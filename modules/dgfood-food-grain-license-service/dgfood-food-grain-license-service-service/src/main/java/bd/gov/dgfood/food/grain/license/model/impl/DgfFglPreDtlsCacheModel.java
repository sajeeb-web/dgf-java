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

package bd.gov.dgfood.food.grain.license.model.impl;

import bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DgfFglPreDtls in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DgfFglPreDtlsCacheModel
	implements CacheModel<DgfFglPreDtls>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DgfFglPreDtlsCacheModel)) {
			return false;
		}

		DgfFglPreDtlsCacheModel dgfFglPreDtlsCacheModel =
			(DgfFglPreDtlsCacheModel)object;

		if (fglPrePrimaryId == dgfFglPreDtlsCacheModel.fglPrePrimaryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fglPrePrimaryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(95);

		sb.append("{fglPrePrimaryId=");
		sb.append(fglPrePrimaryId);
		sb.append(", nationalId=");
		sb.append(nationalId);
		sb.append(", fglApplicationNo=");
		sb.append(fglApplicationNo);
		sb.append(", applicantName=");
		sb.append(applicantName);
		sb.append(", tradeLicenseNo=");
		sb.append(tradeLicenseNo);
		sb.append(", tradeLicenseExpiryDate=");
		sb.append(tradeLicenseExpiryDate);
		sb.append(", tradeLicenseIssuerCode=");
		sb.append(tradeLicenseIssuerCode);
		sb.append(", tradeLicenseIssuerCity=");
		sb.append(tradeLicenseIssuerCity);
		sb.append(", businessIdentificationNo=");
		sb.append(businessIdentificationNo);
		sb.append(", taxIdentificationNo=");
		sb.append(taxIdentificationNo);
		sb.append(", businessName=");
		sb.append(businessName);
		sb.append(", businessType=");
		sb.append(businessType);
		sb.append(", paymentChallanId=");
		sb.append(paymentChallanId);
		sb.append(", paymentStatus=");
		sb.append(paymentStatus);
		sb.append(", reviewComments=");
		sb.append(reviewComments);
		sb.append(", applicationStatus=");
		sb.append(applicationStatus);
		sb.append(", applicationStatusDate=");
		sb.append(applicationStatusDate);
		sb.append(", duplicateLicenseReasonId=");
		sb.append(duplicateLicenseReasonId);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", fglLicenseVersion=");
		sb.append(fglLicenseVersion);
		sb.append(", foodGrainLicenseType=");
		sb.append(foodGrainLicenseType);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", applicationStatusById=");
		sb.append(applicationStatusById);
		sb.append(", presentAddrId=");
		sb.append(presentAddrId);
		sb.append(", bussinessAddrId=");
		sb.append(bussinessAddrId);
		sb.append(", tradeLicenseDocId=");
		sb.append(tradeLicenseDocId);
		sb.append(", bussIdentfctDocId=");
		sb.append(bussIdentfctDocId);
		sb.append(", taxIdentfctDocId=");
		sb.append(taxIdentfctDocId);
		sb.append(", bnkStatmtDocId=");
		sb.append(bnkStatmtDocId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", birthDate=");
		sb.append(birthDate);
		sb.append(", fglApplicationType=");
		sb.append(fglApplicationType);
		sb.append(", photographDocId=");
		sb.append(photographDocId);
		sb.append(", otherReleventDocId=");
		sb.append(otherReleventDocId);
		sb.append(", electricExemptionMemoId=");
		sb.append(electricExemptionMemoId);
		sb.append(", envClrMemoId=");
		sb.append(envClrMemoId);
		sb.append(", bstiClrMemoId=");
		sb.append(bstiClrMemoId);
		sb.append(", fireLicNumDocId=");
		sb.append(fireLicNumDocId);
		sb.append(", productType=");
		sb.append(productType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DgfFglPreDtls toEntityModel() {
		DgfFglPreDtlsImpl dgfFglPreDtlsImpl = new DgfFglPreDtlsImpl();

		dgfFglPreDtlsImpl.setFglPrePrimaryId(fglPrePrimaryId);
		dgfFglPreDtlsImpl.setNationalId(nationalId);

		if (fglApplicationNo == null) {
			dgfFglPreDtlsImpl.setFglApplicationNo("");
		}
		else {
			dgfFglPreDtlsImpl.setFglApplicationNo(fglApplicationNo);
		}

		if (applicantName == null) {
			dgfFglPreDtlsImpl.setApplicantName("");
		}
		else {
			dgfFglPreDtlsImpl.setApplicantName(applicantName);
		}

		if (tradeLicenseNo == null) {
			dgfFglPreDtlsImpl.setTradeLicenseNo("");
		}
		else {
			dgfFglPreDtlsImpl.setTradeLicenseNo(tradeLicenseNo);
		}

		if (tradeLicenseExpiryDate == Long.MIN_VALUE) {
			dgfFglPreDtlsImpl.setTradeLicenseExpiryDate(null);
		}
		else {
			dgfFglPreDtlsImpl.setTradeLicenseExpiryDate(
				new Date(tradeLicenseExpiryDate));
		}

		if (tradeLicenseIssuerCode == null) {
			dgfFglPreDtlsImpl.setTradeLicenseIssuerCode("");
		}
		else {
			dgfFglPreDtlsImpl.setTradeLicenseIssuerCode(tradeLicenseIssuerCode);
		}

		if (tradeLicenseIssuerCity == null) {
			dgfFglPreDtlsImpl.setTradeLicenseIssuerCity("");
		}
		else {
			dgfFglPreDtlsImpl.setTradeLicenseIssuerCity(tradeLicenseIssuerCity);
		}

		if (businessIdentificationNo == null) {
			dgfFglPreDtlsImpl.setBusinessIdentificationNo("");
		}
		else {
			dgfFglPreDtlsImpl.setBusinessIdentificationNo(
				businessIdentificationNo);
		}

		if (taxIdentificationNo == null) {
			dgfFglPreDtlsImpl.setTaxIdentificationNo("");
		}
		else {
			dgfFglPreDtlsImpl.setTaxIdentificationNo(taxIdentificationNo);
		}

		if (businessName == null) {
			dgfFglPreDtlsImpl.setBusinessName("");
		}
		else {
			dgfFglPreDtlsImpl.setBusinessName(businessName);
		}

		if (businessType == null) {
			dgfFglPreDtlsImpl.setBusinessType("");
		}
		else {
			dgfFglPreDtlsImpl.setBusinessType(businessType);
		}

		dgfFglPreDtlsImpl.setPaymentChallanId(paymentChallanId);
		dgfFglPreDtlsImpl.setPaymentStatus(paymentStatus);

		if (reviewComments == null) {
			dgfFglPreDtlsImpl.setReviewComments("");
		}
		else {
			dgfFglPreDtlsImpl.setReviewComments(reviewComments);
		}

		dgfFglPreDtlsImpl.setApplicationStatus(applicationStatus);

		if (applicationStatusDate == Long.MIN_VALUE) {
			dgfFglPreDtlsImpl.setApplicationStatusDate(null);
		}
		else {
			dgfFglPreDtlsImpl.setApplicationStatusDate(
				new Date(applicationStatusDate));
		}

		dgfFglPreDtlsImpl.setDuplicateLicenseReasonId(duplicateLicenseReasonId);

		if (comments == null) {
			dgfFglPreDtlsImpl.setComments("");
		}
		else {
			dgfFglPreDtlsImpl.setComments(comments);
		}

		dgfFglPreDtlsImpl.setFglLicenseVersion(fglLicenseVersion);

		if (foodGrainLicenseType == null) {
			dgfFglPreDtlsImpl.setFoodGrainLicenseType("");
		}
		else {
			dgfFglPreDtlsImpl.setFoodGrainLicenseType(foodGrainLicenseType);
		}

		dgfFglPreDtlsImpl.setGroupId(groupId);
		dgfFglPreDtlsImpl.setCompanyId(companyId);

		if (createdDate == Long.MIN_VALUE) {
			dgfFglPreDtlsImpl.setCreatedDate(null);
		}
		else {
			dgfFglPreDtlsImpl.setCreatedDate(new Date(createdDate));
		}

		dgfFglPreDtlsImpl.setModifiedBy(modifiedBy);

		if (modifiedDate == Long.MIN_VALUE) {
			dgfFglPreDtlsImpl.setModifiedDate(null);
		}
		else {
			dgfFglPreDtlsImpl.setModifiedDate(new Date(modifiedDate));
		}

		dgfFglPreDtlsImpl.setApplicationStatusById(applicationStatusById);
		dgfFglPreDtlsImpl.setPresentAddrId(presentAddrId);
		dgfFglPreDtlsImpl.setBussinessAddrId(bussinessAddrId);
		dgfFglPreDtlsImpl.setTradeLicenseDocId(tradeLicenseDocId);
		dgfFglPreDtlsImpl.setBussIdentfctDocId(bussIdentfctDocId);
		dgfFglPreDtlsImpl.setTaxIdentfctDocId(taxIdentfctDocId);
		dgfFglPreDtlsImpl.setBnkStatmtDocId(bnkStatmtDocId);
		dgfFglPreDtlsImpl.setStatus(status);
		dgfFglPreDtlsImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			dgfFglPreDtlsImpl.setStatusByUserName("");
		}
		else {
			dgfFglPreDtlsImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			dgfFglPreDtlsImpl.setStatusDate(null);
		}
		else {
			dgfFglPreDtlsImpl.setStatusDate(new Date(statusDate));
		}

		dgfFglPreDtlsImpl.setUserId(userId);

		if (birthDate == Long.MIN_VALUE) {
			dgfFglPreDtlsImpl.setBirthDate(null);
		}
		else {
			dgfFglPreDtlsImpl.setBirthDate(new Date(birthDate));
		}

		if (fglApplicationType == null) {
			dgfFglPreDtlsImpl.setFglApplicationType("");
		}
		else {
			dgfFglPreDtlsImpl.setFglApplicationType(fglApplicationType);
		}

		dgfFglPreDtlsImpl.setPhotographDocId(photographDocId);
		dgfFglPreDtlsImpl.setOtherReleventDocId(otherReleventDocId);
		dgfFglPreDtlsImpl.setElectricExemptionMemoId(electricExemptionMemoId);
		dgfFglPreDtlsImpl.setEnvClrMemoId(envClrMemoId);
		dgfFglPreDtlsImpl.setBstiClrMemoId(bstiClrMemoId);
		dgfFglPreDtlsImpl.setFireLicNumDocId(fireLicNumDocId);

		if (productType == null) {
			dgfFglPreDtlsImpl.setProductType("");
		}
		else {
			dgfFglPreDtlsImpl.setProductType(productType);
		}

		dgfFglPreDtlsImpl.resetOriginalValues();

		return dgfFglPreDtlsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		fglPrePrimaryId = objectInput.readLong();

		nationalId = objectInput.readLong();
		fglApplicationNo = objectInput.readUTF();
		applicantName = objectInput.readUTF();
		tradeLicenseNo = objectInput.readUTF();
		tradeLicenseExpiryDate = objectInput.readLong();
		tradeLicenseIssuerCode = objectInput.readUTF();
		tradeLicenseIssuerCity = objectInput.readUTF();
		businessIdentificationNo = objectInput.readUTF();
		taxIdentificationNo = objectInput.readUTF();
		businessName = objectInput.readUTF();
		businessType = objectInput.readUTF();

		paymentChallanId = objectInput.readLong();

		paymentStatus = objectInput.readLong();
		reviewComments = objectInput.readUTF();

		applicationStatus = objectInput.readLong();
		applicationStatusDate = objectInput.readLong();

		duplicateLicenseReasonId = objectInput.readLong();
		comments = objectInput.readUTF();

		fglLicenseVersion = objectInput.readLong();
		foodGrainLicenseType = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createdDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		applicationStatusById = objectInput.readLong();

		presentAddrId = objectInput.readLong();

		bussinessAddrId = objectInput.readLong();

		tradeLicenseDocId = objectInput.readLong();

		bussIdentfctDocId = objectInput.readLong();

		taxIdentfctDocId = objectInput.readLong();

		bnkStatmtDocId = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();

		userId = objectInput.readLong();
		birthDate = objectInput.readLong();
		fglApplicationType = objectInput.readUTF();

		photographDocId = objectInput.readLong();

		otherReleventDocId = objectInput.readLong();

		electricExemptionMemoId = objectInput.readLong();

		envClrMemoId = objectInput.readLong();

		bstiClrMemoId = objectInput.readLong();

		fireLicNumDocId = objectInput.readLong();
		productType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(fglPrePrimaryId);

		objectOutput.writeLong(nationalId);

		if (fglApplicationNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fglApplicationNo);
		}

		if (applicantName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(applicantName);
		}

		if (tradeLicenseNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tradeLicenseNo);
		}

		objectOutput.writeLong(tradeLicenseExpiryDate);

		if (tradeLicenseIssuerCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tradeLicenseIssuerCode);
		}

		if (tradeLicenseIssuerCity == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tradeLicenseIssuerCity);
		}

		if (businessIdentificationNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(businessIdentificationNo);
		}

		if (taxIdentificationNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(taxIdentificationNo);
		}

		if (businessName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(businessName);
		}

		if (businessType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(businessType);
		}

		objectOutput.writeLong(paymentChallanId);

		objectOutput.writeLong(paymentStatus);

		if (reviewComments == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reviewComments);
		}

		objectOutput.writeLong(applicationStatus);
		objectOutput.writeLong(applicationStatusDate);

		objectOutput.writeLong(duplicateLicenseReasonId);

		if (comments == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(comments);
		}

		objectOutput.writeLong(fglLicenseVersion);

		if (foodGrainLicenseType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(foodGrainLicenseType);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createdDate);

		objectOutput.writeLong(modifiedBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(applicationStatusById);

		objectOutput.writeLong(presentAddrId);

		objectOutput.writeLong(bussinessAddrId);

		objectOutput.writeLong(tradeLicenseDocId);

		objectOutput.writeLong(bussIdentfctDocId);

		objectOutput.writeLong(taxIdentfctDocId);

		objectOutput.writeLong(bnkStatmtDocId);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(birthDate);

		if (fglApplicationType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fglApplicationType);
		}

		objectOutput.writeLong(photographDocId);

		objectOutput.writeLong(otherReleventDocId);

		objectOutput.writeLong(electricExemptionMemoId);

		objectOutput.writeLong(envClrMemoId);

		objectOutput.writeLong(bstiClrMemoId);

		objectOutput.writeLong(fireLicNumDocId);

		if (productType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(productType);
		}
	}

	public long fglPrePrimaryId;
	public long nationalId;
	public String fglApplicationNo;
	public String applicantName;
	public String tradeLicenseNo;
	public long tradeLicenseExpiryDate;
	public String tradeLicenseIssuerCode;
	public String tradeLicenseIssuerCity;
	public String businessIdentificationNo;
	public String taxIdentificationNo;
	public String businessName;
	public String businessType;
	public long paymentChallanId;
	public long paymentStatus;
	public String reviewComments;
	public long applicationStatus;
	public long applicationStatusDate;
	public long duplicateLicenseReasonId;
	public String comments;
	public long fglLicenseVersion;
	public String foodGrainLicenseType;
	public long groupId;
	public long companyId;
	public long createdDate;
	public long modifiedBy;
	public long modifiedDate;
	public long applicationStatusById;
	public long presentAddrId;
	public long bussinessAddrId;
	public long tradeLicenseDocId;
	public long bussIdentfctDocId;
	public long taxIdentfctDocId;
	public long bnkStatmtDocId;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public long userId;
	public long birthDate;
	public String fglApplicationType;
	public long photographDocId;
	public long otherReleventDocId;
	public long electricExemptionMemoId;
	public long envClrMemoId;
	public long bstiClrMemoId;
	public long fireLicNumDocId;
	public String productType;

}