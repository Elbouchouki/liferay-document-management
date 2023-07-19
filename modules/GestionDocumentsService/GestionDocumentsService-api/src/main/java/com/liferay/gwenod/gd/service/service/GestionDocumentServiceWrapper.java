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

package com.liferay.gwenod.gd.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GestionDocumentService}.
 *
 * @author Brian Wing Shun Chan
 * @see GestionDocumentService
 * @generated
 */
public class GestionDocumentServiceWrapper
	implements GestionDocumentService, ServiceWrapper<GestionDocumentService> {

	public GestionDocumentServiceWrapper() {
		this(null);
	}

	public GestionDocumentServiceWrapper(
		GestionDocumentService gestionDocumentService) {

		_gestionDocumentService = gestionDocumentService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _gestionDocumentService.getOSGiServiceIdentifier();
	}

	@Override
	public GestionDocumentService getWrappedService() {
		return _gestionDocumentService;
	}

	@Override
	public void setWrappedService(
		GestionDocumentService gestionDocumentService) {

		_gestionDocumentService = gestionDocumentService;
	}

	private GestionDocumentService _gestionDocumentService;

}