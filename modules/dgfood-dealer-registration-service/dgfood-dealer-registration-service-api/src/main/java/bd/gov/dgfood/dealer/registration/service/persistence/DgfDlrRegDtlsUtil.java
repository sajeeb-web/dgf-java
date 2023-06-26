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

package bd.gov.dgfood.dealer.registration.service.persistence;

import bd.gov.dgfood.dealer.registration.model.DgfDlrRegDtls;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dgf dlr reg dtls service. This utility wraps <code>bd.gov.dgfood.dealer.registration.service.persistence.impl.DgfDlrRegDtlsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrRegDtlsPersistence
 * @generated
 */
public class DgfDlrRegDtlsUtil {

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
	public static void clearCache(DgfDlrRegDtls dgfDlrRegDtls) {
		getPersistence().clearCache(dgfDlrRegDtls);
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
	public static Map<Serializable, DgfDlrRegDtls> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DgfDlrRegDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DgfDlrRegDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DgfDlrRegDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DgfDlrRegDtls> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DgfDlrRegDtls update(DgfDlrRegDtls dgfDlrRegDtls) {
		return getPersistence().update(dgfDlrRegDtls);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DgfDlrRegDtls update(
		DgfDlrRegDtls dgfDlrRegDtls, ServiceContext serviceContext) {

		return getPersistence().update(dgfDlrRegDtls, serviceContext);
	}

	/**
	 * Returns the dgf dlr reg dtls where nationalId = &#63; or throws a <code>NoSuchDgfDlrRegDtlsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf dlr reg dtls
	 * @throws NoSuchDgfDlrRegDtlsException if a matching dgf dlr reg dtls could not be found
	 */
	public static DgfDlrRegDtls findByDgfDlrRegDtlsByNid(String nationalId)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrRegDtlsException {

		return getPersistence().findByDgfDlrRegDtlsByNid(nationalId);
	}

	/**
	 * Returns the dgf dlr reg dtls where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf dlr reg dtls, or <code>null</code> if a matching dgf dlr reg dtls could not be found
	 */
	public static DgfDlrRegDtls fetchByDgfDlrRegDtlsByNid(String nationalId) {
		return getPersistence().fetchByDgfDlrRegDtlsByNid(nationalId);
	}

	/**
	 * Returns the dgf dlr reg dtls where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf dlr reg dtls, or <code>null</code> if a matching dgf dlr reg dtls could not be found
	 */
	public static DgfDlrRegDtls fetchByDgfDlrRegDtlsByNid(
		String nationalId, boolean useFinderCache) {

		return getPersistence().fetchByDgfDlrRegDtlsByNid(
			nationalId, useFinderCache);
	}

	/**
	 * Removes the dgf dlr reg dtls where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the dgf dlr reg dtls that was removed
	 */
	public static DgfDlrRegDtls removeByDgfDlrRegDtlsByNid(String nationalId)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrRegDtlsException {

		return getPersistence().removeByDgfDlrRegDtlsByNid(nationalId);
	}

	/**
	 * Returns the number of dgf dlr reg dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf dlr reg dtlses
	 */
	public static int countByDgfDlrRegDtlsByNid(String nationalId) {
		return getPersistence().countByDgfDlrRegDtlsByNid(nationalId);
	}

	/**
	 * Returns the dgf dlr reg dtls where nationalId = &#63; and fglLicnsNo = &#63; and dlrRegNo = &#63; or throws a <code>NoSuchDgfDlrRegDtlsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @param fglLicnsNo the fgl licns no
	 * @param dlrRegNo the dlr reg no
	 * @return the matching dgf dlr reg dtls
	 * @throws NoSuchDgfDlrRegDtlsException if a matching dgf dlr reg dtls could not be found
	 */
	public static DgfDlrRegDtls
			findByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo(
				String nationalId, String fglLicnsNo, long dlrRegNo)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrRegDtlsException {

		return getPersistence().
			findByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo(
				nationalId, fglLicnsNo, dlrRegNo);
	}

	/**
	 * Returns the dgf dlr reg dtls where nationalId = &#63; and fglLicnsNo = &#63; and dlrRegNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param fglLicnsNo the fgl licns no
	 * @param dlrRegNo the dlr reg no
	 * @return the matching dgf dlr reg dtls, or <code>null</code> if a matching dgf dlr reg dtls could not be found
	 */
	public static DgfDlrRegDtls
		fetchByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo(
			String nationalId, String fglLicnsNo, long dlrRegNo) {

		return getPersistence().
			fetchByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo(
				nationalId, fglLicnsNo, dlrRegNo);
	}

	/**
	 * Returns the dgf dlr reg dtls where nationalId = &#63; and fglLicnsNo = &#63; and dlrRegNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param fglLicnsNo the fgl licns no
	 * @param dlrRegNo the dlr reg no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf dlr reg dtls, or <code>null</code> if a matching dgf dlr reg dtls could not be found
	 */
	public static DgfDlrRegDtls
		fetchByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo(
			String nationalId, String fglLicnsNo, long dlrRegNo,
			boolean useFinderCache) {

		return getPersistence().
			fetchByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo(
				nationalId, fglLicnsNo, dlrRegNo, useFinderCache);
	}

	/**
	 * Removes the dgf dlr reg dtls where nationalId = &#63; and fglLicnsNo = &#63; and dlrRegNo = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @param fglLicnsNo the fgl licns no
	 * @param dlrRegNo the dlr reg no
	 * @return the dgf dlr reg dtls that was removed
	 */
	public static DgfDlrRegDtls
			removeByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo(
				String nationalId, String fglLicnsNo, long dlrRegNo)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrRegDtlsException {

		return getPersistence().
			removeByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo(
				nationalId, fglLicnsNo, dlrRegNo);
	}

	/**
	 * Returns the number of dgf dlr reg dtlses where nationalId = &#63; and fglLicnsNo = &#63; and dlrRegNo = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param fglLicnsNo the fgl licns no
	 * @param dlrRegNo the dlr reg no
	 * @return the number of matching dgf dlr reg dtlses
	 */
	public static int countByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo(
		String nationalId, String fglLicnsNo, long dlrRegNo) {

		return getPersistence().
			countByDgfDlrRegDtlsByNationalIdAndFoodgrainLicenseNo(
				nationalId, fglLicnsNo, dlrRegNo);
	}

	/**
	 * Returns the dgf dlr reg dtls where userId = &#63; or throws a <code>NoSuchDgfDlrRegDtlsException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching dgf dlr reg dtls
	 * @throws NoSuchDgfDlrRegDtlsException if a matching dgf dlr reg dtls could not be found
	 */
	public static DgfDlrRegDtls findByDgfDlrRegDtlsByUserId(long userId)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrRegDtlsException {

		return getPersistence().findByDgfDlrRegDtlsByUserId(userId);
	}

	/**
	 * Returns the dgf dlr reg dtls where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching dgf dlr reg dtls, or <code>null</code> if a matching dgf dlr reg dtls could not be found
	 */
	public static DgfDlrRegDtls fetchByDgfDlrRegDtlsByUserId(long userId) {
		return getPersistence().fetchByDgfDlrRegDtlsByUserId(userId);
	}

	/**
	 * Returns the dgf dlr reg dtls where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf dlr reg dtls, or <code>null</code> if a matching dgf dlr reg dtls could not be found
	 */
	public static DgfDlrRegDtls fetchByDgfDlrRegDtlsByUserId(
		long userId, boolean useFinderCache) {

		return getPersistence().fetchByDgfDlrRegDtlsByUserId(
			userId, useFinderCache);
	}

	/**
	 * Removes the dgf dlr reg dtls where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the dgf dlr reg dtls that was removed
	 */
	public static DgfDlrRegDtls removeByDgfDlrRegDtlsByUserId(long userId)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrRegDtlsException {

		return getPersistence().removeByDgfDlrRegDtlsByUserId(userId);
	}

	/**
	 * Returns the number of dgf dlr reg dtlses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching dgf dlr reg dtlses
	 */
	public static int countByDgfDlrRegDtlsByUserId(long userId) {
		return getPersistence().countByDgfDlrRegDtlsByUserId(userId);
	}

	/**
	 * Caches the dgf dlr reg dtls in the entity cache if it is enabled.
	 *
	 * @param dgfDlrRegDtls the dgf dlr reg dtls
	 */
	public static void cacheResult(DgfDlrRegDtls dgfDlrRegDtls) {
		getPersistence().cacheResult(dgfDlrRegDtls);
	}

	/**
	 * Caches the dgf dlr reg dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfDlrRegDtlses the dgf dlr reg dtlses
	 */
	public static void cacheResult(List<DgfDlrRegDtls> dgfDlrRegDtlses) {
		getPersistence().cacheResult(dgfDlrRegDtlses);
	}

	/**
	 * Creates a new dgf dlr reg dtls with the primary key. Does not add the dgf dlr reg dtls to the database.
	 *
	 * @param dlrRegNo the primary key for the new dgf dlr reg dtls
	 * @return the new dgf dlr reg dtls
	 */
	public static DgfDlrRegDtls create(long dlrRegNo) {
		return getPersistence().create(dlrRegNo);
	}

	/**
	 * Removes the dgf dlr reg dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dlrRegNo the primary key of the dgf dlr reg dtls
	 * @return the dgf dlr reg dtls that was removed
	 * @throws NoSuchDgfDlrRegDtlsException if a dgf dlr reg dtls with the primary key could not be found
	 */
	public static DgfDlrRegDtls remove(long dlrRegNo)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrRegDtlsException {

		return getPersistence().remove(dlrRegNo);
	}

	public static DgfDlrRegDtls updateImpl(DgfDlrRegDtls dgfDlrRegDtls) {
		return getPersistence().updateImpl(dgfDlrRegDtls);
	}

	/**
	 * Returns the dgf dlr reg dtls with the primary key or throws a <code>NoSuchDgfDlrRegDtlsException</code> if it could not be found.
	 *
	 * @param dlrRegNo the primary key of the dgf dlr reg dtls
	 * @return the dgf dlr reg dtls
	 * @throws NoSuchDgfDlrRegDtlsException if a dgf dlr reg dtls with the primary key could not be found
	 */
	public static DgfDlrRegDtls findByPrimaryKey(long dlrRegNo)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrRegDtlsException {

		return getPersistence().findByPrimaryKey(dlrRegNo);
	}

	/**
	 * Returns the dgf dlr reg dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dlrRegNo the primary key of the dgf dlr reg dtls
	 * @return the dgf dlr reg dtls, or <code>null</code> if a dgf dlr reg dtls with the primary key could not be found
	 */
	public static DgfDlrRegDtls fetchByPrimaryKey(long dlrRegNo) {
		return getPersistence().fetchByPrimaryKey(dlrRegNo);
	}

	/**
	 * Returns all the dgf dlr reg dtlses.
	 *
	 * @return the dgf dlr reg dtlses
	 */
	public static List<DgfDlrRegDtls> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dgf dlr reg dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrRegDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr reg dtlses
	 * @param end the upper bound of the range of dgf dlr reg dtlses (not inclusive)
	 * @return the range of dgf dlr reg dtlses
	 */
	public static List<DgfDlrRegDtls> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dgf dlr reg dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrRegDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr reg dtlses
	 * @param end the upper bound of the range of dgf dlr reg dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf dlr reg dtlses
	 */
	public static List<DgfDlrRegDtls> findAll(
		int start, int end,
		OrderByComparator<DgfDlrRegDtls> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf dlr reg dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrRegDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr reg dtlses
	 * @param end the upper bound of the range of dgf dlr reg dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf dlr reg dtlses
	 */
	public static List<DgfDlrRegDtls> findAll(
		int start, int end, OrderByComparator<DgfDlrRegDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dgf dlr reg dtlses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dgf dlr reg dtlses.
	 *
	 * @return the number of dgf dlr reg dtlses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DgfDlrRegDtlsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DgfDlrRegDtlsPersistence _persistence;

}