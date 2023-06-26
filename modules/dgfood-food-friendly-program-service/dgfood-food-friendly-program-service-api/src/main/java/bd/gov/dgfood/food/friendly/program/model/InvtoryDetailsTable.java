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

package bd.gov.dgfood.food.friendly.program.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;dgf_ffp_invtory_dtls&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see InvtoryDetails
 * @generated
 */
public class InvtoryDetailsTable extends BaseTable<InvtoryDetailsTable> {

	public static final InvtoryDetailsTable INSTANCE =
		new InvtoryDetailsTable();

	public final Column<InvtoryDetailsTable, Long> inventoryId = createColumn(
		"inventoryId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<InvtoryDetailsTable, Long> dlrRegNo = createColumn(
		"dlrRegNo", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<InvtoryDetailsTable, Long> allcNtfyNo = createColumn(
		"allcNtfyNo", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<InvtoryDetailsTable, Date> fromDate = createColumn(
		"fromDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<InvtoryDetailsTable, Date> toDate = createColumn(
		"toDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<InvtoryDetailsTable, Long> commodityId = createColumn(
		"commodityId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<InvtoryDetailsTable, String> commodityName =
		createColumn(
			"commodityName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<InvtoryDetailsTable, Long> noOfIndents = createColumn(
		"noOfIndents", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<InvtoryDetailsTable, Float> receivedQty = createColumn(
		"receivedQty", Float.class, Types.FLOAT, Column.FLAG_DEFAULT);
	public final Column<InvtoryDetailsTable, Float> soldQty = createColumn(
		"soldQty", Float.class, Types.FLOAT, Column.FLAG_DEFAULT);
	public final Column<InvtoryDetailsTable, Float> balanceQty = createColumn(
		"balanceQty", Float.class, Types.FLOAT, Column.FLAG_DEFAULT);
	public final Column<InvtoryDetailsTable, Long> createDate = createColumn(
		"createDate", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<InvtoryDetailsTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<InvtoryDetailsTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private InvtoryDetailsTable() {
		super("dgf_ffp_invtory_dtls", InvtoryDetailsTable::new);
	}

}