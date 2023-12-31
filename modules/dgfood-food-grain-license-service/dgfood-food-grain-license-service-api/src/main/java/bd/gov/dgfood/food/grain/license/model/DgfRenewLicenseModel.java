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
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the DgfRenewLicense service. Represents a row in the &quot;dgf_renew_license&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>bd.gov.dgfood.food.grain.license.model.impl.DgfRenewLicenseModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>bd.gov.dgfood.food.grain.license.model.impl.DgfRenewLicenseImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfRenewLicense
 * @generated
 */
@ProviderType
public interface DgfRenewLicenseModel
	extends BaseModel<DgfRenewLicense>, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a dgf renew license model instance should use the {@link DgfRenewLicense} interface instead.
	 */

	/**
	 * Returns the primary key of this dgf renew license.
	 *
	 * @return the primary key of this dgf renew license
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this dgf renew license.
	 *
	 * @param primaryKey the primary key of this dgf renew license
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the renew license ID of this dgf renew license.
	 *
	 * @return the renew license ID of this dgf renew license
	 */
	public long getRenewLicenseId();

	/**
	 * Sets the renew license ID of this dgf renew license.
	 *
	 * @param renewLicenseId the renew license ID of this dgf renew license
	 */
	public void setRenewLicenseId(long renewLicenseId);

	/**
	 * Returns the user ID of this dgf renew license.
	 *
	 * @return the user ID of this dgf renew license
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this dgf renew license.
	 *
	 * @param userId the user ID of this dgf renew license
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this dgf renew license.
	 *
	 * @return the user uuid of this dgf renew license
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this dgf renew license.
	 *
	 * @param userUuid the user uuid of this dgf renew license
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the national ID of this dgf renew license.
	 *
	 * @return the national ID of this dgf renew license
	 */
	@AutoEscape
	public String getNationalId();

	/**
	 * Sets the national ID of this dgf renew license.
	 *
	 * @param nationalId the national ID of this dgf renew license
	 */
	public void setNationalId(String nationalId);

	/**
	 * Returns the license no of this dgf renew license.
	 *
	 * @return the license no of this dgf renew license
	 */
	@AutoEscape
	public String getLicenseNo();

	/**
	 * Sets the license no of this dgf renew license.
	 *
	 * @param licenseNo the license no of this dgf renew license
	 */
	public void setLicenseNo(String licenseNo);

	/**
	 * Returns the license expiry date of this dgf renew license.
	 *
	 * @return the license expiry date of this dgf renew license
	 */
	public Date getLicenseExpiryDate();

	/**
	 * Sets the license expiry date of this dgf renew license.
	 *
	 * @param licenseExpiryDate the license expiry date of this dgf renew license
	 */
	public void setLicenseExpiryDate(Date licenseExpiryDate);

	/**
	 * Returns the trade license no of this dgf renew license.
	 *
	 * @return the trade license no of this dgf renew license
	 */
	@AutoEscape
	public String getTradeLicenseNo();

	/**
	 * Sets the trade license no of this dgf renew license.
	 *
	 * @param tradeLicenseNo the trade license no of this dgf renew license
	 */
	public void setTradeLicenseNo(String tradeLicenseNo);

	/**
	 * Returns the trade license expiry date of this dgf renew license.
	 *
	 * @return the trade license expiry date of this dgf renew license
	 */
	public Date getTradeLicenseExpiryDate();

	/**
	 * Sets the trade license expiry date of this dgf renew license.
	 *
	 * @param tradeLicenseExpiryDate the trade license expiry date of this dgf renew license
	 */
	public void setTradeLicenseExpiryDate(Date tradeLicenseExpiryDate);

	/**
	 * Returns the trade lic attch ID of this dgf renew license.
	 *
	 * @return the trade lic attch ID of this dgf renew license
	 */
	public long getTradeLicAttchId();

	/**
	 * Sets the trade lic attch ID of this dgf renew license.
	 *
	 * @param tradeLicAttchId the trade lic attch ID of this dgf renew license
	 */
	public void setTradeLicAttchId(long tradeLicAttchId);

	/**
	 * Returns the payment attch ID of this dgf renew license.
	 *
	 * @return the payment attch ID of this dgf renew license
	 */
	public long getPaymentAttchId();

	/**
	 * Sets the payment attch ID of this dgf renew license.
	 *
	 * @param paymentAttchId the payment attch ID of this dgf renew license
	 */
	public void setPaymentAttchId(long paymentAttchId);

	/**
	 * Returns the application no of this dgf renew license.
	 *
	 * @return the application no of this dgf renew license
	 */
	@AutoEscape
	public String getApplicationNo();

	/**
	 * Sets the application no of this dgf renew license.
	 *
	 * @param applicationNo the application no of this dgf renew license
	 */
	public void setApplicationNo(String applicationNo);

	/**
	 * Returns the license application type of this dgf renew license.
	 *
	 * @return the license application type of this dgf renew license
	 */
	@AutoEscape
	public String getLicenseApplicationType();

	/**
	 * Sets the license application type of this dgf renew license.
	 *
	 * @param licenseApplicationType the license application type of this dgf renew license
	 */
	public void setLicenseApplicationType(String licenseApplicationType);

	/**
	 * Returns the comments of this dgf renew license.
	 *
	 * @return the comments of this dgf renew license
	 */
	@AutoEscape
	public String getComments();

	/**
	 * Sets the comments of this dgf renew license.
	 *
	 * @param comments the comments of this dgf renew license
	 */
	public void setComments(String comments);

	/**
	 * Returns the created date of this dgf renew license.
	 *
	 * @return the created date of this dgf renew license
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this dgf renew license.
	 *
	 * @param createdDate the created date of this dgf renew license
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the modified by of this dgf renew license.
	 *
	 * @return the modified by of this dgf renew license
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this dgf renew license.
	 *
	 * @param modifiedBy the modified by of this dgf renew license
	 */
	public void setModifiedBy(long modifiedBy);

	/**
	 * Returns the modified date of this dgf renew license.
	 *
	 * @return the modified date of this dgf renew license
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this dgf renew license.
	 *
	 * @param modifiedDate the modified date of this dgf renew license
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the fgl pre primary ID of this dgf renew license.
	 *
	 * @return the fgl pre primary ID of this dgf renew license
	 */
	public long getFglPrePrimaryId();

	/**
	 * Sets the fgl pre primary ID of this dgf renew license.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID of this dgf renew license
	 */
	public void setFglPrePrimaryId(long fglPrePrimaryId);

	/**
	 * Returns the status of this dgf renew license.
	 *
	 * @return the status of this dgf renew license
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this dgf renew license.
	 *
	 * @param status the status of this dgf renew license
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this dgf renew license.
	 *
	 * @return the status by user ID of this dgf renew license
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this dgf renew license.
	 *
	 * @param statusByUserId the status by user ID of this dgf renew license
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this dgf renew license.
	 *
	 * @return the status by user uuid of this dgf renew license
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this dgf renew license.
	 *
	 * @param statusByUserUuid the status by user uuid of this dgf renew license
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this dgf renew license.
	 *
	 * @return the status by user name of this dgf renew license
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this dgf renew license.
	 *
	 * @param statusByUserName the status by user name of this dgf renew license
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this dgf renew license.
	 *
	 * @return the status date of this dgf renew license
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this dgf renew license.
	 *
	 * @param statusDate the status date of this dgf renew license
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns <code>true</code> if this dgf renew license is approved.
	 *
	 * @return <code>true</code> if this dgf renew license is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this dgf renew license is denied.
	 *
	 * @return <code>true</code> if this dgf renew license is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this dgf renew license is a draft.
	 *
	 * @return <code>true</code> if this dgf renew license is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this dgf renew license is expired.
	 *
	 * @return <code>true</code> if this dgf renew license is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this dgf renew license is inactive.
	 *
	 * @return <code>true</code> if this dgf renew license is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this dgf renew license is incomplete.
	 *
	 * @return <code>true</code> if this dgf renew license is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this dgf renew license is pending.
	 *
	 * @return <code>true</code> if this dgf renew license is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this dgf renew license is scheduled.
	 *
	 * @return <code>true</code> if this dgf renew license is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public DgfRenewLicense cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}