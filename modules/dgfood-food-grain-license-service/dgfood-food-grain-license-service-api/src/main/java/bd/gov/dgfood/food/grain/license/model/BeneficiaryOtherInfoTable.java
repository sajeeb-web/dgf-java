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
 * The table class for the &quot;dgf_beneficiary_other_info&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see BeneficiaryOtherInfo
 * @generated
 */
public class BeneficiaryOtherInfoTable
	extends BaseTable<BeneficiaryOtherInfoTable> {

	public static final BeneficiaryOtherInfoTable INSTANCE =
		new BeneficiaryOtherInfoTable();

	public final Column<BeneficiaryOtherInfoTable, Long> id = createColumn(
		"id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<BeneficiaryOtherInfoTable, Long> verifiedId =
		createColumn(
			"verified_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BeneficiaryOtherInfoTable, String> maritalStatus =
		createColumn(
			"marital_status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BeneficiaryOtherInfoTable, String> spouseName =
		createColumn(
			"spouse_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BeneficiaryOtherInfoTable, String> spouseNid =
		createColumn(
			"spouse_nid", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BeneficiaryOtherInfoTable, String> spouseSecondNid =
		createColumn(
			"spouse_second_nid", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<BeneficiaryOtherInfoTable, Date> spouseDob =
		createColumn(
			"spouse_dob", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BeneficiaryOtherInfoTable, String> fatherNid =
		createColumn(
			"father_nid", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BeneficiaryOtherInfoTable, String> motherNid =
		createColumn(
			"mother_nid", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BeneficiaryOtherInfoTable, String> mobileNo =
		createColumn(
			"mobile_no", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BeneficiaryOtherInfoTable, String> mobileNoRelation =
		createColumn(
			"mobile_no_relation", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<BeneficiaryOtherInfoTable, String> ecSpouseInfo =
		createColumn(
			"ec_spouse_info", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BeneficiaryOtherInfoTable, String> occupation =
		createColumn(
			"occupation", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BeneficiaryOtherInfoTable, String> villageName =
		createColumn(
			"village_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BeneficiaryOtherInfoTable, String> wordNo =
		createColumn(
			"word_no", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BeneficiaryOtherInfoTable, String> dealerName =
		createColumn(
			"dealer_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BeneficiaryOtherInfoTable, String> dealerMobile =
		createColumn(
			"dealer_mobile", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BeneficiaryOtherInfoTable, Date> mobileVerifiedAt =
		createColumn(
			"mobile_verified_at", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<BeneficiaryOtherInfoTable, Long> familyEarningMember =
		createColumn(
			"family_earning_member", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<BeneficiaryOtherInfoTable, Long> avgFamilyIncome =
		createColumn(
			"avg_family_income", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BeneficiaryOtherInfoTable, Long> dependentFamilyMember =
		createColumn(
			"dependent_family_member", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<BeneficiaryOtherInfoTable, Long> landSize =
		createColumn(
			"land_size", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BeneficiaryOtherInfoTable, String> landUnit =
		createColumn(
			"land_unit", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BeneficiaryOtherInfoTable, String> remarks =
		createColumn(
			"remarks", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BeneficiaryOtherInfoTable, Long> userId = createColumn(
		"user_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BeneficiaryOtherInfoTable, Date> createdAt =
		createColumn(
			"created_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BeneficiaryOtherInfoTable, Date> updatedAt =
		createColumn(
			"updated_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BeneficiaryOtherInfoTable, String> dealerSlug =
		createColumn(
			"dealer_slug", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BeneficiaryOtherInfoTable, Long> dealerId =
		createColumn(
			"dealer_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private BeneficiaryOtherInfoTable() {
		super("dgf_beneficiary_other_info", BeneficiaryOtherInfoTable::new);
	}

}