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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDealerMastersException;
import bd.gov.dgfood.food.grain.license.model.DealerMasters;
import bd.gov.dgfood.food.grain.license.model.DealerMastersTable;
import bd.gov.dgfood.food.grain.license.model.impl.DealerMastersImpl;
import bd.gov.dgfood.food.grain.license.model.impl.DealerMastersModelImpl;
import bd.gov.dgfood.food.grain.license.service.persistence.DealerMastersPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DealerMastersUtil;
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
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the dealer masters service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DealerMastersPersistence.class)
public class DealerMastersPersistenceImpl
	extends BasePersistenceImpl<DealerMasters>
	implements DealerMastersPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DealerMastersUtil</code> to access the dealer masters persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DealerMastersImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByDealerMastersById;
	private FinderPath _finderPathCountByDealerMastersById;

	/**
	 * Returns the dealer masters where id = &#63; or throws a <code>NoSuchDealerMastersException</code> if it could not be found.
	 *
	 * @param id the ID
	 * @return the matching dealer masters
	 * @throws NoSuchDealerMastersException if a matching dealer masters could not be found
	 */
	@Override
	public DealerMasters findByDealerMastersById(long id)
		throws NoSuchDealerMastersException {

		DealerMasters dealerMasters = fetchByDealerMastersById(id);

		if (dealerMasters == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("id=");
			sb.append(id);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDealerMastersException(sb.toString());
		}

		return dealerMasters;
	}

	/**
	 * Returns the dealer masters where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param id the ID
	 * @return the matching dealer masters, or <code>null</code> if a matching dealer masters could not be found
	 */
	@Override
	public DealerMasters fetchByDealerMastersById(long id) {
		return fetchByDealerMastersById(id, true);
	}

	/**
	 * Returns the dealer masters where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param id the ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dealer masters, or <code>null</code> if a matching dealer masters could not be found
	 */
	@Override
	public DealerMasters fetchByDealerMastersById(
		long id, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {id};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDealerMastersById, finderArgs, this);
		}

		if (result instanceof DealerMasters) {
			DealerMasters dealerMasters = (DealerMasters)result;

			if (id != dealerMasters.getId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DEALERMASTERS_WHERE);

			sb.append(_FINDER_COLUMN_DEALERMASTERSBYID_ID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(id);

				List<DealerMasters> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDealerMastersById, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {id};
							}

							_log.warn(
								"DealerMastersPersistenceImpl.fetchByDealerMastersById(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DealerMasters dealerMasters = list.get(0);

					result = dealerMasters;

					cacheResult(dealerMasters);
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
			return (DealerMasters)result;
		}
	}

	/**
	 * Removes the dealer masters where id = &#63; from the database.
	 *
	 * @param id the ID
	 * @return the dealer masters that was removed
	 */
	@Override
	public DealerMasters removeByDealerMastersById(long id)
		throws NoSuchDealerMastersException {

		DealerMasters dealerMasters = findByDealerMastersById(id);

		return remove(dealerMasters);
	}

	/**
	 * Returns the number of dealer masterses where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching dealer masterses
	 */
	@Override
	public int countByDealerMastersById(long id) {
		FinderPath finderPath = _finderPathCountByDealerMastersById;

		Object[] finderArgs = new Object[] {id};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DEALERMASTERS_WHERE);

			sb.append(_FINDER_COLUMN_DEALERMASTERSBYID_ID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(id);

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

	private static final String _FINDER_COLUMN_DEALERMASTERSBYID_ID_2 =
		"dealerMasters.id = ?";

	private FinderPath _finderPathWithPaginationFindBydealerMastersNidFinder;
	private FinderPath _finderPathWithoutPaginationFindBydealerMastersNidFinder;
	private FinderPath _finderPathCountBydealerMastersNidFinder;

	/**
	 * Returns all the dealer masterses where dealerNationalId = &#63;.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @return the matching dealer masterses
	 */
	@Override
	public List<DealerMasters> findBydealerMastersNidFinder(
		String dealerNationalId) {

		return findBydealerMastersNidFinder(
			dealerNationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dealer masterses where dealerNationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DealerMastersModelImpl</code>.
	 * </p>
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param start the lower bound of the range of dealer masterses
	 * @param end the upper bound of the range of dealer masterses (not inclusive)
	 * @return the range of matching dealer masterses
	 */
	@Override
	public List<DealerMasters> findBydealerMastersNidFinder(
		String dealerNationalId, int start, int end) {

		return findBydealerMastersNidFinder(dealerNationalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dealer masterses where dealerNationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DealerMastersModelImpl</code>.
	 * </p>
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param start the lower bound of the range of dealer masterses
	 * @param end the upper bound of the range of dealer masterses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dealer masterses
	 */
	@Override
	public List<DealerMasters> findBydealerMastersNidFinder(
		String dealerNationalId, int start, int end,
		OrderByComparator<DealerMasters> orderByComparator) {

		return findBydealerMastersNidFinder(
			dealerNationalId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dealer masterses where dealerNationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DealerMastersModelImpl</code>.
	 * </p>
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param start the lower bound of the range of dealer masterses
	 * @param end the upper bound of the range of dealer masterses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dealer masterses
	 */
	@Override
	public List<DealerMasters> findBydealerMastersNidFinder(
		String dealerNationalId, int start, int end,
		OrderByComparator<DealerMasters> orderByComparator,
		boolean useFinderCache) {

		dealerNationalId = Objects.toString(dealerNationalId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydealerMastersNidFinder;
				finderArgs = new Object[] {dealerNationalId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBydealerMastersNidFinder;
			finderArgs = new Object[] {
				dealerNationalId, start, end, orderByComparator
			};
		}

		List<DealerMasters> list = null;

		if (useFinderCache) {
			list = (List<DealerMasters>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DealerMasters dealerMasters : list) {
					if (!dealerNationalId.equals(
							dealerMasters.getDealerNationalId())) {

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

			sb.append(_SQL_SELECT_DEALERMASTERS_WHERE);

			boolean bindDealerNationalId = false;

			if (dealerNationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DEALERMASTERSNIDFINDER_DEALERNATIONALID_3);
			}
			else {
				bindDealerNationalId = true;

				sb.append(
					_FINDER_COLUMN_DEALERMASTERSNIDFINDER_DEALERNATIONALID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DealerMastersModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDealerNationalId) {
					queryPos.add(dealerNationalId);
				}

				list = (List<DealerMasters>)QueryUtil.list(
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
	 * Returns the first dealer masters in the ordered set where dealerNationalId = &#63;.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dealer masters
	 * @throws NoSuchDealerMastersException if a matching dealer masters could not be found
	 */
	@Override
	public DealerMasters findBydealerMastersNidFinder_First(
			String dealerNationalId,
			OrderByComparator<DealerMasters> orderByComparator)
		throws NoSuchDealerMastersException {

		DealerMasters dealerMasters = fetchBydealerMastersNidFinder_First(
			dealerNationalId, orderByComparator);

		if (dealerMasters != null) {
			return dealerMasters;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dealerNationalId=");
		sb.append(dealerNationalId);

		sb.append("}");

		throw new NoSuchDealerMastersException(sb.toString());
	}

	/**
	 * Returns the first dealer masters in the ordered set where dealerNationalId = &#63;.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dealer masters, or <code>null</code> if a matching dealer masters could not be found
	 */
	@Override
	public DealerMasters fetchBydealerMastersNidFinder_First(
		String dealerNationalId,
		OrderByComparator<DealerMasters> orderByComparator) {

		List<DealerMasters> list = findBydealerMastersNidFinder(
			dealerNationalId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dealer masters in the ordered set where dealerNationalId = &#63;.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dealer masters
	 * @throws NoSuchDealerMastersException if a matching dealer masters could not be found
	 */
	@Override
	public DealerMasters findBydealerMastersNidFinder_Last(
			String dealerNationalId,
			OrderByComparator<DealerMasters> orderByComparator)
		throws NoSuchDealerMastersException {

		DealerMasters dealerMasters = fetchBydealerMastersNidFinder_Last(
			dealerNationalId, orderByComparator);

		if (dealerMasters != null) {
			return dealerMasters;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dealerNationalId=");
		sb.append(dealerNationalId);

		sb.append("}");

		throw new NoSuchDealerMastersException(sb.toString());
	}

	/**
	 * Returns the last dealer masters in the ordered set where dealerNationalId = &#63;.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dealer masters, or <code>null</code> if a matching dealer masters could not be found
	 */
	@Override
	public DealerMasters fetchBydealerMastersNidFinder_Last(
		String dealerNationalId,
		OrderByComparator<DealerMasters> orderByComparator) {

		int count = countBydealerMastersNidFinder(dealerNationalId);

		if (count == 0) {
			return null;
		}

		List<DealerMasters> list = findBydealerMastersNidFinder(
			dealerNationalId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dealer masterses before and after the current dealer masters in the ordered set where dealerNationalId = &#63;.
	 *
	 * @param id the primary key of the current dealer masters
	 * @param dealerNationalId the dealer national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dealer masters
	 * @throws NoSuchDealerMastersException if a dealer masters with the primary key could not be found
	 */
	@Override
	public DealerMasters[] findBydealerMastersNidFinder_PrevAndNext(
			long id, String dealerNationalId,
			OrderByComparator<DealerMasters> orderByComparator)
		throws NoSuchDealerMastersException {

		dealerNationalId = Objects.toString(dealerNationalId, "");

		DealerMasters dealerMasters = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DealerMasters[] array = new DealerMastersImpl[3];

			array[0] = getBydealerMastersNidFinder_PrevAndNext(
				session, dealerMasters, dealerNationalId, orderByComparator,
				true);

			array[1] = dealerMasters;

			array[2] = getBydealerMastersNidFinder_PrevAndNext(
				session, dealerMasters, dealerNationalId, orderByComparator,
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

	protected DealerMasters getBydealerMastersNidFinder_PrevAndNext(
		Session session, DealerMasters dealerMasters, String dealerNationalId,
		OrderByComparator<DealerMasters> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DEALERMASTERS_WHERE);

		boolean bindDealerNationalId = false;

		if (dealerNationalId.isEmpty()) {
			sb.append(_FINDER_COLUMN_DEALERMASTERSNIDFINDER_DEALERNATIONALID_3);
		}
		else {
			bindDealerNationalId = true;

			sb.append(_FINDER_COLUMN_DEALERMASTERSNIDFINDER_DEALERNATIONALID_2);
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
			sb.append(DealerMastersModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDealerNationalId) {
			queryPos.add(dealerNationalId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dealerMasters)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DealerMasters> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dealer masterses where dealerNationalId = &#63; from the database.
	 *
	 * @param dealerNationalId the dealer national ID
	 */
	@Override
	public void removeBydealerMastersNidFinder(String dealerNationalId) {
		for (DealerMasters dealerMasters :
				findBydealerMastersNidFinder(
					dealerNationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dealerMasters);
		}
	}

	/**
	 * Returns the number of dealer masterses where dealerNationalId = &#63;.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @return the number of matching dealer masterses
	 */
	@Override
	public int countBydealerMastersNidFinder(String dealerNationalId) {
		dealerNationalId = Objects.toString(dealerNationalId, "");

		FinderPath finderPath = _finderPathCountBydealerMastersNidFinder;

		Object[] finderArgs = new Object[] {dealerNationalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DEALERMASTERS_WHERE);

			boolean bindDealerNationalId = false;

			if (dealerNationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DEALERMASTERSNIDFINDER_DEALERNATIONALID_3);
			}
			else {
				bindDealerNationalId = true;

				sb.append(
					_FINDER_COLUMN_DEALERMASTERSNIDFINDER_DEALERNATIONALID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDealerNationalId) {
					queryPos.add(dealerNationalId);
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
		_FINDER_COLUMN_DEALERMASTERSNIDFINDER_DEALERNATIONALID_2 =
			"dealerMasters.dealerNationalId = ?";

	private static final String
		_FINDER_COLUMN_DEALERMASTERSNIDFINDER_DEALERNATIONALID_3 =
			"(dealerMasters.dealerNationalId IS NULL OR dealerMasters.dealerNationalId = '')";

	private FinderPath _finderPathFetchBydealerMastersByNidAndMobile;
	private FinderPath _finderPathCountBydealerMastersByNidAndMobile;

	/**
	 * Returns the dealer masters where dealerNationalId = &#63; and dealerMobileNo = &#63; or throws a <code>NoSuchDealerMastersException</code> if it could not be found.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param dealerMobileNo the dealer mobile no
	 * @return the matching dealer masters
	 * @throws NoSuchDealerMastersException if a matching dealer masters could not be found
	 */
	@Override
	public DealerMasters findBydealerMastersByNidAndMobile(
			String dealerNationalId, String dealerMobileNo)
		throws NoSuchDealerMastersException {

		DealerMasters dealerMasters = fetchBydealerMastersByNidAndMobile(
			dealerNationalId, dealerMobileNo);

		if (dealerMasters == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("dealerNationalId=");
			sb.append(dealerNationalId);

			sb.append(", dealerMobileNo=");
			sb.append(dealerMobileNo);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDealerMastersException(sb.toString());
		}

		return dealerMasters;
	}

	/**
	 * Returns the dealer masters where dealerNationalId = &#63; and dealerMobileNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param dealerMobileNo the dealer mobile no
	 * @return the matching dealer masters, or <code>null</code> if a matching dealer masters could not be found
	 */
	@Override
	public DealerMasters fetchBydealerMastersByNidAndMobile(
		String dealerNationalId, String dealerMobileNo) {

		return fetchBydealerMastersByNidAndMobile(
			dealerNationalId, dealerMobileNo, true);
	}

	/**
	 * Returns the dealer masters where dealerNationalId = &#63; and dealerMobileNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param dealerMobileNo the dealer mobile no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dealer masters, or <code>null</code> if a matching dealer masters could not be found
	 */
	@Override
	public DealerMasters fetchBydealerMastersByNidAndMobile(
		String dealerNationalId, String dealerMobileNo,
		boolean useFinderCache) {

		dealerNationalId = Objects.toString(dealerNationalId, "");
		dealerMobileNo = Objects.toString(dealerMobileNo, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {dealerNationalId, dealerMobileNo};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBydealerMastersByNidAndMobile, finderArgs,
				this);
		}

		if (result instanceof DealerMasters) {
			DealerMasters dealerMasters = (DealerMasters)result;

			if (!Objects.equals(
					dealerNationalId, dealerMasters.getDealerNationalId()) ||
				!Objects.equals(
					dealerMobileNo, dealerMasters.getDealerMobileNo())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DEALERMASTERS_WHERE);

			boolean bindDealerNationalId = false;

			if (dealerNationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DEALERMASTERSBYNIDANDMOBILE_DEALERNATIONALID_3);
			}
			else {
				bindDealerNationalId = true;

				sb.append(
					_FINDER_COLUMN_DEALERMASTERSBYNIDANDMOBILE_DEALERNATIONALID_2);
			}

			boolean bindDealerMobileNo = false;

			if (dealerMobileNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DEALERMASTERSBYNIDANDMOBILE_DEALERMOBILENO_3);
			}
			else {
				bindDealerMobileNo = true;

				sb.append(
					_FINDER_COLUMN_DEALERMASTERSBYNIDANDMOBILE_DEALERMOBILENO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDealerNationalId) {
					queryPos.add(dealerNationalId);
				}

				if (bindDealerMobileNo) {
					queryPos.add(dealerMobileNo);
				}

				List<DealerMasters> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBydealerMastersByNidAndMobile,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									dealerNationalId, dealerMobileNo
								};
							}

							_log.warn(
								"DealerMastersPersistenceImpl.fetchBydealerMastersByNidAndMobile(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DealerMasters dealerMasters = list.get(0);

					result = dealerMasters;

					cacheResult(dealerMasters);
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
			return (DealerMasters)result;
		}
	}

	/**
	 * Removes the dealer masters where dealerNationalId = &#63; and dealerMobileNo = &#63; from the database.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param dealerMobileNo the dealer mobile no
	 * @return the dealer masters that was removed
	 */
	@Override
	public DealerMasters removeBydealerMastersByNidAndMobile(
			String dealerNationalId, String dealerMobileNo)
		throws NoSuchDealerMastersException {

		DealerMasters dealerMasters = findBydealerMastersByNidAndMobile(
			dealerNationalId, dealerMobileNo);

		return remove(dealerMasters);
	}

	/**
	 * Returns the number of dealer masterses where dealerNationalId = &#63; and dealerMobileNo = &#63;.
	 *
	 * @param dealerNationalId the dealer national ID
	 * @param dealerMobileNo the dealer mobile no
	 * @return the number of matching dealer masterses
	 */
	@Override
	public int countBydealerMastersByNidAndMobile(
		String dealerNationalId, String dealerMobileNo) {

		dealerNationalId = Objects.toString(dealerNationalId, "");
		dealerMobileNo = Objects.toString(dealerMobileNo, "");

		FinderPath finderPath = _finderPathCountBydealerMastersByNidAndMobile;

		Object[] finderArgs = new Object[] {dealerNationalId, dealerMobileNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DEALERMASTERS_WHERE);

			boolean bindDealerNationalId = false;

			if (dealerNationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DEALERMASTERSBYNIDANDMOBILE_DEALERNATIONALID_3);
			}
			else {
				bindDealerNationalId = true;

				sb.append(
					_FINDER_COLUMN_DEALERMASTERSBYNIDANDMOBILE_DEALERNATIONALID_2);
			}

			boolean bindDealerMobileNo = false;

			if (dealerMobileNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DEALERMASTERSBYNIDANDMOBILE_DEALERMOBILENO_3);
			}
			else {
				bindDealerMobileNo = true;

				sb.append(
					_FINDER_COLUMN_DEALERMASTERSBYNIDANDMOBILE_DEALERMOBILENO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDealerNationalId) {
					queryPos.add(dealerNationalId);
				}

				if (bindDealerMobileNo) {
					queryPos.add(dealerMobileNo);
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
		_FINDER_COLUMN_DEALERMASTERSBYNIDANDMOBILE_DEALERNATIONALID_2 =
			"dealerMasters.dealerNationalId = ? AND ";

	private static final String
		_FINDER_COLUMN_DEALERMASTERSBYNIDANDMOBILE_DEALERNATIONALID_3 =
			"(dealerMasters.dealerNationalId IS NULL OR dealerMasters.dealerNationalId = '') AND ";

	private static final String
		_FINDER_COLUMN_DEALERMASTERSBYNIDANDMOBILE_DEALERMOBILENO_2 =
			"dealerMasters.dealerMobileNo = ?";

	private static final String
		_FINDER_COLUMN_DEALERMASTERSBYNIDANDMOBILE_DEALERMOBILENO_3 =
			"(dealerMasters.dealerMobileNo IS NULL OR dealerMasters.dealerMobileNo = '')";

	private FinderPath _finderPathFetchByDealerMastersBySecondNidAndMobile;
	private FinderPath _finderPathCountByDealerMastersBySecondNidAndMobile;

	/**
	 * Returns the dealer masters where secondNationalId = &#63; and dealerMobileNo = &#63; or throws a <code>NoSuchDealerMastersException</code> if it could not be found.
	 *
	 * @param secondNationalId the second national ID
	 * @param dealerMobileNo the dealer mobile no
	 * @return the matching dealer masters
	 * @throws NoSuchDealerMastersException if a matching dealer masters could not be found
	 */
	@Override
	public DealerMasters findByDealerMastersBySecondNidAndMobile(
			String secondNationalId, String dealerMobileNo)
		throws NoSuchDealerMastersException {

		DealerMasters dealerMasters = fetchByDealerMastersBySecondNidAndMobile(
			secondNationalId, dealerMobileNo);

		if (dealerMasters == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("secondNationalId=");
			sb.append(secondNationalId);

			sb.append(", dealerMobileNo=");
			sb.append(dealerMobileNo);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDealerMastersException(sb.toString());
		}

		return dealerMasters;
	}

	/**
	 * Returns the dealer masters where secondNationalId = &#63; and dealerMobileNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param secondNationalId the second national ID
	 * @param dealerMobileNo the dealer mobile no
	 * @return the matching dealer masters, or <code>null</code> if a matching dealer masters could not be found
	 */
	@Override
	public DealerMasters fetchByDealerMastersBySecondNidAndMobile(
		String secondNationalId, String dealerMobileNo) {

		return fetchByDealerMastersBySecondNidAndMobile(
			secondNationalId, dealerMobileNo, true);
	}

	/**
	 * Returns the dealer masters where secondNationalId = &#63; and dealerMobileNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param secondNationalId the second national ID
	 * @param dealerMobileNo the dealer mobile no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dealer masters, or <code>null</code> if a matching dealer masters could not be found
	 */
	@Override
	public DealerMasters fetchByDealerMastersBySecondNidAndMobile(
		String secondNationalId, String dealerMobileNo,
		boolean useFinderCache) {

		secondNationalId = Objects.toString(secondNationalId, "");
		dealerMobileNo = Objects.toString(dealerMobileNo, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {secondNationalId, dealerMobileNo};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDealerMastersBySecondNidAndMobile, finderArgs,
				this);
		}

		if (result instanceof DealerMasters) {
			DealerMasters dealerMasters = (DealerMasters)result;

			if (!Objects.equals(
					secondNationalId, dealerMasters.getSecondNationalId()) ||
				!Objects.equals(
					dealerMobileNo, dealerMasters.getDealerMobileNo())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DEALERMASTERS_WHERE);

			boolean bindSecondNationalId = false;

			if (secondNationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DEALERMASTERSBYSECONDNIDANDMOBILE_SECONDNATIONALID_3);
			}
			else {
				bindSecondNationalId = true;

				sb.append(
					_FINDER_COLUMN_DEALERMASTERSBYSECONDNIDANDMOBILE_SECONDNATIONALID_2);
			}

			boolean bindDealerMobileNo = false;

			if (dealerMobileNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DEALERMASTERSBYSECONDNIDANDMOBILE_DEALERMOBILENO_3);
			}
			else {
				bindDealerMobileNo = true;

				sb.append(
					_FINDER_COLUMN_DEALERMASTERSBYSECONDNIDANDMOBILE_DEALERMOBILENO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSecondNationalId) {
					queryPos.add(secondNationalId);
				}

				if (bindDealerMobileNo) {
					queryPos.add(dealerMobileNo);
				}

				List<DealerMasters> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDealerMastersBySecondNidAndMobile,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									secondNationalId, dealerMobileNo
								};
							}

							_log.warn(
								"DealerMastersPersistenceImpl.fetchByDealerMastersBySecondNidAndMobile(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DealerMasters dealerMasters = list.get(0);

					result = dealerMasters;

					cacheResult(dealerMasters);
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
			return (DealerMasters)result;
		}
	}

	/**
	 * Removes the dealer masters where secondNationalId = &#63; and dealerMobileNo = &#63; from the database.
	 *
	 * @param secondNationalId the second national ID
	 * @param dealerMobileNo the dealer mobile no
	 * @return the dealer masters that was removed
	 */
	@Override
	public DealerMasters removeByDealerMastersBySecondNidAndMobile(
			String secondNationalId, String dealerMobileNo)
		throws NoSuchDealerMastersException {

		DealerMasters dealerMasters = findByDealerMastersBySecondNidAndMobile(
			secondNationalId, dealerMobileNo);

		return remove(dealerMasters);
	}

	/**
	 * Returns the number of dealer masterses where secondNationalId = &#63; and dealerMobileNo = &#63;.
	 *
	 * @param secondNationalId the second national ID
	 * @param dealerMobileNo the dealer mobile no
	 * @return the number of matching dealer masterses
	 */
	@Override
	public int countByDealerMastersBySecondNidAndMobile(
		String secondNationalId, String dealerMobileNo) {

		secondNationalId = Objects.toString(secondNationalId, "");
		dealerMobileNo = Objects.toString(dealerMobileNo, "");

		FinderPath finderPath =
			_finderPathCountByDealerMastersBySecondNidAndMobile;

		Object[] finderArgs = new Object[] {secondNationalId, dealerMobileNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DEALERMASTERS_WHERE);

			boolean bindSecondNationalId = false;

			if (secondNationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DEALERMASTERSBYSECONDNIDANDMOBILE_SECONDNATIONALID_3);
			}
			else {
				bindSecondNationalId = true;

				sb.append(
					_FINDER_COLUMN_DEALERMASTERSBYSECONDNIDANDMOBILE_SECONDNATIONALID_2);
			}

			boolean bindDealerMobileNo = false;

			if (dealerMobileNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DEALERMASTERSBYSECONDNIDANDMOBILE_DEALERMOBILENO_3);
			}
			else {
				bindDealerMobileNo = true;

				sb.append(
					_FINDER_COLUMN_DEALERMASTERSBYSECONDNIDANDMOBILE_DEALERMOBILENO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSecondNationalId) {
					queryPos.add(secondNationalId);
				}

				if (bindDealerMobileNo) {
					queryPos.add(dealerMobileNo);
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
		_FINDER_COLUMN_DEALERMASTERSBYSECONDNIDANDMOBILE_SECONDNATIONALID_2 =
			"dealerMasters.secondNationalId = ? AND ";

	private static final String
		_FINDER_COLUMN_DEALERMASTERSBYSECONDNIDANDMOBILE_SECONDNATIONALID_3 =
			"(dealerMasters.secondNationalId IS NULL OR dealerMasters.secondNationalId = '') AND ";

	private static final String
		_FINDER_COLUMN_DEALERMASTERSBYSECONDNIDANDMOBILE_DEALERMOBILENO_2 =
			"dealerMasters.dealerMobileNo = ?";

	private static final String
		_FINDER_COLUMN_DEALERMASTERSBYSECONDNIDANDMOBILE_DEALERMOBILENO_3 =
			"(dealerMasters.dealerMobileNo IS NULL OR dealerMasters.dealerMobileNo = '')";

	private FinderPath _finderPathFetchByDealerMastersByMobileNo;
	private FinderPath _finderPathCountByDealerMastersByMobileNo;

	/**
	 * Returns the dealer masters where dealerMobileNo = &#63; or throws a <code>NoSuchDealerMastersException</code> if it could not be found.
	 *
	 * @param dealerMobileNo the dealer mobile no
	 * @return the matching dealer masters
	 * @throws NoSuchDealerMastersException if a matching dealer masters could not be found
	 */
	@Override
	public DealerMasters findByDealerMastersByMobileNo(String dealerMobileNo)
		throws NoSuchDealerMastersException {

		DealerMasters dealerMasters = fetchByDealerMastersByMobileNo(
			dealerMobileNo);

		if (dealerMasters == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("dealerMobileNo=");
			sb.append(dealerMobileNo);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDealerMastersException(sb.toString());
		}

		return dealerMasters;
	}

	/**
	 * Returns the dealer masters where dealerMobileNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dealerMobileNo the dealer mobile no
	 * @return the matching dealer masters, or <code>null</code> if a matching dealer masters could not be found
	 */
	@Override
	public DealerMasters fetchByDealerMastersByMobileNo(String dealerMobileNo) {
		return fetchByDealerMastersByMobileNo(dealerMobileNo, true);
	}

	/**
	 * Returns the dealer masters where dealerMobileNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dealerMobileNo the dealer mobile no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dealer masters, or <code>null</code> if a matching dealer masters could not be found
	 */
	@Override
	public DealerMasters fetchByDealerMastersByMobileNo(
		String dealerMobileNo, boolean useFinderCache) {

		dealerMobileNo = Objects.toString(dealerMobileNo, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {dealerMobileNo};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDealerMastersByMobileNo, finderArgs, this);
		}

		if (result instanceof DealerMasters) {
			DealerMasters dealerMasters = (DealerMasters)result;

			if (!Objects.equals(
					dealerMobileNo, dealerMasters.getDealerMobileNo())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DEALERMASTERS_WHERE);

			boolean bindDealerMobileNo = false;

			if (dealerMobileNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DEALERMASTERSBYMOBILENO_DEALERMOBILENO_3);
			}
			else {
				bindDealerMobileNo = true;

				sb.append(
					_FINDER_COLUMN_DEALERMASTERSBYMOBILENO_DEALERMOBILENO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDealerMobileNo) {
					queryPos.add(dealerMobileNo);
				}

				List<DealerMasters> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDealerMastersByMobileNo,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {dealerMobileNo};
							}

							_log.warn(
								"DealerMastersPersistenceImpl.fetchByDealerMastersByMobileNo(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DealerMasters dealerMasters = list.get(0);

					result = dealerMasters;

					cacheResult(dealerMasters);
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
			return (DealerMasters)result;
		}
	}

	/**
	 * Removes the dealer masters where dealerMobileNo = &#63; from the database.
	 *
	 * @param dealerMobileNo the dealer mobile no
	 * @return the dealer masters that was removed
	 */
	@Override
	public DealerMasters removeByDealerMastersByMobileNo(String dealerMobileNo)
		throws NoSuchDealerMastersException {

		DealerMasters dealerMasters = findByDealerMastersByMobileNo(
			dealerMobileNo);

		return remove(dealerMasters);
	}

	/**
	 * Returns the number of dealer masterses where dealerMobileNo = &#63;.
	 *
	 * @param dealerMobileNo the dealer mobile no
	 * @return the number of matching dealer masterses
	 */
	@Override
	public int countByDealerMastersByMobileNo(String dealerMobileNo) {
		dealerMobileNo = Objects.toString(dealerMobileNo, "");

		FinderPath finderPath = _finderPathCountByDealerMastersByMobileNo;

		Object[] finderArgs = new Object[] {dealerMobileNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DEALERMASTERS_WHERE);

			boolean bindDealerMobileNo = false;

			if (dealerMobileNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DEALERMASTERSBYMOBILENO_DEALERMOBILENO_3);
			}
			else {
				bindDealerMobileNo = true;

				sb.append(
					_FINDER_COLUMN_DEALERMASTERSBYMOBILENO_DEALERMOBILENO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDealerMobileNo) {
					queryPos.add(dealerMobileNo);
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
		_FINDER_COLUMN_DEALERMASTERSBYMOBILENO_DEALERMOBILENO_2 =
			"dealerMasters.dealerMobileNo = ?";

	private static final String
		_FINDER_COLUMN_DEALERMASTERSBYMOBILENO_DEALERMOBILENO_3 =
			"(dealerMasters.dealerMobileNo IS NULL OR dealerMasters.dealerMobileNo = '')";

	public DealerMastersPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("unionId", "union_id");
		dbColumnNames.put("dealerName", "dealer_name");
		dbColumnNames.put("dealerNameEn", "dealer_name_en");
		dbColumnNames.put("dealerSlug", "dealer_slug");
		dbColumnNames.put("fatherName", "father_name");
		dbColumnNames.put("motherName", "mother_name");
		dbColumnNames.put("birthDate", "birth_date");
		dbColumnNames.put("imagePathReal", "image_path_real");
		dbColumnNames.put("imagePathEc", "image_path_ec");
		dbColumnNames.put("ecPmDivision", "ec_pm_division");
		dbColumnNames.put("ecPmDistrict", "ec_pm_district");
		dbColumnNames.put("ecPmRmo", "ec_pm_rmo");
		dbColumnNames.put("ecPmUpazila", "ec_pm_upazila");
		dbColumnNames.put("ecPmUnionWard", "ec_pm_union_ward");
		dbColumnNames.put("ecPmWardUnionPorishod", "ec_pm_ward_union_porishod");
		dbColumnNames.put("ecPmPostOffice", "ec_pm_post_office");
		dbColumnNames.put("ecPmPostalCode", "ec_pm_postal_code");
		dbColumnNames.put("ecPmMouzaMoholla", "ec_pm_mouza_moholla");
		dbColumnNames.put(
			"ecPmAdditionalMouzaMoholla", "ec_pm_additional_mouza_moholla");
		dbColumnNames.put("ecPmVillageRoad", "ec_pm_village_road");
		dbColumnNames.put(
			"ecPmAdditionalVillageRoad", "ec_pm_additional_village_road");
		dbColumnNames.put("ecPmHomeHoldingNo", "ec_pm_home_holding_no");
		dbColumnNames.put("ecPmRegion", "ec_pm_region");
		dbColumnNames.put("ecPrDivision", "ec_pr_division");
		dbColumnNames.put("ecPrDistrict", "ec_pr_district");
		dbColumnNames.put("ecPrRmo", "ec_pr_rmo");
		dbColumnNames.put("ecPrUpazila", "ec_pr_upazila");
		dbColumnNames.put(
			"ecPrCityCorpMunicipality", "ec_pr_city_corp_municipality");
		dbColumnNames.put("ecPrUnionWard", "ec_pr_union_ward");
		dbColumnNames.put("ecPrPostOffice", "ec_pr_post_office");
		dbColumnNames.put("ecPrPostalCode", "ec_pr_postal_code");
		dbColumnNames.put("ecPrWardUnionPorishod", "ec_pr_ward_union_porishod");
		dbColumnNames.put("ecPrMouzaMoholla", "ec_pr_mouza_moholla");
		dbColumnNames.put(
			"ecPrAdditionalMouzaMoholla", "ec_pr_additional_mouza_moholla");
		dbColumnNames.put("ecPrVillageRoad", "ec_pr_village_road");
		dbColumnNames.put(
			"ecPrAdditionalVillageRoad", "ec_pr_additional_village_road");
		dbColumnNames.put("ecPrHomeHoldingNo", "ec_pr_home_holding_no");
		dbColumnNames.put("ecPrRegion", "ec_pr_region");
		dbColumnNames.put("ecOccupation", "ec_occupation");
		dbColumnNames.put("ecBloodGroup", "ec_blood_group");
		dbColumnNames.put("pmDivisionId", "pm_division_id");
		dbColumnNames.put("pmDistrictId", "pm_district_id");
		dbColumnNames.put("pmUpazilaId", "pm_upazila_id");
		dbColumnNames.put("pmUnionId", "pm_union_id");
		dbColumnNames.put("pmPostOffice", "pm_post_office");
		dbColumnNames.put("pmWordNo", "pm_word_no");
		dbColumnNames.put("pmVillage", "pm_village");
		dbColumnNames.put("pmHoldingInfo", "pm_holding_info");
		dbColumnNames.put("prDivisionId", "pr_division_id");
		dbColumnNames.put("prDistrictId", "pr_district_id");
		dbColumnNames.put("prUpazilaId", "pr_upazila_id");
		dbColumnNames.put("prUnionId", "pr_union_id");
		dbColumnNames.put("prPostOffice", "pr_post_office");
		dbColumnNames.put("prWordNo", "pr_word_no");
		dbColumnNames.put("prVillage", "pr_village");
		dbColumnNames.put("prHoldingInfo", "pr_holding_info");
		dbColumnNames.put("dealerMobileNo", "dealer_mobile_no");
		dbColumnNames.put("dealerNationalId", "dealer_national_id");
		dbColumnNames.put("secondNationalId", "second_national_id");
		dbColumnNames.put("spouseName", "spouse_name");
		dbColumnNames.put("spouseFatherName", "spouse_father_name");
		dbColumnNames.put("spouseBirthDate", "spouse_birth_date");
		dbColumnNames.put("spouseNid", "spouse_nid");
		dbColumnNames.put("spouseSecondNid", "spouse_second_nid");
		dbColumnNames.put("govtEmployee", "govt_employee");
		dbColumnNames.put("publicRepresentative", "public_representative");
		dbColumnNames.put("vgdStatus", "vgd_status");
		dbColumnNames.put("cardNoFromOne", "card_no_from_one");
		dbColumnNames.put("cardNoToOne", "card_no_to_one");
		dbColumnNames.put("cardNoFromTwo", "card_no_from_two");
		dbColumnNames.put("cardNoToTwo", "card_no_to_two");
		dbColumnNames.put("cardNoFromThree", "card_no_from_three");
		dbColumnNames.put("cardNoToThree", "card_no_to_three");
		dbColumnNames.put("createdAt", "created_at");
		dbColumnNames.put("updatedAt", "updated_at");
		dbColumnNames.put("cardNoFromFour", "card_no_from_four");
		dbColumnNames.put("cardNoToFour", "card_no_to_four");
		dbColumnNames.put("cardNoFromFive", "card_no_from_five");
		dbColumnNames.put("cardNoToFive", "card_no_to_five");
		dbColumnNames.put("singleCards", "single_cards");
		dbColumnNames.put("userId", "user_id");
		dbColumnNames.put("additionalUnionId", "additional_union_id");
		dbColumnNames.put("upazilaId", "upazila_id");

		setDBColumnNames(dbColumnNames);

		setModelClass(DealerMasters.class);

		setModelImplClass(DealerMastersImpl.class);
		setModelPKClass(long.class);

		setTable(DealerMastersTable.INSTANCE);
	}

	/**
	 * Caches the dealer masters in the entity cache if it is enabled.
	 *
	 * @param dealerMasters the dealer masters
	 */
	@Override
	public void cacheResult(DealerMasters dealerMasters) {
		entityCache.putResult(
			DealerMastersImpl.class, dealerMasters.getPrimaryKey(),
			dealerMasters);

		finderCache.putResult(
			_finderPathFetchByDealerMastersById,
			new Object[] {dealerMasters.getId()}, dealerMasters);

		finderCache.putResult(
			_finderPathFetchBydealerMastersByNidAndMobile,
			new Object[] {
				dealerMasters.getDealerNationalId(),
				dealerMasters.getDealerMobileNo()
			},
			dealerMasters);

		finderCache.putResult(
			_finderPathFetchByDealerMastersBySecondNidAndMobile,
			new Object[] {
				dealerMasters.getSecondNationalId(),
				dealerMasters.getDealerMobileNo()
			},
			dealerMasters);

		finderCache.putResult(
			_finderPathFetchByDealerMastersByMobileNo,
			new Object[] {dealerMasters.getDealerMobileNo()}, dealerMasters);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dealer masterses in the entity cache if it is enabled.
	 *
	 * @param dealerMasterses the dealer masterses
	 */
	@Override
	public void cacheResult(List<DealerMasters> dealerMasterses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dealerMasterses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DealerMasters dealerMasters : dealerMasterses) {
			if (entityCache.getResult(
					DealerMastersImpl.class, dealerMasters.getPrimaryKey()) ==
						null) {

				cacheResult(dealerMasters);
			}
		}
	}

	/**
	 * Clears the cache for all dealer masterses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DealerMastersImpl.class);

		finderCache.clearCache(DealerMastersImpl.class);
	}

	/**
	 * Clears the cache for the dealer masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DealerMasters dealerMasters) {
		entityCache.removeResult(DealerMastersImpl.class, dealerMasters);
	}

	@Override
	public void clearCache(List<DealerMasters> dealerMasterses) {
		for (DealerMasters dealerMasters : dealerMasterses) {
			entityCache.removeResult(DealerMastersImpl.class, dealerMasters);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DealerMastersImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DealerMastersImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DealerMastersModelImpl dealerMastersModelImpl) {

		Object[] args = new Object[] {dealerMastersModelImpl.getId()};

		finderCache.putResult(
			_finderPathCountByDealerMastersById, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDealerMastersById, args, dealerMastersModelImpl);

		args = new Object[] {
			dealerMastersModelImpl.getDealerNationalId(),
			dealerMastersModelImpl.getDealerMobileNo()
		};

		finderCache.putResult(
			_finderPathCountBydealerMastersByNidAndMobile, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchBydealerMastersByNidAndMobile, args,
			dealerMastersModelImpl);

		args = new Object[] {
			dealerMastersModelImpl.getSecondNationalId(),
			dealerMastersModelImpl.getDealerMobileNo()
		};

		finderCache.putResult(
			_finderPathCountByDealerMastersBySecondNidAndMobile, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDealerMastersBySecondNidAndMobile, args,
			dealerMastersModelImpl);

		args = new Object[] {dealerMastersModelImpl.getDealerMobileNo()};

		finderCache.putResult(
			_finderPathCountByDealerMastersByMobileNo, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDealerMastersByMobileNo, args,
			dealerMastersModelImpl);
	}

	/**
	 * Creates a new dealer masters with the primary key. Does not add the dealer masters to the database.
	 *
	 * @param id the primary key for the new dealer masters
	 * @return the new dealer masters
	 */
	@Override
	public DealerMasters create(long id) {
		DealerMasters dealerMasters = new DealerMastersImpl();

		dealerMasters.setNew(true);
		dealerMasters.setPrimaryKey(id);

		return dealerMasters;
	}

	/**
	 * Removes the dealer masters with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dealer masters
	 * @return the dealer masters that was removed
	 * @throws NoSuchDealerMastersException if a dealer masters with the primary key could not be found
	 */
	@Override
	public DealerMasters remove(long id) throws NoSuchDealerMastersException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the dealer masters with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dealer masters
	 * @return the dealer masters that was removed
	 * @throws NoSuchDealerMastersException if a dealer masters with the primary key could not be found
	 */
	@Override
	public DealerMasters remove(Serializable primaryKey)
		throws NoSuchDealerMastersException {

		Session session = null;

		try {
			session = openSession();

			DealerMasters dealerMasters = (DealerMasters)session.get(
				DealerMastersImpl.class, primaryKey);

			if (dealerMasters == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDealerMastersException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dealerMasters);
		}
		catch (NoSuchDealerMastersException noSuchEntityException) {
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
	protected DealerMasters removeImpl(DealerMasters dealerMasters) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dealerMasters)) {
				dealerMasters = (DealerMasters)session.get(
					DealerMastersImpl.class, dealerMasters.getPrimaryKeyObj());
			}

			if (dealerMasters != null) {
				session.delete(dealerMasters);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dealerMasters != null) {
			clearCache(dealerMasters);
		}

		return dealerMasters;
	}

	@Override
	public DealerMasters updateImpl(DealerMasters dealerMasters) {
		boolean isNew = dealerMasters.isNew();

		if (!(dealerMasters instanceof DealerMastersModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dealerMasters.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dealerMasters);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dealerMasters proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DealerMasters implementation " +
					dealerMasters.getClass());
		}

		DealerMastersModelImpl dealerMastersModelImpl =
			(DealerMastersModelImpl)dealerMasters;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dealerMasters);
			}
			else {
				dealerMasters = (DealerMasters)session.merge(dealerMasters);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DealerMastersImpl.class, dealerMastersModelImpl, false, true);

		cacheUniqueFindersCache(dealerMastersModelImpl);

		if (isNew) {
			dealerMasters.setNew(false);
		}

		dealerMasters.resetOriginalValues();

		return dealerMasters;
	}

	/**
	 * Returns the dealer masters with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dealer masters
	 * @return the dealer masters
	 * @throws NoSuchDealerMastersException if a dealer masters with the primary key could not be found
	 */
	@Override
	public DealerMasters findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDealerMastersException {

		DealerMasters dealerMasters = fetchByPrimaryKey(primaryKey);

		if (dealerMasters == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDealerMastersException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dealerMasters;
	}

	/**
	 * Returns the dealer masters with the primary key or throws a <code>NoSuchDealerMastersException</code> if it could not be found.
	 *
	 * @param id the primary key of the dealer masters
	 * @return the dealer masters
	 * @throws NoSuchDealerMastersException if a dealer masters with the primary key could not be found
	 */
	@Override
	public DealerMasters findByPrimaryKey(long id)
		throws NoSuchDealerMastersException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the dealer masters with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dealer masters
	 * @return the dealer masters, or <code>null</code> if a dealer masters with the primary key could not be found
	 */
	@Override
	public DealerMasters fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the dealer masterses.
	 *
	 * @return the dealer masterses
	 */
	@Override
	public List<DealerMasters> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dealer masterses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DealerMastersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dealer masterses
	 * @param end the upper bound of the range of dealer masterses (not inclusive)
	 * @return the range of dealer masterses
	 */
	@Override
	public List<DealerMasters> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dealer masterses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DealerMastersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dealer masterses
	 * @param end the upper bound of the range of dealer masterses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dealer masterses
	 */
	@Override
	public List<DealerMasters> findAll(
		int start, int end,
		OrderByComparator<DealerMasters> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dealer masterses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DealerMastersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dealer masterses
	 * @param end the upper bound of the range of dealer masterses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dealer masterses
	 */
	@Override
	public List<DealerMasters> findAll(
		int start, int end, OrderByComparator<DealerMasters> orderByComparator,
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

		List<DealerMasters> list = null;

		if (useFinderCache) {
			list = (List<DealerMasters>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DEALERMASTERS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DEALERMASTERS;

				sql = sql.concat(DealerMastersModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DealerMasters>)QueryUtil.list(
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
	 * Removes all the dealer masterses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DealerMasters dealerMasters : findAll()) {
			remove(dealerMasters);
		}
	}

	/**
	 * Returns the number of dealer masterses.
	 *
	 * @return the number of dealer masterses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DEALERMASTERS);

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
		return _SQL_SELECT_DEALERMASTERS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DealerMastersModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dealer masters persistence.
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

		_finderPathFetchByDealerMastersById = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDealerMastersById",
			new String[] {Long.class.getName()}, new String[] {"id"}, true);

		_finderPathCountByDealerMastersById = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDealerMastersById", new String[] {Long.class.getName()},
			new String[] {"id"}, false);

		_finderPathWithPaginationFindBydealerMastersNidFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBydealerMastersNidFinder",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"dealer_national_id"}, true);

		_finderPathWithoutPaginationFindBydealerMastersNidFinder =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydealerMastersNidFinder",
				new String[] {String.class.getName()},
				new String[] {"dealer_national_id"}, true);

		_finderPathCountBydealerMastersNidFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydealerMastersNidFinder",
			new String[] {String.class.getName()},
			new String[] {"dealer_national_id"}, false);

		_finderPathFetchBydealerMastersByNidAndMobile = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBydealerMastersByNidAndMobile",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"dealer_national_id", "dealer_mobile_no"}, true);

		_finderPathCountBydealerMastersByNidAndMobile = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydealerMastersByNidAndMobile",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"dealer_national_id", "dealer_mobile_no"}, false);

		_finderPathFetchByDealerMastersBySecondNidAndMobile = new FinderPath(
			FINDER_CLASS_NAME_ENTITY,
			"fetchByDealerMastersBySecondNidAndMobile",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"second_national_id", "dealer_mobile_no"}, true);

		_finderPathCountByDealerMastersBySecondNidAndMobile = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDealerMastersBySecondNidAndMobile",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"second_national_id", "dealer_mobile_no"}, false);

		_finderPathFetchByDealerMastersByMobileNo = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDealerMastersByMobileNo",
			new String[] {String.class.getName()},
			new String[] {"dealer_mobile_no"}, true);

		_finderPathCountByDealerMastersByMobileNo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDealerMastersByMobileNo",
			new String[] {String.class.getName()},
			new String[] {"dealer_mobile_no"}, false);

		_setDealerMastersUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDealerMastersUtilPersistence(null);

		entityCache.removeCache(DealerMastersImpl.class.getName());
	}

	private void _setDealerMastersUtilPersistence(
		DealerMastersPersistence dealerMastersPersistence) {

		try {
			Field field = DealerMastersUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dealerMastersPersistence);
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

	private static final String _SQL_SELECT_DEALERMASTERS =
		"SELECT dealerMasters FROM DealerMasters dealerMasters";

	private static final String _SQL_SELECT_DEALERMASTERS_WHERE =
		"SELECT dealerMasters FROM DealerMasters dealerMasters WHERE ";

	private static final String _SQL_COUNT_DEALERMASTERS =
		"SELECT COUNT(dealerMasters) FROM DealerMasters dealerMasters";

	private static final String _SQL_COUNT_DEALERMASTERS_WHERE =
		"SELECT COUNT(dealerMasters) FROM DealerMasters dealerMasters WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dealerMasters.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DealerMasters exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DealerMasters exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DealerMastersPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"unionId", "dealerName", "dealerNameEn", "dealerSlug", "fatherName",
			"motherName", "birthDate", "imagePathReal", "imagePathEc",
			"ecPmDivision", "ecPmDistrict", "ecPmRmo", "ecPmUpazila",
			"ecPmUnionWard", "ecPmWardUnionPorishod", "ecPmPostOffice",
			"ecPmPostalCode", "ecPmMouzaMoholla", "ecPmAdditionalMouzaMoholla",
			"ecPmVillageRoad", "ecPmAdditionalVillageRoad", "ecPmHomeHoldingNo",
			"ecPmRegion", "ecPrDivision", "ecPrDistrict", "ecPrRmo",
			"ecPrUpazila", "ecPrCityCorpMunicipality", "ecPrUnionWard",
			"ecPrPostOffice", "ecPrPostalCode", "ecPrWardUnionPorishod",
			"ecPrMouzaMoholla", "ecPrAdditionalMouzaMoholla", "ecPrVillageRoad",
			"ecPrAdditionalVillageRoad", "ecPrHomeHoldingNo", "ecPrRegion",
			"ecOccupation", "ecBloodGroup", "pmDivisionId", "pmDistrictId",
			"pmUpazilaId", "pmUnionId", "pmPostOffice", "pmWordNo", "pmVillage",
			"pmHoldingInfo", "prDivisionId", "prDistrictId", "prUpazilaId",
			"prUnionId", "prPostOffice", "prWordNo", "prVillage",
			"prHoldingInfo", "dealerMobileNo", "dealerNationalId",
			"secondNationalId", "spouseName", "spouseFatherName",
			"spouseBirthDate", "spouseNid", "spouseSecondNid", "govtEmployee",
			"publicRepresentative", "vgdStatus", "cardNoFromOne", "cardNoToOne",
			"cardNoFromTwo", "cardNoToTwo", "cardNoFromThree", "cardNoToThree",
			"createdAt", "updatedAt", "cardNoFromFour", "cardNoToFour",
			"cardNoFromFive", "cardNoToFive", "singleCards", "userId",
			"additionalUnionId", "upazilaId"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}