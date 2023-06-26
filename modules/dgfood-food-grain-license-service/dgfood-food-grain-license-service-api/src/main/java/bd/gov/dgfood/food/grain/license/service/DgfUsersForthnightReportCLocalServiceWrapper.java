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
 * Provides a wrapper for {@link DgfUsersForthnightReportCLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersForthnightReportCLocalService
 * @generated
 */
public class DgfUsersForthnightReportCLocalServiceWrapper
	implements DgfUsersForthnightReportCLocalService,
			   ServiceWrapper<DgfUsersForthnightReportCLocalService> {

	public DgfUsersForthnightReportCLocalServiceWrapper() {
		this(null);
	}

	public DgfUsersForthnightReportCLocalServiceWrapper(
		DgfUsersForthnightReportCLocalService
			dgfUsersForthnightReportCLocalService) {

		_dgfUsersForthnightReportCLocalService =
			dgfUsersForthnightReportCLocalService;
	}

	/**
	 * Adds the dgf users forthnight report c to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersForthnightReportCLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsersForthnightReportC the dgf users forthnight report c
	 * @return the dgf users forthnight report c that was added
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersForthnightReportC
		addDgfUsersForthnightReportC(
			bd.gov.dgfood.food.grain.license.model.DgfUsersForthnightReportC
				dgfUsersForthnightReportC) {

		return _dgfUsersForthnightReportCLocalService.
			addDgfUsersForthnightReportC(dgfUsersForthnightReportC);
	}

	/**
	 * Creates a new dgf users forthnight report c with the primary key. Does not add the dgf users forthnight report c to the database.
	 *
	 * @param reportId the primary key for the new dgf users forthnight report c
	 * @return the new dgf users forthnight report c
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersForthnightReportC
		createDgfUsersForthnightReportC(long reportId) {

		return _dgfUsersForthnightReportCLocalService.
			createDgfUsersForthnightReportC(reportId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersForthnightReportCLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the dgf users forthnight report c from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersForthnightReportCLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsersForthnightReportC the dgf users forthnight report c
	 * @return the dgf users forthnight report c that was removed
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersForthnightReportC
		deleteDgfUsersForthnightReportC(
			bd.gov.dgfood.food.grain.license.model.DgfUsersForthnightReportC
				dgfUsersForthnightReportC) {

		return _dgfUsersForthnightReportCLocalService.
			deleteDgfUsersForthnightReportC(dgfUsersForthnightReportC);
	}

	/**
	 * Deletes the dgf users forthnight report c with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersForthnightReportCLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param reportId the primary key of the dgf users forthnight report c
	 * @return the dgf users forthnight report c that was removed
	 * @throws PortalException if a dgf users forthnight report c with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersForthnightReportC
			deleteDgfUsersForthnightReportC(long reportId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersForthnightReportCLocalService.
			deleteDgfUsersForthnightReportC(reportId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersForthnightReportCLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgfUsersForthnightReportCLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgfUsersForthnightReportCLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgfUsersForthnightReportCLocalService.dynamicQuery();
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

		return _dgfUsersForthnightReportCLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersForthnightReportCModelImpl</code>.
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

		return _dgfUsersForthnightReportCLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersForthnightReportCModelImpl</code>.
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

		return _dgfUsersForthnightReportCLocalService.dynamicQuery(
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

		return _dgfUsersForthnightReportCLocalService.dynamicQueryCount(
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

		return _dgfUsersForthnightReportCLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersForthnightReportC
		fetchDgfUsersForthnightReportC(long reportId) {

		return _dgfUsersForthnightReportCLocalService.
			fetchDgfUsersForthnightReportC(reportId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgfUsersForthnightReportCLocalService.
			getActionableDynamicQuery();
	}

	/**
	 * Returns the dgf users forthnight report c with the primary key.
	 *
	 * @param reportId the primary key of the dgf users forthnight report c
	 * @return the dgf users forthnight report c
	 * @throws PortalException if a dgf users forthnight report c with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersForthnightReportC
			getDgfUsersForthnightReportC(long reportId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersForthnightReportCLocalService.
			getDgfUsersForthnightReportC(reportId);
	}

	/**
	 * Returns a range of all the dgf users forthnight report cs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersForthnightReportCModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users forthnight report cs
	 * @param end the upper bound of the range of dgf users forthnight report cs (not inclusive)
	 * @return the range of dgf users forthnight report cs
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.DgfUsersForthnightReportC>
			getDgfUsersForthnightReportCs(int start, int end) {

		return _dgfUsersForthnightReportCLocalService.
			getDgfUsersForthnightReportCs(start, end);
	}

	/**
	 * Returns the number of dgf users forthnight report cs.
	 *
	 * @return the number of dgf users forthnight report cs
	 */
	@Override
	public int getDgfUsersForthnightReportCsCount() {
		return _dgfUsersForthnightReportCLocalService.
			getDgfUsersForthnightReportCsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgfUsersForthnightReportCLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfUsersForthnightReportCLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersForthnightReportCLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the dgf users forthnight report c in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersForthnightReportCLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsersForthnightReportC the dgf users forthnight report c
	 * @return the dgf users forthnight report c that was updated
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersForthnightReportC
		updateDgfUsersForthnightReportC(
			bd.gov.dgfood.food.grain.license.model.DgfUsersForthnightReportC
				dgfUsersForthnightReportC) {

		return _dgfUsersForthnightReportCLocalService.
			updateDgfUsersForthnightReportC(dgfUsersForthnightReportC);
	}

	@Override
	public DgfUsersForthnightReportCLocalService getWrappedService() {
		return _dgfUsersForthnightReportCLocalService;
	}

	@Override
	public void setWrappedService(
		DgfUsersForthnightReportCLocalService
			dgfUsersForthnightReportCLocalService) {

		_dgfUsersForthnightReportCLocalService =
			dgfUsersForthnightReportCLocalService;
	}

	private DgfUsersForthnightReportCLocalService
		_dgfUsersForthnightReportCLocalService;

}