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

package com.liferay.gwenod.gd.service.service;

import com.liferay.gwenod.gd.service.model.GestionDocument;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for GestionDocument. This utility wraps
 * <code>com.liferay.gwenod.gd.service.service.impl.GestionDocumentLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see GestionDocumentLocalService
 * @generated
 */
public class GestionDocumentLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.gwenod.gd.service.service.impl.GestionDocumentLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the gestion document to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GestionDocumentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param gestionDocument the gestion document
	 * @return the gestion document that was added
	 */
	public static GestionDocument addGestionDocument(
		GestionDocument gestionDocument) {

		return getService().addGestionDocument(gestionDocument);
	}

	public static com.liferay.document.library.kernel.model.DLFileEntry
			createDocument(
				String filename, String title, String description,
				String changeLog,
				com.liferay.portal.vulcan.multipart.BinaryFile file,
				String type, String city, String address, List<String> tags,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws java.io.IOException, PortalException {

		return getService().createDocument(
			filename, title, description, changeLog, file, type, city, address,
			tags, serviceContext);
	}

	/**
	 * Creates a new gestion document with the primary key. Does not add the gestion document to the database.
	 *
	 * @param id the primary key for the new gestion document
	 * @return the new gestion document
	 */
	public static GestionDocument createGestionDocument(long id) {
		return getService().createGestionDocument(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static void deleteDocument(
			Long documentId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		getService().deleteDocument(documentId, serviceContext);
	}

	/**
	 * Deletes the gestion document from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GestionDocumentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param gestionDocument the gestion document
	 * @return the gestion document that was removed
	 */
	public static GestionDocument deleteGestionDocument(
		GestionDocument gestionDocument) {

		return getService().deleteGestionDocument(gestionDocument);
	}

	/**
	 * Deletes the gestion document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GestionDocumentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the gestion document
	 * @return the gestion document that was removed
	 * @throws PortalException if a gestion document with the primary key could not be found
	 */
	public static GestionDocument deleteGestionDocument(long id)
		throws PortalException {

		return getService().deleteGestionDocument(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.gwenod.gd.service.model.impl.GestionDocumentModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.gwenod.gd.service.model.impl.GestionDocumentModelImpl</code>.
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

	public static GestionDocument fetchGestionDocument(long id) {
		return getService().fetchGestionDocument(id);
	}

	public static boolean fileTypeExists(
		String type,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().fileTypeExists(type, serviceContext);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.document.library.kernel.model.DLFileEntry
			getDocument(Long documentId)
		throws PortalException {

		return getService().getDocument(documentId);
	}

	public static List<com.liferay.document.library.kernel.model.DLFileVersion>
			getDocumentHistory(Long documentId)
		throws PortalException {

		return getService().getDocumentHistory(documentId);
	}

	public static List<com.liferay.portal.kernel.search.Document> getDocuments(
			String title, String[] tags,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().getDocuments(title, tags, serviceContext);
	}

	/**
	 * Returns the gestion document with the primary key.
	 *
	 * @param id the primary key of the gestion document
	 * @return the gestion document
	 * @throws PortalException if a gestion document with the primary key could not be found
	 */
	public static GestionDocument getGestionDocument(long id)
		throws PortalException {

		return getService().getGestionDocument(id);
	}

	/**
	 * Returns a range of all the gestion documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.gwenod.gd.service.model.impl.GestionDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gestion documents
	 * @param end the upper bound of the range of gestion documents (not inclusive)
	 * @return the range of gestion documents
	 */
	public static List<GestionDocument> getGestionDocuments(
		int start, int end) {

		return getService().getGestionDocuments(start, end);
	}

	/**
	 * Returns the number of gestion documents.
	 *
	 * @return the number of gestion documents
	 */
	public static int getGestionDocumentsCount() {
		return getService().getGestionDocumentsCount();
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

	public static List<com.liferay.document.library.kernel.model.DLFileEntry>
			searchByKeywords(
				long userId, String keywords, String fileType, int start,
				int end, String fromDate, String toDate,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().searchByKeywords(
			userId, keywords, fileType, start, end, fromDate, toDate,
			serviceContext);
	}

	public static com.liferay.document.library.kernel.model.DLFileEntry
			updateDocument(
				Long documentId, String filename, String title,
				String description, String changeLog,
				com.liferay.portal.vulcan.multipart.BinaryFile file,
				String city, String address, List<String> tags,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws java.io.IOException, PortalException {

		return getService().updateDocument(
			documentId, filename, title, description, changeLog, file, city,
			address, tags, serviceContext);
	}

	/**
	 * Updates the gestion document in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GestionDocumentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param gestionDocument the gestion document
	 * @return the gestion document that was updated
	 */
	public static GestionDocument updateGestionDocument(
		GestionDocument gestionDocument) {

		return getService().updateGestionDocument(gestionDocument);
	}

	public static GestionDocumentLocalService getService() {
		return _service;
	}

	private static volatile GestionDocumentLocalService _service;

}