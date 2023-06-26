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

package bd.gov.dgfood.food.friendly.program.service;

import bd.gov.dgfood.food.friendly.program.model.DlrFfpOmsAllcNtfyDetails;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DlrFfpOmsAllcNtfyDetails. This utility wraps
 * <code>bd.gov.dgfood.food.friendly.program.service.impl.DlrFfpOmsAllcNtfyDetailsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DlrFfpOmsAllcNtfyDetailsLocalService
 * @generated
 */
public class DlrFfpOmsAllcNtfyDetailsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>bd.gov.dgfood.food.friendly.program.service.impl.DlrFfpOmsAllcNtfyDetailsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the dlr ffp oms allc ntfy details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DlrFfpOmsAllcNtfyDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dlrFfpOmsAllcNtfyDetails the dlr ffp oms allc ntfy details
	 * @return the dlr ffp oms allc ntfy details that was added
	 */
	public static DlrFfpOmsAllcNtfyDetails addDlrFfpOmsAllcNtfyDetails(
		DlrFfpOmsAllcNtfyDetails dlrFfpOmsAllcNtfyDetails) {

		return getService().addDlrFfpOmsAllcNtfyDetails(
			dlrFfpOmsAllcNtfyDetails);
	}

	/**
	 * Creates a new dlr ffp oms allc ntfy details with the primary key. Does not add the dlr ffp oms allc ntfy details to the database.
	 *
	 * @param allocNtfyId the primary key for the new dlr ffp oms allc ntfy details
	 * @return the new dlr ffp oms allc ntfy details
	 */
	public static DlrFfpOmsAllcNtfyDetails createDlrFfpOmsAllcNtfyDetails(
		String allocNtfyId) {

		return getService().createDlrFfpOmsAllcNtfyDetails(allocNtfyId);
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
	 * Deletes the dlr ffp oms allc ntfy details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DlrFfpOmsAllcNtfyDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dlrFfpOmsAllcNtfyDetails the dlr ffp oms allc ntfy details
	 * @return the dlr ffp oms allc ntfy details that was removed
	 */
	public static DlrFfpOmsAllcNtfyDetails deleteDlrFfpOmsAllcNtfyDetails(
		DlrFfpOmsAllcNtfyDetails dlrFfpOmsAllcNtfyDetails) {

		return getService().deleteDlrFfpOmsAllcNtfyDetails(
			dlrFfpOmsAllcNtfyDetails);
	}

	/**
	 * Deletes the dlr ffp oms allc ntfy details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DlrFfpOmsAllcNtfyDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param allocNtfyId the primary key of the dlr ffp oms allc ntfy details
	 * @return the dlr ffp oms allc ntfy details that was removed
	 * @throws PortalException if a dlr ffp oms allc ntfy details with the primary key could not be found
	 */
	public static DlrFfpOmsAllcNtfyDetails deleteDlrFfpOmsAllcNtfyDetails(
			String allocNtfyId)
		throws PortalException {

		return getService().deleteDlrFfpOmsAllcNtfyDetails(allocNtfyId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.friendly.program.model.impl.DlrFfpOmsAllcNtfyDetailsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.friendly.program.model.impl.DlrFfpOmsAllcNtfyDetailsModelImpl</code>.
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

	public static DlrFfpOmsAllcNtfyDetails fetchDlrFfpOmsAllcNtfyDetails(
		String allocNtfyId) {

		return getService().fetchDlrFfpOmsAllcNtfyDetails(allocNtfyId);
	}

	/**
	 * Returns the dlr ffp oms allc ntfy details with the primary key.
	 *
	 * @param allocNtfyId the primary key of the dlr ffp oms allc ntfy details
	 * @return the dlr ffp oms allc ntfy details
	 * @throws PortalException if a dlr ffp oms allc ntfy details with the primary key could not be found
	 */
	public static DlrFfpOmsAllcNtfyDetails getDlrFfpOmsAllcNtfyDetails(
			String allocNtfyId)
		throws PortalException {

		return getService().getDlrFfpOmsAllcNtfyDetails(allocNtfyId);
	}

	/**
	 * Returns a range of all the dlr ffp oms allc ntfy detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.friendly.program.model.impl.DlrFfpOmsAllcNtfyDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dlr ffp oms allc ntfy detailses
	 * @param end the upper bound of the range of dlr ffp oms allc ntfy detailses (not inclusive)
	 * @return the range of dlr ffp oms allc ntfy detailses
	 */
	public static List<DlrFfpOmsAllcNtfyDetails> getDlrFfpOmsAllcNtfyDetailses(
		int start, int end) {

		return getService().getDlrFfpOmsAllcNtfyDetailses(start, end);
	}

	/**
	 * Returns the number of dlr ffp oms allc ntfy detailses.
	 *
	 * @return the number of dlr ffp oms allc ntfy detailses
	 */
	public static int getDlrFfpOmsAllcNtfyDetailsesCount() {
		return getService().getDlrFfpOmsAllcNtfyDetailsesCount();
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
	 * Updates the dlr ffp oms allc ntfy details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DlrFfpOmsAllcNtfyDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dlrFfpOmsAllcNtfyDetails the dlr ffp oms allc ntfy details
	 * @return the dlr ffp oms allc ntfy details that was updated
	 */
	public static DlrFfpOmsAllcNtfyDetails updateDlrFfpOmsAllcNtfyDetails(
		DlrFfpOmsAllcNtfyDetails dlrFfpOmsAllcNtfyDetails) {

		return getService().updateDlrFfpOmsAllcNtfyDetails(
			dlrFfpOmsAllcNtfyDetails);
	}

	public static DlrFfpOmsAllcNtfyDetailsLocalService getService() {
		return _service;
	}

	private static volatile DlrFfpOmsAllcNtfyDetailsLocalService _service;

}