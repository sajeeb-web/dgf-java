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

import bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetails;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DgfUsersOtpDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DgfUsersOtpDetailsCacheModel
	implements CacheModel<DgfUsersOtpDetails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DgfUsersOtpDetailsCacheModel)) {
			return false;
		}

		DgfUsersOtpDetailsCacheModel dgfUsersOtpDetailsCacheModel =
			(DgfUsersOtpDetailsCacheModel)object;

		if (otpId == dgfUsersOtpDetailsCacheModel.otpId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, otpId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{otpId=");
		sb.append(otpId);
		sb.append(", nationalId=");
		sb.append(nationalId);
		sb.append(", otp=");
		sb.append(otp);
		sb.append(", otpRequestTime=");
		sb.append(otpRequestTime);
		sb.append(", otpLoginTime=");
		sb.append(otpLoginTime);
		sb.append(", otpExpireTime=");
		sb.append(otpExpireTime);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userRegNo=");
		sb.append(userRegNo);
		sb.append(", mobileNo=");
		sb.append(mobileNo);
		sb.append(", emailId=");
		sb.append(emailId);
		sb.append(", otpVerify=");
		sb.append(otpVerify);
		sb.append(", isSent=");
		sb.append(isSent);
		sb.append(", message=");
		sb.append(message);
		sb.append(", requestUrl=");
		sb.append(requestUrl);
		sb.append(", responseData=");
		sb.append(responseData);
		sb.append(", responseStatusCode=");
		sb.append(responseStatusCode);
		sb.append(", responseResult=");
		sb.append(responseResult);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DgfUsersOtpDetails toEntityModel() {
		DgfUsersOtpDetailsImpl dgfUsersOtpDetailsImpl =
			new DgfUsersOtpDetailsImpl();

		dgfUsersOtpDetailsImpl.setOtpId(otpId);

		if (nationalId == null) {
			dgfUsersOtpDetailsImpl.setNationalId("");
		}
		else {
			dgfUsersOtpDetailsImpl.setNationalId(nationalId);
		}

		dgfUsersOtpDetailsImpl.setOtp(otp);

		if (otpRequestTime == Long.MIN_VALUE) {
			dgfUsersOtpDetailsImpl.setOtpRequestTime(null);
		}
		else {
			dgfUsersOtpDetailsImpl.setOtpRequestTime(new Date(otpRequestTime));
		}

		if (otpLoginTime == Long.MIN_VALUE) {
			dgfUsersOtpDetailsImpl.setOtpLoginTime(null);
		}
		else {
			dgfUsersOtpDetailsImpl.setOtpLoginTime(new Date(otpLoginTime));
		}

		if (otpExpireTime == Long.MIN_VALUE) {
			dgfUsersOtpDetailsImpl.setOtpExpireTime(null);
		}
		else {
			dgfUsersOtpDetailsImpl.setOtpExpireTime(new Date(otpExpireTime));
		}

		dgfUsersOtpDetailsImpl.setUserId(userId);
		dgfUsersOtpDetailsImpl.setUserRegNo(userRegNo);

		if (mobileNo == null) {
			dgfUsersOtpDetailsImpl.setMobileNo("");
		}
		else {
			dgfUsersOtpDetailsImpl.setMobileNo(mobileNo);
		}

		if (emailId == null) {
			dgfUsersOtpDetailsImpl.setEmailId("");
		}
		else {
			dgfUsersOtpDetailsImpl.setEmailId(emailId);
		}

		if (otpVerify == null) {
			dgfUsersOtpDetailsImpl.setOtpVerify("");
		}
		else {
			dgfUsersOtpDetailsImpl.setOtpVerify(otpVerify);
		}

		dgfUsersOtpDetailsImpl.setIsSent(isSent);

		if (message == null) {
			dgfUsersOtpDetailsImpl.setMessage("");
		}
		else {
			dgfUsersOtpDetailsImpl.setMessage(message);
		}

		if (requestUrl == null) {
			dgfUsersOtpDetailsImpl.setRequestUrl("");
		}
		else {
			dgfUsersOtpDetailsImpl.setRequestUrl(requestUrl);
		}

		if (responseData == null) {
			dgfUsersOtpDetailsImpl.setResponseData("");
		}
		else {
			dgfUsersOtpDetailsImpl.setResponseData(responseData);
		}

		dgfUsersOtpDetailsImpl.setResponseStatusCode(responseStatusCode);

		if (responseResult == null) {
			dgfUsersOtpDetailsImpl.setResponseResult("");
		}
		else {
			dgfUsersOtpDetailsImpl.setResponseResult(responseResult);
		}

		dgfUsersOtpDetailsImpl.resetOriginalValues();

		return dgfUsersOtpDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		otpId = objectInput.readLong();
		nationalId = objectInput.readUTF();

		otp = objectInput.readLong();
		otpRequestTime = objectInput.readLong();
		otpLoginTime = objectInput.readLong();
		otpExpireTime = objectInput.readLong();

		userId = objectInput.readLong();

		userRegNo = objectInput.readLong();
		mobileNo = objectInput.readUTF();
		emailId = objectInput.readUTF();
		otpVerify = objectInput.readUTF();

		isSent = objectInput.readBoolean();
		message = objectInput.readUTF();
		requestUrl = objectInput.readUTF();
		responseData = objectInput.readUTF();

		responseStatusCode = objectInput.readInt();
		responseResult = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(otpId);

		if (nationalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationalId);
		}

		objectOutput.writeLong(otp);
		objectOutput.writeLong(otpRequestTime);
		objectOutput.writeLong(otpLoginTime);
		objectOutput.writeLong(otpExpireTime);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(userRegNo);

		if (mobileNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobileNo);
		}

		if (emailId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailId);
		}

		if (otpVerify == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(otpVerify);
		}

		objectOutput.writeBoolean(isSent);

		if (message == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(message);
		}

		if (requestUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(requestUrl);
		}

		if (responseData == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(responseData);
		}

		objectOutput.writeInt(responseStatusCode);

		if (responseResult == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(responseResult);
		}
	}

	public long otpId;
	public String nationalId;
	public long otp;
	public long otpRequestTime;
	public long otpLoginTime;
	public long otpExpireTime;
	public long userId;
	public long userRegNo;
	public String mobileNo;
	public String emailId;
	public String otpVerify;
	public boolean isSent;
	public String message;
	public String requestUrl;
	public String responseData;
	public int responseStatusCode;
	public String responseResult;

}