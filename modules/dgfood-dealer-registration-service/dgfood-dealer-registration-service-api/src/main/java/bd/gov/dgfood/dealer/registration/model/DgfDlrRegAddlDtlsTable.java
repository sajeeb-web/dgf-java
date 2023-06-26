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
 * The table class for the &quot;dgf_dlr_reg_addl_dtls&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrRegAddlDtls
 * @generated
 */
public class DgfDlrRegAddlDtlsTable extends BaseTable<DgfDlrRegAddlDtlsTable> {

	public static final DgfDlrRegAddlDtlsTable INSTANCE =
		new DgfDlrRegAddlDtlsTable();

	public final Column<DgfDlrRegAddlDtlsTable, Long> dlrRegAddlDtlsId =
		createColumn(
			"dlr_reg_addl_dtls_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<DgfDlrRegAddlDtlsTable, String> nationalId =
		createColumn(
			"national_id", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegAddlDtlsTable, Long> dlrRegAppLNo =
		createColumn(
			"dlr_reg_appl_no", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegAddlDtlsTable, Long> dlrRegNo = createColumn(
		"dlr_reg_no", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegAddlDtlsTable, Integer> pblcRep = createColumn(
		"pblc_rep", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegAddlDtlsTable, Integer> wrkInGovt =
		createColumn(
			"wrk_in_govt", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegAddlDtlsTable, Integer> physclyChlngd =
		createColumn(
			"physcly_chlngd", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegAddlDtlsTable, Long> phsclyChlnGdAttchId =
		createColumn(
			"phscly_chln_gd_attch_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegAddlDtlsTable, String> licenseType =
		createColumn(
			"license_type", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegAddlDtlsTable, Long> thirdPartyOpsFlg =
		createColumn(
			"third_party_ops_flg", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegAddlDtlsTable, Long> fmlyDlrShpNo =
		createColumn(
			"fmly_dlr_shp_no", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegAddlDtlsTable, String> dlrshpFmlyMmbrName =
		createColumn(
			"dlrshp_fmly_mmbr_name", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegAddlDtlsTable, String> dlrshpFmlyMmbrType =
		createColumn(
			"dlrshp_fmly_mmbr_type", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegAddlDtlsTable, Integer> dlrShpTrckTypFlg =
		createColumn(
			"dlr_shp_trck_typ_flg", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegAddlDtlsTable, String> trckLicnsPlatNo =
		createColumn(
			"trck_licns_plat_no", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegAddlDtlsTable, Long> trckCpcty = createColumn(
		"trck_cpcty", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegAddlDtlsTable, String> trckMake = createColumn(
		"trck_make", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegAddlDtlsTable, String> trckModel =
		createColumn(
			"trck_model", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegAddlDtlsTable, String> trckRentOwnFlg =
		createColumn(
			"trck_rent_own_flg", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegAddlDtlsTable, Long> trckMfgYr = createColumn(
		"trck_mfg_yr", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegAddlDtlsTable, Long> shpLength = createColumn(
		"shp_length", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegAddlDtlsTable, Long> shpHeight = createColumn(
		"shp_height", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegAddlDtlsTable, Long> shpWidth = createColumn(
		"shp_width", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegAddlDtlsTable, Long> shpStrgCpcty =
		createColumn(
			"shp_strg_cpcty", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegAddlDtlsTable, Integer> shpFlrCmntd =
		createColumn(
			"shp_flr_cmntd", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegAddlDtlsTable, Integer> shpSignBrd =
		createColumn(
			"shp_sign_brd", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegAddlDtlsTable, Integer> dlrLicnsPosses =
		createColumn(
			"dlr_licns_posses", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegAddlDtlsTable, Integer> dlrRunShpHimself =
		createColumn(
			"dlr_run_shp_himself", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegAddlDtlsTable, Long> dlrFmlyDlrShpFlg =
		createColumn(
			"dlr_fmly_dlr_shp_flg", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegAddlDtlsTable, Long> version = createColumn(
		"version", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private DgfDlrRegAddlDtlsTable() {
		super("dgf_dlr_reg_addl_dtls", DgfDlrRegAddlDtlsTable::new);
	}

}