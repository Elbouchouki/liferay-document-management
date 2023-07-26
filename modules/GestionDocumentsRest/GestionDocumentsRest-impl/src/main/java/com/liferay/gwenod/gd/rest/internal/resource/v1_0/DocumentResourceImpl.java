package com.liferay.gwenod.gd.rest.internal.resource.v1_0;

import com.liferay.document.library.kernel.exception.DuplicateFileEntryException;
import com.liferay.document.library.kernel.exception.NoSuchFileEntryException;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFileVersion;
import com.liferay.gwenod.gd.rest.dto.v1_0.Document;
import com.liferay.gwenod.gd.rest.dto.v1_0.ErrorResponse;
import com.liferay.gwenod.gd.rest.resource.v1_0.DocumentResource;

import com.liferay.gwenod.gd.service.service.GestionDocumentLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.vulcan.multipart.BinaryFile;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.ws.rs.core.Response;
import java.util.*;

/**
 * @author Elbouchouki Ahmed
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v1_0/document.properties",
        scope = ServiceScope.PROTOTYPE, service = DocumentResource.class
)
public class DocumentResourceImpl extends BaseDocumentResourceImpl {
    private static final com.liferay.portal.kernel.log.Log _log =
            LogFactoryUtil.getLog(DocumentResourceImpl.class);

    @Reference
    private GestionDocumentLocalService gestionDocumentLocalService;

    @Override
    public Response createDocument(MultipartBody multipartBody) {
        _log.debug("createDocument");
        DocumentDto documentDto;
        ServiceContext serviceContext = _ServiceContextBuilder();
        try {
            documentDto = fromMultipartBody(multipartBody, serviceContext);
        } catch (PortalException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(
                    new ErrorResponse() {{
                        setCode(Response.Status.BAD_REQUEST.getStatusCode());
                        setMessage(e.getMessage());
                    }}
            ).build();
        }

        Response.ResponseBuilder responseBuilder = Response.ok();

        try {
            DLFileEntry document = gestionDocumentLocalService.createDocument(
                    documentDto.getFilename(),
                    documentDto.getTitle(),
                    documentDto.getDescription(),
                    documentDto.getChangeLog(),
                    documentDto.getFile(),
                    documentDto.getType(),
                    documentDto.getCity(),
                    documentDto.getAddress(),
                    documentDto.getTags(),
                    serviceContext
            );

            responseBuilder.entity(
                    toDocument(document)
            );
        } catch (DuplicateFileEntryException e) {
            responseBuilder.status(Response.Status.CONFLICT);
            responseBuilder.entity(
                    new ErrorResponse() {{
                        setCode(Response.Status.CONFLICT.getStatusCode());
                        setMessage(e.getMessage());
                    }}
            );
        } catch (Exception e) {
            String exceptionClass = e.getClass().getSimpleName();
            _log.error("exceptionClass = " + exceptionClass);
            responseBuilder.status(Response.Status.INTERNAL_SERVER_ERROR);
            responseBuilder.entity(
                    new ErrorResponse() {{
                        setCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
                        setMessage(e.getMessage());
                    }}
            );
        }
        return responseBuilder.build();
    }


    @Override
    public Response deleteDocument(Long documentId) {
        _log.debug("deleteDocument");
        Response.ResponseBuilder responseBuilder = Response.ok();

        try {
            gestionDocumentLocalService.deleteDocument(documentId, _ServiceContextBuilder());
        } catch (NoSuchFileEntryException e) {
            responseBuilder.status(Response.Status.NOT_FOUND);
            responseBuilder.entity(
                    new ErrorResponse() {{
                        setCode(Response.Status.NOT_FOUND.getStatusCode());
                        setMessage(e.getMessage());
                    }}
            );
        } catch (Exception e) {
            String exceptionClass = e.getClass().getSimpleName();
            _log.error("exceptionClass = " + exceptionClass);
            responseBuilder.status(Response.Status.INTERNAL_SERVER_ERROR);
            responseBuilder.entity(
                    new ErrorResponse() {{
                        setCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
                        setMessage(e.getMessage());
                    }}
            );
        }

        return responseBuilder.build();
    }

    @Override
    public Object getDocument(Long documentId) {
        _log.debug("getDocument");
        Response.ResponseBuilder responseBuilder = Response.ok();
        try {
            DLFileEntry document = gestionDocumentLocalService.getDocument(documentId);
            responseBuilder.entity(
                    toDocument(document)
            );
        } catch (NoSuchFileEntryException e) {
            responseBuilder.status(Response.Status.NOT_FOUND);
            responseBuilder.entity(
                    new ErrorResponse() {{
                        setCode(Response.Status.NOT_FOUND.getStatusCode());
                        setMessage(e.getMessage());
                    }}
            );
        } catch (Exception e) {
            String exceptionClass = e.getClass().getSimpleName();
            _log.error("exceptionClass = " + exceptionClass);
            responseBuilder.status(Response.Status.INTERNAL_SERVER_ERROR);
            responseBuilder.entity(
                    new ErrorResponse() {{
                        setCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
                        setMessage(e.getMessage());
                    }}
            );
        }
        return responseBuilder.build();
    }

    @Override
    public Response updateDocument(
            Long documentId, MultipartBody multipartBody
    ) {
        _log.debug("updateDocument");
        DocumentDto documentDto;
        ServiceContext serviceContext = _ServiceContextBuilder();
        try {
            documentDto = fromMultipartBody(multipartBody, serviceContext);
        } catch (PortalException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(
                    new ErrorResponse() {{
                        setCode(Response.Status.BAD_REQUEST.getStatusCode());
                        setMessage(e.getMessage());
                    }}
            ).build();
        }

        Response.ResponseBuilder responseBuilder = Response.ok();

        try {
            DLFileEntry document = gestionDocumentLocalService.updateDocument(
                    documentId,
                    documentDto.getFilename(),
                    documentDto.getTitle(),
                    documentDto.getDescription(),
                    documentDto.getChangeLog(),
                    documentDto.getFile(),
                    documentDto.getCity(),
                    documentDto.getAddress(),
                    documentDto.getTags(),
                    serviceContext
            );
            responseBuilder.entity(
                    toDocument(document)
            );
        } catch (NoSuchFileEntryException e) {
            responseBuilder.status(Response.Status.NOT_FOUND);
            responseBuilder.entity(
                    new ErrorResponse() {{
                        setCode(Response.Status.NOT_FOUND.getStatusCode());
                        setMessage(e.getMessage());
                    }}
            );
        } catch (DuplicateFileEntryException e) {
            responseBuilder.status(Response.Status.CONFLICT);
            responseBuilder.entity(
                    new ErrorResponse() {{
                        setCode(Response.Status.CONFLICT.getStatusCode());
                        setMessage(e.getMessage());
                    }}
            );
        } catch (Exception e) {
            String exceptionClass = e.getClass().getSimpleName();
            _log.error("exceptionClass = " + exceptionClass);
            responseBuilder.status(Response.Status.INTERNAL_SERVER_ERROR);
            responseBuilder.entity(
                    new ErrorResponse() {{
                        setCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
                        setMessage(e.getMessage());
                    }}
            );
        }


        return responseBuilder.build();
    }

    @Override
    public Object getDocumentHistory(Long documentId) throws Exception {
        _log.debug("getDocumentHistory");
        Response.ResponseBuilder responseBuilder = Response.ok();
        try {
            responseBuilder.entity(
                    toDocument(
                            gestionDocumentLocalService.getDocumentHistory(documentId)
                    )
            );
        } catch (NoSuchFileEntryException e) {
            responseBuilder.status(Response.Status.NOT_FOUND);
            responseBuilder.entity(
                    new ErrorResponse() {{
                        setCode(Response.Status.NOT_FOUND.getStatusCode());
                        setMessage(e.getMessage());
                    }}
            );
        } catch (Exception e) {
            String exceptionClass = e.getClass().getSimpleName();
            _log.error("exceptionClass = " + exceptionClass);
            responseBuilder.status(Response.Status.INTERNAL_SERVER_ERROR);
            responseBuilder.entity(
                    new ErrorResponse() {{
                        setCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
                        setMessage(e.getMessage());
                    }}
            );
        }
        return responseBuilder.build();
    }

    @Override
    public Object getDocuments(String title, String[] tags) throws Exception {
        _log.debug("getDocuments");
        return Response.ok().entity(
                fromSearchToDocument(
                        gestionDocumentLocalService.getDocuments(
                                title,
                                tags,
                                _ServiceContextBuilder()
                        )
                )
        ).build();
    }

    private final long GROUP_ID = 20119;

    private ServiceContext _ServiceContextBuilder() {
        User user = contextUser;
        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setUserId(user.getUserId());
        serviceContext.setCompanyId(user.getCompanyId());
        serviceContext.setScopeGroupId(GROUP_ID);
        serviceContext.setRequest(contextHttpServletRequest);
        serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);
        serviceContext.setAddGroupPermissions(true);
        serviceContext.setAddGuestPermissions(true);
        return serviceContext;
    }

    private DocumentDto fromMultipartBody(MultipartBody multipartBody, ServiceContext serviceContext) throws PortalException {
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
        String type = multipartBody.getValueAsString("type");

        if (file == null) {
            throw new PortalException("File is not present");
        }

        if (type != null && !type.isEmpty() && !gestionDocumentLocalService.fileTypeExists(type, serviceContext)) {
            throw new PortalException("File Type does not exist");
        }

        if (filename == null || filename.isEmpty()) {
            throw new PortalException("Filename is not present or empty");
        }

        return new DocumentDto(
                file, filename, title, description, city, address, changeLog, tags, type
        );
    }

    private List<Document> fromSearchToDocument(List<com.liferay.portal.kernel.search.Document> documents) {
        List<Document> documentDtos = new ArrayList<>();
        for (com.liferay.portal.kernel.search.Document document : documents) {
            Document documentDto = new Document();
            documentDto.setFileEntryId(Long.valueOf(document.get(Field.ENTRY_CLASS_PK)));
            documentDto.setDescription(document.get(Field.DESCRIPTION));
            documentDto.setTitle(document.get(Field.TITLE));
            documentDtos.add(documentDto);
        }
        return documentDtos;
    }


    private List<Document> toDocument(List<DLFileVersion> dlFileEntries) throws PortalException {
        List<Document> documents = new ArrayList<>();
        for (DLFileVersion dlFileEntry : dlFileEntries) {
            documents.add(toDocument(dlFileEntry));
        }
        return documents;
    }

    private Document toDocument(DLFileVersion dlFileVersion) throws PortalException {
        Document documentDto = new Document();
        documentDto.setFileEntryId(dlFileVersion.getFileEntryId());
        documentDto.setFileName(dlFileVersion.getFileName());
        documentDto.setDescription(dlFileVersion.getDescription());
        documentDto.setFolderId(dlFileVersion.getFolderId());
        documentDto.setTitle(dlFileVersion.getTitle());
        documentDto.setRepositoryId(dlFileVersion.getRepositoryId());
        documentDto.setVersion(dlFileVersion.getVersion());
        documentDto.setMimeType(dlFileVersion.getMimeType());
        documentDto.setGroupId(dlFileVersion.getGroupId());
        documentDto.setUserId(dlFileVersion.getUserId());
        documentDto.setChangeLog(dlFileVersion.getChangeLog());
        documentDto.setFileEntryTypeId(dlFileVersion.getFileEntryTypeId());
        if (dlFileVersion.getDLFileEntryType() != null) {
            documentDto.setFileEntryTypeIdName(dlFileVersion.getDLFileEntryType().getName(Locale.US));
        }
        return documentDto;
    }

    private Document toDocument(DLFileEntry document) throws PortalException {
        Document documentDto = new Document();
        documentDto.setFileEntryId(document.getFileEntryId());
        documentDto.setFileName(document.getFileName());
        documentDto.setDescription(document.getDescription());
        documentDto.setFolderId(document.getFolderId());
        documentDto.setName(document.getName());
        documentDto.setTitle(document.getTitle());
        documentDto.setRepositoryId(document.getRepositoryId());
        /*documentDto.setAddress(document.getAddress());  */
        /*documentDto.setChangeLog(document.getChangeLog());*/
        /*documentDto.setCity(document.getCity());*/
        documentDto.setVersion(document.getVersion());
        documentDto.setFileEntryTypeId(document.getFileEntryTypeId());
        if (document.getDLFileEntryType() != null) {
            documentDto.setFileEntryTypeIdName(document.getDLFileEntryType().getName(Locale.US));
        }
        documentDto.setMimeType(document.getMimeType());
        documentDto.setGroupId(document.getGroupId());
        documentDto.setUserId(document.getUserId());
        documentDto.setCompanyId(document.getCompanyId());
        documentDto.setCreateDate(document.getCreateDate());
        documentDto.setModifiedDate(document.getModifiedDate());

        return documentDto;
    }

    private class DocumentDto {
        private BinaryFile file;
        private String filename;
        private String title;
        private String description;
        private String city;
        private String address;
        private String changeLog;
        private List<String> tags;
        private String type;

        public DocumentDto(BinaryFile file, String filename, String title, String description, String city, String address, String changeLog, List<String> tags, String type) {
            this.file = file;
            this.filename = filename;
            this.title = title;
            this.description = description;
            this.city = city;
            this.address = address;
            this.changeLog = changeLog;
            this.tags = tags;
            this.type = type;
        }

        public BinaryFile getFile() {
            return file;
        }

        public String getFilename() {
            return filename;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public String getCity() {
            return city;
        }

        public String getAddress() {
            return address;
        }

        public String getChangeLog() {
            return changeLog;
        }

        public List<String> getTags() {
            return tags;
        }

        public String getType() {
            return type;
        }
    }
}