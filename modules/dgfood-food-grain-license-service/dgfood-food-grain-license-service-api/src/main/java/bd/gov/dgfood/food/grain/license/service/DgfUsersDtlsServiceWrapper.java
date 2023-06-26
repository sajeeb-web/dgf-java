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
 * Provides a wrapper for {@link DgfUsersDtlsService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersDtlsService
 * @generated
 */
public class DgfUsersDtlsServiceWrapper
	implements DgfUsersDtlsService, ServiceWrapper<DgfUsersDtlsService> {

	public DgfUsersDtlsServiceWrapper() {
		this(null);
	}

	public DgfUsersDtlsServiceWrapper(DgfUsersDtlsService dgfUsersDtlsService) {
		_dgfUsersDtlsService = dgfUsersDtlsService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfUsersDtlsService.getOSGiServiceIdentifier();
	}

	@Override
	public DgfUsersDtlsService getWrappedService() {
		return _dgfUsersDtlsService;
	}

	@Override
	public void setWrappedService(DgfUsersDtlsService dgfUsersDtlsService) {
		_dgfUsersDtlsService = dgfUsersDtlsService;
	}

	private DgfUsersDtlsService _dgfUsersDtlsService;

}