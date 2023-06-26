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
 * The table class for the &quot;dgf_store_dtls&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DgfStoreDtls
 * @generated
 */
public class DgfStoreDtlsTable extends BaseTable<DgfStoreDtlsTable> {

	public static final DgfStoreDtlsTable INSTANCE = new DgfStoreDtlsTable();

	public final Column<DgfStoreDtlsTable, Long> id = createColumn(
		"id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DgfStoreDtlsTable, String> nationalId = createColumn(
		"national_id", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfStoreDtlsTable, String> type = createColumn(
		"type", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfStoreDtlsTable, String> mouza = createColumn(
		"mouza", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfStoreDtlsTable, String> khatiyn = createColumn(
		"khatiyn", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfStoreDtlsTable, String> DagNo = createColumn(
		"dag_no", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfStoreDtlsTable, Long> division = createColumn(
		"division", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfStoreDtlsTable, Long> district = createColumn(
		"district", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfStoreDtlsTable, Long> upzilla = createColumn(
		"upzilla", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfStoreDtlsTable, Long> unionName = createColumn(
		"union_name", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfStoreDtlsTable, Long> cityCrprtn = createColumn(
		"city_corporatn", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfStoreDtlsTable, String> dicsHight = createColumn(
		"dics_hight", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfStoreDtlsTable, String> dicsWidth = createColumn(
		"dics_width", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfStoreDtlsTable, String> dicsLngth = createColumn(
		"dics_lngth", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfStoreDtlsTable, Long> dicsCpacty = createColumn(
		"dics_cpacty", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfStoreDtlsTable, Long> totalCpacty = createColumn(
		"total_cpacty", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfStoreDtlsTable, Date> createdAt = createColumn(
		"created_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfStoreDtlsTable, Date> updatedAt = createColumn(
		"updated_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfStoreDtlsTable, Integer> flag = createColumn(
		"flag", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private DgfStoreDtlsTable() {
		super("dgf_store_dtls", DgfStoreDtlsTable::new);
	}

}