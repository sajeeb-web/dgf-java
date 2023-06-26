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
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.util.GroupThreadLocal;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.portlet.ActionRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.dealer.registration.config.DealerMessageUtil;
import bd.gov.dgfood.dealer.registration.exception.NoSuchDgfDlrRegDtlsException;
import bd.gov.dgfood.dealer.registration.model.DgfDlrPerfDtls;
import bd.gov.dgfood.dealer.registration.model.DgfDlrRegAddlDtls;
import bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls;
import bd.gov.dgfood.dealer.registration.model.DgfDlrUpdtTempDtls;
import bd.gov.dgfood.dealer.registration.service.DgfDlrPerfDtlsLocalServiceUtil;
import bd.gov.dgfood.dealer.registration.service.DgfDlrRegAddlDtlsLocalServiceUtil;
import bd.gov.dgfood.dealer.registration.service.DgfDlrRegDtlsLocalServiceUtil;
import bd.gov.dgfood.dealer.registration.service.DgfDlrUpdtTempDtlsLocalServiceUtil;
import bd.gov.dgfood.dealer.registration.service.base.DgfDlrRegDtlsLocalServiceBaseImpl;
import bd.gov.dgfood.dealer.registration.util.DateMakerUtil;
import bd.gov.dgfood.dealer.registration.util.DealerCommonConstant;
import bd.gov.dgfood.dealer.registration.util.LocationWisePermissionUtil;
import bd.gov.dgfood.dealer.registration.util.PrincipalRoleAndLocationUtil;
import bd.gov.dgfood.dealer.registration.util.UploadFileUtil;
import bd.gov.dgfood.dealer.registration.workflow.DgfoodDealerWorkflowHandlerUtil;
import bd.gov.dgfood.food.grain.license.model.DgfAttachments;
import bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls;
import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.model.dgfLocDistrict;
import bd.gov.dgfood.food.grain.license.model.dgfLocDivision;
import bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict;
import bd.gov.dgfood.food.grain.license.model.dgfLocUnion;
import bd.gov.dgfood.food.grain.license.model.licnsUserRegs;
import bd.gov.dgfood.food.grain.license.service.DgfAttachmentsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfFglPreDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfUsersOtpDetailsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.dgfLocDistrictLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.dgfLocDivisionLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.dgfLocSubdistrictLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.dgfLocUnionLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.licnsUserRegsLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls", service = AopService.class)
public class DgfDlrRegDtlsLocalServiceImpl extends DgfDlrRegDtlsLocalServiceBaseImpl {

	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@Reference
	private DealerMessageUtil dealerMessageUtil;

	public DgfDlrRegDtls getDgfDlrRegDtlsByNid(String nid) {
		try {
			return dgfDlrRegDtlsPersistence.findByDgfDlrRegDtlsByNid(nid);
		} catch (NoSuchDgfDlrRegDtlsException e) {
			log.error("Dealer National Id not found: " + e.getMessage());
		}
		return null;
	}

	public DgfDlrRegDtls getDgfDlrRegDtlsByUserId(long userId) {
		try {
			return dgfDlrRegDtlsPersistence.findByDgfDlrRegDtlsByUserId(userId);
		} catch (NoSuchDgfDlrRegDtlsException e) {
			log.error("Dealer not found by UserId: " + e.getMessage());
		}
		return null;
	}

	public DgfDlrRegDtls getDgfDlrRegDtlsByNationalIdAndLicenseNo(String nationalId, String licenseNo, long regNo) {
		try {
			return dgfDlrRegDtlsPersistence.findByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo(nationalId, licenseNo,
					regNo);
		} catch (Exception e) {
			log.error("Dealer National + license Id not found +   " + e.getMessage());
		}
		return null;
	}

	public DgfAttachments uploadFile(ActionRequest actionRequest, String nationalId, String realPath,
			ResourceBundle bundle, String filecat, String attachmentInputName) {

		DgfAttachments dgfAttachmentObj = null;

		dgfAttachmentObj = UploadFileUtil.addUploadDoc(actionRequest, nationalId, realPath, bundle, filecat,
				attachmentInputName);

		return dgfAttachmentObj;
	}

	public DgfDlrRegDtls saveRegData(String licenseNo, Date licnsIssueDate, String dealerShipType, String omsSubType,
			String nid, Date dob, String maritalStatus, String spouseName, String spouseFatherName, String spouseNid,
			Date spouseDob) {
		DgfDlrRegDtls dlrRegObj = null;

		if (Validator.isNotNull(nid) && PrincipalRoleAndLocationUtil.isMatchUserWithNationalId(nid)) {
			dlrRegObj = getDgfDlrRegDtlsByNid(nid);
			if (dlrRegObj == null) {
				long dlrRegId = CounterLocalServiceUtil.increment();
				dlrRegObj = dgfDlrRegDtlsLocalService.createDgfDlrRegDtls(dlrRegId);
			}
		}
		if (dlrRegObj != null && PrincipalRoleAndLocationUtil.isMatchUserWithNationalId(nid)) {
			long currentTimeMillis = System.currentTimeMillis();
			String dlrRegAppNoStr = nid.substring(nid.length() - 4) + currentTimeMillis;
			long dlrRegAppNo = 0;
			if (dlrRegAppNoStr != null) {
				dlrRegAppNo = Long.parseLong(dlrRegAppNoStr);
			}
			if (Validator.isNotNull(nid)) {
				dlrRegObj.setNationalId(nid);
			}
			if (Validator.isNotNull(dlrRegAppNo)) {
				dlrRegObj.setDlrRegApplNo(dlrRegAppNo);
			}
			if (Validator.isNotNull(dob)) {
				dlrRegObj.setDlrBrthDate(dob);
			}
			if (Validator.isNotNull(licenseNo)) {
				dlrRegObj.setFglLicnsNo(licenseNo);
			}
			if (Validator.isNotNull(licnsIssueDate)) {
				dlrRegObj.setFglLicnsIssueDate(licnsIssueDate);
			}
			if (Validator.isNotNull(dealerShipType)) {
				dlrRegObj.setDlrTypeId(dealerShipType);
				if(dealerShipType.equals(DealerCommonConstant.OMS)) {
					if (Validator.isNotNull(omsSubType)) {
						dlrRegObj.setDlrOmsSubType(omsSubType);
					}
				}else {
					dlrRegObj.setDlrOmsSubType("");
				}
			}
			if (Validator.isNotNull(maritalStatus)) {
				dlrRegObj.setMaritalStatus(maritalStatus);
				if(maritalStatus.equals(DealerCommonConstant.MARITAL_STATUS_MARRIED)) {
					if (Validator.isNotNull(spouseName)) {
						dlrRegObj.setSpouseName(spouseName);
					}
					if (Validator.isNotNull(spouseFatherName)) {
						dlrRegObj.setSpouseFthrName(spouseFatherName);
					}
					if (Validator.isNotNull(spouseNid)) {
						dlrRegObj.setSpouseNid(spouseNid);
					}
					if (Validator.isNotNull(spouseDob)) {
						dlrRegObj.setSpouseBrthDate(spouseDob);
					}
				}else {
					dlrRegObj.setSpouseName(null);
					dlrRegObj.setSpouseFthrName(null);
					dlrRegObj.setSpouseNid(null);
					dlrRegObj.setSpouseBrthDate(null);
				}
			}
			if (Validator.isNotNull(dlrRegObj.getDlrRegNo())) {
				User user = PrincipalRoleAndLocationUtil.principalUser();
				dlrRegObj.setStatus(WorkflowConstants.STATUS_DRAFT);
				dlrRegObj.setUserId(user.getUserId());
				dlrRegObj.setGroupId(user.getGroupId());
				dlrRegObj.setCompanyId(user.getCompanyId());
			}
			dlrRegObj = dgfDlrRegDtlsLocalService.updateDgfDlrRegDtls(dlrRegObj);
			return dlrRegObj;
		}
		return null;
	}

