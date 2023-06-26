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

import bd.gov.dgfood.food.grain.license.model.DgfBussAddrDtls;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DgfBussAddrDtls in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DgfBussAddrDtlsCacheModel
	implements CacheModel<DgfBussAddrDtls>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DgfBussAddrDtlsCacheModel)) {
			return false;
		}

		DgfBussAddrDtlsCacheModel dgfBussAddrDtlsCacheModel =
			(DgfBussAddrDtlsCacheModel)object;

		if (businessAddressId == dgfBussAddrDtlsCacheModel.businessAddressId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, businessAddressId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{businessAddressId=");
		sb.append(businessAddressId);
		sb.append(", nationalId=");
		sb.append(nationalId);
		sb.append(", businessDivision=");
		sb.append(businessDivision);
		sb.append(", businessDistrict=");
		sb.append(businessDistrict);
		sb.append(", businessUpzilla=");
		sb.append(businessUpzilla);
		sb.append(", businessUnionName=");
		sb.append(businessUnionName);
		sb.append(", businessVillage=");
		sb.append(businessVillage);
		sb.append(", businessWard=");
		sb.append(businessWard);
		sb.append(", businessZipCode=");
		sb.append(businessZipCode);
		sb.append(", businessPostOffice=");
		sb.append(businessPostOffice);
		sb.append(", businessHouseAddress=");
		sb.append(businessHouseAddress);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DgfBussAddrDtls toEntityModel() {
		DgfBussAddrDtlsImpl dgfBussAddrDtlsImpl = new DgfBussAddrDtlsImpl();

		dgfBussAddrDtlsImpl.setBusinessAddressId(businessAddressId);
		dgfBussAddrDtlsImpl.setNationalId(nationalId);
		dgfBussAddrDtlsImpl.setBusinessDivision(businessDivision);
		dgfBussAddrDtlsImpl.setBusinessDistrict(businessDistrict);
		dgfBussAddrDtlsImpl.setBusinessUpzilla(businessUpzilla);
		dgfBussAddrDtlsImpl.setBusinessUnionName(businessUnionName);

		if (businessVillage == null) {
			dgfBussAddrDtlsImpl.setBusinessVillage("");
		}
		else {
			dgfBussAddrDtlsImpl.setBusinessVillage(businessVillage);
		}

		if (businessWard == null) {
			dgfBussAddrDtlsImpl.setBusinessWard("");
		}
		else {
			dgfBussAddrDtlsImpl.setBusinessWard(businessWard);
		}

		if (businessZipCode == null) {
			dgfBussAddrDtlsImpl.setBusinessZipCode("");
		}
		else {
			dgfBussAddrDtlsImpl.setBusinessZipCode(businessZipCode);
		}

		if (businessPostOffice == null) {
			dgfBussAddrDtlsImpl.setBusinessPostOffice("");
		}
		else {
			dgfBussAddrDtlsImpl.setBusinessPostOffice(businessPostOffice);
		}

		if (businessHouseAddress == null) {
			dgfBussAddrDtlsImpl.setBusinessHouseAddress("");
		}
		else {
			dgfBussAddrDtlsImpl.setBusinessHouseAddress(businessHouseAddress);
		}

		dgfBussAddrDtlsImpl.resetOriginalValues();

		return dgfBussAddrDtlsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		businessAddressId = objectInput.readLong();

		nationalId = objectInput.readLong();

		businessDivision = objectInput.readLong();

		businessDistrict = objectInput.readLong();

		businessUpzilla = objectInput.readLong();

		businessUnionName = objectInput.readLong();
		businessVillage = objectInput.readUTF();
		businessWard = objectInput.readUTF();
		businessZipCode = objectInput.readUTF();
		businessPostOffice = objectInput.readUTF();
		businessHouseAddress = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(businessAddressId);

		objectOutput.writeLong(nationalId);

		objectOutput.writeLong(businessDivision);

		objectOutput.writeLong(businessDistrict);

		objectOutput.writeLong(businessUpzilla);

		objectOutput.writeLong(businessUnionName);

		if (businessVillage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(businessVillage);
		}

		if (businessWard == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(businessWard);
		}

		if (businessZipCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(businessZipCode);
		}

		if (businessPostOffice == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(businessPostOffice);
		}

		if (businessHouseAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(businessHouseAddress);
		}
	}

	public long businessAddressId;
	public long nationalId;
	public long businessDivision;
	public long businessDistrict;
	public long businessUpzilla;
	public long businessUnionName;
	public String businessVillage;
	public String businessWard;
	public String businessZipCode;
	public String businessPostOffice;
	public String businessHouseAddress;

}