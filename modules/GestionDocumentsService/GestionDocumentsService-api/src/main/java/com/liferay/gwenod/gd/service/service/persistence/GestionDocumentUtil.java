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

package com.liferay.gwenod.gd.service.service.persistence;

import com.liferay.gwenod.gd.service.model.GestionDocument;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the gestion document service. This utility wraps <code>com.liferay.gwenod.gd.service.service.persistence.impl.GestionDocumentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GestionDocumentPersistence
 * @generated
 */
public class GestionDocumentUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(GestionDocument gestionDocument) {
		getPersistence().clearCache(gestionDocument);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, GestionDocument> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GestionDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GestionDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GestionDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GestionDocument> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GestionDocument update(GestionDocument gestionDocument) {
		return getPersistence().update(gestionDocument);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GestionDocument update(
		GestionDocument gestionDocument, ServiceContext serviceContext) {

		return getPersistence().update(gestionDocument, serviceContext);
	}

	/**
	 * Caches the gestion document in the entity cache if it is enabled.
	 *
	 * @param gestionDocument the gestion document
	 */
	public static void cacheResult(GestionDocument gestionDocument) {
		getPersistence().cacheResult(gestionDocument);
	}

	/**
	 * Caches the gestion documents in the entity cache if it is enabled.
	 *
	 * @param gestionDocuments the gestion documents
	 */
	public static void cacheResult(List<GestionDocument> gestionDocuments) {
		getPersistence().cacheResult(gestionDocuments);
	}

	/**
	 * Creates a new gestion document with the primary key. Does not add the gestion document to the database.
	 *
	 * @param id the primary key for the new gestion document
	 * @return the new gestion document
	 */
	public static GestionDocument create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the gestion document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the gestion document
	 * @return the gestion document that was removed
	 * @throws NoSuchGestionDocumentException if a gestion document with the primary key could not be found
	 */
	public static GestionDocument remove(long id)
		throws com.liferay.gwenod.gd.service.exception.
			NoSuchGestionDocumentException {

		return getPersistence().remove(id);
	}

	public static GestionDocument updateImpl(GestionDocument gestionDocument) {
		return getPersistence().updateImpl(gestionDocument);
	}

	/**
	 * Returns the gestion document with the primary key or throws a <code>NoSuchGestionDocumentException</code> if it could not be found.
	 *
	 * @param id the primary key of the gestion document
	 * @return the gestion document
	 * @throws NoSuchGestionDocumentException if a gestion document with the primary key could not be found
	 */
	public static GestionDocument findByPrimaryKey(long id)
		throws com.liferay.gwenod.gd.service.exception.
			NoSuchGestionDocumentException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the gestion document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the gestion document
	 * @return the gestion document, or <code>null</code> if a gestion document with the primary key could not be found
	 */
	public static GestionDocument fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the gestion documents.
	 *
	 * @return the gestion documents
	 */
	public static List<GestionDocument> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the gestion documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GestionDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gestion documents
	 * @param end the upper bound of the range of gestion documents (not inclusive)
	 * @return the range of gestion documents
	 */
	public static List<GestionDocument> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the gestion documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GestionDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gestion documents
	 * @param end the upper bound of the range of gestion documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of gestion documents
	 */
	public static List<GestionDocument> findAll(
		int start, int end,
		OrderByComparator<GestionDocument> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gestion documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GestionDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gestion documents
	 * @param end the upper bound of the range of gestion documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of gestion documents
	 */
	public static List<GestionDocument> findAll(
		int start, int end,
		OrderByComparator<GestionDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the gestion documents from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of gestion documents.
	 *
	 * @return the number of gestion documents
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static GestionDocumentPersistence getPersistence() {
		return _persistence;
	}

	private static volatile GestionDocumentPersistence _persistence;

}