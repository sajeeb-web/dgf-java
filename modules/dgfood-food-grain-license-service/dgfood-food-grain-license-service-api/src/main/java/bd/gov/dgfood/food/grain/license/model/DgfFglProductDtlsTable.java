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
 * The table class for the &quot;dgf_fgl_product_dtls&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DgfFglProductDtls
 * @generated
 */
public class DgfFglProductDtlsTable extends BaseTable<DgfFglProductDtlsTable> {

	public static final DgfFglProductDtlsTable INSTANCE =
		new DgfFglProductDtlsTable();

	public final Column<DgfFglProductDtlsTable, Long> fglProductPrimaryId =
		createColumn(
			"fglProductPrimaryId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<DgfFglProductDtlsTable, String> nationalId =
		createColumn(
			"nationalId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfFglProductDtlsTable, Long> fglLicPrimaryId =
		createColumn(
			"fglLicPrimaryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfFglProductDtlsTable, String> productType =
		createColumn(
			"productType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfFglProductDtlsTable, Long> stockDuration =
		createColumn(
			"stockDuration", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfFglProductDtlsTable, Long> stockAmount =
		createColumn(
			"stockAmount", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfFglProductDtlsTable, Date> createdDate =
		createColumn(
			"createdDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfFglProductDtlsTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfFglProductDtlsTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfFglProductDtlsTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private DgfFglProductDtlsTable() {
		super("dgf_fgl_product_dtls", DgfFglProductDtlsTable::new);
	}

}