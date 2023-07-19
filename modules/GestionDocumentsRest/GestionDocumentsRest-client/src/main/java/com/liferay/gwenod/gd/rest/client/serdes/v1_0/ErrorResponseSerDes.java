package com.liferay.gwenod.gd.rest.client.serdes.v1_0;

import com.liferay.gwenod.gd.rest.client.dto.v1_0.ErrorResponse;
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
public class ErrorResponseSerDes {

	public static ErrorResponse toDTO(String json) {
		ErrorResponseJSONParser errorResponseJSONParser =
			new ErrorResponseJSONParser();

		return errorResponseJSONParser.parseToDTO(json);
	}

	public static ErrorResponse[] toDTOs(String json) {
		ErrorResponseJSONParser errorResponseJSONParser =
			new ErrorResponseJSONParser();

		return errorResponseJSONParser.parseToDTOs(json);
	}

	public static String toJSON(ErrorResponse errorResponse) {
		if (errorResponse == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (errorResponse.getCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"code\": ");

			sb.append(errorResponse.getCode());
		}

		if (errorResponse.getFieldErrors() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fieldErrors\": ");

			sb.append("[");

			for (int i = 0; i < errorResponse.getFieldErrors().length; i++) {
				sb.append("\"");

				sb.append(_escape(errorResponse.getFieldErrors()[i]));

				sb.append("\"");

				if ((i + 1) < errorResponse.getFieldErrors().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (errorResponse.getMessage() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"message\": ");

			sb.append("\"");

			sb.append(_escape(errorResponse.getMessage()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ErrorResponseJSONParser errorResponseJSONParser =
			new ErrorResponseJSONParser();

		return errorResponseJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(ErrorResponse errorResponse) {
		if (errorResponse == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (errorResponse.getCode() == null) {
			map.put("code", null);
		}
		else {
			map.put("code", String.valueOf(errorResponse.getCode()));
		}

		if (errorResponse.getFieldErrors() == null) {
			map.put("fieldErrors", null);
		}
		else {
			map.put(
				"fieldErrors", String.valueOf(errorResponse.getFieldErrors()));
		}

		if (errorResponse.getMessage() == null) {
			map.put("message", null);
		}
		else {
			map.put("message", String.valueOf(errorResponse.getMessage()));
		}

		return map;
	}

	public static class ErrorResponseJSONParser
		extends BaseJSONParser<ErrorResponse> {

		@Override
		protected ErrorResponse createDTO() {
			return new ErrorResponse();
		}

		@Override
		protected ErrorResponse[] createDTOArray(int size) {
			return new ErrorResponse[size];
		}

		@Override
		protected void setField(
			ErrorResponse errorResponse, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "code")) {
				if (jsonParserFieldValue != null) {
					errorResponse.setCode(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fieldErrors")) {
				if (jsonParserFieldValue != null) {
					errorResponse.setFieldErrors(
						toStrings((Object[])jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "message")) {
				if (jsonParserFieldValue != null) {
					errorResponse.setMessage((String)jsonParserFieldValue);
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