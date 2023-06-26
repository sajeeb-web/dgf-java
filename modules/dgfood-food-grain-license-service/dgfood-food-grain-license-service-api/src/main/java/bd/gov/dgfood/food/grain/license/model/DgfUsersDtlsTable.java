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
 * The table class for the &quot;dgf_users_dtls&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersDtls
 * @generated
 */
public class DgfUsersDtlsTable extends BaseTable<DgfUsersDtlsTable> {

	public static final DgfUsersDtlsTable INSTANCE = new DgfUsersDtlsTable();

	public final Column<DgfUsersDtlsTable, Long> userDetailsId = createColumn(
		"userDetailsId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DgfUsersDtlsTable, Long> nationalId = createColumn(
		"nationalId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfUsersDtlsTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersDtlsTable, Long> nidPhotoAttchId = createColumn(
		"nidPhotoAttchId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfUsersDtlsTable, String> nidDivision = createColumn(
		"nidDivision", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersDtlsTable, String> nidDistrict = createColumn(
		"nidDistrict", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersDtlsTable, String> nidUpzilla = createColumn(
		"nidUpzilla", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersDtlsTable, String> nidUnion = createColumn(
		"nidUnion", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersDtlsTable, String> nidVillage = createColumn(
		"nidVillage", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersDtlsTable, String> nidWard = createColumn(
		"nidWard", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersDtlsTable, String> nidZipCode = createColumn(
		"nidZipCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersDtlsTable, String> nidHouseAddress =
		createColumn(
			"nidHouseAddress", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfUsersDtlsTable, Date> lastUpdatedDate = createColumn(
		"lastUpdatedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfUsersDtlsTable, String> nidPostOffice = createColumn(
		"nidPostOffice", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private DgfUsersDtlsTable() {
		super("dgf_users_dtls", DgfUsersDtlsTable::new);
	}

}