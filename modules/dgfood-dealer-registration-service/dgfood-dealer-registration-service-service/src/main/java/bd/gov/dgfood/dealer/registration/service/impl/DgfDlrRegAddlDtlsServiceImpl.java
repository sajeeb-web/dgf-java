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

package bd.gov.dgfood.dealer.registration.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.dealer.registration.model.DgfDlrRegAddlDtls;
import bd.gov.dgfood.dealer.registration.service.DgfDlrRegAddlDtlsLocalServiceUtil;
import bd.gov.dgfood.dealer.registration.service.base.DgfDlrRegAddlDtlsServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=dgf",
		"json.web.service.context.path=DgfDlrRegAddlDtls"
	},
	service = AopService.class
)
public class DgfDlrRegAddlDtlsServiceImpl
	extends DgfDlrRegAddlDtlsServiceBaseImpl {
	public JSONObject saveDgfDlrRegAddlDtls(String nid,long phsclyChlnGdAttchId,int workInGovt,int publcRep,int physclyChlngd,long shopHeight,long shopLength,long shopWidth,long shopStorageCap,int isCemented,int signBoard,int dlrRunShpHimself,String dealershipMemName,String dealershipMemType,int truckType,String truckRentFlag,String truckPlatNo,long truckCap,String truckMake,String truckModel,long truckManuYear){
		DgfDlrRegAddlDtls dgfDlrRegAddlDtls = DgfDlrRegAddlDtlsLocalServiceUtil.saveDgfDlrRegAddlDtls(nid,phsclyChlnGdAttchId,workInGovt,publcRep,physclyChlngd,shopHeight,shopLength,shopWidth,shopStorageCap,isCemented,signBoard,dlrRunShpHimself,dealershipMemName,dealershipMemType,truckType,truckRentFlag,truckPlatNo,truckCap,truckMake,truckModel,truckManuYear);
		return JSONFactoryUtil.createJSONObject(dgfDlrRegAddlDtls.getModelAttributes());
	}
}