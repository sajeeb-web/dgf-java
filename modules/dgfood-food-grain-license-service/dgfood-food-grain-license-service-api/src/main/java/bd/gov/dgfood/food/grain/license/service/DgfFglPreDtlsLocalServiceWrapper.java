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
 * Provides a wrapper for {@link DgfFglPreDtlsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfFglPreDtlsLocalService
 * @generated
 */
public class DgfFglPreDtlsLocalServiceWrapper
	implements DgfFglPreDtlsLocalService,
			   ServiceWrapper<DgfFglPreDtlsLocalService> {

	public DgfFglPreDtlsLocalServiceWrapper() {
		this(null);
	}

	public DgfFglPreDtlsLocalServiceWrapper(
		DgfFglPreDtlsLocalService dgfFglPreDtlsLocalService) {

		_dgfFglPreDtlsLocalService = dgfFglPreDtlsLocalService;
	}

	/**
	 * Adds the dgf fgl pre dtls to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfFglPreDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfFglPreDtls the dgf fgl pre dtls
	 * @return the dgf fgl pre dtls that was added
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls
		addDgfFglPreDtls(
			bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls
				dgfFglPreDtls) {

		return _dgfFglPreDtlsLocalService.addDgfFglPreDtls(dgfFglPreDtls);
	}

	@Override
	public boolean checkAcfUsersExistByLocation(long fglPrePrimaryId) {
		return _dgfFglPreDtlsLocalService.checkAcfUsersExistByLocation(
			fglPrePrimaryId);
	}

	@Override
	public boolean checkCcdrUsersExistByLocation(long fglPrePrimaryId) {
		return _dgfFglPreDtlsLocalService.checkCcdrUsersExistByLocation(
			fglPrePrimaryId);
	}

	/**
	 * Creates a new dgf fgl pre dtls with the primary key. Does not add the dgf fgl pre dtls to the database.
	 *
	 * @param fglPrePrimaryId the primary key for the new dgf fgl pre dtls
	 * @return the new dgf fgl pre dtls
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls
		createDgfFglPreDtls(long fglPrePrimaryId) {

		return _dgfFglPreDtlsLocalService.createDgfFglPreDtls(fglPrePrimaryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfFglPreDtlsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the dgf fgl pre dtls from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfFglPreDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfFglPreDtls the dgf fgl pre dtls
	 * @return the dgf fgl pre dtls that was removed
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls
		deleteDgfFglPreDtls(
			bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls
				dgfFglPreDtls) {

		return _dgfFglPreDtlsLocalService.deleteDgfFglPreDtls(dgfFglPreDtls);
	}

	/**
	 * Deletes the dgf fgl pre dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfFglPreDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fglPrePrimaryId the primary key of the dgf fgl pre dtls
	 * @return the dgf fgl pre dtls that was removed
	 * @throws PortalException if a dgf fgl pre dtls with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls
			deleteDgfFglPreDtls(long fglPrePrimaryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfFglPreDtlsLocalService.deleteDgfFglPreDtls(fglPrePrimaryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfFglPreDtlsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgfFglPreDtlsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgfFglPreDtlsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgfFglPreDtlsLocalService.dynamicQuery();
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

		return _dgfFglPreDtlsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfFglPreDtlsModelImpl</code>.
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

		return _dgfFglPreDtlsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfFglPreDtlsModelImpl</code>.
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

		return _dgfFglPreDtlsLocalService.dynamicQuery(
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

		return _dgfFglPreDtlsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dgfFglPreDtlsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls
		fetchDgfFglPreDtls(long fglPrePrimaryId) {

		return _dgfFglPreDtlsLocalService.fetchDgfFglPreDtls(fglPrePrimaryId);
	}

	@Override
	public void generateLicenseNumberAndStoreData(long classPk) {
		_dgfFglPreDtlsLocalService.generateLicenseNumberAndStoreData(classPk);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgfFglPreDtlsLocalService.getActionableDynamicQuery();
	}

	@Override
	public void getCcdrUserIdByLocationAndSendNotificationByNodeId(
		long fglPrePrimaryId, String nodeId) {

		_dgfFglPreDtlsLocalService.
			getCcdrUserIdByLocationAndSendNotificationByNodeId(
				fglPrePrimaryId, nodeId);
	}

	@Override
	public void getDcfUserIdByLocationAndSendNotificationByNodeId(
		long fglPrePrimaryId, String nodeId) {

		_dgfFglPreDtlsLocalService.
			getDcfUserIdByLocationAndSendNotificationByNodeId(
				fglPrePrimaryId, nodeId);
	}

	@Override
	public java.util.Map<String, Object> getDetailsData(
		long fglPrePrimaryId, long renewLicenseId,
		long duplicateLicenseReasonId) {

		return _dgfFglPreDtlsLocalService.getDetailsData(
			fglPrePrimaryId, renewLicenseId, duplicateLicenseReasonId);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls
			getDgfFglPreDtlObjectByUserIdAndWorkflowTaskId(
				long userId, long workflowTaskId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfFglPreDtlsLocalService.
			getDgfFglPreDtlObjectByUserIdAndWorkflowTaskId(
				userId, workflowTaskId);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls
			getdgfFglPreDtls(long nidId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return _dgfFglPreDtlsLocalService.getdgfFglPreDtls(nidId);
	}

	/**
	 * Returns the dgf fgl pre dtls with the primary key.
	 *
	 * @param fglPrePrimaryId the primary key of the dgf fgl pre dtls
	 * @return the dgf fgl pre dtls
	 * @throws PortalException if a dgf fgl pre dtls with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls
			getDgfFglPreDtls(long fglPrePrimaryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfFglPreDtlsLocalService.getDgfFglPreDtls(fglPrePrimaryId);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls
			getdgfFglPreDtls(String fglApplicationNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return _dgfFglPreDtlsLocalService.getdgfFglPreDtls(fglApplicationNo);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls
			getDgfFglPreDtlsByNID(long nationalId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return _dgfFglPreDtlsLocalService.getDgfFglPreDtlsByNID(nationalId);
	}

	@Override
	public java.util.List<bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls>
			getDgfFglPreDtlsByUserId(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfFglPreDtlsLocalService.getDgfFglPreDtlsByUserId(userId);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of dgf fgl pre dtlses
	 */
	@Override
	public java.util.List<bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls>
		getDgfFglPreDtlses(int start, int end) {

		return _dgfFglPreDtlsLocalService.getDgfFglPreDtlses(start, end);
	}

	/**
	 * Returns the number of dgf fgl pre dtlses.
	 *
	 * @return the number of dgf fgl pre dtlses
	 */
	@Override
	public int getDgfFglPreDtlsesCount() {
		return _dgfFglPreDtlsLocalService.getDgfFglPreDtlsesCount();
	}

	@Override
	public String getDuplicateLicenseFormSubmitMessage() {
		return _dgfFglPreDtlsLocalService.
			getDuplicateLicenseFormSubmitMessage();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgfFglPreDtlsLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public String getLicenseFormSubmitMessage() {
		return _dgfFglPreDtlsLocalService.getLicenseFormSubmitMessage();
	}

	@Override
	public byte[] getLicenseReport(String queryParams) {
		return _dgfFglPreDtlsLocalService.getLicenseReport(queryParams);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfFglPreDtlsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfFglPreDtlsLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public String getRenewLicenseFormSubmitMessage() {
		return _dgfFglPreDtlsLocalService.getRenewLicenseFormSubmitMessage();
	}

	@Override
	public java.util.List<java.util.Map<String, Object>>
		getSearchResultByDateFrom(
			String dateFrom, String dateTo, String dateType,
			String applicationNo, String businessType, int status,
			String licenseType, long roleId, String upazillaOrDistrict,
			long companyId) {

		return _dgfFglPreDtlsLocalService.getSearchResultByDateFrom(
			dateFrom, dateTo, dateType, applicationNo, businessType, status,
			licenseType, roleId, upazillaOrDistrict, companyId);
	}

	@Override
	public void getUcfUserIdByLocationAndSendNotificationByNodeId(
		long fglPrePrimaryId, String nodeId) {

		_dgfFglPreDtlsLocalService.
			getUcfUserIdByLocationAndSendNotificationByNodeId(
				fglPrePrimaryId, nodeId);
	}

	@Override
	public String getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(
		bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls dgfFglPreDtls,
		String nodeId) {

		return _dgfFglPreDtlsLocalService.
			getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(
				dgfFglPreDtls, nodeId);
	}

	@Override
	public com.liferay.portal.kernel.model.WorkflowInstanceLink
			getWorkflowInstanceLinkByUserId(long userId, long classPk)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfFglPreDtlsLocalService.getWorkflowInstanceLinkByUserId(
			userId, classPk);
	}

	@Override
	public com.liferay.portal.kernel.workflow.WorkflowTask
			getWorkflowTaskByCompanyIdAndWorkflowInstanceId(
				long companyId, long workflowInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfFglPreDtlsLocalService.
			getWorkflowTaskByCompanyIdAndWorkflowInstanceId(
				companyId, workflowInstanceId);
	}

	@Override
	public long getWorkflowTaskIdByCompanyIdAndWorkflowInstanceId(
		long companyId, long workflowInstanceId) {

		return _dgfFglPreDtlsLocalService.
			getWorkflowTaskIdByCompanyIdAndWorkflowInstanceId(
				companyId, workflowInstanceId);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls
		saveDgfFglPreDtls(String nationalId) {

		return _dgfFglPreDtlsLocalService.saveDgfFglPreDtls(nationalId);
	}

	@Override
	public void sendAcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfFglPreDtlsLocalService.
			sendAcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendAcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfFglPreDtlsLocalService.
			sendAcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendCcdrApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfFglPreDtlsLocalService.
			sendCcdrApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendCcdrRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfFglPreDtlsLocalService.
			sendCcdrRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendDcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfFglPreDtlsLocalService.
			sendDcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendDcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfFglPreDtlsLocalService.
			sendDcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfFglPreDtlsLocalService.
			sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void
		sendUcfOrDcfPaymentRequestSmsWithWorkflowCommentsByClassPkAndNodeId(
			long classPk, String nodeId) {

		_dgfFglPreDtlsLocalService.
			sendUcfOrDcfPaymentRequestSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfFglPreDtlsLocalService.
			sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void setLicenseAcfUserNotificationEvent(long fglPrePrimaryId) {
		_dgfFglPreDtlsLocalService.setLicenseAcfUserNotificationEvent(
			fglPrePrimaryId);
	}

	@Override
	public void setLicenseUcfUserNotificationEvent(long fglPrePrimaryId) {
		_dgfFglPreDtlsLocalService.setLicenseUcfUserNotificationEvent(
			fglPrePrimaryId);
	}

	@Override
	public void setUserLicenseAndMessageAndLoginActivity(long fglPrePrimaryId) {
		_dgfFglPreDtlsLocalService.setUserLicenseAndMessageAndLoginActivity(
			fglPrePrimaryId);
	}

	/**
	 * Updates the dgf fgl pre dtls in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfFglPreDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfFglPreDtls the dgf fgl pre dtls
	 * @return the dgf fgl pre dtls that was updated
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls
		updateDgfFglPreDtls(
			bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls
				dgfFglPreDtls) {

		return _dgfFglPreDtlsLocalService.updateDgfFglPreDtls(dgfFglPreDtls);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls updateStatus(
			long userId, long resourcePrimKey, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfFglPreDtlsLocalService.updateStatus(
			userId, resourcePrimKey, status, serviceContext);
	}

	@Override
	public DgfFglPreDtlsLocalService getWrappedService() {
		return _dgfFglPreDtlsLocalService;
	}

	@Override
	public void setWrappedService(
		DgfFglPreDtlsLocalService dgfFglPreDtlsLocalService) {

		_dgfFglPreDtlsLocalService = dgfFglPreDtlsLocalService;
	}

	private DgfFglPreDtlsLocalService _dgfFglPreDtlsLocalService;

}