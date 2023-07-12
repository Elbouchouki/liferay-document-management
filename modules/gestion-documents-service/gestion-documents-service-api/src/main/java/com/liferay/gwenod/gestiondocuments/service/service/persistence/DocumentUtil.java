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

import com.liferay.gwenod.gestiondocuments.service.model.Document;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the document service. This utility wraps <code>com.liferay.gwenod.gestiondocuments.service.service.persistence.impl.DocumentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentPersistence
 * @generated
 */
public class DocumentUtil {

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
	public static void clearCache(Document document) {
		getPersistence().clearCache(document);
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
	public static Map<Serializable, Document> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Document> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Document> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Document> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Document> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Document update(Document document) {
		return getPersistence().update(document);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Document update(
		Document document, ServiceContext serviceContext) {

		return getPersistence().update(document, serviceContext);
	}

	/**
	 * Returns all the documents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching documents
	 */
	public static List<Document> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the documents where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of documents
	 * @param end the upper bound of the range of documents (not inclusive)
	 * @return the range of matching documents
	 */
	public static List<Document> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the documents where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of documents
	 * @param end the upper bound of the range of documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching documents
	 */
	public static List<Document> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Document> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the documents where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of documents
	 * @param end the upper bound of the range of documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching documents
	 */
	public static List<Document> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Document> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first document in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	public static Document findByUuid_First(
			String uuid, OrderByComparator<Document> orderByComparator)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first document in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document, or <code>null</code> if a matching document could not be found
	 */
	public static Document fetchByUuid_First(
		String uuid, OrderByComparator<Document> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last document in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	public static Document findByUuid_Last(
			String uuid, OrderByComparator<Document> orderByComparator)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last document in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document, or <code>null</code> if a matching document could not be found
	 */
	public static Document fetchByUuid_Last(
		String uuid, OrderByComparator<Document> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the documents before and after the current document in the ordered set where uuid = &#63;.
	 *
	 * @param documentId the primary key of the current document
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document
	 * @throws NoSuchDocumentException if a document with the primary key could not be found
	 */
	public static Document[] findByUuid_PrevAndNext(
			long documentId, String uuid,
			OrderByComparator<Document> orderByComparator)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentException {

		return getPersistence().findByUuid_PrevAndNext(
			documentId, uuid, orderByComparator);
	}

	/**
	 * Removes all the documents where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of documents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching documents
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the document where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDocumentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	public static Document findByUUID_G(String uuid, long groupId)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the document where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching document, or <code>null</code> if a matching document could not be found
	 */
	public static Document fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the document where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching document, or <code>null</code> if a matching document could not be found
	 */
	public static Document fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the document where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the document that was removed
	 */
	public static Document removeByUUID_G(String uuid, long groupId)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of documents where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching documents
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the documents where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching documents
	 */
	public static List<Document> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the documents where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of documents
	 * @param end the upper bound of the range of documents (not inclusive)
	 * @return the range of matching documents
	 */
	public static List<Document> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the documents where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of documents
	 * @param end the upper bound of the range of documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching documents
	 */
	public static List<Document> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Document> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the documents where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of documents
	 * @param end the upper bound of the range of documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching documents
	 */
	public static List<Document> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Document> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first document in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	public static Document findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Document> orderByComparator)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first document in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document, or <code>null</code> if a matching document could not be found
	 */
	public static Document fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Document> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last document in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	public static Document findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Document> orderByComparator)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last document in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document, or <code>null</code> if a matching document could not be found
	 */
	public static Document fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Document> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the documents before and after the current document in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param documentId the primary key of the current document
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document
	 * @throws NoSuchDocumentException if a document with the primary key could not be found
	 */
	public static Document[] findByUuid_C_PrevAndNext(
			long documentId, String uuid, long companyId,
			OrderByComparator<Document> orderByComparator)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentException {

		return getPersistence().findByUuid_C_PrevAndNext(
			documentId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the documents where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of documents where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching documents
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the documents where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching documents
	 */
	public static List<Document> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the documents where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of documents
	 * @param end the upper bound of the range of documents (not inclusive)
	 * @return the range of matching documents
	 */
	public static List<Document> findByUserId(long userId, int start, int end) {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the documents where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of documents
	 * @param end the upper bound of the range of documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching documents
	 */
	public static List<Document> findByUserId(
		long userId, int start, int end,
		OrderByComparator<Document> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the documents where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of documents
	 * @param end the upper bound of the range of documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching documents
	 */
	public static List<Document> findByUserId(
		long userId, int start, int end,
		OrderByComparator<Document> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first document in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	public static Document findByUserId_First(
			long userId, OrderByComparator<Document> orderByComparator)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first document in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document, or <code>null</code> if a matching document could not be found
	 */
	public static Document fetchByUserId_First(
		long userId, OrderByComparator<Document> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last document in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	public static Document findByUserId_Last(
			long userId, OrderByComparator<Document> orderByComparator)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last document in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document, or <code>null</code> if a matching document could not be found
	 */
	public static Document fetchByUserId_Last(
		long userId, OrderByComparator<Document> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the documents before and after the current document in the ordered set where userId = &#63;.
	 *
	 * @param documentId the primary key of the current document
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document
	 * @throws NoSuchDocumentException if a document with the primary key could not be found
	 */
	public static Document[] findByUserId_PrevAndNext(
			long documentId, long userId,
			OrderByComparator<Document> orderByComparator)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentException {

		return getPersistence().findByUserId_PrevAndNext(
			documentId, userId, orderByComparator);
	}

	/**
	 * Removes all the documents where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of documents where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching documents
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the documents where filename = &#63;.
	 *
	 * @param filename the filename
	 * @return the matching documents
	 */
	public static List<Document> findByFilename(String filename) {
		return getPersistence().findByFilename(filename);
	}

	/**
	 * Returns a range of all the documents where filename = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentModelImpl</code>.
	 * </p>
	 *
	 * @param filename the filename
	 * @param start the lower bound of the range of documents
	 * @param end the upper bound of the range of documents (not inclusive)
	 * @return the range of matching documents
	 */
	public static List<Document> findByFilename(
		String filename, int start, int end) {

		return getPersistence().findByFilename(filename, start, end);
	}

	/**
	 * Returns an ordered range of all the documents where filename = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentModelImpl</code>.
	 * </p>
	 *
	 * @param filename the filename
	 * @param start the lower bound of the range of documents
	 * @param end the upper bound of the range of documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching documents
	 */
	public static List<Document> findByFilename(
		String filename, int start, int end,
		OrderByComparator<Document> orderByComparator) {

		return getPersistence().findByFilename(
			filename, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the documents where filename = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentModelImpl</code>.
	 * </p>
	 *
	 * @param filename the filename
	 * @param start the lower bound of the range of documents
	 * @param end the upper bound of the range of documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching documents
	 */
	public static List<Document> findByFilename(
		String filename, int start, int end,
		OrderByComparator<Document> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByFilename(
			filename, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first document in the ordered set where filename = &#63;.
	 *
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	public static Document findByFilename_First(
			String filename, OrderByComparator<Document> orderByComparator)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentException {

		return getPersistence().findByFilename_First(
			filename, orderByComparator);
	}

	/**
	 * Returns the first document in the ordered set where filename = &#63;.
	 *
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document, or <code>null</code> if a matching document could not be found
	 */
	public static Document fetchByFilename_First(
		String filename, OrderByComparator<Document> orderByComparator) {

		return getPersistence().fetchByFilename_First(
			filename, orderByComparator);
	}

	/**
	 * Returns the last document in the ordered set where filename = &#63;.
	 *
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	public static Document findByFilename_Last(
			String filename, OrderByComparator<Document> orderByComparator)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentException {

		return getPersistence().findByFilename_Last(
			filename, orderByComparator);
	}

	/**
	 * Returns the last document in the ordered set where filename = &#63;.
	 *
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document, or <code>null</code> if a matching document could not be found
	 */
	public static Document fetchByFilename_Last(
		String filename, OrderByComparator<Document> orderByComparator) {

		return getPersistence().fetchByFilename_Last(
			filename, orderByComparator);
	}

	/**
	 * Returns the documents before and after the current document in the ordered set where filename = &#63;.
	 *
	 * @param documentId the primary key of the current document
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document
	 * @throws NoSuchDocumentException if a document with the primary key could not be found
	 */
	public static Document[] findByFilename_PrevAndNext(
			long documentId, String filename,
			OrderByComparator<Document> orderByComparator)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentException {

		return getPersistence().findByFilename_PrevAndNext(
			documentId, filename, orderByComparator);
	}

	/**
	 * Removes all the documents where filename = &#63; from the database.
	 *
	 * @param filename the filename
	 */
	public static void removeByFilename(String filename) {
		getPersistence().removeByFilename(filename);
	}

	/**
	 * Returns the number of documents where filename = &#63;.
	 *
	 * @param filename the filename
	 * @return the number of matching documents
	 */
	public static int countByFilename(String filename) {
		return getPersistence().countByFilename(filename);
	}

	/**
	 * Returns all the documents where userId = &#63; and title = &#63; and tags = &#63;.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param tags the tags
	 * @return the matching documents
	 */
	public static List<Document> findByUserIdAndTitleAndTags(
		long userId, String title, String tags) {

		return getPersistence().findByUserIdAndTitleAndTags(
			userId, title, tags);
	}

	/**
	 * Returns a range of all the documents where userId = &#63; and title = &#63; and tags = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param tags the tags
	 * @param start the lower bound of the range of documents
	 * @param end the upper bound of the range of documents (not inclusive)
	 * @return the range of matching documents
	 */
	public static List<Document> findByUserIdAndTitleAndTags(
		long userId, String title, String tags, int start, int end) {

		return getPersistence().findByUserIdAndTitleAndTags(
			userId, title, tags, start, end);
	}

	/**
	 * Returns an ordered range of all the documents where userId = &#63; and title = &#63; and tags = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param tags the tags
	 * @param start the lower bound of the range of documents
	 * @param end the upper bound of the range of documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching documents
	 */
	public static List<Document> findByUserIdAndTitleAndTags(
		long userId, String title, String tags, int start, int end,
		OrderByComparator<Document> orderByComparator) {

		return getPersistence().findByUserIdAndTitleAndTags(
			userId, title, tags, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the documents where userId = &#63; and title = &#63; and tags = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param tags the tags
	 * @param start the lower bound of the range of documents
	 * @param end the upper bound of the range of documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching documents
	 */
	public static List<Document> findByUserIdAndTitleAndTags(
		long userId, String title, String tags, int start, int end,
		OrderByComparator<Document> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUserIdAndTitleAndTags(
			userId, title, tags, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first document in the ordered set where userId = &#63; and title = &#63; and tags = &#63;.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param tags the tags
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	public static Document findByUserIdAndTitleAndTags_First(
			long userId, String title, String tags,
			OrderByComparator<Document> orderByComparator)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentException {

		return getPersistence().findByUserIdAndTitleAndTags_First(
			userId, title, tags, orderByComparator);
	}

	/**
	 * Returns the first document in the ordered set where userId = &#63; and title = &#63; and tags = &#63;.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param tags the tags
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document, or <code>null</code> if a matching document could not be found
	 */
	public static Document fetchByUserIdAndTitleAndTags_First(
		long userId, String title, String tags,
		OrderByComparator<Document> orderByComparator) {

		return getPersistence().fetchByUserIdAndTitleAndTags_First(
			userId, title, tags, orderByComparator);
	}

	/**
	 * Returns the last document in the ordered set where userId = &#63; and title = &#63; and tags = &#63;.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param tags the tags
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	public static Document findByUserIdAndTitleAndTags_Last(
			long userId, String title, String tags,
			OrderByComparator<Document> orderByComparator)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentException {

		return getPersistence().findByUserIdAndTitleAndTags_Last(
			userId, title, tags, orderByComparator);
	}

	/**
	 * Returns the last document in the ordered set where userId = &#63; and title = &#63; and tags = &#63;.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param tags the tags
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document, or <code>null</code> if a matching document could not be found
	 */
	public static Document fetchByUserIdAndTitleAndTags_Last(
		long userId, String title, String tags,
		OrderByComparator<Document> orderByComparator) {

		return getPersistence().fetchByUserIdAndTitleAndTags_Last(
			userId, title, tags, orderByComparator);
	}

	/**
	 * Returns the documents before and after the current document in the ordered set where userId = &#63; and title = &#63; and tags = &#63;.
	 *
	 * @param documentId the primary key of the current document
	 * @param userId the user ID
	 * @param title the title
	 * @param tags the tags
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document
	 * @throws NoSuchDocumentException if a document with the primary key could not be found
	 */
	public static Document[] findByUserIdAndTitleAndTags_PrevAndNext(
			long documentId, long userId, String title, String tags,
			OrderByComparator<Document> orderByComparator)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentException {

		return getPersistence().findByUserIdAndTitleAndTags_PrevAndNext(
			documentId, userId, title, tags, orderByComparator);
	}

	/**
	 * Removes all the documents where userId = &#63; and title = &#63; and tags = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param tags the tags
	 */
	public static void removeByUserIdAndTitleAndTags(
		long userId, String title, String tags) {

		getPersistence().removeByUserIdAndTitleAndTags(userId, title, tags);
	}

	/**
	 * Returns the number of documents where userId = &#63; and title = &#63; and tags = &#63;.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param tags the tags
	 * @return the number of matching documents
	 */
	public static int countByUserIdAndTitleAndTags(
		long userId, String title, String tags) {

		return getPersistence().countByUserIdAndTitleAndTags(
			userId, title, tags);
	}

	/**
	 * Returns all the documents where userId = &#63; and filename = &#63;.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @return the matching documents
	 */
	public static List<Document> findByUserIdAndFile(
		long userId, String filename) {

		return getPersistence().findByUserIdAndFile(userId, filename);
	}

	/**
	 * Returns a range of all the documents where userId = &#63; and filename = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param start the lower bound of the range of documents
	 * @param end the upper bound of the range of documents (not inclusive)
	 * @return the range of matching documents
	 */
	public static List<Document> findByUserIdAndFile(
		long userId, String filename, int start, int end) {

		return getPersistence().findByUserIdAndFile(
			userId, filename, start, end);
	}

	/**
	 * Returns an ordered range of all the documents where userId = &#63; and filename = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param start the lower bound of the range of documents
	 * @param end the upper bound of the range of documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching documents
	 */
	public static List<Document> findByUserIdAndFile(
		long userId, String filename, int start, int end,
		OrderByComparator<Document> orderByComparator) {

		return getPersistence().findByUserIdAndFile(
			userId, filename, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the documents where userId = &#63; and filename = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param start the lower bound of the range of documents
	 * @param end the upper bound of the range of documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching documents
	 */
	public static List<Document> findByUserIdAndFile(
		long userId, String filename, int start, int end,
		OrderByComparator<Document> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUserIdAndFile(
			userId, filename, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first document in the ordered set where userId = &#63; and filename = &#63;.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	public static Document findByUserIdAndFile_First(
			long userId, String filename,
			OrderByComparator<Document> orderByComparator)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentException {

		return getPersistence().findByUserIdAndFile_First(
			userId, filename, orderByComparator);
	}

	/**
	 * Returns the first document in the ordered set where userId = &#63; and filename = &#63;.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document, or <code>null</code> if a matching document could not be found
	 */
	public static Document fetchByUserIdAndFile_First(
		long userId, String filename,
		OrderByComparator<Document> orderByComparator) {

		return getPersistence().fetchByUserIdAndFile_First(
			userId, filename, orderByComparator);
	}

	/**
	 * Returns the last document in the ordered set where userId = &#63; and filename = &#63;.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	public static Document findByUserIdAndFile_Last(
			long userId, String filename,
			OrderByComparator<Document> orderByComparator)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentException {

		return getPersistence().findByUserIdAndFile_Last(
			userId, filename, orderByComparator);
	}

	/**
	 * Returns the last document in the ordered set where userId = &#63; and filename = &#63;.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document, or <code>null</code> if a matching document could not be found
	 */
	public static Document fetchByUserIdAndFile_Last(
		long userId, String filename,
		OrderByComparator<Document> orderByComparator) {

		return getPersistence().fetchByUserIdAndFile_Last(
			userId, filename, orderByComparator);
	}

	/**
	 * Returns the documents before and after the current document in the ordered set where userId = &#63; and filename = &#63;.
	 *
	 * @param documentId the primary key of the current document
	 * @param userId the user ID
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document
	 * @throws NoSuchDocumentException if a document with the primary key could not be found
	 */
	public static Document[] findByUserIdAndFile_PrevAndNext(
			long documentId, long userId, String filename,
			OrderByComparator<Document> orderByComparator)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentException {

		return getPersistence().findByUserIdAndFile_PrevAndNext(
			documentId, userId, filename, orderByComparator);
	}

	/**
	 * Removes all the documents where userId = &#63; and filename = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 */
	public static void removeByUserIdAndFile(long userId, String filename) {
		getPersistence().removeByUserIdAndFile(userId, filename);
	}

	/**
	 * Returns the number of documents where userId = &#63; and filename = &#63;.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @return the number of matching documents
	 */
	public static int countByUserIdAndFile(long userId, String filename) {
		return getPersistence().countByUserIdAndFile(userId, filename);
	}

	/**
	 * Returns all the documents where userId = &#63; and filename = &#63; and fileversion = &#63;.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param fileversion the fileversion
	 * @return the matching documents
	 */
	public static List<Document> findByUserIdAndFileFull(
		long userId, String filename, long fileversion) {

		return getPersistence().findByUserIdAndFileFull(
			userId, filename, fileversion);
	}

	/**
	 * Returns a range of all the documents where userId = &#63; and filename = &#63; and fileversion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param fileversion the fileversion
	 * @param start the lower bound of the range of documents
	 * @param end the upper bound of the range of documents (not inclusive)
	 * @return the range of matching documents
	 */
	public static List<Document> findByUserIdAndFileFull(
		long userId, String filename, long fileversion, int start, int end) {

		return getPersistence().findByUserIdAndFileFull(
			userId, filename, fileversion, start, end);
	}

	/**
	 * Returns an ordered range of all the documents where userId = &#63; and filename = &#63; and fileversion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param fileversion the fileversion
	 * @param start the lower bound of the range of documents
	 * @param end the upper bound of the range of documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching documents
	 */
	public static List<Document> findByUserIdAndFileFull(
		long userId, String filename, long fileversion, int start, int end,
		OrderByComparator<Document> orderByComparator) {

		return getPersistence().findByUserIdAndFileFull(
			userId, filename, fileversion, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the documents where userId = &#63; and filename = &#63; and fileversion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param fileversion the fileversion
	 * @param start the lower bound of the range of documents
	 * @param end the upper bound of the range of documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching documents
	 */
	public static List<Document> findByUserIdAndFileFull(
		long userId, String filename, long fileversion, int start, int end,
		OrderByComparator<Document> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUserIdAndFileFull(
			userId, filename, fileversion, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first document in the ordered set where userId = &#63; and filename = &#63; and fileversion = &#63;.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param fileversion the fileversion
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	public static Document findByUserIdAndFileFull_First(
			long userId, String filename, long fileversion,
			OrderByComparator<Document> orderByComparator)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentException {

		return getPersistence().findByUserIdAndFileFull_First(
			userId, filename, fileversion, orderByComparator);
	}

	/**
	 * Returns the first document in the ordered set where userId = &#63; and filename = &#63; and fileversion = &#63;.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param fileversion the fileversion
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document, or <code>null</code> if a matching document could not be found
	 */
	public static Document fetchByUserIdAndFileFull_First(
		long userId, String filename, long fileversion,
		OrderByComparator<Document> orderByComparator) {

		return getPersistence().fetchByUserIdAndFileFull_First(
			userId, filename, fileversion, orderByComparator);
	}

	/**
	 * Returns the last document in the ordered set where userId = &#63; and filename = &#63; and fileversion = &#63;.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param fileversion the fileversion
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	public static Document findByUserIdAndFileFull_Last(
			long userId, String filename, long fileversion,
			OrderByComparator<Document> orderByComparator)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentException {

		return getPersistence().findByUserIdAndFileFull_Last(
			userId, filename, fileversion, orderByComparator);
	}

	/**
	 * Returns the last document in the ordered set where userId = &#63; and filename = &#63; and fileversion = &#63;.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param fileversion the fileversion
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document, or <code>null</code> if a matching document could not be found
	 */
	public static Document fetchByUserIdAndFileFull_Last(
		long userId, String filename, long fileversion,
		OrderByComparator<Document> orderByComparator) {

		return getPersistence().fetchByUserIdAndFileFull_Last(
			userId, filename, fileversion, orderByComparator);
	}

	/**
	 * Returns the documents before and after the current document in the ordered set where userId = &#63; and filename = &#63; and fileversion = &#63;.
	 *
	 * @param documentId the primary key of the current document
	 * @param userId the user ID
	 * @param filename the filename
	 * @param fileversion the fileversion
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document
	 * @throws NoSuchDocumentException if a document with the primary key could not be found
	 */
	public static Document[] findByUserIdAndFileFull_PrevAndNext(
			long documentId, long userId, String filename, long fileversion,
			OrderByComparator<Document> orderByComparator)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentException {

		return getPersistence().findByUserIdAndFileFull_PrevAndNext(
			documentId, userId, filename, fileversion, orderByComparator);
	}

	/**
	 * Removes all the documents where userId = &#63; and filename = &#63; and fileversion = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param fileversion the fileversion
	 */
	public static void removeByUserIdAndFileFull(
		long userId, String filename, long fileversion) {

		getPersistence().removeByUserIdAndFileFull(
			userId, filename, fileversion);
	}

	/**
	 * Returns the number of documents where userId = &#63; and filename = &#63; and fileversion = &#63;.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param fileversion the fileversion
	 * @return the number of matching documents
	 */
	public static int countByUserIdAndFileFull(
		long userId, String filename, long fileversion) {

		return getPersistence().countByUserIdAndFileFull(
			userId, filename, fileversion);
	}

	/**
	 * Caches the document in the entity cache if it is enabled.
	 *
	 * @param document the document
	 */
	public static void cacheResult(Document document) {
		getPersistence().cacheResult(document);
	}

	/**
	 * Caches the documents in the entity cache if it is enabled.
	 *
	 * @param documents the documents
	 */
	public static void cacheResult(List<Document> documents) {
		getPersistence().cacheResult(documents);
	}

	/**
	 * Creates a new document with the primary key. Does not add the document to the database.
	 *
	 * @param documentId the primary key for the new document
	 * @return the new document
	 */
	public static Document create(long documentId) {
		return getPersistence().create(documentId);
	}

	/**
	 * Removes the document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentId the primary key of the document
	 * @return the document that was removed
	 * @throws NoSuchDocumentException if a document with the primary key could not be found
	 */
	public static Document remove(long documentId)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentException {

		return getPersistence().remove(documentId);
	}

	public static Document updateImpl(Document document) {
		return getPersistence().updateImpl(document);
	}

	/**
	 * Returns the document with the primary key or throws a <code>NoSuchDocumentException</code> if it could not be found.
	 *
	 * @param documentId the primary key of the document
	 * @return the document
	 * @throws NoSuchDocumentException if a document with the primary key could not be found
	 */
	public static Document findByPrimaryKey(long documentId)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentException {

		return getPersistence().findByPrimaryKey(documentId);
	}

	/**
	 * Returns the document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentId the primary key of the document
	 * @return the document, or <code>null</code> if a document with the primary key could not be found
	 */
	public static Document fetchByPrimaryKey(long documentId) {
		return getPersistence().fetchByPrimaryKey(documentId);
	}

	/**
	 * Returns all the documents.
	 *
	 * @return the documents
	 */
	public static List<Document> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of documents
	 * @param end the upper bound of the range of documents (not inclusive)
	 * @return the range of documents
	 */
	public static List<Document> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of documents
	 * @param end the upper bound of the range of documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of documents
	 */
	public static List<Document> findAll(
		int start, int end, OrderByComparator<Document> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of documents
	 * @param end the upper bound of the range of documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of documents
	 */
	public static List<Document> findAll(
		int start, int end, OrderByComparator<Document> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the documents from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of documents.
	 *
	 * @return the number of documents
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DocumentPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DocumentPersistence _persistence;

}