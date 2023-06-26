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
 * The table class for the &quot;dgf_users_fortnight_report_d&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersForthnightReportD
 * @generated
 */
public class DgfUsersForthnightReportDTable
	extends BaseTable<DgfUsersForthnightReportDTable> {

	public static final DgfUsersForthnightReportDTable INSTANCE =
		new DgfUsersForthnightReportDTable();

	public final Column<DgfUsersForthnightReportDTable, Long> reportId =
		createColumn("reportId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DgfUsersForthnightReportDTable, Long> userId =
		createColumn("userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportDTable, String> usernationalId =
		createColumn(
			"usernationalId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportDTable, String> screenName =
		createColumn(
			"screenName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportDTable, String> fullName =
		createColumn(
			"fullName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportDTable, String> productType =
		createColumn(
			"productType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportDTable, Date> startDate =
		createColumn(
			"startDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportDTable, Date> endDate =
		createColumn(
			"endDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportDTable, String> product =
		createColumn(
			"product", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportDTable, Integer> initalStockOn =
		createColumn(
			"initalStockOn", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportDTable, String>
		initalStockOnUnit = createColumn(
			"initalStockOnUnit", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportDTable, Integer>
		recivedQuantity = createColumn(
			"recivedQuantity", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportDTable, String>
		recivedQuantityUnit = createColumn(
			"recivedQuantityUnit", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportDTable, Integer>
		sellingQuantity = createColumn(
			"sellingQuantity", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportDTable, String>
		sellingQuantityUnit = createColumn(
			"sellingQuantityUnit", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportDTable, Integer>
		quantityOfFinishingStock = createColumn(
			"quantityOfFinishingStock", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportDTable, String>
		quantityOfFinishingStockUnit = createColumn(
			"quantityOfFinishingStockUnit", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportDTable, String> comment =
		createColumn(
			"comment_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportDTable, String> nationalId =
		createColumn(
			"nationalId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private DgfUsersForthnightReportDTable() {
		super(
			"dgf_users_fortnight_report_d",
			DgfUsersForthnightReportDTable::new);
	}

}