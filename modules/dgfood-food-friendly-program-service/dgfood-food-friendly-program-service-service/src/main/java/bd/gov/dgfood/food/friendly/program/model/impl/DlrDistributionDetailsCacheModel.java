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

import bd.gov.dgfood.food.friendly.program.model.DlrDistributionDetails;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DlrDistributionDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DlrDistributionDetailsCacheModel
	implements CacheModel<DlrDistributionDetails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DlrDistributionDetailsCacheModel)) {
			return false;
		}

		DlrDistributionDetailsCacheModel dlrDistributionDetailsCacheModel =
			(DlrDistributionDetailsCacheModel)object;

		if (dstrbnId == dlrDistributionDetailsCacheModel.dstrbnId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dstrbnId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{dstrbnId=");
		sb.append(dstrbnId);
		sb.append(", dlrRegNo=");
		sb.append(dlrRegNo);
		sb.append(", ffpRegstrId=");
		sb.append(ffpRegstrId);
		sb.append(", selLingDate=");
		sb.append(selLingDate);
		sb.append(", commodityId=");
		sb.append(commodityId);
		sb.append(", commodityName=");
		sb.append(commodityName);
		sb.append(", sellingPrice=");
		sb.append(sellingPrice);
		sb.append(", sellingQty=");
		sb.append(sellingQty);
		sb.append(", stockBfrSelling=");
		sb.append(stockBfrSelling);
		sb.append(", stockAfterSelling=");
		sb.append(stockAfterSelling);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", inventoryId=");
		sb.append(inventoryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DlrDistributionDetails toEntityModel() {
		DlrDistributionDetailsImpl dlrDistributionDetailsImpl =
			new DlrDistributionDetailsImpl();

		dlrDistributionDetailsImpl.setDstrbnId(dstrbnId);
		dlrDistributionDetailsImpl.setDlrRegNo(dlrRegNo);
		dlrDistributionDetailsImpl.setFfpRegstrId(ffpRegstrId);

		if (selLingDate == Long.MIN_VALUE) {
			dlrDistributionDetailsImpl.setSelLingDate(null);
		}
		else {
			dlrDistributionDetailsImpl.setSelLingDate(new Date(selLingDate));
		}

		dlrDistributionDetailsImpl.setCommodityId(commodityId);

		if (commodityName == null) {
			dlrDistributionDetailsImpl.setCommodityName("");
		}
		else {
			dlrDistributionDetailsImpl.setCommodityName(commodityName);
		}

		if (sellingPrice == null) {
			dlrDistributionDetailsImpl.setSellingPrice("");
		}
		else {
			dlrDistributionDetailsImpl.setSellingPrice(sellingPrice);
		}

		dlrDistributionDetailsImpl.setSellingQty(sellingQty);
		dlrDistributionDetailsImpl.setStockBfrSelling(stockBfrSelling);
		dlrDistributionDetailsImpl.setStockAfterSelling(stockAfterSelling);

		if (createDate == Long.MIN_VALUE) {
			dlrDistributionDetailsImpl.setCreateDate(null);
		}
		else {
			dlrDistributionDetailsImpl.setCreateDate(new Date(createDate));
		}

		dlrDistributionDetailsImpl.setCreatedBy(createdBy);
		dlrDistributionDetailsImpl.setCompanyId(companyId);
		dlrDistributionDetailsImpl.setInventoryId(inventoryId);

		dlrDistributionDetailsImpl.resetOriginalValues();

		return dlrDistributionDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dstrbnId = objectInput.readLong();

		dlrRegNo = objectInput.readLong();

		ffpRegstrId = objectInput.readLong();
		selLingDate = objectInput.readLong();

		commodityId = objectInput.readLong();
		commodityName = objectInput.readUTF();
		sellingPrice = objectInput.readUTF();

		sellingQty = objectInput.readLong();

		stockBfrSelling = objectInput.readLong();

		stockAfterSelling = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();

		companyId = objectInput.readLong();

		inventoryId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(dstrbnId);

		objectOutput.writeLong(dlrRegNo);

		objectOutput.writeLong(ffpRegstrId);
		objectOutput.writeLong(selLingDate);

		objectOutput.writeLong(commodityId);

		if (commodityName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(commodityName);
		}

		if (sellingPrice == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sellingPrice);
		}

		objectOutput.writeLong(sellingQty);

		objectOutput.writeLong(stockBfrSelling);

		objectOutput.writeLong(stockAfterSelling);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(inventoryId);
	}

	public long dstrbnId;
	public long dlrRegNo;
	public long ffpRegstrId;
	public long selLingDate;
	public long commodityId;
	public String commodityName;
	public String sellingPrice;
	public long sellingQty;
	public long stockBfrSelling;
	public long stockAfterSelling;
	public long createDate;
	public long createdBy;
	public long companyId;
	public long inventoryId;

}