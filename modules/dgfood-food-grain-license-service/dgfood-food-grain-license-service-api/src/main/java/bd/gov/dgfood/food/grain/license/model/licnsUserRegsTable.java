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
 * The table class for the &quot;dgf_licns_user_regs&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see licnsUserRegs
 * @generated
 */
public class licnsUserRegsTable extends BaseTable<licnsUserRegsTable> {

	public static final licnsUserRegsTable INSTANCE = new licnsUserRegsTable();

	public final Column<licnsUserRegsTable, Long> licUserId = createColumn(
		"licUserId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<licnsUserRegsTable, String> nationalId = createColumn(
		"nationalId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> applicantName =
		createColumn(
			"applicantName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> tradeLicenseNo =
		createColumn(
			"tradeLicenseNo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, Date> tradeLicenseExpiryDate =
		createColumn(
			"tradeLicenseExpiryDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> tradeLicenseIssuerCode =
		createColumn(
			"tradeLicenseIssuerCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> tradeLicenseIssuerCity =
		createColumn(
			"tradeLicenseIssuerCity", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> businessIdentificationNo =
		createColumn(
			"businessIdentificationNo", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> taxIdentificationNo =
		createColumn(
			"taxIdentificationNo", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> businessName = createColumn(
		"businessName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> businessType = createColumn(
		"businessType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, Long> businessDivision =
		createColumn(
			"businessDivision", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, Long> businessDistrict =
		createColumn(
			"businessDistrict", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, Long> businessUpzilla =
		createColumn(
			"businessUpzilla", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, Long> businessUnionName =
		createColumn(
			"businessUnionName", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> businessVillage =
		createColumn(
			"businessVillage", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> businessWard = createColumn(
		"businessWard", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> businessZipCode =
		createColumn(
			"businessZipCode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> businessPostOffice =
		createColumn(
			"businessPostOffice", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> businessHouseAddress =
		createColumn(
			"businessHouseAddress", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> photographFile =
		createColumn(
			"photographFile", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> tradeLicDoc = createColumn(
		"tradeLicDoc", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> binDoc = createColumn(
		"binDoc", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> tinDoc = createColumn(
		"tinDoc", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> bankStat = createColumn(
		"bankStat", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> otherReleventDoc =
		createColumn(
			"otherReleventDoc", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> comments = createColumn(
		"comments", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> foodGrainLicenseType =
		createColumn(
			"foodGrainLicenseType", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, Long> division = createColumn(
		"division", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, Long> district = createColumn(
		"district", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, Long> upzilla = createColumn(
		"upzilla", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, Long> unionName = createColumn(
		"unionName", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> village = createColumn(
		"village", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> ward = createColumn(
		"ward", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> zipCode = createColumn(
		"zipCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> postOffice = createColumn(
		"postOffice", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> houseAddress = createColumn(
		"houseAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> password = createColumn(
		"password_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> fatherName = createColumn(
		"fatherName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> lastName = createColumn(
		"lastName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> motherName = createColumn(
		"motherName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> gender = createColumn(
		"gender", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> maritalStatus =
		createColumn(
			"maritalStatus", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, Date> birthDate = createColumn(
		"birthDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> mobileNo = createColumn(
		"mobileNo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> nidDivision = createColumn(
		"nidDivision", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> nidDistrict = createColumn(
		"nidDistrict", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> nidUpzilla = createColumn(
		"nidUpzilla", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> nidUnion = createColumn(
		"nidUnion", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> nidVillage = createColumn(
		"nidVillage", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> nidWard = createColumn(
		"nidWard", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> nidZipCode = createColumn(
		"nidZipCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> nidPostOffice =
		createColumn(
			"nidPostOffice", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> nidHouseAddress =
		createColumn(
			"nidHouseAddress", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, Boolean> isSubmit = createColumn(
		"isSubmit", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> electricExemptionMemo =
		createColumn(
			"electricExemptionMemo", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> envClrMemo = createColumn(
		"envClrMemo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> bstiClrMemo = createColumn(
		"bstiClrMemo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> fireLicNumDoc =
		createColumn(
			"fireLicNumDoc", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<licnsUserRegsTable, String> productType = createColumn(
		"productType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private licnsUserRegsTable() {
		super("dgf_licns_user_regs", licnsUserRegsTable::new);
	}

}