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

import bd.gov.dgfood.food.grain.license.model.DgfFglPreDtls;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dgf fgl pre dtls service. This utility wraps <code>bd.gov.dgfood.food.grain.license.service.persistence.impl.DgfFglPreDtlsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfFglPreDtlsPersistence
 * @generated
 */
public class DgfFglPreDtlsUtil {

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
	public static void clearCache(DgfFglPreDtls dgfFglPreDtls) {
		getPersistence().clearCache(dgfFglPreDtls);
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
	public static Map<Serializable, DgfFglPreDtls> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DgfFglPreDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DgfFglPreDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DgfFglPreDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DgfFglPreDtls update(DgfFglPreDtls dgfFglPreDtls) {
		return getPersistence().update(dgfFglPreDtls);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DgfFglPreDtls update(
		DgfFglPreDtls dgfFglPreDtls, ServiceContext serviceContext) {

		return getPersistence().update(dgfFglPreDtls, serviceContext);
	}

	/**
	 * Returns the dgf fgl pre dtls where fglApplicationNo = &#63; or throws a <code>NoSuchDgfFglPreDtlsException</code> if it could not be found.
	 *
	 * @param fglApplicationNo the fgl application no
	 * @return the matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls findBydgfFglPreDtlsByFglApplicationNo(
			String fglApplicationNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByFglApplicationNo(
			fglApplicationNo);
	}

	/**
	 * Returns the dgf fgl pre dtls where fglApplicationNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fglApplicationNo the fgl application no
	 * @return the matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls fetchBydgfFglPreDtlsByFglApplicationNo(
		String fglApplicationNo) {

		return getPersistence().fetchBydgfFglPreDtlsByFglApplicationNo(
			fglApplicationNo);
	}

	/**
	 * Returns the dgf fgl pre dtls where fglApplicationNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fglApplicationNo the fgl application no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls fetchBydgfFglPreDtlsByFglApplicationNo(
		String fglApplicationNo, boolean useFinderCache) {

		return getPersistence().fetchBydgfFglPreDtlsByFglApplicationNo(
			fglApplicationNo, useFinderCache);
	}

	/**
	 * Removes the dgf fgl pre dtls where fglApplicationNo = &#63; from the database.
	 *
	 * @param fglApplicationNo the fgl application no
	 * @return the dgf fgl pre dtls that was removed
	 */
	public static DgfFglPreDtls removeBydgfFglPreDtlsByFglApplicationNo(
			String fglApplicationNo)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().removeBydgfFglPreDtlsByFglApplicationNo(
			fglApplicationNo);
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where fglApplicationNo = &#63;.
	 *
	 * @param fglApplicationNo the fgl application no
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public static int countBydgfFglPreDtlsByFglApplicationNo(
		String fglApplicationNo) {

		return getPersistence().countBydgfFglPreDtlsByFglApplicationNo(
			fglApplicationNo);
	}

	/**
	 * Returns all the dgf fgl pre dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByNationalId(
		long nationalId) {

		return getPersistence().findBydgfFglPreDtlsByNationalId(nationalId);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByNationalId(
		long nationalId, int start, int end) {

		return getPersistence().findBydgfFglPreDtlsByNationalId(
			nationalId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByNationalId(
		long nationalId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().findBydgfFglPreDtlsByNationalId(
			nationalId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByNationalId(
		long nationalId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydgfFglPreDtlsByNationalId(
			nationalId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls findBydgfFglPreDtlsByNationalId_First(
			long nationalId, OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByNationalId_First(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls fetchBydgfFglPreDtlsByNationalId_First(
		long nationalId, OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglPreDtlsByNationalId_First(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls findBydgfFglPreDtlsByNationalId_Last(
			long nationalId, OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByNationalId_Last(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls fetchBydgfFglPreDtlsByNationalId_Last(
		long nationalId, OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglPreDtlsByNationalId_Last(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public static DgfFglPreDtls[] findBydgfFglPreDtlsByNationalId_PrevAndNext(
			long fglPrePrimaryId, long nationalId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByNationalId_PrevAndNext(
			fglPrePrimaryId, nationalId, orderByComparator);
	}

	/**
	 * Removes all the dgf fgl pre dtlses where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	public static void removeBydgfFglPreDtlsByNationalId(long nationalId) {
		getPersistence().removeBydgfFglPreDtlsByNationalId(nationalId);
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public static int countBydgfFglPreDtlsByNationalId(long nationalId) {
		return getPersistence().countBydgfFglPreDtlsByNationalId(nationalId);
	}

	/**
	 * Returns the dgf fgl pre dtls where nationalId = &#63; or throws a <code>NoSuchDgfFglPreDtlsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls findByDgfFglPreDtlsByNID(long nationalId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findByDgfFglPreDtlsByNID(nationalId);
	}

	/**
	 * Returns the dgf fgl pre dtls where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls fetchByDgfFglPreDtlsByNID(long nationalId) {
		return getPersistence().fetchByDgfFglPreDtlsByNID(nationalId);
	}

	/**
	 * Returns the dgf fgl pre dtls where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls fetchByDgfFglPreDtlsByNID(
		long nationalId, boolean useFinderCache) {

		return getPersistence().fetchByDgfFglPreDtlsByNID(
			nationalId, useFinderCache);
	}

	/**
	 * Removes the dgf fgl pre dtls where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the dgf fgl pre dtls that was removed
	 */
	public static DgfFglPreDtls removeByDgfFglPreDtlsByNID(long nationalId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().removeByDgfFglPreDtlsByNID(nationalId);
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public static int countByDgfFglPreDtlsByNID(long nationalId) {
		return getPersistence().countByDgfFglPreDtlsByNID(nationalId);
	}

	/**
	 * Returns all the dgf fgl pre dtlses where presentAddrId = &#63;.
	 *
	 * @param presentAddrId the present addr ID
	 * @return the matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByPresentAddrId(
		long presentAddrId) {

		return getPersistence().findBydgfFglPreDtlsByPresentAddrId(
			presentAddrId);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses where presentAddrId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param presentAddrId the present addr ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByPresentAddrId(
		long presentAddrId, int start, int end) {

		return getPersistence().findBydgfFglPreDtlsByPresentAddrId(
			presentAddrId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where presentAddrId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param presentAddrId the present addr ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByPresentAddrId(
		long presentAddrId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().findBydgfFglPreDtlsByPresentAddrId(
			presentAddrId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where presentAddrId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param presentAddrId the present addr ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByPresentAddrId(
		long presentAddrId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydgfFglPreDtlsByPresentAddrId(
			presentAddrId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where presentAddrId = &#63;.
	 *
	 * @param presentAddrId the present addr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls findBydgfFglPreDtlsByPresentAddrId_First(
			long presentAddrId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByPresentAddrId_First(
			presentAddrId, orderByComparator);
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where presentAddrId = &#63;.
	 *
	 * @param presentAddrId the present addr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls fetchBydgfFglPreDtlsByPresentAddrId_First(
		long presentAddrId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglPreDtlsByPresentAddrId_First(
			presentAddrId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where presentAddrId = &#63;.
	 *
	 * @param presentAddrId the present addr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls findBydgfFglPreDtlsByPresentAddrId_Last(
			long presentAddrId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByPresentAddrId_Last(
			presentAddrId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where presentAddrId = &#63;.
	 *
	 * @param presentAddrId the present addr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls fetchBydgfFglPreDtlsByPresentAddrId_Last(
		long presentAddrId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglPreDtlsByPresentAddrId_Last(
			presentAddrId, orderByComparator);
	}

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where presentAddrId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param presentAddrId the present addr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public static DgfFglPreDtls[]
			findBydgfFglPreDtlsByPresentAddrId_PrevAndNext(
				long fglPrePrimaryId, long presentAddrId,
				OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByPresentAddrId_PrevAndNext(
			fglPrePrimaryId, presentAddrId, orderByComparator);
	}

	/**
	 * Removes all the dgf fgl pre dtlses where presentAddrId = &#63; from the database.
	 *
	 * @param presentAddrId the present addr ID
	 */
	public static void removeBydgfFglPreDtlsByPresentAddrId(
		long presentAddrId) {

		getPersistence().removeBydgfFglPreDtlsByPresentAddrId(presentAddrId);
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where presentAddrId = &#63;.
	 *
	 * @param presentAddrId the present addr ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public static int countBydgfFglPreDtlsByPresentAddrId(long presentAddrId) {
		return getPersistence().countBydgfFglPreDtlsByPresentAddrId(
			presentAddrId);
	}

	/**
	 * Returns all the dgf fgl pre dtlses where bussinessAddrId = &#63;.
	 *
	 * @param bussinessAddrId the bussiness addr ID
	 * @return the matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByBussinessAddrId(
		long bussinessAddrId) {

		return getPersistence().findBydgfFglPreDtlsByBussinessAddrId(
			bussinessAddrId);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses where bussinessAddrId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bussinessAddrId the bussiness addr ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByBussinessAddrId(
		long bussinessAddrId, int start, int end) {

		return getPersistence().findBydgfFglPreDtlsByBussinessAddrId(
			bussinessAddrId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where bussinessAddrId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bussinessAddrId the bussiness addr ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByBussinessAddrId(
		long bussinessAddrId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().findBydgfFglPreDtlsByBussinessAddrId(
			bussinessAddrId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where bussinessAddrId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bussinessAddrId the bussiness addr ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByBussinessAddrId(
		long bussinessAddrId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydgfFglPreDtlsByBussinessAddrId(
			bussinessAddrId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where bussinessAddrId = &#63;.
	 *
	 * @param bussinessAddrId the bussiness addr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls findBydgfFglPreDtlsByBussinessAddrId_First(
			long bussinessAddrId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByBussinessAddrId_First(
			bussinessAddrId, orderByComparator);
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where bussinessAddrId = &#63;.
	 *
	 * @param bussinessAddrId the bussiness addr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls fetchBydgfFglPreDtlsByBussinessAddrId_First(
		long bussinessAddrId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglPreDtlsByBussinessAddrId_First(
			bussinessAddrId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where bussinessAddrId = &#63;.
	 *
	 * @param bussinessAddrId the bussiness addr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls findBydgfFglPreDtlsByBussinessAddrId_Last(
			long bussinessAddrId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByBussinessAddrId_Last(
			bussinessAddrId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where bussinessAddrId = &#63;.
	 *
	 * @param bussinessAddrId the bussiness addr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls fetchBydgfFglPreDtlsByBussinessAddrId_Last(
		long bussinessAddrId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglPreDtlsByBussinessAddrId_Last(
			bussinessAddrId, orderByComparator);
	}

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where bussinessAddrId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param bussinessAddrId the bussiness addr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public static DgfFglPreDtls[]
			findBydgfFglPreDtlsByBussinessAddrId_PrevAndNext(
				long fglPrePrimaryId, long bussinessAddrId,
				OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().
			findBydgfFglPreDtlsByBussinessAddrId_PrevAndNext(
				fglPrePrimaryId, bussinessAddrId, orderByComparator);
	}

	/**
	 * Removes all the dgf fgl pre dtlses where bussinessAddrId = &#63; from the database.
	 *
	 * @param bussinessAddrId the bussiness addr ID
	 */
	public static void removeBydgfFglPreDtlsByBussinessAddrId(
		long bussinessAddrId) {

		getPersistence().removeBydgfFglPreDtlsByBussinessAddrId(
			bussinessAddrId);
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where bussinessAddrId = &#63;.
	 *
	 * @param bussinessAddrId the bussiness addr ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public static int countBydgfFglPreDtlsByBussinessAddrId(
		long bussinessAddrId) {

		return getPersistence().countBydgfFglPreDtlsByBussinessAddrId(
			bussinessAddrId);
	}

	/**
	 * Returns all the dgf fgl pre dtlses where tradeLicenseDocId = &#63;.
	 *
	 * @param tradeLicenseDocId the trade license doc ID
	 * @return the matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByTradeLicenseDocId(
		long tradeLicenseDocId) {

		return getPersistence().findBydgfFglPreDtlsByTradeLicenseDocId(
			tradeLicenseDocId);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses where tradeLicenseDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param tradeLicenseDocId the trade license doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByTradeLicenseDocId(
		long tradeLicenseDocId, int start, int end) {

		return getPersistence().findBydgfFglPreDtlsByTradeLicenseDocId(
			tradeLicenseDocId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where tradeLicenseDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param tradeLicenseDocId the trade license doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByTradeLicenseDocId(
		long tradeLicenseDocId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().findBydgfFglPreDtlsByTradeLicenseDocId(
			tradeLicenseDocId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where tradeLicenseDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param tradeLicenseDocId the trade license doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByTradeLicenseDocId(
		long tradeLicenseDocId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydgfFglPreDtlsByTradeLicenseDocId(
			tradeLicenseDocId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where tradeLicenseDocId = &#63;.
	 *
	 * @param tradeLicenseDocId the trade license doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls findBydgfFglPreDtlsByTradeLicenseDocId_First(
			long tradeLicenseDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByTradeLicenseDocId_First(
			tradeLicenseDocId, orderByComparator);
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where tradeLicenseDocId = &#63;.
	 *
	 * @param tradeLicenseDocId the trade license doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls fetchBydgfFglPreDtlsByTradeLicenseDocId_First(
		long tradeLicenseDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglPreDtlsByTradeLicenseDocId_First(
			tradeLicenseDocId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where tradeLicenseDocId = &#63;.
	 *
	 * @param tradeLicenseDocId the trade license doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls findBydgfFglPreDtlsByTradeLicenseDocId_Last(
			long tradeLicenseDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByTradeLicenseDocId_Last(
			tradeLicenseDocId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where tradeLicenseDocId = &#63;.
	 *
	 * @param tradeLicenseDocId the trade license doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls fetchBydgfFglPreDtlsByTradeLicenseDocId_Last(
		long tradeLicenseDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglPreDtlsByTradeLicenseDocId_Last(
			tradeLicenseDocId, orderByComparator);
	}

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where tradeLicenseDocId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param tradeLicenseDocId the trade license doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public static DgfFglPreDtls[]
			findBydgfFglPreDtlsByTradeLicenseDocId_PrevAndNext(
				long fglPrePrimaryId, long tradeLicenseDocId,
				OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().
			findBydgfFglPreDtlsByTradeLicenseDocId_PrevAndNext(
				fglPrePrimaryId, tradeLicenseDocId, orderByComparator);
	}

	/**
	 * Removes all the dgf fgl pre dtlses where tradeLicenseDocId = &#63; from the database.
	 *
	 * @param tradeLicenseDocId the trade license doc ID
	 */
	public static void removeBydgfFglPreDtlsByTradeLicenseDocId(
		long tradeLicenseDocId) {

		getPersistence().removeBydgfFglPreDtlsByTradeLicenseDocId(
			tradeLicenseDocId);
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where tradeLicenseDocId = &#63;.
	 *
	 * @param tradeLicenseDocId the trade license doc ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public static int countBydgfFglPreDtlsByTradeLicenseDocId(
		long tradeLicenseDocId) {

		return getPersistence().countBydgfFglPreDtlsByTradeLicenseDocId(
			tradeLicenseDocId);
	}

	/**
	 * Returns all the dgf fgl pre dtlses where bussIdentfctDocId = &#63;.
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID
	 * @return the matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByBussIdentfctDocId(
		long bussIdentfctDocId) {

		return getPersistence().findBydgfFglPreDtlsByBussIdentfctDocId(
			bussIdentfctDocId);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses where bussIdentfctDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByBussIdentfctDocId(
		long bussIdentfctDocId, int start, int end) {

		return getPersistence().findBydgfFglPreDtlsByBussIdentfctDocId(
			bussIdentfctDocId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where bussIdentfctDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByBussIdentfctDocId(
		long bussIdentfctDocId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().findBydgfFglPreDtlsByBussIdentfctDocId(
			bussIdentfctDocId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where bussIdentfctDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByBussIdentfctDocId(
		long bussIdentfctDocId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydgfFglPreDtlsByBussIdentfctDocId(
			bussIdentfctDocId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where bussIdentfctDocId = &#63;.
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls findBydgfFglPreDtlsByBussIdentfctDocId_First(
			long bussIdentfctDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByBussIdentfctDocId_First(
			bussIdentfctDocId, orderByComparator);
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where bussIdentfctDocId = &#63;.
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls fetchBydgfFglPreDtlsByBussIdentfctDocId_First(
		long bussIdentfctDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglPreDtlsByBussIdentfctDocId_First(
			bussIdentfctDocId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where bussIdentfctDocId = &#63;.
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls findBydgfFglPreDtlsByBussIdentfctDocId_Last(
			long bussIdentfctDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByBussIdentfctDocId_Last(
			bussIdentfctDocId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where bussIdentfctDocId = &#63;.
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls fetchBydgfFglPreDtlsByBussIdentfctDocId_Last(
		long bussIdentfctDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglPreDtlsByBussIdentfctDocId_Last(
			bussIdentfctDocId, orderByComparator);
	}

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where bussIdentfctDocId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param bussIdentfctDocId the buss identfct doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public static DgfFglPreDtls[]
			findBydgfFglPreDtlsByBussIdentfctDocId_PrevAndNext(
				long fglPrePrimaryId, long bussIdentfctDocId,
				OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().
			findBydgfFglPreDtlsByBussIdentfctDocId_PrevAndNext(
				fglPrePrimaryId, bussIdentfctDocId, orderByComparator);
	}

	/**
	 * Removes all the dgf fgl pre dtlses where bussIdentfctDocId = &#63; from the database.
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID
	 */
	public static void removeBydgfFglPreDtlsByBussIdentfctDocId(
		long bussIdentfctDocId) {

		getPersistence().removeBydgfFglPreDtlsByBussIdentfctDocId(
			bussIdentfctDocId);
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where bussIdentfctDocId = &#63;.
	 *
	 * @param bussIdentfctDocId the buss identfct doc ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public static int countBydgfFglPreDtlsByBussIdentfctDocId(
		long bussIdentfctDocId) {

		return getPersistence().countBydgfFglPreDtlsByBussIdentfctDocId(
			bussIdentfctDocId);
	}

	/**
	 * Returns all the dgf fgl pre dtlses where taxIdentfctDocId = &#63;.
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID
	 * @return the matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByTaxIdentfctDocId(
		long taxIdentfctDocId) {

		return getPersistence().findBydgfFglPreDtlsByTaxIdentfctDocId(
			taxIdentfctDocId);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses where taxIdentfctDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByTaxIdentfctDocId(
		long taxIdentfctDocId, int start, int end) {

		return getPersistence().findBydgfFglPreDtlsByTaxIdentfctDocId(
			taxIdentfctDocId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where taxIdentfctDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByTaxIdentfctDocId(
		long taxIdentfctDocId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().findBydgfFglPreDtlsByTaxIdentfctDocId(
			taxIdentfctDocId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where taxIdentfctDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByTaxIdentfctDocId(
		long taxIdentfctDocId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydgfFglPreDtlsByTaxIdentfctDocId(
			taxIdentfctDocId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where taxIdentfctDocId = &#63;.
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls findBydgfFglPreDtlsByTaxIdentfctDocId_First(
			long taxIdentfctDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByTaxIdentfctDocId_First(
			taxIdentfctDocId, orderByComparator);
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where taxIdentfctDocId = &#63;.
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls fetchBydgfFglPreDtlsByTaxIdentfctDocId_First(
		long taxIdentfctDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglPreDtlsByTaxIdentfctDocId_First(
			taxIdentfctDocId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where taxIdentfctDocId = &#63;.
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls findBydgfFglPreDtlsByTaxIdentfctDocId_Last(
			long taxIdentfctDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByTaxIdentfctDocId_Last(
			taxIdentfctDocId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where taxIdentfctDocId = &#63;.
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls fetchBydgfFglPreDtlsByTaxIdentfctDocId_Last(
		long taxIdentfctDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglPreDtlsByTaxIdentfctDocId_Last(
			taxIdentfctDocId, orderByComparator);
	}

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where taxIdentfctDocId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param taxIdentfctDocId the tax identfct doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public static DgfFglPreDtls[]
			findBydgfFglPreDtlsByTaxIdentfctDocId_PrevAndNext(
				long fglPrePrimaryId, long taxIdentfctDocId,
				OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().
			findBydgfFglPreDtlsByTaxIdentfctDocId_PrevAndNext(
				fglPrePrimaryId, taxIdentfctDocId, orderByComparator);
	}

	/**
	 * Removes all the dgf fgl pre dtlses where taxIdentfctDocId = &#63; from the database.
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID
	 */
	public static void removeBydgfFglPreDtlsByTaxIdentfctDocId(
		long taxIdentfctDocId) {

		getPersistence().removeBydgfFglPreDtlsByTaxIdentfctDocId(
			taxIdentfctDocId);
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where taxIdentfctDocId = &#63;.
	 *
	 * @param taxIdentfctDocId the tax identfct doc ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public static int countBydgfFglPreDtlsByTaxIdentfctDocId(
		long taxIdentfctDocId) {

		return getPersistence().countBydgfFglPreDtlsByTaxIdentfctDocId(
			taxIdentfctDocId);
	}

	/**
	 * Returns all the dgf fgl pre dtlses where bnkStatmtDocId = &#63;.
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 * @return the matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByBnkStatmtDocId(
		long bnkStatmtDocId) {

		return getPersistence().findBydgfFglPreDtlsByBnkStatmtDocId(
			bnkStatmtDocId);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses where bnkStatmtDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByBnkStatmtDocId(
		long bnkStatmtDocId, int start, int end) {

		return getPersistence().findBydgfFglPreDtlsByBnkStatmtDocId(
			bnkStatmtDocId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where bnkStatmtDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByBnkStatmtDocId(
		long bnkStatmtDocId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().findBydgfFglPreDtlsByBnkStatmtDocId(
			bnkStatmtDocId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where bnkStatmtDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByBnkStatmtDocId(
		long bnkStatmtDocId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydgfFglPreDtlsByBnkStatmtDocId(
			bnkStatmtDocId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where bnkStatmtDocId = &#63;.
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls findBydgfFglPreDtlsByBnkStatmtDocId_First(
			long bnkStatmtDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByBnkStatmtDocId_First(
			bnkStatmtDocId, orderByComparator);
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where bnkStatmtDocId = &#63;.
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls fetchBydgfFglPreDtlsByBnkStatmtDocId_First(
		long bnkStatmtDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglPreDtlsByBnkStatmtDocId_First(
			bnkStatmtDocId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where bnkStatmtDocId = &#63;.
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls findBydgfFglPreDtlsByBnkStatmtDocId_Last(
			long bnkStatmtDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByBnkStatmtDocId_Last(
			bnkStatmtDocId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where bnkStatmtDocId = &#63;.
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls fetchBydgfFglPreDtlsByBnkStatmtDocId_Last(
		long bnkStatmtDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglPreDtlsByBnkStatmtDocId_Last(
			bnkStatmtDocId, orderByComparator);
	}

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where bnkStatmtDocId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public static DgfFglPreDtls[]
			findBydgfFglPreDtlsByBnkStatmtDocId_PrevAndNext(
				long fglPrePrimaryId, long bnkStatmtDocId,
				OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByBnkStatmtDocId_PrevAndNext(
			fglPrePrimaryId, bnkStatmtDocId, orderByComparator);
	}

	/**
	 * Removes all the dgf fgl pre dtlses where bnkStatmtDocId = &#63; from the database.
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 */
	public static void removeBydgfFglPreDtlsByBnkStatmtDocId(
		long bnkStatmtDocId) {

		getPersistence().removeBydgfFglPreDtlsByBnkStatmtDocId(bnkStatmtDocId);
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where bnkStatmtDocId = &#63;.
	 *
	 * @param bnkStatmtDocId the bnk statmt doc ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public static int countBydgfFglPreDtlsByBnkStatmtDocId(
		long bnkStatmtDocId) {

		return getPersistence().countBydgfFglPreDtlsByBnkStatmtDocId(
			bnkStatmtDocId);
	}

	/**
	 * Returns all the dgf fgl pre dtlses where paymentChallanId = &#63;.
	 *
	 * @param paymentChallanId the payment challan ID
	 * @return the matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByPaymentChallanId(
		long paymentChallanId) {

		return getPersistence().findBydgfFglPreDtlsByPaymentChallanId(
			paymentChallanId);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses where paymentChallanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param paymentChallanId the payment challan ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByPaymentChallanId(
		long paymentChallanId, int start, int end) {

		return getPersistence().findBydgfFglPreDtlsByPaymentChallanId(
			paymentChallanId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where paymentChallanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param paymentChallanId the payment challan ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByPaymentChallanId(
		long paymentChallanId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().findBydgfFglPreDtlsByPaymentChallanId(
			paymentChallanId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where paymentChallanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param paymentChallanId the payment challan ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByPaymentChallanId(
		long paymentChallanId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydgfFglPreDtlsByPaymentChallanId(
			paymentChallanId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where paymentChallanId = &#63;.
	 *
	 * @param paymentChallanId the payment challan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls findBydgfFglPreDtlsByPaymentChallanId_First(
			long paymentChallanId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByPaymentChallanId_First(
			paymentChallanId, orderByComparator);
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where paymentChallanId = &#63;.
	 *
	 * @param paymentChallanId the payment challan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls fetchBydgfFglPreDtlsByPaymentChallanId_First(
		long paymentChallanId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglPreDtlsByPaymentChallanId_First(
			paymentChallanId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where paymentChallanId = &#63;.
	 *
	 * @param paymentChallanId the payment challan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls findBydgfFglPreDtlsByPaymentChallanId_Last(
			long paymentChallanId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByPaymentChallanId_Last(
			paymentChallanId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where paymentChallanId = &#63;.
	 *
	 * @param paymentChallanId the payment challan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls fetchBydgfFglPreDtlsByPaymentChallanId_Last(
		long paymentChallanId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglPreDtlsByPaymentChallanId_Last(
			paymentChallanId, orderByComparator);
	}

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where paymentChallanId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param paymentChallanId the payment challan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public static DgfFglPreDtls[]
			findBydgfFglPreDtlsByPaymentChallanId_PrevAndNext(
				long fglPrePrimaryId, long paymentChallanId,
				OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().
			findBydgfFglPreDtlsByPaymentChallanId_PrevAndNext(
				fglPrePrimaryId, paymentChallanId, orderByComparator);
	}

	/**
	 * Removes all the dgf fgl pre dtlses where paymentChallanId = &#63; from the database.
	 *
	 * @param paymentChallanId the payment challan ID
	 */
	public static void removeBydgfFglPreDtlsByPaymentChallanId(
		long paymentChallanId) {

		getPersistence().removeBydgfFglPreDtlsByPaymentChallanId(
			paymentChallanId);
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where paymentChallanId = &#63;.
	 *
	 * @param paymentChallanId the payment challan ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public static int countBydgfFglPreDtlsByPaymentChallanId(
		long paymentChallanId) {

		return getPersistence().countBydgfFglPreDtlsByPaymentChallanId(
			paymentChallanId);
	}

	/**
	 * Returns all the dgf fgl pre dtlses where duplicateLicenseReasonId = &#63;.
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 * @return the matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls>
		findBydgfFglPreDtlsByDuplicateLicenseReasonId(
			long duplicateLicenseReasonId) {

		return getPersistence().findBydgfFglPreDtlsByDuplicateLicenseReasonId(
			duplicateLicenseReasonId);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses where duplicateLicenseReasonId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls>
		findBydgfFglPreDtlsByDuplicateLicenseReasonId(
			long duplicateLicenseReasonId, int start, int end) {

		return getPersistence().findBydgfFglPreDtlsByDuplicateLicenseReasonId(
			duplicateLicenseReasonId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where duplicateLicenseReasonId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls>
		findBydgfFglPreDtlsByDuplicateLicenseReasonId(
			long duplicateLicenseReasonId, int start, int end,
			OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().findBydgfFglPreDtlsByDuplicateLicenseReasonId(
			duplicateLicenseReasonId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where duplicateLicenseReasonId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls>
		findBydgfFglPreDtlsByDuplicateLicenseReasonId(
			long duplicateLicenseReasonId, int start, int end,
			OrderByComparator<DgfFglPreDtls> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findBydgfFglPreDtlsByDuplicateLicenseReasonId(
			duplicateLicenseReasonId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where duplicateLicenseReasonId = &#63;.
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls
			findBydgfFglPreDtlsByDuplicateLicenseReasonId_First(
				long duplicateLicenseReasonId,
				OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().
			findBydgfFglPreDtlsByDuplicateLicenseReasonId_First(
				duplicateLicenseReasonId, orderByComparator);
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where duplicateLicenseReasonId = &#63;.
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls
		fetchBydgfFglPreDtlsByDuplicateLicenseReasonId_First(
			long duplicateLicenseReasonId,
			OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().
			fetchBydgfFglPreDtlsByDuplicateLicenseReasonId_First(
				duplicateLicenseReasonId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where duplicateLicenseReasonId = &#63;.
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls
			findBydgfFglPreDtlsByDuplicateLicenseReasonId_Last(
				long duplicateLicenseReasonId,
				OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().
			findBydgfFglPreDtlsByDuplicateLicenseReasonId_Last(
				duplicateLicenseReasonId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where duplicateLicenseReasonId = &#63;.
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls
		fetchBydgfFglPreDtlsByDuplicateLicenseReasonId_Last(
			long duplicateLicenseReasonId,
			OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().
			fetchBydgfFglPreDtlsByDuplicateLicenseReasonId_Last(
				duplicateLicenseReasonId, orderByComparator);
	}

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where duplicateLicenseReasonId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public static DgfFglPreDtls[]
			findBydgfFglPreDtlsByDuplicateLicenseReasonId_PrevAndNext(
				long fglPrePrimaryId, long duplicateLicenseReasonId,
				OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().
			findBydgfFglPreDtlsByDuplicateLicenseReasonId_PrevAndNext(
				fglPrePrimaryId, duplicateLicenseReasonId, orderByComparator);
	}

	/**
	 * Removes all the dgf fgl pre dtlses where duplicateLicenseReasonId = &#63; from the database.
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 */
	public static void removeBydgfFglPreDtlsByDuplicateLicenseReasonId(
		long duplicateLicenseReasonId) {

		getPersistence().removeBydgfFglPreDtlsByDuplicateLicenseReasonId(
			duplicateLicenseReasonId);
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where duplicateLicenseReasonId = &#63;.
	 *
	 * @param duplicateLicenseReasonId the duplicate license reason ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public static int countBydgfFglPreDtlsByDuplicateLicenseReasonId(
		long duplicateLicenseReasonId) {

		return getPersistence().countBydgfFglPreDtlsByDuplicateLicenseReasonId(
			duplicateLicenseReasonId);
	}

	/**
	 * Returns all the dgf fgl pre dtlses where photographDocId = &#63;.
	 *
	 * @param photographDocId the photograph doc ID
	 * @return the matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByPhotographDocId(
		long photographDocId) {

		return getPersistence().findBydgfFglPreDtlsByPhotographDocId(
			photographDocId);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses where photographDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param photographDocId the photograph doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByPhotographDocId(
		long photographDocId, int start, int end) {

		return getPersistence().findBydgfFglPreDtlsByPhotographDocId(
			photographDocId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where photographDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param photographDocId the photograph doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByPhotographDocId(
		long photographDocId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().findBydgfFglPreDtlsByPhotographDocId(
			photographDocId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where photographDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param photographDocId the photograph doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByPhotographDocId(
		long photographDocId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydgfFglPreDtlsByPhotographDocId(
			photographDocId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where photographDocId = &#63;.
	 *
	 * @param photographDocId the photograph doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls findBydgfFglPreDtlsByPhotographDocId_First(
			long photographDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByPhotographDocId_First(
			photographDocId, orderByComparator);
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where photographDocId = &#63;.
	 *
	 * @param photographDocId the photograph doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls fetchBydgfFglPreDtlsByPhotographDocId_First(
		long photographDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglPreDtlsByPhotographDocId_First(
			photographDocId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where photographDocId = &#63;.
	 *
	 * @param photographDocId the photograph doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls findBydgfFglPreDtlsByPhotographDocId_Last(
			long photographDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByPhotographDocId_Last(
			photographDocId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where photographDocId = &#63;.
	 *
	 * @param photographDocId the photograph doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls fetchBydgfFglPreDtlsByPhotographDocId_Last(
		long photographDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglPreDtlsByPhotographDocId_Last(
			photographDocId, orderByComparator);
	}

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where photographDocId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param photographDocId the photograph doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public static DgfFglPreDtls[]
			findBydgfFglPreDtlsByPhotographDocId_PrevAndNext(
				long fglPrePrimaryId, long photographDocId,
				OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().
			findBydgfFglPreDtlsByPhotographDocId_PrevAndNext(
				fglPrePrimaryId, photographDocId, orderByComparator);
	}

	/**
	 * Removes all the dgf fgl pre dtlses where photographDocId = &#63; from the database.
	 *
	 * @param photographDocId the photograph doc ID
	 */
	public static void removeBydgfFglPreDtlsByPhotographDocId(
		long photographDocId) {

		getPersistence().removeBydgfFglPreDtlsByPhotographDocId(
			photographDocId);
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where photographDocId = &#63;.
	 *
	 * @param photographDocId the photograph doc ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public static int countBydgfFglPreDtlsByPhotographDocId(
		long photographDocId) {

		return getPersistence().countBydgfFglPreDtlsByPhotographDocId(
			photographDocId);
	}

	/**
	 * Returns all the dgf fgl pre dtlses where otherReleventDocId = &#63;.
	 *
	 * @param otherReleventDocId the other relevent doc ID
	 * @return the matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByOtherReleventDocId(
		long otherReleventDocId) {

		return getPersistence().findBydgfFglPreDtlsByOtherReleventDocId(
			otherReleventDocId);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses where otherReleventDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param otherReleventDocId the other relevent doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByOtherReleventDocId(
		long otherReleventDocId, int start, int end) {

		return getPersistence().findBydgfFglPreDtlsByOtherReleventDocId(
			otherReleventDocId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where otherReleventDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param otherReleventDocId the other relevent doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByOtherReleventDocId(
		long otherReleventDocId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().findBydgfFglPreDtlsByOtherReleventDocId(
			otherReleventDocId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where otherReleventDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param otherReleventDocId the other relevent doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByOtherReleventDocId(
		long otherReleventDocId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydgfFglPreDtlsByOtherReleventDocId(
			otherReleventDocId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where otherReleventDocId = &#63;.
	 *
	 * @param otherReleventDocId the other relevent doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls findBydgfFglPreDtlsByOtherReleventDocId_First(
			long otherReleventDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByOtherReleventDocId_First(
			otherReleventDocId, orderByComparator);
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where otherReleventDocId = &#63;.
	 *
	 * @param otherReleventDocId the other relevent doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls fetchBydgfFglPreDtlsByOtherReleventDocId_First(
		long otherReleventDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglPreDtlsByOtherReleventDocId_First(
			otherReleventDocId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where otherReleventDocId = &#63;.
	 *
	 * @param otherReleventDocId the other relevent doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls findBydgfFglPreDtlsByOtherReleventDocId_Last(
			long otherReleventDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByOtherReleventDocId_Last(
			otherReleventDocId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where otherReleventDocId = &#63;.
	 *
	 * @param otherReleventDocId the other relevent doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls fetchBydgfFglPreDtlsByOtherReleventDocId_Last(
		long otherReleventDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglPreDtlsByOtherReleventDocId_Last(
			otherReleventDocId, orderByComparator);
	}

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where otherReleventDocId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param otherReleventDocId the other relevent doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public static DgfFglPreDtls[]
			findBydgfFglPreDtlsByOtherReleventDocId_PrevAndNext(
				long fglPrePrimaryId, long otherReleventDocId,
				OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().
			findBydgfFglPreDtlsByOtherReleventDocId_PrevAndNext(
				fglPrePrimaryId, otherReleventDocId, orderByComparator);
	}

	/**
	 * Removes all the dgf fgl pre dtlses where otherReleventDocId = &#63; from the database.
	 *
	 * @param otherReleventDocId the other relevent doc ID
	 */
	public static void removeBydgfFglPreDtlsByOtherReleventDocId(
		long otherReleventDocId) {

		getPersistence().removeBydgfFglPreDtlsByOtherReleventDocId(
			otherReleventDocId);
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where otherReleventDocId = &#63;.
	 *
	 * @param otherReleventDocId the other relevent doc ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public static int countBydgfFglPreDtlsByOtherReleventDocId(
		long otherReleventDocId) {

		return getPersistence().countBydgfFglPreDtlsByOtherReleventDocId(
			otherReleventDocId);
	}

	/**
	 * Returns all the dgf fgl pre dtlses where electricExemptionMemoId = &#63;.
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID
	 * @return the matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls>
		findBydgfFglPreDtlsByElectricExemptionMemoId(
			long electricExemptionMemoId) {

		return getPersistence().findBydgfFglPreDtlsByElectricExemptionMemoId(
			electricExemptionMemoId);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses where electricExemptionMemoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls>
		findBydgfFglPreDtlsByElectricExemptionMemoId(
			long electricExemptionMemoId, int start, int end) {

		return getPersistence().findBydgfFglPreDtlsByElectricExemptionMemoId(
			electricExemptionMemoId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where electricExemptionMemoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls>
		findBydgfFglPreDtlsByElectricExemptionMemoId(
			long electricExemptionMemoId, int start, int end,
			OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().findBydgfFglPreDtlsByElectricExemptionMemoId(
			electricExemptionMemoId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where electricExemptionMemoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls>
		findBydgfFglPreDtlsByElectricExemptionMemoId(
			long electricExemptionMemoId, int start, int end,
			OrderByComparator<DgfFglPreDtls> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findBydgfFglPreDtlsByElectricExemptionMemoId(
			electricExemptionMemoId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where electricExemptionMemoId = &#63;.
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls
			findBydgfFglPreDtlsByElectricExemptionMemoId_First(
				long electricExemptionMemoId,
				OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().
			findBydgfFglPreDtlsByElectricExemptionMemoId_First(
				electricExemptionMemoId, orderByComparator);
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where electricExemptionMemoId = &#63;.
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls
		fetchBydgfFglPreDtlsByElectricExemptionMemoId_First(
			long electricExemptionMemoId,
			OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().
			fetchBydgfFglPreDtlsByElectricExemptionMemoId_First(
				electricExemptionMemoId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where electricExemptionMemoId = &#63;.
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls
			findBydgfFglPreDtlsByElectricExemptionMemoId_Last(
				long electricExemptionMemoId,
				OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().
			findBydgfFglPreDtlsByElectricExemptionMemoId_Last(
				electricExemptionMemoId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where electricExemptionMemoId = &#63;.
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls
		fetchBydgfFglPreDtlsByElectricExemptionMemoId_Last(
			long electricExemptionMemoId,
			OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().
			fetchBydgfFglPreDtlsByElectricExemptionMemoId_Last(
				electricExemptionMemoId, orderByComparator);
	}

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where electricExemptionMemoId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param electricExemptionMemoId the electric exemption memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public static DgfFglPreDtls[]
			findBydgfFglPreDtlsByElectricExemptionMemoId_PrevAndNext(
				long fglPrePrimaryId, long electricExemptionMemoId,
				OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().
			findBydgfFglPreDtlsByElectricExemptionMemoId_PrevAndNext(
				fglPrePrimaryId, electricExemptionMemoId, orderByComparator);
	}

	/**
	 * Removes all the dgf fgl pre dtlses where electricExemptionMemoId = &#63; from the database.
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID
	 */
	public static void removeBydgfFglPreDtlsByElectricExemptionMemoId(
		long electricExemptionMemoId) {

		getPersistence().removeBydgfFglPreDtlsByElectricExemptionMemoId(
			electricExemptionMemoId);
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where electricExemptionMemoId = &#63;.
	 *
	 * @param electricExemptionMemoId the electric exemption memo ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public static int countBydgfFglPreDtlsByElectricExemptionMemoId(
		long electricExemptionMemoId) {

		return getPersistence().countBydgfFglPreDtlsByElectricExemptionMemoId(
			electricExemptionMemoId);
	}

	/**
	 * Returns all the dgf fgl pre dtlses where envClrMemoId = &#63;.
	 *
	 * @param envClrMemoId the env clr memo ID
	 * @return the matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByEnvClrMemoId(
		long envClrMemoId) {

		return getPersistence().findBydgfFglPreDtlsByEnvClrMemoId(envClrMemoId);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses where envClrMemoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param envClrMemoId the env clr memo ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByEnvClrMemoId(
		long envClrMemoId, int start, int end) {

		return getPersistence().findBydgfFglPreDtlsByEnvClrMemoId(
			envClrMemoId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where envClrMemoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param envClrMemoId the env clr memo ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByEnvClrMemoId(
		long envClrMemoId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().findBydgfFglPreDtlsByEnvClrMemoId(
			envClrMemoId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where envClrMemoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param envClrMemoId the env clr memo ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByEnvClrMemoId(
		long envClrMemoId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydgfFglPreDtlsByEnvClrMemoId(
			envClrMemoId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where envClrMemoId = &#63;.
	 *
	 * @param envClrMemoId the env clr memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls findBydgfFglPreDtlsByEnvClrMemoId_First(
			long envClrMemoId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByEnvClrMemoId_First(
			envClrMemoId, orderByComparator);
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where envClrMemoId = &#63;.
	 *
	 * @param envClrMemoId the env clr memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls fetchBydgfFglPreDtlsByEnvClrMemoId_First(
		long envClrMemoId, OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglPreDtlsByEnvClrMemoId_First(
			envClrMemoId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where envClrMemoId = &#63;.
	 *
	 * @param envClrMemoId the env clr memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls findBydgfFglPreDtlsByEnvClrMemoId_Last(
			long envClrMemoId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByEnvClrMemoId_Last(
			envClrMemoId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where envClrMemoId = &#63;.
	 *
	 * @param envClrMemoId the env clr memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls fetchBydgfFglPreDtlsByEnvClrMemoId_Last(
		long envClrMemoId, OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglPreDtlsByEnvClrMemoId_Last(
			envClrMemoId, orderByComparator);
	}

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where envClrMemoId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param envClrMemoId the env clr memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public static DgfFglPreDtls[] findBydgfFglPreDtlsByEnvClrMemoId_PrevAndNext(
			long fglPrePrimaryId, long envClrMemoId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByEnvClrMemoId_PrevAndNext(
			fglPrePrimaryId, envClrMemoId, orderByComparator);
	}

	/**
	 * Removes all the dgf fgl pre dtlses where envClrMemoId = &#63; from the database.
	 *
	 * @param envClrMemoId the env clr memo ID
	 */
	public static void removeBydgfFglPreDtlsByEnvClrMemoId(long envClrMemoId) {
		getPersistence().removeBydgfFglPreDtlsByEnvClrMemoId(envClrMemoId);
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where envClrMemoId = &#63;.
	 *
	 * @param envClrMemoId the env clr memo ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public static int countBydgfFglPreDtlsByEnvClrMemoId(long envClrMemoId) {
		return getPersistence().countBydgfFglPreDtlsByEnvClrMemoId(
			envClrMemoId);
	}

	/**
	 * Returns all the dgf fgl pre dtlses where bstiClrMemoId = &#63;.
	 *
	 * @param bstiClrMemoId the bsti clr memo ID
	 * @return the matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByBstiClrMemoId(
		long bstiClrMemoId) {

		return getPersistence().findBydgfFglPreDtlsByBstiClrMemoId(
			bstiClrMemoId);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses where bstiClrMemoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bstiClrMemoId the bsti clr memo ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByBstiClrMemoId(
		long bstiClrMemoId, int start, int end) {

		return getPersistence().findBydgfFglPreDtlsByBstiClrMemoId(
			bstiClrMemoId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where bstiClrMemoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bstiClrMemoId the bsti clr memo ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByBstiClrMemoId(
		long bstiClrMemoId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().findBydgfFglPreDtlsByBstiClrMemoId(
			bstiClrMemoId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where bstiClrMemoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param bstiClrMemoId the bsti clr memo ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByBstiClrMemoId(
		long bstiClrMemoId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydgfFglPreDtlsByBstiClrMemoId(
			bstiClrMemoId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where bstiClrMemoId = &#63;.
	 *
	 * @param bstiClrMemoId the bsti clr memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls findBydgfFglPreDtlsByBstiClrMemoId_First(
			long bstiClrMemoId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByBstiClrMemoId_First(
			bstiClrMemoId, orderByComparator);
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where bstiClrMemoId = &#63;.
	 *
	 * @param bstiClrMemoId the bsti clr memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls fetchBydgfFglPreDtlsByBstiClrMemoId_First(
		long bstiClrMemoId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglPreDtlsByBstiClrMemoId_First(
			bstiClrMemoId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where bstiClrMemoId = &#63;.
	 *
	 * @param bstiClrMemoId the bsti clr memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls findBydgfFglPreDtlsByBstiClrMemoId_Last(
			long bstiClrMemoId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByBstiClrMemoId_Last(
			bstiClrMemoId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where bstiClrMemoId = &#63;.
	 *
	 * @param bstiClrMemoId the bsti clr memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls fetchBydgfFglPreDtlsByBstiClrMemoId_Last(
		long bstiClrMemoId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglPreDtlsByBstiClrMemoId_Last(
			bstiClrMemoId, orderByComparator);
	}

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where bstiClrMemoId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param bstiClrMemoId the bsti clr memo ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public static DgfFglPreDtls[]
			findBydgfFglPreDtlsByBstiClrMemoId_PrevAndNext(
				long fglPrePrimaryId, long bstiClrMemoId,
				OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByBstiClrMemoId_PrevAndNext(
			fglPrePrimaryId, bstiClrMemoId, orderByComparator);
	}

	/**
	 * Removes all the dgf fgl pre dtlses where bstiClrMemoId = &#63; from the database.
	 *
	 * @param bstiClrMemoId the bsti clr memo ID
	 */
	public static void removeBydgfFglPreDtlsByBstiClrMemoId(
		long bstiClrMemoId) {

		getPersistence().removeBydgfFglPreDtlsByBstiClrMemoId(bstiClrMemoId);
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where bstiClrMemoId = &#63;.
	 *
	 * @param bstiClrMemoId the bsti clr memo ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public static int countBydgfFglPreDtlsByBstiClrMemoId(long bstiClrMemoId) {
		return getPersistence().countBydgfFglPreDtlsByBstiClrMemoId(
			bstiClrMemoId);
	}

	/**
	 * Returns all the dgf fgl pre dtlses where fireLicNumDocId = &#63;.
	 *
	 * @param fireLicNumDocId the fire lic num doc ID
	 * @return the matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByFireLicNumDocId(
		long fireLicNumDocId) {

		return getPersistence().findBydgfFglPreDtlsByFireLicNumDocId(
			fireLicNumDocId);
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses where fireLicNumDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param fireLicNumDocId the fire lic num doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByFireLicNumDocId(
		long fireLicNumDocId, int start, int end) {

		return getPersistence().findBydgfFglPreDtlsByFireLicNumDocId(
			fireLicNumDocId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where fireLicNumDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param fireLicNumDocId the fire lic num doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByFireLicNumDocId(
		long fireLicNumDocId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().findBydgfFglPreDtlsByFireLicNumDocId(
			fireLicNumDocId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses where fireLicNumDocId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param fireLicNumDocId the fire lic num doc ID
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findBydgfFglPreDtlsByFireLicNumDocId(
		long fireLicNumDocId, int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydgfFglPreDtlsByFireLicNumDocId(
			fireLicNumDocId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where fireLicNumDocId = &#63;.
	 *
	 * @param fireLicNumDocId the fire lic num doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls findBydgfFglPreDtlsByFireLicNumDocId_First(
			long fireLicNumDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByFireLicNumDocId_First(
			fireLicNumDocId, orderByComparator);
	}

	/**
	 * Returns the first dgf fgl pre dtls in the ordered set where fireLicNumDocId = &#63;.
	 *
	 * @param fireLicNumDocId the fire lic num doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls fetchBydgfFglPreDtlsByFireLicNumDocId_First(
		long fireLicNumDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglPreDtlsByFireLicNumDocId_First(
			fireLicNumDocId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where fireLicNumDocId = &#63;.
	 *
	 * @param fireLicNumDocId the fire lic num doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls findBydgfFglPreDtlsByFireLicNumDocId_Last(
			long fireLicNumDocId,
			OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findBydgfFglPreDtlsByFireLicNumDocId_Last(
			fireLicNumDocId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl pre dtls in the ordered set where fireLicNumDocId = &#63;.
	 *
	 * @param fireLicNumDocId the fire lic num doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl pre dtls, or <code>null</code> if a matching dgf fgl pre dtls could not be found
	 */
	public static DgfFglPreDtls fetchBydgfFglPreDtlsByFireLicNumDocId_Last(
		long fireLicNumDocId,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglPreDtlsByFireLicNumDocId_Last(
			fireLicNumDocId, orderByComparator);
	}

	/**
	 * Returns the dgf fgl pre dtlses before and after the current dgf fgl pre dtls in the ordered set where fireLicNumDocId = &#63;.
	 *
	 * @param fglPrePrimaryId the primary key of the current dgf fgl pre dtls
	 * @param fireLicNumDocId the fire lic num doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public static DgfFglPreDtls[]
			findBydgfFglPreDtlsByFireLicNumDocId_PrevAndNext(
				long fglPrePrimaryId, long fireLicNumDocId,
				OrderByComparator<DgfFglPreDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().
			findBydgfFglPreDtlsByFireLicNumDocId_PrevAndNext(
				fglPrePrimaryId, fireLicNumDocId, orderByComparator);
	}

	/**
	 * Removes all the dgf fgl pre dtlses where fireLicNumDocId = &#63; from the database.
	 *
	 * @param fireLicNumDocId the fire lic num doc ID
	 */
	public static void removeBydgfFglPreDtlsByFireLicNumDocId(
		long fireLicNumDocId) {

		getPersistence().removeBydgfFglPreDtlsByFireLicNumDocId(
			fireLicNumDocId);
	}

	/**
	 * Returns the number of dgf fgl pre dtlses where fireLicNumDocId = &#63;.
	 *
	 * @param fireLicNumDocId the fire lic num doc ID
	 * @return the number of matching dgf fgl pre dtlses
	 */
	public static int countBydgfFglPreDtlsByFireLicNumDocId(
		long fireLicNumDocId) {

		return getPersistence().countBydgfFglPreDtlsByFireLicNumDocId(
			fireLicNumDocId);
	}

	/**
	 * Caches the dgf fgl pre dtls in the entity cache if it is enabled.
	 *
	 * @param dgfFglPreDtls the dgf fgl pre dtls
	 */
	public static void cacheResult(DgfFglPreDtls dgfFglPreDtls) {
		getPersistence().cacheResult(dgfFglPreDtls);
	}

	/**
	 * Caches the dgf fgl pre dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfFglPreDtlses the dgf fgl pre dtlses
	 */
	public static void cacheResult(List<DgfFglPreDtls> dgfFglPreDtlses) {
		getPersistence().cacheResult(dgfFglPreDtlses);
	}

	/**
	 * Creates a new dgf fgl pre dtls with the primary key. Does not add the dgf fgl pre dtls to the database.
	 *
	 * @param fglPrePrimaryId the primary key for the new dgf fgl pre dtls
	 * @return the new dgf fgl pre dtls
	 */
	public static DgfFglPreDtls create(long fglPrePrimaryId) {
		return getPersistence().create(fglPrePrimaryId);
	}

	/**
	 * Removes the dgf fgl pre dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fglPrePrimaryId the primary key of the dgf fgl pre dtls
	 * @return the dgf fgl pre dtls that was removed
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public static DgfFglPreDtls remove(long fglPrePrimaryId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().remove(fglPrePrimaryId);
	}

	public static DgfFglPreDtls updateImpl(DgfFglPreDtls dgfFglPreDtls) {
		return getPersistence().updateImpl(dgfFglPreDtls);
	}

	/**
	 * Returns the dgf fgl pre dtls with the primary key or throws a <code>NoSuchDgfFglPreDtlsException</code> if it could not be found.
	 *
	 * @param fglPrePrimaryId the primary key of the dgf fgl pre dtls
	 * @return the dgf fgl pre dtls
	 * @throws NoSuchDgfFglPreDtlsException if a dgf fgl pre dtls with the primary key could not be found
	 */
	public static DgfFglPreDtls findByPrimaryKey(long fglPrePrimaryId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglPreDtlsException {

		return getPersistence().findByPrimaryKey(fglPrePrimaryId);
	}

	/**
	 * Returns the dgf fgl pre dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fglPrePrimaryId the primary key of the dgf fgl pre dtls
	 * @return the dgf fgl pre dtls, or <code>null</code> if a dgf fgl pre dtls with the primary key could not be found
	 */
	public static DgfFglPreDtls fetchByPrimaryKey(long fglPrePrimaryId) {
		return getPersistence().fetchByPrimaryKey(fglPrePrimaryId);
	}

	/**
	 * Returns all the dgf fgl pre dtlses.
	 *
	 * @return the dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dgf fgl pre dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @return the range of dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findAll(
		int start, int end,
		OrderByComparator<DgfFglPreDtls> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf fgl pre dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglPreDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl pre dtlses
	 * @param end the upper bound of the range of dgf fgl pre dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf fgl pre dtlses
	 */
	public static List<DgfFglPreDtls> findAll(
		int start, int end, OrderByComparator<DgfFglPreDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dgf fgl pre dtlses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dgf fgl pre dtlses.
	 *
	 * @return the number of dgf fgl pre dtlses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DgfFglPreDtlsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DgfFglPreDtlsPersistence _persistence;

}