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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GestionDocumentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see GestionDocumentLocalService
 * @generated
 */
public class GestionDocumentLocalServiceWrapper
	implements GestionDocumentLocalService,
			   ServiceWrapper<GestionDocumentLocalService> {

	public GestionDocumentLocalServiceWrapper() {
		this(null);
	}

	public GestionDocumentLocalServiceWrapper(
		GestionDocumentLocalService gestionDocumentLocalService) {

		_gestionDocumentLocalService = gestionDocumentLocalService;
	}

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
	@Override
	public com.liferay.gwenod.gd.service.model.GestionDocument
		addGestionDocument(
			com.liferay.gwenod.gd.service.model.GestionDocument
				gestionDocument) {

		return _gestionDocumentLocalService.addGestionDocument(gestionDocument);
	}

	@Override
	public com.liferay.document.library.kernel.model.DLFileEntry createDocument(
			String filename, String title, String description, String changeLog,
			com.liferay.portal.vulcan.multipart.BinaryFile file, String type,
			String city, String address, java.util.List<String> tags,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   java.io.IOException {

		return _gestionDocumentLocalService.createDocument(
			filename, title, description, changeLog, file, type, city, address,
			tags, serviceContext);
	}

	/**
	 * Creates a new gestion document with the primary key. Does not add the gestion document to the database.
	 *
	 * @param id the primary key for the new gestion document
	 * @return the new gestion document
	 */
	@Override
	public com.liferay.gwenod.gd.service.model.GestionDocument
		createGestionDocument(long id) {

		return _gestionDocumentLocalService.createGestionDocument(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gestionDocumentLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public void deleteDocument(
			Long documentId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		_gestionDocumentLocalService.deleteDocument(documentId, serviceContext);
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
	@Override
	public com.liferay.gwenod.gd.service.model.GestionDocument
		deleteGestionDocument(
			com.liferay.gwenod.gd.service.model.GestionDocument
				gestionDocument) {

		return _gestionDocumentLocalService.deleteGestionDocument(
			gestionDocument);
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
	@Override
	public com.liferay.gwenod.gd.service.model.GestionDocument
			deleteGestionDocument(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gestionDocumentLocalService.deleteGestionDocument(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gestionDocumentLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _gestionDocumentLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _gestionDocumentLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _gestionDocumentLocalService.dynamicQuery();
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

		return _gestionDocumentLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _gestionDocumentLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _gestionDocumentLocalService.dynamicQuery(
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

		return _gestionDocumentLocalService.dynamicQueryCount(dynamicQuery);
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

		return _gestionDocumentLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.gwenod.gd.service.model.GestionDocument
		fetchGestionDocument(long id) {

		return _gestionDocumentLocalService.fetchGestionDocument(id);
	}

	@Override
	public boolean fileTypeExists(
		String type,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _gestionDocumentLocalService.fileTypeExists(
			type, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _gestionDocumentLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.document.library.kernel.model.DLFileEntry getDocument(
			Long documentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gestionDocumentLocalService.getDocument(documentId);
	}

	@Override
	public java.util.List
		<com.liferay.document.library.kernel.model.DLFileVersion>
				getDocumentHistory(Long documentId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _gestionDocumentLocalService.getDocumentHistory(documentId);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document>
			getDocuments(
				String title, String[] tags,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gestionDocumentLocalService.getDocuments(
			title, tags, serviceContext);
	}

	/**
	 * Returns the gestion document with the primary key.
	 *
	 * @param id the primary key of the gestion document
	 * @return the gestion document
	 * @throws PortalException if a gestion document with the primary key could not be found
	 */
	@Override
	public com.liferay.gwenod.gd.service.model.GestionDocument
			getGestionDocument(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gestionDocumentLocalService.getGestionDocument(id);
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
	@Override
	public java.util.List<com.liferay.gwenod.gd.service.model.GestionDocument>
		getGestionDocuments(int start, int end) {

		return _gestionDocumentLocalService.getGestionDocuments(start, end);
	}

	/**
	 * Returns the number of gestion documents.
	 *
	 * @return the number of gestion documents
	 */
	@Override
	public int getGestionDocumentsCount() {
		return _gestionDocumentLocalService.getGestionDocumentsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _gestionDocumentLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _gestionDocumentLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gestionDocumentLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.liferay.document.library.kernel.model.DLFileEntry>
			searchByKeywords(
				long userId, String keywords, String fileType, int start,
				int end, String fromDate, String toDate,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gestionDocumentLocalService.searchByKeywords(
			userId, keywords, fileType, start, end, fromDate, toDate,
			serviceContext);
	}

	@Override
	public com.liferay.document.library.kernel.model.DLFileEntry updateDocument(
			Long documentId, String filename, String title, String description,
			String changeLog,
			com.liferay.portal.vulcan.multipart.BinaryFile file, String city,
			String address, java.util.List<String> tags,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   java.io.IOException {

		return _gestionDocumentLocalService.updateDocument(
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
	@Override
	public com.liferay.gwenod.gd.service.model.GestionDocument
		updateGestionDocument(
			com.liferay.gwenod.gd.service.model.GestionDocument
				gestionDocument) {

		return _gestionDocumentLocalService.updateGestionDocument(
			gestionDocument);
	}

	@Override
	public GestionDocumentLocalService getWrappedService() {
		return _gestionDocumentLocalService;
	}

	@Override
	public void setWrappedService(
		GestionDocumentLocalService gestionDocumentLocalService) {

		_gestionDocumentLocalService = gestionDocumentLocalService;
	}

	private GestionDocumentLocalService _gestionDocumentLocalService;

}