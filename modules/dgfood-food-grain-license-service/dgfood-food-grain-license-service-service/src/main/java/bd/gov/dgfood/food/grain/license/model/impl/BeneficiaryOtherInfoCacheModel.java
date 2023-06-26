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

import bd.gov.dgfood.food.grain.license.model.BeneficiaryOtherInfo;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BeneficiaryOtherInfo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BeneficiaryOtherInfoCacheModel
	implements CacheModel<BeneficiaryOtherInfo>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BeneficiaryOtherInfoCacheModel)) {
			return false;
		}

		BeneficiaryOtherInfoCacheModel beneficiaryOtherInfoCacheModel =
			(BeneficiaryOtherInfoCacheModel)object;

		if (id == beneficiaryOtherInfoCacheModel.id) {
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
		StringBundler sb = new StringBundler(59);

		sb.append("{id=");
		sb.append(id);
		sb.append(", verifiedId=");
		sb.append(verifiedId);
		sb.append(", maritalStatus=");
		sb.append(maritalStatus);
		sb.append(", spouseName=");
		sb.append(spouseName);
		sb.append(", spouseNid=");
		sb.append(spouseNid);
		sb.append(", spouseSecondNid=");
		sb.append(spouseSecondNid);
		sb.append(", spouseDob=");
		sb.append(spouseDob);
		sb.append(", fatherNid=");
		sb.append(fatherNid);
		sb.append(", motherNid=");
		sb.append(motherNid);
		sb.append(", mobileNo=");
		sb.append(mobileNo);
		sb.append(", mobileNoRelation=");
		sb.append(mobileNoRelation);
		sb.append(", ecSpouseInfo=");
		sb.append(ecSpouseInfo);
		sb.append(", occupation=");
		sb.append(occupation);
		sb.append(", villageName=");
		sb.append(villageName);
		sb.append(", wordNo=");
		sb.append(wordNo);
		sb.append(", dealerName=");
		sb.append(dealerName);
		sb.append(", dealerMobile=");
		sb.append(dealerMobile);
		sb.append(", mobileVerifiedAt=");
		sb.append(mobileVerifiedAt);
		sb.append(", familyEarningMember=");
		sb.append(familyEarningMember);
		sb.append(", avgFamilyIncome=");
		sb.append(avgFamilyIncome);
		sb.append(", dependentFamilyMember=");
		sb.append(dependentFamilyMember);
		sb.append(", landSize=");
		sb.append(landSize);
		sb.append(", landUnit=");
		sb.append(landUnit);
		sb.append(", remarks=");
		sb.append(remarks);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdAt=");
		sb.append(createdAt);
		sb.append(", updatedAt=");
		sb.append(updatedAt);
		sb.append(", dealerSlug=");
		sb.append(dealerSlug);
		sb.append(", dealerId=");
		sb.append(dealerId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BeneficiaryOtherInfo toEntityModel() {
		BeneficiaryOtherInfoImpl beneficiaryOtherInfoImpl =
			new BeneficiaryOtherInfoImpl();

		beneficiaryOtherInfoImpl.setId(id);
		beneficiaryOtherInfoImpl.setVerifiedId(verifiedId);

		if (maritalStatus == null) {
			beneficiaryOtherInfoImpl.setMaritalStatus("");
		}
		else {
			beneficiaryOtherInfoImpl.setMaritalStatus(maritalStatus);
		}

		if (spouseName == null) {
			beneficiaryOtherInfoImpl.setSpouseName("");
		}
		else {
			beneficiaryOtherInfoImpl.setSpouseName(spouseName);
		}

		if (spouseNid == null) {
			beneficiaryOtherInfoImpl.setSpouseNid("");
		}
		else {
			beneficiaryOtherInfoImpl.setSpouseNid(spouseNid);
		}

		if (spouseSecondNid == null) {
			beneficiaryOtherInfoImpl.setSpouseSecondNid("");
		}
		else {
			beneficiaryOtherInfoImpl.setSpouseSecondNid(spouseSecondNid);
		}

		if (spouseDob == Long.MIN_VALUE) {
			beneficiaryOtherInfoImpl.setSpouseDob(null);
		}
		else {
			beneficiaryOtherInfoImpl.setSpouseDob(new Date(spouseDob));
		}

		if (fatherNid == null) {
			beneficiaryOtherInfoImpl.setFatherNid("");
		}
		else {
			beneficiaryOtherInfoImpl.setFatherNid(fatherNid);
		}

		if (motherNid == null) {
			beneficiaryOtherInfoImpl.setMotherNid("");
		}
		else {
			beneficiaryOtherInfoImpl.setMotherNid(motherNid);
		}

		if (mobileNo == null) {
			beneficiaryOtherInfoImpl.setMobileNo("");
		}
		else {
			beneficiaryOtherInfoImpl.setMobileNo(mobileNo);
		}

		if (mobileNoRelation == null) {
			beneficiaryOtherInfoImpl.setMobileNoRelation("");
		}
		else {
			beneficiaryOtherInfoImpl.setMobileNoRelation(mobileNoRelation);
		}

		if (ecSpouseInfo == null) {
			beneficiaryOtherInfoImpl.setEcSpouseInfo("");
		}
		else {
			beneficiaryOtherInfoImpl.setEcSpouseInfo(ecSpouseInfo);
		}

		if (occupation == null) {
			beneficiaryOtherInfoImpl.setOccupation("");
		}
		else {
			beneficiaryOtherInfoImpl.setOccupation(occupation);
		}

		if (villageName == null) {
			beneficiaryOtherInfoImpl.setVillageName("");
		}
		else {
			beneficiaryOtherInfoImpl.setVillageName(villageName);
		}

		if (wordNo == null) {
			beneficiaryOtherInfoImpl.setWordNo("");
		}
		else {
			beneficiaryOtherInfoImpl.setWordNo(wordNo);
		}

		if (dealerName == null) {
			beneficiaryOtherInfoImpl.setDealerName("");
		}
		else {
			beneficiaryOtherInfoImpl.setDealerName(dealerName);
		}

		if (dealerMobile == null) {
			beneficiaryOtherInfoImpl.setDealerMobile("");
		}
		else {
			beneficiaryOtherInfoImpl.setDealerMobile(dealerMobile);
		}

		if (mobileVerifiedAt == Long.MIN_VALUE) {
			beneficiaryOtherInfoImpl.setMobileVerifiedAt(null);
		}
		else {
			beneficiaryOtherInfoImpl.setMobileVerifiedAt(
				new Date(mobileVerifiedAt));
		}

		beneficiaryOtherInfoImpl.setFamilyEarningMember(familyEarningMember);
		beneficiaryOtherInfoImpl.setAvgFamilyIncome(avgFamilyIncome);
		beneficiaryOtherInfoImpl.setDependentFamilyMember(
			dependentFamilyMember);
		beneficiaryOtherInfoImpl.setLandSize(landSize);

		if (landUnit == null) {
			beneficiaryOtherInfoImpl.setLandUnit("");
		}
		else {
			beneficiaryOtherInfoImpl.setLandUnit(landUnit);
		}

		if (remarks == null) {
			beneficiaryOtherInfoImpl.setRemarks("");
		}
		else {
			beneficiaryOtherInfoImpl.setRemarks(remarks);
		}

		beneficiaryOtherInfoImpl.setUserId(userId);

		if (createdAt == Long.MIN_VALUE) {
			beneficiaryOtherInfoImpl.setCreatedAt(null);
		}
		else {
			beneficiaryOtherInfoImpl.setCreatedAt(new Date(createdAt));
		}

		if (updatedAt == Long.MIN_VALUE) {
			beneficiaryOtherInfoImpl.setUpdatedAt(null);
		}
		else {
			beneficiaryOtherInfoImpl.setUpdatedAt(new Date(updatedAt));
		}

		if (dealerSlug == null) {
			beneficiaryOtherInfoImpl.setDealerSlug("");
		}
		else {
			beneficiaryOtherInfoImpl.setDealerSlug(dealerSlug);
		}

		beneficiaryOtherInfoImpl.setDealerId(dealerId);

		beneficiaryOtherInfoImpl.resetOriginalValues();

		return beneficiaryOtherInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		verifiedId = objectInput.readLong();
		maritalStatus = objectInput.readUTF();
		spouseName = objectInput.readUTF();
		spouseNid = objectInput.readUTF();
		spouseSecondNid = objectInput.readUTF();
		spouseDob = objectInput.readLong();
		fatherNid = objectInput.readUTF();
		motherNid = objectInput.readUTF();
		mobileNo = objectInput.readUTF();
		mobileNoRelation = objectInput.readUTF();
		ecSpouseInfo = objectInput.readUTF();
		occupation = objectInput.readUTF();
		villageName = objectInput.readUTF();
		wordNo = objectInput.readUTF();
		dealerName = objectInput.readUTF();
		dealerMobile = objectInput.readUTF();
		mobileVerifiedAt = objectInput.readLong();

		familyEarningMember = objectInput.readLong();

		avgFamilyIncome = objectInput.readLong();

		dependentFamilyMember = objectInput.readLong();

		landSize = objectInput.readLong();
		landUnit = objectInput.readUTF();
		remarks = objectInput.readUTF();

		userId = objectInput.readLong();
		createdAt = objectInput.readLong();
		updatedAt = objectInput.readLong();
		dealerSlug = objectInput.readUTF();

		dealerId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(verifiedId);

		if (maritalStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(maritalStatus);
		}

		if (spouseName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(spouseName);
		}

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

		objectOutput.writeLong(spouseDob);

		if (fatherNid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fatherNid);
		}

		if (motherNid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(motherNid);
		}

		if (mobileNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobileNo);
		}

		if (mobileNoRelation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobileNoRelation);
		}

		if (ecSpouseInfo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ecSpouseInfo);
		}

		if (occupation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(occupation);
		}

		if (villageName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(villageName);
		}

		if (wordNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(wordNo);
		}

		if (dealerName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dealerName);
		}

		if (dealerMobile == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dealerMobile);
		}

		objectOutput.writeLong(mobileVerifiedAt);

		objectOutput.writeLong(familyEarningMember);

		objectOutput.writeLong(avgFamilyIncome);

		objectOutput.writeLong(dependentFamilyMember);

		objectOutput.writeLong(landSize);

		if (landUnit == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(landUnit);
		}

		if (remarks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(remarks);
		}

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createdAt);
		objectOutput.writeLong(updatedAt);

		if (dealerSlug == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dealerSlug);
		}

		objectOutput.writeLong(dealerId);
	}

	public long id;
	public long verifiedId;
	public String maritalStatus;
	public String spouseName;
	public String spouseNid;
	public String spouseSecondNid;
	public long spouseDob;
	public String fatherNid;
	public String motherNid;
	public String mobileNo;
	public String mobileNoRelation;
	public String ecSpouseInfo;
	public String occupation;
	public String villageName;
	public String wordNo;
	public String dealerName;
	public String dealerMobile;
	public long mobileVerifiedAt;
	public long familyEarningMember;
	public long avgFamilyIncome;
	public long dependentFamilyMember;
	public long landSize;
	public String landUnit;
	public String remarks;
	public long userId;
	public long createdAt;
	public long updatedAt;
	public String dealerSlug;
	public long dealerId;

}