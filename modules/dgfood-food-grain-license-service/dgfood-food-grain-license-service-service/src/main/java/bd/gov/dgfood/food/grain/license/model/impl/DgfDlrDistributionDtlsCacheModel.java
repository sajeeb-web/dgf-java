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

import bd.gov.dgfood.food.grain.license.model.DgfDlrDistributionDtls;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DgfDlrDistributionDtls in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DgfDlrDistributionDtlsCacheModel
	implements CacheModel<DgfDlrDistributionDtls>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DgfDlrDistributionDtlsCacheModel)) {
			return false;
		}

		DgfDlrDistributionDtlsCacheModel dgfDlrDistributionDtlsCacheModel =
			(DgfDlrDistributionDtlsCacheModel)object;

		if (id == dgfDlrDistributionDtlsCacheModel.id) {
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
		StringBundler sb = new StringBundler(27);

		sb.append("{id=");
		sb.append(id);
		sb.append(", dealerId=");
		sb.append(dealerId);
		sb.append(", beneficiariesId=");
		sb.append(beneficiariesId);
		sb.append(", beneficiariesMobileNo=");
		sb.append(beneficiariesMobileNo);
		sb.append(", cardNo=");
		sb.append(cardNo);
		sb.append(", unionId=");
		sb.append(unionId);
		sb.append(", distributionDate=");
		sb.append(distributionDate);
		sb.append(", distributionQty=");
		sb.append(distributionQty);
		sb.append(", status=");
		sb.append(status);
		sb.append(", createdAt=");
		sb.append(createdAt);
		sb.append(", updatedAt=");
		sb.append(updatedAt);
		sb.append(", month=");
		sb.append(month);
		sb.append(", year=");
		sb.append(year);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DgfDlrDistributionDtls toEntityModel() {
		DgfDlrDistributionDtlsImpl dgfDlrDistributionDtlsImpl =
			new DgfDlrDistributionDtlsImpl();

		dgfDlrDistributionDtlsImpl.setId(id);
		dgfDlrDistributionDtlsImpl.setDealerId(dealerId);
		dgfDlrDistributionDtlsImpl.setBeneficiariesId(beneficiariesId);

		if (beneficiariesMobileNo == null) {
			dgfDlrDistributionDtlsImpl.setBeneficiariesMobileNo("");
		}
		else {
			dgfDlrDistributionDtlsImpl.setBeneficiariesMobileNo(
				beneficiariesMobileNo);
		}

		dgfDlrDistributionDtlsImpl.setCardNo(cardNo);
		dgfDlrDistributionDtlsImpl.setUnionId(unionId);

		if (distributionDate == Long.MIN_VALUE) {
			dgfDlrDistributionDtlsImpl.setDistributionDate(null);
		}
		else {
			dgfDlrDistributionDtlsImpl.setDistributionDate(
				new Date(distributionDate));
		}

		dgfDlrDistributionDtlsImpl.setDistributionQty(distributionQty);
		dgfDlrDistributionDtlsImpl.setStatus(status);

		if (createdAt == Long.MIN_VALUE) {
			dgfDlrDistributionDtlsImpl.setCreatedAt(null);
		}
		else {
			dgfDlrDistributionDtlsImpl.setCreatedAt(new Date(createdAt));
		}

		if (updatedAt == Long.MIN_VALUE) {
			dgfDlrDistributionDtlsImpl.setUpdatedAt(null);
		}
		else {
			dgfDlrDistributionDtlsImpl.setUpdatedAt(new Date(updatedAt));
		}

		dgfDlrDistributionDtlsImpl.setMonth(month);
		dgfDlrDistributionDtlsImpl.setYear(year);

		dgfDlrDistributionDtlsImpl.resetOriginalValues();

		return dgfDlrDistributionDtlsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		dealerId = objectInput.readLong();

		beneficiariesId = objectInput.readLong();
		beneficiariesMobileNo = objectInput.readUTF();

		cardNo = objectInput.readLong();

		unionId = objectInput.readLong();
		distributionDate = objectInput.readLong();

		distributionQty = objectInput.readLong();

		status = objectInput.readInt();
		createdAt = objectInput.readLong();
		updatedAt = objectInput.readLong();

		month = objectInput.readInt();

		year = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(dealerId);

		objectOutput.writeLong(beneficiariesId);

		if (beneficiariesMobileNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(beneficiariesMobileNo);
		}

		objectOutput.writeLong(cardNo);

		objectOutput.writeLong(unionId);
		objectOutput.writeLong(distributionDate);

		objectOutput.writeLong(distributionQty);

		objectOutput.writeInt(status);
		objectOutput.writeLong(createdAt);
		objectOutput.writeLong(updatedAt);

		objectOutput.writeInt(month);

		objectOutput.writeInt(year);
	}

	public long id;
	public long dealerId;
	public long beneficiariesId;
	public String beneficiariesMobileNo;
	public long cardNo;
	public long unionId;
	public long distributionDate;
	public long distributionQty;
	public int status;
	public long createdAt;
	public long updatedAt;
	public int month;
	public int year;

}