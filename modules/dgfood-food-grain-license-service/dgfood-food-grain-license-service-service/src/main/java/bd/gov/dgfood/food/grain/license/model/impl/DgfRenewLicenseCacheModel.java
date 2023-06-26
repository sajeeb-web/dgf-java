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

import bd.gov.dgfood.food.grain.license.model.DgfRenewLicense;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DgfRenewLicense in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DgfRenewLicenseCacheModel
	implements CacheModel<DgfRenewLicense>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DgfRenewLicenseCacheModel)) {
			return false;
		}

		DgfRenewLicenseCacheModel dgfRenewLicenseCacheModel =
			(DgfRenewLicenseCacheModel)object;

		if (renewLicenseId == dgfRenewLicenseCacheModel.renewLicenseId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, renewLicenseId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{renewLicenseId=");
		sb.append(renewLicenseId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", nationalId=");
		sb.append(nationalId);
		sb.append(", licenseNo=");
		sb.append(licenseNo);
		sb.append(", licenseExpiryDate=");
		sb.append(licenseExpiryDate);
		sb.append(", tradeLicenseNo=");
		sb.append(tradeLicenseNo);
		sb.append(", tradeLicenseExpiryDate=");
		sb.append(tradeLicenseExpiryDate);
		sb.append(", tradeLicAttchId=");
		sb.append(tradeLicAttchId);
		sb.append(", paymentAttchId=");
		sb.append(paymentAttchId);
		sb.append(", applicationNo=");
		sb.append(applicationNo);
		sb.append(", licenseApplicationType=");
		sb.append(licenseApplicationType);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", fglPrePrimaryId=");
		sb.append(fglPrePrimaryId);
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
	public DgfRenewLicense toEntityModel() {
		DgfRenewLicenseImpl dgfRenewLicenseImpl = new DgfRenewLicenseImpl();

		dgfRenewLicenseImpl.setRenewLicenseId(renewLicenseId);
		dgfRenewLicenseImpl.setUserId(userId);

		if (nationalId == null) {
			dgfRenewLicenseImpl.setNationalId("");
		}
		else {
			dgfRenewLicenseImpl.setNationalId(nationalId);
		}

		if (licenseNo == null) {
			dgfRenewLicenseImpl.setLicenseNo("");
		}
		else {
			dgfRenewLicenseImpl.setLicenseNo(licenseNo);
		}

		if (licenseExpiryDate == Long.MIN_VALUE) {
			dgfRenewLicenseImpl.setLicenseExpiryDate(null);
		}
		else {
			dgfRenewLicenseImpl.setLicenseExpiryDate(
				new Date(licenseExpiryDate));
		}

		if (tradeLicenseNo == null) {
			dgfRenewLicenseImpl.setTradeLicenseNo("");
		}
		else {
			dgfRenewLicenseImpl.setTradeLicenseNo(tradeLicenseNo);
		}

		if (tradeLicenseExpiryDate == Long.MIN_VALUE) {
			dgfRenewLicenseImpl.setTradeLicenseExpiryDate(null);
		}
		else {
			dgfRenewLicenseImpl.setTradeLicenseExpiryDate(
				new Date(tradeLicenseExpiryDate));
		}

		dgfRenewLicenseImpl.setTradeLicAttchId(tradeLicAttchId);
		dgfRenewLicenseImpl.setPaymentAttchId(paymentAttchId);

		if (applicationNo == null) {
			dgfRenewLicenseImpl.setApplicationNo("");
		}
		else {
			dgfRenewLicenseImpl.setApplicationNo(applicationNo);
		}

		if (licenseApplicationType == null) {
			dgfRenewLicenseImpl.setLicenseApplicationType("");
		}
		else {
			dgfRenewLicenseImpl.setLicenseApplicationType(
				licenseApplicationType);
		}

		if (comments == null) {
			dgfRenewLicenseImpl.setComments("");
		}
		else {
			dgfRenewLicenseImpl.setComments(comments);
		}

		if (createdDate == Long.MIN_VALUE) {
			dgfRenewLicenseImpl.setCreatedDate(null);
		}
		else {
			dgfRenewLicenseImpl.setCreatedDate(new Date(createdDate));
		}

		dgfRenewLicenseImpl.setModifiedBy(modifiedBy);

		if (modifiedDate == Long.MIN_VALUE) {
			dgfRenewLicenseImpl.setModifiedDate(null);
		}
		else {
			dgfRenewLicenseImpl.setModifiedDate(new Date(modifiedDate));
		}

		dgfRenewLicenseImpl.setFglPrePrimaryId(fglPrePrimaryId);
		dgfRenewLicenseImpl.setStatus(status);
		dgfRenewLicenseImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			dgfRenewLicenseImpl.setStatusByUserName("");
		}
		else {
			dgfRenewLicenseImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			dgfRenewLicenseImpl.setStatusDate(null);
		}
		else {
			dgfRenewLicenseImpl.setStatusDate(new Date(statusDate));
		}

		dgfRenewLicenseImpl.resetOriginalValues();

		return dgfRenewLicenseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		renewLicenseId = objectInput.readLong();

		userId = objectInput.readLong();
		nationalId = objectInput.readUTF();
		licenseNo = objectInput.readUTF();
		licenseExpiryDate = objectInput.readLong();
		tradeLicenseNo = objectInput.readUTF();
		tradeLicenseExpiryDate = objectInput.readLong();

		tradeLicAttchId = objectInput.readLong();

		paymentAttchId = objectInput.readLong();
		applicationNo = objectInput.readUTF();
		licenseApplicationType = objectInput.readUTF();
		comments = objectInput.readUTF();
		createdDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		fglPrePrimaryId = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(renewLicenseId);

		objectOutput.writeLong(userId);

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

		objectOutput.writeLong(licenseExpiryDate);

		if (tradeLicenseNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tradeLicenseNo);
		}

		objectOutput.writeLong(tradeLicenseExpiryDate);

		objectOutput.writeLong(tradeLicAttchId);

		objectOutput.writeLong(paymentAttchId);

		if (applicationNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(applicationNo);
		}

		if (licenseApplicationType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(licenseApplicationType);
		}

		if (comments == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(comments);
		}

		objectOutput.writeLong(createdDate);

		objectOutput.writeLong(modifiedBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(fglPrePrimaryId);

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

	public long renewLicenseId;
	public long userId;
	public String nationalId;
	public String licenseNo;
	public long licenseExpiryDate;
	public String tradeLicenseNo;
	public long tradeLicenseExpiryDate;
	public long tradeLicAttchId;
	public long paymentAttchId;
	public String applicationNo;
	public String licenseApplicationType;
	public String comments;
	public long createdDate;
	public long modifiedBy;
	public long modifiedDate;
	public long fglPrePrimaryId;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}