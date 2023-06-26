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
 * This class is a wrapper for {@link dgfLocSubdistrict}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see dgfLocSubdistrict
 * @generated
 */
public class dgfLocSubdistrictWrapper
	extends BaseModelWrapper<dgfLocSubdistrict>
	implements dgfLocSubdistrict, ModelWrapper<dgfLocSubdistrict> {

	public dgfLocSubdistrictWrapper(dgfLocSubdistrict dgfLocSubdistrict) {
		super(dgfLocSubdistrict);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("districtId", getDistrictId());
		attributes.put("name", getName());
		attributes.put("bnName", getBnName());
		attributes.put("url", getUrl());
		attributes.put("status", getStatus());
		attributes.put("createdAt", getCreatedAt());
		attributes.put("updatedAt", getUpdatedAt());
		attributes.put("geoCode", getGeoCode());
		attributes.put("roleName", getRoleName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long districtId = (Long)attributes.get("districtId");

		if (districtId != null) {
			setDistrictId(districtId);
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

		String roleName = (String)attributes.get("roleName");

		if (roleName != null) {
			setRoleName(roleName);
		}
	}

	@Override
	public dgfLocSubdistrict cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the bn name of this dgf loc subdistrict.
	 *
	 * @return the bn name of this dgf loc subdistrict
	 */
	@Override
	public String getBnName() {
		return model.getBnName();
	}

	/**
	 * Returns the created at of this dgf loc subdistrict.
	 *
	 * @return the created at of this dgf loc subdistrict
	 */
	@Override
	public Date getCreatedAt() {
		return model.getCreatedAt();
	}

	/**
	 * Returns the district ID of this dgf loc subdistrict.
	 *
	 * @return the district ID of this dgf loc subdistrict
	 */
	@Override
	public long getDistrictId() {
		return model.getDistrictId();
	}

	/**
	 * Returns the geo code of this dgf loc subdistrict.
	 *
	 * @return the geo code of this dgf loc subdistrict
	 */
	@Override
	public long getGeoCode() {
		return model.getGeoCode();
	}

	/**
	 * Returns the ID of this dgf loc subdistrict.
	 *
	 * @return the ID of this dgf loc subdistrict
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the name of this dgf loc subdistrict.
	 *
	 * @return the name of this dgf loc subdistrict
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this dgf loc subdistrict.
	 *
	 * @return the primary key of this dgf loc subdistrict
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the role name of this dgf loc subdistrict.
	 *
	 * @return the role name of this dgf loc subdistrict
	 */
	@Override
	public String getRoleName() {
		return model.getRoleName();
	}

	/**
	 * Returns the status of this dgf loc subdistrict.
	 *
	 * @return the status of this dgf loc subdistrict
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the updated at of this dgf loc subdistrict.
	 *
	 * @return the updated at of this dgf loc subdistrict
	 */
	@Override
	public Date getUpdatedAt() {
		return model.getUpdatedAt();
	}

	/**
	 * Returns the url of this dgf loc subdistrict.
	 *
	 * @return the url of this dgf loc subdistrict
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
	 * Sets the bn name of this dgf loc subdistrict.
	 *
	 * @param bnName the bn name of this dgf loc subdistrict
	 */
	@Override
	public void setBnName(String bnName) {
		model.setBnName(bnName);
	}

	/**
	 * Sets the created at of this dgf loc subdistrict.
	 *
	 * @param createdAt the created at of this dgf loc subdistrict
	 */
	@Override
	public void setCreatedAt(Date createdAt) {
		model.setCreatedAt(createdAt);
	}

	/**
	 * Sets the district ID of this dgf loc subdistrict.
	 *
	 * @param districtId the district ID of this dgf loc subdistrict
	 */
	@Override
	public void setDistrictId(long districtId) {
		model.setDistrictId(districtId);
	}

	/**
	 * Sets the geo code of this dgf loc subdistrict.
	 *
	 * @param geoCode the geo code of this dgf loc subdistrict
	 */
	@Override
	public void setGeoCode(long geoCode) {
		model.setGeoCode(geoCode);
	}

	/**
	 * Sets the ID of this dgf loc subdistrict.
	 *
	 * @param id the ID of this dgf loc subdistrict
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the name of this dgf loc subdistrict.
	 *
	 * @param name the name of this dgf loc subdistrict
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this dgf loc subdistrict.
	 *
	 * @param primaryKey the primary key of this dgf loc subdistrict
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the role name of this dgf loc subdistrict.
	 *
	 * @param roleName the role name of this dgf loc subdistrict
	 */
	@Override
	public void setRoleName(String roleName) {
		model.setRoleName(roleName);
	}

	/**
	 * Sets the status of this dgf loc subdistrict.
	 *
	 * @param status the status of this dgf loc subdistrict
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the updated at of this dgf loc subdistrict.
	 *
	 * @param updatedAt the updated at of this dgf loc subdistrict
	 */
	@Override
	public void setUpdatedAt(Date updatedAt) {
		model.setUpdatedAt(updatedAt);
	}

	/**
	 * Sets the url of this dgf loc subdistrict.
	 *
	 * @param url the url of this dgf loc subdistrict
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
	protected dgfLocSubdistrictWrapper wrap(
		dgfLocSubdistrict dgfLocSubdistrict) {

		return new dgfLocSubdistrictWrapper(dgfLocSubdistrict);
	}

}