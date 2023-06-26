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

package bd.gov.dgfood.dealer.registration.model.impl;

import bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawal;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DgfDlrWithdrawal in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DgfDlrWithdrawalCacheModel
	implements CacheModel<DgfDlrWithdrawal>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DgfDlrWithdrawalCacheModel)) {
			return false;
		}

		DgfDlrWithdrawalCacheModel dgfDlrWithdrawalCacheModel =
			(DgfDlrWithdrawalCacheModel)object;

		if (dlrWithdrawalId == dgfDlrWithdrawalCacheModel.dlrWithdrawalId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dlrWithdrawalId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{dlrWithdrawalId=");
		sb.append(dlrWithdrawalId);
		sb.append(", nationalId=");
		sb.append(nationalId);
		sb.append(", licenseNo=");
		sb.append(licenseNo);
		sb.append(", dealerName=");
		sb.append(dealerName);
		sb.append(", mobileNo=");
		sb.append(mobileNo);
		sb.append(", reason=");
		sb.append(reason);
		sb.append(", programType=");
		sb.append(programType);
		sb.append(", omsSubType=");
		sb.append(omsSubType);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", dlrRegNo=");
		sb.append(dlrRegNo);
		sb.append(", regApplNo=");
		sb.append(regApplNo);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DgfDlrWithdrawal toEntityModel() {
		DgfDlrWithdrawalImpl dgfDlrWithdrawalImpl = new DgfDlrWithdrawalImpl();

		dgfDlrWithdrawalImpl.setDlrWithdrawalId(dlrWithdrawalId);

		if (nationalId == null) {
			dgfDlrWithdrawalImpl.setNationalId("");
		}
		else {
			dgfDlrWithdrawalImpl.setNationalId(nationalId);
		}

		if (licenseNo == null) {
			dgfDlrWithdrawalImpl.setLicenseNo("");
		}
		else {
			dgfDlrWithdrawalImpl.setLicenseNo(licenseNo);
		}

		if (dealerName == null) {
			dgfDlrWithdrawalImpl.setDealerName("");
		}
		else {
			dgfDlrWithdrawalImpl.setDealerName(dealerName);
		}

		if (mobileNo == null) {
			dgfDlrWithdrawalImpl.setMobileNo("");
		}
		else {
			dgfDlrWithdrawalImpl.setMobileNo(mobileNo);
		}

		if (reason == null) {
			dgfDlrWithdrawalImpl.setReason("");
		}
		else {
			dgfDlrWithdrawalImpl.setReason(reason);
		}

		if (programType == null) {
			dgfDlrWithdrawalImpl.setProgramType("");
		}
		else {
			dgfDlrWithdrawalImpl.setProgramType(programType);
		}

		if (omsSubType == null) {
			dgfDlrWithdrawalImpl.setOmsSubType("");
		}
		else {
			dgfDlrWithdrawalImpl.setOmsSubType(omsSubType);
		}

		if (createdDate == Long.MIN_VALUE) {
			dgfDlrWithdrawalImpl.setCreatedDate(null);
		}
		else {
			dgfDlrWithdrawalImpl.setCreatedDate(new Date(createdDate));
		}

		dgfDlrWithdrawalImpl.setModifiedBy(modifiedBy);

		if (modifiedDate == Long.MIN_VALUE) {
			dgfDlrWithdrawalImpl.setModifiedDate(null);
		}
		else {
			dgfDlrWithdrawalImpl.setModifiedDate(new Date(modifiedDate));
		}

		dgfDlrWithdrawalImpl.setUserId(userId);
		dgfDlrWithdrawalImpl.setGroupId(groupId);
		dgfDlrWithdrawalImpl.setCompanyId(companyId);
		dgfDlrWithdrawalImpl.setDlrRegNo(dlrRegNo);
		dgfDlrWithdrawalImpl.setRegApplNo(regApplNo);
		dgfDlrWithdrawalImpl.setStatus(status);
		dgfDlrWithdrawalImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			dgfDlrWithdrawalImpl.setStatusByUserName("");
		}
		else {
			dgfDlrWithdrawalImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			dgfDlrWithdrawalImpl.setStatusDate(null);
		}
		else {
			dgfDlrWithdrawalImpl.setStatusDate(new Date(statusDate));
		}

		dgfDlrWithdrawalImpl.resetOriginalValues();

		return dgfDlrWithdrawalImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dlrWithdrawalId = objectInput.readLong();
		nationalId = objectInput.readUTF();
		licenseNo = objectInput.readUTF();
		dealerName = objectInput.readUTF();
		mobileNo = objectInput.readUTF();
		reason = objectInput.readUTF();
		programType = objectInput.readUTF();
		omsSubType = objectInput.readUTF();
		createdDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		userId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		dlrRegNo = objectInput.readLong();

		regApplNo = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(dlrWithdrawalId);

		if (nationalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationalId);
		}

		if (licenseNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(licenseNo);
		}

		if (dealerName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dealerName);
		}

		if (mobileNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobileNo);
		}

		if (reason == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reason);
		}

		if (programType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(programType);
		}

		if (omsSubType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(omsSubType);
		}

		objectOutput.writeLong(createdDate);

		objectOutput.writeLong(modifiedBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(dlrRegNo);

		objectOutput.writeLong(regApplNo);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public long dlrWithdrawalId;
	public String nationalId;
	public String licenseNo;
	public String dealerName;
	public String mobileNo;
	public String reason;
	public String programType;
	public String omsSubType;
	public long createdDate;
	public long modifiedBy;
	public long modifiedDate;
	public long userId;
	public long groupId;
	public long companyId;
	public long dlrRegNo;
	public long regApplNo;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}