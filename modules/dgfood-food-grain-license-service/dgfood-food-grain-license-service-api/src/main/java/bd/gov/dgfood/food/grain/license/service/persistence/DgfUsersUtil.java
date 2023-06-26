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

import bd.gov.dgfood.food.grain.license.model.DgfUsers;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dgf users service. This utility wraps <code>bd.gov.dgfood.food.grain.license.service.persistence.impl.DgfUsersPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersPersistence
 * @generated
 */
public class DgfUsersUtil {

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
	public static void clearCache(DgfUsers dgfUsers) {
		getPersistence().clearCache(dgfUsers);
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
	public static Map<Serializable, DgfUsers> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DgfUsers> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DgfUsers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DgfUsers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DgfUsers> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DgfUsers update(DgfUsers dgfUsers) {
		return getPersistence().update(dgfUsers);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DgfUsers update(
		DgfUsers dgfUsers, ServiceContext serviceContext) {

		return getPersistence().update(dgfUsers, serviceContext);
	}

	/**
	 * Returns all the dgf userses where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @return the matching dgf userses
	 */
	public static List<DgfUsers> findBymobileNumberFinder(String mobileNo) {
		return getPersistence().findBymobileNumberFinder(mobileNo);
	}

	/**
	 * Returns a range of all the dgf userses where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @return the range of matching dgf userses
	 */
	public static List<DgfUsers> findBymobileNumberFinder(
		String mobileNo, int start, int end) {

		return getPersistence().findBymobileNumberFinder(mobileNo, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf userses where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf userses
	 */
	public static List<DgfUsers> findBymobileNumberFinder(
		String mobileNo, int start, int end,
		OrderByComparator<DgfUsers> orderByComparator) {

		return getPersistence().findBymobileNumberFinder(
			mobileNo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf userses where mobileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersModelImpl</code>.
	 * </p>
	 *
	 * @param mobileNo the mobile no
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf userses
	 */
	public static List<DgfUsers> findBymobileNumberFinder(
		String mobileNo, int start, int end,
		OrderByComparator<DgfUsers> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBymobileNumberFinder(
			mobileNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf users in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users
	 * @throws NoSuchDgfUsersException if a matching dgf users could not be found
	 */
	public static DgfUsers findBymobileNumberFinder_First(
			String mobileNo, OrderByComparator<DgfUsers> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersException {

		return getPersistence().findBymobileNumberFinder_First(
			mobileNo, orderByComparator);
	}

	/**
	 * Returns the first dgf users in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users, or <code>null</code> if a matching dgf users could not be found
	 */
	public static DgfUsers fetchBymobileNumberFinder_First(
		String mobileNo, OrderByComparator<DgfUsers> orderByComparator) {

		return getPersistence().fetchBymobileNumberFinder_First(
			mobileNo, orderByComparator);
	}

	/**
	 * Returns the last dgf users in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users
	 * @throws NoSuchDgfUsersException if a matching dgf users could not be found
	 */
	public static DgfUsers findBymobileNumberFinder_Last(
			String mobileNo, OrderByComparator<DgfUsers> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersException {

		return getPersistence().findBymobileNumberFinder_Last(
			mobileNo, orderByComparator);
	}

	/**
	 * Returns the last dgf users in the ordered set where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users, or <code>null</code> if a matching dgf users could not be found
	 */
	public static DgfUsers fetchBymobileNumberFinder_Last(
		String mobileNo, OrderByComparator<DgfUsers> orderByComparator) {

		return getPersistence().fetchBymobileNumberFinder_Last(
			mobileNo, orderByComparator);
	}

	/**
	 * Returns the dgf userses before and after the current dgf users in the ordered set where mobileNo = &#63;.
	 *
	 * @param userId the primary key of the current dgf users
	 * @param mobileNo the mobile no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users
	 * @throws NoSuchDgfUsersException if a dgf users with the primary key could not be found
	 */
	public static DgfUsers[] findBymobileNumberFinder_PrevAndNext(
			long userId, String mobileNo,
			OrderByComparator<DgfUsers> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersException {

		return getPersistence().findBymobileNumberFinder_PrevAndNext(
			userId, mobileNo, orderByComparator);
	}

	/**
	 * Removes all the dgf userses where mobileNo = &#63; from the database.
	 *
	 * @param mobileNo the mobile no
	 */
	public static void removeBymobileNumberFinder(String mobileNo) {
		getPersistence().removeBymobileNumberFinder(mobileNo);
	}

	/**
	 * Returns the number of dgf userses where mobileNo = &#63;.
	 *
	 * @param mobileNo the mobile no
	 * @return the number of matching dgf userses
	 */
	public static int countBymobileNumberFinder(String mobileNo) {
		return getPersistence().countBymobileNumberFinder(mobileNo);
	}

	/**
	 * Returns all the dgf userses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf userses
	 */
	public static List<DgfUsers> findBynationalIdfinder(String nationalId) {
		return getPersistence().findBynationalIdfinder(nationalId);
	}

	/**
	 * Returns a range of all the dgf userses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @return the range of matching dgf userses
	 */
	public static List<DgfUsers> findBynationalIdfinder(
		String nationalId, int start, int end) {

		return getPersistence().findBynationalIdfinder(nationalId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf userses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf userses
	 */
	public static List<DgfUsers> findBynationalIdfinder(
		String nationalId, int start, int end,
		OrderByComparator<DgfUsers> orderByComparator) {

		return getPersistence().findBynationalIdfinder(
			nationalId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf userses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf userses
	 */
	public static List<DgfUsers> findBynationalIdfinder(
		String nationalId, int start, int end,
		OrderByComparator<DgfUsers> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBynationalIdfinder(
			nationalId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf users in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users
	 * @throws NoSuchDgfUsersException if a matching dgf users could not be found
	 */
	public static DgfUsers findBynationalIdfinder_First(
			String nationalId, OrderByComparator<DgfUsers> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersException {

		return getPersistence().findBynationalIdfinder_First(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the first dgf users in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users, or <code>null</code> if a matching dgf users could not be found
	 */
	public static DgfUsers fetchBynationalIdfinder_First(
		String nationalId, OrderByComparator<DgfUsers> orderByComparator) {

		return getPersistence().fetchBynationalIdfinder_First(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the last dgf users in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users
	 * @throws NoSuchDgfUsersException if a matching dgf users could not be found
	 */
	public static DgfUsers findBynationalIdfinder_Last(
			String nationalId, OrderByComparator<DgfUsers> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersException {

		return getPersistence().findBynationalIdfinder_Last(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the last dgf users in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users, or <code>null</code> if a matching dgf users could not be found
	 */
	public static DgfUsers fetchBynationalIdfinder_Last(
		String nationalId, OrderByComparator<DgfUsers> orderByComparator) {

		return getPersistence().fetchBynationalIdfinder_Last(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the dgf userses before and after the current dgf users in the ordered set where nationalId = &#63;.
	 *
	 * @param userId the primary key of the current dgf users
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users
	 * @throws NoSuchDgfUsersException if a dgf users with the primary key could not be found
	 */
	public static DgfUsers[] findBynationalIdfinder_PrevAndNext(
			long userId, String nationalId,
			OrderByComparator<DgfUsers> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersException {

		return getPersistence().findBynationalIdfinder_PrevAndNext(
			userId, nationalId, orderByComparator);
	}

	/**
	 * Removes all the dgf userses where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	public static void removeBynationalIdfinder(String nationalId) {
		getPersistence().removeBynationalIdfinder(nationalId);
	}

	/**
	 * Returns the number of dgf userses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf userses
	 */
	public static int countBynationalIdfinder(String nationalId) {
		return getPersistence().countBynationalIdfinder(nationalId);
	}

	/**
	 * Returns the dgf users where userId = &#63; or throws a <code>NoSuchDgfUsersException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching dgf users
	 * @throws NoSuchDgfUsersException if a matching dgf users could not be found
	 */
	public static DgfUsers findByuserIdFinder(long userId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersException {

		return getPersistence().findByuserIdFinder(userId);
	}

	/**
	 * Returns the dgf users where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching dgf users, or <code>null</code> if a matching dgf users could not be found
	 */
	public static DgfUsers fetchByuserIdFinder(long userId) {
		return getPersistence().fetchByuserIdFinder(userId);
	}

	/**
	 * Returns the dgf users where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf users, or <code>null</code> if a matching dgf users could not be found
	 */
	public static DgfUsers fetchByuserIdFinder(
		long userId, boolean useFinderCache) {

		return getPersistence().fetchByuserIdFinder(userId, useFinderCache);
	}

	/**
	 * Removes the dgf users where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the dgf users that was removed
	 */
	public static DgfUsers removeByuserIdFinder(long userId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersException {

		return getPersistence().removeByuserIdFinder(userId);
	}

	/**
	 * Returns the number of dgf userses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching dgf userses
	 */
	public static int countByuserIdFinder(long userId) {
		return getPersistence().countByuserIdFinder(userId);
	}

	/**
	 * Returns the dgf users where nationalId = &#63; or throws a <code>NoSuchDgfUsersException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf users
	 * @throws NoSuchDgfUsersException if a matching dgf users could not be found
	 */
	public static DgfUsers findByDgfUsersByNationalId(String nationalId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersException {

		return getPersistence().findByDgfUsersByNationalId(nationalId);
	}

	/**
	 * Returns the dgf users where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf users, or <code>null</code> if a matching dgf users could not be found
	 */
	public static DgfUsers fetchByDgfUsersByNationalId(String nationalId) {
		return getPersistence().fetchByDgfUsersByNationalId(nationalId);
	}

	/**
	 * Returns the dgf users where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf users, or <code>null</code> if a matching dgf users could not be found
	 */
	public static DgfUsers fetchByDgfUsersByNationalId(
		String nationalId, boolean useFinderCache) {

		return getPersistence().fetchByDgfUsersByNationalId(
			nationalId, useFinderCache);
	}

	/**
	 * Removes the dgf users where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the dgf users that was removed
	 */
	public static DgfUsers removeByDgfUsersByNationalId(String nationalId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersException {

		return getPersistence().removeByDgfUsersByNationalId(nationalId);
	}

	/**
	 * Returns the number of dgf userses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf userses
	 */
	public static int countByDgfUsersByNationalId(String nationalId) {
		return getPersistence().countByDgfUsersByNationalId(nationalId);
	}

	/**
	 * Caches the dgf users in the entity cache if it is enabled.
	 *
	 * @param dgfUsers the dgf users
	 */
	public static void cacheResult(DgfUsers dgfUsers) {
		getPersistence().cacheResult(dgfUsers);
	}

	/**
	 * Caches the dgf userses in the entity cache if it is enabled.
	 *
	 * @param dgfUserses the dgf userses
	 */
	public static void cacheResult(List<DgfUsers> dgfUserses) {
		getPersistence().cacheResult(dgfUserses);
	}

	/**
	 * Creates a new dgf users with the primary key. Does not add the dgf users to the database.
	 *
	 * @param userId the primary key for the new dgf users
	 * @return the new dgf users
	 */
	public static DgfUsers create(long userId) {
		return getPersistence().create(userId);
	}

	/**
	 * Removes the dgf users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the dgf users
	 * @return the dgf users that was removed
	 * @throws NoSuchDgfUsersException if a dgf users with the primary key could not be found
	 */
	public static DgfUsers remove(long userId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersException {

		return getPersistence().remove(userId);
	}

	public static DgfUsers updateImpl(DgfUsers dgfUsers) {
		return getPersistence().updateImpl(dgfUsers);
	}

	/**
	 * Returns the dgf users with the primary key or throws a <code>NoSuchDgfUsersException</code> if it could not be found.
	 *
	 * @param userId the primary key of the dgf users
	 * @return the dgf users
	 * @throws NoSuchDgfUsersException if a dgf users with the primary key could not be found
	 */
	public static DgfUsers findByPrimaryKey(long userId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersException {

		return getPersistence().findByPrimaryKey(userId);
	}

	/**
	 * Returns the dgf users with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the dgf users
	 * @return the dgf users, or <code>null</code> if a dgf users with the primary key could not be found
	 */
	public static DgfUsers fetchByPrimaryKey(long userId) {
		return getPersistence().fetchByPrimaryKey(userId);
	}

	/**
	 * Returns all the dgf userses.
	 *
	 * @return the dgf userses
	 */
	public static List<DgfUsers> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dgf userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @return the range of dgf userses
	 */
	public static List<DgfUsers> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dgf userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf userses
	 */
	public static List<DgfUsers> findAll(
		int start, int end, OrderByComparator<DgfUsers> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf userses
	 * @param end the upper bound of the range of dgf userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf userses
	 */
	public static List<DgfUsers> findAll(
		int start, int end, OrderByComparator<DgfUsers> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dgf userses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dgf userses.
	 *
	 * @return the number of dgf userses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DgfUsersPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DgfUsersPersistence _persistence;

}