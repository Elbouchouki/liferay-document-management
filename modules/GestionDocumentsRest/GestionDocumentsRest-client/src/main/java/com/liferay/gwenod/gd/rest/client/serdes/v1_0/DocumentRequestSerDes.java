package com.liferay.gwenod.gd.rest.client.serdes.v1_0;

import com.liferay.gwenod.gd.rest.client.dto.v1_0.DocumentRequest;
import com.liferay.gwenod.gd.rest.client.json.BaseJSONParser;

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
public class DocumentRequestSerDes {

	public static DocumentRequest toDTO(String json) {
		DocumentRequestJSONParser documentRequestJSONParser =
			new DocumentRequestJSONParser();

		return documentRequestJSONParser.parseToDTO(json);
	}

	public static DocumentRequest[] toDTOs(String json) {
		DocumentRequestJSONParser documentRequestJSONParser =
			new DocumentRequestJSONParser();

		return documentRequestJSONParser.parseToDTOs(json);
	}

	public static String toJSON(DocumentRequest documentRequest) {
		if (documentRequest == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (documentRequest.getAddress() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"address\": ");

			sb.append("\"");

			sb.append(_escape(documentRequest.getAddress()));

			sb.append("\"");
		}

		if (documentRequest.getCity() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"city\": ");

			sb.append("\"");

			sb.append(_escape(documentRequest.getCity()));

			sb.append("\"");
		}

		if (documentRequest.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(documentRequest.getDescription()));

			sb.append("\"");
		}

		if (documentRequest.getFile() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"file\": ");

			sb.append("\"");

			sb.append(_escape(documentRequest.getFile()));

			sb.append("\"");
		}

		if (documentRequest.getFilename() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"filename\": ");

			sb.append("\"");

			sb.append(_escape(documentRequest.getFilename()));

			sb.append("\"");
		}

		if (documentRequest.getItems() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"items\": ");

			sb.append("\"");

			sb.append(_escape(documentRequest.getItems()));

			sb.append("\"");
		}

		if (documentRequest.getTags() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"tags\": ");

			sb.append("[");

			for (int i = 0; i < documentRequest.getTags().length; i++) {
				sb.append("\"");

				sb.append(_escape(documentRequest.getTags()[i]));

				sb.append("\"");

				if ((i + 1) < documentRequest.getTags().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (documentRequest.getTitle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"title\": ");

			sb.append("\"");

			sb.append(_escape(documentRequest.getTitle()));

			sb.append("\"");
		}

		if (documentRequest.getType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"type\": ");

			sb.append("\"");

			sb.append(documentRequest.getType());

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		DocumentRequestJSONParser documentRequestJSONParser =
			new DocumentRequestJSONParser();

		return documentRequestJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(DocumentRequest documentRequest) {
		if (documentRequest == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (documentRequest.getAddress() == null) {
			map.put("address", null);
		}
		else {
			map.put("address", String.valueOf(documentRequest.getAddress()));
		}

		if (documentRequest.getCity() == null) {
			map.put("city", null);
		}
		else {
			map.put("city", String.valueOf(documentRequest.getCity()));
		}

		if (documentRequest.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put(
				"description",
				String.valueOf(documentRequest.getDescription()));
		}

		if (documentRequest.getFile() == null) {
			map.put("file", null);
		}
		else {
			map.put("file", String.valueOf(documentRequest.getFile()));
		}

		if (documentRequest.getFilename() == null) {
			map.put("filename", null);
		}
		else {
			map.put("filename", String.valueOf(documentRequest.getFilename()));
		}

		if (documentRequest.getItems() == null) {
			map.put("items", null);
		}
		else {
			map.put("items", String.valueOf(documentRequest.getItems()));
		}

		if (documentRequest.getTags() == null) {
			map.put("tags", null);
		}
		else {
			map.put("tags", String.valueOf(documentRequest.getTags()));
		}

		if (documentRequest.getTitle() == null) {
			map.put("title", null);
		}
		else {
			map.put("title", String.valueOf(documentRequest.getTitle()));
		}

		if (documentRequest.getType() == null) {
			map.put("type", null);
		}
		else {
			map.put("type", String.valueOf(documentRequest.getType()));
		}

		return map;
	}

	public static class DocumentRequestJSONParser
		extends BaseJSONParser<DocumentRequest> {

		@Override
		protected DocumentRequest createDTO() {
			return new DocumentRequest();
		}

		@Override
		protected DocumentRequest[] createDTOArray(int size) {
			return new DocumentRequest[size];
		}

		@Override
		protected void setField(
			DocumentRequest documentRequest, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "address")) {
				if (jsonParserFieldValue != null) {
					documentRequest.setAddress((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "city")) {
				if (jsonParserFieldValue != null) {
					documentRequest.setCity((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					documentRequest.setDescription(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "file")) {
				if (jsonParserFieldValue != null) {
					documentRequest.setFile((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "filename")) {
				if (jsonParserFieldValue != null) {
					documentRequest.setFilename((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "items")) {
				if (jsonParserFieldValue != null) {
					documentRequest.setItems((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "tags")) {
				if (jsonParserFieldValue != null) {
					documentRequest.setTags(
						toStrings((Object[])jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "title")) {
				if (jsonParserFieldValue != null) {
					documentRequest.setTitle((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "type")) {
				if (jsonParserFieldValue != null) {
					documentRequest.setType(
						DocumentRequest.Type.create(
							(String)jsonParserFieldValue));
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