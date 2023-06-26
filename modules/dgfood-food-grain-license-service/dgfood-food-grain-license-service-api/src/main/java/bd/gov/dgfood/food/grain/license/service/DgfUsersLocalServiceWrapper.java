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
 * Provides a wrapper for {@link DgfUsersLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersLocalService
 * @generated
 */
public class DgfUsersLocalServiceWrapper
	implements DgfUsersLocalService, ServiceWrapper<DgfUsersLocalService> {

	public DgfUsersLocalServiceWrapper() {
		this(null);
	}

	public DgfUsersLocalServiceWrapper(
		DgfUsersLocalService dgfUsersLocalService) {

		_dgfUsersLocalService = dgfUsersLocalService;
	}

	/**
	 * Adds the dgf users to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsers the dgf users
	 * @return the dgf users that was added
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsers addDgfUsers(
		bd.gov.dgfood.food.grain.license.model.DgfUsers dgfUsers) {

		return _dgfUsersLocalService.addDgfUsers(dgfUsers);
	}

	@Override
	public void addDgfUsersInfo(String name, String phoneNo, String nidNo) {
		_dgfUsersLocalService.addDgfUsersInfo(name, phoneNo, nidNo);
	}

	/**
	 * Creates a new dgf users with the primary key. Does not add the dgf users to the database.
	 *
	 * @param userId the primary key for the new dgf users
	 * @return the new dgf users
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsers createDgfUsers(
		long userId) {

		return _dgfUsersLocalService.createDgfUsers(userId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the dgf users from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsers the dgf users
	 * @return the dgf users that was removed
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsers deleteDgfUsers(
		bd.gov.dgfood.food.grain.license.model.DgfUsers dgfUsers) {

		return _dgfUsersLocalService.deleteDgfUsers(dgfUsers);
	}

	/**
	 * Deletes the dgf users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userId the primary key of the dgf users
	 * @return the dgf users that was removed
	 * @throws PortalException if a dgf users with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsers deleteDgfUsers(
			long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersLocalService.deleteDgfUsers(userId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgfUsersLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgfUsersLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgfUsersLocalService.dynamicQuery();
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

		return _dgfUsersLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersModelImpl</code>.
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

		return _dgfUsersLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersModelImpl</code>.
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

		return _dgfUsersLocalService.dynamicQuery(
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

		return _dgfUsersLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dgfUsersLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsers fetchDgfUsers(
		long userId) {

		return _dgfUsersLocalService.fetchDgfUsers(userId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgfUsersLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<bd.gov.dgfood.food.grain.license.model.DgfUsers>
			getDgfAcfUsersByDistrict(long districtId, long companyId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersException {

		return _dgfUsersLocalService.getDgfAcfUsersByDistrict(
			districtId, companyId);
	}

	@Override
	public java.util.List<bd.gov.dgfood.food.grain.license.model.DgfUsers>
			getDgfCcdrUsersByUpazila(long upazilaId, long companyId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersException {

		return _dgfUsersLocalService.getDgfCcdrUsersByUpazila(
			upazilaId, companyId);
	}

	@Override
	public java.util.List<bd.gov.dgfood.food.grain.license.model.DgfUsers>
			getDgfDcfUsersByDistrict(long districtId, long companyId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersException {

		return _dgfUsersLocalService.getDgfDcfUsersByDistrict(
			districtId, companyId);
	}

	@Override
	public java.util.List<bd.gov.dgfood.food.grain.license.model.DgfUsers>
			getDgfRcfUsersByUpazila(long upazilaId, long companyId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersException {

		return _dgfUsersLocalService.getDgfRcfUsersByUpazila(
			upazilaId, companyId);
	}

	@Override
	public java.util.List<bd.gov.dgfood.food.grain.license.model.DgfUsers>
			getDgfUcfUsersByDistrict(long upazilaId, long companyId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersException {

		return _dgfUsersLocalService.getDgfUcfUsersByDistrict(
			upazilaId, companyId);
	}

	/**
	 * Returns the dgf users with the primary key.
	 *
	 * @param userId the primary key of the dgf users
	 * @return the dgf users
	 * @throws PortalException if a dgf users with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsers getDgfUsers(
			long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersLocalService.getDgfUsers(userId);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsers getDgfUsersByNid(
			String nationalId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersException {

		return _dgfUsersLocalService.getDgfUsersByNid(nationalId);
	}

	/**
	 * Returns a range of all the dgf userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @return the range of dgf userses
	 */
	@Override
	public java.util.List<bd.gov.dgfood.food.grain.license.model.DgfUsers>
		getDgfUserses(int start, int end) {

		return _dgfUsersLocalService.getDgfUserses(start, end);
	}

	/**
	 * Returns the number of dgf userses.
	 *
	 * @return the number of dgf userses
	 */
	@Override
	public int getDgfUsersesCount() {
		return _dgfUsersLocalService.getDgfUsersesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgfUsersLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfUsersLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the dgf users in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsers the dgf users
	 * @return the dgf users that was updated
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsers updateDgfUsers(
		bd.gov.dgfood.food.grain.license.model.DgfUsers dgfUsers) {

		return _dgfUsersLocalService.updateDgfUsers(dgfUsers);
	}

	@Override
	public DgfUsersLocalService getWrappedService() {
		return _dgfUsersLocalService;
	}

	@Override
	public void setWrappedService(DgfUsersLocalService dgfUsersLocalService) {
		_dgfUsersLocalService = dgfUsersLocalService;
	}

	private DgfUsersLocalService _dgfUsersLocalService;

}