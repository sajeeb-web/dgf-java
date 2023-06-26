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
 * The base model interface for the DgfDlrDistributionDtls service. Represents a row in the &quot;dgf_dlr_distribution_dtls&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>bd.gov.dgfood.food.grain.license.model.impl.DgfDlrDistributionDtlsModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>bd.gov.dgfood.food.grain.license.model.impl.DgfDlrDistributionDtlsImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrDistributionDtls
 * @generated
 */
@ProviderType
public interface DgfDlrDistributionDtlsModel
	extends BaseModel<DgfDlrDistributionDtls> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a dgf dlr distribution dtls model instance should use the {@link DgfDlrDistributionDtls} interface instead.
	 */

	/**
	 * Returns the primary key of this dgf dlr distribution dtls.
	 *
	 * @return the primary key of this dgf dlr distribution dtls
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this dgf dlr distribution dtls.
	 *
	 * @param primaryKey the primary key of this dgf dlr distribution dtls
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this dgf dlr distribution dtls.
	 *
	 * @return the ID of this dgf dlr distribution dtls
	 */
	public long getId();

	/**
	 * Sets the ID of this dgf dlr distribution dtls.
	 *
	 * @param id the ID of this dgf dlr distribution dtls
	 */
	public void setId(long id);

	/**
	 * Returns the dealer ID of this dgf dlr distribution dtls.
	 *
	 * @return the dealer ID of this dgf dlr distribution dtls
	 */
	public long getDealerId();

	/**
	 * Sets the dealer ID of this dgf dlr distribution dtls.
	 *
	 * @param dealerId the dealer ID of this dgf dlr distribution dtls
	 */
	public void setDealerId(long dealerId);

	/**
	 * Returns the beneficiaries ID of this dgf dlr distribution dtls.
	 *
	 * @return the beneficiaries ID of this dgf dlr distribution dtls
	 */
	public long getBeneficiariesId();

	/**
	 * Sets the beneficiaries ID of this dgf dlr distribution dtls.
	 *
	 * @param beneficiariesId the beneficiaries ID of this dgf dlr distribution dtls
	 */
	public void setBeneficiariesId(long beneficiariesId);

	/**
	 * Returns the beneficiaries mobile no of this dgf dlr distribution dtls.
	 *
	 * @return the beneficiaries mobile no of this dgf dlr distribution dtls
	 */
	@AutoEscape
	public String getBeneficiariesMobileNo();

	/**
	 * Sets the beneficiaries mobile no of this dgf dlr distribution dtls.
	 *
	 * @param beneficiariesMobileNo the beneficiaries mobile no of this dgf dlr distribution dtls
	 */
	public void setBeneficiariesMobileNo(String beneficiariesMobileNo);

	/**
	 * Returns the card no of this dgf dlr distribution dtls.
	 *
	 * @return the card no of this dgf dlr distribution dtls
	 */
	public long getCardNo();

	/**
	 * Sets the card no of this dgf dlr distribution dtls.
	 *
	 * @param cardNo the card no of this dgf dlr distribution dtls
	 */
	public void setCardNo(long cardNo);

	/**
	 * Returns the union ID of this dgf dlr distribution dtls.
	 *
	 * @return the union ID of this dgf dlr distribution dtls
	 */
	public long getUnionId();

	/**
	 * Sets the union ID of this dgf dlr distribution dtls.
	 *
	 * @param unionId the union ID of this dgf dlr distribution dtls
	 */
	public void setUnionId(long unionId);

	/**
	 * Returns the distribution date of this dgf dlr distribution dtls.
	 *
	 * @return the distribution date of this dgf dlr distribution dtls
	 */
	public Date getDistributionDate();

	/**
	 * Sets the distribution date of this dgf dlr distribution dtls.
	 *
	 * @param distributionDate the distribution date of this dgf dlr distribution dtls
	 */
	public void setDistributionDate(Date distributionDate);

	/**
	 * Returns the distribution qty of this dgf dlr distribution dtls.
	 *
	 * @return the distribution qty of this dgf dlr distribution dtls
	 */
	public long getDistributionQty();

	/**
	 * Sets the distribution qty of this dgf dlr distribution dtls.
	 *
	 * @param distributionQty the distribution qty of this dgf dlr distribution dtls
	 */
	public void setDistributionQty(long distributionQty);

	/**
	 * Returns the status of this dgf dlr distribution dtls.
	 *
	 * @return the status of this dgf dlr distribution dtls
	 */
	public int getStatus();

	/**
	 * Sets the status of this dgf dlr distribution dtls.
	 *
	 * @param status the status of this dgf dlr distribution dtls
	 */
	public void setStatus(int status);

	/**
	 * Returns the created at of this dgf dlr distribution dtls.
	 *
	 * @return the created at of this dgf dlr distribution dtls
	 */
	public Date getCreatedAt();

	/**
	 * Sets the created at of this dgf dlr distribution dtls.
	 *
	 * @param createdAt the created at of this dgf dlr distribution dtls
	 */
	public void setCreatedAt(Date createdAt);

	/**
	 * Returns the updated at of this dgf dlr distribution dtls.
	 *
	 * @return the updated at of this dgf dlr distribution dtls
	 */
	public Date getUpdatedAt();

	/**
	 * Sets the updated at of this dgf dlr distribution dtls.
	 *
	 * @param updatedAt the updated at of this dgf dlr distribution dtls
	 */
	public void setUpdatedAt(Date updatedAt);

	/**
	 * Returns the month of this dgf dlr distribution dtls.
	 *
	 * @return the month of this dgf dlr distribution dtls
	 */
	public int getMonth();

	/**
	 * Sets the month of this dgf dlr distribution dtls.
	 *
	 * @param month the month of this dgf dlr distribution dtls
	 */
	public void setMonth(int month);

	/**
	 * Returns the year of this dgf dlr distribution dtls.
	 *
	 * @return the year of this dgf dlr distribution dtls
	 */
	public int getYear();

	/**
	 * Sets the year of this dgf dlr distribution dtls.
	 *
	 * @param year the year of this dgf dlr distribution dtls
	 */
	public void setYear(int year);

	@Override
	public DgfDlrDistributionDtls cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}