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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfUsersException;
import bd.gov.dgfood.food.grain.license.model.DgfUsers;
import bd.gov.dgfood.food.grain.license.model.DgfUsersTable;
import bd.gov.dgfood.food.grain.license.model.impl.DgfUsersImpl;
import bd.gov.dgfood.food.grain.license.model.impl.DgfUsersModelImpl;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfUsersPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfUsersUtil;
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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
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
 * The persistence implementation for the dgf users service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DgfUsersPersistence.class)
public class DgfUsersPersistenceImpl
	extends BasePersistenceImpl<DgfUsers> implements DgfUsersPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DgfUsersUtil</code> to access the dgf users persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DgfUsersImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBymobileNumberFinder;
	private FinderPath _finderPathWithoutPaginationFindBymobileNumberFinder;
	private FinderPath _finderPathCountBymobileNumberFinder;

	/**
	 * Returns all the dgf userses where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @return the matching dgf userses
	 */
	@Override
	public List<DgfUsers> findBymobileNumberFinder(String mobileNo) {
		return findBymobileNumberFinder(
			mobileNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf userses where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @return the range of matching dgf userses
	 */
	@Override
	public List<DgfUsers> findBymobileNumberFinder(
		String mobileNo, int start, int end) {

		return findBymobileNumberFinder(mobileNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf userses where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf userses
	 */
	@Override
	public List<DgfUsers> findBymobileNumberFinder(
		String mobileNo, int start, int end,
		OrderByComparator<DgfUsers> orderByComparator) {

		return findBymobileNumberFinder(
			mobileNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf userses where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf userses
	 */
	@Override
	public List<DgfUsers> findBymobileNumberFinder(
		String mobileNo, int start, int end,
		OrderByComparator<DgfUsers> orderByComparator, boolean useFinderCache) {

		mobileNo = Objects.toString(mobileNo, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBymobileNumberFinder;
				finderArgs = new Object[] {mobileNo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBymobileNumberFinder;
			finderArgs = new Object[] {mobileNo, start, end, orderByComparator};
		}

		List<DgfUsers> list = null;

		if (useFinderCache) {
			list = (List<DgfUsers>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfUsers dgfUsers : list) {
					if (!mobileNo.equals(dgfUsers.getMobileNo())) {
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

			sb.append(_SQL_SELECT_DGFUSERS_WHERE);

			boolean bindMobileNo = false;

			if (mobileNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_MOBILENUMBERFINDER_MOBILENO_3);
			}
			else {
				bindMobileNo = true;

				sb.append(_FINDER_COLUMN_MOBILENUMBERFINDER_MOBILENO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfUsersModelImpl.ORDER_BY_JPQL);
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

				list = (List<DgfUsers>)QueryUtil.list(
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
	 * Returns the first dgf users in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users
	 * @throws NoSuchDgfUsersException if a matching dgf users could not be found
	 */
	@Override
	public DgfUsers findBymobileNumberFinder_First(
			String mobileNo, OrderByComparator<DgfUsers> orderByComparator)
		throws NoSuchDgfUsersException {

		DgfUsers dgfUsers = fetchBymobileNumberFinder_First(
			mobileNo, orderByComparator);

		if (dgfUsers != null) {
			return dgfUsers;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mobileNo=");
		sb.append(mobileNo);

		sb.append("}");

		throw new NoSuchDgfUsersException(sb.toString());
	}

	/**
	 * Returns the first dgf users in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users, or <code>null</code> if a matching dgf users could not be found
	 */
	@Override
	public DgfUsers fetchBymobileNumberFinder_First(
		String mobileNo, OrderByComparator<DgfUsers> orderByComparator) {

		List<DgfUsers> list = findBymobileNumberFinder(
			mobileNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf users in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users
	 * @throws NoSuchDgfUsersException if a matching dgf users could not be found
	 */
	@Override
	public DgfUsers findBymobileNumberFinder_Last(
			String mobileNo, OrderByComparator<DgfUsers> orderByComparator)
		throws NoSuchDgfUsersException {

		DgfUsers dgfUsers = fetchBymobileNumberFinder_Last(
			mobileNo, orderByComparator);

		if (dgfUsers != null) {
			return dgfUsers;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mobileNo=");
		sb.append(mobileNo);

		sb.append("}");

		throw new NoSuchDgfUsersException(sb.toString());
	}

	/**
	 * Returns the last dgf users in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users, or <code>null</code> if a matching dgf users could not be found
	 */
	@Override
	public DgfUsers fetchBymobileNumberFinder_Last(
		String mobileNo, OrderByComparator<DgfUsers> orderByComparator) {

		int count = countBymobileNumberFinder(mobileNo);

		if (count == 0) {
			return null;
		}

		List<DgfUsers> list = findBymobileNumberFinder(
			mobileNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf userses before and after the current dgf users in the ordered set where mobileNo = &#63;.
	 *
	 * @param userId the primary key of the current dgf users
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users
	 * @throws NoSuchDgfUsersException if a dgf users with the primary key could not be found
	 */
	@Override
	public DgfUsers[] findBymobileNumberFinder_PrevAndNext(
			long userId, String mobileNo,
			OrderByComparator<DgfUsers> orderByComparator)
		throws NoSuchDgfUsersException {

		mobileNo = Objects.toString(mobileNo, "");

		DgfUsers dgfUsers = findByPrimaryKey(userId);

		Session session = null;

		try {
			session = openSession();

			DgfUsers[] array = new DgfUsersImpl[3];

			array[0] = getBymobileNumberFinder_PrevAndNext(
				session, dgfUsers, mobileNo, orderByComparator, true);

			array[1] = dgfUsers;

			array[2] = getBymobileNumberFinder_PrevAndNext(
				session, dgfUsers, mobileNo, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DgfUsers getBymobileNumberFinder_PrevAndNext(
		Session session, DgfUsers dgfUsers, String mobileNo,
		OrderByComparator<DgfUsers> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DGFUSERS_WHERE);

		boolean bindMobileNo = false;

		if (mobileNo.isEmpty()) {
			sb.append(_FINDER_COLUMN_MOBILENUMBERFINDER_MOBILENO_3);
		}
		else {
			bindMobileNo = true;

			sb.append(_FINDER_COLUMN_MOBILENUMBERFINDER_MOBILENO_2);
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
			sb.append(DgfUsersModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(dgfUsers)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfUsers> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf userses where mobileNo = &#63; from the database.
	 *
	 * @param mobileNo the mobile no
	 */
	@Override
	public void removeBymobileNumberFinder(String mobileNo) {
		for (DgfUsers dgfUsers :
				findBymobileNumberFinder(
					mobileNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgfUsers);
		}
	}

	/**
	 * Returns the number of dgf userses where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @return the number of matching dgf userses
	 */
	@Override
	public int countBymobileNumberFinder(String mobileNo) {
		mobileNo = Objects.toString(mobileNo, "");

		FinderPath finderPath = _finderPathCountBymobileNumberFinder;

		Object[] finderArgs = new Object[] {mobileNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFUSERS_WHERE);

			boolean bindMobileNo = false;

			if (mobileNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_MOBILENUMBERFINDER_MOBILENO_3);
			}
			else {
				bindMobileNo = true;

				sb.append(_FINDER_COLUMN_MOBILENUMBERFINDER_MOBILENO_2);
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

	private static final String _FINDER_COLUMN_MOBILENUMBERFINDER_MOBILENO_2 =
		"dgfUsers.mobileNo = ?";

	private static final String _FINDER_COLUMN_MOBILENUMBERFINDER_MOBILENO_3 =
		"(dgfUsers.mobileNo IS NULL OR dgfUsers.mobileNo = '')";

	private FinderPath _finderPathWithPaginationFindBynationalIdfinder;
	private FinderPath _finderPathWithoutPaginationFindBynationalIdfinder;
	private FinderPath _finderPathCountBynationalIdfinder;

	/**
	 * Returns all the dgf userses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf userses
	 */
	@Override
	public List<DgfUsers> findBynationalIdfinder(String nationalId) {
		return findBynationalIdfinder(
			nationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf userses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @return the range of matching dgf userses
	 */
	@Override
	public List<DgfUsers> findBynationalIdfinder(
		String nationalId, int start, int end) {

		return findBynationalIdfinder(nationalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf userses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf userses
	 */
	@Override
	public List<DgfUsers> findBynationalIdfinder(
		String nationalId, int start, int end,
		OrderByComparator<DgfUsers> orderByComparator) {

		return findBynationalIdfinder(
			nationalId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf userses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf userses
	 */
	@Override
	public List<DgfUsers> findBynationalIdfinder(
		String nationalId, int start, int end,
		OrderByComparator<DgfUsers> orderByComparator, boolean useFinderCache) {

		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBynationalIdfinder;
				finderArgs = new Object[] {nationalId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBynationalIdfinder;
			finderArgs = new Object[] {
				nationalId, start, end, orderByComparator
			};
		}

		List<DgfUsers> list = null;

		if (useFinderCache) {
			list = (List<DgfUsers>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfUsers dgfUsers : list) {
					if (!nationalId.equals(dgfUsers.getNationalId())) {
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

			sb.append(_SQL_SELECT_DGFUSERS_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_NATIONALIDFINDER_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(_FINDER_COLUMN_NATIONALIDFINDER_NATIONALID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfUsersModelImpl.ORDER_BY_JPQL);
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

				list = (List<DgfUsers>)QueryUtil.list(
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
	 * Returns the first dgf users in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users
	 * @throws NoSuchDgfUsersException if a matching dgf users could not be found
	 */
	@Override
	public DgfUsers findBynationalIdfinder_First(
			String nationalId, OrderByComparator<DgfUsers> orderByComparator)
		throws NoSuchDgfUsersException {

		DgfUsers dgfUsers = fetchBynationalIdfinder_First(
			nationalId, orderByComparator);

		if (dgfUsers != null) {
			return dgfUsers;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationalId=");
		sb.append(nationalId);

		sb.append("}");

		throw new NoSuchDgfUsersException(sb.toString());
	}

	/**
	 * Returns the first dgf users in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users, or <code>null</code> if a matching dgf users could not be found
	 */
	@Override
	public DgfUsers fetchBynationalIdfinder_First(
		String nationalId, OrderByComparator<DgfUsers> orderByComparator) {

		List<DgfUsers> list = findBynationalIdfinder(
			nationalId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf users in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users
	 * @throws NoSuchDgfUsersException if a matching dgf users could not be found
	 */
	@Override
	public DgfUsers findBynationalIdfinder_Last(
			String nationalId, OrderByComparator<DgfUsers> orderByComparator)
		throws NoSuchDgfUsersException {

		DgfUsers dgfUsers = fetchBynationalIdfinder_Last(
			nationalId, orderByComparator);

		if (dgfUsers != null) {
			return dgfUsers;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationalId=");
		sb.append(nationalId);

		sb.append("}");

		throw new NoSuchDgfUsersException(sb.toString());
	}

	/**
	 * Returns the last dgf users in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users, or <code>null</code> if a matching dgf users could not be found
	 */
	@Override
	public DgfUsers fetchBynationalIdfinder_Last(
		String nationalId, OrderByComparator<DgfUsers> orderByComparator) {

		int count = countBynationalIdfinder(nationalId);

		if (count == 0) {
			return null;
		}

		List<DgfUsers> list = findBynationalIdfinder(
			nationalId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf userses before and after the current dgf users in the ordered set where nationalId = &#63;.
	 *
	 * @param userId the primary key of the current dgf users
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users
	 * @throws NoSuchDgfUsersException if a dgf users with the primary key could not be found
	 */
	@Override
	public DgfUsers[] findBynationalIdfinder_PrevAndNext(
			long userId, String nationalId,
			OrderByComparator<DgfUsers> orderByComparator)
		throws NoSuchDgfUsersException {

		nationalId = Objects.toString(nationalId, "");

		DgfUsers dgfUsers = findByPrimaryKey(userId);

		Session session = null;

		try {
			session = openSession();

			DgfUsers[] array = new DgfUsersImpl[3];

			array[0] = getBynationalIdfinder_PrevAndNext(
				session, dgfUsers, nationalId, orderByComparator, true);

			array[1] = dgfUsers;

			array[2] = getBynationalIdfinder_PrevAndNext(
				session, dgfUsers, nationalId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DgfUsers getBynationalIdfinder_PrevAndNext(
		Session session, DgfUsers dgfUsers, String nationalId,
		OrderByComparator<DgfUsers> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DGFUSERS_WHERE);

		boolean bindNationalId = false;

		if (nationalId.isEmpty()) {
			sb.append(_FINDER_COLUMN_NATIONALIDFINDER_NATIONALID_3);
		}
		else {
			bindNationalId = true;

			sb.append(_FINDER_COLUMN_NATIONALIDFINDER_NATIONALID_2);
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
			sb.append(DgfUsersModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(dgfUsers)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfUsers> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf userses where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	@Override
	public void removeBynationalIdfinder(String nationalId) {
		for (DgfUsers dgfUsers :
				findBynationalIdfinder(
					nationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgfUsers);
		}
	}

	/**
	 * Returns the number of dgf userses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf userses
	 */
	@Override
	public int countBynationalIdfinder(String nationalId) {
		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = _finderPathCountBynationalIdfinder;

		Object[] finderArgs = new Object[] {nationalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFUSERS_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_NATIONALIDFINDER_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(_FINDER_COLUMN_NATIONALIDFINDER_NATIONALID_2);
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

	private static final String _FINDER_COLUMN_NATIONALIDFINDER_NATIONALID_2 =
		"dgfUsers.nationalId = ?";

	private static final String _FINDER_COLUMN_NATIONALIDFINDER_NATIONALID_3 =
		"(dgfUsers.nationalId IS NULL OR dgfUsers.nationalId = '')";

	private FinderPath _finderPathFetchByuserIdFinder;
	private FinderPath _finderPathCountByuserIdFinder;

	/**
	 * Returns the dgf users where userId = &#63; or throws a <code>NoSuchDgfUsersException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching dgf users
	 * @throws NoSuchDgfUsersException if a matching dgf users could not be found
	 */
	@Override
	public DgfUsers findByuserIdFinder(long userId)
		throws NoSuchDgfUsersException {

		DgfUsers dgfUsers = fetchByuserIdFinder(userId);

		if (dgfUsers == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("userId=");
			sb.append(userId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfUsersException(sb.toString());
		}

		return dgfUsers;
	}

	/**
	 * Returns the dgf users where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching dgf users, or <code>null</code> if a matching dgf users could not be found
	 */
	@Override
	public DgfUsers fetchByuserIdFinder(long userId) {
		return fetchByuserIdFinder(userId, true);
	}

	/**
	 * Returns the dgf users where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf users, or <code>null</code> if a matching dgf users could not be found
	 */
	@Override
	public DgfUsers fetchByuserIdFinder(long userId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {userId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByuserIdFinder, finderArgs, this);
		}

		if (result instanceof DgfUsers) {
			DgfUsers dgfUsers = (DgfUsers)result;

			if (userId != dgfUsers.getUserId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DGFUSERS_WHERE);

			sb.append(_FINDER_COLUMN_USERIDFINDER_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				List<DgfUsers> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByuserIdFinder, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {userId};
							}

							_log.warn(
								"DgfUsersPersistenceImpl.fetchByuserIdFinder(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DgfUsers dgfUsers = list.get(0);

					result = dgfUsers;

					cacheResult(dgfUsers);
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
			return (DgfUsers)result;
		}
	}

	/**
	 * Removes the dgf users where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the dgf users that was removed
	 */
	@Override
	public DgfUsers removeByuserIdFinder(long userId)
		throws NoSuchDgfUsersException {

		DgfUsers dgfUsers = findByuserIdFinder(userId);

		return remove(dgfUsers);
	}

	/**
	 * Returns the number of dgf userses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching dgf userses
	 */
	@Override
	public int countByuserIdFinder(long userId) {
		FinderPath finderPath = _finderPathCountByuserIdFinder;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFUSERS_WHERE);

			sb.append(_FINDER_COLUMN_USERIDFINDER_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERIDFINDER_USERID_2 =
		"dgfUsers.userId = ?";

	private FinderPath _finderPathFetchByDgfUsersByNationalId;
	private FinderPath _finderPathCountByDgfUsersByNationalId;

	/**
	 * Returns the dgf users where nationalId = &#63; or throws a <code>NoSuchDgfUsersException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf users
	 * @throws NoSuchDgfUsersException if a matching dgf users could not be found
	 */
	@Override
	public DgfUsers findByDgfUsersByNationalId(String nationalId)
		throws NoSuchDgfUsersException {

		DgfUsers dgfUsers = fetchByDgfUsersByNationalId(nationalId);

		if (dgfUsers == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("nationalId=");
			sb.append(nationalId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfUsersException(sb.toString());
		}

		return dgfUsers;
	}

	/**
	 * Returns the dgf users where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf users, or <code>null</code> if a matching dgf users could not be found
	 */
	@Override
	public DgfUsers fetchByDgfUsersByNationalId(String nationalId) {
		return fetchByDgfUsersByNationalId(nationalId, true);
	}

	/**
	 * Returns the dgf users where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf users, or <code>null</code> if a matching dgf users could not be found
	 */
	@Override
	public DgfUsers fetchByDgfUsersByNationalId(
		String nationalId, boolean useFinderCache) {

		nationalId = Objects.toString(nationalId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {nationalId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDgfUsersByNationalId, finderArgs, this);
		}

		if (result instanceof DgfUsers) {
			DgfUsers dgfUsers = (DgfUsers)result;

			if (!Objects.equals(nationalId, dgfUsers.getNationalId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DGFUSERS_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_DGFUSERSBYNATIONALID_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(_FINDER_COLUMN_DGFUSERSBYNATIONALID_NATIONALID_2);
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

				List<DgfUsers> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDgfUsersByNationalId, finderArgs,
							list);
					}
				}
				else {
					DgfUsers dgfUsers = list.get(0);

					result = dgfUsers;

					cacheResult(dgfUsers);
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
			return (DgfUsers)result;
		}
	}

	/**
	 * Removes the dgf users where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the dgf users that was removed
	 */
	@Override
	public DgfUsers removeByDgfUsersByNationalId(String nationalId)
		throws NoSuchDgfUsersException {

		DgfUsers dgfUsers = findByDgfUsersByNationalId(nationalId);

		return remove(dgfUsers);
	}

	/**
	 * Returns the number of dgf userses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf userses
	 */
	@Override
	public int countByDgfUsersByNationalId(String nationalId) {
		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = _finderPathCountByDgfUsersByNationalId;

		Object[] finderArgs = new Object[] {nationalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFUSERS_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_DGFUSERSBYNATIONALID_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(_FINDER_COLUMN_DGFUSERSBYNATIONALID_NATIONALID_2);
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
		_FINDER_COLUMN_DGFUSERSBYNATIONALID_NATIONALID_2 =
			"dgfUsers.nationalId = ?";

	private static final String
		_FINDER_COLUMN_DGFUSERSBYNATIONALID_NATIONALID_3 =
			"(dgfUsers.nationalId IS NULL OR dgfUsers.nationalId = '')";

	public DgfUsersPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("password", "password_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DgfUsers.class);

		setModelImplClass(DgfUsersImpl.class);
		setModelPKClass(long.class);

		setTable(DgfUsersTable.INSTANCE);
	}

	/**
	 * Caches the dgf users in the entity cache if it is enabled.
	 *
	 * @param dgfUsers the dgf users
	 */
	@Override
	public void cacheResult(DgfUsers dgfUsers) {
		entityCache.putResult(
			DgfUsersImpl.class, dgfUsers.getPrimaryKey(), dgfUsers);

		finderCache.putResult(
			_finderPathFetchByuserIdFinder, new Object[] {dgfUsers.getUserId()},
			dgfUsers);

		finderCache.putResult(
			_finderPathFetchByDgfUsersByNationalId,
			new Object[] {dgfUsers.getNationalId()}, dgfUsers);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dgf userses in the entity cache if it is enabled.
	 *
	 * @param dgfUserses the dgf userses
	 */
	@Override
	public void cacheResult(List<DgfUsers> dgfUserses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgfUserses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DgfUsers dgfUsers : dgfUserses) {
			if (entityCache.getResult(
					DgfUsersImpl.class, dgfUsers.getPrimaryKey()) == null) {

				cacheResult(dgfUsers);
			}
		}
	}

	/**
	 * Clears the cache for all dgf userses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DgfUsersImpl.class);

		finderCache.clearCache(DgfUsersImpl.class);
	}

	/**
	 * Clears the cache for the dgf users.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DgfUsers dgfUsers) {
		entityCache.removeResult(DgfUsersImpl.class, dgfUsers);
	}

	@Override
	public void clearCache(List<DgfUsers> dgfUserses) {
		for (DgfUsers dgfUsers : dgfUserses) {
			entityCache.removeResult(DgfUsersImpl.class, dgfUsers);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DgfUsersImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DgfUsersImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DgfUsersModelImpl dgfUsersModelImpl) {

		Object[] args = new Object[] {dgfUsersModelImpl.getUserId()};

		finderCache.putResult(
			_finderPathCountByuserIdFinder, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByuserIdFinder, args, dgfUsersModelImpl);

		args = new Object[] {dgfUsersModelImpl.getNationalId()};

		finderCache.putResult(
			_finderPathCountByDgfUsersByNationalId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDgfUsersByNationalId, args, dgfUsersModelImpl);
	}

	/**
	 * Creates a new dgf users with the primary key. Does not add the dgf users to the database.
	 *
	 * @param userId the primary key for the new dgf users
	 * @return the new dgf users
	 */
	@Override
	public DgfUsers create(long userId) {
		DgfUsers dgfUsers = new DgfUsersImpl();

		dgfUsers.setNew(true);
		dgfUsers.setPrimaryKey(userId);

		return dgfUsers;
	}

	/**
	 * Removes the dgf users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the dgf users
	 * @return the dgf users that was removed
	 * @throws NoSuchDgfUsersException if a dgf users with the primary key could not be found
	 */
	@Override
	public DgfUsers remove(long userId) throws NoSuchDgfUsersException {
		return remove((Serializable)userId);
	}

	/**
	 * Removes the dgf users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dgf users
	 * @return the dgf users that was removed
	 * @throws NoSuchDgfUsersException if a dgf users with the primary key could not be found
	 */
	@Override
	public DgfUsers remove(Serializable primaryKey)
		throws NoSuchDgfUsersException {

		Session session = null;

		try {
			session = openSession();

			DgfUsers dgfUsers = (DgfUsers)session.get(
				DgfUsersImpl.class, primaryKey);

			if (dgfUsers == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDgfUsersException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgfUsers);
		}
		catch (NoSuchDgfUsersException noSuchEntityException) {
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
	protected DgfUsers removeImpl(DgfUsers dgfUsers) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgfUsers)) {
				dgfUsers = (DgfUsers)session.get(
					DgfUsersImpl.class, dgfUsers.getPrimaryKeyObj());
			}

			if (dgfUsers != null) {
				session.delete(dgfUsers);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgfUsers != null) {
			clearCache(dgfUsers);
		}

		return dgfUsers;
	}

	@Override
	public DgfUsers updateImpl(DgfUsers dgfUsers) {
		boolean isNew = dgfUsers.isNew();

		if (!(dgfUsers instanceof DgfUsersModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dgfUsers.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(dgfUsers);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgfUsers proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DgfUsers implementation " +
					dgfUsers.getClass());
		}

		DgfUsersModelImpl dgfUsersModelImpl = (DgfUsersModelImpl)dgfUsers;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (dgfUsers.getCreateDate() == null)) {
			if (serviceContext == null) {
				dgfUsers.setCreateDate(date);
			}
			else {
				dgfUsers.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!dgfUsersModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				dgfUsers.setModifiedDate(date);
			}
			else {
				dgfUsers.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgfUsers);
			}
			else {
				dgfUsers = (DgfUsers)session.merge(dgfUsers);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DgfUsersImpl.class, dgfUsersModelImpl, false, true);

		cacheUniqueFindersCache(dgfUsersModelImpl);

		if (isNew) {
			dgfUsers.setNew(false);
		}

		dgfUsers.resetOriginalValues();

		return dgfUsers;
	}

	/**
	 * Returns the dgf users with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dgf users
	 * @return the dgf users
	 * @throws NoSuchDgfUsersException if a dgf users with the primary key could not be found
	 */
	@Override
	public DgfUsers findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDgfUsersException {

		DgfUsers dgfUsers = fetchByPrimaryKey(primaryKey);

		if (dgfUsers == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDgfUsersException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgfUsers;
	}

	/**
	 * Returns the dgf users with the primary key or throws a <code>NoSuchDgfUsersException</code> if it could not be found.
	 *
	 * @param userId the primary key of the dgf users
	 * @return the dgf users
	 * @throws NoSuchDgfUsersException if a dgf users with the primary key could not be found
	 */
	@Override
	public DgfUsers findByPrimaryKey(long userId)
		throws NoSuchDgfUsersException {

		return findByPrimaryKey((Serializable)userId);
	}

	/**
	 * Returns the dgf users with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the dgf users
	 * @return the dgf users, or <code>null</code> if a dgf users with the primary key could not be found
	 */
	@Override
	public DgfUsers fetchByPrimaryKey(long userId) {
		return fetchByPrimaryKey((Serializable)userId);
	}

	/**
	 * Returns all the dgf userses.
	 *
	 * @return the dgf userses
	 */
	@Override
	public List<DgfUsers> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @return the range of dgf userses
	 */
	@Override
	public List<DgfUsers> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf userses
	 */
	@Override
	public List<DgfUsers> findAll(
		int start, int end, OrderByComparator<DgfUsers> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf userses
	 */
	@Override
	public List<DgfUsers> findAll(
		int start, int end, OrderByComparator<DgfUsers> orderByComparator,
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

		List<DgfUsers> list = null;

		if (useFinderCache) {
			list = (List<DgfUsers>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFUSERS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFUSERS;

				sql = sql.concat(DgfUsersModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DgfUsers>)QueryUtil.list(
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
	 * Removes all the dgf userses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DgfUsers dgfUsers : findAll()) {
			remove(dgfUsers);
		}
	}

	/**
	 * Returns the number of dgf userses.
	 *
	 * @return the number of dgf userses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DGFUSERS);

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
		return "userId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DGFUSERS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DgfUsersModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dgf users persistence.
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

		_finderPathWithPaginationFindBymobileNumberFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBymobileNumberFinder",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"mobileNo"}, true);

		_finderPathWithoutPaginationFindBymobileNumberFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBymobileNumberFinder", new String[] {String.class.getName()},
			new String[] {"mobileNo"}, true);

		_finderPathCountBymobileNumberFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBymobileNumberFinder", new String[] {String.class.getName()},
			new String[] {"mobileNo"}, false);

		_finderPathWithPaginationFindBynationalIdfinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBynationalIdfinder",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"nationalId"}, true);

		_finderPathWithoutPaginationFindBynationalIdfinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBynationalIdfinder",
			new String[] {String.class.getName()}, new String[] {"nationalId"},
			true);

		_finderPathCountBynationalIdfinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBynationalIdfinder", new String[] {String.class.getName()},
			new String[] {"nationalId"}, false);

		_finderPathFetchByuserIdFinder = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByuserIdFinder",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByuserIdFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserIdFinder",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		_finderPathFetchByDgfUsersByNationalId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDgfUsersByNationalId",
			new String[] {String.class.getName()}, new String[] {"nationalId"},
			true);

		_finderPathCountByDgfUsersByNationalId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDgfUsersByNationalId",
			new String[] {String.class.getName()}, new String[] {"nationalId"},
			false);

		_setDgfUsersUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDgfUsersUtilPersistence(null);

		entityCache.removeCache(DgfUsersImpl.class.getName());
	}

	private void _setDgfUsersUtilPersistence(
		DgfUsersPersistence dgfUsersPersistence) {

		try {
			Field field = DgfUsersUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, dgfUsersPersistence);
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

	private static final String _SQL_SELECT_DGFUSERS =
		"SELECT dgfUsers FROM DgfUsers dgfUsers";

	private static final String _SQL_SELECT_DGFUSERS_WHERE =
		"SELECT dgfUsers FROM DgfUsers dgfUsers WHERE ";

	private static final String _SQL_COUNT_DGFUSERS =
		"SELECT COUNT(dgfUsers) FROM DgfUsers dgfUsers";

	private static final String _SQL_COUNT_DGFUSERS_WHERE =
		"SELECT COUNT(dgfUsers) FROM DgfUsers dgfUsers WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dgfUsers.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DgfUsers exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DgfUsers exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DgfUsersPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"password"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}