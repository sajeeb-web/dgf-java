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

package bd.gov.dgfood.dealer.registration.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DgfDlrPerfDtls}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrPerfDtls
 * @generated
 */
public class DgfDlrPerfDtlsWrapper
	extends BaseModelWrapper<DgfDlrPerfDtls>
	implements DgfDlrPerfDtls, ModelWrapper<DgfDlrPerfDtls> {

	public DgfDlrPerfDtlsWrapper(DgfDlrPerfDtls dgfDlrPerfDtls) {
		super(dgfDlrPerfDtls);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dgfDlrPerfId", getDgfDlrPerfId());
		attributes.put("nationalId", getNationalId());
		attributes.put("dlrRegApplNo", getDlrRegApplNo());
		attributes.put("dlrRegNo", getDlrRegNo());
		attributes.put("dlrPerfYr1", getDlrPerfYr1());
		attributes.put("dlrPerfYr1AllocQty", getDlrPerfYr1AllocQty());
		attributes.put("dlrPerfYr1ComdtyQty", getDlrPerfYr1ComdtyQty());
		attributes.put("dlrPerfYr1DlrCtgry", getDlrPerfYr1DlrCtgry());
		attributes.put("dlrPerfYr1Rmrk", getDlrPerfYr1Rmrk());
		attributes.put("dlrPerfYr2", getDlrPerfYr2());
		attributes.put("dlrPerfYr2AllocQty", getDlrPerfYr2AllocQty());
		attributes.put("dlrPerfYr2ComdtyQty", getDlrPerfYr2ComdtyQty());
		attributes.put("dlrPerfYr2DlrCtgry", getDlrPerfYr2DlrCtgry());
		attributes.put("dlrPerfYr2Rmrk", getDlrPerfYr2Rmrk());
		attributes.put("dlrPerfYr3", getDlrPerfYr3());
		attributes.put("dlrPerfYr3AllocQty", getDlrPerfYr3AllocQty());
		attributes.put("dlrPerfYr3ComdtyQty", getDlrPerfYr3ComdtyQty());
		attributes.put("dlrPerfYr3DlrCtgry", getDlrPerfYr3DlrCtgry());
		attributes.put("dlrPerfYr3Rmrk", getDlrPerfYr3Rmrk());
		attributes.put("version", getVersion());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dgfDlrPerfId = (Long)attributes.get("dgfDlrPerfId");

		if (dgfDlrPerfId != null) {
			setDgfDlrPerfId(dgfDlrPerfId);
		}

		String nationalId = (String)attributes.get("nationalId");

		if (nationalId != null) {
			setNationalId(nationalId);
		}

		Long dlrRegApplNo = (Long)attributes.get("dlrRegApplNo");

		if (dlrRegApplNo != null) {
			setDlrRegApplNo(dlrRegApplNo);
		}

		Long dlrRegNo = (Long)attributes.get("dlrRegNo");

		if (dlrRegNo != null) {
			setDlrRegNo(dlrRegNo);
		}

		Long dlrPerfYr1 = (Long)attributes.get("dlrPerfYr1");

		if (dlrPerfYr1 != null) {
			setDlrPerfYr1(dlrPerfYr1);
		}

		Long dlrPerfYr1AllocQty = (Long)attributes.get("dlrPerfYr1AllocQty");

		if (dlrPerfYr1AllocQty != null) {
			setDlrPerfYr1AllocQty(dlrPerfYr1AllocQty);
		}

		Long dlrPerfYr1ComdtyQty = (Long)attributes.get("dlrPerfYr1ComdtyQty");

		if (dlrPerfYr1ComdtyQty != null) {
			setDlrPerfYr1ComdtyQty(dlrPerfYr1ComdtyQty);
		}

		String dlrPerfYr1DlrCtgry = (String)attributes.get(
			"dlrPerfYr1DlrCtgry");

		if (dlrPerfYr1DlrCtgry != null) {
			setDlrPerfYr1DlrCtgry(dlrPerfYr1DlrCtgry);
		}

		String dlrPerfYr1Rmrk = (String)attributes.get("dlrPerfYr1Rmrk");

		if (dlrPerfYr1Rmrk != null) {
			setDlrPerfYr1Rmrk(dlrPerfYr1Rmrk);
		}

		Long dlrPerfYr2 = (Long)attributes.get("dlrPerfYr2");

		if (dlrPerfYr2 != null) {
			setDlrPerfYr2(dlrPerfYr2);
		}

		Long dlrPerfYr2AllocQty = (Long)attributes.get("dlrPerfYr2AllocQty");

		if (dlrPerfYr2AllocQty != null) {
			setDlrPerfYr2AllocQty(dlrPerfYr2AllocQty);
		}

		Long dlrPerfYr2ComdtyQty = (Long)attributes.get("dlrPerfYr2ComdtyQty");

		if (dlrPerfYr2ComdtyQty != null) {
			setDlrPerfYr2ComdtyQty(dlrPerfYr2ComdtyQty);
		}

		String dlrPerfYr2DlrCtgry = (String)attributes.get(
			"dlrPerfYr2DlrCtgry");

		if (dlrPerfYr2DlrCtgry != null) {
			setDlrPerfYr2DlrCtgry(dlrPerfYr2DlrCtgry);
		}

		String dlrPerfYr2Rmrk = (String)attributes.get("dlrPerfYr2Rmrk");

		if (dlrPerfYr2Rmrk != null) {
			setDlrPerfYr2Rmrk(dlrPerfYr2Rmrk);
		}

		Long dlrPerfYr3 = (Long)attributes.get("dlrPerfYr3");

		if (dlrPerfYr3 != null) {
			setDlrPerfYr3(dlrPerfYr3);
		}

		Long dlrPerfYr3AllocQty = (Long)attributes.get("dlrPerfYr3AllocQty");

		if (dlrPerfYr3AllocQty != null) {
			setDlrPerfYr3AllocQty(dlrPerfYr3AllocQty);
		}

		Long dlrPerfYr3ComdtyQty = (Long)attributes.get("dlrPerfYr3ComdtyQty");

		if (dlrPerfYr3ComdtyQty != null) {
			setDlrPerfYr3ComdtyQty(dlrPerfYr3ComdtyQty);
		}

		String dlrPerfYr3DlrCtgry = (String)attributes.get(
			"dlrPerfYr3DlrCtgry");

		if (dlrPerfYr3DlrCtgry != null) {
			setDlrPerfYr3DlrCtgry(dlrPerfYr3DlrCtgry);
		}

		String dlrPerfYr3Rmrk = (String)attributes.get("dlrPerfYr3Rmrk");

		if (dlrPerfYr3Rmrk != null) {
			setDlrPerfYr3Rmrk(dlrPerfYr3Rmrk);
		}

		Long version = (Long)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}
	}

	@Override
	public DgfDlrPerfDtls cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the dgf dlr perf ID of this dgf dlr perf dtls.
	 *
	 * @return the dgf dlr perf ID of this dgf dlr perf dtls
	 */
	@Override
	public long getDgfDlrPerfId() {
		return model.getDgfDlrPerfId();
	}

	/**
	 * Returns the dlr perf yr1 of this dgf dlr perf dtls.
	 *
	 * @return the dlr perf yr1 of this dgf dlr perf dtls
	 */
	@Override
	public long getDlrPerfYr1() {
		return model.getDlrPerfYr1();
	}

	/**
	 * Returns the dlr perf yr1 alloc qty of this dgf dlr perf dtls.
	 *
	 * @return the dlr perf yr1 alloc qty of this dgf dlr perf dtls
	 */
	@Override
	public long getDlrPerfYr1AllocQty() {
		return model.getDlrPerfYr1AllocQty();
	}

	/**
	 * Returns the dlr perf yr1 comdty qty of this dgf dlr perf dtls.
	 *
	 * @return the dlr perf yr1 comdty qty of this dgf dlr perf dtls
	 */
	@Override
	public long getDlrPerfYr1ComdtyQty() {
		return model.getDlrPerfYr1ComdtyQty();
	}

	/**
	 * Returns the dlr perf yr1 dlr ctgry of this dgf dlr perf dtls.
	 *
	 * @return the dlr perf yr1 dlr ctgry of this dgf dlr perf dtls
	 */
	@Override
	public String getDlrPerfYr1DlrCtgry() {
		return model.getDlrPerfYr1DlrCtgry();
	}

	/**
	 * Returns the dlr perf yr1 rmrk of this dgf dlr perf dtls.
	 *
	 * @return the dlr perf yr1 rmrk of this dgf dlr perf dtls
	 */
	@Override
	public String getDlrPerfYr1Rmrk() {
		return model.getDlrPerfYr1Rmrk();
	}

	/**
	 * Returns the dlr perf yr2 of this dgf dlr perf dtls.
	 *
	 * @return the dlr perf yr2 of this dgf dlr perf dtls
	 */
	@Override
	public long getDlrPerfYr2() {
		return model.getDlrPerfYr2();
	}

	/**
	 * Returns the dlr perf yr2 alloc qty of this dgf dlr perf dtls.
	 *
	 * @return the dlr perf yr2 alloc qty of this dgf dlr perf dtls
	 */
	@Override
	public long getDlrPerfYr2AllocQty() {
		return model.getDlrPerfYr2AllocQty();
	}

	/**
	 * Returns the dlr perf yr2 comdty qty of this dgf dlr perf dtls.
	 *
	 * @return the dlr perf yr2 comdty qty of this dgf dlr perf dtls
	 */
	@Override
	public long getDlrPerfYr2ComdtyQty() {
		return model.getDlrPerfYr2ComdtyQty();
	}

	/**
	 * Returns the dlr perf yr2 dlr ctgry of this dgf dlr perf dtls.
	 *
	 * @return the dlr perf yr2 dlr ctgry of this dgf dlr perf dtls
	 */
	@Override
	public String getDlrPerfYr2DlrCtgry() {
		return model.getDlrPerfYr2DlrCtgry();
	}

	/**
	 * Returns the dlr perf yr2 rmrk of this dgf dlr perf dtls.
	 *
	 * @return the dlr perf yr2 rmrk of this dgf dlr perf dtls
	 */
	@Override
	public String getDlrPerfYr2Rmrk() {
		return model.getDlrPerfYr2Rmrk();
	}

	/**
	 * Returns the dlr perf yr3 of this dgf dlr perf dtls.
	 *
	 * @return the dlr perf yr3 of this dgf dlr perf dtls
	 */
	@Override
	public long getDlrPerfYr3() {
		return model.getDlrPerfYr3();
	}

	/**
	 * Returns the dlr perf yr3 alloc qty of this dgf dlr perf dtls.
	 *
	 * @return the dlr perf yr3 alloc qty of this dgf dlr perf dtls
	 */
	@Override
	public long getDlrPerfYr3AllocQty() {
		return model.getDlrPerfYr3AllocQty();
	}

	/**
	 * Returns the dlr perf yr3 comdty qty of this dgf dlr perf dtls.
	 *
	 * @return the dlr perf yr3 comdty qty of this dgf dlr perf dtls
	 */
	@Override
	public long getDlrPerfYr3ComdtyQty() {
		return model.getDlrPerfYr3ComdtyQty();
	}

	/**
	 * Returns the dlr perf yr3 dlr ctgry of this dgf dlr perf dtls.
	 *
	 * @return the dlr perf yr3 dlr ctgry of this dgf dlr perf dtls
	 */
	@Override
	public String getDlrPerfYr3DlrCtgry() {
		return model.getDlrPerfYr3DlrCtgry();
	}

	/**
	 * Returns the dlr perf yr3 rmrk of this dgf dlr perf dtls.
	 *
	 * @return the dlr perf yr3 rmrk of this dgf dlr perf dtls
	 */
	@Override
	public String getDlrPerfYr3Rmrk() {
		return model.getDlrPerfYr3Rmrk();
	}

	/**
	 * Returns the dlr reg appl no of this dgf dlr perf dtls.
	 *
	 * @return the dlr reg appl no of this dgf dlr perf dtls
	 */
	@Override
	public long getDlrRegApplNo() {
		return model.getDlrRegApplNo();
	}

	/**
	 * Returns the dlr reg no of this dgf dlr perf dtls.
	 *
	 * @return the dlr reg no of this dgf dlr perf dtls
	 */
	@Override
	public long getDlrRegNo() {
		return model.getDlrRegNo();
	}

	/**
	 * Returns the national ID of this dgf dlr perf dtls.
	 *
	 * @return the national ID of this dgf dlr perf dtls
	 */
	@Override
	public String getNationalId() {
		return model.getNationalId();
	}

	/**
	 * Returns the primary key of this dgf dlr perf dtls.
	 *
	 * @return the primary key of this dgf dlr perf dtls
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the version of this dgf dlr perf dtls.
	 *
	 * @return the version of this dgf dlr perf dtls
	 */
	@Override
	public long getVersion() {
		return model.getVersion();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the dgf dlr perf ID of this dgf dlr perf dtls.
	 *
	 * @param dgfDlrPerfId the dgf dlr perf ID of this dgf dlr perf dtls
	 */
	@Override
	public void setDgfDlrPerfId(long dgfDlrPerfId) {
		model.setDgfDlrPerfId(dgfDlrPerfId);
	}

	/**
	 * Sets the dlr perf yr1 of this dgf dlr perf dtls.
	 *
	 * @param dlrPerfYr1 the dlr perf yr1 of this dgf dlr perf dtls
	 */
	@Override
	public void setDlrPerfYr1(long dlrPerfYr1) {
		model.setDlrPerfYr1(dlrPerfYr1);
	}

	/**
	 * Sets the dlr perf yr1 alloc qty of this dgf dlr perf dtls.
	 *
	 * @param dlrPerfYr1AllocQty the dlr perf yr1 alloc qty of this dgf dlr perf dtls
	 */
	@Override
	public void setDlrPerfYr1AllocQty(long dlrPerfYr1AllocQty) {
		model.setDlrPerfYr1AllocQty(dlrPerfYr1AllocQty);
	}

	/**
	 * Sets the dlr perf yr1 comdty qty of this dgf dlr perf dtls.
	 *
	 * @param dlrPerfYr1ComdtyQty the dlr perf yr1 comdty qty of this dgf dlr perf dtls
	 */
	@Override
	public void setDlrPerfYr1ComdtyQty(long dlrPerfYr1ComdtyQty) {
		model.setDlrPerfYr1ComdtyQty(dlrPerfYr1ComdtyQty);
	}

	/**
	 * Sets the dlr perf yr1 dlr ctgry of this dgf dlr perf dtls.
	 *
	 * @param dlrPerfYr1DlrCtgry the dlr perf yr1 dlr ctgry of this dgf dlr perf dtls
	 */
	@Override
	public void setDlrPerfYr1DlrCtgry(String dlrPerfYr1DlrCtgry) {
		model.setDlrPerfYr1DlrCtgry(dlrPerfYr1DlrCtgry);
	}

	/**
	 * Sets the dlr perf yr1 rmrk of this dgf dlr perf dtls.
	 *
	 * @param dlrPerfYr1Rmrk the dlr perf yr1 rmrk of this dgf dlr perf dtls
	 */
	@Override
	public void setDlrPerfYr1Rmrk(String dlrPerfYr1Rmrk) {
		model.setDlrPerfYr1Rmrk(dlrPerfYr1Rmrk);
	}

	/**
	 * Sets the dlr perf yr2 of this dgf dlr perf dtls.
	 *
	 * @param dlrPerfYr2 the dlr perf yr2 of this dgf dlr perf dtls
	 */
	@Override
	public void setDlrPerfYr2(long dlrPerfYr2) {
		model.setDlrPerfYr2(dlrPerfYr2);
	}

	/**
	 * Sets the dlr perf yr2 alloc qty of this dgf dlr perf dtls.
	 *
	 * @param dlrPerfYr2AllocQty the dlr perf yr2 alloc qty of this dgf dlr perf dtls
	 */
	@Override
	public void setDlrPerfYr2AllocQty(long dlrPerfYr2AllocQty) {
		model.setDlrPerfYr2AllocQty(dlrPerfYr2AllocQty);
	}

	/**
	 * Sets the dlr perf yr2 comdty qty of this dgf dlr perf dtls.
	 *
	 * @param dlrPerfYr2ComdtyQty the dlr perf yr2 comdty qty of this dgf dlr perf dtls
	 */
	@Override
	public void setDlrPerfYr2ComdtyQty(long dlrPerfYr2ComdtyQty) {
		model.setDlrPerfYr2ComdtyQty(dlrPerfYr2ComdtyQty);
	}

	/**
	 * Sets the dlr perf yr2 dlr ctgry of this dgf dlr perf dtls.
	 *
	 * @param dlrPerfYr2DlrCtgry the dlr perf yr2 dlr ctgry of this dgf dlr perf dtls
	 */
	@Override
	public void setDlrPerfYr2DlrCtgry(String dlrPerfYr2DlrCtgry) {
		model.setDlrPerfYr2DlrCtgry(dlrPerfYr2DlrCtgry);
	}

	/**
	 * Sets the dlr perf yr2 rmrk of this dgf dlr perf dtls.
	 *
	 * @param dlrPerfYr2Rmrk the dlr perf yr2 rmrk of this dgf dlr perf dtls
	 */
	@Override
	public void setDlrPerfYr2Rmrk(String dlrPerfYr2Rmrk) {
		model.setDlrPerfYr2Rmrk(dlrPerfYr2Rmrk);
	}

	/**
	 * Sets the dlr perf yr3 of this dgf dlr perf dtls.
	 *
	 * @param dlrPerfYr3 the dlr perf yr3 of this dgf dlr perf dtls
	 */
	@Override
	public void setDlrPerfYr3(long dlrPerfYr3) {
		model.setDlrPerfYr3(dlrPerfYr3);
	}

	/**
	 * Sets the dlr perf yr3 alloc qty of this dgf dlr perf dtls.
	 *
	 * @param dlrPerfYr3AllocQty the dlr perf yr3 alloc qty of this dgf dlr perf dtls
	 */
	@Override
	public void setDlrPerfYr3AllocQty(long dlrPerfYr3AllocQty) {
		model.setDlrPerfYr3AllocQty(dlrPerfYr3AllocQty);
	}

	/**
	 * Sets the dlr perf yr3 comdty qty of this dgf dlr perf dtls.
	 *
	 * @param dlrPerfYr3ComdtyQty the dlr perf yr3 comdty qty of this dgf dlr perf dtls
	 */
	@Override
	public void setDlrPerfYr3ComdtyQty(long dlrPerfYr3ComdtyQty) {
		model.setDlrPerfYr3ComdtyQty(dlrPerfYr3ComdtyQty);
	}

	/**
	 * Sets the dlr perf yr3 dlr ctgry of this dgf dlr perf dtls.
	 *
	 * @param dlrPerfYr3DlrCtgry the dlr perf yr3 dlr ctgry of this dgf dlr perf dtls
	 */
	@Override
	public void setDlrPerfYr3DlrCtgry(String dlrPerfYr3DlrCtgry) {
		model.setDlrPerfYr3DlrCtgry(dlrPerfYr3DlrCtgry);
	}

	/**
	 * Sets the dlr perf yr3 rmrk of this dgf dlr perf dtls.
	 *
	 * @param dlrPerfYr3Rmrk the dlr perf yr3 rmrk of this dgf dlr perf dtls
	 */
	@Override
	public void setDlrPerfYr3Rmrk(String dlrPerfYr3Rmrk) {
		model.setDlrPerfYr3Rmrk(dlrPerfYr3Rmrk);
	}

	/**
	 * Sets the dlr reg appl no of this dgf dlr perf dtls.
	 *
	 * @param dlrRegApplNo the dlr reg appl no of this dgf dlr perf dtls
	 */
	@Override
	public void setDlrRegApplNo(long dlrRegApplNo) {
		model.setDlrRegApplNo(dlrRegApplNo);
	}

	/**
	 * Sets the dlr reg no of this dgf dlr perf dtls.
	 *
	 * @param dlrRegNo the dlr reg no of this dgf dlr perf dtls
	 */
	@Override
	public void setDlrRegNo(long dlrRegNo) {
		model.setDlrRegNo(dlrRegNo);
	}

	/**
	 * Sets the national ID of this dgf dlr perf dtls.
	 *
	 * @param nationalId the national ID of this dgf dlr perf dtls
	 */
	@Override
	public void setNationalId(String nationalId) {
		model.setNationalId(nationalId);
	}

	/**
	 * Sets the primary key of this dgf dlr perf dtls.
	 *
	 * @param primaryKey the primary key of this dgf dlr perf dtls
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the version of this dgf dlr perf dtls.
	 *
	 * @param version the version of this dgf dlr perf dtls
	 */
	@Override
	public void setVersion(long version) {
		model.setVersion(version);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DgfDlrPerfDtlsWrapper wrap(DgfDlrPerfDtls dgfDlrPerfDtls) {
		return new DgfDlrPerfDtlsWrapper(dgfDlrPerfDtls);
	}

}