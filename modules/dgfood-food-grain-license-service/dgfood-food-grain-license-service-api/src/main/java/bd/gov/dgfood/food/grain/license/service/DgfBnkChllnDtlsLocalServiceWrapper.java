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
 * Provides a wrapper for {@link DgfBnkChllnDtlsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfBnkChllnDtlsLocalService
 * @generated
 */
public class DgfBnkChllnDtlsLocalServiceWrapper
	implements DgfBnkChllnDtlsLocalService,
			   ServiceWrapper<DgfBnkChllnDtlsLocalService> {

	public DgfBnkChllnDtlsLocalServiceWrapper() {
		this(null);
	}

	public DgfBnkChllnDtlsLocalServiceWrapper(
		DgfBnkChllnDtlsLocalService dgfBnkChllnDtlsLocalService) {

		_dgfBnkChllnDtlsLocalService = dgfBnkChllnDtlsLocalService;
	}

	/**
	 * Adds the dgf bnk chlln dtls to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfBnkChllnDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfBnkChllnDtls the dgf bnk chlln dtls
	 * @return the dgf bnk chlln dtls that was added
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfBnkChllnDtls
		addDgfBnkChllnDtls(
			bd.gov.dgfood.food.grain.license.model.DgfBnkChllnDtls
				dgfBnkChllnDtls) {

		return _dgfBnkChllnDtlsLocalService.addDgfBnkChllnDtls(dgfBnkChllnDtls);
	}

	/**
	 * Creates a new dgf bnk chlln dtls with the primary key. Does not add the dgf bnk chlln dtls to the database.
	 *
	 * @param bnkChllnId the primary key for the new dgf bnk chlln dtls
	 * @return the new dgf bnk chlln dtls
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfBnkChllnDtls
		createDgfBnkChllnDtls(long bnkChllnId) {

		return _dgfBnkChllnDtlsLocalService.createDgfBnkChllnDtls(bnkChllnId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfBnkChllnDtlsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the dgf bnk chlln dtls from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfBnkChllnDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfBnkChllnDtls the dgf bnk chlln dtls
	 * @return the dgf bnk chlln dtls that was removed
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfBnkChllnDtls
		deleteDgfBnkChllnDtls(
			bd.gov.dgfood.food.grain.license.model.DgfBnkChllnDtls
				dgfBnkChllnDtls) {

		return _dgfBnkChllnDtlsLocalService.deleteDgfBnkChllnDtls(
			dgfBnkChllnDtls);
	}

	/**
	 * Deletes the dgf bnk chlln dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfBnkChllnDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bnkChllnId the primary key of the dgf bnk chlln dtls
	 * @return the dgf bnk chlln dtls that was removed
	 * @throws PortalException if a dgf bnk chlln dtls with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfBnkChllnDtls
			deleteDgfBnkChllnDtls(long bnkChllnId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfBnkChllnDtlsLocalService.deleteDgfBnkChllnDtls(bnkChllnId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfBnkChllnDtlsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgfBnkChllnDtlsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgfBnkChllnDtlsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgfBnkChllnDtlsLocalService.dynamicQuery();
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

		return _dgfBnkChllnDtlsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfBnkChllnDtlsModelImpl</code>.
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

		return _dgfBnkChllnDtlsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfBnkChllnDtlsModelImpl</code>.
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

		return _dgfBnkChllnDtlsLocalService.dynamicQuery(
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

		return _dgfBnkChllnDtlsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dgfBnkChllnDtlsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfBnkChllnDtls
		fetchDgfBnkChllnDtls(long bnkChllnId) {

		return _dgfBnkChllnDtlsLocalService.fetchDgfBnkChllnDtls(bnkChllnId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgfBnkChllnDtlsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the dgf bnk chlln dtls with the primary key.
	 *
	 * @param bnkChllnId the primary key of the dgf bnk chlln dtls
	 * @return the dgf bnk chlln dtls
	 * @throws PortalException if a dgf bnk chlln dtls with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfBnkChllnDtls
			getDgfBnkChllnDtls(long bnkChllnId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfBnkChllnDtlsLocalService.getDgfBnkChllnDtls(bnkChllnId);
	}

	/**
	 * Returns a range of all the dgf bnk chlln dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfBnkChllnDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf bnk chlln dtlses
	 * @param end the upper bound of the range of dgf bnk chlln dtlses (not inclusive)
	 * @return the range of dgf bnk chlln dtlses
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.DgfBnkChllnDtls>
			getDgfBnkChllnDtlses(int start, int end) {

		return _dgfBnkChllnDtlsLocalService.getDgfBnkChllnDtlses(start, end);
	}

	/**
	 * Returns the number of dgf bnk chlln dtlses.
	 *
	 * @return the number of dgf bnk chlln dtlses
	 */
	@Override
	public int getDgfBnkChllnDtlsesCount() {
		return _dgfBnkChllnDtlsLocalService.getDgfBnkChllnDtlsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgfBnkChllnDtlsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfBnkChllnDtlsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfBnkChllnDtlsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the dgf bnk chlln dtls in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfBnkChllnDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfBnkChllnDtls the dgf bnk chlln dtls
	 * @return the dgf bnk chlln dtls that was updated
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfBnkChllnDtls
		updateDgfBnkChllnDtls(
			bd.gov.dgfood.food.grain.license.model.DgfBnkChllnDtls
				dgfBnkChllnDtls) {

		return _dgfBnkChllnDtlsLocalService.updateDgfBnkChllnDtls(
			dgfBnkChllnDtls);
	}

	@Override
	public DgfBnkChllnDtlsLocalService getWrappedService() {
		return _dgfBnkChllnDtlsLocalService;
	}

	@Override
	public void setWrappedService(
		DgfBnkChllnDtlsLocalService dgfBnkChllnDtlsLocalService) {

		_dgfBnkChllnDtlsLocalService = dgfBnkChllnDtlsLocalService;
	}

	private DgfBnkChllnDtlsLocalService _dgfBnkChllnDtlsLocalService;

}