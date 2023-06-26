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

package bd.gov.dgfood.food.grain.license.service.persistence;

import bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportDForm;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dgf users fortnight report d form service. This utility wraps <code>bd.gov.dgfood.food.grain.license.service.persistence.impl.DgfUsersFortnightReportDFormPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersFortnightReportDFormPersistence
 * @generated
 */
public class DgfUsersFortnightReportDFormUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(
		DgfUsersFortnightReportDForm dgfUsersFortnightReportDForm) {

		getPersistence().clearCache(dgfUsersFortnightReportDForm);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, DgfUsersFortnightReportDForm>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DgfUsersFortnightReportDForm> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DgfUsersFortnightReportDForm> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DgfUsersFortnightReportDForm> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DgfUsersFortnightReportDForm> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DgfUsersFortnightReportDForm update(
		DgfUsersFortnightReportDForm dgfUsersFortnightReportDForm) {

		return getPersistence().update(dgfUsersFortnightReportDForm);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DgfUsersFortnightReportDForm update(
		DgfUsersFortnightReportDForm dgfUsersFortnightReportDForm,
		ServiceContext serviceContext) {

		return getPersistence().update(
			dgfUsersFortnightReportDForm, serviceContext);
	}

	/**
	 * Returns all the dgf users fortnight report d forms where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @return the matching dgf users fortnight report d forms
	 */
	public static List<DgfUsersFortnightReportDForm>
		findByFortnightReportDFormByUsernationalId(String usernationalId) {

		return getPersistence().findByFortnightReportDFormByUsernationalId(
			usernationalId);
	}

	/**
	 * Returns a range of all the dgf users fortnight report d forms where usernationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportDFormModelImpl</code>.
	 * </p>
	 *
	 * @param usernationalId the usernational ID
	 * @param start the lower bound of the range of dgf users fortnight report d forms
	 * @param end the upper bound of the range of dgf users fortnight report d forms (not inclusive)
	 * @return the range of matching dgf users fortnight report d forms
	 */
	public static List<DgfUsersFortnightReportDForm>
		findByFortnightReportDFormByUsernationalId(
			String usernationalId, int start, int end) {

		return getPersistence().findByFortnightReportDFormByUsernationalId(
			usernationalId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf users fortnight report d forms where usernationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportDFormModelImpl</code>.
	 * </p>
	 *
	 * @param usernationalId the usernational ID
	 * @param start the lower bound of the range of dgf users fortnight report d forms
	 * @param end the upper bound of the range of dgf users fortnight report d forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users fortnight report d forms
	 */
	public static List<DgfUsersFortnightReportDForm>
		findByFortnightReportDFormByUsernationalId(
			String usernationalId, int start, int end,
			OrderByComparator<DgfUsersFortnightReportDForm> orderByComparator) {

		return getPersistence().findByFortnightReportDFormByUsernationalId(
			usernationalId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf users fortnight report d forms where usernationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportDFormModelImpl</code>.
	 * </p>
	 *
	 * @param usernationalId the usernational ID
	 * @param start the lower bound of the range of dgf users fortnight report d forms
	 * @param end the upper bound of the range of dgf users fortnight report d forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users fortnight report d forms
	 */
	public static List<DgfUsersFortnightReportDForm>
		findByFortnightReportDFormByUsernationalId(
			String usernationalId, int start, int end,
			OrderByComparator<DgfUsersFortnightReportDForm> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByFortnightReportDFormByUsernationalId(
			usernationalId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf users fortnight report d form in the ordered set where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users fortnight report d form
	 * @throws NoSuchDgfUsersFortnightReportDFormException if a matching dgf users fortnight report d form could not be found
	 */
	public static DgfUsersFortnightReportDForm
			findByFortnightReportDFormByUsernationalId_First(
				String usernationalId,
				OrderByComparator<DgfUsersFortnightReportDForm>
					orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersFortnightReportDFormException {

		return getPersistence().
			findByFortnightReportDFormByUsernationalId_First(
				usernationalId, orderByComparator);
	}

	/**
	 * Returns the first dgf users fortnight report d form in the ordered set where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users fortnight report d form, or <code>null</code> if a matching dgf users fortnight report d form could not be found
	 */
	public static DgfUsersFortnightReportDForm
		fetchByFortnightReportDFormByUsernationalId_First(
			String usernationalId,
			OrderByComparator<DgfUsersFortnightReportDForm> orderByComparator) {

		return getPersistence().
			fetchByFortnightReportDFormByUsernationalId_First(
				usernationalId, orderByComparator);
	}

	/**
	 * Returns the last dgf users fortnight report d form in the ordered set where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users fortnight report d form
	 * @throws NoSuchDgfUsersFortnightReportDFormException if a matching dgf users fortnight report d form could not be found
	 */
	public static DgfUsersFortnightReportDForm
			findByFortnightReportDFormByUsernationalId_Last(
				String usernationalId,
				OrderByComparator<DgfUsersFortnightReportDForm>
					orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersFortnightReportDFormException {

		return getPersistence().findByFortnightReportDFormByUsernationalId_Last(
			usernationalId, orderByComparator);
	}

	/**
	 * Returns the last dgf users fortnight report d form in the ordered set where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users fortnight report d form, or <code>null</code> if a matching dgf users fortnight report d form could not be found
	 */
	public static DgfUsersFortnightReportDForm
		fetchByFortnightReportDFormByUsernationalId_Last(
			String usernationalId,
			OrderByComparator<DgfUsersFortnightReportDForm> orderByComparator) {

		return getPersistence().
			fetchByFortnightReportDFormByUsernationalId_Last(
				usernationalId, orderByComparator);
	}

	/**
	 * Returns the dgf users fortnight report d forms before and after the current dgf users fortnight report d form in the ordered set where usernationalId = &#63;.
	 *
	 * @param reportId the primary key of the current dgf users fortnight report d form
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users fortnight report d form
	 * @throws NoSuchDgfUsersFortnightReportDFormException if a dgf users fortnight report d form with the primary key could not be found
	 */
	public static DgfUsersFortnightReportDForm[]
			findByFortnightReportDFormByUsernationalId_PrevAndNext(
				long reportId, String usernationalId,
				OrderByComparator<DgfUsersFortnightReportDForm>
					orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersFortnightReportDFormException {

		return getPersistence().
			findByFortnightReportDFormByUsernationalId_PrevAndNext(
				reportId, usernationalId, orderByComparator);
	}

	/**
	 * Returns all the dgf users fortnight report d forms that the user has permission to view where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @return the matching dgf users fortnight report d forms that the user has permission to view
	 */
	public static List<DgfUsersFortnightReportDForm>
		filterFindByFortnightReportDFormByUsernationalId(
			String usernationalId) {

		return getPersistence().
			filterFindByFortnightReportDFormByUsernationalId(usernationalId);
	}

	/**
	 * Returns a range of all the dgf users fortnight report d forms that the user has permission to view where usernationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportDFormModelImpl</code>.
	 * </p>
	 *
	 * @param usernationalId the usernational ID
	 * @param start the lower bound of the range of dgf users fortnight report d forms
	 * @param end the upper bound of the range of dgf users fortnight report d forms (not inclusive)
	 * @return the range of matching dgf users fortnight report d forms that the user has permission to view
	 */
	public static List<DgfUsersFortnightReportDForm>
		filterFindByFortnightReportDFormByUsernationalId(
			String usernationalId, int start, int end) {

		return getPersistence().
			filterFindByFortnightReportDFormByUsernationalId(
				usernationalId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf users fortnight report d forms that the user has permissions to view where usernationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportDFormModelImpl</code>.
	 * </p>
	 *
	 * @param usernationalId the usernational ID
	 * @param start the lower bound of the range of dgf users fortnight report d forms
	 * @param end the upper bound of the range of dgf users fortnight report d forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users fortnight report d forms that the user has permission to view
	 */
	public static List<DgfUsersFortnightReportDForm>
		filterFindByFortnightReportDFormByUsernationalId(
			String usernationalId, int start, int end,
			OrderByComparator<DgfUsersFortnightReportDForm> orderByComparator) {

		return getPersistence().
			filterFindByFortnightReportDFormByUsernationalId(
				usernationalId, start, end, orderByComparator);
	}

	/**
	 * Returns the dgf users fortnight report d forms before and after the current dgf users fortnight report d form in the ordered set of dgf users fortnight report d forms that the user has permission to view where usernationalId = &#63;.
	 *
	 * @param reportId the primary key of the current dgf users fortnight report d form
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users fortnight report d form
	 * @throws NoSuchDgfUsersFortnightReportDFormException if a dgf users fortnight report d form with the primary key could not be found
	 */
	public static DgfUsersFortnightReportDForm[]
			filterFindByFortnightReportDFormByUsernationalId_PrevAndNext(
				long reportId, String usernationalId,
				OrderByComparator<DgfUsersFortnightReportDForm>
					orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersFortnightReportDFormException {

		return getPersistence().
			filterFindByFortnightReportDFormByUsernationalId_PrevAndNext(
				reportId, usernationalId, orderByComparator);
	}

	/**
	 * Removes all the dgf users fortnight report d forms where usernationalId = &#63; from the database.
	 *
	 * @param usernationalId the usernational ID
	 */
	public static void removeByFortnightReportDFormByUsernationalId(
		String usernationalId) {

		getPersistence().removeByFortnightReportDFormByUsernationalId(
			usernationalId);
	}

	/**
	 * Returns the number of dgf users fortnight report d forms where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @return the number of matching dgf users fortnight report d forms
	 */
	public static int countByFortnightReportDFormByUsernationalId(
		String usernationalId) {

		return getPersistence().countByFortnightReportDFormByUsernationalId(
			usernationalId);
	}

	/**
	 * Returns the number of dgf users fortnight report d forms that the user has permission to view where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @return the number of matching dgf users fortnight report d forms that the user has permission to view
	 */
	public static int filterCountByFortnightReportDFormByUsernationalId(
		String usernationalId) {

		return getPersistence().
			filterCountByFortnightReportDFormByUsernationalId(usernationalId);
	}

	/**
	 * Returns all the dgf users fortnight report d forms where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the matching dgf users fortnight report d forms
	 */
	public static List<DgfUsersFortnightReportDForm>
		findByFortnightReportDFormByScreenName(String screenName) {

		return getPersistence().findByFortnightReportDFormByScreenName(
			screenName);
	}

	/**
	 * Returns a range of all the dgf users fortnight report d forms where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportDFormModelImpl</code>.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of dgf users fortnight report d forms
	 * @param end the upper bound of the range of dgf users fortnight report d forms (not inclusive)
	 * @return the range of matching dgf users fortnight report d forms
	 */
	public static List<DgfUsersFortnightReportDForm>
		findByFortnightReportDFormByScreenName(
			String screenName, int start, int end) {

		return getPersistence().findByFortnightReportDFormByScreenName(
			screenName, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf users fortnight report d forms where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportDFormModelImpl</code>.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of dgf users fortnight report d forms
	 * @param end the upper bound of the range of dgf users fortnight report d forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users fortnight report d forms
	 */
	public static List<DgfUsersFortnightReportDForm>
		findByFortnightReportDFormByScreenName(
			String screenName, int start, int end,
			OrderByComparator<DgfUsersFortnightReportDForm> orderByComparator) {

		return getPersistence().findByFortnightReportDFormByScreenName(
			screenName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf users fortnight report d forms where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportDFormModelImpl</code>.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of dgf users fortnight report d forms
	 * @param end the upper bound of the range of dgf users fortnight report d forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users fortnight report d forms
	 */
	public static List<DgfUsersFortnightReportDForm>
		findByFortnightReportDFormByScreenName(
			String screenName, int start, int end,
			OrderByComparator<DgfUsersFortnightReportDForm> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByFortnightReportDFormByScreenName(
			screenName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf users fortnight report d form in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users fortnight report d form
	 * @throws NoSuchDgfUsersFortnightReportDFormException if a matching dgf users fortnight report d form could not be found
	 */
	public static DgfUsersFortnightReportDForm
			findByFortnightReportDFormByScreenName_First(
				String screenName,
				OrderByComparator<DgfUsersFortnightReportDForm>
					orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersFortnightReportDFormException {

		return getPersistence().findByFortnightReportDFormByScreenName_First(
			screenName, orderByComparator);
	}

	/**
	 * Returns the first dgf users fortnight report d form in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users fortnight report d form, or <code>null</code> if a matching dgf users fortnight report d form could not be found
	 */
	public static DgfUsersFortnightReportDForm
		fetchByFortnightReportDFormByScreenName_First(
			String screenName,
			OrderByComparator<DgfUsersFortnightReportDForm> orderByComparator) {

		return getPersistence().fetchByFortnightReportDFormByScreenName_First(
			screenName, orderByComparator);
	}

	/**
	 * Returns the last dgf users fortnight report d form in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users fortnight report d form
	 * @throws NoSuchDgfUsersFortnightReportDFormException if a matching dgf users fortnight report d form could not be found
	 */
	public static DgfUsersFortnightReportDForm
			findByFortnightReportDFormByScreenName_Last(
				String screenName,
				OrderByComparator<DgfUsersFortnightReportDForm>
					orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersFortnightReportDFormException {

		return getPersistence().findByFortnightReportDFormByScreenName_Last(
			screenName, orderByComparator);
	}

	/**
	 * Returns the last dgf users fortnight report d form in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users fortnight report d form, or <code>null</code> if a matching dgf users fortnight report d form could not be found
	 */
	public static DgfUsersFortnightReportDForm
		fetchByFortnightReportDFormByScreenName_Last(
			String screenName,
			OrderByComparator<DgfUsersFortnightReportDForm> orderByComparator) {

		return getPersistence().fetchByFortnightReportDFormByScreenName_Last(
			screenName, orderByComparator);
	}

	/**
	 * Returns the dgf users fortnight report d forms before and after the current dgf users fortnight report d form in the ordered set where screenName = &#63;.
	 *
	 * @param reportId the primary key of the current dgf users fortnight report d form
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users fortnight report d form
	 * @throws NoSuchDgfUsersFortnightReportDFormException if a dgf users fortnight report d form with the primary key could not be found
	 */
	public static DgfUsersFortnightReportDForm[]
			findByFortnightReportDFormByScreenName_PrevAndNext(
				long reportId, String screenName,
				OrderByComparator<DgfUsersFortnightReportDForm>
					orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersFortnightReportDFormException {

		return getPersistence().
			findByFortnightReportDFormByScreenName_PrevAndNext(
				reportId, screenName, orderByComparator);
	}

	/**
	 * Returns all the dgf users fortnight report d forms that the user has permission to view where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the matching dgf users fortnight report d forms that the user has permission to view
	 */
	public static List<DgfUsersFortnightReportDForm>
		filterFindByFortnightReportDFormByScreenName(String screenName) {

		return getPersistence().filterFindByFortnightReportDFormByScreenName(
			screenName);
	}

	/**
	 * Returns a range of all the dgf users fortnight report d forms that the user has permission to view where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportDFormModelImpl</code>.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of dgf users fortnight report d forms
	 * @param end the upper bound of the range of dgf users fortnight report d forms (not inclusive)
	 * @return the range of matching dgf users fortnight report d forms that the user has permission to view
	 */
	public static List<DgfUsersFortnightReportDForm>
		filterFindByFortnightReportDFormByScreenName(
			String screenName, int start, int end) {

		return getPersistence().filterFindByFortnightReportDFormByScreenName(
			screenName, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf users fortnight report d forms that the user has permissions to view where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportDFormModelImpl</code>.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of dgf users fortnight report d forms
	 * @param end the upper bound of the range of dgf users fortnight report d forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users fortnight report d forms that the user has permission to view
	 */
	public static List<DgfUsersFortnightReportDForm>
		filterFindByFortnightReportDFormByScreenName(
			String screenName, int start, int end,
			OrderByComparator<DgfUsersFortnightReportDForm> orderByComparator) {

		return getPersistence().filterFindByFortnightReportDFormByScreenName(
			screenName, start, end, orderByComparator);
	}

	/**
	 * Returns the dgf users fortnight report d forms before and after the current dgf users fortnight report d form in the ordered set of dgf users fortnight report d forms that the user has permission to view where screenName = &#63;.
	 *
	 * @param reportId the primary key of the current dgf users fortnight report d form
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users fortnight report d form
	 * @throws NoSuchDgfUsersFortnightReportDFormException if a dgf users fortnight report d form with the primary key could not be found
	 */
	public static DgfUsersFortnightReportDForm[]
			filterFindByFortnightReportDFormByScreenName_PrevAndNext(
				long reportId, String screenName,
				OrderByComparator<DgfUsersFortnightReportDForm>
					orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersFortnightReportDFormException {

		return getPersistence().
			filterFindByFortnightReportDFormByScreenName_PrevAndNext(
				reportId, screenName, orderByComparator);
	}

	/**
	 * Removes all the dgf users fortnight report d forms where screenName = &#63; from the database.
	 *
	 * @param screenName the screen name
	 */
	public static void removeByFortnightReportDFormByScreenName(
		String screenName) {

		getPersistence().removeByFortnightReportDFormByScreenName(screenName);
	}

	/**
	 * Returns the number of dgf users fortnight report d forms where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the number of matching dgf users fortnight report d forms
	 */
	public static int countByFortnightReportDFormByScreenName(
		String screenName) {

		return getPersistence().countByFortnightReportDFormByScreenName(
			screenName);
	}

	/**
	 * Returns the number of dgf users fortnight report d forms that the user has permission to view where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the number of matching dgf users fortnight report d forms that the user has permission to view
	 */
	public static int filterCountByFortnightReportDFormByScreenName(
		String screenName) {

		return getPersistence().filterCountByFortnightReportDFormByScreenName(
			screenName);
	}

	/**
	 * Returns the dgf users fortnight report d form where usernationalId = &#63; and licenseNo = &#63; or throws a <code>NoSuchDgfUsersFortnightReportDFormException</code> if it could not be found.
	 *
	 * @param usernationalId the usernational ID
	 * @param licenseNo the license no
	 * @return the matching dgf users fortnight report d form
	 * @throws NoSuchDgfUsersFortnightReportDFormException if a matching dgf users fortnight report d form could not be found
	 */
	public static DgfUsersFortnightReportDForm
			findByFortnightReportDFormByNIDandLicenseNo(
				String usernationalId, String licenseNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersFortnightReportDFormException {

		return getPersistence().findByFortnightReportDFormByNIDandLicenseNo(
			usernationalId, licenseNo);
	}

	/**
	 * Returns the dgf users fortnight report d form where usernationalId = &#63; and licenseNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param usernationalId the usernational ID
	 * @param licenseNo the license no
	 * @return the matching dgf users fortnight report d form, or <code>null</code> if a matching dgf users fortnight report d form could not be found
	 */
	public static DgfUsersFortnightReportDForm
		fetchByFortnightReportDFormByNIDandLicenseNo(
			String usernationalId, String licenseNo) {

		return getPersistence().fetchByFortnightReportDFormByNIDandLicenseNo(
			usernationalId, licenseNo);
	}

	/**
	 * Returns the dgf users fortnight report d form where usernationalId = &#63; and licenseNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param usernationalId the usernational ID
	 * @param licenseNo the license no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf users fortnight report d form, or <code>null</code> if a matching dgf users fortnight report d form could not be found
	 */
	public static DgfUsersFortnightReportDForm
		fetchByFortnightReportDFormByNIDandLicenseNo(
			String usernationalId, String licenseNo, boolean useFinderCache) {

		return getPersistence().fetchByFortnightReportDFormByNIDandLicenseNo(
			usernationalId, licenseNo, useFinderCache);
	}

	/**
	 * Removes the dgf users fortnight report d form where usernationalId = &#63; and licenseNo = &#63; from the database.
	 *
	 * @param usernationalId the usernational ID
	 * @param licenseNo the license no
	 * @return the dgf users fortnight report d form that was removed
	 */
	public static DgfUsersFortnightReportDForm
			removeByFortnightReportDFormByNIDandLicenseNo(
				String usernationalId, String licenseNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersFortnightReportDFormException {

		return getPersistence().removeByFortnightReportDFormByNIDandLicenseNo(
			usernationalId, licenseNo);
	}

	/**
	 * Returns the number of dgf users fortnight report d forms where usernationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @param licenseNo the license no
	 * @return the number of matching dgf users fortnight report d forms
	 */
	public static int countByFortnightReportDFormByNIDandLicenseNo(
		String usernationalId, String licenseNo) {

		return getPersistence().countByFortnightReportDFormByNIDandLicenseNo(
			usernationalId, licenseNo);
	}

	/**
	 * Caches the dgf users fortnight report d form in the entity cache if it is enabled.
	 *
	 * @param dgfUsersFortnightReportDForm the dgf users fortnight report d form
	 */
	public static void cacheResult(
		DgfUsersFortnightReportDForm dgfUsersFortnightReportDForm) {

		getPersistence().cacheResult(dgfUsersFortnightReportDForm);
	}

	/**
	 * Caches the dgf users fortnight report d forms in the entity cache if it is enabled.
	 *
	 * @param dgfUsersFortnightReportDForms the dgf users fortnight report d forms
	 */
	public static void cacheResult(
		List<DgfUsersFortnightReportDForm> dgfUsersFortnightReportDForms) {

		getPersistence().cacheResult(dgfUsersFortnightReportDForms);
	}

	/**
	 * Creates a new dgf users fortnight report d form with the primary key. Does not add the dgf users fortnight report d form to the database.
	 *
	 * @param reportId the primary key for the new dgf users fortnight report d form
	 * @return the new dgf users fortnight report d form
	 */
	public static DgfUsersFortnightReportDForm create(long reportId) {
		return getPersistence().create(reportId);
	}

	/**
	 * Removes the dgf users fortnight report d form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param reportId the primary key of the dgf users fortnight report d form
	 * @return the dgf users fortnight report d form that was removed
	 * @throws NoSuchDgfUsersFortnightReportDFormException if a dgf users fortnight report d form with the primary key could not be found
	 */
	public static DgfUsersFortnightReportDForm remove(long reportId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersFortnightReportDFormException {

		return getPersistence().remove(reportId);
	}

	public static DgfUsersFortnightReportDForm updateImpl(
		DgfUsersFortnightReportDForm dgfUsersFortnightReportDForm) {

		return getPersistence().updateImpl(dgfUsersFortnightReportDForm);
	}

	/**
	 * Returns the dgf users fortnight report d form with the primary key or throws a <code>NoSuchDgfUsersFortnightReportDFormException</code> if it could not be found.
	 *
	 * @param reportId the primary key of the dgf users fortnight report d form
	 * @return the dgf users fortnight report d form
	 * @throws NoSuchDgfUsersFortnightReportDFormException if a dgf users fortnight report d form with the primary key could not be found
	 */
	public static DgfUsersFortnightReportDForm findByPrimaryKey(long reportId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersFortnightReportDFormException {

		return getPersistence().findByPrimaryKey(reportId);
	}

	/**
	 * Returns the dgf users fortnight report d form with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param reportId the primary key of the dgf users fortnight report d form
	 * @return the dgf users fortnight report d form, or <code>null</code> if a dgf users fortnight report d form with the primary key could not be found
	 */
	public static DgfUsersFortnightReportDForm fetchByPrimaryKey(
		long reportId) {

		return getPersistence().fetchByPrimaryKey(reportId);
	}

	/**
	 * Returns all the dgf users fortnight report d forms.
	 *
	 * @return the dgf users fortnight report d forms
	 */
	public static List<DgfUsersFortnightReportDForm> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dgf users fortnight report d forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportDFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users fortnight report d forms
	 * @param end the upper bound of the range of dgf users fortnight report d forms (not inclusive)
	 * @return the range of dgf users fortnight report d forms
	 */
	public static List<DgfUsersFortnightReportDForm> findAll(
		int start, int end) {

		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dgf users fortnight report d forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportDFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users fortnight report d forms
	 * @param end the upper bound of the range of dgf users fortnight report d forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf users fortnight report d forms
	 */
	public static List<DgfUsersFortnightReportDForm> findAll(
		int start, int end,
		OrderByComparator<DgfUsersFortnightReportDForm> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf users fortnight report d forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersFortnightReportDFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users fortnight report d forms
	 * @param end the upper bound of the range of dgf users fortnight report d forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf users fortnight report d forms
	 */
	public static List<DgfUsersFortnightReportDForm> findAll(
		int start, int end,
		OrderByComparator<DgfUsersFortnightReportDForm> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dgf users fortnight report d forms from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dgf users fortnight report d forms.
	 *
	 * @return the number of dgf users fortnight report d forms
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DgfUsersFortnightReportDFormPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DgfUsersFortnightReportDFormPersistence
		_persistence;

}