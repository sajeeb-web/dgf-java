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

package bd.gov.dgfood.food.grain.license.service.persistence.impl;

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfFglLicenseNoException;
import bd.gov.dgfood.food.grain.license.model.DgfFglLicenseNo;
import bd.gov.dgfood.food.grain.license.model.DgfFglLicenseNoTable;
import bd.gov.dgfood.food.grain.license.model.impl.DgfFglLicenseNoImpl;
import bd.gov.dgfood.food.grain.license.model.impl.DgfFglLicenseNoModelImpl;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfFglLicenseNoPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfFglLicenseNoUtil;
import bd.gov.dgfood.food.grain.license.service.persistence.impl.constants.DGFPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the dgf fgl license no service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DgfFglLicenseNoPersistence.class)
public class DgfFglLicenseNoPersistenceImpl
	extends BasePersistenceImpl<DgfFglLicenseNo>
	implements DgfFglLicenseNoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DgfFglLicenseNoUtil</code> to access the dgf fgl license no persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DgfFglLicenseNoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByDgfFglLicenseNoBySerialNo;
	private FinderPath _finderPathCountByDgfFglLicenseNoBySerialNo;

	/**
	 * Returns the dgf fgl license no where serialNo = &#63; or throws a <code>NoSuchDgfFglLicenseNoException</code> if it could not be found.
	 *
	 * @param serialNo the serial no
	 * @return the matching dgf fgl license no
	 * @throws NoSuchDgfFglLicenseNoException if a matching dgf fgl license no could not be found
	 */
	@Override
	public DgfFglLicenseNo findByDgfFglLicenseNoBySerialNo(long serialNo)
		throws NoSuchDgfFglLicenseNoException {

		DgfFglLicenseNo dgfFglLicenseNo = fetchByDgfFglLicenseNoBySerialNo(
			serialNo);

		if (dgfFglLicenseNo == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("serialNo=");
			sb.append(serialNo);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfFglLicenseNoException(sb.toString());
		}

		return dgfFglLicenseNo;
	}

	/**
	 * Returns the dgf fgl license no where serialNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param serialNo the serial no
	 * @return the matching dgf fgl license no, or <code>null</code> if a matching dgf fgl license no could not be found
	 */
	@Override
	public DgfFglLicenseNo fetchByDgfFglLicenseNoBySerialNo(long serialNo) {
		return fetchByDgfFglLicenseNoBySerialNo(serialNo, true);
	}

	/**
	 * Returns the dgf fgl license no where serialNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param serialNo the serial no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf fgl license no, or <code>null</code> if a matching dgf fgl license no could not be found
	 */
	@Override
	public DgfFglLicenseNo fetchByDgfFglLicenseNoBySerialNo(
		long serialNo, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {serialNo};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDgfFglLicenseNoBySerialNo, finderArgs, this);
		}

		if (result instanceof DgfFglLicenseNo) {
			DgfFglLicenseNo dgfFglLicenseNo = (DgfFglLicenseNo)result;

			if (serialNo != dgfFglLicenseNo.getSerialNo()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DGFFGLLICENSENO_WHERE);

			sb.append(_FINDER_COLUMN_DGFFGLLICENSENOBYSERIALNO_SERIALNO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(serialNo);

				List<DgfFglLicenseNo> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDgfFglLicenseNoBySerialNo,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {serialNo};
							}

							_log.warn(
								"DgfFglLicenseNoPersistenceImpl.fetchByDgfFglLicenseNoBySerialNo(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DgfFglLicenseNo dgfFglLicenseNo = list.get(0);

					result = dgfFglLicenseNo;

					cacheResult(dgfFglLicenseNo);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (DgfFglLicenseNo)result;
		}
	}

	/**
	 * Removes the dgf fgl license no where serialNo = &#63; from the database.
	 *
	 * @param serialNo the serial no
	 * @return the dgf fgl license no that was removed
	 */
	@Override
	public DgfFglLicenseNo removeByDgfFglLicenseNoBySerialNo(long serialNo)
		throws NoSuchDgfFglLicenseNoException {

		DgfFglLicenseNo dgfFglLicenseNo = findByDgfFglLicenseNoBySerialNo(
			serialNo);

		return remove(dgfFglLicenseNo);
	}

	/**
	 * Returns the number of dgf fgl license nos where serialNo = &#63;.
	 *
	 * @param serialNo the serial no
	 * @return the number of matching dgf fgl license nos
	 */
	@Override
	public int countByDgfFglLicenseNoBySerialNo(long serialNo) {
		FinderPath finderPath = _finderPathCountByDgfFglLicenseNoBySerialNo;

		Object[] finderArgs = new Object[] {serialNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFFGLLICENSENO_WHERE);

			sb.append(_FINDER_COLUMN_DGFFGLLICENSENOBYSERIALNO_SERIALNO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(serialNo);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_DGFFGLLICENSENOBYSERIALNO_SERIALNO_2 =
			"dgfFglLicenseNo.serialNo = ?";

	public DgfFglLicenseNoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("serialNo", "serial_no");
		dbColumnNames.put("licenseNo", "license_no");
		dbColumnNames.put("createdAt", "created_at");
		dbColumnNames.put("updatedAt", "updated_at");

		setDBColumnNames(dbColumnNames);

		setModelClass(DgfFglLicenseNo.class);

		setModelImplClass(DgfFglLicenseNoImpl.class);
		setModelPKClass(long.class);

		setTable(DgfFglLicenseNoTable.INSTANCE);
	}

	/**
	 * Caches the dgf fgl license no in the entity cache if it is enabled.
	 *
	 * @param dgfFglLicenseNo the dgf fgl license no
	 */
	@Override
	public void cacheResult(DgfFglLicenseNo dgfFglLicenseNo) {
		entityCache.putResult(
			DgfFglLicenseNoImpl.class, dgfFglLicenseNo.getPrimaryKey(),
			dgfFglLicenseNo);

		finderCache.putResult(
			_finderPathFetchByDgfFglLicenseNoBySerialNo,
			new Object[] {dgfFglLicenseNo.getSerialNo()}, dgfFglLicenseNo);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dgf fgl license nos in the entity cache if it is enabled.
	 *
	 * @param dgfFglLicenseNos the dgf fgl license nos
	 */
	@Override
	public void cacheResult(List<DgfFglLicenseNo> dgfFglLicenseNos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgfFglLicenseNos.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DgfFglLicenseNo dgfFglLicenseNo : dgfFglLicenseNos) {
			if (entityCache.getResult(
					DgfFglLicenseNoImpl.class,
					dgfFglLicenseNo.getPrimaryKey()) == null) {

				cacheResult(dgfFglLicenseNo);
			}
		}
	}

	/**
	 * Clears the cache for all dgf fgl license nos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DgfFglLicenseNoImpl.class);

		finderCache.clearCache(DgfFglLicenseNoImpl.class);
	}

	/**
	 * Clears the cache for the dgf fgl license no.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DgfFglLicenseNo dgfFglLicenseNo) {
		entityCache.removeResult(DgfFglLicenseNoImpl.class, dgfFglLicenseNo);
	}

	@Override
	public void clearCache(List<DgfFglLicenseNo> dgfFglLicenseNos) {
		for (DgfFglLicenseNo dgfFglLicenseNo : dgfFglLicenseNos) {
			entityCache.removeResult(
				DgfFglLicenseNoImpl.class, dgfFglLicenseNo);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DgfFglLicenseNoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DgfFglLicenseNoImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DgfFglLicenseNoModelImpl dgfFglLicenseNoModelImpl) {

		Object[] args = new Object[] {dgfFglLicenseNoModelImpl.getSerialNo()};

		finderCache.putResult(
			_finderPathCountByDgfFglLicenseNoBySerialNo, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDgfFglLicenseNoBySerialNo, args,
			dgfFglLicenseNoModelImpl);
	}

	/**
	 * Creates a new dgf fgl license no with the primary key. Does not add the dgf fgl license no to the database.
	 *
	 * @param id the primary key for the new dgf fgl license no
	 * @return the new dgf fgl license no
	 */
	@Override
	public DgfFglLicenseNo create(long id) {
		DgfFglLicenseNo dgfFglLicenseNo = new DgfFglLicenseNoImpl();

		dgfFglLicenseNo.setNew(true);
		dgfFglLicenseNo.setPrimaryKey(id);

		return dgfFglLicenseNo;
	}

	/**
	 * Removes the dgf fgl license no with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dgf fgl license no
	 * @return the dgf fgl license no that was removed
	 * @throws NoSuchDgfFglLicenseNoException if a dgf fgl license no with the primary key could not be found
	 */
	@Override
	public DgfFglLicenseNo remove(long id)
		throws NoSuchDgfFglLicenseNoException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the dgf fgl license no with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dgf fgl license no
	 * @return the dgf fgl license no that was removed
	 * @throws NoSuchDgfFglLicenseNoException if a dgf fgl license no with the primary key could not be found
	 */
	@Override
	public DgfFglLicenseNo remove(Serializable primaryKey)
		throws NoSuchDgfFglLicenseNoException {

		Session session = null;

		try {
			session = openSession();

			DgfFglLicenseNo dgfFglLicenseNo = (DgfFglLicenseNo)session.get(
				DgfFglLicenseNoImpl.class, primaryKey);

			if (dgfFglLicenseNo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDgfFglLicenseNoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgfFglLicenseNo);
		}
		catch (NoSuchDgfFglLicenseNoException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected DgfFglLicenseNo removeImpl(DgfFglLicenseNo dgfFglLicenseNo) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgfFglLicenseNo)) {
				dgfFglLicenseNo = (DgfFglLicenseNo)session.get(
					DgfFglLicenseNoImpl.class,
					dgfFglLicenseNo.getPrimaryKeyObj());
			}

			if (dgfFglLicenseNo != null) {
				session.delete(dgfFglLicenseNo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgfFglLicenseNo != null) {
			clearCache(dgfFglLicenseNo);
		}

		return dgfFglLicenseNo;
	}

	@Override
	public DgfFglLicenseNo updateImpl(DgfFglLicenseNo dgfFglLicenseNo) {
		boolean isNew = dgfFglLicenseNo.isNew();

		if (!(dgfFglLicenseNo instanceof DgfFglLicenseNoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dgfFglLicenseNo.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dgfFglLicenseNo);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgfFglLicenseNo proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DgfFglLicenseNo implementation " +
					dgfFglLicenseNo.getClass());
		}

		DgfFglLicenseNoModelImpl dgfFglLicenseNoModelImpl =
			(DgfFglLicenseNoModelImpl)dgfFglLicenseNo;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgfFglLicenseNo);
			}
			else {
				dgfFglLicenseNo = (DgfFglLicenseNo)session.merge(
					dgfFglLicenseNo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DgfFglLicenseNoImpl.class, dgfFglLicenseNoModelImpl, false, true);

		cacheUniqueFindersCache(dgfFglLicenseNoModelImpl);

		if (isNew) {
			dgfFglLicenseNo.setNew(false);
		}

		dgfFglLicenseNo.resetOriginalValues();

		return dgfFglLicenseNo;
	}

	/**
	 * Returns the dgf fgl license no with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dgf fgl license no
	 * @return the dgf fgl license no
	 * @throws NoSuchDgfFglLicenseNoException if a dgf fgl license no with the primary key could not be found
	 */
	@Override
	public DgfFglLicenseNo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDgfFglLicenseNoException {

		DgfFglLicenseNo dgfFglLicenseNo = fetchByPrimaryKey(primaryKey);

		if (dgfFglLicenseNo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDgfFglLicenseNoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgfFglLicenseNo;
	}

	/**
	 * Returns the dgf fgl license no with the primary key or throws a <code>NoSuchDgfFglLicenseNoException</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf fgl license no
	 * @return the dgf fgl license no
	 * @throws NoSuchDgfFglLicenseNoException if a dgf fgl license no with the primary key could not be found
	 */
	@Override
	public DgfFglLicenseNo findByPrimaryKey(long id)
		throws NoSuchDgfFglLicenseNoException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the dgf fgl license no with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf fgl license no
	 * @return the dgf fgl license no, or <code>null</code> if a dgf fgl license no with the primary key could not be found
	 */
	@Override
	public DgfFglLicenseNo fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the dgf fgl license nos.
	 *
	 * @return the dgf fgl license nos
	 */
	@Override
	public List<DgfFglLicenseNo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf fgl license nos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglLicenseNoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl license nos
	 * @param end the upper bound of the range of dgf fgl license nos (not inclusive)
	 * @return the range of dgf fgl license nos
	 */
	@Override
	public List<DgfFglLicenseNo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf fgl license nos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglLicenseNoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl license nos
	 * @param end the upper bound of the range of dgf fgl license nos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf fgl license nos
	 */
	@Override
	public List<DgfFglLicenseNo> findAll(
		int start, int end,
		OrderByComparator<DgfFglLicenseNo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf fgl license nos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglLicenseNoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl license nos
	 * @param end the upper bound of the range of dgf fgl license nos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf fgl license nos
	 */
	@Override
	public List<DgfFglLicenseNo> findAll(
		int start, int end,
		OrderByComparator<DgfFglLicenseNo> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<DgfFglLicenseNo> list = null;

		if (useFinderCache) {
			list = (List<DgfFglLicenseNo>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFFGLLICENSENO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFFGLLICENSENO;

				sql = sql.concat(DgfFglLicenseNoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DgfFglLicenseNo>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the dgf fgl license nos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DgfFglLicenseNo dgfFglLicenseNo : findAll()) {
			remove(dgfFglLicenseNo);
		}
	}

	/**
	 * Returns the number of dgf fgl license nos.
	 *
	 * @return the number of dgf fgl license nos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DGFFGLLICENSENO);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DGFFGLLICENSENO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DgfFglLicenseNoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dgf fgl license no persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByDgfFglLicenseNoBySerialNo = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDgfFglLicenseNoBySerialNo",
			new String[] {Long.class.getName()}, new String[] {"serial_no"},
			true);

		_finderPathCountByDgfFglLicenseNoBySerialNo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDgfFglLicenseNoBySerialNo",
			new String[] {Long.class.getName()}, new String[] {"serial_no"},
			false);

		_setDgfFglLicenseNoUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDgfFglLicenseNoUtilPersistence(null);

		entityCache.removeCache(DgfFglLicenseNoImpl.class.getName());
	}

	private void _setDgfFglLicenseNoUtilPersistence(
		DgfFglLicenseNoPersistence dgfFglLicenseNoPersistence) {

		try {
			Field field = DgfFglLicenseNoUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dgfFglLicenseNoPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = DGFPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = DGFPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = DGFPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_DGFFGLLICENSENO =
		"SELECT dgfFglLicenseNo FROM DgfFglLicenseNo dgfFglLicenseNo";

	private static final String _SQL_SELECT_DGFFGLLICENSENO_WHERE =
		"SELECT dgfFglLicenseNo FROM DgfFglLicenseNo dgfFglLicenseNo WHERE ";

	private static final String _SQL_COUNT_DGFFGLLICENSENO =
		"SELECT COUNT(dgfFglLicenseNo) FROM DgfFglLicenseNo dgfFglLicenseNo";

	private static final String _SQL_COUNT_DGFFGLLICENSENO_WHERE =
		"SELECT COUNT(dgfFglLicenseNo) FROM DgfFglLicenseNo dgfFglLicenseNo WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dgfFglLicenseNo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DgfFglLicenseNo exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DgfFglLicenseNo exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DgfFglLicenseNoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"serialNo", "licenseNo", "createdAt", "updatedAt"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}