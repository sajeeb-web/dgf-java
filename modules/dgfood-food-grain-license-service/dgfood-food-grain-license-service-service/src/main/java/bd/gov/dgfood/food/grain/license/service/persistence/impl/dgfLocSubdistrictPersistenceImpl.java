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

import bd.gov.dgfood.food.grain.license.exception.NoSuchdgfLocSubdistrictException;
import bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict;
import bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrictTable;
import bd.gov.dgfood.food.grain.license.model.impl.dgfLocSubdistrictImpl;
import bd.gov.dgfood.food.grain.license.model.impl.dgfLocSubdistrictModelImpl;
import bd.gov.dgfood.food.grain.license.service.persistence.dgfLocSubdistrictPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.dgfLocSubdistrictUtil;
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
 * The persistence implementation for the dgf loc subdistrict service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = dgfLocSubdistrictPersistence.class)
public class dgfLocSubdistrictPersistenceImpl
	extends BasePersistenceImpl<dgfLocSubdistrict>
	implements dgfLocSubdistrictPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>dgfLocSubdistrictUtil</code> to access the dgf loc subdistrict persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		dgfLocSubdistrictImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBydisWiseSubDisFinder;
	private FinderPath _finderPathWithoutPaginationFindBydisWiseSubDisFinder;
	private FinderPath _finderPathCountBydisWiseSubDisFinder;

	/**
	 * Returns all the dgf loc subdistricts where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @return the matching dgf loc subdistricts
	 */
	@Override
	public List<dgfLocSubdistrict> findBydisWiseSubDisFinder(long districtId) {
		return findBydisWiseSubDisFinder(
			districtId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf loc subdistricts where districtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocSubdistrictModelImpl</code>.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param start the lower bound of the range of dgf loc subdistricts
	 * @param end the upper bound of the range of dgf loc subdistricts (not inclusive)
	 * @return the range of matching dgf loc subdistricts
	 */
	@Override
	public List<dgfLocSubdistrict> findBydisWiseSubDisFinder(
		long districtId, int start, int end) {

		return findBydisWiseSubDisFinder(districtId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf loc subdistricts where districtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocSubdistrictModelImpl</code>.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param start the lower bound of the range of dgf loc subdistricts
	 * @param end the upper bound of the range of dgf loc subdistricts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf loc subdistricts
	 */
	@Override
	public List<dgfLocSubdistrict> findBydisWiseSubDisFinder(
		long districtId, int start, int end,
		OrderByComparator<dgfLocSubdistrict> orderByComparator) {

		return findBydisWiseSubDisFinder(
			districtId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf loc subdistricts where districtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocSubdistrictModelImpl</code>.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param start the lower bound of the range of dgf loc subdistricts
	 * @param end the upper bound of the range of dgf loc subdistricts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf loc subdistricts
	 */
	@Override
	public List<dgfLocSubdistrict> findBydisWiseSubDisFinder(
		long districtId, int start, int end,
		OrderByComparator<dgfLocSubdistrict> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydisWiseSubDisFinder;
				finderArgs = new Object[] {districtId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBydisWiseSubDisFinder;
			finderArgs = new Object[] {
				districtId, start, end, orderByComparator
			};
		}

		List<dgfLocSubdistrict> list = null;

		if (useFinderCache) {
			list = (List<dgfLocSubdistrict>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (dgfLocSubdistrict dgfLocSubdistrict : list) {
					if (districtId != dgfLocSubdistrict.getDistrictId()) {
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

			sb.append(_SQL_SELECT_DGFLOCSUBDISTRICT_WHERE);

			sb.append(_FINDER_COLUMN_DISWISESUBDISFINDER_DISTRICTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(dgfLocSubdistrictModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(districtId);

				list = (List<dgfLocSubdistrict>)QueryUtil.list(
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
	 * Returns the first dgf loc subdistrict in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf loc subdistrict
	 * @throws NoSuchdgfLocSubdistrictException if a matching dgf loc subdistrict could not be found
	 */
	@Override
	public dgfLocSubdistrict findBydisWiseSubDisFinder_First(
			long districtId,
			OrderByComparator<dgfLocSubdistrict> orderByComparator)
		throws NoSuchdgfLocSubdistrictException {

		dgfLocSubdistrict dgfLocSubdistrict = fetchBydisWiseSubDisFinder_First(
			districtId, orderByComparator);

		if (dgfLocSubdistrict != null) {
			return dgfLocSubdistrict;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("districtId=");
		sb.append(districtId);

		sb.append("}");

		throw new NoSuchdgfLocSubdistrictException(sb.toString());
	}

	/**
	 * Returns the first dgf loc subdistrict in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf loc subdistrict, or <code>null</code> if a matching dgf loc subdistrict could not be found
	 */
	@Override
	public dgfLocSubdistrict fetchBydisWiseSubDisFinder_First(
		long districtId,
		OrderByComparator<dgfLocSubdistrict> orderByComparator) {

		List<dgfLocSubdistrict> list = findBydisWiseSubDisFinder(
			districtId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf loc subdistrict in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf loc subdistrict
	 * @throws NoSuchdgfLocSubdistrictException if a matching dgf loc subdistrict could not be found
	 */
	@Override
	public dgfLocSubdistrict findBydisWiseSubDisFinder_Last(
			long districtId,
			OrderByComparator<dgfLocSubdistrict> orderByComparator)
		throws NoSuchdgfLocSubdistrictException {

		dgfLocSubdistrict dgfLocSubdistrict = fetchBydisWiseSubDisFinder_Last(
			districtId, orderByComparator);

		if (dgfLocSubdistrict != null) {
			return dgfLocSubdistrict;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("districtId=");
		sb.append(districtId);

		sb.append("}");

		throw new NoSuchdgfLocSubdistrictException(sb.toString());
	}

	/**
	 * Returns the last dgf loc subdistrict in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf loc subdistrict, or <code>null</code> if a matching dgf loc subdistrict could not be found
	 */
	@Override
	public dgfLocSubdistrict fetchBydisWiseSubDisFinder_Last(
		long districtId,
		OrderByComparator<dgfLocSubdistrict> orderByComparator) {

		int count = countBydisWiseSubDisFinder(districtId);

		if (count == 0) {
			return null;
		}

		List<dgfLocSubdistrict> list = findBydisWiseSubDisFinder(
			districtId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf loc subdistricts before and after the current dgf loc subdistrict in the ordered set where districtId = &#63;.
	 *
	 * @param id the primary key of the current dgf loc subdistrict
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf loc subdistrict
	 * @throws NoSuchdgfLocSubdistrictException if a dgf loc subdistrict with the primary key could not be found
	 */
	@Override
	public dgfLocSubdistrict[] findBydisWiseSubDisFinder_PrevAndNext(
			long id, long districtId,
			OrderByComparator<dgfLocSubdistrict> orderByComparator)
		throws NoSuchdgfLocSubdistrictException {

		dgfLocSubdistrict dgfLocSubdistrict = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			dgfLocSubdistrict[] array = new dgfLocSubdistrictImpl[3];

			array[0] = getBydisWiseSubDisFinder_PrevAndNext(
				session, dgfLocSubdistrict, districtId, orderByComparator,
				true);

			array[1] = dgfLocSubdistrict;

			array[2] = getBydisWiseSubDisFinder_PrevAndNext(
				session, dgfLocSubdistrict, districtId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected dgfLocSubdistrict getBydisWiseSubDisFinder_PrevAndNext(
		Session session, dgfLocSubdistrict dgfLocSubdistrict, long districtId,
		OrderByComparator<dgfLocSubdistrict> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DGFLOCSUBDISTRICT_WHERE);

		sb.append(_FINDER_COLUMN_DISWISESUBDISFINDER_DISTRICTID_2);

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
			sb.append(dgfLocSubdistrictModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(districtId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfLocSubdistrict)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<dgfLocSubdistrict> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf loc subdistricts where districtId = &#63; from the database.
	 *
	 * @param districtId the district ID
	 */
	@Override
	public void removeBydisWiseSubDisFinder(long districtId) {
		for (dgfLocSubdistrict dgfLocSubdistrict :
				findBydisWiseSubDisFinder(
					districtId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgfLocSubdistrict);
		}
	}

	/**
	 * Returns the number of dgf loc subdistricts where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @return the number of matching dgf loc subdistricts
	 */
	@Override
	public int countBydisWiseSubDisFinder(long districtId) {
		FinderPath finderPath = _finderPathCountBydisWiseSubDisFinder;

		Object[] finderArgs = new Object[] {districtId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFLOCSUBDISTRICT_WHERE);

			sb.append(_FINDER_COLUMN_DISWISESUBDISFINDER_DISTRICTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(districtId);

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
		_FINDER_COLUMN_DISWISESUBDISFINDER_DISTRICTID_2 =
			"dgfLocSubdistrict.districtId = ?";

	public dgfLocSubdistrictPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(dgfLocSubdistrict.class);

		setModelImplClass(dgfLocSubdistrictImpl.class);
		setModelPKClass(long.class);

		setTable(dgfLocSubdistrictTable.INSTANCE);
	}

	/**
	 * Caches the dgf loc subdistrict in the entity cache if it is enabled.
	 *
	 * @param dgfLocSubdistrict the dgf loc subdistrict
	 */
	@Override
	public void cacheResult(dgfLocSubdistrict dgfLocSubdistrict) {
		entityCache.putResult(
			dgfLocSubdistrictImpl.class, dgfLocSubdistrict.getPrimaryKey(),
			dgfLocSubdistrict);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dgf loc subdistricts in the entity cache if it is enabled.
	 *
	 * @param dgfLocSubdistricts the dgf loc subdistricts
	 */
	@Override
	public void cacheResult(List<dgfLocSubdistrict> dgfLocSubdistricts) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgfLocSubdistricts.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (dgfLocSubdistrict dgfLocSubdistrict : dgfLocSubdistricts) {
			if (entityCache.getResult(
					dgfLocSubdistrictImpl.class,
					dgfLocSubdistrict.getPrimaryKey()) == null) {

				cacheResult(dgfLocSubdistrict);
			}
		}
	}

	/**
	 * Clears the cache for all dgf loc subdistricts.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(dgfLocSubdistrictImpl.class);

		finderCache.clearCache(dgfLocSubdistrictImpl.class);
	}

	/**
	 * Clears the cache for the dgf loc subdistrict.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(dgfLocSubdistrict dgfLocSubdistrict) {
		entityCache.removeResult(
			dgfLocSubdistrictImpl.class, dgfLocSubdistrict);
	}

	@Override
	public void clearCache(List<dgfLocSubdistrict> dgfLocSubdistricts) {
		for (dgfLocSubdistrict dgfLocSubdistrict : dgfLocSubdistricts) {
			entityCache.removeResult(
				dgfLocSubdistrictImpl.class, dgfLocSubdistrict);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(dgfLocSubdistrictImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(dgfLocSubdistrictImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new dgf loc subdistrict with the primary key. Does not add the dgf loc subdistrict to the database.
	 *
	 * @param id the primary key for the new dgf loc subdistrict
	 * @return the new dgf loc subdistrict
	 */
	@Override
	public dgfLocSubdistrict create(long id) {
		dgfLocSubdistrict dgfLocSubdistrict = new dgfLocSubdistrictImpl();

		dgfLocSubdistrict.setNew(true);
		dgfLocSubdistrict.setPrimaryKey(id);

		return dgfLocSubdistrict;
	}

	/**
	 * Removes the dgf loc subdistrict with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dgf loc subdistrict
	 * @return the dgf loc subdistrict that was removed
	 * @throws NoSuchdgfLocSubdistrictException if a dgf loc subdistrict with the primary key could not be found
	 */
	@Override
	public dgfLocSubdistrict remove(long id)
		throws NoSuchdgfLocSubdistrictException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the dgf loc subdistrict with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dgf loc subdistrict
	 * @return the dgf loc subdistrict that was removed
	 * @throws NoSuchdgfLocSubdistrictException if a dgf loc subdistrict with the primary key could not be found
	 */
	@Override
	public dgfLocSubdistrict remove(Serializable primaryKey)
		throws NoSuchdgfLocSubdistrictException {

		Session session = null;

		try {
			session = openSession();

			dgfLocSubdistrict dgfLocSubdistrict =
				(dgfLocSubdistrict)session.get(
					dgfLocSubdistrictImpl.class, primaryKey);

			if (dgfLocSubdistrict == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchdgfLocSubdistrictException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgfLocSubdistrict);
		}
		catch (NoSuchdgfLocSubdistrictException noSuchEntityException) {
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
	protected dgfLocSubdistrict removeImpl(
		dgfLocSubdistrict dgfLocSubdistrict) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgfLocSubdistrict)) {
				dgfLocSubdistrict = (dgfLocSubdistrict)session.get(
					dgfLocSubdistrictImpl.class,
					dgfLocSubdistrict.getPrimaryKeyObj());
			}

			if (dgfLocSubdistrict != null) {
				session.delete(dgfLocSubdistrict);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgfLocSubdistrict != null) {
			clearCache(dgfLocSubdistrict);
		}

		return dgfLocSubdistrict;
	}

	@Override
	public dgfLocSubdistrict updateImpl(dgfLocSubdistrict dgfLocSubdistrict) {
		boolean isNew = dgfLocSubdistrict.isNew();

		if (!(dgfLocSubdistrict instanceof dgfLocSubdistrictModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dgfLocSubdistrict.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dgfLocSubdistrict);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgfLocSubdistrict proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom dgfLocSubdistrict implementation " +
					dgfLocSubdistrict.getClass());
		}

		dgfLocSubdistrictModelImpl dgfLocSubdistrictModelImpl =
			(dgfLocSubdistrictModelImpl)dgfLocSubdistrict;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgfLocSubdistrict);
			}
			else {
				dgfLocSubdistrict = (dgfLocSubdistrict)session.merge(
					dgfLocSubdistrict);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			dgfLocSubdistrictImpl.class, dgfLocSubdistrictModelImpl, false,
			true);

		if (isNew) {
			dgfLocSubdistrict.setNew(false);
		}

		dgfLocSubdistrict.resetOriginalValues();

		return dgfLocSubdistrict;
	}

	/**
	 * Returns the dgf loc subdistrict with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dgf loc subdistrict
	 * @return the dgf loc subdistrict
	 * @throws NoSuchdgfLocSubdistrictException if a dgf loc subdistrict with the primary key could not be found
	 */
	@Override
	public dgfLocSubdistrict findByPrimaryKey(Serializable primaryKey)
		throws NoSuchdgfLocSubdistrictException {

		dgfLocSubdistrict dgfLocSubdistrict = fetchByPrimaryKey(primaryKey);

		if (dgfLocSubdistrict == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchdgfLocSubdistrictException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgfLocSubdistrict;
	}

	/**
	 * Returns the dgf loc subdistrict with the primary key or throws a <code>NoSuchdgfLocSubdistrictException</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf loc subdistrict
	 * @return the dgf loc subdistrict
	 * @throws NoSuchdgfLocSubdistrictException if a dgf loc subdistrict with the primary key could not be found
	 */
	@Override
	public dgfLocSubdistrict findByPrimaryKey(long id)
		throws NoSuchdgfLocSubdistrictException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the dgf loc subdistrict with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf loc subdistrict
	 * @return the dgf loc subdistrict, or <code>null</code> if a dgf loc subdistrict with the primary key could not be found
	 */
	@Override
	public dgfLocSubdistrict fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the dgf loc subdistricts.
	 *
	 * @return the dgf loc subdistricts
	 */
	@Override
	public List<dgfLocSubdistrict> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf loc subdistricts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocSubdistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc subdistricts
	 * @param end the upper bound of the range of dgf loc subdistricts (not inclusive)
	 * @return the range of dgf loc subdistricts
	 */
	@Override
	public List<dgfLocSubdistrict> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf loc subdistricts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocSubdistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc subdistricts
	 * @param end the upper bound of the range of dgf loc subdistricts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf loc subdistricts
	 */
	@Override
	public List<dgfLocSubdistrict> findAll(
		int start, int end,
		OrderByComparator<dgfLocSubdistrict> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf loc subdistricts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocSubdistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc subdistricts
	 * @param end the upper bound of the range of dgf loc subdistricts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf loc subdistricts
	 */
	@Override
	public List<dgfLocSubdistrict> findAll(
		int start, int end,
		OrderByComparator<dgfLocSubdistrict> orderByComparator,
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

		List<dgfLocSubdistrict> list = null;

		if (useFinderCache) {
			list = (List<dgfLocSubdistrict>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFLOCSUBDISTRICT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFLOCSUBDISTRICT;

				sql = sql.concat(dgfLocSubdistrictModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<dgfLocSubdistrict>)QueryUtil.list(
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
	 * Removes all the dgf loc subdistricts from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (dgfLocSubdistrict dgfLocSubdistrict : findAll()) {
			remove(dgfLocSubdistrict);
		}
	}

	/**
	 * Returns the number of dgf loc subdistricts.
	 *
	 * @return the number of dgf loc subdistricts
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DGFLOCSUBDISTRICT);

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
		return _SQL_SELECT_DGFLOCSUBDISTRICT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return dgfLocSubdistrictModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dgf loc subdistrict persistence.
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

		_finderPathWithPaginationFindBydisWiseSubDisFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBydisWiseSubDisFinder",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"districtId"}, true);

		_finderPathWithoutPaginationFindBydisWiseSubDisFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBydisWiseSubDisFinder", new String[] {Long.class.getName()},
			new String[] {"districtId"}, true);

		_finderPathCountBydisWiseSubDisFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydisWiseSubDisFinder", new String[] {Long.class.getName()},
			new String[] {"districtId"}, false);

		_setdgfLocSubdistrictUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setdgfLocSubdistrictUtilPersistence(null);

		entityCache.removeCache(dgfLocSubdistrictImpl.class.getName());
	}

	private void _setdgfLocSubdistrictUtilPersistence(
		dgfLocSubdistrictPersistence dgfLocSubdistrictPersistence) {

		try {
			Field field = dgfLocSubdistrictUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dgfLocSubdistrictPersistence);
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

	private static final String _SQL_SELECT_DGFLOCSUBDISTRICT =
		"SELECT dgfLocSubdistrict FROM dgfLocSubdistrict dgfLocSubdistrict";

	private static final String _SQL_SELECT_DGFLOCSUBDISTRICT_WHERE =
		"SELECT dgfLocSubdistrict FROM dgfLocSubdistrict dgfLocSubdistrict WHERE ";

	private static final String _SQL_COUNT_DGFLOCSUBDISTRICT =
		"SELECT COUNT(dgfLocSubdistrict) FROM dgfLocSubdistrict dgfLocSubdistrict";

	private static final String _SQL_COUNT_DGFLOCSUBDISTRICT_WHERE =
		"SELECT COUNT(dgfLocSubdistrict) FROM dgfLocSubdistrict dgfLocSubdistrict WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dgfLocSubdistrict.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No dgfLocSubdistrict exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No dgfLocSubdistrict exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		dgfLocSubdistrictPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}