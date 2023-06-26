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

import bd.gov.dgfood.food.grain.license.model.DgfFglLicenseNo;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DgfFglLicenseNo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DgfFglLicenseNoCacheModel
	implements CacheModel<DgfFglLicenseNo>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DgfFglLicenseNoCacheModel)) {
			return false;
		}

		DgfFglLicenseNoCacheModel dgfFglLicenseNoCacheModel =
			(DgfFglLicenseNoCacheModel)object;

		if (id == dgfFglLicenseNoCacheModel.id) {
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
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(id);
		sb.append(", suffix=");
		sb.append(suffix);
		sb.append(", prefix=");
		sb.append(prefix);
		sb.append(", serialNo=");
		sb.append(serialNo);
		sb.append(", licenseNo=");
		sb.append(licenseNo);
		sb.append(", createdAt=");
		sb.append(createdAt);
		sb.append(", updatedAt=");
		sb.append(updatedAt);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DgfFglLicenseNo toEntityModel() {
		DgfFglLicenseNoImpl dgfFglLicenseNoImpl = new DgfFglLicenseNoImpl();

		dgfFglLicenseNoImpl.setId(id);
		dgfFglLicenseNoImpl.setSuffix(suffix);
		dgfFglLicenseNoImpl.setPrefix(prefix);
		dgfFglLicenseNoImpl.setSerialNo(serialNo);

		if (licenseNo == null) {
			dgfFglLicenseNoImpl.setLicenseNo("");
		}
		else {
			dgfFglLicenseNoImpl.setLicenseNo(licenseNo);
		}

		if (createdAt == Long.MIN_VALUE) {
			dgfFglLicenseNoImpl.setCreatedAt(null);
		}
		else {
			dgfFglLicenseNoImpl.setCreatedAt(new Date(createdAt));
		}

		if (updatedAt == Long.MIN_VALUE) {
			dgfFglLicenseNoImpl.setUpdatedAt(null);
		}
		else {
			dgfFglLicenseNoImpl.setUpdatedAt(new Date(updatedAt));
		}

		dgfFglLicenseNoImpl.resetOriginalValues();

		return dgfFglLicenseNoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		suffix = objectInput.readLong();

		prefix = objectInput.readLong();

		serialNo = objectInput.readLong();
		licenseNo = objectInput.readUTF();
		createdAt = objectInput.readLong();
		updatedAt = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(suffix);

		objectOutput.writeLong(prefix);

		objectOutput.writeLong(serialNo);

		if (licenseNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(licenseNo);
		}

		objectOutput.writeLong(createdAt);
		objectOutput.writeLong(updatedAt);
	}

	public long id;
	public long suffix;
	public long prefix;
	public long serialNo;
	public String licenseNo;
	public long createdAt;
	public long updatedAt;

}