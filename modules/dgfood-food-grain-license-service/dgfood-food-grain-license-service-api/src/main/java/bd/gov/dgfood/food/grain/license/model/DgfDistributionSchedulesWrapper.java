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
 * This class is a wrapper for {@link DgfDistributionSchedules}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfDistributionSchedules
 * @generated
 */
public class DgfDistributionSchedulesWrapper
	extends BaseModelWrapper<DgfDistributionSchedules>
	implements DgfDistributionSchedules,
			   ModelWrapper<DgfDistributionSchedules> {

	public DgfDistributionSchedulesWrapper(
		DgfDistributionSchedules dgfDistributionSchedules) {

		super(dgfDistributionSchedules);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("distributionYear", getDistributionYear());
		attributes.put("distributionMonth", getDistributionMonth());
		attributes.put("openStatus", getOpenStatus());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("remarks", getRemarks());
		attributes.put("userId", getUserId());
		attributes.put("createdAt", getCreatedAt());
		attributes.put("updatedAt", getUpdatedAt());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String id = (String)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long distributionYear = (Long)attributes.get("distributionYear");

		if (distributionYear != null) {
			setDistributionYear(distributionYear);
		}

		String distributionMonth = (String)attributes.get("distributionMonth");

		if (distributionMonth != null) {
			setDistributionMonth(distributionMonth);
		}

		String openStatus = (String)attributes.get("openStatus");

		if (openStatus != null) {
			setOpenStatus(openStatus);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String remarks = (String)attributes.get("remarks");

		if (remarks != null) {
			setRemarks(remarks);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createdAt = (Date)attributes.get("createdAt");

		if (createdAt != null) {
			setCreatedAt(createdAt);
		}

		Date updatedAt = (Date)attributes.get("updatedAt");

		if (updatedAt != null) {
			setUpdatedAt(updatedAt);
		}
	}

	@Override
	public DgfDistributionSchedules cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the created at of this dgf distribution schedules.
	 *
	 * @return the created at of this dgf distribution schedules
	 */
	@Override
	public Date getCreatedAt() {
		return model.getCreatedAt();
	}

	/**
	 * Returns the distribution month of this dgf distribution schedules.
	 *
	 * @return the distribution month of this dgf distribution schedules
	 */
	@Override
	public String getDistributionMonth() {
		return model.getDistributionMonth();
	}

	/**
	 * Returns the distribution year of this dgf distribution schedules.
	 *
	 * @return the distribution year of this dgf distribution schedules
	 */
	@Override
	public long getDistributionYear() {
		return model.getDistributionYear();
	}

	/**
	 * Returns the end date of this dgf distribution schedules.
	 *
	 * @return the end date of this dgf distribution schedules
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the ID of this dgf distribution schedules.
	 *
	 * @return the ID of this dgf distribution schedules
	 */
	@Override
	public String getId() {
		return model.getId();
	}

	/**
	 * Returns the open status of this dgf distribution schedules.
	 *
	 * @return the open status of this dgf distribution schedules
	 */
	@Override
	public String getOpenStatus() {
		return model.getOpenStatus();
	}

	/**
	 * Returns the primary key of this dgf distribution schedules.
	 *
	 * @return the primary key of this dgf distribution schedules
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the remarks of this dgf distribution schedules.
	 *
	 * @return the remarks of this dgf distribution schedules
	 */
	@Override
	public String getRemarks() {
		return model.getRemarks();
	}

	/**
	 * Returns the start date of this dgf distribution schedules.
	 *
	 * @return the start date of this dgf distribution schedules
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the updated at of this dgf distribution schedules.
	 *
	 * @return the updated at of this dgf distribution schedules
	 */
	@Override
	public Date getUpdatedAt() {
		return model.getUpdatedAt();
	}

	/**
	 * Returns the user ID of this dgf distribution schedules.
	 *
	 * @return the user ID of this dgf distribution schedules
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this dgf distribution schedules.
	 *
	 * @return the user uuid of this dgf distribution schedules
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
	 * Sets the created at of this dgf distribution schedules.
	 *
	 * @param createdAt the created at of this dgf distribution schedules
	 */
	@Override
	public void setCreatedAt(Date createdAt) {
		model.setCreatedAt(createdAt);
	}

	/**
	 * Sets the distribution month of this dgf distribution schedules.
	 *
	 * @param distributionMonth the distribution month of this dgf distribution schedules
	 */
	@Override
	public void setDistributionMonth(String distributionMonth) {
		model.setDistributionMonth(distributionMonth);
	}

	/**
	 * Sets the distribution year of this dgf distribution schedules.
	 *
	 * @param distributionYear the distribution year of this dgf distribution schedules
	 */
	@Override
	public void setDistributionYear(long distributionYear) {
		model.setDistributionYear(distributionYear);
	}

	/**
	 * Sets the end date of this dgf distribution schedules.
	 *
	 * @param endDate the end date of this dgf distribution schedules
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the ID of this dgf distribution schedules.
	 *
	 * @param id the ID of this dgf distribution schedules
	 */
	@Override
	public void setId(String id) {
		model.setId(id);
	}

	/**
	 * Sets the open status of this dgf distribution schedules.
	 *
	 * @param openStatus the open status of this dgf distribution schedules
	 */
	@Override
	public void setOpenStatus(String openStatus) {
		model.setOpenStatus(openStatus);
	}

	/**
	 * Sets the primary key of this dgf distribution schedules.
	 *
	 * @param primaryKey the primary key of this dgf distribution schedules
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the remarks of this dgf distribution schedules.
	 *
	 * @param remarks the remarks of this dgf distribution schedules
	 */
	@Override
	public void setRemarks(String remarks) {
		model.setRemarks(remarks);
	}

	/**
	 * Sets the start date of this dgf distribution schedules.
	 *
	 * @param startDate the start date of this dgf distribution schedules
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the updated at of this dgf distribution schedules.
	 *
	 * @param updatedAt the updated at of this dgf distribution schedules
	 */
	@Override
	public void setUpdatedAt(Date updatedAt) {
		model.setUpdatedAt(updatedAt);
	}

	/**
	 * Sets the user ID of this dgf distribution schedules.
	 *
	 * @param userId the user ID of this dgf distribution schedules
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this dgf distribution schedules.
	 *
	 * @param userUuid the user uuid of this dgf distribution schedules
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
	protected DgfDistributionSchedulesWrapper wrap(
		DgfDistributionSchedules dgfDistributionSchedules) {

		return new DgfDistributionSchedulesWrapper(dgfDistributionSchedules);
	}

}