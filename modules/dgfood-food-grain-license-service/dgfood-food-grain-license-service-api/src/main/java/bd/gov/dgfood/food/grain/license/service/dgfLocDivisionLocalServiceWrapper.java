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
 * Provides a wrapper for {@link dgfLocDivisionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see dgfLocDivisionLocalService
 * @generated
 */
public class dgfLocDivisionLocalServiceWrapper
	implements dgfLocDivisionLocalService,
			   ServiceWrapper<dgfLocDivisionLocalService> {

	public dgfLocDivisionLocalServiceWrapper() {
		this(null);
	}

	public dgfLocDivisionLocalServiceWrapper(
		dgfLocDivisionLocalService dgfLocDivisionLocalService) {

		_dgfLocDivisionLocalService = dgfLocDivisionLocalService;
	}

	/**
	 * Adds the dgf loc division to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect dgfLocDivisionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfLocDivision the dgf loc division
	 * @return the dgf loc division that was added
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.dgfLocDivision
		adddgfLocDivision(
			bd.gov.dgfood.food.grain.license.model.dgfLocDivision
				dgfLocDivision) {

		return _dgfLocDivisionLocalService.adddgfLocDivision(dgfLocDivision);
	}

	/**
	 * Creates a new dgf loc division with the primary key. Does not add the dgf loc division to the database.
	 *
	 * @param id the primary key for the new dgf loc division
	 * @return the new dgf loc division
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.dgfLocDivision
		createdgfLocDivision(long id) {

		return _dgfLocDivisionLocalService.createdgfLocDivision(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfLocDivisionLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the dgf loc division from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect dgfLocDivisionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfLocDivision the dgf loc division
	 * @return the dgf loc division that was removed
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.dgfLocDivision
		deletedgfLocDivision(
			bd.gov.dgfood.food.grain.license.model.dgfLocDivision
				dgfLocDivision) {

		return _dgfLocDivisionLocalService.deletedgfLocDivision(dgfLocDivision);
	}

	/**
	 * Deletes the dgf loc division with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect dgfLocDivisionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the dgf loc division
	 * @return the dgf loc division that was removed
	 * @throws PortalException if a dgf loc division with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.dgfLocDivision
			deletedgfLocDivision(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfLocDivisionLocalService.deletedgfLocDivision(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfLocDivisionLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgfLocDivisionLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgfLocDivisionLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgfLocDivisionLocalService.dynamicQuery();
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

		return _dgfLocDivisionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.dgfLocDivisionModelImpl</code>.
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

		return _dgfLocDivisionLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.dgfLocDivisionModelImpl</code>.
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

		return _dgfLocDivisionLocalService.dynamicQuery(
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

		return _dgfLocDivisionLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dgfLocDivisionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.dgfLocDivision
		fetchdgfLocDivision(long id) {

		return _dgfLocDivisionLocalService.fetchdgfLocDivision(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgfLocDivisionLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the dgf loc division with the primary key.
	 *
	 * @param id the primary key of the dgf loc division
	 * @return the dgf loc division
	 * @throws PortalException if a dgf loc division with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.dgfLocDivision
			getdgfLocDivision(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfLocDivisionLocalService.getdgfLocDivision(id);
	}

	/**
	 * Returns a range of all the dgf loc divisions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.dgfLocDivisionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc divisions
	 * @param end the upper bound of the range of dgf loc divisions (not inclusive)
	 * @return the range of dgf loc divisions
	 */
	@Override
	public java.util.List<bd.gov.dgfood.food.grain.license.model.dgfLocDivision>
		getdgfLocDivisions(int start, int end) {

		return _dgfLocDivisionLocalService.getdgfLocDivisions(start, end);
	}

	/**
	 * Returns the number of dgf loc divisions.
	 *
	 * @return the number of dgf loc divisions
	 */
	@Override
	public int getdgfLocDivisionsCount() {
		return _dgfLocDivisionLocalService.getdgfLocDivisionsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgfLocDivisionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfLocDivisionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfLocDivisionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the dgf loc division in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect dgfLocDivisionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfLocDivision the dgf loc division
	 * @return the dgf loc division that was updated
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.dgfLocDivision
		updatedgfLocDivision(
			bd.gov.dgfood.food.grain.license.model.dgfLocDivision
				dgfLocDivision) {

		return _dgfLocDivisionLocalService.updatedgfLocDivision(dgfLocDivision);
	}

	@Override
	public dgfLocDivisionLocalService getWrappedService() {
		return _dgfLocDivisionLocalService;
	}

	@Override
	public void setWrappedService(
		dgfLocDivisionLocalService dgfLocDivisionLocalService) {

		_dgfLocDivisionLocalService = dgfLocDivisionLocalService;
	}

	private dgfLocDivisionLocalService _dgfLocDivisionLocalService;

}