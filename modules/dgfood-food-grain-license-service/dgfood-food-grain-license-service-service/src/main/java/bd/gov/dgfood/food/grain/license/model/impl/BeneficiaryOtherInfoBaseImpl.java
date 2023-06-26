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

package bd.gov.dgfood.food.grain.license.model.impl;

import bd.gov.dgfood.food.grain.license.model.BeneficiaryOtherInfo;
import bd.gov.dgfood.food.grain.license.service.BeneficiaryOtherInfoLocalServiceUtil;

/**
 * The extended model base implementation for the BeneficiaryOtherInfo service. Represents a row in the &quot;dgf_beneficiary_other_info&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BeneficiaryOtherInfoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BeneficiaryOtherInfoImpl
 * @see BeneficiaryOtherInfo
 * @generated
 */
public abstract class BeneficiaryOtherInfoBaseImpl
	extends BeneficiaryOtherInfoModelImpl implements BeneficiaryOtherInfo {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a beneficiary other info model instance should use the <code>BeneficiaryOtherInfo</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			BeneficiaryOtherInfoLocalServiceUtil.addBeneficiaryOtherInfo(this);
		}
		else {
			BeneficiaryOtherInfoLocalServiceUtil.updateBeneficiaryOtherInfo(
				this);
		}
	}

}