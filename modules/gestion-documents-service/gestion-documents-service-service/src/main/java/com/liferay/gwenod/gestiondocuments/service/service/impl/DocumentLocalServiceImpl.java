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

package com.liferay.gwenod.gestiondocuments.service.service.impl;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalService;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.gwenod.gestiondocuments.service.exception.NoSuchDocumentException;
import com.liferay.gwenod.gestiondocuments.service.model.Document;
import com.liferay.gwenod.gestiondocuments.service.model.DocumentHistory;
import com.liferay.gwenod.gestiondocuments.service.service.base.DocumentLocalServiceBaseImpl;
import com.liferay.info.pagination.Pagination;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.vulcan.multipart.BinaryFile;
import org.osgi.service.component.annotations.Component;

import javax.print.Doc;
import java.awt.print.Pageable;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author elbouchouki
 */
@Component(
        property = "model.class.name=com.liferay.gwenod.gestiondocuments.service.model.Document",
        service = AopService.class
)
public class DocumentLocalServiceImpl extends DocumentLocalServiceBaseImpl {
    private final String absolutePath = System.getProperty("user.dir") + "/resources/document_management/";

    public Document addDocument(
            InputStream file,
            String fileName,
            String title, List<String> tags, String city, String address,
            String type, String description, ServiceContext serviceContext
    ) throws PortalException {

        User user = userLocalService.getUserById(serviceContext.getUserId());
        long groupId = serviceContext.getScopeGroupId();
    
        Date now = new Date();
        Date createDate = serviceContext.getCreateDate(now);
        Date modifiedDate = serviceContext.getModifiedDate(now);

        // format filename to `TYPE_FILENAME`
        fileName = type + "_" + fileName;

        // check existing file
        List<Document> documents = documentPersistence.findByFilename(fileName);

        if (documents.size() > 0) {
            throw new PortalException("File already exists");
        }

        String filePath;
        try {
            filePath = handleFile(file, fileName, user.getUserId(), 1);
        } catch (IOException e) {
            throw new SystemException(e);
        }

        long documentId = counterLocalService.increment();
        Document document = documentPersistence.create(documentId);

        String tagsAsString = String.join(",", tags);

        // audit
        document.setGroupId(groupId);
        document.setCompanyId(user.getCompanyId());
        document.setUserId(user.getUserId());
        document.setUserName(user.getFullName());
        document.setCreateDate(createDate);
        document.setModifiedDate(modifiedDate);
        document.setModifiedBy(user.getUserId());
        document.setExpandoBridgeAttributes(serviceContext);

        // data
        document.setFilepath(filePath);
        document.setFilename(fileName);
        document.setTitle(title);
        document.setFileversion(1);
        document.setTags(tagsAsString);
        document.setCity(city);
        document.setAddress(address);
        document.setType(type);
        document.setDescription(description);

        return documentPersistence.update(document);
    }


    public Document updateDocument(
            long documentId,
            InputStream file,
            String title, List<String> tags, String city, String address,
            String description, ServiceContext serviceContext
    ) throws PortalException {

        Document document = documentPersistence.findByPrimaryKey(documentId);

        // TODO : check if user is allowed to update this document
        if (document == null) {
            throw new NoSuchDocumentException();
        }
        if (document.getUserId() != serviceContext.getUserId()) {
            throw new PortalException("You are not allowed to update this document");
        }

        newDocumentHistory(document);

        if (file != null) {
            String filePath;
            try {
                filePath = handleFile(file, document.getFilename(), document.getUserId(), document.getFileversion() + 1);
            } catch (IOException e) {
                throw new SystemException(e);
            }
            document.setFilename(document.getFilename());
            document.setFileversion(document.getFileversion() + 1);
            document.setFilepath(filePath);
        }

        document.setTitle(title);
        document.setTags(String.join(",", tags));
        document.setCity(city);
        document.setAddress(address);
        document.setDescription(description);
        document.setModifiedDate(serviceContext.getModifiedDate(new Date()));
        document.setModifiedBy(serviceContext.getUserId());
        return documentPersistence.update(document);
    }


