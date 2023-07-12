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

package com.liferay.gwenod.gestiondocuments.service.service.persistence.impl;

import com.liferay.gwenod.gestiondocuments.service.exception.NoSuchDocumentHistoryException;
import com.liferay.gwenod.gestiondocuments.service.model.DocumentHistory;
import com.liferay.gwenod.gestiondocuments.service.model.DocumentHistoryTable;
import com.liferay.gwenod.gestiondocuments.service.model.impl.DocumentHistoryImpl;
import com.liferay.gwenod.gestiondocuments.service.model.impl.DocumentHistoryModelImpl;
import com.liferay.gwenod.gestiondocuments.service.service.persistence.DocumentHistoryPersistence;
import com.liferay.gwenod.gestiondocuments.service.service.persistence.DocumentHistoryUtil;
import com.liferay.gwenod.gestiondocuments.service.service.persistence.impl.constants.DocumentManagementPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the document history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DocumentHistoryPersistence.class)
public class DocumentHistoryPersistenceImpl
	extends BasePersistenceImpl<DocumentHistory>
	implements DocumentHistoryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DocumentHistoryUtil</code> to access the document history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DocumentHistoryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the document histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching document histories
	 */
	@Override
	public List<DocumentHistory> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<DocumentHistory> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<DocumentHistory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DocumentHistory> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<DocumentHistory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DocumentHistory> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<DocumentHistory> list = null;

		if (useFinderCache) {
			list = (List<DocumentHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DocumentHistory documentHistory : list) {
					if (!uuid.equals(documentHistory.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_DOCUMENTHISTORY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DocumentHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<DocumentHistory>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first document history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document history
	 * @throws NoSuchDocumentHistoryException if a matching document history could not be found
	 */
	@Override
	public DocumentHistory findByUuid_First(
			String uuid, OrderByComparator<DocumentHistory> orderByComparator)
		throws NoSuchDocumentHistoryException {

		DocumentHistory documentHistory = fetchByUuid_First(
			uuid, orderByComparator);

		if (documentHistory != null) {
			return documentHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDocumentHistoryException(sb.toString());
	}

	/**
	 * Returns the first document history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document history, or <code>null</code> if a matching document history could not be found
	 */
	@Override
	public DocumentHistory fetchByUuid_First(
		String uuid, OrderByComparator<DocumentHistory> orderByComparator) {

		List<DocumentHistory> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last document history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document history
	 * @throws NoSuchDocumentHistoryException if a matching document history could not be found
	 */
	@Override
	public DocumentHistory findByUuid_Last(
			String uuid, OrderByComparator<DocumentHistory> orderByComparator)
		throws NoSuchDocumentHistoryException {

		DocumentHistory documentHistory = fetchByUuid_Last(
			uuid, orderByComparator);

		if (documentHistory != null) {
			return documentHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDocumentHistoryException(sb.toString());
	}

	/**
	 * Returns the last document history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document history, or <code>null</code> if a matching document history could not be found
	 */
	@Override
	public DocumentHistory fetchByUuid_Last(
		String uuid, OrderByComparator<DocumentHistory> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DocumentHistory> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DocumentHistory[] findByUuid_PrevAndNext(
			long historyId, String uuid,
			OrderByComparator<DocumentHistory> orderByComparator)
		throws NoSuchDocumentHistoryException {

		uuid = Objects.toString(uuid, "");

		DocumentHistory documentHistory = findByPrimaryKey(historyId);

		Session session = null;

		try {
			session = openSession();

			DocumentHistory[] array = new DocumentHistoryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, documentHistory, uuid, orderByComparator, true);

			array[1] = documentHistory;

			array[2] = getByUuid_PrevAndNext(
				session, documentHistory, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DocumentHistory getByUuid_PrevAndNext(
		Session session, DocumentHistory documentHistory, String uuid,
		OrderByComparator<DocumentHistory> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DOCUMENTHISTORY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DocumentHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						documentHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DocumentHistory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the document histories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DocumentHistory documentHistory :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(documentHistory);
		}
	}

	/**
	 * Returns the number of document histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching document histories
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOCUMENTHISTORY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"documentHistory.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(documentHistory.uuid IS NULL OR documentHistory.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByDocumentId;
	private FinderPath _finderPathWithoutPaginationFindByDocumentId;
	private FinderPath _finderPathCountByDocumentId;

	/**
	 * Returns all the document histories where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @return the matching document histories
	 */
	@Override
	public List<DocumentHistory> findByDocumentId(long documentId) {
		return findByDocumentId(
			documentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<DocumentHistory> findByDocumentId(
		long documentId, int start, int end) {

		return findByDocumentId(documentId, start, end, null);
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
	@Override
	public List<DocumentHistory> findByDocumentId(
		long documentId, int start, int end,
		OrderByComparator<DocumentHistory> orderByComparator) {

		return findByDocumentId(
			documentId, start, end, orderByComparator, true);
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
	@Override
	public List<DocumentHistory> findByDocumentId(
		long documentId, int start, int end,
		OrderByComparator<DocumentHistory> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDocumentId;
				finderArgs = new Object[] {documentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDocumentId;
			finderArgs = new Object[] {
				documentId, start, end, orderByComparator
			};
		}

		List<DocumentHistory> list = null;

		if (useFinderCache) {
			list = (List<DocumentHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DocumentHistory documentHistory : list) {
					if (documentId != documentHistory.getDocumentId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_DOCUMENTHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DocumentHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(documentId);

				list = (List<DocumentHistory>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first document history in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document history
	 * @throws NoSuchDocumentHistoryException if a matching document history could not be found
	 */
	@Override
	public DocumentHistory findByDocumentId_First(
			long documentId,
			OrderByComparator<DocumentHistory> orderByComparator)
		throws NoSuchDocumentHistoryException {

		DocumentHistory documentHistory = fetchByDocumentId_First(
			documentId, orderByComparator);

		if (documentHistory != null) {
			return documentHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("documentId=");
		sb.append(documentId);

		sb.append("}");

		throw new NoSuchDocumentHistoryException(sb.toString());
	}

	/**
	 * Returns the first document history in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document history, or <code>null</code> if a matching document history could not be found
	 */
	@Override
	public DocumentHistory fetchByDocumentId_First(
		long documentId, OrderByComparator<DocumentHistory> orderByComparator) {

		List<DocumentHistory> list = findByDocumentId(
			documentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last document history in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document history
	 * @throws NoSuchDocumentHistoryException if a matching document history could not be found
	 */
	@Override
	public DocumentHistory findByDocumentId_Last(
			long documentId,
			OrderByComparator<DocumentHistory> orderByComparator)
		throws NoSuchDocumentHistoryException {

		DocumentHistory documentHistory = fetchByDocumentId_Last(
			documentId, orderByComparator);

		if (documentHistory != null) {
			return documentHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("documentId=");
		sb.append(documentId);

		sb.append("}");

		throw new NoSuchDocumentHistoryException(sb.toString());
	}

	/**
	 * Returns the last document history in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document history, or <code>null</code> if a matching document history could not be found
	 */
	@Override
	public DocumentHistory fetchByDocumentId_Last(
		long documentId, OrderByComparator<DocumentHistory> orderByComparator) {

		int count = countByDocumentId(documentId);

		if (count == 0) {
			return null;
		}

		List<DocumentHistory> list = findByDocumentId(
			documentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DocumentHistory[] findByDocumentId_PrevAndNext(
			long historyId, long documentId,
			OrderByComparator<DocumentHistory> orderByComparator)
		throws NoSuchDocumentHistoryException {

		DocumentHistory documentHistory = findByPrimaryKey(historyId);

		Session session = null;

		try {
			session = openSession();

			DocumentHistory[] array = new DocumentHistoryImpl[3];

			array[0] = getByDocumentId_PrevAndNext(
				session, documentHistory, documentId, orderByComparator, true);

			array[1] = documentHistory;

			array[2] = getByDocumentId_PrevAndNext(
				session, documentHistory, documentId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DocumentHistory getByDocumentId_PrevAndNext(
		Session session, DocumentHistory documentHistory, long documentId,
		OrderByComparator<DocumentHistory> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DOCUMENTHISTORY_WHERE);

		sb.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DocumentHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(documentId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						documentHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DocumentHistory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the document histories where documentId = &#63; from the database.
	 *
	 * @param documentId the document ID
	 */
	@Override
	public void removeByDocumentId(long documentId) {
		for (DocumentHistory documentHistory :
				findByDocumentId(
					documentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(documentHistory);
		}
	}

	/**
	 * Returns the number of document histories where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @return the number of matching document histories
	 */
	@Override
	public int countByDocumentId(long documentId) {
		FinderPath finderPath = _finderPathCountByDocumentId;

		Object[] finderArgs = new Object[] {documentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOCUMENTHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(documentId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DOCUMENTID_DOCUMENTID_2 =
		"documentHistory.documentId = ?";

	public DocumentHistoryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DocumentHistory.class);

		setModelImplClass(DocumentHistoryImpl.class);
		setModelPKClass(long.class);

		setTable(DocumentHistoryTable.INSTANCE);
	}

	/**
	 * Caches the document history in the entity cache if it is enabled.
	 *
	 * @param documentHistory the document history
	 */
	@Override
	public void cacheResult(DocumentHistory documentHistory) {
		entityCache.putResult(
			DocumentHistoryImpl.class, documentHistory.getPrimaryKey(),
			documentHistory);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the document histories in the entity cache if it is enabled.
	 *
	 * @param documentHistories the document histories
	 */
	@Override
	public void cacheResult(List<DocumentHistory> documentHistories) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (documentHistories.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DocumentHistory documentHistory : documentHistories) {
			if (entityCache.getResult(
					DocumentHistoryImpl.class,
					documentHistory.getPrimaryKey()) == null) {

				cacheResult(documentHistory);
			}
		}
	}

	/**
	 * Clears the cache for all document histories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DocumentHistoryImpl.class);

		finderCache.clearCache(DocumentHistoryImpl.class);
	}

	/**
	 * Clears the cache for the document history.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DocumentHistory documentHistory) {
		entityCache.removeResult(DocumentHistoryImpl.class, documentHistory);
	}

	@Override
	public void clearCache(List<DocumentHistory> documentHistories) {
		for (DocumentHistory documentHistory : documentHistories) {
			entityCache.removeResult(
				DocumentHistoryImpl.class, documentHistory);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DocumentHistoryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DocumentHistoryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new document history with the primary key. Does not add the document history to the database.
	 *
	 * @param historyId the primary key for the new document history
	 * @return the new document history
	 */
	@Override
	public DocumentHistory create(long historyId) {
		DocumentHistory documentHistory = new DocumentHistoryImpl();

		documentHistory.setNew(true);
		documentHistory.setPrimaryKey(historyId);

		String uuid = _portalUUID.generate();

		documentHistory.setUuid(uuid);

		return documentHistory;
	}

	/**
	 * Removes the document history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param historyId the primary key of the document history
	 * @return the document history that was removed
	 * @throws NoSuchDocumentHistoryException if a document history with the primary key could not be found
	 */
	@Override
	public DocumentHistory remove(long historyId)
		throws NoSuchDocumentHistoryException {

		return remove((Serializable)historyId);
	}

	/**
	 * Removes the document history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the document history
	 * @return the document history that was removed
	 * @throws NoSuchDocumentHistoryException if a document history with the primary key could not be found
	 */
	@Override
	public DocumentHistory remove(Serializable primaryKey)
		throws NoSuchDocumentHistoryException {

		Session session = null;

		try {
			session = openSession();

			DocumentHistory documentHistory = (DocumentHistory)session.get(
				DocumentHistoryImpl.class, primaryKey);

			if (documentHistory == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDocumentHistoryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(documentHistory);
		}
		catch (NoSuchDocumentHistoryException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected DocumentHistory removeImpl(DocumentHistory documentHistory) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(documentHistory)) {
				documentHistory = (DocumentHistory)session.get(
					DocumentHistoryImpl.class,
					documentHistory.getPrimaryKeyObj());
			}

			if (documentHistory != null) {
				session.delete(documentHistory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (documentHistory != null) {
			clearCache(documentHistory);
		}

		return documentHistory;
	}

	@Override
	public DocumentHistory updateImpl(DocumentHistory documentHistory) {
		boolean isNew = documentHistory.isNew();

		if (!(documentHistory instanceof DocumentHistoryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(documentHistory.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					documentHistory);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in documentHistory proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DocumentHistory implementation " +
					documentHistory.getClass());
		}

		DocumentHistoryModelImpl documentHistoryModelImpl =
			(DocumentHistoryModelImpl)documentHistory;

		if (Validator.isNull(documentHistory.getUuid())) {
			String uuid = _portalUUID.generate();

			documentHistory.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(documentHistory);
			}
			else {
				documentHistory = (DocumentHistory)session.merge(
					documentHistory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DocumentHistoryImpl.class, documentHistoryModelImpl, false, true);

		if (isNew) {
			documentHistory.setNew(false);
		}

		documentHistory.resetOriginalValues();

		return documentHistory;
	}

	/**
	 * Returns the document history with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the document history
	 * @return the document history
	 * @throws NoSuchDocumentHistoryException if a document history with the primary key could not be found
	 */
	@Override
	public DocumentHistory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDocumentHistoryException {

		DocumentHistory documentHistory = fetchByPrimaryKey(primaryKey);

		if (documentHistory == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDocumentHistoryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return documentHistory;
	}

	/**
	 * Returns the document history with the primary key or throws a <code>NoSuchDocumentHistoryException</code> if it could not be found.
	 *
	 * @param historyId the primary key of the document history
	 * @return the document history
	 * @throws NoSuchDocumentHistoryException if a document history with the primary key could not be found
	 */
	@Override
	public DocumentHistory findByPrimaryKey(long historyId)
		throws NoSuchDocumentHistoryException {

		return findByPrimaryKey((Serializable)historyId);
	}

	/**
	 * Returns the document history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param historyId the primary key of the document history
	 * @return the document history, or <code>null</code> if a document history with the primary key could not be found
	 */
	@Override
	public DocumentHistory fetchByPrimaryKey(long historyId) {
		return fetchByPrimaryKey((Serializable)historyId);
	}

	/**
	 * Returns all the document histories.
	 *
	 * @return the document histories
	 */
	@Override
	public List<DocumentHistory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<DocumentHistory> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<DocumentHistory> findAll(
		int start, int end,
		OrderByComparator<DocumentHistory> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<DocumentHistory> findAll(
		int start, int end,
		OrderByComparator<DocumentHistory> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<DocumentHistory> list = null;

		if (useFinderCache) {
			list = (List<DocumentHistory>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DOCUMENTHISTORY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DOCUMENTHISTORY;

				sql = sql.concat(DocumentHistoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DocumentHistory>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the document histories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DocumentHistory documentHistory : findAll()) {
			remove(documentHistory);
		}
	}

	/**
	 * Returns the number of document histories.
	 *
	 * @return the number of document histories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DOCUMENTHISTORY);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "historyId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DOCUMENTHISTORY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DocumentHistoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the document history persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathWithPaginationFindByDocumentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDocumentId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"documentId"}, true);

		_finderPathWithoutPaginationFindByDocumentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDocumentId",
			new String[] {Long.class.getName()}, new String[] {"documentId"},
			true);

		_finderPathCountByDocumentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocumentId",
			new String[] {Long.class.getName()}, new String[] {"documentId"},
			false);

		_setDocumentHistoryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDocumentHistoryUtilPersistence(null);

		entityCache.removeCache(DocumentHistoryImpl.class.getName());
	}

	private void _setDocumentHistoryUtilPersistence(
		DocumentHistoryPersistence documentHistoryPersistence) {

		try {
			Field field = DocumentHistoryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, documentHistoryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = DocumentManagementPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = DocumentManagementPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = DocumentManagementPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_DOCUMENTHISTORY =
		"SELECT documentHistory FROM DocumentHistory documentHistory";

	private static final String _SQL_SELECT_DOCUMENTHISTORY_WHERE =
		"SELECT documentHistory FROM DocumentHistory documentHistory WHERE ";

	private static final String _SQL_COUNT_DOCUMENTHISTORY =
		"SELECT COUNT(documentHistory) FROM DocumentHistory documentHistory";

	private static final String _SQL_COUNT_DOCUMENTHISTORY_WHERE =
		"SELECT COUNT(documentHistory) FROM DocumentHistory documentHistory WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "documentHistory.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DocumentHistory exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DocumentHistory exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DocumentHistoryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}