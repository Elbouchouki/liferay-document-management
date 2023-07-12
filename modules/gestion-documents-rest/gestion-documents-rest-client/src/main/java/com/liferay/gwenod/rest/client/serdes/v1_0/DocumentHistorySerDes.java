package com.liferay.gwenod.rest.client.serdes.v1_0;

import com.liferay.gwenod.rest.client.dto.v1_0.DocumentHistory;
import com.liferay.gwenod.rest.client.json.BaseJSONParser;

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
public class DocumentHistorySerDes {

	public static DocumentHistory toDTO(String json) {
		DocumentHistoryJSONParser documentHistoryJSONParser =
			new DocumentHistoryJSONParser();

		return documentHistoryJSONParser.parseToDTO(json);
	}

	public static DocumentHistory[] toDTOs(String json) {
		DocumentHistoryJSONParser documentHistoryJSONParser =
			new DocumentHistoryJSONParser();

		return documentHistoryJSONParser.parseToDTOs(json);
	}

	public static String toJSON(DocumentHistory documentHistory) {
		if (documentHistory == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ssXX");

		if (documentHistory.getAddress() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"address\": ");

			sb.append("\"");

			sb.append(_escape(documentHistory.getAddress()));

			sb.append("\"");
		}

		if (documentHistory.getCity() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"city\": ");

			sb.append("\"");

			sb.append(_escape(documentHistory.getCity()));

			sb.append("\"");
		}

		if (documentHistory.getFile() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"file\": ");

			sb.append(String.valueOf(documentHistory.getFile()));
		}

		if (documentHistory.getHistoryId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"historyId\": ");

			sb.append(documentHistory.getHistoryId());
		}

		if (documentHistory.getTags() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"tags\": ");

			sb.append("[");

			for (int i = 0; i < documentHistory.getTags().length; i++) {
				sb.append("\"");

				sb.append(_escape(documentHistory.getTags()[i]));

				sb.append("\"");

				if ((i + 1) < documentHistory.getTags().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (documentHistory.getTitle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"title\": ");

			sb.append("\"");

			sb.append(_escape(documentHistory.getTitle()));

			sb.append("\"");
		}

		if (documentHistory.getVersionDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"versionDate\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(
					documentHistory.getVersionDate()));

			sb.append("\"");
		}

		if (documentHistory.getVersionModifier() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"versionModifier\": ");

			sb.append(documentHistory.getVersionModifier());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		DocumentHistoryJSONParser documentHistoryJSONParser =
			new DocumentHistoryJSONParser();

		return documentHistoryJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(DocumentHistory documentHistory) {
		if (documentHistory == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ssXX");

		if (documentHistory.getAddress() == null) {
			map.put("address", null);
		}
		else {
			map.put("address", String.valueOf(documentHistory.getAddress()));
		}

		if (documentHistory.getCity() == null) {
			map.put("city", null);
		}
		else {
			map.put("city", String.valueOf(documentHistory.getCity()));
		}

		if (documentHistory.getFile() == null) {
			map.put("file", null);
		}
		else {
			map.put("file", String.valueOf(documentHistory.getFile()));
		}

		if (documentHistory.getHistoryId() == null) {
			map.put("historyId", null);
		}
		else {
			map.put(
				"historyId", String.valueOf(documentHistory.getHistoryId()));
		}

		if (documentHistory.getTags() == null) {
			map.put("tags", null);
		}
		else {
			map.put("tags", String.valueOf(documentHistory.getTags()));
		}

		if (documentHistory.getTitle() == null) {
			map.put("title", null);
		}
		else {
			map.put("title", String.valueOf(documentHistory.getTitle()));
		}

		if (documentHistory.getVersionDate() == null) {
			map.put("versionDate", null);
		}
		else {
			map.put(
				"versionDate",
				liferayToJSONDateFormat.format(
					documentHistory.getVersionDate()));
		}

		if (documentHistory.getVersionModifier() == null) {
			map.put("versionModifier", null);
		}
		else {
			map.put(
				"versionModifier",
				String.valueOf(documentHistory.getVersionModifier()));
		}

		return map;
	}

	public static class DocumentHistoryJSONParser
		extends BaseJSONParser<DocumentHistory> {

		@Override
		protected DocumentHistory createDTO() {
			return new DocumentHistory();
		}

		@Override
		protected DocumentHistory[] createDTOArray(int size) {
			return new DocumentHistory[size];
		}

		@Override
		protected void setField(
			DocumentHistory documentHistory, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "address")) {
				if (jsonParserFieldValue != null) {
					documentHistory.setAddress((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "city")) {
				if (jsonParserFieldValue != null) {
					documentHistory.setCity((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "file")) {
				if (jsonParserFieldValue != null) {
					documentHistory.setFile(
						FileSerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "historyId")) {
				if (jsonParserFieldValue != null) {
					documentHistory.setHistoryId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "tags")) {
				if (jsonParserFieldValue != null) {
					documentHistory.setTags(
						toStrings((Object[])jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "title")) {
				if (jsonParserFieldValue != null) {
					documentHistory.setTitle((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "versionDate")) {
				if (jsonParserFieldValue != null) {
					documentHistory.setVersionDate(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "versionModifier")) {
				if (jsonParserFieldValue != null) {
					documentHistory.setVersionModifier(
						Long.valueOf((String)jsonParserFieldValue));
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