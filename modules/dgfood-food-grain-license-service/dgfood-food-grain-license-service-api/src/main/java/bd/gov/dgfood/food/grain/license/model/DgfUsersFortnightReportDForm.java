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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the DgfUsersFortnightReportDForm service. Represents a row in the &quot;dgf_users_fortnightreport_d&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersFortnightReportDFormModel
 * @generated
 */
@ImplementationClassName(
	"bd.gov.dgfood.food.grain.license.model.impl.DgfUsersFortnightReportDFormImpl"
)
@ProviderType
public interface DgfUsersFortnightReportDForm
	extends DgfUsersFortnightReportDFormModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersFortnightReportDFormImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DgfUsersFortnightReportDForm, Long>
		REPORT_ID_ACCESSOR =
			new Accessor<DgfUsersFortnightReportDForm, Long>() {

				@Override
				public Long get(
					DgfUsersFortnightReportDForm dgfUsersFortnightReportDForm) {

					return dgfUsersFortnightReportDForm.getReportId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<DgfUsersFortnightReportDForm> getTypeClass() {
					return DgfUsersFortnightReportDForm.class;
				}

			};

}