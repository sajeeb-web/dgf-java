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
 * The table class for the &quot;dgf_ffpb_details&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see FfpbDetails
 * @generated
 */
public class FfpbDetailsTable extends BaseTable<FfpbDetailsTable> {

	public static final FfpbDetailsTable INSTANCE = new FfpbDetailsTable();

	public final Column<FfpbDetailsTable, Long> ffpRegstrId = createColumn(
		"ffpRegstrId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FfpbDetailsTable, Long> nationalId = createColumn(
		"nationalId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FfpbDetailsTable, Long> dlrRegNo = createColumn(
		"dlrRegNo", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FfpbDetailsTable, String> ffpCardNo = createColumn(
		"ffpCardNo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FfpbDetailsTable, Date> dateOfBirth = createColumn(
		"dateOfBirth", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FfpbDetailsTable, String> mobileNo = createColumn(
		"mobileNo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FfpbDetailsTable, String> emialId = createColumn(
		"emialId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FfpbDetailsTable, Long> maritalStatus = createColumn(
		"maritalStatus", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FfpbDetailsTable, Long> gender = createColumn(
		"gender", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FfpbDetailsTable, Long> spouseNid = createColumn(
		"spouseNid", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FfpbDetailsTable, String> prstAddrRegion = createColumn(
		"prstAddrRegion", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FfpbDetailsTable, String> prstAddrDisrict =
		createColumn(
			"prstAddrDisrict", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FfpbDetailsTable, String> prstAddrUpzilla =
		createColumn(
			"prstAddrUpzilla", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FfpbDetailsTable, String> prstAddrUnion = createColumn(
		"prstAddrUnion", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FfpbDetailsTable, String> prstAddrVillage =
		createColumn(
			"prstAddrVillage", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FfpbDetailsTable, String> prstAddrWard = createColumn(
		"prstAddrWard", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FfpbDetailsTable, Long> prstAddrZip = createColumn(
		"prstAddrZip", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FfpbDetailsTable, Long> prstAddrPstoffc = createColumn(
		"prstAddrPstoffc", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FfpbDetailsTable, String> prstAddrHoseaddr =
		createColumn(
			"prstAddrHoseaddr", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FfpbDetailsTable, Long> ffpApplCrtdBy = createColumn(
		"ffpApplCrtdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FfpbDetailsTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FfpbDetailsTable, Long> ffpApplMdfyBy = createColumn(
		"ffpApplMdfyBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FfpbDetailsTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FfpbDetailsTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FfpbDetailsTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FfpbDetailsTable, String> applApprejCmnts =
		createColumn(
			"applApprejCmnts", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FfpbDetailsTable, Long> ffpbApplStatus = createColumn(
		"ffpbApplStatus", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FfpbDetailsTable, Float> version = createColumn(
		"version", Float.class, Types.FLOAT, Column.FLAG_DEFAULT);
	public final Column<FfpbDetailsTable, Long> status = createColumn(
		"status", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FfpbDetailsTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FfpbDetailsTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private FfpbDetailsTable() {
		super("dgf_ffpb_details", FfpbDetailsTable::new);
	}

}