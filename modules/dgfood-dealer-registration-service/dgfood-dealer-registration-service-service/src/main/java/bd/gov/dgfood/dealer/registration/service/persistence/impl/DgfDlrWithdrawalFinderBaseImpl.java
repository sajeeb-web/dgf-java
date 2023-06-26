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

package bd.gov.dgfood.dealer.registration.service.persistence.impl;

import bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawal;
import bd.gov.dgfood.dealer.registration.service.persistence.DgfDlrWithdrawalPersistence;
import bd.gov.dgfood.dealer.registration.service.persistence.impl.constants.DLRPersistenceConstants;

import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class DgfDlrWithdrawalFinderBaseImpl
	extends BasePersistenceImpl<DgfDlrWithdrawal> {

	public DgfDlrWithdrawalFinderBaseImpl() {
		setModelClass(DgfDlrWithdrawal.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("dlrWithdrawalId", "dlr_withdrawal_id");
		dbColumnNames.put("nationalId", "national_id");
		dbColumnNames.put("licenseNo", "license_no");
		dbColumnNames.put("dealerName", "dealer_name");
		dbColumnNames.put("mobileNo", "mobile_no");
		dbColumnNames.put("programType", "program_type");
		dbColumnNames.put("omsSubType", "oms_sub_type");
		dbColumnNames.put("createdDate", "created_date");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("userId", "user_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("dlrRegNo", "dlr_reg_no");
		dbColumnNames.put("regApplNo", "reg_appl_no");
		dbColumnNames.put("statusByUserId", "status_by_user_id");
		dbColumnNames.put("statusByUserName", "status_by_user_name");
		dbColumnNames.put("statusDate", "status_date");

		setDBColumnNames(dbColumnNames);
	}

	@Override
	public Set<String> getBadColumnNames() {
		return dgfDlrWithdrawalPersistence.getBadColumnNames();
	}

	@Override
	@Reference(
		target = DLRPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = DLRPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = DLRPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected DgfDlrWithdrawalPersistence dgfDlrWithdrawalPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		DgfDlrWithdrawalFinderBaseImpl.class);

}