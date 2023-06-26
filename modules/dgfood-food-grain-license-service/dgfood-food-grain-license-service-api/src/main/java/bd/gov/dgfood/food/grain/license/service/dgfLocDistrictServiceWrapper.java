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
 * Provides a wrapper for {@link dgfLocDistrictService}.
 *
 * @author Brian Wing Shun Chan
 * @see dgfLocDistrictService
 * @generated
 */
public class dgfLocDistrictServiceWrapper
	implements dgfLocDistrictService, ServiceWrapper<dgfLocDistrictService> {

	public dgfLocDistrictServiceWrapper() {
		this(null);
	}

	public dgfLocDistrictServiceWrapper(
		dgfLocDistrictService dgfLocDistrictService) {

		_dgfLocDistrictService = dgfLocDistrictService;
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getDistrictsByDivision(
		long divisionId) {

		return _dgfLocDistrictService.getDistrictsByDivision(divisionId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfLocDistrictService.getOSGiServiceIdentifier();
	}

	@Override
	public dgfLocDistrictService getWrappedService() {
		return _dgfLocDistrictService;
	}

	@Override
	public void setWrappedService(dgfLocDistrictService dgfLocDistrictService) {
		_dgfLocDistrictService = dgfLocDistrictService;
	}

	private dgfLocDistrictService _dgfLocDistrictService;

}