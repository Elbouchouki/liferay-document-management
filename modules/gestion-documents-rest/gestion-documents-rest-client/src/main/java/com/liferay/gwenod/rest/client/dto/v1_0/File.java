package com.liferay.gwenod.rest.client.dto.v1_0;

import com.liferay.gwenod.rest.client.function.UnsafeSupplier;
import com.liferay.gwenod.rest.client.serdes.v1_0.FileSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author elbou
 * @generated
 */
@Generated("")
public class File implements Cloneable, Serializable {

	public static File toDTO(String json) {
		return FileSerDes.toDTO(json);
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setFileName(
		UnsafeSupplier<String, Exception> fileNameUnsafeSupplier) {

		try {
			fileName = fileNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String fileName;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void setFilePath(
		UnsafeSupplier<String, Exception> filePathUnsafeSupplier) {

		try {
			filePath = filePathUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String filePath;

	public Long getFileVersion() {
		return fileVersion;
	}

	public void setFileVersion(Long fileVersion) {
		this.fileVersion = fileVersion;
	}

	public void setFileVersion(
		UnsafeSupplier<Long, Exception> fileVersionUnsafeSupplier) {

		try {
			fileVersion = fileVersionUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long fileVersion;

	@Override
	public File clone() throws CloneNotSupportedException {
		return (File)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof File)) {
			return false;
		}

		File file = (File)object;

		return Objects.equals(toString(), file.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return FileSerDes.toJSON(this);
	}

}