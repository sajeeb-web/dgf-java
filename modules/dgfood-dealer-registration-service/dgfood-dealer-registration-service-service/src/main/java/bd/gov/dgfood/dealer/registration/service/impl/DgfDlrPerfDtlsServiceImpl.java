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

import bd.gov.dgfood.dealer.registration.model.DgfDlrPerfDtls;
import bd.gov.dgfood.dealer.registration.service.DgfDlrPerfDtlsLocalServiceUtil;
import bd.gov.dgfood.dealer.registration.service.base.DgfDlrPerfDtlsServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=dgf",
		"json.web.service.context.path=DgfDlrPerfDtls"
	},
	service = AopService.class
)
public class DgfDlrPerfDtlsServiceImpl extends DgfDlrPerfDtlsServiceBaseImpl {
	public JSONObject saveDgfDlrPerfDtls(String nid,long dlrPerfYr1SN,long dlrPerfYr1AllocQty,long dlrPerfYr1ComdtyQty,String dlrPerfYr1DlrCtgry,String dlrPerfYr1Rmrk,long dlrPerfYr2SN,long dlrPerfYr2AllocQty,long dlrPerfYr2ComdtyQty,String dlrPerfYr2DlrCtgry,String dlrPerfYr2Rmrk,long dlrPerfYr3SN,long dlrPerfYr3AllocQty,long dlrPerfYr3ComdtyQty,String dlrPerfYr3DlrCtgry,String dlrPerfYr3Rmrk) {
		DgfDlrPerfDtls dgfDlrPerfDtls = DgfDlrPerfDtlsLocalServiceUtil.saveDgfDlrPerfDtls(nid,dlrPerfYr1SN,dlrPerfYr1AllocQty,dlrPerfYr1ComdtyQty,dlrPerfYr1DlrCtgry,dlrPerfYr1Rmrk,dlrPerfYr2SN,dlrPerfYr2AllocQty,dlrPerfYr2ComdtyQty,dlrPerfYr2DlrCtgry,dlrPerfYr2Rmrk,dlrPerfYr3SN,dlrPerfYr3AllocQty,dlrPerfYr3ComdtyQty,dlrPerfYr3DlrCtgry,dlrPerfYr3Rmrk);

		return JSONFactoryUtil.createJSONObject(dgfDlrPerfDtls.getModelAttributes());
	}
}