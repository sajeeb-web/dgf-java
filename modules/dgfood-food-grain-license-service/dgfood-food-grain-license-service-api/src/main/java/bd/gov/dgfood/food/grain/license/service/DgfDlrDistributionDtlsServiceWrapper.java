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
 * Provides a wrapper for {@link DgfDlrDistributionDtlsService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrDistributionDtlsService
 * @generated
 */
public class DgfDlrDistributionDtlsServiceWrapper
	implements DgfDlrDistributionDtlsService,
			   ServiceWrapper<DgfDlrDistributionDtlsService> {

	public DgfDlrDistributionDtlsServiceWrapper() {
		this(null);
	}

	public DgfDlrDistributionDtlsServiceWrapper(
		DgfDlrDistributionDtlsService dgfDlrDistributionDtlsService) {

		_dgfDlrDistributionDtlsService = dgfDlrDistributionDtlsService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfDlrDistributionDtlsService.getOSGiServiceIdentifier();
	}

	@Override
	public DgfDlrDistributionDtlsService getWrappedService() {
		return _dgfDlrDistributionDtlsService;
	}

	@Override
	public void setWrappedService(
		DgfDlrDistributionDtlsService dgfDlrDistributionDtlsService) {

		_dgfDlrDistributionDtlsService = dgfDlrDistributionDtlsService;
	}

	private DgfDlrDistributionDtlsService _dgfDlrDistributionDtlsService;

}