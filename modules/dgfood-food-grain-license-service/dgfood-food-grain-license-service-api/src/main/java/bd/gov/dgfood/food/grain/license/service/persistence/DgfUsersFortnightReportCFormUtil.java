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

import bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportCForm;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dgf users fortnight report c form service. This utility wraps <code>bd.gov.dgfood.food.grain.license.service.persistence.impl.DgfUsersFortnightReportCFormPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersFortnightReportCFormPersistence
 * @generated
 */
public class DgfUsersFortnightReportCFormUtil {

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
		DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm) {

		getPersistence().clearCache(dgfUsersFortnightReportCForm);
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
	public static Map<Serializable, DgfUsersFortnightReportCForm>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DgfUsersFortnightReportCForm> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DgfUsersFortnightReportCForm> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DgfUsersFortnightReportCForm> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DgfUsersFortnightReportCForm> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DgfUsersFortnightReportCForm update(
		DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm) {

		return getPersistence().update(dgfUsersFortnightReportCForm);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DgfUsersFortnightReportCForm update(
		DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm,
		ServiceContext serviceContext) {

		return getPersistence().update(
			dgfUsersFortnightReportCForm, serviceContext);
	}

	/**
	 * Returns all the dgf users fortnight report c forms where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @return the matching dgf users fortnight report c forms
	 */
	public static List<DgfUsersFortnightReportCForm>
		findByFortnightReportCFormByUsernationalId(String usernationalId) {

		return getPersistence().findByFortnightReportCFormByUsernationalId(
			usernationalId);
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
	public static List<DgfUsersFortnightReportCForm>
		findByFortnightReportCFormByUsernationalId(
			String usernationalId, int start, int end) {

		return getPersistence().findByFortnightReportCFormByUsernationalId(
			usernationalId, start, end);
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
	public static List<DgfUsersFortnightReportCForm>
		findByFortnightReportCFormByUsernationalId(
			String usernationalId, int start, int end,
			OrderByComparator<DgfUsersFortnightReportCForm> orderByComparator) {

		return getPersistence().findByFortnightReportCFormByUsernationalId(
			usernationalId, start, end, orderByComparator);
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
	public static List<DgfUsersFortnightReportCForm>
		findByFortnightReportCFormByUsernationalId(
			String usernationalId, int start, int end,
			OrderByComparator<DgfUsersFortnightReportCForm> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByFortnightReportCFormByUsernationalId(
			usernationalId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf users fortnight report c form in the ordered set where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users fortnight report c form
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a matching dgf users fortnight report c form could not be found
	 */
	public static DgfUsersFortnightReportCForm
			findByFortnightReportCFormByUsernationalId_First(
				String usernationalId,
				OrderByComparator<DgfUsersFortnightReportCForm>
					orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersFortnightReportCFormException {

		return getPersistence().
			findByFortnightReportCFormByUsernationalId_First(
				usernationalId, orderByComparator);
	}

	/**
	 * Returns the first dgf users fortnight report c form in the ordered set where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users fortnight report c form, or <code>null</code> if a matching dgf users fortnight report c form could not be found
	 */
	public static DgfUsersFortnightReportCForm
		fetchByFortnightReportCFormByUsernationalId_First(
			String usernationalId,
			OrderByComparator<DgfUsersFortnightReportCForm> orderByComparator) {

		return getPersistence().
			fetchByFortnightReportCFormByUsernationalId_First(
				usernationalId, orderByComparator);
	}

	/**
	 * Returns the last dgf users fortnight report c form in the ordered set where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users fortnight report c form
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a matching dgf users fortnight report c form could not be found
	 */
	public static DgfUsersFortnightReportCForm
			findByFortnightReportCFormByUsernationalId_Last(
				String usernationalId,
				OrderByComparator<DgfUsersFortnightReportCForm>
					orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersFortnightReportCFormException {

		return getPersistence().findByFortnightReportCFormByUsernationalId_Last(
			usernationalId, orderByComparator);
	}

	/**
	 * Returns the last dgf users fortnight report c form in the ordered set where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users fortnight report c form, or <code>null</code> if a matching dgf users fortnight report c form could not be found
	 */
	public static DgfUsersFortnightReportCForm
		fetchByFortnightReportCFormByUsernationalId_Last(
			String usernationalId,
			OrderByComparator<DgfUsersFortnightReportCForm> orderByComparator) {

		return getPersistence().
			fetchByFortnightReportCFormByUsernationalId_Last(
				usernationalId, orderByComparator);
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
	public static DgfUsersFortnightReportCForm[]
			findByFortnightReportCFormByUsernationalId_PrevAndNext(
				long reportId, String usernationalId,
				OrderByComparator<DgfUsersFortnightReportCForm>
					orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersFortnightReportCFormException {

		return getPersistence().
			findByFortnightReportCFormByUsernationalId_PrevAndNext(
				reportId, usernationalId, orderByComparator);
	}

	/**
	 * Returns all the dgf users fortnight report c forms that the user has permission to view where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @return the matching dgf users fortnight report c forms that the user has permission to view
	 */
	public static List<DgfUsersFortnightReportCForm>
		filterFindByFortnightReportCFormByUsernationalId(
			String usernationalId) {

		return getPersistence().
			filterFindByFortnightReportCFormByUsernationalId(usernationalId);
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
	public static List<DgfUsersFortnightReportCForm>
		filterFindByFortnightReportCFormByUsernationalId(
			String usernationalId, int start, int end) {

		return getPersistence().
			filterFindByFortnightReportCFormByUsernationalId(
				usernationalId, start, end);
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
	public static List<DgfUsersFortnightReportCForm>
		filterFindByFortnightReportCFormByUsernationalId(
			String usernationalId, int start, int end,
			OrderByComparator<DgfUsersFortnightReportCForm> orderByComparator) {

		return getPersistence().
			filterFindByFortnightReportCFormByUsernationalId(
				usernationalId, start, end, orderByComparator);
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
	public static DgfUsersFortnightReportCForm[]
			filterFindByFortnightReportCFormByUsernationalId_PrevAndNext(
				long reportId, String usernationalId,
				OrderByComparator<DgfUsersFortnightReportCForm>
					orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersFortnightReportCFormException {

		return getPersistence().
			filterFindByFortnightReportCFormByUsernationalId_PrevAndNext(
				reportId, usernationalId, orderByComparator);
	}

	/**
	 * Removes all the dgf users fortnight report c forms where usernationalId = &#63; from the database.
	 *
	 * @param usernationalId the usernational ID
	 */
	public static void removeByFortnightReportCFormByUsernationalId(
		String usernationalId) {

		getPersistence().removeByFortnightReportCFormByUsernationalId(
			usernationalId);
	}

	/**
	 * Returns the number of dgf users fortnight report c forms where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @return the number of matching dgf users fortnight report c forms
	 */
	public static int countByFortnightReportCFormByUsernationalId(
		String usernationalId) {

		return getPersistence().countByFortnightReportCFormByUsernationalId(
			usernationalId);
	}

	/**
	 * Returns the number of dgf users fortnight report c forms that the user has permission to view where usernationalId = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @return the number of matching dgf users fortnight report c forms that the user has permission to view
	 */
	public static int filterCountByFortnightReportCFormByUsernationalId(
		String usernationalId) {

		return getPersistence().
			filterCountByFortnightReportCFormByUsernationalId(usernationalId);
	}

	/**
	 * Returns all the dgf users fortnight report c forms where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the matching dgf users fortnight report c forms
	 */
	public static List<DgfUsersFortnightReportCForm>
		findByForthnightReportCFormByScreenName(String screenName) {

		return getPersistence().findByForthnightReportCFormByScreenName(
			screenName);
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
	public static List<DgfUsersFortnightReportCForm>
		findByForthnightReportCFormByScreenName(
			String screenName, int start, int end) {

		return getPersistence().findByForthnightReportCFormByScreenName(
			screenName, start, end);
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
	public static List<DgfUsersFortnightReportCForm>
		findByForthnightReportCFormByScreenName(
			String screenName, int start, int end,
			OrderByComparator<DgfUsersFortnightReportCForm> orderByComparator) {

		return getPersistence().findByForthnightReportCFormByScreenName(
			screenName, start, end, orderByComparator);
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
	public static List<DgfUsersFortnightReportCForm>
		findByForthnightReportCFormByScreenName(
			String screenName, int start, int end,
			OrderByComparator<DgfUsersFortnightReportCForm> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByForthnightReportCFormByScreenName(
			screenName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf users fortnight report c form in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users fortnight report c form
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a matching dgf users fortnight report c form could not be found
	 */
	public static DgfUsersFortnightReportCForm
			findByForthnightReportCFormByScreenName_First(
				String screenName,
				OrderByComparator<DgfUsersFortnightReportCForm>
					orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersFortnightReportCFormException {

		return getPersistence().findByForthnightReportCFormByScreenName_First(
			screenName, orderByComparator);
	}

	/**
	 * Returns the first dgf users fortnight report c form in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users fortnight report c form, or <code>null</code> if a matching dgf users fortnight report c form could not be found
	 */
	public static DgfUsersFortnightReportCForm
		fetchByForthnightReportCFormByScreenName_First(
			String screenName,
			OrderByComparator<DgfUsersFortnightReportCForm> orderByComparator) {

		return getPersistence().fetchByForthnightReportCFormByScreenName_First(
			screenName, orderByComparator);
	}

	/**
	 * Returns the last dgf users fortnight report c form in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users fortnight report c form
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a matching dgf users fortnight report c form could not be found
	 */
	public static DgfUsersFortnightReportCForm
			findByForthnightReportCFormByScreenName_Last(
				String screenName,
				OrderByComparator<DgfUsersFortnightReportCForm>
					orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersFortnightReportCFormException {

		return getPersistence().findByForthnightReportCFormByScreenName_Last(
			screenName, orderByComparator);
	}

	/**
	 * Returns the last dgf users fortnight report c form in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users fortnight report c form, or <code>null</code> if a matching dgf users fortnight report c form could not be found
	 */
	public static DgfUsersFortnightReportCForm
		fetchByForthnightReportCFormByScreenName_Last(
			String screenName,
			OrderByComparator<DgfUsersFortnightReportCForm> orderByComparator) {

		return getPersistence().fetchByForthnightReportCFormByScreenName_Last(
			screenName, orderByComparator);
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
	public static DgfUsersFortnightReportCForm[]
			findByForthnightReportCFormByScreenName_PrevAndNext(
				long reportId, String screenName,
				OrderByComparator<DgfUsersFortnightReportCForm>
					orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersFortnightReportCFormException {

		return getPersistence().
			findByForthnightReportCFormByScreenName_PrevAndNext(
				reportId, screenName, orderByComparator);
	}

	/**
	 * Returns all the dgf users fortnight report c forms that the user has permission to view where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the matching dgf users fortnight report c forms that the user has permission to view
	 */
	public static List<DgfUsersFortnightReportCForm>
		filterFindByForthnightReportCFormByScreenName(String screenName) {

		return getPersistence().filterFindByForthnightReportCFormByScreenName(
			screenName);
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
	public static List<DgfUsersFortnightReportCForm>
		filterFindByForthnightReportCFormByScreenName(
			String screenName, int start, int end) {

		return getPersistence().filterFindByForthnightReportCFormByScreenName(
			screenName, start, end);
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
	public static List<DgfUsersFortnightReportCForm>
		filterFindByForthnightReportCFormByScreenName(
			String screenName, int start, int end,
			OrderByComparator<DgfUsersFortnightReportCForm> orderByComparator) {

		return getPersistence().filterFindByForthnightReportCFormByScreenName(
			screenName, start, end, orderByComparator);
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
	public static DgfUsersFortnightReportCForm[]
			filterFindByForthnightReportCFormByScreenName_PrevAndNext(
				long reportId, String screenName,
				OrderByComparator<DgfUsersFortnightReportCForm>
					orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersFortnightReportCFormException {

		return getPersistence().
			filterFindByForthnightReportCFormByScreenName_PrevAndNext(
				reportId, screenName, orderByComparator);
	}

	/**
	 * Removes all the dgf users fortnight report c forms where screenName = &#63; from the database.
	 *
	 * @param screenName the screen name
	 */
	public static void removeByForthnightReportCFormByScreenName(
		String screenName) {

		getPersistence().removeByForthnightReportCFormByScreenName(screenName);
	}

	/**
	 * Returns the number of dgf users fortnight report c forms where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the number of matching dgf users fortnight report c forms
	 */
	public static int countByForthnightReportCFormByScreenName(
		String screenName) {

		return getPersistence().countByForthnightReportCFormByScreenName(
			screenName);
	}

	/**
	 * Returns the number of dgf users fortnight report c forms that the user has permission to view where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the number of matching dgf users fortnight report c forms that the user has permission to view
	 */
	public static int filterCountByForthnightReportCFormByScreenName(
		String screenName) {

		return getPersistence().filterCountByForthnightReportCFormByScreenName(
			screenName);
	}

	/**
	 * Returns the dgf users fortnight report c form where usernationalId = &#63; and licenseNo = &#63; or throws a <code>NoSuchDgfUsersFortnightReportCFormException</code> if it could not be found.
	 *
	 * @param usernationalId the usernational ID
	 * @param licenseNo the license no
	 * @return the matching dgf users fortnight report c form
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a matching dgf users fortnight report c form could not be found
	 */
	public static DgfUsersFortnightReportCForm
			findByFortnightReportCFormByNIDandLicenseNo(
				String usernationalId, String licenseNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersFortnightReportCFormException {

		return getPersistence().findByFortnightReportCFormByNIDandLicenseNo(
			usernationalId, licenseNo);
	}

	/**
	 * Returns the dgf users fortnight report c form where usernationalId = &#63; and licenseNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param usernationalId the usernational ID
	 * @param licenseNo the license no
	 * @return the matching dgf users fortnight report c form, or <code>null</code> if a matching dgf users fortnight report c form could not be found
	 */
	public static DgfUsersFortnightReportCForm
		fetchByFortnightReportCFormByNIDandLicenseNo(
			String usernationalId, String licenseNo) {

		return getPersistence().fetchByFortnightReportCFormByNIDandLicenseNo(
			usernationalId, licenseNo);
	}

	/**
	 * Returns the dgf users fortnight report c form where usernationalId = &#63; and licenseNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param usernationalId the usernational ID
	 * @param licenseNo the license no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf users fortnight report c form, or <code>null</code> if a matching dgf users fortnight report c form could not be found
	 */
	public static DgfUsersFortnightReportCForm
		fetchByFortnightReportCFormByNIDandLicenseNo(
			String usernationalId, String licenseNo, boolean useFinderCache) {

		return getPersistence().fetchByFortnightReportCFormByNIDandLicenseNo(
			usernationalId, licenseNo, useFinderCache);
	}

	/**
	 * Removes the dgf users fortnight report c form where usernationalId = &#63; and licenseNo = &#63; from the database.
	 *
	 * @param usernationalId the usernational ID
	 * @param licenseNo the license no
	 * @return the dgf users fortnight report c form that was removed
	 */
	public static DgfUsersFortnightReportCForm
			removeByFortnightReportCFormByNIDandLicenseNo(
				String usernationalId, String licenseNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersFortnightReportCFormException {

		return getPersistence().removeByFortnightReportCFormByNIDandLicenseNo(
			usernationalId, licenseNo);
	}

	/**
	 * Returns the number of dgf users fortnight report c forms where usernationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param usernationalId the usernational ID
	 * @param licenseNo the license no
	 * @return the number of matching dgf users fortnight report c forms
	 */
	public static int countByFortnightReportCFormByNIDandLicenseNo(
		String usernationalId, String licenseNo) {

		return getPersistence().countByFortnightReportCFormByNIDandLicenseNo(
			usernationalId, licenseNo);
	}

	/**
	 * Caches the dgf users fortnight report c form in the entity cache if it is enabled.
	 *
	 * @param dgfUsersFortnightReportCForm the dgf users fortnight report c form
	 */
	public static void cacheResult(
		DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm) {

		getPersistence().cacheResult(dgfUsersFortnightReportCForm);
	}

	/**
	 * Caches the dgf users fortnight report c forms in the entity cache if it is enabled.
	 *
	 * @param dgfUsersFortnightReportCForms the dgf users fortnight report c forms
	 */
	public static void cacheResult(
		List<DgfUsersFortnightReportCForm> dgfUsersFortnightReportCForms) {

		getPersistence().cacheResult(dgfUsersFortnightReportCForms);
	}

	/**
	 * Creates a new dgf users fortnight report c form with the primary key. Does not add the dgf users fortnight report c form to the database.
	 *
	 * @param reportId the primary key for the new dgf users fortnight report c form
	 * @return the new dgf users fortnight report c form
	 */
	public static DgfUsersFortnightReportCForm create(long reportId) {
		return getPersistence().create(reportId);
	}

	/**
	 * Removes the dgf users fortnight report c form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param reportId the primary key of the dgf users fortnight report c form
	 * @return the dgf users fortnight report c form that was removed
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a dgf users fortnight report c form with the primary key could not be found
	 */
	public static DgfUsersFortnightReportCForm remove(long reportId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersFortnightReportCFormException {

		return getPersistence().remove(reportId);
	}

	public static DgfUsersFortnightReportCForm updateImpl(
		DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm) {

		return getPersistence().updateImpl(dgfUsersFortnightReportCForm);
	}

	/**
	 * Returns the dgf users fortnight report c form with the primary key or throws a <code>NoSuchDgfUsersFortnightReportCFormException</code> if it could not be found.
	 *
	 * @param reportId the primary key of the dgf users fortnight report c form
	 * @return the dgf users fortnight report c form
	 * @throws NoSuchDgfUsersFortnightReportCFormException if a dgf users fortnight report c form with the primary key could not be found
	 */
	public static DgfUsersFortnightReportCForm findByPrimaryKey(long reportId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersFortnightReportCFormException {

		return getPersistence().findByPrimaryKey(reportId);
	}

	/**
	 * Returns the dgf users fortnight report c form with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param reportId the primary key of the dgf users fortnight report c form
	 * @return the dgf users fortnight report c form, or <code>null</code> if a dgf users fortnight report c form with the primary key could not be found
	 */
	public static DgfUsersFortnightReportCForm fetchByPrimaryKey(
		long reportId) {

		return getPersistence().fetchByPrimaryKey(reportId);
	}

	/**
	 * Returns all the dgf users fortnight report c forms.
	 *
	 * @return the dgf users fortnight report c forms
	 */
	public static List<DgfUsersFortnightReportCForm> findAll() {
		return getPersistence().findAll();
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
	public static List<DgfUsersFortnightReportCForm> findAll(
		int start, int end) {

		return getPersistence().findAll(start, end);
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
	public static List<DgfUsersFortnightReportCForm> findAll(
		int start, int end,
		OrderByComparator<DgfUsersFortnightReportCForm> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<DgfUsersFortnightReportCForm> findAll(
		int start, int end,
		OrderByComparator<DgfUsersFortnightReportCForm> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dgf users fortnight report c forms from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dgf users fortnight report c forms.
	 *
	 * @return the number of dgf users fortnight report c forms
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DgfUsersFortnightReportCFormPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DgfUsersFortnightReportCFormPersistence
		_persistence;

}