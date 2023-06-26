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
 * The table class for the &quot;dgf_verified_beneficiaries&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see VerifiedBeneficiaries
 * @generated
 */
public class VerifiedBeneficiariesTable
	extends BaseTable<VerifiedBeneficiariesTable> {

	public static final VerifiedBeneficiariesTable INSTANCE =
		new VerifiedBeneficiariesTable();

	public final Column<VerifiedBeneficiariesTable, Long> id = createColumn(
		"id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<VerifiedBeneficiariesTable, Integer> bsbVerified =
		createColumn(
			"bsb_verified", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, Long> cardNo = createColumn(
		"card_no", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, Date> createdAt =
		createColumn(
			"created_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> dateOfBirth =
		createColumn(
			"date_of_birth", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, Long> dealerId =
		createColumn(
			"dealer_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, Long> districtId =
		createColumn(
			"district_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, Long> divisionId =
		createColumn(
			"division_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> ecBeneficiaryName =
		createColumn(
			"ec_beneficiary_name", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String>
		ecBeneficiaryNameEn = createColumn(
			"ec_beneficiary_name_en", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> ecBloodGroup =
		createColumn(
			"ec_blood_group", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> ecFatherName =
		createColumn(
			"ec_father_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> ecGender =
		createColumn(
			"ec_gender", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> ecMobileNo =
		createColumn(
			"ec_mobile_no", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> ecMotherName =
		createColumn(
			"ec_mother_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> ecOccupation =
		createColumn(
			"ec_occupation", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String>
		ecPmAdditionalMouzaMoholla = createColumn(
			"ec_pm_additional_mouza_moholla", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String>
		ecPmAdditionalVillageRoad = createColumn(
			"ec_pm_additional_village_road", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> ecPmDistrict =
		createColumn(
			"ec_pm_district", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> ecPmDivision =
		createColumn(
			"ec_pm_division", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> ecPmHomeHoldingNo =
		createColumn(
			"ec_pm_home_holding_no", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> ecPmMouzaMoholla =
		createColumn(
			"ec_pm_mouza_moholla", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> ecPmPostalCode =
		createColumn(
			"ec_pm_postal_code", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> ecPmPostOffice =
		createColumn(
			"ec_pm_post_office", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> ecPmRegion =
		createColumn(
			"ec_pm_region", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> ecPmRmo =
		createColumn(
			"ec_pm_rmo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> ecPmUnionWard =
		createColumn(
			"ec_pm_union_ward", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> ecPmUpazila =
		createColumn(
			"ec_pm_upazila", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> ecPmVillageRoad =
		createColumn(
			"ec_pm_village_road", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String>
		ecPmWardUnionPorishod = createColumn(
			"ec_pm_ward_union_porishod", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String>
		ecPrAdditionalMouzaMoholla = createColumn(
			"ec_pr_additional_mouza_moholla", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String>
		ecPrAdditionalVillageRoad = createColumn(
			"ec_pr_additional_village_road", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String>
		ecPrCityCorpMunicipality = createColumn(
			"ec_pr_city_corp_municipality", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> ecPrDistrict =
		createColumn(
			"ec_pr_district", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> ecPrDivision =
		createColumn(
			"ec_pr_division", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> ecPrHomeHoldingNo =
		createColumn(
			"ec_pr_home_holding_no", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> ecPrMouzaMoholla =
		createColumn(
			"ec_pr_mouza_moholla", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> ecPrPostalCode =
		createColumn(
			"ec_pr_postal_code", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> ecPrPostOffice =
		createColumn(
			"ec_pr_post_office", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> ecPrRegion =
		createColumn(
			"ec_pr_region", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> ecPrRmo =
		createColumn(
			"ec_pr_rmo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> ecPrUnionWard =
		createColumn(
			"ec_pr_union_ward", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> ecPrUpazila =
		createColumn(
			"ec_pr_upazila", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> ecPrVillageRoad =
		createColumn(
			"ec_pr_village_road", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String>
		ecPrWardUnionPorishod = createColumn(
			"ec_pr_ward_union_porishod", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> ecSpouseName =
		createColumn(
			"ec_spouse_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, Integer> ecVerified =
		createColumn(
			"ec_verified", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, Long> finalStatus =
		createColumn(
			"final_status", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> givenMobileNo =
		createColumn(
			"given_mobile_no", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> imagePathEc =
		createColumn(
			"image_path_ec", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> imagePathReal =
		createColumn(
			"image_path_real", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> nationalId =
		createColumn(
			"national_id", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, Long> newCardNumber =
		createColumn(
			"new_card_number", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, Long> rawDataId =
		createColumn(
			"raw_data_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> remarks =
		createColumn(
			"remarks", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, String> secondNationalId =
		createColumn(
			"second_national_id", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, Long> status = createColumn(
		"status", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, Date> ucfVerifiedDate =
		createColumn(
			"ucf_verified_date", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, Long> unionId =
		createColumn("union_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, Long> upazilaId =
		createColumn(
			"upazila_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, Date> updatedAt =
		createColumn(
			"updated_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, Long> verifiedBy =
		createColumn(
			"verified_by", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, Date> verifiedDate =
		createColumn(
			"verified_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<VerifiedBeneficiariesTable, Integer> vgdStatus =
		createColumn(
			"vgd_status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private VerifiedBeneficiariesTable() {
		super("dgf_verified_beneficiaries", VerifiedBeneficiariesTable::new);
	}

}