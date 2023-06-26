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
 * The table class for the &quot;dgf_duplct_licns_reason&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDuplctLicnsReason
 * @generated
 */
public class DgfDuplctLicnsReasonTable
	extends BaseTable<DgfDuplctLicnsReasonTable> {

	public static final DgfDuplctLicnsReasonTable INSTANCE =
		new DgfDuplctLicnsReasonTable();

	public final Column<DgfDuplctLicnsReasonTable, Long>
		duplicateLicenseReasonID = createColumn(
			"duplicateLicenseReasonID", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<DgfDuplctLicnsReasonTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDuplctLicnsReasonTable, String> nationalId =
		createColumn(
			"nationalId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDuplctLicnsReasonTable, String> licenseNo =
		createColumn(
			"licenseNo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDuplctLicnsReasonTable, Date> licenseExpiryDate =
		createColumn(
			"licenseExpiryDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<DgfDuplctLicnsReasonTable, String> tradeLicenseNo =
		createColumn(
			"tradeLicenseNo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDuplctLicnsReasonTable, Date>
		tradeLicenseExpiryDate = createColumn(
			"tradeLicenseExpiryDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<DgfDuplctLicnsReasonTable, Long> tradeLicAttchId =
		createColumn(
			"tradeLicAttchId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDuplctLicnsReasonTable, Long> paymentAttchId =
		createColumn(
			"paymentAttchId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDuplctLicnsReasonTable, String> applicationNo =
		createColumn(
			"applicationNo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDuplctLicnsReasonTable, String>
		licenseApplicationType = createColumn(
			"licenseApplicationType", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDuplctLicnsReasonTable, String>
		duplicateLicenseReasonDisplay = createColumn(
			"duplicateLicenseReasonDisplay", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDuplctLicnsReasonTable, String> comments =
		createColumn(
			"comments", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfDuplctLicnsReasonTable, Date> createdDate =
		createColumn(
			"createdDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfDuplctLicnsReasonTable, Long> modifiedBy =
		createColumn(
			"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDuplctLicnsReasonTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfDuplctLicnsReasonTable, Long> fglPrePrimaryId =
		createColumn(
			"fglPrePrimaryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDuplctLicnsReasonTable, Integer> status =
		createColumn(
			"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<DgfDuplctLicnsReasonTable, Long> statusByUserId =
		createColumn(
			"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfDuplctLicnsReasonTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfDuplctLicnsReasonTable, Date> statusDate =
		createColumn(
			"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private DgfDuplctLicnsReasonTable() {
		super("dgf_duplct_licns_reason", DgfDuplctLicnsReasonTable::new);
	}

}