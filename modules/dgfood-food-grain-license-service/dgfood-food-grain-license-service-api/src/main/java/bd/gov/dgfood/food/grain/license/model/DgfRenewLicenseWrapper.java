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
 * This class is a wrapper for {@link DgfRenewLicense}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfRenewLicense
 * @generated
 */
public class DgfRenewLicenseWrapper
	extends BaseModelWrapper<DgfRenewLicense>
	implements DgfRenewLicense, ModelWrapper<DgfRenewLicense> {

	public DgfRenewLicenseWrapper(DgfRenewLicense dgfRenewLicense) {
		super(dgfRenewLicense);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("renewLicenseId", getRenewLicenseId());
		attributes.put("userId", getUserId());
		attributes.put("nationalId", getNationalId());
		attributes.put("licenseNo", getLicenseNo());
		attributes.put("licenseExpiryDate", getLicenseExpiryDate());
		attributes.put("tradeLicenseNo", getTradeLicenseNo());
		attributes.put("tradeLicenseExpiryDate", getTradeLicenseExpiryDate());
		attributes.put("tradeLicAttchId", getTradeLicAttchId());
		attributes.put("paymentAttchId", getPaymentAttchId());
		attributes.put("applicationNo", getApplicationNo());
		attributes.put("licenseApplicationType", getLicenseApplicationType());
		attributes.put("comments", getComments());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("fglPrePrimaryId", getFglPrePrimaryId());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long renewLicenseId = (Long)attributes.get("renewLicenseId");

		if (renewLicenseId != null) {
			setRenewLicenseId(renewLicenseId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String nationalId = (String)attributes.get("nationalId");

		if (nationalId != null) {
			setNationalId(nationalId);
		}

		String licenseNo = (String)attributes.get("licenseNo");

		if (licenseNo != null) {
			setLicenseNo(licenseNo);
		}

		Date licenseExpiryDate = (Date)attributes.get("licenseExpiryDate");

		if (licenseExpiryDate != null) {
			setLicenseExpiryDate(licenseExpiryDate);
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

		Long tradeLicAttchId = (Long)attributes.get("tradeLicAttchId");

		if (tradeLicAttchId != null) {
			setTradeLicAttchId(tradeLicAttchId);
		}

		Long paymentAttchId = (Long)attributes.get("paymentAttchId");

		if (paymentAttchId != null) {
			setPaymentAttchId(paymentAttchId);
		}

		String applicationNo = (String)attributes.get("applicationNo");

		if (applicationNo != null) {
			setApplicationNo(applicationNo);
		}

		String licenseApplicationType = (String)attributes.get(
			"licenseApplicationType");

		if (licenseApplicationType != null) {
			setLicenseApplicationType(licenseApplicationType);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
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

		Long fglPrePrimaryId = (Long)attributes.get("fglPrePrimaryId");

		if (fglPrePrimaryId != null) {
			setFglPrePrimaryId(fglPrePrimaryId);
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
	public DgfRenewLicense cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the application no of this dgf renew license.
	 *
	 * @return the application no of this dgf renew license
	 */
	@Override
	public String getApplicationNo() {
		return model.getApplicationNo();
	}

	/**
	 * Returns the comments of this dgf renew license.
	 *
	 * @return the comments of this dgf renew license
	 */
	@Override
	public String getComments() {
		return model.getComments();
	}

	/**
	 * Returns the created date of this dgf renew license.
	 *
	 * @return the created date of this dgf renew license
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the fgl pre primary ID of this dgf renew license.
	 *
	 * @return the fgl pre primary ID of this dgf renew license
	 */
	@Override
	public long getFglPrePrimaryId() {
		return model.getFglPrePrimaryId();
	}

	/**
	 * Returns the license application type of this dgf renew license.
	 *
	 * @return the license application type of this dgf renew license
	 */
	@Override
	public String getLicenseApplicationType() {
		return model.getLicenseApplicationType();
	}

	/**
	 * Returns the license expiry date of this dgf renew license.
	 *
	 * @return the license expiry date of this dgf renew license
	 */
	@Override
	public Date getLicenseExpiryDate() {
		return model.getLicenseExpiryDate();
	}

	/**
	 * Returns the license no of this dgf renew license.
	 *
	 * @return the license no of this dgf renew license
	 */
	@Override
	public String getLicenseNo() {
		return model.getLicenseNo();
	}

	/**
	 * Returns the modified by of this dgf renew license.
	 *
	 * @return the modified by of this dgf renew license
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this dgf renew license.
	 *
	 * @return the modified date of this dgf renew license
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the national ID of this dgf renew license.
	 *
	 * @return the national ID of this dgf renew license
	 */
	@Override
	public String getNationalId() {
		return model.getNationalId();
	}

	/**
	 * Returns the payment attch ID of this dgf renew license.
	 *
	 * @return the payment attch ID of this dgf renew license
	 */
	@Override
	public long getPaymentAttchId() {
		return model.getPaymentAttchId();
	}

	/**
	 * Returns the primary key of this dgf renew license.
	 *
	 * @return the primary key of this dgf renew license
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the renew license ID of this dgf renew license.
	 *
	 * @return the renew license ID of this dgf renew license
	 */
	@Override
	public long getRenewLicenseId() {
		return model.getRenewLicenseId();
	}

	/**
	 * Returns the status of this dgf renew license.
	 *
	 * @return the status of this dgf renew license
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this dgf renew license.
	 *
	 * @return the status by user ID of this dgf renew license
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this dgf renew license.
	 *
	 * @return the status by user name of this dgf renew license
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this dgf renew license.
	 *
	 * @return the status by user uuid of this dgf renew license
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this dgf renew license.
	 *
	 * @return the status date of this dgf renew license
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the trade lic attch ID of this dgf renew license.
	 *
	 * @return the trade lic attch ID of this dgf renew license
	 */
	@Override
	public long getTradeLicAttchId() {
		return model.getTradeLicAttchId();
	}

	/**
	 * Returns the trade license expiry date of this dgf renew license.
	 *
	 * @return the trade license expiry date of this dgf renew license
	 */
	@Override
	public Date getTradeLicenseExpiryDate() {
		return model.getTradeLicenseExpiryDate();
	}

	/**
	 * Returns the trade license no of this dgf renew license.
	 *
	 * @return the trade license no of this dgf renew license
	 */
	@Override
	public String getTradeLicenseNo() {
		return model.getTradeLicenseNo();
	}

	/**
	 * Returns the user ID of this dgf renew license.
	 *
	 * @return the user ID of this dgf renew license
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this dgf renew license.
	 *
	 * @return the user uuid of this dgf renew license
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this dgf renew license is approved.
	 *
	 * @return <code>true</code> if this dgf renew license is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this dgf renew license is denied.
	 *
	 * @return <code>true</code> if this dgf renew license is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this dgf renew license is a draft.
	 *
	 * @return <code>true</code> if this dgf renew license is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this dgf renew license is expired.
	 *
	 * @return <code>true</code> if this dgf renew license is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this dgf renew license is inactive.
	 *
	 * @return <code>true</code> if this dgf renew license is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this dgf renew license is incomplete.
	 *
	 * @return <code>true</code> if this dgf renew license is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this dgf renew license is pending.
	 *
	 * @return <code>true</code> if this dgf renew license is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this dgf renew license is scheduled.
	 *
	 * @return <code>true</code> if this dgf renew license is scheduled; <code>false</code> otherwise
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
	 * Sets the application no of this dgf renew license.
	 *
	 * @param applicationNo the application no of this dgf renew license
	 */
	@Override
	public void setApplicationNo(String applicationNo) {
		model.setApplicationNo(applicationNo);
	}

	/**
	 * Sets the comments of this dgf renew license.
	 *
	 * @param comments the comments of this dgf renew license
	 */
	@Override
	public void setComments(String comments) {
		model.setComments(comments);
	}

	/**
	 * Sets the created date of this dgf renew license.
	 *
	 * @param createdDate the created date of this dgf renew license
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the fgl pre primary ID of this dgf renew license.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID of this dgf renew license
	 */
	@Override
	public void setFglPrePrimaryId(long fglPrePrimaryId) {
		model.setFglPrePrimaryId(fglPrePrimaryId);
	}

	/**
	 * Sets the license application type of this dgf renew license.
	 *
	 * @param licenseApplicationType the license application type of this dgf renew license
	 */
	@Override
	public void setLicenseApplicationType(String licenseApplicationType) {
		model.setLicenseApplicationType(licenseApplicationType);
	}

	/**
	 * Sets the license expiry date of this dgf renew license.
	 *
	 * @param licenseExpiryDate the license expiry date of this dgf renew license
	 */
	@Override
	public void setLicenseExpiryDate(Date licenseExpiryDate) {
		model.setLicenseExpiryDate(licenseExpiryDate);
	}

	/**
	 * Sets the license no of this dgf renew license.
	 *
	 * @param licenseNo the license no of this dgf renew license
	 */
	@Override
	public void setLicenseNo(String licenseNo) {
		model.setLicenseNo(licenseNo);
	}

	/**
	 * Sets the modified by of this dgf renew license.
	 *
	 * @param modifiedBy the modified by of this dgf renew license
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this dgf renew license.
	 *
	 * @param modifiedDate the modified date of this dgf renew license
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the national ID of this dgf renew license.
	 *
	 * @param nationalId the national ID of this dgf renew license
	 */
	@Override
	public void setNationalId(String nationalId) {
		model.setNationalId(nationalId);
	}

	/**
	 * Sets the payment attch ID of this dgf renew license.
	 *
	 * @param paymentAttchId the payment attch ID of this dgf renew license
	 */
	@Override
	public void setPaymentAttchId(long paymentAttchId) {
		model.setPaymentAttchId(paymentAttchId);
	}

	/**
	 * Sets the primary key of this dgf renew license.
	 *
	 * @param primaryKey the primary key of this dgf renew license
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the renew license ID of this dgf renew license.
	 *
	 * @param renewLicenseId the renew license ID of this dgf renew license
	 */
	@Override
	public void setRenewLicenseId(long renewLicenseId) {
		model.setRenewLicenseId(renewLicenseId);
	}

	/**
	 * Sets the status of this dgf renew license.
	 *
	 * @param status the status of this dgf renew license
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this dgf renew license.
	 *
	 * @param statusByUserId the status by user ID of this dgf renew license
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this dgf renew license.
	 *
	 * @param statusByUserName the status by user name of this dgf renew license
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this dgf renew license.
	 *
	 * @param statusByUserUuid the status by user uuid of this dgf renew license
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this dgf renew license.
	 *
	 * @param statusDate the status date of this dgf renew license
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the trade lic attch ID of this dgf renew license.
	 *
	 * @param tradeLicAttchId the trade lic attch ID of this dgf renew license
	 */
	@Override
	public void setTradeLicAttchId(long tradeLicAttchId) {
		model.setTradeLicAttchId(tradeLicAttchId);
	}

	/**
	 * Sets the trade license expiry date of this dgf renew license.
	 *
	 * @param tradeLicenseExpiryDate the trade license expiry date of this dgf renew license
	 */
	@Override
	public void setTradeLicenseExpiryDate(Date tradeLicenseExpiryDate) {
		model.setTradeLicenseExpiryDate(tradeLicenseExpiryDate);
	}

	/**
	 * Sets the trade license no of this dgf renew license.
	 *
	 * @param tradeLicenseNo the trade license no of this dgf renew license
	 */
	@Override
	public void setTradeLicenseNo(String tradeLicenseNo) {
		model.setTradeLicenseNo(tradeLicenseNo);
	}

	/**
	 * Sets the user ID of this dgf renew license.
	 *
	 * @param userId the user ID of this dgf renew license
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this dgf renew license.
	 *
	 * @param userUuid the user uuid of this dgf renew license
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
	protected DgfRenewLicenseWrapper wrap(DgfRenewLicense dgfRenewLicense) {
		return new DgfRenewLicenseWrapper(dgfRenewLicense);
	}

}