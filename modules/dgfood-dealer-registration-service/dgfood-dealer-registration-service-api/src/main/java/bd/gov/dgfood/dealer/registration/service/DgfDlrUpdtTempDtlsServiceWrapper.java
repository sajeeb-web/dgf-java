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
 * Provides a wrapper for {@link DgfDlrUpdtTempDtlsService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrUpdtTempDtlsService
 * @generated
 */
public class DgfDlrUpdtTempDtlsServiceWrapper
	implements DgfDlrUpdtTempDtlsService,
			   ServiceWrapper<DgfDlrUpdtTempDtlsService> {

	public DgfDlrUpdtTempDtlsServiceWrapper() {
		this(null);
	}

	public DgfDlrUpdtTempDtlsServiceWrapper(
		DgfDlrUpdtTempDtlsService dgfDlrUpdtTempDtlsService) {

		_dgfDlrUpdtTempDtlsService = dgfDlrUpdtTempDtlsService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfDlrUpdtTempDtlsService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject saveDgfDlrUpdtTempDtls(
		String nid, long phsclyChlnGdAttchId, int workInGovt, int publcRep,
		int physclyChlngd, long shopDiv, long shopDis, long shopUpazila,
		long shopUnion, String shopWard, String shopZipCode, String shopLoc,
		long shopHeight, long shopLength, long shopWidth, long shopStorageCap,
		int isCemented, int signBoard, int dlrRunShpHimself,
		String dealershipMemName, String dealershipMemType, int truckType,
		String truckRentFlag, String truckPlatNo, long truckCap,
		String truckMake, String truckModel, long truckManuYear,
		long dlrPerfYr1SN, long dlrPerfYr1AllocQty, long dlrPerfYr1ComdtyQty,
		String dlrPerfYr1DlrCtgry, String dlrPerfYr1Rmrk, long dlrPerfYr2SN,
		long dlrPerfYr2AllocQty, long dlrPerfYr2ComdtyQty,
		String dlrPerfYr2DlrCtgry, String dlrPerfYr2Rmrk, long dlrPerfYr3SN,
		long dlrPerfYr3AllocQty, long dlrPerfYr3ComdtyQty,
		String dlrPerfYr3DlrCtgry, String dlrPerfYr3Rmrk,
		int dlrOptFoodgrainLicense, int dlrOptTradeLicense,
		int dlrOptTcvDlrLicense, int dlrOptImportLicense,
		int dlrOptLicenseEssentialGoods, int dlrOptTradeLicenseAgriculture) {

		return _dgfDlrUpdtTempDtlsService.saveDgfDlrUpdtTempDtls(
			nid, phsclyChlnGdAttchId, workInGovt, publcRep, physclyChlngd,
			shopDiv, shopDis, shopUpazila, shopUnion, shopWard, shopZipCode,
			shopLoc, shopHeight, shopLength, shopWidth, shopStorageCap,
			isCemented, signBoard, dlrRunShpHimself, dealershipMemName,
			dealershipMemType, truckType, truckRentFlag, truckPlatNo, truckCap,
			truckMake, truckModel, truckManuYear, dlrPerfYr1SN,
			dlrPerfYr1AllocQty, dlrPerfYr1ComdtyQty, dlrPerfYr1DlrCtgry,
			dlrPerfYr1Rmrk, dlrPerfYr2SN, dlrPerfYr2AllocQty,
			dlrPerfYr2ComdtyQty, dlrPerfYr2DlrCtgry, dlrPerfYr2Rmrk,
			dlrPerfYr3SN, dlrPerfYr3AllocQty, dlrPerfYr3ComdtyQty,
			dlrPerfYr3DlrCtgry, dlrPerfYr3Rmrk, dlrOptFoodgrainLicense,
			dlrOptTradeLicense, dlrOptTcvDlrLicense, dlrOptImportLicense,
			dlrOptLicenseEssentialGoods, dlrOptTradeLicenseAgriculture);
	}

	@Override
	public DgfDlrUpdtTempDtlsService getWrappedService() {
		return _dgfDlrUpdtTempDtlsService;
	}

	@Override
	public void setWrappedService(
		DgfDlrUpdtTempDtlsService dgfDlrUpdtTempDtlsService) {

		_dgfDlrUpdtTempDtlsService = dgfDlrUpdtTempDtlsService;
	}

	private DgfDlrUpdtTempDtlsService _dgfDlrUpdtTempDtlsService;

}