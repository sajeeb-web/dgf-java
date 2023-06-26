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
 * The table class for the &quot;dgf_loc_division&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see dgfLocDivision
 * @generated
 */
public class dgfLocDivisionTable extends BaseTable<dgfLocDivisionTable> {

	public static final dgfLocDivisionTable INSTANCE =
		new dgfLocDivisionTable();

	public final Column<dgfLocDivisionTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<dgfLocDivisionTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<dgfLocDivisionTable, String> bnName = createColumn(
		"bnName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<dgfLocDivisionTable, String> url = createColumn(
		"url", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<dgfLocDivisionTable, String> status = createColumn(
		"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<dgfLocDivisionTable, Date> createdAt = createColumn(
		"createdAt", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<dgfLocDivisionTable, Date> updatedAt = createColumn(
		"updatedAt", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<dgfLocDivisionTable, Long> geoCode = createColumn(
		"geoCode", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private dgfLocDivisionTable() {
		super("dgf_loc_division", dgfLocDivisionTable::new);
	}

}