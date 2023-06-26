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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DealerMasters}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DealerMasters
 * @generated
 */
public class DealerMastersWrapper
	extends BaseModelWrapper<DealerMasters>
	implements DealerMasters, ModelWrapper<DealerMasters> {

	public DealerMastersWrapper(DealerMasters dealerMasters) {
		super(dealerMasters);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("unionId", getUnionId());
		attributes.put("dealerName", getDealerName());
		attributes.put("dealerNameEn", getDealerNameEn());
		attributes.put("dealerSlug", getDealerSlug());
		attributes.put("fatherName", getFatherName());
		attributes.put("motherName", getMotherName());
		attributes.put("birthDate", getBirthDate());
		attributes.put("gender", getGender());
		attributes.put("imagePathReal", getImagePathReal());
		attributes.put("imagePathEc", getImagePathEc());
		attributes.put("ecPmDivision", getEcPmDivision());
		attributes.put("ecPmDistrict", getEcPmDistrict());
		attributes.put("ecPmRmo", getEcPmRmo());
		attributes.put("ecPmUpazila", getEcPmUpazila());
		attributes.put("ecPmUnionWard", getEcPmUnionWard());
		attributes.put("ecPmWardUnionPorishod", getEcPmWardUnionPorishod());
		attributes.put("ecPmPostOffice", getEcPmPostOffice());
		attributes.put("ecPmPostalCode", getEcPmPostalCode());
		attributes.put("ecPmMouzaMoholla", getEcPmMouzaMoholla());
		attributes.put(
			"ecPmAdditionalMouzaMoholla", getEcPmAdditionalMouzaMoholla());
		attributes.put("ecPmVillageRoad", getEcPmVillageRoad());
		attributes.put(
			"ecPmAdditionalVillageRoad", getEcPmAdditionalVillageRoad());
		attributes.put("ecPmHomeHoldingNo", getEcPmHomeHoldingNo());
		attributes.put("ecPmRegion", getEcPmRegion());
		attributes.put("ecPrDivision", getEcPrDivision());
		attributes.put("ecPrDistrict", getEcPrDistrict());
		attributes.put("ecPrRmo", getEcPrRmo());
		attributes.put("ecPrUpazila", getEcPrUpazila());
		attributes.put(
			"ecPrCityCorpMunicipality", getEcPrCityCorpMunicipality());
		attributes.put("ecPrUnionWard", getEcPrUnionWard());
		attributes.put("ecPrPostOffice", getEcPrPostOffice());
		attributes.put("ecPrPostalCode", getEcPrPostalCode());
		attributes.put("ecPrWardUnionPorishod", getEcPrWardUnionPorishod());
		attributes.put("ecPrMouzaMoholla", getEcPrMouzaMoholla());
		attributes.put(
			"ecPrAdditionalMouzaMoholla", getEcPrAdditionalMouzaMoholla());
		attributes.put("ecPrVillageRoad", getEcPrVillageRoad());
		attributes.put(
			"ecPrAdditionalVillageRoad", getEcPrAdditionalVillageRoad());
		attributes.put("ecPrHomeHoldingNo", getEcPrHomeHoldingNo());
		attributes.put("ecPrRegion", getEcPrRegion());
		attributes.put("ecOccupation", getEcOccupation());
		attributes.put("ecBloodGroup", getEcBloodGroup());
		attributes.put("age", getAge());
		attributes.put("pmDivisionId", getPmDivisionId());
		attributes.put("pmDistrictId", getPmDistrictId());
		attributes.put("pmUpazilaId", getPmUpazilaId());
		attributes.put("pmUnionId", getPmUnionId());
		attributes.put("pmPostOffice", getPmPostOffice());
		attributes.put("pmWordNo", getPmWordNo());
		attributes.put("pmVillage", getPmVillage());
		attributes.put("pmHoldingInfo", getPmHoldingInfo());
		attributes.put("prDivisionId", getPrDivisionId());
		attributes.put("prDistrictId", getPrDistrictId());
		attributes.put("prUpazilaId", getPrUpazilaId());
		attributes.put("prUnionId", getPrUnionId());
		attributes.put("prPostOffice", getPrPostOffice());
		attributes.put("prWordNo", getPrWordNo());
		attributes.put("prVillage", getPrVillage());
		attributes.put("prHoldingInfo", getPrHoldingInfo());
		attributes.put("dealerMobileNo", getDealerMobileNo());
		attributes.put("dealerNationalId", getDealerNationalId());
		attributes.put("secondNationalId", getSecondNationalId());
		attributes.put("spouseName", getSpouseName());
		attributes.put("spouseFatherName", getSpouseFatherName());
		attributes.put("spouseBirthDate", getSpouseBirthDate());
		attributes.put("spouseNid", getSpouseNid());
		attributes.put("spouseSecondNid", getSpouseSecondNid());
		attributes.put("govtEmployee", getGovtEmployee());
		attributes.put("handicap", getHandicap());
		attributes.put("publicRepresentative", getPublicRepresentative());
		attributes.put("vgdStatus", getVgdStatus());
		attributes.put("cardNoFromOne", getCardNoFromOne());
		attributes.put("cardNoToOne", getCardNoToOne());
		attributes.put("cardNoFromTwo", getCardNoFromTwo());
		attributes.put("cardNoToTwo", getCardNoToTwo());
		attributes.put("cardNoFromThree", getCardNoFromThree());
		attributes.put("cardNoToThree", getCardNoToThree());
		attributes.put("status", getStatus());
		attributes.put("createdAt", getCreatedAt());
		attributes.put("updatedAt", getUpdatedAt());
		attributes.put("cardNoFromFour", getCardNoFromFour());
		attributes.put("cardNoToFour", getCardNoToFour());
		attributes.put("cardNoFromFive", getCardNoFromFive());
		attributes.put("cardNoToFive", getCardNoToFive());
		attributes.put("singleCards", getSingleCards());
		attributes.put("userId", getUserId());
		attributes.put("additionalUnionId", getAdditionalUnionId());
		attributes.put("upazilaId", getUpazilaId());
		attributes.put("remarks", getRemarks());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long unionId = (Long)attributes.get("unionId");

		if (unionId != null) {
			setUnionId(unionId);
		}

		String dealerName = (String)attributes.get("dealerName");

		if (dealerName != null) {
			setDealerName(dealerName);
		}

		String dealerNameEn = (String)attributes.get("dealerNameEn");

		if (dealerNameEn != null) {
			setDealerNameEn(dealerNameEn);
		}

		String dealerSlug = (String)attributes.get("dealerSlug");

		if (dealerSlug != null) {
			setDealerSlug(dealerSlug);
		}

		String fatherName = (String)attributes.get("fatherName");

		if (fatherName != null) {
			setFatherName(fatherName);
		}

		String motherName = (String)attributes.get("motherName");

		if (motherName != null) {
			setMotherName(motherName);
		}

		Date birthDate = (Date)attributes.get("birthDate");

		if (birthDate != null) {
			setBirthDate(birthDate);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String imagePathReal = (String)attributes.get("imagePathReal");

		if (imagePathReal != null) {
			setImagePathReal(imagePathReal);
		}

		String imagePathEc = (String)attributes.get("imagePathEc");

		if (imagePathEc != null) {
			setImagePathEc(imagePathEc);
		}

		String ecPmDivision = (String)attributes.get("ecPmDivision");

		if (ecPmDivision != null) {
			setEcPmDivision(ecPmDivision);
		}

		String ecPmDistrict = (String)attributes.get("ecPmDistrict");

		if (ecPmDistrict != null) {
			setEcPmDistrict(ecPmDistrict);
		}

		String ecPmRmo = (String)attributes.get("ecPmRmo");

		if (ecPmRmo != null) {
			setEcPmRmo(ecPmRmo);
		}

		String ecPmUpazila = (String)attributes.get("ecPmUpazila");

		if (ecPmUpazila != null) {
			setEcPmUpazila(ecPmUpazila);
		}

		String ecPmUnionWard = (String)attributes.get("ecPmUnionWard");

		if (ecPmUnionWard != null) {
			setEcPmUnionWard(ecPmUnionWard);
		}

		String ecPmWardUnionPorishod = (String)attributes.get(
			"ecPmWardUnionPorishod");

		if (ecPmWardUnionPorishod != null) {
			setEcPmWardUnionPorishod(ecPmWardUnionPorishod);
		}

		String ecPmPostOffice = (String)attributes.get("ecPmPostOffice");

		if (ecPmPostOffice != null) {
			setEcPmPostOffice(ecPmPostOffice);
		}

		String ecPmPostalCode = (String)attributes.get("ecPmPostalCode");

		if (ecPmPostalCode != null) {
			setEcPmPostalCode(ecPmPostalCode);
		}

		String ecPmMouzaMoholla = (String)attributes.get("ecPmMouzaMoholla");

		if (ecPmMouzaMoholla != null) {
			setEcPmMouzaMoholla(ecPmMouzaMoholla);
		}

		String ecPmAdditionalMouzaMoholla = (String)attributes.get(
			"ecPmAdditionalMouzaMoholla");

		if (ecPmAdditionalMouzaMoholla != null) {
			setEcPmAdditionalMouzaMoholla(ecPmAdditionalMouzaMoholla);
		}

		String ecPmVillageRoad = (String)attributes.get("ecPmVillageRoad");

		if (ecPmVillageRoad != null) {
			setEcPmVillageRoad(ecPmVillageRoad);
		}

		String ecPmAdditionalVillageRoad = (String)attributes.get(
			"ecPmAdditionalVillageRoad");

		if (ecPmAdditionalVillageRoad != null) {
			setEcPmAdditionalVillageRoad(ecPmAdditionalVillageRoad);
		}

		String ecPmHomeHoldingNo = (String)attributes.get("ecPmHomeHoldingNo");

		if (ecPmHomeHoldingNo != null) {
			setEcPmHomeHoldingNo(ecPmHomeHoldingNo);
		}

		String ecPmRegion = (String)attributes.get("ecPmRegion");

		if (ecPmRegion != null) {
			setEcPmRegion(ecPmRegion);
		}

		String ecPrDivision = (String)attributes.get("ecPrDivision");

		if (ecPrDivision != null) {
			setEcPrDivision(ecPrDivision);
		}

		String ecPrDistrict = (String)attributes.get("ecPrDistrict");

		if (ecPrDistrict != null) {
			setEcPrDistrict(ecPrDistrict);
		}

		String ecPrRmo = (String)attributes.get("ecPrRmo");

		if (ecPrRmo != null) {
			setEcPrRmo(ecPrRmo);
		}

		String ecPrUpazila = (String)attributes.get("ecPrUpazila");

		if (ecPrUpazila != null) {
			setEcPrUpazila(ecPrUpazila);
		}

		String ecPrCityCorpMunicipality = (String)attributes.get(
			"ecPrCityCorpMunicipality");

		if (ecPrCityCorpMunicipality != null) {
			setEcPrCityCorpMunicipality(ecPrCityCorpMunicipality);
		}

		String ecPrUnionWard = (String)attributes.get("ecPrUnionWard");

		if (ecPrUnionWard != null) {
			setEcPrUnionWard(ecPrUnionWard);
		}

		String ecPrPostOffice = (String)attributes.get("ecPrPostOffice");

		if (ecPrPostOffice != null) {
			setEcPrPostOffice(ecPrPostOffice);
		}

		String ecPrPostalCode = (String)attributes.get("ecPrPostalCode");

		if (ecPrPostalCode != null) {
			setEcPrPostalCode(ecPrPostalCode);
		}

		String ecPrWardUnionPorishod = (String)attributes.get(
			"ecPrWardUnionPorishod");

		if (ecPrWardUnionPorishod != null) {
			setEcPrWardUnionPorishod(ecPrWardUnionPorishod);
		}

		String ecPrMouzaMoholla = (String)attributes.get("ecPrMouzaMoholla");

		if (ecPrMouzaMoholla != null) {
			setEcPrMouzaMoholla(ecPrMouzaMoholla);
		}

		String ecPrAdditionalMouzaMoholla = (String)attributes.get(
			"ecPrAdditionalMouzaMoholla");

		if (ecPrAdditionalMouzaMoholla != null) {
			setEcPrAdditionalMouzaMoholla(ecPrAdditionalMouzaMoholla);
		}

		String ecPrVillageRoad = (String)attributes.get("ecPrVillageRoad");

		if (ecPrVillageRoad != null) {
			setEcPrVillageRoad(ecPrVillageRoad);
		}

		String ecPrAdditionalVillageRoad = (String)attributes.get(
			"ecPrAdditionalVillageRoad");

		if (ecPrAdditionalVillageRoad != null) {
			setEcPrAdditionalVillageRoad(ecPrAdditionalVillageRoad);
		}

		String ecPrHomeHoldingNo = (String)attributes.get("ecPrHomeHoldingNo");

		if (ecPrHomeHoldingNo != null) {
			setEcPrHomeHoldingNo(ecPrHomeHoldingNo);
		}

		String ecPrRegion = (String)attributes.get("ecPrRegion");

		if (ecPrRegion != null) {
			setEcPrRegion(ecPrRegion);
		}

		String ecOccupation = (String)attributes.get("ecOccupation");

		if (ecOccupation != null) {
			setEcOccupation(ecOccupation);
		}

		String ecBloodGroup = (String)attributes.get("ecBloodGroup");

		if (ecBloodGroup != null) {
			setEcBloodGroup(ecBloodGroup);
		}

		Long age = (Long)attributes.get("age");

		if (age != null) {
			setAge(age);
		}

		Long pmDivisionId = (Long)attributes.get("pmDivisionId");

		if (pmDivisionId != null) {
			setPmDivisionId(pmDivisionId);
		}

		Long pmDistrictId = (Long)attributes.get("pmDistrictId");

		if (pmDistrictId != null) {
			setPmDistrictId(pmDistrictId);
		}

		Long pmUpazilaId = (Long)attributes.get("pmUpazilaId");

		if (pmUpazilaId != null) {
			setPmUpazilaId(pmUpazilaId);
		}

		Long pmUnionId = (Long)attributes.get("pmUnionId");

		if (pmUnionId != null) {
			setPmUnionId(pmUnionId);
		}

		String pmPostOffice = (String)attributes.get("pmPostOffice");

		if (pmPostOffice != null) {
			setPmPostOffice(pmPostOffice);
		}

		String pmWordNo = (String)attributes.get("pmWordNo");

		if (pmWordNo != null) {
			setPmWordNo(pmWordNo);
		}

		String pmVillage = (String)attributes.get("pmVillage");

		if (pmVillage != null) {
			setPmVillage(pmVillage);
		}

		String pmHoldingInfo = (String)attributes.get("pmHoldingInfo");

		if (pmHoldingInfo != null) {
			setPmHoldingInfo(pmHoldingInfo);
		}

		Long prDivisionId = (Long)attributes.get("prDivisionId");

		if (prDivisionId != null) {
			setPrDivisionId(prDivisionId);
		}

		Long prDistrictId = (Long)attributes.get("prDistrictId");

		if (prDistrictId != null) {
			setPrDistrictId(prDistrictId);
		}

		Long prUpazilaId = (Long)attributes.get("prUpazilaId");

		if (prUpazilaId != null) {
			setPrUpazilaId(prUpazilaId);
		}

		Long prUnionId = (Long)attributes.get("prUnionId");

		if (prUnionId != null) {
			setPrUnionId(prUnionId);
		}

		String prPostOffice = (String)attributes.get("prPostOffice");

		if (prPostOffice != null) {
			setPrPostOffice(prPostOffice);
		}

		String prWordNo = (String)attributes.get("prWordNo");

		if (prWordNo != null) {
			setPrWordNo(prWordNo);
		}

		String prVillage = (String)attributes.get("prVillage");

		if (prVillage != null) {
			setPrVillage(prVillage);
		}

		String prHoldingInfo = (String)attributes.get("prHoldingInfo");

		if (prHoldingInfo != null) {
			setPrHoldingInfo(prHoldingInfo);
		}

		String dealerMobileNo = (String)attributes.get("dealerMobileNo");

		if (dealerMobileNo != null) {
			setDealerMobileNo(dealerMobileNo);
		}

		String dealerNationalId = (String)attributes.get("dealerNationalId");

		if (dealerNationalId != null) {
			setDealerNationalId(dealerNationalId);
		}

		String secondNationalId = (String)attributes.get("secondNationalId");

		if (secondNationalId != null) {
			setSecondNationalId(secondNationalId);
		}

		String spouseName = (String)attributes.get("spouseName");

		if (spouseName != null) {
			setSpouseName(spouseName);
		}

		String spouseFatherName = (String)attributes.get("spouseFatherName");

		if (spouseFatherName != null) {
			setSpouseFatherName(spouseFatherName);
		}

		Date spouseBirthDate = (Date)attributes.get("spouseBirthDate");

		if (spouseBirthDate != null) {
			setSpouseBirthDate(spouseBirthDate);
		}

		String spouseNid = (String)attributes.get("spouseNid");

		if (spouseNid != null) {
			setSpouseNid(spouseNid);
		}

		String spouseSecondNid = (String)attributes.get("spouseSecondNid");

		if (spouseSecondNid != null) {
			setSpouseSecondNid(spouseSecondNid);
		}

		String govtEmployee = (String)attributes.get("govtEmployee");

		if (govtEmployee != null) {
			setGovtEmployee(govtEmployee);
		}

		String handicap = (String)attributes.get("handicap");

		if (handicap != null) {
			setHandicap(handicap);
		}

		String publicRepresentative = (String)attributes.get(
			"publicRepresentative");

		if (publicRepresentative != null) {
			setPublicRepresentative(publicRepresentative);
		}

		String vgdStatus = (String)attributes.get("vgdStatus");

		if (vgdStatus != null) {
			setVgdStatus(vgdStatus);
		}

		Long cardNoFromOne = (Long)attributes.get("cardNoFromOne");

		if (cardNoFromOne != null) {
			setCardNoFromOne(cardNoFromOne);
		}

		Long cardNoToOne = (Long)attributes.get("cardNoToOne");

		if (cardNoToOne != null) {
			setCardNoToOne(cardNoToOne);
		}

		Long cardNoFromTwo = (Long)attributes.get("cardNoFromTwo");

		if (cardNoFromTwo != null) {
			setCardNoFromTwo(cardNoFromTwo);
		}

		Long cardNoToTwo = (Long)attributes.get("cardNoToTwo");

		if (cardNoToTwo != null) {
			setCardNoToTwo(cardNoToTwo);
		}

		Long cardNoFromThree = (Long)attributes.get("cardNoFromThree");

		if (cardNoFromThree != null) {
			setCardNoFromThree(cardNoFromThree);
		}

		Long cardNoToThree = (Long)attributes.get("cardNoToThree");

		if (cardNoToThree != null) {
			setCardNoToThree(cardNoToThree);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date createdAt = (Date)attributes.get("createdAt");

		if (createdAt != null) {
			setCreatedAt(createdAt);
		}

		Date updatedAt = (Date)attributes.get("updatedAt");

		if (updatedAt != null) {
			setUpdatedAt(updatedAt);
		}

		Long cardNoFromFour = (Long)attributes.get("cardNoFromFour");

		if (cardNoFromFour != null) {
			setCardNoFromFour(cardNoFromFour);
		}

		Long cardNoToFour = (Long)attributes.get("cardNoToFour");

		if (cardNoToFour != null) {
			setCardNoToFour(cardNoToFour);
		}

		Long cardNoFromFive = (Long)attributes.get("cardNoFromFive");

		if (cardNoFromFive != null) {
			setCardNoFromFive(cardNoFromFive);
		}

		Long cardNoToFive = (Long)attributes.get("cardNoToFive");

		if (cardNoToFive != null) {
			setCardNoToFive(cardNoToFive);
		}

		String singleCards = (String)attributes.get("singleCards");

		if (singleCards != null) {
			setSingleCards(singleCards);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long additionalUnionId = (Long)attributes.get("additionalUnionId");

		if (additionalUnionId != null) {
			setAdditionalUnionId(additionalUnionId);
		}

		Long upazilaId = (Long)attributes.get("upazilaId");

		if (upazilaId != null) {
			setUpazilaId(upazilaId);
		}

		String remarks = (String)attributes.get("remarks");

		if (remarks != null) {
			setRemarks(remarks);
		}
	}

	@Override
	public DealerMasters cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the additional union ID of this dealer masters.
	 *
	 * @return the additional union ID of this dealer masters
	 */
	@Override
	public long getAdditionalUnionId() {
		return model.getAdditionalUnionId();
	}

	/**
	 * Returns the age of this dealer masters.
	 *
	 * @return the age of this dealer masters
	 */
	@Override
	public long getAge() {
		return model.getAge();
	}

	/**
	 * Returns the birth date of this dealer masters.
	 *
	 * @return the birth date of this dealer masters
	 */
	@Override
	public Date getBirthDate() {
		return model.getBirthDate();
	}

	/**
	 * Returns the card no from five of this dealer masters.
	 *
	 * @return the card no from five of this dealer masters
	 */
	@Override
	public long getCardNoFromFive() {
		return model.getCardNoFromFive();
	}

	/**
	 * Returns the card no from four of this dealer masters.
	 *
	 * @return the card no from four of this dealer masters
	 */
	@Override
	public long getCardNoFromFour() {
		return model.getCardNoFromFour();
	}

	/**
	 * Returns the card no from one of this dealer masters.
	 *
	 * @return the card no from one of this dealer masters
	 */
	@Override
	public long getCardNoFromOne() {
		return model.getCardNoFromOne();
	}

	/**
	 * Returns the card no from three of this dealer masters.
	 *
	 * @return the card no from three of this dealer masters
	 */
	@Override
	public long getCardNoFromThree() {
		return model.getCardNoFromThree();
	}

	/**
	 * Returns the card no from two of this dealer masters.
	 *
	 * @return the card no from two of this dealer masters
	 */
	@Override
	public long getCardNoFromTwo() {
		return model.getCardNoFromTwo();
	}

	/**
	 * Returns the card no to five of this dealer masters.
	 *
	 * @return the card no to five of this dealer masters
	 */
	@Override
	public long getCardNoToFive() {
		return model.getCardNoToFive();
	}

	/**
	 * Returns the card no to four of this dealer masters.
	 *
	 * @return the card no to four of this dealer masters
	 */
	@Override
	public long getCardNoToFour() {
		return model.getCardNoToFour();
	}

	/**
	 * Returns the card no to one of this dealer masters.
	 *
	 * @return the card no to one of this dealer masters
	 */
	@Override
	public long getCardNoToOne() {
		return model.getCardNoToOne();
	}

	/**
	 * Returns the card no to three of this dealer masters.
	 *
	 * @return the card no to three of this dealer masters
	 */
	@Override
	public long getCardNoToThree() {
		return model.getCardNoToThree();
	}

	/**
	 * Returns the card no to two of this dealer masters.
	 *
	 * @return the card no to two of this dealer masters
	 */
	@Override
	public long getCardNoToTwo() {
		return model.getCardNoToTwo();
	}

	/**
	 * Returns the created at of this dealer masters.
	 *
	 * @return the created at of this dealer masters
	 */
	@Override
	public Date getCreatedAt() {
		return model.getCreatedAt();
	}

	/**
	 * Returns the dealer mobile no of this dealer masters.
	 *
	 * @return the dealer mobile no of this dealer masters
	 */
	@Override
	public String getDealerMobileNo() {
		return model.getDealerMobileNo();
	}

	/**
	 * Returns the dealer name of this dealer masters.
	 *
	 * @return the dealer name of this dealer masters
	 */
	@Override
	public String getDealerName() {
		return model.getDealerName();
	}

	/**
	 * Returns the dealer name en of this dealer masters.
	 *
	 * @return the dealer name en of this dealer masters
	 */
	@Override
	public String getDealerNameEn() {
		return model.getDealerNameEn();
	}

	/**
	 * Returns the dealer national ID of this dealer masters.
	 *
	 * @return the dealer national ID of this dealer masters
	 */
	@Override
	public String getDealerNationalId() {
		return model.getDealerNationalId();
	}

	/**
	 * Returns the dealer slug of this dealer masters.
	 *
	 * @return the dealer slug of this dealer masters
	 */
	@Override
	public String getDealerSlug() {
		return model.getDealerSlug();
	}

	/**
	 * Returns the ec blood group of this dealer masters.
	 *
	 * @return the ec blood group of this dealer masters
	 */
	@Override
	public String getEcBloodGroup() {
		return model.getEcBloodGroup();
	}

	/**
	 * Returns the ec occupation of this dealer masters.
	 *
	 * @return the ec occupation of this dealer masters
	 */
	@Override
	public String getEcOccupation() {
		return model.getEcOccupation();
	}

	/**
	 * Returns the ec pm additional mouza moholla of this dealer masters.
	 *
	 * @return the ec pm additional mouza moholla of this dealer masters
	 */
	@Override
	public String getEcPmAdditionalMouzaMoholla() {
		return model.getEcPmAdditionalMouzaMoholla();
	}

	/**
	 * Returns the ec pm additional village road of this dealer masters.
	 *
	 * @return the ec pm additional village road of this dealer masters
	 */
	@Override
	public String getEcPmAdditionalVillageRoad() {
		return model.getEcPmAdditionalVillageRoad();
	}

	/**
	 * Returns the ec pm district of this dealer masters.
	 *
	 * @return the ec pm district of this dealer masters
	 */
	@Override
	public String getEcPmDistrict() {
		return model.getEcPmDistrict();
	}

	/**
	 * Returns the ec pm division of this dealer masters.
	 *
	 * @return the ec pm division of this dealer masters
	 */
	@Override
	public String getEcPmDivision() {
		return model.getEcPmDivision();
	}

	/**
	 * Returns the ec pm home holding no of this dealer masters.
	 *
	 * @return the ec pm home holding no of this dealer masters
	 */
	@Override
	public String getEcPmHomeHoldingNo() {
		return model.getEcPmHomeHoldingNo();
	}

	/**
	 * Returns the ec pm mouza moholla of this dealer masters.
	 *
	 * @return the ec pm mouza moholla of this dealer masters
	 */
	@Override
	public String getEcPmMouzaMoholla() {
		return model.getEcPmMouzaMoholla();
	}

	/**
	 * Returns the ec pm postal code of this dealer masters.
	 *
	 * @return the ec pm postal code of this dealer masters
	 */
	@Override
	public String getEcPmPostalCode() {
		return model.getEcPmPostalCode();
	}

	/**
	 * Returns the ec pm post office of this dealer masters.
	 *
	 * @return the ec pm post office of this dealer masters
	 */
	@Override
	public String getEcPmPostOffice() {
		return model.getEcPmPostOffice();
	}

	/**
	 * Returns the ec pm region of this dealer masters.
	 *
	 * @return the ec pm region of this dealer masters
	 */
	@Override
	public String getEcPmRegion() {
		return model.getEcPmRegion();
	}

	/**
	 * Returns the ec pm rmo of this dealer masters.
	 *
	 * @return the ec pm rmo of this dealer masters
	 */
	@Override
	public String getEcPmRmo() {
		return model.getEcPmRmo();
	}

	/**
	 * Returns the ec pm union ward of this dealer masters.
	 *
	 * @return the ec pm union ward of this dealer masters
	 */
	@Override
	public String getEcPmUnionWard() {
		return model.getEcPmUnionWard();
	}

	/**
	 * Returns the ec pm upazila of this dealer masters.
	 *
	 * @return the ec pm upazila of this dealer masters
	 */
	@Override
	public String getEcPmUpazila() {
		return model.getEcPmUpazila();
	}

	/**
	 * Returns the ec pm village road of this dealer masters.
	 *
	 * @return the ec pm village road of this dealer masters
	 */
	@Override
	public String getEcPmVillageRoad() {
		return model.getEcPmVillageRoad();
	}

	/**
	 * Returns the ec pm ward union porishod of this dealer masters.
	 *
	 * @return the ec pm ward union porishod of this dealer masters
	 */
	@Override
	public String getEcPmWardUnionPorishod() {
		return model.getEcPmWardUnionPorishod();
	}

	/**
	 * Returns the ec pr additional mouza moholla of this dealer masters.
	 *
	 * @return the ec pr additional mouza moholla of this dealer masters
	 */
	@Override
	public String getEcPrAdditionalMouzaMoholla() {
		return model.getEcPrAdditionalMouzaMoholla();
	}

	/**
	 * Returns the ec pr additional village road of this dealer masters.
	 *
	 * @return the ec pr additional village road of this dealer masters
	 */
	@Override
	public String getEcPrAdditionalVillageRoad() {
		return model.getEcPrAdditionalVillageRoad();
	}

	/**
	 * Returns the ec pr city corp municipality of this dealer masters.
	 *
	 * @return the ec pr city corp municipality of this dealer masters
	 */
	@Override
	public String getEcPrCityCorpMunicipality() {
		return model.getEcPrCityCorpMunicipality();
	}

	/**
	 * Returns the ec pr district of this dealer masters.
	 *
	 * @return the ec pr district of this dealer masters
	 */
	@Override
	public String getEcPrDistrict() {
		return model.getEcPrDistrict();
	}

	/**
	 * Returns the ec pr division of this dealer masters.
	 *
	 * @return the ec pr division of this dealer masters
	 */
	@Override
	public String getEcPrDivision() {
		return model.getEcPrDivision();
	}

	/**
	 * Returns the ec pr home holding no of this dealer masters.
	 *
	 * @return the ec pr home holding no of this dealer masters
	 */
	@Override
	public String getEcPrHomeHoldingNo() {
		return model.getEcPrHomeHoldingNo();
	}

	/**
	 * Returns the ec pr mouza moholla of this dealer masters.
	 *
	 * @return the ec pr mouza moholla of this dealer masters
	 */
	@Override
	public String getEcPrMouzaMoholla() {
		return model.getEcPrMouzaMoholla();
	}

	/**
	 * Returns the ec pr postal code of this dealer masters.
	 *
	 * @return the ec pr postal code of this dealer masters
	 */
	@Override
	public String getEcPrPostalCode() {
		return model.getEcPrPostalCode();
	}

	/**
	 * Returns the ec pr post office of this dealer masters.
	 *
	 * @return the ec pr post office of this dealer masters
	 */
	@Override
	public String getEcPrPostOffice() {
		return model.getEcPrPostOffice();
	}

	/**
	 * Returns the ec pr region of this dealer masters.
	 *
	 * @return the ec pr region of this dealer masters
	 */
	@Override
	public String getEcPrRegion() {
		return model.getEcPrRegion();
	}

	/**
	 * Returns the ec pr rmo of this dealer masters.
	 *
	 * @return the ec pr rmo of this dealer masters
	 */
	@Override
	public String getEcPrRmo() {
		return model.getEcPrRmo();
	}

	/**
	 * Returns the ec pr union ward of this dealer masters.
	 *
	 * @return the ec pr union ward of this dealer masters
	 */
	@Override
	public String getEcPrUnionWard() {
		return model.getEcPrUnionWard();
	}

	/**
	 * Returns the ec pr upazila of this dealer masters.
	 *
	 * @return the ec pr upazila of this dealer masters
	 */
	@Override
	public String getEcPrUpazila() {
		return model.getEcPrUpazila();
	}

	/**
	 * Returns the ec pr village road of this dealer masters.
	 *
	 * @return the ec pr village road of this dealer masters
	 */
	@Override
	public String getEcPrVillageRoad() {
		return model.getEcPrVillageRoad();
	}

	/**
	 * Returns the ec pr ward union porishod of this dealer masters.
	 *
	 * @return the ec pr ward union porishod of this dealer masters
	 */
	@Override
	public String getEcPrWardUnionPorishod() {
		return model.getEcPrWardUnionPorishod();
	}

	/**
	 * Returns the father name of this dealer masters.
	 *
	 * @return the father name of this dealer masters
	 */
	@Override
	public String getFatherName() {
		return model.getFatherName();
	}

	/**
	 * Returns the gender of this dealer masters.
	 *
	 * @return the gender of this dealer masters
	 */
	@Override
	public String getGender() {
		return model.getGender();
	}

	/**
	 * Returns the govt employee of this dealer masters.
	 *
	 * @return the govt employee of this dealer masters
	 */
	@Override
	public String getGovtEmployee() {
		return model.getGovtEmployee();
	}

	/**
	 * Returns the handicap of this dealer masters.
	 *
	 * @return the handicap of this dealer masters
	 */
	@Override
	public String getHandicap() {
		return model.getHandicap();
	}

	/**
	 * Returns the ID of this dealer masters.
	 *
	 * @return the ID of this dealer masters
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the image path ec of this dealer masters.
	 *
	 * @return the image path ec of this dealer masters
	 */
	@Override
	public String getImagePathEc() {
		return model.getImagePathEc();
	}

	/**
	 * Returns the image path real of this dealer masters.
	 *
	 * @return the image path real of this dealer masters
	 */
	@Override
	public String getImagePathReal() {
		return model.getImagePathReal();
	}

	/**
	 * Returns the mother name of this dealer masters.
	 *
	 * @return the mother name of this dealer masters
	 */
	@Override
	public String getMotherName() {
		return model.getMotherName();
	}

	/**
	 * Returns the pm district ID of this dealer masters.
	 *
	 * @return the pm district ID of this dealer masters
	 */
	@Override
	public long getPmDistrictId() {
		return model.getPmDistrictId();
	}

	/**
	 * Returns the pm division ID of this dealer masters.
	 *
	 * @return the pm division ID of this dealer masters
	 */
	@Override
	public long getPmDivisionId() {
		return model.getPmDivisionId();
	}

	/**
	 * Returns the pm holding info of this dealer masters.
	 *
	 * @return the pm holding info of this dealer masters
	 */
	@Override
	public String getPmHoldingInfo() {
		return model.getPmHoldingInfo();
	}

	/**
	 * Returns the pm post office of this dealer masters.
	 *
	 * @return the pm post office of this dealer masters
	 */
	@Override
	public String getPmPostOffice() {
		return model.getPmPostOffice();
	}

	/**
	 * Returns the pm union ID of this dealer masters.
	 *
	 * @return the pm union ID of this dealer masters
	 */
	@Override
	public long getPmUnionId() {
		return model.getPmUnionId();
	}

	/**
	 * Returns the pm upazila ID of this dealer masters.
	 *
	 * @return the pm upazila ID of this dealer masters
	 */
	@Override
	public long getPmUpazilaId() {
		return model.getPmUpazilaId();
	}

	/**
	 * Returns the pm village of this dealer masters.
	 *
	 * @return the pm village of this dealer masters
	 */
	@Override
	public String getPmVillage() {
		return model.getPmVillage();
	}

	/**
	 * Returns the pm word no of this dealer masters.
	 *
	 * @return the pm word no of this dealer masters
	 */
	@Override
	public String getPmWordNo() {
		return model.getPmWordNo();
	}

	/**
	 * Returns the pr district ID of this dealer masters.
	 *
	 * @return the pr district ID of this dealer masters
	 */
	@Override
	public long getPrDistrictId() {
		return model.getPrDistrictId();
	}

	/**
	 * Returns the pr division ID of this dealer masters.
	 *
	 * @return the pr division ID of this dealer masters
	 */
	@Override
	public long getPrDivisionId() {
		return model.getPrDivisionId();
	}

	/**
	 * Returns the pr holding info of this dealer masters.
	 *
	 * @return the pr holding info of this dealer masters
	 */
	@Override
	public String getPrHoldingInfo() {
		return model.getPrHoldingInfo();
	}

	/**
	 * Returns the primary key of this dealer masters.
	 *
	 * @return the primary key of this dealer masters
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the pr post office of this dealer masters.
	 *
	 * @return the pr post office of this dealer masters
	 */
	@Override
	public String getPrPostOffice() {
		return model.getPrPostOffice();
	}

	/**
	 * Returns the pr union ID of this dealer masters.
	 *
	 * @return the pr union ID of this dealer masters
	 */
	@Override
	public long getPrUnionId() {
		return model.getPrUnionId();
	}

	/**
	 * Returns the pr upazila ID of this dealer masters.
	 *
	 * @return the pr upazila ID of this dealer masters
	 */
	@Override
	public long getPrUpazilaId() {
		return model.getPrUpazilaId();
	}

	/**
	 * Returns the pr village of this dealer masters.
	 *
	 * @return the pr village of this dealer masters
	 */
	@Override
	public String getPrVillage() {
		return model.getPrVillage();
	}

	/**
	 * Returns the pr word no of this dealer masters.
	 *
	 * @return the pr word no of this dealer masters
	 */
	@Override
	public String getPrWordNo() {
		return model.getPrWordNo();
	}

	/**
	 * Returns the public representative of this dealer masters.
	 *
	 * @return the public representative of this dealer masters
	 */
	@Override
	public String getPublicRepresentative() {
		return model.getPublicRepresentative();
	}

	/**
	 * Returns the remarks of this dealer masters.
	 *
	 * @return the remarks of this dealer masters
	 */
	@Override
	public String getRemarks() {
		return model.getRemarks();
	}

	/**
	 * Returns the second national ID of this dealer masters.
	 *
	 * @return the second national ID of this dealer masters
	 */
	@Override
	public String getSecondNationalId() {
		return model.getSecondNationalId();
	}

	/**
	 * Returns the single cards of this dealer masters.
	 *
	 * @return the single cards of this dealer masters
	 */
	@Override
	public String getSingleCards() {
		return model.getSingleCards();
	}

	/**
	 * Returns the spouse birth date of this dealer masters.
	 *
	 * @return the spouse birth date of this dealer masters
	 */
	@Override
	public Date getSpouseBirthDate() {
		return model.getSpouseBirthDate();
	}

	/**
	 * Returns the spouse father name of this dealer masters.
	 *
	 * @return the spouse father name of this dealer masters
	 */
	@Override
	public String getSpouseFatherName() {
		return model.getSpouseFatherName();
	}

	/**
	 * Returns the spouse name of this dealer masters.
	 *
	 * @return the spouse name of this dealer masters
	 */
	@Override
	public String getSpouseName() {
		return model.getSpouseName();
	}

	/**
	 * Returns the spouse nid of this dealer masters.
	 *
	 * @return the spouse nid of this dealer masters
	 */
	@Override
	public String getSpouseNid() {
		return model.getSpouseNid();
	}

	/**
	 * Returns the spouse second nid of this dealer masters.
	 *
	 * @return the spouse second nid of this dealer masters
	 */
	@Override
	public String getSpouseSecondNid() {
		return model.getSpouseSecondNid();
	}

	/**
	 * Returns the status of this dealer masters.
	 *
	 * @return the status of this dealer masters
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the union ID of this dealer masters.
	 *
	 * @return the union ID of this dealer masters
	 */
	@Override
	public long getUnionId() {
		return model.getUnionId();
	}

	/**
	 * Returns the upazila ID of this dealer masters.
	 *
	 * @return the upazila ID of this dealer masters
	 */
	@Override
	public long getUpazilaId() {
		return model.getUpazilaId();
	}

	/**
	 * Returns the updated at of this dealer masters.
	 *
	 * @return the updated at of this dealer masters
	 */
	@Override
	public Date getUpdatedAt() {
		return model.getUpdatedAt();
	}

	/**
	 * Returns the user ID of this dealer masters.
	 *
	 * @return the user ID of this dealer masters
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this dealer masters.
	 *
	 * @return the user uuid of this dealer masters
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the vgd status of this dealer masters.
	 *
	 * @return the vgd status of this dealer masters
	 */
	@Override
	public String getVgdStatus() {
		return model.getVgdStatus();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the additional union ID of this dealer masters.
	 *
	 * @param additionalUnionId the additional union ID of this dealer masters
	 */
	@Override
	public void setAdditionalUnionId(long additionalUnionId) {
		model.setAdditionalUnionId(additionalUnionId);
	}

	/**
	 * Sets the age of this dealer masters.
	 *
	 * @param age the age of this dealer masters
	 */
	@Override
	public void setAge(long age) {
		model.setAge(age);
	}

	/**
	 * Sets the birth date of this dealer masters.
	 *
	 * @param birthDate the birth date of this dealer masters
	 */
	@Override
	public void setBirthDate(Date birthDate) {
		model.setBirthDate(birthDate);
	}

	/**
	 * Sets the card no from five of this dealer masters.
	 *
	 * @param cardNoFromFive the card no from five of this dealer masters
	 */
	@Override
	public void setCardNoFromFive(long cardNoFromFive) {
		model.setCardNoFromFive(cardNoFromFive);
	}

	/**
	 * Sets the card no from four of this dealer masters.
	 *
	 * @param cardNoFromFour the card no from four of this dealer masters
	 */
	@Override
	public void setCardNoFromFour(long cardNoFromFour) {
		model.setCardNoFromFour(cardNoFromFour);
	}

	/**
	 * Sets the card no from one of this dealer masters.
	 *
	 * @param cardNoFromOne the card no from one of this dealer masters
	 */
	@Override
	public void setCardNoFromOne(long cardNoFromOne) {
		model.setCardNoFromOne(cardNoFromOne);
	}

	/**
	 * Sets the card no from three of this dealer masters.
	 *
	 * @param cardNoFromThree the card no from three of this dealer masters
	 */
	@Override
	public void setCardNoFromThree(long cardNoFromThree) {
		model.setCardNoFromThree(cardNoFromThree);
	}

	/**
	 * Sets the card no from two of this dealer masters.
	 *
	 * @param cardNoFromTwo the card no from two of this dealer masters
	 */
	@Override
	public void setCardNoFromTwo(long cardNoFromTwo) {
		model.setCardNoFromTwo(cardNoFromTwo);
	}

	/**
	 * Sets the card no to five of this dealer masters.
	 *
	 * @param cardNoToFive the card no to five of this dealer masters
	 */
	@Override
	public void setCardNoToFive(long cardNoToFive) {
		model.setCardNoToFive(cardNoToFive);
	}

	/**
	 * Sets the card no to four of this dealer masters.
	 *
	 * @param cardNoToFour the card no to four of this dealer masters
	 */
	@Override
	public void setCardNoToFour(long cardNoToFour) {
		model.setCardNoToFour(cardNoToFour);
	}

	/**
	 * Sets the card no to one of this dealer masters.
	 *
	 * @param cardNoToOne the card no to one of this dealer masters
	 */
	@Override
	public void setCardNoToOne(long cardNoToOne) {
		model.setCardNoToOne(cardNoToOne);
	}

	/**
	 * Sets the card no to three of this dealer masters.
	 *
	 * @param cardNoToThree the card no to three of this dealer masters
	 */
	@Override
	public void setCardNoToThree(long cardNoToThree) {
		model.setCardNoToThree(cardNoToThree);
	}

	/**
	 * Sets the card no to two of this dealer masters.
	 *
	 * @param cardNoToTwo the card no to two of this dealer masters
	 */
	@Override
	public void setCardNoToTwo(long cardNoToTwo) {
		model.setCardNoToTwo(cardNoToTwo);
	}

	/**
	 * Sets the created at of this dealer masters.
	 *
	 * @param createdAt the created at of this dealer masters
	 */
	@Override
	public void setCreatedAt(Date createdAt) {
		model.setCreatedAt(createdAt);
	}

	/**
	 * Sets the dealer mobile no of this dealer masters.
	 *
	 * @param dealerMobileNo the dealer mobile no of this dealer masters
	 */
	@Override
	public void setDealerMobileNo(String dealerMobileNo) {
		model.setDealerMobileNo(dealerMobileNo);
	}

	/**
	 * Sets the dealer name of this dealer masters.
	 *
	 * @param dealerName the dealer name of this dealer masters
	 */
	@Override
	public void setDealerName(String dealerName) {
		model.setDealerName(dealerName);
	}

	/**
	 * Sets the dealer name en of this dealer masters.
	 *
	 * @param dealerNameEn the dealer name en of this dealer masters
	 */
	@Override
	public void setDealerNameEn(String dealerNameEn) {
		model.setDealerNameEn(dealerNameEn);
	}

	/**
	 * Sets the dealer national ID of this dealer masters.
	 *
	 * @param dealerNationalId the dealer national ID of this dealer masters
	 */
	@Override
	public void setDealerNationalId(String dealerNationalId) {
		model.setDealerNationalId(dealerNationalId);
	}

	/**
	 * Sets the dealer slug of this dealer masters.
	 *
	 * @param dealerSlug the dealer slug of this dealer masters
	 */
	@Override
	public void setDealerSlug(String dealerSlug) {
		model.setDealerSlug(dealerSlug);
	}

	/**
	 * Sets the ec blood group of this dealer masters.
	 *
	 * @param ecBloodGroup the ec blood group of this dealer masters
	 */
	@Override
	public void setEcBloodGroup(String ecBloodGroup) {
		model.setEcBloodGroup(ecBloodGroup);
	}

	/**
	 * Sets the ec occupation of this dealer masters.
	 *
	 * @param ecOccupation the ec occupation of this dealer masters
	 */
	@Override
	public void setEcOccupation(String ecOccupation) {
		model.setEcOccupation(ecOccupation);
	}

	/**
	 * Sets the ec pm additional mouza moholla of this dealer masters.
	 *
	 * @param ecPmAdditionalMouzaMoholla the ec pm additional mouza moholla of this dealer masters
	 */
	@Override
	public void setEcPmAdditionalMouzaMoholla(
		String ecPmAdditionalMouzaMoholla) {

		model.setEcPmAdditionalMouzaMoholla(ecPmAdditionalMouzaMoholla);
	}

	/**
	 * Sets the ec pm additional village road of this dealer masters.
	 *
	 * @param ecPmAdditionalVillageRoad the ec pm additional village road of this dealer masters
	 */
	@Override
	public void setEcPmAdditionalVillageRoad(String ecPmAdditionalVillageRoad) {
		model.setEcPmAdditionalVillageRoad(ecPmAdditionalVillageRoad);
	}

	/**
	 * Sets the ec pm district of this dealer masters.
	 *
	 * @param ecPmDistrict the ec pm district of this dealer masters
	 */
	@Override
	public void setEcPmDistrict(String ecPmDistrict) {
		model.setEcPmDistrict(ecPmDistrict);
	}

	/**
	 * Sets the ec pm division of this dealer masters.
	 *
	 * @param ecPmDivision the ec pm division of this dealer masters
	 */
	@Override
	public void setEcPmDivision(String ecPmDivision) {
		model.setEcPmDivision(ecPmDivision);
	}

	/**
	 * Sets the ec pm home holding no of this dealer masters.
	 *
	 * @param ecPmHomeHoldingNo the ec pm home holding no of this dealer masters
	 */
	@Override
	public void setEcPmHomeHoldingNo(String ecPmHomeHoldingNo) {
		model.setEcPmHomeHoldingNo(ecPmHomeHoldingNo);
	}

	/**
	 * Sets the ec pm mouza moholla of this dealer masters.
	 *
	 * @param ecPmMouzaMoholla the ec pm mouza moholla of this dealer masters
	 */
	@Override
	public void setEcPmMouzaMoholla(String ecPmMouzaMoholla) {
		model.setEcPmMouzaMoholla(ecPmMouzaMoholla);
	}

	/**
	 * Sets the ec pm postal code of this dealer masters.
	 *
	 * @param ecPmPostalCode the ec pm postal code of this dealer masters
	 */
	@Override
	public void setEcPmPostalCode(String ecPmPostalCode) {
		model.setEcPmPostalCode(ecPmPostalCode);
	}

	/**
	 * Sets the ec pm post office of this dealer masters.
	 *
	 * @param ecPmPostOffice the ec pm post office of this dealer masters
	 */
	@Override
	public void setEcPmPostOffice(String ecPmPostOffice) {
		model.setEcPmPostOffice(ecPmPostOffice);
	}

	/**
	 * Sets the ec pm region of this dealer masters.
	 *
	 * @param ecPmRegion the ec pm region of this dealer masters
	 */
	@Override
	public void setEcPmRegion(String ecPmRegion) {
		model.setEcPmRegion(ecPmRegion);
	}

	/**
	 * Sets the ec pm rmo of this dealer masters.
	 *
	 * @param ecPmRmo the ec pm rmo of this dealer masters
	 */
	@Override
	public void setEcPmRmo(String ecPmRmo) {
		model.setEcPmRmo(ecPmRmo);
	}

	/**
	 * Sets the ec pm union ward of this dealer masters.
	 *
	 * @param ecPmUnionWard the ec pm union ward of this dealer masters
	 */
	@Override
	public void setEcPmUnionWard(String ecPmUnionWard) {
		model.setEcPmUnionWard(ecPmUnionWard);
	}

	/**
	 * Sets the ec pm upazila of this dealer masters.
	 *
	 * @param ecPmUpazila the ec pm upazila of this dealer masters
	 */
	@Override
	public void setEcPmUpazila(String ecPmUpazila) {
		model.setEcPmUpazila(ecPmUpazila);
	}

	/**
	 * Sets the ec pm village road of this dealer masters.
	 *
	 * @param ecPmVillageRoad the ec pm village road of this dealer masters
	 */
	@Override
	public void setEcPmVillageRoad(String ecPmVillageRoad) {
		model.setEcPmVillageRoad(ecPmVillageRoad);
	}

	/**
	 * Sets the ec pm ward union porishod of this dealer masters.
	 *
	 * @param ecPmWardUnionPorishod the ec pm ward union porishod of this dealer masters
	 */
	@Override
	public void setEcPmWardUnionPorishod(String ecPmWardUnionPorishod) {
		model.setEcPmWardUnionPorishod(ecPmWardUnionPorishod);
	}

	/**
	 * Sets the ec pr additional mouza moholla of this dealer masters.
	 *
	 * @param ecPrAdditionalMouzaMoholla the ec pr additional mouza moholla of this dealer masters
	 */
	@Override
	public void setEcPrAdditionalMouzaMoholla(
		String ecPrAdditionalMouzaMoholla) {

		model.setEcPrAdditionalMouzaMoholla(ecPrAdditionalMouzaMoholla);
	}

	/**
	 * Sets the ec pr additional village road of this dealer masters.
	 *
	 * @param ecPrAdditionalVillageRoad the ec pr additional village road of this dealer masters
	 */
	@Override
	public void setEcPrAdditionalVillageRoad(String ecPrAdditionalVillageRoad) {
		model.setEcPrAdditionalVillageRoad(ecPrAdditionalVillageRoad);
	}

	/**
	 * Sets the ec pr city corp municipality of this dealer masters.
	 *
	 * @param ecPrCityCorpMunicipality the ec pr city corp municipality of this dealer masters
	 */
	@Override
	public void setEcPrCityCorpMunicipality(String ecPrCityCorpMunicipality) {
		model.setEcPrCityCorpMunicipality(ecPrCityCorpMunicipality);
	}

	/**
	 * Sets the ec pr district of this dealer masters.
	 *
	 * @param ecPrDistrict the ec pr district of this dealer masters
	 */
	@Override
	public void setEcPrDistrict(String ecPrDistrict) {
		model.setEcPrDistrict(ecPrDistrict);
	}

	/**
	 * Sets the ec pr division of this dealer masters.
	 *
	 * @param ecPrDivision the ec pr division of this dealer masters
	 */
	@Override
	public void setEcPrDivision(String ecPrDivision) {
		model.setEcPrDivision(ecPrDivision);
	}

	/**
	 * Sets the ec pr home holding no of this dealer masters.
	 *
	 * @param ecPrHomeHoldingNo the ec pr home holding no of this dealer masters
	 */
	@Override
	public void setEcPrHomeHoldingNo(String ecPrHomeHoldingNo) {
		model.setEcPrHomeHoldingNo(ecPrHomeHoldingNo);
	}

	/**
	 * Sets the ec pr mouza moholla of this dealer masters.
	 *
	 * @param ecPrMouzaMoholla the ec pr mouza moholla of this dealer masters
	 */
	@Override
	public void setEcPrMouzaMoholla(String ecPrMouzaMoholla) {
		model.setEcPrMouzaMoholla(ecPrMouzaMoholla);
	}

	/**
	 * Sets the ec pr postal code of this dealer masters.
	 *
	 * @param ecPrPostalCode the ec pr postal code of this dealer masters
	 */
	@Override
	public void setEcPrPostalCode(String ecPrPostalCode) {
		model.setEcPrPostalCode(ecPrPostalCode);
	}

	/**
	 * Sets the ec pr post office of this dealer masters.
	 *
	 * @param ecPrPostOffice the ec pr post office of this dealer masters
	 */
	@Override
	public void setEcPrPostOffice(String ecPrPostOffice) {
		model.setEcPrPostOffice(ecPrPostOffice);
	}

	/**
	 * Sets the ec pr region of this dealer masters.
	 *
	 * @param ecPrRegion the ec pr region of this dealer masters
	 */
	@Override
	public void setEcPrRegion(String ecPrRegion) {
		model.setEcPrRegion(ecPrRegion);
	}

	/**
	 * Sets the ec pr rmo of this dealer masters.
	 *
	 * @param ecPrRmo the ec pr rmo of this dealer masters
	 */
	@Override
	public void setEcPrRmo(String ecPrRmo) {
		model.setEcPrRmo(ecPrRmo);
	}

	/**
	 * Sets the ec pr union ward of this dealer masters.
	 *
	 * @param ecPrUnionWard the ec pr union ward of this dealer masters
	 */
	@Override
	public void setEcPrUnionWard(String ecPrUnionWard) {
		model.setEcPrUnionWard(ecPrUnionWard);
	}

	/**
	 * Sets the ec pr upazila of this dealer masters.
	 *
	 * @param ecPrUpazila the ec pr upazila of this dealer masters
	 */
	@Override
	public void setEcPrUpazila(String ecPrUpazila) {
		model.setEcPrUpazila(ecPrUpazila);
	}

	/**
	 * Sets the ec pr village road of this dealer masters.
	 *
	 * @param ecPrVillageRoad the ec pr village road of this dealer masters
	 */
	@Override
	public void setEcPrVillageRoad(String ecPrVillageRoad) {
		model.setEcPrVillageRoad(ecPrVillageRoad);
	}

	/**
	 * Sets the ec pr ward union porishod of this dealer masters.
	 *
	 * @param ecPrWardUnionPorishod the ec pr ward union porishod of this dealer masters
	 */
	@Override
	public void setEcPrWardUnionPorishod(String ecPrWardUnionPorishod) {
		model.setEcPrWardUnionPorishod(ecPrWardUnionPorishod);
	}

	/**
	 * Sets the father name of this dealer masters.
	 *
	 * @param fatherName the father name of this dealer masters
	 */
	@Override
	public void setFatherName(String fatherName) {
		model.setFatherName(fatherName);
	}

	/**
	 * Sets the gender of this dealer masters.
	 *
	 * @param gender the gender of this dealer masters
	 */
	@Override
	public void setGender(String gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the govt employee of this dealer masters.
	 *
	 * @param govtEmployee the govt employee of this dealer masters
	 */
	@Override
	public void setGovtEmployee(String govtEmployee) {
		model.setGovtEmployee(govtEmployee);
	}

	/**
	 * Sets the handicap of this dealer masters.
	 *
	 * @param handicap the handicap of this dealer masters
	 */
	@Override
	public void setHandicap(String handicap) {
		model.setHandicap(handicap);
	}

	/**
	 * Sets the ID of this dealer masters.
	 *
	 * @param id the ID of this dealer masters
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the image path ec of this dealer masters.
	 *
	 * @param imagePathEc the image path ec of this dealer masters
	 */
	@Override
	public void setImagePathEc(String imagePathEc) {
		model.setImagePathEc(imagePathEc);
	}

	/**
	 * Sets the image path real of this dealer masters.
	 *
	 * @param imagePathReal the image path real of this dealer masters
	 */
	@Override
	public void setImagePathReal(String imagePathReal) {
		model.setImagePathReal(imagePathReal);
	}

	/**
	 * Sets the mother name of this dealer masters.
	 *
	 * @param motherName the mother name of this dealer masters
	 */
	@Override
	public void setMotherName(String motherName) {
		model.setMotherName(motherName);
	}

	/**
	 * Sets the pm district ID of this dealer masters.
	 *
	 * @param pmDistrictId the pm district ID of this dealer masters
	 */
	@Override
	public void setPmDistrictId(long pmDistrictId) {
		model.setPmDistrictId(pmDistrictId);
	}

	/**
	 * Sets the pm division ID of this dealer masters.
	 *
	 * @param pmDivisionId the pm division ID of this dealer masters
	 */
	@Override
	public void setPmDivisionId(long pmDivisionId) {
		model.setPmDivisionId(pmDivisionId);
	}

	/**
	 * Sets the pm holding info of this dealer masters.
	 *
	 * @param pmHoldingInfo the pm holding info of this dealer masters
	 */
	@Override
	public void setPmHoldingInfo(String pmHoldingInfo) {
		model.setPmHoldingInfo(pmHoldingInfo);
	}

	/**
	 * Sets the pm post office of this dealer masters.
	 *
	 * @param pmPostOffice the pm post office of this dealer masters
	 */
	@Override
	public void setPmPostOffice(String pmPostOffice) {
		model.setPmPostOffice(pmPostOffice);
	}

	/**
	 * Sets the pm union ID of this dealer masters.
	 *
	 * @param pmUnionId the pm union ID of this dealer masters
	 */
	@Override
	public void setPmUnionId(long pmUnionId) {
		model.setPmUnionId(pmUnionId);
	}

	/**
	 * Sets the pm upazila ID of this dealer masters.
	 *
	 * @param pmUpazilaId the pm upazila ID of this dealer masters
	 */
	@Override
	public void setPmUpazilaId(long pmUpazilaId) {
		model.setPmUpazilaId(pmUpazilaId);
	}

	/**
	 * Sets the pm village of this dealer masters.
	 *
	 * @param pmVillage the pm village of this dealer masters
	 */
	@Override
	public void setPmVillage(String pmVillage) {
		model.setPmVillage(pmVillage);
	}

	/**
	 * Sets the pm word no of this dealer masters.
	 *
	 * @param pmWordNo the pm word no of this dealer masters
	 */
	@Override
	public void setPmWordNo(String pmWordNo) {
		model.setPmWordNo(pmWordNo);
	}

	/**
	 * Sets the pr district ID of this dealer masters.
	 *
	 * @param prDistrictId the pr district ID of this dealer masters
	 */
	@Override
	public void setPrDistrictId(long prDistrictId) {
		model.setPrDistrictId(prDistrictId);
	}

	/**
	 * Sets the pr division ID of this dealer masters.
	 *
	 * @param prDivisionId the pr division ID of this dealer masters
	 */
	@Override
	public void setPrDivisionId(long prDivisionId) {
		model.setPrDivisionId(prDivisionId);
	}

	/**
	 * Sets the pr holding info of this dealer masters.
	 *
	 * @param prHoldingInfo the pr holding info of this dealer masters
	 */
	@Override
	public void setPrHoldingInfo(String prHoldingInfo) {
		model.setPrHoldingInfo(prHoldingInfo);
	}

	/**
	 * Sets the primary key of this dealer masters.
	 *
	 * @param primaryKey the primary key of this dealer masters
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the pr post office of this dealer masters.
	 *
	 * @param prPostOffice the pr post office of this dealer masters
	 */
	@Override
	public void setPrPostOffice(String prPostOffice) {
		model.setPrPostOffice(prPostOffice);
	}

	/**
	 * Sets the pr union ID of this dealer masters.
	 *
	 * @param prUnionId the pr union ID of this dealer masters
	 */
	@Override
	public void setPrUnionId(long prUnionId) {
		model.setPrUnionId(prUnionId);
	}

	/**
	 * Sets the pr upazila ID of this dealer masters.
	 *
	 * @param prUpazilaId the pr upazila ID of this dealer masters
	 */
	@Override
	public void setPrUpazilaId(long prUpazilaId) {
		model.setPrUpazilaId(prUpazilaId);
	}

	/**
	 * Sets the pr village of this dealer masters.
	 *
	 * @param prVillage the pr village of this dealer masters
	 */
	@Override
	public void setPrVillage(String prVillage) {
		model.setPrVillage(prVillage);
	}

	/**
	 * Sets the pr word no of this dealer masters.
	 *
	 * @param prWordNo the pr word no of this dealer masters
	 */
	@Override
	public void setPrWordNo(String prWordNo) {
		model.setPrWordNo(prWordNo);
	}

	/**
	 * Sets the public representative of this dealer masters.
	 *
	 * @param publicRepresentative the public representative of this dealer masters
	 */
	@Override
	public void setPublicRepresentative(String publicRepresentative) {
		model.setPublicRepresentative(publicRepresentative);
	}

	/**
	 * Sets the remarks of this dealer masters.
	 *
	 * @param remarks the remarks of this dealer masters
	 */
	@Override
	public void setRemarks(String remarks) {
		model.setRemarks(remarks);
	}

	/**
	 * Sets the second national ID of this dealer masters.
	 *
	 * @param secondNationalId the second national ID of this dealer masters
	 */
	@Override
	public void setSecondNationalId(String secondNationalId) {
		model.setSecondNationalId(secondNationalId);
	}

	/**
	 * Sets the single cards of this dealer masters.
	 *
	 * @param singleCards the single cards of this dealer masters
	 */
	@Override
	public void setSingleCards(String singleCards) {
		model.setSingleCards(singleCards);
	}

	/**
	 * Sets the spouse birth date of this dealer masters.
	 *
	 * @param spouseBirthDate the spouse birth date of this dealer masters
	 */
	@Override
	public void setSpouseBirthDate(Date spouseBirthDate) {
		model.setSpouseBirthDate(spouseBirthDate);
	}

	/**
	 * Sets the spouse father name of this dealer masters.
	 *
	 * @param spouseFatherName the spouse father name of this dealer masters
	 */
	@Override
	public void setSpouseFatherName(String spouseFatherName) {
		model.setSpouseFatherName(spouseFatherName);
	}

	/**
	 * Sets the spouse name of this dealer masters.
	 *
	 * @param spouseName the spouse name of this dealer masters
	 */
	@Override
	public void setSpouseName(String spouseName) {
		model.setSpouseName(spouseName);
	}

	/**
	 * Sets the spouse nid of this dealer masters.
	 *
	 * @param spouseNid the spouse nid of this dealer masters
	 */
	@Override
	public void setSpouseNid(String spouseNid) {
		model.setSpouseNid(spouseNid);
	}

	/**
	 * Sets the spouse second nid of this dealer masters.
	 *
	 * @param spouseSecondNid the spouse second nid of this dealer masters
	 */
	@Override
	public void setSpouseSecondNid(String spouseSecondNid) {
		model.setSpouseSecondNid(spouseSecondNid);
	}

	/**
	 * Sets the status of this dealer masters.
	 *
	 * @param status the status of this dealer masters
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the union ID of this dealer masters.
	 *
	 * @param unionId the union ID of this dealer masters
	 */
	@Override
	public void setUnionId(long unionId) {
		model.setUnionId(unionId);
	}

	/**
	 * Sets the upazila ID of this dealer masters.
	 *
	 * @param upazilaId the upazila ID of this dealer masters
	 */
	@Override
	public void setUpazilaId(long upazilaId) {
		model.setUpazilaId(upazilaId);
	}

	/**
	 * Sets the updated at of this dealer masters.
	 *
	 * @param updatedAt the updated at of this dealer masters
	 */
	@Override
	public void setUpdatedAt(Date updatedAt) {
		model.setUpdatedAt(updatedAt);
	}

	/**
	 * Sets the user ID of this dealer masters.
	 *
	 * @param userId the user ID of this dealer masters
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this dealer masters.
	 *
	 * @param userUuid the user uuid of this dealer masters
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the vgd status of this dealer masters.
	 *
	 * @param vgdStatus the vgd status of this dealer masters
	 */
	@Override
	public void setVgdStatus(String vgdStatus) {
		model.setVgdStatus(vgdStatus);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DealerMastersWrapper wrap(DealerMasters dealerMasters) {
		return new DealerMastersWrapper(dealerMasters);
	}

}