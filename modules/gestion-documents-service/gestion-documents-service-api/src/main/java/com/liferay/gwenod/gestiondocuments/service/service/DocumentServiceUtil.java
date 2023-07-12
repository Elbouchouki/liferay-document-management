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

import com.liferay.gwenod.gestiondocuments.service.model.Document;
import com.liferay.portal.kernel.exception.PortalException;

import java.io.InputStream;

import java.util.List;

/**
 * Provides the remote service utility for Document. This utility wraps
 * <code>com.liferay.gwenod.gestiondocuments.service.service.impl.DocumentServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DocumentService
 * @generated
 */
public class DocumentServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.gwenod.gestiondocuments.service.service.impl.DocumentServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Document addDocument(
			InputStream file, String fileName, String title, List<String> tags,
			String city, String address, String type, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addDocument(
			file, fileName, title, tags, city, address, type, description,
			serviceContext);
	}

	public static void deleteAllDocuments() {
		getService().deleteAllDocuments();
	}

	public static Document deleteUserDocument(
			long documentId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws Exception {

		return getService().deleteUserDocument(documentId, serviceContext);
	}

	public static java.io.ByteArrayOutputStream getDocumentFile(
			long documentId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentException,
			   IllegalAccessException {

		return getService().getDocumentFile(documentId, serviceContext);
	}

	public static List
		<com.liferay.gwenod.gestiondocuments.service.model.DocumentHistory>
				getDocumentHistory(
					long documentId,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
			throws com.liferay.gwenod.gestiondocuments.service.exception.
				NoSuchDocumentException,
				   IllegalAccessException {

		return getService().getDocumentHistory(documentId, serviceContext);
	}

	public static List<Document> getDocumentsByTagsAndTitle(
		String title, String tags,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().getDocumentsByTagsAndTitle(
			title, tags, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static List<Document> getUserDocuments(
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().getUserDocuments(serviceContext);
	}

	public static Document updateDocument(
			long documentId, InputStream file, String title, List<String> tags,
			String city, String address, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateDocument(
			documentId, file, title, tags, city, address, description,
			serviceContext);
	}

	public static DocumentService getService() {
		return _service;
	}

	private static volatile DocumentService _service;

}