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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfFglPreDtlsException;
import bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls;
import bd.gov.dgfood.food.grain.license.model.DgfFglPreDtlsTable;
import bd.gov.dgfood.food.grain.license.model.impl.DgfFglPreDtlsImpl;
import bd.gov.dgfood.food.grain.license.model.impl.DgfFglPreDtlsModelImpl;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfFglPreDtlsPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfFglPreDtlsUtil;
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
 * The persistence implementation for the dgf fgl pre dtls service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DgfFglPreDtlsPersistence.class)
public class DgfFglPreDtlsPersistenceImpl
	extends BasePersistenceImpl<DgfFglPreDtls>
	implements DgfFglPreDtlsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DgfFglPreDtlsUtil</code> to access the dgf fgl pre dtls persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DgfFglPreDtlsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBydgfFglPreDtlsByFglApplicationNo;
	private FinderPath _finderPathCountBydgfFglPreDtlsByFglApplicationNo;

	/**
	 * Returns the dgf fgl pre dtls where fglApplicationNo = &#63; or throws a <code>NoSuchDgfFglPreDtlsException</code> if it could not be found.
	 *
	 * @param fglApplicationNo the fgl application no
	 * @return the matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByFglApplicationNo(
			String fglApplicationNo)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls = fetchBydgfFglPreDtlsByFglApplicationNo(
			fglApplicationNo);

		if (dgfFglPreDtls == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("fglApplicationNo=");
			sb.append(fglApplicationNo);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfFglPreDtlsException(sb.toString());
		}

		return dgfFglPreDtls;
	}

	/**
	 * Returns the dgf fgl pre dtls where fglApplicationNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fglApplicationNo the fgl application no
	 * @return the matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByFglApplicationNo(
		String fglApplicationNo) {

		return fetchBydgfFglPreDtlsByFglApplicationNo(fglApplicationNo, true);
	}

	/**
	 * Returns the dgf fgl pre dtls where fglApplicationNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fglApplicationNo the fgl application no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByFglApplicationNo(
		String fglApplicationNo, boolean useFinderCache) {

		fglApplicationNo = Objects.toString(fglApplicationNo, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {fglApplicationNo};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBydgfFglPreDtlsByFglApplicationNo, finderArgs,
				this);
		}

		if (result instanceof DgfFglPreDtls) {
			DgfFglPreDtls dgfFglPreDtls = (DgfFglPreDtls)result;

			if (!Objects.equals(
					fglApplicationNo, dgfFglPreDtls.getFglApplicationNo())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

			boolean bindFglApplicationNo = false;

			if (fglApplicationNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DGFFGLPREDTLSBYFGLAPPLICATIONNO_FGLAPPLICATIONNO_3);
			}
			else {
				bindFglApplicationNo = true;

				sb.append(
					_FINDER_COLUMN_DGFFGLPREDTLSBYFGLAPPLICATIONNO_FGLAPPLICATIONNO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFglApplicationNo) {
					queryPos.add(fglApplicationNo);
				}

				List<DgfFglPreDtls> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBydgfFglPreDtlsByFglApplicationNo,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {fglApplicationNo};
							}

							_log.warn(
								"DgfFglPreDtlsPersistenceImpl.fetchBydgfFglPreDtlsByFglApplicationNo(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DgfFglPreDtls dgfFglPreDtls = list.get(0);

					result = dgfFglPreDtls;

					cacheResult(dgfFglPreDtls);
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
			return (DgfFglPreDtls)result;
		}
	}

	/**
	 * Removes the dgf fgl pre dtls where fglApplicationNo = &#63; from the database.
	 *
	 * @param fglApplicationNo the fgl application no
	 * @return the dgf fgl pre dtls that was removed
	 */
	@Override
	public DgfFglPreDtls removeBydgfFglPreDtlsByFglApplicationNo(
			String fglApplicationNo)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls = findBydgfFglPreDtlsByFglApplicationNo(
			fglApplicationNo);

		return remove(dgfFglPreDtls);
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where fglApplicationNo = &#63;.
	 *
	 * @param fglApplicationNo the fgl application no
	 * @return the number of matching dgf fgl pre dtlses
	 */
	@Override
	public int countBydgfFglPreDtlsByFglApplicationNo(String fglApplicationNo) {
		fglApplicationNo = Objects.toString(fglApplicationNo, "");

		FinderPath finderPath =
			_finderPathCountBydgfFglPreDtlsByFglApplicationNo;

		Object[] finderArgs = new Object[] {fglApplicationNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFFGLPREDTLS_WHERE);

			boolean bindFglApplicationNo = false;

			if (fglApplicationNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DGFFGLPREDTLSBYFGLAPPLICATIONNO_FGLAPPLICATIONNO_3);
			}
			else {
				bindFglApplicationNo = true;

				sb.append(
					_FINDER_COLUMN_DGFFGLPREDTLSBYFGLAPPLICATIONNO_FGLAPPLICATIONNO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFglApplicationNo) {
					queryPos.add(fglApplicationNo);
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
		_FINDER_COLUMN_DGFFGLPREDTLSBYFGLAPPLICATIONNO_FGLAPPLICATIONNO_2 =
			"dgfFglPreDtls.fglApplicationNo = ?";

	private static final String
		_FINDER_COLUMN_DGFFGLPREDTLSBYFGLAPPLICATIONNO_FGLAPPLICATIONNO_3 =
			"(dgfFglPreDtls.fglApplicationNo IS NULL OR dgfFglPreDtls.fglApplicationNo = '')";

	private FinderPath _finderPathWithPaginationFindBydgfFglPreDtlsByNationalId;
	private FinderPath
		_finderPathWithoutPaginationFindBydgfFglPreDtlsByNationalId;
	private FinderPath _finderPathCountBydgfFglPreDtlsByNationalId;

	/**
	 * Returns all the dgf fgl pre dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByNationalId(
		long nationalId) {

		return findBydgfFglPreDtlsByNationalId(
			nationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByNationalId(
		long nationalId, int start, int end) {

		return findBydgfFglPreDtlsByNationalId(nationalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByNationalId(
		long nationalId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return findBydgfFglPreDtlsByNationalId(
			nationalId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByNationalId(
		long nationalId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydgfFglPreDtlsByNationalId;
				finderArgs = new Object[] {nationalId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBydgfFglPreDtlsByNationalId;
			finderArgs = new Object[] {
				nationalId, start, end, orderByComparator
			};
		}

		List<DgfFglPreDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfFglPreDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfFglPreDtls dgfFglPreDtls : list) {
					if (nationalId != dgfFglPreDtls.getNationalId()) {
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

			sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

			sb.append(_FINDER_COLUMN_DGFFGLPREDTLSBYNATIONALID_NATIONALID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(nationalId);

				list = (List<DgfFglPreDtls>)QueryUtil.list(
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
	 * Returns the first dgf fgl pre dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByNationalId_First(
			long nationalId, OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls = fetchBydgfFglPreDtlsByNationalId_First(
			nationalId, orderByComparator);

		if (dgfFglPreDtls != null) {
			return dgfFglPreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationalId=");
		sb.append(nationalId);

		sb.append("}");

		throw new NoSuchDgfFglPreDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByNationalId_First(
		long nationalId, OrderByComparator<DgfFglPreDtls> orderByComparator) {

		List<DgfFglPreDtls> list = findBydgfFglPreDtlsByNationalId(
			nationalId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByNationalId_Last(
			long nationalId, OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls = fetchBydgfFglPreDtlsByNationalId_Last(
			nationalId, orderByComparator);

		if (dgfFglPreDtls != null) {
			return dgfFglPreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationalId=");
		sb.append(nationalId);

		sb.append("}");

		throw new NoSuchDgfFglPreDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByNationalId_Last(
		long nationalId, OrderByComparator<DgfFglPreDtls> orderByComparator) {

		int count = countBydgfFglPreDtlsByNationalId(nationalId);

		if (count == 0) {
			return null;
		}

		List<DgfFglPreDtls> list = findBydgfFglPreDtlsByNationalId(
			nationalId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	@Override
	public DgfFglPreDtls[] findBydgfFglPreDtlsByNationalId_PrevAndNext(
			long fglPrePrimaryId, long nationalId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls = findByPrimaryKey(fglPrePrimaryId);

		Session session = null;

		try {
			session = openSession();

			DgfFglPreDtls[] array = new DgfFglPreDtlsImpl[3];

			array[0] = getBydgfFglPreDtlsByNationalId_PrevAndNext(
				session, dgfFglPreDtls, nationalId, orderByComparator, true);

			array[1] = dgfFglPreDtls;

			array[2] = getBydgfFglPreDtlsByNationalId_PrevAndNext(
				session, dgfFglPreDtls, nationalId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DgfFglPreDtls getBydgfFglPreDtlsByNationalId_PrevAndNext(
		Session session, DgfFglPreDtls dgfFglPreDtls, long nationalId,
		OrderByComparator<DgfFglPreDtls> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

		sb.append(_FINDER_COLUMN_DGFFGLPREDTLSBYNATIONALID_NATIONALID_2);

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
			sb.append(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(nationalId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfFglPreDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfFglPreDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf fgl pre dtlses where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	@Override
	public void removeBydgfFglPreDtlsByNationalId(long nationalId) {
		for (DgfFglPreDtls dgfFglPreDtls :
				findBydgfFglPreDtlsByNationalId(
					nationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgfFglPreDtls);
		}
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	@Override
	public int countBydgfFglPreDtlsByNationalId(long nationalId) {
		FinderPath finderPath = _finderPathCountBydgfFglPreDtlsByNationalId;

		Object[] finderArgs = new Object[] {nationalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFFGLPREDTLS_WHERE);

			sb.append(_FINDER_COLUMN_DGFFGLPREDTLSBYNATIONALID_NATIONALID_2);

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

	private static final String
		_FINDER_COLUMN_DGFFGLPREDTLSBYNATIONALID_NATIONALID_2 =
			"dgfFglPreDtls.nationalId = ?";

	private FinderPath _finderPathFetchByDgfFglPreDtlsByNID;
	private FinderPath _finderPathCountByDgfFglPreDtlsByNID;

	/**
	 * Returns the dgf fgl pre dtls where nationalId = &#63; or throws a <code>NoSuchDgfFglPreDtlsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findByDgfFglPreDtlsByNID(long nationalId)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls = fetchByDgfFglPreDtlsByNID(nationalId);

		if (dgfFglPreDtls == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("nationalId=");
			sb.append(nationalId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfFglPreDtlsException(sb.toString());
		}

		return dgfFglPreDtls;
	}

	/**
	 * Returns the dgf fgl pre dtls where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchByDgfFglPreDtlsByNID(long nationalId) {
		return fetchByDgfFglPreDtlsByNID(nationalId, true);
	}

	/**
	 * Returns the dgf fgl pre dtls where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchByDgfFglPreDtlsByNID(
		long nationalId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {nationalId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDgfFglPreDtlsByNID, finderArgs, this);
		}

		if (result instanceof DgfFglPreDtls) {
			DgfFglPreDtls dgfFglPreDtls = (DgfFglPreDtls)result;

			if (nationalId != dgfFglPreDtls.getNationalId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

			sb.append(_FINDER_COLUMN_DGFFGLPREDTLSBYNID_NATIONALID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(nationalId);

				List<DgfFglPreDtls> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDgfFglPreDtlsByNID, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {nationalId};
							}

							_log.warn(
								"DgfFglPreDtlsPersistenceImpl.fetchByDgfFglPreDtlsByNID(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DgfFglPreDtls dgfFglPreDtls = list.get(0);

					result = dgfFglPreDtls;

					cacheResult(dgfFglPreDtls);
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
			return (DgfFglPreDtls)result;
		}
	}

	/**
	 * Removes the dgf fgl pre dtls where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the dgf fgl pre dtls that was removed
	 */
	@Override
	public DgfFglPreDtls removeByDgfFglPreDtlsByNID(long nationalId)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls = findByDgfFglPreDtlsByNID(nationalId);

		return remove(dgfFglPreDtls);
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	@Override
	public int countByDgfFglPreDtlsByNID(long nationalId) {
		FinderPath finderPath = _finderPathCountByDgfFglPreDtlsByNID;

		Object[] finderArgs = new Object[] {nationalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFFGLPREDTLS_WHERE);

			sb.append(_FINDER_COLUMN_DGFFGLPREDTLSBYNID_NATIONALID_2);

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

	private static final String _FINDER_COLUMN_DGFFGLPREDTLSBYNID_NATIONALID_2 =
		"dgfFglPreDtls.nationalId = ?";

	private FinderPath
		_finderPathWithPaginationFindBydgfFglPreDtlsByPresentAddrId;
	private FinderPath
		_finderPathWithoutPaginationFindBydgfFglPreDtlsByPresentAddrId;
	private FinderPath _finderPathCountBydgfFglPreDtlsByPresentAddrId;

	/**
	 * Returns all the dgf fgl pre dtlses where presentAddrId = &#63;.
	 *
	 * @param presentAddrId the present addr ID
	 * @return the matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByPresentAddrId(
		long presentAddrId) {

		return findBydgfFglPreDtlsByPresentAddrId(
			presentAddrId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses where presentAddrId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param presentAddrId the present addr ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByPresentAddrId(
		long presentAddrId, int start, int end) {

		return findBydgfFglPreDtlsByPresentAddrId(
			presentAddrId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where presentAddrId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param presentAddrId the present addr ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByPresentAddrId(
		long presentAddrId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return findBydgfFglPreDtlsByPresentAddrId(
			presentAddrId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where presentAddrId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param presentAddrId the present addr ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByPresentAddrId(
		long presentAddrId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydgfFglPreDtlsByPresentAddrId;
				finderArgs = new Object[] {presentAddrId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBydgfFglPreDtlsByPresentAddrId;
			finderArgs = new Object[] {
				presentAddrId, start, end, orderByComparator
			};
		}

		List<DgfFglPreDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfFglPreDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfFglPreDtls dgfFglPreDtls : list) {
					if (presentAddrId != dgfFglPreDtls.getPresentAddrId()) {
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

			sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLPREDTLSBYPRESENTADDRID_PRESENTADDRID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(presentAddrId);

				list = (List<DgfFglPreDtls>)QueryUtil.list(
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
	 * Returns the first dgf fgl pre dtls in the ordered set where presentAddrId = &#63;.
	 *
	 * @param presentAddrId the present addr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByPresentAddrId_First(
			long presentAddrId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls = fetchBydgfFglPreDtlsByPresentAddrId_First(
			presentAddrId, orderByComparator);

		if (dgfFglPreDtls != null) {
			return dgfFglPreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("presentAddrId=");
		sb.append(presentAddrId);

		sb.append("}");

		throw new NoSuchDgfFglPreDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where presentAddrId = &#63;.
	 *
	 * @param presentAddrId the present addr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByPresentAddrId_First(
		long presentAddrId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		List<DgfFglPreDtls> list = findBydgfFglPreDtlsByPresentAddrId(
			presentAddrId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where presentAddrId = &#63;.
	 *
	 * @param presentAddrId the present addr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByPresentAddrId_Last(
			long presentAddrId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls = fetchBydgfFglPreDtlsByPresentAddrId_Last(
			presentAddrId, orderByComparator);

		if (dgfFglPreDtls != null) {
			return dgfFglPreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("presentAddrId=");
		sb.append(presentAddrId);

		sb.append("}");

		throw new NoSuchDgfFglPreDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where presentAddrId = &#63;.
	 *
	 * @param presentAddrId the present addr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByPresentAddrId_Last(
		long presentAddrId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		int count = countBydgfFglPreDtlsByPresentAddrId(presentAddrId);

		if (count == 0) {
			return null;
		}

		List<DgfFglPreDtls> list = findBydgfFglPreDtlsByPresentAddrId(
			presentAddrId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where presentAddrId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param presentAddrId the present addr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	@Override
	public DgfFglPreDtls[] findBydgfFglPreDtlsByPresentAddrId_PrevAndNext(
			long fglPrePrimaryId, long presentAddrId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls = findByPrimaryKey(fglPrePrimaryId);

		Session session = null;

		try {
			session = openSession();

			DgfFglPreDtls[] array = new DgfFglPreDtlsImpl[3];

			array[0] = getBydgfFglPreDtlsByPresentAddrId_PrevAndNext(
				session, dgfFglPreDtls, presentAddrId, orderByComparator, true);

			array[1] = dgfFglPreDtls;

			array[2] = getBydgfFglPreDtlsByPresentAddrId_PrevAndNext(
				session, dgfFglPreDtls, presentAddrId, orderByComparator,
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

	protected DgfFglPreDtls getBydgfFglPreDtlsByPresentAddrId_PrevAndNext(
		Session session, DgfFglPreDtls dgfFglPreDtls, long presentAddrId,
		OrderByComparator<DgfFglPreDtls> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

		sb.append(_FINDER_COLUMN_DGFFGLPREDTLSBYPRESENTADDRID_PRESENTADDRID_2);

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
			sb.append(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(presentAddrId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfFglPreDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfFglPreDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf fgl pre dtlses where presentAddrId = &#63; from the database.
	 *
	 * @param presentAddrId the present addr ID
	 */
	@Override
	public void removeBydgfFglPreDtlsByPresentAddrId(long presentAddrId) {
		for (DgfFglPreDtls dgfFglPreDtls :
				findBydgfFglPreDtlsByPresentAddrId(
					presentAddrId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgfFglPreDtls);
		}
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where presentAddrId = &#63;.
	 *
	 * @param presentAddrId the present addr ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	@Override
	public int countBydgfFglPreDtlsByPresentAddrId(long presentAddrId) {
		FinderPath finderPath = _finderPathCountBydgfFglPreDtlsByPresentAddrId;

		Object[] finderArgs = new Object[] {presentAddrId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFFGLPREDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLPREDTLSBYPRESENTADDRID_PRESENTADDRID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(presentAddrId);

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
		_FINDER_COLUMN_DGFFGLPREDTLSBYPRESENTADDRID_PRESENTADDRID_2 =
			"dgfFglPreDtls.presentAddrId = ?";

	private FinderPath
		_finderPathWithPaginationFindBydgfFglPreDtlsByBussinessAddrId;
	private FinderPath
		_finderPathWithoutPaginationFindBydgfFglPreDtlsByBussinessAddrId;
	private FinderPath _finderPathCountBydgfFglPreDtlsByBussinessAddrId;

	/**
	 * Returns all the dgf fgl pre dtlses where bussinessAddrId = &#63;.
	 *
	 * @param bussinessAddrId the bussiness addr ID
	 * @return the matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByBussinessAddrId(
		long bussinessAddrId) {

		return findBydgfFglPreDtlsByBussinessAddrId(
			bussinessAddrId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses where bussinessAddrId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bussinessAddrId the bussiness addr ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByBussinessAddrId(
		long bussinessAddrId, int start, int end) {

		return findBydgfFglPreDtlsByBussinessAddrId(
			bussinessAddrId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where bussinessAddrId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bussinessAddrId the bussiness addr ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByBussinessAddrId(
		long bussinessAddrId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return findBydgfFglPreDtlsByBussinessAddrId(
			bussinessAddrId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where bussinessAddrId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bussinessAddrId the bussiness addr ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByBussinessAddrId(
		long bussinessAddrId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydgfFglPreDtlsByBussinessAddrId;
				finderArgs = new Object[] {bussinessAddrId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBydgfFglPreDtlsByBussinessAddrId;
			finderArgs = new Object[] {
				bussinessAddrId, start, end, orderByComparator
			};
		}

		List<DgfFglPreDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfFglPreDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfFglPreDtls dgfFglPreDtls : list) {
					if (bussinessAddrId != dgfFglPreDtls.getBussinessAddrId()) {
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

			sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLPREDTLSBYBUSSINESSADDRID_BUSSINESSADDRID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(bussinessAddrId);

				list = (List<DgfFglPreDtls>)QueryUtil.list(
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
	 * Returns the first dgf fgl pre dtls in the ordered set where bussinessAddrId = &#63;.
	 *
	 * @param bussinessAddrId the bussiness addr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByBussinessAddrId_First(
			long bussinessAddrId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls =
			fetchBydgfFglPreDtlsByBussinessAddrId_First(
				bussinessAddrId, orderByComparator);

		if (dgfFglPreDtls != null) {
			return dgfFglPreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bussinessAddrId=");
		sb.append(bussinessAddrId);

		sb.append("}");

		throw new NoSuchDgfFglPreDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where bussinessAddrId = &#63;.
	 *
	 * @param bussinessAddrId the bussiness addr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByBussinessAddrId_First(
		long bussinessAddrId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		List<DgfFglPreDtls> list = findBydgfFglPreDtlsByBussinessAddrId(
			bussinessAddrId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where bussinessAddrId = &#63;.
	 *
	 * @param bussinessAddrId the bussiness addr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByBussinessAddrId_Last(
			long bussinessAddrId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls =
			fetchBydgfFglPreDtlsByBussinessAddrId_Last(
				bussinessAddrId, orderByComparator);

		if (dgfFglPreDtls != null) {
			return dgfFglPreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bussinessAddrId=");
		sb.append(bussinessAddrId);

		sb.append("}");

		throw new NoSuchDgfFglPreDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where bussinessAddrId = &#63;.
	 *
	 * @param bussinessAddrId the bussiness addr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByBussinessAddrId_Last(
		long bussinessAddrId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		int count = countBydgfFglPreDtlsByBussinessAddrId(bussinessAddrId);

		if (count == 0) {
			return null;
		}

		List<DgfFglPreDtls> list = findBydgfFglPreDtlsByBussinessAddrId(
			bussinessAddrId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where bussinessAddrId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param bussinessAddrId the bussiness addr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	@Override
	public DgfFglPreDtls[] findBydgfFglPreDtlsByBussinessAddrId_PrevAndNext(
			long fglPrePrimaryId, long bussinessAddrId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls = findByPrimaryKey(fglPrePrimaryId);

		Session session = null;

		try {
			session = openSession();

			DgfFglPreDtls[] array = new DgfFglPreDtlsImpl[3];

			array[0] = getBydgfFglPreDtlsByBussinessAddrId_PrevAndNext(
				session, dgfFglPreDtls, bussinessAddrId, orderByComparator,
				true);

			array[1] = dgfFglPreDtls;

			array[2] = getBydgfFglPreDtlsByBussinessAddrId_PrevAndNext(
				session, dgfFglPreDtls, bussinessAddrId, orderByComparator,
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

	protected DgfFglPreDtls getBydgfFglPreDtlsByBussinessAddrId_PrevAndNext(
		Session session, DgfFglPreDtls dgfFglPreDtls, long bussinessAddrId,
		OrderByComparator<DgfFglPreDtls> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

		sb.append(
			_FINDER_COLUMN_DGFFGLPREDTLSBYBUSSINESSADDRID_BUSSINESSADDRID_2);

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
			sb.append(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(bussinessAddrId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfFglPreDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfFglPreDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf fgl pre dtlses where bussinessAddrId = &#63; from the database.
	 *
	 * @param bussinessAddrId the bussiness addr ID
	 */
	@Override
	public void removeBydgfFglPreDtlsByBussinessAddrId(long bussinessAddrId) {
		for (DgfFglPreDtls dgfFglPreDtls :
				findBydgfFglPreDtlsByBussinessAddrId(
					bussinessAddrId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgfFglPreDtls);
		}
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where bussinessAddrId = &#63;.
	 *
	 * @param bussinessAddrId the bussiness addr ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	@Override
	public int countBydgfFglPreDtlsByBussinessAddrId(long bussinessAddrId) {
		FinderPath finderPath =
			_finderPathCountBydgfFglPreDtlsByBussinessAddrId;

		Object[] finderArgs = new Object[] {bussinessAddrId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFFGLPREDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLPREDTLSBYBUSSINESSADDRID_BUSSINESSADDRID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(bussinessAddrId);

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
		_FINDER_COLUMN_DGFFGLPREDTLSBYBUSSINESSADDRID_BUSSINESSADDRID_2 =
			"dgfFglPreDtls.bussinessAddrId = ?";

	private FinderPath
		_finderPathWithPaginationFindBydgfFglPreDtlsByTradeLicenseDocId;
	private FinderPath
		_finderPathWithoutPaginationFindBydgfFglPreDtlsByTradeLicenseDocId;
	private FinderPath _finderPathCountBydgfFglPreDtlsByTradeLicenseDocId;

	/**
	 * Returns all the dgf fgl pre dtlses where tradeLicenseDocId = &#63;.
	 *
	 * @param tradeLicenseDocId the trade license doc ID
	 * @return the matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByTradeLicenseDocId(
		long tradeLicenseDocId) {

		return findBydgfFglPreDtlsByTradeLicenseDocId(
			tradeLicenseDocId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses where tradeLicenseDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param tradeLicenseDocId the trade license doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByTradeLicenseDocId(
		long tradeLicenseDocId, int start, int end) {

		return findBydgfFglPreDtlsByTradeLicenseDocId(
			tradeLicenseDocId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where tradeLicenseDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param tradeLicenseDocId the trade license doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByTradeLicenseDocId(
		long tradeLicenseDocId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return findBydgfFglPreDtlsByTradeLicenseDocId(
			tradeLicenseDocId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where tradeLicenseDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param tradeLicenseDocId the trade license doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByTradeLicenseDocId(
		long tradeLicenseDocId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydgfFglPreDtlsByTradeLicenseDocId;
				finderArgs = new Object[] {tradeLicenseDocId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBydgfFglPreDtlsByTradeLicenseDocId;
			finderArgs = new Object[] {
				tradeLicenseDocId, start, end, orderByComparator
			};
		}

		List<DgfFglPreDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfFglPreDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfFglPreDtls dgfFglPreDtls : list) {
					if (tradeLicenseDocId !=
							dgfFglPreDtls.getTradeLicenseDocId()) {

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

			sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLPREDTLSBYTRADELICENSEDOCID_TRADELICENSEDOCID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tradeLicenseDocId);

				list = (List<DgfFglPreDtls>)QueryUtil.list(
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
	 * Returns the first dgf fgl pre dtls in the ordered set where tradeLicenseDocId = &#63;.
	 *
	 * @param tradeLicenseDocId the trade license doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByTradeLicenseDocId_First(
			long tradeLicenseDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls =
			fetchBydgfFglPreDtlsByTradeLicenseDocId_First(
				tradeLicenseDocId, orderByComparator);

		if (dgfFglPreDtls != null) {
			return dgfFglPreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tradeLicenseDocId=");
		sb.append(tradeLicenseDocId);

		sb.append("}");

		throw new NoSuchDgfFglPreDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where tradeLicenseDocId = &#63;.
	 *
	 * @param tradeLicenseDocId the trade license doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByTradeLicenseDocId_First(
		long tradeLicenseDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		List<DgfFglPreDtls> list = findBydgfFglPreDtlsByTradeLicenseDocId(
			tradeLicenseDocId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where tradeLicenseDocId = &#63;.
	 *
	 * @param tradeLicenseDocId the trade license doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByTradeLicenseDocId_Last(
			long tradeLicenseDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls =
			fetchBydgfFglPreDtlsByTradeLicenseDocId_Last(
				tradeLicenseDocId, orderByComparator);

		if (dgfFglPreDtls != null) {
			return dgfFglPreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tradeLicenseDocId=");
		sb.append(tradeLicenseDocId);

		sb.append("}");

		throw new NoSuchDgfFglPreDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where tradeLicenseDocId = &#63;.
	 *
	 * @param tradeLicenseDocId the trade license doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByTradeLicenseDocId_Last(
		long tradeLicenseDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		int count = countBydgfFglPreDtlsByTradeLicenseDocId(tradeLicenseDocId);

		if (count == 0) {
			return null;
		}

		List<DgfFglPreDtls> list = findBydgfFglPreDtlsByTradeLicenseDocId(
			tradeLicenseDocId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where tradeLicenseDocId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param tradeLicenseDocId the trade license doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	@Override
	public DgfFglPreDtls[] findBydgfFglPreDtlsByTradeLicenseDocId_PrevAndNext(
			long fglPrePrimaryId, long tradeLicenseDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls = findByPrimaryKey(fglPrePrimaryId);

		Session session = null;

		try {
			session = openSession();

			DgfFglPreDtls[] array = new DgfFglPreDtlsImpl[3];

			array[0] = getBydgfFglPreDtlsByTradeLicenseDocId_PrevAndNext(
				session, dgfFglPreDtls, tradeLicenseDocId, orderByComparator,
				true);

			array[1] = dgfFglPreDtls;

			array[2] = getBydgfFglPreDtlsByTradeLicenseDocId_PrevAndNext(
				session, dgfFglPreDtls, tradeLicenseDocId, orderByComparator,
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

	protected DgfFglPreDtls getBydgfFglPreDtlsByTradeLicenseDocId_PrevAndNext(
		Session session, DgfFglPreDtls dgfFglPreDtls, long tradeLicenseDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

		sb.append(
			_FINDER_COLUMN_DGFFGLPREDTLSBYTRADELICENSEDOCID_TRADELICENSEDOCID_2);

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
			sb.append(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(tradeLicenseDocId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfFglPreDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfFglPreDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf fgl pre dtlses where tradeLicenseDocId = &#63; from the database.
	 *
	 * @param tradeLicenseDocId the trade license doc ID
	 */
	@Override
	public void removeBydgfFglPreDtlsByTradeLicenseDocId(
		long tradeLicenseDocId) {

		for (DgfFglPreDtls dgfFglPreDtls :
				findBydgfFglPreDtlsByTradeLicenseDocId(
					tradeLicenseDocId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgfFglPreDtls);
		}
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where tradeLicenseDocId = &#63;.
	 *
	 * @param tradeLicenseDocId the trade license doc ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	@Override
	public int countBydgfFglPreDtlsByTradeLicenseDocId(long tradeLicenseDocId) {
		FinderPath finderPath =
			_finderPathCountBydgfFglPreDtlsByTradeLicenseDocId;

		Object[] finderArgs = new Object[] {tradeLicenseDocId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFFGLPREDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLPREDTLSBYTRADELICENSEDOCID_TRADELICENSEDOCID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tradeLicenseDocId);

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
		_FINDER_COLUMN_DGFFGLPREDTLSBYTRADELICENSEDOCID_TRADELICENSEDOCID_2 =
			"dgfFglPreDtls.tradeLicenseDocId = ?";

	private FinderPath
		_finderPathWithPaginationFindBydgfFglPreDtlsByBussIdentfctDocId;
	private FinderPath
		_finderPathWithoutPaginationFindBydgfFglPreDtlsByBussIdentfctDocId;
	private FinderPath _finderPathCountBydgfFglPreDtlsByBussIdentfctDocId;

	/**
	 * Returns all the dgf fgl pre dtlses where bussIdentfctDocId = &#63;.
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID
	 * @return the matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByBussIdentfctDocId(
		long bussIdentfctDocId) {

		return findBydgfFglPreDtlsByBussIdentfctDocId(
			bussIdentfctDocId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses where bussIdentfctDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByBussIdentfctDocId(
		long bussIdentfctDocId, int start, int end) {

		return findBydgfFglPreDtlsByBussIdentfctDocId(
			bussIdentfctDocId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where bussIdentfctDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByBussIdentfctDocId(
		long bussIdentfctDocId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return findBydgfFglPreDtlsByBussIdentfctDocId(
			bussIdentfctDocId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where bussIdentfctDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByBussIdentfctDocId(
		long bussIdentfctDocId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydgfFglPreDtlsByBussIdentfctDocId;
				finderArgs = new Object[] {bussIdentfctDocId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBydgfFglPreDtlsByBussIdentfctDocId;
			finderArgs = new Object[] {
				bussIdentfctDocId, start, end, orderByComparator
			};
		}

		List<DgfFglPreDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfFglPreDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfFglPreDtls dgfFglPreDtls : list) {
					if (bussIdentfctDocId !=
							dgfFglPreDtls.getBussIdentfctDocId()) {

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

			sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLPREDTLSBYBUSSIDENTFCTDOCID_BUSSIDENTFCTDOCID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(bussIdentfctDocId);

				list = (List<DgfFglPreDtls>)QueryUtil.list(
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
	 * Returns the first dgf fgl pre dtls in the ordered set where bussIdentfctDocId = &#63;.
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByBussIdentfctDocId_First(
			long bussIdentfctDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls =
			fetchBydgfFglPreDtlsByBussIdentfctDocId_First(
				bussIdentfctDocId, orderByComparator);

		if (dgfFglPreDtls != null) {
			return dgfFglPreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bussIdentfctDocId=");
		sb.append(bussIdentfctDocId);

		sb.append("}");

		throw new NoSuchDgfFglPreDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where bussIdentfctDocId = &#63;.
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByBussIdentfctDocId_First(
		long bussIdentfctDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		List<DgfFglPreDtls> list = findBydgfFglPreDtlsByBussIdentfctDocId(
			bussIdentfctDocId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where bussIdentfctDocId = &#63;.
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByBussIdentfctDocId_Last(
			long bussIdentfctDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls =
			fetchBydgfFglPreDtlsByBussIdentfctDocId_Last(
				bussIdentfctDocId, orderByComparator);

		if (dgfFglPreDtls != null) {
			return dgfFglPreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bussIdentfctDocId=");
		sb.append(bussIdentfctDocId);

		sb.append("}");

		throw new NoSuchDgfFglPreDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where bussIdentfctDocId = &#63;.
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByBussIdentfctDocId_Last(
		long bussIdentfctDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		int count = countBydgfFglPreDtlsByBussIdentfctDocId(bussIdentfctDocId);

		if (count == 0) {
			return null;
		}

		List<DgfFglPreDtls> list = findBydgfFglPreDtlsByBussIdentfctDocId(
			bussIdentfctDocId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where bussIdentfctDocId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param bussIdentfctDocId the buss identfct doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	@Override
	public DgfFglPreDtls[] findBydgfFglPreDtlsByBussIdentfctDocId_PrevAndNext(
			long fglPrePrimaryId, long bussIdentfctDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls = findByPrimaryKey(fglPrePrimaryId);

		Session session = null;

		try {
			session = openSession();

			DgfFglPreDtls[] array = new DgfFglPreDtlsImpl[3];

			array[0] = getBydgfFglPreDtlsByBussIdentfctDocId_PrevAndNext(
				session, dgfFglPreDtls, bussIdentfctDocId, orderByComparator,
				true);

			array[1] = dgfFglPreDtls;

			array[2] = getBydgfFglPreDtlsByBussIdentfctDocId_PrevAndNext(
				session, dgfFglPreDtls, bussIdentfctDocId, orderByComparator,
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

	protected DgfFglPreDtls getBydgfFglPreDtlsByBussIdentfctDocId_PrevAndNext(
		Session session, DgfFglPreDtls dgfFglPreDtls, long bussIdentfctDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

		sb.append(
			_FINDER_COLUMN_DGFFGLPREDTLSBYBUSSIDENTFCTDOCID_BUSSIDENTFCTDOCID_2);

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
			sb.append(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(bussIdentfctDocId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfFglPreDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfFglPreDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf fgl pre dtlses where bussIdentfctDocId = &#63; from the database.
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID
	 */
	@Override
	public void removeBydgfFglPreDtlsByBussIdentfctDocId(
		long bussIdentfctDocId) {

		for (DgfFglPreDtls dgfFglPreDtls :
				findBydgfFglPreDtlsByBussIdentfctDocId(
					bussIdentfctDocId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgfFglPreDtls);
		}
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where bussIdentfctDocId = &#63;.
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	@Override
	public int countBydgfFglPreDtlsByBussIdentfctDocId(long bussIdentfctDocId) {
		FinderPath finderPath =
			_finderPathCountBydgfFglPreDtlsByBussIdentfctDocId;

		Object[] finderArgs = new Object[] {bussIdentfctDocId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFFGLPREDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLPREDTLSBYBUSSIDENTFCTDOCID_BUSSIDENTFCTDOCID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(bussIdentfctDocId);

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
		_FINDER_COLUMN_DGFFGLPREDTLSBYBUSSIDENTFCTDOCID_BUSSIDENTFCTDOCID_2 =
			"dgfFglPreDtls.bussIdentfctDocId = ?";

	private FinderPath
		_finderPathWithPaginationFindBydgfFglPreDtlsByTaxIdentfctDocId;
	private FinderPath
		_finderPathWithoutPaginationFindBydgfFglPreDtlsByTaxIdentfctDocId;
	private FinderPath _finderPathCountBydgfFglPreDtlsByTaxIdentfctDocId;

	/**
	 * Returns all the dgf fgl pre dtlses where taxIdentfctDocId = &#63;.
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID
	 * @return the matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByTaxIdentfctDocId(
		long taxIdentfctDocId) {

		return findBydgfFglPreDtlsByTaxIdentfctDocId(
			taxIdentfctDocId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses where taxIdentfctDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByTaxIdentfctDocId(
		long taxIdentfctDocId, int start, int end) {

		return findBydgfFglPreDtlsByTaxIdentfctDocId(
			taxIdentfctDocId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where taxIdentfctDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByTaxIdentfctDocId(
		long taxIdentfctDocId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return findBydgfFglPreDtlsByTaxIdentfctDocId(
			taxIdentfctDocId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where taxIdentfctDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByTaxIdentfctDocId(
		long taxIdentfctDocId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydgfFglPreDtlsByTaxIdentfctDocId;
				finderArgs = new Object[] {taxIdentfctDocId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBydgfFglPreDtlsByTaxIdentfctDocId;
			finderArgs = new Object[] {
				taxIdentfctDocId, start, end, orderByComparator
			};
		}

		List<DgfFglPreDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfFglPreDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfFglPreDtls dgfFglPreDtls : list) {
					if (taxIdentfctDocId !=
							dgfFglPreDtls.getTaxIdentfctDocId()) {

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

			sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLPREDTLSBYTAXIDENTFCTDOCID_TAXIDENTFCTDOCID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(taxIdentfctDocId);

				list = (List<DgfFglPreDtls>)QueryUtil.list(
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
	 * Returns the first dgf fgl pre dtls in the ordered set where taxIdentfctDocId = &#63;.
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByTaxIdentfctDocId_First(
			long taxIdentfctDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls =
			fetchBydgfFglPreDtlsByTaxIdentfctDocId_First(
				taxIdentfctDocId, orderByComparator);

		if (dgfFglPreDtls != null) {
			return dgfFglPreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("taxIdentfctDocId=");
		sb.append(taxIdentfctDocId);

		sb.append("}");

		throw new NoSuchDgfFglPreDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where taxIdentfctDocId = &#63;.
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByTaxIdentfctDocId_First(
		long taxIdentfctDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		List<DgfFglPreDtls> list = findBydgfFglPreDtlsByTaxIdentfctDocId(
			taxIdentfctDocId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where taxIdentfctDocId = &#63;.
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByTaxIdentfctDocId_Last(
			long taxIdentfctDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls =
			fetchBydgfFglPreDtlsByTaxIdentfctDocId_Last(
				taxIdentfctDocId, orderByComparator);

		if (dgfFglPreDtls != null) {
			return dgfFglPreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("taxIdentfctDocId=");
		sb.append(taxIdentfctDocId);

		sb.append("}");

		throw new NoSuchDgfFglPreDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where taxIdentfctDocId = &#63;.
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByTaxIdentfctDocId_Last(
		long taxIdentfctDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		int count = countBydgfFglPreDtlsByTaxIdentfctDocId(taxIdentfctDocId);

		if (count == 0) {
			return null;
		}

		List<DgfFglPreDtls> list = findBydgfFglPreDtlsByTaxIdentfctDocId(
			taxIdentfctDocId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where taxIdentfctDocId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param taxIdentfctDocId the tax identfct doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	@Override
	public DgfFglPreDtls[] findBydgfFglPreDtlsByTaxIdentfctDocId_PrevAndNext(
			long fglPrePrimaryId, long taxIdentfctDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls = findByPrimaryKey(fglPrePrimaryId);

		Session session = null;

		try {
			session = openSession();

			DgfFglPreDtls[] array = new DgfFglPreDtlsImpl[3];

			array[0] = getBydgfFglPreDtlsByTaxIdentfctDocId_PrevAndNext(
				session, dgfFglPreDtls, taxIdentfctDocId, orderByComparator,
				true);

			array[1] = dgfFglPreDtls;

			array[2] = getBydgfFglPreDtlsByTaxIdentfctDocId_PrevAndNext(
				session, dgfFglPreDtls, taxIdentfctDocId, orderByComparator,
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

	protected DgfFglPreDtls getBydgfFglPreDtlsByTaxIdentfctDocId_PrevAndNext(
		Session session, DgfFglPreDtls dgfFglPreDtls, long taxIdentfctDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

		sb.append(
			_FINDER_COLUMN_DGFFGLPREDTLSBYTAXIDENTFCTDOCID_TAXIDENTFCTDOCID_2);

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
			sb.append(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(taxIdentfctDocId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfFglPreDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfFglPreDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf fgl pre dtlses where taxIdentfctDocId = &#63; from the database.
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID
	 */
	@Override
	public void removeBydgfFglPreDtlsByTaxIdentfctDocId(long taxIdentfctDocId) {
		for (DgfFglPreDtls dgfFglPreDtls :
				findBydgfFglPreDtlsByTaxIdentfctDocId(
					taxIdentfctDocId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgfFglPreDtls);
		}
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where taxIdentfctDocId = &#63;.
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	@Override
	public int countBydgfFglPreDtlsByTaxIdentfctDocId(long taxIdentfctDocId) {
		FinderPath finderPath =
			_finderPathCountBydgfFglPreDtlsByTaxIdentfctDocId;

		Object[] finderArgs = new Object[] {taxIdentfctDocId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFFGLPREDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLPREDTLSBYTAXIDENTFCTDOCID_TAXIDENTFCTDOCID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(taxIdentfctDocId);

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
		_FINDER_COLUMN_DGFFGLPREDTLSBYTAXIDENTFCTDOCID_TAXIDENTFCTDOCID_2 =
			"dgfFglPreDtls.taxIdentfctDocId = ?";

	private FinderPath
		_finderPathWithPaginationFindBydgfFglPreDtlsByBnkStatmtDocId;
	private FinderPath
		_finderPathWithoutPaginationFindBydgfFglPreDtlsByBnkStatmtDocId;
	private FinderPath _finderPathCountBydgfFglPreDtlsByBnkStatmtDocId;

	/**
	 * Returns all the dgf fgl pre dtlses where bnkStatmtDocId = &#63;.
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 * @return the matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByBnkStatmtDocId(
		long bnkStatmtDocId) {

		return findBydgfFglPreDtlsByBnkStatmtDocId(
			bnkStatmtDocId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses where bnkStatmtDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByBnkStatmtDocId(
		long bnkStatmtDocId, int start, int end) {

		return findBydgfFglPreDtlsByBnkStatmtDocId(
			bnkStatmtDocId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where bnkStatmtDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByBnkStatmtDocId(
		long bnkStatmtDocId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return findBydgfFglPreDtlsByBnkStatmtDocId(
			bnkStatmtDocId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where bnkStatmtDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByBnkStatmtDocId(
		long bnkStatmtDocId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydgfFglPreDtlsByBnkStatmtDocId;
				finderArgs = new Object[] {bnkStatmtDocId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBydgfFglPreDtlsByBnkStatmtDocId;
			finderArgs = new Object[] {
				bnkStatmtDocId, start, end, orderByComparator
			};
		}

		List<DgfFglPreDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfFglPreDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfFglPreDtls dgfFglPreDtls : list) {
					if (bnkStatmtDocId != dgfFglPreDtls.getBnkStatmtDocId()) {
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

			sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLPREDTLSBYBNKSTATMTDOCID_BNKSTATMTDOCID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(bnkStatmtDocId);

				list = (List<DgfFglPreDtls>)QueryUtil.list(
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
	 * Returns the first dgf fgl pre dtls in the ordered set where bnkStatmtDocId = &#63;.
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByBnkStatmtDocId_First(
			long bnkStatmtDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls =
			fetchBydgfFglPreDtlsByBnkStatmtDocId_First(
				bnkStatmtDocId, orderByComparator);

		if (dgfFglPreDtls != null) {
			return dgfFglPreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bnkStatmtDocId=");
		sb.append(bnkStatmtDocId);

		sb.append("}");

		throw new NoSuchDgfFglPreDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where bnkStatmtDocId = &#63;.
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByBnkStatmtDocId_First(
		long bnkStatmtDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		List<DgfFglPreDtls> list = findBydgfFglPreDtlsByBnkStatmtDocId(
			bnkStatmtDocId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where bnkStatmtDocId = &#63;.
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByBnkStatmtDocId_Last(
			long bnkStatmtDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls = fetchBydgfFglPreDtlsByBnkStatmtDocId_Last(
			bnkStatmtDocId, orderByComparator);

		if (dgfFglPreDtls != null) {
			return dgfFglPreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bnkStatmtDocId=");
		sb.append(bnkStatmtDocId);

		sb.append("}");

		throw new NoSuchDgfFglPreDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where bnkStatmtDocId = &#63;.
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByBnkStatmtDocId_Last(
		long bnkStatmtDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		int count = countBydgfFglPreDtlsByBnkStatmtDocId(bnkStatmtDocId);

		if (count == 0) {
			return null;
		}

		List<DgfFglPreDtls> list = findBydgfFglPreDtlsByBnkStatmtDocId(
			bnkStatmtDocId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where bnkStatmtDocId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	@Override
	public DgfFglPreDtls[] findBydgfFglPreDtlsByBnkStatmtDocId_PrevAndNext(
			long fglPrePrimaryId, long bnkStatmtDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls = findByPrimaryKey(fglPrePrimaryId);

		Session session = null;

		try {
			session = openSession();

			DgfFglPreDtls[] array = new DgfFglPreDtlsImpl[3];

			array[0] = getBydgfFglPreDtlsByBnkStatmtDocId_PrevAndNext(
				session, dgfFglPreDtls, bnkStatmtDocId, orderByComparator,
				true);

			array[1] = dgfFglPreDtls;

			array[2] = getBydgfFglPreDtlsByBnkStatmtDocId_PrevAndNext(
				session, dgfFglPreDtls, bnkStatmtDocId, orderByComparator,
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

	protected DgfFglPreDtls getBydgfFglPreDtlsByBnkStatmtDocId_PrevAndNext(
		Session session, DgfFglPreDtls dgfFglPreDtls, long bnkStatmtDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

		sb.append(
			_FINDER_COLUMN_DGFFGLPREDTLSBYBNKSTATMTDOCID_BNKSTATMTDOCID_2);

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
			sb.append(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(bnkStatmtDocId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfFglPreDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfFglPreDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf fgl pre dtlses where bnkStatmtDocId = &#63; from the database.
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 */
	@Override
	public void removeBydgfFglPreDtlsByBnkStatmtDocId(long bnkStatmtDocId) {
		for (DgfFglPreDtls dgfFglPreDtls :
				findBydgfFglPreDtlsByBnkStatmtDocId(
					bnkStatmtDocId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgfFglPreDtls);
		}
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where bnkStatmtDocId = &#63;.
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	@Override
	public int countBydgfFglPreDtlsByBnkStatmtDocId(long bnkStatmtDocId) {
		FinderPath finderPath = _finderPathCountBydgfFglPreDtlsByBnkStatmtDocId;

		Object[] finderArgs = new Object[] {bnkStatmtDocId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFFGLPREDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLPREDTLSBYBNKSTATMTDOCID_BNKSTATMTDOCID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(bnkStatmtDocId);

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
		_FINDER_COLUMN_DGFFGLPREDTLSBYBNKSTATMTDOCID_BNKSTATMTDOCID_2 =
			"dgfFglPreDtls.bnkStatmtDocId = ?";

	private FinderPath
		_finderPathWithPaginationFindBydgfFglPreDtlsByPaymentChallanId;
	private FinderPath
		_finderPathWithoutPaginationFindBydgfFglPreDtlsByPaymentChallanId;
	private FinderPath _finderPathCountBydgfFglPreDtlsByPaymentChallanId;

	/**
	 * Returns all the dgf fgl pre dtlses where paymentChallanId = &#63;.
	 *
	 * @param paymentChallanId the payment challan ID
	 * @return the matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByPaymentChallanId(
		long paymentChallanId) {

		return findBydgfFglPreDtlsByPaymentChallanId(
			paymentChallanId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses where paymentChallanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param paymentChallanId the payment challan ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByPaymentChallanId(
		long paymentChallanId, int start, int end) {

		return findBydgfFglPreDtlsByPaymentChallanId(
			paymentChallanId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where paymentChallanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param paymentChallanId the payment challan ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByPaymentChallanId(
		long paymentChallanId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return findBydgfFglPreDtlsByPaymentChallanId(
			paymentChallanId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where paymentChallanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param paymentChallanId the payment challan ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByPaymentChallanId(
		long paymentChallanId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydgfFglPreDtlsByPaymentChallanId;
				finderArgs = new Object[] {paymentChallanId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBydgfFglPreDtlsByPaymentChallanId;
			finderArgs = new Object[] {
				paymentChallanId, start, end, orderByComparator
			};
		}

		List<DgfFglPreDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfFglPreDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfFglPreDtls dgfFglPreDtls : list) {
					if (paymentChallanId !=
							dgfFglPreDtls.getPaymentChallanId()) {

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

			sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLPREDTLSBYPAYMENTCHALLANID_PAYMENTCHALLANID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(paymentChallanId);

				list = (List<DgfFglPreDtls>)QueryUtil.list(
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
	 * Returns the first dgf fgl pre dtls in the ordered set where paymentChallanId = &#63;.
	 *
	 * @param paymentChallanId the payment challan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByPaymentChallanId_First(
			long paymentChallanId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls =
			fetchBydgfFglPreDtlsByPaymentChallanId_First(
				paymentChallanId, orderByComparator);

		if (dgfFglPreDtls != null) {
			return dgfFglPreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("paymentChallanId=");
		sb.append(paymentChallanId);

		sb.append("}");

		throw new NoSuchDgfFglPreDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where paymentChallanId = &#63;.
	 *
	 * @param paymentChallanId the payment challan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByPaymentChallanId_First(
		long paymentChallanId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		List<DgfFglPreDtls> list = findBydgfFglPreDtlsByPaymentChallanId(
			paymentChallanId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where paymentChallanId = &#63;.
	 *
	 * @param paymentChallanId the payment challan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByPaymentChallanId_Last(
			long paymentChallanId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls =
			fetchBydgfFglPreDtlsByPaymentChallanId_Last(
				paymentChallanId, orderByComparator);

		if (dgfFglPreDtls != null) {
			return dgfFglPreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("paymentChallanId=");
		sb.append(paymentChallanId);

		sb.append("}");

		throw new NoSuchDgfFglPreDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where paymentChallanId = &#63;.
	 *
	 * @param paymentChallanId the payment challan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByPaymentChallanId_Last(
		long paymentChallanId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		int count = countBydgfFglPreDtlsByPaymentChallanId(paymentChallanId);

		if (count == 0) {
			return null;
		}

		List<DgfFglPreDtls> list = findBydgfFglPreDtlsByPaymentChallanId(
			paymentChallanId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where paymentChallanId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param paymentChallanId the payment challan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	@Override
	public DgfFglPreDtls[] findBydgfFglPreDtlsByPaymentChallanId_PrevAndNext(
			long fglPrePrimaryId, long paymentChallanId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls = findByPrimaryKey(fglPrePrimaryId);

		Session session = null;

		try {
			session = openSession();

			DgfFglPreDtls[] array = new DgfFglPreDtlsImpl[3];

			array[0] = getBydgfFglPreDtlsByPaymentChallanId_PrevAndNext(
				session, dgfFglPreDtls, paymentChallanId, orderByComparator,
				true);

			array[1] = dgfFglPreDtls;

			array[2] = getBydgfFglPreDtlsByPaymentChallanId_PrevAndNext(
				session, dgfFglPreDtls, paymentChallanId, orderByComparator,
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

	protected DgfFglPreDtls getBydgfFglPreDtlsByPaymentChallanId_PrevAndNext(
		Session session, DgfFglPreDtls dgfFglPreDtls, long paymentChallanId,
		OrderByComparator<DgfFglPreDtls> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

		sb.append(
			_FINDER_COLUMN_DGFFGLPREDTLSBYPAYMENTCHALLANID_PAYMENTCHALLANID_2);

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
			sb.append(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(paymentChallanId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfFglPreDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfFglPreDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf fgl pre dtlses where paymentChallanId = &#63; from the database.
	 *
	 * @param paymentChallanId the payment challan ID
	 */
	@Override
	public void removeBydgfFglPreDtlsByPaymentChallanId(long paymentChallanId) {
		for (DgfFglPreDtls dgfFglPreDtls :
				findBydgfFglPreDtlsByPaymentChallanId(
					paymentChallanId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgfFglPreDtls);
		}
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where paymentChallanId = &#63;.
	 *
	 * @param paymentChallanId the payment challan ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	@Override
	public int countBydgfFglPreDtlsByPaymentChallanId(long paymentChallanId) {
		FinderPath finderPath =
			_finderPathCountBydgfFglPreDtlsByPaymentChallanId;

		Object[] finderArgs = new Object[] {paymentChallanId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFFGLPREDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLPREDTLSBYPAYMENTCHALLANID_PAYMENTCHALLANID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(paymentChallanId);

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
		_FINDER_COLUMN_DGFFGLPREDTLSBYPAYMENTCHALLANID_PAYMENTCHALLANID_2 =
			"dgfFglPreDtls.paymentChallanId = ?";

	private FinderPath
		_finderPathWithPaginationFindBydgfFglPreDtlsByDuplicateLicenseReasonId;
	private FinderPath
		_finderPathWithoutPaginationFindBydgfFglPreDtlsByDuplicateLicenseReasonId;
	private FinderPath
		_finderPathCountBydgfFglPreDtlsByDuplicateLicenseReasonId;

	/**
	 * Returns all the dgf fgl pre dtlses where duplicateLicenseReasonId = &#63;.
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 * @return the matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByDuplicateLicenseReasonId(
		long duplicateLicenseReasonId) {

		return findBydgfFglPreDtlsByDuplicateLicenseReasonId(
			duplicateLicenseReasonId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses where duplicateLicenseReasonId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByDuplicateLicenseReasonId(
		long duplicateLicenseReasonId, int start, int end) {

		return findBydgfFglPreDtlsByDuplicateLicenseReasonId(
			duplicateLicenseReasonId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where duplicateLicenseReasonId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByDuplicateLicenseReasonId(
		long duplicateLicenseReasonId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return findBydgfFglPreDtlsByDuplicateLicenseReasonId(
			duplicateLicenseReasonId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where duplicateLicenseReasonId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByDuplicateLicenseReasonId(
		long duplicateLicenseReasonId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydgfFglPreDtlsByDuplicateLicenseReasonId;
				finderArgs = new Object[] {duplicateLicenseReasonId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBydgfFglPreDtlsByDuplicateLicenseReasonId;
			finderArgs = new Object[] {
				duplicateLicenseReasonId, start, end, orderByComparator
			};
		}

		List<DgfFglPreDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfFglPreDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfFglPreDtls dgfFglPreDtls : list) {
					if (duplicateLicenseReasonId !=
							dgfFglPreDtls.getDuplicateLicenseReasonId()) {

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

			sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLPREDTLSBYDUPLICATELICENSEREASONID_DUPLICATELICENSEREASONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(duplicateLicenseReasonId);

				list = (List<DgfFglPreDtls>)QueryUtil.list(
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
	 * Returns the first dgf fgl pre dtls in the ordered set where duplicateLicenseReasonId = &#63;.
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByDuplicateLicenseReasonId_First(
			long duplicateLicenseReasonId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls =
			fetchBydgfFglPreDtlsByDuplicateLicenseReasonId_First(
				duplicateLicenseReasonId, orderByComparator);

		if (dgfFglPreDtls != null) {
			return dgfFglPreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("duplicateLicenseReasonId=");
		sb.append(duplicateLicenseReasonId);

		sb.append("}");

		throw new NoSuchDgfFglPreDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where duplicateLicenseReasonId = &#63;.
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByDuplicateLicenseReasonId_First(
		long duplicateLicenseReasonId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		List<DgfFglPreDtls> list =
			findBydgfFglPreDtlsByDuplicateLicenseReasonId(
				duplicateLicenseReasonId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where duplicateLicenseReasonId = &#63;.
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByDuplicateLicenseReasonId_Last(
			long duplicateLicenseReasonId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls =
			fetchBydgfFglPreDtlsByDuplicateLicenseReasonId_Last(
				duplicateLicenseReasonId, orderByComparator);

		if (dgfFglPreDtls != null) {
			return dgfFglPreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("duplicateLicenseReasonId=");
		sb.append(duplicateLicenseReasonId);

		sb.append("}");

		throw new NoSuchDgfFglPreDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where duplicateLicenseReasonId = &#63;.
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByDuplicateLicenseReasonId_Last(
		long duplicateLicenseReasonId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		int count = countBydgfFglPreDtlsByDuplicateLicenseReasonId(
			duplicateLicenseReasonId);

		if (count == 0) {
			return null;
		}

		List<DgfFglPreDtls> list =
			findBydgfFglPreDtlsByDuplicateLicenseReasonId(
				duplicateLicenseReasonId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where duplicateLicenseReasonId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	@Override
	public DgfFglPreDtls[]
			findBydgfFglPreDtlsByDuplicateLicenseReasonId_PrevAndNext(
				long fglPrePrimaryId, long duplicateLicenseReasonId,
				OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls = findByPrimaryKey(fglPrePrimaryId);

		Session session = null;

		try {
			session = openSession();

			DgfFglPreDtls[] array = new DgfFglPreDtlsImpl[3];

			array[0] = getBydgfFglPreDtlsByDuplicateLicenseReasonId_PrevAndNext(
				session, dgfFglPreDtls, duplicateLicenseReasonId,
				orderByComparator, true);

			array[1] = dgfFglPreDtls;

			array[2] = getBydgfFglPreDtlsByDuplicateLicenseReasonId_PrevAndNext(
				session, dgfFglPreDtls, duplicateLicenseReasonId,
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

	protected DgfFglPreDtls
		getBydgfFglPreDtlsByDuplicateLicenseReasonId_PrevAndNext(
			Session session, DgfFglPreDtls dgfFglPreDtls,
			long duplicateLicenseReasonId,
			OrderByComparator<DgfFglPreDtls> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

		sb.append(
			_FINDER_COLUMN_DGFFGLPREDTLSBYDUPLICATELICENSEREASONID_DUPLICATELICENSEREASONID_2);

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
			sb.append(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(duplicateLicenseReasonId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfFglPreDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfFglPreDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf fgl pre dtlses where duplicateLicenseReasonId = &#63; from the database.
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 */
	@Override
	public void removeBydgfFglPreDtlsByDuplicateLicenseReasonId(
		long duplicateLicenseReasonId) {

		for (DgfFglPreDtls dgfFglPreDtls :
				findBydgfFglPreDtlsByDuplicateLicenseReasonId(
					duplicateLicenseReasonId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(dgfFglPreDtls);
		}
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where duplicateLicenseReasonId = &#63;.
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	@Override
	public int countBydgfFglPreDtlsByDuplicateLicenseReasonId(
		long duplicateLicenseReasonId) {

		FinderPath finderPath =
			_finderPathCountBydgfFglPreDtlsByDuplicateLicenseReasonId;

		Object[] finderArgs = new Object[] {duplicateLicenseReasonId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFFGLPREDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLPREDTLSBYDUPLICATELICENSEREASONID_DUPLICATELICENSEREASONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(duplicateLicenseReasonId);

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
		_FINDER_COLUMN_DGFFGLPREDTLSBYDUPLICATELICENSEREASONID_DUPLICATELICENSEREASONID_2 =
			"dgfFglPreDtls.duplicateLicenseReasonId = ?";

	private FinderPath
		_finderPathWithPaginationFindBydgfFglPreDtlsByPhotographDocId;
	private FinderPath
		_finderPathWithoutPaginationFindBydgfFglPreDtlsByPhotographDocId;
	private FinderPath _finderPathCountBydgfFglPreDtlsByPhotographDocId;

	/**
	 * Returns all the dgf fgl pre dtlses where photographDocId = &#63;.
	 *
	 * @param photographDocId the photograph doc ID
	 * @return the matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByPhotographDocId(
		long photographDocId) {

		return findBydgfFglPreDtlsByPhotographDocId(
			photographDocId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses where photographDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param photographDocId the photograph doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByPhotographDocId(
		long photographDocId, int start, int end) {

		return findBydgfFglPreDtlsByPhotographDocId(
			photographDocId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where photographDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param photographDocId the photograph doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByPhotographDocId(
		long photographDocId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return findBydgfFglPreDtlsByPhotographDocId(
			photographDocId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where photographDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param photographDocId the photograph doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByPhotographDocId(
		long photographDocId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydgfFglPreDtlsByPhotographDocId;
				finderArgs = new Object[] {photographDocId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBydgfFglPreDtlsByPhotographDocId;
			finderArgs = new Object[] {
				photographDocId, start, end, orderByComparator
			};
		}

		List<DgfFglPreDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfFglPreDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfFglPreDtls dgfFglPreDtls : list) {
					if (photographDocId != dgfFglPreDtls.getPhotographDocId()) {
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

			sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLPREDTLSBYPHOTOGRAPHDOCID_PHOTOGRAPHDOCID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(photographDocId);

				list = (List<DgfFglPreDtls>)QueryUtil.list(
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
	 * Returns the first dgf fgl pre dtls in the ordered set where photographDocId = &#63;.
	 *
	 * @param photographDocId the photograph doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByPhotographDocId_First(
			long photographDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls =
			fetchBydgfFglPreDtlsByPhotographDocId_First(
				photographDocId, orderByComparator);

		if (dgfFglPreDtls != null) {
			return dgfFglPreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("photographDocId=");
		sb.append(photographDocId);

		sb.append("}");

		throw new NoSuchDgfFglPreDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where photographDocId = &#63;.
	 *
	 * @param photographDocId the photograph doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByPhotographDocId_First(
		long photographDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		List<DgfFglPreDtls> list = findBydgfFglPreDtlsByPhotographDocId(
			photographDocId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where photographDocId = &#63;.
	 *
	 * @param photographDocId the photograph doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByPhotographDocId_Last(
			long photographDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls =
			fetchBydgfFglPreDtlsByPhotographDocId_Last(
				photographDocId, orderByComparator);

		if (dgfFglPreDtls != null) {
			return dgfFglPreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("photographDocId=");
		sb.append(photographDocId);

		sb.append("}");

		throw new NoSuchDgfFglPreDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where photographDocId = &#63;.
	 *
	 * @param photographDocId the photograph doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByPhotographDocId_Last(
		long photographDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		int count = countBydgfFglPreDtlsByPhotographDocId(photographDocId);

		if (count == 0) {
			return null;
		}

		List<DgfFglPreDtls> list = findBydgfFglPreDtlsByPhotographDocId(
			photographDocId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where photographDocId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param photographDocId the photograph doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	@Override
	public DgfFglPreDtls[] findBydgfFglPreDtlsByPhotographDocId_PrevAndNext(
			long fglPrePrimaryId, long photographDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls = findByPrimaryKey(fglPrePrimaryId);

		Session session = null;

		try {
			session = openSession();

			DgfFglPreDtls[] array = new DgfFglPreDtlsImpl[3];

			array[0] = getBydgfFglPreDtlsByPhotographDocId_PrevAndNext(
				session, dgfFglPreDtls, photographDocId, orderByComparator,
				true);

			array[1] = dgfFglPreDtls;

			array[2] = getBydgfFglPreDtlsByPhotographDocId_PrevAndNext(
				session, dgfFglPreDtls, photographDocId, orderByComparator,
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

	protected DgfFglPreDtls getBydgfFglPreDtlsByPhotographDocId_PrevAndNext(
		Session session, DgfFglPreDtls dgfFglPreDtls, long photographDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

		sb.append(
			_FINDER_COLUMN_DGFFGLPREDTLSBYPHOTOGRAPHDOCID_PHOTOGRAPHDOCID_2);

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
			sb.append(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(photographDocId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfFglPreDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfFglPreDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf fgl pre dtlses where photographDocId = &#63; from the database.
	 *
	 * @param photographDocId the photograph doc ID
	 */
	@Override
	public void removeBydgfFglPreDtlsByPhotographDocId(long photographDocId) {
		for (DgfFglPreDtls dgfFglPreDtls :
				findBydgfFglPreDtlsByPhotographDocId(
					photographDocId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgfFglPreDtls);
		}
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where photographDocId = &#63;.
	 *
	 * @param photographDocId the photograph doc ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	@Override
	public int countBydgfFglPreDtlsByPhotographDocId(long photographDocId) {
		FinderPath finderPath =
			_finderPathCountBydgfFglPreDtlsByPhotographDocId;

		Object[] finderArgs = new Object[] {photographDocId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFFGLPREDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLPREDTLSBYPHOTOGRAPHDOCID_PHOTOGRAPHDOCID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(photographDocId);

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
		_FINDER_COLUMN_DGFFGLPREDTLSBYPHOTOGRAPHDOCID_PHOTOGRAPHDOCID_2 =
			"dgfFglPreDtls.photographDocId = ?";

	private FinderPath
		_finderPathWithPaginationFindBydgfFglPreDtlsByOtherReleventDocId;
	private FinderPath
		_finderPathWithoutPaginationFindBydgfFglPreDtlsByOtherReleventDocId;
	private FinderPath _finderPathCountBydgfFglPreDtlsByOtherReleventDocId;

	/**
	 * Returns all the dgf fgl pre dtlses where otherReleventDocId = &#63;.
	 *
	 * @param otherReleventDocId the other relevent doc ID
	 * @return the matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByOtherReleventDocId(
		long otherReleventDocId) {

		return findBydgfFglPreDtlsByOtherReleventDocId(
			otherReleventDocId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses where otherReleventDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param otherReleventDocId the other relevent doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByOtherReleventDocId(
		long otherReleventDocId, int start, int end) {

		return findBydgfFglPreDtlsByOtherReleventDocId(
			otherReleventDocId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where otherReleventDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param otherReleventDocId the other relevent doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByOtherReleventDocId(
		long otherReleventDocId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return findBydgfFglPreDtlsByOtherReleventDocId(
			otherReleventDocId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where otherReleventDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param otherReleventDocId the other relevent doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByOtherReleventDocId(
		long otherReleventDocId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydgfFglPreDtlsByOtherReleventDocId;
				finderArgs = new Object[] {otherReleventDocId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBydgfFglPreDtlsByOtherReleventDocId;
			finderArgs = new Object[] {
				otherReleventDocId, start, end, orderByComparator
			};
		}

		List<DgfFglPreDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfFglPreDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfFglPreDtls dgfFglPreDtls : list) {
					if (otherReleventDocId !=
							dgfFglPreDtls.getOtherReleventDocId()) {

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

			sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLPREDTLSBYOTHERRELEVENTDOCID_OTHERRELEVENTDOCID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(otherReleventDocId);

				list = (List<DgfFglPreDtls>)QueryUtil.list(
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
	 * Returns the first dgf fgl pre dtls in the ordered set where otherReleventDocId = &#63;.
	 *
	 * @param otherReleventDocId the other relevent doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByOtherReleventDocId_First(
			long otherReleventDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls =
			fetchBydgfFglPreDtlsByOtherReleventDocId_First(
				otherReleventDocId, orderByComparator);

		if (dgfFglPreDtls != null) {
			return dgfFglPreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("otherReleventDocId=");
		sb.append(otherReleventDocId);

		sb.append("}");

		throw new NoSuchDgfFglPreDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where otherReleventDocId = &#63;.
	 *
	 * @param otherReleventDocId the other relevent doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByOtherReleventDocId_First(
		long otherReleventDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		List<DgfFglPreDtls> list = findBydgfFglPreDtlsByOtherReleventDocId(
			otherReleventDocId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where otherReleventDocId = &#63;.
	 *
	 * @param otherReleventDocId the other relevent doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByOtherReleventDocId_Last(
			long otherReleventDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls =
			fetchBydgfFglPreDtlsByOtherReleventDocId_Last(
				otherReleventDocId, orderByComparator);

		if (dgfFglPreDtls != null) {
			return dgfFglPreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("otherReleventDocId=");
		sb.append(otherReleventDocId);

		sb.append("}");

		throw new NoSuchDgfFglPreDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where otherReleventDocId = &#63;.
	 *
	 * @param otherReleventDocId the other relevent doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByOtherReleventDocId_Last(
		long otherReleventDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		int count = countBydgfFglPreDtlsByOtherReleventDocId(
			otherReleventDocId);

		if (count == 0) {
			return null;
		}

		List<DgfFglPreDtls> list = findBydgfFglPreDtlsByOtherReleventDocId(
			otherReleventDocId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where otherReleventDocId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param otherReleventDocId the other relevent doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	@Override
	public DgfFglPreDtls[] findBydgfFglPreDtlsByOtherReleventDocId_PrevAndNext(
			long fglPrePrimaryId, long otherReleventDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls = findByPrimaryKey(fglPrePrimaryId);

		Session session = null;

		try {
			session = openSession();

			DgfFglPreDtls[] array = new DgfFglPreDtlsImpl[3];

			array[0] = getBydgfFglPreDtlsByOtherReleventDocId_PrevAndNext(
				session, dgfFglPreDtls, otherReleventDocId, orderByComparator,
				true);

			array[1] = dgfFglPreDtls;

			array[2] = getBydgfFglPreDtlsByOtherReleventDocId_PrevAndNext(
				session, dgfFglPreDtls, otherReleventDocId, orderByComparator,
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

	protected DgfFglPreDtls getBydgfFglPreDtlsByOtherReleventDocId_PrevAndNext(
		Session session, DgfFglPreDtls dgfFglPreDtls, long otherReleventDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

		sb.append(
			_FINDER_COLUMN_DGFFGLPREDTLSBYOTHERRELEVENTDOCID_OTHERRELEVENTDOCID_2);

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
			sb.append(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(otherReleventDocId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfFglPreDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfFglPreDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf fgl pre dtlses where otherReleventDocId = &#63; from the database.
	 *
	 * @param otherReleventDocId the other relevent doc ID
	 */
	@Override
	public void removeBydgfFglPreDtlsByOtherReleventDocId(
		long otherReleventDocId) {

		for (DgfFglPreDtls dgfFglPreDtls :
				findBydgfFglPreDtlsByOtherReleventDocId(
					otherReleventDocId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgfFglPreDtls);
		}
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where otherReleventDocId = &#63;.
	 *
	 * @param otherReleventDocId the other relevent doc ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	@Override
	public int countBydgfFglPreDtlsByOtherReleventDocId(
		long otherReleventDocId) {

		FinderPath finderPath =
			_finderPathCountBydgfFglPreDtlsByOtherReleventDocId;

		Object[] finderArgs = new Object[] {otherReleventDocId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFFGLPREDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLPREDTLSBYOTHERRELEVENTDOCID_OTHERRELEVENTDOCID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(otherReleventDocId);

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
		_FINDER_COLUMN_DGFFGLPREDTLSBYOTHERRELEVENTDOCID_OTHERRELEVENTDOCID_2 =
			"dgfFglPreDtls.otherReleventDocId = ?";

	private FinderPath
		_finderPathWithPaginationFindBydgfFglPreDtlsByElectricExemptionMemoId;
	private FinderPath
		_finderPathWithoutPaginationFindBydgfFglPreDtlsByElectricExemptionMemoId;
	private FinderPath _finderPathCountBydgfFglPreDtlsByElectricExemptionMemoId;

	/**
	 * Returns all the dgf fgl pre dtlses where electricExemptionMemoId = &#63;.
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID
	 * @return the matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByElectricExemptionMemoId(
		long electricExemptionMemoId) {

		return findBydgfFglPreDtlsByElectricExemptionMemoId(
			electricExemptionMemoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses where electricExemptionMemoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByElectricExemptionMemoId(
		long electricExemptionMemoId, int start, int end) {

		return findBydgfFglPreDtlsByElectricExemptionMemoId(
			electricExemptionMemoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where electricExemptionMemoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByElectricExemptionMemoId(
		long electricExemptionMemoId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return findBydgfFglPreDtlsByElectricExemptionMemoId(
			electricExemptionMemoId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where electricExemptionMemoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByElectricExemptionMemoId(
		long electricExemptionMemoId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydgfFglPreDtlsByElectricExemptionMemoId;
				finderArgs = new Object[] {electricExemptionMemoId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBydgfFglPreDtlsByElectricExemptionMemoId;
			finderArgs = new Object[] {
				electricExemptionMemoId, start, end, orderByComparator
			};
		}

		List<DgfFglPreDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfFglPreDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfFglPreDtls dgfFglPreDtls : list) {
					if (electricExemptionMemoId !=
							dgfFglPreDtls.getElectricExemptionMemoId()) {

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

			sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLPREDTLSBYELECTRICEXEMPTIONMEMOID_ELECTRICEXEMPTIONMEMOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(electricExemptionMemoId);

				list = (List<DgfFglPreDtls>)QueryUtil.list(
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
	 * Returns the first dgf fgl pre dtls in the ordered set where electricExemptionMemoId = &#63;.
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByElectricExemptionMemoId_First(
			long electricExemptionMemoId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls =
			fetchBydgfFglPreDtlsByElectricExemptionMemoId_First(
				electricExemptionMemoId, orderByComparator);

		if (dgfFglPreDtls != null) {
			return dgfFglPreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("electricExemptionMemoId=");
		sb.append(electricExemptionMemoId);

		sb.append("}");

		throw new NoSuchDgfFglPreDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where electricExemptionMemoId = &#63;.
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByElectricExemptionMemoId_First(
		long electricExemptionMemoId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		List<DgfFglPreDtls> list = findBydgfFglPreDtlsByElectricExemptionMemoId(
			electricExemptionMemoId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where electricExemptionMemoId = &#63;.
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByElectricExemptionMemoId_Last(
			long electricExemptionMemoId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls =
			fetchBydgfFglPreDtlsByElectricExemptionMemoId_Last(
				electricExemptionMemoId, orderByComparator);

		if (dgfFglPreDtls != null) {
			return dgfFglPreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("electricExemptionMemoId=");
		sb.append(electricExemptionMemoId);

		sb.append("}");

		throw new NoSuchDgfFglPreDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where electricExemptionMemoId = &#63;.
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByElectricExemptionMemoId_Last(
		long electricExemptionMemoId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		int count = countBydgfFglPreDtlsByElectricExemptionMemoId(
			electricExemptionMemoId);

		if (count == 0) {
			return null;
		}

		List<DgfFglPreDtls> list = findBydgfFglPreDtlsByElectricExemptionMemoId(
			electricExemptionMemoId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where electricExemptionMemoId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param electricExemptionMemoId the electric exemption memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	@Override
	public DgfFglPreDtls[]
			findBydgfFglPreDtlsByElectricExemptionMemoId_PrevAndNext(
				long fglPrePrimaryId, long electricExemptionMemoId,
				OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls = findByPrimaryKey(fglPrePrimaryId);

		Session session = null;

		try {
			session = openSession();

			DgfFglPreDtls[] array = new DgfFglPreDtlsImpl[3];

			array[0] = getBydgfFglPreDtlsByElectricExemptionMemoId_PrevAndNext(
				session, dgfFglPreDtls, electricExemptionMemoId,
				orderByComparator, true);

			array[1] = dgfFglPreDtls;

			array[2] = getBydgfFglPreDtlsByElectricExemptionMemoId_PrevAndNext(
				session, dgfFglPreDtls, electricExemptionMemoId,
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

	protected DgfFglPreDtls
		getBydgfFglPreDtlsByElectricExemptionMemoId_PrevAndNext(
			Session session, DgfFglPreDtls dgfFglPreDtls,
			long electricExemptionMemoId,
			OrderByComparator<DgfFglPreDtls> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

		sb.append(
			_FINDER_COLUMN_DGFFGLPREDTLSBYELECTRICEXEMPTIONMEMOID_ELECTRICEXEMPTIONMEMOID_2);

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
			sb.append(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(electricExemptionMemoId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfFglPreDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfFglPreDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf fgl pre dtlses where electricExemptionMemoId = &#63; from the database.
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID
	 */
	@Override
	public void removeBydgfFglPreDtlsByElectricExemptionMemoId(
		long electricExemptionMemoId) {

		for (DgfFglPreDtls dgfFglPreDtls :
				findBydgfFglPreDtlsByElectricExemptionMemoId(
					electricExemptionMemoId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(dgfFglPreDtls);
		}
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where electricExemptionMemoId = &#63;.
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	@Override
	public int countBydgfFglPreDtlsByElectricExemptionMemoId(
		long electricExemptionMemoId) {

		FinderPath finderPath =
			_finderPathCountBydgfFglPreDtlsByElectricExemptionMemoId;

		Object[] finderArgs = new Object[] {electricExemptionMemoId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFFGLPREDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLPREDTLSBYELECTRICEXEMPTIONMEMOID_ELECTRICEXEMPTIONMEMOID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(electricExemptionMemoId);

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
		_FINDER_COLUMN_DGFFGLPREDTLSBYELECTRICEXEMPTIONMEMOID_ELECTRICEXEMPTIONMEMOID_2 =
			"dgfFglPreDtls.electricExemptionMemoId = ?";

	private FinderPath
		_finderPathWithPaginationFindBydgfFglPreDtlsByEnvClrMemoId;
	private FinderPath
		_finderPathWithoutPaginationFindBydgfFglPreDtlsByEnvClrMemoId;
	private FinderPath _finderPathCountBydgfFglPreDtlsByEnvClrMemoId;

	/**
	 * Returns all the dgf fgl pre dtlses where envClrMemoId = &#63;.
	 *
	 * @param envClrMemoId the env clr memo ID
	 * @return the matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByEnvClrMemoId(
		long envClrMemoId) {

		return findBydgfFglPreDtlsByEnvClrMemoId(
			envClrMemoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses where envClrMemoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param envClrMemoId the env clr memo ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByEnvClrMemoId(
		long envClrMemoId, int start, int end) {

		return findBydgfFglPreDtlsByEnvClrMemoId(
			envClrMemoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where envClrMemoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param envClrMemoId the env clr memo ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByEnvClrMemoId(
		long envClrMemoId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return findBydgfFglPreDtlsByEnvClrMemoId(
			envClrMemoId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where envClrMemoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param envClrMemoId the env clr memo ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByEnvClrMemoId(
		long envClrMemoId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydgfFglPreDtlsByEnvClrMemoId;
				finderArgs = new Object[] {envClrMemoId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBydgfFglPreDtlsByEnvClrMemoId;
			finderArgs = new Object[] {
				envClrMemoId, start, end, orderByComparator
			};
		}

		List<DgfFglPreDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfFglPreDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfFglPreDtls dgfFglPreDtls : list) {
					if (envClrMemoId != dgfFglPreDtls.getEnvClrMemoId()) {
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

			sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLPREDTLSBYENVCLRMEMOID_ENVCLRMEMOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(envClrMemoId);

				list = (List<DgfFglPreDtls>)QueryUtil.list(
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
	 * Returns the first dgf fgl pre dtls in the ordered set where envClrMemoId = &#63;.
	 *
	 * @param envClrMemoId the env clr memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByEnvClrMemoId_First(
			long envClrMemoId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls = fetchBydgfFglPreDtlsByEnvClrMemoId_First(
			envClrMemoId, orderByComparator);

		if (dgfFglPreDtls != null) {
			return dgfFglPreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("envClrMemoId=");
		sb.append(envClrMemoId);

		sb.append("}");

		throw new NoSuchDgfFglPreDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where envClrMemoId = &#63;.
	 *
	 * @param envClrMemoId the env clr memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByEnvClrMemoId_First(
		long envClrMemoId, OrderByComparator<DgfFglPreDtls> orderByComparator) {

		List<DgfFglPreDtls> list = findBydgfFglPreDtlsByEnvClrMemoId(
			envClrMemoId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where envClrMemoId = &#63;.
	 *
	 * @param envClrMemoId the env clr memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByEnvClrMemoId_Last(
			long envClrMemoId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls = fetchBydgfFglPreDtlsByEnvClrMemoId_Last(
			envClrMemoId, orderByComparator);

		if (dgfFglPreDtls != null) {
			return dgfFglPreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("envClrMemoId=");
		sb.append(envClrMemoId);

		sb.append("}");

		throw new NoSuchDgfFglPreDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where envClrMemoId = &#63;.
	 *
	 * @param envClrMemoId the env clr memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByEnvClrMemoId_Last(
		long envClrMemoId, OrderByComparator<DgfFglPreDtls> orderByComparator) {

		int count = countBydgfFglPreDtlsByEnvClrMemoId(envClrMemoId);

		if (count == 0) {
			return null;
		}

		List<DgfFglPreDtls> list = findBydgfFglPreDtlsByEnvClrMemoId(
			envClrMemoId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where envClrMemoId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param envClrMemoId the env clr memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	@Override
	public DgfFglPreDtls[] findBydgfFglPreDtlsByEnvClrMemoId_PrevAndNext(
			long fglPrePrimaryId, long envClrMemoId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls = findByPrimaryKey(fglPrePrimaryId);

		Session session = null;

		try {
			session = openSession();

			DgfFglPreDtls[] array = new DgfFglPreDtlsImpl[3];

			array[0] = getBydgfFglPreDtlsByEnvClrMemoId_PrevAndNext(
				session, dgfFglPreDtls, envClrMemoId, orderByComparator, true);

			array[1] = dgfFglPreDtls;

			array[2] = getBydgfFglPreDtlsByEnvClrMemoId_PrevAndNext(
				session, dgfFglPreDtls, envClrMemoId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DgfFglPreDtls getBydgfFglPreDtlsByEnvClrMemoId_PrevAndNext(
		Session session, DgfFglPreDtls dgfFglPreDtls, long envClrMemoId,
		OrderByComparator<DgfFglPreDtls> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

		sb.append(_FINDER_COLUMN_DGFFGLPREDTLSBYENVCLRMEMOID_ENVCLRMEMOID_2);

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
			sb.append(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(envClrMemoId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfFglPreDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfFglPreDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf fgl pre dtlses where envClrMemoId = &#63; from the database.
	 *
	 * @param envClrMemoId the env clr memo ID
	 */
	@Override
	public void removeBydgfFglPreDtlsByEnvClrMemoId(long envClrMemoId) {
		for (DgfFglPreDtls dgfFglPreDtls :
				findBydgfFglPreDtlsByEnvClrMemoId(
					envClrMemoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgfFglPreDtls);
		}
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where envClrMemoId = &#63;.
	 *
	 * @param envClrMemoId the env clr memo ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	@Override
	public int countBydgfFglPreDtlsByEnvClrMemoId(long envClrMemoId) {
		FinderPath finderPath = _finderPathCountBydgfFglPreDtlsByEnvClrMemoId;

		Object[] finderArgs = new Object[] {envClrMemoId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFFGLPREDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLPREDTLSBYENVCLRMEMOID_ENVCLRMEMOID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(envClrMemoId);

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
		_FINDER_COLUMN_DGFFGLPREDTLSBYENVCLRMEMOID_ENVCLRMEMOID_2 =
			"dgfFglPreDtls.envClrMemoId = ?";

	private FinderPath
		_finderPathWithPaginationFindBydgfFglPreDtlsByBstiClrMemoId;
	private FinderPath
		_finderPathWithoutPaginationFindBydgfFglPreDtlsByBstiClrMemoId;
	private FinderPath _finderPathCountBydgfFglPreDtlsByBstiClrMemoId;

	/**
	 * Returns all the dgf fgl pre dtlses where bstiClrMemoId = &#63;.
	 *
	 * @param bstiClrMemoId the bsti clr memo ID
	 * @return the matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByBstiClrMemoId(
		long bstiClrMemoId) {

		return findBydgfFglPreDtlsByBstiClrMemoId(
			bstiClrMemoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses where bstiClrMemoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bstiClrMemoId the bsti clr memo ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByBstiClrMemoId(
		long bstiClrMemoId, int start, int end) {

		return findBydgfFglPreDtlsByBstiClrMemoId(
			bstiClrMemoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where bstiClrMemoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bstiClrMemoId the bsti clr memo ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByBstiClrMemoId(
		long bstiClrMemoId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return findBydgfFglPreDtlsByBstiClrMemoId(
			bstiClrMemoId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where bstiClrMemoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bstiClrMemoId the bsti clr memo ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByBstiClrMemoId(
		long bstiClrMemoId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydgfFglPreDtlsByBstiClrMemoId;
				finderArgs = new Object[] {bstiClrMemoId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBydgfFglPreDtlsByBstiClrMemoId;
			finderArgs = new Object[] {
				bstiClrMemoId, start, end, orderByComparator
			};
		}

		List<DgfFglPreDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfFglPreDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfFglPreDtls dgfFglPreDtls : list) {
					if (bstiClrMemoId != dgfFglPreDtls.getBstiClrMemoId()) {
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

			sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLPREDTLSBYBSTICLRMEMOID_BSTICLRMEMOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(bstiClrMemoId);

				list = (List<DgfFglPreDtls>)QueryUtil.list(
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
	 * Returns the first dgf fgl pre dtls in the ordered set where bstiClrMemoId = &#63;.
	 *
	 * @param bstiClrMemoId the bsti clr memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByBstiClrMemoId_First(
			long bstiClrMemoId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls = fetchBydgfFglPreDtlsByBstiClrMemoId_First(
			bstiClrMemoId, orderByComparator);

		if (dgfFglPreDtls != null) {
			return dgfFglPreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bstiClrMemoId=");
		sb.append(bstiClrMemoId);

		sb.append("}");

		throw new NoSuchDgfFglPreDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where bstiClrMemoId = &#63;.
	 *
	 * @param bstiClrMemoId the bsti clr memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByBstiClrMemoId_First(
		long bstiClrMemoId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		List<DgfFglPreDtls> list = findBydgfFglPreDtlsByBstiClrMemoId(
			bstiClrMemoId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where bstiClrMemoId = &#63;.
	 *
	 * @param bstiClrMemoId the bsti clr memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByBstiClrMemoId_Last(
			long bstiClrMemoId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls = fetchBydgfFglPreDtlsByBstiClrMemoId_Last(
			bstiClrMemoId, orderByComparator);

		if (dgfFglPreDtls != null) {
			return dgfFglPreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bstiClrMemoId=");
		sb.append(bstiClrMemoId);

		sb.append("}");

		throw new NoSuchDgfFglPreDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where bstiClrMemoId = &#63;.
	 *
	 * @param bstiClrMemoId the bsti clr memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByBstiClrMemoId_Last(
		long bstiClrMemoId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		int count = countBydgfFglPreDtlsByBstiClrMemoId(bstiClrMemoId);

		if (count == 0) {
			return null;
		}

		List<DgfFglPreDtls> list = findBydgfFglPreDtlsByBstiClrMemoId(
			bstiClrMemoId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where bstiClrMemoId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param bstiClrMemoId the bsti clr memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	@Override
	public DgfFglPreDtls[] findBydgfFglPreDtlsByBstiClrMemoId_PrevAndNext(
			long fglPrePrimaryId, long bstiClrMemoId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls = findByPrimaryKey(fglPrePrimaryId);

		Session session = null;

		try {
			session = openSession();

			DgfFglPreDtls[] array = new DgfFglPreDtlsImpl[3];

			array[0] = getBydgfFglPreDtlsByBstiClrMemoId_PrevAndNext(
				session, dgfFglPreDtls, bstiClrMemoId, orderByComparator, true);

			array[1] = dgfFglPreDtls;

			array[2] = getBydgfFglPreDtlsByBstiClrMemoId_PrevAndNext(
				session, dgfFglPreDtls, bstiClrMemoId, orderByComparator,
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

	protected DgfFglPreDtls getBydgfFglPreDtlsByBstiClrMemoId_PrevAndNext(
		Session session, DgfFglPreDtls dgfFglPreDtls, long bstiClrMemoId,
		OrderByComparator<DgfFglPreDtls> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

		sb.append(_FINDER_COLUMN_DGFFGLPREDTLSBYBSTICLRMEMOID_BSTICLRMEMOID_2);

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
			sb.append(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(bstiClrMemoId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfFglPreDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfFglPreDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf fgl pre dtlses where bstiClrMemoId = &#63; from the database.
	 *
	 * @param bstiClrMemoId the bsti clr memo ID
	 */
	@Override
	public void removeBydgfFglPreDtlsByBstiClrMemoId(long bstiClrMemoId) {
		for (DgfFglPreDtls dgfFglPreDtls :
				findBydgfFglPreDtlsByBstiClrMemoId(
					bstiClrMemoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgfFglPreDtls);
		}
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where bstiClrMemoId = &#63;.
	 *
	 * @param bstiClrMemoId the bsti clr memo ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	@Override
	public int countBydgfFglPreDtlsByBstiClrMemoId(long bstiClrMemoId) {
		FinderPath finderPath = _finderPathCountBydgfFglPreDtlsByBstiClrMemoId;

		Object[] finderArgs = new Object[] {bstiClrMemoId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFFGLPREDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLPREDTLSBYBSTICLRMEMOID_BSTICLRMEMOID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(bstiClrMemoId);

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
		_FINDER_COLUMN_DGFFGLPREDTLSBYBSTICLRMEMOID_BSTICLRMEMOID_2 =
			"dgfFglPreDtls.bstiClrMemoId = ?";

	private FinderPath
		_finderPathWithPaginationFindBydgfFglPreDtlsByFireLicNumDocId;
	private FinderPath
		_finderPathWithoutPaginationFindBydgfFglPreDtlsByFireLicNumDocId;
	private FinderPath _finderPathCountBydgfFglPreDtlsByFireLicNumDocId;

	/**
	 * Returns all the dgf fgl pre dtlses where fireLicNumDocId = &#63;.
	 *
	 * @param fireLicNumDocId the fire lic num doc ID
	 * @return the matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByFireLicNumDocId(
		long fireLicNumDocId) {

		return findBydgfFglPreDtlsByFireLicNumDocId(
			fireLicNumDocId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses where fireLicNumDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param fireLicNumDocId the fire lic num doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByFireLicNumDocId(
		long fireLicNumDocId, int start, int end) {

		return findBydgfFglPreDtlsByFireLicNumDocId(
			fireLicNumDocId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where fireLicNumDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param fireLicNumDocId the fire lic num doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByFireLicNumDocId(
		long fireLicNumDocId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return findBydgfFglPreDtlsByFireLicNumDocId(
			fireLicNumDocId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where fireLicNumDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param fireLicNumDocId the fire lic num doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findBydgfFglPreDtlsByFireLicNumDocId(
		long fireLicNumDocId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydgfFglPreDtlsByFireLicNumDocId;
				finderArgs = new Object[] {fireLicNumDocId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBydgfFglPreDtlsByFireLicNumDocId;
			finderArgs = new Object[] {
				fireLicNumDocId, start, end, orderByComparator
			};
		}

		List<DgfFglPreDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfFglPreDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfFglPreDtls dgfFglPreDtls : list) {
					if (fireLicNumDocId != dgfFglPreDtls.getFireLicNumDocId()) {
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

			sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLPREDTLSBYFIRELICNUMDOCID_FIRELICNUMDOCID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fireLicNumDocId);

				list = (List<DgfFglPreDtls>)QueryUtil.list(
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
	 * Returns the first dgf fgl pre dtls in the ordered set where fireLicNumDocId = &#63;.
	 *
	 * @param fireLicNumDocId the fire lic num doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByFireLicNumDocId_First(
			long fireLicNumDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls =
			fetchBydgfFglPreDtlsByFireLicNumDocId_First(
				fireLicNumDocId, orderByComparator);

		if (dgfFglPreDtls != null) {
			return dgfFglPreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fireLicNumDocId=");
		sb.append(fireLicNumDocId);

		sb.append("}");

		throw new NoSuchDgfFglPreDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where fireLicNumDocId = &#63;.
	 *
	 * @param fireLicNumDocId the fire lic num doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByFireLicNumDocId_First(
		long fireLicNumDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		List<DgfFglPreDtls> list = findBydgfFglPreDtlsByFireLicNumDocId(
			fireLicNumDocId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where fireLicNumDocId = &#63;.
	 *
	 * @param fireLicNumDocId the fire lic num doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls findBydgfFglPreDtlsByFireLicNumDocId_Last(
			long fireLicNumDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls =
			fetchBydgfFglPreDtlsByFireLicNumDocId_Last(
				fireLicNumDocId, orderByComparator);

		if (dgfFglPreDtls != null) {
			return dgfFglPreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fireLicNumDocId=");
		sb.append(fireLicNumDocId);

		sb.append("}");

		throw new NoSuchDgfFglPreDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where fireLicNumDocId = &#63;.
	 *
	 * @param fireLicNumDocId the fire lic num doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	@Override
	public DgfFglPreDtls fetchBydgfFglPreDtlsByFireLicNumDocId_Last(
		long fireLicNumDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		int count = countBydgfFglPreDtlsByFireLicNumDocId(fireLicNumDocId);

		if (count == 0) {
			return null;
		}

		List<DgfFglPreDtls> list = findBydgfFglPreDtlsByFireLicNumDocId(
			fireLicNumDocId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where fireLicNumDocId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param fireLicNumDocId the fire lic num doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	@Override
	public DgfFglPreDtls[] findBydgfFglPreDtlsByFireLicNumDocId_PrevAndNext(
			long fglPrePrimaryId, long fireLicNumDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls = findByPrimaryKey(fglPrePrimaryId);

		Session session = null;

		try {
			session = openSession();

			DgfFglPreDtls[] array = new DgfFglPreDtlsImpl[3];

			array[0] = getBydgfFglPreDtlsByFireLicNumDocId_PrevAndNext(
				session, dgfFglPreDtls, fireLicNumDocId, orderByComparator,
				true);

			array[1] = dgfFglPreDtls;

			array[2] = getBydgfFglPreDtlsByFireLicNumDocId_PrevAndNext(
				session, dgfFglPreDtls, fireLicNumDocId, orderByComparator,
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

	protected DgfFglPreDtls getBydgfFglPreDtlsByFireLicNumDocId_PrevAndNext(
		Session session, DgfFglPreDtls dgfFglPreDtls, long fireLicNumDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DGFFGLPREDTLS_WHERE);

		sb.append(
			_FINDER_COLUMN_DGFFGLPREDTLSBYFIRELICNUMDOCID_FIRELICNUMDOCID_2);

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
			sb.append(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(fireLicNumDocId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfFglPreDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfFglPreDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf fgl pre dtlses where fireLicNumDocId = &#63; from the database.
	 *
	 * @param fireLicNumDocId the fire lic num doc ID
	 */
	@Override
	public void removeBydgfFglPreDtlsByFireLicNumDocId(long fireLicNumDocId) {
		for (DgfFglPreDtls dgfFglPreDtls :
				findBydgfFglPreDtlsByFireLicNumDocId(
					fireLicNumDocId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgfFglPreDtls);
		}
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where fireLicNumDocId = &#63;.
	 *
	 * @param fireLicNumDocId the fire lic num doc ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	@Override
	public int countBydgfFglPreDtlsByFireLicNumDocId(long fireLicNumDocId) {
		FinderPath finderPath =
			_finderPathCountBydgfFglPreDtlsByFireLicNumDocId;

		Object[] finderArgs = new Object[] {fireLicNumDocId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFFGLPREDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLPREDTLSBYFIRELICNUMDOCID_FIRELICNUMDOCID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fireLicNumDocId);

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
		_FINDER_COLUMN_DGFFGLPREDTLSBYFIRELICNUMDOCID_FIRELICNUMDOCID_2 =
			"dgfFglPreDtls.fireLicNumDocId = ?";

	public DgfFglPreDtlsPersistenceImpl() {
		setModelClass(DgfFglPreDtls.class);

		setModelImplClass(DgfFglPreDtlsImpl.class);
		setModelPKClass(long.class);

		setTable(DgfFglPreDtlsTable.INSTANCE);
	}

	/**
	 * Caches the dgf fgl pre dtls in the entity cache if it is enabled.
	 *
	 * @param dgfFglPreDtls the dgf fgl pre dtls
	 */
	@Override
	public void cacheResult(DgfFglPreDtls dgfFglPreDtls) {
		entityCache.putResult(
			DgfFglPreDtlsImpl.class, dgfFglPreDtls.getPrimaryKey(),
			dgfFglPreDtls);

		finderCache.putResult(
			_finderPathFetchBydgfFglPreDtlsByFglApplicationNo,
			new Object[] {dgfFglPreDtls.getFglApplicationNo()}, dgfFglPreDtls);

		finderCache.putResult(
			_finderPathFetchByDgfFglPreDtlsByNID,
			new Object[] {dgfFglPreDtls.getNationalId()}, dgfFglPreDtls);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dgf fgl pre dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfFglPreDtlses the dgf fgl pre dtlses
	 */
	@Override
	public void cacheResult(List<DgfFglPreDtls> dgfFglPreDtlses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgfFglPreDtlses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DgfFglPreDtls dgfFglPreDtls : dgfFglPreDtlses) {
			if (entityCache.getResult(
					DgfFglPreDtlsImpl.class, dgfFglPreDtls.getPrimaryKey()) ==
						null) {

				cacheResult(dgfFglPreDtls);
			}
		}
	}

	/**
	 * Clears the cache for all dgf fgl pre dtlses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DgfFglPreDtlsImpl.class);

		finderCache.clearCache(DgfFglPreDtlsImpl.class);
	}

	/**
	 * Clears the cache for the dgf fgl pre dtls.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DgfFglPreDtls dgfFglPreDtls) {
		entityCache.removeResult(DgfFglPreDtlsImpl.class, dgfFglPreDtls);
	}

	@Override
	public void clearCache(List<DgfFglPreDtls> dgfFglPreDtlses) {
		for (DgfFglPreDtls dgfFglPreDtls : dgfFglPreDtlses) {
			entityCache.removeResult(DgfFglPreDtlsImpl.class, dgfFglPreDtls);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DgfFglPreDtlsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DgfFglPreDtlsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DgfFglPreDtlsModelImpl dgfFglPreDtlsModelImpl) {

		Object[] args = new Object[] {
			dgfFglPreDtlsModelImpl.getFglApplicationNo()
		};

		finderCache.putResult(
			_finderPathCountBydgfFglPreDtlsByFglApplicationNo, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchBydgfFglPreDtlsByFglApplicationNo, args,
			dgfFglPreDtlsModelImpl);

		args = new Object[] {dgfFglPreDtlsModelImpl.getNationalId()};

		finderCache.putResult(
			_finderPathCountByDgfFglPreDtlsByNID, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDgfFglPreDtlsByNID, args, dgfFglPreDtlsModelImpl);
	}

	/**
	 * Creates a new dgf fgl pre dtls with the primary key. Does not add the dgf fgl pre dtls to the database.
	 *
	 * @param fglPrePrimaryId the primary key for the new dgf fgl pre dtls
	 * @return the new dgf fgl pre dtls
	 */
	@Override
	public DgfFglPreDtls create(long fglPrePrimaryId) {
		DgfFglPreDtls dgfFglPreDtls = new DgfFglPreDtlsImpl();

		dgfFglPreDtls.setNew(true);
		dgfFglPreDtls.setPrimaryKey(fglPrePrimaryId);

		dgfFglPreDtls.setCompanyId(CompanyThreadLocal.getCompanyId());

		return dgfFglPreDtls;
	}

	/**
	 * Removes the dgf fgl pre dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fglPrePrimaryId the primary key of the dgf fgl pre dtls
	 * @return the dgf fgl pre dtls that was removed
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	@Override
	public DgfFglPreDtls remove(long fglPrePrimaryId)
		throws NoSuchDgfFglPreDtlsException {

		return remove((Serializable)fglPrePrimaryId);
	}

	/**
	 * Removes the dgf fgl pre dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dgf fgl pre dtls
	 * @return the dgf fgl pre dtls that was removed
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	@Override
	public DgfFglPreDtls remove(Serializable primaryKey)
		throws NoSuchDgfFglPreDtlsException {

		Session session = null;

		try {
			session = openSession();

			DgfFglPreDtls dgfFglPreDtls = (DgfFglPreDtls)session.get(
				DgfFglPreDtlsImpl.class, primaryKey);

			if (dgfFglPreDtls == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDgfFglPreDtlsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgfFglPreDtls);
		}
		catch (NoSuchDgfFglPreDtlsException noSuchEntityException) {
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
	protected DgfFglPreDtls removeImpl(DgfFglPreDtls dgfFglPreDtls) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgfFglPreDtls)) {
				dgfFglPreDtls = (DgfFglPreDtls)session.get(
					DgfFglPreDtlsImpl.class, dgfFglPreDtls.getPrimaryKeyObj());
			}

			if (dgfFglPreDtls != null) {
				session.delete(dgfFglPreDtls);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgfFglPreDtls != null) {
			clearCache(dgfFglPreDtls);
		}

		return dgfFglPreDtls;
	}

	@Override
	public DgfFglPreDtls updateImpl(DgfFglPreDtls dgfFglPreDtls) {
		boolean isNew = dgfFglPreDtls.isNew();

		if (!(dgfFglPreDtls instanceof DgfFglPreDtlsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dgfFglPreDtls.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dgfFglPreDtls);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgfFglPreDtls proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DgfFglPreDtls implementation " +
					dgfFglPreDtls.getClass());
		}

		DgfFglPreDtlsModelImpl dgfFglPreDtlsModelImpl =
			(DgfFglPreDtlsModelImpl)dgfFglPreDtls;

		if (!dgfFglPreDtlsModelImpl.hasSetModifiedDate()) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				dgfFglPreDtls.setModifiedDate(date);
			}
			else {
				dgfFglPreDtls.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgfFglPreDtls);
			}
			else {
				dgfFglPreDtls = (DgfFglPreDtls)session.merge(dgfFglPreDtls);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DgfFglPreDtlsImpl.class, dgfFglPreDtlsModelImpl, false, true);

		cacheUniqueFindersCache(dgfFglPreDtlsModelImpl);

		if (isNew) {
			dgfFglPreDtls.setNew(false);
		}

		dgfFglPreDtls.resetOriginalValues();

		return dgfFglPreDtls;
	}

	/**
	 * Returns the dgf fgl pre dtls with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dgf fgl pre dtls
	 * @return the dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	@Override
	public DgfFglPreDtls findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDgfFglPreDtlsException {

		DgfFglPreDtls dgfFglPreDtls = fetchByPrimaryKey(primaryKey);

		if (dgfFglPreDtls == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDgfFglPreDtlsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgfFglPreDtls;
	}

	/**
	 * Returns the dgf fgl pre dtls with the primary key or throws a <code>NoSuchDgfFglPreDtlsException</code> if it could not be found.
	 *
	 * @param fglPrePrimaryId the primary key of the dgf fgl pre dtls
	 * @return the dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	@Override
	public DgfFglPreDtls findByPrimaryKey(long fglPrePrimaryId)
		throws NoSuchDgfFglPreDtlsException {

		return findByPrimaryKey((Serializable)fglPrePrimaryId);
	}

	/**
	 * Returns the dgf fgl pre dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fglPrePrimaryId the primary key of the dgf fgl pre dtls
	 * @return the dgf fgl pre dtls, or <code>null</code> if a dgf fgl pre dtls with the primary key could not be found
	 */
	@Override
	public DgfFglPreDtls fetchByPrimaryKey(long fglPrePrimaryId) {
		return fetchByPrimaryKey((Serializable)fglPrePrimaryId);
	}

	/**
	 * Returns all the dgf fgl pre dtlses.
	 *
	 * @return the dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findAll(
		int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf fgl pre dtlses
	 */
	@Override
	public List<DgfFglPreDtls> findAll(
		int start, int end, OrderByComparator<DgfFglPreDtls> orderByComparator,
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

		List<DgfFglPreDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfFglPreDtls>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFFGLPREDTLS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFFGLPREDTLS;

				sql = sql.concat(DgfFglPreDtlsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DgfFglPreDtls>)QueryUtil.list(
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
	 * Removes all the dgf fgl pre dtlses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DgfFglPreDtls dgfFglPreDtls : findAll()) {
			remove(dgfFglPreDtls);
		}
	}

	/**
	 * Returns the number of dgf fgl pre dtlses.
	 *
	 * @return the number of dgf fgl pre dtlses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DGFFGLPREDTLS);

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
		return "fglPrePrimaryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DGFFGLPREDTLS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DgfFglPreDtlsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dgf fgl pre dtls persistence.
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

		_finderPathFetchBydgfFglPreDtlsByFglApplicationNo = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBydgfFglPreDtlsByFglApplicationNo",
			new String[] {String.class.getName()},
			new String[] {"fglApplicationNo"}, true);

		_finderPathCountBydgfFglPreDtlsByFglApplicationNo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfFglPreDtlsByFglApplicationNo",
			new String[] {String.class.getName()},
			new String[] {"fglApplicationNo"}, false);

		_finderPathWithPaginationFindBydgfFglPreDtlsByNationalId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBydgfFglPreDtlsByNationalId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"nationalId"}, true);

		_finderPathWithoutPaginationFindBydgfFglPreDtlsByNationalId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydgfFglPreDtlsByNationalId",
				new String[] {Long.class.getName()},
				new String[] {"nationalId"}, true);

		_finderPathCountBydgfFglPreDtlsByNationalId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfFglPreDtlsByNationalId",
			new String[] {Long.class.getName()}, new String[] {"nationalId"},
			false);

		_finderPathFetchByDgfFglPreDtlsByNID = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDgfFglPreDtlsByNID",
			new String[] {Long.class.getName()}, new String[] {"nationalId"},
			true);

		_finderPathCountByDgfFglPreDtlsByNID = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDgfFglPreDtlsByNID", new String[] {Long.class.getName()},
			new String[] {"nationalId"}, false);

		_finderPathWithPaginationFindBydgfFglPreDtlsByPresentAddrId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBydgfFglPreDtlsByPresentAddrId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"presentAddrId"}, true);

		_finderPathWithoutPaginationFindBydgfFglPreDtlsByPresentAddrId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydgfFglPreDtlsByPresentAddrId",
				new String[] {Long.class.getName()},
				new String[] {"presentAddrId"}, true);

		_finderPathCountBydgfFglPreDtlsByPresentAddrId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfFglPreDtlsByPresentAddrId",
			new String[] {Long.class.getName()}, new String[] {"presentAddrId"},
			false);

		_finderPathWithPaginationFindBydgfFglPreDtlsByBussinessAddrId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBydgfFglPreDtlsByBussinessAddrId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"bussinessAddrId"}, true);

		_finderPathWithoutPaginationFindBydgfFglPreDtlsByBussinessAddrId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydgfFglPreDtlsByBussinessAddrId",
				new String[] {Long.class.getName()},
				new String[] {"bussinessAddrId"}, true);

		_finderPathCountBydgfFglPreDtlsByBussinessAddrId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfFglPreDtlsByBussinessAddrId",
			new String[] {Long.class.getName()},
			new String[] {"bussinessAddrId"}, false);

		_finderPathWithPaginationFindBydgfFglPreDtlsByTradeLicenseDocId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBydgfFglPreDtlsByTradeLicenseDocId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"tradeLicenseDocId"}, true);

		_finderPathWithoutPaginationFindBydgfFglPreDtlsByTradeLicenseDocId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydgfFglPreDtlsByTradeLicenseDocId",
				new String[] {Long.class.getName()},
				new String[] {"tradeLicenseDocId"}, true);

		_finderPathCountBydgfFglPreDtlsByTradeLicenseDocId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfFglPreDtlsByTradeLicenseDocId",
			new String[] {Long.class.getName()},
			new String[] {"tradeLicenseDocId"}, false);

		_finderPathWithPaginationFindBydgfFglPreDtlsByBussIdentfctDocId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBydgfFglPreDtlsByBussIdentfctDocId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"bussIdentfctDocId"}, true);

		_finderPathWithoutPaginationFindBydgfFglPreDtlsByBussIdentfctDocId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydgfFglPreDtlsByBussIdentfctDocId",
				new String[] {Long.class.getName()},
				new String[] {"bussIdentfctDocId"}, true);

		_finderPathCountBydgfFglPreDtlsByBussIdentfctDocId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfFglPreDtlsByBussIdentfctDocId",
			new String[] {Long.class.getName()},
			new String[] {"bussIdentfctDocId"}, false);

		_finderPathWithPaginationFindBydgfFglPreDtlsByTaxIdentfctDocId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBydgfFglPreDtlsByTaxIdentfctDocId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"taxIdentfctDocId"}, true);

		_finderPathWithoutPaginationFindBydgfFglPreDtlsByTaxIdentfctDocId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydgfFglPreDtlsByTaxIdentfctDocId",
				new String[] {Long.class.getName()},
				new String[] {"taxIdentfctDocId"}, true);

		_finderPathCountBydgfFglPreDtlsByTaxIdentfctDocId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfFglPreDtlsByTaxIdentfctDocId",
			new String[] {Long.class.getName()},
			new String[] {"taxIdentfctDocId"}, false);

		_finderPathWithPaginationFindBydgfFglPreDtlsByBnkStatmtDocId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBydgfFglPreDtlsByBnkStatmtDocId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"bnkStatmtDocId"}, true);

		_finderPathWithoutPaginationFindBydgfFglPreDtlsByBnkStatmtDocId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydgfFglPreDtlsByBnkStatmtDocId",
				new String[] {Long.class.getName()},
				new String[] {"bnkStatmtDocId"}, true);

		_finderPathCountBydgfFglPreDtlsByBnkStatmtDocId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfFglPreDtlsByBnkStatmtDocId",
			new String[] {Long.class.getName()},
			new String[] {"bnkStatmtDocId"}, false);

		_finderPathWithPaginationFindBydgfFglPreDtlsByPaymentChallanId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBydgfFglPreDtlsByPaymentChallanId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"paymentChallanId"}, true);

		_finderPathWithoutPaginationFindBydgfFglPreDtlsByPaymentChallanId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydgfFglPreDtlsByPaymentChallanId",
				new String[] {Long.class.getName()},
				new String[] {"paymentChallanId"}, true);

		_finderPathCountBydgfFglPreDtlsByPaymentChallanId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfFglPreDtlsByPaymentChallanId",
			new String[] {Long.class.getName()},
			new String[] {"paymentChallanId"}, false);

		_finderPathWithPaginationFindBydgfFglPreDtlsByDuplicateLicenseReasonId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBydgfFglPreDtlsByDuplicateLicenseReasonId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"duplicateLicenseReasonId"}, true);

		_finderPathWithoutPaginationFindBydgfFglPreDtlsByDuplicateLicenseReasonId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydgfFglPreDtlsByDuplicateLicenseReasonId",
				new String[] {Long.class.getName()},
				new String[] {"duplicateLicenseReasonId"}, true);

		_finderPathCountBydgfFglPreDtlsByDuplicateLicenseReasonId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countBydgfFglPreDtlsByDuplicateLicenseReasonId",
				new String[] {Long.class.getName()},
				new String[] {"duplicateLicenseReasonId"}, false);

		_finderPathWithPaginationFindBydgfFglPreDtlsByPhotographDocId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBydgfFglPreDtlsByPhotographDocId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"photographDocId"}, true);

		_finderPathWithoutPaginationFindBydgfFglPreDtlsByPhotographDocId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydgfFglPreDtlsByPhotographDocId",
				new String[] {Long.class.getName()},
				new String[] {"photographDocId"}, true);

		_finderPathCountBydgfFglPreDtlsByPhotographDocId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfFglPreDtlsByPhotographDocId",
			new String[] {Long.class.getName()},
			new String[] {"photographDocId"}, false);

		_finderPathWithPaginationFindBydgfFglPreDtlsByOtherReleventDocId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBydgfFglPreDtlsByOtherReleventDocId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"otherReleventDocId"}, true);

		_finderPathWithoutPaginationFindBydgfFglPreDtlsByOtherReleventDocId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydgfFglPreDtlsByOtherReleventDocId",
				new String[] {Long.class.getName()},
				new String[] {"otherReleventDocId"}, true);

		_finderPathCountBydgfFglPreDtlsByOtherReleventDocId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfFglPreDtlsByOtherReleventDocId",
			new String[] {Long.class.getName()},
			new String[] {"otherReleventDocId"}, false);

		_finderPathWithPaginationFindBydgfFglPreDtlsByElectricExemptionMemoId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBydgfFglPreDtlsByElectricExemptionMemoId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"electricExemptionMemoId"}, true);

		_finderPathWithoutPaginationFindBydgfFglPreDtlsByElectricExemptionMemoId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydgfFglPreDtlsByElectricExemptionMemoId",
				new String[] {Long.class.getName()},
				new String[] {"electricExemptionMemoId"}, true);

		_finderPathCountBydgfFglPreDtlsByElectricExemptionMemoId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countBydgfFglPreDtlsByElectricExemptionMemoId",
				new String[] {Long.class.getName()},
				new String[] {"electricExemptionMemoId"}, false);

		_finderPathWithPaginationFindBydgfFglPreDtlsByEnvClrMemoId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBydgfFglPreDtlsByEnvClrMemoId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"envClrMemoId"}, true);

		_finderPathWithoutPaginationFindBydgfFglPreDtlsByEnvClrMemoId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydgfFglPreDtlsByEnvClrMemoId",
				new String[] {Long.class.getName()},
				new String[] {"envClrMemoId"}, true);

		_finderPathCountBydgfFglPreDtlsByEnvClrMemoId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfFglPreDtlsByEnvClrMemoId",
			new String[] {Long.class.getName()}, new String[] {"envClrMemoId"},
			false);

		_finderPathWithPaginationFindBydgfFglPreDtlsByBstiClrMemoId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBydgfFglPreDtlsByBstiClrMemoId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"bstiClrMemoId"}, true);

		_finderPathWithoutPaginationFindBydgfFglPreDtlsByBstiClrMemoId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydgfFglPreDtlsByBstiClrMemoId",
				new String[] {Long.class.getName()},
				new String[] {"bstiClrMemoId"}, true);

		_finderPathCountBydgfFglPreDtlsByBstiClrMemoId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfFglPreDtlsByBstiClrMemoId",
			new String[] {Long.class.getName()}, new String[] {"bstiClrMemoId"},
			false);

		_finderPathWithPaginationFindBydgfFglPreDtlsByFireLicNumDocId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBydgfFglPreDtlsByFireLicNumDocId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"fireLicNumDocId"}, true);

		_finderPathWithoutPaginationFindBydgfFglPreDtlsByFireLicNumDocId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydgfFglPreDtlsByFireLicNumDocId",
				new String[] {Long.class.getName()},
				new String[] {"fireLicNumDocId"}, true);

		_finderPathCountBydgfFglPreDtlsByFireLicNumDocId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfFglPreDtlsByFireLicNumDocId",
			new String[] {Long.class.getName()},
			new String[] {"fireLicNumDocId"}, false);

		_setDgfFglPreDtlsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDgfFglPreDtlsUtilPersistence(null);

		entityCache.removeCache(DgfFglPreDtlsImpl.class.getName());
	}

	private void _setDgfFglPreDtlsUtilPersistence(
		DgfFglPreDtlsPersistence dgfFglPreDtlsPersistence) {

		try {
			Field field = DgfFglPreDtlsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dgfFglPreDtlsPersistence);
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

	private static final String _SQL_SELECT_DGFFGLPREDTLS =
		"SELECT dgfFglPreDtls FROM DgfFglPreDtls dgfFglPreDtls";

	private static final String _SQL_SELECT_DGFFGLPREDTLS_WHERE =
		"SELECT dgfFglPreDtls FROM DgfFglPreDtls dgfFglPreDtls WHERE ";

	private static final String _SQL_COUNT_DGFFGLPREDTLS =
		"SELECT COUNT(dgfFglPreDtls) FROM DgfFglPreDtls dgfFglPreDtls";

	private static final String _SQL_COUNT_DGFFGLPREDTLS_WHERE =
		"SELECT COUNT(dgfFglPreDtls) FROM DgfFglPreDtls dgfFglPreDtls WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dgfFglPreDtls.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DgfFglPreDtls exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DgfFglPreDtls exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DgfFglPreDtlsPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}