package com.liferay.gwenod.rest.internal.resource.v1_0;

import com.liferay.gwenod.gestiondocuments.service.model.DocumentHistory;
import com.liferay.gwenod.gestiondocuments.service.service.DocumentLocalService;
import com.liferay.gwenod.rest.dto.v1_0.Document;
import com.liferay.gwenod.rest.dto.v1_0.Error;
import com.liferay.gwenod.rest.dto.v1_0.File;
import com.liferay.gwenod.rest.resource.v1_0.DocumentResource;

import com.liferay.portal.kernel.dao.jdbc.OutputBlob;
import com.liferay.portal.kernel.model.Resource;
import com.liferay.portal.kernel.service.ResourceLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.servlet.ResourceUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.vulcan.multipart.BinaryFile;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.portlet.ResourceResponse;
import javax.ws.rs.core.Response;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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


    @Override
    public Response createDocument(MultipartBody multipartBody) throws Exception {


        BinaryFile file = multipartBody.getBinaryFile("file");

        String filename = multipartBody.getValueAsString("filename");
        if (filename == null || filename.isEmpty()) {
            filename = file.getFileName();
        } else {
            filename = filename + "." + file.getFileName().split("\\.")[1];
            System.out.println("filename: " + filename);
        }

        String title = multipartBody.getValueAsString("title");
        String description = multipartBody.getValueAsString("description");
        String city = multipartBody.getValueAsString("city");
        String address = multipartBody.getValueAsString("address");
        List<String> tags = Arrays.asList(
                multipartBody.getValueAsString("tags").split(",")
        );
        String type = multipartBody.getValueAsString("type");

        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setUserId(contextUser.getUserId());
        serviceContext.setScopeGroupId(contextUser.getGroupId());
        serviceContext.setCompanyId(contextUser.getCompanyId());
        serviceContext.setRequest(contextHttpServletRequest);

        Response.ResponseBuilder responseBuilder = Response.ok();

        try {
            com.liferay.gwenod.gestiondocuments.service.model.Document document = documentLocalService.addDocument(
                    file.getInputStream(),
                    filename,
                    title,
                    tags,
                    city,
                    address,
                    type,
                    description,
                    serviceContext
            );
            responseBuilder.entity(toResponse(document));
        } catch (Exception e) {
            e.printStackTrace();
            responseBuilder = Response.serverError();
            Error error = new Error();
            error.setCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
            error.setMessage(e.getMessage());
            responseBuilder.entity(error);
        }
        return responseBuilder.build();
    }

    @Override
    public Response updateDocument(
            Long documentId,
            MultipartBody multipartBody)
            throws Exception {

        BinaryFile file = multipartBody.getBinaryFile("file");
        String title = multipartBody.getValueAsString("title");
        String description = multipartBody.getValueAsString("description");
        String city = multipartBody.getValueAsString("city");
        String address = multipartBody.getValueAsString("address");
        List<String> tags = Arrays.asList(
                multipartBody.getValueAsString("tags").split(",")
        );

        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setUserId(contextUser.getUserId());
        serviceContext.setScopeGroupId(contextUser.getGroupId());
        serviceContext.setCompanyId(contextUser.getCompanyId());
        serviceContext.setRequest(contextHttpServletRequest);

        Response.ResponseBuilder responseBuilder = Response.ok();
        try {
            com.liferay.gwenod.gestiondocuments.service.model.Document document = documentLocalService.updateDocument(
                    documentId,
                    file.getInputStream(),
                    title,
                    tags,
                    city,
                    address,
                    description,
                    serviceContext
            );
            responseBuilder.entity(toResponse(document));
        } catch (Exception e) {
            e.printStackTrace();
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
        com.liferay.gwenod.gestiondocuments.service.model.Document document = documentLocalService.getDocument(documentId);
        if (document == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok()
                .entity(toResponse(document))
                .build();
    }

    @Override
    public Response getDocumentFile(Long documentId) throws Exception {

        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setUserId(contextUser.getUserId());
        serviceContext.setScopeGroupId(contextUser.getGroupId());
        serviceContext.setCompanyId(contextUser.getCompanyId());
        serviceContext.setRequest(contextHttpServletRequest);
        com.liferay.gwenod.gestiondocuments.service.model.Document document = documentLocalService.getDocument(documentId);

        if (document == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        ByteArrayOutputStream bos = documentLocalService.getDocumentFile(documentId, serviceContext);
        if (bos == null) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        Response.ResponseBuilder responseBuilder = Response.ok();

        responseBuilder.header("Content-Disposition", "attachment; filename=" + document.getFilename());

        responseBuilder.entity(bos.toByteArray());

        return responseBuilder.build();
    }

    @Override
    public Object getDocumentHistory(Long documentId) throws Exception {

        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setUserId(contextUser.getUserId());
        serviceContext.setScopeGroupId(contextUser.getGroupId());
        serviceContext.setCompanyId(contextUser.getCompanyId());
        serviceContext.setRequest(contextHttpServletRequest);
        List<DocumentHistory> documentHistories = documentLocalService.getDocumentHistory(documentId, serviceContext);
        List<com.liferay.gwenod.rest.dto.v1_0.DocumentHistory> response = documentHistories.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return Response.ok()
                .entity(response)
                .build();
    }


    @Override
    public Object getDocuments(String title, String[] tags) throws Exception {
        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setUserId(contextUser.getUserId());
        serviceContext.setScopeGroupId(contextUser.getGroupId());
        serviceContext.setCompanyId(contextUser.getCompanyId());
        serviceContext.setRequest(contextHttpServletRequest);
        List<com.liferay.gwenod.gestiondocuments.service.model.Document> documents = documentLocalService.getDocumentsByTagsAndTitle(title, String.join(",", tags), serviceContext);
        List<Document> response = documents.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return Response.ok()
                .entity(response)
                .build();
    }


    @Override
    public Response deleteDocument(Long documentId) throws Exception {
        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setUserId(contextUser.getUserId());
        serviceContext.setScopeGroupId(contextUser.getGroupId());
        serviceContext.setCompanyId(contextUser.getCompanyId());
        serviceContext.setRequest(contextHttpServletRequest);

        com.liferay.gwenod.gestiondocuments.service.model.Document document = documentLocalService.getDocument(documentId);
        if (document == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Response.ResponseBuilder responseBuilder = Response.ok();

        try {
            documentLocalService.deleteUserDocument(documentId, serviceContext);
            responseBuilder.entity(toResponse(document));
        } catch (Exception e) {
            e.printStackTrace();
            responseBuilder = Response.serverError();
            Error error = new Error();
            error.setCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
            error.setMessage(e.getMessage());
            responseBuilder.entity(error);
        }

        return responseBuilder.build();
    }


    private com.liferay.gwenod.rest.dto.v1_0.DocumentHistory toResponse(DocumentHistory documentHistory) {
        com.liferay.gwenod.rest.dto.v1_0.DocumentHistory response = new com.liferay.gwenod.rest.dto.v1_0.DocumentHistory();
        response.setAddress(documentHistory.getAddress());
        response.setCity(documentHistory.getCity());
        response.setHistoryId(documentHistory.getHistoryId());
        response.setTags(documentHistory.getTags().split(","));
        response.setTitle(documentHistory.getTitle());
        response.setVersionDate(documentHistory.getVersionDate());
        response.setVersionModifier(documentHistory.getVersionModifier());

        File file = new File();
        file.setFileName(documentHistory.getFilename());
        file.setFilePath(documentHistory.getFilepath());
        file.setFileVersion(documentHistory.getFileversion());
        response.setFile(file);

        return response;

    }

    private Document toResponse(com.liferay.gwenod.gestiondocuments.service.model.Document document) {
        Document response = new Document();
        response.setDocumentId(document.getDocumentId());
        response.setAddress(document.getAddress());
        response.setCity(document.getCity());
        response.setCreateDate(document.getCreateDate());
        response.setModifiedDate(document.getModifiedDate());
        response.setTags(document.getTags().split(","));
        response.setTitle(document.getTitle());

        response.setType(() -> {
            if (document.getType().equals("POA")) {
                return Document.Type.POA;
            } else {
                return Document.Type.POI;
            }
        });

        File file = new File();
        file.setFileName(document.getFilename());
        file.setFilePath(document.getFilepath());
        file.setFileVersion(document.getFileversion());
        response.setFile(file);

        return response;
    }
}