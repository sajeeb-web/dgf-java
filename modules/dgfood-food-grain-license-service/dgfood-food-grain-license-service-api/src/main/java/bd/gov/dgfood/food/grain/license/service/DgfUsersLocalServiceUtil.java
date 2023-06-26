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

import bd.gov.dgfood.food.grain.license.model.DgfUsers;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DgfUsers. This utility wraps
 * <code>bd.gov.dgfood.food.grain.license.service.impl.DgfUsersLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersLocalService
 * @generated
 */
public class DgfUsersLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>bd.gov.dgfood.food.grain.license.service.impl.DgfUsersLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the dgf users to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsers the dgf users
	 * @return the dgf users that was added
	 */
	public static DgfUsers addDgfUsers(DgfUsers dgfUsers) {
		return getService().addDgfUsers(dgfUsers);
	}

	public static void addDgfUsersInfo(
		String name, String phoneNo, String nidNo) {

		getService().addDgfUsersInfo(name, phoneNo, nidNo);
	}

	/**
	 * Creates a new dgf users with the primary key. Does not add the dgf users to the database.
	 *
	 * @param userId the primary key for the new dgf users
	 * @return the new dgf users
	 */
	public static DgfUsers createDgfUsers(long userId) {
		return getService().createDgfUsers(userId);
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
	 * Deletes the dgf users from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsers the dgf users
	 * @return the dgf users that was removed
	 */
	public static DgfUsers deleteDgfUsers(DgfUsers dgfUsers) {
		return getService().deleteDgfUsers(dgfUsers);
	}

	/**
	 * Deletes the dgf users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userId the primary key of the dgf users
	 * @return the dgf users that was removed
	 * @throws PortalException if a dgf users with the primary key could not be found
	 */
	public static DgfUsers deleteDgfUsers(long userId) throws PortalException {
		return getService().deleteDgfUsers(userId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersModelImpl</code>.
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

	public static DgfUsers fetchDgfUsers(long userId) {
		return getService().fetchDgfUsers(userId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<DgfUsers> getDgfAcfUsersByDistrict(
			long districtId, long companyId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersException {

		return getService().getDgfAcfUsersByDistrict(districtId, companyId);
	}

	public static List<DgfUsers> getDgfCcdrUsersByUpazila(
			long upazilaId, long companyId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersException {

		return getService().getDgfCcdrUsersByUpazila(upazilaId, companyId);
	}

	public static List<DgfUsers> getDgfDcfUsersByDistrict(
			long districtId, long companyId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersException {

		return getService().getDgfDcfUsersByDistrict(districtId, companyId);
	}

	public static List<DgfUsers> getDgfRcfUsersByUpazila(
			long upazilaId, long companyId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersException {

		return getService().getDgfRcfUsersByUpazila(upazilaId, companyId);
	}

	public static List<DgfUsers> getDgfUcfUsersByDistrict(
			long upazilaId, long companyId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersException {

		return getService().getDgfUcfUsersByDistrict(upazilaId, companyId);
	}

	/**
	 * Returns the dgf users with the primary key.
	 *
	 * @param userId the primary key of the dgf users
	 * @return the dgf users
	 * @throws PortalException if a dgf users with the primary key could not be found
	 */
	public static DgfUsers getDgfUsers(long userId) throws PortalException {
		return getService().getDgfUsers(userId);
	}

	public static DgfUsers getDgfUsersByNid(String nationalId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersException {

		return getService().getDgfUsersByNid(nationalId);
	}

	/**
	 * Returns a range of all the dgf userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @return the range of dgf userses
	 */
	public static List<DgfUsers> getDgfUserses(int start, int end) {
		return getService().getDgfUserses(start, end);
	}

	/**
	 * Returns the number of dgf userses.
	 *
	 * @return the number of dgf userses
	 */
	public static int getDgfUsersesCount() {
		return getService().getDgfUsersesCount();
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
	 * Updates the dgf users in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsers the dgf users
	 * @return the dgf users that was updated
	 */
	public static DgfUsers updateDgfUsers(DgfUsers dgfUsers) {
		return getService().updateDgfUsers(dgfUsers);
	}

	public static DgfUsersLocalService getService() {
		return _service;
	}

	private static volatile DgfUsersLocalService _service;

}