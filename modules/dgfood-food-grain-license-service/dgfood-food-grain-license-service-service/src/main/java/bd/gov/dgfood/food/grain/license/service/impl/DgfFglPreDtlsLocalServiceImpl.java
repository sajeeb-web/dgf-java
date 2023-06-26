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

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.model.WorkflowInstanceLink;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.kernel.workflow.WorkflowLog;
import com.liferay.portal.kernel.workflow.WorkflowLogManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.kernel.workflow.comparator.WorkflowComparatorFactoryUtil;
import com.liferay.portal.workflow.kaleo.model.KaleoLog;
import com.liferay.portal.workflow.kaleo.service.KaleoLogLocalServiceUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import bd.gov.dgfood.food.grain.license.config.LicenseMessageUtil;
import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfFglLicDtlsException;
import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfFglPreDtlsException;
import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfUsersException;
import bd.gov.dgfood.food.grain.license.model.DgfAttachments;
import bd.gov.dgfood.food.grain.license.model.DgfBussAddrDtls;
import bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason;
import bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls;
import bd.gov.dgfood.food.grain.license.model.DgfFglLicenseNo;
import bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls;
import bd.gov.dgfood.food.grain.license.model.DgfRenewLicense;
import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls;
import bd.gov.dgfood.food.grain.license.model.DgfUsersDtls;
import bd.gov.dgfood.food.grain.license.model.licnsUserRegs;
import bd.gov.dgfood.food.grain.license.service.DgfAttachmentsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfBussAddrDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfDuplctLicnsReasonLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfFglLicDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfFglLicenseNoLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfFglPreDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfRenewLicenseLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfUsersAddrDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfUsersDtlsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfUsersLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.DgfUsersOtpDetailsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.licnsUserRegsLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.base.DgfFglPreDtlsLocalServiceBaseImpl;
import bd.gov.dgfood.food.grain.license.service.util.LicenseCommonConstant;
import bd.gov.dgfood.food.grain.license.util.GenerateLicenseReportUtil;
import bd.gov.dgfood.food.grain.workflow.DgfoodWorkflowHandlerUtil;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls", service = AopService.class)
public class DgfFglPreDtlsLocalServiceImpl extends DgfFglPreDtlsLocalServiceBaseImpl {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@Reference
	private GenerateLicenseReportUtil generateLicenseReportUtil;
	@Reference
	private LicenseMessageUtil licenseMessageUtil;

	public List<Map<String, Object>> getSearchResultByDateFrom(String dateFrom, String dateTo, String dateType,
			String applicationNo, String businessType, int status, String licenseType, long roleId, String upazillaOrDistrict,
			long companyId) {
		return dgfFglPreDtlsFinder.findBySearchCriteria(dateFrom, dateTo, dateType, applicationNo, businessType, status, licenseType,
				roleId, upazillaOrDistrict, companyId);
	}

	public DgfFglPreDtls getdgfFglPreDtls(long nidId) throws NoSuchDgfFglPreDtlsException {
		return dgfFglPreDtlsPersistence.findByDgfFglPreDtlsByNID(nidId);
	}

	public DgfFglPreDtls getdgfFglPreDtls(String fglApplicationNo) throws NoSuchDgfFglPreDtlsException {
		return dgfFglPreDtlsPersistence.findBydgfFglPreDtlsByFglApplicationNo(fglApplicationNo);
	}

	public DgfFglPreDtls getDgfFglPreDtlsByNID(long nationalId) throws NoSuchDgfFglPreDtlsException {
		return dgfFglPreDtlsPersistence.findByDgfFglPreDtlsByNID(nationalId);
	}

	public DgfFglPreDtls updateStatus(long userId, long resourcePrimKey, int status, ServiceContext serviceContext)
			throws PortalException {
		User user = userLocalService.getUser(userId);
		DgfFglPreDtls dgfFglPreDtls = getDgfFglPreDtls(resourcePrimKey);

		dgfFglPreDtls.setStatus(status);
		dgfFglPreDtls.setStatusByUserId(userId);
		dgfFglPreDtls.setStatusByUserName(user.getFullName());
		dgfFglPreDtls.setStatusDate(new Date());

		dgfFglPreDtlsPersistence.update(dgfFglPreDtls);

		/*
		 * if (status == WorkflowConstants.STATUS_APPROVED) {
		 * assetEntryLocalService.updateVisible( Guestbook.class.getName(),
		 * resourcePrimKey, true); } else { assetEntryLocalService.updateVisible(
		 * Guestbook.class.getName(), resourcePrimKey, false); }
		 */

		return dgfFglPreDtls;

	}

