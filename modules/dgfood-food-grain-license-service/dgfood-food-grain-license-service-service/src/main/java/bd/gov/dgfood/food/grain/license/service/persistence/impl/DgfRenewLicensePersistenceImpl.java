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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfRenewLicenseException;
import bd.gov.dgfood.food.grain.license.model.DgfRenewLicense;
import bd.gov.dgfood.food.grain.license.model.DgfRenewLicenseTable;
import bd.gov.dgfood.food.grain.license.model.impl.DgfRenewLicenseImpl;
import bd.gov.dgfood.food.grain.license.model.impl.DgfRenewLicenseModelImpl;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfRenewLicensePersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfRenewLicenseUtil;
import bd.gov.dgfood.food.grain.license.service.persistence.impl.constants.DGFPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.permission.InlineSQLHelperUtil;
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
 * The persistence implementation for the dgf renew license service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DgfRenewLicensePersistence.class)
public class DgfRenewLicensePersistenceImpl
	extends BasePersistenceImpl<DgfRenewLicense>
	implements DgfRenewLicensePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DgfRenewLicenseUtil</code> to access the dgf renew license persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DgfRenewLicenseImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByrenewLicUserIdFinder;
	private FinderPath _finderPathCountByrenewLicUserIdFinder;

	/**
	 * Returns the dgf renew license where userId = &#63; or throws a <code>NoSuchDgfRenewLicenseException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a matching dgf renew license could not be found
	 */
	@Override
	public DgfRenewLicense findByrenewLicUserIdFinder(long userId)
		throws NoSuchDgfRenewLicenseException {

		DgfRenewLicense dgfRenewLicense = fetchByrenewLicUserIdFinder(userId);

		if (dgfRenewLicense == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("userId=");
			sb.append(userId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfRenewLicenseException(sb.toString());
		}

		return dgfRenewLicense;
	}

	/**
	 * Returns the dgf renew license where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	@Override
	public DgfRenewLicense fetchByrenewLicUserIdFinder(long userId) {
		return fetchByrenewLicUserIdFinder(userId, true);
	}

	/**
	 * Returns the dgf renew license where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	@Override
	public DgfRenewLicense fetchByrenewLicUserIdFinder(
		long userId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {userId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByrenewLicUserIdFinder, finderArgs, this);
		}

		if (result instanceof DgfRenewLicense) {
			DgfRenewLicense dgfRenewLicense = (DgfRenewLicense)result;

			if (userId != dgfRenewLicense.getUserId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DGFRENEWLICENSE_WHERE);

			sb.append(_FINDER_COLUMN_RENEWLICUSERIDFINDER_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				List<DgfRenewLicense> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByrenewLicUserIdFinder, finderArgs,
							list);
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
								"DgfRenewLicensePersistenceImpl.fetchByrenewLicUserIdFinder(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DgfRenewLicense dgfRenewLicense = list.get(0);

					result = dgfRenewLicense;

					cacheResult(dgfRenewLicense);
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
			return (DgfRenewLicense)result;
		}
	}

	/**
	 * Removes the dgf renew license where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the dgf renew license that was removed
	 */
	@Override
	public DgfRenewLicense removeByrenewLicUserIdFinder(long userId)
		throws NoSuchDgfRenewLicenseException {

		DgfRenewLicense dgfRenewLicense = findByrenewLicUserIdFinder(userId);

		return remove(dgfRenewLicense);
	}

	/**
	 * Returns the number of dgf renew licenses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching dgf renew licenses
	 */
	@Override
	public int countByrenewLicUserIdFinder(long userId) {
		FinderPath finderPath = _finderPathCountByrenewLicUserIdFinder;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFRENEWLICENSE_WHERE);

			sb.append(_FINDER_COLUMN_RENEWLICUSERIDFINDER_USERID_2);

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

	private static final String _FINDER_COLUMN_RENEWLICUSERIDFINDER_USERID_2 =
		"dgfRenewLicense.userId = ?";

	private FinderPath _finderPathFetchByrenewLicNationalIdFinder;
	private FinderPath _finderPathCountByrenewLicNationalIdFinder;

	/**
	 * Returns the dgf renew license where nationalId = &#63; or throws a <code>NoSuchDgfRenewLicenseException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a matching dgf renew license could not be found
	 */
	@Override
	public DgfRenewLicense findByrenewLicNationalIdFinder(String nationalId)
		throws NoSuchDgfRenewLicenseException {

		DgfRenewLicense dgfRenewLicense = fetchByrenewLicNationalIdFinder(
			nationalId);

		if (dgfRenewLicense == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("nationalId=");
			sb.append(nationalId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfRenewLicenseException(sb.toString());
		}

		return dgfRenewLicense;
	}

	/**
	 * Returns the dgf renew license where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	@Override
	public DgfRenewLicense fetchByrenewLicNationalIdFinder(String nationalId) {
		return fetchByrenewLicNationalIdFinder(nationalId, true);
	}

	/**
	 * Returns the dgf renew license where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	@Override
	public DgfRenewLicense fetchByrenewLicNationalIdFinder(
		String nationalId, boolean useFinderCache) {

		nationalId = Objects.toString(nationalId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {nationalId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByrenewLicNationalIdFinder, finderArgs, this);
		}

		if (result instanceof DgfRenewLicense) {
			DgfRenewLicense dgfRenewLicense = (DgfRenewLicense)result;

			if (!Objects.equals(nationalId, dgfRenewLicense.getNationalId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DGFRENEWLICENSE_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_RENEWLICNATIONALIDFINDER_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(_FINDER_COLUMN_RENEWLICNATIONALIDFINDER_NATIONALID_2);
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

				List<DgfRenewLicense> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByrenewLicNationalIdFinder,
							finderArgs, list);
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
								"DgfRenewLicensePersistenceImpl.fetchByrenewLicNationalIdFinder(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DgfRenewLicense dgfRenewLicense = list.get(0);

					result = dgfRenewLicense;

					cacheResult(dgfRenewLicense);
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
			return (DgfRenewLicense)result;
		}
	}

	/**
	 * Removes the dgf renew license where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the dgf renew license that was removed
	 */
	@Override
	public DgfRenewLicense removeByrenewLicNationalIdFinder(String nationalId)
		throws NoSuchDgfRenewLicenseException {

		DgfRenewLicense dgfRenewLicense = findByrenewLicNationalIdFinder(
			nationalId);

		return remove(dgfRenewLicense);
	}

	/**
	 * Returns the number of dgf renew licenses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf renew licenses
	 */
	@Override
	public int countByrenewLicNationalIdFinder(String nationalId) {
		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = _finderPathCountByrenewLicNationalIdFinder;

		Object[] finderArgs = new Object[] {nationalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFRENEWLICENSE_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_RENEWLICNATIONALIDFINDER_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(_FINDER_COLUMN_RENEWLICNATIONALIDFINDER_NATIONALID_2);
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
		_FINDER_COLUMN_RENEWLICNATIONALIDFINDER_NATIONALID_2 =
			"dgfRenewLicense.nationalId = ?";

	private static final String
		_FINDER_COLUMN_RENEWLICNATIONALIDFINDER_NATIONALID_3 =
			"(dgfRenewLicense.nationalId IS NULL OR dgfRenewLicense.nationalId = '')";

	private FinderPath
		_finderPathWithPaginationFindByrenewLicNationalIdAndLicenseFinder;
	private FinderPath
		_finderPathWithoutPaginationFindByrenewLicNationalIdAndLicenseFinder;
	private FinderPath _finderPathCountByrenewLicNationalIdAndLicenseFinder;

	/**
	 * Returns all the dgf renew licenses where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @return the matching dgf renew licenses
	 */
	@Override
	public List<DgfRenewLicense> findByrenewLicNationalIdAndLicenseFinder(
		String nationalId, String licenseNo) {

		return findByrenewLicNationalIdAndLicenseFinder(
			nationalId, licenseNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf renew licenses where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @return the range of matching dgf renew licenses
	 */
	@Override
	public List<DgfRenewLicense> findByrenewLicNationalIdAndLicenseFinder(
		String nationalId, String licenseNo, int start, int end) {

		return findByrenewLicNationalIdAndLicenseFinder(
			nationalId, licenseNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf renew licenses where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf renew licenses
	 */
	@Override
	public List<DgfRenewLicense> findByrenewLicNationalIdAndLicenseFinder(
		String nationalId, String licenseNo, int start, int end,
		OrderByComparator<DgfRenewLicense> orderByComparator) {

		return findByrenewLicNationalIdAndLicenseFinder(
			nationalId, licenseNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf renew licenses where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf renew licenses
	 */
	@Override
	public List<DgfRenewLicense> findByrenewLicNationalIdAndLicenseFinder(
		String nationalId, String licenseNo, int start, int end,
		OrderByComparator<DgfRenewLicense> orderByComparator,
		boolean useFinderCache) {

		nationalId = Objects.toString(nationalId, "");
		licenseNo = Objects.toString(licenseNo, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByrenewLicNationalIdAndLicenseFinder;
				finderArgs = new Object[] {nationalId, licenseNo};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByrenewLicNationalIdAndLicenseFinder;
			finderArgs = new Object[] {
				nationalId, licenseNo, start, end, orderByComparator
			};
		}

		List<DgfRenewLicense> list = null;

		if (useFinderCache) {
			list = (List<DgfRenewLicense>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfRenewLicense dgfRenewLicense : list) {
					if (!nationalId.equals(dgfRenewLicense.getNationalId()) ||
						!licenseNo.equals(dgfRenewLicense.getLicenseNo())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_DGFRENEWLICENSE_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_RENEWLICNATIONALIDANDLICENSEFINDER_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(
					_FINDER_COLUMN_RENEWLICNATIONALIDANDLICENSEFINDER_NATIONALID_2);
			}

			boolean bindLicenseNo = false;

			if (licenseNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_RENEWLICNATIONALIDANDLICENSEFINDER_LICENSENO_3);
			}
			else {
				bindLicenseNo = true;

				sb.append(
					_FINDER_COLUMN_RENEWLICNATIONALIDANDLICENSEFINDER_LICENSENO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfRenewLicenseModelImpl.ORDER_BY_JPQL);
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

				if (bindLicenseNo) {
					queryPos.add(licenseNo);
				}

				list = (List<DgfRenewLicense>)QueryUtil.list(
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
	 * Returns the first dgf renew license in the ordered set where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a matching dgf renew license could not be found
	 */
	@Override
	public DgfRenewLicense findByrenewLicNationalIdAndLicenseFinder_First(
			String nationalId, String licenseNo,
			OrderByComparator<DgfRenewLicense> orderByComparator)
		throws NoSuchDgfRenewLicenseException {

		DgfRenewLicense dgfRenewLicense =
			fetchByrenewLicNationalIdAndLicenseFinder_First(
				nationalId, licenseNo, orderByComparator);

		if (dgfRenewLicense != null) {
			return dgfRenewLicense;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationalId=");
		sb.append(nationalId);

		sb.append(", licenseNo=");
		sb.append(licenseNo);

		sb.append("}");

		throw new NoSuchDgfRenewLicenseException(sb.toString());
	}

	/**
	 * Returns the first dgf renew license in the ordered set where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	@Override
	public DgfRenewLicense fetchByrenewLicNationalIdAndLicenseFinder_First(
		String nationalId, String licenseNo,
		OrderByComparator<DgfRenewLicense> orderByComparator) {

		List<DgfRenewLicense> list = findByrenewLicNationalIdAndLicenseFinder(
			nationalId, licenseNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf renew license in the ordered set where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a matching dgf renew license could not be found
	 */
	@Override
	public DgfRenewLicense findByrenewLicNationalIdAndLicenseFinder_Last(
			String nationalId, String licenseNo,
			OrderByComparator<DgfRenewLicense> orderByComparator)
		throws NoSuchDgfRenewLicenseException {

		DgfRenewLicense dgfRenewLicense =
			fetchByrenewLicNationalIdAndLicenseFinder_Last(
				nationalId, licenseNo, orderByComparator);

		if (dgfRenewLicense != null) {
			return dgfRenewLicense;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationalId=");
		sb.append(nationalId);

		sb.append(", licenseNo=");
		sb.append(licenseNo);

		sb.append("}");

		throw new NoSuchDgfRenewLicenseException(sb.toString());
	}

	/**
	 * Returns the last dgf renew license in the ordered set where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	@Override
	public DgfRenewLicense fetchByrenewLicNationalIdAndLicenseFinder_Last(
		String nationalId, String licenseNo,
		OrderByComparator<DgfRenewLicense> orderByComparator) {

		int count = countByrenewLicNationalIdAndLicenseFinder(
			nationalId, licenseNo);

		if (count == 0) {
			return null;
		}

		List<DgfRenewLicense> list = findByrenewLicNationalIdAndLicenseFinder(
			nationalId, licenseNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf renew licenses before and after the current dgf renew license in the ordered set where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param renewLicenseId the primary key of the current dgf renew license
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a dgf renew license with the primary key could not be found
	 */
	@Override
	public DgfRenewLicense[]
			findByrenewLicNationalIdAndLicenseFinder_PrevAndNext(
				long renewLicenseId, String nationalId, String licenseNo,
				OrderByComparator<DgfRenewLicense> orderByComparator)
		throws NoSuchDgfRenewLicenseException {

		nationalId = Objects.toString(nationalId, "");
		licenseNo = Objects.toString(licenseNo, "");

		DgfRenewLicense dgfRenewLicense = findByPrimaryKey(renewLicenseId);

		Session session = null;

		try {
			session = openSession();

			DgfRenewLicense[] array = new DgfRenewLicenseImpl[3];

			array[0] = getByrenewLicNationalIdAndLicenseFinder_PrevAndNext(
				session, dgfRenewLicense, nationalId, licenseNo,
				orderByComparator, true);

			array[1] = dgfRenewLicense;

			array[2] = getByrenewLicNationalIdAndLicenseFinder_PrevAndNext(
				session, dgfRenewLicense, nationalId, licenseNo,
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

	protected DgfRenewLicense
		getByrenewLicNationalIdAndLicenseFinder_PrevAndNext(
			Session session, DgfRenewLicense dgfRenewLicense, String nationalId,
			String licenseNo,
			OrderByComparator<DgfRenewLicense> orderByComparator,
			boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DGFRENEWLICENSE_WHERE);

		boolean bindNationalId = false;

		if (nationalId.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_RENEWLICNATIONALIDANDLICENSEFINDER_NATIONALID_3);
		}
		else {
			bindNationalId = true;

			sb.append(
				_FINDER_COLUMN_RENEWLICNATIONALIDANDLICENSEFINDER_NATIONALID_2);
		}

		boolean bindLicenseNo = false;

		if (licenseNo.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_RENEWLICNATIONALIDANDLICENSEFINDER_LICENSENO_3);
		}
		else {
			bindLicenseNo = true;

			sb.append(
				_FINDER_COLUMN_RENEWLICNATIONALIDANDLICENSEFINDER_LICENSENO_2);
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
			sb.append(DgfRenewLicenseModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindNationalId) {
			queryPos.add(nationalId);
		}

		if (bindLicenseNo) {
			queryPos.add(licenseNo);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfRenewLicense)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfRenewLicense> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the dgf renew licenses that the user has permission to view where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @return the matching dgf renew licenses that the user has permission to view
	 */
	@Override
	public List<DgfRenewLicense> filterFindByrenewLicNationalIdAndLicenseFinder(
		String nationalId, String licenseNo) {

		return filterFindByrenewLicNationalIdAndLicenseFinder(
			nationalId, licenseNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf renew licenses that the user has permission to view where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @return the range of matching dgf renew licenses that the user has permission to view
	 */
	@Override
	public List<DgfRenewLicense> filterFindByrenewLicNationalIdAndLicenseFinder(
		String nationalId, String licenseNo, int start, int end) {

		return filterFindByrenewLicNationalIdAndLicenseFinder(
			nationalId, licenseNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf renew licenses that the user has permissions to view where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf renew licenses that the user has permission to view
	 */
	@Override
	public List<DgfRenewLicense> filterFindByrenewLicNationalIdAndLicenseFinder(
		String nationalId, String licenseNo, int start, int end,
		OrderByComparator<DgfRenewLicense> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByrenewLicNationalIdAndLicenseFinder(
				nationalId, licenseNo, start, end, orderByComparator);
		}

		nationalId = Objects.toString(nationalId, "");
		licenseNo = Objects.toString(licenseNo, "");

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DGFRENEWLICENSE_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_DGFRENEWLICENSE_NO_INLINE_DISTINCT_WHERE_1);
		}

		boolean bindNationalId = false;

		if (nationalId.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_RENEWLICNATIONALIDANDLICENSEFINDER_NATIONALID_3);
		}
		else {
			bindNationalId = true;

			sb.append(
				_FINDER_COLUMN_RENEWLICNATIONALIDANDLICENSEFINDER_NATIONALID_2);
		}

		boolean bindLicenseNo = false;

		if (licenseNo.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_RENEWLICNATIONALIDANDLICENSEFINDER_LICENSENO_3);
		}
		else {
			bindLicenseNo = true;

			sb.append(
				_FINDER_COLUMN_RENEWLICNATIONALIDANDLICENSEFINDER_LICENSENO_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_DGFRENEWLICENSE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(DgfRenewLicenseModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DgfRenewLicenseModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DgfRenewLicense.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(
					_FILTER_ENTITY_ALIAS, DgfRenewLicenseImpl.class);
			}
			else {
				sqlQuery.addEntity(
					_FILTER_ENTITY_TABLE, DgfRenewLicenseImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			if (bindNationalId) {
				queryPos.add(nationalId);
			}

			if (bindLicenseNo) {
				queryPos.add(licenseNo);
			}

			return (List<DgfRenewLicense>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the dgf renew licenses before and after the current dgf renew license in the ordered set of dgf renew licenses that the user has permission to view where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param renewLicenseId the primary key of the current dgf renew license
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a dgf renew license with the primary key could not be found
	 */
	@Override
	public DgfRenewLicense[]
			filterFindByrenewLicNationalIdAndLicenseFinder_PrevAndNext(
				long renewLicenseId, String nationalId, String licenseNo,
				OrderByComparator<DgfRenewLicense> orderByComparator)
		throws NoSuchDgfRenewLicenseException {

		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByrenewLicNationalIdAndLicenseFinder_PrevAndNext(
				renewLicenseId, nationalId, licenseNo, orderByComparator);
		}

		nationalId = Objects.toString(nationalId, "");
		licenseNo = Objects.toString(licenseNo, "");

		DgfRenewLicense dgfRenewLicense = findByPrimaryKey(renewLicenseId);

		Session session = null;

		try {
			session = openSession();

			DgfRenewLicense[] array = new DgfRenewLicenseImpl[3];

			array[0] =
				filterGetByrenewLicNationalIdAndLicenseFinder_PrevAndNext(
					session, dgfRenewLicense, nationalId, licenseNo,
					orderByComparator, true);

			array[1] = dgfRenewLicense;

			array[2] =
				filterGetByrenewLicNationalIdAndLicenseFinder_PrevAndNext(
					session, dgfRenewLicense, nationalId, licenseNo,
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

	protected DgfRenewLicense
		filterGetByrenewLicNationalIdAndLicenseFinder_PrevAndNext(
			Session session, DgfRenewLicense dgfRenewLicense, String nationalId,
			String licenseNo,
			OrderByComparator<DgfRenewLicense> orderByComparator,
			boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DGFRENEWLICENSE_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_DGFRENEWLICENSE_NO_INLINE_DISTINCT_WHERE_1);
		}

		boolean bindNationalId = false;

		if (nationalId.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_RENEWLICNATIONALIDANDLICENSEFINDER_NATIONALID_3);
		}
		else {
			bindNationalId = true;

			sb.append(
				_FINDER_COLUMN_RENEWLICNATIONALIDANDLICENSEFINDER_NATIONALID_2);
		}

		boolean bindLicenseNo = false;

		if (licenseNo.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_RENEWLICNATIONALIDANDLICENSEFINDER_LICENSENO_3);
		}
		else {
			bindLicenseNo = true;

			sb.append(
				_FINDER_COLUMN_RENEWLICNATIONALIDANDLICENSEFINDER_LICENSENO_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_DGFRENEWLICENSE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(DgfRenewLicenseModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DgfRenewLicenseModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DgfRenewLicense.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, DgfRenewLicenseImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, DgfRenewLicenseImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		if (bindNationalId) {
			queryPos.add(nationalId);
		}

		if (bindLicenseNo) {
			queryPos.add(licenseNo);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfRenewLicense)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfRenewLicense> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf renew licenses where nationalId = &#63; and licenseNo = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 */
	@Override
	public void removeByrenewLicNationalIdAndLicenseFinder(
		String nationalId, String licenseNo) {

		for (DgfRenewLicense dgfRenewLicense :
				findByrenewLicNationalIdAndLicenseFinder(
					nationalId, licenseNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgfRenewLicense);
		}
	}

	/**
	 * Returns the number of dgf renew licenses where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @return the number of matching dgf renew licenses
	 */
	@Override
	public int countByrenewLicNationalIdAndLicenseFinder(
		String nationalId, String licenseNo) {

		nationalId = Objects.toString(nationalId, "");
		licenseNo = Objects.toString(licenseNo, "");

		FinderPath finderPath =
			_finderPathCountByrenewLicNationalIdAndLicenseFinder;

		Object[] finderArgs = new Object[] {nationalId, licenseNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFRENEWLICENSE_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_RENEWLICNATIONALIDANDLICENSEFINDER_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(
					_FINDER_COLUMN_RENEWLICNATIONALIDANDLICENSEFINDER_NATIONALID_2);
			}

			boolean bindLicenseNo = false;

			if (licenseNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_RENEWLICNATIONALIDANDLICENSEFINDER_LICENSENO_3);
			}
			else {
				bindLicenseNo = true;

				sb.append(
					_FINDER_COLUMN_RENEWLICNATIONALIDANDLICENSEFINDER_LICENSENO_2);
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

	/**
	 * Returns the number of dgf renew licenses that the user has permission to view where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @return the number of matching dgf renew licenses that the user has permission to view
	 */
	@Override
	public int filterCountByrenewLicNationalIdAndLicenseFinder(
		String nationalId, String licenseNo) {

		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByrenewLicNationalIdAndLicenseFinder(
				nationalId, licenseNo);
		}

		nationalId = Objects.toString(nationalId, "");
		licenseNo = Objects.toString(licenseNo, "");

		StringBundler sb = new StringBundler(3);

		sb.append(_FILTER_SQL_COUNT_DGFRENEWLICENSE_WHERE);

		boolean bindNationalId = false;

		if (nationalId.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_RENEWLICNATIONALIDANDLICENSEFINDER_NATIONALID_3);
		}
		else {
			bindNationalId = true;

			sb.append(
				_FINDER_COLUMN_RENEWLICNATIONALIDANDLICENSEFINDER_NATIONALID_2);
		}

		boolean bindLicenseNo = false;

		if (licenseNo.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_RENEWLICNATIONALIDANDLICENSEFINDER_LICENSENO_3);
		}
		else {
			bindLicenseNo = true;

			sb.append(
				_FINDER_COLUMN_RENEWLICNATIONALIDANDLICENSEFINDER_LICENSENO_2);
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DgfRenewLicense.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			if (bindNationalId) {
				queryPos.add(nationalId);
			}

			if (bindLicenseNo) {
				queryPos.add(licenseNo);
			}

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String
		_FINDER_COLUMN_RENEWLICNATIONALIDANDLICENSEFINDER_NATIONALID_2 =
			"dgfRenewLicense.nationalId = ? AND ";

	private static final String
		_FINDER_COLUMN_RENEWLICNATIONALIDANDLICENSEFINDER_NATIONALID_3 =
			"(dgfRenewLicense.nationalId IS NULL OR dgfRenewLicense.nationalId = '') AND ";

	private static final String
		_FINDER_COLUMN_RENEWLICNATIONALIDANDLICENSEFINDER_LICENSENO_2 =
			"dgfRenewLicense.licenseNo = ?";

	private static final String
		_FINDER_COLUMN_RENEWLICNATIONALIDANDLICENSEFINDER_LICENSENO_3 =
			"(dgfRenewLicense.licenseNo IS NULL OR dgfRenewLicense.licenseNo = '')";

	private FinderPath _finderPathFetchByrenewLicTradeLicAttchIdFinder;
	private FinderPath _finderPathCountByrenewLicTradeLicAttchIdFinder;

	/**
	 * Returns the dgf renew license where tradeLicAttchId = &#63; or throws a <code>NoSuchDgfRenewLicenseException</code> if it could not be found.
	 *
	 * @param tradeLicAttchId the trade lic attch ID
	 * @return the matching dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a matching dgf renew license could not be found
	 */
	@Override
	public DgfRenewLicense findByrenewLicTradeLicAttchIdFinder(
			long tradeLicAttchId)
		throws NoSuchDgfRenewLicenseException {

		DgfRenewLicense dgfRenewLicense = fetchByrenewLicTradeLicAttchIdFinder(
			tradeLicAttchId);

		if (dgfRenewLicense == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("tradeLicAttchId=");
			sb.append(tradeLicAttchId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfRenewLicenseException(sb.toString());
		}

		return dgfRenewLicense;
	}

	/**
	 * Returns the dgf renew license where tradeLicAttchId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tradeLicAttchId the trade lic attch ID
	 * @return the matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	@Override
	public DgfRenewLicense fetchByrenewLicTradeLicAttchIdFinder(
		long tradeLicAttchId) {

		return fetchByrenewLicTradeLicAttchIdFinder(tradeLicAttchId, true);
	}

	/**
	 * Returns the dgf renew license where tradeLicAttchId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tradeLicAttchId the trade lic attch ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	@Override
	public DgfRenewLicense fetchByrenewLicTradeLicAttchIdFinder(
		long tradeLicAttchId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {tradeLicAttchId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByrenewLicTradeLicAttchIdFinder, finderArgs,
				this);
		}

		if (result instanceof DgfRenewLicense) {
			DgfRenewLicense dgfRenewLicense = (DgfRenewLicense)result;

			if (tradeLicAttchId != dgfRenewLicense.getTradeLicAttchId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DGFRENEWLICENSE_WHERE);

			sb.append(
				_FINDER_COLUMN_RENEWLICTRADELICATTCHIDFINDER_TRADELICATTCHID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tradeLicAttchId);

				List<DgfRenewLicense> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByrenewLicTradeLicAttchIdFinder,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {tradeLicAttchId};
							}

							_log.warn(
								"DgfRenewLicensePersistenceImpl.fetchByrenewLicTradeLicAttchIdFinder(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DgfRenewLicense dgfRenewLicense = list.get(0);

					result = dgfRenewLicense;

					cacheResult(dgfRenewLicense);
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
			return (DgfRenewLicense)result;
		}
	}

	/**
	 * Removes the dgf renew license where tradeLicAttchId = &#63; from the database.
	 *
	 * @param tradeLicAttchId the trade lic attch ID
	 * @return the dgf renew license that was removed
	 */
	@Override
	public DgfRenewLicense removeByrenewLicTradeLicAttchIdFinder(
			long tradeLicAttchId)
		throws NoSuchDgfRenewLicenseException {

		DgfRenewLicense dgfRenewLicense = findByrenewLicTradeLicAttchIdFinder(
			tradeLicAttchId);

		return remove(dgfRenewLicense);
	}

	/**
	 * Returns the number of dgf renew licenses where tradeLicAttchId = &#63;.
	 *
	 * @param tradeLicAttchId the trade lic attch ID
	 * @return the number of matching dgf renew licenses
	 */
	@Override
	public int countByrenewLicTradeLicAttchIdFinder(long tradeLicAttchId) {
		FinderPath finderPath = _finderPathCountByrenewLicTradeLicAttchIdFinder;

		Object[] finderArgs = new Object[] {tradeLicAttchId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFRENEWLICENSE_WHERE);

			sb.append(
				_FINDER_COLUMN_RENEWLICTRADELICATTCHIDFINDER_TRADELICATTCHID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tradeLicAttchId);

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
		_FINDER_COLUMN_RENEWLICTRADELICATTCHIDFINDER_TRADELICATTCHID_2 =
			"dgfRenewLicense.tradeLicAttchId = ?";

	private FinderPath _finderPathFetchByrenewLicPaymentAttchIdFinder;
	private FinderPath _finderPathCountByrenewLicPaymentAttchIdFinder;

	/**
	 * Returns the dgf renew license where paymentAttchId = &#63; or throws a <code>NoSuchDgfRenewLicenseException</code> if it could not be found.
	 *
	 * @param paymentAttchId the payment attch ID
	 * @return the matching dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a matching dgf renew license could not be found
	 */
	@Override
	public DgfRenewLicense findByrenewLicPaymentAttchIdFinder(
			long paymentAttchId)
		throws NoSuchDgfRenewLicenseException {

		DgfRenewLicense dgfRenewLicense = fetchByrenewLicPaymentAttchIdFinder(
			paymentAttchId);

		if (dgfRenewLicense == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("paymentAttchId=");
			sb.append(paymentAttchId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfRenewLicenseException(sb.toString());
		}

		return dgfRenewLicense;
	}

	/**
	 * Returns the dgf renew license where paymentAttchId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param paymentAttchId the payment attch ID
	 * @return the matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	@Override
	public DgfRenewLicense fetchByrenewLicPaymentAttchIdFinder(
		long paymentAttchId) {

		return fetchByrenewLicPaymentAttchIdFinder(paymentAttchId, true);
	}

	/**
	 * Returns the dgf renew license where paymentAttchId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param paymentAttchId the payment attch ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	@Override
	public DgfRenewLicense fetchByrenewLicPaymentAttchIdFinder(
		long paymentAttchId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {paymentAttchId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByrenewLicPaymentAttchIdFinder, finderArgs,
				this);
		}

		if (result instanceof DgfRenewLicense) {
			DgfRenewLicense dgfRenewLicense = (DgfRenewLicense)result;

			if (paymentAttchId != dgfRenewLicense.getPaymentAttchId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DGFRENEWLICENSE_WHERE);

			sb.append(
				_FINDER_COLUMN_RENEWLICPAYMENTATTCHIDFINDER_PAYMENTATTCHID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(paymentAttchId);

				List<DgfRenewLicense> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByrenewLicPaymentAttchIdFinder,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {paymentAttchId};
							}

							_log.warn(
								"DgfRenewLicensePersistenceImpl.fetchByrenewLicPaymentAttchIdFinder(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DgfRenewLicense dgfRenewLicense = list.get(0);

					result = dgfRenewLicense;

					cacheResult(dgfRenewLicense);
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
			return (DgfRenewLicense)result;
		}
	}

	/**
	 * Removes the dgf renew license where paymentAttchId = &#63; from the database.
	 *
	 * @param paymentAttchId the payment attch ID
	 * @return the dgf renew license that was removed
	 */
	@Override
	public DgfRenewLicense removeByrenewLicPaymentAttchIdFinder(
			long paymentAttchId)
		throws NoSuchDgfRenewLicenseException {

		DgfRenewLicense dgfRenewLicense = findByrenewLicPaymentAttchIdFinder(
			paymentAttchId);

		return remove(dgfRenewLicense);
	}

	/**
	 * Returns the number of dgf renew licenses where paymentAttchId = &#63;.
	 *
	 * @param paymentAttchId the payment attch ID
	 * @return the number of matching dgf renew licenses
	 */
	@Override
	public int countByrenewLicPaymentAttchIdFinder(long paymentAttchId) {
		FinderPath finderPath = _finderPathCountByrenewLicPaymentAttchIdFinder;

		Object[] finderArgs = new Object[] {paymentAttchId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFRENEWLICENSE_WHERE);

			sb.append(
				_FINDER_COLUMN_RENEWLICPAYMENTATTCHIDFINDER_PAYMENTATTCHID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(paymentAttchId);

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
		_FINDER_COLUMN_RENEWLICPAYMENTATTCHIDFINDER_PAYMENTATTCHID_2 =
			"dgfRenewLicense.paymentAttchId = ?";

	private FinderPath
		_finderPathWithPaginationFindByrenewLicFglPrePrimaryIdFinder;
	private FinderPath
		_finderPathWithoutPaginationFindByrenewLicFglPrePrimaryIdFinder;
	private FinderPath _finderPathCountByrenewLicFglPrePrimaryIdFinder;

	/**
	 * Returns all the dgf renew licenses where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the matching dgf renew licenses
	 */
	@Override
	public List<DgfRenewLicense> findByrenewLicFglPrePrimaryIdFinder(
		long fglPrePrimaryId) {

		return findByrenewLicFglPrePrimaryIdFinder(
			fglPrePrimaryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf renew licenses where fglPrePrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @return the range of matching dgf renew licenses
	 */
	@Override
	public List<DgfRenewLicense> findByrenewLicFglPrePrimaryIdFinder(
		long fglPrePrimaryId, int start, int end) {

		return findByrenewLicFglPrePrimaryIdFinder(
			fglPrePrimaryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf renew licenses where fglPrePrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf renew licenses
	 */
	@Override
	public List<DgfRenewLicense> findByrenewLicFglPrePrimaryIdFinder(
		long fglPrePrimaryId, int start, int end,
		OrderByComparator<DgfRenewLicense> orderByComparator) {

		return findByrenewLicFglPrePrimaryIdFinder(
			fglPrePrimaryId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf renew licenses where fglPrePrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf renew licenses
	 */
	@Override
	public List<DgfRenewLicense> findByrenewLicFglPrePrimaryIdFinder(
		long fglPrePrimaryId, int start, int end,
		OrderByComparator<DgfRenewLicense> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByrenewLicFglPrePrimaryIdFinder;
				finderArgs = new Object[] {fglPrePrimaryId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByrenewLicFglPrePrimaryIdFinder;
			finderArgs = new Object[] {
				fglPrePrimaryId, start, end, orderByComparator
			};
		}

		List<DgfRenewLicense> list = null;

		if (useFinderCache) {
			list = (List<DgfRenewLicense>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfRenewLicense dgfRenewLicense : list) {
					if (fglPrePrimaryId !=
							dgfRenewLicense.getFglPrePrimaryId()) {

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

			sb.append(_SQL_SELECT_DGFRENEWLICENSE_WHERE);

			sb.append(
				_FINDER_COLUMN_RENEWLICFGLPREPRIMARYIDFINDER_FGLPREPRIMARYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfRenewLicenseModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fglPrePrimaryId);

				list = (List<DgfRenewLicense>)QueryUtil.list(
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
	 * Returns the first dgf renew license in the ordered set where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a matching dgf renew license could not be found
	 */
	@Override
	public DgfRenewLicense findByrenewLicFglPrePrimaryIdFinder_First(
			long fglPrePrimaryId,
			OrderByComparator<DgfRenewLicense> orderByComparator)
		throws NoSuchDgfRenewLicenseException {

		DgfRenewLicense dgfRenewLicense =
			fetchByrenewLicFglPrePrimaryIdFinder_First(
				fglPrePrimaryId, orderByComparator);

		if (dgfRenewLicense != null) {
			return dgfRenewLicense;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fglPrePrimaryId=");
		sb.append(fglPrePrimaryId);

		sb.append("}");

		throw new NoSuchDgfRenewLicenseException(sb.toString());
	}

	/**
	 * Returns the first dgf renew license in the ordered set where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	@Override
	public DgfRenewLicense fetchByrenewLicFglPrePrimaryIdFinder_First(
		long fglPrePrimaryId,
		OrderByComparator<DgfRenewLicense> orderByComparator) {

		List<DgfRenewLicense> list = findByrenewLicFglPrePrimaryIdFinder(
			fglPrePrimaryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf renew license in the ordered set where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a matching dgf renew license could not be found
	 */
	@Override
	public DgfRenewLicense findByrenewLicFglPrePrimaryIdFinder_Last(
			long fglPrePrimaryId,
			OrderByComparator<DgfRenewLicense> orderByComparator)
		throws NoSuchDgfRenewLicenseException {

		DgfRenewLicense dgfRenewLicense =
			fetchByrenewLicFglPrePrimaryIdFinder_Last(
				fglPrePrimaryId, orderByComparator);

		if (dgfRenewLicense != null) {
			return dgfRenewLicense;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fglPrePrimaryId=");
		sb.append(fglPrePrimaryId);

		sb.append("}");

		throw new NoSuchDgfRenewLicenseException(sb.toString());
	}

	/**
	 * Returns the last dgf renew license in the ordered set where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	@Override
	public DgfRenewLicense fetchByrenewLicFglPrePrimaryIdFinder_Last(
		long fglPrePrimaryId,
		OrderByComparator<DgfRenewLicense> orderByComparator) {

		int count = countByrenewLicFglPrePrimaryIdFinder(fglPrePrimaryId);

		if (count == 0) {
			return null;
		}

		List<DgfRenewLicense> list = findByrenewLicFglPrePrimaryIdFinder(
			fglPrePrimaryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf renew licenses before and after the current dgf renew license in the ordered set where fglPrePrimaryId = &#63;.
	 *
	 * @param renewLicenseId the primary key of the current dgf renew license
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a dgf renew license with the primary key could not be found
	 */
	@Override
	public DgfRenewLicense[] findByrenewLicFglPrePrimaryIdFinder_PrevAndNext(
			long renewLicenseId, long fglPrePrimaryId,
			OrderByComparator<DgfRenewLicense> orderByComparator)
		throws NoSuchDgfRenewLicenseException {

		DgfRenewLicense dgfRenewLicense = findByPrimaryKey(renewLicenseId);

		Session session = null;

		try {
			session = openSession();

			DgfRenewLicense[] array = new DgfRenewLicenseImpl[3];

			array[0] = getByrenewLicFglPrePrimaryIdFinder_PrevAndNext(
				session, dgfRenewLicense, fglPrePrimaryId, orderByComparator,
				true);

			array[1] = dgfRenewLicense;

			array[2] = getByrenewLicFglPrePrimaryIdFinder_PrevAndNext(
				session, dgfRenewLicense, fglPrePrimaryId, orderByComparator,
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

	protected DgfRenewLicense getByrenewLicFglPrePrimaryIdFinder_PrevAndNext(
		Session session, DgfRenewLicense dgfRenewLicense, long fglPrePrimaryId,
		OrderByComparator<DgfRenewLicense> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFRENEWLICENSE_WHERE);

		sb.append(
			_FINDER_COLUMN_RENEWLICFGLPREPRIMARYIDFINDER_FGLPREPRIMARYID_2);

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
			sb.append(DgfRenewLicenseModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(fglPrePrimaryId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfRenewLicense)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfRenewLicense> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the dgf renew licenses that the user has permission to view where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the matching dgf renew licenses that the user has permission to view
	 */
	@Override
	public List<DgfRenewLicense> filterFindByrenewLicFglPrePrimaryIdFinder(
		long fglPrePrimaryId) {

		return filterFindByrenewLicFglPrePrimaryIdFinder(
			fglPrePrimaryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf renew licenses that the user has permission to view where fglPrePrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @return the range of matching dgf renew licenses that the user has permission to view
	 */
	@Override
	public List<DgfRenewLicense> filterFindByrenewLicFglPrePrimaryIdFinder(
		long fglPrePrimaryId, int start, int end) {

		return filterFindByrenewLicFglPrePrimaryIdFinder(
			fglPrePrimaryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf renew licenses that the user has permissions to view where fglPrePrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf renew licenses that the user has permission to view
	 */
	@Override
	public List<DgfRenewLicense> filterFindByrenewLicFglPrePrimaryIdFinder(
		long fglPrePrimaryId, int start, int end,
		OrderByComparator<DgfRenewLicense> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByrenewLicFglPrePrimaryIdFinder(
				fglPrePrimaryId, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				3 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DGFRENEWLICENSE_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_DGFRENEWLICENSE_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(
			_FINDER_COLUMN_RENEWLICFGLPREPRIMARYIDFINDER_FGLPREPRIMARYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_DGFRENEWLICENSE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(DgfRenewLicenseModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DgfRenewLicenseModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DgfRenewLicense.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(
					_FILTER_ENTITY_ALIAS, DgfRenewLicenseImpl.class);
			}
			else {
				sqlQuery.addEntity(
					_FILTER_ENTITY_TABLE, DgfRenewLicenseImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(fglPrePrimaryId);

			return (List<DgfRenewLicense>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the dgf renew licenses before and after the current dgf renew license in the ordered set of dgf renew licenses that the user has permission to view where fglPrePrimaryId = &#63;.
	 *
	 * @param renewLicenseId the primary key of the current dgf renew license
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a dgf renew license with the primary key could not be found
	 */
	@Override
	public DgfRenewLicense[]
			filterFindByrenewLicFglPrePrimaryIdFinder_PrevAndNext(
				long renewLicenseId, long fglPrePrimaryId,
				OrderByComparator<DgfRenewLicense> orderByComparator)
		throws NoSuchDgfRenewLicenseException {

		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByrenewLicFglPrePrimaryIdFinder_PrevAndNext(
				renewLicenseId, fglPrePrimaryId, orderByComparator);
		}

		DgfRenewLicense dgfRenewLicense = findByPrimaryKey(renewLicenseId);

		Session session = null;

		try {
			session = openSession();

			DgfRenewLicense[] array = new DgfRenewLicenseImpl[3];

			array[0] = filterGetByrenewLicFglPrePrimaryIdFinder_PrevAndNext(
				session, dgfRenewLicense, fglPrePrimaryId, orderByComparator,
				true);

			array[1] = dgfRenewLicense;

			array[2] = filterGetByrenewLicFglPrePrimaryIdFinder_PrevAndNext(
				session, dgfRenewLicense, fglPrePrimaryId, orderByComparator,
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

	protected DgfRenewLicense
		filterGetByrenewLicFglPrePrimaryIdFinder_PrevAndNext(
			Session session, DgfRenewLicense dgfRenewLicense,
			long fglPrePrimaryId,
			OrderByComparator<DgfRenewLicense> orderByComparator,
			boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DGFRENEWLICENSE_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_DGFRENEWLICENSE_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(
			_FINDER_COLUMN_RENEWLICFGLPREPRIMARYIDFINDER_FGLPREPRIMARYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_DGFRENEWLICENSE_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(DgfRenewLicenseModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DgfRenewLicenseModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DgfRenewLicense.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, DgfRenewLicenseImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, DgfRenewLicenseImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(fglPrePrimaryId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfRenewLicense)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfRenewLicense> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf renew licenses where fglPrePrimaryId = &#63; from the database.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 */
	@Override
	public void removeByrenewLicFglPrePrimaryIdFinder(long fglPrePrimaryId) {
		for (DgfRenewLicense dgfRenewLicense :
				findByrenewLicFglPrePrimaryIdFinder(
					fglPrePrimaryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgfRenewLicense);
		}
	}

	/**
	 * Returns the number of dgf renew licenses where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the number of matching dgf renew licenses
	 */
	@Override
	public int countByrenewLicFglPrePrimaryIdFinder(long fglPrePrimaryId) {
		FinderPath finderPath = _finderPathCountByrenewLicFglPrePrimaryIdFinder;

		Object[] finderArgs = new Object[] {fglPrePrimaryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFRENEWLICENSE_WHERE);

			sb.append(
				_FINDER_COLUMN_RENEWLICFGLPREPRIMARYIDFINDER_FGLPREPRIMARYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fglPrePrimaryId);

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

	/**
	 * Returns the number of dgf renew licenses that the user has permission to view where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the number of matching dgf renew licenses that the user has permission to view
	 */
	@Override
	public int filterCountByrenewLicFglPrePrimaryIdFinder(
		long fglPrePrimaryId) {

		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByrenewLicFglPrePrimaryIdFinder(fglPrePrimaryId);
		}

		StringBundler sb = new StringBundler(2);

		sb.append(_FILTER_SQL_COUNT_DGFRENEWLICENSE_WHERE);

		sb.append(
			_FINDER_COLUMN_RENEWLICFGLPREPRIMARYIDFINDER_FGLPREPRIMARYID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DgfRenewLicense.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(fglPrePrimaryId);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String
		_FINDER_COLUMN_RENEWLICFGLPREPRIMARYIDFINDER_FGLPREPRIMARYID_2 =
			"dgfRenewLicense.fglPrePrimaryId = ?";

	private FinderPath _finderPathFetchByrenewLicApplicationNoFinder;
	private FinderPath _finderPathCountByrenewLicApplicationNoFinder;

	/**
	 * Returns the dgf renew license where applicationNo = &#63; or throws a <code>NoSuchDgfRenewLicenseException</code> if it could not be found.
	 *
	 * @param applicationNo the application no
	 * @return the matching dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a matching dgf renew license could not be found
	 */
	@Override
	public DgfRenewLicense findByrenewLicApplicationNoFinder(
			String applicationNo)
		throws NoSuchDgfRenewLicenseException {

		DgfRenewLicense dgfRenewLicense = fetchByrenewLicApplicationNoFinder(
			applicationNo);

		if (dgfRenewLicense == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("applicationNo=");
			sb.append(applicationNo);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfRenewLicenseException(sb.toString());
		}

		return dgfRenewLicense;
	}

	/**
	 * Returns the dgf renew license where applicationNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param applicationNo the application no
	 * @return the matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	@Override
	public DgfRenewLicense fetchByrenewLicApplicationNoFinder(
		String applicationNo) {

		return fetchByrenewLicApplicationNoFinder(applicationNo, true);
	}

	/**
	 * Returns the dgf renew license where applicationNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param applicationNo the application no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	@Override
	public DgfRenewLicense fetchByrenewLicApplicationNoFinder(
		String applicationNo, boolean useFinderCache) {

		applicationNo = Objects.toString(applicationNo, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {applicationNo};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByrenewLicApplicationNoFinder, finderArgs,
				this);
		}

		if (result instanceof DgfRenewLicense) {
			DgfRenewLicense dgfRenewLicense = (DgfRenewLicense)result;

			if (!Objects.equals(
					applicationNo, dgfRenewLicense.getApplicationNo())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DGFRENEWLICENSE_WHERE);

			boolean bindApplicationNo = false;

			if (applicationNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_RENEWLICAPPLICATIONNOFINDER_APPLICATIONNO_3);
			}
			else {
				bindApplicationNo = true;

				sb.append(
					_FINDER_COLUMN_RENEWLICAPPLICATIONNOFINDER_APPLICATIONNO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindApplicationNo) {
					queryPos.add(applicationNo);
				}

				List<DgfRenewLicense> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByrenewLicApplicationNoFinder,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {applicationNo};
							}

							_log.warn(
								"DgfRenewLicensePersistenceImpl.fetchByrenewLicApplicationNoFinder(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DgfRenewLicense dgfRenewLicense = list.get(0);

					result = dgfRenewLicense;

					cacheResult(dgfRenewLicense);
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
			return (DgfRenewLicense)result;
		}
	}

	/**
	 * Removes the dgf renew license where applicationNo = &#63; from the database.
	 *
	 * @param applicationNo the application no
	 * @return the dgf renew license that was removed
	 */
	@Override
	public DgfRenewLicense removeByrenewLicApplicationNoFinder(
			String applicationNo)
		throws NoSuchDgfRenewLicenseException {

		DgfRenewLicense dgfRenewLicense = findByrenewLicApplicationNoFinder(
			applicationNo);

		return remove(dgfRenewLicense);
	}

	/**
	 * Returns the number of dgf renew licenses where applicationNo = &#63;.
	 *
	 * @param applicationNo the application no
	 * @return the number of matching dgf renew licenses
	 */
	@Override
	public int countByrenewLicApplicationNoFinder(String applicationNo) {
		applicationNo = Objects.toString(applicationNo, "");

		FinderPath finderPath = _finderPathCountByrenewLicApplicationNoFinder;

		Object[] finderArgs = new Object[] {applicationNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFRENEWLICENSE_WHERE);

			boolean bindApplicationNo = false;

			if (applicationNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_RENEWLICAPPLICATIONNOFINDER_APPLICATIONNO_3);
			}
			else {
				bindApplicationNo = true;

				sb.append(
					_FINDER_COLUMN_RENEWLICAPPLICATIONNOFINDER_APPLICATIONNO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindApplicationNo) {
					queryPos.add(applicationNo);
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
		_FINDER_COLUMN_RENEWLICAPPLICATIONNOFINDER_APPLICATIONNO_2 =
			"dgfRenewLicense.applicationNo = ?";

	private static final String
		_FINDER_COLUMN_RENEWLICAPPLICATIONNOFINDER_APPLICATIONNO_3 =
			"(dgfRenewLicense.applicationNo IS NULL OR dgfRenewLicense.applicationNo = '')";

	public DgfRenewLicensePersistenceImpl() {
		setModelClass(DgfRenewLicense.class);

		setModelImplClass(DgfRenewLicenseImpl.class);
		setModelPKClass(long.class);

		setTable(DgfRenewLicenseTable.INSTANCE);
	}

	/**
	 * Caches the dgf renew license in the entity cache if it is enabled.
	 *
	 * @param dgfRenewLicense the dgf renew license
	 */
	@Override
	public void cacheResult(DgfRenewLicense dgfRenewLicense) {
		entityCache.putResult(
			DgfRenewLicenseImpl.class, dgfRenewLicense.getPrimaryKey(),
			dgfRenewLicense);

		finderCache.putResult(
			_finderPathFetchByrenewLicUserIdFinder,
			new Object[] {dgfRenewLicense.getUserId()}, dgfRenewLicense);

		finderCache.putResult(
			_finderPathFetchByrenewLicNationalIdFinder,
			new Object[] {dgfRenewLicense.getNationalId()}, dgfRenewLicense);

		finderCache.putResult(
			_finderPathFetchByrenewLicTradeLicAttchIdFinder,
			new Object[] {dgfRenewLicense.getTradeLicAttchId()},
			dgfRenewLicense);

		finderCache.putResult(
			_finderPathFetchByrenewLicPaymentAttchIdFinder,
			new Object[] {dgfRenewLicense.getPaymentAttchId()},
			dgfRenewLicense);

		finderCache.putResult(
			_finderPathFetchByrenewLicApplicationNoFinder,
			new Object[] {dgfRenewLicense.getApplicationNo()}, dgfRenewLicense);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dgf renew licenses in the entity cache if it is enabled.
	 *
	 * @param dgfRenewLicenses the dgf renew licenses
	 */
	@Override
	public void cacheResult(List<DgfRenewLicense> dgfRenewLicenses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgfRenewLicenses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DgfRenewLicense dgfRenewLicense : dgfRenewLicenses) {
			if (entityCache.getResult(
					DgfRenewLicenseImpl.class,
					dgfRenewLicense.getPrimaryKey()) == null) {

				cacheResult(dgfRenewLicense);
			}
		}
	}

	/**
	 * Clears the cache for all dgf renew licenses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DgfRenewLicenseImpl.class);

		finderCache.clearCache(DgfRenewLicenseImpl.class);
	}

	/**
	 * Clears the cache for the dgf renew license.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DgfRenewLicense dgfRenewLicense) {
		entityCache.removeResult(DgfRenewLicenseImpl.class, dgfRenewLicense);
	}

	@Override
	public void clearCache(List<DgfRenewLicense> dgfRenewLicenses) {
		for (DgfRenewLicense dgfRenewLicense : dgfRenewLicenses) {
			entityCache.removeResult(
				DgfRenewLicenseImpl.class, dgfRenewLicense);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DgfRenewLicenseImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DgfRenewLicenseImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DgfRenewLicenseModelImpl dgfRenewLicenseModelImpl) {

		Object[] args = new Object[] {dgfRenewLicenseModelImpl.getUserId()};

		finderCache.putResult(
			_finderPathCountByrenewLicUserIdFinder, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByrenewLicUserIdFinder, args,
			dgfRenewLicenseModelImpl);

		args = new Object[] {dgfRenewLicenseModelImpl.getNationalId()};

		finderCache.putResult(
			_finderPathCountByrenewLicNationalIdFinder, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByrenewLicNationalIdFinder, args,
			dgfRenewLicenseModelImpl);

		args = new Object[] {dgfRenewLicenseModelImpl.getTradeLicAttchId()};

		finderCache.putResult(
			_finderPathCountByrenewLicTradeLicAttchIdFinder, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByrenewLicTradeLicAttchIdFinder, args,
			dgfRenewLicenseModelImpl);

		args = new Object[] {dgfRenewLicenseModelImpl.getPaymentAttchId()};

		finderCache.putResult(
			_finderPathCountByrenewLicPaymentAttchIdFinder, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByrenewLicPaymentAttchIdFinder, args,
			dgfRenewLicenseModelImpl);

		args = new Object[] {dgfRenewLicenseModelImpl.getApplicationNo()};

		finderCache.putResult(
			_finderPathCountByrenewLicApplicationNoFinder, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByrenewLicApplicationNoFinder, args,
			dgfRenewLicenseModelImpl);
	}

	/**
	 * Creates a new dgf renew license with the primary key. Does not add the dgf renew license to the database.
	 *
	 * @param renewLicenseId the primary key for the new dgf renew license
	 * @return the new dgf renew license
	 */
	@Override
	public DgfRenewLicense create(long renewLicenseId) {
		DgfRenewLicense dgfRenewLicense = new DgfRenewLicenseImpl();

		dgfRenewLicense.setNew(true);
		dgfRenewLicense.setPrimaryKey(renewLicenseId);

		return dgfRenewLicense;
	}

	/**
	 * Removes the dgf renew license with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param renewLicenseId the primary key of the dgf renew license
	 * @return the dgf renew license that was removed
	 * @throws NoSuchDgfRenewLicenseException if a dgf renew license with the primary key could not be found
	 */
	@Override
	public DgfRenewLicense remove(long renewLicenseId)
		throws NoSuchDgfRenewLicenseException {

		return remove((Serializable)renewLicenseId);
	}

	/**
	 * Removes the dgf renew license with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dgf renew license
	 * @return the dgf renew license that was removed
	 * @throws NoSuchDgfRenewLicenseException if a dgf renew license with the primary key could not be found
	 */
	@Override
	public DgfRenewLicense remove(Serializable primaryKey)
		throws NoSuchDgfRenewLicenseException {

		Session session = null;

		try {
			session = openSession();

			DgfRenewLicense dgfRenewLicense = (DgfRenewLicense)session.get(
				DgfRenewLicenseImpl.class, primaryKey);

			if (dgfRenewLicense == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDgfRenewLicenseException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgfRenewLicense);
		}
		catch (NoSuchDgfRenewLicenseException noSuchEntityException) {
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
	protected DgfRenewLicense removeImpl(DgfRenewLicense dgfRenewLicense) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgfRenewLicense)) {
				dgfRenewLicense = (DgfRenewLicense)session.get(
					DgfRenewLicenseImpl.class,
					dgfRenewLicense.getPrimaryKeyObj());
			}

			if (dgfRenewLicense != null) {
				session.delete(dgfRenewLicense);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgfRenewLicense != null) {
			clearCache(dgfRenewLicense);
		}

		return dgfRenewLicense;
	}

	@Override
	public DgfRenewLicense updateImpl(DgfRenewLicense dgfRenewLicense) {
		boolean isNew = dgfRenewLicense.isNew();

		if (!(dgfRenewLicense instanceof DgfRenewLicenseModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dgfRenewLicense.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dgfRenewLicense);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgfRenewLicense proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DgfRenewLicense implementation " +
					dgfRenewLicense.getClass());
		}

		DgfRenewLicenseModelImpl dgfRenewLicenseModelImpl =
			(DgfRenewLicenseModelImpl)dgfRenewLicense;

		if (!dgfRenewLicenseModelImpl.hasSetModifiedDate()) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				dgfRenewLicense.setModifiedDate(date);
			}
			else {
				dgfRenewLicense.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgfRenewLicense);
			}
			else {
				dgfRenewLicense = (DgfRenewLicense)session.merge(
					dgfRenewLicense);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DgfRenewLicenseImpl.class, dgfRenewLicenseModelImpl, false, true);

		cacheUniqueFindersCache(dgfRenewLicenseModelImpl);

		if (isNew) {
			dgfRenewLicense.setNew(false);
		}

		dgfRenewLicense.resetOriginalValues();

		return dgfRenewLicense;
	}

	/**
	 * Returns the dgf renew license with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dgf renew license
	 * @return the dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a dgf renew license with the primary key could not be found
	 */
	@Override
	public DgfRenewLicense findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDgfRenewLicenseException {

		DgfRenewLicense dgfRenewLicense = fetchByPrimaryKey(primaryKey);

		if (dgfRenewLicense == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDgfRenewLicenseException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgfRenewLicense;
	}

	/**
	 * Returns the dgf renew license with the primary key or throws a <code>NoSuchDgfRenewLicenseException</code> if it could not be found.
	 *
	 * @param renewLicenseId the primary key of the dgf renew license
	 * @return the dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a dgf renew license with the primary key could not be found
	 */
	@Override
	public DgfRenewLicense findByPrimaryKey(long renewLicenseId)
		throws NoSuchDgfRenewLicenseException {

		return findByPrimaryKey((Serializable)renewLicenseId);
	}

	/**
	 * Returns the dgf renew license with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param renewLicenseId the primary key of the dgf renew license
	 * @return the dgf renew license, or <code>null</code> if a dgf renew license with the primary key could not be found
	 */
	@Override
	public DgfRenewLicense fetchByPrimaryKey(long renewLicenseId) {
		return fetchByPrimaryKey((Serializable)renewLicenseId);
	}

	/**
	 * Returns all the dgf renew licenses.
	 *
	 * @return the dgf renew licenses
	 */
	@Override
	public List<DgfRenewLicense> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf renew licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @return the range of dgf renew licenses
	 */
	@Override
	public List<DgfRenewLicense> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf renew licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf renew licenses
	 */
	@Override
	public List<DgfRenewLicense> findAll(
		int start, int end,
		OrderByComparator<DgfRenewLicense> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf renew licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf renew licenses
	 */
	@Override
	public List<DgfRenewLicense> findAll(
		int start, int end,
		OrderByComparator<DgfRenewLicense> orderByComparator,
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

		List<DgfRenewLicense> list = null;

		if (useFinderCache) {
			list = (List<DgfRenewLicense>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFRENEWLICENSE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFRENEWLICENSE;

				sql = sql.concat(DgfRenewLicenseModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DgfRenewLicense>)QueryUtil.list(
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
	 * Removes all the dgf renew licenses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DgfRenewLicense dgfRenewLicense : findAll()) {
			remove(dgfRenewLicense);
		}
	}

	/**
	 * Returns the number of dgf renew licenses.
	 *
	 * @return the number of dgf renew licenses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DGFRENEWLICENSE);

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
		return "renewLicenseId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DGFRENEWLICENSE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DgfRenewLicenseModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dgf renew license persistence.
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

		_finderPathFetchByrenewLicUserIdFinder = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByrenewLicUserIdFinder",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByrenewLicUserIdFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByrenewLicUserIdFinder", new String[] {Long.class.getName()},
			new String[] {"userId"}, false);

		_finderPathFetchByrenewLicNationalIdFinder = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByrenewLicNationalIdFinder",
			new String[] {String.class.getName()}, new String[] {"nationalId"},
			true);

		_finderPathCountByrenewLicNationalIdFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByrenewLicNationalIdFinder",
			new String[] {String.class.getName()}, new String[] {"nationalId"},
			false);

		_finderPathWithPaginationFindByrenewLicNationalIdAndLicenseFinder =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByrenewLicNationalIdAndLicenseFinder",
				new String[] {
					String.class.getName(), String.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"nationalId", "licenseNo"}, true);

		_finderPathWithoutPaginationFindByrenewLicNationalIdAndLicenseFinder =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByrenewLicNationalIdAndLicenseFinder",
				new String[] {String.class.getName(), String.class.getName()},
				new String[] {"nationalId", "licenseNo"}, true);

		_finderPathCountByrenewLicNationalIdAndLicenseFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByrenewLicNationalIdAndLicenseFinder",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"nationalId", "licenseNo"}, false);

		_finderPathFetchByrenewLicTradeLicAttchIdFinder = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByrenewLicTradeLicAttchIdFinder",
			new String[] {Long.class.getName()},
			new String[] {"tradeLicAttchId"}, true);

		_finderPathCountByrenewLicTradeLicAttchIdFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByrenewLicTradeLicAttchIdFinder",
			new String[] {Long.class.getName()},
			new String[] {"tradeLicAttchId"}, false);

		_finderPathFetchByrenewLicPaymentAttchIdFinder = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByrenewLicPaymentAttchIdFinder",
			new String[] {Long.class.getName()},
			new String[] {"paymentAttchId"}, true);

		_finderPathCountByrenewLicPaymentAttchIdFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByrenewLicPaymentAttchIdFinder",
			new String[] {Long.class.getName()},
			new String[] {"paymentAttchId"}, false);

		_finderPathWithPaginationFindByrenewLicFglPrePrimaryIdFinder =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByrenewLicFglPrePrimaryIdFinder",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"fglPrePrimaryId"}, true);

		_finderPathWithoutPaginationFindByrenewLicFglPrePrimaryIdFinder =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByrenewLicFglPrePrimaryIdFinder",
				new String[] {Long.class.getName()},
				new String[] {"fglPrePrimaryId"}, true);

		_finderPathCountByrenewLicFglPrePrimaryIdFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByrenewLicFglPrePrimaryIdFinder",
			new String[] {Long.class.getName()},
			new String[] {"fglPrePrimaryId"}, false);

		_finderPathFetchByrenewLicApplicationNoFinder = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByrenewLicApplicationNoFinder",
			new String[] {String.class.getName()},
			new String[] {"applicationNo"}, true);

		_finderPathCountByrenewLicApplicationNoFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByrenewLicApplicationNoFinder",
			new String[] {String.class.getName()},
			new String[] {"applicationNo"}, false);

		_setDgfRenewLicenseUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDgfRenewLicenseUtilPersistence(null);

		entityCache.removeCache(DgfRenewLicenseImpl.class.getName());
	}

	private void _setDgfRenewLicenseUtilPersistence(
		DgfRenewLicensePersistence dgfRenewLicensePersistence) {

		try {
			Field field = DgfRenewLicenseUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dgfRenewLicensePersistence);
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

	private static final String _SQL_SELECT_DGFRENEWLICENSE =
		"SELECT dgfRenewLicense FROM DgfRenewLicense dgfRenewLicense";

	private static final String _SQL_SELECT_DGFRENEWLICENSE_WHERE =
		"SELECT dgfRenewLicense FROM DgfRenewLicense dgfRenewLicense WHERE ";

	private static final String _SQL_COUNT_DGFRENEWLICENSE =
		"SELECT COUNT(dgfRenewLicense) FROM DgfRenewLicense dgfRenewLicense";

	private static final String _SQL_COUNT_DGFRENEWLICENSE_WHERE =
		"SELECT COUNT(dgfRenewLicense) FROM DgfRenewLicense dgfRenewLicense WHERE ";

	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN =
		"dgfRenewLicense.renewLicenseId";

	private static final String _FILTER_SQL_SELECT_DGFRENEWLICENSE_WHERE =
		"SELECT DISTINCT {dgfRenewLicense.*} FROM dgf_renew_license dgfRenewLicense WHERE ";

	private static final String
		_FILTER_SQL_SELECT_DGFRENEWLICENSE_NO_INLINE_DISTINCT_WHERE_1 =
			"SELECT {dgf_renew_license.*} FROM (SELECT DISTINCT dgfRenewLicense.renewLicenseId FROM dgf_renew_license dgfRenewLicense WHERE ";

	private static final String
		_FILTER_SQL_SELECT_DGFRENEWLICENSE_NO_INLINE_DISTINCT_WHERE_2 =
			") TEMP_TABLE INNER JOIN dgf_renew_license ON TEMP_TABLE.renewLicenseId = dgf_renew_license.renewLicenseId";

	private static final String _FILTER_SQL_COUNT_DGFRENEWLICENSE_WHERE =
		"SELECT COUNT(DISTINCT dgfRenewLicense.renewLicenseId) AS COUNT_VALUE FROM dgf_renew_license dgfRenewLicense WHERE ";

	private static final String _FILTER_ENTITY_ALIAS = "dgfRenewLicense";

	private static final String _FILTER_ENTITY_TABLE = "dgf_renew_license";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dgfRenewLicense.";

	private static final String _ORDER_BY_ENTITY_TABLE = "dgf_renew_license.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DgfRenewLicense exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DgfRenewLicense exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DgfRenewLicensePersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}