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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the dgfLocDistrict service. Represents a row in the &quot;dgf_loc_district&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>bd.gov.dgfood.food.grain.license.model.impl.dgfLocDistrictModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>bd.gov.dgfood.food.grain.license.model.impl.dgfLocDistrictImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see dgfLocDistrict
 * @generated
 */
@ProviderType
public interface dgfLocDistrictModel extends BaseModel<dgfLocDistrict> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a dgf loc district model instance should use the {@link dgfLocDistrict} interface instead.
	 */

	/**
	 * Returns the primary key of this dgf loc district.
	 *
	 * @return the primary key of this dgf loc district
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this dgf loc district.
	 *
	 * @param primaryKey the primary key of this dgf loc district
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this dgf loc district.
	 *
	 * @return the ID of this dgf loc district
	 */
	public long getId();

	/**
	 * Sets the ID of this dgf loc district.
	 *
	 * @param id the ID of this dgf loc district
	 */
	public void setId(long id);

	/**
	 * Returns the division ID of this dgf loc district.
	 *
	 * @return the division ID of this dgf loc district
	 */
	public long getDivisionId();

	/**
	 * Sets the division ID of this dgf loc district.
	 *
	 * @param divisionId the division ID of this dgf loc district
	 */
	public void setDivisionId(long divisionId);

	/**
	 * Returns the name of this dgf loc district.
	 *
	 * @return the name of this dgf loc district
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this dgf loc district.
	 *
	 * @param name the name of this dgf loc district
	 */
	public void setName(String name);

	/**
	 * Returns the bn name of this dgf loc district.
	 *
	 * @return the bn name of this dgf loc district
	 */
	@AutoEscape
	public String getBnName();

	/**
	 * Sets the bn name of this dgf loc district.
	 *
	 * @param bnName the bn name of this dgf loc district
	 */
	public void setBnName(String bnName);

	/**
	 * Returns the lat of this dgf loc district.
	 *
	 * @return the lat of this dgf loc district
	 */
	@AutoEscape
	public String getLat();

	/**
	 * Sets the lat of this dgf loc district.
	 *
	 * @param lat the lat of this dgf loc district
	 */
	public void setLat(String lat);

	/**
	 * Returns the lon of this dgf loc district.
	 *
	 * @return the lon of this dgf loc district
	 */
	@AutoEscape
	public String getLon();

	/**
	 * Sets the lon of this dgf loc district.
	 *
	 * @param lon the lon of this dgf loc district
	 */
	public void setLon(String lon);

	/**
	 * Returns the url of this dgf loc district.
	 *
	 * @return the url of this dgf loc district
	 */
	@AutoEscape
	public String getUrl();

	/**
	 * Sets the url of this dgf loc district.
	 *
	 * @param url the url of this dgf loc district
	 */
	public void setUrl(String url);

	/**
	 * Returns the status of this dgf loc district.
	 *
	 * @return the status of this dgf loc district
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this dgf loc district.
	 *
	 * @param status the status of this dgf loc district
	 */
	public void setStatus(String status);

	/**
	 * Returns the created at of this dgf loc district.
	 *
	 * @return the created at of this dgf loc district
	 */
	public Date getCreatedAt();

	/**
	 * Sets the created at of this dgf loc district.
	 *
	 * @param createdAt the created at of this dgf loc district
	 */
	public void setCreatedAt(Date createdAt);

	/**
	 * Returns the updated at of this dgf loc district.
	 *
	 * @return the updated at of this dgf loc district
	 */
	public Date getUpdatedAt();

	/**
	 * Sets the updated at of this dgf loc district.
	 *
	 * @param updatedAt the updated at of this dgf loc district
	 */
	public void setUpdatedAt(Date updatedAt);

	/**
	 * Returns the geo code of this dgf loc district.
	 *
	 * @return the geo code of this dgf loc district
	 */
	public long getGeoCode();

	/**
	 * Sets the geo code of this dgf loc district.
	 *
	 * @param geoCode the geo code of this dgf loc district
	 */
	public void setGeoCode(long geoCode);

	@Override
	public dgfLocDistrict cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}