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

import bd.gov.dgfood.food.grain.license.model.DealerMasters;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DealerMasters in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DealerMastersCacheModel
	implements CacheModel<DealerMasters>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DealerMastersCacheModel)) {
			return false;
		}

		DealerMastersCacheModel dealerMastersCacheModel =
			(DealerMastersCacheModel)object;

		if (id == dealerMastersCacheModel.id) {
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
		StringBundler sb = new StringBundler(179);

		sb.append("{id=");
		sb.append(id);
		sb.append(", unionId=");
		sb.append(unionId);
		sb.append(", dealerName=");
		sb.append(dealerName);
		sb.append(", dealerNameEn=");
		sb.append(dealerNameEn);
		sb.append(", dealerSlug=");
		sb.append(dealerSlug);
		sb.append(", fatherName=");
		sb.append(fatherName);
		sb.append(", motherName=");
		sb.append(motherName);
		sb.append(", birthDate=");
		sb.append(birthDate);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", imagePathReal=");
		sb.append(imagePathReal);
		sb.append(", imagePathEc=");
		sb.append(imagePathEc);
		sb.append(", ecPmDivision=");
		sb.append(ecPmDivision);
		sb.append(", ecPmDistrict=");
		sb.append(ecPmDistrict);
		sb.append(", ecPmRmo=");
		sb.append(ecPmRmo);
		sb.append(", ecPmUpazila=");
		sb.append(ecPmUpazila);
		sb.append(", ecPmUnionWard=");
		sb.append(ecPmUnionWard);
		sb.append(", ecPmWardUnionPorishod=");
		sb.append(ecPmWardUnionPorishod);
		sb.append(", ecPmPostOffice=");
		sb.append(ecPmPostOffice);
		sb.append(", ecPmPostalCode=");
		sb.append(ecPmPostalCode);
		sb.append(", ecPmMouzaMoholla=");
		sb.append(ecPmMouzaMoholla);
		sb.append(", ecPmAdditionalMouzaMoholla=");
		sb.append(ecPmAdditionalMouzaMoholla);
		sb.append(", ecPmVillageRoad=");
		sb.append(ecPmVillageRoad);
		sb.append(", ecPmAdditionalVillageRoad=");
		sb.append(ecPmAdditionalVillageRoad);
		sb.append(", ecPmHomeHoldingNo=");
		sb.append(ecPmHomeHoldingNo);
		sb.append(", ecPmRegion=");
		sb.append(ecPmRegion);
		sb.append(", ecPrDivision=");
		sb.append(ecPrDivision);
		sb.append(", ecPrDistrict=");
		sb.append(ecPrDistrict);
		sb.append(", ecPrRmo=");
		sb.append(ecPrRmo);
		sb.append(", ecPrUpazila=");
		sb.append(ecPrUpazila);
		sb.append(", ecPrCityCorpMunicipality=");
		sb.append(ecPrCityCorpMunicipality);
		sb.append(", ecPrUnionWard=");
		sb.append(ecPrUnionWard);
		sb.append(", ecPrPostOffice=");
		sb.append(ecPrPostOffice);
		sb.append(", ecPrPostalCode=");
		sb.append(ecPrPostalCode);
		sb.append(", ecPrWardUnionPorishod=");
		sb.append(ecPrWardUnionPorishod);
		sb.append(", ecPrMouzaMoholla=");
		sb.append(ecPrMouzaMoholla);
		sb.append(", ecPrAdditionalMouzaMoholla=");
		sb.append(ecPrAdditionalMouzaMoholla);
		sb.append(", ecPrVillageRoad=");
		sb.append(ecPrVillageRoad);
		sb.append(", ecPrAdditionalVillageRoad=");
		sb.append(ecPrAdditionalVillageRoad);
		sb.append(", ecPrHomeHoldingNo=");
		sb.append(ecPrHomeHoldingNo);
		sb.append(", ecPrRegion=");
		sb.append(ecPrRegion);
		sb.append(", ecOccupation=");
		sb.append(ecOccupation);
		sb.append(", ecBloodGroup=");
		sb.append(ecBloodGroup);
		sb.append(", age=");
		sb.append(age);
		sb.append(", pmDivisionId=");
		sb.append(pmDivisionId);
		sb.append(", pmDistrictId=");
		sb.append(pmDistrictId);
		sb.append(", pmUpazilaId=");
		sb.append(pmUpazilaId);
		sb.append(", pmUnionId=");
		sb.append(pmUnionId);
		sb.append(", pmPostOffice=");
		sb.append(pmPostOffice);
		sb.append(", pmWordNo=");
		sb.append(pmWordNo);
		sb.append(", pmVillage=");
		sb.append(pmVillage);
		sb.append(", pmHoldingInfo=");
		sb.append(pmHoldingInfo);
		sb.append(", prDivisionId=");
		sb.append(prDivisionId);
		sb.append(", prDistrictId=");
		sb.append(prDistrictId);
		sb.append(", prUpazilaId=");
		sb.append(prUpazilaId);
		sb.append(", prUnionId=");
		sb.append(prUnionId);
		sb.append(", prPostOffice=");
		sb.append(prPostOffice);
		sb.append(", prWordNo=");
		sb.append(prWordNo);
		sb.append(", prVillage=");
		sb.append(prVillage);
		sb.append(", prHoldingInfo=");
		sb.append(prHoldingInfo);
		sb.append(", dealerMobileNo=");
		sb.append(dealerMobileNo);
		sb.append(", dealerNationalId=");
		sb.append(dealerNationalId);
		sb.append(", secondNationalId=");
		sb.append(secondNationalId);
		sb.append(", spouseName=");
		sb.append(spouseName);
		sb.append(", spouseFatherName=");
		sb.append(spouseFatherName);
		sb.append(", spouseBirthDate=");
		sb.append(spouseBirthDate);
		sb.append(", spouseNid=");
		sb.append(spouseNid);
		sb.append(", spouseSecondNid=");
		sb.append(spouseSecondNid);
		sb.append(", govtEmployee=");
		sb.append(govtEmployee);
		sb.append(", handicap=");
		sb.append(handicap);
		sb.append(", publicRepresentative=");
		sb.append(publicRepresentative);
		sb.append(", vgdStatus=");
		sb.append(vgdStatus);
		sb.append(", cardNoFromOne=");
		sb.append(cardNoFromOne);
		sb.append(", cardNoToOne=");
		sb.append(cardNoToOne);
		sb.append(", cardNoFromTwo=");
		sb.append(cardNoFromTwo);
		sb.append(", cardNoToTwo=");
		sb.append(cardNoToTwo);
		sb.append(", cardNoFromThree=");
		sb.append(cardNoFromThree);
		sb.append(", cardNoToThree=");
		sb.append(cardNoToThree);
		sb.append(", status=");
		sb.append(status);
		sb.append(", createdAt=");
		sb.append(createdAt);
		sb.append(", updatedAt=");
		sb.append(updatedAt);
		sb.append(", cardNoFromFour=");
		sb.append(cardNoFromFour);
		sb.append(", cardNoToFour=");
		sb.append(cardNoToFour);
		sb.append(", cardNoFromFive=");
		sb.append(cardNoFromFive);
		sb.append(", cardNoToFive=");
		sb.append(cardNoToFive);
		sb.append(", singleCards=");
		sb.append(singleCards);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", additionalUnionId=");
		sb.append(additionalUnionId);
		sb.append(", upazilaId=");
		sb.append(upazilaId);
		sb.append(", remarks=");
		sb.append(remarks);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DealerMasters toEntityModel() {
		DealerMastersImpl dealerMastersImpl = new DealerMastersImpl();

		dealerMastersImpl.setId(id);
		dealerMastersImpl.setUnionId(unionId);

		if (dealerName == null) {
			dealerMastersImpl.setDealerName("");
		}
		else {
			dealerMastersImpl.setDealerName(dealerName);
		}

		if (dealerNameEn == null) {
			dealerMastersImpl.setDealerNameEn("");
		}
		else {
			dealerMastersImpl.setDealerNameEn(dealerNameEn);
		}

		if (dealerSlug == null) {
			dealerMastersImpl.setDealerSlug("");
		}
		else {
			dealerMastersImpl.setDealerSlug(dealerSlug);
		}

		if (fatherName == null) {
			dealerMastersImpl.setFatherName("");
		}
		else {
			dealerMastersImpl.setFatherName(fatherName);
		}

		if (motherName == null) {
			dealerMastersImpl.setMotherName("");
		}
		else {
			dealerMastersImpl.setMotherName(motherName);
		}

		if (birthDate == Long.MIN_VALUE) {
			dealerMastersImpl.setBirthDate(null);
		}
		else {
			dealerMastersImpl.setBirthDate(new Date(birthDate));
		}

		if (gender == null) {
			dealerMastersImpl.setGender("");
		}
		else {
			dealerMastersImpl.setGender(gender);
		}

		if (imagePathReal == null) {
			dealerMastersImpl.setImagePathReal("");
		}
		else {
			dealerMastersImpl.setImagePathReal(imagePathReal);
		}

		if (imagePathEc == null) {
			dealerMastersImpl.setImagePathEc("");
		}
		else {
			dealerMastersImpl.setImagePathEc(imagePathEc);
		}

		if (ecPmDivision == null) {
			dealerMastersImpl.setEcPmDivision("");
		}
		else {
			dealerMastersImpl.setEcPmDivision(ecPmDivision);
		}

		if (ecPmDistrict == null) {
			dealerMastersImpl.setEcPmDistrict("");
		}
		else {
			dealerMastersImpl.setEcPmDistrict(ecPmDistrict);
		}

		if (ecPmRmo == null) {
			dealerMastersImpl.setEcPmRmo("");
		}
		else {
			dealerMastersImpl.setEcPmRmo(ecPmRmo);
		}

		if (ecPmUpazila == null) {
			dealerMastersImpl.setEcPmUpazila("");
		}
		else {
			dealerMastersImpl.setEcPmUpazila(ecPmUpazila);
		}

		if (ecPmUnionWard == null) {
			dealerMastersImpl.setEcPmUnionWard("");
		}
		else {
			dealerMastersImpl.setEcPmUnionWard(ecPmUnionWard);
		}

		if (ecPmWardUnionPorishod == null) {
			dealerMastersImpl.setEcPmWardUnionPorishod("");
		}
		else {
			dealerMastersImpl.setEcPmWardUnionPorishod(ecPmWardUnionPorishod);
		}

		if (ecPmPostOffice == null) {
			dealerMastersImpl.setEcPmPostOffice("");
		}
		else {
			dealerMastersImpl.setEcPmPostOffice(ecPmPostOffice);
		}

		if (ecPmPostalCode == null) {
			dealerMastersImpl.setEcPmPostalCode("");
		}
		else {
			dealerMastersImpl.setEcPmPostalCode(ecPmPostalCode);
		}

		if (ecPmMouzaMoholla == null) {
			dealerMastersImpl.setEcPmMouzaMoholla("");
		}
		else {
			dealerMastersImpl.setEcPmMouzaMoholla(ecPmMouzaMoholla);
		}

		if (ecPmAdditionalMouzaMoholla == null) {
			dealerMastersImpl.setEcPmAdditionalMouzaMoholla("");
		}
		else {
			dealerMastersImpl.setEcPmAdditionalMouzaMoholla(
				ecPmAdditionalMouzaMoholla);
		}

		if (ecPmVillageRoad == null) {
			dealerMastersImpl.setEcPmVillageRoad("");
		}
		else {
			dealerMastersImpl.setEcPmVillageRoad(ecPmVillageRoad);
		}

		if (ecPmAdditionalVillageRoad == null) {
			dealerMastersImpl.setEcPmAdditionalVillageRoad("");
		}
		else {
			dealerMastersImpl.setEcPmAdditionalVillageRoad(
				ecPmAdditionalVillageRoad);
		}

		if (ecPmHomeHoldingNo == null) {
			dealerMastersImpl.setEcPmHomeHoldingNo("");
		}
		else {
			dealerMastersImpl.setEcPmHomeHoldingNo(ecPmHomeHoldingNo);
		}

		if (ecPmRegion == null) {
			dealerMastersImpl.setEcPmRegion("");
		}
		else {
			dealerMastersImpl.setEcPmRegion(ecPmRegion);
		}

		if (ecPrDivision == null) {
			dealerMastersImpl.setEcPrDivision("");
		}
		else {
			dealerMastersImpl.setEcPrDivision(ecPrDivision);
		}

		if (ecPrDistrict == null) {
			dealerMastersImpl.setEcPrDistrict("");
		}
		else {
			dealerMastersImpl.setEcPrDistrict(ecPrDistrict);
		}

		if (ecPrRmo == null) {
			dealerMastersImpl.setEcPrRmo("");
		}
		else {
			dealerMastersImpl.setEcPrRmo(ecPrRmo);
		}

		if (ecPrUpazila == null) {
			dealerMastersImpl.setEcPrUpazila("");
		}
		else {
			dealerMastersImpl.setEcPrUpazila(ecPrUpazila);
		}

		if (ecPrCityCorpMunicipality == null) {
			dealerMastersImpl.setEcPrCityCorpMunicipality("");
		}
		else {
			dealerMastersImpl.setEcPrCityCorpMunicipality(
				ecPrCityCorpMunicipality);
		}

		if (ecPrUnionWard == null) {
			dealerMastersImpl.setEcPrUnionWard("");
		}
		else {
			dealerMastersImpl.setEcPrUnionWard(ecPrUnionWard);
		}

		if (ecPrPostOffice == null) {
			dealerMastersImpl.setEcPrPostOffice("");
		}
		else {
			dealerMastersImpl.setEcPrPostOffice(ecPrPostOffice);
		}

		if (ecPrPostalCode == null) {
			dealerMastersImpl.setEcPrPostalCode("");
		}
		else {
			dealerMastersImpl.setEcPrPostalCode(ecPrPostalCode);
		}

		if (ecPrWardUnionPorishod == null) {
			dealerMastersImpl.setEcPrWardUnionPorishod("");
		}
		else {
			dealerMastersImpl.setEcPrWardUnionPorishod(ecPrWardUnionPorishod);
		}

		if (ecPrMouzaMoholla == null) {
			dealerMastersImpl.setEcPrMouzaMoholla("");
		}
		else {
			dealerMastersImpl.setEcPrMouzaMoholla(ecPrMouzaMoholla);
		}

		if (ecPrAdditionalMouzaMoholla == null) {
			dealerMastersImpl.setEcPrAdditionalMouzaMoholla("");
		}
		else {
			dealerMastersImpl.setEcPrAdditionalMouzaMoholla(
				ecPrAdditionalMouzaMoholla);
		}

		if (ecPrVillageRoad == null) {
			dealerMastersImpl.setEcPrVillageRoad("");
		}
		else {
			dealerMastersImpl.setEcPrVillageRoad(ecPrVillageRoad);
		}

		if (ecPrAdditionalVillageRoad == null) {
			dealerMastersImpl.setEcPrAdditionalVillageRoad("");
		}
		else {
			dealerMastersImpl.setEcPrAdditionalVillageRoad(
				ecPrAdditionalVillageRoad);
		}

		if (ecPrHomeHoldingNo == null) {
			dealerMastersImpl.setEcPrHomeHoldingNo("");
		}
		else {
			dealerMastersImpl.setEcPrHomeHoldingNo(ecPrHomeHoldingNo);
		}

		if (ecPrRegion == null) {
			dealerMastersImpl.setEcPrRegion("");
		}
		else {
			dealerMastersImpl.setEcPrRegion(ecPrRegion);
		}

		if (ecOccupation == null) {
			dealerMastersImpl.setEcOccupation("");
		}
		else {
			dealerMastersImpl.setEcOccupation(ecOccupation);
		}

		if (ecBloodGroup == null) {
			dealerMastersImpl.setEcBloodGroup("");
		}
		else {
			dealerMastersImpl.setEcBloodGroup(ecBloodGroup);
		}

		dealerMastersImpl.setAge(age);
		dealerMastersImpl.setPmDivisionId(pmDivisionId);
		dealerMastersImpl.setPmDistrictId(pmDistrictId);
		dealerMastersImpl.setPmUpazilaId(pmUpazilaId);
		dealerMastersImpl.setPmUnionId(pmUnionId);

		if (pmPostOffice == null) {
			dealerMastersImpl.setPmPostOffice("");
		}
		else {
			dealerMastersImpl.setPmPostOffice(pmPostOffice);
		}

		if (pmWordNo == null) {
			dealerMastersImpl.setPmWordNo("");
		}
		else {
			dealerMastersImpl.setPmWordNo(pmWordNo);
		}

		if (pmVillage == null) {
			dealerMastersImpl.setPmVillage("");
		}
		else {
			dealerMastersImpl.setPmVillage(pmVillage);
		}

		if (pmHoldingInfo == null) {
			dealerMastersImpl.setPmHoldingInfo("");
		}
		else {
			dealerMastersImpl.setPmHoldingInfo(pmHoldingInfo);
		}

		dealerMastersImpl.setPrDivisionId(prDivisionId);
		dealerMastersImpl.setPrDistrictId(prDistrictId);
		dealerMastersImpl.setPrUpazilaId(prUpazilaId);
		dealerMastersImpl.setPrUnionId(prUnionId);

		if (prPostOffice == null) {
			dealerMastersImpl.setPrPostOffice("");
		}
		else {
			dealerMastersImpl.setPrPostOffice(prPostOffice);
		}

		if (prWordNo == null) {
			dealerMastersImpl.setPrWordNo("");
		}
		else {
			dealerMastersImpl.setPrWordNo(prWordNo);
		}

		if (prVillage == null) {
			dealerMastersImpl.setPrVillage("");
		}
		else {
			dealerMastersImpl.setPrVillage(prVillage);
		}

		if (prHoldingInfo == null) {
			dealerMastersImpl.setPrHoldingInfo("");
		}
		else {
			dealerMastersImpl.setPrHoldingInfo(prHoldingInfo);
		}

		if (dealerMobileNo == null) {
			dealerMastersImpl.setDealerMobileNo("");
		}
		else {
			dealerMastersImpl.setDealerMobileNo(dealerMobileNo);
		}

		if (dealerNationalId == null) {
			dealerMastersImpl.setDealerNationalId("");
		}
		else {
			dealerMastersImpl.setDealerNationalId(dealerNationalId);
		}

		if (secondNationalId == null) {
			dealerMastersImpl.setSecondNationalId("");
		}
		else {
			dealerMastersImpl.setSecondNationalId(secondNationalId);
		}

		if (spouseName == null) {
			dealerMastersImpl.setSpouseName("");
		}
		else {
			dealerMastersImpl.setSpouseName(spouseName);
		}

		if (spouseFatherName == null) {
			dealerMastersImpl.setSpouseFatherName("");
		}
		else {
			dealerMastersImpl.setSpouseFatherName(spouseFatherName);
		}

		if (spouseBirthDate == Long.MIN_VALUE) {
			dealerMastersImpl.setSpouseBirthDate(null);
		}
		else {
			dealerMastersImpl.setSpouseBirthDate(new Date(spouseBirthDate));
		}

		if (spouseNid == null) {
			dealerMastersImpl.setSpouseNid("");
		}
		else {
			dealerMastersImpl.setSpouseNid(spouseNid);
		}

		if (spouseSecondNid == null) {
			dealerMastersImpl.setSpouseSecondNid("");
		}
		else {
			dealerMastersImpl.setSpouseSecondNid(spouseSecondNid);
		}

		if (govtEmployee == null) {
			dealerMastersImpl.setGovtEmployee("");
		}
		else {
			dealerMastersImpl.setGovtEmployee(govtEmployee);
		}

		if (handicap == null) {
			dealerMastersImpl.setHandicap("");
		}
		else {
			dealerMastersImpl.setHandicap(handicap);
		}

		if (publicRepresentative == null) {
			dealerMastersImpl.setPublicRepresentative("");
		}
		else {
			dealerMastersImpl.setPublicRepresentative(publicRepresentative);
		}

		if (vgdStatus == null) {
			dealerMastersImpl.setVgdStatus("");
		}
		else {
			dealerMastersImpl.setVgdStatus(vgdStatus);
		}

		dealerMastersImpl.setCardNoFromOne(cardNoFromOne);
		dealerMastersImpl.setCardNoToOne(cardNoToOne);
		dealerMastersImpl.setCardNoFromTwo(cardNoFromTwo);
		dealerMastersImpl.setCardNoToTwo(cardNoToTwo);
		dealerMastersImpl.setCardNoFromThree(cardNoFromThree);
		dealerMastersImpl.setCardNoToThree(cardNoToThree);

		if (status == null) {
			dealerMastersImpl.setStatus("");
		}
		else {
			dealerMastersImpl.setStatus(status);
		}

		if (createdAt == Long.MIN_VALUE) {
			dealerMastersImpl.setCreatedAt(null);
		}
		else {
			dealerMastersImpl.setCreatedAt(new Date(createdAt));
		}

		if (updatedAt == Long.MIN_VALUE) {
			dealerMastersImpl.setUpdatedAt(null);
		}
		else {
			dealerMastersImpl.setUpdatedAt(new Date(updatedAt));
		}

		dealerMastersImpl.setCardNoFromFour(cardNoFromFour);
		dealerMastersImpl.setCardNoToFour(cardNoToFour);
		dealerMastersImpl.setCardNoFromFive(cardNoFromFive);
		dealerMastersImpl.setCardNoToFive(cardNoToFive);

		if (singleCards == null) {
			dealerMastersImpl.setSingleCards("");
		}
		else {
			dealerMastersImpl.setSingleCards(singleCards);
		}

		dealerMastersImpl.setUserId(userId);
		dealerMastersImpl.setAdditionalUnionId(additionalUnionId);
		dealerMastersImpl.setUpazilaId(upazilaId);

		if (remarks == null) {
			dealerMastersImpl.setRemarks("");
		}
		else {
			dealerMastersImpl.setRemarks(remarks);
		}

		dealerMastersImpl.resetOriginalValues();

		return dealerMastersImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		unionId = objectInput.readLong();
		dealerName = objectInput.readUTF();
		dealerNameEn = objectInput.readUTF();
		dealerSlug = objectInput.readUTF();
		fatherName = objectInput.readUTF();
		motherName = objectInput.readUTF();
		birthDate = objectInput.readLong();
		gender = objectInput.readUTF();
		imagePathReal = objectInput.readUTF();
		imagePathEc = objectInput.readUTF();
		ecPmDivision = objectInput.readUTF();
		ecPmDistrict = objectInput.readUTF();
		ecPmRmo = objectInput.readUTF();
		ecPmUpazila = objectInput.readUTF();
		ecPmUnionWard = objectInput.readUTF();
		ecPmWardUnionPorishod = objectInput.readUTF();
		ecPmPostOffice = objectInput.readUTF();
		ecPmPostalCode = objectInput.readUTF();
		ecPmMouzaMoholla = objectInput.readUTF();
		ecPmAdditionalMouzaMoholla = objectInput.readUTF();
		ecPmVillageRoad = objectInput.readUTF();
		ecPmAdditionalVillageRoad = objectInput.readUTF();
		ecPmHomeHoldingNo = objectInput.readUTF();
		ecPmRegion = objectInput.readUTF();
		ecPrDivision = objectInput.readUTF();
		ecPrDistrict = objectInput.readUTF();
		ecPrRmo = objectInput.readUTF();
		ecPrUpazila = objectInput.readUTF();
		ecPrCityCorpMunicipality = objectInput.readUTF();
		ecPrUnionWard = objectInput.readUTF();
		ecPrPostOffice = objectInput.readUTF();
		ecPrPostalCode = objectInput.readUTF();
		ecPrWardUnionPorishod = objectInput.readUTF();
		ecPrMouzaMoholla = objectInput.readUTF();
		ecPrAdditionalMouzaMoholla = objectInput.readUTF();
		ecPrVillageRoad = objectInput.readUTF();
		ecPrAdditionalVillageRoad = objectInput.readUTF();
		ecPrHomeHoldingNo = objectInput.readUTF();
		ecPrRegion = objectInput.readUTF();
		ecOccupation = objectInput.readUTF();
		ecBloodGroup = objectInput.readUTF();

		age = objectInput.readLong();

		pmDivisionId = objectInput.readLong();

		pmDistrictId = objectInput.readLong();

		pmUpazilaId = objectInput.readLong();

		pmUnionId = objectInput.readLong();
		pmPostOffice = objectInput.readUTF();
		pmWordNo = objectInput.readUTF();
		pmVillage = objectInput.readUTF();
		pmHoldingInfo = objectInput.readUTF();

		prDivisionId = objectInput.readLong();

		prDistrictId = objectInput.readLong();

		prUpazilaId = objectInput.readLong();

		prUnionId = objectInput.readLong();
		prPostOffice = objectInput.readUTF();
		prWordNo = objectInput.readUTF();
		prVillage = objectInput.readUTF();
		prHoldingInfo = objectInput.readUTF();
		dealerMobileNo = objectInput.readUTF();
		dealerNationalId = objectInput.readUTF();
		secondNationalId = objectInput.readUTF();
		spouseName = objectInput.readUTF();
		spouseFatherName = objectInput.readUTF();
		spouseBirthDate = objectInput.readLong();
		spouseNid = objectInput.readUTF();
		spouseSecondNid = objectInput.readUTF();
		govtEmployee = objectInput.readUTF();
		handicap = objectInput.readUTF();
		publicRepresentative = objectInput.readUTF();
		vgdStatus = objectInput.readUTF();

		cardNoFromOne = objectInput.readLong();

		cardNoToOne = objectInput.readLong();

		cardNoFromTwo = objectInput.readLong();

		cardNoToTwo = objectInput.readLong();

		cardNoFromThree = objectInput.readLong();

		cardNoToThree = objectInput.readLong();
		status = objectInput.readUTF();
		createdAt = objectInput.readLong();
		updatedAt = objectInput.readLong();

		cardNoFromFour = objectInput.readLong();

		cardNoToFour = objectInput.readLong();

		cardNoFromFive = objectInput.readLong();

		cardNoToFive = objectInput.readLong();
		singleCards = objectInput.readUTF();

		userId = objectInput.readLong();

		additionalUnionId = objectInput.readLong();

		upazilaId = objectInput.readLong();
		remarks = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(unionId);

		if (dealerName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dealerName);
		}

		if (dealerNameEn == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dealerNameEn);
		}

		if (dealerSlug == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dealerSlug);
		}

		if (fatherName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fatherName);
		}

		if (motherName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(motherName);
		}

		objectOutput.writeLong(birthDate);

		if (gender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gender);
		}

		if (imagePathReal == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(imagePathReal);
		}

		if (imagePathEc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(imagePathEc);
		}

		if (ecPmDivision == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPmDivision);
		}

		if (ecPmDistrict == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPmDistrict);
		}

		if (ecPmRmo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPmRmo);
		}

		if (ecPmUpazila == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPmUpazila);
		}

		if (ecPmUnionWard == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPmUnionWard);
		}

		if (ecPmWardUnionPorishod == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPmWardUnionPorishod);
		}

		if (ecPmPostOffice == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPmPostOffice);
		}

		if (ecPmPostalCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPmPostalCode);
		}

		if (ecPmMouzaMoholla == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPmMouzaMoholla);
		}

		if (ecPmAdditionalMouzaMoholla == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPmAdditionalMouzaMoholla);
		}

		if (ecPmVillageRoad == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPmVillageRoad);
		}

		if (ecPmAdditionalVillageRoad == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPmAdditionalVillageRoad);
		}

		if (ecPmHomeHoldingNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPmHomeHoldingNo);
		}

		if (ecPmRegion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPmRegion);
		}

		if (ecPrDivision == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPrDivision);
		}

		if (ecPrDistrict == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPrDistrict);
		}

		if (ecPrRmo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPrRmo);
		}

		if (ecPrUpazila == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPrUpazila);
		}

		if (ecPrCityCorpMunicipality == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPrCityCorpMunicipality);
		}

		if (ecPrUnionWard == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPrUnionWard);
		}

		if (ecPrPostOffice == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPrPostOffice);
		}

		if (ecPrPostalCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPrPostalCode);
		}

		if (ecPrWardUnionPorishod == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPrWardUnionPorishod);
		}

		if (ecPrMouzaMoholla == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPrMouzaMoholla);
		}

		if (ecPrAdditionalMouzaMoholla == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPrAdditionalMouzaMoholla);
		}

		if (ecPrVillageRoad == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPrVillageRoad);
		}

		if (ecPrAdditionalVillageRoad == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPrAdditionalVillageRoad);
		}

		if (ecPrHomeHoldingNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPrHomeHoldingNo);
		}

		if (ecPrRegion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecPrRegion);
		}

		if (ecOccupation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecOccupation);
		}

		if (ecBloodGroup == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecBloodGroup);
		}

		objectOutput.writeLong(age);

		objectOutput.writeLong(pmDivisionId);

		objectOutput.writeLong(pmDistrictId);

		objectOutput.writeLong(pmUpazilaId);

		objectOutput.writeLong(pmUnionId);

		if (pmPostOffice == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pmPostOffice);
		}

		if (pmWordNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pmWordNo);
		}

		if (pmVillage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pmVillage);
		}

		if (pmHoldingInfo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pmHoldingInfo);
		}

		objectOutput.writeLong(prDivisionId);

		objectOutput.writeLong(prDistrictId);

		objectOutput.writeLong(prUpazilaId);

		objectOutput.writeLong(prUnionId);

		if (prPostOffice == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(prPostOffice);
		}

		if (prWordNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(prWordNo);
		}

		if (prVillage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(prVillage);
		}

		if (prHoldingInfo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(prHoldingInfo);
		}

		if (dealerMobileNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dealerMobileNo);
		}

		if (dealerNationalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dealerNationalId);
		}

		if (secondNationalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(secondNationalId);
		}

		if (spouseName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(spouseName);
		}

		if (spouseFatherName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(spouseFatherName);
		}

		objectOutput.writeLong(spouseBirthDate);

		if (spouseNid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(spouseNid);
		}

		if (spouseSecondNid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(spouseSecondNid);
		}

		if (govtEmployee == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(govtEmployee);
		}

		if (handicap == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(handicap);
		}

		if (publicRepresentative == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(publicRepresentative);
		}

		if (vgdStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vgdStatus);
		}

		objectOutput.writeLong(cardNoFromOne);

		objectOutput.writeLong(cardNoToOne);

		objectOutput.writeLong(cardNoFromTwo);

		objectOutput.writeLong(cardNoToTwo);

		objectOutput.writeLong(cardNoFromThree);

		objectOutput.writeLong(cardNoToThree);

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(createdAt);
		objectOutput.writeLong(updatedAt);

		objectOutput.writeLong(cardNoFromFour);

		objectOutput.writeLong(cardNoToFour);

		objectOutput.writeLong(cardNoFromFive);

		objectOutput.writeLong(cardNoToFive);

		if (singleCards == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(singleCards);
		}

		objectOutput.writeLong(userId);

		objectOutput.writeLong(additionalUnionId);

		objectOutput.writeLong(upazilaId);

		if (remarks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(remarks);
		}
	}

	public long id;
	public long unionId;
	public String dealerName;
	public String dealerNameEn;
	public String dealerSlug;
	public String fatherName;
	public String motherName;
	public long birthDate;
	public String gender;
	public String imagePathReal;
	public String imagePathEc;
	public String ecPmDivision;
	public String ecPmDistrict;
	public String ecPmRmo;
	public String ecPmUpazila;
	public String ecPmUnionWard;
	public String ecPmWardUnionPorishod;
	public String ecPmPostOffice;
	public String ecPmPostalCode;
	public String ecPmMouzaMoholla;
	public String ecPmAdditionalMouzaMoholla;
	public String ecPmVillageRoad;
	public String ecPmAdditionalVillageRoad;
	public String ecPmHomeHoldingNo;
	public String ecPmRegion;
	public String ecPrDivision;
	public String ecPrDistrict;
	public String ecPrRmo;
	public String ecPrUpazila;
	public String ecPrCityCorpMunicipality;
	public String ecPrUnionWard;
	public String ecPrPostOffice;
	public String ecPrPostalCode;
	public String ecPrWardUnionPorishod;
	public String ecPrMouzaMoholla;
	public String ecPrAdditionalMouzaMoholla;
	public String ecPrVillageRoad;
	public String ecPrAdditionalVillageRoad;
	public String ecPrHomeHoldingNo;
	public String ecPrRegion;
	public String ecOccupation;
	public String ecBloodGroup;
	public long age;
	public long pmDivisionId;
	public long pmDistrictId;
	public long pmUpazilaId;
	public long pmUnionId;
	public String pmPostOffice;
	public String pmWordNo;
	public String pmVillage;
	public String pmHoldingInfo;
	public long prDivisionId;
	public long prDistrictId;
	public long prUpazilaId;
	public long prUnionId;
	public String prPostOffice;
	public String prWordNo;
	public String prVillage;
	public String prHoldingInfo;
	public String dealerMobileNo;
	public String dealerNationalId;
	public String secondNationalId;
	public String spouseName;
	public String spouseFatherName;
	public long spouseBirthDate;
	public String spouseNid;
	public String spouseSecondNid;
	public String govtEmployee;
	public String handicap;
	public String publicRepresentative;
	public String vgdStatus;
	public long cardNoFromOne;
	public long cardNoToOne;
	public long cardNoFromTwo;
	public long cardNoToTwo;
	public long cardNoFromThree;
	public long cardNoToThree;
	public String status;
	public long createdAt;
	public long updatedAt;
	public long cardNoFromFour;
	public long cardNoToFour;
	public long cardNoFromFive;
	public long cardNoToFive;
	public String singleCards;
	public long userId;
	public long additionalUnionId;
	public long upazilaId;
	public String remarks;

}