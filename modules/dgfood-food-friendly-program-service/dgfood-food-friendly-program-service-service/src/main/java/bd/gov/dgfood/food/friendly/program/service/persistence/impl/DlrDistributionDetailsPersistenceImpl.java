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

import bd.gov.dgfood.food.friendly.program.exception.NoSuchDlrDistributionDetailsException;
import bd.gov.dgfood.food.friendly.program.model.DlrDistributionDetails;
import bd.gov.dgfood.food.friendly.program.model.DlrDistributionDetailsTable;
import bd.gov.dgfood.food.friendly.program.model.impl.DlrDistributionDetailsImpl;
import bd.gov.dgfood.food.friendly.program.model.impl.DlrDistributionDetailsModelImpl;
import bd.gov.dgfood.food.friendly.program.service.persistence.DlrDistributionDetailsPersistence;
import bd.gov.dgfood.food.friendly.program.service.persistence.DlrDistributionDetailsUtil;
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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
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
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the dlr distribution details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DlrDistributionDetailsPersistence.class)
public class DlrDistributionDetailsPersistenceImpl
	extends BasePersistenceImpl<DlrDistributionDetails>
	implements DlrDistributionDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DlrDistributionDetailsUtil</code> to access the dlr distribution details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DlrDistributionDetailsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBydstrbnIdFinder;
	private FinderPath _finderPathCountBydstrbnIdFinder;

	/**
	 * Returns the dlr distribution details where dstrbnId = &#63; or throws a <code>NoSuchDlrDistributionDetailsException</code> if it could not be found.
	 *
	 * @param dstrbnId the dstrbn ID
	 * @return the matching dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a matching dlr distribution details could not be found
	 */
	@Override
	public DlrDistributionDetails findBydstrbnIdFinder(long dstrbnId)
		throws NoSuchDlrDistributionDetailsException {

		DlrDistributionDetails dlrDistributionDetails = fetchBydstrbnIdFinder(
			dstrbnId);

		if (dlrDistributionDetails == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("dstrbnId=");
			sb.append(dstrbnId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDlrDistributionDetailsException(sb.toString());
		}

		return dlrDistributionDetails;
	}

	/**
	 * Returns the dlr distribution details where dstrbnId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dstrbnId the dstrbn ID
	 * @return the matching dlr distribution details, or <code>null</code> if a matching dlr distribution details could not be found
	 */
	@Override
	public DlrDistributionDetails fetchBydstrbnIdFinder(long dstrbnId) {
		return fetchBydstrbnIdFinder(dstrbnId, true);
	}

	/**
	 * Returns the dlr distribution details where dstrbnId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dstrbnId the dstrbn ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dlr distribution details, or <code>null</code> if a matching dlr distribution details could not be found
	 */
	@Override
	public DlrDistributionDetails fetchBydstrbnIdFinder(
		long dstrbnId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {dstrbnId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBydstrbnIdFinder, finderArgs, this);
		}

		if (result instanceof DlrDistributionDetails) {
			DlrDistributionDetails dlrDistributionDetails =
				(DlrDistributionDetails)result;

			if (dstrbnId != dlrDistributionDetails.getDstrbnId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DLRDISTRIBUTIONDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_DSTRBNIDFINDER_DSTRBNID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dstrbnId);

				List<DlrDistributionDetails> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBydstrbnIdFinder, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {dstrbnId};
							}

							_log.warn(
								"DlrDistributionDetailsPersistenceImpl.fetchBydstrbnIdFinder(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DlrDistributionDetails dlrDistributionDetails = list.get(0);

					result = dlrDistributionDetails;

					cacheResult(dlrDistributionDetails);
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
			return (DlrDistributionDetails)result;
		}
	}

	/**
	 * Removes the dlr distribution details where dstrbnId = &#63; from the database.
	 *
	 * @param dstrbnId the dstrbn ID
	 * @return the dlr distribution details that was removed
	 */
	@Override
	public DlrDistributionDetails removeBydstrbnIdFinder(long dstrbnId)
		throws NoSuchDlrDistributionDetailsException {

		DlrDistributionDetails dlrDistributionDetails = findBydstrbnIdFinder(
			dstrbnId);

		return remove(dlrDistributionDetails);
	}

	/**
	 * Returns the number of dlr distribution detailses where dstrbnId = &#63;.
	 *
	 * @param dstrbnId the dstrbn ID
	 * @return the number of matching dlr distribution detailses
	 */
	@Override
	public int countBydstrbnIdFinder(long dstrbnId) {
		FinderPath finderPath = _finderPathCountBydstrbnIdFinder;

		Object[] finderArgs = new Object[] {dstrbnId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DLRDISTRIBUTIONDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_DSTRBNIDFINDER_DSTRBNID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dstrbnId);

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

	private static final String _FINDER_COLUMN_DSTRBNIDFINDER_DSTRBNID_2 =
		"dlrDistributionDetails.dstrbnId = ?";

	private FinderPath _finderPathWithPaginationFindBydlrregnoFinder;
	private FinderPath _finderPathWithoutPaginationFindBydlrregnoFinder;
	private FinderPath _finderPathCountBydlrregnoFinder;

	/**
	 * Returns all the dlr distribution detailses where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the matching dlr distribution detailses
	 */
	@Override
	public List<DlrDistributionDetails> findBydlrregnoFinder(long dlrRegNo) {
		return findBydlrregnoFinder(
			dlrRegNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dlr distribution detailses where dlrRegNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DlrDistributionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param start the lower bound of the range of dlr distribution detailses
	 * @param end the upper bound of the range of dlr distribution detailses (not inclusive)
	 * @return the range of matching dlr distribution detailses
	 */
	@Override
	public List<DlrDistributionDetails> findBydlrregnoFinder(
		long dlrRegNo, int start, int end) {

		return findBydlrregnoFinder(dlrRegNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dlr distribution detailses where dlrRegNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DlrDistributionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param start the lower bound of the range of dlr distribution detailses
	 * @param end the upper bound of the range of dlr distribution detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dlr distribution detailses
	 */
	@Override
	public List<DlrDistributionDetails> findBydlrregnoFinder(
		long dlrRegNo, int start, int end,
		OrderByComparator<DlrDistributionDetails> orderByComparator) {

		return findBydlrregnoFinder(
			dlrRegNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dlr distribution detailses where dlrRegNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DlrDistributionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param start the lower bound of the range of dlr distribution detailses
	 * @param end the upper bound of the range of dlr distribution detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dlr distribution detailses
	 */
	@Override
	public List<DlrDistributionDetails> findBydlrregnoFinder(
		long dlrRegNo, int start, int end,
		OrderByComparator<DlrDistributionDetails> orderByComparator,
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

		List<DlrDistributionDetails> list = null;

		if (useFinderCache) {
			list = (List<DlrDistributionDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DlrDistributionDetails dlrDistributionDetails : list) {
					if (dlrRegNo != dlrDistributionDetails.getDlrRegNo()) {
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

			sb.append(_SQL_SELECT_DLRDISTRIBUTIONDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_DLRREGNOFINDER_DLRREGNO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DlrDistributionDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dlrRegNo);

				list = (List<DlrDistributionDetails>)QueryUtil.list(
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
	 * Returns the first dlr distribution details in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a matching dlr distribution details could not be found
	 */
	@Override
	public DlrDistributionDetails findBydlrregnoFinder_First(
			long dlrRegNo,
			OrderByComparator<DlrDistributionDetails> orderByComparator)
		throws NoSuchDlrDistributionDetailsException {

		DlrDistributionDetails dlrDistributionDetails =
			fetchBydlrregnoFinder_First(dlrRegNo, orderByComparator);

		if (dlrDistributionDetails != null) {
			return dlrDistributionDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dlrRegNo=");
		sb.append(dlrRegNo);

		sb.append("}");

		throw new NoSuchDlrDistributionDetailsException(sb.toString());
	}

	/**
	 * Returns the first dlr distribution details in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dlr distribution details, or <code>null</code> if a matching dlr distribution details could not be found
	 */
	@Override
	public DlrDistributionDetails fetchBydlrregnoFinder_First(
		long dlrRegNo,
		OrderByComparator<DlrDistributionDetails> orderByComparator) {

		List<DlrDistributionDetails> list = findBydlrregnoFinder(
			dlrRegNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dlr distribution details in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a matching dlr distribution details could not be found
	 */
	@Override
	public DlrDistributionDetails findBydlrregnoFinder_Last(
			long dlrRegNo,
			OrderByComparator<DlrDistributionDetails> orderByComparator)
		throws NoSuchDlrDistributionDetailsException {

		DlrDistributionDetails dlrDistributionDetails =
			fetchBydlrregnoFinder_Last(dlrRegNo, orderByComparator);

		if (dlrDistributionDetails != null) {
			return dlrDistributionDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dlrRegNo=");
		sb.append(dlrRegNo);

		sb.append("}");

		throw new NoSuchDlrDistributionDetailsException(sb.toString());
	}

	/**
	 * Returns the last dlr distribution details in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dlr distribution details, or <code>null</code> if a matching dlr distribution details could not be found
	 */
	@Override
	public DlrDistributionDetails fetchBydlrregnoFinder_Last(
		long dlrRegNo,
		OrderByComparator<DlrDistributionDetails> orderByComparator) {

		int count = countBydlrregnoFinder(dlrRegNo);

		if (count == 0) {
			return null;
		}

		List<DlrDistributionDetails> list = findBydlrregnoFinder(
			dlrRegNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dlr distribution detailses before and after the current dlr distribution details in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dstrbnId the primary key of the current dlr distribution details
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a dlr distribution details with the primary key could not be found
	 */
	@Override
	public DlrDistributionDetails[] findBydlrregnoFinder_PrevAndNext(
			long dstrbnId, long dlrRegNo,
			OrderByComparator<DlrDistributionDetails> orderByComparator)
		throws NoSuchDlrDistributionDetailsException {

		DlrDistributionDetails dlrDistributionDetails = findByPrimaryKey(
			dstrbnId);

		Session session = null;

		try {
			session = openSession();

			DlrDistributionDetails[] array = new DlrDistributionDetailsImpl[3];

			array[0] = getBydlrregnoFinder_PrevAndNext(
				session, dlrDistributionDetails, dlrRegNo, orderByComparator,
				true);

			array[1] = dlrDistributionDetails;

			array[2] = getBydlrregnoFinder_PrevAndNext(
				session, dlrDistributionDetails, dlrRegNo, orderByComparator,
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

	protected DlrDistributionDetails getBydlrregnoFinder_PrevAndNext(
		Session session, DlrDistributionDetails dlrDistributionDetails,
		long dlrRegNo,
		OrderByComparator<DlrDistributionDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_DLRDISTRIBUTIONDETAILS_WHERE);

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
			sb.append(DlrDistributionDetailsModelImpl.ORDER_BY_JPQL);
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
						dlrDistributionDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DlrDistributionDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dlr distribution detailses where dlrRegNo = &#63; from the database.
	 *
	 * @param dlrRegNo the dlr reg no
	 */
	@Override
	public void removeBydlrregnoFinder(long dlrRegNo) {
		for (DlrDistributionDetails dlrDistributionDetails :
				findBydlrregnoFinder(
					dlrRegNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dlrDistributionDetails);
		}
	}

	/**
	 * Returns the number of dlr distribution detailses where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the number of matching dlr distribution detailses
	 */
	@Override
	public int countBydlrregnoFinder(long dlrRegNo) {
		FinderPath finderPath = _finderPathCountBydlrregnoFinder;

		Object[] finderArgs = new Object[] {dlrRegNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DLRDISTRIBUTIONDETAILS_WHERE);

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
		"dlrDistributionDetails.dlrRegNo = ?";

	private FinderPath _finderPathWithPaginationFindByffpregstridFinder;
	private FinderPath _finderPathWithoutPaginationFindByffpregstridFinder;
	private FinderPath _finderPathCountByffpregstridFinder;

	/**
	 * Returns all the dlr distribution detailses where ffpRegstrId = &#63;.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @return the matching dlr distribution detailses
	 */
	@Override
	public List<DlrDistributionDetails> findByffpregstridFinder(
		long ffpRegstrId) {

		return findByffpregstridFinder(
			ffpRegstrId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dlr distribution detailses where ffpRegstrId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DlrDistributionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @param start the lower bound of the range of dlr distribution detailses
	 * @param end the upper bound of the range of dlr distribution detailses (not inclusive)
	 * @return the range of matching dlr distribution detailses
	 */
	@Override
	public List<DlrDistributionDetails> findByffpregstridFinder(
		long ffpRegstrId, int start, int end) {

		return findByffpregstridFinder(ffpRegstrId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dlr distribution detailses where ffpRegstrId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DlrDistributionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @param start the lower bound of the range of dlr distribution detailses
	 * @param end the upper bound of the range of dlr distribution detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dlr distribution detailses
	 */
	@Override
	public List<DlrDistributionDetails> findByffpregstridFinder(
		long ffpRegstrId, int start, int end,
		OrderByComparator<DlrDistributionDetails> orderByComparator) {

		return findByffpregstridFinder(
			ffpRegstrId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dlr distribution detailses where ffpRegstrId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DlrDistributionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @param start the lower bound of the range of dlr distribution detailses
	 * @param end the upper bound of the range of dlr distribution detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dlr distribution detailses
	 */
	@Override
	public List<DlrDistributionDetails> findByffpregstridFinder(
		long ffpRegstrId, int start, int end,
		OrderByComparator<DlrDistributionDetails> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByffpregstridFinder;
				finderArgs = new Object[] {ffpRegstrId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByffpregstridFinder;
			finderArgs = new Object[] {
				ffpRegstrId, start, end, orderByComparator
			};
		}

		List<DlrDistributionDetails> list = null;

		if (useFinderCache) {
			list = (List<DlrDistributionDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DlrDistributionDetails dlrDistributionDetails : list) {
					if (ffpRegstrId !=
							dlrDistributionDetails.getFfpRegstrId()) {

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

			sb.append(_SQL_SELECT_DLRDISTRIBUTIONDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_FFPREGSTRIDFINDER_FFPREGSTRID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DlrDistributionDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(ffpRegstrId);

				list = (List<DlrDistributionDetails>)QueryUtil.list(
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
	 * Returns the first dlr distribution details in the ordered set where ffpRegstrId = &#63;.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a matching dlr distribution details could not be found
	 */
	@Override
	public DlrDistributionDetails findByffpregstridFinder_First(
			long ffpRegstrId,
			OrderByComparator<DlrDistributionDetails> orderByComparator)
		throws NoSuchDlrDistributionDetailsException {

		DlrDistributionDetails dlrDistributionDetails =
			fetchByffpregstridFinder_First(ffpRegstrId, orderByComparator);

		if (dlrDistributionDetails != null) {
			return dlrDistributionDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ffpRegstrId=");
		sb.append(ffpRegstrId);

		sb.append("}");

		throw new NoSuchDlrDistributionDetailsException(sb.toString());
	}

	/**
	 * Returns the first dlr distribution details in the ordered set where ffpRegstrId = &#63;.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dlr distribution details, or <code>null</code> if a matching dlr distribution details could not be found
	 */
	@Override
	public DlrDistributionDetails fetchByffpregstridFinder_First(
		long ffpRegstrId,
		OrderByComparator<DlrDistributionDetails> orderByComparator) {

		List<DlrDistributionDetails> list = findByffpregstridFinder(
			ffpRegstrId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dlr distribution details in the ordered set where ffpRegstrId = &#63;.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a matching dlr distribution details could not be found
	 */
	@Override
	public DlrDistributionDetails findByffpregstridFinder_Last(
			long ffpRegstrId,
			OrderByComparator<DlrDistributionDetails> orderByComparator)
		throws NoSuchDlrDistributionDetailsException {

		DlrDistributionDetails dlrDistributionDetails =
			fetchByffpregstridFinder_Last(ffpRegstrId, orderByComparator);

		if (dlrDistributionDetails != null) {
			return dlrDistributionDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ffpRegstrId=");
		sb.append(ffpRegstrId);

		sb.append("}");

		throw new NoSuchDlrDistributionDetailsException(sb.toString());
	}

	/**
	 * Returns the last dlr distribution details in the ordered set where ffpRegstrId = &#63;.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dlr distribution details, or <code>null</code> if a matching dlr distribution details could not be found
	 */
	@Override
	public DlrDistributionDetails fetchByffpregstridFinder_Last(
		long ffpRegstrId,
		OrderByComparator<DlrDistributionDetails> orderByComparator) {

		int count = countByffpregstridFinder(ffpRegstrId);

		if (count == 0) {
			return null;
		}

		List<DlrDistributionDetails> list = findByffpregstridFinder(
			ffpRegstrId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dlr distribution detailses before and after the current dlr distribution details in the ordered set where ffpRegstrId = &#63;.
	 *
	 * @param dstrbnId the primary key of the current dlr distribution details
	 * @param ffpRegstrId the ffp regstr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a dlr distribution details with the primary key could not be found
	 */
	@Override
	public DlrDistributionDetails[] findByffpregstridFinder_PrevAndNext(
			long dstrbnId, long ffpRegstrId,
			OrderByComparator<DlrDistributionDetails> orderByComparator)
		throws NoSuchDlrDistributionDetailsException {

		DlrDistributionDetails dlrDistributionDetails = findByPrimaryKey(
			dstrbnId);

		Session session = null;

		try {
			session = openSession();

			DlrDistributionDetails[] array = new DlrDistributionDetailsImpl[3];

			array[0] = getByffpregstridFinder_PrevAndNext(
				session, dlrDistributionDetails, ffpRegstrId, orderByComparator,
				true);

			array[1] = dlrDistributionDetails;

			array[2] = getByffpregstridFinder_PrevAndNext(
				session, dlrDistributionDetails, ffpRegstrId, orderByComparator,
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

	protected DlrDistributionDetails getByffpregstridFinder_PrevAndNext(
		Session session, DlrDistributionDetails dlrDistributionDetails,
		long ffpRegstrId,
		OrderByComparator<DlrDistributionDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_DLRDISTRIBUTIONDETAILS_WHERE);

		sb.append(_FINDER_COLUMN_FFPREGSTRIDFINDER_FFPREGSTRID_2);

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
			sb.append(DlrDistributionDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(ffpRegstrId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dlrDistributionDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DlrDistributionDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dlr distribution detailses where ffpRegstrId = &#63; from the database.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 */
	@Override
	public void removeByffpregstridFinder(long ffpRegstrId) {
		for (DlrDistributionDetails dlrDistributionDetails :
				findByffpregstridFinder(
					ffpRegstrId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dlrDistributionDetails);
		}
	}

	/**
	 * Returns the number of dlr distribution detailses where ffpRegstrId = &#63;.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @return the number of matching dlr distribution detailses
	 */
	@Override
	public int countByffpregstridFinder(long ffpRegstrId) {
		FinderPath finderPath = _finderPathCountByffpregstridFinder;

		Object[] finderArgs = new Object[] {ffpRegstrId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DLRDISTRIBUTIONDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_FFPREGSTRIDFINDER_FFPREGSTRID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(ffpRegstrId);

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

	private static final String _FINDER_COLUMN_FFPREGSTRIDFINDER_FFPREGSTRID_2 =
		"dlrDistributionDetails.ffpRegstrId = ?";

	private FinderPath _finderPathWithPaginationFindByinventoryidFinder;
	private FinderPath _finderPathWithoutPaginationFindByinventoryidFinder;
	private FinderPath _finderPathCountByinventoryidFinder;

	/**
	 * Returns all the dlr distribution detailses where inventoryId = &#63;.
	 *
	 * @param inventoryId the inventory ID
	 * @return the matching dlr distribution detailses
	 */
	@Override
	public List<DlrDistributionDetails> findByinventoryidFinder(
		long inventoryId) {

		return findByinventoryidFinder(
			inventoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dlr distribution detailses where inventoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DlrDistributionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param inventoryId the inventory ID
	 * @param start the lower bound of the range of dlr distribution detailses
	 * @param end the upper bound of the range of dlr distribution detailses (not inclusive)
	 * @return the range of matching dlr distribution detailses
	 */
	@Override
	public List<DlrDistributionDetails> findByinventoryidFinder(
		long inventoryId, int start, int end) {

		return findByinventoryidFinder(inventoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dlr distribution detailses where inventoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DlrDistributionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param inventoryId the inventory ID
	 * @param start the lower bound of the range of dlr distribution detailses
	 * @param end the upper bound of the range of dlr distribution detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dlr distribution detailses
	 */
	@Override
	public List<DlrDistributionDetails> findByinventoryidFinder(
		long inventoryId, int start, int end,
		OrderByComparator<DlrDistributionDetails> orderByComparator) {

		return findByinventoryidFinder(
			inventoryId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dlr distribution detailses where inventoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DlrDistributionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param inventoryId the inventory ID
	 * @param start the lower bound of the range of dlr distribution detailses
	 * @param end the upper bound of the range of dlr distribution detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dlr distribution detailses
	 */
	@Override
	public List<DlrDistributionDetails> findByinventoryidFinder(
		long inventoryId, int start, int end,
		OrderByComparator<DlrDistributionDetails> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByinventoryidFinder;
				finderArgs = new Object[] {inventoryId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByinventoryidFinder;
			finderArgs = new Object[] {
				inventoryId, start, end, orderByComparator
			};
		}

		List<DlrDistributionDetails> list = null;

		if (useFinderCache) {
			list = (List<DlrDistributionDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DlrDistributionDetails dlrDistributionDetails : list) {
					if (inventoryId !=
							dlrDistributionDetails.getInventoryId()) {

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

			sb.append(_SQL_SELECT_DLRDISTRIBUTIONDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_INVENTORYIDFINDER_INVENTORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DlrDistributionDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(inventoryId);

				list = (List<DlrDistributionDetails>)QueryUtil.list(
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
	 * Returns the first dlr distribution details in the ordered set where inventoryId = &#63;.
	 *
	 * @param inventoryId the inventory ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a matching dlr distribution details could not be found
	 */
	@Override
	public DlrDistributionDetails findByinventoryidFinder_First(
			long inventoryId,
			OrderByComparator<DlrDistributionDetails> orderByComparator)
		throws NoSuchDlrDistributionDetailsException {

		DlrDistributionDetails dlrDistributionDetails =
			fetchByinventoryidFinder_First(inventoryId, orderByComparator);

		if (dlrDistributionDetails != null) {
			return dlrDistributionDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("inventoryId=");
		sb.append(inventoryId);

		sb.append("}");

		throw new NoSuchDlrDistributionDetailsException(sb.toString());
	}

	/**
	 * Returns the first dlr distribution details in the ordered set where inventoryId = &#63;.
	 *
	 * @param inventoryId the inventory ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dlr distribution details, or <code>null</code> if a matching dlr distribution details could not be found
	 */
	@Override
	public DlrDistributionDetails fetchByinventoryidFinder_First(
		long inventoryId,
		OrderByComparator<DlrDistributionDetails> orderByComparator) {

		List<DlrDistributionDetails> list = findByinventoryidFinder(
			inventoryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dlr distribution details in the ordered set where inventoryId = &#63;.
	 *
	 * @param inventoryId the inventory ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a matching dlr distribution details could not be found
	 */
	@Override
	public DlrDistributionDetails findByinventoryidFinder_Last(
			long inventoryId,
			OrderByComparator<DlrDistributionDetails> orderByComparator)
		throws NoSuchDlrDistributionDetailsException {

		DlrDistributionDetails dlrDistributionDetails =
			fetchByinventoryidFinder_Last(inventoryId, orderByComparator);

		if (dlrDistributionDetails != null) {
			return dlrDistributionDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("inventoryId=");
		sb.append(inventoryId);

		sb.append("}");

		throw new NoSuchDlrDistributionDetailsException(sb.toString());
	}

	/**
	 * Returns the last dlr distribution details in the ordered set where inventoryId = &#63;.
	 *
	 * @param inventoryId the inventory ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dlr distribution details, or <code>null</code> if a matching dlr distribution details could not be found
	 */
	@Override
	public DlrDistributionDetails fetchByinventoryidFinder_Last(
		long inventoryId,
		OrderByComparator<DlrDistributionDetails> orderByComparator) {

		int count = countByinventoryidFinder(inventoryId);

		if (count == 0) {
			return null;
		}

		List<DlrDistributionDetails> list = findByinventoryidFinder(
			inventoryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dlr distribution detailses before and after the current dlr distribution details in the ordered set where inventoryId = &#63;.
	 *
	 * @param dstrbnId the primary key of the current dlr distribution details
	 * @param inventoryId the inventory ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a dlr distribution details with the primary key could not be found
	 */
	@Override
	public DlrDistributionDetails[] findByinventoryidFinder_PrevAndNext(
			long dstrbnId, long inventoryId,
			OrderByComparator<DlrDistributionDetails> orderByComparator)
		throws NoSuchDlrDistributionDetailsException {

		DlrDistributionDetails dlrDistributionDetails = findByPrimaryKey(
			dstrbnId);

		Session session = null;

		try {
			session = openSession();

			DlrDistributionDetails[] array = new DlrDistributionDetailsImpl[3];

			array[0] = getByinventoryidFinder_PrevAndNext(
				session, dlrDistributionDetails, inventoryId, orderByComparator,
				true);

			array[1] = dlrDistributionDetails;

			array[2] = getByinventoryidFinder_PrevAndNext(
				session, dlrDistributionDetails, inventoryId, orderByComparator,
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

	protected DlrDistributionDetails getByinventoryidFinder_PrevAndNext(
		Session session, DlrDistributionDetails dlrDistributionDetails,
		long inventoryId,
		OrderByComparator<DlrDistributionDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_DLRDISTRIBUTIONDETAILS_WHERE);

		sb.append(_FINDER_COLUMN_INVENTORYIDFINDER_INVENTORYID_2);

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
			sb.append(DlrDistributionDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(inventoryId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dlrDistributionDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DlrDistributionDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dlr distribution detailses where inventoryId = &#63; from the database.
	 *
	 * @param inventoryId the inventory ID
	 */
	@Override
	public void removeByinventoryidFinder(long inventoryId) {
		for (DlrDistributionDetails dlrDistributionDetails :
				findByinventoryidFinder(
					inventoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dlrDistributionDetails);
		}
	}

	/**
	 * Returns the number of dlr distribution detailses where inventoryId = &#63;.
	 *
	 * @param inventoryId the inventory ID
	 * @return the number of matching dlr distribution detailses
	 */
	@Override
	public int countByinventoryidFinder(long inventoryId) {
		FinderPath finderPath = _finderPathCountByinventoryidFinder;

		Object[] finderArgs = new Object[] {inventoryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DLRDISTRIBUTIONDETAILS_WHERE);

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
		"dlrDistributionDetails.inventoryId = ?";

	public DlrDistributionDetailsPersistenceImpl() {
		setModelClass(DlrDistributionDetails.class);

		setModelImplClass(DlrDistributionDetailsImpl.class);
		setModelPKClass(long.class);

		setTable(DlrDistributionDetailsTable.INSTANCE);
	}

	/**
	 * Caches the dlr distribution details in the entity cache if it is enabled.
	 *
	 * @param dlrDistributionDetails the dlr distribution details
	 */
	@Override
	public void cacheResult(DlrDistributionDetails dlrDistributionDetails) {
		entityCache.putResult(
			DlrDistributionDetailsImpl.class,
			dlrDistributionDetails.getPrimaryKey(), dlrDistributionDetails);

		finderCache.putResult(
			_finderPathFetchBydstrbnIdFinder,
			new Object[] {dlrDistributionDetails.getDstrbnId()},
			dlrDistributionDetails);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dlr distribution detailses in the entity cache if it is enabled.
	 *
	 * @param dlrDistributionDetailses the dlr distribution detailses
	 */
	@Override
	public void cacheResult(
		List<DlrDistributionDetails> dlrDistributionDetailses) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dlrDistributionDetailses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DlrDistributionDetails dlrDistributionDetails :
				dlrDistributionDetailses) {

			if (entityCache.getResult(
					DlrDistributionDetailsImpl.class,
					dlrDistributionDetails.getPrimaryKey()) == null) {

				cacheResult(dlrDistributionDetails);
			}
		}
	}

	/**
	 * Clears the cache for all dlr distribution detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DlrDistributionDetailsImpl.class);

		finderCache.clearCache(DlrDistributionDetailsImpl.class);
	}

	/**
	 * Clears the cache for the dlr distribution details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DlrDistributionDetails dlrDistributionDetails) {
		entityCache.removeResult(
			DlrDistributionDetailsImpl.class, dlrDistributionDetails);
	}

	@Override
	public void clearCache(
		List<DlrDistributionDetails> dlrDistributionDetailses) {

		for (DlrDistributionDetails dlrDistributionDetails :
				dlrDistributionDetailses) {

			entityCache.removeResult(
				DlrDistributionDetailsImpl.class, dlrDistributionDetails);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DlrDistributionDetailsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				DlrDistributionDetailsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DlrDistributionDetailsModelImpl dlrDistributionDetailsModelImpl) {

		Object[] args = new Object[] {
			dlrDistributionDetailsModelImpl.getDstrbnId()
		};

		finderCache.putResult(
			_finderPathCountBydstrbnIdFinder, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchBydstrbnIdFinder, args,
			dlrDistributionDetailsModelImpl);
	}

	/**
	 * Creates a new dlr distribution details with the primary key. Does not add the dlr distribution details to the database.
	 *
	 * @param dstrbnId the primary key for the new dlr distribution details
	 * @return the new dlr distribution details
	 */
	@Override
	public DlrDistributionDetails create(long dstrbnId) {
		DlrDistributionDetails dlrDistributionDetails =
			new DlrDistributionDetailsImpl();

		dlrDistributionDetails.setNew(true);
		dlrDistributionDetails.setPrimaryKey(dstrbnId);

		dlrDistributionDetails.setCompanyId(CompanyThreadLocal.getCompanyId());

		return dlrDistributionDetails;
	}

	/**
	 * Removes the dlr distribution details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dstrbnId the primary key of the dlr distribution details
	 * @return the dlr distribution details that was removed
	 * @throws NoSuchDlrDistributionDetailsException if a dlr distribution details with the primary key could not be found
	 */
	@Override
	public DlrDistributionDetails remove(long dstrbnId)
		throws NoSuchDlrDistributionDetailsException {

		return remove((Serializable)dstrbnId);
	}

	/**
	 * Removes the dlr distribution details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dlr distribution details
	 * @return the dlr distribution details that was removed
	 * @throws NoSuchDlrDistributionDetailsException if a dlr distribution details with the primary key could not be found
	 */
	@Override
	public DlrDistributionDetails remove(Serializable primaryKey)
		throws NoSuchDlrDistributionDetailsException {

		Session session = null;

		try {
			session = openSession();

			DlrDistributionDetails dlrDistributionDetails =
				(DlrDistributionDetails)session.get(
					DlrDistributionDetailsImpl.class, primaryKey);

			if (dlrDistributionDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDlrDistributionDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dlrDistributionDetails);
		}
		catch (NoSuchDlrDistributionDetailsException noSuchEntityException) {
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
	protected DlrDistributionDetails removeImpl(
		DlrDistributionDetails dlrDistributionDetails) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dlrDistributionDetails)) {
				dlrDistributionDetails = (DlrDistributionDetails)session.get(
					DlrDistributionDetailsImpl.class,
					dlrDistributionDetails.getPrimaryKeyObj());
			}

			if (dlrDistributionDetails != null) {
				session.delete(dlrDistributionDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dlrDistributionDetails != null) {
			clearCache(dlrDistributionDetails);
		}

		return dlrDistributionDetails;
	}

	@Override
	public DlrDistributionDetails updateImpl(
		DlrDistributionDetails dlrDistributionDetails) {

		boolean isNew = dlrDistributionDetails.isNew();

		if (!(dlrDistributionDetails instanceof
				DlrDistributionDetailsModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dlrDistributionDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dlrDistributionDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dlrDistributionDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DlrDistributionDetails implementation " +
					dlrDistributionDetails.getClass());
		}

		DlrDistributionDetailsModelImpl dlrDistributionDetailsModelImpl =
			(DlrDistributionDetailsModelImpl)dlrDistributionDetails;

		if (isNew && (dlrDistributionDetails.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				dlrDistributionDetails.setCreateDate(date);
			}
			else {
				dlrDistributionDetails.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dlrDistributionDetails);
			}
			else {
				dlrDistributionDetails = (DlrDistributionDetails)session.merge(
					dlrDistributionDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DlrDistributionDetailsImpl.class, dlrDistributionDetailsModelImpl,
			false, true);

		cacheUniqueFindersCache(dlrDistributionDetailsModelImpl);

		if (isNew) {
			dlrDistributionDetails.setNew(false);
		}

		dlrDistributionDetails.resetOriginalValues();

		return dlrDistributionDetails;
	}

	/**
	 * Returns the dlr distribution details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dlr distribution details
	 * @return the dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a dlr distribution details with the primary key could not be found
	 */
	@Override
	public DlrDistributionDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDlrDistributionDetailsException {

		DlrDistributionDetails dlrDistributionDetails = fetchByPrimaryKey(
			primaryKey);

		if (dlrDistributionDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDlrDistributionDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dlrDistributionDetails;
	}

	/**
	 * Returns the dlr distribution details with the primary key or throws a <code>NoSuchDlrDistributionDetailsException</code> if it could not be found.
	 *
	 * @param dstrbnId the primary key of the dlr distribution details
	 * @return the dlr distribution details
	 * @throws NoSuchDlrDistributionDetailsException if a dlr distribution details with the primary key could not be found
	 */
	@Override
	public DlrDistributionDetails findByPrimaryKey(long dstrbnId)
		throws NoSuchDlrDistributionDetailsException {

		return findByPrimaryKey((Serializable)dstrbnId);
	}

	/**
	 * Returns the dlr distribution details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dstrbnId the primary key of the dlr distribution details
	 * @return the dlr distribution details, or <code>null</code> if a dlr distribution details with the primary key could not be found
	 */
	@Override
	public DlrDistributionDetails fetchByPrimaryKey(long dstrbnId) {
		return fetchByPrimaryKey((Serializable)dstrbnId);
	}

	/**
	 * Returns all the dlr distribution detailses.
	 *
	 * @return the dlr distribution detailses
	 */
	@Override
	public List<DlrDistributionDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dlr distribution detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DlrDistributionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dlr distribution detailses
	 * @param end the upper bound of the range of dlr distribution detailses (not inclusive)
	 * @return the range of dlr distribution detailses
	 */
	@Override
	public List<DlrDistributionDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dlr distribution detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DlrDistributionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dlr distribution detailses
	 * @param end the upper bound of the range of dlr distribution detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dlr distribution detailses
	 */
	@Override
	public List<DlrDistributionDetails> findAll(
		int start, int end,
		OrderByComparator<DlrDistributionDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dlr distribution detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DlrDistributionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dlr distribution detailses
	 * @param end the upper bound of the range of dlr distribution detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dlr distribution detailses
	 */
	@Override
	public List<DlrDistributionDetails> findAll(
		int start, int end,
		OrderByComparator<DlrDistributionDetails> orderByComparator,
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

		List<DlrDistributionDetails> list = null;

		if (useFinderCache) {
			list = (List<DlrDistributionDetails>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DLRDISTRIBUTIONDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DLRDISTRIBUTIONDETAILS;

				sql = sql.concat(DlrDistributionDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DlrDistributionDetails>)QueryUtil.list(
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
	 * Removes all the dlr distribution detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DlrDistributionDetails dlrDistributionDetails : findAll()) {
			remove(dlrDistributionDetails);
		}
	}

	/**
	 * Returns the number of dlr distribution detailses.
	 *
	 * @return the number of dlr distribution detailses
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
					_SQL_COUNT_DLRDISTRIBUTIONDETAILS);

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
		return "dstrbnId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DLRDISTRIBUTIONDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DlrDistributionDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dlr distribution details persistence.
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

		_finderPathFetchBydstrbnIdFinder = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBydstrbnIdFinder",
			new String[] {Long.class.getName()}, new String[] {"dstrbnId"},
			true);

		_finderPathCountBydstrbnIdFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydstrbnIdFinder",
			new String[] {Long.class.getName()}, new String[] {"dstrbnId"},
			false);

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

		_finderPathWithPaginationFindByffpregstridFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByffpregstridFinder",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"ffpRegstrId"}, true);

		_finderPathWithoutPaginationFindByffpregstridFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByffpregstridFinder", new String[] {Long.class.getName()},
			new String[] {"ffpRegstrId"}, true);

		_finderPathCountByffpregstridFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByffpregstridFinder", new String[] {Long.class.getName()},
			new String[] {"ffpRegstrId"}, false);

		_finderPathWithPaginationFindByinventoryidFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByinventoryidFinder",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"inventoryId"}, true);

		_finderPathWithoutPaginationFindByinventoryidFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByinventoryidFinder", new String[] {Long.class.getName()},
			new String[] {"inventoryId"}, true);

		_finderPathCountByinventoryidFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByinventoryidFinder", new String[] {Long.class.getName()},
			new String[] {"inventoryId"}, false);

		_setDlrDistributionDetailsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDlrDistributionDetailsUtilPersistence(null);

		entityCache.removeCache(DlrDistributionDetailsImpl.class.getName());
	}

	private void _setDlrDistributionDetailsUtilPersistence(
		DlrDistributionDetailsPersistence dlrDistributionDetailsPersistence) {

		try {
			Field field = DlrDistributionDetailsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dlrDistributionDetailsPersistence);
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

	private static final String _SQL_SELECT_DLRDISTRIBUTIONDETAILS =
		"SELECT dlrDistributionDetails FROM DlrDistributionDetails dlrDistributionDetails";

	private static final String _SQL_SELECT_DLRDISTRIBUTIONDETAILS_WHERE =
		"SELECT dlrDistributionDetails FROM DlrDistributionDetails dlrDistributionDetails WHERE ";

	private static final String _SQL_COUNT_DLRDISTRIBUTIONDETAILS =
		"SELECT COUNT(dlrDistributionDetails) FROM DlrDistributionDetails dlrDistributionDetails";

	private static final String _SQL_COUNT_DLRDISTRIBUTIONDETAILS_WHERE =
		"SELECT COUNT(dlrDistributionDetails) FROM DlrDistributionDetails dlrDistributionDetails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"dlrDistributionDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DlrDistributionDetails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DlrDistributionDetails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DlrDistributionDetailsPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}