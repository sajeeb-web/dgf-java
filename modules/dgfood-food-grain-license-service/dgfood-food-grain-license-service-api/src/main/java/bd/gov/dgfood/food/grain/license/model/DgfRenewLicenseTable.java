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
 * The table class for the &quot;dgf_renew_license&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DgfRenewLicense
 * @generated
 */
public class DgfRenewLicenseTable extends BaseTable<DgfRenewLicenseTable> {

	public static final DgfRenewLicenseTable INSTANCE =
		new DgfRenewLicenseTable();

	public final Column<DgfRenewLicenseTable, Long> renewLicenseId =
		createColumn(
			"renewLicenseId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DgfRenewLicenseTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfRenewLicenseTable, String> nationalId = createColumn(
		"nationalId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfRenewLicenseTable, String> licenseNo = createColumn(
		"licenseNo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfRenewLicenseTable, Date> licenseExpiryDate =
		createColumn(
			"licenseExpiryDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<DgfRenewLicenseTable, String> tradeLicenseNo =
		createColumn(
			"tradeLicenseNo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfRenewLicenseTable, Date> tradeLicenseExpiryDate =
		createColumn(
			"tradeLicenseExpiryDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<DgfRenewLicenseTable, Long> tradeLicAttchId =
		createColumn(
			"tradeLicAttchId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfRenewLicenseTable, Long> paymentAttchId =
		createColumn(
			"paymentAttchId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfRenewLicenseTable, String> applicationNo =
		createColumn(
			"applicationNo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfRenewLicenseTable, String> licenseApplicationType =
		createColumn(
			"licenseApplicationType", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfRenewLicenseTable, String> comments = createColumn(
		"comments", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfRenewLicenseTable, Date> createdDate = createColumn(
		"createdDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfRenewLicenseTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfRenewLicenseTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfRenewLicenseTable, Long> fglPrePrimaryId =
		createColumn(
			"fglPrePrimaryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfRenewLicenseTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<DgfRenewLicenseTable, Long> statusByUserId =
		createColumn(
			"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfRenewLicenseTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfRenewLicenseTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private DgfRenewLicenseTable() {
		super("dgf_renew_license", DgfRenewLicenseTable::new);
	}

}