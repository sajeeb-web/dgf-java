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

import bd.gov.dgfood.food.friendly.program.model.DlrFfpOmsAllcNtfyDetails;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DlrFfpOmsAllcNtfyDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DlrFfpOmsAllcNtfyDetailsCacheModel
	implements CacheModel<DlrFfpOmsAllcNtfyDetails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DlrFfpOmsAllcNtfyDetailsCacheModel)) {
			return false;
		}

		DlrFfpOmsAllcNtfyDetailsCacheModel dlrFfpOmsAllcNtfyDetailsCacheModel =
			(DlrFfpOmsAllcNtfyDetailsCacheModel)object;

		if (allocNtfyId.equals(
				dlrFfpOmsAllcNtfyDetailsCacheModel.allocNtfyId)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, allocNtfyId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{allocNtfyId=");
		sb.append(allocNtfyId);
		sb.append(", prgrmType=");
		sb.append(prgrmType);
		sb.append(", salesOrgName=");
		sb.append(salesOrgName);
		sb.append(", dstrbtnChnnl=");
		sb.append(dstrbtnChnnl);
		sb.append(", year=");
		sb.append(year);
		sb.append(", salesOffice=");
		sb.append(salesOffice);
		sb.append(", memoNo=");
		sb.append(memoNo);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", duration=");
		sb.append(duration);
		sb.append(", commodityId=");
		sb.append(commodityId);
		sb.append(", commodityName=");
		sb.append(commodityName);
		sb.append(", econmcPrice=");
		sb.append(econmcPrice);
		sb.append(", salePrceToEndCstmr=");
		sb.append(salePrceToEndCstmr);
		sb.append(", unitPrice=");
		sb.append(unitPrice);
		sb.append(", maxAlltmntPDay=");
		sb.append(maxAlltmntPDay);
		sb.append(", maxSellQtyPCstmr=");
		sb.append(maxSellQtyPCstmr);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DlrFfpOmsAllcNtfyDetails toEntityModel() {
		DlrFfpOmsAllcNtfyDetailsImpl dlrFfpOmsAllcNtfyDetailsImpl =
			new DlrFfpOmsAllcNtfyDetailsImpl();

		if (allocNtfyId == null) {
			dlrFfpOmsAllcNtfyDetailsImpl.setAllocNtfyId("");
		}
		else {
			dlrFfpOmsAllcNtfyDetailsImpl.setAllocNtfyId(allocNtfyId);
		}

		if (prgrmType == null) {
			dlrFfpOmsAllcNtfyDetailsImpl.setPrgrmType("");
		}
		else {
			dlrFfpOmsAllcNtfyDetailsImpl.setPrgrmType(prgrmType);
		}

		if (salesOrgName == null) {
			dlrFfpOmsAllcNtfyDetailsImpl.setSalesOrgName("");
		}
		else {
			dlrFfpOmsAllcNtfyDetailsImpl.setSalesOrgName(salesOrgName);
		}

		if (dstrbtnChnnl == null) {
			dlrFfpOmsAllcNtfyDetailsImpl.setDstrbtnChnnl("");
		}
		else {
			dlrFfpOmsAllcNtfyDetailsImpl.setDstrbtnChnnl(dstrbtnChnnl);
		}

		dlrFfpOmsAllcNtfyDetailsImpl.setYear(year);

		if (salesOffice == null) {
			dlrFfpOmsAllcNtfyDetailsImpl.setSalesOffice("");
		}
		else {
			dlrFfpOmsAllcNtfyDetailsImpl.setSalesOffice(salesOffice);
		}

		if (memoNo == null) {
			dlrFfpOmsAllcNtfyDetailsImpl.setMemoNo("");
		}
		else {
			dlrFfpOmsAllcNtfyDetailsImpl.setMemoNo(memoNo);
		}

		if (startDate == Long.MIN_VALUE) {
			dlrFfpOmsAllcNtfyDetailsImpl.setStartDate(null);
		}
		else {
			dlrFfpOmsAllcNtfyDetailsImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			dlrFfpOmsAllcNtfyDetailsImpl.setEndDate(null);
		}
		else {
			dlrFfpOmsAllcNtfyDetailsImpl.setEndDate(new Date(endDate));
		}

		if (duration == null) {
			dlrFfpOmsAllcNtfyDetailsImpl.setDuration("");
		}
		else {
			dlrFfpOmsAllcNtfyDetailsImpl.setDuration(duration);
		}

		dlrFfpOmsAllcNtfyDetailsImpl.setCommodityId(commodityId);

		if (commodityName == null) {
			dlrFfpOmsAllcNtfyDetailsImpl.setCommodityName("");
		}
		else {
			dlrFfpOmsAllcNtfyDetailsImpl.setCommodityName(commodityName);
		}

		dlrFfpOmsAllcNtfyDetailsImpl.setEconmcPrice(econmcPrice);
		dlrFfpOmsAllcNtfyDetailsImpl.setSalePrceToEndCstmr(salePrceToEndCstmr);

		if (unitPrice == null) {
			dlrFfpOmsAllcNtfyDetailsImpl.setUnitPrice("");
		}
		else {
			dlrFfpOmsAllcNtfyDetailsImpl.setUnitPrice(unitPrice);
		}

		dlrFfpOmsAllcNtfyDetailsImpl.setMaxAlltmntPDay(maxAlltmntPDay);
		dlrFfpOmsAllcNtfyDetailsImpl.setMaxSellQtyPCstmr(maxSellQtyPCstmr);

		if (createDate == Long.MIN_VALUE) {
			dlrFfpOmsAllcNtfyDetailsImpl.setCreateDate(null);
		}
		else {
			dlrFfpOmsAllcNtfyDetailsImpl.setCreateDate(new Date(createDate));
		}

		dlrFfpOmsAllcNtfyDetailsImpl.resetOriginalValues();

		return dlrFfpOmsAllcNtfyDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		allocNtfyId = objectInput.readUTF();
		prgrmType = objectInput.readUTF();
		salesOrgName = objectInput.readUTF();
		dstrbtnChnnl = objectInput.readUTF();

		year = objectInput.readLong();
		salesOffice = objectInput.readUTF();
		memoNo = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		duration = objectInput.readUTF();

		commodityId = objectInput.readLong();
		commodityName = objectInput.readUTF();

		econmcPrice = objectInput.readLong();

		salePrceToEndCstmr = objectInput.readLong();
		unitPrice = objectInput.readUTF();

		maxAlltmntPDay = objectInput.readFloat();

		maxSellQtyPCstmr = objectInput.readFloat();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (allocNtfyId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(allocNtfyId);
		}

		if (prgrmType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(prgrmType);
		}

		if (salesOrgName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(salesOrgName);
		}

		if (dstrbtnChnnl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dstrbtnChnnl);
		}

		objectOutput.writeLong(year);

		if (salesOffice == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(salesOffice);
		}

		if (memoNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(memoNo);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		if (duration == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(duration);
		}

		objectOutput.writeLong(commodityId);

		if (commodityName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(commodityName);
		}

		objectOutput.writeLong(econmcPrice);

		objectOutput.writeLong(salePrceToEndCstmr);

		if (unitPrice == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(unitPrice);
		}

		objectOutput.writeFloat(maxAlltmntPDay);

		objectOutput.writeFloat(maxSellQtyPCstmr);
		objectOutput.writeLong(createDate);
	}

	public String allocNtfyId;
	public String prgrmType;
	public String salesOrgName;
	public String dstrbtnChnnl;
	public long year;
	public String salesOffice;
	public String memoNo;
	public long startDate;
	public long endDate;
	public String duration;
	public long commodityId;
	public String commodityName;
	public long econmcPrice;
	public long salePrceToEndCstmr;
	public String unitPrice;
	public float maxAlltmntPDay;
	public float maxSellQtyPCstmr;
	public long createDate;

}