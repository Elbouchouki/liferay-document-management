package com.liferay.gwenod.rest.client.resource.v1_0;

import com.liferay.gwenod.rest.client.dto.v1_0.Document;
import com.liferay.gwenod.rest.client.dto.v1_0.File;
import com.liferay.gwenod.rest.client.http.HttpInvoker;
import com.liferay.gwenod.rest.client.problem.Problem;
import com.liferay.gwenod.rest.client.serdes.v1_0.DocumentSerDes;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Generated;

/**
 * @author elbou
 * @generated
 */
@Generated("")
public interface DocumentResource {

    public static Builder builder() {
        return new Builder();
    }

    public void createDocument(
            Document document, Map<String, File> multipartFiles)
            throws Exception;

    public HttpInvoker.HttpResponse createDocumentHttpResponse(
            Document document, Map<String, File> multipartFiles)
            throws Exception;

    public void deleteDocument(Long documentId) throws Exception;

    public HttpInvoker.HttpResponse deleteDocumentHttpResponse(Long documentId)
            throws Exception;

    public void deleteDocumentBatch(String callbackURL, Object object)
            throws Exception;

    public HttpInvoker.HttpResponse deleteDocumentBatchHttpResponse(
            String callbackURL, Object object)
            throws Exception;

    public Object getDocument(Long documentId) throws Exception;

    public HttpInvoker.HttpResponse getDocumentHttpResponse(Long documentId)
            throws Exception;

    public void updateDocument(
            Long documentId, Document document,
            Map<String, File> multipartFiles)
            throws Exception;

    public HttpInvoker.HttpResponse updateDocumentHttpResponse(
            Long documentId, Document document,
            Map<String, File> multipartFiles)
            throws Exception;

    public Object getDocumentHistory(Long documentId) throws Exception;

    public HttpInvoker.HttpResponse getDocumentHistoryHttpResponse(
            Long documentId)
            throws Exception;

    public Object getDocuments(String title, String[] tags) throws Exception;

    public HttpInvoker.HttpResponse getDocumentsHttpResponse(
            String title, String[] tags)
            throws Exception;

    public static class Builder {

        public Builder authentication(String login, String password) {
            _login = login;
            _password = password;

            return this;
        }

        public DocumentResource build() {
            return new DocumentResourceImpl(this);
        }

        public Builder contextPath(String contextPath) {
            _contextPath = contextPath;

            return this;
        }

        public Builder endpoint(String host, int port, String scheme) {
            _host = host;
            _port = port;
            _scheme = scheme;

            return this;
        }

        public Builder header(String key, String value) {
            _headers.put(key, value);

            return this;
        }

        public Builder locale(Locale locale) {
            _locale = locale;

            return this;
        }

        public Builder parameter(String key, String value) {
            _parameters.put(key, value);

            return this;
        }

        public Builder parameters(String... parameters) {
            if ((parameters.length % 2) != 0) {
                throw new IllegalArgumentException(
                        "Parameters length is not an even number");
            }

            for (int i = 0; i < parameters.length; i += 2) {
                String parameterName = String.valueOf(parameters[i]);
                String parameterValue = String.valueOf(parameters[i + 1]);

                _parameters.put(parameterName, parameterValue);
            }

            return this;
        }

        private Builder() {
        }

        private String _contextPath = "";
        private Map<String, String> _headers = new LinkedHashMap<>();
        private String _host = "localhost";
        private Locale _locale;
        private String _login = "";
        private String _password = "";
        private Map<String, String> _parameters = new LinkedHashMap<>();
        private int _port = 8080;
        private String _scheme = "http";

    }

    public static class DocumentResourceImpl implements DocumentResource {

