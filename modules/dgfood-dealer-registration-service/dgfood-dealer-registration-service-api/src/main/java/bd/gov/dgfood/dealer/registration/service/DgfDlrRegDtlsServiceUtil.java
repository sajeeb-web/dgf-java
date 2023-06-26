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

package bd.gov.dgfood.dealer.registration.service;

/**
 * Provides the remote service utility for DgfDlrRegDtls. This utility wraps
 * <code>bd.gov.dgfood.dealer.registration.service.impl.DgfDlrRegDtlsServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrRegDtlsService
 * @generated
 */
public class DgfDlrRegDtlsServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>bd.gov.dgfood.dealer.registration.service.impl.DgfDlrRegDtlsServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.lang.String addDealerRegisterWorkflowAndSendMessage(
		long dlrRegNo, java.lang.String nationalId) {

		return getService().addDealerRegisterWorkflowAndSendMessage(
			dlrRegNo, nationalId);
	}

	public static com.liferay.portal.kernel.json.JSONObject getDlrAllAddress(
		java.lang.String nid) {

		return getService().getDlrAllAddress(nid);
	}

	public static com.liferay.portal.kernel.json.JSONObject getDlrDetailData(
		java.lang.String nid) {

		return getService().getDlrDetailData(nid);
	}

	public static com.liferay.portal.kernel.json.JSONArray
		getDlrListSearchResult(
			java.lang.String dateFrom, java.lang.String dateTo,
			java.lang.String dateType, java.lang.String nid, long union,
			java.lang.String dealerType, int status, long roleId,
			java.lang.String upazillaOrDistrict, long companyId) {

		return getService().getDlrListSearchResult(
			dateFrom, dateTo, dateType, nid, union, dealerType, status, roleId,
			upazillaOrDistrict, companyId);
	}

	public static com.liferay.portal.kernel.json.JSONObject
		getDlrProfileData() {

		return getService().getDlrProfileData();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.json.JSONObject saveFinalSubmitData(
		java.lang.String nid) {

		return getService().saveFinalSubmitData(nid);
	}

	public static com.liferay.portal.kernel.json.JSONObject saveRegData(
		java.lang.String licenseNo, java.util.Date licnsIssueDate,
		java.lang.String dealerShipType, java.lang.String omsSubType,
		java.lang.String nid, java.util.Date dob,
		java.lang.String maritalStatus, java.lang.String spouseName,
		java.lang.String spouseFatherName, java.lang.String spouseNid,
		java.util.Date spouseDob) {

		return getService().saveRegData(
			licenseNo, licnsIssueDate, dealerShipType, omsSubType, nid, dob,
			maritalStatus, spouseName, spouseFatherName, spouseNid, spouseDob);
	}

	public static com.liferay.portal.kernel.json.JSONObject saveRegDocData(
		java.lang.String nid, long bankSolvCertAttchId, long taxRtrnCertAttchId,
		long shopOwnrshpDocAttchId, long shopRentalDocAttchId,
		long signOrThumbPicAttchId) {

		return getService().saveRegDocData(
			nid, bankSolvCertAttchId, taxRtrnCertAttchId, shopOwnrshpDocAttchId,
			shopRentalDocAttchId, signOrThumbPicAttchId);
	}

	public static com.liferay.portal.kernel.json.JSONObject saveRegLocData(
		java.lang.String nid, long shopDiv, long shopDis, long shopUpazila,
		long shopUnion) {

		return getService().saveRegLocData(
			nid, shopDiv, shopDis, shopUpazila, shopUnion);
	}

	public static DgfDlrRegDtlsService getService() {
		return _service;
	}

	private static volatile DgfDlrRegDtlsService _service;

}