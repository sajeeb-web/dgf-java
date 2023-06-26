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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfDistributionSchedulesException;
import bd.gov.dgfood.food.grain.license.model.DgfDistributionSchedules;
import bd.gov.dgfood.food.grain.license.model.DgfDistributionSchedulesTable;
import bd.gov.dgfood.food.grain.license.model.impl.DgfDistributionSchedulesImpl;
import bd.gov.dgfood.food.grain.license.model.impl.DgfDistributionSchedulesModelImpl;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfDistributionSchedulesPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfDistributionSchedulesUtil;
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

import java.sql.Timestamp;

import java.util.Collections;
import java.util.Date;
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
 * The persistence implementation for the dgf distribution schedules service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DgfDistributionSchedulesPersistence.class)
public class DgfDistributionSchedulesPersistenceImpl
	extends BasePersistenceImpl<DgfDistributionSchedules>
	implements DgfDistributionSchedulesPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DgfDistributionSchedulesUtil</code> to access the dgf distribution schedules persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DgfDistributionSchedulesImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByDistributionMonthAndYear;
	private FinderPath _finderPathCountByDistributionMonthAndYear;

	/**
	 * Returns the dgf distribution schedules where distributionYear = &#63; and distributionMonth = &#63; or throws a <code>NoSuchDgfDistributionSchedulesException</code> if it could not be found.
	 *
	 * @param distributionYear the distribution year
	 * @param distributionMonth the distribution month
	 * @return the matching dgf distribution schedules
	 * @throws NoSuchDgfDistributionSchedulesException if a matching dgf distribution schedules could not be found
	 */
	@Override
	public DgfDistributionSchedules findByDistributionMonthAndYear(
			long distributionYear, String distributionMonth)
		throws NoSuchDgfDistributionSchedulesException {

		DgfDistributionSchedules dgfDistributionSchedules =
			fetchByDistributionMonthAndYear(
				distributionYear, distributionMonth);

		if (dgfDistributionSchedules == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("distributionYear=");
			sb.append(distributionYear);

			sb.append(", distributionMonth=");
			sb.append(distributionMonth);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfDistributionSchedulesException(sb.toString());
		}

		return dgfDistributionSchedules;
	}

	/**
	 * Returns the dgf distribution schedules where distributionYear = &#63; and distributionMonth = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param distributionYear the distribution year
	 * @param distributionMonth the distribution month
	 * @return the matching dgf distribution schedules, or <code>null</code> if a matching dgf distribution schedules could not be found
	 */
	@Override
	public DgfDistributionSchedules fetchByDistributionMonthAndYear(
		long distributionYear, String distributionMonth) {

		return fetchByDistributionMonthAndYear(
			distributionYear, distributionMonth, true);
	}

	/**
	 * Returns the dgf distribution schedules where distributionYear = &#63; and distributionMonth = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param distributionYear the distribution year
	 * @param distributionMonth the distribution month
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf distribution schedules, or <code>null</code> if a matching dgf distribution schedules could not be found
	 */
	@Override
	public DgfDistributionSchedules fetchByDistributionMonthAndYear(
		long distributionYear, String distributionMonth,
		boolean useFinderCache) {

		distributionMonth = Objects.toString(distributionMonth, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {distributionYear, distributionMonth};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDistributionMonthAndYear, finderArgs, this);
		}

		if (result instanceof DgfDistributionSchedules) {
			DgfDistributionSchedules dgfDistributionSchedules =
				(DgfDistributionSchedules)result;

			if ((distributionYear !=
					dgfDistributionSchedules.getDistributionYear()) ||
				!Objects.equals(
					distributionMonth,
					dgfDistributionSchedules.getDistributionMonth())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DGFDISTRIBUTIONSCHEDULES_WHERE);

			sb.append(
				_FINDER_COLUMN_DISTRIBUTIONMONTHANDYEAR_DISTRIBUTIONYEAR_2);

			boolean bindDistributionMonth = false;

			if (distributionMonth.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DISTRIBUTIONMONTHANDYEAR_DISTRIBUTIONMONTH_3);
			}
			else {
				bindDistributionMonth = true;

				sb.append(
					_FINDER_COLUMN_DISTRIBUTIONMONTHANDYEAR_DISTRIBUTIONMONTH_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(distributionYear);

				if (bindDistributionMonth) {
					queryPos.add(distributionMonth);
				}

				List<DgfDistributionSchedules> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDistributionMonthAndYear,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									distributionYear, distributionMonth
								};
							}

							_log.warn(
								"DgfDistributionSchedulesPersistenceImpl.fetchByDistributionMonthAndYear(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DgfDistributionSchedules dgfDistributionSchedules =
						list.get(0);

					result = dgfDistributionSchedules;

					cacheResult(dgfDistributionSchedules);
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
			return (DgfDistributionSchedules)result;
		}
	}

	/**
	 * Removes the dgf distribution schedules where distributionYear = &#63; and distributionMonth = &#63; from the database.
	 *
	 * @param distributionYear the distribution year
	 * @param distributionMonth the distribution month
	 * @return the dgf distribution schedules that was removed
	 */
	@Override
	public DgfDistributionSchedules removeByDistributionMonthAndYear(
			long distributionYear, String distributionMonth)
		throws NoSuchDgfDistributionSchedulesException {

		DgfDistributionSchedules dgfDistributionSchedules =
			findByDistributionMonthAndYear(distributionYear, distributionMonth);

		return remove(dgfDistributionSchedules);
	}

	/**
	 * Returns the number of dgf distribution scheduleses where distributionYear = &#63; and distributionMonth = &#63;.
	 *
	 * @param distributionYear the distribution year
	 * @param distributionMonth the distribution month
	 * @return the number of matching dgf distribution scheduleses
	 */
	@Override
	public int countByDistributionMonthAndYear(
		long distributionYear, String distributionMonth) {

		distributionMonth = Objects.toString(distributionMonth, "");

		FinderPath finderPath = _finderPathCountByDistributionMonthAndYear;

		Object[] finderArgs = new Object[] {
			distributionYear, distributionMonth
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFDISTRIBUTIONSCHEDULES_WHERE);

			sb.append(
				_FINDER_COLUMN_DISTRIBUTIONMONTHANDYEAR_DISTRIBUTIONYEAR_2);

			boolean bindDistributionMonth = false;

			if (distributionMonth.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DISTRIBUTIONMONTHANDYEAR_DISTRIBUTIONMONTH_3);
			}
			else {
				bindDistributionMonth = true;

				sb.append(
					_FINDER_COLUMN_DISTRIBUTIONMONTHANDYEAR_DISTRIBUTIONMONTH_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(distributionYear);

				if (bindDistributionMonth) {
					queryPos.add(distributionMonth);
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

	private static final String
		_FINDER_COLUMN_DISTRIBUTIONMONTHANDYEAR_DISTRIBUTIONYEAR_2 =
			"dgfDistributionSchedules.distributionYear = ? AND ";

	private static final String
		_FINDER_COLUMN_DISTRIBUTIONMONTHANDYEAR_DISTRIBUTIONMONTH_2 =
			"dgfDistributionSchedules.distributionMonth = ?";

	private static final String
		_FINDER_COLUMN_DISTRIBUTIONMONTHANDYEAR_DISTRIBUTIONMONTH_3 =
			"(dgfDistributionSchedules.distributionMonth IS NULL OR dgfDistributionSchedules.distributionMonth = '')";

	private FinderPath _finderPathWithPaginationFindByOpenStatus;
	private FinderPath _finderPathWithoutPaginationFindByOpenStatus;
	private FinderPath _finderPathCountByOpenStatus;

	/**
	 * Returns all the dgf distribution scheduleses where openStatus = &#63;.
	 *
	 * @param openStatus the open status
	 * @return the matching dgf distribution scheduleses
	 */
	@Override
	public List<DgfDistributionSchedules> findByOpenStatus(String openStatus) {
		return findByOpenStatus(
			openStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf distribution scheduleses where openStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDistributionSchedulesModelImpl</code>.
	 * </p>
	 *
	 * @param openStatus the open status
	 * @param start the lower bound of the range of dgf distribution scheduleses
	 * @param end the upper bound of the range of dgf distribution scheduleses (not inclusive)
	 * @return the range of matching dgf distribution scheduleses
	 */
	@Override
	public List<DgfDistributionSchedules> findByOpenStatus(
		String openStatus, int start, int end) {

		return findByOpenStatus(openStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf distribution scheduleses where openStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDistributionSchedulesModelImpl</code>.
	 * </p>
	 *
	 * @param openStatus the open status
	 * @param start the lower bound of the range of dgf distribution scheduleses
	 * @param end the upper bound of the range of dgf distribution scheduleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf distribution scheduleses
	 */
	@Override
	public List<DgfDistributionSchedules> findByOpenStatus(
		String openStatus, int start, int end,
		OrderByComparator<DgfDistributionSchedules> orderByComparator) {

		return findByOpenStatus(
			openStatus, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf distribution scheduleses where openStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDistributionSchedulesModelImpl</code>.
	 * </p>
	 *
	 * @param openStatus the open status
	 * @param start the lower bound of the range of dgf distribution scheduleses
	 * @param end the upper bound of the range of dgf distribution scheduleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf distribution scheduleses
	 */
	@Override
	public List<DgfDistributionSchedules> findByOpenStatus(
		String openStatus, int start, int end,
		OrderByComparator<DgfDistributionSchedules> orderByComparator,
		boolean useFinderCache) {

		openStatus = Objects.toString(openStatus, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByOpenStatus;
				finderArgs = new Object[] {openStatus};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByOpenStatus;
			finderArgs = new Object[] {
				openStatus, start, end, orderByComparator
			};
		}

		List<DgfDistributionSchedules> list = null;

		if (useFinderCache) {
			list = (List<DgfDistributionSchedules>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfDistributionSchedules dgfDistributionSchedules : list) {
					if (!openStatus.equals(
							dgfDistributionSchedules.getOpenStatus())) {

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

			sb.append(_SQL_SELECT_DGFDISTRIBUTIONSCHEDULES_WHERE);

			boolean bindOpenStatus = false;

			if (openStatus.isEmpty()) {
				sb.append(_FINDER_COLUMN_OPENSTATUS_OPENSTATUS_3);
			}
			else {
				bindOpenStatus = true;

				sb.append(_FINDER_COLUMN_OPENSTATUS_OPENSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfDistributionSchedulesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindOpenStatus) {
					queryPos.add(openStatus);
				}

				list = (List<DgfDistributionSchedules>)QueryUtil.list(
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
	 * Returns the first dgf distribution schedules in the ordered set where openStatus = &#63;.
	 *
	 * @param openStatus the open status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf distribution schedules
	 * @throws NoSuchDgfDistributionSchedulesException if a matching dgf distribution schedules could not be found
	 */
	@Override
	public DgfDistributionSchedules findByOpenStatus_First(
			String openStatus,
			OrderByComparator<DgfDistributionSchedules> orderByComparator)
		throws NoSuchDgfDistributionSchedulesException {

		DgfDistributionSchedules dgfDistributionSchedules =
			fetchByOpenStatus_First(openStatus, orderByComparator);

		if (dgfDistributionSchedules != null) {
			return dgfDistributionSchedules;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("openStatus=");
		sb.append(openStatus);

		sb.append("}");

		throw new NoSuchDgfDistributionSchedulesException(sb.toString());
	}

	/**
	 * Returns the first dgf distribution schedules in the ordered set where openStatus = &#63;.
	 *
	 * @param openStatus the open status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf distribution schedules, or <code>null</code> if a matching dgf distribution schedules could not be found
	 */
	@Override
	public DgfDistributionSchedules fetchByOpenStatus_First(
		String openStatus,
		OrderByComparator<DgfDistributionSchedules> orderByComparator) {

		List<DgfDistributionSchedules> list = findByOpenStatus(
			openStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf distribution schedules in the ordered set where openStatus = &#63;.
	 *
	 * @param openStatus the open status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf distribution schedules
	 * @throws NoSuchDgfDistributionSchedulesException if a matching dgf distribution schedules could not be found
	 */
	@Override
	public DgfDistributionSchedules findByOpenStatus_Last(
			String openStatus,
			OrderByComparator<DgfDistributionSchedules> orderByComparator)
		throws NoSuchDgfDistributionSchedulesException {

		DgfDistributionSchedules dgfDistributionSchedules =
			fetchByOpenStatus_Last(openStatus, orderByComparator);

		if (dgfDistributionSchedules != null) {
			return dgfDistributionSchedules;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("openStatus=");
		sb.append(openStatus);

		sb.append("}");

		throw new NoSuchDgfDistributionSchedulesException(sb.toString());
	}

	/**
	 * Returns the last dgf distribution schedules in the ordered set where openStatus = &#63;.
	 *
	 * @param openStatus the open status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf distribution schedules, or <code>null</code> if a matching dgf distribution schedules could not be found
	 */
	@Override
	public DgfDistributionSchedules fetchByOpenStatus_Last(
		String openStatus,
		OrderByComparator<DgfDistributionSchedules> orderByComparator) {

		int count = countByOpenStatus(openStatus);

		if (count == 0) {
			return null;
		}

		List<DgfDistributionSchedules> list = findByOpenStatus(
			openStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf distribution scheduleses before and after the current dgf distribution schedules in the ordered set where openStatus = &#63;.
	 *
	 * @param id the primary key of the current dgf distribution schedules
	 * @param openStatus the open status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf distribution schedules
	 * @throws NoSuchDgfDistributionSchedulesException if a dgf distribution schedules with the primary key could not be found
	 */
	@Override
	public DgfDistributionSchedules[] findByOpenStatus_PrevAndNext(
			String id, String openStatus,
			OrderByComparator<DgfDistributionSchedules> orderByComparator)
		throws NoSuchDgfDistributionSchedulesException {

		openStatus = Objects.toString(openStatus, "");

		DgfDistributionSchedules dgfDistributionSchedules = findByPrimaryKey(
			id);

		Session session = null;

		try {
			session = openSession();

			DgfDistributionSchedules[] array =
				new DgfDistributionSchedulesImpl[3];

			array[0] = getByOpenStatus_PrevAndNext(
				session, dgfDistributionSchedules, openStatus,
				orderByComparator, true);

			array[1] = dgfDistributionSchedules;

			array[2] = getByOpenStatus_PrevAndNext(
				session, dgfDistributionSchedules, openStatus,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DgfDistributionSchedules getByOpenStatus_PrevAndNext(
		Session session, DgfDistributionSchedules dgfDistributionSchedules,
		String openStatus,
		OrderByComparator<DgfDistributionSchedules> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFDISTRIBUTIONSCHEDULES_WHERE);

		boolean bindOpenStatus = false;

		if (openStatus.isEmpty()) {
			sb.append(_FINDER_COLUMN_OPENSTATUS_OPENSTATUS_3);
		}
		else {
			bindOpenStatus = true;

			sb.append(_FINDER_COLUMN_OPENSTATUS_OPENSTATUS_2);
		}

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
			sb.append(DgfDistributionSchedulesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindOpenStatus) {
			queryPos.add(openStatus);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfDistributionSchedules)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfDistributionSchedules> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf distribution scheduleses where openStatus = &#63; from the database.
	 *
	 * @param openStatus the open status
	 */
	@Override
	public void removeByOpenStatus(String openStatus) {
		for (DgfDistributionSchedules dgfDistributionSchedules :
				findByOpenStatus(
					openStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgfDistributionSchedules);
		}
	}

	/**
	 * Returns the number of dgf distribution scheduleses where openStatus = &#63;.
	 *
	 * @param openStatus the open status
	 * @return the number of matching dgf distribution scheduleses
	 */
	@Override
	public int countByOpenStatus(String openStatus) {
		openStatus = Objects.toString(openStatus, "");

		FinderPath finderPath = _finderPathCountByOpenStatus;

		Object[] finderArgs = new Object[] {openStatus};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFDISTRIBUTIONSCHEDULES_WHERE);

			boolean bindOpenStatus = false;

			if (openStatus.isEmpty()) {
				sb.append(_FINDER_COLUMN_OPENSTATUS_OPENSTATUS_3);
			}
			else {
				bindOpenStatus = true;

				sb.append(_FINDER_COLUMN_OPENSTATUS_OPENSTATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindOpenStatus) {
					queryPos.add(openStatus);
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

	private static final String _FINDER_COLUMN_OPENSTATUS_OPENSTATUS_2 =
		"dgfDistributionSchedules.openStatus = ?";

	private static final String _FINDER_COLUMN_OPENSTATUS_OPENSTATUS_3 =
		"(dgfDistributionSchedules.openStatus IS NULL OR dgfDistributionSchedules.openStatus = '')";

	private FinderPath _finderPathFetchByStartDateAndEndDate;
	private FinderPath _finderPathCountByStartDateAndEndDate;

	/**
	 * Returns the dgf distribution schedules where startDate = &#63; and endDate = &#63; or throws a <code>NoSuchDgfDistributionSchedulesException</code> if it could not be found.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the matching dgf distribution schedules
	 * @throws NoSuchDgfDistributionSchedulesException if a matching dgf distribution schedules could not be found
	 */
	@Override
	public DgfDistributionSchedules findByStartDateAndEndDate(
			Date startDate, Date endDate)
		throws NoSuchDgfDistributionSchedulesException {

		DgfDistributionSchedules dgfDistributionSchedules =
			fetchByStartDateAndEndDate(startDate, endDate);

		if (dgfDistributionSchedules == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("startDate=");
			sb.append(startDate);

			sb.append(", endDate=");
			sb.append(endDate);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfDistributionSchedulesException(sb.toString());
		}

		return dgfDistributionSchedules;
	}

	/**
	 * Returns the dgf distribution schedules where startDate = &#63; and endDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the matching dgf distribution schedules, or <code>null</code> if a matching dgf distribution schedules could not be found
	 */
	@Override
	public DgfDistributionSchedules fetchByStartDateAndEndDate(
		Date startDate, Date endDate) {

		return fetchByStartDateAndEndDate(startDate, endDate, true);
	}

	/**
	 * Returns the dgf distribution schedules where startDate = &#63; and endDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf distribution schedules, or <code>null</code> if a matching dgf distribution schedules could not be found
	 */
	@Override
	public DgfDistributionSchedules fetchByStartDateAndEndDate(
		Date startDate, Date endDate, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {_getTime(startDate), _getTime(endDate)};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByStartDateAndEndDate, finderArgs, this);
		}

		if (result instanceof DgfDistributionSchedules) {
			DgfDistributionSchedules dgfDistributionSchedules =
				(DgfDistributionSchedules)result;

			if (!Objects.equals(
					startDate, dgfDistributionSchedules.getStartDate()) ||
				!Objects.equals(
					endDate, dgfDistributionSchedules.getEndDate())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DGFDISTRIBUTIONSCHEDULES_WHERE);

			boolean bindStartDate = false;

			if (startDate == null) {
				sb.append(_FINDER_COLUMN_STARTDATEANDENDDATE_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				sb.append(_FINDER_COLUMN_STARTDATEANDENDDATE_STARTDATE_2);
			}

			boolean bindEndDate = false;

			if (endDate == null) {
				sb.append(_FINDER_COLUMN_STARTDATEANDENDDATE_ENDDATE_1);
			}
			else {
				bindEndDate = true;

				sb.append(_FINDER_COLUMN_STARTDATEANDENDDATE_ENDDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStartDate) {
					queryPos.add(new Timestamp(startDate.getTime()));
				}

				if (bindEndDate) {
					queryPos.add(new Timestamp(endDate.getTime()));
				}

				List<DgfDistributionSchedules> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByStartDateAndEndDate, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									_getTime(startDate), _getTime(endDate)
								};
							}

							_log.warn(
								"DgfDistributionSchedulesPersistenceImpl.fetchByStartDateAndEndDate(Date, Date, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DgfDistributionSchedules dgfDistributionSchedules =
						list.get(0);

					result = dgfDistributionSchedules;

					cacheResult(dgfDistributionSchedules);
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
			return (DgfDistributionSchedules)result;
		}
	}

	/**
	 * Removes the dgf distribution schedules where startDate = &#63; and endDate = &#63; from the database.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the dgf distribution schedules that was removed
	 */
	@Override
	public DgfDistributionSchedules removeByStartDateAndEndDate(
			Date startDate, Date endDate)
		throws NoSuchDgfDistributionSchedulesException {

		DgfDistributionSchedules dgfDistributionSchedules =
			findByStartDateAndEndDate(startDate, endDate);

		return remove(dgfDistributionSchedules);
	}

	/**
	 * Returns the number of dgf distribution scheduleses where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the number of matching dgf distribution scheduleses
	 */
	@Override
	public int countByStartDateAndEndDate(Date startDate, Date endDate) {
		FinderPath finderPath = _finderPathCountByStartDateAndEndDate;

		Object[] finderArgs = new Object[] {
			_getTime(startDate), _getTime(endDate)
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFDISTRIBUTIONSCHEDULES_WHERE);

			boolean bindStartDate = false;

			if (startDate == null) {
				sb.append(_FINDER_COLUMN_STARTDATEANDENDDATE_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				sb.append(_FINDER_COLUMN_STARTDATEANDENDDATE_STARTDATE_2);
			}

			boolean bindEndDate = false;

			if (endDate == null) {
				sb.append(_FINDER_COLUMN_STARTDATEANDENDDATE_ENDDATE_1);
			}
			else {
				bindEndDate = true;

				sb.append(_FINDER_COLUMN_STARTDATEANDENDDATE_ENDDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStartDate) {
					queryPos.add(new Timestamp(startDate.getTime()));
				}

				if (bindEndDate) {
					queryPos.add(new Timestamp(endDate.getTime()));
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

	private static final String _FINDER_COLUMN_STARTDATEANDENDDATE_STARTDATE_1 =
		"dgfDistributionSchedules.startDate IS NULL AND ";

	private static final String _FINDER_COLUMN_STARTDATEANDENDDATE_STARTDATE_2 =
		"dgfDistributionSchedules.startDate = ? AND ";

	private static final String _FINDER_COLUMN_STARTDATEANDENDDATE_ENDDATE_1 =
		"dgfDistributionSchedules.endDate IS NULL";

	private static final String _FINDER_COLUMN_STARTDATEANDENDDATE_ENDDATE_2 =
		"dgfDistributionSchedules.endDate = ?";

	public DgfDistributionSchedulesPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("distributionYear", "distribution_year");
		dbColumnNames.put("distributionMonth", "distribution_month");
		dbColumnNames.put("openStatus", "open_status");
		dbColumnNames.put("startDate", "start_date");
		dbColumnNames.put("endDate", "end_date");
		dbColumnNames.put("userId", "user_id");
		dbColumnNames.put("createdAt", "created_at");
		dbColumnNames.put("updatedAt", "updated_at");

		setDBColumnNames(dbColumnNames);

		setModelClass(DgfDistributionSchedules.class);

		setModelImplClass(DgfDistributionSchedulesImpl.class);
		setModelPKClass(String.class);

		setTable(DgfDistributionSchedulesTable.INSTANCE);
	}

	/**
	 * Caches the dgf distribution schedules in the entity cache if it is enabled.
	 *
	 * @param dgfDistributionSchedules the dgf distribution schedules
	 */
	@Override
	public void cacheResult(DgfDistributionSchedules dgfDistributionSchedules) {
		entityCache.putResult(
			DgfDistributionSchedulesImpl.class,
			dgfDistributionSchedules.getPrimaryKey(), dgfDistributionSchedules);

		finderCache.putResult(
			_finderPathFetchByDistributionMonthAndYear,
			new Object[] {
				dgfDistributionSchedules.getDistributionYear(),
				dgfDistributionSchedules.getDistributionMonth()
			},
			dgfDistributionSchedules);

		finderCache.putResult(
			_finderPathFetchByStartDateAndEndDate,
			new Object[] {
				dgfDistributionSchedules.getStartDate(),
				dgfDistributionSchedules.getEndDate()
			},
			dgfDistributionSchedules);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dgf distribution scheduleses in the entity cache if it is enabled.
	 *
	 * @param dgfDistributionScheduleses the dgf distribution scheduleses
	 */
	@Override
	public void cacheResult(
		List<DgfDistributionSchedules> dgfDistributionScheduleses) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgfDistributionScheduleses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DgfDistributionSchedules dgfDistributionSchedules :
				dgfDistributionScheduleses) {

			if (entityCache.getResult(
					DgfDistributionSchedulesImpl.class,
					dgfDistributionSchedules.getPrimaryKey()) == null) {

				cacheResult(dgfDistributionSchedules);
			}
		}
	}

	/**
	 * Clears the cache for all dgf distribution scheduleses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DgfDistributionSchedulesImpl.class);

		finderCache.clearCache(DgfDistributionSchedulesImpl.class);
	}

	/**
	 * Clears the cache for the dgf distribution schedules.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DgfDistributionSchedules dgfDistributionSchedules) {
		entityCache.removeResult(
			DgfDistributionSchedulesImpl.class, dgfDistributionSchedules);
	}

	@Override
	public void clearCache(
		List<DgfDistributionSchedules> dgfDistributionScheduleses) {

		for (DgfDistributionSchedules dgfDistributionSchedules :
				dgfDistributionScheduleses) {

			entityCache.removeResult(
				DgfDistributionSchedulesImpl.class, dgfDistributionSchedules);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DgfDistributionSchedulesImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				DgfDistributionSchedulesImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DgfDistributionSchedulesModelImpl dgfDistributionSchedulesModelImpl) {

		Object[] args = new Object[] {
			dgfDistributionSchedulesModelImpl.getDistributionYear(),
			dgfDistributionSchedulesModelImpl.getDistributionMonth()
		};

		finderCache.putResult(
			_finderPathCountByDistributionMonthAndYear, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDistributionMonthAndYear, args,
			dgfDistributionSchedulesModelImpl);

		args = new Object[] {
			_getTime(dgfDistributionSchedulesModelImpl.getStartDate()),
			_getTime(dgfDistributionSchedulesModelImpl.getEndDate())
		};

		finderCache.putResult(
			_finderPathCountByStartDateAndEndDate, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByStartDateAndEndDate, args,
			dgfDistributionSchedulesModelImpl);
	}

	/**
	 * Creates a new dgf distribution schedules with the primary key. Does not add the dgf distribution schedules to the database.
	 *
	 * @param id the primary key for the new dgf distribution schedules
	 * @return the new dgf distribution schedules
	 */
	@Override
	public DgfDistributionSchedules create(String id) {
		DgfDistributionSchedules dgfDistributionSchedules =
			new DgfDistributionSchedulesImpl();

		dgfDistributionSchedules.setNew(true);
		dgfDistributionSchedules.setPrimaryKey(id);

		return dgfDistributionSchedules;
	}

	/**
	 * Removes the dgf distribution schedules with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dgf distribution schedules
	 * @return the dgf distribution schedules that was removed
	 * @throws NoSuchDgfDistributionSchedulesException if a dgf distribution schedules with the primary key could not be found
	 */
	@Override
	public DgfDistributionSchedules remove(String id)
		throws NoSuchDgfDistributionSchedulesException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the dgf distribution schedules with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dgf distribution schedules
	 * @return the dgf distribution schedules that was removed
	 * @throws NoSuchDgfDistributionSchedulesException if a dgf distribution schedules with the primary key could not be found
	 */
	@Override
	public DgfDistributionSchedules remove(Serializable primaryKey)
		throws NoSuchDgfDistributionSchedulesException {

		Session session = null;

		try {
			session = openSession();

			DgfDistributionSchedules dgfDistributionSchedules =
				(DgfDistributionSchedules)session.get(
					DgfDistributionSchedulesImpl.class, primaryKey);

			if (dgfDistributionSchedules == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDgfDistributionSchedulesException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgfDistributionSchedules);
		}
		catch (NoSuchDgfDistributionSchedulesException noSuchEntityException) {
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
	protected DgfDistributionSchedules removeImpl(
		DgfDistributionSchedules dgfDistributionSchedules) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgfDistributionSchedules)) {
				dgfDistributionSchedules =
					(DgfDistributionSchedules)session.get(
						DgfDistributionSchedulesImpl.class,
						dgfDistributionSchedules.getPrimaryKeyObj());
			}

			if (dgfDistributionSchedules != null) {
				session.delete(dgfDistributionSchedules);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgfDistributionSchedules != null) {
			clearCache(dgfDistributionSchedules);
		}

		return dgfDistributionSchedules;
	}

	@Override
	public DgfDistributionSchedules updateImpl(
		DgfDistributionSchedules dgfDistributionSchedules) {

		boolean isNew = dgfDistributionSchedules.isNew();

		if (!(dgfDistributionSchedules instanceof
				DgfDistributionSchedulesModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dgfDistributionSchedules.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dgfDistributionSchedules);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgfDistributionSchedules proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DgfDistributionSchedules implementation " +
					dgfDistributionSchedules.getClass());
		}

		DgfDistributionSchedulesModelImpl dgfDistributionSchedulesModelImpl =
			(DgfDistributionSchedulesModelImpl)dgfDistributionSchedules;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgfDistributionSchedules);
			}
			else {
				dgfDistributionSchedules =
					(DgfDistributionSchedules)session.merge(
						dgfDistributionSchedules);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DgfDistributionSchedulesImpl.class,
			dgfDistributionSchedulesModelImpl, false, true);

		cacheUniqueFindersCache(dgfDistributionSchedulesModelImpl);

		if (isNew) {
			dgfDistributionSchedules.setNew(false);
		}

		dgfDistributionSchedules.resetOriginalValues();

		return dgfDistributionSchedules;
	}

	/**
	 * Returns the dgf distribution schedules with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dgf distribution schedules
	 * @return the dgf distribution schedules
	 * @throws NoSuchDgfDistributionSchedulesException if a dgf distribution schedules with the primary key could not be found
	 */
	@Override
	public DgfDistributionSchedules findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDgfDistributionSchedulesException {

		DgfDistributionSchedules dgfDistributionSchedules = fetchByPrimaryKey(
			primaryKey);

		if (dgfDistributionSchedules == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDgfDistributionSchedulesException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgfDistributionSchedules;
	}

	/**
	 * Returns the dgf distribution schedules with the primary key or throws a <code>NoSuchDgfDistributionSchedulesException</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf distribution schedules
	 * @return the dgf distribution schedules
	 * @throws NoSuchDgfDistributionSchedulesException if a dgf distribution schedules with the primary key could not be found
	 */
	@Override
	public DgfDistributionSchedules findByPrimaryKey(String id)
		throws NoSuchDgfDistributionSchedulesException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the dgf distribution schedules with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf distribution schedules
	 * @return the dgf distribution schedules, or <code>null</code> if a dgf distribution schedules with the primary key could not be found
	 */
	@Override
	public DgfDistributionSchedules fetchByPrimaryKey(String id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the dgf distribution scheduleses.
	 *
	 * @return the dgf distribution scheduleses
	 */
	@Override
	public List<DgfDistributionSchedules> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf distribution scheduleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDistributionSchedulesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf distribution scheduleses
	 * @param end the upper bound of the range of dgf distribution scheduleses (not inclusive)
	 * @return the range of dgf distribution scheduleses
	 */
	@Override
	public List<DgfDistributionSchedules> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf distribution scheduleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDistributionSchedulesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf distribution scheduleses
	 * @param end the upper bound of the range of dgf distribution scheduleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf distribution scheduleses
	 */
	@Override
	public List<DgfDistributionSchedules> findAll(
		int start, int end,
		OrderByComparator<DgfDistributionSchedules> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf distribution scheduleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDistributionSchedulesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf distribution scheduleses
	 * @param end the upper bound of the range of dgf distribution scheduleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf distribution scheduleses
	 */
	@Override
	public List<DgfDistributionSchedules> findAll(
		int start, int end,
		OrderByComparator<DgfDistributionSchedules> orderByComparator,
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

		List<DgfDistributionSchedules> list = null;

		if (useFinderCache) {
			list = (List<DgfDistributionSchedules>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFDISTRIBUTIONSCHEDULES);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFDISTRIBUTIONSCHEDULES;

				sql = sql.concat(
					DgfDistributionSchedulesModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DgfDistributionSchedules>)QueryUtil.list(
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
	 * Removes all the dgf distribution scheduleses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DgfDistributionSchedules dgfDistributionSchedules : findAll()) {
			remove(dgfDistributionSchedules);
		}
	}

	/**
	 * Returns the number of dgf distribution scheduleses.
	 *
	 * @return the number of dgf distribution scheduleses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_DGFDISTRIBUTIONSCHEDULES);

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
		return _SQL_SELECT_DGFDISTRIBUTIONSCHEDULES;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DgfDistributionSchedulesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dgf distribution schedules persistence.
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

		_finderPathFetchByDistributionMonthAndYear = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDistributionMonthAndYear",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"distribution_year", "distribution_month"}, true);

		_finderPathCountByDistributionMonthAndYear = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDistributionMonthAndYear",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"distribution_year", "distribution_month"}, false);

		_finderPathWithPaginationFindByOpenStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOpenStatus",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"open_status"}, true);

		_finderPathWithoutPaginationFindByOpenStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOpenStatus",
			new String[] {String.class.getName()}, new String[] {"open_status"},
			true);

		_finderPathCountByOpenStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOpenStatus",
			new String[] {String.class.getName()}, new String[] {"open_status"},
			false);

		_finderPathFetchByStartDateAndEndDate = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByStartDateAndEndDate",
			new String[] {Date.class.getName(), Date.class.getName()},
			new String[] {"start_date", "end_date"}, true);

		_finderPathCountByStartDateAndEndDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStartDateAndEndDate",
			new String[] {Date.class.getName(), Date.class.getName()},
			new String[] {"start_date", "end_date"}, false);

		_setDgfDistributionSchedulesUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDgfDistributionSchedulesUtilPersistence(null);

		entityCache.removeCache(DgfDistributionSchedulesImpl.class.getName());
	}

	private void _setDgfDistributionSchedulesUtilPersistence(
		DgfDistributionSchedulesPersistence
			dgfDistributionSchedulesPersistence) {

		try {
			Field field = DgfDistributionSchedulesUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dgfDistributionSchedulesPersistence);
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

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_DGFDISTRIBUTIONSCHEDULES =
		"SELECT dgfDistributionSchedules FROM DgfDistributionSchedules dgfDistributionSchedules";

	private static final String _SQL_SELECT_DGFDISTRIBUTIONSCHEDULES_WHERE =
		"SELECT dgfDistributionSchedules FROM DgfDistributionSchedules dgfDistributionSchedules WHERE ";

	private static final String _SQL_COUNT_DGFDISTRIBUTIONSCHEDULES =
		"SELECT COUNT(dgfDistributionSchedules) FROM DgfDistributionSchedules dgfDistributionSchedules";

	private static final String _SQL_COUNT_DGFDISTRIBUTIONSCHEDULES_WHERE =
		"SELECT COUNT(dgfDistributionSchedules) FROM DgfDistributionSchedules dgfDistributionSchedules WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"dgfDistributionSchedules.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DgfDistributionSchedules exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DgfDistributionSchedules exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DgfDistributionSchedulesPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"distributionYear", "distributionMonth", "openStatus", "startDate",
			"endDate", "userId", "createdAt", "updatedAt"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}