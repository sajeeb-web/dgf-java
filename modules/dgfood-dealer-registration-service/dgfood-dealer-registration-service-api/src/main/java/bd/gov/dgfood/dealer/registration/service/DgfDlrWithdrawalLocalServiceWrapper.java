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
 * Provides a wrapper for {@link DgfDlrWithdrawalLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrWithdrawalLocalService
 * @generated
 */
public class DgfDlrWithdrawalLocalServiceWrapper
	implements DgfDlrWithdrawalLocalService,
			   ServiceWrapper<DgfDlrWithdrawalLocalService> {

	public DgfDlrWithdrawalLocalServiceWrapper() {
		this(null);
	}

	public DgfDlrWithdrawalLocalServiceWrapper(
		DgfDlrWithdrawalLocalService dgfDlrWithdrawalLocalService) {

		_dgfDlrWithdrawalLocalService = dgfDlrWithdrawalLocalService;
	}

	/**
	 * Adds the dgf dlr withdrawal to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrWithdrawalLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDlrWithdrawal the dgf dlr withdrawal
	 * @return the dgf dlr withdrawal that was added
	 */
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawal
		addDgfDlrWithdrawal(
			bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawal
				dgfDlrWithdrawal) {

		return _dgfDlrWithdrawalLocalService.addDgfDlrWithdrawal(
			dgfDlrWithdrawal);
	}

	@Override
	public boolean checkCcdrUsersExistByLocation(long classPK) {
		return _dgfDlrWithdrawalLocalService.checkCcdrUsersExistByLocation(
			classPK);
	}

	@Override
	public boolean checkDcfUsersExistByLocation(long classPK) {
		return _dgfDlrWithdrawalLocalService.checkDcfUsersExistByLocation(
			classPK);
	}

	@Override
	public boolean checkRcfUsersExistByLocation(long classPK) {
		return _dgfDlrWithdrawalLocalService.checkRcfUsersExistByLocation(
			classPK);
	}

	@Override
	public boolean checkUcfUsersExistByLocation(long classPK) {
		return _dgfDlrWithdrawalLocalService.checkUcfUsersExistByLocation(
			classPK);
	}

	/**
	 * Creates a new dgf dlr withdrawal with the primary key. Does not add the dgf dlr withdrawal to the database.
	 *
	 * @param dlrWithdrawalId the primary key for the new dgf dlr withdrawal
	 * @return the new dgf dlr withdrawal
	 */
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawal
		createDgfDlrWithdrawal(long dlrWithdrawalId) {

		return _dgfDlrWithdrawalLocalService.createDgfDlrWithdrawal(
			dlrWithdrawalId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrWithdrawalLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the dgf dlr withdrawal from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrWithdrawalLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDlrWithdrawal the dgf dlr withdrawal
	 * @return the dgf dlr withdrawal that was removed
	 */
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawal
		deleteDgfDlrWithdrawal(
			bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawal
				dgfDlrWithdrawal) {

		return _dgfDlrWithdrawalLocalService.deleteDgfDlrWithdrawal(
			dgfDlrWithdrawal);
	}

	/**
	 * Deletes the dgf dlr withdrawal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrWithdrawalLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dlrWithdrawalId the primary key of the dgf dlr withdrawal
	 * @return the dgf dlr withdrawal that was removed
	 * @throws PortalException if a dgf dlr withdrawal with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawal
			deleteDgfDlrWithdrawal(long dlrWithdrawalId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrWithdrawalLocalService.deleteDgfDlrWithdrawal(
			dlrWithdrawalId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrWithdrawalLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgfDlrWithdrawalLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgfDlrWithdrawalLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgfDlrWithdrawalLocalService.dynamicQuery();
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

		return _dgfDlrWithdrawalLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.dealer.registration.model.impl.DgfDlrWithdrawalModelImpl</code>.
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

		return _dgfDlrWithdrawalLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.dealer.registration.model.impl.DgfDlrWithdrawalModelImpl</code>.
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

		return _dgfDlrWithdrawalLocalService.dynamicQuery(
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

		return _dgfDlrWithdrawalLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dgfDlrWithdrawalLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawal
		fetchDgfDlrWithdrawal(long dlrWithdrawalId) {

		return _dgfDlrWithdrawalLocalService.fetchDgfDlrWithdrawal(
			dlrWithdrawalId);
	}

	@Override
	public java.util.List<java.util.Map<String, Object>> findBySearchCriteria(
		String dateFrom, String dateTo, String nid, long union,
		String dealerType, int status) {

		return _dgfDlrWithdrawalLocalService.findBySearchCriteria(
			dateFrom, dateTo, nid, union, dealerType, status);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgfDlrWithdrawalLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the dgf dlr withdrawal with the primary key.
	 *
	 * @param dlrWithdrawalId the primary key of the dgf dlr withdrawal
	 * @return the dgf dlr withdrawal
	 * @throws PortalException if a dgf dlr withdrawal with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawal
			getDgfDlrWithdrawal(long dlrWithdrawalId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrWithdrawalLocalService.getDgfDlrWithdrawal(
			dlrWithdrawalId);
	}

	@Override
	public java.util.List
		<bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawal>
			getDgfDlrWithdrawalbyNationId(String nationId) {

		return _dgfDlrWithdrawalLocalService.getDgfDlrWithdrawalbyNationId(
			nationId);
	}

	@Override
	public java.util.List
		<bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawal>
			getDgfDlrWithdrawalByNid(String nid) {

		return _dgfDlrWithdrawalLocalService.getDgfDlrWithdrawalByNid(nid);
	}

	@Override
	public java.util.Map<String, Object> getDgfDlrWithdrawalDltsData(
		long dlrWithdrawalId) {

		return _dgfDlrWithdrawalLocalService.getDgfDlrWithdrawalDltsData(
			dlrWithdrawalId);
	}

	/**
	 * Returns a range of all the dgf dlr withdrawals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.dealer.registration.model.impl.DgfDlrWithdrawalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr withdrawals
	 * @param end the upper bound of the range of dgf dlr withdrawals (not inclusive)
	 * @return the range of dgf dlr withdrawals
	 */
	@Override
	public java.util.List
		<bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawal>
			getDgfDlrWithdrawals(int start, int end) {

		return _dgfDlrWithdrawalLocalService.getDgfDlrWithdrawals(start, end);
	}

	/**
	 * Returns the number of dgf dlr withdrawals.
	 *
	 * @return the number of dgf dlr withdrawals
	 */
	@Override
	public int getDgfDlrWithdrawalsCount() {
		return _dgfDlrWithdrawalLocalService.getDgfDlrWithdrawalsCount();
	}

	@Override
	public java.util.List<java.util.Map<String, Object>>
		getDlrWithdrawalListSearchResult(
			String dateFrom, String dateTo, String dateType, String nid,
			long union, String dealerType, int status) {

		return _dgfDlrWithdrawalLocalService.getDlrWithdrawalListSearchResult(
			dateFrom, dateTo, dateType, nid, union, dealerType, status);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgfDlrWithdrawalLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfDlrWithdrawalLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrWithdrawalLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Method to submit  dealer @withdrawal form
	 */
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawal
			saveWithdrawalData(
				String nationalId, String licenseNo, String dealerName,
				String mobileNo, String reason, String programType)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _dgfDlrWithdrawalLocalService.saveWithdrawalData(
			nationalId, licenseNo, dealerName, mobileNo, reason, programType);
	}

	@Override
	public void sendCcdrApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfDlrWithdrawalLocalService.
			sendCcdrApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendCcdrRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfDlrWithdrawalLocalService.
			sendCcdrRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendDcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfDlrWithdrawalLocalService.
			sendDcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendDcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfDlrWithdrawalLocalService.
			sendDcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendRcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfDlrWithdrawalLocalService.
			sendRcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendRcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfDlrWithdrawalLocalService.
			sendRcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfDlrWithdrawalLocalService.
			sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId) {

		_dgfDlrWithdrawalLocalService.
			sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
				classPk, nodeId);
	}

	@Override
	public void setDealerCcdrUserNotificationEvent(long classPK) {
		_dgfDlrWithdrawalLocalService.setDealerCcdrUserNotificationEvent(
			classPK);
	}

	@Override
	public void setDealerDcfUserNotificationEvent(long classPK) {
		_dgfDlrWithdrawalLocalService.setDealerDcfUserNotificationEvent(
			classPK);
	}

	@Override
	public void setDealerRcfUserNotificationEvent(long classPK) {
		_dgfDlrWithdrawalLocalService.setDealerRcfUserNotificationEvent(
			classPK);
	}

	@Override
	public void setDealerUcfUserNotificationEvent(long classPK) {
		_dgfDlrWithdrawalLocalService.setDealerUcfUserNotificationEvent(
			classPK);
	}

	/**
	 * Updates the dgf dlr withdrawal in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrWithdrawalLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDlrWithdrawal the dgf dlr withdrawal
	 * @return the dgf dlr withdrawal that was updated
	 */
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawal
		updateDgfDlrWithdrawal(
			bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawal
				dgfDlrWithdrawal) {

		return _dgfDlrWithdrawalLocalService.updateDgfDlrWithdrawal(
			dgfDlrWithdrawal);
	}

	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawal
			updateStatus(
				long userId, long resourcePrimKey, int status,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrWithdrawalLocalService.updateStatus(
			userId, resourcePrimKey, status, serviceContext);
	}

	@Override
	public boolean userExists(String nationalId, String licenseNo) {
		return _dgfDlrWithdrawalLocalService.userExists(nationalId, licenseNo);
	}

	@Override
	public DgfDlrWithdrawalLocalService getWrappedService() {
		return _dgfDlrWithdrawalLocalService;
	}

	@Override
	public void setWrappedService(
		DgfDlrWithdrawalLocalService dgfDlrWithdrawalLocalService) {

		_dgfDlrWithdrawalLocalService = dgfDlrWithdrawalLocalService;
	}

	private DgfDlrWithdrawalLocalService _dgfDlrWithdrawalLocalService;

}