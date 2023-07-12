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

package com.liferay.gwenod.gestiondocuments.service.service.persistence;

import com.liferay.gwenod.gestiondocuments.service.model.DocumentHistory;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the document history service. This utility wraps <code>com.liferay.gwenod.gestiondocuments.service.service.persistence.impl.DocumentHistoryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentHistoryPersistence
 * @generated
 */
public class DocumentHistoryUtil {

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
	public static void clearCache(DocumentHistory documentHistory) {
		getPersistence().clearCache(documentHistory);
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
	public static Map<Serializable, DocumentHistory> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DocumentHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DocumentHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DocumentHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DocumentHistory> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DocumentHistory update(DocumentHistory documentHistory) {
		return getPersistence().update(documentHistory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DocumentHistory update(
		DocumentHistory documentHistory, ServiceContext serviceContext) {

		return getPersistence().update(documentHistory, serviceContext);
	}

	/**
	 * Returns all the document histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching document histories
	 */
	public static List<DocumentHistory> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the document histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of document histories
	 * @param end the upper bound of the range of document histories (not inclusive)
	 * @return the range of matching document histories
	 */
	public static List<DocumentHistory> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the document histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of document histories
	 * @param end the upper bound of the range of document histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching document histories
	 */
	public static List<DocumentHistory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DocumentHistory> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the document histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of document histories
	 * @param end the upper bound of the range of document histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching document histories
	 */
	public static List<DocumentHistory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DocumentHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first document history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document history
	 * @throws NoSuchDocumentHistoryException if a matching document history could not be found
	 */
	public static DocumentHistory findByUuid_First(
			String uuid, OrderByComparator<DocumentHistory> orderByComparator)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentHistoryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first document history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document history, or <code>null</code> if a matching document history could not be found
	 */
	public static DocumentHistory fetchByUuid_First(
		String uuid, OrderByComparator<DocumentHistory> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last document history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document history
	 * @throws NoSuchDocumentHistoryException if a matching document history could not be found
	 */
	public static DocumentHistory findByUuid_Last(
			String uuid, OrderByComparator<DocumentHistory> orderByComparator)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentHistoryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last document history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document history, or <code>null</code> if a matching document history could not be found
	 */
	public static DocumentHistory fetchByUuid_Last(
		String uuid, OrderByComparator<DocumentHistory> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the document histories before and after the current document history in the ordered set where uuid = &#63;.
	 *
	 * @param historyId the primary key of the current document history
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document history
	 * @throws NoSuchDocumentHistoryException if a document history with the primary key could not be found
	 */
	public static DocumentHistory[] findByUuid_PrevAndNext(
			long historyId, String uuid,
			OrderByComparator<DocumentHistory> orderByComparator)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentHistoryException {

		return getPersistence().findByUuid_PrevAndNext(
			historyId, uuid, orderByComparator);
	}

	/**
	 * Removes all the document histories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of document histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching document histories
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the document histories where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @return the matching document histories
	 */
	public static List<DocumentHistory> findByDocumentId(long documentId) {
		return getPersistence().findByDocumentId(documentId);
	}

	/**
	 * Returns a range of all the document histories where documentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param documentId the document ID
	 * @param start the lower bound of the range of document histories
	 * @param end the upper bound of the range of document histories (not inclusive)
	 * @return the range of matching document histories
	 */
	public static List<DocumentHistory> findByDocumentId(
		long documentId, int start, int end) {

		return getPersistence().findByDocumentId(documentId, start, end);
	}

	/**
	 * Returns an ordered range of all the document histories where documentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param documentId the document ID
	 * @param start the lower bound of the range of document histories
	 * @param end the upper bound of the range of document histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching document histories
	 */
	public static List<DocumentHistory> findByDocumentId(
		long documentId, int start, int end,
		OrderByComparator<DocumentHistory> orderByComparator) {

		return getPersistence().findByDocumentId(
			documentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the document histories where documentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param documentId the document ID
	 * @param start the lower bound of the range of document histories
	 * @param end the upper bound of the range of document histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching document histories
	 */
	public static List<DocumentHistory> findByDocumentId(
		long documentId, int start, int end,
		OrderByComparator<DocumentHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDocumentId(
			documentId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first document history in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document history
	 * @throws NoSuchDocumentHistoryException if a matching document history could not be found
	 */
	public static DocumentHistory findByDocumentId_First(
			long documentId,
			OrderByComparator<DocumentHistory> orderByComparator)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentHistoryException {

		return getPersistence().findByDocumentId_First(
			documentId, orderByComparator);
	}

	/**
	 * Returns the first document history in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document history, or <code>null</code> if a matching document history could not be found
	 */
	public static DocumentHistory fetchByDocumentId_First(
		long documentId, OrderByComparator<DocumentHistory> orderByComparator) {

		return getPersistence().fetchByDocumentId_First(
			documentId, orderByComparator);
	}

	/**
	 * Returns the last document history in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document history
	 * @throws NoSuchDocumentHistoryException if a matching document history could not be found
	 */
	public static DocumentHistory findByDocumentId_Last(
			long documentId,
			OrderByComparator<DocumentHistory> orderByComparator)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentHistoryException {

		return getPersistence().findByDocumentId_Last(
			documentId, orderByComparator);
	}

	/**
	 * Returns the last document history in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document history, or <code>null</code> if a matching document history could not be found
	 */
	public static DocumentHistory fetchByDocumentId_Last(
		long documentId, OrderByComparator<DocumentHistory> orderByComparator) {

		return getPersistence().fetchByDocumentId_Last(
			documentId, orderByComparator);
	}

	/**
	 * Returns the document histories before and after the current document history in the ordered set where documentId = &#63;.
	 *
	 * @param historyId the primary key of the current document history
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document history
	 * @throws NoSuchDocumentHistoryException if a document history with the primary key could not be found
	 */
	public static DocumentHistory[] findByDocumentId_PrevAndNext(
			long historyId, long documentId,
			OrderByComparator<DocumentHistory> orderByComparator)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentHistoryException {

		return getPersistence().findByDocumentId_PrevAndNext(
			historyId, documentId, orderByComparator);
	}

	/**
	 * Removes all the document histories where documentId = &#63; from the database.
	 *
	 * @param documentId the document ID
	 */
	public static void removeByDocumentId(long documentId) {
		getPersistence().removeByDocumentId(documentId);
	}

	/**
	 * Returns the number of document histories where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @return the number of matching document histories
	 */
	public static int countByDocumentId(long documentId) {
		return getPersistence().countByDocumentId(documentId);
	}

	/**
	 * Caches the document history in the entity cache if it is enabled.
	 *
	 * @param documentHistory the document history
	 */
	public static void cacheResult(DocumentHistory documentHistory) {
		getPersistence().cacheResult(documentHistory);
	}

	/**
	 * Caches the document histories in the entity cache if it is enabled.
	 *
	 * @param documentHistories the document histories
	 */
	public static void cacheResult(List<DocumentHistory> documentHistories) {
		getPersistence().cacheResult(documentHistories);
	}

	/**
	 * Creates a new document history with the primary key. Does not add the document history to the database.
	 *
	 * @param historyId the primary key for the new document history
	 * @return the new document history
	 */
	public static DocumentHistory create(long historyId) {
		return getPersistence().create(historyId);
	}

	/**
	 * Removes the document history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param historyId the primary key of the document history
	 * @return the document history that was removed
	 * @throws NoSuchDocumentHistoryException if a document history with the primary key could not be found
	 */
	public static DocumentHistory remove(long historyId)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentHistoryException {

		return getPersistence().remove(historyId);
	}

	public static DocumentHistory updateImpl(DocumentHistory documentHistory) {
		return getPersistence().updateImpl(documentHistory);
	}

	/**
	 * Returns the document history with the primary key or throws a <code>NoSuchDocumentHistoryException</code> if it could not be found.
	 *
	 * @param historyId the primary key of the document history
	 * @return the document history
	 * @throws NoSuchDocumentHistoryException if a document history with the primary key could not be found
	 */
	public static DocumentHistory findByPrimaryKey(long historyId)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentHistoryException {

		return getPersistence().findByPrimaryKey(historyId);
	}

	/**
	 * Returns the document history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param historyId the primary key of the document history
	 * @return the document history, or <code>null</code> if a document history with the primary key could not be found
	 */
	public static DocumentHistory fetchByPrimaryKey(long historyId) {
		return getPersistence().fetchByPrimaryKey(historyId);
	}

	/**
	 * Returns all the document histories.
	 *
	 * @return the document histories
	 */
	public static List<DocumentHistory> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the document histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document histories
	 * @param end the upper bound of the range of document histories (not inclusive)
	 * @return the range of document histories
	 */
	public static List<DocumentHistory> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the document histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document histories
	 * @param end the upper bound of the range of document histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of document histories
	 */
	public static List<DocumentHistory> findAll(
		int start, int end,
		OrderByComparator<DocumentHistory> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the document histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document histories
	 * @param end the upper bound of the range of document histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of document histories
	 */
	public static List<DocumentHistory> findAll(
		int start, int end,
		OrderByComparator<DocumentHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the document histories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of document histories.
	 *
	 * @return the number of document histories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DocumentHistoryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DocumentHistoryPersistence _persistence;

}