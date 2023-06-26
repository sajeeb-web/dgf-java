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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowTask;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.food.grain.license.config.LicenseMessageUtil;
import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfDuplctLicnsReasonException;
import bd.gov.dgfood.food.grain.license.model.DgfBussAddrDtls;
import bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason;
import bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls;
import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.service.DgfBussAddrDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfDuplctLicnsReasonLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfFglPreDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfUsersOtpDetailsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.base.DgfDuplctLicnsReasonLocalServiceBaseImpl;
import bd.gov.dgfood.food.grain.license.service.util.LicenseCommonConstant;
import bd.gov.dgfood.food.grain.workflow.DgfoodWorkflowHandlerUtil;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason",
	service = AopService.class
)
public class DgfDuplctLicnsReasonLocalServiceImpl
	extends DgfDuplctLicnsReasonLocalServiceBaseImpl {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());
	
	@Reference
	private LicenseMessageUtil licenseMessageUtil;
	
	public DgfDuplctLicnsReason getDgfDuplctLicnsReasonByUserId(long userId) throws NoSuchDgfDuplctLicnsReasonException{
		DgfDuplctLicnsReason obj = dgfDuplctLicnsReasonPersistence.findByduplicateLicUserIdFinder(userId);
		if(obj != null) {
			return obj;
		}else {
			return null;
		}
	}
	public DgfDuplctLicnsReason getDgfDuplctLicnsReasonByNid(String nationalId) throws NoSuchDgfDuplctLicnsReasonException {
		DgfDuplctLicnsReason obj = dgfDuplctLicnsReasonPersistence.findByduplicateLicNationalIdFinder(nationalId);
		if(obj != null) {
			return obj;
		}else {
			return null;
		}
	}

	public List<DgfDuplctLicnsReason> getDgfDupLicByNationalIdAndLicense(String nationalId, String licenseNo ) {	
		List<DgfDuplctLicnsReason> obj = dgfDuplctLicnsReasonPersistence.findByduplicateLicNationalIdAndLicenseFinder(nationalId, licenseNo);		
		if(obj != null) {
			return obj;
		}else {
			return null;
		}
	}

	
	public DgfDuplctLicnsReason getDgfDuplctLicnsReasonByTradeLicAttchId(long tradeLicAttchId) throws NoSuchDgfDuplctLicnsReasonException {
		DgfDuplctLicnsReason obj = dgfDuplctLicnsReasonPersistence.findByduplicateLicTradeLicAttchIdFinder(tradeLicAttchId);
		if(obj != null) {
			return obj;
		}else {
			return null;
		}
	}
	public DgfDuplctLicnsReason getDgfDuplctLicnsReasonByPaymentAttchId(long paymentAttchId) throws NoSuchDgfDuplctLicnsReasonException {
		DgfDuplctLicnsReason obj = dgfDuplctLicnsReasonPersistence.findByduplicateLicPaymentAttchIdFinder(paymentAttchId);
		if(obj != null) {
			return obj;
		}else {
			return null;
		}
	}
	public DgfDuplctLicnsReason getDgfDuplctLicnsReasonByFglPrePrimary(long fglPrePrimaryId) throws NoSuchDgfDuplctLicnsReasonException{
		DgfDuplctLicnsReason obj = (DgfDuplctLicnsReason) dgfDuplctLicnsReasonPersistence.findByduplicateLicFglPrePrimaryIdFinder(fglPrePrimaryId);
		if(obj != null) {
			return obj;
		}else {
			return null;
		}
	}
	
	
	public DgfDuplctLicnsReason updateStatus(long userId, long resourcePrimKey, int status, ServiceContext serviceContext)
			throws PortalException {
		User user = userLocalService.getUser(userId);
		DgfDuplctLicnsReason dgfDuplctLicnsReason = getDgfDuplctLicnsReason(resourcePrimKey);
		dgfDuplctLicnsReason.setStatus(status);
		dgfDuplctLicnsReason.setStatusByUserId(userId);
		dgfDuplctLicnsReason.setStatusByUserName(user.getFullName());
		dgfDuplctLicnsReason.setStatusDate(new Date());
		dgfDuplctLicnsReasonPersistence.update(dgfDuplctLicnsReason);
		return dgfDuplctLicnsReason;
	}

	public void setLicenseAcfUserNotificationEvent(long classPK) {
		log.info("DgfDuplctLicnsReasonLocalServiceImpl.setLicenseAcfUserNotificationEvent START");
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfBussAddrDtls dgfBussAddrDtls = null;
		List<DgfUsers> dgfUserList = null;
		DgfDuplctLicnsReason dgfDuplctLicnsReason = null;
		try {
			dgfDuplctLicnsReason = DgfDuplctLicnsReasonLocalServiceUtil.getDgfDuplctLicnsReason(classPK);
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(dgfDuplctLicnsReason.getFglPrePrimaryId());
			dgfBussAddrDtls = DgfBussAddrDtlsLocalServiceUtil.getDgfBussAddrDtls(dgfFglPreDtls.getBussinessAddrId());
			// check acf by location wise
			dgfUserList = DgfUsersLocalServiceUtil.getDgfAcfUsersByDistrict(dgfBussAddrDtls.getBusinessDistrict(),
					dgfFglPreDtls.getCompanyId());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			log.error("ERROR: " + e.getMessage());
		}
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		long workflowTaskId = 0;
		WorkflowTask workflowTask = null;
		try {
			workflowInstanceId = DgfoodWorkflowHandlerUtil.getWorkflowInstanceIdByUserIdAndClassPK(
					dgfDuplctLicnsReason.getUserId(), dgfDuplctLicnsReason.getPrimaryKey());
			// get the asset's workflow task
			workflowTask = DgfoodWorkflowHandlerUtil
					.getWorkflowTaskByCompanyIdAndWorkflowInstanceId(dgfFglPreDtls.getCompanyId(), workflowInstanceId);
			workflowTaskId = workflowTask.getWorkflowTaskId();
		} catch (PortalException e1) {
			log.error("ERROR: " + e1.getMessage());
		}
		// send notification to acf user
		String entryType = "model.resource.bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason";
		String notificationMessage = LicenseCommonConstant.DUPLICATE_FOOD_GRAIN_LICENSE;
		if (Validator.isNotNull(dgfUserList) && dgfUserList.size() > 0) {
			for (DgfUsers dgfUser : dgfUserList) {
				DgfoodWorkflowHandlerUtil.preparedPayloadAndSendUserNotification(dgfUser.getUserId(),
						dgfFglPreDtls.getCompanyId(), dgfFglPreDtls.getGroupId(), entryType,
						dgfDuplctLicnsReason.getPrimaryKey(), DgfDuplctLicnsReason.class.getName(), workflowInstanceId,
						workflowTaskId, notificationMessage);
			}
		} else {
			log.error("ACF USER NOT FOUND THIS LOCATION");
		}
		log.info("DgfDuplctLicnsReasonLocalServiceImpl.setLicenseAcfUserNotificationEvent END");
	}

	public void setLicenseCcdrUserNotificationEvent(long classPK) {
		log.info("DgfDuplctLicnsReasonLocalServiceImpl.setLicenseCcdrUserNotificationEvent START");
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfBussAddrDtls dgfBussAddrDtls = null;
		List<DgfUsers> dgfUserList = null;
		DgfDuplctLicnsReason dgfDuplctLicnsReason = null;
		try {
			dgfDuplctLicnsReason = DgfDuplctLicnsReasonLocalServiceUtil.getDgfDuplctLicnsReason(classPK);
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(dgfDuplctLicnsReason.getFglPrePrimaryId());
			dgfBussAddrDtls = DgfBussAddrDtlsLocalServiceUtil.getDgfBussAddrDtls(dgfFglPreDtls.getBussinessAddrId());
			// check ucf by location wise
			dgfUserList = DgfUsersLocalServiceUtil.getDgfCcdrUsersByUpazila(dgfBussAddrDtls.getBusinessUpzilla(),
					dgfFglPreDtls.getCompanyId());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			log.error("ERROR: " + e.getMessage());
		}
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		long workflowTaskId = 0;
		WorkflowTask workflowTask = null;
		try {
			workflowInstanceId = DgfoodWorkflowHandlerUtil.getWorkflowInstanceIdByUserIdAndClassPK(
					dgfDuplctLicnsReason.getUserId(), dgfDuplctLicnsReason.getPrimaryKey());
			// get the asset's workflow task
			workflowTask = DgfoodWorkflowHandlerUtil
					.getWorkflowTaskByCompanyIdAndWorkflowInstanceId(dgfFglPreDtls.getCompanyId(), workflowInstanceId);
			workflowTaskId = workflowTask.getWorkflowTaskId();
		} catch (PortalException e1) {
			log.error("ERROR: " + e1.getMessage());
		}
		// send notification to ucf user
		String entryType = "model.resource.bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason";
		String notificationMessage = LicenseCommonConstant.DUPLICATE_FOOD_GRAIN_LICENSE;
		if (Validator.isNotNull(dgfUserList) && dgfUserList.size() > 0) {
			for (DgfUsers dgfUser : dgfUserList) {
				DgfoodWorkflowHandlerUtil.preparedPayloadAndSendUserNotification(dgfUser.getUserId(),
						dgfFglPreDtls.getCompanyId(), dgfFglPreDtls.getGroupId(), entryType,
						dgfDuplctLicnsReason.getPrimaryKey(), DgfDuplctLicnsReason.class.getName(), workflowInstanceId,
						workflowTaskId, notificationMessage);
			}
		} else {
			log.error("CCDR USER NOT FOUND THIS LOCATION");
		}
		log.info("DgfDuplctLicnsReasonLocalServiceImpl.setLicenseCcdrUserNotificationEvent END");
	}
	public void setLicenseUcfUserNotificationEvent(long classPK) {
		log.info("DgfDuplctLicnsReasonLocalServiceImpl.setLicenseUcfUserNotificationEvent START");
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfBussAddrDtls dgfBussAddrDtls = null;
		List<DgfUsers> dgfUserList = null;
		DgfDuplctLicnsReason dgfDuplctLicnsReason = null;
		try {
			dgfDuplctLicnsReason = DgfDuplctLicnsReasonLocalServiceUtil.getDgfDuplctLicnsReason(classPK);
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(dgfDuplctLicnsReason.getFglPrePrimaryId());
			dgfBussAddrDtls = DgfBussAddrDtlsLocalServiceUtil.getDgfBussAddrDtls(dgfFglPreDtls.getBussinessAddrId());
			// check ucf by location wise
			dgfUserList = DgfUsersLocalServiceUtil.getDgfUcfUsersByDistrict(dgfBussAddrDtls.getBusinessUpzilla(),
					dgfFglPreDtls.getCompanyId());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			log.error("ERROR: " + e.getMessage());
		}
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		long workflowTaskId = 0;
		WorkflowTask workflowTask = null;
		try {
			workflowInstanceId = DgfoodWorkflowHandlerUtil.getWorkflowInstanceIdByUserIdAndClassPK(
					dgfDuplctLicnsReason.getUserId(), dgfDuplctLicnsReason.getPrimaryKey());
			// get the asset's workflow task
			workflowTask = DgfoodWorkflowHandlerUtil
					.getWorkflowTaskByCompanyIdAndWorkflowInstanceId(dgfFglPreDtls.getCompanyId(), workflowInstanceId);
			workflowTaskId = workflowTask.getWorkflowTaskId();
		} catch (PortalException e1) {
			log.error("ERROR: " + e1.getMessage());
		}
		// send notification to ucf user
		String entryType = "model.resource.bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason";
		String notificationMessage = LicenseCommonConstant.DUPLICATE_FOOD_GRAIN_LICENSE;
		if (Validator.isNotNull(dgfUserList) && dgfUserList.size() > 0) {
			for (DgfUsers dgfUser : dgfUserList) {
				DgfoodWorkflowHandlerUtil.preparedPayloadAndSendUserNotification(dgfUser.getUserId(),
						dgfFglPreDtls.getCompanyId(), dgfFglPreDtls.getGroupId(), entryType,
						dgfDuplctLicnsReason.getPrimaryKey(), DgfDuplctLicnsReason.class.getName(), workflowInstanceId,
						workflowTaskId, notificationMessage);
			}
		} else {
			log.error("UCF USER NOT FOUND THIS LOCATION");
		}
		log.info("DgfDuplctLicnsReasonLocalServiceImpl.setLicenseUcfUserNotificationEvent END");
	}

	public void getDcfUserIdByLocationAndSendNotificationByNodeId(long classPK, String nodeId) {
		log.info("DgfDuplctLicnsReasonLocalServiceImpl.getDcfUserIdByLocationAndSendNotificationByNodeId START");
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfBussAddrDtls dgfBussAddrDtls = null;
		DgfDuplctLicnsReason dgfDuplctLicnsReason = null;
		List<DgfUsers> dgfUserList = null;
		try {
			dgfDuplctLicnsReason = DgfDuplctLicnsReasonLocalServiceUtil.getDgfDuplctLicnsReason(classPK);
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(dgfDuplctLicnsReason.getFglPrePrimaryId());
			dgfBussAddrDtls = DgfBussAddrDtlsLocalServiceUtil.getDgfBussAddrDtls(dgfFglPreDtls.getBussinessAddrId());
			// check dcf by location wise
			dgfUserList = DgfUsersLocalServiceUtil.getDgfDcfUsersByDistrict(dgfBussAddrDtls.getBusinessDistrict(),
					dgfFglPreDtls.getCompanyId());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		long workflowTaskId = 0;
		try {
			workflowInstanceId = DgfoodWorkflowHandlerUtil.getWorkflowInstanceIdByUserIdAndClassPK(
					dgfDuplctLicnsReason.getUserId(), dgfDuplctLicnsReason.getPrimaryKey());
			// get workflow task ID
			workflowTaskId = DgfoodWorkflowHandlerUtil.getWorkflowTaskIdByNode(nodeId, dgfFglPreDtls.getCompanyId(),
					workflowInstanceId);
		} catch (PortalException e1) {
			log.error("ERROR: " + e1.getMessage());
		}
		// send notification to ucf user
		String entryType = "model.resource.bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason";
		String notificationMessage = LicenseCommonConstant.DUPLICATE_FOOD_GRAIN_LICENSE;
		if (Validator.isNotNull(dgfUserList) && dgfUserList.size() > 0) {
			for (DgfUsers dgfUser : dgfUserList) {
				DgfoodWorkflowHandlerUtil.preparedPayloadAndSendUserNotification(dgfUser.getUserId(),
						dgfFglPreDtls.getCompanyId(), dgfFglPreDtls.getGroupId(), entryType,
						dgfDuplctLicnsReason.getPrimaryKey(), DgfDuplctLicnsReason.class.getName(), workflowInstanceId,
						workflowTaskId, notificationMessage);
			}
		} else {
			log.error("DCF USER NOT FOUND THIS LOCATION");
		}
		log.info("DgfDuplctLicnsReasonLocalServiceImpl.getDcfUserIdByLocationAndSendNotificationByNodeId END");
	}
	
	public void sendCcdrApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfDuplctLicnsReasonLocalServiceImpl.sendCcdrApprovedSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfUsers dgfUsers = null;
		DgfDuplctLicnsReason dgfDuplctLicnsReason = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfDuplctLicnsReason = DgfDuplctLicnsReasonLocalServiceUtil.getDgfDuplctLicnsReason(classPk);
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(dgfDuplctLicnsReason.getFglPrePrimaryId());
			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(Long.toString(dgfFglPreDtls.getNationalId()));
			workflowInstanceId = DgfoodWorkflowHandlerUtil.getWorkflowInstanceIdByUserIdAndClassPK(
					dgfDuplctLicnsReason.getUserId(), dgfDuplctLicnsReason.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(
					workflowInstanceId, dgfFglPreDtls.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String licenseMessage = licenseMessageUtil.getLicenseCcdrApproveMessage();
		String message = licenseMessage+" #"+dgfDuplctLicnsReason.getApplicationNo()+" "+comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message, dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),Long.parseLong(dgfDuplctLicnsReason.getApplicationNo()));
		log.info("DgfDuplctLicnsReasonLocalServiceImpl.sendCcdrApprovedSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}

	public void sendCcdrRejectSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfDuplctLicnsReasonLocalServiceImpl.sendCcdrRejectSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfUsers dgfUsers = null;
		DgfDuplctLicnsReason dgfDuplctLicnsReason = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfDuplctLicnsReason = DgfDuplctLicnsReasonLocalServiceUtil.getDgfDuplctLicnsReason(classPk);
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(dgfDuplctLicnsReason.getFglPrePrimaryId());
			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(Long.toString(dgfFglPreDtls.getNationalId()));
			workflowInstanceId = DgfoodWorkflowHandlerUtil.getWorkflowInstanceIdByUserIdAndClassPK(
					dgfDuplctLicnsReason.getUserId(), dgfDuplctLicnsReason.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(
					workflowInstanceId, dgfFglPreDtls.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String licenseMessage = licenseMessageUtil.getLicenseCcdrRejectMessage();
		String message = licenseMessage+" #"+dgfDuplctLicnsReason.getApplicationNo()+" "+comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message, dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),Long.parseLong(dgfDuplctLicnsReason.getApplicationNo()));
		log.info("DgfDuplctLicnsReasonLocalServiceImpl.sendCcdrRejectSmsWithWorkflowCommentsByClassPkAndNodeId END");
	}
	
	public void sendAcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfDuplctLicnsReasonLocalServiceImpl.sendAcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfUsers dgfUsers = null;
		DgfDuplctLicnsReason dgfDuplctLicnsReason = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfDuplctLicnsReason = DgfDuplctLicnsReasonLocalServiceUtil.getDgfDuplctLicnsReason(classPk);
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(dgfDuplctLicnsReason.getFglPrePrimaryId());
			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(Long.toString(dgfFglPreDtls.getNationalId()));
			workflowInstanceId = DgfoodWorkflowHandlerUtil.getWorkflowInstanceIdByUserIdAndClassPK(
					dgfDuplctLicnsReason.getUserId(), dgfDuplctLicnsReason.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(
					workflowInstanceId, dgfFglPreDtls.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String licenseMessage = licenseMessageUtil.getLicenseAcfApproveMessage();
		String message = licenseMessage+" #"+dgfDuplctLicnsReason.getApplicationNo()+" "+comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message, dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),Long.parseLong(dgfDuplctLicnsReason.getApplicationNo()));
		log.info("DgfDuplctLicnsReasonLocalServiceImpl.sendAcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}

	public void sendAcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfDuplctLicnsReasonLocalServiceImpl.sendAcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfUsers dgfUsers = null;
		DgfDuplctLicnsReason dgfDuplctLicnsReason = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfDuplctLicnsReason = DgfDuplctLicnsReasonLocalServiceUtil.getDgfDuplctLicnsReason(classPk);
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(dgfDuplctLicnsReason.getFglPrePrimaryId());
			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(Long.toString(dgfFglPreDtls.getNationalId()));
			workflowInstanceId = DgfoodWorkflowHandlerUtil.getWorkflowInstanceIdByUserIdAndClassPK(
					dgfDuplctLicnsReason.getUserId(), dgfDuplctLicnsReason.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(
					workflowInstanceId, dgfFglPreDtls.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String licenseMessage = licenseMessageUtil.getLicenseAcfRejectMessage();
		String message = licenseMessage+" #"+dgfDuplctLicnsReason.getApplicationNo()+" "+comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message, dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),Long.parseLong(dgfDuplctLicnsReason.getApplicationNo()));
		log.info("DgfDuplctLicnsReasonLocalServiceImpl.sendAcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}

	public void sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfDuplctLicnsReasonLocalServiceImpl.sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfUsers dgfUsers = null;
		DgfDuplctLicnsReason dgfDuplctLicnsReason = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfDuplctLicnsReason = DgfDuplctLicnsReasonLocalServiceUtil.getDgfDuplctLicnsReason(classPk);
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(dgfDuplctLicnsReason.getFglPrePrimaryId());
			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(Long.toString(dgfFglPreDtls.getNationalId()));
			workflowInstanceId = DgfoodWorkflowHandlerUtil.getWorkflowInstanceIdByUserIdAndClassPK(
					dgfDuplctLicnsReason.getUserId(), dgfDuplctLicnsReason.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(
					workflowInstanceId, dgfFglPreDtls.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String licenseMessage = licenseMessageUtil.getLicenseUcfApproveMessage();
		String message = licenseMessage+" #"+dgfDuplctLicnsReason.getApplicationNo()+" "+comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message, dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),Long.parseLong(dgfDuplctLicnsReason.getApplicationNo()));
		log.info("DgfDuplctLicnsReasonLocalServiceImpl.sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}

	public void sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfDuplctLicnsReasonLocalServiceImpl.sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfUsers dgfUsers = null;
		DgfDuplctLicnsReason dgfDuplctLicnsReason = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfDuplctLicnsReason = DgfDuplctLicnsReasonLocalServiceUtil.getDgfDuplctLicnsReason(classPk);
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(dgfDuplctLicnsReason.getFglPrePrimaryId());
			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(Long.toString(dgfFglPreDtls.getNationalId()));
			workflowInstanceId = DgfoodWorkflowHandlerUtil.getWorkflowInstanceIdByUserIdAndClassPK(
					dgfDuplctLicnsReason.getUserId(), dgfDuplctLicnsReason.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(
					workflowInstanceId, dgfFglPreDtls.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String licenseMessage = licenseMessageUtil.getLicenseUcfRejectMessage();
		String message = licenseMessage+" #"+dgfDuplctLicnsReason.getApplicationNo()+" "+comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message, dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),Long.parseLong(dgfDuplctLicnsReason.getApplicationNo()));
		log.info("DgfDuplctLicnsReasonLocalServiceImpl.sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}

	public void sendDcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfDuplctLicnsReasonLocalServiceImpl.sendDcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfUsers dgfUsers = null;
		DgfDuplctLicnsReason dgfDuplctLicnsReason = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfDuplctLicnsReason = DgfDuplctLicnsReasonLocalServiceUtil.getDgfDuplctLicnsReason(classPk);
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(dgfDuplctLicnsReason.getFglPrePrimaryId());
			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(Long.toString(dgfFglPreDtls.getNationalId()));
			workflowInstanceId = DgfoodWorkflowHandlerUtil.getWorkflowInstanceIdByUserIdAndClassPK(
					dgfDuplctLicnsReason.getUserId(), dgfDuplctLicnsReason.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(
					workflowInstanceId, dgfFglPreDtls.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String licenseMessage = licenseMessageUtil.getLicenseDcfApproveMessage();
		String message = licenseMessage+" #"+dgfDuplctLicnsReason.getApplicationNo()+" "+comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message, dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),Long.parseLong(dgfDuplctLicnsReason.getApplicationNo()));
		log.info("DgfDuplctLicnsReasonLocalServiceImpl.sendDcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}

	public void sendDcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfDuplctLicnsReasonLocalServiceImpl.sendDcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfUsers dgfUsers = null;
		DgfDuplctLicnsReason dgfDuplctLicnsReason = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfDuplctLicnsReason = DgfDuplctLicnsReasonLocalServiceUtil.getDgfDuplctLicnsReason(classPk);
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(dgfDuplctLicnsReason.getFglPrePrimaryId());
			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(Long.toString(dgfFglPreDtls.getNationalId()));
			workflowInstanceId = DgfoodWorkflowHandlerUtil.getWorkflowInstanceIdByUserIdAndClassPK(
					dgfDuplctLicnsReason.getUserId(), dgfDuplctLicnsReason.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(
					workflowInstanceId, dgfFglPreDtls.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String licenseMessage = licenseMessageUtil.getLicenseDcfRejectMessage();
		String message = licenseMessage+" #"+dgfDuplctLicnsReason.getApplicationNo()+" "+comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message, dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),Long.parseLong(dgfDuplctLicnsReason.getApplicationNo()));
		log.info("DgfDuplctLicnsReasonLocalServiceImpl.sendDcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}
}