	public Map<String, Object> getDetailsData(long fglPrePrimaryId, long renewLicenseId,
			long duplicateLicenseReasonId) {

		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat newFormat = new SimpleDateFormat("dd-MM-yyyy");

		try {
			DgfFglPreDtls dgfFglPreDtlsObj = null;
			DgfRenewLicense dgfRenewLicenseObj = null;
			DgfDuplctLicnsReason dgfDuplctLicnsReasonObj = null;
			DgfFglLicDtls dgfFglLicDtlsObj = null;
			DgfUsers dgfUsersObj = null;
			DgfUsersDtls dgfUsersDtlsObj = null;
			licnsUserRegs licnsUserRegsObj = null;
			DgfAttachments photographFileObj = null;
			DgfAttachments tradeLicenseFileObj = null;
			DgfAttachments binFileObj = null;
			DgfAttachments tinObj = null;
			DgfAttachments bankStatementObj = null;
			DgfAttachments paymentChallanObj = null;
			DgfAttachments electricExemptionMemoObj = null;
			DgfAttachments envClrMemoObj = null;
			DgfAttachments bstiClrMemoObj = null;
			DgfAttachments fireLicNumDocObj = null;
			DgfAttachments otherReleventDocObj = null;
			Map<String, String> allAddress = null;
			dgfFglPreDtlsObj = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(fglPrePrimaryId);
			if (renewLicenseId > 0) {
				dgfRenewLicenseObj = DgfRenewLicenseLocalServiceUtil.getDgfRenewLicense(renewLicenseId);
			}
			if (duplicateLicenseReasonId > 0) {
				dgfDuplctLicnsReasonObj = DgfDuplctLicnsReasonLocalServiceUtil
						.getDgfDuplctLicnsReason(duplicateLicenseReasonId);
			}
			dgfFglLicDtlsObj = DgfFglLicDtlsLocalServiceUtil.getDgfFglLicDtlsByFglPrePrimaryId(fglPrePrimaryId);
			dgfUsersObj = DgfUsersLocalServiceUtil.getDgfUsersByNid(dgfFglLicDtlsObj.getNationalId());
			dgfUsersDtlsObj = DgfUsersDtlsLocalServiceUtil
					.getDgfUsersDtlsByNationalId(Long.parseLong(dgfFglLicDtlsObj.getNationalId()));
			licnsUserRegsObj = licnsUserRegsLocalServiceUtil.getlicnsUserByNid(dgfFglLicDtlsObj.getNationalId());
			if (dgfFglPreDtlsObj.getPhotographDocId() > 0) {
				photographFileObj = DgfAttachmentsLocalServiceUtil
						.getDgfAttachments(dgfFglPreDtlsObj.getPhotographDocId());
			}
			if (dgfFglPreDtlsObj.getTradeLicenseDocId() > 0) {
				tradeLicenseFileObj = DgfAttachmentsLocalServiceUtil
						.getDgfAttachments(dgfFglPreDtlsObj.getTradeLicenseDocId());
			}
			if (dgfFglPreDtlsObj.getBussIdentfctDocId() > 0) {
				binFileObj = DgfAttachmentsLocalServiceUtil.getDgfAttachments(dgfFglPreDtlsObj.getBussIdentfctDocId());
			}
			if (dgfFglPreDtlsObj.getTaxIdentfctDocId() > 0) {
				tinObj = DgfAttachmentsLocalServiceUtil.getDgfAttachments(dgfFglPreDtlsObj.getTaxIdentfctDocId());
			}
			if (dgfFglPreDtlsObj.getBnkStatmtDocId() > 0) {
				bankStatementObj = DgfAttachmentsLocalServiceUtil
						.getDgfAttachments(dgfFglPreDtlsObj.getBnkStatmtDocId());
			}
			if (dgfFglPreDtlsObj.getPaymentChallanId() > 0) {
				paymentChallanObj = DgfAttachmentsLocalServiceUtil
						.getDgfAttachments(dgfFglPreDtlsObj.getPaymentChallanId());
			}
			if(dgfFglPreDtlsObj.getElectricExemptionMemoId() > 0) {
				electricExemptionMemoObj = DgfAttachmentsLocalServiceUtil.getDgfAttachments(dgfFglPreDtlsObj.getElectricExemptionMemoId());
			}
			if(dgfFglPreDtlsObj.getEnvClrMemoId() > 0) {
				envClrMemoObj = DgfAttachmentsLocalServiceUtil.getDgfAttachments(dgfFglPreDtlsObj.getEnvClrMemoId());
			}
			if(dgfFglPreDtlsObj.getBstiClrMemoId() > 0) {
				bstiClrMemoObj = DgfAttachmentsLocalServiceUtil.getDgfAttachments(dgfFglPreDtlsObj.getBstiClrMemoId());
			}
			if(dgfFglPreDtlsObj.getFireLicNumDocId() > 0) {
				fireLicNumDocObj = DgfAttachmentsLocalServiceUtil.getDgfAttachments(dgfFglPreDtlsObj.getFireLicNumDocId());
			}
			if(dgfFglPreDtlsObj.getOtherReleventDocId() > 0) {
				otherReleventDocObj = DgfAttachmentsLocalServiceUtil.getDgfAttachments(dgfFglPreDtlsObj.getOtherReleventDocId());
			}
			allAddress = licnsUserRegsLocalServiceUtil.getlicnsUserAddrs(dgfFglLicDtlsObj.getNationalId());

			map.put("fglApplicationNo", dgfFglPreDtlsObj.getFglApplicationNo());

			if (dgfRenewLicenseObj != null) {
				if (dgfRenewLicenseObj.getTradeLicAttchId() > 0) {
					DgfAttachments renewTradeAttchObj = DgfAttachmentsLocalServiceUtil
							.getDgfAttachments(dgfRenewLicenseObj.getTradeLicAttchId());
					if (renewTradeAttchObj != null) {
						map.put("renewTradeAttchDocument", renewTradeAttchObj.getFilePath());
					}
				}
				if (dgfRenewLicenseObj.getPaymentAttchId() > 0) {
					DgfAttachments renewPaymentAttchObj = DgfAttachmentsLocalServiceUtil
							.getDgfAttachments(dgfRenewLicenseObj.getPaymentAttchId());

					if (renewPaymentAttchObj != null) {
						map.put("renewPaymentAttchDocument", renewPaymentAttchObj.getFilePath());
					}
				}

				map.put("fglApplicationNo", dgfRenewLicenseObj.getApplicationNo());
				map.put("fglLicenseApplicationType", dgfRenewLicenseObj.getLicenseApplicationType());
				map.put("fglLicenseNo", dgfRenewLicenseObj.getLicenseNo());
				map.put("fglLicenseRenewComment", dgfRenewLicenseObj.getComments());
				if (dgfFglLicDtlsObj.getFoodgrainLicenseIssueDate() != null) {
					map.put("fglLicenseIssuedDate", newFormat.format(dgfFglLicDtlsObj.getFoodgrainLicenseIssueDate()));
				}

				if (dgfFglLicDtlsObj.getFoodgrainLicenseIssuedBy() > 0) {
					DgfUsers dgfUsers = DgfUsersLocalServiceUtil
							.getDgfUsers(dgfFglLicDtlsObj.getFoodgrainLicenseIssuedBy());
					if (dgfUsers != null) {
						map.put("fglLicenseIssuedBy", dgfUsers.getApplicantName());
					}
				}
				if (dgfFglLicDtlsObj.getFoodgrainLicenseExpiryDate() != null) {
					map.put("fglLicenseExpiryDate", newFormat.format(dgfFglLicDtlsObj.getFoodgrainLicenseExpiryDate()));
				}
				map.put("status", dgfRenewLicenseObj.getStatus());
			}
			if (dgfDuplctLicnsReasonObj != null) {

				if (dgfDuplctLicnsReasonObj.getTradeLicAttchId() > 0) {
					DgfAttachments duplicateTradeAttchObj = DgfAttachmentsLocalServiceUtil
							.getDgfAttachments(dgfDuplctLicnsReasonObj.getTradeLicAttchId());
					if (duplicateTradeAttchObj != null) {
						map.put("duplicateTradeAttchDocument", duplicateTradeAttchObj.getFilePath());
					}
				}

				if (dgfDuplctLicnsReasonObj.getPaymentAttchId() > 0) {
					DgfAttachments duplicatePaymentAttchObj = DgfAttachmentsLocalServiceUtil
							.getDgfAttachments(dgfDuplctLicnsReasonObj.getPaymentAttchId());

					if (duplicatePaymentAttchObj != null) {
						map.put("duplicatePaymentAttchDocument", duplicatePaymentAttchObj.getFilePath());
					}
				}

				map.put("fglApplicationNo", dgfDuplctLicnsReasonObj.getApplicationNo());
				map.put("fglLicneseApplicationType", dgfDuplctLicnsReasonObj.getLicenseApplicationType());
				map.put("fglLicenseNo", dgfDuplctLicnsReasonObj.getLicenseNo());
				map.put("fglLicenseDuplicateComment", dgfDuplctLicnsReasonObj.getComments());
				map.put("fglLicenseDuplicateReason", dgfDuplctLicnsReasonObj.getDuplicateLicenseReasonDisplay());
				if (dgfFglLicDtlsObj.getFoodgrainLicenseIssueDate() != null) {
					map.put("fglLicenseIssuedDate", newFormat.format(dgfFglLicDtlsObj.getFoodgrainLicenseIssueDate()));
				}
				if (dgfFglLicDtlsObj.getFoodgrainLicenseIssuedBy() > 0) {
					DgfUsers dgfUsers = DgfUsersLocalServiceUtil
							.getDgfUsers(dgfFglLicDtlsObj.getFoodgrainLicenseIssuedBy());
					if (dgfUsers != null) {
						map.put("fglLicenseIssuedBy", dgfUsers.getApplicantName());
					}
				}

				if (dgfFglLicDtlsObj.getFoodgrainLicenseExpiryDate() != null) {
					map.put("fglLicenseExpiryDate", newFormat.format(dgfFglLicDtlsObj.getFoodgrainLicenseExpiryDate()));
				}
				map.put("status", dgfDuplctLicnsReasonObj.getStatus());
			}

			String fglLicenseApplicationType = dgfFglPreDtlsObj.getFglApplicationType();
			map.putIfAbsent("fglLicenseApplicationType",
					(fglLicenseApplicationType != null) ? fglLicenseApplicationType : "");
			map.putIfAbsent("fglLicenseNo", "");
			map.putIfAbsent("fglLicenseRenewComment", "");
			map.putIfAbsent("fglLicenseDuplicateComment", "");
			map.putIfAbsent("fglLicenseDuplicateReason", "");
			map.putIfAbsent("renewTradeAttchDocument", "");
			map.putIfAbsent("renewPaymentAttchDocument", "");
			map.putIfAbsent("duplicateTradeAttchDocument", "");
			map.putIfAbsent("duplicatePaymentAttchDocument", "");
			map.putIfAbsent("fglLicenseIssuedDate", "");
			map.putIfAbsent("fglLicenseIssuedBy", "");
			map.putIfAbsent("fglLicenseExpiryDate", "");
			map.putIfAbsent("status", dgfFglPreDtlsObj.getStatus());
			map.putIfAbsent("companyId", dgfFglPreDtlsObj.getCompanyId());
			map.putIfAbsent("groupId", dgfFglPreDtlsObj.getGroupId());

			map.put("nidNumber", dgfFglLicDtlsObj.getNationalId());
			map.put("Email", dgfUsersDtlsObj.getEmail());
			map.put("mobileNumber", dgfUsersObj.getMobileNo());
			map.put("dateOfBirth", newFormat.format(dgfUsersObj.getBirthDate()));
			map.put("nameOfTheApllicant", dgfUsersObj.getApplicantName());
			map.put("fatherName", dgfUsersObj.getFatherName());
			map.put("motherName", dgfUsersObj.getMotherName());
			map.put("Gender", dgfUsersObj.getGender());
			map.put("maritalStatus", dgfUsersObj.getMaritalStatus());
			map.put("tradeLicenseNumber", dgfFglLicDtlsObj.getTradeLicenseNo());
			map.put("tradeLicenseExpiryDate", newFormat.format(dgfFglLicDtlsObj.getTradeLicenseExpiryDate()));
			map.put("tin", dgfFglPreDtlsObj.getTaxIdentificationNo());
			map.put("bin", dgfFglPreDtlsObj.getBusinessIdentificationNo());
			map.put("tradeLicenseIssuerCode", dgfFglPreDtlsObj.getTradeLicenseIssuerCode());
			map.put("tradeLicenseIssuerCity", dgfFglPreDtlsObj.getTradeLicenseIssuerCity());
			map.put("businessName", dgfFglPreDtlsObj.getBusinessName());
			map.put("businessType", dgfFglPreDtlsObj.getBusinessType());
			map.put("productType", dgfFglPreDtlsObj.getProductType());
			//nid address details
			map.put("nidDivision", allAddress.get("nidDivision"));
			map.put("nidDistrict", allAddress.get("nidDistrict"));
			map.put("nidUpazila", allAddress.get("nidUpazila"));
			map.put("nidUnion", allAddress.get("nidUnion"));
			map.put("nidVillage", allAddress.get("nidVillage"));
			map.put("nidWard", allAddress.get("nidWard"));
			map.put("nidZipCode", allAddress.get("nidZipCode"));
			map.put("nidPostOffice", allAddress.get("nidPostOffice"));
			map.put("nidHouseAddress", allAddress.get("nidHouseAddress"));
			
			map.put("division", allAddress.get("division"));
			map.put("divisionBn", allAddress.get("divisionBn"));
			map.put("district", allAddress.get("district"));
			map.put("districtBn", allAddress.get("districtBn"));
			map.put("upazila", allAddress.get("subdistrict"));
			map.put("upazilaBn", allAddress.get("subdistrictBn"));
			map.put("union", allAddress.get("union"));
			map.put("unionBn", allAddress.get("unionBn"));
			map.put("ward", allAddress.get("ward"));
			map.put("village", allAddress.get("village"));
			map.put("zipCode", allAddress.get("zipcode"));
			map.put("postOffice", allAddress.get("postoffice"));
			map.put("houseAddress", allAddress.get("house"));
			map.put("busDivision", allAddress.get("busdivision"));
			map.put("busDivisionBn", allAddress.get("busdivisionBn"));
			map.put("busDistrict", allAddress.get("busdistrict"));
			map.put("busDistrictBn", allAddress.get("busdistrictBn"));
			map.put("busUpazila", allAddress.get("bussubdistrict"));
			map.put("busUpazilaBn", allAddress.get("bussubdistrictBn"));
			map.put("busUnion", allAddress.get("busunion"));
			map.put("busUnionBn", allAddress.get("busunionBn"));
			map.put("busVillage", allAddress.get("busVillage"));
			map.put("busWard", allAddress.get("busward"));
			map.put("busZipCode", allAddress.get("buszipcode"));
			map.put("busPostOffice", allAddress.get("buspostoffice"));
			map.put("busHouseAddress", allAddress.get("bushouse"));
			map.put("photograph", (photographFileObj != null) ? photographFileObj.getFilePath() : "");
			map.put("tradeLicenseDocument", (tradeLicenseFileObj != null) ? tradeLicenseFileObj.getFilePath() : "");
			map.put("binDocument", (binFileObj != null) ? binFileObj.getFilePath() : "");
			map.put("tinDocument", (tinObj != null) ? tinObj.getFilePath() : "");
			map.put("bankStatementDocument", (bankStatementObj != null) ? bankStatementObj.getFilePath() : "");
			map.put("paymentChallanDocument", (paymentChallanObj !=null) ? paymentChallanObj.getFilePath() : "");
			map.put("electricExemptionMemo", (electricExemptionMemoObj !=null) ? electricExemptionMemoObj.getFilePath() : "");
			map.put("envClrMemo", (envClrMemoObj !=null) ? envClrMemoObj.getFilePath() : "");
			map.put("bstiClrMemo", (bstiClrMemoObj !=null) ? bstiClrMemoObj.getFilePath() : "");
			map.put("fireLicNumDoc", (fireLicNumDocObj !=null) ? fireLicNumDocObj.getFilePath() : "");
			map.put("otherReleventDocument", (otherReleventDocObj !=null) ? otherReleventDocObj.getFilePath() : "");
			return map;
		} catch (Exception e) {
			log.error("details data error===" + e.getMessage());
		}
		return map;

	}

