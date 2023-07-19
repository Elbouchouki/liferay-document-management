package com.liferay.gwenod.rest.internal.resource.v1_0;

import com.liferay.document.library.kernel.model.*;
import com.liferay.document.library.kernel.service.*;
import com.liferay.document.library.util.DLFileEntryTypeUtil;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldValueValidator;
import com.liferay.dynamic.data.mapping.kernel.DDMFormField;
import com.liferay.dynamic.data.mapping.kernel.DDMFormFieldOptions;
import com.liferay.dynamic.data.mapping.kernel.DDMFormFieldValue;
import com.liferay.dynamic.data.mapping.kernel.DDMFormValues;
import com.liferay.dynamic.data.mapping.model.*;

import com.liferay.dynamic.data.mapping.service.DDMStructureLocalServiceUtil;
import com.liferay.dynamic.data.mapping.validator.DDMFormValidator;
import com.liferay.gwenod.gestiondocuments.service.service.DocumentLocalService;
import com.liferay.gwenod.rest.dto.v1_0.Error;
import com.liferay.gwenod.rest.resource.v1_0.DocumentResource;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.vulcan.multipart.BinaryFile;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.ws.rs.core.Response;
import java.io.*;
import java.util.*;

/**
 * @author elbou
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v1_0/document.properties",
        scope = ServiceScope.PROTOTYPE, service = DocumentResource.class
)
public class DocumentResourceImpl extends BaseDocumentResourceImpl {

    @Reference
    private DocumentLocalService documentLocalService;

    /*            LIFERAY VERSION           */
    private final String DOMAINE = "http://localhost:8080";

    @Override
    public Response createDocument(MultipartBody multipartBody) throws Exception {

        Response.ResponseBuilder responseBuilder = Response.ok();
        try {

            BinaryFile file = multipartBody.getBinaryFile("file");
            String filename = multipartBody.getValueAsString("filename");
            String title = multipartBody.getValueAsString("title");
            String description = multipartBody.getValueAsString("description");
            String city = multipartBody.getValueAsString("city");
            String address = multipartBody.getValueAsString("address");
            List<String> tags = Arrays.asList(
                    multipartBody.getValueAsString("tags").split(",")
            );
            String type = multipartBody.getValueAsString("type");


            ServiceContext serviceContext = getServiceContext();

            DLFileEntryType dlFileEntryType = getFileEntryType(serviceContext);

            Map<String, DDMFormValues> values = getMappedValues(
                    dlFileEntryType,
                    city,
                    null
            );

            /* DDMFormValues ddmFormValues = new DDMFormValues();*/

            /*-----------------------------------------------------------------------*/

            List<String> folderArray = getFolderArray(serviceContext.getUserId());

            Folder folder = addFolderRecursive(folderArray, serviceContext);

            try {

                /*
                    BinaryFile file, String fileName, long folderId,String changeLog,
                    String title, String description,
                    long fileEntryTypeId, Map<String, DDMFormValues> ddmFormValuesMap
                    ServiceContext serviceContext,
                */

                DLFileEntry fileEntry = this.addFile(
                        file,
                        String.format("%s_%s", type, filename.replace(" ", "_")),
                        folder.getFolderId(),
                        "changeLog",
                        title,
                        description,
                        dlFileEntryType.getFileEntryTypeId(),
                        values,
                        serviceContext
                );


                Map<String, Object> resp = new HashMap<>();
                resp.put("fileEntryId", fileEntry.getFileEntryId());
                resp.put("title", title);
                resp.put("description", description);
                resp.put("city", city);
                resp.put("address", address);
                resp.put("tags", tags);
                resp.put("type", type);

                Map<String, Object> fileEntryResp = new HashMap<>();
                fileEntryResp.put("fileName", fileEntry.getFileName());

                fileEntryResp.put("url", String.format("%s/documents/d/guest/%s?download=true", DOMAINE, fileEntry.getFileName()));
                fileEntryResp.put("fileVersion", fileEntry.getVersion());
                resp.put("file", fileEntryResp);

                responseBuilder.entity(resp);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                responseBuilder = Response.status(Response.Status.CONFLICT);
                Error error = new Error();
                error.setCode(Response.Status.CONFLICT.getStatusCode());
                error.setMessage(e.getMessage());
                responseBuilder.entity(error);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            responseBuilder = Response.serverError();
            Error error = new Error();
            error.setCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
            error.setMessage(e.getMessage());
            responseBuilder.entity(error);
        }
        return responseBuilder.build();
    }

    private Map<String, DDMFormValues> getMappedValues(
            DLFileEntryType dlFileEntryType,
            String city,
            String address
    ) {
        Map<String, String> fieldRefs = new HashMap<>();
        String _city = "";
        String _address = "";
        if (city != null) {
            _city = city;
        }
        if (address != null) {
            _address = address;
        }
        fieldRefs.put("DocumentTypeV1_TextCity", _city);
        fieldRefs.put("DocumentTypeV1_TextAddress", _address);

        Map<String, DDMFormValues> values = new HashMap<>();

        List<com.liferay.dynamic.data.mapping.kernel.DDMStructure> ddmStructures
                = dlFileEntryType.getDDMStructures();

        com.liferay.dynamic.data.mapping.kernel.DDMStructure ddmStructure = ddmStructures.get(0);

        List<DDMFormField> ddmFormFields = ddmStructure.getDDMFormFields(
                false
        );
        DDMFormValues ddmFormValues = new DDMFormValues(ddmStructure.getDDMForm());
        ddmFormValues.setDefaultLocale(Locale.getDefault());
        ddmFormValues.setAvailableLocales(Collections.singleton(Locale.getDefault()));

        for (DDMFormField ddmFormField : ddmFormFields) {
            DDMFormFieldValue ddmFormFieldValue = new DDMFormFieldValue();
            ddmFormFieldValue.setFieldReference(ddmFormField.getFieldReference());
            com.liferay.dynamic.data.mapping.kernel.LocalizedValue localizedValue =
                    new com.liferay.dynamic.data.mapping.kernel.LocalizedValue();
            localizedValue.addString(Locale.getDefault(), fieldRefs.get(ddmFormField.getFieldReference()));
            localizedValue.setDefaultLocale(Locale.getDefault());
            ddmFormFieldValue.setValue(localizedValue);
            ddmFormFieldValue.setName(ddmFormField.getName());
            ddmFormValues.addDDMFormFieldValue(ddmFormFieldValue);
        }

        values.put(ddmStructure.getStructureKey(), ddmFormValues);
        return values;
    }

    private final String DOCUMENT_TYPE_NAME = "DocumentTypeV1";

    private DLFileEntryType getFileEntryType(ServiceContext serviceContext) throws PortalException {
        List<DLFileEntryType> fileEntryTypes = DLFileEntryTypeServiceUtil.getFileEntryTypes(
                PortalUtil.getCurrentAndAncestorSiteGroupIds(
                        serviceContext.getScopeGroupId()
                )
        );
        return fileEntryTypes.stream()
                .filter(fileEntryType -> fileEntryType.getName(Locale.US).equals(DOCUMENT_TYPE_NAME))
                .findFirst()
                .orElseThrow(
                        () -> new PortalException("FileEntryType not found")
                );
    }

    @Override
    public Response updateDocument(
            Long documentId,
            MultipartBody multipartBody)
            throws Exception {
        Response.ResponseBuilder responseBuilder = Response.ok();

        try {

            BinaryFile file = multipartBody.getBinaryFile("file");
            String filename = multipartBody.getValueAsString("filename");
            String title = multipartBody.getValueAsString("title");
            String description = multipartBody.getValueAsString("description");
            String city = multipartBody.getValueAsString("city");
            String address = multipartBody.getValueAsString("address");
            String changeLog = multipartBody.getValueAsString("changeLog");
            List<String> tags = Arrays.asList(
                    multipartBody.getValueAsString("tags").split(",")
            );

            // TODO : handle META DATA

            ServiceContext serviceContext = getServiceContext();

            DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(documentId);

            String type = dlFileEntry.getFileName().split("_")[0];

            try {

                FileEntry fileEntry = updateFile(
                        documentId,
                        file,
                        String.format("%s_%s", type, filename.replace(" ", "_")),
                        title,
                        description,
                        changeLog,
                        serviceContext
                );

                Map<String, Object> resp = new HashMap<>();
                resp.put("fileEntryId", fileEntry.getFileEntryId());
                resp.put("title", title);
                resp.put("description", description);
                resp.put("city", city);
                resp.put("address", address);
                resp.put("tags", tags);
                resp.put("type", type);

                Map<String, Object> fileEntryResp = new HashMap<>();
                fileEntryResp.put("fileName", fileEntry.getFileName());

                fileEntryResp.put("url", String.format("%s/documents/d/guest/%s?download=true", DOMAINE, fileEntry.getFileName()));
                fileEntryResp.put("fileVersion", fileEntry.getVersion());
                resp.put("file", fileEntryResp);

                responseBuilder.entity(resp);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                responseBuilder = Response.status(Response.Status.CONFLICT);
                Error error = new Error();
                error.setCode(Response.Status.CONFLICT.getStatusCode());
                error.setMessage(e.getMessage());
                responseBuilder.entity(error);
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
            responseBuilder = Response.serverError();
            Error error = new Error();
            error.setCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
            error.setMessage(e.getMessage());
            responseBuilder.entity(error);
        }

        return responseBuilder.build();
    }

    @Override
    public Object getDocument(Long documentId) throws Exception {
        Response.ResponseBuilder responseBuilder = Response.ok();
        try {
            DLFileEntry file = DLFileEntryLocalServiceUtil.getFileEntry(documentId);
            Map<String, DDMFormValues> ddmFormValuesMap = file.getDDMFormValuesMap(
                    file.getLatestFileVersion(false).getFileVersionId()
            );
            System.out.println("ddmFormValuesMap : " + ddmFormValuesMap.size());
            for (Map.Entry<String, DDMFormValues> entry : ddmFormValuesMap.entrySet()) {
                System.out.println(entry.getKey() + "/" + entry.getValue());
                DDMFormValues values = entry.getValue();
                System.out.println("value : " + values.getDDMFormFieldValues().size());
                List<DDMFormFieldValue> ddmFormFieldValues = values.getDDMFormFieldValues();
                for (DDMFormFieldValue ddmFormFieldValue : ddmFormFieldValues) {
                    System.out.println("ddmFormFieldValue : " + ddmFormFieldValue.getFieldReference());
                    System.out.println("ddmFormFieldValue : " + ddmFormFieldValue.getValue().getString(Locale.getDefault()));
                }
            }

            Map<String, Object> resp = new HashMap<>();
            resp.put("fileEntryId", file.getFileEntryId());
            resp.put("title", file.getTitle());
            resp.put("description", file.getDescription());
            /*resp.put("city", file.getCity());
            resp.put("address", file.getAddress());
            resp.put("tags", file.getTags());
            resp.put("type", file.getType());*/
            Map<String, Object> fileEntryResp = new HashMap<>();
            fileEntryResp.put("fileName", file.getFileName());
            fileEntryResp.put("url", String.format("%s/documents/d/guest/%s?download=true", DOMAINE, file.getFileName()));
            fileEntryResp.put("fileVersion", file.getVersion());
            resp.put("file", fileEntryResp);

            responseBuilder.entity(resp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            responseBuilder = Response.status(Response.Status.NOT_FOUND);
            Error error = new Error();
            error.setCode(Response.Status.NOT_FOUND.getStatusCode());
            error.setMessage(e.getMessage());
            responseBuilder.entity(error);
        }

        return responseBuilder.build();
    }

    @Override
    public Object getDocumentHistory(Long documentId) throws Exception {
        Response.ResponseBuilder responseBuilder = Response.ok();

        try {
            List<DLFileVersion> fileVersions = DLFileVersionLocalServiceUtil.getFileVersions(documentId, 0);

            List<Map<String, Object>> resp = new ArrayList<>();
            for (DLFileVersion fileVersion : fileVersions) {
                Map<String, Object> fileVersionResp = new HashMap<>();
                fileVersionResp.put("description", fileVersion.getDescription());
                fileVersionResp.put("mimeType", fileVersion.getMimeType());
                fileVersionResp.put("status", fileVersion.getStatus());
                fileVersionResp.put("statusByUserId", fileVersion.getStatusByUserId());
                fileVersionResp.put("statusByUserName", fileVersion.getStatusByUserName());
                fileVersionResp.put("statusDate", fileVersion.getStatusDate());
                fileVersionResp.put("createDate", fileVersion.getCreateDate());
                fileVersionResp.put("modifiedDate", fileVersion.getModifiedDate());
                fileVersionResp.put("userId", fileVersion.getUserId());
                fileVersionResp.put("userName", fileVersion.getUserName());
                fileVersionResp.put("extension", fileVersion.getExtension());
                fileVersionResp.put("fileEntryId", fileVersion.getFileEntryId());
                fileVersionResp.put("folderId", fileVersion.getFolderId());
                fileVersionResp.put("changeLog", fileVersion.getChangeLog());
                fileVersionResp.put("extraSettings", fileVersion.getExtraSettings());
                fileVersionResp.put("fileEntryTypeId", fileVersion.getFileEntryTypeId());
                fileVersionResp.put("fileVersionId", fileVersion.getFileVersionId());
                fileVersionResp.put("size", fileVersion.getSize());
                fileVersionResp.put("title", fileVersion.getTitle());
                fileVersionResp.put("uuid", fileVersion.getUuid());
                fileVersionResp.put("version", fileVersion.getVersion());
                resp.add(fileVersionResp);
            }
            responseBuilder.entity(resp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            responseBuilder = Response.status(Response.Status.NOT_FOUND);
            Error error = new Error();
            error.setCode(Response.Status.NOT_FOUND.getStatusCode());
            error.setMessage(e.getMessage());
            responseBuilder.entity(error);
        }

        return responseBuilder.build();
    }


    @Override
    public Object getDocuments(String title, String[] tags) throws Exception {

        Response.ResponseBuilder responseBuilder = Response.ok();

        System.out.println("contextUser.getGroupId(): " + contextUser.getGroupId());
        System.out.println("contextUser.getUserId(): " + contextUser.getUserId());

        ServiceContext serviceContext = getServiceContext();

        SearchContext searchContext = new SearchContext();
        searchContext.setOwnerUserId(serviceContext.getUserId());
        searchContext.setKeywords(title);
        searchContext.setAssetTagNames(tags);


        Hits search = DLAppServiceUtil.search(
                serviceContext.getScopeGroupId(),
                searchContext
        );

        List<com.liferay.portal.kernel.search.Document> list = search.toList();

        List<Map<String, Object>> documentResp = new ArrayList<>();

        for (com.liferay.portal.kernel.search.Document document : list) {
            Map<String, com.liferay.portal.kernel.search.Field> documentMap = document.getFields();
            Map<String, Object> documentMapResp = new HashMap<>();
            documentMapResp.put("fileEntryId", documentMap.get("entryClassPK").getValue());
            documentMapResp.put("description", documentMap.get("description").getValue());
            documentMapResp.put("title", documentMap.get("title").getValue());
            documentResp.add(documentMapResp);
        }

        return responseBuilder
                .entity(documentResp)
                .build();
    }


    @Override
    public Response deleteDocument(Long documentId) throws Exception {
        DLAppServiceUtil.deleteFileEntry(documentId);
        return Response.ok().build();
    }


    private DLFileEntry addFile(
            BinaryFile file, String fileName, long folderId, String changeLog,
            String title, String description,
            long fileEntryTypeId, Map<String, DDMFormValues> ddmFormValuesMap,
            ServiceContext serviceContext
    ) throws PortalException {
        return DLFileEntryLocalServiceUtil.addFileEntry(
                serviceContext.getUuid(),
                serviceContext.getUserId(),
                serviceContext.getScopeGroupId(),
                serviceContext.getScopeGroupId(),
                folderId,
                fileName.toLowerCase(),
                file.getContentType(),
                title,
                fileName.toLowerCase(),
                description,
                changeLog,
                fileEntryTypeId,
                ddmFormValuesMap,
                null,
                file.getInputStream(),
                file.getSize(),
                null,
                null,
                serviceContext
        );
    }


    private FileEntry updateFile(
            long fileEntryId, BinaryFile file, String fileName,
            String title, String description,
            String changeLog,
            ServiceContext serviceContext
    ) throws PortalException, IOException {
        return DLAppServiceUtil.updateFileEntry(
                fileEntryId,
                fileName.toLowerCase(),
                file.getContentType(),
                title,
                fileName,
                description,
                changeLog,
                DLVersionNumberIncrease.MINOR,
                file.getInputStream().readAllBytes(),
                null,
                null,
                serviceContext
        );
    }


    private List<String> getFolderArray(long userId) {
        String parentPath = String.format("%d/%d/%d/%d",
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH) + 1,
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH),
                userId
        );
        return Arrays.asList(parentPath.split("/"));
    }

    private Folder addFolderRecursive(List<String> folders, ServiceContext serviceContext) throws
            PortalException {
        long parent = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
        Folder folder = null;
        for (String folderName : folders) {
            folder = addFolder(folderName, parent, serviceContext);
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
            return DLAppServiceUtil.getFolder(serviceContext.getScopeGroupId(), parent, folderName);
        }
    }

    private ServiceContext getServiceContext() {
        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setUuid(UUID.randomUUID().toString());
        serviceContext.setUserId(contextUser.getUserId());
        serviceContext.setScopeGroupId(20119);
        serviceContext.setCompanyId(contextCompany.getCompanyId());
        serviceContext.setRequest(contextHttpServletRequest);
        serviceContext.setAddGroupPermissions(true);
        return serviceContext;
    }
}