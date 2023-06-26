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

import bd.gov.dgfood.food.grain.license.model.DgfUsersDtls;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DgfUsersDtls in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DgfUsersDtlsCacheModel
	implements CacheModel<DgfUsersDtls>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DgfUsersDtlsCacheModel)) {
			return false;
		}

		DgfUsersDtlsCacheModel dgfUsersDtlsCacheModel =
			(DgfUsersDtlsCacheModel)object;

		if (userDetailsId == dgfUsersDtlsCacheModel.userDetailsId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userDetailsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{userDetailsId=");
		sb.append(userDetailsId);
		sb.append(", nationalId=");
		sb.append(nationalId);
		sb.append(", email=");
		sb.append(email);
		sb.append(", nidPhotoAttchId=");
		sb.append(nidPhotoAttchId);
		sb.append(", nidDivision=");
		sb.append(nidDivision);
		sb.append(", nidDistrict=");
		sb.append(nidDistrict);
		sb.append(", nidUpzilla=");
		sb.append(nidUpzilla);
		sb.append(", nidUnion=");
		sb.append(nidUnion);
		sb.append(", nidVillage=");
		sb.append(nidVillage);
		sb.append(", nidWard=");
		sb.append(nidWard);
		sb.append(", nidZipCode=");
		sb.append(nidZipCode);
		sb.append(", nidHouseAddress=");
		sb.append(nidHouseAddress);
		sb.append(", lastUpdatedDate=");
		sb.append(lastUpdatedDate);
		sb.append(", nidPostOffice=");
		sb.append(nidPostOffice);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DgfUsersDtls toEntityModel() {
		DgfUsersDtlsImpl dgfUsersDtlsImpl = new DgfUsersDtlsImpl();

		dgfUsersDtlsImpl.setUserDetailsId(userDetailsId);
		dgfUsersDtlsImpl.setNationalId(nationalId);

		if (email == null) {
			dgfUsersDtlsImpl.setEmail("");
		}
		else {
			dgfUsersDtlsImpl.setEmail(email);
		}

		dgfUsersDtlsImpl.setNidPhotoAttchId(nidPhotoAttchId);

		if (nidDivision == null) {
			dgfUsersDtlsImpl.setNidDivision("");
		}
		else {
			dgfUsersDtlsImpl.setNidDivision(nidDivision);
		}

		if (nidDistrict == null) {
			dgfUsersDtlsImpl.setNidDistrict("");
		}
		else {
			dgfUsersDtlsImpl.setNidDistrict(nidDistrict);
		}

		if (nidUpzilla == null) {
			dgfUsersDtlsImpl.setNidUpzilla("");
		}
		else {
			dgfUsersDtlsImpl.setNidUpzilla(nidUpzilla);
		}

		if (nidUnion == null) {
			dgfUsersDtlsImpl.setNidUnion("");
		}
		else {
			dgfUsersDtlsImpl.setNidUnion(nidUnion);
		}

		if (nidVillage == null) {
			dgfUsersDtlsImpl.setNidVillage("");
		}
		else {
			dgfUsersDtlsImpl.setNidVillage(nidVillage);
		}

		if (nidWard == null) {
			dgfUsersDtlsImpl.setNidWard("");
		}
		else {
			dgfUsersDtlsImpl.setNidWard(nidWard);
		}

		if (nidZipCode == null) {
			dgfUsersDtlsImpl.setNidZipCode("");
		}
		else {
			dgfUsersDtlsImpl.setNidZipCode(nidZipCode);
		}

		if (nidHouseAddress == null) {
			dgfUsersDtlsImpl.setNidHouseAddress("");
		}
		else {
			dgfUsersDtlsImpl.setNidHouseAddress(nidHouseAddress);
		}

		if (lastUpdatedDate == Long.MIN_VALUE) {
			dgfUsersDtlsImpl.setLastUpdatedDate(null);
		}
		else {
			dgfUsersDtlsImpl.setLastUpdatedDate(new Date(lastUpdatedDate));
		}

		if (nidPostOffice == null) {
			dgfUsersDtlsImpl.setNidPostOffice("");
		}
		else {
			dgfUsersDtlsImpl.setNidPostOffice(nidPostOffice);
		}

		dgfUsersDtlsImpl.resetOriginalValues();

		return dgfUsersDtlsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userDetailsId = objectInput.readLong();

		nationalId = objectInput.readLong();
		email = objectInput.readUTF();

		nidPhotoAttchId = objectInput.readLong();
		nidDivision = objectInput.readUTF();
		nidDistrict = objectInput.readUTF();
		nidUpzilla = objectInput.readUTF();
		nidUnion = objectInput.readUTF();
		nidVillage = objectInput.readUTF();
		nidWard = objectInput.readUTF();
		nidZipCode = objectInput.readUTF();
		nidHouseAddress = objectInput.readUTF();
		lastUpdatedDate = objectInput.readLong();
		nidPostOffice = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(userDetailsId);

		objectOutput.writeLong(nationalId);

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		objectOutput.writeLong(nidPhotoAttchId);

		if (nidDivision == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nidDivision);
		}

		if (nidDistrict == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nidDistrict);
		}

		if (nidUpzilla == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nidUpzilla);
		}

		if (nidUnion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nidUnion);
		}

		if (nidVillage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nidVillage);
		}

		if (nidWard == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nidWard);
		}

		if (nidZipCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nidZipCode);
		}

		if (nidHouseAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nidHouseAddress);
		}

		objectOutput.writeLong(lastUpdatedDate);

		if (nidPostOffice == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nidPostOffice);
		}
	}

	public long userDetailsId;
	public long nationalId;
	public String email;
	public long nidPhotoAttchId;
	public String nidDivision;
	public String nidDistrict;
	public String nidUpzilla;
	public String nidUnion;
	public String nidVillage;
	public String nidWard;
	public String nidZipCode;
	public String nidHouseAddress;
	public long lastUpdatedDate;
	public String nidPostOffice;

}