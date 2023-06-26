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

package bd.gov.dgfood.dealer.registration.service;

import bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for DgfDlrRegDtls. This utility wraps
 * <code>bd.gov.dgfood.dealer.registration.service.impl.DgfDlrRegDtlsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrRegDtlsLocalService
 * @generated
 */
public class DgfDlrRegDtlsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>bd.gov.dgfood.dealer.registration.service.impl.DgfDlrRegDtlsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static boolean addDealerRegisterWorkflowAndSendMessage(
		long dlrRegNo, String nationalId) {

		return getService().addDealerRegisterWorkflowAndSendMessage(
			dlrRegNo, nationalId);
	}

	/**
	 * Adds the dgf dlr reg dtls to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrRegDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDlrRegDtls the dgf dlr reg dtls
	 * @return the dgf dlr reg dtls that was added
	 */
	public static DgfDlrRegDtls addDgfDlrRegDtls(DgfDlrRegDtls dgfDlrRegDtls) {
		return getService().addDgfDlrRegDtls(dgfDlrRegDtls);
	}

	public static void addDlrRegsDtlsPermission(DgfDlrRegDtls dlrRegDltsObj) {
		getService().addDlrRegsDtlsPermission(dlrRegDltsObj);
	}

	public static boolean checkCcdrUsersExistByLocation(long classPK) {
		return getService().checkCcdrUsersExistByLocation(classPK);
	}

	public static boolean checkDcfUsersExistByLocation(long classPK) {
		return getService().checkDcfUsersExistByLocation(classPK);
	}

	public static boolean checkRcfUsersExistByLocation(long classPK) {
		return getService().checkRcfUsersExistByLocation(classPK);
	}

	public static boolean checkUcfUsersExistByLocation(long classPK) {
		return getService().checkUcfUsersExistByLocation(classPK);
	}

	/**
	 * Creates a new dgf dlr reg dtls with the primary key. Does not add the dgf dlr reg dtls to the database.
	 *
	 * @param dlrRegNo the primary key for the new dgf dlr reg dtls
	 * @return the new dgf dlr reg dtls
	 */
	public static DgfDlrRegDtls createDgfDlrRegDtls(long dlrRegNo) {
		return getService().createDgfDlrRegDtls(dlrRegNo);
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
	 * Deletes the dgf dlr reg dtls from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrRegDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDlrRegDtls the dgf dlr reg dtls
	 * @return the dgf dlr reg dtls that was removed
	 */
	public static DgfDlrRegDtls deleteDgfDlrRegDtls(
		DgfDlrRegDtls dgfDlrRegDtls) {

		return getService().deleteDgfDlrRegDtls(dgfDlrRegDtls);
	}

	/**
	 * Deletes the dgf dlr reg dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrRegDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dlrRegNo the primary key of the dgf dlr reg dtls
	 * @return the dgf dlr reg dtls that was removed
	 * @throws PortalException if a dgf dlr reg dtls with the primary key could not be found
	 */
	public static DgfDlrRegDtls deleteDgfDlrRegDtls(long dlrRegNo)
		throws PortalException {

		return getService().deleteDgfDlrRegDtls(dlrRegNo);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.dealer.registration.model.impl.DgfDlrRegDtlsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.dealer.registration.model.impl.DgfDlrRegDtlsModelImpl</code>.
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

	public static DgfDlrRegDtls fetchDgfDlrRegDtls(long dlrRegNo) {
		return getService().fetchDgfDlrRegDtls(dlrRegNo);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static Map<String, String> getAllAddrs(String nid)
		throws PortalException {

		return getService().getAllAddrs(nid);
	}

	public static Map<String, Object> getDealerData(String nid) {
		return getService().getDealerData(nid);
	}

	public static String getDealerFormSubmitMessage() {
		return getService().getDealerFormSubmitMessage();
	}

	public static Map getDealerProfileData() {
		return getService().getDealerProfileData();
	}

	/**
	 * Returns the dgf dlr reg dtls with the primary key.
	 *
	 * @param dlrRegNo the primary key of the dgf dlr reg dtls
	 * @return the dgf dlr reg dtls
	 * @throws PortalException if a dgf dlr reg dtls with the primary key could not be found
	 */
	public static DgfDlrRegDtls getDgfDlrRegDtls(long dlrRegNo)
		throws PortalException {

		return getService().getDgfDlrRegDtls(dlrRegNo);
	}

	public static DgfDlrRegDtls getDgfDlrRegDtlsByNationalIdAndLicenseNo(
		String nationalId, String licenseNo, long regNo) {

		return getService().getDgfDlrRegDtlsByNationalIdAndLicenseNo(
			nationalId, licenseNo, regNo);
	}

	public static DgfDlrRegDtls getDgfDlrRegDtlsByNid(String nid) {
		return getService().getDgfDlrRegDtlsByNid(nid);
	}

	public static DgfDlrRegDtls getDgfDlrRegDtlsByUserId(long userId) {
		return getService().getDgfDlrRegDtlsByUserId(userId);
	}

	/**
	 * Returns a range of all the dgf dlr reg dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.dealer.registration.model.impl.DgfDlrRegDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr reg dtlses
	 * @param end the upper bound of the range of dgf dlr reg dtlses (not inclusive)
	 * @return the range of dgf dlr reg dtlses
	 */
	public static List<DgfDlrRegDtls> getDgfDlrRegDtlses(int start, int end) {
		return getService().getDgfDlrRegDtlses(start, end);
	}

	/**
	 * Returns the number of dgf dlr reg dtlses.
	 *
	 * @return the number of dgf dlr reg dtlses
	 */
	public static int getDgfDlrRegDtlsesCount() {
		return getService().getDgfDlrRegDtlsesCount();
	}

	public static List<Map<String, Object>> getDlrListSearchResult(
		String dateFrom, String dateTo, String dateType, String nid, long union,
		String dealerType, int status, long roleId, String upazillaOrDistrict,
		long companyId) {

		return getService().getDlrListSearchResult(
			dateFrom, dateTo, dateType, nid, union, dealerType, status, roleId,
			upazillaOrDistrict, companyId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
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

	public static DgfDlrRegDtls saveFinalSubmitData(String nid) {
		return getService().saveFinalSubmitData(nid);
	}

	public static DgfDlrRegDtls saveRegData(
		String licenseNo, java.util.Date licnsIssueDate, String dealerShipType,
		String omsSubType, String nid, java.util.Date dob, String maritalStatus,
		String spouseName, String spouseFatherName, String spouseNid,
		java.util.Date spouseDob) {

		return getService().saveRegData(
			licenseNo, licnsIssueDate, dealerShipType, omsSubType, nid, dob,
			maritalStatus, spouseName, spouseFatherName, spouseNid, spouseDob);
	}

	public static DgfDlrRegDtls saveRegDocData(
		String nid, long bankSolvCertAttchId, long taxRtrnCertAttchId,
		long shopOwnrshpDocAttchId, long shopRentalDocAttchId,
		long signOrThumbPicAttchId) {

		return getService().saveRegDocData(
			nid, bankSolvCertAttchId, taxRtrnCertAttchId, shopOwnrshpDocAttchId,
			shopRentalDocAttchId, signOrThumbPicAttchId);
	}

	public static DgfDlrRegDtls saveRegLocData(
		String nid, long shopDiv, long shopDis, long shopUpazila,
		long shopUnion) {

		return getService().saveRegLocData(
			nid, shopDiv, shopDis, shopUpazila, shopUnion);
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

	public static void sendRcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		getService().sendRcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
			classPk, nodeId);
	}

	public static void sendRcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		getService().sendRcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
			classPk, nodeId);
	}

	public static void sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		getService().sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
			classPk, nodeId);
	}

	public static void sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		getService().sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
			classPk, nodeId);
	}

	public static void setDealerCcdrUserNotificationEvent(long classPK) {
		getService().setDealerCcdrUserNotificationEvent(classPK);
	}

	public static void setDealerDcfUserNotificationEvent(long classPK) {
		getService().setDealerDcfUserNotificationEvent(classPK);
	}

	public static void setDealerRcfUserNotificationEvent(long classPK) {
		getService().setDealerRcfUserNotificationEvent(classPK);
	}

	public static void setDealerUcfUserNotificationEvent(long classPK) {
		getService().setDealerUcfUserNotificationEvent(classPK);
	}

	/**
	 * Updates the dgf dlr reg dtls in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrRegDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDlrRegDtls the dgf dlr reg dtls
	 * @return the dgf dlr reg dtls that was updated
	 */
	public static DgfDlrRegDtls updateDgfDlrRegDtls(
		DgfDlrRegDtls dgfDlrRegDtls) {

		return getService().updateDgfDlrRegDtls(dgfDlrRegDtls);
	}

	public static DgfDlrRegDtls updateStatus(
			long userId, long resourcePrimKey, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateStatus(
			userId, resourcePrimKey, status, serviceContext);
	}

	public static bd.gov.dgfood.food.grain.license.model.DgfAttachments
		uploadFile(
			javax.portlet.ActionRequest actionRequest, String nationalId,
			String realPath, java.util.ResourceBundle bundle, String filecat,
			String attachmentInputName) {

		return getService().uploadFile(
			actionRequest, nationalId, realPath, bundle, filecat,
			attachmentInputName);
	}

	public static DgfDlrRegDtlsLocalService getService() {
		return _service;
	}

	private static volatile DgfDlrRegDtlsLocalService _service;

}