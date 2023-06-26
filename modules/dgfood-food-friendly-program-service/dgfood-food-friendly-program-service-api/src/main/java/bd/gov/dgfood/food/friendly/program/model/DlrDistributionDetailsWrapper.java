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
 * This class is a wrapper for {@link DlrDistributionDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DlrDistributionDetails
 * @generated
 */
public class DlrDistributionDetailsWrapper
	extends BaseModelWrapper<DlrDistributionDetails>
	implements DlrDistributionDetails, ModelWrapper<DlrDistributionDetails> {

	public DlrDistributionDetailsWrapper(
		DlrDistributionDetails dlrDistributionDetails) {

		super(dlrDistributionDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dstrbnId", getDstrbnId());
		attributes.put("dlrRegNo", getDlrRegNo());
		attributes.put("ffpRegstrId", getFfpRegstrId());
		attributes.put("selLingDate", getSelLingDate());
		attributes.put("commodityId", getCommodityId());
		attributes.put("commodityName", getCommodityName());
		attributes.put("sellingPrice", getSellingPrice());
		attributes.put("sellingQty", getSellingQty());
		attributes.put("stockBfrSelling", getStockBfrSelling());
		attributes.put("stockAfterSelling", getStockAfterSelling());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("companyId", getCompanyId());
		attributes.put("inventoryId", getInventoryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dstrbnId = (Long)attributes.get("dstrbnId");

		if (dstrbnId != null) {
			setDstrbnId(dstrbnId);
		}

		Long dlrRegNo = (Long)attributes.get("dlrRegNo");

		if (dlrRegNo != null) {
			setDlrRegNo(dlrRegNo);
		}

		Long ffpRegstrId = (Long)attributes.get("ffpRegstrId");

		if (ffpRegstrId != null) {
			setFfpRegstrId(ffpRegstrId);
		}

		Date selLingDate = (Date)attributes.get("selLingDate");

		if (selLingDate != null) {
			setSelLingDate(selLingDate);
		}

		Long commodityId = (Long)attributes.get("commodityId");

		if (commodityId != null) {
			setCommodityId(commodityId);
		}

		String commodityName = (String)attributes.get("commodityName");

		if (commodityName != null) {
			setCommodityName(commodityName);
		}

		String sellingPrice = (String)attributes.get("sellingPrice");

		if (sellingPrice != null) {
			setSellingPrice(sellingPrice);
		}

		Long sellingQty = (Long)attributes.get("sellingQty");

		if (sellingQty != null) {
			setSellingQty(sellingQty);
		}

		Long stockBfrSelling = (Long)attributes.get("stockBfrSelling");

		if (stockBfrSelling != null) {
			setStockBfrSelling(stockBfrSelling);
		}

		Long stockAfterSelling = (Long)attributes.get("stockAfterSelling");

		if (stockAfterSelling != null) {
			setStockAfterSelling(stockAfterSelling);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long inventoryId = (Long)attributes.get("inventoryId");

		if (inventoryId != null) {
			setInventoryId(inventoryId);
		}
	}

	@Override
	public DlrDistributionDetails cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the commodity ID of this dlr distribution details.
	 *
	 * @return the commodity ID of this dlr distribution details
	 */
	@Override
	public long getCommodityId() {
		return model.getCommodityId();
	}

	/**
	 * Returns the commodity name of this dlr distribution details.
	 *
	 * @return the commodity name of this dlr distribution details
	 */
	@Override
	public String getCommodityName() {
		return model.getCommodityName();
	}

	/**
	 * Returns the company ID of this dlr distribution details.
	 *
	 * @return the company ID of this dlr distribution details
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this dlr distribution details.
	 *
	 * @return the create date of this dlr distribution details
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this dlr distribution details.
	 *
	 * @return the created by of this dlr distribution details
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the dlr reg no of this dlr distribution details.
	 *
	 * @return the dlr reg no of this dlr distribution details
	 */
	@Override
	public long getDlrRegNo() {
		return model.getDlrRegNo();
	}

	/**
	 * Returns the dstrbn ID of this dlr distribution details.
	 *
	 * @return the dstrbn ID of this dlr distribution details
	 */
	@Override
	public long getDstrbnId() {
		return model.getDstrbnId();
	}

	/**
	 * Returns the ffp regstr ID of this dlr distribution details.
	 *
	 * @return the ffp regstr ID of this dlr distribution details
	 */
	@Override
	public long getFfpRegstrId() {
		return model.getFfpRegstrId();
	}

	/**
	 * Returns the inventory ID of this dlr distribution details.
	 *
	 * @return the inventory ID of this dlr distribution details
	 */
	@Override
	public long getInventoryId() {
		return model.getInventoryId();
	}

	/**
	 * Returns the primary key of this dlr distribution details.
	 *
	 * @return the primary key of this dlr distribution details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sel ling date of this dlr distribution details.
	 *
	 * @return the sel ling date of this dlr distribution details
	 */
	@Override
	public Date getSelLingDate() {
		return model.getSelLingDate();
	}

	/**
	 * Returns the selling price of this dlr distribution details.
	 *
	 * @return the selling price of this dlr distribution details
	 */
	@Override
	public String getSellingPrice() {
		return model.getSellingPrice();
	}

	/**
	 * Returns the selling qty of this dlr distribution details.
	 *
	 * @return the selling qty of this dlr distribution details
	 */
	@Override
	public long getSellingQty() {
		return model.getSellingQty();
	}

	/**
	 * Returns the stock after selling of this dlr distribution details.
	 *
	 * @return the stock after selling of this dlr distribution details
	 */
	@Override
	public long getStockAfterSelling() {
		return model.getStockAfterSelling();
	}

	/**
	 * Returns the stock bfr selling of this dlr distribution details.
	 *
	 * @return the stock bfr selling of this dlr distribution details
	 */
	@Override
	public long getStockBfrSelling() {
		return model.getStockBfrSelling();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the commodity ID of this dlr distribution details.
	 *
	 * @param commodityId the commodity ID of this dlr distribution details
	 */
	@Override
	public void setCommodityId(long commodityId) {
		model.setCommodityId(commodityId);
	}

	/**
	 * Sets the commodity name of this dlr distribution details.
	 *
	 * @param commodityName the commodity name of this dlr distribution details
	 */
	@Override
	public void setCommodityName(String commodityName) {
		model.setCommodityName(commodityName);
	}

	/**
	 * Sets the company ID of this dlr distribution details.
	 *
	 * @param companyId the company ID of this dlr distribution details
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this dlr distribution details.
	 *
	 * @param createDate the create date of this dlr distribution details
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this dlr distribution details.
	 *
	 * @param createdBy the created by of this dlr distribution details
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the dlr reg no of this dlr distribution details.
	 *
	 * @param dlrRegNo the dlr reg no of this dlr distribution details
	 */
	@Override
	public void setDlrRegNo(long dlrRegNo) {
		model.setDlrRegNo(dlrRegNo);
	}

	/**
	 * Sets the dstrbn ID of this dlr distribution details.
	 *
	 * @param dstrbnId the dstrbn ID of this dlr distribution details
	 */
	@Override
	public void setDstrbnId(long dstrbnId) {
		model.setDstrbnId(dstrbnId);
	}

	/**
	 * Sets the ffp regstr ID of this dlr distribution details.
	 *
	 * @param ffpRegstrId the ffp regstr ID of this dlr distribution details
	 */
	@Override
	public void setFfpRegstrId(long ffpRegstrId) {
		model.setFfpRegstrId(ffpRegstrId);
	}

	/**
	 * Sets the inventory ID of this dlr distribution details.
	 *
	 * @param inventoryId the inventory ID of this dlr distribution details
	 */
	@Override
	public void setInventoryId(long inventoryId) {
		model.setInventoryId(inventoryId);
	}

	/**
	 * Sets the primary key of this dlr distribution details.
	 *
	 * @param primaryKey the primary key of this dlr distribution details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sel ling date of this dlr distribution details.
	 *
	 * @param selLingDate the sel ling date of this dlr distribution details
	 */
	@Override
	public void setSelLingDate(Date selLingDate) {
		model.setSelLingDate(selLingDate);
	}

	/**
	 * Sets the selling price of this dlr distribution details.
	 *
	 * @param sellingPrice the selling price of this dlr distribution details
	 */
	@Override
	public void setSellingPrice(String sellingPrice) {
		model.setSellingPrice(sellingPrice);
	}

	/**
	 * Sets the selling qty of this dlr distribution details.
	 *
	 * @param sellingQty the selling qty of this dlr distribution details
	 */
	@Override
	public void setSellingQty(long sellingQty) {
		model.setSellingQty(sellingQty);
	}

	/**
	 * Sets the stock after selling of this dlr distribution details.
	 *
	 * @param stockAfterSelling the stock after selling of this dlr distribution details
	 */
	@Override
	public void setStockAfterSelling(long stockAfterSelling) {
		model.setStockAfterSelling(stockAfterSelling);
	}

	/**
	 * Sets the stock bfr selling of this dlr distribution details.
	 *
	 * @param stockBfrSelling the stock bfr selling of this dlr distribution details
	 */
	@Override
	public void setStockBfrSelling(long stockBfrSelling) {
		model.setStockBfrSelling(stockBfrSelling);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DlrDistributionDetailsWrapper wrap(
		DlrDistributionDetails dlrDistributionDetails) {

		return new DlrDistributionDetailsWrapper(dlrDistributionDetails);
	}

}