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

import bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetails;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DgfUsersOtpDetails. This utility wraps
 * <code>bd.gov.dgfood.food.grain.license.service.impl.DgfUsersOtpDetailsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersOtpDetailsLocalService
 * @generated
 */
public class DgfUsersOtpDetailsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>bd.gov.dgfood.food.grain.license.service.impl.DgfUsersOtpDetailsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the dgf users otp details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersOtpDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsersOtpDetails the dgf users otp details
	 * @return the dgf users otp details that was added
	 */
	public static DgfUsersOtpDetails addDgfUsersOtpDetails(
		DgfUsersOtpDetails dgfUsersOtpDetails) {

		return getService().addDgfUsersOtpDetails(dgfUsersOtpDetails);
	}

	public static DgfUsersOtpDetails
		addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(
			String message, String nationalId, String mobileNo, long userId,
			long userRegNo) {

		return getService().
			addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(
				message, nationalId, mobileNo, userId, userRegNo);
	}

	public static DgfUsersOtpDetails addDgfUsersOtpDetailsByNidAndMobileAndUser(
		String nationalId, String mobileNo, long userId) {

		return getService().addDgfUsersOtpDetailsByNidAndMobileAndUser(
			nationalId, mobileNo, userId);
	}

	public static boolean callSmsMessageApi(String message, String mobileNo) {
		return getService().callSmsMessageApi(message, mobileNo);
	}

	public static boolean callSmsMessageApiByOtpId(long otpId) {
		return getService().callSmsMessageApiByOtpId(otpId);
	}

	/**
	 * Creates a new dgf users otp details with the primary key. Does not add the dgf users otp details to the database.
	 *
	 * @param otpId the primary key for the new dgf users otp details
	 * @return the new dgf users otp details
	 */
	public static DgfUsersOtpDetails createDgfUsersOtpDetails(long otpId) {
		return getService().createDgfUsersOtpDetails(otpId);
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
	 * Deletes the dgf users otp details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersOtpDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsersOtpDetails the dgf users otp details
	 * @return the dgf users otp details that was removed
	 */
	public static DgfUsersOtpDetails deleteDgfUsersOtpDetails(
		DgfUsersOtpDetails dgfUsersOtpDetails) {

		return getService().deleteDgfUsersOtpDetails(dgfUsersOtpDetails);
	}

	/**
	 * Deletes the dgf users otp details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersOtpDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param otpId the primary key of the dgf users otp details
	 * @return the dgf users otp details that was removed
	 * @throws PortalException if a dgf users otp details with the primary key could not be found
	 */
	public static DgfUsersOtpDetails deleteDgfUsersOtpDetails(long otpId)
		throws PortalException {

		return getService().deleteDgfUsersOtpDetails(otpId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersOtpDetailsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersOtpDetailsModelImpl</code>.
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

	public static DgfUsersOtpDetails fetchDgfUsersOtpDetails(long otpId) {
		return getService().fetchDgfUsersOtpDetails(otpId);
	}

	public static List<DgfUsersOtpDetails> findByIsSent(boolean isSent) {
		return getService().findByIsSent(isSent);
	}

	public static List<DgfUsersOtpDetails> findOtpDetailsByMobileNo(
		String mobileNo) {

		return getService().findOtpDetailsByMobileNo(mobileNo);
	}

	public static long genarateOtp() {
		return getService().genarateOtp();
	}

	public static String generateOtpMessage() {
		return getService().generateOtpMessage();
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the dgf users otp details with the primary key.
	 *
	 * @param otpId the primary key of the dgf users otp details
	 * @return the dgf users otp details
	 * @throws PortalException if a dgf users otp details with the primary key could not be found
	 */
	public static DgfUsersOtpDetails getDgfUsersOtpDetails(long otpId)
		throws PortalException {

		return getService().getDgfUsersOtpDetails(otpId);
	}

	/**
	 * Returns a range of all the dgf users otp detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bd.gov.dgfood.food.grain.license.model.impl.DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @return the range of dgf users otp detailses
	 */
	public static List<DgfUsersOtpDetails> getDgfUsersOtpDetailses(
		int start, int end) {

		return getService().getDgfUsersOtpDetailses(start, end);
	}

	/**
	 * Returns the number of dgf users otp detailses.
	 *
	 * @return the number of dgf users otp detailses
	 */
	public static int getDgfUsersOtpDetailsesCount() {
		return getService().getDgfUsersOtpDetailsesCount();
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
	 * Updates the dgf users otp details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DgfUsersOtpDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dgfUsersOtpDetails the dgf users otp details
	 * @return the dgf users otp details that was updated
	 */
	public static DgfUsersOtpDetails updateDgfUsersOtpDetails(
		DgfUsersOtpDetails dgfUsersOtpDetails) {

		return getService().updateDgfUsersOtpDetails(dgfUsersOtpDetails);
	}

	public static DgfUsersOtpDetails
			verifyDgfUsersOtpDetailsByOtpAndOtpIdAndMobile(
				long otpId, long otp, String mobileNo)
		throws PortalException {

		return getService().verifyDgfUsersOtpDetailsByOtpAndOtpIdAndMobile(
			otpId, otp, mobileNo);
	}

	public static DgfUsersOtpDetailsLocalService getService() {
		return _service;
	}

	private static volatile DgfUsersOtpDetailsLocalService _service;

}