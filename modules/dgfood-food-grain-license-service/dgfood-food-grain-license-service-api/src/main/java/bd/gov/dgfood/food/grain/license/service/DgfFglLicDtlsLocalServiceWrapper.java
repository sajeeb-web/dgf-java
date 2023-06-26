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
 * Provides a wrapper for {@link DgfFglLicDtlsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfFglLicDtlsLocalService
 * @generated
 */
public class DgfFglLicDtlsLocalServiceWrapper
	implements DgfFglLicDtlsLocalService,
			   ServiceWrapper<DgfFglLicDtlsLocalService> {

	public DgfFglLicDtlsLocalServiceWrapper() {
		this(null);
	}

	public DgfFglLicDtlsLocalServiceWrapper(
		DgfFglLicDtlsLocalService dgfFglLicDtlsLocalService) {

		_dgfFglLicDtlsLocalService = dgfFglLicDtlsLocalService;
	}

	/**
	 * Adds the dgf fgl lic dtls to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfFglLicDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfFglLicDtls the dgf fgl lic dtls
	 * @return the dgf fgl lic dtls that was added
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls
		addDgfFglLicDtls(
			bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls
				dgfFglLicDtls) {

		return _dgfFglLicDtlsLocalService.addDgfFglLicDtls(dgfFglLicDtls);
	}

	/**
	 * Creates a new dgf fgl lic dtls with the primary key. Does not add the dgf fgl lic dtls to the database.
	 *
	 * @param fglLicPrimaryId the primary key for the new dgf fgl lic dtls
	 * @return the new dgf fgl lic dtls
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls
		createDgfFglLicDtls(long fglLicPrimaryId) {

		return _dgfFglLicDtlsLocalService.createDgfFglLicDtls(fglLicPrimaryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfFglLicDtlsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the dgf fgl lic dtls from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfFglLicDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfFglLicDtls the dgf fgl lic dtls
	 * @return the dgf fgl lic dtls that was removed
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls
		deleteDgfFglLicDtls(
			bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls
				dgfFglLicDtls) {

		return _dgfFglLicDtlsLocalService.deleteDgfFglLicDtls(dgfFglLicDtls);
	}

	/**
	 * Deletes the dgf fgl lic dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfFglLicDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fglLicPrimaryId the primary key of the dgf fgl lic dtls
	 * @return the dgf fgl lic dtls that was removed
	 * @throws PortalException if a dgf fgl lic dtls with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls
			deleteDgfFglLicDtls(long fglLicPrimaryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfFglLicDtlsLocalService.deleteDgfFglLicDtls(fglLicPrimaryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfFglLicDtlsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgfFglLicDtlsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgfFglLicDtlsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgfFglLicDtlsLocalService.dynamicQuery();
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

		return _dgfFglLicDtlsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfFglLicDtlsModelImpl</code>.
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

		return _dgfFglLicDtlsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfFglLicDtlsModelImpl</code>.
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

		return _dgfFglLicDtlsLocalService.dynamicQuery(
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

		return _dgfFglLicDtlsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dgfFglLicDtlsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls
		fetchDgfFglLicDtls(long fglLicPrimaryId) {

		return _dgfFglLicDtlsLocalService.fetchDgfFglLicDtls(fglLicPrimaryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgfFglLicDtlsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the dgf fgl lic dtls with the primary key.
	 *
	 * @param fglLicPrimaryId the primary key of the dgf fgl lic dtls
	 * @return the dgf fgl lic dtls
	 * @throws PortalException if a dgf fgl lic dtls with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls
			getDgfFglLicDtls(long fglLicPrimaryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfFglLicDtlsLocalService.getDgfFglLicDtls(fglLicPrimaryId);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls
		getDgfFglLicDtlsByFglApplicationNo(String fglApplicationNo) {

		return _dgfFglLicDtlsLocalService.getDgfFglLicDtlsByFglApplicationNo(
			fglApplicationNo);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls
		getDgfFglLicDtlsByFglLicNo(String licenseNo) {

		return _dgfFglLicDtlsLocalService.getDgfFglLicDtlsByFglLicNo(licenseNo);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls
		getDgfFglLicDtlsByFglPrePrimaryId(long fglPrePrimaryId) {

		return _dgfFglLicDtlsLocalService.getDgfFglLicDtlsByFglPrePrimaryId(
			fglPrePrimaryId);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls
		getDgfFglLicDtlsByNid(String nationalId) {

		return _dgfFglLicDtlsLocalService.getDgfFglLicDtlsByNid(nationalId);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls
		getDgfFglLicDtlsByNidAndFglLicNo(String nationalId, String licenseNo) {

		return _dgfFglLicDtlsLocalService.getDgfFglLicDtlsByNidAndFglLicNo(
			nationalId, licenseNo);
	}

	/**
	 * Returns a range of all the dgf fgl lic dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfFglLicDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl lic dtlses
	 * @param end the upper bound of the range of dgf fgl lic dtlses (not inclusive)
	 * @return the range of dgf fgl lic dtlses
	 */
	@Override
	public java.util.List<bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls>
		getDgfFglLicDtlses(int start, int end) {

		return _dgfFglLicDtlsLocalService.getDgfFglLicDtlses(start, end);
	}

	/**
	 * Returns the number of dgf fgl lic dtlses.
	 *
	 * @return the number of dgf fgl lic dtlses
	 */
	@Override
	public int getDgfFglLicDtlsesCount() {
		return _dgfFglLicDtlsLocalService.getDgfFglLicDtlsesCount();
	}

	@Override
	public java.util.List<bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls>
		getDgfFglLicDtlsListByNid(String nid) {

		return _dgfFglLicDtlsLocalService.getDgfFglLicDtlsListByNid(nid);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgfFglLicDtlsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfFglLicDtlsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfFglLicDtlsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the dgf fgl lic dtls in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfFglLicDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfFglLicDtls the dgf fgl lic dtls
	 * @return the dgf fgl lic dtls that was updated
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls
		updateDgfFglLicDtls(
			bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls
				dgfFglLicDtls) {

		return _dgfFglLicDtlsLocalService.updateDgfFglLicDtls(dgfFglLicDtls);
	}

	@Override
	public DgfFglLicDtlsLocalService getWrappedService() {
		return _dgfFglLicDtlsLocalService;
	}

	@Override
	public void setWrappedService(
		DgfFglLicDtlsLocalService dgfFglLicDtlsLocalService) {

		_dgfFglLicDtlsLocalService = dgfFglLicDtlsLocalService;
	}

	private DgfFglLicDtlsLocalService _dgfFglLicDtlsLocalService;

}