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

package bd.gov.dgfood.food.friendly.program.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DlrDistributionDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DlrDistributionDetailsLocalService
 * @generated
 */
public class DlrDistributionDetailsLocalServiceWrapper
	implements DlrDistributionDetailsLocalService,
			   ServiceWrapper<DlrDistributionDetailsLocalService> {

	public DlrDistributionDetailsLocalServiceWrapper() {
		this(null);
	}

	public DlrDistributionDetailsLocalServiceWrapper(
		DlrDistributionDetailsLocalService dlrDistributionDetailsLocalService) {

		_dlrDistributionDetailsLocalService =
			dlrDistributionDetailsLocalService;
	}

	/**
	 * Adds the dlr distribution details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DlrDistributionDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dlrDistributionDetails the dlr distribution details
	 * @return the dlr distribution details that was added
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.DlrDistributionDetails
		addDlrDistributionDetails(
			bd.gov.dgfood.food.friendly.program.model.DlrDistributionDetails
				dlrDistributionDetails) {

		return _dlrDistributionDetailsLocalService.addDlrDistributionDetails(
			dlrDistributionDetails);
	}

	/**
	 * Creates a new dlr distribution details with the primary key. Does not add the dlr distribution details to the database.
	 *
	 * @param dstrbnId the primary key for the new dlr distribution details
	 * @return the new dlr distribution details
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.DlrDistributionDetails
		createDlrDistributionDetails(long dstrbnId) {

		return _dlrDistributionDetailsLocalService.createDlrDistributionDetails(
			dstrbnId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dlrDistributionDetailsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the dlr distribution details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DlrDistributionDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dlrDistributionDetails the dlr distribution details
	 * @return the dlr distribution details that was removed
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.DlrDistributionDetails
		deleteDlrDistributionDetails(
			bd.gov.dgfood.food.friendly.program.model.DlrDistributionDetails
				dlrDistributionDetails) {

		return _dlrDistributionDetailsLocalService.deleteDlrDistributionDetails(
			dlrDistributionDetails);
	}

	/**
	 * Deletes the dlr distribution details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DlrDistributionDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dstrbnId the primary key of the dlr distribution details
	 * @return the dlr distribution details that was removed
	 * @throws PortalException if a dlr distribution details with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.DlrDistributionDetails
			deleteDlrDistributionDetails(long dstrbnId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dlrDistributionDetailsLocalService.deleteDlrDistributionDetails(
			dstrbnId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dlrDistributionDetailsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dlrDistributionDetailsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dlrDistributionDetailsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dlrDistributionDetailsLocalService.dynamicQuery();
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

		return _dlrDistributionDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.friendly.program.model.impl.DlrDistributionDetailsModelImpl</code>.
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

		return _dlrDistributionDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.friendly.program.model.impl.DlrDistributionDetailsModelImpl</code>.
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

		return _dlrDistributionDetailsLocalService.dynamicQuery(
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

		return _dlrDistributionDetailsLocalService.dynamicQueryCount(
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

		return _dlrDistributionDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.friendly.program.model.DlrDistributionDetails
		fetchDlrDistributionDetails(long dstrbnId) {

		return _dlrDistributionDetailsLocalService.fetchDlrDistributionDetails(
			dstrbnId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dlrDistributionDetailsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the dlr distribution details with the primary key.
	 *
	 * @param dstrbnId the primary key of the dlr distribution details
	 * @return the dlr distribution details
	 * @throws PortalException if a dlr distribution details with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.DlrDistributionDetails
			getDlrDistributionDetails(long dstrbnId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dlrDistributionDetailsLocalService.getDlrDistributionDetails(
			dstrbnId);
	}

	/**
	 * Returns a range of all the dlr distribution detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.friendly.program.model.impl.DlrDistributionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dlr distribution detailses
	 * @param end the upper bound of the range of dlr distribution detailses (not inclusive)
	 * @return the range of dlr distribution detailses
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.food.friendly.program.model.DlrDistributionDetails>
			getDlrDistributionDetailses(int start, int end) {

		return _dlrDistributionDetailsLocalService.getDlrDistributionDetailses(
			start, end);
	}

	/**
	 * Returns the number of dlr distribution detailses.
	 *
	 * @return the number of dlr distribution detailses
	 */
	@Override
	public int getDlrDistributionDetailsesCount() {
		return _dlrDistributionDetailsLocalService.
			getDlrDistributionDetailsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dlrDistributionDetailsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dlrDistributionDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dlrDistributionDetailsLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the dlr distribution details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DlrDistributionDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dlrDistributionDetails the dlr distribution details
	 * @return the dlr distribution details that was updated
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.DlrDistributionDetails
		updateDlrDistributionDetails(
			bd.gov.dgfood.food.friendly.program.model.DlrDistributionDetails
				dlrDistributionDetails) {

		return _dlrDistributionDetailsLocalService.updateDlrDistributionDetails(
			dlrDistributionDetails);
	}

	@Override
	public DlrDistributionDetailsLocalService getWrappedService() {
		return _dlrDistributionDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		DlrDistributionDetailsLocalService dlrDistributionDetailsLocalService) {

		_dlrDistributionDetailsLocalService =
			dlrDistributionDetailsLocalService;
	}

	private DlrDistributionDetailsLocalService
		_dlrDistributionDetailsLocalService;

}