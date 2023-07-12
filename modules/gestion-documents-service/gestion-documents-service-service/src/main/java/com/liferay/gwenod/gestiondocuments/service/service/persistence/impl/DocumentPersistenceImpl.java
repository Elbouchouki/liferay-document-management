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

import com.liferay.gwenod.gestiondocuments.service.exception.NoSuchDocumentException;
import com.liferay.gwenod.gestiondocuments.service.model.Document;
import com.liferay.gwenod.gestiondocuments.service.model.DocumentTable;
import com.liferay.gwenod.gestiondocuments.service.model.impl.DocumentImpl;
import com.liferay.gwenod.gestiondocuments.service.model.impl.DocumentModelImpl;
import com.liferay.gwenod.gestiondocuments.service.service.persistence.DocumentPersistence;
import com.liferay.gwenod.gestiondocuments.service.service.persistence.DocumentUtil;
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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
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

import java.util.Date;
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
 * The persistence implementation for the document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DocumentPersistence.class)
public class DocumentPersistenceImpl
	extends BasePersistenceImpl<Document> implements DocumentPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DocumentUtil</code> to access the document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DocumentImpl.class.getName();

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
	 * Returns all the documents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching documents
	 */
	@Override
	public List<Document> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Document> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Document> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Document> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Document> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Document> orderByComparator, boolean useFinderCache) {

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

		List<Document> list = null;

		if (useFinderCache) {
			list = (List<Document>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Document document : list) {
					if (!uuid.equals(document.getUuid())) {
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

			sb.append(_SQL_SELECT_DOCUMENT_WHERE);

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
				sb.append(DocumentModelImpl.ORDER_BY_JPQL);
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

				list = (List<Document>)QueryUtil.list(
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
	 * Returns the first document in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	@Override
	public Document findByUuid_First(
			String uuid, OrderByComparator<Document> orderByComparator)
		throws NoSuchDocumentException {

		Document document = fetchByUuid_First(uuid, orderByComparator);

		if (document != null) {
			return document;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDocumentException(sb.toString());
	}

	/**
	 * Returns the first document in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document, or <code>null</code> if a matching document could not be found
	 */
	@Override
	public Document fetchByUuid_First(
		String uuid, OrderByComparator<Document> orderByComparator) {

		List<Document> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last document in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	@Override
	public Document findByUuid_Last(
			String uuid, OrderByComparator<Document> orderByComparator)
		throws NoSuchDocumentException {

		Document document = fetchByUuid_Last(uuid, orderByComparator);

		if (document != null) {
			return document;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDocumentException(sb.toString());
	}

	/**
	 * Returns the last document in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document, or <code>null</code> if a matching document could not be found
	 */
	@Override
	public Document fetchByUuid_Last(
		String uuid, OrderByComparator<Document> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Document> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Document[] findByUuid_PrevAndNext(
			long documentId, String uuid,
			OrderByComparator<Document> orderByComparator)
		throws NoSuchDocumentException {

		uuid = Objects.toString(uuid, "");

		Document document = findByPrimaryKey(documentId);

		Session session = null;

		try {
			session = openSession();

			Document[] array = new DocumentImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, document, uuid, orderByComparator, true);

			array[1] = document;

			array[2] = getByUuid_PrevAndNext(
				session, document, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Document getByUuid_PrevAndNext(
		Session session, Document document, String uuid,
		OrderByComparator<Document> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DOCUMENT_WHERE);

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
			sb.append(DocumentModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(document)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Document> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the documents where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Document document :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(document);
		}
	}

	/**
	 * Returns the number of documents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching documents
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOCUMENT_WHERE);

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
		"document.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(document.uuid IS NULL OR document.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the document where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDocumentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	@Override
	public Document findByUUID_G(String uuid, long groupId)
		throws NoSuchDocumentException {

		Document document = fetchByUUID_G(uuid, groupId);

		if (document == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDocumentException(sb.toString());
		}

		return document;
	}

	/**
	 * Returns the document where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching document, or <code>null</code> if a matching document could not be found
	 */
	@Override
	public Document fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the document where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching document, or <code>null</code> if a matching document could not be found
	 */
	@Override
	public Document fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof Document) {
			Document document = (Document)result;

			if (!Objects.equals(uuid, document.getUuid()) ||
				(groupId != document.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DOCUMENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<Document> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Document document = list.get(0);

					result = document;

					cacheResult(document);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Document)result;
		}
	}

	/**
	 * Removes the document where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the document that was removed
	 */
	@Override
	public Document removeByUUID_G(String uuid, long groupId)
		throws NoSuchDocumentException {

		Document document = findByUUID_G(uuid, groupId);

		return remove(document);
	}

	/**
	 * Returns the number of documents where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching documents
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DOCUMENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"document.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(document.uuid IS NULL OR document.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"document.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the documents where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching documents
	 */
	@Override
	public List<Document> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Document> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Document> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Document> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Document> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Document> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<Document> list = null;

		if (useFinderCache) {
			list = (List<Document>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Document document : list) {
					if (!uuid.equals(document.getUuid()) ||
						(companyId != document.getCompanyId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_DOCUMENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DocumentModelImpl.ORDER_BY_JPQL);
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

				queryPos.add(companyId);

				list = (List<Document>)QueryUtil.list(
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
	 * Returns the first document in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	@Override
	public Document findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Document> orderByComparator)
		throws NoSuchDocumentException {

		Document document = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (document != null) {
			return document;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDocumentException(sb.toString());
	}

	/**
	 * Returns the first document in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document, or <code>null</code> if a matching document could not be found
	 */
	@Override
	public Document fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Document> orderByComparator) {

		List<Document> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Document findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Document> orderByComparator)
		throws NoSuchDocumentException {

		Document document = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (document != null) {
			return document;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDocumentException(sb.toString());
	}

	/**
	 * Returns the last document in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document, or <code>null</code> if a matching document could not be found
	 */
	@Override
	public Document fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Document> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Document> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Document[] findByUuid_C_PrevAndNext(
			long documentId, String uuid, long companyId,
			OrderByComparator<Document> orderByComparator)
		throws NoSuchDocumentException {

		uuid = Objects.toString(uuid, "");

		Document document = findByPrimaryKey(documentId);

		Session session = null;

		try {
			session = openSession();

			Document[] array = new DocumentImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, document, uuid, companyId, orderByComparator, true);

			array[1] = document;

			array[2] = getByUuid_C_PrevAndNext(
				session, document, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Document getByUuid_C_PrevAndNext(
		Session session, Document document, String uuid, long companyId,
		OrderByComparator<Document> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DOCUMENT_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			sb.append(DocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(document)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Document> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the documents where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Document document :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(document);
		}
	}

	/**
	 * Returns the number of documents where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching documents
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DOCUMENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"document.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(document.uuid IS NULL OR document.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"document.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the documents where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching documents
	 */
	@Override
	public List<Document> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Document> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
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
	@Override
	public List<Document> findByUserId(
		long userId, int start, int end,
		OrderByComparator<Document> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
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
	@Override
	public List<Document> findByUserId(
		long userId, int start, int end,
		OrderByComparator<Document> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserId;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<Document> list = null;

		if (useFinderCache) {
			list = (List<Document>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Document document : list) {
					if (userId != document.getUserId()) {
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

			sb.append(_SQL_SELECT_DOCUMENT_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<Document>)QueryUtil.list(
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
	 * Returns the first document in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	@Override
	public Document findByUserId_First(
			long userId, OrderByComparator<Document> orderByComparator)
		throws NoSuchDocumentException {

		Document document = fetchByUserId_First(userId, orderByComparator);

		if (document != null) {
			return document;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchDocumentException(sb.toString());
	}

	/**
	 * Returns the first document in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document, or <code>null</code> if a matching document could not be found
	 */
	@Override
	public Document fetchByUserId_First(
		long userId, OrderByComparator<Document> orderByComparator) {

		List<Document> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last document in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	@Override
	public Document findByUserId_Last(
			long userId, OrderByComparator<Document> orderByComparator)
		throws NoSuchDocumentException {

		Document document = fetchByUserId_Last(userId, orderByComparator);

		if (document != null) {
			return document;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchDocumentException(sb.toString());
	}

	/**
	 * Returns the last document in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document, or <code>null</code> if a matching document could not be found
	 */
	@Override
	public Document fetchByUserId_Last(
		long userId, OrderByComparator<Document> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<Document> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Document[] findByUserId_PrevAndNext(
			long documentId, long userId,
			OrderByComparator<Document> orderByComparator)
		throws NoSuchDocumentException {

		Document document = findByPrimaryKey(documentId);

		Session session = null;

		try {
			session = openSession();

			Document[] array = new DocumentImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, document, userId, orderByComparator, true);

			array[1] = document;

			array[2] = getByUserId_PrevAndNext(
				session, document, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Document getByUserId_PrevAndNext(
		Session session, Document document, long userId,
		OrderByComparator<Document> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DOCUMENT_WHERE);

		sb.append(_FINDER_COLUMN_USERID_USERID_2);

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
			sb.append(DocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(document)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Document> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the documents where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (Document document :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(document);
		}
	}

	/**
	 * Returns the number of documents where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching documents
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOCUMENT_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"document.userId = ?";

	private FinderPath _finderPathWithPaginationFindByFilename;
	private FinderPath _finderPathWithoutPaginationFindByFilename;
	private FinderPath _finderPathCountByFilename;

	/**
	 * Returns all the documents where filename = &#63;.
	 *
	 * @param filename the filename
	 * @return the matching documents
	 */
	@Override
	public List<Document> findByFilename(String filename) {
		return findByFilename(
			filename, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Document> findByFilename(String filename, int start, int end) {
		return findByFilename(filename, start, end, null);
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
	@Override
	public List<Document> findByFilename(
		String filename, int start, int end,
		OrderByComparator<Document> orderByComparator) {

		return findByFilename(filename, start, end, orderByComparator, true);
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
	@Override
	public List<Document> findByFilename(
		String filename, int start, int end,
		OrderByComparator<Document> orderByComparator, boolean useFinderCache) {

		filename = Objects.toString(filename, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFilename;
				finderArgs = new Object[] {filename};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFilename;
			finderArgs = new Object[] {filename, start, end, orderByComparator};
		}

		List<Document> list = null;

		if (useFinderCache) {
			list = (List<Document>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Document document : list) {
					if (!filename.equals(document.getFilename())) {
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

			sb.append(_SQL_SELECT_DOCUMENT_WHERE);

			boolean bindFilename = false;

			if (filename.isEmpty()) {
				sb.append(_FINDER_COLUMN_FILENAME_FILENAME_3);
			}
			else {
				bindFilename = true;

				sb.append(_FINDER_COLUMN_FILENAME_FILENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFilename) {
					queryPos.add(filename);
				}

				list = (List<Document>)QueryUtil.list(
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
	 * Returns the first document in the ordered set where filename = &#63;.
	 *
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	@Override
	public Document findByFilename_First(
			String filename, OrderByComparator<Document> orderByComparator)
		throws NoSuchDocumentException {

		Document document = fetchByFilename_First(filename, orderByComparator);

		if (document != null) {
			return document;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("filename=");
		sb.append(filename);

		sb.append("}");

		throw new NoSuchDocumentException(sb.toString());
	}

	/**
	 * Returns the first document in the ordered set where filename = &#63;.
	 *
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document, or <code>null</code> if a matching document could not be found
	 */
	@Override
	public Document fetchByFilename_First(
		String filename, OrderByComparator<Document> orderByComparator) {

		List<Document> list = findByFilename(filename, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last document in the ordered set where filename = &#63;.
	 *
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	@Override
	public Document findByFilename_Last(
			String filename, OrderByComparator<Document> orderByComparator)
		throws NoSuchDocumentException {

		Document document = fetchByFilename_Last(filename, orderByComparator);

		if (document != null) {
			return document;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("filename=");
		sb.append(filename);

		sb.append("}");

		throw new NoSuchDocumentException(sb.toString());
	}

	/**
	 * Returns the last document in the ordered set where filename = &#63;.
	 *
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document, or <code>null</code> if a matching document could not be found
	 */
	@Override
	public Document fetchByFilename_Last(
		String filename, OrderByComparator<Document> orderByComparator) {

		int count = countByFilename(filename);

		if (count == 0) {
			return null;
		}

		List<Document> list = findByFilename(
			filename, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Document[] findByFilename_PrevAndNext(
			long documentId, String filename,
			OrderByComparator<Document> orderByComparator)
		throws NoSuchDocumentException {

		filename = Objects.toString(filename, "");

		Document document = findByPrimaryKey(documentId);

		Session session = null;

		try {
			session = openSession();

			Document[] array = new DocumentImpl[3];

			array[0] = getByFilename_PrevAndNext(
				session, document, filename, orderByComparator, true);

			array[1] = document;

			array[2] = getByFilename_PrevAndNext(
				session, document, filename, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Document getByFilename_PrevAndNext(
		Session session, Document document, String filename,
		OrderByComparator<Document> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DOCUMENT_WHERE);

		boolean bindFilename = false;

		if (filename.isEmpty()) {
			sb.append(_FINDER_COLUMN_FILENAME_FILENAME_3);
		}
		else {
			bindFilename = true;

			sb.append(_FINDER_COLUMN_FILENAME_FILENAME_2);
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
			sb.append(DocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindFilename) {
			queryPos.add(filename);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(document)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Document> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the documents where filename = &#63; from the database.
	 *
	 * @param filename the filename
	 */
	@Override
	public void removeByFilename(String filename) {
		for (Document document :
				findByFilename(
					filename, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(document);
		}
	}

	/**
	 * Returns the number of documents where filename = &#63;.
	 *
	 * @param filename the filename
	 * @return the number of matching documents
	 */
	@Override
	public int countByFilename(String filename) {
		filename = Objects.toString(filename, "");

		FinderPath finderPath = _finderPathCountByFilename;

		Object[] finderArgs = new Object[] {filename};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOCUMENT_WHERE);

			boolean bindFilename = false;

			if (filename.isEmpty()) {
				sb.append(_FINDER_COLUMN_FILENAME_FILENAME_3);
			}
			else {
				bindFilename = true;

				sb.append(_FINDER_COLUMN_FILENAME_FILENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFilename) {
					queryPos.add(filename);
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

	private static final String _FINDER_COLUMN_FILENAME_FILENAME_2 =
		"document.filename = ?";

	private static final String _FINDER_COLUMN_FILENAME_FILENAME_3 =
		"(document.filename IS NULL OR document.filename = '')";

	private FinderPath _finderPathWithPaginationFindByUserIdAndTitleAndTags;
	private FinderPath _finderPathWithoutPaginationFindByUserIdAndTitleAndTags;
	private FinderPath _finderPathCountByUserIdAndTitleAndTags;

	/**
	 * Returns all the documents where userId = &#63; and title = &#63; and tags = &#63;.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param tags the tags
	 * @return the matching documents
	 */
	@Override
	public List<Document> findByUserIdAndTitleAndTags(
		long userId, String title, String tags) {

		return findByUserIdAndTitleAndTags(
			userId, title, tags, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Document> findByUserIdAndTitleAndTags(
		long userId, String title, String tags, int start, int end) {

		return findByUserIdAndTitleAndTags(
			userId, title, tags, start, end, null);
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
	@Override
	public List<Document> findByUserIdAndTitleAndTags(
		long userId, String title, String tags, int start, int end,
		OrderByComparator<Document> orderByComparator) {

		return findByUserIdAndTitleAndTags(
			userId, title, tags, start, end, orderByComparator, true);
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
	@Override
	public List<Document> findByUserIdAndTitleAndTags(
		long userId, String title, String tags, int start, int end,
		OrderByComparator<Document> orderByComparator, boolean useFinderCache) {

		title = Objects.toString(title, "");
		tags = Objects.toString(tags, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByUserIdAndTitleAndTags;
				finderArgs = new Object[] {userId, title, tags};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserIdAndTitleAndTags;
			finderArgs = new Object[] {
				userId, title, tags, start, end, orderByComparator
			};
		}

		List<Document> list = null;

		if (useFinderCache) {
			list = (List<Document>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Document document : list) {
					if ((userId != document.getUserId()) ||
						!title.equals(document.getTitle()) ||
						!tags.equals(document.getTags())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_DOCUMENT_WHERE);

			sb.append(_FINDER_COLUMN_USERIDANDTITLEANDTAGS_USERID_2);

			boolean bindTitle = false;

			if (title.isEmpty()) {
				sb.append(_FINDER_COLUMN_USERIDANDTITLEANDTAGS_TITLE_3);
			}
			else {
				bindTitle = true;

				sb.append(_FINDER_COLUMN_USERIDANDTITLEANDTAGS_TITLE_2);
			}

			boolean bindTags = false;

			if (tags.isEmpty()) {
				sb.append(_FINDER_COLUMN_USERIDANDTITLEANDTAGS_TAGS_3);
			}
			else {
				bindTags = true;

				sb.append(_FINDER_COLUMN_USERIDANDTITLEANDTAGS_TAGS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				if (bindTitle) {
					queryPos.add(title);
				}

				if (bindTags) {
					queryPos.add(tags);
				}

				list = (List<Document>)QueryUtil.list(
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
	 * Returns the first document in the ordered set where userId = &#63; and title = &#63; and tags = &#63;.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param tags the tags
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	@Override
	public Document findByUserIdAndTitleAndTags_First(
			long userId, String title, String tags,
			OrderByComparator<Document> orderByComparator)
		throws NoSuchDocumentException {

		Document document = fetchByUserIdAndTitleAndTags_First(
			userId, title, tags, orderByComparator);

		if (document != null) {
			return document;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", title=");
		sb.append(title);

		sb.append(", tags=");
		sb.append(tags);

		sb.append("}");

		throw new NoSuchDocumentException(sb.toString());
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
	@Override
	public Document fetchByUserIdAndTitleAndTags_First(
		long userId, String title, String tags,
		OrderByComparator<Document> orderByComparator) {

		List<Document> list = findByUserIdAndTitleAndTags(
			userId, title, tags, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Document findByUserIdAndTitleAndTags_Last(
			long userId, String title, String tags,
			OrderByComparator<Document> orderByComparator)
		throws NoSuchDocumentException {

		Document document = fetchByUserIdAndTitleAndTags_Last(
			userId, title, tags, orderByComparator);

		if (document != null) {
			return document;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", title=");
		sb.append(title);

		sb.append(", tags=");
		sb.append(tags);

		sb.append("}");

		throw new NoSuchDocumentException(sb.toString());
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
	@Override
	public Document fetchByUserIdAndTitleAndTags_Last(
		long userId, String title, String tags,
		OrderByComparator<Document> orderByComparator) {

		int count = countByUserIdAndTitleAndTags(userId, title, tags);

		if (count == 0) {
			return null;
		}

		List<Document> list = findByUserIdAndTitleAndTags(
			userId, title, tags, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Document[] findByUserIdAndTitleAndTags_PrevAndNext(
			long documentId, long userId, String title, String tags,
			OrderByComparator<Document> orderByComparator)
		throws NoSuchDocumentException {

		title = Objects.toString(title, "");
		tags = Objects.toString(tags, "");

		Document document = findByPrimaryKey(documentId);

		Session session = null;

		try {
			session = openSession();

			Document[] array = new DocumentImpl[3];

			array[0] = getByUserIdAndTitleAndTags_PrevAndNext(
				session, document, userId, title, tags, orderByComparator,
				true);

			array[1] = document;

			array[2] = getByUserIdAndTitleAndTags_PrevAndNext(
				session, document, userId, title, tags, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Document getByUserIdAndTitleAndTags_PrevAndNext(
		Session session, Document document, long userId, String title,
		String tags, OrderByComparator<Document> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_DOCUMENT_WHERE);

		sb.append(_FINDER_COLUMN_USERIDANDTITLEANDTAGS_USERID_2);

		boolean bindTitle = false;

		if (title.isEmpty()) {
			sb.append(_FINDER_COLUMN_USERIDANDTITLEANDTAGS_TITLE_3);
		}
		else {
			bindTitle = true;

			sb.append(_FINDER_COLUMN_USERIDANDTITLEANDTAGS_TITLE_2);
		}

		boolean bindTags = false;

		if (tags.isEmpty()) {
			sb.append(_FINDER_COLUMN_USERIDANDTITLEANDTAGS_TAGS_3);
		}
		else {
			bindTags = true;

			sb.append(_FINDER_COLUMN_USERIDANDTITLEANDTAGS_TAGS_2);
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
			sb.append(DocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (bindTitle) {
			queryPos.add(title);
		}

		if (bindTags) {
			queryPos.add(tags);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(document)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Document> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the documents where userId = &#63; and title = &#63; and tags = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param tags the tags
	 */
	@Override
	public void removeByUserIdAndTitleAndTags(
		long userId, String title, String tags) {

		for (Document document :
				findByUserIdAndTitleAndTags(
					userId, title, tags, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(document);
		}
	}

	/**
	 * Returns the number of documents where userId = &#63; and title = &#63; and tags = &#63;.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param tags the tags
	 * @return the number of matching documents
	 */
	@Override
	public int countByUserIdAndTitleAndTags(
		long userId, String title, String tags) {

		title = Objects.toString(title, "");
		tags = Objects.toString(tags, "");

		FinderPath finderPath = _finderPathCountByUserIdAndTitleAndTags;

		Object[] finderArgs = new Object[] {userId, title, tags};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DOCUMENT_WHERE);

			sb.append(_FINDER_COLUMN_USERIDANDTITLEANDTAGS_USERID_2);

			boolean bindTitle = false;

			if (title.isEmpty()) {
				sb.append(_FINDER_COLUMN_USERIDANDTITLEANDTAGS_TITLE_3);
			}
			else {
				bindTitle = true;

				sb.append(_FINDER_COLUMN_USERIDANDTITLEANDTAGS_TITLE_2);
			}

			boolean bindTags = false;

			if (tags.isEmpty()) {
				sb.append(_FINDER_COLUMN_USERIDANDTITLEANDTAGS_TAGS_3);
			}
			else {
				bindTags = true;

				sb.append(_FINDER_COLUMN_USERIDANDTITLEANDTAGS_TAGS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				if (bindTitle) {
					queryPos.add(title);
				}

				if (bindTags) {
					queryPos.add(tags);
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

	private static final String _FINDER_COLUMN_USERIDANDTITLEANDTAGS_USERID_2 =
		"document.userId = ? AND ";

	private static final String _FINDER_COLUMN_USERIDANDTITLEANDTAGS_TITLE_2 =
		"document.title = ? AND ";

	private static final String _FINDER_COLUMN_USERIDANDTITLEANDTAGS_TITLE_3 =
		"(document.title IS NULL OR document.title = '') AND ";

	private static final String _FINDER_COLUMN_USERIDANDTITLEANDTAGS_TAGS_2 =
		"document.tags = ?";

	private static final String _FINDER_COLUMN_USERIDANDTITLEANDTAGS_TAGS_3 =
		"(document.tags IS NULL OR document.tags = '')";

	private FinderPath _finderPathWithPaginationFindByUserIdAndFile;
	private FinderPath _finderPathWithoutPaginationFindByUserIdAndFile;
	private FinderPath _finderPathCountByUserIdAndFile;

	/**
	 * Returns all the documents where userId = &#63; and filename = &#63;.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @return the matching documents
	 */
	@Override
	public List<Document> findByUserIdAndFile(long userId, String filename) {
		return findByUserIdAndFile(
			userId, filename, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Document> findByUserIdAndFile(
		long userId, String filename, int start, int end) {

		return findByUserIdAndFile(userId, filename, start, end, null);
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
	@Override
	public List<Document> findByUserIdAndFile(
		long userId, String filename, int start, int end,
		OrderByComparator<Document> orderByComparator) {

		return findByUserIdAndFile(
			userId, filename, start, end, orderByComparator, true);
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
	@Override
	public List<Document> findByUserIdAndFile(
		long userId, String filename, int start, int end,
		OrderByComparator<Document> orderByComparator, boolean useFinderCache) {

		filename = Objects.toString(filename, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserIdAndFile;
				finderArgs = new Object[] {userId, filename};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserIdAndFile;
			finderArgs = new Object[] {
				userId, filename, start, end, orderByComparator
			};
		}

		List<Document> list = null;

		if (useFinderCache) {
			list = (List<Document>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Document document : list) {
					if ((userId != document.getUserId()) ||
						!filename.equals(document.getFilename())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_DOCUMENT_WHERE);

			sb.append(_FINDER_COLUMN_USERIDANDFILE_USERID_2);

			boolean bindFilename = false;

			if (filename.isEmpty()) {
				sb.append(_FINDER_COLUMN_USERIDANDFILE_FILENAME_3);
			}
			else {
				bindFilename = true;

				sb.append(_FINDER_COLUMN_USERIDANDFILE_FILENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				if (bindFilename) {
					queryPos.add(filename);
				}

				list = (List<Document>)QueryUtil.list(
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
	 * Returns the first document in the ordered set where userId = &#63; and filename = &#63;.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	@Override
	public Document findByUserIdAndFile_First(
			long userId, String filename,
			OrderByComparator<Document> orderByComparator)
		throws NoSuchDocumentException {

		Document document = fetchByUserIdAndFile_First(
			userId, filename, orderByComparator);

		if (document != null) {
			return document;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", filename=");
		sb.append(filename);

		sb.append("}");

		throw new NoSuchDocumentException(sb.toString());
	}

	/**
	 * Returns the first document in the ordered set where userId = &#63; and filename = &#63;.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document, or <code>null</code> if a matching document could not be found
	 */
	@Override
	public Document fetchByUserIdAndFile_First(
		long userId, String filename,
		OrderByComparator<Document> orderByComparator) {

		List<Document> list = findByUserIdAndFile(
			userId, filename, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Document findByUserIdAndFile_Last(
			long userId, String filename,
			OrderByComparator<Document> orderByComparator)
		throws NoSuchDocumentException {

		Document document = fetchByUserIdAndFile_Last(
			userId, filename, orderByComparator);

		if (document != null) {
			return document;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", filename=");
		sb.append(filename);

		sb.append("}");

		throw new NoSuchDocumentException(sb.toString());
	}

	/**
	 * Returns the last document in the ordered set where userId = &#63; and filename = &#63;.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document, or <code>null</code> if a matching document could not be found
	 */
	@Override
	public Document fetchByUserIdAndFile_Last(
		long userId, String filename,
		OrderByComparator<Document> orderByComparator) {

		int count = countByUserIdAndFile(userId, filename);

		if (count == 0) {
			return null;
		}

		List<Document> list = findByUserIdAndFile(
			userId, filename, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Document[] findByUserIdAndFile_PrevAndNext(
			long documentId, long userId, String filename,
			OrderByComparator<Document> orderByComparator)
		throws NoSuchDocumentException {

		filename = Objects.toString(filename, "");

		Document document = findByPrimaryKey(documentId);

		Session session = null;

		try {
			session = openSession();

			Document[] array = new DocumentImpl[3];

			array[0] = getByUserIdAndFile_PrevAndNext(
				session, document, userId, filename, orderByComparator, true);

			array[1] = document;

			array[2] = getByUserIdAndFile_PrevAndNext(
				session, document, userId, filename, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Document getByUserIdAndFile_PrevAndNext(
		Session session, Document document, long userId, String filename,
		OrderByComparator<Document> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DOCUMENT_WHERE);

		sb.append(_FINDER_COLUMN_USERIDANDFILE_USERID_2);

		boolean bindFilename = false;

		if (filename.isEmpty()) {
			sb.append(_FINDER_COLUMN_USERIDANDFILE_FILENAME_3);
		}
		else {
			bindFilename = true;

			sb.append(_FINDER_COLUMN_USERIDANDFILE_FILENAME_2);
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
			sb.append(DocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (bindFilename) {
			queryPos.add(filename);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(document)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Document> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the documents where userId = &#63; and filename = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 */
	@Override
	public void removeByUserIdAndFile(long userId, String filename) {
		for (Document document :
				findByUserIdAndFile(
					userId, filename, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(document);
		}
	}

	/**
	 * Returns the number of documents where userId = &#63; and filename = &#63;.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @return the number of matching documents
	 */
	@Override
	public int countByUserIdAndFile(long userId, String filename) {
		filename = Objects.toString(filename, "");

		FinderPath finderPath = _finderPathCountByUserIdAndFile;

		Object[] finderArgs = new Object[] {userId, filename};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DOCUMENT_WHERE);

			sb.append(_FINDER_COLUMN_USERIDANDFILE_USERID_2);

			boolean bindFilename = false;

			if (filename.isEmpty()) {
				sb.append(_FINDER_COLUMN_USERIDANDFILE_FILENAME_3);
			}
			else {
				bindFilename = true;

				sb.append(_FINDER_COLUMN_USERIDANDFILE_FILENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				if (bindFilename) {
					queryPos.add(filename);
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

	private static final String _FINDER_COLUMN_USERIDANDFILE_USERID_2 =
		"document.userId = ? AND ";

	private static final String _FINDER_COLUMN_USERIDANDFILE_FILENAME_2 =
		"document.filename = ?";

	private static final String _FINDER_COLUMN_USERIDANDFILE_FILENAME_3 =
		"(document.filename IS NULL OR document.filename = '')";

	private FinderPath _finderPathWithPaginationFindByUserIdAndFileFull;
	private FinderPath _finderPathWithoutPaginationFindByUserIdAndFileFull;
	private FinderPath _finderPathCountByUserIdAndFileFull;

	/**
	 * Returns all the documents where userId = &#63; and filename = &#63; and fileversion = &#63;.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param fileversion the fileversion
	 * @return the matching documents
	 */
	@Override
	public List<Document> findByUserIdAndFileFull(
		long userId, String filename, long fileversion) {

		return findByUserIdAndFileFull(
			userId, filename, fileversion, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Document> findByUserIdAndFileFull(
		long userId, String filename, long fileversion, int start, int end) {

		return findByUserIdAndFileFull(
			userId, filename, fileversion, start, end, null);
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
	@Override
	public List<Document> findByUserIdAndFileFull(
		long userId, String filename, long fileversion, int start, int end,
		OrderByComparator<Document> orderByComparator) {

		return findByUserIdAndFileFull(
			userId, filename, fileversion, start, end, orderByComparator, true);
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
	@Override
	public List<Document> findByUserIdAndFileFull(
		long userId, String filename, long fileversion, int start, int end,
		OrderByComparator<Document> orderByComparator, boolean useFinderCache) {

		filename = Objects.toString(filename, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByUserIdAndFileFull;
				finderArgs = new Object[] {userId, filename, fileversion};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserIdAndFileFull;
			finderArgs = new Object[] {
				userId, filename, fileversion, start, end, orderByComparator
			};
		}

		List<Document> list = null;

		if (useFinderCache) {
			list = (List<Document>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Document document : list) {
					if ((userId != document.getUserId()) ||
						!filename.equals(document.getFilename()) ||
						(fileversion != document.getFileversion())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_DOCUMENT_WHERE);

			sb.append(_FINDER_COLUMN_USERIDANDFILEFULL_USERID_2);

			boolean bindFilename = false;

			if (filename.isEmpty()) {
				sb.append(_FINDER_COLUMN_USERIDANDFILEFULL_FILENAME_3);
			}
			else {
				bindFilename = true;

				sb.append(_FINDER_COLUMN_USERIDANDFILEFULL_FILENAME_2);
			}

			sb.append(_FINDER_COLUMN_USERIDANDFILEFULL_FILEVERSION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				if (bindFilename) {
					queryPos.add(filename);
				}

				queryPos.add(fileversion);

				list = (List<Document>)QueryUtil.list(
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
	 * Returns the first document in the ordered set where userId = &#63; and filename = &#63; and fileversion = &#63;.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param fileversion the fileversion
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document
	 * @throws NoSuchDocumentException if a matching document could not be found
	 */
	@Override
	public Document findByUserIdAndFileFull_First(
			long userId, String filename, long fileversion,
			OrderByComparator<Document> orderByComparator)
		throws NoSuchDocumentException {

		Document document = fetchByUserIdAndFileFull_First(
			userId, filename, fileversion, orderByComparator);

		if (document != null) {
			return document;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", filename=");
		sb.append(filename);

		sb.append(", fileversion=");
		sb.append(fileversion);

		sb.append("}");

		throw new NoSuchDocumentException(sb.toString());
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
	@Override
	public Document fetchByUserIdAndFileFull_First(
		long userId, String filename, long fileversion,
		OrderByComparator<Document> orderByComparator) {

		List<Document> list = findByUserIdAndFileFull(
			userId, filename, fileversion, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Document findByUserIdAndFileFull_Last(
			long userId, String filename, long fileversion,
			OrderByComparator<Document> orderByComparator)
		throws NoSuchDocumentException {

		Document document = fetchByUserIdAndFileFull_Last(
			userId, filename, fileversion, orderByComparator);

		if (document != null) {
			return document;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", filename=");
		sb.append(filename);

		sb.append(", fileversion=");
		sb.append(fileversion);

		sb.append("}");

		throw new NoSuchDocumentException(sb.toString());
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
	@Override
	public Document fetchByUserIdAndFileFull_Last(
		long userId, String filename, long fileversion,
		OrderByComparator<Document> orderByComparator) {

		int count = countByUserIdAndFileFull(userId, filename, fileversion);

		if (count == 0) {
			return null;
		}

		List<Document> list = findByUserIdAndFileFull(
			userId, filename, fileversion, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Document[] findByUserIdAndFileFull_PrevAndNext(
			long documentId, long userId, String filename, long fileversion,
			OrderByComparator<Document> orderByComparator)
		throws NoSuchDocumentException {

		filename = Objects.toString(filename, "");

		Document document = findByPrimaryKey(documentId);

		Session session = null;

		try {
			session = openSession();

			Document[] array = new DocumentImpl[3];

			array[0] = getByUserIdAndFileFull_PrevAndNext(
				session, document, userId, filename, fileversion,
				orderByComparator, true);

			array[1] = document;

			array[2] = getByUserIdAndFileFull_PrevAndNext(
				session, document, userId, filename, fileversion,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Document getByUserIdAndFileFull_PrevAndNext(
		Session session, Document document, long userId, String filename,
		long fileversion, OrderByComparator<Document> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_DOCUMENT_WHERE);

		sb.append(_FINDER_COLUMN_USERIDANDFILEFULL_USERID_2);

		boolean bindFilename = false;

		if (filename.isEmpty()) {
			sb.append(_FINDER_COLUMN_USERIDANDFILEFULL_FILENAME_3);
		}
		else {
			bindFilename = true;

			sb.append(_FINDER_COLUMN_USERIDANDFILEFULL_FILENAME_2);
		}

		sb.append(_FINDER_COLUMN_USERIDANDFILEFULL_FILEVERSION_2);

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
			sb.append(DocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (bindFilename) {
			queryPos.add(filename);
		}

		queryPos.add(fileversion);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(document)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Document> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the documents where userId = &#63; and filename = &#63; and fileversion = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param fileversion the fileversion
	 */
	@Override
	public void removeByUserIdAndFileFull(
		long userId, String filename, long fileversion) {

		for (Document document :
				findByUserIdAndFileFull(
					userId, filename, fileversion, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(document);
		}
	}

	/**
	 * Returns the number of documents where userId = &#63; and filename = &#63; and fileversion = &#63;.
	 *
	 * @param userId the user ID
	 * @param filename the filename
	 * @param fileversion the fileversion
	 * @return the number of matching documents
	 */
	@Override
	public int countByUserIdAndFileFull(
		long userId, String filename, long fileversion) {

		filename = Objects.toString(filename, "");

		FinderPath finderPath = _finderPathCountByUserIdAndFileFull;

		Object[] finderArgs = new Object[] {userId, filename, fileversion};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DOCUMENT_WHERE);

			sb.append(_FINDER_COLUMN_USERIDANDFILEFULL_USERID_2);

			boolean bindFilename = false;

			if (filename.isEmpty()) {
				sb.append(_FINDER_COLUMN_USERIDANDFILEFULL_FILENAME_3);
			}
			else {
				bindFilename = true;

				sb.append(_FINDER_COLUMN_USERIDANDFILEFULL_FILENAME_2);
			}

			sb.append(_FINDER_COLUMN_USERIDANDFILEFULL_FILEVERSION_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				if (bindFilename) {
					queryPos.add(filename);
				}

				queryPos.add(fileversion);

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

	private static final String _FINDER_COLUMN_USERIDANDFILEFULL_USERID_2 =
		"document.userId = ? AND ";

	private static final String _FINDER_COLUMN_USERIDANDFILEFULL_FILENAME_2 =
		"document.filename = ? AND ";

	private static final String _FINDER_COLUMN_USERIDANDFILEFULL_FILENAME_3 =
		"(document.filename IS NULL OR document.filename = '') AND ";

	private static final String _FINDER_COLUMN_USERIDANDFILEFULL_FILEVERSION_2 =
		"document.fileversion = ?";

	public DocumentPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Document.class);

		setModelImplClass(DocumentImpl.class);
		setModelPKClass(long.class);

		setTable(DocumentTable.INSTANCE);
	}

	/**
	 * Caches the document in the entity cache if it is enabled.
	 *
	 * @param document the document
	 */
	@Override
	public void cacheResult(Document document) {
		entityCache.putResult(
			DocumentImpl.class, document.getPrimaryKey(), document);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {document.getUuid(), document.getGroupId()}, document);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the documents in the entity cache if it is enabled.
	 *
	 * @param documents the documents
	 */
	@Override
	public void cacheResult(List<Document> documents) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (documents.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Document document : documents) {
			if (entityCache.getResult(
					DocumentImpl.class, document.getPrimaryKey()) == null) {

				cacheResult(document);
			}
		}
	}

	/**
	 * Clears the cache for all documents.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DocumentImpl.class);

		finderCache.clearCache(DocumentImpl.class);
	}

	/**
	 * Clears the cache for the document.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Document document) {
		entityCache.removeResult(DocumentImpl.class, document);
	}

	@Override
	public void clearCache(List<Document> documents) {
		for (Document document : documents) {
			entityCache.removeResult(DocumentImpl.class, document);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DocumentImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DocumentImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DocumentModelImpl documentModelImpl) {

		Object[] args = new Object[] {
			documentModelImpl.getUuid(), documentModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, documentModelImpl);
	}

	/**
	 * Creates a new document with the primary key. Does not add the document to the database.
	 *
	 * @param documentId the primary key for the new document
	 * @return the new document
	 */
	@Override
	public Document create(long documentId) {
		Document document = new DocumentImpl();

		document.setNew(true);
		document.setPrimaryKey(documentId);

		String uuid = _portalUUID.generate();

		document.setUuid(uuid);

		document.setCompanyId(CompanyThreadLocal.getCompanyId());

		return document;
	}

	/**
	 * Removes the document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentId the primary key of the document
	 * @return the document that was removed
	 * @throws NoSuchDocumentException if a document with the primary key could not be found
	 */
	@Override
	public Document remove(long documentId) throws NoSuchDocumentException {
		return remove((Serializable)documentId);
	}

	/**
	 * Removes the document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the document
	 * @return the document that was removed
	 * @throws NoSuchDocumentException if a document with the primary key could not be found
	 */
	@Override
	public Document remove(Serializable primaryKey)
		throws NoSuchDocumentException {

		Session session = null;

		try {
			session = openSession();

			Document document = (Document)session.get(
				DocumentImpl.class, primaryKey);

			if (document == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDocumentException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(document);
		}
		catch (NoSuchDocumentException noSuchEntityException) {
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
	protected Document removeImpl(Document document) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(document)) {
				document = (Document)session.get(
					DocumentImpl.class, document.getPrimaryKeyObj());
			}

			if (document != null) {
				session.delete(document);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (document != null) {
			clearCache(document);
		}

		return document;
	}

	@Override
	public Document updateImpl(Document document) {
		boolean isNew = document.isNew();

		if (!(document instanceof DocumentModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(document.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(document);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in document proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Document implementation " +
					document.getClass());
		}

		DocumentModelImpl documentModelImpl = (DocumentModelImpl)document;

		if (Validator.isNull(document.getUuid())) {
			String uuid = _portalUUID.generate();

			document.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (document.getCreateDate() == null)) {
			if (serviceContext == null) {
				document.setCreateDate(date);
			}
			else {
				document.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!documentModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				document.setModifiedDate(date);
			}
			else {
				document.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(document);
			}
			else {
				document = (Document)session.merge(document);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DocumentImpl.class, documentModelImpl, false, true);

		cacheUniqueFindersCache(documentModelImpl);

		if (isNew) {
			document.setNew(false);
		}

		document.resetOriginalValues();

		return document;
	}

	/**
	 * Returns the document with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the document
	 * @return the document
	 * @throws NoSuchDocumentException if a document with the primary key could not be found
	 */
	@Override
	public Document findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDocumentException {

		Document document = fetchByPrimaryKey(primaryKey);

		if (document == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDocumentException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return document;
	}

	/**
	 * Returns the document with the primary key or throws a <code>NoSuchDocumentException</code> if it could not be found.
	 *
	 * @param documentId the primary key of the document
	 * @return the document
	 * @throws NoSuchDocumentException if a document with the primary key could not be found
	 */
	@Override
	public Document findByPrimaryKey(long documentId)
		throws NoSuchDocumentException {

		return findByPrimaryKey((Serializable)documentId);
	}

	/**
	 * Returns the document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentId the primary key of the document
	 * @return the document, or <code>null</code> if a document with the primary key could not be found
	 */
	@Override
	public Document fetchByPrimaryKey(long documentId) {
		return fetchByPrimaryKey((Serializable)documentId);
	}

	/**
	 * Returns all the documents.
	 *
	 * @return the documents
	 */
	@Override
	public List<Document> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Document> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Document> findAll(
		int start, int end, OrderByComparator<Document> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Document> findAll(
		int start, int end, OrderByComparator<Document> orderByComparator,
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

		List<Document> list = null;

		if (useFinderCache) {
			list = (List<Document>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DOCUMENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DOCUMENT;

				sql = sql.concat(DocumentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Document>)QueryUtil.list(
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
	 * Removes all the documents from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Document document : findAll()) {
			remove(document);
		}
	}

	/**
	 * Returns the number of documents.
	 *
	 * @return the number of documents
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DOCUMENT);

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
		return "documentId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DOCUMENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DocumentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the document persistence.
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

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userId"}, true);

		_finderPathWithoutPaginationFindByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		_finderPathWithPaginationFindByFilename = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFilename",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"filename"}, true);

		_finderPathWithoutPaginationFindByFilename = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFilename",
			new String[] {String.class.getName()}, new String[] {"filename"},
			true);

		_finderPathCountByFilename = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFilename",
			new String[] {String.class.getName()}, new String[] {"filename"},
			false);

		_finderPathWithPaginationFindByUserIdAndTitleAndTags = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserIdAndTitleAndTags",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userId", "title", "tags"}, true);

		_finderPathWithoutPaginationFindByUserIdAndTitleAndTags =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByUserIdAndTitleAndTags",
				new String[] {
					Long.class.getName(), String.class.getName(),
					String.class.getName()
				},
				new String[] {"userId", "title", "tags"}, true);

		_finderPathCountByUserIdAndTitleAndTags = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdAndTitleAndTags",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"userId", "title", "tags"}, false);

		_finderPathWithPaginationFindByUserIdAndFile = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserIdAndFile",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"userId", "filename"}, true);

		_finderPathWithoutPaginationFindByUserIdAndFile = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserIdAndFile",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"userId", "filename"}, true);

		_finderPathCountByUserIdAndFile = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserIdAndFile",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"userId", "filename"}, false);

		_finderPathWithPaginationFindByUserIdAndFileFull = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserIdAndFileFull",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userId", "filename", "fileversion"}, true);

		_finderPathWithoutPaginationFindByUserIdAndFileFull = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserIdAndFileFull",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			new String[] {"userId", "filename", "fileversion"}, true);

		_finderPathCountByUserIdAndFileFull = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdAndFileFull",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			new String[] {"userId", "filename", "fileversion"}, false);

		_setDocumentUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDocumentUtilPersistence(null);

		entityCache.removeCache(DocumentImpl.class.getName());
	}

	private void _setDocumentUtilPersistence(
		DocumentPersistence documentPersistence) {

		try {
			Field field = DocumentUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, documentPersistence);
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

	private static final String _SQL_SELECT_DOCUMENT =
		"SELECT document FROM Document document";

	private static final String _SQL_SELECT_DOCUMENT_WHERE =
		"SELECT document FROM Document document WHERE ";

	private static final String _SQL_COUNT_DOCUMENT =
		"SELECT COUNT(document) FROM Document document";

	private static final String _SQL_COUNT_DOCUMENT_WHERE =
		"SELECT COUNT(document) FROM Document document WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "document.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Document exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Document exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DocumentPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "type"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}