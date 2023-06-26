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
 * The table class for the &quot;dgf_users_fortnight_report_c&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersForthnightReportC
 * @generated
 */
public class DgfUsersForthnightReportCTable
	extends BaseTable<DgfUsersForthnightReportCTable> {

	public static final DgfUsersForthnightReportCTable INSTANCE =
		new DgfUsersForthnightReportCTable();

	public final Column<DgfUsersForthnightReportCTable, Long> reportId =
		createColumn("reportId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DgfUsersForthnightReportCTable, Long> userId =
		createColumn("userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportCTable, String> usernationalId =
		createColumn(
			"usernationalId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportCTable, String> screenName =
		createColumn(
			"screenName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportCTable, String> fullName =
		createColumn(
			"fullName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportCTable, String> productType =
		createColumn(
			"productType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportCTable, Date> startDate =
		createColumn(
			"startDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportCTable, Date> endDate =
		createColumn(
			"endDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportCTable, String> product =
		createColumn(
			"product", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportCTable, Date> daterecipt =
		createColumn(
			"daterecipt", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportCTable, Integer>
		receivedQuantity = createColumn(
			"receivedQuantity", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportCTable, String>
		receivedQuantityUnit = createColumn(
			"receivedQuantityUnit", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportCTable, Date> lastDateApprove =
		createColumn(
			"lastDateApprove", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportCTable, Integer>
		unsoldQuantity = createColumn(
			"unsoldQuantity", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportCTable, String> unsolddunit =
		createColumn(
			"unsolddunit", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersForthnightReportCTable, String>
		reasonForBeingUnsold = createColumn(
			"reasonForBeingUnsold", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private DgfUsersForthnightReportCTable() {
		super(
			"dgf_users_fortnight_report_c",
			DgfUsersForthnightReportCTable::new);
	}

}