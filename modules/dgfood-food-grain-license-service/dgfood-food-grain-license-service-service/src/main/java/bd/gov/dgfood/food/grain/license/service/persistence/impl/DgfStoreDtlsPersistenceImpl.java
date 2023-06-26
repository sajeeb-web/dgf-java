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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfStoreDtlsException;
import bd.gov.dgfood.food.grain.license.model.DgfStoreDtls;
import bd.gov.dgfood.food.grain.license.model.DgfStoreDtlsTable;
import bd.gov.dgfood.food.grain.license.model.impl.DgfStoreDtlsImpl;
import bd.gov.dgfood.food.grain.license.model.impl.DgfStoreDtlsModelImpl;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfStoreDtlsPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfStoreDtlsUtil;
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
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the dgf store dtls service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DgfStoreDtlsPersistence.class)
public class DgfStoreDtlsPersistenceImpl
	extends BasePersistenceImpl<DgfStoreDtls>
	implements DgfStoreDtlsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DgfStoreDtlsUtil</code> to access the dgf store dtls persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DgfStoreDtlsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByDgfStoreDtlsFindByType;
	private FinderPath _finderPathCountByDgfStoreDtlsFindByType;

	/**
	 * Returns the dgf store dtls where type = &#63; or throws a <code>NoSuchDgfStoreDtlsException</code> if it could not be found.
	 *
	 * @param type the type
	 * @return the matching dgf store dtls
	 * @throws NoSuchDgfStoreDtlsException if a matching dgf store dtls could not be found
	 */
	@Override
	public DgfStoreDtls findByDgfStoreDtlsFindByType(String type)
		throws NoSuchDgfStoreDtlsException {

		DgfStoreDtls dgfStoreDtls = fetchByDgfStoreDtlsFindByType(type);

		if (dgfStoreDtls == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("type=");
			sb.append(type);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfStoreDtlsException(sb.toString());
		}

		return dgfStoreDtls;
	}

	/**
	 * Returns the dgf store dtls where type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param type the type
	 * @return the matching dgf store dtls, or <code>null</code> if a matching dgf store dtls could not be found
	 */
	@Override
	public DgfStoreDtls fetchByDgfStoreDtlsFindByType(String type) {
		return fetchByDgfStoreDtlsFindByType(type, true);
	}

	/**
	 * Returns the dgf store dtls where type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf store dtls, or <code>null</code> if a matching dgf store dtls could not be found
	 */
	@Override
	public DgfStoreDtls fetchByDgfStoreDtlsFindByType(
		String type, boolean useFinderCache) {

		type = Objects.toString(type, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {type};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDgfStoreDtlsFindByType, finderArgs, this);
		}

		if (result instanceof DgfStoreDtls) {
			DgfStoreDtls dgfStoreDtls = (DgfStoreDtls)result;

			if (!Objects.equals(type, dgfStoreDtls.getType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DGFSTOREDTLS_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_DGFSTOREDTLSFINDBYTYPE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_DGFSTOREDTLSFINDBYTYPE_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindType) {
					queryPos.add(type);
				}

				List<DgfStoreDtls> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDgfStoreDtlsFindByType,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {type};
							}

							_log.warn(
								"DgfStoreDtlsPersistenceImpl.fetchByDgfStoreDtlsFindByType(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DgfStoreDtls dgfStoreDtls = list.get(0);

					result = dgfStoreDtls;

					cacheResult(dgfStoreDtls);
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
			return (DgfStoreDtls)result;
		}
	}

	/**
	 * Removes the dgf store dtls where type = &#63; from the database.
	 *
	 * @param type the type
	 * @return the dgf store dtls that was removed
	 */
	@Override
	public DgfStoreDtls removeByDgfStoreDtlsFindByType(String type)
		throws NoSuchDgfStoreDtlsException {

		DgfStoreDtls dgfStoreDtls = findByDgfStoreDtlsFindByType(type);

		return remove(dgfStoreDtls);
	}

	/**
	 * Returns the number of dgf store dtlses where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching dgf store dtlses
	 */
	@Override
	public int countByDgfStoreDtlsFindByType(String type) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByDgfStoreDtlsFindByType;

		Object[] finderArgs = new Object[] {type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFSTOREDTLS_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_DGFSTOREDTLSFINDBYTYPE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_DGFSTOREDTLSFINDBYTYPE_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindType) {
					queryPos.add(type);
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

	private static final String _FINDER_COLUMN_DGFSTOREDTLSFINDBYTYPE_TYPE_2 =
		"dgfStoreDtls.type = ?";

	private static final String _FINDER_COLUMN_DGFSTOREDTLSFINDBYTYPE_TYPE_3 =
		"(dgfStoreDtls.type IS NULL OR dgfStoreDtls.type = '')";

	private FinderPath _finderPathFetchByDgfStoreDtlsFindByNid;
	private FinderPath _finderPathCountByDgfStoreDtlsFindByNid;

	/**
	 * Returns the dgf store dtls where nationalId = &#63; or throws a <code>NoSuchDgfStoreDtlsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf store dtls
	 * @throws NoSuchDgfStoreDtlsException if a matching dgf store dtls could not be found
	 */
	@Override
	public DgfStoreDtls findByDgfStoreDtlsFindByNid(String nationalId)
		throws NoSuchDgfStoreDtlsException {

		DgfStoreDtls dgfStoreDtls = fetchByDgfStoreDtlsFindByNid(nationalId);

		if (dgfStoreDtls == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("nationalId=");
			sb.append(nationalId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfStoreDtlsException(sb.toString());
		}

		return dgfStoreDtls;
	}

	/**
	 * Returns the dgf store dtls where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf store dtls, or <code>null</code> if a matching dgf store dtls could not be found
	 */
	@Override
	public DgfStoreDtls fetchByDgfStoreDtlsFindByNid(String nationalId) {
		return fetchByDgfStoreDtlsFindByNid(nationalId, true);
	}

	/**
	 * Returns the dgf store dtls where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf store dtls, or <code>null</code> if a matching dgf store dtls could not be found
	 */
	@Override
	public DgfStoreDtls fetchByDgfStoreDtlsFindByNid(
		String nationalId, boolean useFinderCache) {

		nationalId = Objects.toString(nationalId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {nationalId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDgfStoreDtlsFindByNid, finderArgs, this);
		}

		if (result instanceof DgfStoreDtls) {
			DgfStoreDtls dgfStoreDtls = (DgfStoreDtls)result;

			if (!Objects.equals(nationalId, dgfStoreDtls.getNationalId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DGFSTOREDTLS_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_DGFSTOREDTLSFINDBYNID_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(_FINDER_COLUMN_DGFSTOREDTLSFINDBYNID_NATIONALID_2);
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

				List<DgfStoreDtls> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDgfStoreDtlsFindByNid, finderArgs,
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
								"DgfStoreDtlsPersistenceImpl.fetchByDgfStoreDtlsFindByNid(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DgfStoreDtls dgfStoreDtls = list.get(0);

					result = dgfStoreDtls;

					cacheResult(dgfStoreDtls);
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
			return (DgfStoreDtls)result;
		}
	}

	/**
	 * Removes the dgf store dtls where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the dgf store dtls that was removed
	 */
	@Override
	public DgfStoreDtls removeByDgfStoreDtlsFindByNid(String nationalId)
		throws NoSuchDgfStoreDtlsException {

		DgfStoreDtls dgfStoreDtls = findByDgfStoreDtlsFindByNid(nationalId);

		return remove(dgfStoreDtls);
	}

	/**
	 * Returns the number of dgf store dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf store dtlses
	 */
	@Override
	public int countByDgfStoreDtlsFindByNid(String nationalId) {
		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = _finderPathCountByDgfStoreDtlsFindByNid;

		Object[] finderArgs = new Object[] {nationalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFSTOREDTLS_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_DGFSTOREDTLSFINDBYNID_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(_FINDER_COLUMN_DGFSTOREDTLSFINDBYNID_NATIONALID_2);
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
		_FINDER_COLUMN_DGFSTOREDTLSFINDBYNID_NATIONALID_2 =
			"dgfStoreDtls.nationalId = ?";

	private static final String
		_FINDER_COLUMN_DGFSTOREDTLSFINDBYNID_NATIONALID_3 =
			"(dgfStoreDtls.nationalId IS NULL OR dgfStoreDtls.nationalId = '')";

	private FinderPath
		_finderPathWithPaginationFindByDgfStoreDtlsListFindByType;
	private FinderPath
		_finderPathWithoutPaginationFindByDgfStoreDtlsListFindByType;
	private FinderPath _finderPathCountByDgfStoreDtlsListFindByType;

	/**
	 * Returns all the dgf store dtlses where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching dgf store dtlses
	 */
	@Override
	public List<DgfStoreDtls> findByDgfStoreDtlsListFindByType(String type) {
		return findByDgfStoreDtlsListFindByType(
			type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf store dtlses where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfStoreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of dgf store dtlses
	 * @param end the upper bound of the range of dgf store dtlses (not inclusive)
	 * @return the range of matching dgf store dtlses
	 */
	@Override
	public List<DgfStoreDtls> findByDgfStoreDtlsListFindByType(
		String type, int start, int end) {

		return findByDgfStoreDtlsListFindByType(type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf store dtlses where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfStoreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of dgf store dtlses
	 * @param end the upper bound of the range of dgf store dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf store dtlses
	 */
	@Override
	public List<DgfStoreDtls> findByDgfStoreDtlsListFindByType(
		String type, int start, int end,
		OrderByComparator<DgfStoreDtls> orderByComparator) {

		return findByDgfStoreDtlsListFindByType(
			type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf store dtlses where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfStoreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of dgf store dtlses
	 * @param end the upper bound of the range of dgf store dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf store dtlses
	 */
	@Override
	public List<DgfStoreDtls> findByDgfStoreDtlsListFindByType(
		String type, int start, int end,
		OrderByComparator<DgfStoreDtls> orderByComparator,
		boolean useFinderCache) {

		type = Objects.toString(type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByDgfStoreDtlsListFindByType;
				finderArgs = new Object[] {type};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByDgfStoreDtlsListFindByType;
			finderArgs = new Object[] {type, start, end, orderByComparator};
		}

		List<DgfStoreDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfStoreDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfStoreDtls dgfStoreDtls : list) {
					if (!type.equals(dgfStoreDtls.getType())) {
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

			sb.append(_SQL_SELECT_DGFSTOREDTLS_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_DGFSTOREDTLSLISTFINDBYTYPE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_DGFSTOREDTLSLISTFINDBYTYPE_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfStoreDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindType) {
					queryPos.add(type);
				}

				list = (List<DgfStoreDtls>)QueryUtil.list(
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
	 * Returns the first dgf store dtls in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf store dtls
	 * @throws NoSuchDgfStoreDtlsException if a matching dgf store dtls could not be found
	 */
	@Override
	public DgfStoreDtls findByDgfStoreDtlsListFindByType_First(
			String type, OrderByComparator<DgfStoreDtls> orderByComparator)
		throws NoSuchDgfStoreDtlsException {

		DgfStoreDtls dgfStoreDtls = fetchByDgfStoreDtlsListFindByType_First(
			type, orderByComparator);

		if (dgfStoreDtls != null) {
			return dgfStoreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchDgfStoreDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf store dtls in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf store dtls, or <code>null</code> if a matching dgf store dtls could not be found
	 */
	@Override
	public DgfStoreDtls fetchByDgfStoreDtlsListFindByType_First(
		String type, OrderByComparator<DgfStoreDtls> orderByComparator) {

		List<DgfStoreDtls> list = findByDgfStoreDtlsListFindByType(
			type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf store dtls in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf store dtls
	 * @throws NoSuchDgfStoreDtlsException if a matching dgf store dtls could not be found
	 */
	@Override
	public DgfStoreDtls findByDgfStoreDtlsListFindByType_Last(
			String type, OrderByComparator<DgfStoreDtls> orderByComparator)
		throws NoSuchDgfStoreDtlsException {

		DgfStoreDtls dgfStoreDtls = fetchByDgfStoreDtlsListFindByType_Last(
			type, orderByComparator);

		if (dgfStoreDtls != null) {
			return dgfStoreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchDgfStoreDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf store dtls in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf store dtls, or <code>null</code> if a matching dgf store dtls could not be found
	 */
	@Override
	public DgfStoreDtls fetchByDgfStoreDtlsListFindByType_Last(
		String type, OrderByComparator<DgfStoreDtls> orderByComparator) {

		int count = countByDgfStoreDtlsListFindByType(type);

		if (count == 0) {
			return null;
		}

		List<DgfStoreDtls> list = findByDgfStoreDtlsListFindByType(
			type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf store dtlses before and after the current dgf store dtls in the ordered set where type = &#63;.
	 *
	 * @param id the primary key of the current dgf store dtls
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf store dtls
	 * @throws NoSuchDgfStoreDtlsException if a dgf store dtls with the primary key could not be found
	 */
	@Override
	public DgfStoreDtls[] findByDgfStoreDtlsListFindByType_PrevAndNext(
			long id, String type,
			OrderByComparator<DgfStoreDtls> orderByComparator)
		throws NoSuchDgfStoreDtlsException {

		type = Objects.toString(type, "");

		DgfStoreDtls dgfStoreDtls = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DgfStoreDtls[] array = new DgfStoreDtlsImpl[3];

			array[0] = getByDgfStoreDtlsListFindByType_PrevAndNext(
				session, dgfStoreDtls, type, orderByComparator, true);

			array[1] = dgfStoreDtls;

			array[2] = getByDgfStoreDtlsListFindByType_PrevAndNext(
				session, dgfStoreDtls, type, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DgfStoreDtls getByDgfStoreDtlsListFindByType_PrevAndNext(
		Session session, DgfStoreDtls dgfStoreDtls, String type,
		OrderByComparator<DgfStoreDtls> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DGFSTOREDTLS_WHERE);

		boolean bindType = false;

		if (type.isEmpty()) {
			sb.append(_FINDER_COLUMN_DGFSTOREDTLSLISTFINDBYTYPE_TYPE_3);
		}
		else {
			bindType = true;

			sb.append(_FINDER_COLUMN_DGFSTOREDTLSLISTFINDBYTYPE_TYPE_2);
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
			sb.append(DgfStoreDtlsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindType) {
			queryPos.add(type);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dgfStoreDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfStoreDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf store dtlses where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	@Override
	public void removeByDgfStoreDtlsListFindByType(String type) {
		for (DgfStoreDtls dgfStoreDtls :
				findByDgfStoreDtlsListFindByType(
					type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgfStoreDtls);
		}
	}

	/**
	 * Returns the number of dgf store dtlses where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching dgf store dtlses
	 */
	@Override
	public int countByDgfStoreDtlsListFindByType(String type) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByDgfStoreDtlsListFindByType;

		Object[] finderArgs = new Object[] {type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFSTOREDTLS_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_DGFSTOREDTLSLISTFINDBYTYPE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_DGFSTOREDTLSLISTFINDBYTYPE_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindType) {
					queryPos.add(type);
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
		_FINDER_COLUMN_DGFSTOREDTLSLISTFINDBYTYPE_TYPE_2 =
			"dgfStoreDtls.type = ?";

	private static final String
		_FINDER_COLUMN_DGFSTOREDTLSLISTFINDBYTYPE_TYPE_3 =
			"(dgfStoreDtls.type IS NULL OR dgfStoreDtls.type = '')";

	private FinderPath _finderPathWithPaginationFindByDgfStoreDtlsListFindByNid;
	private FinderPath
		_finderPathWithoutPaginationFindByDgfStoreDtlsListFindByNid;
	private FinderPath _finderPathCountByDgfStoreDtlsListFindByNid;

	/**
	 * Returns all the dgf store dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf store dtlses
	 */
	@Override
	public List<DgfStoreDtls> findByDgfStoreDtlsListFindByNid(
		String nationalId) {

		return findByDgfStoreDtlsListFindByNid(
			nationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf store dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfStoreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf store dtlses
	 * @param end the upper bound of the range of dgf store dtlses (not inclusive)
	 * @return the range of matching dgf store dtlses
	 */
	@Override
	public List<DgfStoreDtls> findByDgfStoreDtlsListFindByNid(
		String nationalId, int start, int end) {

		return findByDgfStoreDtlsListFindByNid(nationalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf store dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfStoreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf store dtlses
	 * @param end the upper bound of the range of dgf store dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf store dtlses
	 */
	@Override
	public List<DgfStoreDtls> findByDgfStoreDtlsListFindByNid(
		String nationalId, int start, int end,
		OrderByComparator<DgfStoreDtls> orderByComparator) {

		return findByDgfStoreDtlsListFindByNid(
			nationalId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf store dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfStoreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf store dtlses
	 * @param end the upper bound of the range of dgf store dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf store dtlses
	 */
	@Override
	public List<DgfStoreDtls> findByDgfStoreDtlsListFindByNid(
		String nationalId, int start, int end,
		OrderByComparator<DgfStoreDtls> orderByComparator,
		boolean useFinderCache) {

		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByDgfStoreDtlsListFindByNid;
				finderArgs = new Object[] {nationalId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByDgfStoreDtlsListFindByNid;
			finderArgs = new Object[] {
				nationalId, start, end, orderByComparator
			};
		}

		List<DgfStoreDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfStoreDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfStoreDtls dgfStoreDtls : list) {
					if (!nationalId.equals(dgfStoreDtls.getNationalId())) {
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

			sb.append(_SQL_SELECT_DGFSTOREDTLS_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DGFSTOREDTLSLISTFINDBYNID_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(
					_FINDER_COLUMN_DGFSTOREDTLSLISTFINDBYNID_NATIONALID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfStoreDtlsModelImpl.ORDER_BY_JPQL);
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

				list = (List<DgfStoreDtls>)QueryUtil.list(
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
	 * Returns the first dgf store dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf store dtls
	 * @throws NoSuchDgfStoreDtlsException if a matching dgf store dtls could not be found
	 */
	@Override
	public DgfStoreDtls findByDgfStoreDtlsListFindByNid_First(
			String nationalId,
			OrderByComparator<DgfStoreDtls> orderByComparator)
		throws NoSuchDgfStoreDtlsException {

		DgfStoreDtls dgfStoreDtls = fetchByDgfStoreDtlsListFindByNid_First(
			nationalId, orderByComparator);

		if (dgfStoreDtls != null) {
			return dgfStoreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationalId=");
		sb.append(nationalId);

		sb.append("}");

		throw new NoSuchDgfStoreDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf store dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf store dtls, or <code>null</code> if a matching dgf store dtls could not be found
	 */
	@Override
	public DgfStoreDtls fetchByDgfStoreDtlsListFindByNid_First(
		String nationalId, OrderByComparator<DgfStoreDtls> orderByComparator) {

		List<DgfStoreDtls> list = findByDgfStoreDtlsListFindByNid(
			nationalId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf store dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf store dtls
	 * @throws NoSuchDgfStoreDtlsException if a matching dgf store dtls could not be found
	 */
	@Override
	public DgfStoreDtls findByDgfStoreDtlsListFindByNid_Last(
			String nationalId,
			OrderByComparator<DgfStoreDtls> orderByComparator)
		throws NoSuchDgfStoreDtlsException {

		DgfStoreDtls dgfStoreDtls = fetchByDgfStoreDtlsListFindByNid_Last(
			nationalId, orderByComparator);

		if (dgfStoreDtls != null) {
			return dgfStoreDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationalId=");
		sb.append(nationalId);

		sb.append("}");

		throw new NoSuchDgfStoreDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf store dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf store dtls, or <code>null</code> if a matching dgf store dtls could not be found
	 */
	@Override
	public DgfStoreDtls fetchByDgfStoreDtlsListFindByNid_Last(
		String nationalId, OrderByComparator<DgfStoreDtls> orderByComparator) {

		int count = countByDgfStoreDtlsListFindByNid(nationalId);

		if (count == 0) {
			return null;
		}

		List<DgfStoreDtls> list = findByDgfStoreDtlsListFindByNid(
			nationalId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf store dtlses before and after the current dgf store dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param id the primary key of the current dgf store dtls
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf store dtls
	 * @throws NoSuchDgfStoreDtlsException if a dgf store dtls with the primary key could not be found
	 */
	@Override
	public DgfStoreDtls[] findByDgfStoreDtlsListFindByNid_PrevAndNext(
			long id, String nationalId,
			OrderByComparator<DgfStoreDtls> orderByComparator)
		throws NoSuchDgfStoreDtlsException {

		nationalId = Objects.toString(nationalId, "");

		DgfStoreDtls dgfStoreDtls = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DgfStoreDtls[] array = new DgfStoreDtlsImpl[3];

			array[0] = getByDgfStoreDtlsListFindByNid_PrevAndNext(
				session, dgfStoreDtls, nationalId, orderByComparator, true);

			array[1] = dgfStoreDtls;

			array[2] = getByDgfStoreDtlsListFindByNid_PrevAndNext(
				session, dgfStoreDtls, nationalId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DgfStoreDtls getByDgfStoreDtlsListFindByNid_PrevAndNext(
		Session session, DgfStoreDtls dgfStoreDtls, String nationalId,
		OrderByComparator<DgfStoreDtls> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DGFSTOREDTLS_WHERE);

		boolean bindNationalId = false;

		if (nationalId.isEmpty()) {
			sb.append(_FINDER_COLUMN_DGFSTOREDTLSLISTFINDBYNID_NATIONALID_3);
		}
		else {
			bindNationalId = true;

			sb.append(_FINDER_COLUMN_DGFSTOREDTLSLISTFINDBYNID_NATIONALID_2);
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
			sb.append(DgfStoreDtlsModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(dgfStoreDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfStoreDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf store dtlses where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	@Override
	public void removeByDgfStoreDtlsListFindByNid(String nationalId) {
		for (DgfStoreDtls dgfStoreDtls :
				findByDgfStoreDtlsListFindByNid(
					nationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgfStoreDtls);
		}
	}

	/**
	 * Returns the number of dgf store dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf store dtlses
	 */
	@Override
	public int countByDgfStoreDtlsListFindByNid(String nationalId) {
		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = _finderPathCountByDgfStoreDtlsListFindByNid;

		Object[] finderArgs = new Object[] {nationalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFSTOREDTLS_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DGFSTOREDTLSLISTFINDBYNID_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(
					_FINDER_COLUMN_DGFSTOREDTLSLISTFINDBYNID_NATIONALID_2);
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
		_FINDER_COLUMN_DGFSTOREDTLSLISTFINDBYNID_NATIONALID_2 =
			"dgfStoreDtls.nationalId = ?";

	private static final String
		_FINDER_COLUMN_DGFSTOREDTLSLISTFINDBYNID_NATIONALID_3 =
			"(dgfStoreDtls.nationalId IS NULL OR dgfStoreDtls.nationalId = '')";

	public DgfStoreDtlsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("nationalId", "national_id");
		dbColumnNames.put("DagNo", "dag_no");
		dbColumnNames.put("unionName", "union_name");
		dbColumnNames.put("cityCrprtn", "city_corporatn");
		dbColumnNames.put("dicsHight", "dics_hight");
		dbColumnNames.put("dicsWidth", "dics_width");
		dbColumnNames.put("dicsLngth", "dics_lngth");
		dbColumnNames.put("dicsCpacty", "dics_cpacty");
		dbColumnNames.put("totalCpacty", "total_cpacty");
		dbColumnNames.put("createdAt", "created_at");
		dbColumnNames.put("updatedAt", "updated_at");

		setDBColumnNames(dbColumnNames);

		setModelClass(DgfStoreDtls.class);

		setModelImplClass(DgfStoreDtlsImpl.class);
		setModelPKClass(long.class);

		setTable(DgfStoreDtlsTable.INSTANCE);
	}

	/**
	 * Caches the dgf store dtls in the entity cache if it is enabled.
	 *
	 * @param dgfStoreDtls the dgf store dtls
	 */
	@Override
	public void cacheResult(DgfStoreDtls dgfStoreDtls) {
		entityCache.putResult(
			DgfStoreDtlsImpl.class, dgfStoreDtls.getPrimaryKey(), dgfStoreDtls);

		finderCache.putResult(
			_finderPathFetchByDgfStoreDtlsFindByType,
			new Object[] {dgfStoreDtls.getType()}, dgfStoreDtls);

		finderCache.putResult(
			_finderPathFetchByDgfStoreDtlsFindByNid,
			new Object[] {dgfStoreDtls.getNationalId()}, dgfStoreDtls);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dgf store dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfStoreDtlses the dgf store dtlses
	 */
	@Override
	public void cacheResult(List<DgfStoreDtls> dgfStoreDtlses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgfStoreDtlses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DgfStoreDtls dgfStoreDtls : dgfStoreDtlses) {
			if (entityCache.getResult(
					DgfStoreDtlsImpl.class, dgfStoreDtls.getPrimaryKey()) ==
						null) {

				cacheResult(dgfStoreDtls);
			}
		}
	}

	/**
	 * Clears the cache for all dgf store dtlses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DgfStoreDtlsImpl.class);

		finderCache.clearCache(DgfStoreDtlsImpl.class);
	}

	/**
	 * Clears the cache for the dgf store dtls.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DgfStoreDtls dgfStoreDtls) {
		entityCache.removeResult(DgfStoreDtlsImpl.class, dgfStoreDtls);
	}

	@Override
	public void clearCache(List<DgfStoreDtls> dgfStoreDtlses) {
		for (DgfStoreDtls dgfStoreDtls : dgfStoreDtlses) {
			entityCache.removeResult(DgfStoreDtlsImpl.class, dgfStoreDtls);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DgfStoreDtlsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DgfStoreDtlsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DgfStoreDtlsModelImpl dgfStoreDtlsModelImpl) {

		Object[] args = new Object[] {dgfStoreDtlsModelImpl.getType()};

		finderCache.putResult(
			_finderPathCountByDgfStoreDtlsFindByType, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDgfStoreDtlsFindByType, args,
			dgfStoreDtlsModelImpl);

		args = new Object[] {dgfStoreDtlsModelImpl.getNationalId()};

		finderCache.putResult(
			_finderPathCountByDgfStoreDtlsFindByNid, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDgfStoreDtlsFindByNid, args,
			dgfStoreDtlsModelImpl);
	}

	/**
	 * Creates a new dgf store dtls with the primary key. Does not add the dgf store dtls to the database.
	 *
	 * @param id the primary key for the new dgf store dtls
	 * @return the new dgf store dtls
	 */
	@Override
	public DgfStoreDtls create(long id) {
		DgfStoreDtls dgfStoreDtls = new DgfStoreDtlsImpl();

		dgfStoreDtls.setNew(true);
		dgfStoreDtls.setPrimaryKey(id);

		return dgfStoreDtls;
	}

	/**
	 * Removes the dgf store dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dgf store dtls
	 * @return the dgf store dtls that was removed
	 * @throws NoSuchDgfStoreDtlsException if a dgf store dtls with the primary key could not be found
	 */
	@Override
	public DgfStoreDtls remove(long id) throws NoSuchDgfStoreDtlsException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the dgf store dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dgf store dtls
	 * @return the dgf store dtls that was removed
	 * @throws NoSuchDgfStoreDtlsException if a dgf store dtls with the primary key could not be found
	 */
	@Override
	public DgfStoreDtls remove(Serializable primaryKey)
		throws NoSuchDgfStoreDtlsException {

		Session session = null;

		try {
			session = openSession();

			DgfStoreDtls dgfStoreDtls = (DgfStoreDtls)session.get(
				DgfStoreDtlsImpl.class, primaryKey);

			if (dgfStoreDtls == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDgfStoreDtlsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgfStoreDtls);
		}
		catch (NoSuchDgfStoreDtlsException noSuchEntityException) {
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
	protected DgfStoreDtls removeImpl(DgfStoreDtls dgfStoreDtls) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgfStoreDtls)) {
				dgfStoreDtls = (DgfStoreDtls)session.get(
					DgfStoreDtlsImpl.class, dgfStoreDtls.getPrimaryKeyObj());
			}

			if (dgfStoreDtls != null) {
				session.delete(dgfStoreDtls);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgfStoreDtls != null) {
			clearCache(dgfStoreDtls);
		}

		return dgfStoreDtls;
	}

	@Override
	public DgfStoreDtls updateImpl(DgfStoreDtls dgfStoreDtls) {
		boolean isNew = dgfStoreDtls.isNew();

		if (!(dgfStoreDtls instanceof DgfStoreDtlsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dgfStoreDtls.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dgfStoreDtls);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgfStoreDtls proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DgfStoreDtls implementation " +
					dgfStoreDtls.getClass());
		}

		DgfStoreDtlsModelImpl dgfStoreDtlsModelImpl =
			(DgfStoreDtlsModelImpl)dgfStoreDtls;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgfStoreDtls);
			}
			else {
				dgfStoreDtls = (DgfStoreDtls)session.merge(dgfStoreDtls);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DgfStoreDtlsImpl.class, dgfStoreDtlsModelImpl, false, true);

		cacheUniqueFindersCache(dgfStoreDtlsModelImpl);

		if (isNew) {
			dgfStoreDtls.setNew(false);
		}

		dgfStoreDtls.resetOriginalValues();

		return dgfStoreDtls;
	}

	/**
	 * Returns the dgf store dtls with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dgf store dtls
	 * @return the dgf store dtls
	 * @throws NoSuchDgfStoreDtlsException if a dgf store dtls with the primary key could not be found
	 */
	@Override
	public DgfStoreDtls findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDgfStoreDtlsException {

		DgfStoreDtls dgfStoreDtls = fetchByPrimaryKey(primaryKey);

		if (dgfStoreDtls == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDgfStoreDtlsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgfStoreDtls;
	}

	/**
	 * Returns the dgf store dtls with the primary key or throws a <code>NoSuchDgfStoreDtlsException</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf store dtls
	 * @return the dgf store dtls
	 * @throws NoSuchDgfStoreDtlsException if a dgf store dtls with the primary key could not be found
	 */
	@Override
	public DgfStoreDtls findByPrimaryKey(long id)
		throws NoSuchDgfStoreDtlsException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the dgf store dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf store dtls
	 * @return the dgf store dtls, or <code>null</code> if a dgf store dtls with the primary key could not be found
	 */
	@Override
	public DgfStoreDtls fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the dgf store dtlses.
	 *
	 * @return the dgf store dtlses
	 */
	@Override
	public List<DgfStoreDtls> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf store dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfStoreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf store dtlses
	 * @param end the upper bound of the range of dgf store dtlses (not inclusive)
	 * @return the range of dgf store dtlses
	 */
	@Override
	public List<DgfStoreDtls> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf store dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfStoreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf store dtlses
	 * @param end the upper bound of the range of dgf store dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf store dtlses
	 */
	@Override
	public List<DgfStoreDtls> findAll(
		int start, int end, OrderByComparator<DgfStoreDtls> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf store dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfStoreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf store dtlses
	 * @param end the upper bound of the range of dgf store dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf store dtlses
	 */
	@Override
	public List<DgfStoreDtls> findAll(
		int start, int end, OrderByComparator<DgfStoreDtls> orderByComparator,
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

		List<DgfStoreDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfStoreDtls>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFSTOREDTLS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFSTOREDTLS;

				sql = sql.concat(DgfStoreDtlsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DgfStoreDtls>)QueryUtil.list(
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
	 * Removes all the dgf store dtlses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DgfStoreDtls dgfStoreDtls : findAll()) {
			remove(dgfStoreDtls);
		}
	}

	/**
	 * Returns the number of dgf store dtlses.
	 *
	 * @return the number of dgf store dtlses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DGFSTOREDTLS);

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
		return _SQL_SELECT_DGFSTOREDTLS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DgfStoreDtlsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dgf store dtls persistence.
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

		_finderPathFetchByDgfStoreDtlsFindByType = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDgfStoreDtlsFindByType",
			new String[] {String.class.getName()}, new String[] {"type"}, true);

		_finderPathCountByDgfStoreDtlsFindByType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDgfStoreDtlsFindByType",
			new String[] {String.class.getName()}, new String[] {"type"},
			false);

		_finderPathFetchByDgfStoreDtlsFindByNid = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDgfStoreDtlsFindByNid",
			new String[] {String.class.getName()}, new String[] {"national_id"},
			true);

		_finderPathCountByDgfStoreDtlsFindByNid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDgfStoreDtlsFindByNid",
			new String[] {String.class.getName()}, new String[] {"national_id"},
			false);

		_finderPathWithPaginationFindByDgfStoreDtlsListFindByType =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByDgfStoreDtlsListFindByType",
				new String[] {
					String.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"type"}, true);

		_finderPathWithoutPaginationFindByDgfStoreDtlsListFindByType =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByDgfStoreDtlsListFindByType",
				new String[] {String.class.getName()}, new String[] {"type"},
				true);

		_finderPathCountByDgfStoreDtlsListFindByType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDgfStoreDtlsListFindByType",
			new String[] {String.class.getName()}, new String[] {"type"},
			false);

		_finderPathWithPaginationFindByDgfStoreDtlsListFindByNid =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByDgfStoreDtlsListFindByNid",
				new String[] {
					String.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"national_id"}, true);

		_finderPathWithoutPaginationFindByDgfStoreDtlsListFindByNid =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByDgfStoreDtlsListFindByNid",
				new String[] {String.class.getName()},
				new String[] {"national_id"}, true);

		_finderPathCountByDgfStoreDtlsListFindByNid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDgfStoreDtlsListFindByNid",
			new String[] {String.class.getName()}, new String[] {"national_id"},
			false);

		_setDgfStoreDtlsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDgfStoreDtlsUtilPersistence(null);

		entityCache.removeCache(DgfStoreDtlsImpl.class.getName());
	}

	private void _setDgfStoreDtlsUtilPersistence(
		DgfStoreDtlsPersistence dgfStoreDtlsPersistence) {

		try {
			Field field = DgfStoreDtlsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dgfStoreDtlsPersistence);
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

	private static final String _SQL_SELECT_DGFSTOREDTLS =
		"SELECT dgfStoreDtls FROM DgfStoreDtls dgfStoreDtls";

	private static final String _SQL_SELECT_DGFSTOREDTLS_WHERE =
		"SELECT dgfStoreDtls FROM DgfStoreDtls dgfStoreDtls WHERE ";

	private static final String _SQL_COUNT_DGFSTOREDTLS =
		"SELECT COUNT(dgfStoreDtls) FROM DgfStoreDtls dgfStoreDtls";

	private static final String _SQL_COUNT_DGFSTOREDTLS_WHERE =
		"SELECT COUNT(dgfStoreDtls) FROM DgfStoreDtls dgfStoreDtls WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dgfStoreDtls.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DgfStoreDtls exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DgfStoreDtls exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DgfStoreDtlsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"nationalId", "DagNo", "unionName", "cityCrprtn", "dicsHight",
			"dicsWidth", "dicsLngth", "dicsCpacty", "totalCpacty", "createdAt",
			"updatedAt"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}