	public DgfDlrRegDtls saveRegLocData(String nid, long shopDiv, long shopDis, long shopUpazila, long shopUnion) {
		DgfDlrRegDtls dlrRegObj = null;

		dlrRegObj = getDgfDlrRegDtlsByNid(nid);
		if (dlrRegObj != null && PrincipalRoleAndLocationUtil.isMatchUserWithNationalId(nid)) {
			if (Validator.isNotNull(shopDiv)) {
				dlrRegObj.setDivision(shopDiv);
			}
			if (Validator.isNotNull(shopDis)) {
				dlrRegObj.setDistrict(shopDis);
			}
			if (Validator.isNotNull(shopUpazila)) {
				dlrRegObj.setUpzilla(shopUpazila);
			}
			if (Validator.isNotNull(shopUnion)) {
				dlrRegObj.setUnionName(shopUnion);
			}
			dlrRegObj = dgfDlrRegDtlsLocalService.updateDgfDlrRegDtls(dlrRegObj);
			return dlrRegObj;
		}
		return null;
	}

	public DgfDlrRegDtls saveRegDocData(String nid, long bankSolvCertAttchId, long taxRtrnCertAttchId,
			long shopOwnrshpDocAttchId, long shopRentalDocAttchId, long signOrThumbPicAttchId) {
		DgfDlrRegDtls dlrRegObj = null;

		dlrRegObj = getDgfDlrRegDtlsByNid(nid);
		if (dlrRegObj != null && PrincipalRoleAndLocationUtil.isMatchUserWithNationalId(nid)) {
			if (Validator.isNotNull(bankSolvCertAttchId)) {
				dlrRegObj.setBnkSolvncyCertId(bankSolvCertAttchId);
			}
			if (Validator.isNotNull(taxRtrnCertAttchId)) {
				dlrRegObj.setIncmTaxAttchID(taxRtrnCertAttchId);
			}
			if (Validator.isNotNull(shopOwnrshpDocAttchId)) {
				dlrRegObj.setShpOwnshipDocuId(shopOwnrshpDocAttchId);
			}
			if (Validator.isNotNull(shopRentalDocAttchId)) {
				dlrRegObj.setShpRentedDocuId(shopRentalDocAttchId);
			}
			if (Validator.isNotNull(signOrThumbPicAttchId)) {
				dlrRegObj.setSignatureId(signOrThumbPicAttchId);
			}
			dlrRegObj = dgfDlrRegDtlsLocalService.updateDgfDlrRegDtls(dlrRegObj);
			return dlrRegObj;
		}
		return null;
	}

	public DgfDlrRegDtls saveFinalSubmitData(String nid) {
		DgfDlrRegDtls dlrRegObj = null;
		DgfDlrPerfDtls dlrPerfDtlsObj = null;
		DgfDlrRegAddlDtls dlrRegAddlDtlsObj = null;
		DgfDlrUpdtTempDtls dlrUpdtTempDtlsObj = null;
		dlrRegObj = getDgfDlrRegDtlsByNid(nid);
		dlrPerfDtlsObj = DgfDlrPerfDtlsLocalServiceUtil.getDgfDlrPerfDtlsByDlrRegNo(dlrRegObj.getDlrRegNo());
		dlrRegAddlDtlsObj = DgfDlrRegAddlDtlsLocalServiceUtil.getDgfDlrRegAddlDtlsByRegNo(dlrRegObj.getDlrRegNo());
		List<DgfDlrUpdtTempDtls> dlrUpdtTempDtlsObjList = DgfDlrUpdtTempDtlsLocalServiceUtil
				.findAllOrderedByIdDesc(nid);
		if (!dlrUpdtTempDtlsObjList.isEmpty() && dlrUpdtTempDtlsObjList.size() > 0) {
			dlrUpdtTempDtlsObj = dlrUpdtTempDtlsObjList.get(0);
		}

		if (dlrRegObj != null && PrincipalRoleAndLocationUtil.isMatchUserWithNationalId(nid)) {
			dlrRegObj.setVersion(DealerCommonConstant.INT_VERSION);
			dlrRegObj.setStatus(WorkflowConstants.STATUS_PENDING);
			dlrPerfDtlsObj.setVersion(DealerCommonConstant.INT_VERSION);
			dlrRegAddlDtlsObj.setVersion(DealerCommonConstant.INT_VERSION);
			dlrUpdtTempDtlsObj.setVersion(DealerCommonConstant.INT_VERSION);
			dlrUpdtTempDtlsObj.setStatus(WorkflowConstants.STATUS_PENDING);

			dlrRegObj = dgfDlrRegDtlsLocalService.updateDgfDlrRegDtls(dlrRegObj);
			dlrPerfDtlsObj = DgfDlrPerfDtlsLocalServiceUtil.updateDgfDlrPerfDtls(dlrPerfDtlsObj);
			dlrRegAddlDtlsObj = DgfDlrRegAddlDtlsLocalServiceUtil.updateDgfDlrRegAddlDtls(dlrRegAddlDtlsObj);
			dlrUpdtTempDtlsObj = DgfDlrUpdtTempDtlsLocalServiceUtil.updateDgfDlrUpdtTempDtls(dlrUpdtTempDtlsObj);
			return dlrRegObj;
		}
		return null;
	}

	public DgfDlrRegDtls updateStatus(long userId, long resourcePrimKey, int status, ServiceContext serviceContext)
			throws PortalException {
		User user = userLocalService.getUser(userId);
		DgfDlrRegDtls dgfDlrRegDtls = getDgfDlrRegDtls(resourcePrimKey);
		dgfDlrRegDtls.setStatus(status);
		dgfDlrRegDtls.setStatusByUserId(userId);
		dgfDlrRegDtls.setStatusByUserName(user.getFullName());
		dgfDlrRegDtls.setStatusDate(new Date());
		dgfDlrRegDtlsPersistence.update(dgfDlrRegDtls);
		return dgfDlrRegDtls;
	}

