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

import bd.gov.dgfood.food.grain.license.model.DgfFglLicDtls;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dgf fgl lic dtls service. This utility wraps <code>bd.gov.dgfood.food.grain.license.service.persistence.impl.DgfFglLicDtlsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfFglLicDtlsPersistence
 * @generated
 */
public class DgfFglLicDtlsUtil {

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
	public static void clearCache(DgfFglLicDtls dgfFglLicDtls) {
		getPersistence().clearCache(dgfFglLicDtls);
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
	public static Map<Serializable, DgfFglLicDtls> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DgfFglLicDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DgfFglLicDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DgfFglLicDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DgfFglLicDtls> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DgfFglLicDtls update(DgfFglLicDtls dgfFglLicDtls) {
		return getPersistence().update(dgfFglLicDtls);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DgfFglLicDtls update(
		DgfFglLicDtls dgfFglLicDtls, ServiceContext serviceContext) {

		return getPersistence().update(dgfFglLicDtls, serviceContext);
	}

	/**
	 * Returns the dgf fgl lic dtls where fglPrePrimaryId = &#63; or throws a <code>NoSuchDgfFglLicDtlsException</code> if it could not be found.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the matching dgf fgl lic dtls
	 * @throws NoSuchDgfFglLicDtlsException if a matching dgf fgl lic dtls could not be found
	 */
	public static DgfFglLicDtls findBydgfFglLicDtlsByFglLicPrePrimaryId(
			long fglPrePrimaryId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglLicDtlsException {

		return getPersistence().findBydgfFglLicDtlsByFglLicPrePrimaryId(
			fglPrePrimaryId);
	}

	/**
	 * Returns the dgf fgl lic dtls where fglPrePrimaryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	public static DgfFglLicDtls fetchBydgfFglLicDtlsByFglLicPrePrimaryId(
		long fglPrePrimaryId) {

		return getPersistence().fetchBydgfFglLicDtlsByFglLicPrePrimaryId(
			fglPrePrimaryId);
	}

	/**
	 * Returns the dgf fgl lic dtls where fglPrePrimaryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	public static DgfFglLicDtls fetchBydgfFglLicDtlsByFglLicPrePrimaryId(
		long fglPrePrimaryId, boolean useFinderCache) {

		return getPersistence().fetchBydgfFglLicDtlsByFglLicPrePrimaryId(
			fglPrePrimaryId, useFinderCache);
	}

	/**
	 * Removes the dgf fgl lic dtls where fglPrePrimaryId = &#63; from the database.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the dgf fgl lic dtls that was removed
	 */
	public static DgfFglLicDtls removeBydgfFglLicDtlsByFglLicPrePrimaryId(
			long fglPrePrimaryId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglLicDtlsException {

		return getPersistence().removeBydgfFglLicDtlsByFglLicPrePrimaryId(
			fglPrePrimaryId);
	}

	/**
	 * Returns the number of dgf fgl lic dtlses where fglPrePrimaryId = &#63;.
	 *
	 * @param fglPrePrimaryId the fgl pre primary ID
	 * @return the number of matching dgf fgl lic dtlses
	 */
	public static int countBydgfFglLicDtlsByFglLicPrePrimaryId(
		long fglPrePrimaryId) {

		return getPersistence().countBydgfFglLicDtlsByFglLicPrePrimaryId(
			fglPrePrimaryId);
	}

	/**
	 * Returns the dgf fgl lic dtls where nationalId = &#63; or throws a <code>NoSuchDgfFglLicDtlsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf fgl lic dtls
	 * @throws NoSuchDgfFglLicDtlsException if a matching dgf fgl lic dtls could not be found
	 */
	public static DgfFglLicDtls findBydgfFglLicDtlsByNationalId(
			String nationalId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglLicDtlsException {

		return getPersistence().findBydgfFglLicDtlsByNationalId(nationalId);
	}

	/**
	 * Returns the dgf fgl lic dtls where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	public static DgfFglLicDtls fetchBydgfFglLicDtlsByNationalId(
		String nationalId) {

		return getPersistence().fetchBydgfFglLicDtlsByNationalId(nationalId);
	}

	/**
	 * Returns the dgf fgl lic dtls where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	public static DgfFglLicDtls fetchBydgfFglLicDtlsByNationalId(
		String nationalId, boolean useFinderCache) {

		return getPersistence().fetchBydgfFglLicDtlsByNationalId(
			nationalId, useFinderCache);
	}

	/**
	 * Removes the dgf fgl lic dtls where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the dgf fgl lic dtls that was removed
	 */
	public static DgfFglLicDtls removeBydgfFglLicDtlsByNationalId(
			String nationalId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglLicDtlsException {

		return getPersistence().removeBydgfFglLicDtlsByNationalId(nationalId);
	}

	/**
	 * Returns the number of dgf fgl lic dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf fgl lic dtlses
	 */
	public static int countBydgfFglLicDtlsByNationalId(String nationalId) {
		return getPersistence().countBydgfFglLicDtlsByNationalId(nationalId);
	}

	/**
	 * Returns the dgf fgl lic dtls where fglApplicationNo = &#63; or throws a <code>NoSuchDgfFglLicDtlsException</code> if it could not be found.
	 *
	 * @param fglApplicationNo the fgl application no
	 * @return the matching dgf fgl lic dtls
	 * @throws NoSuchDgfFglLicDtlsException if a matching dgf fgl lic dtls could not be found
	 */
	public static DgfFglLicDtls findBydgfFglLicDtlsByFglApplicationNo(
			String fglApplicationNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglLicDtlsException {

		return getPersistence().findBydgfFglLicDtlsByFglApplicationNo(
			fglApplicationNo);
	}

	/**
	 * Returns the dgf fgl lic dtls where fglApplicationNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fglApplicationNo the fgl application no
	 * @return the matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	public static DgfFglLicDtls fetchBydgfFglLicDtlsByFglApplicationNo(
		String fglApplicationNo) {

		return getPersistence().fetchBydgfFglLicDtlsByFglApplicationNo(
			fglApplicationNo);
	}

	/**
	 * Returns the dgf fgl lic dtls where fglApplicationNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fglApplicationNo the fgl application no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	public static DgfFglLicDtls fetchBydgfFglLicDtlsByFglApplicationNo(
		String fglApplicationNo, boolean useFinderCache) {

		return getPersistence().fetchBydgfFglLicDtlsByFglApplicationNo(
			fglApplicationNo, useFinderCache);
	}

	/**
	 * Removes the dgf fgl lic dtls where fglApplicationNo = &#63; from the database.
	 *
	 * @param fglApplicationNo the fgl application no
	 * @return the dgf fgl lic dtls that was removed
	 */
	public static DgfFglLicDtls removeBydgfFglLicDtlsByFglApplicationNo(
			String fglApplicationNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglLicDtlsException {

		return getPersistence().removeBydgfFglLicDtlsByFglApplicationNo(
			fglApplicationNo);
	}

	/**
	 * Returns the number of dgf fgl lic dtlses where fglApplicationNo = &#63;.
	 *
	 * @param fglApplicationNo the fgl application no
	 * @return the number of matching dgf fgl lic dtlses
	 */
	public static int countBydgfFglLicDtlsByFglApplicationNo(
		String fglApplicationNo) {

		return getPersistence().countBydgfFglLicDtlsByFglApplicationNo(
			fglApplicationNo);
	}

	/**
	 * Returns the dgf fgl lic dtls where foodgrainLicenseNo = &#63; or throws a <code>NoSuchDgfFglLicDtlsException</code> if it could not be found.
	 *
	 * @param foodgrainLicenseNo the foodgrain license no
	 * @return the matching dgf fgl lic dtls
	 * @throws NoSuchDgfFglLicDtlsException if a matching dgf fgl lic dtls could not be found
	 */
	public static DgfFglLicDtls findBydgfFglLicDtlsByFoodgrainLicenseNo(
			String foodgrainLicenseNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglLicDtlsException {

		return getPersistence().findBydgfFglLicDtlsByFoodgrainLicenseNo(
			foodgrainLicenseNo);
	}

	/**
	 * Returns the dgf fgl lic dtls where foodgrainLicenseNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param foodgrainLicenseNo the foodgrain license no
	 * @return the matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	public static DgfFglLicDtls fetchBydgfFglLicDtlsByFoodgrainLicenseNo(
		String foodgrainLicenseNo) {

		return getPersistence().fetchBydgfFglLicDtlsByFoodgrainLicenseNo(
			foodgrainLicenseNo);
	}

	/**
	 * Returns the dgf fgl lic dtls where foodgrainLicenseNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param foodgrainLicenseNo the foodgrain license no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	public static DgfFglLicDtls fetchBydgfFglLicDtlsByFoodgrainLicenseNo(
		String foodgrainLicenseNo, boolean useFinderCache) {

		return getPersistence().fetchBydgfFglLicDtlsByFoodgrainLicenseNo(
			foodgrainLicenseNo, useFinderCache);
	}

	/**
	 * Removes the dgf fgl lic dtls where foodgrainLicenseNo = &#63; from the database.
	 *
	 * @param foodgrainLicenseNo the foodgrain license no
	 * @return the dgf fgl lic dtls that was removed
	 */
	public static DgfFglLicDtls removeBydgfFglLicDtlsByFoodgrainLicenseNo(
			String foodgrainLicenseNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglLicDtlsException {

		return getPersistence().removeBydgfFglLicDtlsByFoodgrainLicenseNo(
			foodgrainLicenseNo);
	}

	/**
	 * Returns the number of dgf fgl lic dtlses where foodgrainLicenseNo = &#63;.
	 *
	 * @param foodgrainLicenseNo the foodgrain license no
	 * @return the number of matching dgf fgl lic dtlses
	 */
	public static int countBydgfFglLicDtlsByFoodgrainLicenseNo(
		String foodgrainLicenseNo) {

		return getPersistence().countBydgfFglLicDtlsByFoodgrainLicenseNo(
			foodgrainLicenseNo);
	}

	/**
	 * Returns the dgf fgl lic dtls where nationalId = &#63; and foodgrainLicenseNo = &#63; or throws a <code>NoSuchDgfFglLicDtlsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @param foodgrainLicenseNo the foodgrain license no
	 * @return the matching dgf fgl lic dtls
	 * @throws NoSuchDgfFglLicDtlsException if a matching dgf fgl lic dtls could not be found
	 */
	public static DgfFglLicDtls
			findBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo(
				String nationalId, String foodgrainLicenseNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglLicDtlsException {

		return getPersistence().
			findBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo(
				nationalId, foodgrainLicenseNo);
	}

	/**
	 * Returns the dgf fgl lic dtls where nationalId = &#63; and foodgrainLicenseNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param foodgrainLicenseNo the foodgrain license no
	 * @return the matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	public static DgfFglLicDtls
		fetchBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo(
			String nationalId, String foodgrainLicenseNo) {

		return getPersistence().
			fetchBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo(
				nationalId, foodgrainLicenseNo);
	}

	/**
	 * Returns the dgf fgl lic dtls where nationalId = &#63; and foodgrainLicenseNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param foodgrainLicenseNo the foodgrain license no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	public static DgfFglLicDtls
		fetchBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo(
			String nationalId, String foodgrainLicenseNo,
			boolean useFinderCache) {

		return getPersistence().
			fetchBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo(
				nationalId, foodgrainLicenseNo, useFinderCache);
	}

	/**
	 * Removes the dgf fgl lic dtls where nationalId = &#63; and foodgrainLicenseNo = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @param foodgrainLicenseNo the foodgrain license no
	 * @return the dgf fgl lic dtls that was removed
	 */
	public static DgfFglLicDtls
			removeBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo(
				String nationalId, String foodgrainLicenseNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglLicDtlsException {

		return getPersistence().
			removeBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo(
				nationalId, foodgrainLicenseNo);
	}

	/**
	 * Returns the number of dgf fgl lic dtlses where nationalId = &#63; and foodgrainLicenseNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param foodgrainLicenseNo the foodgrain license no
	 * @return the number of matching dgf fgl lic dtlses
	 */
	public static int countBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo(
		String nationalId, String foodgrainLicenseNo) {

		return getPersistence().
			countBydgfFglLicDtlsByNationalIdAndFoodgrainLicenseNo(
				nationalId, foodgrainLicenseNo);
	}

	/**
	 * Returns all the dgf fgl lic dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf fgl lic dtlses
	 */
	public static List<DgfFglLicDtls> findBydgfFglLicDtlsListByNid(
		String nationalId) {

		return getPersistence().findBydgfFglLicDtlsListByNid(nationalId);
	}

	/**
	 * Returns a range of all the dgf fgl lic dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglLicDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf fgl lic dtlses
	 * @param end the upper bound of the range of dgf fgl lic dtlses (not inclusive)
	 * @return the range of matching dgf fgl lic dtlses
	 */
	public static List<DgfFglLicDtls> findBydgfFglLicDtlsListByNid(
		String nationalId, int start, int end) {

		return getPersistence().findBydgfFglLicDtlsListByNid(
			nationalId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf fgl lic dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglLicDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf fgl lic dtlses
	 * @param end the upper bound of the range of dgf fgl lic dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl lic dtlses
	 */
	public static List<DgfFglLicDtls> findBydgfFglLicDtlsListByNid(
		String nationalId, int start, int end,
		OrderByComparator<DgfFglLicDtls> orderByComparator) {

		return getPersistence().findBydgfFglLicDtlsListByNid(
			nationalId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf fgl lic dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglLicDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf fgl lic dtlses
	 * @param end the upper bound of the range of dgf fgl lic dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl lic dtlses
	 */
	public static List<DgfFglLicDtls> findBydgfFglLicDtlsListByNid(
		String nationalId, int start, int end,
		OrderByComparator<DgfFglLicDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydgfFglLicDtlsListByNid(
			nationalId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf fgl lic dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl lic dtls
	 * @throws NoSuchDgfFglLicDtlsException if a matching dgf fgl lic dtls could not be found
	 */
	public static DgfFglLicDtls findBydgfFglLicDtlsListByNid_First(
			String nationalId,
			OrderByComparator<DgfFglLicDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglLicDtlsException {

		return getPersistence().findBydgfFglLicDtlsListByNid_First(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the first dgf fgl lic dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	public static DgfFglLicDtls fetchBydgfFglLicDtlsListByNid_First(
		String nationalId, OrderByComparator<DgfFglLicDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglLicDtlsListByNid_First(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl lic dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl lic dtls
	 * @throws NoSuchDgfFglLicDtlsException if a matching dgf fgl lic dtls could not be found
	 */
	public static DgfFglLicDtls findBydgfFglLicDtlsListByNid_Last(
			String nationalId,
			OrderByComparator<DgfFglLicDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglLicDtlsException {

		return getPersistence().findBydgfFglLicDtlsListByNid_Last(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl lic dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl lic dtls, or <code>null</code> if a matching dgf fgl lic dtls could not be found
	 */
	public static DgfFglLicDtls fetchBydgfFglLicDtlsListByNid_Last(
		String nationalId, OrderByComparator<DgfFglLicDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglLicDtlsListByNid_Last(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the dgf fgl lic dtlses before and after the current dgf fgl lic dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param fglLicPrimaryId the primary key of the current dgf fgl lic dtls
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl lic dtls
	 * @throws NoSuchDgfFglLicDtlsException if a dgf fgl lic dtls with the primary key could not be found
	 */
	public static DgfFglLicDtls[] findBydgfFglLicDtlsListByNid_PrevAndNext(
			long fglLicPrimaryId, String nationalId,
			OrderByComparator<DgfFglLicDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglLicDtlsException {

		return getPersistence().findBydgfFglLicDtlsListByNid_PrevAndNext(
			fglLicPrimaryId, nationalId, orderByComparator);
	}

	/**
	 * Removes all the dgf fgl lic dtlses where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	public static void removeBydgfFglLicDtlsListByNid(String nationalId) {
		getPersistence().removeBydgfFglLicDtlsListByNid(nationalId);
	}

	/**
	 * Returns the number of dgf fgl lic dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf fgl lic dtlses
	 */
	public static int countBydgfFglLicDtlsListByNid(String nationalId) {
		return getPersistence().countBydgfFglLicDtlsListByNid(nationalId);
	}

	/**
	 * Caches the dgf fgl lic dtls in the entity cache if it is enabled.
	 *
	 * @param dgfFglLicDtls the dgf fgl lic dtls
	 */
	public static void cacheResult(DgfFglLicDtls dgfFglLicDtls) {
		getPersistence().cacheResult(dgfFglLicDtls);
	}

	/**
	 * Caches the dgf fgl lic dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfFglLicDtlses the dgf fgl lic dtlses
	 */
	public static void cacheResult(List<DgfFglLicDtls> dgfFglLicDtlses) {
		getPersistence().cacheResult(dgfFglLicDtlses);
	}

	/**
	 * Creates a new dgf fgl lic dtls with the primary key. Does not add the dgf fgl lic dtls to the database.
	 *
	 * @param fglLicPrimaryId the primary key for the new dgf fgl lic dtls
	 * @return the new dgf fgl lic dtls
	 */
	public static DgfFglLicDtls create(long fglLicPrimaryId) {
		return getPersistence().create(fglLicPrimaryId);
	}

	/**
	 * Removes the dgf fgl lic dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fglLicPrimaryId the primary key of the dgf fgl lic dtls
	 * @return the dgf fgl lic dtls that was removed
	 * @throws NoSuchDgfFglLicDtlsException if a dgf fgl lic dtls with the primary key could not be found
	 */
	public static DgfFglLicDtls remove(long fglLicPrimaryId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglLicDtlsException {

		return getPersistence().remove(fglLicPrimaryId);
	}

	public static DgfFglLicDtls updateImpl(DgfFglLicDtls dgfFglLicDtls) {
		return getPersistence().updateImpl(dgfFglLicDtls);
	}

	/**
	 * Returns the dgf fgl lic dtls with the primary key or throws a <code>NoSuchDgfFglLicDtlsException</code> if it could not be found.
	 *
	 * @param fglLicPrimaryId the primary key of the dgf fgl lic dtls
	 * @return the dgf fgl lic dtls
	 * @throws NoSuchDgfFglLicDtlsException if a dgf fgl lic dtls with the primary key could not be found
	 */
	public static DgfFglLicDtls findByPrimaryKey(long fglLicPrimaryId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglLicDtlsException {

		return getPersistence().findByPrimaryKey(fglLicPrimaryId);
	}

	/**
	 * Returns the dgf fgl lic dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fglLicPrimaryId the primary key of the dgf fgl lic dtls
	 * @return the dgf fgl lic dtls, or <code>null</code> if a dgf fgl lic dtls with the primary key could not be found
	 */
	public static DgfFglLicDtls fetchByPrimaryKey(long fglLicPrimaryId) {
		return getPersistence().fetchByPrimaryKey(fglLicPrimaryId);
	}

	/**
	 * Returns all the dgf fgl lic dtlses.
	 *
	 * @return the dgf fgl lic dtlses
	 */
	public static List<DgfFglLicDtls> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dgf fgl lic dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglLicDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl lic dtlses
	 * @param end the upper bound of the range of dgf fgl lic dtlses (not inclusive)
	 * @return the range of dgf fgl lic dtlses
	 */
	public static List<DgfFglLicDtls> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dgf fgl lic dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglLicDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl lic dtlses
	 * @param end the upper bound of the range of dgf fgl lic dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf fgl lic dtlses
	 */
	public static List<DgfFglLicDtls> findAll(
		int start, int end,
		OrderByComparator<DgfFglLicDtls> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf fgl lic dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglLicDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl lic dtlses
	 * @param end the upper bound of the range of dgf fgl lic dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf fgl lic dtlses
	 */
	public static List<DgfFglLicDtls> findAll(
		int start, int end, OrderByComparator<DgfFglLicDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dgf fgl lic dtlses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dgf fgl lic dtlses.
	 *
	 * @return the number of dgf fgl lic dtlses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DgfFglLicDtlsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DgfFglLicDtlsPersistence _persistence;

}