/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.gwenod.gestiondocuments.service.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;GDHistory&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DocumentHistory
 * @generated
 */
public class DocumentHistoryTable extends BaseTable<DocumentHistoryTable> {

	public static final DocumentHistoryTable INSTANCE =
		new DocumentHistoryTable();

	public final Column<DocumentHistoryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DocumentHistoryTable, Long> historyId = createColumn(
		"historyId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DocumentHistoryTable, Date> versionDate = createColumn(
		"versionDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DocumentHistoryTable, Long> versionModifier =
		createColumn(
			"versionModifier", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DocumentHistoryTable, Long> documentId = createColumn(
		"documentId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DocumentHistoryTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DocumentHistoryTable, String> filepath = createColumn(
		"filepath", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DocumentHistoryTable, String> filename = createColumn(
		"filename", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DocumentHistoryTable, Long> fileversion = createColumn(
		"fileversion", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DocumentHistoryTable, String> tags = createColumn(
		"tags", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DocumentHistoryTable, String> city = createColumn(
		"city", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DocumentHistoryTable, String> address = createColumn(
		"address", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DocumentHistoryTable, String> description =
		createColumn(
			"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private DocumentHistoryTable() {
		super("GDHistory", DocumentHistoryTable::new);
	}

}