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

import bd.gov.dgfood.food.grain.license.model.DgfUsersForthnightReportD;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DgfUsersForthnightReportD in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DgfUsersForthnightReportDCacheModel
	implements CacheModel<DgfUsersForthnightReportD>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DgfUsersForthnightReportDCacheModel)) {
			return false;
		}

		DgfUsersForthnightReportDCacheModel
			dgfUsersForthnightReportDCacheModel =
				(DgfUsersForthnightReportDCacheModel)object;

		if (reportId == dgfUsersForthnightReportDCacheModel.reportId) {
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
		StringBundler sb = new StringBundler(39);

		sb.append("{reportId=");
		sb.append(reportId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", usernationalId=");
		sb.append(usernationalId);
		sb.append(", screenName=");
		sb.append(screenName);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", productType=");
		sb.append(productType);
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
	public DgfUsersForthnightReportD toEntityModel() {
		DgfUsersForthnightReportDImpl dgfUsersForthnightReportDImpl =
			new DgfUsersForthnightReportDImpl();

		dgfUsersForthnightReportDImpl.setReportId(reportId);
		dgfUsersForthnightReportDImpl.setUserId(userId);

		if (usernationalId == null) {
			dgfUsersForthnightReportDImpl.setUsernationalId("");
		}
		else {
			dgfUsersForthnightReportDImpl.setUsernationalId(usernationalId);
		}

		if (screenName == null) {
			dgfUsersForthnightReportDImpl.setScreenName("");
		}
		else {
			dgfUsersForthnightReportDImpl.setScreenName(screenName);
		}

		if (fullName == null) {
			dgfUsersForthnightReportDImpl.setFullName("");
		}
		else {
			dgfUsersForthnightReportDImpl.setFullName(fullName);
		}

		if (productType == null) {
			dgfUsersForthnightReportDImpl.setProductType("");
		}
		else {
			dgfUsersForthnightReportDImpl.setProductType(productType);
		}

		if (startDate == Long.MIN_VALUE) {
			dgfUsersForthnightReportDImpl.setStartDate(null);
		}
		else {
			dgfUsersForthnightReportDImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			dgfUsersForthnightReportDImpl.setEndDate(null);
		}
		else {
			dgfUsersForthnightReportDImpl.setEndDate(new Date(endDate));
		}

		if (product == null) {
			dgfUsersForthnightReportDImpl.setProduct("");
		}
		else {
			dgfUsersForthnightReportDImpl.setProduct(product);
		}

		dgfUsersForthnightReportDImpl.setInitalStockOn(initalStockOn);

		if (initalStockOnUnit == null) {
			dgfUsersForthnightReportDImpl.setInitalStockOnUnit("");
		}
		else {
			dgfUsersForthnightReportDImpl.setInitalStockOnUnit(
				initalStockOnUnit);
		}

		dgfUsersForthnightReportDImpl.setRecivedQuantity(recivedQuantity);

		if (recivedQuantityUnit == null) {
			dgfUsersForthnightReportDImpl.setRecivedQuantityUnit("");
		}
		else {
			dgfUsersForthnightReportDImpl.setRecivedQuantityUnit(
				recivedQuantityUnit);
		}

		dgfUsersForthnightReportDImpl.setSellingQuantity(sellingQuantity);

		if (sellingQuantityUnit == null) {
			dgfUsersForthnightReportDImpl.setSellingQuantityUnit("");
		}
		else {
			dgfUsersForthnightReportDImpl.setSellingQuantityUnit(
				sellingQuantityUnit);
		}

		dgfUsersForthnightReportDImpl.setQuantityOfFinishingStock(
			quantityOfFinishingStock);

		if (quantityOfFinishingStockUnit == null) {
			dgfUsersForthnightReportDImpl.setQuantityOfFinishingStockUnit("");
		}
		else {
			dgfUsersForthnightReportDImpl.setQuantityOfFinishingStockUnit(
				quantityOfFinishingStockUnit);
		}

		if (comment == null) {
			dgfUsersForthnightReportDImpl.setComment("");
		}
		else {
			dgfUsersForthnightReportDImpl.setComment(comment);
		}

		if (nationalId == null) {
			dgfUsersForthnightReportDImpl.setNationalId("");
		}
		else {
			dgfUsersForthnightReportDImpl.setNationalId(nationalId);
		}

		dgfUsersForthnightReportDImpl.resetOriginalValues();

		return dgfUsersForthnightReportDImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		reportId = objectInput.readLong();

		userId = objectInput.readLong();
		usernationalId = objectInput.readUTF();
		screenName = objectInput.readUTF();
		fullName = objectInput.readUTF();
		productType = objectInput.readUTF();
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

		if (productType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(productType);
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
	public String screenName;
	public String fullName;
	public String productType;
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