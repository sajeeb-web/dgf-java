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

package bd.gov.dgfood.food.friendly.program.model.impl;

import bd.gov.dgfood.food.friendly.program.model.InvtoryDetails;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing InvtoryDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class InvtoryDetailsCacheModel
	implements CacheModel<InvtoryDetails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof InvtoryDetailsCacheModel)) {
			return false;
		}

		InvtoryDetailsCacheModel invtoryDetailsCacheModel =
			(InvtoryDetailsCacheModel)object;

		if (inventoryId == invtoryDetailsCacheModel.inventoryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, inventoryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{inventoryId=");
		sb.append(inventoryId);
		sb.append(", dlrRegNo=");
		sb.append(dlrRegNo);
		sb.append(", allcNtfyNo=");
		sb.append(allcNtfyNo);
		sb.append(", fromDate=");
		sb.append(fromDate);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append(", commodityId=");
		sb.append(commodityId);
		sb.append(", commodityName=");
		sb.append(commodityName);
		sb.append(", noOfIndents=");
		sb.append(noOfIndents);
		sb.append(", receivedQty=");
		sb.append(receivedQty);
		sb.append(", soldQty=");
		sb.append(soldQty);
		sb.append(", balanceQty=");
		sb.append(balanceQty);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public InvtoryDetails toEntityModel() {
		InvtoryDetailsImpl invtoryDetailsImpl = new InvtoryDetailsImpl();

		invtoryDetailsImpl.setInventoryId(inventoryId);
		invtoryDetailsImpl.setDlrRegNo(dlrRegNo);
		invtoryDetailsImpl.setAllcNtfyNo(allcNtfyNo);

		if (fromDate == Long.MIN_VALUE) {
			invtoryDetailsImpl.setFromDate(null);
		}
		else {
			invtoryDetailsImpl.setFromDate(new Date(fromDate));
		}

		if (toDate == Long.MIN_VALUE) {
			invtoryDetailsImpl.setToDate(null);
		}
		else {
			invtoryDetailsImpl.setToDate(new Date(toDate));
		}

		invtoryDetailsImpl.setCommodityId(commodityId);

		if (commodityName == null) {
			invtoryDetailsImpl.setCommodityName("");
		}
		else {
			invtoryDetailsImpl.setCommodityName(commodityName);
		}

		invtoryDetailsImpl.setNoOfIndents(noOfIndents);
		invtoryDetailsImpl.setReceivedQty(receivedQty);
		invtoryDetailsImpl.setSoldQty(soldQty);
		invtoryDetailsImpl.setBalanceQty(balanceQty);
		invtoryDetailsImpl.setCreateDate(createDate);
		invtoryDetailsImpl.setCompanyId(companyId);
		invtoryDetailsImpl.setCreatedBy(createdBy);

		invtoryDetailsImpl.resetOriginalValues();

		return invtoryDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		inventoryId = objectInput.readLong();

		dlrRegNo = objectInput.readLong();

		allcNtfyNo = objectInput.readLong();
		fromDate = objectInput.readLong();
		toDate = objectInput.readLong();

		commodityId = objectInput.readLong();
		commodityName = objectInput.readUTF();

		noOfIndents = objectInput.readLong();

		receivedQty = objectInput.readFloat();

		soldQty = objectInput.readFloat();

		balanceQty = objectInput.readFloat();

		createDate = objectInput.readLong();

		companyId = objectInput.readLong();

		createdBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(inventoryId);

		objectOutput.writeLong(dlrRegNo);

		objectOutput.writeLong(allcNtfyNo);
		objectOutput.writeLong(fromDate);
		objectOutput.writeLong(toDate);

		objectOutput.writeLong(commodityId);

		if (commodityName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(commodityName);
		}

		objectOutput.writeLong(noOfIndents);

		objectOutput.writeFloat(receivedQty);

		objectOutput.writeFloat(soldQty);

		objectOutput.writeFloat(balanceQty);

		objectOutput.writeLong(createDate);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(createdBy);
	}

	public long inventoryId;
	public long dlrRegNo;
	public long allcNtfyNo;
	public long fromDate;
	public long toDate;
	public long commodityId;
	public String commodityName;
	public long noOfIndents;
	public float receivedQty;
	public float soldQty;
	public float balanceQty;
	public long createDate;
	public long companyId;
	public long createdBy;

}