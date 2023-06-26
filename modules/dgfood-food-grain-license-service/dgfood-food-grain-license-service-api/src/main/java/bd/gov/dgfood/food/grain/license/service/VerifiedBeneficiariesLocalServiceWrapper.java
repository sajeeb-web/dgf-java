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
 * Provides a wrapper for {@link VerifiedBeneficiariesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see VerifiedBeneficiariesLocalService
 * @generated
 */
public class VerifiedBeneficiariesLocalServiceWrapper
	implements ServiceWrapper<VerifiedBeneficiariesLocalService>,
			   VerifiedBeneficiariesLocalService {

	public VerifiedBeneficiariesLocalServiceWrapper() {
		this(null);
	}

	public VerifiedBeneficiariesLocalServiceWrapper(
		VerifiedBeneficiariesLocalService verifiedBeneficiariesLocalService) {

		_verifiedBeneficiariesLocalService = verifiedBeneficiariesLocalService;
	}

	/**
	 * Adds the verified beneficiaries to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VerifiedBeneficiariesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param verifiedBeneficiaries the verified beneficiaries
	 * @return the verified beneficiaries that was added
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.VerifiedBeneficiaries
		addVerifiedBeneficiaries(
			bd.gov.dgfood.food.grain.license.model.VerifiedBeneficiaries
				verifiedBeneficiaries) {

		return _verifiedBeneficiariesLocalService.addVerifiedBeneficiaries(
			verifiedBeneficiaries);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _verifiedBeneficiariesLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new verified beneficiaries with the primary key. Does not add the verified beneficiaries to the database.
	 *
	 * @param id the primary key for the new verified beneficiaries
	 * @return the new verified beneficiaries
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.VerifiedBeneficiaries
		createVerifiedBeneficiaries(long id) {

		return _verifiedBeneficiariesLocalService.createVerifiedBeneficiaries(
			id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _verifiedBeneficiariesLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the verified beneficiaries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VerifiedBeneficiariesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the verified beneficiaries
	 * @return the verified beneficiaries that was removed
	 * @throws PortalException if a verified beneficiaries with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.VerifiedBeneficiaries
			deleteVerifiedBeneficiaries(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _verifiedBeneficiariesLocalService.deleteVerifiedBeneficiaries(
			id);
	}

	/**
	 * Deletes the verified beneficiaries from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VerifiedBeneficiariesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param verifiedBeneficiaries the verified beneficiaries
	 * @return the verified beneficiaries that was removed
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.VerifiedBeneficiaries
		deleteVerifiedBeneficiaries(
			bd.gov.dgfood.food.grain.license.model.VerifiedBeneficiaries
				verifiedBeneficiaries) {

		return _verifiedBeneficiariesLocalService.deleteVerifiedBeneficiaries(
			verifiedBeneficiaries);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _verifiedBeneficiariesLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _verifiedBeneficiariesLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _verifiedBeneficiariesLocalService.dynamicQuery();
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

		return _verifiedBeneficiariesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.VerifiedBeneficiariesModelImpl</code>.
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

		return _verifiedBeneficiariesLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.VerifiedBeneficiariesModelImpl</code>.
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

		return _verifiedBeneficiariesLocalService.dynamicQuery(
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

		return _verifiedBeneficiariesLocalService.dynamicQueryCount(
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

		return _verifiedBeneficiariesLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.VerifiedBeneficiaries
		fetchVerifiedBeneficiaries(long id) {

		return _verifiedBeneficiariesLocalService.fetchVerifiedBeneficiaries(
			id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _verifiedBeneficiariesLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.VerifiedBeneficiaries>
			getDealerLinkedVerifiedBeneficiaries() {

		return _verifiedBeneficiariesLocalService.
			getDealerLinkedVerifiedBeneficiaries();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _verifiedBeneficiariesLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _verifiedBeneficiariesLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _verifiedBeneficiariesLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.VerifiedBeneficiaries>
			getSearchedDealerLinkedVerifiedBeneficiaries(
				String nid, long ffpCardNo) {

		return _verifiedBeneficiariesLocalService.
			getSearchedDealerLinkedVerifiedBeneficiaries(nid, ffpCardNo);
	}

	/**
	 * Returns the verified beneficiaries with the primary key.
	 *
	 * @param id the primary key of the verified beneficiaries
	 * @return the verified beneficiaries
	 * @throws PortalException if a verified beneficiaries with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.VerifiedBeneficiaries
			getVerifiedBeneficiaries(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _verifiedBeneficiariesLocalService.getVerifiedBeneficiaries(id);
	}

	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.VerifiedBeneficiaries>
			getVerifiedBeneficiariesByDealerId(long dealerId) {

		return _verifiedBeneficiariesLocalService.
			getVerifiedBeneficiariesByDealerId(dealerId);
	}

	/**
	 * Returns a range of all the verified beneficiarieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.VerifiedBeneficiariesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of verified beneficiarieses
	 * @param end the upper bound of the range of verified beneficiarieses (not inclusive)
	 * @return the range of verified beneficiarieses
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.VerifiedBeneficiaries>
			getVerifiedBeneficiarieses(int start, int end) {

		return _verifiedBeneficiariesLocalService.getVerifiedBeneficiarieses(
			start, end);
	}

	/**
	 * Returns the number of verified beneficiarieses.
	 *
	 * @return the number of verified beneficiarieses
	 */
	@Override
	public int getVerifiedBeneficiariesesCount() {
		return _verifiedBeneficiariesLocalService.
			getVerifiedBeneficiariesesCount();
	}

	/**
	 * Updates the verified beneficiaries in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VerifiedBeneficiariesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param verifiedBeneficiaries the verified beneficiaries
	 * @return the verified beneficiaries that was updated
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.VerifiedBeneficiaries
		updateVerifiedBeneficiaries(
			bd.gov.dgfood.food.grain.license.model.VerifiedBeneficiaries
				verifiedBeneficiaries) {

		return _verifiedBeneficiariesLocalService.updateVerifiedBeneficiaries(
			verifiedBeneficiaries);
	}

	@Override
	public VerifiedBeneficiariesLocalService getWrappedService() {
		return _verifiedBeneficiariesLocalService;
	}

	@Override
	public void setWrappedService(
		VerifiedBeneficiariesLocalService verifiedBeneficiariesLocalService) {

		_verifiedBeneficiariesLocalService = verifiedBeneficiariesLocalService;
	}

	private VerifiedBeneficiariesLocalService
		_verifiedBeneficiariesLocalService;

}