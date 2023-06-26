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
 * Provides a wrapper for {@link DgfUsersFortnightReportDFormService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersFortnightReportDFormService
 * @generated
 */
public class DgfUsersFortnightReportDFormServiceWrapper
	implements DgfUsersFortnightReportDFormService,
			   ServiceWrapper<DgfUsersFortnightReportDFormService> {

	public DgfUsersFortnightReportDFormServiceWrapper() {
		this(null);
	}

	public DgfUsersFortnightReportDFormServiceWrapper(
		DgfUsersFortnightReportDFormService
			dgfUsersFortnightReportDFormService) {

		_dgfUsersFortnightReportDFormService =
			dgfUsersFortnightReportDFormService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfUsersFortnightReportDFormService.getOSGiServiceIdentifier();
	}

	@Override
	public DgfUsersFortnightReportDFormService getWrappedService() {
		return _dgfUsersFortnightReportDFormService;
	}

	@Override
	public void setWrappedService(
		DgfUsersFortnightReportDFormService
			dgfUsersFortnightReportDFormService) {

		_dgfUsersFortnightReportDFormService =
			dgfUsersFortnightReportDFormService;
	}

	private DgfUsersFortnightReportDFormService
		_dgfUsersFortnightReportDFormService;

}