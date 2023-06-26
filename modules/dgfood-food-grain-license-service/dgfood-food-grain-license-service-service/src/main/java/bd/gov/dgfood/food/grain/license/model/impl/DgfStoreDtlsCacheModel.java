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

import bd.gov.dgfood.food.grain.license.model.DgfStoreDtls;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DgfStoreDtls in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DgfStoreDtlsCacheModel
	implements CacheModel<DgfStoreDtls>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DgfStoreDtlsCacheModel)) {
			return false;
		}

		DgfStoreDtlsCacheModel dgfStoreDtlsCacheModel =
			(DgfStoreDtlsCacheModel)object;

		if (id == dgfStoreDtlsCacheModel.id) {
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
		StringBundler sb = new StringBundler(39);

		sb.append("{id=");
		sb.append(id);
		sb.append(", nationalId=");
		sb.append(nationalId);
		sb.append(", type=");
		sb.append(type);
		sb.append(", mouza=");
		sb.append(mouza);
		sb.append(", khatiyn=");
		sb.append(khatiyn);
		sb.append(", DagNo=");
		sb.append(DagNo);
		sb.append(", division=");
		sb.append(division);
		sb.append(", district=");
		sb.append(district);
		sb.append(", upzilla=");
		sb.append(upzilla);
		sb.append(", unionName=");
		sb.append(unionName);
		sb.append(", cityCrprtn=");
		sb.append(cityCrprtn);
		sb.append(", dicsHight=");
		sb.append(dicsHight);
		sb.append(", dicsWidth=");
		sb.append(dicsWidth);
		sb.append(", dicsLngth=");
		sb.append(dicsLngth);
		sb.append(", dicsCpacty=");
		sb.append(dicsCpacty);
		sb.append(", totalCpacty=");
		sb.append(totalCpacty);
		sb.append(", createdAt=");
		sb.append(createdAt);
		sb.append(", updatedAt=");
		sb.append(updatedAt);
		sb.append(", flag=");
		sb.append(flag);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DgfStoreDtls toEntityModel() {
		DgfStoreDtlsImpl dgfStoreDtlsImpl = new DgfStoreDtlsImpl();

		dgfStoreDtlsImpl.setId(id);

		if (nationalId == null) {
			dgfStoreDtlsImpl.setNationalId("");
		}
		else {
			dgfStoreDtlsImpl.setNationalId(nationalId);
		}

		if (type == null) {
			dgfStoreDtlsImpl.setType("");
		}
		else {
			dgfStoreDtlsImpl.setType(type);
		}

		if (mouza == null) {
			dgfStoreDtlsImpl.setMouza("");
		}
		else {
			dgfStoreDtlsImpl.setMouza(mouza);
		}

		if (khatiyn == null) {
			dgfStoreDtlsImpl.setKhatiyn("");
		}
		else {
			dgfStoreDtlsImpl.setKhatiyn(khatiyn);
		}

		if (DagNo == null) {
			dgfStoreDtlsImpl.setDagNo("");
		}
		else {
			dgfStoreDtlsImpl.setDagNo(DagNo);
		}

		dgfStoreDtlsImpl.setDivision(division);
		dgfStoreDtlsImpl.setDistrict(district);
		dgfStoreDtlsImpl.setUpzilla(upzilla);
		dgfStoreDtlsImpl.setUnionName(unionName);
		dgfStoreDtlsImpl.setCityCrprtn(cityCrprtn);

		if (dicsHight == null) {
			dgfStoreDtlsImpl.setDicsHight("");
		}
		else {
			dgfStoreDtlsImpl.setDicsHight(dicsHight);
		}

		if (dicsWidth == null) {
			dgfStoreDtlsImpl.setDicsWidth("");
		}
		else {
			dgfStoreDtlsImpl.setDicsWidth(dicsWidth);
		}

		if (dicsLngth == null) {
			dgfStoreDtlsImpl.setDicsLngth("");
		}
		else {
			dgfStoreDtlsImpl.setDicsLngth(dicsLngth);
		}

		dgfStoreDtlsImpl.setDicsCpacty(dicsCpacty);
		dgfStoreDtlsImpl.setTotalCpacty(totalCpacty);

		if (createdAt == Long.MIN_VALUE) {
			dgfStoreDtlsImpl.setCreatedAt(null);
		}
		else {
			dgfStoreDtlsImpl.setCreatedAt(new Date(createdAt));
		}

		if (updatedAt == Long.MIN_VALUE) {
			dgfStoreDtlsImpl.setUpdatedAt(null);
		}
		else {
			dgfStoreDtlsImpl.setUpdatedAt(new Date(updatedAt));
		}

		dgfStoreDtlsImpl.setFlag(flag);

		dgfStoreDtlsImpl.resetOriginalValues();

		return dgfStoreDtlsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		nationalId = objectInput.readUTF();
		type = objectInput.readUTF();
		mouza = objectInput.readUTF();
		khatiyn = objectInput.readUTF();
		DagNo = objectInput.readUTF();

		division = objectInput.readLong();

		district = objectInput.readLong();

		upzilla = objectInput.readLong();

		unionName = objectInput.readLong();

		cityCrprtn = objectInput.readLong();
		dicsHight = objectInput.readUTF();
		dicsWidth = objectInput.readUTF();
		dicsLngth = objectInput.readUTF();

		dicsCpacty = objectInput.readLong();

		totalCpacty = objectInput.readLong();
		createdAt = objectInput.readLong();
		updatedAt = objectInput.readLong();

		flag = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (nationalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationalId);
		}

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (mouza == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mouza);
		}

		if (khatiyn == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(khatiyn);
		}

		if (DagNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(DagNo);
		}

		objectOutput.writeLong(division);

		objectOutput.writeLong(district);

		objectOutput.writeLong(upzilla);

		objectOutput.writeLong(unionName);

		objectOutput.writeLong(cityCrprtn);

		if (dicsHight == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dicsHight);
		}

		if (dicsWidth == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dicsWidth);
		}

		if (dicsLngth == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dicsLngth);
		}

		objectOutput.writeLong(dicsCpacty);

		objectOutput.writeLong(totalCpacty);
		objectOutput.writeLong(createdAt);
		objectOutput.writeLong(updatedAt);

		objectOutput.writeInt(flag);
	}

	public long id;
	public String nationalId;
	public String type;
	public String mouza;
	public String khatiyn;
	public String DagNo;
	public long division;
	public long district;
	public long upzilla;
	public long unionName;
	public long cityCrprtn;
	public String dicsHight;
	public String dicsWidth;
	public String dicsLngth;
	public long dicsCpacty;
	public long totalCpacty;
	public long createdAt;
	public long updatedAt;
	public int flag;

}