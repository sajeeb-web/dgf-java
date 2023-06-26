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

import bd.gov.dgfood.food.grain.license.model.dgfLocDistrict;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing dgfLocDistrict in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class dgfLocDistrictCacheModel
	implements CacheModel<dgfLocDistrict>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof dgfLocDistrictCacheModel)) {
			return false;
		}

		dgfLocDistrictCacheModel dgfLocDistrictCacheModel =
			(dgfLocDistrictCacheModel)object;

		if (id == dgfLocDistrictCacheModel.id) {
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
		StringBundler sb = new StringBundler(23);

		sb.append("{id=");
		sb.append(id);
		sb.append(", divisionId=");
		sb.append(divisionId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", bnName=");
		sb.append(bnName);
		sb.append(", lat=");
		sb.append(lat);
		sb.append(", lon=");
		sb.append(lon);
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
	public dgfLocDistrict toEntityModel() {
		dgfLocDistrictImpl dgfLocDistrictImpl = new dgfLocDistrictImpl();

		dgfLocDistrictImpl.setId(id);
		dgfLocDistrictImpl.setDivisionId(divisionId);

		if (name == null) {
			dgfLocDistrictImpl.setName("");
		}
		else {
			dgfLocDistrictImpl.setName(name);
		}

		if (bnName == null) {
			dgfLocDistrictImpl.setBnName("");
		}
		else {
			dgfLocDistrictImpl.setBnName(bnName);
		}

		if (lat == null) {
			dgfLocDistrictImpl.setLat("");
		}
		else {
			dgfLocDistrictImpl.setLat(lat);
		}

		if (lon == null) {
			dgfLocDistrictImpl.setLon("");
		}
		else {
			dgfLocDistrictImpl.setLon(lon);
		}

		if (url == null) {
			dgfLocDistrictImpl.setUrl("");
		}
		else {
			dgfLocDistrictImpl.setUrl(url);
		}

		if (status == null) {
			dgfLocDistrictImpl.setStatus("");
		}
		else {
			dgfLocDistrictImpl.setStatus(status);
		}

		if (createdAt == Long.MIN_VALUE) {
			dgfLocDistrictImpl.setCreatedAt(null);
		}
		else {
			dgfLocDistrictImpl.setCreatedAt(new Date(createdAt));
		}

		if (updatedAt == Long.MIN_VALUE) {
			dgfLocDistrictImpl.setUpdatedAt(null);
		}
		else {
			dgfLocDistrictImpl.setUpdatedAt(new Date(updatedAt));
		}

		dgfLocDistrictImpl.setGeoCode(geoCode);

		dgfLocDistrictImpl.resetOriginalValues();

		return dgfLocDistrictImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		divisionId = objectInput.readLong();
		name = objectInput.readUTF();
		bnName = objectInput.readUTF();
		lat = objectInput.readUTF();
		lon = objectInput.readUTF();
		url = objectInput.readUTF();
		status = objectInput.readUTF();
		createdAt = objectInput.readLong();
		updatedAt = objectInput.readLong();

		geoCode = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(divisionId);

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

		if (lat == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lat);
		}

		if (lon == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lon);
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
	public long divisionId;
	public String name;
	public String bnName;
	public String lat;
	public String lon;
	public String url;
	public String status;
	public long createdAt;
	public long updatedAt;
	public long geoCode;

}