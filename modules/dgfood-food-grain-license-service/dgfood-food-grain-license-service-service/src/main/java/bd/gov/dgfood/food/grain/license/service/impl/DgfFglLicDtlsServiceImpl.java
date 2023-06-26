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

import bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls;
import bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls;
import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.model.dgfLocDivision;
import bd.gov.dgfood.food.grain.license.service.DgfFglPreDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.dgfLocDivisionLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.base.DgfFglLicDtlsServiceBaseImpl;
import bd.gov.dgfood.food.grain.license.service.util.PrincipalRoleAndLocationUtil;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = { "json.web.service.context.name=dgf",
		"json.web.service.context.path=DgfFglLicDtls" }, service = AopService.class)

public class DgfFglLicDtlsServiceImpl extends DgfFglLicDtlsServiceBaseImpl {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@JSONWebService(value = "checkFglLicense", method = "GET")
	public JSONObject checkFglLicense(String cmd, String licenseNo, String licenseIssueDate) {

		DgfFglLicDtls licObj = null;
		DgfFglPreDtls fglPreDtlsObj = null;
		String fglLicType = null;
		String LicNid = null;
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		if (cmd.equalsIgnoreCase("checkLicenseNo")) {
			if (licenseNo != null && !licenseNo.isEmpty()) {
				licObj = dgfFglLicDtlsLocalService.getDgfFglLicDtlsByFglLicNo(licenseNo);
				fglLicType = licObj.getFoodgrainLicenseType();
				LicNid = licObj.getNationalId();
			}

			jsonObject.put("isLicenseNo", (licObj != null && fglLicType != null && fglLicType.equalsIgnoreCase("Dealer")
					&& PrincipalRoleAndLocationUtil.isMatchUserWithNationalId(LicNid)) ? true : false);

			if (licObj != null && licenseIssueDate != null) {
				Date fglDtlsLicenseIssuedate = licObj.getFoodgrainLicenseIssueDate();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String dateStr = dateFormat.format(fglDtlsLicenseIssuedate);
				jsonObject.put("isDateCorrect", dateStr.equals(licenseIssueDate));

				String nid = licObj.getNationalId();
				try {
					fglPreDtlsObj = (DgfFglPreDtlsLocalServiceUtil
							.getDgfFglPreDtls(licObj.getFglPrePrimaryId()) != null)
									? DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(licObj.getFglPrePrimaryId())
									: fglPreDtlsObj;
				} catch (PortalException e) {
					log.error("DgfFglPreDtls not found by Nid" + ", " + e.getMessage());
				}

				Date dateOfBirth = (fglPreDtlsObj != null) ? fglPreDtlsObj.getBirthDate() : null;
				String dateOfBirthStr = dateFormat.format(dateOfBirth);
				jsonObject.put("nid", nid);
				jsonObject.put("dateOfBirth", dateOfBirthStr);
			}

			return jsonObject;
		}
		return jsonObject;
	}
}