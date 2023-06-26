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

package bd.gov.dgfood.food.grain.license.service.impl;

import bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls;
import bd.gov.dgfood.food.grain.license.service.DgfFglPreDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.base.DgfFglPreDtlsServiceBaseImpl;
import bd.gov.dgfood.food.grain.license.util.GenerateLicenseReportUtil;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=dgf",
		"json.web.service.context.path=DgfFglPreDtls"
	},
	service = AopService.class
)
public class DgfFglPreDtlsServiceImpl extends DgfFglPreDtlsServiceBaseImpl {
	public DgfFglPreDtls saveDgfFglPreDtls(String nationalId) {
		return DgfFglPreDtlsLocalServiceUtil.saveDgfFglPreDtls(nationalId);
	}
	
	public byte[] getLicenseReport(String queryParams) {
		return DgfFglPreDtlsLocalServiceUtil.getLicenseReport(queryParams);
	}
}