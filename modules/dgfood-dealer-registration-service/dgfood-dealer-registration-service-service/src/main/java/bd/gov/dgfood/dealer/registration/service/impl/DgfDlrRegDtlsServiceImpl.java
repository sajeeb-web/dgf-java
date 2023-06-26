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

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls;
import bd.gov.dgfood.dealer.registration.service.DgfDlrRegDtlsLocalServiceUtil;
import bd.gov.dgfood.dealer.registration.service.base.DgfDlrRegDtlsServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = { "json.web.service.context.name=dgf",
		"json.web.service.context.path=DgfDlrRegDtls" }, service = AopService.class)
public class DgfDlrRegDtlsServiceImpl extends DgfDlrRegDtlsServiceBaseImpl {

	public JSONObject saveRegData(String licenseNo,Date licnsIssueDate,String dealerShipType,String omsSubType,String nid,Date dob,String maritalStatus,String spouseName,String spouseFatherName,String spouseNid,Date spouseDob) {
		DgfDlrRegDtls dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.saveRegData(licenseNo,licnsIssueDate,dealerShipType,omsSubType,nid,dob,maritalStatus,spouseName,spouseFatherName,spouseNid,spouseDob);
		return JSONFactoryUtil.createJSONObject(dgfDlrRegDtls.getModelAttributes());
	}
	public JSONObject saveRegLocData(String nid,long shopDiv,long shopDis,long shopUpazila,long shopUnion) {
		DgfDlrRegDtls dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.saveRegLocData(nid,shopDiv,shopDis,shopUpazila,shopUnion);
		return JSONFactoryUtil.createJSONObject(dgfDlrRegDtls.getModelAttributes());
	}
	public JSONObject saveRegDocData(String nid,long bankSolvCertAttchId,long taxRtrnCertAttchId, long shopOwnrshpDocAttchId,long shopRentalDocAttchId, long signOrThumbPicAttchId) {
		DgfDlrRegDtls dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.saveRegDocData(nid,bankSolvCertAttchId,taxRtrnCertAttchId,shopOwnrshpDocAttchId,shopRentalDocAttchId,signOrThumbPicAttchId);
		return JSONFactoryUtil.createJSONObject(dgfDlrRegDtls.getModelAttributes());
	}
	public JSONObject saveFinalSubmitData(String nid) {
		DgfDlrRegDtls dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.saveFinalSubmitData(nid);
		return JSONFactoryUtil.createJSONObject(dgfDlrRegDtls.getModelAttributes());
	}

	public JSONArray getDlrListSearchResult(String dateFrom, String dateTo, String dateType, String nid, long union,
			String dealerType, int status, long roleId, String upazillaOrDistrict,
			long companyId) {
		List<Map<String, Object>> dealerApplList = DgfDlrRegDtlsLocalServiceUtil.getDlrListSearchResult(dateFrom,
				dateTo, dateType, nid, union, dealerType, status, roleId, upazillaOrDistrict, companyId);
		return JSONFactoryUtil.createJSONArray(dealerApplList);
	}

	public JSONObject getDlrDetailData(String nid) {
		Map<String, Object> dealerDealerData = DgfDlrRegDtlsLocalServiceUtil.getDealerData(nid);
		return JSONFactoryUtil.createJSONObject(dealerDealerData);
	}

	public JSONObject getDlrAllAddress(String nid) {
		Map<String, String> address = new HashMap<String, String>();

		try {
			address = DgfDlrRegDtlsLocalServiceUtil.getAllAddrs(nid);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return JSONFactoryUtil.createJSONObject(address);
	}
	
	public String addDealerRegisterWorkflowAndSendMessage(long dlrRegNo, String nationalId) {
		boolean isSuccess = DgfDlrRegDtlsLocalServiceUtil.addDealerRegisterWorkflowAndSendMessage(dlrRegNo, nationalId);
		if(isSuccess) {
			return "SUCCESS";
		}else {
			return "FAIL";
		}
	}
	public JSONObject getDlrProfileData() {
		Map dealerProfileData = DgfDlrRegDtlsLocalServiceUtil.getDealerProfileData();
		return JSONFactoryUtil.createJSONObject(dealerProfileData);
	}
}