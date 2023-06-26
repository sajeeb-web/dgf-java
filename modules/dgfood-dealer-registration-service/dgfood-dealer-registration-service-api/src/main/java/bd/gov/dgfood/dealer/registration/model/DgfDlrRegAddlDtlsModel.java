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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the DgfDlrRegAddlDtls service. Represents a row in the &quot;dgf_dlr_reg_addl_dtls&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>bd.gov.dgfood.dealer.registration.model.impl.DgfDlrRegAddlDtlsModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>bd.gov.dgfood.dealer.registration.model.impl.DgfDlrRegAddlDtlsImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrRegAddlDtls
 * @generated
 */
@ProviderType
public interface DgfDlrRegAddlDtlsModel extends BaseModel<DgfDlrRegAddlDtls> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a dgf dlr reg addl dtls model instance should use the {@link DgfDlrRegAddlDtls} interface instead.
	 */

	/**
	 * Returns the primary key of this dgf dlr reg addl dtls.
	 *
	 * @return the primary key of this dgf dlr reg addl dtls
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this dgf dlr reg addl dtls.
	 *
	 * @param primaryKey the primary key of this dgf dlr reg addl dtls
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the dlr reg addl dtls ID of this dgf dlr reg addl dtls.
	 *
	 * @return the dlr reg addl dtls ID of this dgf dlr reg addl dtls
	 */
	public long getDlrRegAddlDtlsId();

	/**
	 * Sets the dlr reg addl dtls ID of this dgf dlr reg addl dtls.
	 *
	 * @param dlrRegAddlDtlsId the dlr reg addl dtls ID of this dgf dlr reg addl dtls
	 */
	public void setDlrRegAddlDtlsId(long dlrRegAddlDtlsId);

	/**
	 * Returns the national ID of this dgf dlr reg addl dtls.
	 *
	 * @return the national ID of this dgf dlr reg addl dtls
	 */
	@AutoEscape
	public String getNationalId();

	/**
	 * Sets the national ID of this dgf dlr reg addl dtls.
	 *
	 * @param nationalId the national ID of this dgf dlr reg addl dtls
	 */
	public void setNationalId(String nationalId);

	/**
	 * Returns the dlr reg app l no of this dgf dlr reg addl dtls.
	 *
	 * @return the dlr reg app l no of this dgf dlr reg addl dtls
	 */
	public long getDlrRegAppLNo();

	/**
	 * Sets the dlr reg app l no of this dgf dlr reg addl dtls.
	 *
	 * @param dlrRegAppLNo the dlr reg app l no of this dgf dlr reg addl dtls
	 */
	public void setDlrRegAppLNo(long dlrRegAppLNo);

	/**
	 * Returns the dlr reg no of this dgf dlr reg addl dtls.
	 *
	 * @return the dlr reg no of this dgf dlr reg addl dtls
	 */
	public long getDlrRegNo();

	/**
	 * Sets the dlr reg no of this dgf dlr reg addl dtls.
	 *
	 * @param dlrRegNo the dlr reg no of this dgf dlr reg addl dtls
	 */
	public void setDlrRegNo(long dlrRegNo);

	/**
	 * Returns the pblc rep of this dgf dlr reg addl dtls.
	 *
	 * @return the pblc rep of this dgf dlr reg addl dtls
	 */
	public int getPblcRep();

	/**
	 * Sets the pblc rep of this dgf dlr reg addl dtls.
	 *
	 * @param pblcRep the pblc rep of this dgf dlr reg addl dtls
	 */
	public void setPblcRep(int pblcRep);

	/**
	 * Returns the wrk in govt of this dgf dlr reg addl dtls.
	 *
	 * @return the wrk in govt of this dgf dlr reg addl dtls
	 */
	public int getWrkInGovt();

	/**
	 * Sets the wrk in govt of this dgf dlr reg addl dtls.
	 *
	 * @param wrkInGovt the wrk in govt of this dgf dlr reg addl dtls
	 */
	public void setWrkInGovt(int wrkInGovt);

	/**
	 * Returns the physcly chlngd of this dgf dlr reg addl dtls.
	 *
	 * @return the physcly chlngd of this dgf dlr reg addl dtls
	 */
	public int getPhysclyChlngd();

	/**
	 * Sets the physcly chlngd of this dgf dlr reg addl dtls.
	 *
	 * @param physclyChlngd the physcly chlngd of this dgf dlr reg addl dtls
	 */
	public void setPhysclyChlngd(int physclyChlngd);

	/**
	 * Returns the phscly chln gd attch ID of this dgf dlr reg addl dtls.
	 *
	 * @return the phscly chln gd attch ID of this dgf dlr reg addl dtls
	 */
	public long getPhsclyChlnGdAttchId();

	/**
	 * Sets the phscly chln gd attch ID of this dgf dlr reg addl dtls.
	 *
	 * @param phsclyChlnGdAttchId the phscly chln gd attch ID of this dgf dlr reg addl dtls
	 */
	public void setPhsclyChlnGdAttchId(long phsclyChlnGdAttchId);

	/**
	 * Returns the license type of this dgf dlr reg addl dtls.
	 *
	 * @return the license type of this dgf dlr reg addl dtls
	 */
	@AutoEscape
	public String getLicenseType();

	/**
	 * Sets the license type of this dgf dlr reg addl dtls.
	 *
	 * @param licenseType the license type of this dgf dlr reg addl dtls
	 */
	public void setLicenseType(String licenseType);

	/**
	 * Returns the third party ops flg of this dgf dlr reg addl dtls.
	 *
	 * @return the third party ops flg of this dgf dlr reg addl dtls
	 */
	public long getThirdPartyOpsFlg();

	/**
	 * Sets the third party ops flg of this dgf dlr reg addl dtls.
	 *
	 * @param thirdPartyOpsFlg the third party ops flg of this dgf dlr reg addl dtls
	 */
	public void setThirdPartyOpsFlg(long thirdPartyOpsFlg);

	/**
	 * Returns the fmly dlr shp no of this dgf dlr reg addl dtls.
	 *
	 * @return the fmly dlr shp no of this dgf dlr reg addl dtls
	 */
	public long getFmlyDlrShpNo();

	/**
	 * Sets the fmly dlr shp no of this dgf dlr reg addl dtls.
	 *
	 * @param fmlyDlrShpNo the fmly dlr shp no of this dgf dlr reg addl dtls
	 */
	public void setFmlyDlrShpNo(long fmlyDlrShpNo);

	/**
	 * Returns the dlrshp fmly mmbr name of this dgf dlr reg addl dtls.
	 *
	 * @return the dlrshp fmly mmbr name of this dgf dlr reg addl dtls
	 */
	@AutoEscape
	public String getDlrshpFmlyMmbrName();

	/**
	 * Sets the dlrshp fmly mmbr name of this dgf dlr reg addl dtls.
	 *
	 * @param dlrshpFmlyMmbrName the dlrshp fmly mmbr name of this dgf dlr reg addl dtls
	 */
	public void setDlrshpFmlyMmbrName(String dlrshpFmlyMmbrName);

	/**
	 * Returns the dlrshp fmly mmbr type of this dgf dlr reg addl dtls.
	 *
	 * @return the dlrshp fmly mmbr type of this dgf dlr reg addl dtls
	 */
	@AutoEscape
	public String getDlrshpFmlyMmbrType();

	/**
	 * Sets the dlrshp fmly mmbr type of this dgf dlr reg addl dtls.
	 *
	 * @param dlrshpFmlyMmbrType the dlrshp fmly mmbr type of this dgf dlr reg addl dtls
	 */
	public void setDlrshpFmlyMmbrType(String dlrshpFmlyMmbrType);

	/**
	 * Returns the dlr shp trck typ flg of this dgf dlr reg addl dtls.
	 *
	 * @return the dlr shp trck typ flg of this dgf dlr reg addl dtls
	 */
	public int getDlrShpTrckTypFlg();

	/**
	 * Sets the dlr shp trck typ flg of this dgf dlr reg addl dtls.
	 *
	 * @param dlrShpTrckTypFlg the dlr shp trck typ flg of this dgf dlr reg addl dtls
	 */
	public void setDlrShpTrckTypFlg(int dlrShpTrckTypFlg);

	/**
	 * Returns the trck licns plat no of this dgf dlr reg addl dtls.
	 *
	 * @return the trck licns plat no of this dgf dlr reg addl dtls
	 */
	@AutoEscape
	public String getTrckLicnsPlatNo();

	/**
	 * Sets the trck licns plat no of this dgf dlr reg addl dtls.
	 *
	 * @param trckLicnsPlatNo the trck licns plat no of this dgf dlr reg addl dtls
	 */
	public void setTrckLicnsPlatNo(String trckLicnsPlatNo);

	/**
	 * Returns the trck cpcty of this dgf dlr reg addl dtls.
	 *
	 * @return the trck cpcty of this dgf dlr reg addl dtls
	 */
	public long getTrckCpcty();

	/**
	 * Sets the trck cpcty of this dgf dlr reg addl dtls.
	 *
	 * @param trckCpcty the trck cpcty of this dgf dlr reg addl dtls
	 */
	public void setTrckCpcty(long trckCpcty);

	/**
	 * Returns the trck make of this dgf dlr reg addl dtls.
	 *
	 * @return the trck make of this dgf dlr reg addl dtls
	 */
	@AutoEscape
	public String getTrckMake();

	/**
	 * Sets the trck make of this dgf dlr reg addl dtls.
	 *
	 * @param trckMake the trck make of this dgf dlr reg addl dtls
	 */
	public void setTrckMake(String trckMake);

	/**
	 * Returns the trck model of this dgf dlr reg addl dtls.
	 *
	 * @return the trck model of this dgf dlr reg addl dtls
	 */
	@AutoEscape
	public String getTrckModel();

	/**
	 * Sets the trck model of this dgf dlr reg addl dtls.
	 *
	 * @param trckModel the trck model of this dgf dlr reg addl dtls
	 */
	public void setTrckModel(String trckModel);

	/**
	 * Returns the trck rent own flg of this dgf dlr reg addl dtls.
	 *
	 * @return the trck rent own flg of this dgf dlr reg addl dtls
	 */
	@AutoEscape
	public String getTrckRentOwnFlg();

	/**
	 * Sets the trck rent own flg of this dgf dlr reg addl dtls.
	 *
	 * @param trckRentOwnFlg the trck rent own flg of this dgf dlr reg addl dtls
	 */
	public void setTrckRentOwnFlg(String trckRentOwnFlg);

	/**
	 * Returns the trck mfg yr of this dgf dlr reg addl dtls.
	 *
	 * @return the trck mfg yr of this dgf dlr reg addl dtls
	 */
	public long getTrckMfgYr();

	/**
	 * Sets the trck mfg yr of this dgf dlr reg addl dtls.
	 *
	 * @param trckMfgYr the trck mfg yr of this dgf dlr reg addl dtls
	 */
	public void setTrckMfgYr(long trckMfgYr);

	/**
	 * Returns the shp length of this dgf dlr reg addl dtls.
	 *
	 * @return the shp length of this dgf dlr reg addl dtls
	 */
	public long getShpLength();

	/**
	 * Sets the shp length of this dgf dlr reg addl dtls.
	 *
	 * @param shpLength the shp length of this dgf dlr reg addl dtls
	 */
	public void setShpLength(long shpLength);

	/**
	 * Returns the shp height of this dgf dlr reg addl dtls.
	 *
	 * @return the shp height of this dgf dlr reg addl dtls
	 */
	public long getShpHeight();

	/**
	 * Sets the shp height of this dgf dlr reg addl dtls.
	 *
	 * @param shpHeight the shp height of this dgf dlr reg addl dtls
	 */
	public void setShpHeight(long shpHeight);

	/**
	 * Returns the shp width of this dgf dlr reg addl dtls.
	 *
	 * @return the shp width of this dgf dlr reg addl dtls
	 */
	public long getShpWidth();

	/**
	 * Sets the shp width of this dgf dlr reg addl dtls.
	 *
	 * @param shpWidth the shp width of this dgf dlr reg addl dtls
	 */
	public void setShpWidth(long shpWidth);

	/**
	 * Returns the shp strg cpcty of this dgf dlr reg addl dtls.
	 *
	 * @return the shp strg cpcty of this dgf dlr reg addl dtls
	 */
	public long getShpStrgCpcty();

	/**
	 * Sets the shp strg cpcty of this dgf dlr reg addl dtls.
	 *
	 * @param shpStrgCpcty the shp strg cpcty of this dgf dlr reg addl dtls
	 */
	public void setShpStrgCpcty(long shpStrgCpcty);

	/**
	 * Returns the shp flr cmntd of this dgf dlr reg addl dtls.
	 *
	 * @return the shp flr cmntd of this dgf dlr reg addl dtls
	 */
	public int getShpFlrCmntd();

	/**
	 * Sets the shp flr cmntd of this dgf dlr reg addl dtls.
	 *
	 * @param shpFlrCmntd the shp flr cmntd of this dgf dlr reg addl dtls
	 */
	public void setShpFlrCmntd(int shpFlrCmntd);

	/**
	 * Returns the shp sign brd of this dgf dlr reg addl dtls.
	 *
	 * @return the shp sign brd of this dgf dlr reg addl dtls
	 */
	public int getShpSignBrd();

	/**
	 * Sets the shp sign brd of this dgf dlr reg addl dtls.
	 *
	 * @param shpSignBrd the shp sign brd of this dgf dlr reg addl dtls
	 */
	public void setShpSignBrd(int shpSignBrd);

	/**
	 * Returns the dlr licns posses of this dgf dlr reg addl dtls.
	 *
	 * @return the dlr licns posses of this dgf dlr reg addl dtls
	 */
	public int getDlrLicnsPosses();

	/**
	 * Sets the dlr licns posses of this dgf dlr reg addl dtls.
	 *
	 * @param dlrLicnsPosses the dlr licns posses of this dgf dlr reg addl dtls
	 */
	public void setDlrLicnsPosses(int dlrLicnsPosses);

	/**
	 * Returns the dlr run shp himself of this dgf dlr reg addl dtls.
	 *
	 * @return the dlr run shp himself of this dgf dlr reg addl dtls
	 */
	public int getDlrRunShpHimself();

	/**
	 * Sets the dlr run shp himself of this dgf dlr reg addl dtls.
	 *
	 * @param dlrRunShpHimself the dlr run shp himself of this dgf dlr reg addl dtls
	 */
	public void setDlrRunShpHimself(int dlrRunShpHimself);

	/**
	 * Returns the dlr fmly dlr shp flg of this dgf dlr reg addl dtls.
	 *
	 * @return the dlr fmly dlr shp flg of this dgf dlr reg addl dtls
	 */
	public long getDlrFmlyDlrShpFlg();

	/**
	 * Sets the dlr fmly dlr shp flg of this dgf dlr reg addl dtls.
	 *
	 * @param dlrFmlyDlrShpFlg the dlr fmly dlr shp flg of this dgf dlr reg addl dtls
	 */
	public void setDlrFmlyDlrShpFlg(long dlrFmlyDlrShpFlg);

	/**
	 * Returns the version of this dgf dlr reg addl dtls.
	 *
	 * @return the version of this dgf dlr reg addl dtls
	 */
	public long getVersion();

	/**
	 * Sets the version of this dgf dlr reg addl dtls.
	 *
	 * @param version the version of this dgf dlr reg addl dtls
	 */
	public void setVersion(long version);

	@Override
	public DgfDlrRegAddlDtls cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}