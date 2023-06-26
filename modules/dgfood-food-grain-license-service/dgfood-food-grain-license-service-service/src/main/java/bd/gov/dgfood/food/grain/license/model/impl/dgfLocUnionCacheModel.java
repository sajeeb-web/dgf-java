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

import bd.gov.dgfood.food.grain.license.model.dgfLocUnion;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing dgfLocUnion in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class dgfLocUnionCacheModel
	implements CacheModel<dgfLocUnion>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof dgfLocUnionCacheModel)) {
			return false;
		}

		dgfLocUnionCacheModel dgfLocUnionCacheModel =
			(dgfLocUnionCacheModel)object;

		if (id == dgfLocUnionCacheModel.id) {
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
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(id);
		sb.append(", subdistrictId=");
		sb.append(subdistrictId);
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
	public dgfLocUnion toEntityModel() {
		dgfLocUnionImpl dgfLocUnionImpl = new dgfLocUnionImpl();

		dgfLocUnionImpl.setId(id);
		dgfLocUnionImpl.setSubdistrictId(subdistrictId);

		if (name == null) {
			dgfLocUnionImpl.setName("");
		}
		else {
			dgfLocUnionImpl.setName(name);
		}

		if (bnName == null) {
			dgfLocUnionImpl.setBnName("");
		}
		else {
			dgfLocUnionImpl.setBnName(bnName);
		}

		if (url == null) {
			dgfLocUnionImpl.setUrl("");
		}
		else {
			dgfLocUnionImpl.setUrl(url);
		}

		if (status == null) {
			dgfLocUnionImpl.setStatus("");
		}
		else {
			dgfLocUnionImpl.setStatus(status);
		}

		if (createdAt == Long.MIN_VALUE) {
			dgfLocUnionImpl.setCreatedAt(null);
		}
		else {
			dgfLocUnionImpl.setCreatedAt(new Date(createdAt));
		}

		if (updatedAt == Long.MIN_VALUE) {
			dgfLocUnionImpl.setUpdatedAt(null);
		}
		else {
			dgfLocUnionImpl.setUpdatedAt(new Date(updatedAt));
		}

		dgfLocUnionImpl.setGeoCode(geoCode);

		dgfLocUnionImpl.resetOriginalValues();

		return dgfLocUnionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		subdistrictId = objectInput.readLong();
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

		objectOutput.writeLong(subdistrictId);

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
	public long subdistrictId;
	public String name;
	public String bnName;
	public String url;
	public String status;
	public long createdAt;
	public long updatedAt;
	public long geoCode;

}