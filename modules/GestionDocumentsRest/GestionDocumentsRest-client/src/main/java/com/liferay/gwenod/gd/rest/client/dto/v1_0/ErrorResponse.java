package com.liferay.gwenod.gd.rest.client.dto.v1_0;

import com.liferay.gwenod.gd.rest.client.function.UnsafeSupplier;
import com.liferay.gwenod.gd.rest.client.serdes.v1_0.ErrorResponseSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author elbou
 * @generated
 */
@Generated("")
public class ErrorResponse implements Cloneable, Serializable {

	public static ErrorResponse toDTO(String json) {
		return ErrorResponseSerDes.toDTO(json);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public void setCode(UnsafeSupplier<Integer, Exception> codeUnsafeSupplier) {
		try {
			code = codeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer code;

	public String[] getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(String[] fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

	public void setFieldErrors(
		UnsafeSupplier<String[], Exception> fieldErrorsUnsafeSupplier) {

		try {
			fieldErrors = fieldErrorsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String[] fieldErrors;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setMessage(
		UnsafeSupplier<String, Exception> messageUnsafeSupplier) {

		try {
			message = messageUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String message;

	@Override
	public ErrorResponse clone() throws CloneNotSupportedException {
		return (ErrorResponse)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ErrorResponse)) {
			return false;
		}

		ErrorResponse errorResponse = (ErrorResponse)object;

		return Objects.equals(toString(), errorResponse.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return ErrorResponseSerDes.toJSON(this);
	}

}