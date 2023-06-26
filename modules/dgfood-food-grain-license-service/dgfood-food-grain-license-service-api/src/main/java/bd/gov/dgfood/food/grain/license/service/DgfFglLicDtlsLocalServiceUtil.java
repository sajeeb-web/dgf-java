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

import bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DgfFglLicDtls. This utility wraps
 * <code>bd.gov.dgfood.food.grain.license.service.impl.DgfFglLicDtlsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DgfFglLicDtlsLocalService
 * @generated
 */
public class DgfFglLicDtlsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>bd.gov.dgfood.food.grain.license.service.impl.DgfFglLicDtlsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the dgf fgl lic dtls to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfFglLicDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfFglLicDtls the dgf fgl lic dtls
	 * @return the dgf fgl lic dtls that was added
	 */
	public static DgfFglLicDtls addDgfFglLicDtls(DgfFglLicDtls dgfFglLicDtls) {
		return getService().addDgfFglLicDtls(dgfFglLicDtls);
	}

	/**
	 * Creates a new dgf fgl lic dtls with the primary key. Does not add the dgf fgl lic dtls to the database.
	 *
	 * @param fglLicPrimaryId the primary key for the new dgf fgl lic dtls
	 * @return the new dgf fgl lic dtls
	 */
	public static DgfFglLicDtls createDgfFglLicDtls(long fglLicPrimaryId) {
		return getService().createDgfFglLicDtls(fglLicPrimaryId);
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
	 * Deletes the dgf fgl lic dtls from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfFglLicDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfFglLicDtls the dgf fgl lic dtls
	 * @return the dgf fgl lic dtls that was removed
	 */
	public static DgfFglLicDtls deleteDgfFglLicDtls(
		DgfFglLicDtls dgfFglLicDtls) {

		return getService().deleteDgfFglLicDtls(dgfFglLicDtls);
	}

	/**
	 * Deletes the dgf fgl lic dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfFglLicDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fglLicPrimaryId the primary key of the dgf fgl lic dtls
	 * @return the dgf fgl lic dtls that was removed
	 * @throws PortalException if a dgf fgl lic dtls with the primary key could not be found
	 */
	public static DgfFglLicDtls deleteDgfFglLicDtls(long fglLicPrimaryId)
		throws PortalException {

		return getService().deleteDgfFglLicDtls(fglLicPrimaryId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfFglLicDtlsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfFglLicDtlsModelImpl</code>.
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

	public static DgfFglLicDtls fetchDgfFglLicDtls(long fglLicPrimaryId) {
		return getService().fetchDgfFglLicDtls(fglLicPrimaryId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the dgf fgl lic dtls with the primary key.
	 *
	 * @param fglLicPrimaryId the primary key of the dgf fgl lic dtls
	 * @return the dgf fgl lic dtls
	 * @throws PortalException if a dgf fgl lic dtls with the primary key could not be found
	 */
	public static DgfFglLicDtls getDgfFglLicDtls(long fglLicPrimaryId)
		throws PortalException {

		return getService().getDgfFglLicDtls(fglLicPrimaryId);
	}

	public static DgfFglLicDtls getDgfFglLicDtlsByFglApplicationNo(
		String fglApplicationNo) {

		return getService().getDgfFglLicDtlsByFglApplicationNo(
			fglApplicationNo);
	}

	public static DgfFglLicDtls getDgfFglLicDtlsByFglLicNo(String licenseNo) {
		return getService().getDgfFglLicDtlsByFglLicNo(licenseNo);
	}

	public static DgfFglLicDtls getDgfFglLicDtlsByFglPrePrimaryId(
		long fglPrePrimaryId) {

		return getService().getDgfFglLicDtlsByFglPrePrimaryId(fglPrePrimaryId);
	}

	public static DgfFglLicDtls getDgfFglLicDtlsByNid(String nationalId) {
		return getService().getDgfFglLicDtlsByNid(nationalId);
	}

	public static DgfFglLicDtls getDgfFglLicDtlsByNidAndFglLicNo(
		String nationalId, String licenseNo) {

		return getService().getDgfFglLicDtlsByNidAndFglLicNo(
			nationalId, licenseNo);
	}

	/**
	 * Returns a range of all the dgf fgl lic dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfFglLicDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl lic dtlses
	 * @param end the upper bound of the range of dgf fgl lic dtlses (not inclusive)
	 * @return the range of dgf fgl lic dtlses
	 */
	public static List<DgfFglLicDtls> getDgfFglLicDtlses(int start, int end) {
		return getService().getDgfFglLicDtlses(start, end);
	}

	/**
	 * Returns the number of dgf fgl lic dtlses.
	 *
	 * @return the number of dgf fgl lic dtlses
	 */
	public static int getDgfFglLicDtlsesCount() {
		return getService().getDgfFglLicDtlsesCount();
	}

	public static List<DgfFglLicDtls> getDgfFglLicDtlsListByNid(String nid) {
		return getService().getDgfFglLicDtlsListByNid(nid);
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

	/**
	 * Updates the dgf fgl lic dtls in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfFglLicDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfFglLicDtls the dgf fgl lic dtls
	 * @return the dgf fgl lic dtls that was updated
	 */
	public static DgfFglLicDtls updateDgfFglLicDtls(
		DgfFglLicDtls dgfFglLicDtls) {

		return getService().updateDgfFglLicDtls(dgfFglLicDtls);
	}

	public static DgfFglLicDtlsLocalService getService() {
		return _service;
	}

	private static volatile DgfFglLicDtlsLocalService _service;

}