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

import bd.gov.dgfood.food.grain.license.model.DgfRenewLicense;
import bd.gov.dgfood.food.grain.license.model.DgfRenewLicenseModel;

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
import com.liferay.portal.kernel.workflow.WorkflowConstants;

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
 * The base model implementation for the DgfRenewLicense service. Represents a row in the &quot;dgf_renew_license&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DgfRenewLicenseModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DgfRenewLicenseImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfRenewLicenseImpl
 * @generated
 */
@JSON(strict = true)
public class DgfRenewLicenseModelImpl
	extends BaseModelImpl<DgfRenewLicense> implements DgfRenewLicenseModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dgf renew license model instance should use the <code>DgfRenewLicense</code> interface instead.
	 */
	public static final String TABLE_NAME = "dgf_renew_license";

	public static final Object[][] TABLE_COLUMNS = {
		{"renewLicenseId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"nationalId", Types.VARCHAR}, {"licenseNo", Types.VARCHAR},
		{"licenseExpiryDate", Types.TIMESTAMP},
		{"tradeLicenseNo", Types.VARCHAR},
		{"tradeLicenseExpiryDate", Types.TIMESTAMP},
		{"tradeLicAttchId", Types.BIGINT}, {"paymentAttchId", Types.BIGINT},
		{"applicationNo", Types.VARCHAR},
		{"licenseApplicationType", Types.VARCHAR}, {"comments", Types.VARCHAR},
		{"createdDate", Types.TIMESTAMP}, {"modifiedBy", Types.BIGINT},
		{"modifiedDate", Types.TIMESTAMP}, {"fglPrePrimaryId", Types.BIGINT},
		{"status", Types.INTEGER}, {"statusByUserId", Types.BIGINT},
		{"statusByUserName", Types.VARCHAR}, {"statusDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("renewLicenseId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("nationalId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("licenseNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("licenseExpiryDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("tradeLicenseNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("tradeLicenseExpiryDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("tradeLicAttchId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("paymentAttchId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("applicationNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("licenseApplicationType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("comments", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createdDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedBy", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("fglPrePrimaryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table dgf_renew_license (renewLicenseId LONG not null primary key,userId LONG,nationalId VARCHAR(75) null,licenseNo VARCHAR(75) null,licenseExpiryDate DATE null,tradeLicenseNo VARCHAR(75) null,tradeLicenseExpiryDate DATE null,tradeLicAttchId LONG,paymentAttchId LONG,applicationNo VARCHAR(75) null,licenseApplicationType VARCHAR(75) null,comments STRING null,createdDate DATE null,modifiedBy LONG,modifiedDate DATE null,fglPrePrimaryId LONG,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table dgf_renew_license";

	public static final String ORDER_BY_JPQL =
		" ORDER BY dgfRenewLicense.renewLicenseId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY dgf_renew_license.renewLicenseId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long APPLICATIONNO_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long FGLPREPRIMARYID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long LICENSENO_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long NATIONALID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PAYMENTATTCHID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TRADELICATTCHID_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long USERID_COLUMN_BITMASK = 64L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long RENEWLICENSEID_COLUMN_BITMASK = 128L;

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

	public DgfRenewLicenseModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _renewLicenseId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRenewLicenseId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _renewLicenseId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DgfRenewLicense.class;
	}

	@Override
	public String getModelClassName() {
		return DgfRenewLicense.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DgfRenewLicense, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DgfRenewLicense, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DgfRenewLicense, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((DgfRenewLicense)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DgfRenewLicense, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DgfRenewLicense, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DgfRenewLicense)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DgfRenewLicense, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DgfRenewLicense, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<DgfRenewLicense, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<DgfRenewLicense, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<DgfRenewLicense, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<DgfRenewLicense, Object>>();
		Map<String, BiConsumer<DgfRenewLicense, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<DgfRenewLicense, ?>>();

		attributeGetterFunctions.put(
			"renewLicenseId", DgfRenewLicense::getRenewLicenseId);
		attributeSetterBiConsumers.put(
			"renewLicenseId",
			(BiConsumer<DgfRenewLicense, Long>)
				DgfRenewLicense::setRenewLicenseId);
		attributeGetterFunctions.put("userId", DgfRenewLicense::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<DgfRenewLicense, Long>)DgfRenewLicense::setUserId);
		attributeGetterFunctions.put(
			"nationalId", DgfRenewLicense::getNationalId);
		attributeSetterBiConsumers.put(
			"nationalId",
			(BiConsumer<DgfRenewLicense, String>)
				DgfRenewLicense::setNationalId);
		attributeGetterFunctions.put(
			"licenseNo", DgfRenewLicense::getLicenseNo);
		attributeSetterBiConsumers.put(
			"licenseNo",
			(BiConsumer<DgfRenewLicense, String>)DgfRenewLicense::setLicenseNo);
		attributeGetterFunctions.put(
			"licenseExpiryDate", DgfRenewLicense::getLicenseExpiryDate);
		attributeSetterBiConsumers.put(
			"licenseExpiryDate",
			(BiConsumer<DgfRenewLicense, Date>)
				DgfRenewLicense::setLicenseExpiryDate);
		attributeGetterFunctions.put(
			"tradeLicenseNo", DgfRenewLicense::getTradeLicenseNo);
		attributeSetterBiConsumers.put(
			"tradeLicenseNo",
			(BiConsumer<DgfRenewLicense, String>)
				DgfRenewLicense::setTradeLicenseNo);
		attributeGetterFunctions.put(
			"tradeLicenseExpiryDate",
			DgfRenewLicense::getTradeLicenseExpiryDate);
		attributeSetterBiConsumers.put(
			"tradeLicenseExpiryDate",
			(BiConsumer<DgfRenewLicense, Date>)
				DgfRenewLicense::setTradeLicenseExpiryDate);
		attributeGetterFunctions.put(
			"tradeLicAttchId", DgfRenewLicense::getTradeLicAttchId);
		attributeSetterBiConsumers.put(
			"tradeLicAttchId",
			(BiConsumer<DgfRenewLicense, Long>)
				DgfRenewLicense::setTradeLicAttchId);
		attributeGetterFunctions.put(
			"paymentAttchId", DgfRenewLicense::getPaymentAttchId);
		attributeSetterBiConsumers.put(
			"paymentAttchId",
			(BiConsumer<DgfRenewLicense, Long>)
				DgfRenewLicense::setPaymentAttchId);
		attributeGetterFunctions.put(
			"applicationNo", DgfRenewLicense::getApplicationNo);
		attributeSetterBiConsumers.put(
			"applicationNo",
			(BiConsumer<DgfRenewLicense, String>)
				DgfRenewLicense::setApplicationNo);
		attributeGetterFunctions.put(
			"licenseApplicationType",
			DgfRenewLicense::getLicenseApplicationType);
		attributeSetterBiConsumers.put(
			"licenseApplicationType",
			(BiConsumer<DgfRenewLicense, String>)
				DgfRenewLicense::setLicenseApplicationType);
		attributeGetterFunctions.put("comments", DgfRenewLicense::getComments);
		attributeSetterBiConsumers.put(
			"comments",
			(BiConsumer<DgfRenewLicense, String>)DgfRenewLicense::setComments);
		attributeGetterFunctions.put(
			"createdDate", DgfRenewLicense::getCreatedDate);
		attributeSetterBiConsumers.put(
			"createdDate",
			(BiConsumer<DgfRenewLicense, Date>)DgfRenewLicense::setCreatedDate);
		attributeGetterFunctions.put(
			"modifiedBy", DgfRenewLicense::getModifiedBy);
		attributeSetterBiConsumers.put(
			"modifiedBy",
			(BiConsumer<DgfRenewLicense, Long>)DgfRenewLicense::setModifiedBy);
		attributeGetterFunctions.put(
			"modifiedDate", DgfRenewLicense::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<DgfRenewLicense, Date>)
				DgfRenewLicense::setModifiedDate);
		attributeGetterFunctions.put(
			"fglPrePrimaryId", DgfRenewLicense::getFglPrePrimaryId);
		attributeSetterBiConsumers.put(
			"fglPrePrimaryId",
			(BiConsumer<DgfRenewLicense, Long>)
				DgfRenewLicense::setFglPrePrimaryId);
		attributeGetterFunctions.put("status", DgfRenewLicense::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<DgfRenewLicense, Integer>)DgfRenewLicense::setStatus);
		attributeGetterFunctions.put(
			"statusByUserId", DgfRenewLicense::getStatusByUserId);
		attributeSetterBiConsumers.put(
			"statusByUserId",
			(BiConsumer<DgfRenewLicense, Long>)
				DgfRenewLicense::setStatusByUserId);
		attributeGetterFunctions.put(
			"statusByUserName", DgfRenewLicense::getStatusByUserName);
		attributeSetterBiConsumers.put(
			"statusByUserName",
			(BiConsumer<DgfRenewLicense, String>)
				DgfRenewLicense::setStatusByUserName);
		attributeGetterFunctions.put(
			"statusDate", DgfRenewLicense::getStatusDate);
		attributeSetterBiConsumers.put(
			"statusDate",
			(BiConsumer<DgfRenewLicense, Date>)DgfRenewLicense::setStatusDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getRenewLicenseId() {
		return _renewLicenseId;
	}

	@Override
	public void setRenewLicenseId(long renewLicenseId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_renewLicenseId = renewLicenseId;
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

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalLicenseNo() {
		return getColumnOriginalValue("licenseNo");
	}

	@JSON
	@Override
	public Date getLicenseExpiryDate() {
		return _licenseExpiryDate;
	}

	@Override
	public void setLicenseExpiryDate(Date licenseExpiryDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_licenseExpiryDate = licenseExpiryDate;
	}

	@JSON
	@Override
	public String getTradeLicenseNo() {
		if (_tradeLicenseNo == null) {
			return "";
		}
		else {
			return _tradeLicenseNo;
		}
	}

	@Override
	public void setTradeLicenseNo(String tradeLicenseNo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_tradeLicenseNo = tradeLicenseNo;
	}

	@JSON
	@Override
	public Date getTradeLicenseExpiryDate() {
		return _tradeLicenseExpiryDate;
	}

	@Override
	public void setTradeLicenseExpiryDate(Date tradeLicenseExpiryDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_tradeLicenseExpiryDate = tradeLicenseExpiryDate;
	}

	@JSON
	@Override
	public long getTradeLicAttchId() {
		return _tradeLicAttchId;
	}

	@Override
	public void setTradeLicAttchId(long tradeLicAttchId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_tradeLicAttchId = tradeLicAttchId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalTradeLicAttchId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("tradeLicAttchId"));
	}

	@JSON
	@Override
	public long getPaymentAttchId() {
		return _paymentAttchId;
	}

	@Override
	public void setPaymentAttchId(long paymentAttchId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_paymentAttchId = paymentAttchId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalPaymentAttchId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("paymentAttchId"));
	}

	@JSON
	@Override
	public String getApplicationNo() {
		if (_applicationNo == null) {
			return "";
		}
		else {
			return _applicationNo;
		}
	}

	@Override
	public void setApplicationNo(String applicationNo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_applicationNo = applicationNo;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalApplicationNo() {
		return getColumnOriginalValue("applicationNo");
	}

	@JSON
	@Override
	public String getLicenseApplicationType() {
		if (_licenseApplicationType == null) {
			return "";
		}
		else {
			return _licenseApplicationType;
		}
	}

	@Override
	public void setLicenseApplicationType(String licenseApplicationType) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_licenseApplicationType = licenseApplicationType;
	}

	@JSON
	@Override
	public String getComments() {
		if (_comments == null) {
			return "";
		}
		else {
			return _comments;
		}
	}

	@Override
	public void setComments(String comments) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_comments = comments;
	}

	@JSON
	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createdDate = createdDate;
	}

	@JSON
	@Override
	public long getModifiedBy() {
		return _modifiedBy;
	}

	@Override
	public void setModifiedBy(long modifiedBy) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedBy = modifiedBy;
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

	@JSON
	@Override
	public long getFglPrePrimaryId() {
		return _fglPrePrimaryId;
	}

	@Override
	public void setFglPrePrimaryId(long fglPrePrimaryId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fglPrePrimaryId = fglPrePrimaryId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalFglPrePrimaryId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("fglPrePrimaryId"));
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_status = status;
	}

	@JSON
	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@JSON
	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return "";
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statusByUserName = statusByUserName;
	}

	@JSON
	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statusDate = statusDate;
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
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
			0, DgfRenewLicense.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DgfRenewLicense toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, DgfRenewLicense>
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
		DgfRenewLicenseImpl dgfRenewLicenseImpl = new DgfRenewLicenseImpl();

		dgfRenewLicenseImpl.setRenewLicenseId(getRenewLicenseId());
		dgfRenewLicenseImpl.setUserId(getUserId());
		dgfRenewLicenseImpl.setNationalId(getNationalId());
		dgfRenewLicenseImpl.setLicenseNo(getLicenseNo());
		dgfRenewLicenseImpl.setLicenseExpiryDate(getLicenseExpiryDate());
		dgfRenewLicenseImpl.setTradeLicenseNo(getTradeLicenseNo());
		dgfRenewLicenseImpl.setTradeLicenseExpiryDate(
			getTradeLicenseExpiryDate());
		dgfRenewLicenseImpl.setTradeLicAttchId(getTradeLicAttchId());
		dgfRenewLicenseImpl.setPaymentAttchId(getPaymentAttchId());
		dgfRenewLicenseImpl.setApplicationNo(getApplicationNo());
		dgfRenewLicenseImpl.setLicenseApplicationType(
			getLicenseApplicationType());
		dgfRenewLicenseImpl.setComments(getComments());
		dgfRenewLicenseImpl.setCreatedDate(getCreatedDate());
		dgfRenewLicenseImpl.setModifiedBy(getModifiedBy());
		dgfRenewLicenseImpl.setModifiedDate(getModifiedDate());
		dgfRenewLicenseImpl.setFglPrePrimaryId(getFglPrePrimaryId());
		dgfRenewLicenseImpl.setStatus(getStatus());
		dgfRenewLicenseImpl.setStatusByUserId(getStatusByUserId());
		dgfRenewLicenseImpl.setStatusByUserName(getStatusByUserName());
		dgfRenewLicenseImpl.setStatusDate(getStatusDate());

		dgfRenewLicenseImpl.resetOriginalValues();

		return dgfRenewLicenseImpl;
	}

	@Override
	public DgfRenewLicense cloneWithOriginalValues() {
		DgfRenewLicenseImpl dgfRenewLicenseImpl = new DgfRenewLicenseImpl();

		dgfRenewLicenseImpl.setRenewLicenseId(
			this.<Long>getColumnOriginalValue("renewLicenseId"));
		dgfRenewLicenseImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		dgfRenewLicenseImpl.setNationalId(
			this.<String>getColumnOriginalValue("nationalId"));
		dgfRenewLicenseImpl.setLicenseNo(
			this.<String>getColumnOriginalValue("licenseNo"));
		dgfRenewLicenseImpl.setLicenseExpiryDate(
			this.<Date>getColumnOriginalValue("licenseExpiryDate"));
		dgfRenewLicenseImpl.setTradeLicenseNo(
			this.<String>getColumnOriginalValue("tradeLicenseNo"));
		dgfRenewLicenseImpl.setTradeLicenseExpiryDate(
			this.<Date>getColumnOriginalValue("tradeLicenseExpiryDate"));
		dgfRenewLicenseImpl.setTradeLicAttchId(
			this.<Long>getColumnOriginalValue("tradeLicAttchId"));
		dgfRenewLicenseImpl.setPaymentAttchId(
			this.<Long>getColumnOriginalValue("paymentAttchId"));
		dgfRenewLicenseImpl.setApplicationNo(
			this.<String>getColumnOriginalValue("applicationNo"));
		dgfRenewLicenseImpl.setLicenseApplicationType(
			this.<String>getColumnOriginalValue("licenseApplicationType"));
		dgfRenewLicenseImpl.setComments(
			this.<String>getColumnOriginalValue("comments"));
		dgfRenewLicenseImpl.setCreatedDate(
			this.<Date>getColumnOriginalValue("createdDate"));
		dgfRenewLicenseImpl.setModifiedBy(
			this.<Long>getColumnOriginalValue("modifiedBy"));
		dgfRenewLicenseImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		dgfRenewLicenseImpl.setFglPrePrimaryId(
			this.<Long>getColumnOriginalValue("fglPrePrimaryId"));
		dgfRenewLicenseImpl.setStatus(
			this.<Integer>getColumnOriginalValue("status"));
		dgfRenewLicenseImpl.setStatusByUserId(
			this.<Long>getColumnOriginalValue("statusByUserId"));
		dgfRenewLicenseImpl.setStatusByUserName(
			this.<String>getColumnOriginalValue("statusByUserName"));
		dgfRenewLicenseImpl.setStatusDate(
			this.<Date>getColumnOriginalValue("statusDate"));

		return dgfRenewLicenseImpl;
	}

	@Override
	public int compareTo(DgfRenewLicense dgfRenewLicense) {
		long primaryKey = dgfRenewLicense.getPrimaryKey();

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

		if (!(object instanceof DgfRenewLicense)) {
			return false;
		}

		DgfRenewLicense dgfRenewLicense = (DgfRenewLicense)object;

		long primaryKey = dgfRenewLicense.getPrimaryKey();

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
	public CacheModel<DgfRenewLicense> toCacheModel() {
		DgfRenewLicenseCacheModel dgfRenewLicenseCacheModel =
			new DgfRenewLicenseCacheModel();

		dgfRenewLicenseCacheModel.renewLicenseId = getRenewLicenseId();

		dgfRenewLicenseCacheModel.userId = getUserId();

		dgfRenewLicenseCacheModel.nationalId = getNationalId();

		String nationalId = dgfRenewLicenseCacheModel.nationalId;

		if ((nationalId != null) && (nationalId.length() == 0)) {
			dgfRenewLicenseCacheModel.nationalId = null;
		}

		dgfRenewLicenseCacheModel.licenseNo = getLicenseNo();

		String licenseNo = dgfRenewLicenseCacheModel.licenseNo;

		if ((licenseNo != null) && (licenseNo.length() == 0)) {
			dgfRenewLicenseCacheModel.licenseNo = null;
		}

		Date licenseExpiryDate = getLicenseExpiryDate();

		if (licenseExpiryDate != null) {
			dgfRenewLicenseCacheModel.licenseExpiryDate =
				licenseExpiryDate.getTime();
		}
		else {
			dgfRenewLicenseCacheModel.licenseExpiryDate = Long.MIN_VALUE;
		}

		dgfRenewLicenseCacheModel.tradeLicenseNo = getTradeLicenseNo();

		String tradeLicenseNo = dgfRenewLicenseCacheModel.tradeLicenseNo;

		if ((tradeLicenseNo != null) && (tradeLicenseNo.length() == 0)) {
			dgfRenewLicenseCacheModel.tradeLicenseNo = null;
		}

		Date tradeLicenseExpiryDate = getTradeLicenseExpiryDate();

		if (tradeLicenseExpiryDate != null) {
			dgfRenewLicenseCacheModel.tradeLicenseExpiryDate =
				tradeLicenseExpiryDate.getTime();
		}
		else {
			dgfRenewLicenseCacheModel.tradeLicenseExpiryDate = Long.MIN_VALUE;
		}

		dgfRenewLicenseCacheModel.tradeLicAttchId = getTradeLicAttchId();

		dgfRenewLicenseCacheModel.paymentAttchId = getPaymentAttchId();

		dgfRenewLicenseCacheModel.applicationNo = getApplicationNo();

		String applicationNo = dgfRenewLicenseCacheModel.applicationNo;

		if ((applicationNo != null) && (applicationNo.length() == 0)) {
			dgfRenewLicenseCacheModel.applicationNo = null;
		}

		dgfRenewLicenseCacheModel.licenseApplicationType =
			getLicenseApplicationType();

		String licenseApplicationType =
			dgfRenewLicenseCacheModel.licenseApplicationType;

		if ((licenseApplicationType != null) &&
			(licenseApplicationType.length() == 0)) {

			dgfRenewLicenseCacheModel.licenseApplicationType = null;
		}

		dgfRenewLicenseCacheModel.comments = getComments();

		String comments = dgfRenewLicenseCacheModel.comments;

		if ((comments != null) && (comments.length() == 0)) {
			dgfRenewLicenseCacheModel.comments = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			dgfRenewLicenseCacheModel.createdDate = createdDate.getTime();
		}
		else {
			dgfRenewLicenseCacheModel.createdDate = Long.MIN_VALUE;
		}

		dgfRenewLicenseCacheModel.modifiedBy = getModifiedBy();

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dgfRenewLicenseCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			dgfRenewLicenseCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		dgfRenewLicenseCacheModel.fglPrePrimaryId = getFglPrePrimaryId();

		dgfRenewLicenseCacheModel.status = getStatus();

		dgfRenewLicenseCacheModel.statusByUserId = getStatusByUserId();

		dgfRenewLicenseCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = dgfRenewLicenseCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			dgfRenewLicenseCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			dgfRenewLicenseCacheModel.statusDate = statusDate.getTime();
		}
		else {
			dgfRenewLicenseCacheModel.statusDate = Long.MIN_VALUE;
		}

		return dgfRenewLicenseCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DgfRenewLicense, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DgfRenewLicense, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DgfRenewLicense, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((DgfRenewLicense)this);

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

		private static final Function<InvocationHandler, DgfRenewLicense>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					DgfRenewLicense.class, ModelWrapper.class);

	}

	private long _renewLicenseId;
	private long _userId;
	private String _nationalId;
	private String _licenseNo;
	private Date _licenseExpiryDate;
	private String _tradeLicenseNo;
	private Date _tradeLicenseExpiryDate;
	private long _tradeLicAttchId;
	private long _paymentAttchId;
	private String _applicationNo;
	private String _licenseApplicationType;
	private String _comments;
	private Date _createdDate;
	private long _modifiedBy;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _fglPrePrimaryId;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;

	public <T> T getColumnValue(String columnName) {
		Function<DgfRenewLicense, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((DgfRenewLicense)this);
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

		_columnOriginalValues.put("renewLicenseId", _renewLicenseId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("nationalId", _nationalId);
		_columnOriginalValues.put("licenseNo", _licenseNo);
		_columnOriginalValues.put("licenseExpiryDate", _licenseExpiryDate);
		_columnOriginalValues.put("tradeLicenseNo", _tradeLicenseNo);
		_columnOriginalValues.put(
			"tradeLicenseExpiryDate", _tradeLicenseExpiryDate);
		_columnOriginalValues.put("tradeLicAttchId", _tradeLicAttchId);
		_columnOriginalValues.put("paymentAttchId", _paymentAttchId);
		_columnOriginalValues.put("applicationNo", _applicationNo);
		_columnOriginalValues.put(
			"licenseApplicationType", _licenseApplicationType);
		_columnOriginalValues.put("comments", _comments);
		_columnOriginalValues.put("createdDate", _createdDate);
		_columnOriginalValues.put("modifiedBy", _modifiedBy);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("fglPrePrimaryId", _fglPrePrimaryId);
		_columnOriginalValues.put("status", _status);
		_columnOriginalValues.put("statusByUserId", _statusByUserId);
		_columnOriginalValues.put("statusByUserName", _statusByUserName);
		_columnOriginalValues.put("statusDate", _statusDate);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("renewLicenseId", 1L);

		columnBitmasks.put("userId", 2L);

		columnBitmasks.put("nationalId", 4L);

		columnBitmasks.put("licenseNo", 8L);

		columnBitmasks.put("licenseExpiryDate", 16L);

		columnBitmasks.put("tradeLicenseNo", 32L);

		columnBitmasks.put("tradeLicenseExpiryDate", 64L);

		columnBitmasks.put("tradeLicAttchId", 128L);

		columnBitmasks.put("paymentAttchId", 256L);

		columnBitmasks.put("applicationNo", 512L);

		columnBitmasks.put("licenseApplicationType", 1024L);

		columnBitmasks.put("comments", 2048L);

		columnBitmasks.put("createdDate", 4096L);

		columnBitmasks.put("modifiedBy", 8192L);

		columnBitmasks.put("modifiedDate", 16384L);

		columnBitmasks.put("fglPrePrimaryId", 32768L);

		columnBitmasks.put("status", 65536L);

		columnBitmasks.put("statusByUserId", 131072L);

		columnBitmasks.put("statusByUserName", 262144L);

		columnBitmasks.put("statusDate", 524288L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private DgfRenewLicense _escapedModel;

}