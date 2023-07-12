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

package com.liferay.gwenod.gestiondocuments.service.service;

import com.liferay.gwenod.gestiondocuments.service.exception.NoSuchDocumentException;
import com.liferay.gwenod.gestiondocuments.service.model.Document;
import com.liferay.gwenod.gestiondocuments.service.model.DocumentHistory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.io.*;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Document. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DocumentServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DocumentService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.liferay.gwenod.gestiondocuments.service.service.impl.DocumentServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the document remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link DocumentServiceUtil} if injection and service tracking are not available.
	 */
	public Document addDocument(
			java.io.InputStream file, String fileName, String title,
			List<String> tags, String city, String address, String type,
			String description, ServiceContext serviceContext)
		throws PortalException;

	public void deleteAllDocuments();

	public Document deleteUserDocument(
			long documentId, ServiceContext serviceContext)
		throws Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.io.ByteArrayOutputStream getDocumentFile(
			long documentId, ServiceContext serviceContext)
		throws IllegalAccessException, NoSuchDocumentException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DocumentHistory> getDocumentHistory(
			long documentId, ServiceContext serviceContext)
		throws IllegalAccessException, NoSuchDocumentException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Document> getDocumentsByTagsAndTitle(
		String title, String tags, ServiceContext serviceContext);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Document> getUserDocuments(ServiceContext serviceContext);

	public Document updateDocument(
			long documentId, java.io.InputStream file, String title,
			List<String> tags, String city, String address, String description,
			ServiceContext serviceContext)
		throws PortalException;

}