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

package bd.gov.dgfood.dealer.registration.service.http;

import bd.gov.dgfood.dealer.registration.service.DgfDlrUpdtTempDtlsServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>DgfDlrUpdtTempDtlsServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DgfDlrUpdtTempDtlsServiceHttp {

	public static com.liferay.portal.kernel.json.JSONObject
		saveDgfDlrUpdtTempDtls(
			HttpPrincipal httpPrincipal, String nid, long phsclyChlnGdAttchId,
			int workInGovt, int publcRep, int physclyChlngd, long shopDiv,
			long shopDis, long shopUpazila, long shopUnion, String shopWard,
			String shopZipCode, String shopLoc, long shopHeight,
			long shopLength, long shopWidth, long shopStorageCap,
			int isCemented, int signBoard, int dlrRunShpHimself,
			String dealershipMemName, String dealershipMemType, int truckType,
			String truckRentFlag, String truckPlatNo, long truckCap,
			String truckMake, String truckModel, long truckManuYear,
			long dlrPerfYr1SN, long dlrPerfYr1AllocQty,
			long dlrPerfYr1ComdtyQty, String dlrPerfYr1DlrCtgry,
			String dlrPerfYr1Rmrk, long dlrPerfYr2SN, long dlrPerfYr2AllocQty,
			long dlrPerfYr2ComdtyQty, String dlrPerfYr2DlrCtgry,
			String dlrPerfYr2Rmrk, long dlrPerfYr3SN, long dlrPerfYr3AllocQty,
			long dlrPerfYr3ComdtyQty, String dlrPerfYr3DlrCtgry,
			String dlrPerfYr3Rmrk, int dlrOptFoodgrainLicense,
			int dlrOptTradeLicense, int dlrOptTcvDlrLicense,
			int dlrOptImportLicense, int dlrOptLicenseEssentialGoods,
			int dlrOptTradeLicenseAgriculture) {

		try {
			MethodKey methodKey = new MethodKey(
				DgfDlrUpdtTempDtlsServiceUtil.class, "saveDgfDlrUpdtTempDtls",
				_saveDgfDlrUpdtTempDtlsParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, nid, phsclyChlnGdAttchId, workInGovt, publcRep,
				physclyChlngd, shopDiv, shopDis, shopUpazila, shopUnion,
				shopWard, shopZipCode, shopLoc, shopHeight, shopLength,
				shopWidth, shopStorageCap, isCemented, signBoard,
				dlrRunShpHimself, dealershipMemName, dealershipMemType,
				truckType, truckRentFlag, truckPlatNo, truckCap, truckMake,
				truckModel, truckManuYear, dlrPerfYr1SN, dlrPerfYr1AllocQty,
				dlrPerfYr1ComdtyQty, dlrPerfYr1DlrCtgry, dlrPerfYr1Rmrk,
				dlrPerfYr2SN, dlrPerfYr2AllocQty, dlrPerfYr2ComdtyQty,
				dlrPerfYr2DlrCtgry, dlrPerfYr2Rmrk, dlrPerfYr3SN,
				dlrPerfYr3AllocQty, dlrPerfYr3ComdtyQty, dlrPerfYr3DlrCtgry,
				dlrPerfYr3Rmrk, dlrOptFoodgrainLicense, dlrOptTradeLicense,
				dlrOptTcvDlrLicense, dlrOptImportLicense,
				dlrOptLicenseEssentialGoods, dlrOptTradeLicenseAgriculture);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		DgfDlrUpdtTempDtlsServiceHttp.class);

	private static final Class<?>[] _saveDgfDlrUpdtTempDtlsParameterTypes0 =
		new Class[] {
			String.class, long.class, int.class, int.class, int.class,
			long.class, long.class, long.class, long.class, String.class,
			String.class, String.class, long.class, long.class, long.class,
			long.class, int.class, int.class, int.class, String.class,
			String.class, int.class, String.class, String.class, long.class,
			String.class, String.class, long.class, long.class, long.class,
			long.class, String.class, String.class, long.class, long.class,
			long.class, String.class, String.class, long.class, long.class,
			long.class, String.class, String.class, int.class, int.class,
			int.class, int.class, int.class, int.class
		};

}