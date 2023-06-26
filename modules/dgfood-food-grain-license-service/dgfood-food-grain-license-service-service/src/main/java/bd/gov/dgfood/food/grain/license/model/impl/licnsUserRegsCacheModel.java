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

package bd.gov.dgfood.food.grain.license.model.impl;

import bd.gov.dgfood.food.grain.license.model.licnsUserRegs;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing licnsUserRegs in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class licnsUserRegsCacheModel
	implements CacheModel<licnsUserRegs>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof licnsUserRegsCacheModel)) {
			return false;
		}

		licnsUserRegsCacheModel licnsUserRegsCacheModel =
			(licnsUserRegsCacheModel)object;

		if (licUserId == licnsUserRegsCacheModel.licUserId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, licUserId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(125);

		sb.append("{licUserId=");
		sb.append(licUserId);
		sb.append(", nationalId=");
		sb.append(nationalId);
		sb.append(", applicantName=");
		sb.append(applicantName);
		sb.append(", tradeLicenseNo=");
		sb.append(tradeLicenseNo);
		sb.append(", tradeLicenseExpiryDate=");
		sb.append(tradeLicenseExpiryDate);
		sb.append(", tradeLicenseIssuerCode=");
		sb.append(tradeLicenseIssuerCode);
		sb.append(", tradeLicenseIssuerCity=");
		sb.append(tradeLicenseIssuerCity);
		sb.append(", businessIdentificationNo=");
		sb.append(businessIdentificationNo);
		sb.append(", taxIdentificationNo=");
		sb.append(taxIdentificationNo);
		sb.append(", businessName=");
		sb.append(businessName);
		sb.append(", businessType=");
		sb.append(businessType);
		sb.append(", businessDivision=");
		sb.append(businessDivision);
		sb.append(", businessDistrict=");
		sb.append(businessDistrict);
		sb.append(", businessUpzilla=");
		sb.append(businessUpzilla);
		sb.append(", businessUnionName=");
		sb.append(businessUnionName);
		sb.append(", businessVillage=");
		sb.append(businessVillage);
		sb.append(", businessWard=");
		sb.append(businessWard);
		sb.append(", businessZipCode=");
		sb.append(businessZipCode);
		sb.append(", businessPostOffice=");
		sb.append(businessPostOffice);
		sb.append(", businessHouseAddress=");
		sb.append(businessHouseAddress);
		sb.append(", photographFile=");
		sb.append(photographFile);
		sb.append(", tradeLicDoc=");
		sb.append(tradeLicDoc);
		sb.append(", binDoc=");
		sb.append(binDoc);
		sb.append(", tinDoc=");
		sb.append(tinDoc);
		sb.append(", bankStat=");
		sb.append(bankStat);
		sb.append(", otherReleventDoc=");
		sb.append(otherReleventDoc);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", foodGrainLicenseType=");
		sb.append(foodGrainLicenseType);
		sb.append(", division=");
		sb.append(division);
		sb.append(", district=");
		sb.append(district);
		sb.append(", upzilla=");
		sb.append(upzilla);
		sb.append(", unionName=");
		sb.append(unionName);
		sb.append(", village=");
		sb.append(village);
		sb.append(", ward=");
		sb.append(ward);
		sb.append(", zipCode=");
		sb.append(zipCode);
		sb.append(", postOffice=");
		sb.append(postOffice);
		sb.append(", houseAddress=");
		sb.append(houseAddress);
		sb.append(", password=");
		sb.append(password);
		sb.append(", fatherName=");
		sb.append(fatherName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", motherName=");
		sb.append(motherName);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", maritalStatus=");
		sb.append(maritalStatus);
		sb.append(", birthDate=");
		sb.append(birthDate);
		sb.append(", mobileNo=");
		sb.append(mobileNo);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", email=");
		sb.append(email);
		sb.append(", nidDivision=");
		sb.append(nidDivision);
		sb.append(", nidDistrict=");
		sb.append(nidDistrict);
		sb.append(", nidUpzilla=");
		sb.append(nidUpzilla);
		sb.append(", nidUnion=");
		sb.append(nidUnion);
		sb.append(", nidVillage=");
		sb.append(nidVillage);
		sb.append(", nidWard=");
		sb.append(nidWard);
		sb.append(", nidZipCode=");
		sb.append(nidZipCode);
		sb.append(", nidPostOffice=");
		sb.append(nidPostOffice);
		sb.append(", nidHouseAddress=");
		sb.append(nidHouseAddress);
		sb.append(", isSubmit=");
		sb.append(isSubmit);
		sb.append(", electricExemptionMemo=");
		sb.append(electricExemptionMemo);
		sb.append(", envClrMemo=");
		sb.append(envClrMemo);
		sb.append(", bstiClrMemo=");
		sb.append(bstiClrMemo);
		sb.append(", fireLicNumDoc=");
		sb.append(fireLicNumDoc);
		sb.append(", productType=");
		sb.append(productType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public licnsUserRegs toEntityModel() {
		licnsUserRegsImpl licnsUserRegsImpl = new licnsUserRegsImpl();

		licnsUserRegsImpl.setLicUserId(licUserId);

		if (nationalId == null) {
			licnsUserRegsImpl.setNationalId("");
		}
		else {
			licnsUserRegsImpl.setNationalId(nationalId);
		}

		if (applicantName == null) {
			licnsUserRegsImpl.setApplicantName("");
		}
		else {
			licnsUserRegsImpl.setApplicantName(applicantName);
		}

		if (tradeLicenseNo == null) {
			licnsUserRegsImpl.setTradeLicenseNo("");
		}
		else {
			licnsUserRegsImpl.setTradeLicenseNo(tradeLicenseNo);
		}

		if (tradeLicenseExpiryDate == Long.MIN_VALUE) {
			licnsUserRegsImpl.setTradeLicenseExpiryDate(null);
		}
		else {
			licnsUserRegsImpl.setTradeLicenseExpiryDate(
				new Date(tradeLicenseExpiryDate));
		}

		if (tradeLicenseIssuerCode == null) {
			licnsUserRegsImpl.setTradeLicenseIssuerCode("");
		}
		else {
			licnsUserRegsImpl.setTradeLicenseIssuerCode(tradeLicenseIssuerCode);
		}

		if (tradeLicenseIssuerCity == null) {
			licnsUserRegsImpl.setTradeLicenseIssuerCity("");
		}
		else {
			licnsUserRegsImpl.setTradeLicenseIssuerCity(tradeLicenseIssuerCity);
		}

		if (businessIdentificationNo == null) {
			licnsUserRegsImpl.setBusinessIdentificationNo("");
		}
		else {
			licnsUserRegsImpl.setBusinessIdentificationNo(
				businessIdentificationNo);
		}

		if (taxIdentificationNo == null) {
			licnsUserRegsImpl.setTaxIdentificationNo("");
		}
		else {
			licnsUserRegsImpl.setTaxIdentificationNo(taxIdentificationNo);
		}

		if (businessName == null) {
			licnsUserRegsImpl.setBusinessName("");
		}
		else {
			licnsUserRegsImpl.setBusinessName(businessName);
		}

		if (businessType == null) {
			licnsUserRegsImpl.setBusinessType("");
		}
		else {
			licnsUserRegsImpl.setBusinessType(businessType);
		}

		licnsUserRegsImpl.setBusinessDivision(businessDivision);
		licnsUserRegsImpl.setBusinessDistrict(businessDistrict);
		licnsUserRegsImpl.setBusinessUpzilla(businessUpzilla);
		licnsUserRegsImpl.setBusinessUnionName(businessUnionName);

		if (businessVillage == null) {
			licnsUserRegsImpl.setBusinessVillage("");
		}
		else {
			licnsUserRegsImpl.setBusinessVillage(businessVillage);
		}

		if (businessWard == null) {
			licnsUserRegsImpl.setBusinessWard("");
		}
		else {
			licnsUserRegsImpl.setBusinessWard(businessWard);
		}

		if (businessZipCode == null) {
			licnsUserRegsImpl.setBusinessZipCode("");
		}
		else {
			licnsUserRegsImpl.setBusinessZipCode(businessZipCode);
		}

		if (businessPostOffice == null) {
			licnsUserRegsImpl.setBusinessPostOffice("");
		}
		else {
			licnsUserRegsImpl.setBusinessPostOffice(businessPostOffice);
		}

		if (businessHouseAddress == null) {
			licnsUserRegsImpl.setBusinessHouseAddress("");
		}
		else {
			licnsUserRegsImpl.setBusinessHouseAddress(businessHouseAddress);
		}

		if (photographFile == null) {
			licnsUserRegsImpl.setPhotographFile("");
		}
		else {
			licnsUserRegsImpl.setPhotographFile(photographFile);
		}

		if (tradeLicDoc == null) {
			licnsUserRegsImpl.setTradeLicDoc("");
		}
		else {
			licnsUserRegsImpl.setTradeLicDoc(tradeLicDoc);
		}

		if (binDoc == null) {
			licnsUserRegsImpl.setBinDoc("");
		}
		else {
			licnsUserRegsImpl.setBinDoc(binDoc);
		}

		if (tinDoc == null) {
			licnsUserRegsImpl.setTinDoc("");
		}
		else {
			licnsUserRegsImpl.setTinDoc(tinDoc);
		}

		if (bankStat == null) {
			licnsUserRegsImpl.setBankStat("");
		}
		else {
			licnsUserRegsImpl.setBankStat(bankStat);
		}

		if (otherReleventDoc == null) {
			licnsUserRegsImpl.setOtherReleventDoc("");
		}
		else {
			licnsUserRegsImpl.setOtherReleventDoc(otherReleventDoc);
		}

		if (comments == null) {
			licnsUserRegsImpl.setComments("");
		}
		else {
			licnsUserRegsImpl.setComments(comments);
		}

		if (foodGrainLicenseType == null) {
			licnsUserRegsImpl.setFoodGrainLicenseType("");
		}
		else {
			licnsUserRegsImpl.setFoodGrainLicenseType(foodGrainLicenseType);
		}

		licnsUserRegsImpl.setDivision(division);
		licnsUserRegsImpl.setDistrict(district);
		licnsUserRegsImpl.setUpzilla(upzilla);
		licnsUserRegsImpl.setUnionName(unionName);

		if (village == null) {
			licnsUserRegsImpl.setVillage("");
		}
		else {
			licnsUserRegsImpl.setVillage(village);
		}

		if (ward == null) {
			licnsUserRegsImpl.setWard("");
		}
		else {
			licnsUserRegsImpl.setWard(ward);
		}

		if (zipCode == null) {
			licnsUserRegsImpl.setZipCode("");
		}
		else {
			licnsUserRegsImpl.setZipCode(zipCode);
		}

		if (postOffice == null) {
			licnsUserRegsImpl.setPostOffice("");
		}
		else {
			licnsUserRegsImpl.setPostOffice(postOffice);
		}

		if (houseAddress == null) {
			licnsUserRegsImpl.setHouseAddress("");
		}
		else {
			licnsUserRegsImpl.setHouseAddress(houseAddress);
		}

		if (password == null) {
			licnsUserRegsImpl.setPassword("");
		}
		else {
			licnsUserRegsImpl.setPassword(password);
		}

		if (fatherName == null) {
			licnsUserRegsImpl.setFatherName("");
		}
		else {
			licnsUserRegsImpl.setFatherName(fatherName);
		}

		if (lastName == null) {
			licnsUserRegsImpl.setLastName("");
		}
		else {
			licnsUserRegsImpl.setLastName(lastName);
		}

		if (motherName == null) {
			licnsUserRegsImpl.setMotherName("");
		}
		else {
			licnsUserRegsImpl.setMotherName(motherName);
		}

		if (gender == null) {
			licnsUserRegsImpl.setGender("");
		}
		else {
			licnsUserRegsImpl.setGender(gender);
		}

		if (maritalStatus == null) {
			licnsUserRegsImpl.setMaritalStatus("");
		}
		else {
			licnsUserRegsImpl.setMaritalStatus(maritalStatus);
		}

		if (birthDate == Long.MIN_VALUE) {
			licnsUserRegsImpl.setBirthDate(null);
		}
		else {
			licnsUserRegsImpl.setBirthDate(new Date(birthDate));
		}

		if (mobileNo == null) {
			licnsUserRegsImpl.setMobileNo("");
		}
		else {
			licnsUserRegsImpl.setMobileNo(mobileNo);
		}

		licnsUserRegsImpl.setUserId(userId);

		if (email == null) {
			licnsUserRegsImpl.setEmail("");
		}
		else {
			licnsUserRegsImpl.setEmail(email);
		}

		if (nidDivision == null) {
			licnsUserRegsImpl.setNidDivision("");
		}
		else {
			licnsUserRegsImpl.setNidDivision(nidDivision);
		}

		if (nidDistrict == null) {
			licnsUserRegsImpl.setNidDistrict("");
		}
		else {
			licnsUserRegsImpl.setNidDistrict(nidDistrict);
		}

		if (nidUpzilla == null) {
			licnsUserRegsImpl.setNidUpzilla("");
		}
		else {
			licnsUserRegsImpl.setNidUpzilla(nidUpzilla);
		}

		if (nidUnion == null) {
			licnsUserRegsImpl.setNidUnion("");
		}
		else {
			licnsUserRegsImpl.setNidUnion(nidUnion);
		}

		if (nidVillage == null) {
			licnsUserRegsImpl.setNidVillage("");
		}
		else {
			licnsUserRegsImpl.setNidVillage(nidVillage);
		}

		if (nidWard == null) {
			licnsUserRegsImpl.setNidWard("");
		}
		else {
			licnsUserRegsImpl.setNidWard(nidWard);
		}

		if (nidZipCode == null) {
			licnsUserRegsImpl.setNidZipCode("");
		}
		else {
			licnsUserRegsImpl.setNidZipCode(nidZipCode);
		}

		if (nidPostOffice == null) {
			licnsUserRegsImpl.setNidPostOffice("");
		}
		else {
			licnsUserRegsImpl.setNidPostOffice(nidPostOffice);
		}

		if (nidHouseAddress == null) {
			licnsUserRegsImpl.setNidHouseAddress("");
		}
		else {
			licnsUserRegsImpl.setNidHouseAddress(nidHouseAddress);
		}

		licnsUserRegsImpl.setIsSubmit(isSubmit);

		if (electricExemptionMemo == null) {
			licnsUserRegsImpl.setElectricExemptionMemo("");
		}
		else {
			licnsUserRegsImpl.setElectricExemptionMemo(electricExemptionMemo);
		}

		if (envClrMemo == null) {
			licnsUserRegsImpl.setEnvClrMemo("");
		}
		else {
			licnsUserRegsImpl.setEnvClrMemo(envClrMemo);
		}

		if (bstiClrMemo == null) {
			licnsUserRegsImpl.setBstiClrMemo("");
		}
		else {
			licnsUserRegsImpl.setBstiClrMemo(bstiClrMemo);
		}

		if (fireLicNumDoc == null) {
			licnsUserRegsImpl.setFireLicNumDoc("");
		}
		else {
			licnsUserRegsImpl.setFireLicNumDoc(fireLicNumDoc);
		}

		if (productType == null) {
			licnsUserRegsImpl.setProductType("");
		}
		else {
			licnsUserRegsImpl.setProductType(productType);
		}

		licnsUserRegsImpl.resetOriginalValues();

		return licnsUserRegsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		licUserId = objectInput.readLong();
		nationalId = objectInput.readUTF();
		applicantName = objectInput.readUTF();
		tradeLicenseNo = objectInput.readUTF();
		tradeLicenseExpiryDate = objectInput.readLong();
		tradeLicenseIssuerCode = objectInput.readUTF();
		tradeLicenseIssuerCity = objectInput.readUTF();
		businessIdentificationNo = objectInput.readUTF();
		taxIdentificationNo = objectInput.readUTF();
		businessName = objectInput.readUTF();
		businessType = objectInput.readUTF();

		businessDivision = objectInput.readLong();

		businessDistrict = objectInput.readLong();

		businessUpzilla = objectInput.readLong();

		businessUnionName = objectInput.readLong();
		businessVillage = objectInput.readUTF();
		businessWard = objectInput.readUTF();
		businessZipCode = objectInput.readUTF();
		businessPostOffice = objectInput.readUTF();
		businessHouseAddress = objectInput.readUTF();
		photographFile = objectInput.readUTF();
		tradeLicDoc = objectInput.readUTF();
		binDoc = objectInput.readUTF();
		tinDoc = objectInput.readUTF();
		bankStat = objectInput.readUTF();
		otherReleventDoc = objectInput.readUTF();
		comments = objectInput.readUTF();
		foodGrainLicenseType = objectInput.readUTF();

		division = objectInput.readLong();

		district = objectInput.readLong();

		upzilla = objectInput.readLong();

		unionName = objectInput.readLong();
		village = objectInput.readUTF();
		ward = objectInput.readUTF();
		zipCode = objectInput.readUTF();
		postOffice = objectInput.readUTF();
		houseAddress = objectInput.readUTF();
		password = objectInput.readUTF();
		fatherName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		motherName = objectInput.readUTF();
		gender = objectInput.readUTF();
		maritalStatus = objectInput.readUTF();
		birthDate = objectInput.readLong();
		mobileNo = objectInput.readUTF();

		userId = objectInput.readLong();
		email = objectInput.readUTF();
		nidDivision = objectInput.readUTF();
		nidDistrict = objectInput.readUTF();
		nidUpzilla = objectInput.readUTF();
		nidUnion = objectInput.readUTF();
		nidVillage = objectInput.readUTF();
		nidWard = objectInput.readUTF();
		nidZipCode = objectInput.readUTF();
		nidPostOffice = objectInput.readUTF();
		nidHouseAddress = objectInput.readUTF();

		isSubmit = objectInput.readBoolean();
		electricExemptionMemo = objectInput.readUTF();
		envClrMemo = objectInput.readUTF();
		bstiClrMemo = objectInput.readUTF();
		fireLicNumDoc = objectInput.readUTF();
		productType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(licUserId);

		if (nationalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationalId);
		}

		if (applicantName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(applicantName);
		}

		if (tradeLicenseNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tradeLicenseNo);
		}

		objectOutput.writeLong(tradeLicenseExpiryDate);

		if (tradeLicenseIssuerCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tradeLicenseIssuerCode);
		}

		if (tradeLicenseIssuerCity == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tradeLicenseIssuerCity);
		}

		if (businessIdentificationNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(businessIdentificationNo);
		}

		if (taxIdentificationNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(taxIdentificationNo);
		}

		if (businessName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(businessName);
		}

		if (businessType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(businessType);
		}

		objectOutput.writeLong(businessDivision);

		objectOutput.writeLong(businessDistrict);

		objectOutput.writeLong(businessUpzilla);

		objectOutput.writeLong(businessUnionName);

		if (businessVillage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(businessVillage);
		}

		if (businessWard == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(businessWard);
		}

		if (businessZipCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(businessZipCode);
		}

		if (businessPostOffice == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(businessPostOffice);
		}

		if (businessHouseAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(businessHouseAddress);
		}

		if (photographFile == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(photographFile);
		}

		if (tradeLicDoc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tradeLicDoc);
		}

		if (binDoc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(binDoc);
		}

		if (tinDoc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tinDoc);
		}

		if (bankStat == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bankStat);
		}

		if (otherReleventDoc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(otherReleventDoc);
		}

		if (comments == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(comments);
		}

		if (foodGrainLicenseType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(foodGrainLicenseType);
		}

		objectOutput.writeLong(division);

		objectOutput.writeLong(district);

		objectOutput.writeLong(upzilla);

		objectOutput.writeLong(unionName);

		if (village == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(village);
		}

		if (ward == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ward);
		}

		if (zipCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(zipCode);
		}

		if (postOffice == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(postOffice);
		}

		if (houseAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(houseAddress);
		}

		if (password == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(password);
		}

		if (fatherName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fatherName);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (motherName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(motherName);
		}

		if (gender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gender);
		}

		if (maritalStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(maritalStatus);
		}

		objectOutput.writeLong(birthDate);

		if (mobileNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobileNo);
		}

		objectOutput.writeLong(userId);

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (nidDivision == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nidDivision);
		}

		if (nidDistrict == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nidDistrict);
		}

		if (nidUpzilla == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nidUpzilla);
		}

		if (nidUnion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nidUnion);
		}

		if (nidVillage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nidVillage);
		}

		if (nidWard == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nidWard);
		}

		if (nidZipCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nidZipCode);
		}

		if (nidPostOffice == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nidPostOffice);
		}

		if (nidHouseAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nidHouseAddress);
		}

		objectOutput.writeBoolean(isSubmit);

		if (electricExemptionMemo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(electricExemptionMemo);
		}

		if (envClrMemo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(envClrMemo);
		}

		if (bstiClrMemo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bstiClrMemo);
		}

		if (fireLicNumDoc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fireLicNumDoc);
		}

		if (productType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(productType);
		}
	}

	public long licUserId;
	public String nationalId;
	public String applicantName;
	public String tradeLicenseNo;
	public long tradeLicenseExpiryDate;
	public String tradeLicenseIssuerCode;
	public String tradeLicenseIssuerCity;
	public String businessIdentificationNo;
	public String taxIdentificationNo;
	public String businessName;
	public String businessType;
	public long businessDivision;
	public long businessDistrict;
	public long businessUpzilla;
	public long businessUnionName;
	public String businessVillage;
	public String businessWard;
	public String businessZipCode;
	public String businessPostOffice;
	public String businessHouseAddress;
	public String photographFile;
	public String tradeLicDoc;
	public String binDoc;
	public String tinDoc;
	public String bankStat;
	public String otherReleventDoc;
	public String comments;
	public String foodGrainLicenseType;
	public long division;
	public long district;
	public long upzilla;
	public long unionName;
	public String village;
	public String ward;
	public String zipCode;
	public String postOffice;
	public String houseAddress;
	public String password;
	public String fatherName;
	public String lastName;
	public String motherName;
	public String gender;
	public String maritalStatus;
	public long birthDate;
	public String mobileNo;
	public long userId;
	public String email;
	public String nidDivision;
	public String nidDistrict;
	public String nidUpzilla;
	public String nidUnion;
	public String nidVillage;
	public String nidWard;
	public String nidZipCode;
	public String nidPostOffice;
	public String nidHouseAddress;
	public boolean isSubmit;
	public String electricExemptionMemo;
	public String envClrMemo;
	public String bstiClrMemo;
	public String fireLicNumDoc;
	public String productType;

}