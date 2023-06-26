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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfDuplctLicnsReasonException;
import bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason;
import bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReasonTable;
import bd.gov.dgfood.food.grain.license.model.impl.DgfDuplctLicnsReasonImpl;
import bd.gov.dgfood.food.grain.license.model.impl.DgfDuplctLicnsReasonModelImpl;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfDuplctLicnsReasonPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfDuplctLicnsReasonUtil;
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
 * The persistence implementation for the dgf duplct licns reason service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DgfDuplctLicnsReasonPersistence.class)
public class DgfDuplctLicnsReasonPersistenceImpl
	extends BasePersistenceImpl<DgfDuplctLicnsReason>
	implements DgfDuplctLicnsReasonPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DgfDuplctLicnsReasonUtil</code> to access the dgf duplct licns reason persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DgfDuplctLicnsReasonImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByduplicateLicUserIdFinder;
	private FinderPath _finderPathCountByduplicateLicUserIdFinder;

	/**
	 * Returns the dgf duplct licns reason where userId = &#63; or throws a <code>NoSuchDgfDuplctLicnsReasonException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a matching dgf duplct licns reason could not be found
	 */
	@Override
	public DgfDuplctLicnsReason findByduplicateLicUserIdFinder(long userId)
		throws NoSuchDgfDuplctLicnsReasonException {

		DgfDuplctLicnsReason dgfDuplctLicnsReason =
			fetchByduplicateLicUserIdFinder(userId);

		if (dgfDuplctLicnsReason == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("userId=");
			sb.append(userId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfDuplctLicnsReasonException(sb.toString());
		}

		return dgfDuplctLicnsReason;
	}

	/**
	 * Returns the dgf duplct licns reason where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	@Override
	public DgfDuplctLicnsReason fetchByduplicateLicUserIdFinder(long userId) {
		return fetchByduplicateLicUserIdFinder(userId, true);
	}

	/**
	 * Returns the dgf duplct licns reason where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	@Override
	public DgfDuplctLicnsReason fetchByduplicateLicUserIdFinder(
		long userId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {userId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByduplicateLicUserIdFinder, finderArgs, this);
		}

		if (result instanceof DgfDuplctLicnsReason) {
			DgfDuplctLicnsReason dgfDuplctLicnsReason =
				(DgfDuplctLicnsReason)result;

			if (userId != dgfDuplctLicnsReason.getUserId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DGFDUPLCTLICNSREASON_WHERE);

			sb.append(_FINDER_COLUMN_DUPLICATELICUSERIDFINDER_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				List<DgfDuplctLicnsReason> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByduplicateLicUserIdFinder,
							finderArgs, list);
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
								"DgfDuplctLicnsReasonPersistenceImpl.fetchByduplicateLicUserIdFinder(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DgfDuplctLicnsReason dgfDuplctLicnsReason = list.get(0);

					result = dgfDuplctLicnsReason;

					cacheResult(dgfDuplctLicnsReason);
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
			return (DgfDuplctLicnsReason)result;
		}
	}

	/**
	 * Removes the dgf duplct licns reason where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the dgf duplct licns reason that was removed
	 */
	@Override
	public DgfDuplctLicnsReason removeByduplicateLicUserIdFinder(long userId)
		throws NoSuchDgfDuplctLicnsReasonException {

		DgfDuplctLicnsReason dgfDuplctLicnsReason =
			findByduplicateLicUserIdFinder(userId);

		return remove(dgfDuplctLicnsReason);
	}

	/**
	 * Returns the number of dgf duplct licns reasons where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching dgf duplct licns reasons
	 */
	@Override
	public int countByduplicateLicUserIdFinder(long userId) {
		FinderPath finderPath = _finderPathCountByduplicateLicUserIdFinder;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFDUPLCTLICNSREASON_WHERE);

			sb.append(_FINDER_COLUMN_DUPLICATELICUSERIDFINDER_USERID_2);

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

	private static final String
		_FINDER_COLUMN_DUPLICATELICUSERIDFINDER_USERID_2 =
			"dgfDuplctLicnsReason.userId = ?";

	private FinderPath _finderPathFetchByduplicateLicNationalIdFinder;
	private FinderPath _finderPathCountByduplicateLicNationalIdFinder;

	/**
	 * Returns the dgf duplct licns reason where nationalId = &#63; or throws a <code>NoSuchDgfDuplctLicnsReasonException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a matching dgf duplct licns reason could not be found
	 */
	@Override
	public DgfDuplctLicnsReason findByduplicateLicNationalIdFinder(
			String nationalId)
		throws NoSuchDgfDuplctLicnsReasonException {

		DgfDuplctLicnsReason dgfDuplctLicnsReason =
			fetchByduplicateLicNationalIdFinder(nationalId);

		if (dgfDuplctLicnsReason == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("nationalId=");
			sb.append(nationalId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfDuplctLicnsReasonException(sb.toString());
		}

		return dgfDuplctLicnsReason;
	}

	/**
	 * Returns the dgf duplct licns reason where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	@Override
	public DgfDuplctLicnsReason fetchByduplicateLicNationalIdFinder(
		String nationalId) {

		return fetchByduplicateLicNationalIdFinder(nationalId, true);
	}

	/**
	 * Returns the dgf duplct licns reason where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	@Override
	public DgfDuplctLicnsReason fetchByduplicateLicNationalIdFinder(
		String nationalId, boolean useFinderCache) {

		nationalId = Objects.toString(nationalId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {nationalId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByduplicateLicNationalIdFinder, finderArgs,
				this);
		}

		if (result instanceof DgfDuplctLicnsReason) {
			DgfDuplctLicnsReason dgfDuplctLicnsReason =
				(DgfDuplctLicnsReason)result;

			if (!Objects.equals(
					nationalId, dgfDuplctLicnsReason.getNationalId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DGFDUPLCTLICNSREASON_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DUPLICATELICNATIONALIDFINDER_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(
					_FINDER_COLUMN_DUPLICATELICNATIONALIDFINDER_NATIONALID_2);
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

				List<DgfDuplctLicnsReason> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByduplicateLicNationalIdFinder,
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
								"DgfDuplctLicnsReasonPersistenceImpl.fetchByduplicateLicNationalIdFinder(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DgfDuplctLicnsReason dgfDuplctLicnsReason = list.get(0);

					result = dgfDuplctLicnsReason;

					cacheResult(dgfDuplctLicnsReason);
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
			return (DgfDuplctLicnsReason)result;
		}
	}

	/**
	 * Removes the dgf duplct licns reason where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the dgf duplct licns reason that was removed
	 */
	@Override
	public DgfDuplctLicnsReason removeByduplicateLicNationalIdFinder(
			String nationalId)
		throws NoSuchDgfDuplctLicnsReasonException {

		DgfDuplctLicnsReason dgfDuplctLicnsReason =
			findByduplicateLicNationalIdFinder(nationalId);

		return remove(dgfDuplctLicnsReason);
	}

	/**
	 * Returns the number of dgf duplct licns reasons where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf duplct licns reasons
	 */
	@Override
	public int countByduplicateLicNationalIdFinder(String nationalId) {
		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = _finderPathCountByduplicateLicNationalIdFinder;

		Object[] finderArgs = new Object[] {nationalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFDUPLCTLICNSREASON_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DUPLICATELICNATIONALIDFINDER_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(
					_FINDER_COLUMN_DUPLICATELICNATIONALIDFINDER_NATIONALID_2);
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
		_FINDER_COLUMN_DUPLICATELICNATIONALIDFINDER_NATIONALID_2 =
			"dgfDuplctLicnsReason.nationalId = ?";

	private static final String
		_FINDER_COLUMN_DUPLICATELICNATIONALIDFINDER_NATIONALID_3 =
			"(dgfDuplctLicnsReason.nationalId IS NULL OR dgfDuplctLicnsReason.nationalId = '')";

	private FinderPath
		_finderPathWithPaginationFindByduplicateLicNationalIdAndLicenseFinder;
	private FinderPath
		_finderPathWithoutPaginationFindByduplicateLicNationalIdAndLicenseFinder;
	private FinderPath _finderPathCountByduplicateLicNationalIdAndLicenseFinder;

	/**
	 * Returns all the dgf duplct licns reasons where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @return the matching dgf duplct licns reasons
	 */
	@Override
	public List<DgfDuplctLicnsReason>
		findByduplicateLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo) {

		return findByduplicateLicNationalIdAndLicenseFinder(
			nationalId, licenseNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf duplct licns reasons where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @return the range of matching dgf duplct licns reasons
	 */
	@Override
	public List<DgfDuplctLicnsReason>
		findByduplicateLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo, int start, int end) {

		return findByduplicateLicNationalIdAndLicenseFinder(
			nationalId, licenseNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf duplct licns reasons where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf duplct licns reasons
	 */
	@Override
	public List<DgfDuplctLicnsReason>
		findByduplicateLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo, int start, int end,
			OrderByComparator<DgfDuplctLicnsReason> orderByComparator) {

		return findByduplicateLicNationalIdAndLicenseFinder(
			nationalId, licenseNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf duplct licns reasons where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf duplct licns reasons
	 */
	@Override
	public List<DgfDuplctLicnsReason>
		findByduplicateLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo, int start, int end,
			OrderByComparator<DgfDuplctLicnsReason> orderByComparator,
			boolean useFinderCache) {

		nationalId = Objects.toString(nationalId, "");
		licenseNo = Objects.toString(licenseNo, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByduplicateLicNationalIdAndLicenseFinder;
				finderArgs = new Object[] {nationalId, licenseNo};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByduplicateLicNationalIdAndLicenseFinder;
			finderArgs = new Object[] {
				nationalId, licenseNo, start, end, orderByComparator
			};
		}

		List<DgfDuplctLicnsReason> list = null;

		if (useFinderCache) {
			list = (List<DgfDuplctLicnsReason>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfDuplctLicnsReason dgfDuplctLicnsReason : list) {
					if (!nationalId.equals(
							dgfDuplctLicnsReason.getNationalId()) ||
						!licenseNo.equals(
							dgfDuplctLicnsReason.getLicenseNo())) {

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

			sb.append(_SQL_SELECT_DGFDUPLCTLICNSREASON_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DUPLICATELICNATIONALIDANDLICENSEFINDER_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(
					_FINDER_COLUMN_DUPLICATELICNATIONALIDANDLICENSEFINDER_NATIONALID_2);
			}

			boolean bindLicenseNo = false;

			if (licenseNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DUPLICATELICNATIONALIDANDLICENSEFINDER_LICENSENO_3);
			}
			else {
				bindLicenseNo = true;

				sb.append(
					_FINDER_COLUMN_DUPLICATELICNATIONALIDANDLICENSEFINDER_LICENSENO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfDuplctLicnsReasonModelImpl.ORDER_BY_JPQL);
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

				list = (List<DgfDuplctLicnsReason>)QueryUtil.list(
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
	 * Returns the first dgf duplct licns reason in the ordered set where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a matching dgf duplct licns reason could not be found
	 */
	@Override
	public DgfDuplctLicnsReason
			findByduplicateLicNationalIdAndLicenseFinder_First(
				String nationalId, String licenseNo,
				OrderByComparator<DgfDuplctLicnsReason> orderByComparator)
		throws NoSuchDgfDuplctLicnsReasonException {

		DgfDuplctLicnsReason dgfDuplctLicnsReason =
			fetchByduplicateLicNationalIdAndLicenseFinder_First(
				nationalId, licenseNo, orderByComparator);

		if (dgfDuplctLicnsReason != null) {
			return dgfDuplctLicnsReason;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationalId=");
		sb.append(nationalId);

		sb.append(", licenseNo=");
		sb.append(licenseNo);

		sb.append("}");

		throw new NoSuchDgfDuplctLicnsReasonException(sb.toString());
	}

	/**
	 * Returns the first dgf duplct licns reason in the ordered set where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	@Override
	public DgfDuplctLicnsReason
		fetchByduplicateLicNationalIdAndLicenseFinder_First(
			String nationalId, String licenseNo,
			OrderByComparator<DgfDuplctLicnsReason> orderByComparator) {

		List<DgfDuplctLicnsReason> list =
			findByduplicateLicNationalIdAndLicenseFinder(
				nationalId, licenseNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf duplct licns reason in the ordered set where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a matching dgf duplct licns reason could not be found
	 */
	@Override
	public DgfDuplctLicnsReason
			findByduplicateLicNationalIdAndLicenseFinder_Last(
				String nationalId, String licenseNo,
				OrderByComparator<DgfDuplctLicnsReason> orderByComparator)
		throws NoSuchDgfDuplctLicnsReasonException {

		DgfDuplctLicnsReason dgfDuplctLicnsReason =
			fetchByduplicateLicNationalIdAndLicenseFinder_Last(
				nationalId, licenseNo, orderByComparator);

		if (dgfDuplctLicnsReason != null) {
			return dgfDuplctLicnsReason;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationalId=");
		sb.append(nationalId);

		sb.append(", licenseNo=");
		sb.append(licenseNo);

		sb.append("}");

		throw new NoSuchDgfDuplctLicnsReasonException(sb.toString());
	}

	/**
	 * Returns the last dgf duplct licns reason in the ordered set where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	@Override
	public DgfDuplctLicnsReason
		fetchByduplicateLicNationalIdAndLicenseFinder_Last(
			String nationalId, String licenseNo,
			OrderByComparator<DgfDuplctLicnsReason> orderByComparator) {

		int count = countByduplicateLicNationalIdAndLicenseFinder(
			nationalId, licenseNo);

		if (count == 0) {
			return null;
		}

		List<DgfDuplctLicnsReason> list =
			findByduplicateLicNationalIdAndLicenseFinder(
				nationalId, licenseNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf duplct licns reasons before and after the current dgf duplct licns reason in the ordered set where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param duplicateLicenseReasonID the primary key of the current dgf duplct licns reason
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a dgf duplct licns reason with the primary key could not be found
	 */
	@Override
	public DgfDuplctLicnsReason[]
			findByduplicateLicNationalIdAndLicenseFinder_PrevAndNext(
				long duplicateLicenseReasonID, String nationalId,
				String licenseNo,
				OrderByComparator<DgfDuplctLicnsReason> orderByComparator)
		throws NoSuchDgfDuplctLicnsReasonException {

		nationalId = Objects.toString(nationalId, "");
		licenseNo = Objects.toString(licenseNo, "");

		DgfDuplctLicnsReason dgfDuplctLicnsReason = findByPrimaryKey(
			duplicateLicenseReasonID);

		Session session = null;

		try {
			session = openSession();

			DgfDuplctLicnsReason[] array = new DgfDuplctLicnsReasonImpl[3];

			array[0] = getByduplicateLicNationalIdAndLicenseFinder_PrevAndNext(
				session, dgfDuplctLicnsReason, nationalId, licenseNo,
				orderByComparator, true);

			array[1] = dgfDuplctLicnsReason;

			array[2] = getByduplicateLicNationalIdAndLicenseFinder_PrevAndNext(
				session, dgfDuplctLicnsReason, nationalId, licenseNo,
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

	protected DgfDuplctLicnsReason
		getByduplicateLicNationalIdAndLicenseFinder_PrevAndNext(
			Session session, DgfDuplctLicnsReason dgfDuplctLicnsReason,
			String nationalId, String licenseNo,
			OrderByComparator<DgfDuplctLicnsReason> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFDUPLCTLICNSREASON_WHERE);

		boolean bindNationalId = false;

		if (nationalId.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_DUPLICATELICNATIONALIDANDLICENSEFINDER_NATIONALID_3);
		}
		else {
			bindNationalId = true;

			sb.append(
				_FINDER_COLUMN_DUPLICATELICNATIONALIDANDLICENSEFINDER_NATIONALID_2);
		}

		boolean bindLicenseNo = false;

		if (licenseNo.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_DUPLICATELICNATIONALIDANDLICENSEFINDER_LICENSENO_3);
		}
		else {
			bindLicenseNo = true;

			sb.append(
				_FINDER_COLUMN_DUPLICATELICNATIONALIDANDLICENSEFINDER_LICENSENO_2);
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
			sb.append(DgfDuplctLicnsReasonModelImpl.ORDER_BY_JPQL);
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
						dgfDuplctLicnsReason)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfDuplctLicnsReason> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the dgf duplct licns reasons that the user has permission to view where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @return the matching dgf duplct licns reasons that the user has permission to view
	 */
	@Override
	public List<DgfDuplctLicnsReason>
		filterFindByduplicateLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo) {

		return filterFindByduplicateLicNationalIdAndLicenseFinder(
			nationalId, licenseNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf duplct licns reasons that the user has permission to view where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @return the range of matching dgf duplct licns reasons that the user has permission to view
	 */
	@Override
	public List<DgfDuplctLicnsReason>
		filterFindByduplicateLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo, int start, int end) {

		return filterFindByduplicateLicNationalIdAndLicenseFinder(
			nationalId, licenseNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf duplct licns reasons that the user has permissions to view where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf duplct licns reasons that the user has permission to view
	 */
	@Override
	public List<DgfDuplctLicnsReason>
		filterFindByduplicateLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo, int start, int end,
			OrderByComparator<DgfDuplctLicnsReason> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByduplicateLicNationalIdAndLicenseFinder(
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
			sb.append(_FILTER_SQL_SELECT_DGFDUPLCTLICNSREASON_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_DGFDUPLCTLICNSREASON_NO_INLINE_DISTINCT_WHERE_1);
		}

		boolean bindNationalId = false;

		if (nationalId.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_DUPLICATELICNATIONALIDANDLICENSEFINDER_NATIONALID_3);
		}
		else {
			bindNationalId = true;

			sb.append(
				_FINDER_COLUMN_DUPLICATELICNATIONALIDANDLICENSEFINDER_NATIONALID_2);
		}

		boolean bindLicenseNo = false;

		if (licenseNo.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_DUPLICATELICNATIONALIDANDLICENSEFINDER_LICENSENO_3);
		}
		else {
			bindLicenseNo = true;

			sb.append(
				_FINDER_COLUMN_DUPLICATELICNATIONALIDANDLICENSEFINDER_LICENSENO_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_DGFDUPLCTLICNSREASON_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(DgfDuplctLicnsReasonModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DgfDuplctLicnsReasonModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DgfDuplctLicnsReason.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(
					_FILTER_ENTITY_ALIAS, DgfDuplctLicnsReasonImpl.class);
			}
			else {
				sqlQuery.addEntity(
					_FILTER_ENTITY_TABLE, DgfDuplctLicnsReasonImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			if (bindNationalId) {
				queryPos.add(nationalId);
			}

			if (bindLicenseNo) {
				queryPos.add(licenseNo);
			}

			return (List<DgfDuplctLicnsReason>)QueryUtil.list(
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
	 * Returns the dgf duplct licns reasons before and after the current dgf duplct licns reason in the ordered set of dgf duplct licns reasons that the user has permission to view where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param duplicateLicenseReasonID the primary key of the current dgf duplct licns reason
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a dgf duplct licns reason with the primary key could not be found
	 */
	@Override
	public DgfDuplctLicnsReason[]
			filterFindByduplicateLicNationalIdAndLicenseFinder_PrevAndNext(
				long duplicateLicenseReasonID, String nationalId,
				String licenseNo,
				OrderByComparator<DgfDuplctLicnsReason> orderByComparator)
		throws NoSuchDgfDuplctLicnsReasonException {

		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByduplicateLicNationalIdAndLicenseFinder_PrevAndNext(
				duplicateLicenseReasonID, nationalId, licenseNo,
				orderByComparator);
		}

		nationalId = Objects.toString(nationalId, "");
		licenseNo = Objects.toString(licenseNo, "");

		DgfDuplctLicnsReason dgfDuplctLicnsReason = findByPrimaryKey(
			duplicateLicenseReasonID);

		Session session = null;

		try {
			session = openSession();

			DgfDuplctLicnsReason[] array = new DgfDuplctLicnsReasonImpl[3];

			array[0] =
				filterGetByduplicateLicNationalIdAndLicenseFinder_PrevAndNext(
					session, dgfDuplctLicnsReason, nationalId, licenseNo,
					orderByComparator, true);

			array[1] = dgfDuplctLicnsReason;

			array[2] =
				filterGetByduplicateLicNationalIdAndLicenseFinder_PrevAndNext(
					session, dgfDuplctLicnsReason, nationalId, licenseNo,
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

	protected DgfDuplctLicnsReason
		filterGetByduplicateLicNationalIdAndLicenseFinder_PrevAndNext(
			Session session, DgfDuplctLicnsReason dgfDuplctLicnsReason,
			String nationalId, String licenseNo,
			OrderByComparator<DgfDuplctLicnsReason> orderByComparator,
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
			sb.append(_FILTER_SQL_SELECT_DGFDUPLCTLICNSREASON_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_DGFDUPLCTLICNSREASON_NO_INLINE_DISTINCT_WHERE_1);
		}

		boolean bindNationalId = false;

		if (nationalId.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_DUPLICATELICNATIONALIDANDLICENSEFINDER_NATIONALID_3);
		}
		else {
			bindNationalId = true;

			sb.append(
				_FINDER_COLUMN_DUPLICATELICNATIONALIDANDLICENSEFINDER_NATIONALID_2);
		}

		boolean bindLicenseNo = false;

		if (licenseNo.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_DUPLICATELICNATIONALIDANDLICENSEFINDER_LICENSENO_3);
		}
		else {
			bindLicenseNo = true;

			sb.append(
				_FINDER_COLUMN_DUPLICATELICNATIONALIDANDLICENSEFINDER_LICENSENO_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_DGFDUPLCTLICNSREASON_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(DgfDuplctLicnsReasonModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DgfDuplctLicnsReasonModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DgfDuplctLicnsReason.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(
				_FILTER_ENTITY_ALIAS, DgfDuplctLicnsReasonImpl.class);
		}
		else {
			sqlQuery.addEntity(
				_FILTER_ENTITY_TABLE, DgfDuplctLicnsReasonImpl.class);
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
						dgfDuplctLicnsReason)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfDuplctLicnsReason> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf duplct licns reasons where nationalId = &#63; and licenseNo = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 */
	@Override
	public void removeByduplicateLicNationalIdAndLicenseFinder(
		String nationalId, String licenseNo) {

		for (DgfDuplctLicnsReason dgfDuplctLicnsReason :
				findByduplicateLicNationalIdAndLicenseFinder(
					nationalId, licenseNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgfDuplctLicnsReason);
		}
	}

	/**
	 * Returns the number of dgf duplct licns reasons where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @return the number of matching dgf duplct licns reasons
	 */
	@Override
	public int countByduplicateLicNationalIdAndLicenseFinder(
		String nationalId, String licenseNo) {

		nationalId = Objects.toString(nationalId, "");
		licenseNo = Objects.toString(licenseNo, "");

		FinderPath finderPath =
			_finderPathCountByduplicateLicNationalIdAndLicenseFinder;

		Object[] finderArgs = new Object[] {nationalId, licenseNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFDUPLCTLICNSREASON_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DUPLICATELICNATIONALIDANDLICENSEFINDER_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(
					_FINDER_COLUMN_DUPLICATELICNATIONALIDANDLICENSEFINDER_NATIONALID_2);
			}

			boolean bindLicenseNo = false;

			if (licenseNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DUPLICATELICNATIONALIDANDLICENSEFINDER_LICENSENO_3);
			}
			else {
				bindLicenseNo = true;

				sb.append(
					_FINDER_COLUMN_DUPLICATELICNATIONALIDANDLICENSEFINDER_LICENSENO_2);
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
	 * Returns the number of dgf duplct licns reasons that the user has permission to view where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @return the number of matching dgf duplct licns reasons that the user has permission to view
	 */
	@Override
	public int filterCountByduplicateLicNationalIdAndLicenseFinder(
		String nationalId, String licenseNo) {

		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByduplicateLicNationalIdAndLicenseFinder(
				nationalId, licenseNo);
		}

		nationalId = Objects.toString(nationalId, "");
		licenseNo = Objects.toString(licenseNo, "");

		StringBundler sb = new StringBundler(3);

		sb.append(_FILTER_SQL_COUNT_DGFDUPLCTLICNSREASON_WHERE);

		boolean bindNationalId = false;

		if (nationalId.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_DUPLICATELICNATIONALIDANDLICENSEFINDER_NATIONALID_3);
		}
		else {
			bindNationalId = true;

			sb.append(
				_FINDER_COLUMN_DUPLICATELICNATIONALIDANDLICENSEFINDER_NATIONALID_2);
		}

		boolean bindLicenseNo = false;

		if (licenseNo.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_DUPLICATELICNATIONALIDANDLICENSEFINDER_LICENSENO_3);
		}
		else {
			bindLicenseNo = true;

			sb.append(
				_FINDER_COLUMN_DUPLICATELICNATIONALIDANDLICENSEFINDER_LICENSENO_2);
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DgfDuplctLicnsReason.class.getName(),
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
		_FINDER_COLUMN_DUPLICATELICNATIONALIDANDLICENSEFINDER_NATIONALID_2 =
			"dgfDuplctLicnsReason.nationalId = ? AND ";

	private static final String
		_FINDER_COLUMN_DUPLICATELICNATIONALIDANDLICENSEFINDER_NATIONALID_3 =
			"(dgfDuplctLicnsReason.nationalId IS NULL OR dgfDuplctLicnsReason.nationalId = '') AND ";

	private static final String
		_FINDER_COLUMN_DUPLICATELICNATIONALIDANDLICENSEFINDER_LICENSENO_2 =
			"dgfDuplctLicnsReason.licenseNo = ?";

	private static final String
		_FINDER_COLUMN_DUPLICATELICNATIONALIDANDLICENSEFINDER_LICENSENO_3 =
			"(dgfDuplctLicnsReason.licenseNo IS NULL OR dgfDuplctLicnsReason.licenseNo = '')";

	private FinderPath _finderPathFetchByduplicateLicTradeLicAttchIdFinder;
	private FinderPath _finderPathCountByduplicateLicTradeLicAttchIdFinder;

	/**
	 * Returns the dgf duplct licns reason where tradeLicAttchId = &#63; or throws a <code>NoSuchDgfDuplctLicnsReasonException</code> if it could not be found.
	 *
	 * @param tradeLicAttchId the trade lic attch ID
	 * @return the matching dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a matching dgf duplct licns reason could not be found
	 */
	@Override
	public DgfDuplctLicnsReason findByduplicateLicTradeLicAttchIdFinder(
			long tradeLicAttchId)
		throws NoSuchDgfDuplctLicnsReasonException {

		DgfDuplctLicnsReason dgfDuplctLicnsReason =
			fetchByduplicateLicTradeLicAttchIdFinder(tradeLicAttchId);

		if (dgfDuplctLicnsReason == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("tradeLicAttchId=");
			sb.append(tradeLicAttchId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfDuplctLicnsReasonException(sb.toString());
		}

		return dgfDuplctLicnsReason;
	}

	/**
	 * Returns the dgf duplct licns reason where tradeLicAttchId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tradeLicAttchId the trade lic attch ID
	 * @return the matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	@Override
	public DgfDuplctLicnsReason fetchByduplicateLicTradeLicAttchIdFinder(
		long tradeLicAttchId) {

		return fetchByduplicateLicTradeLicAttchIdFinder(tradeLicAttchId, true);
	}

	/**
	 * Returns the dgf duplct licns reason where tradeLicAttchId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tradeLicAttchId the trade lic attch ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	@Override
	public DgfDuplctLicnsReason fetchByduplicateLicTradeLicAttchIdFinder(
		long tradeLicAttchId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {tradeLicAttchId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByduplicateLicTradeLicAttchIdFinder, finderArgs,
				this);
		}

		if (result instanceof DgfDuplctLicnsReason) {
			DgfDuplctLicnsReason dgfDuplctLicnsReason =
				(DgfDuplctLicnsReason)result;

			if (tradeLicAttchId != dgfDuplctLicnsReason.getTradeLicAttchId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DGFDUPLCTLICNSREASON_WHERE);

			sb.append(
				_FINDER_COLUMN_DUPLICATELICTRADELICATTCHIDFINDER_TRADELICATTCHID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tradeLicAttchId);

				List<DgfDuplctLicnsReason> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByduplicateLicTradeLicAttchIdFinder,
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
								"DgfDuplctLicnsReasonPersistenceImpl.fetchByduplicateLicTradeLicAttchIdFinder(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DgfDuplctLicnsReason dgfDuplctLicnsReason = list.get(0);

					result = dgfDuplctLicnsReason;

					cacheResult(dgfDuplctLicnsReason);
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
			return (DgfDuplctLicnsReason)result;
		}
	}

	/**
	 * Removes the dgf duplct licns reason where tradeLicAttchId = &#63; from the database.
	 *
	 * @param tradeLicAttchId the trade lic attch ID
	 * @return the dgf duplct licns reason that was removed
	 */
	@Override
	public DgfDuplctLicnsReason removeByduplicateLicTradeLicAttchIdFinder(
			long tradeLicAttchId)
		throws NoSuchDgfDuplctLicnsReasonException {

		DgfDuplctLicnsReason dgfDuplctLicnsReason =
			findByduplicateLicTradeLicAttchIdFinder(tradeLicAttchId);

		return remove(dgfDuplctLicnsReason);
	}

	/**
	 * Returns the number of dgf duplct licns reasons where tradeLicAttchId = &#63;.
	 *
	 * @param tradeLicAttchId the trade lic attch ID
	 * @return the number of matching dgf duplct licns reasons
	 */
	@Override
	public int countByduplicateLicTradeLicAttchIdFinder(long tradeLicAttchId) {
		FinderPath finderPath =
			_finderPathCountByduplicateLicTradeLicAttchIdFinder;

		Object[] finderArgs = new Object[] {tradeLicAttchId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFDUPLCTLICNSREASON_WHERE);

			sb.append(
				_FINDER_COLUMN_DUPLICATELICTRADELICATTCHIDFINDER_TRADELICATTCHID_2);

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
		_FINDER_COLUMN_DUPLICATELICTRADELICATTCHIDFINDER_TRADELICATTCHID_2 =
			"dgfDuplctLicnsReason.tradeLicAttchId = ?";

	private FinderPath _finderPathFetchByduplicateLicPaymentAttchIdFinder;
	private FinderPath _finderPathCountByduplicateLicPaymentAttchIdFinder;

	/**
	 * Returns the dgf duplct licns reason where paymentAttchId = &#63; or throws a <code>NoSuchDgfDuplctLicnsReasonException</code> if it could not be found.
	 *
	 * @param paymentAttchId the payment attch ID
	 * @return the matching dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a matching dgf duplct licns reason could not be found
	 */
	@Override
	public DgfDuplctLicnsReason findByduplicateLicPaymentAttchIdFinder(
			long paymentAttchId)
		throws NoSuchDgfDuplctLicnsReasonException {

		DgfDuplctLicnsReason dgfDuplctLicnsReason =
			fetchByduplicateLicPaymentAttchIdFinder(paymentAttchId);

		if (dgfDuplctLicnsReason == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("paymentAttchId=");
			sb.append(paymentAttchId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfDuplctLicnsReasonException(sb.toString());
		}

		return dgfDuplctLicnsReason;
	}

	/**
	 * Returns the dgf duplct licns reason where paymentAttchId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param paymentAttchId the payment attch ID
	 * @return the matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	@Override
	public DgfDuplctLicnsReason fetchByduplicateLicPaymentAttchIdFinder(
		long paymentAttchId) {

		return fetchByduplicateLicPaymentAttchIdFinder(paymentAttchId, true);
	}

	/**
	 * Returns the dgf duplct licns reason where paymentAttchId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param paymentAttchId the payment attch ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	@Override
	public DgfDuplctLicnsReason fetchByduplicateLicPaymentAttchIdFinder(
		long paymentAttchId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {paymentAttchId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByduplicateLicPaymentAttchIdFinder, finderArgs,
				this);
		}

		if (result instanceof DgfDuplctLicnsReason) {
			DgfDuplctLicnsReason dgfDuplctLicnsReason =
				(DgfDuplctLicnsReason)result;

			if (paymentAttchId != dgfDuplctLicnsReason.getPaymentAttchId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DGFDUPLCTLICNSREASON_WHERE);

			sb.append(
				_FINDER_COLUMN_DUPLICATELICPAYMENTATTCHIDFINDER_PAYMENTATTCHID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(paymentAttchId);

				List<DgfDuplctLicnsReason> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByduplicateLicPaymentAttchIdFinder,
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
								"DgfDuplctLicnsReasonPersistenceImpl.fetchByduplicateLicPaymentAttchIdFinder(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DgfDuplctLicnsReason dgfDuplctLicnsReason = list.get(0);

					result = dgfDuplctLicnsReason;

					cacheResult(dgfDuplctLicnsReason);
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
			return (DgfDuplctLicnsReason)result;
		}
	}

	/**
	 * Removes the dgf duplct licns reason where paymentAttchId = &#63; from the database.
	 *
	 * @param paymentAttchId the payment attch ID
	 * @return the dgf duplct licns reason that was removed
	 */
	@Override
	public DgfDuplctLicnsReason removeByduplicateLicPaymentAttchIdFinder(
			long paymentAttchId)
		throws NoSuchDgfDuplctLicnsReasonException {

		DgfDuplctLicnsReason dgfDuplctLicnsReason =
			findByduplicateLicPaymentAttchIdFinder(paymentAttchId);

		return remove(dgfDuplctLicnsReason);
	}

	/**
	 * Returns the number of dgf duplct licns reasons where paymentAttchId = &#63;.
	 *
	 * @param paymentAttchId the payment attch ID
	 * @return the number of matching dgf duplct licns reasons
	 */
	@Override
	public int countByduplicateLicPaymentAttchIdFinder(long paymentAttchId) {
		FinderPath finderPath =
			_finderPathCountByduplicateLicPaymentAttchIdFinder;

		Object[] finderArgs = new Object[] {paymentAttchId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFDUPLCTLICNSREASON_WHERE);

			sb.append(
				_FINDER_COLUMN_DUPLICATELICPAYMENTATTCHIDFINDER_PAYMENTATTCHID_2);

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
		_FINDER_COLUMN_DUPLICATELICPAYMENTATTCHIDFINDER_PAYMENTATTCHID_2 =
			"dgfDuplctLicnsReason.paymentAttchId = ?";

	private FinderPath
		_finderPathWithPaginationFindByduplicateLicFglPrePrimaryIdFinder;
	private FinderPath
		_finderPathWithoutPaginationFindByduplicateLicFglPrePrimaryIdFinder;
	private FinderPath _finderPathCountByduplicateLicFglPrePrimaryIdFinder;

	/**
	 * Returns all the dgf duplct licns reasons where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the matching dgf duplct licns reasons
	 */
	@Override
	public List<DgfDuplctLicnsReason> findByduplicateLicFglPrePrimaryIdFinder(
		long fglPrePrimaryId) {

		return findByduplicateLicFglPrePrimaryIdFinder(
			fglPrePrimaryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf duplct licns reasons where fglPrePrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @return the range of matching dgf duplct licns reasons
	 */
	@Override
	public List<DgfDuplctLicnsReason> findByduplicateLicFglPrePrimaryIdFinder(
		long fglPrePrimaryId, int start, int end) {

		return findByduplicateLicFglPrePrimaryIdFinder(
			fglPrePrimaryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf duplct licns reasons where fglPrePrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf duplct licns reasons
	 */
	@Override
	public List<DgfDuplctLicnsReason> findByduplicateLicFglPrePrimaryIdFinder(
		long fglPrePrimaryId, int start, int end,
		OrderByComparator<DgfDuplctLicnsReason> orderByComparator) {

		return findByduplicateLicFglPrePrimaryIdFinder(
			fglPrePrimaryId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf duplct licns reasons where fglPrePrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf duplct licns reasons
	 */
	@Override
	public List<DgfDuplctLicnsReason> findByduplicateLicFglPrePrimaryIdFinder(
		long fglPrePrimaryId, int start, int end,
		OrderByComparator<DgfDuplctLicnsReason> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByduplicateLicFglPrePrimaryIdFinder;
				finderArgs = new Object[] {fglPrePrimaryId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByduplicateLicFglPrePrimaryIdFinder;
			finderArgs = new Object[] {
				fglPrePrimaryId, start, end, orderByComparator
			};
		}

		List<DgfDuplctLicnsReason> list = null;

		if (useFinderCache) {
			list = (List<DgfDuplctLicnsReason>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfDuplctLicnsReason dgfDuplctLicnsReason : list) {
					if (fglPrePrimaryId !=
							dgfDuplctLicnsReason.getFglPrePrimaryId()) {

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

			sb.append(_SQL_SELECT_DGFDUPLCTLICNSREASON_WHERE);

			sb.append(
				_FINDER_COLUMN_DUPLICATELICFGLPREPRIMARYIDFINDER_FGLPREPRIMARYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfDuplctLicnsReasonModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fglPrePrimaryId);

				list = (List<DgfDuplctLicnsReason>)QueryUtil.list(
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
	 * Returns the first dgf duplct licns reason in the ordered set where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a matching dgf duplct licns reason could not be found
	 */
	@Override
	public DgfDuplctLicnsReason findByduplicateLicFglPrePrimaryIdFinder_First(
			long fglPrePrimaryId,
			OrderByComparator<DgfDuplctLicnsReason> orderByComparator)
		throws NoSuchDgfDuplctLicnsReasonException {

		DgfDuplctLicnsReason dgfDuplctLicnsReason =
			fetchByduplicateLicFglPrePrimaryIdFinder_First(
				fglPrePrimaryId, orderByComparator);

		if (dgfDuplctLicnsReason != null) {
			return dgfDuplctLicnsReason;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fglPrePrimaryId=");
		sb.append(fglPrePrimaryId);

		sb.append("}");

		throw new NoSuchDgfDuplctLicnsReasonException(sb.toString());
	}

	/**
	 * Returns the first dgf duplct licns reason in the ordered set where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	@Override
	public DgfDuplctLicnsReason fetchByduplicateLicFglPrePrimaryIdFinder_First(
		long fglPrePrimaryId,
		OrderByComparator<DgfDuplctLicnsReason> orderByComparator) {

		List<DgfDuplctLicnsReason> list =
			findByduplicateLicFglPrePrimaryIdFinder(
				fglPrePrimaryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf duplct licns reason in the ordered set where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a matching dgf duplct licns reason could not be found
	 */
	@Override
	public DgfDuplctLicnsReason findByduplicateLicFglPrePrimaryIdFinder_Last(
			long fglPrePrimaryId,
			OrderByComparator<DgfDuplctLicnsReason> orderByComparator)
		throws NoSuchDgfDuplctLicnsReasonException {

		DgfDuplctLicnsReason dgfDuplctLicnsReason =
			fetchByduplicateLicFglPrePrimaryIdFinder_Last(
				fglPrePrimaryId, orderByComparator);

		if (dgfDuplctLicnsReason != null) {
			return dgfDuplctLicnsReason;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fglPrePrimaryId=");
		sb.append(fglPrePrimaryId);

		sb.append("}");

		throw new NoSuchDgfDuplctLicnsReasonException(sb.toString());
	}

	/**
	 * Returns the last dgf duplct licns reason in the ordered set where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	@Override
	public DgfDuplctLicnsReason fetchByduplicateLicFglPrePrimaryIdFinder_Last(
		long fglPrePrimaryId,
		OrderByComparator<DgfDuplctLicnsReason> orderByComparator) {

		int count = countByduplicateLicFglPrePrimaryIdFinder(fglPrePrimaryId);

		if (count == 0) {
			return null;
		}

		List<DgfDuplctLicnsReason> list =
			findByduplicateLicFglPrePrimaryIdFinder(
				fglPrePrimaryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf duplct licns reasons before and after the current dgf duplct licns reason in the ordered set where fglPrePrimaryId = &#63;.
	 *
	 * @param duplicateLicenseReasonID the primary key of the current dgf duplct licns reason
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a dgf duplct licns reason with the primary key could not be found
	 */
	@Override
	public DgfDuplctLicnsReason[]
			findByduplicateLicFglPrePrimaryIdFinder_PrevAndNext(
				long duplicateLicenseReasonID, long fglPrePrimaryId,
				OrderByComparator<DgfDuplctLicnsReason> orderByComparator)
		throws NoSuchDgfDuplctLicnsReasonException {

		DgfDuplctLicnsReason dgfDuplctLicnsReason = findByPrimaryKey(
			duplicateLicenseReasonID);

		Session session = null;

		try {
			session = openSession();

			DgfDuplctLicnsReason[] array = new DgfDuplctLicnsReasonImpl[3];

			array[0] = getByduplicateLicFglPrePrimaryIdFinder_PrevAndNext(
				session, dgfDuplctLicnsReason, fglPrePrimaryId,
				orderByComparator, true);

			array[1] = dgfDuplctLicnsReason;

			array[2] = getByduplicateLicFglPrePrimaryIdFinder_PrevAndNext(
				session, dgfDuplctLicnsReason, fglPrePrimaryId,
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

	protected DgfDuplctLicnsReason
		getByduplicateLicFglPrePrimaryIdFinder_PrevAndNext(
			Session session, DgfDuplctLicnsReason dgfDuplctLicnsReason,
			long fglPrePrimaryId,
			OrderByComparator<DgfDuplctLicnsReason> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFDUPLCTLICNSREASON_WHERE);

		sb.append(
			_FINDER_COLUMN_DUPLICATELICFGLPREPRIMARYIDFINDER_FGLPREPRIMARYID_2);

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
			sb.append(DgfDuplctLicnsReasonModelImpl.ORDER_BY_JPQL);
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
						dgfDuplctLicnsReason)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfDuplctLicnsReason> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the dgf duplct licns reasons that the user has permission to view where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the matching dgf duplct licns reasons that the user has permission to view
	 */
	@Override
	public List<DgfDuplctLicnsReason>
		filterFindByduplicateLicFglPrePrimaryIdFinder(long fglPrePrimaryId) {

		return filterFindByduplicateLicFglPrePrimaryIdFinder(
			fglPrePrimaryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf duplct licns reasons that the user has permission to view where fglPrePrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @return the range of matching dgf duplct licns reasons that the user has permission to view
	 */
	@Override
	public List<DgfDuplctLicnsReason>
		filterFindByduplicateLicFglPrePrimaryIdFinder(
			long fglPrePrimaryId, int start, int end) {

		return filterFindByduplicateLicFglPrePrimaryIdFinder(
			fglPrePrimaryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf duplct licns reasons that the user has permissions to view where fglPrePrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf duplct licns reasons that the user has permission to view
	 */
	@Override
	public List<DgfDuplctLicnsReason>
		filterFindByduplicateLicFglPrePrimaryIdFinder(
			long fglPrePrimaryId, int start, int end,
			OrderByComparator<DgfDuplctLicnsReason> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByduplicateLicFglPrePrimaryIdFinder(
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
			sb.append(_FILTER_SQL_SELECT_DGFDUPLCTLICNSREASON_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_DGFDUPLCTLICNSREASON_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(
			_FINDER_COLUMN_DUPLICATELICFGLPREPRIMARYIDFINDER_FGLPREPRIMARYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_DGFDUPLCTLICNSREASON_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(DgfDuplctLicnsReasonModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DgfDuplctLicnsReasonModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DgfDuplctLicnsReason.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(
					_FILTER_ENTITY_ALIAS, DgfDuplctLicnsReasonImpl.class);
			}
			else {
				sqlQuery.addEntity(
					_FILTER_ENTITY_TABLE, DgfDuplctLicnsReasonImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(fglPrePrimaryId);

			return (List<DgfDuplctLicnsReason>)QueryUtil.list(
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
	 * Returns the dgf duplct licns reasons before and after the current dgf duplct licns reason in the ordered set of dgf duplct licns reasons that the user has permission to view where fglPrePrimaryId = &#63;.
	 *
	 * @param duplicateLicenseReasonID the primary key of the current dgf duplct licns reason
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a dgf duplct licns reason with the primary key could not be found
	 */
	@Override
	public DgfDuplctLicnsReason[]
			filterFindByduplicateLicFglPrePrimaryIdFinder_PrevAndNext(
				long duplicateLicenseReasonID, long fglPrePrimaryId,
				OrderByComparator<DgfDuplctLicnsReason> orderByComparator)
		throws NoSuchDgfDuplctLicnsReasonException {

		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByduplicateLicFglPrePrimaryIdFinder_PrevAndNext(
				duplicateLicenseReasonID, fglPrePrimaryId, orderByComparator);
		}

		DgfDuplctLicnsReason dgfDuplctLicnsReason = findByPrimaryKey(
			duplicateLicenseReasonID);

		Session session = null;

		try {
			session = openSession();

			DgfDuplctLicnsReason[] array = new DgfDuplctLicnsReasonImpl[3];

			array[0] = filterGetByduplicateLicFglPrePrimaryIdFinder_PrevAndNext(
				session, dgfDuplctLicnsReason, fglPrePrimaryId,
				orderByComparator, true);

			array[1] = dgfDuplctLicnsReason;

			array[2] = filterGetByduplicateLicFglPrePrimaryIdFinder_PrevAndNext(
				session, dgfDuplctLicnsReason, fglPrePrimaryId,
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

	protected DgfDuplctLicnsReason
		filterGetByduplicateLicFglPrePrimaryIdFinder_PrevAndNext(
			Session session, DgfDuplctLicnsReason dgfDuplctLicnsReason,
			long fglPrePrimaryId,
			OrderByComparator<DgfDuplctLicnsReason> orderByComparator,
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
			sb.append(_FILTER_SQL_SELECT_DGFDUPLCTLICNSREASON_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_DGFDUPLCTLICNSREASON_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(
			_FINDER_COLUMN_DUPLICATELICFGLPREPRIMARYIDFINDER_FGLPREPRIMARYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_DGFDUPLCTLICNSREASON_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(DgfDuplctLicnsReasonModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DgfDuplctLicnsReasonModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DgfDuplctLicnsReason.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(
				_FILTER_ENTITY_ALIAS, DgfDuplctLicnsReasonImpl.class);
		}
		else {
			sqlQuery.addEntity(
				_FILTER_ENTITY_TABLE, DgfDuplctLicnsReasonImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(fglPrePrimaryId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfDuplctLicnsReason)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfDuplctLicnsReason> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf duplct licns reasons where fglPrePrimaryId = &#63; from the database.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 */
	@Override
	public void removeByduplicateLicFglPrePrimaryIdFinder(
		long fglPrePrimaryId) {

		for (DgfDuplctLicnsReason dgfDuplctLicnsReason :
				findByduplicateLicFglPrePrimaryIdFinder(
					fglPrePrimaryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgfDuplctLicnsReason);
		}
	}

	/**
	 * Returns the number of dgf duplct licns reasons where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the number of matching dgf duplct licns reasons
	 */
	@Override
	public int countByduplicateLicFglPrePrimaryIdFinder(long fglPrePrimaryId) {
		FinderPath finderPath =
			_finderPathCountByduplicateLicFglPrePrimaryIdFinder;

		Object[] finderArgs = new Object[] {fglPrePrimaryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFDUPLCTLICNSREASON_WHERE);

			sb.append(
				_FINDER_COLUMN_DUPLICATELICFGLPREPRIMARYIDFINDER_FGLPREPRIMARYID_2);

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
	 * Returns the number of dgf duplct licns reasons that the user has permission to view where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the number of matching dgf duplct licns reasons that the user has permission to view
	 */
	@Override
	public int filterCountByduplicateLicFglPrePrimaryIdFinder(
		long fglPrePrimaryId) {

		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByduplicateLicFglPrePrimaryIdFinder(fglPrePrimaryId);
		}

		StringBundler sb = new StringBundler(2);

		sb.append(_FILTER_SQL_COUNT_DGFDUPLCTLICNSREASON_WHERE);

		sb.append(
			_FINDER_COLUMN_DUPLICATELICFGLPREPRIMARYIDFINDER_FGLPREPRIMARYID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DgfDuplctLicnsReason.class.getName(),
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
		_FINDER_COLUMN_DUPLICATELICFGLPREPRIMARYIDFINDER_FGLPREPRIMARYID_2 =
			"dgfDuplctLicnsReason.fglPrePrimaryId = ?";

	private FinderPath _finderPathFetchByduplicateLicApplicationNoFinder;
	private FinderPath _finderPathCountByduplicateLicApplicationNoFinder;

	/**
	 * Returns the dgf duplct licns reason where applicationNo = &#63; or throws a <code>NoSuchDgfDuplctLicnsReasonException</code> if it could not be found.
	 *
	 * @param applicationNo the application no
	 * @return the matching dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a matching dgf duplct licns reason could not be found
	 */
	@Override
	public DgfDuplctLicnsReason findByduplicateLicApplicationNoFinder(
			String applicationNo)
		throws NoSuchDgfDuplctLicnsReasonException {

		DgfDuplctLicnsReason dgfDuplctLicnsReason =
			fetchByduplicateLicApplicationNoFinder(applicationNo);

		if (dgfDuplctLicnsReason == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("applicationNo=");
			sb.append(applicationNo);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfDuplctLicnsReasonException(sb.toString());
		}

		return dgfDuplctLicnsReason;
	}

	/**
	 * Returns the dgf duplct licns reason where applicationNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param applicationNo the application no
	 * @return the matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	@Override
	public DgfDuplctLicnsReason fetchByduplicateLicApplicationNoFinder(
		String applicationNo) {

		return fetchByduplicateLicApplicationNoFinder(applicationNo, true);
	}

	/**
	 * Returns the dgf duplct licns reason where applicationNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param applicationNo the application no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	@Override
	public DgfDuplctLicnsReason fetchByduplicateLicApplicationNoFinder(
		String applicationNo, boolean useFinderCache) {

		applicationNo = Objects.toString(applicationNo, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {applicationNo};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByduplicateLicApplicationNoFinder, finderArgs,
				this);
		}

		if (result instanceof DgfDuplctLicnsReason) {
			DgfDuplctLicnsReason dgfDuplctLicnsReason =
				(DgfDuplctLicnsReason)result;

			if (!Objects.equals(
					applicationNo, dgfDuplctLicnsReason.getApplicationNo())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DGFDUPLCTLICNSREASON_WHERE);

			boolean bindApplicationNo = false;

			if (applicationNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DUPLICATELICAPPLICATIONNOFINDER_APPLICATIONNO_3);
			}
			else {
				bindApplicationNo = true;

				sb.append(
					_FINDER_COLUMN_DUPLICATELICAPPLICATIONNOFINDER_APPLICATIONNO_2);
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

				List<DgfDuplctLicnsReason> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByduplicateLicApplicationNoFinder,
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
								"DgfDuplctLicnsReasonPersistenceImpl.fetchByduplicateLicApplicationNoFinder(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DgfDuplctLicnsReason dgfDuplctLicnsReason = list.get(0);

					result = dgfDuplctLicnsReason;

					cacheResult(dgfDuplctLicnsReason);
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
			return (DgfDuplctLicnsReason)result;
		}
	}

	/**
	 * Removes the dgf duplct licns reason where applicationNo = &#63; from the database.
	 *
	 * @param applicationNo the application no
	 * @return the dgf duplct licns reason that was removed
	 */
	@Override
	public DgfDuplctLicnsReason removeByduplicateLicApplicationNoFinder(
			String applicationNo)
		throws NoSuchDgfDuplctLicnsReasonException {

		DgfDuplctLicnsReason dgfDuplctLicnsReason =
			findByduplicateLicApplicationNoFinder(applicationNo);

		return remove(dgfDuplctLicnsReason);
	}

	/**
	 * Returns the number of dgf duplct licns reasons where applicationNo = &#63;.
	 *
	 * @param applicationNo the application no
	 * @return the number of matching dgf duplct licns reasons
	 */
	@Override
	public int countByduplicateLicApplicationNoFinder(String applicationNo) {
		applicationNo = Objects.toString(applicationNo, "");

		FinderPath finderPath =
			_finderPathCountByduplicateLicApplicationNoFinder;

		Object[] finderArgs = new Object[] {applicationNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFDUPLCTLICNSREASON_WHERE);

			boolean bindApplicationNo = false;

			if (applicationNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DUPLICATELICAPPLICATIONNOFINDER_APPLICATIONNO_3);
			}
			else {
				bindApplicationNo = true;

				sb.append(
					_FINDER_COLUMN_DUPLICATELICAPPLICATIONNOFINDER_APPLICATIONNO_2);
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
		_FINDER_COLUMN_DUPLICATELICAPPLICATIONNOFINDER_APPLICATIONNO_2 =
			"dgfDuplctLicnsReason.applicationNo = ?";

	private static final String
		_FINDER_COLUMN_DUPLICATELICAPPLICATIONNOFINDER_APPLICATIONNO_3 =
			"(dgfDuplctLicnsReason.applicationNo IS NULL OR dgfDuplctLicnsReason.applicationNo = '')";

	public DgfDuplctLicnsReasonPersistenceImpl() {
		setModelClass(DgfDuplctLicnsReason.class);

		setModelImplClass(DgfDuplctLicnsReasonImpl.class);
		setModelPKClass(long.class);

		setTable(DgfDuplctLicnsReasonTable.INSTANCE);
	}

	/**
	 * Caches the dgf duplct licns reason in the entity cache if it is enabled.
	 *
	 * @param dgfDuplctLicnsReason the dgf duplct licns reason
	 */
	@Override
	public void cacheResult(DgfDuplctLicnsReason dgfDuplctLicnsReason) {
		entityCache.putResult(
			DgfDuplctLicnsReasonImpl.class,
			dgfDuplctLicnsReason.getPrimaryKey(), dgfDuplctLicnsReason);

		finderCache.putResult(
			_finderPathFetchByduplicateLicUserIdFinder,
			new Object[] {dgfDuplctLicnsReason.getUserId()},
			dgfDuplctLicnsReason);

		finderCache.putResult(
			_finderPathFetchByduplicateLicNationalIdFinder,
			new Object[] {dgfDuplctLicnsReason.getNationalId()},
			dgfDuplctLicnsReason);

		finderCache.putResult(
			_finderPathFetchByduplicateLicTradeLicAttchIdFinder,
			new Object[] {dgfDuplctLicnsReason.getTradeLicAttchId()},
			dgfDuplctLicnsReason);

		finderCache.putResult(
			_finderPathFetchByduplicateLicPaymentAttchIdFinder,
			new Object[] {dgfDuplctLicnsReason.getPaymentAttchId()},
			dgfDuplctLicnsReason);

		finderCache.putResult(
			_finderPathFetchByduplicateLicApplicationNoFinder,
			new Object[] {dgfDuplctLicnsReason.getApplicationNo()},
			dgfDuplctLicnsReason);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dgf duplct licns reasons in the entity cache if it is enabled.
	 *
	 * @param dgfDuplctLicnsReasons the dgf duplct licns reasons
	 */
	@Override
	public void cacheResult(List<DgfDuplctLicnsReason> dgfDuplctLicnsReasons) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgfDuplctLicnsReasons.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DgfDuplctLicnsReason dgfDuplctLicnsReason :
				dgfDuplctLicnsReasons) {

			if (entityCache.getResult(
					DgfDuplctLicnsReasonImpl.class,
					dgfDuplctLicnsReason.getPrimaryKey()) == null) {

				cacheResult(dgfDuplctLicnsReason);
			}
		}
	}

	/**
	 * Clears the cache for all dgf duplct licns reasons.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DgfDuplctLicnsReasonImpl.class);

		finderCache.clearCache(DgfDuplctLicnsReasonImpl.class);
	}

	/**
	 * Clears the cache for the dgf duplct licns reason.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DgfDuplctLicnsReason dgfDuplctLicnsReason) {
		entityCache.removeResult(
			DgfDuplctLicnsReasonImpl.class, dgfDuplctLicnsReason);
	}

	@Override
	public void clearCache(List<DgfDuplctLicnsReason> dgfDuplctLicnsReasons) {
		for (DgfDuplctLicnsReason dgfDuplctLicnsReason :
				dgfDuplctLicnsReasons) {

			entityCache.removeResult(
				DgfDuplctLicnsReasonImpl.class, dgfDuplctLicnsReason);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DgfDuplctLicnsReasonImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				DgfDuplctLicnsReasonImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DgfDuplctLicnsReasonModelImpl dgfDuplctLicnsReasonModelImpl) {

		Object[] args = new Object[] {
			dgfDuplctLicnsReasonModelImpl.getUserId()
		};

		finderCache.putResult(
			_finderPathCountByduplicateLicUserIdFinder, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByduplicateLicUserIdFinder, args,
			dgfDuplctLicnsReasonModelImpl);

		args = new Object[] {dgfDuplctLicnsReasonModelImpl.getNationalId()};

		finderCache.putResult(
			_finderPathCountByduplicateLicNationalIdFinder, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByduplicateLicNationalIdFinder, args,
			dgfDuplctLicnsReasonModelImpl);

		args = new Object[] {
			dgfDuplctLicnsReasonModelImpl.getTradeLicAttchId()
		};

		finderCache.putResult(
			_finderPathCountByduplicateLicTradeLicAttchIdFinder, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByduplicateLicTradeLicAttchIdFinder, args,
			dgfDuplctLicnsReasonModelImpl);

		args = new Object[] {dgfDuplctLicnsReasonModelImpl.getPaymentAttchId()};

		finderCache.putResult(
			_finderPathCountByduplicateLicPaymentAttchIdFinder, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByduplicateLicPaymentAttchIdFinder, args,
			dgfDuplctLicnsReasonModelImpl);

		args = new Object[] {dgfDuplctLicnsReasonModelImpl.getApplicationNo()};

		finderCache.putResult(
			_finderPathCountByduplicateLicApplicationNoFinder, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByduplicateLicApplicationNoFinder, args,
			dgfDuplctLicnsReasonModelImpl);
	}

	/**
	 * Creates a new dgf duplct licns reason with the primary key. Does not add the dgf duplct licns reason to the database.
	 *
	 * @param duplicateLicenseReasonID the primary key for the new dgf duplct licns reason
	 * @return the new dgf duplct licns reason
	 */
	@Override
	public DgfDuplctLicnsReason create(long duplicateLicenseReasonID) {
		DgfDuplctLicnsReason dgfDuplctLicnsReason =
			new DgfDuplctLicnsReasonImpl();

		dgfDuplctLicnsReason.setNew(true);
		dgfDuplctLicnsReason.setPrimaryKey(duplicateLicenseReasonID);

		return dgfDuplctLicnsReason;
	}

	/**
	 * Removes the dgf duplct licns reason with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param duplicateLicenseReasonID the primary key of the dgf duplct licns reason
	 * @return the dgf duplct licns reason that was removed
	 * @throws NoSuchDgfDuplctLicnsReasonException if a dgf duplct licns reason with the primary key could not be found
	 */
	@Override
	public DgfDuplctLicnsReason remove(long duplicateLicenseReasonID)
		throws NoSuchDgfDuplctLicnsReasonException {

		return remove((Serializable)duplicateLicenseReasonID);
	}

	/**
	 * Removes the dgf duplct licns reason with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dgf duplct licns reason
	 * @return the dgf duplct licns reason that was removed
	 * @throws NoSuchDgfDuplctLicnsReasonException if a dgf duplct licns reason with the primary key could not be found
	 */
	@Override
	public DgfDuplctLicnsReason remove(Serializable primaryKey)
		throws NoSuchDgfDuplctLicnsReasonException {

		Session session = null;

		try {
			session = openSession();

			DgfDuplctLicnsReason dgfDuplctLicnsReason =
				(DgfDuplctLicnsReason)session.get(
					DgfDuplctLicnsReasonImpl.class, primaryKey);

			if (dgfDuplctLicnsReason == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDgfDuplctLicnsReasonException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgfDuplctLicnsReason);
		}
		catch (NoSuchDgfDuplctLicnsReasonException noSuchEntityException) {
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
	protected DgfDuplctLicnsReason removeImpl(
		DgfDuplctLicnsReason dgfDuplctLicnsReason) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgfDuplctLicnsReason)) {
				dgfDuplctLicnsReason = (DgfDuplctLicnsReason)session.get(
					DgfDuplctLicnsReasonImpl.class,
					dgfDuplctLicnsReason.getPrimaryKeyObj());
			}

			if (dgfDuplctLicnsReason != null) {
				session.delete(dgfDuplctLicnsReason);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgfDuplctLicnsReason != null) {
			clearCache(dgfDuplctLicnsReason);
		}

		return dgfDuplctLicnsReason;
	}

	@Override
	public DgfDuplctLicnsReason updateImpl(
		DgfDuplctLicnsReason dgfDuplctLicnsReason) {

		boolean isNew = dgfDuplctLicnsReason.isNew();

		if (!(dgfDuplctLicnsReason instanceof DgfDuplctLicnsReasonModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dgfDuplctLicnsReason.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dgfDuplctLicnsReason);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgfDuplctLicnsReason proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DgfDuplctLicnsReason implementation " +
					dgfDuplctLicnsReason.getClass());
		}

		DgfDuplctLicnsReasonModelImpl dgfDuplctLicnsReasonModelImpl =
			(DgfDuplctLicnsReasonModelImpl)dgfDuplctLicnsReason;

		if (!dgfDuplctLicnsReasonModelImpl.hasSetModifiedDate()) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				dgfDuplctLicnsReason.setModifiedDate(date);
			}
			else {
				dgfDuplctLicnsReason.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgfDuplctLicnsReason);
			}
			else {
				dgfDuplctLicnsReason = (DgfDuplctLicnsReason)session.merge(
					dgfDuplctLicnsReason);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DgfDuplctLicnsReasonImpl.class, dgfDuplctLicnsReasonModelImpl,
			false, true);

		cacheUniqueFindersCache(dgfDuplctLicnsReasonModelImpl);

		if (isNew) {
			dgfDuplctLicnsReason.setNew(false);
		}

		dgfDuplctLicnsReason.resetOriginalValues();

		return dgfDuplctLicnsReason;
	}

	/**
	 * Returns the dgf duplct licns reason with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dgf duplct licns reason
	 * @return the dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a dgf duplct licns reason with the primary key could not be found
	 */
	@Override
	public DgfDuplctLicnsReason findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDgfDuplctLicnsReasonException {

		DgfDuplctLicnsReason dgfDuplctLicnsReason = fetchByPrimaryKey(
			primaryKey);

		if (dgfDuplctLicnsReason == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDgfDuplctLicnsReasonException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgfDuplctLicnsReason;
	}

	/**
	 * Returns the dgf duplct licns reason with the primary key or throws a <code>NoSuchDgfDuplctLicnsReasonException</code> if it could not be found.
	 *
	 * @param duplicateLicenseReasonID the primary key of the dgf duplct licns reason
	 * @return the dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a dgf duplct licns reason with the primary key could not be found
	 */
	@Override
	public DgfDuplctLicnsReason findByPrimaryKey(long duplicateLicenseReasonID)
		throws NoSuchDgfDuplctLicnsReasonException {

		return findByPrimaryKey((Serializable)duplicateLicenseReasonID);
	}

	/**
	 * Returns the dgf duplct licns reason with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param duplicateLicenseReasonID the primary key of the dgf duplct licns reason
	 * @return the dgf duplct licns reason, or <code>null</code> if a dgf duplct licns reason with the primary key could not be found
	 */
	@Override
	public DgfDuplctLicnsReason fetchByPrimaryKey(
		long duplicateLicenseReasonID) {

		return fetchByPrimaryKey((Serializable)duplicateLicenseReasonID);
	}

	/**
	 * Returns all the dgf duplct licns reasons.
	 *
	 * @return the dgf duplct licns reasons
	 */
	@Override
	public List<DgfDuplctLicnsReason> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf duplct licns reasons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @return the range of dgf duplct licns reasons
	 */
	@Override
	public List<DgfDuplctLicnsReason> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf duplct licns reasons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf duplct licns reasons
	 */
	@Override
	public List<DgfDuplctLicnsReason> findAll(
		int start, int end,
		OrderByComparator<DgfDuplctLicnsReason> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf duplct licns reasons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf duplct licns reasons
	 */
	@Override
	public List<DgfDuplctLicnsReason> findAll(
		int start, int end,
		OrderByComparator<DgfDuplctLicnsReason> orderByComparator,
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

		List<DgfDuplctLicnsReason> list = null;

		if (useFinderCache) {
			list = (List<DgfDuplctLicnsReason>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFDUPLCTLICNSREASON);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFDUPLCTLICNSREASON;

				sql = sql.concat(DgfDuplctLicnsReasonModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DgfDuplctLicnsReason>)QueryUtil.list(
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
	 * Removes all the dgf duplct licns reasons from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DgfDuplctLicnsReason dgfDuplctLicnsReason : findAll()) {
			remove(dgfDuplctLicnsReason);
		}
	}

	/**
	 * Returns the number of dgf duplct licns reasons.
	 *
	 * @return the number of dgf duplct licns reasons
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
					_SQL_COUNT_DGFDUPLCTLICNSREASON);

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
		return "duplicateLicenseReasonID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DGFDUPLCTLICNSREASON;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DgfDuplctLicnsReasonModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dgf duplct licns reason persistence.
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

		_finderPathFetchByduplicateLicUserIdFinder = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByduplicateLicUserIdFinder",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByduplicateLicUserIdFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByduplicateLicUserIdFinder",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		_finderPathFetchByduplicateLicNationalIdFinder = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByduplicateLicNationalIdFinder",
			new String[] {String.class.getName()}, new String[] {"nationalId"},
			true);

		_finderPathCountByduplicateLicNationalIdFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByduplicateLicNationalIdFinder",
			new String[] {String.class.getName()}, new String[] {"nationalId"},
			false);

		_finderPathWithPaginationFindByduplicateLicNationalIdAndLicenseFinder =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByduplicateLicNationalIdAndLicenseFinder",
				new String[] {
					String.class.getName(), String.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"nationalId", "licenseNo"}, true);

		_finderPathWithoutPaginationFindByduplicateLicNationalIdAndLicenseFinder =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByduplicateLicNationalIdAndLicenseFinder",
				new String[] {String.class.getName(), String.class.getName()},
				new String[] {"nationalId", "licenseNo"}, true);

		_finderPathCountByduplicateLicNationalIdAndLicenseFinder =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByduplicateLicNationalIdAndLicenseFinder",
				new String[] {String.class.getName(), String.class.getName()},
				new String[] {"nationalId", "licenseNo"}, false);

		_finderPathFetchByduplicateLicTradeLicAttchIdFinder = new FinderPath(
			FINDER_CLASS_NAME_ENTITY,
			"fetchByduplicateLicTradeLicAttchIdFinder",
			new String[] {Long.class.getName()},
			new String[] {"tradeLicAttchId"}, true);

		_finderPathCountByduplicateLicTradeLicAttchIdFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByduplicateLicTradeLicAttchIdFinder",
			new String[] {Long.class.getName()},
			new String[] {"tradeLicAttchId"}, false);

		_finderPathFetchByduplicateLicPaymentAttchIdFinder = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByduplicateLicPaymentAttchIdFinder",
			new String[] {Long.class.getName()},
			new String[] {"paymentAttchId"}, true);

		_finderPathCountByduplicateLicPaymentAttchIdFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByduplicateLicPaymentAttchIdFinder",
			new String[] {Long.class.getName()},
			new String[] {"paymentAttchId"}, false);

		_finderPathWithPaginationFindByduplicateLicFglPrePrimaryIdFinder =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByduplicateLicFglPrePrimaryIdFinder",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"fglPrePrimaryId"}, true);

		_finderPathWithoutPaginationFindByduplicateLicFglPrePrimaryIdFinder =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByduplicateLicFglPrePrimaryIdFinder",
				new String[] {Long.class.getName()},
				new String[] {"fglPrePrimaryId"}, true);

		_finderPathCountByduplicateLicFglPrePrimaryIdFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByduplicateLicFglPrePrimaryIdFinder",
			new String[] {Long.class.getName()},
			new String[] {"fglPrePrimaryId"}, false);

		_finderPathFetchByduplicateLicApplicationNoFinder = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByduplicateLicApplicationNoFinder",
			new String[] {String.class.getName()},
			new String[] {"applicationNo"}, true);

		_finderPathCountByduplicateLicApplicationNoFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByduplicateLicApplicationNoFinder",
			new String[] {String.class.getName()},
			new String[] {"applicationNo"}, false);

		_setDgfDuplctLicnsReasonUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDgfDuplctLicnsReasonUtilPersistence(null);

		entityCache.removeCache(DgfDuplctLicnsReasonImpl.class.getName());
	}

	private void _setDgfDuplctLicnsReasonUtilPersistence(
		DgfDuplctLicnsReasonPersistence dgfDuplctLicnsReasonPersistence) {

		try {
			Field field = DgfDuplctLicnsReasonUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dgfDuplctLicnsReasonPersistence);
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

	private static final String _SQL_SELECT_DGFDUPLCTLICNSREASON =
		"SELECT dgfDuplctLicnsReason FROM DgfDuplctLicnsReason dgfDuplctLicnsReason";

	private static final String _SQL_SELECT_DGFDUPLCTLICNSREASON_WHERE =
		"SELECT dgfDuplctLicnsReason FROM DgfDuplctLicnsReason dgfDuplctLicnsReason WHERE ";

	private static final String _SQL_COUNT_DGFDUPLCTLICNSREASON =
		"SELECT COUNT(dgfDuplctLicnsReason) FROM DgfDuplctLicnsReason dgfDuplctLicnsReason";

	private static final String _SQL_COUNT_DGFDUPLCTLICNSREASON_WHERE =
		"SELECT COUNT(dgfDuplctLicnsReason) FROM DgfDuplctLicnsReason dgfDuplctLicnsReason WHERE ";

	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN =
		"dgfDuplctLicnsReason.duplicateLicenseReasonID";

	private static final String _FILTER_SQL_SELECT_DGFDUPLCTLICNSREASON_WHERE =
		"SELECT DISTINCT {dgfDuplctLicnsReason.*} FROM dgf_duplct_licns_reason dgfDuplctLicnsReason WHERE ";

	private static final String
		_FILTER_SQL_SELECT_DGFDUPLCTLICNSREASON_NO_INLINE_DISTINCT_WHERE_1 =
			"SELECT {dgf_duplct_licns_reason.*} FROM (SELECT DISTINCT dgfDuplctLicnsReason.duplicateLicenseReasonID FROM dgf_duplct_licns_reason dgfDuplctLicnsReason WHERE ";

	private static final String
		_FILTER_SQL_SELECT_DGFDUPLCTLICNSREASON_NO_INLINE_DISTINCT_WHERE_2 =
			") TEMP_TABLE INNER JOIN dgf_duplct_licns_reason ON TEMP_TABLE.duplicateLicenseReasonID = dgf_duplct_licns_reason.duplicateLicenseReasonID";

	private static final String _FILTER_SQL_COUNT_DGFDUPLCTLICNSREASON_WHERE =
		"SELECT COUNT(DISTINCT dgfDuplctLicnsReason.duplicateLicenseReasonID) AS COUNT_VALUE FROM dgf_duplct_licns_reason dgfDuplctLicnsReason WHERE ";

	private static final String _FILTER_ENTITY_ALIAS = "dgfDuplctLicnsReason";

	private static final String _FILTER_ENTITY_TABLE =
		"dgf_duplct_licns_reason";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"dgfDuplctLicnsReason.";

	private static final String _ORDER_BY_ENTITY_TABLE =
		"dgf_duplct_licns_reason.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DgfDuplctLicnsReason exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DgfDuplctLicnsReason exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DgfDuplctLicnsReasonPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}