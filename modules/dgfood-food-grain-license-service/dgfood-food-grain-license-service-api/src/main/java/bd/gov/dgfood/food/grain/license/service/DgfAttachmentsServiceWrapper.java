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
 * Provides a wrapper for {@link DgfAttachmentsService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfAttachmentsService
 * @generated
 */
public class DgfAttachmentsServiceWrapper
	implements DgfAttachmentsService, ServiceWrapper<DgfAttachmentsService> {

	public DgfAttachmentsServiceWrapper() {
		this(null);
	}

	public DgfAttachmentsServiceWrapper(
		DgfAttachmentsService dgfAttachmentsService) {

		_dgfAttachmentsService = dgfAttachmentsService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfAttachmentsService.getOSGiServiceIdentifier();
	}

	@Override
	public DgfAttachmentsService getWrappedService() {
		return _dgfAttachmentsService;
	}

	@Override
	public void setWrappedService(DgfAttachmentsService dgfAttachmentsService) {
		_dgfAttachmentsService = dgfAttachmentsService;
	}

	private DgfAttachmentsService _dgfAttachmentsService;

}