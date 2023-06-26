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
 * Provides a wrapper for {@link DgfDlrUpdtTempDtlsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrUpdtTempDtlsLocalService
 * @generated
 */
public class DgfDlrUpdtTempDtlsLocalServiceWrapper
	implements DgfDlrUpdtTempDtlsLocalService,
			   ServiceWrapper<DgfDlrUpdtTempDtlsLocalService> {

	public DgfDlrUpdtTempDtlsLocalServiceWrapper() {
		this(null);
	}

	public DgfDlrUpdtTempDtlsLocalServiceWrapper(
		DgfDlrUpdtTempDtlsLocalService dgfDlrUpdtTempDtlsLocalService) {

		_dgfDlrUpdtTempDtlsLocalService = dgfDlrUpdtTempDtlsLocalService;
	}

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
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrUpdtTempDtls
		addDgfDlrUpdtTempDtls(
			bd.gov.dgfood.dealer.registration.model.DgfDlrUpdtTempDtls
				dgfDlrUpdtTempDtls) {

		return _dgfDlrUpdtTempDtlsLocalService.addDgfDlrUpdtTempDtls(
			dgfDlrUpdtTempDtls);
	}

	/**
	 * Creates a new dgf dlr updt temp dtls with the primary key. Does not add the dgf dlr updt temp dtls to the database.
	 *
	 * @param dgfDlrUpdateReqId the primary key for the new dgf dlr updt temp dtls
	 * @return the new dgf dlr updt temp dtls
	 */
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrUpdtTempDtls
		createDgfDlrUpdtTempDtls(long dgfDlrUpdateReqId) {

		return _dgfDlrUpdtTempDtlsLocalService.createDgfDlrUpdtTempDtls(
			dgfDlrUpdateReqId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrUpdtTempDtlsLocalService.createPersistedModel(
			primaryKeyObj);
	}

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
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrUpdtTempDtls
		deleteDgfDlrUpdtTempDtls(
			bd.gov.dgfood.dealer.registration.model.DgfDlrUpdtTempDtls
				dgfDlrUpdtTempDtls) {

		return _dgfDlrUpdtTempDtlsLocalService.deleteDgfDlrUpdtTempDtls(
			dgfDlrUpdtTempDtls);
	}

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
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrUpdtTempDtls
			deleteDgfDlrUpdtTempDtls(long dgfDlrUpdateReqId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrUpdtTempDtlsLocalService.deleteDgfDlrUpdtTempDtls(
			dgfDlrUpdateReqId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrUpdtTempDtlsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgfDlrUpdtTempDtlsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgfDlrUpdtTempDtlsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgfDlrUpdtTempDtlsLocalService.dynamicQuery();
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

		return _dgfDlrUpdtTempDtlsLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _dgfDlrUpdtTempDtlsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _dgfDlrUpdtTempDtlsLocalService.dynamicQuery(
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

		return _dgfDlrUpdtTempDtlsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dgfDlrUpdtTempDtlsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrUpdtTempDtls
		fetchDgfDlrUpdtTempDtls(long dgfDlrUpdateReqId) {

		return _dgfDlrUpdtTempDtlsLocalService.fetchDgfDlrUpdtTempDtls(
			dgfDlrUpdateReqId);
	}

	@Override
	public java.util.List
		<bd.gov.dgfood.dealer.registration.model.DgfDlrUpdtTempDtls>
				findAllOrderedByIdDesc(String nid)
			throws com.liferay.portal.kernel.exception.SystemException {

		return _dgfDlrUpdtTempDtlsLocalService.findAllOrderedByIdDesc(nid);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgfDlrUpdtTempDtlsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the dgf dlr updt temp dtls with the primary key.
	 *
	 * @param dgfDlrUpdateReqId the primary key of the dgf dlr updt temp dtls
	 * @return the dgf dlr updt temp dtls
	 * @throws PortalException if a dgf dlr updt temp dtls with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrUpdtTempDtls
			getDgfDlrUpdtTempDtls(long dgfDlrUpdateReqId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrUpdtTempDtlsLocalService.getDgfDlrUpdtTempDtls(
			dgfDlrUpdateReqId);
	}

	@Override
	public java.util.List
		<bd.gov.dgfood.dealer.registration.model.DgfDlrUpdtTempDtls>
			getDgfDlrUpdtTempDtlsByNid(String nid) {

		return _dgfDlrUpdtTempDtlsLocalService.getDgfDlrUpdtTempDtlsByNid(nid);
	}

	@Override
	public java.util.List
		<bd.gov.dgfood.dealer.registration.model.DgfDlrUpdtTempDtls>
			getDgfDlrUpdtTempDtlsByRegNo(long dlrRegNo) {

		return _dgfDlrUpdtTempDtlsLocalService.getDgfDlrUpdtTempDtlsByRegNo(
			dlrRegNo);
	}

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
	@Override
	public java.util.List
		<bd.gov.dgfood.dealer.registration.model.DgfDlrUpdtTempDtls>
			getDgfDlrUpdtTempDtlses(int start, int end) {

		return _dgfDlrUpdtTempDtlsLocalService.getDgfDlrUpdtTempDtlses(
			start, end);
	}

	/**
	 * Returns the number of dgf dlr updt temp dtlses.
	 *
	 * @return the number of dgf dlr updt temp dtlses
	 */
	@Override
	public int getDgfDlrUpdtTempDtlsesCount() {
		return _dgfDlrUpdtTempDtlsLocalService.getDgfDlrUpdtTempDtlsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgfDlrUpdtTempDtlsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfDlrUpdtTempDtlsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfDlrUpdtTempDtlsLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrUpdtTempDtls
		saveDgfDlrUpdtTempDtls(
			String nid, long phsclyChlnGdAttchId, int workInGovt, int publcRep,
			int physclyChlngd, long shopDiv, long shopDis, long shopUpazila,
			long shopUnion, String shopWard, String shopZipCode, String shopLoc,
			long shopHeight, long shopLength, long shopWidth,
			long shopStorageCap, int isCemented, int signBoard,
			int dlrRunShpHimself, String dealershipMemName,
			String dealershipMemType, int truckType, String truckRentFlag,
			String truckPlatNo, long truckCap, String truckMake,
			String truckModel, long truckManuYear, long dlrPerfYr1SN,
			long dlrPerfYr1AllocQty, long dlrPerfYr1ComdtyQty,
			String dlrPerfYr1DlrCtgry, String dlrPerfYr1Rmrk, long dlrPerfYr2SN,
			long dlrPerfYr2AllocQty, long dlrPerfYr2ComdtyQty,
			String dlrPerfYr2DlrCtgry, String dlrPerfYr2Rmrk, long dlrPerfYr3SN,
			long dlrPerfYr3AllocQty, long dlrPerfYr3ComdtyQty,
			String dlrPerfYr3DlrCtgry, String dlrPerfYr3Rmrk,
			int dlrOptFoodgrainLicense, int dlrOptTradeLicense,
			int dlrOptTcvDlrLicense, int dlrOptImportLicense,
			int dlrOptLicenseEssentialGoods,
			int dlrOptTradeLicenseAgriculture) {

		return _dgfDlrUpdtTempDtlsLocalService.saveDgfDlrUpdtTempDtls(
			nid, phsclyChlnGdAttchId, workInGovt, publcRep, physclyChlngd,
			shopDiv, shopDis, shopUpazila, shopUnion, shopWard, shopZipCode,
			shopLoc, shopHeight, shopLength, shopWidth, shopStorageCap,
			isCemented, signBoard, dlrRunShpHimself, dealershipMemName,
			dealershipMemType, truckType, truckRentFlag, truckPlatNo, truckCap,
			truckMake, truckModel, truckManuYear, dlrPerfYr1SN,
			dlrPerfYr1AllocQty, dlrPerfYr1ComdtyQty, dlrPerfYr1DlrCtgry,
			dlrPerfYr1Rmrk, dlrPerfYr2SN, dlrPerfYr2AllocQty,
			dlrPerfYr2ComdtyQty, dlrPerfYr2DlrCtgry, dlrPerfYr2Rmrk,
			dlrPerfYr3SN, dlrPerfYr3AllocQty, dlrPerfYr3ComdtyQty,
			dlrPerfYr3DlrCtgry, dlrPerfYr3Rmrk, dlrOptFoodgrainLicense,
			dlrOptTradeLicense, dlrOptTcvDlrLicense, dlrOptImportLicense,
			dlrOptLicenseEssentialGoods, dlrOptTradeLicenseAgriculture);
	}

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
	@Override
	public bd.gov.dgfood.dealer.registration.model.DgfDlrUpdtTempDtls
		updateDgfDlrUpdtTempDtls(
			bd.gov.dgfood.dealer.registration.model.DgfDlrUpdtTempDtls
				dgfDlrUpdtTempDtls) {

		return _dgfDlrUpdtTempDtlsLocalService.updateDgfDlrUpdtTempDtls(
			dgfDlrUpdtTempDtls);
	}

	@Override
	public DgfDlrUpdtTempDtlsLocalService getWrappedService() {
		return _dgfDlrUpdtTempDtlsLocalService;
	}

	@Override
	public void setWrappedService(
		DgfDlrUpdtTempDtlsLocalService dgfDlrUpdtTempDtlsLocalService) {

		_dgfDlrUpdtTempDtlsLocalService = dgfDlrUpdtTempDtlsLocalService;
	}

	private DgfDlrUpdtTempDtlsLocalService _dgfDlrUpdtTempDtlsLocalService;

}