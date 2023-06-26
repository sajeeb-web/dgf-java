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
 * Provides the remote service utility for DgfDlrUpdtTempDtls. This utility wraps
 * <code>bd.gov.dgfood.dealer.registration.service.impl.DgfDlrUpdtTempDtlsServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrUpdtTempDtlsService
 * @generated
 */
public class DgfDlrUpdtTempDtlsServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>bd.gov.dgfood.dealer.registration.service.impl.DgfDlrUpdtTempDtlsServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.json.JSONObject
		saveDgfDlrUpdtTempDtls(
			java.lang.String nid, long phsclyChlnGdAttchId, int workInGovt,
			int publcRep, int physclyChlngd, long shopDiv, long shopDis,
			long shopUpazila, long shopUnion, java.lang.String shopWard,
			java.lang.String shopZipCode, java.lang.String shopLoc,
			long shopHeight, long shopLength, long shopWidth,
			long shopStorageCap, int isCemented, int signBoard,
			int dlrRunShpHimself, java.lang.String dealershipMemName,
			java.lang.String dealershipMemType, int truckType,
			java.lang.String truckRentFlag, java.lang.String truckPlatNo,
			long truckCap, java.lang.String truckMake,
			java.lang.String truckModel, long truckManuYear, long dlrPerfYr1SN,
			long dlrPerfYr1AllocQty, long dlrPerfYr1ComdtyQty,
			java.lang.String dlrPerfYr1DlrCtgry,
			java.lang.String dlrPerfYr1Rmrk, long dlrPerfYr2SN,
			long dlrPerfYr2AllocQty, long dlrPerfYr2ComdtyQty,
			java.lang.String dlrPerfYr2DlrCtgry,
			java.lang.String dlrPerfYr2Rmrk, long dlrPerfYr3SN,
			long dlrPerfYr3AllocQty, long dlrPerfYr3ComdtyQty,
			java.lang.String dlrPerfYr3DlrCtgry,
			java.lang.String dlrPerfYr3Rmrk, int dlrOptFoodgrainLicense,
			int dlrOptTradeLicense, int dlrOptTcvDlrLicense,
			int dlrOptImportLicense, int dlrOptLicenseEssentialGoods,
			int dlrOptTradeLicenseAgriculture) {

		return getService().saveDgfDlrUpdtTempDtls(
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

	public static DgfDlrUpdtTempDtlsService getService() {
		return _service;
	}

	private static volatile DgfDlrUpdtTempDtlsService _service;

}