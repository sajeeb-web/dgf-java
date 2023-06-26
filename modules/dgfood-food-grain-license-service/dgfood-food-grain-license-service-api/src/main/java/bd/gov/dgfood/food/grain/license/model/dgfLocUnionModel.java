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
 * The base model interface for the dgfLocUnion service. Represents a row in the &quot;dgf_loc_union&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>bd.gov.dgfood.food.grain.license.model.impl.dgfLocUnionModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>bd.gov.dgfood.food.grain.license.model.impl.dgfLocUnionImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see dgfLocUnion
 * @generated
 */
@ProviderType
public interface dgfLocUnionModel extends BaseModel<dgfLocUnion> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a dgf loc union model instance should use the {@link dgfLocUnion} interface instead.
	 */

	/**
	 * Returns the primary key of this dgf loc union.
	 *
	 * @return the primary key of this dgf loc union
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this dgf loc union.
	 *
	 * @param primaryKey the primary key of this dgf loc union
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this dgf loc union.
	 *
	 * @return the ID of this dgf loc union
	 */
	public long getId();

	/**
	 * Sets the ID of this dgf loc union.
	 *
	 * @param id the ID of this dgf loc union
	 */
	public void setId(long id);

	/**
	 * Returns the subdistrict ID of this dgf loc union.
	 *
	 * @return the subdistrict ID of this dgf loc union
	 */
	public long getSubdistrictId();

	/**
	 * Sets the subdistrict ID of this dgf loc union.
	 *
	 * @param subdistrictId the subdistrict ID of this dgf loc union
	 */
	public void setSubdistrictId(long subdistrictId);

	/**
	 * Returns the name of this dgf loc union.
	 *
	 * @return the name of this dgf loc union
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this dgf loc union.
	 *
	 * @param name the name of this dgf loc union
	 */
	public void setName(String name);

	/**
	 * Returns the bn name of this dgf loc union.
	 *
	 * @return the bn name of this dgf loc union
	 */
	@AutoEscape
	public String getBnName();

	/**
	 * Sets the bn name of this dgf loc union.
	 *
	 * @param bnName the bn name of this dgf loc union
	 */
	public void setBnName(String bnName);

	/**
	 * Returns the url of this dgf loc union.
	 *
	 * @return the url of this dgf loc union
	 */
	@AutoEscape
	public String getUrl();

	/**
	 * Sets the url of this dgf loc union.
	 *
	 * @param url the url of this dgf loc union
	 */
	public void setUrl(String url);

	/**
	 * Returns the status of this dgf loc union.
	 *
	 * @return the status of this dgf loc union
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this dgf loc union.
	 *
	 * @param status the status of this dgf loc union
	 */
	public void setStatus(String status);

	/**
	 * Returns the created at of this dgf loc union.
	 *
	 * @return the created at of this dgf loc union
	 */
	public Date getCreatedAt();

	/**
	 * Sets the created at of this dgf loc union.
	 *
	 * @param createdAt the created at of this dgf loc union
	 */
	public void setCreatedAt(Date createdAt);

	/**
	 * Returns the updated at of this dgf loc union.
	 *
	 * @return the updated at of this dgf loc union
	 */
	public Date getUpdatedAt();

	/**
	 * Sets the updated at of this dgf loc union.
	 *
	 * @param updatedAt the updated at of this dgf loc union
	 */
	public void setUpdatedAt(Date updatedAt);

	/**
	 * Returns the geo code of this dgf loc union.
	 *
	 * @return the geo code of this dgf loc union
	 */
	public long getGeoCode();

	/**
	 * Sets the geo code of this dgf loc union.
	 *
	 * @param geoCode the geo code of this dgf loc union
	 */
	public void setGeoCode(long geoCode);

	@Override
	public dgfLocUnion cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}