        public void createDocument(
                Document document, Map<String, File> multipartFiles)
                throws Exception {

            HttpInvoker.HttpResponse httpResponse = createDocumentHttpResponse(
                    document, multipartFiles);

            String content = httpResponse.getContent();

            if ((httpResponse.getStatusCode() / 100) != 2) {
                _logger.log(
                        Level.WARNING,
                        "Unable to process HTTP response content: " + content);
                _logger.log(
                        Level.WARNING,
                        "HTTP response message: " + httpResponse.getMessage());
                _logger.log(
                        Level.WARNING,
                        "HTTP response status code: " +
                                httpResponse.getStatusCode());

                throw new Problem.ProblemException(Problem.toDTO(content));
            } else {
                _logger.fine("HTTP response content: " + content);
                _logger.fine(
                        "HTTP response message: " + httpResponse.getMessage());
                _logger.fine(
                        "HTTP response status code: " +
                                httpResponse.getStatusCode());
            }
        }

        public HttpInvoker.HttpResponse createDocumentHttpResponse(
                Document document, Map<String, File> multipartFiles)
                throws Exception {

            HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

            httpInvoker.multipart();

            httpInvoker.part("document", DocumentSerDes.toJSON(document));

            for (Map.Entry<String, File> entry : multipartFiles.entrySet()) {
                httpInvoker.part(entry.getKey(), String.valueOf(entry.getValue()));
            }

            if (_builder._locale != null) {
                httpInvoker.header(
                        "Accept-Language", _builder._locale.toLanguageTag());
            }

            for (Map.Entry<String, String> entry :
                    _builder._headers.entrySet()) {

                httpInvoker.header(entry.getKey(), entry.getValue());
            }

            for (Map.Entry<String, String> entry :
                    _builder._parameters.entrySet()) {

                httpInvoker.parameter(entry.getKey(), entry.getValue());
            }

            httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

            httpInvoker.path(
                    _builder._scheme + "://" + _builder._host + ":" +
                            _builder._port + _builder._contextPath +
                            "/o/gestion-documents-rest/v1.0/document");

            httpInvoker.userNameAndPassword(
                    _builder._login + ":" + _builder._password);

            return httpInvoker.invoke();
        }

        public void deleteDocument(Long documentId) throws Exception {
            HttpInvoker.HttpResponse httpResponse = deleteDocumentHttpResponse(
                    documentId);

            String content = httpResponse.getContent();

            if ((httpResponse.getStatusCode() / 100) != 2) {
                _logger.log(
                        Level.WARNING,
                        "Unable to process HTTP response content: " + content);
                _logger.log(
                        Level.WARNING,
                        "HTTP response message: " + httpResponse.getMessage());
                _logger.log(
                        Level.WARNING,
                        "HTTP response status code: " +
                                httpResponse.getStatusCode());

                throw new Problem.ProblemException(Problem.toDTO(content));
            } else {
                _logger.fine("HTTP response content: " + content);
                _logger.fine(
                        "HTTP response message: " + httpResponse.getMessage());
                _logger.fine(
                        "HTTP response status code: " +
                                httpResponse.getStatusCode());
            }
        }

        public HttpInvoker.HttpResponse deleteDocumentHttpResponse(
                Long documentId)
                throws Exception {

            HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

            if (_builder._locale != null) {
                httpInvoker.header(
                        "Accept-Language", _builder._locale.toLanguageTag());
            }

            for (Map.Entry<String, String> entry :
                    _builder._headers.entrySet()) {

                httpInvoker.header(entry.getKey(), entry.getValue());
            }

            for (Map.Entry<String, String> entry :
                    _builder._parameters.entrySet()) {

                httpInvoker.parameter(entry.getKey(), entry.getValue());
            }

            httpInvoker.httpMethod(HttpInvoker.HttpMethod.DELETE);

            httpInvoker.path(
                    _builder._scheme + "://" + _builder._host + ":" +
                            _builder._port + _builder._contextPath +
                            "/o/gestion-documents-rest/v1.0/document/{documentId}");

            httpInvoker.path("documentId", documentId);

            httpInvoker.userNameAndPassword(
                    _builder._login + ":" + _builder._password);

            return httpInvoker.invoke();
        }

