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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DgfBussAddrDtls}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfBussAddrDtls
 * @generated
 */
public class DgfBussAddrDtlsWrapper
	extends BaseModelWrapper<DgfBussAddrDtls>
	implements DgfBussAddrDtls, ModelWrapper<DgfBussAddrDtls> {

	public DgfBussAddrDtlsWrapper(DgfBussAddrDtls dgfBussAddrDtls) {
		super(dgfBussAddrDtls);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("businessAddressId", getBusinessAddressId());
		attributes.put("nationalId", getNationalId());
		attributes.put("businessDivision", getBusinessDivision());
		attributes.put("businessDistrict", getBusinessDistrict());
		attributes.put("businessUpzilla", getBusinessUpzilla());
		attributes.put("businessUnionName", getBusinessUnionName());
		attributes.put("businessVillage", getBusinessVillage());
		attributes.put("businessWard", getBusinessWard());
		attributes.put("businessZipCode", getBusinessZipCode());
		attributes.put("businessPostOffice", getBusinessPostOffice());
		attributes.put("businessHouseAddress", getBusinessHouseAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long businessAddressId = (Long)attributes.get("businessAddressId");

		if (businessAddressId != null) {
			setBusinessAddressId(businessAddressId);
		}

		Long nationalId = (Long)attributes.get("nationalId");

		if (nationalId != null) {
			setNationalId(nationalId);
		}

		Long businessDivision = (Long)attributes.get("businessDivision");

		if (businessDivision != null) {
			setBusinessDivision(businessDivision);
		}

		Long businessDistrict = (Long)attributes.get("businessDistrict");

		if (businessDistrict != null) {
			setBusinessDistrict(businessDistrict);
		}

		Long businessUpzilla = (Long)attributes.get("businessUpzilla");

		if (businessUpzilla != null) {
			setBusinessUpzilla(businessUpzilla);
		}

		Long businessUnionName = (Long)attributes.get("businessUnionName");

		if (businessUnionName != null) {
			setBusinessUnionName(businessUnionName);
		}

		String businessVillage = (String)attributes.get("businessVillage");

		if (businessVillage != null) {
			setBusinessVillage(businessVillage);
		}

		String businessWard = (String)attributes.get("businessWard");

		if (businessWard != null) {
			setBusinessWard(businessWard);
		}

		String businessZipCode = (String)attributes.get("businessZipCode");

		if (businessZipCode != null) {
			setBusinessZipCode(businessZipCode);
		}

		String businessPostOffice = (String)attributes.get(
			"businessPostOffice");

		if (businessPostOffice != null) {
			setBusinessPostOffice(businessPostOffice);
		}

		String businessHouseAddress = (String)attributes.get(
			"businessHouseAddress");

		if (businessHouseAddress != null) {
			setBusinessHouseAddress(businessHouseAddress);
		}
	}

	@Override
	public DgfBussAddrDtls cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the business address ID of this dgf buss addr dtls.
	 *
	 * @return the business address ID of this dgf buss addr dtls
	 */
	@Override
	public long getBusinessAddressId() {
		return model.getBusinessAddressId();
	}

	/**
	 * Returns the business district of this dgf buss addr dtls.
	 *
	 * @return the business district of this dgf buss addr dtls
	 */
	@Override
	public long getBusinessDistrict() {
		return model.getBusinessDistrict();
	}

	/**
	 * Returns the business division of this dgf buss addr dtls.
	 *
	 * @return the business division of this dgf buss addr dtls
	 */
	@Override
	public long getBusinessDivision() {
		return model.getBusinessDivision();
	}

	/**
	 * Returns the business house address of this dgf buss addr dtls.
	 *
	 * @return the business house address of this dgf buss addr dtls
	 */
	@Override
	public String getBusinessHouseAddress() {
		return model.getBusinessHouseAddress();
	}

	/**
	 * Returns the business post office of this dgf buss addr dtls.
	 *
	 * @return the business post office of this dgf buss addr dtls
	 */
	@Override
	public String getBusinessPostOffice() {
		return model.getBusinessPostOffice();
	}

	/**
	 * Returns the business union name of this dgf buss addr dtls.
	 *
	 * @return the business union name of this dgf buss addr dtls
	 */
	@Override
	public long getBusinessUnionName() {
		return model.getBusinessUnionName();
	}

	/**
	 * Returns the business upzilla of this dgf buss addr dtls.
	 *
	 * @return the business upzilla of this dgf buss addr dtls
	 */
	@Override
	public long getBusinessUpzilla() {
		return model.getBusinessUpzilla();
	}

	/**
	 * Returns the business village of this dgf buss addr dtls.
	 *
	 * @return the business village of this dgf buss addr dtls
	 */
	@Override
	public String getBusinessVillage() {
		return model.getBusinessVillage();
	}

	/**
	 * Returns the business ward of this dgf buss addr dtls.
	 *
	 * @return the business ward of this dgf buss addr dtls
	 */
	@Override
	public String getBusinessWard() {
		return model.getBusinessWard();
	}

	/**
	 * Returns the business zip code of this dgf buss addr dtls.
	 *
	 * @return the business zip code of this dgf buss addr dtls
	 */
	@Override
	public String getBusinessZipCode() {
		return model.getBusinessZipCode();
	}

	/**
	 * Returns the national ID of this dgf buss addr dtls.
	 *
	 * @return the national ID of this dgf buss addr dtls
	 */
	@Override
	public long getNationalId() {
		return model.getNationalId();
	}

	/**
	 * Returns the primary key of this dgf buss addr dtls.
	 *
	 * @return the primary key of this dgf buss addr dtls
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the business address ID of this dgf buss addr dtls.
	 *
	 * @param businessAddressId the business address ID of this dgf buss addr dtls
	 */
	@Override
	public void setBusinessAddressId(long businessAddressId) {
		model.setBusinessAddressId(businessAddressId);
	}

	/**
	 * Sets the business district of this dgf buss addr dtls.
	 *
	 * @param businessDistrict the business district of this dgf buss addr dtls
	 */
	@Override
	public void setBusinessDistrict(long businessDistrict) {
		model.setBusinessDistrict(businessDistrict);
	}

	/**
	 * Sets the business division of this dgf buss addr dtls.
	 *
	 * @param businessDivision the business division of this dgf buss addr dtls
	 */
	@Override
	public void setBusinessDivision(long businessDivision) {
		model.setBusinessDivision(businessDivision);
	}

	/**
	 * Sets the business house address of this dgf buss addr dtls.
	 *
	 * @param businessHouseAddress the business house address of this dgf buss addr dtls
	 */
	@Override
	public void setBusinessHouseAddress(String businessHouseAddress) {
		model.setBusinessHouseAddress(businessHouseAddress);
	}

	/**
	 * Sets the business post office of this dgf buss addr dtls.
	 *
	 * @param businessPostOffice the business post office of this dgf buss addr dtls
	 */
	@Override
	public void setBusinessPostOffice(String businessPostOffice) {
		model.setBusinessPostOffice(businessPostOffice);
	}

	/**
	 * Sets the business union name of this dgf buss addr dtls.
	 *
	 * @param businessUnionName the business union name of this dgf buss addr dtls
	 */
	@Override
	public void setBusinessUnionName(long businessUnionName) {
		model.setBusinessUnionName(businessUnionName);
	}

	/**
	 * Sets the business upzilla of this dgf buss addr dtls.
	 *
	 * @param businessUpzilla the business upzilla of this dgf buss addr dtls
	 */
	@Override
	public void setBusinessUpzilla(long businessUpzilla) {
		model.setBusinessUpzilla(businessUpzilla);
	}

	/**
	 * Sets the business village of this dgf buss addr dtls.
	 *
	 * @param businessVillage the business village of this dgf buss addr dtls
	 */
	@Override
	public void setBusinessVillage(String businessVillage) {
		model.setBusinessVillage(businessVillage);
	}

	/**
	 * Sets the business ward of this dgf buss addr dtls.
	 *
	 * @param businessWard the business ward of this dgf buss addr dtls
	 */
	@Override
	public void setBusinessWard(String businessWard) {
		model.setBusinessWard(businessWard);
	}

	/**
	 * Sets the business zip code of this dgf buss addr dtls.
	 *
	 * @param businessZipCode the business zip code of this dgf buss addr dtls
	 */
	@Override
	public void setBusinessZipCode(String businessZipCode) {
		model.setBusinessZipCode(businessZipCode);
	}

	/**
	 * Sets the national ID of this dgf buss addr dtls.
	 *
	 * @param nationalId the national ID of this dgf buss addr dtls
	 */
	@Override
	public void setNationalId(long nationalId) {
		model.setNationalId(nationalId);
	}

	/**
	 * Sets the primary key of this dgf buss addr dtls.
	 *
	 * @param primaryKey the primary key of this dgf buss addr dtls
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DgfBussAddrDtlsWrapper wrap(DgfBussAddrDtls dgfBussAddrDtls) {
		return new DgfBussAddrDtlsWrapper(dgfBussAddrDtls);
	}

}