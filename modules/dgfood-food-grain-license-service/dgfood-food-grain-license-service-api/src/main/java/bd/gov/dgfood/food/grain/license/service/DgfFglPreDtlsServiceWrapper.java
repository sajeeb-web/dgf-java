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
 * Provides a wrapper for {@link DgfFglPreDtlsService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfFglPreDtlsService
 * @generated
 */
public class DgfFglPreDtlsServiceWrapper
	implements DgfFglPreDtlsService, ServiceWrapper<DgfFglPreDtlsService> {

	public DgfFglPreDtlsServiceWrapper() {
		this(null);
	}

	public DgfFglPreDtlsServiceWrapper(
		DgfFglPreDtlsService dgfFglPreDtlsService) {

		_dgfFglPreDtlsService = dgfFglPreDtlsService;
	}

	@Override
	public byte[] getLicenseReport(String queryParams) {
		return _dgfFglPreDtlsService.getLicenseReport(queryParams);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfFglPreDtlsService.getOSGiServiceIdentifier();
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls
		saveDgfFglPreDtls(String nationalId) {

		return _dgfFglPreDtlsService.saveDgfFglPreDtls(nationalId);
	}

	@Override
	public DgfFglPreDtlsService getWrappedService() {
		return _dgfFglPreDtlsService;
	}

	@Override
	public void setWrappedService(DgfFglPreDtlsService dgfFglPreDtlsService) {
		_dgfFglPreDtlsService = dgfFglPreDtlsService;
	}

	private DgfFglPreDtlsService _dgfFglPreDtlsService;

}