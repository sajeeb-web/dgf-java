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

import java.util.Date;

/**
 * The table class for the &quot;dgf_dlr_updt_temp_dtls&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrUpdtTempDtls
 * @generated
 */
public class DgfDlrUpdtTempDtlsTable
	extends BaseTable<DgfDlrUpdtTempDtlsTable> {

	public static final DgfDlrUpdtTempDtlsTable INSTANCE =
		new DgfDlrUpdtTempDtlsTable();

	public final Column<DgfDlrUpdtTempDtlsTable, Long> dgfDlrUpdateReqId =
		createColumn(
			"dgf_dlr_update_req_id", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<DgfDlrUpdtTempDtlsTable, String> nationalId =
		createColumn(
			"national_id", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Long> dlrRegNo = createColumn(
		"dlr_reg_no", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, String> maritalStatus =
		createColumn(
			"marital_status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, String> spouseName =
		createColumn(
			"spouse_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, String> spouseFthrName =
		createColumn(
			"spouse_fthr_name", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, String> spouseNid =
		createColumn(
			"spouse_nid", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Date> spouseBrthDate =
		createColumn(
			"spouse_brth_date", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Integer> pblcRep =
		createColumn(
			"pblc_rep", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Integer> wrkInGovt =
		createColumn(
			"wrk_in_govt", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Integer> physclyChlngd =
		createColumn(
			"physcly_chlngd", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Long> phsclyChlngdAttchId =
		createColumn(
			"phscly_chlngd_attch_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Long> shpDivision =
		createColumn(
			"shp_division", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Long> shpDistrict =
		createColumn(
			"shp_district", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Long> shpUpzilla =
		createColumn(
			"shp_upzilla", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Long> shpUnion = createColumn(
		"shp_union", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, String> shpVillage =
		createColumn(
			"shp_village", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, String> shpWard = createColumn(
		"shp_ward", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, String> shpZipCode =
		createColumn(
			"shp_zip_code", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, String> shpPstOffc =
		createColumn(
			"shp_pst_offc", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, String> shpPresentAddress =
		createColumn(
			"shp_present_address", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, String> shpLocation =
		createColumn(
			"shp_location", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Long> shpLength = createColumn(
		"shp_length", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Long> shpHeight = createColumn(
		"shp_height", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Long> shpWidth = createColumn(
		"shp_width", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Long> shpStrgCpcty =
		createColumn(
			"shp_strg_cpcty", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Integer> shpFlrCmntd =
		createColumn(
			"shp_flr_cmntd", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Integer> shpSignBrd =
		createColumn(
			"shp_sign_brd", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, String> licenseType =
		createColumn(
			"license_type", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Long> thrdPartyOpsFlg =
		createColumn(
			"thrd_party_ops_flg", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, String> dlrshpFmlyMmbrName =
		createColumn(
			"dlrshp_fmly_mmbr_name", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, String> dlrshpFmlyMmbrType =
		createColumn(
			"dlrshp_fmly_mmbr_type", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Long> dlrPerfYr1 =
		createColumn(
			"dlr_perf_yr1", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Long> dlrPerfYr1AllocQty =
		createColumn(
			"dlr_perf_yr1_alloc_qty", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Long> dlrPerfYr1ComdtyQty =
		createColumn(
			"dlr_perf_yr1_comdty_qty", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, String> dlrPerfYr1DlrCtgry =
		createColumn(
			"dlr_perf_yr1_dlr_ctgry", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, String> dlrPerfYr1Rmrk =
		createColumn(
			"dlr_perf_yr1_rmrk", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Long> dlrPerfYr2 =
		createColumn(
			"dlr_perf_yr2", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Long> dlrPerfYr2AllocQty =
		createColumn(
			"dlr_perf_yr2_alloc_qty", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Long> dlrPerfYr2ComdtyQty =
		createColumn(
			"dlr_perf_yr2_comdty_qty", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, String> dlrPerfYr2DlrCtgry =
		createColumn(
			"dlr_perf_yr2_dlr_ctgry", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, String> dlrPerfYr2Rmrk =
		createColumn(
			"dlr_perf_yr2_rmrk", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Long> dlrPerfYr3 =
		createColumn(
			"dlr_perf_yr3", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Long> dlrPerfYr3AllocQty =
		createColumn(
			"dlr_perf_yr3_alloc_qty", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Long> dlrPerfYr3ComdtyQty =
		createColumn(
			"dlr_perf_yr3_comdty_qty", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, String> dlrPerfYr3DlrCtgry =
		createColumn(
			"dlr_perf_yr3_dlr_ctgry", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, String> dlrPerfYr3Rmrk =
		createColumn(
			"dlr_perf_yr3_rmrk", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, String> trckLicnsPlatNo =
		createColumn(
			"trck_licns_plat_no", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Long> trckCpcty = createColumn(
		"trck_cpcty", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, String> trckMake =
		createColumn(
			"trck_make", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, String> trckModel =
		createColumn(
			"trck_model", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, String> trckRentOwnFlg =
		createColumn(
			"trck_rent_own_flg", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Long> trckMfgYr = createColumn(
		"trck_mfg_yr", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Long> version = createColumn(
		"version", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Long> statusByUserId =
		createColumn(
			"status_by_user_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, String> statusByUserName =
		createColumn(
			"status_by_user_name", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Date> statusDate =
		createColumn(
			"status_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Date> createDate =
		createColumn(
			"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Long> lastUpdtdBy =
		createColumn(
			"last_updtd_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Date> modifiedDate =
		createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Integer> foodgrainLicense =
		createColumn(
			"foodgrain_license", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Integer> tradeLicense =
		createColumn(
			"trade_license", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Integer> tcvDlrLicense =
		createColumn(
			"tcv_dlr_license", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Integer> importLicense =
		createColumn(
			"import_license", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Integer>
		licenseEssentialGoods = createColumn(
			"license_essential_goods", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Integer>
		tradeLicenseAgriculture = createColumn(
			"trade_license_agriculture", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, String> dlrOmsSubType =
		createColumn(
			"dlr_oms_sub_type", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Long> userId = createColumn(
		"user_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Long> groupId = createColumn(
		"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Long> companyId = createColumn(
		"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Integer> dlrRunShpHimself =
		createColumn(
			"dlr_run_shp_himself", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrUpdtTempDtlsTable, Integer> dlrShpTrckTypFlg =
		createColumn(
			"dlr_shp_trck_typ_flg", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);

	private DgfDlrUpdtTempDtlsTable() {
		super("dgf_dlr_updt_temp_dtls", DgfDlrUpdtTempDtlsTable::new);
	}

}