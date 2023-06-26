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
 * This class is a wrapper for {@link dgfLocUnion}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see dgfLocUnion
 * @generated
 */
public class dgfLocUnionWrapper
	extends BaseModelWrapper<dgfLocUnion>
	implements dgfLocUnion, ModelWrapper<dgfLocUnion> {

	public dgfLocUnionWrapper(dgfLocUnion dgfLocUnion) {
		super(dgfLocUnion);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("subdistrictId", getSubdistrictId());
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

		Long subdistrictId = (Long)attributes.get("subdistrictId");

		if (subdistrictId != null) {
			setSubdistrictId(subdistrictId);
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
	public dgfLocUnion cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the bn name of this dgf loc union.
	 *
	 * @return the bn name of this dgf loc union
	 */
	@Override
	public String getBnName() {
		return model.getBnName();
	}

	/**
	 * Returns the created at of this dgf loc union.
	 *
	 * @return the created at of this dgf loc union
	 */
	@Override
	public Date getCreatedAt() {
		return model.getCreatedAt();
	}

	/**
	 * Returns the geo code of this dgf loc union.
	 *
	 * @return the geo code of this dgf loc union
	 */
	@Override
	public long getGeoCode() {
		return model.getGeoCode();
	}

	/**
	 * Returns the ID of this dgf loc union.
	 *
	 * @return the ID of this dgf loc union
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the name of this dgf loc union.
	 *
	 * @return the name of this dgf loc union
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this dgf loc union.
	 *
	 * @return the primary key of this dgf loc union
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this dgf loc union.
	 *
	 * @return the status of this dgf loc union
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the subdistrict ID of this dgf loc union.
	 *
	 * @return the subdistrict ID of this dgf loc union
	 */
	@Override
	public long getSubdistrictId() {
		return model.getSubdistrictId();
	}

	/**
	 * Returns the updated at of this dgf loc union.
	 *
	 * @return the updated at of this dgf loc union
	 */
	@Override
	public Date getUpdatedAt() {
		return model.getUpdatedAt();
	}

	/**
	 * Returns the url of this dgf loc union.
	 *
	 * @return the url of this dgf loc union
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
	 * Sets the bn name of this dgf loc union.
	 *
	 * @param bnName the bn name of this dgf loc union
	 */
	@Override
	public void setBnName(String bnName) {
		model.setBnName(bnName);
	}

	/**
	 * Sets the created at of this dgf loc union.
	 *
	 * @param createdAt the created at of this dgf loc union
	 */
	@Override
	public void setCreatedAt(Date createdAt) {
		model.setCreatedAt(createdAt);
	}

	/**
	 * Sets the geo code of this dgf loc union.
	 *
	 * @param geoCode the geo code of this dgf loc union
	 */
	@Override
	public void setGeoCode(long geoCode) {
		model.setGeoCode(geoCode);
	}

	/**
	 * Sets the ID of this dgf loc union.
	 *
	 * @param id the ID of this dgf loc union
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the name of this dgf loc union.
	 *
	 * @param name the name of this dgf loc union
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this dgf loc union.
	 *
	 * @param primaryKey the primary key of this dgf loc union
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this dgf loc union.
	 *
	 * @param status the status of this dgf loc union
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the subdistrict ID of this dgf loc union.
	 *
	 * @param subdistrictId the subdistrict ID of this dgf loc union
	 */
	@Override
	public void setSubdistrictId(long subdistrictId) {
		model.setSubdistrictId(subdistrictId);
	}

	/**
	 * Sets the updated at of this dgf loc union.
	 *
	 * @param updatedAt the updated at of this dgf loc union
	 */
	@Override
	public void setUpdatedAt(Date updatedAt) {
		model.setUpdatedAt(updatedAt);
	}

	/**
	 * Sets the url of this dgf loc union.
	 *
	 * @param url the url of this dgf loc union
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
	protected dgfLocUnionWrapper wrap(dgfLocUnion dgfLocUnion) {
		return new dgfLocUnionWrapper(dgfLocUnion);
	}

}