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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;dgf_fgl_license_no&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DgfFglLicenseNo
 * @generated
 */
public class DgfFglLicenseNoTable extends BaseTable<DgfFglLicenseNoTable> {

	public static final DgfFglLicenseNoTable INSTANCE =
		new DgfFglLicenseNoTable();

	public final Column<DgfFglLicenseNoTable, Long> id = createColumn(
		"id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DgfFglLicenseNoTable, Long> suffix = createColumn(
		"suffix", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfFglLicenseNoTable, Long> prefix = createColumn(
		"prefix", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfFglLicenseNoTable, Long> serialNo = createColumn(
		"serial_no", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfFglLicenseNoTable, String> licenseNo = createColumn(
		"license_no", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfFglLicenseNoTable, Date> createdAt = createColumn(
		"created_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfFglLicenseNoTable, Date> updatedAt = createColumn(
		"updated_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private DgfFglLicenseNoTable() {
		super("dgf_fgl_license_no", DgfFglLicenseNoTable::new);
	}

}