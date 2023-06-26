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

import bd.gov.dgfood.food.grain.license.exception.NoSuchDgfFglPreDtlsException;
import bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.model.WorkflowInstanceLink;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.workflow.WorkflowTask;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for DgfFglPreDtls. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see DgfFglPreDtlsLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DgfFglPreDtlsLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>bd.gov.dgfood.food.grain.license.service.impl.DgfFglPreDtlsLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the dgf fgl pre dtls local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link DgfFglPreDtlsLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public DgfFglPreDtls addDgfFglPreDtls(DgfFglPreDtls dgfFglPreDtls);

	public boolean checkAcfUsersExistByLocation(long fglPrePrimaryId);

	public boolean checkCcdrUsersExistByLocation(long fglPrePrimaryId);

	/**
	 * Creates a new dgf fgl pre dtls with the primary key. Does not add the dgf fgl pre dtls to the database.
	 *
	 * @param fglPrePrimaryId the primary key for the new dgf fgl pre dtls
	 * @return the new dgf fgl pre dtls
	 */
	@Transactional(enabled = false)
	public DgfFglPreDtls createDgfFglPreDtls(long fglPrePrimaryId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public DgfFglPreDtls deleteDgfFglPreDtls(DgfFglPreDtls dgfFglPreDtls);

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
	@Indexable(type = IndexableType.DELETE)
	public DgfFglPreDtls deleteDgfFglPreDtls(long fglPrePrimaryId)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfFglPreDtlsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfFglPreDtlsModelImpl</code>.
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
	public DgfFglPreDtls fetchDgfFglPreDtls(long fglPrePrimaryId);

	public void generateLicenseNumberAndStoreData(long classPk);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public void getCcdrUserIdByLocationAndSendNotificationByNodeId(
		long fglPrePrimaryId, String nodeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public void getDcfUserIdByLocationAndSendNotificationByNodeId(
		long fglPrePrimaryId, String nodeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Map<String, Object> getDetailsData(
		long fglPrePrimaryId, long renewLicenseId,
		long duplicateLicenseReasonId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DgfFglPreDtls getDgfFglPreDtlObjectByUserIdAndWorkflowTaskId(
			long userId, long workflowTaskId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DgfFglPreDtls getdgfFglPreDtls(long nidId)
		throws NoSuchDgfFglPreDtlsException;

	/**
	 * Returns the dgf fgl pre dtls with the primary key.
	 *
	 * @param fglPrePrimaryId the primary key of the dgf fgl pre dtls
	 * @return the dgf fgl pre dtls
	 * @throws PortalException if a dgf fgl pre dtls with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DgfFglPreDtls getDgfFglPreDtls(long fglPrePrimaryId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DgfFglPreDtls getdgfFglPreDtls(String fglApplicationNo)
		throws NoSuchDgfFglPreDtlsException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DgfFglPreDtls getDgfFglPreDtlsByNID(long nationalId)
		throws NoSuchDgfFglPreDtlsException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DgfFglPreDtls> getDgfFglPreDtlsByUserId(long userId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DgfFglPreDtls> getDgfFglPreDtlses(int start, int end);

	/**
	 * Returns the number of dgf fgl pre dtlses.
	 *
	 * @return the number of dgf fgl pre dtlses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDgfFglPreDtlsesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getDuplicateLicenseFormSubmitMessage();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getLicenseFormSubmitMessage();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public byte[] getLicenseReport(String queryParams);

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

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getRenewLicenseFormSubmitMessage();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Map<String, Object>> getSearchResultByDateFrom(
		String dateFrom, String dateTo, String dateType, String applicationNo,
		String businessType, int status, String licenseType, long roleId,
		String upazillaOrDistrict, long companyId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public void getUcfUserIdByLocationAndSendNotificationByNodeId(
		long fglPrePrimaryId, String nodeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getWorkflowCurrentTaskCommentsByDgfFglPreDtlsAndNodeId(
		DgfFglPreDtls dgfFglPreDtls, String nodeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WorkflowInstanceLink getWorkflowInstanceLinkByUserId(
			long userId, long classPk)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public WorkflowTask getWorkflowTaskByCompanyIdAndWorkflowInstanceId(
			long companyId, long workflowInstanceId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getWorkflowTaskIdByCompanyIdAndWorkflowInstanceId(
		long companyId, long workflowInstanceId);

	public DgfFglPreDtls saveDgfFglPreDtls(String nationalId);

	public void sendAcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId);

	public void sendAcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId);

	public void sendCcdrApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId);

	public void sendCcdrRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId);

	public void sendDcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId);

	public void sendDcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId);

	public void sendUcfApprovedSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId);

	public void
		sendUcfOrDcfPaymentRequestSmsWithWorkflowCommentsByClassPkAndNodeId(
			long classPk, String nodeId);

	public void sendUcfRejectSmsWithWorkflowCommentsByClassPkAndNodeId(
		long classPk, String nodeId);

	public void setLicenseAcfUserNotificationEvent(long fglPrePrimaryId);

	public void setLicenseUcfUserNotificationEvent(long fglPrePrimaryId);

	public void setUserLicenseAndMessageAndLoginActivity(long fglPrePrimaryId);

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
	@Indexable(type = IndexableType.REINDEX)
	public DgfFglPreDtls updateDgfFglPreDtls(DgfFglPreDtls dgfFglPreDtls);

	public DgfFglPreDtls updateStatus(
			long userId, long resourcePrimKey, int status,
			ServiceContext serviceContext)
		throws PortalException;

}