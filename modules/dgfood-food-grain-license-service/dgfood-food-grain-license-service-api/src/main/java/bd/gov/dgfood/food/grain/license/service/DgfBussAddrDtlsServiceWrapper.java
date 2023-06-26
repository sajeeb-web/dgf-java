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
 * Provides a wrapper for {@link DgfBussAddrDtlsService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfBussAddrDtlsService
 * @generated
 */
public class DgfBussAddrDtlsServiceWrapper
	implements DgfBussAddrDtlsService, ServiceWrapper<DgfBussAddrDtlsService> {

	public DgfBussAddrDtlsServiceWrapper() {
		this(null);
	}

	public DgfBussAddrDtlsServiceWrapper(
		DgfBussAddrDtlsService dgfBussAddrDtlsService) {

		_dgfBussAddrDtlsService = dgfBussAddrDtlsService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfBussAddrDtlsService.getOSGiServiceIdentifier();
	}

	@Override
	public DgfBussAddrDtlsService getWrappedService() {
		return _dgfBussAddrDtlsService;
	}

	@Override
	public void setWrappedService(
		DgfBussAddrDtlsService dgfBussAddrDtlsService) {

		_dgfBussAddrDtlsService = dgfBussAddrDtlsService;
	}

	private DgfBussAddrDtlsService _dgfBussAddrDtlsService;

}