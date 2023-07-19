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

import com.liferay.gwenod.gd.service.exception.NoSuchGestionDocumentException;
import com.liferay.gwenod.gd.service.model.GestionDocument;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the gestion document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GestionDocumentUtil
 * @generated
 */
@ProviderType
public interface GestionDocumentPersistence
	extends BasePersistence<GestionDocument> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GestionDocumentUtil} to access the gestion document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the gestion document in the entity cache if it is enabled.
	 *
	 * @param gestionDocument the gestion document
	 */
	public void cacheResult(GestionDocument gestionDocument);

	/**
	 * Caches the gestion documents in the entity cache if it is enabled.
	 *
	 * @param gestionDocuments the gestion documents
	 */
	public void cacheResult(java.util.List<GestionDocument> gestionDocuments);

	/**
	 * Creates a new gestion document with the primary key. Does not add the gestion document to the database.
	 *
	 * @param id the primary key for the new gestion document
	 * @return the new gestion document
	 */
	public GestionDocument create(long id);

	/**
	 * Removes the gestion document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the gestion document
	 * @return the gestion document that was removed
	 * @throws NoSuchGestionDocumentException if a gestion document with the primary key could not be found
	 */
	public GestionDocument remove(long id)
		throws NoSuchGestionDocumentException;

	public GestionDocument updateImpl(GestionDocument gestionDocument);

	/**
	 * Returns the gestion document with the primary key or throws a <code>NoSuchGestionDocumentException</code> if it could not be found.
	 *
	 * @param id the primary key of the gestion document
	 * @return the gestion document
	 * @throws NoSuchGestionDocumentException if a gestion document with the primary key could not be found
	 */
	public GestionDocument findByPrimaryKey(long id)
		throws NoSuchGestionDocumentException;

	/**
	 * Returns the gestion document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the gestion document
	 * @return the gestion document, or <code>null</code> if a gestion document with the primary key could not be found
	 */
	public GestionDocument fetchByPrimaryKey(long id);

	/**
	 * Returns all the gestion documents.
	 *
	 * @return the gestion documents
	 */
	public java.util.List<GestionDocument> findAll();

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
	public java.util.List<GestionDocument> findAll(int start, int end);

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
	public java.util.List<GestionDocument> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GestionDocument>
			orderByComparator);

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
	public java.util.List<GestionDocument> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GestionDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the gestion documents from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of gestion documents.
	 *
	 * @return the number of gestion documents
	 */
	public int countAll();

}