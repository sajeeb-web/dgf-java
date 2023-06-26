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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DgfDlrRegDtlsService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrRegDtlsService
 * @generated
 */
public class DgfDlrRegDtlsServiceWrapper
	implements DgfDlrRegDtlsService, ServiceWrapper<DgfDlrRegDtlsService> {

	public DgfDlrRegDtlsServiceWrapper() {
		this(null);
	}

	public DgfDlrRegDtlsServiceWrapper(
		DgfDlrRegDtlsService dgfDlrRegDtlsService) {

		_dgfDlrRegDtlsService = dgfDlrRegDtlsService;
	}

	@Override
	public String addDealerRegisterWorkflowAndSendMessage(
		long dlrRegNo, String nationalId) {

		return _dgfDlrRegDtlsService.addDealerRegisterWorkflowAndSendMessage(
			dlrRegNo, nationalId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getDlrAllAddress(
		String nid) {

		return _dgfDlrRegDtlsService.getDlrAllAddress(nid);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getDlrDetailData(
		String nid) {

		return _dgfDlrRegDtlsService.getDlrDetailData(nid);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getDlrListSearchResult(
		String dateFrom, String dateTo, String dateType, String nid, long union,
		String dealerType, int status, long roleId, String upazillaOrDistrict,
		long companyId) {

		return _dgfDlrRegDtlsService.getDlrListSearchResult(
			dateFrom, dateTo, dateType, nid, union, dealerType, status, roleId,
			upazillaOrDistrict, companyId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getDlrProfileData() {
		return _dgfDlrRegDtlsService.getDlrProfileData();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfDlrRegDtlsService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject saveFinalSubmitData(
		String nid) {

		return _dgfDlrRegDtlsService.saveFinalSubmitData(nid);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject saveRegData(
		String licenseNo, java.util.Date licnsIssueDate, String dealerShipType,
		String omsSubType, String nid, java.util.Date dob, String maritalStatus,
		String spouseName, String spouseFatherName, String spouseNid,
		java.util.Date spouseDob) {

		return _dgfDlrRegDtlsService.saveRegData(
			licenseNo, licnsIssueDate, dealerShipType, omsSubType, nid, dob,
			maritalStatus, spouseName, spouseFatherName, spouseNid, spouseDob);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject saveRegDocData(
		String nid, long bankSolvCertAttchId, long taxRtrnCertAttchId,
		long shopOwnrshpDocAttchId, long shopRentalDocAttchId,
		long signOrThumbPicAttchId) {

		return _dgfDlrRegDtlsService.saveRegDocData(
			nid, bankSolvCertAttchId, taxRtrnCertAttchId, shopOwnrshpDocAttchId,
			shopRentalDocAttchId, signOrThumbPicAttchId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject saveRegLocData(
		String nid, long shopDiv, long shopDis, long shopUpazila,
		long shopUnion) {

		return _dgfDlrRegDtlsService.saveRegLocData(
			nid, shopDiv, shopDis, shopUpazila, shopUnion);
	}

	@Override
	public DgfDlrRegDtlsService getWrappedService() {
		return _dgfDlrRegDtlsService;
	}

	@Override
	public void setWrappedService(DgfDlrRegDtlsService dgfDlrRegDtlsService) {
		_dgfDlrRegDtlsService = dgfDlrRegDtlsService;
	}

	private DgfDlrRegDtlsService _dgfDlrRegDtlsService;

}