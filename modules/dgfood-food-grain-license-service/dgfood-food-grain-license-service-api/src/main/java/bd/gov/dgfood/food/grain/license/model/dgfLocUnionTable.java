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
 * The table class for the &quot;dgf_loc_union&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see dgfLocUnion
 * @generated
 */
public class dgfLocUnionTable extends BaseTable<dgfLocUnionTable> {

	public static final dgfLocUnionTable INSTANCE = new dgfLocUnionTable();

	public final Column<dgfLocUnionTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<dgfLocUnionTable, Long> subdistrictId = createColumn(
		"subdistrictId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<dgfLocUnionTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<dgfLocUnionTable, String> bnName = createColumn(
		"bnName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<dgfLocUnionTable, String> url = createColumn(
		"url", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<dgfLocUnionTable, String> status = createColumn(
		"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<dgfLocUnionTable, Date> createdAt = createColumn(
		"createdAt", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<dgfLocUnionTable, Date> updatedAt = createColumn(
		"updatedAt", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<dgfLocUnionTable, Long> geoCode = createColumn(
		"geoCode", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private dgfLocUnionTable() {
		super("dgf_loc_union", dgfLocUnionTable::new);
	}

}