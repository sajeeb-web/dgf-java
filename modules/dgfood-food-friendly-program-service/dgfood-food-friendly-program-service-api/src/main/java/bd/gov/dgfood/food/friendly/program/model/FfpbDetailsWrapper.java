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

package bd.gov.dgfood.food.friendly.program.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FfpbDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FfpbDetails
 * @generated
 */
public class FfpbDetailsWrapper
	extends BaseModelWrapper<FfpbDetails>
	implements FfpbDetails, ModelWrapper<FfpbDetails> {

	public FfpbDetailsWrapper(FfpbDetails ffpbDetails) {
		super(ffpbDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ffpRegstrId", getFfpRegstrId());
		attributes.put("nationalId", getNationalId());
		attributes.put("dlrRegNo", getDlrRegNo());
		attributes.put("ffpCardNo", getFfpCardNo());
		attributes.put("dateOfBirth", getDateOfBirth());
		attributes.put("mobileNo", getMobileNo());
		attributes.put("emialId", getEmialId());
		attributes.put("maritalStatus", getMaritalStatus());
		attributes.put("gender", getGender());
		attributes.put("spouseNid", getSpouseNid());
		attributes.put("prstAddrRegion", getPrstAddrRegion());
		attributes.put("prstAddrDisrict", getPrstAddrDisrict());
		attributes.put("prstAddrUpzilla", getPrstAddrUpzilla());
		attributes.put("prstAddrUnion", getPrstAddrUnion());
		attributes.put("prstAddrVillage", getPrstAddrVillage());
		attributes.put("prstAddrWard", getPrstAddrWard());
		attributes.put("prstAddrZip", getPrstAddrZip());
		attributes.put("prstAddrPstoffc", getPrstAddrPstoffc());
		attributes.put("prstAddrHoseaddr", getPrstAddrHoseaddr());
		attributes.put("ffpApplCrtdBy", getFfpApplCrtdBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("ffpApplMdfyBy", getFfpApplMdfyBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("applApprejCmnts", getApplApprejCmnts());
		attributes.put("ffpbApplStatus", getFfpbApplStatus());
		attributes.put("version", getVersion());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ffpRegstrId = (Long)attributes.get("ffpRegstrId");

		if (ffpRegstrId != null) {
			setFfpRegstrId(ffpRegstrId);
		}

		Long nationalId = (Long)attributes.get("nationalId");

		if (nationalId != null) {
			setNationalId(nationalId);
		}

		Long dlrRegNo = (Long)attributes.get("dlrRegNo");

		if (dlrRegNo != null) {
			setDlrRegNo(dlrRegNo);
		}

		String ffpCardNo = (String)attributes.get("ffpCardNo");

		if (ffpCardNo != null) {
			setFfpCardNo(ffpCardNo);
		}

		Date dateOfBirth = (Date)attributes.get("dateOfBirth");

		if (dateOfBirth != null) {
			setDateOfBirth(dateOfBirth);
		}

		String mobileNo = (String)attributes.get("mobileNo");

		if (mobileNo != null) {
			setMobileNo(mobileNo);
		}

		String emialId = (String)attributes.get("emialId");

		if (emialId != null) {
			setEmialId(emialId);
		}

		Long maritalStatus = (Long)attributes.get("maritalStatus");

		if (maritalStatus != null) {
			setMaritalStatus(maritalStatus);
		}

		Long gender = (Long)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		Long spouseNid = (Long)attributes.get("spouseNid");

		if (spouseNid != null) {
			setSpouseNid(spouseNid);
		}

		String prstAddrRegion = (String)attributes.get("prstAddrRegion");

		if (prstAddrRegion != null) {
			setPrstAddrRegion(prstAddrRegion);
		}

		String prstAddrDisrict = (String)attributes.get("prstAddrDisrict");

		if (prstAddrDisrict != null) {
			setPrstAddrDisrict(prstAddrDisrict);
		}

		String prstAddrUpzilla = (String)attributes.get("prstAddrUpzilla");

		if (prstAddrUpzilla != null) {
			setPrstAddrUpzilla(prstAddrUpzilla);
		}

		String prstAddrUnion = (String)attributes.get("prstAddrUnion");

		if (prstAddrUnion != null) {
			setPrstAddrUnion(prstAddrUnion);
		}

		String prstAddrVillage = (String)attributes.get("prstAddrVillage");

		if (prstAddrVillage != null) {
			setPrstAddrVillage(prstAddrVillage);
		}

		String prstAddrWard = (String)attributes.get("prstAddrWard");

		if (prstAddrWard != null) {
			setPrstAddrWard(prstAddrWard);
		}

		Long prstAddrZip = (Long)attributes.get("prstAddrZip");

		if (prstAddrZip != null) {
			setPrstAddrZip(prstAddrZip);
		}

		Long prstAddrPstoffc = (Long)attributes.get("prstAddrPstoffc");

		if (prstAddrPstoffc != null) {
			setPrstAddrPstoffc(prstAddrPstoffc);
		}

		String prstAddrHoseaddr = (String)attributes.get("prstAddrHoseaddr");

		if (prstAddrHoseaddr != null) {
			setPrstAddrHoseaddr(prstAddrHoseaddr);
		}

		Long ffpApplCrtdBy = (Long)attributes.get("ffpApplCrtdBy");

		if (ffpApplCrtdBy != null) {
			setFfpApplCrtdBy(ffpApplCrtdBy);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long ffpApplMdfyBy = (Long)attributes.get("ffpApplMdfyBy");

		if (ffpApplMdfyBy != null) {
			setFfpApplMdfyBy(ffpApplMdfyBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String applApprejCmnts = (String)attributes.get("applApprejCmnts");

		if (applApprejCmnts != null) {
			setApplApprejCmnts(applApprejCmnts);
		}

		Long ffpbApplStatus = (Long)attributes.get("ffpbApplStatus");

		if (ffpbApplStatus != null) {
			setFfpbApplStatus(ffpbApplStatus);
		}

		Float version = (Float)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Long status = (Long)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	@Override
	public FfpbDetails cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the appl apprej cmnts of this ffpb details.
	 *
	 * @return the appl apprej cmnts of this ffpb details
	 */
	@Override
	public String getApplApprejCmnts() {
		return model.getApplApprejCmnts();
	}

	/**
	 * Returns the company ID of this ffpb details.
	 *
	 * @return the company ID of this ffpb details
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this ffpb details.
	 *
	 * @return the create date of this ffpb details
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the date of birth of this ffpb details.
	 *
	 * @return the date of birth of this ffpb details
	 */
	@Override
	public Date getDateOfBirth() {
		return model.getDateOfBirth();
	}

	/**
	 * Returns the dlr reg no of this ffpb details.
	 *
	 * @return the dlr reg no of this ffpb details
	 */
	@Override
	public long getDlrRegNo() {
		return model.getDlrRegNo();
	}

	/**
	 * Returns the emial ID of this ffpb details.
	 *
	 * @return the emial ID of this ffpb details
	 */
	@Override
	public String getEmialId() {
		return model.getEmialId();
	}

	/**
	 * Returns the ffp appl crtd by of this ffpb details.
	 *
	 * @return the ffp appl crtd by of this ffpb details
	 */
	@Override
	public long getFfpApplCrtdBy() {
		return model.getFfpApplCrtdBy();
	}

	/**
	 * Returns the ffp appl mdfy by of this ffpb details.
	 *
	 * @return the ffp appl mdfy by of this ffpb details
	 */
	@Override
	public long getFfpApplMdfyBy() {
		return model.getFfpApplMdfyBy();
	}

	/**
	 * Returns the ffpb appl status of this ffpb details.
	 *
	 * @return the ffpb appl status of this ffpb details
	 */
	@Override
	public long getFfpbApplStatus() {
		return model.getFfpbApplStatus();
	}

	/**
	 * Returns the ffp card no of this ffpb details.
	 *
	 * @return the ffp card no of this ffpb details
	 */
	@Override
	public String getFfpCardNo() {
		return model.getFfpCardNo();
	}

	/**
	 * Returns the ffp regstr ID of this ffpb details.
	 *
	 * @return the ffp regstr ID of this ffpb details
	 */
	@Override
	public long getFfpRegstrId() {
		return model.getFfpRegstrId();
	}

	/**
	 * Returns the gender of this ffpb details.
	 *
	 * @return the gender of this ffpb details
	 */
	@Override
	public long getGender() {
		return model.getGender();
	}

	/**
	 * Returns the group ID of this ffpb details.
	 *
	 * @return the group ID of this ffpb details
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the marital status of this ffpb details.
	 *
	 * @return the marital status of this ffpb details
	 */
	@Override
	public long getMaritalStatus() {
		return model.getMaritalStatus();
	}

	/**
	 * Returns the mobile no of this ffpb details.
	 *
	 * @return the mobile no of this ffpb details
	 */
	@Override
	public String getMobileNo() {
		return model.getMobileNo();
	}

	/**
	 * Returns the modified date of this ffpb details.
	 *
	 * @return the modified date of this ffpb details
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the national ID of this ffpb details.
	 *
	 * @return the national ID of this ffpb details
	 */
	@Override
	public long getNationalId() {
		return model.getNationalId();
	}

	/**
	 * Returns the primary key of this ffpb details.
	 *
	 * @return the primary key of this ffpb details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the prst addr disrict of this ffpb details.
	 *
	 * @return the prst addr disrict of this ffpb details
	 */
	@Override
	public String getPrstAddrDisrict() {
		return model.getPrstAddrDisrict();
	}

	/**
	 * Returns the prst addr hoseaddr of this ffpb details.
	 *
	 * @return the prst addr hoseaddr of this ffpb details
	 */
	@Override
	public String getPrstAddrHoseaddr() {
		return model.getPrstAddrHoseaddr();
	}

	/**
	 * Returns the prst addr pstoffc of this ffpb details.
	 *
	 * @return the prst addr pstoffc of this ffpb details
	 */
	@Override
	public long getPrstAddrPstoffc() {
		return model.getPrstAddrPstoffc();
	}

	/**
	 * Returns the prst addr region of this ffpb details.
	 *
	 * @return the prst addr region of this ffpb details
	 */
	@Override
	public String getPrstAddrRegion() {
		return model.getPrstAddrRegion();
	}

	/**
	 * Returns the prst addr union of this ffpb details.
	 *
	 * @return the prst addr union of this ffpb details
	 */
	@Override
	public String getPrstAddrUnion() {
		return model.getPrstAddrUnion();
	}

	/**
	 * Returns the prst addr upzilla of this ffpb details.
	 *
	 * @return the prst addr upzilla of this ffpb details
	 */
	@Override
	public String getPrstAddrUpzilla() {
		return model.getPrstAddrUpzilla();
	}

	/**
	 * Returns the prst addr village of this ffpb details.
	 *
	 * @return the prst addr village of this ffpb details
	 */
	@Override
	public String getPrstAddrVillage() {
		return model.getPrstAddrVillage();
	}

	/**
	 * Returns the prst addr ward of this ffpb details.
	 *
	 * @return the prst addr ward of this ffpb details
	 */
	@Override
	public String getPrstAddrWard() {
		return model.getPrstAddrWard();
	}

	/**
	 * Returns the prst addr zip of this ffpb details.
	 *
	 * @return the prst addr zip of this ffpb details
	 */
	@Override
	public long getPrstAddrZip() {
		return model.getPrstAddrZip();
	}

	/**
	 * Returns the spouse nid of this ffpb details.
	 *
	 * @return the spouse nid of this ffpb details
	 */
	@Override
	public long getSpouseNid() {
		return model.getSpouseNid();
	}

	/**
	 * Returns the status of this ffpb details.
	 *
	 * @return the status of this ffpb details
	 */
	@Override
	public long getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this ffpb details.
	 *
	 * @return the status by user ID of this ffpb details
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user uuid of this ffpb details.
	 *
	 * @return the status by user uuid of this ffpb details
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this ffpb details.
	 *
	 * @return the status date of this ffpb details
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the version of this ffpb details.
	 *
	 * @return the version of this ffpb details
	 */
	@Override
	public float getVersion() {
		return model.getVersion();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the appl apprej cmnts of this ffpb details.
	 *
	 * @param applApprejCmnts the appl apprej cmnts of this ffpb details
	 */
	@Override
	public void setApplApprejCmnts(String applApprejCmnts) {
		model.setApplApprejCmnts(applApprejCmnts);
	}

	/**
	 * Sets the company ID of this ffpb details.
	 *
	 * @param companyId the company ID of this ffpb details
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this ffpb details.
	 *
	 * @param createDate the create date of this ffpb details
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the date of birth of this ffpb details.
	 *
	 * @param dateOfBirth the date of birth of this ffpb details
	 */
	@Override
	public void setDateOfBirth(Date dateOfBirth) {
		model.setDateOfBirth(dateOfBirth);
	}

	/**
	 * Sets the dlr reg no of this ffpb details.
	 *
	 * @param dlrRegNo the dlr reg no of this ffpb details
	 */
	@Override
	public void setDlrRegNo(long dlrRegNo) {
		model.setDlrRegNo(dlrRegNo);
	}

	/**
	 * Sets the emial ID of this ffpb details.
	 *
	 * @param emialId the emial ID of this ffpb details
	 */
	@Override
	public void setEmialId(String emialId) {
		model.setEmialId(emialId);
	}

	/**
	 * Sets the ffp appl crtd by of this ffpb details.
	 *
	 * @param ffpApplCrtdBy the ffp appl crtd by of this ffpb details
	 */
	@Override
	public void setFfpApplCrtdBy(long ffpApplCrtdBy) {
		model.setFfpApplCrtdBy(ffpApplCrtdBy);
	}

	/**
	 * Sets the ffp appl mdfy by of this ffpb details.
	 *
	 * @param ffpApplMdfyBy the ffp appl mdfy by of this ffpb details
	 */
	@Override
	public void setFfpApplMdfyBy(long ffpApplMdfyBy) {
		model.setFfpApplMdfyBy(ffpApplMdfyBy);
	}

	/**
	 * Sets the ffpb appl status of this ffpb details.
	 *
	 * @param ffpbApplStatus the ffpb appl status of this ffpb details
	 */
	@Override
	public void setFfpbApplStatus(long ffpbApplStatus) {
		model.setFfpbApplStatus(ffpbApplStatus);
	}

	/**
	 * Sets the ffp card no of this ffpb details.
	 *
	 * @param ffpCardNo the ffp card no of this ffpb details
	 */
	@Override
	public void setFfpCardNo(String ffpCardNo) {
		model.setFfpCardNo(ffpCardNo);
	}

	/**
	 * Sets the ffp regstr ID of this ffpb details.
	 *
	 * @param ffpRegstrId the ffp regstr ID of this ffpb details
	 */
	@Override
	public void setFfpRegstrId(long ffpRegstrId) {
		model.setFfpRegstrId(ffpRegstrId);
	}

	/**
	 * Sets the gender of this ffpb details.
	 *
	 * @param gender the gender of this ffpb details
	 */
	@Override
	public void setGender(long gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the group ID of this ffpb details.
	 *
	 * @param groupId the group ID of this ffpb details
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the marital status of this ffpb details.
	 *
	 * @param maritalStatus the marital status of this ffpb details
	 */
	@Override
	public void setMaritalStatus(long maritalStatus) {
		model.setMaritalStatus(maritalStatus);
	}

	/**
	 * Sets the mobile no of this ffpb details.
	 *
	 * @param mobileNo the mobile no of this ffpb details
	 */
	@Override
	public void setMobileNo(String mobileNo) {
		model.setMobileNo(mobileNo);
	}

	/**
	 * Sets the modified date of this ffpb details.
	 *
	 * @param modifiedDate the modified date of this ffpb details
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the national ID of this ffpb details.
	 *
	 * @param nationalId the national ID of this ffpb details
	 */
	@Override
	public void setNationalId(long nationalId) {
		model.setNationalId(nationalId);
	}

	/**
	 * Sets the primary key of this ffpb details.
	 *
	 * @param primaryKey the primary key of this ffpb details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the prst addr disrict of this ffpb details.
	 *
	 * @param prstAddrDisrict the prst addr disrict of this ffpb details
	 */
	@Override
	public void setPrstAddrDisrict(String prstAddrDisrict) {
		model.setPrstAddrDisrict(prstAddrDisrict);
	}

	/**
	 * Sets the prst addr hoseaddr of this ffpb details.
	 *
	 * @param prstAddrHoseaddr the prst addr hoseaddr of this ffpb details
	 */
	@Override
	public void setPrstAddrHoseaddr(String prstAddrHoseaddr) {
		model.setPrstAddrHoseaddr(prstAddrHoseaddr);
	}

	/**
	 * Sets the prst addr pstoffc of this ffpb details.
	 *
	 * @param prstAddrPstoffc the prst addr pstoffc of this ffpb details
	 */
	@Override
	public void setPrstAddrPstoffc(long prstAddrPstoffc) {
		model.setPrstAddrPstoffc(prstAddrPstoffc);
	}

	/**
	 * Sets the prst addr region of this ffpb details.
	 *
	 * @param prstAddrRegion the prst addr region of this ffpb details
	 */
	@Override
	public void setPrstAddrRegion(String prstAddrRegion) {
		model.setPrstAddrRegion(prstAddrRegion);
	}

	/**
	 * Sets the prst addr union of this ffpb details.
	 *
	 * @param prstAddrUnion the prst addr union of this ffpb details
	 */
	@Override
	public void setPrstAddrUnion(String prstAddrUnion) {
		model.setPrstAddrUnion(prstAddrUnion);
	}

	/**
	 * Sets the prst addr upzilla of this ffpb details.
	 *
	 * @param prstAddrUpzilla the prst addr upzilla of this ffpb details
	 */
	@Override
	public void setPrstAddrUpzilla(String prstAddrUpzilla) {
		model.setPrstAddrUpzilla(prstAddrUpzilla);
	}

	/**
	 * Sets the prst addr village of this ffpb details.
	 *
	 * @param prstAddrVillage the prst addr village of this ffpb details
	 */
	@Override
	public void setPrstAddrVillage(String prstAddrVillage) {
		model.setPrstAddrVillage(prstAddrVillage);
	}

	/**
	 * Sets the prst addr ward of this ffpb details.
	 *
	 * @param prstAddrWard the prst addr ward of this ffpb details
	 */
	@Override
	public void setPrstAddrWard(String prstAddrWard) {
		model.setPrstAddrWard(prstAddrWard);
	}

	/**
	 * Sets the prst addr zip of this ffpb details.
	 *
	 * @param prstAddrZip the prst addr zip of this ffpb details
	 */
	@Override
	public void setPrstAddrZip(long prstAddrZip) {
		model.setPrstAddrZip(prstAddrZip);
	}

	/**
	 * Sets the spouse nid of this ffpb details.
	 *
	 * @param spouseNid the spouse nid of this ffpb details
	 */
	@Override
	public void setSpouseNid(long spouseNid) {
		model.setSpouseNid(spouseNid);
	}

	/**
	 * Sets the status of this ffpb details.
	 *
	 * @param status the status of this ffpb details
	 */
	@Override
	public void setStatus(long status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this ffpb details.
	 *
	 * @param statusByUserId the status by user ID of this ffpb details
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user uuid of this ffpb details.
	 *
	 * @param statusByUserUuid the status by user uuid of this ffpb details
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this ffpb details.
	 *
	 * @param statusDate the status date of this ffpb details
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the version of this ffpb details.
	 *
	 * @param version the version of this ffpb details
	 */
	@Override
	public void setVersion(float version) {
		model.setVersion(version);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected FfpbDetailsWrapper wrap(FfpbDetails ffpbDetails) {
		return new FfpbDetailsWrapper(ffpbDetails);
	}

}