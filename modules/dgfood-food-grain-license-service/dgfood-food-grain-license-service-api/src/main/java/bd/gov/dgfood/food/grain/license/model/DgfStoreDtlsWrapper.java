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
 * This class is a wrapper for {@link DgfStoreDtls}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfStoreDtls
 * @generated
 */
public class DgfStoreDtlsWrapper
	extends BaseModelWrapper<DgfStoreDtls>
	implements DgfStoreDtls, ModelWrapper<DgfStoreDtls> {

	public DgfStoreDtlsWrapper(DgfStoreDtls dgfStoreDtls) {
		super(dgfStoreDtls);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("nationalId", getNationalId());
		attributes.put("type", getType());
		attributes.put("mouza", getMouza());
		attributes.put("khatiyn", getKhatiyn());
		attributes.put("DagNo", getDagNo());
		attributes.put("division", getDivision());
		attributes.put("district", getDistrict());
		attributes.put("upzilla", getUpzilla());
		attributes.put("unionName", getUnionName());
		attributes.put("cityCrprtn", getCityCrprtn());
		attributes.put("dicsHight", getDicsHight());
		attributes.put("dicsWidth", getDicsWidth());
		attributes.put("dicsLngth", getDicsLngth());
		attributes.put("dicsCpacty", getDicsCpacty());
		attributes.put("totalCpacty", getTotalCpacty());
		attributes.put("createdAt", getCreatedAt());
		attributes.put("updatedAt", getUpdatedAt());
		attributes.put("flag", getFlag());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String nationalId = (String)attributes.get("nationalId");

		if (nationalId != null) {
			setNationalId(nationalId);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String mouza = (String)attributes.get("mouza");

		if (mouza != null) {
			setMouza(mouza);
		}

		String khatiyn = (String)attributes.get("khatiyn");

		if (khatiyn != null) {
			setKhatiyn(khatiyn);
		}

		String DagNo = (String)attributes.get("DagNo");

		if (DagNo != null) {
			setDagNo(DagNo);
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

		Long cityCrprtn = (Long)attributes.get("cityCrprtn");

		if (cityCrprtn != null) {
			setCityCrprtn(cityCrprtn);
		}

		String dicsHight = (String)attributes.get("dicsHight");

		if (dicsHight != null) {
			setDicsHight(dicsHight);
		}

		String dicsWidth = (String)attributes.get("dicsWidth");

		if (dicsWidth != null) {
			setDicsWidth(dicsWidth);
		}

		String dicsLngth = (String)attributes.get("dicsLngth");

		if (dicsLngth != null) {
			setDicsLngth(dicsLngth);
		}

		Long dicsCpacty = (Long)attributes.get("dicsCpacty");

		if (dicsCpacty != null) {
			setDicsCpacty(dicsCpacty);
		}

		Long totalCpacty = (Long)attributes.get("totalCpacty");

		if (totalCpacty != null) {
			setTotalCpacty(totalCpacty);
		}

		Date createdAt = (Date)attributes.get("createdAt");

		if (createdAt != null) {
			setCreatedAt(createdAt);
		}

		Date updatedAt = (Date)attributes.get("updatedAt");

		if (updatedAt != null) {
			setUpdatedAt(updatedAt);
		}

		Integer flag = (Integer)attributes.get("flag");

		if (flag != null) {
			setFlag(flag);
		}
	}

	@Override
	public DgfStoreDtls cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the city crprtn of this dgf store dtls.
	 *
	 * @return the city crprtn of this dgf store dtls
	 */
	@Override
	public long getCityCrprtn() {
		return model.getCityCrprtn();
	}

	/**
	 * Returns the created at of this dgf store dtls.
	 *
	 * @return the created at of this dgf store dtls
	 */
	@Override
	public Date getCreatedAt() {
		return model.getCreatedAt();
	}

	/**
	 * Returns the dag no of this dgf store dtls.
	 *
	 * @return the dag no of this dgf store dtls
	 */
	@Override
	public String getDagNo() {
		return model.getDagNo();
	}

	/**
	 * Returns the dics cpacty of this dgf store dtls.
	 *
	 * @return the dics cpacty of this dgf store dtls
	 */
	@Override
	public long getDicsCpacty() {
		return model.getDicsCpacty();
	}

	/**
	 * Returns the dics hight of this dgf store dtls.
	 *
	 * @return the dics hight of this dgf store dtls
	 */
	@Override
	public String getDicsHight() {
		return model.getDicsHight();
	}

	/**
	 * Returns the dics lngth of this dgf store dtls.
	 *
	 * @return the dics lngth of this dgf store dtls
	 */
	@Override
	public String getDicsLngth() {
		return model.getDicsLngth();
	}

	/**
	 * Returns the dics width of this dgf store dtls.
	 *
	 * @return the dics width of this dgf store dtls
	 */
	@Override
	public String getDicsWidth() {
		return model.getDicsWidth();
	}

	/**
	 * Returns the district of this dgf store dtls.
	 *
	 * @return the district of this dgf store dtls
	 */
	@Override
	public long getDistrict() {
		return model.getDistrict();
	}

	/**
	 * Returns the division of this dgf store dtls.
	 *
	 * @return the division of this dgf store dtls
	 */
	@Override
	public long getDivision() {
		return model.getDivision();
	}

	/**
	 * Returns the flag of this dgf store dtls.
	 *
	 * @return the flag of this dgf store dtls
	 */
	@Override
	public int getFlag() {
		return model.getFlag();
	}

	/**
	 * Returns the ID of this dgf store dtls.
	 *
	 * @return the ID of this dgf store dtls
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the khatiyn of this dgf store dtls.
	 *
	 * @return the khatiyn of this dgf store dtls
	 */
	@Override
	public String getKhatiyn() {
		return model.getKhatiyn();
	}

	/**
	 * Returns the mouza of this dgf store dtls.
	 *
	 * @return the mouza of this dgf store dtls
	 */
	@Override
	public String getMouza() {
		return model.getMouza();
	}

	/**
	 * Returns the national ID of this dgf store dtls.
	 *
	 * @return the national ID of this dgf store dtls
	 */
	@Override
	public String getNationalId() {
		return model.getNationalId();
	}

	/**
	 * Returns the primary key of this dgf store dtls.
	 *
	 * @return the primary key of this dgf store dtls
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the total cpacty of this dgf store dtls.
	 *
	 * @return the total cpacty of this dgf store dtls
	 */
	@Override
	public long getTotalCpacty() {
		return model.getTotalCpacty();
	}

	/**
	 * Returns the type of this dgf store dtls.
	 *
	 * @return the type of this dgf store dtls
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the union name of this dgf store dtls.
	 *
	 * @return the union name of this dgf store dtls
	 */
	@Override
	public long getUnionName() {
		return model.getUnionName();
	}

	/**
	 * Returns the updated at of this dgf store dtls.
	 *
	 * @return the updated at of this dgf store dtls
	 */
	@Override
	public Date getUpdatedAt() {
		return model.getUpdatedAt();
	}

	/**
	 * Returns the upzilla of this dgf store dtls.
	 *
	 * @return the upzilla of this dgf store dtls
	 */
	@Override
	public long getUpzilla() {
		return model.getUpzilla();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the city crprtn of this dgf store dtls.
	 *
	 * @param cityCrprtn the city crprtn of this dgf store dtls
	 */
	@Override
	public void setCityCrprtn(long cityCrprtn) {
		model.setCityCrprtn(cityCrprtn);
	}

	/**
	 * Sets the created at of this dgf store dtls.
	 *
	 * @param createdAt the created at of this dgf store dtls
	 */
	@Override
	public void setCreatedAt(Date createdAt) {
		model.setCreatedAt(createdAt);
	}

	/**
	 * Sets the dag no of this dgf store dtls.
	 *
	 * @param DagNo the dag no of this dgf store dtls
	 */
	@Override
	public void setDagNo(String DagNo) {
		model.setDagNo(DagNo);
	}

	/**
	 * Sets the dics cpacty of this dgf store dtls.
	 *
	 * @param dicsCpacty the dics cpacty of this dgf store dtls
	 */
	@Override
	public void setDicsCpacty(long dicsCpacty) {
		model.setDicsCpacty(dicsCpacty);
	}

	/**
	 * Sets the dics hight of this dgf store dtls.
	 *
	 * @param dicsHight the dics hight of this dgf store dtls
	 */
	@Override
	public void setDicsHight(String dicsHight) {
		model.setDicsHight(dicsHight);
	}

	/**
	 * Sets the dics lngth of this dgf store dtls.
	 *
	 * @param dicsLngth the dics lngth of this dgf store dtls
	 */
	@Override
	public void setDicsLngth(String dicsLngth) {
		model.setDicsLngth(dicsLngth);
	}

	/**
	 * Sets the dics width of this dgf store dtls.
	 *
	 * @param dicsWidth the dics width of this dgf store dtls
	 */
	@Override
	public void setDicsWidth(String dicsWidth) {
		model.setDicsWidth(dicsWidth);
	}

	/**
	 * Sets the district of this dgf store dtls.
	 *
	 * @param district the district of this dgf store dtls
	 */
	@Override
	public void setDistrict(long district) {
		model.setDistrict(district);
	}

	/**
	 * Sets the division of this dgf store dtls.
	 *
	 * @param division the division of this dgf store dtls
	 */
	@Override
	public void setDivision(long division) {
		model.setDivision(division);
	}

	/**
	 * Sets the flag of this dgf store dtls.
	 *
	 * @param flag the flag of this dgf store dtls
	 */
	@Override
	public void setFlag(int flag) {
		model.setFlag(flag);
	}

	/**
	 * Sets the ID of this dgf store dtls.
	 *
	 * @param id the ID of this dgf store dtls
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the khatiyn of this dgf store dtls.
	 *
	 * @param khatiyn the khatiyn of this dgf store dtls
	 */
	@Override
	public void setKhatiyn(String khatiyn) {
		model.setKhatiyn(khatiyn);
	}

	/**
	 * Sets the mouza of this dgf store dtls.
	 *
	 * @param mouza the mouza of this dgf store dtls
	 */
	@Override
	public void setMouza(String mouza) {
		model.setMouza(mouza);
	}

	/**
	 * Sets the national ID of this dgf store dtls.
	 *
	 * @param nationalId the national ID of this dgf store dtls
	 */
	@Override
	public void setNationalId(String nationalId) {
		model.setNationalId(nationalId);
	}

	/**
	 * Sets the primary key of this dgf store dtls.
	 *
	 * @param primaryKey the primary key of this dgf store dtls
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the total cpacty of this dgf store dtls.
	 *
	 * @param totalCpacty the total cpacty of this dgf store dtls
	 */
	@Override
	public void setTotalCpacty(long totalCpacty) {
		model.setTotalCpacty(totalCpacty);
	}

	/**
	 * Sets the type of this dgf store dtls.
	 *
	 * @param type the type of this dgf store dtls
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets the union name of this dgf store dtls.
	 *
	 * @param unionName the union name of this dgf store dtls
	 */
	@Override
	public void setUnionName(long unionName) {
		model.setUnionName(unionName);
	}

	/**
	 * Sets the updated at of this dgf store dtls.
	 *
	 * @param updatedAt the updated at of this dgf store dtls
	 */
	@Override
	public void setUpdatedAt(Date updatedAt) {
		model.setUpdatedAt(updatedAt);
	}

	/**
	 * Sets the upzilla of this dgf store dtls.
	 *
	 * @param upzilla the upzilla of this dgf store dtls
	 */
	@Override
	public void setUpzilla(long upzilla) {
		model.setUpzilla(upzilla);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DgfStoreDtlsWrapper wrap(DgfStoreDtls dgfStoreDtls) {
		return new DgfStoreDtlsWrapper(dgfStoreDtls);
	}

}