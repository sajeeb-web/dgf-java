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
 * Provides a wrapper for {@link DgfUsersFortnightReportCFormLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersFortnightReportCFormLocalService
 * @generated
 */
public class DgfUsersFortnightReportCFormLocalServiceWrapper
	implements DgfUsersFortnightReportCFormLocalService,
			   ServiceWrapper<DgfUsersFortnightReportCFormLocalService> {

	public DgfUsersFortnightReportCFormLocalServiceWrapper() {
		this(null);
	}

	public DgfUsersFortnightReportCFormLocalServiceWrapper(
		DgfUsersFortnightReportCFormLocalService
			dgfUsersFortnightReportCFormLocalService) {

		_dgfUsersFortnightReportCFormLocalService =
			dgfUsersFortnightReportCFormLocalService;
	}

	/**
	 * Adds the dgf users fortnight report c form to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersFortnightReportCFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsersFortnightReportCForm the dgf users fortnight report c form
	 * @return the dgf users fortnight report c form that was added
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportCForm
		addDgfUsersFortnightReportCForm(
			bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportCForm
				dgfUsersFortnightReportCForm) {

		return _dgfUsersFortnightReportCFormLocalService.
			addDgfUsersFortnightReportCForm(dgfUsersFortnightReportCForm);
	}

	/**
	 * Creates a new dgf users fortnight report c form with the primary key. Does not add the dgf users fortnight report c form to the database.
	 *
	 * @param reportId the primary key for the new dgf users fortnight report c form
	 * @return the new dgf users fortnight report c form
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportCForm
		createDgfUsersFortnightReportCForm(long reportId) {

		return _dgfUsersFortnightReportCFormLocalService.
			createDgfUsersFortnightReportCForm(reportId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersFortnightReportCFormLocalService.createPersistedModel(
			primaryKeyObj);
	}

	@Override
	public java.util.Date dateMaker(String dateStr) {
		return _dgfUsersFortnightReportCFormLocalService.dateMaker(dateStr);
	}

	/**
	 * Deletes the dgf users fortnight report c form from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersFortnightReportCFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsersFortnightReportCForm the dgf users fortnight report c form
	 * @return the dgf users fortnight report c form that was removed
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportCForm
		deleteDgfUsersFortnightReportCForm(
			bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportCForm
				dgfUsersFortnightReportCForm) {

		return _dgfUsersFortnightReportCFormLocalService.
			deleteDgfUsersFortnightReportCForm(dgfUsersFortnightReportCForm);
	}

	/**
	 * Deletes the dgf users fortnight report c form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersFortnightReportCFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param reportId the primary key of the dgf users fortnight report c form
	 * @return the dgf users fortnight report c form that was removed
	 * @throws PortalException if a dgf users fortnight report c form with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportCForm
			deleteDgfUsersFortnightReportCForm(long reportId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersFortnightReportCFormLocalService.
			deleteDgfUsersFortnightReportCForm(reportId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersFortnightReportCFormLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgfUsersFortnightReportCFormLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgfUsersFortnightReportCFormLocalService.dslQueryCount(
			dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgfUsersFortnightReportCFormLocalService.dynamicQuery();
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

		return _dgfUsersFortnightReportCFormLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersFortnightReportCFormModelImpl</code>.
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

		return _dgfUsersFortnightReportCFormLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersFortnightReportCFormModelImpl</code>.
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

		return _dgfUsersFortnightReportCFormLocalService.dynamicQuery(
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

		return _dgfUsersFortnightReportCFormLocalService.dynamicQueryCount(
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

		return _dgfUsersFortnightReportCFormLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportCForm
		fetchDgfUsersFortnightReportCForm(long reportId) {

		return _dgfUsersFortnightReportCFormLocalService.
			fetchDgfUsersFortnightReportCForm(reportId);
	}

	@Override
	public java.util.List<java.util.Map<String, Object>> findBySearchCriteria(
		String bussinessType, String endDate, long upazilla,
		long businessUnionName) {

		return _dgfUsersFortnightReportCFormLocalService.findBySearchCriteria(
			bussinessType, endDate, upazilla, businessUnionName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgfUsersFortnightReportCFormLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportCForm>
			getAllDataUnderUCF(long userId, String usernationalId) {

		return _dgfUsersFortnightReportCFormLocalService.getAllDataUnderUCF(
			userId, usernationalId);
	}

	/**
	 * Returns the dgf users fortnight report c form with the primary key.
	 *
	 * @param reportId the primary key of the dgf users fortnight report c form
	 * @return the dgf users fortnight report c form
	 * @throws PortalException if a dgf users fortnight report c form with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportCForm
			getDgfUsersFortnightReportCForm(long reportId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersFortnightReportCFormLocalService.
			getDgfUsersFortnightReportCForm(reportId);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportCForm
		getDgfUsersFortnightReportCFormByNationalId(String nationalId) {

		return _dgfUsersFortnightReportCFormLocalService.
			getDgfUsersFortnightReportCFormByNationalId(nationalId);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportCForm
		getDgfUsersFortnightReportCFormByNidAndLicenseNo(
			String nationalId, String licenseNo) {

		return _dgfUsersFortnightReportCFormLocalService.
			getDgfUsersFortnightReportCFormByNidAndLicenseNo(
				nationalId, licenseNo);
	}

	/**
	 * Returns a range of all the dgf users fortnight report c forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersFortnightReportCFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users fortnight report c forms
	 * @param end the upper bound of the range of dgf users fortnight report c forms (not inclusive)
	 * @return the range of dgf users fortnight report c forms
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportCForm>
			getDgfUsersFortnightReportCForms(int start, int end) {

		return _dgfUsersFortnightReportCFormLocalService.
			getDgfUsersFortnightReportCForms(start, end);
	}

	/**
	 * Returns the number of dgf users fortnight report c forms.
	 *
	 * @return the number of dgf users fortnight report c forms
	 */
	@Override
	public int getDgfUsersFortnightReportCFormsCount() {
		return _dgfUsersFortnightReportCFormLocalService.
			getDgfUsersFortnightReportCFormsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgfUsersFortnightReportCFormLocalService.
			getIndexableActionableDynamicQuery();
	}

	@Override
	public byte[] getLicenseReport(String queryParams) {
		return _dgfUsersFortnightReportCFormLocalService.getLicenseReport(
			queryParams);
	}

	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportCForm>
			getMatchingReportsByUserNationalId(String nationalId) {

		return _dgfUsersFortnightReportCFormLocalService.
			getMatchingReportsByUserNationalId(nationalId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfUsersFortnightReportCFormLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersFortnightReportCFormLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public java.util.List<bd.gov.dgfood.food.grain.license.model.dgfLocUnion>
		getUnionNameByUpzillaId(long subdistrictId) {

		return _dgfUsersFortnightReportCFormLocalService.
			getUnionNameByUpzillaId(subdistrictId);
	}

	/**
	 * Updates the dgf users fortnight report c form in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersFortnightReportCFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsersFortnightReportCForm the dgf users fortnight report c form
	 * @return the dgf users fortnight report c form that was updated
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportCForm
		updateDgfUsersFortnightReportCForm(
			bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportCForm
				dgfUsersFortnightReportCForm) {

		return _dgfUsersFortnightReportCFormLocalService.
			updateDgfUsersFortnightReportCForm(dgfUsersFortnightReportCForm);
	}

	@Override
	public DgfUsersFortnightReportCFormLocalService getWrappedService() {
		return _dgfUsersFortnightReportCFormLocalService;
	}

	@Override
	public void setWrappedService(
		DgfUsersFortnightReportCFormLocalService
			dgfUsersFortnightReportCFormLocalService) {

		_dgfUsersFortnightReportCFormLocalService =
			dgfUsersFortnightReportCFormLocalService;
	}

	private DgfUsersFortnightReportCFormLocalService
		_dgfUsersFortnightReportCFormLocalService;

}