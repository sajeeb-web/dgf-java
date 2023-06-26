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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfFglProductDtlsException;
import bd.gov.dgfood.food.grain.license.model.DgfFglProductDtls;
import bd.gov.dgfood.food.grain.license.model.DgfFglProductDtlsTable;
import bd.gov.dgfood.food.grain.license.model.impl.DgfFglProductDtlsImpl;
import bd.gov.dgfood.food.grain.license.model.impl.DgfFglProductDtlsModelImpl;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfFglProductDtlsPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfFglProductDtlsUtil;
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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the dgf fgl product dtls service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DgfFglProductDtlsPersistence.class)
public class DgfFglProductDtlsPersistenceImpl
	extends BasePersistenceImpl<DgfFglProductDtls>
	implements DgfFglProductDtlsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DgfFglProductDtlsUtil</code> to access the dgf fgl product dtls persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DgfFglProductDtlsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath
		_finderPathWithPaginationFindBydgfFglProductDtlsByFglLicPrimaryId;
	private FinderPath
		_finderPathWithoutPaginationFindBydgfFglProductDtlsByFglLicPrimaryId;
	private FinderPath _finderPathCountBydgfFglProductDtlsByFglLicPrimaryId;

	/**
	 * Returns all the dgf fgl product dtlses where fglLicPrimaryId = &#63;.
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID
	 * @return the matching dgf fgl product dtlses
	 */
	@Override
	public List<DgfFglProductDtls> findBydgfFglProductDtlsByFglLicPrimaryId(
		long fglLicPrimaryId) {

		return findBydgfFglProductDtlsByFglLicPrimaryId(
			fglLicPrimaryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf fgl product dtlses where fglLicPrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglProductDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID
	 * @param start the lower bound of the range of dgf fgl product dtlses
	 * @param end the upper bound of the range of dgf fgl product dtlses (not inclusive)
	 * @return the range of matching dgf fgl product dtlses
	 */
	@Override
	public List<DgfFglProductDtls> findBydgfFglProductDtlsByFglLicPrimaryId(
		long fglLicPrimaryId, int start, int end) {

		return findBydgfFglProductDtlsByFglLicPrimaryId(
			fglLicPrimaryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf fgl product dtlses where fglLicPrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglProductDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID
	 * @param start the lower bound of the range of dgf fgl product dtlses
	 * @param end the upper bound of the range of dgf fgl product dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl product dtlses
	 */
	@Override
	public List<DgfFglProductDtls> findBydgfFglProductDtlsByFglLicPrimaryId(
		long fglLicPrimaryId, int start, int end,
		OrderByComparator<DgfFglProductDtls> orderByComparator) {

		return findBydgfFglProductDtlsByFglLicPrimaryId(
			fglLicPrimaryId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf fgl product dtlses where fglLicPrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglProductDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID
	 * @param start the lower bound of the range of dgf fgl product dtlses
	 * @param end the upper bound of the range of dgf fgl product dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl product dtlses
	 */
	@Override
	public List<DgfFglProductDtls> findBydgfFglProductDtlsByFglLicPrimaryId(
		long fglLicPrimaryId, int start, int end,
		OrderByComparator<DgfFglProductDtls> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydgfFglProductDtlsByFglLicPrimaryId;
				finderArgs = new Object[] {fglLicPrimaryId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBydgfFglProductDtlsByFglLicPrimaryId;
			finderArgs = new Object[] {
				fglLicPrimaryId, start, end, orderByComparator
			};
		}

		List<DgfFglProductDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfFglProductDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfFglProductDtls dgfFglProductDtls : list) {
					if (fglLicPrimaryId !=
							dgfFglProductDtls.getFglLicPrimaryId()) {

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

			sb.append(_SQL_SELECT_DGFFGLPRODUCTDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLPRODUCTDTLSBYFGLLICPRIMARYID_FGLLICPRIMARYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfFglProductDtlsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fglLicPrimaryId);

				list = (List<DgfFglProductDtls>)QueryUtil.list(
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
	 * Returns the first dgf fgl product dtls in the ordered set where fglLicPrimaryId = &#63;.
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl product dtls
	 * @throws NoSuchDgfFglProductDtlsException if a matching dgf fgl product dtls could not be found
	 */
	@Override
	public DgfFglProductDtls findBydgfFglProductDtlsByFglLicPrimaryId_First(
			long fglLicPrimaryId,
			OrderByComparator<DgfFglProductDtls> orderByComparator)
		throws NoSuchDgfFglProductDtlsException {

		DgfFglProductDtls dgfFglProductDtls =
			fetchBydgfFglProductDtlsByFglLicPrimaryId_First(
				fglLicPrimaryId, orderByComparator);

		if (dgfFglProductDtls != null) {
			return dgfFglProductDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fglLicPrimaryId=");
		sb.append(fglLicPrimaryId);

		sb.append("}");

		throw new NoSuchDgfFglProductDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf fgl product dtls in the ordered set where fglLicPrimaryId = &#63;.
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl product dtls, or <code>null</code> if a matching dgf fgl product dtls could not be found
	 */
	@Override
	public DgfFglProductDtls fetchBydgfFglProductDtlsByFglLicPrimaryId_First(
		long fglLicPrimaryId,
		OrderByComparator<DgfFglProductDtls> orderByComparator) {

		List<DgfFglProductDtls> list = findBydgfFglProductDtlsByFglLicPrimaryId(
			fglLicPrimaryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf fgl product dtls in the ordered set where fglLicPrimaryId = &#63;.
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl product dtls
	 * @throws NoSuchDgfFglProductDtlsException if a matching dgf fgl product dtls could not be found
	 */
	@Override
	public DgfFglProductDtls findBydgfFglProductDtlsByFglLicPrimaryId_Last(
			long fglLicPrimaryId,
			OrderByComparator<DgfFglProductDtls> orderByComparator)
		throws NoSuchDgfFglProductDtlsException {

		DgfFglProductDtls dgfFglProductDtls =
			fetchBydgfFglProductDtlsByFglLicPrimaryId_Last(
				fglLicPrimaryId, orderByComparator);

		if (dgfFglProductDtls != null) {
			return dgfFglProductDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fglLicPrimaryId=");
		sb.append(fglLicPrimaryId);

		sb.append("}");

		throw new NoSuchDgfFglProductDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf fgl product dtls in the ordered set where fglLicPrimaryId = &#63;.
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl product dtls, or <code>null</code> if a matching dgf fgl product dtls could not be found
	 */
	@Override
	public DgfFglProductDtls fetchBydgfFglProductDtlsByFglLicPrimaryId_Last(
		long fglLicPrimaryId,
		OrderByComparator<DgfFglProductDtls> orderByComparator) {

		int count = countBydgfFglProductDtlsByFglLicPrimaryId(fglLicPrimaryId);

		if (count == 0) {
			return null;
		}

		List<DgfFglProductDtls> list = findBydgfFglProductDtlsByFglLicPrimaryId(
			fglLicPrimaryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf fgl product dtlses before and after the current dgf fgl product dtls in the ordered set where fglLicPrimaryId = &#63;.
	 *
	 * @param fglProductPrimaryId the primary key of the current dgf fgl product dtls
	 * @param fglLicPrimaryId the fgl lic primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl product dtls
	 * @throws NoSuchDgfFglProductDtlsException if a dgf fgl product dtls with the primary key could not be found
	 */
	@Override
	public DgfFglProductDtls[]
			findBydgfFglProductDtlsByFglLicPrimaryId_PrevAndNext(
				long fglProductPrimaryId, long fglLicPrimaryId,
				OrderByComparator<DgfFglProductDtls> orderByComparator)
		throws NoSuchDgfFglProductDtlsException {

		DgfFglProductDtls dgfFglProductDtls = findByPrimaryKey(
			fglProductPrimaryId);

		Session session = null;

		try {
			session = openSession();

			DgfFglProductDtls[] array = new DgfFglProductDtlsImpl[3];

			array[0] = getBydgfFglProductDtlsByFglLicPrimaryId_PrevAndNext(
				session, dgfFglProductDtls, fglLicPrimaryId, orderByComparator,
				true);

			array[1] = dgfFglProductDtls;

			array[2] = getBydgfFglProductDtlsByFglLicPrimaryId_PrevAndNext(
				session, dgfFglProductDtls, fglLicPrimaryId, orderByComparator,
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

	protected DgfFglProductDtls
		getBydgfFglProductDtlsByFglLicPrimaryId_PrevAndNext(
			Session session, DgfFglProductDtls dgfFglProductDtls,
			long fglLicPrimaryId,
			OrderByComparator<DgfFglProductDtls> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFFGLPRODUCTDTLS_WHERE);

		sb.append(
			_FINDER_COLUMN_DGFFGLPRODUCTDTLSBYFGLLICPRIMARYID_FGLLICPRIMARYID_2);

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
			sb.append(DgfFglProductDtlsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(fglLicPrimaryId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfFglProductDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfFglProductDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf fgl product dtlses where fglLicPrimaryId = &#63; from the database.
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID
	 */
	@Override
	public void removeBydgfFglProductDtlsByFglLicPrimaryId(
		long fglLicPrimaryId) {

		for (DgfFglProductDtls dgfFglProductDtls :
				findBydgfFglProductDtlsByFglLicPrimaryId(
					fglLicPrimaryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgfFglProductDtls);
		}
	}

	/**
	 * Returns the number of dgf fgl product dtlses where fglLicPrimaryId = &#63;.
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID
	 * @return the number of matching dgf fgl product dtlses
	 */
	@Override
	public int countBydgfFglProductDtlsByFglLicPrimaryId(long fglLicPrimaryId) {
		FinderPath finderPath =
			_finderPathCountBydgfFglProductDtlsByFglLicPrimaryId;

		Object[] finderArgs = new Object[] {fglLicPrimaryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFFGLPRODUCTDTLS_WHERE);

			sb.append(
				_FINDER_COLUMN_DGFFGLPRODUCTDTLSBYFGLLICPRIMARYID_FGLLICPRIMARYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fglLicPrimaryId);

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
		_FINDER_COLUMN_DGFFGLPRODUCTDTLSBYFGLLICPRIMARYID_FGLLICPRIMARYID_2 =
			"dgfFglProductDtls.fglLicPrimaryId = ?";

	private FinderPath
		_finderPathWithPaginationFindBydgfFglProductDtlsByNationalId;
	private FinderPath
		_finderPathWithoutPaginationFindBydgfFglProductDtlsByNationalId;
	private FinderPath _finderPathCountBydgfFglProductDtlsByNationalId;

	/**
	 * Returns all the dgf fgl product dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf fgl product dtlses
	 */
	@Override
	public List<DgfFglProductDtls> findBydgfFglProductDtlsByNationalId(
		String nationalId) {

		return findBydgfFglProductDtlsByNationalId(
			nationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf fgl product dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglProductDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf fgl product dtlses
	 * @param end the upper bound of the range of dgf fgl product dtlses (not inclusive)
	 * @return the range of matching dgf fgl product dtlses
	 */
	@Override
	public List<DgfFglProductDtls> findBydgfFglProductDtlsByNationalId(
		String nationalId, int start, int end) {

		return findBydgfFglProductDtlsByNationalId(
			nationalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf fgl product dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglProductDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf fgl product dtlses
	 * @param end the upper bound of the range of dgf fgl product dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl product dtlses
	 */
	@Override
	public List<DgfFglProductDtls> findBydgfFglProductDtlsByNationalId(
		String nationalId, int start, int end,
		OrderByComparator<DgfFglProductDtls> orderByComparator) {

		return findBydgfFglProductDtlsByNationalId(
			nationalId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf fgl product dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglProductDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf fgl product dtlses
	 * @param end the upper bound of the range of dgf fgl product dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl product dtlses
	 */
	@Override
	public List<DgfFglProductDtls> findBydgfFglProductDtlsByNationalId(
		String nationalId, int start, int end,
		OrderByComparator<DgfFglProductDtls> orderByComparator,
		boolean useFinderCache) {

		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBydgfFglProductDtlsByNationalId;
				finderArgs = new Object[] {nationalId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBydgfFglProductDtlsByNationalId;
			finderArgs = new Object[] {
				nationalId, start, end, orderByComparator
			};
		}

		List<DgfFglProductDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfFglProductDtls>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfFglProductDtls dgfFglProductDtls : list) {
					if (!nationalId.equals(dgfFglProductDtls.getNationalId())) {
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

			sb.append(_SQL_SELECT_DGFFGLPRODUCTDTLS_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DGFFGLPRODUCTDTLSBYNATIONALID_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(
					_FINDER_COLUMN_DGFFGLPRODUCTDTLSBYNATIONALID_NATIONALID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfFglProductDtlsModelImpl.ORDER_BY_JPQL);
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

				list = (List<DgfFglProductDtls>)QueryUtil.list(
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
	 * Returns the first dgf fgl product dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl product dtls
	 * @throws NoSuchDgfFglProductDtlsException if a matching dgf fgl product dtls could not be found
	 */
	@Override
	public DgfFglProductDtls findBydgfFglProductDtlsByNationalId_First(
			String nationalId,
			OrderByComparator<DgfFglProductDtls> orderByComparator)
		throws NoSuchDgfFglProductDtlsException {

		DgfFglProductDtls dgfFglProductDtls =
			fetchBydgfFglProductDtlsByNationalId_First(
				nationalId, orderByComparator);

		if (dgfFglProductDtls != null) {
			return dgfFglProductDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationalId=");
		sb.append(nationalId);

		sb.append("}");

		throw new NoSuchDgfFglProductDtlsException(sb.toString());
	}

	/**
	 * Returns the first dgf fgl product dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl product dtls, or <code>null</code> if a matching dgf fgl product dtls could not be found
	 */
	@Override
	public DgfFglProductDtls fetchBydgfFglProductDtlsByNationalId_First(
		String nationalId,
		OrderByComparator<DgfFglProductDtls> orderByComparator) {

		List<DgfFglProductDtls> list = findBydgfFglProductDtlsByNationalId(
			nationalId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf fgl product dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl product dtls
	 * @throws NoSuchDgfFglProductDtlsException if a matching dgf fgl product dtls could not be found
	 */
	@Override
	public DgfFglProductDtls findBydgfFglProductDtlsByNationalId_Last(
			String nationalId,
			OrderByComparator<DgfFglProductDtls> orderByComparator)
		throws NoSuchDgfFglProductDtlsException {

		DgfFglProductDtls dgfFglProductDtls =
			fetchBydgfFglProductDtlsByNationalId_Last(
				nationalId, orderByComparator);

		if (dgfFglProductDtls != null) {
			return dgfFglProductDtls;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationalId=");
		sb.append(nationalId);

		sb.append("}");

		throw new NoSuchDgfFglProductDtlsException(sb.toString());
	}

	/**
	 * Returns the last dgf fgl product dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl product dtls, or <code>null</code> if a matching dgf fgl product dtls could not be found
	 */
	@Override
	public DgfFglProductDtls fetchBydgfFglProductDtlsByNationalId_Last(
		String nationalId,
		OrderByComparator<DgfFglProductDtls> orderByComparator) {

		int count = countBydgfFglProductDtlsByNationalId(nationalId);

		if (count == 0) {
			return null;
		}

		List<DgfFglProductDtls> list = findBydgfFglProductDtlsByNationalId(
			nationalId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf fgl product dtlses before and after the current dgf fgl product dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param fglProductPrimaryId the primary key of the current dgf fgl product dtls
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl product dtls
	 * @throws NoSuchDgfFglProductDtlsException if a dgf fgl product dtls with the primary key could not be found
	 */
	@Override
	public DgfFglProductDtls[] findBydgfFglProductDtlsByNationalId_PrevAndNext(
			long fglProductPrimaryId, String nationalId,
			OrderByComparator<DgfFglProductDtls> orderByComparator)
		throws NoSuchDgfFglProductDtlsException {

		nationalId = Objects.toString(nationalId, "");

		DgfFglProductDtls dgfFglProductDtls = findByPrimaryKey(
			fglProductPrimaryId);

		Session session = null;

		try {
			session = openSession();

			DgfFglProductDtls[] array = new DgfFglProductDtlsImpl[3];

			array[0] = getBydgfFglProductDtlsByNationalId_PrevAndNext(
				session, dgfFglProductDtls, nationalId, orderByComparator,
				true);

			array[1] = dgfFglProductDtls;

			array[2] = getBydgfFglProductDtlsByNationalId_PrevAndNext(
				session, dgfFglProductDtls, nationalId, orderByComparator,
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

	protected DgfFglProductDtls getBydgfFglProductDtlsByNationalId_PrevAndNext(
		Session session, DgfFglProductDtls dgfFglProductDtls, String nationalId,
		OrderByComparator<DgfFglProductDtls> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFFGLPRODUCTDTLS_WHERE);

		boolean bindNationalId = false;

		if (nationalId.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_DGFFGLPRODUCTDTLSBYNATIONALID_NATIONALID_3);
		}
		else {
			bindNationalId = true;

			sb.append(
				_FINDER_COLUMN_DGFFGLPRODUCTDTLSBYNATIONALID_NATIONALID_2);
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
			sb.append(DgfFglProductDtlsModelImpl.ORDER_BY_JPQL);
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
						dgfFglProductDtls)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfFglProductDtls> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf fgl product dtlses where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	@Override
	public void removeBydgfFglProductDtlsByNationalId(String nationalId) {
		for (DgfFglProductDtls dgfFglProductDtls :
				findBydgfFglProductDtlsByNationalId(
					nationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgfFglProductDtls);
		}
	}

	/**
	 * Returns the number of dgf fgl product dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf fgl product dtlses
	 */
	@Override
	public int countBydgfFglProductDtlsByNationalId(String nationalId) {
		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = _finderPathCountBydgfFglProductDtlsByNationalId;

		Object[] finderArgs = new Object[] {nationalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFFGLPRODUCTDTLS_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_DGFFGLPRODUCTDTLSBYNATIONALID_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(
					_FINDER_COLUMN_DGFFGLPRODUCTDTLSBYNATIONALID_NATIONALID_2);
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
		_FINDER_COLUMN_DGFFGLPRODUCTDTLSBYNATIONALID_NATIONALID_2 =
			"dgfFglProductDtls.nationalId = ?";

	private static final String
		_FINDER_COLUMN_DGFFGLPRODUCTDTLSBYNATIONALID_NATIONALID_3 =
			"(dgfFglProductDtls.nationalId IS NULL OR dgfFglProductDtls.nationalId = '')";

	public DgfFglProductDtlsPersistenceImpl() {
		setModelClass(DgfFglProductDtls.class);

		setModelImplClass(DgfFglProductDtlsImpl.class);
		setModelPKClass(long.class);

		setTable(DgfFglProductDtlsTable.INSTANCE);
	}

	/**
	 * Caches the dgf fgl product dtls in the entity cache if it is enabled.
	 *
	 * @param dgfFglProductDtls the dgf fgl product dtls
	 */
	@Override
	public void cacheResult(DgfFglProductDtls dgfFglProductDtls) {
		entityCache.putResult(
			DgfFglProductDtlsImpl.class, dgfFglProductDtls.getPrimaryKey(),
			dgfFglProductDtls);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dgf fgl product dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfFglProductDtlses the dgf fgl product dtlses
	 */
	@Override
	public void cacheResult(List<DgfFglProductDtls> dgfFglProductDtlses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgfFglProductDtlses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DgfFglProductDtls dgfFglProductDtls : dgfFglProductDtlses) {
			if (entityCache.getResult(
					DgfFglProductDtlsImpl.class,
					dgfFglProductDtls.getPrimaryKey()) == null) {

				cacheResult(dgfFglProductDtls);
			}
		}
	}

	/**
	 * Clears the cache for all dgf fgl product dtlses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DgfFglProductDtlsImpl.class);

		finderCache.clearCache(DgfFglProductDtlsImpl.class);
	}

	/**
	 * Clears the cache for the dgf fgl product dtls.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DgfFglProductDtls dgfFglProductDtls) {
		entityCache.removeResult(
			DgfFglProductDtlsImpl.class, dgfFglProductDtls);
	}

	@Override
	public void clearCache(List<DgfFglProductDtls> dgfFglProductDtlses) {
		for (DgfFglProductDtls dgfFglProductDtls : dgfFglProductDtlses) {
			entityCache.removeResult(
				DgfFglProductDtlsImpl.class, dgfFglProductDtls);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DgfFglProductDtlsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DgfFglProductDtlsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new dgf fgl product dtls with the primary key. Does not add the dgf fgl product dtls to the database.
	 *
	 * @param fglProductPrimaryId the primary key for the new dgf fgl product dtls
	 * @return the new dgf fgl product dtls
	 */
	@Override
	public DgfFglProductDtls create(long fglProductPrimaryId) {
		DgfFglProductDtls dgfFglProductDtls = new DgfFglProductDtlsImpl();

		dgfFglProductDtls.setNew(true);
		dgfFglProductDtls.setPrimaryKey(fglProductPrimaryId);

		return dgfFglProductDtls;
	}

	/**
	 * Removes the dgf fgl product dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fglProductPrimaryId the primary key of the dgf fgl product dtls
	 * @return the dgf fgl product dtls that was removed
	 * @throws NoSuchDgfFglProductDtlsException if a dgf fgl product dtls with the primary key could not be found
	 */
	@Override
	public DgfFglProductDtls remove(long fglProductPrimaryId)
		throws NoSuchDgfFglProductDtlsException {

		return remove((Serializable)fglProductPrimaryId);
	}

	/**
	 * Removes the dgf fgl product dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dgf fgl product dtls
	 * @return the dgf fgl product dtls that was removed
	 * @throws NoSuchDgfFglProductDtlsException if a dgf fgl product dtls with the primary key could not be found
	 */
	@Override
	public DgfFglProductDtls remove(Serializable primaryKey)
		throws NoSuchDgfFglProductDtlsException {

		Session session = null;

		try {
			session = openSession();

			DgfFglProductDtls dgfFglProductDtls =
				(DgfFglProductDtls)session.get(
					DgfFglProductDtlsImpl.class, primaryKey);

			if (dgfFglProductDtls == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDgfFglProductDtlsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgfFglProductDtls);
		}
		catch (NoSuchDgfFglProductDtlsException noSuchEntityException) {
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
	protected DgfFglProductDtls removeImpl(
		DgfFglProductDtls dgfFglProductDtls) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgfFglProductDtls)) {
				dgfFglProductDtls = (DgfFglProductDtls)session.get(
					DgfFglProductDtlsImpl.class,
					dgfFglProductDtls.getPrimaryKeyObj());
			}

			if (dgfFglProductDtls != null) {
				session.delete(dgfFglProductDtls);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgfFglProductDtls != null) {
			clearCache(dgfFglProductDtls);
		}

		return dgfFglProductDtls;
	}

	@Override
	public DgfFglProductDtls updateImpl(DgfFglProductDtls dgfFglProductDtls) {
		boolean isNew = dgfFglProductDtls.isNew();

		if (!(dgfFglProductDtls instanceof DgfFglProductDtlsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dgfFglProductDtls.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dgfFglProductDtls);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgfFglProductDtls proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DgfFglProductDtls implementation " +
					dgfFglProductDtls.getClass());
		}

		DgfFglProductDtlsModelImpl dgfFglProductDtlsModelImpl =
			(DgfFglProductDtlsModelImpl)dgfFglProductDtls;

		if (!dgfFglProductDtlsModelImpl.hasSetModifiedDate()) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				dgfFglProductDtls.setModifiedDate(date);
			}
			else {
				dgfFglProductDtls.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgfFglProductDtls);
			}
			else {
				dgfFglProductDtls = (DgfFglProductDtls)session.merge(
					dgfFglProductDtls);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DgfFglProductDtlsImpl.class, dgfFglProductDtlsModelImpl, false,
			true);

		if (isNew) {
			dgfFglProductDtls.setNew(false);
		}

		dgfFglProductDtls.resetOriginalValues();

		return dgfFglProductDtls;
	}

	/**
	 * Returns the dgf fgl product dtls with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dgf fgl product dtls
	 * @return the dgf fgl product dtls
	 * @throws NoSuchDgfFglProductDtlsException if a dgf fgl product dtls with the primary key could not be found
	 */
	@Override
	public DgfFglProductDtls findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDgfFglProductDtlsException {

		DgfFglProductDtls dgfFglProductDtls = fetchByPrimaryKey(primaryKey);

		if (dgfFglProductDtls == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDgfFglProductDtlsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgfFglProductDtls;
	}

	/**
	 * Returns the dgf fgl product dtls with the primary key or throws a <code>NoSuchDgfFglProductDtlsException</code> if it could not be found.
	 *
	 * @param fglProductPrimaryId the primary key of the dgf fgl product dtls
	 * @return the dgf fgl product dtls
	 * @throws NoSuchDgfFglProductDtlsException if a dgf fgl product dtls with the primary key could not be found
	 */
	@Override
	public DgfFglProductDtls findByPrimaryKey(long fglProductPrimaryId)
		throws NoSuchDgfFglProductDtlsException {

		return findByPrimaryKey((Serializable)fglProductPrimaryId);
	}

	/**
	 * Returns the dgf fgl product dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fglProductPrimaryId the primary key of the dgf fgl product dtls
	 * @return the dgf fgl product dtls, or <code>null</code> if a dgf fgl product dtls with the primary key could not be found
	 */
	@Override
	public DgfFglProductDtls fetchByPrimaryKey(long fglProductPrimaryId) {
		return fetchByPrimaryKey((Serializable)fglProductPrimaryId);
	}

	/**
	 * Returns all the dgf fgl product dtlses.
	 *
	 * @return the dgf fgl product dtlses
	 */
	@Override
	public List<DgfFglProductDtls> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf fgl product dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglProductDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl product dtlses
	 * @param end the upper bound of the range of dgf fgl product dtlses (not inclusive)
	 * @return the range of dgf fgl product dtlses
	 */
	@Override
	public List<DgfFglProductDtls> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf fgl product dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglProductDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl product dtlses
	 * @param end the upper bound of the range of dgf fgl product dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf fgl product dtlses
	 */
	@Override
	public List<DgfFglProductDtls> findAll(
		int start, int end,
		OrderByComparator<DgfFglProductDtls> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf fgl product dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglProductDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl product dtlses
	 * @param end the upper bound of the range of dgf fgl product dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf fgl product dtlses
	 */
	@Override
	public List<DgfFglProductDtls> findAll(
		int start, int end,
		OrderByComparator<DgfFglProductDtls> orderByComparator,
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

		List<DgfFglProductDtls> list = null;

		if (useFinderCache) {
			list = (List<DgfFglProductDtls>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFFGLPRODUCTDTLS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFFGLPRODUCTDTLS;

				sql = sql.concat(DgfFglProductDtlsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DgfFglProductDtls>)QueryUtil.list(
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
	 * Removes all the dgf fgl product dtlses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DgfFglProductDtls dgfFglProductDtls : findAll()) {
			remove(dgfFglProductDtls);
		}
	}

	/**
	 * Returns the number of dgf fgl product dtlses.
	 *
	 * @return the number of dgf fgl product dtlses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DGFFGLPRODUCTDTLS);

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
		return "fglProductPrimaryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DGFFGLPRODUCTDTLS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DgfFglProductDtlsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dgf fgl product dtls persistence.
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

		_finderPathWithPaginationFindBydgfFglProductDtlsByFglLicPrimaryId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBydgfFglProductDtlsByFglLicPrimaryId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"fglLicPrimaryId"}, true);

		_finderPathWithoutPaginationFindBydgfFglProductDtlsByFglLicPrimaryId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydgfFglProductDtlsByFglLicPrimaryId",
				new String[] {Long.class.getName()},
				new String[] {"fglLicPrimaryId"}, true);

		_finderPathCountBydgfFglProductDtlsByFglLicPrimaryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfFglProductDtlsByFglLicPrimaryId",
			new String[] {Long.class.getName()},
			new String[] {"fglLicPrimaryId"}, false);

		_finderPathWithPaginationFindBydgfFglProductDtlsByNationalId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBydgfFglProductDtlsByNationalId",
				new String[] {
					String.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"nationalId"}, true);

		_finderPathWithoutPaginationFindBydgfFglProductDtlsByNationalId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBydgfFglProductDtlsByNationalId",
				new String[] {String.class.getName()},
				new String[] {"nationalId"}, true);

		_finderPathCountBydgfFglProductDtlsByNationalId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydgfFglProductDtlsByNationalId",
			new String[] {String.class.getName()}, new String[] {"nationalId"},
			false);

		_setDgfFglProductDtlsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDgfFglProductDtlsUtilPersistence(null);

		entityCache.removeCache(DgfFglProductDtlsImpl.class.getName());
	}

	private void _setDgfFglProductDtlsUtilPersistence(
		DgfFglProductDtlsPersistence dgfFglProductDtlsPersistence) {

		try {
			Field field = DgfFglProductDtlsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dgfFglProductDtlsPersistence);
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

	private static final String _SQL_SELECT_DGFFGLPRODUCTDTLS =
		"SELECT dgfFglProductDtls FROM DgfFglProductDtls dgfFglProductDtls";

	private static final String _SQL_SELECT_DGFFGLPRODUCTDTLS_WHERE =
		"SELECT dgfFglProductDtls FROM DgfFglProductDtls dgfFglProductDtls WHERE ";

	private static final String _SQL_COUNT_DGFFGLPRODUCTDTLS =
		"SELECT COUNT(dgfFglProductDtls) FROM DgfFglProductDtls dgfFglProductDtls";

	private static final String _SQL_COUNT_DGFFGLPRODUCTDTLS_WHERE =
		"SELECT COUNT(dgfFglProductDtls) FROM DgfFglProductDtls dgfFglProductDtls WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dgfFglProductDtls.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DgfFglProductDtls exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DgfFglProductDtls exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DgfFglProductDtlsPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}