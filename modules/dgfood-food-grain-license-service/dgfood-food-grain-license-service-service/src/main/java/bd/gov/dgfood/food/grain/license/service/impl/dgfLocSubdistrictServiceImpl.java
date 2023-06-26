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

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict;
import bd.gov.dgfood.food.grain.license.service.dgfLocSubdistrictLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.base.dgfLocSubdistrictServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=dgf",
		"json.web.service.context.path=dgfLocSubdistrict"
	},
	service = AopService.class
)
public class dgfLocSubdistrictServiceImpl
	extends dgfLocSubdistrictServiceBaseImpl {
	
	@JSONWebService(value = "getSubDistrictsByDistrict", method = "GET")
	public JSONArray getSubDistrictsByDistrict(long districtId) {
		List<dgfLocSubdistrict>  subDistricts = dgfLocSubdistrictLocalServiceUtil.getdisWiseSubDis(districtId);
		return JSONUtil.putAll(subDistricts.toArray());
	}
}