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

import com.liferay.gwenod.gestiondocuments.service.model.Document;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Document in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DocumentCacheModel
	implements CacheModel<Document>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DocumentCacheModel)) {
			return false;
		}

		DocumentCacheModel documentCacheModel = (DocumentCacheModel)object;

		if (documentId == documentCacheModel.documentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, documentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", documentId=");
		sb.append(documentId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", city=");
		sb.append(city);
		sb.append(", address=");
		sb.append(address);
		sb.append(", type=");
		sb.append(type);
		sb.append(", description=");
		sb.append(description);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Document toEntityModel() {
		DocumentImpl documentImpl = new DocumentImpl();

		if (uuid == null) {
			documentImpl.setUuid("");
		}
		else {
			documentImpl.setUuid(uuid);
		}

		documentImpl.setDocumentId(documentId);
		documentImpl.setGroupId(groupId);
		documentImpl.setCompanyId(companyId);
		documentImpl.setUserId(userId);

		if (userName == null) {
			documentImpl.setUserName("");
		}
		else {
			documentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			documentImpl.setCreateDate(null);
		}
		else {
			documentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			documentImpl.setModifiedDate(null);
		}
		else {
			documentImpl.setModifiedDate(new Date(modifiedDate));
		}

		documentImpl.setModifiedBy(modifiedBy);

		if (city == null) {
			documentImpl.setCity("");
		}
		else {
			documentImpl.setCity(city);
		}

		if (address == null) {
			documentImpl.setAddress("");
		}
		else {
			documentImpl.setAddress(address);
		}

		if (type == null) {
			documentImpl.setType("");
		}
		else {
			documentImpl.setType(type);
		}

		if (description == null) {
			documentImpl.setDescription("");
		}
		else {
			documentImpl.setDescription(description);
		}

		if (title == null) {
			documentImpl.setTitle("");
		}
		else {
			documentImpl.setTitle(title);
		}

		if (filepath == null) {
			documentImpl.setFilepath("");
		}
		else {
			documentImpl.setFilepath(filepath);
		}

		if (filename == null) {
			documentImpl.setFilename("");
		}
		else {
			documentImpl.setFilename(filename);
		}

		documentImpl.setFileversion(fileversion);

		if (tags == null) {
			documentImpl.setTags("");
		}
		else {
			documentImpl.setTags(tags);
		}

		documentImpl.resetOriginalValues();

		return documentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		documentId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		city = objectInput.readUTF();
		address = objectInput.readUTF();
		type = objectInput.readUTF();
		description = objectInput.readUTF();
		title = objectInput.readUTF();
		filepath = objectInput.readUTF();
		filename = objectInput.readUTF();

		fileversion = objectInput.readLong();
		tags = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(documentId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

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

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

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
	}

	public String uuid;
	public long documentId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long modifiedBy;
	public String city;
	public String address;
	public String type;
	public String description;
	public String title;
	public String filepath;
	public String filename;
	public long fileversion;
	public String tags;

}