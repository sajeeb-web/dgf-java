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

package bd.gov.dgfood.food.friendly.program.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DlrDistributionDetailsService}.
 *
 * @author Brian Wing Shun Chan
 * @see DlrDistributionDetailsService
 * @generated
 */
public class DlrDistributionDetailsServiceWrapper
	implements DlrDistributionDetailsService,
			   ServiceWrapper<DlrDistributionDetailsService> {

	public DlrDistributionDetailsServiceWrapper() {
		this(null);
	}

	public DlrDistributionDetailsServiceWrapper(
		DlrDistributionDetailsService dlrDistributionDetailsService) {

		_dlrDistributionDetailsService = dlrDistributionDetailsService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dlrDistributionDetailsService.getOSGiServiceIdentifier();
	}

	@Override
	public DlrDistributionDetailsService getWrappedService() {
		return _dlrDistributionDetailsService;
	}

	@Override
	public void setWrappedService(
		DlrDistributionDetailsService dlrDistributionDetailsService) {

		_dlrDistributionDetailsService = dlrDistributionDetailsService;
	}

	private DlrDistributionDetailsService _dlrDistributionDetailsService;

}