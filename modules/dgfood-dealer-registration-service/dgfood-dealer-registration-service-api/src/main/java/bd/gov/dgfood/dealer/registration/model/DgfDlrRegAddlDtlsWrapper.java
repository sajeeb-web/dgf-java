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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DgfDlrRegAddlDtls}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrRegAddlDtls
 * @generated
 */
public class DgfDlrRegAddlDtlsWrapper
	extends BaseModelWrapper<DgfDlrRegAddlDtls>
	implements DgfDlrRegAddlDtls, ModelWrapper<DgfDlrRegAddlDtls> {

	public DgfDlrRegAddlDtlsWrapper(DgfDlrRegAddlDtls dgfDlrRegAddlDtls) {
		super(dgfDlrRegAddlDtls);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dlrRegAddlDtlsId", getDlrRegAddlDtlsId());
		attributes.put("nationalId", getNationalId());
		attributes.put("dlrRegAppLNo", getDlrRegAppLNo());
		attributes.put("dlrRegNo", getDlrRegNo());
		attributes.put("pblcRep", getPblcRep());
		attributes.put("wrkInGovt", getWrkInGovt());
		attributes.put("physclyChlngd", getPhysclyChlngd());
		attributes.put("phsclyChlnGdAttchId", getPhsclyChlnGdAttchId());
		attributes.put("licenseType", getLicenseType());
		attributes.put("thirdPartyOpsFlg", getThirdPartyOpsFlg());
		attributes.put("fmlyDlrShpNo", getFmlyDlrShpNo());
		attributes.put("dlrshpFmlyMmbrName", getDlrshpFmlyMmbrName());
		attributes.put("dlrshpFmlyMmbrType", getDlrshpFmlyMmbrType());
		attributes.put("dlrShpTrckTypFlg", getDlrShpTrckTypFlg());
		attributes.put("trckLicnsPlatNo", getTrckLicnsPlatNo());
		attributes.put("trckCpcty", getTrckCpcty());
		attributes.put("trckMake", getTrckMake());
		attributes.put("trckModel", getTrckModel());
		attributes.put("trckRentOwnFlg", getTrckRentOwnFlg());
		attributes.put("trckMfgYr", getTrckMfgYr());
		attributes.put("shpLength", getShpLength());
		attributes.put("shpHeight", getShpHeight());
		attributes.put("shpWidth", getShpWidth());
		attributes.put("shpStrgCpcty", getShpStrgCpcty());
		attributes.put("shpFlrCmntd", getShpFlrCmntd());
		attributes.put("shpSignBrd", getShpSignBrd());
		attributes.put("dlrLicnsPosses", getDlrLicnsPosses());
		attributes.put("dlrRunShpHimself", getDlrRunShpHimself());
		attributes.put("dlrFmlyDlrShpFlg", getDlrFmlyDlrShpFlg());
		attributes.put("version", getVersion());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dlrRegAddlDtlsId = (Long)attributes.get("dlrRegAddlDtlsId");

		if (dlrRegAddlDtlsId != null) {
			setDlrRegAddlDtlsId(dlrRegAddlDtlsId);
		}

		String nationalId = (String)attributes.get("nationalId");

		if (nationalId != null) {
			setNationalId(nationalId);
		}

		Long dlrRegAppLNo = (Long)attributes.get("dlrRegAppLNo");

		if (dlrRegAppLNo != null) {
			setDlrRegAppLNo(dlrRegAppLNo);
		}

		Long dlrRegNo = (Long)attributes.get("dlrRegNo");

		if (dlrRegNo != null) {
			setDlrRegNo(dlrRegNo);
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

		Long phsclyChlnGdAttchId = (Long)attributes.get("phsclyChlnGdAttchId");

		if (phsclyChlnGdAttchId != null) {
			setPhsclyChlnGdAttchId(phsclyChlnGdAttchId);
		}

		String licenseType = (String)attributes.get("licenseType");

		if (licenseType != null) {
			setLicenseType(licenseType);
		}

		Long thirdPartyOpsFlg = (Long)attributes.get("thirdPartyOpsFlg");

		if (thirdPartyOpsFlg != null) {
			setThirdPartyOpsFlg(thirdPartyOpsFlg);
		}

		Long fmlyDlrShpNo = (Long)attributes.get("fmlyDlrShpNo");

		if (fmlyDlrShpNo != null) {
			setFmlyDlrShpNo(fmlyDlrShpNo);
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

		Integer dlrShpTrckTypFlg = (Integer)attributes.get("dlrShpTrckTypFlg");

		if (dlrShpTrckTypFlg != null) {
			setDlrShpTrckTypFlg(dlrShpTrckTypFlg);
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

		Integer dlrLicnsPosses = (Integer)attributes.get("dlrLicnsPosses");

		if (dlrLicnsPosses != null) {
			setDlrLicnsPosses(dlrLicnsPosses);
		}

		Integer dlrRunShpHimself = (Integer)attributes.get("dlrRunShpHimself");

		if (dlrRunShpHimself != null) {
			setDlrRunShpHimself(dlrRunShpHimself);
		}

		Long dlrFmlyDlrShpFlg = (Long)attributes.get("dlrFmlyDlrShpFlg");

		if (dlrFmlyDlrShpFlg != null) {
			setDlrFmlyDlrShpFlg(dlrFmlyDlrShpFlg);
		}

		Long version = (Long)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}
	}

	@Override
	public DgfDlrRegAddlDtls cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the dlr fmly dlr shp flg of this dgf dlr reg addl dtls.
	 *
	 * @return the dlr fmly dlr shp flg of this dgf dlr reg addl dtls
	 */
	@Override
	public long getDlrFmlyDlrShpFlg() {
		return model.getDlrFmlyDlrShpFlg();
	}

	/**
	 * Returns the dlr licns posses of this dgf dlr reg addl dtls.
	 *
	 * @return the dlr licns posses of this dgf dlr reg addl dtls
	 */
	@Override
	public int getDlrLicnsPosses() {
		return model.getDlrLicnsPosses();
	}

	/**
	 * Returns the dlr reg addl dtls ID of this dgf dlr reg addl dtls.
	 *
	 * @return the dlr reg addl dtls ID of this dgf dlr reg addl dtls
	 */
	@Override
	public long getDlrRegAddlDtlsId() {
		return model.getDlrRegAddlDtlsId();
	}

	/**
	 * Returns the dlr reg app l no of this dgf dlr reg addl dtls.
	 *
	 * @return the dlr reg app l no of this dgf dlr reg addl dtls
	 */
	@Override
	public long getDlrRegAppLNo() {
		return model.getDlrRegAppLNo();
	}

	/**
	 * Returns the dlr reg no of this dgf dlr reg addl dtls.
	 *
	 * @return the dlr reg no of this dgf dlr reg addl dtls
	 */
	@Override
	public long getDlrRegNo() {
		return model.getDlrRegNo();
	}

	/**
	 * Returns the dlr run shp himself of this dgf dlr reg addl dtls.
	 *
	 * @return the dlr run shp himself of this dgf dlr reg addl dtls
	 */
	@Override
	public int getDlrRunShpHimself() {
		return model.getDlrRunShpHimself();
	}

	/**
	 * Returns the dlrshp fmly mmbr name of this dgf dlr reg addl dtls.
	 *
	 * @return the dlrshp fmly mmbr name of this dgf dlr reg addl dtls
	 */
	@Override
	public String getDlrshpFmlyMmbrName() {
		return model.getDlrshpFmlyMmbrName();
	}

	/**
	 * Returns the dlrshp fmly mmbr type of this dgf dlr reg addl dtls.
	 *
	 * @return the dlrshp fmly mmbr type of this dgf dlr reg addl dtls
	 */
	@Override
	public String getDlrshpFmlyMmbrType() {
		return model.getDlrshpFmlyMmbrType();
	}

	/**
	 * Returns the dlr shp trck typ flg of this dgf dlr reg addl dtls.
	 *
	 * @return the dlr shp trck typ flg of this dgf dlr reg addl dtls
	 */
	@Override
	public int getDlrShpTrckTypFlg() {
		return model.getDlrShpTrckTypFlg();
	}

	/**
	 * Returns the fmly dlr shp no of this dgf dlr reg addl dtls.
	 *
	 * @return the fmly dlr shp no of this dgf dlr reg addl dtls
	 */
	@Override
	public long getFmlyDlrShpNo() {
		return model.getFmlyDlrShpNo();
	}

	/**
	 * Returns the license type of this dgf dlr reg addl dtls.
	 *
	 * @return the license type of this dgf dlr reg addl dtls
	 */
	@Override
	public String getLicenseType() {
		return model.getLicenseType();
	}

	/**
	 * Returns the national ID of this dgf dlr reg addl dtls.
	 *
	 * @return the national ID of this dgf dlr reg addl dtls
	 */
	@Override
	public String getNationalId() {
		return model.getNationalId();
	}

	/**
	 * Returns the pblc rep of this dgf dlr reg addl dtls.
	 *
	 * @return the pblc rep of this dgf dlr reg addl dtls
	 */
	@Override
	public int getPblcRep() {
		return model.getPblcRep();
	}

	/**
	 * Returns the phscly chln gd attch ID of this dgf dlr reg addl dtls.
	 *
	 * @return the phscly chln gd attch ID of this dgf dlr reg addl dtls
	 */
	@Override
	public long getPhsclyChlnGdAttchId() {
		return model.getPhsclyChlnGdAttchId();
	}

	/**
	 * Returns the physcly chlngd of this dgf dlr reg addl dtls.
	 *
	 * @return the physcly chlngd of this dgf dlr reg addl dtls
	 */
	@Override
	public int getPhysclyChlngd() {
		return model.getPhysclyChlngd();
	}

	/**
	 * Returns the primary key of this dgf dlr reg addl dtls.
	 *
	 * @return the primary key of this dgf dlr reg addl dtls
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the shp flr cmntd of this dgf dlr reg addl dtls.
	 *
	 * @return the shp flr cmntd of this dgf dlr reg addl dtls
	 */
	@Override
	public int getShpFlrCmntd() {
		return model.getShpFlrCmntd();
	}

	/**
	 * Returns the shp height of this dgf dlr reg addl dtls.
	 *
	 * @return the shp height of this dgf dlr reg addl dtls
	 */
	@Override
	public long getShpHeight() {
		return model.getShpHeight();
	}

	/**
	 * Returns the shp length of this dgf dlr reg addl dtls.
	 *
	 * @return the shp length of this dgf dlr reg addl dtls
	 */
	@Override
	public long getShpLength() {
		return model.getShpLength();
	}

	/**
	 * Returns the shp sign brd of this dgf dlr reg addl dtls.
	 *
	 * @return the shp sign brd of this dgf dlr reg addl dtls
	 */
	@Override
	public int getShpSignBrd() {
		return model.getShpSignBrd();
	}

	/**
	 * Returns the shp strg cpcty of this dgf dlr reg addl dtls.
	 *
	 * @return the shp strg cpcty of this dgf dlr reg addl dtls
	 */
	@Override
	public long getShpStrgCpcty() {
		return model.getShpStrgCpcty();
	}

	/**
	 * Returns the shp width of this dgf dlr reg addl dtls.
	 *
	 * @return the shp width of this dgf dlr reg addl dtls
	 */
	@Override
	public long getShpWidth() {
		return model.getShpWidth();
	}

	/**
	 * Returns the third party ops flg of this dgf dlr reg addl dtls.
	 *
	 * @return the third party ops flg of this dgf dlr reg addl dtls
	 */
	@Override
	public long getThirdPartyOpsFlg() {
		return model.getThirdPartyOpsFlg();
	}

	/**
	 * Returns the trck cpcty of this dgf dlr reg addl dtls.
	 *
	 * @return the trck cpcty of this dgf dlr reg addl dtls
	 */
	@Override
	public long getTrckCpcty() {
		return model.getTrckCpcty();
	}

	/**
	 * Returns the trck licns plat no of this dgf dlr reg addl dtls.
	 *
	 * @return the trck licns plat no of this dgf dlr reg addl dtls
	 */
	@Override
	public String getTrckLicnsPlatNo() {
		return model.getTrckLicnsPlatNo();
	}

	/**
	 * Returns the trck make of this dgf dlr reg addl dtls.
	 *
	 * @return the trck make of this dgf dlr reg addl dtls
	 */
	@Override
	public String getTrckMake() {
		return model.getTrckMake();
	}

	/**
	 * Returns the trck mfg yr of this dgf dlr reg addl dtls.
	 *
	 * @return the trck mfg yr of this dgf dlr reg addl dtls
	 */
	@Override
	public long getTrckMfgYr() {
		return model.getTrckMfgYr();
	}

	/**
	 * Returns the trck model of this dgf dlr reg addl dtls.
	 *
	 * @return the trck model of this dgf dlr reg addl dtls
	 */
	@Override
	public String getTrckModel() {
		return model.getTrckModel();
	}

	/**
	 * Returns the trck rent own flg of this dgf dlr reg addl dtls.
	 *
	 * @return the trck rent own flg of this dgf dlr reg addl dtls
	 */
	@Override
	public String getTrckRentOwnFlg() {
		return model.getTrckRentOwnFlg();
	}

	/**
	 * Returns the version of this dgf dlr reg addl dtls.
	 *
	 * @return the version of this dgf dlr reg addl dtls
	 */
	@Override
	public long getVersion() {
		return model.getVersion();
	}

	/**
	 * Returns the wrk in govt of this dgf dlr reg addl dtls.
	 *
	 * @return the wrk in govt of this dgf dlr reg addl dtls
	 */
	@Override
	public int getWrkInGovt() {
		return model.getWrkInGovt();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the dlr fmly dlr shp flg of this dgf dlr reg addl dtls.
	 *
	 * @param dlrFmlyDlrShpFlg the dlr fmly dlr shp flg of this dgf dlr reg addl dtls
	 */
	@Override
	public void setDlrFmlyDlrShpFlg(long dlrFmlyDlrShpFlg) {
		model.setDlrFmlyDlrShpFlg(dlrFmlyDlrShpFlg);
	}

	/**
	 * Sets the dlr licns posses of this dgf dlr reg addl dtls.
	 *
	 * @param dlrLicnsPosses the dlr licns posses of this dgf dlr reg addl dtls
	 */
	@Override
	public void setDlrLicnsPosses(int dlrLicnsPosses) {
		model.setDlrLicnsPosses(dlrLicnsPosses);
	}

	/**
	 * Sets the dlr reg addl dtls ID of this dgf dlr reg addl dtls.
	 *
	 * @param dlrRegAddlDtlsId the dlr reg addl dtls ID of this dgf dlr reg addl dtls
	 */
	@Override
	public void setDlrRegAddlDtlsId(long dlrRegAddlDtlsId) {
		model.setDlrRegAddlDtlsId(dlrRegAddlDtlsId);
	}

	/**
	 * Sets the dlr reg app l no of this dgf dlr reg addl dtls.
	 *
	 * @param dlrRegAppLNo the dlr reg app l no of this dgf dlr reg addl dtls
	 */
	@Override
	public void setDlrRegAppLNo(long dlrRegAppLNo) {
		model.setDlrRegAppLNo(dlrRegAppLNo);
	}

	/**
	 * Sets the dlr reg no of this dgf dlr reg addl dtls.
	 *
	 * @param dlrRegNo the dlr reg no of this dgf dlr reg addl dtls
	 */
	@Override
	public void setDlrRegNo(long dlrRegNo) {
		model.setDlrRegNo(dlrRegNo);
	}

	/**
	 * Sets the dlr run shp himself of this dgf dlr reg addl dtls.
	 *
	 * @param dlrRunShpHimself the dlr run shp himself of this dgf dlr reg addl dtls
	 */
	@Override
	public void setDlrRunShpHimself(int dlrRunShpHimself) {
		model.setDlrRunShpHimself(dlrRunShpHimself);
	}

	/**
	 * Sets the dlrshp fmly mmbr name of this dgf dlr reg addl dtls.
	 *
	 * @param dlrshpFmlyMmbrName the dlrshp fmly mmbr name of this dgf dlr reg addl dtls
	 */
	@Override
	public void setDlrshpFmlyMmbrName(String dlrshpFmlyMmbrName) {
		model.setDlrshpFmlyMmbrName(dlrshpFmlyMmbrName);
	}

	/**
	 * Sets the dlrshp fmly mmbr type of this dgf dlr reg addl dtls.
	 *
	 * @param dlrshpFmlyMmbrType the dlrshp fmly mmbr type of this dgf dlr reg addl dtls
	 */
	@Override
	public void setDlrshpFmlyMmbrType(String dlrshpFmlyMmbrType) {
		model.setDlrshpFmlyMmbrType(dlrshpFmlyMmbrType);
	}

	/**
	 * Sets the dlr shp trck typ flg of this dgf dlr reg addl dtls.
	 *
	 * @param dlrShpTrckTypFlg the dlr shp trck typ flg of this dgf dlr reg addl dtls
	 */
	@Override
	public void setDlrShpTrckTypFlg(int dlrShpTrckTypFlg) {
		model.setDlrShpTrckTypFlg(dlrShpTrckTypFlg);
	}

	/**
	 * Sets the fmly dlr shp no of this dgf dlr reg addl dtls.
	 *
	 * @param fmlyDlrShpNo the fmly dlr shp no of this dgf dlr reg addl dtls
	 */
	@Override
	public void setFmlyDlrShpNo(long fmlyDlrShpNo) {
		model.setFmlyDlrShpNo(fmlyDlrShpNo);
	}

	/**
	 * Sets the license type of this dgf dlr reg addl dtls.
	 *
	 * @param licenseType the license type of this dgf dlr reg addl dtls
	 */
	@Override
	public void setLicenseType(String licenseType) {
		model.setLicenseType(licenseType);
	}

	/**
	 * Sets the national ID of this dgf dlr reg addl dtls.
	 *
	 * @param nationalId the national ID of this dgf dlr reg addl dtls
	 */
	@Override
	public void setNationalId(String nationalId) {
		model.setNationalId(nationalId);
	}

	/**
	 * Sets the pblc rep of this dgf dlr reg addl dtls.
	 *
	 * @param pblcRep the pblc rep of this dgf dlr reg addl dtls
	 */
	@Override
	public void setPblcRep(int pblcRep) {
		model.setPblcRep(pblcRep);
	}

	/**
	 * Sets the phscly chln gd attch ID of this dgf dlr reg addl dtls.
	 *
	 * @param phsclyChlnGdAttchId the phscly chln gd attch ID of this dgf dlr reg addl dtls
	 */
	@Override
	public void setPhsclyChlnGdAttchId(long phsclyChlnGdAttchId) {
		model.setPhsclyChlnGdAttchId(phsclyChlnGdAttchId);
	}

	/**
	 * Sets the physcly chlngd of this dgf dlr reg addl dtls.
	 *
	 * @param physclyChlngd the physcly chlngd of this dgf dlr reg addl dtls
	 */
	@Override
	public void setPhysclyChlngd(int physclyChlngd) {
		model.setPhysclyChlngd(physclyChlngd);
	}

	/**
	 * Sets the primary key of this dgf dlr reg addl dtls.
	 *
	 * @param primaryKey the primary key of this dgf dlr reg addl dtls
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the shp flr cmntd of this dgf dlr reg addl dtls.
	 *
	 * @param shpFlrCmntd the shp flr cmntd of this dgf dlr reg addl dtls
	 */
	@Override
	public void setShpFlrCmntd(int shpFlrCmntd) {
		model.setShpFlrCmntd(shpFlrCmntd);
	}

	/**
	 * Sets the shp height of this dgf dlr reg addl dtls.
	 *
	 * @param shpHeight the shp height of this dgf dlr reg addl dtls
	 */
	@Override
	public void setShpHeight(long shpHeight) {
		model.setShpHeight(shpHeight);
	}

	/**
	 * Sets the shp length of this dgf dlr reg addl dtls.
	 *
	 * @param shpLength the shp length of this dgf dlr reg addl dtls
	 */
	@Override
	public void setShpLength(long shpLength) {
		model.setShpLength(shpLength);
	}

	/**
	 * Sets the shp sign brd of this dgf dlr reg addl dtls.
	 *
	 * @param shpSignBrd the shp sign brd of this dgf dlr reg addl dtls
	 */
	@Override
	public void setShpSignBrd(int shpSignBrd) {
		model.setShpSignBrd(shpSignBrd);
	}

	/**
	 * Sets the shp strg cpcty of this dgf dlr reg addl dtls.
	 *
	 * @param shpStrgCpcty the shp strg cpcty of this dgf dlr reg addl dtls
	 */
	@Override
	public void setShpStrgCpcty(long shpStrgCpcty) {
		model.setShpStrgCpcty(shpStrgCpcty);
	}

	/**
	 * Sets the shp width of this dgf dlr reg addl dtls.
	 *
	 * @param shpWidth the shp width of this dgf dlr reg addl dtls
	 */
	@Override
	public void setShpWidth(long shpWidth) {
		model.setShpWidth(shpWidth);
	}

	/**
	 * Sets the third party ops flg of this dgf dlr reg addl dtls.
	 *
	 * @param thirdPartyOpsFlg the third party ops flg of this dgf dlr reg addl dtls
	 */
	@Override
	public void setThirdPartyOpsFlg(long thirdPartyOpsFlg) {
		model.setThirdPartyOpsFlg(thirdPartyOpsFlg);
	}

	/**
	 * Sets the trck cpcty of this dgf dlr reg addl dtls.
	 *
	 * @param trckCpcty the trck cpcty of this dgf dlr reg addl dtls
	 */
	@Override
	public void setTrckCpcty(long trckCpcty) {
		model.setTrckCpcty(trckCpcty);
	}

	/**
	 * Sets the trck licns plat no of this dgf dlr reg addl dtls.
	 *
	 * @param trckLicnsPlatNo the trck licns plat no of this dgf dlr reg addl dtls
	 */
	@Override
	public void setTrckLicnsPlatNo(String trckLicnsPlatNo) {
		model.setTrckLicnsPlatNo(trckLicnsPlatNo);
	}

	/**
	 * Sets the trck make of this dgf dlr reg addl dtls.
	 *
	 * @param trckMake the trck make of this dgf dlr reg addl dtls
	 */
	@Override
	public void setTrckMake(String trckMake) {
		model.setTrckMake(trckMake);
	}

	/**
	 * Sets the trck mfg yr of this dgf dlr reg addl dtls.
	 *
	 * @param trckMfgYr the trck mfg yr of this dgf dlr reg addl dtls
	 */
	@Override
	public void setTrckMfgYr(long trckMfgYr) {
		model.setTrckMfgYr(trckMfgYr);
	}

	/**
	 * Sets the trck model of this dgf dlr reg addl dtls.
	 *
	 * @param trckModel the trck model of this dgf dlr reg addl dtls
	 */
	@Override
	public void setTrckModel(String trckModel) {
		model.setTrckModel(trckModel);
	}

	/**
	 * Sets the trck rent own flg of this dgf dlr reg addl dtls.
	 *
	 * @param trckRentOwnFlg the trck rent own flg of this dgf dlr reg addl dtls
	 */
	@Override
	public void setTrckRentOwnFlg(String trckRentOwnFlg) {
		model.setTrckRentOwnFlg(trckRentOwnFlg);
	}

	/**
	 * Sets the version of this dgf dlr reg addl dtls.
	 *
	 * @param version the version of this dgf dlr reg addl dtls
	 */
	@Override
	public void setVersion(long version) {
		model.setVersion(version);
	}

	/**
	 * Sets the wrk in govt of this dgf dlr reg addl dtls.
	 *
	 * @param wrkInGovt the wrk in govt of this dgf dlr reg addl dtls
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
	protected DgfDlrRegAddlDtlsWrapper wrap(
		DgfDlrRegAddlDtls dgfDlrRegAddlDtls) {

		return new DgfDlrRegAddlDtlsWrapper(dgfDlrRegAddlDtls);
	}

}