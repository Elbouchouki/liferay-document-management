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

package com.liferay.gwenod.gestiondocuments.service.model.impl;

import com.liferay.gwenod.gestiondocuments.service.model.DocumentHistory;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DocumentHistory in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DocumentHistoryCacheModel
	implements CacheModel<DocumentHistory>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DocumentHistoryCacheModel)) {
			return false;
		}

		DocumentHistoryCacheModel documentHistoryCacheModel =
			(DocumentHistoryCacheModel)object;

		if (historyId == documentHistoryCacheModel.historyId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, historyId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", historyId=");
		sb.append(historyId);
		sb.append(", versionDate=");
		sb.append(versionDate);
		sb.append(", versionModifier=");
		sb.append(versionModifier);
		sb.append(", documentId=");
		sb.append(documentId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", filepath=");
		sb.append(filepath);
		sb.append(", filename=");
		sb.append(filename);
		sb.append(", fileversion=");
		sb.append(fileversion);
		sb.append(", tags=");
		sb.append(tags);
		sb.append(", city=");
		sb.append(city);
		sb.append(", address=");
		sb.append(address);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DocumentHistory toEntityModel() {
		DocumentHistoryImpl documentHistoryImpl = new DocumentHistoryImpl();

		if (uuid == null) {
			documentHistoryImpl.setUuid("");
		}
		else {
			documentHistoryImpl.setUuid(uuid);
		}

		documentHistoryImpl.setHistoryId(historyId);

		if (versionDate == Long.MIN_VALUE) {
			documentHistoryImpl.setVersionDate(null);
		}
		else {
			documentHistoryImpl.setVersionDate(new Date(versionDate));
		}

		documentHistoryImpl.setVersionModifier(versionModifier);
		documentHistoryImpl.setDocumentId(documentId);

		if (title == null) {
			documentHistoryImpl.setTitle("");
		}
		else {
			documentHistoryImpl.setTitle(title);
		}

		if (filepath == null) {
			documentHistoryImpl.setFilepath("");
		}
		else {
			documentHistoryImpl.setFilepath(filepath);
		}

		if (filename == null) {
			documentHistoryImpl.setFilename("");
		}
		else {
			documentHistoryImpl.setFilename(filename);
		}

		documentHistoryImpl.setFileversion(fileversion);

		if (tags == null) {
			documentHistoryImpl.setTags("");
		}
		else {
			documentHistoryImpl.setTags(tags);
		}

		if (city == null) {
			documentHistoryImpl.setCity("");
		}
		else {
			documentHistoryImpl.setCity(city);
		}

		if (address == null) {
			documentHistoryImpl.setAddress("");
		}
		else {
			documentHistoryImpl.setAddress(address);
		}

		if (description == null) {
			documentHistoryImpl.setDescription("");
		}
		else {
			documentHistoryImpl.setDescription(description);
		}

		documentHistoryImpl.resetOriginalValues();

		return documentHistoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		historyId = objectInput.readLong();
		versionDate = objectInput.readLong();

		versionModifier = objectInput.readLong();

		documentId = objectInput.readLong();
		title = objectInput.readUTF();
		filepath = objectInput.readUTF();
		filename = objectInput.readUTF();

		fileversion = objectInput.readLong();
		tags = objectInput.readUTF();
		city = objectInput.readUTF();
		address = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(historyId);
		objectOutput.writeLong(versionDate);

		objectOutput.writeLong(versionModifier);

		objectOutput.writeLong(documentId);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (filepath == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(filepath);
		}

		if (filename == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(filename);
		}

		objectOutput.writeLong(fileversion);

		if (tags == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tags);
		}

		if (city == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public String uuid;
	public long historyId;
	public long versionDate;
	public long versionModifier;
	public long documentId;
	public String title;
	public String filepath;
	public String filename;
	public long fileversion;
	public String tags;
	public String city;
	public String address;
	public String description;

}