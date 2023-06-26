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

import bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportCForm;
import bd.gov.dgfood.food.grain.license.model.dgfLocUnion;

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
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for DgfUsersFortnightReportCForm. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersFortnightReportCFormLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DgfUsersFortnightReportCFormLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>bd.gov.dgfood.food.grain.license.service.impl.DgfUsersFortnightReportCFormLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the dgf users fortnight report c form local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link DgfUsersFortnightReportCFormLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the dgf users fortnight report c form to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersFortnightReportCFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsersFortnightReportCForm the dgf users fortnight report c form
	 * @return the dgf users fortnight report c form that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DgfUsersFortnightReportCForm addDgfUsersFortnightReportCForm(
		DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm);

	/**
	 * Creates a new dgf users fortnight report c form with the primary key. Does not add the dgf users fortnight report c form to the database.
	 *
	 * @param reportId the primary key for the new dgf users fortnight report c form
	 * @return the new dgf users fortnight report c form
	 */
	@Transactional(enabled = false)
	public DgfUsersFortnightReportCForm createDgfUsersFortnightReportCForm(
		long reportId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public Date dateMaker(String dateStr);

	/**
	 * Deletes the dgf users fortnight report c form from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersFortnightReportCFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsersFortnightReportCForm the dgf users fortnight report c form
	 * @return the dgf users fortnight report c form that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public DgfUsersFortnightReportCForm deleteDgfUsersFortnightReportCForm(
		DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm);

	/**
	 * Deletes the dgf users fortnight report c form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersFortnightReportCFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param reportId the primary key of the dgf users fortnight report c form
	 * @return the dgf users fortnight report c form that was removed
	 * @throws PortalException if a dgf users fortnight report c form with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public DgfUsersFortnightReportCForm deleteDgfUsersFortnightReportCForm(
			long reportId)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersFortnightReportCFormModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersFortnightReportCFormModelImpl</code>.
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
	public DgfUsersFortnightReportCForm fetchDgfUsersFortnightReportCForm(
		long reportId);

	public List<Map<String, Object>> findBySearchCriteria(
		String bussinessType, String endDate, long upazilla,
		long businessUnionName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DgfUsersFortnightReportCForm> getAllDataUnderUCF(
		long userId, String usernationalId);

	/**
	 * Returns the dgf users fortnight report c form with the primary key.
	 *
	 * @param reportId the primary key of the dgf users fortnight report c form
	 * @return the dgf users fortnight report c form
	 * @throws PortalException if a dgf users fortnight report c form with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DgfUsersFortnightReportCForm getDgfUsersFortnightReportCForm(
			long reportId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DgfUsersFortnightReportCForm
		getDgfUsersFortnightReportCFormByNationalId(String nationalId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DgfUsersFortnightReportCForm
		getDgfUsersFortnightReportCFormByNidAndLicenseNo(
			String nationalId, String licenseNo);

	/**
	 * Returns a range of all the dgf users fortnight report c forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersFortnightReportCFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users fortnight report c forms
	 * @param end the upper bound of the range of dgf users fortnight report c forms (not inclusive)
	 * @return the range of dgf users fortnight report c forms
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DgfUsersFortnightReportCForm> getDgfUsersFortnightReportCForms(
		int start, int end);

	/**
	 * Returns the number of dgf users fortnight report c forms.
	 *
	 * @return the number of dgf users fortnight report c forms
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDgfUsersFortnightReportCFormsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public byte[] getLicenseReport(String queryParams);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DgfUsersFortnightReportCForm>
		getMatchingReportsByUserNationalId(String nationalId);

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
	public List<dgfLocUnion> getUnionNameByUpzillaId(long subdistrictId);

	/**
	 * Updates the dgf users fortnight report c form in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersFortnightReportCFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsersFortnightReportCForm the dgf users fortnight report c form
	 * @return the dgf users fortnight report c form that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DgfUsersFortnightReportCForm updateDgfUsersFortnightReportCForm(
		DgfUsersFortnightReportCForm dgfUsersFortnightReportCForm);

}