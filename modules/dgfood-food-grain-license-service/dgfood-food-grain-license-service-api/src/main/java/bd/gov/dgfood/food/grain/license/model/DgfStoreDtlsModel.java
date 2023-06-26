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
 * The base model interface for the DgfStoreDtls service. Represents a row in the &quot;dgf_store_dtls&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>bd.gov.dgfood.food.grain.license.model.impl.DgfStoreDtlsModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>bd.gov.dgfood.food.grain.license.model.impl.DgfStoreDtlsImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfStoreDtls
 * @generated
 */
@ProviderType
public interface DgfStoreDtlsModel extends BaseModel<DgfStoreDtls> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a dgf store dtls model instance should use the {@link DgfStoreDtls} interface instead.
	 */

	/**
	 * Returns the primary key of this dgf store dtls.
	 *
	 * @return the primary key of this dgf store dtls
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this dgf store dtls.
	 *
	 * @param primaryKey the primary key of this dgf store dtls
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this dgf store dtls.
	 *
	 * @return the ID of this dgf store dtls
	 */
	public long getId();

	/**
	 * Sets the ID of this dgf store dtls.
	 *
	 * @param id the ID of this dgf store dtls
	 */
	public void setId(long id);

	/**
	 * Returns the national ID of this dgf store dtls.
	 *
	 * @return the national ID of this dgf store dtls
	 */
	@AutoEscape
	public String getNationalId();

	/**
	 * Sets the national ID of this dgf store dtls.
	 *
	 * @param nationalId the national ID of this dgf store dtls
	 */
	public void setNationalId(String nationalId);

	/**
	 * Returns the type of this dgf store dtls.
	 *
	 * @return the type of this dgf store dtls
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this dgf store dtls.
	 *
	 * @param type the type of this dgf store dtls
	 */
	public void setType(String type);

	/**
	 * Returns the mouza of this dgf store dtls.
	 *
	 * @return the mouza of this dgf store dtls
	 */
	@AutoEscape
	public String getMouza();

	/**
	 * Sets the mouza of this dgf store dtls.
	 *
	 * @param mouza the mouza of this dgf store dtls
	 */
	public void setMouza(String mouza);

	/**
	 * Returns the khatiyn of this dgf store dtls.
	 *
	 * @return the khatiyn of this dgf store dtls
	 */
	@AutoEscape
	public String getKhatiyn();

	/**
	 * Sets the khatiyn of this dgf store dtls.
	 *
	 * @param khatiyn the khatiyn of this dgf store dtls
	 */
	public void setKhatiyn(String khatiyn);

	/**
	 * Returns the dag no of this dgf store dtls.
	 *
	 * @return the dag no of this dgf store dtls
	 */
	@AutoEscape
	public String getDagNo();

	/**
	 * Sets the dag no of this dgf store dtls.
	 *
	 * @param DagNo the dag no of this dgf store dtls
	 */
	public void setDagNo(String DagNo);

	/**
	 * Returns the division of this dgf store dtls.
	 *
	 * @return the division of this dgf store dtls
	 */
	public long getDivision();

	/**
	 * Sets the division of this dgf store dtls.
	 *
	 * @param division the division of this dgf store dtls
	 */
	public void setDivision(long division);

	/**
	 * Returns the district of this dgf store dtls.
	 *
	 * @return the district of this dgf store dtls
	 */
	public long getDistrict();

	/**
	 * Sets the district of this dgf store dtls.
	 *
	 * @param district the district of this dgf store dtls
	 */
	public void setDistrict(long district);

	/**
	 * Returns the upzilla of this dgf store dtls.
	 *
	 * @return the upzilla of this dgf store dtls
	 */
	public long getUpzilla();

	/**
	 * Sets the upzilla of this dgf store dtls.
	 *
	 * @param upzilla the upzilla of this dgf store dtls
	 */
	public void setUpzilla(long upzilla);

	/**
	 * Returns the union name of this dgf store dtls.
	 *
	 * @return the union name of this dgf store dtls
	 */
	public long getUnionName();

	/**
	 * Sets the union name of this dgf store dtls.
	 *
	 * @param unionName the union name of this dgf store dtls
	 */
	public void setUnionName(long unionName);

	/**
	 * Returns the city crprtn of this dgf store dtls.
	 *
	 * @return the city crprtn of this dgf store dtls
	 */
	public long getCityCrprtn();

	/**
	 * Sets the city crprtn of this dgf store dtls.
	 *
	 * @param cityCrprtn the city crprtn of this dgf store dtls
	 */
	public void setCityCrprtn(long cityCrprtn);

	/**
	 * Returns the dics hight of this dgf store dtls.
	 *
	 * @return the dics hight of this dgf store dtls
	 */
	@AutoEscape
	public String getDicsHight();

	/**
	 * Sets the dics hight of this dgf store dtls.
	 *
	 * @param dicsHight the dics hight of this dgf store dtls
	 */
	public void setDicsHight(String dicsHight);

	/**
	 * Returns the dics width of this dgf store dtls.
	 *
	 * @return the dics width of this dgf store dtls
	 */
	@AutoEscape
	public String getDicsWidth();

	/**
	 * Sets the dics width of this dgf store dtls.
	 *
	 * @param dicsWidth the dics width of this dgf store dtls
	 */
	public void setDicsWidth(String dicsWidth);

	/**
	 * Returns the dics lngth of this dgf store dtls.
	 *
	 * @return the dics lngth of this dgf store dtls
	 */
	@AutoEscape
	public String getDicsLngth();

	/**
	 * Sets the dics lngth of this dgf store dtls.
	 *
	 * @param dicsLngth the dics lngth of this dgf store dtls
	 */
	public void setDicsLngth(String dicsLngth);

	/**
	 * Returns the dics cpacty of this dgf store dtls.
	 *
	 * @return the dics cpacty of this dgf store dtls
	 */
	public long getDicsCpacty();

	/**
	 * Sets the dics cpacty of this dgf store dtls.
	 *
	 * @param dicsCpacty the dics cpacty of this dgf store dtls
	 */
	public void setDicsCpacty(long dicsCpacty);

	/**
	 * Returns the total cpacty of this dgf store dtls.
	 *
	 * @return the total cpacty of this dgf store dtls
	 */
	public long getTotalCpacty();

	/**
	 * Sets the total cpacty of this dgf store dtls.
	 *
	 * @param totalCpacty the total cpacty of this dgf store dtls
	 */
	public void setTotalCpacty(long totalCpacty);

	/**
	 * Returns the created at of this dgf store dtls.
	 *
	 * @return the created at of this dgf store dtls
	 */
	public Date getCreatedAt();

	/**
	 * Sets the created at of this dgf store dtls.
	 *
	 * @param createdAt the created at of this dgf store dtls
	 */
	public void setCreatedAt(Date createdAt);

	/**
	 * Returns the updated at of this dgf store dtls.
	 *
	 * @return the updated at of this dgf store dtls
	 */
	public Date getUpdatedAt();

	/**
	 * Sets the updated at of this dgf store dtls.
	 *
	 * @param updatedAt the updated at of this dgf store dtls
	 */
	public void setUpdatedAt(Date updatedAt);

	/**
	 * Returns the flag of this dgf store dtls.
	 *
	 * @return the flag of this dgf store dtls
	 */
	public int getFlag();

	/**
	 * Sets the flag of this dgf store dtls.
	 *
	 * @param flag the flag of this dgf store dtls
	 */
	public void setFlag(int flag);

	@Override
	public DgfStoreDtls cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}