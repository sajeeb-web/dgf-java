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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfDlrDistributionDtlsException;
import bd.gov.dgfood.food.grain.license.model.DgfDlrDistributionDtls;
import bd.gov.dgfood.food.grain.license.service.base.DgfDlrDistributionDtlsLocalServiceBaseImpl;

/**
 * @author Md. Nazmul
 */
@Component(
	property = "model.class.name=bd.gov.dgfood.food.grain.license.model.DgfDlrDistributionDtls",
	service = AopService.class
)
public class DgfDlrDistributionDtlsLocalServiceImpl
	extends DgfDlrDistributionDtlsLocalServiceBaseImpl {
	
	@Override
	public DgfDlrDistributionDtls getDgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear(long beneficiariesId, int month, int year) throws NoSuchDgfDlrDistributionDtlsException {
		return dgfDlrDistributionDtlsPersistence.findBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear(beneficiariesId, month, year);
	}
	
	@Override
	public List<DgfDlrDistributionDtls> getDgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(long dealerId, long beneficiariesId) throws NoSuchDgfDlrDistributionDtlsException {
		return dgfDlrDistributionDtlsPersistence.findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(dealerId, beneficiariesId);
	}
}