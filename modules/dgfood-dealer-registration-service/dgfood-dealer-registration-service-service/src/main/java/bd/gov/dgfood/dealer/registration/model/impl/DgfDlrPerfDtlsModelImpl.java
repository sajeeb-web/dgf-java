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

package bd.gov.dgfood.dealer.registration.model.impl;

import bd.gov.dgfood.dealer.registration.model.DgfDlrPerfDtls;
import bd.gov.dgfood.dealer.registration.model.DgfDlrPerfDtlsModel;

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
 * The base model implementation for the DgfDlrPerfDtls service. Represents a row in the &quot;dgf_dlr_perf_dtls&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DgfDlrPerfDtlsModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DgfDlrPerfDtlsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrPerfDtlsImpl
 * @generated
 */
@JSON(strict = true)
public class DgfDlrPerfDtlsModelImpl
	extends BaseModelImpl<DgfDlrPerfDtls> implements DgfDlrPerfDtlsModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dgf dlr perf dtls model instance should use the <code>DgfDlrPerfDtls</code> interface instead.
	 */
	public static final String TABLE_NAME = "dgf_dlr_perf_dtls";

	public static final Object[][] TABLE_COLUMNS = {
		{"dgf_dlr_perf_id", Types.BIGINT}, {"national_id", Types.VARCHAR},
		{"dlr_reg_appl_no", Types.BIGINT}, {"dlr_reg_no", Types.BIGINT},
		{"dlr_perf_yr1", Types.BIGINT},
		{"dlr_perf_yr1_alloc_qty", Types.BIGINT},
		{"dlr_perf_yr1_comdty_qty", Types.BIGINT},
		{"dlr_perf_yr1_dlr_ctgry", Types.VARCHAR},
		{"dlr_perf_yr1_rmrk", Types.VARCHAR}, {"dlr_perf_yr2", Types.BIGINT},
		{"dlr_perf_yr2_alloc_qty", Types.BIGINT},
		{"dlr_perf_yr2_comdty_qty", Types.BIGINT},
		{"dlr_perf_yr2_dlr_ctgry", Types.VARCHAR},
		{"dlr_perf_yr2_rmrk", Types.VARCHAR}, {"dlr_perf_yr3", Types.BIGINT},
		{"dlr_perf_yr3_alloc_qty", Types.BIGINT},
		{"dlr_perf_yr3_comdty_qty", Types.BIGINT},
		{"dlr_perf_yr3_dlr_ctgry", Types.VARCHAR},
		{"dlr_perf_yr3_rmrk", Types.VARCHAR}, {"version", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("dgf_dlr_perf_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("national_id", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dlr_reg_appl_no", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dlr_reg_no", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dlr_perf_yr1", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dlr_perf_yr1_alloc_qty", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dlr_perf_yr1_comdty_qty", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dlr_perf_yr1_dlr_ctgry", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dlr_perf_yr1_rmrk", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dlr_perf_yr2", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dlr_perf_yr2_alloc_qty", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dlr_perf_yr2_comdty_qty", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dlr_perf_yr2_dlr_ctgry", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dlr_perf_yr2_rmrk", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dlr_perf_yr3", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dlr_perf_yr3_alloc_qty", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dlr_perf_yr3_comdty_qty", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dlr_perf_yr3_dlr_ctgry", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dlr_perf_yr3_rmrk", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("version", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table dgf_dlr_perf_dtls (dgf_dlr_perf_id LONG not null primary key,national_id VARCHAR(75) null,dlr_reg_appl_no LONG,dlr_reg_no LONG,dlr_perf_yr1 LONG,dlr_perf_yr1_alloc_qty LONG,dlr_perf_yr1_comdty_qty LONG,dlr_perf_yr1_dlr_ctgry VARCHAR(75) null,dlr_perf_yr1_rmrk VARCHAR(75) null,dlr_perf_yr2 LONG,dlr_perf_yr2_alloc_qty LONG,dlr_perf_yr2_comdty_qty LONG,dlr_perf_yr2_dlr_ctgry VARCHAR(75) null,dlr_perf_yr2_rmrk VARCHAR(75) null,dlr_perf_yr3 LONG,dlr_perf_yr3_alloc_qty LONG,dlr_perf_yr3_comdty_qty LONG,dlr_perf_yr3_dlr_ctgry VARCHAR(75) null,dlr_perf_yr3_rmrk VARCHAR(75) null,version LONG)";

	public static final String TABLE_SQL_DROP = "drop table dgf_dlr_perf_dtls";

	public static final String ORDER_BY_JPQL =
		" ORDER BY dgfDlrPerfDtls.dgfDlrPerfId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY dgf_dlr_perf_dtls.dgf_dlr_perf_id ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long DLRREGNO_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long NATIONALID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long DGFDLRPERFID_COLUMN_BITMASK = 4L;

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

	public DgfDlrPerfDtlsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _dgfDlrPerfId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDgfDlrPerfId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dgfDlrPerfId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DgfDlrPerfDtls.class;
	}

	@Override
	public String getModelClassName() {
		return DgfDlrPerfDtls.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DgfDlrPerfDtls, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DgfDlrPerfDtls, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DgfDlrPerfDtls, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((DgfDlrPerfDtls)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DgfDlrPerfDtls, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DgfDlrPerfDtls, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DgfDlrPerfDtls)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DgfDlrPerfDtls, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DgfDlrPerfDtls, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<DgfDlrPerfDtls, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<DgfDlrPerfDtls, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<DgfDlrPerfDtls, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<DgfDlrPerfDtls, Object>>();
		Map<String, BiConsumer<DgfDlrPerfDtls, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<DgfDlrPerfDtls, ?>>();

		attributeGetterFunctions.put(
			"dgfDlrPerfId", DgfDlrPerfDtls::getDgfDlrPerfId);
		attributeSetterBiConsumers.put(
			"dgfDlrPerfId",
			(BiConsumer<DgfDlrPerfDtls, Long>)DgfDlrPerfDtls::setDgfDlrPerfId);
		attributeGetterFunctions.put(
			"nationalId", DgfDlrPerfDtls::getNationalId);
		attributeSetterBiConsumers.put(
			"nationalId",
			(BiConsumer<DgfDlrPerfDtls, String>)DgfDlrPerfDtls::setNationalId);
		attributeGetterFunctions.put(
			"dlrRegApplNo", DgfDlrPerfDtls::getDlrRegApplNo);
		attributeSetterBiConsumers.put(
			"dlrRegApplNo",
			(BiConsumer<DgfDlrPerfDtls, Long>)DgfDlrPerfDtls::setDlrRegApplNo);
		attributeGetterFunctions.put("dlrRegNo", DgfDlrPerfDtls::getDlrRegNo);
		attributeSetterBiConsumers.put(
			"dlrRegNo",
			(BiConsumer<DgfDlrPerfDtls, Long>)DgfDlrPerfDtls::setDlrRegNo);
		attributeGetterFunctions.put(
			"dlrPerfYr1", DgfDlrPerfDtls::getDlrPerfYr1);
		attributeSetterBiConsumers.put(
			"dlrPerfYr1",
			(BiConsumer<DgfDlrPerfDtls, Long>)DgfDlrPerfDtls::setDlrPerfYr1);
		attributeGetterFunctions.put(
			"dlrPerfYr1AllocQty", DgfDlrPerfDtls::getDlrPerfYr1AllocQty);
		attributeSetterBiConsumers.put(
			"dlrPerfYr1AllocQty",
			(BiConsumer<DgfDlrPerfDtls, Long>)
				DgfDlrPerfDtls::setDlrPerfYr1AllocQty);
		attributeGetterFunctions.put(
			"dlrPerfYr1ComdtyQty", DgfDlrPerfDtls::getDlrPerfYr1ComdtyQty);
		attributeSetterBiConsumers.put(
			"dlrPerfYr1ComdtyQty",
			(BiConsumer<DgfDlrPerfDtls, Long>)
				DgfDlrPerfDtls::setDlrPerfYr1ComdtyQty);
		attributeGetterFunctions.put(
			"dlrPerfYr1DlrCtgry", DgfDlrPerfDtls::getDlrPerfYr1DlrCtgry);
		attributeSetterBiConsumers.put(
			"dlrPerfYr1DlrCtgry",
			(BiConsumer<DgfDlrPerfDtls, String>)
				DgfDlrPerfDtls::setDlrPerfYr1DlrCtgry);
		attributeGetterFunctions.put(
			"dlrPerfYr1Rmrk", DgfDlrPerfDtls::getDlrPerfYr1Rmrk);
		attributeSetterBiConsumers.put(
			"dlrPerfYr1Rmrk",
			(BiConsumer<DgfDlrPerfDtls, String>)
				DgfDlrPerfDtls::setDlrPerfYr1Rmrk);
		attributeGetterFunctions.put(
			"dlrPerfYr2", DgfDlrPerfDtls::getDlrPerfYr2);
		attributeSetterBiConsumers.put(
			"dlrPerfYr2",
			(BiConsumer<DgfDlrPerfDtls, Long>)DgfDlrPerfDtls::setDlrPerfYr2);
		attributeGetterFunctions.put(
			"dlrPerfYr2AllocQty", DgfDlrPerfDtls::getDlrPerfYr2AllocQty);
		attributeSetterBiConsumers.put(
			"dlrPerfYr2AllocQty",
			(BiConsumer<DgfDlrPerfDtls, Long>)
				DgfDlrPerfDtls::setDlrPerfYr2AllocQty);
		attributeGetterFunctions.put(
			"dlrPerfYr2ComdtyQty", DgfDlrPerfDtls::getDlrPerfYr2ComdtyQty);
		attributeSetterBiConsumers.put(
			"dlrPerfYr2ComdtyQty",
			(BiConsumer<DgfDlrPerfDtls, Long>)
				DgfDlrPerfDtls::setDlrPerfYr2ComdtyQty);
		attributeGetterFunctions.put(
			"dlrPerfYr2DlrCtgry", DgfDlrPerfDtls::getDlrPerfYr2DlrCtgry);
		attributeSetterBiConsumers.put(
			"dlrPerfYr2DlrCtgry",
			(BiConsumer<DgfDlrPerfDtls, String>)
				DgfDlrPerfDtls::setDlrPerfYr2DlrCtgry);
		attributeGetterFunctions.put(
			"dlrPerfYr2Rmrk", DgfDlrPerfDtls::getDlrPerfYr2Rmrk);
		attributeSetterBiConsumers.put(
			"dlrPerfYr2Rmrk",
			(BiConsumer<DgfDlrPerfDtls, String>)
				DgfDlrPerfDtls::setDlrPerfYr2Rmrk);
		attributeGetterFunctions.put(
			"dlrPerfYr3", DgfDlrPerfDtls::getDlrPerfYr3);
		attributeSetterBiConsumers.put(
			"dlrPerfYr3",
			(BiConsumer<DgfDlrPerfDtls, Long>)DgfDlrPerfDtls::setDlrPerfYr3);
		attributeGetterFunctions.put(
			"dlrPerfYr3AllocQty", DgfDlrPerfDtls::getDlrPerfYr3AllocQty);
		attributeSetterBiConsumers.put(
			"dlrPerfYr3AllocQty",
			(BiConsumer<DgfDlrPerfDtls, Long>)
				DgfDlrPerfDtls::setDlrPerfYr3AllocQty);
		attributeGetterFunctions.put(
			"dlrPerfYr3ComdtyQty", DgfDlrPerfDtls::getDlrPerfYr3ComdtyQty);
		attributeSetterBiConsumers.put(
			"dlrPerfYr3ComdtyQty",
			(BiConsumer<DgfDlrPerfDtls, Long>)
				DgfDlrPerfDtls::setDlrPerfYr3ComdtyQty);
		attributeGetterFunctions.put(
			"dlrPerfYr3DlrCtgry", DgfDlrPerfDtls::getDlrPerfYr3DlrCtgry);
		attributeSetterBiConsumers.put(
			"dlrPerfYr3DlrCtgry",
			(BiConsumer<DgfDlrPerfDtls, String>)
				DgfDlrPerfDtls::setDlrPerfYr3DlrCtgry);
		attributeGetterFunctions.put(
			"dlrPerfYr3Rmrk", DgfDlrPerfDtls::getDlrPerfYr3Rmrk);
		attributeSetterBiConsumers.put(
			"dlrPerfYr3Rmrk",
			(BiConsumer<DgfDlrPerfDtls, String>)
				DgfDlrPerfDtls::setDlrPerfYr3Rmrk);
		attributeGetterFunctions.put("version", DgfDlrPerfDtls::getVersion);
		attributeSetterBiConsumers.put(
			"version",
			(BiConsumer<DgfDlrPerfDtls, Long>)DgfDlrPerfDtls::setVersion);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getDgfDlrPerfId() {
		return _dgfDlrPerfId;
	}

	@Override
	public void setDgfDlrPerfId(long dgfDlrPerfId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dgfDlrPerfId = dgfDlrPerfId;
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
		return getColumnOriginalValue("national_id");
	}

	@JSON
	@Override
	public long getDlrRegApplNo() {
		return _dlrRegApplNo;
	}

	@Override
	public void setDlrRegApplNo(long dlrRegApplNo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dlrRegApplNo = dlrRegApplNo;
	}

	@JSON
	@Override
	public long getDlrRegNo() {
		return _dlrRegNo;
	}

	@Override
	public void setDlrRegNo(long dlrRegNo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dlrRegNo = dlrRegNo;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalDlrRegNo() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("dlr_reg_no"));
	}

	@JSON
	@Override
	public long getDlrPerfYr1() {
		return _dlrPerfYr1;
	}

	@Override
	public void setDlrPerfYr1(long dlrPerfYr1) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dlrPerfYr1 = dlrPerfYr1;
	}

	@JSON
	@Override
	public long getDlrPerfYr1AllocQty() {
		return _dlrPerfYr1AllocQty;
	}

	@Override
	public void setDlrPerfYr1AllocQty(long dlrPerfYr1AllocQty) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dlrPerfYr1AllocQty = dlrPerfYr1AllocQty;
	}

	@JSON
	@Override
	public long getDlrPerfYr1ComdtyQty() {
		return _dlrPerfYr1ComdtyQty;
	}

	@Override
	public void setDlrPerfYr1ComdtyQty(long dlrPerfYr1ComdtyQty) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dlrPerfYr1ComdtyQty = dlrPerfYr1ComdtyQty;
	}

	@JSON
	@Override
	public String getDlrPerfYr1DlrCtgry() {
		if (_dlrPerfYr1DlrCtgry == null) {
			return "";
		}
		else {
			return _dlrPerfYr1DlrCtgry;
		}
	}

	@Override
	public void setDlrPerfYr1DlrCtgry(String dlrPerfYr1DlrCtgry) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dlrPerfYr1DlrCtgry = dlrPerfYr1DlrCtgry;
	}

	@JSON
	@Override
	public String getDlrPerfYr1Rmrk() {
		if (_dlrPerfYr1Rmrk == null) {
			return "";
		}
		else {
			return _dlrPerfYr1Rmrk;
		}
	}

	@Override
	public void setDlrPerfYr1Rmrk(String dlrPerfYr1Rmrk) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dlrPerfYr1Rmrk = dlrPerfYr1Rmrk;
	}

	@JSON
	@Override
	public long getDlrPerfYr2() {
		return _dlrPerfYr2;
	}

	@Override
	public void setDlrPerfYr2(long dlrPerfYr2) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dlrPerfYr2 = dlrPerfYr2;
	}

	@JSON
	@Override
	public long getDlrPerfYr2AllocQty() {
		return _dlrPerfYr2AllocQty;
	}

	@Override
	public void setDlrPerfYr2AllocQty(long dlrPerfYr2AllocQty) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dlrPerfYr2AllocQty = dlrPerfYr2AllocQty;
	}

	@JSON
	@Override
	public long getDlrPerfYr2ComdtyQty() {
		return _dlrPerfYr2ComdtyQty;
	}

	@Override
	public void setDlrPerfYr2ComdtyQty(long dlrPerfYr2ComdtyQty) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dlrPerfYr2ComdtyQty = dlrPerfYr2ComdtyQty;
	}

	@JSON
	@Override
	public String getDlrPerfYr2DlrCtgry() {
		if (_dlrPerfYr2DlrCtgry == null) {
			return "";
		}
		else {
			return _dlrPerfYr2DlrCtgry;
		}
	}

	@Override
	public void setDlrPerfYr2DlrCtgry(String dlrPerfYr2DlrCtgry) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dlrPerfYr2DlrCtgry = dlrPerfYr2DlrCtgry;
	}

	@JSON
	@Override
	public String getDlrPerfYr2Rmrk() {
		if (_dlrPerfYr2Rmrk == null) {
			return "";
		}
		else {
			return _dlrPerfYr2Rmrk;
		}
	}

	@Override
	public void setDlrPerfYr2Rmrk(String dlrPerfYr2Rmrk) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dlrPerfYr2Rmrk = dlrPerfYr2Rmrk;
	}

	@JSON
	@Override
	public long getDlrPerfYr3() {
		return _dlrPerfYr3;
	}

	@Override
	public void setDlrPerfYr3(long dlrPerfYr3) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dlrPerfYr3 = dlrPerfYr3;
	}

	@JSON
	@Override
	public long getDlrPerfYr3AllocQty() {
		return _dlrPerfYr3AllocQty;
	}

	@Override
	public void setDlrPerfYr3AllocQty(long dlrPerfYr3AllocQty) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dlrPerfYr3AllocQty = dlrPerfYr3AllocQty;
	}

	@JSON
	@Override
	public long getDlrPerfYr3ComdtyQty() {
		return _dlrPerfYr3ComdtyQty;
	}

	@Override
	public void setDlrPerfYr3ComdtyQty(long dlrPerfYr3ComdtyQty) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dlrPerfYr3ComdtyQty = dlrPerfYr3ComdtyQty;
	}

	@JSON
	@Override
	public String getDlrPerfYr3DlrCtgry() {
		if (_dlrPerfYr3DlrCtgry == null) {
			return "";
		}
		else {
			return _dlrPerfYr3DlrCtgry;
		}
	}

	@Override
	public void setDlrPerfYr3DlrCtgry(String dlrPerfYr3DlrCtgry) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dlrPerfYr3DlrCtgry = dlrPerfYr3DlrCtgry;
	}

	@JSON
	@Override
	public String getDlrPerfYr3Rmrk() {
		if (_dlrPerfYr3Rmrk == null) {
			return "";
		}
		else {
			return _dlrPerfYr3Rmrk;
		}
	}

	@Override
	public void setDlrPerfYr3Rmrk(String dlrPerfYr3Rmrk) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dlrPerfYr3Rmrk = dlrPerfYr3Rmrk;
	}

	@JSON
	@Override
	public long getVersion() {
		return _version;
	}

	@Override
	public void setVersion(long version) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_version = version;
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
			0, DgfDlrPerfDtls.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DgfDlrPerfDtls toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, DgfDlrPerfDtls>
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
		DgfDlrPerfDtlsImpl dgfDlrPerfDtlsImpl = new DgfDlrPerfDtlsImpl();

		dgfDlrPerfDtlsImpl.setDgfDlrPerfId(getDgfDlrPerfId());
		dgfDlrPerfDtlsImpl.setNationalId(getNationalId());
		dgfDlrPerfDtlsImpl.setDlrRegApplNo(getDlrRegApplNo());
		dgfDlrPerfDtlsImpl.setDlrRegNo(getDlrRegNo());
		dgfDlrPerfDtlsImpl.setDlrPerfYr1(getDlrPerfYr1());
		dgfDlrPerfDtlsImpl.setDlrPerfYr1AllocQty(getDlrPerfYr1AllocQty());
		dgfDlrPerfDtlsImpl.setDlrPerfYr1ComdtyQty(getDlrPerfYr1ComdtyQty());
		dgfDlrPerfDtlsImpl.setDlrPerfYr1DlrCtgry(getDlrPerfYr1DlrCtgry());
		dgfDlrPerfDtlsImpl.setDlrPerfYr1Rmrk(getDlrPerfYr1Rmrk());
		dgfDlrPerfDtlsImpl.setDlrPerfYr2(getDlrPerfYr2());
		dgfDlrPerfDtlsImpl.setDlrPerfYr2AllocQty(getDlrPerfYr2AllocQty());
		dgfDlrPerfDtlsImpl.setDlrPerfYr2ComdtyQty(getDlrPerfYr2ComdtyQty());
		dgfDlrPerfDtlsImpl.setDlrPerfYr2DlrCtgry(getDlrPerfYr2DlrCtgry());
		dgfDlrPerfDtlsImpl.setDlrPerfYr2Rmrk(getDlrPerfYr2Rmrk());
		dgfDlrPerfDtlsImpl.setDlrPerfYr3(getDlrPerfYr3());
		dgfDlrPerfDtlsImpl.setDlrPerfYr3AllocQty(getDlrPerfYr3AllocQty());
		dgfDlrPerfDtlsImpl.setDlrPerfYr3ComdtyQty(getDlrPerfYr3ComdtyQty());
		dgfDlrPerfDtlsImpl.setDlrPerfYr3DlrCtgry(getDlrPerfYr3DlrCtgry());
		dgfDlrPerfDtlsImpl.setDlrPerfYr3Rmrk(getDlrPerfYr3Rmrk());
		dgfDlrPerfDtlsImpl.setVersion(getVersion());

		dgfDlrPerfDtlsImpl.resetOriginalValues();

		return dgfDlrPerfDtlsImpl;
	}

	@Override
	public DgfDlrPerfDtls cloneWithOriginalValues() {
		DgfDlrPerfDtlsImpl dgfDlrPerfDtlsImpl = new DgfDlrPerfDtlsImpl();

		dgfDlrPerfDtlsImpl.setDgfDlrPerfId(
			this.<Long>getColumnOriginalValue("dgf_dlr_perf_id"));
		dgfDlrPerfDtlsImpl.setNationalId(
			this.<String>getColumnOriginalValue("national_id"));
		dgfDlrPerfDtlsImpl.setDlrRegApplNo(
			this.<Long>getColumnOriginalValue("dlr_reg_appl_no"));
		dgfDlrPerfDtlsImpl.setDlrRegNo(
			this.<Long>getColumnOriginalValue("dlr_reg_no"));
		dgfDlrPerfDtlsImpl.setDlrPerfYr1(
			this.<Long>getColumnOriginalValue("dlr_perf_yr1"));
		dgfDlrPerfDtlsImpl.setDlrPerfYr1AllocQty(
			this.<Long>getColumnOriginalValue("dlr_perf_yr1_alloc_qty"));
		dgfDlrPerfDtlsImpl.setDlrPerfYr1ComdtyQty(
			this.<Long>getColumnOriginalValue("dlr_perf_yr1_comdty_qty"));
		dgfDlrPerfDtlsImpl.setDlrPerfYr1DlrCtgry(
			this.<String>getColumnOriginalValue("dlr_perf_yr1_dlr_ctgry"));
		dgfDlrPerfDtlsImpl.setDlrPerfYr1Rmrk(
			this.<String>getColumnOriginalValue("dlr_perf_yr1_rmrk"));
		dgfDlrPerfDtlsImpl.setDlrPerfYr2(
			this.<Long>getColumnOriginalValue("dlr_perf_yr2"));
		dgfDlrPerfDtlsImpl.setDlrPerfYr2AllocQty(
			this.<Long>getColumnOriginalValue("dlr_perf_yr2_alloc_qty"));
		dgfDlrPerfDtlsImpl.setDlrPerfYr2ComdtyQty(
			this.<Long>getColumnOriginalValue("dlr_perf_yr2_comdty_qty"));
		dgfDlrPerfDtlsImpl.setDlrPerfYr2DlrCtgry(
			this.<String>getColumnOriginalValue("dlr_perf_yr2_dlr_ctgry"));
		dgfDlrPerfDtlsImpl.setDlrPerfYr2Rmrk(
			this.<String>getColumnOriginalValue("dlr_perf_yr2_rmrk"));
		dgfDlrPerfDtlsImpl.setDlrPerfYr3(
			this.<Long>getColumnOriginalValue("dlr_perf_yr3"));
		dgfDlrPerfDtlsImpl.setDlrPerfYr3AllocQty(
			this.<Long>getColumnOriginalValue("dlr_perf_yr3_alloc_qty"));
		dgfDlrPerfDtlsImpl.setDlrPerfYr3ComdtyQty(
			this.<Long>getColumnOriginalValue("dlr_perf_yr3_comdty_qty"));
		dgfDlrPerfDtlsImpl.setDlrPerfYr3DlrCtgry(
			this.<String>getColumnOriginalValue("dlr_perf_yr3_dlr_ctgry"));
		dgfDlrPerfDtlsImpl.setDlrPerfYr3Rmrk(
			this.<String>getColumnOriginalValue("dlr_perf_yr3_rmrk"));
		dgfDlrPerfDtlsImpl.setVersion(
			this.<Long>getColumnOriginalValue("version"));

		return dgfDlrPerfDtlsImpl;
	}

	@Override
	public int compareTo(DgfDlrPerfDtls dgfDlrPerfDtls) {
		long primaryKey = dgfDlrPerfDtls.getPrimaryKey();

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

		if (!(object instanceof DgfDlrPerfDtls)) {
			return false;
		}

		DgfDlrPerfDtls dgfDlrPerfDtls = (DgfDlrPerfDtls)object;

		long primaryKey = dgfDlrPerfDtls.getPrimaryKey();

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
	public CacheModel<DgfDlrPerfDtls> toCacheModel() {
		DgfDlrPerfDtlsCacheModel dgfDlrPerfDtlsCacheModel =
			new DgfDlrPerfDtlsCacheModel();

		dgfDlrPerfDtlsCacheModel.dgfDlrPerfId = getDgfDlrPerfId();

		dgfDlrPerfDtlsCacheModel.nationalId = getNationalId();

		String nationalId = dgfDlrPerfDtlsCacheModel.nationalId;

		if ((nationalId != null) && (nationalId.length() == 0)) {
			dgfDlrPerfDtlsCacheModel.nationalId = null;
		}

		dgfDlrPerfDtlsCacheModel.dlrRegApplNo = getDlrRegApplNo();

		dgfDlrPerfDtlsCacheModel.dlrRegNo = getDlrRegNo();

		dgfDlrPerfDtlsCacheModel.dlrPerfYr1 = getDlrPerfYr1();

		dgfDlrPerfDtlsCacheModel.dlrPerfYr1AllocQty = getDlrPerfYr1AllocQty();

		dgfDlrPerfDtlsCacheModel.dlrPerfYr1ComdtyQty = getDlrPerfYr1ComdtyQty();

		dgfDlrPerfDtlsCacheModel.dlrPerfYr1DlrCtgry = getDlrPerfYr1DlrCtgry();

		String dlrPerfYr1DlrCtgry = dgfDlrPerfDtlsCacheModel.dlrPerfYr1DlrCtgry;

		if ((dlrPerfYr1DlrCtgry != null) &&
			(dlrPerfYr1DlrCtgry.length() == 0)) {

			dgfDlrPerfDtlsCacheModel.dlrPerfYr1DlrCtgry = null;
		}

		dgfDlrPerfDtlsCacheModel.dlrPerfYr1Rmrk = getDlrPerfYr1Rmrk();

		String dlrPerfYr1Rmrk = dgfDlrPerfDtlsCacheModel.dlrPerfYr1Rmrk;

		if ((dlrPerfYr1Rmrk != null) && (dlrPerfYr1Rmrk.length() == 0)) {
			dgfDlrPerfDtlsCacheModel.dlrPerfYr1Rmrk = null;
		}

		dgfDlrPerfDtlsCacheModel.dlrPerfYr2 = getDlrPerfYr2();

		dgfDlrPerfDtlsCacheModel.dlrPerfYr2AllocQty = getDlrPerfYr2AllocQty();

		dgfDlrPerfDtlsCacheModel.dlrPerfYr2ComdtyQty = getDlrPerfYr2ComdtyQty();

		dgfDlrPerfDtlsCacheModel.dlrPerfYr2DlrCtgry = getDlrPerfYr2DlrCtgry();

		String dlrPerfYr2DlrCtgry = dgfDlrPerfDtlsCacheModel.dlrPerfYr2DlrCtgry;

		if ((dlrPerfYr2DlrCtgry != null) &&
			(dlrPerfYr2DlrCtgry.length() == 0)) {

			dgfDlrPerfDtlsCacheModel.dlrPerfYr2DlrCtgry = null;
		}

		dgfDlrPerfDtlsCacheModel.dlrPerfYr2Rmrk = getDlrPerfYr2Rmrk();

		String dlrPerfYr2Rmrk = dgfDlrPerfDtlsCacheModel.dlrPerfYr2Rmrk;

		if ((dlrPerfYr2Rmrk != null) && (dlrPerfYr2Rmrk.length() == 0)) {
			dgfDlrPerfDtlsCacheModel.dlrPerfYr2Rmrk = null;
		}

		dgfDlrPerfDtlsCacheModel.dlrPerfYr3 = getDlrPerfYr3();

		dgfDlrPerfDtlsCacheModel.dlrPerfYr3AllocQty = getDlrPerfYr3AllocQty();

		dgfDlrPerfDtlsCacheModel.dlrPerfYr3ComdtyQty = getDlrPerfYr3ComdtyQty();

		dgfDlrPerfDtlsCacheModel.dlrPerfYr3DlrCtgry = getDlrPerfYr3DlrCtgry();

		String dlrPerfYr3DlrCtgry = dgfDlrPerfDtlsCacheModel.dlrPerfYr3DlrCtgry;

		if ((dlrPerfYr3DlrCtgry != null) &&
			(dlrPerfYr3DlrCtgry.length() == 0)) {

			dgfDlrPerfDtlsCacheModel.dlrPerfYr3DlrCtgry = null;
		}

		dgfDlrPerfDtlsCacheModel.dlrPerfYr3Rmrk = getDlrPerfYr3Rmrk();

		String dlrPerfYr3Rmrk = dgfDlrPerfDtlsCacheModel.dlrPerfYr3Rmrk;

		if ((dlrPerfYr3Rmrk != null) && (dlrPerfYr3Rmrk.length() == 0)) {
			dgfDlrPerfDtlsCacheModel.dlrPerfYr3Rmrk = null;
		}

		dgfDlrPerfDtlsCacheModel.version = getVersion();

		return dgfDlrPerfDtlsCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DgfDlrPerfDtls, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DgfDlrPerfDtls, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DgfDlrPerfDtls, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((DgfDlrPerfDtls)this);

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

		private static final Function<InvocationHandler, DgfDlrPerfDtls>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					DgfDlrPerfDtls.class, ModelWrapper.class);

	}

	private long _dgfDlrPerfId;
	private String _nationalId;
	private long _dlrRegApplNo;
	private long _dlrRegNo;
	private long _dlrPerfYr1;
	private long _dlrPerfYr1AllocQty;
	private long _dlrPerfYr1ComdtyQty;
	private String _dlrPerfYr1DlrCtgry;
	private String _dlrPerfYr1Rmrk;
	private long _dlrPerfYr2;
	private long _dlrPerfYr2AllocQty;
	private long _dlrPerfYr2ComdtyQty;
	private String _dlrPerfYr2DlrCtgry;
	private String _dlrPerfYr2Rmrk;
	private long _dlrPerfYr3;
	private long _dlrPerfYr3AllocQty;
	private long _dlrPerfYr3ComdtyQty;
	private String _dlrPerfYr3DlrCtgry;
	private String _dlrPerfYr3Rmrk;
	private long _version;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<DgfDlrPerfDtls, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((DgfDlrPerfDtls)this);
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

		_columnOriginalValues.put("dgf_dlr_perf_id", _dgfDlrPerfId);
		_columnOriginalValues.put("national_id", _nationalId);
		_columnOriginalValues.put("dlr_reg_appl_no", _dlrRegApplNo);
		_columnOriginalValues.put("dlr_reg_no", _dlrRegNo);
		_columnOriginalValues.put("dlr_perf_yr1", _dlrPerfYr1);
		_columnOriginalValues.put(
			"dlr_perf_yr1_alloc_qty", _dlrPerfYr1AllocQty);
		_columnOriginalValues.put(
			"dlr_perf_yr1_comdty_qty", _dlrPerfYr1ComdtyQty);
		_columnOriginalValues.put(
			"dlr_perf_yr1_dlr_ctgry", _dlrPerfYr1DlrCtgry);
		_columnOriginalValues.put("dlr_perf_yr1_rmrk", _dlrPerfYr1Rmrk);
		_columnOriginalValues.put("dlr_perf_yr2", _dlrPerfYr2);
		_columnOriginalValues.put(
			"dlr_perf_yr2_alloc_qty", _dlrPerfYr2AllocQty);
		_columnOriginalValues.put(
			"dlr_perf_yr2_comdty_qty", _dlrPerfYr2ComdtyQty);
		_columnOriginalValues.put(
			"dlr_perf_yr2_dlr_ctgry", _dlrPerfYr2DlrCtgry);
		_columnOriginalValues.put("dlr_perf_yr2_rmrk", _dlrPerfYr2Rmrk);
		_columnOriginalValues.put("dlr_perf_yr3", _dlrPerfYr3);
		_columnOriginalValues.put(
			"dlr_perf_yr3_alloc_qty", _dlrPerfYr3AllocQty);
		_columnOriginalValues.put(
			"dlr_perf_yr3_comdty_qty", _dlrPerfYr3ComdtyQty);
		_columnOriginalValues.put(
			"dlr_perf_yr3_dlr_ctgry", _dlrPerfYr3DlrCtgry);
		_columnOriginalValues.put("dlr_perf_yr3_rmrk", _dlrPerfYr3Rmrk);
		_columnOriginalValues.put("version", _version);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("dgf_dlr_perf_id", "dgfDlrPerfId");
		attributeNames.put("national_id", "nationalId");
		attributeNames.put("dlr_reg_appl_no", "dlrRegApplNo");
		attributeNames.put("dlr_reg_no", "dlrRegNo");
		attributeNames.put("dlr_perf_yr1", "dlrPerfYr1");
		attributeNames.put("dlr_perf_yr1_alloc_qty", "dlrPerfYr1AllocQty");
		attributeNames.put("dlr_perf_yr1_comdty_qty", "dlrPerfYr1ComdtyQty");
		attributeNames.put("dlr_perf_yr1_dlr_ctgry", "dlrPerfYr1DlrCtgry");
		attributeNames.put("dlr_perf_yr1_rmrk", "dlrPerfYr1Rmrk");
		attributeNames.put("dlr_perf_yr2", "dlrPerfYr2");
		attributeNames.put("dlr_perf_yr2_alloc_qty", "dlrPerfYr2AllocQty");
		attributeNames.put("dlr_perf_yr2_comdty_qty", "dlrPerfYr2ComdtyQty");
		attributeNames.put("dlr_perf_yr2_dlr_ctgry", "dlrPerfYr2DlrCtgry");
		attributeNames.put("dlr_perf_yr2_rmrk", "dlrPerfYr2Rmrk");
		attributeNames.put("dlr_perf_yr3", "dlrPerfYr3");
		attributeNames.put("dlr_perf_yr3_alloc_qty", "dlrPerfYr3AllocQty");
		attributeNames.put("dlr_perf_yr3_comdty_qty", "dlrPerfYr3ComdtyQty");
		attributeNames.put("dlr_perf_yr3_dlr_ctgry", "dlrPerfYr3DlrCtgry");
		attributeNames.put("dlr_perf_yr3_rmrk", "dlrPerfYr3Rmrk");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("dgf_dlr_perf_id", 1L);

		columnBitmasks.put("national_id", 2L);

		columnBitmasks.put("dlr_reg_appl_no", 4L);

		columnBitmasks.put("dlr_reg_no", 8L);

		columnBitmasks.put("dlr_perf_yr1", 16L);

		columnBitmasks.put("dlr_perf_yr1_alloc_qty", 32L);

		columnBitmasks.put("dlr_perf_yr1_comdty_qty", 64L);

		columnBitmasks.put("dlr_perf_yr1_dlr_ctgry", 128L);

		columnBitmasks.put("dlr_perf_yr1_rmrk", 256L);

		columnBitmasks.put("dlr_perf_yr2", 512L);

		columnBitmasks.put("dlr_perf_yr2_alloc_qty", 1024L);

		columnBitmasks.put("dlr_perf_yr2_comdty_qty", 2048L);

		columnBitmasks.put("dlr_perf_yr2_dlr_ctgry", 4096L);

		columnBitmasks.put("dlr_perf_yr2_rmrk", 8192L);

		columnBitmasks.put("dlr_perf_yr3", 16384L);

		columnBitmasks.put("dlr_perf_yr3_alloc_qty", 32768L);

		columnBitmasks.put("dlr_perf_yr3_comdty_qty", 65536L);

		columnBitmasks.put("dlr_perf_yr3_dlr_ctgry", 131072L);

		columnBitmasks.put("dlr_perf_yr3_rmrk", 262144L);

		columnBitmasks.put("version", 524288L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private DgfDlrPerfDtls _escapedModel;

}