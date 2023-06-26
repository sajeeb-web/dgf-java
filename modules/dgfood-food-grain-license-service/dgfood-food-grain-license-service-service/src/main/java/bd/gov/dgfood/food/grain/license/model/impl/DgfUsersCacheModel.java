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

import bd.gov.dgfood.food.grain.license.model.DgfUsers;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DgfUsers in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DgfUsersCacheModel
	implements CacheModel<DgfUsers>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DgfUsersCacheModel)) {
			return false;
		}

		DgfUsersCacheModel dgfUsersCacheModel = (DgfUsersCacheModel)object;

		if (userId == dgfUsersCacheModel.userId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", nationalId=");
		sb.append(nationalId);
		sb.append(", password=");
		sb.append(password);
		sb.append(", applicantName=");
		sb.append(applicantName);
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
		sb.append(", presentAddrId=");
		sb.append(presentAddrId);
		sb.append(", applcProfile=");
		sb.append(applcProfile);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DgfUsers toEntityModel() {
		DgfUsersImpl dgfUsersImpl = new DgfUsersImpl();

		dgfUsersImpl.setUserId(userId);

		if (nationalId == null) {
			dgfUsersImpl.setNationalId("");
		}
		else {
			dgfUsersImpl.setNationalId(nationalId);
		}

		if (password == null) {
			dgfUsersImpl.setPassword("");
		}
		else {
			dgfUsersImpl.setPassword(password);
		}

		if (applicantName == null) {
			dgfUsersImpl.setApplicantName("");
		}
		else {
			dgfUsersImpl.setApplicantName(applicantName);
		}

		if (fatherName == null) {
			dgfUsersImpl.setFatherName("");
		}
		else {
			dgfUsersImpl.setFatherName(fatherName);
		}

		if (lastName == null) {
			dgfUsersImpl.setLastName("");
		}
		else {
			dgfUsersImpl.setLastName(lastName);
		}

		if (motherName == null) {
			dgfUsersImpl.setMotherName("");
		}
		else {
			dgfUsersImpl.setMotherName(motherName);
		}

		if (gender == null) {
			dgfUsersImpl.setGender("");
		}
		else {
			dgfUsersImpl.setGender(gender);
		}

		if (maritalStatus == null) {
			dgfUsersImpl.setMaritalStatus("");
		}
		else {
			dgfUsersImpl.setMaritalStatus(maritalStatus);
		}

		if (birthDate == Long.MIN_VALUE) {
			dgfUsersImpl.setBirthDate(null);
		}
		else {
			dgfUsersImpl.setBirthDate(new Date(birthDate));
		}

		if (mobileNo == null) {
			dgfUsersImpl.setMobileNo("");
		}
		else {
			dgfUsersImpl.setMobileNo(mobileNo);
		}

		dgfUsersImpl.setPresentAddrId(presentAddrId);

		if (applcProfile == null) {
			dgfUsersImpl.setApplcProfile("");
		}
		else {
			dgfUsersImpl.setApplcProfile(applcProfile);
		}

		if (createDate == Long.MIN_VALUE) {
			dgfUsersImpl.setCreateDate(null);
		}
		else {
			dgfUsersImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dgfUsersImpl.setModifiedDate(null);
		}
		else {
			dgfUsersImpl.setModifiedDate(new Date(modifiedDate));
		}

		dgfUsersImpl.resetOriginalValues();

		return dgfUsersImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userId = objectInput.readLong();
		nationalId = objectInput.readUTF();
		password = objectInput.readUTF();
		applicantName = objectInput.readUTF();
		fatherName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		motherName = objectInput.readUTF();
		gender = objectInput.readUTF();
		maritalStatus = objectInput.readUTF();
		birthDate = objectInput.readLong();
		mobileNo = objectInput.readUTF();

		presentAddrId = objectInput.readLong();
		applcProfile = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(userId);

		if (nationalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationalId);
		}

		if (password == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(password);
		}

		if (applicantName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(applicantName);
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

		objectOutput.writeLong(presentAddrId);

		if (applcProfile == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(applcProfile);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long userId;
	public String nationalId;
	public String password;
	public String applicantName;
	public String fatherName;
	public String lastName;
	public String motherName;
	public String gender;
	public String maritalStatus;
	public long birthDate;
	public String mobileNo;
	public long presentAddrId;
	public String applcProfile;
	public long createDate;
	public long modifiedDate;

}