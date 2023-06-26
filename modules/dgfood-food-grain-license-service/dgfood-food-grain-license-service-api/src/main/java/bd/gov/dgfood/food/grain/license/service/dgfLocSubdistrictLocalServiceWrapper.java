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
 * Provides a wrapper for {@link dgfLocSubdistrictLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see dgfLocSubdistrictLocalService
 * @generated
 */
public class dgfLocSubdistrictLocalServiceWrapper
	implements dgfLocSubdistrictLocalService,
			   ServiceWrapper<dgfLocSubdistrictLocalService> {

	public dgfLocSubdistrictLocalServiceWrapper() {
		this(null);
	}

	public dgfLocSubdistrictLocalServiceWrapper(
		dgfLocSubdistrictLocalService dgfLocSubdistrictLocalService) {

		_dgfLocSubdistrictLocalService = dgfLocSubdistrictLocalService;
	}

	/**
	 * Adds the dgf loc subdistrict to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect dgfLocSubdistrictLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfLocSubdistrict the dgf loc subdistrict
	 * @return the dgf loc subdistrict that was added
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict
		adddgfLocSubdistrict(
			bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict
				dgfLocSubdistrict) {

		return _dgfLocSubdistrictLocalService.adddgfLocSubdistrict(
			dgfLocSubdistrict);
	}

	/**
	 * Creates a new dgf loc subdistrict with the primary key. Does not add the dgf loc subdistrict to the database.
	 *
	 * @param id the primary key for the new dgf loc subdistrict
	 * @return the new dgf loc subdistrict
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict
		createdgfLocSubdistrict(long id) {

		return _dgfLocSubdistrictLocalService.createdgfLocSubdistrict(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfLocSubdistrictLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the dgf loc subdistrict from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect dgfLocSubdistrictLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfLocSubdistrict the dgf loc subdistrict
	 * @return the dgf loc subdistrict that was removed
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict
		deletedgfLocSubdistrict(
			bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict
				dgfLocSubdistrict) {

		return _dgfLocSubdistrictLocalService.deletedgfLocSubdistrict(
			dgfLocSubdistrict);
	}

	/**
	 * Deletes the dgf loc subdistrict with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect dgfLocSubdistrictLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the dgf loc subdistrict
	 * @return the dgf loc subdistrict that was removed
	 * @throws PortalException if a dgf loc subdistrict with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict
			deletedgfLocSubdistrict(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfLocSubdistrictLocalService.deletedgfLocSubdistrict(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfLocSubdistrictLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgfLocSubdistrictLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgfLocSubdistrictLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgfLocSubdistrictLocalService.dynamicQuery();
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

		return _dgfLocSubdistrictLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.dgfLocSubdistrictModelImpl</code>.
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

		return _dgfLocSubdistrictLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.dgfLocSubdistrictModelImpl</code>.
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

		return _dgfLocSubdistrictLocalService.dynamicQuery(
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

		return _dgfLocSubdistrictLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dgfLocSubdistrictLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict
		fetchdgfLocSubdistrict(long id) {

		return _dgfLocSubdistrictLocalService.fetchdgfLocSubdistrict(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgfLocSubdistrictLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the dgf loc subdistrict with the primary key.
	 *
	 * @param id the primary key of the dgf loc subdistrict
	 * @return the dgf loc subdistrict
	 * @throws PortalException if a dgf loc subdistrict with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict
			getdgfLocSubdistrict(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfLocSubdistrictLocalService.getdgfLocSubdistrict(id);
	}

	/**
	 * Returns a range of all the dgf loc subdistricts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.dgfLocSubdistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc subdistricts
	 * @param end the upper bound of the range of dgf loc subdistricts (not inclusive)
	 * @return the range of dgf loc subdistricts
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict>
			getdgfLocSubdistricts(int start, int end) {

		return _dgfLocSubdistrictLocalService.getdgfLocSubdistricts(start, end);
	}

	/**
	 * Returns the number of dgf loc subdistricts.
	 *
	 * @return the number of dgf loc subdistricts
	 */
	@Override
	public int getdgfLocSubdistrictsCount() {
		return _dgfLocSubdistrictLocalService.getdgfLocSubdistrictsCount();
	}

	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict>
			getdisWiseSubDis(long disId) {

		return _dgfLocSubdistrictLocalService.getdisWiseSubDis(disId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgfLocSubdistrictLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfLocSubdistrictLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfLocSubdistrictLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the dgf loc subdistrict in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect dgfLocSubdistrictLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfLocSubdistrict the dgf loc subdistrict
	 * @return the dgf loc subdistrict that was updated
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict
		updatedgfLocSubdistrict(
			bd.gov.dgfood.food.grain.license.model.dgfLocSubdistrict
				dgfLocSubdistrict) {

		return _dgfLocSubdistrictLocalService.updatedgfLocSubdistrict(
			dgfLocSubdistrict);
	}

	@Override
	public dgfLocSubdistrictLocalService getWrappedService() {
		return _dgfLocSubdistrictLocalService;
	}

	@Override
	public void setWrappedService(
		dgfLocSubdistrictLocalService dgfLocSubdistrictLocalService) {

		_dgfLocSubdistrictLocalService = dgfLocSubdistrictLocalService;
	}

	private dgfLocSubdistrictLocalService _dgfLocSubdistrictLocalService;

}