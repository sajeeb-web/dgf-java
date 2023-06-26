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
 * This class is a wrapper for {@link DgfFglLicDtls}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfFglLicDtls
 * @generated
 */
public class DgfFglLicDtlsWrapper
	extends BaseModelWrapper<DgfFglLicDtls>
	implements DgfFglLicDtls, ModelWrapper<DgfFglLicDtls> {

	public DgfFglLicDtlsWrapper(DgfFglLicDtls dgfFglLicDtls) {
		super(dgfFglLicDtls);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("fglLicPrimaryId", getFglLicPrimaryId());
		attributes.put("nationalId", getNationalId());
		attributes.put("fglPrePrimaryId", getFglPrePrimaryId());
		attributes.put("fglApplicationNo", getFglApplicationNo());
		attributes.put("foodgrainLicenseNo", getFoodgrainLicenseNo());
		attributes.put("foodgrainLicenseType", getFoodgrainLicenseType());
		attributes.put("tradeLicenseNo", getTradeLicenseNo());
		attributes.put("tradeLicenseExpiryDate", getTradeLicenseExpiryDate());
		attributes.put(
			"foodgrainLicenseIssueDate", getFoodgrainLicenseIssueDate());
		attributes.put(
			"foodgrainLicenseExpiryDate", getFoodgrainLicenseExpiryDate());
		attributes.put(
			"foodgrainLicenseIssuedBy", getFoodgrainLicenseIssuedBy());
		attributes.put("fglLicenseVersion", getFglLicenseVersion());
		attributes.put("productType", getProductType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long fglLicPrimaryId = (Long)attributes.get("fglLicPrimaryId");

		if (fglLicPrimaryId != null) {
			setFglLicPrimaryId(fglLicPrimaryId);
		}

		String nationalId = (String)attributes.get("nationalId");

		if (nationalId != null) {
			setNationalId(nationalId);
		}

		Long fglPrePrimaryId = (Long)attributes.get("fglPrePrimaryId");

		if (fglPrePrimaryId != null) {
			setFglPrePrimaryId(fglPrePrimaryId);
		}

		String fglApplicationNo = (String)attributes.get("fglApplicationNo");

		if (fglApplicationNo != null) {
			setFglApplicationNo(fglApplicationNo);
		}

		String foodgrainLicenseNo = (String)attributes.get(
			"foodgrainLicenseNo");

		if (foodgrainLicenseNo != null) {
			setFoodgrainLicenseNo(foodgrainLicenseNo);
		}

		String foodgrainLicenseType = (String)attributes.get(
			"foodgrainLicenseType");

		if (foodgrainLicenseType != null) {
			setFoodgrainLicenseType(foodgrainLicenseType);
		}

		String tradeLicenseNo = (String)attributes.get("tradeLicenseNo");

		if (tradeLicenseNo != null) {
			setTradeLicenseNo(tradeLicenseNo);
		}

		Date tradeLicenseExpiryDate = (Date)attributes.get(
			"tradeLicenseExpiryDate");

		if (tradeLicenseExpiryDate != null) {
			setTradeLicenseExpiryDate(tradeLicenseExpiryDate);
		}

		Date foodgrainLicenseIssueDate = (Date)attributes.get(
			"foodgrainLicenseIssueDate");

		if (foodgrainLicenseIssueDate != null) {
			setFoodgrainLicenseIssueDate(foodgrainLicenseIssueDate);
		}

		Date foodgrainLicenseExpiryDate = (Date)attributes.get(
			"foodgrainLicenseExpiryDate");

		if (foodgrainLicenseExpiryDate != null) {
			setFoodgrainLicenseExpiryDate(foodgrainLicenseExpiryDate);
		}

		Long foodgrainLicenseIssuedBy = (Long)attributes.get(
			"foodgrainLicenseIssuedBy");

		if (foodgrainLicenseIssuedBy != null) {
			setFoodgrainLicenseIssuedBy(foodgrainLicenseIssuedBy);
		}

		Long fglLicenseVersion = (Long)attributes.get("fglLicenseVersion");

		if (fglLicenseVersion != null) {
			setFglLicenseVersion(fglLicenseVersion);
		}

		String productType = (String)attributes.get("productType");

		if (productType != null) {
			setProductType(productType);
		}
	}

	@Override
	public DgfFglLicDtls cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the fgl application no of this dgf fgl lic dtls.
	 *
	 * @return the fgl application no of this dgf fgl lic dtls
	 */
	@Override
	public String getFglApplicationNo() {
		return model.getFglApplicationNo();
	}

	/**
	 * Returns the fgl license version of this dgf fgl lic dtls.
	 *
	 * @return the fgl license version of this dgf fgl lic dtls
	 */
	@Override
	public long getFglLicenseVersion() {
		return model.getFglLicenseVersion();
	}

	/**
	 * Returns the fgl lic primary ID of this dgf fgl lic dtls.
	 *
	 * @return the fgl lic primary ID of this dgf fgl lic dtls
	 */
	@Override
	public long getFglLicPrimaryId() {
		return model.getFglLicPrimaryId();
	}

	/**
	 * Returns the fgl pre primary ID of this dgf fgl lic dtls.
	 *
	 * @return the fgl pre primary ID of this dgf fgl lic dtls
	 */
	@Override
	public long getFglPrePrimaryId() {
		return model.getFglPrePrimaryId();
	}

	/**
	 * Returns the foodgrain license expiry date of this dgf fgl lic dtls.
	 *
	 * @return the foodgrain license expiry date of this dgf fgl lic dtls
	 */
	@Override
	public Date getFoodgrainLicenseExpiryDate() {
		return model.getFoodgrainLicenseExpiryDate();
	}

	/**
	 * Returns the foodgrain license issue date of this dgf fgl lic dtls.
	 *
	 * @return the foodgrain license issue date of this dgf fgl lic dtls
	 */
	@Override
	public Date getFoodgrainLicenseIssueDate() {
		return model.getFoodgrainLicenseIssueDate();
	}

	/**
	 * Returns the foodgrain license issued by of this dgf fgl lic dtls.
	 *
	 * @return the foodgrain license issued by of this dgf fgl lic dtls
	 */
	@Override
	public long getFoodgrainLicenseIssuedBy() {
		return model.getFoodgrainLicenseIssuedBy();
	}

	/**
	 * Returns the foodgrain license no of this dgf fgl lic dtls.
	 *
	 * @return the foodgrain license no of this dgf fgl lic dtls
	 */
	@Override
	public String getFoodgrainLicenseNo() {
		return model.getFoodgrainLicenseNo();
	}

	/**
	 * Returns the foodgrain license type of this dgf fgl lic dtls.
	 *
	 * @return the foodgrain license type of this dgf fgl lic dtls
	 */
	@Override
	public String getFoodgrainLicenseType() {
		return model.getFoodgrainLicenseType();
	}

	/**
	 * Returns the national ID of this dgf fgl lic dtls.
	 *
	 * @return the national ID of this dgf fgl lic dtls
	 */
	@Override
	public String getNationalId() {
		return model.getNationalId();
	}

	/**
	 * Returns the primary key of this dgf fgl lic dtls.
	 *
	 * @return the primary key of this dgf fgl lic dtls
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product type of this dgf fgl lic dtls.
	 *
	 * @return the product type of this dgf fgl lic dtls
	 */
	@Override
	public String getProductType() {
		return model.getProductType();
	}

	/**
	 * Returns the trade license expiry date of this dgf fgl lic dtls.
	 *
	 * @return the trade license expiry date of this dgf fgl lic dtls
	 */
	@Override
	public Date getTradeLicenseExpiryDate() {
		return model.getTradeLicenseExpiryDate();
	}

	/**
	 * Returns the trade license no of this dgf fgl lic dtls.
	 *
	 * @return the trade license no of this dgf fgl lic dtls
	 */
	@Override
	public String getTradeLicenseNo() {
		return model.getTradeLicenseNo();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the fgl application no of this dgf fgl lic dtls.
	 *
	 * @param fglApplicationNo the fgl application no of this dgf fgl lic dtls
	 */
	@Override
	public void setFglApplicationNo(String fglApplicationNo) {
		model.setFglApplicationNo(fglApplicationNo);
	}

	/**
	 * Sets the fgl license version of this dgf fgl lic dtls.
	 *
	 * @param fglLicenseVersion the fgl license version of this dgf fgl lic dtls
	 */
	@Override
	public void setFglLicenseVersion(long fglLicenseVersion) {
		model.setFglLicenseVersion(fglLicenseVersion);
	}

	/**
	 * Sets the fgl lic primary ID of this dgf fgl lic dtls.
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID of this dgf fgl lic dtls
	 */
	@Override
	public void setFglLicPrimaryId(long fglLicPrimaryId) {
		model.setFglLicPrimaryId(fglLicPrimaryId);
	}

	/**
	 * Sets the fgl pre primary ID of this dgf fgl lic dtls.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID of this dgf fgl lic dtls
	 */
	@Override
	public void setFglPrePrimaryId(long fglPrePrimaryId) {
		model.setFglPrePrimaryId(fglPrePrimaryId);
	}

	/**
	 * Sets the foodgrain license expiry date of this dgf fgl lic dtls.
	 *
	 * @param foodgrainLicenseExpiryDate the foodgrain license expiry date of this dgf fgl lic dtls
	 */
	@Override
	public void setFoodgrainLicenseExpiryDate(Date foodgrainLicenseExpiryDate) {
		model.setFoodgrainLicenseExpiryDate(foodgrainLicenseExpiryDate);
	}

	/**
	 * Sets the foodgrain license issue date of this dgf fgl lic dtls.
	 *
	 * @param foodgrainLicenseIssueDate the foodgrain license issue date of this dgf fgl lic dtls
	 */
	@Override
	public void setFoodgrainLicenseIssueDate(Date foodgrainLicenseIssueDate) {
		model.setFoodgrainLicenseIssueDate(foodgrainLicenseIssueDate);
	}

	/**
	 * Sets the foodgrain license issued by of this dgf fgl lic dtls.
	 *
	 * @param foodgrainLicenseIssuedBy the foodgrain license issued by of this dgf fgl lic dtls
	 */
	@Override
	public void setFoodgrainLicenseIssuedBy(long foodgrainLicenseIssuedBy) {
		model.setFoodgrainLicenseIssuedBy(foodgrainLicenseIssuedBy);
	}

	/**
	 * Sets the foodgrain license no of this dgf fgl lic dtls.
	 *
	 * @param foodgrainLicenseNo the foodgrain license no of this dgf fgl lic dtls
	 */
	@Override
	public void setFoodgrainLicenseNo(String foodgrainLicenseNo) {
		model.setFoodgrainLicenseNo(foodgrainLicenseNo);
	}

	/**
	 * Sets the foodgrain license type of this dgf fgl lic dtls.
	 *
	 * @param foodgrainLicenseType the foodgrain license type of this dgf fgl lic dtls
	 */
	@Override
	public void setFoodgrainLicenseType(String foodgrainLicenseType) {
		model.setFoodgrainLicenseType(foodgrainLicenseType);
	}

	/**
	 * Sets the national ID of this dgf fgl lic dtls.
	 *
	 * @param nationalId the national ID of this dgf fgl lic dtls
	 */
	@Override
	public void setNationalId(String nationalId) {
		model.setNationalId(nationalId);
	}

	/**
	 * Sets the primary key of this dgf fgl lic dtls.
	 *
	 * @param primaryKey the primary key of this dgf fgl lic dtls
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product type of this dgf fgl lic dtls.
	 *
	 * @param productType the product type of this dgf fgl lic dtls
	 */
	@Override
	public void setProductType(String productType) {
		model.setProductType(productType);
	}

	/**
	 * Sets the trade license expiry date of this dgf fgl lic dtls.
	 *
	 * @param tradeLicenseExpiryDate the trade license expiry date of this dgf fgl lic dtls
	 */
	@Override
	public void setTradeLicenseExpiryDate(Date tradeLicenseExpiryDate) {
		model.setTradeLicenseExpiryDate(tradeLicenseExpiryDate);
	}

	/**
	 * Sets the trade license no of this dgf fgl lic dtls.
	 *
	 * @param tradeLicenseNo the trade license no of this dgf fgl lic dtls
	 */
	@Override
	public void setTradeLicenseNo(String tradeLicenseNo) {
		model.setTradeLicenseNo(tradeLicenseNo);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DgfFglLicDtlsWrapper wrap(DgfFglLicDtls dgfFglLicDtls) {
		return new DgfFglLicDtlsWrapper(dgfFglLicDtls);
	}

}