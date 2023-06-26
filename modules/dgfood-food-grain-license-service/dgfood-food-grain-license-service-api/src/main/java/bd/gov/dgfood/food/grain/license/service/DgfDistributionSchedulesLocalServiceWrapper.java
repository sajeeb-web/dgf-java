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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DgfDistributionSchedulesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDistributionSchedulesLocalService
 * @generated
 */
public class DgfDistributionSchedulesLocalServiceWrapper
	implements DgfDistributionSchedulesLocalService,
			   ServiceWrapper<DgfDistributionSchedulesLocalService> {

	public DgfDistributionSchedulesLocalServiceWrapper() {
		this(null);
	}

	public DgfDistributionSchedulesLocalServiceWrapper(
		DgfDistributionSchedulesLocalService
			dgfDistributionSchedulesLocalService) {

		_dgfDistributionSchedulesLocalService =
			dgfDistributionSchedulesLocalService;
	}

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
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfDistributionSchedules
		addDgfDistributionSchedules(
			bd.gov.dgfood.food.grain.license.model.DgfDistributionSchedules
				dgfDistributionSchedules) {

		return _dgfDistributionSchedulesLocalService.
			addDgfDistributionSchedules(dgfDistributionSchedules);
	}

	/**
	 * Creates a new dgf distribution schedules with the primary key. Does not add the dgf distribution schedules to the database.
	 *
	 * @param id the primary key for the new dgf distribution schedules
	 * @return the new dgf distribution schedules
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfDistributionSchedules
		createDgfDistributionSchedules(String id) {

		return _dgfDistributionSchedulesLocalService.
			createDgfDistributionSchedules(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDistributionSchedulesLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfDistributionSchedules
		deleteDgfDistributionSchedules(
			bd.gov.dgfood.food.grain.license.model.DgfDistributionSchedules
				dgfDistributionSchedules) {

		return _dgfDistributionSchedulesLocalService.
			deleteDgfDistributionSchedules(dgfDistributionSchedules);
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
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfDistributionSchedules
			deleteDgfDistributionSchedules(String id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDistributionSchedulesLocalService.
			deleteDgfDistributionSchedules(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDistributionSchedulesLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgfDistributionSchedulesLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgfDistributionSchedulesLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgfDistributionSchedulesLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _dgfDistributionSchedulesLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _dgfDistributionSchedulesLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _dgfDistributionSchedulesLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _dgfDistributionSchedulesLocalService.dynamicQueryCount(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _dgfDistributionSchedulesLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfDistributionSchedules
		fetchDgfDistributionSchedules(String id) {

		return _dgfDistributionSchedulesLocalService.
			fetchDgfDistributionSchedules(id);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfDistributionSchedules
			findDgfDistributionSchedulesByMonthAndYear(
				long distributionYear, String distributionMonth)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDistributionSchedulesException {

		return _dgfDistributionSchedulesLocalService.
			findDgfDistributionSchedulesByMonthAndYear(
				distributionYear, distributionMonth);
	}

	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.DgfDistributionSchedules>
				findDgfDistributionSchedulesByOpenStatus(String openStatus)
			throws bd.gov.dgfood.food.grain.license.exception.
				NoSuchDgfDistributionSchedulesException {

		return _dgfDistributionSchedulesLocalService.
			findDgfDistributionSchedulesByOpenStatus(openStatus);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfDistributionSchedules
			findDgfDistributionSchedulesByStartDateAndEndDate(
				java.util.Date startDate, java.util.Date endDate)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDistributionSchedulesException {

		return _dgfDistributionSchedulesLocalService.
			findDgfDistributionSchedulesByStartDateAndEndDate(
				startDate, endDate);
	}

	/**
	 * Returns the dgf distribution schedules with the primary key.
	 *
	 * @param id the primary key of the dgf distribution schedules
	 * @return the dgf distribution schedules
	 * @throws PortalException if a dgf distribution schedules with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfDistributionSchedules
			getDgfDistributionSchedules(String id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDistributionSchedulesLocalService.
			getDgfDistributionSchedules(id);
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
	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.DgfDistributionSchedules>
			getDgfDistributionScheduleses(int start, int end) {

		return _dgfDistributionSchedulesLocalService.
			getDgfDistributionScheduleses(start, end);
	}

	/**
	 * Returns the number of dgf distribution scheduleses.
	 *
	 * @return the number of dgf distribution scheduleses
	 */
	@Override
	public int getDgfDistributionSchedulesesCount() {
		return _dgfDistributionSchedulesLocalService.
			getDgfDistributionSchedulesesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfDistributionSchedulesLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDistributionSchedulesLocalService.getPersistedModel(
			primaryKeyObj);
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
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfDistributionSchedules
		updateDgfDistributionSchedules(
			bd.gov.dgfood.food.grain.license.model.DgfDistributionSchedules
				dgfDistributionSchedules) {

		return _dgfDistributionSchedulesLocalService.
			updateDgfDistributionSchedules(dgfDistributionSchedules);
	}

	@Override
	public DgfDistributionSchedulesLocalService getWrappedService() {
		return _dgfDistributionSchedulesLocalService;
	}

	@Override
	public void setWrappedService(
		DgfDistributionSchedulesLocalService
			dgfDistributionSchedulesLocalService) {

		_dgfDistributionSchedulesLocalService =
			dgfDistributionSchedulesLocalService;
	}

	private DgfDistributionSchedulesLocalService
		_dgfDistributionSchedulesLocalService;

}