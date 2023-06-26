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

import bd.gov.dgfood.dealer.registration.exception.NoSuchDgfDlrPerfDtlsException;
import bd.gov.dgfood.dealer.registration.model.DgfDlrPerfDtls;
import bd.gov.dgfood.dealer.registration.model.DgfDlrPerfDtlsTable;
import bd.gov.dgfood.dealer.registration.model.impl.DgfDlrPerfDtlsImpl;
import bd.gov.dgfood.dealer.registration.model.impl.DgfDlrPerfDtlsModelImpl;
import bd.gov.dgfood.dealer.registration.service.persistence.DgfDlrPerfDtlsPersistence;
import bd.gov.dgfood.dealer.registration.service.persistence.DgfDlrPerfDtlsUtil;
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
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the dgf dlr perf dtls service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DgfDlrPerfDtlsPersistence.class)
public class DgfDlrPerfDtlsPersistenceImpl
	extends BasePersistenceImpl<DgfDlrPerfDtls>
	implements DgfDlrPerfDtlsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DgfDlrPerfDtlsUtil</code> to access the dgf dlr perf dtls persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DgfDlrPerfDtlsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByDgfDlrPerfDtlsByRegNo;
	private FinderPath _finderPathCountByDgfDlrPerfDtlsByRegNo;

	/**
	 * Returns the dgf dlr perf dtls where dlrRegNo = &#63; or throws a <code>NoSuchDgfDlrPerfDtlsException</code> if it could not be found.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the matching dgf dlr perf dtls
	 * @throws NoSuchDgfDlrPerfDtlsException if a matching dgf dlr perf dtls could not be found
	 */
	@Override
	public DgfDlrPerfDtls findByDgfDlrPerfDtlsByRegNo(long dlrRegNo)
		throws NoSuchDgfDlrPerfDtlsException {

		DgfDlrPerfDtls dgfDlrPerfDtls = fetchByDgfDlrPerfDtlsByRegNo(dlrRegNo);

		if (dgfDlrPerfDtls == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("dlrRegNo=");
			sb.append(dlrRegNo);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfDlrPerfDtlsException(sb.toString());
		}

		return dgfDlrPerfDtls;
	}

	/**
	 * Returns the dgf dlr perf dtls where dlrRegNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the matching dgf dlr perf dtls, or <code>null</code> if a matching dgf dlr perf dtls could not be found
	 */
	@Override
	public DgfDlrPerfDtls fetchByDgfDlrPerfDtlsByRegNo(long dlrRegNo) {
		return fetchByDgfDlrPerfDtlsByRegNo(dlrRegNo, true);
	}

	/**
	 * Returns the dgf dlr perf dtls where dlrRegNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf dlr perf dtls, or <code>null</code> if a matching dgf dlr perf dtls could not be found
	 */
	@Override
	public DgfDlrPerfDtls fetchByDgfDlrPerfDtlsByRegNo(
		long dlrRegNo, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {dlrRegNo};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDgfDlrPerfDtlsByRegNo, finderArgs, this);
		}

		if (result instanceof DgfDlrPerfDtls) {
			DgfDlrPerfDtls dgfDlrPerfDtls = (DgfDlrPerfDtls)result;

			if (dlrRegNo != dgfDlrPerfDtls.getDlrRegNo()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DGFDLRPERFDTLS_WHERE);

			sb.append(_FINDER_COLUMN_DGFDLRPERFDTLSBYREGNO_DLRREGNO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dlrRegNo);

				List<DgfDlrPerfDtls> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDgfDlrPerfDtlsByRegNo, finderArgs,
							list);
					}
				}
				else {
					DgfDlrPerfDtls dgfDlrPerfDtls = list.get(0);

					result = dgfDlrPerfDtls;

					cacheResult(dgfDlrPerfDtls);
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
			return (DgfDlrPerfDtls)result;
		}
	}

	/**
	 * Removes the dgf dlr perf dtls where dlrRegNo = &#63; from the database.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the dgf dlr perf dtls that was removed
	 */
	@Override
	public DgfDlrPerfDtls removeByDgfDlrPerfDtlsByRegNo(long dlrRegNo)
		throws NoSuchDgfDlrPerfDtlsException {

		DgfDlrPerfDtls dgfDlrPerfDtls = findByDgfDlrPerfDtlsByRegNo(dlrRegNo);

		return remove(dgfDlrPerfDtls);
	}

	/**
	 * Returns the number of dgf dlr perf dtlses where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the number of matching dgf dlr perf dtlses
	 */
	@Override
	public int countByDgfDlrPerfDtlsByRegNo(long dlrRegNo) {
		FinderPath finderPath = _finderPathCountByDgfDlrPerfDtlsByRegNo;

		Object[] finderArgs = new Object[] {dlrRegNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFDLRPERFDTLS_WHERE);

			sb.append(_FINDER_COLUMN_DGFDLRPERFDTLSBYREGNO_DLRREGNO_2);

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
		_FINDER_COLUMN_DGFDLRPERFDTLSBYREGNO_DLRREGNO_2 =
			"dgfDlrPerfDtls.dlrRegNo = ?";

	private FinderPath _finderPathWithPaginationFindByDgfDlrPerfDtlsByNid;
	private FinderPath _finderPathWithoutPaginationFindByDgfDlrPerfDtlsByNid;
	private FinderPath _finderPathCountByDgfDlrPerfDtlsByNid;

	/**
	 * Returns all the dgf dlr perf dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf dlr perf dtlses
	 */
	@Override
	public List<DgfDlrPerfDtls> findByDgfDlrPerfDtlsByNid(String nationalId) {
		return findByDgfDlrPerfDtlsByNid(
			nationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf dlr perf dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrPerfDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr perf dtlses
	 * @param end the upper bound of the range of dgf dlr perf dtlses (not inclusive)
	 * @return the range of matching dgf dlr perf dtlses
	 */
	@Override
	public List<DgfDlrPerfDtls> findByDgfDlrPerfDtlsByNid(
		String nationalId, int start, int end) {

		return findByDgfDlrPerfDtlsByNid(nationalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf dlr perf dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrPerfDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr perf dtlses
	 * @param end the upper bound of the range of dgf dlr perf dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf dlr perf dtlses
	 */
	@Override
	public List<DgfDlrPerfDtls> findByDgfDlrPerfDtlsByNid(
		String nationalId, int start, int end,
		OrderByComparator<DgfDlrPerfDtls> orderByComparator) {

		return findByDgfDlrPerfDtlsByNid(
			nationalId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf dlr perf dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrPerfDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr perf dtlses
	 * @param end the upper bound of the range of dgf dlr perf dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf dlr perf dtlses
	 */
	@Override
	public List<DgfDlrPerfDtls> findByDgfDlrPerfDtlsByNid(
		String nationalId, int start, int end,
		OrderByComparator<DgfDlrPerfDtls> orderByComparator,
		boolean useFinderCache) {

		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByDgfDlrPerfDtlsByNid;
				finderArgs = new Object[] {nationalId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDgfDlrPerfDtlsByNid;
			finderArgs = new Object[] {
				nationalId, start, end, orderByComparator
			};
		}

		List<DgfDlrPerfDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfDlrPerfDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfDlrPerfDtls dgfDlrPerfDtls : list) {
					if (!nationalId.equals(dgfDlrPerfDtls.getNationalId())) {
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

			sb.append(_SQL_SELECT_DGFDLRPERFDTLS_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_DGFDLRPERFDTLSBYNID_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(_FINDER_COLUMN_DGFDLRPERFDTLSBYNID_NATIONALID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfDlrPerfDtlsModelImpl.ORDER_BY_JPQL);
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

				list = (List<DgfDlrPerfDtls>)QueryUtil.list(
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
	 * Returns the first dgf dlr perf dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr perf dtls
	 * @throws NoSuchDgfDlrPerfDtlsException if a matching dgf dlr perf dtls could not be found
	 */
	@Override
	public DgfDlrPerfDtls findByDgfDlrPerfDtlsByNid_First(
			String nationalId,
			OrderByComparator<DgfDlrPerfDtls> orderByComparator)
		throws NoSuchDgfDlrPerfDtlsException {

		DgfDlrPerfDtls dgfDlrPerfDtls = fetchByDgfDlrPerfDtlsByNid_First(
			nationalId, orderByComparator);

		if (dgfDlrPerfDtls != null) {
			return dgfDlrPerfDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationalId=");
		sb.append(nationalId);

		sb.append("}");

		throw new NoSuchDgfDlrPerfDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf dlr perf dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr perf dtls, or <code>null</code> if a matching dgf dlr perf dtls could not be found
	 */
	@Override
	public DgfDlrPerfDtls fetchByDgfDlrPerfDtlsByNid_First(
		String nationalId,
		OrderByComparator<DgfDlrPerfDtls> orderByComparator) {

		List<DgfDlrPerfDtls> list = findByDgfDlrPerfDtlsByNid(
			nationalId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf dlr perf dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr perf dtls
	 * @throws NoSuchDgfDlrPerfDtlsException if a matching dgf dlr perf dtls could not be found
	 */
	@Override
	public DgfDlrPerfDtls findByDgfDlrPerfDtlsByNid_Last(
			String nationalId,
			OrderByComparator<DgfDlrPerfDtls> orderByComparator)
		throws NoSuchDgfDlrPerfDtlsException {

		DgfDlrPerfDtls dgfDlrPerfDtls = fetchByDgfDlrPerfDtlsByNid_Last(
			nationalId, orderByComparator);

		if (dgfDlrPerfDtls != null) {
			return dgfDlrPerfDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationalId=");
		sb.append(nationalId);

		sb.append("}");

		throw new NoSuchDgfDlrPerfDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf dlr perf dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr perf dtls, or <code>null</code> if a matching dgf dlr perf dtls could not be found
	 */
	@Override
	public DgfDlrPerfDtls fetchByDgfDlrPerfDtlsByNid_Last(
		String nationalId,
		OrderByComparator<DgfDlrPerfDtls> orderByComparator) {

		int count = countByDgfDlrPerfDtlsByNid(nationalId);

		if (count == 0) {
			return null;
		}

		List<DgfDlrPerfDtls> list = findByDgfDlrPerfDtlsByNid(
			nationalId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf dlr perf dtlses before and after the current dgf dlr perf dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param dgfDlrPerfId the primary key of the current dgf dlr perf dtls
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf dlr perf dtls
	 * @throws NoSuchDgfDlrPerfDtlsException if a dgf dlr perf dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrPerfDtls[] findByDgfDlrPerfDtlsByNid_PrevAndNext(
			long dgfDlrPerfId, String nationalId,
			OrderByComparator<DgfDlrPerfDtls> orderByComparator)
		throws NoSuchDgfDlrPerfDtlsException {

		nationalId = Objects.toString(nationalId, "");

		DgfDlrPerfDtls dgfDlrPerfDtls = findByPrimaryKey(dgfDlrPerfId);

		Session session = null;

		try {
			session = openSession();

			DgfDlrPerfDtls[] array = new DgfDlrPerfDtlsImpl[3];

			array[0] = getByDgfDlrPerfDtlsByNid_PrevAndNext(
				session, dgfDlrPerfDtls, nationalId, orderByComparator, true);

			array[1] = dgfDlrPerfDtls;

			array[2] = getByDgfDlrPerfDtlsByNid_PrevAndNext(
				session, dgfDlrPerfDtls, nationalId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DgfDlrPerfDtls getByDgfDlrPerfDtlsByNid_PrevAndNext(
		Session session, DgfDlrPerfDtls dgfDlrPerfDtls, String nationalId,
		OrderByComparator<DgfDlrPerfDtls> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DGFDLRPERFDTLS_WHERE);

		boolean bindNationalId = false;

		if (nationalId.isEmpty()) {
			sb.append(_FINDER_COLUMN_DGFDLRPERFDTLSBYNID_NATIONALID_3);
		}
		else {
			bindNationalId = true;

			sb.append(_FINDER_COLUMN_DGFDLRPERFDTLSBYNID_NATIONALID_2);
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
			sb.append(DgfDlrPerfDtlsModelImpl.ORDER_BY_JPQL);
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
						dgfDlrPerfDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfDlrPerfDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf dlr perf dtlses where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	@Override
	public void removeByDgfDlrPerfDtlsByNid(String nationalId) {
		for (DgfDlrPerfDtls dgfDlrPerfDtls :
				findByDgfDlrPerfDtlsByNid(
					nationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgfDlrPerfDtls);
		}
	}

	/**
	 * Returns the number of dgf dlr perf dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf dlr perf dtlses
	 */
	@Override
	public int countByDgfDlrPerfDtlsByNid(String nationalId) {
		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = _finderPathCountByDgfDlrPerfDtlsByNid;

		Object[] finderArgs = new Object[] {nationalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFDLRPERFDTLS_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_DGFDLRPERFDTLSBYNID_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(_FINDER_COLUMN_DGFDLRPERFDTLSBYNID_NATIONALID_2);
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
		_FINDER_COLUMN_DGFDLRPERFDTLSBYNID_NATIONALID_2 =
			"dgfDlrPerfDtls.nationalId = ?";

	private static final String
		_FINDER_COLUMN_DGFDLRPERFDTLSBYNID_NATIONALID_3 =
			"(dgfDlrPerfDtls.nationalId IS NULL OR dgfDlrPerfDtls.nationalId = '')";

	public DgfDlrPerfDtlsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("dgfDlrPerfId", "dgf_dlr_perf_id");
		dbColumnNames.put("nationalId", "national_id");
		dbColumnNames.put("dlrRegApplNo", "dlr_reg_appl_no");
		dbColumnNames.put("dlrRegNo", "dlr_reg_no");
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

		setDBColumnNames(dbColumnNames);

		setModelClass(DgfDlrPerfDtls.class);

		setModelImplClass(DgfDlrPerfDtlsImpl.class);
		setModelPKClass(long.class);

		setTable(DgfDlrPerfDtlsTable.INSTANCE);
	}

	/**
	 * Caches the dgf dlr perf dtls in the entity cache if it is enabled.
	 *
	 * @param dgfDlrPerfDtls the dgf dlr perf dtls
	 */
	@Override
	public void cacheResult(DgfDlrPerfDtls dgfDlrPerfDtls) {
		entityCache.putResult(
			DgfDlrPerfDtlsImpl.class, dgfDlrPerfDtls.getPrimaryKey(),
			dgfDlrPerfDtls);

		finderCache.putResult(
			_finderPathFetchByDgfDlrPerfDtlsByRegNo,
			new Object[] {dgfDlrPerfDtls.getDlrRegNo()}, dgfDlrPerfDtls);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dgf dlr perf dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfDlrPerfDtlses the dgf dlr perf dtlses
	 */
	@Override
	public void cacheResult(List<DgfDlrPerfDtls> dgfDlrPerfDtlses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgfDlrPerfDtlses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DgfDlrPerfDtls dgfDlrPerfDtls : dgfDlrPerfDtlses) {
			if (entityCache.getResult(
					DgfDlrPerfDtlsImpl.class, dgfDlrPerfDtls.getPrimaryKey()) ==
						null) {

				cacheResult(dgfDlrPerfDtls);
			}
		}
	}

	/**
	 * Clears the cache for all dgf dlr perf dtlses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DgfDlrPerfDtlsImpl.class);

		finderCache.clearCache(DgfDlrPerfDtlsImpl.class);
	}

	/**
	 * Clears the cache for the dgf dlr perf dtls.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DgfDlrPerfDtls dgfDlrPerfDtls) {
		entityCache.removeResult(DgfDlrPerfDtlsImpl.class, dgfDlrPerfDtls);
	}

	@Override
	public void clearCache(List<DgfDlrPerfDtls> dgfDlrPerfDtlses) {
		for (DgfDlrPerfDtls dgfDlrPerfDtls : dgfDlrPerfDtlses) {
			entityCache.removeResult(DgfDlrPerfDtlsImpl.class, dgfDlrPerfDtls);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DgfDlrPerfDtlsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DgfDlrPerfDtlsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DgfDlrPerfDtlsModelImpl dgfDlrPerfDtlsModelImpl) {

		Object[] args = new Object[] {dgfDlrPerfDtlsModelImpl.getDlrRegNo()};

		finderCache.putResult(
			_finderPathCountByDgfDlrPerfDtlsByRegNo, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDgfDlrPerfDtlsByRegNo, args,
			dgfDlrPerfDtlsModelImpl);
	}

	/**
	 * Creates a new dgf dlr perf dtls with the primary key. Does not add the dgf dlr perf dtls to the database.
	 *
	 * @param dgfDlrPerfId the primary key for the new dgf dlr perf dtls
	 * @return the new dgf dlr perf dtls
	 */
	@Override
	public DgfDlrPerfDtls create(long dgfDlrPerfId) {
		DgfDlrPerfDtls dgfDlrPerfDtls = new DgfDlrPerfDtlsImpl();

		dgfDlrPerfDtls.setNew(true);
		dgfDlrPerfDtls.setPrimaryKey(dgfDlrPerfId);

		return dgfDlrPerfDtls;
	}

	/**
	 * Removes the dgf dlr perf dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dgfDlrPerfId the primary key of the dgf dlr perf dtls
	 * @return the dgf dlr perf dtls that was removed
	 * @throws NoSuchDgfDlrPerfDtlsException if a dgf dlr perf dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrPerfDtls remove(long dgfDlrPerfId)
		throws NoSuchDgfDlrPerfDtlsException {

		return remove((Serializable)dgfDlrPerfId);
	}

	/**
	 * Removes the dgf dlr perf dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dgf dlr perf dtls
	 * @return the dgf dlr perf dtls that was removed
	 * @throws NoSuchDgfDlrPerfDtlsException if a dgf dlr perf dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrPerfDtls remove(Serializable primaryKey)
		throws NoSuchDgfDlrPerfDtlsException {

		Session session = null;

		try {
			session = openSession();

			DgfDlrPerfDtls dgfDlrPerfDtls = (DgfDlrPerfDtls)session.get(
				DgfDlrPerfDtlsImpl.class, primaryKey);

			if (dgfDlrPerfDtls == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDgfDlrPerfDtlsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgfDlrPerfDtls);
		}
		catch (NoSuchDgfDlrPerfDtlsException noSuchEntityException) {
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
	protected DgfDlrPerfDtls removeImpl(DgfDlrPerfDtls dgfDlrPerfDtls) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgfDlrPerfDtls)) {
				dgfDlrPerfDtls = (DgfDlrPerfDtls)session.get(
					DgfDlrPerfDtlsImpl.class,
					dgfDlrPerfDtls.getPrimaryKeyObj());
			}

			if (dgfDlrPerfDtls != null) {
				session.delete(dgfDlrPerfDtls);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgfDlrPerfDtls != null) {
			clearCache(dgfDlrPerfDtls);
		}

		return dgfDlrPerfDtls;
	}

	@Override
	public DgfDlrPerfDtls updateImpl(DgfDlrPerfDtls dgfDlrPerfDtls) {
		boolean isNew = dgfDlrPerfDtls.isNew();

		if (!(dgfDlrPerfDtls instanceof DgfDlrPerfDtlsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dgfDlrPerfDtls.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dgfDlrPerfDtls);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgfDlrPerfDtls proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DgfDlrPerfDtls implementation " +
					dgfDlrPerfDtls.getClass());
		}

		DgfDlrPerfDtlsModelImpl dgfDlrPerfDtlsModelImpl =
			(DgfDlrPerfDtlsModelImpl)dgfDlrPerfDtls;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgfDlrPerfDtls);
			}
			else {
				dgfDlrPerfDtls = (DgfDlrPerfDtls)session.merge(dgfDlrPerfDtls);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DgfDlrPerfDtlsImpl.class, dgfDlrPerfDtlsModelImpl, false, true);

		cacheUniqueFindersCache(dgfDlrPerfDtlsModelImpl);

		if (isNew) {
			dgfDlrPerfDtls.setNew(false);
		}

		dgfDlrPerfDtls.resetOriginalValues();

		return dgfDlrPerfDtls;
	}

	/**
	 * Returns the dgf dlr perf dtls with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dgf dlr perf dtls
	 * @return the dgf dlr perf dtls
	 * @throws NoSuchDgfDlrPerfDtlsException if a dgf dlr perf dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrPerfDtls findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDgfDlrPerfDtlsException {

		DgfDlrPerfDtls dgfDlrPerfDtls = fetchByPrimaryKey(primaryKey);

		if (dgfDlrPerfDtls == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDgfDlrPerfDtlsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgfDlrPerfDtls;
	}

	/**
	 * Returns the dgf dlr perf dtls with the primary key or throws a <code>NoSuchDgfDlrPerfDtlsException</code> if it could not be found.
	 *
	 * @param dgfDlrPerfId the primary key of the dgf dlr perf dtls
	 * @return the dgf dlr perf dtls
	 * @throws NoSuchDgfDlrPerfDtlsException if a dgf dlr perf dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrPerfDtls findByPrimaryKey(long dgfDlrPerfId)
		throws NoSuchDgfDlrPerfDtlsException {

		return findByPrimaryKey((Serializable)dgfDlrPerfId);
	}

	/**
	 * Returns the dgf dlr perf dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dgfDlrPerfId the primary key of the dgf dlr perf dtls
	 * @return the dgf dlr perf dtls, or <code>null</code> if a dgf dlr perf dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrPerfDtls fetchByPrimaryKey(long dgfDlrPerfId) {
		return fetchByPrimaryKey((Serializable)dgfDlrPerfId);
	}

	/**
	 * Returns all the dgf dlr perf dtlses.
	 *
	 * @return the dgf dlr perf dtlses
	 */
	@Override
	public List<DgfDlrPerfDtls> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf dlr perf dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrPerfDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr perf dtlses
	 * @param end the upper bound of the range of dgf dlr perf dtlses (not inclusive)
	 * @return the range of dgf dlr perf dtlses
	 */
	@Override
	public List<DgfDlrPerfDtls> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf dlr perf dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrPerfDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr perf dtlses
	 * @param end the upper bound of the range of dgf dlr perf dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf dlr perf dtlses
	 */
	@Override
	public List<DgfDlrPerfDtls> findAll(
		int start, int end,
		OrderByComparator<DgfDlrPerfDtls> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf dlr perf dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrPerfDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr perf dtlses
	 * @param end the upper bound of the range of dgf dlr perf dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf dlr perf dtlses
	 */
	@Override
	public List<DgfDlrPerfDtls> findAll(
		int start, int end, OrderByComparator<DgfDlrPerfDtls> orderByComparator,
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

		List<DgfDlrPerfDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfDlrPerfDtls>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFDLRPERFDTLS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFDLRPERFDTLS;

				sql = sql.concat(DgfDlrPerfDtlsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DgfDlrPerfDtls>)QueryUtil.list(
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
	 * Removes all the dgf dlr perf dtlses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DgfDlrPerfDtls dgfDlrPerfDtls : findAll()) {
			remove(dgfDlrPerfDtls);
		}
	}

	/**
	 * Returns the number of dgf dlr perf dtlses.
	 *
	 * @return the number of dgf dlr perf dtlses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DGFDLRPERFDTLS);

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
		return "dgf_dlr_perf_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DGFDLRPERFDTLS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DgfDlrPerfDtlsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dgf dlr perf dtls persistence.
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

		_finderPathFetchByDgfDlrPerfDtlsByRegNo = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDgfDlrPerfDtlsByRegNo",
			new String[] {Long.class.getName()}, new String[] {"dlr_reg_no"},
			true);

		_finderPathCountByDgfDlrPerfDtlsByRegNo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDgfDlrPerfDtlsByRegNo", new String[] {Long.class.getName()},
			new String[] {"dlr_reg_no"}, false);

		_finderPathWithPaginationFindByDgfDlrPerfDtlsByNid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDgfDlrPerfDtlsByNid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"national_id"}, true);

		_finderPathWithoutPaginationFindByDgfDlrPerfDtlsByNid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDgfDlrPerfDtlsByNid", new String[] {String.class.getName()},
			new String[] {"national_id"}, true);

		_finderPathCountByDgfDlrPerfDtlsByNid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDgfDlrPerfDtlsByNid", new String[] {String.class.getName()},
			new String[] {"national_id"}, false);

		_setDgfDlrPerfDtlsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDgfDlrPerfDtlsUtilPersistence(null);

		entityCache.removeCache(DgfDlrPerfDtlsImpl.class.getName());
	}

	private void _setDgfDlrPerfDtlsUtilPersistence(
		DgfDlrPerfDtlsPersistence dgfDlrPerfDtlsPersistence) {

		try {
			Field field = DgfDlrPerfDtlsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dgfDlrPerfDtlsPersistence);
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

	private static final String _SQL_SELECT_DGFDLRPERFDTLS =
		"SELECT dgfDlrPerfDtls FROM DgfDlrPerfDtls dgfDlrPerfDtls";

	private static final String _SQL_SELECT_DGFDLRPERFDTLS_WHERE =
		"SELECT dgfDlrPerfDtls FROM DgfDlrPerfDtls dgfDlrPerfDtls WHERE ";

	private static final String _SQL_COUNT_DGFDLRPERFDTLS =
		"SELECT COUNT(dgfDlrPerfDtls) FROM DgfDlrPerfDtls dgfDlrPerfDtls";

	private static final String _SQL_COUNT_DGFDLRPERFDTLS_WHERE =
		"SELECT COUNT(dgfDlrPerfDtls) FROM DgfDlrPerfDtls dgfDlrPerfDtls WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dgfDlrPerfDtls.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DgfDlrPerfDtls exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DgfDlrPerfDtls exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DgfDlrPerfDtlsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"dgfDlrPerfId", "nationalId", "dlrRegApplNo", "dlrRegNo",
			"dlrPerfYr1", "dlrPerfYr1AllocQty", "dlrPerfYr1ComdtyQty",
			"dlrPerfYr1DlrCtgry", "dlrPerfYr1Rmrk", "dlrPerfYr2",
			"dlrPerfYr2AllocQty", "dlrPerfYr2ComdtyQty", "dlrPerfYr2DlrCtgry",
			"dlrPerfYr2Rmrk", "dlrPerfYr3", "dlrPerfYr3AllocQty",
			"dlrPerfYr3ComdtyQty", "dlrPerfYr3DlrCtgry", "dlrPerfYr3Rmrk"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}