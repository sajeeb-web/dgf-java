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

import bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetails;
import bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetailsModel;

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
 * The base model implementation for the DgfUsersOtpDetails service. Represents a row in the &quot;dgf_user_otp_dtls&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DgfUsersOtpDetailsModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DgfUsersOtpDetailsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersOtpDetailsImpl
 * @generated
 */
@JSON(strict = true)
public class DgfUsersOtpDetailsModelImpl
	extends BaseModelImpl<DgfUsersOtpDetails>
	implements DgfUsersOtpDetailsModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dgf users otp details model instance should use the <code>DgfUsersOtpDetails</code> interface instead.
	 */
	public static final String TABLE_NAME = "dgf_user_otp_dtls";

	public static final Object[][] TABLE_COLUMNS = {
		{"otpId", Types.BIGINT}, {"nationalId", Types.VARCHAR},
		{"otp", Types.BIGINT}, {"otpRequestTime", Types.TIMESTAMP},
		{"otpLoginTime", Types.TIMESTAMP}, {"otpExpireTime", Types.TIMESTAMP},
		{"userId", Types.BIGINT}, {"userRegNo", Types.BIGINT},
		{"mobileNo", Types.VARCHAR}, {"emailId", Types.VARCHAR},
		{"otpVerify", Types.VARCHAR}, {"isSent", Types.BOOLEAN},
		{"message", Types.VARCHAR}, {"requestUrl", Types.VARCHAR},
		{"responseData", Types.VARCHAR}, {"responseStatusCode", Types.INTEGER},
		{"responseResult", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("otpId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("nationalId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("otp", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("otpRequestTime", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("otpLoginTime", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("otpExpireTime", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userRegNo", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("mobileNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("emailId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("otpVerify", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("isSent", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("message", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("requestUrl", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("responseData", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("responseStatusCode", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("responseResult", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table dgf_user_otp_dtls (otpId LONG not null primary key,nationalId VARCHAR(75) null,otp LONG,otpRequestTime DATE null,otpLoginTime DATE null,otpExpireTime DATE null,userId LONG,userRegNo LONG,mobileNo VARCHAR(75) null,emailId VARCHAR(75) null,otpVerify VARCHAR(75) null,isSent BOOLEAN,message TEXT null,requestUrl TEXT null,responseData TEXT null,responseStatusCode INTEGER,responseResult VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table dgf_user_otp_dtls";

	public static final String ORDER_BY_JPQL =
		" ORDER BY dgfUsersOtpDetails.otpId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY dgf_user_otp_dtls.otpId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ISSENT_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long MOBILENO_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long NATIONALID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long OTP_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long USERID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long OTPID_COLUMN_BITMASK = 32L;

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

	public DgfUsersOtpDetailsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _otpId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOtpId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _otpId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DgfUsersOtpDetails.class;
	}

	@Override
	public String getModelClassName() {
		return DgfUsersOtpDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DgfUsersOtpDetails, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DgfUsersOtpDetails, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DgfUsersOtpDetails, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((DgfUsersOtpDetails)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DgfUsersOtpDetails, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DgfUsersOtpDetails, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DgfUsersOtpDetails)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DgfUsersOtpDetails, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DgfUsersOtpDetails, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<DgfUsersOtpDetails, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<DgfUsersOtpDetails, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<DgfUsersOtpDetails, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<DgfUsersOtpDetails, Object>>();
		Map<String, BiConsumer<DgfUsersOtpDetails, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<DgfUsersOtpDetails, ?>>();

		attributeGetterFunctions.put("otpId", DgfUsersOtpDetails::getOtpId);
		attributeSetterBiConsumers.put(
			"otpId",
			(BiConsumer<DgfUsersOtpDetails, Long>)DgfUsersOtpDetails::setOtpId);
		attributeGetterFunctions.put(
			"nationalId", DgfUsersOtpDetails::getNationalId);
		attributeSetterBiConsumers.put(
			"nationalId",
			(BiConsumer<DgfUsersOtpDetails, String>)
				DgfUsersOtpDetails::setNationalId);
		attributeGetterFunctions.put("otp", DgfUsersOtpDetails::getOtp);
		attributeSetterBiConsumers.put(
			"otp",
			(BiConsumer<DgfUsersOtpDetails, Long>)DgfUsersOtpDetails::setOtp);
		attributeGetterFunctions.put(
			"otpRequestTime", DgfUsersOtpDetails::getOtpRequestTime);
		attributeSetterBiConsumers.put(
			"otpRequestTime",
			(BiConsumer<DgfUsersOtpDetails, Date>)
				DgfUsersOtpDetails::setOtpRequestTime);
		attributeGetterFunctions.put(
			"otpLoginTime", DgfUsersOtpDetails::getOtpLoginTime);
		attributeSetterBiConsumers.put(
			"otpLoginTime",
			(BiConsumer<DgfUsersOtpDetails, Date>)
				DgfUsersOtpDetails::setOtpLoginTime);
		attributeGetterFunctions.put(
			"otpExpireTime", DgfUsersOtpDetails::getOtpExpireTime);
		attributeSetterBiConsumers.put(
			"otpExpireTime",
			(BiConsumer<DgfUsersOtpDetails, Date>)
				DgfUsersOtpDetails::setOtpExpireTime);
		attributeGetterFunctions.put("userId", DgfUsersOtpDetails::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<DgfUsersOtpDetails, Long>)
				DgfUsersOtpDetails::setUserId);
		attributeGetterFunctions.put(
			"userRegNo", DgfUsersOtpDetails::getUserRegNo);
		attributeSetterBiConsumers.put(
			"userRegNo",
			(BiConsumer<DgfUsersOtpDetails, Long>)
				DgfUsersOtpDetails::setUserRegNo);
		attributeGetterFunctions.put(
			"mobileNo", DgfUsersOtpDetails::getMobileNo);
		attributeSetterBiConsumers.put(
			"mobileNo",
			(BiConsumer<DgfUsersOtpDetails, String>)
				DgfUsersOtpDetails::setMobileNo);
		attributeGetterFunctions.put("emailId", DgfUsersOtpDetails::getEmailId);
		attributeSetterBiConsumers.put(
			"emailId",
			(BiConsumer<DgfUsersOtpDetails, String>)
				DgfUsersOtpDetails::setEmailId);
		attributeGetterFunctions.put(
			"otpVerify", DgfUsersOtpDetails::getOtpVerify);
		attributeSetterBiConsumers.put(
			"otpVerify",
			(BiConsumer<DgfUsersOtpDetails, String>)
				DgfUsersOtpDetails::setOtpVerify);
		attributeGetterFunctions.put("isSent", DgfUsersOtpDetails::getIsSent);
		attributeSetterBiConsumers.put(
			"isSent",
			(BiConsumer<DgfUsersOtpDetails, Boolean>)
				DgfUsersOtpDetails::setIsSent);
		attributeGetterFunctions.put("message", DgfUsersOtpDetails::getMessage);
		attributeSetterBiConsumers.put(
			"message",
			(BiConsumer<DgfUsersOtpDetails, String>)
				DgfUsersOtpDetails::setMessage);
		attributeGetterFunctions.put(
			"requestUrl", DgfUsersOtpDetails::getRequestUrl);
		attributeSetterBiConsumers.put(
			"requestUrl",
			(BiConsumer<DgfUsersOtpDetails, String>)
				DgfUsersOtpDetails::setRequestUrl);
		attributeGetterFunctions.put(
			"responseData", DgfUsersOtpDetails::getResponseData);
		attributeSetterBiConsumers.put(
			"responseData",
			(BiConsumer<DgfUsersOtpDetails, String>)
				DgfUsersOtpDetails::setResponseData);
		attributeGetterFunctions.put(
			"responseStatusCode", DgfUsersOtpDetails::getResponseStatusCode);
		attributeSetterBiConsumers.put(
			"responseStatusCode",
			(BiConsumer<DgfUsersOtpDetails, Integer>)
				DgfUsersOtpDetails::setResponseStatusCode);
		attributeGetterFunctions.put(
			"responseResult", DgfUsersOtpDetails::getResponseResult);
		attributeSetterBiConsumers.put(
			"responseResult",
			(BiConsumer<DgfUsersOtpDetails, String>)
				DgfUsersOtpDetails::setResponseResult);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getOtpId() {
		return _otpId;
	}

	@Override
	public void setOtpId(long otpId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_otpId = otpId;
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
	public long getOtp() {
		return _otp;
	}

	@Override
	public void setOtp(long otp) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_otp = otp;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalOtp() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("otp"));
	}

	@JSON
	@Override
	public Date getOtpRequestTime() {
		return _otpRequestTime;
	}

	@Override
	public void setOtpRequestTime(Date otpRequestTime) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_otpRequestTime = otpRequestTime;
	}

	@JSON
	@Override
	public Date getOtpLoginTime() {
		return _otpLoginTime;
	}

	@Override
	public void setOtpLoginTime(Date otpLoginTime) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_otpLoginTime = otpLoginTime;
	}

	@JSON
	@Override
	public Date getOtpExpireTime() {
		return _otpExpireTime;
	}

	@Override
	public void setOtpExpireTime(Date otpExpireTime) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_otpExpireTime = otpExpireTime;
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
	public long getUserRegNo() {
		return _userRegNo;
	}

	@Override
	public void setUserRegNo(long userRegNo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userRegNo = userRegNo;
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
	public String getEmailId() {
		if (_emailId == null) {
			return "";
		}
		else {
			return _emailId;
		}
	}

	@Override
	public void setEmailId(String emailId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_emailId = emailId;
	}

	@JSON
	@Override
	public String getOtpVerify() {
		if (_otpVerify == null) {
			return "";
		}
		else {
			return _otpVerify;
		}
	}

	@Override
	public void setOtpVerify(String otpVerify) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_otpVerify = otpVerify;
	}

	@JSON
	@Override
	public boolean getIsSent() {
		return _isSent;
	}

	@JSON
	@Override
	public boolean isIsSent() {
		return _isSent;
	}

	@Override
	public void setIsSent(boolean isSent) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_isSent = isSent;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public boolean getOriginalIsSent() {
		return GetterUtil.getBoolean(
			this.<Boolean>getColumnOriginalValue("isSent"));
	}

	@JSON
	@Override
	public String getMessage() {
		if (_message == null) {
			return "";
		}
		else {
			return _message;
		}
	}

	@Override
	public void setMessage(String message) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_message = message;
	}

	@JSON
	@Override
	public String getRequestUrl() {
		if (_requestUrl == null) {
			return "";
		}
		else {
			return _requestUrl;
		}
	}

	@Override
	public void setRequestUrl(String requestUrl) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_requestUrl = requestUrl;
	}

	@JSON
	@Override
	public String getResponseData() {
		if (_responseData == null) {
			return "";
		}
		else {
			return _responseData;
		}
	}

	@Override
	public void setResponseData(String responseData) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_responseData = responseData;
	}

	@JSON
	@Override
	public int getResponseStatusCode() {
		return _responseStatusCode;
	}

	@Override
	public void setResponseStatusCode(int responseStatusCode) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_responseStatusCode = responseStatusCode;
	}

	@JSON
	@Override
	public String getResponseResult() {
		if (_responseResult == null) {
			return "";
		}
		else {
			return _responseResult;
		}
	}

	@Override
	public void setResponseResult(String responseResult) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_responseResult = responseResult;
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
			0, DgfUsersOtpDetails.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DgfUsersOtpDetails toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, DgfUsersOtpDetails>
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
		DgfUsersOtpDetailsImpl dgfUsersOtpDetailsImpl =
			new DgfUsersOtpDetailsImpl();

		dgfUsersOtpDetailsImpl.setOtpId(getOtpId());
		dgfUsersOtpDetailsImpl.setNationalId(getNationalId());
		dgfUsersOtpDetailsImpl.setOtp(getOtp());
		dgfUsersOtpDetailsImpl.setOtpRequestTime(getOtpRequestTime());
		dgfUsersOtpDetailsImpl.setOtpLoginTime(getOtpLoginTime());
		dgfUsersOtpDetailsImpl.setOtpExpireTime(getOtpExpireTime());
		dgfUsersOtpDetailsImpl.setUserId(getUserId());
		dgfUsersOtpDetailsImpl.setUserRegNo(getUserRegNo());
		dgfUsersOtpDetailsImpl.setMobileNo(getMobileNo());
		dgfUsersOtpDetailsImpl.setEmailId(getEmailId());
		dgfUsersOtpDetailsImpl.setOtpVerify(getOtpVerify());
		dgfUsersOtpDetailsImpl.setIsSent(isIsSent());
		dgfUsersOtpDetailsImpl.setMessage(getMessage());
		dgfUsersOtpDetailsImpl.setRequestUrl(getRequestUrl());
		dgfUsersOtpDetailsImpl.setResponseData(getResponseData());
		dgfUsersOtpDetailsImpl.setResponseStatusCode(getResponseStatusCode());
		dgfUsersOtpDetailsImpl.setResponseResult(getResponseResult());

		dgfUsersOtpDetailsImpl.resetOriginalValues();

		return dgfUsersOtpDetailsImpl;
	}

	@Override
	public DgfUsersOtpDetails cloneWithOriginalValues() {
		DgfUsersOtpDetailsImpl dgfUsersOtpDetailsImpl =
			new DgfUsersOtpDetailsImpl();

		dgfUsersOtpDetailsImpl.setOtpId(
			this.<Long>getColumnOriginalValue("otpId"));
		dgfUsersOtpDetailsImpl.setNationalId(
			this.<String>getColumnOriginalValue("nationalId"));
		dgfUsersOtpDetailsImpl.setOtp(this.<Long>getColumnOriginalValue("otp"));
		dgfUsersOtpDetailsImpl.setOtpRequestTime(
			this.<Date>getColumnOriginalValue("otpRequestTime"));
		dgfUsersOtpDetailsImpl.setOtpLoginTime(
			this.<Date>getColumnOriginalValue("otpLoginTime"));
		dgfUsersOtpDetailsImpl.setOtpExpireTime(
			this.<Date>getColumnOriginalValue("otpExpireTime"));
		dgfUsersOtpDetailsImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		dgfUsersOtpDetailsImpl.setUserRegNo(
			this.<Long>getColumnOriginalValue("userRegNo"));
		dgfUsersOtpDetailsImpl.setMobileNo(
			this.<String>getColumnOriginalValue("mobileNo"));
		dgfUsersOtpDetailsImpl.setEmailId(
			this.<String>getColumnOriginalValue("emailId"));
		dgfUsersOtpDetailsImpl.setOtpVerify(
			this.<String>getColumnOriginalValue("otpVerify"));
		dgfUsersOtpDetailsImpl.setIsSent(
			this.<Boolean>getColumnOriginalValue("isSent"));
		dgfUsersOtpDetailsImpl.setMessage(
			this.<String>getColumnOriginalValue("message"));
		dgfUsersOtpDetailsImpl.setRequestUrl(
			this.<String>getColumnOriginalValue("requestUrl"));
		dgfUsersOtpDetailsImpl.setResponseData(
			this.<String>getColumnOriginalValue("responseData"));
		dgfUsersOtpDetailsImpl.setResponseStatusCode(
			this.<Integer>getColumnOriginalValue("responseStatusCode"));
		dgfUsersOtpDetailsImpl.setResponseResult(
			this.<String>getColumnOriginalValue("responseResult"));

		return dgfUsersOtpDetailsImpl;
	}

	@Override
	public int compareTo(DgfUsersOtpDetails dgfUsersOtpDetails) {
		long primaryKey = dgfUsersOtpDetails.getPrimaryKey();

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

		if (!(object instanceof DgfUsersOtpDetails)) {
			return false;
		}

		DgfUsersOtpDetails dgfUsersOtpDetails = (DgfUsersOtpDetails)object;

		long primaryKey = dgfUsersOtpDetails.getPrimaryKey();

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
	public CacheModel<DgfUsersOtpDetails> toCacheModel() {
		DgfUsersOtpDetailsCacheModel dgfUsersOtpDetailsCacheModel =
			new DgfUsersOtpDetailsCacheModel();

		dgfUsersOtpDetailsCacheModel.otpId = getOtpId();

		dgfUsersOtpDetailsCacheModel.nationalId = getNationalId();

		String nationalId = dgfUsersOtpDetailsCacheModel.nationalId;

		if ((nationalId != null) && (nationalId.length() == 0)) {
			dgfUsersOtpDetailsCacheModel.nationalId = null;
		}

		dgfUsersOtpDetailsCacheModel.otp = getOtp();

		Date otpRequestTime = getOtpRequestTime();

		if (otpRequestTime != null) {
			dgfUsersOtpDetailsCacheModel.otpRequestTime =
				otpRequestTime.getTime();
		}
		else {
			dgfUsersOtpDetailsCacheModel.otpRequestTime = Long.MIN_VALUE;
		}

		Date otpLoginTime = getOtpLoginTime();

		if (otpLoginTime != null) {
			dgfUsersOtpDetailsCacheModel.otpLoginTime = otpLoginTime.getTime();
		}
		else {
			dgfUsersOtpDetailsCacheModel.otpLoginTime = Long.MIN_VALUE;
		}

		Date otpExpireTime = getOtpExpireTime();

		if (otpExpireTime != null) {
			dgfUsersOtpDetailsCacheModel.otpExpireTime =
				otpExpireTime.getTime();
		}
		else {
			dgfUsersOtpDetailsCacheModel.otpExpireTime = Long.MIN_VALUE;
		}

		dgfUsersOtpDetailsCacheModel.userId = getUserId();

		dgfUsersOtpDetailsCacheModel.userRegNo = getUserRegNo();

		dgfUsersOtpDetailsCacheModel.mobileNo = getMobileNo();

		String mobileNo = dgfUsersOtpDetailsCacheModel.mobileNo;

		if ((mobileNo != null) && (mobileNo.length() == 0)) {
			dgfUsersOtpDetailsCacheModel.mobileNo = null;
		}

		dgfUsersOtpDetailsCacheModel.emailId = getEmailId();

		String emailId = dgfUsersOtpDetailsCacheModel.emailId;

		if ((emailId != null) && (emailId.length() == 0)) {
			dgfUsersOtpDetailsCacheModel.emailId = null;
		}

		dgfUsersOtpDetailsCacheModel.otpVerify = getOtpVerify();

		String otpVerify = dgfUsersOtpDetailsCacheModel.otpVerify;

		if ((otpVerify != null) && (otpVerify.length() == 0)) {
			dgfUsersOtpDetailsCacheModel.otpVerify = null;
		}

		dgfUsersOtpDetailsCacheModel.isSent = isIsSent();

		dgfUsersOtpDetailsCacheModel.message = getMessage();

		String message = dgfUsersOtpDetailsCacheModel.message;

		if ((message != null) && (message.length() == 0)) {
			dgfUsersOtpDetailsCacheModel.message = null;
		}

		dgfUsersOtpDetailsCacheModel.requestUrl = getRequestUrl();

		String requestUrl = dgfUsersOtpDetailsCacheModel.requestUrl;

		if ((requestUrl != null) && (requestUrl.length() == 0)) {
			dgfUsersOtpDetailsCacheModel.requestUrl = null;
		}

		dgfUsersOtpDetailsCacheModel.responseData = getResponseData();

		String responseData = dgfUsersOtpDetailsCacheModel.responseData;

		if ((responseData != null) && (responseData.length() == 0)) {
			dgfUsersOtpDetailsCacheModel.responseData = null;
		}

		dgfUsersOtpDetailsCacheModel.responseStatusCode =
			getResponseStatusCode();

		dgfUsersOtpDetailsCacheModel.responseResult = getResponseResult();

		String responseResult = dgfUsersOtpDetailsCacheModel.responseResult;

		if ((responseResult != null) && (responseResult.length() == 0)) {
			dgfUsersOtpDetailsCacheModel.responseResult = null;
		}

		return dgfUsersOtpDetailsCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DgfUsersOtpDetails, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DgfUsersOtpDetails, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DgfUsersOtpDetails, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(DgfUsersOtpDetails)this);

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

		private static final Function<InvocationHandler, DgfUsersOtpDetails>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					DgfUsersOtpDetails.class, ModelWrapper.class);

	}

	private long _otpId;
	private String _nationalId;
	private long _otp;
	private Date _otpRequestTime;
	private Date _otpLoginTime;
	private Date _otpExpireTime;
	private long _userId;
	private long _userRegNo;
	private String _mobileNo;
	private String _emailId;
	private String _otpVerify;
	private boolean _isSent;
	private String _message;
	private String _requestUrl;
	private String _responseData;
	private int _responseStatusCode;
	private String _responseResult;

	public <T> T getColumnValue(String columnName) {
		Function<DgfUsersOtpDetails, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((DgfUsersOtpDetails)this);
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

		_columnOriginalValues.put("otpId", _otpId);
		_columnOriginalValues.put("nationalId", _nationalId);
		_columnOriginalValues.put("otp", _otp);
		_columnOriginalValues.put("otpRequestTime", _otpRequestTime);
		_columnOriginalValues.put("otpLoginTime", _otpLoginTime);
		_columnOriginalValues.put("otpExpireTime", _otpExpireTime);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userRegNo", _userRegNo);
		_columnOriginalValues.put("mobileNo", _mobileNo);
		_columnOriginalValues.put("emailId", _emailId);
		_columnOriginalValues.put("otpVerify", _otpVerify);
		_columnOriginalValues.put("isSent", _isSent);
		_columnOriginalValues.put("message", _message);
		_columnOriginalValues.put("requestUrl", _requestUrl);
		_columnOriginalValues.put("responseData", _responseData);
		_columnOriginalValues.put("responseStatusCode", _responseStatusCode);
		_columnOriginalValues.put("responseResult", _responseResult);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("otpId", 1L);

		columnBitmasks.put("nationalId", 2L);

		columnBitmasks.put("otp", 4L);

		columnBitmasks.put("otpRequestTime", 8L);

		columnBitmasks.put("otpLoginTime", 16L);

		columnBitmasks.put("otpExpireTime", 32L);

		columnBitmasks.put("userId", 64L);

		columnBitmasks.put("userRegNo", 128L);

		columnBitmasks.put("mobileNo", 256L);

		columnBitmasks.put("emailId", 512L);

		columnBitmasks.put("otpVerify", 1024L);

		columnBitmasks.put("isSent", 2048L);

		columnBitmasks.put("message", 4096L);

		columnBitmasks.put("requestUrl", 8192L);

		columnBitmasks.put("responseData", 16384L);

		columnBitmasks.put("responseStatusCode", 32768L);

		columnBitmasks.put("responseResult", 65536L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private DgfUsersOtpDetails _escapedModel;

}