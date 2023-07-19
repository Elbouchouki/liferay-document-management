/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.gwenod.gestiondocuments.service.service.impl;

import com.liferay.gwenod.gestiondocuments.service.exception.NoSuchDocumentException;
import com.liferay.gwenod.gestiondocuments.service.model.Document;
import com.liferay.gwenod.gestiondocuments.service.model.DocumentHistory;
import com.liferay.gwenod.gestiondocuments.service.service.base.DocumentServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;

import java.io.*;
import java.util.List;

/**
 * @author elbouchouki
 */
@Component(
        property = {
                "json.web.service.context.name=documentmanagement",
                "json.web.service.context.path=Document"
        },
        service = AopService.class
)
public class DocumentServiceImpl extends DocumentServiceBaseImpl {
    public Document addDocument(
            InputStream file,
            String fileName,
            String title, List<String> tags, String city, String address,
            String type, String description, ServiceContext serviceContext
    ) throws PortalException {
        return documentLocalService.addDocument(
                file,
                fileName,
                title, tags, city, address,
                type, description, serviceContext
        );
    }

    public Document updateDocument(
            long documentId,
            InputStream file,
            String title, List<String> tags, String city, String address,
            String description, ServiceContext serviceContext
    ) throws PortalException {
        return documentLocalService.updateDocument(
                documentId,
                file,
                title, tags, city, address,
                description, serviceContext
        );
    }

    public List<Document> getUserDocuments(ServiceContext serviceContext) {
        System.out.println("DocumentServiceImpl.getUserDocuments");
        System.out.println("serviceContext.getUserId() : " + serviceContext.getUserId());
        System.out.println("serviceContext.getScopeGroupId() : " + serviceContext.getScopeGroupId());
        return documentLocalService.getUserDocuments(serviceContext);
    }

    public List<DocumentHistory> getDocumentHistory(long documentId, ServiceContext serviceContext) throws NoSuchDocumentException, IllegalAccessException {
        return documentLocalService.getDocumentHistory(documentId, serviceContext);
    }

    public List<Document> getDocumentsByTagsAndTitle(String title, String tags, ServiceContext serviceContext) {
        return documentLocalService.getDocumentsByTagsAndTitle(title, tags, serviceContext);
    }

    public ByteArrayOutputStream getDocumentFile(long documentId, ServiceContext serviceContext) throws NoSuchDocumentException, IllegalAccessException {
        return documentLocalService.getDocumentFile(documentId, serviceContext);
    }


    public Document deleteUserDocument(long documentId, ServiceContext serviceContext) throws Exception {
        return documentLocalService.deleteUserDocument(documentId, serviceContext);
    }


    // FOR DEV ONLY
    public void deleteAllDocuments() {
        documentLocalService.deleteAllDocuments();
    }
}