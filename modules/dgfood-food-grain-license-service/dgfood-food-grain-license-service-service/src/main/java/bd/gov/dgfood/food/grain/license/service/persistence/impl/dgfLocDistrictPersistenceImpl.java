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

import bd.gov.dgfood.food.grain.license.exception.NoSuchdgfLocDistrictException;
import bd.gov.dgfood.food.grain.license.model.dgfLocDistrict;
import bd.gov.dgfood.food.grain.license.model.dgfLocDistrictTable;
import bd.gov.dgfood.food.grain.license.model.impl.dgfLocDistrictImpl;
import bd.gov.dgfood.food.grain.license.model.impl.dgfLocDistrictModelImpl;
import bd.gov.dgfood.food.grain.license.service.persistence.dgfLocDistrictPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.dgfLocDistrictUtil;
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
 * The persistence implementation for the dgf loc district service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = dgfLocDistrictPersistence.class)
public class dgfLocDistrictPersistenceImpl
	extends BasePersistenceImpl<dgfLocDistrict>
	implements dgfLocDistrictPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>dgfLocDistrictUtil</code> to access the dgf loc district persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		dgfLocDistrictImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBydivWiseDisFinder;
	private FinderPath _finderPathWithoutPaginationFindBydivWiseDisFinder;
	private FinderPath _finderPathCountBydivWiseDisFinder;

	/**
	 * Returns all the dgf loc districts where divisionId = &#63;.
	 *
	 * @param divisionId the division ID
	 * @return the matching dgf loc districts
	 */
	@Override
	public List<dgfLocDistrict> findBydivWiseDisFinder(long divisionId) {
		return findBydivWiseDisFinder(
			divisionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf loc districts where divisionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocDistrictModelImpl</code>.
	 * </p>
	 *
	 * @param divisionId the division ID
	 * @param start the lower bound of the range of dgf loc districts
	 * @param end the upper bound of the range of dgf loc districts (not inclusive)
	 * @return the range of matching dgf loc districts
	 */
	@Override
	public List<dgfLocDistrict> findBydivWiseDisFinder(
		long divisionId, int start, int end) {

		return findBydivWiseDisFinder(divisionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf loc districts where divisionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocDistrictModelImpl</code>.
	 * </p>
	 *
	 * @param divisionId the division ID
	 * @param start the lower bound of the range of dgf loc districts
	 * @param end the upper bound of the range of dgf loc districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf loc districts
	 */
	@Override
	public List<dgfLocDistrict> findBydivWiseDisFinder(
		long divisionId, int start, int end,
		OrderByComparator<dgfLocDistrict> orderByComparator) {

		return findBydivWiseDisFinder(
			divisionId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf loc districts where divisionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocDistrictModelImpl</code>.
	 * </p>
	 *
	 * @param divisionId the division ID
	 * @param start the lower bound of the range of dgf loc districts
	 * @param end the upper bound of the range of dgf loc districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf loc districts
	 */
	@Override
	public List<dgfLocDistrict> findBydivWiseDisFinder(
		long divisionId, int start, int end,
		OrderByComparator<dgfLocDistrict> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBydivWiseDisFinder;
				finderArgs = new Object[] {divisionId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBydivWiseDisFinder;
			finderArgs = new Object[] {
				divisionId, start, end, orderByComparator
			};
		}

		List<dgfLocDistrict> list = null;

		if (useFinderCache) {
			list = (List<dgfLocDistrict>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (dgfLocDistrict dgfLocDistrict : list) {
					if (divisionId != dgfLocDistrict.getDivisionId()) {
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

			sb.append(_SQL_SELECT_DGFLOCDISTRICT_WHERE);

			sb.append(_FINDER_COLUMN_DIVWISEDISFINDER_DIVISIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(dgfLocDistrictModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(divisionId);

				list = (List<dgfLocDistrict>)QueryUtil.list(
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
	 * Returns the first dgf loc district in the ordered set where divisionId = &#63;.
	 *
	 * @param divisionId the division ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf loc district
	 * @throws NoSuchdgfLocDistrictException if a matching dgf loc district could not be found
	 */
	@Override
	public dgfLocDistrict findBydivWiseDisFinder_First(
			long divisionId,
			OrderByComparator<dgfLocDistrict> orderByComparator)
		throws NoSuchdgfLocDistrictException {

		dgfLocDistrict dgfLocDistrict = fetchBydivWiseDisFinder_First(
			divisionId, orderByComparator);

		if (dgfLocDistrict != null) {
			return dgfLocDistrict;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("divisionId=");
		sb.append(divisionId);

		sb.append("}");

		throw new NoSuchdgfLocDistrictException(sb.toString());
	}

	/**
	 * Returns the first dgf loc district in the ordered set where divisionId = &#63;.
	 *
	 * @param divisionId the division ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf loc district, or <code>null</code> if a matching dgf loc district could not be found
	 */
	@Override
	public dgfLocDistrict fetchBydivWiseDisFinder_First(
		long divisionId, OrderByComparator<dgfLocDistrict> orderByComparator) {

		List<dgfLocDistrict> list = findBydivWiseDisFinder(
			divisionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf loc district in the ordered set where divisionId = &#63;.
	 *
	 * @param divisionId the division ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf loc district
	 * @throws NoSuchdgfLocDistrictException if a matching dgf loc district could not be found
	 */
	@Override
	public dgfLocDistrict findBydivWiseDisFinder_Last(
			long divisionId,
			OrderByComparator<dgfLocDistrict> orderByComparator)
		throws NoSuchdgfLocDistrictException {

		dgfLocDistrict dgfLocDistrict = fetchBydivWiseDisFinder_Last(
			divisionId, orderByComparator);

		if (dgfLocDistrict != null) {
			return dgfLocDistrict;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("divisionId=");
		sb.append(divisionId);

		sb.append("}");

		throw new NoSuchdgfLocDistrictException(sb.toString());
	}

	/**
	 * Returns the last dgf loc district in the ordered set where divisionId = &#63;.
	 *
	 * @param divisionId the division ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf loc district, or <code>null</code> if a matching dgf loc district could not be found
	 */
	@Override
	public dgfLocDistrict fetchBydivWiseDisFinder_Last(
		long divisionId, OrderByComparator<dgfLocDistrict> orderByComparator) {

		int count = countBydivWiseDisFinder(divisionId);

		if (count == 0) {
			return null;
		}

		List<dgfLocDistrict> list = findBydivWiseDisFinder(
			divisionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf loc districts before and after the current dgf loc district in the ordered set where divisionId = &#63;.
	 *
	 * @param id the primary key of the current dgf loc district
	 * @param divisionId the division ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf loc district
	 * @throws NoSuchdgfLocDistrictException if a dgf loc district with the primary key could not be found
	 */
	@Override
	public dgfLocDistrict[] findBydivWiseDisFinder_PrevAndNext(
			long id, long divisionId,
			OrderByComparator<dgfLocDistrict> orderByComparator)
		throws NoSuchdgfLocDistrictException {

		dgfLocDistrict dgfLocDistrict = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			dgfLocDistrict[] array = new dgfLocDistrictImpl[3];

			array[0] = getBydivWiseDisFinder_PrevAndNext(
				session, dgfLocDistrict, divisionId, orderByComparator, true);

			array[1] = dgfLocDistrict;

			array[2] = getBydivWiseDisFinder_PrevAndNext(
				session, dgfLocDistrict, divisionId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected dgfLocDistrict getBydivWiseDisFinder_PrevAndNext(
		Session session, dgfLocDistrict dgfLocDistrict, long divisionId,
		OrderByComparator<dgfLocDistrict> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DGFLOCDISTRICT_WHERE);

		sb.append(_FINDER_COLUMN_DIVWISEDISFINDER_DIVISIONID_2);

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
			sb.append(dgfLocDistrictModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(divisionId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfLocDistrict)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<dgfLocDistrict> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf loc districts where divisionId = &#63; from the database.
	 *
	 * @param divisionId the division ID
	 */
	@Override
	public void removeBydivWiseDisFinder(long divisionId) {
		for (dgfLocDistrict dgfLocDistrict :
				findBydivWiseDisFinder(
					divisionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgfLocDistrict);
		}
	}

	/**
	 * Returns the number of dgf loc districts where divisionId = &#63;.
	 *
	 * @param divisionId the division ID
	 * @return the number of matching dgf loc districts
	 */
	@Override
	public int countBydivWiseDisFinder(long divisionId) {
		FinderPath finderPath = _finderPathCountBydivWiseDisFinder;

		Object[] finderArgs = new Object[] {divisionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFLOCDISTRICT_WHERE);

			sb.append(_FINDER_COLUMN_DIVWISEDISFINDER_DIVISIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(divisionId);

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

	private static final String _FINDER_COLUMN_DIVWISEDISFINDER_DIVISIONID_2 =
		"dgfLocDistrict.divisionId = ?";

	public dgfLocDistrictPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(dgfLocDistrict.class);

		setModelImplClass(dgfLocDistrictImpl.class);
		setModelPKClass(long.class);

		setTable(dgfLocDistrictTable.INSTANCE);
	}

	/**
	 * Caches the dgf loc district in the entity cache if it is enabled.
	 *
	 * @param dgfLocDistrict the dgf loc district
	 */
	@Override
	public void cacheResult(dgfLocDistrict dgfLocDistrict) {
		entityCache.putResult(
			dgfLocDistrictImpl.class, dgfLocDistrict.getPrimaryKey(),
			dgfLocDistrict);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dgf loc districts in the entity cache if it is enabled.
	 *
	 * @param dgfLocDistricts the dgf loc districts
	 */
	@Override
	public void cacheResult(List<dgfLocDistrict> dgfLocDistricts) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgfLocDistricts.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (dgfLocDistrict dgfLocDistrict : dgfLocDistricts) {
			if (entityCache.getResult(
					dgfLocDistrictImpl.class, dgfLocDistrict.getPrimaryKey()) ==
						null) {

				cacheResult(dgfLocDistrict);
			}
		}
	}

	/**
	 * Clears the cache for all dgf loc districts.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(dgfLocDistrictImpl.class);

		finderCache.clearCache(dgfLocDistrictImpl.class);
	}

	/**
	 * Clears the cache for the dgf loc district.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(dgfLocDistrict dgfLocDistrict) {
		entityCache.removeResult(dgfLocDistrictImpl.class, dgfLocDistrict);
	}

	@Override
	public void clearCache(List<dgfLocDistrict> dgfLocDistricts) {
		for (dgfLocDistrict dgfLocDistrict : dgfLocDistricts) {
			entityCache.removeResult(dgfLocDistrictImpl.class, dgfLocDistrict);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(dgfLocDistrictImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(dgfLocDistrictImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new dgf loc district with the primary key. Does not add the dgf loc district to the database.
	 *
	 * @param id the primary key for the new dgf loc district
	 * @return the new dgf loc district
	 */
	@Override
	public dgfLocDistrict create(long id) {
		dgfLocDistrict dgfLocDistrict = new dgfLocDistrictImpl();

		dgfLocDistrict.setNew(true);
		dgfLocDistrict.setPrimaryKey(id);

		return dgfLocDistrict;
	}

	/**
	 * Removes the dgf loc district with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dgf loc district
	 * @return the dgf loc district that was removed
	 * @throws NoSuchdgfLocDistrictException if a dgf loc district with the primary key could not be found
	 */
	@Override
	public dgfLocDistrict remove(long id) throws NoSuchdgfLocDistrictException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the dgf loc district with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dgf loc district
	 * @return the dgf loc district that was removed
	 * @throws NoSuchdgfLocDistrictException if a dgf loc district with the primary key could not be found
	 */
	@Override
	public dgfLocDistrict remove(Serializable primaryKey)
		throws NoSuchdgfLocDistrictException {

		Session session = null;

		try {
			session = openSession();

			dgfLocDistrict dgfLocDistrict = (dgfLocDistrict)session.get(
				dgfLocDistrictImpl.class, primaryKey);

			if (dgfLocDistrict == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchdgfLocDistrictException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgfLocDistrict);
		}
		catch (NoSuchdgfLocDistrictException noSuchEntityException) {
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
	protected dgfLocDistrict removeImpl(dgfLocDistrict dgfLocDistrict) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgfLocDistrict)) {
				dgfLocDistrict = (dgfLocDistrict)session.get(
					dgfLocDistrictImpl.class,
					dgfLocDistrict.getPrimaryKeyObj());
			}

			if (dgfLocDistrict != null) {
				session.delete(dgfLocDistrict);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgfLocDistrict != null) {
			clearCache(dgfLocDistrict);
		}

		return dgfLocDistrict;
	}

	@Override
	public dgfLocDistrict updateImpl(dgfLocDistrict dgfLocDistrict) {
		boolean isNew = dgfLocDistrict.isNew();

		if (!(dgfLocDistrict instanceof dgfLocDistrictModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dgfLocDistrict.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dgfLocDistrict);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgfLocDistrict proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom dgfLocDistrict implementation " +
					dgfLocDistrict.getClass());
		}

		dgfLocDistrictModelImpl dgfLocDistrictModelImpl =
			(dgfLocDistrictModelImpl)dgfLocDistrict;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgfLocDistrict);
			}
			else {
				dgfLocDistrict = (dgfLocDistrict)session.merge(dgfLocDistrict);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			dgfLocDistrictImpl.class, dgfLocDistrictModelImpl, false, true);

		if (isNew) {
			dgfLocDistrict.setNew(false);
		}

		dgfLocDistrict.resetOriginalValues();

		return dgfLocDistrict;
	}

	/**
	 * Returns the dgf loc district with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dgf loc district
	 * @return the dgf loc district
	 * @throws NoSuchdgfLocDistrictException if a dgf loc district with the primary key could not be found
	 */
	@Override
	public dgfLocDistrict findByPrimaryKey(Serializable primaryKey)
		throws NoSuchdgfLocDistrictException {

		dgfLocDistrict dgfLocDistrict = fetchByPrimaryKey(primaryKey);

		if (dgfLocDistrict == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchdgfLocDistrictException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgfLocDistrict;
	}

	/**
	 * Returns the dgf loc district with the primary key or throws a <code>NoSuchdgfLocDistrictException</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf loc district
	 * @return the dgf loc district
	 * @throws NoSuchdgfLocDistrictException if a dgf loc district with the primary key could not be found
	 */
	@Override
	public dgfLocDistrict findByPrimaryKey(long id)
		throws NoSuchdgfLocDistrictException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the dgf loc district with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf loc district
	 * @return the dgf loc district, or <code>null</code> if a dgf loc district with the primary key could not be found
	 */
	@Override
	public dgfLocDistrict fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the dgf loc districts.
	 *
	 * @return the dgf loc districts
	 */
	@Override
	public List<dgfLocDistrict> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf loc districts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocDistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc districts
	 * @param end the upper bound of the range of dgf loc districts (not inclusive)
	 * @return the range of dgf loc districts
	 */
	@Override
	public List<dgfLocDistrict> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf loc districts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocDistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc districts
	 * @param end the upper bound of the range of dgf loc districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf loc districts
	 */
	@Override
	public List<dgfLocDistrict> findAll(
		int start, int end,
		OrderByComparator<dgfLocDistrict> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf loc districts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dgfLocDistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc districts
	 * @param end the upper bound of the range of dgf loc districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf loc districts
	 */
	@Override
	public List<dgfLocDistrict> findAll(
		int start, int end, OrderByComparator<dgfLocDistrict> orderByComparator,
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

		List<dgfLocDistrict> list = null;

		if (useFinderCache) {
			list = (List<dgfLocDistrict>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFLOCDISTRICT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFLOCDISTRICT;

				sql = sql.concat(dgfLocDistrictModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<dgfLocDistrict>)QueryUtil.list(
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
	 * Removes all the dgf loc districts from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (dgfLocDistrict dgfLocDistrict : findAll()) {
			remove(dgfLocDistrict);
		}
	}

	/**
	 * Returns the number of dgf loc districts.
	 *
	 * @return the number of dgf loc districts
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DGFLOCDISTRICT);

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
		return _SQL_SELECT_DGFLOCDISTRICT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return dgfLocDistrictModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dgf loc district persistence.
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

		_finderPathWithPaginationFindBydivWiseDisFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBydivWiseDisFinder",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"divisionId"}, true);

		_finderPathWithoutPaginationFindBydivWiseDisFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBydivWiseDisFinder",
			new String[] {Long.class.getName()}, new String[] {"divisionId"},
			true);

		_finderPathCountBydivWiseDisFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydivWiseDisFinder", new String[] {Long.class.getName()},
			new String[] {"divisionId"}, false);

		_setdgfLocDistrictUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setdgfLocDistrictUtilPersistence(null);

		entityCache.removeCache(dgfLocDistrictImpl.class.getName());
	}

	private void _setdgfLocDistrictUtilPersistence(
		dgfLocDistrictPersistence dgfLocDistrictPersistence) {

		try {
			Field field = dgfLocDistrictUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dgfLocDistrictPersistence);
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

	private static final String _SQL_SELECT_DGFLOCDISTRICT =
		"SELECT dgfLocDistrict FROM dgfLocDistrict dgfLocDistrict";

	private static final String _SQL_SELECT_DGFLOCDISTRICT_WHERE =
		"SELECT dgfLocDistrict FROM dgfLocDistrict dgfLocDistrict WHERE ";

	private static final String _SQL_COUNT_DGFLOCDISTRICT =
		"SELECT COUNT(dgfLocDistrict) FROM dgfLocDistrict dgfLocDistrict";

	private static final String _SQL_COUNT_DGFLOCDISTRICT_WHERE =
		"SELECT COUNT(dgfLocDistrict) FROM dgfLocDistrict dgfLocDistrict WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dgfLocDistrict.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No dgfLocDistrict exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No dgfLocDistrict exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		dgfLocDistrictPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}