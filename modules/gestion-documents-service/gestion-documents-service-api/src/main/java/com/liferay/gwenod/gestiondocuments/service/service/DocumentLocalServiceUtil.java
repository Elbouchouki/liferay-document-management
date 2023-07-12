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

import com.liferay.gwenod.gestiondocuments.service.model.Document;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.InputStream;
import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Document. This utility wraps
 * <code>com.liferay.gwenod.gestiondocuments.service.service.impl.DocumentLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DocumentLocalService
 * @generated
 */
public class DocumentLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.gwenod.gestiondocuments.service.service.impl.DocumentLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Document addDocument(Document document) {
		return getService().addDocument(document);
	}

	public static Document addDocument(
			InputStream file, String fileName, String title, List<String> tags,
			String city, String address, String type, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addDocument(
			file, fileName, title, tags, city, address, type, description,
			serviceContext);
	}

	/**
	 * Creates a new document with the primary key. Does not add the document to the database.
	 *
	 * @param documentId the primary key for the new document
	 * @return the new document
	 */
	public static Document createDocument(long documentId) {
		return getService().createDocument(documentId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static void deleteAllDocuments() {
		getService().deleteAllDocuments();
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
	public static Document deleteDocument(Document document) {
		return getService().deleteDocument(document);
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
	public static Document deleteDocument(long documentId)
		throws PortalException {

		return getService().deleteDocument(documentId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static Document deleteUserDocument(
			long documentId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws Exception {

		return getService().deleteUserDocument(documentId, serviceContext);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Document fetchDocument(long documentId) {
		return getService().fetchDocument(documentId);
	}

	/**
	 * Returns the document matching the UUID and group.
	 *
	 * @param uuid the document's UUID
	 * @param groupId the primary key of the group
	 * @return the matching document, or <code>null</code> if a matching document could not be found
	 */
	public static Document fetchDocumentByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchDocumentByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the document with the primary key.
	 *
	 * @param documentId the primary key of the document
	 * @return the document
	 * @throws PortalException if a document with the primary key could not be found
	 */
	public static Document getDocument(long documentId) throws PortalException {
		return getService().getDocument(documentId);
	}

	/**
	 * Returns the document matching the UUID and group.
	 *
	 * @param uuid the document's UUID
	 * @param groupId the primary key of the group
	 * @return the matching document
	 * @throws PortalException if a matching document could not be found
	 */
	public static Document getDocumentByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getDocumentByUuidAndGroupId(uuid, groupId);
	}

	public static java.io.ByteArrayOutputStream getDocumentFile(
			long documentId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentException,
			   IllegalAccessException {

		return getService().getDocumentFile(documentId, serviceContext);
	}

	public static List
		<com.liferay.gwenod.gestiondocuments.service.model.DocumentHistory>
				getDocumentHistory(
					long documentId,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
			throws com.liferay.gwenod.gestiondocuments.service.exception.
				NoSuchDocumentException,
				   IllegalAccessException {

		return getService().getDocumentHistory(documentId, serviceContext);
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
	public static List<Document> getDocuments(int start, int end) {
		return getService().getDocuments(start, end);
	}

	public static List<Document> getDocumentsByTagsAndTitle(
		String title, String tags,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().getDocumentsByTagsAndTitle(
			title, tags, serviceContext);
	}

	/**
	 * Returns all the documents matching the UUID and company.
	 *
	 * @param uuid the UUID of the documents
	 * @param companyId the primary key of the company
	 * @return the matching documents, or an empty list if no matches were found
	 */
	public static List<Document> getDocumentsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getDocumentsByUuidAndCompanyId(uuid, companyId);
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
	public static List<Document> getDocumentsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Document> orderByComparator) {

		return getService().getDocumentsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of documents.
	 *
	 * @return the number of documents
	 */
	public static int getDocumentsCount() {
		return getService().getDocumentsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static List<Document> getUserDocuments(
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().getUserDocuments(serviceContext);
	}

	public static void newDocumentHistory(Document document) {
		getService().newDocumentHistory(document);
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
	public static Document updateDocument(Document document) {
		return getService().updateDocument(document);
	}

	public static Document updateDocument(
			long documentId, InputStream file, String title, List<String> tags,
			String city, String address, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateDocument(
			documentId, file, title, tags, city, address, description,
			serviceContext);
	}

	public static DocumentLocalService getService() {
		return _service;
	}

	private static volatile DocumentLocalService _service;

}