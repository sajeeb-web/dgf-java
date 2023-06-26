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

import bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportCForm;
import bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportCFormModel;

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
 * The base model implementation for the DgfUsersFortnightReportCForm service. Represents a row in the &quot;dgf_users_fortnightreport_c&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DgfUsersFortnightReportCFormModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DgfUsersFortnightReportCFormImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersFortnightReportCFormImpl
 * @generated
 */
@JSON(strict = true)
public class DgfUsersFortnightReportCFormModelImpl
	extends BaseModelImpl<DgfUsersFortnightReportCForm>
	implements DgfUsersFortnightReportCFormModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dgf users fortnight report c form model instance should use the <code>DgfUsersFortnightReportCForm</code> interface instead.
	 */
	public static final String TABLE_NAME = "dgf_users_fortnightreport_c";

	public static final Object[][] TABLE_COLUMNS = {
		{"reportId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"usernationalId", Types.VARCHAR}, {"licenseNo", Types.VARCHAR},
		{"screenName", Types.VARCHAR}, {"fullName", Types.VARCHAR},
		{"bussinessType", Types.VARCHAR}, {"startDate", Types.TIMESTAMP},
		{"endDate", Types.TIMESTAMP}, {"product", Types.VARCHAR},
		{"daterecipt", Types.TIMESTAMP}, {"receivedQuantity", Types.INTEGER},
		{"receivedQuantityUnit", Types.VARCHAR},
		{"lastDateApprove", Types.TIMESTAMP}, {"unsoldQuantity", Types.INTEGER},
		{"unsolddunit", Types.VARCHAR}, {"reasonForBeingUnsold", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("reportId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("usernationalId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("licenseNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("screenName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fullName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("bussinessType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("startDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("endDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("product", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("daterecipt", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("receivedQuantity", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("receivedQuantityUnit", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastDateApprove", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("unsoldQuantity", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("unsolddunit", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("reasonForBeingUnsold", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table dgf_users_fortnightreport_c (reportId LONG not null primary key,userId LONG,usernationalId VARCHAR(75) null,licenseNo VARCHAR(75) null,screenName VARCHAR(75) null,fullName VARCHAR(75) null,bussinessType VARCHAR(75) null,startDate DATE null,endDate DATE null,product VARCHAR(75) null,daterecipt DATE null,receivedQuantity INTEGER,receivedQuantityUnit VARCHAR(75) null,lastDateApprove DATE null,unsoldQuantity INTEGER,unsolddunit VARCHAR(75) null,reasonForBeingUnsold VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table dgf_users_fortnightreport_c";

	public static final String ORDER_BY_JPQL =
		" ORDER BY dgfUsersFortnightReportCForm.reportId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY dgf_users_fortnightreport_c.reportId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long LICENSENO_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long SCREENNAME_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long USERNATIONALID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long REPORTID_COLUMN_BITMASK = 8L;

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

	public DgfUsersFortnightReportCFormModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _reportId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setReportId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _reportId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DgfUsersFortnightReportCForm.class;
	}

	@Override
	public String getModelClassName() {
		return DgfUsersFortnightReportCForm.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DgfUsersFortnightReportCForm, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DgfUsersFortnightReportCForm, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DgfUsersFortnightReportCForm, Object>
				attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply(
					(DgfUsersFortnightReportCForm)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DgfUsersFortnightReportCForm, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DgfUsersFortnightReportCForm, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DgfUsersFortnightReportCForm)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DgfUsersFortnightReportCForm, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DgfUsersFortnightReportCForm, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map
		<String, Function<DgfUsersFortnightReportCForm, Object>>
			_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<DgfUsersFortnightReportCForm, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<DgfUsersFortnightReportCForm, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<DgfUsersFortnightReportCForm, Object>>();
		Map<String, BiConsumer<DgfUsersFortnightReportCForm, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<DgfUsersFortnightReportCForm, ?>>();

		attributeGetterFunctions.put(
			"reportId", DgfUsersFortnightReportCForm::getReportId);
		attributeSetterBiConsumers.put(
			"reportId",
			(BiConsumer<DgfUsersFortnightReportCForm, Long>)
				DgfUsersFortnightReportCForm::setReportId);
		attributeGetterFunctions.put(
			"userId", DgfUsersFortnightReportCForm::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<DgfUsersFortnightReportCForm, Long>)
				DgfUsersFortnightReportCForm::setUserId);
		attributeGetterFunctions.put(
			"usernationalId", DgfUsersFortnightReportCForm::getUsernationalId);
		attributeSetterBiConsumers.put(
			"usernationalId",
			(BiConsumer<DgfUsersFortnightReportCForm, String>)
				DgfUsersFortnightReportCForm::setUsernationalId);
		attributeGetterFunctions.put(
			"licenseNo", DgfUsersFortnightReportCForm::getLicenseNo);
		attributeSetterBiConsumers.put(
			"licenseNo",
			(BiConsumer<DgfUsersFortnightReportCForm, String>)
				DgfUsersFortnightReportCForm::setLicenseNo);
		attributeGetterFunctions.put(
			"screenName", DgfUsersFortnightReportCForm::getScreenName);
		attributeSetterBiConsumers.put(
			"screenName",
			(BiConsumer<DgfUsersFortnightReportCForm, String>)
				DgfUsersFortnightReportCForm::setScreenName);
		attributeGetterFunctions.put(
			"fullName", DgfUsersFortnightReportCForm::getFullName);
		attributeSetterBiConsumers.put(
			"fullName",
			(BiConsumer<DgfUsersFortnightReportCForm, String>)
				DgfUsersFortnightReportCForm::setFullName);
		attributeGetterFunctions.put(
			"bussinessType", DgfUsersFortnightReportCForm::getBussinessType);
		attributeSetterBiConsumers.put(
			"bussinessType",
			(BiConsumer<DgfUsersFortnightReportCForm, String>)
				DgfUsersFortnightReportCForm::setBussinessType);
		attributeGetterFunctions.put(
			"startDate", DgfUsersFortnightReportCForm::getStartDate);
		attributeSetterBiConsumers.put(
			"startDate",
			(BiConsumer<DgfUsersFortnightReportCForm, Date>)
				DgfUsersFortnightReportCForm::setStartDate);
		attributeGetterFunctions.put(
			"endDate", DgfUsersFortnightReportCForm::getEndDate);
		attributeSetterBiConsumers.put(
			"endDate",
			(BiConsumer<DgfUsersFortnightReportCForm, Date>)
				DgfUsersFortnightReportCForm::setEndDate);
		attributeGetterFunctions.put(
			"product", DgfUsersFortnightReportCForm::getProduct);
		attributeSetterBiConsumers.put(
			"product",
			(BiConsumer<DgfUsersFortnightReportCForm, String>)
				DgfUsersFortnightReportCForm::setProduct);
		attributeGetterFunctions.put(
			"daterecipt", DgfUsersFortnightReportCForm::getDaterecipt);
		attributeSetterBiConsumers.put(
			"daterecipt",
			(BiConsumer<DgfUsersFortnightReportCForm, Date>)
				DgfUsersFortnightReportCForm::setDaterecipt);
		attributeGetterFunctions.put(
			"receivedQuantity",
			DgfUsersFortnightReportCForm::getReceivedQuantity);
		attributeSetterBiConsumers.put(
			"receivedQuantity",
			(BiConsumer<DgfUsersFortnightReportCForm, Integer>)
				DgfUsersFortnightReportCForm::setReceivedQuantity);
		attributeGetterFunctions.put(
			"receivedQuantityUnit",
			DgfUsersFortnightReportCForm::getReceivedQuantityUnit);
		attributeSetterBiConsumers.put(
			"receivedQuantityUnit",
			(BiConsumer<DgfUsersFortnightReportCForm, String>)
				DgfUsersFortnightReportCForm::setReceivedQuantityUnit);
		attributeGetterFunctions.put(
			"lastDateApprove",
			DgfUsersFortnightReportCForm::getLastDateApprove);
		attributeSetterBiConsumers.put(
			"lastDateApprove",
			(BiConsumer<DgfUsersFortnightReportCForm, Date>)
				DgfUsersFortnightReportCForm::setLastDateApprove);
		attributeGetterFunctions.put(
			"unsoldQuantity", DgfUsersFortnightReportCForm::getUnsoldQuantity);
		attributeSetterBiConsumers.put(
			"unsoldQuantity",
			(BiConsumer<DgfUsersFortnightReportCForm, Integer>)
				DgfUsersFortnightReportCForm::setUnsoldQuantity);
		attributeGetterFunctions.put(
			"unsolddunit", DgfUsersFortnightReportCForm::getUnsolddunit);
		attributeSetterBiConsumers.put(
			"unsolddunit",
			(BiConsumer<DgfUsersFortnightReportCForm, String>)
				DgfUsersFortnightReportCForm::setUnsolddunit);
		attributeGetterFunctions.put(
			"reasonForBeingUnsold",
			DgfUsersFortnightReportCForm::getReasonForBeingUnsold);
		attributeSetterBiConsumers.put(
			"reasonForBeingUnsold",
			(BiConsumer<DgfUsersFortnightReportCForm, String>)
				DgfUsersFortnightReportCForm::setReasonForBeingUnsold);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getReportId() {
		return _reportId;
	}

	@Override
	public void setReportId(long reportId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_reportId = reportId;
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

	@JSON
	@Override
	public String getUsernationalId() {
		if (_usernationalId == null) {
			return "";
		}
		else {
			return _usernationalId;
		}
	}

	@Override
	public void setUsernationalId(String usernationalId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_usernationalId = usernationalId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUsernationalId() {
		return getColumnOriginalValue("usernationalId");
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
	public String getScreenName() {
		if (_screenName == null) {
			return "";
		}
		else {
			return _screenName;
		}
	}

	@Override
	public void setScreenName(String screenName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_screenName = screenName;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalScreenName() {
		return getColumnOriginalValue("screenName");
	}

	@JSON
	@Override
	public String getFullName() {
		if (_fullName == null) {
			return "";
		}
		else {
			return _fullName;
		}
	}

	@Override
	public void setFullName(String fullName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fullName = fullName;
	}

	@JSON
	@Override
	public String getBussinessType() {
		if (_bussinessType == null) {
			return "";
		}
		else {
			return _bussinessType;
		}
	}

	@Override
	public void setBussinessType(String bussinessType) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_bussinessType = bussinessType;
	}

	@JSON
	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_startDate = startDate;
	}

	@JSON
	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_endDate = endDate;
	}

	@JSON
	@Override
	public String getProduct() {
		if (_product == null) {
			return "";
		}
		else {
			return _product;
		}
	}

	@Override
	public void setProduct(String product) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_product = product;
	}

	@JSON
	@Override
	public Date getDaterecipt() {
		return _daterecipt;
	}

	@Override
	public void setDaterecipt(Date daterecipt) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_daterecipt = daterecipt;
	}

	@JSON
	@Override
	public int getReceivedQuantity() {
		return _receivedQuantity;
	}

	@Override
	public void setReceivedQuantity(int receivedQuantity) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_receivedQuantity = receivedQuantity;
	}

	@JSON
	@Override
	public String getReceivedQuantityUnit() {
		if (_receivedQuantityUnit == null) {
			return "";
		}
		else {
			return _receivedQuantityUnit;
		}
	}

	@Override
	public void setReceivedQuantityUnit(String receivedQuantityUnit) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_receivedQuantityUnit = receivedQuantityUnit;
	}

	@JSON
	@Override
	public Date getLastDateApprove() {
		return _lastDateApprove;
	}

	@Override
	public void setLastDateApprove(Date lastDateApprove) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_lastDateApprove = lastDateApprove;
	}

	@JSON
	@Override
	public int getUnsoldQuantity() {
		return _unsoldQuantity;
	}

	@Override
	public void setUnsoldQuantity(int unsoldQuantity) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_unsoldQuantity = unsoldQuantity;
	}

	@JSON
	@Override
	public String getUnsolddunit() {
		if (_unsolddunit == null) {
			return "";
		}
		else {
			return _unsolddunit;
		}
	}

	@Override
	public void setUnsolddunit(String unsolddunit) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_unsolddunit = unsolddunit;
	}

	@JSON
	@Override
	public String getReasonForBeingUnsold() {
		if (_reasonForBeingUnsold == null) {
			return "";
		}
		else {
			return _reasonForBeingUnsold;
		}
	}

	@Override
	public void setReasonForBeingUnsold(String reasonForBeingUnsold) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_reasonForBeingUnsold = reasonForBeingUnsold;
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
			0, DgfUsersFortnightReportCForm.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DgfUsersFortnightReportCForm toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, DgfUsersFortnightReportCForm>
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
		DgfUsersFortnightReportCFormImpl dgfUsersFortnightReportCFormImpl =
			new DgfUsersFortnightReportCFormImpl();

		dgfUsersFortnightReportCFormImpl.setReportId(getReportId());
		dgfUsersFortnightReportCFormImpl.setUserId(getUserId());
		dgfUsersFortnightReportCFormImpl.setUsernationalId(getUsernationalId());
		dgfUsersFortnightReportCFormImpl.setLicenseNo(getLicenseNo());
		dgfUsersFortnightReportCFormImpl.setScreenName(getScreenName());
		dgfUsersFortnightReportCFormImpl.setFullName(getFullName());
		dgfUsersFortnightReportCFormImpl.setBussinessType(getBussinessType());
		dgfUsersFortnightReportCFormImpl.setStartDate(getStartDate());
		dgfUsersFortnightReportCFormImpl.setEndDate(getEndDate());
		dgfUsersFortnightReportCFormImpl.setProduct(getProduct());
		dgfUsersFortnightReportCFormImpl.setDaterecipt(getDaterecipt());
		dgfUsersFortnightReportCFormImpl.setReceivedQuantity(
			getReceivedQuantity());
		dgfUsersFortnightReportCFormImpl.setReceivedQuantityUnit(
			getReceivedQuantityUnit());
		dgfUsersFortnightReportCFormImpl.setLastDateApprove(
			getLastDateApprove());
		dgfUsersFortnightReportCFormImpl.setUnsoldQuantity(getUnsoldQuantity());
		dgfUsersFortnightReportCFormImpl.setUnsolddunit(getUnsolddunit());
		dgfUsersFortnightReportCFormImpl.setReasonForBeingUnsold(
			getReasonForBeingUnsold());

		dgfUsersFortnightReportCFormImpl.resetOriginalValues();

		return dgfUsersFortnightReportCFormImpl;
	}

	@Override
	public DgfUsersFortnightReportCForm cloneWithOriginalValues() {
		DgfUsersFortnightReportCFormImpl dgfUsersFortnightReportCFormImpl =
			new DgfUsersFortnightReportCFormImpl();

		dgfUsersFortnightReportCFormImpl.setReportId(
			this.<Long>getColumnOriginalValue("reportId"));
		dgfUsersFortnightReportCFormImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		dgfUsersFortnightReportCFormImpl.setUsernationalId(
			this.<String>getColumnOriginalValue("usernationalId"));
		dgfUsersFortnightReportCFormImpl.setLicenseNo(
			this.<String>getColumnOriginalValue("licenseNo"));
		dgfUsersFortnightReportCFormImpl.setScreenName(
			this.<String>getColumnOriginalValue("screenName"));
		dgfUsersFortnightReportCFormImpl.setFullName(
			this.<String>getColumnOriginalValue("fullName"));
		dgfUsersFortnightReportCFormImpl.setBussinessType(
			this.<String>getColumnOriginalValue("bussinessType"));
		dgfUsersFortnightReportCFormImpl.setStartDate(
			this.<Date>getColumnOriginalValue("startDate"));
		dgfUsersFortnightReportCFormImpl.setEndDate(
			this.<Date>getColumnOriginalValue("endDate"));
		dgfUsersFortnightReportCFormImpl.setProduct(
			this.<String>getColumnOriginalValue("product"));
		dgfUsersFortnightReportCFormImpl.setDaterecipt(
			this.<Date>getColumnOriginalValue("daterecipt"));
		dgfUsersFortnightReportCFormImpl.setReceivedQuantity(
			this.<Integer>getColumnOriginalValue("receivedQuantity"));
		dgfUsersFortnightReportCFormImpl.setReceivedQuantityUnit(
			this.<String>getColumnOriginalValue("receivedQuantityUnit"));
		dgfUsersFortnightReportCFormImpl.setLastDateApprove(
			this.<Date>getColumnOriginalValue("lastDateApprove"));
		dgfUsersFortnightReportCFormImpl.setUnsoldQuantity(
			this.<Integer>getColumnOriginalValue("unsoldQuantity"));
		dgfUsersFortnightReportCFormImpl.setUnsolddunit(
			this.<String>getColumnOriginalValue("unsolddunit"));
		dgfUsersFortnightReportCFormImpl.setReasonForBeingUnsold(
			this.<String>getColumnOriginalValue("reasonForBeingUnsold"));

		return dgfUsersFortnightReportCFormImpl;
	}

	@Override
	public int compareTo(
		DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm) {

		long primaryKey = dgfUsersFortnightReportCForm.getPrimaryKey();

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

		if (!(object instanceof DgfUsersFortnightReportCForm)) {
			return false;
		}

		DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm =
			(DgfUsersFortnightReportCForm)object;

		long primaryKey = dgfUsersFortnightReportCForm.getPrimaryKey();

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
	public CacheModel<DgfUsersFortnightReportCForm> toCacheModel() {
		DgfUsersFortnightReportCFormCacheModel
			dgfUsersFortnightReportCFormCacheModel =
				new DgfUsersFortnightReportCFormCacheModel();

		dgfUsersFortnightReportCFormCacheModel.reportId = getReportId();

		dgfUsersFortnightReportCFormCacheModel.userId = getUserId();

		dgfUsersFortnightReportCFormCacheModel.usernationalId =
			getUsernationalId();

		String usernationalId =
			dgfUsersFortnightReportCFormCacheModel.usernationalId;

		if ((usernationalId != null) && (usernationalId.length() == 0)) {
			dgfUsersFortnightReportCFormCacheModel.usernationalId = null;
		}

		dgfUsersFortnightReportCFormCacheModel.licenseNo = getLicenseNo();

		String licenseNo = dgfUsersFortnightReportCFormCacheModel.licenseNo;

		if ((licenseNo != null) && (licenseNo.length() == 0)) {
			dgfUsersFortnightReportCFormCacheModel.licenseNo = null;
		}

		dgfUsersFortnightReportCFormCacheModel.screenName = getScreenName();

		String screenName = dgfUsersFortnightReportCFormCacheModel.screenName;

		if ((screenName != null) && (screenName.length() == 0)) {
			dgfUsersFortnightReportCFormCacheModel.screenName = null;
		}

		dgfUsersFortnightReportCFormCacheModel.fullName = getFullName();

		String fullName = dgfUsersFortnightReportCFormCacheModel.fullName;

		if ((fullName != null) && (fullName.length() == 0)) {
			dgfUsersFortnightReportCFormCacheModel.fullName = null;
		}

		dgfUsersFortnightReportCFormCacheModel.bussinessType =
			getBussinessType();

		String bussinessType =
			dgfUsersFortnightReportCFormCacheModel.bussinessType;

		if ((bussinessType != null) && (bussinessType.length() == 0)) {
			dgfUsersFortnightReportCFormCacheModel.bussinessType = null;
		}

		Date startDate = getStartDate();

		if (startDate != null) {
			dgfUsersFortnightReportCFormCacheModel.startDate =
				startDate.getTime();
		}
		else {
			dgfUsersFortnightReportCFormCacheModel.startDate = Long.MIN_VALUE;
		}

		Date endDate = getEndDate();

		if (endDate != null) {
			dgfUsersFortnightReportCFormCacheModel.endDate = endDate.getTime();
		}
		else {
			dgfUsersFortnightReportCFormCacheModel.endDate = Long.MIN_VALUE;
		}

		dgfUsersFortnightReportCFormCacheModel.product = getProduct();

		String product = dgfUsersFortnightReportCFormCacheModel.product;

		if ((product != null) && (product.length() == 0)) {
			dgfUsersFortnightReportCFormCacheModel.product = null;
		}

		Date daterecipt = getDaterecipt();

		if (daterecipt != null) {
			dgfUsersFortnightReportCFormCacheModel.daterecipt =
				daterecipt.getTime();
		}
		else {
			dgfUsersFortnightReportCFormCacheModel.daterecipt = Long.MIN_VALUE;
		}

		dgfUsersFortnightReportCFormCacheModel.receivedQuantity =
			getReceivedQuantity();

		dgfUsersFortnightReportCFormCacheModel.receivedQuantityUnit =
			getReceivedQuantityUnit();

		String receivedQuantityUnit =
			dgfUsersFortnightReportCFormCacheModel.receivedQuantityUnit;

		if ((receivedQuantityUnit != null) &&
			(receivedQuantityUnit.length() == 0)) {

			dgfUsersFortnightReportCFormCacheModel.receivedQuantityUnit = null;
		}

		Date lastDateApprove = getLastDateApprove();

		if (lastDateApprove != null) {
			dgfUsersFortnightReportCFormCacheModel.lastDateApprove =
				lastDateApprove.getTime();
		}
		else {
			dgfUsersFortnightReportCFormCacheModel.lastDateApprove =
				Long.MIN_VALUE;
		}

		dgfUsersFortnightReportCFormCacheModel.unsoldQuantity =
			getUnsoldQuantity();

		dgfUsersFortnightReportCFormCacheModel.unsolddunit = getUnsolddunit();

		String unsolddunit = dgfUsersFortnightReportCFormCacheModel.unsolddunit;

		if ((unsolddunit != null) && (unsolddunit.length() == 0)) {
			dgfUsersFortnightReportCFormCacheModel.unsolddunit = null;
		}

		dgfUsersFortnightReportCFormCacheModel.reasonForBeingUnsold =
			getReasonForBeingUnsold();

		String reasonForBeingUnsold =
			dgfUsersFortnightReportCFormCacheModel.reasonForBeingUnsold;

		if ((reasonForBeingUnsold != null) &&
			(reasonForBeingUnsold.length() == 0)) {

			dgfUsersFortnightReportCFormCacheModel.reasonForBeingUnsold = null;
		}

		return dgfUsersFortnightReportCFormCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DgfUsersFortnightReportCForm, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DgfUsersFortnightReportCForm, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DgfUsersFortnightReportCForm, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(DgfUsersFortnightReportCForm)this);

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

		private static final Function
			<InvocationHandler, DgfUsersFortnightReportCForm>
				_escapedModelProxyProviderFunction =
					ProxyUtil.getProxyProviderFunction(
						DgfUsersFortnightReportCForm.class, ModelWrapper.class);

	}

	private long _reportId;
	private long _userId;
	private String _usernationalId;
	private String _licenseNo;
	private String _screenName;
	private String _fullName;
	private String _bussinessType;
	private Date _startDate;
	private Date _endDate;
	private String _product;
	private Date _daterecipt;
	private int _receivedQuantity;
	private String _receivedQuantityUnit;
	private Date _lastDateApprove;
	private int _unsoldQuantity;
	private String _unsolddunit;
	private String _reasonForBeingUnsold;

	public <T> T getColumnValue(String columnName) {
		Function<DgfUsersFortnightReportCForm, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((DgfUsersFortnightReportCForm)this);
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

		_columnOriginalValues.put("reportId", _reportId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("usernationalId", _usernationalId);
		_columnOriginalValues.put("licenseNo", _licenseNo);
		_columnOriginalValues.put("screenName", _screenName);
		_columnOriginalValues.put("fullName", _fullName);
		_columnOriginalValues.put("bussinessType", _bussinessType);
		_columnOriginalValues.put("startDate", _startDate);
		_columnOriginalValues.put("endDate", _endDate);
		_columnOriginalValues.put("product", _product);
		_columnOriginalValues.put("daterecipt", _daterecipt);
		_columnOriginalValues.put("receivedQuantity", _receivedQuantity);
		_columnOriginalValues.put(
			"receivedQuantityUnit", _receivedQuantityUnit);
		_columnOriginalValues.put("lastDateApprove", _lastDateApprove);
		_columnOriginalValues.put("unsoldQuantity", _unsoldQuantity);
		_columnOriginalValues.put("unsolddunit", _unsolddunit);
		_columnOriginalValues.put(
			"reasonForBeingUnsold", _reasonForBeingUnsold);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("reportId", 1L);

		columnBitmasks.put("userId", 2L);

		columnBitmasks.put("usernationalId", 4L);

		columnBitmasks.put("licenseNo", 8L);

		columnBitmasks.put("screenName", 16L);

		columnBitmasks.put("fullName", 32L);

		columnBitmasks.put("bussinessType", 64L);

		columnBitmasks.put("startDate", 128L);

		columnBitmasks.put("endDate", 256L);

		columnBitmasks.put("product", 512L);

		columnBitmasks.put("daterecipt", 1024L);

		columnBitmasks.put("receivedQuantity", 2048L);

		columnBitmasks.put("receivedQuantityUnit", 4096L);

		columnBitmasks.put("lastDateApprove", 8192L);

		columnBitmasks.put("unsoldQuantity", 16384L);

		columnBitmasks.put("unsolddunit", 32768L);

		columnBitmasks.put("reasonForBeingUnsold", 65536L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private DgfUsersFortnightReportCForm _escapedModel;

}