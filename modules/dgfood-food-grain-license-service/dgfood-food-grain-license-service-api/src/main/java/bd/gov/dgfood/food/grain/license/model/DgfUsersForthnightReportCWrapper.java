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
 * This class is a wrapper for {@link DgfUsersForthnightReportC}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersForthnightReportC
 * @generated
 */
public class DgfUsersForthnightReportCWrapper
	extends BaseModelWrapper<DgfUsersForthnightReportC>
	implements DgfUsersForthnightReportC,
			   ModelWrapper<DgfUsersForthnightReportC> {

	public DgfUsersForthnightReportCWrapper(
		DgfUsersForthnightReportC dgfUsersForthnightReportC) {

		super(dgfUsersForthnightReportC);
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
		attributes.put("daterecipt", getDaterecipt());
		attributes.put("receivedQuantity", getReceivedQuantity());
		attributes.put("receivedQuantityUnit", getReceivedQuantityUnit());
		attributes.put("lastDateApprove", getLastDateApprove());
		attributes.put("unsoldQuantity", getUnsoldQuantity());
		attributes.put("unsolddunit", getUnsolddunit());
		attributes.put("reasonForBeingUnsold", getReasonForBeingUnsold());

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

		Date daterecipt = (Date)attributes.get("daterecipt");

		if (daterecipt != null) {
			setDaterecipt(daterecipt);
		}

		Integer receivedQuantity = (Integer)attributes.get("receivedQuantity");

		if (receivedQuantity != null) {
			setReceivedQuantity(receivedQuantity);
		}

		String receivedQuantityUnit = (String)attributes.get(
			"receivedQuantityUnit");

		if (receivedQuantityUnit != null) {
			setReceivedQuantityUnit(receivedQuantityUnit);
		}

		Date lastDateApprove = (Date)attributes.get("lastDateApprove");

		if (lastDateApprove != null) {
			setLastDateApprove(lastDateApprove);
		}

		Integer unsoldQuantity = (Integer)attributes.get("unsoldQuantity");

		if (unsoldQuantity != null) {
			setUnsoldQuantity(unsoldQuantity);
		}

		String unsolddunit = (String)attributes.get("unsolddunit");

		if (unsolddunit != null) {
			setUnsolddunit(unsolddunit);
		}

		String reasonForBeingUnsold = (String)attributes.get(
			"reasonForBeingUnsold");

		if (reasonForBeingUnsold != null) {
			setReasonForBeingUnsold(reasonForBeingUnsold);
		}
	}

	@Override
	public DgfUsersForthnightReportC cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the daterecipt of this dgf users forthnight report c.
	 *
	 * @return the daterecipt of this dgf users forthnight report c
	 */
	@Override
	public Date getDaterecipt() {
		return model.getDaterecipt();
	}

	/**
	 * Returns the end date of this dgf users forthnight report c.
	 *
	 * @return the end date of this dgf users forthnight report c
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the full name of this dgf users forthnight report c.
	 *
	 * @return the full name of this dgf users forthnight report c
	 */
	@Override
	public String getFullName() {
		return model.getFullName();
	}

	/**
	 * Returns the last date approve of this dgf users forthnight report c.
	 *
	 * @return the last date approve of this dgf users forthnight report c
	 */
	@Override
	public Date getLastDateApprove() {
		return model.getLastDateApprove();
	}

	/**
	 * Returns the primary key of this dgf users forthnight report c.
	 *
	 * @return the primary key of this dgf users forthnight report c
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product of this dgf users forthnight report c.
	 *
	 * @return the product of this dgf users forthnight report c
	 */
	@Override
	public String getProduct() {
		return model.getProduct();
	}

	/**
	 * Returns the product type of this dgf users forthnight report c.
	 *
	 * @return the product type of this dgf users forthnight report c
	 */
	@Override
	public String getProductType() {
		return model.getProductType();
	}

	/**
	 * Returns the reason for being unsold of this dgf users forthnight report c.
	 *
	 * @return the reason for being unsold of this dgf users forthnight report c
	 */
	@Override
	public String getReasonForBeingUnsold() {
		return model.getReasonForBeingUnsold();
	}

	/**
	 * Returns the received quantity of this dgf users forthnight report c.
	 *
	 * @return the received quantity of this dgf users forthnight report c
	 */
	@Override
	public int getReceivedQuantity() {
		return model.getReceivedQuantity();
	}

	/**
	 * Returns the received quantity unit of this dgf users forthnight report c.
	 *
	 * @return the received quantity unit of this dgf users forthnight report c
	 */
	@Override
	public String getReceivedQuantityUnit() {
		return model.getReceivedQuantityUnit();
	}

	/**
	 * Returns the report ID of this dgf users forthnight report c.
	 *
	 * @return the report ID of this dgf users forthnight report c
	 */
	@Override
	public long getReportId() {
		return model.getReportId();
	}

	/**
	 * Returns the screen name of this dgf users forthnight report c.
	 *
	 * @return the screen name of this dgf users forthnight report c
	 */
	@Override
	public String getScreenName() {
		return model.getScreenName();
	}

	/**
	 * Returns the start date of this dgf users forthnight report c.
	 *
	 * @return the start date of this dgf users forthnight report c
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the unsolddunit of this dgf users forthnight report c.
	 *
	 * @return the unsolddunit of this dgf users forthnight report c
	 */
	@Override
	public String getUnsolddunit() {
		return model.getUnsolddunit();
	}

	/**
	 * Returns the unsold quantity of this dgf users forthnight report c.
	 *
	 * @return the unsold quantity of this dgf users forthnight report c
	 */
	@Override
	public int getUnsoldQuantity() {
		return model.getUnsoldQuantity();
	}

	/**
	 * Returns the user ID of this dgf users forthnight report c.
	 *
	 * @return the user ID of this dgf users forthnight report c
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the usernational ID of this dgf users forthnight report c.
	 *
	 * @return the usernational ID of this dgf users forthnight report c
	 */
	@Override
	public String getUsernationalId() {
		return model.getUsernationalId();
	}

	/**
	 * Returns the user uuid of this dgf users forthnight report c.
	 *
	 * @return the user uuid of this dgf users forthnight report c
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
	 * Sets the daterecipt of this dgf users forthnight report c.
	 *
	 * @param daterecipt the daterecipt of this dgf users forthnight report c
	 */
	@Override
	public void setDaterecipt(Date daterecipt) {
		model.setDaterecipt(daterecipt);
	}

	/**
	 * Sets the end date of this dgf users forthnight report c.
	 *
	 * @param endDate the end date of this dgf users forthnight report c
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the full name of this dgf users forthnight report c.
	 *
	 * @param fullName the full name of this dgf users forthnight report c
	 */
	@Override
	public void setFullName(String fullName) {
		model.setFullName(fullName);
	}

	/**
	 * Sets the last date approve of this dgf users forthnight report c.
	 *
	 * @param lastDateApprove the last date approve of this dgf users forthnight report c
	 */
	@Override
	public void setLastDateApprove(Date lastDateApprove) {
		model.setLastDateApprove(lastDateApprove);
	}

	/**
	 * Sets the primary key of this dgf users forthnight report c.
	 *
	 * @param primaryKey the primary key of this dgf users forthnight report c
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product of this dgf users forthnight report c.
	 *
	 * @param product the product of this dgf users forthnight report c
	 */
	@Override
	public void setProduct(String product) {
		model.setProduct(product);
	}

	/**
	 * Sets the product type of this dgf users forthnight report c.
	 *
	 * @param productType the product type of this dgf users forthnight report c
	 */
	@Override
	public void setProductType(String productType) {
		model.setProductType(productType);
	}

	/**
	 * Sets the reason for being unsold of this dgf users forthnight report c.
	 *
	 * @param reasonForBeingUnsold the reason for being unsold of this dgf users forthnight report c
	 */
	@Override
	public void setReasonForBeingUnsold(String reasonForBeingUnsold) {
		model.setReasonForBeingUnsold(reasonForBeingUnsold);
	}

	/**
	 * Sets the received quantity of this dgf users forthnight report c.
	 *
	 * @param receivedQuantity the received quantity of this dgf users forthnight report c
	 */
	@Override
	public void setReceivedQuantity(int receivedQuantity) {
		model.setReceivedQuantity(receivedQuantity);
	}

	/**
	 * Sets the received quantity unit of this dgf users forthnight report c.
	 *
	 * @param receivedQuantityUnit the received quantity unit of this dgf users forthnight report c
	 */
	@Override
	public void setReceivedQuantityUnit(String receivedQuantityUnit) {
		model.setReceivedQuantityUnit(receivedQuantityUnit);
	}

	/**
	 * Sets the report ID of this dgf users forthnight report c.
	 *
	 * @param reportId the report ID of this dgf users forthnight report c
	 */
	@Override
	public void setReportId(long reportId) {
		model.setReportId(reportId);
	}

	/**
	 * Sets the screen name of this dgf users forthnight report c.
	 *
	 * @param screenName the screen name of this dgf users forthnight report c
	 */
	@Override
	public void setScreenName(String screenName) {
		model.setScreenName(screenName);
	}

	/**
	 * Sets the start date of this dgf users forthnight report c.
	 *
	 * @param startDate the start date of this dgf users forthnight report c
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the unsolddunit of this dgf users forthnight report c.
	 *
	 * @param unsolddunit the unsolddunit of this dgf users forthnight report c
	 */
	@Override
	public void setUnsolddunit(String unsolddunit) {
		model.setUnsolddunit(unsolddunit);
	}

	/**
	 * Sets the unsold quantity of this dgf users forthnight report c.
	 *
	 * @param unsoldQuantity the unsold quantity of this dgf users forthnight report c
	 */
	@Override
	public void setUnsoldQuantity(int unsoldQuantity) {
		model.setUnsoldQuantity(unsoldQuantity);
	}

	/**
	 * Sets the user ID of this dgf users forthnight report c.
	 *
	 * @param userId the user ID of this dgf users forthnight report c
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the usernational ID of this dgf users forthnight report c.
	 *
	 * @param usernationalId the usernational ID of this dgf users forthnight report c
	 */
	@Override
	public void setUsernationalId(String usernationalId) {
		model.setUsernationalId(usernationalId);
	}

	/**
	 * Sets the user uuid of this dgf users forthnight report c.
	 *
	 * @param userUuid the user uuid of this dgf users forthnight report c
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
	protected DgfUsersForthnightReportCWrapper wrap(
		DgfUsersForthnightReportC dgfUsersForthnightReportC) {

		return new DgfUsersForthnightReportCWrapper(dgfUsersForthnightReportC);
	}

}