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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.gwenod.gestiondocuments.service.model.Document;
import com.liferay.gwenod.gestiondocuments.service.model.DocumentModel;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Document service. Represents a row in the &quot;GDDocument&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DocumentModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DocumentImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentImpl
 * @generated
 */
@JSON(strict = true)
public class DocumentModelImpl
	extends BaseModelImpl<Document> implements DocumentModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a document model instance should use the <code>Document</code> interface instead.
	 */
	public static final String TABLE_NAME = "GDDocument";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"documentId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"modifiedBy", Types.BIGINT}, {"city", Types.VARCHAR},
		{"address", Types.VARCHAR}, {"type_", Types.VARCHAR},
		{"description", Types.VARCHAR}, {"title", Types.VARCHAR},
		{"filepath", Types.VARCHAR}, {"filename", Types.VARCHAR},
		{"fileversion", Types.BIGINT}, {"tags", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("documentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedBy", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("city", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("address", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("type_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("filepath", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("filename", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fileversion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("tags", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table GDDocument (uuid_ VARCHAR(75) null,documentId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,modifiedBy LONG,city VARCHAR(75) null,address VARCHAR(75) null,type_ VARCHAR(75) null,description VARCHAR(75) null,title VARCHAR(75) null,filepath VARCHAR(255) null,filename VARCHAR(75) null,fileversion LONG,tags VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table GDDocument";

	public static final String ORDER_BY_JPQL = " ORDER BY document.groupId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY GDDocument.groupId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long FILENAME_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long FILEVERSION_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TAGS_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TITLE_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long USERID_COLUMN_BITMASK = 64L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 128L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public DocumentModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _documentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDocumentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _documentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Document.class;
	}

	@Override
	public String getModelClassName() {
		return Document.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Document, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Document, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Document, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Document)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Document, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Document, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Document)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Document, Object>>
		getAttributeGetterFunctions() {

		return AttributeGetterFunctionsHolder._attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Document, Object>>
		getAttributeSetterBiConsumers() {

		return AttributeSetterBiConsumersHolder._attributeSetterBiConsumers;
	}

	private static class AttributeGetterFunctionsHolder {

		private static final Map<String, Function<Document, Object>>
			_attributeGetterFunctions;

		static {
			Map<String, Function<Document, Object>> attributeGetterFunctions =
				new LinkedHashMap<String, Function<Document, Object>>();

			attributeGetterFunctions.put("uuid", Document::getUuid);
			attributeGetterFunctions.put("documentId", Document::getDocumentId);
			attributeGetterFunctions.put("groupId", Document::getGroupId);
			attributeGetterFunctions.put("companyId", Document::getCompanyId);
			attributeGetterFunctions.put("userId", Document::getUserId);
			attributeGetterFunctions.put("userName", Document::getUserName);
			attributeGetterFunctions.put("createDate", Document::getCreateDate);
			attributeGetterFunctions.put(
				"modifiedDate", Document::getModifiedDate);
			attributeGetterFunctions.put("modifiedBy", Document::getModifiedBy);
			attributeGetterFunctions.put("city", Document::getCity);
			attributeGetterFunctions.put("address", Document::getAddress);
			attributeGetterFunctions.put("type", Document::getType);
			attributeGetterFunctions.put(
				"description", Document::getDescription);
			attributeGetterFunctions.put("title", Document::getTitle);
			attributeGetterFunctions.put("filepath", Document::getFilepath);
			attributeGetterFunctions.put("filename", Document::getFilename);
			attributeGetterFunctions.put(
				"fileversion", Document::getFileversion);
			attributeGetterFunctions.put("tags", Document::getTags);

			_attributeGetterFunctions = Collections.unmodifiableMap(
				attributeGetterFunctions);
		}

	}

	private static class AttributeSetterBiConsumersHolder {

		private static final Map<String, BiConsumer<Document, Object>>
			_attributeSetterBiConsumers;

		static {
			Map<String, BiConsumer<Document, ?>> attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<Document, ?>>();

			attributeSetterBiConsumers.put(
				"uuid", (BiConsumer<Document, String>)Document::setUuid);
			attributeSetterBiConsumers.put(
				"documentId",
				(BiConsumer<Document, Long>)Document::setDocumentId);
			attributeSetterBiConsumers.put(
				"groupId", (BiConsumer<Document, Long>)Document::setGroupId);
			attributeSetterBiConsumers.put(
				"companyId",
				(BiConsumer<Document, Long>)Document::setCompanyId);
			attributeSetterBiConsumers.put(
				"userId", (BiConsumer<Document, Long>)Document::setUserId);
			attributeSetterBiConsumers.put(
				"userName",
				(BiConsumer<Document, String>)Document::setUserName);
			attributeSetterBiConsumers.put(
				"createDate",
				(BiConsumer<Document, Date>)Document::setCreateDate);
			attributeSetterBiConsumers.put(
				"modifiedDate",
				(BiConsumer<Document, Date>)Document::setModifiedDate);
			attributeSetterBiConsumers.put(
				"modifiedBy",
				(BiConsumer<Document, Long>)Document::setModifiedBy);
			attributeSetterBiConsumers.put(
				"city", (BiConsumer<Document, String>)Document::setCity);
			attributeSetterBiConsumers.put(
				"address", (BiConsumer<Document, String>)Document::setAddress);
			attributeSetterBiConsumers.put(
				"type", (BiConsumer<Document, String>)Document::setType);
			attributeSetterBiConsumers.put(
				"description",
				(BiConsumer<Document, String>)Document::setDescription);
			attributeSetterBiConsumers.put(
				"title", (BiConsumer<Document, String>)Document::setTitle);
			attributeSetterBiConsumers.put(
				"filepath",
				(BiConsumer<Document, String>)Document::setFilepath);
			attributeSetterBiConsumers.put(
				"filename",
				(BiConsumer<Document, String>)Document::setFilename);
			attributeSetterBiConsumers.put(
				"fileversion",
				(BiConsumer<Document, Long>)Document::setFileversion);
			attributeSetterBiConsumers.put(
				"tags", (BiConsumer<Document, String>)Document::setTags);

			_attributeSetterBiConsumers = Collections.unmodifiableMap(
				(Map)attributeSetterBiConsumers);
		}

	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getDocumentId() {
		return _documentId;
	}

	@Override
	public void setDocumentId(long documentId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_documentId = documentId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalUserId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("userId"));
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getModifiedBy() {
		return _modifiedBy;
	}

	@Override
	public void setModifiedBy(long modifiedBy) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedBy = modifiedBy;
	}

	@JSON
	@Override
	public String getCity() {
		if (_city == null) {
			return "";
		}
		else {
			return _city;
		}
	}

	@Override
	public void setCity(String city) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_city = city;
	}

	@JSON
	@Override
	public String getAddress() {
		if (_address == null) {
			return "";
		}
		else {
			return _address;
		}
	}

	@Override
	public void setAddress(String address) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_address = address;
	}

	@JSON
	@Override
	public String getType() {
		if (_type == null) {
			return "";
		}
		else {
			return _type;
		}
	}

	@Override
	public void setType(String type) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_type = type;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_description = description;
	}

	@JSON
	@Override
	public String getTitle() {
		if (_title == null) {
			return "";
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_title = title;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalTitle() {
		return getColumnOriginalValue("title");
	}

	@JSON
	@Override
	public String getFilepath() {
		if (_filepath == null) {
			return "";
		}
		else {
			return _filepath;
		}
	}

	@Override
	public void setFilepath(String filepath) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_filepath = filepath;
	}

	@JSON
	@Override
	public String getFilename() {
		if (_filename == null) {
			return "";
		}
		else {
			return _filename;
		}
	}

	@Override
	public void setFilename(String filename) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_filename = filename;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalFilename() {
		return getColumnOriginalValue("filename");
	}

	@JSON
	@Override
	public long getFileversion() {
		return _fileversion;
	}

	@Override
	public void setFileversion(long fileversion) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fileversion = fileversion;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalFileversion() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("fileversion"));
	}

	@JSON
	@Override
	public String getTags() {
		if (_tags == null) {
			return "";
		}
		else {
			return _tags;
		}
	}

	@Override
	public void setTags(String tags) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_tags = tags;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalTags() {
		return getColumnOriginalValue("tags");
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Document.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Document.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Document toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Document>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DocumentImpl documentImpl = new DocumentImpl();

		documentImpl.setUuid(getUuid());
		documentImpl.setDocumentId(getDocumentId());
		documentImpl.setGroupId(getGroupId());
		documentImpl.setCompanyId(getCompanyId());
		documentImpl.setUserId(getUserId());
		documentImpl.setUserName(getUserName());
		documentImpl.setCreateDate(getCreateDate());
		documentImpl.setModifiedDate(getModifiedDate());
		documentImpl.setModifiedBy(getModifiedBy());
		documentImpl.setCity(getCity());
		documentImpl.setAddress(getAddress());
		documentImpl.setType(getType());
		documentImpl.setDescription(getDescription());
		documentImpl.setTitle(getTitle());
		documentImpl.setFilepath(getFilepath());
		documentImpl.setFilename(getFilename());
		documentImpl.setFileversion(getFileversion());
		documentImpl.setTags(getTags());

		documentImpl.resetOriginalValues();

		return documentImpl;
	}

	@Override
	public Document cloneWithOriginalValues() {
		DocumentImpl documentImpl = new DocumentImpl();

		documentImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		documentImpl.setDocumentId(
			this.<Long>getColumnOriginalValue("documentId"));
		documentImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		documentImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		documentImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		documentImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		documentImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		documentImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		documentImpl.setModifiedBy(
			this.<Long>getColumnOriginalValue("modifiedBy"));
		documentImpl.setCity(this.<String>getColumnOriginalValue("city"));
		documentImpl.setAddress(this.<String>getColumnOriginalValue("address"));
		documentImpl.setType(this.<String>getColumnOriginalValue("type_"));
		documentImpl.setDescription(
			this.<String>getColumnOriginalValue("description"));
		documentImpl.setTitle(this.<String>getColumnOriginalValue("title"));
		documentImpl.setFilepath(
			this.<String>getColumnOriginalValue("filepath"));
		documentImpl.setFilename(
			this.<String>getColumnOriginalValue("filename"));
		documentImpl.setFileversion(
			this.<Long>getColumnOriginalValue("fileversion"));
		documentImpl.setTags(this.<String>getColumnOriginalValue("tags"));

		return documentImpl;
	}

	@Override
	public int compareTo(Document document) {
		int value = 0;

		if (getGroupId() < document.getGroupId()) {
			value = -1;
		}
		else if (getGroupId() > document.getGroupId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Document)) {
			return false;
		}

		Document document = (Document)object;

		long primaryKey = document.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Document> toCacheModel() {
		DocumentCacheModel documentCacheModel = new DocumentCacheModel();

		documentCacheModel.uuid = getUuid();

		String uuid = documentCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			documentCacheModel.uuid = null;
		}

		documentCacheModel.documentId = getDocumentId();

		documentCacheModel.groupId = getGroupId();

		documentCacheModel.companyId = getCompanyId();

		documentCacheModel.userId = getUserId();

		documentCacheModel.userName = getUserName();

		String userName = documentCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			documentCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			documentCacheModel.createDate = createDate.getTime();
		}
		else {
			documentCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			documentCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			documentCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		documentCacheModel.modifiedBy = getModifiedBy();

		documentCacheModel.city = getCity();

		String city = documentCacheModel.city;

		if ((city != null) && (city.length() == 0)) {
			documentCacheModel.city = null;
		}

		documentCacheModel.address = getAddress();

		String address = documentCacheModel.address;

		if ((address != null) && (address.length() == 0)) {
			documentCacheModel.address = null;
		}

		documentCacheModel.type = getType();

		String type = documentCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			documentCacheModel.type = null;
		}

		documentCacheModel.description = getDescription();

		String description = documentCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			documentCacheModel.description = null;
		}

		documentCacheModel.title = getTitle();

		String title = documentCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			documentCacheModel.title = null;
		}

		documentCacheModel.filepath = getFilepath();

		String filepath = documentCacheModel.filepath;

		if ((filepath != null) && (filepath.length() == 0)) {
			documentCacheModel.filepath = null;
		}

		documentCacheModel.filename = getFilename();

		String filename = documentCacheModel.filename;

		if ((filename != null) && (filename.length() == 0)) {
			documentCacheModel.filename = null;
		}

		documentCacheModel.fileversion = getFileversion();

		documentCacheModel.tags = getTags();

		String tags = documentCacheModel.tags;

		if ((tags != null) && (tags.length() == 0)) {
			documentCacheModel.tags = null;
		}

		return documentCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Document, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Document, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Document, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Document)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Document>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Document.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _documentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _modifiedBy;
	private String _city;
	private String _address;
	private String _type;
	private String _description;
	private String _title;
	private String _filepath;
	private String _filename;
	private long _fileversion;
	private String _tags;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Document, Object> function =
			AttributeGetterFunctionsHolder._attributeGetterFunctions.get(
				columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Document)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("documentId", _documentId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("modifiedBy", _modifiedBy);
		_columnOriginalValues.put("city", _city);
		_columnOriginalValues.put("address", _address);
		_columnOriginalValues.put("type_", _type);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("title", _title);
		_columnOriginalValues.put("filepath", _filepath);
		_columnOriginalValues.put("filename", _filename);
		_columnOriginalValues.put("fileversion", _fileversion);
		_columnOriginalValues.put("tags", _tags);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("type_", "type");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("documentId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("modifiedBy", 256L);

		columnBitmasks.put("city", 512L);

		columnBitmasks.put("address", 1024L);

		columnBitmasks.put("type_", 2048L);

		columnBitmasks.put("description", 4096L);

		columnBitmasks.put("title", 8192L);

		columnBitmasks.put("filepath", 16384L);

		columnBitmasks.put("filename", 32768L);

		columnBitmasks.put("fileversion", 65536L);

		columnBitmasks.put("tags", 131072L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Document _escapedModel;

}