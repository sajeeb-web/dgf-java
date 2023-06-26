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

package bd.gov.dgfood.food.friendly.program.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;dgf_ffp_oms_allc_ntfy_dtls&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DlrFfpOmsAllcNtfyDetails
 * @generated
 */
public class DlrFfpOmsAllcNtfyDetailsTable
	extends BaseTable<DlrFfpOmsAllcNtfyDetailsTable> {

	public static final DlrFfpOmsAllcNtfyDetailsTable INSTANCE =
		new DlrFfpOmsAllcNtfyDetailsTable();

	public final Column<DlrFfpOmsAllcNtfyDetailsTable, String> allocNtfyId =
		createColumn(
			"allocNtfyId", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<DlrFfpOmsAllcNtfyDetailsTable, String> prgrmType =
		createColumn(
			"prgrmType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DlrFfpOmsAllcNtfyDetailsTable, String> salesOrgName =
		createColumn(
			"salesOrgName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DlrFfpOmsAllcNtfyDetailsTable, String> dstrbtnChnnl =
		createColumn(
			"dstrbtnChnnl", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DlrFfpOmsAllcNtfyDetailsTable, Long> year =
		createColumn("year", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DlrFfpOmsAllcNtfyDetailsTable, String> salesOffice =
		createColumn(
			"salesOffice", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DlrFfpOmsAllcNtfyDetailsTable, String> memoNo =
		createColumn(
			"memoNo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DlrFfpOmsAllcNtfyDetailsTable, Date> startDate =
		createColumn(
			"startDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DlrFfpOmsAllcNtfyDetailsTable, Date> endDate =
		createColumn(
			"endDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DlrFfpOmsAllcNtfyDetailsTable, String> duration =
		createColumn(
			"duration", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DlrFfpOmsAllcNtfyDetailsTable, Long> commodityId =
		createColumn(
			"commodityId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DlrFfpOmsAllcNtfyDetailsTable, String> commodityName =
		createColumn(
			"commodityName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DlrFfpOmsAllcNtfyDetailsTable, Long> econmcPrice =
		createColumn(
			"econmcPrice", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DlrFfpOmsAllcNtfyDetailsTable, Long>
		salePrceToEndCstmr = createColumn(
			"salePrceToEndCstmr", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DlrFfpOmsAllcNtfyDetailsTable, String> unitPrice =
		createColumn(
			"unitPrice", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DlrFfpOmsAllcNtfyDetailsTable, Float> maxAlltmntPDay =
		createColumn(
			"maxAlltmntPDay", Float.class, Types.FLOAT, Column.FLAG_DEFAULT);
	public final Column<DlrFfpOmsAllcNtfyDetailsTable, Float> maxSellQtyPCstmr =
		createColumn(
			"maxSellQtyPCstmr", Float.class, Types.FLOAT, Column.FLAG_DEFAULT);
	public final Column<DlrFfpOmsAllcNtfyDetailsTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private DlrFfpOmsAllcNtfyDetailsTable() {
		super("dgf_ffp_oms_allc_ntfy_dtls", DlrFfpOmsAllcNtfyDetailsTable::new);
	}

}