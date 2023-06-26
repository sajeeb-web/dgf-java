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
 * Provides a wrapper for {@link DgfUsersAddrDtlsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersAddrDtlsLocalService
 * @generated
 */
public class DgfUsersAddrDtlsLocalServiceWrapper
	implements DgfUsersAddrDtlsLocalService,
			   ServiceWrapper<DgfUsersAddrDtlsLocalService> {

	public DgfUsersAddrDtlsLocalServiceWrapper() {
		this(null);
	}

	public DgfUsersAddrDtlsLocalServiceWrapper(
		DgfUsersAddrDtlsLocalService dgfUsersAddrDtlsLocalService) {

		_dgfUsersAddrDtlsLocalService = dgfUsersAddrDtlsLocalService;
	}

	/**
	 * Adds the dgf users addr dtls to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersAddrDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsersAddrDtls the dgf users addr dtls
	 * @return the dgf users addr dtls that was added
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls
		addDgfUsersAddrDtls(
			bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls
				dgfUsersAddrDtls) {

		return _dgfUsersAddrDtlsLocalService.addDgfUsersAddrDtls(
			dgfUsersAddrDtls);
	}

	/**
	 * Creates a new dgf users addr dtls with the primary key. Does not add the dgf users addr dtls to the database.
	 *
	 * @param addressId the primary key for the new dgf users addr dtls
	 * @return the new dgf users addr dtls
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls
		createDgfUsersAddrDtls(long addressId) {

		return _dgfUsersAddrDtlsLocalService.createDgfUsersAddrDtls(addressId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersAddrDtlsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the dgf users addr dtls from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersAddrDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsersAddrDtls the dgf users addr dtls
	 * @return the dgf users addr dtls that was removed
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls
		deleteDgfUsersAddrDtls(
			bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls
				dgfUsersAddrDtls) {

		return _dgfUsersAddrDtlsLocalService.deleteDgfUsersAddrDtls(
			dgfUsersAddrDtls);
	}

	/**
	 * Deletes the dgf users addr dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersAddrDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param addressId the primary key of the dgf users addr dtls
	 * @return the dgf users addr dtls that was removed
	 * @throws PortalException if a dgf users addr dtls with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls
			deleteDgfUsersAddrDtls(long addressId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersAddrDtlsLocalService.deleteDgfUsersAddrDtls(addressId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersAddrDtlsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgfUsersAddrDtlsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgfUsersAddrDtlsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgfUsersAddrDtlsLocalService.dynamicQuery();
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

		return _dgfUsersAddrDtlsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersAddrDtlsModelImpl</code>.
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

		return _dgfUsersAddrDtlsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersAddrDtlsModelImpl</code>.
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

		return _dgfUsersAddrDtlsLocalService.dynamicQuery(
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

		return _dgfUsersAddrDtlsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dgfUsersAddrDtlsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls
		fetchDgfUsersAddrDtls(long addressId) {

		return _dgfUsersAddrDtlsLocalService.fetchDgfUsersAddrDtls(addressId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgfUsersAddrDtlsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the dgf users addr dtls with the primary key.
	 *
	 * @param addressId the primary key of the dgf users addr dtls
	 * @return the dgf users addr dtls
	 * @throws PortalException if a dgf users addr dtls with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls
			getDgfUsersAddrDtls(long addressId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersAddrDtlsLocalService.getDgfUsersAddrDtls(addressId);
	}

	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls>
			getDgfUsersAddrDtlsByDivisionAndDistrict(
				long division, long district) {

		return _dgfUsersAddrDtlsLocalService.
			getDgfUsersAddrDtlsByDivisionAndDistrict(division, district);
	}

	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls>
			getDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
				long division, long district, long upzilla) {

		return _dgfUsersAddrDtlsLocalService.
			getDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
				division, district, upzilla);
	}

	/**
	 * Returns a range of all the dgf users addr dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @return the range of dgf users addr dtlses
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls>
			getDgfUsersAddrDtlses(int start, int end) {

		return _dgfUsersAddrDtlsLocalService.getDgfUsersAddrDtlses(start, end);
	}

	/**
	 * Returns the number of dgf users addr dtlses.
	 *
	 * @return the number of dgf users addr dtlses
	 */
	@Override
	public int getDgfUsersAddrDtlsesCount() {
		return _dgfUsersAddrDtlsLocalService.getDgfUsersAddrDtlsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgfUsersAddrDtlsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfUsersAddrDtlsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersAddrDtlsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the dgf users addr dtls in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersAddrDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsersAddrDtls the dgf users addr dtls
	 * @return the dgf users addr dtls that was updated
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls
		updateDgfUsersAddrDtls(
			bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls
				dgfUsersAddrDtls) {

		return _dgfUsersAddrDtlsLocalService.updateDgfUsersAddrDtls(
			dgfUsersAddrDtls);
	}

	@Override
	public DgfUsersAddrDtlsLocalService getWrappedService() {
		return _dgfUsersAddrDtlsLocalService;
	}

	@Override
	public void setWrappedService(
		DgfUsersAddrDtlsLocalService dgfUsersAddrDtlsLocalService) {

		_dgfUsersAddrDtlsLocalService = dgfUsersAddrDtlsLocalService;
	}

	private DgfUsersAddrDtlsLocalService _dgfUsersAddrDtlsLocalService;

}