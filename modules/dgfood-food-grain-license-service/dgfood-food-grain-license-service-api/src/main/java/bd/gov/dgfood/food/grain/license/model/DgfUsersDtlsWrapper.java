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
 * This class is a wrapper for {@link DgfUsersDtls}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersDtls
 * @generated
 */
public class DgfUsersDtlsWrapper
	extends BaseModelWrapper<DgfUsersDtls>
	implements DgfUsersDtls, ModelWrapper<DgfUsersDtls> {

	public DgfUsersDtlsWrapper(DgfUsersDtls dgfUsersDtls) {
		super(dgfUsersDtls);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userDetailsId", getUserDetailsId());
		attributes.put("nationalId", getNationalId());
		attributes.put("email", getEmail());
		attributes.put("nidPhotoAttchId", getNidPhotoAttchId());
		attributes.put("nidDivision", getNidDivision());
		attributes.put("nidDistrict", getNidDistrict());
		attributes.put("nidUpzilla", getNidUpzilla());
		attributes.put("nidUnion", getNidUnion());
		attributes.put("nidVillage", getNidVillage());
		attributes.put("nidWard", getNidWard());
		attributes.put("nidZipCode", getNidZipCode());
		attributes.put("nidHouseAddress", getNidHouseAddress());
		attributes.put("lastUpdatedDate", getLastUpdatedDate());
		attributes.put("nidPostOffice", getNidPostOffice());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userDetailsId = (Long)attributes.get("userDetailsId");

		if (userDetailsId != null) {
			setUserDetailsId(userDetailsId);
		}

		Long nationalId = (Long)attributes.get("nationalId");

		if (nationalId != null) {
			setNationalId(nationalId);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Long nidPhotoAttchId = (Long)attributes.get("nidPhotoAttchId");

		if (nidPhotoAttchId != null) {
			setNidPhotoAttchId(nidPhotoAttchId);
		}

		String nidDivision = (String)attributes.get("nidDivision");

		if (nidDivision != null) {
			setNidDivision(nidDivision);
		}

		String nidDistrict = (String)attributes.get("nidDistrict");

		if (nidDistrict != null) {
			setNidDistrict(nidDistrict);
		}

		String nidUpzilla = (String)attributes.get("nidUpzilla");

		if (nidUpzilla != null) {
			setNidUpzilla(nidUpzilla);
		}

		String nidUnion = (String)attributes.get("nidUnion");

		if (nidUnion != null) {
			setNidUnion(nidUnion);
		}

		String nidVillage = (String)attributes.get("nidVillage");

		if (nidVillage != null) {
			setNidVillage(nidVillage);
		}

		String nidWard = (String)attributes.get("nidWard");

		if (nidWard != null) {
			setNidWard(nidWard);
		}

		String nidZipCode = (String)attributes.get("nidZipCode");

		if (nidZipCode != null) {
			setNidZipCode(nidZipCode);
		}

		String nidHouseAddress = (String)attributes.get("nidHouseAddress");

		if (nidHouseAddress != null) {
			setNidHouseAddress(nidHouseAddress);
		}

		Date lastUpdatedDate = (Date)attributes.get("lastUpdatedDate");

		if (lastUpdatedDate != null) {
			setLastUpdatedDate(lastUpdatedDate);
		}

		String nidPostOffice = (String)attributes.get("nidPostOffice");

		if (nidPostOffice != null) {
			setNidPostOffice(nidPostOffice);
		}
	}

	@Override
	public DgfUsersDtls cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the email of this dgf users dtls.
	 *
	 * @return the email of this dgf users dtls
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the last updated date of this dgf users dtls.
	 *
	 * @return the last updated date of this dgf users dtls
	 */
	@Override
	public Date getLastUpdatedDate() {
		return model.getLastUpdatedDate();
	}

	/**
	 * Returns the national ID of this dgf users dtls.
	 *
	 * @return the national ID of this dgf users dtls
	 */
	@Override
	public long getNationalId() {
		return model.getNationalId();
	}

	/**
	 * Returns the nid district of this dgf users dtls.
	 *
	 * @return the nid district of this dgf users dtls
	 */
	@Override
	public String getNidDistrict() {
		return model.getNidDistrict();
	}

	/**
	 * Returns the nid division of this dgf users dtls.
	 *
	 * @return the nid division of this dgf users dtls
	 */
	@Override
	public String getNidDivision() {
		return model.getNidDivision();
	}

	/**
	 * Returns the nid house address of this dgf users dtls.
	 *
	 * @return the nid house address of this dgf users dtls
	 */
	@Override
	public String getNidHouseAddress() {
		return model.getNidHouseAddress();
	}

	/**
	 * Returns the nid photo attch ID of this dgf users dtls.
	 *
	 * @return the nid photo attch ID of this dgf users dtls
	 */
	@Override
	public long getNidPhotoAttchId() {
		return model.getNidPhotoAttchId();
	}

	/**
	 * Returns the nid post office of this dgf users dtls.
	 *
	 * @return the nid post office of this dgf users dtls
	 */
	@Override
	public String getNidPostOffice() {
		return model.getNidPostOffice();
	}

	/**
	 * Returns the nid union of this dgf users dtls.
	 *
	 * @return the nid union of this dgf users dtls
	 */
	@Override
	public String getNidUnion() {
		return model.getNidUnion();
	}

	/**
	 * Returns the nid upzilla of this dgf users dtls.
	 *
	 * @return the nid upzilla of this dgf users dtls
	 */
	@Override
	public String getNidUpzilla() {
		return model.getNidUpzilla();
	}

	/**
	 * Returns the nid village of this dgf users dtls.
	 *
	 * @return the nid village of this dgf users dtls
	 */
	@Override
	public String getNidVillage() {
		return model.getNidVillage();
	}

	/**
	 * Returns the nid ward of this dgf users dtls.
	 *
	 * @return the nid ward of this dgf users dtls
	 */
	@Override
	public String getNidWard() {
		return model.getNidWard();
	}

	/**
	 * Returns the nid zip code of this dgf users dtls.
	 *
	 * @return the nid zip code of this dgf users dtls
	 */
	@Override
	public String getNidZipCode() {
		return model.getNidZipCode();
	}

	/**
	 * Returns the primary key of this dgf users dtls.
	 *
	 * @return the primary key of this dgf users dtls
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user details ID of this dgf users dtls.
	 *
	 * @return the user details ID of this dgf users dtls
	 */
	@Override
	public long getUserDetailsId() {
		return model.getUserDetailsId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the email of this dgf users dtls.
	 *
	 * @param email the email of this dgf users dtls
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the last updated date of this dgf users dtls.
	 *
	 * @param lastUpdatedDate the last updated date of this dgf users dtls
	 */
	@Override
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		model.setLastUpdatedDate(lastUpdatedDate);
	}

	/**
	 * Sets the national ID of this dgf users dtls.
	 *
	 * @param nationalId the national ID of this dgf users dtls
	 */
	@Override
	public void setNationalId(long nationalId) {
		model.setNationalId(nationalId);
	}

	/**
	 * Sets the nid district of this dgf users dtls.
	 *
	 * @param nidDistrict the nid district of this dgf users dtls
	 */
	@Override
	public void setNidDistrict(String nidDistrict) {
		model.setNidDistrict(nidDistrict);
	}

	/**
	 * Sets the nid division of this dgf users dtls.
	 *
	 * @param nidDivision the nid division of this dgf users dtls
	 */
	@Override
	public void setNidDivision(String nidDivision) {
		model.setNidDivision(nidDivision);
	}

	/**
	 * Sets the nid house address of this dgf users dtls.
	 *
	 * @param nidHouseAddress the nid house address of this dgf users dtls
	 */
	@Override
	public void setNidHouseAddress(String nidHouseAddress) {
		model.setNidHouseAddress(nidHouseAddress);
	}

	/**
	 * Sets the nid photo attch ID of this dgf users dtls.
	 *
	 * @param nidPhotoAttchId the nid photo attch ID of this dgf users dtls
	 */
	@Override
	public void setNidPhotoAttchId(long nidPhotoAttchId) {
		model.setNidPhotoAttchId(nidPhotoAttchId);
	}

	/**
	 * Sets the nid post office of this dgf users dtls.
	 *
	 * @param nidPostOffice the nid post office of this dgf users dtls
	 */
	@Override
	public void setNidPostOffice(String nidPostOffice) {
		model.setNidPostOffice(nidPostOffice);
	}

	/**
	 * Sets the nid union of this dgf users dtls.
	 *
	 * @param nidUnion the nid union of this dgf users dtls
	 */
	@Override
	public void setNidUnion(String nidUnion) {
		model.setNidUnion(nidUnion);
	}

	/**
	 * Sets the nid upzilla of this dgf users dtls.
	 *
	 * @param nidUpzilla the nid upzilla of this dgf users dtls
	 */
	@Override
	public void setNidUpzilla(String nidUpzilla) {
		model.setNidUpzilla(nidUpzilla);
	}

	/**
	 * Sets the nid village of this dgf users dtls.
	 *
	 * @param nidVillage the nid village of this dgf users dtls
	 */
	@Override
	public void setNidVillage(String nidVillage) {
		model.setNidVillage(nidVillage);
	}

	/**
	 * Sets the nid ward of this dgf users dtls.
	 *
	 * @param nidWard the nid ward of this dgf users dtls
	 */
	@Override
	public void setNidWard(String nidWard) {
		model.setNidWard(nidWard);
	}

	/**
	 * Sets the nid zip code of this dgf users dtls.
	 *
	 * @param nidZipCode the nid zip code of this dgf users dtls
	 */
	@Override
	public void setNidZipCode(String nidZipCode) {
		model.setNidZipCode(nidZipCode);
	}

	/**
	 * Sets the primary key of this dgf users dtls.
	 *
	 * @param primaryKey the primary key of this dgf users dtls
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user details ID of this dgf users dtls.
	 *
	 * @param userDetailsId the user details ID of this dgf users dtls
	 */
	@Override
	public void setUserDetailsId(long userDetailsId) {
		model.setUserDetailsId(userDetailsId);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DgfUsersDtlsWrapper wrap(DgfUsersDtls dgfUsersDtls) {
		return new DgfUsersDtlsWrapper(dgfUsersDtls);
	}

}