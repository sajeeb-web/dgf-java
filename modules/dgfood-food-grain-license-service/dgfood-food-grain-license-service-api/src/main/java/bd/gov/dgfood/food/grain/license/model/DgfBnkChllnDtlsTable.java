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
 * The table class for the &quot;dgf_bnk_chlln_dtls&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DgfBnkChllnDtls
 * @generated
 */
public class DgfBnkChllnDtlsTable extends BaseTable<DgfBnkChllnDtlsTable> {

	public static final DgfBnkChllnDtlsTable INSTANCE =
		new DgfBnkChllnDtlsTable();

	public final Column<DgfBnkChllnDtlsTable, Long> bnkChllnId = createColumn(
		"bnkChllnId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DgfBnkChllnDtlsTable, Long> trnPoNo = createColumn(
		"trnPoNo", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfBnkChllnDtlsTable, Long> paymentStatus =
		createColumn(
			"paymentStatus", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfBnkChllnDtlsTable, Long> trnAmount = createColumn(
		"trnAmount", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfBnkChllnDtlsTable, Date> pymntChllnDate =
		createColumn(
			"pymntChllnDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfBnkChllnDtlsTable, Long> bnkChllnDocId =
		createColumn(
			"bnkChllnDocId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfBnkChllnDtlsTable, Long> bnkChllnUpldBy =
		createColumn(
			"bnkChllnUpldBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private DgfBnkChllnDtlsTable() {
		super("dgf_bnk_chlln_dtls", DgfBnkChllnDtlsTable::new);
	}

}