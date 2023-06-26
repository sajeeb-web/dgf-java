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

import bd.gov.dgfood.food.grain.license.model.DgfDuplctLicnsReason;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dgf duplct licns reason service. This utility wraps <code>bd.gov.dgfood.food.grain.license.service.persistence.impl.DgfDuplctLicnsReasonPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfDuplctLicnsReasonPersistence
 * @generated
 */
public class DgfDuplctLicnsReasonUtil {

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
	public static void clearCache(DgfDuplctLicnsReason dgfDuplctLicnsReason) {
		getPersistence().clearCache(dgfDuplctLicnsReason);
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
	public static Map<Serializable, DgfDuplctLicnsReason> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DgfDuplctLicnsReason> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DgfDuplctLicnsReason> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DgfDuplctLicnsReason> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DgfDuplctLicnsReason> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DgfDuplctLicnsReason update(
		DgfDuplctLicnsReason dgfDuplctLicnsReason) {

		return getPersistence().update(dgfDuplctLicnsReason);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DgfDuplctLicnsReason update(
		DgfDuplctLicnsReason dgfDuplctLicnsReason,
		ServiceContext serviceContext) {

		return getPersistence().update(dgfDuplctLicnsReason, serviceContext);
	}

	/**
	 * Returns the dgf duplct licns reason where userId = &#63; or throws a <code>NoSuchDgfDuplctLicnsReasonException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a matching dgf duplct licns reason could not be found
	 */
	public static DgfDuplctLicnsReason findByduplicateLicUserIdFinder(
			long userId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDuplctLicnsReasonException {

		return getPersistence().findByduplicateLicUserIdFinder(userId);
	}

	/**
	 * Returns the dgf duplct licns reason where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	public static DgfDuplctLicnsReason fetchByduplicateLicUserIdFinder(
		long userId) {

		return getPersistence().fetchByduplicateLicUserIdFinder(userId);
	}

	/**
	 * Returns the dgf duplct licns reason where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	public static DgfDuplctLicnsReason fetchByduplicateLicUserIdFinder(
		long userId, boolean useFinderCache) {

		return getPersistence().fetchByduplicateLicUserIdFinder(
			userId, useFinderCache);
	}

	/**
	 * Removes the dgf duplct licns reason where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the dgf duplct licns reason that was removed
	 */
	public static DgfDuplctLicnsReason removeByduplicateLicUserIdFinder(
			long userId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDuplctLicnsReasonException {

		return getPersistence().removeByduplicateLicUserIdFinder(userId);
	}

	/**
	 * Returns the number of dgf duplct licns reasons where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching dgf duplct licns reasons
	 */
	public static int countByduplicateLicUserIdFinder(long userId) {
		return getPersistence().countByduplicateLicUserIdFinder(userId);
	}

	/**
	 * Returns the dgf duplct licns reason where nationalId = &#63; or throws a <code>NoSuchDgfDuplctLicnsReasonException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a matching dgf duplct licns reason could not be found
	 */
	public static DgfDuplctLicnsReason findByduplicateLicNationalIdFinder(
			String nationalId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDuplctLicnsReasonException {

		return getPersistence().findByduplicateLicNationalIdFinder(nationalId);
	}

	/**
	 * Returns the dgf duplct licns reason where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	public static DgfDuplctLicnsReason fetchByduplicateLicNationalIdFinder(
		String nationalId) {

		return getPersistence().fetchByduplicateLicNationalIdFinder(nationalId);
	}

	/**
	 * Returns the dgf duplct licns reason where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	public static DgfDuplctLicnsReason fetchByduplicateLicNationalIdFinder(
		String nationalId, boolean useFinderCache) {

		return getPersistence().fetchByduplicateLicNationalIdFinder(
			nationalId, useFinderCache);
	}

	/**
	 * Removes the dgf duplct licns reason where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the dgf duplct licns reason that was removed
	 */
	public static DgfDuplctLicnsReason removeByduplicateLicNationalIdFinder(
			String nationalId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDuplctLicnsReasonException {

		return getPersistence().removeByduplicateLicNationalIdFinder(
			nationalId);
	}

	/**
	 * Returns the number of dgf duplct licns reasons where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf duplct licns reasons
	 */
	public static int countByduplicateLicNationalIdFinder(String nationalId) {
		return getPersistence().countByduplicateLicNationalIdFinder(nationalId);
	}

	/**
	 * Returns all the dgf duplct licns reasons where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @return the matching dgf duplct licns reasons
	 */
	public static List<DgfDuplctLicnsReason>
		findByduplicateLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo) {

		return getPersistence().findByduplicateLicNationalIdAndLicenseFinder(
			nationalId, licenseNo);
	}

	/**
	 * Returns a range of all the dgf duplct licns reasons where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @return the range of matching dgf duplct licns reasons
	 */
	public static List<DgfDuplctLicnsReason>
		findByduplicateLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo, int start, int end) {

		return getPersistence().findByduplicateLicNationalIdAndLicenseFinder(
			nationalId, licenseNo, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf duplct licns reasons where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf duplct licns reasons
	 */
	public static List<DgfDuplctLicnsReason>
		findByduplicateLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo, int start, int end,
			OrderByComparator<DgfDuplctLicnsReason> orderByComparator) {

		return getPersistence().findByduplicateLicNationalIdAndLicenseFinder(
			nationalId, licenseNo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf duplct licns reasons where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf duplct licns reasons
	 */
	public static List<DgfDuplctLicnsReason>
		findByduplicateLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo, int start, int end,
			OrderByComparator<DgfDuplctLicnsReason> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByduplicateLicNationalIdAndLicenseFinder(
			nationalId, licenseNo, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first dgf duplct licns reason in the ordered set where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a matching dgf duplct licns reason could not be found
	 */
	public static DgfDuplctLicnsReason
			findByduplicateLicNationalIdAndLicenseFinder_First(
				String nationalId, String licenseNo,
				OrderByComparator<DgfDuplctLicnsReason> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDuplctLicnsReasonException {

		return getPersistence().
			findByduplicateLicNationalIdAndLicenseFinder_First(
				nationalId, licenseNo, orderByComparator);
	}

	/**
	 * Returns the first dgf duplct licns reason in the ordered set where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	public static DgfDuplctLicnsReason
		fetchByduplicateLicNationalIdAndLicenseFinder_First(
			String nationalId, String licenseNo,
			OrderByComparator<DgfDuplctLicnsReason> orderByComparator) {

		return getPersistence().
			fetchByduplicateLicNationalIdAndLicenseFinder_First(
				nationalId, licenseNo, orderByComparator);
	}

	/**
	 * Returns the last dgf duplct licns reason in the ordered set where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a matching dgf duplct licns reason could not be found
	 */
	public static DgfDuplctLicnsReason
			findByduplicateLicNationalIdAndLicenseFinder_Last(
				String nationalId, String licenseNo,
				OrderByComparator<DgfDuplctLicnsReason> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDuplctLicnsReasonException {

		return getPersistence().
			findByduplicateLicNationalIdAndLicenseFinder_Last(
				nationalId, licenseNo, orderByComparator);
	}

	/**
	 * Returns the last dgf duplct licns reason in the ordered set where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	public static DgfDuplctLicnsReason
		fetchByduplicateLicNationalIdAndLicenseFinder_Last(
			String nationalId, String licenseNo,
			OrderByComparator<DgfDuplctLicnsReason> orderByComparator) {

		return getPersistence().
			fetchByduplicateLicNationalIdAndLicenseFinder_Last(
				nationalId, licenseNo, orderByComparator);
	}

	/**
	 * Returns the dgf duplct licns reasons before and after the current dgf duplct licns reason in the ordered set where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param duplicateLicenseReasonID the primary key of the current dgf duplct licns reason
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a dgf duplct licns reason with the primary key could not be found
	 */
	public static DgfDuplctLicnsReason[]
			findByduplicateLicNationalIdAndLicenseFinder_PrevAndNext(
				long duplicateLicenseReasonID, String nationalId,
				String licenseNo,
				OrderByComparator<DgfDuplctLicnsReason> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDuplctLicnsReasonException {

		return getPersistence().
			findByduplicateLicNationalIdAndLicenseFinder_PrevAndNext(
				duplicateLicenseReasonID, nationalId, licenseNo,
				orderByComparator);
	}

	/**
	 * Returns all the dgf duplct licns reasons that the user has permission to view where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @return the matching dgf duplct licns reasons that the user has permission to view
	 */
	public static List<DgfDuplctLicnsReason>
		filterFindByduplicateLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo) {

		return getPersistence().
			filterFindByduplicateLicNationalIdAndLicenseFinder(
				nationalId, licenseNo);
	}

	/**
	 * Returns a range of all the dgf duplct licns reasons that the user has permission to view where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @return the range of matching dgf duplct licns reasons that the user has permission to view
	 */
	public static List<DgfDuplctLicnsReason>
		filterFindByduplicateLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo, int start, int end) {

		return getPersistence().
			filterFindByduplicateLicNationalIdAndLicenseFinder(
				nationalId, licenseNo, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf duplct licns reasons that the user has permissions to view where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf duplct licns reasons that the user has permission to view
	 */
	public static List<DgfDuplctLicnsReason>
		filterFindByduplicateLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo, int start, int end,
			OrderByComparator<DgfDuplctLicnsReason> orderByComparator) {

		return getPersistence().
			filterFindByduplicateLicNationalIdAndLicenseFinder(
				nationalId, licenseNo, start, end, orderByComparator);
	}

	/**
	 * Returns the dgf duplct licns reasons before and after the current dgf duplct licns reason in the ordered set of dgf duplct licns reasons that the user has permission to view where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param duplicateLicenseReasonID the primary key of the current dgf duplct licns reason
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a dgf duplct licns reason with the primary key could not be found
	 */
	public static DgfDuplctLicnsReason[]
			filterFindByduplicateLicNationalIdAndLicenseFinder_PrevAndNext(
				long duplicateLicenseReasonID, String nationalId,
				String licenseNo,
				OrderByComparator<DgfDuplctLicnsReason> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDuplctLicnsReasonException {

		return getPersistence().
			filterFindByduplicateLicNationalIdAndLicenseFinder_PrevAndNext(
				duplicateLicenseReasonID, nationalId, licenseNo,
				orderByComparator);
	}

	/**
	 * Removes all the dgf duplct licns reasons where nationalId = &#63; and licenseNo = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 */
	public static void removeByduplicateLicNationalIdAndLicenseFinder(
		String nationalId, String licenseNo) {

		getPersistence().removeByduplicateLicNationalIdAndLicenseFinder(
			nationalId, licenseNo);
	}

	/**
	 * Returns the number of dgf duplct licns reasons where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @return the number of matching dgf duplct licns reasons
	 */
	public static int countByduplicateLicNationalIdAndLicenseFinder(
		String nationalId, String licenseNo) {

		return getPersistence().countByduplicateLicNationalIdAndLicenseFinder(
			nationalId, licenseNo);
	}

	/**
	 * Returns the number of dgf duplct licns reasons that the user has permission to view where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @return the number of matching dgf duplct licns reasons that the user has permission to view
	 */
	public static int filterCountByduplicateLicNationalIdAndLicenseFinder(
		String nationalId, String licenseNo) {

		return getPersistence().
			filterCountByduplicateLicNationalIdAndLicenseFinder(
				nationalId, licenseNo);
	}

	/**
	 * Returns the dgf duplct licns reason where tradeLicAttchId = &#63; or throws a <code>NoSuchDgfDuplctLicnsReasonException</code> if it could not be found.
	 *
	 * @param tradeLicAttchId the trade lic attch ID
	 * @return the matching dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a matching dgf duplct licns reason could not be found
	 */
	public static DgfDuplctLicnsReason findByduplicateLicTradeLicAttchIdFinder(
			long tradeLicAttchId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDuplctLicnsReasonException {

		return getPersistence().findByduplicateLicTradeLicAttchIdFinder(
			tradeLicAttchId);
	}

	/**
	 * Returns the dgf duplct licns reason where tradeLicAttchId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tradeLicAttchId the trade lic attch ID
	 * @return the matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	public static DgfDuplctLicnsReason fetchByduplicateLicTradeLicAttchIdFinder(
		long tradeLicAttchId) {

		return getPersistence().fetchByduplicateLicTradeLicAttchIdFinder(
			tradeLicAttchId);
	}

	/**
	 * Returns the dgf duplct licns reason where tradeLicAttchId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tradeLicAttchId the trade lic attch ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	public static DgfDuplctLicnsReason fetchByduplicateLicTradeLicAttchIdFinder(
		long tradeLicAttchId, boolean useFinderCache) {

		return getPersistence().fetchByduplicateLicTradeLicAttchIdFinder(
			tradeLicAttchId, useFinderCache);
	}

	/**
	 * Removes the dgf duplct licns reason where tradeLicAttchId = &#63; from the database.
	 *
	 * @param tradeLicAttchId the trade lic attch ID
	 * @return the dgf duplct licns reason that was removed
	 */
	public static DgfDuplctLicnsReason
			removeByduplicateLicTradeLicAttchIdFinder(long tradeLicAttchId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDuplctLicnsReasonException {

		return getPersistence().removeByduplicateLicTradeLicAttchIdFinder(
			tradeLicAttchId);
	}

	/**
	 * Returns the number of dgf duplct licns reasons where tradeLicAttchId = &#63;.
	 *
	 * @param tradeLicAttchId the trade lic attch ID
	 * @return the number of matching dgf duplct licns reasons
	 */
	public static int countByduplicateLicTradeLicAttchIdFinder(
		long tradeLicAttchId) {

		return getPersistence().countByduplicateLicTradeLicAttchIdFinder(
			tradeLicAttchId);
	}

	/**
	 * Returns the dgf duplct licns reason where paymentAttchId = &#63; or throws a <code>NoSuchDgfDuplctLicnsReasonException</code> if it could not be found.
	 *
	 * @param paymentAttchId the payment attch ID
	 * @return the matching dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a matching dgf duplct licns reason could not be found
	 */
	public static DgfDuplctLicnsReason findByduplicateLicPaymentAttchIdFinder(
			long paymentAttchId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDuplctLicnsReasonException {

		return getPersistence().findByduplicateLicPaymentAttchIdFinder(
			paymentAttchId);
	}

	/**
	 * Returns the dgf duplct licns reason where paymentAttchId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param paymentAttchId the payment attch ID
	 * @return the matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	public static DgfDuplctLicnsReason fetchByduplicateLicPaymentAttchIdFinder(
		long paymentAttchId) {

		return getPersistence().fetchByduplicateLicPaymentAttchIdFinder(
			paymentAttchId);
	}

	/**
	 * Returns the dgf duplct licns reason where paymentAttchId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param paymentAttchId the payment attch ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	public static DgfDuplctLicnsReason fetchByduplicateLicPaymentAttchIdFinder(
		long paymentAttchId, boolean useFinderCache) {

		return getPersistence().fetchByduplicateLicPaymentAttchIdFinder(
			paymentAttchId, useFinderCache);
	}

	/**
	 * Removes the dgf duplct licns reason where paymentAttchId = &#63; from the database.
	 *
	 * @param paymentAttchId the payment attch ID
	 * @return the dgf duplct licns reason that was removed
	 */
	public static DgfDuplctLicnsReason removeByduplicateLicPaymentAttchIdFinder(
			long paymentAttchId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDuplctLicnsReasonException {

		return getPersistence().removeByduplicateLicPaymentAttchIdFinder(
			paymentAttchId);
	}

	/**
	 * Returns the number of dgf duplct licns reasons where paymentAttchId = &#63;.
	 *
	 * @param paymentAttchId the payment attch ID
	 * @return the number of matching dgf duplct licns reasons
	 */
	public static int countByduplicateLicPaymentAttchIdFinder(
		long paymentAttchId) {

		return getPersistence().countByduplicateLicPaymentAttchIdFinder(
			paymentAttchId);
	}

	/**
	 * Returns all the dgf duplct licns reasons where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the matching dgf duplct licns reasons
	 */
	public static List<DgfDuplctLicnsReason>
		findByduplicateLicFglPrePrimaryIdFinder(long fglPrePrimaryId) {

		return getPersistence().findByduplicateLicFglPrePrimaryIdFinder(
			fglPrePrimaryId);
	}

	/**
	 * Returns a range of all the dgf duplct licns reasons where fglPrePrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @return the range of matching dgf duplct licns reasons
	 */
	public static List<DgfDuplctLicnsReason>
		findByduplicateLicFglPrePrimaryIdFinder(
			long fglPrePrimaryId, int start, int end) {

		return getPersistence().findByduplicateLicFglPrePrimaryIdFinder(
			fglPrePrimaryId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf duplct licns reasons where fglPrePrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf duplct licns reasons
	 */
	public static List<DgfDuplctLicnsReason>
		findByduplicateLicFglPrePrimaryIdFinder(
			long fglPrePrimaryId, int start, int end,
			OrderByComparator<DgfDuplctLicnsReason> orderByComparator) {

		return getPersistence().findByduplicateLicFglPrePrimaryIdFinder(
			fglPrePrimaryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf duplct licns reasons where fglPrePrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf duplct licns reasons
	 */
	public static List<DgfDuplctLicnsReason>
		findByduplicateLicFglPrePrimaryIdFinder(
			long fglPrePrimaryId, int start, int end,
			OrderByComparator<DgfDuplctLicnsReason> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByduplicateLicFglPrePrimaryIdFinder(
			fglPrePrimaryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf duplct licns reason in the ordered set where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a matching dgf duplct licns reason could not be found
	 */
	public static DgfDuplctLicnsReason
			findByduplicateLicFglPrePrimaryIdFinder_First(
				long fglPrePrimaryId,
				OrderByComparator<DgfDuplctLicnsReason> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDuplctLicnsReasonException {

		return getPersistence().findByduplicateLicFglPrePrimaryIdFinder_First(
			fglPrePrimaryId, orderByComparator);
	}

	/**
	 * Returns the first dgf duplct licns reason in the ordered set where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	public static DgfDuplctLicnsReason
		fetchByduplicateLicFglPrePrimaryIdFinder_First(
			long fglPrePrimaryId,
			OrderByComparator<DgfDuplctLicnsReason> orderByComparator) {

		return getPersistence().fetchByduplicateLicFglPrePrimaryIdFinder_First(
			fglPrePrimaryId, orderByComparator);
	}

	/**
	 * Returns the last dgf duplct licns reason in the ordered set where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a matching dgf duplct licns reason could not be found
	 */
	public static DgfDuplctLicnsReason
			findByduplicateLicFglPrePrimaryIdFinder_Last(
				long fglPrePrimaryId,
				OrderByComparator<DgfDuplctLicnsReason> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDuplctLicnsReasonException {

		return getPersistence().findByduplicateLicFglPrePrimaryIdFinder_Last(
			fglPrePrimaryId, orderByComparator);
	}

	/**
	 * Returns the last dgf duplct licns reason in the ordered set where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	public static DgfDuplctLicnsReason
		fetchByduplicateLicFglPrePrimaryIdFinder_Last(
			long fglPrePrimaryId,
			OrderByComparator<DgfDuplctLicnsReason> orderByComparator) {

		return getPersistence().fetchByduplicateLicFglPrePrimaryIdFinder_Last(
			fglPrePrimaryId, orderByComparator);
	}

	/**
	 * Returns the dgf duplct licns reasons before and after the current dgf duplct licns reason in the ordered set where fglPrePrimaryId = &#63;.
	 *
	 * @param duplicateLicenseReasonID the primary key of the current dgf duplct licns reason
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a dgf duplct licns reason with the primary key could not be found
	 */
	public static DgfDuplctLicnsReason[]
			findByduplicateLicFglPrePrimaryIdFinder_PrevAndNext(
				long duplicateLicenseReasonID, long fglPrePrimaryId,
				OrderByComparator<DgfDuplctLicnsReason> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDuplctLicnsReasonException {

		return getPersistence().
			findByduplicateLicFglPrePrimaryIdFinder_PrevAndNext(
				duplicateLicenseReasonID, fglPrePrimaryId, orderByComparator);
	}

	/**
	 * Returns all the dgf duplct licns reasons that the user has permission to view where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the matching dgf duplct licns reasons that the user has permission to view
	 */
	public static List<DgfDuplctLicnsReason>
		filterFindByduplicateLicFglPrePrimaryIdFinder(long fglPrePrimaryId) {

		return getPersistence().filterFindByduplicateLicFglPrePrimaryIdFinder(
			fglPrePrimaryId);
	}

	/**
	 * Returns a range of all the dgf duplct licns reasons that the user has permission to view where fglPrePrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @return the range of matching dgf duplct licns reasons that the user has permission to view
	 */
	public static List<DgfDuplctLicnsReason>
		filterFindByduplicateLicFglPrePrimaryIdFinder(
			long fglPrePrimaryId, int start, int end) {

		return getPersistence().filterFindByduplicateLicFglPrePrimaryIdFinder(
			fglPrePrimaryId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf duplct licns reasons that the user has permissions to view where fglPrePrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf duplct licns reasons that the user has permission to view
	 */
	public static List<DgfDuplctLicnsReason>
		filterFindByduplicateLicFglPrePrimaryIdFinder(
			long fglPrePrimaryId, int start, int end,
			OrderByComparator<DgfDuplctLicnsReason> orderByComparator) {

		return getPersistence().filterFindByduplicateLicFglPrePrimaryIdFinder(
			fglPrePrimaryId, start, end, orderByComparator);
	}

	/**
	 * Returns the dgf duplct licns reasons before and after the current dgf duplct licns reason in the ordered set of dgf duplct licns reasons that the user has permission to view where fglPrePrimaryId = &#63;.
	 *
	 * @param duplicateLicenseReasonID the primary key of the current dgf duplct licns reason
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a dgf duplct licns reason with the primary key could not be found
	 */
	public static DgfDuplctLicnsReason[]
			filterFindByduplicateLicFglPrePrimaryIdFinder_PrevAndNext(
				long duplicateLicenseReasonID, long fglPrePrimaryId,
				OrderByComparator<DgfDuplctLicnsReason> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDuplctLicnsReasonException {

		return getPersistence().
			filterFindByduplicateLicFglPrePrimaryIdFinder_PrevAndNext(
				duplicateLicenseReasonID, fglPrePrimaryId, orderByComparator);
	}

	/**
	 * Removes all the dgf duplct licns reasons where fglPrePrimaryId = &#63; from the database.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 */
	public static void removeByduplicateLicFglPrePrimaryIdFinder(
		long fglPrePrimaryId) {

		getPersistence().removeByduplicateLicFglPrePrimaryIdFinder(
			fglPrePrimaryId);
	}

	/**
	 * Returns the number of dgf duplct licns reasons where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the number of matching dgf duplct licns reasons
	 */
	public static int countByduplicateLicFglPrePrimaryIdFinder(
		long fglPrePrimaryId) {

		return getPersistence().countByduplicateLicFglPrePrimaryIdFinder(
			fglPrePrimaryId);
	}

	/**
	 * Returns the number of dgf duplct licns reasons that the user has permission to view where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the number of matching dgf duplct licns reasons that the user has permission to view
	 */
	public static int filterCountByduplicateLicFglPrePrimaryIdFinder(
		long fglPrePrimaryId) {

		return getPersistence().filterCountByduplicateLicFglPrePrimaryIdFinder(
			fglPrePrimaryId);
	}

	/**
	 * Returns the dgf duplct licns reason where applicationNo = &#63; or throws a <code>NoSuchDgfDuplctLicnsReasonException</code> if it could not be found.
	 *
	 * @param applicationNo the application no
	 * @return the matching dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a matching dgf duplct licns reason could not be found
	 */
	public static DgfDuplctLicnsReason findByduplicateLicApplicationNoFinder(
			String applicationNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDuplctLicnsReasonException {

		return getPersistence().findByduplicateLicApplicationNoFinder(
			applicationNo);
	}

	/**
	 * Returns the dgf duplct licns reason where applicationNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param applicationNo the application no
	 * @return the matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	public static DgfDuplctLicnsReason fetchByduplicateLicApplicationNoFinder(
		String applicationNo) {

		return getPersistence().fetchByduplicateLicApplicationNoFinder(
			applicationNo);
	}

	/**
	 * Returns the dgf duplct licns reason where applicationNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param applicationNo the application no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf duplct licns reason, or <code>null</code> if a matching dgf duplct licns reason could not be found
	 */
	public static DgfDuplctLicnsReason fetchByduplicateLicApplicationNoFinder(
		String applicationNo, boolean useFinderCache) {

		return getPersistence().fetchByduplicateLicApplicationNoFinder(
			applicationNo, useFinderCache);
	}

	/**
	 * Removes the dgf duplct licns reason where applicationNo = &#63; from the database.
	 *
	 * @param applicationNo the application no
	 * @return the dgf duplct licns reason that was removed
	 */
	public static DgfDuplctLicnsReason removeByduplicateLicApplicationNoFinder(
			String applicationNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDuplctLicnsReasonException {

		return getPersistence().removeByduplicateLicApplicationNoFinder(
			applicationNo);
	}

	/**
	 * Returns the number of dgf duplct licns reasons where applicationNo = &#63;.
	 *
	 * @param applicationNo the application no
	 * @return the number of matching dgf duplct licns reasons
	 */
	public static int countByduplicateLicApplicationNoFinder(
		String applicationNo) {

		return getPersistence().countByduplicateLicApplicationNoFinder(
			applicationNo);
	}

	/**
	 * Caches the dgf duplct licns reason in the entity cache if it is enabled.
	 *
	 * @param dgfDuplctLicnsReason the dgf duplct licns reason
	 */
	public static void cacheResult(DgfDuplctLicnsReason dgfDuplctLicnsReason) {
		getPersistence().cacheResult(dgfDuplctLicnsReason);
	}

	/**
	 * Caches the dgf duplct licns reasons in the entity cache if it is enabled.
	 *
	 * @param dgfDuplctLicnsReasons the dgf duplct licns reasons
	 */
	public static void cacheResult(
		List<DgfDuplctLicnsReason> dgfDuplctLicnsReasons) {

		getPersistence().cacheResult(dgfDuplctLicnsReasons);
	}

	/**
	 * Creates a new dgf duplct licns reason with the primary key. Does not add the dgf duplct licns reason to the database.
	 *
	 * @param duplicateLicenseReasonID the primary key for the new dgf duplct licns reason
	 * @return the new dgf duplct licns reason
	 */
	public static DgfDuplctLicnsReason create(long duplicateLicenseReasonID) {
		return getPersistence().create(duplicateLicenseReasonID);
	}

	/**
	 * Removes the dgf duplct licns reason with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param duplicateLicenseReasonID the primary key of the dgf duplct licns reason
	 * @return the dgf duplct licns reason that was removed
	 * @throws NoSuchDgfDuplctLicnsReasonException if a dgf duplct licns reason with the primary key could not be found
	 */
	public static DgfDuplctLicnsReason remove(long duplicateLicenseReasonID)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDuplctLicnsReasonException {

		return getPersistence().remove(duplicateLicenseReasonID);
	}

	public static DgfDuplctLicnsReason updateImpl(
		DgfDuplctLicnsReason dgfDuplctLicnsReason) {

		return getPersistence().updateImpl(dgfDuplctLicnsReason);
	}

	/**
	 * Returns the dgf duplct licns reason with the primary key or throws a <code>NoSuchDgfDuplctLicnsReasonException</code> if it could not be found.
	 *
	 * @param duplicateLicenseReasonID the primary key of the dgf duplct licns reason
	 * @return the dgf duplct licns reason
	 * @throws NoSuchDgfDuplctLicnsReasonException if a dgf duplct licns reason with the primary key could not be found
	 */
	public static DgfDuplctLicnsReason findByPrimaryKey(
			long duplicateLicenseReasonID)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfDuplctLicnsReasonException {

		return getPersistence().findByPrimaryKey(duplicateLicenseReasonID);
	}

	/**
	 * Returns the dgf duplct licns reason with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param duplicateLicenseReasonID the primary key of the dgf duplct licns reason
	 * @return the dgf duplct licns reason, or <code>null</code> if a dgf duplct licns reason with the primary key could not be found
	 */
	public static DgfDuplctLicnsReason fetchByPrimaryKey(
		long duplicateLicenseReasonID) {

		return getPersistence().fetchByPrimaryKey(duplicateLicenseReasonID);
	}

	/**
	 * Returns all the dgf duplct licns reasons.
	 *
	 * @return the dgf duplct licns reasons
	 */
	public static List<DgfDuplctLicnsReason> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dgf duplct licns reasons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @return the range of dgf duplct licns reasons
	 */
	public static List<DgfDuplctLicnsReason> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dgf duplct licns reasons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf duplct licns reasons
	 */
	public static List<DgfDuplctLicnsReason> findAll(
		int start, int end,
		OrderByComparator<DgfDuplctLicnsReason> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf duplct licns reasons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDuplctLicnsReasonModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf duplct licns reasons
	 * @param end the upper bound of the range of dgf duplct licns reasons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf duplct licns reasons
	 */
	public static List<DgfDuplctLicnsReason> findAll(
		int start, int end,
		OrderByComparator<DgfDuplctLicnsReason> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dgf duplct licns reasons from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dgf duplct licns reasons.
	 *
	 * @return the number of dgf duplct licns reasons
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DgfDuplctLicnsReasonPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DgfDuplctLicnsReasonPersistence _persistence;

}