        public void deleteDocumentBatch(String callbackURL, Object object)
                throws Exception {

            HttpInvoker.HttpResponse httpResponse =
                    deleteDocumentBatchHttpResponse(callbackURL, object);

            String content = httpResponse.getContent();

            if ((httpResponse.getStatusCode() / 100) != 2) {
                _logger.log(
                        Level.WARNING,
                        "Unable to process HTTP response content: " + content);
                _logger.log(
                        Level.WARNING,
                        "HTTP response message: " + httpResponse.getMessage());
                _logger.log(
                        Level.WARNING,
                        "HTTP response status code: " +
                                httpResponse.getStatusCode());

                throw new Problem.ProblemException(Problem.toDTO(content));
            } else {
                _logger.fine("HTTP response content: " + content);
                _logger.fine(
                        "HTTP response message: " + httpResponse.getMessage());
                _logger.fine(
                        "HTTP response status code: " +
                                httpResponse.getStatusCode());
            }
        }

        public HttpInvoker.HttpResponse deleteDocumentBatchHttpResponse(
                String callbackURL, Object object)
                throws Exception {

            HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

            httpInvoker.body(object.toString(), "application/json");

            if (_builder._locale != null) {
                httpInvoker.header(
                        "Accept-Language", _builder._locale.toLanguageTag());
            }

            for (Map.Entry<String, String> entry :
                    _builder._headers.entrySet()) {

                httpInvoker.header(entry.getKey(), entry.getValue());
            }

            for (Map.Entry<String, String> entry :
                    _builder._parameters.entrySet()) {

                httpInvoker.parameter(entry.getKey(), entry.getValue());
            }

            httpInvoker.httpMethod(HttpInvoker.HttpMethod.DELETE);

            if (callbackURL != null) {
                httpInvoker.parameter(
                        "callbackURL", String.valueOf(callbackURL));
            }

            httpInvoker.path(
                    _builder._scheme + "://" + _builder._host + ":" +
                            _builder._port + _builder._contextPath +
                            "/o/gestion-documents-rest/v1.0/document/batch");

            httpInvoker.userNameAndPassword(
                    _builder._login + ":" + _builder._password);

            return httpInvoker.invoke();
        }

        public Object getDocument(Long documentId) throws Exception {
            HttpInvoker.HttpResponse httpResponse = getDocumentHttpResponse(
                    documentId);

            String content = httpResponse.getContent();

            if ((httpResponse.getStatusCode() / 100) != 2) {
                _logger.log(
                        Level.WARNING,
                        "Unable to process HTTP response content: " + content);
                _logger.log(
                        Level.WARNING,
                        "HTTP response message: " + httpResponse.getMessage());
                _logger.log(
                        Level.WARNING,
                        "HTTP response status code: " +
                                httpResponse.getStatusCode());

                throw new Problem.ProblemException(Problem.toDTO(content));
            } else {
                _logger.fine("HTTP response content: " + content);
                _logger.fine(
                        "HTTP response message: " + httpResponse.getMessage());
                _logger.fine(
                        "HTTP response status code: " +
                                httpResponse.getStatusCode());
            }

            try {
                return (Object) content;
            } catch (Exception e) {
                _logger.log(
                        Level.WARNING,
                        "Unable to process HTTP response: " + content, e);

                throw new Problem.ProblemException(Problem.toDTO(content));
            }
        }

