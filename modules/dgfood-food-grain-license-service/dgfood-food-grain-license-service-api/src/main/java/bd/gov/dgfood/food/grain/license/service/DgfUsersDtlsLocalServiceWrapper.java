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
 * Provides a wrapper for {@link DgfUsersDtlsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersDtlsLocalService
 * @generated
 */
public class DgfUsersDtlsLocalServiceWrapper
	implements DgfUsersDtlsLocalService,
			   ServiceWrapper<DgfUsersDtlsLocalService> {

	public DgfUsersDtlsLocalServiceWrapper() {
		this(null);
	}

	public DgfUsersDtlsLocalServiceWrapper(
		DgfUsersDtlsLocalService dgfUsersDtlsLocalService) {

		_dgfUsersDtlsLocalService = dgfUsersDtlsLocalService;
	}

	/**
	 * Adds the dgf users dtls to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsersDtls the dgf users dtls
	 * @return the dgf users dtls that was added
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersDtls addDgfUsersDtls(
		bd.gov.dgfood.food.grain.license.model.DgfUsersDtls dgfUsersDtls) {

		return _dgfUsersDtlsLocalService.addDgfUsersDtls(dgfUsersDtls);
	}

	/**
	 * Creates a new dgf users dtls with the primary key. Does not add the dgf users dtls to the database.
	 *
	 * @param userDetailsId the primary key for the new dgf users dtls
	 * @return the new dgf users dtls
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersDtls
		createDgfUsersDtls(long userDetailsId) {

		return _dgfUsersDtlsLocalService.createDgfUsersDtls(userDetailsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersDtlsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the dgf users dtls from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsersDtls the dgf users dtls
	 * @return the dgf users dtls that was removed
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersDtls
		deleteDgfUsersDtls(
			bd.gov.dgfood.food.grain.license.model.DgfUsersDtls dgfUsersDtls) {

		return _dgfUsersDtlsLocalService.deleteDgfUsersDtls(dgfUsersDtls);
	}

	/**
	 * Deletes the dgf users dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userDetailsId the primary key of the dgf users dtls
	 * @return the dgf users dtls that was removed
	 * @throws PortalException if a dgf users dtls with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersDtls
			deleteDgfUsersDtls(long userDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersDtlsLocalService.deleteDgfUsersDtls(userDetailsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersDtlsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgfUsersDtlsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgfUsersDtlsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgfUsersDtlsLocalService.dynamicQuery();
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

		return _dgfUsersDtlsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersDtlsModelImpl</code>.
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

		return _dgfUsersDtlsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersDtlsModelImpl</code>.
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

		return _dgfUsersDtlsLocalService.dynamicQuery(
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

		return _dgfUsersDtlsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dgfUsersDtlsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersDtls
		fetchDgfUsersDtls(long userDetailsId) {

		return _dgfUsersDtlsLocalService.fetchDgfUsersDtls(userDetailsId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgfUsersDtlsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the dgf users dtls with the primary key.
	 *
	 * @param userDetailsId the primary key of the dgf users dtls
	 * @return the dgf users dtls
	 * @throws PortalException if a dgf users dtls with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersDtls getDgfUsersDtls(
			long userDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersDtlsLocalService.getDgfUsersDtls(userDetailsId);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersDtls
		getDgfUsersDtlsByNationalId(long nationalId) {

		return _dgfUsersDtlsLocalService.getDgfUsersDtlsByNationalId(
			nationalId);
	}

	/**
	 * Returns a range of all the dgf users dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users dtlses
	 * @param end the upper bound of the range of dgf users dtlses (not inclusive)
	 * @return the range of dgf users dtlses
	 */
	@Override
	public java.util.List<bd.gov.dgfood.food.grain.license.model.DgfUsersDtls>
		getDgfUsersDtlses(int start, int end) {

		return _dgfUsersDtlsLocalService.getDgfUsersDtlses(start, end);
	}

	/**
	 * Returns the number of dgf users dtlses.
	 *
	 * @return the number of dgf users dtlses
	 */
	@Override
	public int getDgfUsersDtlsesCount() {
		return _dgfUsersDtlsLocalService.getDgfUsersDtlsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgfUsersDtlsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfUsersDtlsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersDtlsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the dgf users dtls in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsersDtls the dgf users dtls
	 * @return the dgf users dtls that was updated
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersDtls
		updateDgfUsersDtls(
			bd.gov.dgfood.food.grain.license.model.DgfUsersDtls dgfUsersDtls) {

		return _dgfUsersDtlsLocalService.updateDgfUsersDtls(dgfUsersDtls);
	}

	@Override
	public DgfUsersDtlsLocalService getWrappedService() {
		return _dgfUsersDtlsLocalService;
	}

	@Override
	public void setWrappedService(
		DgfUsersDtlsLocalService dgfUsersDtlsLocalService) {

		_dgfUsersDtlsLocalService = dgfUsersDtlsLocalService;
	}

	private DgfUsersDtlsLocalService _dgfUsersDtlsLocalService;

}