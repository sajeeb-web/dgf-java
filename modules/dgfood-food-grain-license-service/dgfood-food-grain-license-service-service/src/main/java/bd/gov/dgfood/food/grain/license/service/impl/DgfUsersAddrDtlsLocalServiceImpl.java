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

import java.util.List;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls;
import bd.gov.dgfood.food.grain.license.service.base.DgfUsersAddrDtlsLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls",
	service = AopService.class
)
public class DgfUsersAddrDtlsLocalServiceImpl
	extends DgfUsersAddrDtlsLocalServiceBaseImpl {
	
	@Override
	public List<DgfUsersAddrDtls> getDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(long division, long district, long upzilla) {
		return dgfUsersAddrDtlsPersistence.findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(division, district, upzilla);
	}
	
	@Override
	public List<DgfUsersAddrDtls> getDgfUsersAddrDtlsByDivisionAndDistrict(long division, long district) {
		return dgfUsersAddrDtlsPersistence.findByDgfUsersAddrDtlsByDivisionAndDistrict(division, district);
	}
}