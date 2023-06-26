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
 * This class is a wrapper for {@link VerifiedBeneficiaries}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VerifiedBeneficiaries
 * @generated
 */
public class VerifiedBeneficiariesWrapper
	extends BaseModelWrapper<VerifiedBeneficiaries>
	implements ModelWrapper<VerifiedBeneficiaries>, VerifiedBeneficiaries {

	public VerifiedBeneficiariesWrapper(
		VerifiedBeneficiaries verifiedBeneficiaries) {

		super(verifiedBeneficiaries);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("bsbVerified", getBsbVerified());
		attributes.put("cardNo", getCardNo());
		attributes.put("createdAt", getCreatedAt());
		attributes.put("dateOfBirth", getDateOfBirth());
		attributes.put("dealerId", getDealerId());
		attributes.put("districtId", getDistrictId());
		attributes.put("divisionId", getDivisionId());
		attributes.put("ecBeneficiaryName", getEcBeneficiaryName());
		attributes.put("ecBeneficiaryNameEn", getEcBeneficiaryNameEn());
		attributes.put("ecBloodGroup", getEcBloodGroup());
		attributes.put("ecFatherName", getEcFatherName());
		attributes.put("ecGender", getEcGender());
		attributes.put("ecMobileNo", getEcMobileNo());
		attributes.put("ecMotherName", getEcMotherName());
		attributes.put("ecOccupation", getEcOccupation());
		attributes.put(
			"ecPmAdditionalMouzaMoholla", getEcPmAdditionalMouzaMoholla());
		attributes.put(
			"ecPmAdditionalVillageRoad", getEcPmAdditionalVillageRoad());
		attributes.put("ecPmDistrict", getEcPmDistrict());
		attributes.put("ecPmDivision", getEcPmDivision());
		attributes.put("ecPmHomeHoldingNo", getEcPmHomeHoldingNo());
		attributes.put("ecPmMouzaMoholla", getEcPmMouzaMoholla());
		attributes.put("ecPmPostalCode", getEcPmPostalCode());
		attributes.put("ecPmPostOffice", getEcPmPostOffice());
		attributes.put("ecPmRegion", getEcPmRegion());
		attributes.put("ecPmRmo", getEcPmRmo());
		attributes.put("ecPmUnionWard", getEcPmUnionWard());
		attributes.put("ecPmUpazila", getEcPmUpazila());
		attributes.put("ecPmVillageRoad", getEcPmVillageRoad());
		attributes.put("ecPmWardUnionPorishod", getEcPmWardUnionPorishod());
		attributes.put(
			"ecPrAdditionalMouzaMoholla", getEcPrAdditionalMouzaMoholla());
		attributes.put(
			"ecPrAdditionalVillageRoad", getEcPrAdditionalVillageRoad());
		attributes.put(
			"ecPrCityCorpMunicipality", getEcPrCityCorpMunicipality());
		attributes.put("ecPrDistrict", getEcPrDistrict());
		attributes.put("ecPrDivision", getEcPrDivision());
		attributes.put("ecPrHomeHoldingNo", getEcPrHomeHoldingNo());
		attributes.put("ecPrMouzaMoholla", getEcPrMouzaMoholla());
		attributes.put("ecPrPostalCode", getEcPrPostalCode());
		attributes.put("ecPrPostOffice", getEcPrPostOffice());
		attributes.put("ecPrRegion", getEcPrRegion());
		attributes.put("ecPrRmo", getEcPrRmo());
		attributes.put("ecPrUnionWard", getEcPrUnionWard());
		attributes.put("ecPrUpazila", getEcPrUpazila());
		attributes.put("ecPrVillageRoad", getEcPrVillageRoad());
		attributes.put("ecPrWardUnionPorishod", getEcPrWardUnionPorishod());
		attributes.put("ecSpouseName", getEcSpouseName());
		attributes.put("ecVerified", getEcVerified());
		attributes.put("finalStatus", getFinalStatus());
		attributes.put("givenMobileNo", getGivenMobileNo());
		attributes.put("imagePathEc", getImagePathEc());
		attributes.put("imagePathReal", getImagePathReal());
		attributes.put("nationalId", getNationalId());
		attributes.put("newCardNumber", getNewCardNumber());
		attributes.put("rawDataId", getRawDataId());
		attributes.put("remarks", getRemarks());
		attributes.put("secondNationalId", getSecondNationalId());
		attributes.put("status", getStatus());
		attributes.put("ucfVerifiedDate", getUcfVerifiedDate());
		attributes.put("unionId", getUnionId());
		attributes.put("upazilaId", getUpazilaId());
		attributes.put("updatedAt", getUpdatedAt());
		attributes.put("verifiedBy", getVerifiedBy());
		attributes.put("verifiedDate", getVerifiedDate());
		attributes.put("vgdStatus", getVgdStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Integer bsbVerified = (Integer)attributes.get("bsbVerified");

		if (bsbVerified != null) {
			setBsbVerified(bsbVerified);
		}

		Long cardNo = (Long)attributes.get("cardNo");

		if (cardNo != null) {
			setCardNo(cardNo);
		}

		Date createdAt = (Date)attributes.get("createdAt");

		if (createdAt != null) {
			setCreatedAt(createdAt);
		}

		String dateOfBirth = (String)attributes.get("dateOfBirth");

		if (dateOfBirth != null) {
			setDateOfBirth(dateOfBirth);
		}

		Long dealerId = (Long)attributes.get("dealerId");

		if (dealerId != null) {
			setDealerId(dealerId);
		}

		Long districtId = (Long)attributes.get("districtId");

		if (districtId != null) {
			setDistrictId(districtId);
		}

		Long divisionId = (Long)attributes.get("divisionId");

		if (divisionId != null) {
			setDivisionId(divisionId);
		}

		String ecBeneficiaryName = (String)attributes.get("ecBeneficiaryName");

		if (ecBeneficiaryName != null) {
			setEcBeneficiaryName(ecBeneficiaryName);
		}

		String ecBeneficiaryNameEn = (String)attributes.get(
			"ecBeneficiaryNameEn");

		if (ecBeneficiaryNameEn != null) {
			setEcBeneficiaryNameEn(ecBeneficiaryNameEn);
		}

		String ecBloodGroup = (String)attributes.get("ecBloodGroup");

		if (ecBloodGroup != null) {
			setEcBloodGroup(ecBloodGroup);
		}

		String ecFatherName = (String)attributes.get("ecFatherName");

		if (ecFatherName != null) {
			setEcFatherName(ecFatherName);
		}

		String ecGender = (String)attributes.get("ecGender");

		if (ecGender != null) {
			setEcGender(ecGender);
		}

		String ecMobileNo = (String)attributes.get("ecMobileNo");

		if (ecMobileNo != null) {
			setEcMobileNo(ecMobileNo);
		}

		String ecMotherName = (String)attributes.get("ecMotherName");

		if (ecMotherName != null) {
			setEcMotherName(ecMotherName);
		}

		String ecOccupation = (String)attributes.get("ecOccupation");

		if (ecOccupation != null) {
			setEcOccupation(ecOccupation);
		}

		String ecPmAdditionalMouzaMoholla = (String)attributes.get(
			"ecPmAdditionalMouzaMoholla");

		if (ecPmAdditionalMouzaMoholla != null) {
			setEcPmAdditionalMouzaMoholla(ecPmAdditionalMouzaMoholla);
		}

		String ecPmAdditionalVillageRoad = (String)attributes.get(
			"ecPmAdditionalVillageRoad");

		if (ecPmAdditionalVillageRoad != null) {
			setEcPmAdditionalVillageRoad(ecPmAdditionalVillageRoad);
		}

		String ecPmDistrict = (String)attributes.get("ecPmDistrict");

		if (ecPmDistrict != null) {
			setEcPmDistrict(ecPmDistrict);
		}

		String ecPmDivision = (String)attributes.get("ecPmDivision");

		if (ecPmDivision != null) {
			setEcPmDivision(ecPmDivision);
		}

		String ecPmHomeHoldingNo = (String)attributes.get("ecPmHomeHoldingNo");

		if (ecPmHomeHoldingNo != null) {
			setEcPmHomeHoldingNo(ecPmHomeHoldingNo);
		}

		String ecPmMouzaMoholla = (String)attributes.get("ecPmMouzaMoholla");

		if (ecPmMouzaMoholla != null) {
			setEcPmMouzaMoholla(ecPmMouzaMoholla);
		}

		String ecPmPostalCode = (String)attributes.get("ecPmPostalCode");

		if (ecPmPostalCode != null) {
			setEcPmPostalCode(ecPmPostalCode);
		}

		String ecPmPostOffice = (String)attributes.get("ecPmPostOffice");

		if (ecPmPostOffice != null) {
			setEcPmPostOffice(ecPmPostOffice);
		}

		String ecPmRegion = (String)attributes.get("ecPmRegion");

		if (ecPmRegion != null) {
			setEcPmRegion(ecPmRegion);
		}

		String ecPmRmo = (String)attributes.get("ecPmRmo");

		if (ecPmRmo != null) {
			setEcPmRmo(ecPmRmo);
		}

		String ecPmUnionWard = (String)attributes.get("ecPmUnionWard");

		if (ecPmUnionWard != null) {
			setEcPmUnionWard(ecPmUnionWard);
		}

		String ecPmUpazila = (String)attributes.get("ecPmUpazila");

		if (ecPmUpazila != null) {
			setEcPmUpazila(ecPmUpazila);
		}

		String ecPmVillageRoad = (String)attributes.get("ecPmVillageRoad");

		if (ecPmVillageRoad != null) {
			setEcPmVillageRoad(ecPmVillageRoad);
		}

		String ecPmWardUnionPorishod = (String)attributes.get(
			"ecPmWardUnionPorishod");

		if (ecPmWardUnionPorishod != null) {
			setEcPmWardUnionPorishod(ecPmWardUnionPorishod);
		}

		String ecPrAdditionalMouzaMoholla = (String)attributes.get(
			"ecPrAdditionalMouzaMoholla");

		if (ecPrAdditionalMouzaMoholla != null) {
			setEcPrAdditionalMouzaMoholla(ecPrAdditionalMouzaMoholla);
		}

		String ecPrAdditionalVillageRoad = (String)attributes.get(
			"ecPrAdditionalVillageRoad");

		if (ecPrAdditionalVillageRoad != null) {
			setEcPrAdditionalVillageRoad(ecPrAdditionalVillageRoad);
		}

		String ecPrCityCorpMunicipality = (String)attributes.get(
			"ecPrCityCorpMunicipality");

		if (ecPrCityCorpMunicipality != null) {
			setEcPrCityCorpMunicipality(ecPrCityCorpMunicipality);
		}

		String ecPrDistrict = (String)attributes.get("ecPrDistrict");

		if (ecPrDistrict != null) {
			setEcPrDistrict(ecPrDistrict);
		}

		String ecPrDivision = (String)attributes.get("ecPrDivision");

		if (ecPrDivision != null) {
			setEcPrDivision(ecPrDivision);
		}

		String ecPrHomeHoldingNo = (String)attributes.get("ecPrHomeHoldingNo");

		if (ecPrHomeHoldingNo != null) {
			setEcPrHomeHoldingNo(ecPrHomeHoldingNo);
		}

		String ecPrMouzaMoholla = (String)attributes.get("ecPrMouzaMoholla");

		if (ecPrMouzaMoholla != null) {
			setEcPrMouzaMoholla(ecPrMouzaMoholla);
		}

		String ecPrPostalCode = (String)attributes.get("ecPrPostalCode");

		if (ecPrPostalCode != null) {
			setEcPrPostalCode(ecPrPostalCode);
		}

		String ecPrPostOffice = (String)attributes.get("ecPrPostOffice");

		if (ecPrPostOffice != null) {
			setEcPrPostOffice(ecPrPostOffice);
		}

		String ecPrRegion = (String)attributes.get("ecPrRegion");

		if (ecPrRegion != null) {
			setEcPrRegion(ecPrRegion);
		}

		String ecPrRmo = (String)attributes.get("ecPrRmo");

		if (ecPrRmo != null) {
			setEcPrRmo(ecPrRmo);
		}

		String ecPrUnionWard = (String)attributes.get("ecPrUnionWard");

		if (ecPrUnionWard != null) {
			setEcPrUnionWard(ecPrUnionWard);
		}

		String ecPrUpazila = (String)attributes.get("ecPrUpazila");

		if (ecPrUpazila != null) {
			setEcPrUpazila(ecPrUpazila);
		}

		String ecPrVillageRoad = (String)attributes.get("ecPrVillageRoad");

		if (ecPrVillageRoad != null) {
			setEcPrVillageRoad(ecPrVillageRoad);
		}

		String ecPrWardUnionPorishod = (String)attributes.get(
			"ecPrWardUnionPorishod");

		if (ecPrWardUnionPorishod != null) {
			setEcPrWardUnionPorishod(ecPrWardUnionPorishod);
		}

		String ecSpouseName = (String)attributes.get("ecSpouseName");

		if (ecSpouseName != null) {
			setEcSpouseName(ecSpouseName);
		}

		Integer ecVerified = (Integer)attributes.get("ecVerified");

		if (ecVerified != null) {
			setEcVerified(ecVerified);
		}

		Long finalStatus = (Long)attributes.get("finalStatus");

		if (finalStatus != null) {
			setFinalStatus(finalStatus);
		}

		String givenMobileNo = (String)attributes.get("givenMobileNo");

		if (givenMobileNo != null) {
			setGivenMobileNo(givenMobileNo);
		}

		String imagePathEc = (String)attributes.get("imagePathEc");

		if (imagePathEc != null) {
			setImagePathEc(imagePathEc);
		}

		String imagePathReal = (String)attributes.get("imagePathReal");

		if (imagePathReal != null) {
			setImagePathReal(imagePathReal);
		}

		String nationalId = (String)attributes.get("nationalId");

		if (nationalId != null) {
			setNationalId(nationalId);
		}

		Long newCardNumber = (Long)attributes.get("newCardNumber");

		if (newCardNumber != null) {
			setNewCardNumber(newCardNumber);
		}

		Long rawDataId = (Long)attributes.get("rawDataId");

		if (rawDataId != null) {
			setRawDataId(rawDataId);
		}

		String remarks = (String)attributes.get("remarks");

		if (remarks != null) {
			setRemarks(remarks);
		}

		String secondNationalId = (String)attributes.get("secondNationalId");

		if (secondNationalId != null) {
			setSecondNationalId(secondNationalId);
		}

		Long status = (Long)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date ucfVerifiedDate = (Date)attributes.get("ucfVerifiedDate");

		if (ucfVerifiedDate != null) {
			setUcfVerifiedDate(ucfVerifiedDate);
		}

		Long unionId = (Long)attributes.get("unionId");

		if (unionId != null) {
			setUnionId(unionId);
		}

		Long upazilaId = (Long)attributes.get("upazilaId");

		if (upazilaId != null) {
			setUpazilaId(upazilaId);
		}

		Date updatedAt = (Date)attributes.get("updatedAt");

		if (updatedAt != null) {
			setUpdatedAt(updatedAt);
		}

		Long verifiedBy = (Long)attributes.get("verifiedBy");

		if (verifiedBy != null) {
			setVerifiedBy(verifiedBy);
		}

		Date verifiedDate = (Date)attributes.get("verifiedDate");

		if (verifiedDate != null) {
			setVerifiedDate(verifiedDate);
		}

		Integer vgdStatus = (Integer)attributes.get("vgdStatus");

		if (vgdStatus != null) {
			setVgdStatus(vgdStatus);
		}
	}

	@Override
	public VerifiedBeneficiaries cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the bsb verified of this verified beneficiaries.
	 *
	 * @return the bsb verified of this verified beneficiaries
	 */
	@Override
	public int getBsbVerified() {
		return model.getBsbVerified();
	}

	/**
	 * Returns the card no of this verified beneficiaries.
	 *
	 * @return the card no of this verified beneficiaries
	 */
	@Override
	public long getCardNo() {
		return model.getCardNo();
	}

	/**
	 * Returns the created at of this verified beneficiaries.
	 *
	 * @return the created at of this verified beneficiaries
	 */
	@Override
	public Date getCreatedAt() {
		return model.getCreatedAt();
	}

	/**
	 * Returns the date of birth of this verified beneficiaries.
	 *
	 * @return the date of birth of this verified beneficiaries
	 */
	@Override
	public String getDateOfBirth() {
		return model.getDateOfBirth();
	}

	/**
	 * Returns the dealer ID of this verified beneficiaries.
	 *
	 * @return the dealer ID of this verified beneficiaries
	 */
	@Override
	public long getDealerId() {
		return model.getDealerId();
	}

	/**
	 * Returns the district ID of this verified beneficiaries.
	 *
	 * @return the district ID of this verified beneficiaries
	 */
	@Override
	public long getDistrictId() {
		return model.getDistrictId();
	}

	/**
	 * Returns the division ID of this verified beneficiaries.
	 *
	 * @return the division ID of this verified beneficiaries
	 */
	@Override
	public long getDivisionId() {
		return model.getDivisionId();
	}

	/**
	 * Returns the ec beneficiary name of this verified beneficiaries.
	 *
	 * @return the ec beneficiary name of this verified beneficiaries
	 */
	@Override
	public String getEcBeneficiaryName() {
		return model.getEcBeneficiaryName();
	}

	/**
	 * Returns the ec beneficiary name en of this verified beneficiaries.
	 *
	 * @return the ec beneficiary name en of this verified beneficiaries
	 */
	@Override
	public String getEcBeneficiaryNameEn() {
		return model.getEcBeneficiaryNameEn();
	}

	/**
	 * Returns the ec blood group of this verified beneficiaries.
	 *
	 * @return the ec blood group of this verified beneficiaries
	 */
	@Override
	public String getEcBloodGroup() {
		return model.getEcBloodGroup();
	}

	/**
	 * Returns the ec father name of this verified beneficiaries.
	 *
	 * @return the ec father name of this verified beneficiaries
	 */
	@Override
	public String getEcFatherName() {
		return model.getEcFatherName();
	}

	/**
	 * Returns the ec gender of this verified beneficiaries.
	 *
	 * @return the ec gender of this verified beneficiaries
	 */
	@Override
	public String getEcGender() {
		return model.getEcGender();
	}

	/**
	 * Returns the ec mobile no of this verified beneficiaries.
	 *
	 * @return the ec mobile no of this verified beneficiaries
	 */
	@Override
	public String getEcMobileNo() {
		return model.getEcMobileNo();
	}

	/**
	 * Returns the ec mother name of this verified beneficiaries.
	 *
	 * @return the ec mother name of this verified beneficiaries
	 */
	@Override
	public String getEcMotherName() {
		return model.getEcMotherName();
	}

	/**
	 * Returns the ec occupation of this verified beneficiaries.
	 *
	 * @return the ec occupation of this verified beneficiaries
	 */
	@Override
	public String getEcOccupation() {
		return model.getEcOccupation();
	}

	/**
	 * Returns the ec pm additional mouza moholla of this verified beneficiaries.
	 *
	 * @return the ec pm additional mouza moholla of this verified beneficiaries
	 */
	@Override
	public String getEcPmAdditionalMouzaMoholla() {
		return model.getEcPmAdditionalMouzaMoholla();
	}

	/**
	 * Returns the ec pm additional village road of this verified beneficiaries.
	 *
	 * @return the ec pm additional village road of this verified beneficiaries
	 */
	@Override
	public String getEcPmAdditionalVillageRoad() {
		return model.getEcPmAdditionalVillageRoad();
	}

	/**
	 * Returns the ec pm district of this verified beneficiaries.
	 *
	 * @return the ec pm district of this verified beneficiaries
	 */
	@Override
	public String getEcPmDistrict() {
		return model.getEcPmDistrict();
	}

	/**
	 * Returns the ec pm division of this verified beneficiaries.
	 *
	 * @return the ec pm division of this verified beneficiaries
	 */
	@Override
	public String getEcPmDivision() {
		return model.getEcPmDivision();
	}

	/**
	 * Returns the ec pm home holding no of this verified beneficiaries.
	 *
	 * @return the ec pm home holding no of this verified beneficiaries
	 */
	@Override
	public String getEcPmHomeHoldingNo() {
		return model.getEcPmHomeHoldingNo();
	}

	/**
	 * Returns the ec pm mouza moholla of this verified beneficiaries.
	 *
	 * @return the ec pm mouza moholla of this verified beneficiaries
	 */
	@Override
	public String getEcPmMouzaMoholla() {
		return model.getEcPmMouzaMoholla();
	}

	/**
	 * Returns the ec pm postal code of this verified beneficiaries.
	 *
	 * @return the ec pm postal code of this verified beneficiaries
	 */
	@Override
	public String getEcPmPostalCode() {
		return model.getEcPmPostalCode();
	}

	/**
	 * Returns the ec pm post office of this verified beneficiaries.
	 *
	 * @return the ec pm post office of this verified beneficiaries
	 */
	@Override
	public String getEcPmPostOffice() {
		return model.getEcPmPostOffice();
	}

	/**
	 * Returns the ec pm region of this verified beneficiaries.
	 *
	 * @return the ec pm region of this verified beneficiaries
	 */
	@Override
	public String getEcPmRegion() {
		return model.getEcPmRegion();
	}

	/**
	 * Returns the ec pm rmo of this verified beneficiaries.
	 *
	 * @return the ec pm rmo of this verified beneficiaries
	 */
	@Override
	public String getEcPmRmo() {
		return model.getEcPmRmo();
	}

	/**
	 * Returns the ec pm union ward of this verified beneficiaries.
	 *
	 * @return the ec pm union ward of this verified beneficiaries
	 */
	@Override
	public String getEcPmUnionWard() {
		return model.getEcPmUnionWard();
	}

	/**
	 * Returns the ec pm upazila of this verified beneficiaries.
	 *
	 * @return the ec pm upazila of this verified beneficiaries
	 */
	@Override
	public String getEcPmUpazila() {
		return model.getEcPmUpazila();
	}

	/**
	 * Returns the ec pm village road of this verified beneficiaries.
	 *
	 * @return the ec pm village road of this verified beneficiaries
	 */
	@Override
	public String getEcPmVillageRoad() {
		return model.getEcPmVillageRoad();
	}

	/**
	 * Returns the ec pm ward union porishod of this verified beneficiaries.
	 *
	 * @return the ec pm ward union porishod of this verified beneficiaries
	 */
	@Override
	public String getEcPmWardUnionPorishod() {
		return model.getEcPmWardUnionPorishod();
	}

	/**
	 * Returns the ec pr additional mouza moholla of this verified beneficiaries.
	 *
	 * @return the ec pr additional mouza moholla of this verified beneficiaries
	 */
	@Override
	public String getEcPrAdditionalMouzaMoholla() {
		return model.getEcPrAdditionalMouzaMoholla();
	}

	/**
	 * Returns the ec pr additional village road of this verified beneficiaries.
	 *
	 * @return the ec pr additional village road of this verified beneficiaries
	 */
	@Override
	public String getEcPrAdditionalVillageRoad() {
		return model.getEcPrAdditionalVillageRoad();
	}

	/**
	 * Returns the ec pr city corp municipality of this verified beneficiaries.
	 *
	 * @return the ec pr city corp municipality of this verified beneficiaries
	 */
	@Override
	public String getEcPrCityCorpMunicipality() {
		return model.getEcPrCityCorpMunicipality();
	}

	/**
	 * Returns the ec pr district of this verified beneficiaries.
	 *
	 * @return the ec pr district of this verified beneficiaries
	 */
	@Override
	public String getEcPrDistrict() {
		return model.getEcPrDistrict();
	}

	/**
	 * Returns the ec pr division of this verified beneficiaries.
	 *
	 * @return the ec pr division of this verified beneficiaries
	 */
	@Override
	public String getEcPrDivision() {
		return model.getEcPrDivision();
	}

	/**
	 * Returns the ec pr home holding no of this verified beneficiaries.
	 *
	 * @return the ec pr home holding no of this verified beneficiaries
	 */
	@Override
	public String getEcPrHomeHoldingNo() {
		return model.getEcPrHomeHoldingNo();
	}

	/**
	 * Returns the ec pr mouza moholla of this verified beneficiaries.
	 *
	 * @return the ec pr mouza moholla of this verified beneficiaries
	 */
	@Override
	public String getEcPrMouzaMoholla() {
		return model.getEcPrMouzaMoholla();
	}

	/**
	 * Returns the ec pr postal code of this verified beneficiaries.
	 *
	 * @return the ec pr postal code of this verified beneficiaries
	 */
	@Override
	public String getEcPrPostalCode() {
		return model.getEcPrPostalCode();
	}

	/**
	 * Returns the ec pr post office of this verified beneficiaries.
	 *
	 * @return the ec pr post office of this verified beneficiaries
	 */
	@Override
	public String getEcPrPostOffice() {
		return model.getEcPrPostOffice();
	}

	/**
	 * Returns the ec pr region of this verified beneficiaries.
	 *
	 * @return the ec pr region of this verified beneficiaries
	 */
	@Override
	public String getEcPrRegion() {
		return model.getEcPrRegion();
	}

	/**
	 * Returns the ec pr rmo of this verified beneficiaries.
	 *
	 * @return the ec pr rmo of this verified beneficiaries
	 */
	@Override
	public String getEcPrRmo() {
		return model.getEcPrRmo();
	}

	/**
	 * Returns the ec pr union ward of this verified beneficiaries.
	 *
	 * @return the ec pr union ward of this verified beneficiaries
	 */
	@Override
	public String getEcPrUnionWard() {
		return model.getEcPrUnionWard();
	}

	/**
	 * Returns the ec pr upazila of this verified beneficiaries.
	 *
	 * @return the ec pr upazila of this verified beneficiaries
	 */
	@Override
	public String getEcPrUpazila() {
		return model.getEcPrUpazila();
	}

	/**
	 * Returns the ec pr village road of this verified beneficiaries.
	 *
	 * @return the ec pr village road of this verified beneficiaries
	 */
	@Override
	public String getEcPrVillageRoad() {
		return model.getEcPrVillageRoad();
	}

	/**
	 * Returns the ec pr ward union porishod of this verified beneficiaries.
	 *
	 * @return the ec pr ward union porishod of this verified beneficiaries
	 */
	@Override
	public String getEcPrWardUnionPorishod() {
		return model.getEcPrWardUnionPorishod();
	}

	/**
	 * Returns the ec spouse name of this verified beneficiaries.
	 *
	 * @return the ec spouse name of this verified beneficiaries
	 */
	@Override
	public String getEcSpouseName() {
		return model.getEcSpouseName();
	}

	/**
	 * Returns the ec verified of this verified beneficiaries.
	 *
	 * @return the ec verified of this verified beneficiaries
	 */
	@Override
	public int getEcVerified() {
		return model.getEcVerified();
	}

	/**
	 * Returns the final status of this verified beneficiaries.
	 *
	 * @return the final status of this verified beneficiaries
	 */
	@Override
	public long getFinalStatus() {
		return model.getFinalStatus();
	}

	/**
	 * Returns the given mobile no of this verified beneficiaries.
	 *
	 * @return the given mobile no of this verified beneficiaries
	 */
	@Override
	public String getGivenMobileNo() {
		return model.getGivenMobileNo();
	}

	/**
	 * Returns the ID of this verified beneficiaries.
	 *
	 * @return the ID of this verified beneficiaries
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the image path ec of this verified beneficiaries.
	 *
	 * @return the image path ec of this verified beneficiaries
	 */
	@Override
	public String getImagePathEc() {
		return model.getImagePathEc();
	}

	/**
	 * Returns the image path real of this verified beneficiaries.
	 *
	 * @return the image path real of this verified beneficiaries
	 */
	@Override
	public String getImagePathReal() {
		return model.getImagePathReal();
	}

	/**
	 * Returns the national ID of this verified beneficiaries.
	 *
	 * @return the national ID of this verified beneficiaries
	 */
	@Override
	public String getNationalId() {
		return model.getNationalId();
	}

	/**
	 * Returns the new card number of this verified beneficiaries.
	 *
	 * @return the new card number of this verified beneficiaries
	 */
	@Override
	public long getNewCardNumber() {
		return model.getNewCardNumber();
	}

	/**
	 * Returns the primary key of this verified beneficiaries.
	 *
	 * @return the primary key of this verified beneficiaries
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the raw data ID of this verified beneficiaries.
	 *
	 * @return the raw data ID of this verified beneficiaries
	 */
	@Override
	public long getRawDataId() {
		return model.getRawDataId();
	}

	/**
	 * Returns the remarks of this verified beneficiaries.
	 *
	 * @return the remarks of this verified beneficiaries
	 */
	@Override
	public String getRemarks() {
		return model.getRemarks();
	}

	/**
	 * Returns the second national ID of this verified beneficiaries.
	 *
	 * @return the second national ID of this verified beneficiaries
	 */
	@Override
	public String getSecondNationalId() {
		return model.getSecondNationalId();
	}

	/**
	 * Returns the status of this verified beneficiaries.
	 *
	 * @return the status of this verified beneficiaries
	 */
	@Override
	public long getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the ucf verified date of this verified beneficiaries.
	 *
	 * @return the ucf verified date of this verified beneficiaries
	 */
	@Override
	public Date getUcfVerifiedDate() {
		return model.getUcfVerifiedDate();
	}

	/**
	 * Returns the union ID of this verified beneficiaries.
	 *
	 * @return the union ID of this verified beneficiaries
	 */
	@Override
	public long getUnionId() {
		return model.getUnionId();
	}

	/**
	 * Returns the upazila ID of this verified beneficiaries.
	 *
	 * @return the upazila ID of this verified beneficiaries
	 */
	@Override
	public long getUpazilaId() {
		return model.getUpazilaId();
	}

	/**
	 * Returns the updated at of this verified beneficiaries.
	 *
	 * @return the updated at of this verified beneficiaries
	 */
	@Override
	public Date getUpdatedAt() {
		return model.getUpdatedAt();
	}

	/**
	 * Returns the verified by of this verified beneficiaries.
	 *
	 * @return the verified by of this verified beneficiaries
	 */
	@Override
	public long getVerifiedBy() {
		return model.getVerifiedBy();
	}

	/**
	 * Returns the verified date of this verified beneficiaries.
	 *
	 * @return the verified date of this verified beneficiaries
	 */
	@Override
	public Date getVerifiedDate() {
		return model.getVerifiedDate();
	}

	/**
	 * Returns the vgd status of this verified beneficiaries.
	 *
	 * @return the vgd status of this verified beneficiaries
	 */
	@Override
	public int getVgdStatus() {
		return model.getVgdStatus();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the bsb verified of this verified beneficiaries.
	 *
	 * @param bsbVerified the bsb verified of this verified beneficiaries
	 */
	@Override
	public void setBsbVerified(int bsbVerified) {
		model.setBsbVerified(bsbVerified);
	}

	/**
	 * Sets the card no of this verified beneficiaries.
	 *
	 * @param cardNo the card no of this verified beneficiaries
	 */
	@Override
	public void setCardNo(long cardNo) {
		model.setCardNo(cardNo);
	}

	/**
	 * Sets the created at of this verified beneficiaries.
	 *
	 * @param createdAt the created at of this verified beneficiaries
	 */
	@Override
	public void setCreatedAt(Date createdAt) {
		model.setCreatedAt(createdAt);
	}

	/**
	 * Sets the date of birth of this verified beneficiaries.
	 *
	 * @param dateOfBirth the date of birth of this verified beneficiaries
	 */
	@Override
	public void setDateOfBirth(String dateOfBirth) {
		model.setDateOfBirth(dateOfBirth);
	}

	/**
	 * Sets the dealer ID of this verified beneficiaries.
	 *
	 * @param dealerId the dealer ID of this verified beneficiaries
	 */
	@Override
	public void setDealerId(long dealerId) {
		model.setDealerId(dealerId);
	}

	/**
	 * Sets the district ID of this verified beneficiaries.
	 *
	 * @param districtId the district ID of this verified beneficiaries
	 */
	@Override
	public void setDistrictId(long districtId) {
		model.setDistrictId(districtId);
	}

	/**
	 * Sets the division ID of this verified beneficiaries.
	 *
	 * @param divisionId the division ID of this verified beneficiaries
	 */
	@Override
	public void setDivisionId(long divisionId) {
		model.setDivisionId(divisionId);
	}

	/**
	 * Sets the ec beneficiary name of this verified beneficiaries.
	 *
	 * @param ecBeneficiaryName the ec beneficiary name of this verified beneficiaries
	 */
	@Override
	public void setEcBeneficiaryName(String ecBeneficiaryName) {
		model.setEcBeneficiaryName(ecBeneficiaryName);
	}

	/**
	 * Sets the ec beneficiary name en of this verified beneficiaries.
	 *
	 * @param ecBeneficiaryNameEn the ec beneficiary name en of this verified beneficiaries
	 */
	@Override
	public void setEcBeneficiaryNameEn(String ecBeneficiaryNameEn) {
		model.setEcBeneficiaryNameEn(ecBeneficiaryNameEn);
	}

	/**
	 * Sets the ec blood group of this verified beneficiaries.
	 *
	 * @param ecBloodGroup the ec blood group of this verified beneficiaries
	 */
	@Override
	public void setEcBloodGroup(String ecBloodGroup) {
		model.setEcBloodGroup(ecBloodGroup);
	}

	/**
	 * Sets the ec father name of this verified beneficiaries.
	 *
	 * @param ecFatherName the ec father name of this verified beneficiaries
	 */
	@Override
	public void setEcFatherName(String ecFatherName) {
		model.setEcFatherName(ecFatherName);
	}

	/**
	 * Sets the ec gender of this verified beneficiaries.
	 *
	 * @param ecGender the ec gender of this verified beneficiaries
	 */
	@Override
	public void setEcGender(String ecGender) {
		model.setEcGender(ecGender);
	}

	/**
	 * Sets the ec mobile no of this verified beneficiaries.
	 *
	 * @param ecMobileNo the ec mobile no of this verified beneficiaries
	 */
	@Override
	public void setEcMobileNo(String ecMobileNo) {
		model.setEcMobileNo(ecMobileNo);
	}

	/**
	 * Sets the ec mother name of this verified beneficiaries.
	 *
	 * @param ecMotherName the ec mother name of this verified beneficiaries
	 */
	@Override
	public void setEcMotherName(String ecMotherName) {
		model.setEcMotherName(ecMotherName);
	}

	/**
	 * Sets the ec occupation of this verified beneficiaries.
	 *
	 * @param ecOccupation the ec occupation of this verified beneficiaries
	 */
	@Override
	public void setEcOccupation(String ecOccupation) {
		model.setEcOccupation(ecOccupation);
	}

	/**
	 * Sets the ec pm additional mouza moholla of this verified beneficiaries.
	 *
	 * @param ecPmAdditionalMouzaMoholla the ec pm additional mouza moholla of this verified beneficiaries
	 */
	@Override
	public void setEcPmAdditionalMouzaMoholla(
		String ecPmAdditionalMouzaMoholla) {

		model.setEcPmAdditionalMouzaMoholla(ecPmAdditionalMouzaMoholla);
	}

	/**
	 * Sets the ec pm additional village road of this verified beneficiaries.
	 *
	 * @param ecPmAdditionalVillageRoad the ec pm additional village road of this verified beneficiaries
	 */
	@Override
	public void setEcPmAdditionalVillageRoad(String ecPmAdditionalVillageRoad) {
		model.setEcPmAdditionalVillageRoad(ecPmAdditionalVillageRoad);
	}

	/**
	 * Sets the ec pm district of this verified beneficiaries.
	 *
	 * @param ecPmDistrict the ec pm district of this verified beneficiaries
	 */
	@Override
	public void setEcPmDistrict(String ecPmDistrict) {
		model.setEcPmDistrict(ecPmDistrict);
	}

	/**
	 * Sets the ec pm division of this verified beneficiaries.
	 *
	 * @param ecPmDivision the ec pm division of this verified beneficiaries
	 */
	@Override
	public void setEcPmDivision(String ecPmDivision) {
		model.setEcPmDivision(ecPmDivision);
	}

	/**
	 * Sets the ec pm home holding no of this verified beneficiaries.
	 *
	 * @param ecPmHomeHoldingNo the ec pm home holding no of this verified beneficiaries
	 */
	@Override
	public void setEcPmHomeHoldingNo(String ecPmHomeHoldingNo) {
		model.setEcPmHomeHoldingNo(ecPmHomeHoldingNo);
	}

	/**
	 * Sets the ec pm mouza moholla of this verified beneficiaries.
	 *
	 * @param ecPmMouzaMoholla the ec pm mouza moholla of this verified beneficiaries
	 */
	@Override
	public void setEcPmMouzaMoholla(String ecPmMouzaMoholla) {
		model.setEcPmMouzaMoholla(ecPmMouzaMoholla);
	}

	/**
	 * Sets the ec pm postal code of this verified beneficiaries.
	 *
	 * @param ecPmPostalCode the ec pm postal code of this verified beneficiaries
	 */
	@Override
	public void setEcPmPostalCode(String ecPmPostalCode) {
		model.setEcPmPostalCode(ecPmPostalCode);
	}

	/**
	 * Sets the ec pm post office of this verified beneficiaries.
	 *
	 * @param ecPmPostOffice the ec pm post office of this verified beneficiaries
	 */
	@Override
	public void setEcPmPostOffice(String ecPmPostOffice) {
		model.setEcPmPostOffice(ecPmPostOffice);
	}

	/**
	 * Sets the ec pm region of this verified beneficiaries.
	 *
	 * @param ecPmRegion the ec pm region of this verified beneficiaries
	 */
	@Override
	public void setEcPmRegion(String ecPmRegion) {
		model.setEcPmRegion(ecPmRegion);
	}

	/**
	 * Sets the ec pm rmo of this verified beneficiaries.
	 *
	 * @param ecPmRmo the ec pm rmo of this verified beneficiaries
	 */
	@Override
	public void setEcPmRmo(String ecPmRmo) {
		model.setEcPmRmo(ecPmRmo);
	}

	/**
	 * Sets the ec pm union ward of this verified beneficiaries.
	 *
	 * @param ecPmUnionWard the ec pm union ward of this verified beneficiaries
	 */
	@Override
	public void setEcPmUnionWard(String ecPmUnionWard) {
		model.setEcPmUnionWard(ecPmUnionWard);
	}

	/**
	 * Sets the ec pm upazila of this verified beneficiaries.
	 *
	 * @param ecPmUpazila the ec pm upazila of this verified beneficiaries
	 */
	@Override
	public void setEcPmUpazila(String ecPmUpazila) {
		model.setEcPmUpazila(ecPmUpazila);
	}

	/**
	 * Sets the ec pm village road of this verified beneficiaries.
	 *
	 * @param ecPmVillageRoad the ec pm village road of this verified beneficiaries
	 */
	@Override
	public void setEcPmVillageRoad(String ecPmVillageRoad) {
		model.setEcPmVillageRoad(ecPmVillageRoad);
	}

	/**
	 * Sets the ec pm ward union porishod of this verified beneficiaries.
	 *
	 * @param ecPmWardUnionPorishod the ec pm ward union porishod of this verified beneficiaries
	 */
	@Override
	public void setEcPmWardUnionPorishod(String ecPmWardUnionPorishod) {
		model.setEcPmWardUnionPorishod(ecPmWardUnionPorishod);
	}

	/**
	 * Sets the ec pr additional mouza moholla of this verified beneficiaries.
	 *
	 * @param ecPrAdditionalMouzaMoholla the ec pr additional mouza moholla of this verified beneficiaries
	 */
	@Override
	public void setEcPrAdditionalMouzaMoholla(
		String ecPrAdditionalMouzaMoholla) {

		model.setEcPrAdditionalMouzaMoholla(ecPrAdditionalMouzaMoholla);
	}

	/**
	 * Sets the ec pr additional village road of this verified beneficiaries.
	 *
	 * @param ecPrAdditionalVillageRoad the ec pr additional village road of this verified beneficiaries
	 */
	@Override
	public void setEcPrAdditionalVillageRoad(String ecPrAdditionalVillageRoad) {
		model.setEcPrAdditionalVillageRoad(ecPrAdditionalVillageRoad);
	}

	/**
	 * Sets the ec pr city corp municipality of this verified beneficiaries.
	 *
	 * @param ecPrCityCorpMunicipality the ec pr city corp municipality of this verified beneficiaries
	 */
	@Override
	public void setEcPrCityCorpMunicipality(String ecPrCityCorpMunicipality) {
		model.setEcPrCityCorpMunicipality(ecPrCityCorpMunicipality);
	}

	/**
	 * Sets the ec pr district of this verified beneficiaries.
	 *
	 * @param ecPrDistrict the ec pr district of this verified beneficiaries
	 */
	@Override
	public void setEcPrDistrict(String ecPrDistrict) {
		model.setEcPrDistrict(ecPrDistrict);
	}

	/**
	 * Sets the ec pr division of this verified beneficiaries.
	 *
	 * @param ecPrDivision the ec pr division of this verified beneficiaries
	 */
	@Override
	public void setEcPrDivision(String ecPrDivision) {
		model.setEcPrDivision(ecPrDivision);
	}

	/**
	 * Sets the ec pr home holding no of this verified beneficiaries.
	 *
	 * @param ecPrHomeHoldingNo the ec pr home holding no of this verified beneficiaries
	 */
	@Override
	public void setEcPrHomeHoldingNo(String ecPrHomeHoldingNo) {
		model.setEcPrHomeHoldingNo(ecPrHomeHoldingNo);
	}

	/**
	 * Sets the ec pr mouza moholla of this verified beneficiaries.
	 *
	 * @param ecPrMouzaMoholla the ec pr mouza moholla of this verified beneficiaries
	 */
	@Override
	public void setEcPrMouzaMoholla(String ecPrMouzaMoholla) {
		model.setEcPrMouzaMoholla(ecPrMouzaMoholla);
	}

	/**
	 * Sets the ec pr postal code of this verified beneficiaries.
	 *
	 * @param ecPrPostalCode the ec pr postal code of this verified beneficiaries
	 */
	@Override
	public void setEcPrPostalCode(String ecPrPostalCode) {
		model.setEcPrPostalCode(ecPrPostalCode);
	}

	/**
	 * Sets the ec pr post office of this verified beneficiaries.
	 *
	 * @param ecPrPostOffice the ec pr post office of this verified beneficiaries
	 */
	@Override
	public void setEcPrPostOffice(String ecPrPostOffice) {
		model.setEcPrPostOffice(ecPrPostOffice);
	}

	/**
	 * Sets the ec pr region of this verified beneficiaries.
	 *
	 * @param ecPrRegion the ec pr region of this verified beneficiaries
	 */
	@Override
	public void setEcPrRegion(String ecPrRegion) {
		model.setEcPrRegion(ecPrRegion);
	}

	/**
	 * Sets the ec pr rmo of this verified beneficiaries.
	 *
	 * @param ecPrRmo the ec pr rmo of this verified beneficiaries
	 */
	@Override
	public void setEcPrRmo(String ecPrRmo) {
		model.setEcPrRmo(ecPrRmo);
	}

	/**
	 * Sets the ec pr union ward of this verified beneficiaries.
	 *
	 * @param ecPrUnionWard the ec pr union ward of this verified beneficiaries
	 */
	@Override
	public void setEcPrUnionWard(String ecPrUnionWard) {
		model.setEcPrUnionWard(ecPrUnionWard);
	}

	/**
	 * Sets the ec pr upazila of this verified beneficiaries.
	 *
	 * @param ecPrUpazila the ec pr upazila of this verified beneficiaries
	 */
	@Override
	public void setEcPrUpazila(String ecPrUpazila) {
		model.setEcPrUpazila(ecPrUpazila);
	}

	/**
	 * Sets the ec pr village road of this verified beneficiaries.
	 *
	 * @param ecPrVillageRoad the ec pr village road of this verified beneficiaries
	 */
	@Override
	public void setEcPrVillageRoad(String ecPrVillageRoad) {
		model.setEcPrVillageRoad(ecPrVillageRoad);
	}

	/**
	 * Sets the ec pr ward union porishod of this verified beneficiaries.
	 *
	 * @param ecPrWardUnionPorishod the ec pr ward union porishod of this verified beneficiaries
	 */
	@Override
	public void setEcPrWardUnionPorishod(String ecPrWardUnionPorishod) {
		model.setEcPrWardUnionPorishod(ecPrWardUnionPorishod);
	}

	/**
	 * Sets the ec spouse name of this verified beneficiaries.
	 *
	 * @param ecSpouseName the ec spouse name of this verified beneficiaries
	 */
	@Override
	public void setEcSpouseName(String ecSpouseName) {
		model.setEcSpouseName(ecSpouseName);
	}

	/**
	 * Sets the ec verified of this verified beneficiaries.
	 *
	 * @param ecVerified the ec verified of this verified beneficiaries
	 */
	@Override
	public void setEcVerified(int ecVerified) {
		model.setEcVerified(ecVerified);
	}

	/**
	 * Sets the final status of this verified beneficiaries.
	 *
	 * @param finalStatus the final status of this verified beneficiaries
	 */
	@Override
	public void setFinalStatus(long finalStatus) {
		model.setFinalStatus(finalStatus);
	}

	/**
	 * Sets the given mobile no of this verified beneficiaries.
	 *
	 * @param givenMobileNo the given mobile no of this verified beneficiaries
	 */
	@Override
	public void setGivenMobileNo(String givenMobileNo) {
		model.setGivenMobileNo(givenMobileNo);
	}

	/**
	 * Sets the ID of this verified beneficiaries.
	 *
	 * @param id the ID of this verified beneficiaries
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the image path ec of this verified beneficiaries.
	 *
	 * @param imagePathEc the image path ec of this verified beneficiaries
	 */
	@Override
	public void setImagePathEc(String imagePathEc) {
		model.setImagePathEc(imagePathEc);
	}

	/**
	 * Sets the image path real of this verified beneficiaries.
	 *
	 * @param imagePathReal the image path real of this verified beneficiaries
	 */
	@Override
	public void setImagePathReal(String imagePathReal) {
		model.setImagePathReal(imagePathReal);
	}

	/**
	 * Sets the national ID of this verified beneficiaries.
	 *
	 * @param nationalId the national ID of this verified beneficiaries
	 */
	@Override
	public void setNationalId(String nationalId) {
		model.setNationalId(nationalId);
	}

	/**
	 * Sets the new card number of this verified beneficiaries.
	 *
	 * @param newCardNumber the new card number of this verified beneficiaries
	 */
	@Override
	public void setNewCardNumber(long newCardNumber) {
		model.setNewCardNumber(newCardNumber);
	}

	/**
	 * Sets the primary key of this verified beneficiaries.
	 *
	 * @param primaryKey the primary key of this verified beneficiaries
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the raw data ID of this verified beneficiaries.
	 *
	 * @param rawDataId the raw data ID of this verified beneficiaries
	 */
	@Override
	public void setRawDataId(long rawDataId) {
		model.setRawDataId(rawDataId);
	}

	/**
	 * Sets the remarks of this verified beneficiaries.
	 *
	 * @param remarks the remarks of this verified beneficiaries
	 */
	@Override
	public void setRemarks(String remarks) {
		model.setRemarks(remarks);
	}

	/**
	 * Sets the second national ID of this verified beneficiaries.
	 *
	 * @param secondNationalId the second national ID of this verified beneficiaries
	 */
	@Override
	public void setSecondNationalId(String secondNationalId) {
		model.setSecondNationalId(secondNationalId);
	}

	/**
	 * Sets the status of this verified beneficiaries.
	 *
	 * @param status the status of this verified beneficiaries
	 */
	@Override
	public void setStatus(long status) {
		model.setStatus(status);
	}

	/**
	 * Sets the ucf verified date of this verified beneficiaries.
	 *
	 * @param ucfVerifiedDate the ucf verified date of this verified beneficiaries
	 */
	@Override
	public void setUcfVerifiedDate(Date ucfVerifiedDate) {
		model.setUcfVerifiedDate(ucfVerifiedDate);
	}

	/**
	 * Sets the union ID of this verified beneficiaries.
	 *
	 * @param unionId the union ID of this verified beneficiaries
	 */
	@Override
	public void setUnionId(long unionId) {
		model.setUnionId(unionId);
	}

	/**
	 * Sets the upazila ID of this verified beneficiaries.
	 *
	 * @param upazilaId the upazila ID of this verified beneficiaries
	 */
	@Override
	public void setUpazilaId(long upazilaId) {
		model.setUpazilaId(upazilaId);
	}

	/**
	 * Sets the updated at of this verified beneficiaries.
	 *
	 * @param updatedAt the updated at of this verified beneficiaries
	 */
	@Override
	public void setUpdatedAt(Date updatedAt) {
		model.setUpdatedAt(updatedAt);
	}

	/**
	 * Sets the verified by of this verified beneficiaries.
	 *
	 * @param verifiedBy the verified by of this verified beneficiaries
	 */
	@Override
	public void setVerifiedBy(long verifiedBy) {
		model.setVerifiedBy(verifiedBy);
	}

	/**
	 * Sets the verified date of this verified beneficiaries.
	 *
	 * @param verifiedDate the verified date of this verified beneficiaries
	 */
	@Override
	public void setVerifiedDate(Date verifiedDate) {
		model.setVerifiedDate(verifiedDate);
	}

	/**
	 * Sets the vgd status of this verified beneficiaries.
	 *
	 * @param vgdStatus the vgd status of this verified beneficiaries
	 */
	@Override
	public void setVgdStatus(int vgdStatus) {
		model.setVgdStatus(vgdStatus);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected VerifiedBeneficiariesWrapper wrap(
		VerifiedBeneficiaries verifiedBeneficiaries) {

		return new VerifiedBeneficiariesWrapper(verifiedBeneficiaries);
	}

}