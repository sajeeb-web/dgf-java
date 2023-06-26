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
 * Provides a wrapper for {@link DgfDlrPerfDtlsService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrPerfDtlsService
 * @generated
 */
public class DgfDlrPerfDtlsServiceWrapper
	implements DgfDlrPerfDtlsService, ServiceWrapper<DgfDlrPerfDtlsService> {

	public DgfDlrPerfDtlsServiceWrapper() {
		this(null);
	}

	public DgfDlrPerfDtlsServiceWrapper(
		DgfDlrPerfDtlsService dgfDlrPerfDtlsService) {

		_dgfDlrPerfDtlsService = dgfDlrPerfDtlsService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfDlrPerfDtlsService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject saveDgfDlrPerfDtls(
		String nid, long dlrPerfYr1SN, long dlrPerfYr1AllocQty,
		long dlrPerfYr1ComdtyQty, String dlrPerfYr1DlrCtgry,
		String dlrPerfYr1Rmrk, long dlrPerfYr2SN, long dlrPerfYr2AllocQty,
		long dlrPerfYr2ComdtyQty, String dlrPerfYr2DlrCtgry,
		String dlrPerfYr2Rmrk, long dlrPerfYr3SN, long dlrPerfYr3AllocQty,
		long dlrPerfYr3ComdtyQty, String dlrPerfYr3DlrCtgry,
		String dlrPerfYr3Rmrk) {

		return _dgfDlrPerfDtlsService.saveDgfDlrPerfDtls(
			nid, dlrPerfYr1SN, dlrPerfYr1AllocQty, dlrPerfYr1ComdtyQty,
			dlrPerfYr1DlrCtgry, dlrPerfYr1Rmrk, dlrPerfYr2SN,
			dlrPerfYr2AllocQty, dlrPerfYr2ComdtyQty, dlrPerfYr2DlrCtgry,
			dlrPerfYr2Rmrk, dlrPerfYr3SN, dlrPerfYr3AllocQty,
			dlrPerfYr3ComdtyQty, dlrPerfYr3DlrCtgry, dlrPerfYr3Rmrk);
	}

	@Override
	public DgfDlrPerfDtlsService getWrappedService() {
		return _dgfDlrPerfDtlsService;
	}

	@Override
	public void setWrappedService(DgfDlrPerfDtlsService dgfDlrPerfDtlsService) {
		_dgfDlrPerfDtlsService = dgfDlrPerfDtlsService;
	}

	private DgfDlrPerfDtlsService _dgfDlrPerfDtlsService;

}