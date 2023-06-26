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

import bd.gov.dgfood.food.grain.license.model.DgfFglProductDtls;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dgf fgl product dtls service. This utility wraps <code>bd.gov.dgfood.food.grain.license.service.persistence.impl.DgfFglProductDtlsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfFglProductDtlsPersistence
 * @generated
 */
public class DgfFglProductDtlsUtil {

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
	public static void clearCache(DgfFglProductDtls dgfFglProductDtls) {
		getPersistence().clearCache(dgfFglProductDtls);
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
	public static Map<Serializable, DgfFglProductDtls> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DgfFglProductDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DgfFglProductDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DgfFglProductDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DgfFglProductDtls> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DgfFglProductDtls update(
		DgfFglProductDtls dgfFglProductDtls) {

		return getPersistence().update(dgfFglProductDtls);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DgfFglProductDtls update(
		DgfFglProductDtls dgfFglProductDtls, ServiceContext serviceContext) {

		return getPersistence().update(dgfFglProductDtls, serviceContext);
	}

	/**
	 * Returns all the dgf fgl product dtlses where fglLicPrimaryId = &#63;.
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID
	 * @return the matching dgf fgl product dtlses
	 */
	public static List<DgfFglProductDtls>
		findBydgfFglProductDtlsByFglLicPrimaryId(long fglLicPrimaryId) {

		return getPersistence().findBydgfFglProductDtlsByFglLicPrimaryId(
			fglLicPrimaryId);
	}

	/**
	 * Returns a range of all the dgf fgl product dtlses where fglLicPrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglProductDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID
	 * @param start the lower bound of the range of dgf fgl product dtlses
	 * @param end the upper bound of the range of dgf fgl product dtlses (not inclusive)
	 * @return the range of matching dgf fgl product dtlses
	 */
	public static List<DgfFglProductDtls>
		findBydgfFglProductDtlsByFglLicPrimaryId(
			long fglLicPrimaryId, int start, int end) {

		return getPersistence().findBydgfFglProductDtlsByFglLicPrimaryId(
			fglLicPrimaryId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf fgl product dtlses where fglLicPrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglProductDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID
	 * @param start the lower bound of the range of dgf fgl product dtlses
	 * @param end the upper bound of the range of dgf fgl product dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl product dtlses
	 */
	public static List<DgfFglProductDtls>
		findBydgfFglProductDtlsByFglLicPrimaryId(
			long fglLicPrimaryId, int start, int end,
			OrderByComparator<DgfFglProductDtls> orderByComparator) {

		return getPersistence().findBydgfFglProductDtlsByFglLicPrimaryId(
			fglLicPrimaryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf fgl product dtlses where fglLicPrimaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglProductDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID
	 * @param start the lower bound of the range of dgf fgl product dtlses
	 * @param end the upper bound of the range of dgf fgl product dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl product dtlses
	 */
	public static List<DgfFglProductDtls>
		findBydgfFglProductDtlsByFglLicPrimaryId(
			long fglLicPrimaryId, int start, int end,
			OrderByComparator<DgfFglProductDtls> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findBydgfFglProductDtlsByFglLicPrimaryId(
			fglLicPrimaryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf fgl product dtls in the ordered set where fglLicPrimaryId = &#63;.
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl product dtls
	 * @throws NoSuchDgfFglProductDtlsException if a matching dgf fgl product dtls could not be found
	 */
	public static DgfFglProductDtls
			findBydgfFglProductDtlsByFglLicPrimaryId_First(
				long fglLicPrimaryId,
				OrderByComparator<DgfFglProductDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglProductDtlsException {

		return getPersistence().findBydgfFglProductDtlsByFglLicPrimaryId_First(
			fglLicPrimaryId, orderByComparator);
	}

	/**
	 * Returns the first dgf fgl product dtls in the ordered set where fglLicPrimaryId = &#63;.
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl product dtls, or <code>null</code> if a matching dgf fgl product dtls could not be found
	 */
	public static DgfFglProductDtls
		fetchBydgfFglProductDtlsByFglLicPrimaryId_First(
			long fglLicPrimaryId,
			OrderByComparator<DgfFglProductDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglProductDtlsByFglLicPrimaryId_First(
			fglLicPrimaryId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl product dtls in the ordered set where fglLicPrimaryId = &#63;.
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl product dtls
	 * @throws NoSuchDgfFglProductDtlsException if a matching dgf fgl product dtls could not be found
	 */
	public static DgfFglProductDtls
			findBydgfFglProductDtlsByFglLicPrimaryId_Last(
				long fglLicPrimaryId,
				OrderByComparator<DgfFglProductDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglProductDtlsException {

		return getPersistence().findBydgfFglProductDtlsByFglLicPrimaryId_Last(
			fglLicPrimaryId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl product dtls in the ordered set where fglLicPrimaryId = &#63;.
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl product dtls, or <code>null</code> if a matching dgf fgl product dtls could not be found
	 */
	public static DgfFglProductDtls
		fetchBydgfFglProductDtlsByFglLicPrimaryId_Last(
			long fglLicPrimaryId,
			OrderByComparator<DgfFglProductDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglProductDtlsByFglLicPrimaryId_Last(
			fglLicPrimaryId, orderByComparator);
	}

	/**
	 * Returns the dgf fgl product dtlses before and after the current dgf fgl product dtls in the ordered set where fglLicPrimaryId = &#63;.
	 *
	 * @param fglProductPrimaryId the primary key of the current dgf fgl product dtls
	 * @param fglLicPrimaryId the fgl lic primary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl product dtls
	 * @throws NoSuchDgfFglProductDtlsException if a dgf fgl product dtls with the primary key could not be found
	 */
	public static DgfFglProductDtls[]
			findBydgfFglProductDtlsByFglLicPrimaryId_PrevAndNext(
				long fglProductPrimaryId, long fglLicPrimaryId,
				OrderByComparator<DgfFglProductDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglProductDtlsException {

		return getPersistence().
			findBydgfFglProductDtlsByFglLicPrimaryId_PrevAndNext(
				fglProductPrimaryId, fglLicPrimaryId, orderByComparator);
	}

	/**
	 * Removes all the dgf fgl product dtlses where fglLicPrimaryId = &#63; from the database.
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID
	 */
	public static void removeBydgfFglProductDtlsByFglLicPrimaryId(
		long fglLicPrimaryId) {

		getPersistence().removeBydgfFglProductDtlsByFglLicPrimaryId(
			fglLicPrimaryId);
	}

	/**
	 * Returns the number of dgf fgl product dtlses where fglLicPrimaryId = &#63;.
	 *
	 * @param fglLicPrimaryId the fgl lic primary ID
	 * @return the number of matching dgf fgl product dtlses
	 */
	public static int countBydgfFglProductDtlsByFglLicPrimaryId(
		long fglLicPrimaryId) {

		return getPersistence().countBydgfFglProductDtlsByFglLicPrimaryId(
			fglLicPrimaryId);
	}

	/**
	 * Returns all the dgf fgl product dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf fgl product dtlses
	 */
	public static List<DgfFglProductDtls> findBydgfFglProductDtlsByNationalId(
		String nationalId) {

		return getPersistence().findBydgfFglProductDtlsByNationalId(nationalId);
	}

	/**
	 * Returns a range of all the dgf fgl product dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglProductDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf fgl product dtlses
	 * @param end the upper bound of the range of dgf fgl product dtlses (not inclusive)
	 * @return the range of matching dgf fgl product dtlses
	 */
	public static List<DgfFglProductDtls> findBydgfFglProductDtlsByNationalId(
		String nationalId, int start, int end) {

		return getPersistence().findBydgfFglProductDtlsByNationalId(
			nationalId, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf fgl product dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglProductDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf fgl product dtlses
	 * @param end the upper bound of the range of dgf fgl product dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf fgl product dtlses
	 */
	public static List<DgfFglProductDtls> findBydgfFglProductDtlsByNationalId(
		String nationalId, int start, int end,
		OrderByComparator<DgfFglProductDtls> orderByComparator) {

		return getPersistence().findBydgfFglProductDtlsByNationalId(
			nationalId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf fgl product dtlses where nationalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglProductDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param nationalId the national ID
	 * @param start the lower bound of the range of dgf fgl product dtlses
	 * @param end the upper bound of the range of dgf fgl product dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf fgl product dtlses
	 */
	public static List<DgfFglProductDtls> findBydgfFglProductDtlsByNationalId(
		String nationalId, int start, int end,
		OrderByComparator<DgfFglProductDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydgfFglProductDtlsByNationalId(
			nationalId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf fgl product dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl product dtls
	 * @throws NoSuchDgfFglProductDtlsException if a matching dgf fgl product dtls could not be found
	 */
	public static DgfFglProductDtls findBydgfFglProductDtlsByNationalId_First(
			String nationalId,
			OrderByComparator<DgfFglProductDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglProductDtlsException {

		return getPersistence().findBydgfFglProductDtlsByNationalId_First(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the first dgf fgl product dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf fgl product dtls, or <code>null</code> if a matching dgf fgl product dtls could not be found
	 */
	public static DgfFglProductDtls fetchBydgfFglProductDtlsByNationalId_First(
		String nationalId,
		OrderByComparator<DgfFglProductDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglProductDtlsByNationalId_First(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl product dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl product dtls
	 * @throws NoSuchDgfFglProductDtlsException if a matching dgf fgl product dtls could not be found
	 */
	public static DgfFglProductDtls findBydgfFglProductDtlsByNationalId_Last(
			String nationalId,
			OrderByComparator<DgfFglProductDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglProductDtlsException {

		return getPersistence().findBydgfFglProductDtlsByNationalId_Last(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the last dgf fgl product dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf fgl product dtls, or <code>null</code> if a matching dgf fgl product dtls could not be found
	 */
	public static DgfFglProductDtls fetchBydgfFglProductDtlsByNationalId_Last(
		String nationalId,
		OrderByComparator<DgfFglProductDtls> orderByComparator) {

		return getPersistence().fetchBydgfFglProductDtlsByNationalId_Last(
			nationalId, orderByComparator);
	}

	/**
	 * Returns the dgf fgl product dtlses before and after the current dgf fgl product dtls in the ordered set where nationalId = &#63;.
	 *
	 * @param fglProductPrimaryId the primary key of the current dgf fgl product dtls
	 * @param nationalId the national ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf fgl product dtls
	 * @throws NoSuchDgfFglProductDtlsException if a dgf fgl product dtls with the primary key could not be found
	 */
	public static DgfFglProductDtls[]
			findBydgfFglProductDtlsByNationalId_PrevAndNext(
				long fglProductPrimaryId, String nationalId,
				OrderByComparator<DgfFglProductDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglProductDtlsException {

		return getPersistence().findBydgfFglProductDtlsByNationalId_PrevAndNext(
			fglProductPrimaryId, nationalId, orderByComparator);
	}

	/**
	 * Removes all the dgf fgl product dtlses where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 */
	public static void removeBydgfFglProductDtlsByNationalId(
		String nationalId) {

		getPersistence().removeBydgfFglProductDtlsByNationalId(nationalId);
	}

	/**
	 * Returns the number of dgf fgl product dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf fgl product dtlses
	 */
	public static int countBydgfFglProductDtlsByNationalId(String nationalId) {
		return getPersistence().countBydgfFglProductDtlsByNationalId(
			nationalId);
	}

	/**
	 * Caches the dgf fgl product dtls in the entity cache if it is enabled.
	 *
	 * @param dgfFglProductDtls the dgf fgl product dtls
	 */
	public static void cacheResult(DgfFglProductDtls dgfFglProductDtls) {
		getPersistence().cacheResult(dgfFglProductDtls);
	}

	/**
	 * Caches the dgf fgl product dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfFglProductDtlses the dgf fgl product dtlses
	 */
	public static void cacheResult(
		List<DgfFglProductDtls> dgfFglProductDtlses) {

		getPersistence().cacheResult(dgfFglProductDtlses);
	}

	/**
	 * Creates a new dgf fgl product dtls with the primary key. Does not add the dgf fgl product dtls to the database.
	 *
	 * @param fglProductPrimaryId the primary key for the new dgf fgl product dtls
	 * @return the new dgf fgl product dtls
	 */
	public static DgfFglProductDtls create(long fglProductPrimaryId) {
		return getPersistence().create(fglProductPrimaryId);
	}

	/**
	 * Removes the dgf fgl product dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fglProductPrimaryId the primary key of the dgf fgl product dtls
	 * @return the dgf fgl product dtls that was removed
	 * @throws NoSuchDgfFglProductDtlsException if a dgf fgl product dtls with the primary key could not be found
	 */
	public static DgfFglProductDtls remove(long fglProductPrimaryId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglProductDtlsException {

		return getPersistence().remove(fglProductPrimaryId);
	}

	public static DgfFglProductDtls updateImpl(
		DgfFglProductDtls dgfFglProductDtls) {

		return getPersistence().updateImpl(dgfFglProductDtls);
	}

	/**
	 * Returns the dgf fgl product dtls with the primary key or throws a <code>NoSuchDgfFglProductDtlsException</code> if it could not be found.
	 *
	 * @param fglProductPrimaryId the primary key of the dgf fgl product dtls
	 * @return the dgf fgl product dtls
	 * @throws NoSuchDgfFglProductDtlsException if a dgf fgl product dtls with the primary key could not be found
	 */
	public static DgfFglProductDtls findByPrimaryKey(long fglProductPrimaryId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfFglProductDtlsException {

		return getPersistence().findByPrimaryKey(fglProductPrimaryId);
	}

	/**
	 * Returns the dgf fgl product dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fglProductPrimaryId the primary key of the dgf fgl product dtls
	 * @return the dgf fgl product dtls, or <code>null</code> if a dgf fgl product dtls with the primary key could not be found
	 */
	public static DgfFglProductDtls fetchByPrimaryKey(
		long fglProductPrimaryId) {

		return getPersistence().fetchByPrimaryKey(fglProductPrimaryId);
	}

	/**
	 * Returns all the dgf fgl product dtlses.
	 *
	 * @return the dgf fgl product dtlses
	 */
	public static List<DgfFglProductDtls> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dgf fgl product dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglProductDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl product dtlses
	 * @param end the upper bound of the range of dgf fgl product dtlses (not inclusive)
	 * @return the range of dgf fgl product dtlses
	 */
	public static List<DgfFglProductDtls> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dgf fgl product dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglProductDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl product dtlses
	 * @param end the upper bound of the range of dgf fgl product dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf fgl product dtlses
	 */
	public static List<DgfFglProductDtls> findAll(
		int start, int end,
		OrderByComparator<DgfFglProductDtls> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf fgl product dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfFglProductDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf fgl product dtlses
	 * @param end the upper bound of the range of dgf fgl product dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf fgl product dtlses
	 */
	public static List<DgfFglProductDtls> findAll(
		int start, int end,
		OrderByComparator<DgfFglProductDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dgf fgl product dtlses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dgf fgl product dtlses.
	 *
	 * @return the number of dgf fgl product dtlses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DgfFglProductDtlsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DgfFglProductDtlsPersistence _persistence;

}