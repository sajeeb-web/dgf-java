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

package bd.gov.dgfood.food.friendly.program.service.persistence.impl;

import bd.gov.dgfood.food.friendly.program.exception.NoSuchInvtoryDetailsException;
import bd.gov.dgfood.food.friendly.program.model.InvtoryDetails;
import bd.gov.dgfood.food.friendly.program.model.InvtoryDetailsTable;
import bd.gov.dgfood.food.friendly.program.model.impl.InvtoryDetailsImpl;
import bd.gov.dgfood.food.friendly.program.model.impl.InvtoryDetailsModelImpl;
import bd.gov.dgfood.food.friendly.program.service.persistence.InvtoryDetailsPersistence;
import bd.gov.dgfood.food.friendly.program.service.persistence.InvtoryDetailsUtil;
import bd.gov.dgfood.food.friendly.program.service.persistence.impl.constants.FFPBPersistenceConstants;

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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
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
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the invtory details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = InvtoryDetailsPersistence.class)
public class InvtoryDetailsPersistenceImpl
	extends BasePersistenceImpl<InvtoryDetails>
	implements InvtoryDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>InvtoryDetailsUtil</code> to access the invtory details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		InvtoryDetailsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByinventoryidFinder;
	private FinderPath _finderPathCountByinventoryidFinder;

	/**
	 * Returns the invtory details where inventoryId = &#63; or throws a <code>NoSuchInvtoryDetailsException</code> if it could not be found.
	 *
	 * @param inventoryId the inventory ID
	 * @return the matching invtory details
	 * @throws NoSuchInvtoryDetailsException if a matching invtory details could not be found
	 */
	@Override
	public InvtoryDetails findByinventoryidFinder(long inventoryId)
		throws NoSuchInvtoryDetailsException {

		InvtoryDetails invtoryDetails = fetchByinventoryidFinder(inventoryId);

		if (invtoryDetails == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("inventoryId=");
			sb.append(inventoryId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchInvtoryDetailsException(sb.toString());
		}

		return invtoryDetails;
	}

	/**
	 * Returns the invtory details where inventoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param inventoryId the inventory ID
	 * @return the matching invtory details, or <code>null</code> if a matching invtory details could not be found
	 */
	@Override
	public InvtoryDetails fetchByinventoryidFinder(long inventoryId) {
		return fetchByinventoryidFinder(inventoryId, true);
	}

	/**
	 * Returns the invtory details where inventoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param inventoryId the inventory ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching invtory details, or <code>null</code> if a matching invtory details could not be found
	 */
	@Override
	public InvtoryDetails fetchByinventoryidFinder(
		long inventoryId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {inventoryId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByinventoryidFinder, finderArgs, this);
		}

		if (result instanceof InvtoryDetails) {
			InvtoryDetails invtoryDetails = (InvtoryDetails)result;

			if (inventoryId != invtoryDetails.getInventoryId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_INVTORYDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_INVENTORYIDFINDER_INVENTORYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(inventoryId);

				List<InvtoryDetails> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByinventoryidFinder, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {inventoryId};
							}

							_log.warn(
								"InvtoryDetailsPersistenceImpl.fetchByinventoryidFinder(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					InvtoryDetails invtoryDetails = list.get(0);

					result = invtoryDetails;

					cacheResult(invtoryDetails);
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
			return (InvtoryDetails)result;
		}
	}

	/**
	 * Removes the invtory details where inventoryId = &#63; from the database.
	 *
	 * @param inventoryId the inventory ID
	 * @return the invtory details that was removed
	 */
	@Override
	public InvtoryDetails removeByinventoryidFinder(long inventoryId)
		throws NoSuchInvtoryDetailsException {

		InvtoryDetails invtoryDetails = findByinventoryidFinder(inventoryId);

		return remove(invtoryDetails);
	}

	/**
	 * Returns the number of invtory detailses where inventoryId = &#63;.
	 *
	 * @param inventoryId the inventory ID
	 * @return the number of matching invtory detailses
	 */
	@Override
	public int countByinventoryidFinder(long inventoryId) {
		FinderPath finderPath = _finderPathCountByinventoryidFinder;

		Object[] finderArgs = new Object[] {inventoryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_INVTORYDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_INVENTORYIDFINDER_INVENTORYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(inventoryId);

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

	private static final String _FINDER_COLUMN_INVENTORYIDFINDER_INVENTORYID_2 =
		"invtoryDetails.inventoryId = ?";

	private FinderPath _finderPathWithPaginationFindBydlrregnoFinder;
	private FinderPath _finderPathWithoutPaginationFindBydlrregnoFinder;
	private FinderPath _finderPathCountBydlrregnoFinder;

	/**
	 * Returns all the invtory detailses where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the matching invtory detailses
	 */
	@Override
	public List<InvtoryDetails> findBydlrregnoFinder(long dlrRegNo) {
		return findBydlrregnoFinder(
			dlrRegNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the invtory detailses where dlrRegNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvtoryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param start the lower bound of the range of invtory detailses
	 * @param end the upper bound of the range of invtory detailses (not inclusive)
	 * @return the range of matching invtory detailses
	 */
	@Override
	public List<InvtoryDetails> findBydlrregnoFinder(
		long dlrRegNo, int start, int end) {

		return findBydlrregnoFinder(dlrRegNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the invtory detailses where dlrRegNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvtoryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param start the lower bound of the range of invtory detailses
	 * @param end the upper bound of the range of invtory detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching invtory detailses
	 */
	@Override
	public List<InvtoryDetails> findBydlrregnoFinder(
		long dlrRegNo, int start, int end,
		OrderByComparator<InvtoryDetails> orderByComparator) {

		return findBydlrregnoFinder(
			dlrRegNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the invtory detailses where dlrRegNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvtoryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param start the lower bound of the range of invtory detailses
	 * @param end the upper bound of the range of invtory detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching invtory detailses
	 */
	@Override
	public List<InvtoryDetails> findBydlrregnoFinder(
		long dlrRegNo, int start, int end,
		OrderByComparator<InvtoryDetails> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBydlrregnoFinder;
				finderArgs = new Object[] {dlrRegNo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBydlrregnoFinder;
			finderArgs = new Object[] {dlrRegNo, start, end, orderByComparator};
		}

		List<InvtoryDetails> list = null;

		if (useFinderCache) {
			list = (List<InvtoryDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (InvtoryDetails invtoryDetails : list) {
					if (dlrRegNo != invtoryDetails.getDlrRegNo()) {
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

			sb.append(_SQL_SELECT_INVTORYDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_DLRREGNOFINDER_DLRREGNO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(InvtoryDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dlrRegNo);

				list = (List<InvtoryDetails>)QueryUtil.list(
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
	 * Returns the first invtory details in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invtory details
	 * @throws NoSuchInvtoryDetailsException if a matching invtory details could not be found
	 */
	@Override
	public InvtoryDetails findBydlrregnoFinder_First(
			long dlrRegNo, OrderByComparator<InvtoryDetails> orderByComparator)
		throws NoSuchInvtoryDetailsException {

		InvtoryDetails invtoryDetails = fetchBydlrregnoFinder_First(
			dlrRegNo, orderByComparator);

		if (invtoryDetails != null) {
			return invtoryDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dlrRegNo=");
		sb.append(dlrRegNo);

		sb.append("}");

		throw new NoSuchInvtoryDetailsException(sb.toString());
	}

	/**
	 * Returns the first invtory details in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invtory details, or <code>null</code> if a matching invtory details could not be found
	 */
	@Override
	public InvtoryDetails fetchBydlrregnoFinder_First(
		long dlrRegNo, OrderByComparator<InvtoryDetails> orderByComparator) {

		List<InvtoryDetails> list = findBydlrregnoFinder(
			dlrRegNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last invtory details in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invtory details
	 * @throws NoSuchInvtoryDetailsException if a matching invtory details could not be found
	 */
	@Override
	public InvtoryDetails findBydlrregnoFinder_Last(
			long dlrRegNo, OrderByComparator<InvtoryDetails> orderByComparator)
		throws NoSuchInvtoryDetailsException {

		InvtoryDetails invtoryDetails = fetchBydlrregnoFinder_Last(
			dlrRegNo, orderByComparator);

		if (invtoryDetails != null) {
			return invtoryDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dlrRegNo=");
		sb.append(dlrRegNo);

		sb.append("}");

		throw new NoSuchInvtoryDetailsException(sb.toString());
	}

	/**
	 * Returns the last invtory details in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invtory details, or <code>null</code> if a matching invtory details could not be found
	 */
	@Override
	public InvtoryDetails fetchBydlrregnoFinder_Last(
		long dlrRegNo, OrderByComparator<InvtoryDetails> orderByComparator) {

		int count = countBydlrregnoFinder(dlrRegNo);

		if (count == 0) {
			return null;
		}

		List<InvtoryDetails> list = findBydlrregnoFinder(
			dlrRegNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the invtory detailses before and after the current invtory details in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param inventoryId the primary key of the current invtory details
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next invtory details
	 * @throws NoSuchInvtoryDetailsException if a invtory details with the primary key could not be found
	 */
	@Override
	public InvtoryDetails[] findBydlrregnoFinder_PrevAndNext(
			long inventoryId, long dlrRegNo,
			OrderByComparator<InvtoryDetails> orderByComparator)
		throws NoSuchInvtoryDetailsException {

		InvtoryDetails invtoryDetails = findByPrimaryKey(inventoryId);

		Session session = null;

		try {
			session = openSession();

			InvtoryDetails[] array = new InvtoryDetailsImpl[3];

			array[0] = getBydlrregnoFinder_PrevAndNext(
				session, invtoryDetails, dlrRegNo, orderByComparator, true);

			array[1] = invtoryDetails;

			array[2] = getBydlrregnoFinder_PrevAndNext(
				session, invtoryDetails, dlrRegNo, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected InvtoryDetails getBydlrregnoFinder_PrevAndNext(
		Session session, InvtoryDetails invtoryDetails, long dlrRegNo,
		OrderByComparator<InvtoryDetails> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_INVTORYDETAILS_WHERE);

		sb.append(_FINDER_COLUMN_DLRREGNOFINDER_DLRREGNO_2);

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
			sb.append(InvtoryDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(dlrRegNo);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						invtoryDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<InvtoryDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the invtory detailses where dlrRegNo = &#63; from the database.
	 *
	 * @param dlrRegNo the dlr reg no
	 */
	@Override
	public void removeBydlrregnoFinder(long dlrRegNo) {
		for (InvtoryDetails invtoryDetails :
				findBydlrregnoFinder(
					dlrRegNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(invtoryDetails);
		}
	}

	/**
	 * Returns the number of invtory detailses where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the number of matching invtory detailses
	 */
	@Override
	public int countBydlrregnoFinder(long dlrRegNo) {
		FinderPath finderPath = _finderPathCountBydlrregnoFinder;

		Object[] finderArgs = new Object[] {dlrRegNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_INVTORYDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_DLRREGNOFINDER_DLRREGNO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dlrRegNo);

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

	private static final String _FINDER_COLUMN_DLRREGNOFINDER_DLRREGNO_2 =
		"invtoryDetails.dlrRegNo = ?";

	private FinderPath _finderPathWithPaginationFindByallcntfynoFinder;
	private FinderPath _finderPathWithoutPaginationFindByallcntfynoFinder;
	private FinderPath _finderPathCountByallcntfynoFinder;

	/**
	 * Returns all the invtory detailses where allcNtfyNo = &#63;.
	 *
	 * @param allcNtfyNo the allc ntfy no
	 * @return the matching invtory detailses
	 */
	@Override
	public List<InvtoryDetails> findByallcntfynoFinder(long allcNtfyNo) {
		return findByallcntfynoFinder(
			allcNtfyNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the invtory detailses where allcNtfyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvtoryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param allcNtfyNo the allc ntfy no
	 * @param start the lower bound of the range of invtory detailses
	 * @param end the upper bound of the range of invtory detailses (not inclusive)
	 * @return the range of matching invtory detailses
	 */
	@Override
	public List<InvtoryDetails> findByallcntfynoFinder(
		long allcNtfyNo, int start, int end) {

		return findByallcntfynoFinder(allcNtfyNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the invtory detailses where allcNtfyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvtoryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param allcNtfyNo the allc ntfy no
	 * @param start the lower bound of the range of invtory detailses
	 * @param end the upper bound of the range of invtory detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching invtory detailses
	 */
	@Override
	public List<InvtoryDetails> findByallcntfynoFinder(
		long allcNtfyNo, int start, int end,
		OrderByComparator<InvtoryDetails> orderByComparator) {

		return findByallcntfynoFinder(
			allcNtfyNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the invtory detailses where allcNtfyNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvtoryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param allcNtfyNo the allc ntfy no
	 * @param start the lower bound of the range of invtory detailses
	 * @param end the upper bound of the range of invtory detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching invtory detailses
	 */
	@Override
	public List<InvtoryDetails> findByallcntfynoFinder(
		long allcNtfyNo, int start, int end,
		OrderByComparator<InvtoryDetails> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByallcntfynoFinder;
				finderArgs = new Object[] {allcNtfyNo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByallcntfynoFinder;
			finderArgs = new Object[] {
				allcNtfyNo, start, end, orderByComparator
			};
		}

		List<InvtoryDetails> list = null;

		if (useFinderCache) {
			list = (List<InvtoryDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (InvtoryDetails invtoryDetails : list) {
					if (allcNtfyNo != invtoryDetails.getAllcNtfyNo()) {
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

			sb.append(_SQL_SELECT_INVTORYDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_ALLCNTFYNOFINDER_ALLCNTFYNO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(InvtoryDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(allcNtfyNo);

				list = (List<InvtoryDetails>)QueryUtil.list(
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
	 * Returns the first invtory details in the ordered set where allcNtfyNo = &#63;.
	 *
	 * @param allcNtfyNo the allc ntfy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invtory details
	 * @throws NoSuchInvtoryDetailsException if a matching invtory details could not be found
	 */
	@Override
	public InvtoryDetails findByallcntfynoFinder_First(
			long allcNtfyNo,
			OrderByComparator<InvtoryDetails> orderByComparator)
		throws NoSuchInvtoryDetailsException {

		InvtoryDetails invtoryDetails = fetchByallcntfynoFinder_First(
			allcNtfyNo, orderByComparator);

		if (invtoryDetails != null) {
			return invtoryDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("allcNtfyNo=");
		sb.append(allcNtfyNo);

		sb.append("}");

		throw new NoSuchInvtoryDetailsException(sb.toString());
	}

	/**
	 * Returns the first invtory details in the ordered set where allcNtfyNo = &#63;.
	 *
	 * @param allcNtfyNo the allc ntfy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invtory details, or <code>null</code> if a matching invtory details could not be found
	 */
	@Override
	public InvtoryDetails fetchByallcntfynoFinder_First(
		long allcNtfyNo, OrderByComparator<InvtoryDetails> orderByComparator) {

		List<InvtoryDetails> list = findByallcntfynoFinder(
			allcNtfyNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last invtory details in the ordered set where allcNtfyNo = &#63;.
	 *
	 * @param allcNtfyNo the allc ntfy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invtory details
	 * @throws NoSuchInvtoryDetailsException if a matching invtory details could not be found
	 */
	@Override
	public InvtoryDetails findByallcntfynoFinder_Last(
			long allcNtfyNo,
			OrderByComparator<InvtoryDetails> orderByComparator)
		throws NoSuchInvtoryDetailsException {

		InvtoryDetails invtoryDetails = fetchByallcntfynoFinder_Last(
			allcNtfyNo, orderByComparator);

		if (invtoryDetails != null) {
			return invtoryDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("allcNtfyNo=");
		sb.append(allcNtfyNo);

		sb.append("}");

		throw new NoSuchInvtoryDetailsException(sb.toString());
	}

	/**
	 * Returns the last invtory details in the ordered set where allcNtfyNo = &#63;.
	 *
	 * @param allcNtfyNo the allc ntfy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invtory details, or <code>null</code> if a matching invtory details could not be found
	 */
	@Override
	public InvtoryDetails fetchByallcntfynoFinder_Last(
		long allcNtfyNo, OrderByComparator<InvtoryDetails> orderByComparator) {

		int count = countByallcntfynoFinder(allcNtfyNo);

		if (count == 0) {
			return null;
		}

		List<InvtoryDetails> list = findByallcntfynoFinder(
			allcNtfyNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the invtory detailses before and after the current invtory details in the ordered set where allcNtfyNo = &#63;.
	 *
	 * @param inventoryId the primary key of the current invtory details
	 * @param allcNtfyNo the allc ntfy no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next invtory details
	 * @throws NoSuchInvtoryDetailsException if a invtory details with the primary key could not be found
	 */
	@Override
	public InvtoryDetails[] findByallcntfynoFinder_PrevAndNext(
			long inventoryId, long allcNtfyNo,
			OrderByComparator<InvtoryDetails> orderByComparator)
		throws NoSuchInvtoryDetailsException {

		InvtoryDetails invtoryDetails = findByPrimaryKey(inventoryId);

		Session session = null;

		try {
			session = openSession();

			InvtoryDetails[] array = new InvtoryDetailsImpl[3];

			array[0] = getByallcntfynoFinder_PrevAndNext(
				session, invtoryDetails, allcNtfyNo, orderByComparator, true);

			array[1] = invtoryDetails;

			array[2] = getByallcntfynoFinder_PrevAndNext(
				session, invtoryDetails, allcNtfyNo, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected InvtoryDetails getByallcntfynoFinder_PrevAndNext(
		Session session, InvtoryDetails invtoryDetails, long allcNtfyNo,
		OrderByComparator<InvtoryDetails> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_INVTORYDETAILS_WHERE);

		sb.append(_FINDER_COLUMN_ALLCNTFYNOFINDER_ALLCNTFYNO_2);

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
			sb.append(InvtoryDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(allcNtfyNo);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						invtoryDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<InvtoryDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the invtory detailses where allcNtfyNo = &#63; from the database.
	 *
	 * @param allcNtfyNo the allc ntfy no
	 */
	@Override
	public void removeByallcntfynoFinder(long allcNtfyNo) {
		for (InvtoryDetails invtoryDetails :
				findByallcntfynoFinder(
					allcNtfyNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(invtoryDetails);
		}
	}

	/**
	 * Returns the number of invtory detailses where allcNtfyNo = &#63;.
	 *
	 * @param allcNtfyNo the allc ntfy no
	 * @return the number of matching invtory detailses
	 */
	@Override
	public int countByallcntfynoFinder(long allcNtfyNo) {
		FinderPath finderPath = _finderPathCountByallcntfynoFinder;

		Object[] finderArgs = new Object[] {allcNtfyNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_INVTORYDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_ALLCNTFYNOFINDER_ALLCNTFYNO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(allcNtfyNo);

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

	private static final String _FINDER_COLUMN_ALLCNTFYNOFINDER_ALLCNTFYNO_2 =
		"invtoryDetails.allcNtfyNo = ?";

	public InvtoryDetailsPersistenceImpl() {
		setModelClass(InvtoryDetails.class);

		setModelImplClass(InvtoryDetailsImpl.class);
		setModelPKClass(long.class);

		setTable(InvtoryDetailsTable.INSTANCE);
	}

	/**
	 * Caches the invtory details in the entity cache if it is enabled.
	 *
	 * @param invtoryDetails the invtory details
	 */
	@Override
	public void cacheResult(InvtoryDetails invtoryDetails) {
		entityCache.putResult(
			InvtoryDetailsImpl.class, invtoryDetails.getPrimaryKey(),
			invtoryDetails);

		finderCache.putResult(
			_finderPathFetchByinventoryidFinder,
			new Object[] {invtoryDetails.getInventoryId()}, invtoryDetails);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the invtory detailses in the entity cache if it is enabled.
	 *
	 * @param invtoryDetailses the invtory detailses
	 */
	@Override
	public void cacheResult(List<InvtoryDetails> invtoryDetailses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (invtoryDetailses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (InvtoryDetails invtoryDetails : invtoryDetailses) {
			if (entityCache.getResult(
					InvtoryDetailsImpl.class, invtoryDetails.getPrimaryKey()) ==
						null) {

				cacheResult(invtoryDetails);
			}
		}
	}

	/**
	 * Clears the cache for all invtory detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(InvtoryDetailsImpl.class);

		finderCache.clearCache(InvtoryDetailsImpl.class);
	}

	/**
	 * Clears the cache for the invtory details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(InvtoryDetails invtoryDetails) {
		entityCache.removeResult(InvtoryDetailsImpl.class, invtoryDetails);
	}

	@Override
	public void clearCache(List<InvtoryDetails> invtoryDetailses) {
		for (InvtoryDetails invtoryDetails : invtoryDetailses) {
			entityCache.removeResult(InvtoryDetailsImpl.class, invtoryDetails);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(InvtoryDetailsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(InvtoryDetailsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		InvtoryDetailsModelImpl invtoryDetailsModelImpl) {

		Object[] args = new Object[] {invtoryDetailsModelImpl.getInventoryId()};

		finderCache.putResult(
			_finderPathCountByinventoryidFinder, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByinventoryidFinder, args, invtoryDetailsModelImpl);
	}

	/**
	 * Creates a new invtory details with the primary key. Does not add the invtory details to the database.
	 *
	 * @param inventoryId the primary key for the new invtory details
	 * @return the new invtory details
	 */
	@Override
	public InvtoryDetails create(long inventoryId) {
		InvtoryDetails invtoryDetails = new InvtoryDetailsImpl();

		invtoryDetails.setNew(true);
		invtoryDetails.setPrimaryKey(inventoryId);

		invtoryDetails.setCompanyId(CompanyThreadLocal.getCompanyId());

		return invtoryDetails;
	}

	/**
	 * Removes the invtory details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param inventoryId the primary key of the invtory details
	 * @return the invtory details that was removed
	 * @throws NoSuchInvtoryDetailsException if a invtory details with the primary key could not be found
	 */
	@Override
	public InvtoryDetails remove(long inventoryId)
		throws NoSuchInvtoryDetailsException {

		return remove((Serializable)inventoryId);
	}

	/**
	 * Removes the invtory details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the invtory details
	 * @return the invtory details that was removed
	 * @throws NoSuchInvtoryDetailsException if a invtory details with the primary key could not be found
	 */
	@Override
	public InvtoryDetails remove(Serializable primaryKey)
		throws NoSuchInvtoryDetailsException {

		Session session = null;

		try {
			session = openSession();

			InvtoryDetails invtoryDetails = (InvtoryDetails)session.get(
				InvtoryDetailsImpl.class, primaryKey);

			if (invtoryDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInvtoryDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(invtoryDetails);
		}
		catch (NoSuchInvtoryDetailsException noSuchEntityException) {
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
	protected InvtoryDetails removeImpl(InvtoryDetails invtoryDetails) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(invtoryDetails)) {
				invtoryDetails = (InvtoryDetails)session.get(
					InvtoryDetailsImpl.class,
					invtoryDetails.getPrimaryKeyObj());
			}

			if (invtoryDetails != null) {
				session.delete(invtoryDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (invtoryDetails != null) {
			clearCache(invtoryDetails);
		}

		return invtoryDetails;
	}

	@Override
	public InvtoryDetails updateImpl(InvtoryDetails invtoryDetails) {
		boolean isNew = invtoryDetails.isNew();

		if (!(invtoryDetails instanceof InvtoryDetailsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(invtoryDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					invtoryDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in invtoryDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom InvtoryDetails implementation " +
					invtoryDetails.getClass());
		}

		InvtoryDetailsModelImpl invtoryDetailsModelImpl =
			(InvtoryDetailsModelImpl)invtoryDetails;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(invtoryDetails);
			}
			else {
				invtoryDetails = (InvtoryDetails)session.merge(invtoryDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			InvtoryDetailsImpl.class, invtoryDetailsModelImpl, false, true);

		cacheUniqueFindersCache(invtoryDetailsModelImpl);

		if (isNew) {
			invtoryDetails.setNew(false);
		}

		invtoryDetails.resetOriginalValues();

		return invtoryDetails;
	}

	/**
	 * Returns the invtory details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the invtory details
	 * @return the invtory details
	 * @throws NoSuchInvtoryDetailsException if a invtory details with the primary key could not be found
	 */
	@Override
	public InvtoryDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInvtoryDetailsException {

		InvtoryDetails invtoryDetails = fetchByPrimaryKey(primaryKey);

		if (invtoryDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInvtoryDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return invtoryDetails;
	}

	/**
	 * Returns the invtory details with the primary key or throws a <code>NoSuchInvtoryDetailsException</code> if it could not be found.
	 *
	 * @param inventoryId the primary key of the invtory details
	 * @return the invtory details
	 * @throws NoSuchInvtoryDetailsException if a invtory details with the primary key could not be found
	 */
	@Override
	public InvtoryDetails findByPrimaryKey(long inventoryId)
		throws NoSuchInvtoryDetailsException {

		return findByPrimaryKey((Serializable)inventoryId);
	}

	/**
	 * Returns the invtory details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param inventoryId the primary key of the invtory details
	 * @return the invtory details, or <code>null</code> if a invtory details with the primary key could not be found
	 */
	@Override
	public InvtoryDetails fetchByPrimaryKey(long inventoryId) {
		return fetchByPrimaryKey((Serializable)inventoryId);
	}

	/**
	 * Returns all the invtory detailses.
	 *
	 * @return the invtory detailses
	 */
	@Override
	public List<InvtoryDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the invtory detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvtoryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of invtory detailses
	 * @param end the upper bound of the range of invtory detailses (not inclusive)
	 * @return the range of invtory detailses
	 */
	@Override
	public List<InvtoryDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the invtory detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvtoryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of invtory detailses
	 * @param end the upper bound of the range of invtory detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of invtory detailses
	 */
	@Override
	public List<InvtoryDetails> findAll(
		int start, int end,
		OrderByComparator<InvtoryDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the invtory detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvtoryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of invtory detailses
	 * @param end the upper bound of the range of invtory detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of invtory detailses
	 */
	@Override
	public List<InvtoryDetails> findAll(
		int start, int end, OrderByComparator<InvtoryDetails> orderByComparator,
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

		List<InvtoryDetails> list = null;

		if (useFinderCache) {
			list = (List<InvtoryDetails>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_INVTORYDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_INVTORYDETAILS;

				sql = sql.concat(InvtoryDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<InvtoryDetails>)QueryUtil.list(
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
	 * Removes all the invtory detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (InvtoryDetails invtoryDetails : findAll()) {
			remove(invtoryDetails);
		}
	}

	/**
	 * Returns the number of invtory detailses.
	 *
	 * @return the number of invtory detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_INVTORYDETAILS);

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
		return "inventoryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_INVTORYDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return InvtoryDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the invtory details persistence.
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

		_finderPathFetchByinventoryidFinder = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByinventoryidFinder",
			new String[] {Long.class.getName()}, new String[] {"inventoryId"},
			true);

		_finderPathCountByinventoryidFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByinventoryidFinder", new String[] {Long.class.getName()},
			new String[] {"inventoryId"}, false);

		_finderPathWithPaginationFindBydlrregnoFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBydlrregnoFinder",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"dlrRegNo"}, true);

		_finderPathWithoutPaginationFindBydlrregnoFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBydlrregnoFinder",
			new String[] {Long.class.getName()}, new String[] {"dlrRegNo"},
			true);

		_finderPathCountBydlrregnoFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydlrregnoFinder",
			new String[] {Long.class.getName()}, new String[] {"dlrRegNo"},
			false);

		_finderPathWithPaginationFindByallcntfynoFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByallcntfynoFinder",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"allcNtfyNo"}, true);

		_finderPathWithoutPaginationFindByallcntfynoFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByallcntfynoFinder",
			new String[] {Long.class.getName()}, new String[] {"allcNtfyNo"},
			true);

		_finderPathCountByallcntfynoFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByallcntfynoFinder", new String[] {Long.class.getName()},
			new String[] {"allcNtfyNo"}, false);

		_setInvtoryDetailsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setInvtoryDetailsUtilPersistence(null);

		entityCache.removeCache(InvtoryDetailsImpl.class.getName());
	}

	private void _setInvtoryDetailsUtilPersistence(
		InvtoryDetailsPersistence invtoryDetailsPersistence) {

		try {
			Field field = InvtoryDetailsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, invtoryDetailsPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = FFPBPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = FFPBPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = FFPBPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_INVTORYDETAILS =
		"SELECT invtoryDetails FROM InvtoryDetails invtoryDetails";

	private static final String _SQL_SELECT_INVTORYDETAILS_WHERE =
		"SELECT invtoryDetails FROM InvtoryDetails invtoryDetails WHERE ";

	private static final String _SQL_COUNT_INVTORYDETAILS =
		"SELECT COUNT(invtoryDetails) FROM InvtoryDetails invtoryDetails";

	private static final String _SQL_COUNT_INVTORYDETAILS_WHERE =
		"SELECT COUNT(invtoryDetails) FROM InvtoryDetails invtoryDetails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "invtoryDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No InvtoryDetails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No InvtoryDetails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		InvtoryDetailsPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}