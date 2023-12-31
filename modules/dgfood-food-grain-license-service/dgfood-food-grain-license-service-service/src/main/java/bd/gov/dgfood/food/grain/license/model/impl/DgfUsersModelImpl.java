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

package bd.gov.dgfood.food.grain.license.model.impl;

import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.model.DgfUsersModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the DgfUsers service. Represents a row in the &quot;dgf_users&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DgfUsersModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DgfUsersImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersImpl
 * @generated
 */
@JSON(strict = true)
public class DgfUsersModelImpl
	extends BaseModelImpl<DgfUsers> implements DgfUsersModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dgf users model instance should use the <code>DgfUsers</code> interface instead.
	 */
	public static final String TABLE_NAME = "dgf_users";

	public static final Object[][] TABLE_COLUMNS = {
		{"userId", Types.BIGINT}, {"nationalId", Types.VARCHAR},
		{"password_", Types.VARCHAR}, {"applicantName", Types.VARCHAR},
		{"fatherName", Types.VARCHAR}, {"lastName", Types.VARCHAR},
		{"motherName", Types.VARCHAR}, {"gender", Types.VARCHAR},
		{"maritalStatus", Types.VARCHAR}, {"birthDate", Types.TIMESTAMP},
		{"mobileNo", Types.VARCHAR}, {"presentAddrId", Types.BIGINT},
		{"applcProfile", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("nationalId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("password_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("applicantName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fatherName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("motherName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("gender", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("maritalStatus", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("birthDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("mobileNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("presentAddrId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("applcProfile", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table dgf_users (userId LONG not null primary key,nationalId VARCHAR(75) null,password_ VARCHAR(75) null,applicantName VARCHAR(75) null,fatherName VARCHAR(75) null,lastName VARCHAR(75) null,motherName VARCHAR(75) null,gender VARCHAR(75) null,maritalStatus VARCHAR(75) null,birthDate DATE null,mobileNo VARCHAR(75) null,presentAddrId LONG,applcProfile VARCHAR(75) null,createDate DATE null,modifiedDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table dgf_users";

	public static final String ORDER_BY_JPQL = " ORDER BY dgfUsers.userId ASC";

	public static final String ORDER_BY_SQL = " ORDER BY dgf_users.userId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long MOBILENO_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long NATIONALID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long USERID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public DgfUsersModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _userId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DgfUsers.class;
	}

	@Override
	public String getModelClassName() {
		return DgfUsers.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DgfUsers, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DgfUsers, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DgfUsers, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((DgfUsers)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DgfUsers, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DgfUsers, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DgfUsers)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DgfUsers, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DgfUsers, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<DgfUsers, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<DgfUsers, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<DgfUsers, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<DgfUsers, Object>>();
		Map<String, BiConsumer<DgfUsers, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<DgfUsers, ?>>();

		attributeGetterFunctions.put("userId", DgfUsers::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<DgfUsers, Long>)DgfUsers::setUserId);
		attributeGetterFunctions.put("nationalId", DgfUsers::getNationalId);
		attributeSetterBiConsumers.put(
			"nationalId",
			(BiConsumer<DgfUsers, String>)DgfUsers::setNationalId);
		attributeGetterFunctions.put("password", DgfUsers::getPassword);
		attributeSetterBiConsumers.put(
			"password", (BiConsumer<DgfUsers, String>)DgfUsers::setPassword);
		attributeGetterFunctions.put(
			"applicantName", DgfUsers::getApplicantName);
		attributeSetterBiConsumers.put(
			"applicantName",
			(BiConsumer<DgfUsers, String>)DgfUsers::setApplicantName);
		attributeGetterFunctions.put("fatherName", DgfUsers::getFatherName);
		attributeSetterBiConsumers.put(
			"fatherName",
			(BiConsumer<DgfUsers, String>)DgfUsers::setFatherName);
		attributeGetterFunctions.put("lastName", DgfUsers::getLastName);
		attributeSetterBiConsumers.put(
			"lastName", (BiConsumer<DgfUsers, String>)DgfUsers::setLastName);
		attributeGetterFunctions.put("motherName", DgfUsers::getMotherName);
		attributeSetterBiConsumers.put(
			"motherName",
			(BiConsumer<DgfUsers, String>)DgfUsers::setMotherName);
		attributeGetterFunctions.put("gender", DgfUsers::getGender);
		attributeSetterBiConsumers.put(
			"gender", (BiConsumer<DgfUsers, String>)DgfUsers::setGender);
		attributeGetterFunctions.put(
			"maritalStatus", DgfUsers::getMaritalStatus);
		attributeSetterBiConsumers.put(
			"maritalStatus",
			(BiConsumer<DgfUsers, String>)DgfUsers::setMaritalStatus);
		attributeGetterFunctions.put("birthDate", DgfUsers::getBirthDate);
		attributeSetterBiConsumers.put(
			"birthDate", (BiConsumer<DgfUsers, Date>)DgfUsers::setBirthDate);
		attributeGetterFunctions.put("mobileNo", DgfUsers::getMobileNo);
		attributeSetterBiConsumers.put(
			"mobileNo", (BiConsumer<DgfUsers, String>)DgfUsers::setMobileNo);
		attributeGetterFunctions.put(
			"presentAddrId", DgfUsers::getPresentAddrId);
		attributeSetterBiConsumers.put(
			"presentAddrId",
			(BiConsumer<DgfUsers, Long>)DgfUsers::setPresentAddrId);
		attributeGetterFunctions.put("applcProfile", DgfUsers::getApplcProfile);
		attributeSetterBiConsumers.put(
			"applcProfile",
			(BiConsumer<DgfUsers, String>)DgfUsers::setApplcProfile);
		attributeGetterFunctions.put("createDate", DgfUsers::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<DgfUsers, Date>)DgfUsers::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", DgfUsers::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<DgfUsers, Date>)DgfUsers::setModifiedDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalUserId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("userId"));
	}

	@JSON
	@Override
	public String getNationalId() {
		if (_nationalId == null) {
			return "";
		}
		else {
			return _nationalId;
		}
	}

	@Override
	public void setNationalId(String nationalId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_nationalId = nationalId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalNationalId() {
		return getColumnOriginalValue("nationalId");
	}

	@JSON
	@Override
	public String getPassword() {
		if (_password == null) {
			return "";
		}
		else {
			return _password;
		}
	}

	@Override
	public void setPassword(String password) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_password = password;
	}

	@JSON
	@Override
	public String getApplicantName() {
		if (_applicantName == null) {
			return "";
		}
		else {
			return _applicantName;
		}
	}

	@Override
	public void setApplicantName(String applicantName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_applicantName = applicantName;
	}

	@JSON
	@Override
	public String getFatherName() {
		if (_fatherName == null) {
			return "";
		}
		else {
			return _fatherName;
		}
	}

	@Override
	public void setFatherName(String fatherName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fatherName = fatherName;
	}

	@JSON
	@Override
	public String getLastName() {
		if (_lastName == null) {
			return "";
		}
		else {
			return _lastName;
		}
	}

	@Override
	public void setLastName(String lastName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_lastName = lastName;
	}

	@JSON
	@Override
	public String getMotherName() {
		if (_motherName == null) {
			return "";
		}
		else {
			return _motherName;
		}
	}

	@Override
	public void setMotherName(String motherName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_motherName = motherName;
	}

	@JSON
	@Override
	public String getGender() {
		if (_gender == null) {
			return "";
		}
		else {
			return _gender;
		}
	}

	@Override
	public void setGender(String gender) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_gender = gender;
	}

	@JSON
	@Override
	public String getMaritalStatus() {
		if (_maritalStatus == null) {
			return "";
		}
		else {
			return _maritalStatus;
		}
	}

	@Override
	public void setMaritalStatus(String maritalStatus) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_maritalStatus = maritalStatus;
	}

	@JSON
	@Override
	public Date getBirthDate() {
		return _birthDate;
	}

	@Override
	public void setBirthDate(Date birthDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_birthDate = birthDate;
	}

	@JSON
	@Override
	public String getMobileNo() {
		if (_mobileNo == null) {
			return "";
		}
		else {
			return _mobileNo;
		}
	}

	@Override
	public void setMobileNo(String mobileNo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_mobileNo = mobileNo;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalMobileNo() {
		return getColumnOriginalValue("mobileNo");
	}

	@JSON
	@Override
	public long getPresentAddrId() {
		return _presentAddrId;
	}

	@Override
	public void setPresentAddrId(long presentAddrId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_presentAddrId = presentAddrId;
	}

	@JSON
	@Override
	public String getApplcProfile() {
		if (_applcProfile == null) {
			return "";
		}
		else {
			return _applcProfile;
		}
	}

	@Override
	public void setApplcProfile(String applcProfile) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_applcProfile = applcProfile;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, DgfUsers.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DgfUsers toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, DgfUsers>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DgfUsersImpl dgfUsersImpl = new DgfUsersImpl();

		dgfUsersImpl.setUserId(getUserId());
		dgfUsersImpl.setNationalId(getNationalId());
		dgfUsersImpl.setPassword(getPassword());
		dgfUsersImpl.setApplicantName(getApplicantName());
		dgfUsersImpl.setFatherName(getFatherName());
		dgfUsersImpl.setLastName(getLastName());
		dgfUsersImpl.setMotherName(getMotherName());
		dgfUsersImpl.setGender(getGender());
		dgfUsersImpl.setMaritalStatus(getMaritalStatus());
		dgfUsersImpl.setBirthDate(getBirthDate());
		dgfUsersImpl.setMobileNo(getMobileNo());
		dgfUsersImpl.setPresentAddrId(getPresentAddrId());
		dgfUsersImpl.setApplcProfile(getApplcProfile());
		dgfUsersImpl.setCreateDate(getCreateDate());
		dgfUsersImpl.setModifiedDate(getModifiedDate());

		dgfUsersImpl.resetOriginalValues();

		return dgfUsersImpl;
	}

	@Override
	public DgfUsers cloneWithOriginalValues() {
		DgfUsersImpl dgfUsersImpl = new DgfUsersImpl();

		dgfUsersImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		dgfUsersImpl.setNationalId(
			this.<String>getColumnOriginalValue("nationalId"));
		dgfUsersImpl.setPassword(
			this.<String>getColumnOriginalValue("password_"));
		dgfUsersImpl.setApplicantName(
			this.<String>getColumnOriginalValue("applicantName"));
		dgfUsersImpl.setFatherName(
			this.<String>getColumnOriginalValue("fatherName"));
		dgfUsersImpl.setLastName(
			this.<String>getColumnOriginalValue("lastName"));
		dgfUsersImpl.setMotherName(
			this.<String>getColumnOriginalValue("motherName"));
		dgfUsersImpl.setGender(this.<String>getColumnOriginalValue("gender"));
		dgfUsersImpl.setMaritalStatus(
			this.<String>getColumnOriginalValue("maritalStatus"));
		dgfUsersImpl.setBirthDate(
			this.<Date>getColumnOriginalValue("birthDate"));
		dgfUsersImpl.setMobileNo(
			this.<String>getColumnOriginalValue("mobileNo"));
		dgfUsersImpl.setPresentAddrId(
			this.<Long>getColumnOriginalValue("presentAddrId"));
		dgfUsersImpl.setApplcProfile(
			this.<String>getColumnOriginalValue("applcProfile"));
		dgfUsersImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		dgfUsersImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));

		return dgfUsersImpl;
	}

	@Override
	public int compareTo(DgfUsers dgfUsers) {
		long primaryKey = dgfUsers.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DgfUsers)) {
			return false;
		}

		DgfUsers dgfUsers = (DgfUsers)object;

		long primaryKey = dgfUsers.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<DgfUsers> toCacheModel() {
		DgfUsersCacheModel dgfUsersCacheModel = new DgfUsersCacheModel();

		dgfUsersCacheModel.userId = getUserId();

		dgfUsersCacheModel.nationalId = getNationalId();

		String nationalId = dgfUsersCacheModel.nationalId;

		if ((nationalId != null) && (nationalId.length() == 0)) {
			dgfUsersCacheModel.nationalId = null;
		}

		dgfUsersCacheModel.password = getPassword();

		String password = dgfUsersCacheModel.password;

		if ((password != null) && (password.length() == 0)) {
			dgfUsersCacheModel.password = null;
		}

		dgfUsersCacheModel.applicantName = getApplicantName();

		String applicantName = dgfUsersCacheModel.applicantName;

		if ((applicantName != null) && (applicantName.length() == 0)) {
			dgfUsersCacheModel.applicantName = null;
		}

		dgfUsersCacheModel.fatherName = getFatherName();

		String fatherName = dgfUsersCacheModel.fatherName;

		if ((fatherName != null) && (fatherName.length() == 0)) {
			dgfUsersCacheModel.fatherName = null;
		}

		dgfUsersCacheModel.lastName = getLastName();

		String lastName = dgfUsersCacheModel.lastName;

		if ((lastName != null) && (lastName.length() == 0)) {
			dgfUsersCacheModel.lastName = null;
		}

		dgfUsersCacheModel.motherName = getMotherName();

		String motherName = dgfUsersCacheModel.motherName;

		if ((motherName != null) && (motherName.length() == 0)) {
			dgfUsersCacheModel.motherName = null;
		}

		dgfUsersCacheModel.gender = getGender();

		String gender = dgfUsersCacheModel.gender;

		if ((gender != null) && (gender.length() == 0)) {
			dgfUsersCacheModel.gender = null;
		}

		dgfUsersCacheModel.maritalStatus = getMaritalStatus();

		String maritalStatus = dgfUsersCacheModel.maritalStatus;

		if ((maritalStatus != null) && (maritalStatus.length() == 0)) {
			dgfUsersCacheModel.maritalStatus = null;
		}

		Date birthDate = getBirthDate();

		if (birthDate != null) {
			dgfUsersCacheModel.birthDate = birthDate.getTime();
		}
		else {
			dgfUsersCacheModel.birthDate = Long.MIN_VALUE;
		}

		dgfUsersCacheModel.mobileNo = getMobileNo();

		String mobileNo = dgfUsersCacheModel.mobileNo;

		if ((mobileNo != null) && (mobileNo.length() == 0)) {
			dgfUsersCacheModel.mobileNo = null;
		}

		dgfUsersCacheModel.presentAddrId = getPresentAddrId();

		dgfUsersCacheModel.applcProfile = getApplcProfile();

		String applcProfile = dgfUsersCacheModel.applcProfile;

		if ((applcProfile != null) && (applcProfile.length() == 0)) {
			dgfUsersCacheModel.applcProfile = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			dgfUsersCacheModel.createDate = createDate.getTime();
		}
		else {
			dgfUsersCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dgfUsersCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			dgfUsersCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return dgfUsersCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DgfUsers, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DgfUsers, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DgfUsers, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((DgfUsers)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, DgfUsers>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					DgfUsers.class, ModelWrapper.class);

	}

	private long _userId;
	private String _nationalId;
	private String _password;
	private String _applicantName;
	private String _fatherName;
	private String _lastName;
	private String _motherName;
	private String _gender;
	private String _maritalStatus;
	private Date _birthDate;
	private String _mobileNo;
	private long _presentAddrId;
	private String _applcProfile;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<DgfUsers, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((DgfUsers)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("nationalId", _nationalId);
		_columnOriginalValues.put("password_", _password);
		_columnOriginalValues.put("applicantName", _applicantName);
		_columnOriginalValues.put("fatherName", _fatherName);
		_columnOriginalValues.put("lastName", _lastName);
		_columnOriginalValues.put("motherName", _motherName);
		_columnOriginalValues.put("gender", _gender);
		_columnOriginalValues.put("maritalStatus", _maritalStatus);
		_columnOriginalValues.put("birthDate", _birthDate);
		_columnOriginalValues.put("mobileNo", _mobileNo);
		_columnOriginalValues.put("presentAddrId", _presentAddrId);
		_columnOriginalValues.put("applcProfile", _applcProfile);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("password_", "password");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("userId", 1L);

		columnBitmasks.put("nationalId", 2L);

		columnBitmasks.put("password_", 4L);

		columnBitmasks.put("applicantName", 8L);

		columnBitmasks.put("fatherName", 16L);

		columnBitmasks.put("lastName", 32L);

		columnBitmasks.put("motherName", 64L);

		columnBitmasks.put("gender", 128L);

		columnBitmasks.put("maritalStatus", 256L);

		columnBitmasks.put("birthDate", 512L);

		columnBitmasks.put("mobileNo", 1024L);

		columnBitmasks.put("presentAddrId", 2048L);

		columnBitmasks.put("applcProfile", 4096L);

		columnBitmasks.put("createDate", 8192L);

		columnBitmasks.put("modifiedDate", 16384L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private DgfUsers _escapedModel;

}