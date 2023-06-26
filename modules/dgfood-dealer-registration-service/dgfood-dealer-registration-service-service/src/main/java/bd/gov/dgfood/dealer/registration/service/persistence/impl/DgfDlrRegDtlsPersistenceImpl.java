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

import bd.gov.dgfood.dealer.registration.exception.NoSuchDgfDlrRegDtlsException;
import bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls;
import bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtlsTable;
import bd.gov.dgfood.dealer.registration.model.impl.DgfDlrRegDtlsImpl;
import bd.gov.dgfood.dealer.registration.model.impl.DgfDlrRegDtlsModelImpl;
import bd.gov.dgfood.dealer.registration.service.persistence.DgfDlrRegDtlsPersistence;
import bd.gov.dgfood.dealer.registration.service.persistence.DgfDlrRegDtlsUtil;
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
 * The persistence implementation for the dgf dlr reg dtls service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DgfDlrRegDtlsPersistence.class)
public class DgfDlrRegDtlsPersistenceImpl
	extends BasePersistenceImpl<DgfDlrRegDtls>
	implements DgfDlrRegDtlsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DgfDlrRegDtlsUtil</code> to access the dgf dlr reg dtls persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DgfDlrRegDtlsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByDgfDlrRegDtlsByNid;
	private FinderPath _finderPathCountByDgfDlrRegDtlsByNid;

	/**
	 * Returns the dgf dlr reg dtls where nationalId = &#63; or throws a <code>NoSuchDgfDlrRegDtlsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf dlr reg dtls
	 * @throws NoSuchDgfDlrRegDtlsException if a matching dgf dlr reg dtls could not be found
	 */
	@Override
	public DgfDlrRegDtls findByDgfDlrRegDtlsByNid(String nationalId)
		throws NoSuchDgfDlrRegDtlsException {

		DgfDlrRegDtls dgfDlrRegDtls = fetchByDgfDlrRegDtlsByNid(nationalId);

		if (dgfDlrRegDtls == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("nationalId=");
			sb.append(nationalId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfDlrRegDtlsException(sb.toString());
		}

		return dgfDlrRegDtls;
	}

	/**
	 * Returns the dgf dlr reg dtls where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf dlr reg dtls, or <code>null</code> if a matching dgf dlr reg dtls could not be found
	 */
	@Override
	public DgfDlrRegDtls fetchByDgfDlrRegDtlsByNid(String nationalId) {
		return fetchByDgfDlrRegDtlsByNid(nationalId, true);
	}

	/**
	 * Returns the dgf dlr reg dtls where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf dlr reg dtls, or <code>null</code> if a matching dgf dlr reg dtls could not be found
	 */
	@Override
	public DgfDlrRegDtls fetchByDgfDlrRegDtlsByNid(
		String nationalId, boolean useFinderCache) {

		nationalId = Objects.toString(nationalId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {nationalId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDgfDlrRegDtlsByNid, finderArgs, this);
		}

		if (result instanceof DgfDlrRegDtls) {
			DgfDlrRegDtls dgfDlrRegDtls = (DgfDlrRegDtls)result;

			if (!Objects.equals(nationalId, dgfDlrRegDtls.getNationalId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DGFDLRREGDTLS_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_DGFDLRREGDTLSBYNID_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(_FINDER_COLUMN_DGFDLRREGDTLSBYNID_NATIONALID_2);
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

				List<DgfDlrRegDtls> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDgfDlrRegDtlsByNid, finderArgs,
							list);
					}
				}
				else {
					DgfDlrRegDtls dgfDlrRegDtls = list.get(0);

					result = dgfDlrRegDtls;

					cacheResult(dgfDlrRegDtls);
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
			return (DgfDlrRegDtls)result;
		}
	}

	/**
	 * Removes the dgf dlr reg dtls where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the dgf dlr reg dtls that was removed
	 */
	@Override
	public DgfDlrRegDtls removeByDgfDlrRegDtlsByNid(String nationalId)
		throws NoSuchDgfDlrRegDtlsException {

		DgfDlrRegDtls dgfDlrRegDtls = findByDgfDlrRegDtlsByNid(nationalId);

		return remove(dgfDlrRegDtls);
	}

	/**
	 * Returns the number of dgf dlr reg dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf dlr reg dtlses
	 */
	@Override
	public int countByDgfDlrRegDtlsByNid(String nationalId) {
		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = _finderPathCountByDgfDlrRegDtlsByNid;

		Object[] finderArgs = new Object[] {nationalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFDLRREGDTLS_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_DGFDLRREGDTLSBYNID_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(_FINDER_COLUMN_DGFDLRREGDTLSBYNID_NATIONALID_2);
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

	private static final String _FINDER_COLUMN_DGFDLRREGDTLSBYNID_NATIONALID_2 =
		"dgfDlrRegDtls.nationalId = ?";

	private static final String _FINDER_COLUMN_DGFDLRREGDTLSBYNID_NATIONALID_3 =
		"(dgfDlrRegDtls.nationalId IS NULL OR dgfDlrRegDtls.nationalId = '')";

	private FinderPath
		_finderPathFetchByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo;
	private FinderPath
		_finderPathCountByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo;

	/**
	 * Returns the dgf dlr reg dtls where nationalId = &#63; and fglLicnsNo = &#63; and dlrRegNo = &#63; or throws a <code>NoSuchDgfDlrRegDtlsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @param fglLicnsNo the fgl licns no
	 * @param dlrRegNo the dlr reg no
	 * @return the matching dgf dlr reg dtls
	 * @throws NoSuchDgfDlrRegDtlsException if a matching dgf dlr reg dtls could not be found
	 */
	@Override
	public DgfDlrRegDtls findByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo(
			String nationalId, String fglLicnsNo, long dlrRegNo)
		throws NoSuchDgfDlrRegDtlsException {

		DgfDlrRegDtls dgfDlrRegDtls =
			fetchByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo(
				nationalId, fglLicnsNo, dlrRegNo);

		if (dgfDlrRegDtls == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("nationalId=");
			sb.append(nationalId);

			sb.append(", fglLicnsNo=");
			sb.append(fglLicnsNo);

			sb.append(", dlrRegNo=");
			sb.append(dlrRegNo);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfDlrRegDtlsException(sb.toString());
		}

		return dgfDlrRegDtls;
	}

	/**
	 * Returns the dgf dlr reg dtls where nationalId = &#63; and fglLicnsNo = &#63; and dlrRegNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param fglLicnsNo the fgl licns no
	 * @param dlrRegNo the dlr reg no
	 * @return the matching dgf dlr reg dtls, or <code>null</code> if a matching dgf dlr reg dtls could not be found
	 */
	@Override
	public DgfDlrRegDtls fetchByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo(
		String nationalId, String fglLicnsNo, long dlrRegNo) {

		return fetchByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo(
			nationalId, fglLicnsNo, dlrRegNo, true);
	}

	/**
	 * Returns the dgf dlr reg dtls where nationalId = &#63; and fglLicnsNo = &#63; and dlrRegNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param fglLicnsNo the fgl licns no
	 * @param dlrRegNo the dlr reg no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf dlr reg dtls, or <code>null</code> if a matching dgf dlr reg dtls could not be found
	 */
	@Override
	public DgfDlrRegDtls fetchByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo(
		String nationalId, String fglLicnsNo, long dlrRegNo,
		boolean useFinderCache) {

		nationalId = Objects.toString(nationalId, "");
		fglLicnsNo = Objects.toString(fglLicnsNo, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {nationalId, fglLicnsNo, dlrRegNo};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo,
				finderArgs, this);
		}

		if (result instanceof DgfDlrRegDtls) {
			DgfDlrRegDtls dgfDlrRegDtls = (DgfDlrRegDtls)result;

			if (!Objects.equals(nationalId, dgfDlrRegDtls.getNationalId()) ||
				!Objects.equals(fglLicnsNo, dgfDlrRegDtls.getFglLicnsNo()) ||
				(dlrRegNo != dgfDlrRegDtls.getDlrRegNo())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_DGFDLRREGDTLS_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DGFDLRREGDTLSBYNATIONALIDANDFOODGRAINLICENSENO_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(
					_FINDER_COLUMN_DGFDLRREGDTLSBYNATIONALIDANDFOODGRAINLICENSENO_NATIONALID_2);
			}

			boolean bindFglLicnsNo = false;

			if (fglLicnsNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DGFDLRREGDTLSBYNATIONALIDANDFOODGRAINLICENSENO_FGLLICNSNO_3);
			}
			else {
				bindFglLicnsNo = true;

				sb.append(
					_FINDER_COLUMN_DGFDLRREGDTLSBYNATIONALIDANDFOODGRAINLICENSENO_FGLLICNSNO_2);
			}

			sb.append(
				_FINDER_COLUMN_DGFDLRREGDTLSBYNATIONALIDANDFOODGRAINLICENSENO_DLRREGNO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNationalId) {
					queryPos.add(nationalId);
				}

				if (bindFglLicnsNo) {
					queryPos.add(fglLicnsNo);
				}

				queryPos.add(dlrRegNo);

				List<DgfDlrRegDtls> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									nationalId, fglLicnsNo, dlrRegNo
								};
							}

							_log.warn(
								"DgfDlrRegDtlsPersistenceImpl.fetchByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo(String, String, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DgfDlrRegDtls dgfDlrRegDtls = list.get(0);

					result = dgfDlrRegDtls;

					cacheResult(dgfDlrRegDtls);
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
			return (DgfDlrRegDtls)result;
		}
	}

	/**
	 * Removes the dgf dlr reg dtls where nationalId = &#63; and fglLicnsNo = &#63; and dlrRegNo = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @param fglLicnsNo the fgl licns no
	 * @param dlrRegNo the dlr reg no
	 * @return the dgf dlr reg dtls that was removed
	 */
	@Override
	public DgfDlrRegDtls removeByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo(
			String nationalId, String fglLicnsNo, long dlrRegNo)
		throws NoSuchDgfDlrRegDtlsException {

		DgfDlrRegDtls dgfDlrRegDtls =
			findByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo(
				nationalId, fglLicnsNo, dlrRegNo);

		return remove(dgfDlrRegDtls);
	}

	/**
	 * Returns the number of dgf dlr reg dtlses where nationalId = &#63; and fglLicnsNo = &#63; and dlrRegNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param fglLicnsNo the fgl licns no
	 * @param dlrRegNo the dlr reg no
	 * @return the number of matching dgf dlr reg dtlses
	 */
	@Override
	public int countByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo(
		String nationalId, String fglLicnsNo, long dlrRegNo) {

		nationalId = Objects.toString(nationalId, "");
		fglLicnsNo = Objects.toString(fglLicnsNo, "");

		FinderPath finderPath =
			_finderPathCountByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo;

		Object[] finderArgs = new Object[] {nationalId, fglLicnsNo, dlrRegNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DGFDLRREGDTLS_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DGFDLRREGDTLSBYNATIONALIDANDFOODGRAINLICENSENO_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(
					_FINDER_COLUMN_DGFDLRREGDTLSBYNATIONALIDANDFOODGRAINLICENSENO_NATIONALID_2);
			}

			boolean bindFglLicnsNo = false;

			if (fglLicnsNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DGFDLRREGDTLSBYNATIONALIDANDFOODGRAINLICENSENO_FGLLICNSNO_3);
			}
			else {
				bindFglLicnsNo = true;

				sb.append(
					_FINDER_COLUMN_DGFDLRREGDTLSBYNATIONALIDANDFOODGRAINLICENSENO_FGLLICNSNO_2);
			}

			sb.append(
				_FINDER_COLUMN_DGFDLRREGDTLSBYNATIONALIDANDFOODGRAINLICENSENO_DLRREGNO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNationalId) {
					queryPos.add(nationalId);
				}

				if (bindFglLicnsNo) {
					queryPos.add(fglLicnsNo);
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
		_FINDER_COLUMN_DGFDLRREGDTLSBYNATIONALIDANDFOODGRAINLICENSENO_NATIONALID_2 =
			"dgfDlrRegDtls.nationalId = ? AND ";

	private static final String
		_FINDER_COLUMN_DGFDLRREGDTLSBYNATIONALIDANDFOODGRAINLICENSENO_NATIONALID_3 =
			"(dgfDlrRegDtls.nationalId IS NULL OR dgfDlrRegDtls.nationalId = '') AND ";

	private static final String
		_FINDER_COLUMN_DGFDLRREGDTLSBYNATIONALIDANDFOODGRAINLICENSENO_FGLLICNSNO_2 =
			"dgfDlrRegDtls.fglLicnsNo = ? AND ";

	private static final String
		_FINDER_COLUMN_DGFDLRREGDTLSBYNATIONALIDANDFOODGRAINLICENSENO_FGLLICNSNO_3 =
			"(dgfDlrRegDtls.fglLicnsNo IS NULL OR dgfDlrRegDtls.fglLicnsNo = '') AND ";

	private static final String
		_FINDER_COLUMN_DGFDLRREGDTLSBYNATIONALIDANDFOODGRAINLICENSENO_DLRREGNO_2 =
			"dgfDlrRegDtls.dlrRegNo = ?";

	private FinderPath _finderPathFetchByDgfDlrRegDtlsByUserId;
	private FinderPath _finderPathCountByDgfDlrRegDtlsByUserId;

	/**
	 * Returns the dgf dlr reg dtls where userId = &#63; or throws a <code>NoSuchDgfDlrRegDtlsException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching dgf dlr reg dtls
	 * @throws NoSuchDgfDlrRegDtlsException if a matching dgf dlr reg dtls could not be found
	 */
	@Override
	public DgfDlrRegDtls findByDgfDlrRegDtlsByUserId(long userId)
		throws NoSuchDgfDlrRegDtlsException {

		DgfDlrRegDtls dgfDlrRegDtls = fetchByDgfDlrRegDtlsByUserId(userId);

		if (dgfDlrRegDtls == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("userId=");
			sb.append(userId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfDlrRegDtlsException(sb.toString());
		}

		return dgfDlrRegDtls;
	}

	/**
	 * Returns the dgf dlr reg dtls where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching dgf dlr reg dtls, or <code>null</code> if a matching dgf dlr reg dtls could not be found
	 */
	@Override
	public DgfDlrRegDtls fetchByDgfDlrRegDtlsByUserId(long userId) {
		return fetchByDgfDlrRegDtlsByUserId(userId, true);
	}

	/**
	 * Returns the dgf dlr reg dtls where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf dlr reg dtls, or <code>null</code> if a matching dgf dlr reg dtls could not be found
	 */
	@Override
	public DgfDlrRegDtls fetchByDgfDlrRegDtlsByUserId(
		long userId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {userId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDgfDlrRegDtlsByUserId, finderArgs, this);
		}

		if (result instanceof DgfDlrRegDtls) {
			DgfDlrRegDtls dgfDlrRegDtls = (DgfDlrRegDtls)result;

			if (userId != dgfDlrRegDtls.getUserId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DGFDLRREGDTLS_WHERE);

			sb.append(_FINDER_COLUMN_DGFDLRREGDTLSBYUSERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				List<DgfDlrRegDtls> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDgfDlrRegDtlsByUserId, finderArgs,
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
								"DgfDlrRegDtlsPersistenceImpl.fetchByDgfDlrRegDtlsByUserId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DgfDlrRegDtls dgfDlrRegDtls = list.get(0);

					result = dgfDlrRegDtls;

					cacheResult(dgfDlrRegDtls);
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
			return (DgfDlrRegDtls)result;
		}
	}

	/**
	 * Removes the dgf dlr reg dtls where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the dgf dlr reg dtls that was removed
	 */
	@Override
	public DgfDlrRegDtls removeByDgfDlrRegDtlsByUserId(long userId)
		throws NoSuchDgfDlrRegDtlsException {

		DgfDlrRegDtls dgfDlrRegDtls = findByDgfDlrRegDtlsByUserId(userId);

		return remove(dgfDlrRegDtls);
	}

	/**
	 * Returns the number of dgf dlr reg dtlses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching dgf dlr reg dtlses
	 */
	@Override
	public int countByDgfDlrRegDtlsByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByDgfDlrRegDtlsByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFDLRREGDTLS_WHERE);

			sb.append(_FINDER_COLUMN_DGFDLRREGDTLSBYUSERID_USERID_2);

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

	private static final String _FINDER_COLUMN_DGFDLRREGDTLSBYUSERID_USERID_2 =
		"dgfDlrRegDtls.userId = ?";

	public DgfDlrRegDtlsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("dlrRegNo", "dlr_reg_no");
		dbColumnNames.put("nationalId", "national_id");
		dbColumnNames.put("userId", "user_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("dlrRegApplNo", "dlr_reg_appl_no");
		dbColumnNames.put("fglLicnsNo", "fgl_licns_no");
		dbColumnNames.put("fglLicnsIssueDate", "fgl_licns_issue_date");
		dbColumnNames.put("trdLicnsNo", "trd_licns_no");
		dbColumnNames.put("trdLicnsExpDate", "trd_licns_exp_date");
		dbColumnNames.put("dlrTypeId", "dlr_type_id");
		dbColumnNames.put("maritalStatus", "marital_status");
		dbColumnNames.put("spouseName", "spouse_name");
		dbColumnNames.put("spouseFthrName", "spouse_fthr_name");
		dbColumnNames.put("spouseNid", "spouse_nid");
		dbColumnNames.put("spouseBrthDate", "spouse_brth_date");
		dbColumnNames.put("dlrRegExpiryDate", "dlr_reg_expiry_date");
		dbColumnNames.put("sapBuCode", "sap_bu_code");
		dbColumnNames.put("dlrRegApplStatus", "dlr_reg_appl_status");
		dbColumnNames.put("dlrRegCrtdDate", "dlr_reg_crtd_date");
		dbColumnNames.put("pymntTrnRefNo", "pymnt_trn_ref_no");
		dbColumnNames.put("pymntTrnStatus", "pymnt_trn_status");
		dbColumnNames.put("challanDocId", "challan_doc_id");
		dbColumnNames.put("incmTaxAttchID", "incm_tax_attch_id");
		dbColumnNames.put("bnkSolvncyCertId", "bnk_solvncy_cert_id");
		dbColumnNames.put("shpOwnshipDocuId", "shp_ownship_docu_id");
		dbColumnNames.put("shpRentedDocuId", "shp_rented_docu_id");
		dbColumnNames.put("signatureId", "signature_id");
		dbColumnNames.put("dlrApprRjctComments", "dlr_appr_rjct_comments");
		dbColumnNames.put("dlrRegApprRejRmrk", "dlr_reg_appr_rej_rmrk");
		dbColumnNames.put("statusByUserId", "status_by_user_id");
		dbColumnNames.put("statusByUserName", "status_by_user_name");
		dbColumnNames.put("statusDate", "status_date");
		dbColumnNames.put("dlrRegCrtdBy", "dlr_reg_crtd_by");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("lastUpdtdBy", "last_updtd_by");
		dbColumnNames.put("modifedDate", "modifed_date");
		dbColumnNames.put("dlrOmsSubType", "dlr_oms_sub_type");
		dbColumnNames.put("unionName", "union_name");
		dbColumnNames.put("dlrBrthDate", "dlr_brth_date");

		setDBColumnNames(dbColumnNames);

		setModelClass(DgfDlrRegDtls.class);

		setModelImplClass(DgfDlrRegDtlsImpl.class);
		setModelPKClass(long.class);

		setTable(DgfDlrRegDtlsTable.INSTANCE);
	}

	/**
	 * Caches the dgf dlr reg dtls in the entity cache if it is enabled.
	 *
	 * @param dgfDlrRegDtls the dgf dlr reg dtls
	 */
	@Override
	public void cacheResult(DgfDlrRegDtls dgfDlrRegDtls) {
		entityCache.putResult(
			DgfDlrRegDtlsImpl.class, dgfDlrRegDtls.getPrimaryKey(),
			dgfDlrRegDtls);

		finderCache.putResult(
			_finderPathFetchByDgfDlrRegDtlsByNid,
			new Object[] {dgfDlrRegDtls.getNationalId()}, dgfDlrRegDtls);

		finderCache.putResult(
			_finderPathFetchByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo,
			new Object[] {
				dgfDlrRegDtls.getNationalId(), dgfDlrRegDtls.getFglLicnsNo(),
				dgfDlrRegDtls.getDlrRegNo()
			},
			dgfDlrRegDtls);

		finderCache.putResult(
			_finderPathFetchByDgfDlrRegDtlsByUserId,
			new Object[] {dgfDlrRegDtls.getUserId()}, dgfDlrRegDtls);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dgf dlr reg dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfDlrRegDtlses the dgf dlr reg dtlses
	 */
	@Override
	public void cacheResult(List<DgfDlrRegDtls> dgfDlrRegDtlses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgfDlrRegDtlses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DgfDlrRegDtls dgfDlrRegDtls : dgfDlrRegDtlses) {
			if (entityCache.getResult(
					DgfDlrRegDtlsImpl.class, dgfDlrRegDtls.getPrimaryKey()) ==
						null) {

				cacheResult(dgfDlrRegDtls);
			}
		}
	}

	/**
	 * Clears the cache for all dgf dlr reg dtlses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DgfDlrRegDtlsImpl.class);

		finderCache.clearCache(DgfDlrRegDtlsImpl.class);
	}

	/**
	 * Clears the cache for the dgf dlr reg dtls.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DgfDlrRegDtls dgfDlrRegDtls) {
		entityCache.removeResult(DgfDlrRegDtlsImpl.class, dgfDlrRegDtls);
	}

	@Override
	public void clearCache(List<DgfDlrRegDtls> dgfDlrRegDtlses) {
		for (DgfDlrRegDtls dgfDlrRegDtls : dgfDlrRegDtlses) {
			entityCache.removeResult(DgfDlrRegDtlsImpl.class, dgfDlrRegDtls);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DgfDlrRegDtlsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DgfDlrRegDtlsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DgfDlrRegDtlsModelImpl dgfDlrRegDtlsModelImpl) {

		Object[] args = new Object[] {dgfDlrRegDtlsModelImpl.getNationalId()};

		finderCache.putResult(
			_finderPathCountByDgfDlrRegDtlsByNid, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDgfDlrRegDtlsByNid, args, dgfDlrRegDtlsModelImpl);

		args = new Object[] {
			dgfDlrRegDtlsModelImpl.getNationalId(),
			dgfDlrRegDtlsModelImpl.getFglLicnsNo(),
			dgfDlrRegDtlsModelImpl.getDlrRegNo()
		};

		finderCache.putResult(
			_finderPathCountByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo,
			args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo,
			args, dgfDlrRegDtlsModelImpl);

		args = new Object[] {dgfDlrRegDtlsModelImpl.getUserId()};

		finderCache.putResult(
			_finderPathCountByDgfDlrRegDtlsByUserId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDgfDlrRegDtlsByUserId, args,
			dgfDlrRegDtlsModelImpl);
	}

	/**
	 * Creates a new dgf dlr reg dtls with the primary key. Does not add the dgf dlr reg dtls to the database.
	 *
	 * @param dlrRegNo the primary key for the new dgf dlr reg dtls
	 * @return the new dgf dlr reg dtls
	 */
	@Override
	public DgfDlrRegDtls create(long dlrRegNo) {
		DgfDlrRegDtls dgfDlrRegDtls = new DgfDlrRegDtlsImpl();

		dgfDlrRegDtls.setNew(true);
		dgfDlrRegDtls.setPrimaryKey(dlrRegNo);

		dgfDlrRegDtls.setCompanyId(CompanyThreadLocal.getCompanyId());

		return dgfDlrRegDtls;
	}

	/**
	 * Removes the dgf dlr reg dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dlrRegNo the primary key of the dgf dlr reg dtls
	 * @return the dgf dlr reg dtls that was removed
	 * @throws NoSuchDgfDlrRegDtlsException if a dgf dlr reg dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrRegDtls remove(long dlrRegNo)
		throws NoSuchDgfDlrRegDtlsException {

		return remove((Serializable)dlrRegNo);
	}

	/**
	 * Removes the dgf dlr reg dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dgf dlr reg dtls
	 * @return the dgf dlr reg dtls that was removed
	 * @throws NoSuchDgfDlrRegDtlsException if a dgf dlr reg dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrRegDtls remove(Serializable primaryKey)
		throws NoSuchDgfDlrRegDtlsException {

		Session session = null;

		try {
			session = openSession();

			DgfDlrRegDtls dgfDlrRegDtls = (DgfDlrRegDtls)session.get(
				DgfDlrRegDtlsImpl.class, primaryKey);

			if (dgfDlrRegDtls == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDgfDlrRegDtlsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgfDlrRegDtls);
		}
		catch (NoSuchDgfDlrRegDtlsException noSuchEntityException) {
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
	protected DgfDlrRegDtls removeImpl(DgfDlrRegDtls dgfDlrRegDtls) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgfDlrRegDtls)) {
				dgfDlrRegDtls = (DgfDlrRegDtls)session.get(
					DgfDlrRegDtlsImpl.class, dgfDlrRegDtls.getPrimaryKeyObj());
			}

			if (dgfDlrRegDtls != null) {
				session.delete(dgfDlrRegDtls);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgfDlrRegDtls != null) {
			clearCache(dgfDlrRegDtls);
		}

		return dgfDlrRegDtls;
	}

	@Override
	public DgfDlrRegDtls updateImpl(DgfDlrRegDtls dgfDlrRegDtls) {
		boolean isNew = dgfDlrRegDtls.isNew();

		if (!(dgfDlrRegDtls instanceof DgfDlrRegDtlsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dgfDlrRegDtls.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dgfDlrRegDtls);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgfDlrRegDtls proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DgfDlrRegDtls implementation " +
					dgfDlrRegDtls.getClass());
		}

		DgfDlrRegDtlsModelImpl dgfDlrRegDtlsModelImpl =
			(DgfDlrRegDtlsModelImpl)dgfDlrRegDtls;

		if (isNew && (dgfDlrRegDtls.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				dgfDlrRegDtls.setCreateDate(date);
			}
			else {
				dgfDlrRegDtls.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgfDlrRegDtls);
			}
			else {
				dgfDlrRegDtls = (DgfDlrRegDtls)session.merge(dgfDlrRegDtls);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DgfDlrRegDtlsImpl.class, dgfDlrRegDtlsModelImpl, false, true);

		cacheUniqueFindersCache(dgfDlrRegDtlsModelImpl);

		if (isNew) {
			dgfDlrRegDtls.setNew(false);
		}

		dgfDlrRegDtls.resetOriginalValues();

		return dgfDlrRegDtls;
	}

	/**
	 * Returns the dgf dlr reg dtls with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dgf dlr reg dtls
	 * @return the dgf dlr reg dtls
	 * @throws NoSuchDgfDlrRegDtlsException if a dgf dlr reg dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrRegDtls findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDgfDlrRegDtlsException {

		DgfDlrRegDtls dgfDlrRegDtls = fetchByPrimaryKey(primaryKey);

		if (dgfDlrRegDtls == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDgfDlrRegDtlsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgfDlrRegDtls;
	}

	/**
	 * Returns the dgf dlr reg dtls with the primary key or throws a <code>NoSuchDgfDlrRegDtlsException</code> if it could not be found.
	 *
	 * @param dlrRegNo the primary key of the dgf dlr reg dtls
	 * @return the dgf dlr reg dtls
	 * @throws NoSuchDgfDlrRegDtlsException if a dgf dlr reg dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrRegDtls findByPrimaryKey(long dlrRegNo)
		throws NoSuchDgfDlrRegDtlsException {

		return findByPrimaryKey((Serializable)dlrRegNo);
	}

	/**
	 * Returns the dgf dlr reg dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dlrRegNo the primary key of the dgf dlr reg dtls
	 * @return the dgf dlr reg dtls, or <code>null</code> if a dgf dlr reg dtls with the primary key could not be found
	 */
	@Override
	public DgfDlrRegDtls fetchByPrimaryKey(long dlrRegNo) {
		return fetchByPrimaryKey((Serializable)dlrRegNo);
	}

	/**
	 * Returns all the dgf dlr reg dtlses.
	 *
	 * @return the dgf dlr reg dtlses
	 */
	@Override
	public List<DgfDlrRegDtls> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf dlr reg dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrRegDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr reg dtlses
	 * @param end the upper bound of the range of dgf dlr reg dtlses (not inclusive)
	 * @return the range of dgf dlr reg dtlses
	 */
	@Override
	public List<DgfDlrRegDtls> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf dlr reg dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrRegDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr reg dtlses
	 * @param end the upper bound of the range of dgf dlr reg dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf dlr reg dtlses
	 */
	@Override
	public List<DgfDlrRegDtls> findAll(
		int start, int end,
		OrderByComparator<DgfDlrRegDtls> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf dlr reg dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrRegDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr reg dtlses
	 * @param end the upper bound of the range of dgf dlr reg dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf dlr reg dtlses
	 */
	@Override
	public List<DgfDlrRegDtls> findAll(
		int start, int end, OrderByComparator<DgfDlrRegDtls> orderByComparator,
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

		List<DgfDlrRegDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfDlrRegDtls>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFDLRREGDTLS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFDLRREGDTLS;

				sql = sql.concat(DgfDlrRegDtlsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DgfDlrRegDtls>)QueryUtil.list(
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
	 * Removes all the dgf dlr reg dtlses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DgfDlrRegDtls dgfDlrRegDtls : findAll()) {
			remove(dgfDlrRegDtls);
		}
	}

	/**
	 * Returns the number of dgf dlr reg dtlses.
	 *
	 * @return the number of dgf dlr reg dtlses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DGFDLRREGDTLS);

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
		return "dlr_reg_no";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DGFDLRREGDTLS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DgfDlrRegDtlsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dgf dlr reg dtls persistence.
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

		_finderPathFetchByDgfDlrRegDtlsByNid = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDgfDlrRegDtlsByNid",
			new String[] {String.class.getName()}, new String[] {"national_id"},
			true);

		_finderPathCountByDgfDlrRegDtlsByNid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDgfDlrRegDtlsByNid", new String[] {String.class.getName()},
			new String[] {"national_id"}, false);

		_finderPathFetchByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo =
			new FinderPath(
				FINDER_CLASS_NAME_ENTITY,
				"fetchByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo",
				new String[] {
					String.class.getName(), String.class.getName(),
					Long.class.getName()
				},
				new String[] {"national_id", "fgl_licns_no", "dlr_reg_no"},
				true);

		_finderPathCountByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo",
				new String[] {
					String.class.getName(), String.class.getName(),
					Long.class.getName()
				},
				new String[] {"national_id", "fgl_licns_no", "dlr_reg_no"},
				false);

		_finderPathFetchByDgfDlrRegDtlsByUserId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDgfDlrRegDtlsByUserId",
			new String[] {Long.class.getName()}, new String[] {"user_id"},
			true);

		_finderPathCountByDgfDlrRegDtlsByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDgfDlrRegDtlsByUserId", new String[] {Long.class.getName()},
			new String[] {"user_id"}, false);

		_setDgfDlrRegDtlsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDgfDlrRegDtlsUtilPersistence(null);

		entityCache.removeCache(DgfDlrRegDtlsImpl.class.getName());
	}

	private void _setDgfDlrRegDtlsUtilPersistence(
		DgfDlrRegDtlsPersistence dgfDlrRegDtlsPersistence) {

		try {
			Field field = DgfDlrRegDtlsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dgfDlrRegDtlsPersistence);
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

	private static final String _SQL_SELECT_DGFDLRREGDTLS =
		"SELECT dgfDlrRegDtls FROM DgfDlrRegDtls dgfDlrRegDtls";

	private static final String _SQL_SELECT_DGFDLRREGDTLS_WHERE =
		"SELECT dgfDlrRegDtls FROM DgfDlrRegDtls dgfDlrRegDtls WHERE ";

	private static final String _SQL_COUNT_DGFDLRREGDTLS =
		"SELECT COUNT(dgfDlrRegDtls) FROM DgfDlrRegDtls dgfDlrRegDtls";

	private static final String _SQL_COUNT_DGFDLRREGDTLS_WHERE =
		"SELECT COUNT(dgfDlrRegDtls) FROM DgfDlrRegDtls dgfDlrRegDtls WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dgfDlrRegDtls.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DgfDlrRegDtls exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DgfDlrRegDtls exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DgfDlrRegDtlsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"dlrRegNo", "nationalId", "userId", "groupId", "companyId",
			"dlrRegApplNo", "fglLicnsNo", "fglLicnsIssueDate", "trdLicnsNo",
			"trdLicnsExpDate", "dlrTypeId", "maritalStatus", "spouseName",
			"spouseFthrName", "spouseNid", "spouseBrthDate", "dlrRegExpiryDate",
			"sapBuCode", "dlrRegApplStatus", "dlrRegCrtdDate", "pymntTrnRefNo",
			"pymntTrnStatus", "challanDocId", "incmTaxAttchID",
			"bnkSolvncyCertId", "shpOwnshipDocuId", "shpRentedDocuId",
			"signatureId", "dlrApprRjctComments", "dlrRegApprRejRmrk",
			"statusByUserId", "statusByUserName", "statusDate", "dlrRegCrtdBy",
			"createDate", "lastUpdtdBy", "modifedDate", "dlrOmsSubType",
			"unionName", "dlrBrthDate"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}