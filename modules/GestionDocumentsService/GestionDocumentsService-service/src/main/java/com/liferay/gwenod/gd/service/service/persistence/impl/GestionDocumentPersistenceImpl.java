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

package com.liferay.gwenod.gd.service.service.persistence.impl;

import com.liferay.gwenod.gd.service.exception.NoSuchGestionDocumentException;
import com.liferay.gwenod.gd.service.model.GestionDocument;
import com.liferay.gwenod.gd.service.model.GestionDocumentTable;
import com.liferay.gwenod.gd.service.model.impl.GestionDocumentImpl;
import com.liferay.gwenod.gd.service.model.impl.GestionDocumentModelImpl;
import com.liferay.gwenod.gd.service.service.persistence.GestionDocumentPersistence;
import com.liferay.gwenod.gd.service.service.persistence.GestionDocumentUtil;
import com.liferay.gwenod.gd.service.service.persistence.impl.constants.GestionDocumentPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the gestion document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = GestionDocumentPersistence.class)
public class GestionDocumentPersistenceImpl
	extends BasePersistenceImpl<GestionDocument>
	implements GestionDocumentPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>GestionDocumentUtil</code> to access the gestion document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		GestionDocumentImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public GestionDocumentPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(GestionDocument.class);

		setModelImplClass(GestionDocumentImpl.class);
		setModelPKClass(long.class);

		setTable(GestionDocumentTable.INSTANCE);
	}

	/**
	 * Caches the gestion document in the entity cache if it is enabled.
	 *
	 * @param gestionDocument the gestion document
	 */
	@Override
	public void cacheResult(GestionDocument gestionDocument) {
		entityCache.putResult(
			GestionDocumentImpl.class, gestionDocument.getPrimaryKey(),
			gestionDocument);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the gestion documents in the entity cache if it is enabled.
	 *
	 * @param gestionDocuments the gestion documents
	 */
	@Override
	public void cacheResult(List<GestionDocument> gestionDocuments) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (gestionDocuments.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (GestionDocument gestionDocument : gestionDocuments) {
			if (entityCache.getResult(
					GestionDocumentImpl.class,
					gestionDocument.getPrimaryKey()) == null) {

				cacheResult(gestionDocument);
			}
		}
	}

	/**
	 * Clears the cache for all gestion documents.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GestionDocumentImpl.class);

		finderCache.clearCache(GestionDocumentImpl.class);
	}

	/**
	 * Clears the cache for the gestion document.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GestionDocument gestionDocument) {
		entityCache.removeResult(GestionDocumentImpl.class, gestionDocument);
	}

	@Override
	public void clearCache(List<GestionDocument> gestionDocuments) {
		for (GestionDocument gestionDocument : gestionDocuments) {
			entityCache.removeResult(
				GestionDocumentImpl.class, gestionDocument);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(GestionDocumentImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(GestionDocumentImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new gestion document with the primary key. Does not add the gestion document to the database.
	 *
	 * @param id the primary key for the new gestion document
	 * @return the new gestion document
	 */
	@Override
	public GestionDocument create(long id) {
		GestionDocument gestionDocument = new GestionDocumentImpl();

		gestionDocument.setNew(true);
		gestionDocument.setPrimaryKey(id);

		return gestionDocument;
	}

	/**
	 * Removes the gestion document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the gestion document
	 * @return the gestion document that was removed
	 * @throws NoSuchGestionDocumentException if a gestion document with the primary key could not be found
	 */
	@Override
	public GestionDocument remove(long id)
		throws NoSuchGestionDocumentException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the gestion document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the gestion document
	 * @return the gestion document that was removed
	 * @throws NoSuchGestionDocumentException if a gestion document with the primary key could not be found
	 */
	@Override
	public GestionDocument remove(Serializable primaryKey)
		throws NoSuchGestionDocumentException {

		Session session = null;

		try {
			session = openSession();

			GestionDocument gestionDocument = (GestionDocument)session.get(
				GestionDocumentImpl.class, primaryKey);

			if (gestionDocument == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGestionDocumentException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(gestionDocument);
		}
		catch (NoSuchGestionDocumentException noSuchEntityException) {
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
	protected GestionDocument removeImpl(GestionDocument gestionDocument) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gestionDocument)) {
				gestionDocument = (GestionDocument)session.get(
					GestionDocumentImpl.class,
					gestionDocument.getPrimaryKeyObj());
			}

			if (gestionDocument != null) {
				session.delete(gestionDocument);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (gestionDocument != null) {
			clearCache(gestionDocument);
		}

		return gestionDocument;
	}

	@Override
	public GestionDocument updateImpl(GestionDocument gestionDocument) {
		boolean isNew = gestionDocument.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(gestionDocument);
			}
			else {
				gestionDocument = (GestionDocument)session.merge(
					gestionDocument);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			GestionDocumentImpl.class, gestionDocument, false, true);

		if (isNew) {
			gestionDocument.setNew(false);
		}

		gestionDocument.resetOriginalValues();

		return gestionDocument;
	}

	/**
	 * Returns the gestion document with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the gestion document
	 * @return the gestion document
	 * @throws NoSuchGestionDocumentException if a gestion document with the primary key could not be found
	 */
	@Override
	public GestionDocument findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGestionDocumentException {

		GestionDocument gestionDocument = fetchByPrimaryKey(primaryKey);

		if (gestionDocument == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGestionDocumentException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return gestionDocument;
	}

	/**
	 * Returns the gestion document with the primary key or throws a <code>NoSuchGestionDocumentException</code> if it could not be found.
	 *
	 * @param id the primary key of the gestion document
	 * @return the gestion document
	 * @throws NoSuchGestionDocumentException if a gestion document with the primary key could not be found
	 */
	@Override
	public GestionDocument findByPrimaryKey(long id)
		throws NoSuchGestionDocumentException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the gestion document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the gestion document
	 * @return the gestion document, or <code>null</code> if a gestion document with the primary key could not be found
	 */
	@Override
	public GestionDocument fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the gestion documents.
	 *
	 * @return the gestion documents
	 */
	@Override
	public List<GestionDocument> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<GestionDocument> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<GestionDocument> findAll(
		int start, int end,
		OrderByComparator<GestionDocument> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<GestionDocument> findAll(
		int start, int end,
		OrderByComparator<GestionDocument> orderByComparator,
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

		List<GestionDocument> list = null;

		if (useFinderCache) {
			list = (List<GestionDocument>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_GESTIONDOCUMENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_GESTIONDOCUMENT;

				sql = sql.concat(GestionDocumentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<GestionDocument>)QueryUtil.list(
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
	 * Removes all the gestion documents from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (GestionDocument gestionDocument : findAll()) {
			remove(gestionDocument);
		}
	}

	/**
	 * Returns the number of gestion documents.
	 *
	 * @return the number of gestion documents
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_GESTIONDOCUMENT);

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
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_GESTIONDOCUMENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GestionDocumentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the gestion document persistence.
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

		_setGestionDocumentUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setGestionDocumentUtilPersistence(null);

		entityCache.removeCache(GestionDocumentImpl.class.getName());
	}

	private void _setGestionDocumentUtilPersistence(
		GestionDocumentPersistence gestionDocumentPersistence) {

		try {
			Field field = GestionDocumentUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, gestionDocumentPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = GestionDocumentPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = GestionDocumentPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = GestionDocumentPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_GESTIONDOCUMENT =
		"SELECT gestionDocument FROM GestionDocument gestionDocument";

	private static final String _SQL_COUNT_GESTIONDOCUMENT =
		"SELECT COUNT(gestionDocument) FROM GestionDocument gestionDocument";

	private static final String _ORDER_BY_ENTITY_ALIAS = "gestionDocument.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No GestionDocument exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		GestionDocumentPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}