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
 * Provides a wrapper for {@link DgfFglLicDtlsService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfFglLicDtlsService
 * @generated
 */
public class DgfFglLicDtlsServiceWrapper
	implements DgfFglLicDtlsService, ServiceWrapper<DgfFglLicDtlsService> {

	public DgfFglLicDtlsServiceWrapper() {
		this(null);
	}

	public DgfFglLicDtlsServiceWrapper(
		DgfFglLicDtlsService dgfFglLicDtlsService) {

		_dgfFglLicDtlsService = dgfFglLicDtlsService;
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject checkFglLicense(
		String cmd, String licenseNo, String licenseIssueDate) {

		return _dgfFglLicDtlsService.checkFglLicense(
			cmd, licenseNo, licenseIssueDate);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfFglLicDtlsService.getOSGiServiceIdentifier();
	}

	@Override
	public DgfFglLicDtlsService getWrappedService() {
		return _dgfFglLicDtlsService;
	}

	@Override
	public void setWrappedService(DgfFglLicDtlsService dgfFglLicDtlsService) {
		_dgfFglLicDtlsService = dgfFglLicDtlsService;
	}

	private DgfFglLicDtlsService _dgfFglLicDtlsService;

}