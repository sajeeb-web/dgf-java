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
 * This class is a wrapper for {@link DgfUsersForthnightReportD}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersForthnightReportD
 * @generated
 */
public class DgfUsersForthnightReportDWrapper
	extends BaseModelWrapper<DgfUsersForthnightReportD>
	implements DgfUsersForthnightReportD,
			   ModelWrapper<DgfUsersForthnightReportD> {

	public DgfUsersForthnightReportDWrapper(
		DgfUsersForthnightReportD dgfUsersForthnightReportD) {

		super(dgfUsersForthnightReportD);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("reportId", getReportId());
		attributes.put("userId", getUserId());
		attributes.put("usernationalId", getUsernationalId());
		attributes.put("screenName", getScreenName());
		attributes.put("fullName", getFullName());
		attributes.put("productType", getProductType());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("product", getProduct());
		attributes.put("initalStockOn", getInitalStockOn());
		attributes.put("initalStockOnUnit", getInitalStockOnUnit());
		attributes.put("recivedQuantity", getRecivedQuantity());
		attributes.put("recivedQuantityUnit", getRecivedQuantityUnit());
		attributes.put("sellingQuantity", getSellingQuantity());
		attributes.put("sellingQuantityUnit", getSellingQuantityUnit());
		attributes.put(
			"quantityOfFinishingStock", getQuantityOfFinishingStock());
		attributes.put(
			"quantityOfFinishingStockUnit", getQuantityOfFinishingStockUnit());
		attributes.put("comment", getComment());
		attributes.put("nationalId", getNationalId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long reportId = (Long)attributes.get("reportId");

		if (reportId != null) {
			setReportId(reportId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String usernationalId = (String)attributes.get("usernationalId");

		if (usernationalId != null) {
			setUsernationalId(usernationalId);
		}

		String screenName = (String)attributes.get("screenName");

		if (screenName != null) {
			setScreenName(screenName);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String productType = (String)attributes.get("productType");

		if (productType != null) {
			setProductType(productType);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String product = (String)attributes.get("product");

		if (product != null) {
			setProduct(product);
		}

		Integer initalStockOn = (Integer)attributes.get("initalStockOn");

		if (initalStockOn != null) {
			setInitalStockOn(initalStockOn);
		}

		String initalStockOnUnit = (String)attributes.get("initalStockOnUnit");

		if (initalStockOnUnit != null) {
			setInitalStockOnUnit(initalStockOnUnit);
		}

		Integer recivedQuantity = (Integer)attributes.get("recivedQuantity");

		if (recivedQuantity != null) {
			setRecivedQuantity(recivedQuantity);
		}

		String recivedQuantityUnit = (String)attributes.get(
			"recivedQuantityUnit");

		if (recivedQuantityUnit != null) {
			setRecivedQuantityUnit(recivedQuantityUnit);
		}

		Integer sellingQuantity = (Integer)attributes.get("sellingQuantity");

		if (sellingQuantity != null) {
			setSellingQuantity(sellingQuantity);
		}

		String sellingQuantityUnit = (String)attributes.get(
			"sellingQuantityUnit");

		if (sellingQuantityUnit != null) {
			setSellingQuantityUnit(sellingQuantityUnit);
		}

		Integer quantityOfFinishingStock = (Integer)attributes.get(
			"quantityOfFinishingStock");

		if (quantityOfFinishingStock != null) {
			setQuantityOfFinishingStock(quantityOfFinishingStock);
		}

		String quantityOfFinishingStockUnit = (String)attributes.get(
			"quantityOfFinishingStockUnit");

		if (quantityOfFinishingStockUnit != null) {
			setQuantityOfFinishingStockUnit(quantityOfFinishingStockUnit);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}

		String nationalId = (String)attributes.get("nationalId");

		if (nationalId != null) {
			setNationalId(nationalId);
		}
	}

	@Override
	public DgfUsersForthnightReportD cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the comment of this dgf users forthnight report d.
	 *
	 * @return the comment of this dgf users forthnight report d
	 */
	@Override
	public String getComment() {
		return model.getComment();
	}

	/**
	 * Returns the end date of this dgf users forthnight report d.
	 *
	 * @return the end date of this dgf users forthnight report d
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the full name of this dgf users forthnight report d.
	 *
	 * @return the full name of this dgf users forthnight report d
	 */
	@Override
	public String getFullName() {
		return model.getFullName();
	}

	/**
	 * Returns the inital stock on of this dgf users forthnight report d.
	 *
	 * @return the inital stock on of this dgf users forthnight report d
	 */
	@Override
	public int getInitalStockOn() {
		return model.getInitalStockOn();
	}

	/**
	 * Returns the inital stock on unit of this dgf users forthnight report d.
	 *
	 * @return the inital stock on unit of this dgf users forthnight report d
	 */
	@Override
	public String getInitalStockOnUnit() {
		return model.getInitalStockOnUnit();
	}

	/**
	 * Returns the national ID of this dgf users forthnight report d.
	 *
	 * @return the national ID of this dgf users forthnight report d
	 */
	@Override
	public String getNationalId() {
		return model.getNationalId();
	}

	/**
	 * Returns the primary key of this dgf users forthnight report d.
	 *
	 * @return the primary key of this dgf users forthnight report d
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product of this dgf users forthnight report d.
	 *
	 * @return the product of this dgf users forthnight report d
	 */
	@Override
	public String getProduct() {
		return model.getProduct();
	}

	/**
	 * Returns the product type of this dgf users forthnight report d.
	 *
	 * @return the product type of this dgf users forthnight report d
	 */
	@Override
	public String getProductType() {
		return model.getProductType();
	}

	/**
	 * Returns the quantity of finishing stock of this dgf users forthnight report d.
	 *
	 * @return the quantity of finishing stock of this dgf users forthnight report d
	 */
	@Override
	public int getQuantityOfFinishingStock() {
		return model.getQuantityOfFinishingStock();
	}

	/**
	 * Returns the quantity of finishing stock unit of this dgf users forthnight report d.
	 *
	 * @return the quantity of finishing stock unit of this dgf users forthnight report d
	 */
	@Override
	public String getQuantityOfFinishingStockUnit() {
		return model.getQuantityOfFinishingStockUnit();
	}

	/**
	 * Returns the recived quantity of this dgf users forthnight report d.
	 *
	 * @return the recived quantity of this dgf users forthnight report d
	 */
	@Override
	public int getRecivedQuantity() {
		return model.getRecivedQuantity();
	}

	/**
	 * Returns the recived quantity unit of this dgf users forthnight report d.
	 *
	 * @return the recived quantity unit of this dgf users forthnight report d
	 */
	@Override
	public String getRecivedQuantityUnit() {
		return model.getRecivedQuantityUnit();
	}

	/**
	 * Returns the report ID of this dgf users forthnight report d.
	 *
	 * @return the report ID of this dgf users forthnight report d
	 */
	@Override
	public long getReportId() {
		return model.getReportId();
	}

	/**
	 * Returns the screen name of this dgf users forthnight report d.
	 *
	 * @return the screen name of this dgf users forthnight report d
	 */
	@Override
	public String getScreenName() {
		return model.getScreenName();
	}

	/**
	 * Returns the selling quantity of this dgf users forthnight report d.
	 *
	 * @return the selling quantity of this dgf users forthnight report d
	 */
	@Override
	public int getSellingQuantity() {
		return model.getSellingQuantity();
	}

	/**
	 * Returns the selling quantity unit of this dgf users forthnight report d.
	 *
	 * @return the selling quantity unit of this dgf users forthnight report d
	 */
	@Override
	public String getSellingQuantityUnit() {
		return model.getSellingQuantityUnit();
	}

	/**
	 * Returns the start date of this dgf users forthnight report d.
	 *
	 * @return the start date of this dgf users forthnight report d
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the user ID of this dgf users forthnight report d.
	 *
	 * @return the user ID of this dgf users forthnight report d
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the usernational ID of this dgf users forthnight report d.
	 *
	 * @return the usernational ID of this dgf users forthnight report d
	 */
	@Override
	public String getUsernationalId() {
		return model.getUsernationalId();
	}

	/**
	 * Returns the user uuid of this dgf users forthnight report d.
	 *
	 * @return the user uuid of this dgf users forthnight report d
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the comment of this dgf users forthnight report d.
	 *
	 * @param comment the comment of this dgf users forthnight report d
	 */
	@Override
	public void setComment(String comment) {
		model.setComment(comment);
	}

	/**
	 * Sets the end date of this dgf users forthnight report d.
	 *
	 * @param endDate the end date of this dgf users forthnight report d
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the full name of this dgf users forthnight report d.
	 *
	 * @param fullName the full name of this dgf users forthnight report d
	 */
	@Override
	public void setFullName(String fullName) {
		model.setFullName(fullName);
	}

	/**
	 * Sets the inital stock on of this dgf users forthnight report d.
	 *
	 * @param initalStockOn the inital stock on of this dgf users forthnight report d
	 */
	@Override
	public void setInitalStockOn(int initalStockOn) {
		model.setInitalStockOn(initalStockOn);
	}

	/**
	 * Sets the inital stock on unit of this dgf users forthnight report d.
	 *
	 * @param initalStockOnUnit the inital stock on unit of this dgf users forthnight report d
	 */
	@Override
	public void setInitalStockOnUnit(String initalStockOnUnit) {
		model.setInitalStockOnUnit(initalStockOnUnit);
	}

	/**
	 * Sets the national ID of this dgf users forthnight report d.
	 *
	 * @param nationalId the national ID of this dgf users forthnight report d
	 */
	@Override
	public void setNationalId(String nationalId) {
		model.setNationalId(nationalId);
	}

	/**
	 * Sets the primary key of this dgf users forthnight report d.
	 *
	 * @param primaryKey the primary key of this dgf users forthnight report d
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product of this dgf users forthnight report d.
	 *
	 * @param product the product of this dgf users forthnight report d
	 */
	@Override
	public void setProduct(String product) {
		model.setProduct(product);
	}

	/**
	 * Sets the product type of this dgf users forthnight report d.
	 *
	 * @param productType the product type of this dgf users forthnight report d
	 */
	@Override
	public void setProductType(String productType) {
		model.setProductType(productType);
	}

	/**
	 * Sets the quantity of finishing stock of this dgf users forthnight report d.
	 *
	 * @param quantityOfFinishingStock the quantity of finishing stock of this dgf users forthnight report d
	 */
	@Override
	public void setQuantityOfFinishingStock(int quantityOfFinishingStock) {
		model.setQuantityOfFinishingStock(quantityOfFinishingStock);
	}

	/**
	 * Sets the quantity of finishing stock unit of this dgf users forthnight report d.
	 *
	 * @param quantityOfFinishingStockUnit the quantity of finishing stock unit of this dgf users forthnight report d
	 */
	@Override
	public void setQuantityOfFinishingStockUnit(
		String quantityOfFinishingStockUnit) {

		model.setQuantityOfFinishingStockUnit(quantityOfFinishingStockUnit);
	}

	/**
	 * Sets the recived quantity of this dgf users forthnight report d.
	 *
	 * @param recivedQuantity the recived quantity of this dgf users forthnight report d
	 */
	@Override
	public void setRecivedQuantity(int recivedQuantity) {
		model.setRecivedQuantity(recivedQuantity);
	}

	/**
	 * Sets the recived quantity unit of this dgf users forthnight report d.
	 *
	 * @param recivedQuantityUnit the recived quantity unit of this dgf users forthnight report d
	 */
	@Override
	public void setRecivedQuantityUnit(String recivedQuantityUnit) {
		model.setRecivedQuantityUnit(recivedQuantityUnit);
	}

	/**
	 * Sets the report ID of this dgf users forthnight report d.
	 *
	 * @param reportId the report ID of this dgf users forthnight report d
	 */
	@Override
	public void setReportId(long reportId) {
		model.setReportId(reportId);
	}

	/**
	 * Sets the screen name of this dgf users forthnight report d.
	 *
	 * @param screenName the screen name of this dgf users forthnight report d
	 */
	@Override
	public void setScreenName(String screenName) {
		model.setScreenName(screenName);
	}

	/**
	 * Sets the selling quantity of this dgf users forthnight report d.
	 *
	 * @param sellingQuantity the selling quantity of this dgf users forthnight report d
	 */
	@Override
	public void setSellingQuantity(int sellingQuantity) {
		model.setSellingQuantity(sellingQuantity);
	}

	/**
	 * Sets the selling quantity unit of this dgf users forthnight report d.
	 *
	 * @param sellingQuantityUnit the selling quantity unit of this dgf users forthnight report d
	 */
	@Override
	public void setSellingQuantityUnit(String sellingQuantityUnit) {
		model.setSellingQuantityUnit(sellingQuantityUnit);
	}

	/**
	 * Sets the start date of this dgf users forthnight report d.
	 *
	 * @param startDate the start date of this dgf users forthnight report d
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the user ID of this dgf users forthnight report d.
	 *
	 * @param userId the user ID of this dgf users forthnight report d
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the usernational ID of this dgf users forthnight report d.
	 *
	 * @param usernationalId the usernational ID of this dgf users forthnight report d
	 */
	@Override
	public void setUsernationalId(String usernationalId) {
		model.setUsernationalId(usernationalId);
	}

	/**
	 * Sets the user uuid of this dgf users forthnight report d.
	 *
	 * @param userUuid the user uuid of this dgf users forthnight report d
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DgfUsersForthnightReportDWrapper wrap(
		DgfUsersForthnightReportD dgfUsersForthnightReportD) {

		return new DgfUsersForthnightReportDWrapper(dgfUsersForthnightReportD);
	}

}