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
 * Provides a wrapper for {@link BeneficiaryOtherInfoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BeneficiaryOtherInfoLocalService
 * @generated
 */
public class BeneficiaryOtherInfoLocalServiceWrapper
	implements BeneficiaryOtherInfoLocalService,
			   ServiceWrapper<BeneficiaryOtherInfoLocalService> {

	public BeneficiaryOtherInfoLocalServiceWrapper() {
		this(null);
	}

	public BeneficiaryOtherInfoLocalServiceWrapper(
		BeneficiaryOtherInfoLocalService beneficiaryOtherInfoLocalService) {

		_beneficiaryOtherInfoLocalService = beneficiaryOtherInfoLocalService;
	}

	/**
	 * Adds the beneficiary other info to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BeneficiaryOtherInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param beneficiaryOtherInfo the beneficiary other info
	 * @return the beneficiary other info that was added
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.BeneficiaryOtherInfo
		addBeneficiaryOtherInfo(
			bd.gov.dgfood.food.grain.license.model.BeneficiaryOtherInfo
				beneficiaryOtherInfo) {

		return _beneficiaryOtherInfoLocalService.addBeneficiaryOtherInfo(
			beneficiaryOtherInfo);
	}

	/**
	 * Creates a new beneficiary other info with the primary key. Does not add the beneficiary other info to the database.
	 *
	 * @param id the primary key for the new beneficiary other info
	 * @return the new beneficiary other info
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.BeneficiaryOtherInfo
		createBeneficiaryOtherInfo(long id) {

		return _beneficiaryOtherInfoLocalService.createBeneficiaryOtherInfo(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _beneficiaryOtherInfoLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the beneficiary other info from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BeneficiaryOtherInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param beneficiaryOtherInfo the beneficiary other info
	 * @return the beneficiary other info that was removed
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.BeneficiaryOtherInfo
		deleteBeneficiaryOtherInfo(
			bd.gov.dgfood.food.grain.license.model.BeneficiaryOtherInfo
				beneficiaryOtherInfo) {

		return _beneficiaryOtherInfoLocalService.deleteBeneficiaryOtherInfo(
			beneficiaryOtherInfo);
	}

	/**
	 * Deletes the beneficiary other info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BeneficiaryOtherInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the beneficiary other info
	 * @return the beneficiary other info that was removed
	 * @throws PortalException if a beneficiary other info with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.BeneficiaryOtherInfo
			deleteBeneficiaryOtherInfo(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _beneficiaryOtherInfoLocalService.deleteBeneficiaryOtherInfo(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _beneficiaryOtherInfoLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _beneficiaryOtherInfoLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _beneficiaryOtherInfoLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _beneficiaryOtherInfoLocalService.dynamicQuery();
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

		return _beneficiaryOtherInfoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.BeneficiaryOtherInfoModelImpl</code>.
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

		return _beneficiaryOtherInfoLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.BeneficiaryOtherInfoModelImpl</code>.
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

		return _beneficiaryOtherInfoLocalService.dynamicQuery(
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

		return _beneficiaryOtherInfoLocalService.dynamicQueryCount(
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

		return _beneficiaryOtherInfoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.BeneficiaryOtherInfo
		fetchBeneficiaryOtherInfo(long id) {

		return _beneficiaryOtherInfoLocalService.fetchBeneficiaryOtherInfo(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _beneficiaryOtherInfoLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the beneficiary other info with the primary key.
	 *
	 * @param id the primary key of the beneficiary other info
	 * @return the beneficiary other info
	 * @throws PortalException if a beneficiary other info with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.BeneficiaryOtherInfo
			getBeneficiaryOtherInfo(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _beneficiaryOtherInfoLocalService.getBeneficiaryOtherInfo(id);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.BeneficiaryOtherInfo
			getBeneficiaryOtherInfoByVerifiedId(long verifiedId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchBeneficiaryOtherInfoException {

		return _beneficiaryOtherInfoLocalService.
			getBeneficiaryOtherInfoByVerifiedId(verifiedId);
	}

	/**
	 * Returns a range of all the beneficiary other infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.BeneficiaryOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of beneficiary other infos
	 * @param end the upper bound of the range of beneficiary other infos (not inclusive)
	 * @return the range of beneficiary other infos
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.BeneficiaryOtherInfo>
			getBeneficiaryOtherInfos(int start, int end) {

		return _beneficiaryOtherInfoLocalService.getBeneficiaryOtherInfos(
			start, end);
	}

	/**
	 * Returns the number of beneficiary other infos.
	 *
	 * @return the number of beneficiary other infos
	 */
	@Override
	public int getBeneficiaryOtherInfosCount() {
		return _beneficiaryOtherInfoLocalService.
			getBeneficiaryOtherInfosCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _beneficiaryOtherInfoLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _beneficiaryOtherInfoLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _beneficiaryOtherInfoLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the beneficiary other info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BeneficiaryOtherInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param beneficiaryOtherInfo the beneficiary other info
	 * @return the beneficiary other info that was updated
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.BeneficiaryOtherInfo
		updateBeneficiaryOtherInfo(
			bd.gov.dgfood.food.grain.license.model.BeneficiaryOtherInfo
				beneficiaryOtherInfo) {

		return _beneficiaryOtherInfoLocalService.updateBeneficiaryOtherInfo(
			beneficiaryOtherInfo);
	}

	@Override
	public BeneficiaryOtherInfoLocalService getWrappedService() {
		return _beneficiaryOtherInfoLocalService;
	}

	@Override
	public void setWrappedService(
		BeneficiaryOtherInfoLocalService beneficiaryOtherInfoLocalService) {

		_beneficiaryOtherInfoLocalService = beneficiaryOtherInfoLocalService;
	}

	private BeneficiaryOtherInfoLocalService _beneficiaryOtherInfoLocalService;

}