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

import bd.gov.dgfood.food.grain.license.model.DgfAttachments;
import bd.gov.dgfood.food.grain.license.model.DgfAttachmentsModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
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
 * The base model implementation for the DgfAttachments service. Represents a row in the &quot;dgf_attachments&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DgfAttachmentsModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DgfAttachmentsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfAttachmentsImpl
 * @generated
 */
@JSON(strict = true)
public class DgfAttachmentsModelImpl
	extends BaseModelImpl<DgfAttachments> implements DgfAttachmentsModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dgf attachments model instance should use the <code>DgfAttachments</code> interface instead.
	 */
	public static final String TABLE_NAME = "dgf_attachments";

	public static final Object[][] TABLE_COLUMNS = {
		{"attchmId", Types.BIGINT}, {"nationalId", Types.BIGINT},
		{"attachmentCatagory", Types.VARCHAR},
		{"attachmntDate", Types.TIMESTAMP}, {"fileEntryId", Types.BIGINT},
		{"title", Types.VARCHAR}, {"filePath", Types.VARCHAR},
		{"version", Types.BIGINT}, {"openTextId", Types.BIGINT},
		{"status", Types.BIGINT}, {"lastUpdatedDate", Types.TIMESTAMP},
		{"lastUpdatedBy", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("attchmId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("nationalId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("attachmentCatagory", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("attachmntDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("fileEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("filePath", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("version", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("openTextId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("status", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("lastUpdatedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("lastUpdatedBy", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table dgf_attachments (attchmId LONG not null primary key,nationalId LONG,attachmentCatagory VARCHAR(75) null,attachmntDate DATE null,fileEntryId LONG,title VARCHAR(1000) null,filePath VARCHAR(1000) null,version LONG,openTextId LONG,status LONG,lastUpdatedDate DATE null,lastUpdatedBy LONG)";

	public static final String TABLE_SQL_DROP = "drop table dgf_attachments";

	public static final String ORDER_BY_JPQL =
		" ORDER BY dgfAttachments.attchmId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY dgf_attachments.attchmId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ATTCHMID_COLUMN_BITMASK = 1L;

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

	public DgfAttachmentsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _attchmId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAttchmId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _attchmId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DgfAttachments.class;
	}

	@Override
	public String getModelClassName() {
		return DgfAttachments.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DgfAttachments, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DgfAttachments, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DgfAttachments, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((DgfAttachments)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DgfAttachments, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DgfAttachments, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DgfAttachments)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DgfAttachments, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DgfAttachments, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<DgfAttachments, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<DgfAttachments, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<DgfAttachments, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<DgfAttachments, Object>>();
		Map<String, BiConsumer<DgfAttachments, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<DgfAttachments, ?>>();

		attributeGetterFunctions.put("attchmId", DgfAttachments::getAttchmId);
		attributeSetterBiConsumers.put(
			"attchmId",
			(BiConsumer<DgfAttachments, Long>)DgfAttachments::setAttchmId);
		attributeGetterFunctions.put(
			"nationalId", DgfAttachments::getNationalId);
		attributeSetterBiConsumers.put(
			"nationalId",
			(BiConsumer<DgfAttachments, Long>)DgfAttachments::setNationalId);
		attributeGetterFunctions.put(
			"attachmentCatagory", DgfAttachments::getAttachmentCatagory);
		attributeSetterBiConsumers.put(
			"attachmentCatagory",
			(BiConsumer<DgfAttachments, String>)
				DgfAttachments::setAttachmentCatagory);
		attributeGetterFunctions.put(
			"attachmntDate", DgfAttachments::getAttachmntDate);
		attributeSetterBiConsumers.put(
			"attachmntDate",
			(BiConsumer<DgfAttachments, Date>)DgfAttachments::setAttachmntDate);
		attributeGetterFunctions.put(
			"fileEntryId", DgfAttachments::getFileEntryId);
		attributeSetterBiConsumers.put(
			"fileEntryId",
			(BiConsumer<DgfAttachments, Long>)DgfAttachments::setFileEntryId);
		attributeGetterFunctions.put("title", DgfAttachments::getTitle);
		attributeSetterBiConsumers.put(
			"title",
			(BiConsumer<DgfAttachments, String>)DgfAttachments::setTitle);
		attributeGetterFunctions.put("filePath", DgfAttachments::getFilePath);
		attributeSetterBiConsumers.put(
			"filePath",
			(BiConsumer<DgfAttachments, String>)DgfAttachments::setFilePath);
		attributeGetterFunctions.put("version", DgfAttachments::getVersion);
		attributeSetterBiConsumers.put(
			"version",
			(BiConsumer<DgfAttachments, Long>)DgfAttachments::setVersion);
		attributeGetterFunctions.put(
			"openTextId", DgfAttachments::getOpenTextId);
		attributeSetterBiConsumers.put(
			"openTextId",
			(BiConsumer<DgfAttachments, Long>)DgfAttachments::setOpenTextId);
		attributeGetterFunctions.put("status", DgfAttachments::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<DgfAttachments, Long>)DgfAttachments::setStatus);
		attributeGetterFunctions.put(
			"lastUpdatedDate", DgfAttachments::getLastUpdatedDate);
		attributeSetterBiConsumers.put(
			"lastUpdatedDate",
			(BiConsumer<DgfAttachments, Date>)
				DgfAttachments::setLastUpdatedDate);
		attributeGetterFunctions.put(
			"lastUpdatedBy", DgfAttachments::getLastUpdatedBy);
		attributeSetterBiConsumers.put(
			"lastUpdatedBy",
			(BiConsumer<DgfAttachments, Long>)DgfAttachments::setLastUpdatedBy);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getAttchmId() {
		return _attchmId;
	}

	@Override
	public void setAttchmId(long attchmId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_attchmId = attchmId;
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

	@JSON
	@Override
	public String getAttachmentCatagory() {
		if (_attachmentCatagory == null) {
			return "";
		}
		else {
			return _attachmentCatagory;
		}
	}

	@Override
	public void setAttachmentCatagory(String attachmentCatagory) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_attachmentCatagory = attachmentCatagory;
	}

	@JSON
	@Override
	public Date getAttachmntDate() {
		return _attachmntDate;
	}

	@Override
	public void setAttachmntDate(Date attachmntDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_attachmntDate = attachmntDate;
	}

	@JSON
	@Override
	public long getFileEntryId() {
		return _fileEntryId;
	}

	@Override
	public void setFileEntryId(long fileEntryId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fileEntryId = fileEntryId;
	}

	@JSON
	@Override
	public String getTitle() {
		if (_title == null) {
			return "";
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_title = title;
	}

	@JSON
	@Override
	public String getFilePath() {
		if (_filePath == null) {
			return "";
		}
		else {
			return _filePath;
		}
	}

	@Override
	public void setFilePath(String filePath) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_filePath = filePath;
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

	@JSON
	@Override
	public long getOpenTextId() {
		return _openTextId;
	}

	@Override
	public void setOpenTextId(long openTextId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_openTextId = openTextId;
	}

	@JSON
	@Override
	public long getStatus() {
		return _status;
	}

	@Override
	public void setStatus(long status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_status = status;
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
	public long getLastUpdatedBy() {
		return _lastUpdatedBy;
	}

	@Override
	public void setLastUpdatedBy(long lastUpdatedBy) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_lastUpdatedBy = lastUpdatedBy;
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
			0, DgfAttachments.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DgfAttachments toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, DgfAttachments>
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
		DgfAttachmentsImpl dgfAttachmentsImpl = new DgfAttachmentsImpl();

		dgfAttachmentsImpl.setAttchmId(getAttchmId());
		dgfAttachmentsImpl.setNationalId(getNationalId());
		dgfAttachmentsImpl.setAttachmentCatagory(getAttachmentCatagory());
		dgfAttachmentsImpl.setAttachmntDate(getAttachmntDate());
		dgfAttachmentsImpl.setFileEntryId(getFileEntryId());
		dgfAttachmentsImpl.setTitle(getTitle());
		dgfAttachmentsImpl.setFilePath(getFilePath());
		dgfAttachmentsImpl.setVersion(getVersion());
		dgfAttachmentsImpl.setOpenTextId(getOpenTextId());
		dgfAttachmentsImpl.setStatus(getStatus());
		dgfAttachmentsImpl.setLastUpdatedDate(getLastUpdatedDate());
		dgfAttachmentsImpl.setLastUpdatedBy(getLastUpdatedBy());

		dgfAttachmentsImpl.resetOriginalValues();

		return dgfAttachmentsImpl;
	}

	@Override
	public DgfAttachments cloneWithOriginalValues() {
		DgfAttachmentsImpl dgfAttachmentsImpl = new DgfAttachmentsImpl();

		dgfAttachmentsImpl.setAttchmId(
			this.<Long>getColumnOriginalValue("attchmId"));
		dgfAttachmentsImpl.setNationalId(
			this.<Long>getColumnOriginalValue("nationalId"));
		dgfAttachmentsImpl.setAttachmentCatagory(
			this.<String>getColumnOriginalValue("attachmentCatagory"));
		dgfAttachmentsImpl.setAttachmntDate(
			this.<Date>getColumnOriginalValue("attachmntDate"));
		dgfAttachmentsImpl.setFileEntryId(
			this.<Long>getColumnOriginalValue("fileEntryId"));
		dgfAttachmentsImpl.setTitle(
			this.<String>getColumnOriginalValue("title"));
		dgfAttachmentsImpl.setFilePath(
			this.<String>getColumnOriginalValue("filePath"));
		dgfAttachmentsImpl.setVersion(
			this.<Long>getColumnOriginalValue("version"));
		dgfAttachmentsImpl.setOpenTextId(
			this.<Long>getColumnOriginalValue("openTextId"));
		dgfAttachmentsImpl.setStatus(
			this.<Long>getColumnOriginalValue("status"));
		dgfAttachmentsImpl.setLastUpdatedDate(
			this.<Date>getColumnOriginalValue("lastUpdatedDate"));
		dgfAttachmentsImpl.setLastUpdatedBy(
			this.<Long>getColumnOriginalValue("lastUpdatedBy"));

		return dgfAttachmentsImpl;
	}

	@Override
	public int compareTo(DgfAttachments dgfAttachments) {
		long primaryKey = dgfAttachments.getPrimaryKey();

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

		if (!(object instanceof DgfAttachments)) {
			return false;
		}

		DgfAttachments dgfAttachments = (DgfAttachments)object;

		long primaryKey = dgfAttachments.getPrimaryKey();

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
	public CacheModel<DgfAttachments> toCacheModel() {
		DgfAttachmentsCacheModel dgfAttachmentsCacheModel =
			new DgfAttachmentsCacheModel();

		dgfAttachmentsCacheModel.attchmId = getAttchmId();

		dgfAttachmentsCacheModel.nationalId = getNationalId();

		dgfAttachmentsCacheModel.attachmentCatagory = getAttachmentCatagory();

		String attachmentCatagory = dgfAttachmentsCacheModel.attachmentCatagory;

		if ((attachmentCatagory != null) &&
			(attachmentCatagory.length() == 0)) {

			dgfAttachmentsCacheModel.attachmentCatagory = null;
		}

		Date attachmntDate = getAttachmntDate();

		if (attachmntDate != null) {
			dgfAttachmentsCacheModel.attachmntDate = attachmntDate.getTime();
		}
		else {
			dgfAttachmentsCacheModel.attachmntDate = Long.MIN_VALUE;
		}

		dgfAttachmentsCacheModel.fileEntryId = getFileEntryId();

		dgfAttachmentsCacheModel.title = getTitle();

		String title = dgfAttachmentsCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			dgfAttachmentsCacheModel.title = null;
		}

		dgfAttachmentsCacheModel.filePath = getFilePath();

		String filePath = dgfAttachmentsCacheModel.filePath;

		if ((filePath != null) && (filePath.length() == 0)) {
			dgfAttachmentsCacheModel.filePath = null;
		}

		dgfAttachmentsCacheModel.version = getVersion();

		dgfAttachmentsCacheModel.openTextId = getOpenTextId();

		dgfAttachmentsCacheModel.status = getStatus();

		Date lastUpdatedDate = getLastUpdatedDate();

		if (lastUpdatedDate != null) {
			dgfAttachmentsCacheModel.lastUpdatedDate =
				lastUpdatedDate.getTime();
		}
		else {
			dgfAttachmentsCacheModel.lastUpdatedDate = Long.MIN_VALUE;
		}

		dgfAttachmentsCacheModel.lastUpdatedBy = getLastUpdatedBy();

		return dgfAttachmentsCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DgfAttachments, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DgfAttachments, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DgfAttachments, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((DgfAttachments)this);

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

		private static final Function<InvocationHandler, DgfAttachments>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					DgfAttachments.class, ModelWrapper.class);

	}

	private long _attchmId;
	private long _nationalId;
	private String _attachmentCatagory;
	private Date _attachmntDate;
	private long _fileEntryId;
	private String _title;
	private String _filePath;
	private long _version;
	private long _openTextId;
	private long _status;
	private Date _lastUpdatedDate;
	private long _lastUpdatedBy;

	public <T> T getColumnValue(String columnName) {
		Function<DgfAttachments, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((DgfAttachments)this);
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

		_columnOriginalValues.put("attchmId", _attchmId);
		_columnOriginalValues.put("nationalId", _nationalId);
		_columnOriginalValues.put("attachmentCatagory", _attachmentCatagory);
		_columnOriginalValues.put("attachmntDate", _attachmntDate);
		_columnOriginalValues.put("fileEntryId", _fileEntryId);
		_columnOriginalValues.put("title", _title);
		_columnOriginalValues.put("filePath", _filePath);
		_columnOriginalValues.put("version", _version);
		_columnOriginalValues.put("openTextId", _openTextId);
		_columnOriginalValues.put("status", _status);
		_columnOriginalValues.put("lastUpdatedDate", _lastUpdatedDate);
		_columnOriginalValues.put("lastUpdatedBy", _lastUpdatedBy);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("attchmId", 1L);

		columnBitmasks.put("nationalId", 2L);

		columnBitmasks.put("attachmentCatagory", 4L);

		columnBitmasks.put("attachmntDate", 8L);

		columnBitmasks.put("fileEntryId", 16L);

		columnBitmasks.put("title", 32L);

		columnBitmasks.put("filePath", 64L);

		columnBitmasks.put("version", 128L);

		columnBitmasks.put("openTextId", 256L);

		columnBitmasks.put("status", 512L);

		columnBitmasks.put("lastUpdatedDate", 1024L);

		columnBitmasks.put("lastUpdatedBy", 2048L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private DgfAttachments _escapedModel;

}