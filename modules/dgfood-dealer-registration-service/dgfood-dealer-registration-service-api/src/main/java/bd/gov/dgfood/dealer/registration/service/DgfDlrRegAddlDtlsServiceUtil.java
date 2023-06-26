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
 * Provides the remote service utility for DgfDlrRegAddlDtls. This utility wraps
 * <code>bd.gov.dgfood.dealer.registration.service.impl.DgfDlrRegAddlDtlsServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrRegAddlDtlsService
 * @generated
 */
public class DgfDlrRegAddlDtlsServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>bd.gov.dgfood.dealer.registration.service.impl.DgfDlrRegAddlDtlsServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
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
		saveDgfDlrRegAddlDtls(
			java.lang.String nid, long phsclyChlnGdAttchId, int workInGovt,
			int publcRep, int physclyChlngd, long shopHeight, long shopLength,
			long shopWidth, long shopStorageCap, int isCemented, int signBoard,
			int dlrRunShpHimself, java.lang.String dealershipMemName,
			java.lang.String dealershipMemType, int truckType,
			java.lang.String truckRentFlag, java.lang.String truckPlatNo,
			long truckCap, java.lang.String truckMake,
			java.lang.String truckModel, long truckManuYear) {

		return getService().saveDgfDlrRegAddlDtls(
			nid, phsclyChlnGdAttchId, workInGovt, publcRep, physclyChlngd,
			shopHeight, shopLength, shopWidth, shopStorageCap, isCemented,
			signBoard, dlrRunShpHimself, dealershipMemName, dealershipMemType,
			truckType, truckRentFlag, truckPlatNo, truckCap, truckMake,
			truckModel, truckManuYear);
	}

	public static DgfDlrRegAddlDtlsService getService() {
		return _service;
	}

	private static volatile DgfDlrRegAddlDtlsService _service;

}