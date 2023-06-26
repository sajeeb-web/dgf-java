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

import bd.gov.dgfood.dealer.registration.exception.NoSuchDgfDlrRegAddlDtlsException;
import bd.gov.dgfood.dealer.registration.model.DgfDlrRegAddlDtls;
import bd.gov.dgfood.dealer.registration.model.DgfDlrRegAddlDtlsTable;
import bd.gov.dgfood.dealer.registration.model.impl.DgfDlrRegAddlDtlsImpl;
import bd.gov.dgfood.dealer.registration.model.impl.DgfDlrRegAddlDtlsModelImpl;
import bd.gov.dgfood.dealer.registration.service.persistence.DgfDlrRegAddlDtlsPersistence;
import bd.gov.dgfood.dealer.registration.service.persistence.DgfDlrRegAddlDtlsUtil;
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
 * The persistence implementation for the dgf dlr reg addl dtls service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DgfDlrRegAddlDtlsPersistence.class)
public class DgfDlrRegAddlDtlsPersistenceImpl
	extends BasePersistenceImpl<DgfDlrRegAddlDtls>
	implements DgfDlrRegAddlDtlsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DgfDlrRegAddlDtlsUtil</code> to access the dgf dlr reg addl dtls persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DgfDlrRegAddlDtlsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByDgfDlrRegAddlDtlsByRegNo;
	private FinderPath _finderPathCountByDgfDlrRegAddlDtlsByRegNo;

	/**
	 * Returns the dgf dlr reg addl dtls where dlrRegNo = &#63; or throws a <code>NoSuchDgfDlrRegAddlDtlsException</code> if it could not be found.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the matching dgf dlr reg addl dtls
	 * @throws NoSuchDgfDlrRegAddlDtlsException if a matching dgf dlr reg addl dtls could not be found
	 */
	@Override
	public DgfDlrRegAddlDtls findByDgfDlrRegAddlDtlsByRegNo(long dlrRegNo)
		throws NoSuchDgfDlrRegAddlDtlsException {

		DgfDlrRegAddlDtls dgfDlrRegAddlDtls = fetchByDgfDlrRegAddlDtlsByRegNo(
			dlrRegNo);

		if (dgfDlrRegAddlDtls == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("dlrRegNo=");
			sb.append(dlrRegNo);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfDlrRegAddlDtlsException(sb.toString());
		}

		return dgfDlrRegAddlDtls;
	}

	/**
	 * Returns the dgf dlr reg addl dtls where dlrRegNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the matching dgf dlr reg addl dtls, or <code>null</code> if a matching dgf dlr reg addl dtls could not be found
	 */
	@Override
	public DgfDlrRegAddlDtls fetchByDgfDlrRegAddlDtlsByRegNo(long dlrRegNo) {
		return fetchByDgfDlrRegAddlDtlsByRegNo(dlrRegNo, true);
	}

	/**
	 * Returns the dgf dlr reg addl dtls where dlrRegNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf dlr reg addl dtls, or <code>null</code> if a matching dgf dlr reg addl dtls could not be found
	 */
	@Override
	public DgfDlrRegAddlDtls fetchByDgfDlrRegAddlDtlsByRegNo(
		long dlrRegNo, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {dlrRegNo};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDgfDlrRegAddlDtlsByRegNo, finderArgs, this);
		}

		if (result instanceof DgfDlrRegAddlDtls) {
			DgfDlrRegAddlDtls dgfDlrRegAddlDtls = (DgfDlrRegAddlDtls)result;

			if (dlrRegNo != dgfDlrRegAddlDtls.getDlrRegNo()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DGFDLRREGADDLDTLS_WHERE);

			sb.append(_FINDER_COLUMN_DGFDLRREGADDLDTLSBYREGNO_DLRREGNO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dlrRegNo);

				List<DgfDlrRegAddlDtls> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDgfDlrRegAddlDtlsByRegNo,
							finderArgs, list);
					}
				}
				else {
					DgfDlrRegAddlDtls dgfDlrRegAddlDtls = list.get(0);

					result = dgfDlrRegAddlDtls;

					cacheResult(dgfDlrRegAddlDtls);
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
			return (DgfDlrRegAddlDtls)result;
		}
	}

	/**
	 * Removes the dgf dlr reg addl dtls where dlrRegNo = &#63; from the database.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the dgf dlr reg addl dtls that was removed
	 */
	@Override
	public DgfDlrRegAddlDtls removeByDgfDlrRegAddlDtlsByRegNo(long dlrRegNo)
		throws NoSuchDgfDlrRegAddlDtlsException {

		DgfDlrRegAddlDtls dgfDlrRegAddlDtls = findByDgfDlrRegAddlDtlsByRegNo(
			dlrRegNo);

		return remove(dgfDlrRegAddlDtls);
	}

	/**
	 * Returns the number of dgf dlr reg addl dtlses where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the number of matching dgf dlr reg addl dtlses
	 */
	@Override
	public int countByDgfDlrRegAddlDtlsByRegNo(long dlrRegNo) {
		FinderPath finderPath = _finderPathCountByDgfDlrRegAddlDtlsByRegNo;

		Object[] finderArgs = new Object[] {dlrRegNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFDLRREGADDLDTLS_WHERE);

			sb.append(_FINDER_COLUMN_DGFDLRREGADDLDTLSBYREGNO_DLRREGNO_2);

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
		_FINDER_COLUMN_DGFDLRREGADDLDTLSBYREGNO_DLRREGNO_2 =
			"dgfDlrRegAddlDtls.dlrRegNo = ?";

	private FinderPath _finderPathWithPaginationFindByDgfDlrRegAddlDtlsByNid;
	private FinderPath _finderPathWithoutPaginationFindByDgfDlrRegAddlDtlsByNid;
	private FinderPath _finderPathCountByDgfDlrRegAddlDtlsByNid;

	/**
	 * Returns all the dgf dlr reg addl dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf dlr reg addl dtlses
	 */
	@Override
	public List<DgfDlrRegAddlDtls> findByDgfDlrRegAddlDtlsByNid(
		String nationalId) {

		return findByDgfDlrRegAddlDtlsByNid(
			nationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf dlr reg addl dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrRegAddlDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr reg addl dtlses
	 * @param end the upper bound of the range of dgf dlr reg addl dtlses (not inclusive)
	 * @return the range of matching dgf dlr reg addl dtlses
	 */
	@Override
	public List<DgfDlrRegAddlDtls> findByDgfDlrRegAddlDtlsByNid(
		String nationalId, int start, int end) {

		return findByDgfDlrRegAddlDtlsByNid(nationalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf dlr reg addl dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrRegAddlDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr reg addl dtlses
	 * @param end the upper bound of the range of dgf dlr reg addl dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf dlr reg addl dtlses
	 */
	@Override
	public List<DgfDlrRegAddlDtls> findByDgfDlrRegAddlDtlsByNid(
		String nationalId, int start, int end,
		OrderByComparator<DgfDlrRegAddlDtls> orderByComparator) {

		return findByDgfDlrRegAddlDtlsByNid(
			nationalId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf dlr reg addl dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrRegAddlDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr reg addl dtlses
	 * @param end the upper bound of the range of dgf dlr reg addl dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf dlr reg addl dtlses
	 */
	@Override
	public List<DgfDlrRegAddlDtls> findByDgfDlrRegAddlDtlsByNid(
		String nationalId, int start, int end,
		OrderByComparator<DgfDlrRegAddlDtls> orderByComparator,
		boolean useFinderCache) {

		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByDgfDlrRegAddlDtlsByNid;
				finderArgs = new Object[] {nationalId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDgfDlrRegAddlDtlsByNid;
			finderArgs = new Object[] {
				nationalId, start, end, orderByComparator
			};
		}

		List<DgfDlrRegAddlDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfDlrRegAddlDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfDlrRegAddlDtls dgfDlrRegAddlDtls : list) {
					if (!nationalId.equals(dgfDlrRegAddlDtls.getNationalId())) {
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

			sb.append(_SQL_SELECT_DGFDLRREGADDLDTLS_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_DGFDLRREGADDLDTLSBYNID_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(_FINDER_COLUMN_DGFDLRREGADDLDTLSBYNID_NATIONALID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfDlrRegAddlDtlsModelImpl.ORDER_BY_JPQL);
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

				list = (List<DgfDlrRegAddlDtls>)QueryUtil.list(
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
	 * Returns the first dgf dlr reg addl dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr reg addl dtls
	 * @throws NoSuchDgfDlrRegAddlDtlsException if a matching dgf dlr reg addl dtls could not be found
	 */
	@Override
	public DgfDlrRegAddlDtls findByDgfDlrRegAddlDtlsByNid_First(
			String nationalId,
			OrderByComparator<DgfDlrRegAddlDtls> orderByComparator)
		throws NoSuchDgfDlrRegAddlDtlsException {

		DgfDlrRegAddlDtls dgfDlrRegAddlDtls =
			fetchByDgfDlrRegAddlDtlsByNid_First(nationalId, orderByComparator);

		if (dgfDlrRegAddlDtls != null) {
			return dgfDlrRegAddlDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationalId=");
		sb.append(nationalId);

		sb.append("}");

		throw new NoSuchDgfDlrRegAddlDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf dlr reg addl dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr reg addl dtls, or <code>null</code> if a matching dgf dlr reg addl dtls could not be found
	 */
	@Override
	public DgfDlrRegAddlDtls fetchByDgfDlrRegAddlDtlsByNid_First(
		String nationalId,
		OrderByComparator<DgfDlrRegAddlDtls> orderByComparator) {

		List<DgfDlrRegAddlDtls> list = findByDgfDlrRegAddlDtlsByNid(
			nationalId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf dlr reg addl dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr reg addl dtls
	 * @throws NoSuchDgfDlrRegAddlDtlsException if a matching dgf dlr reg addl dtls could not be found
	 */
	@Override
	public DgfDlrRegAddlDtls findByDgfDlrRegAddlDtlsByNid_Last(
			String nationalId,
			OrderByComparator<DgfDlrRegAddlDtls> orderByComparator)
		throws NoSuchDgfDlrRegAddlDtlsException {

		DgfDlrRegAddlDtls dgfDlrRegAddlDtls =
			fetchByDgfDlrRegAddlDtlsByNid_Last(nationalId, orderByComparator);

		if (dgfDlrRegAddlDtls != null) {
			return dgfDlrRegAddlDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationalId=");
		sb.append(nationalId);

		sb.append("}");

		throw new NoSuchDgfDlrRegAddlDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf dlr reg addl dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr reg addl dtls, or <code>null</code> if a matching dgf dlr reg addl dtls could not be found
	 */
	@Override
	public DgfDlrRegAddlDtls fetchByDgfDlrRegAddlDtlsByNid_Last(
		String nationalId,
		OrderByComparator<DgfDlrRegAddlDtls> orderByComparator) {

		int count = countByDgfDlrRegAddlDtlsByNid(nationalId);

		if (count == 0) {
			return null;
		}

		List<DgfDlrRegAddlDtls> list = findByDgfDlrRegAddlDtlsByNid(
			nationalId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf dlr reg addl dtlses before and after the current dgf dlr reg addl dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param dlrRegAddlDtlsId the primary key of the current dgf dlr reg addl dtls
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf dlr reg addl dtls
	 * @throws NoSuchDgfDlrRegAddlDtlsException if a dgf dlr reg addl dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrRegAddlDtls[] findByDgfDlrRegAddlDtlsByNid_PrevAndNext(
			long dlrRegAddlDtlsId, String nationalId,
			OrderByComparator<DgfDlrRegAddlDtls> orderByComparator)
		throws NoSuchDgfDlrRegAddlDtlsException {

		nationalId = Objects.toString(nationalId, "");

		DgfDlrRegAddlDtls dgfDlrRegAddlDtls = findByPrimaryKey(
			dlrRegAddlDtlsId);

		Session session = null;

		try {
			session = openSession();

			DgfDlrRegAddlDtls[] array = new DgfDlrRegAddlDtlsImpl[3];

			array[0] = getByDgfDlrRegAddlDtlsByNid_PrevAndNext(
				session, dgfDlrRegAddlDtls, nationalId, orderByComparator,
				true);

			array[1] = dgfDlrRegAddlDtls;

			array[2] = getByDgfDlrRegAddlDtlsByNid_PrevAndNext(
				session, dgfDlrRegAddlDtls, nationalId, orderByComparator,
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

	protected DgfDlrRegAddlDtls getByDgfDlrRegAddlDtlsByNid_PrevAndNext(
		Session session, DgfDlrRegAddlDtls dgfDlrRegAddlDtls, String nationalId,
		OrderByComparator<DgfDlrRegAddlDtls> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFDLRREGADDLDTLS_WHERE);

		boolean bindNationalId = false;

		if (nationalId.isEmpty()) {
			sb.append(_FINDER_COLUMN_DGFDLRREGADDLDTLSBYNID_NATIONALID_3);
		}
		else {
			bindNationalId = true;

			sb.append(_FINDER_COLUMN_DGFDLRREGADDLDTLSBYNID_NATIONALID_2);
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
			sb.append(DgfDlrRegAddlDtlsModelImpl.ORDER_BY_JPQL);
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
						dgfDlrRegAddlDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfDlrRegAddlDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf dlr reg addl dtlses where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	@Override
	public void removeByDgfDlrRegAddlDtlsByNid(String nationalId) {
		for (DgfDlrRegAddlDtls dgfDlrRegAddlDtls :
				findByDgfDlrRegAddlDtlsByNid(
					nationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgfDlrRegAddlDtls);
		}
	}

	/**
	 * Returns the number of dgf dlr reg addl dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf dlr reg addl dtlses
	 */
	@Override
	public int countByDgfDlrRegAddlDtlsByNid(String nationalId) {
		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = _finderPathCountByDgfDlrRegAddlDtlsByNid;

		Object[] finderArgs = new Object[] {nationalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFDLRREGADDLDTLS_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_DGFDLRREGADDLDTLSBYNID_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(_FINDER_COLUMN_DGFDLRREGADDLDTLSBYNID_NATIONALID_2);
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
		_FINDER_COLUMN_DGFDLRREGADDLDTLSBYNID_NATIONALID_2 =
			"dgfDlrRegAddlDtls.nationalId = ?";

	private static final String
		_FINDER_COLUMN_DGFDLRREGADDLDTLSBYNID_NATIONALID_3 =
			"(dgfDlrRegAddlDtls.nationalId IS NULL OR dgfDlrRegAddlDtls.nationalId = '')";

	public DgfDlrRegAddlDtlsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("dlrRegAddlDtlsId", "dlr_reg_addl_dtls_id");
		dbColumnNames.put("nationalId", "national_id");
		dbColumnNames.put("dlrRegAppLNo", "dlr_reg_appl_no");
		dbColumnNames.put("dlrRegNo", "dlr_reg_no");
		dbColumnNames.put("pblcRep", "pblc_rep");
		dbColumnNames.put("wrkInGovt", "wrk_in_govt");
		dbColumnNames.put("physclyChlngd", "physcly_chlngd");
		dbColumnNames.put("phsclyChlnGdAttchId", "phscly_chln_gd_attch_id");
		dbColumnNames.put("licenseType", "license_type");
		dbColumnNames.put("thirdPartyOpsFlg", "third_party_ops_flg");
		dbColumnNames.put("fmlyDlrShpNo", "fmly_dlr_shp_no");
		dbColumnNames.put("dlrshpFmlyMmbrName", "dlrshp_fmly_mmbr_name");
		dbColumnNames.put("dlrshpFmlyMmbrType", "dlrshp_fmly_mmbr_type");
		dbColumnNames.put("dlrShpTrckTypFlg", "dlr_shp_trck_typ_flg");
		dbColumnNames.put("trckLicnsPlatNo", "trck_licns_plat_no");
		dbColumnNames.put("trckCpcty", "trck_cpcty");
		dbColumnNames.put("trckMake", "trck_make");
		dbColumnNames.put("trckModel", "trck_model");
		dbColumnNames.put("trckRentOwnFlg", "trck_rent_own_flg");
		dbColumnNames.put("trckMfgYr", "trck_mfg_yr");
		dbColumnNames.put("shpLength", "shp_length");
		dbColumnNames.put("shpHeight", "shp_height");
		dbColumnNames.put("shpWidth", "shp_width");
		dbColumnNames.put("shpStrgCpcty", "shp_strg_cpcty");
		dbColumnNames.put("shpFlrCmntd", "shp_flr_cmntd");
		dbColumnNames.put("shpSignBrd", "shp_sign_brd");
		dbColumnNames.put("dlrLicnsPosses", "dlr_licns_posses");
		dbColumnNames.put("dlrRunShpHimself", "dlr_run_shp_himself");
		dbColumnNames.put("dlrFmlyDlrShpFlg", "dlr_fmly_dlr_shp_flg");

		setDBColumnNames(dbColumnNames);

		setModelClass(DgfDlrRegAddlDtls.class);

		setModelImplClass(DgfDlrRegAddlDtlsImpl.class);
		setModelPKClass(long.class);

		setTable(DgfDlrRegAddlDtlsTable.INSTANCE);
	}

	/**
	 * Caches the dgf dlr reg addl dtls in the entity cache if it is enabled.
	 *
	 * @param dgfDlrRegAddlDtls the dgf dlr reg addl dtls
	 */
	@Override
	public void cacheResult(DgfDlrRegAddlDtls dgfDlrRegAddlDtls) {
		entityCache.putResult(
			DgfDlrRegAddlDtlsImpl.class, dgfDlrRegAddlDtls.getPrimaryKey(),
			dgfDlrRegAddlDtls);

		finderCache.putResult(
			_finderPathFetchByDgfDlrRegAddlDtlsByRegNo,
			new Object[] {dgfDlrRegAddlDtls.getDlrRegNo()}, dgfDlrRegAddlDtls);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dgf dlr reg addl dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfDlrRegAddlDtlses the dgf dlr reg addl dtlses
	 */
	@Override
	public void cacheResult(List<DgfDlrRegAddlDtls> dgfDlrRegAddlDtlses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgfDlrRegAddlDtlses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DgfDlrRegAddlDtls dgfDlrRegAddlDtls : dgfDlrRegAddlDtlses) {
			if (entityCache.getResult(
					DgfDlrRegAddlDtlsImpl.class,
					dgfDlrRegAddlDtls.getPrimaryKey()) == null) {

				cacheResult(dgfDlrRegAddlDtls);
			}
		}
	}

	/**
	 * Clears the cache for all dgf dlr reg addl dtlses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DgfDlrRegAddlDtlsImpl.class);

		finderCache.clearCache(DgfDlrRegAddlDtlsImpl.class);
	}

	/**
	 * Clears the cache for the dgf dlr reg addl dtls.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DgfDlrRegAddlDtls dgfDlrRegAddlDtls) {
		entityCache.removeResult(
			DgfDlrRegAddlDtlsImpl.class, dgfDlrRegAddlDtls);
	}

	@Override
	public void clearCache(List<DgfDlrRegAddlDtls> dgfDlrRegAddlDtlses) {
		for (DgfDlrRegAddlDtls dgfDlrRegAddlDtls : dgfDlrRegAddlDtlses) {
			entityCache.removeResult(
				DgfDlrRegAddlDtlsImpl.class, dgfDlrRegAddlDtls);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DgfDlrRegAddlDtlsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DgfDlrRegAddlDtlsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DgfDlrRegAddlDtlsModelImpl dgfDlrRegAddlDtlsModelImpl) {

		Object[] args = new Object[] {dgfDlrRegAddlDtlsModelImpl.getDlrRegNo()};

		finderCache.putResult(
			_finderPathCountByDgfDlrRegAddlDtlsByRegNo, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDgfDlrRegAddlDtlsByRegNo, args,
			dgfDlrRegAddlDtlsModelImpl);
	}

	/**
	 * Creates a new dgf dlr reg addl dtls with the primary key. Does not add the dgf dlr reg addl dtls to the database.
	 *
	 * @param dlrRegAddlDtlsId the primary key for the new dgf dlr reg addl dtls
	 * @return the new dgf dlr reg addl dtls
	 */
	@Override
	public DgfDlrRegAddlDtls create(long dlrRegAddlDtlsId) {
		DgfDlrRegAddlDtls dgfDlrRegAddlDtls = new DgfDlrRegAddlDtlsImpl();

		dgfDlrRegAddlDtls.setNew(true);
		dgfDlrRegAddlDtls.setPrimaryKey(dlrRegAddlDtlsId);

		return dgfDlrRegAddlDtls;
	}

	/**
	 * Removes the dgf dlr reg addl dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dlrRegAddlDtlsId the primary key of the dgf dlr reg addl dtls
	 * @return the dgf dlr reg addl dtls that was removed
	 * @throws NoSuchDgfDlrRegAddlDtlsException if a dgf dlr reg addl dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrRegAddlDtls remove(long dlrRegAddlDtlsId)
		throws NoSuchDgfDlrRegAddlDtlsException {

		return remove((Serializable)dlrRegAddlDtlsId);
	}

	/**
	 * Removes the dgf dlr reg addl dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dgf dlr reg addl dtls
	 * @return the dgf dlr reg addl dtls that was removed
	 * @throws NoSuchDgfDlrRegAddlDtlsException if a dgf dlr reg addl dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrRegAddlDtls remove(Serializable primaryKey)
		throws NoSuchDgfDlrRegAddlDtlsException {

		Session session = null;

		try {
			session = openSession();

			DgfDlrRegAddlDtls dgfDlrRegAddlDtls =
				(DgfDlrRegAddlDtls)session.get(
					DgfDlrRegAddlDtlsImpl.class, primaryKey);

			if (dgfDlrRegAddlDtls == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDgfDlrRegAddlDtlsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgfDlrRegAddlDtls);
		}
		catch (NoSuchDgfDlrRegAddlDtlsException noSuchEntityException) {
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
	protected DgfDlrRegAddlDtls removeImpl(
		DgfDlrRegAddlDtls dgfDlrRegAddlDtls) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgfDlrRegAddlDtls)) {
				dgfDlrRegAddlDtls = (DgfDlrRegAddlDtls)session.get(
					DgfDlrRegAddlDtlsImpl.class,
					dgfDlrRegAddlDtls.getPrimaryKeyObj());
			}

			if (dgfDlrRegAddlDtls != null) {
				session.delete(dgfDlrRegAddlDtls);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgfDlrRegAddlDtls != null) {
			clearCache(dgfDlrRegAddlDtls);
		}

		return dgfDlrRegAddlDtls;
	}

	@Override
	public DgfDlrRegAddlDtls updateImpl(DgfDlrRegAddlDtls dgfDlrRegAddlDtls) {
		boolean isNew = dgfDlrRegAddlDtls.isNew();

		if (!(dgfDlrRegAddlDtls instanceof DgfDlrRegAddlDtlsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dgfDlrRegAddlDtls.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dgfDlrRegAddlDtls);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgfDlrRegAddlDtls proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DgfDlrRegAddlDtls implementation " +
					dgfDlrRegAddlDtls.getClass());
		}

		DgfDlrRegAddlDtlsModelImpl dgfDlrRegAddlDtlsModelImpl =
			(DgfDlrRegAddlDtlsModelImpl)dgfDlrRegAddlDtls;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgfDlrRegAddlDtls);
			}
			else {
				dgfDlrRegAddlDtls = (DgfDlrRegAddlDtls)session.merge(
					dgfDlrRegAddlDtls);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DgfDlrRegAddlDtlsImpl.class, dgfDlrRegAddlDtlsModelImpl, false,
			true);

		cacheUniqueFindersCache(dgfDlrRegAddlDtlsModelImpl);

		if (isNew) {
			dgfDlrRegAddlDtls.setNew(false);
		}

		dgfDlrRegAddlDtls.resetOriginalValues();

		return dgfDlrRegAddlDtls;
	}

	/**
	 * Returns the dgf dlr reg addl dtls with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dgf dlr reg addl dtls
	 * @return the dgf dlr reg addl dtls
	 * @throws NoSuchDgfDlrRegAddlDtlsException if a dgf dlr reg addl dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrRegAddlDtls findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDgfDlrRegAddlDtlsException {

		DgfDlrRegAddlDtls dgfDlrRegAddlDtls = fetchByPrimaryKey(primaryKey);

		if (dgfDlrRegAddlDtls == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDgfDlrRegAddlDtlsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgfDlrRegAddlDtls;
	}

	/**
	 * Returns the dgf dlr reg addl dtls with the primary key or throws a <code>NoSuchDgfDlrRegAddlDtlsException</code> if it could not be found.
	 *
	 * @param dlrRegAddlDtlsId the primary key of the dgf dlr reg addl dtls
	 * @return the dgf dlr reg addl dtls
	 * @throws NoSuchDgfDlrRegAddlDtlsException if a dgf dlr reg addl dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrRegAddlDtls findByPrimaryKey(long dlrRegAddlDtlsId)
		throws NoSuchDgfDlrRegAddlDtlsException {

		return findByPrimaryKey((Serializable)dlrRegAddlDtlsId);
	}

	/**
	 * Returns the dgf dlr reg addl dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dlrRegAddlDtlsId the primary key of the dgf dlr reg addl dtls
	 * @return the dgf dlr reg addl dtls, or <code>null</code> if a dgf dlr reg addl dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrRegAddlDtls fetchByPrimaryKey(long dlrRegAddlDtlsId) {
		return fetchByPrimaryKey((Serializable)dlrRegAddlDtlsId);
	}

	/**
	 * Returns all the dgf dlr reg addl dtlses.
	 *
	 * @return the dgf dlr reg addl dtlses
	 */
	@Override
	public List<DgfDlrRegAddlDtls> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf dlr reg addl dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrRegAddlDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr reg addl dtlses
	 * @param end the upper bound of the range of dgf dlr reg addl dtlses (not inclusive)
	 * @return the range of dgf dlr reg addl dtlses
	 */
	@Override
	public List<DgfDlrRegAddlDtls> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf dlr reg addl dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrRegAddlDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr reg addl dtlses
	 * @param end the upper bound of the range of dgf dlr reg addl dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf dlr reg addl dtlses
	 */
	@Override
	public List<DgfDlrRegAddlDtls> findAll(
		int start, int end,
		OrderByComparator<DgfDlrRegAddlDtls> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf dlr reg addl dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrRegAddlDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr reg addl dtlses
	 * @param end the upper bound of the range of dgf dlr reg addl dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf dlr reg addl dtlses
	 */
	@Override
	public List<DgfDlrRegAddlDtls> findAll(
		int start, int end,
		OrderByComparator<DgfDlrRegAddlDtls> orderByComparator,
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

		List<DgfDlrRegAddlDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfDlrRegAddlDtls>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFDLRREGADDLDTLS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFDLRREGADDLDTLS;

				sql = sql.concat(DgfDlrRegAddlDtlsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DgfDlrRegAddlDtls>)QueryUtil.list(
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
	 * Removes all the dgf dlr reg addl dtlses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DgfDlrRegAddlDtls dgfDlrRegAddlDtls : findAll()) {
			remove(dgfDlrRegAddlDtls);
		}
	}

	/**
	 * Returns the number of dgf dlr reg addl dtlses.
	 *
	 * @return the number of dgf dlr reg addl dtlses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DGFDLRREGADDLDTLS);

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
		return "dlr_reg_addl_dtls_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DGFDLRREGADDLDTLS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DgfDlrRegAddlDtlsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dgf dlr reg addl dtls persistence.
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

		_finderPathFetchByDgfDlrRegAddlDtlsByRegNo = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDgfDlrRegAddlDtlsByRegNo",
			new String[] {Long.class.getName()}, new String[] {"dlr_reg_no"},
			true);

		_finderPathCountByDgfDlrRegAddlDtlsByRegNo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDgfDlrRegAddlDtlsByRegNo",
			new String[] {Long.class.getName()}, new String[] {"dlr_reg_no"},
			false);

		_finderPathWithPaginationFindByDgfDlrRegAddlDtlsByNid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDgfDlrRegAddlDtlsByNid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"national_id"}, true);

		_finderPathWithoutPaginationFindByDgfDlrRegAddlDtlsByNid =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByDgfDlrRegAddlDtlsByNid",
				new String[] {String.class.getName()},
				new String[] {"national_id"}, true);

		_finderPathCountByDgfDlrRegAddlDtlsByNid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDgfDlrRegAddlDtlsByNid",
			new String[] {String.class.getName()}, new String[] {"national_id"},
			false);

		_setDgfDlrRegAddlDtlsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDgfDlrRegAddlDtlsUtilPersistence(null);

		entityCache.removeCache(DgfDlrRegAddlDtlsImpl.class.getName());
	}

	private void _setDgfDlrRegAddlDtlsUtilPersistence(
		DgfDlrRegAddlDtlsPersistence dgfDlrRegAddlDtlsPersistence) {

		try {
			Field field = DgfDlrRegAddlDtlsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dgfDlrRegAddlDtlsPersistence);
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

	private static final String _SQL_SELECT_DGFDLRREGADDLDTLS =
		"SELECT dgfDlrRegAddlDtls FROM DgfDlrRegAddlDtls dgfDlrRegAddlDtls";

	private static final String _SQL_SELECT_DGFDLRREGADDLDTLS_WHERE =
		"SELECT dgfDlrRegAddlDtls FROM DgfDlrRegAddlDtls dgfDlrRegAddlDtls WHERE ";

	private static final String _SQL_COUNT_DGFDLRREGADDLDTLS =
		"SELECT COUNT(dgfDlrRegAddlDtls) FROM DgfDlrRegAddlDtls dgfDlrRegAddlDtls";

	private static final String _SQL_COUNT_DGFDLRREGADDLDTLS_WHERE =
		"SELECT COUNT(dgfDlrRegAddlDtls) FROM DgfDlrRegAddlDtls dgfDlrRegAddlDtls WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dgfDlrRegAddlDtls.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DgfDlrRegAddlDtls exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DgfDlrRegAddlDtls exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DgfDlrRegAddlDtlsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"dlrRegAddlDtlsId", "nationalId", "dlrRegAppLNo", "dlrRegNo",
			"pblcRep", "wrkInGovt", "physclyChlngd", "phsclyChlnGdAttchId",
			"licenseType", "thirdPartyOpsFlg", "fmlyDlrShpNo",
			"dlrshpFmlyMmbrName", "dlrshpFmlyMmbrType", "dlrShpTrckTypFlg",
			"trckLicnsPlatNo", "trckCpcty", "trckMake", "trckModel",
			"trckRentOwnFlg", "trckMfgYr", "shpLength", "shpHeight", "shpWidth",
			"shpStrgCpcty", "shpFlrCmntd", "shpSignBrd", "dlrLicnsPosses",
			"dlrRunShpHimself", "dlrFmlyDlrShpFlg"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}