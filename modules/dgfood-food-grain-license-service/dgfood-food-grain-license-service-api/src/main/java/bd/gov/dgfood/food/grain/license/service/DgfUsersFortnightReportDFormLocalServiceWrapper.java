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
 * Provides a wrapper for {@link DgfUsersFortnightReportDFormLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersFortnightReportDFormLocalService
 * @generated
 */
public class DgfUsersFortnightReportDFormLocalServiceWrapper
	implements DgfUsersFortnightReportDFormLocalService,
			   ServiceWrapper<DgfUsersFortnightReportDFormLocalService> {

	public DgfUsersFortnightReportDFormLocalServiceWrapper() {
		this(null);
	}

	public DgfUsersFortnightReportDFormLocalServiceWrapper(
		DgfUsersFortnightReportDFormLocalService
			dgfUsersFortnightReportDFormLocalService) {

		_dgfUsersFortnightReportDFormLocalService =
			dgfUsersFortnightReportDFormLocalService;
	}

	/**
	 * Adds the dgf users fortnight report d form to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersFortnightReportDFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsersFortnightReportDForm the dgf users fortnight report d form
	 * @return the dgf users fortnight report d form that was added
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportDForm
		addDgfUsersFortnightReportDForm(
			bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportDForm
				dgfUsersFortnightReportDForm) {

		return _dgfUsersFortnightReportDFormLocalService.
			addDgfUsersFortnightReportDForm(dgfUsersFortnightReportDForm);
	}

	/**
	 * Creates a new dgf users fortnight report d form with the primary key. Does not add the dgf users fortnight report d form to the database.
	 *
	 * @param reportId the primary key for the new dgf users fortnight report d form
	 * @return the new dgf users fortnight report d form
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportDForm
		createDgfUsersFortnightReportDForm(long reportId) {

		return _dgfUsersFortnightReportDFormLocalService.
			createDgfUsersFortnightReportDForm(reportId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersFortnightReportDFormLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the dgf users fortnight report d form from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersFortnightReportDFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsersFortnightReportDForm the dgf users fortnight report d form
	 * @return the dgf users fortnight report d form that was removed
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportDForm
		deleteDgfUsersFortnightReportDForm(
			bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportDForm
				dgfUsersFortnightReportDForm) {

		return _dgfUsersFortnightReportDFormLocalService.
			deleteDgfUsersFortnightReportDForm(dgfUsersFortnightReportDForm);
	}

	/**
	 * Deletes the dgf users fortnight report d form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersFortnightReportDFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param reportId the primary key of the dgf users fortnight report d form
	 * @return the dgf users fortnight report d form that was removed
	 * @throws PortalException if a dgf users fortnight report d form with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportDForm
			deleteDgfUsersFortnightReportDForm(long reportId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersFortnightReportDFormLocalService.
			deleteDgfUsersFortnightReportDForm(reportId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersFortnightReportDFormLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgfUsersFortnightReportDFormLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgfUsersFortnightReportDFormLocalService.dslQueryCount(
			dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgfUsersFortnightReportDFormLocalService.dynamicQuery();
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

		return _dgfUsersFortnightReportDFormLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersFortnightReportDFormModelImpl</code>.
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

		return _dgfUsersFortnightReportDFormLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersFortnightReportDFormModelImpl</code>.
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

		return _dgfUsersFortnightReportDFormLocalService.dynamicQuery(
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

		return _dgfUsersFortnightReportDFormLocalService.dynamicQueryCount(
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

		return _dgfUsersFortnightReportDFormLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportDForm
		fetchDgfUsersFortnightReportDForm(long reportId) {

		return _dgfUsersFortnightReportDFormLocalService.
			fetchDgfUsersFortnightReportDForm(reportId);
	}

	@Override
	public java.util.List<java.util.Map<String, Object>> findBySearchCriteria(
		String bussinessType, String endDate, long upazilla,
		long businessUnionName) {

		return _dgfUsersFortnightReportDFormLocalService.findBySearchCriteria(
			bussinessType, endDate, upazilla, businessUnionName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgfUsersFortnightReportDFormLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportDForm
		getDgfUsersFortnightReportBYNidAndLicenseNo(
			String nationalId, String licenseNo) {

		return _dgfUsersFortnightReportDFormLocalService.
			getDgfUsersFortnightReportBYNidAndLicenseNo(nationalId, licenseNo);
	}

	/**
	 * Returns the dgf users fortnight report d form with the primary key.
	 *
	 * @param reportId the primary key of the dgf users fortnight report d form
	 * @return the dgf users fortnight report d form
	 * @throws PortalException if a dgf users fortnight report d form with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportDForm
			getDgfUsersFortnightReportDForm(long reportId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersFortnightReportDFormLocalService.
			getDgfUsersFortnightReportDForm(reportId);
	}

	/**
	 * Returns a range of all the dgf users fortnight report d forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersFortnightReportDFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users fortnight report d forms
	 * @param end the upper bound of the range of dgf users fortnight report d forms (not inclusive)
	 * @return the range of dgf users fortnight report d forms
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportDForm>
			getDgfUsersFortnightReportDForms(int start, int end) {

		return _dgfUsersFortnightReportDFormLocalService.
			getDgfUsersFortnightReportDForms(start, end);
	}

	/**
	 * Returns the number of dgf users fortnight report d forms.
	 *
	 * @return the number of dgf users fortnight report d forms
	 */
	@Override
	public int getDgfUsersFortnightReportDFormsCount() {
		return _dgfUsersFortnightReportDFormLocalService.
			getDgfUsersFortnightReportDFormsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgfUsersFortnightReportDFormLocalService.
			getIndexableActionableDynamicQuery();
	}

	@Override
	public byte[] getLicenseReport(String queryParams) {
		return _dgfUsersFortnightReportDFormLocalService.getLicenseReport(
			queryParams);
	}

	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportDForm>
			getMatchingReportFormDByUserNationalId(String nationalId) {

		return _dgfUsersFortnightReportDFormLocalService.
			getMatchingReportFormDByUserNationalId(nationalId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfUsersFortnightReportDFormLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersFortnightReportDFormLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the dgf users fortnight report d form in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersFortnightReportDFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsersFortnightReportDForm the dgf users fortnight report d form
	 * @return the dgf users fortnight report d form that was updated
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportDForm
		updateDgfUsersFortnightReportDForm(
			bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportDForm
				dgfUsersFortnightReportDForm) {

		return _dgfUsersFortnightReportDFormLocalService.
			updateDgfUsersFortnightReportDForm(dgfUsersFortnightReportDForm);
	}

	@Override
	public DgfUsersFortnightReportDFormLocalService getWrappedService() {
		return _dgfUsersFortnightReportDFormLocalService;
	}

	@Override
	public void setWrappedService(
		DgfUsersFortnightReportDFormLocalService
			dgfUsersFortnightReportDFormLocalService) {

		_dgfUsersFortnightReportDFormLocalService =
			dgfUsersFortnightReportDFormLocalService;
	}

	private DgfUsersFortnightReportDFormLocalService
		_dgfUsersFortnightReportDFormLocalService;

}