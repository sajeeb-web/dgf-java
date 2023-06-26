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
 * This class is a wrapper for {@link DgfDlrRegDtls}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrRegDtls
 * @generated
 */
public class DgfDlrRegDtlsWrapper
	extends BaseModelWrapper<DgfDlrRegDtls>
	implements DgfDlrRegDtls, ModelWrapper<DgfDlrRegDtls> {

	public DgfDlrRegDtlsWrapper(DgfDlrRegDtls dgfDlrRegDtls) {
		super(dgfDlrRegDtls);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dlrRegNo", getDlrRegNo());
		attributes.put("nationalId", getNationalId());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("dlrRegApplNo", getDlrRegApplNo());
		attributes.put("fglLicnsNo", getFglLicnsNo());
		attributes.put("fglLicnsIssueDate", getFglLicnsIssueDate());
		attributes.put("trdLicnsNo", getTrdLicnsNo());
		attributes.put("trdLicnsExpDate", getTrdLicnsExpDate());
		attributes.put("dlrTypeId", getDlrTypeId());
		attributes.put("maritalStatus", getMaritalStatus());
		attributes.put("spouseName", getSpouseName());
		attributes.put("spouseFthrName", getSpouseFthrName());
		attributes.put("spouseNid", getSpouseNid());
		attributes.put("spouseBrthDate", getSpouseBrthDate());
		attributes.put("dlrRegExpiryDate", getDlrRegExpiryDate());
		attributes.put("sapBuCode", getSapBuCode());
		attributes.put("dlrRegApplStatus", getDlrRegApplStatus());
		attributes.put("dlrRegCrtdDate", getDlrRegCrtdDate());
		attributes.put("pymntTrnRefNo", getPymntTrnRefNo());
		attributes.put("pymntTrnStatus", getPymntTrnStatus());
		attributes.put("challanDocId", getChallanDocId());
		attributes.put("incmTaxAttchID", getIncmTaxAttchID());
		attributes.put("bnkSolvncyCertId", getBnkSolvncyCertId());
		attributes.put("shpOwnshipDocuId", getShpOwnshipDocuId());
		attributes.put("shpRentedDocuId", getShpRentedDocuId());
		attributes.put("signatureId", getSignatureId());
		attributes.put("dlrApprRjctComments", getDlrApprRjctComments());
		attributes.put("dlrRegApprRejRmrk", getDlrRegApprRejRmrk());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("version", getVersion());
		attributes.put("dlrRegCrtdBy", getDlrRegCrtdBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("lastUpdtdBy", getLastUpdtdBy());
		attributes.put("modifedDate", getModifedDate());
		attributes.put("dlrOmsSubType", getDlrOmsSubType());
		attributes.put("division", getDivision());
		attributes.put("district", getDistrict());
		attributes.put("upzilla", getUpzilla());
		attributes.put("unionName", getUnionName());
		attributes.put("dlrBrthDate", getDlrBrthDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dlrRegNo = (Long)attributes.get("dlrRegNo");

		if (dlrRegNo != null) {
			setDlrRegNo(dlrRegNo);
		}

		String nationalId = (String)attributes.get("nationalId");

		if (nationalId != null) {
			setNationalId(nationalId);
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

		Long dlrRegApplNo = (Long)attributes.get("dlrRegApplNo");

		if (dlrRegApplNo != null) {
			setDlrRegApplNo(dlrRegApplNo);
		}

		String fglLicnsNo = (String)attributes.get("fglLicnsNo");

		if (fglLicnsNo != null) {
			setFglLicnsNo(fglLicnsNo);
		}

		Date fglLicnsIssueDate = (Date)attributes.get("fglLicnsIssueDate");

		if (fglLicnsIssueDate != null) {
			setFglLicnsIssueDate(fglLicnsIssueDate);
		}

		Long trdLicnsNo = (Long)attributes.get("trdLicnsNo");

		if (trdLicnsNo != null) {
			setTrdLicnsNo(trdLicnsNo);
		}

		Date trdLicnsExpDate = (Date)attributes.get("trdLicnsExpDate");

		if (trdLicnsExpDate != null) {
			setTrdLicnsExpDate(trdLicnsExpDate);
		}

		String dlrTypeId = (String)attributes.get("dlrTypeId");

		if (dlrTypeId != null) {
			setDlrTypeId(dlrTypeId);
		}

		String maritalStatus = (String)attributes.get("maritalStatus");

		if (maritalStatus != null) {
			setMaritalStatus(maritalStatus);
		}

		String spouseName = (String)attributes.get("spouseName");

		if (spouseName != null) {
			setSpouseName(spouseName);
		}

		String spouseFthrName = (String)attributes.get("spouseFthrName");

		if (spouseFthrName != null) {
			setSpouseFthrName(spouseFthrName);
		}

		String spouseNid = (String)attributes.get("spouseNid");

		if (spouseNid != null) {
			setSpouseNid(spouseNid);
		}

		Date spouseBrthDate = (Date)attributes.get("spouseBrthDate");

		if (spouseBrthDate != null) {
			setSpouseBrthDate(spouseBrthDate);
		}

		Date dlrRegExpiryDate = (Date)attributes.get("dlrRegExpiryDate");

		if (dlrRegExpiryDate != null) {
			setDlrRegExpiryDate(dlrRegExpiryDate);
		}

		String sapBuCode = (String)attributes.get("sapBuCode");

		if (sapBuCode != null) {
			setSapBuCode(sapBuCode);
		}

		String dlrRegApplStatus = (String)attributes.get("dlrRegApplStatus");

		if (dlrRegApplStatus != null) {
			setDlrRegApplStatus(dlrRegApplStatus);
		}

		Date dlrRegCrtdDate = (Date)attributes.get("dlrRegCrtdDate");

		if (dlrRegCrtdDate != null) {
			setDlrRegCrtdDate(dlrRegCrtdDate);
		}

		Long pymntTrnRefNo = (Long)attributes.get("pymntTrnRefNo");

		if (pymntTrnRefNo != null) {
			setPymntTrnRefNo(pymntTrnRefNo);
		}

		String pymntTrnStatus = (String)attributes.get("pymntTrnStatus");

		if (pymntTrnStatus != null) {
			setPymntTrnStatus(pymntTrnStatus);
		}

		Long challanDocId = (Long)attributes.get("challanDocId");

		if (challanDocId != null) {
			setChallanDocId(challanDocId);
		}

		Long incmTaxAttchID = (Long)attributes.get("incmTaxAttchID");

		if (incmTaxAttchID != null) {
			setIncmTaxAttchID(incmTaxAttchID);
		}

		Long bnkSolvncyCertId = (Long)attributes.get("bnkSolvncyCertId");

		if (bnkSolvncyCertId != null) {
			setBnkSolvncyCertId(bnkSolvncyCertId);
		}

		Long shpOwnshipDocuId = (Long)attributes.get("shpOwnshipDocuId");

		if (shpOwnshipDocuId != null) {
			setShpOwnshipDocuId(shpOwnshipDocuId);
		}

		Long shpRentedDocuId = (Long)attributes.get("shpRentedDocuId");

		if (shpRentedDocuId != null) {
			setShpRentedDocuId(shpRentedDocuId);
		}

		Long signatureId = (Long)attributes.get("signatureId");

		if (signatureId != null) {
			setSignatureId(signatureId);
		}

		String dlrApprRjctComments = (String)attributes.get(
			"dlrApprRjctComments");

		if (dlrApprRjctComments != null) {
			setDlrApprRjctComments(dlrApprRjctComments);
		}

		String dlrRegApprRejRmrk = (String)attributes.get("dlrRegApprRejRmrk");

		if (dlrRegApprRejRmrk != null) {
			setDlrRegApprRejRmrk(dlrRegApprRejRmrk);
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

		Long version = (Long)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		String dlrRegCrtdBy = (String)attributes.get("dlrRegCrtdBy");

		if (dlrRegCrtdBy != null) {
			setDlrRegCrtdBy(dlrRegCrtdBy);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long lastUpdtdBy = (Long)attributes.get("lastUpdtdBy");

		if (lastUpdtdBy != null) {
			setLastUpdtdBy(lastUpdtdBy);
		}

		Date modifedDate = (Date)attributes.get("modifedDate");

		if (modifedDate != null) {
			setModifedDate(modifedDate);
		}

		String dlrOmsSubType = (String)attributes.get("dlrOmsSubType");

		if (dlrOmsSubType != null) {
			setDlrOmsSubType(dlrOmsSubType);
		}

		Long division = (Long)attributes.get("division");

		if (division != null) {
			setDivision(division);
		}

		Long district = (Long)attributes.get("district");

		if (district != null) {
			setDistrict(district);
		}

		Long upzilla = (Long)attributes.get("upzilla");

		if (upzilla != null) {
			setUpzilla(upzilla);
		}

		Long unionName = (Long)attributes.get("unionName");

		if (unionName != null) {
			setUnionName(unionName);
		}

		Date dlrBrthDate = (Date)attributes.get("dlrBrthDate");

		if (dlrBrthDate != null) {
			setDlrBrthDate(dlrBrthDate);
		}
	}

	@Override
	public DgfDlrRegDtls cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the bnk solvncy cert ID of this dgf dlr reg dtls.
	 *
	 * @return the bnk solvncy cert ID of this dgf dlr reg dtls
	 */
	@Override
	public long getBnkSolvncyCertId() {
		return model.getBnkSolvncyCertId();
	}

	/**
	 * Returns the challan doc ID of this dgf dlr reg dtls.
	 *
	 * @return the challan doc ID of this dgf dlr reg dtls
	 */
	@Override
	public long getChallanDocId() {
		return model.getChallanDocId();
	}

	/**
	 * Returns the company ID of this dgf dlr reg dtls.
	 *
	 * @return the company ID of this dgf dlr reg dtls
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this dgf dlr reg dtls.
	 *
	 * @return the create date of this dgf dlr reg dtls
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the district of this dgf dlr reg dtls.
	 *
	 * @return the district of this dgf dlr reg dtls
	 */
	@Override
	public long getDistrict() {
		return model.getDistrict();
	}

	/**
	 * Returns the division of this dgf dlr reg dtls.
	 *
	 * @return the division of this dgf dlr reg dtls
	 */
	@Override
	public long getDivision() {
		return model.getDivision();
	}

	/**
	 * Returns the dlr appr rjct comments of this dgf dlr reg dtls.
	 *
	 * @return the dlr appr rjct comments of this dgf dlr reg dtls
	 */
	@Override
	public String getDlrApprRjctComments() {
		return model.getDlrApprRjctComments();
	}

	/**
	 * Returns the dlr brth date of this dgf dlr reg dtls.
	 *
	 * @return the dlr brth date of this dgf dlr reg dtls
	 */
	@Override
	public Date getDlrBrthDate() {
		return model.getDlrBrthDate();
	}

	/**
	 * Returns the dlr oms sub type of this dgf dlr reg dtls.
	 *
	 * @return the dlr oms sub type of this dgf dlr reg dtls
	 */
	@Override
	public String getDlrOmsSubType() {
		return model.getDlrOmsSubType();
	}

	/**
	 * Returns the dlr reg appl no of this dgf dlr reg dtls.
	 *
	 * @return the dlr reg appl no of this dgf dlr reg dtls
	 */
	@Override
	public long getDlrRegApplNo() {
		return model.getDlrRegApplNo();
	}

	/**
	 * Returns the dlr reg appl status of this dgf dlr reg dtls.
	 *
	 * @return the dlr reg appl status of this dgf dlr reg dtls
	 */
	@Override
	public String getDlrRegApplStatus() {
		return model.getDlrRegApplStatus();
	}

	/**
	 * Returns the dlr reg appr rej rmrk of this dgf dlr reg dtls.
	 *
	 * @return the dlr reg appr rej rmrk of this dgf dlr reg dtls
	 */
	@Override
	public String getDlrRegApprRejRmrk() {
		return model.getDlrRegApprRejRmrk();
	}

	/**
	 * Returns the dlr reg crtd by of this dgf dlr reg dtls.
	 *
	 * @return the dlr reg crtd by of this dgf dlr reg dtls
	 */
	@Override
	public String getDlrRegCrtdBy() {
		return model.getDlrRegCrtdBy();
	}

	/**
	 * Returns the dlr reg crtd date of this dgf dlr reg dtls.
	 *
	 * @return the dlr reg crtd date of this dgf dlr reg dtls
	 */
	@Override
	public Date getDlrRegCrtdDate() {
		return model.getDlrRegCrtdDate();
	}

	/**
	 * Returns the dlr reg expiry date of this dgf dlr reg dtls.
	 *
	 * @return the dlr reg expiry date of this dgf dlr reg dtls
	 */
	@Override
	public Date getDlrRegExpiryDate() {
		return model.getDlrRegExpiryDate();
	}

	/**
	 * Returns the dlr reg no of this dgf dlr reg dtls.
	 *
	 * @return the dlr reg no of this dgf dlr reg dtls
	 */
	@Override
	public long getDlrRegNo() {
		return model.getDlrRegNo();
	}

	/**
	 * Returns the dlr type ID of this dgf dlr reg dtls.
	 *
	 * @return the dlr type ID of this dgf dlr reg dtls
	 */
	@Override
	public String getDlrTypeId() {
		return model.getDlrTypeId();
	}

	/**
	 * Returns the fgl licns issue date of this dgf dlr reg dtls.
	 *
	 * @return the fgl licns issue date of this dgf dlr reg dtls
	 */
	@Override
	public Date getFglLicnsIssueDate() {
		return model.getFglLicnsIssueDate();
	}

	/**
	 * Returns the fgl licns no of this dgf dlr reg dtls.
	 *
	 * @return the fgl licns no of this dgf dlr reg dtls
	 */
	@Override
	public String getFglLicnsNo() {
		return model.getFglLicnsNo();
	}

	/**
	 * Returns the group ID of this dgf dlr reg dtls.
	 *
	 * @return the group ID of this dgf dlr reg dtls
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the incm tax attch ID of this dgf dlr reg dtls.
	 *
	 * @return the incm tax attch ID of this dgf dlr reg dtls
	 */
	@Override
	public long getIncmTaxAttchID() {
		return model.getIncmTaxAttchID();
	}

	/**
	 * Returns the last updtd by of this dgf dlr reg dtls.
	 *
	 * @return the last updtd by of this dgf dlr reg dtls
	 */
	@Override
	public long getLastUpdtdBy() {
		return model.getLastUpdtdBy();
	}

	/**
	 * Returns the marital status of this dgf dlr reg dtls.
	 *
	 * @return the marital status of this dgf dlr reg dtls
	 */
	@Override
	public String getMaritalStatus() {
		return model.getMaritalStatus();
	}

	/**
	 * Returns the modifed date of this dgf dlr reg dtls.
	 *
	 * @return the modifed date of this dgf dlr reg dtls
	 */
	@Override
	public Date getModifedDate() {
		return model.getModifedDate();
	}

	/**
	 * Returns the national ID of this dgf dlr reg dtls.
	 *
	 * @return the national ID of this dgf dlr reg dtls
	 */
	@Override
	public String getNationalId() {
		return model.getNationalId();
	}

	/**
	 * Returns the primary key of this dgf dlr reg dtls.
	 *
	 * @return the primary key of this dgf dlr reg dtls
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the pymnt trn ref no of this dgf dlr reg dtls.
	 *
	 * @return the pymnt trn ref no of this dgf dlr reg dtls
	 */
	@Override
	public long getPymntTrnRefNo() {
		return model.getPymntTrnRefNo();
	}

	/**
	 * Returns the pymnt trn status of this dgf dlr reg dtls.
	 *
	 * @return the pymnt trn status of this dgf dlr reg dtls
	 */
	@Override
	public String getPymntTrnStatus() {
		return model.getPymntTrnStatus();
	}

	/**
	 * Returns the sap bu code of this dgf dlr reg dtls.
	 *
	 * @return the sap bu code of this dgf dlr reg dtls
	 */
	@Override
	public String getSapBuCode() {
		return model.getSapBuCode();
	}

	/**
	 * Returns the shp ownship docu ID of this dgf dlr reg dtls.
	 *
	 * @return the shp ownship docu ID of this dgf dlr reg dtls
	 */
	@Override
	public long getShpOwnshipDocuId() {
		return model.getShpOwnshipDocuId();
	}

	/**
	 * Returns the shp rented docu ID of this dgf dlr reg dtls.
	 *
	 * @return the shp rented docu ID of this dgf dlr reg dtls
	 */
	@Override
	public long getShpRentedDocuId() {
		return model.getShpRentedDocuId();
	}

	/**
	 * Returns the signature ID of this dgf dlr reg dtls.
	 *
	 * @return the signature ID of this dgf dlr reg dtls
	 */
	@Override
	public long getSignatureId() {
		return model.getSignatureId();
	}

	/**
	 * Returns the spouse brth date of this dgf dlr reg dtls.
	 *
	 * @return the spouse brth date of this dgf dlr reg dtls
	 */
	@Override
	public Date getSpouseBrthDate() {
		return model.getSpouseBrthDate();
	}

	/**
	 * Returns the spouse fthr name of this dgf dlr reg dtls.
	 *
	 * @return the spouse fthr name of this dgf dlr reg dtls
	 */
	@Override
	public String getSpouseFthrName() {
		return model.getSpouseFthrName();
	}

	/**
	 * Returns the spouse name of this dgf dlr reg dtls.
	 *
	 * @return the spouse name of this dgf dlr reg dtls
	 */
	@Override
	public String getSpouseName() {
		return model.getSpouseName();
	}

	/**
	 * Returns the spouse nid of this dgf dlr reg dtls.
	 *
	 * @return the spouse nid of this dgf dlr reg dtls
	 */
	@Override
	public String getSpouseNid() {
		return model.getSpouseNid();
	}

	/**
	 * Returns the status of this dgf dlr reg dtls.
	 *
	 * @return the status of this dgf dlr reg dtls
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this dgf dlr reg dtls.
	 *
	 * @return the status by user ID of this dgf dlr reg dtls
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this dgf dlr reg dtls.
	 *
	 * @return the status by user name of this dgf dlr reg dtls
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this dgf dlr reg dtls.
	 *
	 * @return the status by user uuid of this dgf dlr reg dtls
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this dgf dlr reg dtls.
	 *
	 * @return the status date of this dgf dlr reg dtls
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the trd licns exp date of this dgf dlr reg dtls.
	 *
	 * @return the trd licns exp date of this dgf dlr reg dtls
	 */
	@Override
	public Date getTrdLicnsExpDate() {
		return model.getTrdLicnsExpDate();
	}

	/**
	 * Returns the trd licns no of this dgf dlr reg dtls.
	 *
	 * @return the trd licns no of this dgf dlr reg dtls
	 */
	@Override
	public long getTrdLicnsNo() {
		return model.getTrdLicnsNo();
	}

	/**
	 * Returns the union name of this dgf dlr reg dtls.
	 *
	 * @return the union name of this dgf dlr reg dtls
	 */
	@Override
	public long getUnionName() {
		return model.getUnionName();
	}

	/**
	 * Returns the upzilla of this dgf dlr reg dtls.
	 *
	 * @return the upzilla of this dgf dlr reg dtls
	 */
	@Override
	public long getUpzilla() {
		return model.getUpzilla();
	}

	/**
	 * Returns the user ID of this dgf dlr reg dtls.
	 *
	 * @return the user ID of this dgf dlr reg dtls
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this dgf dlr reg dtls.
	 *
	 * @return the user uuid of this dgf dlr reg dtls
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the version of this dgf dlr reg dtls.
	 *
	 * @return the version of this dgf dlr reg dtls
	 */
	@Override
	public long getVersion() {
		return model.getVersion();
	}

	/**
	 * Returns <code>true</code> if this dgf dlr reg dtls is approved.
	 *
	 * @return <code>true</code> if this dgf dlr reg dtls is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this dgf dlr reg dtls is denied.
	 *
	 * @return <code>true</code> if this dgf dlr reg dtls is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this dgf dlr reg dtls is a draft.
	 *
	 * @return <code>true</code> if this dgf dlr reg dtls is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this dgf dlr reg dtls is expired.
	 *
	 * @return <code>true</code> if this dgf dlr reg dtls is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this dgf dlr reg dtls is inactive.
	 *
	 * @return <code>true</code> if this dgf dlr reg dtls is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this dgf dlr reg dtls is incomplete.
	 *
	 * @return <code>true</code> if this dgf dlr reg dtls is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this dgf dlr reg dtls is pending.
	 *
	 * @return <code>true</code> if this dgf dlr reg dtls is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this dgf dlr reg dtls is scheduled.
	 *
	 * @return <code>true</code> if this dgf dlr reg dtls is scheduled; <code>false</code> otherwise
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
	 * Sets the bnk solvncy cert ID of this dgf dlr reg dtls.
	 *
	 * @param bnkSolvncyCertId the bnk solvncy cert ID of this dgf dlr reg dtls
	 */
	@Override
	public void setBnkSolvncyCertId(long bnkSolvncyCertId) {
		model.setBnkSolvncyCertId(bnkSolvncyCertId);
	}

	/**
	 * Sets the challan doc ID of this dgf dlr reg dtls.
	 *
	 * @param challanDocId the challan doc ID of this dgf dlr reg dtls
	 */
	@Override
	public void setChallanDocId(long challanDocId) {
		model.setChallanDocId(challanDocId);
	}

	/**
	 * Sets the company ID of this dgf dlr reg dtls.
	 *
	 * @param companyId the company ID of this dgf dlr reg dtls
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this dgf dlr reg dtls.
	 *
	 * @param createDate the create date of this dgf dlr reg dtls
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the district of this dgf dlr reg dtls.
	 *
	 * @param district the district of this dgf dlr reg dtls
	 */
	@Override
	public void setDistrict(long district) {
		model.setDistrict(district);
	}

	/**
	 * Sets the division of this dgf dlr reg dtls.
	 *
	 * @param division the division of this dgf dlr reg dtls
	 */
	@Override
	public void setDivision(long division) {
		model.setDivision(division);
	}

	/**
	 * Sets the dlr appr rjct comments of this dgf dlr reg dtls.
	 *
	 * @param dlrApprRjctComments the dlr appr rjct comments of this dgf dlr reg dtls
	 */
	@Override
	public void setDlrApprRjctComments(String dlrApprRjctComments) {
		model.setDlrApprRjctComments(dlrApprRjctComments);
	}

	/**
	 * Sets the dlr brth date of this dgf dlr reg dtls.
	 *
	 * @param dlrBrthDate the dlr brth date of this dgf dlr reg dtls
	 */
	@Override
	public void setDlrBrthDate(Date dlrBrthDate) {
		model.setDlrBrthDate(dlrBrthDate);
	}

	/**
	 * Sets the dlr oms sub type of this dgf dlr reg dtls.
	 *
	 * @param dlrOmsSubType the dlr oms sub type of this dgf dlr reg dtls
	 */
	@Override
	public void setDlrOmsSubType(String dlrOmsSubType) {
		model.setDlrOmsSubType(dlrOmsSubType);
	}

	/**
	 * Sets the dlr reg appl no of this dgf dlr reg dtls.
	 *
	 * @param dlrRegApplNo the dlr reg appl no of this dgf dlr reg dtls
	 */
	@Override
	public void setDlrRegApplNo(long dlrRegApplNo) {
		model.setDlrRegApplNo(dlrRegApplNo);
	}

	/**
	 * Sets the dlr reg appl status of this dgf dlr reg dtls.
	 *
	 * @param dlrRegApplStatus the dlr reg appl status of this dgf dlr reg dtls
	 */
	@Override
	public void setDlrRegApplStatus(String dlrRegApplStatus) {
		model.setDlrRegApplStatus(dlrRegApplStatus);
	}

	/**
	 * Sets the dlr reg appr rej rmrk of this dgf dlr reg dtls.
	 *
	 * @param dlrRegApprRejRmrk the dlr reg appr rej rmrk of this dgf dlr reg dtls
	 */
	@Override
	public void setDlrRegApprRejRmrk(String dlrRegApprRejRmrk) {
		model.setDlrRegApprRejRmrk(dlrRegApprRejRmrk);
	}

	/**
	 * Sets the dlr reg crtd by of this dgf dlr reg dtls.
	 *
	 * @param dlrRegCrtdBy the dlr reg crtd by of this dgf dlr reg dtls
	 */
	@Override
	public void setDlrRegCrtdBy(String dlrRegCrtdBy) {
		model.setDlrRegCrtdBy(dlrRegCrtdBy);
	}

	/**
	 * Sets the dlr reg crtd date of this dgf dlr reg dtls.
	 *
	 * @param dlrRegCrtdDate the dlr reg crtd date of this dgf dlr reg dtls
	 */
	@Override
	public void setDlrRegCrtdDate(Date dlrRegCrtdDate) {
		model.setDlrRegCrtdDate(dlrRegCrtdDate);
	}

	/**
	 * Sets the dlr reg expiry date of this dgf dlr reg dtls.
	 *
	 * @param dlrRegExpiryDate the dlr reg expiry date of this dgf dlr reg dtls
	 */
	@Override
	public void setDlrRegExpiryDate(Date dlrRegExpiryDate) {
		model.setDlrRegExpiryDate(dlrRegExpiryDate);
	}

	/**
	 * Sets the dlr reg no of this dgf dlr reg dtls.
	 *
	 * @param dlrRegNo the dlr reg no of this dgf dlr reg dtls
	 */
	@Override
	public void setDlrRegNo(long dlrRegNo) {
		model.setDlrRegNo(dlrRegNo);
	}

	/**
	 * Sets the dlr type ID of this dgf dlr reg dtls.
	 *
	 * @param dlrTypeId the dlr type ID of this dgf dlr reg dtls
	 */
	@Override
	public void setDlrTypeId(String dlrTypeId) {
		model.setDlrTypeId(dlrTypeId);
	}

	/**
	 * Sets the fgl licns issue date of this dgf dlr reg dtls.
	 *
	 * @param fglLicnsIssueDate the fgl licns issue date of this dgf dlr reg dtls
	 */
	@Override
	public void setFglLicnsIssueDate(Date fglLicnsIssueDate) {
		model.setFglLicnsIssueDate(fglLicnsIssueDate);
	}

	/**
	 * Sets the fgl licns no of this dgf dlr reg dtls.
	 *
	 * @param fglLicnsNo the fgl licns no of this dgf dlr reg dtls
	 */
	@Override
	public void setFglLicnsNo(String fglLicnsNo) {
		model.setFglLicnsNo(fglLicnsNo);
	}

	/**
	 * Sets the group ID of this dgf dlr reg dtls.
	 *
	 * @param groupId the group ID of this dgf dlr reg dtls
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the incm tax attch ID of this dgf dlr reg dtls.
	 *
	 * @param incmTaxAttchID the incm tax attch ID of this dgf dlr reg dtls
	 */
	@Override
	public void setIncmTaxAttchID(long incmTaxAttchID) {
		model.setIncmTaxAttchID(incmTaxAttchID);
	}

	/**
	 * Sets the last updtd by of this dgf dlr reg dtls.
	 *
	 * @param lastUpdtdBy the last updtd by of this dgf dlr reg dtls
	 */
	@Override
	public void setLastUpdtdBy(long lastUpdtdBy) {
		model.setLastUpdtdBy(lastUpdtdBy);
	}

	/**
	 * Sets the marital status of this dgf dlr reg dtls.
	 *
	 * @param maritalStatus the marital status of this dgf dlr reg dtls
	 */
	@Override
	public void setMaritalStatus(String maritalStatus) {
		model.setMaritalStatus(maritalStatus);
	}

	/**
	 * Sets the modifed date of this dgf dlr reg dtls.
	 *
	 * @param modifedDate the modifed date of this dgf dlr reg dtls
	 */
	@Override
	public void setModifedDate(Date modifedDate) {
		model.setModifedDate(modifedDate);
	}

	/**
	 * Sets the national ID of this dgf dlr reg dtls.
	 *
	 * @param nationalId the national ID of this dgf dlr reg dtls
	 */
	@Override
	public void setNationalId(String nationalId) {
		model.setNationalId(nationalId);
	}

	/**
	 * Sets the primary key of this dgf dlr reg dtls.
	 *
	 * @param primaryKey the primary key of this dgf dlr reg dtls
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the pymnt trn ref no of this dgf dlr reg dtls.
	 *
	 * @param pymntTrnRefNo the pymnt trn ref no of this dgf dlr reg dtls
	 */
	@Override
	public void setPymntTrnRefNo(long pymntTrnRefNo) {
		model.setPymntTrnRefNo(pymntTrnRefNo);
	}

	/**
	 * Sets the pymnt trn status of this dgf dlr reg dtls.
	 *
	 * @param pymntTrnStatus the pymnt trn status of this dgf dlr reg dtls
	 */
	@Override
	public void setPymntTrnStatus(String pymntTrnStatus) {
		model.setPymntTrnStatus(pymntTrnStatus);
	}

	/**
	 * Sets the sap bu code of this dgf dlr reg dtls.
	 *
	 * @param sapBuCode the sap bu code of this dgf dlr reg dtls
	 */
	@Override
	public void setSapBuCode(String sapBuCode) {
		model.setSapBuCode(sapBuCode);
	}

	/**
	 * Sets the shp ownship docu ID of this dgf dlr reg dtls.
	 *
	 * @param shpOwnshipDocuId the shp ownship docu ID of this dgf dlr reg dtls
	 */
	@Override
	public void setShpOwnshipDocuId(long shpOwnshipDocuId) {
		model.setShpOwnshipDocuId(shpOwnshipDocuId);
	}

	/**
	 * Sets the shp rented docu ID of this dgf dlr reg dtls.
	 *
	 * @param shpRentedDocuId the shp rented docu ID of this dgf dlr reg dtls
	 */
	@Override
	public void setShpRentedDocuId(long shpRentedDocuId) {
		model.setShpRentedDocuId(shpRentedDocuId);
	}

	/**
	 * Sets the signature ID of this dgf dlr reg dtls.
	 *
	 * @param signatureId the signature ID of this dgf dlr reg dtls
	 */
	@Override
	public void setSignatureId(long signatureId) {
		model.setSignatureId(signatureId);
	}

	/**
	 * Sets the spouse brth date of this dgf dlr reg dtls.
	 *
	 * @param spouseBrthDate the spouse brth date of this dgf dlr reg dtls
	 */
	@Override
	public void setSpouseBrthDate(Date spouseBrthDate) {
		model.setSpouseBrthDate(spouseBrthDate);
	}

	/**
	 * Sets the spouse fthr name of this dgf dlr reg dtls.
	 *
	 * @param spouseFthrName the spouse fthr name of this dgf dlr reg dtls
	 */
	@Override
	public void setSpouseFthrName(String spouseFthrName) {
		model.setSpouseFthrName(spouseFthrName);
	}

	/**
	 * Sets the spouse name of this dgf dlr reg dtls.
	 *
	 * @param spouseName the spouse name of this dgf dlr reg dtls
	 */
	@Override
	public void setSpouseName(String spouseName) {
		model.setSpouseName(spouseName);
	}

	/**
	 * Sets the spouse nid of this dgf dlr reg dtls.
	 *
	 * @param spouseNid the spouse nid of this dgf dlr reg dtls
	 */
	@Override
	public void setSpouseNid(String spouseNid) {
		model.setSpouseNid(spouseNid);
	}

	/**
	 * Sets the status of this dgf dlr reg dtls.
	 *
	 * @param status the status of this dgf dlr reg dtls
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this dgf dlr reg dtls.
	 *
	 * @param statusByUserId the status by user ID of this dgf dlr reg dtls
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this dgf dlr reg dtls.
	 *
	 * @param statusByUserName the status by user name of this dgf dlr reg dtls
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this dgf dlr reg dtls.
	 *
	 * @param statusByUserUuid the status by user uuid of this dgf dlr reg dtls
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this dgf dlr reg dtls.
	 *
	 * @param statusDate the status date of this dgf dlr reg dtls
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the trd licns exp date of this dgf dlr reg dtls.
	 *
	 * @param trdLicnsExpDate the trd licns exp date of this dgf dlr reg dtls
	 */
	@Override
	public void setTrdLicnsExpDate(Date trdLicnsExpDate) {
		model.setTrdLicnsExpDate(trdLicnsExpDate);
	}

	/**
	 * Sets the trd licns no of this dgf dlr reg dtls.
	 *
	 * @param trdLicnsNo the trd licns no of this dgf dlr reg dtls
	 */
	@Override
	public void setTrdLicnsNo(long trdLicnsNo) {
		model.setTrdLicnsNo(trdLicnsNo);
	}

	/**
	 * Sets the union name of this dgf dlr reg dtls.
	 *
	 * @param unionName the union name of this dgf dlr reg dtls
	 */
	@Override
	public void setUnionName(long unionName) {
		model.setUnionName(unionName);
	}

	/**
	 * Sets the upzilla of this dgf dlr reg dtls.
	 *
	 * @param upzilla the upzilla of this dgf dlr reg dtls
	 */
	@Override
	public void setUpzilla(long upzilla) {
		model.setUpzilla(upzilla);
	}

	/**
	 * Sets the user ID of this dgf dlr reg dtls.
	 *
	 * @param userId the user ID of this dgf dlr reg dtls
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this dgf dlr reg dtls.
	 *
	 * @param userUuid the user uuid of this dgf dlr reg dtls
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the version of this dgf dlr reg dtls.
	 *
	 * @param version the version of this dgf dlr reg dtls
	 */
	@Override
	public void setVersion(long version) {
		model.setVersion(version);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DgfDlrRegDtlsWrapper wrap(DgfDlrRegDtls dgfDlrRegDtls) {
		return new DgfDlrRegDtlsWrapper(dgfDlrRegDtls);
	}

}