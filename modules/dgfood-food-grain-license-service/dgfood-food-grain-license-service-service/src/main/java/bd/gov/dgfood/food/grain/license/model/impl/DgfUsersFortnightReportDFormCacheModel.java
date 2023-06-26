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

import bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportDForm;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DgfUsersFortnightReportDForm in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DgfUsersFortnightReportDFormCacheModel
	implements CacheModel<DgfUsersFortnightReportDForm>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DgfUsersFortnightReportDFormCacheModel)) {
			return false;
		}

		DgfUsersFortnightReportDFormCacheModel
			dgfUsersFortnightReportDFormCacheModel =
				(DgfUsersFortnightReportDFormCacheModel)object;

		if (reportId == dgfUsersFortnightReportDFormCacheModel.reportId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, reportId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{reportId=");
		sb.append(reportId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", usernationalId=");
		sb.append(usernationalId);
		sb.append(", licenseNo=");
		sb.append(licenseNo);
		sb.append(", screenName=");
		sb.append(screenName);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", bussinessType=");
		sb.append(bussinessType);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", product=");
		sb.append(product);
		sb.append(", initalStockOn=");
		sb.append(initalStockOn);
		sb.append(", initalStockOnUnit=");
		sb.append(initalStockOnUnit);
		sb.append(", recivedQuantity=");
		sb.append(recivedQuantity);
		sb.append(", recivedQuantityUnit=");
		sb.append(recivedQuantityUnit);
		sb.append(", sellingQuantity=");
		sb.append(sellingQuantity);
		sb.append(", sellingQuantityUnit=");
		sb.append(sellingQuantityUnit);
		sb.append(", quantityOfFinishingStock=");
		sb.append(quantityOfFinishingStock);
		sb.append(", quantityOfFinishingStockUnit=");
		sb.append(quantityOfFinishingStockUnit);
		sb.append(", comment=");
		sb.append(comment);
		sb.append(", nationalId=");
		sb.append(nationalId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DgfUsersFortnightReportDForm toEntityModel() {
		DgfUsersFortnightReportDFormImpl dgfUsersFortnightReportDFormImpl =
			new DgfUsersFortnightReportDFormImpl();

		dgfUsersFortnightReportDFormImpl.setReportId(reportId);
		dgfUsersFortnightReportDFormImpl.setUserId(userId);

		if (usernationalId == null) {
			dgfUsersFortnightReportDFormImpl.setUsernationalId("");
		}
		else {
			dgfUsersFortnightReportDFormImpl.setUsernationalId(usernationalId);
		}

		if (licenseNo == null) {
			dgfUsersFortnightReportDFormImpl.setLicenseNo("");
		}
		else {
			dgfUsersFortnightReportDFormImpl.setLicenseNo(licenseNo);
		}

		if (screenName == null) {
			dgfUsersFortnightReportDFormImpl.setScreenName("");
		}
		else {
			dgfUsersFortnightReportDFormImpl.setScreenName(screenName);
		}

		if (fullName == null) {
			dgfUsersFortnightReportDFormImpl.setFullName("");
		}
		else {
			dgfUsersFortnightReportDFormImpl.setFullName(fullName);
		}

		if (bussinessType == null) {
			dgfUsersFortnightReportDFormImpl.setBussinessType("");
		}
		else {
			dgfUsersFortnightReportDFormImpl.setBussinessType(bussinessType);
		}

		if (startDate == Long.MIN_VALUE) {
			dgfUsersFortnightReportDFormImpl.setStartDate(null);
		}
		else {
			dgfUsersFortnightReportDFormImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			dgfUsersFortnightReportDFormImpl.setEndDate(null);
		}
		else {
			dgfUsersFortnightReportDFormImpl.setEndDate(new Date(endDate));
		}

		if (product == null) {
			dgfUsersFortnightReportDFormImpl.setProduct("");
		}
		else {
			dgfUsersFortnightReportDFormImpl.setProduct(product);
		}

		dgfUsersFortnightReportDFormImpl.setInitalStockOn(initalStockOn);

		if (initalStockOnUnit == null) {
			dgfUsersFortnightReportDFormImpl.setInitalStockOnUnit("");
		}
		else {
			dgfUsersFortnightReportDFormImpl.setInitalStockOnUnit(
				initalStockOnUnit);
		}

		dgfUsersFortnightReportDFormImpl.setRecivedQuantity(recivedQuantity);

		if (recivedQuantityUnit == null) {
			dgfUsersFortnightReportDFormImpl.setRecivedQuantityUnit("");
		}
		else {
			dgfUsersFortnightReportDFormImpl.setRecivedQuantityUnit(
				recivedQuantityUnit);
		}

		dgfUsersFortnightReportDFormImpl.setSellingQuantity(sellingQuantity);

		if (sellingQuantityUnit == null) {
			dgfUsersFortnightReportDFormImpl.setSellingQuantityUnit("");
		}
		else {
			dgfUsersFortnightReportDFormImpl.setSellingQuantityUnit(
				sellingQuantityUnit);
		}

		dgfUsersFortnightReportDFormImpl.setQuantityOfFinishingStock(
			quantityOfFinishingStock);

		if (quantityOfFinishingStockUnit == null) {
			dgfUsersFortnightReportDFormImpl.setQuantityOfFinishingStockUnit(
				"");
		}
		else {
			dgfUsersFortnightReportDFormImpl.setQuantityOfFinishingStockUnit(
				quantityOfFinishingStockUnit);
		}

		if (comment == null) {
			dgfUsersFortnightReportDFormImpl.setComment("");
		}
		else {
			dgfUsersFortnightReportDFormImpl.setComment(comment);
		}

		if (nationalId == null) {
			dgfUsersFortnightReportDFormImpl.setNationalId("");
		}
		else {
			dgfUsersFortnightReportDFormImpl.setNationalId(nationalId);
		}

		dgfUsersFortnightReportDFormImpl.resetOriginalValues();

		return dgfUsersFortnightReportDFormImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		reportId = objectInput.readLong();

		userId = objectInput.readLong();
		usernationalId = objectInput.readUTF();
		licenseNo = objectInput.readUTF();
		screenName = objectInput.readUTF();
		fullName = objectInput.readUTF();
		bussinessType = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		product = objectInput.readUTF();

		initalStockOn = objectInput.readInt();
		initalStockOnUnit = objectInput.readUTF();

		recivedQuantity = objectInput.readInt();
		recivedQuantityUnit = objectInput.readUTF();

		sellingQuantity = objectInput.readInt();
		sellingQuantityUnit = objectInput.readUTF();

		quantityOfFinishingStock = objectInput.readInt();
		quantityOfFinishingStockUnit = objectInput.readUTF();
		comment = objectInput.readUTF();
		nationalId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(reportId);

		objectOutput.writeLong(userId);

		if (usernationalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(usernationalId);
		}

		if (licenseNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(licenseNo);
		}

		if (screenName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(screenName);
		}

		if (fullName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		if (bussinessType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bussinessType);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		if (product == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(product);
		}

		objectOutput.writeInt(initalStockOn);

		if (initalStockOnUnit == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(initalStockOnUnit);
		}

		objectOutput.writeInt(recivedQuantity);

		if (recivedQuantityUnit == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(recivedQuantityUnit);
		}

		objectOutput.writeInt(sellingQuantity);

		if (sellingQuantityUnit == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sellingQuantityUnit);
		}

		objectOutput.writeInt(quantityOfFinishingStock);

		if (quantityOfFinishingStockUnit == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(quantityOfFinishingStockUnit);
		}

		if (comment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(comment);
		}

		if (nationalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationalId);
		}
	}

	public long reportId;
	public long userId;
	public String usernationalId;
	public String licenseNo;
	public String screenName;
	public String fullName;
	public String bussinessType;
	public long startDate;
	public long endDate;
	public String product;
	public int initalStockOn;
	public String initalStockOnUnit;
	public int recivedQuantity;
	public String recivedQuantityUnit;
	public int sellingQuantity;
	public String sellingQuantityUnit;
	public int quantityOfFinishingStock;
	public String quantityOfFinishingStockUnit;
	public String comment;
	public String nationalId;

}