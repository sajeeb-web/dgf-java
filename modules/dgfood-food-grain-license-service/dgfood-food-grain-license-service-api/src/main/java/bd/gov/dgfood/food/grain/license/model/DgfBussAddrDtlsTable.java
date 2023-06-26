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

/**
 * The table class for the &quot;dgf_buss_addr_dtls&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DgfBussAddrDtls
 * @generated
 */
public class DgfBussAddrDtlsTable extends BaseTable<DgfBussAddrDtlsTable> {

	public static final DgfBussAddrDtlsTable INSTANCE =
		new DgfBussAddrDtlsTable();

	public final Column<DgfBussAddrDtlsTable, Long> businessAddressId =
		createColumn(
			"businessAddressId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DgfBussAddrDtlsTable, Long> nationalId = createColumn(
		"nationalId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfBussAddrDtlsTable, Long> businessDivision =
		createColumn(
			"businessDivision", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfBussAddrDtlsTable, Long> businessDistrict =
		createColumn(
			"businessDistrict", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfBussAddrDtlsTable, Long> businessUpzilla =
		createColumn(
			"businessUpzilla", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfBussAddrDtlsTable, Long> businessUnionName =
		createColumn(
			"businessUnionName", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfBussAddrDtlsTable, String> businessVillage =
		createColumn(
			"businessVillage", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfBussAddrDtlsTable, String> businessWard =
		createColumn(
			"businessWard", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfBussAddrDtlsTable, String> businessZipCode =
		createColumn(
			"businessZipCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfBussAddrDtlsTable, String> businessPostOffice =
		createColumn(
			"businessPostOffice", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfBussAddrDtlsTable, String> businessHouseAddress =
		createColumn(
			"businessHouseAddress", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private DgfBussAddrDtlsTable() {
		super("dgf_buss_addr_dtls", DgfBussAddrDtlsTable::new);
	}

}