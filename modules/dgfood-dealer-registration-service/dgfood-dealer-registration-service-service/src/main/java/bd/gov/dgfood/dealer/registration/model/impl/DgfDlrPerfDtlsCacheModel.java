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

package bd.gov.dgfood.dealer.registration.model.impl;

import bd.gov.dgfood.dealer.registration.model.DgfDlrPerfDtls;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DgfDlrPerfDtls in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DgfDlrPerfDtlsCacheModel
	implements CacheModel<DgfDlrPerfDtls>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DgfDlrPerfDtlsCacheModel)) {
			return false;
		}

		DgfDlrPerfDtlsCacheModel dgfDlrPerfDtlsCacheModel =
			(DgfDlrPerfDtlsCacheModel)object;

		if (dgfDlrPerfId == dgfDlrPerfDtlsCacheModel.dgfDlrPerfId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dgfDlrPerfId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{dgfDlrPerfId=");
		sb.append(dgfDlrPerfId);
		sb.append(", nationalId=");
		sb.append(nationalId);
		sb.append(", dlrRegApplNo=");
		sb.append(dlrRegApplNo);
		sb.append(", dlrRegNo=");
		sb.append(dlrRegNo);
		sb.append(", dlrPerfYr1=");
		sb.append(dlrPerfYr1);
		sb.append(", dlrPerfYr1AllocQty=");
		sb.append(dlrPerfYr1AllocQty);
		sb.append(", dlrPerfYr1ComdtyQty=");
		sb.append(dlrPerfYr1ComdtyQty);
		sb.append(", dlrPerfYr1DlrCtgry=");
		sb.append(dlrPerfYr1DlrCtgry);
		sb.append(", dlrPerfYr1Rmrk=");
		sb.append(dlrPerfYr1Rmrk);
		sb.append(", dlrPerfYr2=");
		sb.append(dlrPerfYr2);
		sb.append(", dlrPerfYr2AllocQty=");
		sb.append(dlrPerfYr2AllocQty);
		sb.append(", dlrPerfYr2ComdtyQty=");
		sb.append(dlrPerfYr2ComdtyQty);
		sb.append(", dlrPerfYr2DlrCtgry=");
		sb.append(dlrPerfYr2DlrCtgry);
		sb.append(", dlrPerfYr2Rmrk=");
		sb.append(dlrPerfYr2Rmrk);
		sb.append(", dlrPerfYr3=");
		sb.append(dlrPerfYr3);
		sb.append(", dlrPerfYr3AllocQty=");
		sb.append(dlrPerfYr3AllocQty);
		sb.append(", dlrPerfYr3ComdtyQty=");
		sb.append(dlrPerfYr3ComdtyQty);
		sb.append(", dlrPerfYr3DlrCtgry=");
		sb.append(dlrPerfYr3DlrCtgry);
		sb.append(", dlrPerfYr3Rmrk=");
		sb.append(dlrPerfYr3Rmrk);
		sb.append(", version=");
		sb.append(version);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DgfDlrPerfDtls toEntityModel() {
		DgfDlrPerfDtlsImpl dgfDlrPerfDtlsImpl = new DgfDlrPerfDtlsImpl();

		dgfDlrPerfDtlsImpl.setDgfDlrPerfId(dgfDlrPerfId);

		if (nationalId == null) {
			dgfDlrPerfDtlsImpl.setNationalId("");
		}
		else {
			dgfDlrPerfDtlsImpl.setNationalId(nationalId);
		}

		dgfDlrPerfDtlsImpl.setDlrRegApplNo(dlrRegApplNo);
		dgfDlrPerfDtlsImpl.setDlrRegNo(dlrRegNo);
		dgfDlrPerfDtlsImpl.setDlrPerfYr1(dlrPerfYr1);
		dgfDlrPerfDtlsImpl.setDlrPerfYr1AllocQty(dlrPerfYr1AllocQty);
		dgfDlrPerfDtlsImpl.setDlrPerfYr1ComdtyQty(dlrPerfYr1ComdtyQty);

		if (dlrPerfYr1DlrCtgry == null) {
			dgfDlrPerfDtlsImpl.setDlrPerfYr1DlrCtgry("");
		}
		else {
			dgfDlrPerfDtlsImpl.setDlrPerfYr1DlrCtgry(dlrPerfYr1DlrCtgry);
		}

		if (dlrPerfYr1Rmrk == null) {
			dgfDlrPerfDtlsImpl.setDlrPerfYr1Rmrk("");
		}
		else {
			dgfDlrPerfDtlsImpl.setDlrPerfYr1Rmrk(dlrPerfYr1Rmrk);
		}

		dgfDlrPerfDtlsImpl.setDlrPerfYr2(dlrPerfYr2);
		dgfDlrPerfDtlsImpl.setDlrPerfYr2AllocQty(dlrPerfYr2AllocQty);
		dgfDlrPerfDtlsImpl.setDlrPerfYr2ComdtyQty(dlrPerfYr2ComdtyQty);

		if (dlrPerfYr2DlrCtgry == null) {
			dgfDlrPerfDtlsImpl.setDlrPerfYr2DlrCtgry("");
		}
		else {
			dgfDlrPerfDtlsImpl.setDlrPerfYr2DlrCtgry(dlrPerfYr2DlrCtgry);
		}

		if (dlrPerfYr2Rmrk == null) {
			dgfDlrPerfDtlsImpl.setDlrPerfYr2Rmrk("");
		}
		else {
			dgfDlrPerfDtlsImpl.setDlrPerfYr2Rmrk(dlrPerfYr2Rmrk);
		}

		dgfDlrPerfDtlsImpl.setDlrPerfYr3(dlrPerfYr3);
		dgfDlrPerfDtlsImpl.setDlrPerfYr3AllocQty(dlrPerfYr3AllocQty);
		dgfDlrPerfDtlsImpl.setDlrPerfYr3ComdtyQty(dlrPerfYr3ComdtyQty);

		if (dlrPerfYr3DlrCtgry == null) {
			dgfDlrPerfDtlsImpl.setDlrPerfYr3DlrCtgry("");
		}
		else {
			dgfDlrPerfDtlsImpl.setDlrPerfYr3DlrCtgry(dlrPerfYr3DlrCtgry);
		}

		if (dlrPerfYr3Rmrk == null) {
			dgfDlrPerfDtlsImpl.setDlrPerfYr3Rmrk("");
		}
		else {
			dgfDlrPerfDtlsImpl.setDlrPerfYr3Rmrk(dlrPerfYr3Rmrk);
		}

		dgfDlrPerfDtlsImpl.setVersion(version);

		dgfDlrPerfDtlsImpl.resetOriginalValues();

		return dgfDlrPerfDtlsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dgfDlrPerfId = objectInput.readLong();
		nationalId = objectInput.readUTF();

		dlrRegApplNo = objectInput.readLong();

		dlrRegNo = objectInput.readLong();

		dlrPerfYr1 = objectInput.readLong();

		dlrPerfYr1AllocQty = objectInput.readLong();

		dlrPerfYr1ComdtyQty = objectInput.readLong();
		dlrPerfYr1DlrCtgry = objectInput.readUTF();
		dlrPerfYr1Rmrk = objectInput.readUTF();

		dlrPerfYr2 = objectInput.readLong();

		dlrPerfYr2AllocQty = objectInput.readLong();

		dlrPerfYr2ComdtyQty = objectInput.readLong();
		dlrPerfYr2DlrCtgry = objectInput.readUTF();
		dlrPerfYr2Rmrk = objectInput.readUTF();

		dlrPerfYr3 = objectInput.readLong();

		dlrPerfYr3AllocQty = objectInput.readLong();

		dlrPerfYr3ComdtyQty = objectInput.readLong();
		dlrPerfYr3DlrCtgry = objectInput.readUTF();
		dlrPerfYr3Rmrk = objectInput.readUTF();

		version = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(dgfDlrPerfId);

		if (nationalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationalId);
		}

		objectOutput.writeLong(dlrRegApplNo);

		objectOutput.writeLong(dlrRegNo);

		objectOutput.writeLong(dlrPerfYr1);

		objectOutput.writeLong(dlrPerfYr1AllocQty);

		objectOutput.writeLong(dlrPerfYr1ComdtyQty);

		if (dlrPerfYr1DlrCtgry == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dlrPerfYr1DlrCtgry);
		}

		if (dlrPerfYr1Rmrk == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dlrPerfYr1Rmrk);
		}

		objectOutput.writeLong(dlrPerfYr2);

		objectOutput.writeLong(dlrPerfYr2AllocQty);

		objectOutput.writeLong(dlrPerfYr2ComdtyQty);

		if (dlrPerfYr2DlrCtgry == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dlrPerfYr2DlrCtgry);
		}

		if (dlrPerfYr2Rmrk == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dlrPerfYr2Rmrk);
		}

		objectOutput.writeLong(dlrPerfYr3);

		objectOutput.writeLong(dlrPerfYr3AllocQty);

		objectOutput.writeLong(dlrPerfYr3ComdtyQty);

		if (dlrPerfYr3DlrCtgry == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dlrPerfYr3DlrCtgry);
		}

		if (dlrPerfYr3Rmrk == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dlrPerfYr3Rmrk);
		}

		objectOutput.writeLong(version);
	}

	public long dgfDlrPerfId;
	public String nationalId;
	public long dlrRegApplNo;
	public long dlrRegNo;
	public long dlrPerfYr1;
	public long dlrPerfYr1AllocQty;
	public long dlrPerfYr1ComdtyQty;
	public String dlrPerfYr1DlrCtgry;
	public String dlrPerfYr1Rmrk;
	public long dlrPerfYr2;
	public long dlrPerfYr2AllocQty;
	public long dlrPerfYr2ComdtyQty;
	public String dlrPerfYr2DlrCtgry;
	public String dlrPerfYr2Rmrk;
	public long dlrPerfYr3;
	public long dlrPerfYr3AllocQty;
	public long dlrPerfYr3ComdtyQty;
	public String dlrPerfYr3DlrCtgry;
	public String dlrPerfYr3Rmrk;
	public long version;

}