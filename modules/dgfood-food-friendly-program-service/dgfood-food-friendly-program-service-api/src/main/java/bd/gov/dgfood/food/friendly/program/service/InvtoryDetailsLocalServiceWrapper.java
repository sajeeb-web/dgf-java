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
 * Provides a wrapper for {@link InvtoryDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see InvtoryDetailsLocalService
 * @generated
 */
public class InvtoryDetailsLocalServiceWrapper
	implements InvtoryDetailsLocalService,
			   ServiceWrapper<InvtoryDetailsLocalService> {

	public InvtoryDetailsLocalServiceWrapper() {
		this(null);
	}

	public InvtoryDetailsLocalServiceWrapper(
		InvtoryDetailsLocalService invtoryDetailsLocalService) {

		_invtoryDetailsLocalService = invtoryDetailsLocalService;
	}

	/**
	 * Adds the invtory details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InvtoryDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param invtoryDetails the invtory details
	 * @return the invtory details that was added
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.InvtoryDetails
		addInvtoryDetails(
			bd.gov.dgfood.food.friendly.program.model.InvtoryDetails
				invtoryDetails) {

		return _invtoryDetailsLocalService.addInvtoryDetails(invtoryDetails);
	}

	/**
	 * Creates a new invtory details with the primary key. Does not add the invtory details to the database.
	 *
	 * @param inventoryId the primary key for the new invtory details
	 * @return the new invtory details
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.InvtoryDetails
		createInvtoryDetails(long inventoryId) {

		return _invtoryDetailsLocalService.createInvtoryDetails(inventoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _invtoryDetailsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the invtory details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InvtoryDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param invtoryDetails the invtory details
	 * @return the invtory details that was removed
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.InvtoryDetails
		deleteInvtoryDetails(
			bd.gov.dgfood.food.friendly.program.model.InvtoryDetails
				invtoryDetails) {

		return _invtoryDetailsLocalService.deleteInvtoryDetails(invtoryDetails);
	}

	/**
	 * Deletes the invtory details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InvtoryDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param inventoryId the primary key of the invtory details
	 * @return the invtory details that was removed
	 * @throws PortalException if a invtory details with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.InvtoryDetails
			deleteInvtoryDetails(long inventoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _invtoryDetailsLocalService.deleteInvtoryDetails(inventoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _invtoryDetailsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _invtoryDetailsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _invtoryDetailsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _invtoryDetailsLocalService.dynamicQuery();
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

		return _invtoryDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.friendly.program.model.impl.InvtoryDetailsModelImpl</code>.
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

		return _invtoryDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.friendly.program.model.impl.InvtoryDetailsModelImpl</code>.
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

		return _invtoryDetailsLocalService.dynamicQuery(
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

		return _invtoryDetailsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _invtoryDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.friendly.program.model.InvtoryDetails
		fetchInvtoryDetails(long inventoryId) {

		return _invtoryDetailsLocalService.fetchInvtoryDetails(inventoryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _invtoryDetailsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _invtoryDetailsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the invtory details with the primary key.
	 *
	 * @param inventoryId the primary key of the invtory details
	 * @return the invtory details
	 * @throws PortalException if a invtory details with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.InvtoryDetails
			getInvtoryDetails(long inventoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _invtoryDetailsLocalService.getInvtoryDetails(inventoryId);
	}

	/**
	 * Returns a range of all the invtory detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.friendly.program.model.impl.InvtoryDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of invtory detailses
	 * @param end the upper bound of the range of invtory detailses (not inclusive)
	 * @return the range of invtory detailses
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.food.friendly.program.model.InvtoryDetails>
			getInvtoryDetailses(int start, int end) {

		return _invtoryDetailsLocalService.getInvtoryDetailses(start, end);
	}

	/**
	 * Returns the number of invtory detailses.
	 *
	 * @return the number of invtory detailses
	 */
	@Override
	public int getInvtoryDetailsesCount() {
		return _invtoryDetailsLocalService.getInvtoryDetailsesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _invtoryDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _invtoryDetailsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the invtory details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InvtoryDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param invtoryDetails the invtory details
	 * @return the invtory details that was updated
	 */
	@Override
	public bd.gov.dgfood.food.friendly.program.model.InvtoryDetails
		updateInvtoryDetails(
			bd.gov.dgfood.food.friendly.program.model.InvtoryDetails
				invtoryDetails) {

		return _invtoryDetailsLocalService.updateInvtoryDetails(invtoryDetails);
	}

	@Override
	public InvtoryDetailsLocalService getWrappedService() {
		return _invtoryDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		InvtoryDetailsLocalService invtoryDetailsLocalService) {

		_invtoryDetailsLocalService = invtoryDetailsLocalService;
	}

	private InvtoryDetailsLocalService _invtoryDetailsLocalService;

}