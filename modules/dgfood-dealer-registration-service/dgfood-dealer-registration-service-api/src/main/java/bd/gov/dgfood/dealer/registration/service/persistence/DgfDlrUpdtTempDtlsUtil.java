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

import bd.gov.dgfood.dealer.registration.model.DgfDlrUpdtTempDtls;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dgf dlr updt temp dtls service. This utility wraps <code>bd.gov.dgfood.dealer.registration.service.persistence.impl.DgfDlrUpdtTempDtlsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfDlrUpdtTempDtlsPersistence
 * @generated
 */
public class DgfDlrUpdtTempDtlsUtil {

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
	public static void clearCache(DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls) {
		getPersistence().clearCache(dgfDlrUpdtTempDtls);
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
	public static Map<Serializable, DgfDlrUpdtTempDtls> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DgfDlrUpdtTempDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DgfDlrUpdtTempDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DgfDlrUpdtTempDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DgfDlrUpdtTempDtls update(
		DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls) {

		return getPersistence().update(dgfDlrUpdtTempDtls);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DgfDlrUpdtTempDtls update(
		DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls, ServiceContext serviceContext) {

		return getPersistence().update(dgfDlrUpdtTempDtls, serviceContext);
	}

	/**
	 * Returns all the dgf dlr updt temp dtlses where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the matching dgf dlr updt temp dtlses
	 */
	public static List<DgfDlrUpdtTempDtls> findByDgfDlrUpdtTempDtlsByRegNo(
		long dlrRegNo) {

		return getPersistence().findByDgfDlrUpdtTempDtlsByRegNo(dlrRegNo);
	}

	/**
	 * Returns a range of all the dgf dlr updt temp dtlses where dlrRegNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrUpdtTempDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param start the lower bound of the range of dgf dlr updt temp dtlses
	 * @param end the upper bound of the range of dgf dlr updt temp dtlses (not inclusive)
	 * @return the range of matching dgf dlr updt temp dtlses
	 */
	public static List<DgfDlrUpdtTempDtls> findByDgfDlrUpdtTempDtlsByRegNo(
		long dlrRegNo, int start, int end) {

		return getPersistence().findByDgfDlrUpdtTempDtlsByRegNo(
			dlrRegNo, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf dlr updt temp dtlses where dlrRegNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrUpdtTempDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param start the lower bound of the range of dgf dlr updt temp dtlses
	 * @param end the upper bound of the range of dgf dlr updt temp dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf dlr updt temp dtlses
	 */
	public static List<DgfDlrUpdtTempDtls> findByDgfDlrUpdtTempDtlsByRegNo(
		long dlrRegNo, int start, int end,
		OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator) {

		return getPersistence().findByDgfDlrUpdtTempDtlsByRegNo(
			dlrRegNo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf dlr updt temp dtlses where dlrRegNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrUpdtTempDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param start the lower bound of the range of dgf dlr updt temp dtlses
	 * @param end the upper bound of the range of dgf dlr updt temp dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf dlr updt temp dtlses
	 */
	public static List<DgfDlrUpdtTempDtls> findByDgfDlrUpdtTempDtlsByRegNo(
		long dlrRegNo, int start, int end,
		OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDgfDlrUpdtTempDtlsByRegNo(
			dlrRegNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf dlr updt temp dtls in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr updt temp dtls
	 * @throws NoSuchDgfDlrUpdtTempDtlsException if a matching dgf dlr updt temp dtls could not be found
	 */
	public static DgfDlrUpdtTempDtls findByDgfDlrUpdtTempDtlsByRegNo_First(
			long dlrRegNo,
			OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrUpdtTempDtlsException {

		return getPersistence().findByDgfDlrUpdtTempDtlsByRegNo_First(
			dlrRegNo, orderByComparator);
	}

	/**
	 * Returns the first dgf dlr updt temp dtls in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr updt temp dtls, or <code>null</code> if a matching dgf dlr updt temp dtls could not be found
	 */
	public static DgfDlrUpdtTempDtls fetchByDgfDlrUpdtTempDtlsByRegNo_First(
		long dlrRegNo,
		OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator) {

		return getPersistence().fetchByDgfDlrUpdtTempDtlsByRegNo_First(
			dlrRegNo, orderByComparator);
	}

	/**
	 * Returns the last dgf dlr updt temp dtls in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr updt temp dtls
	 * @throws NoSuchDgfDlrUpdtTempDtlsException if a matching dgf dlr updt temp dtls could not be found
	 */
	public static DgfDlrUpdtTempDtls findByDgfDlrUpdtTempDtlsByRegNo_Last(
			long dlrRegNo,
			OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrUpdtTempDtlsException {

		return getPersistence().findByDgfDlrUpdtTempDtlsByRegNo_Last(
			dlrRegNo, orderByComparator);
	}

	/**
	 * Returns the last dgf dlr updt temp dtls in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr updt temp dtls, or <code>null</code> if a matching dgf dlr updt temp dtls could not be found
	 */
	public static DgfDlrUpdtTempDtls fetchByDgfDlrUpdtTempDtlsByRegNo_Last(
		long dlrRegNo,
		OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator) {

		return getPersistence().fetchByDgfDlrUpdtTempDtlsByRegNo_Last(
			dlrRegNo, orderByComparator);
	}

	/**
	 * Returns the dgf dlr updt temp dtlses before and after the current dgf dlr updt temp dtls in the ordered set where dlrRegNo = &#63;.
	 *
	 * @param dgfDlrUpdateReqId the primary key of the current dgf dlr updt temp dtls
	 * @param dlrRegNo the dlr reg no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf dlr updt temp dtls
	 * @throws NoSuchDgfDlrUpdtTempDtlsException if a dgf dlr updt temp dtls with the primary key could not be found
	 */
	public static DgfDlrUpdtTempDtls[]
			findByDgfDlrUpdtTempDtlsByRegNo_PrevAndNext(
				long dgfDlrUpdateReqId, long dlrRegNo,
				OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrUpdtTempDtlsException {

		return getPersistence().findByDgfDlrUpdtTempDtlsByRegNo_PrevAndNext(
			dgfDlrUpdateReqId, dlrRegNo, orderByComparator);
	}

	/**
	 * Removes all the dgf dlr updt temp dtlses where dlrRegNo = &#63; from the database.
	 *
	 * @param dlrRegNo the dlr reg no
	 */
	public static void removeByDgfDlrUpdtTempDtlsByRegNo(long dlrRegNo) {
		getPersistence().removeByDgfDlrUpdtTempDtlsByRegNo(dlrRegNo);
	}

	/**
	 * Returns the number of dgf dlr updt temp dtlses where dlrRegNo = &#63;.
	 *
	 * @param dlrRegNo the dlr reg no
	 * @return the number of matching dgf dlr updt temp dtlses
	 */
	public static int countByDgfDlrUpdtTempDtlsByRegNo(long dlrRegNo) {
		return getPersistence().countByDgfDlrUpdtTempDtlsByRegNo(dlrRegNo);
	}

	/**
	 * Returns all the dgf dlr updt temp dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf dlr updt temp dtlses
	 */
	public static List<DgfDlrUpdtTempDtls> findByDgfDlrUpdtTempDtlsByNid(
		String nationalId) {

		return getPersistence().findByDgfDlrUpdtTempDtlsByNid(nationalId);
	}

	/**
	 * Returns a range of all the dgf dlr updt temp dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrUpdtTempDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr updt temp dtlses
	 * @param end the upper bound of the range of dgf dlr updt temp dtlses (not inclusive)
	 * @return the range of matching dgf dlr updt temp dtlses
	 */
	public static List<DgfDlrUpdtTempDtls> findByDgfDlrUpdtTempDtlsByNid(
		String nationalId, int start, int end) {

		return getPersistence().findByDgfDlrUpdtTempDtlsByNid(
			nationalId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf dlr updt temp dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrUpdtTempDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr updt temp dtlses
	 * @param end the upper bound of the range of dgf dlr updt temp dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf dlr updt temp dtlses
	 */
	public static List<DgfDlrUpdtTempDtls> findByDgfDlrUpdtTempDtlsByNid(
		String nationalId, int start, int end,
		OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator) {

		return getPersistence().findByDgfDlrUpdtTempDtlsByNid(
			nationalId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf dlr updt temp dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrUpdtTempDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf dlr updt temp dtlses
	 * @param end the upper bound of the range of dgf dlr updt temp dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf dlr updt temp dtlses
	 */
	public static List<DgfDlrUpdtTempDtls> findByDgfDlrUpdtTempDtlsByNid(
		String nationalId, int start, int end,
		OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDgfDlrUpdtTempDtlsByNid(
			nationalId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf dlr updt temp dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr updt temp dtls
	 * @throws NoSuchDgfDlrUpdtTempDtlsException if a matching dgf dlr updt temp dtls could not be found
	 */
	public static DgfDlrUpdtTempDtls findByDgfDlrUpdtTempDtlsByNid_First(
			String nationalId,
			OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrUpdtTempDtlsException {

		return getPersistence().findByDgfDlrUpdtTempDtlsByNid_First(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the first dgf dlr updt temp dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf dlr updt temp dtls, or <code>null</code> if a matching dgf dlr updt temp dtls could not be found
	 */
	public static DgfDlrUpdtTempDtls fetchByDgfDlrUpdtTempDtlsByNid_First(
		String nationalId,
		OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator) {

		return getPersistence().fetchByDgfDlrUpdtTempDtlsByNid_First(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the last dgf dlr updt temp dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr updt temp dtls
	 * @throws NoSuchDgfDlrUpdtTempDtlsException if a matching dgf dlr updt temp dtls could not be found
	 */
	public static DgfDlrUpdtTempDtls findByDgfDlrUpdtTempDtlsByNid_Last(
			String nationalId,
			OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrUpdtTempDtlsException {

		return getPersistence().findByDgfDlrUpdtTempDtlsByNid_Last(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the last dgf dlr updt temp dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf dlr updt temp dtls, or <code>null</code> if a matching dgf dlr updt temp dtls could not be found
	 */
	public static DgfDlrUpdtTempDtls fetchByDgfDlrUpdtTempDtlsByNid_Last(
		String nationalId,
		OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator) {

		return getPersistence().fetchByDgfDlrUpdtTempDtlsByNid_Last(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the dgf dlr updt temp dtlses before and after the current dgf dlr updt temp dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param dgfDlrUpdateReqId the primary key of the current dgf dlr updt temp dtls
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf dlr updt temp dtls
	 * @throws NoSuchDgfDlrUpdtTempDtlsException if a dgf dlr updt temp dtls with the primary key could not be found
	 */
	public static DgfDlrUpdtTempDtls[]
			findByDgfDlrUpdtTempDtlsByNid_PrevAndNext(
				long dgfDlrUpdateReqId, String nationalId,
				OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrUpdtTempDtlsException {

		return getPersistence().findByDgfDlrUpdtTempDtlsByNid_PrevAndNext(
			dgfDlrUpdateReqId, nationalId, orderByComparator);
	}

	/**
	 * Removes all the dgf dlr updt temp dtlses where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	public static void removeByDgfDlrUpdtTempDtlsByNid(String nationalId) {
		getPersistence().removeByDgfDlrUpdtTempDtlsByNid(nationalId);
	}

	/**
	 * Returns the number of dgf dlr updt temp dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf dlr updt temp dtlses
	 */
	public static int countByDgfDlrUpdtTempDtlsByNid(String nationalId) {
		return getPersistence().countByDgfDlrUpdtTempDtlsByNid(nationalId);
	}

	/**
	 * Caches the dgf dlr updt temp dtls in the entity cache if it is enabled.
	 *
	 * @param dgfDlrUpdtTempDtls the dgf dlr updt temp dtls
	 */
	public static void cacheResult(DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls) {
		getPersistence().cacheResult(dgfDlrUpdtTempDtls);
	}

	/**
	 * Caches the dgf dlr updt temp dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfDlrUpdtTempDtlses the dgf dlr updt temp dtlses
	 */
	public static void cacheResult(
		List<DgfDlrUpdtTempDtls> dgfDlrUpdtTempDtlses) {

		getPersistence().cacheResult(dgfDlrUpdtTempDtlses);
	}

	/**
	 * Creates a new dgf dlr updt temp dtls with the primary key. Does not add the dgf dlr updt temp dtls to the database.
	 *
	 * @param dgfDlrUpdateReqId the primary key for the new dgf dlr updt temp dtls
	 * @return the new dgf dlr updt temp dtls
	 */
	public static DgfDlrUpdtTempDtls create(long dgfDlrUpdateReqId) {
		return getPersistence().create(dgfDlrUpdateReqId);
	}

	/**
	 * Removes the dgf dlr updt temp dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dgfDlrUpdateReqId the primary key of the dgf dlr updt temp dtls
	 * @return the dgf dlr updt temp dtls that was removed
	 * @throws NoSuchDgfDlrUpdtTempDtlsException if a dgf dlr updt temp dtls with the primary key could not be found
	 */
	public static DgfDlrUpdtTempDtls remove(long dgfDlrUpdateReqId)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrUpdtTempDtlsException {

		return getPersistence().remove(dgfDlrUpdateReqId);
	}

	public static DgfDlrUpdtTempDtls updateImpl(
		DgfDlrUpdtTempDtls dgfDlrUpdtTempDtls) {

		return getPersistence().updateImpl(dgfDlrUpdtTempDtls);
	}

	/**
	 * Returns the dgf dlr updt temp dtls with the primary key or throws a <code>NoSuchDgfDlrUpdtTempDtlsException</code> if it could not be found.
	 *
	 * @param dgfDlrUpdateReqId the primary key of the dgf dlr updt temp dtls
	 * @return the dgf dlr updt temp dtls
	 * @throws NoSuchDgfDlrUpdtTempDtlsException if a dgf dlr updt temp dtls with the primary key could not be found
	 */
	public static DgfDlrUpdtTempDtls findByPrimaryKey(long dgfDlrUpdateReqId)
		throws bd.gov.dgfood.dealer.registration.exception.
			NoSuchDgfDlrUpdtTempDtlsException {

		return getPersistence().findByPrimaryKey(dgfDlrUpdateReqId);
	}

	/**
	 * Returns the dgf dlr updt temp dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dgfDlrUpdateReqId the primary key of the dgf dlr updt temp dtls
	 * @return the dgf dlr updt temp dtls, or <code>null</code> if a dgf dlr updt temp dtls with the primary key could not be found
	 */
	public static DgfDlrUpdtTempDtls fetchByPrimaryKey(long dgfDlrUpdateReqId) {
		return getPersistence().fetchByPrimaryKey(dgfDlrUpdateReqId);
	}

	/**
	 * Returns all the dgf dlr updt temp dtlses.
	 *
	 * @return the dgf dlr updt temp dtlses
	 */
	public static List<DgfDlrUpdtTempDtls> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dgf dlr updt temp dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrUpdtTempDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr updt temp dtlses
	 * @param end the upper bound of the range of dgf dlr updt temp dtlses (not inclusive)
	 * @return the range of dgf dlr updt temp dtlses
	 */
	public static List<DgfDlrUpdtTempDtls> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dgf dlr updt temp dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrUpdtTempDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr updt temp dtlses
	 * @param end the upper bound of the range of dgf dlr updt temp dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf dlr updt temp dtlses
	 */
	public static List<DgfDlrUpdtTempDtls> findAll(
		int start, int end,
		OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf dlr updt temp dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfDlrUpdtTempDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf dlr updt temp dtlses
	 * @param end the upper bound of the range of dgf dlr updt temp dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf dlr updt temp dtlses
	 */
	public static List<DgfDlrUpdtTempDtls> findAll(
		int start, int end,
		OrderByComparator<DgfDlrUpdtTempDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dgf dlr updt temp dtlses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dgf dlr updt temp dtlses.
	 *
	 * @return the number of dgf dlr updt temp dtlses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DgfDlrUpdtTempDtlsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DgfDlrUpdtTempDtlsPersistence _persistence;

}