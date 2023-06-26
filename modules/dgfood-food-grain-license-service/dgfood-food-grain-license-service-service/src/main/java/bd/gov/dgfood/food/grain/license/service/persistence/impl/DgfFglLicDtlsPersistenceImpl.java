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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfFglLicDtlsException;
import bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls;
import bd.gov.dgfood.food.grain.license.model.DgfFglLicDtlsTable;
import bd.gov.dgfood.food.grain.license.model.impl.DgfFglLicDtlsImpl;
import bd.gov.dgfood.food.grain.license.model.impl.DgfFglLicDtlsModelImpl;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfFglLicDtlsPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfFglLicDtlsUtil;
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
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the dgf fgl lic dtls service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DgfFglLicDtlsPersistence.class)
public class DgfFglLicDtlsPersistenceImpl
	extends BasePersistenceImpl<DgfFglLicDtls>
	implements DgfFglLicDtlsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DgfFglLicDtlsUtil</code> to access the dgf fgl lic dtls persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DgfFglLicDtlsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBydgfFglLicDtlsByFglLicPrePrimaryId;
	private FinderPath _finderPathCountBydgfFglLicDtlsByFglLicPrePrimaryId;

	/**
	 * Returns the dgf fgl lic dtls where fglPrePrimaryId = &#63; or throws a <code>NoSuchDgfFglLicDtlsException</code> if it could not be found.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the matching dgf fgl lic dtls
	 * @throws NoSuchDgfFglLicDtlsException if a matching dgf fgl lic dtls could not be found
	 */
	@Override
	public DgfFglLicDtls findBydgfFglLicDtlsByFglLicPrePrimaryId(
			long fglPrePrimaryId)
		throws NoSuchDgfFglLicDtlsException {

		DgfFglLicDtls dgfFglLicDtls = fetchBydgfFglLicDtlsByFglLicPrePrimaryId(
			fglPrePrimaryId);

		if (dgfFglLicDtls == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("fglPrePrimaryId=");
			sb.append(fglPrePrimaryId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfFglLicDtlsException(sb.toString());
		}

		return dgfFglLicDtls;
	}

	/**
	 * Returns the dgf fgl lic dtls where fglPrePrimaryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	@Override
	public DgfFglLicDtls fetchBydgfFglLicDtlsByFglLicPrePrimaryId(
		long fglPrePrimaryId) {

		return fetchBydgfFglLicDtlsByFglLicPrePrimaryId(fglPrePrimaryId, true);
	}

	/**
	 * Returns the dgf fgl lic dtls where fglPrePrimaryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	@Override
	public DgfFglLicDtls fetchBydgfFglLicDtlsByFglLicPrePrimaryId(
		long fglPrePrimaryId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {fglPrePrimaryId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBydgfFglLicDtlsByFglLicPrePrimaryId, finderArgs,
				this);
		}

		if (result instanceof DgfFglLicDtls) {
			DgfFglLicDtls dgfFglLicDtls = (DgfFglLicDtls)result;

			if (fglPrePrimaryId != dgfFglLicDtls.getFglPrePrimaryId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DGFFGLLICDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLLICDTLSBYFGLLICPREPRIMARYID_FGLPREPRIMARYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fglPrePrimaryId);

				List<DgfFglLicDtls> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBydgfFglLicDtlsByFglLicPrePrimaryId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {fglPrePrimaryId};
							}

							_log.warn(
								"DgfFglLicDtlsPersistenceImpl.fetchBydgfFglLicDtlsByFglLicPrePrimaryId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DgfFglLicDtls dgfFglLicDtls = list.get(0);

					result = dgfFglLicDtls;

					cacheResult(dgfFglLicDtls);
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
			return (DgfFglLicDtls)result;
		}
	}

	/**
	 * Removes the dgf fgl lic dtls where fglPrePrimaryId = &#63; from the database.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the dgf fgl lic dtls that was removed
	 */
	@Override
	public DgfFglLicDtls removeBydgfFglLicDtlsByFglLicPrePrimaryId(
			long fglPrePrimaryId)
		throws NoSuchDgfFglLicDtlsException {

		DgfFglLicDtls dgfFglLicDtls = findBydgfFglLicDtlsByFglLicPrePrimaryId(
			fglPrePrimaryId);

		return remove(dgfFglLicDtls);
	}

	/**
	 * Returns the number of dgf fgl lic dtlses where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the number of matching dgf fgl lic dtlses
	 */
	@Override
	public int countBydgfFglLicDtlsByFglLicPrePrimaryId(long fglPrePrimaryId) {
		FinderPath finderPath =
			_finderPathCountBydgfFglLicDtlsByFglLicPrePrimaryId;

		Object[] finderArgs = new Object[] {fglPrePrimaryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFFGLLICDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLLICDTLSBYFGLLICPREPRIMARYID_FGLPREPRIMARYID_2);

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

	private static final String
		_FINDER_COLUMN_DGFFGLLICDTLSBYFGLLICPREPRIMARYID_FGLPREPRIMARYID_2 =
			"dgfFglLicDtls.fglPrePrimaryId = ?";

	private FinderPath _finderPathFetchBydgfFglLicDtlsByNationalId;
	private FinderPath _finderPathCountBydgfFglLicDtlsByNationalId;

	/**
	 * Returns the dgf fgl lic dtls where nationalId = &#63; or throws a <code>NoSuchDgfFglLicDtlsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf fgl lic dtls
	 * @throws NoSuchDgfFglLicDtlsException if a matching dgf fgl lic dtls could not be found
	 */
	@Override
	public DgfFglLicDtls findBydgfFglLicDtlsByNationalId(String nationalId)
		throws NoSuchDgfFglLicDtlsException {

		DgfFglLicDtls dgfFglLicDtls = fetchBydgfFglLicDtlsByNationalId(
			nationalId);

		if (dgfFglLicDtls == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("nationalId=");
			sb.append(nationalId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfFglLicDtlsException(sb.toString());
		}

		return dgfFglLicDtls;
	}

	/**
	 * Returns the dgf fgl lic dtls where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	@Override
	public DgfFglLicDtls fetchBydgfFglLicDtlsByNationalId(String nationalId) {
		return fetchBydgfFglLicDtlsByNationalId(nationalId, true);
	}

	/**
	 * Returns the dgf fgl lic dtls where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	@Override
	public DgfFglLicDtls fetchBydgfFglLicDtlsByNationalId(
		String nationalId, boolean useFinderCache) {

		nationalId = Objects.toString(nationalId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {nationalId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBydgfFglLicDtlsByNationalId, finderArgs, this);
		}

		if (result instanceof DgfFglLicDtls) {
			DgfFglLicDtls dgfFglLicDtls = (DgfFglLicDtls)result;

			if (!Objects.equals(nationalId, dgfFglLicDtls.getNationalId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DGFFGLLICDTLS_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DGFFGLLICDTLSBYNATIONALID_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(
					_FINDER_COLUMN_DGFFGLLICDTLSBYNATIONALID_NATIONALID_2);
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

				List<DgfFglLicDtls> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBydgfFglLicDtlsByNationalId,
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
								"DgfFglLicDtlsPersistenceImpl.fetchBydgfFglLicDtlsByNationalId(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DgfFglLicDtls dgfFglLicDtls = list.get(0);

					result = dgfFglLicDtls;

					cacheResult(dgfFglLicDtls);
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
			return (DgfFglLicDtls)result;
		}
	}

	/**
	 * Removes the dgf fgl lic dtls where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the dgf fgl lic dtls that was removed
	 */
	@Override
	public DgfFglLicDtls removeBydgfFglLicDtlsByNationalId(String nationalId)
		throws NoSuchDgfFglLicDtlsException {

		DgfFglLicDtls dgfFglLicDtls = findBydgfFglLicDtlsByNationalId(
			nationalId);

		return remove(dgfFglLicDtls);
	}

	/**
	 * Returns the number of dgf fgl lic dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf fgl lic dtlses
	 */
	@Override
	public int countBydgfFglLicDtlsByNationalId(String nationalId) {
		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = _finderPathCountBydgfFglLicDtlsByNationalId;

		Object[] finderArgs = new Object[] {nationalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFFGLLICDTLS_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DGFFGLLICDTLSBYNATIONALID_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(
					_FINDER_COLUMN_DGFFGLLICDTLSBYNATIONALID_NATIONALID_2);
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
		_FINDER_COLUMN_DGFFGLLICDTLSBYNATIONALID_NATIONALID_2 =
			"dgfFglLicDtls.nationalId = ?";

	private static final String
		_FINDER_COLUMN_DGFFGLLICDTLSBYNATIONALID_NATIONALID_3 =
			"(dgfFglLicDtls.nationalId IS NULL OR dgfFglLicDtls.nationalId = '')";

	private FinderPath _finderPathFetchBydgfFglLicDtlsByFglApplicationNo;
	private FinderPath _finderPathCountBydgfFglLicDtlsByFglApplicationNo;

	/**
	 * Returns the dgf fgl lic dtls where fglApplicationNo = &#63; or throws a <code>NoSuchDgfFglLicDtlsException</code> if it could not be found.
	 *
	 * @param fglApplicationNo the fgl application no
	 * @return the matching dgf fgl lic dtls
	 * @throws NoSuchDgfFglLicDtlsException if a matching dgf fgl lic dtls could not be found
	 */
	@Override
	public DgfFglLicDtls findBydgfFglLicDtlsByFglApplicationNo(
			String fglApplicationNo)
		throws NoSuchDgfFglLicDtlsException {

		DgfFglLicDtls dgfFglLicDtls = fetchBydgfFglLicDtlsByFglApplicationNo(
			fglApplicationNo);

		if (dgfFglLicDtls == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("fglApplicationNo=");
			sb.append(fglApplicationNo);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfFglLicDtlsException(sb.toString());
		}

		return dgfFglLicDtls;
	}

	/**
	 * Returns the dgf fgl lic dtls where fglApplicationNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fglApplicationNo the fgl application no
	 * @return the matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	@Override
	public DgfFglLicDtls fetchBydgfFglLicDtlsByFglApplicationNo(
		String fglApplicationNo) {

		return fetchBydgfFglLicDtlsByFglApplicationNo(fglApplicationNo, true);
	}

	/**
	 * Returns the dgf fgl lic dtls where fglApplicationNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fglApplicationNo the fgl application no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	@Override
	public DgfFglLicDtls fetchBydgfFglLicDtlsByFglApplicationNo(
		String fglApplicationNo, boolean useFinderCache) {

		fglApplicationNo = Objects.toString(fglApplicationNo, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {fglApplicationNo};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBydgfFglLicDtlsByFglApplicationNo, finderArgs,
				this);
		}

		if (result instanceof DgfFglLicDtls) {
			DgfFglLicDtls dgfFglLicDtls = (DgfFglLicDtls)result;

			if (!Objects.equals(
					fglApplicationNo, dgfFglLicDtls.getFglApplicationNo())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DGFFGLLICDTLS_WHERE);

			boolean bindFglApplicationNo = false;

			if (fglApplicationNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DGFFGLLICDTLSBYFGLAPPLICATIONNO_FGLAPPLICATIONNO_3);
			}
			else {
				bindFglApplicationNo = true;

				sb.append(
					_FINDER_COLUMN_DGFFGLLICDTLSBYFGLAPPLICATIONNO_FGLAPPLICATIONNO_2);
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

				List<DgfFglLicDtls> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBydgfFglLicDtlsByFglApplicationNo,
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
								"DgfFglLicDtlsPersistenceImpl.fetchBydgfFglLicDtlsByFglApplicationNo(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DgfFglLicDtls dgfFglLicDtls = list.get(0);

					result = dgfFglLicDtls;

					cacheResult(dgfFglLicDtls);
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
			return (DgfFglLicDtls)result;
		}
	}

	/**
	 * Removes the dgf fgl lic dtls where fglApplicationNo = &#63; from the database.
	 *
	 * @param fglApplicationNo the fgl application no
	 * @return the dgf fgl lic dtls that was removed
	 */
	@Override
	public DgfFglLicDtls removeBydgfFglLicDtlsByFglApplicationNo(
			String fglApplicationNo)
		throws NoSuchDgfFglLicDtlsException {

		DgfFglLicDtls dgfFglLicDtls = findBydgfFglLicDtlsByFglApplicationNo(
			fglApplicationNo);

		return remove(dgfFglLicDtls);
	}

	/**
	 * Returns the number of dgf fgl lic dtlses where fglApplicationNo = &#63;.
	 *
	 * @param fglApplicationNo the fgl application no
	 * @return the number of matching dgf fgl lic dtlses
	 */
	@Override
	public int countBydgfFglLicDtlsByFglApplicationNo(String fglApplicationNo) {
		fglApplicationNo = Objects.toString(fglApplicationNo, "");

		FinderPath finderPath =
			_finderPathCountBydgfFglLicDtlsByFglApplicationNo;

		Object[] finderArgs = new Object[] {fglApplicationNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFFGLLICDTLS_WHERE);

			boolean bindFglApplicationNo = false;

			if (fglApplicationNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DGFFGLLICDTLSBYFGLAPPLICATIONNO_FGLAPPLICATIONNO_3);
			}
			else {
				bindFglApplicationNo = true;

				sb.append(
					_FINDER_COLUMN_DGFFGLLICDTLSBYFGLAPPLICATIONNO_FGLAPPLICATIONNO_2);
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
		_FINDER_COLUMN_DGFFGLLICDTLSBYFGLAPPLICATIONNO_FGLAPPLICATIONNO_2 =
			"dgfFglLicDtls.fglApplicationNo = ?";

	private static final String
		_FINDER_COLUMN_DGFFGLLICDTLSBYFGLAPPLICATIONNO_FGLAPPLICATIONNO_3 =
			"(dgfFglLicDtls.fglApplicationNo IS NULL OR dgfFglLicDtls.fglApplicationNo = '')";

	private FinderPath _finderPathFetchBydgfFglLicDtlsByFoodgrainLicenseNo;
	private FinderPath _finderPathCountBydgfFglLicDtlsByFoodgrainLicenseNo;

	/**
	 * Returns the dgf fgl lic dtls where foodgrainLicenseNo = &#63; or throws a <code>NoSuchDgfFglLicDtlsException</code> if it could not be found.
	 *
	 * @param foodgrainLicenseNo the foodgrain license no
	 * @return the matching dgf fgl lic dtls
	 * @throws NoSuchDgfFglLicDtlsException if a matching dgf fgl lic dtls could not be found
	 */
	@Override
	public DgfFglLicDtls findBydgfFglLicDtlsByFoodgrainLicenseNo(
			String foodgrainLicenseNo)
		throws NoSuchDgfFglLicDtlsException {

		DgfFglLicDtls dgfFglLicDtls = fetchBydgfFglLicDtlsByFoodgrainLicenseNo(
			foodgrainLicenseNo);

		if (dgfFglLicDtls == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("foodgrainLicenseNo=");
			sb.append(foodgrainLicenseNo);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfFglLicDtlsException(sb.toString());
		}

		return dgfFglLicDtls;
	}

	/**
	 * Returns the dgf fgl lic dtls where foodgrainLicenseNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param foodgrainLicenseNo the foodgrain license no
	 * @return the matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	@Override
	public DgfFglLicDtls fetchBydgfFglLicDtlsByFoodgrainLicenseNo(
		String foodgrainLicenseNo) {

		return fetchBydgfFglLicDtlsByFoodgrainLicenseNo(
			foodgrainLicenseNo, true);
	}

	/**
	 * Returns the dgf fgl lic dtls where foodgrainLicenseNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param foodgrainLicenseNo the foodgrain license no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	@Override
	public DgfFglLicDtls fetchBydgfFglLicDtlsByFoodgrainLicenseNo(
		String foodgrainLicenseNo, boolean useFinderCache) {

		foodgrainLicenseNo = Objects.toString(foodgrainLicenseNo, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {foodgrainLicenseNo};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBydgfFglLicDtlsByFoodgrainLicenseNo, finderArgs,
				this);
		}

		if (result instanceof DgfFglLicDtls) {
			DgfFglLicDtls dgfFglLicDtls = (DgfFglLicDtls)result;

			if (!Objects.equals(
					foodgrainLicenseNo,
					dgfFglLicDtls.getFoodgrainLicenseNo())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DGFFGLLICDTLS_WHERE);

			boolean bindFoodgrainLicenseNo = false;

			if (foodgrainLicenseNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DGFFGLLICDTLSBYFOODGRAINLICENSENO_FOODGRAINLICENSENO_3);
			}
			else {
				bindFoodgrainLicenseNo = true;

				sb.append(
					_FINDER_COLUMN_DGFFGLLICDTLSBYFOODGRAINLICENSENO_FOODGRAINLICENSENO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFoodgrainLicenseNo) {
					queryPos.add(foodgrainLicenseNo);
				}

				List<DgfFglLicDtls> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBydgfFglLicDtlsByFoodgrainLicenseNo,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {foodgrainLicenseNo};
							}

							_log.warn(
								"DgfFglLicDtlsPersistenceImpl.fetchBydgfFglLicDtlsByFoodgrainLicenseNo(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DgfFglLicDtls dgfFglLicDtls = list.get(0);

					result = dgfFglLicDtls;

					cacheResult(dgfFglLicDtls);
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
			return (DgfFglLicDtls)result;
		}
	}

	/**
	 * Removes the dgf fgl lic dtls where foodgrainLicenseNo = &#63; from the database.
	 *
	 * @param foodgrainLicenseNo the foodgrain license no
	 * @return the dgf fgl lic dtls that was removed
	 */
	@Override
	public DgfFglLicDtls removeBydgfFglLicDtlsByFoodgrainLicenseNo(
			String foodgrainLicenseNo)
		throws NoSuchDgfFglLicDtlsException {

		DgfFglLicDtls dgfFglLicDtls = findBydgfFglLicDtlsByFoodgrainLicenseNo(
			foodgrainLicenseNo);

		return remove(dgfFglLicDtls);
	}

	/**
	 * Returns the number of dgf fgl lic dtlses where foodgrainLicenseNo = &#63;.
	 *
	 * @param foodgrainLicenseNo the foodgrain license no
	 * @return the number of matching dgf fgl lic dtlses
	 */
	@Override
	public int countBydgfFglLicDtlsByFoodgrainLicenseNo(
		String foodgrainLicenseNo) {

		foodgrainLicenseNo = Objects.toString(foodgrainLicenseNo, "");

		FinderPath finderPath =
			_finderPathCountBydgfFglLicDtlsByFoodgrainLicenseNo;

		Object[] finderArgs = new Object[] {foodgrainLicenseNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFFGLLICDTLS_WHERE);

			boolean bindFoodgrainLicenseNo = false;

			if (foodgrainLicenseNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DGFFGLLICDTLSBYFOODGRAINLICENSENO_FOODGRAINLICENSENO_3);
			}
			else {
				bindFoodgrainLicenseNo = true;

				sb.append(
					_FINDER_COLUMN_DGFFGLLICDTLSBYFOODGRAINLICENSENO_FOODGRAINLICENSENO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFoodgrainLicenseNo) {
					queryPos.add(foodgrainLicenseNo);
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
		_FINDER_COLUMN_DGFFGLLICDTLSBYFOODGRAINLICENSENO_FOODGRAINLICENSENO_2 =
			"dgfFglLicDtls.foodgrainLicenseNo = ?";

	private static final String
		_FINDER_COLUMN_DGFFGLLICDTLSBYFOODGRAINLICENSENO_FOODGRAINLICENSENO_3 =
			"(dgfFglLicDtls.foodgrainLicenseNo IS NULL OR dgfFglLicDtls.foodgrainLicenseNo = '')";

	private FinderPath
		_finderPathFetchBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo;
	private FinderPath
		_finderPathCountBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo;

	/**
	 * Returns the dgf fgl lic dtls where nationalId = &#63; and foodgrainLicenseNo = &#63; or throws a <code>NoSuchDgfFglLicDtlsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @param foodgrainLicenseNo the foodgrain license no
	 * @return the matching dgf fgl lic dtls
	 * @throws NoSuchDgfFglLicDtlsException if a matching dgf fgl lic dtls could not be found
	 */
	@Override
	public DgfFglLicDtls findBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo(
			String nationalId, String foodgrainLicenseNo)
		throws NoSuchDgfFglLicDtlsException {

		DgfFglLicDtls dgfFglLicDtls =
			fetchBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo(
				nationalId, foodgrainLicenseNo);

		if (dgfFglLicDtls == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("nationalId=");
			sb.append(nationalId);

			sb.append(", foodgrainLicenseNo=");
			sb.append(foodgrainLicenseNo);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfFglLicDtlsException(sb.toString());
		}

		return dgfFglLicDtls;
	}

	/**
	 * Returns the dgf fgl lic dtls where nationalId = &#63; and foodgrainLicenseNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param foodgrainLicenseNo the foodgrain license no
	 * @return the matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	@Override
	public DgfFglLicDtls fetchBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo(
		String nationalId, String foodgrainLicenseNo) {

		return fetchBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo(
			nationalId, foodgrainLicenseNo, true);
	}

	/**
	 * Returns the dgf fgl lic dtls where nationalId = &#63; and foodgrainLicenseNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param foodgrainLicenseNo the foodgrain license no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	@Override
	public DgfFglLicDtls fetchBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo(
		String nationalId, String foodgrainLicenseNo, boolean useFinderCache) {

		nationalId = Objects.toString(nationalId, "");
		foodgrainLicenseNo = Objects.toString(foodgrainLicenseNo, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {nationalId, foodgrainLicenseNo};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo,
				finderArgs, this);
		}

		if (result instanceof DgfFglLicDtls) {
			DgfFglLicDtls dgfFglLicDtls = (DgfFglLicDtls)result;

			if (!Objects.equals(nationalId, dgfFglLicDtls.getNationalId()) ||
				!Objects.equals(
					foodgrainLicenseNo,
					dgfFglLicDtls.getFoodgrainLicenseNo())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DGFFGLLICDTLS_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DGFFGLLICDTLSBYNATIONALIDANDFOODGRAINLICENSENO_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(
					_FINDER_COLUMN_DGFFGLLICDTLSBYNATIONALIDANDFOODGRAINLICENSENO_NATIONALID_2);
			}

			boolean bindFoodgrainLicenseNo = false;

			if (foodgrainLicenseNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DGFFGLLICDTLSBYNATIONALIDANDFOODGRAINLICENSENO_FOODGRAINLICENSENO_3);
			}
			else {
				bindFoodgrainLicenseNo = true;

				sb.append(
					_FINDER_COLUMN_DGFFGLLICDTLSBYNATIONALIDANDFOODGRAINLICENSENO_FOODGRAINLICENSENO_2);
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

				if (bindFoodgrainLicenseNo) {
					queryPos.add(foodgrainLicenseNo);
				}

				List<DgfFglLicDtls> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									nationalId, foodgrainLicenseNo
								};
							}

							_log.warn(
								"DgfFglLicDtlsPersistenceImpl.fetchBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DgfFglLicDtls dgfFglLicDtls = list.get(0);

					result = dgfFglLicDtls;

					cacheResult(dgfFglLicDtls);
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
			return (DgfFglLicDtls)result;
		}
	}

	/**
	 * Removes the dgf fgl lic dtls where nationalId = &#63; and foodgrainLicenseNo = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @param foodgrainLicenseNo the foodgrain license no
	 * @return the dgf fgl lic dtls that was removed
	 */
	@Override
	public DgfFglLicDtls removeBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo(
			String nationalId, String foodgrainLicenseNo)
		throws NoSuchDgfFglLicDtlsException {

		DgfFglLicDtls dgfFglLicDtls =
			findBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo(
				nationalId, foodgrainLicenseNo);

		return remove(dgfFglLicDtls);
	}

	/**
	 * Returns the number of dgf fgl lic dtlses where nationalId = &#63; and foodgrainLicenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param foodgrainLicenseNo the foodgrain license no
	 * @return the number of matching dgf fgl lic dtlses
	 */
	@Override
	public int countBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo(
		String nationalId, String foodgrainLicenseNo) {

		nationalId = Objects.toString(nationalId, "");
		foodgrainLicenseNo = Objects.toString(foodgrainLicenseNo, "");

		FinderPath finderPath =
			_finderPathCountBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo;

		Object[] finderArgs = new Object[] {nationalId, foodgrainLicenseNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFFGLLICDTLS_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DGFFGLLICDTLSBYNATIONALIDANDFOODGRAINLICENSENO_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(
					_FINDER_COLUMN_DGFFGLLICDTLSBYNATIONALIDANDFOODGRAINLICENSENO_NATIONALID_2);
			}

			boolean bindFoodgrainLicenseNo = false;

			if (foodgrainLicenseNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DGFFGLLICDTLSBYNATIONALIDANDFOODGRAINLICENSENO_FOODGRAINLICENSENO_3);
			}
			else {
				bindFoodgrainLicenseNo = true;

				sb.append(
					_FINDER_COLUMN_DGFFGLLICDTLSBYNATIONALIDANDFOODGRAINLICENSENO_FOODGRAINLICENSENO_2);
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

				if (bindFoodgrainLicenseNo) {
					queryPos.add(foodgrainLicenseNo);
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
		_FINDER_COLUMN_DGFFGLLICDTLSBYNATIONALIDANDFOODGRAINLICENSENO_NATIONALID_2 =
			"dgfFglLicDtls.nationalId = ? AND ";

	private static final String
		_FINDER_COLUMN_DGFFGLLICDTLSBYNATIONALIDANDFOODGRAINLICENSENO_NATIONALID_3 =
			"(dgfFglLicDtls.nationalId IS NULL OR dgfFglLicDtls.nationalId = '') AND ";

	private static final String
		_FINDER_COLUMN_DGFFGLLICDTLSBYNATIONALIDANDFOODGRAINLICENSENO_FOODGRAINLICENSENO_2 =
			"dgfFglLicDtls.foodgrainLicenseNo = ?";

	private static final String
		_FINDER_COLUMN_DGFFGLLICDTLSBYNATIONALIDANDFOODGRAINLICENSENO_FOODGRAINLICENSENO_3 =
			"(dgfFglLicDtls.foodgrainLicenseNo IS NULL OR dgfFglLicDtls.foodgrainLicenseNo = '')";

	private FinderPath _finderPathWithPaginationFindBydgfFglLicDtlsListByNid;
	private FinderPath _finderPathWithoutPaginationFindBydgfFglLicDtlsListByNid;
	private FinderPath _finderPathCountBydgfFglLicDtlsListByNid;

	/**
	 * Returns all the dgf fgl lic dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf fgl lic dtlses
	 */
	@Override
	public List<DgfFglLicDtls> findBydgfFglLicDtlsListByNid(String nationalId) {
		return findBydgfFglLicDtlsListByNid(
			nationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf fgl lic dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglLicDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf fgl lic dtlses
	 * @param end the upper bound of the range of dgf fgl lic dtlses (not inclusive)
	 * @return the range of matching dgf fgl lic dtlses
	 */
	@Override
	public List<DgfFglLicDtls> findBydgfFglLicDtlsListByNid(
		String nationalId, int start, int end) {

		return findBydgfFglLicDtlsListByNid(nationalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf fgl lic dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglLicDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf fgl lic dtlses
	 * @param end the upper bound of the range of dgf fgl lic dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl lic dtlses
	 */
	@Override
	public List<DgfFglLicDtls> findBydgfFglLicDtlsListByNid(
		String nationalId, int start, int end,
		OrderByComparator<DgfFglLicDtls> orderByComparator) {

		return findBydgfFglLicDtlsListByNid(
			nationalId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf fgl lic dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglLicDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf fgl lic dtlses
	 * @param end the upper bound of the range of dgf fgl lic dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl lic dtlses
	 */
	@Override
	public List<DgfFglLicDtls> findBydgfFglLicDtlsListByNid(
		String nationalId, int start, int end,
		OrderByComparator<DgfFglLicDtls> orderByComparator,
		boolean useFinderCache) {

		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydgfFglLicDtlsListByNid;
				finderArgs = new Object[] {nationalId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBydgfFglLicDtlsListByNid;
			finderArgs = new Object[] {
				nationalId, start, end, orderByComparator
			};
		}

		List<DgfFglLicDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfFglLicDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfFglLicDtls dgfFglLicDtls : list) {
					if (!nationalId.equals(dgfFglLicDtls.getNationalId())) {
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

			sb.append(_SQL_SELECT_DGFFGLLICDTLS_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_DGFFGLLICDTLSLISTBYNID_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(_FINDER_COLUMN_DGFFGLLICDTLSLISTBYNID_NATIONALID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfFglLicDtlsModelImpl.ORDER_BY_JPQL);
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

				list = (List<DgfFglLicDtls>)QueryUtil.list(
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
	 * Returns the first dgf fgl lic dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl lic dtls
	 * @throws NoSuchDgfFglLicDtlsException if a matching dgf fgl lic dtls could not be found
	 */
	@Override
	public DgfFglLicDtls findBydgfFglLicDtlsListByNid_First(
			String nationalId,
			OrderByComparator<DgfFglLicDtls> orderByComparator)
		throws NoSuchDgfFglLicDtlsException {

		DgfFglLicDtls dgfFglLicDtls = fetchBydgfFglLicDtlsListByNid_First(
			nationalId, orderByComparator);

		if (dgfFglLicDtls != null) {
			return dgfFglLicDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationalId=");
		sb.append(nationalId);

		sb.append("}");

		throw new NoSuchDgfFglLicDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf fgl lic dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	@Override
	public DgfFglLicDtls fetchBydgfFglLicDtlsListByNid_First(
		String nationalId, OrderByComparator<DgfFglLicDtls> orderByComparator) {

		List<DgfFglLicDtls> list = findBydgfFglLicDtlsListByNid(
			nationalId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf fgl lic dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl lic dtls
	 * @throws NoSuchDgfFglLicDtlsException if a matching dgf fgl lic dtls could not be found
	 */
	@Override
	public DgfFglLicDtls findBydgfFglLicDtlsListByNid_Last(
			String nationalId,
			OrderByComparator<DgfFglLicDtls> orderByComparator)
		throws NoSuchDgfFglLicDtlsException {

		DgfFglLicDtls dgfFglLicDtls = fetchBydgfFglLicDtlsListByNid_Last(
			nationalId, orderByComparator);

		if (dgfFglLicDtls != null) {
			return dgfFglLicDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationalId=");
		sb.append(nationalId);

		sb.append("}");

		throw new NoSuchDgfFglLicDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf fgl lic dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	@Override
	public DgfFglLicDtls fetchBydgfFglLicDtlsListByNid_Last(
		String nationalId, OrderByComparator<DgfFglLicDtls> orderByComparator) {

		int count = countBydgfFglLicDtlsListByNid(nationalId);

		if (count == 0) {
			return null;
		}

		List<DgfFglLicDtls> list = findBydgfFglLicDtlsListByNid(
			nationalId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf fgl lic dtlses before and after the current dgf fgl lic dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param fglLicPrimaryId the primary key of the current dgf fgl lic dtls
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl lic dtls
	 * @throws NoSuchDgfFglLicDtlsException if a dgf fgl lic dtls with the primary key could not be found
	 */
	@Override
	public DgfFglLicDtls[] findBydgfFglLicDtlsListByNid_PrevAndNext(
			long fglLicPrimaryId, String nationalId,
			OrderByComparator<DgfFglLicDtls> orderByComparator)
		throws NoSuchDgfFglLicDtlsException {

		nationalId = Objects.toString(nationalId, "");

		DgfFglLicDtls dgfFglLicDtls = findByPrimaryKey(fglLicPrimaryId);

		Session session = null;

		try {
			session = openSession();

			DgfFglLicDtls[] array = new DgfFglLicDtlsImpl[3];

			array[0] = getBydgfFglLicDtlsListByNid_PrevAndNext(
				session, dgfFglLicDtls, nationalId, orderByComparator, true);

			array[1] = dgfFglLicDtls;

			array[2] = getBydgfFglLicDtlsListByNid_PrevAndNext(
				session, dgfFglLicDtls, nationalId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DgfFglLicDtls getBydgfFglLicDtlsListByNid_PrevAndNext(
		Session session, DgfFglLicDtls dgfFglLicDtls, String nationalId,
		OrderByComparator<DgfFglLicDtls> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DGFFGLLICDTLS_WHERE);

		boolean bindNationalId = false;

		if (nationalId.isEmpty()) {
			sb.append(_FINDER_COLUMN_DGFFGLLICDTLSLISTBYNID_NATIONALID_3);
		}
		else {
			bindNationalId = true;

			sb.append(_FINDER_COLUMN_DGFFGLLICDTLSLISTBYNID_NATIONALID_2);
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
			sb.append(DgfFglLicDtlsModelImpl.ORDER_BY_JPQL);
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
						dgfFglLicDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfFglLicDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf fgl lic dtlses where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	@Override
	public void removeBydgfFglLicDtlsListByNid(String nationalId) {
		for (DgfFglLicDtls dgfFglLicDtls :
				findBydgfFglLicDtlsListByNid(
					nationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgfFglLicDtls);
		}
	}

	/**
	 * Returns the number of dgf fgl lic dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf fgl lic dtlses
	 */
	@Override
	public int countBydgfFglLicDtlsListByNid(String nationalId) {
		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = _finderPathCountBydgfFglLicDtlsListByNid;

		Object[] finderArgs = new Object[] {nationalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFFGLLICDTLS_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_DGFFGLLICDTLSLISTBYNID_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(_FINDER_COLUMN_DGFFGLLICDTLSLISTBYNID_NATIONALID_2);
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
		_FINDER_COLUMN_DGFFGLLICDTLSLISTBYNID_NATIONALID_2 =
			"dgfFglLicDtls.nationalId = ?";

	private static final String
		_FINDER_COLUMN_DGFFGLLICDTLSLISTBYNID_NATIONALID_3 =
			"(dgfFglLicDtls.nationalId IS NULL OR dgfFglLicDtls.nationalId = '')";

	public DgfFglLicDtlsPersistenceImpl() {
		setModelClass(DgfFglLicDtls.class);

		setModelImplClass(DgfFglLicDtlsImpl.class);
		setModelPKClass(long.class);

		setTable(DgfFglLicDtlsTable.INSTANCE);
	}

	/**
	 * Caches the dgf fgl lic dtls in the entity cache if it is enabled.
	 *
	 * @param dgfFglLicDtls the dgf fgl lic dtls
	 */
	@Override
	public void cacheResult(DgfFglLicDtls dgfFglLicDtls) {
		entityCache.putResult(
			DgfFglLicDtlsImpl.class, dgfFglLicDtls.getPrimaryKey(),
			dgfFglLicDtls);

		finderCache.putResult(
			_finderPathFetchBydgfFglLicDtlsByFglLicPrePrimaryId,
			new Object[] {dgfFglLicDtls.getFglPrePrimaryId()}, dgfFglLicDtls);

		finderCache.putResult(
			_finderPathFetchBydgfFglLicDtlsByNationalId,
			new Object[] {dgfFglLicDtls.getNationalId()}, dgfFglLicDtls);

		finderCache.putResult(
			_finderPathFetchBydgfFglLicDtlsByFglApplicationNo,
			new Object[] {dgfFglLicDtls.getFglApplicationNo()}, dgfFglLicDtls);

		finderCache.putResult(
			_finderPathFetchBydgfFglLicDtlsByFoodgrainLicenseNo,
			new Object[] {dgfFglLicDtls.getFoodgrainLicenseNo()},
			dgfFglLicDtls);

		finderCache.putResult(
			_finderPathFetchBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo,
			new Object[] {
				dgfFglLicDtls.getNationalId(),
				dgfFglLicDtls.getFoodgrainLicenseNo()
			},
			dgfFglLicDtls);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dgf fgl lic dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfFglLicDtlses the dgf fgl lic dtlses
	 */
	@Override
	public void cacheResult(List<DgfFglLicDtls> dgfFglLicDtlses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgfFglLicDtlses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DgfFglLicDtls dgfFglLicDtls : dgfFglLicDtlses) {
			if (entityCache.getResult(
					DgfFglLicDtlsImpl.class, dgfFglLicDtls.getPrimaryKey()) ==
						null) {

				cacheResult(dgfFglLicDtls);
			}
		}
	}

	/**
	 * Clears the cache for all dgf fgl lic dtlses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DgfFglLicDtlsImpl.class);

		finderCache.clearCache(DgfFglLicDtlsImpl.class);
	}

	/**
	 * Clears the cache for the dgf fgl lic dtls.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DgfFglLicDtls dgfFglLicDtls) {
		entityCache.removeResult(DgfFglLicDtlsImpl.class, dgfFglLicDtls);
	}

	@Override
	public void clearCache(List<DgfFglLicDtls> dgfFglLicDtlses) {
		for (DgfFglLicDtls dgfFglLicDtls : dgfFglLicDtlses) {
			entityCache.removeResult(DgfFglLicDtlsImpl.class, dgfFglLicDtls);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DgfFglLicDtlsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DgfFglLicDtlsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DgfFglLicDtlsModelImpl dgfFglLicDtlsModelImpl) {

		Object[] args = new Object[] {
			dgfFglLicDtlsModelImpl.getFglPrePrimaryId()
		};

		finderCache.putResult(
			_finderPathCountBydgfFglLicDtlsByFglLicPrePrimaryId, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchBydgfFglLicDtlsByFglLicPrePrimaryId, args,
			dgfFglLicDtlsModelImpl);

		args = new Object[] {dgfFglLicDtlsModelImpl.getNationalId()};

		finderCache.putResult(
			_finderPathCountBydgfFglLicDtlsByNationalId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchBydgfFglLicDtlsByNationalId, args,
			dgfFglLicDtlsModelImpl);

		args = new Object[] {dgfFglLicDtlsModelImpl.getFglApplicationNo()};

		finderCache.putResult(
			_finderPathCountBydgfFglLicDtlsByFglApplicationNo, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchBydgfFglLicDtlsByFglApplicationNo, args,
			dgfFglLicDtlsModelImpl);

		args = new Object[] {dgfFglLicDtlsModelImpl.getFoodgrainLicenseNo()};

		finderCache.putResult(
			_finderPathCountBydgfFglLicDtlsByFoodgrainLicenseNo, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchBydgfFglLicDtlsByFoodgrainLicenseNo, args,
			dgfFglLicDtlsModelImpl);

		args = new Object[] {
			dgfFglLicDtlsModelImpl.getNationalId(),
			dgfFglLicDtlsModelImpl.getFoodgrainLicenseNo()
		};

		finderCache.putResult(
			_finderPathCountBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo,
			args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo,
			args, dgfFglLicDtlsModelImpl);
	}

	/**
	 * Creates a new dgf fgl lic dtls with the primary key. Does not add the dgf fgl lic dtls to the database.
	 *
	 * @param fglLicPrimaryId the primary key for the new dgf fgl lic dtls
	 * @return the new dgf fgl lic dtls
	 */
	@Override
	public DgfFglLicDtls create(long fglLicPrimaryId) {
		DgfFglLicDtls dgfFglLicDtls = new DgfFglLicDtlsImpl();

		dgfFglLicDtls.setNew(true);
		dgfFglLicDtls.setPrimaryKey(fglLicPrimaryId);

		return dgfFglLicDtls;
	}

	/**
	 * Removes the dgf fgl lic dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fglLicPrimaryId the primary key of the dgf fgl lic dtls
	 * @return the dgf fgl lic dtls that was removed
	 * @throws NoSuchDgfFglLicDtlsException if a dgf fgl lic dtls with the primary key could not be found
	 */
	@Override
	public DgfFglLicDtls remove(long fglLicPrimaryId)
		throws NoSuchDgfFglLicDtlsException {

		return remove((Serializable)fglLicPrimaryId);
	}

	/**
	 * Removes the dgf fgl lic dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dgf fgl lic dtls
	 * @return the dgf fgl lic dtls that was removed
	 * @throws NoSuchDgfFglLicDtlsException if a dgf fgl lic dtls with the primary key could not be found
	 */
	@Override
	public DgfFglLicDtls remove(Serializable primaryKey)
		throws NoSuchDgfFglLicDtlsException {

		Session session = null;

		try {
			session = openSession();

			DgfFglLicDtls dgfFglLicDtls = (DgfFglLicDtls)session.get(
				DgfFglLicDtlsImpl.class, primaryKey);

			if (dgfFglLicDtls == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDgfFglLicDtlsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgfFglLicDtls);
		}
		catch (NoSuchDgfFglLicDtlsException noSuchEntityException) {
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
	protected DgfFglLicDtls removeImpl(DgfFglLicDtls dgfFglLicDtls) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgfFglLicDtls)) {
				dgfFglLicDtls = (DgfFglLicDtls)session.get(
					DgfFglLicDtlsImpl.class, dgfFglLicDtls.getPrimaryKeyObj());
			}

			if (dgfFglLicDtls != null) {
				session.delete(dgfFglLicDtls);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgfFglLicDtls != null) {
			clearCache(dgfFglLicDtls);
		}

		return dgfFglLicDtls;
	}

	@Override
	public DgfFglLicDtls updateImpl(DgfFglLicDtls dgfFglLicDtls) {
		boolean isNew = dgfFglLicDtls.isNew();

		if (!(dgfFglLicDtls instanceof DgfFglLicDtlsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dgfFglLicDtls.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dgfFglLicDtls);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgfFglLicDtls proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DgfFglLicDtls implementation " +
					dgfFglLicDtls.getClass());
		}

		DgfFglLicDtlsModelImpl dgfFglLicDtlsModelImpl =
			(DgfFglLicDtlsModelImpl)dgfFglLicDtls;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgfFglLicDtls);
			}
			else {
				dgfFglLicDtls = (DgfFglLicDtls)session.merge(dgfFglLicDtls);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DgfFglLicDtlsImpl.class, dgfFglLicDtlsModelImpl, false, true);

		cacheUniqueFindersCache(dgfFglLicDtlsModelImpl);

		if (isNew) {
			dgfFglLicDtls.setNew(false);
		}

		dgfFglLicDtls.resetOriginalValues();

		return dgfFglLicDtls;
	}

	/**
	 * Returns the dgf fgl lic dtls with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dgf fgl lic dtls
	 * @return the dgf fgl lic dtls
	 * @throws NoSuchDgfFglLicDtlsException if a dgf fgl lic dtls with the primary key could not be found
	 */
	@Override
	public DgfFglLicDtls findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDgfFglLicDtlsException {

		DgfFglLicDtls dgfFglLicDtls = fetchByPrimaryKey(primaryKey);

		if (dgfFglLicDtls == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDgfFglLicDtlsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgfFglLicDtls;
	}

	/**
	 * Returns the dgf fgl lic dtls with the primary key or throws a <code>NoSuchDgfFglLicDtlsException</code> if it could not be found.
	 *
	 * @param fglLicPrimaryId the primary key of the dgf fgl lic dtls
	 * @return the dgf fgl lic dtls
	 * @throws NoSuchDgfFglLicDtlsException if a dgf fgl lic dtls with the primary key could not be found
	 */
	@Override
	public DgfFglLicDtls findByPrimaryKey(long fglLicPrimaryId)
		throws NoSuchDgfFglLicDtlsException {

		return findByPrimaryKey((Serializable)fglLicPrimaryId);
	}

	/**
	 * Returns the dgf fgl lic dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fglLicPrimaryId the primary key of the dgf fgl lic dtls
	 * @return the dgf fgl lic dtls, or <code>null</code> if a dgf fgl lic dtls with the primary key could not be found
	 */
	@Override
	public DgfFglLicDtls fetchByPrimaryKey(long fglLicPrimaryId) {
		return fetchByPrimaryKey((Serializable)fglLicPrimaryId);
	}

	/**
	 * Returns all the dgf fgl lic dtlses.
	 *
	 * @return the dgf fgl lic dtlses
	 */
	@Override
	public List<DgfFglLicDtls> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf fgl lic dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglLicDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl lic dtlses
	 * @param end the upper bound of the range of dgf fgl lic dtlses (not inclusive)
	 * @return the range of dgf fgl lic dtlses
	 */
	@Override
	public List<DgfFglLicDtls> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf fgl lic dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglLicDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl lic dtlses
	 * @param end the upper bound of the range of dgf fgl lic dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf fgl lic dtlses
	 */
	@Override
	public List<DgfFglLicDtls> findAll(
		int start, int end,
		OrderByComparator<DgfFglLicDtls> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf fgl lic dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglLicDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl lic dtlses
	 * @param end the upper bound of the range of dgf fgl lic dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf fgl lic dtlses
	 */
	@Override
	public List<DgfFglLicDtls> findAll(
		int start, int end, OrderByComparator<DgfFglLicDtls> orderByComparator,
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

		List<DgfFglLicDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfFglLicDtls>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFFGLLICDTLS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFFGLLICDTLS;

				sql = sql.concat(DgfFglLicDtlsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DgfFglLicDtls>)QueryUtil.list(
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
	 * Removes all the dgf fgl lic dtlses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DgfFglLicDtls dgfFglLicDtls : findAll()) {
			remove(dgfFglLicDtls);
		}
	}

	/**
	 * Returns the number of dgf fgl lic dtlses.
	 *
	 * @return the number of dgf fgl lic dtlses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DGFFGLLICDTLS);

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
		return "fglLicPrimaryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DGFFGLLICDTLS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DgfFglLicDtlsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dgf fgl lic dtls persistence.
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

		_finderPathFetchBydgfFglLicDtlsByFglLicPrePrimaryId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY,
			"fetchBydgfFglLicDtlsByFglLicPrePrimaryId",
			new String[] {Long.class.getName()},
			new String[] {"fglPrePrimaryId"}, true);

		_finderPathCountBydgfFglLicDtlsByFglLicPrePrimaryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfFglLicDtlsByFglLicPrePrimaryId",
			new String[] {Long.class.getName()},
			new String[] {"fglPrePrimaryId"}, false);

		_finderPathFetchBydgfFglLicDtlsByNationalId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBydgfFglLicDtlsByNationalId",
			new String[] {String.class.getName()}, new String[] {"nationalId"},
			true);

		_finderPathCountBydgfFglLicDtlsByNationalId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfFglLicDtlsByNationalId",
			new String[] {String.class.getName()}, new String[] {"nationalId"},
			false);

		_finderPathFetchBydgfFglLicDtlsByFglApplicationNo = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBydgfFglLicDtlsByFglApplicationNo",
			new String[] {String.class.getName()},
			new String[] {"fglApplicationNo"}, true);

		_finderPathCountBydgfFglLicDtlsByFglApplicationNo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfFglLicDtlsByFglApplicationNo",
			new String[] {String.class.getName()},
			new String[] {"fglApplicationNo"}, false);

		_finderPathFetchBydgfFglLicDtlsByFoodgrainLicenseNo = new FinderPath(
			FINDER_CLASS_NAME_ENTITY,
			"fetchBydgfFglLicDtlsByFoodgrainLicenseNo",
			new String[] {String.class.getName()},
			new String[] {"foodgrainLicenseNo"}, true);

		_finderPathCountBydgfFglLicDtlsByFoodgrainLicenseNo = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfFglLicDtlsByFoodgrainLicenseNo",
			new String[] {String.class.getName()},
			new String[] {"foodgrainLicenseNo"}, false);

		_finderPathFetchBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo =
			new FinderPath(
				FINDER_CLASS_NAME_ENTITY,
				"fetchBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo",
				new String[] {String.class.getName(), String.class.getName()},
				new String[] {"nationalId", "foodgrainLicenseNo"}, true);

		_finderPathCountBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo",
				new String[] {String.class.getName(), String.class.getName()},
				new String[] {"nationalId", "foodgrainLicenseNo"}, false);

		_finderPathWithPaginationFindBydgfFglLicDtlsListByNid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBydgfFglLicDtlsListByNid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"nationalId"}, true);

		_finderPathWithoutPaginationFindBydgfFglLicDtlsListByNid =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydgfFglLicDtlsListByNid",
				new String[] {String.class.getName()},
				new String[] {"nationalId"}, true);

		_finderPathCountBydgfFglLicDtlsListByNid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfFglLicDtlsListByNid",
			new String[] {String.class.getName()}, new String[] {"nationalId"},
			false);

		_setDgfFglLicDtlsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDgfFglLicDtlsUtilPersistence(null);

		entityCache.removeCache(DgfFglLicDtlsImpl.class.getName());
	}

	private void _setDgfFglLicDtlsUtilPersistence(
		DgfFglLicDtlsPersistence dgfFglLicDtlsPersistence) {

		try {
			Field field = DgfFglLicDtlsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dgfFglLicDtlsPersistence);
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

	private static final String _SQL_SELECT_DGFFGLLICDTLS =
		"SELECT dgfFglLicDtls FROM DgfFglLicDtls dgfFglLicDtls";

	private static final String _SQL_SELECT_DGFFGLLICDTLS_WHERE =
		"SELECT dgfFglLicDtls FROM DgfFglLicDtls dgfFglLicDtls WHERE ";

	private static final String _SQL_COUNT_DGFFGLLICDTLS =
		"SELECT COUNT(dgfFglLicDtls) FROM DgfFglLicDtls dgfFglLicDtls";

	private static final String _SQL_COUNT_DGFFGLLICDTLS_WHERE =
		"SELECT COUNT(dgfFglLicDtls) FROM DgfFglLicDtls dgfFglLicDtls WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dgfFglLicDtls.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DgfFglLicDtls exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DgfFglLicDtls exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DgfFglLicDtlsPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}