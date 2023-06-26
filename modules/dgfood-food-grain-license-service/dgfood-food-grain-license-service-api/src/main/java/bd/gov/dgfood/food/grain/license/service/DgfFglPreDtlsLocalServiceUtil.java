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

import bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for DgfFglPreDtls. This utility wraps
 * <code>bd.gov.dgfood.food.grain.license.service.impl.DgfFglPreDtlsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DgfFglPreDtlsLocalService
 * @generated
 */
public class DgfFglPreDtlsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>bd.gov.dgfood.food.grain.license.service.impl.DgfFglPreDtlsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static DgfFglPreDtls addDgfFglPreDtls(DgfFglPreDtls dgfFglPreDtls) {
		return getService().addDgfFglPreDtls(dgfFglPreDtls);
	}

	public static boolean checkAcfUsersExistByLocation(long fglPrePrimaryId) {
		return getService().checkAcfUsersExistByLocation(fglPrePrimaryId);
	}

	public static boolean checkCcdrUsersExistByLocation(long fglPrePrimaryId) {
		return getService().checkCcdrUsersExistByLocation(fglPrePrimaryId);
	}

	/**
	 * Creates a new dgf fgl pre dtls with the primary key. Does not add the dgf fgl pre dtls to the database.
	 *
	 * @param fglPrePrimaryId the primary key for the new dgf fgl pre dtls
	 * @return the new dgf fgl pre dtls
	 */
	public static DgfFglPreDtls createDgfFglPreDtls(long fglPrePrimaryId) {
		return getService().createDgfFglPreDtls(fglPrePrimaryId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static DgfFglPreDtls deleteDgfFglPreDtls(
		DgfFglPreDtls dgfFglPreDtls) {

		return getService().deleteDgfFglPreDtls(dgfFglPreDtls);
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
	public static DgfFglPreDtls deleteDgfFglPreDtls(long fglPrePrimaryId)
		throws PortalException {

		return getService().deleteDgfFglPreDtls(fglPrePrimaryId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static DgfFglPreDtls fetchDgfFglPreDtls(long fglPrePrimaryId) {
		return getService().fetchDgfFglPreDtls(fglPrePrimaryId);
	}

	public static void generateLicenseNumberAndStoreData(long classPk) {
		getService().generateLicenseNumberAndStoreData(classPk);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static void getCcdrUserIdByLocationAndSendNotificationByNodeId(
		long fglPrePrimaryId, String nodeId) {

		getService().getCcdrUserIdByLocationAndSendNotificationByNodeId(
			fglPrePrimaryId, nodeId);
	}

	public static void getDcfUserIdByLocationAndSendNotificationByNodeId(
		long fglPrePrimaryId, String nodeId) {

		getService().getDcfUserIdByLocationAndSendNotificationByNodeId(
			fglPrePrimaryId, nodeId);
	}

	public static Map<String, Object> getDetailsData(
		long fglPrePrimaryId, long renewLicenseId,
		long duplicateLicenseReasonId) {

		return getService().getDetailsData(
			fglPrePrimaryId, renewLicenseId, duplicateLicenseReasonId);
	}

	public static DgfFglPreDtls getDgfFglPreDtlObjectByUserIdAndWorkflowTaskId(
			long userId, long workflowTaskId)
		throws PortalException {

		return getService().getDgfFglPreDtlObjectByUserIdAndWorkflowTaskId(
			userId, workflowTaskId);
	}

	public static DgfFglPreDtls getdgfFglPreDtls(long nidId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getService().getdgfFglPreDtls(nidId);
	}

	/**
	 * Returns the dgf fgl pre dtls with the primary key.
	 *
	 * @param fglPrePrimaryId the primary key of the dgf fgl pre dtls
	 * @return the dgf fgl pre dtls
	 * @throws PortalException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public static DgfFglPreDtls getDgfFglPreDtls(long fglPrePrimaryId)
		throws PortalException {

		return getService().getDgfFglPreDtls(fglPrePrimaryId);
	}

	public static DgfFglPreDtls getdgfFglPreDtls(String fglApplicationNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getService().getdgfFglPreDtls(fglApplicationNo);
	}

	public static DgfFglPreDtls getDgfFglPreDtlsByNID(long nationalId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getService().getDgfFglPreDtlsByNID(nationalId);
	}

	public static List<DgfFglPreDtls> getDgfFglPreDtlsByUserId(long userId)
		throws PortalException {

		return getService().getDgfFglPreDtlsByUserId(userId);
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
	public static List<DgfFglPreDtls> getDgfFglPreDtlses(int start, int end) {
		return getService().getDgfFglPreDtlses(start, end);
	}

	/**
	 * Returns the number of dgf fgl pre dtlses.
	 *
	 * @return the number of dgf fgl pre dtlses
	 */
	public static int getDgfFglPreDtlsesCount() {
		return getService().getDgfFglPreDtlsesCount();
	}

	public static String getDuplicateLicenseFormSubmitMessage() {
		return getService().getDuplicateLicenseFormSubmitMessage();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static String getLicenseFormSubmitMessage() {
		return getService().getLicenseFormSubmitMessage();
	}

	public static byte[] getLicenseReport(String queryParams) {
		return getService().getLicenseReport(queryParams);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static String getRenewLicenseFormSubmitMessage() {
		return getService().getRenewLicenseFormSubmitMessage();
	}

	public static List<Map<String, Object>> getSearchResultByDateFrom(
		String dateFrom, String dateTo, String dateType, String applicationNo,
		String businessType, int status, String licenseType, long roleId,
		String upazillaOrDistrict, long companyId) {

		return getService().getSearchResultByDateFrom(
			dateFrom, dateTo, dateType, applicationNo, businessType, status,
			licenseType, roleId, upazillaOrDistrict, companyId);
	}

	public static void getUcfUserIdByLocationAndSendNotificationByNodeId(
		long fglPrePrimaryId, String nodeId) {

		getService().getUcfUserIdByLocationAndSendNotificationByNodeId(
			fglPrePrimaryId, nodeId);
	}

	public static String getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(
		DgfFglPreDtls dgfFglPreDtls, String nodeId) {

		return getService().
			getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(
				dgfFglPreDtls, nodeId);
	}

	public static com.liferay.portal.kernel.model.WorkflowInstanceLink
			getWorkflowInstanceLinkByUserId(long userId, long classPk)
		throws PortalException {

		return getService().getWorkflowInstanceLinkByUserId(userId, classPk);
	}

	public static com.liferay.portal.kernel.workflow.WorkflowTask
			getWorkflowTaskByCompanyIdAndWorkflowInstanceId(
				long companyId, long workflowInstanceId)
		throws PortalException {

		return getService().getWorkflowTaskByCompanyIdAndWorkflowInstanceId(
			companyId, workflowInstanceId);
	}

	public static long getWorkflowTaskIdByCompanyIdAndWorkflowInstanceId(
		long companyId, long workflowInstanceId) {

		return getService().getWorkflowTaskIdByCompanyIdAndWorkflowInstanceId(
			companyId, workflowInstanceId);
	}

	public static DgfFglPreDtls saveDgfFglPreDtls(String nationalId) {
		return getService().saveDgfFglPreDtls(nationalId);
	}

	public static void sendAcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		getService().sendAcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
			classPk, nodeId);
	}

	public static void sendAcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		getService().sendAcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
			classPk, nodeId);
	}

	public static void
		sendCcdrApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
			long classPk, String nodeId) {

		getService().sendCcdrApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
			classPk, nodeId);
	}

	public static void sendCcdrRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		getService().sendCcdrRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
			classPk, nodeId);
	}

	public static void sendDcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		getService().sendDcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
			classPk, nodeId);
	}

	public static void sendDcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		getService().sendDcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
			classPk, nodeId);
	}

	public static void sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		getService().sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
			classPk, nodeId);
	}

	public static void
		sendUcfOrDcfPaymentRequestSmsWithWorkflowCommentsByClassPkAndNodeId(
			long classPk, String nodeId) {

		getService().
			sendUcfOrDcfPaymentRequestSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	public static void sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		getService().sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
			classPk, nodeId);
	}

	public static void setLicenseAcfUserNotificationEvent(
		long fglPrePrimaryId) {

		getService().setLicenseAcfUserNotificationEvent(fglPrePrimaryId);
	}

	public static void setLicenseUcfUserNotificationEvent(
		long fglPrePrimaryId) {

		getService().setLicenseUcfUserNotificationEvent(fglPrePrimaryId);
	}

	public static void setUserLicenseAndMessageAndLoginActivity(
		long fglPrePrimaryId) {

		getService().setUserLicenseAndMessageAndLoginActivity(fglPrePrimaryId);
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
	public static DgfFglPreDtls updateDgfFglPreDtls(
		DgfFglPreDtls dgfFglPreDtls) {

		return getService().updateDgfFglPreDtls(dgfFglPreDtls);
	}

	public static DgfFglPreDtls updateStatus(
			long userId, long resourcePrimKey, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateStatus(
			userId, resourcePrimKey, status, serviceContext);
	}

	public static DgfFglPreDtlsLocalService getService() {
		return _service;
	}

	private static volatile DgfFglPreDtlsLocalService _service;

}