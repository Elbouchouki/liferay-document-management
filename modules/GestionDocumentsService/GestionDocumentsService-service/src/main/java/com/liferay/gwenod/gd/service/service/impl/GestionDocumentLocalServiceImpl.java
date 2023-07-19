/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.gwenod.gd.service.service.impl;

import com.liferay.document.library.kernel.model.*;
import com.liferay.document.library.kernel.service.*;
import com.liferay.dynamic.data.mapping.kernel.*;
import com.liferay.gwenod.gd.service.service.base.GestionDocumentLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.vulcan.multipart.BinaryFile;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author Elbouchouki Ahmed
 */
@Component(
        property = "model.class.name=com.liferay.gwenod.gd.service.model.GestionDocument",
        service = AopService.class
)
public class GestionDocumentLocalServiceImpl
        extends GestionDocumentLocalServiceBaseImpl {
    public com.liferay.document.library.kernel.model.DLFileEntry createDocument(
            String filename,
            String title,
            String description,
            String changeLog,
            BinaryFile file,
            String type,
            String city,
            String address,
            List<String> tags,
            ServiceContext serviceContext
    ) throws PortalException, IOException {

        com.liferay.document.library.kernel.model.DLFileEntryType dlFileEntryType = getFileEntryType(type, serviceContext);

        Folder folder = addFolderRecursive(serviceContext);

        String _filename = String.format("%s_%s", type, filename.replace(" ", "_"));

        String _externalReferenceCode = UUID.randomUUID().toString();
        long _userId = serviceContext.getUserId();
        long _groupId = serviceContext.getScopeGroupId();
        long _repositoryId = _groupId;
        long _folderId = folder.getFolderId();
        String _sourceFileName = _filename;
        String _mimeType = file.getContentType();
        String _title = title;
        String _urlTitle = _filename.toLowerCase();
        String _description = description;
        String _changeLog = changeLog;

        InputStream _inputStream = file.getInputStream();
        long _size = file.getSize();


        com.liferay.portal.kernel.repository.model.FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(
                _externalReferenceCode, _userId, _repositoryId, _folderId,
                _sourceFileName, _mimeType, _inputStream.readAllBytes(),
                null, null, serviceContext
        );

        Map<String, DDMFormValues> _ddmFormValuesMap = getMappedValues(
                dlFileEntryType,
                type,
                Optional.ofNullable(city),
                Optional.ofNullable(address)
        );

        return DLFileEntryLocalServiceUtil.updateFileEntry(
                _userId, fileEntry.getFileEntryId(), _sourceFileName,
                _mimeType, _title, _urlTitle, _description,
                _changeLog,
                com.liferay.document.library.kernel.model.DLVersionNumberIncrease.NONE,
                dlFileEntryType.getFileEntryTypeId(),
                _ddmFormValuesMap,
                null, null, _size,
                null, null,
                serviceContext
        );
    }

    public com.liferay.document.library.kernel.model.DLFileEntry updateDocument(
            Long documentId,
            String filename,
            String title,
            String description,
            String changeLog,
            BinaryFile file,
            String city,
            String address,
            List<String> tags,
            ServiceContext serviceContext
    ) throws PortalException, IOException {

        com.liferay.document.library.kernel.model.DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(documentId);

        long _userId = serviceContext.getUserId();
        long _fileEntryId = dlFileEntry.getFileEntryId();
        String _filename = String.format("%s_%s", dlFileEntry.getDLFileEntryType().getName(Locale.getDefault()), filename.replace(" ", "_"));
        String _sourceFileName = _filename;
        String _mimeType = file.getContentType();
        String _title = title;
        String _urlTitle = _filename.toLowerCase();
        String _description = description;
        String _changeLog = changeLog;
        long _fileEntryTypeId = dlFileEntry.getFileEntryTypeId();

        Map<String, DDMFormValues> _ddmFormValuesMap = getMappedValues(
                dlFileEntry.getDLFileEntryType(),
                dlFileEntry.getDLFileEntryType().getName(Locale.getDefault()),
                Optional.ofNullable(city),
                Optional.ofNullable(address)
        );

        InputStream _inputStream = file.getInputStream();
        long _size = file.getSize();

        DLAppLocalServiceUtil.updateFileEntry(
                _userId, _fileEntryId, _sourceFileName, _mimeType,
                _title, _urlTitle, _description, _changeLog, DLVersionNumberIncrease.MAJOR,
                _inputStream.readAllBytes(), null, null, serviceContext
        );

        return DLFileEntryLocalServiceUtil.updateFileEntry(
                _userId, _fileEntryId, _sourceFileName, _mimeType,
                _title, _urlTitle, _description, _changeLog, DLVersionNumberIncrease.NONE,
                _fileEntryTypeId, _ddmFormValuesMap, null, null, _size,
                null, null,
                serviceContext

        );
    }

    public com.liferay.document.library.kernel.model.DLFileEntry getDocument(Long documentId) throws PortalException {
        return DLFileEntryLocalServiceUtil.getFileEntry(documentId);
    }


    public List<com.liferay.document.library.kernel.model.DLFileVersion> getDocumentHistory(Long documentId) throws PortalException {
        DLFileEntryLocalServiceUtil.getFileEntry(documentId);
        return DLFileVersionLocalServiceUtil.getFileVersions(documentId, 0);
    }


    public List<Document> getDocuments(
            String title,
            String[] tags,
            ServiceContext serviceContext
    ) throws PortalException {

        SearchContext searchContext = new SearchContext();
        searchContext.setOwnerUserId(serviceContext.getUserId());
        searchContext.setKeywords(title);
        searchContext.setAssetTagNames(tags);

        Hits search = DLAppServiceUtil.search(
                serviceContext.getScopeGroupId(),
                searchContext
        );

        return search.toList();
    }

    public void deleteDocument(Long documentId) throws PortalException {
        DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(documentId);
        DLAppServiceUtil.deleteFileEntry(documentId);
        deleteFolder(fileEntry.getFolder());
    }

    private void deleteFolder(DLFolder folder) throws PortalException {
        if (folder == null || folder.getFolderId() == DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) {
            return;
        }

        List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(folder.getGroupId(), folder.getFolderId());
        List<Folder> folders = DLAppServiceUtil.getFolders(folder.getGroupId(), folder.getFolderId());

        int size = fileEntries.size() + folders.size();

        if (size == 0) {
            DLAppServiceUtil.deleteFolder(folder.getFolderId());
            deleteFolder(folder.getParentFolder());
        }
    }


    private Map<String, com.liferay.dynamic.data.mapping.kernel.DDMFormValues> getMappedValues(
            DLFileEntryType dlFileEntryType,
            String type,
            Optional<String> city,
            Optional<String> address
    ) {
        Map<String, String> fieldRefs = new HashMap<>();
        fieldRefs.put(type.toUpperCase() + "_TextCity", city.orElse(""));
        fieldRefs.put(type.toUpperCase() + "_TextAddress", address.orElse(""));

        Map<String, com.liferay.dynamic.data.mapping.kernel.DDMFormValues> values = new HashMap<>();
        List<com.liferay.dynamic.data.mapping.kernel.DDMStructure> ddmStructures = dlFileEntryType.getDDMStructures();
        DDMStructure ddmStructure = ddmStructures.get(0);
        List<com.liferay.dynamic.data.mapping.kernel.DDMFormField> ddmFormFields = ddmStructure.getDDMFormFields(false);

        com.liferay.dynamic.data.mapping.kernel.DDMFormValues ddmFormValues = new com.liferay.dynamic.data.mapping.kernel.DDMFormValues(ddmStructure.getDDMForm());
        ddmFormValues.setDefaultLocale(Locale.getDefault());
        ddmFormValues.setAvailableLocales(Collections.singleton(Locale.getDefault()));

        for (com.liferay.dynamic.data.mapping.kernel.DDMFormField ddmFormField : ddmFormFields) {
            com.liferay.dynamic.data.mapping.kernel.DDMFormFieldValue ddmFormFieldValue = new com.liferay.dynamic.data.mapping.kernel.DDMFormFieldValue();
            ddmFormFieldValue.setFieldReference(ddmFormField.getFieldReference());
            com.liferay.dynamic.data.mapping.kernel.LocalizedValue localizedValue = new com.liferay.dynamic.data.mapping.kernel.LocalizedValue();
            localizedValue.addString(Locale.getDefault(), fieldRefs.get(ddmFormField.getFieldReference()));
            ddmFormFieldValue.setValue(localizedValue);
            ddmFormFieldValue.setName(ddmFormField.getName());

            ddmFormValues.addDDMFormFieldValue(ddmFormFieldValue);
        }

        values.put(ddmStructure.getStructureKey(), ddmFormValues);
        return values;
    }

    public boolean fileTypeExists(String type, ServiceContext serviceContext) {

        try {
            getFileEntryType(type, serviceContext);
            return true;
        } catch (PortalException e) {
            return false;
        }
    }

    private com.liferay.document.library.kernel.model.DLFileEntryType getFileEntryType(String type, ServiceContext serviceContext) throws PortalException {
        List<com.liferay.document.library.kernel.model.DLFileEntryType> fileEntryTypes = DLFileEntryTypeServiceUtil.getFileEntryTypes(
                PortalUtil.getCurrentAndAncestorSiteGroupIds(
                        serviceContext.getScopeGroupId()
                )
        );
        return fileEntryTypes.stream()
                .filter(fileEntryType -> fileEntryType.getName(Locale.getDefault()).equals(type))
                .findFirst()
                .orElseThrow(
                        () -> new PortalException("File Type not found")
                );
    }


    private Folder addFolderRecursive(ServiceContext serviceContext) throws PortalException {
        long parent = com.liferay.document.library.kernel.model.DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
        String parentPath = String.format("%d/%d/%d/%d",
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH) + 1,
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH),
                serviceContext.getUserId()
        );
        String[] folders = parentPath.split("/");
        Folder folder = null;
        for (String folderName : folders) {
            folder = this.addFolder(folderName, parent, serviceContext);
            parent = folder.getFolderId();
        }
        return folder;
    }

    private Folder addFolder(String folderName, long parent, ServiceContext serviceContext) throws PortalException {
        try {
            return DLAppServiceUtil.addFolder(
                    serviceContext.getUuid(),
                    serviceContext.getScopeGroupId(),
                    parent,
                    folderName,
                    folderName,
                    serviceContext
            );
        } catch (PortalException e) {
            return DLAppServiceUtil.getFolder(
                    serviceContext.getScopeGroupId(),
                    parent,
                    folderName
            );
        }
    }
}