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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DgfDlrUpdtTempDtls. This utility wraps
 * <code>bd.gov.dgfood.dealer.registration.service.impl.DgfDlrUpdtTempDtlsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrUpdtTempDtlsLocalService
 * @generated
 */
public class DgfDlrUpdtTempDtlsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>bd.gov.dgfood.dealer.registration.service.impl.DgfDlrUpdtTempDtlsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
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
	public static DgfDlrUpdtTempDtls addDgfDlrUpdtTempDtls(
		DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls) {

		return getService().addDgfDlrUpdtTempDtls(dgfDlrUpdtTempDtls);
	}

	/**
	 * Creates a new dgf dlr updt temp dtls with the primary key. Does not add the dgf dlr updt temp dtls to the database.
	 *
	 * @param dgfDlrUpdateReqId the primary key for the new dgf dlr updt temp dtls
	 * @return the new dgf dlr updt temp dtls
	 */
	public static DgfDlrUpdtTempDtls createDgfDlrUpdtTempDtls(
		long dgfDlrUpdateReqId) {

		return getService().createDgfDlrUpdtTempDtls(dgfDlrUpdateReqId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static DgfDlrUpdtTempDtls deleteDgfDlrUpdtTempDtls(
		DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls) {

		return getService().deleteDgfDlrUpdtTempDtls(dgfDlrUpdtTempDtls);
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
	public static DgfDlrUpdtTempDtls deleteDgfDlrUpdtTempDtls(
			long dgfDlrUpdateReqId)
		throws PortalException {

		return getService().deleteDgfDlrUpdtTempDtls(dgfDlrUpdateReqId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static DgfDlrUpdtTempDtls fetchDgfDlrUpdtTempDtls(
		long dgfDlrUpdateReqId) {

		return getService().fetchDgfDlrUpdtTempDtls(dgfDlrUpdateReqId);
	}

	public static List<DgfDlrUpdtTempDtls> findAllOrderedByIdDesc(String nid)
		throws SystemException {

		return getService().findAllOrderedByIdDesc(nid);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the dgf dlr updt temp dtls with the primary key.
	 *
	 * @param dgfDlrUpdateReqId the primary key of the dgf dlr updt temp dtls
	 * @return the dgf dlr updt temp dtls
	 * @throws PortalException if a dgf dlr updt temp dtls with the primary key could not be found
	 */
	public static DgfDlrUpdtTempDtls getDgfDlrUpdtTempDtls(
			long dgfDlrUpdateReqId)
		throws PortalException {

		return getService().getDgfDlrUpdtTempDtls(dgfDlrUpdateReqId);
	}

	public static List<DgfDlrUpdtTempDtls> getDgfDlrUpdtTempDtlsByNid(
		String nid) {

		return getService().getDgfDlrUpdtTempDtlsByNid(nid);
	}

	public static List<DgfDlrUpdtTempDtls> getDgfDlrUpdtTempDtlsByRegNo(
		long dlrRegNo) {

		return getService().getDgfDlrUpdtTempDtlsByRegNo(dlrRegNo);
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
	public static List<DgfDlrUpdtTempDtls> getDgfDlrUpdtTempDtlses(
		int start, int end) {

		return getService().getDgfDlrUpdtTempDtlses(start, end);
	}

	/**
	 * Returns the number of dgf dlr updt temp dtlses.
	 *
	 * @return the number of dgf dlr updt temp dtlses
	 */
	public static int getDgfDlrUpdtTempDtlsesCount() {
		return getService().getDgfDlrUpdtTempDtlsesCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static DgfDlrUpdtTempDtls saveDgfDlrUpdtTempDtls(
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
		int dlrOptLicenseEssentialGoods, int dlrOptTradeLicenseAgriculture) {

		return getService().saveDgfDlrUpdtTempDtls(
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
	public static DgfDlrUpdtTempDtls updateDgfDlrUpdtTempDtls(
		DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls) {

		return getService().updateDgfDlrUpdtTempDtls(dgfDlrUpdtTempDtls);
	}

	public static DgfDlrUpdtTempDtlsLocalService getService() {
		return _service;
	}

	private static volatile DgfDlrUpdtTempDtlsLocalService _service;

}