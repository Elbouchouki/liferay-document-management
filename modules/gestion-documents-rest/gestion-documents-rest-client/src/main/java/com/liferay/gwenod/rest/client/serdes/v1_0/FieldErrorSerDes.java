package com.liferay.gwenod.rest.client.serdes.v1_0;

import com.liferay.gwenod.rest.client.dto.v1_0.FieldError;
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
public class FieldErrorSerDes {

	public static FieldError toDTO(String json) {
		FieldErrorJSONParser fieldErrorJSONParser = new FieldErrorJSONParser();

		return fieldErrorJSONParser.parseToDTO(json);
	}

	public static FieldError[] toDTOs(String json) {
		FieldErrorJSONParser fieldErrorJSONParser = new FieldErrorJSONParser();

		return fieldErrorJSONParser.parseToDTOs(json);
	}

	public static String toJSON(FieldError fieldError) {
		if (fieldError == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (fieldError.getMessage() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"message\": ");

			sb.append("\"");

			sb.append(_escape(fieldError.getMessage()));

			sb.append("\"");
		}

		if (fieldError.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(fieldError.getName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		FieldErrorJSONParser fieldErrorJSONParser = new FieldErrorJSONParser();

		return fieldErrorJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(FieldError fieldError) {
		if (fieldError == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (fieldError.getMessage() == null) {
			map.put("message", null);
		}
		else {
			map.put("message", String.valueOf(fieldError.getMessage()));
		}

		if (fieldError.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(fieldError.getName()));
		}

		return map;
	}

	public static class FieldErrorJSONParser
		extends BaseJSONParser<FieldError> {

		@Override
		protected FieldError createDTO() {
			return new FieldError();
		}

		@Override
		protected FieldError[] createDTOArray(int size) {
			return new FieldError[size];
		}

		@Override
		protected void setField(
			FieldError fieldError, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "message")) {
				if (jsonParserFieldValue != null) {
					fieldError.setMessage((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					fieldError.setName((String)jsonParserFieldValue);
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