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

import bd.gov.dgfood.dealer.registration.exception.NoSuchDgfDlrRegAddlDtlsException;
import bd.gov.dgfood.dealer.registration.model.DgfDlrRegAddlDtls;
import bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls;
import bd.gov.dgfood.dealer.registration.service.DgfDlrRegDtlsLocalServiceUtil;
import bd.gov.dgfood.dealer.registration.service.base.DgfDlrRegAddlDtlsLocalServiceBaseImpl;
import bd.gov.dgfood.dealer.registration.util.DealerCommonConstant;
import bd.gov.dgfood.dealer.registration.util.PrincipalRoleAndLocationUtil;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=bd.gov.dgfood.dealer.registration.model.DgfDlrRegAddlDtls",
	service = AopService.class
)
public class DgfDlrRegAddlDtlsLocalServiceImpl
	extends DgfDlrRegAddlDtlsLocalServiceBaseImpl {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());
	public DgfDlrRegAddlDtls getDgfDlrRegAddlDtlsByRegNo(long dlrRegNo) {
		try {
			return dgfDlrRegAddlDtlsPersistence.findByDgfDlrRegAddlDtlsByRegNo(dlrRegNo);
		} catch (NoSuchDgfDlrRegAddlDtlsException e) {
			log.error("Dealer Registration No not found"+e.getMessage());
		}
		return null;
	}
	public List<DgfDlrRegAddlDtls> getDgfDlrRegAddlDtlsByNid(String nid) {
		List<DgfDlrRegAddlDtls> dgfDlrRegAddlDtls = dgfDlrRegAddlDtlsPersistence.findByDgfDlrRegAddlDtlsByNid(nid);
		return dgfDlrRegAddlDtls;
	}
	public DgfDlrRegAddlDtls saveDgfDlrRegAddlDtls(String nid,long phsclyChlnGdAttchId,int workInGovt,int publcRep,int physclyChlngd,long shopHeight,long shopLength,long shopWidth,long shopStorageCap,int isCemented,int signBoard,int dlrRunShpHimself,String dealershipMemName,String dealershipMemType,int truckType,String truckRentFlag,String truckPlatNo,long truckCap,String truckMake,String truckModel,long truckManuYear){
		DgfDlrRegDtls dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtlsByNid(nid);
		DgfDlrRegAddlDtls dgfDlrRegAddlDtlsObj = null;
		if (Validator.isNotNull(dgfDlrRegDtls.getDlrRegNo()) && PrincipalRoleAndLocationUtil.isMatchUserWithNationalId(nid)) {
			dgfDlrRegAddlDtlsObj = getDgfDlrRegAddlDtlsByRegNo(dgfDlrRegDtls.getDlrRegNo());
			if(dgfDlrRegAddlDtlsObj == null) {
				dgfDlrRegAddlDtlsObj = dgfDlrRegAddlDtlsLocalService.createDgfDlrRegAddlDtls(CounterLocalServiceUtil.increment());
			}
		}
		if (dgfDlrRegAddlDtlsObj != null && PrincipalRoleAndLocationUtil.isMatchUserWithNationalId(nid)) {
				if (Validator.isNotNull(nid)) {
					dgfDlrRegAddlDtlsObj.setNationalId(nid); 
				}
				if(Validator.isNotNull(dgfDlrRegDtls.getDlrRegNo())) {
					dgfDlrRegAddlDtlsObj.setDlrRegNo(dgfDlrRegDtls.getDlrRegNo());
				}
				if(Validator.isNotNull(dgfDlrRegDtls.getDlrRegApplNo())) {
					dgfDlrRegAddlDtlsObj.setDlrRegAppLNo(dgfDlrRegDtls.getDlrRegApplNo());
				}
				if(Validator.isNotNull(dgfDlrRegDtls.getDlrTypeId())) {
					dgfDlrRegAddlDtlsObj.setLicenseType(dgfDlrRegDtls.getDlrTypeId());
				}
				if(Validator.isNotNull(dgfDlrRegDtls.getDlrRegNo())) {
					dgfDlrRegAddlDtlsObj.setDlrRegNo(dgfDlrRegDtls.getDlrRegNo());
				}
				if (Validator.isNotNull(workInGovt)) {
					dgfDlrRegAddlDtlsObj.setWrkInGovt(workInGovt);
				}
				if (Validator.isNotNull(publcRep)) {
					dgfDlrRegAddlDtlsObj.setPblcRep(publcRep);
				}
				if (Validator.isNotNull(physclyChlngd)) {
					dgfDlrRegAddlDtlsObj.setPhysclyChlngd(physclyChlngd);
					if(physclyChlngd == DealerCommonConstant.PHYSCLYCHLNGD) {
						if (Validator.isNotNull(phsclyChlnGdAttchId)) {
							dgfDlrRegAddlDtlsObj.setPhsclyChlnGdAttchId(phsclyChlnGdAttchId);
						}
					}else {
						dgfDlrRegAddlDtlsObj.setPhsclyChlnGdAttchId(0);
					}
				}
				if (Validator.isNotNull(shopHeight)) {
					dgfDlrRegAddlDtlsObj.setShpHeight(shopHeight);
				}
				if (Validator.isNotNull(shopLength)) {
					dgfDlrRegAddlDtlsObj.setShpLength(shopLength);
				}
				if (Validator.isNotNull(shopWidth)) {
					dgfDlrRegAddlDtlsObj.setShpWidth(shopWidth);
				}
				if (Validator.isNotNull(shopStorageCap)) {
					dgfDlrRegAddlDtlsObj.setShpStrgCpcty(shopStorageCap);
				}
				if (Validator.isNotNull(isCemented)) {
					dgfDlrRegAddlDtlsObj.setShpFlrCmntd(isCemented);
				}
				if (Validator.isNotNull(signBoard)) {
					dgfDlrRegAddlDtlsObj.setShpSignBrd(signBoard);
				}   
				if (Validator.isNotNull(dlrRunShpHimself)) {
					dgfDlrRegAddlDtlsObj.setDlrRunShpHimself(dlrRunShpHimself);
					if(dlrRunShpHimself == DealerCommonConstant.DLRRUNSHPHIMSELF) {
						if (Validator.isNotNull(dealershipMemName)) {
							dgfDlrRegAddlDtlsObj.setDlrshpFmlyMmbrName(dealershipMemName);
						}   
						if (Validator.isNotNull(dealershipMemType)) {
							dgfDlrRegAddlDtlsObj.setDlrshpFmlyMmbrType(dealershipMemType);
						} 
					}else {
						dgfDlrRegAddlDtlsObj.setDlrshpFmlyMmbrName(null);
						dgfDlrRegAddlDtlsObj.setDlrshpFmlyMmbrType(null);
					}
				}   
				if(Validator.isNotNull(dgfDlrRegDtls.getDlrTypeId())) {
					if(dgfDlrRegDtls.getDlrTypeId().equals(DealerCommonConstant.OMS)) {
						if (Validator.isNotNull(truckType)) {
							dgfDlrRegAddlDtlsObj.setDlrShpTrckTypFlg(truckType);
						} 
						if (Validator.isNotNull(truckRentFlag)) {
							dgfDlrRegAddlDtlsObj.setTrckRentOwnFlg(truckRentFlag);
						} 
						if (Validator.isNotNull(truckPlatNo)) {
							dgfDlrRegAddlDtlsObj.setTrckLicnsPlatNo(truckPlatNo);
						} 
						if (Validator.isNotNull(truckCap)) {
							dgfDlrRegAddlDtlsObj.setTrckCpcty(truckCap);
						} 
						if (Validator.isNotNull(truckMake)) {
							dgfDlrRegAddlDtlsObj.setTrckMake(truckMake);
						} 
						if (Validator.isNotNull(truckModel)) {
							dgfDlrRegAddlDtlsObj.setTrckModel(truckModel);
						} 
						if (Validator.isNotNull(truckManuYear)) {
							dgfDlrRegAddlDtlsObj.setTrckMfgYr(truckManuYear);
						} 
					}else {
						dgfDlrRegAddlDtlsObj.setDlrShpTrckTypFlg(-1);
						dgfDlrRegAddlDtlsObj.setTrckRentOwnFlg("");
						dgfDlrRegAddlDtlsObj.setTrckLicnsPlatNo(null);
						dgfDlrRegAddlDtlsObj.setTrckCpcty(0);
						dgfDlrRegAddlDtlsObj.setTrckMake(null);
						dgfDlrRegAddlDtlsObj.setTrckModel(null);
						dgfDlrRegAddlDtlsObj.setTrckMfgYr(0);
					}
				}
				dgfDlrRegAddlDtlsObj = dgfDlrRegAddlDtlsLocalService.updateDgfDlrRegAddlDtls(dgfDlrRegAddlDtlsObj);
				return dgfDlrRegAddlDtlsObj;
			}
		return null;
	}
}