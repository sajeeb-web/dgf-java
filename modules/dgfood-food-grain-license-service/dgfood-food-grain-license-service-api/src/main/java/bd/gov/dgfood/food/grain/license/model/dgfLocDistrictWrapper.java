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
 * This class is a wrapper for {@link dgfLocDistrict}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see dgfLocDistrict
 * @generated
 */
public class dgfLocDistrictWrapper
	extends BaseModelWrapper<dgfLocDistrict>
	implements dgfLocDistrict, ModelWrapper<dgfLocDistrict> {

	public dgfLocDistrictWrapper(dgfLocDistrict dgfLocDistrict) {
		super(dgfLocDistrict);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("divisionId", getDivisionId());
		attributes.put("name", getName());
		attributes.put("bnName", getBnName());
		attributes.put("lat", getLat());
		attributes.put("lon", getLon());
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

		Long divisionId = (Long)attributes.get("divisionId");

		if (divisionId != null) {
			setDivisionId(divisionId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String bnName = (String)attributes.get("bnName");

		if (bnName != null) {
			setBnName(bnName);
		}

		String lat = (String)attributes.get("lat");

		if (lat != null) {
			setLat(lat);
		}

		String lon = (String)attributes.get("lon");

		if (lon != null) {
			setLon(lon);
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
	public dgfLocDistrict cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the bn name of this dgf loc district.
	 *
	 * @return the bn name of this dgf loc district
	 */
	@Override
	public String getBnName() {
		return model.getBnName();
	}

	/**
	 * Returns the created at of this dgf loc district.
	 *
	 * @return the created at of this dgf loc district
	 */
	@Override
	public Date getCreatedAt() {
		return model.getCreatedAt();
	}

	/**
	 * Returns the division ID of this dgf loc district.
	 *
	 * @return the division ID of this dgf loc district
	 */
	@Override
	public long getDivisionId() {
		return model.getDivisionId();
	}

	/**
	 * Returns the geo code of this dgf loc district.
	 *
	 * @return the geo code of this dgf loc district
	 */
	@Override
	public long getGeoCode() {
		return model.getGeoCode();
	}

	/**
	 * Returns the ID of this dgf loc district.
	 *
	 * @return the ID of this dgf loc district
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the lat of this dgf loc district.
	 *
	 * @return the lat of this dgf loc district
	 */
	@Override
	public String getLat() {
		return model.getLat();
	}

	/**
	 * Returns the lon of this dgf loc district.
	 *
	 * @return the lon of this dgf loc district
	 */
	@Override
	public String getLon() {
		return model.getLon();
	}

	/**
	 * Returns the name of this dgf loc district.
	 *
	 * @return the name of this dgf loc district
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this dgf loc district.
	 *
	 * @return the primary key of this dgf loc district
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this dgf loc district.
	 *
	 * @return the status of this dgf loc district
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the updated at of this dgf loc district.
	 *
	 * @return the updated at of this dgf loc district
	 */
	@Override
	public Date getUpdatedAt() {
		return model.getUpdatedAt();
	}

	/**
	 * Returns the url of this dgf loc district.
	 *
	 * @return the url of this dgf loc district
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
	 * Sets the bn name of this dgf loc district.
	 *
	 * @param bnName the bn name of this dgf loc district
	 */
	@Override
	public void setBnName(String bnName) {
		model.setBnName(bnName);
	}

	/**
	 * Sets the created at of this dgf loc district.
	 *
	 * @param createdAt the created at of this dgf loc district
	 */
	@Override
	public void setCreatedAt(Date createdAt) {
		model.setCreatedAt(createdAt);
	}

	/**
	 * Sets the division ID of this dgf loc district.
	 *
	 * @param divisionId the division ID of this dgf loc district
	 */
	@Override
	public void setDivisionId(long divisionId) {
		model.setDivisionId(divisionId);
	}

	/**
	 * Sets the geo code of this dgf loc district.
	 *
	 * @param geoCode the geo code of this dgf loc district
	 */
	@Override
	public void setGeoCode(long geoCode) {
		model.setGeoCode(geoCode);
	}

	/**
	 * Sets the ID of this dgf loc district.
	 *
	 * @param id the ID of this dgf loc district
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the lat of this dgf loc district.
	 *
	 * @param lat the lat of this dgf loc district
	 */
	@Override
	public void setLat(String lat) {
		model.setLat(lat);
	}

	/**
	 * Sets the lon of this dgf loc district.
	 *
	 * @param lon the lon of this dgf loc district
	 */
	@Override
	public void setLon(String lon) {
		model.setLon(lon);
	}

	/**
	 * Sets the name of this dgf loc district.
	 *
	 * @param name the name of this dgf loc district
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this dgf loc district.
	 *
	 * @param primaryKey the primary key of this dgf loc district
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this dgf loc district.
	 *
	 * @param status the status of this dgf loc district
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the updated at of this dgf loc district.
	 *
	 * @param updatedAt the updated at of this dgf loc district
	 */
	@Override
	public void setUpdatedAt(Date updatedAt) {
		model.setUpdatedAt(updatedAt);
	}

	/**
	 * Sets the url of this dgf loc district.
	 *
	 * @param url the url of this dgf loc district
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
	protected dgfLocDistrictWrapper wrap(dgfLocDistrict dgfLocDistrict) {
		return new dgfLocDistrictWrapper(dgfLocDistrict);
	}

}