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

package bd.gov.dgfood.dealer.registration.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;dgf_dlr_perf_dtls&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrPerfDtls
 * @generated
 */
public class DgfDlrPerfDtlsTable extends BaseTable<DgfDlrPerfDtlsTable> {

	public static final DgfDlrPerfDtlsTable INSTANCE =
		new DgfDlrPerfDtlsTable();

	public final Column<DgfDlrPerfDtlsTable, Long> dgfDlrPerfId = createColumn(
		"dgf_dlr_perf_id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DgfDlrPerfDtlsTable, String> nationalId = createColumn(
		"national_id", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrPerfDtlsTable, Long> dlrRegApplNo = createColumn(
		"dlr_reg_appl_no", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrPerfDtlsTable, Long> dlrRegNo = createColumn(
		"dlr_reg_no", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrPerfDtlsTable, Long> dlrPerfYr1 = createColumn(
		"dlr_perf_yr1", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrPerfDtlsTable, Long> dlrPerfYr1AllocQty =
		createColumn(
			"dlr_perf_yr1_alloc_qty", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrPerfDtlsTable, Long> dlrPerfYr1ComdtyQty =
		createColumn(
			"dlr_perf_yr1_comdty_qty", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrPerfDtlsTable, String> dlrPerfYr1DlrCtgry =
		createColumn(
			"dlr_perf_yr1_dlr_ctgry", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrPerfDtlsTable, String> dlrPerfYr1Rmrk =
		createColumn(
			"dlr_perf_yr1_rmrk", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrPerfDtlsTable, Long> dlrPerfYr2 = createColumn(
		"dlr_perf_yr2", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrPerfDtlsTable, Long> dlrPerfYr2AllocQty =
		createColumn(
			"dlr_perf_yr2_alloc_qty", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrPerfDtlsTable, Long> dlrPerfYr2ComdtyQty =
		createColumn(
			"dlr_perf_yr2_comdty_qty", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrPerfDtlsTable, String> dlrPerfYr2DlrCtgry =
		createColumn(
			"dlr_perf_yr2_dlr_ctgry", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrPerfDtlsTable, String> dlrPerfYr2Rmrk =
		createColumn(
			"dlr_perf_yr2_rmrk", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrPerfDtlsTable, Long> dlrPerfYr3 = createColumn(
		"dlr_perf_yr3", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrPerfDtlsTable, Long> dlrPerfYr3AllocQty =
		createColumn(
			"dlr_perf_yr3_alloc_qty", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrPerfDtlsTable, Long> dlrPerfYr3ComdtyQty =
		createColumn(
			"dlr_perf_yr3_comdty_qty", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrPerfDtlsTable, String> dlrPerfYr3DlrCtgry =
		createColumn(
			"dlr_perf_yr3_dlr_ctgry", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrPerfDtlsTable, String> dlrPerfYr3Rmrk =
		createColumn(
			"dlr_perf_yr3_rmrk", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrPerfDtlsTable, Long> version = createColumn(
		"version", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private DgfDlrPerfDtlsTable() {
		super("dgf_dlr_perf_dtls", DgfDlrPerfDtlsTable::new);
	}

}