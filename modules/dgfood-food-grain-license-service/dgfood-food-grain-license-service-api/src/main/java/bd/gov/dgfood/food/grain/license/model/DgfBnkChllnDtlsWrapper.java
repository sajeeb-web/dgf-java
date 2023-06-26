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

package bd.gov.dgfood.food.grain.license.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DgfBnkChllnDtls}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfBnkChllnDtls
 * @generated
 */
public class DgfBnkChllnDtlsWrapper
	extends BaseModelWrapper<DgfBnkChllnDtls>
	implements DgfBnkChllnDtls, ModelWrapper<DgfBnkChllnDtls> {

	public DgfBnkChllnDtlsWrapper(DgfBnkChllnDtls dgfBnkChllnDtls) {
		super(dgfBnkChllnDtls);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bnkChllnId", getBnkChllnId());
		attributes.put("trnPoNo", getTrnPoNo());
		attributes.put("paymentStatus", getPaymentStatus());
		attributes.put("trnAmount", getTrnAmount());
		attributes.put("pymntChllnDate", getPymntChllnDate());
		attributes.put("bnkChllnDocId", getBnkChllnDocId());
		attributes.put("bnkChllnUpldBy", getBnkChllnUpldBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bnkChllnId = (Long)attributes.get("bnkChllnId");

		if (bnkChllnId != null) {
			setBnkChllnId(bnkChllnId);
		}

		Long trnPoNo = (Long)attributes.get("trnPoNo");

		if (trnPoNo != null) {
			setTrnPoNo(trnPoNo);
		}

		Long paymentStatus = (Long)attributes.get("paymentStatus");

		if (paymentStatus != null) {
			setPaymentStatus(paymentStatus);
		}

		Long trnAmount = (Long)attributes.get("trnAmount");

		if (trnAmount != null) {
			setTrnAmount(trnAmount);
		}

		Date pymntChllnDate = (Date)attributes.get("pymntChllnDate");

		if (pymntChllnDate != null) {
			setPymntChllnDate(pymntChllnDate);
		}

		Long bnkChllnDocId = (Long)attributes.get("bnkChllnDocId");

		if (bnkChllnDocId != null) {
			setBnkChllnDocId(bnkChllnDocId);
		}

		Long bnkChllnUpldBy = (Long)attributes.get("bnkChllnUpldBy");

		if (bnkChllnUpldBy != null) {
			setBnkChllnUpldBy(bnkChllnUpldBy);
		}
	}

	@Override
	public DgfBnkChllnDtls cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the bnk chlln doc ID of this dgf bnk chlln dtls.
	 *
	 * @return the bnk chlln doc ID of this dgf bnk chlln dtls
	 */
	@Override
	public long getBnkChllnDocId() {
		return model.getBnkChllnDocId();
	}

	/**
	 * Returns the bnk chlln ID of this dgf bnk chlln dtls.
	 *
	 * @return the bnk chlln ID of this dgf bnk chlln dtls
	 */
	@Override
	public long getBnkChllnId() {
		return model.getBnkChllnId();
	}

	/**
	 * Returns the bnk chlln upld by of this dgf bnk chlln dtls.
	 *
	 * @return the bnk chlln upld by of this dgf bnk chlln dtls
	 */
	@Override
	public long getBnkChllnUpldBy() {
		return model.getBnkChllnUpldBy();
	}

	/**
	 * Returns the payment status of this dgf bnk chlln dtls.
	 *
	 * @return the payment status of this dgf bnk chlln dtls
	 */
	@Override
	public long getPaymentStatus() {
		return model.getPaymentStatus();
	}

	/**
	 * Returns the primary key of this dgf bnk chlln dtls.
	 *
	 * @return the primary key of this dgf bnk chlln dtls
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the pymnt chlln date of this dgf bnk chlln dtls.
	 *
	 * @return the pymnt chlln date of this dgf bnk chlln dtls
	 */
	@Override
	public Date getPymntChllnDate() {
		return model.getPymntChllnDate();
	}

	/**
	 * Returns the trn amount of this dgf bnk chlln dtls.
	 *
	 * @return the trn amount of this dgf bnk chlln dtls
	 */
	@Override
	public long getTrnAmount() {
		return model.getTrnAmount();
	}

	/**
	 * Returns the trn po no of this dgf bnk chlln dtls.
	 *
	 * @return the trn po no of this dgf bnk chlln dtls
	 */
	@Override
	public long getTrnPoNo() {
		return model.getTrnPoNo();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the bnk chlln doc ID of this dgf bnk chlln dtls.
	 *
	 * @param bnkChllnDocId the bnk chlln doc ID of this dgf bnk chlln dtls
	 */
	@Override
	public void setBnkChllnDocId(long bnkChllnDocId) {
		model.setBnkChllnDocId(bnkChllnDocId);
	}

	/**
	 * Sets the bnk chlln ID of this dgf bnk chlln dtls.
	 *
	 * @param bnkChllnId the bnk chlln ID of this dgf bnk chlln dtls
	 */
	@Override
	public void setBnkChllnId(long bnkChllnId) {
		model.setBnkChllnId(bnkChllnId);
	}

	/**
	 * Sets the bnk chlln upld by of this dgf bnk chlln dtls.
	 *
	 * @param bnkChllnUpldBy the bnk chlln upld by of this dgf bnk chlln dtls
	 */
	@Override
	public void setBnkChllnUpldBy(long bnkChllnUpldBy) {
		model.setBnkChllnUpldBy(bnkChllnUpldBy);
	}

	/**
	 * Sets the payment status of this dgf bnk chlln dtls.
	 *
	 * @param paymentStatus the payment status of this dgf bnk chlln dtls
	 */
	@Override
	public void setPaymentStatus(long paymentStatus) {
		model.setPaymentStatus(paymentStatus);
	}

	/**
	 * Sets the primary key of this dgf bnk chlln dtls.
	 *
	 * @param primaryKey the primary key of this dgf bnk chlln dtls
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the pymnt chlln date of this dgf bnk chlln dtls.
	 *
	 * @param pymntChllnDate the pymnt chlln date of this dgf bnk chlln dtls
	 */
	@Override
	public void setPymntChllnDate(Date pymntChllnDate) {
		model.setPymntChllnDate(pymntChllnDate);
	}

	/**
	 * Sets the trn amount of this dgf bnk chlln dtls.
	 *
	 * @param trnAmount the trn amount of this dgf bnk chlln dtls
	 */
	@Override
	public void setTrnAmount(long trnAmount) {
		model.setTrnAmount(trnAmount);
	}

	/**
	 * Sets the trn po no of this dgf bnk chlln dtls.
	 *
	 * @param trnPoNo the trn po no of this dgf bnk chlln dtls
	 */
	@Override
	public void setTrnPoNo(long trnPoNo) {
		model.setTrnPoNo(trnPoNo);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DgfBnkChllnDtlsWrapper wrap(DgfBnkChllnDtls dgfBnkChllnDtls) {
		return new DgfBnkChllnDtlsWrapper(dgfBnkChllnDtls);
	}

}