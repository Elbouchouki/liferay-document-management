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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DocumentService}.
 *
 * @author Brian Wing Shun Chan
 * @see DocumentService
 * @generated
 */
public class DocumentServiceWrapper
	implements DocumentService, ServiceWrapper<DocumentService> {

	public DocumentServiceWrapper() {
		this(null);
	}

	public DocumentServiceWrapper(DocumentService documentService) {
		_documentService = documentService;
	}

	@Override
	public com.liferay.gwenod.gestiondocuments.service.model.Document
			addDocument(
				java.io.InputStream file, String fileName, String title,
				java.util.List<String> tags, String city, String address,
				String type, String description,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentService.addDocument(
			file, fileName, title, tags, city, address, type, description,
			serviceContext);
	}

	@Override
	public void deleteAllDocuments() {
		_documentService.deleteAllDocuments();
	}

	@Override
	public com.liferay.gwenod.gestiondocuments.service.model.Document
			deleteUserDocument(
				long documentId,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws Exception {

		return _documentService.deleteUserDocument(documentId, serviceContext);
	}

	@Override
	public java.io.ByteArrayOutputStream getDocumentFile(
			long documentId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentException,
			   IllegalAccessException {

		return _documentService.getDocumentFile(documentId, serviceContext);
	}

	@Override
	public java.util.List
		<com.liferay.gwenod.gestiondocuments.service.model.DocumentHistory>
				getDocumentHistory(
					long documentId,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
			throws com.liferay.gwenod.gestiondocuments.service.exception.
				NoSuchDocumentException,
				   IllegalAccessException {

		return _documentService.getDocumentHistory(documentId, serviceContext);
	}

	@Override
	public java.util.List
		<com.liferay.gwenod.gestiondocuments.service.model.Document>
			getDocumentsByTagsAndTitle(
				String title, String tags,
				com.liferay.portal.kernel.service.ServiceContext
					serviceContext) {

		return _documentService.getDocumentsByTagsAndTitle(
			title, tags, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _documentService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List
		<com.liferay.gwenod.gestiondocuments.service.model.Document>
			getUserDocuments(
				com.liferay.portal.kernel.service.ServiceContext
					serviceContext) {

		return _documentService.getUserDocuments(serviceContext);
	}

	@Override
	public com.liferay.gwenod.gestiondocuments.service.model.Document
			updateDocument(
				long documentId, java.io.InputStream file, String title,
				java.util.List<String> tags, String city, String address,
				String description,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentService.updateDocument(
			documentId, file, title, tags, city, address, description,
			serviceContext);
	}

	@Override
	public DocumentService getWrappedService() {
		return _documentService;
	}

	@Override
	public void setWrappedService(DocumentService documentService) {
		_documentService = documentService;
	}

	private DocumentService _documentService;

}