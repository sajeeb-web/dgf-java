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

package bd.gov.dgfood.food.grain.license.service.impl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.food.grain.license.config.LicenseMessageUtil;
import bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetails;
import bd.gov.dgfood.food.grain.license.service.DgfUsersOtpDetailsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.base.DgfUsersOtpDetailsLocalServiceBaseImpl;
import bd.gov.dgfood.food.grain.license.util.SmsMessageApiUtil;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetails",
	service = AopService.class
)
public class DgfUsersOtpDetailsLocalServiceImpl
	extends DgfUsersOtpDetailsLocalServiceBaseImpl {
	
	@Reference
	LicenseMessageUtil licenseMessageUtil;
	@Reference
	SmsMessageApiUtil smsMessageApiUtil;

	@Override
	public DgfUsersOtpDetails addDgfUsersOtpDetailsByNidAndMobileAndUser(String nationalId, String mobileNo, long userId) {
		DgfUsersOtpDetails dgfUsersOtpDetails = DgfUsersOtpDetailsLocalServiceUtil
                .createDgfUsersOtpDetails(CounterLocalServiceUtil.increment());
		dgfUsersOtpDetails.setNationalId(nationalId);
		dgfUsersOtpDetails.setMobileNo(mobileNo);
		long otp = genarateOtp();
		String message = generateOtpMessage()+" "+otp;
		dgfUsersOtpDetails.setMessage(message);
		dgfUsersOtpDetails.setOtp(otp);
		dgfUsersOtpDetails.setUserId(userId);
		dgfUsersOtpDetails.setOtpRequestTime(new Date());
		dgfUsersOtpDetails.setIsSent(false);
		dgfUsersOtpDetails.setOtpVerify("PENDING");
		dgfUsersOtpDetails = DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetails(dgfUsersOtpDetails);
		return dgfUsersOtpDetails;
	}
	
	@Override
	public DgfUsersOtpDetails addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(String message, String nationalId, String mobileNo, long userId, long userRegNo) {
		DgfUsersOtpDetails dgfUsersOtpDetails = DgfUsersOtpDetailsLocalServiceUtil
                .createDgfUsersOtpDetails(CounterLocalServiceUtil.increment());
		dgfUsersOtpDetails.setMessage(message);
		dgfUsersOtpDetails.setNationalId(nationalId);
		dgfUsersOtpDetails.setMobileNo(mobileNo);
		dgfUsersOtpDetails.setUserId(userId);
		dgfUsersOtpDetails.setUserRegNo(userRegNo);
		dgfUsersOtpDetails.setOtpRequestTime(new Date());
		dgfUsersOtpDetails.setIsSent(false);
		dgfUsersOtpDetails = DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetails(dgfUsersOtpDetails);
		return dgfUsersOtpDetails;
	}
	
	@Override
	public DgfUsersOtpDetails verifyDgfUsersOtpDetailsByOtpAndOtpIdAndMobile(long otpId, long otp, String mobileNo) throws PortalException {
		DgfUsersOtpDetails dgfUsersOtpDetails = DgfUsersOtpDetailsLocalServiceUtil.getDgfUsersOtpDetails(otpId);
		if(Validator.isNotNull(dgfUsersOtpDetails)) {
			long checkOtp = dgfUsersOtpDetails.getOtp();
			if(checkOtp!=0 && checkOtp==otp && mobileNo.equals(dgfUsersOtpDetails.getMobileNo())) {
				dgfUsersOtpDetails.setOtpLoginTime(new Date());
				dgfUsersOtpDetails.setOtpVerify("SUCCESS");
				dgfUsersOtpDetails = DgfUsersOtpDetailsLocalServiceUtil.updateDgfUsersOtpDetails(dgfUsersOtpDetails);
			}else {
				dgfUsersOtpDetails = null;
			}
		}
		return dgfUsersOtpDetails;
	}

	public List<DgfUsersOtpDetails> findByIsSent(boolean isSent) {
		DynamicQuery dynamicQuery = DgfUsersOtpDetailsLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.eq("isSent", isSent));
		List<DgfUsersOtpDetails> dgfUsersOtpDetailsList = DgfUsersOtpDetailsLocalServiceUtil.dynamicQuery(dynamicQuery);

		return dgfUsersOtpDetailsList;
	}
	
	public List<DgfUsersOtpDetails> findOtpDetailsByMobileNo(String mobileNo) {
		DynamicQuery dynamicQuery = DgfUsersOtpDetailsLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.eq("mobileNo", mobileNo));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("otpRequestTime"));
		List<DgfUsersOtpDetails> dgfUsersOtpDetailsList = DgfUsersOtpDetailsLocalServiceUtil.dynamicQuery(dynamicQuery);
		return dgfUsersOtpDetailsList;
	}
	
	public long genarateOtp() {
		int genarateOtp = 1000 + (int) (Math.random() * 9000);
		return genarateOtp;
	}
	
	public String generateOtpMessage() {
		String preparedMessage = licenseMessageUtil.getOtpMessage();
		return preparedMessage;
	}
	
	public boolean callSmsMessageApiByOtpId(long otpId) {
		return smsMessageApiUtil.callSmsMessageApiByOtpId(otpId);
	}
	
	public boolean callSmsMessageApi(String message, String mobileNo) {
		return smsMessageApiUtil.callSmsMessageApi(message, mobileNo);
	}
	
}