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

import bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DgfFglLicDtls in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DgfFglLicDtlsCacheModel
	implements CacheModel<DgfFglLicDtls>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DgfFglLicDtlsCacheModel)) {
			return false;
		}

		DgfFglLicDtlsCacheModel dgfFglLicDtlsCacheModel =
			(DgfFglLicDtlsCacheModel)object;

		if (fglLicPrimaryId == dgfFglLicDtlsCacheModel.fglLicPrimaryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fglLicPrimaryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{fglLicPrimaryId=");
		sb.append(fglLicPrimaryId);
		sb.append(", nationalId=");
		sb.append(nationalId);
		sb.append(", fglPrePrimaryId=");
		sb.append(fglPrePrimaryId);
		sb.append(", fglApplicationNo=");
		sb.append(fglApplicationNo);
		sb.append(", foodgrainLicenseNo=");
		sb.append(foodgrainLicenseNo);
		sb.append(", foodgrainLicenseType=");
		sb.append(foodgrainLicenseType);
		sb.append(", tradeLicenseNo=");
		sb.append(tradeLicenseNo);
		sb.append(", tradeLicenseExpiryDate=");
		sb.append(tradeLicenseExpiryDate);
		sb.append(", foodgrainLicenseIssueDate=");
		sb.append(foodgrainLicenseIssueDate);
		sb.append(", foodgrainLicenseExpiryDate=");
		sb.append(foodgrainLicenseExpiryDate);
		sb.append(", foodgrainLicenseIssuedBy=");
		sb.append(foodgrainLicenseIssuedBy);
		sb.append(", fglLicenseVersion=");
		sb.append(fglLicenseVersion);
		sb.append(", productType=");
		sb.append(productType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DgfFglLicDtls toEntityModel() {
		DgfFglLicDtlsImpl dgfFglLicDtlsImpl = new DgfFglLicDtlsImpl();

		dgfFglLicDtlsImpl.setFglLicPrimaryId(fglLicPrimaryId);

		if (nationalId == null) {
			dgfFglLicDtlsImpl.setNationalId("");
		}
		else {
			dgfFglLicDtlsImpl.setNationalId(nationalId);
		}

		dgfFglLicDtlsImpl.setFglPrePrimaryId(fglPrePrimaryId);

		if (fglApplicationNo == null) {
			dgfFglLicDtlsImpl.setFglApplicationNo("");
		}
		else {
			dgfFglLicDtlsImpl.setFglApplicationNo(fglApplicationNo);
		}

		if (foodgrainLicenseNo == null) {
			dgfFglLicDtlsImpl.setFoodgrainLicenseNo("");
		}
		else {
			dgfFglLicDtlsImpl.setFoodgrainLicenseNo(foodgrainLicenseNo);
		}

		if (foodgrainLicenseType == null) {
			dgfFglLicDtlsImpl.setFoodgrainLicenseType("");
		}
		else {
			dgfFglLicDtlsImpl.setFoodgrainLicenseType(foodgrainLicenseType);
		}

		if (tradeLicenseNo == null) {
			dgfFglLicDtlsImpl.setTradeLicenseNo("");
		}
		else {
			dgfFglLicDtlsImpl.setTradeLicenseNo(tradeLicenseNo);
		}

		if (tradeLicenseExpiryDate == Long.MIN_VALUE) {
			dgfFglLicDtlsImpl.setTradeLicenseExpiryDate(null);
		}
		else {
			dgfFglLicDtlsImpl.setTradeLicenseExpiryDate(
				new Date(tradeLicenseExpiryDate));
		}

		if (foodgrainLicenseIssueDate == Long.MIN_VALUE) {
			dgfFglLicDtlsImpl.setFoodgrainLicenseIssueDate(null);
		}
		else {
			dgfFglLicDtlsImpl.setFoodgrainLicenseIssueDate(
				new Date(foodgrainLicenseIssueDate));
		}

		if (foodgrainLicenseExpiryDate == Long.MIN_VALUE) {
			dgfFglLicDtlsImpl.setFoodgrainLicenseExpiryDate(null);
		}
		else {
			dgfFglLicDtlsImpl.setFoodgrainLicenseExpiryDate(
				new Date(foodgrainLicenseExpiryDate));
		}

		dgfFglLicDtlsImpl.setFoodgrainLicenseIssuedBy(foodgrainLicenseIssuedBy);
		dgfFglLicDtlsImpl.setFglLicenseVersion(fglLicenseVersion);

		if (productType == null) {
			dgfFglLicDtlsImpl.setProductType("");
		}
		else {
			dgfFglLicDtlsImpl.setProductType(productType);
		}

		dgfFglLicDtlsImpl.resetOriginalValues();

		return dgfFglLicDtlsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		fglLicPrimaryId = objectInput.readLong();
		nationalId = objectInput.readUTF();

		fglPrePrimaryId = objectInput.readLong();
		fglApplicationNo = objectInput.readUTF();
		foodgrainLicenseNo = objectInput.readUTF();
		foodgrainLicenseType = objectInput.readUTF();
		tradeLicenseNo = objectInput.readUTF();
		tradeLicenseExpiryDate = objectInput.readLong();
		foodgrainLicenseIssueDate = objectInput.readLong();
		foodgrainLicenseExpiryDate = objectInput.readLong();

		foodgrainLicenseIssuedBy = objectInput.readLong();

		fglLicenseVersion = objectInput.readLong();
		productType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(fglLicPrimaryId);

		if (nationalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationalId);
		}

		objectOutput.writeLong(fglPrePrimaryId);

		if (fglApplicationNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fglApplicationNo);
		}

		if (foodgrainLicenseNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(foodgrainLicenseNo);
		}

		if (foodgrainLicenseType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(foodgrainLicenseType);
		}

		if (tradeLicenseNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tradeLicenseNo);
		}

		objectOutput.writeLong(tradeLicenseExpiryDate);
		objectOutput.writeLong(foodgrainLicenseIssueDate);
		objectOutput.writeLong(foodgrainLicenseExpiryDate);

		objectOutput.writeLong(foodgrainLicenseIssuedBy);

		objectOutput.writeLong(fglLicenseVersion);

		if (productType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(productType);
		}
	}

	public long fglLicPrimaryId;
	public String nationalId;
	public long fglPrePrimaryId;
	public String fglApplicationNo;
	public String foodgrainLicenseNo;
	public String foodgrainLicenseType;
	public String tradeLicenseNo;
	public long tradeLicenseExpiryDate;
	public long foodgrainLicenseIssueDate;
	public long foodgrainLicenseExpiryDate;
	public long foodgrainLicenseIssuedBy;
	public long fglLicenseVersion;
	public String productType;

}