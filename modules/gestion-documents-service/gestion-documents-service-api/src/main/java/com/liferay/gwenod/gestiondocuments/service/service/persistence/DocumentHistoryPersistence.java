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

import com.liferay.gwenod.gestiondocuments.service.exception.NoSuchDocumentHistoryException;
import com.liferay.gwenod.gestiondocuments.service.model.DocumentHistory;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the document history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentHistoryUtil
 * @generated
 */
@ProviderType
public interface DocumentHistoryPersistence
	extends BasePersistence<DocumentHistory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DocumentHistoryUtil} to access the document history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the document histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching document histories
	 */
	public java.util.List<DocumentHistory> findByUuid(String uuid);

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
	public java.util.List<DocumentHistory> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<DocumentHistory> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentHistory>
			orderByComparator);

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
	public java.util.List<DocumentHistory> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first document history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document history
	 * @throws NoSuchDocumentHistoryException if a matching document history could not be found
	 */
	public DocumentHistory findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DocumentHistory>
				orderByComparator)
		throws NoSuchDocumentHistoryException;

	/**
	 * Returns the first document history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document history, or <code>null</code> if a matching document history could not be found
	 */
	public DocumentHistory fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentHistory>
			orderByComparator);

	/**
	 * Returns the last document history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document history
	 * @throws NoSuchDocumentHistoryException if a matching document history could not be found
	 */
	public DocumentHistory findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DocumentHistory>
				orderByComparator)
		throws NoSuchDocumentHistoryException;

	/**
	 * Returns the last document history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document history, or <code>null</code> if a matching document history could not be found
	 */
	public DocumentHistory fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentHistory>
			orderByComparator);

	/**
	 * Returns the document histories before and after the current document history in the ordered set where uuid = &#63;.
	 *
	 * @param historyId the primary key of the current document history
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document history
	 * @throws NoSuchDocumentHistoryException if a document history with the primary key could not be found
	 */
	public DocumentHistory[] findByUuid_PrevAndNext(
			long historyId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DocumentHistory>
				orderByComparator)
		throws NoSuchDocumentHistoryException;

	/**
	 * Removes all the document histories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of document histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching document histories
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the document histories where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @return the matching document histories
	 */
	public java.util.List<DocumentHistory> findByDocumentId(long documentId);

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
	public java.util.List<DocumentHistory> findByDocumentId(
		long documentId, int start, int end);

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
	public java.util.List<DocumentHistory> findByDocumentId(
		long documentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentHistory>
			orderByComparator);

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
	public java.util.List<DocumentHistory> findByDocumentId(
		long documentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first document history in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document history
	 * @throws NoSuchDocumentHistoryException if a matching document history could not be found
	 */
	public DocumentHistory findByDocumentId_First(
			long documentId,
			com.liferay.portal.kernel.util.OrderByComparator<DocumentHistory>
				orderByComparator)
		throws NoSuchDocumentHistoryException;

	/**
	 * Returns the first document history in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document history, or <code>null</code> if a matching document history could not be found
	 */
	public DocumentHistory fetchByDocumentId_First(
		long documentId,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentHistory>
			orderByComparator);

	/**
	 * Returns the last document history in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document history
	 * @throws NoSuchDocumentHistoryException if a matching document history could not be found
	 */
	public DocumentHistory findByDocumentId_Last(
			long documentId,
			com.liferay.portal.kernel.util.OrderByComparator<DocumentHistory>
				orderByComparator)
		throws NoSuchDocumentHistoryException;

	/**
	 * Returns the last document history in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document history, or <code>null</code> if a matching document history could not be found
	 */
	public DocumentHistory fetchByDocumentId_Last(
		long documentId,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentHistory>
			orderByComparator);

	/**
	 * Returns the document histories before and after the current document history in the ordered set where documentId = &#63;.
	 *
	 * @param historyId the primary key of the current document history
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document history
	 * @throws NoSuchDocumentHistoryException if a document history with the primary key could not be found
	 */
	public DocumentHistory[] findByDocumentId_PrevAndNext(
			long historyId, long documentId,
			com.liferay.portal.kernel.util.OrderByComparator<DocumentHistory>
				orderByComparator)
		throws NoSuchDocumentHistoryException;

	/**
	 * Removes all the document histories where documentId = &#63; from the database.
	 *
	 * @param documentId the document ID
	 */
	public void removeByDocumentId(long documentId);

	/**
	 * Returns the number of document histories where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @return the number of matching document histories
	 */
	public int countByDocumentId(long documentId);

	/**
	 * Caches the document history in the entity cache if it is enabled.
	 *
	 * @param documentHistory the document history
	 */
	public void cacheResult(DocumentHistory documentHistory);

	/**
	 * Caches the document histories in the entity cache if it is enabled.
	 *
	 * @param documentHistories the document histories
	 */
	public void cacheResult(java.util.List<DocumentHistory> documentHistories);

	/**
	 * Creates a new document history with the primary key. Does not add the document history to the database.
	 *
	 * @param historyId the primary key for the new document history
	 * @return the new document history
	 */
	public DocumentHistory create(long historyId);

	/**
	 * Removes the document history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param historyId the primary key of the document history
	 * @return the document history that was removed
	 * @throws NoSuchDocumentHistoryException if a document history with the primary key could not be found
	 */
	public DocumentHistory remove(long historyId)
		throws NoSuchDocumentHistoryException;

	public DocumentHistory updateImpl(DocumentHistory documentHistory);

	/**
	 * Returns the document history with the primary key or throws a <code>NoSuchDocumentHistoryException</code> if it could not be found.
	 *
	 * @param historyId the primary key of the document history
	 * @return the document history
	 * @throws NoSuchDocumentHistoryException if a document history with the primary key could not be found
	 */
	public DocumentHistory findByPrimaryKey(long historyId)
		throws NoSuchDocumentHistoryException;

	/**
	 * Returns the document history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param historyId the primary key of the document history
	 * @return the document history, or <code>null</code> if a document history with the primary key could not be found
	 */
	public DocumentHistory fetchByPrimaryKey(long historyId);

	/**
	 * Returns all the document histories.
	 *
	 * @return the document histories
	 */
	public java.util.List<DocumentHistory> findAll();

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
	public java.util.List<DocumentHistory> findAll(int start, int end);

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
	public java.util.List<DocumentHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentHistory>
			orderByComparator);

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
	public java.util.List<DocumentHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the document histories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of document histories.
	 *
	 * @return the number of document histories
	 */
	public int countAll();

}