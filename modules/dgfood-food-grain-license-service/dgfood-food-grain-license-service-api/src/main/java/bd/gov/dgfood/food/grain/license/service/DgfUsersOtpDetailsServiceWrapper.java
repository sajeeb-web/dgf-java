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

package bd.gov.dgfood.food.grain.license.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DgfUsersOtpDetailsService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersOtpDetailsService
 * @generated
 */
public class DgfUsersOtpDetailsServiceWrapper
	implements DgfUsersOtpDetailsService,
			   ServiceWrapper<DgfUsersOtpDetailsService> {

	public DgfUsersOtpDetailsServiceWrapper() {
		this(null);
	}

	public DgfUsersOtpDetailsServiceWrapper(
		DgfUsersOtpDetailsService dgfUsersOtpDetailsService) {

		_dgfUsersOtpDetailsService = dgfUsersOtpDetailsService;
	}

	@Override
	public String checkOtpMessageApi(long otpId) {
		return _dgfUsersOtpDetailsService.checkOtpMessageApi(otpId);
	}

	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetails>
			findOtpDetailsByMobileNo(String mobileNo) {

		return _dgfUsersOtpDetailsService.findOtpDetailsByMobileNo(mobileNo);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfUsersOtpDetailsService.getOSGiServiceIdentifier();
	}

	@Override
	public DgfUsersOtpDetailsService getWrappedService() {
		return _dgfUsersOtpDetailsService;
	}

	@Override
	public void setWrappedService(
		DgfUsersOtpDetailsService dgfUsersOtpDetailsService) {

		_dgfUsersOtpDetailsService = dgfUsersOtpDetailsService;
	}

	private DgfUsersOtpDetailsService _dgfUsersOtpDetailsService;

}