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

package bd.gov.dgfood.dealer.registration.service.impl;

import bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawal;
import bd.gov.dgfood.dealer.registration.service.DgfDlrWithdrawalLocalServiceUtil;
import bd.gov.dgfood.dealer.registration.service.base.DgfDlrWithdrawalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = { "json.web.service.context.name=dlr",
		"json.web.service.context.path=DgfDlrWithdrawal" }, service = AopService.class)
public class DgfDlrWithdrawalServiceImpl extends DgfDlrWithdrawalServiceBaseImpl {

	public JSONObject saveWithdrawalData(String nationalId, String licenseNo, String dealerName, String mobileNo,
			String reason, String programType) {

		DgfDlrWithdrawal dgfDlrWithdrawal = DgfDlrWithdrawalLocalServiceUtil.saveWithdrawalData(nationalId, licenseNo,
				dealerName, mobileNo, reason, programType);

		JSONObject json = JSONFactoryUtil.createJSONObject();

		// Convert the DgfDlrWithdrawal object to a JSONObject
		json.put("nationalId", dgfDlrWithdrawal.getNationalId());
		json.put("licenseNo", dgfDlrWithdrawal.getLicenseNo());
		json.put("dealerName", dgfDlrWithdrawal.getDealerName());
		json.put("mobileNo", dgfDlrWithdrawal.getMobileNo());
		json.put("reason", dgfDlrWithdrawal.getReason());
		json.put("programType", dgfDlrWithdrawal.getProgramType());

		return json;
	}

}