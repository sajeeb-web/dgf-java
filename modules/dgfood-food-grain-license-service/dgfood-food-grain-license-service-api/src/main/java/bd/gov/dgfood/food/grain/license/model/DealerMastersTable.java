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
 * The table class for the &quot;dgf_dealer_masters&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DealerMasters
 * @generated
 */
public class DealerMastersTable extends BaseTable<DealerMastersTable> {

	public static final DealerMastersTable INSTANCE = new DealerMastersTable();

	public final Column<DealerMastersTable, Long> id = createColumn(
		"id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DealerMastersTable, Long> unionId = createColumn(
		"union_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> dealerName = createColumn(
		"dealer_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> dealerNameEn = createColumn(
		"dealer_name_en", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> dealerSlug = createColumn(
		"dealer_slug", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> fatherName = createColumn(
		"father_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> motherName = createColumn(
		"mother_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, Date> birthDate = createColumn(
		"birth_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> gender = createColumn(
		"gender", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> imagePathReal =
		createColumn(
			"image_path_real", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> imagePathEc = createColumn(
		"image_path_ec", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecPmDivision = createColumn(
		"ec_pm_division", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecPmDistrict = createColumn(
		"ec_pm_district", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecPmRmo = createColumn(
		"ec_pm_rmo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecPmUpazila = createColumn(
		"ec_pm_upazila", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecPmUnionWard =
		createColumn(
			"ec_pm_union_ward", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecPmWardUnionPorishod =
		createColumn(
			"ec_pm_ward_union_porishod", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecPmPostOffice =
		createColumn(
			"ec_pm_post_office", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecPmPostalCode =
		createColumn(
			"ec_pm_postal_code", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecPmMouzaMoholla =
		createColumn(
			"ec_pm_mouza_moholla", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecPmAdditionalMouzaMoholla =
		createColumn(
			"ec_pm_additional_mouza_moholla", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecPmVillageRoad =
		createColumn(
			"ec_pm_village_road", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecPmAdditionalVillageRoad =
		createColumn(
			"ec_pm_additional_village_road", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecPmHomeHoldingNo =
		createColumn(
			"ec_pm_home_holding_no", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecPmRegion = createColumn(
		"ec_pm_region", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecPrDivision = createColumn(
		"ec_pr_division", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecPrDistrict = createColumn(
		"ec_pr_district", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecPrRmo = createColumn(
		"ec_pr_rmo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecPrUpazila = createColumn(
		"ec_pr_upazila", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecPrCityCorpMunicipality =
		createColumn(
			"ec_pr_city_corp_municipality", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecPrUnionWard =
		createColumn(
			"ec_pr_union_ward", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecPrPostOffice =
		createColumn(
			"ec_pr_post_office", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecPrPostalCode =
		createColumn(
			"ec_pr_postal_code", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecPrWardUnionPorishod =
		createColumn(
			"ec_pr_ward_union_porishod", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecPrMouzaMoholla =
		createColumn(
			"ec_pr_mouza_moholla", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecPrAdditionalMouzaMoholla =
		createColumn(
			"ec_pr_additional_mouza_moholla", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecPrVillageRoad =
		createColumn(
			"ec_pr_village_road", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecPrAdditionalVillageRoad =
		createColumn(
			"ec_pr_additional_village_road", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecPrHomeHoldingNo =
		createColumn(
			"ec_pr_home_holding_no", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecPrRegion = createColumn(
		"ec_pr_region", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecOccupation = createColumn(
		"ec_occupation", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> ecBloodGroup = createColumn(
		"ec_blood_group", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, Long> age = createColumn(
		"age", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, Long> pmDivisionId = createColumn(
		"pm_division_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, Long> pmDistrictId = createColumn(
		"pm_district_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, Long> pmUpazilaId = createColumn(
		"pm_upazila_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, Long> pmUnionId = createColumn(
		"pm_union_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> pmPostOffice = createColumn(
		"pm_post_office", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> pmWordNo = createColumn(
		"pm_word_no", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> pmVillage = createColumn(
		"pm_village", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> pmHoldingInfo =
		createColumn(
			"pm_holding_info", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, Long> prDivisionId = createColumn(
		"pr_division_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, Long> prDistrictId = createColumn(
		"pr_district_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, Long> prUpazilaId = createColumn(
		"pr_upazila_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, Long> prUnionId = createColumn(
		"pr_union_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> prPostOffice = createColumn(
		"pr_post_office", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> prWordNo = createColumn(
		"pr_word_no", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> prVillage = createColumn(
		"pr_village", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> prHoldingInfo =
		createColumn(
			"pr_holding_info", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> dealerMobileNo =
		createColumn(
			"dealer_mobile_no", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> dealerNationalId =
		createColumn(
			"dealer_national_id", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> secondNationalId =
		createColumn(
			"second_national_id", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> spouseName = createColumn(
		"spouse_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> spouseFatherName =
		createColumn(
			"spouse_father_name", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, Date> spouseBirthDate =
		createColumn(
			"spouse_birth_date", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> spouseNid = createColumn(
		"spouse_nid", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> spouseSecondNid =
		createColumn(
			"spouse_second_nid", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> govtEmployee = createColumn(
		"govt_employee", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> handicap = createColumn(
		"handicap", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> publicRepresentative =
		createColumn(
			"public_representative", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> vgdStatus = createColumn(
		"vgd_status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, Long> cardNoFromOne = createColumn(
		"card_no_from_one", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, Long> cardNoToOne = createColumn(
		"card_no_to_one", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, Long> cardNoFromTwo = createColumn(
		"card_no_from_two", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, Long> cardNoToTwo = createColumn(
		"card_no_to_two", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, Long> cardNoFromThree =
		createColumn(
			"card_no_from_three", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, Long> cardNoToThree = createColumn(
		"card_no_to_three", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> status = createColumn(
		"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, Date> createdAt = createColumn(
		"created_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, Date> updatedAt = createColumn(
		"updated_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, Long> cardNoFromFour = createColumn(
		"card_no_from_four", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, Long> cardNoToFour = createColumn(
		"card_no_to_four", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, Long> cardNoFromFive = createColumn(
		"card_no_from_five", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, Long> cardNoToFive = createColumn(
		"card_no_to_five", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> singleCards = createColumn(
		"single_cards", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, Long> userId = createColumn(
		"user_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, Long> additionalUnionId =
		createColumn(
			"additional_union_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, Long> upazilaId = createColumn(
		"upazila_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DealerMastersTable, String> remarks = createColumn(
		"remarks", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private DealerMastersTable() {
		super("dgf_dealer_masters", DealerMastersTable::new);
	}

}