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

import bd.gov.dgfood.dealer.registration.exception.NoSuchDgfDlrUpdtTempDtlsException;
import bd.gov.dgfood.dealer.registration.model.DgfDlrUpdtTempDtls;
import bd.gov.dgfood.dealer.registration.model.DgfDlrUpdtTempDtlsTable;
import bd.gov.dgfood.dealer.registration.model.impl.DgfDlrUpdtTempDtlsImpl;
import bd.gov.dgfood.dealer.registration.model.impl.DgfDlrUpdtTempDtlsModelImpl;
import bd.gov.dgfood.dealer.registration.service.persistence.DgfDlrUpdtTempDtlsPersistence;
import bd.gov.dgfood.dealer.registration.service.persistence.DgfDlrUpdtTempDtlsUtil;
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
 * The persistence implementation for the dgf dlr updt temp dtls service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DgfDlrUpdtTempDtlsPersistence.class)
public class DgfDlrUpdtTempDtlsPersistenceImpl
	extends BasePersistenceImpl<DgfDlrUpdtTempDtls>
	implements DgfDlrUpdtTempDtlsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DgfDlrUpdtTempDtlsUtil</code> to access the dgf dlr updt temp dtls persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DgfDlrUpdtTempDtlsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByDgfDlrUpdtTempDtlsByRegNo;
	private FinderPath
		_finderPathWithoutPaginationFindByDgfDlrUpdtTempDtlsByRegNo;
	private FinderPath _finderPathCountByDgfDlrUpdtTempDtlsByRegNo;

	/**
	 * Returns all the dgf dlr updt temp dtlses where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the matching dgf dlr updt temp dtlses
	 */
	@Override
	public List<DgfDlrUpdtTempDtls> findByDgfDlrUpdtTempDtlsByRegNo(
		long dlrRegNo) {

		return findByDgfDlrUpdtTempDtlsByRegNo(
			dlrRegNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf dlr updt temp dtlses where dlrRegNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrUpdtTempDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param start the lower bound of the range of dgf dlr updt temp dtlses
	 * @param end the upper bound of the range of dgf dlr updt temp dtlses (not inclusive)
	 * @return the range of matching dgf dlr updt temp dtlses
	 */
	@Override
	public List<DgfDlrUpdtTempDtls> findByDgfDlrUpdtTempDtlsByRegNo(
		long dlrRegNo, int start, int end) {

		return findByDgfDlrUpdtTempDtlsByRegNo(dlrRegNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf dlr updt temp dtlses where dlrRegNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrUpdtTempDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param start the lower bound of the range of dgf dlr updt temp dtlses
	 * @param end the upper bound of the range of dgf dlr updt temp dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf dlr updt temp dtlses
	 */
	@Override
	public List<DgfDlrUpdtTempDtls> findByDgfDlrUpdtTempDtlsByRegNo(
		long dlrRegNo, int start, int end,
		OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator) {

		return findByDgfDlrUpdtTempDtlsByRegNo(
			dlrRegNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf dlr updt temp dtlses where dlrRegNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrUpdtTempDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param start the lower bound of the range of dgf dlr updt temp dtlses
	 * @param end the upper bound of the range of dgf dlr updt temp dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf dlr updt temp dtlses
	 */
	@Override
	public List<DgfDlrUpdtTempDtls> findByDgfDlrUpdtTempDtlsByRegNo(
		long dlrRegNo, int start, int end,
		OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByDgfDlrUpdtTempDtlsByRegNo;
				finderArgs = new Object[] {dlrRegNo};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByDgfDlrUpdtTempDtlsByRegNo;
			finderArgs = new Object[] {dlrRegNo, start, end, orderByComparator};
		}

		List<DgfDlrUpdtTempDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfDlrUpdtTempDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls : list) {
					if (dlrRegNo != dgfDlrUpdtTempDtls.getDlrRegNo()) {
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

			sb.append(_SQL_SELECT_DGFDLRUPDTTEMPDTLS_WHERE);

			sb.append(_FINDER_COLUMN_DGFDLRUPDTTEMPDTLSBYREGNO_DLRREGNO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfDlrUpdtTempDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dlrRegNo);

				list = (List<DgfDlrUpdtTempDtls>)QueryUtil.list(
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
	 * Returns the first dgf dlr updt temp dtls in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr updt temp dtls
	 * @throws NoSuchDgfDlrUpdtTempDtlsException if a matching dgf dlr updt temp dtls could not be found
	 */
	@Override
	public DgfDlrUpdtTempDtls findByDgfDlrUpdtTempDtlsByRegNo_First(
			long dlrRegNo,
			OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator)
		throws NoSuchDgfDlrUpdtTempDtlsException {

		DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls =
			fetchByDgfDlrUpdtTempDtlsByRegNo_First(dlrRegNo, orderByComparator);

		if (dgfDlrUpdtTempDtls != null) {
			return dgfDlrUpdtTempDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dlrRegNo=");
		sb.append(dlrRegNo);

		sb.append("}");

		throw new NoSuchDgfDlrUpdtTempDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf dlr updt temp dtls in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr updt temp dtls, or <code>null</code> if a matching dgf dlr updt temp dtls could not be found
	 */
	@Override
	public DgfDlrUpdtTempDtls fetchByDgfDlrUpdtTempDtlsByRegNo_First(
		long dlrRegNo,
		OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator) {

		List<DgfDlrUpdtTempDtls> list = findByDgfDlrUpdtTempDtlsByRegNo(
			dlrRegNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf dlr updt temp dtls in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr updt temp dtls
	 * @throws NoSuchDgfDlrUpdtTempDtlsException if a matching dgf dlr updt temp dtls could not be found
	 */
	@Override
	public DgfDlrUpdtTempDtls findByDgfDlrUpdtTempDtlsByRegNo_Last(
			long dlrRegNo,
			OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator)
		throws NoSuchDgfDlrUpdtTempDtlsException {

		DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls =
			fetchByDgfDlrUpdtTempDtlsByRegNo_Last(dlrRegNo, orderByComparator);

		if (dgfDlrUpdtTempDtls != null) {
			return dgfDlrUpdtTempDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dlrRegNo=");
		sb.append(dlrRegNo);

		sb.append("}");

		throw new NoSuchDgfDlrUpdtTempDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf dlr updt temp dtls in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr updt temp dtls, or <code>null</code> if a matching dgf dlr updt temp dtls could not be found
	 */
	@Override
	public DgfDlrUpdtTempDtls fetchByDgfDlrUpdtTempDtlsByRegNo_Last(
		long dlrRegNo,
		OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator) {

		int count = countByDgfDlrUpdtTempDtlsByRegNo(dlrRegNo);

		if (count == 0) {
			return null;
		}

		List<DgfDlrUpdtTempDtls> list = findByDgfDlrUpdtTempDtlsByRegNo(
			dlrRegNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf dlr updt temp dtlses before and after the current dgf dlr updt temp dtls in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dgfDlrUpdateReqId the primary key of the current dgf dlr updt temp dtls
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf dlr updt temp dtls
	 * @throws NoSuchDgfDlrUpdtTempDtlsException if a dgf dlr updt temp dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrUpdtTempDtls[] findByDgfDlrUpdtTempDtlsByRegNo_PrevAndNext(
			long dgfDlrUpdateReqId, long dlrRegNo,
			OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator)
		throws NoSuchDgfDlrUpdtTempDtlsException {

		DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls = findByPrimaryKey(
			dgfDlrUpdateReqId);

		Session session = null;

		try {
			session = openSession();

			DgfDlrUpdtTempDtls[] array = new DgfDlrUpdtTempDtlsImpl[3];

			array[0] = getByDgfDlrUpdtTempDtlsByRegNo_PrevAndNext(
				session, dgfDlrUpdtTempDtls, dlrRegNo, orderByComparator, true);

			array[1] = dgfDlrUpdtTempDtls;

			array[2] = getByDgfDlrUpdtTempDtlsByRegNo_PrevAndNext(
				session, dgfDlrUpdtTempDtls, dlrRegNo, orderByComparator,
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

	protected DgfDlrUpdtTempDtls getByDgfDlrUpdtTempDtlsByRegNo_PrevAndNext(
		Session session, DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls, long dlrRegNo,
		OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFDLRUPDTTEMPDTLS_WHERE);

		sb.append(_FINDER_COLUMN_DGFDLRUPDTTEMPDTLSBYREGNO_DLRREGNO_2);

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
			sb.append(DgfDlrUpdtTempDtlsModelImpl.ORDER_BY_JPQL);
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
						dgfDlrUpdtTempDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfDlrUpdtTempDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf dlr updt temp dtlses where dlrRegNo = &#63; from the database.
	 *
	 * @param dlrRegNo the dlr reg no
	 */
	@Override
	public void removeByDgfDlrUpdtTempDtlsByRegNo(long dlrRegNo) {
		for (DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls :
				findByDgfDlrUpdtTempDtlsByRegNo(
					dlrRegNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgfDlrUpdtTempDtls);
		}
	}

	/**
	 * Returns the number of dgf dlr updt temp dtlses where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the number of matching dgf dlr updt temp dtlses
	 */
	@Override
	public int countByDgfDlrUpdtTempDtlsByRegNo(long dlrRegNo) {
		FinderPath finderPath = _finderPathCountByDgfDlrUpdtTempDtlsByRegNo;

		Object[] finderArgs = new Object[] {dlrRegNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFDLRUPDTTEMPDTLS_WHERE);

			sb.append(_FINDER_COLUMN_DGFDLRUPDTTEMPDTLSBYREGNO_DLRREGNO_2);

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

	private static final String
		_FINDER_COLUMN_DGFDLRUPDTTEMPDTLSBYREGNO_DLRREGNO_2 =
			"dgfDlrUpdtTempDtls.dlrRegNo = ?";

	private FinderPath _finderPathWithPaginationFindByDgfDlrUpdtTempDtlsByNid;
	private FinderPath
		_finderPathWithoutPaginationFindByDgfDlrUpdtTempDtlsByNid;
	private FinderPath _finderPathCountByDgfDlrUpdtTempDtlsByNid;

	/**
	 * Returns all the dgf dlr updt temp dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf dlr updt temp dtlses
	 */
	@Override
	public List<DgfDlrUpdtTempDtls> findByDgfDlrUpdtTempDtlsByNid(
		String nationalId) {

		return findByDgfDlrUpdtTempDtlsByNid(
			nationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf dlr updt temp dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrUpdtTempDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr updt temp dtlses
	 * @param end the upper bound of the range of dgf dlr updt temp dtlses (not inclusive)
	 * @return the range of matching dgf dlr updt temp dtlses
	 */
	@Override
	public List<DgfDlrUpdtTempDtls> findByDgfDlrUpdtTempDtlsByNid(
		String nationalId, int start, int end) {

		return findByDgfDlrUpdtTempDtlsByNid(nationalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf dlr updt temp dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrUpdtTempDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr updt temp dtlses
	 * @param end the upper bound of the range of dgf dlr updt temp dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf dlr updt temp dtlses
	 */
	@Override
	public List<DgfDlrUpdtTempDtls> findByDgfDlrUpdtTempDtlsByNid(
		String nationalId, int start, int end,
		OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator) {

		return findByDgfDlrUpdtTempDtlsByNid(
			nationalId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf dlr updt temp dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrUpdtTempDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr updt temp dtlses
	 * @param end the upper bound of the range of dgf dlr updt temp dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf dlr updt temp dtlses
	 */
	@Override
	public List<DgfDlrUpdtTempDtls> findByDgfDlrUpdtTempDtlsByNid(
		String nationalId, int start, int end,
		OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator,
		boolean useFinderCache) {

		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByDgfDlrUpdtTempDtlsByNid;
				finderArgs = new Object[] {nationalId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDgfDlrUpdtTempDtlsByNid;
			finderArgs = new Object[] {
				nationalId, start, end, orderByComparator
			};
		}

		List<DgfDlrUpdtTempDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfDlrUpdtTempDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls : list) {
					if (!nationalId.equals(
							dgfDlrUpdtTempDtls.getNationalId())) {

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

			sb.append(_SQL_SELECT_DGFDLRUPDTTEMPDTLS_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_DGFDLRUPDTTEMPDTLSBYNID_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(_FINDER_COLUMN_DGFDLRUPDTTEMPDTLSBYNID_NATIONALID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfDlrUpdtTempDtlsModelImpl.ORDER_BY_JPQL);
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

				list = (List<DgfDlrUpdtTempDtls>)QueryUtil.list(
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
	 * Returns the first dgf dlr updt temp dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr updt temp dtls
	 * @throws NoSuchDgfDlrUpdtTempDtlsException if a matching dgf dlr updt temp dtls could not be found
	 */
	@Override
	public DgfDlrUpdtTempDtls findByDgfDlrUpdtTempDtlsByNid_First(
			String nationalId,
			OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator)
		throws NoSuchDgfDlrUpdtTempDtlsException {

		DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls =
			fetchByDgfDlrUpdtTempDtlsByNid_First(nationalId, orderByComparator);

		if (dgfDlrUpdtTempDtls != null) {
			return dgfDlrUpdtTempDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationalId=");
		sb.append(nationalId);

		sb.append("}");

		throw new NoSuchDgfDlrUpdtTempDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf dlr updt temp dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr updt temp dtls, or <code>null</code> if a matching dgf dlr updt temp dtls could not be found
	 */
	@Override
	public DgfDlrUpdtTempDtls fetchByDgfDlrUpdtTempDtlsByNid_First(
		String nationalId,
		OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator) {

		List<DgfDlrUpdtTempDtls> list = findByDgfDlrUpdtTempDtlsByNid(
			nationalId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf dlr updt temp dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr updt temp dtls
	 * @throws NoSuchDgfDlrUpdtTempDtlsException if a matching dgf dlr updt temp dtls could not be found
	 */
	@Override
	public DgfDlrUpdtTempDtls findByDgfDlrUpdtTempDtlsByNid_Last(
			String nationalId,
			OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator)
		throws NoSuchDgfDlrUpdtTempDtlsException {

		DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls =
			fetchByDgfDlrUpdtTempDtlsByNid_Last(nationalId, orderByComparator);

		if (dgfDlrUpdtTempDtls != null) {
			return dgfDlrUpdtTempDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationalId=");
		sb.append(nationalId);

		sb.append("}");

		throw new NoSuchDgfDlrUpdtTempDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf dlr updt temp dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr updt temp dtls, or <code>null</code> if a matching dgf dlr updt temp dtls could not be found
	 */
	@Override
	public DgfDlrUpdtTempDtls fetchByDgfDlrUpdtTempDtlsByNid_Last(
		String nationalId,
		OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator) {

		int count = countByDgfDlrUpdtTempDtlsByNid(nationalId);

		if (count == 0) {
			return null;
		}

		List<DgfDlrUpdtTempDtls> list = findByDgfDlrUpdtTempDtlsByNid(
			nationalId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf dlr updt temp dtlses before and after the current dgf dlr updt temp dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param dgfDlrUpdateReqId the primary key of the current dgf dlr updt temp dtls
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf dlr updt temp dtls
	 * @throws NoSuchDgfDlrUpdtTempDtlsException if a dgf dlr updt temp dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrUpdtTempDtls[] findByDgfDlrUpdtTempDtlsByNid_PrevAndNext(
			long dgfDlrUpdateReqId, String nationalId,
			OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator)
		throws NoSuchDgfDlrUpdtTempDtlsException {

		nationalId = Objects.toString(nationalId, "");

		DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls = findByPrimaryKey(
			dgfDlrUpdateReqId);

		Session session = null;

		try {
			session = openSession();

			DgfDlrUpdtTempDtls[] array = new DgfDlrUpdtTempDtlsImpl[3];

			array[0] = getByDgfDlrUpdtTempDtlsByNid_PrevAndNext(
				session, dgfDlrUpdtTempDtls, nationalId, orderByComparator,
				true);

			array[1] = dgfDlrUpdtTempDtls;

			array[2] = getByDgfDlrUpdtTempDtlsByNid_PrevAndNext(
				session, dgfDlrUpdtTempDtls, nationalId, orderByComparator,
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

	protected DgfDlrUpdtTempDtls getByDgfDlrUpdtTempDtlsByNid_PrevAndNext(
		Session session, DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls,
		String nationalId,
		OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFDLRUPDTTEMPDTLS_WHERE);

		boolean bindNationalId = false;

		if (nationalId.isEmpty()) {
			sb.append(_FINDER_COLUMN_DGFDLRUPDTTEMPDTLSBYNID_NATIONALID_3);
		}
		else {
			bindNationalId = true;

			sb.append(_FINDER_COLUMN_DGFDLRUPDTTEMPDTLSBYNID_NATIONALID_2);
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
			sb.append(DgfDlrUpdtTempDtlsModelImpl.ORDER_BY_JPQL);
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
						dgfDlrUpdtTempDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfDlrUpdtTempDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf dlr updt temp dtlses where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	@Override
	public void removeByDgfDlrUpdtTempDtlsByNid(String nationalId) {
		for (DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls :
				findByDgfDlrUpdtTempDtlsByNid(
					nationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgfDlrUpdtTempDtls);
		}
	}

	/**
	 * Returns the number of dgf dlr updt temp dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf dlr updt temp dtlses
	 */
	@Override
	public int countByDgfDlrUpdtTempDtlsByNid(String nationalId) {
		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = _finderPathCountByDgfDlrUpdtTempDtlsByNid;

		Object[] finderArgs = new Object[] {nationalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFDLRUPDTTEMPDTLS_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_DGFDLRUPDTTEMPDTLSBYNID_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(_FINDER_COLUMN_DGFDLRUPDTTEMPDTLSBYNID_NATIONALID_2);
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
		_FINDER_COLUMN_DGFDLRUPDTTEMPDTLSBYNID_NATIONALID_2 =
			"dgfDlrUpdtTempDtls.nationalId = ?";

	private static final String
		_FINDER_COLUMN_DGFDLRUPDTTEMPDTLSBYNID_NATIONALID_3 =
			"(dgfDlrUpdtTempDtls.nationalId IS NULL OR dgfDlrUpdtTempDtls.nationalId = '')";

	public DgfDlrUpdtTempDtlsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("dgfDlrUpdateReqId", "dgf_dlr_update_req_id");
		dbColumnNames.put("nationalId", "national_id");
		dbColumnNames.put("dlrRegNo", "dlr_reg_no");
		dbColumnNames.put("maritalStatus", "marital_status");
		dbColumnNames.put("spouseName", "spouse_name");
		dbColumnNames.put("spouseFthrName", "spouse_fthr_name");
		dbColumnNames.put("spouseNid", "spouse_nid");
		dbColumnNames.put("spouseBrthDate", "spouse_brth_date");
		dbColumnNames.put("pblcRep", "pblc_rep");
		dbColumnNames.put("wrkInGovt", "wrk_in_govt");
		dbColumnNames.put("physclyChlngd", "physcly_chlngd");
		dbColumnNames.put("phsclyChlngdAttchId", "phscly_chlngd_attch_id");
		dbColumnNames.put("shpDivision", "shp_division");
		dbColumnNames.put("shpDistrict", "shp_district");
		dbColumnNames.put("shpUpzilla", "shp_upzilla");
		dbColumnNames.put("shpUnion", "shp_union");
		dbColumnNames.put("shpVillage", "shp_village");
		dbColumnNames.put("shpWard", "shp_ward");
		dbColumnNames.put("shpZipCode", "shp_zip_code");
		dbColumnNames.put("shpPstOffc", "shp_pst_offc");
		dbColumnNames.put("shpPresentAddress", "shp_present_address");
		dbColumnNames.put("shpLocation", "shp_location");
		dbColumnNames.put("shpLength", "shp_length");
		dbColumnNames.put("shpHeight", "shp_height");
		dbColumnNames.put("shpWidth", "shp_width");
		dbColumnNames.put("shpStrgCpcty", "shp_strg_cpcty");
		dbColumnNames.put("shpFlrCmntd", "shp_flr_cmntd");
		dbColumnNames.put("shpSignBrd", "shp_sign_brd");
		dbColumnNames.put("licenseType", "license_type");
		dbColumnNames.put("thrdPartyOpsFlg", "thrd_party_ops_flg");
		dbColumnNames.put("dlrshpFmlyMmbrName", "dlrshp_fmly_mmbr_name");
		dbColumnNames.put("dlrshpFmlyMmbrType", "dlrshp_fmly_mmbr_type");
		dbColumnNames.put("dlrPerfYr1", "dlr_perf_yr1");
		dbColumnNames.put("dlrPerfYr1AllocQty", "dlr_perf_yr1_alloc_qty");
		dbColumnNames.put("dlrPerfYr1ComdtyQty", "dlr_perf_yr1_comdty_qty");
		dbColumnNames.put("dlrPerfYr1DlrCtgry", "dlr_perf_yr1_dlr_ctgry");
		dbColumnNames.put("dlrPerfYr1Rmrk", "dlr_perf_yr1_rmrk");
		dbColumnNames.put("dlrPerfYr2", "dlr_perf_yr2");
		dbColumnNames.put("dlrPerfYr2AllocQty", "dlr_perf_yr2_alloc_qty");
		dbColumnNames.put("dlrPerfYr2ComdtyQty", "dlr_perf_yr2_comdty_qty");
		dbColumnNames.put("dlrPerfYr2DlrCtgry", "dlr_perf_yr2_dlr_ctgry");
		dbColumnNames.put("dlrPerfYr2Rmrk", "dlr_perf_yr2_rmrk");
		dbColumnNames.put("dlrPerfYr3", "dlr_perf_yr3");
		dbColumnNames.put("dlrPerfYr3AllocQty", "dlr_perf_yr3_alloc_qty");
		dbColumnNames.put("dlrPerfYr3ComdtyQty", "dlr_perf_yr3_comdty_qty");
		dbColumnNames.put("dlrPerfYr3DlrCtgry", "dlr_perf_yr3_dlr_ctgry");
		dbColumnNames.put("dlrPerfYr3Rmrk", "dlr_perf_yr3_rmrk");
		dbColumnNames.put("trckLicnsPlatNo", "trck_licns_plat_no");
		dbColumnNames.put("trckCpcty", "trck_cpcty");
		dbColumnNames.put("trckMake", "trck_make");
		dbColumnNames.put("trckModel", "trck_model");
		dbColumnNames.put("trckRentOwnFlg", "trck_rent_own_flg");
		dbColumnNames.put("trckMfgYr", "trck_mfg_yr");
		dbColumnNames.put("statusByUserId", "status_by_user_id");
		dbColumnNames.put("statusByUserName", "status_by_user_name");
		dbColumnNames.put("statusDate", "status_date");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("lastUpdtdBy", "last_updtd_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("foodgrainLicense", "foodgrain_license");
		dbColumnNames.put("tradeLicense", "trade_license");
		dbColumnNames.put("tcvDlrLicense", "tcv_dlr_license");
		dbColumnNames.put("importLicense", "import_license");
		dbColumnNames.put("licenseEssentialGoods", "license_essential_goods");
		dbColumnNames.put(
			"tradeLicenseAgriculture", "trade_license_agriculture");
		dbColumnNames.put("dlrOmsSubType", "dlr_oms_sub_type");
		dbColumnNames.put("userId", "user_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("dlrRunShpHimself", "dlr_run_shp_himself");
		dbColumnNames.put("dlrShpTrckTypFlg", "dlr_shp_trck_typ_flg");

		setDBColumnNames(dbColumnNames);

		setModelClass(DgfDlrUpdtTempDtls.class);

		setModelImplClass(DgfDlrUpdtTempDtlsImpl.class);
		setModelPKClass(long.class);

		setTable(DgfDlrUpdtTempDtlsTable.INSTANCE);
	}

	/**
	 * Caches the dgf dlr updt temp dtls in the entity cache if it is enabled.
	 *
	 * @param dgfDlrUpdtTempDtls the dgf dlr updt temp dtls
	 */
	@Override
	public void cacheResult(DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls) {
		entityCache.putResult(
			DgfDlrUpdtTempDtlsImpl.class, dgfDlrUpdtTempDtls.getPrimaryKey(),
			dgfDlrUpdtTempDtls);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dgf dlr updt temp dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfDlrUpdtTempDtlses the dgf dlr updt temp dtlses
	 */
	@Override
	public void cacheResult(List<DgfDlrUpdtTempDtls> dgfDlrUpdtTempDtlses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgfDlrUpdtTempDtlses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls : dgfDlrUpdtTempDtlses) {
			if (entityCache.getResult(
					DgfDlrUpdtTempDtlsImpl.class,
					dgfDlrUpdtTempDtls.getPrimaryKey()) == null) {

				cacheResult(dgfDlrUpdtTempDtls);
			}
		}
	}

	/**
	 * Clears the cache for all dgf dlr updt temp dtlses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DgfDlrUpdtTempDtlsImpl.class);

		finderCache.clearCache(DgfDlrUpdtTempDtlsImpl.class);
	}

	/**
	 * Clears the cache for the dgf dlr updt temp dtls.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls) {
		entityCache.removeResult(
			DgfDlrUpdtTempDtlsImpl.class, dgfDlrUpdtTempDtls);
	}

	@Override
	public void clearCache(List<DgfDlrUpdtTempDtls> dgfDlrUpdtTempDtlses) {
		for (DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls : dgfDlrUpdtTempDtlses) {
			entityCache.removeResult(
				DgfDlrUpdtTempDtlsImpl.class, dgfDlrUpdtTempDtls);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DgfDlrUpdtTempDtlsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DgfDlrUpdtTempDtlsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new dgf dlr updt temp dtls with the primary key. Does not add the dgf dlr updt temp dtls to the database.
	 *
	 * @param dgfDlrUpdateReqId the primary key for the new dgf dlr updt temp dtls
	 * @return the new dgf dlr updt temp dtls
	 */
	@Override
	public DgfDlrUpdtTempDtls create(long dgfDlrUpdateReqId) {
		DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls = new DgfDlrUpdtTempDtlsImpl();

		dgfDlrUpdtTempDtls.setNew(true);
		dgfDlrUpdtTempDtls.setPrimaryKey(dgfDlrUpdateReqId);

		dgfDlrUpdtTempDtls.setCompanyId(CompanyThreadLocal.getCompanyId());

		return dgfDlrUpdtTempDtls;
	}

	/**
	 * Removes the dgf dlr updt temp dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dgfDlrUpdateReqId the primary key of the dgf dlr updt temp dtls
	 * @return the dgf dlr updt temp dtls that was removed
	 * @throws NoSuchDgfDlrUpdtTempDtlsException if a dgf dlr updt temp dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrUpdtTempDtls remove(long dgfDlrUpdateReqId)
		throws NoSuchDgfDlrUpdtTempDtlsException {

		return remove((Serializable)dgfDlrUpdateReqId);
	}

	/**
	 * Removes the dgf dlr updt temp dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dgf dlr updt temp dtls
	 * @return the dgf dlr updt temp dtls that was removed
	 * @throws NoSuchDgfDlrUpdtTempDtlsException if a dgf dlr updt temp dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrUpdtTempDtls remove(Serializable primaryKey)
		throws NoSuchDgfDlrUpdtTempDtlsException {

		Session session = null;

		try {
			session = openSession();

			DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls =
				(DgfDlrUpdtTempDtls)session.get(
					DgfDlrUpdtTempDtlsImpl.class, primaryKey);

			if (dgfDlrUpdtTempDtls == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDgfDlrUpdtTempDtlsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgfDlrUpdtTempDtls);
		}
		catch (NoSuchDgfDlrUpdtTempDtlsException noSuchEntityException) {
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
	protected DgfDlrUpdtTempDtls removeImpl(
		DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgfDlrUpdtTempDtls)) {
				dgfDlrUpdtTempDtls = (DgfDlrUpdtTempDtls)session.get(
					DgfDlrUpdtTempDtlsImpl.class,
					dgfDlrUpdtTempDtls.getPrimaryKeyObj());
			}

			if (dgfDlrUpdtTempDtls != null) {
				session.delete(dgfDlrUpdtTempDtls);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgfDlrUpdtTempDtls != null) {
			clearCache(dgfDlrUpdtTempDtls);
		}

		return dgfDlrUpdtTempDtls;
	}

	@Override
	public DgfDlrUpdtTempDtls updateImpl(
		DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls) {

		boolean isNew = dgfDlrUpdtTempDtls.isNew();

		if (!(dgfDlrUpdtTempDtls instanceof DgfDlrUpdtTempDtlsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dgfDlrUpdtTempDtls.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dgfDlrUpdtTempDtls);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgfDlrUpdtTempDtls proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DgfDlrUpdtTempDtls implementation " +
					dgfDlrUpdtTempDtls.getClass());
		}

		DgfDlrUpdtTempDtlsModelImpl dgfDlrUpdtTempDtlsModelImpl =
			(DgfDlrUpdtTempDtlsModelImpl)dgfDlrUpdtTempDtls;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (dgfDlrUpdtTempDtls.getCreateDate() == null)) {
			if (serviceContext == null) {
				dgfDlrUpdtTempDtls.setCreateDate(date);
			}
			else {
				dgfDlrUpdtTempDtls.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!dgfDlrUpdtTempDtlsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				dgfDlrUpdtTempDtls.setModifiedDate(date);
			}
			else {
				dgfDlrUpdtTempDtls.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgfDlrUpdtTempDtls);
			}
			else {
				dgfDlrUpdtTempDtls = (DgfDlrUpdtTempDtls)session.merge(
					dgfDlrUpdtTempDtls);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DgfDlrUpdtTempDtlsImpl.class, dgfDlrUpdtTempDtlsModelImpl, false,
			true);

		if (isNew) {
			dgfDlrUpdtTempDtls.setNew(false);
		}

		dgfDlrUpdtTempDtls.resetOriginalValues();

		return dgfDlrUpdtTempDtls;
	}

	/**
	 * Returns the dgf dlr updt temp dtls with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dgf dlr updt temp dtls
	 * @return the dgf dlr updt temp dtls
	 * @throws NoSuchDgfDlrUpdtTempDtlsException if a dgf dlr updt temp dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrUpdtTempDtls findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDgfDlrUpdtTempDtlsException {

		DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls = fetchByPrimaryKey(primaryKey);

		if (dgfDlrUpdtTempDtls == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDgfDlrUpdtTempDtlsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgfDlrUpdtTempDtls;
	}

	/**
	 * Returns the dgf dlr updt temp dtls with the primary key or throws a <code>NoSuchDgfDlrUpdtTempDtlsException</code> if it could not be found.
	 *
	 * @param dgfDlrUpdateReqId the primary key of the dgf dlr updt temp dtls
	 * @return the dgf dlr updt temp dtls
	 * @throws NoSuchDgfDlrUpdtTempDtlsException if a dgf dlr updt temp dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrUpdtTempDtls findByPrimaryKey(long dgfDlrUpdateReqId)
		throws NoSuchDgfDlrUpdtTempDtlsException {

		return findByPrimaryKey((Serializable)dgfDlrUpdateReqId);
	}

	/**
	 * Returns the dgf dlr updt temp dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dgfDlrUpdateReqId the primary key of the dgf dlr updt temp dtls
	 * @return the dgf dlr updt temp dtls, or <code>null</code> if a dgf dlr updt temp dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrUpdtTempDtls fetchByPrimaryKey(long dgfDlrUpdateReqId) {
		return fetchByPrimaryKey((Serializable)dgfDlrUpdateReqId);
	}

	/**
	 * Returns all the dgf dlr updt temp dtlses.
	 *
	 * @return the dgf dlr updt temp dtlses
	 */
	@Override
	public List<DgfDlrUpdtTempDtls> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf dlr updt temp dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrUpdtTempDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr updt temp dtlses
	 * @param end the upper bound of the range of dgf dlr updt temp dtlses (not inclusive)
	 * @return the range of dgf dlr updt temp dtlses
	 */
	@Override
	public List<DgfDlrUpdtTempDtls> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf dlr updt temp dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrUpdtTempDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr updt temp dtlses
	 * @param end the upper bound of the range of dgf dlr updt temp dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf dlr updt temp dtlses
	 */
	@Override
	public List<DgfDlrUpdtTempDtls> findAll(
		int start, int end,
		OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf dlr updt temp dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrUpdtTempDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr updt temp dtlses
	 * @param end the upper bound of the range of dgf dlr updt temp dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf dlr updt temp dtlses
	 */
	@Override
	public List<DgfDlrUpdtTempDtls> findAll(
		int start, int end,
		OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator,
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

		List<DgfDlrUpdtTempDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfDlrUpdtTempDtls>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFDLRUPDTTEMPDTLS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFDLRUPDTTEMPDTLS;

				sql = sql.concat(DgfDlrUpdtTempDtlsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DgfDlrUpdtTempDtls>)QueryUtil.list(
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
	 * Removes all the dgf dlr updt temp dtlses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls : findAll()) {
			remove(dgfDlrUpdtTempDtls);
		}
	}

	/**
	 * Returns the number of dgf dlr updt temp dtlses.
	 *
	 * @return the number of dgf dlr updt temp dtlses
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
					_SQL_COUNT_DGFDLRUPDTTEMPDTLS);

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
		return "dgf_dlr_update_req_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DGFDLRUPDTTEMPDTLS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DgfDlrUpdtTempDtlsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dgf dlr updt temp dtls persistence.
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

		_finderPathWithPaginationFindByDgfDlrUpdtTempDtlsByRegNo =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByDgfDlrUpdtTempDtlsByRegNo",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"dlr_reg_no"}, true);

		_finderPathWithoutPaginationFindByDgfDlrUpdtTempDtlsByRegNo =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByDgfDlrUpdtTempDtlsByRegNo",
				new String[] {Long.class.getName()},
				new String[] {"dlr_reg_no"}, true);

		_finderPathCountByDgfDlrUpdtTempDtlsByRegNo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDgfDlrUpdtTempDtlsByRegNo",
			new String[] {Long.class.getName()}, new String[] {"dlr_reg_no"},
			false);

		_finderPathWithPaginationFindByDgfDlrUpdtTempDtlsByNid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDgfDlrUpdtTempDtlsByNid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"national_id"}, true);

		_finderPathWithoutPaginationFindByDgfDlrUpdtTempDtlsByNid =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByDgfDlrUpdtTempDtlsByNid",
				new String[] {String.class.getName()},
				new String[] {"national_id"}, true);

		_finderPathCountByDgfDlrUpdtTempDtlsByNid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDgfDlrUpdtTempDtlsByNid",
			new String[] {String.class.getName()}, new String[] {"national_id"},
			false);

		_setDgfDlrUpdtTempDtlsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDgfDlrUpdtTempDtlsUtilPersistence(null);

		entityCache.removeCache(DgfDlrUpdtTempDtlsImpl.class.getName());
	}

	private void _setDgfDlrUpdtTempDtlsUtilPersistence(
		DgfDlrUpdtTempDtlsPersistence dgfDlrUpdtTempDtlsPersistence) {

		try {
			Field field = DgfDlrUpdtTempDtlsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dgfDlrUpdtTempDtlsPersistence);
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

	private static final String _SQL_SELECT_DGFDLRUPDTTEMPDTLS =
		"SELECT dgfDlrUpdtTempDtls FROM DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls";

	private static final String _SQL_SELECT_DGFDLRUPDTTEMPDTLS_WHERE =
		"SELECT dgfDlrUpdtTempDtls FROM DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls WHERE ";

	private static final String _SQL_COUNT_DGFDLRUPDTTEMPDTLS =
		"SELECT COUNT(dgfDlrUpdtTempDtls) FROM DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls";

	private static final String _SQL_COUNT_DGFDLRUPDTTEMPDTLS_WHERE =
		"SELECT COUNT(dgfDlrUpdtTempDtls) FROM DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dgfDlrUpdtTempDtls.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DgfDlrUpdtTempDtls exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DgfDlrUpdtTempDtls exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DgfDlrUpdtTempDtlsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"dgfDlrUpdateReqId", "nationalId", "dlrRegNo", "maritalStatus",
			"spouseName", "spouseFthrName", "spouseNid", "spouseBrthDate",
			"pblcRep", "wrkInGovt", "physclyChlngd", "phsclyChlngdAttchId",
			"shpDivision", "shpDistrict", "shpUpzilla", "shpUnion",
			"shpVillage", "shpWard", "shpZipCode", "shpPstOffc",
			"shpPresentAddress", "shpLocation", "shpLength", "shpHeight",
			"shpWidth", "shpStrgCpcty", "shpFlrCmntd", "shpSignBrd",
			"licenseType", "thrdPartyOpsFlg", "dlrshpFmlyMmbrName",
			"dlrshpFmlyMmbrType", "dlrPerfYr1", "dlrPerfYr1AllocQty",
			"dlrPerfYr1ComdtyQty", "dlrPerfYr1DlrCtgry", "dlrPerfYr1Rmrk",
			"dlrPerfYr2", "dlrPerfYr2AllocQty", "dlrPerfYr2ComdtyQty",
			"dlrPerfYr2DlrCtgry", "dlrPerfYr2Rmrk", "dlrPerfYr3",
			"dlrPerfYr3AllocQty", "dlrPerfYr3ComdtyQty", "dlrPerfYr3DlrCtgry",
			"dlrPerfYr3Rmrk", "trckLicnsPlatNo", "trckCpcty", "trckMake",
			"trckModel", "trckRentOwnFlg", "trckMfgYr", "statusByUserId",
			"statusByUserName", "statusDate", "createDate", "lastUpdtdBy",
			"modifiedDate", "foodgrainLicense", "tradeLicense", "tcvDlrLicense",
			"importLicense", "licenseEssentialGoods", "tradeLicenseAgriculture",
			"dlrOmsSubType", "userId", "groupId", "companyId",
			"dlrRunShpHimself", "dlrShpTrckTypFlg"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}