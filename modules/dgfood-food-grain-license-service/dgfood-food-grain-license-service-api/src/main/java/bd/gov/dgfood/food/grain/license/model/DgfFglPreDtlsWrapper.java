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

package bd.gov.dgfood.food.grain.license.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DgfFglPreDtls}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfFglPreDtls
 * @generated
 */
public class DgfFglPreDtlsWrapper
	extends BaseModelWrapper<DgfFglPreDtls>
	implements DgfFglPreDtls, ModelWrapper<DgfFglPreDtls> {

	public DgfFglPreDtlsWrapper(DgfFglPreDtls dgfFglPreDtls) {
		super(dgfFglPreDtls);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("fglPrePrimaryId", getFglPrePrimaryId());
		attributes.put("nationalId", getNationalId());
		attributes.put("fglApplicationNo", getFglApplicationNo());
		attributes.put("applicantName", getApplicantName());
		attributes.put("tradeLicenseNo", getTradeLicenseNo());
		attributes.put("tradeLicenseExpiryDate", getTradeLicenseExpiryDate());
		attributes.put("tradeLicenseIssuerCode", getTradeLicenseIssuerCode());
		attributes.put("tradeLicenseIssuerCity", getTradeLicenseIssuerCity());
		attributes.put(
			"businessIdentificationNo", getBusinessIdentificationNo());
		attributes.put("taxIdentificationNo", getTaxIdentificationNo());
		attributes.put("businessName", getBusinessName());
		attributes.put("businessType", getBusinessType());
		attributes.put("paymentChallanId", getPaymentChallanId());
		attributes.put("paymentStatus", getPaymentStatus());
		attributes.put("reviewComments", getReviewComments());
		attributes.put("applicationStatus", getApplicationStatus());
		attributes.put("applicationStatusDate", getApplicationStatusDate());
		attributes.put(
			"duplicateLicenseReasonId", getDuplicateLicenseReasonId());
		attributes.put("comments", getComments());
		attributes.put("fglLicenseVersion", getFglLicenseVersion());
		attributes.put("foodGrainLicenseType", getFoodGrainLicenseType());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("applicationStatusById", getApplicationStatusById());
		attributes.put("presentAddrId", getPresentAddrId());
		attributes.put("bussinessAddrId", getBussinessAddrId());
		attributes.put("tradeLicenseDocId", getTradeLicenseDocId());
		attributes.put("bussIdentfctDocId", getBussIdentfctDocId());
		attributes.put("taxIdentfctDocId", getTaxIdentfctDocId());
		attributes.put("bnkStatmtDocId", getBnkStatmtDocId());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("userId", getUserId());
		attributes.put("birthDate", getBirthDate());
		attributes.put("fglApplicationType", getFglApplicationType());
		attributes.put("photographDocId", getPhotographDocId());
		attributes.put("otherReleventDocId", getOtherReleventDocId());
		attributes.put("electricExemptionMemoId", getElectricExemptionMemoId());
		attributes.put("envClrMemoId", getEnvClrMemoId());
		attributes.put("bstiClrMemoId", getBstiClrMemoId());
		attributes.put("fireLicNumDocId", getFireLicNumDocId());
		attributes.put("productType", getProductType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long fglPrePrimaryId = (Long)attributes.get("fglPrePrimaryId");

		if (fglPrePrimaryId != null) {
			setFglPrePrimaryId(fglPrePrimaryId);
		}

		Long nationalId = (Long)attributes.get("nationalId");

		if (nationalId != null) {
			setNationalId(nationalId);
		}

		String fglApplicationNo = (String)attributes.get("fglApplicationNo");

		if (fglApplicationNo != null) {
			setFglApplicationNo(fglApplicationNo);
		}

		String applicantName = (String)attributes.get("applicantName");

		if (applicantName != null) {
			setApplicantName(applicantName);
		}

		String tradeLicenseNo = (String)attributes.get("tradeLicenseNo");

		if (tradeLicenseNo != null) {
			setTradeLicenseNo(tradeLicenseNo);
		}

		Date tradeLicenseExpiryDate = (Date)attributes.get(
			"tradeLicenseExpiryDate");

		if (tradeLicenseExpiryDate != null) {
			setTradeLicenseExpiryDate(tradeLicenseExpiryDate);
		}

		String tradeLicenseIssuerCode = (String)attributes.get(
			"tradeLicenseIssuerCode");

		if (tradeLicenseIssuerCode != null) {
			setTradeLicenseIssuerCode(tradeLicenseIssuerCode);
		}

		String tradeLicenseIssuerCity = (String)attributes.get(
			"tradeLicenseIssuerCity");

		if (tradeLicenseIssuerCity != null) {
			setTradeLicenseIssuerCity(tradeLicenseIssuerCity);
		}

		String businessIdentificationNo = (String)attributes.get(
			"businessIdentificationNo");

		if (businessIdentificationNo != null) {
			setBusinessIdentificationNo(businessIdentificationNo);
		}

		String taxIdentificationNo = (String)attributes.get(
			"taxIdentificationNo");

		if (taxIdentificationNo != null) {
			setTaxIdentificationNo(taxIdentificationNo);
		}

		String businessName = (String)attributes.get("businessName");

		if (businessName != null) {
			setBusinessName(businessName);
		}

		String businessType = (String)attributes.get("businessType");

		if (businessType != null) {
			setBusinessType(businessType);
		}

		Long paymentChallanId = (Long)attributes.get("paymentChallanId");

		if (paymentChallanId != null) {
			setPaymentChallanId(paymentChallanId);
		}

		Long paymentStatus = (Long)attributes.get("paymentStatus");

		if (paymentStatus != null) {
			setPaymentStatus(paymentStatus);
		}

		String reviewComments = (String)attributes.get("reviewComments");

		if (reviewComments != null) {
			setReviewComments(reviewComments);
		}

		Long applicationStatus = (Long)attributes.get("applicationStatus");

		if (applicationStatus != null) {
			setApplicationStatus(applicationStatus);
		}

		Date applicationStatusDate = (Date)attributes.get(
			"applicationStatusDate");

		if (applicationStatusDate != null) {
			setApplicationStatusDate(applicationStatusDate);
		}

		Long duplicateLicenseReasonId = (Long)attributes.get(
			"duplicateLicenseReasonId");

		if (duplicateLicenseReasonId != null) {
			setDuplicateLicenseReasonId(duplicateLicenseReasonId);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		Long fglLicenseVersion = (Long)attributes.get("fglLicenseVersion");

		if (fglLicenseVersion != null) {
			setFglLicenseVersion(fglLicenseVersion);
		}

		String foodGrainLicenseType = (String)attributes.get(
			"foodGrainLicenseType");

		if (foodGrainLicenseType != null) {
			setFoodGrainLicenseType(foodGrainLicenseType);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long applicationStatusById = (Long)attributes.get(
			"applicationStatusById");

		if (applicationStatusById != null) {
			setApplicationStatusById(applicationStatusById);
		}

		Long presentAddrId = (Long)attributes.get("presentAddrId");

		if (presentAddrId != null) {
			setPresentAddrId(presentAddrId);
		}

		Long bussinessAddrId = (Long)attributes.get("bussinessAddrId");

		if (bussinessAddrId != null) {
			setBussinessAddrId(bussinessAddrId);
		}

		Long tradeLicenseDocId = (Long)attributes.get("tradeLicenseDocId");

		if (tradeLicenseDocId != null) {
			setTradeLicenseDocId(tradeLicenseDocId);
		}

		Long bussIdentfctDocId = (Long)attributes.get("bussIdentfctDocId");

		if (bussIdentfctDocId != null) {
			setBussIdentfctDocId(bussIdentfctDocId);
		}

		Long taxIdentfctDocId = (Long)attributes.get("taxIdentfctDocId");

		if (taxIdentfctDocId != null) {
			setTaxIdentfctDocId(taxIdentfctDocId);
		}

		Long bnkStatmtDocId = (Long)attributes.get("bnkStatmtDocId");

		if (bnkStatmtDocId != null) {
			setBnkStatmtDocId(bnkStatmtDocId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date birthDate = (Date)attributes.get("birthDate");

		if (birthDate != null) {
			setBirthDate(birthDate);
		}

		String fglApplicationType = (String)attributes.get(
			"fglApplicationType");

		if (fglApplicationType != null) {
			setFglApplicationType(fglApplicationType);
		}

		Long photographDocId = (Long)attributes.get("photographDocId");

		if (photographDocId != null) {
			setPhotographDocId(photographDocId);
		}

		Long otherReleventDocId = (Long)attributes.get("otherReleventDocId");

		if (otherReleventDocId != null) {
			setOtherReleventDocId(otherReleventDocId);
		}

		Long electricExemptionMemoId = (Long)attributes.get(
			"electricExemptionMemoId");

		if (electricExemptionMemoId != null) {
			setElectricExemptionMemoId(electricExemptionMemoId);
		}

		Long envClrMemoId = (Long)attributes.get("envClrMemoId");

		if (envClrMemoId != null) {
			setEnvClrMemoId(envClrMemoId);
		}

		Long bstiClrMemoId = (Long)attributes.get("bstiClrMemoId");

		if (bstiClrMemoId != null) {
			setBstiClrMemoId(bstiClrMemoId);
		}

		Long fireLicNumDocId = (Long)attributes.get("fireLicNumDocId");

		if (fireLicNumDocId != null) {
			setFireLicNumDocId(fireLicNumDocId);
		}

		String productType = (String)attributes.get("productType");

		if (productType != null) {
			setProductType(productType);
		}
	}

	@Override
	public DgfFglPreDtls cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the applicant name of this dgf fgl pre dtls.
	 *
	 * @return the applicant name of this dgf fgl pre dtls
	 */
	@Override
	public String getApplicantName() {
		return model.getApplicantName();
	}

	/**
	 * Returns the application status of this dgf fgl pre dtls.
	 *
	 * @return the application status of this dgf fgl pre dtls
	 */
	@Override
	public long getApplicationStatus() {
		return model.getApplicationStatus();
	}

	/**
	 * Returns the application status by ID of this dgf fgl pre dtls.
	 *
	 * @return the application status by ID of this dgf fgl pre dtls
	 */
	@Override
	public long getApplicationStatusById() {
		return model.getApplicationStatusById();
	}

	/**
	 * Returns the application status date of this dgf fgl pre dtls.
	 *
	 * @return the application status date of this dgf fgl pre dtls
	 */
	@Override
	public Date getApplicationStatusDate() {
		return model.getApplicationStatusDate();
	}

	/**
	 * Returns the birth date of this dgf fgl pre dtls.
	 *
	 * @return the birth date of this dgf fgl pre dtls
	 */
	@Override
	public Date getBirthDate() {
		return model.getBirthDate();
	}

	/**
	 * Returns the bnk statmt doc ID of this dgf fgl pre dtls.
	 *
	 * @return the bnk statmt doc ID of this dgf fgl pre dtls
	 */
	@Override
	public long getBnkStatmtDocId() {
		return model.getBnkStatmtDocId();
	}

	/**
	 * Returns the bsti clr memo ID of this dgf fgl pre dtls.
	 *
	 * @return the bsti clr memo ID of this dgf fgl pre dtls
	 */
	@Override
	public long getBstiClrMemoId() {
		return model.getBstiClrMemoId();
	}

	/**
	 * Returns the business identification no of this dgf fgl pre dtls.
	 *
	 * @return the business identification no of this dgf fgl pre dtls
	 */
	@Override
	public String getBusinessIdentificationNo() {
		return model.getBusinessIdentificationNo();
	}

	/**
	 * Returns the business name of this dgf fgl pre dtls.
	 *
	 * @return the business name of this dgf fgl pre dtls
	 */
	@Override
	public String getBusinessName() {
		return model.getBusinessName();
	}

	/**
	 * Returns the business type of this dgf fgl pre dtls.
	 *
	 * @return the business type of this dgf fgl pre dtls
	 */
	@Override
	public String getBusinessType() {
		return model.getBusinessType();
	}

	/**
	 * Returns the buss identfct doc ID of this dgf fgl pre dtls.
	 *
	 * @return the buss identfct doc ID of this dgf fgl pre dtls
	 */
	@Override
	public long getBussIdentfctDocId() {
		return model.getBussIdentfctDocId();
	}

	/**
	 * Returns the bussiness addr ID of this dgf fgl pre dtls.
	 *
	 * @return the bussiness addr ID of this dgf fgl pre dtls
	 */
	@Override
	public long getBussinessAddrId() {
		return model.getBussinessAddrId();
	}

	/**
	 * Returns the comments of this dgf fgl pre dtls.
	 *
	 * @return the comments of this dgf fgl pre dtls
	 */
	@Override
	public String getComments() {
		return model.getComments();
	}

	/**
	 * Returns the company ID of this dgf fgl pre dtls.
	 *
	 * @return the company ID of this dgf fgl pre dtls
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the created date of this dgf fgl pre dtls.
	 *
	 * @return the created date of this dgf fgl pre dtls
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the duplicate license reason ID of this dgf fgl pre dtls.
	 *
	 * @return the duplicate license reason ID of this dgf fgl pre dtls
	 */
	@Override
	public long getDuplicateLicenseReasonId() {
		return model.getDuplicateLicenseReasonId();
	}

	/**
	 * Returns the electric exemption memo ID of this dgf fgl pre dtls.
	 *
	 * @return the electric exemption memo ID of this dgf fgl pre dtls
	 */
	@Override
	public long getElectricExemptionMemoId() {
		return model.getElectricExemptionMemoId();
	}

	/**
	 * Returns the env clr memo ID of this dgf fgl pre dtls.
	 *
	 * @return the env clr memo ID of this dgf fgl pre dtls
	 */
	@Override
	public long getEnvClrMemoId() {
		return model.getEnvClrMemoId();
	}

	/**
	 * Returns the fgl application no of this dgf fgl pre dtls.
	 *
	 * @return the fgl application no of this dgf fgl pre dtls
	 */
	@Override
	public String getFglApplicationNo() {
		return model.getFglApplicationNo();
	}

	/**
	 * Returns the fgl application type of this dgf fgl pre dtls.
	 *
	 * @return the fgl application type of this dgf fgl pre dtls
	 */
	@Override
	public String getFglApplicationType() {
		return model.getFglApplicationType();
	}

	/**
	 * Returns the fgl license version of this dgf fgl pre dtls.
	 *
	 * @return the fgl license version of this dgf fgl pre dtls
	 */
	@Override
	public long getFglLicenseVersion() {
		return model.getFglLicenseVersion();
	}

	/**
	 * Returns the fgl pre primary ID of this dgf fgl pre dtls.
	 *
	 * @return the fgl pre primary ID of this dgf fgl pre dtls
	 */
	@Override
	public long getFglPrePrimaryId() {
		return model.getFglPrePrimaryId();
	}

	/**
	 * Returns the fire lic num doc ID of this dgf fgl pre dtls.
	 *
	 * @return the fire lic num doc ID of this dgf fgl pre dtls
	 */
	@Override
	public long getFireLicNumDocId() {
		return model.getFireLicNumDocId();
	}

	/**
	 * Returns the food grain license type of this dgf fgl pre dtls.
	 *
	 * @return the food grain license type of this dgf fgl pre dtls
	 */
	@Override
	public String getFoodGrainLicenseType() {
		return model.getFoodGrainLicenseType();
	}

	/**
	 * Returns the group ID of this dgf fgl pre dtls.
	 *
	 * @return the group ID of this dgf fgl pre dtls
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified by of this dgf fgl pre dtls.
	 *
	 * @return the modified by of this dgf fgl pre dtls
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this dgf fgl pre dtls.
	 *
	 * @return the modified date of this dgf fgl pre dtls
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the national ID of this dgf fgl pre dtls.
	 *
	 * @return the national ID of this dgf fgl pre dtls
	 */
	@Override
	public long getNationalId() {
		return model.getNationalId();
	}

	/**
	 * Returns the other relevent doc ID of this dgf fgl pre dtls.
	 *
	 * @return the other relevent doc ID of this dgf fgl pre dtls
	 */
	@Override
	public long getOtherReleventDocId() {
		return model.getOtherReleventDocId();
	}

	/**
	 * Returns the payment challan ID of this dgf fgl pre dtls.
	 *
	 * @return the payment challan ID of this dgf fgl pre dtls
	 */
	@Override
	public long getPaymentChallanId() {
		return model.getPaymentChallanId();
	}

	/**
	 * Returns the payment status of this dgf fgl pre dtls.
	 *
	 * @return the payment status of this dgf fgl pre dtls
	 */
	@Override
	public long getPaymentStatus() {
		return model.getPaymentStatus();
	}

	/**
	 * Returns the photograph doc ID of this dgf fgl pre dtls.
	 *
	 * @return the photograph doc ID of this dgf fgl pre dtls
	 */
	@Override
	public long getPhotographDocId() {
		return model.getPhotographDocId();
	}

	/**
	 * Returns the present addr ID of this dgf fgl pre dtls.
	 *
	 * @return the present addr ID of this dgf fgl pre dtls
	 */
	@Override
	public long getPresentAddrId() {
		return model.getPresentAddrId();
	}

	/**
	 * Returns the primary key of this dgf fgl pre dtls.
	 *
	 * @return the primary key of this dgf fgl pre dtls
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product type of this dgf fgl pre dtls.
	 *
	 * @return the product type of this dgf fgl pre dtls
	 */
	@Override
	public String getProductType() {
		return model.getProductType();
	}

	/**
	 * Returns the review comments of this dgf fgl pre dtls.
	 *
	 * @return the review comments of this dgf fgl pre dtls
	 */
	@Override
	public String getReviewComments() {
		return model.getReviewComments();
	}

	/**
	 * Returns the status of this dgf fgl pre dtls.
	 *
	 * @return the status of this dgf fgl pre dtls
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this dgf fgl pre dtls.
	 *
	 * @return the status by user ID of this dgf fgl pre dtls
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this dgf fgl pre dtls.
	 *
	 * @return the status by user name of this dgf fgl pre dtls
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this dgf fgl pre dtls.
	 *
	 * @return the status by user uuid of this dgf fgl pre dtls
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this dgf fgl pre dtls.
	 *
	 * @return the status date of this dgf fgl pre dtls
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the tax identfct doc ID of this dgf fgl pre dtls.
	 *
	 * @return the tax identfct doc ID of this dgf fgl pre dtls
	 */
	@Override
	public long getTaxIdentfctDocId() {
		return model.getTaxIdentfctDocId();
	}

	/**
	 * Returns the tax identification no of this dgf fgl pre dtls.
	 *
	 * @return the tax identification no of this dgf fgl pre dtls
	 */
	@Override
	public String getTaxIdentificationNo() {
		return model.getTaxIdentificationNo();
	}

	/**
	 * Returns the trade license doc ID of this dgf fgl pre dtls.
	 *
	 * @return the trade license doc ID of this dgf fgl pre dtls
	 */
	@Override
	public long getTradeLicenseDocId() {
		return model.getTradeLicenseDocId();
	}

	/**
	 * Returns the trade license expiry date of this dgf fgl pre dtls.
	 *
	 * @return the trade license expiry date of this dgf fgl pre dtls
	 */
	@Override
	public Date getTradeLicenseExpiryDate() {
		return model.getTradeLicenseExpiryDate();
	}

	/**
	 * Returns the trade license issuer city of this dgf fgl pre dtls.
	 *
	 * @return the trade license issuer city of this dgf fgl pre dtls
	 */
	@Override
	public String getTradeLicenseIssuerCity() {
		return model.getTradeLicenseIssuerCity();
	}

	/**
	 * Returns the trade license issuer code of this dgf fgl pre dtls.
	 *
	 * @return the trade license issuer code of this dgf fgl pre dtls
	 */
	@Override
	public String getTradeLicenseIssuerCode() {
		return model.getTradeLicenseIssuerCode();
	}

	/**
	 * Returns the trade license no of this dgf fgl pre dtls.
	 *
	 * @return the trade license no of this dgf fgl pre dtls
	 */
	@Override
	public String getTradeLicenseNo() {
		return model.getTradeLicenseNo();
	}

	/**
	 * Returns the user ID of this dgf fgl pre dtls.
	 *
	 * @return the user ID of this dgf fgl pre dtls
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this dgf fgl pre dtls.
	 *
	 * @return the user uuid of this dgf fgl pre dtls
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this dgf fgl pre dtls is approved.
	 *
	 * @return <code>true</code> if this dgf fgl pre dtls is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this dgf fgl pre dtls is denied.
	 *
	 * @return <code>true</code> if this dgf fgl pre dtls is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this dgf fgl pre dtls is a draft.
	 *
	 * @return <code>true</code> if this dgf fgl pre dtls is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this dgf fgl pre dtls is expired.
	 *
	 * @return <code>true</code> if this dgf fgl pre dtls is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this dgf fgl pre dtls is inactive.
	 *
	 * @return <code>true</code> if this dgf fgl pre dtls is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this dgf fgl pre dtls is incomplete.
	 *
	 * @return <code>true</code> if this dgf fgl pre dtls is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this dgf fgl pre dtls is pending.
	 *
	 * @return <code>true</code> if this dgf fgl pre dtls is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this dgf fgl pre dtls is scheduled.
	 *
	 * @return <code>true</code> if this dgf fgl pre dtls is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the applicant name of this dgf fgl pre dtls.
	 *
	 * @param applicantName the applicant name of this dgf fgl pre dtls
	 */
	@Override
	public void setApplicantName(String applicantName) {
		model.setApplicantName(applicantName);
	}

	/**
	 * Sets the application status of this dgf fgl pre dtls.
	 *
	 * @param applicationStatus the application status of this dgf fgl pre dtls
	 */
	@Override
	public void setApplicationStatus(long applicationStatus) {
		model.setApplicationStatus(applicationStatus);
	}

	/**
	 * Sets the application status by ID of this dgf fgl pre dtls.
	 *
	 * @param applicationStatusById the application status by ID of this dgf fgl pre dtls
	 */
	@Override
	public void setApplicationStatusById(long applicationStatusById) {
		model.setApplicationStatusById(applicationStatusById);
	}

	/**
	 * Sets the application status date of this dgf fgl pre dtls.
	 *
	 * @param applicationStatusDate the application status date of this dgf fgl pre dtls
	 */
	@Override
	public void setApplicationStatusDate(Date applicationStatusDate) {
		model.setApplicationStatusDate(applicationStatusDate);
	}

	/**
	 * Sets the birth date of this dgf fgl pre dtls.
	 *
	 * @param birthDate the birth date of this dgf fgl pre dtls
	 */
	@Override
	public void setBirthDate(Date birthDate) {
		model.setBirthDate(birthDate);
	}

	/**
	 * Sets the bnk statmt doc ID of this dgf fgl pre dtls.
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID of this dgf fgl pre dtls
	 */
	@Override
	public void setBnkStatmtDocId(long bnkStatmtDocId) {
		model.setBnkStatmtDocId(bnkStatmtDocId);
	}

	/**
	 * Sets the bsti clr memo ID of this dgf fgl pre dtls.
	 *
	 * @param bstiClrMemoId the bsti clr memo ID of this dgf fgl pre dtls
	 */
	@Override
	public void setBstiClrMemoId(long bstiClrMemoId) {
		model.setBstiClrMemoId(bstiClrMemoId);
	}

	/**
	 * Sets the business identification no of this dgf fgl pre dtls.
	 *
	 * @param businessIdentificationNo the business identification no of this dgf fgl pre dtls
	 */
	@Override
	public void setBusinessIdentificationNo(String businessIdentificationNo) {
		model.setBusinessIdentificationNo(businessIdentificationNo);
	}

	/**
	 * Sets the business name of this dgf fgl pre dtls.
	 *
	 * @param businessName the business name of this dgf fgl pre dtls
	 */
	@Override
	public void setBusinessName(String businessName) {
		model.setBusinessName(businessName);
	}

	/**
	 * Sets the business type of this dgf fgl pre dtls.
	 *
	 * @param businessType the business type of this dgf fgl pre dtls
	 */
	@Override
	public void setBusinessType(String businessType) {
		model.setBusinessType(businessType);
	}

	/**
	 * Sets the buss identfct doc ID of this dgf fgl pre dtls.
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID of this dgf fgl pre dtls
	 */
	@Override
	public void setBussIdentfctDocId(long bussIdentfctDocId) {
		model.setBussIdentfctDocId(bussIdentfctDocId);
	}

	/**
	 * Sets the bussiness addr ID of this dgf fgl pre dtls.
	 *
	 * @param bussinessAddrId the bussiness addr ID of this dgf fgl pre dtls
	 */
	@Override
	public void setBussinessAddrId(long bussinessAddrId) {
		model.setBussinessAddrId(bussinessAddrId);
	}

	/**
	 * Sets the comments of this dgf fgl pre dtls.
	 *
	 * @param comments the comments of this dgf fgl pre dtls
	 */
	@Override
	public void setComments(String comments) {
		model.setComments(comments);
	}

	/**
	 * Sets the company ID of this dgf fgl pre dtls.
	 *
	 * @param companyId the company ID of this dgf fgl pre dtls
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the created date of this dgf fgl pre dtls.
	 *
	 * @param createdDate the created date of this dgf fgl pre dtls
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the duplicate license reason ID of this dgf fgl pre dtls.
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID of this dgf fgl pre dtls
	 */
	@Override
	public void setDuplicateLicenseReasonId(long duplicateLicenseReasonId) {
		model.setDuplicateLicenseReasonId(duplicateLicenseReasonId);
	}

	/**
	 * Sets the electric exemption memo ID of this dgf fgl pre dtls.
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID of this dgf fgl pre dtls
	 */
	@Override
	public void setElectricExemptionMemoId(long electricExemptionMemoId) {
		model.setElectricExemptionMemoId(electricExemptionMemoId);
	}

	/**
	 * Sets the env clr memo ID of this dgf fgl pre dtls.
	 *
	 * @param envClrMemoId the env clr memo ID of this dgf fgl pre dtls
	 */
	@Override
	public void setEnvClrMemoId(long envClrMemoId) {
		model.setEnvClrMemoId(envClrMemoId);
	}

	/**
	 * Sets the fgl application no of this dgf fgl pre dtls.
	 *
	 * @param fglApplicationNo the fgl application no of this dgf fgl pre dtls
	 */
	@Override
	public void setFglApplicationNo(String fglApplicationNo) {
		model.setFglApplicationNo(fglApplicationNo);
	}

	/**
	 * Sets the fgl application type of this dgf fgl pre dtls.
	 *
	 * @param fglApplicationType the fgl application type of this dgf fgl pre dtls
	 */
	@Override
	public void setFglApplicationType(String fglApplicationType) {
		model.setFglApplicationType(fglApplicationType);
	}

	/**
	 * Sets the fgl license version of this dgf fgl pre dtls.
	 *
	 * @param fglLicenseVersion the fgl license version of this dgf fgl pre dtls
	 */
	@Override
	public void setFglLicenseVersion(long fglLicenseVersion) {
		model.setFglLicenseVersion(fglLicenseVersion);
	}

	/**
	 * Sets the fgl pre primary ID of this dgf fgl pre dtls.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID of this dgf fgl pre dtls
	 */
	@Override
	public void setFglPrePrimaryId(long fglPrePrimaryId) {
		model.setFglPrePrimaryId(fglPrePrimaryId);
	}

	/**
	 * Sets the fire lic num doc ID of this dgf fgl pre dtls.
	 *
	 * @param fireLicNumDocId the fire lic num doc ID of this dgf fgl pre dtls
	 */
	@Override
	public void setFireLicNumDocId(long fireLicNumDocId) {
		model.setFireLicNumDocId(fireLicNumDocId);
	}

	/**
	 * Sets the food grain license type of this dgf fgl pre dtls.
	 *
	 * @param foodGrainLicenseType the food grain license type of this dgf fgl pre dtls
	 */
	@Override
	public void setFoodGrainLicenseType(String foodGrainLicenseType) {
		model.setFoodGrainLicenseType(foodGrainLicenseType);
	}

	/**
	 * Sets the group ID of this dgf fgl pre dtls.
	 *
	 * @param groupId the group ID of this dgf fgl pre dtls
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified by of this dgf fgl pre dtls.
	 *
	 * @param modifiedBy the modified by of this dgf fgl pre dtls
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this dgf fgl pre dtls.
	 *
	 * @param modifiedDate the modified date of this dgf fgl pre dtls
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the national ID of this dgf fgl pre dtls.
	 *
	 * @param nationalId the national ID of this dgf fgl pre dtls
	 */
	@Override
	public void setNationalId(long nationalId) {
		model.setNationalId(nationalId);
	}

	/**
	 * Sets the other relevent doc ID of this dgf fgl pre dtls.
	 *
	 * @param otherReleventDocId the other relevent doc ID of this dgf fgl pre dtls
	 */
	@Override
	public void setOtherReleventDocId(long otherReleventDocId) {
		model.setOtherReleventDocId(otherReleventDocId);
	}

	/**
	 * Sets the payment challan ID of this dgf fgl pre dtls.
	 *
	 * @param paymentChallanId the payment challan ID of this dgf fgl pre dtls
	 */
	@Override
	public void setPaymentChallanId(long paymentChallanId) {
		model.setPaymentChallanId(paymentChallanId);
	}

	/**
	 * Sets the payment status of this dgf fgl pre dtls.
	 *
	 * @param paymentStatus the payment status of this dgf fgl pre dtls
	 */
	@Override
	public void setPaymentStatus(long paymentStatus) {
		model.setPaymentStatus(paymentStatus);
	}

	/**
	 * Sets the photograph doc ID of this dgf fgl pre dtls.
	 *
	 * @param photographDocId the photograph doc ID of this dgf fgl pre dtls
	 */
	@Override
	public void setPhotographDocId(long photographDocId) {
		model.setPhotographDocId(photographDocId);
	}

	/**
	 * Sets the present addr ID of this dgf fgl pre dtls.
	 *
	 * @param presentAddrId the present addr ID of this dgf fgl pre dtls
	 */
	@Override
	public void setPresentAddrId(long presentAddrId) {
		model.setPresentAddrId(presentAddrId);
	}

	/**
	 * Sets the primary key of this dgf fgl pre dtls.
	 *
	 * @param primaryKey the primary key of this dgf fgl pre dtls
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product type of this dgf fgl pre dtls.
	 *
	 * @param productType the product type of this dgf fgl pre dtls
	 */
	@Override
	public void setProductType(String productType) {
		model.setProductType(productType);
	}

	/**
	 * Sets the review comments of this dgf fgl pre dtls.
	 *
	 * @param reviewComments the review comments of this dgf fgl pre dtls
	 */
	@Override
	public void setReviewComments(String reviewComments) {
		model.setReviewComments(reviewComments);
	}

	/**
	 * Sets the status of this dgf fgl pre dtls.
	 *
	 * @param status the status of this dgf fgl pre dtls
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this dgf fgl pre dtls.
	 *
	 * @param statusByUserId the status by user ID of this dgf fgl pre dtls
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this dgf fgl pre dtls.
	 *
	 * @param statusByUserName the status by user name of this dgf fgl pre dtls
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this dgf fgl pre dtls.
	 *
	 * @param statusByUserUuid the status by user uuid of this dgf fgl pre dtls
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this dgf fgl pre dtls.
	 *
	 * @param statusDate the status date of this dgf fgl pre dtls
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the tax identfct doc ID of this dgf fgl pre dtls.
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID of this dgf fgl pre dtls
	 */
	@Override
	public void setTaxIdentfctDocId(long taxIdentfctDocId) {
		model.setTaxIdentfctDocId(taxIdentfctDocId);
	}

	/**
	 * Sets the tax identification no of this dgf fgl pre dtls.
	 *
	 * @param taxIdentificationNo the tax identification no of this dgf fgl pre dtls
	 */
	@Override
	public void setTaxIdentificationNo(String taxIdentificationNo) {
		model.setTaxIdentificationNo(taxIdentificationNo);
	}

	/**
	 * Sets the trade license doc ID of this dgf fgl pre dtls.
	 *
	 * @param tradeLicenseDocId the trade license doc ID of this dgf fgl pre dtls
	 */
	@Override
	public void setTradeLicenseDocId(long tradeLicenseDocId) {
		model.setTradeLicenseDocId(tradeLicenseDocId);
	}

	/**
	 * Sets the trade license expiry date of this dgf fgl pre dtls.
	 *
	 * @param tradeLicenseExpiryDate the trade license expiry date of this dgf fgl pre dtls
	 */
	@Override
	public void setTradeLicenseExpiryDate(Date tradeLicenseExpiryDate) {
		model.setTradeLicenseExpiryDate(tradeLicenseExpiryDate);
	}

	/**
	 * Sets the trade license issuer city of this dgf fgl pre dtls.
	 *
	 * @param tradeLicenseIssuerCity the trade license issuer city of this dgf fgl pre dtls
	 */
	@Override
	public void setTradeLicenseIssuerCity(String tradeLicenseIssuerCity) {
		model.setTradeLicenseIssuerCity(tradeLicenseIssuerCity);
	}

	/**
	 * Sets the trade license issuer code of this dgf fgl pre dtls.
	 *
	 * @param tradeLicenseIssuerCode the trade license issuer code of this dgf fgl pre dtls
	 */
	@Override
	public void setTradeLicenseIssuerCode(String tradeLicenseIssuerCode) {
		model.setTradeLicenseIssuerCode(tradeLicenseIssuerCode);
	}

	/**
	 * Sets the trade license no of this dgf fgl pre dtls.
	 *
	 * @param tradeLicenseNo the trade license no of this dgf fgl pre dtls
	 */
	@Override
	public void setTradeLicenseNo(String tradeLicenseNo) {
		model.setTradeLicenseNo(tradeLicenseNo);
	}

	/**
	 * Sets the user ID of this dgf fgl pre dtls.
	 *
	 * @param userId the user ID of this dgf fgl pre dtls
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this dgf fgl pre dtls.
	 *
	 * @param userUuid the user uuid of this dgf fgl pre dtls
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DgfFglPreDtlsWrapper wrap(DgfFglPreDtls dgfFglPreDtls) {
		return new DgfFglPreDtlsWrapper(dgfFglPreDtls);
	}

}