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

import bd.gov.dgfood.food.grain.license.exception.NoSuchlicnsUserRegsException;
import bd.gov.dgfood.food.grain.license.model.impl.licnsUserRegsImpl;
import bd.gov.dgfood.food.grain.license.model.impl.licnsUserRegsModelImpl;
import bd.gov.dgfood.food.grain.license.model.licnsUserRegs;
import bd.gov.dgfood.food.grain.license.model.licnsUserRegsTable;
import bd.gov.dgfood.food.grain.license.service.persistence.impl.constants.DGFPersistenceConstants;
import bd.gov.dgfood.food.grain.license.service.persistence.licnsUserRegsPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.licnsUserRegsUtil;

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

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the licns user regs service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = licnsUserRegsPersistence.class)
public class licnsUserRegsPersistenceImpl
	extends BasePersistenceImpl<licnsUserRegs>
	implements licnsUserRegsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>licnsUserRegsUtil</code> to access the licns user regs persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		licnsUserRegsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBylicnsUserRegsNid;
	private FinderPath _finderPathCountBylicnsUserRegsNid;

	/**
	 * Returns the licns user regs where nationalId = &#63; or throws a <code>NoSuchlicnsUserRegsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching licns user regs
	 * @throws NoSuchlicnsUserRegsException if a matching licns user regs could not be found
	 */
	@Override
	public licnsUserRegs findBylicnsUserRegsNid(String nationalId)
		throws NoSuchlicnsUserRegsException {

		licnsUserRegs licnsUserRegs = fetchBylicnsUserRegsNid(nationalId);

		if (licnsUserRegs == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("nationalId=");
			sb.append(nationalId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchlicnsUserRegsException(sb.toString());
		}

		return licnsUserRegs;
	}

	/**
	 * Returns the licns user regs where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching licns user regs, or <code>null</code> if a matching licns user regs could not be found
	 */
	@Override
	public licnsUserRegs fetchBylicnsUserRegsNid(String nationalId) {
		return fetchBylicnsUserRegsNid(nationalId, true);
	}

	/**
	 * Returns the licns user regs where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching licns user regs, or <code>null</code> if a matching licns user regs could not be found
	 */
	@Override
	public licnsUserRegs fetchBylicnsUserRegsNid(
		String nationalId, boolean useFinderCache) {

		nationalId = Objects.toString(nationalId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {nationalId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBylicnsUserRegsNid, finderArgs, this);
		}

		if (result instanceof licnsUserRegs) {
			licnsUserRegs licnsUserRegs = (licnsUserRegs)result;

			if (!Objects.equals(nationalId, licnsUserRegs.getNationalId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_LICNSUSERREGS_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_LICNSUSERREGSNID_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(_FINDER_COLUMN_LICNSUSERREGSNID_NATIONALID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNationalId) {
					queryPos.add(nationalId);
				}

				List<licnsUserRegs> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBylicnsUserRegsNid, finderArgs,
							list);
					}
				}
				else {
					licnsUserRegs licnsUserRegs = list.get(0);

					result = licnsUserRegs;

					cacheResult(licnsUserRegs);
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
			return (licnsUserRegs)result;
		}
	}

	/**
	 * Removes the licns user regs where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the licns user regs that was removed
	 */
	@Override
	public licnsUserRegs removeBylicnsUserRegsNid(String nationalId)
		throws NoSuchlicnsUserRegsException {

		licnsUserRegs licnsUserRegs = findBylicnsUserRegsNid(nationalId);

		return remove(licnsUserRegs);
	}

	/**
	 * Returns the number of licns user regses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching licns user regses
	 */
	@Override
	public int countBylicnsUserRegsNid(String nationalId) {
		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = _finderPathCountBylicnsUserRegsNid;

		Object[] finderArgs = new Object[] {nationalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LICNSUSERREGS_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_LICNSUSERREGSNID_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(_FINDER_COLUMN_LICNSUSERREGSNID_NATIONALID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNationalId) {
					queryPos.add(nationalId);
				}

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

	private static final String _FINDER_COLUMN_LICNSUSERREGSNID_NATIONALID_2 =
		"licnsUserRegs.nationalId = ?";

	private static final String _FINDER_COLUMN_LICNSUSERREGSNID_NATIONALID_3 =
		"(licnsUserRegs.nationalId IS NULL OR licnsUserRegs.nationalId = '')";

	public licnsUserRegsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("password", "password_");

		setDBColumnNames(dbColumnNames);

		setModelClass(licnsUserRegs.class);

		setModelImplClass(licnsUserRegsImpl.class);
		setModelPKClass(long.class);

		setTable(licnsUserRegsTable.INSTANCE);
	}

	/**
	 * Caches the licns user regs in the entity cache if it is enabled.
	 *
	 * @param licnsUserRegs the licns user regs
	 */
	@Override
	public void cacheResult(licnsUserRegs licnsUserRegs) {
		entityCache.putResult(
			licnsUserRegsImpl.class, licnsUserRegs.getPrimaryKey(),
			licnsUserRegs);

		finderCache.putResult(
			_finderPathFetchBylicnsUserRegsNid,
			new Object[] {licnsUserRegs.getNationalId()}, licnsUserRegs);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the licns user regses in the entity cache if it is enabled.
	 *
	 * @param licnsUserRegses the licns user regses
	 */
	@Override
	public void cacheResult(List<licnsUserRegs> licnsUserRegses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (licnsUserRegses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (licnsUserRegs licnsUserRegs : licnsUserRegses) {
			if (entityCache.getResult(
					licnsUserRegsImpl.class, licnsUserRegs.getPrimaryKey()) ==
						null) {

				cacheResult(licnsUserRegs);
			}
		}
	}

	/**
	 * Clears the cache for all licns user regses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(licnsUserRegsImpl.class);

		finderCache.clearCache(licnsUserRegsImpl.class);
	}

	/**
	 * Clears the cache for the licns user regs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(licnsUserRegs licnsUserRegs) {
		entityCache.removeResult(licnsUserRegsImpl.class, licnsUserRegs);
	}

	@Override
	public void clearCache(List<licnsUserRegs> licnsUserRegses) {
		for (licnsUserRegs licnsUserRegs : licnsUserRegses) {
			entityCache.removeResult(licnsUserRegsImpl.class, licnsUserRegs);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(licnsUserRegsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(licnsUserRegsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		licnsUserRegsModelImpl licnsUserRegsModelImpl) {

		Object[] args = new Object[] {licnsUserRegsModelImpl.getNationalId()};

		finderCache.putResult(
			_finderPathCountBylicnsUserRegsNid, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchBylicnsUserRegsNid, args, licnsUserRegsModelImpl);
	}

	/**
	 * Creates a new licns user regs with the primary key. Does not add the licns user regs to the database.
	 *
	 * @param licUserId the primary key for the new licns user regs
	 * @return the new licns user regs
	 */
	@Override
	public licnsUserRegs create(long licUserId) {
		licnsUserRegs licnsUserRegs = new licnsUserRegsImpl();

		licnsUserRegs.setNew(true);
		licnsUserRegs.setPrimaryKey(licUserId);

		return licnsUserRegs;
	}

	/**
	 * Removes the licns user regs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param licUserId the primary key of the licns user regs
	 * @return the licns user regs that was removed
	 * @throws NoSuchlicnsUserRegsException if a licns user regs with the primary key could not be found
	 */
	@Override
	public licnsUserRegs remove(long licUserId)
		throws NoSuchlicnsUserRegsException {

		return remove((Serializable)licUserId);
	}

	/**
	 * Removes the licns user regs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the licns user regs
	 * @return the licns user regs that was removed
	 * @throws NoSuchlicnsUserRegsException if a licns user regs with the primary key could not be found
	 */
	@Override
	public licnsUserRegs remove(Serializable primaryKey)
		throws NoSuchlicnsUserRegsException {

		Session session = null;

		try {
			session = openSession();

			licnsUserRegs licnsUserRegs = (licnsUserRegs)session.get(
				licnsUserRegsImpl.class, primaryKey);

			if (licnsUserRegs == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchlicnsUserRegsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(licnsUserRegs);
		}
		catch (NoSuchlicnsUserRegsException noSuchEntityException) {
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
	protected licnsUserRegs removeImpl(licnsUserRegs licnsUserRegs) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(licnsUserRegs)) {
				licnsUserRegs = (licnsUserRegs)session.get(
					licnsUserRegsImpl.class, licnsUserRegs.getPrimaryKeyObj());
			}

			if (licnsUserRegs != null) {
				session.delete(licnsUserRegs);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (licnsUserRegs != null) {
			clearCache(licnsUserRegs);
		}

		return licnsUserRegs;
	}

	@Override
	public licnsUserRegs updateImpl(licnsUserRegs licnsUserRegs) {
		boolean isNew = licnsUserRegs.isNew();

		if (!(licnsUserRegs instanceof licnsUserRegsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(licnsUserRegs.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					licnsUserRegs);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in licnsUserRegs proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom licnsUserRegs implementation " +
					licnsUserRegs.getClass());
		}

		licnsUserRegsModelImpl licnsUserRegsModelImpl =
			(licnsUserRegsModelImpl)licnsUserRegs;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(licnsUserRegs);
			}
			else {
				licnsUserRegs = (licnsUserRegs)session.merge(licnsUserRegs);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			licnsUserRegsImpl.class, licnsUserRegsModelImpl, false, true);

		cacheUniqueFindersCache(licnsUserRegsModelImpl);

		if (isNew) {
			licnsUserRegs.setNew(false);
		}

		licnsUserRegs.resetOriginalValues();

		return licnsUserRegs;
	}

	/**
	 * Returns the licns user regs with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the licns user regs
	 * @return the licns user regs
	 * @throws NoSuchlicnsUserRegsException if a licns user regs with the primary key could not be found
	 */
	@Override
	public licnsUserRegs findByPrimaryKey(Serializable primaryKey)
		throws NoSuchlicnsUserRegsException {

		licnsUserRegs licnsUserRegs = fetchByPrimaryKey(primaryKey);

		if (licnsUserRegs == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchlicnsUserRegsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return licnsUserRegs;
	}

	/**
	 * Returns the licns user regs with the primary key or throws a <code>NoSuchlicnsUserRegsException</code> if it could not be found.
	 *
	 * @param licUserId the primary key of the licns user regs
	 * @return the licns user regs
	 * @throws NoSuchlicnsUserRegsException if a licns user regs with the primary key could not be found
	 */
	@Override
	public licnsUserRegs findByPrimaryKey(long licUserId)
		throws NoSuchlicnsUserRegsException {

		return findByPrimaryKey((Serializable)licUserId);
	}

	/**
	 * Returns the licns user regs with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param licUserId the primary key of the licns user regs
	 * @return the licns user regs, or <code>null</code> if a licns user regs with the primary key could not be found
	 */
	@Override
	public licnsUserRegs fetchByPrimaryKey(long licUserId) {
		return fetchByPrimaryKey((Serializable)licUserId);
	}

	/**
	 * Returns all the licns user regses.
	 *
	 * @return the licns user regses
	 */
	@Override
	public List<licnsUserRegs> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the licns user regses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>licnsUserRegsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of licns user regses
	 * @param end the upper bound of the range of licns user regses (not inclusive)
	 * @return the range of licns user regses
	 */
	@Override
	public List<licnsUserRegs> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the licns user regses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>licnsUserRegsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of licns user regses
	 * @param end the upper bound of the range of licns user regses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of licns user regses
	 */
	@Override
	public List<licnsUserRegs> findAll(
		int start, int end,
		OrderByComparator<licnsUserRegs> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the licns user regses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>licnsUserRegsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of licns user regses
	 * @param end the upper bound of the range of licns user regses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of licns user regses
	 */
	@Override
	public List<licnsUserRegs> findAll(
		int start, int end, OrderByComparator<licnsUserRegs> orderByComparator,
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

		List<licnsUserRegs> list = null;

		if (useFinderCache) {
			list = (List<licnsUserRegs>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LICNSUSERREGS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LICNSUSERREGS;

				sql = sql.concat(licnsUserRegsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<licnsUserRegs>)QueryUtil.list(
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
	 * Removes all the licns user regses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (licnsUserRegs licnsUserRegs : findAll()) {
			remove(licnsUserRegs);
		}
	}

	/**
	 * Returns the number of licns user regses.
	 *
	 * @return the number of licns user regses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LICNSUSERREGS);

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
		return "licUserId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LICNSUSERREGS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return licnsUserRegsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the licns user regs persistence.
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

		_finderPathFetchBylicnsUserRegsNid = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBylicnsUserRegsNid",
			new String[] {String.class.getName()}, new String[] {"nationalId"},
			true);

		_finderPathCountBylicnsUserRegsNid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBylicnsUserRegsNid", new String[] {String.class.getName()},
			new String[] {"nationalId"}, false);

		_setlicnsUserRegsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setlicnsUserRegsUtilPersistence(null);

		entityCache.removeCache(licnsUserRegsImpl.class.getName());
	}

	private void _setlicnsUserRegsUtilPersistence(
		licnsUserRegsPersistence licnsUserRegsPersistence) {

		try {
			Field field = licnsUserRegsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, licnsUserRegsPersistence);
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

	private static final String _SQL_SELECT_LICNSUSERREGS =
		"SELECT licnsUserRegs FROM licnsUserRegs licnsUserRegs";

	private static final String _SQL_SELECT_LICNSUSERREGS_WHERE =
		"SELECT licnsUserRegs FROM licnsUserRegs licnsUserRegs WHERE ";

	private static final String _SQL_COUNT_LICNSUSERREGS =
		"SELECT COUNT(licnsUserRegs) FROM licnsUserRegs licnsUserRegs";

	private static final String _SQL_COUNT_LICNSUSERREGS_WHERE =
		"SELECT COUNT(licnsUserRegs) FROM licnsUserRegs licnsUserRegs WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "licnsUserRegs.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No licnsUserRegs exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No licnsUserRegs exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		licnsUserRegsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"password"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}