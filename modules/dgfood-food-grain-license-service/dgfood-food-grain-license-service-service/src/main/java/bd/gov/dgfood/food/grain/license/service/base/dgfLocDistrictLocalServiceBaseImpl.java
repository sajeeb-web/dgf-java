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

import bd.gov.dgfood.food.grain.license.model.dgfLocDistrict;
import bd.gov.dgfood.food.grain.license.service.dgfLocDistrictLocalService;
import bd.gov.dgfood.food.grain.license.service.dgfLocDistrictLocalServiceUtil;
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
 * Provides the base implementation for the dgf loc district local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link bd.gov.dgfood.food.grain.license.service.impl.dgfLocDistrictLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see bd.gov.dgfood.food.grain.license.service.impl.dgfLocDistrictLocalServiceImpl
 * @generated
 */
public abstract class dgfLocDistrictLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, dgfLocDistrictLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>dgfLocDistrictLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>dgfLocDistrictLocalServiceUtil</code>.
	 */

	/**
	 * Adds the dgf loc district to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect dgfLocDistrictLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfLocDistrict the dgf loc district
	 * @return the dgf loc district that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public dgfLocDistrict adddgfLocDistrict(dgfLocDistrict dgfLocDistrict) {
		dgfLocDistrict.setNew(true);

		return dgfLocDistrictPersistence.update(dgfLocDistrict);
	}

	/**
	 * Creates a new dgf loc district with the primary key. Does not add the dgf loc district to the database.
	 *
	 * @param id the primary key for the new dgf loc district
	 * @return the new dgf loc district
	 */
	@Override
	@Transactional(enabled = false)
	public dgfLocDistrict createdgfLocDistrict(long id) {
		return dgfLocDistrictPersistence.create(id);
	}

	/**
	 * Deletes the dgf loc district with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect dgfLocDistrictLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the dgf loc district
	 * @return the dgf loc district that was removed
	 * @throws PortalException if a dgf loc district with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public dgfLocDistrict deletedgfLocDistrict(long id) throws PortalException {
		return dgfLocDistrictPersistence.remove(id);
	}

	/**
	 * Deletes the dgf loc district from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect dgfLocDistrictLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfLocDistrict the dgf loc district
	 * @return the dgf loc district that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public dgfLocDistrict deletedgfLocDistrict(dgfLocDistrict dgfLocDistrict) {
		return dgfLocDistrictPersistence.remove(dgfLocDistrict);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return dgfLocDistrictPersistence.dslQuery(dslQuery);
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
			dgfLocDistrict.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return dgfLocDistrictPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.dgfLocDistrictModelImpl</code>.
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

		return dgfLocDistrictPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.dgfLocDistrictModelImpl</code>.
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

		return dgfLocDistrictPersistence.findWithDynamicQuery(
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
		return dgfLocDistrictPersistence.countWithDynamicQuery(dynamicQuery);
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

		return dgfLocDistrictPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public dgfLocDistrict fetchdgfLocDistrict(long id) {
		return dgfLocDistrictPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the dgf loc district with the primary key.
	 *
	 * @param id the primary key of the dgf loc district
	 * @return the dgf loc district
	 * @throws PortalException if a dgf loc district with the primary key could not be found
	 */
	@Override
	public dgfLocDistrict getdgfLocDistrict(long id) throws PortalException {
		return dgfLocDistrictPersistence.findByPrimaryKey(id);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(dgfLocDistrictLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(dgfLocDistrict.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			dgfLocDistrictLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(dgfLocDistrict.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(dgfLocDistrictLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(dgfLocDistrict.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return dgfLocDistrictPersistence.create(
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
				"Implement dgfLocDistrictLocalServiceImpl#deletedgfLocDistrict(dgfLocDistrict) to avoid orphaned data");
		}

		return dgfLocDistrictLocalService.deletedgfLocDistrict(
			(dgfLocDistrict)persistedModel);
	}

	@Override
	public BasePersistence<dgfLocDistrict> getBasePersistence() {
		return dgfLocDistrictPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return dgfLocDistrictPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the dgf loc districts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.dgfLocDistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf loc districts
	 * @param end the upper bound of the range of dgf loc districts (not inclusive)
	 * @return the range of dgf loc districts
	 */
	@Override
	public List<dgfLocDistrict> getdgfLocDistricts(int start, int end) {
		return dgfLocDistrictPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of dgf loc districts.
	 *
	 * @return the number of dgf loc districts
	 */
	@Override
	public int getdgfLocDistrictsCount() {
		return dgfLocDistrictPersistence.countAll();
	}

	/**
	 * Updates the dgf loc district in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect dgfLocDistrictLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfLocDistrict the dgf loc district
	 * @return the dgf loc district that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public dgfLocDistrict updatedgfLocDistrict(dgfLocDistrict dgfLocDistrict) {
		return dgfLocDistrictPersistence.update(dgfLocDistrict);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			dgfLocDistrictLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		dgfLocDistrictLocalService = (dgfLocDistrictLocalService)aopProxy;

		_setLocalServiceUtilService(dgfLocDistrictLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return dgfLocDistrictLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return dgfLocDistrict.class;
	}

	protected String getModelClassName() {
		return dgfLocDistrict.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = dgfLocDistrictPersistence.getDataSource();

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
		dgfLocDistrictLocalService dgfLocDistrictLocalService) {

		try {
			Field field = dgfLocDistrictLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, dgfLocDistrictLocalService);
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

	protected dgfLocDistrictLocalService dgfLocDistrictLocalService;

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
		dgfLocDistrictLocalServiceBaseImpl.class);

}