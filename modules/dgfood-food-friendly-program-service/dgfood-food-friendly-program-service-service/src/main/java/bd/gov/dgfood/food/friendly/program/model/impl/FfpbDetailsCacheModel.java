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

package bd.gov.dgfood.food.friendly.program.model.impl;

import bd.gov.dgfood.food.friendly.program.model.FfpbDetails;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FfpbDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FfpbDetailsCacheModel
	implements CacheModel<FfpbDetails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FfpbDetailsCacheModel)) {
			return false;
		}

		FfpbDetailsCacheModel ffpbDetailsCacheModel =
			(FfpbDetailsCacheModel)object;

		if (ffpRegstrId == ffpbDetailsCacheModel.ffpRegstrId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ffpRegstrId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(63);

		sb.append("{ffpRegstrId=");
		sb.append(ffpRegstrId);
		sb.append(", nationalId=");
		sb.append(nationalId);
		sb.append(", dlrRegNo=");
		sb.append(dlrRegNo);
		sb.append(", ffpCardNo=");
		sb.append(ffpCardNo);
		sb.append(", dateOfBirth=");
		sb.append(dateOfBirth);
		sb.append(", mobileNo=");
		sb.append(mobileNo);
		sb.append(", emialId=");
		sb.append(emialId);
		sb.append(", maritalStatus=");
		sb.append(maritalStatus);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", spouseNid=");
		sb.append(spouseNid);
		sb.append(", prstAddrRegion=");
		sb.append(prstAddrRegion);
		sb.append(", prstAddrDisrict=");
		sb.append(prstAddrDisrict);
		sb.append(", prstAddrUpzilla=");
		sb.append(prstAddrUpzilla);
		sb.append(", prstAddrUnion=");
		sb.append(prstAddrUnion);
		sb.append(", prstAddrVillage=");
		sb.append(prstAddrVillage);
		sb.append(", prstAddrWard=");
		sb.append(prstAddrWard);
		sb.append(", prstAddrZip=");
		sb.append(prstAddrZip);
		sb.append(", prstAddrPstoffc=");
		sb.append(prstAddrPstoffc);
		sb.append(", prstAddrHoseaddr=");
		sb.append(prstAddrHoseaddr);
		sb.append(", ffpApplCrtdBy=");
		sb.append(ffpApplCrtdBy);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", ffpApplMdfyBy=");
		sb.append(ffpApplMdfyBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", applApprejCmnts=");
		sb.append(applApprejCmnts);
		sb.append(", ffpbApplStatus=");
		sb.append(ffpbApplStatus);
		sb.append(", version=");
		sb.append(version);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FfpbDetails toEntityModel() {
		FfpbDetailsImpl ffpbDetailsImpl = new FfpbDetailsImpl();

		ffpbDetailsImpl.setFfpRegstrId(ffpRegstrId);
		ffpbDetailsImpl.setNationalId(nationalId);
		ffpbDetailsImpl.setDlrRegNo(dlrRegNo);

		if (ffpCardNo == null) {
			ffpbDetailsImpl.setFfpCardNo("");
		}
		else {
			ffpbDetailsImpl.setFfpCardNo(ffpCardNo);
		}

		if (dateOfBirth == Long.MIN_VALUE) {
			ffpbDetailsImpl.setDateOfBirth(null);
		}
		else {
			ffpbDetailsImpl.setDateOfBirth(new Date(dateOfBirth));
		}

		if (mobileNo == null) {
			ffpbDetailsImpl.setMobileNo("");
		}
		else {
			ffpbDetailsImpl.setMobileNo(mobileNo);
		}

		if (emialId == null) {
			ffpbDetailsImpl.setEmialId("");
		}
		else {
			ffpbDetailsImpl.setEmialId(emialId);
		}

		ffpbDetailsImpl.setMaritalStatus(maritalStatus);
		ffpbDetailsImpl.setGender(gender);
		ffpbDetailsImpl.setSpouseNid(spouseNid);

		if (prstAddrRegion == null) {
			ffpbDetailsImpl.setPrstAddrRegion("");
		}
		else {
			ffpbDetailsImpl.setPrstAddrRegion(prstAddrRegion);
		}

		if (prstAddrDisrict == null) {
			ffpbDetailsImpl.setPrstAddrDisrict("");
		}
		else {
			ffpbDetailsImpl.setPrstAddrDisrict(prstAddrDisrict);
		}

		if (prstAddrUpzilla == null) {
			ffpbDetailsImpl.setPrstAddrUpzilla("");
		}
		else {
			ffpbDetailsImpl.setPrstAddrUpzilla(prstAddrUpzilla);
		}

		if (prstAddrUnion == null) {
			ffpbDetailsImpl.setPrstAddrUnion("");
		}
		else {
			ffpbDetailsImpl.setPrstAddrUnion(prstAddrUnion);
		}

		if (prstAddrVillage == null) {
			ffpbDetailsImpl.setPrstAddrVillage("");
		}
		else {
			ffpbDetailsImpl.setPrstAddrVillage(prstAddrVillage);
		}

		if (prstAddrWard == null) {
			ffpbDetailsImpl.setPrstAddrWard("");
		}
		else {
			ffpbDetailsImpl.setPrstAddrWard(prstAddrWard);
		}

		ffpbDetailsImpl.setPrstAddrZip(prstAddrZip);
		ffpbDetailsImpl.setPrstAddrPstoffc(prstAddrPstoffc);

		if (prstAddrHoseaddr == null) {
			ffpbDetailsImpl.setPrstAddrHoseaddr("");
		}
		else {
			ffpbDetailsImpl.setPrstAddrHoseaddr(prstAddrHoseaddr);
		}

		ffpbDetailsImpl.setFfpApplCrtdBy(ffpApplCrtdBy);

		if (createDate == Long.MIN_VALUE) {
			ffpbDetailsImpl.setCreateDate(null);
		}
		else {
			ffpbDetailsImpl.setCreateDate(new Date(createDate));
		}

		ffpbDetailsImpl.setFfpApplMdfyBy(ffpApplMdfyBy);

		if (modifiedDate == Long.MIN_VALUE) {
			ffpbDetailsImpl.setModifiedDate(null);
		}
		else {
			ffpbDetailsImpl.setModifiedDate(new Date(modifiedDate));
		}

		ffpbDetailsImpl.setGroupId(groupId);
		ffpbDetailsImpl.setCompanyId(companyId);

		if (applApprejCmnts == null) {
			ffpbDetailsImpl.setApplApprejCmnts("");
		}
		else {
			ffpbDetailsImpl.setApplApprejCmnts(applApprejCmnts);
		}

		ffpbDetailsImpl.setFfpbApplStatus(ffpbApplStatus);
		ffpbDetailsImpl.setVersion(version);
		ffpbDetailsImpl.setStatus(status);
		ffpbDetailsImpl.setStatusByUserId(statusByUserId);

		if (statusDate == Long.MIN_VALUE) {
			ffpbDetailsImpl.setStatusDate(null);
		}
		else {
			ffpbDetailsImpl.setStatusDate(new Date(statusDate));
		}

		ffpbDetailsImpl.resetOriginalValues();

		return ffpbDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ffpRegstrId = objectInput.readLong();

		nationalId = objectInput.readLong();

		dlrRegNo = objectInput.readLong();
		ffpCardNo = objectInput.readUTF();
		dateOfBirth = objectInput.readLong();
		mobileNo = objectInput.readUTF();
		emialId = objectInput.readUTF();

		maritalStatus = objectInput.readLong();

		gender = objectInput.readLong();

		spouseNid = objectInput.readLong();
		prstAddrRegion = objectInput.readUTF();
		prstAddrDisrict = objectInput.readUTF();
		prstAddrUpzilla = objectInput.readUTF();
		prstAddrUnion = objectInput.readUTF();
		prstAddrVillage = objectInput.readUTF();
		prstAddrWard = objectInput.readUTF();

		prstAddrZip = objectInput.readLong();

		prstAddrPstoffc = objectInput.readLong();
		prstAddrHoseaddr = objectInput.readUTF();

		ffpApplCrtdBy = objectInput.readLong();
		createDate = objectInput.readLong();

		ffpApplMdfyBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		applApprejCmnts = objectInput.readUTF();

		ffpbApplStatus = objectInput.readLong();

		version = objectInput.readFloat();

		status = objectInput.readLong();

		statusByUserId = objectInput.readLong();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ffpRegstrId);

		objectOutput.writeLong(nationalId);

		objectOutput.writeLong(dlrRegNo);

		if (ffpCardNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ffpCardNo);
		}

		objectOutput.writeLong(dateOfBirth);

		if (mobileNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobileNo);
		}

		if (emialId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emialId);
		}

		objectOutput.writeLong(maritalStatus);

		objectOutput.writeLong(gender);

		objectOutput.writeLong(spouseNid);

		if (prstAddrRegion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(prstAddrRegion);
		}

		if (prstAddrDisrict == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(prstAddrDisrict);
		}

		if (prstAddrUpzilla == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(prstAddrUpzilla);
		}

		if (prstAddrUnion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(prstAddrUnion);
		}

		if (prstAddrVillage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(prstAddrVillage);
		}

		if (prstAddrWard == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(prstAddrWard);
		}

		objectOutput.writeLong(prstAddrZip);

		objectOutput.writeLong(prstAddrPstoffc);

		if (prstAddrHoseaddr == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(prstAddrHoseaddr);
		}

		objectOutput.writeLong(ffpApplCrtdBy);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(ffpApplMdfyBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		if (applApprejCmnts == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(applApprejCmnts);
		}

		objectOutput.writeLong(ffpbApplStatus);

		objectOutput.writeFloat(version);

		objectOutput.writeLong(status);

		objectOutput.writeLong(statusByUserId);
		objectOutput.writeLong(statusDate);
	}

	public long ffpRegstrId;
	public long nationalId;
	public long dlrRegNo;
	public String ffpCardNo;
	public long dateOfBirth;
	public String mobileNo;
	public String emialId;
	public long maritalStatus;
	public long gender;
	public long spouseNid;
	public String prstAddrRegion;
	public String prstAddrDisrict;
	public String prstAddrUpzilla;
	public String prstAddrUnion;
	public String prstAddrVillage;
	public String prstAddrWard;
	public long prstAddrZip;
	public long prstAddrPstoffc;
	public String prstAddrHoseaddr;
	public long ffpApplCrtdBy;
	public long createDate;
	public long ffpApplMdfyBy;
	public long modifiedDate;
	public long groupId;
	public long companyId;
	public String applApprejCmnts;
	public long ffpbApplStatus;
	public float version;
	public long status;
	public long statusByUserId;
	public long statusDate;

}