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
 * The table class for the &quot;dgf_dlr_reg_dtls&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrRegDtls
 * @generated
 */
public class DgfDlrRegDtlsTable extends BaseTable<DgfDlrRegDtlsTable> {

	public static final DgfDlrRegDtlsTable INSTANCE = new DgfDlrRegDtlsTable();

	public final Column<DgfDlrRegDtlsTable, Long> dlrRegNo = createColumn(
		"dlr_reg_no", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DgfDlrRegDtlsTable, String> nationalId = createColumn(
		"national_id", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, Long> userId = createColumn(
		"user_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, Long> groupId = createColumn(
		"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, Long> companyId = createColumn(
		"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, Long> dlrRegApplNo = createColumn(
		"dlr_reg_appl_no", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, String> fglLicnsNo = createColumn(
		"fgl_licns_no", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, Date> fglLicnsIssueDate =
		createColumn(
			"fgl_licns_issue_date", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, Long> trdLicnsNo = createColumn(
		"trd_licns_no", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, Date> trdLicnsExpDate =
		createColumn(
			"trd_licns_exp_date", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, String> dlrTypeId = createColumn(
		"dlr_type_id", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, String> maritalStatus =
		createColumn(
			"marital_status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, String> spouseName = createColumn(
		"spouse_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, String> spouseFthrName =
		createColumn(
			"spouse_fthr_name", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, String> spouseNid = createColumn(
		"spouse_nid", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, Date> spouseBrthDate = createColumn(
		"spouse_brth_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, Date> dlrRegExpiryDate =
		createColumn(
			"dlr_reg_expiry_date", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, String> sapBuCode = createColumn(
		"sap_bu_code", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, String> dlrRegApplStatus =
		createColumn(
			"dlr_reg_appl_status", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, Date> dlrRegCrtdDate = createColumn(
		"dlr_reg_crtd_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, Long> pymntTrnRefNo = createColumn(
		"pymnt_trn_ref_no", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, String> pymntTrnStatus =
		createColumn(
			"pymnt_trn_status", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, Long> challanDocId = createColumn(
		"challan_doc_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, Long> incmTaxAttchID = createColumn(
		"incm_tax_attch_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, Long> bnkSolvncyCertId =
		createColumn(
			"bnk_solvncy_cert_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, Long> shpOwnshipDocuId =
		createColumn(
			"shp_ownship_docu_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, Long> shpRentedDocuId =
		createColumn(
			"shp_rented_docu_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, Long> signatureId = createColumn(
		"signature_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, String> dlrApprRjctComments =
		createColumn(
			"dlr_appr_rjct_comments", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, String> dlrRegApprRejRmrk =
		createColumn(
			"dlr_reg_appr_rej_rmrk", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, Long> statusByUserId = createColumn(
		"status_by_user_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, String> statusByUserName =
		createColumn(
			"status_by_user_name", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, Date> statusDate = createColumn(
		"status_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, Long> version = createColumn(
		"version", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, String> dlrRegCrtdBy = createColumn(
		"dlr_reg_crtd_by", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, Date> createDate = createColumn(
		"create_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, Long> lastUpdtdBy = createColumn(
		"last_updtd_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, Date> modifedDate = createColumn(
		"modifed_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, String> dlrOmsSubType =
		createColumn(
			"dlr_oms_sub_type", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, Long> division = createColumn(
		"division", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, Long> district = createColumn(
		"district", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, Long> upzilla = createColumn(
		"upzilla", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, Long> unionName = createColumn(
		"union_name", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrRegDtlsTable, Date> dlrBrthDate = createColumn(
		"dlr_brth_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private DgfDlrRegDtlsTable() {
		super("dgf_dlr_reg_dtls", DgfDlrRegDtlsTable::new);
	}

}