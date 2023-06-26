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

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfFglLicenseNoException;
import bd.gov.dgfood.food.grain.license.model.DgfFglLicenseNo;
import bd.gov.dgfood.food.grain.license.service.DgfFglLicenseNoLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.base.DgfFglLicenseNoLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=bd.gov.dgfood.food.grain.license.model.DgfFglLicenseNo",
	service = AopService.class
)
public class DgfFglLicenseNoLocalServiceImpl
	extends DgfFglLicenseNoLocalServiceBaseImpl {
	
	@Override
	public DgfFglLicenseNo generatedDgfFglLicenseNo() {
		//TODO set prefix, serialNo & suffix
		String licenseNo = "";
		long prefix = 0;
		long suffix = 0;
		long serialNo = 10000;
		// find entity by serial number and get entity last object and incriment one
		DgfFglLicenseNo dgfFglLicenseNo = null;
		try {
			// find query will be change based on requirement
			dgfFglLicenseNo = dgfFglLicenseNoPersistence.findByDgfFglLicenseNoBySerialNo(serialNo);
		}catch (NoSuchDgfFglLicenseNoException e) {
			// TODO: get last entity object from this table
			dgfFglLicenseNo = null;
		}
		if(Validator.isNull(dgfFglLicenseNo)){
			serialNo = 10000;
			prefix = 2000;
			suffix = 100;
		}else {
			List<DgfFglLicenseNo> entities = findAllOrderedByIdDesc();
		    if (!entities.isEmpty()) {
		    	dgfFglLicenseNo = entities.get(0);
		      }
		    if(Validator.isNotNull(dgfFglLicenseNo)) {
		    	serialNo = dgfFglLicenseNo.getSerialNo()+1;
		    	prefix = dgfFglLicenseNo.getPrefix();
		    	suffix = dgfFglLicenseNo.getSuffix();
		    }
		}
		
		licenseNo = String.valueOf(serialNo);
		dgfFglLicenseNo = DgfFglLicenseNoLocalServiceUtil
                .createDgfFglLicenseNo(CounterLocalServiceUtil.increment());
		dgfFglLicenseNo.setPrefix(prefix);
		dgfFglLicenseNo.setSuffix(suffix);
		dgfFglLicenseNo.setSerialNo(serialNo);
		dgfFglLicenseNo.setLicenseNo(licenseNo);
		dgfFglLicenseNo.setCreatedAt(new Date());
		dgfFglLicenseNo.setUpdatedAt(new Date());
		dgfFglLicenseNo = DgfFglLicenseNoLocalServiceUtil.addDgfFglLicenseNo(dgfFglLicenseNo);
		return dgfFglLicenseNo;
	}
	
	public List<DgfFglLicenseNo> findAllOrderedByIdDesc() throws SystemException {
	    DynamicQuery dynamicQuery = dynamicQuery();
	    Order order = OrderFactoryUtil.desc("serialNo");
	    dynamicQuery.addOrder(order);
	    return dynamicQuery(dynamicQuery);
	}
}