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

package bd.gov.dgfood.dealer.registration.service.persistence.impl;

import bd.gov.dgfood.dealer.registration.exception.NoSuchDgfDlrWithdrawalException;
import bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawal;
import bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawalTable;
import bd.gov.dgfood.dealer.registration.model.impl.DgfDlrWithdrawalImpl;
import bd.gov.dgfood.dealer.registration.model.impl.DgfDlrWithdrawalModelImpl;
import bd.gov.dgfood.dealer.registration.service.persistence.DgfDlrWithdrawalPersistence;
import bd.gov.dgfood.dealer.registration.service.persistence.DgfDlrWithdrawalUtil;
import bd.gov.dgfood.dealer.registration.service.persistence.impl.constants.DLRPersistenceConstants;

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
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the dgf dlr withdrawal service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DgfDlrWithdrawalPersistence.class)
public class DgfDlrWithdrawalPersistenceImpl
	extends BasePersistenceImpl<DgfDlrWithdrawal>
	implements DgfDlrWithdrawalPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DgfDlrWithdrawalUtil</code> to access the dgf dlr withdrawal persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DgfDlrWithdrawalImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByDlrWithdrawalByNationalId;
	private FinderPath
		_finderPathWithoutPaginationFindByDlrWithdrawalByNationalId;
	private FinderPath _finderPathCountByDlrWithdrawalByNationalId;

	/**
	 * Returns all the dgf dlr withdrawals where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf dlr withdrawals
	 */
	@Override
	public List<DgfDlrWithdrawal> findByDlrWithdrawalByNationalId(
		String nationalId) {

		return findByDlrWithdrawalByNationalId(
			nationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf dlr withdrawals where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrWithdrawalModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr withdrawals
	 * @param end the upper bound of the range of dgf dlr withdrawals (not inclusive)
	 * @return the range of matching dgf dlr withdrawals
	 */
	@Override
	public List<DgfDlrWithdrawal> findByDlrWithdrawalByNationalId(
		String nationalId, int start, int end) {

		return findByDlrWithdrawalByNationalId(nationalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf dlr withdrawals where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrWithdrawalModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr withdrawals
	 * @param end the upper bound of the range of dgf dlr withdrawals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf dlr withdrawals
	 */
	@Override
	public List<DgfDlrWithdrawal> findByDlrWithdrawalByNationalId(
		String nationalId, int start, int end,
		OrderByComparator<DgfDlrWithdrawal> orderByComparator) {

		return findByDlrWithdrawalByNationalId(
			nationalId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf dlr withdrawals where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrWithdrawalModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr withdrawals
	 * @param end the upper bound of the range of dgf dlr withdrawals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf dlr withdrawals
	 */
	@Override
	public List<DgfDlrWithdrawal> findByDlrWithdrawalByNationalId(
		String nationalId, int start, int end,
		OrderByComparator<DgfDlrWithdrawal> orderByComparator,
		boolean useFinderCache) {

		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByDlrWithdrawalByNationalId;
				finderArgs = new Object[] {nationalId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByDlrWithdrawalByNationalId;
			finderArgs = new Object[] {
				nationalId, start, end, orderByComparator
			};
		}

		List<DgfDlrWithdrawal> list = null;

		if (useFinderCache) {
			list = (List<DgfDlrWithdrawal>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfDlrWithdrawal dgfDlrWithdrawal : list) {
					if (!nationalId.equals(dgfDlrWithdrawal.getNationalId())) {
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

			sb.append(_SQL_SELECT_DGFDLRWITHDRAWAL_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DLRWITHDRAWALBYNATIONALID_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(
					_FINDER_COLUMN_DLRWITHDRAWALBYNATIONALID_NATIONALID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfDlrWithdrawalModelImpl.ORDER_BY_JPQL);
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

				list = (List<DgfDlrWithdrawal>)QueryUtil.list(
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
	 * Returns the first dgf dlr withdrawal in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr withdrawal
	 * @throws NoSuchDgfDlrWithdrawalException if a matching dgf dlr withdrawal could not be found
	 */
	@Override
	public DgfDlrWithdrawal findByDlrWithdrawalByNationalId_First(
			String nationalId,
			OrderByComparator<DgfDlrWithdrawal> orderByComparator)
		throws NoSuchDgfDlrWithdrawalException {

		DgfDlrWithdrawal dgfDlrWithdrawal =
			fetchByDlrWithdrawalByNationalId_First(
				nationalId, orderByComparator);

		if (dgfDlrWithdrawal != null) {
			return dgfDlrWithdrawal;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationalId=");
		sb.append(nationalId);

		sb.append("}");

		throw new NoSuchDgfDlrWithdrawalException(sb.toString());
	}

	/**
	 * Returns the first dgf dlr withdrawal in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr withdrawal, or <code>null</code> if a matching dgf dlr withdrawal could not be found
	 */
	@Override
	public DgfDlrWithdrawal fetchByDlrWithdrawalByNationalId_First(
		String nationalId,
		OrderByComparator<DgfDlrWithdrawal> orderByComparator) {

		List<DgfDlrWithdrawal> list = findByDlrWithdrawalByNationalId(
			nationalId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf dlr withdrawal in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr withdrawal
	 * @throws NoSuchDgfDlrWithdrawalException if a matching dgf dlr withdrawal could not be found
	 */
	@Override
	public DgfDlrWithdrawal findByDlrWithdrawalByNationalId_Last(
			String nationalId,
			OrderByComparator<DgfDlrWithdrawal> orderByComparator)
		throws NoSuchDgfDlrWithdrawalException {

		DgfDlrWithdrawal dgfDlrWithdrawal =
			fetchByDlrWithdrawalByNationalId_Last(
				nationalId, orderByComparator);

		if (dgfDlrWithdrawal != null) {
			return dgfDlrWithdrawal;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationalId=");
		sb.append(nationalId);

		sb.append("}");

		throw new NoSuchDgfDlrWithdrawalException(sb.toString());
	}

	/**
	 * Returns the last dgf dlr withdrawal in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr withdrawal, or <code>null</code> if a matching dgf dlr withdrawal could not be found
	 */
	@Override
	public DgfDlrWithdrawal fetchByDlrWithdrawalByNationalId_Last(
		String nationalId,
		OrderByComparator<DgfDlrWithdrawal> orderByComparator) {

		int count = countByDlrWithdrawalByNationalId(nationalId);

		if (count == 0) {
			return null;
		}

		List<DgfDlrWithdrawal> list = findByDlrWithdrawalByNationalId(
			nationalId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf dlr withdrawals before and after the current dgf dlr withdrawal in the ordered set where nationalId = &#63;.
	 *
	 * @param dlrWithdrawalId the primary key of the current dgf dlr withdrawal
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf dlr withdrawal
	 * @throws NoSuchDgfDlrWithdrawalException if a dgf dlr withdrawal with the primary key could not be found
	 */
	@Override
	public DgfDlrWithdrawal[] findByDlrWithdrawalByNationalId_PrevAndNext(
			long dlrWithdrawalId, String nationalId,
			OrderByComparator<DgfDlrWithdrawal> orderByComparator)
		throws NoSuchDgfDlrWithdrawalException {

		nationalId = Objects.toString(nationalId, "");

		DgfDlrWithdrawal dgfDlrWithdrawal = findByPrimaryKey(dlrWithdrawalId);

		Session session = null;

		try {
			session = openSession();

			DgfDlrWithdrawal[] array = new DgfDlrWithdrawalImpl[3];

			array[0] = getByDlrWithdrawalByNationalId_PrevAndNext(
				session, dgfDlrWithdrawal, nationalId, orderByComparator, true);

			array[1] = dgfDlrWithdrawal;

			array[2] = getByDlrWithdrawalByNationalId_PrevAndNext(
				session, dgfDlrWithdrawal, nationalId, orderByComparator,
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

	protected DgfDlrWithdrawal getByDlrWithdrawalByNationalId_PrevAndNext(
		Session session, DgfDlrWithdrawal dgfDlrWithdrawal, String nationalId,
		OrderByComparator<DgfDlrWithdrawal> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFDLRWITHDRAWAL_WHERE);

		boolean bindNationalId = false;

		if (nationalId.isEmpty()) {
			sb.append(_FINDER_COLUMN_DLRWITHDRAWALBYNATIONALID_NATIONALID_3);
		}
		else {
			bindNationalId = true;

			sb.append(_FINDER_COLUMN_DLRWITHDRAWALBYNATIONALID_NATIONALID_2);
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
			sb.append(DgfDlrWithdrawalModelImpl.ORDER_BY_JPQL);
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
						dgfDlrWithdrawal)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfDlrWithdrawal> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf dlr withdrawals where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	@Override
	public void removeByDlrWithdrawalByNationalId(String nationalId) {
		for (DgfDlrWithdrawal dgfDlrWithdrawal :
				findByDlrWithdrawalByNationalId(
					nationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgfDlrWithdrawal);
		}
	}

	/**
	 * Returns the number of dgf dlr withdrawals where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf dlr withdrawals
	 */
	@Override
	public int countByDlrWithdrawalByNationalId(String nationalId) {
		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = _finderPathCountByDlrWithdrawalByNationalId;

		Object[] finderArgs = new Object[] {nationalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFDLRWITHDRAWAL_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DLRWITHDRAWALBYNATIONALID_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(
					_FINDER_COLUMN_DLRWITHDRAWALBYNATIONALID_NATIONALID_2);
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
		_FINDER_COLUMN_DLRWITHDRAWALBYNATIONALID_NATIONALID_2 =
			"dgfDlrWithdrawal.nationalId = ?";

	private static final String
		_FINDER_COLUMN_DLRWITHDRAWALBYNATIONALID_NATIONALID_3 =
			"(dgfDlrWithdrawal.nationalId IS NULL OR dgfDlrWithdrawal.nationalId = '')";

	private FinderPath _finderPathWithPaginationFindByDlrWithdrawalByLicenseNo;
	private FinderPath
		_finderPathWithoutPaginationFindByDlrWithdrawalByLicenseNo;
	private FinderPath _finderPathCountByDlrWithdrawalByLicenseNo;

	/**
	 * Returns all the dgf dlr withdrawals where licenseNo = &#63;.
	 *
	 * @param licenseNo the license no
	 * @return the matching dgf dlr withdrawals
	 */
	@Override
	public List<DgfDlrWithdrawal> findByDlrWithdrawalByLicenseNo(
		String licenseNo) {

		return findByDlrWithdrawalByLicenseNo(
			licenseNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf dlr withdrawals where licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrWithdrawalModelImpl</code>.
	 * </p>
	 *
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf dlr withdrawals
	 * @param end the upper bound of the range of dgf dlr withdrawals (not inclusive)
	 * @return the range of matching dgf dlr withdrawals
	 */
	@Override
	public List<DgfDlrWithdrawal> findByDlrWithdrawalByLicenseNo(
		String licenseNo, int start, int end) {

		return findByDlrWithdrawalByLicenseNo(licenseNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf dlr withdrawals where licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrWithdrawalModelImpl</code>.
	 * </p>
	 *
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf dlr withdrawals
	 * @param end the upper bound of the range of dgf dlr withdrawals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf dlr withdrawals
	 */
	@Override
	public List<DgfDlrWithdrawal> findByDlrWithdrawalByLicenseNo(
		String licenseNo, int start, int end,
		OrderByComparator<DgfDlrWithdrawal> orderByComparator) {

		return findByDlrWithdrawalByLicenseNo(
			licenseNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf dlr withdrawals where licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrWithdrawalModelImpl</code>.
	 * </p>
	 *
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf dlr withdrawals
	 * @param end the upper bound of the range of dgf dlr withdrawals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf dlr withdrawals
	 */
	@Override
	public List<DgfDlrWithdrawal> findByDlrWithdrawalByLicenseNo(
		String licenseNo, int start, int end,
		OrderByComparator<DgfDlrWithdrawal> orderByComparator,
		boolean useFinderCache) {

		licenseNo = Objects.toString(licenseNo, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByDlrWithdrawalByLicenseNo;
				finderArgs = new Object[] {licenseNo};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByDlrWithdrawalByLicenseNo;
			finderArgs = new Object[] {
				licenseNo, start, end, orderByComparator
			};
		}

		List<DgfDlrWithdrawal> list = null;

		if (useFinderCache) {
			list = (List<DgfDlrWithdrawal>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfDlrWithdrawal dgfDlrWithdrawal : list) {
					if (!licenseNo.equals(dgfDlrWithdrawal.getLicenseNo())) {
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

			sb.append(_SQL_SELECT_DGFDLRWITHDRAWAL_WHERE);

			boolean bindLicenseNo = false;

			if (licenseNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_DLRWITHDRAWALBYLICENSENO_LICENSENO_3);
			}
			else {
				bindLicenseNo = true;

				sb.append(_FINDER_COLUMN_DLRWITHDRAWALBYLICENSENO_LICENSENO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfDlrWithdrawalModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLicenseNo) {
					queryPos.add(licenseNo);
				}

				list = (List<DgfDlrWithdrawal>)QueryUtil.list(
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
	 * Returns the first dgf dlr withdrawal in the ordered set where licenseNo = &#63;.
	 *
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr withdrawal
	 * @throws NoSuchDgfDlrWithdrawalException if a matching dgf dlr withdrawal could not be found
	 */
	@Override
	public DgfDlrWithdrawal findByDlrWithdrawalByLicenseNo_First(
			String licenseNo,
			OrderByComparator<DgfDlrWithdrawal> orderByComparator)
		throws NoSuchDgfDlrWithdrawalException {

		DgfDlrWithdrawal dgfDlrWithdrawal =
			fetchByDlrWithdrawalByLicenseNo_First(licenseNo, orderByComparator);

		if (dgfDlrWithdrawal != null) {
			return dgfDlrWithdrawal;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("licenseNo=");
		sb.append(licenseNo);

		sb.append("}");

		throw new NoSuchDgfDlrWithdrawalException(sb.toString());
	}

	/**
	 * Returns the first dgf dlr withdrawal in the ordered set where licenseNo = &#63;.
	 *
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr withdrawal, or <code>null</code> if a matching dgf dlr withdrawal could not be found
	 */
	@Override
	public DgfDlrWithdrawal fetchByDlrWithdrawalByLicenseNo_First(
		String licenseNo,
		OrderByComparator<DgfDlrWithdrawal> orderByComparator) {

		List<DgfDlrWithdrawal> list = findByDlrWithdrawalByLicenseNo(
			licenseNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf dlr withdrawal in the ordered set where licenseNo = &#63;.
	 *
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr withdrawal
	 * @throws NoSuchDgfDlrWithdrawalException if a matching dgf dlr withdrawal could not be found
	 */
	@Override
	public DgfDlrWithdrawal findByDlrWithdrawalByLicenseNo_Last(
			String licenseNo,
			OrderByComparator<DgfDlrWithdrawal> orderByComparator)
		throws NoSuchDgfDlrWithdrawalException {

		DgfDlrWithdrawal dgfDlrWithdrawal =
			fetchByDlrWithdrawalByLicenseNo_Last(licenseNo, orderByComparator);

		if (dgfDlrWithdrawal != null) {
			return dgfDlrWithdrawal;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("licenseNo=");
		sb.append(licenseNo);

		sb.append("}");

		throw new NoSuchDgfDlrWithdrawalException(sb.toString());
	}

	/**
	 * Returns the last dgf dlr withdrawal in the ordered set where licenseNo = &#63;.
	 *
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr withdrawal, or <code>null</code> if a matching dgf dlr withdrawal could not be found
	 */
	@Override
	public DgfDlrWithdrawal fetchByDlrWithdrawalByLicenseNo_Last(
		String licenseNo,
		OrderByComparator<DgfDlrWithdrawal> orderByComparator) {

		int count = countByDlrWithdrawalByLicenseNo(licenseNo);

		if (count == 0) {
			return null;
		}

		List<DgfDlrWithdrawal> list = findByDlrWithdrawalByLicenseNo(
			licenseNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf dlr withdrawals before and after the current dgf dlr withdrawal in the ordered set where licenseNo = &#63;.
	 *
	 * @param dlrWithdrawalId the primary key of the current dgf dlr withdrawal
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf dlr withdrawal
	 * @throws NoSuchDgfDlrWithdrawalException if a dgf dlr withdrawal with the primary key could not be found
	 */
	@Override
	public DgfDlrWithdrawal[] findByDlrWithdrawalByLicenseNo_PrevAndNext(
			long dlrWithdrawalId, String licenseNo,
			OrderByComparator<DgfDlrWithdrawal> orderByComparator)
		throws NoSuchDgfDlrWithdrawalException {

		licenseNo = Objects.toString(licenseNo, "");

		DgfDlrWithdrawal dgfDlrWithdrawal = findByPrimaryKey(dlrWithdrawalId);

		Session session = null;

		try {
			session = openSession();

			DgfDlrWithdrawal[] array = new DgfDlrWithdrawalImpl[3];

			array[0] = getByDlrWithdrawalByLicenseNo_PrevAndNext(
				session, dgfDlrWithdrawal, licenseNo, orderByComparator, true);

			array[1] = dgfDlrWithdrawal;

			array[2] = getByDlrWithdrawalByLicenseNo_PrevAndNext(
				session, dgfDlrWithdrawal, licenseNo, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DgfDlrWithdrawal getByDlrWithdrawalByLicenseNo_PrevAndNext(
		Session session, DgfDlrWithdrawal dgfDlrWithdrawal, String licenseNo,
		OrderByComparator<DgfDlrWithdrawal> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFDLRWITHDRAWAL_WHERE);

		boolean bindLicenseNo = false;

		if (licenseNo.isEmpty()) {
			sb.append(_FINDER_COLUMN_DLRWITHDRAWALBYLICENSENO_LICENSENO_3);
		}
		else {
			bindLicenseNo = true;

			sb.append(_FINDER_COLUMN_DLRWITHDRAWALBYLICENSENO_LICENSENO_2);
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
			sb.append(DgfDlrWithdrawalModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindLicenseNo) {
			queryPos.add(licenseNo);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfDlrWithdrawal)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfDlrWithdrawal> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf dlr withdrawals where licenseNo = &#63; from the database.
	 *
	 * @param licenseNo the license no
	 */
	@Override
	public void removeByDlrWithdrawalByLicenseNo(String licenseNo) {
		for (DgfDlrWithdrawal dgfDlrWithdrawal :
				findByDlrWithdrawalByLicenseNo(
					licenseNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgfDlrWithdrawal);
		}
	}

	/**
	 * Returns the number of dgf dlr withdrawals where licenseNo = &#63;.
	 *
	 * @param licenseNo the license no
	 * @return the number of matching dgf dlr withdrawals
	 */
	@Override
	public int countByDlrWithdrawalByLicenseNo(String licenseNo) {
		licenseNo = Objects.toString(licenseNo, "");

		FinderPath finderPath = _finderPathCountByDlrWithdrawalByLicenseNo;

		Object[] finderArgs = new Object[] {licenseNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFDLRWITHDRAWAL_WHERE);

			boolean bindLicenseNo = false;

			if (licenseNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_DLRWITHDRAWALBYLICENSENO_LICENSENO_3);
			}
			else {
				bindLicenseNo = true;

				sb.append(_FINDER_COLUMN_DLRWITHDRAWALBYLICENSENO_LICENSENO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLicenseNo) {
					queryPos.add(licenseNo);
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
		_FINDER_COLUMN_DLRWITHDRAWALBYLICENSENO_LICENSENO_2 =
			"dgfDlrWithdrawal.licenseNo = ?";

	private static final String
		_FINDER_COLUMN_DLRWITHDRAWALBYLICENSENO_LICENSENO_3 =
			"(dgfDlrWithdrawal.licenseNo IS NULL OR dgfDlrWithdrawal.licenseNo = '')";

	private FinderPath _finderPathFetchByDlrWithdrawalByNationalIdAndLicenseNo;
	private FinderPath _finderPathCountByDlrWithdrawalByNationalIdAndLicenseNo;

	/**
	 * Returns the dgf dlr withdrawal where nationalId = &#63; and licenseNo = &#63; and dlrRegNo = &#63; or throws a <code>NoSuchDgfDlrWithdrawalException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param dlrRegNo the dlr reg no
	 * @return the matching dgf dlr withdrawal
	 * @throws NoSuchDgfDlrWithdrawalException if a matching dgf dlr withdrawal could not be found
	 */
	@Override
	public DgfDlrWithdrawal findByDlrWithdrawalByNationalIdAndLicenseNo(
			String nationalId, String licenseNo, long dlrRegNo)
		throws NoSuchDgfDlrWithdrawalException {

		DgfDlrWithdrawal dgfDlrWithdrawal =
			fetchByDlrWithdrawalByNationalIdAndLicenseNo(
				nationalId, licenseNo, dlrRegNo);

		if (dgfDlrWithdrawal == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("nationalId=");
			sb.append(nationalId);

			sb.append(", licenseNo=");
			sb.append(licenseNo);

			sb.append(", dlrRegNo=");
			sb.append(dlrRegNo);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfDlrWithdrawalException(sb.toString());
		}

		return dgfDlrWithdrawal;
	}

	/**
	 * Returns the dgf dlr withdrawal where nationalId = &#63; and licenseNo = &#63; and dlrRegNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param dlrRegNo the dlr reg no
	 * @return the matching dgf dlr withdrawal, or <code>null</code> if a matching dgf dlr withdrawal could not be found
	 */
	@Override
	public DgfDlrWithdrawal fetchByDlrWithdrawalByNationalIdAndLicenseNo(
		String nationalId, String licenseNo, long dlrRegNo) {

		return fetchByDlrWithdrawalByNationalIdAndLicenseNo(
			nationalId, licenseNo, dlrRegNo, true);
	}

	/**
	 * Returns the dgf dlr withdrawal where nationalId = &#63; and licenseNo = &#63; and dlrRegNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param dlrRegNo the dlr reg no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf dlr withdrawal, or <code>null</code> if a matching dgf dlr withdrawal could not be found
	 */
	@Override
	public DgfDlrWithdrawal fetchByDlrWithdrawalByNationalIdAndLicenseNo(
		String nationalId, String licenseNo, long dlrRegNo,
		boolean useFinderCache) {

		nationalId = Objects.toString(nationalId, "");
		licenseNo = Objects.toString(licenseNo, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {nationalId, licenseNo, dlrRegNo};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDlrWithdrawalByNationalIdAndLicenseNo,
				finderArgs, this);
		}

		if (result instanceof DgfDlrWithdrawal) {
			DgfDlrWithdrawal dgfDlrWithdrawal = (DgfDlrWithdrawal)result;

			if (!Objects.equals(nationalId, dgfDlrWithdrawal.getNationalId()) ||
				!Objects.equals(licenseNo, dgfDlrWithdrawal.getLicenseNo()) ||
				(dlrRegNo != dgfDlrWithdrawal.getDlrRegNo())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_DGFDLRWITHDRAWAL_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DLRWITHDRAWALBYNATIONALIDANDLICENSENO_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(
					_FINDER_COLUMN_DLRWITHDRAWALBYNATIONALIDANDLICENSENO_NATIONALID_2);
			}

			boolean bindLicenseNo = false;

			if (licenseNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DLRWITHDRAWALBYNATIONALIDANDLICENSENO_LICENSENO_3);
			}
			else {
				bindLicenseNo = true;

				sb.append(
					_FINDER_COLUMN_DLRWITHDRAWALBYNATIONALIDANDLICENSENO_LICENSENO_2);
			}

			sb.append(
				_FINDER_COLUMN_DLRWITHDRAWALBYNATIONALIDANDLICENSENO_DLRREGNO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNationalId) {
					queryPos.add(nationalId);
				}

				if (bindLicenseNo) {
					queryPos.add(licenseNo);
				}

				queryPos.add(dlrRegNo);

				List<DgfDlrWithdrawal> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDlrWithdrawalByNationalIdAndLicenseNo,
							finderArgs, list);
					}
				}
				else {
					DgfDlrWithdrawal dgfDlrWithdrawal = list.get(0);

					result = dgfDlrWithdrawal;

					cacheResult(dgfDlrWithdrawal);
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
			return (DgfDlrWithdrawal)result;
		}
	}

	/**
	 * Removes the dgf dlr withdrawal where nationalId = &#63; and licenseNo = &#63; and dlrRegNo = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param dlrRegNo the dlr reg no
	 * @return the dgf dlr withdrawal that was removed
	 */
	@Override
	public DgfDlrWithdrawal removeByDlrWithdrawalByNationalIdAndLicenseNo(
			String nationalId, String licenseNo, long dlrRegNo)
		throws NoSuchDgfDlrWithdrawalException {

		DgfDlrWithdrawal dgfDlrWithdrawal =
			findByDlrWithdrawalByNationalIdAndLicenseNo(
				nationalId, licenseNo, dlrRegNo);

		return remove(dgfDlrWithdrawal);
	}

	/**
	 * Returns the number of dgf dlr withdrawals where nationalId = &#63; and licenseNo = &#63; and dlrRegNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param dlrRegNo the dlr reg no
	 * @return the number of matching dgf dlr withdrawals
	 */
	@Override
	public int countByDlrWithdrawalByNationalIdAndLicenseNo(
		String nationalId, String licenseNo, long dlrRegNo) {

		nationalId = Objects.toString(nationalId, "");
		licenseNo = Objects.toString(licenseNo, "");

		FinderPath finderPath =
			_finderPathCountByDlrWithdrawalByNationalIdAndLicenseNo;

		Object[] finderArgs = new Object[] {nationalId, licenseNo, dlrRegNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DGFDLRWITHDRAWAL_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DLRWITHDRAWALBYNATIONALIDANDLICENSENO_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(
					_FINDER_COLUMN_DLRWITHDRAWALBYNATIONALIDANDLICENSENO_NATIONALID_2);
			}

			boolean bindLicenseNo = false;

			if (licenseNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DLRWITHDRAWALBYNATIONALIDANDLICENSENO_LICENSENO_3);
			}
			else {
				bindLicenseNo = true;

				sb.append(
					_FINDER_COLUMN_DLRWITHDRAWALBYNATIONALIDANDLICENSENO_LICENSENO_2);
			}

			sb.append(
				_FINDER_COLUMN_DLRWITHDRAWALBYNATIONALIDANDLICENSENO_DLRREGNO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNationalId) {
					queryPos.add(nationalId);
				}

				if (bindLicenseNo) {
					queryPos.add(licenseNo);
				}

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

	private static final String
		_FINDER_COLUMN_DLRWITHDRAWALBYNATIONALIDANDLICENSENO_NATIONALID_2 =
			"dgfDlrWithdrawal.nationalId = ? AND ";

	private static final String
		_FINDER_COLUMN_DLRWITHDRAWALBYNATIONALIDANDLICENSENO_NATIONALID_3 =
			"(dgfDlrWithdrawal.nationalId IS NULL OR dgfDlrWithdrawal.nationalId = '') AND ";

	private static final String
		_FINDER_COLUMN_DLRWITHDRAWALBYNATIONALIDANDLICENSENO_LICENSENO_2 =
			"dgfDlrWithdrawal.licenseNo = ? AND ";

	private static final String
		_FINDER_COLUMN_DLRWITHDRAWALBYNATIONALIDANDLICENSENO_LICENSENO_3 =
			"(dgfDlrWithdrawal.licenseNo IS NULL OR dgfDlrWithdrawal.licenseNo = '') AND ";

	private static final String
		_FINDER_COLUMN_DLRWITHDRAWALBYNATIONALIDANDLICENSENO_DLRREGNO_2 =
			"dgfDlrWithdrawal.dlrRegNo = ?";

	public DgfDlrWithdrawalPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("dlrWithdrawalId", "dlr_withdrawal_id");
		dbColumnNames.put("nationalId", "national_id");
		dbColumnNames.put("licenseNo", "license_no");
		dbColumnNames.put("dealerName", "dealer_name");
		dbColumnNames.put("mobileNo", "mobile_no");
		dbColumnNames.put("programType", "program_type");
		dbColumnNames.put("omsSubType", "oms_sub_type");
		dbColumnNames.put("createdDate", "created_date");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("userId", "user_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("dlrRegNo", "dlr_reg_no");
		dbColumnNames.put("regApplNo", "reg_appl_no");
		dbColumnNames.put("statusByUserId", "status_by_user_id");
		dbColumnNames.put("statusByUserName", "status_by_user_name");
		dbColumnNames.put("statusDate", "status_date");

		setDBColumnNames(dbColumnNames);

		setModelClass(DgfDlrWithdrawal.class);

		setModelImplClass(DgfDlrWithdrawalImpl.class);
		setModelPKClass(long.class);

		setTable(DgfDlrWithdrawalTable.INSTANCE);
	}

	/**
	 * Caches the dgf dlr withdrawal in the entity cache if it is enabled.
	 *
	 * @param dgfDlrWithdrawal the dgf dlr withdrawal
	 */
	@Override
	public void cacheResult(DgfDlrWithdrawal dgfDlrWithdrawal) {
		entityCache.putResult(
			DgfDlrWithdrawalImpl.class, dgfDlrWithdrawal.getPrimaryKey(),
			dgfDlrWithdrawal);

		finderCache.putResult(
			_finderPathFetchByDlrWithdrawalByNationalIdAndLicenseNo,
			new Object[] {
				dgfDlrWithdrawal.getNationalId(),
				dgfDlrWithdrawal.getLicenseNo(), dgfDlrWithdrawal.getDlrRegNo()
			},
			dgfDlrWithdrawal);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dgf dlr withdrawals in the entity cache if it is enabled.
	 *
	 * @param dgfDlrWithdrawals the dgf dlr withdrawals
	 */
	@Override
	public void cacheResult(List<DgfDlrWithdrawal> dgfDlrWithdrawals) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgfDlrWithdrawals.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DgfDlrWithdrawal dgfDlrWithdrawal : dgfDlrWithdrawals) {
			if (entityCache.getResult(
					DgfDlrWithdrawalImpl.class,
					dgfDlrWithdrawal.getPrimaryKey()) == null) {

				cacheResult(dgfDlrWithdrawal);
			}
		}
	}

	/**
	 * Clears the cache for all dgf dlr withdrawals.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DgfDlrWithdrawalImpl.class);

		finderCache.clearCache(DgfDlrWithdrawalImpl.class);
	}

	/**
	 * Clears the cache for the dgf dlr withdrawal.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DgfDlrWithdrawal dgfDlrWithdrawal) {
		entityCache.removeResult(DgfDlrWithdrawalImpl.class, dgfDlrWithdrawal);
	}

	@Override
	public void clearCache(List<DgfDlrWithdrawal> dgfDlrWithdrawals) {
		for (DgfDlrWithdrawal dgfDlrWithdrawal : dgfDlrWithdrawals) {
			entityCache.removeResult(
				DgfDlrWithdrawalImpl.class, dgfDlrWithdrawal);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DgfDlrWithdrawalImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DgfDlrWithdrawalImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DgfDlrWithdrawalModelImpl dgfDlrWithdrawalModelImpl) {

		Object[] args = new Object[] {
			dgfDlrWithdrawalModelImpl.getNationalId(),
			dgfDlrWithdrawalModelImpl.getLicenseNo(),
			dgfDlrWithdrawalModelImpl.getDlrRegNo()
		};

		finderCache.putResult(
			_finderPathCountByDlrWithdrawalByNationalIdAndLicenseNo, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDlrWithdrawalByNationalIdAndLicenseNo, args,
			dgfDlrWithdrawalModelImpl);
	}

	/**
	 * Creates a new dgf dlr withdrawal with the primary key. Does not add the dgf dlr withdrawal to the database.
	 *
	 * @param dlrWithdrawalId the primary key for the new dgf dlr withdrawal
	 * @return the new dgf dlr withdrawal
	 */
	@Override
	public DgfDlrWithdrawal create(long dlrWithdrawalId) {
		DgfDlrWithdrawal dgfDlrWithdrawal = new DgfDlrWithdrawalImpl();

		dgfDlrWithdrawal.setNew(true);
		dgfDlrWithdrawal.setPrimaryKey(dlrWithdrawalId);

		dgfDlrWithdrawal.setCompanyId(CompanyThreadLocal.getCompanyId());

		return dgfDlrWithdrawal;
	}

	/**
	 * Removes the dgf dlr withdrawal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dlrWithdrawalId the primary key of the dgf dlr withdrawal
	 * @return the dgf dlr withdrawal that was removed
	 * @throws NoSuchDgfDlrWithdrawalException if a dgf dlr withdrawal with the primary key could not be found
	 */
	@Override
	public DgfDlrWithdrawal remove(long dlrWithdrawalId)
		throws NoSuchDgfDlrWithdrawalException {

		return remove((Serializable)dlrWithdrawalId);
	}

	/**
	 * Removes the dgf dlr withdrawal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dgf dlr withdrawal
	 * @return the dgf dlr withdrawal that was removed
	 * @throws NoSuchDgfDlrWithdrawalException if a dgf dlr withdrawal with the primary key could not be found
	 */
	@Override
	public DgfDlrWithdrawal remove(Serializable primaryKey)
		throws NoSuchDgfDlrWithdrawalException {

		Session session = null;

		try {
			session = openSession();

			DgfDlrWithdrawal dgfDlrWithdrawal = (DgfDlrWithdrawal)session.get(
				DgfDlrWithdrawalImpl.class, primaryKey);

			if (dgfDlrWithdrawal == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDgfDlrWithdrawalException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgfDlrWithdrawal);
		}
		catch (NoSuchDgfDlrWithdrawalException noSuchEntityException) {
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
	protected DgfDlrWithdrawal removeImpl(DgfDlrWithdrawal dgfDlrWithdrawal) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgfDlrWithdrawal)) {
				dgfDlrWithdrawal = (DgfDlrWithdrawal)session.get(
					DgfDlrWithdrawalImpl.class,
					dgfDlrWithdrawal.getPrimaryKeyObj());
			}

			if (dgfDlrWithdrawal != null) {
				session.delete(dgfDlrWithdrawal);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgfDlrWithdrawal != null) {
			clearCache(dgfDlrWithdrawal);
		}

		return dgfDlrWithdrawal;
	}

	@Override
	public DgfDlrWithdrawal updateImpl(DgfDlrWithdrawal dgfDlrWithdrawal) {
		boolean isNew = dgfDlrWithdrawal.isNew();

		if (!(dgfDlrWithdrawal instanceof DgfDlrWithdrawalModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dgfDlrWithdrawal.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dgfDlrWithdrawal);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgfDlrWithdrawal proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DgfDlrWithdrawal implementation " +
					dgfDlrWithdrawal.getClass());
		}

		DgfDlrWithdrawalModelImpl dgfDlrWithdrawalModelImpl =
			(DgfDlrWithdrawalModelImpl)dgfDlrWithdrawal;

		if (!dgfDlrWithdrawalModelImpl.hasSetModifiedDate()) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				dgfDlrWithdrawal.setModifiedDate(date);
			}
			else {
				dgfDlrWithdrawal.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgfDlrWithdrawal);
			}
			else {
				dgfDlrWithdrawal = (DgfDlrWithdrawal)session.merge(
					dgfDlrWithdrawal);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DgfDlrWithdrawalImpl.class, dgfDlrWithdrawalModelImpl, false, true);

		cacheUniqueFindersCache(dgfDlrWithdrawalModelImpl);

		if (isNew) {
			dgfDlrWithdrawal.setNew(false);
		}

		dgfDlrWithdrawal.resetOriginalValues();

		return dgfDlrWithdrawal;
	}

	/**
	 * Returns the dgf dlr withdrawal with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dgf dlr withdrawal
	 * @return the dgf dlr withdrawal
	 * @throws NoSuchDgfDlrWithdrawalException if a dgf dlr withdrawal with the primary key could not be found
	 */
	@Override
	public DgfDlrWithdrawal findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDgfDlrWithdrawalException {

		DgfDlrWithdrawal dgfDlrWithdrawal = fetchByPrimaryKey(primaryKey);

		if (dgfDlrWithdrawal == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDgfDlrWithdrawalException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgfDlrWithdrawal;
	}

	/**
	 * Returns the dgf dlr withdrawal with the primary key or throws a <code>NoSuchDgfDlrWithdrawalException</code> if it could not be found.
	 *
	 * @param dlrWithdrawalId the primary key of the dgf dlr withdrawal
	 * @return the dgf dlr withdrawal
	 * @throws NoSuchDgfDlrWithdrawalException if a dgf dlr withdrawal with the primary key could not be found
	 */
	@Override
	public DgfDlrWithdrawal findByPrimaryKey(long dlrWithdrawalId)
		throws NoSuchDgfDlrWithdrawalException {

		return findByPrimaryKey((Serializable)dlrWithdrawalId);
	}

	/**
	 * Returns the dgf dlr withdrawal with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dlrWithdrawalId the primary key of the dgf dlr withdrawal
	 * @return the dgf dlr withdrawal, or <code>null</code> if a dgf dlr withdrawal with the primary key could not be found
	 */
	@Override
	public DgfDlrWithdrawal fetchByPrimaryKey(long dlrWithdrawalId) {
		return fetchByPrimaryKey((Serializable)dlrWithdrawalId);
	}

	/**
	 * Returns all the dgf dlr withdrawals.
	 *
	 * @return the dgf dlr withdrawals
	 */
	@Override
	public List<DgfDlrWithdrawal> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf dlr withdrawals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrWithdrawalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr withdrawals
	 * @param end the upper bound of the range of dgf dlr withdrawals (not inclusive)
	 * @return the range of dgf dlr withdrawals
	 */
	@Override
	public List<DgfDlrWithdrawal> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf dlr withdrawals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrWithdrawalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr withdrawals
	 * @param end the upper bound of the range of dgf dlr withdrawals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf dlr withdrawals
	 */
	@Override
	public List<DgfDlrWithdrawal> findAll(
		int start, int end,
		OrderByComparator<DgfDlrWithdrawal> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf dlr withdrawals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrWithdrawalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr withdrawals
	 * @param end the upper bound of the range of dgf dlr withdrawals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf dlr withdrawals
	 */
	@Override
	public List<DgfDlrWithdrawal> findAll(
		int start, int end,
		OrderByComparator<DgfDlrWithdrawal> orderByComparator,
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

		List<DgfDlrWithdrawal> list = null;

		if (useFinderCache) {
			list = (List<DgfDlrWithdrawal>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFDLRWITHDRAWAL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFDLRWITHDRAWAL;

				sql = sql.concat(DgfDlrWithdrawalModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DgfDlrWithdrawal>)QueryUtil.list(
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
	 * Removes all the dgf dlr withdrawals from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DgfDlrWithdrawal dgfDlrWithdrawal : findAll()) {
			remove(dgfDlrWithdrawal);
		}
	}

	/**
	 * Returns the number of dgf dlr withdrawals.
	 *
	 * @return the number of dgf dlr withdrawals
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DGFDLRWITHDRAWAL);

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
		return "dlr_withdrawal_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DGFDLRWITHDRAWAL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DgfDlrWithdrawalModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dgf dlr withdrawal persistence.
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

		_finderPathWithPaginationFindByDlrWithdrawalByNationalId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByDlrWithdrawalByNationalId",
				new String[] {
					String.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"national_id"}, true);

		_finderPathWithoutPaginationFindByDlrWithdrawalByNationalId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByDlrWithdrawalByNationalId",
				new String[] {String.class.getName()},
				new String[] {"national_id"}, true);

		_finderPathCountByDlrWithdrawalByNationalId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDlrWithdrawalByNationalId",
			new String[] {String.class.getName()}, new String[] {"national_id"},
			false);

		_finderPathWithPaginationFindByDlrWithdrawalByLicenseNo =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByDlrWithdrawalByLicenseNo",
				new String[] {
					String.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"license_no"}, true);

		_finderPathWithoutPaginationFindByDlrWithdrawalByLicenseNo =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByDlrWithdrawalByLicenseNo",
				new String[] {String.class.getName()},
				new String[] {"license_no"}, true);

		_finderPathCountByDlrWithdrawalByLicenseNo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDlrWithdrawalByLicenseNo",
			new String[] {String.class.getName()}, new String[] {"license_no"},
			false);

		_finderPathFetchByDlrWithdrawalByNationalIdAndLicenseNo =
			new FinderPath(
				FINDER_CLASS_NAME_ENTITY,
				"fetchByDlrWithdrawalByNationalIdAndLicenseNo",
				new String[] {
					String.class.getName(), String.class.getName(),
					Long.class.getName()
				},
				new String[] {"national_id", "license_no", "dlr_reg_no"}, true);

		_finderPathCountByDlrWithdrawalByNationalIdAndLicenseNo =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByDlrWithdrawalByNationalIdAndLicenseNo",
				new String[] {
					String.class.getName(), String.class.getName(),
					Long.class.getName()
				},
				new String[] {"national_id", "license_no", "dlr_reg_no"},
				false);

		_setDgfDlrWithdrawalUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDgfDlrWithdrawalUtilPersistence(null);

		entityCache.removeCache(DgfDlrWithdrawalImpl.class.getName());
	}

	private void _setDgfDlrWithdrawalUtilPersistence(
		DgfDlrWithdrawalPersistence dgfDlrWithdrawalPersistence) {

		try {
			Field field = DgfDlrWithdrawalUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dgfDlrWithdrawalPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = DLRPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = DLRPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = DLRPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_DGFDLRWITHDRAWAL =
		"SELECT dgfDlrWithdrawal FROM DgfDlrWithdrawal dgfDlrWithdrawal";

	private static final String _SQL_SELECT_DGFDLRWITHDRAWAL_WHERE =
		"SELECT dgfDlrWithdrawal FROM DgfDlrWithdrawal dgfDlrWithdrawal WHERE ";

	private static final String _SQL_COUNT_DGFDLRWITHDRAWAL =
		"SELECT COUNT(dgfDlrWithdrawal) FROM DgfDlrWithdrawal dgfDlrWithdrawal";

	private static final String _SQL_COUNT_DGFDLRWITHDRAWAL_WHERE =
		"SELECT COUNT(dgfDlrWithdrawal) FROM DgfDlrWithdrawal dgfDlrWithdrawal WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dgfDlrWithdrawal.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DgfDlrWithdrawal exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DgfDlrWithdrawal exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DgfDlrWithdrawalPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"dlrWithdrawalId", "nationalId", "licenseNo", "dealerName",
			"mobileNo", "programType", "omsSubType", "createdDate",
			"modifiedBy", "modifiedDate", "userId", "groupId", "companyId",
			"dlrRegNo", "regApplNo", "statusByUserId", "statusByUserName",
			"statusDate"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}