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
 * Provides a wrapper for {@link DgfUsersAddrDtlsService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersAddrDtlsService
 * @generated
 */
public class DgfUsersAddrDtlsServiceWrapper
	implements DgfUsersAddrDtlsService,
			   ServiceWrapper<DgfUsersAddrDtlsService> {

	public DgfUsersAddrDtlsServiceWrapper() {
		this(null);
	}

	public DgfUsersAddrDtlsServiceWrapper(
		DgfUsersAddrDtlsService dgfUsersAddrDtlsService) {

		_dgfUsersAddrDtlsService = dgfUsersAddrDtlsService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfUsersAddrDtlsService.getOSGiServiceIdentifier();
	}

	@Override
	public DgfUsersAddrDtlsService getWrappedService() {
		return _dgfUsersAddrDtlsService;
	}

	@Override
	public void setWrappedService(
		DgfUsersAddrDtlsService dgfUsersAddrDtlsService) {

		_dgfUsersAddrDtlsService = dgfUsersAddrDtlsService;
	}

	private DgfUsersAddrDtlsService _dgfUsersAddrDtlsService;

}