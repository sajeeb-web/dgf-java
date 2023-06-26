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

import bd.gov.dgfood.food.grain.license.model.DgfRenewLicense;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dgf renew license service. This utility wraps <code>bd.gov.dgfood.food.grain.license.service.persistence.impl.DgfRenewLicensePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfRenewLicensePersistence
 * @generated
 */
public class DgfRenewLicenseUtil {

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
	public static void clearCache(DgfRenewLicense dgfRenewLicense) {
		getPersistence().clearCache(dgfRenewLicense);
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
	public static Map<Serializable, DgfRenewLicense> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DgfRenewLicense> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DgfRenewLicense> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DgfRenewLicense> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DgfRenewLicense> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DgfRenewLicense update(DgfRenewLicense dgfRenewLicense) {
		return getPersistence().update(dgfRenewLicense);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DgfRenewLicense update(
		DgfRenewLicense dgfRenewLicense, ServiceContext serviceContext) {

		return getPersistence().update(dgfRenewLicense, serviceContext);
	}

	/**
	 * Returns the dgf renew license where userId = &#63; or throws a <code>NoSuchDgfRenewLicenseException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a matching dgf renew license could not be found
	 */
	public static DgfRenewLicense findByrenewLicUserIdFinder(long userId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfRenewLicenseException {

		return getPersistence().findByrenewLicUserIdFinder(userId);
	}

	/**
	 * Returns the dgf renew license where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	public static DgfRenewLicense fetchByrenewLicUserIdFinder(long userId) {
		return getPersistence().fetchByrenewLicUserIdFinder(userId);
	}

	/**
	 * Returns the dgf renew license where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	public static DgfRenewLicense fetchByrenewLicUserIdFinder(
		long userId, boolean useFinderCache) {

		return getPersistence().fetchByrenewLicUserIdFinder(
			userId, useFinderCache);
	}

	/**
	 * Removes the dgf renew license where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the dgf renew license that was removed
	 */
	public static DgfRenewLicense removeByrenewLicUserIdFinder(long userId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfRenewLicenseException {

		return getPersistence().removeByrenewLicUserIdFinder(userId);
	}

	/**
	 * Returns the number of dgf renew licenses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching dgf renew licenses
	 */
	public static int countByrenewLicUserIdFinder(long userId) {
		return getPersistence().countByrenewLicUserIdFinder(userId);
	}

	/**
	 * Returns the dgf renew license where nationalId = &#63; or throws a <code>NoSuchDgfRenewLicenseException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a matching dgf renew license could not be found
	 */
	public static DgfRenewLicense findByrenewLicNationalIdFinder(
			String nationalId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfRenewLicenseException {

		return getPersistence().findByrenewLicNationalIdFinder(nationalId);
	}

	/**
	 * Returns the dgf renew license where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	public static DgfRenewLicense fetchByrenewLicNationalIdFinder(
		String nationalId) {

		return getPersistence().fetchByrenewLicNationalIdFinder(nationalId);
	}

	/**
	 * Returns the dgf renew license where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	public static DgfRenewLicense fetchByrenewLicNationalIdFinder(
		String nationalId, boolean useFinderCache) {

		return getPersistence().fetchByrenewLicNationalIdFinder(
			nationalId, useFinderCache);
	}

	/**
	 * Removes the dgf renew license where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the dgf renew license that was removed
	 */
	public static DgfRenewLicense removeByrenewLicNationalIdFinder(
			String nationalId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfRenewLicenseException {

		return getPersistence().removeByrenewLicNationalIdFinder(nationalId);
	}

	/**
	 * Returns the number of dgf renew licenses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf renew licenses
	 */
	public static int countByrenewLicNationalIdFinder(String nationalId) {
		return getPersistence().countByrenewLicNationalIdFinder(nationalId);
	}

	/**
	 * Returns all the dgf renew licenses where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @return the matching dgf renew licenses
	 */
	public static List<DgfRenewLicense>
		findByrenewLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo) {

		return getPersistence().findByrenewLicNationalIdAndLicenseFinder(
			nationalId, licenseNo);
	}

	/**
	 * Returns a range of all the dgf renew licenses where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @return the range of matching dgf renew licenses
	 */
	public static List<DgfRenewLicense>
		findByrenewLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo, int start, int end) {

		return getPersistence().findByrenewLicNationalIdAndLicenseFinder(
			nationalId, licenseNo, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf renew licenses where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf renew licenses
	 */
	public static List<DgfRenewLicense>
		findByrenewLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo, int start, int end,
			OrderByComparator<DgfRenewLicense> orderByComparator) {

		return getPersistence().findByrenewLicNationalIdAndLicenseFinder(
			nationalId, licenseNo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf renew licenses where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf renew licenses
	 */
	public static List<DgfRenewLicense>
		findByrenewLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo, int start, int end,
			OrderByComparator<DgfRenewLicense> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByrenewLicNationalIdAndLicenseFinder(
			nationalId, licenseNo, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first dgf renew license in the ordered set where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a matching dgf renew license could not be found
	 */
	public static DgfRenewLicense
			findByrenewLicNationalIdAndLicenseFinder_First(
				String nationalId, String licenseNo,
				OrderByComparator<DgfRenewLicense> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfRenewLicenseException {

		return getPersistence().findByrenewLicNationalIdAndLicenseFinder_First(
			nationalId, licenseNo, orderByComparator);
	}

	/**
	 * Returns the first dgf renew license in the ordered set where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	public static DgfRenewLicense
		fetchByrenewLicNationalIdAndLicenseFinder_First(
			String nationalId, String licenseNo,
			OrderByComparator<DgfRenewLicense> orderByComparator) {

		return getPersistence().fetchByrenewLicNationalIdAndLicenseFinder_First(
			nationalId, licenseNo, orderByComparator);
	}

	/**
	 * Returns the last dgf renew license in the ordered set where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a matching dgf renew license could not be found
	 */
	public static DgfRenewLicense findByrenewLicNationalIdAndLicenseFinder_Last(
			String nationalId, String licenseNo,
			OrderByComparator<DgfRenewLicense> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfRenewLicenseException {

		return getPersistence().findByrenewLicNationalIdAndLicenseFinder_Last(
			nationalId, licenseNo, orderByComparator);
	}

	/**
	 * Returns the last dgf renew license in the ordered set where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	public static DgfRenewLicense
		fetchByrenewLicNationalIdAndLicenseFinder_Last(
			String nationalId, String licenseNo,
			OrderByComparator<DgfRenewLicense> orderByComparator) {

		return getPersistence().fetchByrenewLicNationalIdAndLicenseFinder_Last(
			nationalId, licenseNo, orderByComparator);
	}

	/**
	 * Returns the dgf renew licenses before and after the current dgf renew license in the ordered set where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param renewLicenseId the primary key of the current dgf renew license
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a dgf renew license with the primary key could not be found
	 */
	public static DgfRenewLicense[]
			findByrenewLicNationalIdAndLicenseFinder_PrevAndNext(
				long renewLicenseId, String nationalId, String licenseNo,
				OrderByComparator<DgfRenewLicense> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfRenewLicenseException {

		return getPersistence().
			findByrenewLicNationalIdAndLicenseFinder_PrevAndNext(
				renewLicenseId, nationalId, licenseNo, orderByComparator);
	}

	/**
	 * Returns all the dgf renew licenses that the user has permission to view where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @return the matching dgf renew licenses that the user has permission to view
	 */
	public static List<DgfRenewLicense>
		filterFindByrenewLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo) {

		return getPersistence().filterFindByrenewLicNationalIdAndLicenseFinder(
			nationalId, licenseNo);
	}

	/**
	 * Returns a range of all the dgf renew licenses that the user has permission to view where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @return the range of matching dgf renew licenses that the user has permission to view
	 */
	public static List<DgfRenewLicense>
		filterFindByrenewLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo, int start, int end) {

		return getPersistence().filterFindByrenewLicNationalIdAndLicenseFinder(
			nationalId, licenseNo, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf renew licenses that the user has permissions to view where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf renew licenses that the user has permission to view
	 */
	public static List<DgfRenewLicense>
		filterFindByrenewLicNationalIdAndLicenseFinder(
			String nationalId, String licenseNo, int start, int end,
			OrderByComparator<DgfRenewLicense> orderByComparator) {

		return getPersistence().filterFindByrenewLicNationalIdAndLicenseFinder(
			nationalId, licenseNo, start, end, orderByComparator);
	}

	/**
	 * Returns the dgf renew licenses before and after the current dgf renew license in the ordered set of dgf renew licenses that the user has permission to view where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param renewLicenseId the primary key of the current dgf renew license
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a dgf renew license with the primary key could not be found
	 */
	public static DgfRenewLicense[]
			filterFindByrenewLicNationalIdAndLicenseFinder_PrevAndNext(
				long renewLicenseId, String nationalId, String licenseNo,
				OrderByComparator<DgfRenewLicense> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfRenewLicenseException {

		return getPersistence().
			filterFindByrenewLicNationalIdAndLicenseFinder_PrevAndNext(
				renewLicenseId, nationalId, licenseNo, orderByComparator);
	}

	/**
	 * Removes all the dgf renew licenses where nationalId = &#63; and licenseNo = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 */
	public static void removeByrenewLicNationalIdAndLicenseFinder(
		String nationalId, String licenseNo) {

		getPersistence().removeByrenewLicNationalIdAndLicenseFinder(
			nationalId, licenseNo);
	}

	/**
	 * Returns the number of dgf renew licenses where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @return the number of matching dgf renew licenses
	 */
	public static int countByrenewLicNationalIdAndLicenseFinder(
		String nationalId, String licenseNo) {

		return getPersistence().countByrenewLicNationalIdAndLicenseFinder(
			nationalId, licenseNo);
	}

	/**
	 * Returns the number of dgf renew licenses that the user has permission to view where nationalId = &#63; and licenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param licenseNo the license no
	 * @return the number of matching dgf renew licenses that the user has permission to view
	 */
	public static int filterCountByrenewLicNationalIdAndLicenseFinder(
		String nationalId, String licenseNo) {

		return getPersistence().filterCountByrenewLicNationalIdAndLicenseFinder(
			nationalId, licenseNo);
	}

	/**
	 * Returns the dgf renew license where tradeLicAttchId = &#63; or throws a <code>NoSuchDgfRenewLicenseException</code> if it could not be found.
	 *
	 * @param tradeLicAttchId the trade lic attch ID
	 * @return the matching dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a matching dgf renew license could not be found
	 */
	public static DgfRenewLicense findByrenewLicTradeLicAttchIdFinder(
			long tradeLicAttchId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfRenewLicenseException {

		return getPersistence().findByrenewLicTradeLicAttchIdFinder(
			tradeLicAttchId);
	}

	/**
	 * Returns the dgf renew license where tradeLicAttchId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tradeLicAttchId the trade lic attch ID
	 * @return the matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	public static DgfRenewLicense fetchByrenewLicTradeLicAttchIdFinder(
		long tradeLicAttchId) {

		return getPersistence().fetchByrenewLicTradeLicAttchIdFinder(
			tradeLicAttchId);
	}

	/**
	 * Returns the dgf renew license where tradeLicAttchId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tradeLicAttchId the trade lic attch ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	public static DgfRenewLicense fetchByrenewLicTradeLicAttchIdFinder(
		long tradeLicAttchId, boolean useFinderCache) {

		return getPersistence().fetchByrenewLicTradeLicAttchIdFinder(
			tradeLicAttchId, useFinderCache);
	}

	/**
	 * Removes the dgf renew license where tradeLicAttchId = &#63; from the database.
	 *
	 * @param tradeLicAttchId the trade lic attch ID
	 * @return the dgf renew license that was removed
	 */
	public static DgfRenewLicense removeByrenewLicTradeLicAttchIdFinder(
			long tradeLicAttchId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfRenewLicenseException {

		return getPersistence().removeByrenewLicTradeLicAttchIdFinder(
			tradeLicAttchId);
	}

	/**
	 * Returns the number of dgf renew licenses where tradeLicAttchId = &#63;.
	 *
	 * @param tradeLicAttchId the trade lic attch ID
	 * @return the number of matching dgf renew licenses
	 */
	public static int countByrenewLicTradeLicAttchIdFinder(
		long tradeLicAttchId) {

		return getPersistence().countByrenewLicTradeLicAttchIdFinder(
			tradeLicAttchId);
	}

	/**
	 * Returns the dgf renew license where paymentAttchId = &#63; or throws a <code>NoSuchDgfRenewLicenseException</code> if it could not be found.
	 *
	 * @param paymentAttchId the payment attch ID
	 * @return the matching dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a matching dgf renew license could not be found
	 */
	public static DgfRenewLicense findByrenewLicPaymentAttchIdFinder(
			long paymentAttchId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfRenewLicenseException {

		return getPersistence().findByrenewLicPaymentAttchIdFinder(
			paymentAttchId);
	}

	/**
	 * Returns the dgf renew license where paymentAttchId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param paymentAttchId the payment attch ID
	 * @return the matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	public static DgfRenewLicense fetchByrenewLicPaymentAttchIdFinder(
		long paymentAttchId) {

		return getPersistence().fetchByrenewLicPaymentAttchIdFinder(
			paymentAttchId);
	}

	/**
	 * Returns the dgf renew license where paymentAttchId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param paymentAttchId the payment attch ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	public static DgfRenewLicense fetchByrenewLicPaymentAttchIdFinder(
		long paymentAttchId, boolean useFinderCache) {

		return getPersistence().fetchByrenewLicPaymentAttchIdFinder(
			paymentAttchId, useFinderCache);
	}

	/**
	 * Removes the dgf renew license where paymentAttchId = &#63; from the database.
	 *
	 * @param paymentAttchId the payment attch ID
	 * @return the dgf renew license that was removed
	 */
	public static DgfRenewLicense removeByrenewLicPaymentAttchIdFinder(
			long paymentAttchId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfRenewLicenseException {

		return getPersistence().removeByrenewLicPaymentAttchIdFinder(
			paymentAttchId);
	}

	/**
	 * Returns the number of dgf renew licenses where paymentAttchId = &#63;.
	 *
	 * @param paymentAttchId the payment attch ID
	 * @return the number of matching dgf renew licenses
	 */
	public static int countByrenewLicPaymentAttchIdFinder(long paymentAttchId) {
		return getPersistence().countByrenewLicPaymentAttchIdFinder(
			paymentAttchId);
	}

	/**
	 * Returns all the dgf renew licenses where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the matching dgf renew licenses
	 */
	public static List<DgfRenewLicense> findByrenewLicFglPrePrimaryIdFinder(
		long fglPrePrimaryId) {

		return getPersistence().findByrenewLicFglPrePrimaryIdFinder(
			fglPrePrimaryId);
	}

	/**
	 * Returns a range of all the dgf renew licenses where fglPrePrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @return the range of matching dgf renew licenses
	 */
	public static List<DgfRenewLicense> findByrenewLicFglPrePrimaryIdFinder(
		long fglPrePrimaryId, int start, int end) {

		return getPersistence().findByrenewLicFglPrePrimaryIdFinder(
			fglPrePrimaryId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf renew licenses where fglPrePrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf renew licenses
	 */
	public static List<DgfRenewLicense> findByrenewLicFglPrePrimaryIdFinder(
		long fglPrePrimaryId, int start, int end,
		OrderByComparator<DgfRenewLicense> orderByComparator) {

		return getPersistence().findByrenewLicFglPrePrimaryIdFinder(
			fglPrePrimaryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf renew licenses where fglPrePrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf renew licenses
	 */
	public static List<DgfRenewLicense> findByrenewLicFglPrePrimaryIdFinder(
		long fglPrePrimaryId, int start, int end,
		OrderByComparator<DgfRenewLicense> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByrenewLicFglPrePrimaryIdFinder(
			fglPrePrimaryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf renew license in the ordered set where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a matching dgf renew license could not be found
	 */
	public static DgfRenewLicense findByrenewLicFglPrePrimaryIdFinder_First(
			long fglPrePrimaryId,
			OrderByComparator<DgfRenewLicense> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfRenewLicenseException {

		return getPersistence().findByrenewLicFglPrePrimaryIdFinder_First(
			fglPrePrimaryId, orderByComparator);
	}

	/**
	 * Returns the first dgf renew license in the ordered set where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	public static DgfRenewLicense fetchByrenewLicFglPrePrimaryIdFinder_First(
		long fglPrePrimaryId,
		OrderByComparator<DgfRenewLicense> orderByComparator) {

		return getPersistence().fetchByrenewLicFglPrePrimaryIdFinder_First(
			fglPrePrimaryId, orderByComparator);
	}

	/**
	 * Returns the last dgf renew license in the ordered set where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a matching dgf renew license could not be found
	 */
	public static DgfRenewLicense findByrenewLicFglPrePrimaryIdFinder_Last(
			long fglPrePrimaryId,
			OrderByComparator<DgfRenewLicense> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfRenewLicenseException {

		return getPersistence().findByrenewLicFglPrePrimaryIdFinder_Last(
			fglPrePrimaryId, orderByComparator);
	}

	/**
	 * Returns the last dgf renew license in the ordered set where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	public static DgfRenewLicense fetchByrenewLicFglPrePrimaryIdFinder_Last(
		long fglPrePrimaryId,
		OrderByComparator<DgfRenewLicense> orderByComparator) {

		return getPersistence().fetchByrenewLicFglPrePrimaryIdFinder_Last(
			fglPrePrimaryId, orderByComparator);
	}

	/**
	 * Returns the dgf renew licenses before and after the current dgf renew license in the ordered set where fglPrePrimaryId = &#63;.
	 *
	 * @param renewLicenseId the primary key of the current dgf renew license
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a dgf renew license with the primary key could not be found
	 */
	public static DgfRenewLicense[]
			findByrenewLicFglPrePrimaryIdFinder_PrevAndNext(
				long renewLicenseId, long fglPrePrimaryId,
				OrderByComparator<DgfRenewLicense> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfRenewLicenseException {

		return getPersistence().findByrenewLicFglPrePrimaryIdFinder_PrevAndNext(
			renewLicenseId, fglPrePrimaryId, orderByComparator);
	}

	/**
	 * Returns all the dgf renew licenses that the user has permission to view where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the matching dgf renew licenses that the user has permission to view
	 */
	public static List<DgfRenewLicense>
		filterFindByrenewLicFglPrePrimaryIdFinder(long fglPrePrimaryId) {

		return getPersistence().filterFindByrenewLicFglPrePrimaryIdFinder(
			fglPrePrimaryId);
	}

	/**
	 * Returns a range of all the dgf renew licenses that the user has permission to view where fglPrePrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @return the range of matching dgf renew licenses that the user has permission to view
	 */
	public static List<DgfRenewLicense>
		filterFindByrenewLicFglPrePrimaryIdFinder(
			long fglPrePrimaryId, int start, int end) {

		return getPersistence().filterFindByrenewLicFglPrePrimaryIdFinder(
			fglPrePrimaryId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf renew licenses that the user has permissions to view where fglPrePrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf renew licenses that the user has permission to view
	 */
	public static List<DgfRenewLicense>
		filterFindByrenewLicFglPrePrimaryIdFinder(
			long fglPrePrimaryId, int start, int end,
			OrderByComparator<DgfRenewLicense> orderByComparator) {

		return getPersistence().filterFindByrenewLicFglPrePrimaryIdFinder(
			fglPrePrimaryId, start, end, orderByComparator);
	}

	/**
	 * Returns the dgf renew licenses before and after the current dgf renew license in the ordered set of dgf renew licenses that the user has permission to view where fglPrePrimaryId = &#63;.
	 *
	 * @param renewLicenseId the primary key of the current dgf renew license
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a dgf renew license with the primary key could not be found
	 */
	public static DgfRenewLicense[]
			filterFindByrenewLicFglPrePrimaryIdFinder_PrevAndNext(
				long renewLicenseId, long fglPrePrimaryId,
				OrderByComparator<DgfRenewLicense> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfRenewLicenseException {

		return getPersistence().
			filterFindByrenewLicFglPrePrimaryIdFinder_PrevAndNext(
				renewLicenseId, fglPrePrimaryId, orderByComparator);
	}

	/**
	 * Removes all the dgf renew licenses where fglPrePrimaryId = &#63; from the database.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 */
	public static void removeByrenewLicFglPrePrimaryIdFinder(
		long fglPrePrimaryId) {

		getPersistence().removeByrenewLicFglPrePrimaryIdFinder(fglPrePrimaryId);
	}

	/**
	 * Returns the number of dgf renew licenses where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the number of matching dgf renew licenses
	 */
	public static int countByrenewLicFglPrePrimaryIdFinder(
		long fglPrePrimaryId) {

		return getPersistence().countByrenewLicFglPrePrimaryIdFinder(
			fglPrePrimaryId);
	}

	/**
	 * Returns the number of dgf renew licenses that the user has permission to view where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the number of matching dgf renew licenses that the user has permission to view
	 */
	public static int filterCountByrenewLicFglPrePrimaryIdFinder(
		long fglPrePrimaryId) {

		return getPersistence().filterCountByrenewLicFglPrePrimaryIdFinder(
			fglPrePrimaryId);
	}

	/**
	 * Returns the dgf renew license where applicationNo = &#63; or throws a <code>NoSuchDgfRenewLicenseException</code> if it could not be found.
	 *
	 * @param applicationNo the application no
	 * @return the matching dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a matching dgf renew license could not be found
	 */
	public static DgfRenewLicense findByrenewLicApplicationNoFinder(
			String applicationNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfRenewLicenseException {

		return getPersistence().findByrenewLicApplicationNoFinder(
			applicationNo);
	}

	/**
	 * Returns the dgf renew license where applicationNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param applicationNo the application no
	 * @return the matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	public static DgfRenewLicense fetchByrenewLicApplicationNoFinder(
		String applicationNo) {

		return getPersistence().fetchByrenewLicApplicationNoFinder(
			applicationNo);
	}

	/**
	 * Returns the dgf renew license where applicationNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param applicationNo the application no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf renew license, or <code>null</code> if a matching dgf renew license could not be found
	 */
	public static DgfRenewLicense fetchByrenewLicApplicationNoFinder(
		String applicationNo, boolean useFinderCache) {

		return getPersistence().fetchByrenewLicApplicationNoFinder(
			applicationNo, useFinderCache);
	}

	/**
	 * Removes the dgf renew license where applicationNo = &#63; from the database.
	 *
	 * @param applicationNo the application no
	 * @return the dgf renew license that was removed
	 */
	public static DgfRenewLicense removeByrenewLicApplicationNoFinder(
			String applicationNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfRenewLicenseException {

		return getPersistence().removeByrenewLicApplicationNoFinder(
			applicationNo);
	}

	/**
	 * Returns the number of dgf renew licenses where applicationNo = &#63;.
	 *
	 * @param applicationNo the application no
	 * @return the number of matching dgf renew licenses
	 */
	public static int countByrenewLicApplicationNoFinder(String applicationNo) {
		return getPersistence().countByrenewLicApplicationNoFinder(
			applicationNo);
	}

	/**
	 * Caches the dgf renew license in the entity cache if it is enabled.
	 *
	 * @param dgfRenewLicense the dgf renew license
	 */
	public static void cacheResult(DgfRenewLicense dgfRenewLicense) {
		getPersistence().cacheResult(dgfRenewLicense);
	}

	/**
	 * Caches the dgf renew licenses in the entity cache if it is enabled.
	 *
	 * @param dgfRenewLicenses the dgf renew licenses
	 */
	public static void cacheResult(List<DgfRenewLicense> dgfRenewLicenses) {
		getPersistence().cacheResult(dgfRenewLicenses);
	}

	/**
	 * Creates a new dgf renew license with the primary key. Does not add the dgf renew license to the database.
	 *
	 * @param renewLicenseId the primary key for the new dgf renew license
	 * @return the new dgf renew license
	 */
	public static DgfRenewLicense create(long renewLicenseId) {
		return getPersistence().create(renewLicenseId);
	}

	/**
	 * Removes the dgf renew license with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param renewLicenseId the primary key of the dgf renew license
	 * @return the dgf renew license that was removed
	 * @throws NoSuchDgfRenewLicenseException if a dgf renew license with the primary key could not be found
	 */
	public static DgfRenewLicense remove(long renewLicenseId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfRenewLicenseException {

		return getPersistence().remove(renewLicenseId);
	}

	public static DgfRenewLicense updateImpl(DgfRenewLicense dgfRenewLicense) {
		return getPersistence().updateImpl(dgfRenewLicense);
	}

	/**
	 * Returns the dgf renew license with the primary key or throws a <code>NoSuchDgfRenewLicenseException</code> if it could not be found.
	 *
	 * @param renewLicenseId the primary key of the dgf renew license
	 * @return the dgf renew license
	 * @throws NoSuchDgfRenewLicenseException if a dgf renew license with the primary key could not be found
	 */
	public static DgfRenewLicense findByPrimaryKey(long renewLicenseId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfRenewLicenseException {

		return getPersistence().findByPrimaryKey(renewLicenseId);
	}

	/**
	 * Returns the dgf renew license with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param renewLicenseId the primary key of the dgf renew license
	 * @return the dgf renew license, or <code>null</code> if a dgf renew license with the primary key could not be found
	 */
	public static DgfRenewLicense fetchByPrimaryKey(long renewLicenseId) {
		return getPersistence().fetchByPrimaryKey(renewLicenseId);
	}

	/**
	 * Returns all the dgf renew licenses.
	 *
	 * @return the dgf renew licenses
	 */
	public static List<DgfRenewLicense> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dgf renew licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @return the range of dgf renew licenses
	 */
	public static List<DgfRenewLicense> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dgf renew licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf renew licenses
	 */
	public static List<DgfRenewLicense> findAll(
		int start, int end,
		OrderByComparator<DgfRenewLicense> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf renew licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfRenewLicenseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf renew licenses
	 * @param end the upper bound of the range of dgf renew licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf renew licenses
	 */
	public static List<DgfRenewLicense> findAll(
		int start, int end,
		OrderByComparator<DgfRenewLicense> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dgf renew licenses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dgf renew licenses.
	 *
	 * @return the number of dgf renew licenses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DgfRenewLicensePersistence getPersistence() {
		return _persistence;
	}

	private static volatile DgfRenewLicensePersistence _persistence;

}