package com.liferay.gwenod.rest.client.serdes.v1_0;

import com.liferay.gwenod.rest.client.dto.v1_0.DocumentCreationRequest;
import com.liferay.gwenod.rest.client.json.BaseJSONParser;

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
public class DocumentCreationRequestSerDes {

	public static DocumentCreationRequest toDTO(String json) {
		DocumentCreationRequestJSONParser documentCreationRequestJSONParser =
			new DocumentCreationRequestJSONParser();

		return documentCreationRequestJSONParser.parseToDTO(json);
	}

	public static DocumentCreationRequest[] toDTOs(String json) {
		DocumentCreationRequestJSONParser documentCreationRequestJSONParser =
			new DocumentCreationRequestJSONParser();

		return documentCreationRequestJSONParser.parseToDTOs(json);
	}

	public static String toJSON(
		DocumentCreationRequest documentCreationRequest) {

		if (documentCreationRequest == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (documentCreationRequest.getAddress() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"address\": ");

			sb.append("\"");

			sb.append(_escape(documentCreationRequest.getAddress()));

			sb.append("\"");
		}

		if (documentCreationRequest.getCity() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"city\": ");

			sb.append("\"");

			sb.append(_escape(documentCreationRequest.getCity()));

			sb.append("\"");
		}

		if (documentCreationRequest.getFile() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"file\": ");

			sb.append("\"");

			sb.append(_escape(documentCreationRequest.getFile()));

			sb.append("\"");
		}

		if (documentCreationRequest.getFilename() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"filename\": ");

			sb.append("\"");

			sb.append(_escape(documentCreationRequest.getFilename()));

			sb.append("\"");
		}

		if (documentCreationRequest.getItems() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"items\": ");

			sb.append("\"");

			sb.append(_escape(documentCreationRequest.getItems()));

			sb.append("\"");
		}

		if (documentCreationRequest.getTags() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"tags\": ");

			sb.append("[");

			for (int i = 0; i < documentCreationRequest.getTags().length; i++) {
				sb.append("\"");

				sb.append(_escape(documentCreationRequest.getTags()[i]));

				sb.append("\"");

				if ((i + 1) < documentCreationRequest.getTags().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (documentCreationRequest.getTitle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"title\": ");

			sb.append("\"");

			sb.append(_escape(documentCreationRequest.getTitle()));

			sb.append("\"");
		}

		if (documentCreationRequest.getType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"type\": ");

			sb.append("\"");

			sb.append(documentCreationRequest.getType());

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		DocumentCreationRequestJSONParser documentCreationRequestJSONParser =
			new DocumentCreationRequestJSONParser();

		return documentCreationRequestJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		DocumentCreationRequest documentCreationRequest) {

		if (documentCreationRequest == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (documentCreationRequest.getAddress() == null) {
			map.put("address", null);
		}
		else {
			map.put(
				"address",
				String.valueOf(documentCreationRequest.getAddress()));
		}

		if (documentCreationRequest.getCity() == null) {
			map.put("city", null);
		}
		else {
			map.put("city", String.valueOf(documentCreationRequest.getCity()));
		}

		if (documentCreationRequest.getFile() == null) {
			map.put("file", null);
		}
		else {
			map.put("file", String.valueOf(documentCreationRequest.getFile()));
		}

		if (documentCreationRequest.getFilename() == null) {
			map.put("filename", null);
		}
		else {
			map.put(
				"filename",
				String.valueOf(documentCreationRequest.getFilename()));
		}

		if (documentCreationRequest.getItems() == null) {
			map.put("items", null);
		}
		else {
			map.put(
				"items", String.valueOf(documentCreationRequest.getItems()));
		}

		if (documentCreationRequest.getTags() == null) {
			map.put("tags", null);
		}
		else {
			map.put("tags", String.valueOf(documentCreationRequest.getTags()));
		}

		if (documentCreationRequest.getTitle() == null) {
			map.put("title", null);
		}
		else {
			map.put(
				"title", String.valueOf(documentCreationRequest.getTitle()));
		}

		if (documentCreationRequest.getType() == null) {
			map.put("type", null);
		}
		else {
			map.put("type", String.valueOf(documentCreationRequest.getType()));
		}

		return map;
	}

	public static class DocumentCreationRequestJSONParser
		extends BaseJSONParser<DocumentCreationRequest> {

		@Override
		protected DocumentCreationRequest createDTO() {
			return new DocumentCreationRequest();
		}

		@Override
		protected DocumentCreationRequest[] createDTOArray(int size) {
			return new DocumentCreationRequest[size];
		}

		@Override
		protected void setField(
			DocumentCreationRequest documentCreationRequest,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "address")) {
				if (jsonParserFieldValue != null) {
					documentCreationRequest.setAddress(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "city")) {
				if (jsonParserFieldValue != null) {
					documentCreationRequest.setCity(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "file")) {
				if (jsonParserFieldValue != null) {
					documentCreationRequest.setFile(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "filename")) {
				if (jsonParserFieldValue != null) {
					documentCreationRequest.setFilename(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "items")) {
				if (jsonParserFieldValue != null) {
					documentCreationRequest.setItems(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "tags")) {
				if (jsonParserFieldValue != null) {
					documentCreationRequest.setTags(
						toStrings((Object[])jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "title")) {
				if (jsonParserFieldValue != null) {
					documentCreationRequest.setTitle(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "type")) {
				if (jsonParserFieldValue != null) {
					documentCreationRequest.setType(
						DocumentCreationRequest.Type.create(
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