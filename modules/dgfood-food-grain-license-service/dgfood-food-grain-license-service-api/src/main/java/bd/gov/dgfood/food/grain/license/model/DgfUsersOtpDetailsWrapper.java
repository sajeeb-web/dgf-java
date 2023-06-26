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
 * This class is a wrapper for {@link DgfUsersOtpDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersOtpDetails
 * @generated
 */
public class DgfUsersOtpDetailsWrapper
	extends BaseModelWrapper<DgfUsersOtpDetails>
	implements DgfUsersOtpDetails, ModelWrapper<DgfUsersOtpDetails> {

	public DgfUsersOtpDetailsWrapper(DgfUsersOtpDetails dgfUsersOtpDetails) {
		super(dgfUsersOtpDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("otpId", getOtpId());
		attributes.put("nationalId", getNationalId());
		attributes.put("otp", getOtp());
		attributes.put("otpRequestTime", getOtpRequestTime());
		attributes.put("otpLoginTime", getOtpLoginTime());
		attributes.put("otpExpireTime", getOtpExpireTime());
		attributes.put("userId", getUserId());
		attributes.put("userRegNo", getUserRegNo());
		attributes.put("mobileNo", getMobileNo());
		attributes.put("emailId", getEmailId());
		attributes.put("otpVerify", getOtpVerify());
		attributes.put("isSent", isIsSent());
		attributes.put("message", getMessage());
		attributes.put("requestUrl", getRequestUrl());
		attributes.put("responseData", getResponseData());
		attributes.put("responseStatusCode", getResponseStatusCode());
		attributes.put("responseResult", getResponseResult());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long otpId = (Long)attributes.get("otpId");

		if (otpId != null) {
			setOtpId(otpId);
		}

		String nationalId = (String)attributes.get("nationalId");

		if (nationalId != null) {
			setNationalId(nationalId);
		}

		Long otp = (Long)attributes.get("otp");

		if (otp != null) {
			setOtp(otp);
		}

		Date otpRequestTime = (Date)attributes.get("otpRequestTime");

		if (otpRequestTime != null) {
			setOtpRequestTime(otpRequestTime);
		}

		Date otpLoginTime = (Date)attributes.get("otpLoginTime");

		if (otpLoginTime != null) {
			setOtpLoginTime(otpLoginTime);
		}

		Date otpExpireTime = (Date)attributes.get("otpExpireTime");

		if (otpExpireTime != null) {
			setOtpExpireTime(otpExpireTime);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long userRegNo = (Long)attributes.get("userRegNo");

		if (userRegNo != null) {
			setUserRegNo(userRegNo);
		}

		String mobileNo = (String)attributes.get("mobileNo");

		if (mobileNo != null) {
			setMobileNo(mobileNo);
		}

		String emailId = (String)attributes.get("emailId");

		if (emailId != null) {
			setEmailId(emailId);
		}

		String otpVerify = (String)attributes.get("otpVerify");

		if (otpVerify != null) {
			setOtpVerify(otpVerify);
		}

		Boolean isSent = (Boolean)attributes.get("isSent");

		if (isSent != null) {
			setIsSent(isSent);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		String requestUrl = (String)attributes.get("requestUrl");

		if (requestUrl != null) {
			setRequestUrl(requestUrl);
		}

		String responseData = (String)attributes.get("responseData");

		if (responseData != null) {
			setResponseData(responseData);
		}

		Integer responseStatusCode = (Integer)attributes.get(
			"responseStatusCode");

		if (responseStatusCode != null) {
			setResponseStatusCode(responseStatusCode);
		}

		String responseResult = (String)attributes.get("responseResult");

		if (responseResult != null) {
			setResponseResult(responseResult);
		}
	}

	@Override
	public DgfUsersOtpDetails cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the email ID of this dgf users otp details.
	 *
	 * @return the email ID of this dgf users otp details
	 */
	@Override
	public String getEmailId() {
		return model.getEmailId();
	}

	/**
	 * Returns the is sent of this dgf users otp details.
	 *
	 * @return the is sent of this dgf users otp details
	 */
	@Override
	public boolean getIsSent() {
		return model.getIsSent();
	}

	/**
	 * Returns the message of this dgf users otp details.
	 *
	 * @return the message of this dgf users otp details
	 */
	@Override
	public String getMessage() {
		return model.getMessage();
	}

	/**
	 * Returns the mobile no of this dgf users otp details.
	 *
	 * @return the mobile no of this dgf users otp details
	 */
	@Override
	public String getMobileNo() {
		return model.getMobileNo();
	}

	/**
	 * Returns the national ID of this dgf users otp details.
	 *
	 * @return the national ID of this dgf users otp details
	 */
	@Override
	public String getNationalId() {
		return model.getNationalId();
	}

	/**
	 * Returns the otp of this dgf users otp details.
	 *
	 * @return the otp of this dgf users otp details
	 */
	@Override
	public long getOtp() {
		return model.getOtp();
	}

	/**
	 * Returns the otp expire time of this dgf users otp details.
	 *
	 * @return the otp expire time of this dgf users otp details
	 */
	@Override
	public Date getOtpExpireTime() {
		return model.getOtpExpireTime();
	}

	/**
	 * Returns the otp ID of this dgf users otp details.
	 *
	 * @return the otp ID of this dgf users otp details
	 */
	@Override
	public long getOtpId() {
		return model.getOtpId();
	}

	/**
	 * Returns the otp login time of this dgf users otp details.
	 *
	 * @return the otp login time of this dgf users otp details
	 */
	@Override
	public Date getOtpLoginTime() {
		return model.getOtpLoginTime();
	}

	/**
	 * Returns the otp request time of this dgf users otp details.
	 *
	 * @return the otp request time of this dgf users otp details
	 */
	@Override
	public Date getOtpRequestTime() {
		return model.getOtpRequestTime();
	}

	/**
	 * Returns the otp verify of this dgf users otp details.
	 *
	 * @return the otp verify of this dgf users otp details
	 */
	@Override
	public String getOtpVerify() {
		return model.getOtpVerify();
	}

	/**
	 * Returns the primary key of this dgf users otp details.
	 *
	 * @return the primary key of this dgf users otp details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the request url of this dgf users otp details.
	 *
	 * @return the request url of this dgf users otp details
	 */
	@Override
	public String getRequestUrl() {
		return model.getRequestUrl();
	}

	/**
	 * Returns the response data of this dgf users otp details.
	 *
	 * @return the response data of this dgf users otp details
	 */
	@Override
	public String getResponseData() {
		return model.getResponseData();
	}

	/**
	 * Returns the response result of this dgf users otp details.
	 *
	 * @return the response result of this dgf users otp details
	 */
	@Override
	public String getResponseResult() {
		return model.getResponseResult();
	}

	/**
	 * Returns the response status code of this dgf users otp details.
	 *
	 * @return the response status code of this dgf users otp details
	 */
	@Override
	public int getResponseStatusCode() {
		return model.getResponseStatusCode();
	}

	/**
	 * Returns the user ID of this dgf users otp details.
	 *
	 * @return the user ID of this dgf users otp details
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user reg no of this dgf users otp details.
	 *
	 * @return the user reg no of this dgf users otp details
	 */
	@Override
	public long getUserRegNo() {
		return model.getUserRegNo();
	}

	/**
	 * Returns the user uuid of this dgf users otp details.
	 *
	 * @return the user uuid of this dgf users otp details
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this dgf users otp details is is sent.
	 *
	 * @return <code>true</code> if this dgf users otp details is is sent; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsSent() {
		return model.isIsSent();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the email ID of this dgf users otp details.
	 *
	 * @param emailId the email ID of this dgf users otp details
	 */
	@Override
	public void setEmailId(String emailId) {
		model.setEmailId(emailId);
	}

	/**
	 * Sets whether this dgf users otp details is is sent.
	 *
	 * @param isSent the is sent of this dgf users otp details
	 */
	@Override
	public void setIsSent(boolean isSent) {
		model.setIsSent(isSent);
	}

	/**
	 * Sets the message of this dgf users otp details.
	 *
	 * @param message the message of this dgf users otp details
	 */
	@Override
	public void setMessage(String message) {
		model.setMessage(message);
	}

	/**
	 * Sets the mobile no of this dgf users otp details.
	 *
	 * @param mobileNo the mobile no of this dgf users otp details
	 */
	@Override
	public void setMobileNo(String mobileNo) {
		model.setMobileNo(mobileNo);
	}

	/**
	 * Sets the national ID of this dgf users otp details.
	 *
	 * @param nationalId the national ID of this dgf users otp details
	 */
	@Override
	public void setNationalId(String nationalId) {
		model.setNationalId(nationalId);
	}

	/**
	 * Sets the otp of this dgf users otp details.
	 *
	 * @param otp the otp of this dgf users otp details
	 */
	@Override
	public void setOtp(long otp) {
		model.setOtp(otp);
	}

	/**
	 * Sets the otp expire time of this dgf users otp details.
	 *
	 * @param otpExpireTime the otp expire time of this dgf users otp details
	 */
	@Override
	public void setOtpExpireTime(Date otpExpireTime) {
		model.setOtpExpireTime(otpExpireTime);
	}

	/**
	 * Sets the otp ID of this dgf users otp details.
	 *
	 * @param otpId the otp ID of this dgf users otp details
	 */
	@Override
	public void setOtpId(long otpId) {
		model.setOtpId(otpId);
	}

	/**
	 * Sets the otp login time of this dgf users otp details.
	 *
	 * @param otpLoginTime the otp login time of this dgf users otp details
	 */
	@Override
	public void setOtpLoginTime(Date otpLoginTime) {
		model.setOtpLoginTime(otpLoginTime);
	}

	/**
	 * Sets the otp request time of this dgf users otp details.
	 *
	 * @param otpRequestTime the otp request time of this dgf users otp details
	 */
	@Override
	public void setOtpRequestTime(Date otpRequestTime) {
		model.setOtpRequestTime(otpRequestTime);
	}

	/**
	 * Sets the otp verify of this dgf users otp details.
	 *
	 * @param otpVerify the otp verify of this dgf users otp details
	 */
	@Override
	public void setOtpVerify(String otpVerify) {
		model.setOtpVerify(otpVerify);
	}

	/**
	 * Sets the primary key of this dgf users otp details.
	 *
	 * @param primaryKey the primary key of this dgf users otp details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the request url of this dgf users otp details.
	 *
	 * @param requestUrl the request url of this dgf users otp details
	 */
	@Override
	public void setRequestUrl(String requestUrl) {
		model.setRequestUrl(requestUrl);
	}

	/**
	 * Sets the response data of this dgf users otp details.
	 *
	 * @param responseData the response data of this dgf users otp details
	 */
	@Override
	public void setResponseData(String responseData) {
		model.setResponseData(responseData);
	}

	/**
	 * Sets the response result of this dgf users otp details.
	 *
	 * @param responseResult the response result of this dgf users otp details
	 */
	@Override
	public void setResponseResult(String responseResult) {
		model.setResponseResult(responseResult);
	}

	/**
	 * Sets the response status code of this dgf users otp details.
	 *
	 * @param responseStatusCode the response status code of this dgf users otp details
	 */
	@Override
	public void setResponseStatusCode(int responseStatusCode) {
		model.setResponseStatusCode(responseStatusCode);
	}

	/**
	 * Sets the user ID of this dgf users otp details.
	 *
	 * @param userId the user ID of this dgf users otp details
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user reg no of this dgf users otp details.
	 *
	 * @param userRegNo the user reg no of this dgf users otp details
	 */
	@Override
	public void setUserRegNo(long userRegNo) {
		model.setUserRegNo(userRegNo);
	}

	/**
	 * Sets the user uuid of this dgf users otp details.
	 *
	 * @param userUuid the user uuid of this dgf users otp details
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DgfUsersOtpDetailsWrapper wrap(
		DgfUsersOtpDetails dgfUsersOtpDetails) {

		return new DgfUsersOtpDetailsWrapper(dgfUsersOtpDetails);
	}

}