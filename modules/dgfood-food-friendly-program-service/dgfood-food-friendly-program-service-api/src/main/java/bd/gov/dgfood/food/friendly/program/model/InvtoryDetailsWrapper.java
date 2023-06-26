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
 * This class is a wrapper for {@link InvtoryDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InvtoryDetails
 * @generated
 */
public class InvtoryDetailsWrapper
	extends BaseModelWrapper<InvtoryDetails>
	implements InvtoryDetails, ModelWrapper<InvtoryDetails> {

	public InvtoryDetailsWrapper(InvtoryDetails invtoryDetails) {
		super(invtoryDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("inventoryId", getInventoryId());
		attributes.put("dlrRegNo", getDlrRegNo());
		attributes.put("allcNtfyNo", getAllcNtfyNo());
		attributes.put("fromDate", getFromDate());
		attributes.put("toDate", getToDate());
		attributes.put("commodityId", getCommodityId());
		attributes.put("commodityName", getCommodityName());
		attributes.put("noOfIndents", getNoOfIndents());
		attributes.put("receivedQty", getReceivedQty());
		attributes.put("soldQty", getSoldQty());
		attributes.put("balanceQty", getBalanceQty());
		attributes.put("createDate", getCreateDate());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long inventoryId = (Long)attributes.get("inventoryId");

		if (inventoryId != null) {
			setInventoryId(inventoryId);
		}

		Long dlrRegNo = (Long)attributes.get("dlrRegNo");

		if (dlrRegNo != null) {
			setDlrRegNo(dlrRegNo);
		}

		Long allcNtfyNo = (Long)attributes.get("allcNtfyNo");

		if (allcNtfyNo != null) {
			setAllcNtfyNo(allcNtfyNo);
		}

		Date fromDate = (Date)attributes.get("fromDate");

		if (fromDate != null) {
			setFromDate(fromDate);
		}

		Date toDate = (Date)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
		}

		Long commodityId = (Long)attributes.get("commodityId");

		if (commodityId != null) {
			setCommodityId(commodityId);
		}

		String commodityName = (String)attributes.get("commodityName");

		if (commodityName != null) {
			setCommodityName(commodityName);
		}

		Long noOfIndents = (Long)attributes.get("noOfIndents");

		if (noOfIndents != null) {
			setNoOfIndents(noOfIndents);
		}

		Float receivedQty = (Float)attributes.get("receivedQty");

		if (receivedQty != null) {
			setReceivedQty(receivedQty);
		}

		Float soldQty = (Float)attributes.get("soldQty");

		if (soldQty != null) {
			setSoldQty(soldQty);
		}

		Float balanceQty = (Float)attributes.get("balanceQty");

		if (balanceQty != null) {
			setBalanceQty(balanceQty);
		}

		Long createDate = (Long)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}
	}

	@Override
	public InvtoryDetails cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the allc ntfy no of this invtory details.
	 *
	 * @return the allc ntfy no of this invtory details
	 */
	@Override
	public long getAllcNtfyNo() {
		return model.getAllcNtfyNo();
	}

	/**
	 * Returns the balance qty of this invtory details.
	 *
	 * @return the balance qty of this invtory details
	 */
	@Override
	public float getBalanceQty() {
		return model.getBalanceQty();
	}

	/**
	 * Returns the commodity ID of this invtory details.
	 *
	 * @return the commodity ID of this invtory details
	 */
	@Override
	public long getCommodityId() {
		return model.getCommodityId();
	}

	/**
	 * Returns the commodity name of this invtory details.
	 *
	 * @return the commodity name of this invtory details
	 */
	@Override
	public String getCommodityName() {
		return model.getCommodityName();
	}

	/**
	 * Returns the company ID of this invtory details.
	 *
	 * @return the company ID of this invtory details
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this invtory details.
	 *
	 * @return the create date of this invtory details
	 */
	@Override
	public long getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this invtory details.
	 *
	 * @return the created by of this invtory details
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the dlr reg no of this invtory details.
	 *
	 * @return the dlr reg no of this invtory details
	 */
	@Override
	public long getDlrRegNo() {
		return model.getDlrRegNo();
	}

	/**
	 * Returns the from date of this invtory details.
	 *
	 * @return the from date of this invtory details
	 */
	@Override
	public Date getFromDate() {
		return model.getFromDate();
	}

	/**
	 * Returns the inventory ID of this invtory details.
	 *
	 * @return the inventory ID of this invtory details
	 */
	@Override
	public long getInventoryId() {
		return model.getInventoryId();
	}

	/**
	 * Returns the no of indents of this invtory details.
	 *
	 * @return the no of indents of this invtory details
	 */
	@Override
	public long getNoOfIndents() {
		return model.getNoOfIndents();
	}

	/**
	 * Returns the primary key of this invtory details.
	 *
	 * @return the primary key of this invtory details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the received qty of this invtory details.
	 *
	 * @return the received qty of this invtory details
	 */
	@Override
	public float getReceivedQty() {
		return model.getReceivedQty();
	}

	/**
	 * Returns the sold qty of this invtory details.
	 *
	 * @return the sold qty of this invtory details
	 */
	@Override
	public float getSoldQty() {
		return model.getSoldQty();
	}

	/**
	 * Returns the to date of this invtory details.
	 *
	 * @return the to date of this invtory details
	 */
	@Override
	public Date getToDate() {
		return model.getToDate();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the allc ntfy no of this invtory details.
	 *
	 * @param allcNtfyNo the allc ntfy no of this invtory details
	 */
	@Override
	public void setAllcNtfyNo(long allcNtfyNo) {
		model.setAllcNtfyNo(allcNtfyNo);
	}

	/**
	 * Sets the balance qty of this invtory details.
	 *
	 * @param balanceQty the balance qty of this invtory details
	 */
	@Override
	public void setBalanceQty(float balanceQty) {
		model.setBalanceQty(balanceQty);
	}

	/**
	 * Sets the commodity ID of this invtory details.
	 *
	 * @param commodityId the commodity ID of this invtory details
	 */
	@Override
	public void setCommodityId(long commodityId) {
		model.setCommodityId(commodityId);
	}

	/**
	 * Sets the commodity name of this invtory details.
	 *
	 * @param commodityName the commodity name of this invtory details
	 */
	@Override
	public void setCommodityName(String commodityName) {
		model.setCommodityName(commodityName);
	}

	/**
	 * Sets the company ID of this invtory details.
	 *
	 * @param companyId the company ID of this invtory details
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this invtory details.
	 *
	 * @param createDate the create date of this invtory details
	 */
	@Override
	public void setCreateDate(long createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this invtory details.
	 *
	 * @param createdBy the created by of this invtory details
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the dlr reg no of this invtory details.
	 *
	 * @param dlrRegNo the dlr reg no of this invtory details
	 */
	@Override
	public void setDlrRegNo(long dlrRegNo) {
		model.setDlrRegNo(dlrRegNo);
	}

	/**
	 * Sets the from date of this invtory details.
	 *
	 * @param fromDate the from date of this invtory details
	 */
	@Override
	public void setFromDate(Date fromDate) {
		model.setFromDate(fromDate);
	}

	/**
	 * Sets the inventory ID of this invtory details.
	 *
	 * @param inventoryId the inventory ID of this invtory details
	 */
	@Override
	public void setInventoryId(long inventoryId) {
		model.setInventoryId(inventoryId);
	}

	/**
	 * Sets the no of indents of this invtory details.
	 *
	 * @param noOfIndents the no of indents of this invtory details
	 */
	@Override
	public void setNoOfIndents(long noOfIndents) {
		model.setNoOfIndents(noOfIndents);
	}

	/**
	 * Sets the primary key of this invtory details.
	 *
	 * @param primaryKey the primary key of this invtory details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the received qty of this invtory details.
	 *
	 * @param receivedQty the received qty of this invtory details
	 */
	@Override
	public void setReceivedQty(float receivedQty) {
		model.setReceivedQty(receivedQty);
	}

	/**
	 * Sets the sold qty of this invtory details.
	 *
	 * @param soldQty the sold qty of this invtory details
	 */
	@Override
	public void setSoldQty(float soldQty) {
		model.setSoldQty(soldQty);
	}

	/**
	 * Sets the to date of this invtory details.
	 *
	 * @param toDate the to date of this invtory details
	 */
	@Override
	public void setToDate(Date toDate) {
		model.setToDate(toDate);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected InvtoryDetailsWrapper wrap(InvtoryDetails invtoryDetails) {
		return new InvtoryDetailsWrapper(invtoryDetails);
	}

}