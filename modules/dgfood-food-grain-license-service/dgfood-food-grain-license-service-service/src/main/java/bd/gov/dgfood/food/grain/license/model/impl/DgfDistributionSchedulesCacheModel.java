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

import bd.gov.dgfood.food.grain.license.model.DgfDistributionSchedules;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DgfDistributionSchedules in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DgfDistributionSchedulesCacheModel
	implements CacheModel<DgfDistributionSchedules>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DgfDistributionSchedulesCacheModel)) {
			return false;
		}

		DgfDistributionSchedulesCacheModel dgfDistributionSchedulesCacheModel =
			(DgfDistributionSchedulesCacheModel)object;

		if (id.equals(dgfDistributionSchedulesCacheModel.id)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(id);
		sb.append(", distributionYear=");
		sb.append(distributionYear);
		sb.append(", distributionMonth=");
		sb.append(distributionMonth);
		sb.append(", openStatus=");
		sb.append(openStatus);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", remarks=");
		sb.append(remarks);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdAt=");
		sb.append(createdAt);
		sb.append(", updatedAt=");
		sb.append(updatedAt);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DgfDistributionSchedules toEntityModel() {
		DgfDistributionSchedulesImpl dgfDistributionSchedulesImpl =
			new DgfDistributionSchedulesImpl();

		if (id == null) {
			dgfDistributionSchedulesImpl.setId("");
		}
		else {
			dgfDistributionSchedulesImpl.setId(id);
		}

		dgfDistributionSchedulesImpl.setDistributionYear(distributionYear);

		if (distributionMonth == null) {
			dgfDistributionSchedulesImpl.setDistributionMonth("");
		}
		else {
			dgfDistributionSchedulesImpl.setDistributionMonth(
				distributionMonth);
		}

		if (openStatus == null) {
			dgfDistributionSchedulesImpl.setOpenStatus("");
		}
		else {
			dgfDistributionSchedulesImpl.setOpenStatus(openStatus);
		}

		if (startDate == Long.MIN_VALUE) {
			dgfDistributionSchedulesImpl.setStartDate(null);
		}
		else {
			dgfDistributionSchedulesImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			dgfDistributionSchedulesImpl.setEndDate(null);
		}
		else {
			dgfDistributionSchedulesImpl.setEndDate(new Date(endDate));
		}

		if (remarks == null) {
			dgfDistributionSchedulesImpl.setRemarks("");
		}
		else {
			dgfDistributionSchedulesImpl.setRemarks(remarks);
		}

		dgfDistributionSchedulesImpl.setUserId(userId);

		if (createdAt == Long.MIN_VALUE) {
			dgfDistributionSchedulesImpl.setCreatedAt(null);
		}
		else {
			dgfDistributionSchedulesImpl.setCreatedAt(new Date(createdAt));
		}

		if (updatedAt == Long.MIN_VALUE) {
			dgfDistributionSchedulesImpl.setUpdatedAt(null);
		}
		else {
			dgfDistributionSchedulesImpl.setUpdatedAt(new Date(updatedAt));
		}

		dgfDistributionSchedulesImpl.resetOriginalValues();

		return dgfDistributionSchedulesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readUTF();

		distributionYear = objectInput.readLong();
		distributionMonth = objectInput.readUTF();
		openStatus = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		remarks = objectInput.readUTF();

		userId = objectInput.readLong();
		createdAt = objectInput.readLong();
		updatedAt = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (id == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(id);
		}

		objectOutput.writeLong(distributionYear);

		if (distributionMonth == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(distributionMonth);
		}

		if (openStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(openStatus);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		if (remarks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(remarks);
		}

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createdAt);
		objectOutput.writeLong(updatedAt);
	}

	public String id;
	public long distributionYear;
	public String distributionMonth;
	public String openStatus;
	public long startDate;
	public long endDate;
	public String remarks;
	public long userId;
	public long createdAt;
	public long updatedAt;

}