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

import bd.gov.dgfood.dealer.registration.model.DgfDlrUpdtTempDtls;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DgfDlrUpdtTempDtls in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DgfDlrUpdtTempDtlsCacheModel
	implements CacheModel<DgfDlrUpdtTempDtls>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DgfDlrUpdtTempDtlsCacheModel)) {
			return false;
		}

		DgfDlrUpdtTempDtlsCacheModel dgfDlrUpdtTempDtlsCacheModel =
			(DgfDlrUpdtTempDtlsCacheModel)object;

		if (dgfDlrUpdateReqId ==
				dgfDlrUpdtTempDtlsCacheModel.dgfDlrUpdateReqId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dgfDlrUpdateReqId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(147);

		sb.append("{dgfDlrUpdateReqId=");
		sb.append(dgfDlrUpdateReqId);
		sb.append(", nationalId=");
		sb.append(nationalId);
		sb.append(", dlrRegNo=");
		sb.append(dlrRegNo);
		sb.append(", maritalStatus=");
		sb.append(maritalStatus);
		sb.append(", spouseName=");
		sb.append(spouseName);
		sb.append(", spouseFthrName=");
		sb.append(spouseFthrName);
		sb.append(", spouseNid=");
		sb.append(spouseNid);
		sb.append(", spouseBrthDate=");
		sb.append(spouseBrthDate);
		sb.append(", pblcRep=");
		sb.append(pblcRep);
		sb.append(", wrkInGovt=");
		sb.append(wrkInGovt);
		sb.append(", physclyChlngd=");
		sb.append(physclyChlngd);
		sb.append(", phsclyChlngdAttchId=");
		sb.append(phsclyChlngdAttchId);
		sb.append(", shpDivision=");
		sb.append(shpDivision);
		sb.append(", shpDistrict=");
		sb.append(shpDistrict);
		sb.append(", shpUpzilla=");
		sb.append(shpUpzilla);
		sb.append(", shpUnion=");
		sb.append(shpUnion);
		sb.append(", shpVillage=");
		sb.append(shpVillage);
		sb.append(", shpWard=");
		sb.append(shpWard);
		sb.append(", shpZipCode=");
		sb.append(shpZipCode);
		sb.append(", shpPstOffc=");
		sb.append(shpPstOffc);
		sb.append(", shpPresentAddress=");
		sb.append(shpPresentAddress);
		sb.append(", shpLocation=");
		sb.append(shpLocation);
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
		sb.append(", licenseType=");
		sb.append(licenseType);
		sb.append(", thrdPartyOpsFlg=");
		sb.append(thrdPartyOpsFlg);
		sb.append(", dlrshpFmlyMmbrName=");
		sb.append(dlrshpFmlyMmbrName);
		sb.append(", dlrshpFmlyMmbrType=");
		sb.append(dlrshpFmlyMmbrType);
		sb.append(", dlrPerfYr1=");
		sb.append(dlrPerfYr1);
		sb.append(", dlrPerfYr1AllocQty=");
		sb.append(dlrPerfYr1AllocQty);
		sb.append(", dlrPerfYr1ComdtyQty=");
		sb.append(dlrPerfYr1ComdtyQty);
		sb.append(", dlrPerfYr1DlrCtgry=");
		sb.append(dlrPerfYr1DlrCtgry);
		sb.append(", dlrPerfYr1Rmrk=");
		sb.append(dlrPerfYr1Rmrk);
		sb.append(", dlrPerfYr2=");
		sb.append(dlrPerfYr2);
		sb.append(", dlrPerfYr2AllocQty=");
		sb.append(dlrPerfYr2AllocQty);
		sb.append(", dlrPerfYr2ComdtyQty=");
		sb.append(dlrPerfYr2ComdtyQty);
		sb.append(", dlrPerfYr2DlrCtgry=");
		sb.append(dlrPerfYr2DlrCtgry);
		sb.append(", dlrPerfYr2Rmrk=");
		sb.append(dlrPerfYr2Rmrk);
		sb.append(", dlrPerfYr3=");
		sb.append(dlrPerfYr3);
		sb.append(", dlrPerfYr3AllocQty=");
		sb.append(dlrPerfYr3AllocQty);
		sb.append(", dlrPerfYr3ComdtyQty=");
		sb.append(dlrPerfYr3ComdtyQty);
		sb.append(", dlrPerfYr3DlrCtgry=");
		sb.append(dlrPerfYr3DlrCtgry);
		sb.append(", dlrPerfYr3Rmrk=");
		sb.append(dlrPerfYr3Rmrk);
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
		sb.append(", version=");
		sb.append(version);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", lastUpdtdBy=");
		sb.append(lastUpdtdBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", foodgrainLicense=");
		sb.append(foodgrainLicense);
		sb.append(", tradeLicense=");
		sb.append(tradeLicense);
		sb.append(", tcvDlrLicense=");
		sb.append(tcvDlrLicense);
		sb.append(", importLicense=");
		sb.append(importLicense);
		sb.append(", licenseEssentialGoods=");
		sb.append(licenseEssentialGoods);
		sb.append(", tradeLicenseAgriculture=");
		sb.append(tradeLicenseAgriculture);
		sb.append(", dlrOmsSubType=");
		sb.append(dlrOmsSubType);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", dlrRunShpHimself=");
		sb.append(dlrRunShpHimself);
		sb.append(", dlrShpTrckTypFlg=");
		sb.append(dlrShpTrckTypFlg);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DgfDlrUpdtTempDtls toEntityModel() {
		DgfDlrUpdtTempDtlsImpl dgfDlrUpdtTempDtlsImpl =
			new DgfDlrUpdtTempDtlsImpl();

		dgfDlrUpdtTempDtlsImpl.setDgfDlrUpdateReqId(dgfDlrUpdateReqId);

		if (nationalId == null) {
			dgfDlrUpdtTempDtlsImpl.setNationalId("");
		}
		else {
			dgfDlrUpdtTempDtlsImpl.setNationalId(nationalId);
		}

		dgfDlrUpdtTempDtlsImpl.setDlrRegNo(dlrRegNo);

		if (maritalStatus == null) {
			dgfDlrUpdtTempDtlsImpl.setMaritalStatus("");
		}
		else {
			dgfDlrUpdtTempDtlsImpl.setMaritalStatus(maritalStatus);
		}

		if (spouseName == null) {
			dgfDlrUpdtTempDtlsImpl.setSpouseName("");
		}
		else {
			dgfDlrUpdtTempDtlsImpl.setSpouseName(spouseName);
		}

		if (spouseFthrName == null) {
			dgfDlrUpdtTempDtlsImpl.setSpouseFthrName("");
		}
		else {
			dgfDlrUpdtTempDtlsImpl.setSpouseFthrName(spouseFthrName);
		}

		if (spouseNid == null) {
			dgfDlrUpdtTempDtlsImpl.setSpouseNid("");
		}
		else {
			dgfDlrUpdtTempDtlsImpl.setSpouseNid(spouseNid);
		}

		if (spouseBrthDate == Long.MIN_VALUE) {
			dgfDlrUpdtTempDtlsImpl.setSpouseBrthDate(null);
		}
		else {
			dgfDlrUpdtTempDtlsImpl.setSpouseBrthDate(new Date(spouseBrthDate));
		}

		dgfDlrUpdtTempDtlsImpl.setPblcRep(pblcRep);
		dgfDlrUpdtTempDtlsImpl.setWrkInGovt(wrkInGovt);
		dgfDlrUpdtTempDtlsImpl.setPhysclyChlngd(physclyChlngd);
		dgfDlrUpdtTempDtlsImpl.setPhsclyChlngdAttchId(phsclyChlngdAttchId);
		dgfDlrUpdtTempDtlsImpl.setShpDivision(shpDivision);
		dgfDlrUpdtTempDtlsImpl.setShpDistrict(shpDistrict);
		dgfDlrUpdtTempDtlsImpl.setShpUpzilla(shpUpzilla);
		dgfDlrUpdtTempDtlsImpl.setShpUnion(shpUnion);

		if (shpVillage == null) {
			dgfDlrUpdtTempDtlsImpl.setShpVillage("");
		}
		else {
			dgfDlrUpdtTempDtlsImpl.setShpVillage(shpVillage);
		}

		if (shpWard == null) {
			dgfDlrUpdtTempDtlsImpl.setShpWard("");
		}
		else {
			dgfDlrUpdtTempDtlsImpl.setShpWard(shpWard);
		}

		if (shpZipCode == null) {
			dgfDlrUpdtTempDtlsImpl.setShpZipCode("");
		}
		else {
			dgfDlrUpdtTempDtlsImpl.setShpZipCode(shpZipCode);
		}

		if (shpPstOffc == null) {
			dgfDlrUpdtTempDtlsImpl.setShpPstOffc("");
		}
		else {
			dgfDlrUpdtTempDtlsImpl.setShpPstOffc(shpPstOffc);
		}

		if (shpPresentAddress == null) {
			dgfDlrUpdtTempDtlsImpl.setShpPresentAddress("");
		}
		else {
			dgfDlrUpdtTempDtlsImpl.setShpPresentAddress(shpPresentAddress);
		}

		if (shpLocation == null) {
			dgfDlrUpdtTempDtlsImpl.setShpLocation("");
		}
		else {
			dgfDlrUpdtTempDtlsImpl.setShpLocation(shpLocation);
		}

		dgfDlrUpdtTempDtlsImpl.setShpLength(shpLength);
		dgfDlrUpdtTempDtlsImpl.setShpHeight(shpHeight);
		dgfDlrUpdtTempDtlsImpl.setShpWidth(shpWidth);
		dgfDlrUpdtTempDtlsImpl.setShpStrgCpcty(shpStrgCpcty);
		dgfDlrUpdtTempDtlsImpl.setShpFlrCmntd(shpFlrCmntd);
		dgfDlrUpdtTempDtlsImpl.setShpSignBrd(shpSignBrd);

		if (licenseType == null) {
			dgfDlrUpdtTempDtlsImpl.setLicenseType("");
		}
		else {
			dgfDlrUpdtTempDtlsImpl.setLicenseType(licenseType);
		}

		dgfDlrUpdtTempDtlsImpl.setThrdPartyOpsFlg(thrdPartyOpsFlg);

		if (dlrshpFmlyMmbrName == null) {
			dgfDlrUpdtTempDtlsImpl.setDlrshpFmlyMmbrName("");
		}
		else {
			dgfDlrUpdtTempDtlsImpl.setDlrshpFmlyMmbrName(dlrshpFmlyMmbrName);
		}

		if (dlrshpFmlyMmbrType == null) {
			dgfDlrUpdtTempDtlsImpl.setDlrshpFmlyMmbrType("");
		}
		else {
			dgfDlrUpdtTempDtlsImpl.setDlrshpFmlyMmbrType(dlrshpFmlyMmbrType);
		}

		dgfDlrUpdtTempDtlsImpl.setDlrPerfYr1(dlrPerfYr1);
		dgfDlrUpdtTempDtlsImpl.setDlrPerfYr1AllocQty(dlrPerfYr1AllocQty);
		dgfDlrUpdtTempDtlsImpl.setDlrPerfYr1ComdtyQty(dlrPerfYr1ComdtyQty);

		if (dlrPerfYr1DlrCtgry == null) {
			dgfDlrUpdtTempDtlsImpl.setDlrPerfYr1DlrCtgry("");
		}
		else {
			dgfDlrUpdtTempDtlsImpl.setDlrPerfYr1DlrCtgry(dlrPerfYr1DlrCtgry);
		}

		if (dlrPerfYr1Rmrk == null) {
			dgfDlrUpdtTempDtlsImpl.setDlrPerfYr1Rmrk("");
		}
		else {
			dgfDlrUpdtTempDtlsImpl.setDlrPerfYr1Rmrk(dlrPerfYr1Rmrk);
		}

		dgfDlrUpdtTempDtlsImpl.setDlrPerfYr2(dlrPerfYr2);
		dgfDlrUpdtTempDtlsImpl.setDlrPerfYr2AllocQty(dlrPerfYr2AllocQty);
		dgfDlrUpdtTempDtlsImpl.setDlrPerfYr2ComdtyQty(dlrPerfYr2ComdtyQty);

		if (dlrPerfYr2DlrCtgry == null) {
			dgfDlrUpdtTempDtlsImpl.setDlrPerfYr2DlrCtgry("");
		}
		else {
			dgfDlrUpdtTempDtlsImpl.setDlrPerfYr2DlrCtgry(dlrPerfYr2DlrCtgry);
		}

		if (dlrPerfYr2Rmrk == null) {
			dgfDlrUpdtTempDtlsImpl.setDlrPerfYr2Rmrk("");
		}
		else {
			dgfDlrUpdtTempDtlsImpl.setDlrPerfYr2Rmrk(dlrPerfYr2Rmrk);
		}

		dgfDlrUpdtTempDtlsImpl.setDlrPerfYr3(dlrPerfYr3);
		dgfDlrUpdtTempDtlsImpl.setDlrPerfYr3AllocQty(dlrPerfYr3AllocQty);
		dgfDlrUpdtTempDtlsImpl.setDlrPerfYr3ComdtyQty(dlrPerfYr3ComdtyQty);

		if (dlrPerfYr3DlrCtgry == null) {
			dgfDlrUpdtTempDtlsImpl.setDlrPerfYr3DlrCtgry("");
		}
		else {
			dgfDlrUpdtTempDtlsImpl.setDlrPerfYr3DlrCtgry(dlrPerfYr3DlrCtgry);
		}

		if (dlrPerfYr3Rmrk == null) {
			dgfDlrUpdtTempDtlsImpl.setDlrPerfYr3Rmrk("");
		}
		else {
			dgfDlrUpdtTempDtlsImpl.setDlrPerfYr3Rmrk(dlrPerfYr3Rmrk);
		}

		if (trckLicnsPlatNo == null) {
			dgfDlrUpdtTempDtlsImpl.setTrckLicnsPlatNo("");
		}
		else {
			dgfDlrUpdtTempDtlsImpl.setTrckLicnsPlatNo(trckLicnsPlatNo);
		}

		dgfDlrUpdtTempDtlsImpl.setTrckCpcty(trckCpcty);

		if (trckMake == null) {
			dgfDlrUpdtTempDtlsImpl.setTrckMake("");
		}
		else {
			dgfDlrUpdtTempDtlsImpl.setTrckMake(trckMake);
		}

		if (trckModel == null) {
			dgfDlrUpdtTempDtlsImpl.setTrckModel("");
		}
		else {
			dgfDlrUpdtTempDtlsImpl.setTrckModel(trckModel);
		}

		if (trckRentOwnFlg == null) {
			dgfDlrUpdtTempDtlsImpl.setTrckRentOwnFlg("");
		}
		else {
			dgfDlrUpdtTempDtlsImpl.setTrckRentOwnFlg(trckRentOwnFlg);
		}

		dgfDlrUpdtTempDtlsImpl.setTrckMfgYr(trckMfgYr);
		dgfDlrUpdtTempDtlsImpl.setVersion(version);
		dgfDlrUpdtTempDtlsImpl.setStatus(status);
		dgfDlrUpdtTempDtlsImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			dgfDlrUpdtTempDtlsImpl.setStatusByUserName("");
		}
		else {
			dgfDlrUpdtTempDtlsImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			dgfDlrUpdtTempDtlsImpl.setStatusDate(null);
		}
		else {
			dgfDlrUpdtTempDtlsImpl.setStatusDate(new Date(statusDate));
		}

		if (createDate == Long.MIN_VALUE) {
			dgfDlrUpdtTempDtlsImpl.setCreateDate(null);
		}
		else {
			dgfDlrUpdtTempDtlsImpl.setCreateDate(new Date(createDate));
		}

		dgfDlrUpdtTempDtlsImpl.setLastUpdtdBy(lastUpdtdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			dgfDlrUpdtTempDtlsImpl.setModifiedDate(null);
		}
		else {
			dgfDlrUpdtTempDtlsImpl.setModifiedDate(new Date(modifiedDate));
		}

		dgfDlrUpdtTempDtlsImpl.setFoodgrainLicense(foodgrainLicense);
		dgfDlrUpdtTempDtlsImpl.setTradeLicense(tradeLicense);
		dgfDlrUpdtTempDtlsImpl.setTcvDlrLicense(tcvDlrLicense);
		dgfDlrUpdtTempDtlsImpl.setImportLicense(importLicense);
		dgfDlrUpdtTempDtlsImpl.setLicenseEssentialGoods(licenseEssentialGoods);
		dgfDlrUpdtTempDtlsImpl.setTradeLicenseAgriculture(
			tradeLicenseAgriculture);

		if (dlrOmsSubType == null) {
			dgfDlrUpdtTempDtlsImpl.setDlrOmsSubType("");
		}
		else {
			dgfDlrUpdtTempDtlsImpl.setDlrOmsSubType(dlrOmsSubType);
		}

		dgfDlrUpdtTempDtlsImpl.setUserId(userId);
		dgfDlrUpdtTempDtlsImpl.setGroupId(groupId);
		dgfDlrUpdtTempDtlsImpl.setCompanyId(companyId);
		dgfDlrUpdtTempDtlsImpl.setDlrRunShpHimself(dlrRunShpHimself);
		dgfDlrUpdtTempDtlsImpl.setDlrShpTrckTypFlg(dlrShpTrckTypFlg);

		dgfDlrUpdtTempDtlsImpl.resetOriginalValues();

		return dgfDlrUpdtTempDtlsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dgfDlrUpdateReqId = objectInput.readLong();
		nationalId = objectInput.readUTF();

		dlrRegNo = objectInput.readLong();
		maritalStatus = objectInput.readUTF();
		spouseName = objectInput.readUTF();
		spouseFthrName = objectInput.readUTF();
		spouseNid = objectInput.readUTF();
		spouseBrthDate = objectInput.readLong();

		pblcRep = objectInput.readInt();

		wrkInGovt = objectInput.readInt();

		physclyChlngd = objectInput.readInt();

		phsclyChlngdAttchId = objectInput.readLong();

		shpDivision = objectInput.readLong();

		shpDistrict = objectInput.readLong();

		shpUpzilla = objectInput.readLong();

		shpUnion = objectInput.readLong();
		shpVillage = objectInput.readUTF();
		shpWard = objectInput.readUTF();
		shpZipCode = objectInput.readUTF();
		shpPstOffc = objectInput.readUTF();
		shpPresentAddress = objectInput.readUTF();
		shpLocation = objectInput.readUTF();

		shpLength = objectInput.readLong();

		shpHeight = objectInput.readLong();

		shpWidth = objectInput.readLong();

		shpStrgCpcty = objectInput.readLong();

		shpFlrCmntd = objectInput.readInt();

		shpSignBrd = objectInput.readInt();
		licenseType = objectInput.readUTF();

		thrdPartyOpsFlg = objectInput.readLong();
		dlrshpFmlyMmbrName = objectInput.readUTF();
		dlrshpFmlyMmbrType = objectInput.readUTF();

		dlrPerfYr1 = objectInput.readLong();

		dlrPerfYr1AllocQty = objectInput.readLong();

		dlrPerfYr1ComdtyQty = objectInput.readLong();
		dlrPerfYr1DlrCtgry = objectInput.readUTF();
		dlrPerfYr1Rmrk = objectInput.readUTF();

		dlrPerfYr2 = objectInput.readLong();

		dlrPerfYr2AllocQty = objectInput.readLong();

		dlrPerfYr2ComdtyQty = objectInput.readLong();
		dlrPerfYr2DlrCtgry = objectInput.readUTF();
		dlrPerfYr2Rmrk = objectInput.readUTF();

		dlrPerfYr3 = objectInput.readLong();

		dlrPerfYr3AllocQty = objectInput.readLong();

		dlrPerfYr3ComdtyQty = objectInput.readLong();
		dlrPerfYr3DlrCtgry = objectInput.readUTF();
		dlrPerfYr3Rmrk = objectInput.readUTF();
		trckLicnsPlatNo = objectInput.readUTF();

		trckCpcty = objectInput.readLong();
		trckMake = objectInput.readUTF();
		trckModel = objectInput.readUTF();
		trckRentOwnFlg = objectInput.readUTF();

		trckMfgYr = objectInput.readLong();

		version = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		createDate = objectInput.readLong();

		lastUpdtdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		foodgrainLicense = objectInput.readInt();

		tradeLicense = objectInput.readInt();

		tcvDlrLicense = objectInput.readInt();

		importLicense = objectInput.readInt();

		licenseEssentialGoods = objectInput.readInt();

		tradeLicenseAgriculture = objectInput.readInt();
		dlrOmsSubType = objectInput.readUTF();

		userId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		dlrRunShpHimself = objectInput.readInt();

		dlrShpTrckTypFlg = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(dgfDlrUpdateReqId);

		if (nationalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationalId);
		}

		objectOutput.writeLong(dlrRegNo);

		if (maritalStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(maritalStatus);
		}

		if (spouseName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(spouseName);
		}

		if (spouseFthrName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(spouseFthrName);
		}

		if (spouseNid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(spouseNid);
		}

		objectOutput.writeLong(spouseBrthDate);

		objectOutput.writeInt(pblcRep);

		objectOutput.writeInt(wrkInGovt);

		objectOutput.writeInt(physclyChlngd);

		objectOutput.writeLong(phsclyChlngdAttchId);

		objectOutput.writeLong(shpDivision);

		objectOutput.writeLong(shpDistrict);

		objectOutput.writeLong(shpUpzilla);

		objectOutput.writeLong(shpUnion);

		if (shpVillage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(shpVillage);
		}

		if (shpWard == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(shpWard);
		}

		if (shpZipCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(shpZipCode);
		}

		if (shpPstOffc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(shpPstOffc);
		}

		if (shpPresentAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(shpPresentAddress);
		}

		if (shpLocation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(shpLocation);
		}

		objectOutput.writeLong(shpLength);

		objectOutput.writeLong(shpHeight);

		objectOutput.writeLong(shpWidth);

		objectOutput.writeLong(shpStrgCpcty);

		objectOutput.writeInt(shpFlrCmntd);

		objectOutput.writeInt(shpSignBrd);

		if (licenseType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(licenseType);
		}

		objectOutput.writeLong(thrdPartyOpsFlg);

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

		objectOutput.writeLong(dlrPerfYr1);

		objectOutput.writeLong(dlrPerfYr1AllocQty);

		objectOutput.writeLong(dlrPerfYr1ComdtyQty);

		if (dlrPerfYr1DlrCtgry == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dlrPerfYr1DlrCtgry);
		}

		if (dlrPerfYr1Rmrk == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dlrPerfYr1Rmrk);
		}

		objectOutput.writeLong(dlrPerfYr2);

		objectOutput.writeLong(dlrPerfYr2AllocQty);

		objectOutput.writeLong(dlrPerfYr2ComdtyQty);

		if (dlrPerfYr2DlrCtgry == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dlrPerfYr2DlrCtgry);
		}

		if (dlrPerfYr2Rmrk == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dlrPerfYr2Rmrk);
		}

		objectOutput.writeLong(dlrPerfYr3);

		objectOutput.writeLong(dlrPerfYr3AllocQty);

		objectOutput.writeLong(dlrPerfYr3ComdtyQty);

		if (dlrPerfYr3DlrCtgry == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dlrPerfYr3DlrCtgry);
		}

		if (dlrPerfYr3Rmrk == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dlrPerfYr3Rmrk);
		}

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

		objectOutput.writeLong(version);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(lastUpdtdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(foodgrainLicense);

		objectOutput.writeInt(tradeLicense);

		objectOutput.writeInt(tcvDlrLicense);

		objectOutput.writeInt(importLicense);

		objectOutput.writeInt(licenseEssentialGoods);

		objectOutput.writeInt(tradeLicenseAgriculture);

		if (dlrOmsSubType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dlrOmsSubType);
		}

		objectOutput.writeLong(userId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeInt(dlrRunShpHimself);

		objectOutput.writeInt(dlrShpTrckTypFlg);
	}

	public long dgfDlrUpdateReqId;
	public String nationalId;
	public long dlrRegNo;
	public String maritalStatus;
	public String spouseName;
	public String spouseFthrName;
	public String spouseNid;
	public long spouseBrthDate;
	public int pblcRep;
	public int wrkInGovt;
	public int physclyChlngd;
	public long phsclyChlngdAttchId;
	public long shpDivision;
	public long shpDistrict;
	public long shpUpzilla;
	public long shpUnion;
	public String shpVillage;
	public String shpWard;
	public String shpZipCode;
	public String shpPstOffc;
	public String shpPresentAddress;
	public String shpLocation;
	public long shpLength;
	public long shpHeight;
	public long shpWidth;
	public long shpStrgCpcty;
	public int shpFlrCmntd;
	public int shpSignBrd;
	public String licenseType;
	public long thrdPartyOpsFlg;
	public String dlrshpFmlyMmbrName;
	public String dlrshpFmlyMmbrType;
	public long dlrPerfYr1;
	public long dlrPerfYr1AllocQty;
	public long dlrPerfYr1ComdtyQty;
	public String dlrPerfYr1DlrCtgry;
	public String dlrPerfYr1Rmrk;
	public long dlrPerfYr2;
	public long dlrPerfYr2AllocQty;
	public long dlrPerfYr2ComdtyQty;
	public String dlrPerfYr2DlrCtgry;
	public String dlrPerfYr2Rmrk;
	public long dlrPerfYr3;
	public long dlrPerfYr3AllocQty;
	public long dlrPerfYr3ComdtyQty;
	public String dlrPerfYr3DlrCtgry;
	public String dlrPerfYr3Rmrk;
	public String trckLicnsPlatNo;
	public long trckCpcty;
	public String trckMake;
	public String trckModel;
	public String trckRentOwnFlg;
	public long trckMfgYr;
	public long version;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public long createDate;
	public long lastUpdtdBy;
	public long modifiedDate;
	public int foodgrainLicense;
	public int tradeLicense;
	public int tcvDlrLicense;
	public int importLicense;
	public int licenseEssentialGoods;
	public int tradeLicenseAgriculture;
	public String dlrOmsSubType;
	public long userId;
	public long groupId;
	public long companyId;
	public int dlrRunShpHimself;
	public int dlrShpTrckTypFlg;

}