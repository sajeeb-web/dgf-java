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

import bd.gov.dgfood.food.friendly.program.exception.NoSuchFfpbDetailsException;
import bd.gov.dgfood.food.friendly.program.model.FfpbDetails;
import bd.gov.dgfood.food.friendly.program.model.FfpbDetailsTable;
import bd.gov.dgfood.food.friendly.program.model.impl.FfpbDetailsImpl;
import bd.gov.dgfood.food.friendly.program.model.impl.FfpbDetailsModelImpl;
import bd.gov.dgfood.food.friendly.program.service.persistence.FfpbDetailsPersistence;
import bd.gov.dgfood.food.friendly.program.service.persistence.FfpbDetailsUtil;
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
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the ffpb details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FfpbDetailsPersistence.class)
public class FfpbDetailsPersistenceImpl
	extends BasePersistenceImpl<FfpbDetails> implements FfpbDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FfpbDetailsUtil</code> to access the ffpb details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FfpbDetailsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByffpbNidFinder;
	private FinderPath _finderPathCountByffpbNidFinder;

	/**
	 * Returns the ffpb details where nationalId = &#63; or throws a <code>NoSuchFfpbDetailsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching ffpb details
	 * @throws NoSuchFfpbDetailsException if a matching ffpb details could not be found
	 */
	@Override
	public FfpbDetails findByffpbNidFinder(long nationalId)
		throws NoSuchFfpbDetailsException {

		FfpbDetails ffpbDetails = fetchByffpbNidFinder(nationalId);

		if (ffpbDetails == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("nationalId=");
			sb.append(nationalId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFfpbDetailsException(sb.toString());
		}

		return ffpbDetails;
	}

	/**
	 * Returns the ffpb details where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching ffpb details, or <code>null</code> if a matching ffpb details could not be found
	 */
	@Override
	public FfpbDetails fetchByffpbNidFinder(long nationalId) {
		return fetchByffpbNidFinder(nationalId, true);
	}

	/**
	 * Returns the ffpb details where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ffpb details, or <code>null</code> if a matching ffpb details could not be found
	 */
	@Override
	public FfpbDetails fetchByffpbNidFinder(
		long nationalId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {nationalId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByffpbNidFinder, finderArgs, this);
		}

		if (result instanceof FfpbDetails) {
			FfpbDetails ffpbDetails = (FfpbDetails)result;

			if (nationalId != ffpbDetails.getNationalId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_FFPBDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_FFPBNIDFINDER_NATIONALID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(nationalId);

				List<FfpbDetails> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByffpbNidFinder, finderArgs, list);
					}
				}
				else {
					FfpbDetails ffpbDetails = list.get(0);

					result = ffpbDetails;

					cacheResult(ffpbDetails);
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
			return (FfpbDetails)result;
		}
	}

	/**
	 * Removes the ffpb details where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the ffpb details that was removed
	 */
	@Override
	public FfpbDetails removeByffpbNidFinder(long nationalId)
		throws NoSuchFfpbDetailsException {

		FfpbDetails ffpbDetails = findByffpbNidFinder(nationalId);

		return remove(ffpbDetails);
	}

	/**
	 * Returns the number of ffpb detailses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching ffpb detailses
	 */
	@Override
	public int countByffpbNidFinder(long nationalId) {
		FinderPath finderPath = _finderPathCountByffpbNidFinder;

		Object[] finderArgs = new Object[] {nationalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FFPBDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_FFPBNIDFINDER_NATIONALID_2);

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

	private static final String _FINDER_COLUMN_FFPBNIDFINDER_NATIONALID_2 =
		"ffpbDetails.nationalId = ?";

	private FinderPath _finderPathWithPaginationFindByffpbMobileFinder;
	private FinderPath _finderPathWithoutPaginationFindByffpbMobileFinder;
	private FinderPath _finderPathCountByffpbMobileFinder;

	/**
	 * Returns all the ffpb detailses where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @return the matching ffpb detailses
	 */
	@Override
	public List<FfpbDetails> findByffpbMobileFinder(String mobileNo) {
		return findByffpbMobileFinder(
			mobileNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ffpb detailses where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FfpbDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of ffpb detailses
	 * @param end the upper bound of the range of ffpb detailses (not inclusive)
	 * @return the range of matching ffpb detailses
	 */
	@Override
	public List<FfpbDetails> findByffpbMobileFinder(
		String mobileNo, int start, int end) {

		return findByffpbMobileFinder(mobileNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ffpb detailses where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FfpbDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of ffpb detailses
	 * @param end the upper bound of the range of ffpb detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ffpb detailses
	 */
	@Override
	public List<FfpbDetails> findByffpbMobileFinder(
		String mobileNo, int start, int end,
		OrderByComparator<FfpbDetails> orderByComparator) {

		return findByffpbMobileFinder(
			mobileNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ffpb detailses where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FfpbDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of ffpb detailses
	 * @param end the upper bound of the range of ffpb detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ffpb detailses
	 */
	@Override
	public List<FfpbDetails> findByffpbMobileFinder(
		String mobileNo, int start, int end,
		OrderByComparator<FfpbDetails> orderByComparator,
		boolean useFinderCache) {

		mobileNo = Objects.toString(mobileNo, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByffpbMobileFinder;
				finderArgs = new Object[] {mobileNo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByffpbMobileFinder;
			finderArgs = new Object[] {mobileNo, start, end, orderByComparator};
		}

		List<FfpbDetails> list = null;

		if (useFinderCache) {
			list = (List<FfpbDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FfpbDetails ffpbDetails : list) {
					if (!mobileNo.equals(ffpbDetails.getMobileNo())) {
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

			sb.append(_SQL_SELECT_FFPBDETAILS_WHERE);

			boolean bindMobileNo = false;

			if (mobileNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_FFPBMOBILEFINDER_MOBILENO_3);
			}
			else {
				bindMobileNo = true;

				sb.append(_FINDER_COLUMN_FFPBMOBILEFINDER_MOBILENO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FfpbDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindMobileNo) {
					queryPos.add(mobileNo);
				}

				list = (List<FfpbDetails>)QueryUtil.list(
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
	 * Returns the first ffpb details in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ffpb details
	 * @throws NoSuchFfpbDetailsException if a matching ffpb details could not be found
	 */
	@Override
	public FfpbDetails findByffpbMobileFinder_First(
			String mobileNo, OrderByComparator<FfpbDetails> orderByComparator)
		throws NoSuchFfpbDetailsException {

		FfpbDetails ffpbDetails = fetchByffpbMobileFinder_First(
			mobileNo, orderByComparator);

		if (ffpbDetails != null) {
			return ffpbDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mobileNo=");
		sb.append(mobileNo);

		sb.append("}");

		throw new NoSuchFfpbDetailsException(sb.toString());
	}

	/**
	 * Returns the first ffpb details in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ffpb details, or <code>null</code> if a matching ffpb details could not be found
	 */
	@Override
	public FfpbDetails fetchByffpbMobileFinder_First(
		String mobileNo, OrderByComparator<FfpbDetails> orderByComparator) {

		List<FfpbDetails> list = findByffpbMobileFinder(
			mobileNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ffpb details in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ffpb details
	 * @throws NoSuchFfpbDetailsException if a matching ffpb details could not be found
	 */
	@Override
	public FfpbDetails findByffpbMobileFinder_Last(
			String mobileNo, OrderByComparator<FfpbDetails> orderByComparator)
		throws NoSuchFfpbDetailsException {

		FfpbDetails ffpbDetails = fetchByffpbMobileFinder_Last(
			mobileNo, orderByComparator);

		if (ffpbDetails != null) {
			return ffpbDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mobileNo=");
		sb.append(mobileNo);

		sb.append("}");

		throw new NoSuchFfpbDetailsException(sb.toString());
	}

	/**
	 * Returns the last ffpb details in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ffpb details, or <code>null</code> if a matching ffpb details could not be found
	 */
	@Override
	public FfpbDetails fetchByffpbMobileFinder_Last(
		String mobileNo, OrderByComparator<FfpbDetails> orderByComparator) {

		int count = countByffpbMobileFinder(mobileNo);

		if (count == 0) {
			return null;
		}

		List<FfpbDetails> list = findByffpbMobileFinder(
			mobileNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ffpb detailses before and after the current ffpb details in the ordered set where mobileNo = &#63;.
	 *
	 * @param ffpRegstrId the primary key of the current ffpb details
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ffpb details
	 * @throws NoSuchFfpbDetailsException if a ffpb details with the primary key could not be found
	 */
	@Override
	public FfpbDetails[] findByffpbMobileFinder_PrevAndNext(
			long ffpRegstrId, String mobileNo,
			OrderByComparator<FfpbDetails> orderByComparator)
		throws NoSuchFfpbDetailsException {

		mobileNo = Objects.toString(mobileNo, "");

		FfpbDetails ffpbDetails = findByPrimaryKey(ffpRegstrId);

		Session session = null;

		try {
			session = openSession();

			FfpbDetails[] array = new FfpbDetailsImpl[3];

			array[0] = getByffpbMobileFinder_PrevAndNext(
				session, ffpbDetails, mobileNo, orderByComparator, true);

			array[1] = ffpbDetails;

			array[2] = getByffpbMobileFinder_PrevAndNext(
				session, ffpbDetails, mobileNo, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FfpbDetails getByffpbMobileFinder_PrevAndNext(
		Session session, FfpbDetails ffpbDetails, String mobileNo,
		OrderByComparator<FfpbDetails> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FFPBDETAILS_WHERE);

		boolean bindMobileNo = false;

		if (mobileNo.isEmpty()) {
			sb.append(_FINDER_COLUMN_FFPBMOBILEFINDER_MOBILENO_3);
		}
		else {
			bindMobileNo = true;

			sb.append(_FINDER_COLUMN_FFPBMOBILEFINDER_MOBILENO_2);
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
			sb.append(FfpbDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindMobileNo) {
			queryPos.add(mobileNo);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ffpbDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FfpbDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ffpb detailses where mobileNo = &#63; from the database.
	 *
	 * @param mobileNo the mobile no
	 */
	@Override
	public void removeByffpbMobileFinder(String mobileNo) {
		for (FfpbDetails ffpbDetails :
				findByffpbMobileFinder(
					mobileNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ffpbDetails);
		}
	}

	/**
	 * Returns the number of ffpb detailses where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @return the number of matching ffpb detailses
	 */
	@Override
	public int countByffpbMobileFinder(String mobileNo) {
		mobileNo = Objects.toString(mobileNo, "");

		FinderPath finderPath = _finderPathCountByffpbMobileFinder;

		Object[] finderArgs = new Object[] {mobileNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FFPBDETAILS_WHERE);

			boolean bindMobileNo = false;

			if (mobileNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_FFPBMOBILEFINDER_MOBILENO_3);
			}
			else {
				bindMobileNo = true;

				sb.append(_FINDER_COLUMN_FFPBMOBILEFINDER_MOBILENO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindMobileNo) {
					queryPos.add(mobileNo);
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

	private static final String _FINDER_COLUMN_FFPBMOBILEFINDER_MOBILENO_2 =
		"ffpbDetails.mobileNo = ?";

	private static final String _FINDER_COLUMN_FFPBMOBILEFINDER_MOBILENO_3 =
		"(ffpbDetails.mobileNo IS NULL OR ffpbDetails.mobileNo = '')";

	private FinderPath _finderPathFetchByffpregstridFinder;
	private FinderPath _finderPathCountByffpregstridFinder;

	/**
	 * Returns the ffpb details where ffpRegstrId = &#63; or throws a <code>NoSuchFfpbDetailsException</code> if it could not be found.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @return the matching ffpb details
	 * @throws NoSuchFfpbDetailsException if a matching ffpb details could not be found
	 */
	@Override
	public FfpbDetails findByffpregstridFinder(long ffpRegstrId)
		throws NoSuchFfpbDetailsException {

		FfpbDetails ffpbDetails = fetchByffpregstridFinder(ffpRegstrId);

		if (ffpbDetails == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("ffpRegstrId=");
			sb.append(ffpRegstrId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFfpbDetailsException(sb.toString());
		}

		return ffpbDetails;
	}

	/**
	 * Returns the ffpb details where ffpRegstrId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @return the matching ffpb details, or <code>null</code> if a matching ffpb details could not be found
	 */
	@Override
	public FfpbDetails fetchByffpregstridFinder(long ffpRegstrId) {
		return fetchByffpregstridFinder(ffpRegstrId, true);
	}

	/**
	 * Returns the ffpb details where ffpRegstrId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ffpb details, or <code>null</code> if a matching ffpb details could not be found
	 */
	@Override
	public FfpbDetails fetchByffpregstridFinder(
		long ffpRegstrId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {ffpRegstrId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByffpregstridFinder, finderArgs, this);
		}

		if (result instanceof FfpbDetails) {
			FfpbDetails ffpbDetails = (FfpbDetails)result;

			if (ffpRegstrId != ffpbDetails.getFfpRegstrId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_FFPBDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_FFPREGSTRIDFINDER_FFPREGSTRID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(ffpRegstrId);

				List<FfpbDetails> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByffpregstridFinder, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {ffpRegstrId};
							}

							_log.warn(
								"FfpbDetailsPersistenceImpl.fetchByffpregstridFinder(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					FfpbDetails ffpbDetails = list.get(0);

					result = ffpbDetails;

					cacheResult(ffpbDetails);
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
			return (FfpbDetails)result;
		}
	}

	/**
	 * Removes the ffpb details where ffpRegstrId = &#63; from the database.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @return the ffpb details that was removed
	 */
	@Override
	public FfpbDetails removeByffpregstridFinder(long ffpRegstrId)
		throws NoSuchFfpbDetailsException {

		FfpbDetails ffpbDetails = findByffpregstridFinder(ffpRegstrId);

		return remove(ffpbDetails);
	}

	/**
	 * Returns the number of ffpb detailses where ffpRegstrId = &#63;.
	 *
	 * @param ffpRegstrId the ffp regstr ID
	 * @return the number of matching ffpb detailses
	 */
	@Override
	public int countByffpregstridFinder(long ffpRegstrId) {
		FinderPath finderPath = _finderPathCountByffpregstridFinder;

		Object[] finderArgs = new Object[] {ffpRegstrId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FFPBDETAILS_WHERE);

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
		"ffpbDetails.ffpRegstrId = ?";

	public FfpbDetailsPersistenceImpl() {
		setModelClass(FfpbDetails.class);

		setModelImplClass(FfpbDetailsImpl.class);
		setModelPKClass(long.class);

		setTable(FfpbDetailsTable.INSTANCE);
	}

	/**
	 * Caches the ffpb details in the entity cache if it is enabled.
	 *
	 * @param ffpbDetails the ffpb details
	 */
	@Override
	public void cacheResult(FfpbDetails ffpbDetails) {
		entityCache.putResult(
			FfpbDetailsImpl.class, ffpbDetails.getPrimaryKey(), ffpbDetails);

		finderCache.putResult(
			_finderPathFetchByffpbNidFinder,
			new Object[] {ffpbDetails.getNationalId()}, ffpbDetails);

		finderCache.putResult(
			_finderPathFetchByffpregstridFinder,
			new Object[] {ffpbDetails.getFfpRegstrId()}, ffpbDetails);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the ffpb detailses in the entity cache if it is enabled.
	 *
	 * @param ffpbDetailses the ffpb detailses
	 */
	@Override
	public void cacheResult(List<FfpbDetails> ffpbDetailses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (ffpbDetailses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FfpbDetails ffpbDetails : ffpbDetailses) {
			if (entityCache.getResult(
					FfpbDetailsImpl.class, ffpbDetails.getPrimaryKey()) ==
						null) {

				cacheResult(ffpbDetails);
			}
		}
	}

	/**
	 * Clears the cache for all ffpb detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FfpbDetailsImpl.class);

		finderCache.clearCache(FfpbDetailsImpl.class);
	}

	/**
	 * Clears the cache for the ffpb details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FfpbDetails ffpbDetails) {
		entityCache.removeResult(FfpbDetailsImpl.class, ffpbDetails);
	}

	@Override
	public void clearCache(List<FfpbDetails> ffpbDetailses) {
		for (FfpbDetails ffpbDetails : ffpbDetailses) {
			entityCache.removeResult(FfpbDetailsImpl.class, ffpbDetails);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FfpbDetailsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FfpbDetailsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		FfpbDetailsModelImpl ffpbDetailsModelImpl) {

		Object[] args = new Object[] {ffpbDetailsModelImpl.getNationalId()};

		finderCache.putResult(
			_finderPathCountByffpbNidFinder, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByffpbNidFinder, args, ffpbDetailsModelImpl);

		args = new Object[] {ffpbDetailsModelImpl.getFfpRegstrId()};

		finderCache.putResult(
			_finderPathCountByffpregstridFinder, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByffpregstridFinder, args, ffpbDetailsModelImpl);
	}

	/**
	 * Creates a new ffpb details with the primary key. Does not add the ffpb details to the database.
	 *
	 * @param ffpRegstrId the primary key for the new ffpb details
	 * @return the new ffpb details
	 */
	@Override
	public FfpbDetails create(long ffpRegstrId) {
		FfpbDetails ffpbDetails = new FfpbDetailsImpl();

		ffpbDetails.setNew(true);
		ffpbDetails.setPrimaryKey(ffpRegstrId);

		ffpbDetails.setCompanyId(CompanyThreadLocal.getCompanyId());

		return ffpbDetails;
	}

	/**
	 * Removes the ffpb details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ffpRegstrId the primary key of the ffpb details
	 * @return the ffpb details that was removed
	 * @throws NoSuchFfpbDetailsException if a ffpb details with the primary key could not be found
	 */
	@Override
	public FfpbDetails remove(long ffpRegstrId)
		throws NoSuchFfpbDetailsException {

		return remove((Serializable)ffpRegstrId);
	}

	/**
	 * Removes the ffpb details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ffpb details
	 * @return the ffpb details that was removed
	 * @throws NoSuchFfpbDetailsException if a ffpb details with the primary key could not be found
	 */
	@Override
	public FfpbDetails remove(Serializable primaryKey)
		throws NoSuchFfpbDetailsException {

		Session session = null;

		try {
			session = openSession();

			FfpbDetails ffpbDetails = (FfpbDetails)session.get(
				FfpbDetailsImpl.class, primaryKey);

			if (ffpbDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFfpbDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ffpbDetails);
		}
		catch (NoSuchFfpbDetailsException noSuchEntityException) {
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
	protected FfpbDetails removeImpl(FfpbDetails ffpbDetails) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ffpbDetails)) {
				ffpbDetails = (FfpbDetails)session.get(
					FfpbDetailsImpl.class, ffpbDetails.getPrimaryKeyObj());
			}

			if (ffpbDetails != null) {
				session.delete(ffpbDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (ffpbDetails != null) {
			clearCache(ffpbDetails);
		}

		return ffpbDetails;
	}

	@Override
	public FfpbDetails updateImpl(FfpbDetails ffpbDetails) {
		boolean isNew = ffpbDetails.isNew();

		if (!(ffpbDetails instanceof FfpbDetailsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ffpbDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(ffpbDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ffpbDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FfpbDetails implementation " +
					ffpbDetails.getClass());
		}

		FfpbDetailsModelImpl ffpbDetailsModelImpl =
			(FfpbDetailsModelImpl)ffpbDetails;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (ffpbDetails.getCreateDate() == null)) {
			if (serviceContext == null) {
				ffpbDetails.setCreateDate(date);
			}
			else {
				ffpbDetails.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!ffpbDetailsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				ffpbDetails.setModifiedDate(date);
			}
			else {
				ffpbDetails.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(ffpbDetails);
			}
			else {
				ffpbDetails = (FfpbDetails)session.merge(ffpbDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FfpbDetailsImpl.class, ffpbDetailsModelImpl, false, true);

		cacheUniqueFindersCache(ffpbDetailsModelImpl);

		if (isNew) {
			ffpbDetails.setNew(false);
		}

		ffpbDetails.resetOriginalValues();

		return ffpbDetails;
	}

	/**
	 * Returns the ffpb details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ffpb details
	 * @return the ffpb details
	 * @throws NoSuchFfpbDetailsException if a ffpb details with the primary key could not be found
	 */
	@Override
	public FfpbDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFfpbDetailsException {

		FfpbDetails ffpbDetails = fetchByPrimaryKey(primaryKey);

		if (ffpbDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFfpbDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ffpbDetails;
	}

	/**
	 * Returns the ffpb details with the primary key or throws a <code>NoSuchFfpbDetailsException</code> if it could not be found.
	 *
	 * @param ffpRegstrId the primary key of the ffpb details
	 * @return the ffpb details
	 * @throws NoSuchFfpbDetailsException if a ffpb details with the primary key could not be found
	 */
	@Override
	public FfpbDetails findByPrimaryKey(long ffpRegstrId)
		throws NoSuchFfpbDetailsException {

		return findByPrimaryKey((Serializable)ffpRegstrId);
	}

	/**
	 * Returns the ffpb details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ffpRegstrId the primary key of the ffpb details
	 * @return the ffpb details, or <code>null</code> if a ffpb details with the primary key could not be found
	 */
	@Override
	public FfpbDetails fetchByPrimaryKey(long ffpRegstrId) {
		return fetchByPrimaryKey((Serializable)ffpRegstrId);
	}

	/**
	 * Returns all the ffpb detailses.
	 *
	 * @return the ffpb detailses
	 */
	@Override
	public List<FfpbDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ffpb detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FfpbDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffpb detailses
	 * @param end the upper bound of the range of ffpb detailses (not inclusive)
	 * @return the range of ffpb detailses
	 */
	@Override
	public List<FfpbDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ffpb detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FfpbDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffpb detailses
	 * @param end the upper bound of the range of ffpb detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ffpb detailses
	 */
	@Override
	public List<FfpbDetails> findAll(
		int start, int end, OrderByComparator<FfpbDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ffpb detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FfpbDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffpb detailses
	 * @param end the upper bound of the range of ffpb detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ffpb detailses
	 */
	@Override
	public List<FfpbDetails> findAll(
		int start, int end, OrderByComparator<FfpbDetails> orderByComparator,
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

		List<FfpbDetails> list = null;

		if (useFinderCache) {
			list = (List<FfpbDetails>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FFPBDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FFPBDETAILS;

				sql = sql.concat(FfpbDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FfpbDetails>)QueryUtil.list(
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
	 * Removes all the ffpb detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FfpbDetails ffpbDetails : findAll()) {
			remove(ffpbDetails);
		}
	}

	/**
	 * Returns the number of ffpb detailses.
	 *
	 * @return the number of ffpb detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FFPBDETAILS);

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
		return "ffpRegstrId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FFPBDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FfpbDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ffpb details persistence.
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

		_finderPathFetchByffpbNidFinder = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByffpbNidFinder",
			new String[] {Long.class.getName()}, new String[] {"nationalId"},
			true);

		_finderPathCountByffpbNidFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByffpbNidFinder",
			new String[] {Long.class.getName()}, new String[] {"nationalId"},
			false);

		_finderPathWithPaginationFindByffpbMobileFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByffpbMobileFinder",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"mobileNo"}, true);

		_finderPathWithoutPaginationFindByffpbMobileFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByffpbMobileFinder",
			new String[] {String.class.getName()}, new String[] {"mobileNo"},
			true);

		_finderPathCountByffpbMobileFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByffpbMobileFinder", new String[] {String.class.getName()},
			new String[] {"mobileNo"}, false);

		_finderPathFetchByffpregstridFinder = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByffpregstridFinder",
			new String[] {Long.class.getName()}, new String[] {"ffpRegstrId"},
			true);

		_finderPathCountByffpregstridFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByffpregstridFinder", new String[] {Long.class.getName()},
			new String[] {"ffpRegstrId"}, false);

		_setFfpbDetailsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setFfpbDetailsUtilPersistence(null);

		entityCache.removeCache(FfpbDetailsImpl.class.getName());
	}

	private void _setFfpbDetailsUtilPersistence(
		FfpbDetailsPersistence ffpbDetailsPersistence) {

		try {
			Field field = FfpbDetailsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, ffpbDetailsPersistence);
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

	private static final String _SQL_SELECT_FFPBDETAILS =
		"SELECT ffpbDetails FROM FfpbDetails ffpbDetails";

	private static final String _SQL_SELECT_FFPBDETAILS_WHERE =
		"SELECT ffpbDetails FROM FfpbDetails ffpbDetails WHERE ";

	private static final String _SQL_COUNT_FFPBDETAILS =
		"SELECT COUNT(ffpbDetails) FROM FfpbDetails ffpbDetails";

	private static final String _SQL_COUNT_FFPBDETAILS_WHERE =
		"SELECT COUNT(ffpbDetails) FROM FfpbDetails ffpbDetails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ffpbDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FfpbDetails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FfpbDetails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FfpbDetailsPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}