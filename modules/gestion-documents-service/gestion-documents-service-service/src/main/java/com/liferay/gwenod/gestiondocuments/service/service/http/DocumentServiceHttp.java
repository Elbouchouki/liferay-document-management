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

package com.liferay.gwenod.gestiondocuments.service.service.http;

import com.liferay.gwenod.gestiondocuments.service.service.DocumentServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>DocumentServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DocumentServiceHttp {

	public static com.liferay.gwenod.gestiondocuments.service.model.Document
			addDocument(
				HttpPrincipal httpPrincipal, java.io.InputStream file,
				String fileName, String title, java.util.List<String> tags,
				String city, String address, String type, String description,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				DocumentServiceUtil.class, "addDocument",
				_addDocumentParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, file, fileName, title, tags, city, address, type,
				description, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.gwenod.gestiondocuments.service.model.Document)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.gwenod.gestiondocuments.service.model.Document
			updateDocument(
				HttpPrincipal httpPrincipal, long documentId,
				java.io.InputStream file, String title,
				java.util.List<String> tags, String city, String address,
				String description,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				DocumentServiceUtil.class, "updateDocument",
				_updateDocumentParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, documentId, file, title, tags, city, address,
				description, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.gwenod.gestiondocuments.service.model.Document)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.liferay.gwenod.gestiondocuments.service.model.Document>
			getUserDocuments(
				HttpPrincipal httpPrincipal,
				com.liferay.portal.kernel.service.ServiceContext
					serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				DocumentServiceUtil.class, "getUserDocuments",
				_getUserDocumentsParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.gwenod.gestiondocuments.service.model.Document>)
					returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.liferay.gwenod.gestiondocuments.service.model.DocumentHistory>
				getDocumentHistory(
					HttpPrincipal httpPrincipal, long documentId,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
			throws com.liferay.gwenod.gestiondocuments.service.exception.
				NoSuchDocumentException,
				   IllegalAccessException {

		try {
			MethodKey methodKey = new MethodKey(
				DocumentServiceUtil.class, "getDocumentHistory",
				_getDocumentHistoryParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, documentId, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.gwenod.gestiondocuments.service.exception.
							NoSuchDocumentException) {

					throw (com.liferay.gwenod.gestiondocuments.service.
						exception.NoSuchDocumentException)exception;
				}

				if (exception instanceof IllegalAccessException) {
					throw (IllegalAccessException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.gwenod.gestiondocuments.service.model.
					DocumentHistory>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.liferay.gwenod.gestiondocuments.service.model.Document>
			getDocumentsByTagsAndTitle(
				HttpPrincipal httpPrincipal, String title, String tags,
				com.liferay.portal.kernel.service.ServiceContext
					serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				DocumentServiceUtil.class, "getDocumentsByTagsAndTitle",
				_getDocumentsByTagsAndTitleParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, title, tags, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.gwenod.gestiondocuments.service.model.Document>)
					returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.io.ByteArrayOutputStream getDocumentFile(
			HttpPrincipal httpPrincipal, long documentId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.gwenod.gestiondocuments.service.exception.
			NoSuchDocumentException,
			   IllegalAccessException {

		try {
			MethodKey methodKey = new MethodKey(
				DocumentServiceUtil.class, "getDocumentFile",
				_getDocumentFileParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, documentId, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.gwenod.gestiondocuments.service.exception.
							NoSuchDocumentException) {

					throw (com.liferay.gwenod.gestiondocuments.service.
						exception.NoSuchDocumentException)exception;
				}

				if (exception instanceof IllegalAccessException) {
					throw (IllegalAccessException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.io.ByteArrayOutputStream)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.gwenod.gestiondocuments.service.model.Document
			deleteUserDocument(
				HttpPrincipal httpPrincipal, long documentId,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				DocumentServiceUtil.class, "deleteUserDocument",
				_deleteUserDocumentParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, documentId, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof Exception) {
					throw (Exception)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.gwenod.gestiondocuments.service.model.Document)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void deleteAllDocuments(HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(
				DocumentServiceUtil.class, "deleteAllDocuments",
				_deleteAllDocumentsParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(DocumentServiceHttp.class);

	private static final Class<?>[] _addDocumentParameterTypes0 = new Class[] {
		java.io.InputStream.class, String.class, String.class,
		java.util.List.class, String.class, String.class, String.class,
		String.class, com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _updateDocumentParameterTypes1 =
		new Class[] {
			long.class, java.io.InputStream.class, String.class,
			java.util.List.class, String.class, String.class, String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _getUserDocumentsParameterTypes2 =
		new Class[] {com.liferay.portal.kernel.service.ServiceContext.class};
	private static final Class<?>[] _getDocumentHistoryParameterTypes3 =
		new Class[] {
			long.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _getDocumentsByTagsAndTitleParameterTypes4 =
		new Class[] {
			String.class, String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _getDocumentFileParameterTypes5 =
		new Class[] {
			long.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteUserDocumentParameterTypes6 =
		new Class[] {
			long.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteAllDocumentsParameterTypes7 =
		new Class[] {};

}