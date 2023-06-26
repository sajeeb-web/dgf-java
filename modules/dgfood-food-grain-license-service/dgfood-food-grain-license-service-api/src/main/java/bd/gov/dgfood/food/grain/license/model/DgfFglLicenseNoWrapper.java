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
 * This class is a wrapper for {@link DgfFglLicenseNo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfFglLicenseNo
 * @generated
 */
public class DgfFglLicenseNoWrapper
	extends BaseModelWrapper<DgfFglLicenseNo>
	implements DgfFglLicenseNo, ModelWrapper<DgfFglLicenseNo> {

	public DgfFglLicenseNoWrapper(DgfFglLicenseNo dgfFglLicenseNo) {
		super(dgfFglLicenseNo);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("suffix", getSuffix());
		attributes.put("prefix", getPrefix());
		attributes.put("serialNo", getSerialNo());
		attributes.put("licenseNo", getLicenseNo());
		attributes.put("createdAt", getCreatedAt());
		attributes.put("updatedAt", getUpdatedAt());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long suffix = (Long)attributes.get("suffix");

		if (suffix != null) {
			setSuffix(suffix);
		}

		Long prefix = (Long)attributes.get("prefix");

		if (prefix != null) {
			setPrefix(prefix);
		}

		Long serialNo = (Long)attributes.get("serialNo");

		if (serialNo != null) {
			setSerialNo(serialNo);
		}

		String licenseNo = (String)attributes.get("licenseNo");

		if (licenseNo != null) {
			setLicenseNo(licenseNo);
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
	public DgfFglLicenseNo cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the created at of this dgf fgl license no.
	 *
	 * @return the created at of this dgf fgl license no
	 */
	@Override
	public Date getCreatedAt() {
		return model.getCreatedAt();
	}

	/**
	 * Returns the ID of this dgf fgl license no.
	 *
	 * @return the ID of this dgf fgl license no
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the license no of this dgf fgl license no.
	 *
	 * @return the license no of this dgf fgl license no
	 */
	@Override
	public String getLicenseNo() {
		return model.getLicenseNo();
	}

	/**
	 * Returns the prefix of this dgf fgl license no.
	 *
	 * @return the prefix of this dgf fgl license no
	 */
	@Override
	public long getPrefix() {
		return model.getPrefix();
	}

	/**
	 * Returns the primary key of this dgf fgl license no.
	 *
	 * @return the primary key of this dgf fgl license no
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the serial no of this dgf fgl license no.
	 *
	 * @return the serial no of this dgf fgl license no
	 */
	@Override
	public long getSerialNo() {
		return model.getSerialNo();
	}

	/**
	 * Returns the suffix of this dgf fgl license no.
	 *
	 * @return the suffix of this dgf fgl license no
	 */
	@Override
	public long getSuffix() {
		return model.getSuffix();
	}

	/**
	 * Returns the updated at of this dgf fgl license no.
	 *
	 * @return the updated at of this dgf fgl license no
	 */
	@Override
	public Date getUpdatedAt() {
		return model.getUpdatedAt();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the created at of this dgf fgl license no.
	 *
	 * @param createdAt the created at of this dgf fgl license no
	 */
	@Override
	public void setCreatedAt(Date createdAt) {
		model.setCreatedAt(createdAt);
	}

	/**
	 * Sets the ID of this dgf fgl license no.
	 *
	 * @param id the ID of this dgf fgl license no
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the license no of this dgf fgl license no.
	 *
	 * @param licenseNo the license no of this dgf fgl license no
	 */
	@Override
	public void setLicenseNo(String licenseNo) {
		model.setLicenseNo(licenseNo);
	}

	/**
	 * Sets the prefix of this dgf fgl license no.
	 *
	 * @param prefix the prefix of this dgf fgl license no
	 */
	@Override
	public void setPrefix(long prefix) {
		model.setPrefix(prefix);
	}

	/**
	 * Sets the primary key of this dgf fgl license no.
	 *
	 * @param primaryKey the primary key of this dgf fgl license no
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the serial no of this dgf fgl license no.
	 *
	 * @param serialNo the serial no of this dgf fgl license no
	 */
	@Override
	public void setSerialNo(long serialNo) {
		model.setSerialNo(serialNo);
	}

	/**
	 * Sets the suffix of this dgf fgl license no.
	 *
	 * @param suffix the suffix of this dgf fgl license no
	 */
	@Override
	public void setSuffix(long suffix) {
		model.setSuffix(suffix);
	}

	/**
	 * Sets the updated at of this dgf fgl license no.
	 *
	 * @param updatedAt the updated at of this dgf fgl license no
	 */
	@Override
	public void setUpdatedAt(Date updatedAt) {
		model.setUpdatedAt(updatedAt);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DgfFglLicenseNoWrapper wrap(DgfFglLicenseNo dgfFglLicenseNo) {
		return new DgfFglLicenseNoWrapper(dgfFglLicenseNo);
	}

}