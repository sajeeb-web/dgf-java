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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowTask;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.dealer.registration.config.DealerMessageUtil;
import bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls;
import bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawal;
import bd.gov.dgfood.dealer.registration.service.DgfDlrRegDtlsLocalService;
import bd.gov.dgfood.dealer.registration.service.DgfDlrRegDtlsLocalServiceUtil;
import bd.gov.dgfood.dealer.registration.service.DgfDlrWithdrawalLocalServiceUtil;
import bd.gov.dgfood.dealer.registration.service.base.DgfDlrWithdrawalLocalServiceBaseImpl;
import bd.gov.dgfood.dealer.registration.util.DateMakerUtil;
import bd.gov.dgfood.dealer.registration.util.DealerCommonConstant;
import bd.gov.dgfood.dealer.registration.workflow.DgfoodDealerWorkflowHandlerUtil;
import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.model.dgfLocUnion;
import bd.gov.dgfood.food.grain.license.model.licnsUserRegs;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfUsersOtpDetailsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.dgfLocUnionLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.licnsUserRegsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.util.EntityResourcePermissionUtil;
import bd.gov.dgfood.food.grain.license.service.util.LicenseCommonConstant;
import bd.gov.dgfood.food.grain.license.service.util.PrincipalRoleAndLocationUtil;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawal", service = AopService.class)
public class DgfDlrWithdrawalLocalServiceImpl extends DgfDlrWithdrawalLocalServiceBaseImpl {

	private Log log = LogFactoryUtil.getLog(this.getClass().getName());
	
	@Reference
	private DealerMessageUtil dealerMessageUtil;

	@Reference
	DgfDlrRegDtlsLocalService _dgfDlrRegDtlsLocalService;
	
	public List<DgfDlrWithdrawal> getDgfDlrWithdrawalByNid(String nid) {
		return dgfDlrWithdrawalPersistence.findByDlrWithdrawalByNationalId(nid);
	}

	public List<DgfDlrWithdrawal> getDgfDlrWithdrawalbyNationId(String nationId) {
		try {
			return dgfDlrWithdrawalPersistence.findByDlrWithdrawalByNationalId(nationId);
		} catch (Exception e) {
			log.error("Get Dgf DlrWithdrawal Report data  by NationId not found " + e.getMessage());
		}
		return null;
	}

    public boolean userExists(String nationalId, String licenseNo) {
        // Create a DynamicQuery instance for DgfDlrWithdrawal
        DynamicQuery dynamicQuery = dynamicQuery()
                .add(PropertyFactoryUtil.forName("nationalId").eq(nationalId))
                .add(PropertyFactoryUtil.forName("licenseNo").eq(licenseNo));

        try {
            // Use dynamicQueryCount method from the base local service implementation
            long count = dynamicQueryCount(dynamicQuery);

            // If count is greater than 0, a record exists
            return count > 0;
        } catch (SystemException e) {
            e.printStackTrace();
            // If an exception occurs, return false
            return false;
        }
    }

	
	/** Method to submit  dealer @withdrawal form */
	public DgfDlrWithdrawal saveWithdrawalData(String nationalId, String licenseNo, String dealerName, String mobileNo,
			String reason, String programType) throws SystemException {
		/*
		 * if (nationalId == null || nationalId.equals("") || licenseNo == null ||
		 * licenseNo.equals("") || dealerName == null || dealerName.equals("") ||
		 * mobileNo == null || mobileNo.equals("") || reason == null ||
		 * reason.equals("") || programType == null || programType.equals("")) {
		 * throw new
		 * IllegalArgumentException("Dealer withdrawal data cannot be  null or empty");
		 * }
		 */
		
		DgfDlrRegDtls dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtlsByNid(nationalId);
		
		long withdrawalId = counterLocalService.increment();
		DgfDlrWithdrawal addDlrWithdrawal = createDgfDlrWithdrawal(withdrawalId);

		addDlrWithdrawal.setNationalId(nationalId);
		addDlrWithdrawal.setLicenseNo(licenseNo);
		addDlrWithdrawal.setDealerName(dealerName);
		addDlrWithdrawal.setMobileNo(mobileNo);
		addDlrWithdrawal.setReason(reason);
		addDlrWithdrawal.setProgramType(programType);
		addDlrWithdrawal.setCreatedDate(new Date());
		addDlrWithdrawal.setCompanyId(dgfDlrRegDtls.getCompanyId());
		addDlrWithdrawal.setUserId(dgfDlrRegDtls.getUserId());
		addDlrWithdrawal.setGroupId(dgfDlrRegDtls.getGroupId());
		addDlrWithdrawal.setDlrRegNo(dgfDlrRegDtls.getDlrRegNo());
		addDlrWithdrawal.setOmsSubType(dgfDlrRegDtls.getDlrOmsSubType());
		addDlrWithdrawal.setRegApplNo(dgfDlrRegDtls.getDlrRegApplNo());

		addDlrWithdrawal = super.addDgfDlrWithdrawal(addDlrWithdrawal);

		System.out.println("programType===="+programType);
		if(LicenseCommonConstant.OMS.equals(programType)) {
			programType = dgfDlrRegDtls.getDlrOmsSubType();
		}
		
		String rolename = PrincipalRoleAndLocationUtil.getRoleByType(programType);
		String locationWithPrefix = getLocationWithPrefixByRole(dgfDlrRegDtls, rolename);
		System.out.println("locationWithPrefix======"+locationWithPrefix);
		//added resource permission
		EntityResourcePermissionUtil.addEntityPermission(DgfDlrWithdrawal.class.getName(), addDlrWithdrawal.getDlrWithdrawalId(), programType, nationalId, dgfDlrRegDtls.getCompanyId(), locationWithPrefix);
		
		return addDlrWithdrawal;
	}
	
	
	
