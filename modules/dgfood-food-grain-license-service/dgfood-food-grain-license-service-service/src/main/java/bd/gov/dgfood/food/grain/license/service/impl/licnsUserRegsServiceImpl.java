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

import bd.gov.dgfood.food.grain.license.service.licnsUserRegsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.base.licnsUserRegsServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=dgf",
		"json.web.service.context.path=licnsUserRegs"
	},
	service = AopService.class
)
public class licnsUserRegsServiceImpl extends licnsUserRegsServiceBaseImpl {
	
	@JSONWebService(value = "fetchNidData", method = "GET")
	public JSONArray fetchNidData(String nid, String dob) {
		
		return licnsUserRegsLocalServiceUtil.fetchNidData(nid, dob);
	}
	
public boolean checkNidStatus(String nid, String dob) {
		
		return licnsUserRegsLocalServiceUtil.checkNidStatus(nid, dob);
	}
}