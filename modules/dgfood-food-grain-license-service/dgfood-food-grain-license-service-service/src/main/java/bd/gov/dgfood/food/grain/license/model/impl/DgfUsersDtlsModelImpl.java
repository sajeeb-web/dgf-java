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

import bd.gov.dgfood.food.grain.license.model.DgfUsersDtls;
import bd.gov.dgfood.food.grain.license.model.DgfUsersDtlsModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
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
 * The base model implementation for the DgfUsersDtls service. Represents a row in the &quot;dgf_users_dtls&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DgfUsersDtlsModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DgfUsersDtlsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersDtlsImpl
 * @generated
 */
@JSON(strict = true)
public class DgfUsersDtlsModelImpl
	extends BaseModelImpl<DgfUsersDtls> implements DgfUsersDtlsModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dgf users dtls model instance should use the <code>DgfUsersDtls</code> interface instead.
	 */
	public static final String TABLE_NAME = "dgf_users_dtls";

	public static final Object[][] TABLE_COLUMNS = {
		{"userDetailsId", Types.BIGINT}, {"nationalId", Types.BIGINT},
		{"email", Types.VARCHAR}, {"nidPhotoAttchId", Types.BIGINT},
		{"nidDivision", Types.VARCHAR}, {"nidDistrict", Types.VARCHAR},
		{"nidUpzilla", Types.VARCHAR}, {"nidUnion", Types.VARCHAR},
		{"nidVillage", Types.VARCHAR}, {"nidWard", Types.VARCHAR},
		{"nidZipCode", Types.VARCHAR}, {"nidHouseAddress", Types.VARCHAR},
		{"lastUpdatedDate", Types.TIMESTAMP}, {"nidPostOffice", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("userDetailsId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("nationalId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("nidPhotoAttchId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("nidDivision", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("nidDistrict", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("nidUpzilla", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("nidUnion", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("nidVillage", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("nidWard", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("nidZipCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("nidHouseAddress", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastUpdatedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("nidPostOffice", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table dgf_users_dtls (userDetailsId LONG not null primary key,nationalId LONG,email VARCHAR(75) null,nidPhotoAttchId LONG,nidDivision VARCHAR(75) null,nidDistrict VARCHAR(75) null,nidUpzilla VARCHAR(75) null,nidUnion VARCHAR(75) null,nidVillage VARCHAR(75) null,nidWard VARCHAR(75) null,nidZipCode VARCHAR(75) null,nidHouseAddress VARCHAR(75) null,lastUpdatedDate DATE null,nidPostOffice VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table dgf_users_dtls";

	public static final String ORDER_BY_JPQL =
		" ORDER BY dgfUsersDtls.userDetailsId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY dgf_users_dtls.userDetailsId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long NATIONALID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long USERDETAILSID_COLUMN_BITMASK = 2L;

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

	public DgfUsersDtlsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _userDetailsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUserDetailsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userDetailsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DgfUsersDtls.class;
	}

	@Override
	public String getModelClassName() {
		return DgfUsersDtls.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DgfUsersDtls, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DgfUsersDtls, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DgfUsersDtls, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((DgfUsersDtls)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DgfUsersDtls, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DgfUsersDtls, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DgfUsersDtls)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DgfUsersDtls, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DgfUsersDtls, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<DgfUsersDtls, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<DgfUsersDtls, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<DgfUsersDtls, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<DgfUsersDtls, Object>>();
		Map<String, BiConsumer<DgfUsersDtls, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<DgfUsersDtls, ?>>();

		attributeGetterFunctions.put(
			"userDetailsId", DgfUsersDtls::getUserDetailsId);
		attributeSetterBiConsumers.put(
			"userDetailsId",
			(BiConsumer<DgfUsersDtls, Long>)DgfUsersDtls::setUserDetailsId);
		attributeGetterFunctions.put("nationalId", DgfUsersDtls::getNationalId);
		attributeSetterBiConsumers.put(
			"nationalId",
			(BiConsumer<DgfUsersDtls, Long>)DgfUsersDtls::setNationalId);
		attributeGetterFunctions.put("email", DgfUsersDtls::getEmail);
		attributeSetterBiConsumers.put(
			"email", (BiConsumer<DgfUsersDtls, String>)DgfUsersDtls::setEmail);
		attributeGetterFunctions.put(
			"nidPhotoAttchId", DgfUsersDtls::getNidPhotoAttchId);
		attributeSetterBiConsumers.put(
			"nidPhotoAttchId",
			(BiConsumer<DgfUsersDtls, Long>)DgfUsersDtls::setNidPhotoAttchId);
		attributeGetterFunctions.put(
			"nidDivision", DgfUsersDtls::getNidDivision);
		attributeSetterBiConsumers.put(
			"nidDivision",
			(BiConsumer<DgfUsersDtls, String>)DgfUsersDtls::setNidDivision);
		attributeGetterFunctions.put(
			"nidDistrict", DgfUsersDtls::getNidDistrict);
		attributeSetterBiConsumers.put(
			"nidDistrict",
			(BiConsumer<DgfUsersDtls, String>)DgfUsersDtls::setNidDistrict);
		attributeGetterFunctions.put("nidUpzilla", DgfUsersDtls::getNidUpzilla);
		attributeSetterBiConsumers.put(
			"nidUpzilla",
			(BiConsumer<DgfUsersDtls, String>)DgfUsersDtls::setNidUpzilla);
		attributeGetterFunctions.put("nidUnion", DgfUsersDtls::getNidUnion);
		attributeSetterBiConsumers.put(
			"nidUnion",
			(BiConsumer<DgfUsersDtls, String>)DgfUsersDtls::setNidUnion);
		attributeGetterFunctions.put("nidVillage", DgfUsersDtls::getNidVillage);
		attributeSetterBiConsumers.put(
			"nidVillage",
			(BiConsumer<DgfUsersDtls, String>)DgfUsersDtls::setNidVillage);
		attributeGetterFunctions.put("nidWard", DgfUsersDtls::getNidWard);
		attributeSetterBiConsumers.put(
			"nidWard",
			(BiConsumer<DgfUsersDtls, String>)DgfUsersDtls::setNidWard);
		attributeGetterFunctions.put("nidZipCode", DgfUsersDtls::getNidZipCode);
		attributeSetterBiConsumers.put(
			"nidZipCode",
			(BiConsumer<DgfUsersDtls, String>)DgfUsersDtls::setNidZipCode);
		attributeGetterFunctions.put(
			"nidHouseAddress", DgfUsersDtls::getNidHouseAddress);
		attributeSetterBiConsumers.put(
			"nidHouseAddress",
			(BiConsumer<DgfUsersDtls, String>)DgfUsersDtls::setNidHouseAddress);
		attributeGetterFunctions.put(
			"lastUpdatedDate", DgfUsersDtls::getLastUpdatedDate);
		attributeSetterBiConsumers.put(
			"lastUpdatedDate",
			(BiConsumer<DgfUsersDtls, Date>)DgfUsersDtls::setLastUpdatedDate);
		attributeGetterFunctions.put(
			"nidPostOffice", DgfUsersDtls::getNidPostOffice);
		attributeSetterBiConsumers.put(
			"nidPostOffice",
			(BiConsumer<DgfUsersDtls, String>)DgfUsersDtls::setNidPostOffice);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getUserDetailsId() {
		return _userDetailsId;
	}

	@Override
	public void setUserDetailsId(long userDetailsId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userDetailsId = userDetailsId;
	}

	@JSON
	@Override
	public long getNationalId() {
		return _nationalId;
	}

	@Override
	public void setNationalId(long nationalId) {
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
	public long getOriginalNationalId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("nationalId"));
	}

	@JSON
	@Override
	public String getEmail() {
		if (_email == null) {
			return "";
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_email = email;
	}

	@JSON
	@Override
	public long getNidPhotoAttchId() {
		return _nidPhotoAttchId;
	}

	@Override
	public void setNidPhotoAttchId(long nidPhotoAttchId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_nidPhotoAttchId = nidPhotoAttchId;
	}

	@JSON
	@Override
	public String getNidDivision() {
		if (_nidDivision == null) {
			return "";
		}
		else {
			return _nidDivision;
		}
	}

	@Override
	public void setNidDivision(String nidDivision) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_nidDivision = nidDivision;
	}

	@JSON
	@Override
	public String getNidDistrict() {
		if (_nidDistrict == null) {
			return "";
		}
		else {
			return _nidDistrict;
		}
	}

	@Override
	public void setNidDistrict(String nidDistrict) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_nidDistrict = nidDistrict;
	}

	@JSON
	@Override
	public String getNidUpzilla() {
		if (_nidUpzilla == null) {
			return "";
		}
		else {
			return _nidUpzilla;
		}
	}

	@Override
	public void setNidUpzilla(String nidUpzilla) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_nidUpzilla = nidUpzilla;
	}

	@JSON
	@Override
	public String getNidUnion() {
		if (_nidUnion == null) {
			return "";
		}
		else {
			return _nidUnion;
		}
	}

	@Override
	public void setNidUnion(String nidUnion) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_nidUnion = nidUnion;
	}

	@JSON
	@Override
	public String getNidVillage() {
		if (_nidVillage == null) {
			return "";
		}
		else {
			return _nidVillage;
		}
	}

	@Override
	public void setNidVillage(String nidVillage) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_nidVillage = nidVillage;
	}

	@JSON
	@Override
	public String getNidWard() {
		if (_nidWard == null) {
			return "";
		}
		else {
			return _nidWard;
		}
	}

	@Override
	public void setNidWard(String nidWard) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_nidWard = nidWard;
	}

	@JSON
	@Override
	public String getNidZipCode() {
		if (_nidZipCode == null) {
			return "";
		}
		else {
			return _nidZipCode;
		}
	}

	@Override
	public void setNidZipCode(String nidZipCode) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_nidZipCode = nidZipCode;
	}

	@JSON
	@Override
	public String getNidHouseAddress() {
		if (_nidHouseAddress == null) {
			return "";
		}
		else {
			return _nidHouseAddress;
		}
	}

	@Override
	public void setNidHouseAddress(String nidHouseAddress) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_nidHouseAddress = nidHouseAddress;
	}

	@JSON
	@Override
	public Date getLastUpdatedDate() {
		return _lastUpdatedDate;
	}

	@Override
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_lastUpdatedDate = lastUpdatedDate;
	}

	@JSON
	@Override
	public String getNidPostOffice() {
		if (_nidPostOffice == null) {
			return "";
		}
		else {
			return _nidPostOffice;
		}
	}

	@Override
	public void setNidPostOffice(String nidPostOffice) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_nidPostOffice = nidPostOffice;
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
			0, DgfUsersDtls.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DgfUsersDtls toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, DgfUsersDtls>
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
		DgfUsersDtlsImpl dgfUsersDtlsImpl = new DgfUsersDtlsImpl();

		dgfUsersDtlsImpl.setUserDetailsId(getUserDetailsId());
		dgfUsersDtlsImpl.setNationalId(getNationalId());
		dgfUsersDtlsImpl.setEmail(getEmail());
		dgfUsersDtlsImpl.setNidPhotoAttchId(getNidPhotoAttchId());
		dgfUsersDtlsImpl.setNidDivision(getNidDivision());
		dgfUsersDtlsImpl.setNidDistrict(getNidDistrict());
		dgfUsersDtlsImpl.setNidUpzilla(getNidUpzilla());
		dgfUsersDtlsImpl.setNidUnion(getNidUnion());
		dgfUsersDtlsImpl.setNidVillage(getNidVillage());
		dgfUsersDtlsImpl.setNidWard(getNidWard());
		dgfUsersDtlsImpl.setNidZipCode(getNidZipCode());
		dgfUsersDtlsImpl.setNidHouseAddress(getNidHouseAddress());
		dgfUsersDtlsImpl.setLastUpdatedDate(getLastUpdatedDate());
		dgfUsersDtlsImpl.setNidPostOffice(getNidPostOffice());

		dgfUsersDtlsImpl.resetOriginalValues();

		return dgfUsersDtlsImpl;
	}

	@Override
	public DgfUsersDtls cloneWithOriginalValues() {
		DgfUsersDtlsImpl dgfUsersDtlsImpl = new DgfUsersDtlsImpl();

		dgfUsersDtlsImpl.setUserDetailsId(
			this.<Long>getColumnOriginalValue("userDetailsId"));
		dgfUsersDtlsImpl.setNationalId(
			this.<Long>getColumnOriginalValue("nationalId"));
		dgfUsersDtlsImpl.setEmail(this.<String>getColumnOriginalValue("email"));
		dgfUsersDtlsImpl.setNidPhotoAttchId(
			this.<Long>getColumnOriginalValue("nidPhotoAttchId"));
		dgfUsersDtlsImpl.setNidDivision(
			this.<String>getColumnOriginalValue("nidDivision"));
		dgfUsersDtlsImpl.setNidDistrict(
			this.<String>getColumnOriginalValue("nidDistrict"));
		dgfUsersDtlsImpl.setNidUpzilla(
			this.<String>getColumnOriginalValue("nidUpzilla"));
		dgfUsersDtlsImpl.setNidUnion(
			this.<String>getColumnOriginalValue("nidUnion"));
		dgfUsersDtlsImpl.setNidVillage(
			this.<String>getColumnOriginalValue("nidVillage"));
		dgfUsersDtlsImpl.setNidWard(
			this.<String>getColumnOriginalValue("nidWard"));
		dgfUsersDtlsImpl.setNidZipCode(
			this.<String>getColumnOriginalValue("nidZipCode"));
		dgfUsersDtlsImpl.setNidHouseAddress(
			this.<String>getColumnOriginalValue("nidHouseAddress"));
		dgfUsersDtlsImpl.setLastUpdatedDate(
			this.<Date>getColumnOriginalValue("lastUpdatedDate"));
		dgfUsersDtlsImpl.setNidPostOffice(
			this.<String>getColumnOriginalValue("nidPostOffice"));

		return dgfUsersDtlsImpl;
	}

	@Override
	public int compareTo(DgfUsersDtls dgfUsersDtls) {
		long primaryKey = dgfUsersDtls.getPrimaryKey();

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

		if (!(object instanceof DgfUsersDtls)) {
			return false;
		}

		DgfUsersDtls dgfUsersDtls = (DgfUsersDtls)object;

		long primaryKey = dgfUsersDtls.getPrimaryKey();

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

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<DgfUsersDtls> toCacheModel() {
		DgfUsersDtlsCacheModel dgfUsersDtlsCacheModel =
			new DgfUsersDtlsCacheModel();

		dgfUsersDtlsCacheModel.userDetailsId = getUserDetailsId();

		dgfUsersDtlsCacheModel.nationalId = getNationalId();

		dgfUsersDtlsCacheModel.email = getEmail();

		String email = dgfUsersDtlsCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			dgfUsersDtlsCacheModel.email = null;
		}

		dgfUsersDtlsCacheModel.nidPhotoAttchId = getNidPhotoAttchId();

		dgfUsersDtlsCacheModel.nidDivision = getNidDivision();

		String nidDivision = dgfUsersDtlsCacheModel.nidDivision;

		if ((nidDivision != null) && (nidDivision.length() == 0)) {
			dgfUsersDtlsCacheModel.nidDivision = null;
		}

		dgfUsersDtlsCacheModel.nidDistrict = getNidDistrict();

		String nidDistrict = dgfUsersDtlsCacheModel.nidDistrict;

		if ((nidDistrict != null) && (nidDistrict.length() == 0)) {
			dgfUsersDtlsCacheModel.nidDistrict = null;
		}

		dgfUsersDtlsCacheModel.nidUpzilla = getNidUpzilla();

		String nidUpzilla = dgfUsersDtlsCacheModel.nidUpzilla;

		if ((nidUpzilla != null) && (nidUpzilla.length() == 0)) {
			dgfUsersDtlsCacheModel.nidUpzilla = null;
		}

		dgfUsersDtlsCacheModel.nidUnion = getNidUnion();

		String nidUnion = dgfUsersDtlsCacheModel.nidUnion;

		if ((nidUnion != null) && (nidUnion.length() == 0)) {
			dgfUsersDtlsCacheModel.nidUnion = null;
		}

		dgfUsersDtlsCacheModel.nidVillage = getNidVillage();

		String nidVillage = dgfUsersDtlsCacheModel.nidVillage;

		if ((nidVillage != null) && (nidVillage.length() == 0)) {
			dgfUsersDtlsCacheModel.nidVillage = null;
		}

		dgfUsersDtlsCacheModel.nidWard = getNidWard();

		String nidWard = dgfUsersDtlsCacheModel.nidWard;

		if ((nidWard != null) && (nidWard.length() == 0)) {
			dgfUsersDtlsCacheModel.nidWard = null;
		}

		dgfUsersDtlsCacheModel.nidZipCode = getNidZipCode();

		String nidZipCode = dgfUsersDtlsCacheModel.nidZipCode;

		if ((nidZipCode != null) && (nidZipCode.length() == 0)) {
			dgfUsersDtlsCacheModel.nidZipCode = null;
		}

		dgfUsersDtlsCacheModel.nidHouseAddress = getNidHouseAddress();

		String nidHouseAddress = dgfUsersDtlsCacheModel.nidHouseAddress;

		if ((nidHouseAddress != null) && (nidHouseAddress.length() == 0)) {
			dgfUsersDtlsCacheModel.nidHouseAddress = null;
		}

		Date lastUpdatedDate = getLastUpdatedDate();

		if (lastUpdatedDate != null) {
			dgfUsersDtlsCacheModel.lastUpdatedDate = lastUpdatedDate.getTime();
		}
		else {
			dgfUsersDtlsCacheModel.lastUpdatedDate = Long.MIN_VALUE;
		}

		dgfUsersDtlsCacheModel.nidPostOffice = getNidPostOffice();

		String nidPostOffice = dgfUsersDtlsCacheModel.nidPostOffice;

		if ((nidPostOffice != null) && (nidPostOffice.length() == 0)) {
			dgfUsersDtlsCacheModel.nidPostOffice = null;
		}

		return dgfUsersDtlsCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DgfUsersDtls, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DgfUsersDtls, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DgfUsersDtls, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((DgfUsersDtls)this);

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

		private static final Function<InvocationHandler, DgfUsersDtls>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					DgfUsersDtls.class, ModelWrapper.class);

	}

	private long _userDetailsId;
	private long _nationalId;
	private String _email;
	private long _nidPhotoAttchId;
	private String _nidDivision;
	private String _nidDistrict;
	private String _nidUpzilla;
	private String _nidUnion;
	private String _nidVillage;
	private String _nidWard;
	private String _nidZipCode;
	private String _nidHouseAddress;
	private Date _lastUpdatedDate;
	private String _nidPostOffice;

	public <T> T getColumnValue(String columnName) {
		Function<DgfUsersDtls, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((DgfUsersDtls)this);
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

		_columnOriginalValues.put("userDetailsId", _userDetailsId);
		_columnOriginalValues.put("nationalId", _nationalId);
		_columnOriginalValues.put("email", _email);
		_columnOriginalValues.put("nidPhotoAttchId", _nidPhotoAttchId);
		_columnOriginalValues.put("nidDivision", _nidDivision);
		_columnOriginalValues.put("nidDistrict", _nidDistrict);
		_columnOriginalValues.put("nidUpzilla", _nidUpzilla);
		_columnOriginalValues.put("nidUnion", _nidUnion);
		_columnOriginalValues.put("nidVillage", _nidVillage);
		_columnOriginalValues.put("nidWard", _nidWard);
		_columnOriginalValues.put("nidZipCode", _nidZipCode);
		_columnOriginalValues.put("nidHouseAddress", _nidHouseAddress);
		_columnOriginalValues.put("lastUpdatedDate", _lastUpdatedDate);
		_columnOriginalValues.put("nidPostOffice", _nidPostOffice);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("userDetailsId", 1L);

		columnBitmasks.put("nationalId", 2L);

		columnBitmasks.put("email", 4L);

		columnBitmasks.put("nidPhotoAttchId", 8L);

		columnBitmasks.put("nidDivision", 16L);

		columnBitmasks.put("nidDistrict", 32L);

		columnBitmasks.put("nidUpzilla", 64L);

		columnBitmasks.put("nidUnion", 128L);

		columnBitmasks.put("nidVillage", 256L);

		columnBitmasks.put("nidWard", 512L);

		columnBitmasks.put("nidZipCode", 1024L);

		columnBitmasks.put("nidHouseAddress", 2048L);

		columnBitmasks.put("lastUpdatedDate", 4096L);

		columnBitmasks.put("nidPostOffice", 8192L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private DgfUsersDtls _escapedModel;

}