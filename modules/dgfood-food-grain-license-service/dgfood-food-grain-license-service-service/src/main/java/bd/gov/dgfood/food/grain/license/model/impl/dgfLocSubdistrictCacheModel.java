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

import bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing dgfLocSubdistrict in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class dgfLocSubdistrictCacheModel
	implements CacheModel<dgfLocSubdistrict>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof dgfLocSubdistrictCacheModel)) {
			return false;
		}

		dgfLocSubdistrictCacheModel dgfLocSubdistrictCacheModel =
			(dgfLocSubdistrictCacheModel)object;

		if (id == dgfLocSubdistrictCacheModel.id) {
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
		sb.append(", districtId=");
		sb.append(districtId);
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
		sb.append(", roleName=");
		sb.append(roleName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public dgfLocSubdistrict toEntityModel() {
		dgfLocSubdistrictImpl dgfLocSubdistrictImpl =
			new dgfLocSubdistrictImpl();

		dgfLocSubdistrictImpl.setId(id);
		dgfLocSubdistrictImpl.setDistrictId(districtId);

		if (name == null) {
			dgfLocSubdistrictImpl.setName("");
		}
		else {
			dgfLocSubdistrictImpl.setName(name);
		}

		if (bnName == null) {
			dgfLocSubdistrictImpl.setBnName("");
		}
		else {
			dgfLocSubdistrictImpl.setBnName(bnName);
		}

		if (url == null) {
			dgfLocSubdistrictImpl.setUrl("");
		}
		else {
			dgfLocSubdistrictImpl.setUrl(url);
		}

		if (status == null) {
			dgfLocSubdistrictImpl.setStatus("");
		}
		else {
			dgfLocSubdistrictImpl.setStatus(status);
		}

		if (createdAt == Long.MIN_VALUE) {
			dgfLocSubdistrictImpl.setCreatedAt(null);
		}
		else {
			dgfLocSubdistrictImpl.setCreatedAt(new Date(createdAt));
		}

		if (updatedAt == Long.MIN_VALUE) {
			dgfLocSubdistrictImpl.setUpdatedAt(null);
		}
		else {
			dgfLocSubdistrictImpl.setUpdatedAt(new Date(updatedAt));
		}

		dgfLocSubdistrictImpl.setGeoCode(geoCode);

		if (roleName == null) {
			dgfLocSubdistrictImpl.setRoleName("");
		}
		else {
			dgfLocSubdistrictImpl.setRoleName(roleName);
		}

		dgfLocSubdistrictImpl.resetOriginalValues();

		return dgfLocSubdistrictImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		districtId = objectInput.readLong();
		name = objectInput.readUTF();
		bnName = objectInput.readUTF();
		url = objectInput.readUTF();
		status = objectInput.readUTF();
		createdAt = objectInput.readLong();
		updatedAt = objectInput.readLong();

		geoCode = objectInput.readLong();
		roleName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(districtId);

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

		if (roleName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(roleName);
		}
	}

	public long id;
	public long districtId;
	public String name;
	public String bnName;
	public String url;
	public String status;
	public long createdAt;
	public long updatedAt;
	public long geoCode;
	public String roleName;

}