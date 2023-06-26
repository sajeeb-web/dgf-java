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

import bd.gov.dgfood.food.grain.license.model.DgfUsersDtls;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dgf users dtls service. This utility wraps <code>bd.gov.dgfood.food.grain.license.service.persistence.impl.DgfUsersDtlsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersDtlsPersistence
 * @generated
 */
public class DgfUsersDtlsUtil {

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
	public static void clearCache(DgfUsersDtls dgfUsersDtls) {
		getPersistence().clearCache(dgfUsersDtls);
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
	public static Map<Serializable, DgfUsersDtls> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DgfUsersDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DgfUsersDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DgfUsersDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DgfUsersDtls> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DgfUsersDtls update(DgfUsersDtls dgfUsersDtls) {
		return getPersistence().update(dgfUsersDtls);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DgfUsersDtls update(
		DgfUsersDtls dgfUsersDtls, ServiceContext serviceContext) {

		return getPersistence().update(dgfUsersDtls, serviceContext);
	}

	/**
	 * Returns the dgf users dtls where nationalId = &#63; or throws a <code>NoSuchDgfUsersDtlsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf users dtls
	 * @throws NoSuchDgfUsersDtlsException if a matching dgf users dtls could not be found
	 */
	public static DgfUsersDtls findBydgfUsersDtlsByNationalId(long nationalId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersDtlsException {

		return getPersistence().findBydgfUsersDtlsByNationalId(nationalId);
	}

	/**
	 * Returns the dgf users dtls where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf users dtls, or <code>null</code> if a matching dgf users dtls could not be found
	 */
	public static DgfUsersDtls fetchBydgfUsersDtlsByNationalId(
		long nationalId) {

		return getPersistence().fetchBydgfUsersDtlsByNationalId(nationalId);
	}

	/**
	 * Returns the dgf users dtls where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf users dtls, or <code>null</code> if a matching dgf users dtls could not be found
	 */
	public static DgfUsersDtls fetchBydgfUsersDtlsByNationalId(
		long nationalId, boolean useFinderCache) {

		return getPersistence().fetchBydgfUsersDtlsByNationalId(
			nationalId, useFinderCache);
	}

	/**
	 * Removes the dgf users dtls where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the dgf users dtls that was removed
	 */
	public static DgfUsersDtls removeBydgfUsersDtlsByNationalId(long nationalId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersDtlsException {

		return getPersistence().removeBydgfUsersDtlsByNationalId(nationalId);
	}

	/**
	 * Returns the number of dgf users dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf users dtlses
	 */
	public static int countBydgfUsersDtlsByNationalId(long nationalId) {
		return getPersistence().countBydgfUsersDtlsByNationalId(nationalId);
	}

	/**
	 * Caches the dgf users dtls in the entity cache if it is enabled.
	 *
	 * @param dgfUsersDtls the dgf users dtls
	 */
	public static void cacheResult(DgfUsersDtls dgfUsersDtls) {
		getPersistence().cacheResult(dgfUsersDtls);
	}

	/**
	 * Caches the dgf users dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfUsersDtlses the dgf users dtlses
	 */
	public static void cacheResult(List<DgfUsersDtls> dgfUsersDtlses) {
		getPersistence().cacheResult(dgfUsersDtlses);
	}

	/**
	 * Creates a new dgf users dtls with the primary key. Does not add the dgf users dtls to the database.
	 *
	 * @param userDetailsId the primary key for the new dgf users dtls
	 * @return the new dgf users dtls
	 */
	public static DgfUsersDtls create(long userDetailsId) {
		return getPersistence().create(userDetailsId);
	}

	/**
	 * Removes the dgf users dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userDetailsId the primary key of the dgf users dtls
	 * @return the dgf users dtls that was removed
	 * @throws NoSuchDgfUsersDtlsException if a dgf users dtls with the primary key could not be found
	 */
	public static DgfUsersDtls remove(long userDetailsId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersDtlsException {

		return getPersistence().remove(userDetailsId);
	}

	public static DgfUsersDtls updateImpl(DgfUsersDtls dgfUsersDtls) {
		return getPersistence().updateImpl(dgfUsersDtls);
	}

	/**
	 * Returns the dgf users dtls with the primary key or throws a <code>NoSuchDgfUsersDtlsException</code> if it could not be found.
	 *
	 * @param userDetailsId the primary key of the dgf users dtls
	 * @return the dgf users dtls
	 * @throws NoSuchDgfUsersDtlsException if a dgf users dtls with the primary key could not be found
	 */
	public static DgfUsersDtls findByPrimaryKey(long userDetailsId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersDtlsException {

		return getPersistence().findByPrimaryKey(userDetailsId);
	}

	/**
	 * Returns the dgf users dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userDetailsId the primary key of the dgf users dtls
	 * @return the dgf users dtls, or <code>null</code> if a dgf users dtls with the primary key could not be found
	 */
	public static DgfUsersDtls fetchByPrimaryKey(long userDetailsId) {
		return getPersistence().fetchByPrimaryKey(userDetailsId);
	}

	/**
	 * Returns all the dgf users dtlses.
	 *
	 * @return the dgf users dtlses
	 */
	public static List<DgfUsersDtls> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dgf users dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users dtlses
	 * @param end the upper bound of the range of dgf users dtlses (not inclusive)
	 * @return the range of dgf users dtlses
	 */
	public static List<DgfUsersDtls> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dgf users dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users dtlses
	 * @param end the upper bound of the range of dgf users dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf users dtlses
	 */
	public static List<DgfUsersDtls> findAll(
		int start, int end, OrderByComparator<DgfUsersDtls> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf users dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users dtlses
	 * @param end the upper bound of the range of dgf users dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf users dtlses
	 */
	public static List<DgfUsersDtls> findAll(
		int start, int end, OrderByComparator<DgfUsersDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dgf users dtlses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dgf users dtlses.
	 *
	 * @return the number of dgf users dtlses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DgfUsersDtlsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DgfUsersDtlsPersistence _persistence;

}