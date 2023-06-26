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

import bd.gov.dgfood.food.grain.license.model.DgfUsersAddrDtls;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the dgf users addr dtls service. This utility wraps <code>bd.gov.dgfood.food.grain.license.service.persistence.impl.DgfUsersAddrDtlsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DgfUsersAddrDtlsPersistence
 * @generated
 */
public class DgfUsersAddrDtlsUtil {

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
	public static void clearCache(DgfUsersAddrDtls dgfUsersAddrDtls) {
		getPersistence().clearCache(dgfUsersAddrDtls);
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
	public static Map<Serializable, DgfUsersAddrDtls> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DgfUsersAddrDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DgfUsersAddrDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DgfUsersAddrDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DgfUsersAddrDtls update(DgfUsersAddrDtls dgfUsersAddrDtls) {
		return getPersistence().update(dgfUsersAddrDtls);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DgfUsersAddrDtls update(
		DgfUsersAddrDtls dgfUsersAddrDtls, ServiceContext serviceContext) {

		return getPersistence().update(dgfUsersAddrDtls, serviceContext);
	}

	/**
	 * Returns the dgf users addr dtls where nationalId = &#63; or throws a <code>NoSuchDgfUsersAddrDtlsException</code> if it could not be found.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	public static DgfUsersAddrDtls findBydgfUsersAddrDtlsByNationalId(
			long nationalId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersAddrDtlsException {

		return getPersistence().findBydgfUsersAddrDtlsByNationalId(nationalId);
	}

	/**
	 * Returns the dgf users addr dtls where nationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nationalId the national ID
	 * @return the matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	public static DgfUsersAddrDtls fetchBydgfUsersAddrDtlsByNationalId(
		long nationalId) {

		return getPersistence().fetchBydgfUsersAddrDtlsByNationalId(nationalId);
	}

	/**
	 * Returns the dgf users addr dtls where nationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nationalId the national ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	public static DgfUsersAddrDtls fetchBydgfUsersAddrDtlsByNationalId(
		long nationalId, boolean useFinderCache) {

		return getPersistence().fetchBydgfUsersAddrDtlsByNationalId(
			nationalId, useFinderCache);
	}

	/**
	 * Removes the dgf users addr dtls where nationalId = &#63; from the database.
	 *
	 * @param nationalId the national ID
	 * @return the dgf users addr dtls that was removed
	 */
	public static DgfUsersAddrDtls removeBydgfUsersAddrDtlsByNationalId(
			long nationalId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersAddrDtlsException {

		return getPersistence().removeBydgfUsersAddrDtlsByNationalId(
			nationalId);
	}

	/**
	 * Returns the number of dgf users addr dtlses where nationalId = &#63;.
	 *
	 * @param nationalId the national ID
	 * @return the number of matching dgf users addr dtlses
	 */
	public static int countBydgfUsersAddrDtlsByNationalId(long nationalId) {
		return getPersistence().countBydgfUsersAddrDtlsByNationalId(nationalId);
	}

	/**
	 * Returns all the dgf users addr dtlses where district = &#63;.
	 *
	 * @param district the district
	 * @return the matching dgf users addr dtlses
	 */
	public static List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByDistrict(
		long district) {

		return getPersistence().findBydgfUsersAddrDtlsByDistrict(district);
	}

	/**
	 * Returns a range of all the dgf users addr dtlses where district = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param district the district
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @return the range of matching dgf users addr dtlses
	 */
	public static List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByDistrict(
		long district, int start, int end) {

		return getPersistence().findBydgfUsersAddrDtlsByDistrict(
			district, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where district = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param district the district
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	public static List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByDistrict(
		long district, int start, int end,
		OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		return getPersistence().findBydgfUsersAddrDtlsByDistrict(
			district, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where district = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param district the district
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	public static List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByDistrict(
		long district, int start, int end,
		OrderByComparator<DgfUsersAddrDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydgfUsersAddrDtlsByDistrict(
			district, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf users addr dtls in the ordered set where district = &#63;.
	 *
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	public static DgfUsersAddrDtls findBydgfUsersAddrDtlsByDistrict_First(
			long district,
			OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersAddrDtlsException {

		return getPersistence().findBydgfUsersAddrDtlsByDistrict_First(
			district, orderByComparator);
	}

	/**
	 * Returns the first dgf users addr dtls in the ordered set where district = &#63;.
	 *
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	public static DgfUsersAddrDtls fetchBydgfUsersAddrDtlsByDistrict_First(
		long district, OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		return getPersistence().fetchBydgfUsersAddrDtlsByDistrict_First(
			district, orderByComparator);
	}

	/**
	 * Returns the last dgf users addr dtls in the ordered set where district = &#63;.
	 *
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	public static DgfUsersAddrDtls findBydgfUsersAddrDtlsByDistrict_Last(
			long district,
			OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersAddrDtlsException {

		return getPersistence().findBydgfUsersAddrDtlsByDistrict_Last(
			district, orderByComparator);
	}

	/**
	 * Returns the last dgf users addr dtls in the ordered set where district = &#63;.
	 *
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	public static DgfUsersAddrDtls fetchBydgfUsersAddrDtlsByDistrict_Last(
		long district, OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		return getPersistence().fetchBydgfUsersAddrDtlsByDistrict_Last(
			district, orderByComparator);
	}

	/**
	 * Returns the dgf users addr dtlses before and after the current dgf users addr dtls in the ordered set where district = &#63;.
	 *
	 * @param addressId the primary key of the current dgf users addr dtls
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a dgf users addr dtls with the primary key could not be found
	 */
	public static DgfUsersAddrDtls[]
			findBydgfUsersAddrDtlsByDistrict_PrevAndNext(
				long addressId, long district,
				OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersAddrDtlsException {

		return getPersistence().findBydgfUsersAddrDtlsByDistrict_PrevAndNext(
			addressId, district, orderByComparator);
	}

	/**
	 * Removes all the dgf users addr dtlses where district = &#63; from the database.
	 *
	 * @param district the district
	 */
	public static void removeBydgfUsersAddrDtlsByDistrict(long district) {
		getPersistence().removeBydgfUsersAddrDtlsByDistrict(district);
	}

	/**
	 * Returns the number of dgf users addr dtlses where district = &#63;.
	 *
	 * @param district the district
	 * @return the number of matching dgf users addr dtlses
	 */
	public static int countBydgfUsersAddrDtlsByDistrict(long district) {
		return getPersistence().countBydgfUsersAddrDtlsByDistrict(district);
	}

	/**
	 * Returns all the dgf users addr dtlses where upzilla = &#63;.
	 *
	 * @param upzilla the upzilla
	 * @return the matching dgf users addr dtlses
	 */
	public static List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByUpzilla(
		long upzilla) {

		return getPersistence().findBydgfUsersAddrDtlsByUpzilla(upzilla);
	}

	/**
	 * Returns a range of all the dgf users addr dtlses where upzilla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param upzilla the upzilla
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @return the range of matching dgf users addr dtlses
	 */
	public static List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByUpzilla(
		long upzilla, int start, int end) {

		return getPersistence().findBydgfUsersAddrDtlsByUpzilla(
			upzilla, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where upzilla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param upzilla the upzilla
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	public static List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByUpzilla(
		long upzilla, int start, int end,
		OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		return getPersistence().findBydgfUsersAddrDtlsByUpzilla(
			upzilla, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where upzilla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param upzilla the upzilla
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	public static List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByUpzilla(
		long upzilla, int start, int end,
		OrderByComparator<DgfUsersAddrDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydgfUsersAddrDtlsByUpzilla(
			upzilla, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf users addr dtls in the ordered set where upzilla = &#63;.
	 *
	 * @param upzilla the upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	public static DgfUsersAddrDtls findBydgfUsersAddrDtlsByUpzilla_First(
			long upzilla, OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersAddrDtlsException {

		return getPersistence().findBydgfUsersAddrDtlsByUpzilla_First(
			upzilla, orderByComparator);
	}

	/**
	 * Returns the first dgf users addr dtls in the ordered set where upzilla = &#63;.
	 *
	 * @param upzilla the upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	public static DgfUsersAddrDtls fetchBydgfUsersAddrDtlsByUpzilla_First(
		long upzilla, OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		return getPersistence().fetchBydgfUsersAddrDtlsByUpzilla_First(
			upzilla, orderByComparator);
	}

	/**
	 * Returns the last dgf users addr dtls in the ordered set where upzilla = &#63;.
	 *
	 * @param upzilla the upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	public static DgfUsersAddrDtls findBydgfUsersAddrDtlsByUpzilla_Last(
			long upzilla, OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersAddrDtlsException {

		return getPersistence().findBydgfUsersAddrDtlsByUpzilla_Last(
			upzilla, orderByComparator);
	}

	/**
	 * Returns the last dgf users addr dtls in the ordered set where upzilla = &#63;.
	 *
	 * @param upzilla the upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	public static DgfUsersAddrDtls fetchBydgfUsersAddrDtlsByUpzilla_Last(
		long upzilla, OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		return getPersistence().fetchBydgfUsersAddrDtlsByUpzilla_Last(
			upzilla, orderByComparator);
	}

	/**
	 * Returns the dgf users addr dtlses before and after the current dgf users addr dtls in the ordered set where upzilla = &#63;.
	 *
	 * @param addressId the primary key of the current dgf users addr dtls
	 * @param upzilla the upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a dgf users addr dtls with the primary key could not be found
	 */
	public static DgfUsersAddrDtls[]
			findBydgfUsersAddrDtlsByUpzilla_PrevAndNext(
				long addressId, long upzilla,
				OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersAddrDtlsException {

		return getPersistence().findBydgfUsersAddrDtlsByUpzilla_PrevAndNext(
			addressId, upzilla, orderByComparator);
	}

	/**
	 * Removes all the dgf users addr dtlses where upzilla = &#63; from the database.
	 *
	 * @param upzilla the upzilla
	 */
	public static void removeBydgfUsersAddrDtlsByUpzilla(long upzilla) {
		getPersistence().removeBydgfUsersAddrDtlsByUpzilla(upzilla);
	}

	/**
	 * Returns the number of dgf users addr dtlses where upzilla = &#63;.
	 *
	 * @param upzilla the upzilla
	 * @return the number of matching dgf users addr dtlses
	 */
	public static int countBydgfUsersAddrDtlsByUpzilla(long upzilla) {
		return getPersistence().countBydgfUsersAddrDtlsByUpzilla(upzilla);
	}

	/**
	 * Returns all the dgf users addr dtlses where unionName = &#63;.
	 *
	 * @param unionName the union name
	 * @return the matching dgf users addr dtlses
	 */
	public static List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByUnion(
		long unionName) {

		return getPersistence().findBydgfUsersAddrDtlsByUnion(unionName);
	}

	/**
	 * Returns a range of all the dgf users addr dtlses where unionName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param unionName the union name
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @return the range of matching dgf users addr dtlses
	 */
	public static List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByUnion(
		long unionName, int start, int end) {

		return getPersistence().findBydgfUsersAddrDtlsByUnion(
			unionName, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where unionName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param unionName the union name
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	public static List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByUnion(
		long unionName, int start, int end,
		OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		return getPersistence().findBydgfUsersAddrDtlsByUnion(
			unionName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where unionName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param unionName the union name
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	public static List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByUnion(
		long unionName, int start, int end,
		OrderByComparator<DgfUsersAddrDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydgfUsersAddrDtlsByUnion(
			unionName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf users addr dtls in the ordered set where unionName = &#63;.
	 *
	 * @param unionName the union name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	public static DgfUsersAddrDtls findBydgfUsersAddrDtlsByUnion_First(
			long unionName,
			OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersAddrDtlsException {

		return getPersistence().findBydgfUsersAddrDtlsByUnion_First(
			unionName, orderByComparator);
	}

	/**
	 * Returns the first dgf users addr dtls in the ordered set where unionName = &#63;.
	 *
	 * @param unionName the union name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	public static DgfUsersAddrDtls fetchBydgfUsersAddrDtlsByUnion_First(
		long unionName, OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		return getPersistence().fetchBydgfUsersAddrDtlsByUnion_First(
			unionName, orderByComparator);
	}

	/**
	 * Returns the last dgf users addr dtls in the ordered set where unionName = &#63;.
	 *
	 * @param unionName the union name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	public static DgfUsersAddrDtls findBydgfUsersAddrDtlsByUnion_Last(
			long unionName,
			OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersAddrDtlsException {

		return getPersistence().findBydgfUsersAddrDtlsByUnion_Last(
			unionName, orderByComparator);
	}

	/**
	 * Returns the last dgf users addr dtls in the ordered set where unionName = &#63;.
	 *
	 * @param unionName the union name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	public static DgfUsersAddrDtls fetchBydgfUsersAddrDtlsByUnion_Last(
		long unionName, OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		return getPersistence().fetchBydgfUsersAddrDtlsByUnion_Last(
			unionName, orderByComparator);
	}

	/**
	 * Returns the dgf users addr dtlses before and after the current dgf users addr dtls in the ordered set where unionName = &#63;.
	 *
	 * @param addressId the primary key of the current dgf users addr dtls
	 * @param unionName the union name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a dgf users addr dtls with the primary key could not be found
	 */
	public static DgfUsersAddrDtls[] findBydgfUsersAddrDtlsByUnion_PrevAndNext(
			long addressId, long unionName,
			OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersAddrDtlsException {

		return getPersistence().findBydgfUsersAddrDtlsByUnion_PrevAndNext(
			addressId, unionName, orderByComparator);
	}

	/**
	 * Removes all the dgf users addr dtlses where unionName = &#63; from the database.
	 *
	 * @param unionName the union name
	 */
	public static void removeBydgfUsersAddrDtlsByUnion(long unionName) {
		getPersistence().removeBydgfUsersAddrDtlsByUnion(unionName);
	}

	/**
	 * Returns the number of dgf users addr dtlses where unionName = &#63;.
	 *
	 * @param unionName the union name
	 * @return the number of matching dgf users addr dtlses
	 */
	public static int countBydgfUsersAddrDtlsByUnion(long unionName) {
		return getPersistence().countBydgfUsersAddrDtlsByUnion(unionName);
	}

	/**
	 * Returns all the dgf users addr dtlses where ward = &#63;.
	 *
	 * @param ward the ward
	 * @return the matching dgf users addr dtlses
	 */
	public static List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByWard(
		String ward) {

		return getPersistence().findBydgfUsersAddrDtlsByWard(ward);
	}

	/**
	 * Returns a range of all the dgf users addr dtlses where ward = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param ward the ward
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @return the range of matching dgf users addr dtlses
	 */
	public static List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByWard(
		String ward, int start, int end) {

		return getPersistence().findBydgfUsersAddrDtlsByWard(ward, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where ward = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param ward the ward
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	public static List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByWard(
		String ward, int start, int end,
		OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		return getPersistence().findBydgfUsersAddrDtlsByWard(
			ward, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where ward = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param ward the ward
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	public static List<DgfUsersAddrDtls> findBydgfUsersAddrDtlsByWard(
		String ward, int start, int end,
		OrderByComparator<DgfUsersAddrDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydgfUsersAddrDtlsByWard(
			ward, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf users addr dtls in the ordered set where ward = &#63;.
	 *
	 * @param ward the ward
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	public static DgfUsersAddrDtls findBydgfUsersAddrDtlsByWard_First(
			String ward, OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersAddrDtlsException {

		return getPersistence().findBydgfUsersAddrDtlsByWard_First(
			ward, orderByComparator);
	}

	/**
	 * Returns the first dgf users addr dtls in the ordered set where ward = &#63;.
	 *
	 * @param ward the ward
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	public static DgfUsersAddrDtls fetchBydgfUsersAddrDtlsByWard_First(
		String ward, OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		return getPersistence().fetchBydgfUsersAddrDtlsByWard_First(
			ward, orderByComparator);
	}

	/**
	 * Returns the last dgf users addr dtls in the ordered set where ward = &#63;.
	 *
	 * @param ward the ward
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	public static DgfUsersAddrDtls findBydgfUsersAddrDtlsByWard_Last(
			String ward, OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersAddrDtlsException {

		return getPersistence().findBydgfUsersAddrDtlsByWard_Last(
			ward, orderByComparator);
	}

	/**
	 * Returns the last dgf users addr dtls in the ordered set where ward = &#63;.
	 *
	 * @param ward the ward
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	public static DgfUsersAddrDtls fetchBydgfUsersAddrDtlsByWard_Last(
		String ward, OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		return getPersistence().fetchBydgfUsersAddrDtlsByWard_Last(
			ward, orderByComparator);
	}

	/**
	 * Returns the dgf users addr dtlses before and after the current dgf users addr dtls in the ordered set where ward = &#63;.
	 *
	 * @param addressId the primary key of the current dgf users addr dtls
	 * @param ward the ward
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a dgf users addr dtls with the primary key could not be found
	 */
	public static DgfUsersAddrDtls[] findBydgfUsersAddrDtlsByWard_PrevAndNext(
			long addressId, String ward,
			OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersAddrDtlsException {

		return getPersistence().findBydgfUsersAddrDtlsByWard_PrevAndNext(
			addressId, ward, orderByComparator);
	}

	/**
	 * Removes all the dgf users addr dtlses where ward = &#63; from the database.
	 *
	 * @param ward the ward
	 */
	public static void removeBydgfUsersAddrDtlsByWard(String ward) {
		getPersistence().removeBydgfUsersAddrDtlsByWard(ward);
	}

	/**
	 * Returns the number of dgf users addr dtlses where ward = &#63;.
	 *
	 * @param ward the ward
	 * @return the number of matching dgf users addr dtlses
	 */
	public static int countBydgfUsersAddrDtlsByWard(String ward) {
		return getPersistence().countBydgfUsersAddrDtlsByWard(ward);
	}

	/**
	 * Returns all the dgf users addr dtlses where division = &#63; and district = &#63; and upzilla = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 * @return the matching dgf users addr dtlses
	 */
	public static List<DgfUsersAddrDtls>
		findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
			long division, long district, long upzilla) {

		return getPersistence().
			findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
				division, district, upzilla);
	}

	/**
	 * Returns a range of all the dgf users addr dtlses where division = &#63; and district = &#63; and upzilla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @return the range of matching dgf users addr dtlses
	 */
	public static List<DgfUsersAddrDtls>
		findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
			long division, long district, long upzilla, int start, int end) {

		return getPersistence().
			findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
				division, district, upzilla, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where division = &#63; and district = &#63; and upzilla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	public static List<DgfUsersAddrDtls>
		findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
			long division, long district, long upzilla, int start, int end,
			OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		return getPersistence().
			findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
				division, district, upzilla, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where division = &#63; and district = &#63; and upzilla = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	public static List<DgfUsersAddrDtls>
		findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
			long division, long district, long upzilla, int start, int end,
			OrderByComparator<DgfUsersAddrDtls> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().
			findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
				division, district, upzilla, start, end, orderByComparator,
				useFinderCache);
	}

	/**
	 * Returns the first dgf users addr dtls in the ordered set where division = &#63; and district = &#63; and upzilla = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	public static DgfUsersAddrDtls
			findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla_First(
				long division, long district, long upzilla,
				OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersAddrDtlsException {

		return getPersistence().
			findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla_First(
				division, district, upzilla, orderByComparator);
	}

	/**
	 * Returns the first dgf users addr dtls in the ordered set where division = &#63; and district = &#63; and upzilla = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	public static DgfUsersAddrDtls
		fetchByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla_First(
			long division, long district, long upzilla,
			OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		return getPersistence().
			fetchByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla_First(
				division, district, upzilla, orderByComparator);
	}

	/**
	 * Returns the last dgf users addr dtls in the ordered set where division = &#63; and district = &#63; and upzilla = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	public static DgfUsersAddrDtls
			findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla_Last(
				long division, long district, long upzilla,
				OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersAddrDtlsException {

		return getPersistence().
			findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla_Last(
				division, district, upzilla, orderByComparator);
	}

	/**
	 * Returns the last dgf users addr dtls in the ordered set where division = &#63; and district = &#63; and upzilla = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	public static DgfUsersAddrDtls
		fetchByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla_Last(
			long division, long district, long upzilla,
			OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		return getPersistence().
			fetchByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla_Last(
				division, district, upzilla, orderByComparator);
	}

	/**
	 * Returns the dgf users addr dtlses before and after the current dgf users addr dtls in the ordered set where division = &#63; and district = &#63; and upzilla = &#63;.
	 *
	 * @param addressId the primary key of the current dgf users addr dtls
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a dgf users addr dtls with the primary key could not be found
	 */
	public static DgfUsersAddrDtls[]
			findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla_PrevAndNext(
				long addressId, long division, long district, long upzilla,
				OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersAddrDtlsException {

		return getPersistence().
			findByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla_PrevAndNext(
				addressId, division, district, upzilla, orderByComparator);
	}

	/**
	 * Removes all the dgf users addr dtlses where division = &#63; and district = &#63; and upzilla = &#63; from the database.
	 *
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 */
	public static void removeByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
		long division, long district, long upzilla) {

		getPersistence().
			removeByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
				division, district, upzilla);
	}

	/**
	 * Returns the number of dgf users addr dtlses where division = &#63; and district = &#63; and upzilla = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @param upzilla the upzilla
	 * @return the number of matching dgf users addr dtlses
	 */
	public static int countByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
		long division, long district, long upzilla) {

		return getPersistence().
			countByDgfUsersAddrDtlsByDivisionAndDistrictAndUpzilla(
				division, district, upzilla);
	}

	/**
	 * Returns all the dgf users addr dtlses where division = &#63; and district = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @return the matching dgf users addr dtlses
	 */
	public static List<DgfUsersAddrDtls>
		findByDgfUsersAddrDtlsByDivisionAndDistrict(
			long division, long district) {

		return getPersistence().findByDgfUsersAddrDtlsByDivisionAndDistrict(
			division, district);
	}

	/**
	 * Returns a range of all the dgf users addr dtlses where division = &#63; and district = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param division the division
	 * @param district the district
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @return the range of matching dgf users addr dtlses
	 */
	public static List<DgfUsersAddrDtls>
		findByDgfUsersAddrDtlsByDivisionAndDistrict(
			long division, long district, int start, int end) {

		return getPersistence().findByDgfUsersAddrDtlsByDivisionAndDistrict(
			division, district, start, end);
	}

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where division = &#63; and district = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param division the division
	 * @param district the district
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	public static List<DgfUsersAddrDtls>
		findByDgfUsersAddrDtlsByDivisionAndDistrict(
			long division, long district, int start, int end,
			OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		return getPersistence().findByDgfUsersAddrDtlsByDivisionAndDistrict(
			division, district, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf users addr dtlses where division = &#63; and district = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param division the division
	 * @param district the district
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dgf users addr dtlses
	 */
	public static List<DgfUsersAddrDtls>
		findByDgfUsersAddrDtlsByDivisionAndDistrict(
			long division, long district, int start, int end,
			OrderByComparator<DgfUsersAddrDtls> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByDgfUsersAddrDtlsByDivisionAndDistrict(
			division, district, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dgf users addr dtls in the ordered set where division = &#63; and district = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	public static DgfUsersAddrDtls
			findByDgfUsersAddrDtlsByDivisionAndDistrict_First(
				long division, long district,
				OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersAddrDtlsException {

		return getPersistence().
			findByDgfUsersAddrDtlsByDivisionAndDistrict_First(
				division, district, orderByComparator);
	}

	/**
	 * Returns the first dgf users addr dtls in the ordered set where division = &#63; and district = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	public static DgfUsersAddrDtls
		fetchByDgfUsersAddrDtlsByDivisionAndDistrict_First(
			long division, long district,
			OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		return getPersistence().
			fetchByDgfUsersAddrDtlsByDivisionAndDistrict_First(
				division, district, orderByComparator);
	}

	/**
	 * Returns the last dgf users addr dtls in the ordered set where division = &#63; and district = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a matching dgf users addr dtls could not be found
	 */
	public static DgfUsersAddrDtls
			findByDgfUsersAddrDtlsByDivisionAndDistrict_Last(
				long division, long district,
				OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersAddrDtlsException {

		return getPersistence().
			findByDgfUsersAddrDtlsByDivisionAndDistrict_Last(
				division, district, orderByComparator);
	}

	/**
	 * Returns the last dgf users addr dtls in the ordered set where division = &#63; and district = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dgf users addr dtls, or <code>null</code> if a matching dgf users addr dtls could not be found
	 */
	public static DgfUsersAddrDtls
		fetchByDgfUsersAddrDtlsByDivisionAndDistrict_Last(
			long division, long district,
			OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		return getPersistence().
			fetchByDgfUsersAddrDtlsByDivisionAndDistrict_Last(
				division, district, orderByComparator);
	}

	/**
	 * Returns the dgf users addr dtlses before and after the current dgf users addr dtls in the ordered set where division = &#63; and district = &#63;.
	 *
	 * @param addressId the primary key of the current dgf users addr dtls
	 * @param division the division
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a dgf users addr dtls with the primary key could not be found
	 */
	public static DgfUsersAddrDtls[]
			findByDgfUsersAddrDtlsByDivisionAndDistrict_PrevAndNext(
				long addressId, long division, long district,
				OrderByComparator<DgfUsersAddrDtls> orderByComparator)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersAddrDtlsException {

		return getPersistence().
			findByDgfUsersAddrDtlsByDivisionAndDistrict_PrevAndNext(
				addressId, division, district, orderByComparator);
	}

	/**
	 * Removes all the dgf users addr dtlses where division = &#63; and district = &#63; from the database.
	 *
	 * @param division the division
	 * @param district the district
	 */
	public static void removeByDgfUsersAddrDtlsByDivisionAndDistrict(
		long division, long district) {

		getPersistence().removeByDgfUsersAddrDtlsByDivisionAndDistrict(
			division, district);
	}

	/**
	 * Returns the number of dgf users addr dtlses where division = &#63; and district = &#63;.
	 *
	 * @param division the division
	 * @param district the district
	 * @return the number of matching dgf users addr dtlses
	 */
	public static int countByDgfUsersAddrDtlsByDivisionAndDistrict(
		long division, long district) {

		return getPersistence().countByDgfUsersAddrDtlsByDivisionAndDistrict(
			division, district);
	}

	/**
	 * Caches the dgf users addr dtls in the entity cache if it is enabled.
	 *
	 * @param dgfUsersAddrDtls the dgf users addr dtls
	 */
	public static void cacheResult(DgfUsersAddrDtls dgfUsersAddrDtls) {
		getPersistence().cacheResult(dgfUsersAddrDtls);
	}

	/**
	 * Caches the dgf users addr dtlses in the entity cache if it is enabled.
	 *
	 * @param dgfUsersAddrDtlses the dgf users addr dtlses
	 */
	public static void cacheResult(List<DgfUsersAddrDtls> dgfUsersAddrDtlses) {
		getPersistence().cacheResult(dgfUsersAddrDtlses);
	}

	/**
	 * Creates a new dgf users addr dtls with the primary key. Does not add the dgf users addr dtls to the database.
	 *
	 * @param addressId the primary key for the new dgf users addr dtls
	 * @return the new dgf users addr dtls
	 */
	public static DgfUsersAddrDtls create(long addressId) {
		return getPersistence().create(addressId);
	}

	/**
	 * Removes the dgf users addr dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addressId the primary key of the dgf users addr dtls
	 * @return the dgf users addr dtls that was removed
	 * @throws NoSuchDgfUsersAddrDtlsException if a dgf users addr dtls with the primary key could not be found
	 */
	public static DgfUsersAddrDtls remove(long addressId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersAddrDtlsException {

		return getPersistence().remove(addressId);
	}

	public static DgfUsersAddrDtls updateImpl(
		DgfUsersAddrDtls dgfUsersAddrDtls) {

		return getPersistence().updateImpl(dgfUsersAddrDtls);
	}

	/**
	 * Returns the dgf users addr dtls with the primary key or throws a <code>NoSuchDgfUsersAddrDtlsException</code> if it could not be found.
	 *
	 * @param addressId the primary key of the dgf users addr dtls
	 * @return the dgf users addr dtls
	 * @throws NoSuchDgfUsersAddrDtlsException if a dgf users addr dtls with the primary key could not be found
	 */
	public static DgfUsersAddrDtls findByPrimaryKey(long addressId)
		throws bd.gov.dgfood.food.grain.license.exception.
			NoSuchDgfUsersAddrDtlsException {

		return getPersistence().findByPrimaryKey(addressId);
	}

	/**
	 * Returns the dgf users addr dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addressId the primary key of the dgf users addr dtls
	 * @return the dgf users addr dtls, or <code>null</code> if a dgf users addr dtls with the primary key could not be found
	 */
	public static DgfUsersAddrDtls fetchByPrimaryKey(long addressId) {
		return getPersistence().fetchByPrimaryKey(addressId);
	}

	/**
	 * Returns all the dgf users addr dtlses.
	 *
	 * @return the dgf users addr dtlses
	 */
	public static List<DgfUsersAddrDtls> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dgf users addr dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @return the range of dgf users addr dtlses
	 */
	public static List<DgfUsersAddrDtls> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dgf users addr dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dgf users addr dtlses
	 */
	public static List<DgfUsersAddrDtls> findAll(
		int start, int end,
		OrderByComparator<DgfUsersAddrDtls> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dgf users addr dtlses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DgfUsersAddrDtlsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dgf users addr dtlses
	 * @param end the upper bound of the range of dgf users addr dtlses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dgf users addr dtlses
	 */
	public static List<DgfUsersAddrDtls> findAll(
		int start, int end,
		OrderByComparator<DgfUsersAddrDtls> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dgf users addr dtlses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dgf users addr dtlses.
	 *
	 * @return the number of dgf users addr dtlses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DgfUsersAddrDtlsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DgfUsersAddrDtlsPersistence _persistence;

}