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

import bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DgfDlrRegDtls in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DgfDlrRegDtlsCacheModel
	implements CacheModel<DgfDlrRegDtls>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DgfDlrRegDtlsCacheModel)) {
			return false;
		}

		DgfDlrRegDtlsCacheModel dgfDlrRegDtlsCacheModel =
			(DgfDlrRegDtlsCacheModel)object;

		if (dlrRegNo == dgfDlrRegDtlsCacheModel.dlrRegNo) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dlrRegNo);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(91);

		sb.append("{dlrRegNo=");
		sb.append(dlrRegNo);
		sb.append(", nationalId=");
		sb.append(nationalId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", dlrRegApplNo=");
		sb.append(dlrRegApplNo);
		sb.append(", fglLicnsNo=");
		sb.append(fglLicnsNo);
		sb.append(", fglLicnsIssueDate=");
		sb.append(fglLicnsIssueDate);
		sb.append(", trdLicnsNo=");
		sb.append(trdLicnsNo);
		sb.append(", trdLicnsExpDate=");
		sb.append(trdLicnsExpDate);
		sb.append(", dlrTypeId=");
		sb.append(dlrTypeId);
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
		sb.append(", dlrRegExpiryDate=");
		sb.append(dlrRegExpiryDate);
		sb.append(", sapBuCode=");
		sb.append(sapBuCode);
		sb.append(", dlrRegApplStatus=");
		sb.append(dlrRegApplStatus);
		sb.append(", dlrRegCrtdDate=");
		sb.append(dlrRegCrtdDate);
		sb.append(", pymntTrnRefNo=");
		sb.append(pymntTrnRefNo);
		sb.append(", pymntTrnStatus=");
		sb.append(pymntTrnStatus);
		sb.append(", challanDocId=");
		sb.append(challanDocId);
		sb.append(", incmTaxAttchID=");
		sb.append(incmTaxAttchID);
		sb.append(", bnkSolvncyCertId=");
		sb.append(bnkSolvncyCertId);
		sb.append(", shpOwnshipDocuId=");
		sb.append(shpOwnshipDocuId);
		sb.append(", shpRentedDocuId=");
		sb.append(shpRentedDocuId);
		sb.append(", signatureId=");
		sb.append(signatureId);
		sb.append(", dlrApprRjctComments=");
		sb.append(dlrApprRjctComments);
		sb.append(", dlrRegApprRejRmrk=");
		sb.append(dlrRegApprRejRmrk);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", version=");
		sb.append(version);
		sb.append(", dlrRegCrtdBy=");
		sb.append(dlrRegCrtdBy);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", lastUpdtdBy=");
		sb.append(lastUpdtdBy);
		sb.append(", modifedDate=");
		sb.append(modifedDate);
		sb.append(", dlrOmsSubType=");
		sb.append(dlrOmsSubType);
		sb.append(", division=");
		sb.append(division);
		sb.append(", district=");
		sb.append(district);
		sb.append(", upzilla=");
		sb.append(upzilla);
		sb.append(", unionName=");
		sb.append(unionName);
		sb.append(", dlrBrthDate=");
		sb.append(dlrBrthDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DgfDlrRegDtls toEntityModel() {
		DgfDlrRegDtlsImpl dgfDlrRegDtlsImpl = new DgfDlrRegDtlsImpl();

		dgfDlrRegDtlsImpl.setDlrRegNo(dlrRegNo);

		if (nationalId == null) {
			dgfDlrRegDtlsImpl.setNationalId("");
		}
		else {
			dgfDlrRegDtlsImpl.setNationalId(nationalId);
		}

		dgfDlrRegDtlsImpl.setUserId(userId);
		dgfDlrRegDtlsImpl.setGroupId(groupId);
		dgfDlrRegDtlsImpl.setCompanyId(companyId);
		dgfDlrRegDtlsImpl.setDlrRegApplNo(dlrRegApplNo);

		if (fglLicnsNo == null) {
			dgfDlrRegDtlsImpl.setFglLicnsNo("");
		}
		else {
			dgfDlrRegDtlsImpl.setFglLicnsNo(fglLicnsNo);
		}

		if (fglLicnsIssueDate == Long.MIN_VALUE) {
			dgfDlrRegDtlsImpl.setFglLicnsIssueDate(null);
		}
		else {
			dgfDlrRegDtlsImpl.setFglLicnsIssueDate(new Date(fglLicnsIssueDate));
		}

		dgfDlrRegDtlsImpl.setTrdLicnsNo(trdLicnsNo);

		if (trdLicnsExpDate == Long.MIN_VALUE) {
			dgfDlrRegDtlsImpl.setTrdLicnsExpDate(null);
		}
		else {
			dgfDlrRegDtlsImpl.setTrdLicnsExpDate(new Date(trdLicnsExpDate));
		}

		if (dlrTypeId == null) {
			dgfDlrRegDtlsImpl.setDlrTypeId("");
		}
		else {
			dgfDlrRegDtlsImpl.setDlrTypeId(dlrTypeId);
		}

		if (maritalStatus == null) {
			dgfDlrRegDtlsImpl.setMaritalStatus("");
		}
		else {
			dgfDlrRegDtlsImpl.setMaritalStatus(maritalStatus);
		}

		if (spouseName == null) {
			dgfDlrRegDtlsImpl.setSpouseName("");
		}
		else {
			dgfDlrRegDtlsImpl.setSpouseName(spouseName);
		}

		if (spouseFthrName == null) {
			dgfDlrRegDtlsImpl.setSpouseFthrName("");
		}
		else {
			dgfDlrRegDtlsImpl.setSpouseFthrName(spouseFthrName);
		}

		if (spouseNid == null) {
			dgfDlrRegDtlsImpl.setSpouseNid("");
		}
		else {
			dgfDlrRegDtlsImpl.setSpouseNid(spouseNid);
		}

		if (spouseBrthDate == Long.MIN_VALUE) {
			dgfDlrRegDtlsImpl.setSpouseBrthDate(null);
		}
		else {
			dgfDlrRegDtlsImpl.setSpouseBrthDate(new Date(spouseBrthDate));
		}

		if (dlrRegExpiryDate == Long.MIN_VALUE) {
			dgfDlrRegDtlsImpl.setDlrRegExpiryDate(null);
		}
		else {
			dgfDlrRegDtlsImpl.setDlrRegExpiryDate(new Date(dlrRegExpiryDate));
		}

		if (sapBuCode == null) {
			dgfDlrRegDtlsImpl.setSapBuCode("");
		}
		else {
			dgfDlrRegDtlsImpl.setSapBuCode(sapBuCode);
		}

		if (dlrRegApplStatus == null) {
			dgfDlrRegDtlsImpl.setDlrRegApplStatus("");
		}
		else {
			dgfDlrRegDtlsImpl.setDlrRegApplStatus(dlrRegApplStatus);
		}

		if (dlrRegCrtdDate == Long.MIN_VALUE) {
			dgfDlrRegDtlsImpl.setDlrRegCrtdDate(null);
		}
		else {
			dgfDlrRegDtlsImpl.setDlrRegCrtdDate(new Date(dlrRegCrtdDate));
		}

		dgfDlrRegDtlsImpl.setPymntTrnRefNo(pymntTrnRefNo);

		if (pymntTrnStatus == null) {
			dgfDlrRegDtlsImpl.setPymntTrnStatus("");
		}
		else {
			dgfDlrRegDtlsImpl.setPymntTrnStatus(pymntTrnStatus);
		}

		dgfDlrRegDtlsImpl.setChallanDocId(challanDocId);
		dgfDlrRegDtlsImpl.setIncmTaxAttchID(incmTaxAttchID);
		dgfDlrRegDtlsImpl.setBnkSolvncyCertId(bnkSolvncyCertId);
		dgfDlrRegDtlsImpl.setShpOwnshipDocuId(shpOwnshipDocuId);
		dgfDlrRegDtlsImpl.setShpRentedDocuId(shpRentedDocuId);
		dgfDlrRegDtlsImpl.setSignatureId(signatureId);

		if (dlrApprRjctComments == null) {
			dgfDlrRegDtlsImpl.setDlrApprRjctComments("");
		}
		else {
			dgfDlrRegDtlsImpl.setDlrApprRjctComments(dlrApprRjctComments);
		}

		if (dlrRegApprRejRmrk == null) {
			dgfDlrRegDtlsImpl.setDlrRegApprRejRmrk("");
		}
		else {
			dgfDlrRegDtlsImpl.setDlrRegApprRejRmrk(dlrRegApprRejRmrk);
		}

		dgfDlrRegDtlsImpl.setStatus(status);
		dgfDlrRegDtlsImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			dgfDlrRegDtlsImpl.setStatusByUserName("");
		}
		else {
			dgfDlrRegDtlsImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			dgfDlrRegDtlsImpl.setStatusDate(null);
		}
		else {
			dgfDlrRegDtlsImpl.setStatusDate(new Date(statusDate));
		}

		dgfDlrRegDtlsImpl.setVersion(version);

		if (dlrRegCrtdBy == null) {
			dgfDlrRegDtlsImpl.setDlrRegCrtdBy("");
		}
		else {
			dgfDlrRegDtlsImpl.setDlrRegCrtdBy(dlrRegCrtdBy);
		}

		if (createDate == Long.MIN_VALUE) {
			dgfDlrRegDtlsImpl.setCreateDate(null);
		}
		else {
			dgfDlrRegDtlsImpl.setCreateDate(new Date(createDate));
		}

		dgfDlrRegDtlsImpl.setLastUpdtdBy(lastUpdtdBy);

		if (modifedDate == Long.MIN_VALUE) {
			dgfDlrRegDtlsImpl.setModifedDate(null);
		}
		else {
			dgfDlrRegDtlsImpl.setModifedDate(new Date(modifedDate));
		}

		if (dlrOmsSubType == null) {
			dgfDlrRegDtlsImpl.setDlrOmsSubType("");
		}
		else {
			dgfDlrRegDtlsImpl.setDlrOmsSubType(dlrOmsSubType);
		}

		dgfDlrRegDtlsImpl.setDivision(division);
		dgfDlrRegDtlsImpl.setDistrict(district);
		dgfDlrRegDtlsImpl.setUpzilla(upzilla);
		dgfDlrRegDtlsImpl.setUnionName(unionName);

		if (dlrBrthDate == Long.MIN_VALUE) {
			dgfDlrRegDtlsImpl.setDlrBrthDate(null);
		}
		else {
			dgfDlrRegDtlsImpl.setDlrBrthDate(new Date(dlrBrthDate));
		}

		dgfDlrRegDtlsImpl.resetOriginalValues();

		return dgfDlrRegDtlsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dlrRegNo = objectInput.readLong();
		nationalId = objectInput.readUTF();

		userId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		dlrRegApplNo = objectInput.readLong();
		fglLicnsNo = objectInput.readUTF();
		fglLicnsIssueDate = objectInput.readLong();

		trdLicnsNo = objectInput.readLong();
		trdLicnsExpDate = objectInput.readLong();
		dlrTypeId = objectInput.readUTF();
		maritalStatus = objectInput.readUTF();
		spouseName = objectInput.readUTF();
		spouseFthrName = objectInput.readUTF();
		spouseNid = objectInput.readUTF();
		spouseBrthDate = objectInput.readLong();
		dlrRegExpiryDate = objectInput.readLong();
		sapBuCode = objectInput.readUTF();
		dlrRegApplStatus = objectInput.readUTF();
		dlrRegCrtdDate = objectInput.readLong();

		pymntTrnRefNo = objectInput.readLong();
		pymntTrnStatus = objectInput.readUTF();

		challanDocId = objectInput.readLong();

		incmTaxAttchID = objectInput.readLong();

		bnkSolvncyCertId = objectInput.readLong();

		shpOwnshipDocuId = objectInput.readLong();

		shpRentedDocuId = objectInput.readLong();

		signatureId = objectInput.readLong();
		dlrApprRjctComments = objectInput.readUTF();
		dlrRegApprRejRmrk = objectInput.readUTF();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();

		version = objectInput.readLong();
		dlrRegCrtdBy = objectInput.readUTF();
		createDate = objectInput.readLong();

		lastUpdtdBy = objectInput.readLong();
		modifedDate = objectInput.readLong();
		dlrOmsSubType = objectInput.readUTF();

		division = objectInput.readLong();

		district = objectInput.readLong();

		upzilla = objectInput.readLong();

		unionName = objectInput.readLong();
		dlrBrthDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(dlrRegNo);

		if (nationalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationalId);
		}

		objectOutput.writeLong(userId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(dlrRegApplNo);

		if (fglLicnsNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fglLicnsNo);
		}

		objectOutput.writeLong(fglLicnsIssueDate);

		objectOutput.writeLong(trdLicnsNo);
		objectOutput.writeLong(trdLicnsExpDate);

		if (dlrTypeId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dlrTypeId);
		}

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
		objectOutput.writeLong(dlrRegExpiryDate);

		if (sapBuCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sapBuCode);
		}

		if (dlrRegApplStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dlrRegApplStatus);
		}

		objectOutput.writeLong(dlrRegCrtdDate);

		objectOutput.writeLong(pymntTrnRefNo);

		if (pymntTrnStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pymntTrnStatus);
		}

		objectOutput.writeLong(challanDocId);

		objectOutput.writeLong(incmTaxAttchID);

		objectOutput.writeLong(bnkSolvncyCertId);

		objectOutput.writeLong(shpOwnshipDocuId);

		objectOutput.writeLong(shpRentedDocuId);

		objectOutput.writeLong(signatureId);

		if (dlrApprRjctComments == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dlrApprRjctComments);
		}

		if (dlrRegApprRejRmrk == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dlrRegApprRejRmrk);
		}

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		objectOutput.writeLong(version);

		if (dlrRegCrtdBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dlrRegCrtdBy);
		}

		objectOutput.writeLong(createDate);

		objectOutput.writeLong(lastUpdtdBy);
		objectOutput.writeLong(modifedDate);

		if (dlrOmsSubType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dlrOmsSubType);
		}

		objectOutput.writeLong(division);

		objectOutput.writeLong(district);

		objectOutput.writeLong(upzilla);

		objectOutput.writeLong(unionName);
		objectOutput.writeLong(dlrBrthDate);
	}

	public long dlrRegNo;
	public String nationalId;
	public long userId;
	public long groupId;
	public long companyId;
	public long dlrRegApplNo;
	public String fglLicnsNo;
	public long fglLicnsIssueDate;
	public long trdLicnsNo;
	public long trdLicnsExpDate;
	public String dlrTypeId;
	public String maritalStatus;
	public String spouseName;
	public String spouseFthrName;
	public String spouseNid;
	public long spouseBrthDate;
	public long dlrRegExpiryDate;
	public String sapBuCode;
	public String dlrRegApplStatus;
	public long dlrRegCrtdDate;
	public long pymntTrnRefNo;
	public String pymntTrnStatus;
	public long challanDocId;
	public long incmTaxAttchID;
	public long bnkSolvncyCertId;
	public long shpOwnshipDocuId;
	public long shpRentedDocuId;
	public long signatureId;
	public String dlrApprRjctComments;
	public String dlrRegApprRejRmrk;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public long version;
	public String dlrRegCrtdBy;
	public long createDate;
	public long lastUpdtdBy;
	public long modifedDate;
	public String dlrOmsSubType;
	public long division;
	public long district;
	public long upzilla;
	public long unionName;
	public long dlrBrthDate;

}