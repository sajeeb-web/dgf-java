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

package bd.gov.dgfood.food.friendly.program.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DlrFfpOmsAllcNtfyDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DlrFfpOmsAllcNtfyDetails
 * @generated
 */
public class DlrFfpOmsAllcNtfyDetailsWrapper
	extends BaseModelWrapper<DlrFfpOmsAllcNtfyDetails>
	implements DlrFfpOmsAllcNtfyDetails,
			   ModelWrapper<DlrFfpOmsAllcNtfyDetails> {

	public DlrFfpOmsAllcNtfyDetailsWrapper(
		DlrFfpOmsAllcNtfyDetails dlrFfpOmsAllcNtfyDetails) {

		super(dlrFfpOmsAllcNtfyDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("allocNtfyId", getAllocNtfyId());
		attributes.put("prgrmType", getPrgrmType());
		attributes.put("salesOrgName", getSalesOrgName());
		attributes.put("dstrbtnChnnl", getDstrbtnChnnl());
		attributes.put("year", getYear());
		attributes.put("salesOffice", getSalesOffice());
		attributes.put("memoNo", getMemoNo());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("duration", getDuration());
		attributes.put("commodityId", getCommodityId());
		attributes.put("commodityName", getCommodityName());
		attributes.put("econmcPrice", getEconmcPrice());
		attributes.put("salePrceToEndCstmr", getSalePrceToEndCstmr());
		attributes.put("unitPrice", getUnitPrice());
		attributes.put("maxAlltmntPDay", getMaxAlltmntPDay());
		attributes.put("maxSellQtyPCstmr", getMaxSellQtyPCstmr());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String allocNtfyId = (String)attributes.get("allocNtfyId");

		if (allocNtfyId != null) {
			setAllocNtfyId(allocNtfyId);
		}

		String prgrmType = (String)attributes.get("prgrmType");

		if (prgrmType != null) {
			setPrgrmType(prgrmType);
		}

		String salesOrgName = (String)attributes.get("salesOrgName");

		if (salesOrgName != null) {
			setSalesOrgName(salesOrgName);
		}

		String dstrbtnChnnl = (String)attributes.get("dstrbtnChnnl");

		if (dstrbtnChnnl != null) {
			setDstrbtnChnnl(dstrbtnChnnl);
		}

		Long year = (Long)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		String salesOffice = (String)attributes.get("salesOffice");

		if (salesOffice != null) {
			setSalesOffice(salesOffice);
		}

		String memoNo = (String)attributes.get("memoNo");

		if (memoNo != null) {
			setMemoNo(memoNo);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String duration = (String)attributes.get("duration");

		if (duration != null) {
			setDuration(duration);
		}

		Long commodityId = (Long)attributes.get("commodityId");

		if (commodityId != null) {
			setCommodityId(commodityId);
		}

		String commodityName = (String)attributes.get("commodityName");

		if (commodityName != null) {
			setCommodityName(commodityName);
		}

		Long econmcPrice = (Long)attributes.get("econmcPrice");

		if (econmcPrice != null) {
			setEconmcPrice(econmcPrice);
		}

		Long salePrceToEndCstmr = (Long)attributes.get("salePrceToEndCstmr");

		if (salePrceToEndCstmr != null) {
			setSalePrceToEndCstmr(salePrceToEndCstmr);
		}

		String unitPrice = (String)attributes.get("unitPrice");

		if (unitPrice != null) {
			setUnitPrice(unitPrice);
		}

		Float maxAlltmntPDay = (Float)attributes.get("maxAlltmntPDay");

		if (maxAlltmntPDay != null) {
			setMaxAlltmntPDay(maxAlltmntPDay);
		}

		Float maxSellQtyPCstmr = (Float)attributes.get("maxSellQtyPCstmr");

		if (maxSellQtyPCstmr != null) {
			setMaxSellQtyPCstmr(maxSellQtyPCstmr);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@Override
	public DlrFfpOmsAllcNtfyDetails cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the alloc ntfy ID of this dlr ffp oms allc ntfy details.
	 *
	 * @return the alloc ntfy ID of this dlr ffp oms allc ntfy details
	 */
	@Override
	public String getAllocNtfyId() {
		return model.getAllocNtfyId();
	}

	/**
	 * Returns the commodity ID of this dlr ffp oms allc ntfy details.
	 *
	 * @return the commodity ID of this dlr ffp oms allc ntfy details
	 */
	@Override
	public long getCommodityId() {
		return model.getCommodityId();
	}

	/**
	 * Returns the commodity name of this dlr ffp oms allc ntfy details.
	 *
	 * @return the commodity name of this dlr ffp oms allc ntfy details
	 */
	@Override
	public String getCommodityName() {
		return model.getCommodityName();
	}

	/**
	 * Returns the create date of this dlr ffp oms allc ntfy details.
	 *
	 * @return the create date of this dlr ffp oms allc ntfy details
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the dstrbtn chnnl of this dlr ffp oms allc ntfy details.
	 *
	 * @return the dstrbtn chnnl of this dlr ffp oms allc ntfy details
	 */
	@Override
	public String getDstrbtnChnnl() {
		return model.getDstrbtnChnnl();
	}

	/**
	 * Returns the duration of this dlr ffp oms allc ntfy details.
	 *
	 * @return the duration of this dlr ffp oms allc ntfy details
	 */
	@Override
	public String getDuration() {
		return model.getDuration();
	}

	/**
	 * Returns the econmc price of this dlr ffp oms allc ntfy details.
	 *
	 * @return the econmc price of this dlr ffp oms allc ntfy details
	 */
	@Override
	public long getEconmcPrice() {
		return model.getEconmcPrice();
	}

	/**
	 * Returns the end date of this dlr ffp oms allc ntfy details.
	 *
	 * @return the end date of this dlr ffp oms allc ntfy details
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the max alltmnt p day of this dlr ffp oms allc ntfy details.
	 *
	 * @return the max alltmnt p day of this dlr ffp oms allc ntfy details
	 */
	@Override
	public float getMaxAlltmntPDay() {
		return model.getMaxAlltmntPDay();
	}

	/**
	 * Returns the max sell qty p cstmr of this dlr ffp oms allc ntfy details.
	 *
	 * @return the max sell qty p cstmr of this dlr ffp oms allc ntfy details
	 */
	@Override
	public float getMaxSellQtyPCstmr() {
		return model.getMaxSellQtyPCstmr();
	}

	/**
	 * Returns the memo no of this dlr ffp oms allc ntfy details.
	 *
	 * @return the memo no of this dlr ffp oms allc ntfy details
	 */
	@Override
	public String getMemoNo() {
		return model.getMemoNo();
	}

	/**
	 * Returns the prgrm type of this dlr ffp oms allc ntfy details.
	 *
	 * @return the prgrm type of this dlr ffp oms allc ntfy details
	 */
	@Override
	public String getPrgrmType() {
		return model.getPrgrmType();
	}

	/**
	 * Returns the primary key of this dlr ffp oms allc ntfy details.
	 *
	 * @return the primary key of this dlr ffp oms allc ntfy details
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sale prce to end cstmr of this dlr ffp oms allc ntfy details.
	 *
	 * @return the sale prce to end cstmr of this dlr ffp oms allc ntfy details
	 */
	@Override
	public long getSalePrceToEndCstmr() {
		return model.getSalePrceToEndCstmr();
	}

	/**
	 * Returns the sales office of this dlr ffp oms allc ntfy details.
	 *
	 * @return the sales office of this dlr ffp oms allc ntfy details
	 */
	@Override
	public String getSalesOffice() {
		return model.getSalesOffice();
	}

	/**
	 * Returns the sales org name of this dlr ffp oms allc ntfy details.
	 *
	 * @return the sales org name of this dlr ffp oms allc ntfy details
	 */
	@Override
	public String getSalesOrgName() {
		return model.getSalesOrgName();
	}

	/**
	 * Returns the start date of this dlr ffp oms allc ntfy details.
	 *
	 * @return the start date of this dlr ffp oms allc ntfy details
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the unit price of this dlr ffp oms allc ntfy details.
	 *
	 * @return the unit price of this dlr ffp oms allc ntfy details
	 */
	@Override
	public String getUnitPrice() {
		return model.getUnitPrice();
	}

	/**
	 * Returns the year of this dlr ffp oms allc ntfy details.
	 *
	 * @return the year of this dlr ffp oms allc ntfy details
	 */
	@Override
	public long getYear() {
		return model.getYear();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the alloc ntfy ID of this dlr ffp oms allc ntfy details.
	 *
	 * @param allocNtfyId the alloc ntfy ID of this dlr ffp oms allc ntfy details
	 */
	@Override
	public void setAllocNtfyId(String allocNtfyId) {
		model.setAllocNtfyId(allocNtfyId);
	}

	/**
	 * Sets the commodity ID of this dlr ffp oms allc ntfy details.
	 *
	 * @param commodityId the commodity ID of this dlr ffp oms allc ntfy details
	 */
	@Override
	public void setCommodityId(long commodityId) {
		model.setCommodityId(commodityId);
	}

	/**
	 * Sets the commodity name of this dlr ffp oms allc ntfy details.
	 *
	 * @param commodityName the commodity name of this dlr ffp oms allc ntfy details
	 */
	@Override
	public void setCommodityName(String commodityName) {
		model.setCommodityName(commodityName);
	}

	/**
	 * Sets the create date of this dlr ffp oms allc ntfy details.
	 *
	 * @param createDate the create date of this dlr ffp oms allc ntfy details
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the dstrbtn chnnl of this dlr ffp oms allc ntfy details.
	 *
	 * @param dstrbtnChnnl the dstrbtn chnnl of this dlr ffp oms allc ntfy details
	 */
	@Override
	public void setDstrbtnChnnl(String dstrbtnChnnl) {
		model.setDstrbtnChnnl(dstrbtnChnnl);
	}

	/**
	 * Sets the duration of this dlr ffp oms allc ntfy details.
	 *
	 * @param duration the duration of this dlr ffp oms allc ntfy details
	 */
	@Override
	public void setDuration(String duration) {
		model.setDuration(duration);
	}

	/**
	 * Sets the econmc price of this dlr ffp oms allc ntfy details.
	 *
	 * @param econmcPrice the econmc price of this dlr ffp oms allc ntfy details
	 */
	@Override
	public void setEconmcPrice(long econmcPrice) {
		model.setEconmcPrice(econmcPrice);
	}

	/**
	 * Sets the end date of this dlr ffp oms allc ntfy details.
	 *
	 * @param endDate the end date of this dlr ffp oms allc ntfy details
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the max alltmnt p day of this dlr ffp oms allc ntfy details.
	 *
	 * @param maxAlltmntPDay the max alltmnt p day of this dlr ffp oms allc ntfy details
	 */
	@Override
	public void setMaxAlltmntPDay(float maxAlltmntPDay) {
		model.setMaxAlltmntPDay(maxAlltmntPDay);
	}

	/**
	 * Sets the max sell qty p cstmr of this dlr ffp oms allc ntfy details.
	 *
	 * @param maxSellQtyPCstmr the max sell qty p cstmr of this dlr ffp oms allc ntfy details
	 */
	@Override
	public void setMaxSellQtyPCstmr(float maxSellQtyPCstmr) {
		model.setMaxSellQtyPCstmr(maxSellQtyPCstmr);
	}

	/**
	 * Sets the memo no of this dlr ffp oms allc ntfy details.
	 *
	 * @param memoNo the memo no of this dlr ffp oms allc ntfy details
	 */
	@Override
	public void setMemoNo(String memoNo) {
		model.setMemoNo(memoNo);
	}

	/**
	 * Sets the prgrm type of this dlr ffp oms allc ntfy details.
	 *
	 * @param prgrmType the prgrm type of this dlr ffp oms allc ntfy details
	 */
	@Override
	public void setPrgrmType(String prgrmType) {
		model.setPrgrmType(prgrmType);
	}

	/**
	 * Sets the primary key of this dlr ffp oms allc ntfy details.
	 *
	 * @param primaryKey the primary key of this dlr ffp oms allc ntfy details
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sale prce to end cstmr of this dlr ffp oms allc ntfy details.
	 *
	 * @param salePrceToEndCstmr the sale prce to end cstmr of this dlr ffp oms allc ntfy details
	 */
	@Override
	public void setSalePrceToEndCstmr(long salePrceToEndCstmr) {
		model.setSalePrceToEndCstmr(salePrceToEndCstmr);
	}

	/**
	 * Sets the sales office of this dlr ffp oms allc ntfy details.
	 *
	 * @param salesOffice the sales office of this dlr ffp oms allc ntfy details
	 */
	@Override
	public void setSalesOffice(String salesOffice) {
		model.setSalesOffice(salesOffice);
	}

	/**
	 * Sets the sales org name of this dlr ffp oms allc ntfy details.
	 *
	 * @param salesOrgName the sales org name of this dlr ffp oms allc ntfy details
	 */
	@Override
	public void setSalesOrgName(String salesOrgName) {
		model.setSalesOrgName(salesOrgName);
	}

	/**
	 * Sets the start date of this dlr ffp oms allc ntfy details.
	 *
	 * @param startDate the start date of this dlr ffp oms allc ntfy details
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the unit price of this dlr ffp oms allc ntfy details.
	 *
	 * @param unitPrice the unit price of this dlr ffp oms allc ntfy details
	 */
	@Override
	public void setUnitPrice(String unitPrice) {
		model.setUnitPrice(unitPrice);
	}

	/**
	 * Sets the year of this dlr ffp oms allc ntfy details.
	 *
	 * @param year the year of this dlr ffp oms allc ntfy details
	 */
	@Override
	public void setYear(long year) {
		model.setYear(year);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DlrFfpOmsAllcNtfyDetailsWrapper wrap(
		DlrFfpOmsAllcNtfyDetails dlrFfpOmsAllcNtfyDetails) {

		return new DlrFfpOmsAllcNtfyDetailsWrapper(dlrFfpOmsAllcNtfyDetails);
	}

}