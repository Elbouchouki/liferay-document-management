package com.liferay.gwenod.rest.client.serdes.v1_0;

import com.liferay.gwenod.rest.client.dto.v1_0.File;
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
public class FileSerDes {

	public static File toDTO(String json) {
		FileJSONParser fileJSONParser = new FileJSONParser();

		return fileJSONParser.parseToDTO(json);
	}

	public static File[] toDTOs(String json) {
		FileJSONParser fileJSONParser = new FileJSONParser();

		return fileJSONParser.parseToDTOs(json);
	}

	public static String toJSON(File file) {
		if (file == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (file.getFileName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileName\": ");

			sb.append("\"");

			sb.append(_escape(file.getFileName()));

			sb.append("\"");
		}

		if (file.getFilePath() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"filePath\": ");

			sb.append("\"");

			sb.append(_escape(file.getFilePath()));

			sb.append("\"");
		}

		if (file.getFileVersion() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileVersion\": ");

			sb.append(file.getFileVersion());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		FileJSONParser fileJSONParser = new FileJSONParser();

		return fileJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(File file) {
		if (file == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (file.getFileName() == null) {
			map.put("fileName", null);
		}
		else {
			map.put("fileName", String.valueOf(file.getFileName()));
		}

		if (file.getFilePath() == null) {
			map.put("filePath", null);
		}
		else {
			map.put("filePath", String.valueOf(file.getFilePath()));
		}

		if (file.getFileVersion() == null) {
			map.put("fileVersion", null);
		}
		else {
			map.put("fileVersion", String.valueOf(file.getFileVersion()));
		}

		return map;
	}

	public static class FileJSONParser extends BaseJSONParser<File> {

		@Override
		protected File createDTO() {
			return new File();
		}

		@Override
		protected File[] createDTOArray(int size) {
			return new File[size];
		}

		@Override
		protected void setField(
			File file, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "fileName")) {
				if (jsonParserFieldValue != null) {
					file.setFileName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "filePath")) {
				if (jsonParserFieldValue != null) {
					file.setFilePath((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fileVersion")) {
				if (jsonParserFieldValue != null) {
					file.setFileVersion(
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