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

package bd.gov.dgfood.food.grain.license.service.persistence.impl;

import bd.gov.dgfood.food.grain.license.model.DealerMastersTable;
import bd.gov.dgfood.food.grain.license.model.impl.DealerMastersImpl;
import bd.gov.dgfood.food.grain.license.model.impl.DealerMastersModelImpl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Objects;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from DealerMasters.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ArgumentsResolver.class)
public class DealerMastersModelArgumentsResolver implements ArgumentsResolver {

	@Override
	public Object[] getArguments(
		FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
		boolean original) {

		String[] columnNames = finderPath.getColumnNames();

		if ((columnNames == null) || (columnNames.length == 0)) {
			if (baseModel.isNew()) {
				return new Object[0];
			}

			return null;
		}

		DealerMastersModelImpl dealerMastersModelImpl =
			(DealerMastersModelImpl)baseModel;

		if (!checkColumn ||
			_hasModifiedColumns(dealerMastersModelImpl, columnNames)) {

			return _getValue(dealerMastersModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return DealerMastersImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return DealerMastersTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		DealerMastersModelImpl dealerMastersModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = dealerMastersModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = dealerMastersModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static boolean _hasModifiedColumns(
		DealerMastersModelImpl dealerMastersModelImpl, String[] columnNames) {

		if (columnNames.length == 0) {
			return false;
		}

		for (String columnName : columnNames) {
			if (!Objects.equals(
					dealerMastersModelImpl.getColumnOriginalValue(columnName),
					dealerMastersModelImpl.getColumnValue(columnName))) {

				return true;
			}
		}

		return false;
	}

}