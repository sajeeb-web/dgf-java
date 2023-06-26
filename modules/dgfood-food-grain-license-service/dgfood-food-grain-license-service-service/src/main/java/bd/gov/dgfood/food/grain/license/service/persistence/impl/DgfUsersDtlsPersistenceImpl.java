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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfUsersDtlsException;
import bd.gov.dgfood.food.grain.license.model.DgfUsersDtls;
import bd.gov.dgfood.food.grain.license.model.DgfUsersDtlsTable;
import bd.gov.dgfood.food.grain.license.model.impl.DgfUsersDtlsImpl;
import bd.gov.dgfood.food.grain.license.model.impl.DgfUsersDtlsModelImpl;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfUsersDtlsPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfUsersDtlsUtil;
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
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the dgf users dtls service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DgfUsersDtlsPersistence.class)
public class DgfUsersDtlsPersistenceImpl
	extends BasePersistenceImpl<DgfUsersDtls>
	implements DgfUsersDtlsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DgfUsersDtlsUtil</code> to access the dgf users dtls persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DgfUsersDtlsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBydgfUsersDtlsByNationalId;
	private FinderPath _finderPathCountBydgfUsersDtlsByNationalId;

	/**
	 * Returns the dgf users dtls where nationalId = &#63; or throws a <code>NoSuchDgfUsersDtlsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf users dtls
	 * @throws NoSuchDgfUsersDtlsException if a matching dgf users dtls could not be found
	 */
	@Override
	public DgfUsersDtls findBydgfUsersDtlsByNationalId(long nationalId)
		throws NoSuchDgfUsersDtlsException {

		DgfUsersDtls dgfUsersDtls = fetchBydgfUsersDtlsByNationalId(nationalId);

		if (dgfUsersDtls == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("nationalId=");
			sb.append(nationalId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfUsersDtlsException(sb.toString());
		}

		return dgfUsersDtls;
	}

	/**
	 * Returns the dgf users dtls where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf users dtls, or <code>null</code> if a matching dgf users dtls could not be found
	 */
	@Override
	public DgfUsersDtls fetchBydgfUsersDtlsByNationalId(long nationalId) {
		return fetchBydgfUsersDtlsByNationalId(nationalId, true);
	}

	/**
	 * Returns the dgf users dtls where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf users dtls, or <code>null</code> if a matching dgf users dtls could not be found
	 */
	@Override
	public DgfUsersDtls fetchBydgfUsersDtlsByNationalId(
		long nationalId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {nationalId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBydgfUsersDtlsByNationalId, finderArgs, this);
		}

		if (result instanceof DgfUsersDtls) {
			DgfUsersDtls dgfUsersDtls = (DgfUsersDtls)result;

			if (nationalId != dgfUsersDtls.getNationalId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DGFUSERSDTLS_WHERE);

			sb.append(_FINDER_COLUMN_DGFUSERSDTLSBYNATIONALID_NATIONALID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(nationalId);

				List<DgfUsersDtls> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBydgfUsersDtlsByNationalId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {nationalId};
							}

							_log.warn(
								"DgfUsersDtlsPersistenceImpl.fetchBydgfUsersDtlsByNationalId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DgfUsersDtls dgfUsersDtls = list.get(0);

					result = dgfUsersDtls;

					cacheResult(dgfUsersDtls);
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
			return (DgfUsersDtls)result;
		}
	}

	/**
	 * Removes the dgf users dtls where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the dgf users dtls that was removed
	 */
	@Override
	public DgfUsersDtls removeBydgfUsersDtlsByNationalId(long nationalId)
		throws NoSuchDgfUsersDtlsException {

		DgfUsersDtls dgfUsersDtls = findBydgfUsersDtlsByNationalId(nationalId);

		return remove(dgfUsersDtls);
	}

	/**
	 * Returns the number of dgf users dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf users dtlses
	 */
	@Override
	public int countBydgfUsersDtlsByNationalId(long nationalId) {
		FinderPath finderPath = _finderPathCountBydgfUsersDtlsByNationalId;

		Object[] finderArgs = new Object[] {nationalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFUSERSDTLS_WHERE);

			sb.append(_FINDER_COLUMN_DGFUSERSDTLSBYNATIONALID_NATIONALID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(nationalId);

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
		_FINDER_COLUMN_DGFUSERSDTLSBYNATIONALID_NATIONALID_2 =
			"dgfUsersDtls.nationalId = ?";

	public DgfUsersDtlsPersistenceImpl() {
		setModelClass(DgfUsersDtls.class);

		setModelImplClass(DgfUsersDtlsImpl.class);
		setModelPKClass(long.class);

		setTable(DgfUsersDtlsTable.INSTANCE);
	}

	/**
	 * Caches the dgf users dtls in the entity cache if it is enabled.
	 *
	 * @param dgfUsersDtls the dgf users dtls
	 */
	@Override
	public void cacheResult(DgfUsersDtls dgfUsersDtls) {
		entityCache.putResult(
			DgfUsersDtlsImpl.class, dgfUsersDtls.getPrimaryKey(), dgfUsersDtls);

		finderCache.putResult(
			_finderPathFetchBydgfUsersDtlsByNationalId,
			new Object[] {dgfUsersDtls.getNationalId()}, dgfUsersDtls);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dgf users dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfUsersDtlses the dgf users dtlses
	 */
	@Override
	public void cacheResult(List<DgfUsersDtls> dgfUsersDtlses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgfUsersDtlses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DgfUsersDtls dgfUsersDtls : dgfUsersDtlses) {
			if (entityCache.getResult(
					DgfUsersDtlsImpl.class, dgfUsersDtls.getPrimaryKey()) ==
						null) {

				cacheResult(dgfUsersDtls);
			}
		}
	}

	/**
	 * Clears the cache for all dgf users dtlses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DgfUsersDtlsImpl.class);

		finderCache.clearCache(DgfUsersDtlsImpl.class);
	}

	/**
	 * Clears the cache for the dgf users dtls.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DgfUsersDtls dgfUsersDtls) {
		entityCache.removeResult(DgfUsersDtlsImpl.class, dgfUsersDtls);
	}

	@Override
	public void clearCache(List<DgfUsersDtls> dgfUsersDtlses) {
		for (DgfUsersDtls dgfUsersDtls : dgfUsersDtlses) {
			entityCache.removeResult(DgfUsersDtlsImpl.class, dgfUsersDtls);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DgfUsersDtlsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DgfUsersDtlsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DgfUsersDtlsModelImpl dgfUsersDtlsModelImpl) {

		Object[] args = new Object[] {dgfUsersDtlsModelImpl.getNationalId()};

		finderCache.putResult(
			_finderPathCountBydgfUsersDtlsByNationalId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchBydgfUsersDtlsByNationalId, args,
			dgfUsersDtlsModelImpl);
	}

	/**
	 * Creates a new dgf users dtls with the primary key. Does not add the dgf users dtls to the database.
	 *
	 * @param userDetailsId the primary key for the new dgf users dtls
	 * @return the new dgf users dtls
	 */
	@Override
	public DgfUsersDtls create(long userDetailsId) {
		DgfUsersDtls dgfUsersDtls = new DgfUsersDtlsImpl();

		dgfUsersDtls.setNew(true);
		dgfUsersDtls.setPrimaryKey(userDetailsId);

		return dgfUsersDtls;
	}

	/**
	 * Removes the dgf users dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userDetailsId the primary key of the dgf users dtls
	 * @return the dgf users dtls that was removed
	 * @throws NoSuchDgfUsersDtlsException if a dgf users dtls with the primary key could not be found
	 */
	@Override
	public DgfUsersDtls remove(long userDetailsId)
		throws NoSuchDgfUsersDtlsException {

		return remove((Serializable)userDetailsId);
	}

	/**
	 * Removes the dgf users dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dgf users dtls
	 * @return the dgf users dtls that was removed
	 * @throws NoSuchDgfUsersDtlsException if a dgf users dtls with the primary key could not be found
	 */
	@Override
	public DgfUsersDtls remove(Serializable primaryKey)
		throws NoSuchDgfUsersDtlsException {

		Session session = null;

		try {
			session = openSession();

			DgfUsersDtls dgfUsersDtls = (DgfUsersDtls)session.get(
				DgfUsersDtlsImpl.class, primaryKey);

			if (dgfUsersDtls == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDgfUsersDtlsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgfUsersDtls);
		}
		catch (NoSuchDgfUsersDtlsException noSuchEntityException) {
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
	protected DgfUsersDtls removeImpl(DgfUsersDtls dgfUsersDtls) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgfUsersDtls)) {
				dgfUsersDtls = (DgfUsersDtls)session.get(
					DgfUsersDtlsImpl.class, dgfUsersDtls.getPrimaryKeyObj());
			}

			if (dgfUsersDtls != null) {
				session.delete(dgfUsersDtls);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgfUsersDtls != null) {
			clearCache(dgfUsersDtls);
		}

		return dgfUsersDtls;
	}

	@Override
	public DgfUsersDtls updateImpl(DgfUsersDtls dgfUsersDtls) {
		boolean isNew = dgfUsersDtls.isNew();

		if (!(dgfUsersDtls instanceof DgfUsersDtlsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dgfUsersDtls.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dgfUsersDtls);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgfUsersDtls proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DgfUsersDtls implementation " +
					dgfUsersDtls.getClass());
		}

		DgfUsersDtlsModelImpl dgfUsersDtlsModelImpl =
			(DgfUsersDtlsModelImpl)dgfUsersDtls;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgfUsersDtls);
			}
			else {
				dgfUsersDtls = (DgfUsersDtls)session.merge(dgfUsersDtls);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DgfUsersDtlsImpl.class, dgfUsersDtlsModelImpl, false, true);

		cacheUniqueFindersCache(dgfUsersDtlsModelImpl);

		if (isNew) {
			dgfUsersDtls.setNew(false);
		}

		dgfUsersDtls.resetOriginalValues();

		return dgfUsersDtls;
	}

	/**
	 * Returns the dgf users dtls with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dgf users dtls
	 * @return the dgf users dtls
	 * @throws NoSuchDgfUsersDtlsException if a dgf users dtls with the primary key could not be found
	 */
	@Override
	public DgfUsersDtls findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDgfUsersDtlsException {

		DgfUsersDtls dgfUsersDtls = fetchByPrimaryKey(primaryKey);

		if (dgfUsersDtls == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDgfUsersDtlsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgfUsersDtls;
	}

	/**
	 * Returns the dgf users dtls with the primary key or throws a <code>NoSuchDgfUsersDtlsException</code> if it could not be found.
	 *
	 * @param userDetailsId the primary key of the dgf users dtls
	 * @return the dgf users dtls
	 * @throws NoSuchDgfUsersDtlsException if a dgf users dtls with the primary key could not be found
	 */
	@Override
	public DgfUsersDtls findByPrimaryKey(long userDetailsId)
		throws NoSuchDgfUsersDtlsException {

		return findByPrimaryKey((Serializable)userDetailsId);
	}

	/**
	 * Returns the dgf users dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userDetailsId the primary key of the dgf users dtls
	 * @return the dgf users dtls, or <code>null</code> if a dgf users dtls with the primary key could not be found
	 */
	@Override
	public DgfUsersDtls fetchByPrimaryKey(long userDetailsId) {
		return fetchByPrimaryKey((Serializable)userDetailsId);
	}

	/**
	 * Returns all the dgf users dtlses.
	 *
	 * @return the dgf users dtlses
	 */
	@Override
	public List<DgfUsersDtls> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf users dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users dtlses
	 * @param end the upper bound of the range of dgf users dtlses (not inclusive)
	 * @return the range of dgf users dtlses
	 */
	@Override
	public List<DgfUsersDtls> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf users dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users dtlses
	 * @param end the upper bound of the range of dgf users dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf users dtlses
	 */
	@Override
	public List<DgfUsersDtls> findAll(
		int start, int end, OrderByComparator<DgfUsersDtls> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf users dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users dtlses
	 * @param end the upper bound of the range of dgf users dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf users dtlses
	 */
	@Override
	public List<DgfUsersDtls> findAll(
		int start, int end, OrderByComparator<DgfUsersDtls> orderByComparator,
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

		List<DgfUsersDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfUsersDtls>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFUSERSDTLS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFUSERSDTLS;

				sql = sql.concat(DgfUsersDtlsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DgfUsersDtls>)QueryUtil.list(
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
	 * Removes all the dgf users dtlses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DgfUsersDtls dgfUsersDtls : findAll()) {
			remove(dgfUsersDtls);
		}
	}

	/**
	 * Returns the number of dgf users dtlses.
	 *
	 * @return the number of dgf users dtlses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DGFUSERSDTLS);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "userDetailsId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DGFUSERSDTLS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DgfUsersDtlsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dgf users dtls persistence.
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

		_finderPathFetchBydgfUsersDtlsByNationalId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBydgfUsersDtlsByNationalId",
			new String[] {Long.class.getName()}, new String[] {"nationalId"},
			true);

		_finderPathCountBydgfUsersDtlsByNationalId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfUsersDtlsByNationalId",
			new String[] {Long.class.getName()}, new String[] {"nationalId"},
			false);

		_setDgfUsersDtlsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDgfUsersDtlsUtilPersistence(null);

		entityCache.removeCache(DgfUsersDtlsImpl.class.getName());
	}

	private void _setDgfUsersDtlsUtilPersistence(
		DgfUsersDtlsPersistence dgfUsersDtlsPersistence) {

		try {
			Field field = DgfUsersDtlsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dgfUsersDtlsPersistence);
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

	private static final String _SQL_SELECT_DGFUSERSDTLS =
		"SELECT dgfUsersDtls FROM DgfUsersDtls dgfUsersDtls";

	private static final String _SQL_SELECT_DGFUSERSDTLS_WHERE =
		"SELECT dgfUsersDtls FROM DgfUsersDtls dgfUsersDtls WHERE ";

	private static final String _SQL_COUNT_DGFUSERSDTLS =
		"SELECT COUNT(dgfUsersDtls) FROM DgfUsersDtls dgfUsersDtls";

	private static final String _SQL_COUNT_DGFUSERSDTLS_WHERE =
		"SELECT COUNT(dgfUsersDtls) FROM DgfUsersDtls dgfUsersDtls WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dgfUsersDtls.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DgfUsersDtls exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DgfUsersDtls exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DgfUsersDtlsPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}