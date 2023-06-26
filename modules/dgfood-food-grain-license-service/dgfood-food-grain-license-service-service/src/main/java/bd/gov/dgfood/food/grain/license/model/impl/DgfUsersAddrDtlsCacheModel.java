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

import bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DgfUsersAddrDtls in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DgfUsersAddrDtlsCacheModel
	implements CacheModel<DgfUsersAddrDtls>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DgfUsersAddrDtlsCacheModel)) {
			return false;
		}

		DgfUsersAddrDtlsCacheModel dgfUsersAddrDtlsCacheModel =
			(DgfUsersAddrDtlsCacheModel)object;

		if (addressId == dgfUsersAddrDtlsCacheModel.addressId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, addressId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{addressId=");
		sb.append(addressId);
		sb.append(", nationalId=");
		sb.append(nationalId);
		sb.append(", classPk=");
		sb.append(classPk);
		sb.append(", className=");
		sb.append(className);
		sb.append(", addressType=");
		sb.append(addressType);
		sb.append(", division=");
		sb.append(division);
		sb.append(", district=");
		sb.append(district);
		sb.append(", upzilla=");
		sb.append(upzilla);
		sb.append(", unionName=");
		sb.append(unionName);
		sb.append(", village=");
		sb.append(village);
		sb.append(", ward=");
		sb.append(ward);
		sb.append(", zipCode=");
		sb.append(zipCode);
		sb.append(", postOffice=");
		sb.append(postOffice);
		sb.append(", houseAddress=");
		sb.append(houseAddress);
		sb.append(", lastUpdatedDate=");
		sb.append(lastUpdatedDate);
		sb.append(", lastUpdatedBy=");
		sb.append(lastUpdatedBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DgfUsersAddrDtls toEntityModel() {
		DgfUsersAddrDtlsImpl dgfUsersAddrDtlsImpl = new DgfUsersAddrDtlsImpl();

		dgfUsersAddrDtlsImpl.setAddressId(addressId);
		dgfUsersAddrDtlsImpl.setNationalId(nationalId);
		dgfUsersAddrDtlsImpl.setClassPk(classPk);

		if (className == null) {
			dgfUsersAddrDtlsImpl.setClassName("");
		}
		else {
			dgfUsersAddrDtlsImpl.setClassName(className);
		}

		if (addressType == null) {
			dgfUsersAddrDtlsImpl.setAddressType("");
		}
		else {
			dgfUsersAddrDtlsImpl.setAddressType(addressType);
		}

		dgfUsersAddrDtlsImpl.setDivision(division);
		dgfUsersAddrDtlsImpl.setDistrict(district);
		dgfUsersAddrDtlsImpl.setUpzilla(upzilla);
		dgfUsersAddrDtlsImpl.setUnionName(unionName);

		if (village == null) {
			dgfUsersAddrDtlsImpl.setVillage("");
		}
		else {
			dgfUsersAddrDtlsImpl.setVillage(village);
		}

		if (ward == null) {
			dgfUsersAddrDtlsImpl.setWard("");
		}
		else {
			dgfUsersAddrDtlsImpl.setWard(ward);
		}

		if (zipCode == null) {
			dgfUsersAddrDtlsImpl.setZipCode("");
		}
		else {
			dgfUsersAddrDtlsImpl.setZipCode(zipCode);
		}

		if (postOffice == null) {
			dgfUsersAddrDtlsImpl.setPostOffice("");
		}
		else {
			dgfUsersAddrDtlsImpl.setPostOffice(postOffice);
		}

		if (houseAddress == null) {
			dgfUsersAddrDtlsImpl.setHouseAddress("");
		}
		else {
			dgfUsersAddrDtlsImpl.setHouseAddress(houseAddress);
		}

		if (lastUpdatedDate == Long.MIN_VALUE) {
			dgfUsersAddrDtlsImpl.setLastUpdatedDate(null);
		}
		else {
			dgfUsersAddrDtlsImpl.setLastUpdatedDate(new Date(lastUpdatedDate));
		}

		if (lastUpdatedBy == Long.MIN_VALUE) {
			dgfUsersAddrDtlsImpl.setLastUpdatedBy(null);
		}
		else {
			dgfUsersAddrDtlsImpl.setLastUpdatedBy(new Date(lastUpdatedBy));
		}

		dgfUsersAddrDtlsImpl.resetOriginalValues();

		return dgfUsersAddrDtlsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		addressId = objectInput.readLong();

		nationalId = objectInput.readLong();

		classPk = objectInput.readLong();
		className = objectInput.readUTF();
		addressType = objectInput.readUTF();

		division = objectInput.readLong();

		district = objectInput.readLong();

		upzilla = objectInput.readLong();

		unionName = objectInput.readLong();
		village = objectInput.readUTF();
		ward = objectInput.readUTF();
		zipCode = objectInput.readUTF();
		postOffice = objectInput.readUTF();
		houseAddress = objectInput.readUTF();
		lastUpdatedDate = objectInput.readLong();
		lastUpdatedBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(addressId);

		objectOutput.writeLong(nationalId);

		objectOutput.writeLong(classPk);

		if (className == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(className);
		}

		if (addressType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(addressType);
		}

		objectOutput.writeLong(division);

		objectOutput.writeLong(district);

		objectOutput.writeLong(upzilla);

		objectOutput.writeLong(unionName);

		if (village == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(village);
		}

		if (ward == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ward);
		}

		if (zipCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(zipCode);
		}

		if (postOffice == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(postOffice);
		}

		if (houseAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(houseAddress);
		}

		objectOutput.writeLong(lastUpdatedDate);
		objectOutput.writeLong(lastUpdatedBy);
	}

	public long addressId;
	public long nationalId;
	public long classPk;
	public String className;
	public String addressType;
	public long division;
	public long district;
	public long upzilla;
	public long unionName;
	public String village;
	public String ward;
	public String zipCode;
	public String postOffice;
	public String houseAddress;
	public long lastUpdatedDate;
	public long lastUpdatedBy;

}