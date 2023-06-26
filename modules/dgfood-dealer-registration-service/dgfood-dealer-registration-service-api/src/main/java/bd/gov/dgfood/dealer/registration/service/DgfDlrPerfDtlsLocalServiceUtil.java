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

import bd.gov.dgfood.dealer.registration.model.DgfDlrPerfDtls;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DgfDlrPerfDtls. This utility wraps
 * <code>bd.gov.dgfood.dealer.registration.service.impl.DgfDlrPerfDtlsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrPerfDtlsLocalService
 * @generated
 */
public class DgfDlrPerfDtlsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>bd.gov.dgfood.dealer.registration.service.impl.DgfDlrPerfDtlsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the dgf dlr perf dtls to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrPerfDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDlrPerfDtls the dgf dlr perf dtls
	 * @return the dgf dlr perf dtls that was added
	 */
	public static DgfDlrPerfDtls addDgfDlrPerfDtls(
		DgfDlrPerfDtls dgfDlrPerfDtls) {

		return getService().addDgfDlrPerfDtls(dgfDlrPerfDtls);
	}

	/**
	 * Creates a new dgf dlr perf dtls with the primary key. Does not add the dgf dlr perf dtls to the database.
	 *
	 * @param dgfDlrPerfId the primary key for the new dgf dlr perf dtls
	 * @return the new dgf dlr perf dtls
	 */
	public static DgfDlrPerfDtls createDgfDlrPerfDtls(long dgfDlrPerfId) {
		return getService().createDgfDlrPerfDtls(dgfDlrPerfId);
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
	 * Deletes the dgf dlr perf dtls from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrPerfDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDlrPerfDtls the dgf dlr perf dtls
	 * @return the dgf dlr perf dtls that was removed
	 */
	public static DgfDlrPerfDtls deleteDgfDlrPerfDtls(
		DgfDlrPerfDtls dgfDlrPerfDtls) {

		return getService().deleteDgfDlrPerfDtls(dgfDlrPerfDtls);
	}

	/**
	 * Deletes the dgf dlr perf dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrPerfDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDlrPerfId the primary key of the dgf dlr perf dtls
	 * @return the dgf dlr perf dtls that was removed
	 * @throws PortalException if a dgf dlr perf dtls with the primary key could not be found
	 */
	public static DgfDlrPerfDtls deleteDgfDlrPerfDtls(long dgfDlrPerfId)
		throws PortalException {

		return getService().deleteDgfDlrPerfDtls(dgfDlrPerfId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.dealer.registration.model.impl.DgfDlrPerfDtlsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.dealer.registration.model.impl.DgfDlrPerfDtlsModelImpl</code>.
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

	public static DgfDlrPerfDtls fetchDgfDlrPerfDtls(long dgfDlrPerfId) {
		return getService().fetchDgfDlrPerfDtls(dgfDlrPerfId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the dgf dlr perf dtls with the primary key.
	 *
	 * @param dgfDlrPerfId the primary key of the dgf dlr perf dtls
	 * @return the dgf dlr perf dtls
	 * @throws PortalException if a dgf dlr perf dtls with the primary key could not be found
	 */
	public static DgfDlrPerfDtls getDgfDlrPerfDtls(long dgfDlrPerfId)
		throws PortalException {

		return getService().getDgfDlrPerfDtls(dgfDlrPerfId);
	}

	public static DgfDlrPerfDtls getDgfDlrPerfDtlsByDlrRegNo(long dlrRegNo) {
		return getService().getDgfDlrPerfDtlsByDlrRegNo(dlrRegNo);
	}

	public static List<DgfDlrPerfDtls> getDgfDlrPerfDtlsByNid(String nid) {
		return getService().getDgfDlrPerfDtlsByNid(nid);
	}

	/**
	 * Returns a range of all the dgf dlr perf dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.dealer.registration.model.impl.DgfDlrPerfDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr perf dtlses
	 * @param end the upper bound of the range of dgf dlr perf dtlses (not inclusive)
	 * @return the range of dgf dlr perf dtlses
	 */
	public static List<DgfDlrPerfDtls> getDgfDlrPerfDtlses(int start, int end) {
		return getService().getDgfDlrPerfDtlses(start, end);
	}

	/**
	 * Returns the number of dgf dlr perf dtlses.
	 *
	 * @return the number of dgf dlr perf dtlses
	 */
	public static int getDgfDlrPerfDtlsesCount() {
		return getService().getDgfDlrPerfDtlsesCount();
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

	public static DgfDlrPerfDtls saveDgfDlrPerfDtls(
		String nid, long dlrPerfYr1SN, long dlrPerfYr1AllocQty,
		long dlrPerfYr1ComdtyQty, String dlrPerfYr1DlrCtgry,
		String dlrPerfYr1Rmrk, long dlrPerfYr2SN, long dlrPerfYr2AllocQty,
		long dlrPerfYr2ComdtyQty, String dlrPerfYr2DlrCtgry,
		String dlrPerfYr2Rmrk, long dlrPerfYr3SN, long dlrPerfYr3AllocQty,
		long dlrPerfYr3ComdtyQty, String dlrPerfYr3DlrCtgry,
		String dlrPerfYr3Rmrk) {

		return getService().saveDgfDlrPerfDtls(
			nid, dlrPerfYr1SN, dlrPerfYr1AllocQty, dlrPerfYr1ComdtyQty,
			dlrPerfYr1DlrCtgry, dlrPerfYr1Rmrk, dlrPerfYr2SN,
			dlrPerfYr2AllocQty, dlrPerfYr2ComdtyQty, dlrPerfYr2DlrCtgry,
			dlrPerfYr2Rmrk, dlrPerfYr3SN, dlrPerfYr3AllocQty,
			dlrPerfYr3ComdtyQty, dlrPerfYr3DlrCtgry, dlrPerfYr3Rmrk);
	}

	/**
	 * Updates the dgf dlr perf dtls in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfDlrPerfDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfDlrPerfDtls the dgf dlr perf dtls
	 * @return the dgf dlr perf dtls that was updated
	 */
	public static DgfDlrPerfDtls updateDgfDlrPerfDtls(
		DgfDlrPerfDtls dgfDlrPerfDtls) {

		return getService().updateDgfDlrPerfDtls(dgfDlrPerfDtls);
	}

	public static DgfDlrPerfDtlsLocalService getService() {
		return _service;
	}

	private static volatile DgfDlrPerfDtlsLocalService _service;

}