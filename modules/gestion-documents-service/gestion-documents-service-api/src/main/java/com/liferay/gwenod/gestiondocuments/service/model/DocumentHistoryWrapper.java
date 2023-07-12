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

package com.liferay.gwenod.gestiondocuments.service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DocumentHistory}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentHistory
 * @generated
 */
public class DocumentHistoryWrapper
	extends BaseModelWrapper<DocumentHistory>
	implements DocumentHistory, ModelWrapper<DocumentHistory> {

	public DocumentHistoryWrapper(DocumentHistory documentHistory) {
		super(documentHistory);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("historyId", getHistoryId());
		attributes.put("versionDate", getVersionDate());
		attributes.put("versionModifier", getVersionModifier());
		attributes.put("documentId", getDocumentId());
		attributes.put("title", getTitle());
		attributes.put("filepath", getFilepath());
		attributes.put("filename", getFilename());
		attributes.put("fileversion", getFileversion());
		attributes.put("tags", getTags());
		attributes.put("city", getCity());
		attributes.put("address", getAddress());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long historyId = (Long)attributes.get("historyId");

		if (historyId != null) {
			setHistoryId(historyId);
		}

		Date versionDate = (Date)attributes.get("versionDate");

		if (versionDate != null) {
			setVersionDate(versionDate);
		}

		Long versionModifier = (Long)attributes.get("versionModifier");

		if (versionModifier != null) {
			setVersionModifier(versionModifier);
		}

		Long documentId = (Long)attributes.get("documentId");

		if (documentId != null) {
			setDocumentId(documentId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String filepath = (String)attributes.get("filepath");

		if (filepath != null) {
			setFilepath(filepath);
		}

		String filename = (String)attributes.get("filename");

		if (filename != null) {
			setFilename(filename);
		}

		Long fileversion = (Long)attributes.get("fileversion");

		if (fileversion != null) {
			setFileversion(fileversion);
		}

		String tags = (String)attributes.get("tags");

		if (tags != null) {
			setTags(tags);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public DocumentHistory cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the address of this document history.
	 *
	 * @return the address of this document history
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the city of this document history.
	 *
	 * @return the city of this document history
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the description of this document history.
	 *
	 * @return the description of this document history
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the document ID of this document history.
	 *
	 * @return the document ID of this document history
	 */
	@Override
	public long getDocumentId() {
		return model.getDocumentId();
	}

	/**
	 * Returns the filename of this document history.
	 *
	 * @return the filename of this document history
	 */
	@Override
	public String getFilename() {
		return model.getFilename();
	}

	/**
	 * Returns the filepath of this document history.
	 *
	 * @return the filepath of this document history
	 */
	@Override
	public String getFilepath() {
		return model.getFilepath();
	}

	/**
	 * Returns the fileversion of this document history.
	 *
	 * @return the fileversion of this document history
	 */
	@Override
	public long getFileversion() {
		return model.getFileversion();
	}

	/**
	 * Returns the history ID of this document history.
	 *
	 * @return the history ID of this document history
	 */
	@Override
	public long getHistoryId() {
		return model.getHistoryId();
	}

	/**
	 * Returns the primary key of this document history.
	 *
	 * @return the primary key of this document history
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the tags of this document history.
	 *
	 * @return the tags of this document history
	 */
	@Override
	public String getTags() {
		return model.getTags();
	}

	/**
	 * Returns the title of this document history.
	 *
	 * @return the title of this document history
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the uuid of this document history.
	 *
	 * @return the uuid of this document history
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the version date of this document history.
	 *
	 * @return the version date of this document history
	 */
	@Override
	public Date getVersionDate() {
		return model.getVersionDate();
	}

	/**
	 * Returns the version modifier of this document history.
	 *
	 * @return the version modifier of this document history
	 */
	@Override
	public long getVersionModifier() {
		return model.getVersionModifier();
	}

	/**
	 * Sets the address of this document history.
	 *
	 * @param address the address of this document history
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the city of this document history.
	 *
	 * @param city the city of this document history
	 */
	@Override
	public void setCity(String city) {
		model.setCity(city);
	}

	/**
	 * Sets the description of this document history.
	 *
	 * @param description the description of this document history
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the document ID of this document history.
	 *
	 * @param documentId the document ID of this document history
	 */
	@Override
	public void setDocumentId(long documentId) {
		model.setDocumentId(documentId);
	}

	/**
	 * Sets the filename of this document history.
	 *
	 * @param filename the filename of this document history
	 */
	@Override
	public void setFilename(String filename) {
		model.setFilename(filename);
	}

	/**
	 * Sets the filepath of this document history.
	 *
	 * @param filepath the filepath of this document history
	 */
	@Override
	public void setFilepath(String filepath) {
		model.setFilepath(filepath);
	}

	/**
	 * Sets the fileversion of this document history.
	 *
	 * @param fileversion the fileversion of this document history
	 */
	@Override
	public void setFileversion(long fileversion) {
		model.setFileversion(fileversion);
	}

	/**
	 * Sets the history ID of this document history.
	 *
	 * @param historyId the history ID of this document history
	 */
	@Override
	public void setHistoryId(long historyId) {
		model.setHistoryId(historyId);
	}

	/**
	 * Sets the primary key of this document history.
	 *
	 * @param primaryKey the primary key of this document history
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the tags of this document history.
	 *
	 * @param tags the tags of this document history
	 */
	@Override
	public void setTags(String tags) {
		model.setTags(tags);
	}

	/**
	 * Sets the title of this document history.
	 *
	 * @param title the title of this document history
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the uuid of this document history.
	 *
	 * @param uuid the uuid of this document history
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the version date of this document history.
	 *
	 * @param versionDate the version date of this document history
	 */
	@Override
	public void setVersionDate(Date versionDate) {
		model.setVersionDate(versionDate);
	}

	/**
	 * Sets the version modifier of this document history.
	 *
	 * @param versionModifier the version modifier of this document history
	 */
	@Override
	public void setVersionModifier(long versionModifier) {
		model.setVersionModifier(versionModifier);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DocumentHistoryWrapper wrap(DocumentHistory documentHistory) {
		return new DocumentHistoryWrapper(documentHistory);
	}

}