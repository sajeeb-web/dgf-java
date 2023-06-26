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
 * The table class for the &quot;dgf_dlr_distribution_dtls&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrDistributionDtls
 * @generated
 */
public class DgfDlrDistributionDtlsTable
	extends BaseTable<DgfDlrDistributionDtlsTable> {

	public static final DgfDlrDistributionDtlsTable INSTANCE =
		new DgfDlrDistributionDtlsTable();

	public final Column<DgfDlrDistributionDtlsTable, Long> id = createColumn(
		"id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DgfDlrDistributionDtlsTable, Long> dealerId =
		createColumn(
			"dealer_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrDistributionDtlsTable, Long> beneficiariesId =
		createColumn(
			"beneficiaries_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrDistributionDtlsTable, String>
		beneficiariesMobileNo = createColumn(
			"beneficiaries_mobile_no", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrDistributionDtlsTable, Long> cardNo =
		createColumn("card_no", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrDistributionDtlsTable, Long> unionId =
		createColumn("union_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrDistributionDtlsTable, Date> distributionDate =
		createColumn(
			"distribution_date", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrDistributionDtlsTable, Long> distributionQty =
		createColumn(
			"distribution_qty", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrDistributionDtlsTable, Integer> status =
		createColumn(
			"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<DgfDlrDistributionDtlsTable, Date> createdAt =
		createColumn(
			"created_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfDlrDistributionDtlsTable, Date> updatedAt =
		createColumn(
			"updated_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfDlrDistributionDtlsTable, Integer> month =
		createColumn(
			"month", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<DgfDlrDistributionDtlsTable, Integer> year =
		createColumn("year", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private DgfDlrDistributionDtlsTable() {
		super("dgf_dlr_distribution_dtls", DgfDlrDistributionDtlsTable::new);
	}

}