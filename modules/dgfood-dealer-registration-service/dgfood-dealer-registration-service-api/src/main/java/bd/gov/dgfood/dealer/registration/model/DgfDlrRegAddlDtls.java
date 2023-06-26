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

package bd.gov.dgfood.dealer.registration.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the DgfDlrRegAddlDtls service. Represents a row in the &quot;dgf_dlr_reg_addl_dtls&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrRegAddlDtlsModel
 * @generated
 */
@ImplementationClassName(
	"bd.gov.dgfood.dealer.registration.model.impl.DgfDlrRegAddlDtlsImpl"
)
@ProviderType
public interface DgfDlrRegAddlDtls
	extends DgfDlrRegAddlDtlsModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>bd.gov.dgfood.dealer.registration.model.impl.DgfDlrRegAddlDtlsImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DgfDlrRegAddlDtls, Long>
		DLR_REG_ADDL_DTLS_ID_ACCESSOR =
			new Accessor<DgfDlrRegAddlDtls, Long>() {

				@Override
				public Long get(DgfDlrRegAddlDtls dgfDlrRegAddlDtls) {
					return dgfDlrRegAddlDtls.getDlrRegAddlDtlsId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<DgfDlrRegAddlDtls> getTypeClass() {
					return DgfDlrRegAddlDtls.class;
				}

			};

}