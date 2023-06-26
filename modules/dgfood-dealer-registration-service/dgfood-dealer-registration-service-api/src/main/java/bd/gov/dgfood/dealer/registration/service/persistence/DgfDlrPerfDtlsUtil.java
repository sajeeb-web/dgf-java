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

import bd.gov.dgfood.dealer.registration.model.DgfDlrPerfDtls;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dgf dlr perf dtls service. This utility wraps <code>bd.gov.dgfood.dealer.registration.service.persistence.impl.DgfDlrPerfDtlsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrPerfDtlsPersistence
 * @generated
 */
public class DgfDlrPerfDtlsUtil {

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
	public static void clearCache(DgfDlrPerfDtls dgfDlrPerfDtls) {
		getPersistence().clearCache(dgfDlrPerfDtls);
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
	public static Map<Serializable, DgfDlrPerfDtls> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DgfDlrPerfDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DgfDlrPerfDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DgfDlrPerfDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DgfDlrPerfDtls> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DgfDlrPerfDtls update(DgfDlrPerfDtls dgfDlrPerfDtls) {
		return getPersistence().update(dgfDlrPerfDtls);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DgfDlrPerfDtls update(
		DgfDlrPerfDtls dgfDlrPerfDtls, ServiceContext serviceContext) {

		return getPersistence().update(dgfDlrPerfDtls, serviceContext);
	}

	/**
	 * Returns the dgf dlr perf dtls where dlrRegNo = &#63; or throws a <code>NoSuchDgfDlrPerfDtlsException</code> if it could not be found.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the matching dgf dlr perf dtls
	 * @throws NoSuchDgfDlrPerfDtlsException if a matching dgf dlr perf dtls could not be found
	 */
	public static DgfDlrPerfDtls findByDgfDlrPerfDtlsByRegNo(long dlrRegNo)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrPerfDtlsException {

		return getPersistence().findByDgfDlrPerfDtlsByRegNo(dlrRegNo);
	}

	/**
	 * Returns the dgf dlr perf dtls where dlrRegNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the matching dgf dlr perf dtls, or <code>null</code> if a matching dgf dlr perf dtls could not be found
	 */
	public static DgfDlrPerfDtls fetchByDgfDlrPerfDtlsByRegNo(long dlrRegNo) {
		return getPersistence().fetchByDgfDlrPerfDtlsByRegNo(dlrRegNo);
	}

	/**
	 * Returns the dgf dlr perf dtls where dlrRegNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf dlr perf dtls, or <code>null</code> if a matching dgf dlr perf dtls could not be found
	 */
	public static DgfDlrPerfDtls fetchByDgfDlrPerfDtlsByRegNo(
		long dlrRegNo, boolean useFinderCache) {

		return getPersistence().fetchByDgfDlrPerfDtlsByRegNo(
			dlrRegNo, useFinderCache);
	}

	/**
	 * Removes the dgf dlr perf dtls where dlrRegNo = &#63; from the database.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the dgf dlr perf dtls that was removed
	 */
	public static DgfDlrPerfDtls removeByDgfDlrPerfDtlsByRegNo(long dlrRegNo)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrPerfDtlsException {

		return getPersistence().removeByDgfDlrPerfDtlsByRegNo(dlrRegNo);
	}

	/**
	 * Returns the number of dgf dlr perf dtlses where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the number of matching dgf dlr perf dtlses
	 */
	public static int countByDgfDlrPerfDtlsByRegNo(long dlrRegNo) {
		return getPersistence().countByDgfDlrPerfDtlsByRegNo(dlrRegNo);
	}

	/**
	 * Returns all the dgf dlr perf dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf dlr perf dtlses
	 */
	public static List<DgfDlrPerfDtls> findByDgfDlrPerfDtlsByNid(
		String nationalId) {

		return getPersistence().findByDgfDlrPerfDtlsByNid(nationalId);
	}

	/**
	 * Returns a range of all the dgf dlr perf dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrPerfDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr perf dtlses
	 * @param end the upper bound of the range of dgf dlr perf dtlses (not inclusive)
	 * @return the range of matching dgf dlr perf dtlses
	 */
	public static List<DgfDlrPerfDtls> findByDgfDlrPerfDtlsByNid(
		String nationalId, int start, int end) {

		return getPersistence().findByDgfDlrPerfDtlsByNid(
			nationalId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf dlr perf dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrPerfDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr perf dtlses
	 * @param end the upper bound of the range of dgf dlr perf dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf dlr perf dtlses
	 */
	public static List<DgfDlrPerfDtls> findByDgfDlrPerfDtlsByNid(
		String nationalId, int start, int end,
		OrderByComparator<DgfDlrPerfDtls> orderByComparator) {

		return getPersistence().findByDgfDlrPerfDtlsByNid(
			nationalId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf dlr perf dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrPerfDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr perf dtlses
	 * @param end the upper bound of the range of dgf dlr perf dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf dlr perf dtlses
	 */
	public static List<DgfDlrPerfDtls> findByDgfDlrPerfDtlsByNid(
		String nationalId, int start, int end,
		OrderByComparator<DgfDlrPerfDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDgfDlrPerfDtlsByNid(
			nationalId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf dlr perf dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr perf dtls
	 * @throws NoSuchDgfDlrPerfDtlsException if a matching dgf dlr perf dtls could not be found
	 */
	public static DgfDlrPerfDtls findByDgfDlrPerfDtlsByNid_First(
			String nationalId,
			OrderByComparator<DgfDlrPerfDtls> orderByComparator)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrPerfDtlsException {

		return getPersistence().findByDgfDlrPerfDtlsByNid_First(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the first dgf dlr perf dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr perf dtls, or <code>null</code> if a matching dgf dlr perf dtls could not be found
	 */
	public static DgfDlrPerfDtls fetchByDgfDlrPerfDtlsByNid_First(
		String nationalId,
		OrderByComparator<DgfDlrPerfDtls> orderByComparator) {

		return getPersistence().fetchByDgfDlrPerfDtlsByNid_First(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the last dgf dlr perf dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr perf dtls
	 * @throws NoSuchDgfDlrPerfDtlsException if a matching dgf dlr perf dtls could not be found
	 */
	public static DgfDlrPerfDtls findByDgfDlrPerfDtlsByNid_Last(
			String nationalId,
			OrderByComparator<DgfDlrPerfDtls> orderByComparator)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrPerfDtlsException {

		return getPersistence().findByDgfDlrPerfDtlsByNid_Last(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the last dgf dlr perf dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr perf dtls, or <code>null</code> if a matching dgf dlr perf dtls could not be found
	 */
	public static DgfDlrPerfDtls fetchByDgfDlrPerfDtlsByNid_Last(
		String nationalId,
		OrderByComparator<DgfDlrPerfDtls> orderByComparator) {

		return getPersistence().fetchByDgfDlrPerfDtlsByNid_Last(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the dgf dlr perf dtlses before and after the current dgf dlr perf dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param dgfDlrPerfId the primary key of the current dgf dlr perf dtls
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf dlr perf dtls
	 * @throws NoSuchDgfDlrPerfDtlsException if a dgf dlr perf dtls with the primary key could not be found
	 */
	public static DgfDlrPerfDtls[] findByDgfDlrPerfDtlsByNid_PrevAndNext(
			long dgfDlrPerfId, String nationalId,
			OrderByComparator<DgfDlrPerfDtls> orderByComparator)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrPerfDtlsException {

		return getPersistence().findByDgfDlrPerfDtlsByNid_PrevAndNext(
			dgfDlrPerfId, nationalId, orderByComparator);
	}

	/**
	 * Removes all the dgf dlr perf dtlses where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	public static void removeByDgfDlrPerfDtlsByNid(String nationalId) {
		getPersistence().removeByDgfDlrPerfDtlsByNid(nationalId);
	}

	/**
	 * Returns the number of dgf dlr perf dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf dlr perf dtlses
	 */
	public static int countByDgfDlrPerfDtlsByNid(String nationalId) {
		return getPersistence().countByDgfDlrPerfDtlsByNid(nationalId);
	}

	/**
	 * Caches the dgf dlr perf dtls in the entity cache if it is enabled.
	 *
	 * @param dgfDlrPerfDtls the dgf dlr perf dtls
	 */
	public static void cacheResult(DgfDlrPerfDtls dgfDlrPerfDtls) {
		getPersistence().cacheResult(dgfDlrPerfDtls);
	}

	/**
	 * Caches the dgf dlr perf dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfDlrPerfDtlses the dgf dlr perf dtlses
	 */
	public static void cacheResult(List<DgfDlrPerfDtls> dgfDlrPerfDtlses) {
		getPersistence().cacheResult(dgfDlrPerfDtlses);
	}

	/**
	 * Creates a new dgf dlr perf dtls with the primary key. Does not add the dgf dlr perf dtls to the database.
	 *
	 * @param dgfDlrPerfId the primary key for the new dgf dlr perf dtls
	 * @return the new dgf dlr perf dtls
	 */
	public static DgfDlrPerfDtls create(long dgfDlrPerfId) {
		return getPersistence().create(dgfDlrPerfId);
	}

	/**
	 * Removes the dgf dlr perf dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dgfDlrPerfId the primary key of the dgf dlr perf dtls
	 * @return the dgf dlr perf dtls that was removed
	 * @throws NoSuchDgfDlrPerfDtlsException if a dgf dlr perf dtls with the primary key could not be found
	 */
	public static DgfDlrPerfDtls remove(long dgfDlrPerfId)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrPerfDtlsException {

		return getPersistence().remove(dgfDlrPerfId);
	}

	public static DgfDlrPerfDtls updateImpl(DgfDlrPerfDtls dgfDlrPerfDtls) {
		return getPersistence().updateImpl(dgfDlrPerfDtls);
	}

	/**
	 * Returns the dgf dlr perf dtls with the primary key or throws a <code>NoSuchDgfDlrPerfDtlsException</code> if it could not be found.
	 *
	 * @param dgfDlrPerfId the primary key of the dgf dlr perf dtls
	 * @return the dgf dlr perf dtls
	 * @throws NoSuchDgfDlrPerfDtlsException if a dgf dlr perf dtls with the primary key could not be found
	 */
	public static DgfDlrPerfDtls findByPrimaryKey(long dgfDlrPerfId)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrPerfDtlsException {

		return getPersistence().findByPrimaryKey(dgfDlrPerfId);
	}

	/**
	 * Returns the dgf dlr perf dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dgfDlrPerfId the primary key of the dgf dlr perf dtls
	 * @return the dgf dlr perf dtls, or <code>null</code> if a dgf dlr perf dtls with the primary key could not be found
	 */
	public static DgfDlrPerfDtls fetchByPrimaryKey(long dgfDlrPerfId) {
		return getPersistence().fetchByPrimaryKey(dgfDlrPerfId);
	}

	/**
	 * Returns all the dgf dlr perf dtlses.
	 *
	 * @return the dgf dlr perf dtlses
	 */
	public static List<DgfDlrPerfDtls> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dgf dlr perf dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrPerfDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr perf dtlses
	 * @param end the upper bound of the range of dgf dlr perf dtlses (not inclusive)
	 * @return the range of dgf dlr perf dtlses
	 */
	public static List<DgfDlrPerfDtls> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dgf dlr perf dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrPerfDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr perf dtlses
	 * @param end the upper bound of the range of dgf dlr perf dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf dlr perf dtlses
	 */
	public static List<DgfDlrPerfDtls> findAll(
		int start, int end,
		OrderByComparator<DgfDlrPerfDtls> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf dlr perf dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrPerfDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr perf dtlses
	 * @param end the upper bound of the range of dgf dlr perf dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf dlr perf dtlses
	 */
	public static List<DgfDlrPerfDtls> findAll(
		int start, int end, OrderByComparator<DgfDlrPerfDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dgf dlr perf dtlses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dgf dlr perf dtlses.
	 *
	 * @return the number of dgf dlr perf dtlses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DgfDlrPerfDtlsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DgfDlrPerfDtlsPersistence _persistence;

}