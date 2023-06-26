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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfUsersOtpDetailsException;
import bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetails;
import bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetailsTable;
import bd.gov.dgfood.food.grain.license.model.impl.DgfUsersOtpDetailsImpl;
import bd.gov.dgfood.food.grain.license.model.impl.DgfUsersOtpDetailsModelImpl;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfUsersOtpDetailsPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfUsersOtpDetailsUtil;
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
 * The persistence implementation for the dgf users otp details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DgfUsersOtpDetailsPersistence.class)
public class DgfUsersOtpDetailsPersistenceImpl
	extends BasePersistenceImpl<DgfUsersOtpDetails>
	implements DgfUsersOtpDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DgfUsersOtpDetailsUtil</code> to access the dgf users otp details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DgfUsersOtpDetailsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBymobileNumberFinder;
	private FinderPath _finderPathWithoutPaginationFindBymobileNumberFinder;
	private FinderPath _finderPathCountBymobileNumberFinder;

	/**
	 * Returns all the dgf users otp detailses where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @return the matching dgf users otp detailses
	 */
	@Override
	public List<DgfUsersOtpDetails> findBymobileNumberFinder(String mobileNo) {
		return findBymobileNumberFinder(
			mobileNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf users otp detailses where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @return the range of matching dgf users otp detailses
	 */
	@Override
	public List<DgfUsersOtpDetails> findBymobileNumberFinder(
		String mobileNo, int start, int end) {

		return findBymobileNumberFinder(mobileNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf users otp detailses where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users otp detailses
	 */
	@Override
	public List<DgfUsersOtpDetails> findBymobileNumberFinder(
		String mobileNo, int start, int end,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator) {

		return findBymobileNumberFinder(
			mobileNo, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf users otp detailses where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users otp detailses
	 */
	@Override
	public List<DgfUsersOtpDetails> findBymobileNumberFinder(
		String mobileNo, int start, int end,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator,
		boolean useFinderCache) {

		mobileNo = Objects.toString(mobileNo, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBymobileNumberFinder;
				finderArgs = new Object[] {mobileNo};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBymobileNumberFinder;
			finderArgs = new Object[] {mobileNo, start, end, orderByComparator};
		}

		List<DgfUsersOtpDetails> list = null;

		if (useFinderCache) {
			list = (List<DgfUsersOtpDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfUsersOtpDetails dgfUsersOtpDetails : list) {
					if (!mobileNo.equals(dgfUsersOtpDetails.getMobileNo())) {
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

			sb.append(_SQL_SELECT_DGFUSERSOTPDETAILS_WHERE);

			boolean bindMobileNo = false;

			if (mobileNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_MOBILENUMBERFINDER_MOBILENO_3);
			}
			else {
				bindMobileNo = true;

				sb.append(_FINDER_COLUMN_MOBILENUMBERFINDER_MOBILENO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfUsersOtpDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindMobileNo) {
					queryPos.add(mobileNo);
				}

				list = (List<DgfUsersOtpDetails>)QueryUtil.list(
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
	 * Returns the first dgf users otp details in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a matching dgf users otp details could not be found
	 */
	@Override
	public DgfUsersOtpDetails findBymobileNumberFinder_First(
			String mobileNo,
			OrderByComparator<DgfUsersOtpDetails> orderByComparator)
		throws NoSuchDgfUsersOtpDetailsException {

		DgfUsersOtpDetails dgfUsersOtpDetails = fetchBymobileNumberFinder_First(
			mobileNo, orderByComparator);

		if (dgfUsersOtpDetails != null) {
			return dgfUsersOtpDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mobileNo=");
		sb.append(mobileNo);

		sb.append("}");

		throw new NoSuchDgfUsersOtpDetailsException(sb.toString());
	}

	/**
	 * Returns the first dgf users otp details in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users otp details, or <code>null</code> if a matching dgf users otp details could not be found
	 */
	@Override
	public DgfUsersOtpDetails fetchBymobileNumberFinder_First(
		String mobileNo,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator) {

		List<DgfUsersOtpDetails> list = findBymobileNumberFinder(
			mobileNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf users otp details in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a matching dgf users otp details could not be found
	 */
	@Override
	public DgfUsersOtpDetails findBymobileNumberFinder_Last(
			String mobileNo,
			OrderByComparator<DgfUsersOtpDetails> orderByComparator)
		throws NoSuchDgfUsersOtpDetailsException {

		DgfUsersOtpDetails dgfUsersOtpDetails = fetchBymobileNumberFinder_Last(
			mobileNo, orderByComparator);

		if (dgfUsersOtpDetails != null) {
			return dgfUsersOtpDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mobileNo=");
		sb.append(mobileNo);

		sb.append("}");

		throw new NoSuchDgfUsersOtpDetailsException(sb.toString());
	}

	/**
	 * Returns the last dgf users otp details in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users otp details, or <code>null</code> if a matching dgf users otp details could not be found
	 */
	@Override
	public DgfUsersOtpDetails fetchBymobileNumberFinder_Last(
		String mobileNo,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator) {

		int count = countBymobileNumberFinder(mobileNo);

		if (count == 0) {
			return null;
		}

		List<DgfUsersOtpDetails> list = findBymobileNumberFinder(
			mobileNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf users otp detailses before and after the current dgf users otp details in the ordered set where mobileNo = &#63;.
	 *
	 * @param otpId the primary key of the current dgf users otp details
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a dgf users otp details with the primary key could not be found
	 */
	@Override
	public DgfUsersOtpDetails[] findBymobileNumberFinder_PrevAndNext(
			long otpId, String mobileNo,
			OrderByComparator<DgfUsersOtpDetails> orderByComparator)
		throws NoSuchDgfUsersOtpDetailsException {

		mobileNo = Objects.toString(mobileNo, "");

		DgfUsersOtpDetails dgfUsersOtpDetails = findByPrimaryKey(otpId);

		Session session = null;

		try {
			session = openSession();

			DgfUsersOtpDetails[] array = new DgfUsersOtpDetailsImpl[3];

			array[0] = getBymobileNumberFinder_PrevAndNext(
				session, dgfUsersOtpDetails, mobileNo, orderByComparator, true);

			array[1] = dgfUsersOtpDetails;

			array[2] = getBymobileNumberFinder_PrevAndNext(
				session, dgfUsersOtpDetails, mobileNo, orderByComparator,
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

	protected DgfUsersOtpDetails getBymobileNumberFinder_PrevAndNext(
		Session session, DgfUsersOtpDetails dgfUsersOtpDetails, String mobileNo,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFUSERSOTPDETAILS_WHERE);

		boolean bindMobileNo = false;

		if (mobileNo.isEmpty()) {
			sb.append(_FINDER_COLUMN_MOBILENUMBERFINDER_MOBILENO_3);
		}
		else {
			bindMobileNo = true;

			sb.append(_FINDER_COLUMN_MOBILENUMBERFINDER_MOBILENO_2);
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
			sb.append(DgfUsersOtpDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindMobileNo) {
			queryPos.add(mobileNo);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfUsersOtpDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfUsersOtpDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf users otp detailses where mobileNo = &#63; from the database.
	 *
	 * @param mobileNo the mobile no
	 */
	@Override
	public void removeBymobileNumberFinder(String mobileNo) {
		for (DgfUsersOtpDetails dgfUsersOtpDetails :
				findBymobileNumberFinder(
					mobileNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgfUsersOtpDetails);
		}
	}

	/**
	 * Returns the number of dgf users otp detailses where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @return the number of matching dgf users otp detailses
	 */
	@Override
	public int countBymobileNumberFinder(String mobileNo) {
		mobileNo = Objects.toString(mobileNo, "");

		FinderPath finderPath = _finderPathCountBymobileNumberFinder;

		Object[] finderArgs = new Object[] {mobileNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFUSERSOTPDETAILS_WHERE);

			boolean bindMobileNo = false;

			if (mobileNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_MOBILENUMBERFINDER_MOBILENO_3);
			}
			else {
				bindMobileNo = true;

				sb.append(_FINDER_COLUMN_MOBILENUMBERFINDER_MOBILENO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindMobileNo) {
					queryPos.add(mobileNo);
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

	private static final String _FINDER_COLUMN_MOBILENUMBERFINDER_MOBILENO_2 =
		"dgfUsersOtpDetails.mobileNo = ?";

	private static final String _FINDER_COLUMN_MOBILENUMBERFINDER_MOBILENO_3 =
		"(dgfUsersOtpDetails.mobileNo IS NULL OR dgfUsersOtpDetails.mobileNo = '')";

	private FinderPath _finderPathWithPaginationFindBynationalIdfinder;
	private FinderPath _finderPathWithoutPaginationFindBynationalIdfinder;
	private FinderPath _finderPathCountBynationalIdfinder;

	/**
	 * Returns all the dgf users otp detailses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf users otp detailses
	 */
	@Override
	public List<DgfUsersOtpDetails> findBynationalIdfinder(String nationalId) {
		return findBynationalIdfinder(
			nationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf users otp detailses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @return the range of matching dgf users otp detailses
	 */
	@Override
	public List<DgfUsersOtpDetails> findBynationalIdfinder(
		String nationalId, int start, int end) {

		return findBynationalIdfinder(nationalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf users otp detailses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users otp detailses
	 */
	@Override
	public List<DgfUsersOtpDetails> findBynationalIdfinder(
		String nationalId, int start, int end,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator) {

		return findBynationalIdfinder(
			nationalId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf users otp detailses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users otp detailses
	 */
	@Override
	public List<DgfUsersOtpDetails> findBynationalIdfinder(
		String nationalId, int start, int end,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator,
		boolean useFinderCache) {

		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBynationalIdfinder;
				finderArgs = new Object[] {nationalId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBynationalIdfinder;
			finderArgs = new Object[] {
				nationalId, start, end, orderByComparator
			};
		}

		List<DgfUsersOtpDetails> list = null;

		if (useFinderCache) {
			list = (List<DgfUsersOtpDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfUsersOtpDetails dgfUsersOtpDetails : list) {
					if (!nationalId.equals(
							dgfUsersOtpDetails.getNationalId())) {

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

			sb.append(_SQL_SELECT_DGFUSERSOTPDETAILS_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_NATIONALIDFINDER_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(_FINDER_COLUMN_NATIONALIDFINDER_NATIONALID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfUsersOtpDetailsModelImpl.ORDER_BY_JPQL);
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

				list = (List<DgfUsersOtpDetails>)QueryUtil.list(
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
	 * Returns the first dgf users otp details in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a matching dgf users otp details could not be found
	 */
	@Override
	public DgfUsersOtpDetails findBynationalIdfinder_First(
			String nationalId,
			OrderByComparator<DgfUsersOtpDetails> orderByComparator)
		throws NoSuchDgfUsersOtpDetailsException {

		DgfUsersOtpDetails dgfUsersOtpDetails = fetchBynationalIdfinder_First(
			nationalId, orderByComparator);

		if (dgfUsersOtpDetails != null) {
			return dgfUsersOtpDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationalId=");
		sb.append(nationalId);

		sb.append("}");

		throw new NoSuchDgfUsersOtpDetailsException(sb.toString());
	}

	/**
	 * Returns the first dgf users otp details in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users otp details, or <code>null</code> if a matching dgf users otp details could not be found
	 */
	@Override
	public DgfUsersOtpDetails fetchBynationalIdfinder_First(
		String nationalId,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator) {

		List<DgfUsersOtpDetails> list = findBynationalIdfinder(
			nationalId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf users otp details in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a matching dgf users otp details could not be found
	 */
	@Override
	public DgfUsersOtpDetails findBynationalIdfinder_Last(
			String nationalId,
			OrderByComparator<DgfUsersOtpDetails> orderByComparator)
		throws NoSuchDgfUsersOtpDetailsException {

		DgfUsersOtpDetails dgfUsersOtpDetails = fetchBynationalIdfinder_Last(
			nationalId, orderByComparator);

		if (dgfUsersOtpDetails != null) {
			return dgfUsersOtpDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nationalId=");
		sb.append(nationalId);

		sb.append("}");

		throw new NoSuchDgfUsersOtpDetailsException(sb.toString());
	}

	/**
	 * Returns the last dgf users otp details in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users otp details, or <code>null</code> if a matching dgf users otp details could not be found
	 */
	@Override
	public DgfUsersOtpDetails fetchBynationalIdfinder_Last(
		String nationalId,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator) {

		int count = countBynationalIdfinder(nationalId);

		if (count == 0) {
			return null;
		}

		List<DgfUsersOtpDetails> list = findBynationalIdfinder(
			nationalId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf users otp detailses before and after the current dgf users otp details in the ordered set where nationalId = &#63;.
	 *
	 * @param otpId the primary key of the current dgf users otp details
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a dgf users otp details with the primary key could not be found
	 */
	@Override
	public DgfUsersOtpDetails[] findBynationalIdfinder_PrevAndNext(
			long otpId, String nationalId,
			OrderByComparator<DgfUsersOtpDetails> orderByComparator)
		throws NoSuchDgfUsersOtpDetailsException {

		nationalId = Objects.toString(nationalId, "");

		DgfUsersOtpDetails dgfUsersOtpDetails = findByPrimaryKey(otpId);

		Session session = null;

		try {
			session = openSession();

			DgfUsersOtpDetails[] array = new DgfUsersOtpDetailsImpl[3];

			array[0] = getBynationalIdfinder_PrevAndNext(
				session, dgfUsersOtpDetails, nationalId, orderByComparator,
				true);

			array[1] = dgfUsersOtpDetails;

			array[2] = getBynationalIdfinder_PrevAndNext(
				session, dgfUsersOtpDetails, nationalId, orderByComparator,
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

	protected DgfUsersOtpDetails getBynationalIdfinder_PrevAndNext(
		Session session, DgfUsersOtpDetails dgfUsersOtpDetails,
		String nationalId,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFUSERSOTPDETAILS_WHERE);

		boolean bindNationalId = false;

		if (nationalId.isEmpty()) {
			sb.append(_FINDER_COLUMN_NATIONALIDFINDER_NATIONALID_3);
		}
		else {
			bindNationalId = true;

			sb.append(_FINDER_COLUMN_NATIONALIDFINDER_NATIONALID_2);
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
			sb.append(DgfUsersOtpDetailsModelImpl.ORDER_BY_JPQL);
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
						dgfUsersOtpDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfUsersOtpDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf users otp detailses where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	@Override
	public void removeBynationalIdfinder(String nationalId) {
		for (DgfUsersOtpDetails dgfUsersOtpDetails :
				findBynationalIdfinder(
					nationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgfUsersOtpDetails);
		}
	}

	/**
	 * Returns the number of dgf users otp detailses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf users otp detailses
	 */
	@Override
	public int countBynationalIdfinder(String nationalId) {
		nationalId = Objects.toString(nationalId, "");

		FinderPath finderPath = _finderPathCountBynationalIdfinder;

		Object[] finderArgs = new Object[] {nationalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFUSERSOTPDETAILS_WHERE);

			boolean bindNationalId = false;

			if (nationalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_NATIONALIDFINDER_NATIONALID_3);
			}
			else {
				bindNationalId = true;

				sb.append(_FINDER_COLUMN_NATIONALIDFINDER_NATIONALID_2);
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

	private static final String _FINDER_COLUMN_NATIONALIDFINDER_NATIONALID_2 =
		"dgfUsersOtpDetails.nationalId = ?";

	private static final String _FINDER_COLUMN_NATIONALIDFINDER_NATIONALID_3 =
		"(dgfUsersOtpDetails.nationalId IS NULL OR dgfUsersOtpDetails.nationalId = '')";

	private FinderPath _finderPathWithPaginationFindByuserIdFinder;
	private FinderPath _finderPathWithoutPaginationFindByuserIdFinder;
	private FinderPath _finderPathCountByuserIdFinder;

	/**
	 * Returns all the dgf users otp detailses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching dgf users otp detailses
	 */
	@Override
	public List<DgfUsersOtpDetails> findByuserIdFinder(long userId) {
		return findByuserIdFinder(
			userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf users otp detailses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @return the range of matching dgf users otp detailses
	 */
	@Override
	public List<DgfUsersOtpDetails> findByuserIdFinder(
		long userId, int start, int end) {

		return findByuserIdFinder(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf users otp detailses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users otp detailses
	 */
	@Override
	public List<DgfUsersOtpDetails> findByuserIdFinder(
		long userId, int start, int end,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator) {

		return findByuserIdFinder(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf users otp detailses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users otp detailses
	 */
	@Override
	public List<DgfUsersOtpDetails> findByuserIdFinder(
		long userId, int start, int end,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByuserIdFinder;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByuserIdFinder;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<DgfUsersOtpDetails> list = null;

		if (useFinderCache) {
			list = (List<DgfUsersOtpDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfUsersOtpDetails dgfUsersOtpDetails : list) {
					if (userId != dgfUsersOtpDetails.getUserId()) {
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

			sb.append(_SQL_SELECT_DGFUSERSOTPDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_USERIDFINDER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfUsersOtpDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<DgfUsersOtpDetails>)QueryUtil.list(
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
	 * Returns the first dgf users otp details in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a matching dgf users otp details could not be found
	 */
	@Override
	public DgfUsersOtpDetails findByuserIdFinder_First(
			long userId,
			OrderByComparator<DgfUsersOtpDetails> orderByComparator)
		throws NoSuchDgfUsersOtpDetailsException {

		DgfUsersOtpDetails dgfUsersOtpDetails = fetchByuserIdFinder_First(
			userId, orderByComparator);

		if (dgfUsersOtpDetails != null) {
			return dgfUsersOtpDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchDgfUsersOtpDetailsException(sb.toString());
	}

	/**
	 * Returns the first dgf users otp details in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users otp details, or <code>null</code> if a matching dgf users otp details could not be found
	 */
	@Override
	public DgfUsersOtpDetails fetchByuserIdFinder_First(
		long userId, OrderByComparator<DgfUsersOtpDetails> orderByComparator) {

		List<DgfUsersOtpDetails> list = findByuserIdFinder(
			userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf users otp details in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a matching dgf users otp details could not be found
	 */
	@Override
	public DgfUsersOtpDetails findByuserIdFinder_Last(
			long userId,
			OrderByComparator<DgfUsersOtpDetails> orderByComparator)
		throws NoSuchDgfUsersOtpDetailsException {

		DgfUsersOtpDetails dgfUsersOtpDetails = fetchByuserIdFinder_Last(
			userId, orderByComparator);

		if (dgfUsersOtpDetails != null) {
			return dgfUsersOtpDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchDgfUsersOtpDetailsException(sb.toString());
	}

	/**
	 * Returns the last dgf users otp details in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users otp details, or <code>null</code> if a matching dgf users otp details could not be found
	 */
	@Override
	public DgfUsersOtpDetails fetchByuserIdFinder_Last(
		long userId, OrderByComparator<DgfUsersOtpDetails> orderByComparator) {

		int count = countByuserIdFinder(userId);

		if (count == 0) {
			return null;
		}

		List<DgfUsersOtpDetails> list = findByuserIdFinder(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf users otp detailses before and after the current dgf users otp details in the ordered set where userId = &#63;.
	 *
	 * @param otpId the primary key of the current dgf users otp details
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a dgf users otp details with the primary key could not be found
	 */
	@Override
	public DgfUsersOtpDetails[] findByuserIdFinder_PrevAndNext(
			long otpId, long userId,
			OrderByComparator<DgfUsersOtpDetails> orderByComparator)
		throws NoSuchDgfUsersOtpDetailsException {

		DgfUsersOtpDetails dgfUsersOtpDetails = findByPrimaryKey(otpId);

		Session session = null;

		try {
			session = openSession();

			DgfUsersOtpDetails[] array = new DgfUsersOtpDetailsImpl[3];

			array[0] = getByuserIdFinder_PrevAndNext(
				session, dgfUsersOtpDetails, userId, orderByComparator, true);

			array[1] = dgfUsersOtpDetails;

			array[2] = getByuserIdFinder_PrevAndNext(
				session, dgfUsersOtpDetails, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DgfUsersOtpDetails getByuserIdFinder_PrevAndNext(
		Session session, DgfUsersOtpDetails dgfUsersOtpDetails, long userId,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFUSERSOTPDETAILS_WHERE);

		sb.append(_FINDER_COLUMN_USERIDFINDER_USERID_2);

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
			sb.append(DgfUsersOtpDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfUsersOtpDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfUsersOtpDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf users otp detailses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByuserIdFinder(long userId) {
		for (DgfUsersOtpDetails dgfUsersOtpDetails :
				findByuserIdFinder(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgfUsersOtpDetails);
		}
	}

	/**
	 * Returns the number of dgf users otp detailses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching dgf users otp detailses
	 */
	@Override
	public int countByuserIdFinder(long userId) {
		FinderPath finderPath = _finderPathCountByuserIdFinder;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFUSERSOTPDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_USERIDFINDER_USERID_2);

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

	private static final String _FINDER_COLUMN_USERIDFINDER_USERID_2 =
		"dgfUsersOtpDetails.userId = ?";

	private FinderPath _finderPathWithPaginationFindByisSent;
	private FinderPath _finderPathWithoutPaginationFindByisSent;
	private FinderPath _finderPathCountByisSent;

	/**
	 * Returns all the dgf users otp detailses where isSent = &#63;.
	 *
	 * @param isSent the is sent
	 * @return the matching dgf users otp detailses
	 */
	@Override
	public List<DgfUsersOtpDetails> findByisSent(boolean isSent) {
		return findByisSent(isSent, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf users otp detailses where isSent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param isSent the is sent
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @return the range of matching dgf users otp detailses
	 */
	@Override
	public List<DgfUsersOtpDetails> findByisSent(
		boolean isSent, int start, int end) {

		return findByisSent(isSent, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf users otp detailses where isSent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param isSent the is sent
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users otp detailses
	 */
	@Override
	public List<DgfUsersOtpDetails> findByisSent(
		boolean isSent, int start, int end,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator) {

		return findByisSent(isSent, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf users otp detailses where isSent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param isSent the is sent
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users otp detailses
	 */
	@Override
	public List<DgfUsersOtpDetails> findByisSent(
		boolean isSent, int start, int end,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByisSent;
				finderArgs = new Object[] {isSent};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByisSent;
			finderArgs = new Object[] {isSent, start, end, orderByComparator};
		}

		List<DgfUsersOtpDetails> list = null;

		if (useFinderCache) {
			list = (List<DgfUsersOtpDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfUsersOtpDetails dgfUsersOtpDetails : list) {
					if (isSent != dgfUsersOtpDetails.isIsSent()) {
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

			sb.append(_SQL_SELECT_DGFUSERSOTPDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_ISSENT_ISSENT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfUsersOtpDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isSent);

				list = (List<DgfUsersOtpDetails>)QueryUtil.list(
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
	 * Returns the first dgf users otp details in the ordered set where isSent = &#63;.
	 *
	 * @param isSent the is sent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a matching dgf users otp details could not be found
	 */
	@Override
	public DgfUsersOtpDetails findByisSent_First(
			boolean isSent,
			OrderByComparator<DgfUsersOtpDetails> orderByComparator)
		throws NoSuchDgfUsersOtpDetailsException {

		DgfUsersOtpDetails dgfUsersOtpDetails = fetchByisSent_First(
			isSent, orderByComparator);

		if (dgfUsersOtpDetails != null) {
			return dgfUsersOtpDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isSent=");
		sb.append(isSent);

		sb.append("}");

		throw new NoSuchDgfUsersOtpDetailsException(sb.toString());
	}

	/**
	 * Returns the first dgf users otp details in the ordered set where isSent = &#63;.
	 *
	 * @param isSent the is sent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users otp details, or <code>null</code> if a matching dgf users otp details could not be found
	 */
	@Override
	public DgfUsersOtpDetails fetchByisSent_First(
		boolean isSent,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator) {

		List<DgfUsersOtpDetails> list = findByisSent(
			isSent, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf users otp details in the ordered set where isSent = &#63;.
	 *
	 * @param isSent the is sent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a matching dgf users otp details could not be found
	 */
	@Override
	public DgfUsersOtpDetails findByisSent_Last(
			boolean isSent,
			OrderByComparator<DgfUsersOtpDetails> orderByComparator)
		throws NoSuchDgfUsersOtpDetailsException {

		DgfUsersOtpDetails dgfUsersOtpDetails = fetchByisSent_Last(
			isSent, orderByComparator);

		if (dgfUsersOtpDetails != null) {
			return dgfUsersOtpDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isSent=");
		sb.append(isSent);

		sb.append("}");

		throw new NoSuchDgfUsersOtpDetailsException(sb.toString());
	}

	/**
	 * Returns the last dgf users otp details in the ordered set where isSent = &#63;.
	 *
	 * @param isSent the is sent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users otp details, or <code>null</code> if a matching dgf users otp details could not be found
	 */
	@Override
	public DgfUsersOtpDetails fetchByisSent_Last(
		boolean isSent,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator) {

		int count = countByisSent(isSent);

		if (count == 0) {
			return null;
		}

		List<DgfUsersOtpDetails> list = findByisSent(
			isSent, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf users otp detailses before and after the current dgf users otp details in the ordered set where isSent = &#63;.
	 *
	 * @param otpId the primary key of the current dgf users otp details
	 * @param isSent the is sent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a dgf users otp details with the primary key could not be found
	 */
	@Override
	public DgfUsersOtpDetails[] findByisSent_PrevAndNext(
			long otpId, boolean isSent,
			OrderByComparator<DgfUsersOtpDetails> orderByComparator)
		throws NoSuchDgfUsersOtpDetailsException {

		DgfUsersOtpDetails dgfUsersOtpDetails = findByPrimaryKey(otpId);

		Session session = null;

		try {
			session = openSession();

			DgfUsersOtpDetails[] array = new DgfUsersOtpDetailsImpl[3];

			array[0] = getByisSent_PrevAndNext(
				session, dgfUsersOtpDetails, isSent, orderByComparator, true);

			array[1] = dgfUsersOtpDetails;

			array[2] = getByisSent_PrevAndNext(
				session, dgfUsersOtpDetails, isSent, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DgfUsersOtpDetails getByisSent_PrevAndNext(
		Session session, DgfUsersOtpDetails dgfUsersOtpDetails, boolean isSent,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFUSERSOTPDETAILS_WHERE);

		sb.append(_FINDER_COLUMN_ISSENT_ISSENT_2);

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
			sb.append(DgfUsersOtpDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(isSent);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfUsersOtpDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfUsersOtpDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf users otp detailses where isSent = &#63; from the database.
	 *
	 * @param isSent the is sent
	 */
	@Override
	public void removeByisSent(boolean isSent) {
		for (DgfUsersOtpDetails dgfUsersOtpDetails :
				findByisSent(
					isSent, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgfUsersOtpDetails);
		}
	}

	/**
	 * Returns the number of dgf users otp detailses where isSent = &#63;.
	 *
	 * @param isSent the is sent
	 * @return the number of matching dgf users otp detailses
	 */
	@Override
	public int countByisSent(boolean isSent) {
		FinderPath finderPath = _finderPathCountByisSent;

		Object[] finderArgs = new Object[] {isSent};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFUSERSOTPDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_ISSENT_ISSENT_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isSent);

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

	private static final String _FINDER_COLUMN_ISSENT_ISSENT_2 =
		"dgfUsersOtpDetails.isSent = ?";

	private FinderPath _finderPathFetchByotpDetailsByMobileAndOtp;
	private FinderPath _finderPathCountByotpDetailsByMobileAndOtp;

	/**
	 * Returns the dgf users otp details where mobileNo = &#63; and otp = &#63; and isSent = &#63; or throws a <code>NoSuchDgfUsersOtpDetailsException</code> if it could not be found.
	 *
	 * @param mobileNo the mobile no
	 * @param otp the otp
	 * @param isSent the is sent
	 * @return the matching dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a matching dgf users otp details could not be found
	 */
	@Override
	public DgfUsersOtpDetails findByotpDetailsByMobileAndOtp(
			String mobileNo, long otp, boolean isSent)
		throws NoSuchDgfUsersOtpDetailsException {

		DgfUsersOtpDetails dgfUsersOtpDetails = fetchByotpDetailsByMobileAndOtp(
			mobileNo, otp, isSent);

		if (dgfUsersOtpDetails == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("mobileNo=");
			sb.append(mobileNo);

			sb.append(", otp=");
			sb.append(otp);

			sb.append(", isSent=");
			sb.append(isSent);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfUsersOtpDetailsException(sb.toString());
		}

		return dgfUsersOtpDetails;
	}

	/**
	 * Returns the dgf users otp details where mobileNo = &#63; and otp = &#63; and isSent = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param mobileNo the mobile no
	 * @param otp the otp
	 * @param isSent the is sent
	 * @return the matching dgf users otp details, or <code>null</code> if a matching dgf users otp details could not be found
	 */
	@Override
	public DgfUsersOtpDetails fetchByotpDetailsByMobileAndOtp(
		String mobileNo, long otp, boolean isSent) {

		return fetchByotpDetailsByMobileAndOtp(mobileNo, otp, isSent, true);
	}

	/**
	 * Returns the dgf users otp details where mobileNo = &#63; and otp = &#63; and isSent = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param mobileNo the mobile no
	 * @param otp the otp
	 * @param isSent the is sent
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf users otp details, or <code>null</code> if a matching dgf users otp details could not be found
	 */
	@Override
	public DgfUsersOtpDetails fetchByotpDetailsByMobileAndOtp(
		String mobileNo, long otp, boolean isSent, boolean useFinderCache) {

		mobileNo = Objects.toString(mobileNo, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {mobileNo, otp, isSent};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByotpDetailsByMobileAndOtp, finderArgs, this);
		}

		if (result instanceof DgfUsersOtpDetails) {
			DgfUsersOtpDetails dgfUsersOtpDetails = (DgfUsersOtpDetails)result;

			if (!Objects.equals(mobileNo, dgfUsersOtpDetails.getMobileNo()) ||
				(otp != dgfUsersOtpDetails.getOtp()) ||
				(isSent != dgfUsersOtpDetails.isIsSent())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_DGFUSERSOTPDETAILS_WHERE);

			boolean bindMobileNo = false;

			if (mobileNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_OTPDETAILSBYMOBILEANDOTP_MOBILENO_3);
			}
			else {
				bindMobileNo = true;

				sb.append(_FINDER_COLUMN_OTPDETAILSBYMOBILEANDOTP_MOBILENO_2);
			}

			sb.append(_FINDER_COLUMN_OTPDETAILSBYMOBILEANDOTP_OTP_2);

			sb.append(_FINDER_COLUMN_OTPDETAILSBYMOBILEANDOTP_ISSENT_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindMobileNo) {
					queryPos.add(mobileNo);
				}

				queryPos.add(otp);

				queryPos.add(isSent);

				List<DgfUsersOtpDetails> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByotpDetailsByMobileAndOtp,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									mobileNo, otp, isSent
								};
							}

							_log.warn(
								"DgfUsersOtpDetailsPersistenceImpl.fetchByotpDetailsByMobileAndOtp(String, long, boolean, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DgfUsersOtpDetails dgfUsersOtpDetails = list.get(0);

					result = dgfUsersOtpDetails;

					cacheResult(dgfUsersOtpDetails);
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
			return (DgfUsersOtpDetails)result;
		}
	}

	/**
	 * Removes the dgf users otp details where mobileNo = &#63; and otp = &#63; and isSent = &#63; from the database.
	 *
	 * @param mobileNo the mobile no
	 * @param otp the otp
	 * @param isSent the is sent
	 * @return the dgf users otp details that was removed
	 */
	@Override
	public DgfUsersOtpDetails removeByotpDetailsByMobileAndOtp(
			String mobileNo, long otp, boolean isSent)
		throws NoSuchDgfUsersOtpDetailsException {

		DgfUsersOtpDetails dgfUsersOtpDetails = findByotpDetailsByMobileAndOtp(
			mobileNo, otp, isSent);

		return remove(dgfUsersOtpDetails);
	}

	/**
	 * Returns the number of dgf users otp detailses where mobileNo = &#63; and otp = &#63; and isSent = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param otp the otp
	 * @param isSent the is sent
	 * @return the number of matching dgf users otp detailses
	 */
	@Override
	public int countByotpDetailsByMobileAndOtp(
		String mobileNo, long otp, boolean isSent) {

		mobileNo = Objects.toString(mobileNo, "");

		FinderPath finderPath = _finderPathCountByotpDetailsByMobileAndOtp;

		Object[] finderArgs = new Object[] {mobileNo, otp, isSent};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DGFUSERSOTPDETAILS_WHERE);

			boolean bindMobileNo = false;

			if (mobileNo.isEmpty()) {
				sb.append(_FINDER_COLUMN_OTPDETAILSBYMOBILEANDOTP_MOBILENO_3);
			}
			else {
				bindMobileNo = true;

				sb.append(_FINDER_COLUMN_OTPDETAILSBYMOBILEANDOTP_MOBILENO_2);
			}

			sb.append(_FINDER_COLUMN_OTPDETAILSBYMOBILEANDOTP_OTP_2);

			sb.append(_FINDER_COLUMN_OTPDETAILSBYMOBILEANDOTP_ISSENT_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindMobileNo) {
					queryPos.add(mobileNo);
				}

				queryPos.add(otp);

				queryPos.add(isSent);

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
		_FINDER_COLUMN_OTPDETAILSBYMOBILEANDOTP_MOBILENO_2 =
			"dgfUsersOtpDetails.mobileNo = ? AND ";

	private static final String
		_FINDER_COLUMN_OTPDETAILSBYMOBILEANDOTP_MOBILENO_3 =
			"(dgfUsersOtpDetails.mobileNo IS NULL OR dgfUsersOtpDetails.mobileNo = '') AND ";

	private static final String _FINDER_COLUMN_OTPDETAILSBYMOBILEANDOTP_OTP_2 =
		"dgfUsersOtpDetails.otp = ? AND ";

	private static final String
		_FINDER_COLUMN_OTPDETAILSBYMOBILEANDOTP_ISSENT_2 =
			"dgfUsersOtpDetails.isSent = ?";

	public DgfUsersOtpDetailsPersistenceImpl() {
		setModelClass(DgfUsersOtpDetails.class);

		setModelImplClass(DgfUsersOtpDetailsImpl.class);
		setModelPKClass(long.class);

		setTable(DgfUsersOtpDetailsTable.INSTANCE);
	}

	/**
	 * Caches the dgf users otp details in the entity cache if it is enabled.
	 *
	 * @param dgfUsersOtpDetails the dgf users otp details
	 */
	@Override
	public void cacheResult(DgfUsersOtpDetails dgfUsersOtpDetails) {
		entityCache.putResult(
			DgfUsersOtpDetailsImpl.class, dgfUsersOtpDetails.getPrimaryKey(),
			dgfUsersOtpDetails);

		finderCache.putResult(
			_finderPathFetchByotpDetailsByMobileAndOtp,
			new Object[] {
				dgfUsersOtpDetails.getMobileNo(), dgfUsersOtpDetails.getOtp(),
				dgfUsersOtpDetails.isIsSent()
			},
			dgfUsersOtpDetails);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dgf users otp detailses in the entity cache if it is enabled.
	 *
	 * @param dgfUsersOtpDetailses the dgf users otp detailses
	 */
	@Override
	public void cacheResult(List<DgfUsersOtpDetails> dgfUsersOtpDetailses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgfUsersOtpDetailses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DgfUsersOtpDetails dgfUsersOtpDetails : dgfUsersOtpDetailses) {
			if (entityCache.getResult(
					DgfUsersOtpDetailsImpl.class,
					dgfUsersOtpDetails.getPrimaryKey()) == null) {

				cacheResult(dgfUsersOtpDetails);
			}
		}
	}

	/**
	 * Clears the cache for all dgf users otp detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DgfUsersOtpDetailsImpl.class);

		finderCache.clearCache(DgfUsersOtpDetailsImpl.class);
	}

	/**
	 * Clears the cache for the dgf users otp details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DgfUsersOtpDetails dgfUsersOtpDetails) {
		entityCache.removeResult(
			DgfUsersOtpDetailsImpl.class, dgfUsersOtpDetails);
	}

	@Override
	public void clearCache(List<DgfUsersOtpDetails> dgfUsersOtpDetailses) {
		for (DgfUsersOtpDetails dgfUsersOtpDetails : dgfUsersOtpDetailses) {
			entityCache.removeResult(
				DgfUsersOtpDetailsImpl.class, dgfUsersOtpDetails);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DgfUsersOtpDetailsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DgfUsersOtpDetailsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DgfUsersOtpDetailsModelImpl dgfUsersOtpDetailsModelImpl) {

		Object[] args = new Object[] {
			dgfUsersOtpDetailsModelImpl.getMobileNo(),
			dgfUsersOtpDetailsModelImpl.getOtp(),
			dgfUsersOtpDetailsModelImpl.isIsSent()
		};

		finderCache.putResult(
			_finderPathCountByotpDetailsByMobileAndOtp, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByotpDetailsByMobileAndOtp, args,
			dgfUsersOtpDetailsModelImpl);
	}

	/**
	 * Creates a new dgf users otp details with the primary key. Does not add the dgf users otp details to the database.
	 *
	 * @param otpId the primary key for the new dgf users otp details
	 * @return the new dgf users otp details
	 */
	@Override
	public DgfUsersOtpDetails create(long otpId) {
		DgfUsersOtpDetails dgfUsersOtpDetails = new DgfUsersOtpDetailsImpl();

		dgfUsersOtpDetails.setNew(true);
		dgfUsersOtpDetails.setPrimaryKey(otpId);

		return dgfUsersOtpDetails;
	}

	/**
	 * Removes the dgf users otp details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param otpId the primary key of the dgf users otp details
	 * @return the dgf users otp details that was removed
	 * @throws NoSuchDgfUsersOtpDetailsException if a dgf users otp details with the primary key could not be found
	 */
	@Override
	public DgfUsersOtpDetails remove(long otpId)
		throws NoSuchDgfUsersOtpDetailsException {

		return remove((Serializable)otpId);
	}

	/**
	 * Removes the dgf users otp details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dgf users otp details
	 * @return the dgf users otp details that was removed
	 * @throws NoSuchDgfUsersOtpDetailsException if a dgf users otp details with the primary key could not be found
	 */
	@Override
	public DgfUsersOtpDetails remove(Serializable primaryKey)
		throws NoSuchDgfUsersOtpDetailsException {

		Session session = null;

		try {
			session = openSession();

			DgfUsersOtpDetails dgfUsersOtpDetails =
				(DgfUsersOtpDetails)session.get(
					DgfUsersOtpDetailsImpl.class, primaryKey);

			if (dgfUsersOtpDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDgfUsersOtpDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgfUsersOtpDetails);
		}
		catch (NoSuchDgfUsersOtpDetailsException noSuchEntityException) {
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
	protected DgfUsersOtpDetails removeImpl(
		DgfUsersOtpDetails dgfUsersOtpDetails) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgfUsersOtpDetails)) {
				dgfUsersOtpDetails = (DgfUsersOtpDetails)session.get(
					DgfUsersOtpDetailsImpl.class,
					dgfUsersOtpDetails.getPrimaryKeyObj());
			}

			if (dgfUsersOtpDetails != null) {
				session.delete(dgfUsersOtpDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgfUsersOtpDetails != null) {
			clearCache(dgfUsersOtpDetails);
		}

		return dgfUsersOtpDetails;
	}

	@Override
	public DgfUsersOtpDetails updateImpl(
		DgfUsersOtpDetails dgfUsersOtpDetails) {

		boolean isNew = dgfUsersOtpDetails.isNew();

		if (!(dgfUsersOtpDetails instanceof DgfUsersOtpDetailsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dgfUsersOtpDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dgfUsersOtpDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgfUsersOtpDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DgfUsersOtpDetails implementation " +
					dgfUsersOtpDetails.getClass());
		}

		DgfUsersOtpDetailsModelImpl dgfUsersOtpDetailsModelImpl =
			(DgfUsersOtpDetailsModelImpl)dgfUsersOtpDetails;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgfUsersOtpDetails);
			}
			else {
				dgfUsersOtpDetails = (DgfUsersOtpDetails)session.merge(
					dgfUsersOtpDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DgfUsersOtpDetailsImpl.class, dgfUsersOtpDetailsModelImpl, false,
			true);

		cacheUniqueFindersCache(dgfUsersOtpDetailsModelImpl);

		if (isNew) {
			dgfUsersOtpDetails.setNew(false);
		}

		dgfUsersOtpDetails.resetOriginalValues();

		return dgfUsersOtpDetails;
	}

	/**
	 * Returns the dgf users otp details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dgf users otp details
	 * @return the dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a dgf users otp details with the primary key could not be found
	 */
	@Override
	public DgfUsersOtpDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDgfUsersOtpDetailsException {

		DgfUsersOtpDetails dgfUsersOtpDetails = fetchByPrimaryKey(primaryKey);

		if (dgfUsersOtpDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDgfUsersOtpDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgfUsersOtpDetails;
	}

	/**
	 * Returns the dgf users otp details with the primary key or throws a <code>NoSuchDgfUsersOtpDetailsException</code> if it could not be found.
	 *
	 * @param otpId the primary key of the dgf users otp details
	 * @return the dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a dgf users otp details with the primary key could not be found
	 */
	@Override
	public DgfUsersOtpDetails findByPrimaryKey(long otpId)
		throws NoSuchDgfUsersOtpDetailsException {

		return findByPrimaryKey((Serializable)otpId);
	}

	/**
	 * Returns the dgf users otp details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param otpId the primary key of the dgf users otp details
	 * @return the dgf users otp details, or <code>null</code> if a dgf users otp details with the primary key could not be found
	 */
	@Override
	public DgfUsersOtpDetails fetchByPrimaryKey(long otpId) {
		return fetchByPrimaryKey((Serializable)otpId);
	}

	/**
	 * Returns all the dgf users otp detailses.
	 *
	 * @return the dgf users otp detailses
	 */
	@Override
	public List<DgfUsersOtpDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf users otp detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @return the range of dgf users otp detailses
	 */
	@Override
	public List<DgfUsersOtpDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf users otp detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf users otp detailses
	 */
	@Override
	public List<DgfUsersOtpDetails> findAll(
		int start, int end,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf users otp detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf users otp detailses
	 */
	@Override
	public List<DgfUsersOtpDetails> findAll(
		int start, int end,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator,
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

		List<DgfUsersOtpDetails> list = null;

		if (useFinderCache) {
			list = (List<DgfUsersOtpDetails>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFUSERSOTPDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFUSERSOTPDETAILS;

				sql = sql.concat(DgfUsersOtpDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DgfUsersOtpDetails>)QueryUtil.list(
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
	 * Removes all the dgf users otp detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DgfUsersOtpDetails dgfUsersOtpDetails : findAll()) {
			remove(dgfUsersOtpDetails);
		}
	}

	/**
	 * Returns the number of dgf users otp detailses.
	 *
	 * @return the number of dgf users otp detailses
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
					_SQL_COUNT_DGFUSERSOTPDETAILS);

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
		return "otpId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DGFUSERSOTPDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DgfUsersOtpDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dgf users otp details persistence.
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

		_finderPathWithPaginationFindBymobileNumberFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBymobileNumberFinder",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"mobileNo"}, true);

		_finderPathWithoutPaginationFindBymobileNumberFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBymobileNumberFinder", new String[] {String.class.getName()},
			new String[] {"mobileNo"}, true);

		_finderPathCountBymobileNumberFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBymobileNumberFinder", new String[] {String.class.getName()},
			new String[] {"mobileNo"}, false);

		_finderPathWithPaginationFindBynationalIdfinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBynationalIdfinder",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"nationalId"}, true);

		_finderPathWithoutPaginationFindBynationalIdfinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBynationalIdfinder",
			new String[] {String.class.getName()}, new String[] {"nationalId"},
			true);

		_finderPathCountBynationalIdfinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBynationalIdfinder", new String[] {String.class.getName()},
			new String[] {"nationalId"}, false);

		_finderPathWithPaginationFindByuserIdFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserIdFinder",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userId"}, true);

		_finderPathWithoutPaginationFindByuserIdFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserIdFinder",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByuserIdFinder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserIdFinder",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		_finderPathWithPaginationFindByisSent = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByisSent",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"isSent"}, true);

		_finderPathWithoutPaginationFindByisSent = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByisSent",
			new String[] {Boolean.class.getName()}, new String[] {"isSent"},
			true);

		_finderPathCountByisSent = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByisSent",
			new String[] {Boolean.class.getName()}, new String[] {"isSent"},
			false);

		_finderPathFetchByotpDetailsByMobileAndOtp = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByotpDetailsByMobileAndOtp",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			new String[] {"mobileNo", "otp", "isSent"}, true);

		_finderPathCountByotpDetailsByMobileAndOtp = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByotpDetailsByMobileAndOtp",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			new String[] {"mobileNo", "otp", "isSent"}, false);

		_setDgfUsersOtpDetailsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDgfUsersOtpDetailsUtilPersistence(null);

		entityCache.removeCache(DgfUsersOtpDetailsImpl.class.getName());
	}

	private void _setDgfUsersOtpDetailsUtilPersistence(
		DgfUsersOtpDetailsPersistence dgfUsersOtpDetailsPersistence) {

		try {
			Field field = DgfUsersOtpDetailsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dgfUsersOtpDetailsPersistence);
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

	private static final String _SQL_SELECT_DGFUSERSOTPDETAILS =
		"SELECT dgfUsersOtpDetails FROM DgfUsersOtpDetails dgfUsersOtpDetails";

	private static final String _SQL_SELECT_DGFUSERSOTPDETAILS_WHERE =
		"SELECT dgfUsersOtpDetails FROM DgfUsersOtpDetails dgfUsersOtpDetails WHERE ";

	private static final String _SQL_COUNT_DGFUSERSOTPDETAILS =
		"SELECT COUNT(dgfUsersOtpDetails) FROM DgfUsersOtpDetails dgfUsersOtpDetails";

	private static final String _SQL_COUNT_DGFUSERSOTPDETAILS_WHERE =
		"SELECT COUNT(dgfUsersOtpDetails) FROM DgfUsersOtpDetails dgfUsersOtpDetails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dgfUsersOtpDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DgfUsersOtpDetails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DgfUsersOtpDetails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DgfUsersOtpDetailsPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}