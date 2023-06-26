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
 * Provides a wrapper for {@link DgfFglProductDtlsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfFglProductDtlsLocalService
 * @generated
 */
public class DgfFglProductDtlsLocalServiceWrapper
	implements DgfFglProductDtlsLocalService,
			   ServiceWrapper<DgfFglProductDtlsLocalService> {

	public DgfFglProductDtlsLocalServiceWrapper() {
		this(null);
	}

	public DgfFglProductDtlsLocalServiceWrapper(
		DgfFglProductDtlsLocalService dgfFglProductDtlsLocalService) {

		_dgfFglProductDtlsLocalService = dgfFglProductDtlsLocalService;
	}

	/**
	 * Adds the dgf fgl product dtls to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfFglProductDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfFglProductDtls the dgf fgl product dtls
	 * @return the dgf fgl product dtls that was added
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglProductDtls
		addDgfFglProductDtls(
			bd.gov.dgfood.food.grain.license.model.DgfFglProductDtls
				dgfFglProductDtls) {

		return _dgfFglProductDtlsLocalService.addDgfFglProductDtls(
			dgfFglProductDtls);
	}

	/**
	 * Creates a new dgf fgl product dtls with the primary key. Does not add the dgf fgl product dtls to the database.
	 *
	 * @param fglProductPrimaryId the primary key for the new dgf fgl product dtls
	 * @return the new dgf fgl product dtls
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglProductDtls
		createDgfFglProductDtls(long fglProductPrimaryId) {

		return _dgfFglProductDtlsLocalService.createDgfFglProductDtls(
			fglProductPrimaryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfFglProductDtlsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the dgf fgl product dtls from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfFglProductDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfFglProductDtls the dgf fgl product dtls
	 * @return the dgf fgl product dtls that was removed
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglProductDtls
		deleteDgfFglProductDtls(
			bd.gov.dgfood.food.grain.license.model.DgfFglProductDtls
				dgfFglProductDtls) {

		return _dgfFglProductDtlsLocalService.deleteDgfFglProductDtls(
			dgfFglProductDtls);
	}

	/**
	 * Deletes the dgf fgl product dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfFglProductDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fglProductPrimaryId the primary key of the dgf fgl product dtls
	 * @return the dgf fgl product dtls that was removed
	 * @throws PortalException if a dgf fgl product dtls with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglProductDtls
			deleteDgfFglProductDtls(long fglProductPrimaryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfFglProductDtlsLocalService.deleteDgfFglProductDtls(
			fglProductPrimaryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfFglProductDtlsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgfFglProductDtlsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgfFglProductDtlsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgfFglProductDtlsLocalService.dynamicQuery();
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

		return _dgfFglProductDtlsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfFglProductDtlsModelImpl</code>.
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

		return _dgfFglProductDtlsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfFglProductDtlsModelImpl</code>.
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

		return _dgfFglProductDtlsLocalService.dynamicQuery(
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

		return _dgfFglProductDtlsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dgfFglProductDtlsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglProductDtls
		fetchDgfFglProductDtls(long fglProductPrimaryId) {

		return _dgfFglProductDtlsLocalService.fetchDgfFglProductDtls(
			fglProductPrimaryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgfFglProductDtlsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the dgf fgl product dtls with the primary key.
	 *
	 * @param fglProductPrimaryId the primary key of the dgf fgl product dtls
	 * @return the dgf fgl product dtls
	 * @throws PortalException if a dgf fgl product dtls with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglProductDtls
			getDgfFglProductDtls(long fglProductPrimaryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfFglProductDtlsLocalService.getDgfFglProductDtls(
			fglProductPrimaryId);
	}

	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.DgfFglProductDtls>
			getDgfFglProductDtlsByFglLicPrimaryId(long fglLicPrimaryId) {

		return _dgfFglProductDtlsLocalService.
			getDgfFglProductDtlsByFglLicPrimaryId(fglLicPrimaryId);
	}

	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.DgfFglProductDtls>
			getDgfFglProductDtlsByNationalId(String nationalId) {

		return _dgfFglProductDtlsLocalService.getDgfFglProductDtlsByNationalId(
			nationalId);
	}

	/**
	 * Returns a range of all the dgf fgl product dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfFglProductDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl product dtlses
	 * @param end the upper bound of the range of dgf fgl product dtlses (not inclusive)
	 * @return the range of dgf fgl product dtlses
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.DgfFglProductDtls>
			getDgfFglProductDtlses(int start, int end) {

		return _dgfFglProductDtlsLocalService.getDgfFglProductDtlses(
			start, end);
	}

	/**
	 * Returns the number of dgf fgl product dtlses.
	 *
	 * @return the number of dgf fgl product dtlses
	 */
	@Override
	public int getDgfFglProductDtlsesCount() {
		return _dgfFglProductDtlsLocalService.getDgfFglProductDtlsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgfFglProductDtlsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfFglProductDtlsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfFglProductDtlsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the dgf fgl product dtls in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfFglProductDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfFglProductDtls the dgf fgl product dtls
	 * @return the dgf fgl product dtls that was updated
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglProductDtls
		updateDgfFglProductDtls(
			bd.gov.dgfood.food.grain.license.model.DgfFglProductDtls
				dgfFglProductDtls) {

		return _dgfFglProductDtlsLocalService.updateDgfFglProductDtls(
			dgfFglProductDtls);
	}

	@Override
	public DgfFglProductDtlsLocalService getWrappedService() {
		return _dgfFglProductDtlsLocalService;
	}

	@Override
	public void setWrappedService(
		DgfFglProductDtlsLocalService dgfFglProductDtlsLocalService) {

		_dgfFglProductDtlsLocalService = dgfFglProductDtlsLocalService;
	}

	private DgfFglProductDtlsLocalService _dgfFglProductDtlsLocalService;

}