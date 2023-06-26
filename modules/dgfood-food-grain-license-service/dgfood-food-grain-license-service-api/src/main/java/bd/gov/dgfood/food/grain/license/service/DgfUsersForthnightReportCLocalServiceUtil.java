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

import bd.gov.dgfood.food.grain.license.model.DgfUsersForthnightReportC;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DgfUsersForthnightReportC. This utility wraps
 * <code>bd.gov.dgfood.food.grain.license.service.impl.DgfUsersForthnightReportCLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersForthnightReportCLocalService
 * @generated
 */
public class DgfUsersForthnightReportCLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>bd.gov.dgfood.food.grain.license.service.impl.DgfUsersForthnightReportCLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the dgf users forthnight report c to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersForthnightReportCLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsersForthnightReportC the dgf users forthnight report c
	 * @return the dgf users forthnight report c that was added
	 */
	public static DgfUsersForthnightReportC addDgfUsersForthnightReportC(
		DgfUsersForthnightReportC dgfUsersForthnightReportC) {

		return getService().addDgfUsersForthnightReportC(
			dgfUsersForthnightReportC);
	}

	/**
	 * Creates a new dgf users forthnight report c with the primary key. Does not add the dgf users forthnight report c to the database.
	 *
	 * @param reportId the primary key for the new dgf users forthnight report c
	 * @return the new dgf users forthnight report c
	 */
	public static DgfUsersForthnightReportC createDgfUsersForthnightReportC(
		long reportId) {

		return getService().createDgfUsersForthnightReportC(reportId);
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
	 * Deletes the dgf users forthnight report c from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersForthnightReportCLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsersForthnightReportC the dgf users forthnight report c
	 * @return the dgf users forthnight report c that was removed
	 */
	public static DgfUsersForthnightReportC deleteDgfUsersForthnightReportC(
		DgfUsersForthnightReportC dgfUsersForthnightReportC) {

		return getService().deleteDgfUsersForthnightReportC(
			dgfUsersForthnightReportC);
	}

	/**
	 * Deletes the dgf users forthnight report c with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersForthnightReportCLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param reportId the primary key of the dgf users forthnight report c
	 * @return the dgf users forthnight report c that was removed
	 * @throws PortalException if a dgf users forthnight report c with the primary key could not be found
	 */
	public static DgfUsersForthnightReportC deleteDgfUsersForthnightReportC(
			long reportId)
		throws PortalException {

		return getService().deleteDgfUsersForthnightReportC(reportId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersForthnightReportCModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersForthnightReportCModelImpl</code>.
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

	public static DgfUsersForthnightReportC fetchDgfUsersForthnightReportC(
		long reportId) {

		return getService().fetchDgfUsersForthnightReportC(reportId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the dgf users forthnight report c with the primary key.
	 *
	 * @param reportId the primary key of the dgf users forthnight report c
	 * @return the dgf users forthnight report c
	 * @throws PortalException if a dgf users forthnight report c with the primary key could not be found
	 */
	public static DgfUsersForthnightReportC getDgfUsersForthnightReportC(
			long reportId)
		throws PortalException {

		return getService().getDgfUsersForthnightReportC(reportId);
	}

	/**
	 * Returns a range of all the dgf users forthnight report cs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersForthnightReportCModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users forthnight report cs
	 * @param end the upper bound of the range of dgf users forthnight report cs (not inclusive)
	 * @return the range of dgf users forthnight report cs
	 */
	public static List<DgfUsersForthnightReportC> getDgfUsersForthnightReportCs(
		int start, int end) {

		return getService().getDgfUsersForthnightReportCs(start, end);
	}

	/**
	 * Returns the number of dgf users forthnight report cs.
	 *
	 * @return the number of dgf users forthnight report cs
	 */
	public static int getDgfUsersForthnightReportCsCount() {
		return getService().getDgfUsersForthnightReportCsCount();
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
	 * Updates the dgf users forthnight report c in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersForthnightReportCLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsersForthnightReportC the dgf users forthnight report c
	 * @return the dgf users forthnight report c that was updated
	 */
	public static DgfUsersForthnightReportC updateDgfUsersForthnightReportC(
		DgfUsersForthnightReportC dgfUsersForthnightReportC) {

		return getService().updateDgfUsersForthnightReportC(
			dgfUsersForthnightReportC);
	}

	public static DgfUsersForthnightReportCLocalService getService() {
		return _service;
	}

	private static volatile DgfUsersForthnightReportCLocalService _service;

}