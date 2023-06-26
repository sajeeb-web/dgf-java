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
 * This class is a wrapper for {@link DgfUsers}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsers
 * @generated
 */
public class DgfUsersWrapper
	extends BaseModelWrapper<DgfUsers>
	implements DgfUsers, ModelWrapper<DgfUsers> {

	public DgfUsersWrapper(DgfUsers dgfUsers) {
		super(dgfUsers);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("nationalId", getNationalId());
		attributes.put("password", getPassword());
		attributes.put("applicantName", getApplicantName());
		attributes.put("fatherName", getFatherName());
		attributes.put("lastName", getLastName());
		attributes.put("motherName", getMotherName());
		attributes.put("gender", getGender());
		attributes.put("maritalStatus", getMaritalStatus());
		attributes.put("birthDate", getBirthDate());
		attributes.put("mobileNo", getMobileNo());
		attributes.put("presentAddrId", getPresentAddrId());
		attributes.put("applcProfile", getApplcProfile());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String nationalId = (String)attributes.get("nationalId");

		if (nationalId != null) {
			setNationalId(nationalId);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		String applicantName = (String)attributes.get("applicantName");

		if (applicantName != null) {
			setApplicantName(applicantName);
		}

		String fatherName = (String)attributes.get("fatherName");

		if (fatherName != null) {
			setFatherName(fatherName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String motherName = (String)attributes.get("motherName");

		if (motherName != null) {
			setMotherName(motherName);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String maritalStatus = (String)attributes.get("maritalStatus");

		if (maritalStatus != null) {
			setMaritalStatus(maritalStatus);
		}

		Date birthDate = (Date)attributes.get("birthDate");

		if (birthDate != null) {
			setBirthDate(birthDate);
		}

		String mobileNo = (String)attributes.get("mobileNo");

		if (mobileNo != null) {
			setMobileNo(mobileNo);
		}

		Long presentAddrId = (Long)attributes.get("presentAddrId");

		if (presentAddrId != null) {
			setPresentAddrId(presentAddrId);
		}

		String applcProfile = (String)attributes.get("applcProfile");

		if (applcProfile != null) {
			setApplcProfile(applcProfile);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public DgfUsers cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the applc profile of this dgf users.
	 *
	 * @return the applc profile of this dgf users
	 */
	@Override
	public String getApplcProfile() {
		return model.getApplcProfile();
	}

	/**
	 * Returns the applicant name of this dgf users.
	 *
	 * @return the applicant name of this dgf users
	 */
	@Override
	public String getApplicantName() {
		return model.getApplicantName();
	}

	/**
	 * Returns the birth date of this dgf users.
	 *
	 * @return the birth date of this dgf users
	 */
	@Override
	public Date getBirthDate() {
		return model.getBirthDate();
	}

	/**
	 * Returns the create date of this dgf users.
	 *
	 * @return the create date of this dgf users
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the father name of this dgf users.
	 *
	 * @return the father name of this dgf users
	 */
	@Override
	public String getFatherName() {
		return model.getFatherName();
	}

	/**
	 * Returns the gender of this dgf users.
	 *
	 * @return the gender of this dgf users
	 */
	@Override
	public String getGender() {
		return model.getGender();
	}

	/**
	 * Returns the last name of this dgf users.
	 *
	 * @return the last name of this dgf users
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the marital status of this dgf users.
	 *
	 * @return the marital status of this dgf users
	 */
	@Override
	public String getMaritalStatus() {
		return model.getMaritalStatus();
	}

	/**
	 * Returns the mobile no of this dgf users.
	 *
	 * @return the mobile no of this dgf users
	 */
	@Override
	public String getMobileNo() {
		return model.getMobileNo();
	}

	/**
	 * Returns the modified date of this dgf users.
	 *
	 * @return the modified date of this dgf users
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mother name of this dgf users.
	 *
	 * @return the mother name of this dgf users
	 */
	@Override
	public String getMotherName() {
		return model.getMotherName();
	}

	/**
	 * Returns the national ID of this dgf users.
	 *
	 * @return the national ID of this dgf users
	 */
	@Override
	public String getNationalId() {
		return model.getNationalId();
	}

	/**
	 * Returns the password of this dgf users.
	 *
	 * @return the password of this dgf users
	 */
	@Override
	public String getPassword() {
		return model.getPassword();
	}

	/**
	 * Returns the present addr ID of this dgf users.
	 *
	 * @return the present addr ID of this dgf users
	 */
	@Override
	public long getPresentAddrId() {
		return model.getPresentAddrId();
	}

	/**
	 * Returns the primary key of this dgf users.
	 *
	 * @return the primary key of this dgf users
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this dgf users.
	 *
	 * @return the user ID of this dgf users
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this dgf users.
	 *
	 * @return the user uuid of this dgf users
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the applc profile of this dgf users.
	 *
	 * @param applcProfile the applc profile of this dgf users
	 */
	@Override
	public void setApplcProfile(String applcProfile) {
		model.setApplcProfile(applcProfile);
	}

	/**
	 * Sets the applicant name of this dgf users.
	 *
	 * @param applicantName the applicant name of this dgf users
	 */
	@Override
	public void setApplicantName(String applicantName) {
		model.setApplicantName(applicantName);
	}

	/**
	 * Sets the birth date of this dgf users.
	 *
	 * @param birthDate the birth date of this dgf users
	 */
	@Override
	public void setBirthDate(Date birthDate) {
		model.setBirthDate(birthDate);
	}

	/**
	 * Sets the create date of this dgf users.
	 *
	 * @param createDate the create date of this dgf users
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the father name of this dgf users.
	 *
	 * @param fatherName the father name of this dgf users
	 */
	@Override
	public void setFatherName(String fatherName) {
		model.setFatherName(fatherName);
	}

	/**
	 * Sets the gender of this dgf users.
	 *
	 * @param gender the gender of this dgf users
	 */
	@Override
	public void setGender(String gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the last name of this dgf users.
	 *
	 * @param lastName the last name of this dgf users
	 */
	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets the marital status of this dgf users.
	 *
	 * @param maritalStatus the marital status of this dgf users
	 */
	@Override
	public void setMaritalStatus(String maritalStatus) {
		model.setMaritalStatus(maritalStatus);
	}

	/**
	 * Sets the mobile no of this dgf users.
	 *
	 * @param mobileNo the mobile no of this dgf users
	 */
	@Override
	public void setMobileNo(String mobileNo) {
		model.setMobileNo(mobileNo);
	}

	/**
	 * Sets the modified date of this dgf users.
	 *
	 * @param modifiedDate the modified date of this dgf users
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mother name of this dgf users.
	 *
	 * @param motherName the mother name of this dgf users
	 */
	@Override
	public void setMotherName(String motherName) {
		model.setMotherName(motherName);
	}

	/**
	 * Sets the national ID of this dgf users.
	 *
	 * @param nationalId the national ID of this dgf users
	 */
	@Override
	public void setNationalId(String nationalId) {
		model.setNationalId(nationalId);
	}

	/**
	 * Sets the password of this dgf users.
	 *
	 * @param password the password of this dgf users
	 */
	@Override
	public void setPassword(String password) {
		model.setPassword(password);
	}

	/**
	 * Sets the present addr ID of this dgf users.
	 *
	 * @param presentAddrId the present addr ID of this dgf users
	 */
	@Override
	public void setPresentAddrId(long presentAddrId) {
		model.setPresentAddrId(presentAddrId);
	}

	/**
	 * Sets the primary key of this dgf users.
	 *
	 * @param primaryKey the primary key of this dgf users
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this dgf users.
	 *
	 * @param userId the user ID of this dgf users
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this dgf users.
	 *
	 * @param userUuid the user uuid of this dgf users
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
	protected DgfUsersWrapper wrap(DgfUsers dgfUsers) {
		return new DgfUsersWrapper(dgfUsers);
	}

}