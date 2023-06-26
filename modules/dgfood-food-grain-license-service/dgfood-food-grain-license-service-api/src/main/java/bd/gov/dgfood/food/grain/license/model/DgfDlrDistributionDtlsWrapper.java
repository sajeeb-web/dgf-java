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
 * This class is a wrapper for {@link DgfDlrDistributionDtls}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrDistributionDtls
 * @generated
 */
public class DgfDlrDistributionDtlsWrapper
	extends BaseModelWrapper<DgfDlrDistributionDtls>
	implements DgfDlrDistributionDtls, ModelWrapper<DgfDlrDistributionDtls> {

	public DgfDlrDistributionDtlsWrapper(
		DgfDlrDistributionDtls dgfDlrDistributionDtls) {

		super(dgfDlrDistributionDtls);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("dealerId", getDealerId());
		attributes.put("beneficiariesId", getBeneficiariesId());
		attributes.put("beneficiariesMobileNo", getBeneficiariesMobileNo());
		attributes.put("cardNo", getCardNo());
		attributes.put("unionId", getUnionId());
		attributes.put("distributionDate", getDistributionDate());
		attributes.put("distributionQty", getDistributionQty());
		attributes.put("status", getStatus());
		attributes.put("createdAt", getCreatedAt());
		attributes.put("updatedAt", getUpdatedAt());
		attributes.put("month", getMonth());
		attributes.put("year", getYear());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long dealerId = (Long)attributes.get("dealerId");

		if (dealerId != null) {
			setDealerId(dealerId);
		}

		Long beneficiariesId = (Long)attributes.get("beneficiariesId");

		if (beneficiariesId != null) {
			setBeneficiariesId(beneficiariesId);
		}

		String beneficiariesMobileNo = (String)attributes.get(
			"beneficiariesMobileNo");

		if (beneficiariesMobileNo != null) {
			setBeneficiariesMobileNo(beneficiariesMobileNo);
		}

		Long cardNo = (Long)attributes.get("cardNo");

		if (cardNo != null) {
			setCardNo(cardNo);
		}

		Long unionId = (Long)attributes.get("unionId");

		if (unionId != null) {
			setUnionId(unionId);
		}

		Date distributionDate = (Date)attributes.get("distributionDate");

		if (distributionDate != null) {
			setDistributionDate(distributionDate);
		}

		Long distributionQty = (Long)attributes.get("distributionQty");

		if (distributionQty != null) {
			setDistributionQty(distributionQty);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date createdAt = (Date)attributes.get("createdAt");

		if (createdAt != null) {
			setCreatedAt(createdAt);
		}

		Date updatedAt = (Date)attributes.get("updatedAt");

		if (updatedAt != null) {
			setUpdatedAt(updatedAt);
		}

		Integer month = (Integer)attributes.get("month");

		if (month != null) {
			setMonth(month);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
		}
	}

	@Override
	public DgfDlrDistributionDtls cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the beneficiaries ID of this dgf dlr distribution dtls.
	 *
	 * @return the beneficiaries ID of this dgf dlr distribution dtls
	 */
	@Override
	public long getBeneficiariesId() {
		return model.getBeneficiariesId();
	}

	/**
	 * Returns the beneficiaries mobile no of this dgf dlr distribution dtls.
	 *
	 * @return the beneficiaries mobile no of this dgf dlr distribution dtls
	 */
	@Override
	public String getBeneficiariesMobileNo() {
		return model.getBeneficiariesMobileNo();
	}

	/**
	 * Returns the card no of this dgf dlr distribution dtls.
	 *
	 * @return the card no of this dgf dlr distribution dtls
	 */
	@Override
	public long getCardNo() {
		return model.getCardNo();
	}

	/**
	 * Returns the created at of this dgf dlr distribution dtls.
	 *
	 * @return the created at of this dgf dlr distribution dtls
	 */
	@Override
	public Date getCreatedAt() {
		return model.getCreatedAt();
	}

	/**
	 * Returns the dealer ID of this dgf dlr distribution dtls.
	 *
	 * @return the dealer ID of this dgf dlr distribution dtls
	 */
	@Override
	public long getDealerId() {
		return model.getDealerId();
	}

	/**
	 * Returns the distribution date of this dgf dlr distribution dtls.
	 *
	 * @return the distribution date of this dgf dlr distribution dtls
	 */
	@Override
	public Date getDistributionDate() {
		return model.getDistributionDate();
	}

	/**
	 * Returns the distribution qty of this dgf dlr distribution dtls.
	 *
	 * @return the distribution qty of this dgf dlr distribution dtls
	 */
	@Override
	public long getDistributionQty() {
		return model.getDistributionQty();
	}

	/**
	 * Returns the ID of this dgf dlr distribution dtls.
	 *
	 * @return the ID of this dgf dlr distribution dtls
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the month of this dgf dlr distribution dtls.
	 *
	 * @return the month of this dgf dlr distribution dtls
	 */
	@Override
	public int getMonth() {
		return model.getMonth();
	}

	/**
	 * Returns the primary key of this dgf dlr distribution dtls.
	 *
	 * @return the primary key of this dgf dlr distribution dtls
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this dgf dlr distribution dtls.
	 *
	 * @return the status of this dgf dlr distribution dtls
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the union ID of this dgf dlr distribution dtls.
	 *
	 * @return the union ID of this dgf dlr distribution dtls
	 */
	@Override
	public long getUnionId() {
		return model.getUnionId();
	}

	/**
	 * Returns the updated at of this dgf dlr distribution dtls.
	 *
	 * @return the updated at of this dgf dlr distribution dtls
	 */
	@Override
	public Date getUpdatedAt() {
		return model.getUpdatedAt();
	}

	/**
	 * Returns the year of this dgf dlr distribution dtls.
	 *
	 * @return the year of this dgf dlr distribution dtls
	 */
	@Override
	public int getYear() {
		return model.getYear();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the beneficiaries ID of this dgf dlr distribution dtls.
	 *
	 * @param beneficiariesId the beneficiaries ID of this dgf dlr distribution dtls
	 */
	@Override
	public void setBeneficiariesId(long beneficiariesId) {
		model.setBeneficiariesId(beneficiariesId);
	}

	/**
	 * Sets the beneficiaries mobile no of this dgf dlr distribution dtls.
	 *
	 * @param beneficiariesMobileNo the beneficiaries mobile no of this dgf dlr distribution dtls
	 */
	@Override
	public void setBeneficiariesMobileNo(String beneficiariesMobileNo) {
		model.setBeneficiariesMobileNo(beneficiariesMobileNo);
	}

	/**
	 * Sets the card no of this dgf dlr distribution dtls.
	 *
	 * @param cardNo the card no of this dgf dlr distribution dtls
	 */
	@Override
	public void setCardNo(long cardNo) {
		model.setCardNo(cardNo);
	}

	/**
	 * Sets the created at of this dgf dlr distribution dtls.
	 *
	 * @param createdAt the created at of this dgf dlr distribution dtls
	 */
	@Override
	public void setCreatedAt(Date createdAt) {
		model.setCreatedAt(createdAt);
	}

	/**
	 * Sets the dealer ID of this dgf dlr distribution dtls.
	 *
	 * @param dealerId the dealer ID of this dgf dlr distribution dtls
	 */
	@Override
	public void setDealerId(long dealerId) {
		model.setDealerId(dealerId);
	}

	/**
	 * Sets the distribution date of this dgf dlr distribution dtls.
	 *
	 * @param distributionDate the distribution date of this dgf dlr distribution dtls
	 */
	@Override
	public void setDistributionDate(Date distributionDate) {
		model.setDistributionDate(distributionDate);
	}

	/**
	 * Sets the distribution qty of this dgf dlr distribution dtls.
	 *
	 * @param distributionQty the distribution qty of this dgf dlr distribution dtls
	 */
	@Override
	public void setDistributionQty(long distributionQty) {
		model.setDistributionQty(distributionQty);
	}

	/**
	 * Sets the ID of this dgf dlr distribution dtls.
	 *
	 * @param id the ID of this dgf dlr distribution dtls
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the month of this dgf dlr distribution dtls.
	 *
	 * @param month the month of this dgf dlr distribution dtls
	 */
	@Override
	public void setMonth(int month) {
		model.setMonth(month);
	}

	/**
	 * Sets the primary key of this dgf dlr distribution dtls.
	 *
	 * @param primaryKey the primary key of this dgf dlr distribution dtls
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this dgf dlr distribution dtls.
	 *
	 * @param status the status of this dgf dlr distribution dtls
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the union ID of this dgf dlr distribution dtls.
	 *
	 * @param unionId the union ID of this dgf dlr distribution dtls
	 */
	@Override
	public void setUnionId(long unionId) {
		model.setUnionId(unionId);
	}

	/**
	 * Sets the updated at of this dgf dlr distribution dtls.
	 *
	 * @param updatedAt the updated at of this dgf dlr distribution dtls
	 */
	@Override
	public void setUpdatedAt(Date updatedAt) {
		model.setUpdatedAt(updatedAt);
	}

	/**
	 * Sets the year of this dgf dlr distribution dtls.
	 *
	 * @param year the year of this dgf dlr distribution dtls
	 */
	@Override
	public void setYear(int year) {
		model.setYear(year);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DgfDlrDistributionDtlsWrapper wrap(
		DgfDlrDistributionDtls dgfDlrDistributionDtls) {

		return new DgfDlrDistributionDtlsWrapper(dgfDlrDistributionDtls);
	}

}