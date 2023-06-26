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

package bd.gov.dgfood.dealer.registration.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DgfDlrWithdrawal}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrWithdrawal
 * @generated
 */
public class DgfDlrWithdrawalWrapper
	extends BaseModelWrapper<DgfDlrWithdrawal>
	implements DgfDlrWithdrawal, ModelWrapper<DgfDlrWithdrawal> {

	public DgfDlrWithdrawalWrapper(DgfDlrWithdrawal dgfDlrWithdrawal) {
		super(dgfDlrWithdrawal);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dlrWithdrawalId", getDlrWithdrawalId());
		attributes.put("nationalId", getNationalId());
		attributes.put("licenseNo", getLicenseNo());
		attributes.put("dealerName", getDealerName());
		attributes.put("mobileNo", getMobileNo());
		attributes.put("reason", getReason());
		attributes.put("programType", getProgramType());
		attributes.put("omsSubType", getOmsSubType());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("dlrRegNo", getDlrRegNo());
		attributes.put("regApplNo", getRegApplNo());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dlrWithdrawalId = (Long)attributes.get("dlrWithdrawalId");

		if (dlrWithdrawalId != null) {
			setDlrWithdrawalId(dlrWithdrawalId);
		}

		String nationalId = (String)attributes.get("nationalId");

		if (nationalId != null) {
			setNationalId(nationalId);
		}

		String licenseNo = (String)attributes.get("licenseNo");

		if (licenseNo != null) {
			setLicenseNo(licenseNo);
		}

		String dealerName = (String)attributes.get("dealerName");

		if (dealerName != null) {
			setDealerName(dealerName);
		}

		String mobileNo = (String)attributes.get("mobileNo");

		if (mobileNo != null) {
			setMobileNo(mobileNo);
		}

		String reason = (String)attributes.get("reason");

		if (reason != null) {
			setReason(reason);
		}

		String programType = (String)attributes.get("programType");

		if (programType != null) {
			setProgramType(programType);
		}

		String omsSubType = (String)attributes.get("omsSubType");

		if (omsSubType != null) {
			setOmsSubType(omsSubType);
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

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long dlrRegNo = (Long)attributes.get("dlrRegNo");

		if (dlrRegNo != null) {
			setDlrRegNo(dlrRegNo);
		}

		Long regApplNo = (Long)attributes.get("regApplNo");

		if (regApplNo != null) {
			setRegApplNo(regApplNo);
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
	}

	@Override
	public DgfDlrWithdrawal cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this dgf dlr withdrawal.
	 *
	 * @return the company ID of this dgf dlr withdrawal
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the created date of this dgf dlr withdrawal.
	 *
	 * @return the created date of this dgf dlr withdrawal
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the dealer name of this dgf dlr withdrawal.
	 *
	 * @return the dealer name of this dgf dlr withdrawal
	 */
	@Override
	public String getDealerName() {
		return model.getDealerName();
	}

	/**
	 * Returns the dlr reg no of this dgf dlr withdrawal.
	 *
	 * @return the dlr reg no of this dgf dlr withdrawal
	 */
	@Override
	public long getDlrRegNo() {
		return model.getDlrRegNo();
	}

	/**
	 * Returns the dlr withdrawal ID of this dgf dlr withdrawal.
	 *
	 * @return the dlr withdrawal ID of this dgf dlr withdrawal
	 */
	@Override
	public long getDlrWithdrawalId() {
		return model.getDlrWithdrawalId();
	}

	/**
	 * Returns the group ID of this dgf dlr withdrawal.
	 *
	 * @return the group ID of this dgf dlr withdrawal
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the license no of this dgf dlr withdrawal.
	 *
	 * @return the license no of this dgf dlr withdrawal
	 */
	@Override
	public String getLicenseNo() {
		return model.getLicenseNo();
	}

	/**
	 * Returns the mobile no of this dgf dlr withdrawal.
	 *
	 * @return the mobile no of this dgf dlr withdrawal
	 */
	@Override
	public String getMobileNo() {
		return model.getMobileNo();
	}

	/**
	 * Returns the modified by of this dgf dlr withdrawal.
	 *
	 * @return the modified by of this dgf dlr withdrawal
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this dgf dlr withdrawal.
	 *
	 * @return the modified date of this dgf dlr withdrawal
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the national ID of this dgf dlr withdrawal.
	 *
	 * @return the national ID of this dgf dlr withdrawal
	 */
	@Override
	public String getNationalId() {
		return model.getNationalId();
	}

	/**
	 * Returns the oms sub type of this dgf dlr withdrawal.
	 *
	 * @return the oms sub type of this dgf dlr withdrawal
	 */
	@Override
	public String getOmsSubType() {
		return model.getOmsSubType();
	}

	/**
	 * Returns the primary key of this dgf dlr withdrawal.
	 *
	 * @return the primary key of this dgf dlr withdrawal
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the program type of this dgf dlr withdrawal.
	 *
	 * @return the program type of this dgf dlr withdrawal
	 */
	@Override
	public String getProgramType() {
		return model.getProgramType();
	}

	/**
	 * Returns the reason of this dgf dlr withdrawal.
	 *
	 * @return the reason of this dgf dlr withdrawal
	 */
	@Override
	public String getReason() {
		return model.getReason();
	}

	/**
	 * Returns the reg appl no of this dgf dlr withdrawal.
	 *
	 * @return the reg appl no of this dgf dlr withdrawal
	 */
	@Override
	public long getRegApplNo() {
		return model.getRegApplNo();
	}

	/**
	 * Returns the status of this dgf dlr withdrawal.
	 *
	 * @return the status of this dgf dlr withdrawal
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this dgf dlr withdrawal.
	 *
	 * @return the status by user ID of this dgf dlr withdrawal
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this dgf dlr withdrawal.
	 *
	 * @return the status by user name of this dgf dlr withdrawal
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this dgf dlr withdrawal.
	 *
	 * @return the status by user uuid of this dgf dlr withdrawal
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this dgf dlr withdrawal.
	 *
	 * @return the status date of this dgf dlr withdrawal
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this dgf dlr withdrawal.
	 *
	 * @return the user ID of this dgf dlr withdrawal
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this dgf dlr withdrawal.
	 *
	 * @return the user uuid of this dgf dlr withdrawal
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this dgf dlr withdrawal is approved.
	 *
	 * @return <code>true</code> if this dgf dlr withdrawal is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this dgf dlr withdrawal is denied.
	 *
	 * @return <code>true</code> if this dgf dlr withdrawal is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this dgf dlr withdrawal is a draft.
	 *
	 * @return <code>true</code> if this dgf dlr withdrawal is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this dgf dlr withdrawal is expired.
	 *
	 * @return <code>true</code> if this dgf dlr withdrawal is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this dgf dlr withdrawal is inactive.
	 *
	 * @return <code>true</code> if this dgf dlr withdrawal is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this dgf dlr withdrawal is incomplete.
	 *
	 * @return <code>true</code> if this dgf dlr withdrawal is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this dgf dlr withdrawal is pending.
	 *
	 * @return <code>true</code> if this dgf dlr withdrawal is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this dgf dlr withdrawal is scheduled.
	 *
	 * @return <code>true</code> if this dgf dlr withdrawal is scheduled; <code>false</code> otherwise
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
	 * Sets the company ID of this dgf dlr withdrawal.
	 *
	 * @param companyId the company ID of this dgf dlr withdrawal
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the created date of this dgf dlr withdrawal.
	 *
	 * @param createdDate the created date of this dgf dlr withdrawal
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the dealer name of this dgf dlr withdrawal.
	 *
	 * @param dealerName the dealer name of this dgf dlr withdrawal
	 */
	@Override
	public void setDealerName(String dealerName) {
		model.setDealerName(dealerName);
	}

	/**
	 * Sets the dlr reg no of this dgf dlr withdrawal.
	 *
	 * @param dlrRegNo the dlr reg no of this dgf dlr withdrawal
	 */
	@Override
	public void setDlrRegNo(long dlrRegNo) {
		model.setDlrRegNo(dlrRegNo);
	}

	/**
	 * Sets the dlr withdrawal ID of this dgf dlr withdrawal.
	 *
	 * @param dlrWithdrawalId the dlr withdrawal ID of this dgf dlr withdrawal
	 */
	@Override
	public void setDlrWithdrawalId(long dlrWithdrawalId) {
		model.setDlrWithdrawalId(dlrWithdrawalId);
	}

	/**
	 * Sets the group ID of this dgf dlr withdrawal.
	 *
	 * @param groupId the group ID of this dgf dlr withdrawal
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the license no of this dgf dlr withdrawal.
	 *
	 * @param licenseNo the license no of this dgf dlr withdrawal
	 */
	@Override
	public void setLicenseNo(String licenseNo) {
		model.setLicenseNo(licenseNo);
	}

	/**
	 * Sets the mobile no of this dgf dlr withdrawal.
	 *
	 * @param mobileNo the mobile no of this dgf dlr withdrawal
	 */
	@Override
	public void setMobileNo(String mobileNo) {
		model.setMobileNo(mobileNo);
	}

	/**
	 * Sets the modified by of this dgf dlr withdrawal.
	 *
	 * @param modifiedBy the modified by of this dgf dlr withdrawal
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this dgf dlr withdrawal.
	 *
	 * @param modifiedDate the modified date of this dgf dlr withdrawal
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the national ID of this dgf dlr withdrawal.
	 *
	 * @param nationalId the national ID of this dgf dlr withdrawal
	 */
	@Override
	public void setNationalId(String nationalId) {
		model.setNationalId(nationalId);
	}

	/**
	 * Sets the oms sub type of this dgf dlr withdrawal.
	 *
	 * @param omsSubType the oms sub type of this dgf dlr withdrawal
	 */
	@Override
	public void setOmsSubType(String omsSubType) {
		model.setOmsSubType(omsSubType);
	}

	/**
	 * Sets the primary key of this dgf dlr withdrawal.
	 *
	 * @param primaryKey the primary key of this dgf dlr withdrawal
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the program type of this dgf dlr withdrawal.
	 *
	 * @param programType the program type of this dgf dlr withdrawal
	 */
	@Override
	public void setProgramType(String programType) {
		model.setProgramType(programType);
	}

	/**
	 * Sets the reason of this dgf dlr withdrawal.
	 *
	 * @param reason the reason of this dgf dlr withdrawal
	 */
	@Override
	public void setReason(String reason) {
		model.setReason(reason);
	}

	/**
	 * Sets the reg appl no of this dgf dlr withdrawal.
	 *
	 * @param regApplNo the reg appl no of this dgf dlr withdrawal
	 */
	@Override
	public void setRegApplNo(long regApplNo) {
		model.setRegApplNo(regApplNo);
	}

	/**
	 * Sets the status of this dgf dlr withdrawal.
	 *
	 * @param status the status of this dgf dlr withdrawal
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this dgf dlr withdrawal.
	 *
	 * @param statusByUserId the status by user ID of this dgf dlr withdrawal
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this dgf dlr withdrawal.
	 *
	 * @param statusByUserName the status by user name of this dgf dlr withdrawal
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this dgf dlr withdrawal.
	 *
	 * @param statusByUserUuid the status by user uuid of this dgf dlr withdrawal
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this dgf dlr withdrawal.
	 *
	 * @param statusDate the status date of this dgf dlr withdrawal
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this dgf dlr withdrawal.
	 *
	 * @param userId the user ID of this dgf dlr withdrawal
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this dgf dlr withdrawal.
	 *
	 * @param userUuid the user uuid of this dgf dlr withdrawal
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
	protected DgfDlrWithdrawalWrapper wrap(DgfDlrWithdrawal dgfDlrWithdrawal) {
		return new DgfDlrWithdrawalWrapper(dgfDlrWithdrawal);
	}

}