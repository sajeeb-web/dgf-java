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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfUsersFortnightReportCFormException;
import bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportCForm;
import bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportCFormTable;
import bd.gov.dgfood.food.grain.license.model.impl.DgfUsersFortnightReportCFormImpl;
import bd.gov.dgfood.food.grain.license.model.impl.DgfUsersFortnightReportCFormModelImpl;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfUsersFortnightReportCFormPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfUsersFortnightReportCFormUtil;
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
 * The persistence implementation for the dgf users fortnight report c form service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DgfUsersFortnightReportCFormPersistence.class)
public class DgfUsersFortnightReportCFormPersistenceImpl
	extends BasePersistenceImpl<DgfUsersFortnightReportCForm>
	implements DgfUsersFortnightReportCFormPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DgfUsersFortnightReportCFormUtil</code> to access the dgf users fortnight report c form persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DgfUsersFortnightReportCFormImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath
		_finderPathWithPaginationFindByFortnightReportCFormByUsernationalId;
	private FinderPath
		_finderPathWithoutPaginationFindByFortnightReportCFormByUsernationalId;
	private FinderPath _finderPathCountByFortnightReportCFormByUsernationalId;

	/**
	 * Returns all the dgf users fortnight report c forms where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @return the matching dgf users fortnight report c forms
	 */
	@Override
	public List<DgfUsersFortnightReportCForm>
		findByFortnightReportCFormByUsernationalId(String usernationalId) {

		return findByFortnightReportCFormByUsernationalId(
			usernationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf users fortnight report c forms where usernationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportCFormModelImpl</code>.
	 * </p>
	 *
	 * @param usernationalId the usernational ID
	 * @param start the lower bound of the range of dgf users fortnight report c forms
	 * @param end the upper bound of the range of dgf users fortnight report c forms (not inclusive)
	 * @return the range of matching dgf users fortnight report c forms
	 */
	@Override
	public List<DgfUsersFortnightReportCForm>
		findByFortnightReportCFormByUsernationalId(
			String usernationalId, int start, int end) {

		return findByFortnightReportCFormByUsernationalId(
			usernationalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf users fortnight report c forms where usernationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportCFormModelImpl</code>.
	 * </p>
	 *
	 * @param usernationalId the usernational ID
	 * @param start the lower bound of the range of dgf users fortnight report c forms
	 * @param end the upper bound of the range of dgf users fortnight report c forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users fortnight report c forms
	 */
	@Override
	public List<DgfUsersFortnightReportCForm>
		findByFortnightReportCFormByUsernationalId(
			String usernationalId, int start, int end,
			OrderByComparator<DgfUsersFortnightReportCForm> orderByComparator) {

		return findByFortnightReportCFormByUsernationalId(
			usernationalId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf users fortnight report c forms where usernationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportCFormModelImpl</code>.
	 * </p>
	 *
	 * @param usernationalId the usernational ID
	 * @param start the lower bound of the range of dgf users fortnight report c forms
	 * @param end the upper bound of the range of dgf users fortnight report c forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users fortnight report c forms
	 */
	@Override
	public List<DgfUsersFortnightReportCForm>
		findByFortnightReportCFormByUsernationalId(
			String usernationalId, int start, int end,
			OrderByComparator<DgfUsersFortnightReportCForm> orderByComparator,
			boolean useFinderCache) {

		usernationalId = Objects.toString(usernationalId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByFortnightReportCFormByUsernationalId;
				finderArgs = new Object[] {usernationalId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByFortnightReportCFormByUsernationalId;
			finderArgs = new Object[] {
				usernationalId, start, end, orderByComparator
			};
		}

		List<DgfUsersFortnightReportCForm> list = null;

		if (useFinderCache) {
			list = (List<DgfUsersFortnightReportCForm>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm :
						list) {

					if (!usernationalId.equals(
							dgfUsersFortnightReportCForm.getUsernationalId())) {

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

			sb.append(_SQL_SELECT_DGFUSERSFORTNIGHTREPORTCFORM_WHERE);

			boolean bindUsernationalId = false;

			if (usernationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_FORTNIGHTREPORTCFORMBYUSERNATIONALID_USERNATIONALID_3);
			}
			else {
				bindUsernationalId = true;

				sb.append(
					_FINDER_COLUMN_FORTNIGHTREPORTCFORMBYUSERNATIONALID_USERNATIONALID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfUsersFortnightReportCFormModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUsernationalId) {
					queryPos.add(usernationalId);
				}

				list = (List<DgfUsersFortnightReportCForm>)QueryUtil.list(
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
	 * Returns the first dgf users fortnight report c form in the ordered set where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users fortnight report c form
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a matching dgf users fortnight report c form could not be found
	 */
	@Override
	public DgfUsersFortnightReportCForm
			findByFortnightReportCFormByUsernationalId_First(
				String usernationalId,
				OrderByComparator<DgfUsersFortnightReportCForm>
					orderByComparator)
		throws NoSuchDgfUsersFortnightReportCFormException {

		DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm =
			fetchByFortnightReportCFormByUsernationalId_First(
				usernationalId, orderByComparator);

		if (dgfUsersFortnightReportCForm != null) {
			return dgfUsersFortnightReportCForm;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("usernationalId=");
		sb.append(usernationalId);

		sb.append("}");

		throw new NoSuchDgfUsersFortnightReportCFormException(sb.toString());
	}

	/**
	 * Returns the first dgf users fortnight report c form in the ordered set where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users fortnight report c form, or <code>null</code> if a matching dgf users fortnight report c form could not be found
	 */
	@Override
	public DgfUsersFortnightReportCForm
		fetchByFortnightReportCFormByUsernationalId_First(
			String usernationalId,
			OrderByComparator<DgfUsersFortnightReportCForm> orderByComparator) {

		List<DgfUsersFortnightReportCForm> list =
			findByFortnightReportCFormByUsernationalId(
				usernationalId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf users fortnight report c form in the ordered set where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users fortnight report c form
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a matching dgf users fortnight report c form could not be found
	 */
	@Override
	public DgfUsersFortnightReportCForm
			findByFortnightReportCFormByUsernationalId_Last(
				String usernationalId,
				OrderByComparator<DgfUsersFortnightReportCForm>
					orderByComparator)
		throws NoSuchDgfUsersFortnightReportCFormException {

		DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm =
			fetchByFortnightReportCFormByUsernationalId_Last(
				usernationalId, orderByComparator);

		if (dgfUsersFortnightReportCForm != null) {
			return dgfUsersFortnightReportCForm;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("usernationalId=");
		sb.append(usernationalId);

		sb.append("}");

		throw new NoSuchDgfUsersFortnightReportCFormException(sb.toString());
	}

	/**
	 * Returns the last dgf users fortnight report c form in the ordered set where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users fortnight report c form, or <code>null</code> if a matching dgf users fortnight report c form could not be found
	 */
	@Override
	public DgfUsersFortnightReportCForm
		fetchByFortnightReportCFormByUsernationalId_Last(
			String usernationalId,
			OrderByComparator<DgfUsersFortnightReportCForm> orderByComparator) {

		int count = countByFortnightReportCFormByUsernationalId(usernationalId);

		if (count == 0) {
			return null;
		}

		List<DgfUsersFortnightReportCForm> list =
			findByFortnightReportCFormByUsernationalId(
				usernationalId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf users fortnight report c forms before and after the current dgf users fortnight report c form in the ordered set where usernationalId = &#63;.
	 *
	 * @param reportId the primary key of the current dgf users fortnight report c form
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users fortnight report c form
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a dgf users fortnight report c form with the primary key could not be found
	 */
	@Override
	public DgfUsersFortnightReportCForm[]
			findByFortnightReportCFormByUsernationalId_PrevAndNext(
				long reportId, String usernationalId,
				OrderByComparator<DgfUsersFortnightReportCForm>
					orderByComparator)
		throws NoSuchDgfUsersFortnightReportCFormException {

		usernationalId = Objects.toString(usernationalId, "");

		DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm =
			findByPrimaryKey(reportId);

		Session session = null;

		try {
			session = openSession();

			DgfUsersFortnightReportCForm[] array =
				new DgfUsersFortnightReportCFormImpl[3];

			array[0] = getByFortnightReportCFormByUsernationalId_PrevAndNext(
				session, dgfUsersFortnightReportCForm, usernationalId,
				orderByComparator, true);

			array[1] = dgfUsersFortnightReportCForm;

			array[2] = getByFortnightReportCFormByUsernationalId_PrevAndNext(
				session, dgfUsersFortnightReportCForm, usernationalId,
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

	protected DgfUsersFortnightReportCForm
		getByFortnightReportCFormByUsernationalId_PrevAndNext(
			Session session,
			DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm,
			String usernationalId,
			OrderByComparator<DgfUsersFortnightReportCForm> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFUSERSFORTNIGHTREPORTCFORM_WHERE);

		boolean bindUsernationalId = false;

		if (usernationalId.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_FORTNIGHTREPORTCFORMBYUSERNATIONALID_USERNATIONALID_3);
		}
		else {
			bindUsernationalId = true;

			sb.append(
				_FINDER_COLUMN_FORTNIGHTREPORTCFORMBYUSERNATIONALID_USERNATIONALID_2);
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
			sb.append(DgfUsersFortnightReportCFormModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUsernationalId) {
			queryPos.add(usernationalId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfUsersFortnightReportCForm)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfUsersFortnightReportCForm> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the dgf users fortnight report c forms that the user has permission to view where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @return the matching dgf users fortnight report c forms that the user has permission to view
	 */
	@Override
	public List<DgfUsersFortnightReportCForm>
		filterFindByFortnightReportCFormByUsernationalId(
			String usernationalId) {

		return filterFindByFortnightReportCFormByUsernationalId(
			usernationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf users fortnight report c forms that the user has permission to view where usernationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportCFormModelImpl</code>.
	 * </p>
	 *
	 * @param usernationalId the usernational ID
	 * @param start the lower bound of the range of dgf users fortnight report c forms
	 * @param end the upper bound of the range of dgf users fortnight report c forms (not inclusive)
	 * @return the range of matching dgf users fortnight report c forms that the user has permission to view
	 */
	@Override
	public List<DgfUsersFortnightReportCForm>
		filterFindByFortnightReportCFormByUsernationalId(
			String usernationalId, int start, int end) {

		return filterFindByFortnightReportCFormByUsernationalId(
			usernationalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf users fortnight report c forms that the user has permissions to view where usernationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportCFormModelImpl</code>.
	 * </p>
	 *
	 * @param usernationalId the usernational ID
	 * @param start the lower bound of the range of dgf users fortnight report c forms
	 * @param end the upper bound of the range of dgf users fortnight report c forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users fortnight report c forms that the user has permission to view
	 */
	@Override
	public List<DgfUsersFortnightReportCForm>
		filterFindByFortnightReportCFormByUsernationalId(
			String usernationalId, int start, int end,
			OrderByComparator<DgfUsersFortnightReportCForm> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByFortnightReportCFormByUsernationalId(
				usernationalId, start, end, orderByComparator);
		}

		usernationalId = Objects.toString(usernationalId, "");

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				3 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DGFUSERSFORTNIGHTREPORTCFORM_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_DGFUSERSFORTNIGHTREPORTCFORM_NO_INLINE_DISTINCT_WHERE_1);
		}

		boolean bindUsernationalId = false;

		if (usernationalId.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_FORTNIGHTREPORTCFORMBYUSERNATIONALID_USERNATIONALID_3);
		}
		else {
			bindUsernationalId = true;

			sb.append(
				_FINDER_COLUMN_FORTNIGHTREPORTCFORMBYUSERNATIONALID_USERNATIONALID_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_DGFUSERSFORTNIGHTREPORTCFORM_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(DgfUsersFortnightReportCFormModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DgfUsersFortnightReportCFormModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DgfUsersFortnightReportCForm.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(
					_FILTER_ENTITY_ALIAS,
					DgfUsersFortnightReportCFormImpl.class);
			}
			else {
				sqlQuery.addEntity(
					_FILTER_ENTITY_TABLE,
					DgfUsersFortnightReportCFormImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			if (bindUsernationalId) {
				queryPos.add(usernationalId);
			}

			return (List<DgfUsersFortnightReportCForm>)QueryUtil.list(
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
	 * Returns the dgf users fortnight report c forms before and after the current dgf users fortnight report c form in the ordered set of dgf users fortnight report c forms that the user has permission to view where usernationalId = &#63;.
	 *
	 * @param reportId the primary key of the current dgf users fortnight report c form
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users fortnight report c form
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a dgf users fortnight report c form with the primary key could not be found
	 */
	@Override
	public DgfUsersFortnightReportCForm[]
			filterFindByFortnightReportCFormByUsernationalId_PrevAndNext(
				long reportId, String usernationalId,
				OrderByComparator<DgfUsersFortnightReportCForm>
					orderByComparator)
		throws NoSuchDgfUsersFortnightReportCFormException {

		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByFortnightReportCFormByUsernationalId_PrevAndNext(
				reportId, usernationalId, orderByComparator);
		}

		usernationalId = Objects.toString(usernationalId, "");

		DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm =
			findByPrimaryKey(reportId);

		Session session = null;

		try {
			session = openSession();

			DgfUsersFortnightReportCForm[] array =
				new DgfUsersFortnightReportCFormImpl[3];

			array[0] =
				filterGetByFortnightReportCFormByUsernationalId_PrevAndNext(
					session, dgfUsersFortnightReportCForm, usernationalId,
					orderByComparator, true);

			array[1] = dgfUsersFortnightReportCForm;

			array[2] =
				filterGetByFortnightReportCFormByUsernationalId_PrevAndNext(
					session, dgfUsersFortnightReportCForm, usernationalId,
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

	protected DgfUsersFortnightReportCForm
		filterGetByFortnightReportCFormByUsernationalId_PrevAndNext(
			Session session,
			DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm,
			String usernationalId,
			OrderByComparator<DgfUsersFortnightReportCForm> orderByComparator,
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
			sb.append(_FILTER_SQL_SELECT_DGFUSERSFORTNIGHTREPORTCFORM_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_DGFUSERSFORTNIGHTREPORTCFORM_NO_INLINE_DISTINCT_WHERE_1);
		}

		boolean bindUsernationalId = false;

		if (usernationalId.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_FORTNIGHTREPORTCFORMBYUSERNATIONALID_USERNATIONALID_3);
		}
		else {
			bindUsernationalId = true;

			sb.append(
				_FINDER_COLUMN_FORTNIGHTREPORTCFORMBYUSERNATIONALID_USERNATIONALID_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_DGFUSERSFORTNIGHTREPORTCFORM_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(DgfUsersFortnightReportCFormModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DgfUsersFortnightReportCFormModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DgfUsersFortnightReportCForm.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(
				_FILTER_ENTITY_ALIAS, DgfUsersFortnightReportCFormImpl.class);
		}
		else {
			sqlQuery.addEntity(
				_FILTER_ENTITY_TABLE, DgfUsersFortnightReportCFormImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		if (bindUsernationalId) {
			queryPos.add(usernationalId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfUsersFortnightReportCForm)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfUsersFortnightReportCForm> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf users fortnight report c forms where usernationalId = &#63; from the database.
	 *
	 * @param usernationalId the usernational ID
	 */
	@Override
	public void removeByFortnightReportCFormByUsernationalId(
		String usernationalId) {

		for (DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm :
				findByFortnightReportCFormByUsernationalId(
					usernationalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dgfUsersFortnightReportCForm);
		}
	}

	/**
	 * Returns the number of dgf users fortnight report c forms where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @return the number of matching dgf users fortnight report c forms
	 */
	@Override
	public int countByFortnightReportCFormByUsernationalId(
		String usernationalId) {

		usernationalId = Objects.toString(usernationalId, "");

		FinderPath finderPath =
			_finderPathCountByFortnightReportCFormByUsernationalId;

		Object[] finderArgs = new Object[] {usernationalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFUSERSFORTNIGHTREPORTCFORM_WHERE);

			boolean bindUsernationalId = false;

			if (usernationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_FORTNIGHTREPORTCFORMBYUSERNATIONALID_USERNATIONALID_3);
			}
			else {
				bindUsernationalId = true;

				sb.append(
					_FINDER_COLUMN_FORTNIGHTREPORTCFORMBYUSERNATIONALID_USERNATIONALID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUsernationalId) {
					queryPos.add(usernationalId);
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
	 * Returns the number of dgf users fortnight report c forms that the user has permission to view where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @return the number of matching dgf users fortnight report c forms that the user has permission to view
	 */
	@Override
	public int filterCountByFortnightReportCFormByUsernationalId(
		String usernationalId) {

		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByFortnightReportCFormByUsernationalId(usernationalId);
		}

		usernationalId = Objects.toString(usernationalId, "");

		StringBundler sb = new StringBundler(2);

		sb.append(_FILTER_SQL_COUNT_DGFUSERSFORTNIGHTREPORTCFORM_WHERE);

		boolean bindUsernationalId = false;

		if (usernationalId.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_FORTNIGHTREPORTCFORMBYUSERNATIONALID_USERNATIONALID_3);
		}
		else {
			bindUsernationalId = true;

			sb.append(
				_FINDER_COLUMN_FORTNIGHTREPORTCFORMBYUSERNATIONALID_USERNATIONALID_2);
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DgfUsersFortnightReportCForm.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			if (bindUsernationalId) {
				queryPos.add(usernationalId);
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
		_FINDER_COLUMN_FORTNIGHTREPORTCFORMBYUSERNATIONALID_USERNATIONALID_2 =
			"dgfUsersFortnightReportCForm.usernationalId = ?";

	private static final String
		_FINDER_COLUMN_FORTNIGHTREPORTCFORMBYUSERNATIONALID_USERNATIONALID_3 =
			"(dgfUsersFortnightReportCForm.usernationalId IS NULL OR dgfUsersFortnightReportCForm.usernationalId = '')";

	private FinderPath
		_finderPathWithPaginationFindByForthnightReportCFormByScreenName;
	private FinderPath
		_finderPathWithoutPaginationFindByForthnightReportCFormByScreenName;
	private FinderPath _finderPathCountByForthnightReportCFormByScreenName;

	/**
	 * Returns all the dgf users fortnight report c forms where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the matching dgf users fortnight report c forms
	 */
	@Override
	public List<DgfUsersFortnightReportCForm>
		findByForthnightReportCFormByScreenName(String screenName) {

		return findByForthnightReportCFormByScreenName(
			screenName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf users fortnight report c forms where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportCFormModelImpl</code>.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of dgf users fortnight report c forms
	 * @param end the upper bound of the range of dgf users fortnight report c forms (not inclusive)
	 * @return the range of matching dgf users fortnight report c forms
	 */
	@Override
	public List<DgfUsersFortnightReportCForm>
		findByForthnightReportCFormByScreenName(
			String screenName, int start, int end) {

		return findByForthnightReportCFormByScreenName(
			screenName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf users fortnight report c forms where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportCFormModelImpl</code>.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of dgf users fortnight report c forms
	 * @param end the upper bound of the range of dgf users fortnight report c forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users fortnight report c forms
	 */
	@Override
	public List<DgfUsersFortnightReportCForm>
		findByForthnightReportCFormByScreenName(
			String screenName, int start, int end,
			OrderByComparator<DgfUsersFortnightReportCForm> orderByComparator) {

		return findByForthnightReportCFormByScreenName(
			screenName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf users fortnight report c forms where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportCFormModelImpl</code>.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of dgf users fortnight report c forms
	 * @param end the upper bound of the range of dgf users fortnight report c forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users fortnight report c forms
	 */
	@Override
	public List<DgfUsersFortnightReportCForm>
		findByForthnightReportCFormByScreenName(
			String screenName, int start, int end,
			OrderByComparator<DgfUsersFortnightReportCForm> orderByComparator,
			boolean useFinderCache) {

		screenName = Objects.toString(screenName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByForthnightReportCFormByScreenName;
				finderArgs = new Object[] {screenName};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByForthnightReportCFormByScreenName;
			finderArgs = new Object[] {
				screenName, start, end, orderByComparator
			};
		}

		List<DgfUsersFortnightReportCForm> list = null;

		if (useFinderCache) {
			list = (List<DgfUsersFortnightReportCForm>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm :
						list) {

					if (!screenName.equals(
							dgfUsersFortnightReportCForm.getScreenName())) {

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

			sb.append(_SQL_SELECT_DGFUSERSFORTNIGHTREPORTCFORM_WHERE);

			boolean bindScreenName = false;

			if (screenName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_FORTHNIGHTREPORTCFORMBYSCREENNAME_SCREENNAME_3);
			}
			else {
				bindScreenName = true;

				sb.append(
					_FINDER_COLUMN_FORTHNIGHTREPORTCFORMBYSCREENNAME_SCREENNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DgfUsersFortnightReportCFormModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindScreenName) {
					queryPos.add(screenName);
				}

				list = (List<DgfUsersFortnightReportCForm>)QueryUtil.list(
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
	 * Returns the first dgf users fortnight report c form in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users fortnight report c form
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a matching dgf users fortnight report c form could not be found
	 */
	@Override
	public DgfUsersFortnightReportCForm
			findByForthnightReportCFormByScreenName_First(
				String screenName,
				OrderByComparator<DgfUsersFortnightReportCForm>
					orderByComparator)
		throws NoSuchDgfUsersFortnightReportCFormException {

		DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm =
			fetchByForthnightReportCFormByScreenName_First(
				screenName, orderByComparator);

		if (dgfUsersFortnightReportCForm != null) {
			return dgfUsersFortnightReportCForm;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("screenName=");
		sb.append(screenName);

		sb.append("}");

		throw new NoSuchDgfUsersFortnightReportCFormException(sb.toString());
	}

	/**
	 * Returns the first dgf users fortnight report c form in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users fortnight report c form, or <code>null</code> if a matching dgf users fortnight report c form could not be found
	 */
	@Override
	public DgfUsersFortnightReportCForm
		fetchByForthnightReportCFormByScreenName_First(
			String screenName,
			OrderByComparator<DgfUsersFortnightReportCForm> orderByComparator) {

		List<DgfUsersFortnightReportCForm> list =
			findByForthnightReportCFormByScreenName(
				screenName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dgf users fortnight report c form in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users fortnight report c form
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a matching dgf users fortnight report c form could not be found
	 */
	@Override
	public DgfUsersFortnightReportCForm
			findByForthnightReportCFormByScreenName_Last(
				String screenName,
				OrderByComparator<DgfUsersFortnightReportCForm>
					orderByComparator)
		throws NoSuchDgfUsersFortnightReportCFormException {

		DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm =
			fetchByForthnightReportCFormByScreenName_Last(
				screenName, orderByComparator);

		if (dgfUsersFortnightReportCForm != null) {
			return dgfUsersFortnightReportCForm;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("screenName=");
		sb.append(screenName);

		sb.append("}");

		throw new NoSuchDgfUsersFortnightReportCFormException(sb.toString());
	}

	/**
	 * Returns the last dgf users fortnight report c form in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users fortnight report c form, or <code>null</code> if a matching dgf users fortnight report c form could not be found
	 */
	@Override
	public DgfUsersFortnightReportCForm
		fetchByForthnightReportCFormByScreenName_Last(
			String screenName,
			OrderByComparator<DgfUsersFortnightReportCForm> orderByComparator) {

		int count = countByForthnightReportCFormByScreenName(screenName);

		if (count == 0) {
			return null;
		}

		List<DgfUsersFortnightReportCForm> list =
			findByForthnightReportCFormByScreenName(
				screenName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dgf users fortnight report c forms before and after the current dgf users fortnight report c form in the ordered set where screenName = &#63;.
	 *
	 * @param reportId the primary key of the current dgf users fortnight report c form
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users fortnight report c form
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a dgf users fortnight report c form with the primary key could not be found
	 */
	@Override
	public DgfUsersFortnightReportCForm[]
			findByForthnightReportCFormByScreenName_PrevAndNext(
				long reportId, String screenName,
				OrderByComparator<DgfUsersFortnightReportCForm>
					orderByComparator)
		throws NoSuchDgfUsersFortnightReportCFormException {

		screenName = Objects.toString(screenName, "");

		DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm =
			findByPrimaryKey(reportId);

		Session session = null;

		try {
			session = openSession();

			DgfUsersFortnightReportCForm[] array =
				new DgfUsersFortnightReportCFormImpl[3];

			array[0] = getByForthnightReportCFormByScreenName_PrevAndNext(
				session, dgfUsersFortnightReportCForm, screenName,
				orderByComparator, true);

			array[1] = dgfUsersFortnightReportCForm;

			array[2] = getByForthnightReportCFormByScreenName_PrevAndNext(
				session, dgfUsersFortnightReportCForm, screenName,
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

	protected DgfUsersFortnightReportCForm
		getByForthnightReportCFormByScreenName_PrevAndNext(
			Session session,
			DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm,
			String screenName,
			OrderByComparator<DgfUsersFortnightReportCForm> orderByComparator,
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

		sb.append(_SQL_SELECT_DGFUSERSFORTNIGHTREPORTCFORM_WHERE);

		boolean bindScreenName = false;

		if (screenName.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_FORTHNIGHTREPORTCFORMBYSCREENNAME_SCREENNAME_3);
		}
		else {
			bindScreenName = true;

			sb.append(
				_FINDER_COLUMN_FORTHNIGHTREPORTCFORMBYSCREENNAME_SCREENNAME_2);
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
			sb.append(DgfUsersFortnightReportCFormModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindScreenName) {
			queryPos.add(screenName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfUsersFortnightReportCForm)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfUsersFortnightReportCForm> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the dgf users fortnight report c forms that the user has permission to view where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the matching dgf users fortnight report c forms that the user has permission to view
	 */
	@Override
	public List<DgfUsersFortnightReportCForm>
		filterFindByForthnightReportCFormByScreenName(String screenName) {

		return filterFindByForthnightReportCFormByScreenName(
			screenName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf users fortnight report c forms that the user has permission to view where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportCFormModelImpl</code>.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of dgf users fortnight report c forms
	 * @param end the upper bound of the range of dgf users fortnight report c forms (not inclusive)
	 * @return the range of matching dgf users fortnight report c forms that the user has permission to view
	 */
	@Override
	public List<DgfUsersFortnightReportCForm>
		filterFindByForthnightReportCFormByScreenName(
			String screenName, int start, int end) {

		return filterFindByForthnightReportCFormByScreenName(
			screenName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf users fortnight report c forms that the user has permissions to view where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportCFormModelImpl</code>.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of dgf users fortnight report c forms
	 * @param end the upper bound of the range of dgf users fortnight report c forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users fortnight report c forms that the user has permission to view
	 */
	@Override
	public List<DgfUsersFortnightReportCForm>
		filterFindByForthnightReportCFormByScreenName(
			String screenName, int start, int end,
			OrderByComparator<DgfUsersFortnightReportCForm> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByForthnightReportCFormByScreenName(
				screenName, start, end, orderByComparator);
		}

		screenName = Objects.toString(screenName, "");

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				3 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DGFUSERSFORTNIGHTREPORTCFORM_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_DGFUSERSFORTNIGHTREPORTCFORM_NO_INLINE_DISTINCT_WHERE_1);
		}

		boolean bindScreenName = false;

		if (screenName.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_FORTHNIGHTREPORTCFORMBYSCREENNAME_SCREENNAME_3);
		}
		else {
			bindScreenName = true;

			sb.append(
				_FINDER_COLUMN_FORTHNIGHTREPORTCFORMBYSCREENNAME_SCREENNAME_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_DGFUSERSFORTNIGHTREPORTCFORM_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(DgfUsersFortnightReportCFormModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DgfUsersFortnightReportCFormModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DgfUsersFortnightReportCForm.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(
					_FILTER_ENTITY_ALIAS,
					DgfUsersFortnightReportCFormImpl.class);
			}
			else {
				sqlQuery.addEntity(
					_FILTER_ENTITY_TABLE,
					DgfUsersFortnightReportCFormImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			if (bindScreenName) {
				queryPos.add(screenName);
			}

			return (List<DgfUsersFortnightReportCForm>)QueryUtil.list(
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
	 * Returns the dgf users fortnight report c forms before and after the current dgf users fortnight report c form in the ordered set of dgf users fortnight report c forms that the user has permission to view where screenName = &#63;.
	 *
	 * @param reportId the primary key of the current dgf users fortnight report c form
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users fortnight report c form
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a dgf users fortnight report c form with the primary key could not be found
	 */
	@Override
	public DgfUsersFortnightReportCForm[]
			filterFindByForthnightReportCFormByScreenName_PrevAndNext(
				long reportId, String screenName,
				OrderByComparator<DgfUsersFortnightReportCForm>
					orderByComparator)
		throws NoSuchDgfUsersFortnightReportCFormException {

		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByForthnightReportCFormByScreenName_PrevAndNext(
				reportId, screenName, orderByComparator);
		}

		screenName = Objects.toString(screenName, "");

		DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm =
			findByPrimaryKey(reportId);

		Session session = null;

		try {
			session = openSession();

			DgfUsersFortnightReportCForm[] array =
				new DgfUsersFortnightReportCFormImpl[3];

			array[0] = filterGetByForthnightReportCFormByScreenName_PrevAndNext(
				session, dgfUsersFortnightReportCForm, screenName,
				orderByComparator, true);

			array[1] = dgfUsersFortnightReportCForm;

			array[2] = filterGetByForthnightReportCFormByScreenName_PrevAndNext(
				session, dgfUsersFortnightReportCForm, screenName,
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

	protected DgfUsersFortnightReportCForm
		filterGetByForthnightReportCFormByScreenName_PrevAndNext(
			Session session,
			DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm,
			String screenName,
			OrderByComparator<DgfUsersFortnightReportCForm> orderByComparator,
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
			sb.append(_FILTER_SQL_SELECT_DGFUSERSFORTNIGHTREPORTCFORM_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_DGFUSERSFORTNIGHTREPORTCFORM_NO_INLINE_DISTINCT_WHERE_1);
		}

		boolean bindScreenName = false;

		if (screenName.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_FORTHNIGHTREPORTCFORMBYSCREENNAME_SCREENNAME_3);
		}
		else {
			bindScreenName = true;

			sb.append(
				_FINDER_COLUMN_FORTHNIGHTREPORTCFORMBYSCREENNAME_SCREENNAME_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_DGFUSERSFORTNIGHTREPORTCFORM_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(DgfUsersFortnightReportCFormModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DgfUsersFortnightReportCFormModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DgfUsersFortnightReportCForm.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(
				_FILTER_ENTITY_ALIAS, DgfUsersFortnightReportCFormImpl.class);
		}
		else {
			sqlQuery.addEntity(
				_FILTER_ENTITY_TABLE, DgfUsersFortnightReportCFormImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		if (bindScreenName) {
			queryPos.add(screenName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dgfUsersFortnightReportCForm)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DgfUsersFortnightReportCForm> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dgf users fortnight report c forms where screenName = &#63; from the database.
	 *
	 * @param screenName the screen name
	 */
	@Override
	public void removeByForthnightReportCFormByScreenName(String screenName) {
		for (DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm :
				findByForthnightReportCFormByScreenName(
					screenName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dgfUsersFortnightReportCForm);
		}
	}

	/**
	 * Returns the number of dgf users fortnight report c forms where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the number of matching dgf users fortnight report c forms
	 */
	@Override
	public int countByForthnightReportCFormByScreenName(String screenName) {
		screenName = Objects.toString(screenName, "");

		FinderPath finderPath =
			_finderPathCountByForthnightReportCFormByScreenName;

		Object[] finderArgs = new Object[] {screenName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DGFUSERSFORTNIGHTREPORTCFORM_WHERE);

			boolean bindScreenName = false;

			if (screenName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_FORTHNIGHTREPORTCFORMBYSCREENNAME_SCREENNAME_3);
			}
			else {
				bindScreenName = true;

				sb.append(
					_FINDER_COLUMN_FORTHNIGHTREPORTCFORMBYSCREENNAME_SCREENNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindScreenName) {
					queryPos.add(screenName);
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
	 * Returns the number of dgf users fortnight report c forms that the user has permission to view where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the number of matching dgf users fortnight report c forms that the user has permission to view
	 */
	@Override
	public int filterCountByForthnightReportCFormByScreenName(
		String screenName) {

		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByForthnightReportCFormByScreenName(screenName);
		}

		screenName = Objects.toString(screenName, "");

		StringBundler sb = new StringBundler(2);

		sb.append(_FILTER_SQL_COUNT_DGFUSERSFORTNIGHTREPORTCFORM_WHERE);

		boolean bindScreenName = false;

		if (screenName.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_FORTHNIGHTREPORTCFORMBYSCREENNAME_SCREENNAME_3);
		}
		else {
			bindScreenName = true;

			sb.append(
				_FINDER_COLUMN_FORTHNIGHTREPORTCFORMBYSCREENNAME_SCREENNAME_2);
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DgfUsersFortnightReportCForm.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			if (bindScreenName) {
				queryPos.add(screenName);
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
		_FINDER_COLUMN_FORTHNIGHTREPORTCFORMBYSCREENNAME_SCREENNAME_2 =
			"dgfUsersFortnightReportCForm.screenName = ?";

	private static final String
		_FINDER_COLUMN_FORTHNIGHTREPORTCFORMBYSCREENNAME_SCREENNAME_3 =
			"(dgfUsersFortnightReportCForm.screenName IS NULL OR dgfUsersFortnightReportCForm.screenName = '')";

	private FinderPath _finderPathFetchByFortnightReportCFormByNIDandLicenseNo;
	private FinderPath _finderPathCountByFortnightReportCFormByNIDandLicenseNo;

	/**
	 * Returns the dgf users fortnight report c form where usernationalId = &#63; and licenseNo = &#63; or throws a <code>NoSuchDgfUsersFortnightReportCFormException</code> if it could not be found.
	 *
	 * @param usernationalId the usernational ID
	 * @param licenseNo the license no
	 * @return the matching dgf users fortnight report c form
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a matching dgf users fortnight report c form could not be found
	 */
	@Override
	public DgfUsersFortnightReportCForm
			findByFortnightReportCFormByNIDandLicenseNo(
				String usernationalId, String licenseNo)
		throws NoSuchDgfUsersFortnightReportCFormException {

		DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm =
			fetchByFortnightReportCFormByNIDandLicenseNo(
				usernationalId, licenseNo);

		if (dgfUsersFortnightReportCForm == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("usernationalId=");
			sb.append(usernationalId);

			sb.append(", licenseNo=");
			sb.append(licenseNo);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDgfUsersFortnightReportCFormException(
				sb.toString());
		}

		return dgfUsersFortnightReportCForm;
	}

	/**
	 * Returns the dgf users fortnight report c form where usernationalId = &#63; and licenseNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param usernationalId the usernational ID
	 * @param licenseNo the license no
	 * @return the matching dgf users fortnight report c form, or <code>null</code> if a matching dgf users fortnight report c form could not be found
	 */
	@Override
	public DgfUsersFortnightReportCForm
		fetchByFortnightReportCFormByNIDandLicenseNo(
			String usernationalId, String licenseNo) {

		return fetchByFortnightReportCFormByNIDandLicenseNo(
			usernationalId, licenseNo, true);
	}

	/**
	 * Returns the dgf users fortnight report c form where usernationalId = &#63; and licenseNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param usernationalId the usernational ID
	 * @param licenseNo the license no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf users fortnight report c form, or <code>null</code> if a matching dgf users fortnight report c form could not be found
	 */
	@Override
	public DgfUsersFortnightReportCForm
		fetchByFortnightReportCFormByNIDandLicenseNo(
			String usernationalId, String licenseNo, boolean useFinderCache) {

		usernationalId = Objects.toString(usernationalId, "");
		licenseNo = Objects.toString(licenseNo, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {usernationalId, licenseNo};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByFortnightReportCFormByNIDandLicenseNo,
				finderArgs, this);
		}

		if (result instanceof DgfUsersFortnightReportCForm) {
			DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm =
				(DgfUsersFortnightReportCForm)result;

			if (!Objects.equals(
					usernationalId,
					dgfUsersFortnightReportCForm.getUsernationalId()) ||
				!Objects.equals(
					licenseNo, dgfUsersFortnightReportCForm.getLicenseNo())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DGFUSERSFORTNIGHTREPORTCFORM_WHERE);

			boolean bindUsernationalId = false;

			if (usernationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_FORTNIGHTREPORTCFORMBYNIDANDLICENSENO_USERNATIONALID_3);
			}
			else {
				bindUsernationalId = true;

				sb.append(
					_FINDER_COLUMN_FORTNIGHTREPORTCFORMBYNIDANDLICENSENO_USERNATIONALID_2);
			}

			boolean bindLicenseNo = false;

			if (licenseNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_FORTNIGHTREPORTCFORMBYNIDANDLICENSENO_LICENSENO_3);
			}
			else {
				bindLicenseNo = true;

				sb.append(
					_FINDER_COLUMN_FORTNIGHTREPORTCFORMBYNIDANDLICENSENO_LICENSENO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUsernationalId) {
					queryPos.add(usernationalId);
				}

				if (bindLicenseNo) {
					queryPos.add(licenseNo);
				}

				List<DgfUsersFortnightReportCForm> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByFortnightReportCFormByNIDandLicenseNo,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									usernationalId, licenseNo
								};
							}

							_log.warn(
								"DgfUsersFortnightReportCFormPersistenceImpl.fetchByFortnightReportCFormByNIDandLicenseNo(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm =
						list.get(0);

					result = dgfUsersFortnightReportCForm;

					cacheResult(dgfUsersFortnightReportCForm);
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
			return (DgfUsersFortnightReportCForm)result;
		}
	}

	/**
	 * Removes the dgf users fortnight report c form where usernationalId = &#63; and licenseNo = &#63; from the database.
	 *
	 * @param usernationalId the usernational ID
	 * @param licenseNo the license no
	 * @return the dgf users fortnight report c form that was removed
	 */
	@Override
	public DgfUsersFortnightReportCForm
			removeByFortnightReportCFormByNIDandLicenseNo(
				String usernationalId, String licenseNo)
		throws NoSuchDgfUsersFortnightReportCFormException {

		DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm =
			findByFortnightReportCFormByNIDandLicenseNo(
				usernationalId, licenseNo);

		return remove(dgfUsersFortnightReportCForm);
	}

	/**
	 * Returns the number of dgf users fortnight report c forms where usernationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @param licenseNo the license no
	 * @return the number of matching dgf users fortnight report c forms
	 */
	@Override
	public int countByFortnightReportCFormByNIDandLicenseNo(
		String usernationalId, String licenseNo) {

		usernationalId = Objects.toString(usernationalId, "");
		licenseNo = Objects.toString(licenseNo, "");

		FinderPath finderPath =
			_finderPathCountByFortnightReportCFormByNIDandLicenseNo;

		Object[] finderArgs = new Object[] {usernationalId, licenseNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DGFUSERSFORTNIGHTREPORTCFORM_WHERE);

			boolean bindUsernationalId = false;

			if (usernationalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_FORTNIGHTREPORTCFORMBYNIDANDLICENSENO_USERNATIONALID_3);
			}
			else {
				bindUsernationalId = true;

				sb.append(
					_FINDER_COLUMN_FORTNIGHTREPORTCFORMBYNIDANDLICENSENO_USERNATIONALID_2);
			}

			boolean bindLicenseNo = false;

			if (licenseNo.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_FORTNIGHTREPORTCFORMBYNIDANDLICENSENO_LICENSENO_3);
			}
			else {
				bindLicenseNo = true;

				sb.append(
					_FINDER_COLUMN_FORTNIGHTREPORTCFORMBYNIDANDLICENSENO_LICENSENO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUsernationalId) {
					queryPos.add(usernationalId);
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

	private static final String
		_FINDER_COLUMN_FORTNIGHTREPORTCFORMBYNIDANDLICENSENO_USERNATIONALID_2 =
			"dgfUsersFortnightReportCForm.usernationalId = ? AND ";

	private static final String
		_FINDER_COLUMN_FORTNIGHTREPORTCFORMBYNIDANDLICENSENO_USERNATIONALID_3 =
			"(dgfUsersFortnightReportCForm.usernationalId IS NULL OR dgfUsersFortnightReportCForm.usernationalId = '') AND ";

	private static final String
		_FINDER_COLUMN_FORTNIGHTREPORTCFORMBYNIDANDLICENSENO_LICENSENO_2 =
			"dgfUsersFortnightReportCForm.licenseNo = ?";

	private static final String
		_FINDER_COLUMN_FORTNIGHTREPORTCFORMBYNIDANDLICENSENO_LICENSENO_3 =
			"(dgfUsersFortnightReportCForm.licenseNo IS NULL OR dgfUsersFortnightReportCForm.licenseNo = '')";

	public DgfUsersFortnightReportCFormPersistenceImpl() {
		setModelClass(DgfUsersFortnightReportCForm.class);

		setModelImplClass(DgfUsersFortnightReportCFormImpl.class);
		setModelPKClass(long.class);

		setTable(DgfUsersFortnightReportCFormTable.INSTANCE);
	}

	/**
	 * Caches the dgf users fortnight report c form in the entity cache if it is enabled.
	 *
	 * @param dgfUsersFortnightReportCForm the dgf users fortnight report c form
	 */
	@Override
	public void cacheResult(
		DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm) {

		entityCache.putResult(
			DgfUsersFortnightReportCFormImpl.class,
			dgfUsersFortnightReportCForm.getPrimaryKey(),
			dgfUsersFortnightReportCForm);

		finderCache.putResult(
			_finderPathFetchByFortnightReportCFormByNIDandLicenseNo,
			new Object[] {
				dgfUsersFortnightReportCForm.getUsernationalId(),
				dgfUsersFortnightReportCForm.getLicenseNo()
			},
			dgfUsersFortnightReportCForm);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dgf users fortnight report c forms in the entity cache if it is enabled.
	 *
	 * @param dgfUsersFortnightReportCForms the dgf users fortnight report c forms
	 */
	@Override
	public void cacheResult(
		List<DgfUsersFortnightReportCForm> dgfUsersFortnightReportCForms) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dgfUsersFortnightReportCForms.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm :
				dgfUsersFortnightReportCForms) {

			if (entityCache.getResult(
					DgfUsersFortnightReportCFormImpl.class,
					dgfUsersFortnightReportCForm.getPrimaryKey()) == null) {

				cacheResult(dgfUsersFortnightReportCForm);
			}
		}
	}

	/**
	 * Clears the cache for all dgf users fortnight report c forms.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DgfUsersFortnightReportCFormImpl.class);

		finderCache.clearCache(DgfUsersFortnightReportCFormImpl.class);
	}

	/**
	 * Clears the cache for the dgf users fortnight report c form.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm) {

		entityCache.removeResult(
			DgfUsersFortnightReportCFormImpl.class,
			dgfUsersFortnightReportCForm);
	}

	@Override
	public void clearCache(
		List<DgfUsersFortnightReportCForm> dgfUsersFortnightReportCForms) {

		for (DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm :
				dgfUsersFortnightReportCForms) {

			entityCache.removeResult(
				DgfUsersFortnightReportCFormImpl.class,
				dgfUsersFortnightReportCForm);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DgfUsersFortnightReportCFormImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				DgfUsersFortnightReportCFormImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DgfUsersFortnightReportCFormModelImpl
			dgfUsersFortnightReportCFormModelImpl) {

		Object[] args = new Object[] {
			dgfUsersFortnightReportCFormModelImpl.getUsernationalId(),
			dgfUsersFortnightReportCFormModelImpl.getLicenseNo()
		};

		finderCache.putResult(
			_finderPathCountByFortnightReportCFormByNIDandLicenseNo, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByFortnightReportCFormByNIDandLicenseNo, args,
			dgfUsersFortnightReportCFormModelImpl);
	}

	/**
	 * Creates a new dgf users fortnight report c form with the primary key. Does not add the dgf users fortnight report c form to the database.
	 *
	 * @param reportId the primary key for the new dgf users fortnight report c form
	 * @return the new dgf users fortnight report c form
	 */
	@Override
	public DgfUsersFortnightReportCForm create(long reportId) {
		DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm =
			new DgfUsersFortnightReportCFormImpl();

		dgfUsersFortnightReportCForm.setNew(true);
		dgfUsersFortnightReportCForm.setPrimaryKey(reportId);

		return dgfUsersFortnightReportCForm;
	}

	/**
	 * Removes the dgf users fortnight report c form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param reportId the primary key of the dgf users fortnight report c form
	 * @return the dgf users fortnight report c form that was removed
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a dgf users fortnight report c form with the primary key could not be found
	 */
	@Override
	public DgfUsersFortnightReportCForm remove(long reportId)
		throws NoSuchDgfUsersFortnightReportCFormException {

		return remove((Serializable)reportId);
	}

	/**
	 * Removes the dgf users fortnight report c form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dgf users fortnight report c form
	 * @return the dgf users fortnight report c form that was removed
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a dgf users fortnight report c form with the primary key could not be found
	 */
	@Override
	public DgfUsersFortnightReportCForm remove(Serializable primaryKey)
		throws NoSuchDgfUsersFortnightReportCFormException {

		Session session = null;

		try {
			session = openSession();

			DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm =
				(DgfUsersFortnightReportCForm)session.get(
					DgfUsersFortnightReportCFormImpl.class, primaryKey);

			if (dgfUsersFortnightReportCForm == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDgfUsersFortnightReportCFormException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dgfUsersFortnightReportCForm);
		}
		catch (NoSuchDgfUsersFortnightReportCFormException
					noSuchEntityException) {

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
	protected DgfUsersFortnightReportCForm removeImpl(
		DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dgfUsersFortnightReportCForm)) {
				dgfUsersFortnightReportCForm =
					(DgfUsersFortnightReportCForm)session.get(
						DgfUsersFortnightReportCFormImpl.class,
						dgfUsersFortnightReportCForm.getPrimaryKeyObj());
			}

			if (dgfUsersFortnightReportCForm != null) {
				session.delete(dgfUsersFortnightReportCForm);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dgfUsersFortnightReportCForm != null) {
			clearCache(dgfUsersFortnightReportCForm);
		}

		return dgfUsersFortnightReportCForm;
	}

	@Override
	public DgfUsersFortnightReportCForm updateImpl(
		DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm) {

		boolean isNew = dgfUsersFortnightReportCForm.isNew();

		if (!(dgfUsersFortnightReportCForm instanceof
				DgfUsersFortnightReportCFormModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					dgfUsersFortnightReportCForm.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					dgfUsersFortnightReportCForm);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dgfUsersFortnightReportCForm proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DgfUsersFortnightReportCForm implementation " +
					dgfUsersFortnightReportCForm.getClass());
		}

		DgfUsersFortnightReportCFormModelImpl
			dgfUsersFortnightReportCFormModelImpl =
				(DgfUsersFortnightReportCFormModelImpl)
					dgfUsersFortnightReportCForm;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dgfUsersFortnightReportCForm);
			}
			else {
				dgfUsersFortnightReportCForm =
					(DgfUsersFortnightReportCForm)session.merge(
						dgfUsersFortnightReportCForm);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DgfUsersFortnightReportCFormImpl.class,
			dgfUsersFortnightReportCFormModelImpl, false, true);

		cacheUniqueFindersCache(dgfUsersFortnightReportCFormModelImpl);

		if (isNew) {
			dgfUsersFortnightReportCForm.setNew(false);
		}

		dgfUsersFortnightReportCForm.resetOriginalValues();

		return dgfUsersFortnightReportCForm;
	}

	/**
	 * Returns the dgf users fortnight report c form with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dgf users fortnight report c form
	 * @return the dgf users fortnight report c form
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a dgf users fortnight report c form with the primary key could not be found
	 */
	@Override
	public DgfUsersFortnightReportCForm findByPrimaryKey(
			Serializable primaryKey)
		throws NoSuchDgfUsersFortnightReportCFormException {

		DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm =
			fetchByPrimaryKey(primaryKey);

		if (dgfUsersFortnightReportCForm == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDgfUsersFortnightReportCFormException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dgfUsersFortnightReportCForm;
	}

	/**
	 * Returns the dgf users fortnight report c form with the primary key or throws a <code>NoSuchDgfUsersFortnightReportCFormException</code> if it could not be found.
	 *
	 * @param reportId the primary key of the dgf users fortnight report c form
	 * @return the dgf users fortnight report c form
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a dgf users fortnight report c form with the primary key could not be found
	 */
	@Override
	public DgfUsersFortnightReportCForm findByPrimaryKey(long reportId)
		throws NoSuchDgfUsersFortnightReportCFormException {

		return findByPrimaryKey((Serializable)reportId);
	}

	/**
	 * Returns the dgf users fortnight report c form with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param reportId the primary key of the dgf users fortnight report c form
	 * @return the dgf users fortnight report c form, or <code>null</code> if a dgf users fortnight report c form with the primary key could not be found
	 */
	@Override
	public DgfUsersFortnightReportCForm fetchByPrimaryKey(long reportId) {
		return fetchByPrimaryKey((Serializable)reportId);
	}

	/**
	 * Returns all the dgf users fortnight report c forms.
	 *
	 * @return the dgf users fortnight report c forms
	 */
	@Override
	public List<DgfUsersFortnightReportCForm> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dgf users fortnight report c forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportCFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users fortnight report c forms
	 * @param end the upper bound of the range of dgf users fortnight report c forms (not inclusive)
	 * @return the range of dgf users fortnight report c forms
	 */
	@Override
	public List<DgfUsersFortnightReportCForm> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dgf users fortnight report c forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportCFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users fortnight report c forms
	 * @param end the upper bound of the range of dgf users fortnight report c forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf users fortnight report c forms
	 */
	@Override
	public List<DgfUsersFortnightReportCForm> findAll(
		int start, int end,
		OrderByComparator<DgfUsersFortnightReportCForm> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dgf users fortnight report c forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportCFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users fortnight report c forms
	 * @param end the upper bound of the range of dgf users fortnight report c forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf users fortnight report c forms
	 */
	@Override
	public List<DgfUsersFortnightReportCForm> findAll(
		int start, int end,
		OrderByComparator<DgfUsersFortnightReportCForm> orderByComparator,
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

		List<DgfUsersFortnightReportCForm> list = null;

		if (useFinderCache) {
			list = (List<DgfUsersFortnightReportCForm>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DGFUSERSFORTNIGHTREPORTCFORM);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DGFUSERSFORTNIGHTREPORTCFORM;

				sql = sql.concat(
					DgfUsersFortnightReportCFormModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DgfUsersFortnightReportCForm>)QueryUtil.list(
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
	 * Removes all the dgf users fortnight report c forms from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm :
				findAll()) {

			remove(dgfUsersFortnightReportCForm);
		}
	}

	/**
	 * Returns the number of dgf users fortnight report c forms.
	 *
	 * @return the number of dgf users fortnight report c forms
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
					_SQL_COUNT_DGFUSERSFORTNIGHTREPORTCFORM);

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
		return "reportId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DGFUSERSFORTNIGHTREPORTCFORM;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DgfUsersFortnightReportCFormModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dgf users fortnight report c form persistence.
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

		_finderPathWithPaginationFindByFortnightReportCFormByUsernationalId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByFortnightReportCFormByUsernationalId",
				new String[] {
					String.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"usernationalId"}, true);

		_finderPathWithoutPaginationFindByFortnightReportCFormByUsernationalId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByFortnightReportCFormByUsernationalId",
				new String[] {String.class.getName()},
				new String[] {"usernationalId"}, true);

		_finderPathCountByFortnightReportCFormByUsernationalId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFortnightReportCFormByUsernationalId",
			new String[] {String.class.getName()},
			new String[] {"usernationalId"}, false);

		_finderPathWithPaginationFindByForthnightReportCFormByScreenName =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByForthnightReportCFormByScreenName",
				new String[] {
					String.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"screenName"}, true);

		_finderPathWithoutPaginationFindByForthnightReportCFormByScreenName =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByForthnightReportCFormByScreenName",
				new String[] {String.class.getName()},
				new String[] {"screenName"}, true);

		_finderPathCountByForthnightReportCFormByScreenName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByForthnightReportCFormByScreenName",
			new String[] {String.class.getName()}, new String[] {"screenName"},
			false);

		_finderPathFetchByFortnightReportCFormByNIDandLicenseNo =
			new FinderPath(
				FINDER_CLASS_NAME_ENTITY,
				"fetchByFortnightReportCFormByNIDandLicenseNo",
				new String[] {String.class.getName(), String.class.getName()},
				new String[] {"usernationalId", "licenseNo"}, true);

		_finderPathCountByFortnightReportCFormByNIDandLicenseNo =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByFortnightReportCFormByNIDandLicenseNo",
				new String[] {String.class.getName(), String.class.getName()},
				new String[] {"usernationalId", "licenseNo"}, false);

		_setDgfUsersFortnightReportCFormUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDgfUsersFortnightReportCFormUtilPersistence(null);

		entityCache.removeCache(
			DgfUsersFortnightReportCFormImpl.class.getName());
	}

	private void _setDgfUsersFortnightReportCFormUtilPersistence(
		DgfUsersFortnightReportCFormPersistence
			dgfUsersFortnightReportCFormPersistence) {

		try {
			Field field =
				DgfUsersFortnightReportCFormUtil.class.getDeclaredField(
					"_persistence");

			field.setAccessible(true);

			field.set(null, dgfUsersFortnightReportCFormPersistence);
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

	private static final String _SQL_SELECT_DGFUSERSFORTNIGHTREPORTCFORM =
		"SELECT dgfUsersFortnightReportCForm FROM DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm";

	private static final String _SQL_SELECT_DGFUSERSFORTNIGHTREPORTCFORM_WHERE =
		"SELECT dgfUsersFortnightReportCForm FROM DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm WHERE ";

	private static final String _SQL_COUNT_DGFUSERSFORTNIGHTREPORTCFORM =
		"SELECT COUNT(dgfUsersFortnightReportCForm) FROM DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm";

	private static final String _SQL_COUNT_DGFUSERSFORTNIGHTREPORTCFORM_WHERE =
		"SELECT COUNT(dgfUsersFortnightReportCForm) FROM DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm WHERE ";

	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN =
		"dgfUsersFortnightReportCForm.reportId";

	private static final String
		_FILTER_SQL_SELECT_DGFUSERSFORTNIGHTREPORTCFORM_WHERE =
			"SELECT DISTINCT {dgfUsersFortnightReportCForm.*} FROM dgf_users_fortnightreport_c dgfUsersFortnightReportCForm WHERE ";

	private static final String
		_FILTER_SQL_SELECT_DGFUSERSFORTNIGHTREPORTCFORM_NO_INLINE_DISTINCT_WHERE_1 =
			"SELECT {dgf_users_fortnightreport_c.*} FROM (SELECT DISTINCT dgfUsersFortnightReportCForm.reportId FROM dgf_users_fortnightreport_c dgfUsersFortnightReportCForm WHERE ";

	private static final String
		_FILTER_SQL_SELECT_DGFUSERSFORTNIGHTREPORTCFORM_NO_INLINE_DISTINCT_WHERE_2 =
			") TEMP_TABLE INNER JOIN dgf_users_fortnightreport_c ON TEMP_TABLE.reportId = dgf_users_fortnightreport_c.reportId";

	private static final String
		_FILTER_SQL_COUNT_DGFUSERSFORTNIGHTREPORTCFORM_WHERE =
			"SELECT COUNT(DISTINCT dgfUsersFortnightReportCForm.reportId) AS COUNT_VALUE FROM dgf_users_fortnightreport_c dgfUsersFortnightReportCForm WHERE ";

	private static final String _FILTER_ENTITY_ALIAS =
		"dgfUsersFortnightReportCForm";

	private static final String _FILTER_ENTITY_TABLE =
		"dgf_users_fortnightreport_c";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"dgfUsersFortnightReportCForm.";

	private static final String _ORDER_BY_ENTITY_TABLE =
		"dgf_users_fortnightreport_c.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DgfUsersFortnightReportCForm exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DgfUsersFortnightReportCForm exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DgfUsersFortnightReportCFormPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}