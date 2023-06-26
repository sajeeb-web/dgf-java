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
 * The table class for the &quot;dgf_users&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsers
 * @generated
 */
public class DgfUsersTable extends BaseTable<DgfUsersTable> {

	public static final DgfUsersTable INSTANCE = new DgfUsersTable();

	public final Column<DgfUsersTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DgfUsersTable, String> nationalId = createColumn(
		"nationalId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersTable, String> password = createColumn(
		"password_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersTable, String> applicantName = createColumn(
		"applicantName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersTable, String> fatherName = createColumn(
		"fatherName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersTable, String> lastName = createColumn(
		"lastName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersTable, String> motherName = createColumn(
		"motherName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersTable, String> gender = createColumn(
		"gender", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersTable, String> maritalStatus = createColumn(
		"maritalStatus", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersTable, Date> birthDate = createColumn(
		"birthDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfUsersTable, String> mobileNo = createColumn(
		"mobileNo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersTable, Long> presentAddrId = createColumn(
		"presentAddrId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DgfUsersTable, String> applcProfile = createColumn(
		"applcProfile", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DgfUsersTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DgfUsersTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private DgfUsersTable() {
		super("dgf_users", DgfUsersTable::new);
	}

}