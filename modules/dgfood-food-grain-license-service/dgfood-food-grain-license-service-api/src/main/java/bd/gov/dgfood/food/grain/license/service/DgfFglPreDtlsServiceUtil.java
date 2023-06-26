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

import bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls;

/**
 * Provides the remote service utility for DgfFglPreDtls. This utility wraps
 * <code>bd.gov.dgfood.food.grain.license.service.impl.DgfFglPreDtlsServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DgfFglPreDtlsService
 * @generated
 */
public class DgfFglPreDtlsServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>bd.gov.dgfood.food.grain.license.service.impl.DgfFglPreDtlsServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static byte[] getLicenseReport(String queryParams) {
		return getService().getLicenseReport(queryParams);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static DgfFglPreDtls saveDgfFglPreDtls(String nationalId) {
		return getService().saveDgfFglPreDtls(nationalId);
	}

	public static DgfFglPreDtlsService getService() {
		return _service;
	}

	private static volatile DgfFglPreDtlsService _service;

}