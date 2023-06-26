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

import bd.gov.dgfood.dealer.registration.model.DgfDlrRegAddlDtls;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dgf dlr reg addl dtls service. This utility wraps <code>bd.gov.dgfood.dealer.registration.service.persistence.impl.DgfDlrRegAddlDtlsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrRegAddlDtlsPersistence
 * @generated
 */
public class DgfDlrRegAddlDtlsUtil {

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
	public static void clearCache(DgfDlrRegAddlDtls dgfDlrRegAddlDtls) {
		getPersistence().clearCache(dgfDlrRegAddlDtls);
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
	public static Map<Serializable, DgfDlrRegAddlDtls> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DgfDlrRegAddlDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DgfDlrRegAddlDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DgfDlrRegAddlDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DgfDlrRegAddlDtls> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DgfDlrRegAddlDtls update(
		DgfDlrRegAddlDtls dgfDlrRegAddlDtls) {

		return getPersistence().update(dgfDlrRegAddlDtls);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DgfDlrRegAddlDtls update(
		DgfDlrRegAddlDtls dgfDlrRegAddlDtls, ServiceContext serviceContext) {

		return getPersistence().update(dgfDlrRegAddlDtls, serviceContext);
	}

	/**
	 * Returns the dgf dlr reg addl dtls where dlrRegNo = &#63; or throws a <code>NoSuchDgfDlrRegAddlDtlsException</code> if it could not be found.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the matching dgf dlr reg addl dtls
	 * @throws NoSuchDgfDlrRegAddlDtlsException if a matching dgf dlr reg addl dtls could not be found
	 */
	public static DgfDlrRegAddlDtls findByDgfDlrRegAddlDtlsByRegNo(
			long dlrRegNo)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrRegAddlDtlsException {

		return getPersistence().findByDgfDlrRegAddlDtlsByRegNo(dlrRegNo);
	}

	/**
	 * Returns the dgf dlr reg addl dtls where dlrRegNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the matching dgf dlr reg addl dtls, or <code>null</code> if a matching dgf dlr reg addl dtls could not be found
	 */
	public static DgfDlrRegAddlDtls fetchByDgfDlrRegAddlDtlsByRegNo(
		long dlrRegNo) {

		return getPersistence().fetchByDgfDlrRegAddlDtlsByRegNo(dlrRegNo);
	}

	/**
	 * Returns the dgf dlr reg addl dtls where dlrRegNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf dlr reg addl dtls, or <code>null</code> if a matching dgf dlr reg addl dtls could not be found
	 */
	public static DgfDlrRegAddlDtls fetchByDgfDlrRegAddlDtlsByRegNo(
		long dlrRegNo, boolean useFinderCache) {

		return getPersistence().fetchByDgfDlrRegAddlDtlsByRegNo(
			dlrRegNo, useFinderCache);
	}

	/**
	 * Removes the dgf dlr reg addl dtls where dlrRegNo = &#63; from the database.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the dgf dlr reg addl dtls that was removed
	 */
	public static DgfDlrRegAddlDtls removeByDgfDlrRegAddlDtlsByRegNo(
			long dlrRegNo)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrRegAddlDtlsException {

		return getPersistence().removeByDgfDlrRegAddlDtlsByRegNo(dlrRegNo);
	}

	/**
	 * Returns the number of dgf dlr reg addl dtlses where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the number of matching dgf dlr reg addl dtlses
	 */
	public static int countByDgfDlrRegAddlDtlsByRegNo(long dlrRegNo) {
		return getPersistence().countByDgfDlrRegAddlDtlsByRegNo(dlrRegNo);
	}

	/**
	 * Returns all the dgf dlr reg addl dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf dlr reg addl dtlses
	 */
	public static List<DgfDlrRegAddlDtls> findByDgfDlrRegAddlDtlsByNid(
		String nationalId) {

		return getPersistence().findByDgfDlrRegAddlDtlsByNid(nationalId);
	}

	/**
	 * Returns a range of all the dgf dlr reg addl dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrRegAddlDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr reg addl dtlses
	 * @param end the upper bound of the range of dgf dlr reg addl dtlses (not inclusive)
	 * @return the range of matching dgf dlr reg addl dtlses
	 */
	public static List<DgfDlrRegAddlDtls> findByDgfDlrRegAddlDtlsByNid(
		String nationalId, int start, int end) {

		return getPersistence().findByDgfDlrRegAddlDtlsByNid(
			nationalId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf dlr reg addl dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrRegAddlDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr reg addl dtlses
	 * @param end the upper bound of the range of dgf dlr reg addl dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf dlr reg addl dtlses
	 */
	public static List<DgfDlrRegAddlDtls> findByDgfDlrRegAddlDtlsByNid(
		String nationalId, int start, int end,
		OrderByComparator<DgfDlrRegAddlDtls> orderByComparator) {

		return getPersistence().findByDgfDlrRegAddlDtlsByNid(
			nationalId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf dlr reg addl dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrRegAddlDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr reg addl dtlses
	 * @param end the upper bound of the range of dgf dlr reg addl dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf dlr reg addl dtlses
	 */
	public static List<DgfDlrRegAddlDtls> findByDgfDlrRegAddlDtlsByNid(
		String nationalId, int start, int end,
		OrderByComparator<DgfDlrRegAddlDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDgfDlrRegAddlDtlsByNid(
			nationalId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf dlr reg addl dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr reg addl dtls
	 * @throws NoSuchDgfDlrRegAddlDtlsException if a matching dgf dlr reg addl dtls could not be found
	 */
	public static DgfDlrRegAddlDtls findByDgfDlrRegAddlDtlsByNid_First(
			String nationalId,
			OrderByComparator<DgfDlrRegAddlDtls> orderByComparator)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrRegAddlDtlsException {

		return getPersistence().findByDgfDlrRegAddlDtlsByNid_First(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the first dgf dlr reg addl dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr reg addl dtls, or <code>null</code> if a matching dgf dlr reg addl dtls could not be found
	 */
	public static DgfDlrRegAddlDtls fetchByDgfDlrRegAddlDtlsByNid_First(
		String nationalId,
		OrderByComparator<DgfDlrRegAddlDtls> orderByComparator) {

		return getPersistence().fetchByDgfDlrRegAddlDtlsByNid_First(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the last dgf dlr reg addl dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr reg addl dtls
	 * @throws NoSuchDgfDlrRegAddlDtlsException if a matching dgf dlr reg addl dtls could not be found
	 */
	public static DgfDlrRegAddlDtls findByDgfDlrRegAddlDtlsByNid_Last(
			String nationalId,
			OrderByComparator<DgfDlrRegAddlDtls> orderByComparator)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrRegAddlDtlsException {

		return getPersistence().findByDgfDlrRegAddlDtlsByNid_Last(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the last dgf dlr reg addl dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr reg addl dtls, or <code>null</code> if a matching dgf dlr reg addl dtls could not be found
	 */
	public static DgfDlrRegAddlDtls fetchByDgfDlrRegAddlDtlsByNid_Last(
		String nationalId,
		OrderByComparator<DgfDlrRegAddlDtls> orderByComparator) {

		return getPersistence().fetchByDgfDlrRegAddlDtlsByNid_Last(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the dgf dlr reg addl dtlses before and after the current dgf dlr reg addl dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param dlrRegAddlDtlsId the primary key of the current dgf dlr reg addl dtls
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf dlr reg addl dtls
	 * @throws NoSuchDgfDlrRegAddlDtlsException if a dgf dlr reg addl dtls with the primary key could not be found
	 */
	public static DgfDlrRegAddlDtls[] findByDgfDlrRegAddlDtlsByNid_PrevAndNext(
			long dlrRegAddlDtlsId, String nationalId,
			OrderByComparator<DgfDlrRegAddlDtls> orderByComparator)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrRegAddlDtlsException {

		return getPersistence().findByDgfDlrRegAddlDtlsByNid_PrevAndNext(
			dlrRegAddlDtlsId, nationalId, orderByComparator);
	}

	/**
	 * Removes all the dgf dlr reg addl dtlses where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	public static void removeByDgfDlrRegAddlDtlsByNid(String nationalId) {
		getPersistence().removeByDgfDlrRegAddlDtlsByNid(nationalId);
	}

	/**
	 * Returns the number of dgf dlr reg addl dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf dlr reg addl dtlses
	 */
	public static int countByDgfDlrRegAddlDtlsByNid(String nationalId) {
		return getPersistence().countByDgfDlrRegAddlDtlsByNid(nationalId);
	}

	/**
	 * Caches the dgf dlr reg addl dtls in the entity cache if it is enabled.
	 *
	 * @param dgfDlrRegAddlDtls the dgf dlr reg addl dtls
	 */
	public static void cacheResult(DgfDlrRegAddlDtls dgfDlrRegAddlDtls) {
		getPersistence().cacheResult(dgfDlrRegAddlDtls);
	}

	/**
	 * Caches the dgf dlr reg addl dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfDlrRegAddlDtlses the dgf dlr reg addl dtlses
	 */
	public static void cacheResult(
		List<DgfDlrRegAddlDtls> dgfDlrRegAddlDtlses) {

		getPersistence().cacheResult(dgfDlrRegAddlDtlses);
	}

	/**
	 * Creates a new dgf dlr reg addl dtls with the primary key. Does not add the dgf dlr reg addl dtls to the database.
	 *
	 * @param dlrRegAddlDtlsId the primary key for the new dgf dlr reg addl dtls
	 * @return the new dgf dlr reg addl dtls
	 */
	public static DgfDlrRegAddlDtls create(long dlrRegAddlDtlsId) {
		return getPersistence().create(dlrRegAddlDtlsId);
	}

	/**
	 * Removes the dgf dlr reg addl dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dlrRegAddlDtlsId the primary key of the dgf dlr reg addl dtls
	 * @return the dgf dlr reg addl dtls that was removed
	 * @throws NoSuchDgfDlrRegAddlDtlsException if a dgf dlr reg addl dtls with the primary key could not be found
	 */
	public static DgfDlrRegAddlDtls remove(long dlrRegAddlDtlsId)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrRegAddlDtlsException {

		return getPersistence().remove(dlrRegAddlDtlsId);
	}

	public static DgfDlrRegAddlDtls updateImpl(
		DgfDlrRegAddlDtls dgfDlrRegAddlDtls) {

		return getPersistence().updateImpl(dgfDlrRegAddlDtls);
	}

	/**
	 * Returns the dgf dlr reg addl dtls with the primary key or throws a <code>NoSuchDgfDlrRegAddlDtlsException</code> if it could not be found.
	 *
	 * @param dlrRegAddlDtlsId the primary key of the dgf dlr reg addl dtls
	 * @return the dgf dlr reg addl dtls
	 * @throws NoSuchDgfDlrRegAddlDtlsException if a dgf dlr reg addl dtls with the primary key could not be found
	 */
	public static DgfDlrRegAddlDtls findByPrimaryKey(long dlrRegAddlDtlsId)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrRegAddlDtlsException {

		return getPersistence().findByPrimaryKey(dlrRegAddlDtlsId);
	}

	/**
	 * Returns the dgf dlr reg addl dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dlrRegAddlDtlsId the primary key of the dgf dlr reg addl dtls
	 * @return the dgf dlr reg addl dtls, or <code>null</code> if a dgf dlr reg addl dtls with the primary key could not be found
	 */
	public static DgfDlrRegAddlDtls fetchByPrimaryKey(long dlrRegAddlDtlsId) {
		return getPersistence().fetchByPrimaryKey(dlrRegAddlDtlsId);
	}

	/**
	 * Returns all the dgf dlr reg addl dtlses.
	 *
	 * @return the dgf dlr reg addl dtlses
	 */
	public static List<DgfDlrRegAddlDtls> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dgf dlr reg addl dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrRegAddlDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr reg addl dtlses
	 * @param end the upper bound of the range of dgf dlr reg addl dtlses (not inclusive)
	 * @return the range of dgf dlr reg addl dtlses
	 */
	public static List<DgfDlrRegAddlDtls> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dgf dlr reg addl dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrRegAddlDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr reg addl dtlses
	 * @param end the upper bound of the range of dgf dlr reg addl dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf dlr reg addl dtlses
	 */
	public static List<DgfDlrRegAddlDtls> findAll(
		int start, int end,
		OrderByComparator<DgfDlrRegAddlDtls> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf dlr reg addl dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrRegAddlDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr reg addl dtlses
	 * @param end the upper bound of the range of dgf dlr reg addl dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf dlr reg addl dtlses
	 */
	public static List<DgfDlrRegAddlDtls> findAll(
		int start, int end,
		OrderByComparator<DgfDlrRegAddlDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dgf dlr reg addl dtlses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dgf dlr reg addl dtlses.
	 *
	 * @return the number of dgf dlr reg addl dtlses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DgfDlrRegAddlDtlsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DgfDlrRegAddlDtlsPersistence _persistence;

}