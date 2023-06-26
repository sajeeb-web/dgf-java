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

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import bd.gov.dgfood.dealer.registration.exception.NoSuchDgfDlrPerfDtlsException;
import bd.gov.dgfood.dealer.registration.model.DgfDlrPerfDtls;
import bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls;
import bd.gov.dgfood.dealer.registration.service.DgfDlrRegDtlsLocalServiceUtil;
import bd.gov.dgfood.dealer.registration.service.base.DgfDlrPerfDtlsLocalServiceBaseImpl;
import bd.gov.dgfood.dealer.registration.util.PrincipalRoleAndLocationUtil;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=bd.gov.dgfood.dealer.registration.model.DgfDlrPerfDtls", service = AopService.class)
public class DgfDlrPerfDtlsLocalServiceImpl extends DgfDlrPerfDtlsLocalServiceBaseImpl {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());
	public DgfDlrPerfDtls getDgfDlrPerfDtlsByDlrRegNo(long dlrRegNo) {
		try {
			return dgfDlrPerfDtlsPersistence.findByDgfDlrPerfDtlsByRegNo(dlrRegNo);
		} catch (NoSuchDgfDlrPerfDtlsException e) {
			log.error("Dealer Registration No not found"+e.getMessage());
		}
		return null;
	}
	public List<DgfDlrPerfDtls> getDgfDlrPerfDtlsByNid(String nid) {
		List<DgfDlrPerfDtls> dgfDlrPerfDtls =  dgfDlrPerfDtlsPersistence.findByDgfDlrPerfDtlsByNid(nid);
		return dgfDlrPerfDtls;
	}
	public DgfDlrPerfDtls saveDgfDlrPerfDtls(String nid,long dlrPerfYr1SN,long dlrPerfYr1AllocQty,long dlrPerfYr1ComdtyQty,String dlrPerfYr1DlrCtgry,String dlrPerfYr1Rmrk,long dlrPerfYr2SN,long dlrPerfYr2AllocQty,long dlrPerfYr2ComdtyQty,String dlrPerfYr2DlrCtgry,String dlrPerfYr2Rmrk,long dlrPerfYr3SN,long dlrPerfYr3AllocQty,long dlrPerfYr3ComdtyQty,String dlrPerfYr3DlrCtgry,String dlrPerfYr3Rmrk){
		DgfDlrRegDtls dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtlsByNid(nid);
		DgfDlrPerfDtls dgfDlrPerfDtlsObj = null;
		if (Validator.isNotNull(dgfDlrRegDtls.getDlrRegNo()) && PrincipalRoleAndLocationUtil.isMatchUserWithNationalId(nid)) {
			dgfDlrPerfDtlsObj = getDgfDlrPerfDtlsByDlrRegNo(dgfDlrRegDtls.getDlrRegNo());
			if(dgfDlrPerfDtlsObj == null) {
				dgfDlrPerfDtlsObj = dgfDlrPerfDtlsLocalService.createDgfDlrPerfDtls(CounterLocalServiceUtil.increment());
			}
			
		}
		if (dgfDlrPerfDtlsObj != null && PrincipalRoleAndLocationUtil.isMatchUserWithNationalId(nid)) {
				if (Validator.isNotNull(nid)) {
					dgfDlrPerfDtlsObj.setNationalId(nid); 
				}
				if(Validator.isNotNull(dgfDlrRegDtls.getDlrRegNo())) {
					dgfDlrPerfDtlsObj.setDlrRegNo(dgfDlrRegDtls.getDlrRegNo());
				}
				if(Validator.isNotNull(dgfDlrRegDtls.getDlrRegApplNo())) {
					dgfDlrPerfDtlsObj.setDlrRegApplNo(dgfDlrRegDtls.getDlrRegApplNo());
				}
				if (Validator.isNotNull(dlrPerfYr1SN)) {
					dgfDlrPerfDtlsObj.setDlrPerfYr1(dlrPerfYr1SN);
				} 
				if (Validator.isNotNull(dlrPerfYr1AllocQty)) {
					dgfDlrPerfDtlsObj.setDlrPerfYr1AllocQty(dlrPerfYr1AllocQty);
				} 
				if (Validator.isNotNull(dlrPerfYr1ComdtyQty)) {
					dgfDlrPerfDtlsObj.setDlrPerfYr1ComdtyQty(dlrPerfYr1ComdtyQty);
				} 
				if (Validator.isNotNull(dlrPerfYr1DlrCtgry)) {
					dgfDlrPerfDtlsObj.setDlrPerfYr1DlrCtgry(dlrPerfYr1DlrCtgry);
				} 
				if (Validator.isNotNull(dlrPerfYr1Rmrk)) {
					dgfDlrPerfDtlsObj.setDlrPerfYr1Rmrk(dlrPerfYr1Rmrk);
				} 
				if (Validator.isNotNull(dlrPerfYr2SN)) {
					dgfDlrPerfDtlsObj.setDlrPerfYr2(dlrPerfYr2SN);
				} 
				if (Validator.isNotNull(dlrPerfYr2AllocQty)) {
					dgfDlrPerfDtlsObj.setDlrPerfYr2AllocQty(dlrPerfYr2AllocQty);
				} 
				if (Validator.isNotNull(dlrPerfYr2ComdtyQty)) {
					dgfDlrPerfDtlsObj.setDlrPerfYr2ComdtyQty(dlrPerfYr2ComdtyQty);
				} 
				if (Validator.isNotNull(dlrPerfYr2DlrCtgry)) {
					dgfDlrPerfDtlsObj.setDlrPerfYr2DlrCtgry(dlrPerfYr2DlrCtgry);
				} 
				if (Validator.isNotNull(dlrPerfYr2Rmrk)) {
					dgfDlrPerfDtlsObj.setDlrPerfYr2Rmrk(dlrPerfYr2Rmrk);
				} 
				if (Validator.isNotNull(dlrPerfYr3SN)) {
					dgfDlrPerfDtlsObj.setDlrPerfYr3(dlrPerfYr3SN);
				} 
				if (Validator.isNotNull(dlrPerfYr3AllocQty)) {
					dgfDlrPerfDtlsObj.setDlrPerfYr3AllocQty(dlrPerfYr3AllocQty);
				} 
				if (Validator.isNotNull(dlrPerfYr3ComdtyQty)) {
					dgfDlrPerfDtlsObj.setDlrPerfYr3ComdtyQty(dlrPerfYr3ComdtyQty);
				} 
				if (Validator.isNotNull(dlrPerfYr3DlrCtgry)) {
					dgfDlrPerfDtlsObj.setDlrPerfYr3DlrCtgry(dlrPerfYr3DlrCtgry);
				} 
				if (Validator.isNotNull(dlrPerfYr3Rmrk)) {
					dgfDlrPerfDtlsObj.setDlrPerfYr3Rmrk(dlrPerfYr3Rmrk);
				} 
				dgfDlrPerfDtlsObj = dgfDlrPerfDtlsLocalService.updateDgfDlrPerfDtls(dgfDlrPerfDtlsObj);
				return dgfDlrPerfDtlsObj;
			}
		return null;
	}
}