    public void newDocumentHistory(Document document) {
        DocumentHistory documentHistory = documentHistoryPersistence.create(document.getDocumentId());
        documentHistory.setDocumentId(document.getDocumentId());
        documentHistory.setFilepath(document.getFilepath());
        documentHistory.setFilename(document.getFilename());
        documentHistory.setTitle(document.getTitle());
        documentHistory.setFileversion(document.getFileversion());
        documentHistory.setTags(document.getTags());
        documentHistory.setHistoryId(counterLocalService.increment());
        documentHistory.setCity(document.getCity());
        documentHistory.setAddress(document.getAddress());
        documentHistory.setDescription(document.getDescription());
        documentHistory.setVersionModifier(document.getModifiedBy());
        documentHistory.setVersionDate(document.getModifiedDate());
        documentHistoryPersistence.update(documentHistory);
    }

    public List<Document> getUserDocuments(ServiceContext serviceContext) {
        return documentPersistence.findByUserId(serviceContext.getUserId());
    }

    public List<DocumentHistory> getDocumentHistory(long documentId, ServiceContext serviceContext) throws NoSuchDocumentException, IllegalAccessException {
        Document document = documentPersistence.fetchByPrimaryKey(documentId);
        if (document == null) {
            throw new NoSuchDocumentException();
        }
        if (document.getUserId() != serviceContext.getUserId()) {
            throw new IllegalAccessException("You are not allowed to access this document");
        }
        return documentHistoryPersistence.findByDocumentId(documentId);
    }

    public List<Document> getDocumentsByTagsAndTitle(String title, String tags, ServiceContext serviceContext) {
        List<String> tagsAsList = Arrays.asList(tags.split(","));
        List<Document> allDocs = documentPersistence.findByUserId(serviceContext.getUserId());

        if (title == null && tagsAsList.size() == 0) return allDocs;

        String search = title == null ? "" : title;

        List<Document> filteredDocs = allDocs.stream()
                .filter(doc -> doc.getTitle().toLowerCase().contains(search.toLowerCase()))
                .collect(Collectors.toList());

        if (tagsAsList.size() > 0) {
            filteredDocs = filteredDocs.stream()
                    .filter(doc -> tagsAsList.stream().anyMatch(tag -> doc.getTags().contains(tag)))
                    .collect(Collectors.toList());
        }

        return filteredDocs;
    }

    public ByteArrayOutputStream getDocumentFile(long documentId, ServiceContext serviceContext) throws NoSuchDocumentException, IllegalAccessException {
        Document document = documentPersistence.fetchByPrimaryKey(documentId);
        if (document == null) {
            throw new NoSuchDocumentException();
        }
        if (document.getUserId() != serviceContext.getUserId()) {
            throw new IllegalAccessException("You are not allowed to access this document");
        }
        String filePath = absolutePath + document.getFilepath();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            FileInputStream fis = new FileInputStream(filePath);
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = fis.read(buf)) != -1; ) {
                bos.write(buf, 0, readNum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bos;
    }


    public Document deleteUserDocument(long documentId, ServiceContext serviceContext) throws Exception {
        Document document = documentPersistence.findByPrimaryKey(documentId);
        if (document == null) {
            throw new NoSuchDocumentException();
        }
        if (document.getUserId() != serviceContext.getUserId()) {
            throw new IllegalAccessException("You are not allowed to delete this document");
        }

        List<DocumentHistory> documentHistories = documentHistoryPersistence.findByDocumentId(documentId);

        for (DocumentHistory documentHistory : documentHistories) {
            //remove file
            String filename = absolutePath + documentHistory.getFilepath();
            File file = new File(filename);
            Files.deleteIfExists(file.toPath());
            documentHistoryPersistence.remove(documentHistory);
        }

        File file = new File(absolutePath + document.getFilepath());
        Files.deleteIfExists(file.toPath());

        return documentPersistence.remove(documentId);
    }

    private String handleFile(InputStream file, String fileName, long userId, long version) throws IOException {
        String parentPath = String.format("%d/%d/%d/%d/v%d/",
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH) + 1,
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH),
                userId,
                version
        );
        File parentDir = new File(absolutePath + parentPath);
        if (!parentDir.exists() && !parentDir.mkdirs()) {
            throw new IllegalStateException("Couldn't create dir: " + parentDir);
        }
        String filename = parentDir.getAbsolutePath() + "/" + fileName;
        File _file = new File(filename);
        try {
            Files.copy(file, _file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parentPath + fileName;
    }

    // FOR DEV ONLY
    public void deleteAllDocuments() {
        documentPersistence.removeAll();
    }

}