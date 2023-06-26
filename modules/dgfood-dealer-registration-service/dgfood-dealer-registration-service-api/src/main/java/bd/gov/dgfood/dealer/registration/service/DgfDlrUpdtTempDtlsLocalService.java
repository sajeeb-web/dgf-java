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

import bd.gov.dgfood.dealer.registration.model.DgfDlrUpdtTempDtls;

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

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for DgfDlrUpdtTempDtls. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrUpdtTempDtlsLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DgfDlrUpdtTempDtlsLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>bd.gov.dgfood.dealer.registration.service.impl.DgfDlrUpdtTempDtlsLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the dgf dlr updt temp dtls local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link DgfDlrUpdtTempDtlsLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the dgf dlr updt temp dtls to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrUpdtTempDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDlrUpdtTempDtls the dgf dlr updt temp dtls
	 * @return the dgf dlr updt temp dtls that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DgfDlrUpdtTempDtls addDgfDlrUpdtTempDtls(
		DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls);

	/**
	 * Creates a new dgf dlr updt temp dtls with the primary key. Does not add the dgf dlr updt temp dtls to the database.
	 *
	 * @param dgfDlrUpdateReqId the primary key for the new dgf dlr updt temp dtls
	 * @return the new dgf dlr updt temp dtls
	 */
	@Transactional(enabled = false)
	public DgfDlrUpdtTempDtls createDgfDlrUpdtTempDtls(long dgfDlrUpdateReqId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the dgf dlr updt temp dtls from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrUpdtTempDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDlrUpdtTempDtls the dgf dlr updt temp dtls
	 * @return the dgf dlr updt temp dtls that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public DgfDlrUpdtTempDtls deleteDgfDlrUpdtTempDtls(
		DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls);

	/**
	 * Deletes the dgf dlr updt temp dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrUpdtTempDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDlrUpdateReqId the primary key of the dgf dlr updt temp dtls
	 * @return the dgf dlr updt temp dtls that was removed
	 * @throws PortalException if a dgf dlr updt temp dtls with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public DgfDlrUpdtTempDtls deleteDgfDlrUpdtTempDtls(long dgfDlrUpdateReqId)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.dealer.registration.model.impl.DgfDlrUpdtTempDtlsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.dealer.registration.model.impl.DgfDlrUpdtTempDtlsModelImpl</code>.
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
	public DgfDlrUpdtTempDtls fetchDgfDlrUpdtTempDtls(long dgfDlrUpdateReqId);

	public List<DgfDlrUpdtTempDtls> findAllOrderedByIdDesc(String nid)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the dgf dlr updt temp dtls with the primary key.
	 *
	 * @param dgfDlrUpdateReqId the primary key of the dgf dlr updt temp dtls
	 * @return the dgf dlr updt temp dtls
	 * @throws PortalException if a dgf dlr updt temp dtls with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DgfDlrUpdtTempDtls getDgfDlrUpdtTempDtls(long dgfDlrUpdateReqId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DgfDlrUpdtTempDtls> getDgfDlrUpdtTempDtlsByNid(String nid);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DgfDlrUpdtTempDtls> getDgfDlrUpdtTempDtlsByRegNo(long dlrRegNo);

	/**
	 * Returns a range of all the dgf dlr updt temp dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.dealer.registration.model.impl.DgfDlrUpdtTempDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr updt temp dtlses
	 * @param end the upper bound of the range of dgf dlr updt temp dtlses (not inclusive)
	 * @return the range of dgf dlr updt temp dtlses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DgfDlrUpdtTempDtls> getDgfDlrUpdtTempDtlses(int start, int end);

	/**
	 * Returns the number of dgf dlr updt temp dtlses.
	 *
	 * @return the number of dgf dlr updt temp dtlses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDgfDlrUpdtTempDtlsesCount();

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

	public DgfDlrUpdtTempDtls saveDgfDlrUpdtTempDtls(
		String nid, long phsclyChlnGdAttchId, int workInGovt, int publcRep,
		int physclyChlngd, long shopDiv, long shopDis, long shopUpazila,
		long shopUnion, String shopWard, String shopZipCode, String shopLoc,
		long shopHeight, long shopLength, long shopWidth, long shopStorageCap,
		int isCemented, int signBoard, int dlrRunShpHimself,
		String dealershipMemName, String dealershipMemType, int truckType,
		String truckRentFlag, String truckPlatNo, long truckCap,
		String truckMake, String truckModel, long truckManuYear,
		long dlrPerfYr1SN, long dlrPerfYr1AllocQty, long dlrPerfYr1ComdtyQty,
		String dlrPerfYr1DlrCtgry, String dlrPerfYr1Rmrk, long dlrPerfYr2SN,
		long dlrPerfYr2AllocQty, long dlrPerfYr2ComdtyQty,
		String dlrPerfYr2DlrCtgry, String dlrPerfYr2Rmrk, long dlrPerfYr3SN,
		long dlrPerfYr3AllocQty, long dlrPerfYr3ComdtyQty,
		String dlrPerfYr3DlrCtgry, String dlrPerfYr3Rmrk,
		int dlrOptFoodgrainLicense, int dlrOptTradeLicense,
		int dlrOptTcvDlrLicense, int dlrOptImportLicense,
		int dlrOptLicenseEssentialGoods, int dlrOptTradeLicenseAgriculture);

	/**
	 * Updates the dgf dlr updt temp dtls in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrUpdtTempDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDlrUpdtTempDtls the dgf dlr updt temp dtls
	 * @return the dgf dlr updt temp dtls that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DgfDlrUpdtTempDtls updateDgfDlrUpdtTempDtls(
		DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls);

}