package com.liferay.gwenod.gd.rest.client.serdes.v1_0;

import com.liferay.gwenod.gd.rest.client.dto.v1_0.Document;
import com.liferay.gwenod.gd.rest.client.json.BaseJSONParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author elbou
 * @generated
 */
@Generated("")
public class DocumentSerDes {

	public static Document toDTO(String json) {
		DocumentJSONParser documentJSONParser = new DocumentJSONParser();

		return documentJSONParser.parseToDTO(json);
	}

	public static Document[] toDTOs(String json) {
		DocumentJSONParser documentJSONParser = new DocumentJSONParser();

		return documentJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Document document) {
		if (document == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ssXX");

		if (document.getAddress() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"address\": ");

			sb.append("\"");

			sb.append(_escape(document.getAddress()));

			sb.append("\"");
		}

		if (document.getChangeLog() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"changeLog\": ");

			sb.append("\"");

			sb.append(_escape(document.getChangeLog()));

			sb.append("\"");
		}

		if (document.getCity() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"city\": ");

			sb.append("\"");

			sb.append(_escape(document.getCity()));

			sb.append("\"");
		}

		if (document.getCompanyId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"companyId\": ");

			sb.append(document.getCompanyId());
		}

		if (document.getCreateDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"createDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(document.getCreateDate()));

			sb.append("\"");
		}

		if (document.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(document.getDescription()));

			sb.append("\"");
		}

		if (document.getFileEntryId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileEntryId\": ");

			sb.append(document.getFileEntryId());
		}

		if (document.getFileEntryTypeId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileEntryTypeId\": ");

			sb.append(document.getFileEntryTypeId());
		}

		if (document.getFileEntryTypeIdName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileEntryTypeIdName\": ");

			sb.append("\"");

			sb.append(_escape(document.getFileEntryTypeIdName()));

			sb.append("\"");
		}

		if (document.getFileName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileName\": ");

			sb.append("\"");

			sb.append(_escape(document.getFileName()));

			sb.append("\"");
		}

		if (document.getFolderId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"folderId\": ");

			sb.append(document.getFolderId());
		}

		if (document.getGroupId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"groupId\": ");

			sb.append(document.getGroupId());
		}

		if (document.getMimeType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"mimeType\": ");

			sb.append("\"");

			sb.append(_escape(document.getMimeType()));

			sb.append("\"");
		}

		if (document.getModifiedDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"modifiedDate\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(document.getModifiedDate()));

			sb.append("\"");
		}

		if (document.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(document.getName()));

			sb.append("\"");
		}

		if (document.getRepositoryId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"repositoryId\": ");

			sb.append(document.getRepositoryId());
		}

		if (document.getSize() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"size\": ");

			sb.append(document.getSize());
		}

		if (document.getTags() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"tags\": ");

			sb.append("[");

			for (int i = 0; i < document.getTags().length; i++) {
				sb.append("\"");

				sb.append(_escape(document.getTags()[i]));

				sb.append("\"");

				if ((i + 1) < document.getTags().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (document.getTitle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"title\": ");

			sb.append("\"");

			sb.append(_escape(document.getTitle()));

			sb.append("\"");
		}

		if (document.getType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"type\": ");

			sb.append("\"");

			sb.append(document.getType());

			sb.append("\"");
		}

		if (document.getUserId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userId\": ");

			sb.append(document.getUserId());
		}

		if (document.getVersion() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"version\": ");

			sb.append("\"");

			sb.append(_escape(document.getVersion()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		DocumentJSONParser documentJSONParser = new DocumentJSONParser();

		return documentJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Document document) {
		if (document == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ssXX");

		if (document.getAddress() == null) {
			map.put("address", null);
		}
		else {
			map.put("address", String.valueOf(document.getAddress()));
		}

		if (document.getChangeLog() == null) {
			map.put("changeLog", null);
		}
		else {
			map.put("changeLog", String.valueOf(document.getChangeLog()));
		}

		if (document.getCity() == null) {
			map.put("city", null);
		}
		else {
			map.put("city", String.valueOf(document.getCity()));
		}

		if (document.getCompanyId() == null) {
			map.put("companyId", null);
		}
		else {
			map.put("companyId", String.valueOf(document.getCompanyId()));
		}

		if (document.getCreateDate() == null) {
			map.put("createDate", null);
		}
		else {
			map.put(
				"createDate",
				liferayToJSONDateFormat.format(document.getCreateDate()));
		}

		if (document.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put("description", String.valueOf(document.getDescription()));
		}

		if (document.getFileEntryId() == null) {
			map.put("fileEntryId", null);
		}
		else {
			map.put("fileEntryId", String.valueOf(document.getFileEntryId()));
		}

		if (document.getFileEntryTypeId() == null) {
			map.put("fileEntryTypeId", null);
		}
		else {
			map.put(
				"fileEntryTypeId",
				String.valueOf(document.getFileEntryTypeId()));
		}

		if (document.getFileEntryTypeIdName() == null) {
			map.put("fileEntryTypeIdName", null);
		}
		else {
			map.put(
				"fileEntryTypeIdName",
				String.valueOf(document.getFileEntryTypeIdName()));
		}

		if (document.getFileName() == null) {
			map.put("fileName", null);
		}
		else {
			map.put("fileName", String.valueOf(document.getFileName()));
		}

		if (document.getFolderId() == null) {
			map.put("folderId", null);
		}
		else {
			map.put("folderId", String.valueOf(document.getFolderId()));
		}

		if (document.getGroupId() == null) {
			map.put("groupId", null);
		}
		else {
			map.put("groupId", String.valueOf(document.getGroupId()));
		}

		if (document.getMimeType() == null) {
			map.put("mimeType", null);
		}
		else {
			map.put("mimeType", String.valueOf(document.getMimeType()));
		}

		if (document.getModifiedDate() == null) {
			map.put("modifiedDate", null);
		}
		else {
			map.put(
				"modifiedDate",
				liferayToJSONDateFormat.format(document.getModifiedDate()));
		}

		if (document.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(document.getName()));
		}

		if (document.getRepositoryId() == null) {
			map.put("repositoryId", null);
		}
		else {
			map.put("repositoryId", String.valueOf(document.getRepositoryId()));
		}

		if (document.getSize() == null) {
			map.put("size", null);
		}
		else {
			map.put("size", String.valueOf(document.getSize()));
		}

		if (document.getTags() == null) {
			map.put("tags", null);
		}
		else {
			map.put("tags", String.valueOf(document.getTags()));
		}

		if (document.getTitle() == null) {
			map.put("title", null);
		}
		else {
			map.put("title", String.valueOf(document.getTitle()));
		}

		if (document.getType() == null) {
			map.put("type", null);
		}
		else {
			map.put("type", String.valueOf(document.getType()));
		}

		if (document.getUserId() == null) {
			map.put("userId", null);
		}
		else {
			map.put("userId", String.valueOf(document.getUserId()));
		}

		if (document.getVersion() == null) {
			map.put("version", null);
		}
		else {
			map.put("version", String.valueOf(document.getVersion()));
		}

		return map;
	}

	public static class DocumentJSONParser extends BaseJSONParser<Document> {

		@Override
		protected Document createDTO() {
			return new Document();
		}

		@Override
		protected Document[] createDTOArray(int size) {
			return new Document[size];
		}

		@Override
		protected void setField(
			Document document, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "address")) {
				if (jsonParserFieldValue != null) {
					document.setAddress((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "changeLog")) {
				if (jsonParserFieldValue != null) {
					document.setChangeLog((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "city")) {
				if (jsonParserFieldValue != null) {
					document.setCity((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "companyId")) {
				if (jsonParserFieldValue != null) {
					document.setCompanyId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "createDate")) {
				if (jsonParserFieldValue != null) {
					document.setCreateDate(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					document.setDescription((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fileEntryId")) {
				if (jsonParserFieldValue != null) {
					document.setFileEntryId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fileEntryTypeId")) {
				if (jsonParserFieldValue != null) {
					document.setFileEntryTypeId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "fileEntryTypeIdName")) {

				if (jsonParserFieldValue != null) {
					document.setFileEntryTypeIdName(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fileName")) {
				if (jsonParserFieldValue != null) {
					document.setFileName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "folderId")) {
				if (jsonParserFieldValue != null) {
					document.setFolderId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "groupId")) {
				if (jsonParserFieldValue != null) {
					document.setGroupId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "mimeType")) {
				if (jsonParserFieldValue != null) {
					document.setMimeType((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "modifiedDate")) {
				if (jsonParserFieldValue != null) {
					document.setModifiedDate(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					document.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "repositoryId")) {
				if (jsonParserFieldValue != null) {
					document.setRepositoryId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "size")) {
				if (jsonParserFieldValue != null) {
					document.setSize(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "tags")) {
				if (jsonParserFieldValue != null) {
					document.setTags(toStrings((Object[])jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "title")) {
				if (jsonParserFieldValue != null) {
					document.setTitle((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "type")) {
				if (jsonParserFieldValue != null) {
					document.setType(
						Document.Type.create((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "userId")) {
				if (jsonParserFieldValue != null) {
					document.setUserId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "version")) {
				if (jsonParserFieldValue != null) {
					document.setVersion((String)jsonParserFieldValue);
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}