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
 * Provides a wrapper for {@link DgfRenewLicenseLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfRenewLicenseLocalService
 * @generated
 */
public class DgfRenewLicenseLocalServiceWrapper
	implements DgfRenewLicenseLocalService,
			   ServiceWrapper<DgfRenewLicenseLocalService> {

	public DgfRenewLicenseLocalServiceWrapper() {
		this(null);
	}

	public DgfRenewLicenseLocalServiceWrapper(
		DgfRenewLicenseLocalService dgfRenewLicenseLocalService) {

		_dgfRenewLicenseLocalService = dgfRenewLicenseLocalService;
	}

	/**
	 * Adds the dgf renew license to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfRenewLicenseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfRenewLicense the dgf renew license
	 * @return the dgf renew license that was added
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfRenewLicense
		addDgfRenewLicense(
			bd.gov.dgfood.food.grain.license.model.DgfRenewLicense
				dgfRenewLicense) {

		return _dgfRenewLicenseLocalService.addDgfRenewLicense(dgfRenewLicense);
	}

	/**
	 * Creates a new dgf renew license with the primary key. Does not add the dgf renew license to the database.
	 *
	 * @param renewLicenseId the primary key for the new dgf renew license
	 * @return the new dgf renew license
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfRenewLicense
		createDgfRenewLicense(long renewLicenseId) {

		return _dgfRenewLicenseLocalService.createDgfRenewLicense(
			renewLicenseId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfRenewLicenseLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the dgf renew license from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfRenewLicenseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfRenewLicense the dgf renew license
	 * @return the dgf renew license that was removed
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfRenewLicense
		deleteDgfRenewLicense(
			bd.gov.dgfood.food.grain.license.model.DgfRenewLicense
				dgfRenewLicense) {

		return _dgfRenewLicenseLocalService.deleteDgfRenewLicense(
			dgfRenewLicense);
	}

	/**
	 * Deletes the dgf renew license with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfRenewLicenseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param renewLicenseId the primary key of the dgf renew license
	 * @return the dgf renew license that was removed
	 * @throws PortalException if a dgf renew license with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfRenewLicense
			deleteDgfRenewLicense(long renewLicenseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfRenewLicenseLocalService.deleteDgfRenewLicense(
			renewLicenseId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfRenewLicenseLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgfRenewLicenseLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgfRenewLicenseLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgfRenewLicenseLocalService.dynamicQuery();
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

		return _dgfRenewLicenseLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfRenewLicenseModelImpl</code>.
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

		return _dgfRenewLicenseLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfRenewLicenseModelImpl</code>.
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

		return _dgfRenewLicenseLocalService.dynamicQuery(
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

		return _dgfRenewLicenseLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dgfRenewLicenseLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public void extendRenewLicenseExpiredDate(long classPk) {
		_dgfRenewLicenseLocalService.extendRenewLicenseExpiredDate(classPk);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfRenewLicense
		fetchDgfRenewLicense(long renewLicenseId) {

		return _dgfRenewLicenseLocalService.fetchDgfRenewLicense(
			renewLicenseId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgfRenewLicenseLocalService.getActionableDynamicQuery();
	}

	@Override
	public void getDcfUserIdByLocationAndSendNotificationByNodeId(
		long renewLicenseId, String nodeId) {

		_dgfRenewLicenseLocalService.
			getDcfUserIdByLocationAndSendNotificationByNodeId(
				renewLicenseId, nodeId);
	}

	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.DgfRenewLicense>
			getDgfRenewLicByNationalIdAndLicense(
				String nationalId, String licenseNo) {

		return _dgfRenewLicenseLocalService.
			getDgfRenewLicByNationalIdAndLicense(nationalId, licenseNo);
	}

	/**
	 * Returns the dgf renew license with the primary key.
	 *
	 * @param renewLicenseId the primary key of the dgf renew license
	 * @return the dgf renew license
	 * @throws PortalException if a dgf renew license with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfRenewLicense
			getDgfRenewLicense(long renewLicenseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfRenewLicenseLocalService.getDgfRenewLicense(renewLicenseId);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfRenewLicense
			getDgfRenewLicenseByFglPrePrimary(long fglPrePrimaryId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfRenewLicenseException {

		return _dgfRenewLicenseLocalService.getDgfRenewLicenseByFglPrePrimary(
			fglPrePrimaryId);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfRenewLicense
		getDgfRenewLicenseByNid(String nationalId) {

		return _dgfRenewLicenseLocalService.getDgfRenewLicenseByNid(nationalId);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfRenewLicense
			getDgfRenewLicenseByPaymentAttchId(long paymentAttchId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfRenewLicenseException {

		return _dgfRenewLicenseLocalService.getDgfRenewLicenseByPaymentAttchId(
			paymentAttchId);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfRenewLicense
			getDgfRenewLicenseByTradeLicAttchId(long tradeLicAttchId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfRenewLicenseException {

		return _dgfRenewLicenseLocalService.getDgfRenewLicenseByTradeLicAttchId(
			tradeLicAttchId);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfRenewLicense
			getDgfRenewLicenseByUserId(long userId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfRenewLicenseException {

		return _dgfRenewLicenseLocalService.getDgfRenewLicenseByUserId(userId);
	}

	/**
	 * Returns a range of all the dgf renew licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @return the range of dgf renew licenses
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.DgfRenewLicense>
			getDgfRenewLicenses(int start, int end) {

		return _dgfRenewLicenseLocalService.getDgfRenewLicenses(start, end);
	}

	/**
	 * Returns the number of dgf renew licenses.
	 *
	 * @return the number of dgf renew licenses
	 */
	@Override
	public int getDgfRenewLicensesCount() {
		return _dgfRenewLicenseLocalService.getDgfRenewLicensesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgfRenewLicenseLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfRenewLicenseLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfRenewLicenseLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public void sendAcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfRenewLicenseLocalService.
			sendAcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendAcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfRenewLicenseLocalService.
			sendAcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendCcdrApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfRenewLicenseLocalService.
			sendCcdrApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendCcdrRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfRenewLicenseLocalService.
			sendCcdrRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendDcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfRenewLicenseLocalService.
			sendDcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendDcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfRenewLicenseLocalService.
			sendDcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfRenewLicenseLocalService.
			sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfRenewLicenseLocalService.
			sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void setLicenseAcfUserNotificationEvent(long renewLicenseId) {
		_dgfRenewLicenseLocalService.setLicenseAcfUserNotificationEvent(
			renewLicenseId);
	}

	@Override
	public void setLicenseCcdrUserNotificationEvent(long renewLicenseId) {
		_dgfRenewLicenseLocalService.setLicenseCcdrUserNotificationEvent(
			renewLicenseId);
	}

	@Override
	public void setLicenseUcfUserNotificationEvent(long renewLicenseId) {
		_dgfRenewLicenseLocalService.setLicenseUcfUserNotificationEvent(
			renewLicenseId);
	}

	/**
	 * Updates the dgf renew license in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfRenewLicenseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfRenewLicense the dgf renew license
	 * @return the dgf renew license that was updated
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfRenewLicense
		updateDgfRenewLicense(
			bd.gov.dgfood.food.grain.license.model.DgfRenewLicense
				dgfRenewLicense) {

		return _dgfRenewLicenseLocalService.updateDgfRenewLicense(
			dgfRenewLicense);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfRenewLicense updateStatus(
			long userId, long resourcePrimKey, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfRenewLicenseLocalService.updateStatus(
			userId, resourcePrimKey, status, serviceContext);
	}

	@Override
	public DgfRenewLicenseLocalService getWrappedService() {
		return _dgfRenewLicenseLocalService;
	}

	@Override
	public void setWrappedService(
		DgfRenewLicenseLocalService dgfRenewLicenseLocalService) {

		_dgfRenewLicenseLocalService = dgfRenewLicenseLocalService;
	}

	private DgfRenewLicenseLocalService _dgfRenewLicenseLocalService;

}