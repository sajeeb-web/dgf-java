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

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.food.grain.license.config.LicenseMessageUtil;
import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfRenewLicenseException;
import bd.gov.dgfood.food.grain.license.model.DgfBussAddrDtls;
import bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason;
import bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls;
import bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls;
import bd.gov.dgfood.food.grain.license.model.DgfRenewLicense;
import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.service.DgfBussAddrDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfFglLicDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfFglPreDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfRenewLicenseLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfUsersOtpDetailsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.base.DgfRenewLicenseLocalServiceBaseImpl;
import bd.gov.dgfood.food.grain.license.service.util.LicenseCommonConstant;
import bd.gov.dgfood.food.grain.workflow.DgfoodWorkflowHandlerUtil;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=bd.gov.dgfood.food.grain.license.model.DgfRenewLicense", service = AopService.class)
public class DgfRenewLicenseLocalServiceImpl extends DgfRenewLicenseLocalServiceBaseImpl {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());
	
	@Reference
	private LicenseMessageUtil licenseMessageUtil;

	public DgfRenewLicense getDgfRenewLicenseByUserId(long userId) throws NoSuchDgfRenewLicenseException {
		return dgfRenewLicensePersistence.findByrenewLicUserIdFinder(userId);
	}

	
	public DgfRenewLicense getDgfRenewLicenseByNid(String nationalId) {
		try {
			return dgfRenewLicensePersistence.findByrenewLicNationalIdFinder(nationalId);
		} catch (NoSuchDgfRenewLicenseException e) {
			log.error("Renew data not found by national Id "+e.getMessage());
		}
		return null;
	}

	public List<DgfRenewLicense> getDgfRenewLicByNationalIdAndLicense(String nationalId, String licenseNo ) {	
		List<DgfRenewLicense> obj = dgfRenewLicensePersistence.findByrenewLicNationalIdAndLicenseFinder(nationalId, licenseNo);	
		if(obj != null) {
			return obj;
		}else {
			return null;
		}
	}
	
	public DgfRenewLicense getDgfRenewLicenseByTradeLicAttchId(long tradeLicAttchId)
			throws NoSuchDgfRenewLicenseException {
		return dgfRenewLicensePersistence.findByrenewLicTradeLicAttchIdFinder(tradeLicAttchId);
	}

	public DgfRenewLicense getDgfRenewLicenseByPaymentAttchId(long paymentAttchId)
			throws NoSuchDgfRenewLicenseException {
		return dgfRenewLicensePersistence.findByrenewLicPaymentAttchIdFinder(paymentAttchId);
	}

	public DgfRenewLicense getDgfRenewLicenseByFglPrePrimary(long fglPrePrimaryId) throws NoSuchDgfRenewLicenseException {
		DgfRenewLicense obj = (DgfRenewLicense) dgfRenewLicensePersistence.findByrenewLicFglPrePrimaryIdFinder(fglPrePrimaryId);
		if(obj != null) {
			return obj;
		}else {
			return null;
		}
	}
	/// START Workflow ///
	public DgfRenewLicense updateStatus(long userId, long resourcePrimKey, int status, ServiceContext serviceContext)
			throws PortalException {
		User user = userLocalService.getUser(userId);
		DgfRenewLicense dgfRenewLicense = getDgfRenewLicense(resourcePrimKey);
		dgfRenewLicense.setStatus(status);
		dgfRenewLicense.setStatusByUserId(userId);
		dgfRenewLicense.setStatusByUserName(user.getFullName());
		dgfRenewLicense.setStatusDate(new Date());
		dgfRenewLicensePersistence.update(dgfRenewLicense);
		return dgfRenewLicense;
	}
	
	public void setLicenseCcdrUserNotificationEvent(long renewLicenseId) {
		log.info("DgfRenewLicenseLocalServiceImpl.setLicenseCcdrUserNotificationEvent START");
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfBussAddrDtls dgfBussAddrDtls = null;
		List<DgfUsers> dgfUserList = null;
		DgfRenewLicense dgfRenewLicense = null;
		try {
			dgfRenewLicense = DgfRenewLicenseLocalServiceUtil.getDgfRenewLicense(renewLicenseId);
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(dgfRenewLicense.getFglPrePrimaryId());
			dgfBussAddrDtls = DgfBussAddrDtlsLocalServiceUtil.getDgfBussAddrDtls(dgfFglPreDtls.getBussinessAddrId());
			// check acf by location wise
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
					dgfRenewLicense.getUserId(), dgfRenewLicense.getPrimaryKey());
			// get the asset's workflow task
			workflowTask = DgfoodWorkflowHandlerUtil
					.getWorkflowTaskByCompanyIdAndWorkflowInstanceId(dgfFglPreDtls.getCompanyId(), workflowInstanceId);
			workflowTaskId = workflowTask.getWorkflowTaskId();
		} catch (PortalException e1) {
			log.error("ERROR: " + e1.getMessage());
		}
		// send notification to acf user
		String entryType = "model.resource.bd.gov.dgfood.food.grain.license.model.DgfRenewLicense";
		String notificationMessage = LicenseCommonConstant.RENEW_FOOD_GRAIN_LICENSE;
		if (Validator.isNotNull(dgfUserList) && dgfUserList.size() > 0) {
			for (DgfUsers dgfUser : dgfUserList) {
				DgfoodWorkflowHandlerUtil.preparedPayloadAndSendUserNotification(dgfUser.getUserId(),
						dgfFglPreDtls.getCompanyId(), dgfFglPreDtls.getGroupId(), entryType,
						dgfRenewLicense.getPrimaryKey(), DgfRenewLicense.class.getName(), workflowInstanceId,
						workflowTaskId, notificationMessage);
			}
		} else {
			log.error("CCDR USER NOT FOUND THIS LOCATION");
		}
		log.info("DgfRenewLicenseLocalServiceImpl.setLicenseCcdrUserNotificationEvent END");
	}

	public void setLicenseAcfUserNotificationEvent(long renewLicenseId) {
		log.info("DgfRenewLicenseLocalServiceImpl.setLicenseAcfUserNotificationEvent START");
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfBussAddrDtls dgfBussAddrDtls = null;
		List<DgfUsers> dgfUserList = null;
		DgfRenewLicense dgfRenewLicense = null;
		try {
			dgfRenewLicense = DgfRenewLicenseLocalServiceUtil.getDgfRenewLicense(renewLicenseId);
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(dgfRenewLicense.getFglPrePrimaryId());
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
					dgfRenewLicense.getUserId(), dgfRenewLicense.getPrimaryKey());
			// get the asset's workflow task
			workflowTask = DgfoodWorkflowHandlerUtil
					.getWorkflowTaskByCompanyIdAndWorkflowInstanceId(dgfFglPreDtls.getCompanyId(), workflowInstanceId);
			workflowTaskId = workflowTask.getWorkflowTaskId();
		} catch (PortalException e1) {
			log.error("ERROR: " + e1.getMessage());
		}
		// send notification to acf user
		String entryType = "model.resource.bd.gov.dgfood.food.grain.license.model.DgfRenewLicense";
		String notificationMessage = LicenseCommonConstant.RENEW_FOOD_GRAIN_LICENSE;
		if (Validator.isNotNull(dgfUserList) && dgfUserList.size() > 0) {
			for (DgfUsers dgfUser : dgfUserList) {
				DgfoodWorkflowHandlerUtil.preparedPayloadAndSendUserNotification(dgfUser.getUserId(),
						dgfFglPreDtls.getCompanyId(), dgfFglPreDtls.getGroupId(), entryType,
						dgfRenewLicense.getPrimaryKey(), DgfRenewLicense.class.getName(), workflowInstanceId,
						workflowTaskId, notificationMessage);
			}
		} else {
			log.error("ACF USER NOT FOUND THIS LOCATION");
		}
		log.info("DgfRenewLicenseLocalServiceImpl.setLicenseAcfUserNotificationEvent END");
	}
	
	public void setLicenseUcfUserNotificationEvent(long renewLicenseId) {
		log.info("DgfRenewLicenseLocalServiceImpl.setLicenseUcfUserNotificationEvent START");
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfBussAddrDtls dgfBussAddrDtls = null;
		List<DgfUsers> dgfUserList = null;
		DgfRenewLicense dgfRenewLicense = null;
		try {
			dgfRenewLicense = DgfRenewLicenseLocalServiceUtil.getDgfRenewLicense(renewLicenseId);
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(dgfRenewLicense.getFglPrePrimaryId());
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
					dgfRenewLicense.getUserId(), dgfRenewLicense.getPrimaryKey());
			// get the asset's workflow task
			workflowTask = DgfoodWorkflowHandlerUtil
					.getWorkflowTaskByCompanyIdAndWorkflowInstanceId(dgfFglPreDtls.getCompanyId(), workflowInstanceId);
			workflowTaskId = workflowTask.getWorkflowTaskId();
		} catch (PortalException e1) {
			log.error("ERROR: " + e1.getMessage());
		}
		// send notification to ucf user
		String entryType = "model.resource.bd.gov.dgfood.food.grain.license.model.DgfRenewLicense";
		String notificationMessage = LicenseCommonConstant.RENEW_FOOD_GRAIN_LICENSE;
		if (Validator.isNotNull(dgfUserList) && dgfUserList.size() > 0) {
			for (DgfUsers dgfUser : dgfUserList) {
				DgfoodWorkflowHandlerUtil.preparedPayloadAndSendUserNotification(dgfUser.getUserId(),
						dgfFglPreDtls.getCompanyId(), dgfFglPreDtls.getGroupId(), entryType,
						dgfRenewLicense.getPrimaryKey(), DgfRenewLicense.class.getName(), workflowInstanceId,
						workflowTaskId, notificationMessage);
			}
		} else {
			log.error("UCF USER NOT FOUND THIS LOCATION");
		}
		log.info("DgfRenewLicenseLocalServiceImpl.setLicenseUcfUserNotificationEvent END");
	}

	public void getDcfUserIdByLocationAndSendNotificationByNodeId(long renewLicenseId, String nodeId) {
		log.info("DgfRenewLicenseLocalServiceImpl.getDcfUserIdByLocationAndSendNotificationByNodeId START");
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfBussAddrDtls dgfBussAddrDtls = null;
		DgfRenewLicense dgfRenewLicense = null;
		List<DgfUsers> dgfUserList = null;
		try {
			dgfRenewLicense = DgfRenewLicenseLocalServiceUtil.getDgfRenewLicense(renewLicenseId);
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(dgfRenewLicense.getFglPrePrimaryId());
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
					dgfRenewLicense.getUserId(), dgfRenewLicense.getPrimaryKey());
			// get workflow task ID
			workflowTaskId = DgfoodWorkflowHandlerUtil.getWorkflowTaskIdByNode(nodeId, dgfFglPreDtls.getCompanyId(),
					workflowInstanceId);
		} catch (PortalException e1) {
			log.error("ERROR: " + e1.getMessage());
		}
		// send notification to ucf user
		String entryType = "model.resource.bd.gov.dgfood.food.grain.license.model.DgfRenewLicense";
		String notificationMessage = LicenseCommonConstant.RENEW_FOOD_GRAIN_LICENSE;
		if (Validator.isNotNull(dgfUserList) && dgfUserList.size() > 0) {
			for (DgfUsers dgfUser : dgfUserList) {
				DgfoodWorkflowHandlerUtil.preparedPayloadAndSendUserNotification(dgfUser.getUserId(),
						dgfFglPreDtls.getCompanyId(), dgfFglPreDtls.getGroupId(), entryType,
						dgfRenewLicense.getPrimaryKey(), DgfRenewLicense.class.getName(), workflowInstanceId,
						workflowTaskId, notificationMessage);
			}
		} else {
			log.error("DCF USER NOT FOUND THIS LOCATION");
		}
		log.info("DgfRenewLicenseLocalServiceImpl.getDcfUserIdByLocationAndSendNotificationByNodeId END");
	}
	
	public void sendCcdrApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfRenewLicenseLocalServiceImpl.sendCcdrApprovedSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfUsers dgfUsers = null;
		DgfRenewLicense dgfRenewLicense = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfRenewLicense = DgfRenewLicenseLocalServiceUtil.getDgfRenewLicense(classPk);
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(dgfRenewLicense.getFglPrePrimaryId());
			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(Long.toString(dgfFglPreDtls.getNationalId()));
			workflowInstanceId = DgfoodWorkflowHandlerUtil.getWorkflowInstanceIdByUserIdAndClassPK(
					dgfRenewLicense.getUserId(), dgfRenewLicense.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(
					workflowInstanceId, dgfFglPreDtls.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String licenseMessage = licenseMessageUtil.getLicenseCcdrApproveMessage();
		String message = licenseMessage+" #"+dgfRenewLicense.getApplicationNo()+" "+comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message, dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),Long.parseLong(dgfRenewLicense.getApplicationNo()));
		log.info("DgfRenewLicenseLocalServiceImpl.sendCcdrApprovedSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}

	public void sendCcdrRejectSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfRenewLicenseLocalServiceImpl.sendCcdrRejectSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfUsers dgfUsers = null;
		DgfRenewLicense dgfRenewLicense = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfRenewLicense = DgfRenewLicenseLocalServiceUtil.getDgfRenewLicense(classPk);
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(dgfRenewLicense.getFglPrePrimaryId());
			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(Long.toString(dgfFglPreDtls.getNationalId()));
			workflowInstanceId = DgfoodWorkflowHandlerUtil.getWorkflowInstanceIdByUserIdAndClassPK(
					dgfRenewLicense.getUserId(), dgfRenewLicense.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(
					workflowInstanceId, dgfFglPreDtls.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String licenseMessage = licenseMessageUtil.getLicenseCcdrRejectMessage();
		String message = licenseMessage+" #"+dgfRenewLicense.getApplicationNo()+" "+comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message, dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),Long.parseLong(dgfRenewLicense.getApplicationNo()));
		log.info("DgfRenewLicenseLocalServiceImpl.sendCcdrRejectSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}

	public void sendAcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfRenewLicenseLocalServiceImpl.sendAcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfUsers dgfUsers = null;
		DgfRenewLicense dgfRenewLicense = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfRenewLicense = DgfRenewLicenseLocalServiceUtil.getDgfRenewLicense(classPk);
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(dgfRenewLicense.getFglPrePrimaryId());
			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(Long.toString(dgfFglPreDtls.getNationalId()));
			workflowInstanceId = DgfoodWorkflowHandlerUtil.getWorkflowInstanceIdByUserIdAndClassPK(
					dgfRenewLicense.getUserId(), dgfRenewLicense.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(
					workflowInstanceId, dgfFglPreDtls.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String licenseMessage = licenseMessageUtil.getLicenseAcfApproveMessage();
		String message = licenseMessage+" #"+dgfRenewLicense.getApplicationNo()+" "+comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message, dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),Long.parseLong(dgfRenewLicense.getApplicationNo()));
		log.info("DgfRenewLicenseLocalServiceImpl.sendAcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}

	public void sendAcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfRenewLicenseLocalServiceImpl.sendAcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfUsers dgfUsers = null;
		DgfRenewLicense dgfRenewLicense = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfRenewLicense = DgfRenewLicenseLocalServiceUtil.getDgfRenewLicense(classPk);
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(dgfRenewLicense.getFglPrePrimaryId());
			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(Long.toString(dgfFglPreDtls.getNationalId()));
			workflowInstanceId = DgfoodWorkflowHandlerUtil.getWorkflowInstanceIdByUserIdAndClassPK(
					dgfRenewLicense.getUserId(), dgfRenewLicense.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(
					workflowInstanceId, dgfFglPreDtls.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String licenseMessage = licenseMessageUtil.getLicenseAcfRejectMessage();
		String message = licenseMessage+" #"+dgfRenewLicense.getApplicationNo()+" "+comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message, dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),Long.parseLong(dgfRenewLicense.getApplicationNo()));
		log.info("DgfRenewLicenseLocalServiceImpl.sendAcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}

	public void sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfRenewLicenseLocalServiceImpl.sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfUsers dgfUsers = null;
		DgfRenewLicense dgfRenewLicense = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfRenewLicense = DgfRenewLicenseLocalServiceUtil.getDgfRenewLicense(classPk);
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(dgfRenewLicense.getFglPrePrimaryId());
			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(Long.toString(dgfFglPreDtls.getNationalId()));
			workflowInstanceId = DgfoodWorkflowHandlerUtil.getWorkflowInstanceIdByUserIdAndClassPK(
					dgfRenewLicense.getUserId(), dgfRenewLicense.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(
					workflowInstanceId, dgfFglPreDtls.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String licenseMessage = licenseMessageUtil.getLicenseUcfApproveMessage();
		String message = licenseMessage+" #"+dgfRenewLicense.getApplicationNo()+" "+comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message, dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),Long.parseLong(dgfRenewLicense.getApplicationNo()));
		log.info("DgfRenewLicenseLocalServiceImpl.sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}

	public void sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfRenewLicenseLocalServiceImpl.sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfUsers dgfUsers = null;
		DgfRenewLicense dgfRenewLicense = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfRenewLicense = DgfRenewLicenseLocalServiceUtil.getDgfRenewLicense(classPk);
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(dgfRenewLicense.getFglPrePrimaryId());
			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(Long.toString(dgfFglPreDtls.getNationalId()));
			workflowInstanceId = DgfoodWorkflowHandlerUtil.getWorkflowInstanceIdByUserIdAndClassPK(
					dgfRenewLicense.getUserId(), dgfRenewLicense.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(
					workflowInstanceId, dgfFglPreDtls.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String licenseMessage = licenseMessageUtil.getLicenseUcfRejectMessage();
		String message = licenseMessage+" #"+dgfRenewLicense.getApplicationNo()+" "+comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message, dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),Long.parseLong(dgfRenewLicense.getApplicationNo()));
		log.info("DgfRenewLicenseLocalServiceImpl.sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}

	public void sendDcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfRenewLicenseLocalServiceImpl.sendDcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfUsers dgfUsers = null;
		DgfRenewLicense dgfRenewLicense = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfRenewLicense = DgfRenewLicenseLocalServiceUtil.getDgfRenewLicense(classPk);
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(dgfRenewLicense.getFglPrePrimaryId());
			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(Long.toString(dgfFglPreDtls.getNationalId()));
			workflowInstanceId = DgfoodWorkflowHandlerUtil.getWorkflowInstanceIdByUserIdAndClassPK(
					dgfRenewLicense.getUserId(), dgfRenewLicense.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(
					workflowInstanceId, dgfFglPreDtls.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String licenseMessage = licenseMessageUtil.getLicenseDcfApproveMessage();
		String message = licenseMessage+" #"+dgfRenewLicense.getApplicationNo()+" "+comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message, dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),Long.parseLong(dgfRenewLicense.getApplicationNo()));
		log.info("DgfRenewLicenseLocalServiceImpl.sendDcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}

	public void sendDcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfRenewLicenseLocalServiceImpl.sendDcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfUsers dgfUsers = null;
		DgfRenewLicense dgfRenewLicense = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfRenewLicense = DgfRenewLicenseLocalServiceUtil.getDgfRenewLicense(classPk);
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(dgfRenewLicense.getFglPrePrimaryId());
			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(Long.toString(dgfFglPreDtls.getNationalId()));
			workflowInstanceId = DgfoodWorkflowHandlerUtil.getWorkflowInstanceIdByUserIdAndClassPK(
					dgfRenewLicense.getUserId(), dgfRenewLicense.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(
					workflowInstanceId, dgfFglPreDtls.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String licenseMessage = licenseMessageUtil.getLicenseDcfRejectMessage();
		String message = licenseMessage+" #"+dgfRenewLicense.getApplicationNo()+" "+comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message, dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),Long.parseLong(dgfRenewLicense.getApplicationNo()));
		log.info("DgfRenewLicenseLocalServiceImpl.sendDcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}
	
	public void extendRenewLicenseExpiredDate(long classPk) {
		log.info("DgfRenewLicenseLocalServiceImpl.extendRenewLicenseExpiredDate START");
		DgfRenewLicense dgfRenewLicense = null;
		try {
			dgfRenewLicense = DgfRenewLicenseLocalServiceUtil.getDgfRenewLicense(classPk);
			//TODO update date in lic details table from approved date
			DgfFglLicDtls dgfFglLicDtls = DgfFglLicDtlsLocalServiceUtil.getDgfFglLicDtlsByFglPrePrimaryId(dgfRenewLicense.getFglPrePrimaryId());
			Date currentDate = new Date();
			// Create a calendar instance and set it to the current date
		    Calendar calendar = Calendar.getInstance();
		    calendar.setTime(currentDate);
		    // Add one year to the calendar instance
		    calendar.add(Calendar.YEAR, 1);
		    // Set the month and day to June 30
	        calendar.set(Calendar.MONTH, Calendar.JUNE);
	        calendar.set(Calendar.DAY_OF_MONTH, 30);
		    // Get the new date from the calendar instance
		    Date nextYearDate = calendar.getTime();
		    dgfFglLicDtls.setFoodgrainLicenseExpiryDate(nextYearDate);
		    DgfFglLicDtlsLocalServiceUtil.updateDgfFglLicDtls(dgfFglLicDtls);
		    
		}catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		log.info("DgfRenewLicenseLocalServiceImpl.extendRenewLicenseExpiredDate END");
	}

}