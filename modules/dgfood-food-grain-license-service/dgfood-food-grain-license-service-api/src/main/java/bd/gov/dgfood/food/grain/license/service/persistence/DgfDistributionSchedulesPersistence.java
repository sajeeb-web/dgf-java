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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfDistributionSchedulesException;
import bd.gov.dgfood.food.grain.license.model.DgfDistributionSchedules;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dgf distribution schedules service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfDistributionSchedulesUtil
 * @generated
 */
@ProviderType
public interface DgfDistributionSchedulesPersistence
	extends BasePersistence<DgfDistributionSchedules> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DgfDistributionSchedulesUtil} to access the dgf distribution schedules persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the dgf distribution schedules where distributionYear = &#63; and distributionMonth = &#63; or throws a <code>NoSuchDgfDistributionSchedulesException</code> if it could not be found.
	 *
	 * @param distributionYear the distribution year
	 * @param distributionMonth the distribution month
	 * @return the matching dgf distribution schedules
	 * @throws NoSuchDgfDistributionSchedulesException if a matching dgf distribution schedules could not be found
	 */
	public DgfDistributionSchedules findByDistributionMonthAndYear(
			long distributionYear, String distributionMonth)
		throws NoSuchDgfDistributionSchedulesException;

	/**
	 * Returns the dgf distribution schedules where distributionYear = &#63; and distributionMonth = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param distributionYear the distribution year
	 * @param distributionMonth the distribution month
	 * @return the matching dgf distribution schedules, or <code>null</code> if a matching dgf distribution schedules could not be found
	 */
	public DgfDistributionSchedules fetchByDistributionMonthAndYear(
		long distributionYear, String distributionMonth);

	/**
	 * Returns the dgf distribution schedules where distributionYear = &#63; and distributionMonth = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param distributionYear the distribution year
	 * @param distributionMonth the distribution month
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf distribution schedules, or <code>null</code> if a matching dgf distribution schedules could not be found
	 */
	public DgfDistributionSchedules fetchByDistributionMonthAndYear(
		long distributionYear, String distributionMonth,
		boolean useFinderCache);

	/**
	 * Removes the dgf distribution schedules where distributionYear = &#63; and distributionMonth = &#63; from the database.
	 *
	 * @param distributionYear the distribution year
	 * @param distributionMonth the distribution month
	 * @return the dgf distribution schedules that was removed
	 */
	public DgfDistributionSchedules removeByDistributionMonthAndYear(
			long distributionYear, String distributionMonth)
		throws NoSuchDgfDistributionSchedulesException;

	/**
	 * Returns the number of dgf distribution scheduleses where distributionYear = &#63; and distributionMonth = &#63;.
	 *
	 * @param distributionYear the distribution year
	 * @param distributionMonth the distribution month
	 * @return the number of matching dgf distribution scheduleses
	 */
	public int countByDistributionMonthAndYear(
		long distributionYear, String distributionMonth);

	/**
	 * Returns all the dgf distribution scheduleses where openStatus = &#63;.
	 *
	 * @param openStatus the open status
	 * @return the matching dgf distribution scheduleses
	 */
	public java.util.List<DgfDistributionSchedules> findByOpenStatus(
		String openStatus);

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
	public java.util.List<DgfDistributionSchedules> findByOpenStatus(
		String openStatus, int start, int end);

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
	public java.util.List<DgfDistributionSchedules> findByOpenStatus(
		String openStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DgfDistributionSchedules> orderByComparator);

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
	public java.util.List<DgfDistributionSchedules> findByOpenStatus(
		String openStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DgfDistributionSchedules> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dgf distribution schedules in the ordered set where openStatus = &#63;.
	 *
	 * @param openStatus the open status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf distribution schedules
	 * @throws NoSuchDgfDistributionSchedulesException if a matching dgf distribution schedules could not be found
	 */
	public DgfDistributionSchedules findByOpenStatus_First(
			String openStatus,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfDistributionSchedules> orderByComparator)
		throws NoSuchDgfDistributionSchedulesException;

	/**
	 * Returns the first dgf distribution schedules in the ordered set where openStatus = &#63;.
	 *
	 * @param openStatus the open status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf distribution schedules, or <code>null</code> if a matching dgf distribution schedules could not be found
	 */
	public DgfDistributionSchedules fetchByOpenStatus_First(
		String openStatus,
		com.liferay.portal.kernel.util.OrderByComparator
			<DgfDistributionSchedules> orderByComparator);

	/**
	 * Returns the last dgf distribution schedules in the ordered set where openStatus = &#63;.
	 *
	 * @param openStatus the open status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf distribution schedules
	 * @throws NoSuchDgfDistributionSchedulesException if a matching dgf distribution schedules could not be found
	 */
	public DgfDistributionSchedules findByOpenStatus_Last(
			String openStatus,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfDistributionSchedules> orderByComparator)
		throws NoSuchDgfDistributionSchedulesException;

	/**
	 * Returns the last dgf distribution schedules in the ordered set where openStatus = &#63;.
	 *
	 * @param openStatus the open status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf distribution schedules, or <code>null</code> if a matching dgf distribution schedules could not be found
	 */
	public DgfDistributionSchedules fetchByOpenStatus_Last(
		String openStatus,
		com.liferay.portal.kernel.util.OrderByComparator
			<DgfDistributionSchedules> orderByComparator);

	/**
	 * Returns the dgf distribution scheduleses before and after the current dgf distribution schedules in the ordered set where openStatus = &#63;.
	 *
	 * @param id the primary key of the current dgf distribution schedules
	 * @param openStatus the open status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf distribution schedules
	 * @throws NoSuchDgfDistributionSchedulesException if a dgf distribution schedules with the primary key could not be found
	 */
	public DgfDistributionSchedules[] findByOpenStatus_PrevAndNext(
			String id, String openStatus,
			com.liferay.portal.kernel.util.OrderByComparator
				<DgfDistributionSchedules> orderByComparator)
		throws NoSuchDgfDistributionSchedulesException;

	/**
	 * Removes all the dgf distribution scheduleses where openStatus = &#63; from the database.
	 *
	 * @param openStatus the open status
	 */
	public void removeByOpenStatus(String openStatus);

	/**
	 * Returns the number of dgf distribution scheduleses where openStatus = &#63;.
	 *
	 * @param openStatus the open status
	 * @return the number of matching dgf distribution scheduleses
	 */
	public int countByOpenStatus(String openStatus);

	/**
	 * Returns the dgf distribution schedules where startDate = &#63; and endDate = &#63; or throws a <code>NoSuchDgfDistributionSchedulesException</code> if it could not be found.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the matching dgf distribution schedules
	 * @throws NoSuchDgfDistributionSchedulesException if a matching dgf distribution schedules could not be found
	 */
	public DgfDistributionSchedules findByStartDateAndEndDate(
			Date startDate, Date endDate)
		throws NoSuchDgfDistributionSchedulesException;

	/**
	 * Returns the dgf distribution schedules where startDate = &#63; and endDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the matching dgf distribution schedules, or <code>null</code> if a matching dgf distribution schedules could not be found
	 */
	public DgfDistributionSchedules fetchByStartDateAndEndDate(
		Date startDate, Date endDate);

	/**
	 * Returns the dgf distribution schedules where startDate = &#63; and endDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf distribution schedules, or <code>null</code> if a matching dgf distribution schedules could not be found
	 */
	public DgfDistributionSchedules fetchByStartDateAndEndDate(
		Date startDate, Date endDate, boolean useFinderCache);

	/**
	 * Removes the dgf distribution schedules where startDate = &#63; and endDate = &#63; from the database.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the dgf distribution schedules that was removed
	 */
	public DgfDistributionSchedules removeByStartDateAndEndDate(
			Date startDate, Date endDate)
		throws NoSuchDgfDistributionSchedulesException;

	/**
	 * Returns the number of dgf distribution scheduleses where startDate = &#63; and endDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the number of matching dgf distribution scheduleses
	 */
	public int countByStartDateAndEndDate(Date startDate, Date endDate);

	/**
	 * Caches the dgf distribution schedules in the entity cache if it is enabled.
	 *
	 * @param dgfDistributionSchedules the dgf distribution schedules
	 */
	public void cacheResult(DgfDistributionSchedules dgfDistributionSchedules);

	/**
	 * Caches the dgf distribution scheduleses in the entity cache if it is enabled.
	 *
	 * @param dgfDistributionScheduleses the dgf distribution scheduleses
	 */
	public void cacheResult(
		java.util.List<DgfDistributionSchedules> dgfDistributionScheduleses);

	/**
	 * Creates a new dgf distribution schedules with the primary key. Does not add the dgf distribution schedules to the database.
	 *
	 * @param id the primary key for the new dgf distribution schedules
	 * @return the new dgf distribution schedules
	 */
	public DgfDistributionSchedules create(String id);

	/**
	 * Removes the dgf distribution schedules with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dgf distribution schedules
	 * @return the dgf distribution schedules that was removed
	 * @throws NoSuchDgfDistributionSchedulesException if a dgf distribution schedules with the primary key could not be found
	 */
	public DgfDistributionSchedules remove(String id)
		throws NoSuchDgfDistributionSchedulesException;

	public DgfDistributionSchedules updateImpl(
		DgfDistributionSchedules dgfDistributionSchedules);

	/**
	 * Returns the dgf distribution schedules with the primary key or throws a <code>NoSuchDgfDistributionSchedulesException</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf distribution schedules
	 * @return the dgf distribution schedules
	 * @throws NoSuchDgfDistributionSchedulesException if a dgf distribution schedules with the primary key could not be found
	 */
	public DgfDistributionSchedules findByPrimaryKey(String id)
		throws NoSuchDgfDistributionSchedulesException;

	/**
	 * Returns the dgf distribution schedules with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dgf distribution schedules
	 * @return the dgf distribution schedules, or <code>null</code> if a dgf distribution schedules with the primary key could not be found
	 */
	public DgfDistributionSchedules fetchByPrimaryKey(String id);

	/**
	 * Returns all the dgf distribution scheduleses.
	 *
	 * @return the dgf distribution scheduleses
	 */
	public java.util.List<DgfDistributionSchedules> findAll();

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
	public java.util.List<DgfDistributionSchedules> findAll(int start, int end);

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
	public java.util.List<DgfDistributionSchedules> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DgfDistributionSchedules> orderByComparator);

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
	public java.util.List<DgfDistributionSchedules> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<DgfDistributionSchedules> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dgf distribution scheduleses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dgf distribution scheduleses.
	 *
	 * @return the number of dgf distribution scheduleses
	 */
	public int countAll();

}