        public HttpInvoker.HttpResponse getDocumentHttpResponse(Long documentId)
                throws Exception {

            HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

            if (_builder._locale != null) {
                httpInvoker.header(
                        "Accept-Language", _builder._locale.toLanguageTag());
            }

            for (Map.Entry<String, String> entry :
                    _builder._headers.entrySet()) {

                httpInvoker.header(entry.getKey(), entry.getValue());
            }

            for (Map.Entry<String, String> entry :
                    _builder._parameters.entrySet()) {

                httpInvoker.parameter(entry.getKey(), entry.getValue());
            }

            httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

            httpInvoker.path(
                    _builder._scheme + "://" + _builder._host + ":" +
                            _builder._port + _builder._contextPath +
                            "/o/gestion-documents-rest/v1.0/document/{documentId}");

            httpInvoker.path("documentId", documentId);

            httpInvoker.userNameAndPassword(
                    _builder._login + ":" + _builder._password);

            return httpInvoker.invoke();
        }

        public void updateDocument(
                Long documentId, Document document,
                Map<String, File> multipartFiles)
                throws Exception {

            HttpInvoker.HttpResponse httpResponse = updateDocumentHttpResponse(
                    documentId, document, multipartFiles);

            String content = httpResponse.getContent();

            if ((httpResponse.getStatusCode() / 100) != 2) {
                _logger.log(
                        Level.WARNING,
                        "Unable to process HTTP response content: " + content);
                _logger.log(
                        Level.WARNING,
                        "HTTP response message: " + httpResponse.getMessage());
                _logger.log(
                        Level.WARNING,
                        "HTTP response status code: " +
                                httpResponse.getStatusCode());

                throw new Problem.ProblemException(Problem.toDTO(content));
            } else {
                _logger.fine("HTTP response content: " + content);
                _logger.fine(
                        "HTTP response message: " + httpResponse.getMessage());
                _logger.fine(
                        "HTTP response status code: " +
                                httpResponse.getStatusCode());
            }
        }

        public HttpInvoker.HttpResponse updateDocumentHttpResponse(
                Long documentId, Document document,
                Map<String, File> multipartFiles)
                throws Exception {

            HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

            httpInvoker.multipart();

            httpInvoker.part("document", DocumentSerDes.toJSON(document));

            for (Map.Entry<String, File> entry : multipartFiles.entrySet()) {
                httpInvoker.part(entry.getKey(), String.valueOf(entry.getValue()));
            }

            if (_builder._locale != null) {
                httpInvoker.header(
                        "Accept-Language", _builder._locale.toLanguageTag());
            }

            for (Map.Entry<String, String> entry :
                    _builder._headers.entrySet()) {

                httpInvoker.header(entry.getKey(), entry.getValue());
            }

            for (Map.Entry<String, String> entry :
                    _builder._parameters.entrySet()) {

                httpInvoker.parameter(entry.getKey(), entry.getValue());
            }

            httpInvoker.httpMethod(HttpInvoker.HttpMethod.PUT);

            httpInvoker.path(
                    _builder._scheme + "://" + _builder._host + ":" +
                            _builder._port + _builder._contextPath +
                            "/o/gestion-documents-rest/v1.0/document/{documentId}");

            httpInvoker.path("documentId", documentId);

            httpInvoker.userNameAndPassword(
                    _builder._login + ":" + _builder._password);

            return httpInvoker.invoke();
        }

        public Object getDocumentHistory(Long documentId) throws Exception {
            HttpInvoker.HttpResponse httpResponse =
                    getDocumentHistoryHttpResponse(documentId);

            String content = httpResponse.getContent();

            if ((httpResponse.getStatusCode() / 100) != 2) {
                _logger.log(
                        Level.WARNING,
                        "Unable to process HTTP response content: " + content);
                _logger.log(
                        Level.WARNING,
                        "HTTP response message: " + httpResponse.getMessage());
                _logger.log(
                        Level.WARNING,
                        "HTTP response status code: " +
                                httpResponse.getStatusCode());

                throw new Problem.ProblemException(Problem.toDTO(content));
            } else {
                _logger.fine("HTTP response content: " + content);
                _logger.fine(
                        "HTTP response message: " + httpResponse.getMessage());
                _logger.fine(
                        "HTTP response status code: " +
                                httpResponse.getStatusCode());
            }

            try {
                return (Object) content;
            } catch (Exception e) {
                _logger.log(
                        Level.WARNING,
                        "Unable to process HTTP response: " + content, e);

                throw new Problem.ProblemException(Problem.toDTO(content));
            }
        }

