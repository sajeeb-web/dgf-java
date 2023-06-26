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
 * The table class for the &quot;dgf_ffp_dlr_dstrbn_dtls&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DlrDistributionDetails
 * @generated
 */
public class DlrDistributionDetailsTable
	extends BaseTable<DlrDistributionDetailsTable> {

	public static final DlrDistributionDetailsTable INSTANCE =
		new DlrDistributionDetailsTable();

	public final Column<DlrDistributionDetailsTable, Long> dstrbnId =
		createColumn("dstrbnId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DlrDistributionDetailsTable, Long> dlrRegNo =
		createColumn("dlrRegNo", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DlrDistributionDetailsTable, Long> ffpRegstrId =
		createColumn(
			"ffpRegstrId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DlrDistributionDetailsTable, Date> selLingDate =
		createColumn(
			"selLingDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DlrDistributionDetailsTable, Long> commodityId =
		createColumn(
			"commodityId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DlrDistributionDetailsTable, String> commodityName =
		createColumn(
			"commodityName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DlrDistributionDetailsTable, String> sellingPrice =
		createColumn(
			"sellingPrice", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DlrDistributionDetailsTable, Long> sellingQty =
		createColumn(
			"sellingQty", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DlrDistributionDetailsTable, Long> stockBfrSelling =
		createColumn(
			"stockBfrSelling", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DlrDistributionDetailsTable, Long> stockAfterSelling =
		createColumn(
			"stockAfterSelling", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DlrDistributionDetailsTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DlrDistributionDetailsTable, Long> createdBy =
		createColumn(
			"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DlrDistributionDetailsTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DlrDistributionDetailsTable, Long> inventoryId =
		createColumn(
			"inventoryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private DlrDistributionDetailsTable() {
		super("dgf_ffp_dlr_dstrbn_dtls", DlrDistributionDetailsTable::new);
	}

}