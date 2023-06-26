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

import bd.gov.dgfood.food.grain.license.model.DgfDistributionSchedules;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dgf distribution schedules service. This utility wraps <code>bd.gov.dgfood.food.grain.license.service.persistence.impl.DgfDistributionSchedulesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfDistributionSchedulesPersistence
 * @generated
 */
public class DgfDistributionSchedulesUtil {

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
		DgfDistributionSchedules dgfDistributionSchedules) {

		getPersistence().clearCache(dgfDistributionSchedules);
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
	public static Map<Serializable, DgfDistributionSchedules>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DgfDistributionSchedules> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DgfDistributionSchedules> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DgfDistributionSchedules> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DgfDistributionSchedules> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DgfDistributionSchedules update(
		DgfDistributionSchedules dgfDistributionSchedules) {

		return getPersistence().update(dgfDistributionSchedules);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DgfDistributionSchedules update(
		DgfDistributionSchedules dgfDistributionSchedules,
		ServiceContext serviceContext) {

		return getPersistence().update(
			dgfDistributionSchedules, serviceContext);
	}

	/**
	 * Returns the dgf distribution schedules where distributionYear = &#63; and distributionMonth = &#63; or throws a <code>NoSuchDgfDistributionSchedulesException</code> if it could not be found.
	 *
	 * @param distributionYear the distribution year
	 * @param distributionMonth the distribution month
	 * @return the matching dgf distribution schedules
	 * @throws NoSuchDgfDistributionSchedulesException if a matching dgf distribution schedules could not be found
	 */
	public static DgfDistributionSchedules findByDistributionMonthAndYear(
			long distributionYear, String distributionMonth)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDistributionSchedulesException {

		return getPersistence().findByDistributionMonthAndYear(
			distributionYear, distributionMonth);
	}

	/**
	 * Returns the dgf distribution schedules where distributionYear = &#63; and distributionMonth = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param distributionYear the distribution year
	 * @param distributionMonth the distribution month
	 * @return the matching dgf distribution schedules, or <code>null</code> if a matching dgf distribution schedules could not be found
	 */
	public static DgfDistributionSchedules fetchByDistributionMonthAndYear(
		long distributionYear, String distributionMonth) {

		return getPersistence().fetchByDistributionMonthAndYear(
			distributionYear, distributionMonth);
	}

	/**
	 * Returns the dgf distribution schedules where distributionYear = &#63; and distributionMonth = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param distributionYear the distribution year
	 * @param distributionMonth the distribution month
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf distribution schedules, or <code>null</code> if a matching dgf distribution schedules could not be found
	 */
	public static DgfDistributionSchedules fetchByDistributionMonthAndYear(
		long distributionYear, String distributionMonth,
		boolean useFinderCache) {

		return getPersistence().fetchByDistributionMonthAndYear(
			distributionYear, distributionMonth, useFinderCache);
	}

	/**
	 * Removes the dgf distribution schedules where distributionYear = &#63; and distributionMonth = &#63; from the database.
	 *
	 * @param distributionYear the distribution year
	 * @param distributionMonth the distribution month
	 * @return the dgf distribution schedules that was removed
	 */
	public static DgfDistributionSchedules removeByDistributionMonthAndYear(
			long distributionYear, String distributionMonth)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDistributionSchedulesException {

		return getPersistence().removeByDistributionMonthAndYear(
			distributionYear, distributionMonth);
	}

	/**
	 * Returns the number of dgf distribution scheduleses where distributionYear = &#63; and distributionMonth = &#63;.
	 *
	 * @param distributionYear the distribution year
	 * @param distributionMonth the distribution month
	 * @return the number of matching dgf distribution scheduleses
	 */
	public static int countByDistributionMonthAndYear(
		long distributionYear, String distributionMonth) {

		return getPersistence().countByDistributionMonthAndYear(
			distributionYear, distributionMonth);
	}

	/**
	 * Returns all the dgf distribution scheduleses where openStatus = &#63;.
	 *
	 * @param openStatus the open status
	 * @return the matching dgf distribution scheduleses
	 */
	public static List<DgfDistributionSchedules> findByOpenStatus(
		String openStatus) {

		return getPersistence().findByOpenStatus(openStatus);
	}

	/**
	 * Returns a range of all the dgf distribution scheduleses where openStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDistributionSchedulesModelImpl</code>.
	 * </p>
	 *
	 * @param openStatus the open status
	 * @param start the lower bound of the range of dgf distribution scheduleses
	 * @param end the upper bound of the range of dgf distribution scheduleses (not inclusive)
	 * @return the range of matching dgf distribution scheduleses
	 */
	public static List<DgfDistributionSchedules> findByOpenStatus(
		String openStatus, int start, int end) {

		return getPersistence().findByOpenStatus(openStatus, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf distribution scheduleses where openStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDistributionSchedulesModelImpl</code>.
	 * </p>
	 *
	 * @param openStatus the open status
	 * @param start the lower bound of the range of dgf distribution scheduleses
	 * @param end the upper bound of the range of dgf distribution scheduleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf distribution scheduleses
	 */
	public static List<DgfDistributionSchedules> findByOpenStatus(
		String openStatus, int start, int end,
		OrderByComparator<DgfDistributionSchedules> orderByComparator) {

		return getPersistence().findByOpenStatus(
			openStatus, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf distribution scheduleses where openStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDistributionSchedulesModelImpl</code>.
	 * </p>
	 *
	 * @param openStatus the open status
	 * @param start the lower bound of the range of dgf distribution scheduleses
	 * @param end the upper bound of the range of dgf distribution scheduleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf distribution scheduleses
	 */
	public static List<DgfDistributionSchedules> findByOpenStatus(
		String openStatus, int start, int end,
		OrderByComparator<DgfDistributionSchedules> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByOpenStatus(
			openStatus, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf distribution schedules in the ordered set where openStatus = &#63;.
	 *
	 * @param openStatus the open status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf distribution schedules
	 * @throws NoSuchDgfDistributionSchedulesException if a matching dgf distribution schedules could not be found
	 */
	public static DgfDistributionSchedules findByOpenStatus_First(
			String openStatus,
			OrderByComparator<DgfDistributionSchedules> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDistributionSchedulesException {

		return getPersistence().findByOpenStatus_First(
			openStatus, orderByComparator);
	}

	/**
	 * Returns the first dgf distribution schedules in the ordered set where openStatus = &#63;.
	 *
	 * @param openStatus the open status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf distribution schedules, or <code>null</code> if a matching dgf distribution schedules could not be found
	 */
	public static DgfDistributionSchedules fetchByOpenStatus_First(
		String openStatus,
		OrderByComparator<DgfDistributionSchedules> orderByComparator) {

		return getPersistence().fetchByOpenStatus_First(
			openStatus, orderByComparator);
	}

	/**
	 * Returns the last dgf distribution schedules in the ordered set where openStatus = &#63;.
	 *
	 * @param openStatus the open status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf distribution schedules
	 * @throws NoSuchDgfDistributionSchedulesException if a matching dgf distribution schedules could not be found
	 */
	public static DgfDistributionSchedules findByOpenStatus_Last(
			String openStatus,
			OrderByComparator<DgfDistributionSchedules> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDistributionSchedulesException {

		return getPersistence().findByOpenStatus_Last(
			openStatus, orderByComparator);
	}

	/**
	 * Returns the last dgf distribution schedules in the ordered set where openStatus = &#63;.
	 *
	 * @param openStatus the open status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf distribution schedules, or <code>null</code> if a matching dgf distribution schedules could not be found
	 */
	public static DgfDistributionSchedules fetchByOpenStatus_Last(
		String openStatus,
		OrderByComparator<DgfDistributionSchedules> orderByComparator) {

		return getPersistence().fetchByOpenStatus_Last(
			openStatus, orderByComparator);
	}

	/**
	 * Returns the dgf distribution scheduleses before and after the current dgf distribution schedules in the ordered set where openStatus = &#63;.
	 *
	 * @param id the primary key of the current dgf distribution schedules
	 * @param openStatus the open status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf distribution schedules
	 * @throws NoSuchDgfDistributionSchedulesException if a dgf distribution schedules with the primary key could not be found
	 */
	public static DgfDistributionSchedules[] findByOpenStatus_PrevAndNext(
			String id, String openStatus,
			OrderByComparator<DgfDistributionSchedules> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDistributionSchedulesException {

		return getPersistence().findByOpenStatus_PrevAndNext(
			id, openStatus, orderByComparator);
	}

	/**
	 * Removes all the dgf distribution scheduleses where openStatus = &#63; from the database.
	 *
	 * @param openStatus the open status
	 */
	public static void removeByOpenStatus(String openStatus) {
		getPersistence().removeByOpenStatus(openStatus);
	}

	/**
	 * Returns the number of dgf distribution scheduleses where openStatus = &#63;.
	 *
	 * @param openStatus the open status
	 * @return the number of matching dgf distribution scheduleses
	 */
	public static int countByOpenStatus(String openStatus) {
		return getPersistence().countByOpenStatus(openStatus);
	}

	/**
	 * Returns the dgf distribution schedules where startDate = &#63; and endDate = &#63; or throws a <code>NoSuchDgfDistributionSchedulesException</code> if it could not be found.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the matching dgf distribution schedules
	 * @throws NoSuchDgfDistributionSchedulesException if a matching dgf distribution schedules could not be found
	 */
	public static DgfDistributionSchedules findByStartDateAndEndDate(
			Date startDate, Date endDate)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDistributionSchedulesException {

		return getPersistence().findByStartDateAndEndDate(startDate, endDate);
	}

	/**
	 * Returns the dgf distribution schedules where startDate = &#63; and endDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the matching dgf distribution schedules, or <code>null</code> if a matching dgf distribution schedules could not be found
	 */
	public static DgfDistributionSchedules fetchByStartDateAndEndDate(
		Date startDate, Date endDate) {

		return getPersistence().fetchByStartDateAndEndDate(startDate, endDate);
	}

	/**
	 * Returns the dgf distribution schedules where startDate = &#63; and endDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf distribution schedules, or <code>null</code> if a matching dgf distribution schedules could not be found
	 */
	public static DgfDistributionSchedules fetchByStartDateAndEndDate(
		Date startDate, Date endDate, boolean useFinderCache) {

		return getPersistence().fetchByStartDateAndEndDate(
			startDate, endDate, useFinderCache);
	}

	/**
	 * Removes the dgf distribution schedules where startDate = &#63; and endDate = &#63; from the database.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the dgf distribution schedules that was removed
	 */
	public static DgfDistributionSchedules removeByStartDateAndEndDate(
			Date startDate, Date endDate)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDistributionSchedulesException {

		return getPersistence().removeByStartDateAndEndDate(startDate, endDate);
	}

	/**
	 * Returns the number of dgf distribution scheduleses where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the number of matching dgf distribution scheduleses
	 */
	public static int countByStartDateAndEndDate(Date startDate, Date endDate) {
		return getPersistence().countByStartDateAndEndDate(startDate, endDate);
	}

	/**
	 * Caches the dgf distribution schedules in the entity cache if it is enabled.
	 *
	 * @param dgfDistributionSchedules the dgf distribution schedules
	 */
	public static void cacheResult(
		DgfDistributionSchedules dgfDistributionSchedules) {

		getPersistence().cacheResult(dgfDistributionSchedules);
	}

	/**
	 * Caches the dgf distribution scheduleses in the entity cache if it is enabled.
	 *
	 * @param dgfDistributionScheduleses the dgf distribution scheduleses
	 */
	public static void cacheResult(
		List<DgfDistributionSchedules> dgfDistributionScheduleses) {

		getPersistence().cacheResult(dgfDistributionScheduleses);
	}

	/**
	 * Creates a new dgf distribution schedules with the primary key. Does not add the dgf distribution schedules to the database.
	 *
	 * @param id the primary key for the new dgf distribution schedules
	 * @return the new dgf distribution schedules
	 */
	public static DgfDistributionSchedules create(String id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the dgf distribution schedules with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dgf distribution schedules
	 * @return the dgf distribution schedules that was removed
	 * @throws NoSuchDgfDistributionSchedulesException if a dgf distribution schedules with the primary key could not be found
	 */
	public static DgfDistributionSchedules remove(String id)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDistributionSchedulesException {

		return getPersistence().remove(id);
	}

	public static DgfDistributionSchedules updateImpl(
		DgfDistributionSchedules dgfDistributionSchedules) {

		return getPersistence().updateImpl(dgfDistributionSchedules);
	}

	/**
	 * Returns the dgf distribution schedules with the primary key or throws a <code>NoSuchDgfDistributionSchedulesException</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf distribution schedules
	 * @return the dgf distribution schedules
	 * @throws NoSuchDgfDistributionSchedulesException if a dgf distribution schedules with the primary key could not be found
	 */
	public static DgfDistributionSchedules findByPrimaryKey(String id)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDistributionSchedulesException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the dgf distribution schedules with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf distribution schedules
	 * @return the dgf distribution schedules, or <code>null</code> if a dgf distribution schedules with the primary key could not be found
	 */
	public static DgfDistributionSchedules fetchByPrimaryKey(String id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the dgf distribution scheduleses.
	 *
	 * @return the dgf distribution scheduleses
	 */
	public static List<DgfDistributionSchedules> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dgf distribution scheduleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDistributionSchedulesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf distribution scheduleses
	 * @param end the upper bound of the range of dgf distribution scheduleses (not inclusive)
	 * @return the range of dgf distribution scheduleses
	 */
	public static List<DgfDistributionSchedules> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dgf distribution scheduleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDistributionSchedulesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf distribution scheduleses
	 * @param end the upper bound of the range of dgf distribution scheduleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf distribution scheduleses
	 */
	public static List<DgfDistributionSchedules> findAll(
		int start, int end,
		OrderByComparator<DgfDistributionSchedules> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf distribution scheduleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDistributionSchedulesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf distribution scheduleses
	 * @param end the upper bound of the range of dgf distribution scheduleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf distribution scheduleses
	 */
	public static List<DgfDistributionSchedules> findAll(
		int start, int end,
		OrderByComparator<DgfDistributionSchedules> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dgf distribution scheduleses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dgf distribution scheduleses.
	 *
	 * @return the number of dgf distribution scheduleses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DgfDistributionSchedulesPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DgfDistributionSchedulesPersistence _persistence;

}