        public HttpInvoker.HttpResponse getDocumentHistoryHttpResponse(
                Long documentId)
                throws Exception {

            HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

            if (_builder._locale != null) {
                httpInvoker.header(
                        "Accept-Language", _builder._locale.toLanguageTag());
            }

            for (Map.Entry<String, String> entry :
                    _builder._headers.entrySet()) {

                httpInvoker.header(entry.getKey(), entry.getValue());
            }

            for (Map.Entry<String, String> entry :
                    _builder._parameters.entrySet()) {

                httpInvoker.parameter(entry.getKey(), entry.getValue());
            }

            httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

            httpInvoker.path(
                    _builder._scheme + "://" + _builder._host + ":" +
                            _builder._port + _builder._contextPath +
                            "/o/gestion-documents-rest/v1.0/document/{documentId}/history");

            httpInvoker.path("documentId", documentId);

            httpInvoker.userNameAndPassword(
                    _builder._login + ":" + _builder._password);

            return httpInvoker.invoke();
        }

        public Object getDocuments(String title, String[] tags)
                throws Exception {

            HttpInvoker.HttpResponse httpResponse = getDocumentsHttpResponse(
                    title, tags);

            String content = httpResponse.getContent();

            if ((httpResponse.getStatusCode() / 100) != 2) {
                _logger.log(
                        Level.WARNING,
                        "Unable to process HTTP response content: " + content);
                _logger.log(
                        Level.WARNING,
                        "HTTP response message: " + httpResponse.getMessage());
                _logger.log(
                        Level.WARNING,
                        "HTTP response status code: " +
                                httpResponse.getStatusCode());

                throw new Problem.ProblemException(Problem.toDTO(content));
            } else {
                _logger.fine("HTTP response content: " + content);
                _logger.fine(
                        "HTTP response message: " + httpResponse.getMessage());
                _logger.fine(
                        "HTTP response status code: " +
                                httpResponse.getStatusCode());
            }

            try {
                return (Object) content;
            } catch (Exception e) {
                _logger.log(
                        Level.WARNING,
                        "Unable to process HTTP response: " + content, e);

                throw new Problem.ProblemException(Problem.toDTO(content));
            }
        }

        public HttpInvoker.HttpResponse getDocumentsHttpResponse(
                String title, String[] tags)
                throws Exception {

            HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

            if (_builder._locale != null) {
                httpInvoker.header(
                        "Accept-Language", _builder._locale.toLanguageTag());
            }

            for (Map.Entry<String, String> entry :
                    _builder._headers.entrySet()) {

                httpInvoker.header(entry.getKey(), entry.getValue());
            }

            for (Map.Entry<String, String> entry :
                    _builder._parameters.entrySet()) {

                httpInvoker.parameter(entry.getKey(), entry.getValue());
            }

            httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

            if (title != null) {
                httpInvoker.parameter("title", String.valueOf(title));
            }

            if (tags != null) {
                for (int i = 0; i < tags.length; i++) {
                    httpInvoker.parameter("tags", String.valueOf(tags[i]));
                }
            }

            httpInvoker.path(
                    _builder._scheme + "://" + _builder._host + ":" +
                            _builder._port + _builder._contextPath +
                            "/o/gestion-documents-rest/v1.0/documents");

            httpInvoker.userNameAndPassword(
                    _builder._login + ":" + _builder._password);

            return httpInvoker.invoke();
        }

        private DocumentResourceImpl(Builder builder) {
            _builder = builder;
        }

        private static final Logger _logger = Logger.getLogger(
                DocumentResource.class.getName());

        private Builder _builder;

    }

}