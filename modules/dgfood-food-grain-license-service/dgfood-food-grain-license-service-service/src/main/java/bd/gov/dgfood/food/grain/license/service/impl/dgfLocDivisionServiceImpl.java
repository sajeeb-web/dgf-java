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
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.food.grain.license.model.dgfLocDivision;
import bd.gov.dgfood.food.grain.license.service.dgfLocDivisionLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.base.dgfLocDivisionServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=dgf",
		"json.web.service.context.path=dgfLocDivision"
	},
	service = AopService.class
)

public class dgfLocDivisionServiceImpl extends dgfLocDivisionServiceBaseImpl {

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService(value = "getDivisions", method = "GET")
	public JSONArray getDivisions() {
		List<dgfLocDivision>  divisions = dgfLocDivisionLocalServiceUtil.getdgfLocDivisions(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		return JSONUtil.putAll(divisions.toArray());
	}
}