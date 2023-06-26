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

package bd.gov.dgfood.food.grain.license.service.base;

import bd.gov.dgfood.food.grain.license.model.DgfUsersFortnightReportDForm;
import bd.gov.dgfood.food.grain.license.service.DgfUsersFortnightReportDFormLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfUsersFortnightReportDFormLocalServiceUtil;
import bd.gov.dgfood.food.grain.license.service.persistence.BeneficiaryOtherInfoPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DealerMastersPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfAttachmentsPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfBnkChllnDtlsPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfBussAddrDtlsPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfDistributionSchedulesPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfDlrDistributionDtlsPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfDuplctLicnsReasonPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfFglLicDtlsPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfFglLicenseNoPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfFglPreDtlsFinder;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfFglPreDtlsPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfFglProductDtlsPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfRenewLicensePersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfStoreDtlsPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfUsersAddrDtlsPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfUsersDtlsPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfUsersFortnightReportCFormFinder;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfUsersFortnightReportCFormPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfUsersFortnightReportDFormFinder;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfUsersFortnightReportDFormPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfUsersOtpDetailsPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.DgfUsersPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.VerifiedBeneficiariesPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.dgfLocDistrictPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.dgfLocDivisionPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.dgfLocSubdistrictPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.dgfLocUnionPersistence;
import bd.gov.dgfood.food.grain.license.service.persistence.licnsUserRegsPersistence;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the dgf users fortnight report d form local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link bd.gov.dgfood.food.grain.license.service.impl.DgfUsersFortnightReportDFormLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see bd.gov.dgfood.food.grain.license.service.impl.DgfUsersFortnightReportDFormLocalServiceImpl
 * @generated
 */
public abstract class DgfUsersFortnightReportDFormLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, DgfUsersFortnightReportDFormLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>DgfUsersFortnightReportDFormLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>DgfUsersFortnightReportDFormLocalServiceUtil</code>.
	 */

	/**
	 * Adds the dgf users fortnight report d form to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersFortnightReportDFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsersFortnightReportDForm the dgf users fortnight report d form
	 * @return the dgf users fortnight report d form that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DgfUsersFortnightReportDForm addDgfUsersFortnightReportDForm(
		DgfUsersFortnightReportDForm dgfUsersFortnightReportDForm) {

		dgfUsersFortnightReportDForm.setNew(true);

		return dgfUsersFortnightReportDFormPersistence.update(
			dgfUsersFortnightReportDForm);
	}

	/**
	 * Creates a new dgf users fortnight report d form with the primary key. Does not add the dgf users fortnight report d form to the database.
	 *
	 * @param reportId the primary key for the new dgf users fortnight report d form
	 * @return the new dgf users fortnight report d form
	 */
	@Override
	@Transactional(enabled = false)
	public DgfUsersFortnightReportDForm createDgfUsersFortnightReportDForm(
		long reportId) {

		return dgfUsersFortnightReportDFormPersistence.create(reportId);
	}

	/**
	 * Deletes the dgf users fortnight report d form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersFortnightReportDFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param reportId the primary key of the dgf users fortnight report d form
	 * @return the dgf users fortnight report d form that was removed
	 * @throws PortalException if a dgf users fortnight report d form with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DgfUsersFortnightReportDForm deleteDgfUsersFortnightReportDForm(
			long reportId)
		throws PortalException {

		return dgfUsersFortnightReportDFormPersistence.remove(reportId);
	}

	/**
	 * Deletes the dgf users fortnight report d form from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersFortnightReportDFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsersFortnightReportDForm the dgf users fortnight report d form
	 * @return the dgf users fortnight report d form that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DgfUsersFortnightReportDForm deleteDgfUsersFortnightReportDForm(
		DgfUsersFortnightReportDForm dgfUsersFortnightReportDForm) {

		return dgfUsersFortnightReportDFormPersistence.remove(
			dgfUsersFortnightReportDForm);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return dgfUsersFortnightReportDFormPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			DgfUsersFortnightReportDForm.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return dgfUsersFortnightReportDFormPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersFortnightReportDFormModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return dgfUsersFortnightReportDFormPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersFortnightReportDFormModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return dgfUsersFortnightReportDFormPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return dgfUsersFortnightReportDFormPersistence.countWithDynamicQuery(
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
		DynamicQuery dynamicQuery, Projection projection) {

		return dgfUsersFortnightReportDFormPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public DgfUsersFortnightReportDForm fetchDgfUsersFortnightReportDForm(
		long reportId) {

		return dgfUsersFortnightReportDFormPersistence.fetchByPrimaryKey(
			reportId);
	}

	/**
	 * Returns the dgf users fortnight report d form with the primary key.
	 *
	 * @param reportId the primary key of the dgf users fortnight report d form
	 * @return the dgf users fortnight report d form
	 * @throws PortalException if a dgf users fortnight report d form with the primary key could not be found
	 */
	@Override
	public DgfUsersFortnightReportDForm getDgfUsersFortnightReportDForm(
			long reportId)
		throws PortalException {

		return dgfUsersFortnightReportDFormPersistence.findByPrimaryKey(
			reportId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			dgfUsersFortnightReportDFormLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(
			DgfUsersFortnightReportDForm.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("reportId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			dgfUsersFortnightReportDFormLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			DgfUsersFortnightReportDForm.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("reportId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			dgfUsersFortnightReportDFormLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(
			DgfUsersFortnightReportDForm.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("reportId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return dgfUsersFortnightReportDFormPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		if (_log.isWarnEnabled()) {
			_log.warn(
				"Implement DgfUsersFortnightReportDFormLocalServiceImpl#deleteDgfUsersFortnightReportDForm(DgfUsersFortnightReportDForm) to avoid orphaned data");
		}

		return dgfUsersFortnightReportDFormLocalService.
			deleteDgfUsersFortnightReportDForm(
				(DgfUsersFortnightReportDForm)persistedModel);
	}

	@Override
	public BasePersistence<DgfUsersFortnightReportDForm> getBasePersistence() {
		return dgfUsersFortnightReportDFormPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return dgfUsersFortnightReportDFormPersistence.findByPrimaryKey(
			primaryKeyObj);
	}

	/**
	 * Returns a range of all the dgf users fortnight report d forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersFortnightReportDFormModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users fortnight report d forms
	 * @param end the upper bound of the range of dgf users fortnight report d forms (not inclusive)
	 * @return the range of dgf users fortnight report d forms
	 */
	@Override
	public List<DgfUsersFortnightReportDForm> getDgfUsersFortnightReportDForms(
		int start, int end) {

		return dgfUsersFortnightReportDFormPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of dgf users fortnight report d forms.
	 *
	 * @return the number of dgf users fortnight report d forms
	 */
	@Override
	public int getDgfUsersFortnightReportDFormsCount() {
		return dgfUsersFortnightReportDFormPersistence.countAll();
	}

	/**
	 * Updates the dgf users fortnight report d form in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersFortnightReportDFormLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsersFortnightReportDForm the dgf users fortnight report d form
	 * @return the dgf users fortnight report d form that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DgfUsersFortnightReportDForm updateDgfUsersFortnightReportDForm(
		DgfUsersFortnightReportDForm dgfUsersFortnightReportDForm) {

		return dgfUsersFortnightReportDFormPersistence.update(
			dgfUsersFortnightReportDForm);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			DgfUsersFortnightReportDFormLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		dgfUsersFortnightReportDFormLocalService =
			(DgfUsersFortnightReportDFormLocalService)aopProxy;

		_setLocalServiceUtilService(dgfUsersFortnightReportDFormLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return DgfUsersFortnightReportDFormLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return DgfUsersFortnightReportDForm.class;
	}

	protected String getModelClassName() {
		return DgfUsersFortnightReportDForm.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				dgfUsersFortnightReportDFormPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		DgfUsersFortnightReportDFormLocalService
			dgfUsersFortnightReportDFormLocalService) {

		try {
			Field field =
				DgfUsersFortnightReportDFormLocalServiceUtil.class.
					getDeclaredField("_service");

			field.setAccessible(true);

			field.set(null, dgfUsersFortnightReportDFormLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected BeneficiaryOtherInfoPersistence beneficiaryOtherInfoPersistence;

	@Reference
	protected DealerMastersPersistence dealerMastersPersistence;

	@Reference
	protected DgfAttachmentsPersistence dgfAttachmentsPersistence;

	@Reference
	protected DgfBnkChllnDtlsPersistence dgfBnkChllnDtlsPersistence;

	@Reference
	protected DgfBussAddrDtlsPersistence dgfBussAddrDtlsPersistence;

	@Reference
	protected DgfDistributionSchedulesPersistence
		dgfDistributionSchedulesPersistence;

	@Reference
	protected DgfDlrDistributionDtlsPersistence
		dgfDlrDistributionDtlsPersistence;

	@Reference
	protected DgfDuplctLicnsReasonPersistence dgfDuplctLicnsReasonPersistence;

	@Reference
	protected DgfFglLicDtlsPersistence dgfFglLicDtlsPersistence;

	@Reference
	protected DgfFglLicenseNoPersistence dgfFglLicenseNoPersistence;

	@Reference
	protected DgfFglPreDtlsPersistence dgfFglPreDtlsPersistence;

	@Reference
	protected DgfFglPreDtlsFinder dgfFglPreDtlsFinder;

	@Reference
	protected DgfFglProductDtlsPersistence dgfFglProductDtlsPersistence;

	@Reference
	protected dgfLocDistrictPersistence dgfLocDistrictPersistence;

	@Reference
	protected dgfLocDivisionPersistence dgfLocDivisionPersistence;

	@Reference
	protected dgfLocSubdistrictPersistence dgfLocSubdistrictPersistence;

	@Reference
	protected dgfLocUnionPersistence dgfLocUnionPersistence;

	@Reference
	protected DgfRenewLicensePersistence dgfRenewLicensePersistence;

	@Reference
	protected DgfStoreDtlsPersistence dgfStoreDtlsPersistence;

	@Reference
	protected DgfUsersPersistence dgfUsersPersistence;

	@Reference
	protected DgfUsersAddrDtlsPersistence dgfUsersAddrDtlsPersistence;

	@Reference
	protected DgfUsersDtlsPersistence dgfUsersDtlsPersistence;

	@Reference
	protected DgfUsersFortnightReportCFormPersistence
		dgfUsersFortnightReportCFormPersistence;

	@Reference
	protected DgfUsersFortnightReportCFormFinder
		dgfUsersFortnightReportCFormFinder;

	protected DgfUsersFortnightReportDFormLocalService
		dgfUsersFortnightReportDFormLocalService;

	@Reference
	protected DgfUsersFortnightReportDFormPersistence
		dgfUsersFortnightReportDFormPersistence;

	@Reference
	protected DgfUsersFortnightReportDFormFinder
		dgfUsersFortnightReportDFormFinder;

	@Reference
	protected DgfUsersOtpDetailsPersistence dgfUsersOtpDetailsPersistence;

	@Reference
	protected licnsUserRegsPersistence licnsUserRegsPersistence;

	@Reference
	protected VerifiedBeneficiariesPersistence verifiedBeneficiariesPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	private static final Log _log = LogFactoryUtil.getLog(
		DgfUsersFortnightReportDFormLocalServiceBaseImpl.class);

}