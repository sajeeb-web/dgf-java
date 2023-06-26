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
 * Provides a wrapper for {@link DgfDlrDistributionDtlsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrDistributionDtlsLocalService
 * @generated
 */
public class DgfDlrDistributionDtlsLocalServiceWrapper
	implements DgfDlrDistributionDtlsLocalService,
			   ServiceWrapper<DgfDlrDistributionDtlsLocalService> {

	public DgfDlrDistributionDtlsLocalServiceWrapper() {
		this(null);
	}

	public DgfDlrDistributionDtlsLocalServiceWrapper(
		DgfDlrDistributionDtlsLocalService dgfDlrDistributionDtlsLocalService) {

		_dgfDlrDistributionDtlsLocalService =
			dgfDlrDistributionDtlsLocalService;
	}

	/**
	 * Adds the dgf dlr distribution dtls to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrDistributionDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDlrDistributionDtls the dgf dlr distribution dtls
	 * @return the dgf dlr distribution dtls that was added
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfDlrDistributionDtls
		addDgfDlrDistributionDtls(
			bd.gov.dgfood.food.grain.license.model.DgfDlrDistributionDtls
				dgfDlrDistributionDtls) {

		return _dgfDlrDistributionDtlsLocalService.addDgfDlrDistributionDtls(
			dgfDlrDistributionDtls);
	}

	/**
	 * Creates a new dgf dlr distribution dtls with the primary key. Does not add the dgf dlr distribution dtls to the database.
	 *
	 * @param id the primary key for the new dgf dlr distribution dtls
	 * @return the new dgf dlr distribution dtls
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfDlrDistributionDtls
		createDgfDlrDistributionDtls(long id) {

		return _dgfDlrDistributionDtlsLocalService.createDgfDlrDistributionDtls(
			id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrDistributionDtlsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the dgf dlr distribution dtls from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrDistributionDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDlrDistributionDtls the dgf dlr distribution dtls
	 * @return the dgf dlr distribution dtls that was removed
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfDlrDistributionDtls
		deleteDgfDlrDistributionDtls(
			bd.gov.dgfood.food.grain.license.model.DgfDlrDistributionDtls
				dgfDlrDistributionDtls) {

		return _dgfDlrDistributionDtlsLocalService.deleteDgfDlrDistributionDtls(
			dgfDlrDistributionDtls);
	}

	/**
	 * Deletes the dgf dlr distribution dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrDistributionDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the dgf dlr distribution dtls
	 * @return the dgf dlr distribution dtls that was removed
	 * @throws PortalException if a dgf dlr distribution dtls with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfDlrDistributionDtls
			deleteDgfDlrDistributionDtls(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrDistributionDtlsLocalService.deleteDgfDlrDistributionDtls(
			id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrDistributionDtlsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgfDlrDistributionDtlsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgfDlrDistributionDtlsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgfDlrDistributionDtlsLocalService.dynamicQuery();
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

		return _dgfDlrDistributionDtlsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfDlrDistributionDtlsModelImpl</code>.
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

		return _dgfDlrDistributionDtlsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfDlrDistributionDtlsModelImpl</code>.
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

		return _dgfDlrDistributionDtlsLocalService.dynamicQuery(
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

		return _dgfDlrDistributionDtlsLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _dgfDlrDistributionDtlsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfDlrDistributionDtls
		fetchDgfDlrDistributionDtls(long id) {

		return _dgfDlrDistributionDtlsLocalService.fetchDgfDlrDistributionDtls(
			id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgfDlrDistributionDtlsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the dgf dlr distribution dtls with the primary key.
	 *
	 * @param id the primary key of the dgf dlr distribution dtls
	 * @return the dgf dlr distribution dtls
	 * @throws PortalException if a dgf dlr distribution dtls with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfDlrDistributionDtls
			getDgfDlrDistributionDtls(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrDistributionDtlsLocalService.getDgfDlrDistributionDtls(
			id);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfDlrDistributionDtls
			getDgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear(
				long beneficiariesId, int month, int year)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDlrDistributionDtlsException {

		return _dgfDlrDistributionDtlsLocalService.
			getDgfDlrDistributionDtlsByBeneficiariesAndMonthAndYear(
				beneficiariesId, month, year);
	}

	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.DgfDlrDistributionDtls>
				getDgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
					long dealerId, long beneficiariesId)
			throws bd.gov.dgfood.food.grain.license.exception.
				NoSuchDgfDlrDistributionDtlsException {

		return _dgfDlrDistributionDtlsLocalService.
			getDgfDlrDistributionDtlsByDealerIdAndBeneficiariesId(
				dealerId, beneficiariesId);
	}

	/**
	 * Returns a range of all the dgf dlr distribution dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfDlrDistributionDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr distribution dtlses
	 * @param end the upper bound of the range of dgf dlr distribution dtlses (not inclusive)
	 * @return the range of dgf dlr distribution dtlses
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.DgfDlrDistributionDtls>
			getDgfDlrDistributionDtlses(int start, int end) {

		return _dgfDlrDistributionDtlsLocalService.getDgfDlrDistributionDtlses(
			start, end);
	}

	/**
	 * Returns the number of dgf dlr distribution dtlses.
	 *
	 * @return the number of dgf dlr distribution dtlses
	 */
	@Override
	public int getDgfDlrDistributionDtlsesCount() {
		return _dgfDlrDistributionDtlsLocalService.
			getDgfDlrDistributionDtlsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgfDlrDistributionDtlsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfDlrDistributionDtlsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrDistributionDtlsLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the dgf dlr distribution dtls in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrDistributionDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDlrDistributionDtls the dgf dlr distribution dtls
	 * @return the dgf dlr distribution dtls that was updated
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfDlrDistributionDtls
		updateDgfDlrDistributionDtls(
			bd.gov.dgfood.food.grain.license.model.DgfDlrDistributionDtls
				dgfDlrDistributionDtls) {

		return _dgfDlrDistributionDtlsLocalService.updateDgfDlrDistributionDtls(
			dgfDlrDistributionDtls);
	}

	@Override
	public DgfDlrDistributionDtlsLocalService getWrappedService() {
		return _dgfDlrDistributionDtlsLocalService;
	}

	@Override
	public void setWrappedService(
		DgfDlrDistributionDtlsLocalService dgfDlrDistributionDtlsLocalService) {

		_dgfDlrDistributionDtlsLocalService =
			dgfDlrDistributionDtlsLocalService;
	}

	private DgfDlrDistributionDtlsLocalService
		_dgfDlrDistributionDtlsLocalService;

}