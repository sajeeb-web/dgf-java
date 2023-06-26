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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfBussAddrDtlsException;
import bd.gov.dgfood.food.grain.license.model.DgfBussAddrDtls;
import bd.gov.dgfood.food.grain.license.model.DgfBussAddrDtlsTable;
import bd.gov.dgfood.food.grain.license.model.impl.DgfBussAddrDtlsImpl;
import bd.gov.dgfood.food.grain.license.model.impl.DgfBussAddrDtlsModelImpl;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfBussAddrDtlsPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfBussAddrDtlsUtil;
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

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the dgf buss addr dtls service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DgfBussAddrDtlsPersistence.class)
public class DgfBussAddrDtlsPersistenceImpl
	extends BasePersistenceImpl<DgfBussAddrDtls>
	implements DgfBussAddrDtlsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DgfBussAddrDtlsUtil</code> to access the dgf buss addr dtls persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DgfBussAddrDtlsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath
		_finderPathWithPaginationFindBydgfBussAddrDtlsByBusinessDistrict;
	private FinderPath
		_finderPathWithoutPaginationFindBydgfBussAddrDtlsByBusinessDistrict;
	private FinderPath _finderPathCountBydgfBussAddrDtlsByBusinessDistrict;

	/**
	 * Returns all the dgf buss addr dtlses where businessDistrict = &#63;.
	 *
	 * @param businessDistrict the business district
	 * @return the matching dgf buss addr dtlses
	 */
	@Override
	public List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessDistrict(
		long businessDistrict) {

		return findBydgfBussAddrDtlsByBusinessDistrict(
			businessDistrict, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf buss addr dtlses where businessDistrict = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessDistrict the business district
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @return the range of matching dgf buss addr dtlses
	 */
	@Override
	public List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessDistrict(
		long businessDistrict, int start, int end) {

		return findBydgfBussAddrDtlsByBusinessDistrict(
			businessDistrict, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf buss addr dtlses where businessDistrict = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessDistrict the business district
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf buss addr dtlses
	 */
	@Override
	public List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessDistrict(
		long businessDistrict, int start, int end,
		OrderByComparator<DgfBussAddrDtls> orderByComparator) {

		return findBydgfBussAddrDtlsByBusinessDistrict(
			businessDistrict, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf buss addr dtlses where businessDistrict = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessDistrict the business district
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf buss addr dtlses
	 */
	@Override
	public List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessDistrict(
		long businessDistrict, int start, int end,
		OrderByComparator<DgfBussAddrDtls> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydgfBussAddrDtlsByBusinessDistrict;
				finderArgs = new Object[] {businessDistrict};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBydgfBussAddrDtlsByBusinessDistrict;
			finderArgs = new Object[] {
				businessDistrict, start, end, orderByComparator
			};
		}

		List<DgfBussAddrDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfBussAddrDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfBussAddrDtls dgfBussAddrDtls : list) {
					if (businessDistrict !=
							dgfBussAddrDtls.getBusinessDistrict()) {

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

			sb.append(_SQL_SELECT_DGFBUSSADDRDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFBUSSADDRDTLSBYBUSINESSDISTRICT_BUSINESSDISTRICT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfBussAddrDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessDistrict);

				list = (List<DgfBussAddrDtls>)QueryUtil.list(
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
	 * Returns the first dgf buss addr dtls in the ordered set where businessDistrict = &#63;.
	 *
	 * @param businessDistrict the business district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a matching dgf buss addr dtls could not be found
	 */
	@Override
	public DgfBussAddrDtls findBydgfBussAddrDtlsByBusinessDistrict_First(
			long businessDistrict,
			OrderByComparator<DgfBussAddrDtls> orderByComparator)
		throws NoSuchDgfBussAddrDtlsException {

		DgfBussAddrDtls dgfBussAddrDtls =
			fetchBydgfBussAddrDtlsByBusinessDistrict_First(
				businessDistrict, orderByComparator);

		if (dgfBussAddrDtls != null) {
			return dgfBussAddrDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessDistrict=");
		sb.append(businessDistrict);

		sb.append("}");

		throw new NoSuchDgfBussAddrDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf buss addr dtls in the ordered set where businessDistrict = &#63;.
	 *
	 * @param businessDistrict the business district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf buss addr dtls, or <code>null</code> if a matching dgf buss addr dtls could not be found
	 */
	@Override
	public DgfBussAddrDtls fetchBydgfBussAddrDtlsByBusinessDistrict_First(
		long businessDistrict,
		OrderByComparator<DgfBussAddrDtls> orderByComparator) {

		List<DgfBussAddrDtls> list = findBydgfBussAddrDtlsByBusinessDistrict(
			businessDistrict, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf buss addr dtls in the ordered set where businessDistrict = &#63;.
	 *
	 * @param businessDistrict the business district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a matching dgf buss addr dtls could not be found
	 */
	@Override
	public DgfBussAddrDtls findBydgfBussAddrDtlsByBusinessDistrict_Last(
			long businessDistrict,
			OrderByComparator<DgfBussAddrDtls> orderByComparator)
		throws NoSuchDgfBussAddrDtlsException {

		DgfBussAddrDtls dgfBussAddrDtls =
			fetchBydgfBussAddrDtlsByBusinessDistrict_Last(
				businessDistrict, orderByComparator);

		if (dgfBussAddrDtls != null) {
			return dgfBussAddrDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessDistrict=");
		sb.append(businessDistrict);

		sb.append("}");

		throw new NoSuchDgfBussAddrDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf buss addr dtls in the ordered set where businessDistrict = &#63;.
	 *
	 * @param businessDistrict the business district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf buss addr dtls, or <code>null</code> if a matching dgf buss addr dtls could not be found
	 */
	@Override
	public DgfBussAddrDtls fetchBydgfBussAddrDtlsByBusinessDistrict_Last(
		long businessDistrict,
		OrderByComparator<DgfBussAddrDtls> orderByComparator) {

		int count = countBydgfBussAddrDtlsByBusinessDistrict(businessDistrict);

		if (count == 0) {
			return null;
		}

		List<DgfBussAddrDtls> list = findBydgfBussAddrDtlsByBusinessDistrict(
			businessDistrict, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf buss addr dtlses before and after the current dgf buss addr dtls in the ordered set where businessDistrict = &#63;.
	 *
	 * @param businessAddressId the primary key of the current dgf buss addr dtls
	 * @param businessDistrict the business district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a dgf buss addr dtls with the primary key could not be found
	 */
	@Override
	public DgfBussAddrDtls[]
			findBydgfBussAddrDtlsByBusinessDistrict_PrevAndNext(
				long businessAddressId, long businessDistrict,
				OrderByComparator<DgfBussAddrDtls> orderByComparator)
		throws NoSuchDgfBussAddrDtlsException {

		DgfBussAddrDtls dgfBussAddrDtls = findByPrimaryKey(businessAddressId);

		Session session = null;

		try {
			session = openSession();

			DgfBussAddrDtls[] array = new DgfBussAddrDtlsImpl[3];

			array[0] = getBydgfBussAddrDtlsByBusinessDistrict_PrevAndNext(
				session, dgfBussAddrDtls, businessDistrict, orderByComparator,
				true);

			array[1] = dgfBussAddrDtls;

			array[2] = getBydgfBussAddrDtlsByBusinessDistrict_PrevAndNext(
				session, dgfBussAddrDtls, businessDistrict, orderByComparator,
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

	protected DgfBussAddrDtls
		getBydgfBussAddrDtlsByBusinessDistrict_PrevAndNext(
			Session session, DgfBussAddrDtls dgfBussAddrDtls,
			long businessDistrict,
			OrderByComparator<DgfBussAddrDtls> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFBUSSADDRDTLS_WHERE);

		sb.append(
			_FINDER_COLUMN_DGFBUSSADDRDTLSBYBUSINESSDISTRICT_BUSINESSDISTRICT_2);

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
			sb.append(DgfBussAddrDtlsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(businessDistrict);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfBussAddrDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfBussAddrDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf buss addr dtlses where businessDistrict = &#63; from the database.
	 *
	 * @param businessDistrict the business district
	 */
	@Override
	public void removeBydgfBussAddrDtlsByBusinessDistrict(
		long businessDistrict) {

		for (DgfBussAddrDtls dgfBussAddrDtls :
				findBydgfBussAddrDtlsByBusinessDistrict(
					businessDistrict, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgfBussAddrDtls);
		}
	}

	/**
	 * Returns the number of dgf buss addr dtlses where businessDistrict = &#63;.
	 *
	 * @param businessDistrict the business district
	 * @return the number of matching dgf buss addr dtlses
	 */
	@Override
	public int countBydgfBussAddrDtlsByBusinessDistrict(long businessDistrict) {
		FinderPath finderPath =
			_finderPathCountBydgfBussAddrDtlsByBusinessDistrict;

		Object[] finderArgs = new Object[] {businessDistrict};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFBUSSADDRDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFBUSSADDRDTLSBYBUSINESSDISTRICT_BUSINESSDISTRICT_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessDistrict);

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
		_FINDER_COLUMN_DGFBUSSADDRDTLSBYBUSINESSDISTRICT_BUSINESSDISTRICT_2 =
			"dgfBussAddrDtls.businessDistrict = ?";

	private FinderPath
		_finderPathWithPaginationFindBydgfBussAddrDtlsByBusinessUpzilla;
	private FinderPath
		_finderPathWithoutPaginationFindBydgfBussAddrDtlsByBusinessUpzilla;
	private FinderPath _finderPathCountBydgfBussAddrDtlsByBusinessUpzilla;

	/**
	 * Returns all the dgf buss addr dtlses where businessUpzilla = &#63;.
	 *
	 * @param businessUpzilla the business upzilla
	 * @return the matching dgf buss addr dtlses
	 */
	@Override
	public List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessUpzilla(
		long businessUpzilla) {

		return findBydgfBussAddrDtlsByBusinessUpzilla(
			businessUpzilla, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf buss addr dtlses where businessUpzilla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessUpzilla the business upzilla
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @return the range of matching dgf buss addr dtlses
	 */
	@Override
	public List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessUpzilla(
		long businessUpzilla, int start, int end) {

		return findBydgfBussAddrDtlsByBusinessUpzilla(
			businessUpzilla, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf buss addr dtlses where businessUpzilla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessUpzilla the business upzilla
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf buss addr dtlses
	 */
	@Override
	public List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessUpzilla(
		long businessUpzilla, int start, int end,
		OrderByComparator<DgfBussAddrDtls> orderByComparator) {

		return findBydgfBussAddrDtlsByBusinessUpzilla(
			businessUpzilla, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf buss addr dtlses where businessUpzilla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessUpzilla the business upzilla
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf buss addr dtlses
	 */
	@Override
	public List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessUpzilla(
		long businessUpzilla, int start, int end,
		OrderByComparator<DgfBussAddrDtls> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydgfBussAddrDtlsByBusinessUpzilla;
				finderArgs = new Object[] {businessUpzilla};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBydgfBussAddrDtlsByBusinessUpzilla;
			finderArgs = new Object[] {
				businessUpzilla, start, end, orderByComparator
			};
		}

		List<DgfBussAddrDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfBussAddrDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfBussAddrDtls dgfBussAddrDtls : list) {
					if (businessUpzilla !=
							dgfBussAddrDtls.getBusinessUpzilla()) {

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

			sb.append(_SQL_SELECT_DGFBUSSADDRDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFBUSSADDRDTLSBYBUSINESSUPZILLA_BUSINESSUPZILLA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfBussAddrDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessUpzilla);

				list = (List<DgfBussAddrDtls>)QueryUtil.list(
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
	 * Returns the first dgf buss addr dtls in the ordered set where businessUpzilla = &#63;.
	 *
	 * @param businessUpzilla the business upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a matching dgf buss addr dtls could not be found
	 */
	@Override
	public DgfBussAddrDtls findBydgfBussAddrDtlsByBusinessUpzilla_First(
			long businessUpzilla,
			OrderByComparator<DgfBussAddrDtls> orderByComparator)
		throws NoSuchDgfBussAddrDtlsException {

		DgfBussAddrDtls dgfBussAddrDtls =
			fetchBydgfBussAddrDtlsByBusinessUpzilla_First(
				businessUpzilla, orderByComparator);

		if (dgfBussAddrDtls != null) {
			return dgfBussAddrDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessUpzilla=");
		sb.append(businessUpzilla);

		sb.append("}");

		throw new NoSuchDgfBussAddrDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf buss addr dtls in the ordered set where businessUpzilla = &#63;.
	 *
	 * @param businessUpzilla the business upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf buss addr dtls, or <code>null</code> if a matching dgf buss addr dtls could not be found
	 */
	@Override
	public DgfBussAddrDtls fetchBydgfBussAddrDtlsByBusinessUpzilla_First(
		long businessUpzilla,
		OrderByComparator<DgfBussAddrDtls> orderByComparator) {

		List<DgfBussAddrDtls> list = findBydgfBussAddrDtlsByBusinessUpzilla(
			businessUpzilla, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf buss addr dtls in the ordered set where businessUpzilla = &#63;.
	 *
	 * @param businessUpzilla the business upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a matching dgf buss addr dtls could not be found
	 */
	@Override
	public DgfBussAddrDtls findBydgfBussAddrDtlsByBusinessUpzilla_Last(
			long businessUpzilla,
			OrderByComparator<DgfBussAddrDtls> orderByComparator)
		throws NoSuchDgfBussAddrDtlsException {

		DgfBussAddrDtls dgfBussAddrDtls =
			fetchBydgfBussAddrDtlsByBusinessUpzilla_Last(
				businessUpzilla, orderByComparator);

		if (dgfBussAddrDtls != null) {
			return dgfBussAddrDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessUpzilla=");
		sb.append(businessUpzilla);

		sb.append("}");

		throw new NoSuchDgfBussAddrDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf buss addr dtls in the ordered set where businessUpzilla = &#63;.
	 *
	 * @param businessUpzilla the business upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf buss addr dtls, or <code>null</code> if a matching dgf buss addr dtls could not be found
	 */
	@Override
	public DgfBussAddrDtls fetchBydgfBussAddrDtlsByBusinessUpzilla_Last(
		long businessUpzilla,
		OrderByComparator<DgfBussAddrDtls> orderByComparator) {

		int count = countBydgfBussAddrDtlsByBusinessUpzilla(businessUpzilla);

		if (count == 0) {
			return null;
		}

		List<DgfBussAddrDtls> list = findBydgfBussAddrDtlsByBusinessUpzilla(
			businessUpzilla, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf buss addr dtlses before and after the current dgf buss addr dtls in the ordered set where businessUpzilla = &#63;.
	 *
	 * @param businessAddressId the primary key of the current dgf buss addr dtls
	 * @param businessUpzilla the business upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a dgf buss addr dtls with the primary key could not be found
	 */
	@Override
	public DgfBussAddrDtls[] findBydgfBussAddrDtlsByBusinessUpzilla_PrevAndNext(
			long businessAddressId, long businessUpzilla,
			OrderByComparator<DgfBussAddrDtls> orderByComparator)
		throws NoSuchDgfBussAddrDtlsException {

		DgfBussAddrDtls dgfBussAddrDtls = findByPrimaryKey(businessAddressId);

		Session session = null;

		try {
			session = openSession();

			DgfBussAddrDtls[] array = new DgfBussAddrDtlsImpl[3];

			array[0] = getBydgfBussAddrDtlsByBusinessUpzilla_PrevAndNext(
				session, dgfBussAddrDtls, businessUpzilla, orderByComparator,
				true);

			array[1] = dgfBussAddrDtls;

			array[2] = getBydgfBussAddrDtlsByBusinessUpzilla_PrevAndNext(
				session, dgfBussAddrDtls, businessUpzilla, orderByComparator,
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

	protected DgfBussAddrDtls getBydgfBussAddrDtlsByBusinessUpzilla_PrevAndNext(
		Session session, DgfBussAddrDtls dgfBussAddrDtls, long businessUpzilla,
		OrderByComparator<DgfBussAddrDtls> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFBUSSADDRDTLS_WHERE);

		sb.append(
			_FINDER_COLUMN_DGFBUSSADDRDTLSBYBUSINESSUPZILLA_BUSINESSUPZILLA_2);

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
			sb.append(DgfBussAddrDtlsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(businessUpzilla);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfBussAddrDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfBussAddrDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf buss addr dtlses where businessUpzilla = &#63; from the database.
	 *
	 * @param businessUpzilla the business upzilla
	 */
	@Override
	public void removeBydgfBussAddrDtlsByBusinessUpzilla(long businessUpzilla) {
		for (DgfBussAddrDtls dgfBussAddrDtls :
				findBydgfBussAddrDtlsByBusinessUpzilla(
					businessUpzilla, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgfBussAddrDtls);
		}
	}

	/**
	 * Returns the number of dgf buss addr dtlses where businessUpzilla = &#63;.
	 *
	 * @param businessUpzilla the business upzilla
	 * @return the number of matching dgf buss addr dtlses
	 */
	@Override
	public int countBydgfBussAddrDtlsByBusinessUpzilla(long businessUpzilla) {
		FinderPath finderPath =
			_finderPathCountBydgfBussAddrDtlsByBusinessUpzilla;

		Object[] finderArgs = new Object[] {businessUpzilla};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFBUSSADDRDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFBUSSADDRDTLSBYBUSINESSUPZILLA_BUSINESSUPZILLA_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessUpzilla);

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
		_FINDER_COLUMN_DGFBUSSADDRDTLSBYBUSINESSUPZILLA_BUSINESSUPZILLA_2 =
			"dgfBussAddrDtls.businessUpzilla = ?";

	private FinderPath
		_finderPathWithPaginationFindBydgfBussAddrDtlsByBusinessUnionName;
	private FinderPath
		_finderPathWithoutPaginationFindBydgfBussAddrDtlsByBusinessUnionName;
	private FinderPath _finderPathCountBydgfBussAddrDtlsByBusinessUnionName;

	/**
	 * Returns all the dgf buss addr dtlses where businessUnionName = &#63;.
	 *
	 * @param businessUnionName the business union name
	 * @return the matching dgf buss addr dtlses
	 */
	@Override
	public List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessUnionName(
		long businessUnionName) {

		return findBydgfBussAddrDtlsByBusinessUnionName(
			businessUnionName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf buss addr dtlses where businessUnionName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessUnionName the business union name
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @return the range of matching dgf buss addr dtlses
	 */
	@Override
	public List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessUnionName(
		long businessUnionName, int start, int end) {

		return findBydgfBussAddrDtlsByBusinessUnionName(
			businessUnionName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf buss addr dtlses where businessUnionName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessUnionName the business union name
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf buss addr dtlses
	 */
	@Override
	public List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessUnionName(
		long businessUnionName, int start, int end,
		OrderByComparator<DgfBussAddrDtls> orderByComparator) {

		return findBydgfBussAddrDtlsByBusinessUnionName(
			businessUnionName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf buss addr dtlses where businessUnionName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessUnionName the business union name
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf buss addr dtlses
	 */
	@Override
	public List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessUnionName(
		long businessUnionName, int start, int end,
		OrderByComparator<DgfBussAddrDtls> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydgfBussAddrDtlsByBusinessUnionName;
				finderArgs = new Object[] {businessUnionName};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBydgfBussAddrDtlsByBusinessUnionName;
			finderArgs = new Object[] {
				businessUnionName, start, end, orderByComparator
			};
		}

		List<DgfBussAddrDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfBussAddrDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfBussAddrDtls dgfBussAddrDtls : list) {
					if (businessUnionName !=
							dgfBussAddrDtls.getBusinessUnionName()) {

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

			sb.append(_SQL_SELECT_DGFBUSSADDRDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFBUSSADDRDTLSBYBUSINESSUNIONNAME_BUSINESSUNIONNAME_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfBussAddrDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessUnionName);

				list = (List<DgfBussAddrDtls>)QueryUtil.list(
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
	 * Returns the first dgf buss addr dtls in the ordered set where businessUnionName = &#63;.
	 *
	 * @param businessUnionName the business union name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a matching dgf buss addr dtls could not be found
	 */
	@Override
	public DgfBussAddrDtls findBydgfBussAddrDtlsByBusinessUnionName_First(
			long businessUnionName,
			OrderByComparator<DgfBussAddrDtls> orderByComparator)
		throws NoSuchDgfBussAddrDtlsException {

		DgfBussAddrDtls dgfBussAddrDtls =
			fetchBydgfBussAddrDtlsByBusinessUnionName_First(
				businessUnionName, orderByComparator);

		if (dgfBussAddrDtls != null) {
			return dgfBussAddrDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessUnionName=");
		sb.append(businessUnionName);

		sb.append("}");

		throw new NoSuchDgfBussAddrDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf buss addr dtls in the ordered set where businessUnionName = &#63;.
	 *
	 * @param businessUnionName the business union name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf buss addr dtls, or <code>null</code> if a matching dgf buss addr dtls could not be found
	 */
	@Override
	public DgfBussAddrDtls fetchBydgfBussAddrDtlsByBusinessUnionName_First(
		long businessUnionName,
		OrderByComparator<DgfBussAddrDtls> orderByComparator) {

		List<DgfBussAddrDtls> list = findBydgfBussAddrDtlsByBusinessUnionName(
			businessUnionName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf buss addr dtls in the ordered set where businessUnionName = &#63;.
	 *
	 * @param businessUnionName the business union name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a matching dgf buss addr dtls could not be found
	 */
	@Override
	public DgfBussAddrDtls findBydgfBussAddrDtlsByBusinessUnionName_Last(
			long businessUnionName,
			OrderByComparator<DgfBussAddrDtls> orderByComparator)
		throws NoSuchDgfBussAddrDtlsException {

		DgfBussAddrDtls dgfBussAddrDtls =
			fetchBydgfBussAddrDtlsByBusinessUnionName_Last(
				businessUnionName, orderByComparator);

		if (dgfBussAddrDtls != null) {
			return dgfBussAddrDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessUnionName=");
		sb.append(businessUnionName);

		sb.append("}");

		throw new NoSuchDgfBussAddrDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf buss addr dtls in the ordered set where businessUnionName = &#63;.
	 *
	 * @param businessUnionName the business union name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf buss addr dtls, or <code>null</code> if a matching dgf buss addr dtls could not be found
	 */
	@Override
	public DgfBussAddrDtls fetchBydgfBussAddrDtlsByBusinessUnionName_Last(
		long businessUnionName,
		OrderByComparator<DgfBussAddrDtls> orderByComparator) {

		int count = countBydgfBussAddrDtlsByBusinessUnionName(
			businessUnionName);

		if (count == 0) {
			return null;
		}

		List<DgfBussAddrDtls> list = findBydgfBussAddrDtlsByBusinessUnionName(
			businessUnionName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf buss addr dtlses before and after the current dgf buss addr dtls in the ordered set where businessUnionName = &#63;.
	 *
	 * @param businessAddressId the primary key of the current dgf buss addr dtls
	 * @param businessUnionName the business union name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a dgf buss addr dtls with the primary key could not be found
	 */
	@Override
	public DgfBussAddrDtls[]
			findBydgfBussAddrDtlsByBusinessUnionName_PrevAndNext(
				long businessAddressId, long businessUnionName,
				OrderByComparator<DgfBussAddrDtls> orderByComparator)
		throws NoSuchDgfBussAddrDtlsException {

		DgfBussAddrDtls dgfBussAddrDtls = findByPrimaryKey(businessAddressId);

		Session session = null;

		try {
			session = openSession();

			DgfBussAddrDtls[] array = new DgfBussAddrDtlsImpl[3];

			array[0] = getBydgfBussAddrDtlsByBusinessUnionName_PrevAndNext(
				session, dgfBussAddrDtls, businessUnionName, orderByComparator,
				true);

			array[1] = dgfBussAddrDtls;

			array[2] = getBydgfBussAddrDtlsByBusinessUnionName_PrevAndNext(
				session, dgfBussAddrDtls, businessUnionName, orderByComparator,
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

	protected DgfBussAddrDtls
		getBydgfBussAddrDtlsByBusinessUnionName_PrevAndNext(
			Session session, DgfBussAddrDtls dgfBussAddrDtls,
			long businessUnionName,
			OrderByComparator<DgfBussAddrDtls> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFBUSSADDRDTLS_WHERE);

		sb.append(
			_FINDER_COLUMN_DGFBUSSADDRDTLSBYBUSINESSUNIONNAME_BUSINESSUNIONNAME_2);

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
			sb.append(DgfBussAddrDtlsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(businessUnionName);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfBussAddrDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfBussAddrDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf buss addr dtlses where businessUnionName = &#63; from the database.
	 *
	 * @param businessUnionName the business union name
	 */
	@Override
	public void removeBydgfBussAddrDtlsByBusinessUnionName(
		long businessUnionName) {

		for (DgfBussAddrDtls dgfBussAddrDtls :
				findBydgfBussAddrDtlsByBusinessUnionName(
					businessUnionName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgfBussAddrDtls);
		}
	}

	/**
	 * Returns the number of dgf buss addr dtlses where businessUnionName = &#63;.
	 *
	 * @param businessUnionName the business union name
	 * @return the number of matching dgf buss addr dtlses
	 */
	@Override
	public int countBydgfBussAddrDtlsByBusinessUnionName(
		long businessUnionName) {

		FinderPath finderPath =
			_finderPathCountBydgfBussAddrDtlsByBusinessUnionName;

		Object[] finderArgs = new Object[] {businessUnionName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFBUSSADDRDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFBUSSADDRDTLSBYBUSINESSUNIONNAME_BUSINESSUNIONNAME_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(businessUnionName);

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
		_FINDER_COLUMN_DGFBUSSADDRDTLSBYBUSINESSUNIONNAME_BUSINESSUNIONNAME_2 =
			"dgfBussAddrDtls.businessUnionName = ?";

	private FinderPath
		_finderPathWithPaginationFindBydgfBussAddrDtlsByBusinessWard;
	private FinderPath
		_finderPathWithoutPaginationFindBydgfBussAddrDtlsByBusinessWard;
	private FinderPath _finderPathCountBydgfBussAddrDtlsByBusinessWard;

	/**
	 * Returns all the dgf buss addr dtlses where businessWard = &#63;.
	 *
	 * @param businessWard the business ward
	 * @return the matching dgf buss addr dtlses
	 */
	@Override
	public List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessWard(
		String businessWard) {

		return findBydgfBussAddrDtlsByBusinessWard(
			businessWard, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf buss addr dtlses where businessWard = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessWard the business ward
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @return the range of matching dgf buss addr dtlses
	 */
	@Override
	public List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessWard(
		String businessWard, int start, int end) {

		return findBydgfBussAddrDtlsByBusinessWard(
			businessWard, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf buss addr dtlses where businessWard = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessWard the business ward
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf buss addr dtlses
	 */
	@Override
	public List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessWard(
		String businessWard, int start, int end,
		OrderByComparator<DgfBussAddrDtls> orderByComparator) {

		return findBydgfBussAddrDtlsByBusinessWard(
			businessWard, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf buss addr dtlses where businessWard = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param businessWard the business ward
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf buss addr dtlses
	 */
	@Override
	public List<DgfBussAddrDtls> findBydgfBussAddrDtlsByBusinessWard(
		String businessWard, int start, int end,
		OrderByComparator<DgfBussAddrDtls> orderByComparator,
		boolean useFinderCache) {

		businessWard = Objects.toString(businessWard, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydgfBussAddrDtlsByBusinessWard;
				finderArgs = new Object[] {businessWard};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBydgfBussAddrDtlsByBusinessWard;
			finderArgs = new Object[] {
				businessWard, start, end, orderByComparator
			};
		}

		List<DgfBussAddrDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfBussAddrDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfBussAddrDtls dgfBussAddrDtls : list) {
					if (!businessWard.equals(
							dgfBussAddrDtls.getBusinessWard())) {

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

			sb.append(_SQL_SELECT_DGFBUSSADDRDTLS_WHERE);

			boolean bindBusinessWard = false;

			if (businessWard.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DGFBUSSADDRDTLSBYBUSINESSWARD_BUSINESSWARD_3);
			}
			else {
				bindBusinessWard = true;

				sb.append(
					_FINDER_COLUMN_DGFBUSSADDRDTLSBYBUSINESSWARD_BUSINESSWARD_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfBussAddrDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindBusinessWard) {
					queryPos.add(businessWard);
				}

				list = (List<DgfBussAddrDtls>)QueryUtil.list(
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
	 * Returns the first dgf buss addr dtls in the ordered set where businessWard = &#63;.
	 *
	 * @param businessWard the business ward
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a matching dgf buss addr dtls could not be found
	 */
	@Override
	public DgfBussAddrDtls findBydgfBussAddrDtlsByBusinessWard_First(
			String businessWard,
			OrderByComparator<DgfBussAddrDtls> orderByComparator)
		throws NoSuchDgfBussAddrDtlsException {

		DgfBussAddrDtls dgfBussAddrDtls =
			fetchBydgfBussAddrDtlsByBusinessWard_First(
				businessWard, orderByComparator);

		if (dgfBussAddrDtls != null) {
			return dgfBussAddrDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessWard=");
		sb.append(businessWard);

		sb.append("}");

		throw new NoSuchDgfBussAddrDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf buss addr dtls in the ordered set where businessWard = &#63;.
	 *
	 * @param businessWard the business ward
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf buss addr dtls, or <code>null</code> if a matching dgf buss addr dtls could not be found
	 */
	@Override
	public DgfBussAddrDtls fetchBydgfBussAddrDtlsByBusinessWard_First(
		String businessWard,
		OrderByComparator<DgfBussAddrDtls> orderByComparator) {

		List<DgfBussAddrDtls> list = findBydgfBussAddrDtlsByBusinessWard(
			businessWard, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf buss addr dtls in the ordered set where businessWard = &#63;.
	 *
	 * @param businessWard the business ward
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a matching dgf buss addr dtls could not be found
	 */
	@Override
	public DgfBussAddrDtls findBydgfBussAddrDtlsByBusinessWard_Last(
			String businessWard,
			OrderByComparator<DgfBussAddrDtls> orderByComparator)
		throws NoSuchDgfBussAddrDtlsException {

		DgfBussAddrDtls dgfBussAddrDtls =
			fetchBydgfBussAddrDtlsByBusinessWard_Last(
				businessWard, orderByComparator);

		if (dgfBussAddrDtls != null) {
			return dgfBussAddrDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("businessWard=");
		sb.append(businessWard);

		sb.append("}");

		throw new NoSuchDgfBussAddrDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf buss addr dtls in the ordered set where businessWard = &#63;.
	 *
	 * @param businessWard the business ward
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf buss addr dtls, or <code>null</code> if a matching dgf buss addr dtls could not be found
	 */
	@Override
	public DgfBussAddrDtls fetchBydgfBussAddrDtlsByBusinessWard_Last(
		String businessWard,
		OrderByComparator<DgfBussAddrDtls> orderByComparator) {

		int count = countBydgfBussAddrDtlsByBusinessWard(businessWard);

		if (count == 0) {
			return null;
		}

		List<DgfBussAddrDtls> list = findBydgfBussAddrDtlsByBusinessWard(
			businessWard, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf buss addr dtlses before and after the current dgf buss addr dtls in the ordered set where businessWard = &#63;.
	 *
	 * @param businessAddressId the primary key of the current dgf buss addr dtls
	 * @param businessWard the business ward
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a dgf buss addr dtls with the primary key could not be found
	 */
	@Override
	public DgfBussAddrDtls[] findBydgfBussAddrDtlsByBusinessWard_PrevAndNext(
			long businessAddressId, String businessWard,
			OrderByComparator<DgfBussAddrDtls> orderByComparator)
		throws NoSuchDgfBussAddrDtlsException {

		businessWard = Objects.toString(businessWard, "");

		DgfBussAddrDtls dgfBussAddrDtls = findByPrimaryKey(businessAddressId);

		Session session = null;

		try {
			session = openSession();

			DgfBussAddrDtls[] array = new DgfBussAddrDtlsImpl[3];

			array[0] = getBydgfBussAddrDtlsByBusinessWard_PrevAndNext(
				session, dgfBussAddrDtls, businessWard, orderByComparator,
				true);

			array[1] = dgfBussAddrDtls;

			array[2] = getBydgfBussAddrDtlsByBusinessWard_PrevAndNext(
				session, dgfBussAddrDtls, businessWard, orderByComparator,
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

	protected DgfBussAddrDtls getBydgfBussAddrDtlsByBusinessWard_PrevAndNext(
		Session session, DgfBussAddrDtls dgfBussAddrDtls, String businessWard,
		OrderByComparator<DgfBussAddrDtls> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFBUSSADDRDTLS_WHERE);

		boolean bindBusinessWard = false;

		if (businessWard.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_DGFBUSSADDRDTLSBYBUSINESSWARD_BUSINESSWARD_3);
		}
		else {
			bindBusinessWard = true;

			sb.append(
				_FINDER_COLUMN_DGFBUSSADDRDTLSBYBUSINESSWARD_BUSINESSWARD_2);
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
			sb.append(DgfBussAddrDtlsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindBusinessWard) {
			queryPos.add(businessWard);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfBussAddrDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfBussAddrDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf buss addr dtlses where businessWard = &#63; from the database.
	 *
	 * @param businessWard the business ward
	 */
	@Override
	public void removeBydgfBussAddrDtlsByBusinessWard(String businessWard) {
		for (DgfBussAddrDtls dgfBussAddrDtls :
				findBydgfBussAddrDtlsByBusinessWard(
					businessWard, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgfBussAddrDtls);
		}
	}

	/**
	 * Returns the number of dgf buss addr dtlses where businessWard = &#63;.
	 *
	 * @param businessWard the business ward
	 * @return the number of matching dgf buss addr dtlses
	 */
	@Override
	public int countBydgfBussAddrDtlsByBusinessWard(String businessWard) {
		businessWard = Objects.toString(businessWard, "");

		FinderPath finderPath = _finderPathCountBydgfBussAddrDtlsByBusinessWard;

		Object[] finderArgs = new Object[] {businessWard};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFBUSSADDRDTLS_WHERE);

			boolean bindBusinessWard = false;

			if (businessWard.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DGFBUSSADDRDTLSBYBUSINESSWARD_BUSINESSWARD_3);
			}
			else {
				bindBusinessWard = true;

				sb.append(
					_FINDER_COLUMN_DGFBUSSADDRDTLSBYBUSINESSWARD_BUSINESSWARD_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindBusinessWard) {
					queryPos.add(businessWard);
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
		_FINDER_COLUMN_DGFBUSSADDRDTLSBYBUSINESSWARD_BUSINESSWARD_2 =
			"dgfBussAddrDtls.businessWard = ?";

	private static final String
		_FINDER_COLUMN_DGFBUSSADDRDTLSBYBUSINESSWARD_BUSINESSWARD_3 =
			"(dgfBussAddrDtls.businessWard IS NULL OR dgfBussAddrDtls.businessWard = '')";

	public DgfBussAddrDtlsPersistenceImpl() {
		setModelClass(DgfBussAddrDtls.class);

		setModelImplClass(DgfBussAddrDtlsImpl.class);
		setModelPKClass(long.class);

		setTable(DgfBussAddrDtlsTable.INSTANCE);
	}

	/**
	 * Caches the dgf buss addr dtls in the entity cache if it is enabled.
	 *
	 * @param dgfBussAddrDtls the dgf buss addr dtls
	 */
	@Override
	public void cacheResult(DgfBussAddrDtls dgfBussAddrDtls) {
		entityCache.putResult(
			DgfBussAddrDtlsImpl.class, dgfBussAddrDtls.getPrimaryKey(),
			dgfBussAddrDtls);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dgf buss addr dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfBussAddrDtlses the dgf buss addr dtlses
	 */
	@Override
	public void cacheResult(List<DgfBussAddrDtls> dgfBussAddrDtlses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgfBussAddrDtlses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DgfBussAddrDtls dgfBussAddrDtls : dgfBussAddrDtlses) {
			if (entityCache.getResult(
					DgfBussAddrDtlsImpl.class,
					dgfBussAddrDtls.getPrimaryKey()) == null) {

				cacheResult(dgfBussAddrDtls);
			}
		}
	}

	/**
	 * Clears the cache for all dgf buss addr dtlses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DgfBussAddrDtlsImpl.class);

		finderCache.clearCache(DgfBussAddrDtlsImpl.class);
	}

	/**
	 * Clears the cache for the dgf buss addr dtls.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DgfBussAddrDtls dgfBussAddrDtls) {
		entityCache.removeResult(DgfBussAddrDtlsImpl.class, dgfBussAddrDtls);
	}

	@Override
	public void clearCache(List<DgfBussAddrDtls> dgfBussAddrDtlses) {
		for (DgfBussAddrDtls dgfBussAddrDtls : dgfBussAddrDtlses) {
			entityCache.removeResult(
				DgfBussAddrDtlsImpl.class, dgfBussAddrDtls);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DgfBussAddrDtlsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DgfBussAddrDtlsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new dgf buss addr dtls with the primary key. Does not add the dgf buss addr dtls to the database.
	 *
	 * @param businessAddressId the primary key for the new dgf buss addr dtls
	 * @return the new dgf buss addr dtls
	 */
	@Override
	public DgfBussAddrDtls create(long businessAddressId) {
		DgfBussAddrDtls dgfBussAddrDtls = new DgfBussAddrDtlsImpl();

		dgfBussAddrDtls.setNew(true);
		dgfBussAddrDtls.setPrimaryKey(businessAddressId);

		return dgfBussAddrDtls;
	}

	/**
	 * Removes the dgf buss addr dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param businessAddressId the primary key of the dgf buss addr dtls
	 * @return the dgf buss addr dtls that was removed
	 * @throws NoSuchDgfBussAddrDtlsException if a dgf buss addr dtls with the primary key could not be found
	 */
	@Override
	public DgfBussAddrDtls remove(long businessAddressId)
		throws NoSuchDgfBussAddrDtlsException {

		return remove((Serializable)businessAddressId);
	}

	/**
	 * Removes the dgf buss addr dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dgf buss addr dtls
	 * @return the dgf buss addr dtls that was removed
	 * @throws NoSuchDgfBussAddrDtlsException if a dgf buss addr dtls with the primary key could not be found
	 */
	@Override
	public DgfBussAddrDtls remove(Serializable primaryKey)
		throws NoSuchDgfBussAddrDtlsException {

		Session session = null;

		try {
			session = openSession();

			DgfBussAddrDtls dgfBussAddrDtls = (DgfBussAddrDtls)session.get(
				DgfBussAddrDtlsImpl.class, primaryKey);

			if (dgfBussAddrDtls == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDgfBussAddrDtlsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgfBussAddrDtls);
		}
		catch (NoSuchDgfBussAddrDtlsException noSuchEntityException) {
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
	protected DgfBussAddrDtls removeImpl(DgfBussAddrDtls dgfBussAddrDtls) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgfBussAddrDtls)) {
				dgfBussAddrDtls = (DgfBussAddrDtls)session.get(
					DgfBussAddrDtlsImpl.class,
					dgfBussAddrDtls.getPrimaryKeyObj());
			}

			if (dgfBussAddrDtls != null) {
				session.delete(dgfBussAddrDtls);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgfBussAddrDtls != null) {
			clearCache(dgfBussAddrDtls);
		}

		return dgfBussAddrDtls;
	}

	@Override
	public DgfBussAddrDtls updateImpl(DgfBussAddrDtls dgfBussAddrDtls) {
		boolean isNew = dgfBussAddrDtls.isNew();

		if (!(dgfBussAddrDtls instanceof DgfBussAddrDtlsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dgfBussAddrDtls.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dgfBussAddrDtls);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgfBussAddrDtls proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DgfBussAddrDtls implementation " +
					dgfBussAddrDtls.getClass());
		}

		DgfBussAddrDtlsModelImpl dgfBussAddrDtlsModelImpl =
			(DgfBussAddrDtlsModelImpl)dgfBussAddrDtls;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgfBussAddrDtls);
			}
			else {
				dgfBussAddrDtls = (DgfBussAddrDtls)session.merge(
					dgfBussAddrDtls);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DgfBussAddrDtlsImpl.class, dgfBussAddrDtlsModelImpl, false, true);

		if (isNew) {
			dgfBussAddrDtls.setNew(false);
		}

		dgfBussAddrDtls.resetOriginalValues();

		return dgfBussAddrDtls;
	}

	/**
	 * Returns the dgf buss addr dtls with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dgf buss addr dtls
	 * @return the dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a dgf buss addr dtls with the primary key could not be found
	 */
	@Override
	public DgfBussAddrDtls findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDgfBussAddrDtlsException {

		DgfBussAddrDtls dgfBussAddrDtls = fetchByPrimaryKey(primaryKey);

		if (dgfBussAddrDtls == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDgfBussAddrDtlsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgfBussAddrDtls;
	}

	/**
	 * Returns the dgf buss addr dtls with the primary key or throws a <code>NoSuchDgfBussAddrDtlsException</code> if it could not be found.
	 *
	 * @param businessAddressId the primary key of the dgf buss addr dtls
	 * @return the dgf buss addr dtls
	 * @throws NoSuchDgfBussAddrDtlsException if a dgf buss addr dtls with the primary key could not be found
	 */
	@Override
	public DgfBussAddrDtls findByPrimaryKey(long businessAddressId)
		throws NoSuchDgfBussAddrDtlsException {

		return findByPrimaryKey((Serializable)businessAddressId);
	}

	/**
	 * Returns the dgf buss addr dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param businessAddressId the primary key of the dgf buss addr dtls
	 * @return the dgf buss addr dtls, or <code>null</code> if a dgf buss addr dtls with the primary key could not be found
	 */
	@Override
	public DgfBussAddrDtls fetchByPrimaryKey(long businessAddressId) {
		return fetchByPrimaryKey((Serializable)businessAddressId);
	}

	/**
	 * Returns all the dgf buss addr dtlses.
	 *
	 * @return the dgf buss addr dtlses
	 */
	@Override
	public List<DgfBussAddrDtls> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf buss addr dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @return the range of dgf buss addr dtlses
	 */
	@Override
	public List<DgfBussAddrDtls> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf buss addr dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf buss addr dtlses
	 */
	@Override
	public List<DgfBussAddrDtls> findAll(
		int start, int end,
		OrderByComparator<DgfBussAddrDtls> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf buss addr dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf buss addr dtlses
	 */
	@Override
	public List<DgfBussAddrDtls> findAll(
		int start, int end,
		OrderByComparator<DgfBussAddrDtls> orderByComparator,
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

		List<DgfBussAddrDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfBussAddrDtls>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFBUSSADDRDTLS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFBUSSADDRDTLS;

				sql = sql.concat(DgfBussAddrDtlsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DgfBussAddrDtls>)QueryUtil.list(
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
	 * Removes all the dgf buss addr dtlses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DgfBussAddrDtls dgfBussAddrDtls : findAll()) {
			remove(dgfBussAddrDtls);
		}
	}

	/**
	 * Returns the number of dgf buss addr dtlses.
	 *
	 * @return the number of dgf buss addr dtlses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DGFBUSSADDRDTLS);

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
		return "businessAddressId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DGFBUSSADDRDTLS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DgfBussAddrDtlsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dgf buss addr dtls persistence.
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

		_finderPathWithPaginationFindBydgfBussAddrDtlsByBusinessDistrict =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBydgfBussAddrDtlsByBusinessDistrict",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"businessDistrict"}, true);

		_finderPathWithoutPaginationFindBydgfBussAddrDtlsByBusinessDistrict =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydgfBussAddrDtlsByBusinessDistrict",
				new String[] {Long.class.getName()},
				new String[] {"businessDistrict"}, true);

		_finderPathCountBydgfBussAddrDtlsByBusinessDistrict = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfBussAddrDtlsByBusinessDistrict",
			new String[] {Long.class.getName()},
			new String[] {"businessDistrict"}, false);

		_finderPathWithPaginationFindBydgfBussAddrDtlsByBusinessUpzilla =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBydgfBussAddrDtlsByBusinessUpzilla",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"businessUpzilla"}, true);

		_finderPathWithoutPaginationFindBydgfBussAddrDtlsByBusinessUpzilla =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydgfBussAddrDtlsByBusinessUpzilla",
				new String[] {Long.class.getName()},
				new String[] {"businessUpzilla"}, true);

		_finderPathCountBydgfBussAddrDtlsByBusinessUpzilla = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfBussAddrDtlsByBusinessUpzilla",
			new String[] {Long.class.getName()},
			new String[] {"businessUpzilla"}, false);

		_finderPathWithPaginationFindBydgfBussAddrDtlsByBusinessUnionName =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBydgfBussAddrDtlsByBusinessUnionName",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"businessUnionName"}, true);

		_finderPathWithoutPaginationFindBydgfBussAddrDtlsByBusinessUnionName =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydgfBussAddrDtlsByBusinessUnionName",
				new String[] {Long.class.getName()},
				new String[] {"businessUnionName"}, true);

		_finderPathCountBydgfBussAddrDtlsByBusinessUnionName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfBussAddrDtlsByBusinessUnionName",
			new String[] {Long.class.getName()},
			new String[] {"businessUnionName"}, false);

		_finderPathWithPaginationFindBydgfBussAddrDtlsByBusinessWard =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBydgfBussAddrDtlsByBusinessWard",
				new String[] {
					String.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"businessWard"}, true);

		_finderPathWithoutPaginationFindBydgfBussAddrDtlsByBusinessWard =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydgfBussAddrDtlsByBusinessWard",
				new String[] {String.class.getName()},
				new String[] {"businessWard"}, true);

		_finderPathCountBydgfBussAddrDtlsByBusinessWard = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfBussAddrDtlsByBusinessWard",
			new String[] {String.class.getName()},
			new String[] {"businessWard"}, false);

		_setDgfBussAddrDtlsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDgfBussAddrDtlsUtilPersistence(null);

		entityCache.removeCache(DgfBussAddrDtlsImpl.class.getName());
	}

	private void _setDgfBussAddrDtlsUtilPersistence(
		DgfBussAddrDtlsPersistence dgfBussAddrDtlsPersistence) {

		try {
			Field field = DgfBussAddrDtlsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dgfBussAddrDtlsPersistence);
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

	private static final String _SQL_SELECT_DGFBUSSADDRDTLS =
		"SELECT dgfBussAddrDtls FROM DgfBussAddrDtls dgfBussAddrDtls";

	private static final String _SQL_SELECT_DGFBUSSADDRDTLS_WHERE =
		"SELECT dgfBussAddrDtls FROM DgfBussAddrDtls dgfBussAddrDtls WHERE ";

	private static final String _SQL_COUNT_DGFBUSSADDRDTLS =
		"SELECT COUNT(dgfBussAddrDtls) FROM DgfBussAddrDtls dgfBussAddrDtls";

	private static final String _SQL_COUNT_DGFBUSSADDRDTLS_WHERE =
		"SELECT COUNT(dgfBussAddrDtls) FROM DgfBussAddrDtls dgfBussAddrDtls WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dgfBussAddrDtls.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DgfBussAddrDtls exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DgfBussAddrDtls exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DgfBussAddrDtlsPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}