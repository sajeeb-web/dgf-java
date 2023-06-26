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
 * The table class for the &quot;dgf_user_otp_dtls&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersOtpDetails
 * @generated
 */
public class DgfUsersOtpDetailsTable
	extends BaseTable<DgfUsersOtpDetailsTable> {

	public static final DgfUsersOtpDetailsTable INSTANCE =
		new DgfUsersOtpDetailsTable();

	public final Column<DgfUsersOtpDetailsTable, Long> otpId = createColumn(
		"otpId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DgfUsersOtpDetailsTable, String> nationalId =
		createColumn(
			"nationalId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersOtpDetailsTable, Long> otp = createColumn(
		"otp", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfUsersOtpDetailsTable, Date> otpRequestTime =
		createColumn(
			"otpRequestTime", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfUsersOtpDetailsTable, Date> otpLoginTime =
		createColumn(
			"otpLoginTime", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfUsersOtpDetailsTable, Date> otpExpireTime =
		createColumn(
			"otpExpireTime", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfUsersOtpDetailsTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfUsersOtpDetailsTable, Long> userRegNo = createColumn(
		"userRegNo", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfUsersOtpDetailsTable, String> mobileNo =
		createColumn(
			"mobileNo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersOtpDetailsTable, String> emailId = createColumn(
		"emailId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersOtpDetailsTable, String> otpVerify =
		createColumn(
			"otpVerify", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersOtpDetailsTable, Boolean> isSent = createColumn(
		"isSent", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<DgfUsersOtpDetailsTable, String> message = createColumn(
		"message", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersOtpDetailsTable, String> requestUrl =
		createColumn(
			"requestUrl", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersOtpDetailsTable, String> responseData =
		createColumn(
			"responseData", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersOtpDetailsTable, Integer> responseStatusCode =
		createColumn(
			"responseStatusCode", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<DgfUsersOtpDetailsTable, String> responseResult =
		createColumn(
			"responseResult", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private DgfUsersOtpDetailsTable() {
		super("dgf_user_otp_dtls", DgfUsersOtpDetailsTable::new);
	}

}