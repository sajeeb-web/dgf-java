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
 * The table class for the &quot;dgf_users_addr_dtls&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersAddrDtls
 * @generated
 */
public class DgfUsersAddrDtlsTable extends BaseTable<DgfUsersAddrDtlsTable> {

	public static final DgfUsersAddrDtlsTable INSTANCE =
		new DgfUsersAddrDtlsTable();

	public final Column<DgfUsersAddrDtlsTable, Long> addressId = createColumn(
		"addressId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DgfUsersAddrDtlsTable, Long> nationalId = createColumn(
		"nationalId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfUsersAddrDtlsTable, Long> classPk = createColumn(
		"classPk", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfUsersAddrDtlsTable, String> className = createColumn(
		"className", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersAddrDtlsTable, String> addressType =
		createColumn(
			"addressType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersAddrDtlsTable, Long> division = createColumn(
		"division", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfUsersAddrDtlsTable, Long> district = createColumn(
		"district", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfUsersAddrDtlsTable, Long> upzilla = createColumn(
		"upzilla", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfUsersAddrDtlsTable, Long> unionName = createColumn(
		"unionName", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfUsersAddrDtlsTable, String> village = createColumn(
		"village", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersAddrDtlsTable, String> ward = createColumn(
		"ward", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersAddrDtlsTable, String> zipCode = createColumn(
		"zipCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersAddrDtlsTable, String> postOffice =
		createColumn(
			"postOffice", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersAddrDtlsTable, String> houseAddress =
		createColumn(
			"houseAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersAddrDtlsTable, Date> lastUpdatedDate =
		createColumn(
			"lastUpdatedDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<DgfUsersAddrDtlsTable, Date> lastUpdatedBy =
		createColumn(
			"lastUpdatedBy", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private DgfUsersAddrDtlsTable() {
		super("dgf_users_addr_dtls", DgfUsersAddrDtlsTable::new);
	}

}