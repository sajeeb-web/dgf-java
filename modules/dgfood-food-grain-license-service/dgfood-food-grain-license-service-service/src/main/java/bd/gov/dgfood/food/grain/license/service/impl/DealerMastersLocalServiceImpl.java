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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDealerMastersException;
import bd.gov.dgfood.food.grain.license.model.DealerMasters;
import bd.gov.dgfood.food.grain.license.service.base.DealerMastersLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=bd.gov.dgfood.food.grain.license.model.DealerMasters",
	service = AopService.class
)
public class DealerMastersLocalServiceImpl
	extends DealerMastersLocalServiceBaseImpl {

	@Override
	public List<DealerMasters> getDealerMastersByNid(String nationalId) {
		return dealerMastersPersistence.findBydealerMastersNidFinder(nationalId);
	}

	@Override
	public DealerMasters getDealerMastersByNidAndMobile(String nationalId, String mobileNo) throws NoSuchDealerMastersException {
		return dealerMastersPersistence.findBydealerMastersByNidAndMobile(nationalId, mobileNo);
	}

	@Override
	public DealerMasters getDealerMastersBySecondNidAndMobile(String secondNationalId, String dealerMobileNo) throws NoSuchDealerMastersException {
		return dealerMastersPersistence.findByDealerMastersBySecondNidAndMobile(secondNationalId, dealerMobileNo);
	}

	@Override
	public DealerMasters getDealerMastersByMobileNo(String dealerMobileNo) throws NoSuchDealerMastersException {
		return dealerMastersPersistence.findByDealerMastersByMobileNo(dealerMobileNo);
	}

}