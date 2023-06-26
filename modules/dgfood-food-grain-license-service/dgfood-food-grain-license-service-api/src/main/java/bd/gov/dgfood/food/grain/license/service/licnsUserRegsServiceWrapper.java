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
 * Provides a wrapper for {@link licnsUserRegsService}.
 *
 * @author Brian Wing Shun Chan
 * @see licnsUserRegsService
 * @generated
 */
public class licnsUserRegsServiceWrapper
	implements licnsUserRegsService, ServiceWrapper<licnsUserRegsService> {

	public licnsUserRegsServiceWrapper() {
		this(null);
	}

	public licnsUserRegsServiceWrapper(
		licnsUserRegsService licnsUserRegsService) {

		_licnsUserRegsService = licnsUserRegsService;
	}

	@Override
	public boolean checkNidStatus(String nid, String dob) {
		return _licnsUserRegsService.checkNidStatus(nid, dob);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray fetchNidData(
		String nid, String dob) {

		return _licnsUserRegsService.fetchNidData(nid, dob);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _licnsUserRegsService.getOSGiServiceIdentifier();
	}

	@Override
	public licnsUserRegsService getWrappedService() {
		return _licnsUserRegsService;
	}

	@Override
	public void setWrappedService(licnsUserRegsService licnsUserRegsService) {
		_licnsUserRegsService = licnsUserRegsService;
	}

	private licnsUserRegsService _licnsUserRegsService;

}