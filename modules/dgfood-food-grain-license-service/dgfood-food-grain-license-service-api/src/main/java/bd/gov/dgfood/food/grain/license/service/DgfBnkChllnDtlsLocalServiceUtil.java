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

import bd.gov.dgfood.food.grain.license.model.DgfBnkChllnDtls;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DgfBnkChllnDtls. This utility wraps
 * <code>bd.gov.dgfood.food.grain.license.service.impl.DgfBnkChllnDtlsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DgfBnkChllnDtlsLocalService
 * @generated
 */
public class DgfBnkChllnDtlsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>bd.gov.dgfood.food.grain.license.service.impl.DgfBnkChllnDtlsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the dgf bnk chlln dtls to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfBnkChllnDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfBnkChllnDtls the dgf bnk chlln dtls
	 * @return the dgf bnk chlln dtls that was added
	 */
	public static DgfBnkChllnDtls addDgfBnkChllnDtls(
		DgfBnkChllnDtls dgfBnkChllnDtls) {

		return getService().addDgfBnkChllnDtls(dgfBnkChllnDtls);
	}

	/**
	 * Creates a new dgf bnk chlln dtls with the primary key. Does not add the dgf bnk chlln dtls to the database.
	 *
	 * @param bnkChllnId the primary key for the new dgf bnk chlln dtls
	 * @return the new dgf bnk chlln dtls
	 */
	public static DgfBnkChllnDtls createDgfBnkChllnDtls(long bnkChllnId) {
		return getService().createDgfBnkChllnDtls(bnkChllnId);
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
	 * Deletes the dgf bnk chlln dtls from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfBnkChllnDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfBnkChllnDtls the dgf bnk chlln dtls
	 * @return the dgf bnk chlln dtls that was removed
	 */
	public static DgfBnkChllnDtls deleteDgfBnkChllnDtls(
		DgfBnkChllnDtls dgfBnkChllnDtls) {

		return getService().deleteDgfBnkChllnDtls(dgfBnkChllnDtls);
	}

	/**
	 * Deletes the dgf bnk chlln dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfBnkChllnDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bnkChllnId the primary key of the dgf bnk chlln dtls
	 * @return the dgf bnk chlln dtls that was removed
	 * @throws PortalException if a dgf bnk chlln dtls with the primary key could not be found
	 */
	public static DgfBnkChllnDtls deleteDgfBnkChllnDtls(long bnkChllnId)
		throws PortalException {

		return getService().deleteDgfBnkChllnDtls(bnkChllnId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfBnkChllnDtlsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfBnkChllnDtlsModelImpl</code>.
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

	public static DgfBnkChllnDtls fetchDgfBnkChllnDtls(long bnkChllnId) {
		return getService().fetchDgfBnkChllnDtls(bnkChllnId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the dgf bnk chlln dtls with the primary key.
	 *
	 * @param bnkChllnId the primary key of the dgf bnk chlln dtls
	 * @return the dgf bnk chlln dtls
	 * @throws PortalException if a dgf bnk chlln dtls with the primary key could not be found
	 */
	public static DgfBnkChllnDtls getDgfBnkChllnDtls(long bnkChllnId)
		throws PortalException {

		return getService().getDgfBnkChllnDtls(bnkChllnId);
	}

	/**
	 * Returns a range of all the dgf bnk chlln dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfBnkChllnDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf bnk chlln dtlses
	 * @param end the upper bound of the range of dgf bnk chlln dtlses (not inclusive)
	 * @return the range of dgf bnk chlln dtlses
	 */
	public static List<DgfBnkChllnDtls> getDgfBnkChllnDtlses(
		int start, int end) {

		return getService().getDgfBnkChllnDtlses(start, end);
	}

	/**
	 * Returns the number of dgf bnk chlln dtlses.
	 *
	 * @return the number of dgf bnk chlln dtlses
	 */
	public static int getDgfBnkChllnDtlsesCount() {
		return getService().getDgfBnkChllnDtlsesCount();
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
	 * Updates the dgf bnk chlln dtls in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfBnkChllnDtlsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfBnkChllnDtls the dgf bnk chlln dtls
	 * @return the dgf bnk chlln dtls that was updated
	 */
	public static DgfBnkChllnDtls updateDgfBnkChllnDtls(
		DgfBnkChllnDtls dgfBnkChllnDtls) {

		return getService().updateDgfBnkChllnDtls(dgfBnkChllnDtls);
	}

	public static DgfBnkChllnDtlsLocalService getService() {
		return _service;
	}

	private static volatile DgfBnkChllnDtlsLocalService _service;

}