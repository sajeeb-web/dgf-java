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

package bd.gov.dgfood.dealer.registration.model.impl;

import bd.gov.dgfood.dealer.registration.model.DgfDlrRegAddlDtls;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DgfDlrRegAddlDtls in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DgfDlrRegAddlDtlsCacheModel
	implements CacheModel<DgfDlrRegAddlDtls>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DgfDlrRegAddlDtlsCacheModel)) {
			return false;
		}

		DgfDlrRegAddlDtlsCacheModel dgfDlrRegAddlDtlsCacheModel =
			(DgfDlrRegAddlDtlsCacheModel)object;

		if (dlrRegAddlDtlsId == dgfDlrRegAddlDtlsCacheModel.dlrRegAddlDtlsId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dlrRegAddlDtlsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(61);

		sb.append("{dlrRegAddlDtlsId=");
		sb.append(dlrRegAddlDtlsId);
		sb.append(", nationalId=");
		sb.append(nationalId);
		sb.append(", dlrRegAppLNo=");
		sb.append(dlrRegAppLNo);
		sb.append(", dlrRegNo=");
		sb.append(dlrRegNo);
		sb.append(", pblcRep=");
		sb.append(pblcRep);
		sb.append(", wrkInGovt=");
		sb.append(wrkInGovt);
		sb.append(", physclyChlngd=");
		sb.append(physclyChlngd);
		sb.append(", phsclyChlnGdAttchId=");
		sb.append(phsclyChlnGdAttchId);
		sb.append(", licenseType=");
		sb.append(licenseType);
		sb.append(", thirdPartyOpsFlg=");
		sb.append(thirdPartyOpsFlg);
		sb.append(", fmlyDlrShpNo=");
		sb.append(fmlyDlrShpNo);
		sb.append(", dlrshpFmlyMmbrName=");
		sb.append(dlrshpFmlyMmbrName);
		sb.append(", dlrshpFmlyMmbrType=");
		sb.append(dlrshpFmlyMmbrType);
		sb.append(", dlrShpTrckTypFlg=");
		sb.append(dlrShpTrckTypFlg);
		sb.append(", trckLicnsPlatNo=");
		sb.append(trckLicnsPlatNo);
		sb.append(", trckCpcty=");
		sb.append(trckCpcty);
		sb.append(", trckMake=");
		sb.append(trckMake);
		sb.append(", trckModel=");
		sb.append(trckModel);
		sb.append(", trckRentOwnFlg=");
		sb.append(trckRentOwnFlg);
		sb.append(", trckMfgYr=");
		sb.append(trckMfgYr);
		sb.append(", shpLength=");
		sb.append(shpLength);
		sb.append(", shpHeight=");
		sb.append(shpHeight);
		sb.append(", shpWidth=");
		sb.append(shpWidth);
		sb.append(", shpStrgCpcty=");
		sb.append(shpStrgCpcty);
		sb.append(", shpFlrCmntd=");
		sb.append(shpFlrCmntd);
		sb.append(", shpSignBrd=");
		sb.append(shpSignBrd);
		sb.append(", dlrLicnsPosses=");
		sb.append(dlrLicnsPosses);
		sb.append(", dlrRunShpHimself=");
		sb.append(dlrRunShpHimself);
		sb.append(", dlrFmlyDlrShpFlg=");
		sb.append(dlrFmlyDlrShpFlg);
		sb.append(", version=");
		sb.append(version);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DgfDlrRegAddlDtls toEntityModel() {
		DgfDlrRegAddlDtlsImpl dgfDlrRegAddlDtlsImpl =
			new DgfDlrRegAddlDtlsImpl();

		dgfDlrRegAddlDtlsImpl.setDlrRegAddlDtlsId(dlrRegAddlDtlsId);

		if (nationalId == null) {
			dgfDlrRegAddlDtlsImpl.setNationalId("");
		}
		else {
			dgfDlrRegAddlDtlsImpl.setNationalId(nationalId);
		}

		dgfDlrRegAddlDtlsImpl.setDlrRegAppLNo(dlrRegAppLNo);
		dgfDlrRegAddlDtlsImpl.setDlrRegNo(dlrRegNo);
		dgfDlrRegAddlDtlsImpl.setPblcRep(pblcRep);
		dgfDlrRegAddlDtlsImpl.setWrkInGovt(wrkInGovt);
		dgfDlrRegAddlDtlsImpl.setPhysclyChlngd(physclyChlngd);
		dgfDlrRegAddlDtlsImpl.setPhsclyChlnGdAttchId(phsclyChlnGdAttchId);

		if (licenseType == null) {
			dgfDlrRegAddlDtlsImpl.setLicenseType("");
		}
		else {
			dgfDlrRegAddlDtlsImpl.setLicenseType(licenseType);
		}

		dgfDlrRegAddlDtlsImpl.setThirdPartyOpsFlg(thirdPartyOpsFlg);
		dgfDlrRegAddlDtlsImpl.setFmlyDlrShpNo(fmlyDlrShpNo);

		if (dlrshpFmlyMmbrName == null) {
			dgfDlrRegAddlDtlsImpl.setDlrshpFmlyMmbrName("");
		}
		else {
			dgfDlrRegAddlDtlsImpl.setDlrshpFmlyMmbrName(dlrshpFmlyMmbrName);
		}

		if (dlrshpFmlyMmbrType == null) {
			dgfDlrRegAddlDtlsImpl.setDlrshpFmlyMmbrType("");
		}
		else {
			dgfDlrRegAddlDtlsImpl.setDlrshpFmlyMmbrType(dlrshpFmlyMmbrType);
		}

		dgfDlrRegAddlDtlsImpl.setDlrShpTrckTypFlg(dlrShpTrckTypFlg);

		if (trckLicnsPlatNo == null) {
			dgfDlrRegAddlDtlsImpl.setTrckLicnsPlatNo("");
		}
		else {
			dgfDlrRegAddlDtlsImpl.setTrckLicnsPlatNo(trckLicnsPlatNo);
		}

		dgfDlrRegAddlDtlsImpl.setTrckCpcty(trckCpcty);

		if (trckMake == null) {
			dgfDlrRegAddlDtlsImpl.setTrckMake("");
		}
		else {
			dgfDlrRegAddlDtlsImpl.setTrckMake(trckMake);
		}

		if (trckModel == null) {
			dgfDlrRegAddlDtlsImpl.setTrckModel("");
		}
		else {
			dgfDlrRegAddlDtlsImpl.setTrckModel(trckModel);
		}

		if (trckRentOwnFlg == null) {
			dgfDlrRegAddlDtlsImpl.setTrckRentOwnFlg("");
		}
		else {
			dgfDlrRegAddlDtlsImpl.setTrckRentOwnFlg(trckRentOwnFlg);
		}

		dgfDlrRegAddlDtlsImpl.setTrckMfgYr(trckMfgYr);
		dgfDlrRegAddlDtlsImpl.setShpLength(shpLength);
		dgfDlrRegAddlDtlsImpl.setShpHeight(shpHeight);
		dgfDlrRegAddlDtlsImpl.setShpWidth(shpWidth);
		dgfDlrRegAddlDtlsImpl.setShpStrgCpcty(shpStrgCpcty);
		dgfDlrRegAddlDtlsImpl.setShpFlrCmntd(shpFlrCmntd);
		dgfDlrRegAddlDtlsImpl.setShpSignBrd(shpSignBrd);
		dgfDlrRegAddlDtlsImpl.setDlrLicnsPosses(dlrLicnsPosses);
		dgfDlrRegAddlDtlsImpl.setDlrRunShpHimself(dlrRunShpHimself);
		dgfDlrRegAddlDtlsImpl.setDlrFmlyDlrShpFlg(dlrFmlyDlrShpFlg);
		dgfDlrRegAddlDtlsImpl.setVersion(version);

		dgfDlrRegAddlDtlsImpl.resetOriginalValues();

		return dgfDlrRegAddlDtlsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dlrRegAddlDtlsId = objectInput.readLong();
		nationalId = objectInput.readUTF();

		dlrRegAppLNo = objectInput.readLong();

		dlrRegNo = objectInput.readLong();

		pblcRep = objectInput.readInt();

		wrkInGovt = objectInput.readInt();

		physclyChlngd = objectInput.readInt();

		phsclyChlnGdAttchId = objectInput.readLong();
		licenseType = objectInput.readUTF();

		thirdPartyOpsFlg = objectInput.readLong();

		fmlyDlrShpNo = objectInput.readLong();
		dlrshpFmlyMmbrName = objectInput.readUTF();
		dlrshpFmlyMmbrType = objectInput.readUTF();

		dlrShpTrckTypFlg = objectInput.readInt();
		trckLicnsPlatNo = objectInput.readUTF();

		trckCpcty = objectInput.readLong();
		trckMake = objectInput.readUTF();
		trckModel = objectInput.readUTF();
		trckRentOwnFlg = objectInput.readUTF();

		trckMfgYr = objectInput.readLong();

		shpLength = objectInput.readLong();

		shpHeight = objectInput.readLong();

		shpWidth = objectInput.readLong();

		shpStrgCpcty = objectInput.readLong();

		shpFlrCmntd = objectInput.readInt();

		shpSignBrd = objectInput.readInt();

		dlrLicnsPosses = objectInput.readInt();

		dlrRunShpHimself = objectInput.readInt();

		dlrFmlyDlrShpFlg = objectInput.readLong();

		version = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(dlrRegAddlDtlsId);

		if (nationalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationalId);
		}

		objectOutput.writeLong(dlrRegAppLNo);

		objectOutput.writeLong(dlrRegNo);

		objectOutput.writeInt(pblcRep);

		objectOutput.writeInt(wrkInGovt);

		objectOutput.writeInt(physclyChlngd);

		objectOutput.writeLong(phsclyChlnGdAttchId);

		if (licenseType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(licenseType);
		}

		objectOutput.writeLong(thirdPartyOpsFlg);

		objectOutput.writeLong(fmlyDlrShpNo);

		if (dlrshpFmlyMmbrName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dlrshpFmlyMmbrName);
		}

		if (dlrshpFmlyMmbrType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dlrshpFmlyMmbrType);
		}

		objectOutput.writeInt(dlrShpTrckTypFlg);

		if (trckLicnsPlatNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(trckLicnsPlatNo);
		}

		objectOutput.writeLong(trckCpcty);

		if (trckMake == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(trckMake);
		}

		if (trckModel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(trckModel);
		}

		if (trckRentOwnFlg == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(trckRentOwnFlg);
		}

		objectOutput.writeLong(trckMfgYr);

		objectOutput.writeLong(shpLength);

		objectOutput.writeLong(shpHeight);

		objectOutput.writeLong(shpWidth);

		objectOutput.writeLong(shpStrgCpcty);

		objectOutput.writeInt(shpFlrCmntd);

		objectOutput.writeInt(shpSignBrd);

		objectOutput.writeInt(dlrLicnsPosses);

		objectOutput.writeInt(dlrRunShpHimself);

		objectOutput.writeLong(dlrFmlyDlrShpFlg);

		objectOutput.writeLong(version);
	}

	public long dlrRegAddlDtlsId;
	public String nationalId;
	public long dlrRegAppLNo;
	public long dlrRegNo;
	public int pblcRep;
	public int wrkInGovt;
	public int physclyChlngd;
	public long phsclyChlnGdAttchId;
	public String licenseType;
	public long thirdPartyOpsFlg;
	public long fmlyDlrShpNo;
	public String dlrshpFmlyMmbrName;
	public String dlrshpFmlyMmbrType;
	public int dlrShpTrckTypFlg;
	public String trckLicnsPlatNo;
	public long trckCpcty;
	public String trckMake;
	public String trckModel;
	public String trckRentOwnFlg;
	public long trckMfgYr;
	public long shpLength;
	public long shpHeight;
	public long shpWidth;
	public long shpStrgCpcty;
	public int shpFlrCmntd;
	public int shpSignBrd;
	public int dlrLicnsPosses;
	public int dlrRunShpHimself;
	public long dlrFmlyDlrShpFlg;
	public long version;

}