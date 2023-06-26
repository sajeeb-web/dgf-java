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

import bd.gov.dgfood.food.grain.license.model.DgfFglProductDtls;
import bd.gov.dgfood.food.grain.license.service.DgfFglProductDtlsLocalServiceUtil;

/**
 * The extended model base implementation for the DgfFglProductDtls service. Represents a row in the &quot;dgf_fgl_product_dtls&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DgfFglProductDtlsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfFglProductDtlsImpl
 * @see DgfFglProductDtls
 * @generated
 */
public abstract class DgfFglProductDtlsBaseImpl
	extends DgfFglProductDtlsModelImpl implements DgfFglProductDtls {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dgf fgl product dtls model instance should use the <code>DgfFglProductDtls</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			DgfFglProductDtlsLocalServiceUtil.addDgfFglProductDtls(this);
		}
		else {
			DgfFglProductDtlsLocalServiceUtil.updateDgfFglProductDtls(this);
		}
	}

}