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
 * Provides a wrapper for {@link DgfDlrRegAddlDtlsService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrRegAddlDtlsService
 * @generated
 */
public class DgfDlrRegAddlDtlsServiceWrapper
	implements DgfDlrRegAddlDtlsService,
			   ServiceWrapper<DgfDlrRegAddlDtlsService> {

	public DgfDlrRegAddlDtlsServiceWrapper() {
		this(null);
	}

	public DgfDlrRegAddlDtlsServiceWrapper(
		DgfDlrRegAddlDtlsService dgfDlrRegAddlDtlsService) {

		_dgfDlrRegAddlDtlsService = dgfDlrRegAddlDtlsService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfDlrRegAddlDtlsService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject saveDgfDlrRegAddlDtls(
		String nid, long phsclyChlnGdAttchId, int workInGovt, int publcRep,
		int physclyChlngd, long shopHeight, long shopLength, long shopWidth,
		long shopStorageCap, int isCemented, int signBoard,
		int dlrRunShpHimself, String dealershipMemName,
		String dealershipMemType, int truckType, String truckRentFlag,
		String truckPlatNo, long truckCap, String truckMake, String truckModel,
		long truckManuYear) {

		return _dgfDlrRegAddlDtlsService.saveDgfDlrRegAddlDtls(
			nid, phsclyChlnGdAttchId, workInGovt, publcRep, physclyChlngd,
			shopHeight, shopLength, shopWidth, shopStorageCap, isCemented,
			signBoard, dlrRunShpHimself, dealershipMemName, dealershipMemType,
			truckType, truckRentFlag, truckPlatNo, truckCap, truckMake,
			truckModel, truckManuYear);
	}

	@Override
	public DgfDlrRegAddlDtlsService getWrappedService() {
		return _dgfDlrRegAddlDtlsService;
	}

	@Override
	public void setWrappedService(
		DgfDlrRegAddlDtlsService dgfDlrRegAddlDtlsService) {

		_dgfDlrRegAddlDtlsService = dgfDlrRegAddlDtlsService;
	}

	private DgfDlrRegAddlDtlsService _dgfDlrRegAddlDtlsService;

}