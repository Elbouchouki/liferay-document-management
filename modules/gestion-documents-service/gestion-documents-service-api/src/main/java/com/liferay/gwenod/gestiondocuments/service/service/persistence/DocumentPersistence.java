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

import com.liferay.gwenod.gestiondocuments.service.exception.NoSuchDocumentException;
import com.liferay.gwenod.gestiondocuments.service.model.Document;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentUtil
 * @generated
 */
@ProviderType
public interface DocumentPersistence extends BasePersistence<Document> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DocumentUtil} to access the document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the documents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching documents
	 */
	public java.util.List<Document> findByUuid(String uuid);

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
	public java.util.List<Document> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Document> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Document>
			orderByComparator);

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
	public java.util.List<Document> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Document>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first document in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	public Document findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Document>
				orderByComparator)
		throws NoSuchDocumentException;

	/**
	 * Returns the first document in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document, or <code>null</code> if a matching document could not be found
	 */
	public Document fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Document>
			orderByComparator);

	/**
	 * Returns the last document in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	public Document findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Document>
				orderByComparator)
		throws NoSuchDocumentException;

	/**
	 * Returns the last document in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document, or <code>null</code> if a matching document could not be found
	 */
	public Document fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Document>
			orderByComparator);

	/**
	 * Returns the documents before and after the current document in the ordered set where uuid = &#63;.
	 *
	 * @param documentId the primary key of the current document
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document
	 * @throws NoSuchDocumentException if a document with the primary key could not be found
	 */
	public Document[] findByUuid_PrevAndNext(
			long documentId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Document>
				orderByComparator)
		throws NoSuchDocumentException;

	/**
	 * Removes all the documents where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of documents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching documents
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the document where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDocumentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	public Document findByUUID_G(String uuid, long groupId)
		throws NoSuchDocumentException;

	/**
	 * Returns the document where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching document, or <code>null</code> if a matching document could not be found
	 */
	public Document fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the document where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching document, or <code>null</code> if a matching document could not be found
	 */
	public Document fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the document where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the document that was removed
	 */
	public Document removeByUUID_G(String uuid, long groupId)
		throws NoSuchDocumentException;

	/**
	 * Returns the number of documents where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching documents
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the documents where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching documents
	 */
	public java.util.List<Document> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Document> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Document> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Document>
			orderByComparator);

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
	public java.util.List<Document> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Document>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first document in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	public Document findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Document>
				orderByComparator)
		throws NoSuchDocumentException;

	/**
	 * Returns the first document in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document, or <code>null</code> if a matching document could not be found
	 */
	public Document fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Document>
			orderByComparator);

	/**
	 * Returns the last document in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	public Document findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Document>
				orderByComparator)
		throws NoSuchDocumentException;

	/**
	 * Returns the last document in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document, or <code>null</code> if a matching document could not be found
	 */
	public Document fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Document>
			orderByComparator);

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
	public Document[] findByUuid_C_PrevAndNext(
			long documentId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Document>
				orderByComparator)
		throws NoSuchDocumentException;

	/**
	 * Removes all the documents where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of documents where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching documents
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the documents where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching documents
	 */
	public java.util.List<Document> findByUserId(long userId);

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
	public java.util.List<Document> findByUserId(
		long userId, int start, int end);

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
	public java.util.List<Document> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Document>
			orderByComparator);

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
	public java.util.List<Document> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Document>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first document in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	public Document findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Document>
				orderByComparator)
		throws NoSuchDocumentException;

	/**
	 * Returns the first document in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document, or <code>null</code> if a matching document could not be found
	 */
	public Document fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Document>
			orderByComparator);

	/**
	 * Returns the last document in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	public Document findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Document>
				orderByComparator)
		throws NoSuchDocumentException;

	/**
	 * Returns the last document in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document, or <code>null</code> if a matching document could not be found
	 */
	public Document fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Document>
			orderByComparator);

	/**
	 * Returns the documents before and after the current document in the ordered set where userId = &#63;.
	 *
	 * @param documentId the primary key of the current document
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document
	 * @throws NoSuchDocumentException if a document with the primary key could not be found
	 */
	public Document[] findByUserId_PrevAndNext(
			long documentId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Document>
				orderByComparator)
		throws NoSuchDocumentException;

	/**
	 * Removes all the documents where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of documents where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching documents
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the documents where filename = &#63;.
	 *
	 * @param filename the filename
	 * @return the matching documents
	 */
	public java.util.List<Document> findByFilename(String filename);

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
	public java.util.List<Document> findByFilename(
		String filename, int start, int end);

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
	public java.util.List<Document> findByFilename(
		String filename, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Document>
			orderByComparator);

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
	public java.util.List<Document> findByFilename(
		String filename, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Document>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first document in the ordered set where filename = &#63;.
	 *
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	public Document findByFilename_First(
			String filename,
			com.liferay.portal.kernel.util.OrderByComparator<Document>
				orderByComparator)
		throws NoSuchDocumentException;

	/**
	 * Returns the first document in the ordered set where filename = &#63;.
	 *
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document, or <code>null</code> if a matching document could not be found
	 */
	public Document fetchByFilename_First(
		String filename,
		com.liferay.portal.kernel.util.OrderByComparator<Document>
			orderByComparator);

	/**
	 * Returns the last document in the ordered set where filename = &#63;.
	 *
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	public Document findByFilename_Last(
			String filename,
			com.liferay.portal.kernel.util.OrderByComparator<Document>
				orderByComparator)
		throws NoSuchDocumentException;

	/**
	 * Returns the last document in the ordered set where filename = &#63;.
	 *
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document, or <code>null</code> if a matching document could not be found
	 */
	public Document fetchByFilename_Last(
		String filename,
		com.liferay.portal.kernel.util.OrderByComparator<Document>
			orderByComparator);

	/**
	 * Returns the documents before and after the current document in the ordered set where filename = &#63;.
	 *
	 * @param documentId the primary key of the current document
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document
	 * @throws NoSuchDocumentException if a document with the primary key could not be found
	 */
	public Document[] findByFilename_PrevAndNext(
			long documentId, String filename,
			com.liferay.portal.kernel.util.OrderByComparator<Document>
				orderByComparator)
		throws NoSuchDocumentException;

	/**
	 * Removes all the documents where filename = &#63; from the database.
	 *
	 * @param filename the filename
	 */
	public void removeByFilename(String filename);

	/**
	 * Returns the number of documents where filename = &#63;.
	 *
	 * @param filename the filename
	 * @return the number of matching documents
	 */
	public int countByFilename(String filename);

	/**
	 * Returns all the documents where userId = &#63; and title = &#63; and tags = &#63;.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param tags the tags
	 * @return the matching documents
	 */
	public java.util.List<Document> findByUserIdAndTitleAndTags(
		long userId, String title, String tags);

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
	public java.util.List<Document> findByUserIdAndTitleAndTags(
		long userId, String title, String tags, int start, int end);

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
	public java.util.List<Document> findByUserIdAndTitleAndTags(
		long userId, String title, String tags, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Document>
			orderByComparator);

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
	public java.util.List<Document> findByUserIdAndTitleAndTags(
		long userId, String title, String tags, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Document>
			orderByComparator,
		boolean useFinderCache);

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
	public Document findByUserIdAndTitleAndTags_First(
			long userId, String title, String tags,
			com.liferay.portal.kernel.util.OrderByComparator<Document>
				orderByComparator)
		throws NoSuchDocumentException;

	/**
	 * Returns the first document in the ordered set where userId = &#63; and title = &#63; and tags = &#63;.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param tags the tags
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document, or <code>null</code> if a matching document could not be found
	 */
	public Document fetchByUserIdAndTitleAndTags_First(
		long userId, String title, String tags,
		com.liferay.portal.kernel.util.OrderByComparator<Document>
			orderByComparator);

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
	public Document findByUserIdAndTitleAndTags_Last(
			long userId, String title, String tags,
			com.liferay.portal.kernel.util.OrderByComparator<Document>
				orderByComparator)
		throws NoSuchDocumentException;

	/**
	 * Returns the last document in the ordered set where userId = &#63; and title = &#63; and tags = &#63;.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param tags the tags
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document, or <code>null</code> if a matching document could not be found
	 */
	public Document fetchByUserIdAndTitleAndTags_Last(
		long userId, String title, String tags,
		com.liferay.portal.kernel.util.OrderByComparator<Document>
			orderByComparator);

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
	public Document[] findByUserIdAndTitleAndTags_PrevAndNext(
			long documentId, long userId, String title, String tags,
			com.liferay.portal.kernel.util.OrderByComparator<Document>
				orderByComparator)
		throws NoSuchDocumentException;

	/**
	 * Removes all the documents where userId = &#63; and title = &#63; and tags = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param tags the tags
	 */
	public void removeByUserIdAndTitleAndTags(
		long userId, String title, String tags);

	/**
	 * Returns the number of documents where userId = &#63; and title = &#63; and tags = &#63;.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param tags the tags
	 * @return the number of matching documents
	 */
	public int countByUserIdAndTitleAndTags(
		long userId, String title, String tags);

	/**
	 * Returns all the documents where userId = &#63; and filename = &#63;.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @return the matching documents
	 */
	public java.util.List<Document> findByUserIdAndFile(
		long userId, String filename);

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
	public java.util.List<Document> findByUserIdAndFile(
		long userId, String filename, int start, int end);

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
	public java.util.List<Document> findByUserIdAndFile(
		long userId, String filename, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Document>
			orderByComparator);

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
	public java.util.List<Document> findByUserIdAndFile(
		long userId, String filename, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Document>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first document in the ordered set where userId = &#63; and filename = &#63;.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	public Document findByUserIdAndFile_First(
			long userId, String filename,
			com.liferay.portal.kernel.util.OrderByComparator<Document>
				orderByComparator)
		throws NoSuchDocumentException;

	/**
	 * Returns the first document in the ordered set where userId = &#63; and filename = &#63;.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document, or <code>null</code> if a matching document could not be found
	 */
	public Document fetchByUserIdAndFile_First(
		long userId, String filename,
		com.liferay.portal.kernel.util.OrderByComparator<Document>
			orderByComparator);

	/**
	 * Returns the last document in the ordered set where userId = &#63; and filename = &#63;.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	public Document findByUserIdAndFile_Last(
			long userId, String filename,
			com.liferay.portal.kernel.util.OrderByComparator<Document>
				orderByComparator)
		throws NoSuchDocumentException;

	/**
	 * Returns the last document in the ordered set where userId = &#63; and filename = &#63;.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document, or <code>null</code> if a matching document could not be found
	 */
	public Document fetchByUserIdAndFile_Last(
		long userId, String filename,
		com.liferay.portal.kernel.util.OrderByComparator<Document>
			orderByComparator);

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
	public Document[] findByUserIdAndFile_PrevAndNext(
			long documentId, long userId, String filename,
			com.liferay.portal.kernel.util.OrderByComparator<Document>
				orderByComparator)
		throws NoSuchDocumentException;

	/**
	 * Removes all the documents where userId = &#63; and filename = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 */
	public void removeByUserIdAndFile(long userId, String filename);

	/**
	 * Returns the number of documents where userId = &#63; and filename = &#63;.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @return the number of matching documents
	 */
	public int countByUserIdAndFile(long userId, String filename);

	/**
	 * Returns all the documents where userId = &#63; and filename = &#63; and fileversion = &#63;.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param fileversion the fileversion
	 * @return the matching documents
	 */
	public java.util.List<Document> findByUserIdAndFileFull(
		long userId, String filename, long fileversion);

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
	public java.util.List<Document> findByUserIdAndFileFull(
		long userId, String filename, long fileversion, int start, int end);

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
	public java.util.List<Document> findByUserIdAndFileFull(
		long userId, String filename, long fileversion, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Document>
			orderByComparator);

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
	public java.util.List<Document> findByUserIdAndFileFull(
		long userId, String filename, long fileversion, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Document>
			orderByComparator,
		boolean useFinderCache);

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
	public Document findByUserIdAndFileFull_First(
			long userId, String filename, long fileversion,
			com.liferay.portal.kernel.util.OrderByComparator<Document>
				orderByComparator)
		throws NoSuchDocumentException;

	/**
	 * Returns the first document in the ordered set where userId = &#63; and filename = &#63; and fileversion = &#63;.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param fileversion the fileversion
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document, or <code>null</code> if a matching document could not be found
	 */
	public Document fetchByUserIdAndFileFull_First(
		long userId, String filename, long fileversion,
		com.liferay.portal.kernel.util.OrderByComparator<Document>
			orderByComparator);

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
	public Document findByUserIdAndFileFull_Last(
			long userId, String filename, long fileversion,
			com.liferay.portal.kernel.util.OrderByComparator<Document>
				orderByComparator)
		throws NoSuchDocumentException;

	/**
	 * Returns the last document in the ordered set where userId = &#63; and filename = &#63; and fileversion = &#63;.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param fileversion the fileversion
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document, or <code>null</code> if a matching document could not be found
	 */
	public Document fetchByUserIdAndFileFull_Last(
		long userId, String filename, long fileversion,
		com.liferay.portal.kernel.util.OrderByComparator<Document>
			orderByComparator);

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
	public Document[] findByUserIdAndFileFull_PrevAndNext(
			long documentId, long userId, String filename, long fileversion,
			com.liferay.portal.kernel.util.OrderByComparator<Document>
				orderByComparator)
		throws NoSuchDocumentException;

	/**
	 * Removes all the documents where userId = &#63; and filename = &#63; and fileversion = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param fileversion the fileversion
	 */
	public void removeByUserIdAndFileFull(
		long userId, String filename, long fileversion);

	/**
	 * Returns the number of documents where userId = &#63; and filename = &#63; and fileversion = &#63;.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param fileversion the fileversion
	 * @return the number of matching documents
	 */
	public int countByUserIdAndFileFull(
		long userId, String filename, long fileversion);

	/**
	 * Caches the document in the entity cache if it is enabled.
	 *
	 * @param document the document
	 */
	public void cacheResult(Document document);

	/**
	 * Caches the documents in the entity cache if it is enabled.
	 *
	 * @param documents the documents
	 */
	public void cacheResult(java.util.List<Document> documents);

	/**
	 * Creates a new document with the primary key. Does not add the document to the database.
	 *
	 * @param documentId the primary key for the new document
	 * @return the new document
	 */
	public Document create(long documentId);

	/**
	 * Removes the document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentId the primary key of the document
	 * @return the document that was removed
	 * @throws NoSuchDocumentException if a document with the primary key could not be found
	 */
	public Document remove(long documentId) throws NoSuchDocumentException;

	public Document updateImpl(Document document);

	/**
	 * Returns the document with the primary key or throws a <code>NoSuchDocumentException</code> if it could not be found.
	 *
	 * @param documentId the primary key of the document
	 * @return the document
	 * @throws NoSuchDocumentException if a document with the primary key could not be found
	 */
	public Document findByPrimaryKey(long documentId)
		throws NoSuchDocumentException;

	/**
	 * Returns the document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentId the primary key of the document
	 * @return the document, or <code>null</code> if a document with the primary key could not be found
	 */
	public Document fetchByPrimaryKey(long documentId);

	/**
	 * Returns all the documents.
	 *
	 * @return the documents
	 */
	public java.util.List<Document> findAll();

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
	public java.util.List<Document> findAll(int start, int end);

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
	public java.util.List<Document> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Document>
			orderByComparator);

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
	public java.util.List<Document> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Document>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the documents from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of documents.
	 *
	 * @return the number of documents
	 */
	public int countAll();

}