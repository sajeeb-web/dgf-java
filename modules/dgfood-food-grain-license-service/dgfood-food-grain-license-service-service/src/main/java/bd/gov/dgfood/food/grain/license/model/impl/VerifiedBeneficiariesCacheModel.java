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

import bd.gov.dgfood.food.grain.license.model.VerifiedBeneficiaries;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VerifiedBeneficiaries in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class VerifiedBeneficiariesCacheModel
	implements CacheModel<VerifiedBeneficiaries>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof VerifiedBeneficiariesCacheModel)) {
			return false;
		}

		VerifiedBeneficiariesCacheModel verifiedBeneficiariesCacheModel =
			(VerifiedBeneficiariesCacheModel)object;

		if (id == verifiedBeneficiariesCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(129);

		sb.append("{id=");
		sb.append(id);
		sb.append(", bsbVerified=");
		sb.append(bsbVerified);
		sb.append(", cardNo=");
		sb.append(cardNo);
		sb.append(", createdAt=");
		sb.append(createdAt);
		sb.append(", dateOfBirth=");
		sb.append(dateOfBirth);
		sb.append(", dealerId=");
		sb.append(dealerId);
		sb.append(", districtId=");
		sb.append(districtId);
		sb.append(", divisionId=");
		sb.append(divisionId);
		sb.append(", ecBeneficiaryName=");
		sb.append(ecBeneficiaryName);
		sb.append(", ecBeneficiaryNameEn=");
		sb.append(ecBeneficiaryNameEn);
		sb.append(", ecBloodGroup=");
		sb.append(ecBloodGroup);
		sb.append(", ecFatherName=");
		sb.append(ecFatherName);
		sb.append(", ecGender=");
		sb.append(ecGender);
		sb.append(", ecMobileNo=");
		sb.append(ecMobileNo);
		sb.append(", ecMotherName=");
		sb.append(ecMotherName);
		sb.append(", ecOccupation=");
		sb.append(ecOccupation);
		sb.append(", ecPmAdditionalMouzaMoholla=");
		sb.append(ecPmAdditionalMouzaMoholla);
		sb.append(", ecPmAdditionalVillageRoad=");
		sb.append(ecPmAdditionalVillageRoad);
		sb.append(", ecPmDistrict=");
		sb.append(ecPmDistrict);
		sb.append(", ecPmDivision=");
		sb.append(ecPmDivision);
		sb.append(", ecPmHomeHoldingNo=");
		sb.append(ecPmHomeHoldingNo);
		sb.append(", ecPmMouzaMoholla=");
		sb.append(ecPmMouzaMoholla);
		sb.append(", ecPmPostalCode=");
		sb.append(ecPmPostalCode);
		sb.append(", ecPmPostOffice=");
		sb.append(ecPmPostOffice);
		sb.append(", ecPmRegion=");
		sb.append(ecPmRegion);
		sb.append(", ecPmRmo=");
		sb.append(ecPmRmo);
		sb.append(", ecPmUnionWard=");
		sb.append(ecPmUnionWard);
		sb.append(", ecPmUpazila=");
		sb.append(ecPmUpazila);
		sb.append(", ecPmVillageRoad=");
		sb.append(ecPmVillageRoad);
		sb.append(", ecPmWardUnionPorishod=");
		sb.append(ecPmWardUnionPorishod);
		sb.append(", ecPrAdditionalMouzaMoholla=");
		sb.append(ecPrAdditionalMouzaMoholla);
		sb.append(", ecPrAdditionalVillageRoad=");
		sb.append(ecPrAdditionalVillageRoad);
		sb.append(", ecPrCityCorpMunicipality=");
		sb.append(ecPrCityCorpMunicipality);
		sb.append(", ecPrDistrict=");
		sb.append(ecPrDistrict);
		sb.append(", ecPrDivision=");
		sb.append(ecPrDivision);
		sb.append(", ecPrHomeHoldingNo=");
		sb.append(ecPrHomeHoldingNo);
		sb.append(", ecPrMouzaMoholla=");
		sb.append(ecPrMouzaMoholla);
		sb.append(", ecPrPostalCode=");
		sb.append(ecPrPostalCode);
		sb.append(", ecPrPostOffice=");
		sb.append(ecPrPostOffice);
		sb.append(", ecPrRegion=");
		sb.append(ecPrRegion);
		sb.append(", ecPrRmo=");
		sb.append(ecPrRmo);
		sb.append(", ecPrUnionWard=");
		sb.append(ecPrUnionWard);
		sb.append(", ecPrUpazila=");
		sb.append(ecPrUpazila);
		sb.append(", ecPrVillageRoad=");
		sb.append(ecPrVillageRoad);
		sb.append(", ecPrWardUnionPorishod=");
		sb.append(ecPrWardUnionPorishod);
		sb.append(", ecSpouseName=");
		sb.append(ecSpouseName);
		sb.append(", ecVerified=");
		sb.append(ecVerified);
		sb.append(", finalStatus=");
		sb.append(finalStatus);
		sb.append(", givenMobileNo=");
		sb.append(givenMobileNo);
		sb.append(", imagePathEc=");
		sb.append(imagePathEc);
		sb.append(", imagePathReal=");
		sb.append(imagePathReal);
		sb.append(", nationalId=");
		sb.append(nationalId);
		sb.append(", newCardNumber=");
		sb.append(newCardNumber);
		sb.append(", rawDataId=");
		sb.append(rawDataId);
		sb.append(", remarks=");
		sb.append(remarks);
		sb.append(", secondNationalId=");
		sb.append(secondNationalId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", ucfVerifiedDate=");
		sb.append(ucfVerifiedDate);
		sb.append(", unionId=");
		sb.append(unionId);
		sb.append(", upazilaId=");
		sb.append(upazilaId);
		sb.append(", updatedAt=");
		sb.append(updatedAt);
		sb.append(", verifiedBy=");
		sb.append(verifiedBy);
		sb.append(", verifiedDate=");
		sb.append(verifiedDate);
		sb.append(", vgdStatus=");
		sb.append(vgdStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VerifiedBeneficiaries toEntityModel() {
		VerifiedBeneficiariesImpl verifiedBeneficiariesImpl =
			new VerifiedBeneficiariesImpl();

		verifiedBeneficiariesImpl.setId(id);
		verifiedBeneficiariesImpl.setBsbVerified(bsbVerified);
		verifiedBeneficiariesImpl.setCardNo(cardNo);

		if (createdAt == Long.MIN_VALUE) {
			verifiedBeneficiariesImpl.setCreatedAt(null);
		}
		else {
			verifiedBeneficiariesImpl.setCreatedAt(new Date(createdAt));
		}

		if (dateOfBirth == null) {
			verifiedBeneficiariesImpl.setDateOfBirth("");
		}
		else {
			verifiedBeneficiariesImpl.setDateOfBirth(dateOfBirth);
		}

		verifiedBeneficiariesImpl.setDealerId(dealerId);
		verifiedBeneficiariesImpl.setDistrictId(districtId);
		verifiedBeneficiariesImpl.setDivisionId(divisionId);

		if (ecBeneficiaryName == null) {
			verifiedBeneficiariesImpl.setEcBeneficiaryName("");
		}
		else {
			verifiedBeneficiariesImpl.setEcBeneficiaryName(ecBeneficiaryName);
		}

		if (ecBeneficiaryNameEn == null) {
			verifiedBeneficiariesImpl.setEcBeneficiaryNameEn("");
		}
		else {
			verifiedBeneficiariesImpl.setEcBeneficiaryNameEn(
				ecBeneficiaryNameEn);
		}

		if (ecBloodGroup == null) {
			verifiedBeneficiariesImpl.setEcBloodGroup("");
		}
		else {
			verifiedBeneficiariesImpl.setEcBloodGroup(ecBloodGroup);
		}

		if (ecFatherName == null) {
			verifiedBeneficiariesImpl.setEcFatherName("");
		}
		else {
			verifiedBeneficiariesImpl.setEcFatherName(ecFatherName);
		}

		if (ecGender == null) {
			verifiedBeneficiariesImpl.setEcGender("");
		}
		else {
			verifiedBeneficiariesImpl.setEcGender(ecGender);
		}

		if (ecMobileNo == null) {
			verifiedBeneficiariesImpl.setEcMobileNo("");
		}
		else {
			verifiedBeneficiariesImpl.setEcMobileNo(ecMobileNo);
		}

		if (ecMotherName == null) {
			verifiedBeneficiariesImpl.setEcMotherName("");
		}
		else {
			verifiedBeneficiariesImpl.setEcMotherName(ecMotherName);
		}

		if (ecOccupation == null) {
			verifiedBeneficiariesImpl.setEcOccupation("");
		}
		else {
			verifiedBeneficiariesImpl.setEcOccupation(ecOccupation);
		}

		if (ecPmAdditionalMouzaMoholla == null) {
			verifiedBeneficiariesImpl.setEcPmAdditionalMouzaMoholla("");
		}
		else {
			verifiedBeneficiariesImpl.setEcPmAdditionalMouzaMoholla(
				ecPmAdditionalMouzaMoholla);
		}

		if (ecPmAdditionalVillageRoad == null) {
			verifiedBeneficiariesImpl.setEcPmAdditionalVillageRoad("");
		}
		else {
			verifiedBeneficiariesImpl.setEcPmAdditionalVillageRoad(
				ecPmAdditionalVillageRoad);
		}

		if (ecPmDistrict == null) {
			verifiedBeneficiariesImpl.setEcPmDistrict("");
		}
		else {
			verifiedBeneficiariesImpl.setEcPmDistrict(ecPmDistrict);
		}

		if (ecPmDivision == null) {
			verifiedBeneficiariesImpl.setEcPmDivision("");
		}
		else {
			verifiedBeneficiariesImpl.setEcPmDivision(ecPmDivision);
		}

		if (ecPmHomeHoldingNo == null) {
			verifiedBeneficiariesImpl.setEcPmHomeHoldingNo("");
		}
		else {
			verifiedBeneficiariesImpl.setEcPmHomeHoldingNo(ecPmHomeHoldingNo);
		}

		if (ecPmMouzaMoholla == null) {
			verifiedBeneficiariesImpl.setEcPmMouzaMoholla("");
		}
		else {
			verifiedBeneficiariesImpl.setEcPmMouzaMoholla(ecPmMouzaMoholla);
		}

		if (ecPmPostalCode == null) {
			verifiedBeneficiariesImpl.setEcPmPostalCode("");
		}
		else {
			verifiedBeneficiariesImpl.setEcPmPostalCode(ecPmPostalCode);
		}

		if (ecPmPostOffice == null) {
			verifiedBeneficiariesImpl.setEcPmPostOffice("");
		}
		else {
			verifiedBeneficiariesImpl.setEcPmPostOffice(ecPmPostOffice);
		}

		if (ecPmRegion == null) {
			verifiedBeneficiariesImpl.setEcPmRegion("");
		}
		else {
			verifiedBeneficiariesImpl.setEcPmRegion(ecPmRegion);
		}

		if (ecPmRmo == null) {
			verifiedBeneficiariesImpl.setEcPmRmo("");
		}
		else {
			verifiedBeneficiariesImpl.setEcPmRmo(ecPmRmo);
		}

		if (ecPmUnionWard == null) {
			verifiedBeneficiariesImpl.setEcPmUnionWard("");
		}
		else {
			verifiedBeneficiariesImpl.setEcPmUnionWard(ecPmUnionWard);
		}

		if (ecPmUpazila == null) {
			verifiedBeneficiariesImpl.setEcPmUpazila("");
		}
		else {
			verifiedBeneficiariesImpl.setEcPmUpazila(ecPmUpazila);
		}

		if (ecPmVillageRoad == null) {
			verifiedBeneficiariesImpl.setEcPmVillageRoad("");
		}
		else {
			verifiedBeneficiariesImpl.setEcPmVillageRoad(ecPmVillageRoad);
		}

		if (ecPmWardUnionPorishod == null) {
			verifiedBeneficiariesImpl.setEcPmWardUnionPorishod("");
		}
		else {
			verifiedBeneficiariesImpl.setEcPmWardUnionPorishod(
				ecPmWardUnionPorishod);
		}

		if (ecPrAdditionalMouzaMoholla == null) {
			verifiedBeneficiariesImpl.setEcPrAdditionalMouzaMoholla("");
		}
		else {
			verifiedBeneficiariesImpl.setEcPrAdditionalMouzaMoholla(
				ecPrAdditionalMouzaMoholla);
		}

		if (ecPrAdditionalVillageRoad == null) {
			verifiedBeneficiariesImpl.setEcPrAdditionalVillageRoad("");
		}
		else {
			verifiedBeneficiariesImpl.setEcPrAdditionalVillageRoad(
				ecPrAdditionalVillageRoad);
		}

		if (ecPrCityCorpMunicipality == null) {
			verifiedBeneficiariesImpl.setEcPrCityCorpMunicipality("");
		}
		else {
			verifiedBeneficiariesImpl.setEcPrCityCorpMunicipality(
				ecPrCityCorpMunicipality);
		}

		if (ecPrDistrict == null) {
			verifiedBeneficiariesImpl.setEcPrDistrict("");
		}
		else {
			verifiedBeneficiariesImpl.setEcPrDistrict(ecPrDistrict);
		}

		if (ecPrDivision == null) {
			verifiedBeneficiariesImpl.setEcPrDivision("");
		}
		else {
			verifiedBeneficiariesImpl.setEcPrDivision(ecPrDivision);
		}

		if (ecPrHomeHoldingNo == null) {
			verifiedBeneficiariesImpl.setEcPrHomeHoldingNo("");
		}
		else {
			verifiedBeneficiariesImpl.setEcPrHomeHoldingNo(ecPrHomeHoldingNo);
		}

		if (ecPrMouzaMoholla == null) {
			verifiedBeneficiariesImpl.setEcPrMouzaMoholla("");
		}
		else {
			verifiedBeneficiariesImpl.setEcPrMouzaMoholla(ecPrMouzaMoholla);
		}

		if (ecPrPostalCode == null) {
			verifiedBeneficiariesImpl.setEcPrPostalCode("");
		}
		else {
			verifiedBeneficiariesImpl.setEcPrPostalCode(ecPrPostalCode);
		}

		if (ecPrPostOffice == null) {
			verifiedBeneficiariesImpl.setEcPrPostOffice("");
		}
		else {
			verifiedBeneficiariesImpl.setEcPrPostOffice(ecPrPostOffice);
		}

		if (ecPrRegion == null) {
			verifiedBeneficiariesImpl.setEcPrRegion("");
		}
		else {
			verifiedBeneficiariesImpl.setEcPrRegion(ecPrRegion);
		}

		if (ecPrRmo == null) {
			verifiedBeneficiariesImpl.setEcPrRmo("");
		}
		else {
			verifiedBeneficiariesImpl.setEcPrRmo(ecPrRmo);
		}

		if (ecPrUnionWard == null) {
			verifiedBeneficiariesImpl.setEcPrUnionWard("");
		}
		else {
			verifiedBeneficiariesImpl.setEcPrUnionWard(ecPrUnionWard);
		}

		if (ecPrUpazila == null) {
			verifiedBeneficiariesImpl.setEcPrUpazila("");
		}
		else {
			verifiedBeneficiariesImpl.setEcPrUpazila(ecPrUpazila);
		}

		if (ecPrVillageRoad == null) {
			verifiedBeneficiariesImpl.setEcPrVillageRoad("");
		}
		else {
			verifiedBeneficiariesImpl.setEcPrVillageRoad(ecPrVillageRoad);
		}

		if (ecPrWardUnionPorishod == null) {
			verifiedBeneficiariesImpl.setEcPrWardUnionPorishod("");
		}
		else {
			verifiedBeneficiariesImpl.setEcPrWardUnionPorishod(
				ecPrWardUnionPorishod);
		}

		if (ecSpouseName == null) {
			verifiedBeneficiariesImpl.setEcSpouseName("");
		}
		else {
			verifiedBeneficiariesImpl.setEcSpouseName(ecSpouseName);
		}

		verifiedBeneficiariesImpl.setEcVerified(ecVerified);
		verifiedBeneficiariesImpl.setFinalStatus(finalStatus);

		if (givenMobileNo == null) {
			verifiedBeneficiariesImpl.setGivenMobileNo("");
		}
		else {
			verifiedBeneficiariesImpl.setGivenMobileNo(givenMobileNo);
		}

		if (imagePathEc == null) {
			verifiedBeneficiariesImpl.setImagePathEc("");
		}
		else {
			verifiedBeneficiariesImpl.setImagePathEc(imagePathEc);
		}

		if (imagePathReal == null) {
			verifiedBeneficiariesImpl.setImagePathReal("");
		}
		else {
			verifiedBeneficiariesImpl.setImagePathReal(imagePathReal);
		}

		if (nationalId == null) {
			verifiedBeneficiariesImpl.setNationalId("");
		}
		else {
			verifiedBeneficiariesImpl.setNationalId(nationalId);
		}

		verifiedBeneficiariesImpl.setNewCardNumber(newCardNumber);
		verifiedBeneficiariesImpl.setRawDataId(rawDataId);

		if (remarks == null) {
			verifiedBeneficiariesImpl.setRemarks("");
		}
		else {
			verifiedBeneficiariesImpl.setRemarks(remarks);
		}

		if (secondNationalId == null) {
			verifiedBeneficiariesImpl.setSecondNationalId("");
		}
		else {
			verifiedBeneficiariesImpl.setSecondNationalId(secondNationalId);
		}

		verifiedBeneficiariesImpl.setStatus(status);

		if (ucfVerifiedDate == Long.MIN_VALUE) {
			verifiedBeneficiariesImpl.setUcfVerifiedDate(null);
		}
		else {
			verifiedBeneficiariesImpl.setUcfVerifiedDate(
				new Date(ucfVerifiedDate));
		}

		verifiedBeneficiariesImpl.setUnionId(unionId);
		verifiedBeneficiariesImpl.setUpazilaId(upazilaId);

		if (updatedAt == Long.MIN_VALUE) {
			verifiedBeneficiariesImpl.setUpdatedAt(null);
		}
		else {
			verifiedBeneficiariesImpl.setUpdatedAt(new Date(updatedAt));
		}

		verifiedBeneficiariesImpl.setVerifiedBy(verifiedBy);

		if (verifiedDate == Long.MIN_VALUE) {
			verifiedBeneficiariesImpl.setVerifiedDate(null);
		}
		else {
			verifiedBeneficiariesImpl.setVerifiedDate(new Date(verifiedDate));
		}

		verifiedBeneficiariesImpl.setVgdStatus(vgdStatus);

		verifiedBeneficiariesImpl.resetOriginalValues();

		return verifiedBeneficiariesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		bsbVerified = objectInput.readInt();

		cardNo = objectInput.readLong();
		createdAt = objectInput.readLong();
		dateOfBirth = objectInput.readUTF();

		dealerId = objectInput.readLong();

		districtId = objectInput.readLong();

		divisionId = objectInput.readLong();
		ecBeneficiaryName = objectInput.readUTF();
		ecBeneficiaryNameEn = objectInput.readUTF();
		ecBloodGroup = objectInput.readUTF();
		ecFatherName = objectInput.readUTF();
		ecGender = objectInput.readUTF();
		ecMobileNo = objectInput.readUTF();
		ecMotherName = objectInput.readUTF();
		ecOccupation = objectInput.readUTF();
		ecPmAdditionalMouzaMoholla = objectInput.readUTF();
		ecPmAdditionalVillageRoad = objectInput.readUTF();
		ecPmDistrict = objectInput.readUTF();
		ecPmDivision = objectInput.readUTF();
		ecPmHomeHoldingNo = objectInput.readUTF();
		ecPmMouzaMoholla = objectInput.readUTF();
		ecPmPostalCode = objectInput.readUTF();
		ecPmPostOffice = objectInput.readUTF();
		ecPmRegion = objectInput.readUTF();
		ecPmRmo = objectInput.readUTF();
		ecPmUnionWard = objectInput.readUTF();
		ecPmUpazila = objectInput.readUTF();
		ecPmVillageRoad = objectInput.readUTF();
		ecPmWardUnionPorishod = objectInput.readUTF();
		ecPrAdditionalMouzaMoholla = objectInput.readUTF();
		ecPrAdditionalVillageRoad = objectInput.readUTF();
		ecPrCityCorpMunicipality = objectInput.readUTF();
		ecPrDistrict = objectInput.readUTF();
		ecPrDivision = objectInput.readUTF();
		ecPrHomeHoldingNo = objectInput.readUTF();
		ecPrMouzaMoholla = objectInput.readUTF();
		ecPrPostalCode = objectInput.readUTF();
		ecPrPostOffice = objectInput.readUTF();
		ecPrRegion = objectInput.readUTF();
		ecPrRmo = objectInput.readUTF();
		ecPrUnionWard = objectInput.readUTF();
		ecPrUpazila = objectInput.readUTF();
		ecPrVillageRoad = objectInput.readUTF();
		ecPrWardUnionPorishod = objectInput.readUTF();
		ecSpouseName = objectInput.readUTF();

		ecVerified = objectInput.readInt();

		finalStatus = objectInput.readLong();
		givenMobileNo = objectInput.readUTF();
		imagePathEc = objectInput.readUTF();
		imagePathReal = objectInput.readUTF();
		nationalId = objectInput.readUTF();

		newCardNumber = objectInput.readLong();

		rawDataId = objectInput.readLong();
		remarks = objectInput.readUTF();
		secondNationalId = objectInput.readUTF();

		status = objectInput.readLong();
		ucfVerifiedDate = objectInput.readLong();

		unionId = objectInput.readLong();

		upazilaId = objectInput.readLong();
		updatedAt = objectInput.readLong();

		verifiedBy = objectInput.readLong();
		verifiedDate = objectInput.readLong();

		vgdStatus = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeInt(bsbVerified);

		objectOutput.writeLong(cardNo);
		objectOutput.writeLong(createdAt);

		if (dateOfBirth == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dateOfBirth);
		}

		objectOutput.writeLong(dealerId);

		objectOutput.writeLong(districtId);

		objectOutput.writeLong(divisionId);

		if (ecBeneficiaryName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecBeneficiaryName);
		}

		if (ecBeneficiaryNameEn == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecBeneficiaryNameEn);
		}

		if (ecBloodGroup == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecBloodGroup);
		}

		if (ecFatherName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecFatherName);
		}

		if (ecGender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecGender);
		}

		if (ecMobileNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecMobileNo);
		}

		if (ecMotherName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecMotherName);
		}

		if (ecOccupation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecOccupation);
		}

		if (ecPmAdditionalMouzaMoholla == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPmAdditionalMouzaMoholla);
		}

		if (ecPmAdditionalVillageRoad == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPmAdditionalVillageRoad);
		}

		if (ecPmDistrict == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPmDistrict);
		}

		if (ecPmDivision == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPmDivision);
		}

		if (ecPmHomeHoldingNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPmHomeHoldingNo);
		}

		if (ecPmMouzaMoholla == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPmMouzaMoholla);
		}

		if (ecPmPostalCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPmPostalCode);
		}

		if (ecPmPostOffice == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPmPostOffice);
		}

		if (ecPmRegion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPmRegion);
		}

		if (ecPmRmo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPmRmo);
		}

		if (ecPmUnionWard == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPmUnionWard);
		}

		if (ecPmUpazila == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPmUpazila);
		}

		if (ecPmVillageRoad == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPmVillageRoad);
		}

		if (ecPmWardUnionPorishod == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPmWardUnionPorishod);
		}

		if (ecPrAdditionalMouzaMoholla == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPrAdditionalMouzaMoholla);
		}

		if (ecPrAdditionalVillageRoad == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPrAdditionalVillageRoad);
		}

		if (ecPrCityCorpMunicipality == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPrCityCorpMunicipality);
		}

		if (ecPrDistrict == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPrDistrict);
		}

		if (ecPrDivision == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPrDivision);
		}

		if (ecPrHomeHoldingNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPrHomeHoldingNo);
		}

		if (ecPrMouzaMoholla == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPrMouzaMoholla);
		}

		if (ecPrPostalCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPrPostalCode);
		}

		if (ecPrPostOffice == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPrPostOffice);
		}

		if (ecPrRegion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPrRegion);
		}

		if (ecPrRmo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPrRmo);
		}

		if (ecPrUnionWard == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPrUnionWard);
		}

		if (ecPrUpazila == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPrUpazila);
		}

		if (ecPrVillageRoad == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPrVillageRoad);
		}

		if (ecPrWardUnionPorishod == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPrWardUnionPorishod);
		}

		if (ecSpouseName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecSpouseName);
		}

		objectOutput.writeInt(ecVerified);

		objectOutput.writeLong(finalStatus);

		if (givenMobileNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(givenMobileNo);
		}

		if (imagePathEc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(imagePathEc);
		}

		if (imagePathReal == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(imagePathReal);
		}

		if (nationalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationalId);
		}

		objectOutput.writeLong(newCardNumber);

		objectOutput.writeLong(rawDataId);

		if (remarks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(remarks);
		}

		if (secondNationalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(secondNationalId);
		}

		objectOutput.writeLong(status);
		objectOutput.writeLong(ucfVerifiedDate);

		objectOutput.writeLong(unionId);

		objectOutput.writeLong(upazilaId);
		objectOutput.writeLong(updatedAt);

		objectOutput.writeLong(verifiedBy);
		objectOutput.writeLong(verifiedDate);

		objectOutput.writeInt(vgdStatus);
	}

	public long id;
	public int bsbVerified;
	public long cardNo;
	public long createdAt;
	public String dateOfBirth;
	public long dealerId;
	public long districtId;
	public long divisionId;
	public String ecBeneficiaryName;
	public String ecBeneficiaryNameEn;
	public String ecBloodGroup;
	public String ecFatherName;
	public String ecGender;
	public String ecMobileNo;
	public String ecMotherName;
	public String ecOccupation;
	public String ecPmAdditionalMouzaMoholla;
	public String ecPmAdditionalVillageRoad;
	public String ecPmDistrict;
	public String ecPmDivision;
	public String ecPmHomeHoldingNo;
	public String ecPmMouzaMoholla;
	public String ecPmPostalCode;
	public String ecPmPostOffice;
	public String ecPmRegion;
	public String ecPmRmo;
	public String ecPmUnionWard;
	public String ecPmUpazila;
	public String ecPmVillageRoad;
	public String ecPmWardUnionPorishod;
	public String ecPrAdditionalMouzaMoholla;
	public String ecPrAdditionalVillageRoad;
	public String ecPrCityCorpMunicipality;
	public String ecPrDistrict;
	public String ecPrDivision;
	public String ecPrHomeHoldingNo;
	public String ecPrMouzaMoholla;
	public String ecPrPostalCode;
	public String ecPrPostOffice;
	public String ecPrRegion;
	public String ecPrRmo;
	public String ecPrUnionWard;
	public String ecPrUpazila;
	public String ecPrVillageRoad;
	public String ecPrWardUnionPorishod;
	public String ecSpouseName;
	public int ecVerified;
	public long finalStatus;
	public String givenMobileNo;
	public String imagePathEc;
	public String imagePathReal;
	public String nationalId;
	public long newCardNumber;
	public long rawDataId;
	public String remarks;
	public String secondNationalId;
	public long status;
	public long ucfVerifiedDate;
	public long unionId;
	public long upazilaId;
	public long updatedAt;
	public long verifiedBy;
	public long verifiedDate;
	public int vgdStatus;

}