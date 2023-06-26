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

package bd.gov.dgfood.food.grain.license.service;

import bd.gov.dgfood.food.grain.license.model.DgfDistributionSchedules;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DgfDistributionSchedules. This utility wraps
 * <code>bd.gov.dgfood.food.grain.license.service.impl.DgfDistributionSchedulesLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDistributionSchedulesLocalService
 * @generated
 */
public class DgfDistributionSchedulesLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>bd.gov.dgfood.food.grain.license.service.impl.DgfDistributionSchedulesLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the dgf distribution schedules to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDistributionSchedulesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDistributionSchedules the dgf distribution schedules
	 * @return the dgf distribution schedules that was added
	 */
	public static DgfDistributionSchedules addDgfDistributionSchedules(
		DgfDistributionSchedules dgfDistributionSchedules) {

		return getService().addDgfDistributionSchedules(
			dgfDistributionSchedules);
	}

	/**
	 * Creates a new dgf distribution schedules with the primary key. Does not add the dgf distribution schedules to the database.
	 *
	 * @param id the primary key for the new dgf distribution schedules
	 * @return the new dgf distribution schedules
	 */
	public static DgfDistributionSchedules createDgfDistributionSchedules(
		String id) {

		return getService().createDgfDistributionSchedules(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the dgf distribution schedules from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDistributionSchedulesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDistributionSchedules the dgf distribution schedules
	 * @return the dgf distribution schedules that was removed
	 */
	public static DgfDistributionSchedules deleteDgfDistributionSchedules(
		DgfDistributionSchedules dgfDistributionSchedules) {

		return getService().deleteDgfDistributionSchedules(
			dgfDistributionSchedules);
	}

	/**
	 * Deletes the dgf distribution schedules with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDistributionSchedulesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the dgf distribution schedules
	 * @return the dgf distribution schedules that was removed
	 * @throws PortalException if a dgf distribution schedules with the primary key could not be found
	 */
	public static DgfDistributionSchedules deleteDgfDistributionSchedules(
			String id)
		throws PortalException {

		return getService().deleteDgfDistributionSchedules(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfDistributionSchedulesModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfDistributionSchedulesModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static DgfDistributionSchedules fetchDgfDistributionSchedules(
		String id) {

		return getService().fetchDgfDistributionSchedules(id);
	}

	public static DgfDistributionSchedules
			findDgfDistributionSchedulesByMonthAndYear(
				long distributionYear, String distributionMonth)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDistributionSchedulesException {

		return getService().findDgfDistributionSchedulesByMonthAndYear(
			distributionYear, distributionMonth);
	}

	public static List<DgfDistributionSchedules>
			findDgfDistributionSchedulesByOpenStatus(String openStatus)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDistributionSchedulesException {

		return getService().findDgfDistributionSchedulesByOpenStatus(
			openStatus);
	}

	public static DgfDistributionSchedules
			findDgfDistributionSchedulesByStartDateAndEndDate(
				java.util.Date startDate, java.util.Date endDate)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDistributionSchedulesException {

		return getService().findDgfDistributionSchedulesByStartDateAndEndDate(
			startDate, endDate);
	}

	/**
	 * Returns the dgf distribution schedules with the primary key.
	 *
	 * @param id the primary key of the dgf distribution schedules
	 * @return the dgf distribution schedules
	 * @throws PortalException if a dgf distribution schedules with the primary key could not be found
	 */
	public static DgfDistributionSchedules getDgfDistributionSchedules(
			String id)
		throws PortalException {

		return getService().getDgfDistributionSchedules(id);
	}

	/**
	 * Returns a range of all the dgf distribution scheduleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfDistributionSchedulesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf distribution scheduleses
	 * @param end the upper bound of the range of dgf distribution scheduleses (not inclusive)
	 * @return the range of dgf distribution scheduleses
	 */
	public static List<DgfDistributionSchedules> getDgfDistributionScheduleses(
		int start, int end) {

		return getService().getDgfDistributionScheduleses(start, end);
	}

	/**
	 * Returns the number of dgf distribution scheduleses.
	 *
	 * @return the number of dgf distribution scheduleses
	 */
	public static int getDgfDistributionSchedulesesCount() {
		return getService().getDgfDistributionSchedulesesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the dgf distribution schedules in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDistributionSchedulesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDistributionSchedules the dgf distribution schedules
	 * @return the dgf distribution schedules that was updated
	 */
	public static DgfDistributionSchedules updateDgfDistributionSchedules(
		DgfDistributionSchedules dgfDistributionSchedules) {

		return getService().updateDgfDistributionSchedules(
			dgfDistributionSchedules);
	}

	public static DgfDistributionSchedulesLocalService getService() {
		return _service;
	}

	private static volatile DgfDistributionSchedulesLocalService _service;

}