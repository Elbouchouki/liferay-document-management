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
import com.liferay.gwenod.gestiondocuments.service.model.DocumentHistory;
import com.liferay.gwenod.gestiondocuments.service.model.DocumentHistoryModel;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
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
 * The base model implementation for the DocumentHistory service. Represents a row in the &quot;GDHistory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DocumentHistoryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DocumentHistoryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentHistoryImpl
 * @generated
 */
public class DocumentHistoryModelImpl
	extends BaseModelImpl<DocumentHistory> implements DocumentHistoryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a document history model instance should use the <code>DocumentHistory</code> interface instead.
	 */
	public static final String TABLE_NAME = "GDHistory";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"historyId", Types.BIGINT},
		{"versionDate", Types.TIMESTAMP}, {"versionModifier", Types.BIGINT},
		{"documentId", Types.BIGINT}, {"title", Types.VARCHAR},
		{"filepath", Types.VARCHAR}, {"filename", Types.VARCHAR},
		{"fileversion", Types.BIGINT}, {"tags", Types.VARCHAR},
		{"city", Types.VARCHAR}, {"address", Types.VARCHAR},
		{"description", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("historyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("versionDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("versionModifier", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("documentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("filepath", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("filename", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fileversion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("tags", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("city", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("address", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table GDHistory (uuid_ VARCHAR(75) null,historyId LONG not null primary key,versionDate DATE null,versionModifier LONG,documentId LONG,title VARCHAR(75) null,filepath VARCHAR(75) null,filename VARCHAR(75) null,fileversion LONG,tags VARCHAR(75) null,city VARCHAR(75) null,address VARCHAR(75) null,description VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table GDHistory";

	public static final String ORDER_BY_JPQL =
		" ORDER BY documentHistory.historyId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY GDHistory.historyId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long DOCUMENTID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long HISTORYID_COLUMN_BITMASK = 4L;

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

	public DocumentHistoryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _historyId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setHistoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _historyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DocumentHistory.class;
	}

	@Override
	public String getModelClassName() {
		return DocumentHistory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DocumentHistory, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DocumentHistory, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DocumentHistory, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((DocumentHistory)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DocumentHistory, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DocumentHistory, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DocumentHistory)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DocumentHistory, Object>>
		getAttributeGetterFunctions() {

		return AttributeGetterFunctionsHolder._attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DocumentHistory, Object>>
		getAttributeSetterBiConsumers() {

		return AttributeSetterBiConsumersHolder._attributeSetterBiConsumers;
	}

	private static class AttributeGetterFunctionsHolder {

		private static final Map<String, Function<DocumentHistory, Object>>
			_attributeGetterFunctions;

		static {
			Map<String, Function<DocumentHistory, Object>>
				attributeGetterFunctions =
					new LinkedHashMap
						<String, Function<DocumentHistory, Object>>();

			attributeGetterFunctions.put("uuid", DocumentHistory::getUuid);
			attributeGetterFunctions.put(
				"historyId", DocumentHistory::getHistoryId);
			attributeGetterFunctions.put(
				"versionDate", DocumentHistory::getVersionDate);
			attributeGetterFunctions.put(
				"versionModifier", DocumentHistory::getVersionModifier);
			attributeGetterFunctions.put(
				"documentId", DocumentHistory::getDocumentId);
			attributeGetterFunctions.put("title", DocumentHistory::getTitle);
			attributeGetterFunctions.put(
				"filepath", DocumentHistory::getFilepath);
			attributeGetterFunctions.put(
				"filename", DocumentHistory::getFilename);
			attributeGetterFunctions.put(
				"fileversion", DocumentHistory::getFileversion);
			attributeGetterFunctions.put("tags", DocumentHistory::getTags);
			attributeGetterFunctions.put("city", DocumentHistory::getCity);
			attributeGetterFunctions.put(
				"address", DocumentHistory::getAddress);
			attributeGetterFunctions.put(
				"description", DocumentHistory::getDescription);

			_attributeGetterFunctions = Collections.unmodifiableMap(
				attributeGetterFunctions);
		}

	}

	private static class AttributeSetterBiConsumersHolder {

		private static final Map<String, BiConsumer<DocumentHistory, Object>>
			_attributeSetterBiConsumers;

		static {
			Map<String, BiConsumer<DocumentHistory, ?>>
				attributeSetterBiConsumers =
					new LinkedHashMap<String, BiConsumer<DocumentHistory, ?>>();

			attributeSetterBiConsumers.put(
				"uuid",
				(BiConsumer<DocumentHistory, String>)DocumentHistory::setUuid);
			attributeSetterBiConsumers.put(
				"historyId",
				(BiConsumer<DocumentHistory, Long>)
					DocumentHistory::setHistoryId);
			attributeSetterBiConsumers.put(
				"versionDate",
				(BiConsumer<DocumentHistory, Date>)
					DocumentHistory::setVersionDate);
			attributeSetterBiConsumers.put(
				"versionModifier",
				(BiConsumer<DocumentHistory, Long>)
					DocumentHistory::setVersionModifier);
			attributeSetterBiConsumers.put(
				"documentId",
				(BiConsumer<DocumentHistory, Long>)
					DocumentHistory::setDocumentId);
			attributeSetterBiConsumers.put(
				"title",
				(BiConsumer<DocumentHistory, String>)DocumentHistory::setTitle);
			attributeSetterBiConsumers.put(
				"filepath",
				(BiConsumer<DocumentHistory, String>)
					DocumentHistory::setFilepath);
			attributeSetterBiConsumers.put(
				"filename",
				(BiConsumer<DocumentHistory, String>)
					DocumentHistory::setFilename);
			attributeSetterBiConsumers.put(
				"fileversion",
				(BiConsumer<DocumentHistory, Long>)
					DocumentHistory::setFileversion);
			attributeSetterBiConsumers.put(
				"tags",
				(BiConsumer<DocumentHistory, String>)DocumentHistory::setTags);
			attributeSetterBiConsumers.put(
				"city",
				(BiConsumer<DocumentHistory, String>)DocumentHistory::setCity);
			attributeSetterBiConsumers.put(
				"address",
				(BiConsumer<DocumentHistory, String>)
					DocumentHistory::setAddress);
			attributeSetterBiConsumers.put(
				"description",
				(BiConsumer<DocumentHistory, String>)
					DocumentHistory::setDescription);

			_attributeSetterBiConsumers = Collections.unmodifiableMap(
				(Map)attributeSetterBiConsumers);
		}

	}

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

	@Override
	public long getHistoryId() {
		return _historyId;
	}

	@Override
	public void setHistoryId(long historyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_historyId = historyId;
	}

	@Override
	public Date getVersionDate() {
		return _versionDate;
	}

	@Override
	public void setVersionDate(Date versionDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_versionDate = versionDate;
	}

	@Override
	public long getVersionModifier() {
		return _versionModifier;
	}

	@Override
	public void setVersionModifier(long versionModifier) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_versionModifier = versionModifier;
	}

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

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalDocumentId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("documentId"));
	}

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
			0, DocumentHistory.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DocumentHistory toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, DocumentHistory>
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
		DocumentHistoryImpl documentHistoryImpl = new DocumentHistoryImpl();

		documentHistoryImpl.setUuid(getUuid());
		documentHistoryImpl.setHistoryId(getHistoryId());
		documentHistoryImpl.setVersionDate(getVersionDate());
		documentHistoryImpl.setVersionModifier(getVersionModifier());
		documentHistoryImpl.setDocumentId(getDocumentId());
		documentHistoryImpl.setTitle(getTitle());
		documentHistoryImpl.setFilepath(getFilepath());
		documentHistoryImpl.setFilename(getFilename());
		documentHistoryImpl.setFileversion(getFileversion());
		documentHistoryImpl.setTags(getTags());
		documentHistoryImpl.setCity(getCity());
		documentHistoryImpl.setAddress(getAddress());
		documentHistoryImpl.setDescription(getDescription());

		documentHistoryImpl.resetOriginalValues();

		return documentHistoryImpl;
	}

	@Override
	public DocumentHistory cloneWithOriginalValues() {
		DocumentHistoryImpl documentHistoryImpl = new DocumentHistoryImpl();

		documentHistoryImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		documentHistoryImpl.setHistoryId(
			this.<Long>getColumnOriginalValue("historyId"));
		documentHistoryImpl.setVersionDate(
			this.<Date>getColumnOriginalValue("versionDate"));
		documentHistoryImpl.setVersionModifier(
			this.<Long>getColumnOriginalValue("versionModifier"));
		documentHistoryImpl.setDocumentId(
			this.<Long>getColumnOriginalValue("documentId"));
		documentHistoryImpl.setTitle(
			this.<String>getColumnOriginalValue("title"));
		documentHistoryImpl.setFilepath(
			this.<String>getColumnOriginalValue("filepath"));
		documentHistoryImpl.setFilename(
			this.<String>getColumnOriginalValue("filename"));
		documentHistoryImpl.setFileversion(
			this.<Long>getColumnOriginalValue("fileversion"));
		documentHistoryImpl.setTags(
			this.<String>getColumnOriginalValue("tags"));
		documentHistoryImpl.setCity(
			this.<String>getColumnOriginalValue("city"));
		documentHistoryImpl.setAddress(
			this.<String>getColumnOriginalValue("address"));
		documentHistoryImpl.setDescription(
			this.<String>getColumnOriginalValue("description"));

		return documentHistoryImpl;
	}

	@Override
	public int compareTo(DocumentHistory documentHistory) {
		int value = 0;

		if (getHistoryId() < documentHistory.getHistoryId()) {
			value = -1;
		}
		else if (getHistoryId() > documentHistory.getHistoryId()) {
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

		if (!(object instanceof DocumentHistory)) {
			return false;
		}

		DocumentHistory documentHistory = (DocumentHistory)object;

		long primaryKey = documentHistory.getPrimaryKey();

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

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<DocumentHistory> toCacheModel() {
		DocumentHistoryCacheModel documentHistoryCacheModel =
			new DocumentHistoryCacheModel();

		documentHistoryCacheModel.uuid = getUuid();

		String uuid = documentHistoryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			documentHistoryCacheModel.uuid = null;
		}

		documentHistoryCacheModel.historyId = getHistoryId();

		Date versionDate = getVersionDate();

		if (versionDate != null) {
			documentHistoryCacheModel.versionDate = versionDate.getTime();
		}
		else {
			documentHistoryCacheModel.versionDate = Long.MIN_VALUE;
		}

		documentHistoryCacheModel.versionModifier = getVersionModifier();

		documentHistoryCacheModel.documentId = getDocumentId();

		documentHistoryCacheModel.title = getTitle();

		String title = documentHistoryCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			documentHistoryCacheModel.title = null;
		}

		documentHistoryCacheModel.filepath = getFilepath();

		String filepath = documentHistoryCacheModel.filepath;

		if ((filepath != null) && (filepath.length() == 0)) {
			documentHistoryCacheModel.filepath = null;
		}

		documentHistoryCacheModel.filename = getFilename();

		String filename = documentHistoryCacheModel.filename;

		if ((filename != null) && (filename.length() == 0)) {
			documentHistoryCacheModel.filename = null;
		}

		documentHistoryCacheModel.fileversion = getFileversion();

		documentHistoryCacheModel.tags = getTags();

		String tags = documentHistoryCacheModel.tags;

		if ((tags != null) && (tags.length() == 0)) {
			documentHistoryCacheModel.tags = null;
		}

		documentHistoryCacheModel.city = getCity();

		String city = documentHistoryCacheModel.city;

		if ((city != null) && (city.length() == 0)) {
			documentHistoryCacheModel.city = null;
		}

		documentHistoryCacheModel.address = getAddress();

		String address = documentHistoryCacheModel.address;

		if ((address != null) && (address.length() == 0)) {
			documentHistoryCacheModel.address = null;
		}

		documentHistoryCacheModel.description = getDescription();

		String description = documentHistoryCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			documentHistoryCacheModel.description = null;
		}

		return documentHistoryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DocumentHistory, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DocumentHistory, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DocumentHistory, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((DocumentHistory)this);

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

		private static final Function<InvocationHandler, DocumentHistory>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					DocumentHistory.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _historyId;
	private Date _versionDate;
	private long _versionModifier;
	private long _documentId;
	private String _title;
	private String _filepath;
	private String _filename;
	private long _fileversion;
	private String _tags;
	private String _city;
	private String _address;
	private String _description;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<DocumentHistory, Object> function =
			AttributeGetterFunctionsHolder._attributeGetterFunctions.get(
				columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((DocumentHistory)this);
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
		_columnOriginalValues.put("historyId", _historyId);
		_columnOriginalValues.put("versionDate", _versionDate);
		_columnOriginalValues.put("versionModifier", _versionModifier);
		_columnOriginalValues.put("documentId", _documentId);
		_columnOriginalValues.put("title", _title);
		_columnOriginalValues.put("filepath", _filepath);
		_columnOriginalValues.put("filename", _filename);
		_columnOriginalValues.put("fileversion", _fileversion);
		_columnOriginalValues.put("tags", _tags);
		_columnOriginalValues.put("city", _city);
		_columnOriginalValues.put("address", _address);
		_columnOriginalValues.put("description", _description);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

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

		columnBitmasks.put("historyId", 2L);

		columnBitmasks.put("versionDate", 4L);

		columnBitmasks.put("versionModifier", 8L);

		columnBitmasks.put("documentId", 16L);

		columnBitmasks.put("title", 32L);

		columnBitmasks.put("filepath", 64L);

		columnBitmasks.put("filename", 128L);

		columnBitmasks.put("fileversion", 256L);

		columnBitmasks.put("tags", 512L);

		columnBitmasks.put("city", 1024L);

		columnBitmasks.put("address", 2048L);

		columnBitmasks.put("description", 4096L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private DocumentHistory _escapedModel;

}