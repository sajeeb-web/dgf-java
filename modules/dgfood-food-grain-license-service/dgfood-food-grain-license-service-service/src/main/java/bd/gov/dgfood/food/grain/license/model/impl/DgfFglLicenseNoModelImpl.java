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

import bd.gov.dgfood.food.grain.license.model.DgfFglLicenseNo;
import bd.gov.dgfood.food.grain.license.model.DgfFglLicenseNoModel;

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
 * The base model implementation for the DgfFglLicenseNo service. Represents a row in the &quot;dgf_fgl_license_no&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DgfFglLicenseNoModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DgfFglLicenseNoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfFglLicenseNoImpl
 * @generated
 */
@JSON(strict = true)
public class DgfFglLicenseNoModelImpl
	extends BaseModelImpl<DgfFglLicenseNo> implements DgfFglLicenseNoModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dgf fgl license no model instance should use the <code>DgfFglLicenseNo</code> interface instead.
	 */
	public static final String TABLE_NAME = "dgf_fgl_license_no";

	public static final Object[][] TABLE_COLUMNS = {
		{"id", Types.BIGINT}, {"suffix", Types.BIGINT},
		{"prefix", Types.BIGINT}, {"serial_no", Types.BIGINT},
		{"license_no", Types.VARCHAR}, {"created_at", Types.TIMESTAMP},
		{"updated_at", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("suffix", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("prefix", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("serial_no", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("license_no", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("created_at", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("updated_at", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table dgf_fgl_license_no (id LONG not null primary key,suffix LONG,prefix LONG,serial_no LONG,license_no VARCHAR(75) null,created_at DATE null,updated_at DATE null)";

	public static final String TABLE_SQL_DROP = "drop table dgf_fgl_license_no";

	public static final String ORDER_BY_JPQL =
		" ORDER BY dgfFglLicenseNo.id ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY dgf_fgl_license_no.id ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long SERIALNO_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ID_COLUMN_BITMASK = 2L;

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

	public DgfFglLicenseNoModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DgfFglLicenseNo.class;
	}

	@Override
	public String getModelClassName() {
		return DgfFglLicenseNo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DgfFglLicenseNo, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DgfFglLicenseNo, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DgfFglLicenseNo, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((DgfFglLicenseNo)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DgfFglLicenseNo, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DgfFglLicenseNo, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DgfFglLicenseNo)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DgfFglLicenseNo, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DgfFglLicenseNo, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<DgfFglLicenseNo, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<DgfFglLicenseNo, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<DgfFglLicenseNo, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<DgfFglLicenseNo, Object>>();
		Map<String, BiConsumer<DgfFglLicenseNo, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<DgfFglLicenseNo, ?>>();

		attributeGetterFunctions.put("id", DgfFglLicenseNo::getId);
		attributeSetterBiConsumers.put(
			"id", (BiConsumer<DgfFglLicenseNo, Long>)DgfFglLicenseNo::setId);
		attributeGetterFunctions.put("suffix", DgfFglLicenseNo::getSuffix);
		attributeSetterBiConsumers.put(
			"suffix",
			(BiConsumer<DgfFglLicenseNo, Long>)DgfFglLicenseNo::setSuffix);
		attributeGetterFunctions.put("prefix", DgfFglLicenseNo::getPrefix);
		attributeSetterBiConsumers.put(
			"prefix",
			(BiConsumer<DgfFglLicenseNo, Long>)DgfFglLicenseNo::setPrefix);
		attributeGetterFunctions.put("serialNo", DgfFglLicenseNo::getSerialNo);
		attributeSetterBiConsumers.put(
			"serialNo",
			(BiConsumer<DgfFglLicenseNo, Long>)DgfFglLicenseNo::setSerialNo);
		attributeGetterFunctions.put(
			"licenseNo", DgfFglLicenseNo::getLicenseNo);
		attributeSetterBiConsumers.put(
			"licenseNo",
			(BiConsumer<DgfFglLicenseNo, String>)DgfFglLicenseNo::setLicenseNo);
		attributeGetterFunctions.put(
			"createdAt", DgfFglLicenseNo::getCreatedAt);
		attributeSetterBiConsumers.put(
			"createdAt",
			(BiConsumer<DgfFglLicenseNo, Date>)DgfFglLicenseNo::setCreatedAt);
		attributeGetterFunctions.put(
			"updatedAt", DgfFglLicenseNo::getUpdatedAt);
		attributeSetterBiConsumers.put(
			"updatedAt",
			(BiConsumer<DgfFglLicenseNo, Date>)DgfFglLicenseNo::setUpdatedAt);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_id = id;
	}

	@JSON
	@Override
	public long getSuffix() {
		return _suffix;
	}

	@Override
	public void setSuffix(long suffix) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_suffix = suffix;
	}

	@JSON
	@Override
	public long getPrefix() {
		return _prefix;
	}

	@Override
	public void setPrefix(long prefix) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_prefix = prefix;
	}

	@JSON
	@Override
	public long getSerialNo() {
		return _serialNo;
	}

	@Override
	public void setSerialNo(long serialNo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_serialNo = serialNo;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalSerialNo() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("serial_no"));
	}

	@JSON
	@Override
	public String getLicenseNo() {
		if (_licenseNo == null) {
			return "";
		}
		else {
			return _licenseNo;
		}
	}

	@Override
	public void setLicenseNo(String licenseNo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_licenseNo = licenseNo;
	}

	@JSON
	@Override
	public Date getCreatedAt() {
		return _createdAt;
	}

	@Override
	public void setCreatedAt(Date createdAt) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createdAt = createdAt;
	}

	@JSON
	@Override
	public Date getUpdatedAt() {
		return _updatedAt;
	}

	@Override
	public void setUpdatedAt(Date updatedAt) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_updatedAt = updatedAt;
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
			0, DgfFglLicenseNo.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DgfFglLicenseNo toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, DgfFglLicenseNo>
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
		DgfFglLicenseNoImpl dgfFglLicenseNoImpl = new DgfFglLicenseNoImpl();

		dgfFglLicenseNoImpl.setId(getId());
		dgfFglLicenseNoImpl.setSuffix(getSuffix());
		dgfFglLicenseNoImpl.setPrefix(getPrefix());
		dgfFglLicenseNoImpl.setSerialNo(getSerialNo());
		dgfFglLicenseNoImpl.setLicenseNo(getLicenseNo());
		dgfFglLicenseNoImpl.setCreatedAt(getCreatedAt());
		dgfFglLicenseNoImpl.setUpdatedAt(getUpdatedAt());

		dgfFglLicenseNoImpl.resetOriginalValues();

		return dgfFglLicenseNoImpl;
	}

	@Override
	public DgfFglLicenseNo cloneWithOriginalValues() {
		DgfFglLicenseNoImpl dgfFglLicenseNoImpl = new DgfFglLicenseNoImpl();

		dgfFglLicenseNoImpl.setId(this.<Long>getColumnOriginalValue("id"));
		dgfFglLicenseNoImpl.setSuffix(
			this.<Long>getColumnOriginalValue("suffix"));
		dgfFglLicenseNoImpl.setPrefix(
			this.<Long>getColumnOriginalValue("prefix"));
		dgfFglLicenseNoImpl.setSerialNo(
			this.<Long>getColumnOriginalValue("serial_no"));
		dgfFglLicenseNoImpl.setLicenseNo(
			this.<String>getColumnOriginalValue("license_no"));
		dgfFglLicenseNoImpl.setCreatedAt(
			this.<Date>getColumnOriginalValue("created_at"));
		dgfFglLicenseNoImpl.setUpdatedAt(
			this.<Date>getColumnOriginalValue("updated_at"));

		return dgfFglLicenseNoImpl;
	}

	@Override
	public int compareTo(DgfFglLicenseNo dgfFglLicenseNo) {
		long primaryKey = dgfFglLicenseNo.getPrimaryKey();

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

		if (!(object instanceof DgfFglLicenseNo)) {
			return false;
		}

		DgfFglLicenseNo dgfFglLicenseNo = (DgfFglLicenseNo)object;

		long primaryKey = dgfFglLicenseNo.getPrimaryKey();

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
	public CacheModel<DgfFglLicenseNo> toCacheModel() {
		DgfFglLicenseNoCacheModel dgfFglLicenseNoCacheModel =
			new DgfFglLicenseNoCacheModel();

		dgfFglLicenseNoCacheModel.id = getId();

		dgfFglLicenseNoCacheModel.suffix = getSuffix();

		dgfFglLicenseNoCacheModel.prefix = getPrefix();

		dgfFglLicenseNoCacheModel.serialNo = getSerialNo();

		dgfFglLicenseNoCacheModel.licenseNo = getLicenseNo();

		String licenseNo = dgfFglLicenseNoCacheModel.licenseNo;

		if ((licenseNo != null) && (licenseNo.length() == 0)) {
			dgfFglLicenseNoCacheModel.licenseNo = null;
		}

		Date createdAt = getCreatedAt();

		if (createdAt != null) {
			dgfFglLicenseNoCacheModel.createdAt = createdAt.getTime();
		}
		else {
			dgfFglLicenseNoCacheModel.createdAt = Long.MIN_VALUE;
		}

		Date updatedAt = getUpdatedAt();

		if (updatedAt != null) {
			dgfFglLicenseNoCacheModel.updatedAt = updatedAt.getTime();
		}
		else {
			dgfFglLicenseNoCacheModel.updatedAt = Long.MIN_VALUE;
		}

		return dgfFglLicenseNoCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DgfFglLicenseNo, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DgfFglLicenseNo, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DgfFglLicenseNo, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((DgfFglLicenseNo)this);

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

		private static final Function<InvocationHandler, DgfFglLicenseNo>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					DgfFglLicenseNo.class, ModelWrapper.class);

	}

	private long _id;
	private long _suffix;
	private long _prefix;
	private long _serialNo;
	private String _licenseNo;
	private Date _createdAt;
	private Date _updatedAt;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<DgfFglLicenseNo, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((DgfFglLicenseNo)this);
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

		_columnOriginalValues.put("id", _id);
		_columnOriginalValues.put("suffix", _suffix);
		_columnOriginalValues.put("prefix", _prefix);
		_columnOriginalValues.put("serial_no", _serialNo);
		_columnOriginalValues.put("license_no", _licenseNo);
		_columnOriginalValues.put("created_at", _createdAt);
		_columnOriginalValues.put("updated_at", _updatedAt);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("serial_no", "serialNo");
		attributeNames.put("license_no", "licenseNo");
		attributeNames.put("created_at", "createdAt");
		attributeNames.put("updated_at", "updatedAt");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("id", 1L);

		columnBitmasks.put("suffix", 2L);

		columnBitmasks.put("prefix", 4L);

		columnBitmasks.put("serial_no", 8L);

		columnBitmasks.put("license_no", 16L);

		columnBitmasks.put("created_at", 32L);

		columnBitmasks.put("updated_at", 64L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private DgfFglLicenseNo _escapedModel;

}