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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DgfUsersOtpDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersOtpDetailsLocalService
 * @generated
 */
public class DgfUsersOtpDetailsLocalServiceWrapper
	implements DgfUsersOtpDetailsLocalService,
			   ServiceWrapper<DgfUsersOtpDetailsLocalService> {

	public DgfUsersOtpDetailsLocalServiceWrapper() {
		this(null);
	}

	public DgfUsersOtpDetailsLocalServiceWrapper(
		DgfUsersOtpDetailsLocalService dgfUsersOtpDetailsLocalService) {

		_dgfUsersOtpDetailsLocalService = dgfUsersOtpDetailsLocalService;
	}

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
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetails
		addDgfUsersOtpDetails(
			bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetails
				dgfUsersOtpDetails) {

		return _dgfUsersOtpDetailsLocalService.addDgfUsersOtpDetails(
			dgfUsersOtpDetails);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetails
		addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(
			String message, String nationalId, String mobileNo, long userId,
			long userRegNo) {

		return _dgfUsersOtpDetailsLocalService.
			addDgfUsersOtpDetailsByMessageAndNidAndMobileAndUserAndUserRegNo(
				message, nationalId, mobileNo, userId, userRegNo);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetails
		addDgfUsersOtpDetailsByNidAndMobileAndUser(
			String nationalId, String mobileNo, long userId) {

		return _dgfUsersOtpDetailsLocalService.
			addDgfUsersOtpDetailsByNidAndMobileAndUser(
				nationalId, mobileNo, userId);
	}

	@Override
	public boolean callSmsMessageApi(String message, String mobileNo) {
		return _dgfUsersOtpDetailsLocalService.callSmsMessageApi(
			message, mobileNo);
	}

	@Override
	public boolean callSmsMessageApiByOtpId(long otpId) {
		return _dgfUsersOtpDetailsLocalService.callSmsMessageApiByOtpId(otpId);
	}

	/**
	 * Creates a new dgf users otp details with the primary key. Does not add the dgf users otp details to the database.
	 *
	 * @param otpId the primary key for the new dgf users otp details
	 * @return the new dgf users otp details
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetails
		createDgfUsersOtpDetails(long otpId) {

		return _dgfUsersOtpDetailsLocalService.createDgfUsersOtpDetails(otpId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersOtpDetailsLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetails
		deleteDgfUsersOtpDetails(
			bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetails
				dgfUsersOtpDetails) {

		return _dgfUsersOtpDetailsLocalService.deleteDgfUsersOtpDetails(
			dgfUsersOtpDetails);
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
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetails
			deleteDgfUsersOtpDetails(long otpId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersOtpDetailsLocalService.deleteDgfUsersOtpDetails(otpId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersOtpDetailsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _dgfUsersOtpDetailsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _dgfUsersOtpDetailsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dgfUsersOtpDetailsLocalService.dynamicQuery();
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

		return _dgfUsersOtpDetailsLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _dgfUsersOtpDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _dgfUsersOtpDetailsLocalService.dynamicQuery(
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

		return _dgfUsersOtpDetailsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dgfUsersOtpDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetails
		fetchDgfUsersOtpDetails(long otpId) {

		return _dgfUsersOtpDetailsLocalService.fetchDgfUsersOtpDetails(otpId);
	}

	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetails>
			findByIsSent(boolean isSent) {

		return _dgfUsersOtpDetailsLocalService.findByIsSent(isSent);
	}

	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetails>
			findOtpDetailsByMobileNo(String mobileNo) {

		return _dgfUsersOtpDetailsLocalService.findOtpDetailsByMobileNo(
			mobileNo);
	}

	@Override
	public long genarateOtp() {
		return _dgfUsersOtpDetailsLocalService.genarateOtp();
	}

	@Override
	public String generateOtpMessage() {
		return _dgfUsersOtpDetailsLocalService.generateOtpMessage();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dgfUsersOtpDetailsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the dgf users otp details with the primary key.
	 *
	 * @param otpId the primary key of the dgf users otp details
	 * @return the dgf users otp details
	 * @throws PortalException if a dgf users otp details with the primary key could not be found
	 */
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetails
			getDgfUsersOtpDetails(long otpId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersOtpDetailsLocalService.getDgfUsersOtpDetails(otpId);
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
	@Override
	public java.util.List
		<bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetails>
			getDgfUsersOtpDetailses(int start, int end) {

		return _dgfUsersOtpDetailsLocalService.getDgfUsersOtpDetailses(
			start, end);
	}

	/**
	 * Returns the number of dgf users otp detailses.
	 *
	 * @return the number of dgf users otp detailses
	 */
	@Override
	public int getDgfUsersOtpDetailsesCount() {
		return _dgfUsersOtpDetailsLocalService.getDgfUsersOtpDetailsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dgfUsersOtpDetailsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dgfUsersOtpDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersOtpDetailsLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetails
		updateDgfUsersOtpDetails(
			bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetails
				dgfUsersOtpDetails) {

		return _dgfUsersOtpDetailsLocalService.updateDgfUsersOtpDetails(
			dgfUsersOtpDetails);
	}

	@Override
	public bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetails
			verifyDgfUsersOtpDetailsByOtpAndOtpIdAndMobile(
				long otpId, long otp, String mobileNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dgfUsersOtpDetailsLocalService.
			verifyDgfUsersOtpDetailsByOtpAndOtpIdAndMobile(
				otpId, otp, mobileNo);
	}

	@Override
	public DgfUsersOtpDetailsLocalService getWrappedService() {
		return _dgfUsersOtpDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		DgfUsersOtpDetailsLocalService dgfUsersOtpDetailsLocalService) {

		_dgfUsersOtpDetailsLocalService = dgfUsersOtpDetailsLocalService;
	}

	private DgfUsersOtpDetailsLocalService _dgfUsersOtpDetailsLocalService;

}