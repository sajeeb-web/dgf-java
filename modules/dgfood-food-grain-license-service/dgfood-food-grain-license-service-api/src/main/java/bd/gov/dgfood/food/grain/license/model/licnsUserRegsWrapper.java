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
 * This class is a wrapper for {@link licnsUserRegs}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see licnsUserRegs
 * @generated
 */
public class licnsUserRegsWrapper
	extends BaseModelWrapper<licnsUserRegs>
	implements licnsUserRegs, ModelWrapper<licnsUserRegs> {

	public licnsUserRegsWrapper(licnsUserRegs licnsUserRegs) {
		super(licnsUserRegs);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("licUserId", getLicUserId());
		attributes.put("nationalId", getNationalId());
		attributes.put("applicantName", getApplicantName());
		attributes.put("tradeLicenseNo", getTradeLicenseNo());
		attributes.put("tradeLicenseExpiryDate", getTradeLicenseExpiryDate());
		attributes.put("tradeLicenseIssuerCode", getTradeLicenseIssuerCode());
		attributes.put("tradeLicenseIssuerCity", getTradeLicenseIssuerCity());
		attributes.put(
			"businessIdentificationNo", getBusinessIdentificationNo());
		attributes.put("taxIdentificationNo", getTaxIdentificationNo());
		attributes.put("businessName", getBusinessName());
		attributes.put("businessType", getBusinessType());
		attributes.put("businessDivision", getBusinessDivision());
		attributes.put("businessDistrict", getBusinessDistrict());
		attributes.put("businessUpzilla", getBusinessUpzilla());
		attributes.put("businessUnionName", getBusinessUnionName());
		attributes.put("businessVillage", getBusinessVillage());
		attributes.put("businessWard", getBusinessWard());
		attributes.put("businessZipCode", getBusinessZipCode());
		attributes.put("businessPostOffice", getBusinessPostOffice());
		attributes.put("businessHouseAddress", getBusinessHouseAddress());
		attributes.put("photographFile", getPhotographFile());
		attributes.put("tradeLicDoc", getTradeLicDoc());
		attributes.put("binDoc", getBinDoc());
		attributes.put("tinDoc", getTinDoc());
		attributes.put("bankStat", getBankStat());
		attributes.put("otherReleventDoc", getOtherReleventDoc());
		attributes.put("comments", getComments());
		attributes.put("foodGrainLicenseType", getFoodGrainLicenseType());
		attributes.put("division", getDivision());
		attributes.put("district", getDistrict());
		attributes.put("upzilla", getUpzilla());
		attributes.put("unionName", getUnionName());
		attributes.put("village", getVillage());
		attributes.put("ward", getWard());
		attributes.put("zipCode", getZipCode());
		attributes.put("postOffice", getPostOffice());
		attributes.put("houseAddress", getHouseAddress());
		attributes.put("password", getPassword());
		attributes.put("fatherName", getFatherName());
		attributes.put("lastName", getLastName());
		attributes.put("motherName", getMotherName());
		attributes.put("gender", getGender());
		attributes.put("maritalStatus", getMaritalStatus());
		attributes.put("birthDate", getBirthDate());
		attributes.put("mobileNo", getMobileNo());
		attributes.put("userId", getUserId());
		attributes.put("email", getEmail());
		attributes.put("nidDivision", getNidDivision());
		attributes.put("nidDistrict", getNidDistrict());
		attributes.put("nidUpzilla", getNidUpzilla());
		attributes.put("nidUnion", getNidUnion());
		attributes.put("nidVillage", getNidVillage());
		attributes.put("nidWard", getNidWard());
		attributes.put("nidZipCode", getNidZipCode());
		attributes.put("nidPostOffice", getNidPostOffice());
		attributes.put("nidHouseAddress", getNidHouseAddress());
		attributes.put("isSubmit", isIsSubmit());
		attributes.put("electricExemptionMemo", getElectricExemptionMemo());
		attributes.put("envClrMemo", getEnvClrMemo());
		attributes.put("bstiClrMemo", getBstiClrMemo());
		attributes.put("fireLicNumDoc", getFireLicNumDoc());
		attributes.put("productType", getProductType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long licUserId = (Long)attributes.get("licUserId");

		if (licUserId != null) {
			setLicUserId(licUserId);
		}

		String nationalId = (String)attributes.get("nationalId");

		if (nationalId != null) {
			setNationalId(nationalId);
		}

		String applicantName = (String)attributes.get("applicantName");

		if (applicantName != null) {
			setApplicantName(applicantName);
		}

		String tradeLicenseNo = (String)attributes.get("tradeLicenseNo");

		if (tradeLicenseNo != null) {
			setTradeLicenseNo(tradeLicenseNo);
		}

		Date tradeLicenseExpiryDate = (Date)attributes.get(
			"tradeLicenseExpiryDate");

		if (tradeLicenseExpiryDate != null) {
			setTradeLicenseExpiryDate(tradeLicenseExpiryDate);
		}

		String tradeLicenseIssuerCode = (String)attributes.get(
			"tradeLicenseIssuerCode");

		if (tradeLicenseIssuerCode != null) {
			setTradeLicenseIssuerCode(tradeLicenseIssuerCode);
		}

		String tradeLicenseIssuerCity = (String)attributes.get(
			"tradeLicenseIssuerCity");

		if (tradeLicenseIssuerCity != null) {
			setTradeLicenseIssuerCity(tradeLicenseIssuerCity);
		}

		String businessIdentificationNo = (String)attributes.get(
			"businessIdentificationNo");

		if (businessIdentificationNo != null) {
			setBusinessIdentificationNo(businessIdentificationNo);
		}

		String taxIdentificationNo = (String)attributes.get(
			"taxIdentificationNo");

		if (taxIdentificationNo != null) {
			setTaxIdentificationNo(taxIdentificationNo);
		}

		String businessName = (String)attributes.get("businessName");

		if (businessName != null) {
			setBusinessName(businessName);
		}

		String businessType = (String)attributes.get("businessType");

		if (businessType != null) {
			setBusinessType(businessType);
		}

		Long businessDivision = (Long)attributes.get("businessDivision");

		if (businessDivision != null) {
			setBusinessDivision(businessDivision);
		}

		Long businessDistrict = (Long)attributes.get("businessDistrict");

		if (businessDistrict != null) {
			setBusinessDistrict(businessDistrict);
		}

		Long businessUpzilla = (Long)attributes.get("businessUpzilla");

		if (businessUpzilla != null) {
			setBusinessUpzilla(businessUpzilla);
		}

		Long businessUnionName = (Long)attributes.get("businessUnionName");

		if (businessUnionName != null) {
			setBusinessUnionName(businessUnionName);
		}

		String businessVillage = (String)attributes.get("businessVillage");

		if (businessVillage != null) {
			setBusinessVillage(businessVillage);
		}

		String businessWard = (String)attributes.get("businessWard");

		if (businessWard != null) {
			setBusinessWard(businessWard);
		}

		String businessZipCode = (String)attributes.get("businessZipCode");

		if (businessZipCode != null) {
			setBusinessZipCode(businessZipCode);
		}

		String businessPostOffice = (String)attributes.get(
			"businessPostOffice");

		if (businessPostOffice != null) {
			setBusinessPostOffice(businessPostOffice);
		}

		String businessHouseAddress = (String)attributes.get(
			"businessHouseAddress");

		if (businessHouseAddress != null) {
			setBusinessHouseAddress(businessHouseAddress);
		}

		String photographFile = (String)attributes.get("photographFile");

		if (photographFile != null) {
			setPhotographFile(photographFile);
		}

		String tradeLicDoc = (String)attributes.get("tradeLicDoc");

		if (tradeLicDoc != null) {
			setTradeLicDoc(tradeLicDoc);
		}

		String binDoc = (String)attributes.get("binDoc");

		if (binDoc != null) {
			setBinDoc(binDoc);
		}

		String tinDoc = (String)attributes.get("tinDoc");

		if (tinDoc != null) {
			setTinDoc(tinDoc);
		}

		String bankStat = (String)attributes.get("bankStat");

		if (bankStat != null) {
			setBankStat(bankStat);
		}

		String otherReleventDoc = (String)attributes.get("otherReleventDoc");

		if (otherReleventDoc != null) {
			setOtherReleventDoc(otherReleventDoc);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		String foodGrainLicenseType = (String)attributes.get(
			"foodGrainLicenseType");

		if (foodGrainLicenseType != null) {
			setFoodGrainLicenseType(foodGrainLicenseType);
		}

		Long division = (Long)attributes.get("division");

		if (division != null) {
			setDivision(division);
		}

		Long district = (Long)attributes.get("district");

		if (district != null) {
			setDistrict(district);
		}

		Long upzilla = (Long)attributes.get("upzilla");

		if (upzilla != null) {
			setUpzilla(upzilla);
		}

		Long unionName = (Long)attributes.get("unionName");

		if (unionName != null) {
			setUnionName(unionName);
		}

		String village = (String)attributes.get("village");

		if (village != null) {
			setVillage(village);
		}

		String ward = (String)attributes.get("ward");

		if (ward != null) {
			setWard(ward);
		}

		String zipCode = (String)attributes.get("zipCode");

		if (zipCode != null) {
			setZipCode(zipCode);
		}

		String postOffice = (String)attributes.get("postOffice");

		if (postOffice != null) {
			setPostOffice(postOffice);
		}

		String houseAddress = (String)attributes.get("houseAddress");

		if (houseAddress != null) {
			setHouseAddress(houseAddress);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		String fatherName = (String)attributes.get("fatherName");

		if (fatherName != null) {
			setFatherName(fatherName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String motherName = (String)attributes.get("motherName");

		if (motherName != null) {
			setMotherName(motherName);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String maritalStatus = (String)attributes.get("maritalStatus");

		if (maritalStatus != null) {
			setMaritalStatus(maritalStatus);
		}

		Date birthDate = (Date)attributes.get("birthDate");

		if (birthDate != null) {
			setBirthDate(birthDate);
		}

		String mobileNo = (String)attributes.get("mobileNo");

		if (mobileNo != null) {
			setMobileNo(mobileNo);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String nidDivision = (String)attributes.get("nidDivision");

		if (nidDivision != null) {
			setNidDivision(nidDivision);
		}

		String nidDistrict = (String)attributes.get("nidDistrict");

		if (nidDistrict != null) {
			setNidDistrict(nidDistrict);
		}

		String nidUpzilla = (String)attributes.get("nidUpzilla");

		if (nidUpzilla != null) {
			setNidUpzilla(nidUpzilla);
		}

		String nidUnion = (String)attributes.get("nidUnion");

		if (nidUnion != null) {
			setNidUnion(nidUnion);
		}

		String nidVillage = (String)attributes.get("nidVillage");

		if (nidVillage != null) {
			setNidVillage(nidVillage);
		}

		String nidWard = (String)attributes.get("nidWard");

		if (nidWard != null) {
			setNidWard(nidWard);
		}

		String nidZipCode = (String)attributes.get("nidZipCode");

		if (nidZipCode != null) {
			setNidZipCode(nidZipCode);
		}

		String nidPostOffice = (String)attributes.get("nidPostOffice");

		if (nidPostOffice != null) {
			setNidPostOffice(nidPostOffice);
		}

		String nidHouseAddress = (String)attributes.get("nidHouseAddress");

		if (nidHouseAddress != null) {
			setNidHouseAddress(nidHouseAddress);
		}

		Boolean isSubmit = (Boolean)attributes.get("isSubmit");

		if (isSubmit != null) {
			setIsSubmit(isSubmit);
		}

		String electricExemptionMemo = (String)attributes.get(
			"electricExemptionMemo");

		if (electricExemptionMemo != null) {
			setElectricExemptionMemo(electricExemptionMemo);
		}

		String envClrMemo = (String)attributes.get("envClrMemo");

		if (envClrMemo != null) {
			setEnvClrMemo(envClrMemo);
		}

		String bstiClrMemo = (String)attributes.get("bstiClrMemo");

		if (bstiClrMemo != null) {
			setBstiClrMemo(bstiClrMemo);
		}

		String fireLicNumDoc = (String)attributes.get("fireLicNumDoc");

		if (fireLicNumDoc != null) {
			setFireLicNumDoc(fireLicNumDoc);
		}

		String productType = (String)attributes.get("productType");

		if (productType != null) {
			setProductType(productType);
		}
	}

	@Override
	public licnsUserRegs cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the applicant name of this licns user regs.
	 *
	 * @return the applicant name of this licns user regs
	 */
	@Override
	public String getApplicantName() {
		return model.getApplicantName();
	}

	/**
	 * Returns the bank stat of this licns user regs.
	 *
	 * @return the bank stat of this licns user regs
	 */
	@Override
	public String getBankStat() {
		return model.getBankStat();
	}

	/**
	 * Returns the bin doc of this licns user regs.
	 *
	 * @return the bin doc of this licns user regs
	 */
	@Override
	public String getBinDoc() {
		return model.getBinDoc();
	}

	/**
	 * Returns the birth date of this licns user regs.
	 *
	 * @return the birth date of this licns user regs
	 */
	@Override
	public Date getBirthDate() {
		return model.getBirthDate();
	}

	/**
	 * Returns the bsti clr memo of this licns user regs.
	 *
	 * @return the bsti clr memo of this licns user regs
	 */
	@Override
	public String getBstiClrMemo() {
		return model.getBstiClrMemo();
	}

	/**
	 * Returns the business district of this licns user regs.
	 *
	 * @return the business district of this licns user regs
	 */
	@Override
	public long getBusinessDistrict() {
		return model.getBusinessDistrict();
	}

	/**
	 * Returns the business division of this licns user regs.
	 *
	 * @return the business division of this licns user regs
	 */
	@Override
	public long getBusinessDivision() {
		return model.getBusinessDivision();
	}

	/**
	 * Returns the business house address of this licns user regs.
	 *
	 * @return the business house address of this licns user regs
	 */
	@Override
	public String getBusinessHouseAddress() {
		return model.getBusinessHouseAddress();
	}

	/**
	 * Returns the business identification no of this licns user regs.
	 *
	 * @return the business identification no of this licns user regs
	 */
	@Override
	public String getBusinessIdentificationNo() {
		return model.getBusinessIdentificationNo();
	}

	/**
	 * Returns the business name of this licns user regs.
	 *
	 * @return the business name of this licns user regs
	 */
	@Override
	public String getBusinessName() {
		return model.getBusinessName();
	}

	/**
	 * Returns the business post office of this licns user regs.
	 *
	 * @return the business post office of this licns user regs
	 */
	@Override
	public String getBusinessPostOffice() {
		return model.getBusinessPostOffice();
	}

	/**
	 * Returns the business type of this licns user regs.
	 *
	 * @return the business type of this licns user regs
	 */
	@Override
	public String getBusinessType() {
		return model.getBusinessType();
	}

	/**
	 * Returns the business union name of this licns user regs.
	 *
	 * @return the business union name of this licns user regs
	 */
	@Override
	public long getBusinessUnionName() {
		return model.getBusinessUnionName();
	}

	/**
	 * Returns the business upzilla of this licns user regs.
	 *
	 * @return the business upzilla of this licns user regs
	 */
	@Override
	public long getBusinessUpzilla() {
		return model.getBusinessUpzilla();
	}

	/**
	 * Returns the business village of this licns user regs.
	 *
	 * @return the business village of this licns user regs
	 */
	@Override
	public String getBusinessVillage() {
		return model.getBusinessVillage();
	}

	/**
	 * Returns the business ward of this licns user regs.
	 *
	 * @return the business ward of this licns user regs
	 */
	@Override
	public String getBusinessWard() {
		return model.getBusinessWard();
	}

	/**
	 * Returns the business zip code of this licns user regs.
	 *
	 * @return the business zip code of this licns user regs
	 */
	@Override
	public String getBusinessZipCode() {
		return model.getBusinessZipCode();
	}

	/**
	 * Returns the comments of this licns user regs.
	 *
	 * @return the comments of this licns user regs
	 */
	@Override
	public String getComments() {
		return model.getComments();
	}

	/**
	 * Returns the district of this licns user regs.
	 *
	 * @return the district of this licns user regs
	 */
	@Override
	public long getDistrict() {
		return model.getDistrict();
	}

	/**
	 * Returns the division of this licns user regs.
	 *
	 * @return the division of this licns user regs
	 */
	@Override
	public long getDivision() {
		return model.getDivision();
	}

	/**
	 * Returns the electric exemption memo of this licns user regs.
	 *
	 * @return the electric exemption memo of this licns user regs
	 */
	@Override
	public String getElectricExemptionMemo() {
		return model.getElectricExemptionMemo();
	}

	/**
	 * Returns the email of this licns user regs.
	 *
	 * @return the email of this licns user regs
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the env clr memo of this licns user regs.
	 *
	 * @return the env clr memo of this licns user regs
	 */
	@Override
	public String getEnvClrMemo() {
		return model.getEnvClrMemo();
	}

	/**
	 * Returns the father name of this licns user regs.
	 *
	 * @return the father name of this licns user regs
	 */
	@Override
	public String getFatherName() {
		return model.getFatherName();
	}

	/**
	 * Returns the fire lic num doc of this licns user regs.
	 *
	 * @return the fire lic num doc of this licns user regs
	 */
	@Override
	public String getFireLicNumDoc() {
		return model.getFireLicNumDoc();
	}

	/**
	 * Returns the food grain license type of this licns user regs.
	 *
	 * @return the food grain license type of this licns user regs
	 */
	@Override
	public String getFoodGrainLicenseType() {
		return model.getFoodGrainLicenseType();
	}

	/**
	 * Returns the gender of this licns user regs.
	 *
	 * @return the gender of this licns user regs
	 */
	@Override
	public String getGender() {
		return model.getGender();
	}

	/**
	 * Returns the house address of this licns user regs.
	 *
	 * @return the house address of this licns user regs
	 */
	@Override
	public String getHouseAddress() {
		return model.getHouseAddress();
	}

	/**
	 * Returns the is submit of this licns user regs.
	 *
	 * @return the is submit of this licns user regs
	 */
	@Override
	public boolean getIsSubmit() {
		return model.getIsSubmit();
	}

	/**
	 * Returns the last name of this licns user regs.
	 *
	 * @return the last name of this licns user regs
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the lic user ID of this licns user regs.
	 *
	 * @return the lic user ID of this licns user regs
	 */
	@Override
	public long getLicUserId() {
		return model.getLicUserId();
	}

	/**
	 * Returns the lic user uuid of this licns user regs.
	 *
	 * @return the lic user uuid of this licns user regs
	 */
	@Override
	public String getLicUserUuid() {
		return model.getLicUserUuid();
	}

	/**
	 * Returns the marital status of this licns user regs.
	 *
	 * @return the marital status of this licns user regs
	 */
	@Override
	public String getMaritalStatus() {
		return model.getMaritalStatus();
	}

	/**
	 * Returns the mobile no of this licns user regs.
	 *
	 * @return the mobile no of this licns user regs
	 */
	@Override
	public String getMobileNo() {
		return model.getMobileNo();
	}

	/**
	 * Returns the mother name of this licns user regs.
	 *
	 * @return the mother name of this licns user regs
	 */
	@Override
	public String getMotherName() {
		return model.getMotherName();
	}

	/**
	 * Returns the national ID of this licns user regs.
	 *
	 * @return the national ID of this licns user regs
	 */
	@Override
	public String getNationalId() {
		return model.getNationalId();
	}

	/**
	 * Returns the nid district of this licns user regs.
	 *
	 * @return the nid district of this licns user regs
	 */
	@Override
	public String getNidDistrict() {
		return model.getNidDistrict();
	}

	/**
	 * Returns the nid division of this licns user regs.
	 *
	 * @return the nid division of this licns user regs
	 */
	@Override
	public String getNidDivision() {
		return model.getNidDivision();
	}

	/**
	 * Returns the nid house address of this licns user regs.
	 *
	 * @return the nid house address of this licns user regs
	 */
	@Override
	public String getNidHouseAddress() {
		return model.getNidHouseAddress();
	}

	/**
	 * Returns the nid post office of this licns user regs.
	 *
	 * @return the nid post office of this licns user regs
	 */
	@Override
	public String getNidPostOffice() {
		return model.getNidPostOffice();
	}

	/**
	 * Returns the nid union of this licns user regs.
	 *
	 * @return the nid union of this licns user regs
	 */
	@Override
	public String getNidUnion() {
		return model.getNidUnion();
	}

	/**
	 * Returns the nid upzilla of this licns user regs.
	 *
	 * @return the nid upzilla of this licns user regs
	 */
	@Override
	public String getNidUpzilla() {
		return model.getNidUpzilla();
	}

	/**
	 * Returns the nid village of this licns user regs.
	 *
	 * @return the nid village of this licns user regs
	 */
	@Override
	public String getNidVillage() {
		return model.getNidVillage();
	}

	/**
	 * Returns the nid ward of this licns user regs.
	 *
	 * @return the nid ward of this licns user regs
	 */
	@Override
	public String getNidWard() {
		return model.getNidWard();
	}

	/**
	 * Returns the nid zip code of this licns user regs.
	 *
	 * @return the nid zip code of this licns user regs
	 */
	@Override
	public String getNidZipCode() {
		return model.getNidZipCode();
	}

	/**
	 * Returns the other relevent doc of this licns user regs.
	 *
	 * @return the other relevent doc of this licns user regs
	 */
	@Override
	public String getOtherReleventDoc() {
		return model.getOtherReleventDoc();
	}

	/**
	 * Returns the password of this licns user regs.
	 *
	 * @return the password of this licns user regs
	 */
	@Override
	public String getPassword() {
		return model.getPassword();
	}

	/**
	 * Returns the photograph file of this licns user regs.
	 *
	 * @return the photograph file of this licns user regs
	 */
	@Override
	public String getPhotographFile() {
		return model.getPhotographFile();
	}

	/**
	 * Returns the post office of this licns user regs.
	 *
	 * @return the post office of this licns user regs
	 */
	@Override
	public String getPostOffice() {
		return model.getPostOffice();
	}

	/**
	 * Returns the primary key of this licns user regs.
	 *
	 * @return the primary key of this licns user regs
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product type of this licns user regs.
	 *
	 * @return the product type of this licns user regs
	 */
	@Override
	public String getProductType() {
		return model.getProductType();
	}

	/**
	 * Returns the tax identification no of this licns user regs.
	 *
	 * @return the tax identification no of this licns user regs
	 */
	@Override
	public String getTaxIdentificationNo() {
		return model.getTaxIdentificationNo();
	}

	/**
	 * Returns the tin doc of this licns user regs.
	 *
	 * @return the tin doc of this licns user regs
	 */
	@Override
	public String getTinDoc() {
		return model.getTinDoc();
	}

	/**
	 * Returns the trade lic doc of this licns user regs.
	 *
	 * @return the trade lic doc of this licns user regs
	 */
	@Override
	public String getTradeLicDoc() {
		return model.getTradeLicDoc();
	}

	/**
	 * Returns the trade license expiry date of this licns user regs.
	 *
	 * @return the trade license expiry date of this licns user regs
	 */
	@Override
	public Date getTradeLicenseExpiryDate() {
		return model.getTradeLicenseExpiryDate();
	}

	/**
	 * Returns the trade license issuer city of this licns user regs.
	 *
	 * @return the trade license issuer city of this licns user regs
	 */
	@Override
	public String getTradeLicenseIssuerCity() {
		return model.getTradeLicenseIssuerCity();
	}

	/**
	 * Returns the trade license issuer code of this licns user regs.
	 *
	 * @return the trade license issuer code of this licns user regs
	 */
	@Override
	public String getTradeLicenseIssuerCode() {
		return model.getTradeLicenseIssuerCode();
	}

	/**
	 * Returns the trade license no of this licns user regs.
	 *
	 * @return the trade license no of this licns user regs
	 */
	@Override
	public String getTradeLicenseNo() {
		return model.getTradeLicenseNo();
	}

	/**
	 * Returns the union name of this licns user regs.
	 *
	 * @return the union name of this licns user regs
	 */
	@Override
	public long getUnionName() {
		return model.getUnionName();
	}

	/**
	 * Returns the upzilla of this licns user regs.
	 *
	 * @return the upzilla of this licns user regs
	 */
	@Override
	public long getUpzilla() {
		return model.getUpzilla();
	}

	/**
	 * Returns the user ID of this licns user regs.
	 *
	 * @return the user ID of this licns user regs
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this licns user regs.
	 *
	 * @return the user uuid of this licns user regs
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the village of this licns user regs.
	 *
	 * @return the village of this licns user regs
	 */
	@Override
	public String getVillage() {
		return model.getVillage();
	}

	/**
	 * Returns the ward of this licns user regs.
	 *
	 * @return the ward of this licns user regs
	 */
	@Override
	public String getWard() {
		return model.getWard();
	}

	/**
	 * Returns the zip code of this licns user regs.
	 *
	 * @return the zip code of this licns user regs
	 */
	@Override
	public String getZipCode() {
		return model.getZipCode();
	}

	/**
	 * Returns <code>true</code> if this licns user regs is is submit.
	 *
	 * @return <code>true</code> if this licns user regs is is submit; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsSubmit() {
		return model.isIsSubmit();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the applicant name of this licns user regs.
	 *
	 * @param applicantName the applicant name of this licns user regs
	 */
	@Override
	public void setApplicantName(String applicantName) {
		model.setApplicantName(applicantName);
	}

	/**
	 * Sets the bank stat of this licns user regs.
	 *
	 * @param bankStat the bank stat of this licns user regs
	 */
	@Override
	public void setBankStat(String bankStat) {
		model.setBankStat(bankStat);
	}

	/**
	 * Sets the bin doc of this licns user regs.
	 *
	 * @param binDoc the bin doc of this licns user regs
	 */
	@Override
	public void setBinDoc(String binDoc) {
		model.setBinDoc(binDoc);
	}

	/**
	 * Sets the birth date of this licns user regs.
	 *
	 * @param birthDate the birth date of this licns user regs
	 */
	@Override
	public void setBirthDate(Date birthDate) {
		model.setBirthDate(birthDate);
	}

	/**
	 * Sets the bsti clr memo of this licns user regs.
	 *
	 * @param bstiClrMemo the bsti clr memo of this licns user regs
	 */
	@Override
	public void setBstiClrMemo(String bstiClrMemo) {
		model.setBstiClrMemo(bstiClrMemo);
	}

	/**
	 * Sets the business district of this licns user regs.
	 *
	 * @param businessDistrict the business district of this licns user regs
	 */
	@Override
	public void setBusinessDistrict(long businessDistrict) {
		model.setBusinessDistrict(businessDistrict);
	}

	/**
	 * Sets the business division of this licns user regs.
	 *
	 * @param businessDivision the business division of this licns user regs
	 */
	@Override
	public void setBusinessDivision(long businessDivision) {
		model.setBusinessDivision(businessDivision);
	}

	/**
	 * Sets the business house address of this licns user regs.
	 *
	 * @param businessHouseAddress the business house address of this licns user regs
	 */
	@Override
	public void setBusinessHouseAddress(String businessHouseAddress) {
		model.setBusinessHouseAddress(businessHouseAddress);
	}

	/**
	 * Sets the business identification no of this licns user regs.
	 *
	 * @param businessIdentificationNo the business identification no of this licns user regs
	 */
	@Override
	public void setBusinessIdentificationNo(String businessIdentificationNo) {
		model.setBusinessIdentificationNo(businessIdentificationNo);
	}

	/**
	 * Sets the business name of this licns user regs.
	 *
	 * @param businessName the business name of this licns user regs
	 */
	@Override
	public void setBusinessName(String businessName) {
		model.setBusinessName(businessName);
	}

	/**
	 * Sets the business post office of this licns user regs.
	 *
	 * @param businessPostOffice the business post office of this licns user regs
	 */
	@Override
	public void setBusinessPostOffice(String businessPostOffice) {
		model.setBusinessPostOffice(businessPostOffice);
	}

	/**
	 * Sets the business type of this licns user regs.
	 *
	 * @param businessType the business type of this licns user regs
	 */
	@Override
	public void setBusinessType(String businessType) {
		model.setBusinessType(businessType);
	}

	/**
	 * Sets the business union name of this licns user regs.
	 *
	 * @param businessUnionName the business union name of this licns user regs
	 */
	@Override
	public void setBusinessUnionName(long businessUnionName) {
		model.setBusinessUnionName(businessUnionName);
	}

	/**
	 * Sets the business upzilla of this licns user regs.
	 *
	 * @param businessUpzilla the business upzilla of this licns user regs
	 */
	@Override
	public void setBusinessUpzilla(long businessUpzilla) {
		model.setBusinessUpzilla(businessUpzilla);
	}

	/**
	 * Sets the business village of this licns user regs.
	 *
	 * @param businessVillage the business village of this licns user regs
	 */
	@Override
	public void setBusinessVillage(String businessVillage) {
		model.setBusinessVillage(businessVillage);
	}

	/**
	 * Sets the business ward of this licns user regs.
	 *
	 * @param businessWard the business ward of this licns user regs
	 */
	@Override
	public void setBusinessWard(String businessWard) {
		model.setBusinessWard(businessWard);
	}

	/**
	 * Sets the business zip code of this licns user regs.
	 *
	 * @param businessZipCode the business zip code of this licns user regs
	 */
	@Override
	public void setBusinessZipCode(String businessZipCode) {
		model.setBusinessZipCode(businessZipCode);
	}

	/**
	 * Sets the comments of this licns user regs.
	 *
	 * @param comments the comments of this licns user regs
	 */
	@Override
	public void setComments(String comments) {
		model.setComments(comments);
	}

	/**
	 * Sets the district of this licns user regs.
	 *
	 * @param district the district of this licns user regs
	 */
	@Override
	public void setDistrict(long district) {
		model.setDistrict(district);
	}

	/**
	 * Sets the division of this licns user regs.
	 *
	 * @param division the division of this licns user regs
	 */
	@Override
	public void setDivision(long division) {
		model.setDivision(division);
	}

	/**
	 * Sets the electric exemption memo of this licns user regs.
	 *
	 * @param electricExemptionMemo the electric exemption memo of this licns user regs
	 */
	@Override
	public void setElectricExemptionMemo(String electricExemptionMemo) {
		model.setElectricExemptionMemo(electricExemptionMemo);
	}

	/**
	 * Sets the email of this licns user regs.
	 *
	 * @param email the email of this licns user regs
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the env clr memo of this licns user regs.
	 *
	 * @param envClrMemo the env clr memo of this licns user regs
	 */
	@Override
	public void setEnvClrMemo(String envClrMemo) {
		model.setEnvClrMemo(envClrMemo);
	}

	/**
	 * Sets the father name of this licns user regs.
	 *
	 * @param fatherName the father name of this licns user regs
	 */
	@Override
	public void setFatherName(String fatherName) {
		model.setFatherName(fatherName);
	}

	/**
	 * Sets the fire lic num doc of this licns user regs.
	 *
	 * @param fireLicNumDoc the fire lic num doc of this licns user regs
	 */
	@Override
	public void setFireLicNumDoc(String fireLicNumDoc) {
		model.setFireLicNumDoc(fireLicNumDoc);
	}

	/**
	 * Sets the food grain license type of this licns user regs.
	 *
	 * @param foodGrainLicenseType the food grain license type of this licns user regs
	 */
	@Override
	public void setFoodGrainLicenseType(String foodGrainLicenseType) {
		model.setFoodGrainLicenseType(foodGrainLicenseType);
	}

	/**
	 * Sets the gender of this licns user regs.
	 *
	 * @param gender the gender of this licns user regs
	 */
	@Override
	public void setGender(String gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the house address of this licns user regs.
	 *
	 * @param houseAddress the house address of this licns user regs
	 */
	@Override
	public void setHouseAddress(String houseAddress) {
		model.setHouseAddress(houseAddress);
	}

	/**
	 * Sets whether this licns user regs is is submit.
	 *
	 * @param isSubmit the is submit of this licns user regs
	 */
	@Override
	public void setIsSubmit(boolean isSubmit) {
		model.setIsSubmit(isSubmit);
	}

	/**
	 * Sets the last name of this licns user regs.
	 *
	 * @param lastName the last name of this licns user regs
	 */
	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets the lic user ID of this licns user regs.
	 *
	 * @param licUserId the lic user ID of this licns user regs
	 */
	@Override
	public void setLicUserId(long licUserId) {
		model.setLicUserId(licUserId);
	}

	/**
	 * Sets the lic user uuid of this licns user regs.
	 *
	 * @param licUserUuid the lic user uuid of this licns user regs
	 */
	@Override
	public void setLicUserUuid(String licUserUuid) {
		model.setLicUserUuid(licUserUuid);
	}

	/**
	 * Sets the marital status of this licns user regs.
	 *
	 * @param maritalStatus the marital status of this licns user regs
	 */
	@Override
	public void setMaritalStatus(String maritalStatus) {
		model.setMaritalStatus(maritalStatus);
	}

	/**
	 * Sets the mobile no of this licns user regs.
	 *
	 * @param mobileNo the mobile no of this licns user regs
	 */
	@Override
	public void setMobileNo(String mobileNo) {
		model.setMobileNo(mobileNo);
	}

	/**
	 * Sets the mother name of this licns user regs.
	 *
	 * @param motherName the mother name of this licns user regs
	 */
	@Override
	public void setMotherName(String motherName) {
		model.setMotherName(motherName);
	}

	/**
	 * Sets the national ID of this licns user regs.
	 *
	 * @param nationalId the national ID of this licns user regs
	 */
	@Override
	public void setNationalId(String nationalId) {
		model.setNationalId(nationalId);
	}

	/**
	 * Sets the nid district of this licns user regs.
	 *
	 * @param nidDistrict the nid district of this licns user regs
	 */
	@Override
	public void setNidDistrict(String nidDistrict) {
		model.setNidDistrict(nidDistrict);
	}

	/**
	 * Sets the nid division of this licns user regs.
	 *
	 * @param nidDivision the nid division of this licns user regs
	 */
	@Override
	public void setNidDivision(String nidDivision) {
		model.setNidDivision(nidDivision);
	}

	/**
	 * Sets the nid house address of this licns user regs.
	 *
	 * @param nidHouseAddress the nid house address of this licns user regs
	 */
	@Override
	public void setNidHouseAddress(String nidHouseAddress) {
		model.setNidHouseAddress(nidHouseAddress);
	}

	/**
	 * Sets the nid post office of this licns user regs.
	 *
	 * @param nidPostOffice the nid post office of this licns user regs
	 */
	@Override
	public void setNidPostOffice(String nidPostOffice) {
		model.setNidPostOffice(nidPostOffice);
	}

	/**
	 * Sets the nid union of this licns user regs.
	 *
	 * @param nidUnion the nid union of this licns user regs
	 */
	@Override
	public void setNidUnion(String nidUnion) {
		model.setNidUnion(nidUnion);
	}

	/**
	 * Sets the nid upzilla of this licns user regs.
	 *
	 * @param nidUpzilla the nid upzilla of this licns user regs
	 */
	@Override
	public void setNidUpzilla(String nidUpzilla) {
		model.setNidUpzilla(nidUpzilla);
	}

	/**
	 * Sets the nid village of this licns user regs.
	 *
	 * @param nidVillage the nid village of this licns user regs
	 */
	@Override
	public void setNidVillage(String nidVillage) {
		model.setNidVillage(nidVillage);
	}

	/**
	 * Sets the nid ward of this licns user regs.
	 *
	 * @param nidWard the nid ward of this licns user regs
	 */
	@Override
	public void setNidWard(String nidWard) {
		model.setNidWard(nidWard);
	}

	/**
	 * Sets the nid zip code of this licns user regs.
	 *
	 * @param nidZipCode the nid zip code of this licns user regs
	 */
	@Override
	public void setNidZipCode(String nidZipCode) {
		model.setNidZipCode(nidZipCode);
	}

	/**
	 * Sets the other relevent doc of this licns user regs.
	 *
	 * @param otherReleventDoc the other relevent doc of this licns user regs
	 */
	@Override
	public void setOtherReleventDoc(String otherReleventDoc) {
		model.setOtherReleventDoc(otherReleventDoc);
	}

	/**
	 * Sets the password of this licns user regs.
	 *
	 * @param password the password of this licns user regs
	 */
	@Override
	public void setPassword(String password) {
		model.setPassword(password);
	}

	/**
	 * Sets the photograph file of this licns user regs.
	 *
	 * @param photographFile the photograph file of this licns user regs
	 */
	@Override
	public void setPhotographFile(String photographFile) {
		model.setPhotographFile(photographFile);
	}

	/**
	 * Sets the post office of this licns user regs.
	 *
	 * @param postOffice the post office of this licns user regs
	 */
	@Override
	public void setPostOffice(String postOffice) {
		model.setPostOffice(postOffice);
	}

	/**
	 * Sets the primary key of this licns user regs.
	 *
	 * @param primaryKey the primary key of this licns user regs
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product type of this licns user regs.
	 *
	 * @param productType the product type of this licns user regs
	 */
	@Override
	public void setProductType(String productType) {
		model.setProductType(productType);
	}

	/**
	 * Sets the tax identification no of this licns user regs.
	 *
	 * @param taxIdentificationNo the tax identification no of this licns user regs
	 */
	@Override
	public void setTaxIdentificationNo(String taxIdentificationNo) {
		model.setTaxIdentificationNo(taxIdentificationNo);
	}

	/**
	 * Sets the tin doc of this licns user regs.
	 *
	 * @param tinDoc the tin doc of this licns user regs
	 */
	@Override
	public void setTinDoc(String tinDoc) {
		model.setTinDoc(tinDoc);
	}

	/**
	 * Sets the trade lic doc of this licns user regs.
	 *
	 * @param tradeLicDoc the trade lic doc of this licns user regs
	 */
	@Override
	public void setTradeLicDoc(String tradeLicDoc) {
		model.setTradeLicDoc(tradeLicDoc);
	}

	/**
	 * Sets the trade license expiry date of this licns user regs.
	 *
	 * @param tradeLicenseExpiryDate the trade license expiry date of this licns user regs
	 */
	@Override
	public void setTradeLicenseExpiryDate(Date tradeLicenseExpiryDate) {
		model.setTradeLicenseExpiryDate(tradeLicenseExpiryDate);
	}

	/**
	 * Sets the trade license issuer city of this licns user regs.
	 *
	 * @param tradeLicenseIssuerCity the trade license issuer city of this licns user regs
	 */
	@Override
	public void setTradeLicenseIssuerCity(String tradeLicenseIssuerCity) {
		model.setTradeLicenseIssuerCity(tradeLicenseIssuerCity);
	}

	/**
	 * Sets the trade license issuer code of this licns user regs.
	 *
	 * @param tradeLicenseIssuerCode the trade license issuer code of this licns user regs
	 */
	@Override
	public void setTradeLicenseIssuerCode(String tradeLicenseIssuerCode) {
		model.setTradeLicenseIssuerCode(tradeLicenseIssuerCode);
	}

	/**
	 * Sets the trade license no of this licns user regs.
	 *
	 * @param tradeLicenseNo the trade license no of this licns user regs
	 */
	@Override
	public void setTradeLicenseNo(String tradeLicenseNo) {
		model.setTradeLicenseNo(tradeLicenseNo);
	}

	/**
	 * Sets the union name of this licns user regs.
	 *
	 * @param unionName the union name of this licns user regs
	 */
	@Override
	public void setUnionName(long unionName) {
		model.setUnionName(unionName);
	}

	/**
	 * Sets the upzilla of this licns user regs.
	 *
	 * @param upzilla the upzilla of this licns user regs
	 */
	@Override
	public void setUpzilla(long upzilla) {
		model.setUpzilla(upzilla);
	}

	/**
	 * Sets the user ID of this licns user regs.
	 *
	 * @param userId the user ID of this licns user regs
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this licns user regs.
	 *
	 * @param userUuid the user uuid of this licns user regs
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the village of this licns user regs.
	 *
	 * @param village the village of this licns user regs
	 */
	@Override
	public void setVillage(String village) {
		model.setVillage(village);
	}

	/**
	 * Sets the ward of this licns user regs.
	 *
	 * @param ward the ward of this licns user regs
	 */
	@Override
	public void setWard(String ward) {
		model.setWard(ward);
	}

	/**
	 * Sets the zip code of this licns user regs.
	 *
	 * @param zipCode the zip code of this licns user regs
	 */
	@Override
	public void setZipCode(String zipCode) {
		model.setZipCode(zipCode);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected licnsUserRegsWrapper wrap(licnsUserRegs licnsUserRegs) {
		return new licnsUserRegsWrapper(licnsUserRegs);
	}

}