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
 * Provides a wrapper for {@link DgfStoreDtlsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfStoreDtlsLocalService
 * @generated
 */
public class DgfStoreDtlsLocalServiceWrapper
	implements DgfStoreDtlsLocalService,
			   ServiceWrapper<DgfStoreDtlsLocalService> {

	public DgfStoreDtlsLocalServiceWrapper() {
		this(null);
	}

	public DgfStoreDtlsLocalServiceWrapper(
		DgfStoreDtlsLocalService dgfStoreDtlsLocalService) {

		_dgfStoreDtlsLocalService = dgfStoreDtlsLocalService;
	}

	/**
	 * Adds the dgf store dtls to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfStoreDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfStoreDtls the dgf store dtls
	 * @return the dgf store dtls that was added
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfStoreDtls addDgfStoreDtls(
		bd.gov.dgfood.food.grain.license.model.DgfStoreDtls dgfStoreDtls) {

		return _dgfStoreDtlsLocalService.addDgfStoreDtls(dgfStoreDtls);
	}

	/**
	 * Creates a new dgf store dtls with the primary key. Does not add the dgf store dtls to the database.
	 *
	 * @param id the primary key for the new dgf store dtls
	 * @return the new dgf store dtls
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfStoreDtls
		createDgfStoreDtls(long id) {

		return _dgfStoreDtlsLocalService.createDgfStoreDtls(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfStoreDtlsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the dgf store dtls from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfStoreDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfStoreDtls the dgf store dtls
	 * @return the dgf store dtls that was removed
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfStoreDtls
		deleteDgfStoreDtls(
			bd.gov.dgfood.food.grain.license.model.DgfStoreDtls dgfStoreDtls) {

		return _dgfStoreDtlsLocalService.deleteDgfStoreDtls(dgfStoreDtls);
	}

	/**
	 * Deletes the dgf store dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfStoreDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the dgf store dtls
	 * @return the dgf store dtls that was removed
	 * @throws PortalException if a dgf store dtls with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfStoreDtls
			deleteDgfStoreDtls(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfStoreDtlsLocalService.deleteDgfStoreDtls(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfStoreDtlsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgfStoreDtlsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgfStoreDtlsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgfStoreDtlsLocalService.dynamicQuery();
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

		return _dgfStoreDtlsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfStoreDtlsModelImpl</code>.
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

		return _dgfStoreDtlsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfStoreDtlsModelImpl</code>.
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

		return _dgfStoreDtlsLocalService.dynamicQuery(
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

		return _dgfStoreDtlsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dgfStoreDtlsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfStoreDtls
		fetchDgfStoreDtls(long id) {

		return _dgfStoreDtlsLocalService.fetchDgfStoreDtls(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgfStoreDtlsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the dgf store dtls with the primary key.
	 *
	 * @param id the primary key of the dgf store dtls
	 * @return the dgf store dtls
	 * @throws PortalException if a dgf store dtls with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfStoreDtls getDgfStoreDtls(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfStoreDtlsLocalService.getDgfStoreDtls(id);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfStoreDtls
		getDgfStoreDtlsByNid(String nationalId) {

		return _dgfStoreDtlsLocalService.getDgfStoreDtlsByNid(nationalId);
	}

	/**
	 * Returns a range of all the dgf store dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfStoreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf store dtlses
	 * @param end the upper bound of the range of dgf store dtlses (not inclusive)
	 * @return the range of dgf store dtlses
	 */
	@Override
	public java.util.List<bd.gov.dgfood.food.grain.license.model.DgfStoreDtls>
		getDgfStoreDtlses(int start, int end) {

		return _dgfStoreDtlsLocalService.getDgfStoreDtlses(start, end);
	}

	/**
	 * Returns the number of dgf store dtlses.
	 *
	 * @return the number of dgf store dtlses
	 */
	@Override
	public int getDgfStoreDtlsesCount() {
		return _dgfStoreDtlsLocalService.getDgfStoreDtlsesCount();
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfStoreDtls
		getDgfStoreDtlsFindByType(String type) {

		return _dgfStoreDtlsLocalService.getDgfStoreDtlsFindByType(type);
	}

	@Override
	public java.util.List<bd.gov.dgfood.food.grain.license.model.DgfStoreDtls>
		getDgfStoreDtlsListByNid(String nationalId) {

		return _dgfStoreDtlsLocalService.getDgfStoreDtlsListByNid(nationalId);
	}

	@Override
	public java.util.List<bd.gov.dgfood.food.grain.license.model.DgfStoreDtls>
		getDgfStoreDtlsListFindByType(String type) {

		return _dgfStoreDtlsLocalService.getDgfStoreDtlsListFindByType(type);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgfStoreDtlsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfStoreDtlsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfStoreDtlsLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.Map<Long, Object> getUserStoreAddrs(String nationalId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfStoreDtlsLocalService.getUserStoreAddrs(nationalId);
	}

	/**
	 * Updates the dgf store dtls in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfStoreDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfStoreDtls the dgf store dtls
	 * @return the dgf store dtls that was updated
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfStoreDtls
		updateDgfStoreDtls(
			bd.gov.dgfood.food.grain.license.model.DgfStoreDtls dgfStoreDtls) {

		return _dgfStoreDtlsLocalService.updateDgfStoreDtls(dgfStoreDtls);
	}

	@Override
	public DgfStoreDtlsLocalService getWrappedService() {
		return _dgfStoreDtlsLocalService;
	}

	@Override
	public void setWrappedService(
		DgfStoreDtlsLocalService dgfStoreDtlsLocalService) {

		_dgfStoreDtlsLocalService = dgfStoreDtlsLocalService;
	}

	private DgfStoreDtlsLocalService _dgfStoreDtlsLocalService;

}