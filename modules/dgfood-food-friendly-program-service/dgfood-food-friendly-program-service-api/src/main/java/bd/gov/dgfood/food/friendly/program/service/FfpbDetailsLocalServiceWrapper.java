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
 * Provides a wrapper for {@link FfpbDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FfpbDetailsLocalService
 * @generated
 */
public class FfpbDetailsLocalServiceWrapper
	implements FfpbDetailsLocalService,
			   ServiceWrapper<FfpbDetailsLocalService> {

	public FfpbDetailsLocalServiceWrapper() {
		this(null);
	}

	public FfpbDetailsLocalServiceWrapper(
		FfpbDetailsLocalService ffpbDetailsLocalService) {

		_ffpbDetailsLocalService = ffpbDetailsLocalService;
	}

	/**
	 * Adds the ffpb details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FfpbDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ffpbDetails the ffpb details
	 * @return the ffpb details that was added
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.FfpbDetails addFfpbDetails(
		bd.gov.dgfood.food.friendly.program.model.FfpbDetails ffpbDetails) {

		return _ffpbDetailsLocalService.addFfpbDetails(ffpbDetails);
	}

	/**
	 * Creates a new ffpb details with the primary key. Does not add the ffpb details to the database.
	 *
	 * @param ffpRegstrId the primary key for the new ffpb details
	 * @return the new ffpb details
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.FfpbDetails
		createFfpbDetails(long ffpRegstrId) {

		return _ffpbDetailsLocalService.createFfpbDetails(ffpRegstrId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ffpbDetailsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the ffpb details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FfpbDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ffpbDetails the ffpb details
	 * @return the ffpb details that was removed
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.FfpbDetails
		deleteFfpbDetails(
			bd.gov.dgfood.food.friendly.program.model.FfpbDetails ffpbDetails) {

		return _ffpbDetailsLocalService.deleteFfpbDetails(ffpbDetails);
	}

	/**
	 * Deletes the ffpb details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FfpbDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ffpRegstrId the primary key of the ffpb details
	 * @return the ffpb details that was removed
	 * @throws PortalException if a ffpb details with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.FfpbDetails
			deleteFfpbDetails(long ffpRegstrId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ffpbDetailsLocalService.deleteFfpbDetails(ffpRegstrId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ffpbDetailsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _ffpbDetailsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _ffpbDetailsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ffpbDetailsLocalService.dynamicQuery();
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

		return _ffpbDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.friendly.program.model.impl.FfpbDetailsModelImpl</code>.
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

		return _ffpbDetailsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.friendly.program.model.impl.FfpbDetailsModelImpl</code>.
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

		return _ffpbDetailsLocalService.dynamicQuery(
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

		return _ffpbDetailsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _ffpbDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.friendly.program.model.FfpbDetails
		fetchFfpbDetails(long ffpRegstrId) {

		return _ffpbDetailsLocalService.fetchFfpbDetails(ffpRegstrId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ffpbDetailsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the ffpb details with the primary key.
	 *
	 * @param ffpRegstrId the primary key of the ffpb details
	 * @return the ffpb details
	 * @throws PortalException if a ffpb details with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.FfpbDetails getFfpbDetails(
			long ffpRegstrId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ffpbDetailsLocalService.getFfpbDetails(ffpRegstrId);
	}

	/**
	 * Returns a range of all the ffpb detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.friendly.program.model.impl.FfpbDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ffpb detailses
	 * @param end the upper bound of the range of ffpb detailses (not inclusive)
	 * @return the range of ffpb detailses
	 */
	@Override
	public java.util.List<bd.gov.dgfood.food.friendly.program.model.FfpbDetails>
		getFfpbDetailses(int start, int end) {

		return _ffpbDetailsLocalService.getFfpbDetailses(start, end);
	}

	/**
	 * Returns the number of ffpb detailses.
	 *
	 * @return the number of ffpb detailses
	 */
	@Override
	public int getFfpbDetailsesCount() {
		return _ffpbDetailsLocalService.getFfpbDetailsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ffpbDetailsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ffpbDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ffpbDetailsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the ffpb details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FfpbDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ffpbDetails the ffpb details
	 * @return the ffpb details that was updated
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.FfpbDetails
		updateFfpbDetails(
			bd.gov.dgfood.food.friendly.program.model.FfpbDetails ffpbDetails) {

		return _ffpbDetailsLocalService.updateFfpbDetails(ffpbDetails);
	}

	@Override
	public FfpbDetailsLocalService getWrappedService() {
		return _ffpbDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		FfpbDetailsLocalService ffpbDetailsLocalService) {

		_ffpbDetailsLocalService = ffpbDetailsLocalService;
	}

	private FfpbDetailsLocalService _ffpbDetailsLocalService;

}