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
 * Provides a wrapper for {@link DgfFglLicenseNoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfFglLicenseNoLocalService
 * @generated
 */
public class DgfFglLicenseNoLocalServiceWrapper
	implements DgfFglLicenseNoLocalService,
			   ServiceWrapper<DgfFglLicenseNoLocalService> {

	public DgfFglLicenseNoLocalServiceWrapper() {
		this(null);
	}

	public DgfFglLicenseNoLocalServiceWrapper(
		DgfFglLicenseNoLocalService dgfFglLicenseNoLocalService) {

		_dgfFglLicenseNoLocalService = dgfFglLicenseNoLocalService;
	}

	/**
	 * Adds the dgf fgl license no to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfFglLicenseNoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfFglLicenseNo the dgf fgl license no
	 * @return the dgf fgl license no that was added
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglLicenseNo
		addDgfFglLicenseNo(
			bd.gov.dgfood.food.grain.license.model.DgfFglLicenseNo
				dgfFglLicenseNo) {

		return _dgfFglLicenseNoLocalService.addDgfFglLicenseNo(dgfFglLicenseNo);
	}

	/**
	 * Creates a new dgf fgl license no with the primary key. Does not add the dgf fgl license no to the database.
	 *
	 * @param id the primary key for the new dgf fgl license no
	 * @return the new dgf fgl license no
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglLicenseNo
		createDgfFglLicenseNo(long id) {

		return _dgfFglLicenseNoLocalService.createDgfFglLicenseNo(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfFglLicenseNoLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the dgf fgl license no from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfFglLicenseNoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfFglLicenseNo the dgf fgl license no
	 * @return the dgf fgl license no that was removed
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglLicenseNo
		deleteDgfFglLicenseNo(
			bd.gov.dgfood.food.grain.license.model.DgfFglLicenseNo
				dgfFglLicenseNo) {

		return _dgfFglLicenseNoLocalService.deleteDgfFglLicenseNo(
			dgfFglLicenseNo);
	}

	/**
	 * Deletes the dgf fgl license no with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfFglLicenseNoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the dgf fgl license no
	 * @return the dgf fgl license no that was removed
	 * @throws PortalException if a dgf fgl license no with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglLicenseNo
			deleteDgfFglLicenseNo(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfFglLicenseNoLocalService.deleteDgfFglLicenseNo(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfFglLicenseNoLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgfFglLicenseNoLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgfFglLicenseNoLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgfFglLicenseNoLocalService.dynamicQuery();
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

		return _dgfFglLicenseNoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfFglLicenseNoModelImpl</code>.
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

		return _dgfFglLicenseNoLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfFglLicenseNoModelImpl</code>.
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

		return _dgfFglLicenseNoLocalService.dynamicQuery(
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

		return _dgfFglLicenseNoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dgfFglLicenseNoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglLicenseNo
		fetchDgfFglLicenseNo(long id) {

		return _dgfFglLicenseNoLocalService.fetchDgfFglLicenseNo(id);
	}

	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.DgfFglLicenseNo>
				findAllOrderedByIdDesc()
			throws com.liferay.portal.kernel.exception.SystemException {

		return _dgfFglLicenseNoLocalService.findAllOrderedByIdDesc();
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglLicenseNo
		generatedDgfFglLicenseNo() {

		return _dgfFglLicenseNoLocalService.generatedDgfFglLicenseNo();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgfFglLicenseNoLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the dgf fgl license no with the primary key.
	 *
	 * @param id the primary key of the dgf fgl license no
	 * @return the dgf fgl license no
	 * @throws PortalException if a dgf fgl license no with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglLicenseNo
			getDgfFglLicenseNo(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfFglLicenseNoLocalService.getDgfFglLicenseNo(id);
	}

	/**
	 * Returns a range of all the dgf fgl license nos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfFglLicenseNoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl license nos
	 * @param end the upper bound of the range of dgf fgl license nos (not inclusive)
	 * @return the range of dgf fgl license nos
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.DgfFglLicenseNo>
			getDgfFglLicenseNos(int start, int end) {

		return _dgfFglLicenseNoLocalService.getDgfFglLicenseNos(start, end);
	}

	/**
	 * Returns the number of dgf fgl license nos.
	 *
	 * @return the number of dgf fgl license nos
	 */
	@Override
	public int getDgfFglLicenseNosCount() {
		return _dgfFglLicenseNoLocalService.getDgfFglLicenseNosCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgfFglLicenseNoLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfFglLicenseNoLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfFglLicenseNoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the dgf fgl license no in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfFglLicenseNoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfFglLicenseNo the dgf fgl license no
	 * @return the dgf fgl license no that was updated
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglLicenseNo
		updateDgfFglLicenseNo(
			bd.gov.dgfood.food.grain.license.model.DgfFglLicenseNo
				dgfFglLicenseNo) {

		return _dgfFglLicenseNoLocalService.updateDgfFglLicenseNo(
			dgfFglLicenseNo);
	}

	@Override
	public DgfFglLicenseNoLocalService getWrappedService() {
		return _dgfFglLicenseNoLocalService;
	}

	@Override
	public void setWrappedService(
		DgfFglLicenseNoLocalService dgfFglLicenseNoLocalService) {

		_dgfFglLicenseNoLocalService = dgfFglLicenseNoLocalService;
	}

	private DgfFglLicenseNoLocalService _dgfFglLicenseNoLocalService;

}