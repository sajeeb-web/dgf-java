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
 * Provides a wrapper for {@link FfpbDetailsService}.
 *
 * @author Brian Wing Shun Chan
 * @see FfpbDetailsService
 * @generated
 */
public class FfpbDetailsServiceWrapper
	implements FfpbDetailsService, ServiceWrapper<FfpbDetailsService> {

	public FfpbDetailsServiceWrapper() {
		this(null);
	}

	public FfpbDetailsServiceWrapper(FfpbDetailsService ffpbDetailsService) {
		_ffpbDetailsService = ffpbDetailsService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ffpbDetailsService.getOSGiServiceIdentifier();
	}

	@Override
	public FfpbDetailsService getWrappedService() {
		return _ffpbDetailsService;
	}

	@Override
	public void setWrappedService(FfpbDetailsService ffpbDetailsService) {
		_ffpbDetailsService = ffpbDetailsService;
	}

	private FfpbDetailsService _ffpbDetailsService;

}