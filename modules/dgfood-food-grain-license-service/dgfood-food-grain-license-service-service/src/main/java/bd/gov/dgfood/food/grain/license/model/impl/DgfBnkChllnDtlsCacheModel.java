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

import bd.gov.dgfood.food.grain.license.model.DgfBnkChllnDtls;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DgfBnkChllnDtls in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DgfBnkChllnDtlsCacheModel
	implements CacheModel<DgfBnkChllnDtls>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DgfBnkChllnDtlsCacheModel)) {
			return false;
		}

		DgfBnkChllnDtlsCacheModel dgfBnkChllnDtlsCacheModel =
			(DgfBnkChllnDtlsCacheModel)object;

		if (bnkChllnId == dgfBnkChllnDtlsCacheModel.bnkChllnId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, bnkChllnId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{bnkChllnId=");
		sb.append(bnkChllnId);
		sb.append(", trnPoNo=");
		sb.append(trnPoNo);
		sb.append(", paymentStatus=");
		sb.append(paymentStatus);
		sb.append(", trnAmount=");
		sb.append(trnAmount);
		sb.append(", pymntChllnDate=");
		sb.append(pymntChllnDate);
		sb.append(", bnkChllnDocId=");
		sb.append(bnkChllnDocId);
		sb.append(", bnkChllnUpldBy=");
		sb.append(bnkChllnUpldBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DgfBnkChllnDtls toEntityModel() {
		DgfBnkChllnDtlsImpl dgfBnkChllnDtlsImpl = new DgfBnkChllnDtlsImpl();

		dgfBnkChllnDtlsImpl.setBnkChllnId(bnkChllnId);
		dgfBnkChllnDtlsImpl.setTrnPoNo(trnPoNo);
		dgfBnkChllnDtlsImpl.setPaymentStatus(paymentStatus);
		dgfBnkChllnDtlsImpl.setTrnAmount(trnAmount);

		if (pymntChllnDate == Long.MIN_VALUE) {
			dgfBnkChllnDtlsImpl.setPymntChllnDate(null);
		}
		else {
			dgfBnkChllnDtlsImpl.setPymntChllnDate(new Date(pymntChllnDate));
		}

		dgfBnkChllnDtlsImpl.setBnkChllnDocId(bnkChllnDocId);
		dgfBnkChllnDtlsImpl.setBnkChllnUpldBy(bnkChllnUpldBy);

		dgfBnkChllnDtlsImpl.resetOriginalValues();

		return dgfBnkChllnDtlsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		bnkChllnId = objectInput.readLong();

		trnPoNo = objectInput.readLong();

		paymentStatus = objectInput.readLong();

		trnAmount = objectInput.readLong();
		pymntChllnDate = objectInput.readLong();

		bnkChllnDocId = objectInput.readLong();

		bnkChllnUpldBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(bnkChllnId);

		objectOutput.writeLong(trnPoNo);

		objectOutput.writeLong(paymentStatus);

		objectOutput.writeLong(trnAmount);
		objectOutput.writeLong(pymntChllnDate);

		objectOutput.writeLong(bnkChllnDocId);

		objectOutput.writeLong(bnkChllnUpldBy);
	}

	public long bnkChllnId;
	public long trnPoNo;
	public long paymentStatus;
	public long trnAmount;
	public long pymntChllnDate;
	public long bnkChllnDocId;
	public long bnkChllnUpldBy;

}