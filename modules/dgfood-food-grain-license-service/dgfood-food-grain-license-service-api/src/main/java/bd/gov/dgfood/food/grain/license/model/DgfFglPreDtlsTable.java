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
 * The table class for the &quot;dgf_fgl_pre_dtls&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DgfFglPreDtls
 * @generated
 */
public class DgfFglPreDtlsTable extends BaseTable<DgfFglPreDtlsTable> {

	public static final DgfFglPreDtlsTable INSTANCE = new DgfFglPreDtlsTable();

	public final Column<DgfFglPreDtlsTable, Long> fglPrePrimaryId =
		createColumn(
			"fglPrePrimaryId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DgfFglPreDtlsTable, Long> nationalId = createColumn(
		"nationalId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, String> fglApplicationNo =
		createColumn(
			"fglApplicationNo", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, String> applicantName =
		createColumn(
			"applicantName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, String> tradeLicenseNo =
		createColumn(
			"tradeLicenseNo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, Date> tradeLicenseExpiryDate =
		createColumn(
			"tradeLicenseExpiryDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, String> tradeLicenseIssuerCode =
		createColumn(
			"tradeLicenseIssuerCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, String> tradeLicenseIssuerCity =
		createColumn(
			"tradeLicenseIssuerCity", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, String> businessIdentificationNo =
		createColumn(
			"businessIdentificationNo", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, String> taxIdentificationNo =
		createColumn(
			"taxIdentificationNo", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, String> businessName = createColumn(
		"businessName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, String> businessType = createColumn(
		"businessType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, Long> paymentChallanId =
		createColumn(
			"paymentChallanId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, Long> paymentStatus = createColumn(
		"paymentStatus", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, String> reviewComments =
		createColumn(
			"reviewComments", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, Long> applicationStatus =
		createColumn(
			"applicationStatus", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, Date> applicationStatusDate =
		createColumn(
			"applicationStatusDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, Long> duplicateLicenseReasonId =
		createColumn(
			"duplicateLicenseReasonId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, String> comments = createColumn(
		"comments", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, Long> fglLicenseVersion =
		createColumn(
			"fglLicenseVersion", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, String> foodGrainLicenseType =
		createColumn(
			"foodGrainLicenseType", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, Date> createdDate = createColumn(
		"createdDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, Long> applicationStatusById =
		createColumn(
			"applicationStatusById", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, Long> presentAddrId = createColumn(
		"presentAddrId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, Long> bussinessAddrId =
		createColumn(
			"bussinessAddrId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, Long> tradeLicenseDocId =
		createColumn(
			"tradeLicenseDocId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, Long> bussIdentfctDocId =
		createColumn(
			"bussIdentfctDocId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, Long> taxIdentfctDocId =
		createColumn(
			"taxIdentfctDocId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, Long> bnkStatmtDocId = createColumn(
		"bnkStatmtDocId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, Date> birthDate = createColumn(
		"birthDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, String> fglApplicationType =
		createColumn(
			"fglApplicationType", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, Long> photographDocId =
		createColumn(
			"photographDocId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, Long> otherReleventDocId =
		createColumn(
			"otherReleventDocId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, Long> electricExemptionMemoId =
		createColumn(
			"electricExemptionMemoId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, Long> envClrMemoId = createColumn(
		"envClrMemoId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, Long> bstiClrMemoId = createColumn(
		"bstiClrMemoId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, Long> fireLicNumDocId =
		createColumn(
			"fireLicNumDocId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfFglPreDtlsTable, String> productType = createColumn(
		"productType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private DgfFglPreDtlsTable() {
		super("dgf_fgl_pre_dtls", DgfFglPreDtlsTable::new);
	}

}