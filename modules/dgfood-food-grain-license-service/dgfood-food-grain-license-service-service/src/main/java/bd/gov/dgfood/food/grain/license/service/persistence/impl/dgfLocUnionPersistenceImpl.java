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

import bd.gov.dgfood.food.grain.license.exception.NoSuchdgfLocUnionException;
import bd.gov.dgfood.food.grain.license.model.dgfLocUnion;
import bd.gov.dgfood.food.grain.license.model.dgfLocUnionTable;
import bd.gov.dgfood.food.grain.license.model.impl.dgfLocUnionImpl;
import bd.gov.dgfood.food.grain.license.model.impl.dgfLocUnionModelImpl;
import bd.gov.dgfood.food.grain.license.service.persistence.dgfLocUnionPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.dgfLocUnionUtil;
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

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the dgf loc union service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = dgfLocUnionPersistence.class)
public class dgfLocUnionPersistenceImpl
	extends BasePersistenceImpl<dgfLocUnion> implements dgfLocUnionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>dgfLocUnionUtil</code> to access the dgf loc union persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		dgfLocUnionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBysubDisWiseUnFinder;
	private FinderPath _finderPathWithoutPaginationFindBysubDisWiseUnFinder;
	private FinderPath _finderPathCountBysubDisWiseUnFinder;

	/**
	 * Returns all the dgf loc unions where subdistrictId = &#63;.
	 *
	 * @param subdistrictId the subdistrict ID
	 * @return the matching dgf loc unions
	 */
	@Override
	public List<dgfLocUnion> findBysubDisWiseUnFinder(long subdistrictId) {
		return findBysubDisWiseUnFinder(
			subdistrictId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf loc unions where subdistrictId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocUnionModelImpl</code>.
	 * </p>
	 *
	 * @param subdistrictId the subdistrict ID
	 * @param start the lower bound of the range of dgf loc unions
	 * @param end the upper bound of the range of dgf loc unions (not inclusive)
	 * @return the range of matching dgf loc unions
	 */
	@Override
	public List<dgfLocUnion> findBysubDisWiseUnFinder(
		long subdistrictId, int start, int end) {

		return findBysubDisWiseUnFinder(subdistrictId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf loc unions where subdistrictId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocUnionModelImpl</code>.
	 * </p>
	 *
	 * @param subdistrictId the subdistrict ID
	 * @param start the lower bound of the range of dgf loc unions
	 * @param end the upper bound of the range of dgf loc unions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf loc unions
	 */
	@Override
	public List<dgfLocUnion> findBysubDisWiseUnFinder(
		long subdistrictId, int start, int end,
		OrderByComparator<dgfLocUnion> orderByComparator) {

		return findBysubDisWiseUnFinder(
			subdistrictId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf loc unions where subdistrictId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocUnionModelImpl</code>.
	 * </p>
	 *
	 * @param subdistrictId the subdistrict ID
	 * @param start the lower bound of the range of dgf loc unions
	 * @param end the upper bound of the range of dgf loc unions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf loc unions
	 */
	@Override
	public List<dgfLocUnion> findBysubDisWiseUnFinder(
		long subdistrictId, int start, int end,
		OrderByComparator<dgfLocUnion> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBysubDisWiseUnFinder;
				finderArgs = new Object[] {subdistrictId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBysubDisWiseUnFinder;
			finderArgs = new Object[] {
				subdistrictId, start, end, orderByComparator
			};
		}

		List<dgfLocUnion> list = null;

		if (useFinderCache) {
			list = (List<dgfLocUnion>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (dgfLocUnion dgfLocUnion : list) {
					if (subdistrictId != dgfLocUnion.getSubdistrictId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_DGFLOCUNION_WHERE);

			sb.append(_FINDER_COLUMN_SUBDISWISEUNFINDER_SUBDISTRICTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(dgfLocUnionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subdistrictId);

				list = (List<dgfLocUnion>)QueryUtil.list(
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
	 * Returns the first dgf loc union in the ordered set where subdistrictId = &#63;.
	 *
	 * @param subdistrictId the subdistrict ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf loc union
	 * @throws NoSuchdgfLocUnionException if a matching dgf loc union could not be found
	 */
	@Override
	public dgfLocUnion findBysubDisWiseUnFinder_First(
			long subdistrictId,
			OrderByComparator<dgfLocUnion> orderByComparator)
		throws NoSuchdgfLocUnionException {

		dgfLocUnion dgfLocUnion = fetchBysubDisWiseUnFinder_First(
			subdistrictId, orderByComparator);

		if (dgfLocUnion != null) {
			return dgfLocUnion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subdistrictId=");
		sb.append(subdistrictId);

		sb.append("}");

		throw new NoSuchdgfLocUnionException(sb.toString());
	}

	/**
	 * Returns the first dgf loc union in the ordered set where subdistrictId = &#63;.
	 *
	 * @param subdistrictId the subdistrict ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf loc union, or <code>null</code> if a matching dgf loc union could not be found
	 */
	@Override
	public dgfLocUnion fetchBysubDisWiseUnFinder_First(
		long subdistrictId, OrderByComparator<dgfLocUnion> orderByComparator) {

		List<dgfLocUnion> list = findBysubDisWiseUnFinder(
			subdistrictId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf loc union in the ordered set where subdistrictId = &#63;.
	 *
	 * @param subdistrictId the subdistrict ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf loc union
	 * @throws NoSuchdgfLocUnionException if a matching dgf loc union could not be found
	 */
	@Override
	public dgfLocUnion findBysubDisWiseUnFinder_Last(
			long subdistrictId,
			OrderByComparator<dgfLocUnion> orderByComparator)
		throws NoSuchdgfLocUnionException {

		dgfLocUnion dgfLocUnion = fetchBysubDisWiseUnFinder_Last(
			subdistrictId, orderByComparator);

		if (dgfLocUnion != null) {
			return dgfLocUnion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subdistrictId=");
		sb.append(subdistrictId);

		sb.append("}");

		throw new NoSuchdgfLocUnionException(sb.toString());
	}

	/**
	 * Returns the last dgf loc union in the ordered set where subdistrictId = &#63;.
	 *
	 * @param subdistrictId the subdistrict ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf loc union, or <code>null</code> if a matching dgf loc union could not be found
	 */
	@Override
	public dgfLocUnion fetchBysubDisWiseUnFinder_Last(
		long subdistrictId, OrderByComparator<dgfLocUnion> orderByComparator) {

		int count = countBysubDisWiseUnFinder(subdistrictId);

		if (count == 0) {
			return null;
		}

		List<dgfLocUnion> list = findBysubDisWiseUnFinder(
			subdistrictId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf loc unions before and after the current dgf loc union in the ordered set where subdistrictId = &#63;.
	 *
	 * @param id the primary key of the current dgf loc union
	 * @param subdistrictId the subdistrict ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf loc union
	 * @throws NoSuchdgfLocUnionException if a dgf loc union with the primary key could not be found
	 */
	@Override
	public dgfLocUnion[] findBysubDisWiseUnFinder_PrevAndNext(
			long id, long subdistrictId,
			OrderByComparator<dgfLocUnion> orderByComparator)
		throws NoSuchdgfLocUnionException {

		dgfLocUnion dgfLocUnion = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			dgfLocUnion[] array = new dgfLocUnionImpl[3];

			array[0] = getBysubDisWiseUnFinder_PrevAndNext(
				session, dgfLocUnion, subdistrictId, orderByComparator, true);

			array[1] = dgfLocUnion;

			array[2] = getBysubDisWiseUnFinder_PrevAndNext(
				session, dgfLocUnion, subdistrictId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected dgfLocUnion getBysubDisWiseUnFinder_PrevAndNext(
		Session session, dgfLocUnion dgfLocUnion, long subdistrictId,
		OrderByComparator<dgfLocUnion> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DGFLOCUNION_WHERE);

		sb.append(_FINDER_COLUMN_SUBDISWISEUNFINDER_SUBDISTRICTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(dgfLocUnionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(subdistrictId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dgfLocUnion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<dgfLocUnion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf loc unions where subdistrictId = &#63; from the database.
	 *
	 * @param subdistrictId the subdistrict ID
	 */
	@Override
	public void removeBysubDisWiseUnFinder(long subdistrictId) {
		for (dgfLocUnion dgfLocUnion :
				findBysubDisWiseUnFinder(
					subdistrictId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgfLocUnion);
		}
	}

	/**
	 * Returns the number of dgf loc unions where subdistrictId = &#63;.
	 *
	 * @param subdistrictId the subdistrict ID
	 * @return the number of matching dgf loc unions
	 */
	@Override
	public int countBysubDisWiseUnFinder(long subdistrictId) {
		FinderPath finderPath = _finderPathCountBysubDisWiseUnFinder;

		Object[] finderArgs = new Object[] {subdistrictId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFLOCUNION_WHERE);

			sb.append(_FINDER_COLUMN_SUBDISWISEUNFINDER_SUBDISTRICTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subdistrictId);

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
		_FINDER_COLUMN_SUBDISWISEUNFINDER_SUBDISTRICTID_2 =
			"dgfLocUnion.subdistrictId = ?";

	public dgfLocUnionPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(dgfLocUnion.class);

		setModelImplClass(dgfLocUnionImpl.class);
		setModelPKClass(long.class);

		setTable(dgfLocUnionTable.INSTANCE);
	}

	/**
	 * Caches the dgf loc union in the entity cache if it is enabled.
	 *
	 * @param dgfLocUnion the dgf loc union
	 */
	@Override
	public void cacheResult(dgfLocUnion dgfLocUnion) {
		entityCache.putResult(
			dgfLocUnionImpl.class, dgfLocUnion.getPrimaryKey(), dgfLocUnion);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dgf loc unions in the entity cache if it is enabled.
	 *
	 * @param dgfLocUnions the dgf loc unions
	 */
	@Override
	public void cacheResult(List<dgfLocUnion> dgfLocUnions) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgfLocUnions.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (dgfLocUnion dgfLocUnion : dgfLocUnions) {
			if (entityCache.getResult(
					dgfLocUnionImpl.class, dgfLocUnion.getPrimaryKey()) ==
						null) {

				cacheResult(dgfLocUnion);
			}
		}
	}

	/**
	 * Clears the cache for all dgf loc unions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(dgfLocUnionImpl.class);

		finderCache.clearCache(dgfLocUnionImpl.class);
	}

	/**
	 * Clears the cache for the dgf loc union.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(dgfLocUnion dgfLocUnion) {
		entityCache.removeResult(dgfLocUnionImpl.class, dgfLocUnion);
	}

	@Override
	public void clearCache(List<dgfLocUnion> dgfLocUnions) {
		for (dgfLocUnion dgfLocUnion : dgfLocUnions) {
			entityCache.removeResult(dgfLocUnionImpl.class, dgfLocUnion);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(dgfLocUnionImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(dgfLocUnionImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new dgf loc union with the primary key. Does not add the dgf loc union to the database.
	 *
	 * @param id the primary key for the new dgf loc union
	 * @return the new dgf loc union
	 */
	@Override
	public dgfLocUnion create(long id) {
		dgfLocUnion dgfLocUnion = new dgfLocUnionImpl();

		dgfLocUnion.setNew(true);
		dgfLocUnion.setPrimaryKey(id);

		return dgfLocUnion;
	}

	/**
	 * Removes the dgf loc union with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dgf loc union
	 * @return the dgf loc union that was removed
	 * @throws NoSuchdgfLocUnionException if a dgf loc union with the primary key could not be found
	 */
	@Override
	public dgfLocUnion remove(long id) throws NoSuchdgfLocUnionException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the dgf loc union with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dgf loc union
	 * @return the dgf loc union that was removed
	 * @throws NoSuchdgfLocUnionException if a dgf loc union with the primary key could not be found
	 */
	@Override
	public dgfLocUnion remove(Serializable primaryKey)
		throws NoSuchdgfLocUnionException {

		Session session = null;

		try {
			session = openSession();

			dgfLocUnion dgfLocUnion = (dgfLocUnion)session.get(
				dgfLocUnionImpl.class, primaryKey);

			if (dgfLocUnion == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchdgfLocUnionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgfLocUnion);
		}
		catch (NoSuchdgfLocUnionException noSuchEntityException) {
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
	protected dgfLocUnion removeImpl(dgfLocUnion dgfLocUnion) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgfLocUnion)) {
				dgfLocUnion = (dgfLocUnion)session.get(
					dgfLocUnionImpl.class, dgfLocUnion.getPrimaryKeyObj());
			}

			if (dgfLocUnion != null) {
				session.delete(dgfLocUnion);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgfLocUnion != null) {
			clearCache(dgfLocUnion);
		}

		return dgfLocUnion;
	}

	@Override
	public dgfLocUnion updateImpl(dgfLocUnion dgfLocUnion) {
		boolean isNew = dgfLocUnion.isNew();

		if (!(dgfLocUnion instanceof dgfLocUnionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dgfLocUnion.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(dgfLocUnion);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgfLocUnion proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom dgfLocUnion implementation " +
					dgfLocUnion.getClass());
		}

		dgfLocUnionModelImpl dgfLocUnionModelImpl =
			(dgfLocUnionModelImpl)dgfLocUnion;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgfLocUnion);
			}
			else {
				dgfLocUnion = (dgfLocUnion)session.merge(dgfLocUnion);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			dgfLocUnionImpl.class, dgfLocUnionModelImpl, false, true);

		if (isNew) {
			dgfLocUnion.setNew(false);
		}

		dgfLocUnion.resetOriginalValues();

		return dgfLocUnion;
	}

	/**
	 * Returns the dgf loc union with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dgf loc union
	 * @return the dgf loc union
	 * @throws NoSuchdgfLocUnionException if a dgf loc union with the primary key could not be found
	 */
	@Override
	public dgfLocUnion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchdgfLocUnionException {

		dgfLocUnion dgfLocUnion = fetchByPrimaryKey(primaryKey);

		if (dgfLocUnion == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchdgfLocUnionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgfLocUnion;
	}

	/**
	 * Returns the dgf loc union with the primary key or throws a <code>NoSuchdgfLocUnionException</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf loc union
	 * @return the dgf loc union
	 * @throws NoSuchdgfLocUnionException if a dgf loc union with the primary key could not be found
	 */
	@Override
	public dgfLocUnion findByPrimaryKey(long id)
		throws NoSuchdgfLocUnionException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the dgf loc union with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf loc union
	 * @return the dgf loc union, or <code>null</code> if a dgf loc union with the primary key could not be found
	 */
	@Override
	public dgfLocUnion fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the dgf loc unions.
	 *
	 * @return the dgf loc unions
	 */
	@Override
	public List<dgfLocUnion> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf loc unions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocUnionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc unions
	 * @param end the upper bound of the range of dgf loc unions (not inclusive)
	 * @return the range of dgf loc unions
	 */
	@Override
	public List<dgfLocUnion> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf loc unions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocUnionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc unions
	 * @param end the upper bound of the range of dgf loc unions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf loc unions
	 */
	@Override
	public List<dgfLocUnion> findAll(
		int start, int end, OrderByComparator<dgfLocUnion> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf loc unions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocUnionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc unions
	 * @param end the upper bound of the range of dgf loc unions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf loc unions
	 */
	@Override
	public List<dgfLocUnion> findAll(
		int start, int end, OrderByComparator<dgfLocUnion> orderByComparator,
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

		List<dgfLocUnion> list = null;

		if (useFinderCache) {
			list = (List<dgfLocUnion>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFLOCUNION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFLOCUNION;

				sql = sql.concat(dgfLocUnionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<dgfLocUnion>)QueryUtil.list(
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
	 * Removes all the dgf loc unions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (dgfLocUnion dgfLocUnion : findAll()) {
			remove(dgfLocUnion);
		}
	}

	/**
	 * Returns the number of dgf loc unions.
	 *
	 * @return the number of dgf loc unions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DGFLOCUNION);

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
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DGFLOCUNION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return dgfLocUnionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dgf loc union persistence.
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

		_finderPathWithPaginationFindBysubDisWiseUnFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysubDisWiseUnFinder",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"subdistrictId"}, true);

		_finderPathWithoutPaginationFindBysubDisWiseUnFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBysubDisWiseUnFinder", new String[] {Long.class.getName()},
			new String[] {"subdistrictId"}, true);

		_finderPathCountBysubDisWiseUnFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBysubDisWiseUnFinder", new String[] {Long.class.getName()},
			new String[] {"subdistrictId"}, false);

		_setdgfLocUnionUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setdgfLocUnionUtilPersistence(null);

		entityCache.removeCache(dgfLocUnionImpl.class.getName());
	}

	private void _setdgfLocUnionUtilPersistence(
		dgfLocUnionPersistence dgfLocUnionPersistence) {

		try {
			Field field = dgfLocUnionUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dgfLocUnionPersistence);
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

	private static final String _SQL_SELECT_DGFLOCUNION =
		"SELECT dgfLocUnion FROM dgfLocUnion dgfLocUnion";

	private static final String _SQL_SELECT_DGFLOCUNION_WHERE =
		"SELECT dgfLocUnion FROM dgfLocUnion dgfLocUnion WHERE ";

	private static final String _SQL_COUNT_DGFLOCUNION =
		"SELECT COUNT(dgfLocUnion) FROM dgfLocUnion dgfLocUnion";

	private static final String _SQL_COUNT_DGFLOCUNION_WHERE =
		"SELECT COUNT(dgfLocUnion) FROM dgfLocUnion dgfLocUnion WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dgfLocUnion.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No dgfLocUnion exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No dgfLocUnion exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		dgfLocUnionPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}