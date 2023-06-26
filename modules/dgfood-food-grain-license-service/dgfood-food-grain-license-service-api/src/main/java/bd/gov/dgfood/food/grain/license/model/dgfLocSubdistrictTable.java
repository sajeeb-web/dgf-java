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
 * The table class for the &quot;dgf_loc_subdistrict&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see dgfLocSubdistrict
 * @generated
 */
public class dgfLocSubdistrictTable extends BaseTable<dgfLocSubdistrictTable> {

	public static final dgfLocSubdistrictTable INSTANCE =
		new dgfLocSubdistrictTable();

	public final Column<dgfLocSubdistrictTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<dgfLocSubdistrictTable, Long> districtId = createColumn(
		"districtId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<dgfLocSubdistrictTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<dgfLocSubdistrictTable, String> bnName = createColumn(
		"bnName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<dgfLocSubdistrictTable, String> url = createColumn(
		"url", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<dgfLocSubdistrictTable, String> status = createColumn(
		"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<dgfLocSubdistrictTable, Date> createdAt = createColumn(
		"createdAt", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<dgfLocSubdistrictTable, Date> updatedAt = createColumn(
		"updatedAt", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<dgfLocSubdistrictTable, Long> geoCode = createColumn(
		"geoCode", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<dgfLocSubdistrictTable, String> roleName = createColumn(
		"roleName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private dgfLocSubdistrictTable() {
		super("dgf_loc_subdistrict", dgfLocSubdistrictTable::new);
	}

}