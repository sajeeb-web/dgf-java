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
 * Provides a wrapper for {@link DgfDuplctLicnsReasonLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDuplctLicnsReasonLocalService
 * @generated
 */
public class DgfDuplctLicnsReasonLocalServiceWrapper
	implements DgfDuplctLicnsReasonLocalService,
			   ServiceWrapper<DgfDuplctLicnsReasonLocalService> {

	public DgfDuplctLicnsReasonLocalServiceWrapper() {
		this(null);
	}

	public DgfDuplctLicnsReasonLocalServiceWrapper(
		DgfDuplctLicnsReasonLocalService dgfDuplctLicnsReasonLocalService) {

		_dgfDuplctLicnsReasonLocalService = dgfDuplctLicnsReasonLocalService;
	}

	/**
	 * Adds the dgf duplct licns reason to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDuplctLicnsReasonLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDuplctLicnsReason the dgf duplct licns reason
	 * @return the dgf duplct licns reason that was added
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason
		addDgfDuplctLicnsReason(
			bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason
				dgfDuplctLicnsReason) {

		return _dgfDuplctLicnsReasonLocalService.addDgfDuplctLicnsReason(
			dgfDuplctLicnsReason);
	}

	/**
	 * Creates a new dgf duplct licns reason with the primary key. Does not add the dgf duplct licns reason to the database.
	 *
	 * @param duplicateLicenseReasonID the primary key for the new dgf duplct licns reason
	 * @return the new dgf duplct licns reason
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason
		createDgfDuplctLicnsReason(long duplicateLicenseReasonID) {

		return _dgfDuplctLicnsReasonLocalService.createDgfDuplctLicnsReason(
			duplicateLicenseReasonID);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDuplctLicnsReasonLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the dgf duplct licns reason from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDuplctLicnsReasonLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDuplctLicnsReason the dgf duplct licns reason
	 * @return the dgf duplct licns reason that was removed
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason
		deleteDgfDuplctLicnsReason(
			bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason
				dgfDuplctLicnsReason) {

		return _dgfDuplctLicnsReasonLocalService.deleteDgfDuplctLicnsReason(
			dgfDuplctLicnsReason);
	}

	/**
	 * Deletes the dgf duplct licns reason with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDuplctLicnsReasonLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param duplicateLicenseReasonID the primary key of the dgf duplct licns reason
	 * @return the dgf duplct licns reason that was removed
	 * @throws PortalException if a dgf duplct licns reason with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason
			deleteDgfDuplctLicnsReason(long duplicateLicenseReasonID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDuplctLicnsReasonLocalService.deleteDgfDuplctLicnsReason(
			duplicateLicenseReasonID);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDuplctLicnsReasonLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgfDuplctLicnsReasonLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgfDuplctLicnsReasonLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgfDuplctLicnsReasonLocalService.dynamicQuery();
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

		return _dgfDuplctLicnsReasonLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfDuplctLicnsReasonModelImpl</code>.
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

		return _dgfDuplctLicnsReasonLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfDuplctLicnsReasonModelImpl</code>.
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

		return _dgfDuplctLicnsReasonLocalService.dynamicQuery(
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

		return _dgfDuplctLicnsReasonLocalService.dynamicQueryCount(
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

		return _dgfDuplctLicnsReasonLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason
		fetchDgfDuplctLicnsReason(long duplicateLicenseReasonID) {

		return _dgfDuplctLicnsReasonLocalService.fetchDgfDuplctLicnsReason(
			duplicateLicenseReasonID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgfDuplctLicnsReasonLocalService.getActionableDynamicQuery();
	}

	@Override
	public void getDcfUserIdByLocationAndSendNotificationByNodeId(
		long classPK, String nodeId) {

		_dgfDuplctLicnsReasonLocalService.
			getDcfUserIdByLocationAndSendNotificationByNodeId(classPK, nodeId);
	}

	/**
	 * Returns the dgf duplct licns reason with the primary key.
	 *
	 * @param duplicateLicenseReasonID the primary key of the dgf duplct licns reason
	 * @return the dgf duplct licns reason
	 * @throws PortalException if a dgf duplct licns reason with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason
			getDgfDuplctLicnsReason(long duplicateLicenseReasonID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDuplctLicnsReasonLocalService.getDgfDuplctLicnsReason(
			duplicateLicenseReasonID);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason
			getDgfDuplctLicnsReasonByFglPrePrimary(long fglPrePrimaryId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDuplctLicnsReasonException {

		return _dgfDuplctLicnsReasonLocalService.
			getDgfDuplctLicnsReasonByFglPrePrimary(fglPrePrimaryId);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason
			getDgfDuplctLicnsReasonByNid(String nationalId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDuplctLicnsReasonException {

		return _dgfDuplctLicnsReasonLocalService.getDgfDuplctLicnsReasonByNid(
			nationalId);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason
			getDgfDuplctLicnsReasonByPaymentAttchId(long paymentAttchId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDuplctLicnsReasonException {

		return _dgfDuplctLicnsReasonLocalService.
			getDgfDuplctLicnsReasonByPaymentAttchId(paymentAttchId);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason
			getDgfDuplctLicnsReasonByTradeLicAttchId(long tradeLicAttchId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDuplctLicnsReasonException {

		return _dgfDuplctLicnsReasonLocalService.
			getDgfDuplctLicnsReasonByTradeLicAttchId(tradeLicAttchId);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason
			getDgfDuplctLicnsReasonByUserId(long userId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDuplctLicnsReasonException {

		return _dgfDuplctLicnsReasonLocalService.
			getDgfDuplctLicnsReasonByUserId(userId);
	}

	/**
	 * Returns a range of all the dgf duplct licns reasons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @return the range of dgf duplct licns reasons
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason>
			getDgfDuplctLicnsReasons(int start, int end) {

		return _dgfDuplctLicnsReasonLocalService.getDgfDuplctLicnsReasons(
			start, end);
	}

	/**
	 * Returns the number of dgf duplct licns reasons.
	 *
	 * @return the number of dgf duplct licns reasons
	 */
	@Override
	public int getDgfDuplctLicnsReasonsCount() {
		return _dgfDuplctLicnsReasonLocalService.
			getDgfDuplctLicnsReasonsCount();
	}

	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason>
			getDgfDupLicByNationalIdAndLicense(
				String nationalId, String licenseNo) {

		return _dgfDuplctLicnsReasonLocalService.
			getDgfDupLicByNationalIdAndLicense(nationalId, licenseNo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgfDuplctLicnsReasonLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfDuplctLicnsReasonLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDuplctLicnsReasonLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public void sendAcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfDuplctLicnsReasonLocalService.
			sendAcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendAcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfDuplctLicnsReasonLocalService.
			sendAcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendCcdrApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfDuplctLicnsReasonLocalService.
			sendCcdrApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendCcdrRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfDuplctLicnsReasonLocalService.
			sendCcdrRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendDcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfDuplctLicnsReasonLocalService.
			sendDcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendDcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfDuplctLicnsReasonLocalService.
			sendDcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfDuplctLicnsReasonLocalService.
			sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfDuplctLicnsReasonLocalService.
			sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void setLicenseAcfUserNotificationEvent(long classPK) {
		_dgfDuplctLicnsReasonLocalService.setLicenseAcfUserNotificationEvent(
			classPK);
	}

	@Override
	public void setLicenseCcdrUserNotificationEvent(long classPK) {
		_dgfDuplctLicnsReasonLocalService.setLicenseCcdrUserNotificationEvent(
			classPK);
	}

	@Override
	public void setLicenseUcfUserNotificationEvent(long classPK) {
		_dgfDuplctLicnsReasonLocalService.setLicenseUcfUserNotificationEvent(
			classPK);
	}

	/**
	 * Updates the dgf duplct licns reason in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDuplctLicnsReasonLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDuplctLicnsReason the dgf duplct licns reason
	 * @return the dgf duplct licns reason that was updated
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason
		updateDgfDuplctLicnsReason(
			bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason
				dgfDuplctLicnsReason) {

		return _dgfDuplctLicnsReasonLocalService.updateDgfDuplctLicnsReason(
			dgfDuplctLicnsReason);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason
			updateStatus(
				long userId, long resourcePrimKey, int status,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDuplctLicnsReasonLocalService.updateStatus(
			userId, resourcePrimKey, status, serviceContext);
	}

	@Override
	public DgfDuplctLicnsReasonLocalService getWrappedService() {
		return _dgfDuplctLicnsReasonLocalService;
	}

	@Override
	public void setWrappedService(
		DgfDuplctLicnsReasonLocalService dgfDuplctLicnsReasonLocalService) {

		_dgfDuplctLicnsReasonLocalService = dgfDuplctLicnsReasonLocalService;
	}

	private DgfDuplctLicnsReasonLocalService _dgfDuplctLicnsReasonLocalService;

}