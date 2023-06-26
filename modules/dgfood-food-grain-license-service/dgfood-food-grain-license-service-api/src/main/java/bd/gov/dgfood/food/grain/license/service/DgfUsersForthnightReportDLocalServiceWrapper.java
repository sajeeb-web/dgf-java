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
 * Provides a wrapper for {@link DgfUsersForthnightReportDLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersForthnightReportDLocalService
 * @generated
 */
public class DgfUsersForthnightReportDLocalServiceWrapper
	implements DgfUsersForthnightReportDLocalService,
			   ServiceWrapper<DgfUsersForthnightReportDLocalService> {

	public DgfUsersForthnightReportDLocalServiceWrapper() {
		this(null);
	}

	public DgfUsersForthnightReportDLocalServiceWrapper(
		DgfUsersForthnightReportDLocalService
			dgfUsersForthnightReportDLocalService) {

		_dgfUsersForthnightReportDLocalService =
			dgfUsersForthnightReportDLocalService;
	}

	/**
	 * Adds the dgf users forthnight report d to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersForthnightReportDLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsersForthnightReportD the dgf users forthnight report d
	 * @return the dgf users forthnight report d that was added
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersForthnightReportD
		addDgfUsersForthnightReportD(
			bd.gov.dgfood.food.grain.license.model.DgfUsersForthnightReportD
				dgfUsersForthnightReportD) {

		return _dgfUsersForthnightReportDLocalService.
			addDgfUsersForthnightReportD(dgfUsersForthnightReportD);
	}

	/**
	 * Creates a new dgf users forthnight report d with the primary key. Does not add the dgf users forthnight report d to the database.
	 *
	 * @param reportId the primary key for the new dgf users forthnight report d
	 * @return the new dgf users forthnight report d
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersForthnightReportD
		createDgfUsersForthnightReportD(long reportId) {

		return _dgfUsersForthnightReportDLocalService.
			createDgfUsersForthnightReportD(reportId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersForthnightReportDLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the dgf users forthnight report d from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersForthnightReportDLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsersForthnightReportD the dgf users forthnight report d
	 * @return the dgf users forthnight report d that was removed
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersForthnightReportD
		deleteDgfUsersForthnightReportD(
			bd.gov.dgfood.food.grain.license.model.DgfUsersForthnightReportD
				dgfUsersForthnightReportD) {

		return _dgfUsersForthnightReportDLocalService.
			deleteDgfUsersForthnightReportD(dgfUsersForthnightReportD);
	}

	/**
	 * Deletes the dgf users forthnight report d with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersForthnightReportDLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param reportId the primary key of the dgf users forthnight report d
	 * @return the dgf users forthnight report d that was removed
	 * @throws PortalException if a dgf users forthnight report d with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersForthnightReportD
			deleteDgfUsersForthnightReportD(long reportId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersForthnightReportDLocalService.
			deleteDgfUsersForthnightReportD(reportId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersForthnightReportDLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgfUsersForthnightReportDLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgfUsersForthnightReportDLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgfUsersForthnightReportDLocalService.dynamicQuery();
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

		return _dgfUsersForthnightReportDLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersForthnightReportDModelImpl</code>.
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

		return _dgfUsersForthnightReportDLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersForthnightReportDModelImpl</code>.
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

		return _dgfUsersForthnightReportDLocalService.dynamicQuery(
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

		return _dgfUsersForthnightReportDLocalService.dynamicQueryCount(
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

		return _dgfUsersForthnightReportDLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersForthnightReportD
		fetchDgfUsersForthnightReportD(long reportId) {

		return _dgfUsersForthnightReportDLocalService.
			fetchDgfUsersForthnightReportD(reportId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgfUsersForthnightReportDLocalService.
			getActionableDynamicQuery();
	}

	/**
	 * Returns the dgf users forthnight report d with the primary key.
	 *
	 * @param reportId the primary key of the dgf users forthnight report d
	 * @return the dgf users forthnight report d
	 * @throws PortalException if a dgf users forthnight report d with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersForthnightReportD
			getDgfUsersForthnightReportD(long reportId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersForthnightReportDLocalService.
			getDgfUsersForthnightReportD(reportId);
	}

	/**
	 * Returns a range of all the dgf users forthnight report ds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersForthnightReportDModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users forthnight report ds
	 * @param end the upper bound of the range of dgf users forthnight report ds (not inclusive)
	 * @return the range of dgf users forthnight report ds
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.DgfUsersForthnightReportD>
			getDgfUsersForthnightReportDs(int start, int end) {

		return _dgfUsersForthnightReportDLocalService.
			getDgfUsersForthnightReportDs(start, end);
	}

	/**
	 * Returns the number of dgf users forthnight report ds.
	 *
	 * @return the number of dgf users forthnight report ds
	 */
	@Override
	public int getDgfUsersForthnightReportDsCount() {
		return _dgfUsersForthnightReportDLocalService.
			getDgfUsersForthnightReportDsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgfUsersForthnightReportDLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfUsersForthnightReportDLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersForthnightReportDLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the dgf users forthnight report d in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersForthnightReportDLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsersForthnightReportD the dgf users forthnight report d
	 * @return the dgf users forthnight report d that was updated
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersForthnightReportD
		updateDgfUsersForthnightReportD(
			bd.gov.dgfood.food.grain.license.model.DgfUsersForthnightReportD
				dgfUsersForthnightReportD) {

		return _dgfUsersForthnightReportDLocalService.
			updateDgfUsersForthnightReportD(dgfUsersForthnightReportD);
	}

	@Override
	public DgfUsersForthnightReportDLocalService getWrappedService() {
		return _dgfUsersForthnightReportDLocalService;
	}

	@Override
	public void setWrappedService(
		DgfUsersForthnightReportDLocalService
			dgfUsersForthnightReportDLocalService) {

		_dgfUsersForthnightReportDLocalService =
			dgfUsersForthnightReportDLocalService;
	}

	private DgfUsersForthnightReportDLocalService
		_dgfUsersForthnightReportDLocalService;

}