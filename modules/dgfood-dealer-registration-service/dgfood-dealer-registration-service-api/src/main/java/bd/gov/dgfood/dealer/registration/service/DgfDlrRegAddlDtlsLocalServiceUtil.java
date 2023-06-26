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

import bd.gov.dgfood.dealer.registration.model.DgfDlrRegAddlDtls;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DgfDlrRegAddlDtls. This utility wraps
 * <code>bd.gov.dgfood.dealer.registration.service.impl.DgfDlrRegAddlDtlsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrRegAddlDtlsLocalService
 * @generated
 */
public class DgfDlrRegAddlDtlsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>bd.gov.dgfood.dealer.registration.service.impl.DgfDlrRegAddlDtlsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the dgf dlr reg addl dtls to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrRegAddlDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDlrRegAddlDtls the dgf dlr reg addl dtls
	 * @return the dgf dlr reg addl dtls that was added
	 */
	public static DgfDlrRegAddlDtls addDgfDlrRegAddlDtls(
		DgfDlrRegAddlDtls dgfDlrRegAddlDtls) {

		return getService().addDgfDlrRegAddlDtls(dgfDlrRegAddlDtls);
	}

	/**
	 * Creates a new dgf dlr reg addl dtls with the primary key. Does not add the dgf dlr reg addl dtls to the database.
	 *
	 * @param dlrRegAddlDtlsId the primary key for the new dgf dlr reg addl dtls
	 * @return the new dgf dlr reg addl dtls
	 */
	public static DgfDlrRegAddlDtls createDgfDlrRegAddlDtls(
		long dlrRegAddlDtlsId) {

		return getService().createDgfDlrRegAddlDtls(dlrRegAddlDtlsId);
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
	 * Deletes the dgf dlr reg addl dtls from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrRegAddlDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDlrRegAddlDtls the dgf dlr reg addl dtls
	 * @return the dgf dlr reg addl dtls that was removed
	 */
	public static DgfDlrRegAddlDtls deleteDgfDlrRegAddlDtls(
		DgfDlrRegAddlDtls dgfDlrRegAddlDtls) {

		return getService().deleteDgfDlrRegAddlDtls(dgfDlrRegAddlDtls);
	}

	/**
	 * Deletes the dgf dlr reg addl dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrRegAddlDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dlrRegAddlDtlsId the primary key of the dgf dlr reg addl dtls
	 * @return the dgf dlr reg addl dtls that was removed
	 * @throws PortalException if a dgf dlr reg addl dtls with the primary key could not be found
	 */
	public static DgfDlrRegAddlDtls deleteDgfDlrRegAddlDtls(
			long dlrRegAddlDtlsId)
		throws PortalException {

		return getService().deleteDgfDlrRegAddlDtls(dlrRegAddlDtlsId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.dealer.registration.model.impl.DgfDlrRegAddlDtlsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.dealer.registration.model.impl.DgfDlrRegAddlDtlsModelImpl</code>.
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

	public static DgfDlrRegAddlDtls fetchDgfDlrRegAddlDtls(
		long dlrRegAddlDtlsId) {

		return getService().fetchDgfDlrRegAddlDtls(dlrRegAddlDtlsId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the dgf dlr reg addl dtls with the primary key.
	 *
	 * @param dlrRegAddlDtlsId the primary key of the dgf dlr reg addl dtls
	 * @return the dgf dlr reg addl dtls
	 * @throws PortalException if a dgf dlr reg addl dtls with the primary key could not be found
	 */
	public static DgfDlrRegAddlDtls getDgfDlrRegAddlDtls(long dlrRegAddlDtlsId)
		throws PortalException {

		return getService().getDgfDlrRegAddlDtls(dlrRegAddlDtlsId);
	}

	public static List<DgfDlrRegAddlDtls> getDgfDlrRegAddlDtlsByNid(
		String nid) {

		return getService().getDgfDlrRegAddlDtlsByNid(nid);
	}

	public static DgfDlrRegAddlDtls getDgfDlrRegAddlDtlsByRegNo(long dlrRegNo) {
		return getService().getDgfDlrRegAddlDtlsByRegNo(dlrRegNo);
	}

	/**
	 * Returns a range of all the dgf dlr reg addl dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.dealer.registration.model.impl.DgfDlrRegAddlDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr reg addl dtlses
	 * @param end the upper bound of the range of dgf dlr reg addl dtlses (not inclusive)
	 * @return the range of dgf dlr reg addl dtlses
	 */
	public static List<DgfDlrRegAddlDtls> getDgfDlrRegAddlDtlses(
		int start, int end) {

		return getService().getDgfDlrRegAddlDtlses(start, end);
	}

	/**
	 * Returns the number of dgf dlr reg addl dtlses.
	 *
	 * @return the number of dgf dlr reg addl dtlses
	 */
	public static int getDgfDlrRegAddlDtlsesCount() {
		return getService().getDgfDlrRegAddlDtlsesCount();
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

	public static DgfDlrRegAddlDtls saveDgfDlrRegAddlDtls(
		String nid, long phsclyChlnGdAttchId, int workInGovt, int publcRep,
		int physclyChlngd, long shopHeight, long shopLength, long shopWidth,
		long shopStorageCap, int isCemented, int signBoard,
		int dlrRunShpHimself, String dealershipMemName,
		String dealershipMemType, int truckType, String truckRentFlag,
		String truckPlatNo, long truckCap, String truckMake, String truckModel,
		long truckManuYear) {

		return getService().saveDgfDlrRegAddlDtls(
			nid, phsclyChlnGdAttchId, workInGovt, publcRep, physclyChlngd,
			shopHeight, shopLength, shopWidth, shopStorageCap, isCemented,
			signBoard, dlrRunShpHimself, dealershipMemName, dealershipMemType,
			truckType, truckRentFlag, truckPlatNo, truckCap, truckMake,
			truckModel, truckManuYear);
	}

	/**
	 * Updates the dgf dlr reg addl dtls in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrRegAddlDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDlrRegAddlDtls the dgf dlr reg addl dtls
	 * @return the dgf dlr reg addl dtls that was updated
	 */
	public static DgfDlrRegAddlDtls updateDgfDlrRegAddlDtls(
		DgfDlrRegAddlDtls dgfDlrRegAddlDtls) {

		return getService().updateDgfDlrRegAddlDtls(dgfDlrRegAddlDtls);
	}

	public static DgfDlrRegAddlDtlsLocalService getService() {
		return _service;
	}

	private static volatile DgfDlrRegAddlDtlsLocalService _service;

}