	/////////// START WORKFLOW //////////////////
	public boolean checkDcfUsersExistByLocation(long classPK) {
		log.info("DgfDlrRegDtlsLocalServiceImpl.checkDcfUsersExistByLocation START");
		DgfDlrRegDtls dgfDlrRegDtls = null;
		List<DgfUsers> dgfUserList = null;
		boolean isExistAcfUser = false;
		try {
			dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtls(classPK);
			dgfUserList = DgfUsersLocalServiceUtil.getDgfDcfUsersByDistrict(dgfDlrRegDtls.getDistrict(),
					dgfDlrRegDtls.getCompanyId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("ERROR: " + e.getMessage());
		}
		if (Validator.isNotNull(dgfUserList) && dgfUserList.size() > 0) {
			isExistAcfUser = true;
		}
		log.info("DgfDlrRegDtlsLocalServiceImpl.checkDcfUsersExistByLocation END");
		return isExistAcfUser;
	}

	public boolean checkUcfUsersExistByLocation(long classPK) {
		log.info("DgfDlrRegDtlsLocalServiceImpl.checkUcfUsersExistByLocation START");
		DgfDlrRegDtls dgfDlrRegDtls = null;
		List<DgfUsers> dgfUserList = null;
		boolean isExistAcfUser = false;
		try {
			dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtls(classPK);
			dgfUserList = DgfUsersLocalServiceUtil.getDgfUcfUsersByDistrict(dgfDlrRegDtls.getUpzilla(),
					dgfDlrRegDtls.getCompanyId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("ERROR: " + e.getMessage());
		}
		if (Validator.isNotNull(dgfUserList) && dgfUserList.size() > 0) {
			isExistAcfUser = true;
		}
		log.info("DgfDlrRegDtlsLocalServiceImpl.checkUcfUsersExistByLocation END");
		return isExistAcfUser;
	}

	public boolean checkCcdrUsersExistByLocation(long classPK) {
		log.info("DgfDlrRegDtlsLocalServiceImpl.checkCcdrUsersExistByLocation START");
		DgfDlrRegDtls dgfDlrRegDtls = null;
		List<DgfUsers> dgfUserList = null;
		boolean isExistAcfUser = false;
		try {
			dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtls(classPK);
			dgfUserList = DgfUsersLocalServiceUtil.getDgfCcdrUsersByUpazila(dgfDlrRegDtls.getUpzilla(),
					dgfDlrRegDtls.getCompanyId());
			// TODO check CCDR from user list
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("ERROR: " + e.getMessage());
		}
		if (Validator.isNotNull(dgfUserList) && dgfUserList.size() > 0) {
			isExistAcfUser = true;
		}
		log.info("DgfDlrRegDtlsLocalServiceImpl.checkCcdrUsersExistByLocation END");
		return isExistAcfUser;
	}

	public boolean checkRcfUsersExistByLocation(long classPK) {
		log.info("DgfDlrRegDtlsLocalServiceImpl.checkRcfUsersExistByLocation START");
		DgfDlrRegDtls dgfDlrRegDtls = null;
		List<DgfUsers> dgfUserList = null;
		boolean isExistAcfUser = false;
		try {
			dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtls(classPK);
			dgfUserList = DgfUsersLocalServiceUtil.getDgfRcfUsersByUpazila(dgfDlrRegDtls.getUpzilla(),
					dgfDlrRegDtls.getCompanyId());
			// TODO check RCF from user list
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("ERROR: " + e.getMessage());
		}
		if (Validator.isNotNull(dgfUserList) && dgfUserList.size() > 0) {
			isExistAcfUser = true;
		}
		log.info("DgfDlrRegDtlsLocalServiceImpl.checkRcfUsersExistByLocation END");
		return isExistAcfUser;
	}

	public void setDealerRcfUserNotificationEvent(long classPK) {
		log.info("DgfDlrRegDtlsLocalServiceImpl.setDealerRcfUserNotificationEvent START");
		List<DgfUsers> dgfUserList = null;
		DgfDlrRegDtls dgfDlrRegDtls = null;
		try {
			dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtls(classPK);
			dgfUserList = DgfUsersLocalServiceUtil.getDgfRcfUsersByUpazila(dgfDlrRegDtls.getUpzilla(),
					dgfDlrRegDtls.getCompanyId());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			log.error("ERROR: " + e.getMessage());
		}
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		long workflowTaskId = 0;
		WorkflowTask workflowTask = null;
		try {
			workflowInstanceId = DgfoodDealerWorkflowHandlerUtil
					.getWorkflowInstanceIdByUserIdAndClassPK(dgfDlrRegDtls.getUserId(), dgfDlrRegDtls.getPrimaryKey());
			// get the asset's workflow task
			workflowTask = DgfoodDealerWorkflowHandlerUtil
					.getWorkflowTaskByCompanyIdAndWorkflowInstanceId(dgfDlrRegDtls.getCompanyId(), workflowInstanceId);
			workflowTaskId = workflowTask.getWorkflowTaskId();
		} catch (PortalException e1) {
			log.error("ERROR: " + e1.getMessage());
		}
		// send notification to acf user
		String entryType = "model.resource.bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls";
		String notificationMessage = DealerCommonConstant.NEW_DEALER_REGISTRATION;
		if (Validator.isNotNull(dgfUserList) && dgfUserList.size() > 0) {
			for (DgfUsers dgfUser : dgfUserList) {
				DgfoodDealerWorkflowHandlerUtil.preparedPayloadAndSendUserNotification(dgfUser.getUserId(),
						dgfDlrRegDtls.getCompanyId(), dgfDlrRegDtls.getGroupId(), entryType,
						dgfDlrRegDtls.getPrimaryKey(), DgfDlrRegDtls.class.getName(), workflowInstanceId,
						workflowTaskId, notificationMessage);
			}
		} else {
			log.error("RCF USER NOT FOUND THIS LOCATION");
		}
		log.info("DgfDlrRegDtlsLocalServiceImpl.setDealerRcfUserNotificationEvent END");
	}

	public void setDealerCcdrUserNotificationEvent(long classPK) {
		log.info("DgfDlrRegDtlsLocalServiceImpl.setDealerCcdrUserNotificationEvent START");
		List<DgfUsers> dgfUserList = null;
		DgfDlrRegDtls dgfDlrRegDtls = null;
		try {
			dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtls(classPK);
			dgfUserList = DgfUsersLocalServiceUtil.getDgfCcdrUsersByUpazila(dgfDlrRegDtls.getUpzilla(),
					dgfDlrRegDtls.getCompanyId());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			log.error("ERROR: " + e.getMessage());
		}
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		long workflowTaskId = 0;
		WorkflowTask workflowTask = null;
		try {
			workflowInstanceId = DgfoodDealerWorkflowHandlerUtil
					.getWorkflowInstanceIdByUserIdAndClassPK(dgfDlrRegDtls.getUserId(), dgfDlrRegDtls.getPrimaryKey());
			// get the asset's workflow task
			workflowTask = DgfoodDealerWorkflowHandlerUtil
					.getWorkflowTaskByCompanyIdAndWorkflowInstanceId(dgfDlrRegDtls.getCompanyId(), workflowInstanceId);
			workflowTaskId = workflowTask.getWorkflowTaskId();
		} catch (PortalException e1) {
			log.error("ERROR: " + e1.getMessage());
		}
		// send notification to acf user
		String entryType = "model.resource.bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls";
		String notificationMessage = DealerCommonConstant.NEW_DEALER_REGISTRATION;
		if (Validator.isNotNull(dgfUserList) && dgfUserList.size() > 0) {
			for (DgfUsers dgfUser : dgfUserList) {
				DgfoodDealerWorkflowHandlerUtil.preparedPayloadAndSendUserNotification(dgfUser.getUserId(),
						dgfDlrRegDtls.getCompanyId(), dgfDlrRegDtls.getGroupId(), entryType,
						dgfDlrRegDtls.getPrimaryKey(), DgfDlrRegDtls.class.getName(), workflowInstanceId,
						workflowTaskId, notificationMessage);
			}
		} else {
			log.error("CCDR USER NOT FOUND THIS LOCATION");
		}
		log.info("DgfDlrRegDtlsLocalServiceImpl.setDealerCcdrUserNotificationEvent END");
	}

	public void setDealerUcfUserNotificationEvent(long classPK) {
		log.info("DgfDlrRegDtlsLocalServiceImpl.setDealerUcfUserNotificationEvent START");
		List<DgfUsers> dgfUserList = null;
		DgfDlrRegDtls dgfDlrRegDtls = null;
		try {
			dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtls(classPK);
			dgfUserList = DgfUsersLocalServiceUtil.getDgfUcfUsersByDistrict(dgfDlrRegDtls.getUpzilla(),
					dgfDlrRegDtls.getCompanyId());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			log.error("ERROR: " + e.getMessage());
		}
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		long workflowTaskId = 0;
		WorkflowTask workflowTask = null;
		try {
			workflowInstanceId = DgfoodDealerWorkflowHandlerUtil
					.getWorkflowInstanceIdByUserIdAndClassPK(dgfDlrRegDtls.getUserId(), dgfDlrRegDtls.getPrimaryKey());
			// get the asset's workflow task
			workflowTask = DgfoodDealerWorkflowHandlerUtil
					.getWorkflowTaskByCompanyIdAndWorkflowInstanceId(dgfDlrRegDtls.getCompanyId(), workflowInstanceId);
			workflowTaskId = workflowTask.getWorkflowTaskId();
		} catch (PortalException e1) {
			log.error("ERROR: " + e1.getMessage());
		}
		// send notification to ucf user
		String entryType = "model.resource.bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls";
		String notificationMessage = DealerCommonConstant.NEW_DEALER_REGISTRATION;
		if (Validator.isNotNull(dgfUserList) && dgfUserList.size() > 0) {
			for (DgfUsers dgfUser : dgfUserList) {
				DgfoodDealerWorkflowHandlerUtil.preparedPayloadAndSendUserNotification(dgfUser.getUserId(),
						dgfDlrRegDtls.getCompanyId(), dgfDlrRegDtls.getGroupId(), entryType,
						dgfDlrRegDtls.getPrimaryKey(), DgfDlrRegDtls.class.getName(), workflowInstanceId,
						workflowTaskId, notificationMessage);
			}
		} else {
			log.error("UCF USER NOT FOUND THIS LOCATION");
		}
		log.info("DgfDlrRegDtlsLocalServiceImpl.setDealerUcfUserNotificationEvent END");
	}

	public void setDealerDcfUserNotificationEvent(long classPK) {
		log.info("DgfDlrRegDtlsLocalServiceImpl.setDealerDcfUserNotificationEvent START");
		List<DgfUsers> dgfUserList = null;
		DgfDlrRegDtls dgfDlrRegDtls = null;
		try {
			dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtls(classPK);
			dgfUserList = DgfUsersLocalServiceUtil.getDgfDcfUsersByDistrict(dgfDlrRegDtls.getDistrict(),
					dgfDlrRegDtls.getCompanyId());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		long workflowTaskId = 0;
		WorkflowTask workflowTask = null;
		try {
			workflowInstanceId = DgfoodDealerWorkflowHandlerUtil
					.getWorkflowInstanceIdByUserIdAndClassPK(dgfDlrRegDtls.getUserId(), dgfDlrRegDtls.getPrimaryKey());
			// get the asset's workflow task
			workflowTask = DgfoodDealerWorkflowHandlerUtil
					.getWorkflowTaskByCompanyIdAndWorkflowInstanceId(dgfDlrRegDtls.getCompanyId(), workflowInstanceId);
			workflowTaskId = workflowTask.getWorkflowTaskId();
		} catch (PortalException e1) {
			log.error("ERROR: " + e1.getMessage());
		}
		// send notification to ucf user
		String entryType = "model.resource.bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls";
		String notificationMessage = DealerCommonConstant.NEW_DEALER_REGISTRATION;
		if (Validator.isNotNull(dgfUserList) && dgfUserList.size() > 0) {
			for (DgfUsers dgfUser : dgfUserList) {
				DgfoodDealerWorkflowHandlerUtil.preparedPayloadAndSendUserNotification(dgfUser.getUserId(),
						dgfDlrRegDtls.getCompanyId(), dgfDlrRegDtls.getGroupId(), entryType,
						dgfDlrRegDtls.getPrimaryKey(), DgfDlrRegDtls.class.getName(), workflowInstanceId,
						workflowTaskId, notificationMessage);
			}
		} else {
			log.error("DCF USER NOT FOUND THIS LOCATION");
		}
		log.info("DgfDlrRegDtlsLocalServiceImpl.setDealerDcfUserNotificationEvent END");
	}

	public void sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfDlrRegDtlsLocalServiceImpl.sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfUsers dgfUsers = null;
		DgfDlrRegDtls dgfDlrRegDtls = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtls(classPk);

			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(dgfDlrRegDtls.getNationalId());
			workflowInstanceId = DgfoodDealerWorkflowHandlerUtil
					.getWorkflowInstanceIdByUserIdAndClassPK(dgfDlrRegDtls.getUserId(), dgfDlrRegDtls.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodDealerWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByWorkflowInstanceIdAndNodeId(
					workflowInstanceId, dgfDlrRegDtls.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String dealerMessage = dealerMessageUtil.getDealerUcfApproveMessage();
		String message = dealerMessage + " #" + dgfDlrRegDtls.getDlrRegApplNo() + " " + comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message,
				dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),
				dgfDlrRegDtls.getDlrRegApplNo());
		log.info("DgfDlrRegDtlsLocalServiceImpl.sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}

	public void sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfDlrRegDtlsLocalServiceImpl.sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfUsers dgfUsers = null;
		DgfDlrRegDtls dgfDlrRegDtls = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtls(classPk);

			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(dgfDlrRegDtls.getNationalId());
			workflowInstanceId = DgfoodDealerWorkflowHandlerUtil
					.getWorkflowInstanceIdByUserIdAndClassPK(dgfDlrRegDtls.getUserId(), dgfDlrRegDtls.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodDealerWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByWorkflowInstanceIdAndNodeId(
					workflowInstanceId, dgfDlrRegDtls.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String dealerMessage = dealerMessageUtil.getDealerUcfRejectMessage();
		String message = dealerMessage + " #" + dgfDlrRegDtls.getDlrRegApplNo() + " " + comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message,
				dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),
				dgfDlrRegDtls.getDlrRegApplNo());
		log.info("DgfDlrRegDtlsLocalServiceImpl.sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}

	public void sendDcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfDlrRegDtlsLocalServiceImpl.sendDcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfUsers dgfUsers = null;
		DgfDlrRegDtls dgfDlrRegDtls = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtls(classPk);

			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(dgfDlrRegDtls.getNationalId());
			workflowInstanceId = DgfoodDealerWorkflowHandlerUtil
					.getWorkflowInstanceIdByUserIdAndClassPK(dgfDlrRegDtls.getUserId(), dgfDlrRegDtls.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodDealerWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByWorkflowInstanceIdAndNodeId(
					workflowInstanceId, dgfDlrRegDtls.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String dealerMessage = dealerMessageUtil.getDealerDcfApproveMessage();
		String message = dealerMessage + " #" + dgfDlrRegDtls.getDlrRegApplNo() + " " + comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message,
				dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),
				dgfDlrRegDtls.getDlrRegApplNo());
		log.info("DgfDlrRegDtlsLocalServiceImpl.sendDcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}

	public void sendDcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfDlrRegDtlsLocalServiceImpl.sendDcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfUsers dgfUsers = null;
		DgfDlrRegDtls dgfDlrRegDtls = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtls(classPk);

			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(dgfDlrRegDtls.getNationalId());
			workflowInstanceId = DgfoodDealerWorkflowHandlerUtil
					.getWorkflowInstanceIdByUserIdAndClassPK(dgfDlrRegDtls.getUserId(), dgfDlrRegDtls.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodDealerWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByWorkflowInstanceIdAndNodeId(
					workflowInstanceId, dgfDlrRegDtls.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String dealerMessage = dealerMessageUtil.getDealerDcfRejectMessage();
		String message = dealerMessage + " #" + dgfDlrRegDtls.getDlrRegApplNo() + " " + comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message,
				dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),
				dgfDlrRegDtls.getDlrRegApplNo());
		log.info("DgfDlrRegDtlsLocalServiceImpl.sendDcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}

	public void sendRcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfDlrRegDtlsLocalServiceImpl.sendRcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfUsers dgfUsers = null;
		DgfDlrRegDtls dgfDlrRegDtls = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtls(classPk);

			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(dgfDlrRegDtls.getNationalId());
			workflowInstanceId = DgfoodDealerWorkflowHandlerUtil
					.getWorkflowInstanceIdByUserIdAndClassPK(dgfDlrRegDtls.getUserId(), dgfDlrRegDtls.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodDealerWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByWorkflowInstanceIdAndNodeId(
					workflowInstanceId, dgfDlrRegDtls.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String dealerMessage = dealerMessageUtil.getDealerRcfApproveMessage();
		String message = dealerMessage + " #" + dgfDlrRegDtls.getDlrRegApplNo() + " " + comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message,
				dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),
				dgfDlrRegDtls.getDlrRegApplNo());
		log.info("DgfDlrRegDtlsLocalServiceImpl.sendRcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}

	public void sendRcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfDlrRegDtlsLocalServiceImpl.sendRcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfUsers dgfUsers = null;
		DgfDlrRegDtls dgfDlrRegDtls = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtls(classPk);

			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(dgfDlrRegDtls.getNationalId());
			workflowInstanceId = DgfoodDealerWorkflowHandlerUtil
					.getWorkflowInstanceIdByUserIdAndClassPK(dgfDlrRegDtls.getUserId(), dgfDlrRegDtls.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodDealerWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByWorkflowInstanceIdAndNodeId(
					workflowInstanceId, dgfDlrRegDtls.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String dealerMessage = dealerMessageUtil.getDealerRcfRejectMessage();
		String message = dealerMessage + " #" + dgfDlrRegDtls.getDlrRegApplNo() + " " + comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message,
				dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),
				dgfDlrRegDtls.getDlrRegApplNo());
		log.info("DgfDlrRegDtlsLocalServiceImpl.sendRcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}

	public void sendCcdrApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfDlrRegDtlsLocalServiceImpl.sendCcdrApprovedSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfUsers dgfUsers = null;
		DgfDlrRegDtls dgfDlrRegDtls = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtls(classPk);

			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(dgfDlrRegDtls.getNationalId());
			workflowInstanceId = DgfoodDealerWorkflowHandlerUtil
					.getWorkflowInstanceIdByUserIdAndClassPK(dgfDlrRegDtls.getUserId(), dgfDlrRegDtls.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodDealerWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByWorkflowInstanceIdAndNodeId(
					workflowInstanceId, dgfDlrRegDtls.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String dealerMessage = dealerMessageUtil.getDealerCcdrApproveMessage();
		String message = dealerMessage + " #" + dgfDlrRegDtls.getDlrRegApplNo() + " " + comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message,
				dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),
				dgfDlrRegDtls.getDlrRegApplNo());
		log.info("DgfDlrRegDtlsLocalServiceImpl.sendCcdrApprovedSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}

	public void sendCcdrRejectSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfDlrRegDtlsLocalServiceImpl.sendCcdrRejectSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfUsers dgfUsers = null;
		DgfDlrRegDtls dgfDlrRegDtls = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtls(classPk);

			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(dgfDlrRegDtls.getNationalId());
			workflowInstanceId = DgfoodDealerWorkflowHandlerUtil
					.getWorkflowInstanceIdByUserIdAndClassPK(dgfDlrRegDtls.getUserId(), dgfDlrRegDtls.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodDealerWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByWorkflowInstanceIdAndNodeId(
					workflowInstanceId, dgfDlrRegDtls.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String dealerMessage = dealerMessageUtil.getDealerCcdrRejectMessage();
		String message = dealerMessage + " #" + dgfDlrRegDtls.getDlrRegApplNo() + " " + comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message,
				dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),
				dgfDlrRegDtls.getDlrRegApplNo());
		log.info("DgfDlrRegDtlsLocalServiceImpl.sendCcdrRejectSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}

	public boolean addDealerRegisterWorkflowAndSendMessage(long dlrRegNo, String nationalId) {
		DgfUsers dgfUsers = null;
		DgfDlrRegDtls dgfDlrRegDtls = null;
		boolean isSuccess = false;
		try {
			// get userID
			dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtls(dlrRegNo);
			if (Validator.isNotNull(nationalId) && dgfDlrRegDtls.getNationalId().equals(nationalId)) {
				dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(dgfDlrRegDtls.getNationalId());
			}
			long userId = dgfUsers.getUserId();
			String className = DgfDlrRegDtls.class.getName();
			ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
			// long groupId = themeDisplay.getScopeGroupId();
			// long companyId = themeDisplay.getCompanyId();
			long groupId = dgfDlrRegDtls.getGroupId();
			long companyId = dgfDlrRegDtls.getCompanyId();
			int status = WorkflowConstants.STATUS_PENDING;
			serviceContext.setScopeGroupId(groupId);
			serviceContext.setCompanyId(companyId);
			serviceContext.setUserId(dgfDlrRegDtls.getUserId());
			// update status
			dgfDlrRegDtlsLocalService.updateStatus(userId, dgfDlrRegDtls.getDlrRegNo(), status, serviceContext);
			// start workflow for dgfDlrRegDtls
			WorkflowHandlerRegistryUtil.startWorkflowInstance(companyId, groupId, userId, className,
					dgfDlrRegDtls.getPrimaryKey(), dgfDlrRegDtls, serviceContext);
			// send message
			String dealerMessage = DgfDlrRegDtlsLocalServiceUtil.getDealerFormSubmitMessage();
			String message = dealerMessage + " #" + dgfDlrRegDtls.getDlrRegApplNo();
			// send message to dealer user
			DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message,
					dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),
					dgfDlrRegDtls.getDlrRegApplNo());
			isSuccess = true;
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;

	}
	/////////// END WORKFLOW //////////////////

	public List<Map<String, Object>> getDlrListSearchResult(String dateFrom, String dateTo, String dateType, String nid,
			long union, String dealerType, int status, long roleId, String upazillaOrDistrict, long companyId) {
		Date dateF = DateMakerUtil.dateMaker(dateFrom);
		Date dateT = DateMakerUtil.dateMaker(dateTo);

		try {
			ClassLoader classLoader = getClass().getClassLoader();
			DynamicQuery searchQuery = DynamicQueryFactoryUtil.forClass(DgfDlrRegDtls.class, classLoader);
			searchQuery.add(RestrictionsFactoryUtil.sqlRestriction(LocationWisePermissionUtil.addLocationWisePermission(
					DgfDlrRegDtls.class.getName(), "dlr_reg_no", roleId, upazillaOrDistrict, companyId)));

			Junction conjunction = RestrictionsFactoryUtil.conjunction();

			if (dateF != null) {
				if (dateType != null && dateType.equals("applStatusUpdateDate")) {

					conjunction.add(PropertyFactoryUtil.forName("modifedDate").ge(dateF));

				} else {
					conjunction.add(PropertyFactoryUtil.forName("createDate").ge(dateF));

				}
			}

			if (dateT != null) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(dateT);
				cal.set(Calendar.HOUR_OF_DAY, 23);
				cal.set(Calendar.MINUTE, 59);
				cal.set(Calendar.SECOND, 59);
				cal.set(Calendar.MILLISECOND, 999);
				Date endOfDay = cal.getTime();
				if (dateType != null && dateType.equals("applStatusUpdateDate")) {

					conjunction.add(PropertyFactoryUtil.forName("modifedDate").le(endOfDay));

				} else {

					conjunction.add(PropertyFactoryUtil.forName("createDate").le(endOfDay));

				}

			}

			if (Validator.isNotNull(nid) && !nid.trim().isEmpty()) {
//				status = (status != -2) ? status : -2;
				status = -2;
				conjunction.add(PropertyFactoryUtil.forName("nationalId").eq(nid));

			}

			if (status != -2) {
				conjunction.add(PropertyFactoryUtil.forName("status").eq(status));

			}

			if (Validator.isNotNull(dealerType) && !dealerType.trim().isEmpty()) {
				conjunction.add(PropertyFactoryUtil.forName("dlrTypeId").eq(dealerType));
			}

			if (union != -2) {
				conjunction.add(PropertyFactoryUtil.forName("unionName").eq(union));
			}

			searchQuery.add(conjunction);

			List<DgfDlrRegDtls> dgfDlrRegDltsObj = new ArrayList<DgfDlrRegDtls>();
			dgfDlrRegDltsObj = dgfDlrRegDtlsLocalService.dynamicQuery(searchQuery);

			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
			SimpleDateFormat newFormat = new SimpleDateFormat("dd-MM-yyyy");

			for (DgfDlrRegDtls item : dgfDlrRegDltsObj) {
				Map<String, Object> map = new HashMap<String, Object>();

				DgfFglPreDtls dgfFglPreDtlsObj = null;
				long nidLong = (item.getNationalId() != null) ? Long.parseLong(item.getNationalId()) : 0;
				if (nidLong != 0) {
					dgfFglPreDtlsObj = (DgfFglPreDtlsLocalServiceUtil.getdgfFglPreDtls(nidLong) != null)
							? dgfFglPreDtlsObj = DgfFglPreDtlsLocalServiceUtil.getdgfFglPreDtls(nidLong)
							: dgfFglPreDtlsObj;
				}

				map.put("fglLicenseNo", item.getFglLicnsNo());
				map.put("dealerApplNo", item.getDlrRegApplNo());
				map.put("dealerName",
						(dgfFglPreDtlsObj.getApplicantName() != null) ? dgfFglPreDtlsObj.getApplicantName() : null);
				map.put("nid", item.getNationalId());
				map.put("fglLicIssuDate", newFormat.format(item.getFglLicnsIssueDate()));
				map.put("program", item.getDlrTypeId());
				map.put("status", item.getStatus());
				map.put("dgfDlrRegDltsPrimaryId", item.getPrimaryKey());
				dataList.add(map);
			}

			return dataList;
		} catch (Exception e) {
			log.debug("Dealer Application Search Error======" + e.getMessage());
		}
		return null;
	}

	public Map<String, Object> getDealerData(String nid) {
		DgfDlrRegDtls dgfDlrRegDltsObj = null;
		DgfDlrUpdtTempDtls dgfDlrUpdtTempDltsObj = null;
		List<DgfDlrUpdtTempDtls> dgfDlrUpdtTempDltsList = null;
		DgfDlrRegAddlDtls dgfDlrRegAddDtlObj = null;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		SimpleDateFormat newFormat = new SimpleDateFormat("dd-MM-yyyy");
		DgfAttachments physclyChlngdAttachment = null;
		DgfAttachments bnkSolvCertAttachment = null;
		DgfAttachments incmTaxRtrnCertAttachment = null;
		DgfAttachments shpOwnrDocAttachment = null;
		DgfAttachments shpRentDocAttachment = null;
		DgfAttachments signThumbAttachment = null;

		try {
			dgfDlrRegDltsObj = dgfDlrRegDtlsLocalService.getDgfDlrRegDtlsByNid(nid);
			dgfDlrUpdtTempDltsList = DgfDlrUpdtTempDtlsLocalServiceUtil
					.getDgfDlrUpdtTempDtlsByNid(dgfDlrRegDltsObj.getNationalId());
			List<DgfDlrUpdtTempDtls> entities = DgfDlrUpdtTempDtlsLocalServiceUtil.findAllOrderedByIdDesc(nid);
			if (!entities.isEmpty() && entities.size() > 0) {
				dgfDlrUpdtTempDltsObj = entities.get(0);
			}
			dgfDlrRegAddDtlObj = DgfDlrRegAddlDtlsLocalServiceUtil
					.getDgfDlrRegAddlDtlsByRegNo(dgfDlrRegDltsObj.getDlrRegNo());
			dataMap.put("applicationNo", dgfDlrRegDltsObj.getDlrRegApplNo());
			dataMap.put("fglLicNo", dgfDlrRegDltsObj.getFglLicnsNo());
			 dataMap.put("groupId", dgfDlrRegDltsObj.getGroupId());
			 dataMap.put("companyId", dgfDlrRegDltsObj.getCompanyId());
			dataMap.put("fglIssueDate", newFormat.format(dgfDlrRegDltsObj.getFglLicnsIssueDate()));
			dataMap.put("dlrType", dgfDlrRegDltsObj.getDlrTypeId());
			dataMap.put("maritialStatus", dgfDlrRegDltsObj.getMaritalStatus());
			dataMap.put("spouseName",
					(dgfDlrRegDltsObj.getSpouseName() != null) ? dgfDlrRegDltsObj.getSpouseName() : null);
			dataMap.put("spouseFatherName",
					(dgfDlrRegDltsObj.getSpouseFthrName() != null) ? dgfDlrRegDltsObj.getSpouseFthrName() : null);
			dataMap.put("spouseDob",
					(dgfDlrRegDltsObj.getSpouseBrthDate() != null)
							? newFormat.format(dgfDlrRegDltsObj.getSpouseBrthDate())
							: null);
			dataMap.put("spouseNid",
					(dgfDlrRegDltsObj.getSpouseNid() != null) ? dgfDlrRegDltsObj.getSpouseNid() : null);
			dataMap.put("wrkGovt", (dgfDlrRegAddDtlObj.getWrkInGovt() == 1) ? "Yes" : "n-o-1");
			dataMap.put("pblcRep", (dgfDlrRegAddDtlObj.getPblcRep() == 1) ? "Yes" : "n-o-1");
			dataMap.put("physclyChlngd", (dgfDlrRegAddDtlObj.getPhysclyChlngd() == 1) ? "Yes" : "n-o-1");

			physclyChlngdAttachment = (dgfDlrRegAddDtlObj.getPhsclyChlnGdAttchId() > 0)
					? DgfAttachmentsLocalServiceUtil.getDgfAttachments(dgfDlrRegAddDtlObj.getPhsclyChlnGdAttchId())
					: physclyChlngdAttachment;
			dataMap.put("physclyChlngAttchmnt",
					(physclyChlngdAttachment != null && physclyChlngdAttachment.getFilePath() != null)
							? physclyChlngdAttachment.getFilePath()
							: null);

			dataMap.put("shpLoc", dgfDlrUpdtTempDltsObj.getShpLocation());
			dataMap.put("shpHeight", dgfDlrRegAddDtlObj.getShpHeight());
			dataMap.put("shpLength", dgfDlrRegAddDtlObj.getShpLength());
			dataMap.put("shpCapacity", dgfDlrRegAddDtlObj.getShpStrgCpcty());
			dataMap.put("shpWidth", dgfDlrRegAddDtlObj.getShpWidth());
			dataMap.put("shpCmntd", (dgfDlrRegAddDtlObj.getShpFlrCmntd() == 1) ? "Yes" : "n-o-1");
			dataMap.put("shpSignBrd", (dgfDlrRegAddDtlObj.getShpSignBrd() == 1) ? "Yes" : "n-o-1");
			dataMap.put("dlrLicPossFglLic", dgfDlrUpdtTempDltsObj.getFoodgrainLicense());
			dataMap.put("dlrLicPossTradeLic", dgfDlrUpdtTempDltsObj.getTradeLicense());
			dataMap.put("dlrLicPossTcvDlrLic", dgfDlrUpdtTempDltsObj.getTcvDlrLicense());
			dataMap.put("dlrLicPossImportLic", dgfDlrUpdtTempDltsObj.getImportLicense());
			dataMap.put("dlrLicPossEsstnlGoodsLic", dgfDlrUpdtTempDltsObj.getLicenseEssentialGoods());
			dataMap.put("dlrLicPossTradeAgriLic", dgfDlrUpdtTempDltsObj.getTradeLicenseAgriculture());
			dataMap.put("dlrRunsShopHimself", (dgfDlrRegAddDtlObj.getDlrRunShpHimself() == 1) ? "Yes" : "n-o-1");
			dataMap.put("fmlyDlrLic",
					(dgfDlrUpdtTempDltsObj.getDlrshpFmlyMmbrName() != null)
							? dgfDlrUpdtTempDltsObj.getDlrshpFmlyMmbrName()
							: null);
			dataMap.put("fmlyDlrLicType",
					(dgfDlrUpdtTempDltsObj.getDlrshpFmlyMmbrType() != null)
							? dgfDlrUpdtTempDltsObj.getDlrshpFmlyMmbrType()
							: null);
			dataMap.put("dlrPerfYr1", dgfDlrUpdtTempDltsObj.getDlrPerfYr1());
			dataMap.put("dlrPerfYr2", dgfDlrUpdtTempDltsObj.getDlrPerfYr2());
			dataMap.put("dlrPerfYr3", dgfDlrUpdtTempDltsObj.getDlrPerfYr3());
			dataMap.put("dlrPerfYr1AllocQty", dgfDlrUpdtTempDltsObj.getDlrPerfYr1AllocQty());
			dataMap.put("dlrPerfYr2AllocQty", dgfDlrUpdtTempDltsObj.getDlrPerfYr2AllocQty());
			dataMap.put("dlrPerfYr3AllocQty", dgfDlrUpdtTempDltsObj.getDlrPerfYr3AllocQty());
			dataMap.put("dlrPerfYr1ComdtyQty", dgfDlrUpdtTempDltsObj.getDlrPerfYr1ComdtyQty());
			dataMap.put("dlrPerfYr2ComdtyQty", dgfDlrUpdtTempDltsObj.getDlrPerfYr2ComdtyQty());
			dataMap.put("dlrPerfYr3ComdtyQty", dgfDlrUpdtTempDltsObj.getDlrPerfYr3ComdtyQty());
			dataMap.put("dlrPerfYr1DlrCtgry", dgfDlrUpdtTempDltsObj.getDlrPerfYr1DlrCtgry());
			dataMap.put("dlrPerfYr2DlrCtgry", dgfDlrUpdtTempDltsObj.getDlrPerfYr2DlrCtgry());
			dataMap.put("dlrPerfYr3DlrCtgry", dgfDlrUpdtTempDltsObj.getDlrPerfYr3DlrCtgry());
			dataMap.put("dlrPerfYr1Rmrk", dgfDlrUpdtTempDltsObj.getDlrPerfYr1Rmrk());
			dataMap.put("dlrPerfYr2Rmrk", dgfDlrUpdtTempDltsObj.getDlrPerfYr2Rmrk());
			dataMap.put("dlrPerfYr3Rmrk", dgfDlrUpdtTempDltsObj.getDlrPerfYr3Rmrk());
			dataMap.put("dlrCategory", dgfDlrRegDltsObj.getDlrTypeId());

			bnkSolvCertAttachment = (dgfDlrRegDltsObj.getBnkSolvncyCertId() > 0)
					? DgfAttachmentsLocalServiceUtil.getDgfAttachments(dgfDlrRegDltsObj.getBnkSolvncyCertId())
					: bnkSolvCertAttachment;
			incmTaxRtrnCertAttachment = (dgfDlrRegDltsObj.getIncmTaxAttchID() > 0)
					? DgfAttachmentsLocalServiceUtil.getDgfAttachments(dgfDlrRegDltsObj.getIncmTaxAttchID())
					: incmTaxRtrnCertAttachment;
			shpOwnrDocAttachment = (dgfDlrRegDltsObj.getShpOwnshipDocuId() > 0)
					? DgfAttachmentsLocalServiceUtil.getDgfAttachments(dgfDlrRegDltsObj.getShpOwnshipDocuId())
					: shpOwnrDocAttachment;
			shpRentDocAttachment = (dgfDlrRegDltsObj.getShpRentedDocuId() > 0)
					? DgfAttachmentsLocalServiceUtil.getDgfAttachments(dgfDlrRegDltsObj.getShpRentedDocuId())
					: shpRentDocAttachment;
			signThumbAttachment = (dgfDlrRegDltsObj.getSignatureId() > 0)
					? DgfAttachmentsLocalServiceUtil.getDgfAttachments(dgfDlrRegDltsObj.getSignatureId())
					: signThumbAttachment;

			dataMap.put("bnkSolvCertAttch",
					(bnkSolvCertAttachment != null && bnkSolvCertAttachment.getFilePath() != null)
							? bnkSolvCertAttachment.getFilePath()
							: null);
			dataMap.put("incmTaxAttch",
					(incmTaxRtrnCertAttachment != null && incmTaxRtrnCertAttachment.getFilePath() != null)
							? incmTaxRtrnCertAttachment.getFilePath()
							: null);
			dataMap.put("shpOwnshipDocAttch",
					(shpOwnrDocAttachment != null && shpOwnrDocAttachment.getFilePath() != null)
							? shpOwnrDocAttachment.getFilePath()
							: null);
			dataMap.put("shpRentDocAttch",
					(shpRentDocAttachment != null && shpRentDocAttachment.getFilePath() != null)
							? shpRentDocAttachment.getFilePath()
							: null);
			dataMap.put("signThumbAttch",
					(signThumbAttachment != null && signThumbAttachment.getFilePath() != null)
							? signThumbAttachment.getFilePath()
							: null);
			dataMap.put("status", dgfDlrRegDltsObj.getStatus());
			dataMap.put("statusByUsername",
					(dgfDlrRegDltsObj.getStatusByUserName() != null) ? dgfDlrRegDltsObj.getStatusByUserName() : null);

			Map<String, String> allAddress = (dgfDlrRegDtlsLocalService.getAllAddrs(nid) != null)
					? dgfDlrRegDtlsLocalService.getAllAddrs(nid)
					: null;
			dataMap.put("shpDiv", (allAddress != null) ? allAddress.get("shpDiv") : null);
			dataMap.put("shpDivBn", (allAddress != null) ? allAddress.get("shpDivBn") : null);
			dataMap.put("shpDis", (allAddress != null) ? allAddress.get("shpDis") : null);
			dataMap.put("shpDisBn", (allAddress != null) ? allAddress.get("shpDisBn") : null);
			dataMap.put("shpSubDis", (allAddress != null) ? allAddress.get("shpSubDis") : null);
			dataMap.put("shpSubDisBn", (allAddress != null) ? allAddress.get("shpSubDisBn") : null);
			dataMap.put("shpUn", (allAddress != null) ? allAddress.get("shpUn") : null);
			dataMap.put("shpUnBn", (allAddress != null) ? allAddress.get("shpUnBn") : null);
			dataMap.put("shpWard", (allAddress != null) ? allAddress.get("shpWard") : null);
			dataMap.put("shpZipCode", (allAddress != null) ? allAddress.get("shpZipCode") : null);

			return dataMap;

		} catch (Exception e) {
			log.error("DgfDlrRegDtls not Found for Detail Data====== " + e.getMessage());
		}

		return dataMap;

	}

	public Map<String, String> getAllAddrs(String nid) throws PortalException {

		Map<String, String> address = new HashMap<>();

		try {
			licnsUserRegs licnsUser = licnsUserRegsLocalServiceUtil.getlicnsUserByNid(nid);
			dgfLocDivision div = dgfLocDivisionLocalServiceUtil.getdgfLocDivision(licnsUser.getDivision());
			dgfLocDistrict dis = dgfLocDistrictLocalServiceUtil.getdgfLocDistrict(licnsUser.getDistrict());
			dgfLocSubdistrict subDis = dgfLocSubdistrictLocalServiceUtil.getdgfLocSubdistrict(licnsUser.getUpzilla());
			dgfLocUnion un = dgfLocUnionLocalServiceUtil.getdgfLocUnion(licnsUser.getUnionName());
			String ward = licnsUser.getWard();
			String ps = licnsUser.getPostOffice();
			String zipCode = licnsUser.getZipCode();
			String house = licnsUser.getHouseAddress();

			dgfLocDivision busDiv = dgfLocDivisionLocalServiceUtil.getdgfLocDivision(licnsUser.getBusinessDivision());
			dgfLocDistrict busDis = dgfLocDistrictLocalServiceUtil.getdgfLocDistrict(licnsUser.getBusinessDistrict());
			dgfLocSubdistrict busSubDis = dgfLocSubdistrictLocalServiceUtil
					.getdgfLocSubdistrict(licnsUser.getBusinessUpzilla());
			dgfLocUnion busUn = dgfLocUnionLocalServiceUtil.getdgfLocUnion(licnsUser.getBusinessUnionName());
			String busWard = licnsUser.getBusinessWard();
			String busPs = licnsUser.getBusinessPostOffice();
			String busZipCode = licnsUser.getBusinessZipCode();
			String busHouse = licnsUser.getBusinessHouseAddress();
			DgfDlrUpdtTempDtls dlrUpdtTempDtlsObj = null;

			List<DgfDlrUpdtTempDtls> entities = DgfDlrUpdtTempDtlsLocalServiceUtil.findAllOrderedByIdDesc(nid);
			if (!entities.isEmpty() && entities.size() > 0) {
				dlrUpdtTempDtlsObj = entities.get(0);
			}
			dgfLocDivision shpDiv = dgfLocDivisionLocalServiceUtil
					.getdgfLocDivision(dlrUpdtTempDtlsObj.getShpDivision());
			dgfLocDistrict shpDis = dgfLocDistrictLocalServiceUtil
					.getdgfLocDistrict(dlrUpdtTempDtlsObj.getShpDistrict());

			dgfLocSubdistrict shpSubDis = dgfLocSubdistrictLocalServiceUtil
					.getdgfLocSubdistrict(dlrUpdtTempDtlsObj.getShpUpzilla());
			dgfLocUnion shpUn = dgfLocUnionLocalServiceUtil.getdgfLocUnion(dlrUpdtTempDtlsObj.getShpUnion());
			String shpWard = dlrUpdtTempDtlsObj.getShpWard();
			String shpPs = dlrUpdtTempDtlsObj.getShpPstOffc();
			String shpZipCode = dlrUpdtTempDtlsObj.getShpZipCode();
			String shpVillage = (dlrUpdtTempDtlsObj.getShpVillage() != null) ? dlrUpdtTempDtlsObj.getShpVillage()
					: null;
			String shpPresentAddrs = (dlrUpdtTempDtlsObj.getShpPresentAddress() != null)
					? dlrUpdtTempDtlsObj.getShpPresentAddress()
					: null;
			String shpLocation = (dlrUpdtTempDtlsObj.getShpLocation() != null) ? dlrUpdtTempDtlsObj.getShpLocation()
					: null;

			address.put("division", div.getName());
			address.put("divisionBn", div.getBnName());
			address.put("district", dis.getName());
			address.put("districtBn", dis.getBnName());
			address.put("subDistrict", subDis.getName());
			address.put("subDistrictBn", subDis.getBnName());
			address.put("union", un.getName());
			address.put("unionBn", un.getBnName());
			address.put("ward", ward);
			address.put("zipCode", zipCode);
			address.put("postOffice", ps);
			address.put("house", house);
			address.put("busDivision", busDiv.getName());
			address.put("busDivisionBn", busDiv.getBnName());
			address.put("busDistrict", busDis.getName());
			address.put("busDistrictBn", busDis.getBnName());
			address.put("busSubDistrict", busSubDis.getName());
			address.put("busSubDistrictBn", busSubDis.getBnName());
			address.put("busUnion", busUn.getName());
			address.put("busUnionBn", busUn.getBnName());
			address.put("busWard", busWard);
			address.put("busZipCode", busZipCode);
			address.put("busPostOffice", busPs);
			address.put("busHouse", busHouse);
			address.put("shpDiv", shpDiv.getName());
			address.put("shpDivBn", shpDiv.getBnName());
			address.put("shpDis", shpDis.getName());
			address.put("shpDisBn", shpDis.getBnName());
			address.put("shpSubDis", shpSubDis.getName());
			address.put("shpSubDisBn", shpSubDis.getBnName());
			address.put("shpUn", shpUn.getName());
			address.put("shpUnBn", shpUn.getBnName());
			address.put("shpWard", shpWard);
			address.put("shpPostOffice", shpPs);
			address.put("shpZipCode", shpZipCode);
			address.put("shpVillage", shpVillage);
			address.put("shpPresentAddrs", shpPresentAddrs);
			address.put("shpLocation", shpLocation);

			return address;
		} catch (Exception e) {
			log.error("Address not Found by the Nid======== " + e.getMessage());
		}
		return address;
	}

	public void addDlrRegsDtlsPermission(DgfDlrRegDtls dlrRegDltsObj) {
		try {
			long companyId = dlrRegDltsObj.getCompanyId();
			String[] actionsRW = new String[] { ActionKeys.VIEW, ActionKeys.UPDATE };
			String dlrProgramType = dlrRegDltsObj.getDlrTypeId();
			String dlrOmsSubType = dlrRegDltsObj.getDlrOmsSubType();
			String roleName = null;
			String primKey = null;
			long dhakaMetros[] = DealerCommonConstant.DHAKA_METROS;
			long otherMetros[] = DealerCommonConstant.OTHER_METROS;
			if (dlrProgramType != null) {
				if (DealerCommonConstant.FFP.equalsIgnoreCase(dlrProgramType)
						|| (dlrOmsSubType != null && DealerCommonConstant.OMS.equalsIgnoreCase(dlrProgramType)
								&& DealerCommonConstant.OMS_UPAZILA.equalsIgnoreCase(dlrOmsSubType))) {

					roleName = DealerCommonConstant.ROLE_UCF;
					primKey = dlrRegDltsObj.getPrimaryKey() + StringPool.UNDERLINE
							+ DealerCommonConstant.UPAZILLA_FIRST_LETTER + Long.toString(dlrRegDltsObj.getUpzilla());

				} else if (dlrOmsSubType != null && DealerCommonConstant.OMS.equalsIgnoreCase(dlrProgramType)
						&& DealerCommonConstant.OMS_DISTRICT.equalsIgnoreCase(dlrOmsSubType)) {

					roleName = DealerCommonConstant.ROLE_DCF;
					primKey = dlrRegDltsObj.getPrimaryKey() + StringPool.UNDERLINE
							+ DealerCommonConstant.DISTRICT_FIRST_LETTER + Long.toString(dlrRegDltsObj.getDistrict());

				} else if (dlrOmsSubType != null && DealerCommonConstant.OMS.equalsIgnoreCase(dlrProgramType)
						&& DealerCommonConstant.OMS_DM.equalsIgnoreCase(dlrOmsSubType)) {

					for (long metro : dhakaMetros) {
						if (metro == dlrRegDltsObj.getUpzilla()) {

							roleName = DealerCommonConstant.ROLE_CCDR;
							primKey = dlrRegDltsObj.getPrimaryKey() + StringPool.UNDERLINE
									+ DealerCommonConstant.DHAKA_METRO_FIRST_TWO_LETTER;
						}
					}
				} else if (dlrOmsSubType != null && DealerCommonConstant.OMS.equalsIgnoreCase(dlrProgramType)
						&& DealerCommonConstant.OMS_OM.equalsIgnoreCase(dlrOmsSubType)) {

					for (long metro : otherMetros) {
						if (metro == dlrRegDltsObj.getUpzilla()) {

							roleName = DealerCommonConstant.ROLE_RCF;
							primKey = dlrRegDltsObj.getPrimaryKey() + StringPool.UNDERLINE
									+ DealerCommonConstant.OTHER_METRO_FIRST_TWO_LETTER
									+ Long.toString(dlrRegDltsObj.getUpzilla());
						}
					}
				}
			}

			Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
			if (role != null) {
				ResourcePermissionLocalServiceUtil.setResourcePermissions(companyId, DgfDlrRegDtls.class.getName(),
						ResourceConstants.SCOPE_INDIVIDUAL, primKey, role.getRoleId(), actionsRW);
			}
		} catch (PortalException e) {
			log.error("New dealer add permission error===" + e.getMessage());

		}
	}

	public Map getDealerProfileData() {
		long userId = PrincipalRoleAndLocationUtil.principalUserId();
		DgfDlrRegDtls dgfDlrRegDtlsObj = dgfDlrRegDtlsLocalService.getDgfDlrRegDtlsByUserId(userId);
		Map<String, Object> dealerDetailData = new HashMap<>();
		if (dgfDlrRegDtlsObj != null && dgfDlrRegDtlsObj.getStatus()==0) {
			dealerDetailData = dgfDlrRegDtlsLocalService.getDealerData(dgfDlrRegDtlsObj.getNationalId());
		}
		return dealerDetailData;
	}

	public String getDealerFormSubmitMessage() {
		return dealerMessageUtil.getDealerFormSubmitMessage();
	}

}