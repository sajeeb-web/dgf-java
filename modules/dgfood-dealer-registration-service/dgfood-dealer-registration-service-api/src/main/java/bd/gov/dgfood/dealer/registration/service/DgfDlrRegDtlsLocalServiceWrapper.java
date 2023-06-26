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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DgfDlrRegDtlsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrRegDtlsLocalService
 * @generated
 */
public class DgfDlrRegDtlsLocalServiceWrapper
	implements DgfDlrRegDtlsLocalService,
			   ServiceWrapper<DgfDlrRegDtlsLocalService> {

	public DgfDlrRegDtlsLocalServiceWrapper() {
		this(null);
	}

	public DgfDlrRegDtlsLocalServiceWrapper(
		DgfDlrRegDtlsLocalService dgfDlrRegDtlsLocalService) {

		_dgfDlrRegDtlsLocalService = dgfDlrRegDtlsLocalService;
	}

	@Override
	public boolean addDealerRegisterWorkflowAndSendMessage(
		long dlrRegNo, String nationalId) {

		return _dgfDlrRegDtlsLocalService.
			addDealerRegisterWorkflowAndSendMessage(dlrRegNo, nationalId);
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
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls
		addDgfDlrRegDtls(
			bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls
				dgfDlrRegDtls) {

		return _dgfDlrRegDtlsLocalService.addDgfDlrRegDtls(dgfDlrRegDtls);
	}

	@Override
	public void addDlrRegsDtlsPermission(
		bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls dlrRegDltsObj) {

		_dgfDlrRegDtlsLocalService.addDlrRegsDtlsPermission(dlrRegDltsObj);
	}

	@Override
	public boolean checkCcdrUsersExistByLocation(long classPK) {
		return _dgfDlrRegDtlsLocalService.checkCcdrUsersExistByLocation(
			classPK);
	}

	@Override
	public boolean checkDcfUsersExistByLocation(long classPK) {
		return _dgfDlrRegDtlsLocalService.checkDcfUsersExistByLocation(classPK);
	}

	@Override
	public boolean checkRcfUsersExistByLocation(long classPK) {
		return _dgfDlrRegDtlsLocalService.checkRcfUsersExistByLocation(classPK);
	}

	@Override
	public boolean checkUcfUsersExistByLocation(long classPK) {
		return _dgfDlrRegDtlsLocalService.checkUcfUsersExistByLocation(classPK);
	}

	/**
	 * Creates a new dgf dlr reg dtls with the primary key. Does not add the dgf dlr reg dtls to the database.
	 *
	 * @param dlrRegNo the primary key for the new dgf dlr reg dtls
	 * @return the new dgf dlr reg dtls
	 */
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls
		createDgfDlrRegDtls(long dlrRegNo) {

		return _dgfDlrRegDtlsLocalService.createDgfDlrRegDtls(dlrRegNo);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrRegDtlsLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls
		deleteDgfDlrRegDtls(
			bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls
				dgfDlrRegDtls) {

		return _dgfDlrRegDtlsLocalService.deleteDgfDlrRegDtls(dgfDlrRegDtls);
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
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls
			deleteDgfDlrRegDtls(long dlrRegNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrRegDtlsLocalService.deleteDgfDlrRegDtls(dlrRegNo);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrRegDtlsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgfDlrRegDtlsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgfDlrRegDtlsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgfDlrRegDtlsLocalService.dynamicQuery();
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

		return _dgfDlrRegDtlsLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _dgfDlrRegDtlsLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _dgfDlrRegDtlsLocalService.dynamicQuery(
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

		return _dgfDlrRegDtlsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dgfDlrRegDtlsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls
		fetchDgfDlrRegDtls(long dlrRegNo) {

		return _dgfDlrRegDtlsLocalService.fetchDgfDlrRegDtls(dlrRegNo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgfDlrRegDtlsLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.Map<String, String> getAllAddrs(String nid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrRegDtlsLocalService.getAllAddrs(nid);
	}

	@Override
	public java.util.Map<String, Object> getDealerData(String nid) {
		return _dgfDlrRegDtlsLocalService.getDealerData(nid);
	}

	@Override
	public String getDealerFormSubmitMessage() {
		return _dgfDlrRegDtlsLocalService.getDealerFormSubmitMessage();
	}

	@Override
	public java.util.Map getDealerProfileData() {
		return _dgfDlrRegDtlsLocalService.getDealerProfileData();
	}

	/**
	 * Returns the dgf dlr reg dtls with the primary key.
	 *
	 * @param dlrRegNo the primary key of the dgf dlr reg dtls
	 * @return the dgf dlr reg dtls
	 * @throws PortalException if a dgf dlr reg dtls with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls
			getDgfDlrRegDtls(long dlrRegNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrRegDtlsLocalService.getDgfDlrRegDtls(dlrRegNo);
	}

	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls
		getDgfDlrRegDtlsByNationalIdAndLicenseNo(
			String nationalId, String licenseNo, long regNo) {

		return _dgfDlrRegDtlsLocalService.
			getDgfDlrRegDtlsByNationalIdAndLicenseNo(
				nationalId, licenseNo, regNo);
	}

	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls
		getDgfDlrRegDtlsByNid(String nid) {

		return _dgfDlrRegDtlsLocalService.getDgfDlrRegDtlsByNid(nid);
	}

	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls
		getDgfDlrRegDtlsByUserId(long userId) {

		return _dgfDlrRegDtlsLocalService.getDgfDlrRegDtlsByUserId(userId);
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
	@Override
	public java.util.List<bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls>
		getDgfDlrRegDtlses(int start, int end) {

		return _dgfDlrRegDtlsLocalService.getDgfDlrRegDtlses(start, end);
	}

	/**
	 * Returns the number of dgf dlr reg dtlses.
	 *
	 * @return the number of dgf dlr reg dtlses
	 */
	@Override
	public int getDgfDlrRegDtlsesCount() {
		return _dgfDlrRegDtlsLocalService.getDgfDlrRegDtlsesCount();
	}

	@Override
	public java.util.List<java.util.Map<String, Object>> getDlrListSearchResult(
		String dateFrom, String dateTo, String dateType, String nid, long union,
		String dealerType, int status, long roleId, String upazillaOrDistrict,
		long companyId) {

		return _dgfDlrRegDtlsLocalService.getDlrListSearchResult(
			dateFrom, dateTo, dateType, nid, union, dealerType, status, roleId,
			upazillaOrDistrict, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgfDlrRegDtlsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfDlrRegDtlsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrRegDtlsLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls
		saveFinalSubmitData(String nid) {

		return _dgfDlrRegDtlsLocalService.saveFinalSubmitData(nid);
	}

	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls saveRegData(
		String licenseNo, java.util.Date licnsIssueDate, String dealerShipType,
		String omsSubType, String nid, java.util.Date dob, String maritalStatus,
		String spouseName, String spouseFatherName, String spouseNid,
		java.util.Date spouseDob) {

		return _dgfDlrRegDtlsLocalService.saveRegData(
			licenseNo, licnsIssueDate, dealerShipType, omsSubType, nid, dob,
			maritalStatus, spouseName, spouseFatherName, spouseNid, spouseDob);
	}

	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls saveRegDocData(
		String nid, long bankSolvCertAttchId, long taxRtrnCertAttchId,
		long shopOwnrshpDocAttchId, long shopRentalDocAttchId,
		long signOrThumbPicAttchId) {

		return _dgfDlrRegDtlsLocalService.saveRegDocData(
			nid, bankSolvCertAttchId, taxRtrnCertAttchId, shopOwnrshpDocAttchId,
			shopRentalDocAttchId, signOrThumbPicAttchId);
	}

	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls saveRegLocData(
		String nid, long shopDiv, long shopDis, long shopUpazila,
		long shopUnion) {

		return _dgfDlrRegDtlsLocalService.saveRegLocData(
			nid, shopDiv, shopDis, shopUpazila, shopUnion);
	}

	@Override
	public void sendCcdrApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfDlrRegDtlsLocalService.
			sendCcdrApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendCcdrRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfDlrRegDtlsLocalService.
			sendCcdrRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendDcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfDlrRegDtlsLocalService.
			sendDcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendDcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfDlrRegDtlsLocalService.
			sendDcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendRcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfDlrRegDtlsLocalService.
			sendRcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendRcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfDlrRegDtlsLocalService.
			sendRcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfDlrRegDtlsLocalService.
			sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfDlrRegDtlsLocalService.
			sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void setDealerCcdrUserNotificationEvent(long classPK) {
		_dgfDlrRegDtlsLocalService.setDealerCcdrUserNotificationEvent(classPK);
	}

	@Override
	public void setDealerDcfUserNotificationEvent(long classPK) {
		_dgfDlrRegDtlsLocalService.setDealerDcfUserNotificationEvent(classPK);
	}

	@Override
	public void setDealerRcfUserNotificationEvent(long classPK) {
		_dgfDlrRegDtlsLocalService.setDealerRcfUserNotificationEvent(classPK);
	}

	@Override
	public void setDealerUcfUserNotificationEvent(long classPK) {
		_dgfDlrRegDtlsLocalService.setDealerUcfUserNotificationEvent(classPK);
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
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls
		updateDgfDlrRegDtls(
			bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls
				dgfDlrRegDtls) {

		return _dgfDlrRegDtlsLocalService.updateDgfDlrRegDtls(dgfDlrRegDtls);
	}

	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls updateStatus(
			long userId, long resourcePrimKey, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrRegDtlsLocalService.updateStatus(
			userId, resourcePrimKey, status, serviceContext);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfAttachments uploadFile(
		javax.portlet.ActionRequest actionRequest, String nationalId,
		String realPath, java.util.ResourceBundle bundle, String filecat,
		String attachmentInputName) {

		return _dgfDlrRegDtlsLocalService.uploadFile(
			actionRequest, nationalId, realPath, bundle, filecat,
			attachmentInputName);
	}

	@Override
	public DgfDlrRegDtlsLocalService getWrappedService() {
		return _dgfDlrRegDtlsLocalService;
	}

	@Override
	public void setWrappedService(
		DgfDlrRegDtlsLocalService dgfDlrRegDtlsLocalService) {

		_dgfDlrRegDtlsLocalService = dgfDlrRegDtlsLocalService;
	}

	private DgfDlrRegDtlsLocalService _dgfDlrRegDtlsLocalService;

}