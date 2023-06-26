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

import bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DgfDuplctLicnsReason. This utility wraps
 * <code>bd.gov.dgfood.food.grain.license.service.impl.DgfDuplctLicnsReasonLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDuplctLicnsReasonLocalService
 * @generated
 */
public class DgfDuplctLicnsReasonLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>bd.gov.dgfood.food.grain.license.service.impl.DgfDuplctLicnsReasonLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static DgfDuplctLicnsReason addDgfDuplctLicnsReason(
		DgfDuplctLicnsReason dgfDuplctLicnsReason) {

		return getService().addDgfDuplctLicnsReason(dgfDuplctLicnsReason);
	}

	/**
	 * Creates a new dgf duplct licns reason with the primary key. Does not add the dgf duplct licns reason to the database.
	 *
	 * @param duplicateLicenseReasonID the primary key for the new dgf duplct licns reason
	 * @return the new dgf duplct licns reason
	 */
	public static DgfDuplctLicnsReason createDgfDuplctLicnsReason(
		long duplicateLicenseReasonID) {

		return getService().createDgfDuplctLicnsReason(
			duplicateLicenseReasonID);
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
	 * Deletes the dgf duplct licns reason from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDuplctLicnsReasonLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDuplctLicnsReason the dgf duplct licns reason
	 * @return the dgf duplct licns reason that was removed
	 */
	public static DgfDuplctLicnsReason deleteDgfDuplctLicnsReason(
		DgfDuplctLicnsReason dgfDuplctLicnsReason) {

		return getService().deleteDgfDuplctLicnsReason(dgfDuplctLicnsReason);
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
	public static DgfDuplctLicnsReason deleteDgfDuplctLicnsReason(
			long duplicateLicenseReasonID)
		throws PortalException {

		return getService().deleteDgfDuplctLicnsReason(
			duplicateLicenseReasonID);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfDuplctLicnsReasonModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfDuplctLicnsReasonModelImpl</code>.
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

	public static DgfDuplctLicnsReason fetchDgfDuplctLicnsReason(
		long duplicateLicenseReasonID) {

		return getService().fetchDgfDuplctLicnsReason(duplicateLicenseReasonID);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static void getDcfUserIdByLocationAndSendNotificationByNodeId(
		long classPK, String nodeId) {

		getService().getDcfUserIdByLocationAndSendNotificationByNodeId(
			classPK, nodeId);
	}

	/**
	 * Returns the dgf duplct licns reason with the primary key.
	 *
	 * @param duplicateLicenseReasonID the primary key of the dgf duplct licns reason
	 * @return the dgf duplct licns reason
	 * @throws PortalException if a dgf duplct licns reason with the primary key could not be found
	 */
	public static DgfDuplctLicnsReason getDgfDuplctLicnsReason(
			long duplicateLicenseReasonID)
		throws PortalException {

		return getService().getDgfDuplctLicnsReason(duplicateLicenseReasonID);
	}

	public static DgfDuplctLicnsReason getDgfDuplctLicnsReasonByFglPrePrimary(
			long fglPrePrimaryId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDuplctLicnsReasonException {

		return getService().getDgfDuplctLicnsReasonByFglPrePrimary(
			fglPrePrimaryId);
	}

	public static DgfDuplctLicnsReason getDgfDuplctLicnsReasonByNid(
			String nationalId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDuplctLicnsReasonException {

		return getService().getDgfDuplctLicnsReasonByNid(nationalId);
	}

	public static DgfDuplctLicnsReason getDgfDuplctLicnsReasonByPaymentAttchId(
			long paymentAttchId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDuplctLicnsReasonException {

		return getService().getDgfDuplctLicnsReasonByPaymentAttchId(
			paymentAttchId);
	}

	public static DgfDuplctLicnsReason getDgfDuplctLicnsReasonByTradeLicAttchId(
			long tradeLicAttchId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDuplctLicnsReasonException {

		return getService().getDgfDuplctLicnsReasonByTradeLicAttchId(
			tradeLicAttchId);
	}

	public static DgfDuplctLicnsReason getDgfDuplctLicnsReasonByUserId(
			long userId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDuplctLicnsReasonException {

		return getService().getDgfDuplctLicnsReasonByUserId(userId);
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
	public static List<DgfDuplctLicnsReason> getDgfDuplctLicnsReasons(
		int start, int end) {

		return getService().getDgfDuplctLicnsReasons(start, end);
	}

	/**
	 * Returns the number of dgf duplct licns reasons.
	 *
	 * @return the number of dgf duplct licns reasons
	 */
	public static int getDgfDuplctLicnsReasonsCount() {
		return getService().getDgfDuplctLicnsReasonsCount();
	}

	public static List<DgfDuplctLicnsReason> getDgfDupLicByNationalIdAndLicense(
		String nationalId, String licenseNo) {

		return getService().getDgfDupLicByNationalIdAndLicense(
			nationalId, licenseNo);
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

	public static void sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		getService().sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
			classPk, nodeId);
	}

	public static void setLicenseAcfUserNotificationEvent(long classPK) {
		getService().setLicenseAcfUserNotificationEvent(classPK);
	}

	public static void setLicenseCcdrUserNotificationEvent(long classPK) {
		getService().setLicenseCcdrUserNotificationEvent(classPK);
	}

	public static void setLicenseUcfUserNotificationEvent(long classPK) {
		getService().setLicenseUcfUserNotificationEvent(classPK);
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
	public static DgfDuplctLicnsReason updateDgfDuplctLicnsReason(
		DgfDuplctLicnsReason dgfDuplctLicnsReason) {

		return getService().updateDgfDuplctLicnsReason(dgfDuplctLicnsReason);
	}

	public static DgfDuplctLicnsReason updateStatus(
			long userId, long resourcePrimKey, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateStatus(
			userId, resourcePrimKey, status, serviceContext);
	}

	public static DgfDuplctLicnsReasonLocalService getService() {
		return _service;
	}

	private static volatile DgfDuplctLicnsReasonLocalService _service;

}