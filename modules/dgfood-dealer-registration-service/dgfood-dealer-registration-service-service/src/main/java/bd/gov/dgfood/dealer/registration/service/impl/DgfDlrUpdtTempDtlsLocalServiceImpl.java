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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.dealer.registration.model.DgfDlrRegAddlDtls;
import bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls;
import bd.gov.dgfood.dealer.registration.model.DgfDlrUpdtTempDtls;
import bd.gov.dgfood.dealer.registration.service.DgfDlrRegDtlsLocalService;
import bd.gov.dgfood.dealer.registration.service.DgfDlrRegDtlsLocalServiceUtil;
import bd.gov.dgfood.dealer.registration.service.DgfDlrUpdtTempDtlsLocalServiceUtil;
import bd.gov.dgfood.dealer.registration.service.base.DgfDlrUpdtTempDtlsLocalServiceBaseImpl;
import bd.gov.dgfood.dealer.registration.service.persistence.DgfDlrRegAddlDtlsUtil;
import bd.gov.dgfood.dealer.registration.util.DealerCommonConstant;
import bd.gov.dgfood.dealer.registration.util.PrincipalRoleAndLocationUtil;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=bd.gov.dgfood.dealer.registration.model.DgfDlrUpdtTempDtls",
	service = AopService.class
)
public class DgfDlrUpdtTempDtlsLocalServiceImpl
	extends DgfDlrUpdtTempDtlsLocalServiceBaseImpl {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());
	
	@Reference 
	DgfDlrRegDtlsLocalService dgfDlrRegDtlsLocalService;
	
	public List<DgfDlrUpdtTempDtls> getDgfDlrUpdtTempDtlsByRegNo(long dlrRegNo) {
		return dgfDlrUpdtTempDtlsPersistence.findByDgfDlrUpdtTempDtlsByRegNo(dlrRegNo);
	}
	public List<DgfDlrUpdtTempDtls> getDgfDlrUpdtTempDtlsByNid(String nid) {
		return dgfDlrUpdtTempDtlsPersistence.findByDgfDlrUpdtTempDtlsByNid(nid);
	}
	public DgfDlrUpdtTempDtls saveDgfDlrUpdtTempDtls(String nid,long phsclyChlnGdAttchId,int workInGovt,int publcRep,int physclyChlngd,long shopDiv,long shopDis,long shopUpazila,long shopUnion,String shopWard,String shopZipCode,String shopLoc,long shopHeight,long shopLength,long shopWidth,long shopStorageCap,int isCemented,int signBoard,int dlrRunShpHimself,String dealershipMemName,String dealershipMemType,int truckType,String truckRentFlag,String truckPlatNo,long truckCap,String truckMake,String truckModel,long truckManuYear,long dlrPerfYr1SN,long dlrPerfYr1AllocQty,long dlrPerfYr1ComdtyQty,String dlrPerfYr1DlrCtgry,String dlrPerfYr1Rmrk,long dlrPerfYr2SN,long dlrPerfYr2AllocQty,long dlrPerfYr2ComdtyQty,String dlrPerfYr2DlrCtgry,String dlrPerfYr2Rmrk,long dlrPerfYr3SN,long dlrPerfYr3AllocQty,long dlrPerfYr3ComdtyQty,String dlrPerfYr3DlrCtgry,String dlrPerfYr3Rmrk,int dlrOptFoodgrainLicense,int dlrOptTradeLicense,int dlrOptTcvDlrLicense,int dlrOptImportLicense,int dlrOptLicenseEssentialGoods,int dlrOptTradeLicenseAgriculture) {
		List<DgfDlrUpdtTempDtls> dlrUpdtTempDtlsObjList = null;
		DgfDlrUpdtTempDtls dlrUpdtTempDtlsObj = null;
		if (Validator.isNotNull(nid) && PrincipalRoleAndLocationUtil.isMatchUserWithNationalId(nid)) {
			dlrUpdtTempDtlsObjList = getDgfDlrUpdtTempDtlsByNid(nid);
			if(dlrUpdtTempDtlsObjList == null || dlrUpdtTempDtlsObjList.isEmpty()) {
				dlrUpdtTempDtlsObj = dgfDlrUpdtTempDtlsLocalService.createDgfDlrUpdtTempDtls(CounterLocalServiceUtil.increment());
			}
			else {
				
				List<DgfDlrUpdtTempDtls> entities = findAllOrderedByIdDesc(nid);
			    if (!entities.isEmpty() && entities.size() > 0) {
			    	dlrUpdtTempDtlsObj = entities.get(0);
			      }
			}
		}
		if (dlrUpdtTempDtlsObj != null && PrincipalRoleAndLocationUtil.isMatchUserWithNationalId(nid)) {
			DgfDlrRegDtls dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtlsByNid(nid);
			if (Validator.isNotNull(nid)) {
				dlrUpdtTempDtlsObj.setNationalId(nid); 
			}
			if(Validator.isNotNull(dgfDlrRegDtls.getDlrRegNo())) {
				dlrUpdtTempDtlsObj.setDlrRegNo(dgfDlrRegDtls.getDlrRegNo());
			}
			if(Validator.isNotNull(dgfDlrRegDtls.getDlrRegNo())) {
				dlrUpdtTempDtlsObj.setDlrRegNo(dgfDlrRegDtls.getDlrRegNo());
			}
			if(Validator.isNotNull(dgfDlrRegDtls.getDlrTypeId())) {
				dlrUpdtTempDtlsObj.setLicenseType(dgfDlrRegDtls.getDlrTypeId());
			}
			if (Validator.isNotNull(dgfDlrRegDtls.getDlrOmsSubType())) {
				dlrUpdtTempDtlsObj.setDlrOmsSubType(dgfDlrRegDtls.getDlrOmsSubType());
			}
			if(Validator.isNotNull(dgfDlrRegDtls.getMaritalStatus())) {
				dlrUpdtTempDtlsObj.setMaritalStatus(dgfDlrRegDtls.getMaritalStatus());
			}
			if(Validator.isNotNull(dgfDlrRegDtls.getSpouseName())) {
				dlrUpdtTempDtlsObj.setSpouseName(dgfDlrRegDtls.getSpouseName());
			}
			if(Validator.isNotNull(dgfDlrRegDtls.getSpouseFthrName())) {
				dlrUpdtTempDtlsObj.setSpouseFthrName(dgfDlrRegDtls.getSpouseFthrName());
			}
			if(Validator.isNotNull(dgfDlrRegDtls.getSpouseBrthDate())) {
				dlrUpdtTempDtlsObj.setSpouseBrthDate(dgfDlrRegDtls.getSpouseBrthDate());
			}
			if(Validator.isNotNull(dgfDlrRegDtls.getSpouseNid())) {
				dlrUpdtTempDtlsObj.setSpouseNid(dgfDlrRegDtls.getSpouseNid());
			}
			if (Validator.isNotNull(workInGovt)) {
				dlrUpdtTempDtlsObj.setWrkInGovt(workInGovt);
			}
			if (Validator.isNotNull(publcRep)) {
				dlrUpdtTempDtlsObj.setPblcRep(publcRep);
			}
			if (Validator.isNotNull(physclyChlngd)) {
				dlrUpdtTempDtlsObj.setPhysclyChlngd(physclyChlngd);
				if(physclyChlngd == DealerCommonConstant.PHYSCLYCHLNGD) {
					if (Validator.isNotNull(phsclyChlnGdAttchId)) {
						dlrUpdtTempDtlsObj.setPhsclyChlngdAttchId(phsclyChlnGdAttchId);
					}
				}else {
					dlrUpdtTempDtlsObj.setPhsclyChlngdAttchId(0);
				}
			}
			if (Validator.isNotNull(shopDiv)) {
				dlrUpdtTempDtlsObj.setShpDivision(shopDiv);
			}
			if (Validator.isNotNull(shopDis)) {
				dlrUpdtTempDtlsObj.setShpDistrict(shopDis);
			}
			if (Validator.isNotNull(shopUpazila)) {
				dlrUpdtTempDtlsObj.setShpUpzilla(shopUpazila);
			}
			if (Validator.isNotNull(shopUnion)) {
				dlrUpdtTempDtlsObj.setShpUnion(shopUnion);
			}
			if (Validator.isNotNull(shopWard)) {
				dlrUpdtTempDtlsObj.setShpWard(shopWard);
			}
			if (Validator.isNotNull(shopZipCode)) {
				dlrUpdtTempDtlsObj.setShpZipCode(shopZipCode);
			}
			if (Validator.isNotNull(shopLoc)) {
				dlrUpdtTempDtlsObj.setShpLocation(shopLoc);
			}
			if (Validator.isNotNull(shopHeight)) {
				dlrUpdtTempDtlsObj.setShpHeight(shopHeight);
			}
			if (Validator.isNotNull(shopLength)) {
				dlrUpdtTempDtlsObj.setShpLength(shopLength);
			}
			if (Validator.isNotNull(shopWidth)) {
				dlrUpdtTempDtlsObj.setShpWidth(shopWidth);
			}
			if (Validator.isNotNull(shopStorageCap)) {
				dlrUpdtTempDtlsObj.setShpStrgCpcty(shopStorageCap);
			}
			if (Validator.isNotNull(isCemented)) {
				dlrUpdtTempDtlsObj.setShpFlrCmntd(isCemented);
			}
			if (Validator.isNotNull(signBoard)) {
				dlrUpdtTempDtlsObj.setShpSignBrd(signBoard);
			}    
			if (Validator.isNotNull(dlrRunShpHimself)) {
				dlrUpdtTempDtlsObj.setDlrRunShpHimself(dlrRunShpHimself);
				if(dlrRunShpHimself == DealerCommonConstant.DLRRUNSHPHIMSELF) {
					if (Validator.isNotNull(dealershipMemName)) {
						dlrUpdtTempDtlsObj.setDlrshpFmlyMmbrName(dealershipMemName);
					}   
					if (Validator.isNotNull(dealershipMemType)) {
						dlrUpdtTempDtlsObj.setDlrshpFmlyMmbrType(dealershipMemType);
					}  
				}else {
					dlrUpdtTempDtlsObj.setDlrshpFmlyMmbrName(null);
					dlrUpdtTempDtlsObj.setDlrshpFmlyMmbrType(null);
				}
			}
			if(Validator.isNotNull(dgfDlrRegDtls.getDlrTypeId())) {
				if(dgfDlrRegDtls.getDlrTypeId().equals(DealerCommonConstant.OMS)) {
					if (Validator.isNotNull(truckType)) {
						dlrUpdtTempDtlsObj.setDlrShpTrckTypFlg(truckType);
					} 
					if (Validator.isNotNull(truckRentFlag)) {
						dlrUpdtTempDtlsObj.setTrckRentOwnFlg(truckRentFlag);
					} 
					if (Validator.isNotNull(truckPlatNo)) {
						dlrUpdtTempDtlsObj.setTrckLicnsPlatNo(truckPlatNo);
					} 
					if (Validator.isNotNull(truckCap)) {
						dlrUpdtTempDtlsObj.setTrckCpcty(truckCap);
					} 
					if (Validator.isNotNull(truckMake)) {
						dlrUpdtTempDtlsObj.setTrckMake(truckMake);
					} 
					if (Validator.isNotNull(truckModel)) {
						dlrUpdtTempDtlsObj.setTrckModel(truckModel);
					} 
					if (Validator.isNotNull(truckManuYear)) {
						dlrUpdtTempDtlsObj.setTrckMfgYr(truckManuYear);
					} 
				}else {
					dlrUpdtTempDtlsObj.setDlrShpTrckTypFlg(-1);
					dlrUpdtTempDtlsObj.setTrckRentOwnFlg("");
					dlrUpdtTempDtlsObj.setTrckLicnsPlatNo(null);
					dlrUpdtTempDtlsObj.setTrckCpcty(0);
					dlrUpdtTempDtlsObj.setTrckMake(null);
					dlrUpdtTempDtlsObj.setTrckModel(null);
					dlrUpdtTempDtlsObj.setTrckMfgYr(0);
				}
			}
			if (Validator.isNotNull(dlrPerfYr1SN)) {
				dlrUpdtTempDtlsObj.setDlrPerfYr1(dlrPerfYr1SN);
			} 
			if (Validator.isNotNull(dlrPerfYr1AllocQty)) {
				dlrUpdtTempDtlsObj.setDlrPerfYr1AllocQty(dlrPerfYr1AllocQty);
			} 
			if (Validator.isNotNull(dlrPerfYr1ComdtyQty)) {
				dlrUpdtTempDtlsObj.setDlrPerfYr1ComdtyQty(dlrPerfYr1ComdtyQty);
			} 
			if (Validator.isNotNull(dlrPerfYr1DlrCtgry)) {
				dlrUpdtTempDtlsObj.setDlrPerfYr1DlrCtgry(dlrPerfYr1DlrCtgry);
			} 
			if (Validator.isNotNull(dlrPerfYr1Rmrk)) {
				dlrUpdtTempDtlsObj.setDlrPerfYr1Rmrk(dlrPerfYr1Rmrk);
			} 
			if (Validator.isNotNull(dlrPerfYr2SN)) {
				dlrUpdtTempDtlsObj.setDlrPerfYr2(dlrPerfYr2SN);
			} 
			if (Validator.isNotNull(dlrPerfYr2AllocQty)) {
				dlrUpdtTempDtlsObj.setDlrPerfYr2AllocQty(dlrPerfYr2AllocQty);
			} 
			if (Validator.isNotNull(dlrPerfYr2ComdtyQty)) {
				dlrUpdtTempDtlsObj.setDlrPerfYr2ComdtyQty(dlrPerfYr2ComdtyQty);
			} 
			if (Validator.isNotNull(dlrPerfYr2DlrCtgry)) {
				dlrUpdtTempDtlsObj.setDlrPerfYr2DlrCtgry(dlrPerfYr2DlrCtgry);
			} 
			if (Validator.isNotNull(dlrPerfYr2Rmrk)) {
				dlrUpdtTempDtlsObj.setDlrPerfYr2Rmrk(dlrPerfYr2Rmrk);
			} 
			if (Validator.isNotNull(dlrPerfYr3SN)) {
				dlrUpdtTempDtlsObj.setDlrPerfYr3(dlrPerfYr3SN);
			} 
			if (Validator.isNotNull(dlrPerfYr3AllocQty)) {
				dlrUpdtTempDtlsObj.setDlrPerfYr3AllocQty(dlrPerfYr3AllocQty);
			} 
			if (Validator.isNotNull(dlrPerfYr3ComdtyQty)) {
				dlrUpdtTempDtlsObj.setDlrPerfYr3ComdtyQty(dlrPerfYr3ComdtyQty);
			} 
			if (Validator.isNotNull(dlrPerfYr3DlrCtgry)) {
				dlrUpdtTempDtlsObj.setDlrPerfYr3DlrCtgry(dlrPerfYr3DlrCtgry);
			} 
			if (Validator.isNotNull(dlrPerfYr3Rmrk)) {
				dlrUpdtTempDtlsObj.setDlrPerfYr3Rmrk(dlrPerfYr3Rmrk);
			} 
			if (Validator.isNotNull(dlrOptFoodgrainLicense)) {
				dlrUpdtTempDtlsObj.setFoodgrainLicense(dlrOptFoodgrainLicense);
			} 
			if (Validator.isNotNull(dlrOptTradeLicense)) {
				dlrUpdtTempDtlsObj.setTradeLicense(dlrOptTradeLicense);
			} 
			if (Validator.isNotNull(dlrOptTcvDlrLicense)) {
				dlrUpdtTempDtlsObj.setTcvDlrLicense(dlrOptTcvDlrLicense);
			} 
			if (Validator.isNotNull(dlrOptImportLicense)) {
				dlrUpdtTempDtlsObj.setImportLicense(dlrOptImportLicense);
			} 
			if (Validator.isNotNull(dlrOptLicenseEssentialGoods)) {
				dlrUpdtTempDtlsObj.setLicenseEssentialGoods(dlrOptLicenseEssentialGoods);
			} 
			if (Validator.isNotNull(dlrOptTradeLicenseAgriculture)) {
				dlrUpdtTempDtlsObj.setTradeLicenseAgriculture(dlrOptTradeLicenseAgriculture);
			} 
			if(Validator.isNotNull(dgfDlrRegDtls.getDlrRegNo())) {
				User user = PrincipalRoleAndLocationUtil.principalUser();
				dlrUpdtTempDtlsObj.setStatus(WorkflowConstants.STATUS_DRAFT);
				dlrUpdtTempDtlsObj.setUserId(user.getUserId());
				dlrUpdtTempDtlsObj.setGroupId(user.getGroupId());
				dlrUpdtTempDtlsObj.setCompanyId(user.getCompanyId());
			}
				dlrUpdtTempDtlsObj = dgfDlrUpdtTempDtlsLocalService.updateDgfDlrUpdtTempDtls(dlrUpdtTempDtlsObj);
				return dlrUpdtTempDtlsObj;
			}
		return null;
	}
	public List<DgfDlrUpdtTempDtls> findAllOrderedByIdDesc(String nid) throws SystemException {
	    DynamicQuery dynamicQuery = DgfDlrUpdtTempDtlsLocalServiceUtil.dynamicQuery();
	    dynamicQuery.add(RestrictionsFactoryUtil.eq("nationalId", nid));
	    Order order = OrderFactoryUtil.desc("version");
	    dynamicQuery.addOrder(order);
	    return dynamicQuery(dynamicQuery);
	}
}