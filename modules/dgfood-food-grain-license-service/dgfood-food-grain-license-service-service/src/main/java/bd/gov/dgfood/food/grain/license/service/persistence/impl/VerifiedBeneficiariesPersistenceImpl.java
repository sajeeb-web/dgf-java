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

import bd.gov.dgfood.food.grain.license.exception.NoSuchVerifiedBeneficiariesException;
import bd.gov.dgfood.food.grain.license.model.VerifiedBeneficiaries;
import bd.gov.dgfood.food.grain.license.model.VerifiedBeneficiariesTable;
import bd.gov.dgfood.food.grain.license.model.impl.VerifiedBeneficiariesImpl;
import bd.gov.dgfood.food.grain.license.model.impl.VerifiedBeneficiariesModelImpl;
import bd.gov.dgfood.food.grain.license.service.persistence.VerifiedBeneficiariesPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.VerifiedBeneficiariesUtil;
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
 * The persistence implementation for the verified beneficiaries service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = VerifiedBeneficiariesPersistence.class)
public class VerifiedBeneficiariesPersistenceImpl
	extends BasePersistenceImpl<VerifiedBeneficiaries>
	implements VerifiedBeneficiariesPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>VerifiedBeneficiariesUtil</code> to access the verified beneficiaries persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		VerifiedBeneficiariesImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByVerifiedBeneficiariesById;
	private FinderPath _finderPathCountByVerifiedBeneficiariesById;

	/**
	 * Returns the verified beneficiaries where id = &#63; or throws a <code>NoSuchVerifiedBeneficiariesException</code> if it could not be found.
	 *
	 * @param id the ID
	 * @return the matching verified beneficiaries
	 * @throws NoSuchVerifiedBeneficiariesException if a matching verified beneficiaries could not be found
	 */
	@Override
	public VerifiedBeneficiaries findByVerifiedBeneficiariesById(long id)
		throws NoSuchVerifiedBeneficiariesException {

		VerifiedBeneficiaries verifiedBeneficiaries =
			fetchByVerifiedBeneficiariesById(id);

		if (verifiedBeneficiaries == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("id=");
			sb.append(id);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchVerifiedBeneficiariesException(sb.toString());
		}

		return verifiedBeneficiaries;
	}

	/**
	 * Returns the verified beneficiaries where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param id the ID
	 * @return the matching verified beneficiaries, or <code>null</code> if a matching verified beneficiaries could not be found
	 */
	@Override
	public VerifiedBeneficiaries fetchByVerifiedBeneficiariesById(long id) {
		return fetchByVerifiedBeneficiariesById(id, true);
	}

	/**
	 * Returns the verified beneficiaries where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param id the ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching verified beneficiaries, or <code>null</code> if a matching verified beneficiaries could not be found
	 */
	@Override
	public VerifiedBeneficiaries fetchByVerifiedBeneficiariesById(
		long id, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {id};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByVerifiedBeneficiariesById, finderArgs, this);
		}

		if (result instanceof VerifiedBeneficiaries) {
			VerifiedBeneficiaries verifiedBeneficiaries =
				(VerifiedBeneficiaries)result;

			if (id != verifiedBeneficiaries.getId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_VERIFIEDBENEFICIARIES_WHERE);

			sb.append(_FINDER_COLUMN_VERIFIEDBENEFICIARIESBYID_ID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(id);

				List<VerifiedBeneficiaries> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByVerifiedBeneficiariesById,
							finderArgs, list);
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
								"VerifiedBeneficiariesPersistenceImpl.fetchByVerifiedBeneficiariesById(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					VerifiedBeneficiaries verifiedBeneficiaries = list.get(0);

					result = verifiedBeneficiaries;

					cacheResult(verifiedBeneficiaries);
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
			return (VerifiedBeneficiaries)result;
		}
	}

	/**
	 * Removes the verified beneficiaries where id = &#63; from the database.
	 *
	 * @param id the ID
	 * @return the verified beneficiaries that was removed
	 */
	@Override
	public VerifiedBeneficiaries removeByVerifiedBeneficiariesById(long id)
		throws NoSuchVerifiedBeneficiariesException {

		VerifiedBeneficiaries verifiedBeneficiaries =
			findByVerifiedBeneficiariesById(id);

		return remove(verifiedBeneficiaries);
	}

	/**
	 * Returns the number of verified beneficiarieses where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching verified beneficiarieses
	 */
	@Override
	public int countByVerifiedBeneficiariesById(long id) {
		FinderPath finderPath = _finderPathCountByVerifiedBeneficiariesById;

		Object[] finderArgs = new Object[] {id};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VERIFIEDBENEFICIARIES_WHERE);

			sb.append(_FINDER_COLUMN_VERIFIEDBENEFICIARIESBYID_ID_2);

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

	private static final String _FINDER_COLUMN_VERIFIEDBENEFICIARIESBYID_ID_2 =
		"verifiedBeneficiaries.id = ?";

	private FinderPath
		_finderPathWithPaginationFindByverifiedBeneficiariesDealerIdFinder;
	private FinderPath
		_finderPathWithoutPaginationFindByverifiedBeneficiariesDealerIdFinder;
	private FinderPath _finderPathCountByverifiedBeneficiariesDealerIdFinder;

	/**
	 * Returns all the verified beneficiarieses where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @return the matching verified beneficiarieses
	 */
	@Override
	public List<VerifiedBeneficiaries>
		findByverifiedBeneficiariesDealerIdFinder(long dealerId) {

		return findByverifiedBeneficiariesDealerIdFinder(
			dealerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the verified beneficiarieses where dealerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerifiedBeneficiariesModelImpl</code>.
	 * </p>
	 *
	 * @param dealerId the dealer ID
	 * @param start the lower bound of the range of verified beneficiarieses
	 * @param end the upper bound of the range of verified beneficiarieses (not inclusive)
	 * @return the range of matching verified beneficiarieses
	 */
	@Override
	public List<VerifiedBeneficiaries>
		findByverifiedBeneficiariesDealerIdFinder(
			long dealerId, int start, int end) {

		return findByverifiedBeneficiariesDealerIdFinder(
			dealerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the verified beneficiarieses where dealerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerifiedBeneficiariesModelImpl</code>.
	 * </p>
	 *
	 * @param dealerId the dealer ID
	 * @param start the lower bound of the range of verified beneficiarieses
	 * @param end the upper bound of the range of verified beneficiarieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verified beneficiarieses
	 */
	@Override
	public List<VerifiedBeneficiaries>
		findByverifiedBeneficiariesDealerIdFinder(
			long dealerId, int start, int end,
			OrderByComparator<VerifiedBeneficiaries> orderByComparator) {

		return findByverifiedBeneficiariesDealerIdFinder(
			dealerId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the verified beneficiarieses where dealerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerifiedBeneficiariesModelImpl</code>.
	 * </p>
	 *
	 * @param dealerId the dealer ID
	 * @param start the lower bound of the range of verified beneficiarieses
	 * @param end the upper bound of the range of verified beneficiarieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching verified beneficiarieses
	 */
	@Override
	public List<VerifiedBeneficiaries>
		findByverifiedBeneficiariesDealerIdFinder(
			long dealerId, int start, int end,
			OrderByComparator<VerifiedBeneficiaries> orderByComparator,
			boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByverifiedBeneficiariesDealerIdFinder;
				finderArgs = new Object[] {dealerId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByverifiedBeneficiariesDealerIdFinder;
			finderArgs = new Object[] {dealerId, start, end, orderByComparator};
		}

		List<VerifiedBeneficiaries> list = null;

		if (useFinderCache) {
			list = (List<VerifiedBeneficiaries>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VerifiedBeneficiaries verifiedBeneficiaries : list) {
					if (dealerId != verifiedBeneficiaries.getDealerId()) {
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

			sb.append(_SQL_SELECT_VERIFIEDBENEFICIARIES_WHERE);

			sb.append(
				_FINDER_COLUMN_VERIFIEDBENEFICIARIESDEALERIDFINDER_DEALERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VerifiedBeneficiariesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dealerId);

				list = (List<VerifiedBeneficiaries>)QueryUtil.list(
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
	 * Returns the first verified beneficiaries in the ordered set where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verified beneficiaries
	 * @throws NoSuchVerifiedBeneficiariesException if a matching verified beneficiaries could not be found
	 */
	@Override
	public VerifiedBeneficiaries
			findByverifiedBeneficiariesDealerIdFinder_First(
				long dealerId,
				OrderByComparator<VerifiedBeneficiaries> orderByComparator)
		throws NoSuchVerifiedBeneficiariesException {

		VerifiedBeneficiaries verifiedBeneficiaries =
			fetchByverifiedBeneficiariesDealerIdFinder_First(
				dealerId, orderByComparator);

		if (verifiedBeneficiaries != null) {
			return verifiedBeneficiaries;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dealerId=");
		sb.append(dealerId);

		sb.append("}");

		throw new NoSuchVerifiedBeneficiariesException(sb.toString());
	}

	/**
	 * Returns the first verified beneficiaries in the ordered set where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verified beneficiaries, or <code>null</code> if a matching verified beneficiaries could not be found
	 */
	@Override
	public VerifiedBeneficiaries
		fetchByverifiedBeneficiariesDealerIdFinder_First(
			long dealerId,
			OrderByComparator<VerifiedBeneficiaries> orderByComparator) {

		List<VerifiedBeneficiaries> list =
			findByverifiedBeneficiariesDealerIdFinder(
				dealerId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last verified beneficiaries in the ordered set where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verified beneficiaries
	 * @throws NoSuchVerifiedBeneficiariesException if a matching verified beneficiaries could not be found
	 */
	@Override
	public VerifiedBeneficiaries findByverifiedBeneficiariesDealerIdFinder_Last(
			long dealerId,
			OrderByComparator<VerifiedBeneficiaries> orderByComparator)
		throws NoSuchVerifiedBeneficiariesException {

		VerifiedBeneficiaries verifiedBeneficiaries =
			fetchByverifiedBeneficiariesDealerIdFinder_Last(
				dealerId, orderByComparator);

		if (verifiedBeneficiaries != null) {
			return verifiedBeneficiaries;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dealerId=");
		sb.append(dealerId);

		sb.append("}");

		throw new NoSuchVerifiedBeneficiariesException(sb.toString());
	}

	/**
	 * Returns the last verified beneficiaries in the ordered set where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verified beneficiaries, or <code>null</code> if a matching verified beneficiaries could not be found
	 */
	@Override
	public VerifiedBeneficiaries
		fetchByverifiedBeneficiariesDealerIdFinder_Last(
			long dealerId,
			OrderByComparator<VerifiedBeneficiaries> orderByComparator) {

		int count = countByverifiedBeneficiariesDealerIdFinder(dealerId);

		if (count == 0) {
			return null;
		}

		List<VerifiedBeneficiaries> list =
			findByverifiedBeneficiariesDealerIdFinder(
				dealerId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the verified beneficiarieses before and after the current verified beneficiaries in the ordered set where dealerId = &#63;.
	 *
	 * @param id the primary key of the current verified beneficiaries
	 * @param dealerId the dealer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verified beneficiaries
	 * @throws NoSuchVerifiedBeneficiariesException if a verified beneficiaries with the primary key could not be found
	 */
	@Override
	public VerifiedBeneficiaries[]
			findByverifiedBeneficiariesDealerIdFinder_PrevAndNext(
				long id, long dealerId,
				OrderByComparator<VerifiedBeneficiaries> orderByComparator)
		throws NoSuchVerifiedBeneficiariesException {

		VerifiedBeneficiaries verifiedBeneficiaries = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VerifiedBeneficiaries[] array = new VerifiedBeneficiariesImpl[3];

			array[0] = getByverifiedBeneficiariesDealerIdFinder_PrevAndNext(
				session, verifiedBeneficiaries, dealerId, orderByComparator,
				true);

			array[1] = verifiedBeneficiaries;

			array[2] = getByverifiedBeneficiariesDealerIdFinder_PrevAndNext(
				session, verifiedBeneficiaries, dealerId, orderByComparator,
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

	protected VerifiedBeneficiaries
		getByverifiedBeneficiariesDealerIdFinder_PrevAndNext(
			Session session, VerifiedBeneficiaries verifiedBeneficiaries,
			long dealerId,
			OrderByComparator<VerifiedBeneficiaries> orderByComparator,
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

		sb.append(_SQL_SELECT_VERIFIEDBENEFICIARIES_WHERE);

		sb.append(
			_FINDER_COLUMN_VERIFIEDBENEFICIARIESDEALERIDFINDER_DEALERID_2);

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
			sb.append(VerifiedBeneficiariesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(dealerId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						verifiedBeneficiaries)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<VerifiedBeneficiaries> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the verified beneficiarieses where dealerId = &#63; from the database.
	 *
	 * @param dealerId the dealer ID
	 */
	@Override
	public void removeByverifiedBeneficiariesDealerIdFinder(long dealerId) {
		for (VerifiedBeneficiaries verifiedBeneficiaries :
				findByverifiedBeneficiariesDealerIdFinder(
					dealerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(verifiedBeneficiaries);
		}
	}

	/**
	 * Returns the number of verified beneficiarieses where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @return the number of matching verified beneficiarieses
	 */
	@Override
	public int countByverifiedBeneficiariesDealerIdFinder(long dealerId) {
		FinderPath finderPath =
			_finderPathCountByverifiedBeneficiariesDealerIdFinder;

		Object[] finderArgs = new Object[] {dealerId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VERIFIEDBENEFICIARIES_WHERE);

			sb.append(
				_FINDER_COLUMN_VERIFIEDBENEFICIARIESDEALERIDFINDER_DEALERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dealerId);

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
		_FINDER_COLUMN_VERIFIEDBENEFICIARIESDEALERIDFINDER_DEALERID_2 =
			"verifiedBeneficiaries.dealerId = ?";

	private FinderPath
		_finderPathWithPaginationFindByverifiedBeneficiariesNidFinder;
	private FinderPath
		_finderPathWithoutPaginationFindByverifiedBeneficiariesNidFinder;
	private FinderPath _finderPathCountByverifiedBeneficiariesNidFinder;

	/**
	 * Returns all the verified beneficiarieses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching verified beneficiarieses
	 */
	@Override
	public List<VerifiedBeneficiaries> findByverifiedBeneficiariesNidFinder(
		String nationalId) {

		return findByverifiedBeneficiariesNidFinder(
			nationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the verified beneficiarieses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerifiedBeneficiariesModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of verified beneficiarieses
	 * @param end the upper bound of the range of verified beneficiarieses (not inclusive)
	 * @return the range of matching verified beneficiarieses
	 */
	@Override
	public List<VerifiedBeneficiaries> findByverifiedBeneficiariesNidFinder(
		String nationalId, int start, int end) {

		return findByverifiedBeneficiariesNidFinder(
			nationalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the verified beneficiarieses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerifiedBeneficiariesModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of verified beneficiarieses
	 * @param end the upper bound of the range of verified beneficiarieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching verified beneficiarieses
	 */
	@Override
	public List<VerifiedBeneficiaries> findByverifiedBeneficiariesNidFinder(
		String nationalId, int start, int end,
		OrderByComparator<VerifiedBeneficiaries> orderByComparator) {

		return findByverifiedBeneficiariesNidFinder(
			nationalId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the verified beneficiarieses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerifiedBeneficiariesModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of verified beneficiarieses
	 * @param end the upper bound of the range of verified beneficiarieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching verified beneficiarieses
	 */
	@Override
	public List<VerifiedBeneficiaries> findByverifiedBeneficiariesNidFinder(
		String nationalId, int start, int end,
		OrderByComparator<VerifiedBeneficiaries> orderByComparator,
		boolean useFinderCache) {

		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByverifiedBeneficiariesNidFinder;
				finderArgs = new Object[] {nationalId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByverifiedBeneficiariesNidFinder;
			finderArgs = new Object[] {
				nationalId, start, end, orderByComparator
			};
		}

		List<VerifiedBeneficiaries> list = null;

		if (useFinderCache) {
			list = (List<VerifiedBeneficiaries>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VerifiedBeneficiaries verifiedBeneficiaries : list) {
					if (!nationalId.equals(
							verifiedBeneficiaries.getNationalId())) {

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

			sb.append(_SQL_SELECT_VERIFIEDBENEFICIARIES_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_VERIFIEDBENEFICIARIESNIDFINDER_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(
					_FINDER_COLUMN_VERIFIEDBENEFICIARIESNIDFINDER_NATIONALID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VerifiedBeneficiariesModelImpl.ORDER_BY_JPQL);
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

				list = (List<VerifiedBeneficiaries>)QueryUtil.list(
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
	 * Returns the first verified beneficiaries in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verified beneficiaries
	 * @throws NoSuchVerifiedBeneficiariesException if a matching verified beneficiaries could not be found
	 */
	@Override
	public VerifiedBeneficiaries findByverifiedBeneficiariesNidFinder_First(
			String nationalId,
			OrderByComparator<VerifiedBeneficiaries> orderByComparator)
		throws NoSuchVerifiedBeneficiariesException {

		VerifiedBeneficiaries verifiedBeneficiaries =
			fetchByverifiedBeneficiariesNidFinder_First(
				nationalId, orderByComparator);

		if (verifiedBeneficiaries != null) {
			return verifiedBeneficiaries;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationalId=");
		sb.append(nationalId);

		sb.append("}");

		throw new NoSuchVerifiedBeneficiariesException(sb.toString());
	}

	/**
	 * Returns the first verified beneficiaries in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching verified beneficiaries, or <code>null</code> if a matching verified beneficiaries could not be found
	 */
	@Override
	public VerifiedBeneficiaries fetchByverifiedBeneficiariesNidFinder_First(
		String nationalId,
		OrderByComparator<VerifiedBeneficiaries> orderByComparator) {

		List<VerifiedBeneficiaries> list = findByverifiedBeneficiariesNidFinder(
			nationalId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last verified beneficiaries in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verified beneficiaries
	 * @throws NoSuchVerifiedBeneficiariesException if a matching verified beneficiaries could not be found
	 */
	@Override
	public VerifiedBeneficiaries findByverifiedBeneficiariesNidFinder_Last(
			String nationalId,
			OrderByComparator<VerifiedBeneficiaries> orderByComparator)
		throws NoSuchVerifiedBeneficiariesException {

		VerifiedBeneficiaries verifiedBeneficiaries =
			fetchByverifiedBeneficiariesNidFinder_Last(
				nationalId, orderByComparator);

		if (verifiedBeneficiaries != null) {
			return verifiedBeneficiaries;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationalId=");
		sb.append(nationalId);

		sb.append("}");

		throw new NoSuchVerifiedBeneficiariesException(sb.toString());
	}

	/**
	 * Returns the last verified beneficiaries in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching verified beneficiaries, or <code>null</code> if a matching verified beneficiaries could not be found
	 */
	@Override
	public VerifiedBeneficiaries fetchByverifiedBeneficiariesNidFinder_Last(
		String nationalId,
		OrderByComparator<VerifiedBeneficiaries> orderByComparator) {

		int count = countByverifiedBeneficiariesNidFinder(nationalId);

		if (count == 0) {
			return null;
		}

		List<VerifiedBeneficiaries> list = findByverifiedBeneficiariesNidFinder(
			nationalId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the verified beneficiarieses before and after the current verified beneficiaries in the ordered set where nationalId = &#63;.
	 *
	 * @param id the primary key of the current verified beneficiaries
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next verified beneficiaries
	 * @throws NoSuchVerifiedBeneficiariesException if a verified beneficiaries with the primary key could not be found
	 */
	@Override
	public VerifiedBeneficiaries[]
			findByverifiedBeneficiariesNidFinder_PrevAndNext(
				long id, String nationalId,
				OrderByComparator<VerifiedBeneficiaries> orderByComparator)
		throws NoSuchVerifiedBeneficiariesException {

		nationalId = Objects.toString(nationalId, "");

		VerifiedBeneficiaries verifiedBeneficiaries = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VerifiedBeneficiaries[] array = new VerifiedBeneficiariesImpl[3];

			array[0] = getByverifiedBeneficiariesNidFinder_PrevAndNext(
				session, verifiedBeneficiaries, nationalId, orderByComparator,
				true);

			array[1] = verifiedBeneficiaries;

			array[2] = getByverifiedBeneficiariesNidFinder_PrevAndNext(
				session, verifiedBeneficiaries, nationalId, orderByComparator,
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

	protected VerifiedBeneficiaries
		getByverifiedBeneficiariesNidFinder_PrevAndNext(
			Session session, VerifiedBeneficiaries verifiedBeneficiaries,
			String nationalId,
			OrderByComparator<VerifiedBeneficiaries> orderByComparator,
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

		sb.append(_SQL_SELECT_VERIFIEDBENEFICIARIES_WHERE);

		boolean bindNationalId = false;

		if (nationalId.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_VERIFIEDBENEFICIARIESNIDFINDER_NATIONALID_3);
		}
		else {
			bindNationalId = true;

			sb.append(
				_FINDER_COLUMN_VERIFIEDBENEFICIARIESNIDFINDER_NATIONALID_2);
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
			sb.append(VerifiedBeneficiariesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindNationalId) {
			queryPos.add(nationalId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						verifiedBeneficiaries)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<VerifiedBeneficiaries> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the verified beneficiarieses where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	@Override
	public void removeByverifiedBeneficiariesNidFinder(String nationalId) {
		for (VerifiedBeneficiaries verifiedBeneficiaries :
				findByverifiedBeneficiariesNidFinder(
					nationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(verifiedBeneficiaries);
		}
	}

	/**
	 * Returns the number of verified beneficiarieses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching verified beneficiarieses
	 */
	@Override
	public int countByverifiedBeneficiariesNidFinder(String nationalId) {
		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath =
			_finderPathCountByverifiedBeneficiariesNidFinder;

		Object[] finderArgs = new Object[] {nationalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VERIFIEDBENEFICIARIES_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_VERIFIEDBENEFICIARIESNIDFINDER_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(
					_FINDER_COLUMN_VERIFIEDBENEFICIARIESNIDFINDER_NATIONALID_2);
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

	private static final String
		_FINDER_COLUMN_VERIFIEDBENEFICIARIESNIDFINDER_NATIONALID_2 =
			"verifiedBeneficiaries.nationalId = ?";

	private static final String
		_FINDER_COLUMN_VERIFIEDBENEFICIARIESNIDFINDER_NATIONALID_3 =
			"(verifiedBeneficiaries.nationalId IS NULL OR verifiedBeneficiaries.nationalId = '')";

	public VerifiedBeneficiariesPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("bsbVerified", "bsb_verified");
		dbColumnNames.put("cardNo", "card_no");
		dbColumnNames.put("createdAt", "created_at");
		dbColumnNames.put("dateOfBirth", "date_of_birth");
		dbColumnNames.put("dealerId", "dealer_id");
		dbColumnNames.put("districtId", "district_id");
		dbColumnNames.put("divisionId", "division_id");
		dbColumnNames.put("ecBeneficiaryName", "ec_beneficiary_name");
		dbColumnNames.put("ecBeneficiaryNameEn", "ec_beneficiary_name_en");
		dbColumnNames.put("ecBloodGroup", "ec_blood_group");
		dbColumnNames.put("ecFatherName", "ec_father_name");
		dbColumnNames.put("ecGender", "ec_gender");
		dbColumnNames.put("ecMobileNo", "ec_mobile_no");
		dbColumnNames.put("ecMotherName", "ec_mother_name");
		dbColumnNames.put("ecOccupation", "ec_occupation");
		dbColumnNames.put(
			"ecPmAdditionalMouzaMoholla", "ec_pm_additional_mouza_moholla");
		dbColumnNames.put(
			"ecPmAdditionalVillageRoad", "ec_pm_additional_village_road");
		dbColumnNames.put("ecPmDistrict", "ec_pm_district");
		dbColumnNames.put("ecPmDivision", "ec_pm_division");
		dbColumnNames.put("ecPmHomeHoldingNo", "ec_pm_home_holding_no");
		dbColumnNames.put("ecPmMouzaMoholla", "ec_pm_mouza_moholla");
		dbColumnNames.put("ecPmPostalCode", "ec_pm_postal_code");
		dbColumnNames.put("ecPmPostOffice", "ec_pm_post_office");
		dbColumnNames.put("ecPmRegion", "ec_pm_region");
		dbColumnNames.put("ecPmRmo", "ec_pm_rmo");
		dbColumnNames.put("ecPmUnionWard", "ec_pm_union_ward");
		dbColumnNames.put("ecPmUpazila", "ec_pm_upazila");
		dbColumnNames.put("ecPmVillageRoad", "ec_pm_village_road");
		dbColumnNames.put("ecPmWardUnionPorishod", "ec_pm_ward_union_porishod");
		dbColumnNames.put(
			"ecPrAdditionalMouzaMoholla", "ec_pr_additional_mouza_moholla");
		dbColumnNames.put(
			"ecPrAdditionalVillageRoad", "ec_pr_additional_village_road");
		dbColumnNames.put(
			"ecPrCityCorpMunicipality", "ec_pr_city_corp_municipality");
		dbColumnNames.put("ecPrDistrict", "ec_pr_district");
		dbColumnNames.put("ecPrDivision", "ec_pr_division");
		dbColumnNames.put("ecPrHomeHoldingNo", "ec_pr_home_holding_no");
		dbColumnNames.put("ecPrMouzaMoholla", "ec_pr_mouza_moholla");
		dbColumnNames.put("ecPrPostalCode", "ec_pr_postal_code");
		dbColumnNames.put("ecPrPostOffice", "ec_pr_post_office");
		dbColumnNames.put("ecPrRegion", "ec_pr_region");
		dbColumnNames.put("ecPrRmo", "ec_pr_rmo");
		dbColumnNames.put("ecPrUnionWard", "ec_pr_union_ward");
		dbColumnNames.put("ecPrUpazila", "ec_pr_upazila");
		dbColumnNames.put("ecPrVillageRoad", "ec_pr_village_road");
		dbColumnNames.put("ecPrWardUnionPorishod", "ec_pr_ward_union_porishod");
		dbColumnNames.put("ecSpouseName", "ec_spouse_name");
		dbColumnNames.put("ecVerified", "ec_verified");
		dbColumnNames.put("finalStatus", "final_status");
		dbColumnNames.put("givenMobileNo", "given_mobile_no");
		dbColumnNames.put("imagePathEc", "image_path_ec");
		dbColumnNames.put("imagePathReal", "image_path_real");
		dbColumnNames.put("nationalId", "national_id");
		dbColumnNames.put("newCardNumber", "new_card_number");
		dbColumnNames.put("rawDataId", "raw_data_id");
		dbColumnNames.put("secondNationalId", "second_national_id");
		dbColumnNames.put("ucfVerifiedDate", "ucf_verified_date");
		dbColumnNames.put("unionId", "union_id");
		dbColumnNames.put("upazilaId", "upazila_id");
		dbColumnNames.put("updatedAt", "updated_at");
		dbColumnNames.put("verifiedBy", "verified_by");
		dbColumnNames.put("verifiedDate", "verified_date");
		dbColumnNames.put("vgdStatus", "vgd_status");

		setDBColumnNames(dbColumnNames);

		setModelClass(VerifiedBeneficiaries.class);

		setModelImplClass(VerifiedBeneficiariesImpl.class);
		setModelPKClass(long.class);

		setTable(VerifiedBeneficiariesTable.INSTANCE);
	}

	/**
	 * Caches the verified beneficiaries in the entity cache if it is enabled.
	 *
	 * @param verifiedBeneficiaries the verified beneficiaries
	 */
	@Override
	public void cacheResult(VerifiedBeneficiaries verifiedBeneficiaries) {
		entityCache.putResult(
			VerifiedBeneficiariesImpl.class,
			verifiedBeneficiaries.getPrimaryKey(), verifiedBeneficiaries);

		finderCache.putResult(
			_finderPathFetchByVerifiedBeneficiariesById,
			new Object[] {verifiedBeneficiaries.getId()},
			verifiedBeneficiaries);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the verified beneficiarieses in the entity cache if it is enabled.
	 *
	 * @param verifiedBeneficiarieses the verified beneficiarieses
	 */
	@Override
	public void cacheResult(
		List<VerifiedBeneficiaries> verifiedBeneficiarieses) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (verifiedBeneficiarieses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (VerifiedBeneficiaries verifiedBeneficiaries :
				verifiedBeneficiarieses) {

			if (entityCache.getResult(
					VerifiedBeneficiariesImpl.class,
					verifiedBeneficiaries.getPrimaryKey()) == null) {

				cacheResult(verifiedBeneficiaries);
			}
		}
	}

	/**
	 * Clears the cache for all verified beneficiarieses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VerifiedBeneficiariesImpl.class);

		finderCache.clearCache(VerifiedBeneficiariesImpl.class);
	}

	/**
	 * Clears the cache for the verified beneficiaries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VerifiedBeneficiaries verifiedBeneficiaries) {
		entityCache.removeResult(
			VerifiedBeneficiariesImpl.class, verifiedBeneficiaries);
	}

	@Override
	public void clearCache(
		List<VerifiedBeneficiaries> verifiedBeneficiarieses) {

		for (VerifiedBeneficiaries verifiedBeneficiaries :
				verifiedBeneficiarieses) {

			entityCache.removeResult(
				VerifiedBeneficiariesImpl.class, verifiedBeneficiaries);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(VerifiedBeneficiariesImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				VerifiedBeneficiariesImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		VerifiedBeneficiariesModelImpl verifiedBeneficiariesModelImpl) {

		Object[] args = new Object[] {verifiedBeneficiariesModelImpl.getId()};

		finderCache.putResult(
			_finderPathCountByVerifiedBeneficiariesById, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByVerifiedBeneficiariesById, args,
			verifiedBeneficiariesModelImpl);
	}

	/**
	 * Creates a new verified beneficiaries with the primary key. Does not add the verified beneficiaries to the database.
	 *
	 * @param id the primary key for the new verified beneficiaries
	 * @return the new verified beneficiaries
	 */
	@Override
	public VerifiedBeneficiaries create(long id) {
		VerifiedBeneficiaries verifiedBeneficiaries =
			new VerifiedBeneficiariesImpl();

		verifiedBeneficiaries.setNew(true);
		verifiedBeneficiaries.setPrimaryKey(id);

		return verifiedBeneficiaries;
	}

	/**
	 * Removes the verified beneficiaries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the verified beneficiaries
	 * @return the verified beneficiaries that was removed
	 * @throws NoSuchVerifiedBeneficiariesException if a verified beneficiaries with the primary key could not be found
	 */
	@Override
	public VerifiedBeneficiaries remove(long id)
		throws NoSuchVerifiedBeneficiariesException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the verified beneficiaries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the verified beneficiaries
	 * @return the verified beneficiaries that was removed
	 * @throws NoSuchVerifiedBeneficiariesException if a verified beneficiaries with the primary key could not be found
	 */
	@Override
	public VerifiedBeneficiaries remove(Serializable primaryKey)
		throws NoSuchVerifiedBeneficiariesException {

		Session session = null;

		try {
			session = openSession();

			VerifiedBeneficiaries verifiedBeneficiaries =
				(VerifiedBeneficiaries)session.get(
					VerifiedBeneficiariesImpl.class, primaryKey);

			if (verifiedBeneficiaries == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVerifiedBeneficiariesException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(verifiedBeneficiaries);
		}
		catch (NoSuchVerifiedBeneficiariesException noSuchEntityException) {
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
	protected VerifiedBeneficiaries removeImpl(
		VerifiedBeneficiaries verifiedBeneficiaries) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(verifiedBeneficiaries)) {
				verifiedBeneficiaries = (VerifiedBeneficiaries)session.get(
					VerifiedBeneficiariesImpl.class,
					verifiedBeneficiaries.getPrimaryKeyObj());
			}

			if (verifiedBeneficiaries != null) {
				session.delete(verifiedBeneficiaries);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (verifiedBeneficiaries != null) {
			clearCache(verifiedBeneficiaries);
		}

		return verifiedBeneficiaries;
	}

	@Override
	public VerifiedBeneficiaries updateImpl(
		VerifiedBeneficiaries verifiedBeneficiaries) {

		boolean isNew = verifiedBeneficiaries.isNew();

		if (!(verifiedBeneficiaries instanceof
				VerifiedBeneficiariesModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(verifiedBeneficiaries.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					verifiedBeneficiaries);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in verifiedBeneficiaries proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom VerifiedBeneficiaries implementation " +
					verifiedBeneficiaries.getClass());
		}

		VerifiedBeneficiariesModelImpl verifiedBeneficiariesModelImpl =
			(VerifiedBeneficiariesModelImpl)verifiedBeneficiaries;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(verifiedBeneficiaries);
			}
			else {
				verifiedBeneficiaries = (VerifiedBeneficiaries)session.merge(
					verifiedBeneficiaries);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			VerifiedBeneficiariesImpl.class, verifiedBeneficiariesModelImpl,
			false, true);

		cacheUniqueFindersCache(verifiedBeneficiariesModelImpl);

		if (isNew) {
			verifiedBeneficiaries.setNew(false);
		}

		verifiedBeneficiaries.resetOriginalValues();

		return verifiedBeneficiaries;
	}

	/**
	 * Returns the verified beneficiaries with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the verified beneficiaries
	 * @return the verified beneficiaries
	 * @throws NoSuchVerifiedBeneficiariesException if a verified beneficiaries with the primary key could not be found
	 */
	@Override
	public VerifiedBeneficiaries findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVerifiedBeneficiariesException {

		VerifiedBeneficiaries verifiedBeneficiaries = fetchByPrimaryKey(
			primaryKey);

		if (verifiedBeneficiaries == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVerifiedBeneficiariesException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return verifiedBeneficiaries;
	}

	/**
	 * Returns the verified beneficiaries with the primary key or throws a <code>NoSuchVerifiedBeneficiariesException</code> if it could not be found.
	 *
	 * @param id the primary key of the verified beneficiaries
	 * @return the verified beneficiaries
	 * @throws NoSuchVerifiedBeneficiariesException if a verified beneficiaries with the primary key could not be found
	 */
	@Override
	public VerifiedBeneficiaries findByPrimaryKey(long id)
		throws NoSuchVerifiedBeneficiariesException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the verified beneficiaries with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the verified beneficiaries
	 * @return the verified beneficiaries, or <code>null</code> if a verified beneficiaries with the primary key could not be found
	 */
	@Override
	public VerifiedBeneficiaries fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the verified beneficiarieses.
	 *
	 * @return the verified beneficiarieses
	 */
	@Override
	public List<VerifiedBeneficiaries> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the verified beneficiarieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerifiedBeneficiariesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of verified beneficiarieses
	 * @param end the upper bound of the range of verified beneficiarieses (not inclusive)
	 * @return the range of verified beneficiarieses
	 */
	@Override
	public List<VerifiedBeneficiaries> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the verified beneficiarieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerifiedBeneficiariesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of verified beneficiarieses
	 * @param end the upper bound of the range of verified beneficiarieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of verified beneficiarieses
	 */
	@Override
	public List<VerifiedBeneficiaries> findAll(
		int start, int end,
		OrderByComparator<VerifiedBeneficiaries> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the verified beneficiarieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerifiedBeneficiariesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of verified beneficiarieses
	 * @param end the upper bound of the range of verified beneficiarieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of verified beneficiarieses
	 */
	@Override
	public List<VerifiedBeneficiaries> findAll(
		int start, int end,
		OrderByComparator<VerifiedBeneficiaries> orderByComparator,
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

		List<VerifiedBeneficiaries> list = null;

		if (useFinderCache) {
			list = (List<VerifiedBeneficiaries>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_VERIFIEDBENEFICIARIES);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_VERIFIEDBENEFICIARIES;

				sql = sql.concat(VerifiedBeneficiariesModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<VerifiedBeneficiaries>)QueryUtil.list(
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
	 * Removes all the verified beneficiarieses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (VerifiedBeneficiaries verifiedBeneficiaries : findAll()) {
			remove(verifiedBeneficiaries);
		}
	}

	/**
	 * Returns the number of verified beneficiarieses.
	 *
	 * @return the number of verified beneficiarieses
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
					_SQL_COUNT_VERIFIEDBENEFICIARIES);

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
		return _SQL_SELECT_VERIFIEDBENEFICIARIES;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return VerifiedBeneficiariesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the verified beneficiaries persistence.
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

		_finderPathFetchByVerifiedBeneficiariesById = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByVerifiedBeneficiariesById",
			new String[] {Long.class.getName()}, new String[] {"id"}, true);

		_finderPathCountByVerifiedBeneficiariesById = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByVerifiedBeneficiariesById",
			new String[] {Long.class.getName()}, new String[] {"id"}, false);

		_finderPathWithPaginationFindByverifiedBeneficiariesDealerIdFinder =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByverifiedBeneficiariesDealerIdFinder",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"dealer_id"}, true);

		_finderPathWithoutPaginationFindByverifiedBeneficiariesDealerIdFinder =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByverifiedBeneficiariesDealerIdFinder",
				new String[] {Long.class.getName()}, new String[] {"dealer_id"},
				true);

		_finderPathCountByverifiedBeneficiariesDealerIdFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByverifiedBeneficiariesDealerIdFinder",
			new String[] {Long.class.getName()}, new String[] {"dealer_id"},
			false);

		_finderPathWithPaginationFindByverifiedBeneficiariesNidFinder =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByverifiedBeneficiariesNidFinder",
				new String[] {
					String.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"national_id"}, true);

		_finderPathWithoutPaginationFindByverifiedBeneficiariesNidFinder =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByverifiedBeneficiariesNidFinder",
				new String[] {String.class.getName()},
				new String[] {"national_id"}, true);

		_finderPathCountByverifiedBeneficiariesNidFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByverifiedBeneficiariesNidFinder",
			new String[] {String.class.getName()}, new String[] {"national_id"},
			false);

		_setVerifiedBeneficiariesUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setVerifiedBeneficiariesUtilPersistence(null);

		entityCache.removeCache(VerifiedBeneficiariesImpl.class.getName());
	}

	private void _setVerifiedBeneficiariesUtilPersistence(
		VerifiedBeneficiariesPersistence verifiedBeneficiariesPersistence) {

		try {
			Field field = VerifiedBeneficiariesUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, verifiedBeneficiariesPersistence);
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

	private static final String _SQL_SELECT_VERIFIEDBENEFICIARIES =
		"SELECT verifiedBeneficiaries FROM VerifiedBeneficiaries verifiedBeneficiaries";

	private static final String _SQL_SELECT_VERIFIEDBENEFICIARIES_WHERE =
		"SELECT verifiedBeneficiaries FROM VerifiedBeneficiaries verifiedBeneficiaries WHERE ";

	private static final String _SQL_COUNT_VERIFIEDBENEFICIARIES =
		"SELECT COUNT(verifiedBeneficiaries) FROM VerifiedBeneficiaries verifiedBeneficiaries";

	private static final String _SQL_COUNT_VERIFIEDBENEFICIARIES_WHERE =
		"SELECT COUNT(verifiedBeneficiaries) FROM VerifiedBeneficiaries verifiedBeneficiaries WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"verifiedBeneficiaries.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No VerifiedBeneficiaries exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No VerifiedBeneficiaries exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		VerifiedBeneficiariesPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"bsbVerified", "cardNo", "createdAt", "dateOfBirth", "dealerId",
			"districtId", "divisionId", "ecBeneficiaryName",
			"ecBeneficiaryNameEn", "ecBloodGroup", "ecFatherName", "ecGender",
			"ecMobileNo", "ecMotherName", "ecOccupation",
			"ecPmAdditionalMouzaMoholla", "ecPmAdditionalVillageRoad",
			"ecPmDistrict", "ecPmDivision", "ecPmHomeHoldingNo",
			"ecPmMouzaMoholla", "ecPmPostalCode", "ecPmPostOffice",
			"ecPmRegion", "ecPmRmo", "ecPmUnionWard", "ecPmUpazila",
			"ecPmVillageRoad", "ecPmWardUnionPorishod",
			"ecPrAdditionalMouzaMoholla", "ecPrAdditionalVillageRoad",
			"ecPrCityCorpMunicipality", "ecPrDistrict", "ecPrDivision",
			"ecPrHomeHoldingNo", "ecPrMouzaMoholla", "ecPrPostalCode",
			"ecPrPostOffice", "ecPrRegion", "ecPrRmo", "ecPrUnionWard",
			"ecPrUpazila", "ecPrVillageRoad", "ecPrWardUnionPorishod",
			"ecSpouseName", "ecVerified", "finalStatus", "givenMobileNo",
			"imagePathEc", "imagePathReal", "nationalId", "newCardNumber",
			"rawDataId", "secondNationalId", "ucfVerifiedDate", "unionId",
			"upazilaId", "updatedAt", "verifiedBy", "verifiedDate", "vgdStatus"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}