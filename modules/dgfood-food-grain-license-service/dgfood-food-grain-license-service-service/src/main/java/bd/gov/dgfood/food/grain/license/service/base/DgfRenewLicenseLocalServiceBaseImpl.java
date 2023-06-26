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

import bd.gov.dgfood.food.grain.license.model.DgfRenewLicense;
import bd.gov.dgfood.food.grain.license.service.DgfRenewLicenseLocalService;
import bd.gov.dgfood.food.grain.license.service.DgfRenewLicenseLocalServiceUtil;
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
 * Provides the base implementation for the dgf renew license local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link bd.gov.dgfood.food.grain.license.service.impl.DgfRenewLicenseLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see bd.gov.dgfood.food.grain.license.service.impl.DgfRenewLicenseLocalServiceImpl
 * @generated
 */
public abstract class DgfRenewLicenseLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, DgfRenewLicenseLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>DgfRenewLicenseLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>DgfRenewLicenseLocalServiceUtil</code>.
	 */

	/**
	 * Adds the dgf renew license to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfRenewLicenseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfRenewLicense the dgf renew license
	 * @return the dgf renew license that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DgfRenewLicense addDgfRenewLicense(DgfRenewLicense dgfRenewLicense) {
		dgfRenewLicense.setNew(true);

		return dgfRenewLicensePersistence.update(dgfRenewLicense);
	}

	/**
	 * Creates a new dgf renew license with the primary key. Does not add the dgf renew license to the database.
	 *
	 * @param renewLicenseId the primary key for the new dgf renew license
	 * @return the new dgf renew license
	 */
	@Override
	@Transactional(enabled = false)
	public DgfRenewLicense createDgfRenewLicense(long renewLicenseId) {
		return dgfRenewLicensePersistence.create(renewLicenseId);
	}

	/**
	 * Deletes the dgf renew license with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfRenewLicenseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param renewLicenseId the primary key of the dgf renew license
	 * @return the dgf renew license that was removed
	 * @throws PortalException if a dgf renew license with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DgfRenewLicense deleteDgfRenewLicense(long renewLicenseId)
		throws PortalException {

		return dgfRenewLicensePersistence.remove(renewLicenseId);
	}

	/**
	 * Deletes the dgf renew license from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfRenewLicenseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfRenewLicense the dgf renew license
	 * @return the dgf renew license that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DgfRenewLicense deleteDgfRenewLicense(
		DgfRenewLicense dgfRenewLicense) {

		return dgfRenewLicensePersistence.remove(dgfRenewLicense);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return dgfRenewLicensePersistence.dslQuery(dslQuery);
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
			DgfRenewLicense.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return dgfRenewLicensePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfRenewLicenseModelImpl</code>.
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

		return dgfRenewLicensePersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfRenewLicenseModelImpl</code>.
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

		return dgfRenewLicensePersistence.findWithDynamicQuery(
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
		return dgfRenewLicensePersistence.countWithDynamicQuery(dynamicQuery);
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

		return dgfRenewLicensePersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public DgfRenewLicense fetchDgfRenewLicense(long renewLicenseId) {
		return dgfRenewLicensePersistence.fetchByPrimaryKey(renewLicenseId);
	}

	/**
	 * Returns the dgf renew license with the primary key.
	 *
	 * @param renewLicenseId the primary key of the dgf renew license
	 * @return the dgf renew license
	 * @throws PortalException if a dgf renew license with the primary key could not be found
	 */
	@Override
	public DgfRenewLicense getDgfRenewLicense(long renewLicenseId)
		throws PortalException {

		return dgfRenewLicensePersistence.findByPrimaryKey(renewLicenseId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(dgfRenewLicenseLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(DgfRenewLicense.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("renewLicenseId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			dgfRenewLicenseLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(DgfRenewLicense.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"renewLicenseId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(dgfRenewLicenseLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(DgfRenewLicense.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("renewLicenseId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return dgfRenewLicensePersistence.create(
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
				"Implement DgfRenewLicenseLocalServiceImpl#deleteDgfRenewLicense(DgfRenewLicense) to avoid orphaned data");
		}

		return dgfRenewLicenseLocalService.deleteDgfRenewLicense(
			(DgfRenewLicense)persistedModel);
	}

	@Override
	public BasePersistence<DgfRenewLicense> getBasePersistence() {
		return dgfRenewLicensePersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return dgfRenewLicensePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the dgf renew licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @return the range of dgf renew licenses
	 */
	@Override
	public List<DgfRenewLicense> getDgfRenewLicenses(int start, int end) {
		return dgfRenewLicensePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of dgf renew licenses.
	 *
	 * @return the number of dgf renew licenses
	 */
	@Override
	public int getDgfRenewLicensesCount() {
		return dgfRenewLicensePersistence.countAll();
	}

	/**
	 * Updates the dgf renew license in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfRenewLicenseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfRenewLicense the dgf renew license
	 * @return the dgf renew license that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DgfRenewLicense updateDgfRenewLicense(
		DgfRenewLicense dgfRenewLicense) {

		return dgfRenewLicensePersistence.update(dgfRenewLicense);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			DgfRenewLicenseLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		dgfRenewLicenseLocalService = (DgfRenewLicenseLocalService)aopProxy;

		_setLocalServiceUtilService(dgfRenewLicenseLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return DgfRenewLicenseLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return DgfRenewLicense.class;
	}

	protected String getModelClassName() {
		return DgfRenewLicense.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = dgfRenewLicensePersistence.getDataSource();

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
		DgfRenewLicenseLocalService dgfRenewLicenseLocalService) {

		try {
			Field field =
				DgfRenewLicenseLocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, dgfRenewLicenseLocalService);
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

	protected DgfRenewLicenseLocalService dgfRenewLicenseLocalService;

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
		DgfRenewLicenseLocalServiceBaseImpl.class);

}