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

import bd.gov.dgfood.food.grain.license.model.dgfLocDivision;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing dgfLocDivision in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class dgfLocDivisionCacheModel
	implements CacheModel<dgfLocDivision>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof dgfLocDivisionCacheModel)) {
			return false;
		}

		dgfLocDivisionCacheModel dgfLocDivisionCacheModel =
			(dgfLocDivisionCacheModel)object;

		if (id == dgfLocDivisionCacheModel.id) {
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
		StringBundler sb = new StringBundler(17);

		sb.append("{id=");
		sb.append(id);
		sb.append(", name=");
		sb.append(name);
		sb.append(", bnName=");
		sb.append(bnName);
		sb.append(", url=");
		sb.append(url);
		sb.append(", status=");
		sb.append(status);
		sb.append(", createdAt=");
		sb.append(createdAt);
		sb.append(", updatedAt=");
		sb.append(updatedAt);
		sb.append(", geoCode=");
		sb.append(geoCode);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public dgfLocDivision toEntityModel() {
		dgfLocDivisionImpl dgfLocDivisionImpl = new dgfLocDivisionImpl();

		dgfLocDivisionImpl.setId(id);

		if (name == null) {
			dgfLocDivisionImpl.setName("");
		}
		else {
			dgfLocDivisionImpl.setName(name);
		}

		if (bnName == null) {
			dgfLocDivisionImpl.setBnName("");
		}
		else {
			dgfLocDivisionImpl.setBnName(bnName);
		}

		if (url == null) {
			dgfLocDivisionImpl.setUrl("");
		}
		else {
			dgfLocDivisionImpl.setUrl(url);
		}

		if (status == null) {
			dgfLocDivisionImpl.setStatus("");
		}
		else {
			dgfLocDivisionImpl.setStatus(status);
		}

		if (createdAt == Long.MIN_VALUE) {
			dgfLocDivisionImpl.setCreatedAt(null);
		}
		else {
			dgfLocDivisionImpl.setCreatedAt(new Date(createdAt));
		}

		if (updatedAt == Long.MIN_VALUE) {
			dgfLocDivisionImpl.setUpdatedAt(null);
		}
		else {
			dgfLocDivisionImpl.setUpdatedAt(new Date(updatedAt));
		}

		dgfLocDivisionImpl.setGeoCode(geoCode);

		dgfLocDivisionImpl.resetOriginalValues();

		return dgfLocDivisionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		name = objectInput.readUTF();
		bnName = objectInput.readUTF();
		url = objectInput.readUTF();
		status = objectInput.readUTF();
		createdAt = objectInput.readLong();
		updatedAt = objectInput.readLong();

		geoCode = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (bnName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bnName);
		}

		if (url == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(url);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(createdAt);
		objectOutput.writeLong(updatedAt);

		objectOutput.writeLong(geoCode);
	}

	public long id;
	public String name;
	public String bnName;
	public String url;
	public String status;
	public long createdAt;
	public long updatedAt;
	public long geoCode;

}