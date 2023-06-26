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
 * Provides a wrapper for {@link DgfBussAddrDtlsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfBussAddrDtlsLocalService
 * @generated
 */
public class DgfBussAddrDtlsLocalServiceWrapper
	implements DgfBussAddrDtlsLocalService,
			   ServiceWrapper<DgfBussAddrDtlsLocalService> {

	public DgfBussAddrDtlsLocalServiceWrapper() {
		this(null);
	}

	public DgfBussAddrDtlsLocalServiceWrapper(
		DgfBussAddrDtlsLocalService dgfBussAddrDtlsLocalService) {

		_dgfBussAddrDtlsLocalService = dgfBussAddrDtlsLocalService;
	}

	/**
	 * Adds the dgf buss addr dtls to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfBussAddrDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfBussAddrDtls the dgf buss addr dtls
	 * @return the dgf buss addr dtls that was added
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfBussAddrDtls
		addDgfBussAddrDtls(
			bd.gov.dgfood.food.grain.license.model.DgfBussAddrDtls
				dgfBussAddrDtls) {

		return _dgfBussAddrDtlsLocalService.addDgfBussAddrDtls(dgfBussAddrDtls);
	}

	/**
	 * Creates a new dgf buss addr dtls with the primary key. Does not add the dgf buss addr dtls to the database.
	 *
	 * @param businessAddressId the primary key for the new dgf buss addr dtls
	 * @return the new dgf buss addr dtls
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfBussAddrDtls
		createDgfBussAddrDtls(long businessAddressId) {

		return _dgfBussAddrDtlsLocalService.createDgfBussAddrDtls(
			businessAddressId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfBussAddrDtlsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the dgf buss addr dtls from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfBussAddrDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfBussAddrDtls the dgf buss addr dtls
	 * @return the dgf buss addr dtls that was removed
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfBussAddrDtls
		deleteDgfBussAddrDtls(
			bd.gov.dgfood.food.grain.license.model.DgfBussAddrDtls
				dgfBussAddrDtls) {

		return _dgfBussAddrDtlsLocalService.deleteDgfBussAddrDtls(
			dgfBussAddrDtls);
	}

	/**
	 * Deletes the dgf buss addr dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfBussAddrDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param businessAddressId the primary key of the dgf buss addr dtls
	 * @return the dgf buss addr dtls that was removed
	 * @throws PortalException if a dgf buss addr dtls with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfBussAddrDtls
			deleteDgfBussAddrDtls(long businessAddressId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfBussAddrDtlsLocalService.deleteDgfBussAddrDtls(
			businessAddressId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfBussAddrDtlsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgfBussAddrDtlsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgfBussAddrDtlsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgfBussAddrDtlsLocalService.dynamicQuery();
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

		return _dgfBussAddrDtlsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfBussAddrDtlsModelImpl</code>.
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

		return _dgfBussAddrDtlsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfBussAddrDtlsModelImpl</code>.
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

		return _dgfBussAddrDtlsLocalService.dynamicQuery(
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

		return _dgfBussAddrDtlsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dgfBussAddrDtlsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfBussAddrDtls
		fetchDgfBussAddrDtls(long businessAddressId) {

		return _dgfBussAddrDtlsLocalService.fetchDgfBussAddrDtls(
			businessAddressId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgfBussAddrDtlsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the dgf buss addr dtls with the primary key.
	 *
	 * @param businessAddressId the primary key of the dgf buss addr dtls
	 * @return the dgf buss addr dtls
	 * @throws PortalException if a dgf buss addr dtls with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfBussAddrDtls
			getDgfBussAddrDtls(long businessAddressId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfBussAddrDtlsLocalService.getDgfBussAddrDtls(
			businessAddressId);
	}

	/**
	 * Returns a range of all the dgf buss addr dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfBussAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf buss addr dtlses
	 * @param end the upper bound of the range of dgf buss addr dtlses (not inclusive)
	 * @return the range of dgf buss addr dtlses
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.DgfBussAddrDtls>
			getDgfBussAddrDtlses(int start, int end) {

		return _dgfBussAddrDtlsLocalService.getDgfBussAddrDtlses(start, end);
	}

	/**
	 * Returns the number of dgf buss addr dtlses.
	 *
	 * @return the number of dgf buss addr dtlses
	 */
	@Override
	public int getDgfBussAddrDtlsesCount() {
		return _dgfBussAddrDtlsLocalService.getDgfBussAddrDtlsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgfBussAddrDtlsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfBussAddrDtlsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfBussAddrDtlsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the dgf buss addr dtls in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfBussAddrDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfBussAddrDtls the dgf buss addr dtls
	 * @return the dgf buss addr dtls that was updated
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfBussAddrDtls
		updateDgfBussAddrDtls(
			bd.gov.dgfood.food.grain.license.model.DgfBussAddrDtls
				dgfBussAddrDtls) {

		return _dgfBussAddrDtlsLocalService.updateDgfBussAddrDtls(
			dgfBussAddrDtls);
	}

	@Override
	public DgfBussAddrDtlsLocalService getWrappedService() {
		return _dgfBussAddrDtlsLocalService;
	}

	@Override
	public void setWrappedService(
		DgfBussAddrDtlsLocalService dgfBussAddrDtlsLocalService) {

		_dgfBussAddrDtlsLocalService = dgfBussAddrDtlsLocalService;
	}

	private DgfBussAddrDtlsLocalService _dgfBussAddrDtlsLocalService;

}