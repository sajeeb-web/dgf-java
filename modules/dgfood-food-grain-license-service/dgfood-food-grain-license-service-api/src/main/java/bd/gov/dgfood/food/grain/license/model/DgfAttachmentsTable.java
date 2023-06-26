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

package bd.gov.dgfood.food.grain.license.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;dgf_attachments&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DgfAttachments
 * @generated
 */
public class DgfAttachmentsTable extends BaseTable<DgfAttachmentsTable> {

	public static final DgfAttachmentsTable INSTANCE =
		new DgfAttachmentsTable();

	public final Column<DgfAttachmentsTable, Long> attchmId = createColumn(
		"attchmId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DgfAttachmentsTable, Long> nationalId = createColumn(
		"nationalId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfAttachmentsTable, String> attachmentCatagory =
		createColumn(
			"attachmentCatagory", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfAttachmentsTable, Date> attachmntDate = createColumn(
		"attachmntDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfAttachmentsTable, Long> fileEntryId = createColumn(
		"fileEntryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfAttachmentsTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfAttachmentsTable, String> filePath = createColumn(
		"filePath", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfAttachmentsTable, Long> version = createColumn(
		"version", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfAttachmentsTable, Long> openTextId = createColumn(
		"openTextId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfAttachmentsTable, Long> status = createColumn(
		"status", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfAttachmentsTable, Date> lastUpdatedDate =
		createColumn(
			"lastUpdatedDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<DgfAttachmentsTable, Long> lastUpdatedBy = createColumn(
		"lastUpdatedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private DgfAttachmentsTable() {
		super("dgf_attachments", DgfAttachmentsTable::new);
	}

}