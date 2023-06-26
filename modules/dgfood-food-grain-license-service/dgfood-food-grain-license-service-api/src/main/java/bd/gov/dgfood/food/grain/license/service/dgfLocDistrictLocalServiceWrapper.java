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
 * Provides a wrapper for {@link dgfLocDistrictLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see dgfLocDistrictLocalService
 * @generated
 */
public class dgfLocDistrictLocalServiceWrapper
	implements dgfLocDistrictLocalService,
			   ServiceWrapper<dgfLocDistrictLocalService> {

	public dgfLocDistrictLocalServiceWrapper() {
		this(null);
	}

	public dgfLocDistrictLocalServiceWrapper(
		dgfLocDistrictLocalService dgfLocDistrictLocalService) {

		_dgfLocDistrictLocalService = dgfLocDistrictLocalService;
	}

	/**
	 * Adds the dgf loc district to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect dgfLocDistrictLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfLocDistrict the dgf loc district
	 * @return the dgf loc district that was added
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.dgfLocDistrict
		adddgfLocDistrict(
			bd.gov.dgfood.food.grain.license.model.dgfLocDistrict
				dgfLocDistrict) {

		return _dgfLocDistrictLocalService.adddgfLocDistrict(dgfLocDistrict);
	}

	/**
	 * Creates a new dgf loc district with the primary key. Does not add the dgf loc district to the database.
	 *
	 * @param id the primary key for the new dgf loc district
	 * @return the new dgf loc district
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.dgfLocDistrict
		createdgfLocDistrict(long id) {

		return _dgfLocDistrictLocalService.createdgfLocDistrict(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfLocDistrictLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the dgf loc district from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect dgfLocDistrictLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfLocDistrict the dgf loc district
	 * @return the dgf loc district that was removed
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.dgfLocDistrict
		deletedgfLocDistrict(
			bd.gov.dgfood.food.grain.license.model.dgfLocDistrict
				dgfLocDistrict) {

		return _dgfLocDistrictLocalService.deletedgfLocDistrict(dgfLocDistrict);
	}

	/**
	 * Deletes the dgf loc district with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect dgfLocDistrictLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the dgf loc district
	 * @return the dgf loc district that was removed
	 * @throws PortalException if a dgf loc district with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.dgfLocDistrict
			deletedgfLocDistrict(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfLocDistrictLocalService.deletedgfLocDistrict(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfLocDistrictLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgfLocDistrictLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgfLocDistrictLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgfLocDistrictLocalService.dynamicQuery();
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

		return _dgfLocDistrictLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.dgfLocDistrictModelImpl</code>.
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

		return _dgfLocDistrictLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.dgfLocDistrictModelImpl</code>.
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

		return _dgfLocDistrictLocalService.dynamicQuery(
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

		return _dgfLocDistrictLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dgfLocDistrictLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.dgfLocDistrict
		fetchdgfLocDistrict(long id) {

		return _dgfLocDistrictLocalService.fetchdgfLocDistrict(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgfLocDistrictLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the dgf loc district with the primary key.
	 *
	 * @param id the primary key of the dgf loc district
	 * @return the dgf loc district
	 * @throws PortalException if a dgf loc district with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.dgfLocDistrict
			getdgfLocDistrict(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfLocDistrictLocalService.getdgfLocDistrict(id);
	}

	/**
	 * Returns a range of all the dgf loc districts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.dgfLocDistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc districts
	 * @param end the upper bound of the range of dgf loc districts (not inclusive)
	 * @return the range of dgf loc districts
	 */
	@Override
	public java.util.List<bd.gov.dgfood.food.grain.license.model.dgfLocDistrict>
		getdgfLocDistricts(int start, int end) {

		return _dgfLocDistrictLocalService.getdgfLocDistricts(start, end);
	}

	/**
	 * Returns the number of dgf loc districts.
	 *
	 * @return the number of dgf loc districts
	 */
	@Override
	public int getdgfLocDistrictsCount() {
		return _dgfLocDistrictLocalService.getdgfLocDistrictsCount();
	}

	@Override
	public java.util.List<bd.gov.dgfood.food.grain.license.model.dgfLocDistrict>
		getdivWiseDis(long divId) {

		return _dgfLocDistrictLocalService.getdivWiseDis(divId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgfLocDistrictLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfLocDistrictLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfLocDistrictLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the dgf loc district in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect dgfLocDistrictLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfLocDistrict the dgf loc district
	 * @return the dgf loc district that was updated
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.dgfLocDistrict
		updatedgfLocDistrict(
			bd.gov.dgfood.food.grain.license.model.dgfLocDistrict
				dgfLocDistrict) {

		return _dgfLocDistrictLocalService.updatedgfLocDistrict(dgfLocDistrict);
	}

	@Override
	public dgfLocDistrictLocalService getWrappedService() {
		return _dgfLocDistrictLocalService;
	}

	@Override
	public void setWrappedService(
		dgfLocDistrictLocalService dgfLocDistrictLocalService) {

		_dgfLocDistrictLocalService = dgfLocDistrictLocalService;
	}

	private dgfLocDistrictLocalService _dgfLocDistrictLocalService;

}