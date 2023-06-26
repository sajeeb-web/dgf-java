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

import bd.gov.dgfood.food.grain.license.model.DgfFglProductDtls;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DgfFglProductDtls in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DgfFglProductDtlsCacheModel
	implements CacheModel<DgfFglProductDtls>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DgfFglProductDtlsCacheModel)) {
			return false;
		}

		DgfFglProductDtlsCacheModel dgfFglProductDtlsCacheModel =
			(DgfFglProductDtlsCacheModel)object;

		if (fglProductPrimaryId ==
				dgfFglProductDtlsCacheModel.fglProductPrimaryId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fglProductPrimaryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{fglProductPrimaryId=");
		sb.append(fglProductPrimaryId);
		sb.append(", nationalId=");
		sb.append(nationalId);
		sb.append(", fglLicPrimaryId=");
		sb.append(fglLicPrimaryId);
		sb.append(", productType=");
		sb.append(productType);
		sb.append(", stockDuration=");
		sb.append(stockDuration);
		sb.append(", stockAmount=");
		sb.append(stockAmount);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DgfFglProductDtls toEntityModel() {
		DgfFglProductDtlsImpl dgfFglProductDtlsImpl =
			new DgfFglProductDtlsImpl();

		dgfFglProductDtlsImpl.setFglProductPrimaryId(fglProductPrimaryId);

		if (nationalId == null) {
			dgfFglProductDtlsImpl.setNationalId("");
		}
		else {
			dgfFglProductDtlsImpl.setNationalId(nationalId);
		}

		dgfFglProductDtlsImpl.setFglLicPrimaryId(fglLicPrimaryId);

		if (productType == null) {
			dgfFglProductDtlsImpl.setProductType("");
		}
		else {
			dgfFglProductDtlsImpl.setProductType(productType);
		}

		dgfFglProductDtlsImpl.setStockDuration(stockDuration);
		dgfFglProductDtlsImpl.setStockAmount(stockAmount);

		if (createdDate == Long.MIN_VALUE) {
			dgfFglProductDtlsImpl.setCreatedDate(null);
		}
		else {
			dgfFglProductDtlsImpl.setCreatedDate(new Date(createdDate));
		}

		dgfFglProductDtlsImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			dgfFglProductDtlsImpl.setModifiedDate(null);
		}
		else {
			dgfFglProductDtlsImpl.setModifiedDate(new Date(modifiedDate));
		}

		dgfFglProductDtlsImpl.setModifiedBy(modifiedBy);

		dgfFglProductDtlsImpl.resetOriginalValues();

		return dgfFglProductDtlsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		fglProductPrimaryId = objectInput.readLong();
		nationalId = objectInput.readUTF();

		fglLicPrimaryId = objectInput.readLong();
		productType = objectInput.readUTF();

		stockDuration = objectInput.readLong();

		stockAmount = objectInput.readLong();
		createdDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(fglProductPrimaryId);

		if (nationalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationalId);
		}

		objectOutput.writeLong(fglLicPrimaryId);

		if (productType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(productType);
		}

		objectOutput.writeLong(stockDuration);

		objectOutput.writeLong(stockAmount);
		objectOutput.writeLong(createdDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public long fglProductPrimaryId;
	public String nationalId;
	public long fglLicPrimaryId;
	public String productType;
	public long stockDuration;
	public long stockAmount;
	public long createdDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;

}