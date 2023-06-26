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
 * Provides a wrapper for {@link DlrFfpOmsAllcNtfyDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DlrFfpOmsAllcNtfyDetailsLocalService
 * @generated
 */
public class DlrFfpOmsAllcNtfyDetailsLocalServiceWrapper
	implements DlrFfpOmsAllcNtfyDetailsLocalService,
			   ServiceWrapper<DlrFfpOmsAllcNtfyDetailsLocalService> {

	public DlrFfpOmsAllcNtfyDetailsLocalServiceWrapper() {
		this(null);
	}

	public DlrFfpOmsAllcNtfyDetailsLocalServiceWrapper(
		DlrFfpOmsAllcNtfyDetailsLocalService
			dlrFfpOmsAllcNtfyDetailsLocalService) {

		_dlrFfpOmsAllcNtfyDetailsLocalService =
			dlrFfpOmsAllcNtfyDetailsLocalService;
	}

	/**
	 * Adds the dlr ffp oms allc ntfy details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DlrFfpOmsAllcNtfyDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dlrFfpOmsAllcNtfyDetails the dlr ffp oms allc ntfy details
	 * @return the dlr ffp oms allc ntfy details that was added
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.DlrFfpOmsAllcNtfyDetails
		addDlrFfpOmsAllcNtfyDetails(
			bd.gov.dgfood.food.friendly.program.model.DlrFfpOmsAllcNtfyDetails
				dlrFfpOmsAllcNtfyDetails) {

		return _dlrFfpOmsAllcNtfyDetailsLocalService.
			addDlrFfpOmsAllcNtfyDetails(dlrFfpOmsAllcNtfyDetails);
	}

	/**
	 * Creates a new dlr ffp oms allc ntfy details with the primary key. Does not add the dlr ffp oms allc ntfy details to the database.
	 *
	 * @param allocNtfyId the primary key for the new dlr ffp oms allc ntfy details
	 * @return the new dlr ffp oms allc ntfy details
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.DlrFfpOmsAllcNtfyDetails
		createDlrFfpOmsAllcNtfyDetails(String allocNtfyId) {

		return _dlrFfpOmsAllcNtfyDetailsLocalService.
			createDlrFfpOmsAllcNtfyDetails(allocNtfyId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dlrFfpOmsAllcNtfyDetailsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the dlr ffp oms allc ntfy details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DlrFfpOmsAllcNtfyDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dlrFfpOmsAllcNtfyDetails the dlr ffp oms allc ntfy details
	 * @return the dlr ffp oms allc ntfy details that was removed
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.DlrFfpOmsAllcNtfyDetails
		deleteDlrFfpOmsAllcNtfyDetails(
			bd.gov.dgfood.food.friendly.program.model.DlrFfpOmsAllcNtfyDetails
				dlrFfpOmsAllcNtfyDetails) {

		return _dlrFfpOmsAllcNtfyDetailsLocalService.
			deleteDlrFfpOmsAllcNtfyDetails(dlrFfpOmsAllcNtfyDetails);
	}

	/**
	 * Deletes the dlr ffp oms allc ntfy details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DlrFfpOmsAllcNtfyDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param allocNtfyId the primary key of the dlr ffp oms allc ntfy details
	 * @return the dlr ffp oms allc ntfy details that was removed
	 * @throws PortalException if a dlr ffp oms allc ntfy details with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.DlrFfpOmsAllcNtfyDetails
			deleteDlrFfpOmsAllcNtfyDetails(String allocNtfyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dlrFfpOmsAllcNtfyDetailsLocalService.
			deleteDlrFfpOmsAllcNtfyDetails(allocNtfyId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dlrFfpOmsAllcNtfyDetailsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dlrFfpOmsAllcNtfyDetailsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dlrFfpOmsAllcNtfyDetailsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dlrFfpOmsAllcNtfyDetailsLocalService.dynamicQuery();
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

		return _dlrFfpOmsAllcNtfyDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.friendly.program.model.impl.DlrFfpOmsAllcNtfyDetailsModelImpl</code>.
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

		return _dlrFfpOmsAllcNtfyDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.friendly.program.model.impl.DlrFfpOmsAllcNtfyDetailsModelImpl</code>.
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

		return _dlrFfpOmsAllcNtfyDetailsLocalService.dynamicQuery(
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

		return _dlrFfpOmsAllcNtfyDetailsLocalService.dynamicQueryCount(
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

		return _dlrFfpOmsAllcNtfyDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.friendly.program.model.DlrFfpOmsAllcNtfyDetails
		fetchDlrFfpOmsAllcNtfyDetails(String allocNtfyId) {

		return _dlrFfpOmsAllcNtfyDetailsLocalService.
			fetchDlrFfpOmsAllcNtfyDetails(allocNtfyId);
	}

	/**
	 * Returns the dlr ffp oms allc ntfy details with the primary key.
	 *
	 * @param allocNtfyId the primary key of the dlr ffp oms allc ntfy details
	 * @return the dlr ffp oms allc ntfy details
	 * @throws PortalException if a dlr ffp oms allc ntfy details with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.DlrFfpOmsAllcNtfyDetails
			getDlrFfpOmsAllcNtfyDetails(String allocNtfyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dlrFfpOmsAllcNtfyDetailsLocalService.
			getDlrFfpOmsAllcNtfyDetails(allocNtfyId);
	}

	/**
	 * Returns a range of all the dlr ffp oms allc ntfy detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.friendly.program.model.impl.DlrFfpOmsAllcNtfyDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dlr ffp oms allc ntfy detailses
	 * @param end the upper bound of the range of dlr ffp oms allc ntfy detailses (not inclusive)
	 * @return the range of dlr ffp oms allc ntfy detailses
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.food.friendly.program.model.DlrFfpOmsAllcNtfyDetails>
			getDlrFfpOmsAllcNtfyDetailses(int start, int end) {

		return _dlrFfpOmsAllcNtfyDetailsLocalService.
			getDlrFfpOmsAllcNtfyDetailses(start, end);
	}

	/**
	 * Returns the number of dlr ffp oms allc ntfy detailses.
	 *
	 * @return the number of dlr ffp oms allc ntfy detailses
	 */
	@Override
	public int getDlrFfpOmsAllcNtfyDetailsesCount() {
		return _dlrFfpOmsAllcNtfyDetailsLocalService.
			getDlrFfpOmsAllcNtfyDetailsesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dlrFfpOmsAllcNtfyDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dlrFfpOmsAllcNtfyDetailsLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the dlr ffp oms allc ntfy details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DlrFfpOmsAllcNtfyDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dlrFfpOmsAllcNtfyDetails the dlr ffp oms allc ntfy details
	 * @return the dlr ffp oms allc ntfy details that was updated
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.DlrFfpOmsAllcNtfyDetails
		updateDlrFfpOmsAllcNtfyDetails(
			bd.gov.dgfood.food.friendly.program.model.DlrFfpOmsAllcNtfyDetails
				dlrFfpOmsAllcNtfyDetails) {

		return _dlrFfpOmsAllcNtfyDetailsLocalService.
			updateDlrFfpOmsAllcNtfyDetails(dlrFfpOmsAllcNtfyDetails);
	}

	@Override
	public DlrFfpOmsAllcNtfyDetailsLocalService getWrappedService() {
		return _dlrFfpOmsAllcNtfyDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		DlrFfpOmsAllcNtfyDetailsLocalService
			dlrFfpOmsAllcNtfyDetailsLocalService) {

		_dlrFfpOmsAllcNtfyDetailsLocalService =
			dlrFfpOmsAllcNtfyDetailsLocalService;
	}

	private DlrFfpOmsAllcNtfyDetailsLocalService
		_dlrFfpOmsAllcNtfyDetailsLocalService;

}