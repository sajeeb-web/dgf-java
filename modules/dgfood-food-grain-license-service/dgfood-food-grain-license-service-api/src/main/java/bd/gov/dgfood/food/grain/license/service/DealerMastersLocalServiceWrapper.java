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
 * Provides a wrapper for {@link DealerMastersLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DealerMastersLocalService
 * @generated
 */
public class DealerMastersLocalServiceWrapper
	implements DealerMastersLocalService,
			   ServiceWrapper<DealerMastersLocalService> {

	public DealerMastersLocalServiceWrapper() {
		this(null);
	}

	public DealerMastersLocalServiceWrapper(
		DealerMastersLocalService dealerMastersLocalService) {

		_dealerMastersLocalService = dealerMastersLocalService;
	}

	/**
	 * Adds the dealer masters to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DealerMastersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dealerMasters the dealer masters
	 * @return the dealer masters that was added
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DealerMasters
		addDealerMasters(
			bd.gov.dgfood.food.grain.license.model.DealerMasters
				dealerMasters) {

		return _dealerMastersLocalService.addDealerMasters(dealerMasters);
	}

	/**
	 * Creates a new dealer masters with the primary key. Does not add the dealer masters to the database.
	 *
	 * @param id the primary key for the new dealer masters
	 * @return the new dealer masters
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DealerMasters
		createDealerMasters(long id) {

		return _dealerMastersLocalService.createDealerMasters(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dealerMastersLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the dealer masters from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DealerMastersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dealerMasters the dealer masters
	 * @return the dealer masters that was removed
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DealerMasters
		deleteDealerMasters(
			bd.gov.dgfood.food.grain.license.model.DealerMasters
				dealerMasters) {

		return _dealerMastersLocalService.deleteDealerMasters(dealerMasters);
	}

	/**
	 * Deletes the dealer masters with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DealerMastersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the dealer masters
	 * @return the dealer masters that was removed
	 * @throws PortalException if a dealer masters with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DealerMasters
			deleteDealerMasters(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dealerMastersLocalService.deleteDealerMasters(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dealerMastersLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dealerMastersLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dealerMastersLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dealerMastersLocalService.dynamicQuery();
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

		return _dealerMastersLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DealerMastersModelImpl</code>.
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

		return _dealerMastersLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DealerMastersModelImpl</code>.
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

		return _dealerMastersLocalService.dynamicQuery(
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

		return _dealerMastersLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dealerMastersLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DealerMasters
		fetchDealerMasters(long id) {

		return _dealerMastersLocalService.fetchDealerMasters(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dealerMastersLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the dealer masters with the primary key.
	 *
	 * @param id the primary key of the dealer masters
	 * @return the dealer masters
	 * @throws PortalException if a dealer masters with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DealerMasters
			getDealerMasters(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dealerMastersLocalService.getDealerMasters(id);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DealerMasters
			getDealerMastersByMobileNo(String dealerMobileNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDealerMastersException {

		return _dealerMastersLocalService.getDealerMastersByMobileNo(
			dealerMobileNo);
	}

	@Override
	public java.util.List<bd.gov.dgfood.food.grain.license.model.DealerMasters>
		getDealerMastersByNid(String nationalId) {

		return _dealerMastersLocalService.getDealerMastersByNid(nationalId);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DealerMasters
			getDealerMastersByNidAndMobile(String nationalId, String mobileNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDealerMastersException {

		return _dealerMastersLocalService.getDealerMastersByNidAndMobile(
			nationalId, mobileNo);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DealerMasters
			getDealerMastersBySecondNidAndMobile(
				String secondNationalId, String dealerMobileNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDealerMastersException {

		return _dealerMastersLocalService.getDealerMastersBySecondNidAndMobile(
			secondNationalId, dealerMobileNo);
	}

	/**
	 * Returns a range of all the dealer masterses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DealerMastersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dealer masterses
	 * @param end the upper bound of the range of dealer masterses (not inclusive)
	 * @return the range of dealer masterses
	 */
	@Override
	public java.util.List<bd.gov.dgfood.food.grain.license.model.DealerMasters>
		getDealerMasterses(int start, int end) {

		return _dealerMastersLocalService.getDealerMasterses(start, end);
	}

	/**
	 * Returns the number of dealer masterses.
	 *
	 * @return the number of dealer masterses
	 */
	@Override
	public int getDealerMastersesCount() {
		return _dealerMastersLocalService.getDealerMastersesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dealerMastersLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dealerMastersLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dealerMastersLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the dealer masters in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DealerMastersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dealerMasters the dealer masters
	 * @return the dealer masters that was updated
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DealerMasters
		updateDealerMasters(
			bd.gov.dgfood.food.grain.license.model.DealerMasters
				dealerMasters) {

		return _dealerMastersLocalService.updateDealerMasters(dealerMasters);
	}

	@Override
	public DealerMastersLocalService getWrappedService() {
		return _dealerMastersLocalService;
	}

	@Override
	public void setWrappedService(
		DealerMastersLocalService dealerMastersLocalService) {

		_dealerMastersLocalService = dealerMastersLocalService;
	}

	private DealerMastersLocalService _dealerMastersLocalService;

}