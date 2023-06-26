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
 * The table class for the &quot;dgf_loc_district&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see dgfLocDistrict
 * @generated
 */
public class dgfLocDistrictTable extends BaseTable<dgfLocDistrictTable> {

	public static final dgfLocDistrictTable INSTANCE =
		new dgfLocDistrictTable();

	public final Column<dgfLocDistrictTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<dgfLocDistrictTable, Long> divisionId = createColumn(
		"divisionId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<dgfLocDistrictTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<dgfLocDistrictTable, String> bnName = createColumn(
		"bnName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<dgfLocDistrictTable, String> lat = createColumn(
		"lat", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<dgfLocDistrictTable, String> lon = createColumn(
		"lon", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<dgfLocDistrictTable, String> url = createColumn(
		"url", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<dgfLocDistrictTable, String> status = createColumn(
		"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<dgfLocDistrictTable, Date> createdAt = createColumn(
		"createdAt", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<dgfLocDistrictTable, Date> updatedAt = createColumn(
		"updatedAt", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<dgfLocDistrictTable, Long> geoCode = createColumn(
		"geoCode", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private dgfLocDistrictTable() {
		super("dgf_loc_district", dgfLocDistrictTable::new);
	}

}