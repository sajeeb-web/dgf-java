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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfUsersAddrDtlsException;
import bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls;
import bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtlsTable;
import bd.gov.dgfood.food.grain.license.model.impl.DgfUsersAddrDtlsImpl;
import bd.gov.dgfood.food.grain.license.model.impl.DgfUsersAddrDtlsModelImpl;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfUsersAddrDtlsPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfUsersAddrDtlsUtil;
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
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the dgf users addr dtls service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DgfUsersAddrDtlsPersistence.class)
public class DgfUsersAddrDtlsPersistenceImpl
	extends BasePersistenceImpl<DgfUsersAddrDtls>
	implements DgfUsersAddrDtlsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DgfUsersAddrDtlsUtil</code> to access the dgf users addr dtls persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DgfUsersAddrDtlsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBydgfUsersAddrDtlsByNationalId;
	private FinderPath _finderPathCountBydgfUsersAddrDtlsByNationalId;

	/**
	 * Returns the dgf users addr dtls where nationalId = &#63; or throws a <code>NoSuchDgfUsersAddrDtlsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	@Override
	public DgfUsersAddrDtls findBydgfUsersAddrDtlsByNationalId(long nationalId)
		throws NoSuchDgfUsersAddrDtlsException {

		DgfUsersAddrDtls dgfUsersAddrDtls = fetchBydgfUsersAddrDtlsByNationalId(
			nationalId);

		if (dgfUsersAddrDtls == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("nationalId=");
			sb.append(nationalId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfUsersAddrDtlsException(sb.toString());
		}

		return dgfUsersAddrDtls;
	}

	/**
	 * Returns the dgf users addr dtls where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	@Override
	public DgfUsersAddrDtls fetchBydgfUsersAddrDtlsByNationalId(
		long nationalId) {

		return fetchBydgfUsersAddrDtlsByNationalId(nationalId, true);
	}

	/**
	 * Returns the dgf users addr dtls where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	@Override
	public DgfUsersAddrDtls fetchBydgfUsersAddrDtlsByNationalId(
		long nationalId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {nationalId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBydgfUsersAddrDtlsByNationalId, finderArgs,
				this);
		}

		if (result instanceof DgfUsersAddrDtls) {
			DgfUsersAddrDtls dgfUsersAddrDtls = (DgfUsersAddrDtls)result;

			if (nationalId != dgfUsersAddrDtls.getNationalId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DGFUSERSADDRDTLS_WHERE);

			sb.append(_FINDER_COLUMN_DGFUSERSADDRDTLSBYNATIONALID_NATIONALID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(nationalId);

				List<DgfUsersAddrDtls> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBydgfUsersAddrDtlsByNationalId,
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
								"DgfUsersAddrDtlsPersistenceImpl.fetchBydgfUsersAddrDtlsByNationalId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DgfUsersAddrDtls dgfUsersAddrDtls = list.get(0);

					result = dgfUsersAddrDtls;

					cacheResult(dgfUsersAddrDtls);
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
			return (DgfUsersAddrDtls)result;
		}
	}

	/**
	 * Removes the dgf users addr dtls where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the dgf users addr dtls that was removed
	 */
	@Override
	public DgfUsersAddrDtls removeBydgfUsersAddrDtlsByNationalId(
			long nationalId)
		throws NoSuchDgfUsersAddrDtlsException {

		DgfUsersAddrDtls dgfUsersAddrDtls = findBydgfUsersAddrDtlsByNationalId(
			nationalId);

		return remove(dgfUsersAddrDtls);
	}

	/**
	 * Returns the number of dgf users addr dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf users addr dtlses
	 */
	@Override
	public int countBydgfUsersAddrDtlsByNationalId(long nationalId) {
		FinderPath finderPath = _finderPathCountBydgfUsersAddrDtlsByNationalId;

		Object[] finderArgs = new Object[] {nationalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFUSERSADDRDTLS_WHERE);

			sb.append(_FINDER_COLUMN_DGFUSERSADDRDTLSBYNATIONALID_NATIONALID_2);

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
		_FINDER_COLUMN_DGFUSERSADDRDTLSBYNATIONALID_NATIONALID_2 =
			"dgfUsersAddrDtls.nationalId = ?";

	private FinderPath
		_finderPathWithPaginationFindBydgfUsersAddrDtlsByDistrict;
	private FinderPath
		_finderPathWithoutPaginationFindBydgfUsersAddrDtlsByDistrict;
	private FinderPath _finderPathCountBydgfUsersAddrDtlsByDistrict;

	/**
	 * Returns all the dgf users addr dtlses where district = &#63;.
	 *
	 * @param district the district
	 * @return the matching dgf users addr dtlses
	 */
	@Override
	public List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByDistrict(
		long district) {

		return findBydgfUsersAddrDtlsByDistrict(
			district, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf users addr dtlses where district = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param district the district
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @return the range of matching dgf users addr dtlses
	 */
	@Override
	public List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByDistrict(
		long district, int start, int end) {

		return findBydgfUsersAddrDtlsByDistrict(district, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where district = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param district the district
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	@Override
	public List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByDistrict(
		long district, int start, int end,
		OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		return findBydgfUsersAddrDtlsByDistrict(
			district, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where district = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param district the district
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	@Override
	public List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByDistrict(
		long district, int start, int end,
		OrderByComparator<DgfUsersAddrDtls> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydgfUsersAddrDtlsByDistrict;
				finderArgs = new Object[] {district};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBydgfUsersAddrDtlsByDistrict;
			finderArgs = new Object[] {district, start, end, orderByComparator};
		}

		List<DgfUsersAddrDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfUsersAddrDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfUsersAddrDtls dgfUsersAddrDtls : list) {
					if (district != dgfUsersAddrDtls.getDistrict()) {
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

			sb.append(_SQL_SELECT_DGFUSERSADDRDTLS_WHERE);

			sb.append(_FINDER_COLUMN_DGFUSERSADDRDTLSBYDISTRICT_DISTRICT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfUsersAddrDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(district);

				list = (List<DgfUsersAddrDtls>)QueryUtil.list(
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
	 * Returns the first dgf users addr dtls in the ordered set where district = &#63;.
	 *
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	@Override
	public DgfUsersAddrDtls findBydgfUsersAddrDtlsByDistrict_First(
			long district,
			OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException {

		DgfUsersAddrDtls dgfUsersAddrDtls =
			fetchBydgfUsersAddrDtlsByDistrict_First(
				district, orderByComparator);

		if (dgfUsersAddrDtls != null) {
			return dgfUsersAddrDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("district=");
		sb.append(district);

		sb.append("}");

		throw new NoSuchDgfUsersAddrDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf users addr dtls in the ordered set where district = &#63;.
	 *
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	@Override
	public DgfUsersAddrDtls fetchBydgfUsersAddrDtlsByDistrict_First(
		long district, OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		List<DgfUsersAddrDtls> list = findBydgfUsersAddrDtlsByDistrict(
			district, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf users addr dtls in the ordered set where district = &#63;.
	 *
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	@Override
	public DgfUsersAddrDtls findBydgfUsersAddrDtlsByDistrict_Last(
			long district,
			OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException {

		DgfUsersAddrDtls dgfUsersAddrDtls =
			fetchBydgfUsersAddrDtlsByDistrict_Last(district, orderByComparator);

		if (dgfUsersAddrDtls != null) {
			return dgfUsersAddrDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("district=");
		sb.append(district);

		sb.append("}");

		throw new NoSuchDgfUsersAddrDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf users addr dtls in the ordered set where district = &#63;.
	 *
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	@Override
	public DgfUsersAddrDtls fetchBydgfUsersAddrDtlsByDistrict_Last(
		long district, OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		int count = countBydgfUsersAddrDtlsByDistrict(district);

		if (count == 0) {
			return null;
		}

		List<DgfUsersAddrDtls> list = findBydgfUsersAddrDtlsByDistrict(
			district, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf users addr dtlses before and after the current dgf users addr dtls in the ordered set where district = &#63;.
	 *
	 * @param addressId the primary key of the current dgf users addr dtls
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a dgf users addr dtls with the primary key could not be found
	 */
	@Override
	public DgfUsersAddrDtls[] findBydgfUsersAddrDtlsByDistrict_PrevAndNext(
			long addressId, long district,
			OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException {

		DgfUsersAddrDtls dgfUsersAddrDtls = findByPrimaryKey(addressId);

		Session session = null;

		try {
			session = openSession();

			DgfUsersAddrDtls[] array = new DgfUsersAddrDtlsImpl[3];

			array[0] = getBydgfUsersAddrDtlsByDistrict_PrevAndNext(
				session, dgfUsersAddrDtls, district, orderByComparator, true);

			array[1] = dgfUsersAddrDtls;

			array[2] = getBydgfUsersAddrDtlsByDistrict_PrevAndNext(
				session, dgfUsersAddrDtls, district, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DgfUsersAddrDtls getBydgfUsersAddrDtlsByDistrict_PrevAndNext(
		Session session, DgfUsersAddrDtls dgfUsersAddrDtls, long district,
		OrderByComparator<DgfUsersAddrDtls> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFUSERSADDRDTLS_WHERE);

		sb.append(_FINDER_COLUMN_DGFUSERSADDRDTLSBYDISTRICT_DISTRICT_2);

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
			sb.append(DgfUsersAddrDtlsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(district);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfUsersAddrDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfUsersAddrDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf users addr dtlses where district = &#63; from the database.
	 *
	 * @param district the district
	 */
	@Override
	public void removeBydgfUsersAddrDtlsByDistrict(long district) {
		for (DgfUsersAddrDtls dgfUsersAddrDtls :
				findBydgfUsersAddrDtlsByDistrict(
					district, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgfUsersAddrDtls);
		}
	}

	/**
	 * Returns the number of dgf users addr dtlses where district = &#63;.
	 *
	 * @param district the district
	 * @return the number of matching dgf users addr dtlses
	 */
	@Override
	public int countBydgfUsersAddrDtlsByDistrict(long district) {
		FinderPath finderPath = _finderPathCountBydgfUsersAddrDtlsByDistrict;

		Object[] finderArgs = new Object[] {district};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFUSERSADDRDTLS_WHERE);

			sb.append(_FINDER_COLUMN_DGFUSERSADDRDTLSBYDISTRICT_DISTRICT_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(district);

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
		_FINDER_COLUMN_DGFUSERSADDRDTLSBYDISTRICT_DISTRICT_2 =
			"dgfUsersAddrDtls.district = ?";

	private FinderPath _finderPathWithPaginationFindBydgfUsersAddrDtlsByUpzilla;
	private FinderPath
		_finderPathWithoutPaginationFindBydgfUsersAddrDtlsByUpzilla;
	private FinderPath _finderPathCountBydgfUsersAddrDtlsByUpzilla;

	/**
	 * Returns all the dgf users addr dtlses where upzilla = &#63;.
	 *
	 * @param upzilla the upzilla
	 * @return the matching dgf users addr dtlses
	 */
	@Override
	public List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByUpzilla(
		long upzilla) {

		return findBydgfUsersAddrDtlsByUpzilla(
			upzilla, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf users addr dtlses where upzilla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param upzilla the upzilla
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @return the range of matching dgf users addr dtlses
	 */
	@Override
	public List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByUpzilla(
		long upzilla, int start, int end) {

		return findBydgfUsersAddrDtlsByUpzilla(upzilla, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where upzilla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param upzilla the upzilla
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	@Override
	public List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByUpzilla(
		long upzilla, int start, int end,
		OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		return findBydgfUsersAddrDtlsByUpzilla(
			upzilla, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where upzilla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param upzilla the upzilla
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	@Override
	public List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByUpzilla(
		long upzilla, int start, int end,
		OrderByComparator<DgfUsersAddrDtls> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydgfUsersAddrDtlsByUpzilla;
				finderArgs = new Object[] {upzilla};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBydgfUsersAddrDtlsByUpzilla;
			finderArgs = new Object[] {upzilla, start, end, orderByComparator};
		}

		List<DgfUsersAddrDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfUsersAddrDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfUsersAddrDtls dgfUsersAddrDtls : list) {
					if (upzilla != dgfUsersAddrDtls.getUpzilla()) {
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

			sb.append(_SQL_SELECT_DGFUSERSADDRDTLS_WHERE);

			sb.append(_FINDER_COLUMN_DGFUSERSADDRDTLSBYUPZILLA_UPZILLA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfUsersAddrDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(upzilla);

				list = (List<DgfUsersAddrDtls>)QueryUtil.list(
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
	 * Returns the first dgf users addr dtls in the ordered set where upzilla = &#63;.
	 *
	 * @param upzilla the upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	@Override
	public DgfUsersAddrDtls findBydgfUsersAddrDtlsByUpzilla_First(
			long upzilla, OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException {

		DgfUsersAddrDtls dgfUsersAddrDtls =
			fetchBydgfUsersAddrDtlsByUpzilla_First(upzilla, orderByComparator);

		if (dgfUsersAddrDtls != null) {
			return dgfUsersAddrDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("upzilla=");
		sb.append(upzilla);

		sb.append("}");

		throw new NoSuchDgfUsersAddrDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf users addr dtls in the ordered set where upzilla = &#63;.
	 *
	 * @param upzilla the upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	@Override
	public DgfUsersAddrDtls fetchBydgfUsersAddrDtlsByUpzilla_First(
		long upzilla, OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		List<DgfUsersAddrDtls> list = findBydgfUsersAddrDtlsByUpzilla(
			upzilla, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf users addr dtls in the ordered set where upzilla = &#63;.
	 *
	 * @param upzilla the upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	@Override
	public DgfUsersAddrDtls findBydgfUsersAddrDtlsByUpzilla_Last(
			long upzilla, OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException {

		DgfUsersAddrDtls dgfUsersAddrDtls =
			fetchBydgfUsersAddrDtlsByUpzilla_Last(upzilla, orderByComparator);

		if (dgfUsersAddrDtls != null) {
			return dgfUsersAddrDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("upzilla=");
		sb.append(upzilla);

		sb.append("}");

		throw new NoSuchDgfUsersAddrDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf users addr dtls in the ordered set where upzilla = &#63;.
	 *
	 * @param upzilla the upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	@Override
	public DgfUsersAddrDtls fetchBydgfUsersAddrDtlsByUpzilla_Last(
		long upzilla, OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		int count = countBydgfUsersAddrDtlsByUpzilla(upzilla);

		if (count == 0) {
			return null;
		}

		List<DgfUsersAddrDtls> list = findBydgfUsersAddrDtlsByUpzilla(
			upzilla, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf users addr dtlses before and after the current dgf users addr dtls in the ordered set where upzilla = &#63;.
	 *
	 * @param addressId the primary key of the current dgf users addr dtls
	 * @param upzilla the upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a dgf users addr dtls with the primary key could not be found
	 */
	@Override
	public DgfUsersAddrDtls[] findBydgfUsersAddrDtlsByUpzilla_PrevAndNext(
			long addressId, long upzilla,
			OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException {

		DgfUsersAddrDtls dgfUsersAddrDtls = findByPrimaryKey(addressId);

		Session session = null;

		try {
			session = openSession();

			DgfUsersAddrDtls[] array = new DgfUsersAddrDtlsImpl[3];

			array[0] = getBydgfUsersAddrDtlsByUpzilla_PrevAndNext(
				session, dgfUsersAddrDtls, upzilla, orderByComparator, true);

			array[1] = dgfUsersAddrDtls;

			array[2] = getBydgfUsersAddrDtlsByUpzilla_PrevAndNext(
				session, dgfUsersAddrDtls, upzilla, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DgfUsersAddrDtls getBydgfUsersAddrDtlsByUpzilla_PrevAndNext(
		Session session, DgfUsersAddrDtls dgfUsersAddrDtls, long upzilla,
		OrderByComparator<DgfUsersAddrDtls> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFUSERSADDRDTLS_WHERE);

		sb.append(_FINDER_COLUMN_DGFUSERSADDRDTLSBYUPZILLA_UPZILLA_2);

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
			sb.append(DgfUsersAddrDtlsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(upzilla);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfUsersAddrDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfUsersAddrDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf users addr dtlses where upzilla = &#63; from the database.
	 *
	 * @param upzilla the upzilla
	 */
	@Override
	public void removeBydgfUsersAddrDtlsByUpzilla(long upzilla) {
		for (DgfUsersAddrDtls dgfUsersAddrDtls :
				findBydgfUsersAddrDtlsByUpzilla(
					upzilla, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgfUsersAddrDtls);
		}
	}

	/**
	 * Returns the number of dgf users addr dtlses where upzilla = &#63;.
	 *
	 * @param upzilla the upzilla
	 * @return the number of matching dgf users addr dtlses
	 */
	@Override
	public int countBydgfUsersAddrDtlsByUpzilla(long upzilla) {
		FinderPath finderPath = _finderPathCountBydgfUsersAddrDtlsByUpzilla;

		Object[] finderArgs = new Object[] {upzilla};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFUSERSADDRDTLS_WHERE);

			sb.append(_FINDER_COLUMN_DGFUSERSADDRDTLSBYUPZILLA_UPZILLA_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(upzilla);

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
		_FINDER_COLUMN_DGFUSERSADDRDTLSBYUPZILLA_UPZILLA_2 =
			"dgfUsersAddrDtls.upzilla = ?";

	private FinderPath _finderPathWithPaginationFindBydgfUsersAddrDtlsByUnion;
	private FinderPath
		_finderPathWithoutPaginationFindBydgfUsersAddrDtlsByUnion;
	private FinderPath _finderPathCountBydgfUsersAddrDtlsByUnion;

	/**
	 * Returns all the dgf users addr dtlses where unionName = &#63;.
	 *
	 * @param unionName the union name
	 * @return the matching dgf users addr dtlses
	 */
	@Override
	public List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByUnion(
		long unionName) {

		return findBydgfUsersAddrDtlsByUnion(
			unionName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf users addr dtlses where unionName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param unionName the union name
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @return the range of matching dgf users addr dtlses
	 */
	@Override
	public List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByUnion(
		long unionName, int start, int end) {

		return findBydgfUsersAddrDtlsByUnion(unionName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where unionName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param unionName the union name
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	@Override
	public List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByUnion(
		long unionName, int start, int end,
		OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		return findBydgfUsersAddrDtlsByUnion(
			unionName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where unionName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param unionName the union name
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	@Override
	public List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByUnion(
		long unionName, int start, int end,
		OrderByComparator<DgfUsersAddrDtls> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydgfUsersAddrDtlsByUnion;
				finderArgs = new Object[] {unionName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBydgfUsersAddrDtlsByUnion;
			finderArgs = new Object[] {
				unionName, start, end, orderByComparator
			};
		}

		List<DgfUsersAddrDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfUsersAddrDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfUsersAddrDtls dgfUsersAddrDtls : list) {
					if (unionName != dgfUsersAddrDtls.getUnionName()) {
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

			sb.append(_SQL_SELECT_DGFUSERSADDRDTLS_WHERE);

			sb.append(_FINDER_COLUMN_DGFUSERSADDRDTLSBYUNION_UNIONNAME_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfUsersAddrDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(unionName);

				list = (List<DgfUsersAddrDtls>)QueryUtil.list(
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
	 * Returns the first dgf users addr dtls in the ordered set where unionName = &#63;.
	 *
	 * @param unionName the union name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	@Override
	public DgfUsersAddrDtls findBydgfUsersAddrDtlsByUnion_First(
			long unionName,
			OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException {

		DgfUsersAddrDtls dgfUsersAddrDtls =
			fetchBydgfUsersAddrDtlsByUnion_First(unionName, orderByComparator);

		if (dgfUsersAddrDtls != null) {
			return dgfUsersAddrDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unionName=");
		sb.append(unionName);

		sb.append("}");

		throw new NoSuchDgfUsersAddrDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf users addr dtls in the ordered set where unionName = &#63;.
	 *
	 * @param unionName the union name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	@Override
	public DgfUsersAddrDtls fetchBydgfUsersAddrDtlsByUnion_First(
		long unionName, OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		List<DgfUsersAddrDtls> list = findBydgfUsersAddrDtlsByUnion(
			unionName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf users addr dtls in the ordered set where unionName = &#63;.
	 *
	 * @param unionName the union name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	@Override
	public DgfUsersAddrDtls findBydgfUsersAddrDtlsByUnion_Last(
			long unionName,
			OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException {

		DgfUsersAddrDtls dgfUsersAddrDtls = fetchBydgfUsersAddrDtlsByUnion_Last(
			unionName, orderByComparator);

		if (dgfUsersAddrDtls != null) {
			return dgfUsersAddrDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("unionName=");
		sb.append(unionName);

		sb.append("}");

		throw new NoSuchDgfUsersAddrDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf users addr dtls in the ordered set where unionName = &#63;.
	 *
	 * @param unionName the union name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	@Override
	public DgfUsersAddrDtls fetchBydgfUsersAddrDtlsByUnion_Last(
		long unionName, OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		int count = countBydgfUsersAddrDtlsByUnion(unionName);

		if (count == 0) {
			return null;
		}

		List<DgfUsersAddrDtls> list = findBydgfUsersAddrDtlsByUnion(
			unionName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf users addr dtlses before and after the current dgf users addr dtls in the ordered set where unionName = &#63;.
	 *
	 * @param addressId the primary key of the current dgf users addr dtls
	 * @param unionName the union name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a dgf users addr dtls with the primary key could not be found
	 */
	@Override
	public DgfUsersAddrDtls[] findBydgfUsersAddrDtlsByUnion_PrevAndNext(
			long addressId, long unionName,
			OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException {

		DgfUsersAddrDtls dgfUsersAddrDtls = findByPrimaryKey(addressId);

		Session session = null;

		try {
			session = openSession();

			DgfUsersAddrDtls[] array = new DgfUsersAddrDtlsImpl[3];

			array[0] = getBydgfUsersAddrDtlsByUnion_PrevAndNext(
				session, dgfUsersAddrDtls, unionName, orderByComparator, true);

			array[1] = dgfUsersAddrDtls;

			array[2] = getBydgfUsersAddrDtlsByUnion_PrevAndNext(
				session, dgfUsersAddrDtls, unionName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DgfUsersAddrDtls getBydgfUsersAddrDtlsByUnion_PrevAndNext(
		Session session, DgfUsersAddrDtls dgfUsersAddrDtls, long unionName,
		OrderByComparator<DgfUsersAddrDtls> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFUSERSADDRDTLS_WHERE);

		sb.append(_FINDER_COLUMN_DGFUSERSADDRDTLSBYUNION_UNIONNAME_2);

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
			sb.append(DgfUsersAddrDtlsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(unionName);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfUsersAddrDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfUsersAddrDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf users addr dtlses where unionName = &#63; from the database.
	 *
	 * @param unionName the union name
	 */
	@Override
	public void removeBydgfUsersAddrDtlsByUnion(long unionName) {
		for (DgfUsersAddrDtls dgfUsersAddrDtls :
				findBydgfUsersAddrDtlsByUnion(
					unionName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgfUsersAddrDtls);
		}
	}

	/**
	 * Returns the number of dgf users addr dtlses where unionName = &#63;.
	 *
	 * @param unionName the union name
	 * @return the number of matching dgf users addr dtlses
	 */
	@Override
	public int countBydgfUsersAddrDtlsByUnion(long unionName) {
		FinderPath finderPath = _finderPathCountBydgfUsersAddrDtlsByUnion;

		Object[] finderArgs = new Object[] {unionName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFUSERSADDRDTLS_WHERE);

			sb.append(_FINDER_COLUMN_DGFUSERSADDRDTLSBYUNION_UNIONNAME_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(unionName);

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
		_FINDER_COLUMN_DGFUSERSADDRDTLSBYUNION_UNIONNAME_2 =
			"dgfUsersAddrDtls.unionName = ?";

	private FinderPath _finderPathWithPaginationFindBydgfUsersAddrDtlsByWard;
	private FinderPath _finderPathWithoutPaginationFindBydgfUsersAddrDtlsByWard;
	private FinderPath _finderPathCountBydgfUsersAddrDtlsByWard;

	/**
	 * Returns all the dgf users addr dtlses where ward = &#63;.
	 *
	 * @param ward the ward
	 * @return the matching dgf users addr dtlses
	 */
	@Override
	public List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByWard(String ward) {
		return findBydgfUsersAddrDtlsByWard(
			ward, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf users addr dtlses where ward = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param ward the ward
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @return the range of matching dgf users addr dtlses
	 */
	@Override
	public List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByWard(
		String ward, int start, int end) {

		return findBydgfUsersAddrDtlsByWard(ward, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where ward = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param ward the ward
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	@Override
	public List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByWard(
		String ward, int start, int end,
		OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		return findBydgfUsersAddrDtlsByWard(
			ward, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where ward = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param ward the ward
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	@Override
	public List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByWard(
		String ward, int start, int end,
		OrderByComparator<DgfUsersAddrDtls> orderByComparator,
		boolean useFinderCache) {

		ward = Objects.toString(ward, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydgfUsersAddrDtlsByWard;
				finderArgs = new Object[] {ward};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBydgfUsersAddrDtlsByWard;
			finderArgs = new Object[] {ward, start, end, orderByComparator};
		}

		List<DgfUsersAddrDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfUsersAddrDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfUsersAddrDtls dgfUsersAddrDtls : list) {
					if (!ward.equals(dgfUsersAddrDtls.getWard())) {
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

			sb.append(_SQL_SELECT_DGFUSERSADDRDTLS_WHERE);

			boolean bindWard = false;

			if (ward.isEmpty()) {
				sb.append(_FINDER_COLUMN_DGFUSERSADDRDTLSBYWARD_WARD_3);
			}
			else {
				bindWard = true;

				sb.append(_FINDER_COLUMN_DGFUSERSADDRDTLSBYWARD_WARD_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfUsersAddrDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindWard) {
					queryPos.add(ward);
				}

				list = (List<DgfUsersAddrDtls>)QueryUtil.list(
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
	 * Returns the first dgf users addr dtls in the ordered set where ward = &#63;.
	 *
	 * @param ward the ward
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	@Override
	public DgfUsersAddrDtls findBydgfUsersAddrDtlsByWard_First(
			String ward, OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException {

		DgfUsersAddrDtls dgfUsersAddrDtls = fetchBydgfUsersAddrDtlsByWard_First(
			ward, orderByComparator);

		if (dgfUsersAddrDtls != null) {
			return dgfUsersAddrDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ward=");
		sb.append(ward);

		sb.append("}");

		throw new NoSuchDgfUsersAddrDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf users addr dtls in the ordered set where ward = &#63;.
	 *
	 * @param ward the ward
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	@Override
	public DgfUsersAddrDtls fetchBydgfUsersAddrDtlsByWard_First(
		String ward, OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		List<DgfUsersAddrDtls> list = findBydgfUsersAddrDtlsByWard(
			ward, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf users addr dtls in the ordered set where ward = &#63;.
	 *
	 * @param ward the ward
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	@Override
	public DgfUsersAddrDtls findBydgfUsersAddrDtlsByWard_Last(
			String ward, OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException {

		DgfUsersAddrDtls dgfUsersAddrDtls = fetchBydgfUsersAddrDtlsByWard_Last(
			ward, orderByComparator);

		if (dgfUsersAddrDtls != null) {
			return dgfUsersAddrDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ward=");
		sb.append(ward);

		sb.append("}");

		throw new NoSuchDgfUsersAddrDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf users addr dtls in the ordered set where ward = &#63;.
	 *
	 * @param ward the ward
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	@Override
	public DgfUsersAddrDtls fetchBydgfUsersAddrDtlsByWard_Last(
		String ward, OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		int count = countBydgfUsersAddrDtlsByWard(ward);

		if (count == 0) {
			return null;
		}

		List<DgfUsersAddrDtls> list = findBydgfUsersAddrDtlsByWard(
			ward, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf users addr dtlses before and after the current dgf users addr dtls in the ordered set where ward = &#63;.
	 *
	 * @param addressId the primary key of the current dgf users addr dtls
	 * @param ward the ward
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a dgf users addr dtls with the primary key could not be found
	 */
	@Override
	public DgfUsersAddrDtls[] findBydgfUsersAddrDtlsByWard_PrevAndNext(
			long addressId, String ward,
			OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException {

		ward = Objects.toString(ward, "");

		DgfUsersAddrDtls dgfUsersAddrDtls = findByPrimaryKey(addressId);

		Session session = null;

		try {
			session = openSession();

			DgfUsersAddrDtls[] array = new DgfUsersAddrDtlsImpl[3];

			array[0] = getBydgfUsersAddrDtlsByWard_PrevAndNext(
				session, dgfUsersAddrDtls, ward, orderByComparator, true);

			array[1] = dgfUsersAddrDtls;

			array[2] = getBydgfUsersAddrDtlsByWard_PrevAndNext(
				session, dgfUsersAddrDtls, ward, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DgfUsersAddrDtls getBydgfUsersAddrDtlsByWard_PrevAndNext(
		Session session, DgfUsersAddrDtls dgfUsersAddrDtls, String ward,
		OrderByComparator<DgfUsersAddrDtls> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFUSERSADDRDTLS_WHERE);

		boolean bindWard = false;

		if (ward.isEmpty()) {
			sb.append(_FINDER_COLUMN_DGFUSERSADDRDTLSBYWARD_WARD_3);
		}
		else {
			bindWard = true;

			sb.append(_FINDER_COLUMN_DGFUSERSADDRDTLSBYWARD_WARD_2);
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
			sb.append(DgfUsersAddrDtlsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindWard) {
			queryPos.add(ward);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfUsersAddrDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfUsersAddrDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf users addr dtlses where ward = &#63; from the database.
	 *
	 * @param ward the ward
	 */
	@Override
	public void removeBydgfUsersAddrDtlsByWard(String ward) {
		for (DgfUsersAddrDtls dgfUsersAddrDtls :
				findBydgfUsersAddrDtlsByWard(
					ward, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgfUsersAddrDtls);
		}
	}

	/**
	 * Returns the number of dgf users addr dtlses where ward = &#63;.
	 *
	 * @param ward the ward
	 * @return the number of matching dgf users addr dtlses
	 */
	@Override
	public int countBydgfUsersAddrDtlsByWard(String ward) {
		ward = Objects.toString(ward, "");

		FinderPath finderPath = _finderPathCountBydgfUsersAddrDtlsByWard;

		Object[] finderArgs = new Object[] {ward};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFUSERSADDRDTLS_WHERE);

			boolean bindWard = false;

			if (ward.isEmpty()) {
				sb.append(_FINDER_COLUMN_DGFUSERSADDRDTLSBYWARD_WARD_3);
			}
			else {
				bindWard = true;

				sb.append(_FINDER_COLUMN_DGFUSERSADDRDTLSBYWARD_WARD_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindWard) {
					queryPos.add(ward);
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

	private static final String _FINDER_COLUMN_DGFUSERSADDRDTLSBYWARD_WARD_2 =
		"dgfUsersAddrDtls.ward = ?";

	private static final String _FINDER_COLUMN_DGFUSERSADDRDTLSBYWARD_WARD_3 =
		"(dgfUsersAddrDtls.ward IS NULL OR dgfUsersAddrDtls.ward = '')";

	private FinderPath
		_finderPathWithPaginationFindByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla;
	private FinderPath
		_finderPathWithoutPaginationFindByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla;
	private FinderPath
		_finderPathCountByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla;

	/**
	 * Returns all the dgf users addr dtlses where division = &#63; and district = &#63; and upzilla = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 * @return the matching dgf users addr dtlses
	 */
	@Override
	public List<DgfUsersAddrDtls>
		findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
			long division, long district, long upzilla) {

		return findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
			division, district, upzilla, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the dgf users addr dtlses where division = &#63; and district = &#63; and upzilla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @return the range of matching dgf users addr dtlses
	 */
	@Override
	public List<DgfUsersAddrDtls>
		findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
			long division, long district, long upzilla, int start, int end) {

		return findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
			division, district, upzilla, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where division = &#63; and district = &#63; and upzilla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	@Override
	public List<DgfUsersAddrDtls>
		findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
			long division, long district, long upzilla, int start, int end,
			OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		return findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
			division, district, upzilla, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where division = &#63; and district = &#63; and upzilla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	@Override
	public List<DgfUsersAddrDtls>
		findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
			long division, long district, long upzilla, int start, int end,
			OrderByComparator<DgfUsersAddrDtls> orderByComparator,
			boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla;
				finderArgs = new Object[] {division, district, upzilla};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla;
			finderArgs = new Object[] {
				division, district, upzilla, start, end, orderByComparator
			};
		}

		List<DgfUsersAddrDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfUsersAddrDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfUsersAddrDtls dgfUsersAddrDtls : list) {
					if ((division != dgfUsersAddrDtls.getDivision()) ||
						(district != dgfUsersAddrDtls.getDistrict()) ||
						(upzilla != dgfUsersAddrDtls.getUpzilla())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_DGFUSERSADDRDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFUSERSADDRDTLSBYDIVISIONANDDISTRICTANDUPZILLA_DIVISION_2);

			sb.append(
				_FINDER_COLUMN_DGFUSERSADDRDTLSBYDIVISIONANDDISTRICTANDUPZILLA_DISTRICT_2);

			sb.append(
				_FINDER_COLUMN_DGFUSERSADDRDTLSBYDIVISIONANDDISTRICTANDUPZILLA_UPZILLA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfUsersAddrDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(division);

				queryPos.add(district);

				queryPos.add(upzilla);

				list = (List<DgfUsersAddrDtls>)QueryUtil.list(
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
	 * Returns the first dgf users addr dtls in the ordered set where division = &#63; and district = &#63; and upzilla = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	@Override
	public DgfUsersAddrDtls
			findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla_First(
				long division, long district, long upzilla,
				OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException {

		DgfUsersAddrDtls dgfUsersAddrDtls =
			fetchByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla_First(
				division, district, upzilla, orderByComparator);

		if (dgfUsersAddrDtls != null) {
			return dgfUsersAddrDtls;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("division=");
		sb.append(division);

		sb.append(", district=");
		sb.append(district);

		sb.append(", upzilla=");
		sb.append(upzilla);

		sb.append("}");

		throw new NoSuchDgfUsersAddrDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf users addr dtls in the ordered set where division = &#63; and district = &#63; and upzilla = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	@Override
	public DgfUsersAddrDtls
		fetchByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla_First(
			long division, long district, long upzilla,
			OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		List<DgfUsersAddrDtls> list =
			findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
				division, district, upzilla, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf users addr dtls in the ordered set where division = &#63; and district = &#63; and upzilla = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	@Override
	public DgfUsersAddrDtls
			findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla_Last(
				long division, long district, long upzilla,
				OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException {

		DgfUsersAddrDtls dgfUsersAddrDtls =
			fetchByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla_Last(
				division, district, upzilla, orderByComparator);

		if (dgfUsersAddrDtls != null) {
			return dgfUsersAddrDtls;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("division=");
		sb.append(division);

		sb.append(", district=");
		sb.append(district);

		sb.append(", upzilla=");
		sb.append(upzilla);

		sb.append("}");

		throw new NoSuchDgfUsersAddrDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf users addr dtls in the ordered set where division = &#63; and district = &#63; and upzilla = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	@Override
	public DgfUsersAddrDtls
		fetchByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla_Last(
			long division, long district, long upzilla,
			OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		int count = countByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
			division, district, upzilla);

		if (count == 0) {
			return null;
		}

		List<DgfUsersAddrDtls> list =
			findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
				division, district, upzilla, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf users addr dtlses before and after the current dgf users addr dtls in the ordered set where division = &#63; and district = &#63; and upzilla = &#63;.
	 *
	 * @param addressId the primary key of the current dgf users addr dtls
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a dgf users addr dtls with the primary key could not be found
	 */
	@Override
	public DgfUsersAddrDtls[]
			findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla_PrevAndNext(
				long addressId, long division, long district, long upzilla,
				OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException {

		DgfUsersAddrDtls dgfUsersAddrDtls = findByPrimaryKey(addressId);

		Session session = null;

		try {
			session = openSession();

			DgfUsersAddrDtls[] array = new DgfUsersAddrDtlsImpl[3];

			array[0] =
				getByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla_PrevAndNext(
					session, dgfUsersAddrDtls, division, district, upzilla,
					orderByComparator, true);

			array[1] = dgfUsersAddrDtls;

			array[2] =
				getByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla_PrevAndNext(
					session, dgfUsersAddrDtls, division, district, upzilla,
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

	protected DgfUsersAddrDtls
		getByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla_PrevAndNext(
			Session session, DgfUsersAddrDtls dgfUsersAddrDtls, long division,
			long district, long upzilla,
			OrderByComparator<DgfUsersAddrDtls> orderByComparator,
			boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_DGFUSERSADDRDTLS_WHERE);

		sb.append(
			_FINDER_COLUMN_DGFUSERSADDRDTLSBYDIVISIONANDDISTRICTANDUPZILLA_DIVISION_2);

		sb.append(
			_FINDER_COLUMN_DGFUSERSADDRDTLSBYDIVISIONANDDISTRICTANDUPZILLA_DISTRICT_2);

		sb.append(
			_FINDER_COLUMN_DGFUSERSADDRDTLSBYDIVISIONANDDISTRICTANDUPZILLA_UPZILLA_2);

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
			sb.append(DgfUsersAddrDtlsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(division);

		queryPos.add(district);

		queryPos.add(upzilla);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfUsersAddrDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfUsersAddrDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf users addr dtlses where division = &#63; and district = &#63; and upzilla = &#63; from the database.
	 *
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 */
	@Override
	public void removeByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
		long division, long district, long upzilla) {

		for (DgfUsersAddrDtls dgfUsersAddrDtls :
				findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
					division, district, upzilla, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(dgfUsersAddrDtls);
		}
	}

	/**
	 * Returns the number of dgf users addr dtlses where division = &#63; and district = &#63; and upzilla = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 * @return the number of matching dgf users addr dtlses
	 */
	@Override
	public int countByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
		long division, long district, long upzilla) {

		FinderPath finderPath =
			_finderPathCountByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla;

		Object[] finderArgs = new Object[] {division, district, upzilla};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DGFUSERSADDRDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFUSERSADDRDTLSBYDIVISIONANDDISTRICTANDUPZILLA_DIVISION_2);

			sb.append(
				_FINDER_COLUMN_DGFUSERSADDRDTLSBYDIVISIONANDDISTRICTANDUPZILLA_DISTRICT_2);

			sb.append(
				_FINDER_COLUMN_DGFUSERSADDRDTLSBYDIVISIONANDDISTRICTANDUPZILLA_UPZILLA_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(division);

				queryPos.add(district);

				queryPos.add(upzilla);

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
		_FINDER_COLUMN_DGFUSERSADDRDTLSBYDIVISIONANDDISTRICTANDUPZILLA_DIVISION_2 =
			"dgfUsersAddrDtls.division = ? AND ";

	private static final String
		_FINDER_COLUMN_DGFUSERSADDRDTLSBYDIVISIONANDDISTRICTANDUPZILLA_DISTRICT_2 =
			"dgfUsersAddrDtls.district = ? AND ";

	private static final String
		_FINDER_COLUMN_DGFUSERSADDRDTLSBYDIVISIONANDDISTRICTANDUPZILLA_UPZILLA_2 =
			"dgfUsersAddrDtls.upzilla = ?";

	private FinderPath
		_finderPathWithPaginationFindByDgfUsersAddrDtlsByDivisionAndDistrict;
	private FinderPath
		_finderPathWithoutPaginationFindByDgfUsersAddrDtlsByDivisionAndDistrict;
	private FinderPath _finderPathCountByDgfUsersAddrDtlsByDivisionAndDistrict;

	/**
	 * Returns all the dgf users addr dtlses where division = &#63; and district = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @return the matching dgf users addr dtlses
	 */
	@Override
	public List<DgfUsersAddrDtls> findByDgfUsersAddrDtlsByDivisionAndDistrict(
		long division, long district) {

		return findByDgfUsersAddrDtlsByDivisionAndDistrict(
			division, district, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf users addr dtlses where division = &#63; and district = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param division the division
	 * @param district the district
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @return the range of matching dgf users addr dtlses
	 */
	@Override
	public List<DgfUsersAddrDtls> findByDgfUsersAddrDtlsByDivisionAndDistrict(
		long division, long district, int start, int end) {

		return findByDgfUsersAddrDtlsByDivisionAndDistrict(
			division, district, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where division = &#63; and district = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param division the division
	 * @param district the district
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	@Override
	public List<DgfUsersAddrDtls> findByDgfUsersAddrDtlsByDivisionAndDistrict(
		long division, long district, int start, int end,
		OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		return findByDgfUsersAddrDtlsByDivisionAndDistrict(
			division, district, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where division = &#63; and district = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param division the division
	 * @param district the district
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	@Override
	public List<DgfUsersAddrDtls> findByDgfUsersAddrDtlsByDivisionAndDistrict(
		long division, long district, int start, int end,
		OrderByComparator<DgfUsersAddrDtls> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByDgfUsersAddrDtlsByDivisionAndDistrict;
				finderArgs = new Object[] {division, district};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByDgfUsersAddrDtlsByDivisionAndDistrict;
			finderArgs = new Object[] {
				division, district, start, end, orderByComparator
			};
		}

		List<DgfUsersAddrDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfUsersAddrDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfUsersAddrDtls dgfUsersAddrDtls : list) {
					if ((division != dgfUsersAddrDtls.getDivision()) ||
						(district != dgfUsersAddrDtls.getDistrict())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_DGFUSERSADDRDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFUSERSADDRDTLSBYDIVISIONANDDISTRICT_DIVISION_2);

			sb.append(
				_FINDER_COLUMN_DGFUSERSADDRDTLSBYDIVISIONANDDISTRICT_DISTRICT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfUsersAddrDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(division);

				queryPos.add(district);

				list = (List<DgfUsersAddrDtls>)QueryUtil.list(
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
	 * Returns the first dgf users addr dtls in the ordered set where division = &#63; and district = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	@Override
	public DgfUsersAddrDtls findByDgfUsersAddrDtlsByDivisionAndDistrict_First(
			long division, long district,
			OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException {

		DgfUsersAddrDtls dgfUsersAddrDtls =
			fetchByDgfUsersAddrDtlsByDivisionAndDistrict_First(
				division, district, orderByComparator);

		if (dgfUsersAddrDtls != null) {
			return dgfUsersAddrDtls;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("division=");
		sb.append(division);

		sb.append(", district=");
		sb.append(district);

		sb.append("}");

		throw new NoSuchDgfUsersAddrDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf users addr dtls in the ordered set where division = &#63; and district = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	@Override
	public DgfUsersAddrDtls fetchByDgfUsersAddrDtlsByDivisionAndDistrict_First(
		long division, long district,
		OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		List<DgfUsersAddrDtls> list =
			findByDgfUsersAddrDtlsByDivisionAndDistrict(
				division, district, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf users addr dtls in the ordered set where division = &#63; and district = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	@Override
	public DgfUsersAddrDtls findByDgfUsersAddrDtlsByDivisionAndDistrict_Last(
			long division, long district,
			OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException {

		DgfUsersAddrDtls dgfUsersAddrDtls =
			fetchByDgfUsersAddrDtlsByDivisionAndDistrict_Last(
				division, district, orderByComparator);

		if (dgfUsersAddrDtls != null) {
			return dgfUsersAddrDtls;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("division=");
		sb.append(division);

		sb.append(", district=");
		sb.append(district);

		sb.append("}");

		throw new NoSuchDgfUsersAddrDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf users addr dtls in the ordered set where division = &#63; and district = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	@Override
	public DgfUsersAddrDtls fetchByDgfUsersAddrDtlsByDivisionAndDistrict_Last(
		long division, long district,
		OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		int count = countByDgfUsersAddrDtlsByDivisionAndDistrict(
			division, district);

		if (count == 0) {
			return null;
		}

		List<DgfUsersAddrDtls> list =
			findByDgfUsersAddrDtlsByDivisionAndDistrict(
				division, district, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf users addr dtlses before and after the current dgf users addr dtls in the ordered set where division = &#63; and district = &#63;.
	 *
	 * @param addressId the primary key of the current dgf users addr dtls
	 * @param division the division
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a dgf users addr dtls with the primary key could not be found
	 */
	@Override
	public DgfUsersAddrDtls[]
			findByDgfUsersAddrDtlsByDivisionAndDistrict_PrevAndNext(
				long addressId, long division, long district,
				OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws NoSuchDgfUsersAddrDtlsException {

		DgfUsersAddrDtls dgfUsersAddrDtls = findByPrimaryKey(addressId);

		Session session = null;

		try {
			session = openSession();

			DgfUsersAddrDtls[] array = new DgfUsersAddrDtlsImpl[3];

			array[0] = getByDgfUsersAddrDtlsByDivisionAndDistrict_PrevAndNext(
				session, dgfUsersAddrDtls, division, district,
				orderByComparator, true);

			array[1] = dgfUsersAddrDtls;

			array[2] = getByDgfUsersAddrDtlsByDivisionAndDistrict_PrevAndNext(
				session, dgfUsersAddrDtls, division, district,
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

	protected DgfUsersAddrDtls
		getByDgfUsersAddrDtlsByDivisionAndDistrict_PrevAndNext(
			Session session, DgfUsersAddrDtls dgfUsersAddrDtls, long division,
			long district,
			OrderByComparator<DgfUsersAddrDtls> orderByComparator,
			boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DGFUSERSADDRDTLS_WHERE);

		sb.append(
			_FINDER_COLUMN_DGFUSERSADDRDTLSBYDIVISIONANDDISTRICT_DIVISION_2);

		sb.append(
			_FINDER_COLUMN_DGFUSERSADDRDTLSBYDIVISIONANDDISTRICT_DISTRICT_2);

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
			sb.append(DgfUsersAddrDtlsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(division);

		queryPos.add(district);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfUsersAddrDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfUsersAddrDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf users addr dtlses where division = &#63; and district = &#63; from the database.
	 *
	 * @param division the division
	 * @param district the district
	 */
	@Override
	public void removeByDgfUsersAddrDtlsByDivisionAndDistrict(
		long division, long district) {

		for (DgfUsersAddrDtls dgfUsersAddrDtls :
				findByDgfUsersAddrDtlsByDivisionAndDistrict(
					division, district, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgfUsersAddrDtls);
		}
	}

	/**
	 * Returns the number of dgf users addr dtlses where division = &#63; and district = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @return the number of matching dgf users addr dtlses
	 */
	@Override
	public int countByDgfUsersAddrDtlsByDivisionAndDistrict(
		long division, long district) {

		FinderPath finderPath =
			_finderPathCountByDgfUsersAddrDtlsByDivisionAndDistrict;

		Object[] finderArgs = new Object[] {division, district};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFUSERSADDRDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFUSERSADDRDTLSBYDIVISIONANDDISTRICT_DIVISION_2);

			sb.append(
				_FINDER_COLUMN_DGFUSERSADDRDTLSBYDIVISIONANDDISTRICT_DISTRICT_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(division);

				queryPos.add(district);

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
		_FINDER_COLUMN_DGFUSERSADDRDTLSBYDIVISIONANDDISTRICT_DIVISION_2 =
			"dgfUsersAddrDtls.division = ? AND ";

	private static final String
		_FINDER_COLUMN_DGFUSERSADDRDTLSBYDIVISIONANDDISTRICT_DISTRICT_2 =
			"dgfUsersAddrDtls.district = ?";

	public DgfUsersAddrDtlsPersistenceImpl() {
		setModelClass(DgfUsersAddrDtls.class);

		setModelImplClass(DgfUsersAddrDtlsImpl.class);
		setModelPKClass(long.class);

		setTable(DgfUsersAddrDtlsTable.INSTANCE);
	}

	/**
	 * Caches the dgf users addr dtls in the entity cache if it is enabled.
	 *
	 * @param dgfUsersAddrDtls the dgf users addr dtls
	 */
	@Override
	public void cacheResult(DgfUsersAddrDtls dgfUsersAddrDtls) {
		entityCache.putResult(
			DgfUsersAddrDtlsImpl.class, dgfUsersAddrDtls.getPrimaryKey(),
			dgfUsersAddrDtls);

		finderCache.putResult(
			_finderPathFetchBydgfUsersAddrDtlsByNationalId,
			new Object[] {dgfUsersAddrDtls.getNationalId()}, dgfUsersAddrDtls);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dgf users addr dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfUsersAddrDtlses the dgf users addr dtlses
	 */
	@Override
	public void cacheResult(List<DgfUsersAddrDtls> dgfUsersAddrDtlses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgfUsersAddrDtlses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DgfUsersAddrDtls dgfUsersAddrDtls : dgfUsersAddrDtlses) {
			if (entityCache.getResult(
					DgfUsersAddrDtlsImpl.class,
					dgfUsersAddrDtls.getPrimaryKey()) == null) {

				cacheResult(dgfUsersAddrDtls);
			}
		}
	}

	/**
	 * Clears the cache for all dgf users addr dtlses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DgfUsersAddrDtlsImpl.class);

		finderCache.clearCache(DgfUsersAddrDtlsImpl.class);
	}

	/**
	 * Clears the cache for the dgf users addr dtls.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DgfUsersAddrDtls dgfUsersAddrDtls) {
		entityCache.removeResult(DgfUsersAddrDtlsImpl.class, dgfUsersAddrDtls);
	}

	@Override
	public void clearCache(List<DgfUsersAddrDtls> dgfUsersAddrDtlses) {
		for (DgfUsersAddrDtls dgfUsersAddrDtls : dgfUsersAddrDtlses) {
			entityCache.removeResult(
				DgfUsersAddrDtlsImpl.class, dgfUsersAddrDtls);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DgfUsersAddrDtlsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DgfUsersAddrDtlsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DgfUsersAddrDtlsModelImpl dgfUsersAddrDtlsModelImpl) {

		Object[] args = new Object[] {
			dgfUsersAddrDtlsModelImpl.getNationalId()
		};

		finderCache.putResult(
			_finderPathCountBydgfUsersAddrDtlsByNationalId, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchBydgfUsersAddrDtlsByNationalId, args,
			dgfUsersAddrDtlsModelImpl);
	}

	/**
	 * Creates a new dgf users addr dtls with the primary key. Does not add the dgf users addr dtls to the database.
	 *
	 * @param addressId the primary key for the new dgf users addr dtls
	 * @return the new dgf users addr dtls
	 */
	@Override
	public DgfUsersAddrDtls create(long addressId) {
		DgfUsersAddrDtls dgfUsersAddrDtls = new DgfUsersAddrDtlsImpl();

		dgfUsersAddrDtls.setNew(true);
		dgfUsersAddrDtls.setPrimaryKey(addressId);

		return dgfUsersAddrDtls;
	}

	/**
	 * Removes the dgf users addr dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addressId the primary key of the dgf users addr dtls
	 * @return the dgf users addr dtls that was removed
	 * @throws NoSuchDgfUsersAddrDtlsException if a dgf users addr dtls with the primary key could not be found
	 */
	@Override
	public DgfUsersAddrDtls remove(long addressId)
		throws NoSuchDgfUsersAddrDtlsException {

		return remove((Serializable)addressId);
	}

	/**
	 * Removes the dgf users addr dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dgf users addr dtls
	 * @return the dgf users addr dtls that was removed
	 * @throws NoSuchDgfUsersAddrDtlsException if a dgf users addr dtls with the primary key could not be found
	 */
	@Override
	public DgfUsersAddrDtls remove(Serializable primaryKey)
		throws NoSuchDgfUsersAddrDtlsException {

		Session session = null;

		try {
			session = openSession();

			DgfUsersAddrDtls dgfUsersAddrDtls = (DgfUsersAddrDtls)session.get(
				DgfUsersAddrDtlsImpl.class, primaryKey);

			if (dgfUsersAddrDtls == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDgfUsersAddrDtlsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgfUsersAddrDtls);
		}
		catch (NoSuchDgfUsersAddrDtlsException noSuchEntityException) {
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
	protected DgfUsersAddrDtls removeImpl(DgfUsersAddrDtls dgfUsersAddrDtls) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgfUsersAddrDtls)) {
				dgfUsersAddrDtls = (DgfUsersAddrDtls)session.get(
					DgfUsersAddrDtlsImpl.class,
					dgfUsersAddrDtls.getPrimaryKeyObj());
			}

			if (dgfUsersAddrDtls != null) {
				session.delete(dgfUsersAddrDtls);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgfUsersAddrDtls != null) {
			clearCache(dgfUsersAddrDtls);
		}

		return dgfUsersAddrDtls;
	}

	@Override
	public DgfUsersAddrDtls updateImpl(DgfUsersAddrDtls dgfUsersAddrDtls) {
		boolean isNew = dgfUsersAddrDtls.isNew();

		if (!(dgfUsersAddrDtls instanceof DgfUsersAddrDtlsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dgfUsersAddrDtls.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dgfUsersAddrDtls);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgfUsersAddrDtls proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DgfUsersAddrDtls implementation " +
					dgfUsersAddrDtls.getClass());
		}

		DgfUsersAddrDtlsModelImpl dgfUsersAddrDtlsModelImpl =
			(DgfUsersAddrDtlsModelImpl)dgfUsersAddrDtls;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgfUsersAddrDtls);
			}
			else {
				dgfUsersAddrDtls = (DgfUsersAddrDtls)session.merge(
					dgfUsersAddrDtls);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DgfUsersAddrDtlsImpl.class, dgfUsersAddrDtlsModelImpl, false, true);

		cacheUniqueFindersCache(dgfUsersAddrDtlsModelImpl);

		if (isNew) {
			dgfUsersAddrDtls.setNew(false);
		}

		dgfUsersAddrDtls.resetOriginalValues();

		return dgfUsersAddrDtls;
	}

	/**
	 * Returns the dgf users addr dtls with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dgf users addr dtls
	 * @return the dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a dgf users addr dtls with the primary key could not be found
	 */
	@Override
	public DgfUsersAddrDtls findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDgfUsersAddrDtlsException {

		DgfUsersAddrDtls dgfUsersAddrDtls = fetchByPrimaryKey(primaryKey);

		if (dgfUsersAddrDtls == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDgfUsersAddrDtlsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgfUsersAddrDtls;
	}

	/**
	 * Returns the dgf users addr dtls with the primary key or throws a <code>NoSuchDgfUsersAddrDtlsException</code> if it could not be found.
	 *
	 * @param addressId the primary key of the dgf users addr dtls
	 * @return the dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a dgf users addr dtls with the primary key could not be found
	 */
	@Override
	public DgfUsersAddrDtls findByPrimaryKey(long addressId)
		throws NoSuchDgfUsersAddrDtlsException {

		return findByPrimaryKey((Serializable)addressId);
	}

	/**
	 * Returns the dgf users addr dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addressId the primary key of the dgf users addr dtls
	 * @return the dgf users addr dtls, or <code>null</code> if a dgf users addr dtls with the primary key could not be found
	 */
	@Override
	public DgfUsersAddrDtls fetchByPrimaryKey(long addressId) {
		return fetchByPrimaryKey((Serializable)addressId);
	}

	/**
	 * Returns all the dgf users addr dtlses.
	 *
	 * @return the dgf users addr dtlses
	 */
	@Override
	public List<DgfUsersAddrDtls> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf users addr dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @return the range of dgf users addr dtlses
	 */
	@Override
	public List<DgfUsersAddrDtls> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf users addr dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf users addr dtlses
	 */
	@Override
	public List<DgfUsersAddrDtls> findAll(
		int start, int end,
		OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf users addr dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf users addr dtlses
	 */
	@Override
	public List<DgfUsersAddrDtls> findAll(
		int start, int end,
		OrderByComparator<DgfUsersAddrDtls> orderByComparator,
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

		List<DgfUsersAddrDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfUsersAddrDtls>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFUSERSADDRDTLS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFUSERSADDRDTLS;

				sql = sql.concat(DgfUsersAddrDtlsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DgfUsersAddrDtls>)QueryUtil.list(
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
	 * Removes all the dgf users addr dtlses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DgfUsersAddrDtls dgfUsersAddrDtls : findAll()) {
			remove(dgfUsersAddrDtls);
		}
	}

	/**
	 * Returns the number of dgf users addr dtlses.
	 *
	 * @return the number of dgf users addr dtlses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DGFUSERSADDRDTLS);

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
		return "addressId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DGFUSERSADDRDTLS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DgfUsersAddrDtlsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dgf users addr dtls persistence.
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

		_finderPathFetchBydgfUsersAddrDtlsByNationalId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBydgfUsersAddrDtlsByNationalId",
			new String[] {Long.class.getName()}, new String[] {"nationalId"},
			true);

		_finderPathCountBydgfUsersAddrDtlsByNationalId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfUsersAddrDtlsByNationalId",
			new String[] {Long.class.getName()}, new String[] {"nationalId"},
			false);

		_finderPathWithPaginationFindBydgfUsersAddrDtlsByDistrict =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBydgfUsersAddrDtlsByDistrict",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"district"}, true);

		_finderPathWithoutPaginationFindBydgfUsersAddrDtlsByDistrict =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydgfUsersAddrDtlsByDistrict",
				new String[] {Long.class.getName()}, new String[] {"district"},
				true);

		_finderPathCountBydgfUsersAddrDtlsByDistrict = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfUsersAddrDtlsByDistrict",
			new String[] {Long.class.getName()}, new String[] {"district"},
			false);

		_finderPathWithPaginationFindBydgfUsersAddrDtlsByUpzilla =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBydgfUsersAddrDtlsByUpzilla",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"upzilla"}, true);

		_finderPathWithoutPaginationFindBydgfUsersAddrDtlsByUpzilla =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydgfUsersAddrDtlsByUpzilla",
				new String[] {Long.class.getName()}, new String[] {"upzilla"},
				true);

		_finderPathCountBydgfUsersAddrDtlsByUpzilla = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfUsersAddrDtlsByUpzilla",
			new String[] {Long.class.getName()}, new String[] {"upzilla"},
			false);

		_finderPathWithPaginationFindBydgfUsersAddrDtlsByUnion = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBydgfUsersAddrDtlsByUnion",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"unionName"}, true);

		_finderPathWithoutPaginationFindBydgfUsersAddrDtlsByUnion =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydgfUsersAddrDtlsByUnion",
				new String[] {Long.class.getName()}, new String[] {"unionName"},
				true);

		_finderPathCountBydgfUsersAddrDtlsByUnion = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfUsersAddrDtlsByUnion",
			new String[] {Long.class.getName()}, new String[] {"unionName"},
			false);

		_finderPathWithPaginationFindBydgfUsersAddrDtlsByWard = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBydgfUsersAddrDtlsByWard",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"ward"}, true);

		_finderPathWithoutPaginationFindBydgfUsersAddrDtlsByWard =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydgfUsersAddrDtlsByWard",
				new String[] {String.class.getName()}, new String[] {"ward"},
				true);

		_finderPathCountBydgfUsersAddrDtlsByWard = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfUsersAddrDtlsByWard",
			new String[] {String.class.getName()}, new String[] {"ward"},
			false);

		_finderPathWithPaginationFindByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"division", "district", "upzilla"}, true);

		_finderPathWithoutPaginationFindByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName()
				},
				new String[] {"division", "district", "upzilla"}, true);

		_finderPathCountByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName()
				},
				new String[] {"division", "district", "upzilla"}, false);

		_finderPathWithPaginationFindByDgfUsersAddrDtlsByDivisionAndDistrict =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByDgfUsersAddrDtlsByDivisionAndDistrict",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"division", "district"}, true);

		_finderPathWithoutPaginationFindByDgfUsersAddrDtlsByDivisionAndDistrict =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByDgfUsersAddrDtlsByDivisionAndDistrict",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"division", "district"}, true);

		_finderPathCountByDgfUsersAddrDtlsByDivisionAndDistrict =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByDgfUsersAddrDtlsByDivisionAndDistrict",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"division", "district"}, false);

		_setDgfUsersAddrDtlsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDgfUsersAddrDtlsUtilPersistence(null);

		entityCache.removeCache(DgfUsersAddrDtlsImpl.class.getName());
	}

	private void _setDgfUsersAddrDtlsUtilPersistence(
		DgfUsersAddrDtlsPersistence dgfUsersAddrDtlsPersistence) {

		try {
			Field field = DgfUsersAddrDtlsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dgfUsersAddrDtlsPersistence);
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

	private static final String _SQL_SELECT_DGFUSERSADDRDTLS =
		"SELECT dgfUsersAddrDtls FROM DgfUsersAddrDtls dgfUsersAddrDtls";

	private static final String _SQL_SELECT_DGFUSERSADDRDTLS_WHERE =
		"SELECT dgfUsersAddrDtls FROM DgfUsersAddrDtls dgfUsersAddrDtls WHERE ";

	private static final String _SQL_COUNT_DGFUSERSADDRDTLS =
		"SELECT COUNT(dgfUsersAddrDtls) FROM DgfUsersAddrDtls dgfUsersAddrDtls";

	private static final String _SQL_COUNT_DGFUSERSADDRDTLS_WHERE =
		"SELECT COUNT(dgfUsersAddrDtls) FROM DgfUsersAddrDtls dgfUsersAddrDtls WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dgfUsersAddrDtls.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DgfUsersAddrDtls exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DgfUsersAddrDtls exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DgfUsersAddrDtlsPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}