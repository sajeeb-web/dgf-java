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

import bd.gov.dgfood.dealer.registration.model.DgfDlrWithdrawal;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for DgfDlrWithdrawal. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrWithdrawalLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DgfDlrWithdrawalLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>bd.gov.dgfood.dealer.registration.service.impl.DgfDlrWithdrawalLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the dgf dlr withdrawal local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link DgfDlrWithdrawalLocalServiceUtil} if injection and service tracking are not available.
	 */

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
	@Indexable(type = IndexableType.REINDEX)
	public DgfDlrWithdrawal addDgfDlrWithdrawal(
		DgfDlrWithdrawal dgfDlrWithdrawal);

	public boolean checkCcdrUsersExistByLocation(long classPK);

	public boolean checkDcfUsersExistByLocation(long classPK);

	public boolean checkRcfUsersExistByLocation(long classPK);

	public boolean checkUcfUsersExistByLocation(long classPK);

	/**
	 * Creates a new dgf dlr withdrawal with the primary key. Does not add the dgf dlr withdrawal to the database.
	 *
	 * @param dlrWithdrawalId the primary key for the new dgf dlr withdrawal
	 * @return the new dgf dlr withdrawal
	 */
	@Transactional(enabled = false)
	public DgfDlrWithdrawal createDgfDlrWithdrawal(long dlrWithdrawalId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public DgfDlrWithdrawal deleteDgfDlrWithdrawal(
		DgfDlrWithdrawal dgfDlrWithdrawal);

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
	@Indexable(type = IndexableType.DELETE)
	public DgfDlrWithdrawal deleteDgfDlrWithdrawal(long dlrWithdrawalId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DgfDlrWithdrawal fetchDgfDlrWithdrawal(long dlrWithdrawalId);

	public List<Map<String, Object>> findBySearchCriteria(
		String dateFrom, String dateTo, String nid, long union,
		String dealerType, int status);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the dgf dlr withdrawal with the primary key.
	 *
	 * @param dlrWithdrawalId the primary key of the dgf dlr withdrawal
	 * @return the dgf dlr withdrawal
	 * @throws PortalException if a dgf dlr withdrawal with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DgfDlrWithdrawal getDgfDlrWithdrawal(long dlrWithdrawalId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DgfDlrWithdrawal> getDgfDlrWithdrawalbyNationId(
		String nationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DgfDlrWithdrawal> getDgfDlrWithdrawalByNid(String nid);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Map<String, Object> getDgfDlrWithdrawalDltsData(
		long dlrWithdrawalId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DgfDlrWithdrawal> getDgfDlrWithdrawals(int start, int end);

	/**
	 * Returns the number of dgf dlr withdrawals.
	 *
	 * @return the number of dgf dlr withdrawals
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDgfDlrWithdrawalsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Map<String, Object>> getDlrWithdrawalListSearchResult(
		String dateFrom, String dateTo, String dateType, String nid, long union,
		String dealerType, int status);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Method to submit  dealer @withdrawal form
	 */
	public DgfDlrWithdrawal saveWithdrawalData(
			String nationalId, String licenseNo, String dealerName,
			String mobileNo, String reason, String programType)
		throws SystemException;

	public void sendCcdrApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId);

	public void sendCcdrRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId);

	public void sendDcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId);

	public void sendDcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId);

	public void sendRcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId);

	public void sendRcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId);

	public void sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId);

	public void sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId);

	public void setDealerCcdrUserNotificationEvent(long classPK);

	public void setDealerDcfUserNotificationEvent(long classPK);

	public void setDealerRcfUserNotificationEvent(long classPK);

	public void setDealerUcfUserNotificationEvent(long classPK);

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
	@Indexable(type = IndexableType.REINDEX)
	public DgfDlrWithdrawal updateDgfDlrWithdrawal(
		DgfDlrWithdrawal dgfDlrWithdrawal);

	public DgfDlrWithdrawal updateStatus(
			long userId, long resourcePrimKey, int status,
			ServiceContext serviceContext)
		throws PortalException;

	public boolean userExists(String nationalId, String licenseNo);

}