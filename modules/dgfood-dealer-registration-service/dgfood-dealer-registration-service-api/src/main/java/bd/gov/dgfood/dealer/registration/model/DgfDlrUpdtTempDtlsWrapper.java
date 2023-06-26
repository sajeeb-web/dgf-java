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
 * This class is a wrapper for {@link DgfDlrUpdtTempDtls}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrUpdtTempDtls
 * @generated
 */
public class DgfDlrUpdtTempDtlsWrapper
	extends BaseModelWrapper<DgfDlrUpdtTempDtls>
	implements DgfDlrUpdtTempDtls, ModelWrapper<DgfDlrUpdtTempDtls> {

	public DgfDlrUpdtTempDtlsWrapper(DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls) {
		super(dgfDlrUpdtTempDtls);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dgfDlrUpdateReqId", getDgfDlrUpdateReqId());
		attributes.put("nationalId", getNationalId());
		attributes.put("dlrRegNo", getDlrRegNo());
		attributes.put("maritalStatus", getMaritalStatus());
		attributes.put("spouseName", getSpouseName());
		attributes.put("spouseFthrName", getSpouseFthrName());
		attributes.put("spouseNid", getSpouseNid());
		attributes.put("spouseBrthDate", getSpouseBrthDate());
		attributes.put("pblcRep", getPblcRep());
		attributes.put("wrkInGovt", getWrkInGovt());
		attributes.put("physclyChlngd", getPhysclyChlngd());
		attributes.put("phsclyChlngdAttchId", getPhsclyChlngdAttchId());
		attributes.put("shpDivision", getShpDivision());
		attributes.put("shpDistrict", getShpDistrict());
		attributes.put("shpUpzilla", getShpUpzilla());
		attributes.put("shpUnion", getShpUnion());
		attributes.put("shpVillage", getShpVillage());
		attributes.put("shpWard", getShpWard());
		attributes.put("shpZipCode", getShpZipCode());
		attributes.put("shpPstOffc", getShpPstOffc());
		attributes.put("shpPresentAddress", getShpPresentAddress());
		attributes.put("shpLocation", getShpLocation());
		attributes.put("shpLength", getShpLength());
		attributes.put("shpHeight", getShpHeight());
		attributes.put("shpWidth", getShpWidth());
		attributes.put("shpStrgCpcty", getShpStrgCpcty());
		attributes.put("shpFlrCmntd", getShpFlrCmntd());
		attributes.put("shpSignBrd", getShpSignBrd());
		attributes.put("licenseType", getLicenseType());
		attributes.put("thrdPartyOpsFlg", getThrdPartyOpsFlg());
		attributes.put("dlrshpFmlyMmbrName", getDlrshpFmlyMmbrName());
		attributes.put("dlrshpFmlyMmbrType", getDlrshpFmlyMmbrType());
		attributes.put("dlrPerfYr1", getDlrPerfYr1());
		attributes.put("dlrPerfYr1AllocQty", getDlrPerfYr1AllocQty());
		attributes.put("dlrPerfYr1ComdtyQty", getDlrPerfYr1ComdtyQty());
		attributes.put("dlrPerfYr1DlrCtgry", getDlrPerfYr1DlrCtgry());
		attributes.put("dlrPerfYr1Rmrk", getDlrPerfYr1Rmrk());
		attributes.put("dlrPerfYr2", getDlrPerfYr2());
		attributes.put("dlrPerfYr2AllocQty", getDlrPerfYr2AllocQty());
		attributes.put("dlrPerfYr2ComdtyQty", getDlrPerfYr2ComdtyQty());
		attributes.put("dlrPerfYr2DlrCtgry", getDlrPerfYr2DlrCtgry());
		attributes.put("dlrPerfYr2Rmrk", getDlrPerfYr2Rmrk());
		attributes.put("dlrPerfYr3", getDlrPerfYr3());
		attributes.put("dlrPerfYr3AllocQty", getDlrPerfYr3AllocQty());
		attributes.put("dlrPerfYr3ComdtyQty", getDlrPerfYr3ComdtyQty());
		attributes.put("dlrPerfYr3DlrCtgry", getDlrPerfYr3DlrCtgry());
		attributes.put("dlrPerfYr3Rmrk", getDlrPerfYr3Rmrk());
		attributes.put("trckLicnsPlatNo", getTrckLicnsPlatNo());
		attributes.put("trckCpcty", getTrckCpcty());
		attributes.put("trckMake", getTrckMake());
		attributes.put("trckModel", getTrckModel());
		attributes.put("trckRentOwnFlg", getTrckRentOwnFlg());
		attributes.put("trckMfgYr", getTrckMfgYr());
		attributes.put("version", getVersion());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("createDate", getCreateDate());
		attributes.put("lastUpdtdBy", getLastUpdtdBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("foodgrainLicense", getFoodgrainLicense());
		attributes.put("tradeLicense", getTradeLicense());
		attributes.put("tcvDlrLicense", getTcvDlrLicense());
		attributes.put("importLicense", getImportLicense());
		attributes.put("licenseEssentialGoods", getLicenseEssentialGoods());
		attributes.put("tradeLicenseAgriculture", getTradeLicenseAgriculture());
		attributes.put("dlrOmsSubType", getDlrOmsSubType());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("dlrRunShpHimself", getDlrRunShpHimself());
		attributes.put("dlrShpTrckTypFlg", getDlrShpTrckTypFlg());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dgfDlrUpdateReqId = (Long)attributes.get("dgfDlrUpdateReqId");

		if (dgfDlrUpdateReqId != null) {
			setDgfDlrUpdateReqId(dgfDlrUpdateReqId);
		}

		String nationalId = (String)attributes.get("nationalId");

		if (nationalId != null) {
			setNationalId(nationalId);
		}

		Long dlrRegNo = (Long)attributes.get("dlrRegNo");

		if (dlrRegNo != null) {
			setDlrRegNo(dlrRegNo);
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

		Integer pblcRep = (Integer)attributes.get("pblcRep");

		if (pblcRep != null) {
			setPblcRep(pblcRep);
		}

		Integer wrkInGovt = (Integer)attributes.get("wrkInGovt");

		if (wrkInGovt != null) {
			setWrkInGovt(wrkInGovt);
		}

		Integer physclyChlngd = (Integer)attributes.get("physclyChlngd");

		if (physclyChlngd != null) {
			setPhysclyChlngd(physclyChlngd);
		}

		Long phsclyChlngdAttchId = (Long)attributes.get("phsclyChlngdAttchId");

		if (phsclyChlngdAttchId != null) {
			setPhsclyChlngdAttchId(phsclyChlngdAttchId);
		}

		Long shpDivision = (Long)attributes.get("shpDivision");

		if (shpDivision != null) {
			setShpDivision(shpDivision);
		}

		Long shpDistrict = (Long)attributes.get("shpDistrict");

		if (shpDistrict != null) {
			setShpDistrict(shpDistrict);
		}

		Long shpUpzilla = (Long)attributes.get("shpUpzilla");

		if (shpUpzilla != null) {
			setShpUpzilla(shpUpzilla);
		}

		Long shpUnion = (Long)attributes.get("shpUnion");

		if (shpUnion != null) {
			setShpUnion(shpUnion);
		}

		String shpVillage = (String)attributes.get("shpVillage");

		if (shpVillage != null) {
			setShpVillage(shpVillage);
		}

		String shpWard = (String)attributes.get("shpWard");

		if (shpWard != null) {
			setShpWard(shpWard);
		}

		String shpZipCode = (String)attributes.get("shpZipCode");

		if (shpZipCode != null) {
			setShpZipCode(shpZipCode);
		}

		String shpPstOffc = (String)attributes.get("shpPstOffc");

		if (shpPstOffc != null) {
			setShpPstOffc(shpPstOffc);
		}

		String shpPresentAddress = (String)attributes.get("shpPresentAddress");

		if (shpPresentAddress != null) {
			setShpPresentAddress(shpPresentAddress);
		}

		String shpLocation = (String)attributes.get("shpLocation");

		if (shpLocation != null) {
			setShpLocation(shpLocation);
		}

		Long shpLength = (Long)attributes.get("shpLength");

		if (shpLength != null) {
			setShpLength(shpLength);
		}

		Long shpHeight = (Long)attributes.get("shpHeight");

		if (shpHeight != null) {
			setShpHeight(shpHeight);
		}

		Long shpWidth = (Long)attributes.get("shpWidth");

		if (shpWidth != null) {
			setShpWidth(shpWidth);
		}

		Long shpStrgCpcty = (Long)attributes.get("shpStrgCpcty");

		if (shpStrgCpcty != null) {
			setShpStrgCpcty(shpStrgCpcty);
		}

		Integer shpFlrCmntd = (Integer)attributes.get("shpFlrCmntd");

		if (shpFlrCmntd != null) {
			setShpFlrCmntd(shpFlrCmntd);
		}

		Integer shpSignBrd = (Integer)attributes.get("shpSignBrd");

		if (shpSignBrd != null) {
			setShpSignBrd(shpSignBrd);
		}

		String licenseType = (String)attributes.get("licenseType");

		if (licenseType != null) {
			setLicenseType(licenseType);
		}

		Long thrdPartyOpsFlg = (Long)attributes.get("thrdPartyOpsFlg");

		if (thrdPartyOpsFlg != null) {
			setThrdPartyOpsFlg(thrdPartyOpsFlg);
		}

		String dlrshpFmlyMmbrName = (String)attributes.get(
			"dlrshpFmlyMmbrName");

		if (dlrshpFmlyMmbrName != null) {
			setDlrshpFmlyMmbrName(dlrshpFmlyMmbrName);
		}

		String dlrshpFmlyMmbrType = (String)attributes.get(
			"dlrshpFmlyMmbrType");

		if (dlrshpFmlyMmbrType != null) {
			setDlrshpFmlyMmbrType(dlrshpFmlyMmbrType);
		}

		Long dlrPerfYr1 = (Long)attributes.get("dlrPerfYr1");

		if (dlrPerfYr1 != null) {
			setDlrPerfYr1(dlrPerfYr1);
		}

		Long dlrPerfYr1AllocQty = (Long)attributes.get("dlrPerfYr1AllocQty");

		if (dlrPerfYr1AllocQty != null) {
			setDlrPerfYr1AllocQty(dlrPerfYr1AllocQty);
		}

		Long dlrPerfYr1ComdtyQty = (Long)attributes.get("dlrPerfYr1ComdtyQty");

		if (dlrPerfYr1ComdtyQty != null) {
			setDlrPerfYr1ComdtyQty(dlrPerfYr1ComdtyQty);
		}

		String dlrPerfYr1DlrCtgry = (String)attributes.get(
			"dlrPerfYr1DlrCtgry");

		if (dlrPerfYr1DlrCtgry != null) {
			setDlrPerfYr1DlrCtgry(dlrPerfYr1DlrCtgry);
		}

		String dlrPerfYr1Rmrk = (String)attributes.get("dlrPerfYr1Rmrk");

		if (dlrPerfYr1Rmrk != null) {
			setDlrPerfYr1Rmrk(dlrPerfYr1Rmrk);
		}

		Long dlrPerfYr2 = (Long)attributes.get("dlrPerfYr2");

		if (dlrPerfYr2 != null) {
			setDlrPerfYr2(dlrPerfYr2);
		}

		Long dlrPerfYr2AllocQty = (Long)attributes.get("dlrPerfYr2AllocQty");

		if (dlrPerfYr2AllocQty != null) {
			setDlrPerfYr2AllocQty(dlrPerfYr2AllocQty);
		}

		Long dlrPerfYr2ComdtyQty = (Long)attributes.get("dlrPerfYr2ComdtyQty");

		if (dlrPerfYr2ComdtyQty != null) {
			setDlrPerfYr2ComdtyQty(dlrPerfYr2ComdtyQty);
		}

		String dlrPerfYr2DlrCtgry = (String)attributes.get(
			"dlrPerfYr2DlrCtgry");

		if (dlrPerfYr2DlrCtgry != null) {
			setDlrPerfYr2DlrCtgry(dlrPerfYr2DlrCtgry);
		}

		String dlrPerfYr2Rmrk = (String)attributes.get("dlrPerfYr2Rmrk");

		if (dlrPerfYr2Rmrk != null) {
			setDlrPerfYr2Rmrk(dlrPerfYr2Rmrk);
		}

		Long dlrPerfYr3 = (Long)attributes.get("dlrPerfYr3");

		if (dlrPerfYr3 != null) {
			setDlrPerfYr3(dlrPerfYr3);
		}

		Long dlrPerfYr3AllocQty = (Long)attributes.get("dlrPerfYr3AllocQty");

		if (dlrPerfYr3AllocQty != null) {
			setDlrPerfYr3AllocQty(dlrPerfYr3AllocQty);
		}

		Long dlrPerfYr3ComdtyQty = (Long)attributes.get("dlrPerfYr3ComdtyQty");

		if (dlrPerfYr3ComdtyQty != null) {
			setDlrPerfYr3ComdtyQty(dlrPerfYr3ComdtyQty);
		}

		String dlrPerfYr3DlrCtgry = (String)attributes.get(
			"dlrPerfYr3DlrCtgry");

		if (dlrPerfYr3DlrCtgry != null) {
			setDlrPerfYr3DlrCtgry(dlrPerfYr3DlrCtgry);
		}

		String dlrPerfYr3Rmrk = (String)attributes.get("dlrPerfYr3Rmrk");

		if (dlrPerfYr3Rmrk != null) {
			setDlrPerfYr3Rmrk(dlrPerfYr3Rmrk);
		}

		String trckLicnsPlatNo = (String)attributes.get("trckLicnsPlatNo");

		if (trckLicnsPlatNo != null) {
			setTrckLicnsPlatNo(trckLicnsPlatNo);
		}

		Long trckCpcty = (Long)attributes.get("trckCpcty");

		if (trckCpcty != null) {
			setTrckCpcty(trckCpcty);
		}

		String trckMake = (String)attributes.get("trckMake");

		if (trckMake != null) {
			setTrckMake(trckMake);
		}

		String trckModel = (String)attributes.get("trckModel");

		if (trckModel != null) {
			setTrckModel(trckModel);
		}

		String trckRentOwnFlg = (String)attributes.get("trckRentOwnFlg");

		if (trckRentOwnFlg != null) {
			setTrckRentOwnFlg(trckRentOwnFlg);
		}

		Long trckMfgYr = (Long)attributes.get("trckMfgYr");

		if (trckMfgYr != null) {
			setTrckMfgYr(trckMfgYr);
		}

		Long version = (Long)attributes.get("version");

		if (version != null) {
			setVersion(version);
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

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long lastUpdtdBy = (Long)attributes.get("lastUpdtdBy");

		if (lastUpdtdBy != null) {
			setLastUpdtdBy(lastUpdtdBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer foodgrainLicense = (Integer)attributes.get("foodgrainLicense");

		if (foodgrainLicense != null) {
			setFoodgrainLicense(foodgrainLicense);
		}

		Integer tradeLicense = (Integer)attributes.get("tradeLicense");

		if (tradeLicense != null) {
			setTradeLicense(tradeLicense);
		}

		Integer tcvDlrLicense = (Integer)attributes.get("tcvDlrLicense");

		if (tcvDlrLicense != null) {
			setTcvDlrLicense(tcvDlrLicense);
		}

		Integer importLicense = (Integer)attributes.get("importLicense");

		if (importLicense != null) {
			setImportLicense(importLicense);
		}

		Integer licenseEssentialGoods = (Integer)attributes.get(
			"licenseEssentialGoods");

		if (licenseEssentialGoods != null) {
			setLicenseEssentialGoods(licenseEssentialGoods);
		}

		Integer tradeLicenseAgriculture = (Integer)attributes.get(
			"tradeLicenseAgriculture");

		if (tradeLicenseAgriculture != null) {
			setTradeLicenseAgriculture(tradeLicenseAgriculture);
		}

		String dlrOmsSubType = (String)attributes.get("dlrOmsSubType");

		if (dlrOmsSubType != null) {
			setDlrOmsSubType(dlrOmsSubType);
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

		Integer dlrRunShpHimself = (Integer)attributes.get("dlrRunShpHimself");

		if (dlrRunShpHimself != null) {
			setDlrRunShpHimself(dlrRunShpHimself);
		}

		Integer dlrShpTrckTypFlg = (Integer)attributes.get("dlrShpTrckTypFlg");

		if (dlrShpTrckTypFlg != null) {
			setDlrShpTrckTypFlg(dlrShpTrckTypFlg);
		}
	}

	@Override
	public DgfDlrUpdtTempDtls cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this dgf dlr updt temp dtls.
	 *
	 * @return the company ID of this dgf dlr updt temp dtls
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this dgf dlr updt temp dtls.
	 *
	 * @return the create date of this dgf dlr updt temp dtls
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the dgf dlr update req ID of this dgf dlr updt temp dtls.
	 *
	 * @return the dgf dlr update req ID of this dgf dlr updt temp dtls
	 */
	@Override
	public long getDgfDlrUpdateReqId() {
		return model.getDgfDlrUpdateReqId();
	}

	/**
	 * Returns the dlr oms sub type of this dgf dlr updt temp dtls.
	 *
	 * @return the dlr oms sub type of this dgf dlr updt temp dtls
	 */
	@Override
	public String getDlrOmsSubType() {
		return model.getDlrOmsSubType();
	}

	/**
	 * Returns the dlr perf yr1 of this dgf dlr updt temp dtls.
	 *
	 * @return the dlr perf yr1 of this dgf dlr updt temp dtls
	 */
	@Override
	public long getDlrPerfYr1() {
		return model.getDlrPerfYr1();
	}

	/**
	 * Returns the dlr perf yr1 alloc qty of this dgf dlr updt temp dtls.
	 *
	 * @return the dlr perf yr1 alloc qty of this dgf dlr updt temp dtls
	 */
	@Override
	public long getDlrPerfYr1AllocQty() {
		return model.getDlrPerfYr1AllocQty();
	}

	/**
	 * Returns the dlr perf yr1 comdty qty of this dgf dlr updt temp dtls.
	 *
	 * @return the dlr perf yr1 comdty qty of this dgf dlr updt temp dtls
	 */
	@Override
	public long getDlrPerfYr1ComdtyQty() {
		return model.getDlrPerfYr1ComdtyQty();
	}

	/**
	 * Returns the dlr perf yr1 dlr ctgry of this dgf dlr updt temp dtls.
	 *
	 * @return the dlr perf yr1 dlr ctgry of this dgf dlr updt temp dtls
	 */
	@Override
	public String getDlrPerfYr1DlrCtgry() {
		return model.getDlrPerfYr1DlrCtgry();
	}

	/**
	 * Returns the dlr perf yr1 rmrk of this dgf dlr updt temp dtls.
	 *
	 * @return the dlr perf yr1 rmrk of this dgf dlr updt temp dtls
	 */
	@Override
	public String getDlrPerfYr1Rmrk() {
		return model.getDlrPerfYr1Rmrk();
	}

	/**
	 * Returns the dlr perf yr2 of this dgf dlr updt temp dtls.
	 *
	 * @return the dlr perf yr2 of this dgf dlr updt temp dtls
	 */
	@Override
	public long getDlrPerfYr2() {
		return model.getDlrPerfYr2();
	}

	/**
	 * Returns the dlr perf yr2 alloc qty of this dgf dlr updt temp dtls.
	 *
	 * @return the dlr perf yr2 alloc qty of this dgf dlr updt temp dtls
	 */
	@Override
	public long getDlrPerfYr2AllocQty() {
		return model.getDlrPerfYr2AllocQty();
	}

	/**
	 * Returns the dlr perf yr2 comdty qty of this dgf dlr updt temp dtls.
	 *
	 * @return the dlr perf yr2 comdty qty of this dgf dlr updt temp dtls
	 */
	@Override
	public long getDlrPerfYr2ComdtyQty() {
		return model.getDlrPerfYr2ComdtyQty();
	}

	/**
	 * Returns the dlr perf yr2 dlr ctgry of this dgf dlr updt temp dtls.
	 *
	 * @return the dlr perf yr2 dlr ctgry of this dgf dlr updt temp dtls
	 */
	@Override
	public String getDlrPerfYr2DlrCtgry() {
		return model.getDlrPerfYr2DlrCtgry();
	}

	/**
	 * Returns the dlr perf yr2 rmrk of this dgf dlr updt temp dtls.
	 *
	 * @return the dlr perf yr2 rmrk of this dgf dlr updt temp dtls
	 */
	@Override
	public String getDlrPerfYr2Rmrk() {
		return model.getDlrPerfYr2Rmrk();
	}

	/**
	 * Returns the dlr perf yr3 of this dgf dlr updt temp dtls.
	 *
	 * @return the dlr perf yr3 of this dgf dlr updt temp dtls
	 */
	@Override
	public long getDlrPerfYr3() {
		return model.getDlrPerfYr3();
	}

	/**
	 * Returns the dlr perf yr3 alloc qty of this dgf dlr updt temp dtls.
	 *
	 * @return the dlr perf yr3 alloc qty of this dgf dlr updt temp dtls
	 */
	@Override
	public long getDlrPerfYr3AllocQty() {
		return model.getDlrPerfYr3AllocQty();
	}

	/**
	 * Returns the dlr perf yr3 comdty qty of this dgf dlr updt temp dtls.
	 *
	 * @return the dlr perf yr3 comdty qty of this dgf dlr updt temp dtls
	 */
	@Override
	public long getDlrPerfYr3ComdtyQty() {
		return model.getDlrPerfYr3ComdtyQty();
	}

	/**
	 * Returns the dlr perf yr3 dlr ctgry of this dgf dlr updt temp dtls.
	 *
	 * @return the dlr perf yr3 dlr ctgry of this dgf dlr updt temp dtls
	 */
	@Override
	public String getDlrPerfYr3DlrCtgry() {
		return model.getDlrPerfYr3DlrCtgry();
	}

	/**
	 * Returns the dlr perf yr3 rmrk of this dgf dlr updt temp dtls.
	 *
	 * @return the dlr perf yr3 rmrk of this dgf dlr updt temp dtls
	 */
	@Override
	public String getDlrPerfYr3Rmrk() {
		return model.getDlrPerfYr3Rmrk();
	}

	/**
	 * Returns the dlr reg no of this dgf dlr updt temp dtls.
	 *
	 * @return the dlr reg no of this dgf dlr updt temp dtls
	 */
	@Override
	public long getDlrRegNo() {
		return model.getDlrRegNo();
	}

	/**
	 * Returns the dlr run shp himself of this dgf dlr updt temp dtls.
	 *
	 * @return the dlr run shp himself of this dgf dlr updt temp dtls
	 */
	@Override
	public int getDlrRunShpHimself() {
		return model.getDlrRunShpHimself();
	}

	/**
	 * Returns the dlrshp fmly mmbr name of this dgf dlr updt temp dtls.
	 *
	 * @return the dlrshp fmly mmbr name of this dgf dlr updt temp dtls
	 */
	@Override
	public String getDlrshpFmlyMmbrName() {
		return model.getDlrshpFmlyMmbrName();
	}

	/**
	 * Returns the dlrshp fmly mmbr type of this dgf dlr updt temp dtls.
	 *
	 * @return the dlrshp fmly mmbr type of this dgf dlr updt temp dtls
	 */
	@Override
	public String getDlrshpFmlyMmbrType() {
		return model.getDlrshpFmlyMmbrType();
	}

	/**
	 * Returns the dlr shp trck typ flg of this dgf dlr updt temp dtls.
	 *
	 * @return the dlr shp trck typ flg of this dgf dlr updt temp dtls
	 */
	@Override
	public int getDlrShpTrckTypFlg() {
		return model.getDlrShpTrckTypFlg();
	}

	/**
	 * Returns the foodgrain license of this dgf dlr updt temp dtls.
	 *
	 * @return the foodgrain license of this dgf dlr updt temp dtls
	 */
	@Override
	public int getFoodgrainLicense() {
		return model.getFoodgrainLicense();
	}

	/**
	 * Returns the group ID of this dgf dlr updt temp dtls.
	 *
	 * @return the group ID of this dgf dlr updt temp dtls
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the import license of this dgf dlr updt temp dtls.
	 *
	 * @return the import license of this dgf dlr updt temp dtls
	 */
	@Override
	public int getImportLicense() {
		return model.getImportLicense();
	}

	/**
	 * Returns the last updtd by of this dgf dlr updt temp dtls.
	 *
	 * @return the last updtd by of this dgf dlr updt temp dtls
	 */
	@Override
	public long getLastUpdtdBy() {
		return model.getLastUpdtdBy();
	}

	/**
	 * Returns the license essential goods of this dgf dlr updt temp dtls.
	 *
	 * @return the license essential goods of this dgf dlr updt temp dtls
	 */
	@Override
	public int getLicenseEssentialGoods() {
		return model.getLicenseEssentialGoods();
	}

	/**
	 * Returns the license type of this dgf dlr updt temp dtls.
	 *
	 * @return the license type of this dgf dlr updt temp dtls
	 */
	@Override
	public String getLicenseType() {
		return model.getLicenseType();
	}

	/**
	 * Returns the marital status of this dgf dlr updt temp dtls.
	 *
	 * @return the marital status of this dgf dlr updt temp dtls
	 */
	@Override
	public String getMaritalStatus() {
		return model.getMaritalStatus();
	}

	/**
	 * Returns the modified date of this dgf dlr updt temp dtls.
	 *
	 * @return the modified date of this dgf dlr updt temp dtls
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the national ID of this dgf dlr updt temp dtls.
	 *
	 * @return the national ID of this dgf dlr updt temp dtls
	 */
	@Override
	public String getNationalId() {
		return model.getNationalId();
	}

	/**
	 * Returns the pblc rep of this dgf dlr updt temp dtls.
	 *
	 * @return the pblc rep of this dgf dlr updt temp dtls
	 */
	@Override
	public int getPblcRep() {
		return model.getPblcRep();
	}

	/**
	 * Returns the phscly chlngd attch ID of this dgf dlr updt temp dtls.
	 *
	 * @return the phscly chlngd attch ID of this dgf dlr updt temp dtls
	 */
	@Override
	public long getPhsclyChlngdAttchId() {
		return model.getPhsclyChlngdAttchId();
	}

	/**
	 * Returns the physcly chlngd of this dgf dlr updt temp dtls.
	 *
	 * @return the physcly chlngd of this dgf dlr updt temp dtls
	 */
	@Override
	public int getPhysclyChlngd() {
		return model.getPhysclyChlngd();
	}

	/**
	 * Returns the primary key of this dgf dlr updt temp dtls.
	 *
	 * @return the primary key of this dgf dlr updt temp dtls
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the shp district of this dgf dlr updt temp dtls.
	 *
	 * @return the shp district of this dgf dlr updt temp dtls
	 */
	@Override
	public long getShpDistrict() {
		return model.getShpDistrict();
	}

	/**
	 * Returns the shp division of this dgf dlr updt temp dtls.
	 *
	 * @return the shp division of this dgf dlr updt temp dtls
	 */
	@Override
	public long getShpDivision() {
		return model.getShpDivision();
	}

	/**
	 * Returns the shp flr cmntd of this dgf dlr updt temp dtls.
	 *
	 * @return the shp flr cmntd of this dgf dlr updt temp dtls
	 */
	@Override
	public int getShpFlrCmntd() {
		return model.getShpFlrCmntd();
	}

	/**
	 * Returns the shp height of this dgf dlr updt temp dtls.
	 *
	 * @return the shp height of this dgf dlr updt temp dtls
	 */
	@Override
	public long getShpHeight() {
		return model.getShpHeight();
	}

	/**
	 * Returns the shp length of this dgf dlr updt temp dtls.
	 *
	 * @return the shp length of this dgf dlr updt temp dtls
	 */
	@Override
	public long getShpLength() {
		return model.getShpLength();
	}

	/**
	 * Returns the shp location of this dgf dlr updt temp dtls.
	 *
	 * @return the shp location of this dgf dlr updt temp dtls
	 */
	@Override
	public String getShpLocation() {
		return model.getShpLocation();
	}

	/**
	 * Returns the shp present address of this dgf dlr updt temp dtls.
	 *
	 * @return the shp present address of this dgf dlr updt temp dtls
	 */
	@Override
	public String getShpPresentAddress() {
		return model.getShpPresentAddress();
	}

	/**
	 * Returns the shp pst offc of this dgf dlr updt temp dtls.
	 *
	 * @return the shp pst offc of this dgf dlr updt temp dtls
	 */
	@Override
	public String getShpPstOffc() {
		return model.getShpPstOffc();
	}

	/**
	 * Returns the shp sign brd of this dgf dlr updt temp dtls.
	 *
	 * @return the shp sign brd of this dgf dlr updt temp dtls
	 */
	@Override
	public int getShpSignBrd() {
		return model.getShpSignBrd();
	}

	/**
	 * Returns the shp strg cpcty of this dgf dlr updt temp dtls.
	 *
	 * @return the shp strg cpcty of this dgf dlr updt temp dtls
	 */
	@Override
	public long getShpStrgCpcty() {
		return model.getShpStrgCpcty();
	}

	/**
	 * Returns the shp union of this dgf dlr updt temp dtls.
	 *
	 * @return the shp union of this dgf dlr updt temp dtls
	 */
	@Override
	public long getShpUnion() {
		return model.getShpUnion();
	}

	/**
	 * Returns the shp upzilla of this dgf dlr updt temp dtls.
	 *
	 * @return the shp upzilla of this dgf dlr updt temp dtls
	 */
	@Override
	public long getShpUpzilla() {
		return model.getShpUpzilla();
	}

	/**
	 * Returns the shp village of this dgf dlr updt temp dtls.
	 *
	 * @return the shp village of this dgf dlr updt temp dtls
	 */
	@Override
	public String getShpVillage() {
		return model.getShpVillage();
	}

	/**
	 * Returns the shp ward of this dgf dlr updt temp dtls.
	 *
	 * @return the shp ward of this dgf dlr updt temp dtls
	 */
	@Override
	public String getShpWard() {
		return model.getShpWard();
	}

	/**
	 * Returns the shp width of this dgf dlr updt temp dtls.
	 *
	 * @return the shp width of this dgf dlr updt temp dtls
	 */
	@Override
	public long getShpWidth() {
		return model.getShpWidth();
	}

	/**
	 * Returns the shp zip code of this dgf dlr updt temp dtls.
	 *
	 * @return the shp zip code of this dgf dlr updt temp dtls
	 */
	@Override
	public String getShpZipCode() {
		return model.getShpZipCode();
	}

	/**
	 * Returns the spouse brth date of this dgf dlr updt temp dtls.
	 *
	 * @return the spouse brth date of this dgf dlr updt temp dtls
	 */
	@Override
	public Date getSpouseBrthDate() {
		return model.getSpouseBrthDate();
	}

	/**
	 * Returns the spouse fthr name of this dgf dlr updt temp dtls.
	 *
	 * @return the spouse fthr name of this dgf dlr updt temp dtls
	 */
	@Override
	public String getSpouseFthrName() {
		return model.getSpouseFthrName();
	}

	/**
	 * Returns the spouse name of this dgf dlr updt temp dtls.
	 *
	 * @return the spouse name of this dgf dlr updt temp dtls
	 */
	@Override
	public String getSpouseName() {
		return model.getSpouseName();
	}

	/**
	 * Returns the spouse nid of this dgf dlr updt temp dtls.
	 *
	 * @return the spouse nid of this dgf dlr updt temp dtls
	 */
	@Override
	public String getSpouseNid() {
		return model.getSpouseNid();
	}

	/**
	 * Returns the status of this dgf dlr updt temp dtls.
	 *
	 * @return the status of this dgf dlr updt temp dtls
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this dgf dlr updt temp dtls.
	 *
	 * @return the status by user ID of this dgf dlr updt temp dtls
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this dgf dlr updt temp dtls.
	 *
	 * @return the status by user name of this dgf dlr updt temp dtls
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this dgf dlr updt temp dtls.
	 *
	 * @return the status by user uuid of this dgf dlr updt temp dtls
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this dgf dlr updt temp dtls.
	 *
	 * @return the status date of this dgf dlr updt temp dtls
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the tcv dlr license of this dgf dlr updt temp dtls.
	 *
	 * @return the tcv dlr license of this dgf dlr updt temp dtls
	 */
	@Override
	public int getTcvDlrLicense() {
		return model.getTcvDlrLicense();
	}

	/**
	 * Returns the thrd party ops flg of this dgf dlr updt temp dtls.
	 *
	 * @return the thrd party ops flg of this dgf dlr updt temp dtls
	 */
	@Override
	public long getThrdPartyOpsFlg() {
		return model.getThrdPartyOpsFlg();
	}

	/**
	 * Returns the trade license of this dgf dlr updt temp dtls.
	 *
	 * @return the trade license of this dgf dlr updt temp dtls
	 */
	@Override
	public int getTradeLicense() {
		return model.getTradeLicense();
	}

	/**
	 * Returns the trade license agriculture of this dgf dlr updt temp dtls.
	 *
	 * @return the trade license agriculture of this dgf dlr updt temp dtls
	 */
	@Override
	public int getTradeLicenseAgriculture() {
		return model.getTradeLicenseAgriculture();
	}

	/**
	 * Returns the trck cpcty of this dgf dlr updt temp dtls.
	 *
	 * @return the trck cpcty of this dgf dlr updt temp dtls
	 */
	@Override
	public long getTrckCpcty() {
		return model.getTrckCpcty();
	}

	/**
	 * Returns the trck licns plat no of this dgf dlr updt temp dtls.
	 *
	 * @return the trck licns plat no of this dgf dlr updt temp dtls
	 */
	@Override
	public String getTrckLicnsPlatNo() {
		return model.getTrckLicnsPlatNo();
	}

	/**
	 * Returns the trck make of this dgf dlr updt temp dtls.
	 *
	 * @return the trck make of this dgf dlr updt temp dtls
	 */
	@Override
	public String getTrckMake() {
		return model.getTrckMake();
	}

	/**
	 * Returns the trck mfg yr of this dgf dlr updt temp dtls.
	 *
	 * @return the trck mfg yr of this dgf dlr updt temp dtls
	 */
	@Override
	public long getTrckMfgYr() {
		return model.getTrckMfgYr();
	}

	/**
	 * Returns the trck model of this dgf dlr updt temp dtls.
	 *
	 * @return the trck model of this dgf dlr updt temp dtls
	 */
	@Override
	public String getTrckModel() {
		return model.getTrckModel();
	}

	/**
	 * Returns the trck rent own flg of this dgf dlr updt temp dtls.
	 *
	 * @return the trck rent own flg of this dgf dlr updt temp dtls
	 */
	@Override
	public String getTrckRentOwnFlg() {
		return model.getTrckRentOwnFlg();
	}

	/**
	 * Returns the user ID of this dgf dlr updt temp dtls.
	 *
	 * @return the user ID of this dgf dlr updt temp dtls
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this dgf dlr updt temp dtls.
	 *
	 * @return the user uuid of this dgf dlr updt temp dtls
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the version of this dgf dlr updt temp dtls.
	 *
	 * @return the version of this dgf dlr updt temp dtls
	 */
	@Override
	public long getVersion() {
		return model.getVersion();
	}

	/**
	 * Returns the wrk in govt of this dgf dlr updt temp dtls.
	 *
	 * @return the wrk in govt of this dgf dlr updt temp dtls
	 */
	@Override
	public int getWrkInGovt() {
		return model.getWrkInGovt();
	}

	/**
	 * Returns <code>true</code> if this dgf dlr updt temp dtls is approved.
	 *
	 * @return <code>true</code> if this dgf dlr updt temp dtls is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this dgf dlr updt temp dtls is denied.
	 *
	 * @return <code>true</code> if this dgf dlr updt temp dtls is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this dgf dlr updt temp dtls is a draft.
	 *
	 * @return <code>true</code> if this dgf dlr updt temp dtls is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this dgf dlr updt temp dtls is expired.
	 *
	 * @return <code>true</code> if this dgf dlr updt temp dtls is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this dgf dlr updt temp dtls is inactive.
	 *
	 * @return <code>true</code> if this dgf dlr updt temp dtls is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this dgf dlr updt temp dtls is incomplete.
	 *
	 * @return <code>true</code> if this dgf dlr updt temp dtls is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this dgf dlr updt temp dtls is pending.
	 *
	 * @return <code>true</code> if this dgf dlr updt temp dtls is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this dgf dlr updt temp dtls is scheduled.
	 *
	 * @return <code>true</code> if this dgf dlr updt temp dtls is scheduled; <code>false</code> otherwise
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
	 * Sets the company ID of this dgf dlr updt temp dtls.
	 *
	 * @param companyId the company ID of this dgf dlr updt temp dtls
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this dgf dlr updt temp dtls.
	 *
	 * @param createDate the create date of this dgf dlr updt temp dtls
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the dgf dlr update req ID of this dgf dlr updt temp dtls.
	 *
	 * @param dgfDlrUpdateReqId the dgf dlr update req ID of this dgf dlr updt temp dtls
	 */
	@Override
	public void setDgfDlrUpdateReqId(long dgfDlrUpdateReqId) {
		model.setDgfDlrUpdateReqId(dgfDlrUpdateReqId);
	}

	/**
	 * Sets the dlr oms sub type of this dgf dlr updt temp dtls.
	 *
	 * @param dlrOmsSubType the dlr oms sub type of this dgf dlr updt temp dtls
	 */
	@Override
	public void setDlrOmsSubType(String dlrOmsSubType) {
		model.setDlrOmsSubType(dlrOmsSubType);
	}

	/**
	 * Sets the dlr perf yr1 of this dgf dlr updt temp dtls.
	 *
	 * @param dlrPerfYr1 the dlr perf yr1 of this dgf dlr updt temp dtls
	 */
	@Override
	public void setDlrPerfYr1(long dlrPerfYr1) {
		model.setDlrPerfYr1(dlrPerfYr1);
	}

	/**
	 * Sets the dlr perf yr1 alloc qty of this dgf dlr updt temp dtls.
	 *
	 * @param dlrPerfYr1AllocQty the dlr perf yr1 alloc qty of this dgf dlr updt temp dtls
	 */
	@Override
	public void setDlrPerfYr1AllocQty(long dlrPerfYr1AllocQty) {
		model.setDlrPerfYr1AllocQty(dlrPerfYr1AllocQty);
	}

	/**
	 * Sets the dlr perf yr1 comdty qty of this dgf dlr updt temp dtls.
	 *
	 * @param dlrPerfYr1ComdtyQty the dlr perf yr1 comdty qty of this dgf dlr updt temp dtls
	 */
	@Override
	public void setDlrPerfYr1ComdtyQty(long dlrPerfYr1ComdtyQty) {
		model.setDlrPerfYr1ComdtyQty(dlrPerfYr1ComdtyQty);
	}

	/**
	 * Sets the dlr perf yr1 dlr ctgry of this dgf dlr updt temp dtls.
	 *
	 * @param dlrPerfYr1DlrCtgry the dlr perf yr1 dlr ctgry of this dgf dlr updt temp dtls
	 */
	@Override
	public void setDlrPerfYr1DlrCtgry(String dlrPerfYr1DlrCtgry) {
		model.setDlrPerfYr1DlrCtgry(dlrPerfYr1DlrCtgry);
	}

	/**
	 * Sets the dlr perf yr1 rmrk of this dgf dlr updt temp dtls.
	 *
	 * @param dlrPerfYr1Rmrk the dlr perf yr1 rmrk of this dgf dlr updt temp dtls
	 */
	@Override
	public void setDlrPerfYr1Rmrk(String dlrPerfYr1Rmrk) {
		model.setDlrPerfYr1Rmrk(dlrPerfYr1Rmrk);
	}

	/**
	 * Sets the dlr perf yr2 of this dgf dlr updt temp dtls.
	 *
	 * @param dlrPerfYr2 the dlr perf yr2 of this dgf dlr updt temp dtls
	 */
	@Override
	public void setDlrPerfYr2(long dlrPerfYr2) {
		model.setDlrPerfYr2(dlrPerfYr2);
	}

	/**
	 * Sets the dlr perf yr2 alloc qty of this dgf dlr updt temp dtls.
	 *
	 * @param dlrPerfYr2AllocQty the dlr perf yr2 alloc qty of this dgf dlr updt temp dtls
	 */
	@Override
	public void setDlrPerfYr2AllocQty(long dlrPerfYr2AllocQty) {
		model.setDlrPerfYr2AllocQty(dlrPerfYr2AllocQty);
	}

	/**
	 * Sets the dlr perf yr2 comdty qty of this dgf dlr updt temp dtls.
	 *
	 * @param dlrPerfYr2ComdtyQty the dlr perf yr2 comdty qty of this dgf dlr updt temp dtls
	 */
	@Override
	public void setDlrPerfYr2ComdtyQty(long dlrPerfYr2ComdtyQty) {
		model.setDlrPerfYr2ComdtyQty(dlrPerfYr2ComdtyQty);
	}

	/**
	 * Sets the dlr perf yr2 dlr ctgry of this dgf dlr updt temp dtls.
	 *
	 * @param dlrPerfYr2DlrCtgry the dlr perf yr2 dlr ctgry of this dgf dlr updt temp dtls
	 */
	@Override
	public void setDlrPerfYr2DlrCtgry(String dlrPerfYr2DlrCtgry) {
		model.setDlrPerfYr2DlrCtgry(dlrPerfYr2DlrCtgry);
	}

	/**
	 * Sets the dlr perf yr2 rmrk of this dgf dlr updt temp dtls.
	 *
	 * @param dlrPerfYr2Rmrk the dlr perf yr2 rmrk of this dgf dlr updt temp dtls
	 */
	@Override
	public void setDlrPerfYr2Rmrk(String dlrPerfYr2Rmrk) {
		model.setDlrPerfYr2Rmrk(dlrPerfYr2Rmrk);
	}

	/**
	 * Sets the dlr perf yr3 of this dgf dlr updt temp dtls.
	 *
	 * @param dlrPerfYr3 the dlr perf yr3 of this dgf dlr updt temp dtls
	 */
	@Override
	public void setDlrPerfYr3(long dlrPerfYr3) {
		model.setDlrPerfYr3(dlrPerfYr3);
	}

	/**
	 * Sets the dlr perf yr3 alloc qty of this dgf dlr updt temp dtls.
	 *
	 * @param dlrPerfYr3AllocQty the dlr perf yr3 alloc qty of this dgf dlr updt temp dtls
	 */
	@Override
	public void setDlrPerfYr3AllocQty(long dlrPerfYr3AllocQty) {
		model.setDlrPerfYr3AllocQty(dlrPerfYr3AllocQty);
	}

	/**
	 * Sets the dlr perf yr3 comdty qty of this dgf dlr updt temp dtls.
	 *
	 * @param dlrPerfYr3ComdtyQty the dlr perf yr3 comdty qty of this dgf dlr updt temp dtls
	 */
	@Override
	public void setDlrPerfYr3ComdtyQty(long dlrPerfYr3ComdtyQty) {
		model.setDlrPerfYr3ComdtyQty(dlrPerfYr3ComdtyQty);
	}

	/**
	 * Sets the dlr perf yr3 dlr ctgry of this dgf dlr updt temp dtls.
	 *
	 * @param dlrPerfYr3DlrCtgry the dlr perf yr3 dlr ctgry of this dgf dlr updt temp dtls
	 */
	@Override
	public void setDlrPerfYr3DlrCtgry(String dlrPerfYr3DlrCtgry) {
		model.setDlrPerfYr3DlrCtgry(dlrPerfYr3DlrCtgry);
	}

	/**
	 * Sets the dlr perf yr3 rmrk of this dgf dlr updt temp dtls.
	 *
	 * @param dlrPerfYr3Rmrk the dlr perf yr3 rmrk of this dgf dlr updt temp dtls
	 */
	@Override
	public void setDlrPerfYr3Rmrk(String dlrPerfYr3Rmrk) {
		model.setDlrPerfYr3Rmrk(dlrPerfYr3Rmrk);
	}

	/**
	 * Sets the dlr reg no of this dgf dlr updt temp dtls.
	 *
	 * @param dlrRegNo the dlr reg no of this dgf dlr updt temp dtls
	 */
	@Override
	public void setDlrRegNo(long dlrRegNo) {
		model.setDlrRegNo(dlrRegNo);
	}

	/**
	 * Sets the dlr run shp himself of this dgf dlr updt temp dtls.
	 *
	 * @param dlrRunShpHimself the dlr run shp himself of this dgf dlr updt temp dtls
	 */
	@Override
	public void setDlrRunShpHimself(int dlrRunShpHimself) {
		model.setDlrRunShpHimself(dlrRunShpHimself);
	}

	/**
	 * Sets the dlrshp fmly mmbr name of this dgf dlr updt temp dtls.
	 *
	 * @param dlrshpFmlyMmbrName the dlrshp fmly mmbr name of this dgf dlr updt temp dtls
	 */
	@Override
	public void setDlrshpFmlyMmbrName(String dlrshpFmlyMmbrName) {
		model.setDlrshpFmlyMmbrName(dlrshpFmlyMmbrName);
	}

	/**
	 * Sets the dlrshp fmly mmbr type of this dgf dlr updt temp dtls.
	 *
	 * @param dlrshpFmlyMmbrType the dlrshp fmly mmbr type of this dgf dlr updt temp dtls
	 */
	@Override
	public void setDlrshpFmlyMmbrType(String dlrshpFmlyMmbrType) {
		model.setDlrshpFmlyMmbrType(dlrshpFmlyMmbrType);
	}

	/**
	 * Sets the dlr shp trck typ flg of this dgf dlr updt temp dtls.
	 *
	 * @param dlrShpTrckTypFlg the dlr shp trck typ flg of this dgf dlr updt temp dtls
	 */
	@Override
	public void setDlrShpTrckTypFlg(int dlrShpTrckTypFlg) {
		model.setDlrShpTrckTypFlg(dlrShpTrckTypFlg);
	}

	/**
	 * Sets the foodgrain license of this dgf dlr updt temp dtls.
	 *
	 * @param foodgrainLicense the foodgrain license of this dgf dlr updt temp dtls
	 */
	@Override
	public void setFoodgrainLicense(int foodgrainLicense) {
		model.setFoodgrainLicense(foodgrainLicense);
	}

	/**
	 * Sets the group ID of this dgf dlr updt temp dtls.
	 *
	 * @param groupId the group ID of this dgf dlr updt temp dtls
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the import license of this dgf dlr updt temp dtls.
	 *
	 * @param importLicense the import license of this dgf dlr updt temp dtls
	 */
	@Override
	public void setImportLicense(int importLicense) {
		model.setImportLicense(importLicense);
	}

	/**
	 * Sets the last updtd by of this dgf dlr updt temp dtls.
	 *
	 * @param lastUpdtdBy the last updtd by of this dgf dlr updt temp dtls
	 */
	@Override
	public void setLastUpdtdBy(long lastUpdtdBy) {
		model.setLastUpdtdBy(lastUpdtdBy);
	}

	/**
	 * Sets the license essential goods of this dgf dlr updt temp dtls.
	 *
	 * @param licenseEssentialGoods the license essential goods of this dgf dlr updt temp dtls
	 */
	@Override
	public void setLicenseEssentialGoods(int licenseEssentialGoods) {
		model.setLicenseEssentialGoods(licenseEssentialGoods);
	}

	/**
	 * Sets the license type of this dgf dlr updt temp dtls.
	 *
	 * @param licenseType the license type of this dgf dlr updt temp dtls
	 */
	@Override
	public void setLicenseType(String licenseType) {
		model.setLicenseType(licenseType);
	}

	/**
	 * Sets the marital status of this dgf dlr updt temp dtls.
	 *
	 * @param maritalStatus the marital status of this dgf dlr updt temp dtls
	 */
	@Override
	public void setMaritalStatus(String maritalStatus) {
		model.setMaritalStatus(maritalStatus);
	}

	/**
	 * Sets the modified date of this dgf dlr updt temp dtls.
	 *
	 * @param modifiedDate the modified date of this dgf dlr updt temp dtls
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the national ID of this dgf dlr updt temp dtls.
	 *
	 * @param nationalId the national ID of this dgf dlr updt temp dtls
	 */
	@Override
	public void setNationalId(String nationalId) {
		model.setNationalId(nationalId);
	}

	/**
	 * Sets the pblc rep of this dgf dlr updt temp dtls.
	 *
	 * @param pblcRep the pblc rep of this dgf dlr updt temp dtls
	 */
	@Override
	public void setPblcRep(int pblcRep) {
		model.setPblcRep(pblcRep);
	}

	/**
	 * Sets the phscly chlngd attch ID of this dgf dlr updt temp dtls.
	 *
	 * @param phsclyChlngdAttchId the phscly chlngd attch ID of this dgf dlr updt temp dtls
	 */
	@Override
	public void setPhsclyChlngdAttchId(long phsclyChlngdAttchId) {
		model.setPhsclyChlngdAttchId(phsclyChlngdAttchId);
	}

	/**
	 * Sets the physcly chlngd of this dgf dlr updt temp dtls.
	 *
	 * @param physclyChlngd the physcly chlngd of this dgf dlr updt temp dtls
	 */
	@Override
	public void setPhysclyChlngd(int physclyChlngd) {
		model.setPhysclyChlngd(physclyChlngd);
	}

	/**
	 * Sets the primary key of this dgf dlr updt temp dtls.
	 *
	 * @param primaryKey the primary key of this dgf dlr updt temp dtls
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the shp district of this dgf dlr updt temp dtls.
	 *
	 * @param shpDistrict the shp district of this dgf dlr updt temp dtls
	 */
	@Override
	public void setShpDistrict(long shpDistrict) {
		model.setShpDistrict(shpDistrict);
	}

	/**
	 * Sets the shp division of this dgf dlr updt temp dtls.
	 *
	 * @param shpDivision the shp division of this dgf dlr updt temp dtls
	 */
	@Override
	public void setShpDivision(long shpDivision) {
		model.setShpDivision(shpDivision);
	}

	/**
	 * Sets the shp flr cmntd of this dgf dlr updt temp dtls.
	 *
	 * @param shpFlrCmntd the shp flr cmntd of this dgf dlr updt temp dtls
	 */
	@Override
	public void setShpFlrCmntd(int shpFlrCmntd) {
		model.setShpFlrCmntd(shpFlrCmntd);
	}

	/**
	 * Sets the shp height of this dgf dlr updt temp dtls.
	 *
	 * @param shpHeight the shp height of this dgf dlr updt temp dtls
	 */
	@Override
	public void setShpHeight(long shpHeight) {
		model.setShpHeight(shpHeight);
	}

	/**
	 * Sets the shp length of this dgf dlr updt temp dtls.
	 *
	 * @param shpLength the shp length of this dgf dlr updt temp dtls
	 */
	@Override
	public void setShpLength(long shpLength) {
		model.setShpLength(shpLength);
	}

	/**
	 * Sets the shp location of this dgf dlr updt temp dtls.
	 *
	 * @param shpLocation the shp location of this dgf dlr updt temp dtls
	 */
	@Override
	public void setShpLocation(String shpLocation) {
		model.setShpLocation(shpLocation);
	}

	/**
	 * Sets the shp present address of this dgf dlr updt temp dtls.
	 *
	 * @param shpPresentAddress the shp present address of this dgf dlr updt temp dtls
	 */
	@Override
	public void setShpPresentAddress(String shpPresentAddress) {
		model.setShpPresentAddress(shpPresentAddress);
	}

	/**
	 * Sets the shp pst offc of this dgf dlr updt temp dtls.
	 *
	 * @param shpPstOffc the shp pst offc of this dgf dlr updt temp dtls
	 */
	@Override
	public void setShpPstOffc(String shpPstOffc) {
		model.setShpPstOffc(shpPstOffc);
	}

	/**
	 * Sets the shp sign brd of this dgf dlr updt temp dtls.
	 *
	 * @param shpSignBrd the shp sign brd of this dgf dlr updt temp dtls
	 */
	@Override
	public void setShpSignBrd(int shpSignBrd) {
		model.setShpSignBrd(shpSignBrd);
	}

	/**
	 * Sets the shp strg cpcty of this dgf dlr updt temp dtls.
	 *
	 * @param shpStrgCpcty the shp strg cpcty of this dgf dlr updt temp dtls
	 */
	@Override
	public void setShpStrgCpcty(long shpStrgCpcty) {
		model.setShpStrgCpcty(shpStrgCpcty);
	}

	/**
	 * Sets the shp union of this dgf dlr updt temp dtls.
	 *
	 * @param shpUnion the shp union of this dgf dlr updt temp dtls
	 */
	@Override
	public void setShpUnion(long shpUnion) {
		model.setShpUnion(shpUnion);
	}

	/**
	 * Sets the shp upzilla of this dgf dlr updt temp dtls.
	 *
	 * @param shpUpzilla the shp upzilla of this dgf dlr updt temp dtls
	 */
	@Override
	public void setShpUpzilla(long shpUpzilla) {
		model.setShpUpzilla(shpUpzilla);
	}

	/**
	 * Sets the shp village of this dgf dlr updt temp dtls.
	 *
	 * @param shpVillage the shp village of this dgf dlr updt temp dtls
	 */
	@Override
	public void setShpVillage(String shpVillage) {
		model.setShpVillage(shpVillage);
	}

	/**
	 * Sets the shp ward of this dgf dlr updt temp dtls.
	 *
	 * @param shpWard the shp ward of this dgf dlr updt temp dtls
	 */
	@Override
	public void setShpWard(String shpWard) {
		model.setShpWard(shpWard);
	}

	/**
	 * Sets the shp width of this dgf dlr updt temp dtls.
	 *
	 * @param shpWidth the shp width of this dgf dlr updt temp dtls
	 */
	@Override
	public void setShpWidth(long shpWidth) {
		model.setShpWidth(shpWidth);
	}

	/**
	 * Sets the shp zip code of this dgf dlr updt temp dtls.
	 *
	 * @param shpZipCode the shp zip code of this dgf dlr updt temp dtls
	 */
	@Override
	public void setShpZipCode(String shpZipCode) {
		model.setShpZipCode(shpZipCode);
	}

	/**
	 * Sets the spouse brth date of this dgf dlr updt temp dtls.
	 *
	 * @param spouseBrthDate the spouse brth date of this dgf dlr updt temp dtls
	 */
	@Override
	public void setSpouseBrthDate(Date spouseBrthDate) {
		model.setSpouseBrthDate(spouseBrthDate);
	}

	/**
	 * Sets the spouse fthr name of this dgf dlr updt temp dtls.
	 *
	 * @param spouseFthrName the spouse fthr name of this dgf dlr updt temp dtls
	 */
	@Override
	public void setSpouseFthrName(String spouseFthrName) {
		model.setSpouseFthrName(spouseFthrName);
	}

	/**
	 * Sets the spouse name of this dgf dlr updt temp dtls.
	 *
	 * @param spouseName the spouse name of this dgf dlr updt temp dtls
	 */
	@Override
	public void setSpouseName(String spouseName) {
		model.setSpouseName(spouseName);
	}

	/**
	 * Sets the spouse nid of this dgf dlr updt temp dtls.
	 *
	 * @param spouseNid the spouse nid of this dgf dlr updt temp dtls
	 */
	@Override
	public void setSpouseNid(String spouseNid) {
		model.setSpouseNid(spouseNid);
	}

	/**
	 * Sets the status of this dgf dlr updt temp dtls.
	 *
	 * @param status the status of this dgf dlr updt temp dtls
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this dgf dlr updt temp dtls.
	 *
	 * @param statusByUserId the status by user ID of this dgf dlr updt temp dtls
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this dgf dlr updt temp dtls.
	 *
	 * @param statusByUserName the status by user name of this dgf dlr updt temp dtls
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this dgf dlr updt temp dtls.
	 *
	 * @param statusByUserUuid the status by user uuid of this dgf dlr updt temp dtls
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this dgf dlr updt temp dtls.
	 *
	 * @param statusDate the status date of this dgf dlr updt temp dtls
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the tcv dlr license of this dgf dlr updt temp dtls.
	 *
	 * @param tcvDlrLicense the tcv dlr license of this dgf dlr updt temp dtls
	 */
	@Override
	public void setTcvDlrLicense(int tcvDlrLicense) {
		model.setTcvDlrLicense(tcvDlrLicense);
	}

	/**
	 * Sets the thrd party ops flg of this dgf dlr updt temp dtls.
	 *
	 * @param thrdPartyOpsFlg the thrd party ops flg of this dgf dlr updt temp dtls
	 */
	@Override
	public void setThrdPartyOpsFlg(long thrdPartyOpsFlg) {
		model.setThrdPartyOpsFlg(thrdPartyOpsFlg);
	}

	/**
	 * Sets the trade license of this dgf dlr updt temp dtls.
	 *
	 * @param tradeLicense the trade license of this dgf dlr updt temp dtls
	 */
	@Override
	public void setTradeLicense(int tradeLicense) {
		model.setTradeLicense(tradeLicense);
	}

	/**
	 * Sets the trade license agriculture of this dgf dlr updt temp dtls.
	 *
	 * @param tradeLicenseAgriculture the trade license agriculture of this dgf dlr updt temp dtls
	 */
	@Override
	public void setTradeLicenseAgriculture(int tradeLicenseAgriculture) {
		model.setTradeLicenseAgriculture(tradeLicenseAgriculture);
	}

	/**
	 * Sets the trck cpcty of this dgf dlr updt temp dtls.
	 *
	 * @param trckCpcty the trck cpcty of this dgf dlr updt temp dtls
	 */
	@Override
	public void setTrckCpcty(long trckCpcty) {
		model.setTrckCpcty(trckCpcty);
	}

	/**
	 * Sets the trck licns plat no of this dgf dlr updt temp dtls.
	 *
	 * @param trckLicnsPlatNo the trck licns plat no of this dgf dlr updt temp dtls
	 */
	@Override
	public void setTrckLicnsPlatNo(String trckLicnsPlatNo) {
		model.setTrckLicnsPlatNo(trckLicnsPlatNo);
	}

	/**
	 * Sets the trck make of this dgf dlr updt temp dtls.
	 *
	 * @param trckMake the trck make of this dgf dlr updt temp dtls
	 */
	@Override
	public void setTrckMake(String trckMake) {
		model.setTrckMake(trckMake);
	}

	/**
	 * Sets the trck mfg yr of this dgf dlr updt temp dtls.
	 *
	 * @param trckMfgYr the trck mfg yr of this dgf dlr updt temp dtls
	 */
	@Override
	public void setTrckMfgYr(long trckMfgYr) {
		model.setTrckMfgYr(trckMfgYr);
	}

	/**
	 * Sets the trck model of this dgf dlr updt temp dtls.
	 *
	 * @param trckModel the trck model of this dgf dlr updt temp dtls
	 */
	@Override
	public void setTrckModel(String trckModel) {
		model.setTrckModel(trckModel);
	}

	/**
	 * Sets the trck rent own flg of this dgf dlr updt temp dtls.
	 *
	 * @param trckRentOwnFlg the trck rent own flg of this dgf dlr updt temp dtls
	 */
	@Override
	public void setTrckRentOwnFlg(String trckRentOwnFlg) {
		model.setTrckRentOwnFlg(trckRentOwnFlg);
	}

	/**
	 * Sets the user ID of this dgf dlr updt temp dtls.
	 *
	 * @param userId the user ID of this dgf dlr updt temp dtls
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this dgf dlr updt temp dtls.
	 *
	 * @param userUuid the user uuid of this dgf dlr updt temp dtls
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the version of this dgf dlr updt temp dtls.
	 *
	 * @param version the version of this dgf dlr updt temp dtls
	 */
	@Override
	public void setVersion(long version) {
		model.setVersion(version);
	}

	/**
	 * Sets the wrk in govt of this dgf dlr updt temp dtls.
	 *
	 * @param wrkInGovt the wrk in govt of this dgf dlr updt temp dtls
	 */
	@Override
	public void setWrkInGovt(int wrkInGovt) {
		model.setWrkInGovt(wrkInGovt);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DgfDlrUpdtTempDtlsWrapper wrap(
		DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls) {

		return new DgfDlrUpdtTempDtlsWrapper(dgfDlrUpdtTempDtls);
	}

}