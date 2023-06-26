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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfDlrDistributionDtlsException;
import bd.gov.dgfood.food.grain.license.model.DgfDlrDistributionDtls;
import bd.gov.dgfood.food.grain.license.model.DgfDlrDistributionDtlsTable;
import bd.gov.dgfood.food.grain.license.model.impl.DgfDlrDistributionDtlsImpl;
import bd.gov.dgfood.food.grain.license.model.impl.DgfDlrDistributionDtlsModelImpl;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfDlrDistributionDtlsPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfDlrDistributionDtlsUtil;
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
 * The persistence implementation for the dgf dlr distribution dtls service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DgfDlrDistributionDtlsPersistence.class)
public class DgfDlrDistributionDtlsPersistenceImpl
	extends BasePersistenceImpl<DgfDlrDistributionDtls>
	implements DgfDlrDistributionDtlsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DgfDlrDistributionDtlsUtil</code> to access the dgf dlr distribution dtls persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DgfDlrDistributionDtlsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath
		_finderPathWithPaginationFindBydgfDlrDistributionDtlsByDealerId;
	private FinderPath
		_finderPathWithoutPaginationFindBydgfDlrDistributionDtlsByDealerId;
	private FinderPath _finderPathCountBydgfDlrDistributionDtlsByDealerId;

	/**
	 * Returns all the dgf dlr distribution dtlses where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @return the matching dgf dlr distribution dtlses
	 */
	@Override
	public List<DgfDlrDistributionDtls> findBydgfDlrDistributionDtlsByDealerId(
		long dealerId) {

		return findBydgfDlrDistributionDtlsByDealerId(
			dealerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf dlr distribution dtlses where dealerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrDistributionDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param dealerId the dealer ID
	 * @param start the lower bound of the range of dgf dlr distribution dtlses
	 * @param end the upper bound of the range of dgf dlr distribution dtlses (not inclusive)
	 * @return the range of matching dgf dlr distribution dtlses
	 */
	@Override
	public List<DgfDlrDistributionDtls> findBydgfDlrDistributionDtlsByDealerId(
		long dealerId, int start, int end) {

		return findBydgfDlrDistributionDtlsByDealerId(
			dealerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf dlr distribution dtlses where dealerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrDistributionDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param dealerId the dealer ID
	 * @param start the lower bound of the range of dgf dlr distribution dtlses
	 * @param end the upper bound of the range of dgf dlr distribution dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf dlr distribution dtlses
	 */
	@Override
	public List<DgfDlrDistributionDtls> findBydgfDlrDistributionDtlsByDealerId(
		long dealerId, int start, int end,
		OrderByComparator<DgfDlrDistributionDtls> orderByComparator) {

		return findBydgfDlrDistributionDtlsByDealerId(
			dealerId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf dlr distribution dtlses where dealerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrDistributionDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param dealerId the dealer ID
	 * @param start the lower bound of the range of dgf dlr distribution dtlses
	 * @param end the upper bound of the range of dgf dlr distribution dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf dlr distribution dtlses
	 */
	@Override
	public List<DgfDlrDistributionDtls> findBydgfDlrDistributionDtlsByDealerId(
		long dealerId, int start, int end,
		OrderByComparator<DgfDlrDistributionDtls> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydgfDlrDistributionDtlsByDealerId;
				finderArgs = new Object[] {dealerId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBydgfDlrDistributionDtlsByDealerId;
			finderArgs = new Object[] {dealerId, start, end, orderByComparator};
		}

		List<DgfDlrDistributionDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfDlrDistributionDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfDlrDistributionDtls dgfDlrDistributionDtls : list) {
					if (dealerId != dgfDlrDistributionDtls.getDealerId()) {
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

			sb.append(_SQL_SELECT_DGFDLRDISTRIBUTIONDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFDLRDISTRIBUTIONDTLSBYDEALERID_DEALERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfDlrDistributionDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dealerId);

				list = (List<DgfDlrDistributionDtls>)QueryUtil.list(
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
	 * Returns the first dgf dlr distribution dtls in the ordered set where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a matching dgf dlr distribution dtls could not be found
	 */
	@Override
	public DgfDlrDistributionDtls findBydgfDlrDistributionDtlsByDealerId_First(
			long dealerId,
			OrderByComparator<DgfDlrDistributionDtls> orderByComparator)
		throws NoSuchDgfDlrDistributionDtlsException {

		DgfDlrDistributionDtls dgfDlrDistributionDtls =
			fetchBydgfDlrDistributionDtlsByDealerId_First(
				dealerId, orderByComparator);

		if (dgfDlrDistributionDtls != null) {
			return dgfDlrDistributionDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dealerId=");
		sb.append(dealerId);

		sb.append("}");

		throw new NoSuchDgfDlrDistributionDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf dlr distribution dtls in the ordered set where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr distribution dtls, or <code>null</code> if a matching dgf dlr distribution dtls could not be found
	 */
	@Override
	public DgfDlrDistributionDtls fetchBydgfDlrDistributionDtlsByDealerId_First(
		long dealerId,
		OrderByComparator<DgfDlrDistributionDtls> orderByComparator) {

		List<DgfDlrDistributionDtls> list =
			findBydgfDlrDistributionDtlsByDealerId(
				dealerId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf dlr distribution dtls in the ordered set where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a matching dgf dlr distribution dtls could not be found
	 */
	@Override
	public DgfDlrDistributionDtls findBydgfDlrDistributionDtlsByDealerId_Last(
			long dealerId,
			OrderByComparator<DgfDlrDistributionDtls> orderByComparator)
		throws NoSuchDgfDlrDistributionDtlsException {

		DgfDlrDistributionDtls dgfDlrDistributionDtls =
			fetchBydgfDlrDistributionDtlsByDealerId_Last(
				dealerId, orderByComparator);

		if (dgfDlrDistributionDtls != null) {
			return dgfDlrDistributionDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dealerId=");
		sb.append(dealerId);

		sb.append("}");

		throw new NoSuchDgfDlrDistributionDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf dlr distribution dtls in the ordered set where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr distribution dtls, or <code>null</code> if a matching dgf dlr distribution dtls could not be found
	 */
	@Override
	public DgfDlrDistributionDtls fetchBydgfDlrDistributionDtlsByDealerId_Last(
		long dealerId,
		OrderByComparator<DgfDlrDistributionDtls> orderByComparator) {

		int count = countBydgfDlrDistributionDtlsByDealerId(dealerId);

		if (count == 0) {
			return null;
		}

		List<DgfDlrDistributionDtls> list =
			findBydgfDlrDistributionDtlsByDealerId(
				dealerId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf dlr distribution dtlses before and after the current dgf dlr distribution dtls in the ordered set where dealerId = &#63;.
	 *
	 * @param id the primary key of the current dgf dlr distribution dtls
	 * @param dealerId the dealer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a dgf dlr distribution dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrDistributionDtls[]
			findBydgfDlrDistributionDtlsByDealerId_PrevAndNext(
				long id, long dealerId,
				OrderByComparator<DgfDlrDistributionDtls> orderByComparator)
		throws NoSuchDgfDlrDistributionDtlsException {

		DgfDlrDistributionDtls dgfDlrDistributionDtls = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DgfDlrDistributionDtls[] array = new DgfDlrDistributionDtlsImpl[3];

			array[0] = getBydgfDlrDistributionDtlsByDealerId_PrevAndNext(
				session, dgfDlrDistributionDtls, dealerId, orderByComparator,
				true);

			array[1] = dgfDlrDistributionDtls;

			array[2] = getBydgfDlrDistributionDtlsByDealerId_PrevAndNext(
				session, dgfDlrDistributionDtls, dealerId, orderByComparator,
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

	protected DgfDlrDistributionDtls
		getBydgfDlrDistributionDtlsByDealerId_PrevAndNext(
			Session session, DgfDlrDistributionDtls dgfDlrDistributionDtls,
			long dealerId,
			OrderByComparator<DgfDlrDistributionDtls> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFDLRDISTRIBUTIONDTLS_WHERE);

		sb.append(_FINDER_COLUMN_DGFDLRDISTRIBUTIONDTLSBYDEALERID_DEALERID_2);

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
			sb.append(DgfDlrDistributionDtlsModelImpl.ORDER_BY_JPQL);
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
						dgfDlrDistributionDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfDlrDistributionDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf dlr distribution dtlses where dealerId = &#63; from the database.
	 *
	 * @param dealerId the dealer ID
	 */
	@Override
	public void removeBydgfDlrDistributionDtlsByDealerId(long dealerId) {
		for (DgfDlrDistributionDtls dgfDlrDistributionDtls :
				findBydgfDlrDistributionDtlsByDealerId(
					dealerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgfDlrDistributionDtls);
		}
	}

	/**
	 * Returns the number of dgf dlr distribution dtlses where dealerId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @return the number of matching dgf dlr distribution dtlses
	 */
	@Override
	public int countBydgfDlrDistributionDtlsByDealerId(long dealerId) {
		FinderPath finderPath =
			_finderPathCountBydgfDlrDistributionDtlsByDealerId;

		Object[] finderArgs = new Object[] {dealerId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFDLRDISTRIBUTIONDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFDLRDISTRIBUTIONDTLSBYDEALERID_DEALERID_2);

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
		_FINDER_COLUMN_DGFDLRDISTRIBUTIONDTLSBYDEALERID_DEALERID_2 =
			"dgfDlrDistributionDtls.dealerId = ?";

	private FinderPath
		_finderPathWithPaginationFindBydgfDlrDistributionDtlsByBeneficiariesId;
	private FinderPath
		_finderPathWithoutPaginationFindBydgfDlrDistributionDtlsByBeneficiariesId;
	private FinderPath
		_finderPathCountBydgfDlrDistributionDtlsByBeneficiariesId;

	/**
	 * Returns all the dgf dlr distribution dtlses where beneficiariesId = &#63;.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @return the matching dgf dlr distribution dtlses
	 */
	@Override
	public List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByBeneficiariesId(long beneficiariesId) {

		return findBydgfDlrDistributionDtlsByBeneficiariesId(
			beneficiariesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf dlr distribution dtlses where beneficiariesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrDistributionDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param start the lower bound of the range of dgf dlr distribution dtlses
	 * @param end the upper bound of the range of dgf dlr distribution dtlses (not inclusive)
	 * @return the range of matching dgf dlr distribution dtlses
	 */
	@Override
	public List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByBeneficiariesId(
			long beneficiariesId, int start, int end) {

		return findBydgfDlrDistributionDtlsByBeneficiariesId(
			beneficiariesId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf dlr distribution dtlses where beneficiariesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrDistributionDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param start the lower bound of the range of dgf dlr distribution dtlses
	 * @param end the upper bound of the range of dgf dlr distribution dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf dlr distribution dtlses
	 */
	@Override
	public List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByBeneficiariesId(
			long beneficiariesId, int start, int end,
			OrderByComparator<DgfDlrDistributionDtls> orderByComparator) {

		return findBydgfDlrDistributionDtlsByBeneficiariesId(
			beneficiariesId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf dlr distribution dtlses where beneficiariesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrDistributionDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param start the lower bound of the range of dgf dlr distribution dtlses
	 * @param end the upper bound of the range of dgf dlr distribution dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf dlr distribution dtlses
	 */
	@Override
	public List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByBeneficiariesId(
			long beneficiariesId, int start, int end,
			OrderByComparator<DgfDlrDistributionDtls> orderByComparator,
			boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydgfDlrDistributionDtlsByBeneficiariesId;
				finderArgs = new Object[] {beneficiariesId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBydgfDlrDistributionDtlsByBeneficiariesId;
			finderArgs = new Object[] {
				beneficiariesId, start, end, orderByComparator
			};
		}

		List<DgfDlrDistributionDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfDlrDistributionDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfDlrDistributionDtls dgfDlrDistributionDtls : list) {
					if (beneficiariesId !=
							dgfDlrDistributionDtls.getBeneficiariesId()) {

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

			sb.append(_SQL_SELECT_DGFDLRDISTRIBUTIONDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFDLRDISTRIBUTIONDTLSBYBENEFICIARIESID_BENEFICIARIESID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfDlrDistributionDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(beneficiariesId);

				list = (List<DgfDlrDistributionDtls>)QueryUtil.list(
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
	 * Returns the first dgf dlr distribution dtls in the ordered set where beneficiariesId = &#63;.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a matching dgf dlr distribution dtls could not be found
	 */
	@Override
	public DgfDlrDistributionDtls
			findBydgfDlrDistributionDtlsByBeneficiariesId_First(
				long beneficiariesId,
				OrderByComparator<DgfDlrDistributionDtls> orderByComparator)
		throws NoSuchDgfDlrDistributionDtlsException {

		DgfDlrDistributionDtls dgfDlrDistributionDtls =
			fetchBydgfDlrDistributionDtlsByBeneficiariesId_First(
				beneficiariesId, orderByComparator);

		if (dgfDlrDistributionDtls != null) {
			return dgfDlrDistributionDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("beneficiariesId=");
		sb.append(beneficiariesId);

		sb.append("}");

		throw new NoSuchDgfDlrDistributionDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf dlr distribution dtls in the ordered set where beneficiariesId = &#63;.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr distribution dtls, or <code>null</code> if a matching dgf dlr distribution dtls could not be found
	 */
	@Override
	public DgfDlrDistributionDtls
		fetchBydgfDlrDistributionDtlsByBeneficiariesId_First(
			long beneficiariesId,
			OrderByComparator<DgfDlrDistributionDtls> orderByComparator) {

		List<DgfDlrDistributionDtls> list =
			findBydgfDlrDistributionDtlsByBeneficiariesId(
				beneficiariesId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf dlr distribution dtls in the ordered set where beneficiariesId = &#63;.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a matching dgf dlr distribution dtls could not be found
	 */
	@Override
	public DgfDlrDistributionDtls
			findBydgfDlrDistributionDtlsByBeneficiariesId_Last(
				long beneficiariesId,
				OrderByComparator<DgfDlrDistributionDtls> orderByComparator)
		throws NoSuchDgfDlrDistributionDtlsException {

		DgfDlrDistributionDtls dgfDlrDistributionDtls =
			fetchBydgfDlrDistributionDtlsByBeneficiariesId_Last(
				beneficiariesId, orderByComparator);

		if (dgfDlrDistributionDtls != null) {
			return dgfDlrDistributionDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("beneficiariesId=");
		sb.append(beneficiariesId);

		sb.append("}");

		throw new NoSuchDgfDlrDistributionDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf dlr distribution dtls in the ordered set where beneficiariesId = &#63;.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr distribution dtls, or <code>null</code> if a matching dgf dlr distribution dtls could not be found
	 */
	@Override
	public DgfDlrDistributionDtls
		fetchBydgfDlrDistributionDtlsByBeneficiariesId_Last(
			long beneficiariesId,
			OrderByComparator<DgfDlrDistributionDtls> orderByComparator) {

		int count = countBydgfDlrDistributionDtlsByBeneficiariesId(
			beneficiariesId);

		if (count == 0) {
			return null;
		}

		List<DgfDlrDistributionDtls> list =
			findBydgfDlrDistributionDtlsByBeneficiariesId(
				beneficiariesId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf dlr distribution dtlses before and after the current dgf dlr distribution dtls in the ordered set where beneficiariesId = &#63;.
	 *
	 * @param id the primary key of the current dgf dlr distribution dtls
	 * @param beneficiariesId the beneficiaries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a dgf dlr distribution dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrDistributionDtls[]
			findBydgfDlrDistributionDtlsByBeneficiariesId_PrevAndNext(
				long id, long beneficiariesId,
				OrderByComparator<DgfDlrDistributionDtls> orderByComparator)
		throws NoSuchDgfDlrDistributionDtlsException {

		DgfDlrDistributionDtls dgfDlrDistributionDtls = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DgfDlrDistributionDtls[] array = new DgfDlrDistributionDtlsImpl[3];

			array[0] = getBydgfDlrDistributionDtlsByBeneficiariesId_PrevAndNext(
				session, dgfDlrDistributionDtls, beneficiariesId,
				orderByComparator, true);

			array[1] = dgfDlrDistributionDtls;

			array[2] = getBydgfDlrDistributionDtlsByBeneficiariesId_PrevAndNext(
				session, dgfDlrDistributionDtls, beneficiariesId,
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

	protected DgfDlrDistributionDtls
		getBydgfDlrDistributionDtlsByBeneficiariesId_PrevAndNext(
			Session session, DgfDlrDistributionDtls dgfDlrDistributionDtls,
			long beneficiariesId,
			OrderByComparator<DgfDlrDistributionDtls> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFDLRDISTRIBUTIONDTLS_WHERE);

		sb.append(
			_FINDER_COLUMN_DGFDLRDISTRIBUTIONDTLSBYBENEFICIARIESID_BENEFICIARIESID_2);

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
			sb.append(DgfDlrDistributionDtlsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(beneficiariesId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfDlrDistributionDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfDlrDistributionDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf dlr distribution dtlses where beneficiariesId = &#63; from the database.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 */
	@Override
	public void removeBydgfDlrDistributionDtlsByBeneficiariesId(
		long beneficiariesId) {

		for (DgfDlrDistributionDtls dgfDlrDistributionDtls :
				findBydgfDlrDistributionDtlsByBeneficiariesId(
					beneficiariesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgfDlrDistributionDtls);
		}
	}

	/**
	 * Returns the number of dgf dlr distribution dtlses where beneficiariesId = &#63;.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @return the number of matching dgf dlr distribution dtlses
	 */
	@Override
	public int countBydgfDlrDistributionDtlsByBeneficiariesId(
		long beneficiariesId) {

		FinderPath finderPath =
			_finderPathCountBydgfDlrDistributionDtlsByBeneficiariesId;

		Object[] finderArgs = new Object[] {beneficiariesId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFDLRDISTRIBUTIONDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFDLRDISTRIBUTIONDTLSBYBENEFICIARIESID_BENEFICIARIESID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(beneficiariesId);

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
		_FINDER_COLUMN_DGFDLRDISTRIBUTIONDTLSBYBENEFICIARIESID_BENEFICIARIESID_2 =
			"dgfDlrDistributionDtls.beneficiariesId = ?";

	private FinderPath
		_finderPathWithPaginationFindBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId;
	private FinderPath
		_finderPathWithoutPaginationFindBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId;
	private FinderPath
		_finderPathCountBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId;

	/**
	 * Returns all the dgf dlr distribution dtlses where dealerId = &#63; and beneficiariesId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param beneficiariesId the beneficiaries ID
	 * @return the matching dgf dlr distribution dtlses
	 */
	@Override
	public List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
			long dealerId, long beneficiariesId) {

		return findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
			dealerId, beneficiariesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the dgf dlr distribution dtlses where dealerId = &#63; and beneficiariesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrDistributionDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param dealerId the dealer ID
	 * @param beneficiariesId the beneficiaries ID
	 * @param start the lower bound of the range of dgf dlr distribution dtlses
	 * @param end the upper bound of the range of dgf dlr distribution dtlses (not inclusive)
	 * @return the range of matching dgf dlr distribution dtlses
	 */
	@Override
	public List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
			long dealerId, long beneficiariesId, int start, int end) {

		return findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
			dealerId, beneficiariesId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf dlr distribution dtlses where dealerId = &#63; and beneficiariesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrDistributionDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param dealerId the dealer ID
	 * @param beneficiariesId the beneficiaries ID
	 * @param start the lower bound of the range of dgf dlr distribution dtlses
	 * @param end the upper bound of the range of dgf dlr distribution dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf dlr distribution dtlses
	 */
	@Override
	public List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
			long dealerId, long beneficiariesId, int start, int end,
			OrderByComparator<DgfDlrDistributionDtls> orderByComparator) {

		return findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
			dealerId, beneficiariesId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf dlr distribution dtlses where dealerId = &#63; and beneficiariesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrDistributionDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param dealerId the dealer ID
	 * @param beneficiariesId the beneficiaries ID
	 * @param start the lower bound of the range of dgf dlr distribution dtlses
	 * @param end the upper bound of the range of dgf dlr distribution dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf dlr distribution dtlses
	 */
	@Override
	public List<DgfDlrDistributionDtls>
		findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
			long dealerId, long beneficiariesId, int start, int end,
			OrderByComparator<DgfDlrDistributionDtls> orderByComparator,
			boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId;
				finderArgs = new Object[] {dealerId, beneficiariesId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId;
			finderArgs = new Object[] {
				dealerId, beneficiariesId, start, end, orderByComparator
			};
		}

		List<DgfDlrDistributionDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfDlrDistributionDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfDlrDistributionDtls dgfDlrDistributionDtls : list) {
					if ((dealerId != dgfDlrDistributionDtls.getDealerId()) ||
						(beneficiariesId !=
							dgfDlrDistributionDtls.getBeneficiariesId())) {

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

			sb.append(_SQL_SELECT_DGFDLRDISTRIBUTIONDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFDLRDISTRIBUTIONDTLSBYDEALERIDANDBENEFICIARIESID_DEALERID_2);

			sb.append(
				_FINDER_COLUMN_DGFDLRDISTRIBUTIONDTLSBYDEALERIDANDBENEFICIARIESID_BENEFICIARIESID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfDlrDistributionDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dealerId);

				queryPos.add(beneficiariesId);

				list = (List<DgfDlrDistributionDtls>)QueryUtil.list(
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
	 * Returns the first dgf dlr distribution dtls in the ordered set where dealerId = &#63; and beneficiariesId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param beneficiariesId the beneficiaries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a matching dgf dlr distribution dtls could not be found
	 */
	@Override
	public DgfDlrDistributionDtls
			findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId_First(
				long dealerId, long beneficiariesId,
				OrderByComparator<DgfDlrDistributionDtls> orderByComparator)
		throws NoSuchDgfDlrDistributionDtlsException {

		DgfDlrDistributionDtls dgfDlrDistributionDtls =
			fetchBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId_First(
				dealerId, beneficiariesId, orderByComparator);

		if (dgfDlrDistributionDtls != null) {
			return dgfDlrDistributionDtls;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dealerId=");
		sb.append(dealerId);

		sb.append(", beneficiariesId=");
		sb.append(beneficiariesId);

		sb.append("}");

		throw new NoSuchDgfDlrDistributionDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf dlr distribution dtls in the ordered set where dealerId = &#63; and beneficiariesId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param beneficiariesId the beneficiaries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr distribution dtls, or <code>null</code> if a matching dgf dlr distribution dtls could not be found
	 */
	@Override
	public DgfDlrDistributionDtls
		fetchBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId_First(
			long dealerId, long beneficiariesId,
			OrderByComparator<DgfDlrDistributionDtls> orderByComparator) {

		List<DgfDlrDistributionDtls> list =
			findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
				dealerId, beneficiariesId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf dlr distribution dtls in the ordered set where dealerId = &#63; and beneficiariesId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param beneficiariesId the beneficiaries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a matching dgf dlr distribution dtls could not be found
	 */
	@Override
	public DgfDlrDistributionDtls
			findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId_Last(
				long dealerId, long beneficiariesId,
				OrderByComparator<DgfDlrDistributionDtls> orderByComparator)
		throws NoSuchDgfDlrDistributionDtlsException {

		DgfDlrDistributionDtls dgfDlrDistributionDtls =
			fetchBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId_Last(
				dealerId, beneficiariesId, orderByComparator);

		if (dgfDlrDistributionDtls != null) {
			return dgfDlrDistributionDtls;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dealerId=");
		sb.append(dealerId);

		sb.append(", beneficiariesId=");
		sb.append(beneficiariesId);

		sb.append("}");

		throw new NoSuchDgfDlrDistributionDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf dlr distribution dtls in the ordered set where dealerId = &#63; and beneficiariesId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param beneficiariesId the beneficiaries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr distribution dtls, or <code>null</code> if a matching dgf dlr distribution dtls could not be found
	 */
	@Override
	public DgfDlrDistributionDtls
		fetchBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId_Last(
			long dealerId, long beneficiariesId,
			OrderByComparator<DgfDlrDistributionDtls> orderByComparator) {

		int count = countBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
			dealerId, beneficiariesId);

		if (count == 0) {
			return null;
		}

		List<DgfDlrDistributionDtls> list =
			findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
				dealerId, beneficiariesId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf dlr distribution dtlses before and after the current dgf dlr distribution dtls in the ordered set where dealerId = &#63; and beneficiariesId = &#63;.
	 *
	 * @param id the primary key of the current dgf dlr distribution dtls
	 * @param dealerId the dealer ID
	 * @param beneficiariesId the beneficiaries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a dgf dlr distribution dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrDistributionDtls[]
			findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId_PrevAndNext(
				long id, long dealerId, long beneficiariesId,
				OrderByComparator<DgfDlrDistributionDtls> orderByComparator)
		throws NoSuchDgfDlrDistributionDtlsException {

		DgfDlrDistributionDtls dgfDlrDistributionDtls = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DgfDlrDistributionDtls[] array = new DgfDlrDistributionDtlsImpl[3];

			array[0] =
				getBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId_PrevAndNext(
					session, dgfDlrDistributionDtls, dealerId, beneficiariesId,
					orderByComparator, true);

			array[1] = dgfDlrDistributionDtls;

			array[2] =
				getBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId_PrevAndNext(
					session, dgfDlrDistributionDtls, dealerId, beneficiariesId,
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

	protected DgfDlrDistributionDtls
		getBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId_PrevAndNext(
			Session session, DgfDlrDistributionDtls dgfDlrDistributionDtls,
			long dealerId, long beneficiariesId,
			OrderByComparator<DgfDlrDistributionDtls> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFDLRDISTRIBUTIONDTLS_WHERE);

		sb.append(
			_FINDER_COLUMN_DGFDLRDISTRIBUTIONDTLSBYDEALERIDANDBENEFICIARIESID_DEALERID_2);

		sb.append(
			_FINDER_COLUMN_DGFDLRDISTRIBUTIONDTLSBYDEALERIDANDBENEFICIARIESID_BENEFICIARIESID_2);

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
			sb.append(DgfDlrDistributionDtlsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(dealerId);

		queryPos.add(beneficiariesId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfDlrDistributionDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfDlrDistributionDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf dlr distribution dtlses where dealerId = &#63; and beneficiariesId = &#63; from the database.
	 *
	 * @param dealerId the dealer ID
	 * @param beneficiariesId the beneficiaries ID
	 */
	@Override
	public void removeBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
		long dealerId, long beneficiariesId) {

		for (DgfDlrDistributionDtls dgfDlrDistributionDtls :
				findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
					dealerId, beneficiariesId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(dgfDlrDistributionDtls);
		}
	}

	/**
	 * Returns the number of dgf dlr distribution dtlses where dealerId = &#63; and beneficiariesId = &#63;.
	 *
	 * @param dealerId the dealer ID
	 * @param beneficiariesId the beneficiaries ID
	 * @return the number of matching dgf dlr distribution dtlses
	 */
	@Override
	public int countBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
		long dealerId, long beneficiariesId) {

		FinderPath finderPath =
			_finderPathCountBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId;

		Object[] finderArgs = new Object[] {dealerId, beneficiariesId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFDLRDISTRIBUTIONDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFDLRDISTRIBUTIONDTLSBYDEALERIDANDBENEFICIARIESID_DEALERID_2);

			sb.append(
				_FINDER_COLUMN_DGFDLRDISTRIBUTIONDTLSBYDEALERIDANDBENEFICIARIESID_BENEFICIARIESID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dealerId);

				queryPos.add(beneficiariesId);

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
		_FINDER_COLUMN_DGFDLRDISTRIBUTIONDTLSBYDEALERIDANDBENEFICIARIESID_DEALERID_2 =
			"dgfDlrDistributionDtls.dealerId = ? AND ";

	private static final String
		_FINDER_COLUMN_DGFDLRDISTRIBUTIONDTLSBYDEALERIDANDBENEFICIARIESID_BENEFICIARIESID_2 =
			"dgfDlrDistributionDtls.beneficiariesId = ?";

	private FinderPath
		_finderPathFetchBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear;
	private FinderPath
		_finderPathCountBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear;

	/**
	 * Returns the dgf dlr distribution dtls where beneficiariesId = &#63; and month = &#63; and year = &#63; or throws a <code>NoSuchDgfDlrDistributionDtlsException</code> if it could not be found.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param month the month
	 * @param year the year
	 * @return the matching dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a matching dgf dlr distribution dtls could not be found
	 */
	@Override
	public DgfDlrDistributionDtls
			findBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear(
				long beneficiariesId, int month, int year)
		throws NoSuchDgfDlrDistributionDtlsException {

		DgfDlrDistributionDtls dgfDlrDistributionDtls =
			fetchBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear(
				beneficiariesId, month, year);

		if (dgfDlrDistributionDtls == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("beneficiariesId=");
			sb.append(beneficiariesId);

			sb.append(", month=");
			sb.append(month);

			sb.append(", year=");
			sb.append(year);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfDlrDistributionDtlsException(sb.toString());
		}

		return dgfDlrDistributionDtls;
	}

	/**
	 * Returns the dgf dlr distribution dtls where beneficiariesId = &#63; and month = &#63; and year = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param month the month
	 * @param year the year
	 * @return the matching dgf dlr distribution dtls, or <code>null</code> if a matching dgf dlr distribution dtls could not be found
	 */
	@Override
	public DgfDlrDistributionDtls
		fetchBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear(
			long beneficiariesId, int month, int year) {

		return fetchBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear(
			beneficiariesId, month, year, true);
	}

	/**
	 * Returns the dgf dlr distribution dtls where beneficiariesId = &#63; and month = &#63; and year = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param month the month
	 * @param year the year
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf dlr distribution dtls, or <code>null</code> if a matching dgf dlr distribution dtls could not be found
	 */
	@Override
	public DgfDlrDistributionDtls
		fetchBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear(
			long beneficiariesId, int month, int year, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {beneficiariesId, month, year};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear,
				finderArgs, this);
		}

		if (result instanceof DgfDlrDistributionDtls) {
			DgfDlrDistributionDtls dgfDlrDistributionDtls =
				(DgfDlrDistributionDtls)result;

			if ((beneficiariesId !=
					dgfDlrDistributionDtls.getBeneficiariesId()) ||
				(month != dgfDlrDistributionDtls.getMonth()) ||
				(year != dgfDlrDistributionDtls.getYear())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_DGFDLRDISTRIBUTIONDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFDLRDISTRIBUTIONDTLSBYBENEFICIARIESANDMONTHANDYEAR_BENEFICIARIESID_2);

			sb.append(
				_FINDER_COLUMN_DGFDLRDISTRIBUTIONDTLSBYBENEFICIARIESANDMONTHANDYEAR_MONTH_2);

			sb.append(
				_FINDER_COLUMN_DGFDLRDISTRIBUTIONDTLSBYBENEFICIARIESANDMONTHANDYEAR_YEAR_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(beneficiariesId);

				queryPos.add(month);

				queryPos.add(year);

				List<DgfDlrDistributionDtls> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear,
							finderArgs, list);
					}
				}
				else {
					DgfDlrDistributionDtls dgfDlrDistributionDtls = list.get(0);

					result = dgfDlrDistributionDtls;

					cacheResult(dgfDlrDistributionDtls);
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
			return (DgfDlrDistributionDtls)result;
		}
	}

	/**
	 * Removes the dgf dlr distribution dtls where beneficiariesId = &#63; and month = &#63; and year = &#63; from the database.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param month the month
	 * @param year the year
	 * @return the dgf dlr distribution dtls that was removed
	 */
	@Override
	public DgfDlrDistributionDtls
			removeBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear(
				long beneficiariesId, int month, int year)
		throws NoSuchDgfDlrDistributionDtlsException {

		DgfDlrDistributionDtls dgfDlrDistributionDtls =
			findBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear(
				beneficiariesId, month, year);

		return remove(dgfDlrDistributionDtls);
	}

	/**
	 * Returns the number of dgf dlr distribution dtlses where beneficiariesId = &#63; and month = &#63; and year = &#63;.
	 *
	 * @param beneficiariesId the beneficiaries ID
	 * @param month the month
	 * @param year the year
	 * @return the number of matching dgf dlr distribution dtlses
	 */
	@Override
	public int countBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear(
		long beneficiariesId, int month, int year) {

		FinderPath finderPath =
			_finderPathCountBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear;

		Object[] finderArgs = new Object[] {beneficiariesId, month, year};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DGFDLRDISTRIBUTIONDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFDLRDISTRIBUTIONDTLSBYBENEFICIARIESANDMONTHANDYEAR_BENEFICIARIESID_2);

			sb.append(
				_FINDER_COLUMN_DGFDLRDISTRIBUTIONDTLSBYBENEFICIARIESANDMONTHANDYEAR_MONTH_2);

			sb.append(
				_FINDER_COLUMN_DGFDLRDISTRIBUTIONDTLSBYBENEFICIARIESANDMONTHANDYEAR_YEAR_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(beneficiariesId);

				queryPos.add(month);

				queryPos.add(year);

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
		_FINDER_COLUMN_DGFDLRDISTRIBUTIONDTLSBYBENEFICIARIESANDMONTHANDYEAR_BENEFICIARIESID_2 =
			"dgfDlrDistributionDtls.beneficiariesId = ? AND ";

	private static final String
		_FINDER_COLUMN_DGFDLRDISTRIBUTIONDTLSBYBENEFICIARIESANDMONTHANDYEAR_MONTH_2 =
			"dgfDlrDistributionDtls.month = ? AND ";

	private static final String
		_FINDER_COLUMN_DGFDLRDISTRIBUTIONDTLSBYBENEFICIARIESANDMONTHANDYEAR_YEAR_2 =
			"dgfDlrDistributionDtls.year = ?";

	public DgfDlrDistributionDtlsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("dealerId", "dealer_id");
		dbColumnNames.put("beneficiariesId", "beneficiaries_id");
		dbColumnNames.put("beneficiariesMobileNo", "beneficiaries_mobile_no");
		dbColumnNames.put("cardNo", "card_no");
		dbColumnNames.put("unionId", "union_id");
		dbColumnNames.put("distributionDate", "distribution_date");
		dbColumnNames.put("distributionQty", "distribution_qty");
		dbColumnNames.put("createdAt", "created_at");
		dbColumnNames.put("updatedAt", "updated_at");

		setDBColumnNames(dbColumnNames);

		setModelClass(DgfDlrDistributionDtls.class);

		setModelImplClass(DgfDlrDistributionDtlsImpl.class);
		setModelPKClass(long.class);

		setTable(DgfDlrDistributionDtlsTable.INSTANCE);
	}

	/**
	 * Caches the dgf dlr distribution dtls in the entity cache if it is enabled.
	 *
	 * @param dgfDlrDistributionDtls the dgf dlr distribution dtls
	 */
	@Override
	public void cacheResult(DgfDlrDistributionDtls dgfDlrDistributionDtls) {
		entityCache.putResult(
			DgfDlrDistributionDtlsImpl.class,
			dgfDlrDistributionDtls.getPrimaryKey(), dgfDlrDistributionDtls);

		finderCache.putResult(
			_finderPathFetchBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear,
			new Object[] {
				dgfDlrDistributionDtls.getBeneficiariesId(),
				dgfDlrDistributionDtls.getMonth(),
				dgfDlrDistributionDtls.getYear()
			},
			dgfDlrDistributionDtls);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dgf dlr distribution dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfDlrDistributionDtlses the dgf dlr distribution dtlses
	 */
	@Override
	public void cacheResult(
		List<DgfDlrDistributionDtls> dgfDlrDistributionDtlses) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgfDlrDistributionDtlses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DgfDlrDistributionDtls dgfDlrDistributionDtls :
				dgfDlrDistributionDtlses) {

			if (entityCache.getResult(
					DgfDlrDistributionDtlsImpl.class,
					dgfDlrDistributionDtls.getPrimaryKey()) == null) {

				cacheResult(dgfDlrDistributionDtls);
			}
		}
	}

	/**
	 * Clears the cache for all dgf dlr distribution dtlses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DgfDlrDistributionDtlsImpl.class);

		finderCache.clearCache(DgfDlrDistributionDtlsImpl.class);
	}

	/**
	 * Clears the cache for the dgf dlr distribution dtls.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DgfDlrDistributionDtls dgfDlrDistributionDtls) {
		entityCache.removeResult(
			DgfDlrDistributionDtlsImpl.class, dgfDlrDistributionDtls);
	}

	@Override
	public void clearCache(
		List<DgfDlrDistributionDtls> dgfDlrDistributionDtlses) {

		for (DgfDlrDistributionDtls dgfDlrDistributionDtls :
				dgfDlrDistributionDtlses) {

			entityCache.removeResult(
				DgfDlrDistributionDtlsImpl.class, dgfDlrDistributionDtls);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DgfDlrDistributionDtlsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				DgfDlrDistributionDtlsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DgfDlrDistributionDtlsModelImpl dgfDlrDistributionDtlsModelImpl) {

		Object[] args = new Object[] {
			dgfDlrDistributionDtlsModelImpl.getBeneficiariesId(),
			dgfDlrDistributionDtlsModelImpl.getMonth(),
			dgfDlrDistributionDtlsModelImpl.getYear()
		};

		finderCache.putResult(
			_finderPathCountBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear,
			args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear,
			args, dgfDlrDistributionDtlsModelImpl);
	}

	/**
	 * Creates a new dgf dlr distribution dtls with the primary key. Does not add the dgf dlr distribution dtls to the database.
	 *
	 * @param id the primary key for the new dgf dlr distribution dtls
	 * @return the new dgf dlr distribution dtls
	 */
	@Override
	public DgfDlrDistributionDtls create(long id) {
		DgfDlrDistributionDtls dgfDlrDistributionDtls =
			new DgfDlrDistributionDtlsImpl();

		dgfDlrDistributionDtls.setNew(true);
		dgfDlrDistributionDtls.setPrimaryKey(id);

		return dgfDlrDistributionDtls;
	}

	/**
	 * Removes the dgf dlr distribution dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dgf dlr distribution dtls
	 * @return the dgf dlr distribution dtls that was removed
	 * @throws NoSuchDgfDlrDistributionDtlsException if a dgf dlr distribution dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrDistributionDtls remove(long id)
		throws NoSuchDgfDlrDistributionDtlsException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the dgf dlr distribution dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dgf dlr distribution dtls
	 * @return the dgf dlr distribution dtls that was removed
	 * @throws NoSuchDgfDlrDistributionDtlsException if a dgf dlr distribution dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrDistributionDtls remove(Serializable primaryKey)
		throws NoSuchDgfDlrDistributionDtlsException {

		Session session = null;

		try {
			session = openSession();

			DgfDlrDistributionDtls dgfDlrDistributionDtls =
				(DgfDlrDistributionDtls)session.get(
					DgfDlrDistributionDtlsImpl.class, primaryKey);

			if (dgfDlrDistributionDtls == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDgfDlrDistributionDtlsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgfDlrDistributionDtls);
		}
		catch (NoSuchDgfDlrDistributionDtlsException noSuchEntityException) {
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
	protected DgfDlrDistributionDtls removeImpl(
		DgfDlrDistributionDtls dgfDlrDistributionDtls) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgfDlrDistributionDtls)) {
				dgfDlrDistributionDtls = (DgfDlrDistributionDtls)session.get(
					DgfDlrDistributionDtlsImpl.class,
					dgfDlrDistributionDtls.getPrimaryKeyObj());
			}

			if (dgfDlrDistributionDtls != null) {
				session.delete(dgfDlrDistributionDtls);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgfDlrDistributionDtls != null) {
			clearCache(dgfDlrDistributionDtls);
		}

		return dgfDlrDistributionDtls;
	}

	@Override
	public DgfDlrDistributionDtls updateImpl(
		DgfDlrDistributionDtls dgfDlrDistributionDtls) {

		boolean isNew = dgfDlrDistributionDtls.isNew();

		if (!(dgfDlrDistributionDtls instanceof
				DgfDlrDistributionDtlsModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dgfDlrDistributionDtls.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dgfDlrDistributionDtls);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgfDlrDistributionDtls proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DgfDlrDistributionDtls implementation " +
					dgfDlrDistributionDtls.getClass());
		}

		DgfDlrDistributionDtlsModelImpl dgfDlrDistributionDtlsModelImpl =
			(DgfDlrDistributionDtlsModelImpl)dgfDlrDistributionDtls;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgfDlrDistributionDtls);
			}
			else {
				dgfDlrDistributionDtls = (DgfDlrDistributionDtls)session.merge(
					dgfDlrDistributionDtls);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DgfDlrDistributionDtlsImpl.class, dgfDlrDistributionDtlsModelImpl,
			false, true);

		cacheUniqueFindersCache(dgfDlrDistributionDtlsModelImpl);

		if (isNew) {
			dgfDlrDistributionDtls.setNew(false);
		}

		dgfDlrDistributionDtls.resetOriginalValues();

		return dgfDlrDistributionDtls;
	}

	/**
	 * Returns the dgf dlr distribution dtls with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dgf dlr distribution dtls
	 * @return the dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a dgf dlr distribution dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrDistributionDtls findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDgfDlrDistributionDtlsException {

		DgfDlrDistributionDtls dgfDlrDistributionDtls = fetchByPrimaryKey(
			primaryKey);

		if (dgfDlrDistributionDtls == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDgfDlrDistributionDtlsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgfDlrDistributionDtls;
	}

	/**
	 * Returns the dgf dlr distribution dtls with the primary key or throws a <code>NoSuchDgfDlrDistributionDtlsException</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf dlr distribution dtls
	 * @return the dgf dlr distribution dtls
	 * @throws NoSuchDgfDlrDistributionDtlsException if a dgf dlr distribution dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrDistributionDtls findByPrimaryKey(long id)
		throws NoSuchDgfDlrDistributionDtlsException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the dgf dlr distribution dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf dlr distribution dtls
	 * @return the dgf dlr distribution dtls, or <code>null</code> if a dgf dlr distribution dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrDistributionDtls fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the dgf dlr distribution dtlses.
	 *
	 * @return the dgf dlr distribution dtlses
	 */
	@Override
	public List<DgfDlrDistributionDtls> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf dlr distribution dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrDistributionDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr distribution dtlses
	 * @param end the upper bound of the range of dgf dlr distribution dtlses (not inclusive)
	 * @return the range of dgf dlr distribution dtlses
	 */
	@Override
	public List<DgfDlrDistributionDtls> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf dlr distribution dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrDistributionDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr distribution dtlses
	 * @param end the upper bound of the range of dgf dlr distribution dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf dlr distribution dtlses
	 */
	@Override
	public List<DgfDlrDistributionDtls> findAll(
		int start, int end,
		OrderByComparator<DgfDlrDistributionDtls> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf dlr distribution dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrDistributionDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr distribution dtlses
	 * @param end the upper bound of the range of dgf dlr distribution dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf dlr distribution dtlses
	 */
	@Override
	public List<DgfDlrDistributionDtls> findAll(
		int start, int end,
		OrderByComparator<DgfDlrDistributionDtls> orderByComparator,
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

		List<DgfDlrDistributionDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfDlrDistributionDtls>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFDLRDISTRIBUTIONDTLS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFDLRDISTRIBUTIONDTLS;

				sql = sql.concat(DgfDlrDistributionDtlsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DgfDlrDistributionDtls>)QueryUtil.list(
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
	 * Removes all the dgf dlr distribution dtlses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DgfDlrDistributionDtls dgfDlrDistributionDtls : findAll()) {
			remove(dgfDlrDistributionDtls);
		}
	}

	/**
	 * Returns the number of dgf dlr distribution dtlses.
	 *
	 * @return the number of dgf dlr distribution dtlses
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
					_SQL_COUNT_DGFDLRDISTRIBUTIONDTLS);

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
		return _SQL_SELECT_DGFDLRDISTRIBUTIONDTLS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DgfDlrDistributionDtlsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dgf dlr distribution dtls persistence.
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

		_finderPathWithPaginationFindBydgfDlrDistributionDtlsByDealerId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBydgfDlrDistributionDtlsByDealerId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"dealer_id"}, true);

		_finderPathWithoutPaginationFindBydgfDlrDistributionDtlsByDealerId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydgfDlrDistributionDtlsByDealerId",
				new String[] {Long.class.getName()}, new String[] {"dealer_id"},
				true);

		_finderPathCountBydgfDlrDistributionDtlsByDealerId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfDlrDistributionDtlsByDealerId",
			new String[] {Long.class.getName()}, new String[] {"dealer_id"},
			false);

		_finderPathWithPaginationFindBydgfDlrDistributionDtlsByBeneficiariesId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBydgfDlrDistributionDtlsByBeneficiariesId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"beneficiaries_id"}, true);

		_finderPathWithoutPaginationFindBydgfDlrDistributionDtlsByBeneficiariesId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydgfDlrDistributionDtlsByBeneficiariesId",
				new String[] {Long.class.getName()},
				new String[] {"beneficiaries_id"}, true);

		_finderPathCountBydgfDlrDistributionDtlsByBeneficiariesId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countBydgfDlrDistributionDtlsByBeneficiariesId",
				new String[] {Long.class.getName()},
				new String[] {"beneficiaries_id"}, false);

		_finderPathWithPaginationFindBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"dealer_id", "beneficiaries_id"}, true);

		_finderPathWithoutPaginationFindBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"dealer_id", "beneficiaries_id"}, true);

		_finderPathCountBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countBydgfDlrDistributionDtlsByDealerIdAndBeneficiariesId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"dealer_id", "beneficiaries_id"}, false);

		_finderPathFetchBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear =
			new FinderPath(
				FINDER_CLASS_NAME_ENTITY,
				"fetchBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName()
				},
				new String[] {"beneficiaries_id", "month", "year"}, true);

		_finderPathCountBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countBydgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName()
				},
				new String[] {"beneficiaries_id", "month", "year"}, false);

		_setDgfDlrDistributionDtlsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDgfDlrDistributionDtlsUtilPersistence(null);

		entityCache.removeCache(DgfDlrDistributionDtlsImpl.class.getName());
	}

	private void _setDgfDlrDistributionDtlsUtilPersistence(
		DgfDlrDistributionDtlsPersistence dgfDlrDistributionDtlsPersistence) {

		try {
			Field field = DgfDlrDistributionDtlsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dgfDlrDistributionDtlsPersistence);
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

	private static final String _SQL_SELECT_DGFDLRDISTRIBUTIONDTLS =
		"SELECT dgfDlrDistributionDtls FROM DgfDlrDistributionDtls dgfDlrDistributionDtls";

	private static final String _SQL_SELECT_DGFDLRDISTRIBUTIONDTLS_WHERE =
		"SELECT dgfDlrDistributionDtls FROM DgfDlrDistributionDtls dgfDlrDistributionDtls WHERE ";

	private static final String _SQL_COUNT_DGFDLRDISTRIBUTIONDTLS =
		"SELECT COUNT(dgfDlrDistributionDtls) FROM DgfDlrDistributionDtls dgfDlrDistributionDtls";

	private static final String _SQL_COUNT_DGFDLRDISTRIBUTIONDTLS_WHERE =
		"SELECT COUNT(dgfDlrDistributionDtls) FROM DgfDlrDistributionDtls dgfDlrDistributionDtls WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"dgfDlrDistributionDtls.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DgfDlrDistributionDtls exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DgfDlrDistributionDtls exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DgfDlrDistributionDtlsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"dealerId", "beneficiariesId", "beneficiariesMobileNo", "cardNo",
			"unionId", "distributionDate", "distributionQty", "createdAt",
			"updatedAt"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}