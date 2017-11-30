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

package com.liferay.portal.workflow.kaleo.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.workflow.kaleo.model.KaleoTimer;
import com.liferay.portal.workflow.kaleo.model.KaleoTimerModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the KaleoTimer service. Represents a row in the &quot;KaleoTimer&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link KaleoTimerModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link KaleoTimerImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KaleoTimerImpl
 * @see KaleoTimer
 * @see KaleoTimerModel
 * @generated
 */
@ProviderType
public class KaleoTimerModelImpl extends BaseModelImpl<KaleoTimer>
	implements KaleoTimerModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a kaleo timer model instance should use the {@link KaleoTimer} interface instead.
	 */
	public static final String TABLE_NAME = "KaleoTimer";
	public static final Object[][] TABLE_COLUMNS = {
			{ "kaleoTimerId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "kaleoClassName", Types.VARCHAR },
			{ "kaleoClassPK", Types.BIGINT },
			{ "kaleoDefinitionVersionId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "blocking", Types.BOOLEAN },
			{ "description", Types.VARCHAR },
			{ "duration", Types.DOUBLE },
			{ "scale", Types.VARCHAR },
			{ "recurrenceDuration", Types.DOUBLE },
			{ "recurrenceScale", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("kaleoTimerId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("kaleoClassName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("kaleoClassPK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("kaleoDefinitionVersionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("blocking", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("duration", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("scale", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("recurrenceDuration", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("recurrenceScale", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table KaleoTimer (kaleoTimerId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(200) null,createDate DATE null,modifiedDate DATE null,kaleoClassName VARCHAR(200) null,kaleoClassPK LONG,kaleoDefinitionVersionId LONG,name VARCHAR(75) null,blocking BOOLEAN,description STRING null,duration DOUBLE,scale VARCHAR(75) null,recurrenceDuration DOUBLE,recurrenceScale VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table KaleoTimer";
	public static final String ORDER_BY_JPQL = " ORDER BY kaleoTimer.kaleoTimerId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY KaleoTimer.kaleoTimerId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.workflow.kaleo.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.portal.workflow.kaleo.model.KaleoTimer"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.workflow.kaleo.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.portal.workflow.kaleo.model.KaleoTimer"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.workflow.kaleo.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.portal.workflow.kaleo.model.KaleoTimer"),
			true);
	public static final long BLOCKING_COLUMN_BITMASK = 1L;
	public static final long KALEOCLASSNAME_COLUMN_BITMASK = 2L;
	public static final long KALEOCLASSPK_COLUMN_BITMASK = 4L;
	public static final long KALEOTIMERID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.workflow.kaleo.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.portal.workflow.kaleo.model.KaleoTimer"));

	public KaleoTimerModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _kaleoTimerId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setKaleoTimerId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _kaleoTimerId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return KaleoTimer.class;
	}

	@Override
	public String getModelClassName() {
		return KaleoTimer.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("kaleoTimerId", getKaleoTimerId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("kaleoClassName", getKaleoClassName());
		attributes.put("kaleoClassPK", getKaleoClassPK());
		attributes.put("kaleoDefinitionVersionId", getKaleoDefinitionVersionId());
		attributes.put("name", getName());
		attributes.put("blocking", getBlocking());
		attributes.put("description", getDescription());
		attributes.put("duration", getDuration());
		attributes.put("scale", getScale());
		attributes.put("recurrenceDuration", getRecurrenceDuration());
		attributes.put("recurrenceScale", getRecurrenceScale());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long kaleoTimerId = (Long)attributes.get("kaleoTimerId");

		if (kaleoTimerId != null) {
			setKaleoTimerId(kaleoTimerId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String kaleoClassName = (String)attributes.get("kaleoClassName");

		if (kaleoClassName != null) {
			setKaleoClassName(kaleoClassName);
		}

		Long kaleoClassPK = (Long)attributes.get("kaleoClassPK");

		if (kaleoClassPK != null) {
			setKaleoClassPK(kaleoClassPK);
		}

		Long kaleoDefinitionVersionId = (Long)attributes.get(
				"kaleoDefinitionVersionId");

		if (kaleoDefinitionVersionId != null) {
			setKaleoDefinitionVersionId(kaleoDefinitionVersionId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Boolean blocking = (Boolean)attributes.get("blocking");

		if (blocking != null) {
			setBlocking(blocking);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Double duration = (Double)attributes.get("duration");

		if (duration != null) {
			setDuration(duration);
		}

		String scale = (String)attributes.get("scale");

		if (scale != null) {
			setScale(scale);
		}

		Double recurrenceDuration = (Double)attributes.get("recurrenceDuration");

		if (recurrenceDuration != null) {
			setRecurrenceDuration(recurrenceDuration);
		}

		String recurrenceScale = (String)attributes.get("recurrenceScale");

		if (recurrenceScale != null) {
			setRecurrenceScale(recurrenceScale);
		}
	}

	@Override
	public long getKaleoTimerId() {
		return _kaleoTimerId;
	}

	@Override
	public void setKaleoTimerId(long kaleoTimerId) {
		_columnBitmask = -1L;

		_kaleoTimerId = kaleoTimerId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

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

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getKaleoClassName() {
		if (_kaleoClassName == null) {
			return "";
		}
		else {
			return _kaleoClassName;
		}
	}

	@Override
	public void setKaleoClassName(String kaleoClassName) {
		_columnBitmask |= KALEOCLASSNAME_COLUMN_BITMASK;

		if (_originalKaleoClassName == null) {
			_originalKaleoClassName = _kaleoClassName;
		}

		_kaleoClassName = kaleoClassName;
	}

	public String getOriginalKaleoClassName() {
		return GetterUtil.getString(_originalKaleoClassName);
	}

	@Override
	public long getKaleoClassPK() {
		return _kaleoClassPK;
	}

	@Override
	public void setKaleoClassPK(long kaleoClassPK) {
		_columnBitmask |= KALEOCLASSPK_COLUMN_BITMASK;

		if (!_setOriginalKaleoClassPK) {
			_setOriginalKaleoClassPK = true;

			_originalKaleoClassPK = _kaleoClassPK;
		}

		_kaleoClassPK = kaleoClassPK;
	}

	public long getOriginalKaleoClassPK() {
		return _originalKaleoClassPK;
	}

	@Override
	public long getKaleoDefinitionVersionId() {
		return _kaleoDefinitionVersionId;
	}

	@Override
	public void setKaleoDefinitionVersionId(long kaleoDefinitionVersionId) {
		_kaleoDefinitionVersionId = kaleoDefinitionVersionId;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@Override
	public boolean getBlocking() {
		return _blocking;
	}

	@Override
	public boolean isBlocking() {
		return _blocking;
	}

	@Override
	public void setBlocking(boolean blocking) {
		_columnBitmask |= BLOCKING_COLUMN_BITMASK;

		if (!_setOriginalBlocking) {
			_setOriginalBlocking = true;

			_originalBlocking = _blocking;
		}

		_blocking = blocking;
	}

	public boolean getOriginalBlocking() {
		return _originalBlocking;
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public double getDuration() {
		return _duration;
	}

	@Override
	public void setDuration(double duration) {
		_duration = duration;
	}

	@Override
	public String getScale() {
		if (_scale == null) {
			return "";
		}
		else {
			return _scale;
		}
	}

	@Override
	public void setScale(String scale) {
		_scale = scale;
	}

	@Override
	public double getRecurrenceDuration() {
		return _recurrenceDuration;
	}

	@Override
	public void setRecurrenceDuration(double recurrenceDuration) {
		_recurrenceDuration = recurrenceDuration;
	}

	@Override
	public String getRecurrenceScale() {
		if (_recurrenceScale == null) {
			return "";
		}
		else {
			return _recurrenceScale;
		}
	}

	@Override
	public void setRecurrenceScale(String recurrenceScale) {
		_recurrenceScale = recurrenceScale;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			KaleoTimer.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public KaleoTimer toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (KaleoTimer)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		KaleoTimerImpl kaleoTimerImpl = new KaleoTimerImpl();

		kaleoTimerImpl.setKaleoTimerId(getKaleoTimerId());
		kaleoTimerImpl.setGroupId(getGroupId());
		kaleoTimerImpl.setCompanyId(getCompanyId());
		kaleoTimerImpl.setUserId(getUserId());
		kaleoTimerImpl.setUserName(getUserName());
		kaleoTimerImpl.setCreateDate(getCreateDate());
		kaleoTimerImpl.setModifiedDate(getModifiedDate());
		kaleoTimerImpl.setKaleoClassName(getKaleoClassName());
		kaleoTimerImpl.setKaleoClassPK(getKaleoClassPK());
		kaleoTimerImpl.setKaleoDefinitionVersionId(getKaleoDefinitionVersionId());
		kaleoTimerImpl.setName(getName());
		kaleoTimerImpl.setBlocking(getBlocking());
		kaleoTimerImpl.setDescription(getDescription());
		kaleoTimerImpl.setDuration(getDuration());
		kaleoTimerImpl.setScale(getScale());
		kaleoTimerImpl.setRecurrenceDuration(getRecurrenceDuration());
		kaleoTimerImpl.setRecurrenceScale(getRecurrenceScale());

		kaleoTimerImpl.resetOriginalValues();

		return kaleoTimerImpl;
	}

	@Override
	public int compareTo(KaleoTimer kaleoTimer) {
		int value = 0;

		if (getKaleoTimerId() < kaleoTimer.getKaleoTimerId()) {
			value = -1;
		}
		else if (getKaleoTimerId() > kaleoTimer.getKaleoTimerId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KaleoTimer)) {
			return false;
		}

		KaleoTimer kaleoTimer = (KaleoTimer)obj;

		long primaryKey = kaleoTimer.getPrimaryKey();

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

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		KaleoTimerModelImpl kaleoTimerModelImpl = this;

		kaleoTimerModelImpl._setModifiedDate = false;

		kaleoTimerModelImpl._originalKaleoClassName = kaleoTimerModelImpl._kaleoClassName;

		kaleoTimerModelImpl._originalKaleoClassPK = kaleoTimerModelImpl._kaleoClassPK;

		kaleoTimerModelImpl._setOriginalKaleoClassPK = false;

		kaleoTimerModelImpl._originalBlocking = kaleoTimerModelImpl._blocking;

		kaleoTimerModelImpl._setOriginalBlocking = false;

		kaleoTimerModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<KaleoTimer> toCacheModel() {
		KaleoTimerCacheModel kaleoTimerCacheModel = new KaleoTimerCacheModel();

		kaleoTimerCacheModel.kaleoTimerId = getKaleoTimerId();

		kaleoTimerCacheModel.groupId = getGroupId();

		kaleoTimerCacheModel.companyId = getCompanyId();

		kaleoTimerCacheModel.userId = getUserId();

		kaleoTimerCacheModel.userName = getUserName();

		String userName = kaleoTimerCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			kaleoTimerCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			kaleoTimerCacheModel.createDate = createDate.getTime();
		}
		else {
			kaleoTimerCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			kaleoTimerCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			kaleoTimerCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		kaleoTimerCacheModel.kaleoClassName = getKaleoClassName();

		String kaleoClassName = kaleoTimerCacheModel.kaleoClassName;

		if ((kaleoClassName != null) && (kaleoClassName.length() == 0)) {
			kaleoTimerCacheModel.kaleoClassName = null;
		}

		kaleoTimerCacheModel.kaleoClassPK = getKaleoClassPK();

		kaleoTimerCacheModel.kaleoDefinitionVersionId = getKaleoDefinitionVersionId();

		kaleoTimerCacheModel.name = getName();

		String name = kaleoTimerCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			kaleoTimerCacheModel.name = null;
		}

		kaleoTimerCacheModel.blocking = getBlocking();

		kaleoTimerCacheModel.description = getDescription();

		String description = kaleoTimerCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			kaleoTimerCacheModel.description = null;
		}

		kaleoTimerCacheModel.duration = getDuration();

		kaleoTimerCacheModel.scale = getScale();

		String scale = kaleoTimerCacheModel.scale;

		if ((scale != null) && (scale.length() == 0)) {
			kaleoTimerCacheModel.scale = null;
		}

		kaleoTimerCacheModel.recurrenceDuration = getRecurrenceDuration();

		kaleoTimerCacheModel.recurrenceScale = getRecurrenceScale();

		String recurrenceScale = kaleoTimerCacheModel.recurrenceScale;

		if ((recurrenceScale != null) && (recurrenceScale.length() == 0)) {
			kaleoTimerCacheModel.recurrenceScale = null;
		}

		return kaleoTimerCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{kaleoTimerId=");
		sb.append(getKaleoTimerId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", kaleoClassName=");
		sb.append(getKaleoClassName());
		sb.append(", kaleoClassPK=");
		sb.append(getKaleoClassPK());
		sb.append(", kaleoDefinitionVersionId=");
		sb.append(getKaleoDefinitionVersionId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", blocking=");
		sb.append(getBlocking());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", duration=");
		sb.append(getDuration());
		sb.append(", scale=");
		sb.append(getScale());
		sb.append(", recurrenceDuration=");
		sb.append(getRecurrenceDuration());
		sb.append(", recurrenceScale=");
		sb.append(getRecurrenceScale());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.workflow.kaleo.model.KaleoTimer");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>kaleoTimerId</column-name><column-value><![CDATA[");
		sb.append(getKaleoTimerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kaleoClassName</column-name><column-value><![CDATA[");
		sb.append(getKaleoClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kaleoClassPK</column-name><column-value><![CDATA[");
		sb.append(getKaleoClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kaleoDefinitionVersionId</column-name><column-value><![CDATA[");
		sb.append(getKaleoDefinitionVersionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>blocking</column-name><column-value><![CDATA[");
		sb.append(getBlocking());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>duration</column-name><column-value><![CDATA[");
		sb.append(getDuration());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scale</column-name><column-value><![CDATA[");
		sb.append(getScale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recurrenceDuration</column-name><column-value><![CDATA[");
		sb.append(getRecurrenceDuration());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recurrenceScale</column-name><column-value><![CDATA[");
		sb.append(getRecurrenceScale());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = KaleoTimer.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			KaleoTimer.class
		};
	private long _kaleoTimerId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _kaleoClassName;
	private String _originalKaleoClassName;
	private long _kaleoClassPK;
	private long _originalKaleoClassPK;
	private boolean _setOriginalKaleoClassPK;
	private long _kaleoDefinitionVersionId;
	private String _name;
	private boolean _blocking;
	private boolean _originalBlocking;
	private boolean _setOriginalBlocking;
	private String _description;
	private double _duration;
	private String _scale;
	private double _recurrenceDuration;
	private String _recurrenceScale;
	private long _columnBitmask;
	private KaleoTimer _escapedModel;
}