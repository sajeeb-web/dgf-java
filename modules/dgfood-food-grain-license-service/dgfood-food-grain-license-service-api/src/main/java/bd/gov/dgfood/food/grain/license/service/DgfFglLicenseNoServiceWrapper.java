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
 * Provides a wrapper for {@link DgfFglLicenseNoService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfFglLicenseNoService
 * @generated
 */
public class DgfFglLicenseNoServiceWrapper
	implements DgfFglLicenseNoService, ServiceWrapper<DgfFglLicenseNoService> {

	public DgfFglLicenseNoServiceWrapper() {
		this(null);
	}

	public DgfFglLicenseNoServiceWrapper(
		DgfFglLicenseNoService dgfFglLicenseNoService) {

		_dgfFglLicenseNoService = dgfFglLicenseNoService;
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglLicenseNo
		generatedDgfFglLicenseNo() {

		return _dgfFglLicenseNoService.generatedDgfFglLicenseNo();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfFglLicenseNoService.getOSGiServiceIdentifier();
	}

	@Override
	public DgfFglLicenseNoService getWrappedService() {
		return _dgfFglLicenseNoService;
	}

	@Override
	public void setWrappedService(
		DgfFglLicenseNoService dgfFglLicenseNoService) {

		_dgfFglLicenseNoService = dgfFglLicenseNoService;
	}

	private DgfFglLicenseNoService _dgfFglLicenseNoService;

}