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

package bd.gov.dgfood.food.grain.license.service.persistence;

import bd.gov.dgfood.food.grain.license.model.DgfUsersOtpDetails;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dgf users otp details service. This utility wraps <code>bd.gov.dgfood.food.grain.license.service.persistence.impl.DgfUsersOtpDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersOtpDetailsPersistence
 * @generated
 */
public class DgfUsersOtpDetailsUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(DgfUsersOtpDetails dgfUsersOtpDetails) {
		getPersistence().clearCache(dgfUsersOtpDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, DgfUsersOtpDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DgfUsersOtpDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DgfUsersOtpDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DgfUsersOtpDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DgfUsersOtpDetails update(
		DgfUsersOtpDetails dgfUsersOtpDetails) {

		return getPersistence().update(dgfUsersOtpDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DgfUsersOtpDetails update(
		DgfUsersOtpDetails dgfUsersOtpDetails, ServiceContext serviceContext) {

		return getPersistence().update(dgfUsersOtpDetails, serviceContext);
	}

	/**
	 * Returns all the dgf users otp detailses where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @return the matching dgf users otp detailses
	 */
	public static List<DgfUsersOtpDetails> findBymobileNumberFinder(
		String mobileNo) {

		return getPersistence().findBymobileNumberFinder(mobileNo);
	}

	/**
	 * Returns a range of all the dgf users otp detailses where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @return the range of matching dgf users otp detailses
	 */
	public static List<DgfUsersOtpDetails> findBymobileNumberFinder(
		String mobileNo, int start, int end) {

		return getPersistence().findBymobileNumberFinder(mobileNo, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf users otp detailses where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users otp detailses
	 */
	public static List<DgfUsersOtpDetails> findBymobileNumberFinder(
		String mobileNo, int start, int end,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator) {

		return getPersistence().findBymobileNumberFinder(
			mobileNo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf users otp detailses where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users otp detailses
	 */
	public static List<DgfUsersOtpDetails> findBymobileNumberFinder(
		String mobileNo, int start, int end,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBymobileNumberFinder(
			mobileNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf users otp details in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a matching dgf users otp details could not be found
	 */
	public static DgfUsersOtpDetails findBymobileNumberFinder_First(
			String mobileNo,
			OrderByComparator<DgfUsersOtpDetails> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersOtpDetailsException {

		return getPersistence().findBymobileNumberFinder_First(
			mobileNo, orderByComparator);
	}

	/**
	 * Returns the first dgf users otp details in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users otp details, or <code>null</code> if a matching dgf users otp details could not be found
	 */
	public static DgfUsersOtpDetails fetchBymobileNumberFinder_First(
		String mobileNo,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator) {

		return getPersistence().fetchBymobileNumberFinder_First(
			mobileNo, orderByComparator);
	}

	/**
	 * Returns the last dgf users otp details in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a matching dgf users otp details could not be found
	 */
	public static DgfUsersOtpDetails findBymobileNumberFinder_Last(
			String mobileNo,
			OrderByComparator<DgfUsersOtpDetails> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersOtpDetailsException {

		return getPersistence().findBymobileNumberFinder_Last(
			mobileNo, orderByComparator);
	}

	/**
	 * Returns the last dgf users otp details in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users otp details, or <code>null</code> if a matching dgf users otp details could not be found
	 */
	public static DgfUsersOtpDetails fetchBymobileNumberFinder_Last(
		String mobileNo,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator) {

		return getPersistence().fetchBymobileNumberFinder_Last(
			mobileNo, orderByComparator);
	}

	/**
	 * Returns the dgf users otp detailses before and after the current dgf users otp details in the ordered set where mobileNo = &#63;.
	 *
	 * @param otpId the primary key of the current dgf users otp details
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a dgf users otp details with the primary key could not be found
	 */
	public static DgfUsersOtpDetails[] findBymobileNumberFinder_PrevAndNext(
			long otpId, String mobileNo,
			OrderByComparator<DgfUsersOtpDetails> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersOtpDetailsException {

		return getPersistence().findBymobileNumberFinder_PrevAndNext(
			otpId, mobileNo, orderByComparator);
	}

	/**
	 * Removes all the dgf users otp detailses where mobileNo = &#63; from the database.
	 *
	 * @param mobileNo the mobile no
	 */
	public static void removeBymobileNumberFinder(String mobileNo) {
		getPersistence().removeBymobileNumberFinder(mobileNo);
	}

	/**
	 * Returns the number of dgf users otp detailses where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @return the number of matching dgf users otp detailses
	 */
	public static int countBymobileNumberFinder(String mobileNo) {
		return getPersistence().countBymobileNumberFinder(mobileNo);
	}

	/**
	 * Returns all the dgf users otp detailses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf users otp detailses
	 */
	public static List<DgfUsersOtpDetails> findBynationalIdfinder(
		String nationalId) {

		return getPersistence().findBynationalIdfinder(nationalId);
	}

	/**
	 * Returns a range of all the dgf users otp detailses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @return the range of matching dgf users otp detailses
	 */
	public static List<DgfUsersOtpDetails> findBynationalIdfinder(
		String nationalId, int start, int end) {

		return getPersistence().findBynationalIdfinder(nationalId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf users otp detailses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users otp detailses
	 */
	public static List<DgfUsersOtpDetails> findBynationalIdfinder(
		String nationalId, int start, int end,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator) {

		return getPersistence().findBynationalIdfinder(
			nationalId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf users otp detailses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users otp detailses
	 */
	public static List<DgfUsersOtpDetails> findBynationalIdfinder(
		String nationalId, int start, int end,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBynationalIdfinder(
			nationalId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf users otp details in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a matching dgf users otp details could not be found
	 */
	public static DgfUsersOtpDetails findBynationalIdfinder_First(
			String nationalId,
			OrderByComparator<DgfUsersOtpDetails> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersOtpDetailsException {

		return getPersistence().findBynationalIdfinder_First(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the first dgf users otp details in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users otp details, or <code>null</code> if a matching dgf users otp details could not be found
	 */
	public static DgfUsersOtpDetails fetchBynationalIdfinder_First(
		String nationalId,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator) {

		return getPersistence().fetchBynationalIdfinder_First(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the last dgf users otp details in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a matching dgf users otp details could not be found
	 */
	public static DgfUsersOtpDetails findBynationalIdfinder_Last(
			String nationalId,
			OrderByComparator<DgfUsersOtpDetails> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersOtpDetailsException {

		return getPersistence().findBynationalIdfinder_Last(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the last dgf users otp details in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users otp details, or <code>null</code> if a matching dgf users otp details could not be found
	 */
	public static DgfUsersOtpDetails fetchBynationalIdfinder_Last(
		String nationalId,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator) {

		return getPersistence().fetchBynationalIdfinder_Last(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the dgf users otp detailses before and after the current dgf users otp details in the ordered set where nationalId = &#63;.
	 *
	 * @param otpId the primary key of the current dgf users otp details
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a dgf users otp details with the primary key could not be found
	 */
	public static DgfUsersOtpDetails[] findBynationalIdfinder_PrevAndNext(
			long otpId, String nationalId,
			OrderByComparator<DgfUsersOtpDetails> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersOtpDetailsException {

		return getPersistence().findBynationalIdfinder_PrevAndNext(
			otpId, nationalId, orderByComparator);
	}

	/**
	 * Removes all the dgf users otp detailses where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	public static void removeBynationalIdfinder(String nationalId) {
		getPersistence().removeBynationalIdfinder(nationalId);
	}

	/**
	 * Returns the number of dgf users otp detailses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf users otp detailses
	 */
	public static int countBynationalIdfinder(String nationalId) {
		return getPersistence().countBynationalIdfinder(nationalId);
	}

	/**
	 * Returns all the dgf users otp detailses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching dgf users otp detailses
	 */
	public static List<DgfUsersOtpDetails> findByuserIdFinder(long userId) {
		return getPersistence().findByuserIdFinder(userId);
	}

	/**
	 * Returns a range of all the dgf users otp detailses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @return the range of matching dgf users otp detailses
	 */
	public static List<DgfUsersOtpDetails> findByuserIdFinder(
		long userId, int start, int end) {

		return getPersistence().findByuserIdFinder(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf users otp detailses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users otp detailses
	 */
	public static List<DgfUsersOtpDetails> findByuserIdFinder(
		long userId, int start, int end,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator) {

		return getPersistence().findByuserIdFinder(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf users otp detailses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users otp detailses
	 */
	public static List<DgfUsersOtpDetails> findByuserIdFinder(
		long userId, int start, int end,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByuserIdFinder(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf users otp details in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a matching dgf users otp details could not be found
	 */
	public static DgfUsersOtpDetails findByuserIdFinder_First(
			long userId,
			OrderByComparator<DgfUsersOtpDetails> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersOtpDetailsException {

		return getPersistence().findByuserIdFinder_First(
			userId, orderByComparator);
	}

	/**
	 * Returns the first dgf users otp details in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users otp details, or <code>null</code> if a matching dgf users otp details could not be found
	 */
	public static DgfUsersOtpDetails fetchByuserIdFinder_First(
		long userId, OrderByComparator<DgfUsersOtpDetails> orderByComparator) {

		return getPersistence().fetchByuserIdFinder_First(
			userId, orderByComparator);
	}

	/**
	 * Returns the last dgf users otp details in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a matching dgf users otp details could not be found
	 */
	public static DgfUsersOtpDetails findByuserIdFinder_Last(
			long userId,
			OrderByComparator<DgfUsersOtpDetails> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersOtpDetailsException {

		return getPersistence().findByuserIdFinder_Last(
			userId, orderByComparator);
	}

	/**
	 * Returns the last dgf users otp details in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users otp details, or <code>null</code> if a matching dgf users otp details could not be found
	 */
	public static DgfUsersOtpDetails fetchByuserIdFinder_Last(
		long userId, OrderByComparator<DgfUsersOtpDetails> orderByComparator) {

		return getPersistence().fetchByuserIdFinder_Last(
			userId, orderByComparator);
	}

	/**
	 * Returns the dgf users otp detailses before and after the current dgf users otp details in the ordered set where userId = &#63;.
	 *
	 * @param otpId the primary key of the current dgf users otp details
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a dgf users otp details with the primary key could not be found
	 */
	public static DgfUsersOtpDetails[] findByuserIdFinder_PrevAndNext(
			long otpId, long userId,
			OrderByComparator<DgfUsersOtpDetails> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersOtpDetailsException {

		return getPersistence().findByuserIdFinder_PrevAndNext(
			otpId, userId, orderByComparator);
	}

	/**
	 * Removes all the dgf users otp detailses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByuserIdFinder(long userId) {
		getPersistence().removeByuserIdFinder(userId);
	}

	/**
	 * Returns the number of dgf users otp detailses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching dgf users otp detailses
	 */
	public static int countByuserIdFinder(long userId) {
		return getPersistence().countByuserIdFinder(userId);
	}

	/**
	 * Returns all the dgf users otp detailses where isSent = &#63;.
	 *
	 * @param isSent the is sent
	 * @return the matching dgf users otp detailses
	 */
	public static List<DgfUsersOtpDetails> findByisSent(boolean isSent) {
		return getPersistence().findByisSent(isSent);
	}

	/**
	 * Returns a range of all the dgf users otp detailses where isSent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param isSent the is sent
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @return the range of matching dgf users otp detailses
	 */
	public static List<DgfUsersOtpDetails> findByisSent(
		boolean isSent, int start, int end) {

		return getPersistence().findByisSent(isSent, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf users otp detailses where isSent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param isSent the is sent
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users otp detailses
	 */
	public static List<DgfUsersOtpDetails> findByisSent(
		boolean isSent, int start, int end,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator) {

		return getPersistence().findByisSent(
			isSent, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf users otp detailses where isSent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param isSent the is sent
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users otp detailses
	 */
	public static List<DgfUsersOtpDetails> findByisSent(
		boolean isSent, int start, int end,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByisSent(
			isSent, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf users otp details in the ordered set where isSent = &#63;.
	 *
	 * @param isSent the is sent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a matching dgf users otp details could not be found
	 */
	public static DgfUsersOtpDetails findByisSent_First(
			boolean isSent,
			OrderByComparator<DgfUsersOtpDetails> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersOtpDetailsException {

		return getPersistence().findByisSent_First(isSent, orderByComparator);
	}

	/**
	 * Returns the first dgf users otp details in the ordered set where isSent = &#63;.
	 *
	 * @param isSent the is sent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users otp details, or <code>null</code> if a matching dgf users otp details could not be found
	 */
	public static DgfUsersOtpDetails fetchByisSent_First(
		boolean isSent,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator) {

		return getPersistence().fetchByisSent_First(isSent, orderByComparator);
	}

	/**
	 * Returns the last dgf users otp details in the ordered set where isSent = &#63;.
	 *
	 * @param isSent the is sent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a matching dgf users otp details could not be found
	 */
	public static DgfUsersOtpDetails findByisSent_Last(
			boolean isSent,
			OrderByComparator<DgfUsersOtpDetails> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersOtpDetailsException {

		return getPersistence().findByisSent_Last(isSent, orderByComparator);
	}

	/**
	 * Returns the last dgf users otp details in the ordered set where isSent = &#63;.
	 *
	 * @param isSent the is sent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users otp details, or <code>null</code> if a matching dgf users otp details could not be found
	 */
	public static DgfUsersOtpDetails fetchByisSent_Last(
		boolean isSent,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator) {

		return getPersistence().fetchByisSent_Last(isSent, orderByComparator);
	}

	/**
	 * Returns the dgf users otp detailses before and after the current dgf users otp details in the ordered set where isSent = &#63;.
	 *
	 * @param otpId the primary key of the current dgf users otp details
	 * @param isSent the is sent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a dgf users otp details with the primary key could not be found
	 */
	public static DgfUsersOtpDetails[] findByisSent_PrevAndNext(
			long otpId, boolean isSent,
			OrderByComparator<DgfUsersOtpDetails> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersOtpDetailsException {

		return getPersistence().findByisSent_PrevAndNext(
			otpId, isSent, orderByComparator);
	}

	/**
	 * Removes all the dgf users otp detailses where isSent = &#63; from the database.
	 *
	 * @param isSent the is sent
	 */
	public static void removeByisSent(boolean isSent) {
		getPersistence().removeByisSent(isSent);
	}

	/**
	 * Returns the number of dgf users otp detailses where isSent = &#63;.
	 *
	 * @param isSent the is sent
	 * @return the number of matching dgf users otp detailses
	 */
	public static int countByisSent(boolean isSent) {
		return getPersistence().countByisSent(isSent);
	}

	/**
	 * Returns the dgf users otp details where mobileNo = &#63; and otp = &#63; and isSent = &#63; or throws a <code>NoSuchDgfUsersOtpDetailsException</code> if it could not be found.
	 *
	 * @param mobileNo the mobile no
	 * @param otp the otp
	 * @param isSent the is sent
	 * @return the matching dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a matching dgf users otp details could not be found
	 */
	public static DgfUsersOtpDetails findByotpDetailsByMobileAndOtp(
			String mobileNo, long otp, boolean isSent)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersOtpDetailsException {

		return getPersistence().findByotpDetailsByMobileAndOtp(
			mobileNo, otp, isSent);
	}

	/**
	 * Returns the dgf users otp details where mobileNo = &#63; and otp = &#63; and isSent = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param mobileNo the mobile no
	 * @param otp the otp
	 * @param isSent the is sent
	 * @return the matching dgf users otp details, or <code>null</code> if a matching dgf users otp details could not be found
	 */
	public static DgfUsersOtpDetails fetchByotpDetailsByMobileAndOtp(
		String mobileNo, long otp, boolean isSent) {

		return getPersistence().fetchByotpDetailsByMobileAndOtp(
			mobileNo, otp, isSent);
	}

	/**
	 * Returns the dgf users otp details where mobileNo = &#63; and otp = &#63; and isSent = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param mobileNo the mobile no
	 * @param otp the otp
	 * @param isSent the is sent
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf users otp details, or <code>null</code> if a matching dgf users otp details could not be found
	 */
	public static DgfUsersOtpDetails fetchByotpDetailsByMobileAndOtp(
		String mobileNo, long otp, boolean isSent, boolean useFinderCache) {

		return getPersistence().fetchByotpDetailsByMobileAndOtp(
			mobileNo, otp, isSent, useFinderCache);
	}

	/**
	 * Removes the dgf users otp details where mobileNo = &#63; and otp = &#63; and isSent = &#63; from the database.
	 *
	 * @param mobileNo the mobile no
	 * @param otp the otp
	 * @param isSent the is sent
	 * @return the dgf users otp details that was removed
	 */
	public static DgfUsersOtpDetails removeByotpDetailsByMobileAndOtp(
			String mobileNo, long otp, boolean isSent)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersOtpDetailsException {

		return getPersistence().removeByotpDetailsByMobileAndOtp(
			mobileNo, otp, isSent);
	}

	/**
	 * Returns the number of dgf users otp detailses where mobileNo = &#63; and otp = &#63; and isSent = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param otp the otp
	 * @param isSent the is sent
	 * @return the number of matching dgf users otp detailses
	 */
	public static int countByotpDetailsByMobileAndOtp(
		String mobileNo, long otp, boolean isSent) {

		return getPersistence().countByotpDetailsByMobileAndOtp(
			mobileNo, otp, isSent);
	}

	/**
	 * Caches the dgf users otp details in the entity cache if it is enabled.
	 *
	 * @param dgfUsersOtpDetails the dgf users otp details
	 */
	public static void cacheResult(DgfUsersOtpDetails dgfUsersOtpDetails) {
		getPersistence().cacheResult(dgfUsersOtpDetails);
	}

	/**
	 * Caches the dgf users otp detailses in the entity cache if it is enabled.
	 *
	 * @param dgfUsersOtpDetailses the dgf users otp detailses
	 */
	public static void cacheResult(
		List<DgfUsersOtpDetails> dgfUsersOtpDetailses) {

		getPersistence().cacheResult(dgfUsersOtpDetailses);
	}

	/**
	 * Creates a new dgf users otp details with the primary key. Does not add the dgf users otp details to the database.
	 *
	 * @param otpId the primary key for the new dgf users otp details
	 * @return the new dgf users otp details
	 */
	public static DgfUsersOtpDetails create(long otpId) {
		return getPersistence().create(otpId);
	}

	/**
	 * Removes the dgf users otp details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param otpId the primary key of the dgf users otp details
	 * @return the dgf users otp details that was removed
	 * @throws NoSuchDgfUsersOtpDetailsException if a dgf users otp details with the primary key could not be found
	 */
	public static DgfUsersOtpDetails remove(long otpId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersOtpDetailsException {

		return getPersistence().remove(otpId);
	}

	public static DgfUsersOtpDetails updateImpl(
		DgfUsersOtpDetails dgfUsersOtpDetails) {

		return getPersistence().updateImpl(dgfUsersOtpDetails);
	}

	/**
	 * Returns the dgf users otp details with the primary key or throws a <code>NoSuchDgfUsersOtpDetailsException</code> if it could not be found.
	 *
	 * @param otpId the primary key of the dgf users otp details
	 * @return the dgf users otp details
	 * @throws NoSuchDgfUsersOtpDetailsException if a dgf users otp details with the primary key could not be found
	 */
	public static DgfUsersOtpDetails findByPrimaryKey(long otpId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersOtpDetailsException {

		return getPersistence().findByPrimaryKey(otpId);
	}

	/**
	 * Returns the dgf users otp details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param otpId the primary key of the dgf users otp details
	 * @return the dgf users otp details, or <code>null</code> if a dgf users otp details with the primary key could not be found
	 */
	public static DgfUsersOtpDetails fetchByPrimaryKey(long otpId) {
		return getPersistence().fetchByPrimaryKey(otpId);
	}

	/**
	 * Returns all the dgf users otp detailses.
	 *
	 * @return the dgf users otp detailses
	 */
	public static List<DgfUsersOtpDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dgf users otp detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @return the range of dgf users otp detailses
	 */
	public static List<DgfUsersOtpDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dgf users otp detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf users otp detailses
	 */
	public static List<DgfUsersOtpDetails> findAll(
		int start, int end,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf users otp detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersOtpDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users otp detailses
	 * @param end the upper bound of the range of dgf users otp detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf users otp detailses
	 */
	public static List<DgfUsersOtpDetails> findAll(
		int start, int end,
		OrderByComparator<DgfUsersOtpDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dgf users otp detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dgf users otp detailses.
	 *
	 * @return the number of dgf users otp detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DgfUsersOtpDetailsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DgfUsersOtpDetailsPersistence _persistence;

}