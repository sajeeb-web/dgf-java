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
 * The table class for the &quot;dgf_fgl_lic_dtls&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DgfFglLicDtls
 * @generated
 */
public class DgfFglLicDtlsTable extends BaseTable<DgfFglLicDtlsTable> {

	public static final DgfFglLicDtlsTable INSTANCE = new DgfFglLicDtlsTable();

	public final Column<DgfFglLicDtlsTable, Long> fglLicPrimaryId =
		createColumn(
			"fglLicPrimaryId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DgfFglLicDtlsTable, String> nationalId = createColumn(
		"nationalId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfFglLicDtlsTable, Long> fglPrePrimaryId =
		createColumn(
			"fglPrePrimaryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfFglLicDtlsTable, String> fglApplicationNo =
		createColumn(
			"fglApplicationNo", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfFglLicDtlsTable, String> foodgrainLicenseNo =
		createColumn(
			"foodgrainLicenseNo", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfFglLicDtlsTable, String> foodgrainLicenseType =
		createColumn(
			"foodgrainLicenseType", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfFglLicDtlsTable, String> tradeLicenseNo =
		createColumn(
			"tradeLicenseNo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfFglLicDtlsTable, Date> tradeLicenseExpiryDate =
		createColumn(
			"tradeLicenseExpiryDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<DgfFglLicDtlsTable, Date> foodgrainLicenseIssueDate =
		createColumn(
			"foodgrainLicenseIssueDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<DgfFglLicDtlsTable, Date> foodgrainLicenseExpiryDate =
		createColumn(
			"foodgrainLicenseExpiryDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<DgfFglLicDtlsTable, Long> foodgrainLicenseIssuedBy =
		createColumn(
			"foodgrainLicenseIssuedBy", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DgfFglLicDtlsTable, Long> fglLicenseVersion =
		createColumn(
			"fglLicenseVersion", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfFglLicDtlsTable, String> productType = createColumn(
		"productType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private DgfFglLicDtlsTable() {
		super("dgf_fgl_lic_dtls", DgfFglLicDtlsTable::new);
	}

}