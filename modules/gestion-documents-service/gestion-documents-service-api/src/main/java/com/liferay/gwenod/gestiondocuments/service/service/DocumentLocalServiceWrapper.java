/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.gwenod.gestiondocuments.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DocumentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DocumentLocalService
 * @generated
 */
public class DocumentLocalServiceWrapper
	implements DocumentLocalService, ServiceWrapper<DocumentLocalService> {

	public DocumentLocalServiceWrapper() {
		this(null);
	}

	public DocumentLocalServiceWrapper(
		DocumentLocalService documentLocalService) {

		_documentLocalService = documentLocalService;
	}

	/**
	 * Adds the document to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param document the document
	 * @return the document that was added
	 */
	@Override
	public com.liferay.gwenod.gestiondocuments.service.model.Document
		addDocument(
			com.liferay.gwenod.gestiondocuments.service.model.Document
				document) {

		return _documentLocalService.addDocument(document);
	}

	@Override
	public com.liferay.gwenod.gestiondocuments.service.model.Document
			addDocument(
				java.io.InputStream file, String fileName, String title,
				java.util.List<String> tags, String city, String address,
				String type, String description,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentLocalService.addDocument(
			file, fileName, title, tags, city, address, type, description,
			serviceContext);
	}

	/**
	 * Creates a new document with the primary key. Does not add the document to the database.
	 *
	 * @param documentId the primary key for the new document
	 * @return the new document
	 */
	@Override
	public com.liferay.gwenod.gestiondocuments.service.model.Document
		createDocument(long documentId) {

		return _documentLocalService.createDocument(documentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public void deleteAllDocuments() {
		_documentLocalService.deleteAllDocuments();
	}

	/**
	 * Deletes the document from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param document the document
	 * @return the document that was removed
	 */
	@Override
	public com.liferay.gwenod.gestiondocuments.service.model.Document
		deleteDocument(
			com.liferay.gwenod.gestiondocuments.service.model.Document
				document) {

		return _documentLocalService.deleteDocument(document);
	}

	/**
	 * Deletes the document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documentId the primary key of the document
	 * @return the document that was removed
	 * @throws PortalException if a document with the primary key could not be found
	 */
	@Override
	public com.liferay.gwenod.gestiondocuments.service.model.Document
			deleteDocument(long documentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentLocalService.deleteDocument(documentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.gwenod.gestiondocuments.service.model.Document
			deleteUserDocument(
				long documentId,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws Exception {

		return _documentLocalService.deleteUserDocument(
			documentId, serviceContext);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _documentLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _documentLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _documentLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _documentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.gwenod.gestiondocuments.service.model.impl.DocumentModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _documentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.gwenod.gestiondocuments.service.model.impl.DocumentModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _documentLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _documentLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _documentLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.gwenod.gestiondocuments.service.model.Document
		fetchDocument(long documentId) {

		return _documentLocalService.fetchDocument(documentId);
	}

	/**
	 * Returns the document matching the UUID and group.
	 *
	 * @param uuid the document's UUID
	 * @param groupId the primary key of the group
	 * @return the matching document, or <code>null</code> if a matching document could not be found
	 */
	@Override
	public com.liferay.gwenod.gestiondocuments.service.model.Document
		fetchDocumentByUuidAndGroupId(String uuid, long groupId) {

		return _documentLocalService.fetchDocumentByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _documentLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the document with the primary key.
	 *
	 * @param documentId the primary key of the document
	 * @return the document
	 * @throws PortalException if a document with the primary key could not be found
	 */
	@Override
	public com.liferay.gwenod.gestiondocuments.service.model.Document
			getDocument(long documentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentLocalService.getDocument(documentId);
	}

	/**
	 * Returns the document matching the UUID and group.
	 *
	 * @param uuid the document's UUID
	 * @param groupId the primary key of the group
	 * @return the matching document
	 * @throws PortalException if a matching document could not be found
	 */
	@Override
	public com.liferay.gwenod.gestiondocuments.service.model.Document
			getDocumentByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentLocalService.getDocumentByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.io.ByteArrayOutputStream getDocumentFile(
			long documentId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentException,
			   IllegalAccessException {

		return _documentLocalService.getDocumentFile(
			documentId, serviceContext);
	}

	@Override
	public java.util.List
		<com.liferay.gwenod.gestiondocuments.service.model.DocumentHistory>
				getDocumentHistory(
					long documentId,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
			throws com.liferay.gwenod.gestiondocuments.service.exception.
				NoSuchDocumentException,
				   IllegalAccessException {

		return _documentLocalService.getDocumentHistory(
			documentId, serviceContext);
	}

	/**
	 * Returns a range of all the documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.gwenod.gestiondocuments.service.model.impl.DocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of documents
	 * @param end the upper bound of the range of documents (not inclusive)
	 * @return the range of documents
	 */
	@Override
	public java.util.List
		<com.liferay.gwenod.gestiondocuments.service.model.Document>
			getDocuments(int start, int end) {

		return _documentLocalService.getDocuments(start, end);
	}

	@Override
	public java.util.List
		<com.liferay.gwenod.gestiondocuments.service.model.Document>
			getDocumentsByTagsAndTitle(
				String title, String tags,
				com.liferay.portal.kernel.service.ServiceContext
					serviceContext) {

		return _documentLocalService.getDocumentsByTagsAndTitle(
			title, tags, serviceContext);
	}

	/**
	 * Returns all the documents matching the UUID and company.
	 *
	 * @param uuid the UUID of the documents
	 * @param companyId the primary key of the company
	 * @return the matching documents, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.liferay.gwenod.gestiondocuments.service.model.Document>
			getDocumentsByUuidAndCompanyId(String uuid, long companyId) {

		return _documentLocalService.getDocumentsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of documents matching the UUID and company.
	 *
	 * @param uuid the UUID of the documents
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of documents
	 * @param end the upper bound of the range of documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching documents, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.liferay.gwenod.gestiondocuments.service.model.Document>
			getDocumentsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.gwenod.gestiondocuments.service.model.Document>
						orderByComparator) {

		return _documentLocalService.getDocumentsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of documents.
	 *
	 * @return the number of documents
	 */
	@Override
	public int getDocumentsCount() {
		return _documentLocalService.getDocumentsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _documentLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _documentLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _documentLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List
		<com.liferay.gwenod.gestiondocuments.service.model.Document>
			getUserDocuments(
				com.liferay.portal.kernel.service.ServiceContext
					serviceContext) {

		return _documentLocalService.getUserDocuments(serviceContext);
	}

	@Override
	public void newDocumentHistory(
		com.liferay.gwenod.gestiondocuments.service.model.Document document) {

		_documentLocalService.newDocumentHistory(document);
	}

	/**
	 * Updates the document in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param document the document
	 * @return the document that was updated
	 */
	@Override
	public com.liferay.gwenod.gestiondocuments.service.model.Document
		updateDocument(
			com.liferay.gwenod.gestiondocuments.service.model.Document
				document) {

		return _documentLocalService.updateDocument(document);
	}

	@Override
	public com.liferay.gwenod.gestiondocuments.service.model.Document
			updateDocument(
				long documentId, java.io.InputStream file, String title,
				java.util.List<String> tags, String city, String address,
				String description,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentLocalService.updateDocument(
			documentId, file, title, tags, city, address, description,
			serviceContext);
	}

	@Override
	public DocumentLocalService getWrappedService() {
		return _documentLocalService;
	}

	@Override
	public void setWrappedService(DocumentLocalService documentLocalService) {
		_documentLocalService = documentLocalService;
	}

	private DocumentLocalService _documentLocalService;

}