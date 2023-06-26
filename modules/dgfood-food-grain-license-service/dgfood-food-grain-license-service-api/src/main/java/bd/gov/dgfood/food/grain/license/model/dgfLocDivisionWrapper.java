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
 * This class is a wrapper for {@link dgfLocDivision}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see dgfLocDivision
 * @generated
 */
public class dgfLocDivisionWrapper
	extends BaseModelWrapper<dgfLocDivision>
	implements dgfLocDivision, ModelWrapper<dgfLocDivision> {

	public dgfLocDivisionWrapper(dgfLocDivision dgfLocDivision) {
		super(dgfLocDivision);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("name", getName());
		attributes.put("bnName", getBnName());
		attributes.put("url", getUrl());
		attributes.put("status", getStatus());
		attributes.put("createdAt", getCreatedAt());
		attributes.put("updatedAt", getUpdatedAt());
		attributes.put("geoCode", getGeoCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String bnName = (String)attributes.get("bnName");

		if (bnName != null) {
			setBnName(bnName);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		String status = (String)attributes.get("status");

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

		Long geoCode = (Long)attributes.get("geoCode");

		if (geoCode != null) {
			setGeoCode(geoCode);
		}
	}

	@Override
	public dgfLocDivision cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the bn name of this dgf loc division.
	 *
	 * @return the bn name of this dgf loc division
	 */
	@Override
	public String getBnName() {
		return model.getBnName();
	}

	/**
	 * Returns the created at of this dgf loc division.
	 *
	 * @return the created at of this dgf loc division
	 */
	@Override
	public Date getCreatedAt() {
		return model.getCreatedAt();
	}

	/**
	 * Returns the geo code of this dgf loc division.
	 *
	 * @return the geo code of this dgf loc division
	 */
	@Override
	public long getGeoCode() {
		return model.getGeoCode();
	}

	/**
	 * Returns the ID of this dgf loc division.
	 *
	 * @return the ID of this dgf loc division
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the name of this dgf loc division.
	 *
	 * @return the name of this dgf loc division
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this dgf loc division.
	 *
	 * @return the primary key of this dgf loc division
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this dgf loc division.
	 *
	 * @return the status of this dgf loc division
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the updated at of this dgf loc division.
	 *
	 * @return the updated at of this dgf loc division
	 */
	@Override
	public Date getUpdatedAt() {
		return model.getUpdatedAt();
	}

	/**
	 * Returns the url of this dgf loc division.
	 *
	 * @return the url of this dgf loc division
	 */
	@Override
	public String getUrl() {
		return model.getUrl();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the bn name of this dgf loc division.
	 *
	 * @param bnName the bn name of this dgf loc division
	 */
	@Override
	public void setBnName(String bnName) {
		model.setBnName(bnName);
	}

	/**
	 * Sets the created at of this dgf loc division.
	 *
	 * @param createdAt the created at of this dgf loc division
	 */
	@Override
	public void setCreatedAt(Date createdAt) {
		model.setCreatedAt(createdAt);
	}

	/**
	 * Sets the geo code of this dgf loc division.
	 *
	 * @param geoCode the geo code of this dgf loc division
	 */
	@Override
	public void setGeoCode(long geoCode) {
		model.setGeoCode(geoCode);
	}

	/**
	 * Sets the ID of this dgf loc division.
	 *
	 * @param id the ID of this dgf loc division
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the name of this dgf loc division.
	 *
	 * @param name the name of this dgf loc division
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this dgf loc division.
	 *
	 * @param primaryKey the primary key of this dgf loc division
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this dgf loc division.
	 *
	 * @param status the status of this dgf loc division
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the updated at of this dgf loc division.
	 *
	 * @param updatedAt the updated at of this dgf loc division
	 */
	@Override
	public void setUpdatedAt(Date updatedAt) {
		model.setUpdatedAt(updatedAt);
	}

	/**
	 * Sets the url of this dgf loc division.
	 *
	 * @param url the url of this dgf loc division
	 */
	@Override
	public void setUrl(String url) {
		model.setUrl(url);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected dgfLocDivisionWrapper wrap(dgfLocDivision dgfLocDivision) {
		return new dgfLocDivisionWrapper(dgfLocDivision);
	}

}