	public WorkflowInstanceLink getWorkflowInstanceLinkByUserId(long userId, long classPk) throws PortalException {
		User user = UserLocalServiceUtil.getUser(userId);
		long companyId = user.getCompanyId();
		long classNameId = ClassNameLocalServiceUtil.getClassNameId(DgfFglPreDtls.class);

		DynamicQuery dynamicQuery = WorkflowInstanceLinkLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.eq("userId", userId));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("companyId", companyId));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("classNameId", classNameId));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("classPK", classPk));
		WorkflowInstanceLink workflowInstanceLink = null;
		List<WorkflowInstanceLink> workflowInstanceLinkObjList = WorkflowInstanceLinkLocalServiceUtil
				.dynamicQuery(dynamicQuery);
		if (Validator.isNotNull(workflowInstanceLinkObjList) && workflowInstanceLinkObjList.size() > 0) {
			for (WorkflowInstanceLink workflowInstanceLinkObj : workflowInstanceLinkObjList) {
				if (workflowInstanceLinkObj.getClassPK() == classPk) {
					workflowInstanceLink = workflowInstanceLinkObj;
					break;
				}
			}
		}
		return workflowInstanceLink;
	}

	public long getWorkflowTaskIdByCompanyIdAndWorkflowInstanceId(long companyId, long workflowInstanceId) {
		List<WorkflowLog> workflowLogs = null;
		try {
			workflowLogs = getWorkflowLogs(companyId, workflowInstanceId);
		} catch (WorkflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long workflowTaskId = 0;
		if (!workflowLogs.isEmpty()) {
			workflowTaskId = workflowLogs.get(workflowLogs.size() - 1).getWorkflowTaskId();
		}
		return workflowTaskId;
	}

	private List<WorkflowLog> getWorkflowLogs(long companyId, long workflowInstanceId) throws WorkflowException {
		List<Integer> assignLogTypes = new ArrayList<>();
		assignLogTypes.add(WorkflowLog.TASK_ASSIGN);
		List<WorkflowLog> workflowLogs = WorkflowLogManagerUtil.getWorkflowLogsByWorkflowInstance(companyId,
				workflowInstanceId, assignLogTypes, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				WorkflowComparatorFactoryUtil.getLogCreateDateComparator(true));
		if (Validator.isNull(workflowLogs)) {
			return new ArrayList<>();
		}
		return workflowLogs;
	}

	public WorkflowTask getWorkflowTaskByCompanyIdAndWorkflowInstanceId(long companyId, long workflowInstanceId)
			throws PortalException {
		// get the current workflow task for the workflow instance
		List<WorkflowTask> workflowTasks = WorkflowTaskManagerUtil.getWorkflowTasks(companyId, false, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null);

		WorkflowTask workflowTask = null;

		for (WorkflowTask workflowTaskObj : workflowTasks) {
			if (workflowTaskObj.getWorkflowInstanceId() == workflowInstanceId) {
				workflowTask = workflowTaskObj;
				break;
			}
		}
		return workflowTask;
	}

	public List<DgfFglPreDtls> getDgfFglPreDtlsByUserId(long userId) throws PortalException {
		User user = UserLocalServiceUtil.getUser(userId);
		long companyId = user.getCompanyId();
		long classNameId = ClassNameLocalServiceUtil.getClassNameId(DgfFglPreDtls.class);
		DynamicQuery dynamicQuery = WorkflowInstanceLinkLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.eq("userId", userId));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("companyId", companyId));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("classNameId", classNameId));
		DgfFglPreDtls dgfFglPreDtls = null;
		List<DgfFglPreDtls> dgfFglPreDtlsList = new ArrayList<DgfFglPreDtls>();
		List<WorkflowInstanceLink> workflowInstanceLinkList = WorkflowInstanceLinkLocalServiceUtil
				.dynamicQuery(dynamicQuery);
		for (WorkflowInstanceLink workflowInstanceLink : workflowInstanceLinkList) {
			long classPK = workflowInstanceLink.getClassPK();
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(classPK);
			dgfFglPreDtlsList.add(dgfFglPreDtls);
		}

		return dgfFglPreDtlsList;
	}

	public DgfFglPreDtls getDgfFglPreDtlObjectByUserIdAndWorkflowTaskId(long userId, long workflowTaskId)
			throws PortalException {
		User user = UserLocalServiceUtil.getUser(userId);
		long companyId = user.getCompanyId();
		DynamicQuery dynamicQuery = UserNotificationEventLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.eq("userId", userId));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("companyId", companyId));
		DgfFglPreDtls dgfFglPreDtls = null;
		List<UserNotificationEvent> userNotificationEventList = UserNotificationEventLocalServiceUtil
				.dynamicQuery(dynamicQuery);
		for (UserNotificationEvent userNotificationEvent : userNotificationEventList) {
			String payload = userNotificationEvent.getPayload();
			if (Validator.isNotNull(payload)) {
				JSONObject payloadJSON = JSONFactoryUtil.createJSONObject(payload);
				long entryClassPK = payloadJSON.getLong("entryClassPK");
				long currentWorkflowTaskId = payloadJSON.getLong("workflowTaskId");
				if (currentWorkflowTaskId == workflowTaskId) {
					dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(entryClassPK);
					break;
				}
			}
		}
		return dgfFglPreDtls;
	}

	public void setUserLicenseAndMessageAndLoginActivity(long fglPrePrimaryId) {
		log.info("DgfFglPreDtlsLocalServiceImpl.setUserLicenseAndMessageAndLoginActivity START");
		// DCF approved action
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfFglLicDtls dgfFglLicDtls = null;
		DgfUsers dgfUsers = null;
		DgfFglLicenseNo dgfFglLicenseNo = null;
		int DCF_APPROVED_TYPE = 5;
		if (Validator.isNotNull(fglPrePrimaryId)) {
			try {
				// Get DgfFglPreDtls by fglPrePrimaryId
				dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(fglPrePrimaryId);
				// get DgfFglLicDtls by fglPrePrimaryId then set the license no and update data
				dgfFglLicDtls = dgfFglLicDtlsPersistence.findBydgfFglLicDtlsByFglLicPrePrimaryId(fglPrePrimaryId);
				dgfFglLicenseNo = DgfFglLicenseNoLocalServiceUtil.generatedDgfFglLicenseNo();
				if (Validator.isNotNull(dgfFglLicDtls) && Validator.isNotNull(dgfFglLicenseNo)) {
					dgfFglLicDtls.setFoodgrainLicenseNo(dgfFglLicenseNo.getLicenseNo());
					DgfFglLicDtlsLocalServiceUtil.updateDgfFglLicDtls(dgfFglLicDtls);
				}
				// get Dgfusers by userId or NID
				dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(Long.toString(dgfFglPreDtls.getNationalId()));

				if (Validator.isNotNull(dgfUsers)) {
					// get liferay user_ by userId and set user login active and update user data
					User user = UserLocalServiceUtil.getUser(dgfUsers.getUserId());
					user.setStatus(WorkflowConstants.STATUS_APPROVED);
					UserLocalServiceUtil.updateUser(user);
					// send sms to user
					// send user sms notification with comments
					String licenseMessage = licenseMessageUtil.getLicenseDcfApproveMessage();
					String message = licenseMessage + " #" + dgfFglPreDtls.getFglApplicationNo();
					DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(
							message, dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),
							Long.parseLong(dgfFglPreDtls.getFglApplicationNo()));
				}
			} catch (NoSuchDgfFglLicDtlsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchDgfUsersException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		log.info("DgfFglPreDtlsLocalServiceImpl.setUserLicenseAndMessageAndLoginActivity END");
	}

	public DgfFglPreDtls saveDgfFglPreDtls(String nationalId) {
		long fglPrePrimaryId = counterLocalService.increment(DgfFglPreDtls.class.getName());
		DgfFglPreDtls dgfFglPreDtlsObj = dgfFglPreDtlsLocalService.createDgfFglPreDtls(fglPrePrimaryId);
		dgfFglPreDtlsObj.setFglPrePrimaryId(fglPrePrimaryId);

		long nid = 0L;
		String nidStr = nationalId;
		if (nidStr != null && !nidStr.isEmpty()) {
			nid = Long.parseLong(nidStr);
		}
		dgfFglPreDtlsObj.setNationalId(nid);

		long currentTimeMillis = System.currentTimeMillis();
		String applicationNo = nidStr.substring(nidStr.length() - 4) + currentTimeMillis;
		dgfFglPreDtlsObj.setFglApplicationNo(applicationNo);
		dgfFglPreDtlsObj.setApplicantName("Test Application");
		dgfFglPreDtlsObj.setTradeLicenseNo("1111111");
		dgfFglPreDtlsObj.setTradeLicenseIssuerCity("Dhaka");
		dgfFglPreDtlsObj.setBusinessIdentificationNo("22222");
		dgfFglPreDtlsObj.setTaxIdentificationNo("22222");
		dgfFglPreDtlsObj.setBusinessName("Test Business");
		dgfFglPreDtlsObj.setBusinessType("Dealer");
		dgfFglPreDtlsObj.setComments("Test Comm");
		dgfFglPreDtlsObj.setBirthDate(new Date());
		dgfFglPreDtlsObj.setFglApplicationType("New");
		dgfFglPreDtlsObj.setStatus(1);

		DgfFglPreDtls dgfFglPreDtls = dgfFglPreDtlsLocalService.addDgfFglPreDtls(dgfFglPreDtlsObj);
		// set bussiness address and current address and liferay user and dgf user
		// ServiceContext serviceContext =
		// ServiceContextFactory.getInstance(DgfFglPreDtls.class.getName());
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		long userId = 20125;

		dgfFglPreDtls.setUserId(userId);

		long groupId = 20121;

		dgfFglPreDtls.setGroupId(groupId);

		int status = WorkflowConstants.STATUS_DRAFT;

		serviceContext.setScopeGroupId(groupId);
		serviceContext.setCompanyId(20097);
		serviceContext.setUserId(userId);

		String className = DgfFglPreDtls.class.getName();

		dgfFglPreDtlsLocalService.updateDgfFglPreDtls(dgfFglPreDtls);
		try {
			dgfFglPreDtlsLocalService.updateStatus(userId, dgfFglPreDtls.getFglPrePrimaryId(), status, serviceContext);
			AssetEntry assetEntry = AssetEntryLocalServiceUtil.updateEntry(userId, serviceContext.getScopeGroupId(),
					new Date(), new Date(), className, dgfFglPreDtls.getFglPrePrimaryId(), null, 0, null, null, true,
					false, new Date(), null, new Date(), null, ContentTypes.TEXT_HTML, dgfFglPreDtls.getApplicantName(),
					dgfFglPreDtls.getApplicantName(), null, null, null, 0, 0, null);
			WorkflowHandlerRegistryUtil.startWorkflowInstance(dgfFglPreDtls.getCompanyId(), dgfFglPreDtls.getGroupId(),
					dgfFglPreDtls.getUserId(), className, dgfFglPreDtls.getPrimaryKey(), dgfFglPreDtls, serviceContext);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dgfFglPreDtls;
	}

	/////// START USER NOTIFICATION EVENT ///////////
	public void setLicenseAcfUserNotificationEvent(long fglPrePrimaryId) {
		log.info("DgfFglPreDtlsLocalServiceImpl.setLicenseAcfUserNotificationEvent START");
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfBussAddrDtls dgfBussAddrDtls = null;
		List<DgfUsers> dgfUserList = null;
		try {
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(fglPrePrimaryId);
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
			workflowInstanceId = DgfoodWorkflowHandlerUtil
					.getWorkflowInstanceIdByUserIdAndClassPK(dgfFglPreDtls.getUserId(), dgfFglPreDtls.getPrimaryKey());
			// get the asset's workflow task
			workflowTask = DgfoodWorkflowHandlerUtil
					.getWorkflowTaskByCompanyIdAndWorkflowInstanceId(dgfFglPreDtls.getCompanyId(), workflowInstanceId);
			workflowTaskId = workflowTask.getWorkflowTaskId();
		} catch (PortalException e1) {
			log.error("ERROR: " + e1.getMessage());
		}
		// send notification to acf user
		String entryType = "model.resource.bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls";
		String notificationMessage = LicenseCommonConstant.NEW_FOOD_GRAIN_LICENSE;
		if (Validator.isNotNull(dgfUserList) && dgfUserList.size() > 0) {
			for (DgfUsers dgfUser : dgfUserList) {
				DgfoodWorkflowHandlerUtil.preparedPayloadAndSendUserNotification(dgfUser.getUserId(),
						dgfFglPreDtls.getCompanyId(), dgfFglPreDtls.getGroupId(), entryType,
						dgfFglPreDtls.getPrimaryKey(), DgfFglPreDtls.class.getName(), workflowInstanceId,
						workflowTaskId, notificationMessage);
			}
		} else {
			log.error("ACF USER NOT FOUND THIS LOCATION");
		}
		log.info("DgfFglPreDtlsLocalServiceImpl.setLicenseAcfUserNotificationEvent END");
	}

	public void setLicenseUcfUserNotificationEvent(long fglPrePrimaryId) {
		log.info("DgfFglPreDtlsLocalServiceImpl.setLicenseUcfUserNotificationEvent START");
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfBussAddrDtls dgfBussAddrDtls = null;
		List<DgfUsers> dgfUserList = null;
		try {
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(fglPrePrimaryId);
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
			workflowInstanceId = DgfoodWorkflowHandlerUtil
					.getWorkflowInstanceIdByUserIdAndClassPK(dgfFglPreDtls.getUserId(), dgfFglPreDtls.getPrimaryKey());
			// get the asset's workflow task
			workflowTask = DgfoodWorkflowHandlerUtil
					.getWorkflowTaskByCompanyIdAndWorkflowInstanceId(dgfFglPreDtls.getCompanyId(), workflowInstanceId);
			workflowTaskId = workflowTask.getWorkflowTaskId();
		} catch (PortalException e1) {
			log.error("ERROR: " + e1.getMessage());
		}
		// send notification to ucf user
		String entryType = "model.resource.bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls";
		String notificationMessage = LicenseCommonConstant.NEW_FOOD_GRAIN_LICENSE;
		if (Validator.isNotNull(dgfUserList) && dgfUserList.size() > 0) {
			for (DgfUsers dgfUser : dgfUserList) {
				DgfoodWorkflowHandlerUtil.preparedPayloadAndSendUserNotification(dgfUser.getUserId(),
						dgfFglPreDtls.getCompanyId(), dgfFglPreDtls.getGroupId(), entryType,
						dgfFglPreDtls.getPrimaryKey(), DgfFglPreDtls.class.getName(), workflowInstanceId,
						workflowTaskId, notificationMessage);
			}
		} else {
			log.error("UCF USER NOT FOUND THIS LOCATION");
		}
		log.info("DgfFglPreDtlsLocalServiceImpl.setLicenseUcfUserNotificationEvent END");
	}

	public void getDcfUserIdByLocationAndSendNotificationByNodeId(long fglPrePrimaryId, String nodeId) {
		log.info("DgfFglPreDtlsLocalServiceImpl.getDcfUserIdByLocationAndSendNotificationByNodeId START");
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfBussAddrDtls dgfBussAddrDtls = null;
		List<DgfUsers> dgfUserList = null;
		try {
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(fglPrePrimaryId);
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
			workflowInstanceId = DgfoodWorkflowHandlerUtil
					.getWorkflowInstanceIdByUserIdAndClassPK(dgfFglPreDtls.getUserId(), dgfFglPreDtls.getPrimaryKey());
			// get workflow task ID
			workflowTaskId = DgfoodWorkflowHandlerUtil.getWorkflowTaskIdByNode(nodeId, dgfFglPreDtls.getCompanyId(),
					workflowInstanceId);
		} catch (PortalException e1) {
			log.error("ERROR: " + e1.getMessage());
		}
		// send notification to ucf user
		String entryType = "model.resource.bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls";
		String notificationMessage = LicenseCommonConstant.NEW_FOOD_GRAIN_LICENSE;
		if (Validator.isNotNull(dgfUserList) && dgfUserList.size() > 0) {
			for (DgfUsers dgfUser : dgfUserList) {
				DgfoodWorkflowHandlerUtil.preparedPayloadAndSendUserNotification(dgfUser.getUserId(),
						dgfFglPreDtls.getCompanyId(), dgfFglPreDtls.getGroupId(), entryType,
						dgfFglPreDtls.getPrimaryKey(), DgfFglPreDtls.class.getName(), workflowInstanceId,
						workflowTaskId, notificationMessage);
			}
		} else {
			log.info("DCF USER NOT FOUND THIS LOCATION");
		}
		log.info("DgfFglPreDtlsLocalServiceImpl.getDcfUserIdByLocationAndSendNotificationByNodeId END");
	}
	
	public void getUcfUserIdByLocationAndSendNotificationByNodeId(long fglPrePrimaryId, String nodeId) {
		log.info("DgfFglPreDtlsLocalServiceImpl.getUcfUserIdByLocationAndSendNotificationByNodeId START");
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfBussAddrDtls dgfBussAddrDtls = null;
		List<DgfUsers> dgfUserList = null;
		try {
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(fglPrePrimaryId);
			dgfBussAddrDtls = DgfBussAddrDtlsLocalServiceUtil.getDgfBussAddrDtls(dgfFglPreDtls.getBussinessAddrId());
			// check dcf by location wise
			dgfUserList = DgfUsersLocalServiceUtil.getDgfUcfUsersByDistrict(dgfBussAddrDtls.getBusinessUpzilla(),
					dgfFglPreDtls.getCompanyId());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// get workflow task and instanse id
		long workflowInstanceId = 0;
		long workflowTaskId = 0;
		try {
			workflowInstanceId = DgfoodWorkflowHandlerUtil
					.getWorkflowInstanceIdByUserIdAndClassPK(dgfFglPreDtls.getUserId(), dgfFglPreDtls.getPrimaryKey());
			// get workflow task ID
			workflowTaskId = DgfoodWorkflowHandlerUtil.getWorkflowTaskIdByNode(nodeId, dgfFglPreDtls.getCompanyId(),
					workflowInstanceId);
		} catch (PortalException e1) {
			log.error("ERROR: " + e1.getMessage());
		}
		// send notification to ucf user
		String entryType = "model.resource.bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls";
		String notificationMessage = LicenseCommonConstant.NEW_FOOD_GRAIN_LICENSE;
		if (Validator.isNotNull(dgfUserList) && dgfUserList.size() > 0) {
			for (DgfUsers dgfUser : dgfUserList) {
				DgfoodWorkflowHandlerUtil.preparedPayloadAndSendUserNotification(dgfUser.getUserId(),
						dgfFglPreDtls.getCompanyId(), dgfFglPreDtls.getGroupId(), entryType,
						dgfFglPreDtls.getPrimaryKey(), DgfFglPreDtls.class.getName(), workflowInstanceId,
						workflowTaskId, notificationMessage);
			}
		} else {
			log.info("UCF USER NOT FOUND THIS LOCATION");
		}
		log.info("DgfFglPreDtlsLocalServiceImpl.getUcfUserIdByLocationAndSendNotificationByNodeId END");
	}
	
	public void getCcdrUserIdByLocationAndSendNotificationByNodeId(long fglPrePrimaryId, String nodeId) {
		log.info("DgfFglPreDtlsLocalServiceImpl.getCcdrUserIdByLocationAndSendNotificationByNodeId START");
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfBussAddrDtls dgfBussAddrDtls = null;
		List<DgfUsers> dgfUserList = null;
		try {
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(fglPrePrimaryId);
			dgfBussAddrDtls = DgfBussAddrDtlsLocalServiceUtil.getDgfBussAddrDtls(dgfFglPreDtls.getBussinessAddrId());
			// check dcf by location wise
			dgfUserList = DgfUsersLocalServiceUtil.getDgfCcdrUsersByUpazila(dgfBussAddrDtls.getBusinessUpzilla(),
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
					dgfFglPreDtls.getUserId(), dgfFglPreDtls.getPrimaryKey());
			// get workflow task ID
			workflowTaskId = DgfoodWorkflowHandlerUtil.getWorkflowTaskIdByNode(nodeId, dgfFglPreDtls.getCompanyId(),
					workflowInstanceId);
		} catch (PortalException e1) {
			log.error("ERROR: " + e1.getMessage());
		}
		// send notification to ucf user
		String entryType = "model.resource.bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls";
		String notificationMessage = LicenseCommonConstant.NEW_FOOD_GRAIN_LICENSE;
		if (Validator.isNotNull(dgfUserList) && dgfUserList.size() > 0) {
			for (DgfUsers dgfUser : dgfUserList) {
				DgfoodWorkflowHandlerUtil.preparedPayloadAndSendUserNotification(dgfUser.getUserId(),
						dgfFglPreDtls.getCompanyId(), dgfFglPreDtls.getGroupId(), entryType,
						dgfFglPreDtls.getPrimaryKey(), DgfFglPreDtls.class.getName(), workflowInstanceId,
						workflowTaskId, notificationMessage);
			}
		} else {
			log.info("CCDR USER NOT FOUND THIS LOCATION");
		}
		log.info("DgfFglPreDtlsLocalServiceImpl.getCcdrUserIdByLocationAndSendNotificationByNodeId END");
	}
	
	
	////////// END USER NOTIFICATION EVENT //////////////

	public boolean checkAcfUsersExistByLocation(long fglPrePrimaryId) {
		log.info("DgfFglPreDtlsLocalServiceImpl.checkAcfUsersExistByLocation START");
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfBussAddrDtls dgfBussAddrDtls = null;
		List<DgfUsers> dgfUserList = null;
		boolean isExistAcfUser = false;
		try {
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(fglPrePrimaryId);
			dgfBussAddrDtls = DgfBussAddrDtlsLocalServiceUtil.getDgfBussAddrDtls(dgfFglPreDtls.getBussinessAddrId());
			dgfUserList = DgfUsersLocalServiceUtil.getDgfAcfUsersByDistrict(dgfBussAddrDtls.getBusinessDistrict(),
					dgfFglPreDtls.getCompanyId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("ERROR: " + e.getMessage());
		}
		if (Validator.isNotNull(dgfUserList) && dgfUserList.size() > 0) {
			isExistAcfUser = true;
		}
		log.info("DgfFglPreDtlsLocalServiceImpl.checkAcfUsersExistByLocation END");
		return isExistAcfUser;
	}
	
	public boolean checkCcdrUsersExistByLocation(long fglPrePrimaryId) {
		log.info("DgfFglPreDtlsLocalServiceImpl.checkCcdrUsersExistByLocation START");
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfBussAddrDtls dgfBussAddrDtls = null;
		List<DgfUsers> dgfUserList = null;
		boolean isExistCcdrUser = false;
		try {
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(fglPrePrimaryId);
			dgfBussAddrDtls = DgfBussAddrDtlsLocalServiceUtil.getDgfBussAddrDtls(dgfFglPreDtls.getBussinessAddrId());
			dgfUserList = DgfUsersLocalServiceUtil.getDgfCcdrUsersByUpazila(dgfBussAddrDtls.getBusinessUpzilla(), dgfFglPreDtls.getCompanyId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("ERROR: "+e.getMessage());
		}
		if(Validator.isNotNull(dgfUserList) && dgfUserList.size()>0) {
			isExistCcdrUser = true;
		}
		log.info("DgfFglPreDtlsLocalServiceImpl.checkCcdrUsersExistByLocation END");
		return isExistCcdrUser;
	}

	private ArrayList<Long> getDcfUserIdListByLocation(DgfBussAddrDtls dgfBussAddrDtls, DgfFglPreDtls dgfFglPreDtls) {
		ArrayList<Long> userIdList = new ArrayList<Long>();
		long userId = getDcfUserIdByLocation(dgfFglPreDtls, dgfBussAddrDtls);
		if (userId > 0) {
			userIdList.add(userId);
		}
		return userIdList;
	}

	private ArrayList<Long> getAcfOrUcfUserIdByLocation(DgfBussAddrDtls dgfBussAddrDtls, DgfFglPreDtls dgfFglPreDtls) {
		ArrayList<Long> userIdList = new ArrayList<Long>();
		List<DgfUsersAddrDtls> dgfUsersAddrDtlsList = null;
		try {
			dgfUsersAddrDtlsList = DgfUsersAddrDtlsLocalServiceUtil.getDgfUsersAddrDtlsByDivisionAndDistrict(
					dgfBussAddrDtls.getBusinessDivision(), dgfBussAddrDtls.getBusinessDistrict());
		} catch (Exception e1) {
			log.error("USER NOT FOUND DIVISION, DISTRICT WISE ERROR: " + e1.getMessage());
		}
		if (Validator.isNotNull(dgfUsersAddrDtlsList)) {
			for (DgfUsersAddrDtls dgfUsersAddrDtlsObj : dgfUsersAddrDtlsList) {
				// find dgf user then check acf user role
				DgfUsers currentDgfUsers = null;
				try {
					currentDgfUsers = DgfUsersLocalServiceUtil
							.getDgfUsersByNid(Long.toString(dgfUsersAddrDtlsObj.getNationalId()));
				} catch (NoSuchDgfUsersException e) {
					log.error("ERROR: " + e.getMessage());
				}
				if (Validator.isNotNull(currentDgfUsers)) {
					// List<Role> userRoles =
					// RoleLocalServiceUtil.getUserRoles(currentDgfUsers.getUserId());
					List<Role> userRoles = RoleLocalServiceUtil.getUserGroupRoles(currentDgfUsers.getUserId(),
							dgfFglPreDtls.getGroupId());
					if (Validator.isNotNull(userRoles) && userRoles.size() > 0) {
						for (Role role : userRoles) {
							// check ACF or UCF assignment by bussiness type
							boolean isUcf = dgfFglPreDtls.getBusinessType().toUpperCase()
									.equals(LicenseCommonConstant.ATTACHAKKI)
									|| dgfFglPreDtls.getBusinessType().toUpperCase()
											.equals(LicenseCommonConstant.RETAILERS);
							if (isUcf) {
								if (role.getName().toUpperCase().equals(LicenseCommonConstant.ROLE_UCF)) {
									userIdList.add(currentDgfUsers.getUserId());
								}
							} else {
								if (role.getName().toUpperCase().equals(LicenseCommonConstant.ROLE_ACF)) {
									userIdList.add(currentDgfUsers.getUserId());
								}
							}

						}
					}
				}

			}
		}
		return userIdList;
	}

	private ArrayList<Long> getUcfUserIdByLocation(DgfBussAddrDtls dgfBussAddrDtls, DgfFglPreDtls dgfFglPreDtls) {
		ArrayList<Long> userIdList = new ArrayList<Long>();
		List<DgfUsersAddrDtls> dgfUsersAddrDtlsList = null;
		try {
			dgfUsersAddrDtlsList = DgfUsersAddrDtlsLocalServiceUtil.getDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
					dgfBussAddrDtls.getBusinessDivision(), dgfBussAddrDtls.getBusinessDistrict(),
					dgfBussAddrDtls.getBusinessUpzilla());
		} catch (Exception e1) {
			log.error("USER NOT FOUND DIVISION, DISTRICT AND UPZILLA WISE ERROR: " + e1.getMessage());
		}
		if (Validator.isNotNull(dgfUsersAddrDtlsList)) {
			for (DgfUsersAddrDtls dgfUsersAddrDtlsObj : dgfUsersAddrDtlsList) {
				// find dgf user then check acf user role
				DgfUsers currentDgfUsers = null;
				try {
					currentDgfUsers = DgfUsersLocalServiceUtil
							.getDgfUsersByNid(Long.toString(dgfUsersAddrDtlsObj.getNationalId()));
				} catch (NoSuchDgfUsersException e) {
					log.error("ERROR: " + e.getMessage());
				}
				if (Validator.isNotNull(currentDgfUsers)) {
					// List<Role> userRoles =
					// RoleLocalServiceUtil.getUserRoles(currentDgfUsers.getUserId());
					List<Role> userRoles = RoleLocalServiceUtil.getUserGroupRoles(currentDgfUsers.getUserId(),
							dgfFglPreDtls.getGroupId());
					if (Validator.isNotNull(userRoles) && userRoles.size() > 0) {
						for (Role role : userRoles) {
							// check ACF or UCF assignment by bussiness type
							boolean isUcf = dgfFglPreDtls.getBusinessType().toUpperCase()
									.equals(LicenseCommonConstant.ATTACHAKKI)
									|| dgfFglPreDtls.getBusinessType().toUpperCase()
											.equals(LicenseCommonConstant.RETAILERS);
							if (isUcf) {
								if (role.getName().toUpperCase().equals(LicenseCommonConstant.ROLE_UCF)) {
									userIdList.add(currentDgfUsers.getUserId());
								}
							}

						}
					}
				}

			}
		}
		return userIdList;
	}

	private void setWorkflowTaskIdAndPreparedPayloadAndSendUserNotification(String nodeId, DgfFglPreDtls dgfFglPreDtls,
			long userId) {
		String type = "com_liferay_portal_workflow_task_web_portlet_MyWorkflowTaskPortlet"; // Replace with a unique
																							// identifier for your
																							// notification
		long timestamp = System.currentTimeMillis(); // Replace with the timestamp of the notification
		int deliveryType = UserNotificationDeliveryConstants.TYPE_WEBSITE; // Replace with the delivery type of your
																			// choice
		long deliverBy = 0; // Use the default delivery deadline
		// prepared payload
		WorkflowInstanceLink workflowInstanceLink = null;
		long workflowTaskId = 0;
		// WorkflowTask workflowTask = null;
		try {
			workflowInstanceLink = DgfFglPreDtlsLocalServiceUtil
					.getWorkflowInstanceLinkByUserId(dgfFglPreDtls.getUserId(), dgfFglPreDtls.getPrimaryKey());

			DynamicQuery dynamicQuery = KaleoLogLocalServiceUtil.dynamicQuery();
			dynamicQuery
					.add(RestrictionsFactoryUtil.eq("kaleoInstanceId", workflowInstanceLink.getWorkflowInstanceId()));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("kaleoNodeName", nodeId));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("type", "TASK_ASSIGNMENT"));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("companyId", dgfFglPreDtls.getCompanyId()));

			List<KaleoLog> kaleoLogList = KaleoLogLocalServiceUtil.dynamicQuery(dynamicQuery);
			if (Validator.isNotNull(kaleoLogList) && kaleoLogList.size() > 0) {
				for (KaleoLog kaleoLog : kaleoLogList) {
					workflowTaskId = kaleoLog.getKaleoTaskInstanceTokenId();
					if (workflowTaskId > 0) {
						break;
					}
				}
			}

		} catch (PortalException e1) {
			log.error("ERROR: " + e1.getMessage());
		}

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("entryType", "model.resource.bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls");
		jsonObject.put("companyId", dgfFglPreDtls.getCompanyId());
		jsonObject.put("entryClassPK", dgfFglPreDtls.getPrimaryKey());
		jsonObject.put("entryClassName", DgfFglPreDtls.class.getName());
		jsonObject.put("groupId", dgfFglPreDtls.getGroupId());
		jsonObject.put("workflowTaskId", workflowTaskId);
		jsonObject.put("notificationMessage", LicenseCommonConstant.NEW_FOOD_GRAIN_LICENSE);
		jsonObject.put("ctCollectionId", "0");
		jsonObject.put("userId", userId);
		jsonObject.put("workflowInstanceId", workflowInstanceLink.getWorkflowInstanceId());
		jsonObject.put("url", "");
		String payload = jsonObject.toString();
		try {
			ServiceContext serviceContext = new ServiceContext();
			UserNotificationEvent userNotificationEvent = UserNotificationEventLocalServiceUtil
					.addUserNotificationEvent(userId, type, timestamp, deliveryType, deliverBy, payload, false,
							serviceContext);
		} catch (PortalException | SystemException e) {
			log.error("ERROR: " + e.getMessage());
		}
	}

	private long getDcfUserIdByLocation(DgfFglPreDtls dgfFglPreDtls, DgfBussAddrDtls dgfBussAddrDtls) {
		long userId = 0;
		List<DgfUsersAddrDtls> dgfUsersAddrDtlsList = DgfUsersAddrDtlsLocalServiceUtil
				.getDgfUsersAddrDtlsByDivisionAndDistrict(dgfBussAddrDtls.getBusinessDivision(),
						dgfBussAddrDtls.getBusinessDistrict());
		if (Validator.isNotNull(dgfUsersAddrDtlsList)) {
			for (DgfUsersAddrDtls dgfUsersAddrDtls : dgfUsersAddrDtlsList) {
				// find dgf user then check acf user role
				DgfUsers currentDgfUsers = null;
				try {
					currentDgfUsers = DgfUsersLocalServiceUtil
							.getDgfUsersByNid(Long.toString(dgfUsersAddrDtls.getNationalId()));
				} catch (NoSuchDgfUsersException e) {
					log.error("ERROR: " + e.getMessage());
				}
				if (Validator.isNotNull(currentDgfUsers)) {
					// List<Role> userRoles =
					// RoleLocalServiceUtil.getUserRoles(currentDgfUsers.getUserId());
					List<Role> userRoles = RoleLocalServiceUtil.getUserGroupRoles(currentDgfUsers.getUserId(),
							dgfFglPreDtls.getGroupId());
					if (Validator.isNotNull(userRoles) && userRoles.size() > 0) {
						for (Role role : userRoles) {
							// check one DCF user in district label
							if (role.getName().toUpperCase().equals(LicenseCommonConstant.ROLE_DCF)) {
								userId = currentDgfUsers.getUserId();
								break;
							}
						}
					}
				}
				if (userId > 0) {
					break;
				}
			}
		}
		return userId;
	}

	public void sendAcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfFglPreDtlsLocalServiceImpl.sendAcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfUsers dgfUsers = null;
		try {
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(classPk);
			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(Long.toString(dgfFglPreDtls.getNationalId()));
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// Get workflow task comments
		String comments = DgfFglPreDtlsLocalServiceUtil
				.getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(dgfFglPreDtls, nodeId);
		// send user sms notification with comments
		String licenseMessage = licenseMessageUtil.getLicenseAcfApproveMessage();
		String message = licenseMessage + " #" + dgfFglPreDtls.getFglApplicationNo() + " " + comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message,
				dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),
				Long.parseLong(dgfFglPreDtls.getFglApplicationNo()));
		log.info("DgfFglPreDtlsLocalServiceImpl.sendAcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId END");
	}

	public void sendAcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfFglPreDtlsLocalServiceImpl.sendAcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfUsers dgfUsers = null;
		try {
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(classPk);
			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(Long.toString(dgfFglPreDtls.getNationalId()));
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// Get workflow task comments
		String comments = DgfFglPreDtlsLocalServiceUtil
				.getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(dgfFglPreDtls, nodeId);
		// send user sms notification with comments
		String licenseMessage = licenseMessageUtil.getLicenseAcfRejectMessage();
		String message = licenseMessage + " #" + dgfFglPreDtls.getFglApplicationNo() + " " + comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message,
				dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),
				Long.parseLong(dgfFglPreDtls.getFglApplicationNo()));
		log.info("DgfFglPreDtlsLocalServiceImpl.sendAcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId END");
	}

	public void sendUcfOrDcfPaymentRequestSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info(
				"DgfFglPreDtlsLocalServiceImpl.sendUcfOrDcfPaymentRequestSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfUsers dgfUsers = null;
		try {
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(classPk);
			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(Long.toString(dgfFglPreDtls.getNationalId()));
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// Get workflow task comments
		String comments = DgfFglPreDtlsLocalServiceUtil
				.getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(dgfFglPreDtls, nodeId);
		// send user sms notification with comments
		String licenseMessage = licenseMessageUtil.getLicensePaymentRequestMessage();
		String message = licenseMessage + " #" + dgfFglPreDtls.getFglApplicationNo() + " " + comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message,
				dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),
				Long.parseLong(dgfFglPreDtls.getFglApplicationNo()));
		log.info(
				"DgfFglPreDtlsLocalServiceImpl.sendUcfOrDcfPaymentRequestSmsWithWorkflowCommentsByClassPkAndNodeId END");
	}

	public void sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfFglPreDtlsLocalServiceImpl.sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfUsers dgfUsers = null;
		try {
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(classPk);
			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(Long.toString(dgfFglPreDtls.getNationalId()));
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// Get workflow task comments
		String comments = DgfFglPreDtlsLocalServiceUtil
				.getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(dgfFglPreDtls, nodeId);
		// send user sms notification with comments
		String licenseMessage = licenseMessageUtil.getLicenseUcfApproveMessage();
		String message = licenseMessage + " #" + dgfFglPreDtls.getFglApplicationNo() + " " + comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message,
				dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),
				Long.parseLong(dgfFglPreDtls.getFglApplicationNo()));
		log.info("DgfFglPreDtlsLocalServiceImpl.sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId END");
	}

	public void sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfFglPreDtlsLocalServiceImpl.sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfUsers dgfUsers = null;
		try {
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(classPk);
			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(Long.toString(dgfFglPreDtls.getNationalId()));
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// Get workflow task comments
		String comments = DgfFglPreDtlsLocalServiceUtil
				.getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(dgfFglPreDtls, nodeId);
		// send user sms notification with comments
		String licenseMessage = licenseMessageUtil.getLicenseUcfRejectMessage();
		String message = licenseMessage + " #" + dgfFglPreDtls.getFglApplicationNo() + " " + comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message,
				dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),
				Long.parseLong(dgfFglPreDtls.getFglApplicationNo()));
		log.info("DgfFglPreDtlsLocalServiceImpl.sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId END");
	}

	public void sendDcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfFglPreDtlsLocalServiceImpl.sendDcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfUsers dgfUsers = null;
		try {
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(classPk);
			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(Long.toString(dgfFglPreDtls.getNationalId()));
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// Get workflow task comments
		String comments = DgfFglPreDtlsLocalServiceUtil
				.getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(dgfFglPreDtls, nodeId);
		// send user sms notification with comments
		String licenseMessage = licenseMessageUtil.getLicenseDcfApproveMessage();
		String message = licenseMessage + " #" + dgfFglPreDtls.getFglApplicationNo() + " " + comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message,
				dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),
				Long.parseLong(dgfFglPreDtls.getFglApplicationNo()));
		log.info("DgfFglPreDtlsLocalServiceImpl.sendDcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId END");
	}

	public void sendDcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfFglPreDtlsLocalServiceImpl.sendDcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfUsers dgfUsers = null;
		try {
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(classPk);
			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(Long.toString(dgfFglPreDtls.getNationalId()));
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// Get workflow task comments
		String comments = DgfFglPreDtlsLocalServiceUtil
				.getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(dgfFglPreDtls, nodeId);
		// send user sms notification with comments
		String licenseMessage = licenseMessageUtil.getLicenseDcfRejectMessage();
		String message = licenseMessage + " #" + dgfFglPreDtls.getFglApplicationNo() + " " + comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message,
				dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),
				Long.parseLong(dgfFglPreDtls.getFglApplicationNo()));
		log.info("DgfFglPreDtlsLocalServiceImpl.sendDcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId END");
	}
	
	public void sendCcdrApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfFglPreDtlsLocalServiceImpl.sendCcdrApprovedSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfUsers dgfUsers = null;
		try {
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(classPk);
			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(Long.toString(dgfFglPreDtls.getNationalId()));
		}catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// Get workflow task comments
		String comments = DgfFglPreDtlsLocalServiceUtil.getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(dgfFglPreDtls, nodeId);
		// send user sms notification with comments
		String licenseMessage = licenseMessageUtil.getLicenseCcdrApproveMessage();
		String message = licenseMessage+" #"+dgfFglPreDtls.getFglApplicationNo()+" "+comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message, dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),Long.parseLong(dgfFglPreDtls.getFglApplicationNo()));
		log.info("DgfFglPreDtlsLocalServiceImpl.sendCcdrApprovedSmsWithWorkflowCommentsByClassPkAndNodeId END");
	}
	
	public void sendCcdrRejectSmsWithWorkflowCommentsByClassPkAndNodeId(long classPk, String nodeId) {
		log.info("DgfFglPreDtlsLocalServiceImpl.sendCcdrRejectSmsWithWorkflowCommentsByClassPkAndNodeId START");
		// get license and user object
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfUsers dgfUsers = null;
		try {
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(classPk);
			dgfUsers = DgfUsersLocalServiceUtil.getDgfUsersByNid(Long.toString(dgfFglPreDtls.getNationalId()));
		}catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// Get workflow task comments
		String comments = DgfFglPreDtlsLocalServiceUtil.getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(dgfFglPreDtls, nodeId);	
		// send user sms notification with comments
		String licenseMessage = licenseMessageUtil.getLicenseCcdrRejectMessage();
		String message = licenseMessage+" #"+dgfFglPreDtls.getFglApplicationNo()+" "+comments;
		DgfUsersOtpDetailsLocalServiceUtil.addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(message, dgfUsers.getNationalId(), dgfUsers.getMobileNo(), dgfUsers.getUserId(),Long.parseLong(dgfFglPreDtls.getFglApplicationNo()));
		log.info("DgfFglPreDtlsLocalServiceImpl.sendCcdrRejectSmsWithWorkflowCommentsByClassPkAndNodeId END");
	}
	
	public String getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(DgfFglPreDtls dgfFglPreDtls, String nodeId) {
		log.info("DgfFglPreDtlsLocalServiceImpl.getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId START");
		WorkflowInstanceLink workflowInstanceLink = null;
		String comments = "";
		try {
			workflowInstanceLink = DgfFglPreDtlsLocalServiceUtil
					.getWorkflowInstanceLinkByUserId(dgfFglPreDtls.getUserId(), dgfFglPreDtls.getPrimaryKey());
			// find workflow comments from KaleoLog
			DynamicQuery dynamicQuery = KaleoLogLocalServiceUtil.dynamicQuery();
			dynamicQuery
					.add(RestrictionsFactoryUtil.eq("kaleoInstanceId", workflowInstanceLink.getWorkflowInstanceId()));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("kaleoNodeName", nodeId));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("type", "TASK_COMPLETION"));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("companyId", dgfFglPreDtls.getCompanyId()));
			List<KaleoLog> kaleoLogList = KaleoLogLocalServiceUtil.dynamicQuery(dynamicQuery);
			if (Validator.isNotNull(kaleoLogList) && kaleoLogList.size() > 0) {
				for (KaleoLog kaleoLog : kaleoLogList) {
					comments = kaleoLog.getComment();
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		log.info("DgfFglPreDtlsLocalServiceImpl.getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId END");
		return comments;
	}

	public void generateLicenseNumberAndStoreData(long classPk) {
		log.info("DgfFglPreDtlsLocalServiceImpl.generateLicenseNumberAndStoreData START");
		DgfFglPreDtls dgfFglPreDtls = null;
		DgfFglLicDtls dgfFglLicDtls = null;
		DgfFglLicenseNo dgfFglLicenseNo = null;
		String licenseNo = "";
		try {
			dgfFglPreDtls = DgfFglPreDtlsLocalServiceUtil.getDgfFglPreDtls(classPk);
			dgfFglLicDtls = DgfFglLicDtlsLocalServiceUtil
					.getDgfFglLicDtlsByFglPrePrimaryId(dgfFglPreDtls.getFglPrePrimaryId());
			// generate license number
			dgfFglLicenseNo = DgfFglLicenseNoLocalServiceUtil.generatedDgfFglLicenseNo();
			// it will be change based on requirement currently its 13 degit
			licenseNo = String.valueOf(dgfFglLicenseNo.getPrefix()) + "/" + String.valueOf(dgfFglLicenseNo.getSuffix())
					+ "/" + dgfFglLicenseNo.getLicenseNo();
			// generate qrscan
			// user activation
			User user = UserLocalServiceUtil.getUser(dgfFglPreDtls.getUserId());
			user.setStatus(WorkflowConstants.STATUS_APPROVED);
			UserLocalServiceUtil.updateUser(user);
			// update license info
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

			dgfFglLicDtls.setFoodgrainLicenseNo(licenseNo);
			dgfFglLicDtls.setFoodgrainLicenseIssueDate(currentDate);
			dgfFglLicDtls.setFoodgrainLicenseExpiryDate(nextYearDate);
			DgfFglLicDtlsLocalServiceUtil.updateDgfFglLicDtls(dgfFglLicDtls);

		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		log.info("DgfFglPreDtlsLocalServiceImpl.generateLicenseNumberAndStoreData END");
	}

	public byte[] getLicenseReport(String queryParams) {
		return generateLicenseReportUtil.getLicenseReport(queryParams);
	}

	public String getLicenseFormSubmitMessage() {
		return licenseMessageUtil.getLicenseFormSubmitMessage();
	}

	public String getRenewLicenseFormSubmitMessage() {
		return licenseMessageUtil.getRenewLicenseFormSubmitMessage();
	}

	public String getDuplicateLicenseFormSubmitMessage() {
		return licenseMessageUtil.getDuplicateLicenseFormSubmitMessage();
	}

}