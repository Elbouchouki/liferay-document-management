package com.liferay.gwenod.rest.client.dto.v1_0;

import com.liferay.gwenod.rest.client.function.UnsafeSupplier;
import com.liferay.gwenod.rest.client.serdes.v1_0.DocumentHistorySerDes;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author elbou
 * @generated
 */
@Generated("")
public class DocumentHistory implements Cloneable, Serializable {

	public static DocumentHistory toDTO(String json) {
		return DocumentHistorySerDes.toDTO(json);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAddress(
		UnsafeSupplier<String, Exception> addressUnsafeSupplier) {

		try {
			address = addressUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String address;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCity(UnsafeSupplier<String, Exception> cityUnsafeSupplier) {
		try {
			city = cityUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String city;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public void setFile(UnsafeSupplier<File, Exception> fileUnsafeSupplier) {
		try {
			file = fileUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected File file;

	public Long getHistoryId() {
		return historyId;
	}

	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}

	public void setHistoryId(
		UnsafeSupplier<Long, Exception> historyIdUnsafeSupplier) {

		try {
			historyId = historyIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long historyId;

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public void setTags(
		UnsafeSupplier<String[], Exception> tagsUnsafeSupplier) {

		try {
			tags = tagsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String[] tags;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTitle(
		UnsafeSupplier<String, Exception> titleUnsafeSupplier) {

		try {
			title = titleUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String title;

	public Date getVersionDate() {
		return versionDate;
	}

	public void setVersionDate(Date versionDate) {
		this.versionDate = versionDate;
	}

	public void setVersionDate(
		UnsafeSupplier<Date, Exception> versionDateUnsafeSupplier) {

		try {
			versionDate = versionDateUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date versionDate;

	public Long getVersionModifier() {
		return versionModifier;
	}

	public void setVersionModifier(Long versionModifier) {
		this.versionModifier = versionModifier;
	}

	public void setVersionModifier(
		UnsafeSupplier<Long, Exception> versionModifierUnsafeSupplier) {

		try {
			versionModifier = versionModifierUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long versionModifier;

	@Override
	public DocumentHistory clone() throws CloneNotSupportedException {
		return (DocumentHistory)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DocumentHistory)) {
			return false;
		}

		DocumentHistory documentHistory = (DocumentHistory)object;

		return Objects.equals(toString(), documentHistory.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return DocumentHistorySerDes.toJSON(this);
	}

}