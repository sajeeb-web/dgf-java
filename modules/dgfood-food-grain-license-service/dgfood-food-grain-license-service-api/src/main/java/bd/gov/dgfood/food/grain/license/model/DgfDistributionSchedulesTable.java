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
 * The table class for the &quot;dgf_distribution_schedules&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDistributionSchedules
 * @generated
 */
public class DgfDistributionSchedulesTable
	extends BaseTable<DgfDistributionSchedulesTable> {

	public static final DgfDistributionSchedulesTable INSTANCE =
		new DgfDistributionSchedulesTable();

	public final Column<DgfDistributionSchedulesTable, String> id =
		createColumn("id", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<DgfDistributionSchedulesTable, Long> distributionYear =
		createColumn(
			"distribution_year", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDistributionSchedulesTable, String>
		distributionMonth = createColumn(
			"distribution_month", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDistributionSchedulesTable, String> openStatus =
		createColumn(
			"open_status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDistributionSchedulesTable, Date> startDate =
		createColumn(
			"start_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfDistributionSchedulesTable, Date> endDate =
		createColumn(
			"end_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfDistributionSchedulesTable, String> remarks =
		createColumn(
			"remarks", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDistributionSchedulesTable, Long> userId =
		createColumn("user_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDistributionSchedulesTable, Date> createdAt =
		createColumn(
			"created_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfDistributionSchedulesTable, Date> updatedAt =
		createColumn(
			"updated_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private DgfDistributionSchedulesTable() {
		super("dgf_distribution_schedules", DgfDistributionSchedulesTable::new);
	}

}