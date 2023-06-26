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
 * Provides a wrapper for {@link DgfDlrWithdrawalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrWithdrawalService
 * @generated
 */
public class DgfDlrWithdrawalServiceWrapper
	implements DgfDlrWithdrawalService,
			   ServiceWrapper<DgfDlrWithdrawalService> {

	public DgfDlrWithdrawalServiceWrapper() {
		this(null);
	}

	public DgfDlrWithdrawalServiceWrapper(
		DgfDlrWithdrawalService dgfDlrWithdrawalService) {

		_dgfDlrWithdrawalService = dgfDlrWithdrawalService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfDlrWithdrawalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject saveWithdrawalData(
		String nationalId, String licenseNo, String dealerName, String mobileNo,
		String reason, String programType) {

		return _dgfDlrWithdrawalService.saveWithdrawalData(
			nationalId, licenseNo, dealerName, mobileNo, reason, programType);
	}

	@Override
	public DgfDlrWithdrawalService getWrappedService() {
		return _dgfDlrWithdrawalService;
	}

	@Override
	public void setWrappedService(
		DgfDlrWithdrawalService dgfDlrWithdrawalService) {

		_dgfDlrWithdrawalService = dgfDlrWithdrawalService;
	}

	private DgfDlrWithdrawalService _dgfDlrWithdrawalService;

}