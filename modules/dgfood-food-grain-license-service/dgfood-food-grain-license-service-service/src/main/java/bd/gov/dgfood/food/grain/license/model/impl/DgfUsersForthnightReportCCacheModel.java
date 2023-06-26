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

import bd.gov.dgfood.food.grain.license.model.DgfUsersForthnightReportC;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DgfUsersForthnightReportC in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DgfUsersForthnightReportCCacheModel
	implements CacheModel<DgfUsersForthnightReportC>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DgfUsersForthnightReportCCacheModel)) {
			return false;
		}

		DgfUsersForthnightReportCCacheModel
			dgfUsersForthnightReportCCacheModel =
				(DgfUsersForthnightReportCCacheModel)object;

		if (reportId == dgfUsersForthnightReportCCacheModel.reportId) {
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
		StringBundler sb = new StringBundler(33);

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
		sb.append(", daterecipt=");
		sb.append(daterecipt);
		sb.append(", receivedQuantity=");
		sb.append(receivedQuantity);
		sb.append(", receivedQuantityUnit=");
		sb.append(receivedQuantityUnit);
		sb.append(", lastDateApprove=");
		sb.append(lastDateApprove);
		sb.append(", unsoldQuantity=");
		sb.append(unsoldQuantity);
		sb.append(", unsolddunit=");
		sb.append(unsolddunit);
		sb.append(", reasonForBeingUnsold=");
		sb.append(reasonForBeingUnsold);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DgfUsersForthnightReportC toEntityModel() {
		DgfUsersForthnightReportCImpl dgfUsersForthnightReportCImpl =
			new DgfUsersForthnightReportCImpl();

		dgfUsersForthnightReportCImpl.setReportId(reportId);
		dgfUsersForthnightReportCImpl.setUserId(userId);

		if (usernationalId == null) {
			dgfUsersForthnightReportCImpl.setUsernationalId("");
		}
		else {
			dgfUsersForthnightReportCImpl.setUsernationalId(usernationalId);
		}

		if (screenName == null) {
			dgfUsersForthnightReportCImpl.setScreenName("");
		}
		else {
			dgfUsersForthnightReportCImpl.setScreenName(screenName);
		}

		if (fullName == null) {
			dgfUsersForthnightReportCImpl.setFullName("");
		}
		else {
			dgfUsersForthnightReportCImpl.setFullName(fullName);
		}

		if (productType == null) {
			dgfUsersForthnightReportCImpl.setProductType("");
		}
		else {
			dgfUsersForthnightReportCImpl.setProductType(productType);
		}

		if (startDate == Long.MIN_VALUE) {
			dgfUsersForthnightReportCImpl.setStartDate(null);
		}
		else {
			dgfUsersForthnightReportCImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			dgfUsersForthnightReportCImpl.setEndDate(null);
		}
		else {
			dgfUsersForthnightReportCImpl.setEndDate(new Date(endDate));
		}

		if (product == null) {
			dgfUsersForthnightReportCImpl.setProduct("");
		}
		else {
			dgfUsersForthnightReportCImpl.setProduct(product);
		}

		if (daterecipt == Long.MIN_VALUE) {
			dgfUsersForthnightReportCImpl.setDaterecipt(null);
		}
		else {
			dgfUsersForthnightReportCImpl.setDaterecipt(new Date(daterecipt));
		}

		dgfUsersForthnightReportCImpl.setReceivedQuantity(receivedQuantity);

		if (receivedQuantityUnit == null) {
			dgfUsersForthnightReportCImpl.setReceivedQuantityUnit("");
		}
		else {
			dgfUsersForthnightReportCImpl.setReceivedQuantityUnit(
				receivedQuantityUnit);
		}

		if (lastDateApprove == Long.MIN_VALUE) {
			dgfUsersForthnightReportCImpl.setLastDateApprove(null);
		}
		else {
			dgfUsersForthnightReportCImpl.setLastDateApprove(
				new Date(lastDateApprove));
		}

		dgfUsersForthnightReportCImpl.setUnsoldQuantity(unsoldQuantity);

		if (unsolddunit == null) {
			dgfUsersForthnightReportCImpl.setUnsolddunit("");
		}
		else {
			dgfUsersForthnightReportCImpl.setUnsolddunit(unsolddunit);
		}

		if (reasonForBeingUnsold == null) {
			dgfUsersForthnightReportCImpl.setReasonForBeingUnsold("");
		}
		else {
			dgfUsersForthnightReportCImpl.setReasonForBeingUnsold(
				reasonForBeingUnsold);
		}

		dgfUsersForthnightReportCImpl.resetOriginalValues();

		return dgfUsersForthnightReportCImpl;
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
		daterecipt = objectInput.readLong();

		receivedQuantity = objectInput.readInt();
		receivedQuantityUnit = objectInput.readUTF();
		lastDateApprove = objectInput.readLong();

		unsoldQuantity = objectInput.readInt();
		unsolddunit = objectInput.readUTF();
		reasonForBeingUnsold = objectInput.readUTF();
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

		objectOutput.writeLong(daterecipt);

		objectOutput.writeInt(receivedQuantity);

		if (receivedQuantityUnit == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(receivedQuantityUnit);
		}

		objectOutput.writeLong(lastDateApprove);

		objectOutput.writeInt(unsoldQuantity);

		if (unsolddunit == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(unsolddunit);
		}

		if (reasonForBeingUnsold == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reasonForBeingUnsold);
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
	public long daterecipt;
	public int receivedQuantity;
	public String receivedQuantityUnit;
	public long lastDateApprove;
	public int unsoldQuantity;
	public String unsolddunit;
	public String reasonForBeingUnsold;

}