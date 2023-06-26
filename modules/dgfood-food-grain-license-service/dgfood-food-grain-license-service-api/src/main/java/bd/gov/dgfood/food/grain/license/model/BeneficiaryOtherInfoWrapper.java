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
 * This class is a wrapper for {@link BeneficiaryOtherInfo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BeneficiaryOtherInfo
 * @generated
 */
public class BeneficiaryOtherInfoWrapper
	extends BaseModelWrapper<BeneficiaryOtherInfo>
	implements BeneficiaryOtherInfo, ModelWrapper<BeneficiaryOtherInfo> {

	public BeneficiaryOtherInfoWrapper(
		BeneficiaryOtherInfo beneficiaryOtherInfo) {

		super(beneficiaryOtherInfo);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("verifiedId", getVerifiedId());
		attributes.put("maritalStatus", getMaritalStatus());
		attributes.put("spouseName", getSpouseName());
		attributes.put("spouseNid", getSpouseNid());
		attributes.put("spouseSecondNid", getSpouseSecondNid());
		attributes.put("spouseDob", getSpouseDob());
		attributes.put("fatherNid", getFatherNid());
		attributes.put("motherNid", getMotherNid());
		attributes.put("mobileNo", getMobileNo());
		attributes.put("mobileNoRelation", getMobileNoRelation());
		attributes.put("ecSpouseInfo", getEcSpouseInfo());
		attributes.put("occupation", getOccupation());
		attributes.put("villageName", getVillageName());
		attributes.put("wordNo", getWordNo());
		attributes.put("dealerName", getDealerName());
		attributes.put("dealerMobile", getDealerMobile());
		attributes.put("mobileVerifiedAt", getMobileVerifiedAt());
		attributes.put("familyEarningMember", getFamilyEarningMember());
		attributes.put("avgFamilyIncome", getAvgFamilyIncome());
		attributes.put("dependentFamilyMember", getDependentFamilyMember());
		attributes.put("landSize", getLandSize());
		attributes.put("landUnit", getLandUnit());
		attributes.put("remarks", getRemarks());
		attributes.put("userId", getUserId());
		attributes.put("createdAt", getCreatedAt());
		attributes.put("updatedAt", getUpdatedAt());
		attributes.put("dealerSlug", getDealerSlug());
		attributes.put("dealerId", getDealerId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long verifiedId = (Long)attributes.get("verifiedId");

		if (verifiedId != null) {
			setVerifiedId(verifiedId);
		}

		String maritalStatus = (String)attributes.get("maritalStatus");

		if (maritalStatus != null) {
			setMaritalStatus(maritalStatus);
		}

		String spouseName = (String)attributes.get("spouseName");

		if (spouseName != null) {
			setSpouseName(spouseName);
		}

		String spouseNid = (String)attributes.get("spouseNid");

		if (spouseNid != null) {
			setSpouseNid(spouseNid);
		}

		String spouseSecondNid = (String)attributes.get("spouseSecondNid");

		if (spouseSecondNid != null) {
			setSpouseSecondNid(spouseSecondNid);
		}

		Date spouseDob = (Date)attributes.get("spouseDob");

		if (spouseDob != null) {
			setSpouseDob(spouseDob);
		}

		String fatherNid = (String)attributes.get("fatherNid");

		if (fatherNid != null) {
			setFatherNid(fatherNid);
		}

		String motherNid = (String)attributes.get("motherNid");

		if (motherNid != null) {
			setMotherNid(motherNid);
		}

		String mobileNo = (String)attributes.get("mobileNo");

		if (mobileNo != null) {
			setMobileNo(mobileNo);
		}

		String mobileNoRelation = (String)attributes.get("mobileNoRelation");

		if (mobileNoRelation != null) {
			setMobileNoRelation(mobileNoRelation);
		}

		String ecSpouseInfo = (String)attributes.get("ecSpouseInfo");

		if (ecSpouseInfo != null) {
			setEcSpouseInfo(ecSpouseInfo);
		}

		String occupation = (String)attributes.get("occupation");

		if (occupation != null) {
			setOccupation(occupation);
		}

		String villageName = (String)attributes.get("villageName");

		if (villageName != null) {
			setVillageName(villageName);
		}

		String wordNo = (String)attributes.get("wordNo");

		if (wordNo != null) {
			setWordNo(wordNo);
		}

		String dealerName = (String)attributes.get("dealerName");

		if (dealerName != null) {
			setDealerName(dealerName);
		}

		String dealerMobile = (String)attributes.get("dealerMobile");

		if (dealerMobile != null) {
			setDealerMobile(dealerMobile);
		}

		Date mobileVerifiedAt = (Date)attributes.get("mobileVerifiedAt");

		if (mobileVerifiedAt != null) {
			setMobileVerifiedAt(mobileVerifiedAt);
		}

		Long familyEarningMember = (Long)attributes.get("familyEarningMember");

		if (familyEarningMember != null) {
			setFamilyEarningMember(familyEarningMember);
		}

		Long avgFamilyIncome = (Long)attributes.get("avgFamilyIncome");

		if (avgFamilyIncome != null) {
			setAvgFamilyIncome(avgFamilyIncome);
		}

		Long dependentFamilyMember = (Long)attributes.get(
			"dependentFamilyMember");

		if (dependentFamilyMember != null) {
			setDependentFamilyMember(dependentFamilyMember);
		}

		Long landSize = (Long)attributes.get("landSize");

		if (landSize != null) {
			setLandSize(landSize);
		}

		String landUnit = (String)attributes.get("landUnit");

		if (landUnit != null) {
			setLandUnit(landUnit);
		}

		String remarks = (String)attributes.get("remarks");

		if (remarks != null) {
			setRemarks(remarks);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createdAt = (Date)attributes.get("createdAt");

		if (createdAt != null) {
			setCreatedAt(createdAt);
		}

		Date updatedAt = (Date)attributes.get("updatedAt");

		if (updatedAt != null) {
			setUpdatedAt(updatedAt);
		}

		String dealerSlug = (String)attributes.get("dealerSlug");

		if (dealerSlug != null) {
			setDealerSlug(dealerSlug);
		}

		Long dealerId = (Long)attributes.get("dealerId");

		if (dealerId != null) {
			setDealerId(dealerId);
		}
	}

	@Override
	public BeneficiaryOtherInfo cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the avg family income of this beneficiary other info.
	 *
	 * @return the avg family income of this beneficiary other info
	 */
	@Override
	public long getAvgFamilyIncome() {
		return model.getAvgFamilyIncome();
	}

	/**
	 * Returns the created at of this beneficiary other info.
	 *
	 * @return the created at of this beneficiary other info
	 */
	@Override
	public Date getCreatedAt() {
		return model.getCreatedAt();
	}

	/**
	 * Returns the dealer ID of this beneficiary other info.
	 *
	 * @return the dealer ID of this beneficiary other info
	 */
	@Override
	public long getDealerId() {
		return model.getDealerId();
	}

	/**
	 * Returns the dealer mobile of this beneficiary other info.
	 *
	 * @return the dealer mobile of this beneficiary other info
	 */
	@Override
	public String getDealerMobile() {
		return model.getDealerMobile();
	}

	/**
	 * Returns the dealer name of this beneficiary other info.
	 *
	 * @return the dealer name of this beneficiary other info
	 */
	@Override
	public String getDealerName() {
		return model.getDealerName();
	}

	/**
	 * Returns the dealer slug of this beneficiary other info.
	 *
	 * @return the dealer slug of this beneficiary other info
	 */
	@Override
	public String getDealerSlug() {
		return model.getDealerSlug();
	}

	/**
	 * Returns the dependent family member of this beneficiary other info.
	 *
	 * @return the dependent family member of this beneficiary other info
	 */
	@Override
	public long getDependentFamilyMember() {
		return model.getDependentFamilyMember();
	}

	/**
	 * Returns the ec spouse info of this beneficiary other info.
	 *
	 * @return the ec spouse info of this beneficiary other info
	 */
	@Override
	public String getEcSpouseInfo() {
		return model.getEcSpouseInfo();
	}

	/**
	 * Returns the family earning member of this beneficiary other info.
	 *
	 * @return the family earning member of this beneficiary other info
	 */
	@Override
	public long getFamilyEarningMember() {
		return model.getFamilyEarningMember();
	}

	/**
	 * Returns the father nid of this beneficiary other info.
	 *
	 * @return the father nid of this beneficiary other info
	 */
	@Override
	public String getFatherNid() {
		return model.getFatherNid();
	}

	/**
	 * Returns the ID of this beneficiary other info.
	 *
	 * @return the ID of this beneficiary other info
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the land size of this beneficiary other info.
	 *
	 * @return the land size of this beneficiary other info
	 */
	@Override
	public long getLandSize() {
		return model.getLandSize();
	}

	/**
	 * Returns the land unit of this beneficiary other info.
	 *
	 * @return the land unit of this beneficiary other info
	 */
	@Override
	public String getLandUnit() {
		return model.getLandUnit();
	}

	/**
	 * Returns the marital status of this beneficiary other info.
	 *
	 * @return the marital status of this beneficiary other info
	 */
	@Override
	public String getMaritalStatus() {
		return model.getMaritalStatus();
	}

	/**
	 * Returns the mobile no of this beneficiary other info.
	 *
	 * @return the mobile no of this beneficiary other info
	 */
	@Override
	public String getMobileNo() {
		return model.getMobileNo();
	}

	/**
	 * Returns the mobile no relation of this beneficiary other info.
	 *
	 * @return the mobile no relation of this beneficiary other info
	 */
	@Override
	public String getMobileNoRelation() {
		return model.getMobileNoRelation();
	}

	/**
	 * Returns the mobile verified at of this beneficiary other info.
	 *
	 * @return the mobile verified at of this beneficiary other info
	 */
	@Override
	public Date getMobileVerifiedAt() {
		return model.getMobileVerifiedAt();
	}

	/**
	 * Returns the mother nid of this beneficiary other info.
	 *
	 * @return the mother nid of this beneficiary other info
	 */
	@Override
	public String getMotherNid() {
		return model.getMotherNid();
	}

	/**
	 * Returns the occupation of this beneficiary other info.
	 *
	 * @return the occupation of this beneficiary other info
	 */
	@Override
	public String getOccupation() {
		return model.getOccupation();
	}

	/**
	 * Returns the primary key of this beneficiary other info.
	 *
	 * @return the primary key of this beneficiary other info
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the remarks of this beneficiary other info.
	 *
	 * @return the remarks of this beneficiary other info
	 */
	@Override
	public String getRemarks() {
		return model.getRemarks();
	}

	/**
	 * Returns the spouse dob of this beneficiary other info.
	 *
	 * @return the spouse dob of this beneficiary other info
	 */
	@Override
	public Date getSpouseDob() {
		return model.getSpouseDob();
	}

	/**
	 * Returns the spouse name of this beneficiary other info.
	 *
	 * @return the spouse name of this beneficiary other info
	 */
	@Override
	public String getSpouseName() {
		return model.getSpouseName();
	}

	/**
	 * Returns the spouse nid of this beneficiary other info.
	 *
	 * @return the spouse nid of this beneficiary other info
	 */
	@Override
	public String getSpouseNid() {
		return model.getSpouseNid();
	}

	/**
	 * Returns the spouse second nid of this beneficiary other info.
	 *
	 * @return the spouse second nid of this beneficiary other info
	 */
	@Override
	public String getSpouseSecondNid() {
		return model.getSpouseSecondNid();
	}

	/**
	 * Returns the updated at of this beneficiary other info.
	 *
	 * @return the updated at of this beneficiary other info
	 */
	@Override
	public Date getUpdatedAt() {
		return model.getUpdatedAt();
	}

	/**
	 * Returns the user ID of this beneficiary other info.
	 *
	 * @return the user ID of this beneficiary other info
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this beneficiary other info.
	 *
	 * @return the user uuid of this beneficiary other info
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the verified ID of this beneficiary other info.
	 *
	 * @return the verified ID of this beneficiary other info
	 */
	@Override
	public long getVerifiedId() {
		return model.getVerifiedId();
	}

	/**
	 * Returns the village name of this beneficiary other info.
	 *
	 * @return the village name of this beneficiary other info
	 */
	@Override
	public String getVillageName() {
		return model.getVillageName();
	}

	/**
	 * Returns the word no of this beneficiary other info.
	 *
	 * @return the word no of this beneficiary other info
	 */
	@Override
	public String getWordNo() {
		return model.getWordNo();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the avg family income of this beneficiary other info.
	 *
	 * @param avgFamilyIncome the avg family income of this beneficiary other info
	 */
	@Override
	public void setAvgFamilyIncome(long avgFamilyIncome) {
		model.setAvgFamilyIncome(avgFamilyIncome);
	}

	/**
	 * Sets the created at of this beneficiary other info.
	 *
	 * @param createdAt the created at of this beneficiary other info
	 */
	@Override
	public void setCreatedAt(Date createdAt) {
		model.setCreatedAt(createdAt);
	}

	/**
	 * Sets the dealer ID of this beneficiary other info.
	 *
	 * @param dealerId the dealer ID of this beneficiary other info
	 */
	@Override
	public void setDealerId(long dealerId) {
		model.setDealerId(dealerId);
	}

	/**
	 * Sets the dealer mobile of this beneficiary other info.
	 *
	 * @param dealerMobile the dealer mobile of this beneficiary other info
	 */
	@Override
	public void setDealerMobile(String dealerMobile) {
		model.setDealerMobile(dealerMobile);
	}

	/**
	 * Sets the dealer name of this beneficiary other info.
	 *
	 * @param dealerName the dealer name of this beneficiary other info
	 */
	@Override
	public void setDealerName(String dealerName) {
		model.setDealerName(dealerName);
	}

	/**
	 * Sets the dealer slug of this beneficiary other info.
	 *
	 * @param dealerSlug the dealer slug of this beneficiary other info
	 */
	@Override
	public void setDealerSlug(String dealerSlug) {
		model.setDealerSlug(dealerSlug);
	}

	/**
	 * Sets the dependent family member of this beneficiary other info.
	 *
	 * @param dependentFamilyMember the dependent family member of this beneficiary other info
	 */
	@Override
	public void setDependentFamilyMember(long dependentFamilyMember) {
		model.setDependentFamilyMember(dependentFamilyMember);
	}

	/**
	 * Sets the ec spouse info of this beneficiary other info.
	 *
	 * @param ecSpouseInfo the ec spouse info of this beneficiary other info
	 */
	@Override
	public void setEcSpouseInfo(String ecSpouseInfo) {
		model.setEcSpouseInfo(ecSpouseInfo);
	}

	/**
	 * Sets the family earning member of this beneficiary other info.
	 *
	 * @param familyEarningMember the family earning member of this beneficiary other info
	 */
	@Override
	public void setFamilyEarningMember(long familyEarningMember) {
		model.setFamilyEarningMember(familyEarningMember);
	}

	/**
	 * Sets the father nid of this beneficiary other info.
	 *
	 * @param fatherNid the father nid of this beneficiary other info
	 */
	@Override
	public void setFatherNid(String fatherNid) {
		model.setFatherNid(fatherNid);
	}

	/**
	 * Sets the ID of this beneficiary other info.
	 *
	 * @param id the ID of this beneficiary other info
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the land size of this beneficiary other info.
	 *
	 * @param landSize the land size of this beneficiary other info
	 */
	@Override
	public void setLandSize(long landSize) {
		model.setLandSize(landSize);
	}

	/**
	 * Sets the land unit of this beneficiary other info.
	 *
	 * @param landUnit the land unit of this beneficiary other info
	 */
	@Override
	public void setLandUnit(String landUnit) {
		model.setLandUnit(landUnit);
	}

	/**
	 * Sets the marital status of this beneficiary other info.
	 *
	 * @param maritalStatus the marital status of this beneficiary other info
	 */
	@Override
	public void setMaritalStatus(String maritalStatus) {
		model.setMaritalStatus(maritalStatus);
	}

	/**
	 * Sets the mobile no of this beneficiary other info.
	 *
	 * @param mobileNo the mobile no of this beneficiary other info
	 */
	@Override
	public void setMobileNo(String mobileNo) {
		model.setMobileNo(mobileNo);
	}

	/**
	 * Sets the mobile no relation of this beneficiary other info.
	 *
	 * @param mobileNoRelation the mobile no relation of this beneficiary other info
	 */
	@Override
	public void setMobileNoRelation(String mobileNoRelation) {
		model.setMobileNoRelation(mobileNoRelation);
	}

	/**
	 * Sets the mobile verified at of this beneficiary other info.
	 *
	 * @param mobileVerifiedAt the mobile verified at of this beneficiary other info
	 */
	@Override
	public void setMobileVerifiedAt(Date mobileVerifiedAt) {
		model.setMobileVerifiedAt(mobileVerifiedAt);
	}

	/**
	 * Sets the mother nid of this beneficiary other info.
	 *
	 * @param motherNid the mother nid of this beneficiary other info
	 */
	@Override
	public void setMotherNid(String motherNid) {
		model.setMotherNid(motherNid);
	}

	/**
	 * Sets the occupation of this beneficiary other info.
	 *
	 * @param occupation the occupation of this beneficiary other info
	 */
	@Override
	public void setOccupation(String occupation) {
		model.setOccupation(occupation);
	}

	/**
	 * Sets the primary key of this beneficiary other info.
	 *
	 * @param primaryKey the primary key of this beneficiary other info
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the remarks of this beneficiary other info.
	 *
	 * @param remarks the remarks of this beneficiary other info
	 */
	@Override
	public void setRemarks(String remarks) {
		model.setRemarks(remarks);
	}

	/**
	 * Sets the spouse dob of this beneficiary other info.
	 *
	 * @param spouseDob the spouse dob of this beneficiary other info
	 */
	@Override
	public void setSpouseDob(Date spouseDob) {
		model.setSpouseDob(spouseDob);
	}

	/**
	 * Sets the spouse name of this beneficiary other info.
	 *
	 * @param spouseName the spouse name of this beneficiary other info
	 */
	@Override
	public void setSpouseName(String spouseName) {
		model.setSpouseName(spouseName);
	}

	/**
	 * Sets the spouse nid of this beneficiary other info.
	 *
	 * @param spouseNid the spouse nid of this beneficiary other info
	 */
	@Override
	public void setSpouseNid(String spouseNid) {
		model.setSpouseNid(spouseNid);
	}

	/**
	 * Sets the spouse second nid of this beneficiary other info.
	 *
	 * @param spouseSecondNid the spouse second nid of this beneficiary other info
	 */
	@Override
	public void setSpouseSecondNid(String spouseSecondNid) {
		model.setSpouseSecondNid(spouseSecondNid);
	}

	/**
	 * Sets the updated at of this beneficiary other info.
	 *
	 * @param updatedAt the updated at of this beneficiary other info
	 */
	@Override
	public void setUpdatedAt(Date updatedAt) {
		model.setUpdatedAt(updatedAt);
	}

	/**
	 * Sets the user ID of this beneficiary other info.
	 *
	 * @param userId the user ID of this beneficiary other info
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this beneficiary other info.
	 *
	 * @param userUuid the user uuid of this beneficiary other info
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the verified ID of this beneficiary other info.
	 *
	 * @param verifiedId the verified ID of this beneficiary other info
	 */
	@Override
	public void setVerifiedId(long verifiedId) {
		model.setVerifiedId(verifiedId);
	}

	/**
	 * Sets the village name of this beneficiary other info.
	 *
	 * @param villageName the village name of this beneficiary other info
	 */
	@Override
	public void setVillageName(String villageName) {
		model.setVillageName(villageName);
	}

	/**
	 * Sets the word no of this beneficiary other info.
	 *
	 * @param wordNo the word no of this beneficiary other info
	 */
	@Override
	public void setWordNo(String wordNo) {
		model.setWordNo(wordNo);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected BeneficiaryOtherInfoWrapper wrap(
		BeneficiaryOtherInfo beneficiaryOtherInfo) {

		return new BeneficiaryOtherInfoWrapper(beneficiaryOtherInfo);
	}

}