package com.liferay.gwenod.rest.client.dto.v1_0;

import com.liferay.gwenod.rest.client.function.UnsafeSupplier;
import com.liferay.gwenod.rest.client.serdes.v1_0.FieldErrorSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author elbou
 * @generated
 */
@Generated("")
public class FieldError implements Cloneable, Serializable {

	public static FieldError toDTO(String json) {
		return FieldErrorSerDes.toDTO(json);
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		try {
			name = nameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String name;

	@Override
	public FieldError clone() throws CloneNotSupportedException {
		return (FieldError)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FieldError)) {
			return false;
		}

		FieldError fieldError = (FieldError)object;

		return Objects.equals(toString(), fieldError.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return FieldErrorSerDes.toJSON(this);
	}

}