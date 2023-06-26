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
 * This class is a wrapper for {@link DgfUsersAddrDtls}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersAddrDtls
 * @generated
 */
public class DgfUsersAddrDtlsWrapper
	extends BaseModelWrapper<DgfUsersAddrDtls>
	implements DgfUsersAddrDtls, ModelWrapper<DgfUsersAddrDtls> {

	public DgfUsersAddrDtlsWrapper(DgfUsersAddrDtls dgfUsersAddrDtls) {
		super(dgfUsersAddrDtls);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("addressId", getAddressId());
		attributes.put("nationalId", getNationalId());
		attributes.put("classPk", getClassPk());
		attributes.put("className", getClassName());
		attributes.put("addressType", getAddressType());
		attributes.put("division", getDivision());
		attributes.put("district", getDistrict());
		attributes.put("upzilla", getUpzilla());
		attributes.put("unionName", getUnionName());
		attributes.put("village", getVillage());
		attributes.put("ward", getWard());
		attributes.put("zipCode", getZipCode());
		attributes.put("postOffice", getPostOffice());
		attributes.put("houseAddress", getHouseAddress());
		attributes.put("lastUpdatedDate", getLastUpdatedDate());
		attributes.put("lastUpdatedBy", getLastUpdatedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long addressId = (Long)attributes.get("addressId");

		if (addressId != null) {
			setAddressId(addressId);
		}

		Long nationalId = (Long)attributes.get("nationalId");

		if (nationalId != null) {
			setNationalId(nationalId);
		}

		Long classPk = (Long)attributes.get("classPk");

		if (classPk != null) {
			setClassPk(classPk);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		String addressType = (String)attributes.get("addressType");

		if (addressType != null) {
			setAddressType(addressType);
		}

		Long division = (Long)attributes.get("division");

		if (division != null) {
			setDivision(division);
		}

		Long district = (Long)attributes.get("district");

		if (district != null) {
			setDistrict(district);
		}

		Long upzilla = (Long)attributes.get("upzilla");

		if (upzilla != null) {
			setUpzilla(upzilla);
		}

		Long unionName = (Long)attributes.get("unionName");

		if (unionName != null) {
			setUnionName(unionName);
		}

		String village = (String)attributes.get("village");

		if (village != null) {
			setVillage(village);
		}

		String ward = (String)attributes.get("ward");

		if (ward != null) {
			setWard(ward);
		}

		String zipCode = (String)attributes.get("zipCode");

		if (zipCode != null) {
			setZipCode(zipCode);
		}

		String postOffice = (String)attributes.get("postOffice");

		if (postOffice != null) {
			setPostOffice(postOffice);
		}

		String houseAddress = (String)attributes.get("houseAddress");

		if (houseAddress != null) {
			setHouseAddress(houseAddress);
		}

		Date lastUpdatedDate = (Date)attributes.get("lastUpdatedDate");

		if (lastUpdatedDate != null) {
			setLastUpdatedDate(lastUpdatedDate);
		}

		Date lastUpdatedBy = (Date)attributes.get("lastUpdatedBy");

		if (lastUpdatedBy != null) {
			setLastUpdatedBy(lastUpdatedBy);
		}
	}

	@Override
	public DgfUsersAddrDtls cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the address ID of this dgf users addr dtls.
	 *
	 * @return the address ID of this dgf users addr dtls
	 */
	@Override
	public long getAddressId() {
		return model.getAddressId();
	}

	/**
	 * Returns the address type of this dgf users addr dtls.
	 *
	 * @return the address type of this dgf users addr dtls
	 */
	@Override
	public String getAddressType() {
		return model.getAddressType();
	}

	/**
	 * Returns the class name of this dgf users addr dtls.
	 *
	 * @return the class name of this dgf users addr dtls
	 */
	@Override
	public String getClassName() {
		return model.getClassName();
	}

	/**
	 * Returns the class pk of this dgf users addr dtls.
	 *
	 * @return the class pk of this dgf users addr dtls
	 */
	@Override
	public long getClassPk() {
		return model.getClassPk();
	}

	/**
	 * Returns the district of this dgf users addr dtls.
	 *
	 * @return the district of this dgf users addr dtls
	 */
	@Override
	public long getDistrict() {
		return model.getDistrict();
	}

	/**
	 * Returns the division of this dgf users addr dtls.
	 *
	 * @return the division of this dgf users addr dtls
	 */
	@Override
	public long getDivision() {
		return model.getDivision();
	}

	/**
	 * Returns the house address of this dgf users addr dtls.
	 *
	 * @return the house address of this dgf users addr dtls
	 */
	@Override
	public String getHouseAddress() {
		return model.getHouseAddress();
	}

	/**
	 * Returns the last updated by of this dgf users addr dtls.
	 *
	 * @return the last updated by of this dgf users addr dtls
	 */
	@Override
	public Date getLastUpdatedBy() {
		return model.getLastUpdatedBy();
	}

	/**
	 * Returns the last updated date of this dgf users addr dtls.
	 *
	 * @return the last updated date of this dgf users addr dtls
	 */
	@Override
	public Date getLastUpdatedDate() {
		return model.getLastUpdatedDate();
	}

	/**
	 * Returns the national ID of this dgf users addr dtls.
	 *
	 * @return the national ID of this dgf users addr dtls
	 */
	@Override
	public long getNationalId() {
		return model.getNationalId();
	}

	/**
	 * Returns the post office of this dgf users addr dtls.
	 *
	 * @return the post office of this dgf users addr dtls
	 */
	@Override
	public String getPostOffice() {
		return model.getPostOffice();
	}

	/**
	 * Returns the primary key of this dgf users addr dtls.
	 *
	 * @return the primary key of this dgf users addr dtls
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the union name of this dgf users addr dtls.
	 *
	 * @return the union name of this dgf users addr dtls
	 */
	@Override
	public long getUnionName() {
		return model.getUnionName();
	}

	/**
	 * Returns the upzilla of this dgf users addr dtls.
	 *
	 * @return the upzilla of this dgf users addr dtls
	 */
	@Override
	public long getUpzilla() {
		return model.getUpzilla();
	}

	/**
	 * Returns the village of this dgf users addr dtls.
	 *
	 * @return the village of this dgf users addr dtls
	 */
	@Override
	public String getVillage() {
		return model.getVillage();
	}

	/**
	 * Returns the ward of this dgf users addr dtls.
	 *
	 * @return the ward of this dgf users addr dtls
	 */
	@Override
	public String getWard() {
		return model.getWard();
	}

	/**
	 * Returns the zip code of this dgf users addr dtls.
	 *
	 * @return the zip code of this dgf users addr dtls
	 */
	@Override
	public String getZipCode() {
		return model.getZipCode();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address ID of this dgf users addr dtls.
	 *
	 * @param addressId the address ID of this dgf users addr dtls
	 */
	@Override
	public void setAddressId(long addressId) {
		model.setAddressId(addressId);
	}

	/**
	 * Sets the address type of this dgf users addr dtls.
	 *
	 * @param addressType the address type of this dgf users addr dtls
	 */
	@Override
	public void setAddressType(String addressType) {
		model.setAddressType(addressType);
	}

	/**
	 * Sets the class name of this dgf users addr dtls.
	 *
	 * @param className the class name of this dgf users addr dtls
	 */
	@Override
	public void setClassName(String className) {
		model.setClassName(className);
	}

	/**
	 * Sets the class pk of this dgf users addr dtls.
	 *
	 * @param classPk the class pk of this dgf users addr dtls
	 */
	@Override
	public void setClassPk(long classPk) {
		model.setClassPk(classPk);
	}

	/**
	 * Sets the district of this dgf users addr dtls.
	 *
	 * @param district the district of this dgf users addr dtls
	 */
	@Override
	public void setDistrict(long district) {
		model.setDistrict(district);
	}

	/**
	 * Sets the division of this dgf users addr dtls.
	 *
	 * @param division the division of this dgf users addr dtls
	 */
	@Override
	public void setDivision(long division) {
		model.setDivision(division);
	}

	/**
	 * Sets the house address of this dgf users addr dtls.
	 *
	 * @param houseAddress the house address of this dgf users addr dtls
	 */
	@Override
	public void setHouseAddress(String houseAddress) {
		model.setHouseAddress(houseAddress);
	}

	/**
	 * Sets the last updated by of this dgf users addr dtls.
	 *
	 * @param lastUpdatedBy the last updated by of this dgf users addr dtls
	 */
	@Override
	public void setLastUpdatedBy(Date lastUpdatedBy) {
		model.setLastUpdatedBy(lastUpdatedBy);
	}

	/**
	 * Sets the last updated date of this dgf users addr dtls.
	 *
	 * @param lastUpdatedDate the last updated date of this dgf users addr dtls
	 */
	@Override
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		model.setLastUpdatedDate(lastUpdatedDate);
	}

	/**
	 * Sets the national ID of this dgf users addr dtls.
	 *
	 * @param nationalId the national ID of this dgf users addr dtls
	 */
	@Override
	public void setNationalId(long nationalId) {
		model.setNationalId(nationalId);
	}

	/**
	 * Sets the post office of this dgf users addr dtls.
	 *
	 * @param postOffice the post office of this dgf users addr dtls
	 */
	@Override
	public void setPostOffice(String postOffice) {
		model.setPostOffice(postOffice);
	}

	/**
	 * Sets the primary key of this dgf users addr dtls.
	 *
	 * @param primaryKey the primary key of this dgf users addr dtls
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the union name of this dgf users addr dtls.
	 *
	 * @param unionName the union name of this dgf users addr dtls
	 */
	@Override
	public void setUnionName(long unionName) {
		model.setUnionName(unionName);
	}

	/**
	 * Sets the upzilla of this dgf users addr dtls.
	 *
	 * @param upzilla the upzilla of this dgf users addr dtls
	 */
	@Override
	public void setUpzilla(long upzilla) {
		model.setUpzilla(upzilla);
	}

	/**
	 * Sets the village of this dgf users addr dtls.
	 *
	 * @param village the village of this dgf users addr dtls
	 */
	@Override
	public void setVillage(String village) {
		model.setVillage(village);
	}

	/**
	 * Sets the ward of this dgf users addr dtls.
	 *
	 * @param ward the ward of this dgf users addr dtls
	 */
	@Override
	public void setWard(String ward) {
		model.setWard(ward);
	}

	/**
	 * Sets the zip code of this dgf users addr dtls.
	 *
	 * @param zipCode the zip code of this dgf users addr dtls
	 */
	@Override
	public void setZipCode(String zipCode) {
		model.setZipCode(zipCode);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DgfUsersAddrDtlsWrapper wrap(DgfUsersAddrDtls dgfUsersAddrDtls) {
		return new DgfUsersAddrDtlsWrapper(dgfUsersAddrDtls);
	}

}