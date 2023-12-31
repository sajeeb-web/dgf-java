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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the DgfFglPreDtls service. Represents a row in the &quot;dgf_fgl_pre_dtls&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>bd.gov.dgfood.food.grain.license.model.impl.DgfFglPreDtlsModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>bd.gov.dgfood.food.grain.license.model.impl.DgfFglPreDtlsImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfFglPreDtls
 * @generated
 */
@ProviderType
public interface DgfFglPreDtlsModel
	extends BaseModel<DgfFglPreDtls>, ShardedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a dgf fgl pre dtls model instance should use the {@link DgfFglPreDtls} interface instead.
	 */

	/**
	 * Returns the primary key of this dgf fgl pre dtls.
	 *
	 * @return the primary key of this dgf fgl pre dtls
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this dgf fgl pre dtls.
	 *
	 * @param primaryKey the primary key of this dgf fgl pre dtls
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the fgl pre primary ID of this dgf fgl pre dtls.
	 *
	 * @return the fgl pre primary ID of this dgf fgl pre dtls
	 */
	public long getFglPrePrimaryId();

	/**
	 * Sets the fgl pre primary ID of this dgf fgl pre dtls.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID of this dgf fgl pre dtls
	 */
	public void setFglPrePrimaryId(long fglPrePrimaryId);

	/**
	 * Returns the national ID of this dgf fgl pre dtls.
	 *
	 * @return the national ID of this dgf fgl pre dtls
	 */
	public long getNationalId();

	/**
	 * Sets the national ID of this dgf fgl pre dtls.
	 *
	 * @param nationalId the national ID of this dgf fgl pre dtls
	 */
	public void setNationalId(long nationalId);

	/**
	 * Returns the fgl application no of this dgf fgl pre dtls.
	 *
	 * @return the fgl application no of this dgf fgl pre dtls
	 */
	@AutoEscape
	public String getFglApplicationNo();

	/**
	 * Sets the fgl application no of this dgf fgl pre dtls.
	 *
	 * @param fglApplicationNo the fgl application no of this dgf fgl pre dtls
	 */
	public void setFglApplicationNo(String fglApplicationNo);

	/**
	 * Returns the applicant name of this dgf fgl pre dtls.
	 *
	 * @return the applicant name of this dgf fgl pre dtls
	 */
	@AutoEscape
	public String getApplicantName();

	/**
	 * Sets the applicant name of this dgf fgl pre dtls.
	 *
	 * @param applicantName the applicant name of this dgf fgl pre dtls
	 */
	public void setApplicantName(String applicantName);

	/**
	 * Returns the trade license no of this dgf fgl pre dtls.
	 *
	 * @return the trade license no of this dgf fgl pre dtls
	 */
	@AutoEscape
	public String getTradeLicenseNo();

	/**
	 * Sets the trade license no of this dgf fgl pre dtls.
	 *
	 * @param tradeLicenseNo the trade license no of this dgf fgl pre dtls
	 */
	public void setTradeLicenseNo(String tradeLicenseNo);

	/**
	 * Returns the trade license expiry date of this dgf fgl pre dtls.
	 *
	 * @return the trade license expiry date of this dgf fgl pre dtls
	 */
	public Date getTradeLicenseExpiryDate();

	/**
	 * Sets the trade license expiry date of this dgf fgl pre dtls.
	 *
	 * @param tradeLicenseExpiryDate the trade license expiry date of this dgf fgl pre dtls
	 */
	public void setTradeLicenseExpiryDate(Date tradeLicenseExpiryDate);

	/**
	 * Returns the trade license issuer code of this dgf fgl pre dtls.
	 *
	 * @return the trade license issuer code of this dgf fgl pre dtls
	 */
	@AutoEscape
	public String getTradeLicenseIssuerCode();

	/**
	 * Sets the trade license issuer code of this dgf fgl pre dtls.
	 *
	 * @param tradeLicenseIssuerCode the trade license issuer code of this dgf fgl pre dtls
	 */
	public void setTradeLicenseIssuerCode(String tradeLicenseIssuerCode);

	/**
	 * Returns the trade license issuer city of this dgf fgl pre dtls.
	 *
	 * @return the trade license issuer city of this dgf fgl pre dtls
	 */
	@AutoEscape
	public String getTradeLicenseIssuerCity();

	/**
	 * Sets the trade license issuer city of this dgf fgl pre dtls.
	 *
	 * @param tradeLicenseIssuerCity the trade license issuer city of this dgf fgl pre dtls
	 */
	public void setTradeLicenseIssuerCity(String tradeLicenseIssuerCity);

	/**
	 * Returns the business identification no of this dgf fgl pre dtls.
	 *
	 * @return the business identification no of this dgf fgl pre dtls
	 */
	@AutoEscape
	public String getBusinessIdentificationNo();

	/**
	 * Sets the business identification no of this dgf fgl pre dtls.
	 *
	 * @param businessIdentificationNo the business identification no of this dgf fgl pre dtls
	 */
	public void setBusinessIdentificationNo(String businessIdentificationNo);

	/**
	 * Returns the tax identification no of this dgf fgl pre dtls.
	 *
	 * @return the tax identification no of this dgf fgl pre dtls
	 */
	@AutoEscape
	public String getTaxIdentificationNo();

	/**
	 * Sets the tax identification no of this dgf fgl pre dtls.
	 *
	 * @param taxIdentificationNo the tax identification no of this dgf fgl pre dtls
	 */
	public void setTaxIdentificationNo(String taxIdentificationNo);

	/**
	 * Returns the business name of this dgf fgl pre dtls.
	 *
	 * @return the business name of this dgf fgl pre dtls
	 */
	@AutoEscape
	public String getBusinessName();

	/**
	 * Sets the business name of this dgf fgl pre dtls.
	 *
	 * @param businessName the business name of this dgf fgl pre dtls
	 */
	public void setBusinessName(String businessName);

	/**
	 * Returns the business type of this dgf fgl pre dtls.
	 *
	 * @return the business type of this dgf fgl pre dtls
	 */
	@AutoEscape
	public String getBusinessType();

	/**
	 * Sets the business type of this dgf fgl pre dtls.
	 *
	 * @param businessType the business type of this dgf fgl pre dtls
	 */
	public void setBusinessType(String businessType);

	/**
	 * Returns the payment challan ID of this dgf fgl pre dtls.
	 *
	 * @return the payment challan ID of this dgf fgl pre dtls
	 */
	public long getPaymentChallanId();

	/**
	 * Sets the payment challan ID of this dgf fgl pre dtls.
	 *
	 * @param paymentChallanId the payment challan ID of this dgf fgl pre dtls
	 */
	public void setPaymentChallanId(long paymentChallanId);

	/**
	 * Returns the payment status of this dgf fgl pre dtls.
	 *
	 * @return the payment status of this dgf fgl pre dtls
	 */
	public long getPaymentStatus();

	/**
	 * Sets the payment status of this dgf fgl pre dtls.
	 *
	 * @param paymentStatus the payment status of this dgf fgl pre dtls
	 */
	public void setPaymentStatus(long paymentStatus);

	/**
	 * Returns the review comments of this dgf fgl pre dtls.
	 *
	 * @return the review comments of this dgf fgl pre dtls
	 */
	@AutoEscape
	public String getReviewComments();

	/**
	 * Sets the review comments of this dgf fgl pre dtls.
	 *
	 * @param reviewComments the review comments of this dgf fgl pre dtls
	 */
	public void setReviewComments(String reviewComments);

	/**
	 * Returns the application status of this dgf fgl pre dtls.
	 *
	 * @return the application status of this dgf fgl pre dtls
	 */
	public long getApplicationStatus();

	/**
	 * Sets the application status of this dgf fgl pre dtls.
	 *
	 * @param applicationStatus the application status of this dgf fgl pre dtls
	 */
	public void setApplicationStatus(long applicationStatus);

	/**
	 * Returns the application status date of this dgf fgl pre dtls.
	 *
	 * @return the application status date of this dgf fgl pre dtls
	 */
	public Date getApplicationStatusDate();

	/**
	 * Sets the application status date of this dgf fgl pre dtls.
	 *
	 * @param applicationStatusDate the application status date of this dgf fgl pre dtls
	 */
	public void setApplicationStatusDate(Date applicationStatusDate);

	/**
	 * Returns the duplicate license reason ID of this dgf fgl pre dtls.
	 *
	 * @return the duplicate license reason ID of this dgf fgl pre dtls
	 */
	public long getDuplicateLicenseReasonId();

	/**
	 * Sets the duplicate license reason ID of this dgf fgl pre dtls.
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID of this dgf fgl pre dtls
	 */
	public void setDuplicateLicenseReasonId(long duplicateLicenseReasonId);

	/**
	 * Returns the comments of this dgf fgl pre dtls.
	 *
	 * @return the comments of this dgf fgl pre dtls
	 */
	@AutoEscape
	public String getComments();

	/**
	 * Sets the comments of this dgf fgl pre dtls.
	 *
	 * @param comments the comments of this dgf fgl pre dtls
	 */
	public void setComments(String comments);

	/**
	 * Returns the fgl license version of this dgf fgl pre dtls.
	 *
	 * @return the fgl license version of this dgf fgl pre dtls
	 */
	public long getFglLicenseVersion();

	/**
	 * Sets the fgl license version of this dgf fgl pre dtls.
	 *
	 * @param fglLicenseVersion the fgl license version of this dgf fgl pre dtls
	 */
	public void setFglLicenseVersion(long fglLicenseVersion);

	/**
	 * Returns the food grain license type of this dgf fgl pre dtls.
	 *
	 * @return the food grain license type of this dgf fgl pre dtls
	 */
	@AutoEscape
	public String getFoodGrainLicenseType();

	/**
	 * Sets the food grain license type of this dgf fgl pre dtls.
	 *
	 * @param foodGrainLicenseType the food grain license type of this dgf fgl pre dtls
	 */
	public void setFoodGrainLicenseType(String foodGrainLicenseType);

	/**
	 * Returns the group ID of this dgf fgl pre dtls.
	 *
	 * @return the group ID of this dgf fgl pre dtls
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this dgf fgl pre dtls.
	 *
	 * @param groupId the group ID of this dgf fgl pre dtls
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this dgf fgl pre dtls.
	 *
	 * @return the company ID of this dgf fgl pre dtls
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this dgf fgl pre dtls.
	 *
	 * @param companyId the company ID of this dgf fgl pre dtls
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the created date of this dgf fgl pre dtls.
	 *
	 * @return the created date of this dgf fgl pre dtls
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this dgf fgl pre dtls.
	 *
	 * @param createdDate the created date of this dgf fgl pre dtls
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the modified by of this dgf fgl pre dtls.
	 *
	 * @return the modified by of this dgf fgl pre dtls
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this dgf fgl pre dtls.
	 *
	 * @param modifiedBy the modified by of this dgf fgl pre dtls
	 */
	public void setModifiedBy(long modifiedBy);

	/**
	 * Returns the modified date of this dgf fgl pre dtls.
	 *
	 * @return the modified date of this dgf fgl pre dtls
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this dgf fgl pre dtls.
	 *
	 * @param modifiedDate the modified date of this dgf fgl pre dtls
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the application status by ID of this dgf fgl pre dtls.
	 *
	 * @return the application status by ID of this dgf fgl pre dtls
	 */
	public long getApplicationStatusById();

	/**
	 * Sets the application status by ID of this dgf fgl pre dtls.
	 *
	 * @param applicationStatusById the application status by ID of this dgf fgl pre dtls
	 */
	public void setApplicationStatusById(long applicationStatusById);

	/**
	 * Returns the present addr ID of this dgf fgl pre dtls.
	 *
	 * @return the present addr ID of this dgf fgl pre dtls
	 */
	public long getPresentAddrId();

	/**
	 * Sets the present addr ID of this dgf fgl pre dtls.
	 *
	 * @param presentAddrId the present addr ID of this dgf fgl pre dtls
	 */
	public void setPresentAddrId(long presentAddrId);

	/**
	 * Returns the bussiness addr ID of this dgf fgl pre dtls.
	 *
	 * @return the bussiness addr ID of this dgf fgl pre dtls
	 */
	public long getBussinessAddrId();

	/**
	 * Sets the bussiness addr ID of this dgf fgl pre dtls.
	 *
	 * @param bussinessAddrId the bussiness addr ID of this dgf fgl pre dtls
	 */
	public void setBussinessAddrId(long bussinessAddrId);

	/**
	 * Returns the trade license doc ID of this dgf fgl pre dtls.
	 *
	 * @return the trade license doc ID of this dgf fgl pre dtls
	 */
	public long getTradeLicenseDocId();

	/**
	 * Sets the trade license doc ID of this dgf fgl pre dtls.
	 *
	 * @param tradeLicenseDocId the trade license doc ID of this dgf fgl pre dtls
	 */
	public void setTradeLicenseDocId(long tradeLicenseDocId);

	/**
	 * Returns the buss identfct doc ID of this dgf fgl pre dtls.
	 *
	 * @return the buss identfct doc ID of this dgf fgl pre dtls
	 */
	public long getBussIdentfctDocId();

	/**
	 * Sets the buss identfct doc ID of this dgf fgl pre dtls.
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID of this dgf fgl pre dtls
	 */
	public void setBussIdentfctDocId(long bussIdentfctDocId);

	/**
	 * Returns the tax identfct doc ID of this dgf fgl pre dtls.
	 *
	 * @return the tax identfct doc ID of this dgf fgl pre dtls
	 */
	public long getTaxIdentfctDocId();

	/**
	 * Sets the tax identfct doc ID of this dgf fgl pre dtls.
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID of this dgf fgl pre dtls
	 */
	public void setTaxIdentfctDocId(long taxIdentfctDocId);

	/**
	 * Returns the bnk statmt doc ID of this dgf fgl pre dtls.
	 *
	 * @return the bnk statmt doc ID of this dgf fgl pre dtls
	 */
	public long getBnkStatmtDocId();

	/**
	 * Sets the bnk statmt doc ID of this dgf fgl pre dtls.
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID of this dgf fgl pre dtls
	 */
	public void setBnkStatmtDocId(long bnkStatmtDocId);

	/**
	 * Returns the status of this dgf fgl pre dtls.
	 *
	 * @return the status of this dgf fgl pre dtls
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this dgf fgl pre dtls.
	 *
	 * @param status the status of this dgf fgl pre dtls
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this dgf fgl pre dtls.
	 *
	 * @return the status by user ID of this dgf fgl pre dtls
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this dgf fgl pre dtls.
	 *
	 * @param statusByUserId the status by user ID of this dgf fgl pre dtls
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this dgf fgl pre dtls.
	 *
	 * @return the status by user uuid of this dgf fgl pre dtls
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this dgf fgl pre dtls.
	 *
	 * @param statusByUserUuid the status by user uuid of this dgf fgl pre dtls
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this dgf fgl pre dtls.
	 *
	 * @return the status by user name of this dgf fgl pre dtls
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this dgf fgl pre dtls.
	 *
	 * @param statusByUserName the status by user name of this dgf fgl pre dtls
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this dgf fgl pre dtls.
	 *
	 * @return the status date of this dgf fgl pre dtls
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this dgf fgl pre dtls.
	 *
	 * @param statusDate the status date of this dgf fgl pre dtls
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the user ID of this dgf fgl pre dtls.
	 *
	 * @return the user ID of this dgf fgl pre dtls
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this dgf fgl pre dtls.
	 *
	 * @param userId the user ID of this dgf fgl pre dtls
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this dgf fgl pre dtls.
	 *
	 * @return the user uuid of this dgf fgl pre dtls
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this dgf fgl pre dtls.
	 *
	 * @param userUuid the user uuid of this dgf fgl pre dtls
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the birth date of this dgf fgl pre dtls.
	 *
	 * @return the birth date of this dgf fgl pre dtls
	 */
	public Date getBirthDate();

	/**
	 * Sets the birth date of this dgf fgl pre dtls.
	 *
	 * @param birthDate the birth date of this dgf fgl pre dtls
	 */
	public void setBirthDate(Date birthDate);

	/**
	 * Returns the fgl application type of this dgf fgl pre dtls.
	 *
	 * @return the fgl application type of this dgf fgl pre dtls
	 */
	@AutoEscape
	public String getFglApplicationType();

	/**
	 * Sets the fgl application type of this dgf fgl pre dtls.
	 *
	 * @param fglApplicationType the fgl application type of this dgf fgl pre dtls
	 */
	public void setFglApplicationType(String fglApplicationType);

	/**
	 * Returns the photograph doc ID of this dgf fgl pre dtls.
	 *
	 * @return the photograph doc ID of this dgf fgl pre dtls
	 */
	public long getPhotographDocId();

	/**
	 * Sets the photograph doc ID of this dgf fgl pre dtls.
	 *
	 * @param photographDocId the photograph doc ID of this dgf fgl pre dtls
	 */
	public void setPhotographDocId(long photographDocId);

	/**
	 * Returns the other relevent doc ID of this dgf fgl pre dtls.
	 *
	 * @return the other relevent doc ID of this dgf fgl pre dtls
	 */
	public long getOtherReleventDocId();

	/**
	 * Sets the other relevent doc ID of this dgf fgl pre dtls.
	 *
	 * @param otherReleventDocId the other relevent doc ID of this dgf fgl pre dtls
	 */
	public void setOtherReleventDocId(long otherReleventDocId);

	/**
	 * Returns the electric exemption memo ID of this dgf fgl pre dtls.
	 *
	 * @return the electric exemption memo ID of this dgf fgl pre dtls
	 */
	public long getElectricExemptionMemoId();

	/**
	 * Sets the electric exemption memo ID of this dgf fgl pre dtls.
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID of this dgf fgl pre dtls
	 */
	public void setElectricExemptionMemoId(long electricExemptionMemoId);

	/**
	 * Returns the env clr memo ID of this dgf fgl pre dtls.
	 *
	 * @return the env clr memo ID of this dgf fgl pre dtls
	 */
	public long getEnvClrMemoId();

	/**
	 * Sets the env clr memo ID of this dgf fgl pre dtls.
	 *
	 * @param envClrMemoId the env clr memo ID of this dgf fgl pre dtls
	 */
	public void setEnvClrMemoId(long envClrMemoId);

	/**
	 * Returns the bsti clr memo ID of this dgf fgl pre dtls.
	 *
	 * @return the bsti clr memo ID of this dgf fgl pre dtls
	 */
	public long getBstiClrMemoId();

	/**
	 * Sets the bsti clr memo ID of this dgf fgl pre dtls.
	 *
	 * @param bstiClrMemoId the bsti clr memo ID of this dgf fgl pre dtls
	 */
	public void setBstiClrMemoId(long bstiClrMemoId);

	/**
	 * Returns the fire lic num doc ID of this dgf fgl pre dtls.
	 *
	 * @return the fire lic num doc ID of this dgf fgl pre dtls
	 */
	public long getFireLicNumDocId();

	/**
	 * Sets the fire lic num doc ID of this dgf fgl pre dtls.
	 *
	 * @param fireLicNumDocId the fire lic num doc ID of this dgf fgl pre dtls
	 */
	public void setFireLicNumDocId(long fireLicNumDocId);

	/**
	 * Returns the product type of this dgf fgl pre dtls.
	 *
	 * @return the product type of this dgf fgl pre dtls
	 */
	@AutoEscape
	public String getProductType();

	/**
	 * Sets the product type of this dgf fgl pre dtls.
	 *
	 * @param productType the product type of this dgf fgl pre dtls
	 */
	public void setProductType(String productType);

	/**
	 * Returns <code>true</code> if this dgf fgl pre dtls is approved.
	 *
	 * @return <code>true</code> if this dgf fgl pre dtls is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this dgf fgl pre dtls is denied.
	 *
	 * @return <code>true</code> if this dgf fgl pre dtls is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this dgf fgl pre dtls is a draft.
	 *
	 * @return <code>true</code> if this dgf fgl pre dtls is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this dgf fgl pre dtls is expired.
	 *
	 * @return <code>true</code> if this dgf fgl pre dtls is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this dgf fgl pre dtls is inactive.
	 *
	 * @return <code>true</code> if this dgf fgl pre dtls is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this dgf fgl pre dtls is incomplete.
	 *
	 * @return <code>true</code> if this dgf fgl pre dtls is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this dgf fgl pre dtls is pending.
	 *
	 * @return <code>true</code> if this dgf fgl pre dtls is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this dgf fgl pre dtls is scheduled.
	 *
	 * @return <code>true</code> if this dgf fgl pre dtls is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public DgfFglPreDtls cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}