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
 * This class is a wrapper for {@link DgfFglProductDtls}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfFglProductDtls
 * @generated
 */
public class DgfFglProductDtlsWrapper
	extends BaseModelWrapper<DgfFglProductDtls>
	implements DgfFglProductDtls, ModelWrapper<DgfFglProductDtls> {

	public DgfFglProductDtlsWrapper(DgfFglProductDtls dgfFglProductDtls) {
		super(dgfFglProductDtls);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("fglProductPrimaryId", getFglProductPrimaryId());
		attributes.put("nationalId", getNationalId());
		attributes.put("fglLicPrimaryId", getFglLicPrimaryId());
		attributes.put("productType", getProductType());
		attributes.put("stockDuration", getStockDuration());
		attributes.put("stockAmount", getStockAmount());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long fglProductPrimaryId = (Long)attributes.get("fglProductPrimaryId");

		if (fglProductPrimaryId != null) {
			setFglProductPrimaryId(fglProductPrimaryId);
		}

		String nationalId = (String)attributes.get("nationalId");

		if (nationalId != null) {
			setNationalId(nationalId);
		}

		Long fglLicPrimaryId = (Long)attributes.get("fglLicPrimaryId");

		if (fglLicPrimaryId != null) {
			setFglLicPrimaryId(fglLicPrimaryId);
		}

		String productType = (String)attributes.get("productType");

		if (productType != null) {
			setProductType(productType);
		}

		Long stockDuration = (Long)attributes.get("stockDuration");

		if (stockDuration != null) {
			setStockDuration(stockDuration);
		}

		Long stockAmount = (Long)attributes.get("stockAmount");

		if (stockAmount != null) {
			setStockAmount(stockAmount);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}
	}

	@Override
	public DgfFglProductDtls cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the created by of this dgf fgl product dtls.
	 *
	 * @return the created by of this dgf fgl product dtls
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the created date of this dgf fgl product dtls.
	 *
	 * @return the created date of this dgf fgl product dtls
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the fgl lic primary ID of this dgf fgl product dtls.
	 *
	 * @return the fgl lic primary ID of this dgf fgl product dtls
	 */
	@Override
	public long getFglLicPrimaryId() {
		return model.getFglLicPrimaryId();
	}

	/**
	 * Returns the fgl product primary ID of this dgf fgl product dtls.
	 *
	 * @return the fgl product primary ID of this dgf fgl product dtls
	 */
	@Override
	public long getFglProductPrimaryId() {
		return model.getFglProductPrimaryId();
	}

	/**
	 * Returns the modified by of this dgf fgl product dtls.
	 *
	 * @return the modified by of this dgf fgl product dtls
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this dgf fgl product dtls.
	 *
	 * @return the modified date of this dgf fgl product dtls
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the national ID of this dgf fgl product dtls.
	 *
	 * @return the national ID of this dgf fgl product dtls
	 */
	@Override
	public String getNationalId() {
		return model.getNationalId();
	}

	/**
	 * Returns the primary key of this dgf fgl product dtls.
	 *
	 * @return the primary key of this dgf fgl product dtls
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product type of this dgf fgl product dtls.
	 *
	 * @return the product type of this dgf fgl product dtls
	 */
	@Override
	public String getProductType() {
		return model.getProductType();
	}

	/**
	 * Returns the stock amount of this dgf fgl product dtls.
	 *
	 * @return the stock amount of this dgf fgl product dtls
	 */
	@Override
	public long getStockAmount() {
		return model.getStockAmount();
	}

	/**
	 * Returns the stock duration of this dgf fgl product dtls.
	 *
	 * @return the stock duration of this dgf fgl product dtls
	 */
	@Override
	public long getStockDuration() {
		return model.getStockDuration();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the created by of this dgf fgl product dtls.
	 *
	 * @param createdBy the created by of this dgf fgl product dtls
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the created date of this dgf fgl product dtls.
	 *
	 * @param createdDate the created date of this dgf fgl product dtls
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the fgl lic primary ID of this dgf fgl product dtls.
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID of this dgf fgl product dtls
	 */
	@Override
	public void setFglLicPrimaryId(long fglLicPrimaryId) {
		model.setFglLicPrimaryId(fglLicPrimaryId);
	}

	/**
	 * Sets the fgl product primary ID of this dgf fgl product dtls.
	 *
	 * @param fglProductPrimaryId the fgl product primary ID of this dgf fgl product dtls
	 */
	@Override
	public void setFglProductPrimaryId(long fglProductPrimaryId) {
		model.setFglProductPrimaryId(fglProductPrimaryId);
	}

	/**
	 * Sets the modified by of this dgf fgl product dtls.
	 *
	 * @param modifiedBy the modified by of this dgf fgl product dtls
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this dgf fgl product dtls.
	 *
	 * @param modifiedDate the modified date of this dgf fgl product dtls
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the national ID of this dgf fgl product dtls.
	 *
	 * @param nationalId the national ID of this dgf fgl product dtls
	 */
	@Override
	public void setNationalId(String nationalId) {
		model.setNationalId(nationalId);
	}

	/**
	 * Sets the primary key of this dgf fgl product dtls.
	 *
	 * @param primaryKey the primary key of this dgf fgl product dtls
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product type of this dgf fgl product dtls.
	 *
	 * @param productType the product type of this dgf fgl product dtls
	 */
	@Override
	public void setProductType(String productType) {
		model.setProductType(productType);
	}

	/**
	 * Sets the stock amount of this dgf fgl product dtls.
	 *
	 * @param stockAmount the stock amount of this dgf fgl product dtls
	 */
	@Override
	public void setStockAmount(long stockAmount) {
		model.setStockAmount(stockAmount);
	}

	/**
	 * Sets the stock duration of this dgf fgl product dtls.
	 *
	 * @param stockDuration the stock duration of this dgf fgl product dtls
	 */
	@Override
	public void setStockDuration(long stockDuration) {
		model.setStockDuration(stockDuration);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DgfFglProductDtlsWrapper wrap(
		DgfFglProductDtls dgfFglProductDtls) {

		return new DgfFglProductDtlsWrapper(dgfFglProductDtls);
	}

}