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
 * This class is a wrapper for {@link DgfDuplctLicnsReason}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfDuplctLicnsReason
 * @generated
 */
public class DgfDuplctLicnsReasonWrapper
	extends BaseModelWrapper<DgfDuplctLicnsReason>
	implements DgfDuplctLicnsReason, ModelWrapper<DgfDuplctLicnsReason> {

	public DgfDuplctLicnsReasonWrapper(
		DgfDuplctLicnsReason dgfDuplctLicnsReason) {

		super(dgfDuplctLicnsReason);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put(
			"duplicateLicenseReasonID", getDuplicateLicenseReasonID());
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
		attributes.put(
			"duplicateLicenseReasonDisplay",
			getDuplicateLicenseReasonDisplay());
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
		Long duplicateLicenseReasonID = (Long)attributes.get(
			"duplicateLicenseReasonID");

		if (duplicateLicenseReasonID != null) {
			setDuplicateLicenseReasonID(duplicateLicenseReasonID);
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

		String duplicateLicenseReasonDisplay = (String)attributes.get(
			"duplicateLicenseReasonDisplay");

		if (duplicateLicenseReasonDisplay != null) {
			setDuplicateLicenseReasonDisplay(duplicateLicenseReasonDisplay);
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
	public DgfDuplctLicnsReason cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the application no of this dgf duplct licns reason.
	 *
	 * @return the application no of this dgf duplct licns reason
	 */
	@Override
	public String getApplicationNo() {
		return model.getApplicationNo();
	}

	/**
	 * Returns the comments of this dgf duplct licns reason.
	 *
	 * @return the comments of this dgf duplct licns reason
	 */
	@Override
	public String getComments() {
		return model.getComments();
	}

	/**
	 * Returns the created date of this dgf duplct licns reason.
	 *
	 * @return the created date of this dgf duplct licns reason
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the duplicate license reason display of this dgf duplct licns reason.
	 *
	 * @return the duplicate license reason display of this dgf duplct licns reason
	 */
	@Override
	public String getDuplicateLicenseReasonDisplay() {
		return model.getDuplicateLicenseReasonDisplay();
	}

	/**
	 * Returns the duplicate license reason ID of this dgf duplct licns reason.
	 *
	 * @return the duplicate license reason ID of this dgf duplct licns reason
	 */
	@Override
	public long getDuplicateLicenseReasonID() {
		return model.getDuplicateLicenseReasonID();
	}

	/**
	 * Returns the fgl pre primary ID of this dgf duplct licns reason.
	 *
	 * @return the fgl pre primary ID of this dgf duplct licns reason
	 */
	@Override
	public long getFglPrePrimaryId() {
		return model.getFglPrePrimaryId();
	}

	/**
	 * Returns the license application type of this dgf duplct licns reason.
	 *
	 * @return the license application type of this dgf duplct licns reason
	 */
	@Override
	public String getLicenseApplicationType() {
		return model.getLicenseApplicationType();
	}

	/**
	 * Returns the license expiry date of this dgf duplct licns reason.
	 *
	 * @return the license expiry date of this dgf duplct licns reason
	 */
	@Override
	public Date getLicenseExpiryDate() {
		return model.getLicenseExpiryDate();
	}

	/**
	 * Returns the license no of this dgf duplct licns reason.
	 *
	 * @return the license no of this dgf duplct licns reason
	 */
	@Override
	public String getLicenseNo() {
		return model.getLicenseNo();
	}

	/**
	 * Returns the modified by of this dgf duplct licns reason.
	 *
	 * @return the modified by of this dgf duplct licns reason
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this dgf duplct licns reason.
	 *
	 * @return the modified date of this dgf duplct licns reason
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the national ID of this dgf duplct licns reason.
	 *
	 * @return the national ID of this dgf duplct licns reason
	 */
	@Override
	public String getNationalId() {
		return model.getNationalId();
	}

	/**
	 * Returns the payment attch ID of this dgf duplct licns reason.
	 *
	 * @return the payment attch ID of this dgf duplct licns reason
	 */
	@Override
	public long getPaymentAttchId() {
		return model.getPaymentAttchId();
	}

	/**
	 * Returns the primary key of this dgf duplct licns reason.
	 *
	 * @return the primary key of this dgf duplct licns reason
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this dgf duplct licns reason.
	 *
	 * @return the status of this dgf duplct licns reason
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this dgf duplct licns reason.
	 *
	 * @return the status by user ID of this dgf duplct licns reason
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this dgf duplct licns reason.
	 *
	 * @return the status by user name of this dgf duplct licns reason
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this dgf duplct licns reason.
	 *
	 * @return the status by user uuid of this dgf duplct licns reason
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this dgf duplct licns reason.
	 *
	 * @return the status date of this dgf duplct licns reason
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the trade lic attch ID of this dgf duplct licns reason.
	 *
	 * @return the trade lic attch ID of this dgf duplct licns reason
	 */
	@Override
	public long getTradeLicAttchId() {
		return model.getTradeLicAttchId();
	}

	/**
	 * Returns the trade license expiry date of this dgf duplct licns reason.
	 *
	 * @return the trade license expiry date of this dgf duplct licns reason
	 */
	@Override
	public Date getTradeLicenseExpiryDate() {
		return model.getTradeLicenseExpiryDate();
	}

	/**
	 * Returns the trade license no of this dgf duplct licns reason.
	 *
	 * @return the trade license no of this dgf duplct licns reason
	 */
	@Override
	public String getTradeLicenseNo() {
		return model.getTradeLicenseNo();
	}

	/**
	 * Returns the user ID of this dgf duplct licns reason.
	 *
	 * @return the user ID of this dgf duplct licns reason
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this dgf duplct licns reason.
	 *
	 * @return the user uuid of this dgf duplct licns reason
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this dgf duplct licns reason is approved.
	 *
	 * @return <code>true</code> if this dgf duplct licns reason is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this dgf duplct licns reason is denied.
	 *
	 * @return <code>true</code> if this dgf duplct licns reason is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this dgf duplct licns reason is a draft.
	 *
	 * @return <code>true</code> if this dgf duplct licns reason is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this dgf duplct licns reason is expired.
	 *
	 * @return <code>true</code> if this dgf duplct licns reason is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this dgf duplct licns reason is inactive.
	 *
	 * @return <code>true</code> if this dgf duplct licns reason is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this dgf duplct licns reason is incomplete.
	 *
	 * @return <code>true</code> if this dgf duplct licns reason is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this dgf duplct licns reason is pending.
	 *
	 * @return <code>true</code> if this dgf duplct licns reason is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this dgf duplct licns reason is scheduled.
	 *
	 * @return <code>true</code> if this dgf duplct licns reason is scheduled; <code>false</code> otherwise
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
	 * Sets the application no of this dgf duplct licns reason.
	 *
	 * @param applicationNo the application no of this dgf duplct licns reason
	 */
	@Override
	public void setApplicationNo(String applicationNo) {
		model.setApplicationNo(applicationNo);
	}

	/**
	 * Sets the comments of this dgf duplct licns reason.
	 *
	 * @param comments the comments of this dgf duplct licns reason
	 */
	@Override
	public void setComments(String comments) {
		model.setComments(comments);
	}

	/**
	 * Sets the created date of this dgf duplct licns reason.
	 *
	 * @param createdDate the created date of this dgf duplct licns reason
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the duplicate license reason display of this dgf duplct licns reason.
	 *
	 * @param duplicateLicenseReasonDisplay the duplicate license reason display of this dgf duplct licns reason
	 */
	@Override
	public void setDuplicateLicenseReasonDisplay(
		String duplicateLicenseReasonDisplay) {

		model.setDuplicateLicenseReasonDisplay(duplicateLicenseReasonDisplay);
	}

	/**
	 * Sets the duplicate license reason ID of this dgf duplct licns reason.
	 *
	 * @param duplicateLicenseReasonID the duplicate license reason ID of this dgf duplct licns reason
	 */
	@Override
	public void setDuplicateLicenseReasonID(long duplicateLicenseReasonID) {
		model.setDuplicateLicenseReasonID(duplicateLicenseReasonID);
	}

	/**
	 * Sets the fgl pre primary ID of this dgf duplct licns reason.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID of this dgf duplct licns reason
	 */
	@Override
	public void setFglPrePrimaryId(long fglPrePrimaryId) {
		model.setFglPrePrimaryId(fglPrePrimaryId);
	}

	/**
	 * Sets the license application type of this dgf duplct licns reason.
	 *
	 * @param licenseApplicationType the license application type of this dgf duplct licns reason
	 */
	@Override
	public void setLicenseApplicationType(String licenseApplicationType) {
		model.setLicenseApplicationType(licenseApplicationType);
	}

	/**
	 * Sets the license expiry date of this dgf duplct licns reason.
	 *
	 * @param licenseExpiryDate the license expiry date of this dgf duplct licns reason
	 */
	@Override
	public void setLicenseExpiryDate(Date licenseExpiryDate) {
		model.setLicenseExpiryDate(licenseExpiryDate);
	}

	/**
	 * Sets the license no of this dgf duplct licns reason.
	 *
	 * @param licenseNo the license no of this dgf duplct licns reason
	 */
	@Override
	public void setLicenseNo(String licenseNo) {
		model.setLicenseNo(licenseNo);
	}

	/**
	 * Sets the modified by of this dgf duplct licns reason.
	 *
	 * @param modifiedBy the modified by of this dgf duplct licns reason
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this dgf duplct licns reason.
	 *
	 * @param modifiedDate the modified date of this dgf duplct licns reason
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the national ID of this dgf duplct licns reason.
	 *
	 * @param nationalId the national ID of this dgf duplct licns reason
	 */
	@Override
	public void setNationalId(String nationalId) {
		model.setNationalId(nationalId);
	}

	/**
	 * Sets the payment attch ID of this dgf duplct licns reason.
	 *
	 * @param paymentAttchId the payment attch ID of this dgf duplct licns reason
	 */
	@Override
	public void setPaymentAttchId(long paymentAttchId) {
		model.setPaymentAttchId(paymentAttchId);
	}

	/**
	 * Sets the primary key of this dgf duplct licns reason.
	 *
	 * @param primaryKey the primary key of this dgf duplct licns reason
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this dgf duplct licns reason.
	 *
	 * @param status the status of this dgf duplct licns reason
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this dgf duplct licns reason.
	 *
	 * @param statusByUserId the status by user ID of this dgf duplct licns reason
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this dgf duplct licns reason.
	 *
	 * @param statusByUserName the status by user name of this dgf duplct licns reason
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this dgf duplct licns reason.
	 *
	 * @param statusByUserUuid the status by user uuid of this dgf duplct licns reason
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this dgf duplct licns reason.
	 *
	 * @param statusDate the status date of this dgf duplct licns reason
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the trade lic attch ID of this dgf duplct licns reason.
	 *
	 * @param tradeLicAttchId the trade lic attch ID of this dgf duplct licns reason
	 */
	@Override
	public void setTradeLicAttchId(long tradeLicAttchId) {
		model.setTradeLicAttchId(tradeLicAttchId);
	}

	/**
	 * Sets the trade license expiry date of this dgf duplct licns reason.
	 *
	 * @param tradeLicenseExpiryDate the trade license expiry date of this dgf duplct licns reason
	 */
	@Override
	public void setTradeLicenseExpiryDate(Date tradeLicenseExpiryDate) {
		model.setTradeLicenseExpiryDate(tradeLicenseExpiryDate);
	}

	/**
	 * Sets the trade license no of this dgf duplct licns reason.
	 *
	 * @param tradeLicenseNo the trade license no of this dgf duplct licns reason
	 */
	@Override
	public void setTradeLicenseNo(String tradeLicenseNo) {
		model.setTradeLicenseNo(tradeLicenseNo);
	}

	/**
	 * Sets the user ID of this dgf duplct licns reason.
	 *
	 * @param userId the user ID of this dgf duplct licns reason
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this dgf duplct licns reason.
	 *
	 * @param userUuid the user uuid of this dgf duplct licns reason
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
	protected DgfDuplctLicnsReasonWrapper wrap(
		DgfDuplctLicnsReason dgfDuplctLicnsReason) {

		return new DgfDuplctLicnsReasonWrapper(dgfDuplctLicnsReason);
	}

}