	public List<Map<String, Object>> getDlrWithdrawalListSearchResult(String dateFrom, String dateTo, String dateType,
			String nid, long union, String dealerType, int status) {
		Date dateF = DateMakerUtil.dateMaker(dateFrom);
		Date dateT = DateMakerUtil.dateMaker(dateTo);

		try {
			ClassLoader classLoader = getClass().getClassLoader();
			DynamicQuery searchQuery = DynamicQueryFactoryUtil.forClass(DgfDlrWithdrawal.class, classLoader);

			Junction conjunction = RestrictionsFactoryUtil.conjunction();

			if (dateF != null) {
				if (dateType != null && dateType.equals("statusDate")) {

					conjunction.add(PropertyFactoryUtil.forName("modifiedDate").ge(dateF));

				} else {
					conjunction.add(PropertyFactoryUtil.forName("createdDate").ge(dateF));

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
				if (dateType != null && dateType.equals("statusDate")) {

					conjunction.add(PropertyFactoryUtil.forName("modifiedDate").le(endOfDay));

				} else {

					conjunction.add(PropertyFactoryUtil.forName("createdDate").le(endOfDay));

				}

			}

			if (Validator.isNotNull(nid) && !nid.trim().isEmpty()) {
				/* status = (status != -2) ? status : -2; */
				status = -2;
				conjunction.add(PropertyFactoryUtil.forName("nationalId").eq(nid));

			}

			if (status != -2) {
				conjunction.add(PropertyFactoryUtil.forName("status").eq(status));

			}

			if (Validator.isNotNull(dealerType) && !dealerType.trim().isEmpty()) {
				conjunction.add(PropertyFactoryUtil.forName("programType").eq(dealerType));
			}

			searchQuery.add(conjunction);

			List<DgfDlrWithdrawal> dgfDlrWithdrawalDltsObj = new ArrayList<DgfDlrWithdrawal>();
			dgfDlrWithdrawalDltsObj = dgfDlrWithdrawalLocalService.dynamicQuery(searchQuery);

			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
			SimpleDateFormat newFormat = new SimpleDateFormat("dd-MM-yyyy");

			for (DgfDlrWithdrawal item : dgfDlrWithdrawalDltsObj) {
				Map<String, Object> map = new HashMap<String, Object>();

				DgfDlrRegDtls dgfDlrRegDtlsObj = null;
				licnsUserRegs userRegsObj = null;
				dgfLocUnion unionObj = null;

				String nidNo = item.getNationalId();

				if (nidNo != null) {
					dgfDlrRegDtlsObj = (DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtlsByNid(nidNo) != null)
							? dgfDlrRegDtlsObj = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtlsByNid(nid)
							: dgfDlrRegDtlsObj;
				}

				if (nidNo.toString() != null) {
					userRegsObj = (licnsUserRegsLocalServiceUtil.getlicnsUserByNid(nidNo.toString()) != null)
							? userRegsObj = licnsUserRegsLocalServiceUtil.getlicnsUserByNid(nidNo.toString())
							: userRegsObj;

					unionObj = (userRegsObj.getBusinessUnionName() != 0)
							? dgfLocUnionLocalServiceUtil.getdgfLocUnion(userRegsObj.getBusinessUnionName())
							: unionObj;
				}

				map.put("dealerBussinessCode", dgfDlrRegDtlsObj.getSapBuCode());
				map.put("unionName", unionObj.getBnName());
				map.put("dealerUnion", dgfDlrRegDtlsObj.getUnionName());
				map.put("withdrawReason", item.getReason());
				map.put("dealerName", item.getDealerName());
				map.put("mobileNo", item.getMobileNo());
				map.put("createdDate", newFormat.format(item.getCreatedDate()));
				map.put("modifyDate", newFormat.format(item.getModifiedDate()));
				map.put("licenseNo", item.getLicenseNo());
				map.put("mobileNo", item.getMobileNo());
				map.put("nid", item.getNationalId());
				map.put("program", item.getProgramType());
				map.put("status", item.getStatus());
				map.put("dgfDlrRegDltsPrimaryId", item.getDlrWithdrawalId());
				map.put("withdrawaId", item.getDlrWithdrawalId());
				
				
				dataList.add(map);
			}

			return dataList;
		} catch (Exception e) {
			log.debug("Dealer Application Search Error======" + e.getMessage());
		}
		return null;
	}

	public Map<String, Object> getDgfDlrWithdrawalDltsData(long dlrWithdrawalId) {
	    DgfDlrWithdrawal dgfDlrWithdrwalDltsObj = null;
	    Map<String, Object> dataMap = new HashMap<String, Object>();
	    SimpleDateFormat newFormat = new SimpleDateFormat("dd-MM-yyyy");

	    try {
	        // Fetch the DgfDlrWithdrawal object using dlrWithdrawalId
	        dgfDlrWithdrwalDltsObj = dgfDlrWithdrawalLocalService.getDgfDlrWithdrawal(dlrWithdrawalId);

	        // Get the nationalId from the DgfDlrWithdrawal object
	        String nidNo = dgfDlrWithdrwalDltsObj.getNationalId();

	        DgfDlrRegDtls dgfDlrRegDtlsObj = null;
	        licnsUserRegs userRegsObj = null;
	        dgfLocUnion unionObj = null;

			if (nidNo.toString() != null) {
				dgfDlrRegDtlsObj = (DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtlsByNid(nidNo.toString()) != null)
						? dgfDlrRegDtlsObj = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtlsByNid(nidNo.toString())
						: dgfDlrRegDtlsObj;
			}

			if (nidNo.toString() != null) {
				userRegsObj = (licnsUserRegsLocalServiceUtil.getlicnsUserByNid(nidNo.toString()) != null)
						? userRegsObj = licnsUserRegsLocalServiceUtil.getlicnsUserByNid(nidNo.toString())
						: userRegsObj;

				unionObj = (userRegsObj.getBusinessUnionName() != 0)
						? dgfLocUnionLocalServiceUtil.getdgfLocUnion(userRegsObj.getBusinessUnionName())
						: unionObj;
			}

			dataMap.put("dealerBussinessCode", dgfDlrRegDtlsObj.getSapBuCode());
			dataMap.put("unionName", unionObj.getBnName());
			dataMap.put("dealerUnion", dgfDlrRegDtlsObj.getUnionName());
			dataMap.put("withdrawalId", dgfDlrWithdrwalDltsObj.getDlrWithdrawalId());
			dataMap.put("IssueDate", newFormat.format(dgfDlrWithdrwalDltsObj.getCreatedDate()));
			dataMap.put("nationalId", dgfDlrWithdrwalDltsObj.getNationalId());
			dataMap.put("withdrawReason", dgfDlrWithdrwalDltsObj.getReason());
			dataMap.put("dealerName", dgfDlrWithdrwalDltsObj.getDealerName());
			dataMap.put("mobileNo", dgfDlrWithdrwalDltsObj.getMobileNo());
			dataMap.put("createdDate", newFormat.format(dgfDlrWithdrwalDltsObj.getCreatedDate()));
			dataMap.put("modifyDate", newFormat.format(dgfDlrWithdrwalDltsObj.getModifiedDate()));
			dataMap.put("licenseNo", dgfDlrWithdrwalDltsObj.getLicenseNo());
			dataMap.put("mobileNo", dgfDlrWithdrwalDltsObj.getMobileNo());
			dataMap.put("program", dgfDlrWithdrwalDltsObj.getProgramType());
			dataMap.put("status", dgfDlrWithdrwalDltsObj.getStatus());
			dataMap.put("withdrawaId", dgfDlrWithdrwalDltsObj.getDlrWithdrawalId());
			
			return dataMap;

		} catch (Exception e) {
			log.error("dgf Dlr WithdrwalDlts Obj not Found for Detail Data====== " + e.getMessage());
		}

		return dataMap;

	}
	
	/////////// START WORKFLOW //////////////////
	
	public DgfDlrWithdrawal updateStatus(long userId, long resourcePrimKey, int status, ServiceContext serviceContext)
			throws PortalException {
		User user = userLocalService.getUser(userId);
		DgfDlrWithdrawal dgfDlrWithdrawal = getDgfDlrWithdrawal(resourcePrimKey);
		dgfDlrWithdrawal.setStatus(status);
		dgfDlrWithdrawal.setStatusByUserId(userId);
		dgfDlrWithdrawal.setStatusByUserName(user.getFullName());
		dgfDlrWithdrawal.setStatusDate(new Date());
		dgfDlrWithdrawalPersistence.update(dgfDlrWithdrawal);
		return dgfDlrWithdrawal;
	}
	
	public boolean checkDcfUsersExistByLocation(long classPK) {
		log.info("DgfDlrWithdrawalLocalServiceImpl.checkDcfUsersExistByLocation START");
		DgfDlrWithdrawal dgfDlrWithdrawal = null;
		DgfDlrRegDtls dgfDlrRegDtls = null;
		List<DgfUsers> dgfUserList = null;
		boolean isExistAcfUser = false;
		try {
			dgfDlrWithdrawal = DgfDlrWithdrawalLocalServiceUtil.getDgfDlrWithdrawal(classPK);
			dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtls(dgfDlrWithdrawal.getDlrRegNo());
			dgfUserList = DgfUsersLocalServiceUtil.getDgfDcfUsersByDistrict(dgfDlrRegDtls.getDistrict(),
					dgfDlrRegDtls.getCompanyId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("ERROR: " + e.getMessage());
		}
		if (Validator.isNotNull(dgfUserList) && dgfUserList.size() > 0) {
			isExistAcfUser = true;
		}
		log.info("DgfDlrWithdrawalLocalServiceImpl.checkDcfUsersExistByLocation END");
		return isExistAcfUser;
	}

	public boolean checkUcfUsersExistByLocation(long classPK) {
		log.info("DgfDlrWithdrawalLocalServiceImpl.checkUcfUsersExistByLocation START");
		DgfDlrWithdrawal dgfDlrWithdrawal = null;
		DgfDlrRegDtls dgfDlrRegDtls = null;
		List<DgfUsers> dgfUserList = null;
		boolean isExistAcfUser = false;
		try {
			dgfDlrWithdrawal = DgfDlrWithdrawalLocalServiceUtil.getDgfDlrWithdrawal(classPK);
			dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtls(dgfDlrWithdrawal.getDlrRegNo());
			dgfUserList = DgfUsersLocalServiceUtil.getDgfUcfUsersByDistrict(dgfDlrRegDtls.getUpzilla(),
					dgfDlrRegDtls.getCompanyId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("ERROR: " + e.getMessage());
		}
		if (Validator.isNotNull(dgfUserList) && dgfUserList.size() > 0) {
			isExistAcfUser = true;
		}
		log.info("DgfDlrWithdrawalLocalServiceImpl.checkUcfUsersExistByLocation END");
		return isExistAcfUser;
	}

	public boolean checkCcdrUsersExistByLocation(long classPK) {
		log.info("DgfDlrWithdrawalLocalServiceImpl.checkCcdrUsersExistByLocation START");
		DgfDlrWithdrawal dgfDlrWithdrawal = null;
		DgfDlrRegDtls dgfDlrRegDtls = null;
		List<DgfUsers> dgfUserList = null;
		boolean isExistAcfUser = false;
		try {
			dgfDlrWithdrawal = DgfDlrWithdrawalLocalServiceUtil.getDgfDlrWithdrawal(classPK);
			dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtls(dgfDlrWithdrawal.getDlrRegNo());
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
		log.info("DgfDlrWithdrawalLocalServiceImpl.checkCcdrUsersExistByLocation END");
		return isExistAcfUser;
	}

	public boolean checkRcfUsersExistByLocation(long classPK) {
		log.info("DgfDlrWithdrawalLocalServiceImpl.checkRcfUsersExistByLocation START");
		DgfDlrWithdrawal dgfDlrWithdrawal = null;
		DgfDlrRegDtls dgfDlrRegDtls = null;
		List<DgfUsers> dgfUserList = null;
		boolean isExistAcfUser = false;
		try {
			dgfDlrWithdrawal = DgfDlrWithdrawalLocalServiceUtil.getDgfDlrWithdrawal(classPK);
			dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtls(dgfDlrWithdrawal.getDlrRegNo());
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
		log.info("DgfDlrWithdrawalLocalServiceImpl.checkRcfUsersExistByLocation END");
		return isExistAcfUser;
	}
	
	private void getWorkflowTaskAndSendNotification(DgfDlrWithdrawal dgfDlrWithdrawal, List<DgfUsers> dgfUserList) {
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		long workflowTaskId = 0;
		WorkflowTask workflowTask = null;
		try {
			workflowInstanceId = DgfoodDealerWorkflowHandlerUtil
					.getWorkflowInstanceIdByUserIdAndClassPK(dgfDlrWithdrawal.getUserId(), dgfDlrWithdrawal.getPrimaryKey());
			// get the asset's workflow task
			workflowTask = DgfoodDealerWorkflowHandlerUtil
					.getWorkflowTaskByCompanyIdAndWorkflowInstanceId(dgfDlrWithdrawal.getCompanyId(), workflowInstanceId);
			workflowTaskId = workflowTask.getWorkflowTaskId();
		} catch (PortalException e1) {
			log.error("ERROR: " + e1.getMessage());
		}
		// send notification to acf user
		String entryType = "model.resource.bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawal";
		String notificationMessage = DealerCommonConstant.DEALER_WITHDRAWAL_PROGRAM;
		if (Validator.isNotNull(dgfUserList) && dgfUserList.size() > 0) {
			for (DgfUsers dgfUser : dgfUserList) {
				DgfoodDealerWorkflowHandlerUtil.preparedPayloadAndSendUserNotification(dgfUser.getUserId(),
						dgfDlrWithdrawal.getCompanyId(), dgfDlrWithdrawal.getGroupId(), entryType,
						dgfDlrWithdrawal.getPrimaryKey(), DgfDlrWithdrawal.class.getName(), workflowInstanceId,
						workflowTaskId, notificationMessage);
			}
		} else {
			log.info("USER NOT FOUND THIS LOCATION");
		}
	}

	public void setDealerRcfUserNotificationEvent(long classPK) {
		log.info("DgfDlrWithdrawalLocalServiceImpl.setDealerRcfUserNotificationEvent START");
		DgfDlrWithdrawal dgfDlrWithdrawal = null;
		List<DgfUsers> dgfUserList = null;
		DgfDlrRegDtls dgfDlrRegDtls = null;
		try {
			dgfDlrWithdrawal = DgfDlrWithdrawalLocalServiceUtil.getDgfDlrWithdrawal(classPK);
			dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtls(dgfDlrWithdrawal.getDlrRegNo());
			dgfUserList = DgfUsersLocalServiceUtil.getDgfRcfUsersByUpazila(dgfDlrRegDtls.getUpzilla(),
					dgfDlrRegDtls.getCompanyId());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			log.error("ERROR: " + e.getMessage());
		}
		getWorkflowTaskAndSendNotification(dgfDlrWithdrawal, dgfUserList);
		log.info("DgfDlrWithdrawalLocalServiceImpl.setDealerRcfUserNotificationEvent END");
	}

	

	public void setDealerCcdrUserNotificationEvent(long classPK) {
		log.info("DgfDlrWithdrawalLocalServiceImpl.setDealerCcdrUserNotificationEvent START");
		DgfDlrWithdrawal dgfDlrWithdrawal = null;
		List<DgfUsers> dgfUserList = null;
		DgfDlrRegDtls dgfDlrRegDtls = null;
		try {
			dgfDlrWithdrawal = DgfDlrWithdrawalLocalServiceUtil.getDgfDlrWithdrawal(classPK);
			dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtls(dgfDlrWithdrawal.getDlrRegNo());
			dgfUserList = DgfUsersLocalServiceUtil.getDgfCcdrUsersByUpazila(dgfDlrRegDtls.getUpzilla(),
					dgfDlrRegDtls.getCompanyId());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			log.error("ERROR: " + e.getMessage());
		}
		getWorkflowTaskAndSendNotification(dgfDlrWithdrawal, dgfUserList);
		log.info("DgfDlrWithdrawalLocalServiceImpl.setDealerCcdrUserNotificationEvent END");
	}

	public void setDealerUcfUserNotificationEvent(long classPK) {
		log.info("DgfDlrWithdrawalLocalServiceImpl.setDealerUcfUserNotificationEvent START");
		DgfDlrWithdrawal dgfDlrWithdrawal = null;
		List<DgfUsers> dgfUserList = null;
		DgfDlrRegDtls dgfDlrRegDtls = null;
		try {
			dgfDlrWithdrawal = DgfDlrWithdrawalLocalServiceUtil.getDgfDlrWithdrawal(classPK);
			dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtls(dgfDlrWithdrawal.getDlrRegNo());
			dgfUserList = DgfUsersLocalServiceUtil.getDgfUcfUsersByDistrict(dgfDlrRegDtls.getUpzilla(),
					dgfDlrRegDtls.getCompanyId());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			log.error("ERROR: " + e.getMessage());
		}
		getWorkflowTaskAndSendNotification(dgfDlrWithdrawal, dgfUserList);
		log.info("DgfDlrWithdrawalLocalServiceImpl.setDealerUcfUserNotificationEvent END");
	}

	public void setDealerDcfUserNotificationEvent(long classPK) {
		log.info("DgfDlrWithdrawalLocalServiceImpl.setDealerDcfUserNotificationEvent START");
		DgfDlrWithdrawal dgfDlrWithdrawal = null;
		List<DgfUsers> dgfUserList = null;
		DgfDlrRegDtls dgfDlrRegDtls = null;
		try {
			dgfDlrWithdrawal = DgfDlrWithdrawalLocalServiceUtil.getDgfDlrWithdrawal(classPK);
			dgfDlrRegDtls = DgfDlrRegDtlsLocalServiceUtil.getDgfDlrRegDtls(dgfDlrWithdrawal.getDlrRegNo());
			dgfUserList = DgfUsersLocalServiceUtil.getDgfDcfUsersByDistrict(dgfDlrRegDtls.getDistrict(),
					dgfDlrRegDtls.getCompanyId());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getWorkflowTaskAndSendNotification(dgfDlrWithdrawal, dgfUserList);
		log.info("DgfDlrWithdrawalLocalServiceImpl.setDealerDcfUserNotificationEvent END");
	}

	public void sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfDlrWithdrawalLocalServiceImpl.sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfDlrWithdrawal dgfDlrWithdrawal = null;
		DgfUsers dgfUsers = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfDlrWithdrawal = DgfDlrWithdrawalLocalServiceUtil.getDgfDlrWithdrawal(classPk);

			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(dgfDlrWithdrawal.getNationalId());
			workflowInstanceId = DgfoodDealerWorkflowHandlerUtil
					.getWorkflowInstanceIdByUserIdAndClassPK(dgfDlrWithdrawal.getUserId(), dgfDlrWithdrawal.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodDealerWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByWorkflowInstanceIdAndNodeId(
					workflowInstanceId, dgfDlrWithdrawal.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String dealerMessage = dealerMessageUtil.getDealerUcfApproveMessage();
		String message = dealerMessage + " #" + dgfDlrWithdrawal.getRegApplNo() + " " + comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message,
				dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),
				dgfDlrWithdrawal.getRegApplNo());
		log.info("DgfDlrWithdrawalLocalServiceImpl.sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}

	public void sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfDlrWithdrawalLocalServiceImpl.sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfUsers dgfUsers = null;
		DgfDlrWithdrawal dgfDlrWithdrawal = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfDlrWithdrawal = DgfDlrWithdrawalLocalServiceUtil.getDgfDlrWithdrawal(classPk);

			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(dgfDlrWithdrawal.getNationalId());
			workflowInstanceId = DgfoodDealerWorkflowHandlerUtil
					.getWorkflowInstanceIdByUserIdAndClassPK(dgfDlrWithdrawal.getUserId(), dgfDlrWithdrawal.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodDealerWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByWorkflowInstanceIdAndNodeId(
					workflowInstanceId, dgfDlrWithdrawal.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String dealerMessage = dealerMessageUtil.getDealerUcfRejectMessage();
		String message = dealerMessage + " #" + dgfDlrWithdrawal.getRegApplNo() + " " + comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message,
				dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),
				dgfDlrWithdrawal.getRegApplNo());
		log.info("DgfDlrWithdrawalLocalServiceImpl.sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}

	public void sendDcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfDlrWithdrawalLocalServiceImpl.sendDcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfUsers dgfUsers = null;
		DgfDlrWithdrawal dgfDlrWithdrawal = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfDlrWithdrawal = DgfDlrWithdrawalLocalServiceUtil.getDgfDlrWithdrawal(classPk);

			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(dgfDlrWithdrawal.getNationalId());
			workflowInstanceId = DgfoodDealerWorkflowHandlerUtil
					.getWorkflowInstanceIdByUserIdAndClassPK(dgfDlrWithdrawal.getUserId(), dgfDlrWithdrawal.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodDealerWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByWorkflowInstanceIdAndNodeId(
					workflowInstanceId, dgfDlrWithdrawal.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String dealerMessage = dealerMessageUtil.getDealerDcfApproveMessage();
		String message = dealerMessage + " #" + dgfDlrWithdrawal.getRegApplNo() + " " + comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message,
				dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),
				dgfDlrWithdrawal.getRegApplNo());
		log.info("DgfDlrWithdrawalLocalServiceImpl.sendDcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}

	public void sendDcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfDlrWithdrawalLocalServiceImpl.sendDcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfUsers dgfUsers = null;
		DgfDlrWithdrawal dgfDlrWithdrawal = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfDlrWithdrawal = DgfDlrWithdrawalLocalServiceUtil.getDgfDlrWithdrawal(classPk);

			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(dgfDlrWithdrawal.getNationalId());
			workflowInstanceId = DgfoodDealerWorkflowHandlerUtil
					.getWorkflowInstanceIdByUserIdAndClassPK(dgfDlrWithdrawal.getUserId(), dgfDlrWithdrawal.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodDealerWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByWorkflowInstanceIdAndNodeId(
					workflowInstanceId, dgfDlrWithdrawal.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String dealerMessage = dealerMessageUtil.getDealerDcfRejectMessage();
		String message = dealerMessage + " #" + dgfDlrWithdrawal.getRegApplNo() + " " + comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message,
				dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),
				dgfDlrWithdrawal.getRegApplNo());
		log.info("DgfDlrWithdrawalLocalServiceImpl.sendDcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}

	public void sendRcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfDlrWithdrawalLocalServiceImpl.sendRcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfUsers dgfUsers = null;
		DgfDlrWithdrawal dgfDlrWithdrawal = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfDlrWithdrawal = DgfDlrWithdrawalLocalServiceUtil.getDgfDlrWithdrawal(classPk);

			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(dgfDlrWithdrawal.getNationalId());
			workflowInstanceId = DgfoodDealerWorkflowHandlerUtil
					.getWorkflowInstanceIdByUserIdAndClassPK(dgfDlrWithdrawal.getUserId(), dgfDlrWithdrawal.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodDealerWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByWorkflowInstanceIdAndNodeId(
					workflowInstanceId, dgfDlrWithdrawal.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String dealerMessage = dealerMessageUtil.getDealerRcfApproveMessage();
		String message = dealerMessage + " #" + dgfDlrWithdrawal.getRegApplNo() + " " + comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message,
				dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),
				dgfDlrWithdrawal.getRegApplNo());
		log.info("DgfDlrWithdrawalLocalServiceImpl.sendRcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}

	public void sendRcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfDlrWithdrawalLocalServiceImpl.sendRcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfUsers dgfUsers = null;
		DgfDlrWithdrawal dgfDlrWithdrawal = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfDlrWithdrawal = DgfDlrWithdrawalLocalServiceUtil.getDgfDlrWithdrawal(classPk);

			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(dgfDlrWithdrawal.getNationalId());
			workflowInstanceId = DgfoodDealerWorkflowHandlerUtil
					.getWorkflowInstanceIdByUserIdAndClassPK(dgfDlrWithdrawal.getUserId(), dgfDlrWithdrawal.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodDealerWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByWorkflowInstanceIdAndNodeId(
					workflowInstanceId, dgfDlrWithdrawal.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String dealerMessage = dealerMessageUtil.getDealerRcfRejectMessage();
		String message = dealerMessage + " #" + dgfDlrWithdrawal.getRegApplNo() + " " + comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message,
				dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),
				dgfDlrWithdrawal.getRegApplNo());
		log.info("DgfDlrWithdrawalLocalServiceImpl.sendRcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}

	public void sendCcdrApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfDlrWithdrawalLocalServiceImpl.sendCcdrApprovedSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfUsers dgfUsers = null;
		DgfDlrWithdrawal dgfDlrWithdrawal = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfDlrWithdrawal = DgfDlrWithdrawalLocalServiceUtil.getDgfDlrWithdrawal(classPk);

			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(dgfDlrWithdrawal.getNationalId());
			workflowInstanceId = DgfoodDealerWorkflowHandlerUtil
					.getWorkflowInstanceIdByUserIdAndClassPK(dgfDlrWithdrawal.getUserId(), dgfDlrWithdrawal.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodDealerWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByWorkflowInstanceIdAndNodeId(
					workflowInstanceId, dgfDlrWithdrawal.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String dealerMessage = dealerMessageUtil.getDealerCcdrApproveMessage();
		String message = dealerMessage + " #" + dgfDlrWithdrawal.getRegApplNo() + " " + comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message,
				dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),
				dgfDlrWithdrawal.getRegApplNo());
		log.info("DgfDlrWithdrawalLocalServiceImpl.sendCcdrApprovedSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}

	public void sendCcdrRejectSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfDlrWithdrawalLocalServiceImpl.sendCcdrRejectSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfUsers dgfUsers = null;
		DgfDlrWithdrawal dgfDlrWithdrawal = null;
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		String comments = "";
		try {
			dgfDlrWithdrawal = DgfDlrWithdrawalLocalServiceUtil.getDgfDlrWithdrawal(classPk);

			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(dgfDlrWithdrawal.getNationalId());
			workflowInstanceId = DgfoodDealerWorkflowHandlerUtil
					.getWorkflowInstanceIdByUserIdAndClassPK(dgfDlrWithdrawal.getUserId(), dgfDlrWithdrawal.getPrimaryKey());
			// Get workflow task comments
			comments = DgfoodDealerWorkflowHandlerUtil.getWorkflowCurrentTaskCommentsByWorkflowInstanceIdAndNodeId(
					workflowInstanceId, dgfDlrWithdrawal.getCompanyId(), nodeId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// send user sms notification with comments
		String dealerMessage = dealerMessageUtil.getDealerCcdrRejectMessage();
		String message = dealerMessage + " #" + dgfDlrWithdrawal.getRegApplNo() + " " + comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message,
				dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),
				dgfDlrWithdrawal.getRegApplNo());
		log.info("DgfDlrWithdrawalLocalServiceImpl.sendCcdrRejectSmsWithWorkflowCommentsByClassPkAndNodeId END");

	}

	/////////// END WORKFLOW //////////////////
	
	public List<Map<String, Object>> findBySearchCriteria(String dateFrom, String dateTo,
			String nid, long union, String dealerType, int status) {
		return dgfDlrWithdrawalFinder.findBySearchCriteria(dateFrom, dateTo, nid, union, dealerType, status);
	}

	private String getLocationWithPrefixByRole(DgfDlrRegDtls dgfDlrRegDtls, String role) {
		String locationPrefix = "";
		switch (role) {
		case LicenseCommonConstant.ROLE_UCF:
			locationPrefix = LicenseCommonConstant.UPAZILLA_FIRST_LETTER+dgfDlrRegDtls.getUpzilla();
			break;
		case LicenseCommonConstant.ROLE_CCDR:
			locationPrefix = LicenseCommonConstant.DHAKA_METRO_TWO_LETTER+dgfDlrRegDtls.getUpzilla();
			break;
		case LicenseCommonConstant.ROLE_RCF:
			locationPrefix = LicenseCommonConstant.OTHER_METRO_TWO_LETTER+dgfDlrRegDtls.getUpzilla();
			break;
		default:
			locationPrefix = LicenseCommonConstant.DISTRICT_FIRST_LETTER+dgfDlrRegDtls.getDistrict();
		}
		return locationPrefix;
	}

}
