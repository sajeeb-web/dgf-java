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
 * Provides a wrapper for {@link dgfLocUnionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see dgfLocUnionLocalService
 * @generated
 */
public class dgfLocUnionLocalServiceWrapper
	implements dgfLocUnionLocalService,
			   ServiceWrapper<dgfLocUnionLocalService> {

	public dgfLocUnionLocalServiceWrapper() {
		this(null);
	}

	public dgfLocUnionLocalServiceWrapper(
		dgfLocUnionLocalService dgfLocUnionLocalService) {

		_dgfLocUnionLocalService = dgfLocUnionLocalService;
	}

	/**
	 * Adds the dgf loc union to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect dgfLocUnionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfLocUnion the dgf loc union
	 * @return the dgf loc union that was added
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.dgfLocUnion adddgfLocUnion(
		bd.gov.dgfood.food.grain.license.model.dgfLocUnion dgfLocUnion) {

		return _dgfLocUnionLocalService.adddgfLocUnion(dgfLocUnion);
	}

	/**
	 * Creates a new dgf loc union with the primary key. Does not add the dgf loc union to the database.
	 *
	 * @param id the primary key for the new dgf loc union
	 * @return the new dgf loc union
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.dgfLocUnion createdgfLocUnion(
		long id) {

		return _dgfLocUnionLocalService.createdgfLocUnion(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfLocUnionLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the dgf loc union from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect dgfLocUnionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfLocUnion the dgf loc union
	 * @return the dgf loc union that was removed
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.dgfLocUnion deletedgfLocUnion(
		bd.gov.dgfood.food.grain.license.model.dgfLocUnion dgfLocUnion) {

		return _dgfLocUnionLocalService.deletedgfLocUnion(dgfLocUnion);
	}

	/**
	 * Deletes the dgf loc union with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect dgfLocUnionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the dgf loc union
	 * @return the dgf loc union that was removed
	 * @throws PortalException if a dgf loc union with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.dgfLocUnion deletedgfLocUnion(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfLocUnionLocalService.deletedgfLocUnion(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfLocUnionLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgfLocUnionLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgfLocUnionLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgfLocUnionLocalService.dynamicQuery();
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

		return _dgfLocUnionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.dgfLocUnionModelImpl</code>.
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

		return _dgfLocUnionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.dgfLocUnionModelImpl</code>.
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

		return _dgfLocUnionLocalService.dynamicQuery(
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

		return _dgfLocUnionLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dgfLocUnionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.dgfLocUnion fetchdgfLocUnion(
		long id) {

		return _dgfLocUnionLocalService.fetchdgfLocUnion(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgfLocUnionLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the dgf loc union with the primary key.
	 *
	 * @param id the primary key of the dgf loc union
	 * @return the dgf loc union
	 * @throws PortalException if a dgf loc union with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.dgfLocUnion getdgfLocUnion(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfLocUnionLocalService.getdgfLocUnion(id);
	}

	/**
	 * Returns a range of all the dgf loc unions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.dgfLocUnionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc unions
	 * @param end the upper bound of the range of dgf loc unions (not inclusive)
	 * @return the range of dgf loc unions
	 */
	@Override
	public java.util.List<bd.gov.dgfood.food.grain.license.model.dgfLocUnion>
		getdgfLocUnions(int start, int end) {

		return _dgfLocUnionLocalService.getdgfLocUnions(start, end);
	}

	/**
	 * Returns the number of dgf loc unions.
	 *
	 * @return the number of dgf loc unions
	 */
	@Override
	public int getdgfLocUnionsCount() {
		return _dgfLocUnionLocalService.getdgfLocUnionsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgfLocUnionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfLocUnionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfLocUnionLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<bd.gov.dgfood.food.grain.license.model.dgfLocUnion>
		getsubDisWiseUn(long subDisId) {

		return _dgfLocUnionLocalService.getsubDisWiseUn(subDisId);
	}

	/**
	 * Updates the dgf loc union in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect dgfLocUnionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfLocUnion the dgf loc union
	 * @return the dgf loc union that was updated
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.dgfLocUnion updatedgfLocUnion(
		bd.gov.dgfood.food.grain.license.model.dgfLocUnion dgfLocUnion) {

		return _dgfLocUnionLocalService.updatedgfLocUnion(dgfLocUnion);
	}

	@Override
	public dgfLocUnionLocalService getWrappedService() {
		return _dgfLocUnionLocalService;
	}

	@Override
	public void setWrappedService(
		dgfLocUnionLocalService dgfLocUnionLocalService) {

		_dgfLocUnionLocalService = dgfLocUnionLocalService;
	}

	private dgfLocUnionLocalService _dgfLocUnionLocalService;

}