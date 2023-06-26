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
 * The table class for the &quot;dgf_dlr_withdrawal&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrWithdrawal
 * @generated
 */
public class DgfDlrWithdrawalTable extends BaseTable<DgfDlrWithdrawalTable> {

	public static final DgfDlrWithdrawalTable INSTANCE =
		new DgfDlrWithdrawalTable();

	public final Column<DgfDlrWithdrawalTable, Long> dlrWithdrawalId =
		createColumn(
			"dlr_withdrawal_id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DgfDlrWithdrawalTable, String> nationalId =
		createColumn(
			"national_id", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrWithdrawalTable, String> licenseNo = createColumn(
		"license_no", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrWithdrawalTable, String> dealerName =
		createColumn(
			"dealer_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrWithdrawalTable, String> mobileNo = createColumn(
		"mobile_no", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrWithdrawalTable, String> reason = createColumn(
		"reason", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrWithdrawalTable, String> programType =
		createColumn(
			"program_type", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrWithdrawalTable, String> omsSubType =
		createColumn(
			"oms_sub_type", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDlrWithdrawalTable, Date> createdDate = createColumn(
		"created_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfDlrWithdrawalTable, Long> modifiedBy = createColumn(
		"modified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrWithdrawalTable, Date> modifiedDate =
		createColumn(
			"modified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfDlrWithdrawalTable, Long> userId = createColumn(
		"user_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrWithdrawalTable, Long> groupId = createColumn(
		"group_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrWithdrawalTable, Long> companyId = createColumn(
		"company_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrWithdrawalTable, Long> dlrRegNo = createColumn(
		"dlr_reg_no", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrWithdrawalTable, Long> regApplNo = createColumn(
		"reg_appl_no", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrWithdrawalTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<DgfDlrWithdrawalTable, Long> statusByUserId =
		createColumn(
			"status_by_user_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDlrWithdrawalTable, String> statusByUserName =
		createColumn(
			"status_by_user_name", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDlrWithdrawalTable, Date> statusDate = createColumn(
		"status_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private DgfDlrWithdrawalTable() {
		super("dgf_dlr_withdrawal", DgfDlrWithdrawalTable::new);
	}

}